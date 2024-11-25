package com.sun.mail.smtp;

import com.sun.mail.util.ASCIIUtility;
import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.MailLogger;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Level;
import kotlin.UByte;
/* loaded from: classes2.dex */
public class DigestMD5 {
    private static char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private String clientResponse;
    private MailLogger logger;
    private MessageDigest md5;
    private String uri;

    public DigestMD5(MailLogger mailLogger) {
        this.logger = mailLogger.getLogger(getClass(), "DEBUG DIGEST-MD5");
        mailLogger.config("DIGEST-MD5 Loaded");
    }

    public byte[] authClient(String str, String str2, String str3, String str4, String str5) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        BASE64EncoderStream bASE64EncoderStream = new BASE64EncoderStream(byteArrayOutputStream, Integer.MAX_VALUE);
        try {
            SecureRandom secureRandom = new SecureRandom();
            this.md5 = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            this.uri = "smtp/" + str;
            byte[] bArr = new byte[32];
            this.logger.fine("Begin authentication ...");
            Map<String, String> map = tokenize(str5);
            if (str4 == null) {
                String str6 = map.get("realm");
                if (str6 != null) {
                    str = new StringTokenizer(str6, ",").nextToken();
                }
                str4 = str;
            }
            String str7 = map.get("nonce");
            String str8 = map.get("charset");
            boolean z = str8 != null && str8.equalsIgnoreCase("utf-8");
            secureRandom.nextBytes(bArr);
            bASE64EncoderStream.write(bArr);
            bASE64EncoderStream.flush();
            String byteArrayOutputStream2 = byteArrayOutputStream.toString("iso-8859-1");
            byteArrayOutputStream.reset();
            if (z) {
                MessageDigest messageDigest = this.md5;
                messageDigest.update(messageDigest.digest((str2 + ":" + str4 + ":" + str3).getBytes(StandardCharsets.UTF_8)));
            } else {
                MessageDigest messageDigest2 = this.md5;
                messageDigest2.update(messageDigest2.digest(ASCIIUtility.getBytes(str2 + ":" + str4 + ":" + str3)));
            }
            this.md5.update(ASCIIUtility.getBytes(":" + str7 + ":" + byteArrayOutputStream2));
            this.clientResponse = toHex(this.md5.digest()) + ":" + str7 + ":00000001:" + byteArrayOutputStream2 + ":auth:";
            MessageDigest messageDigest3 = this.md5;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("AUTHENTICATE:");
            sb2.append(this.uri);
            messageDigest3.update(ASCIIUtility.getBytes(sb2.toString()));
            MessageDigest messageDigest4 = this.md5;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(this.clientResponse);
            sb3.append(toHex(this.md5.digest()));
            messageDigest4.update(ASCIIUtility.getBytes(sb3.toString()));
            sb.append("username=\"" + str2 + "\"");
            sb.append(",realm=\"" + str4 + "\"");
            sb.append(",qop=auth");
            sb.append(",nc=00000001");
            sb.append(",nonce=\"" + str7 + "\"");
            sb.append(",cnonce=\"" + byteArrayOutputStream2 + "\"");
            sb.append(",digest-uri=\"" + this.uri + "\"");
            if (z) {
                sb.append(",charset=\"utf-8\"");
            }
            sb.append(",response=" + toHex(this.md5.digest()));
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("Response => " + sb.toString());
            }
            bASE64EncoderStream.write(ASCIIUtility.getBytes(sb.toString()));
            bASE64EncoderStream.flush();
            return byteArrayOutputStream.toByteArray();
        } catch (NoSuchAlgorithmException e) {
            this.logger.log(Level.FINE, "NoSuchAlgorithmException", (Throwable) e);
            throw new IOException(e.toString());
        }
    }

    public boolean authServer(String str) throws IOException {
        Map<String, String> map = tokenize(str);
        MessageDigest messageDigest = this.md5;
        messageDigest.update(ASCIIUtility.getBytes(":" + this.uri));
        MessageDigest messageDigest2 = this.md5;
        messageDigest2.update(ASCIIUtility.getBytes(this.clientResponse + toHex(this.md5.digest())));
        String hex = toHex(this.md5.digest());
        if (hex.equals(map.get("rspauth"))) {
            return true;
        }
        if (this.logger.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.logger;
            mailLogger.fine("Expected => rspauth=" + hex);
            return false;
        }
        return false;
    }

    private Map<String, String> tokenize(String str) throws IOException {
        HashMap hashMap = new HashMap();
        byte[] bytes = str.getBytes("iso-8859-1");
        StreamTokenizer streamTokenizer = new StreamTokenizer(new InputStreamReader(new BASE64DecoderStream(new ByteArrayInputStream(bytes, 4, bytes.length - 4)), "iso-8859-1"));
        streamTokenizer.ordinaryChars(48, 57);
        streamTokenizer.wordChars(48, 57);
        while (true) {
            String str2 = null;
            while (true) {
                int nextToken = streamTokenizer.nextToken();
                if (nextToken == -1) {
                    return hashMap;
                }
                if (nextToken == -3) {
                    if (str2 != null) {
                        break;
                    }
                    str2 = streamTokenizer.sval;
                } else if (nextToken == 34) {
                    break;
                }
            }
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("Received => " + str2 + "='" + streamTokenizer.sval + "'");
            }
            if (hashMap.containsKey(str2)) {
                hashMap.put(str2, ((String) hashMap.get(str2)) + "," + streamTokenizer.sval);
            } else {
                hashMap.put(str2, streamTokenizer.sval);
            }
        }
    }

    private static String toHex(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = b & UByte.MAX_VALUE;
            int i3 = i + 1;
            char[] cArr2 = digits;
            cArr[i] = cArr2[i2 >> 4];
            i = i3 + 1;
            cArr[i3] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }
}
