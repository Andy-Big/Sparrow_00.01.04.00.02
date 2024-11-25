package com.sun.mail.auth;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import com.sun.mail.util.MailLogger;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Random;
import java.util.logging.Level;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.SecretKeySpec;
import kotlin.UByte;
/* loaded from: classes2.dex */
public class Ntlm {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte HIRESPONSERVERSION = 1;
    private static final int NTLMSSP_NEGOTIATE_128 = 536870912;
    private static final int NTLMSSP_NEGOTIATE_56 = Integer.MIN_VALUE;
    private static final int NTLMSSP_NEGOTIATE_ALWAYS_SIGN = 32768;
    private static final int NTLMSSP_NEGOTIATE_DATAGRAM = 64;
    private static final int NTLMSSP_NEGOTIATE_EXTENDED_SESSIONSECURITY = 524288;
    private static final int NTLMSSP_NEGOTIATE_IDENTIFY = 1048576;
    private static final int NTLMSSP_NEGOTIATE_KEY_EXCH = 1073741824;
    private static final int NTLMSSP_NEGOTIATE_LM_KEY = 128;
    private static final int NTLMSSP_NEGOTIATE_NTLM = 512;
    private static final int NTLMSSP_NEGOTIATE_OEM = 2;
    private static final int NTLMSSP_NEGOTIATE_OEM_DOMAIN_SUPPLIED = 4096;
    private static final int NTLMSSP_NEGOTIATE_OEM_WORKSTATION_SUPPLIED = 8192;
    private static final int NTLMSSP_NEGOTIATE_SEAL = 32;
    private static final int NTLMSSP_NEGOTIATE_SIGN = 16;
    private static final int NTLMSSP_NEGOTIATE_TARGET_INFO = 8388608;
    private static final int NTLMSSP_NEGOTIATE_UNICODE = 1;
    private static final int NTLMSSP_NEGOTIATE_VERSION = 33554432;
    private static final int NTLMSSP_REQUEST_NON_NT_SESSION_KEY = 4194304;
    private static final int NTLMSSP_REQUEST_TARGET = 4;
    private static final int NTLMSSP_TARGET_TYPE_DOMAIN = 65536;
    private static final int NTLMSSP_TARGET_TYPE_SERVER = 131072;
    private static final byte RESPONSERVERSION = 1;
    private Cipher cipher;
    private SecretKeyFactory fac;
    private Mac hmac;
    private String hostname;
    private MailLogger logger;
    private MD4 md4;
    private String ntdomain;
    private String password;
    private byte[] type1;
    private byte[] type3;
    private String username;
    private static final byte[] Z6 = {0, 0, 0, 0, 0, 0};
    private static final byte[] Z4 = {0, 0, 0, 0};
    private static char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    private void init0() {
        byte[] bArr = new byte[256];
        this.type1 = bArr;
        this.type3 = new byte[512];
        System.arraycopy(new byte[]{78, 84, 76, 77, 83, 83, 80, 0, 1}, 0, bArr, 0, 9);
        System.arraycopy(new byte[]{78, 84, 76, 77, 83, 83, 80, 0, 3}, 0, this.type3, 0, 9);
        try {
            this.fac = SecretKeyFactory.getInstance("DES");
            this.cipher = Cipher.getInstance("DES/ECB/NoPadding");
            this.md4 = new MD4();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
        }
    }

    public Ntlm(String str, String str2, String str3, String str4, MailLogger mailLogger) {
        int indexOf = str2.indexOf(46);
        str2 = indexOf != -1 ? str2.substring(0, indexOf) : str2;
        int indexOf2 = str3.indexOf(92);
        if (indexOf2 != -1) {
            str = str3.substring(0, indexOf2).toUpperCase(Locale.ENGLISH);
            str3 = str3.substring(indexOf2 + 1);
        } else if (str == null) {
            str = "";
        }
        this.ntdomain = str;
        this.hostname = str2;
        this.username = str3;
        this.password = str4;
        this.logger = mailLogger.getLogger(getClass(), "DEBUG NTLM");
        init0();
    }

    private void copybytes(byte[] bArr, int i, String str, String str2) {
        try {
            byte[] bytes = str.getBytes(str2);
            System.arraycopy(bytes, 0, bArr, i, bytes.length);
        } catch (UnsupportedEncodingException unused) {
        }
    }

    public String generateType1Msg(int i) {
        return generateType1Msg(i, false);
    }

    public String generateType1Msg(int i, boolean z) {
        int length = this.ntdomain.length();
        int i2 = i | 41475;
        if (length != 0) {
            i2 |= 4096;
        }
        if (z) {
            i2 |= 524288;
        }
        writeInt(this.type1, 12, i2);
        byte[] bArr = this.type1;
        bArr[28] = 32;
        writeShort(bArr, 16, length);
        writeShort(this.type1, 18, length);
        int length2 = this.hostname.length();
        writeShort(this.type1, 24, length2);
        writeShort(this.type1, 26, length2);
        copybytes(this.type1, 32, this.hostname, "iso-8859-1");
        int i3 = length2 + 32;
        copybytes(this.type1, i3, this.ntdomain, "iso-8859-1");
        writeInt(this.type1, 20, i3);
        int i4 = i3 + length;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(this.type1, 0, bArr2, 0, i4);
        if (this.logger.isLoggable(Level.FINE)) {
            MailLogger mailLogger = this.logger;
            mailLogger.fine("type 1 message: " + toHex(bArr2));
        }
        try {
            return new String(BASE64EncoderStream.encode(bArr2), "iso-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private byte[] makeDesKey(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] < 0 ? bArr[i2] + 256 : bArr[i2];
        }
        int i3 = i + 0;
        int i4 = i + 1;
        int i5 = i + 2;
        int i6 = i + 3;
        int i7 = i + 4;
        int i8 = i + 5;
        int i9 = i + 6;
        return new byte[]{(byte) iArr[i3], (byte) (((iArr[i3] << 7) & 255) | (iArr[i4] >> 1)), (byte) (((iArr[i4] << 6) & 255) | (iArr[i5] >> 2)), (byte) (((iArr[i5] << 5) & 255) | (iArr[i6] >> 3)), (byte) (((iArr[i6] << 4) & 255) | (iArr[i7] >> 4)), (byte) (((iArr[i7] << 3) & 255) | (iArr[i8] >> 5)), (byte) (((iArr[i8] << 2) & 255) | (iArr[i9] >> 6)), (byte) ((iArr[i9] << 1) & 255)};
    }

    private byte[] hmacMD5(byte[] bArr, byte[] bArr2) {
        try {
            if (this.hmac == null) {
                this.hmac = Mac.getInstance("HmacMD5");
            }
            int i = 16;
            try {
                byte[] bArr3 = new byte[16];
                if (bArr.length <= 16) {
                    i = bArr.length;
                }
                System.arraycopy(bArr, 0, bArr3, 0, i);
                this.hmac.init(new SecretKeySpec(bArr3, "HmacMD5"));
                return this.hmac.doFinal(bArr2);
            } catch (RuntimeException | InvalidKeyException unused) {
                return null;
            }
        } catch (NoSuchAlgorithmException unused2) {
            throw new AssertionError();
        }
    }

    private byte[] calcLMHash() throws GeneralSecurityException {
        byte[] bArr;
        byte[] bArr2 = {75, 71, 83, 33, 64, 35, 36, 37};
        try {
            bArr = this.password.toUpperCase(Locale.ENGLISH).getBytes("iso-8859-1");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        byte[] bArr3 = new byte[14];
        int length = this.password.length();
        System.arraycopy(bArr, 0, bArr3, 0, length <= 14 ? length : 14);
        DESKeySpec dESKeySpec = new DESKeySpec(makeDesKey(bArr3, 0));
        DESKeySpec dESKeySpec2 = new DESKeySpec(makeDesKey(bArr3, 7));
        SecretKey generateSecret = this.fac.generateSecret(dESKeySpec);
        SecretKey generateSecret2 = this.fac.generateSecret(dESKeySpec2);
        this.cipher.init(1, generateSecret);
        byte[] doFinal = this.cipher.doFinal(bArr2, 0, 8);
        this.cipher.init(1, generateSecret2);
        byte[] doFinal2 = this.cipher.doFinal(bArr2, 0, 8);
        byte[] bArr4 = new byte[21];
        System.arraycopy(doFinal, 0, bArr4, 0, 8);
        System.arraycopy(doFinal2, 0, bArr4, 8, 8);
        return bArr4;
    }

    private byte[] calcNTHash() throws GeneralSecurityException {
        byte[] bArr;
        try {
            bArr = this.password.getBytes("UnicodeLittleUnmarked");
        } catch (UnsupportedEncodingException unused) {
            bArr = null;
        }
        byte[] bArr2 = new byte[21];
        System.arraycopy(this.md4.digest(bArr), 0, bArr2, 0, 16);
        return bArr2;
    }

    private byte[] calcResponse(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        DESKeySpec dESKeySpec = new DESKeySpec(makeDesKey(bArr, 0));
        DESKeySpec dESKeySpec2 = new DESKeySpec(makeDesKey(bArr, 7));
        DESKeySpec dESKeySpec3 = new DESKeySpec(makeDesKey(bArr, 14));
        SecretKey generateSecret = this.fac.generateSecret(dESKeySpec);
        SecretKey generateSecret2 = this.fac.generateSecret(dESKeySpec2);
        SecretKey generateSecret3 = this.fac.generateSecret(dESKeySpec3);
        this.cipher.init(1, generateSecret);
        byte[] doFinal = this.cipher.doFinal(bArr2, 0, 8);
        this.cipher.init(1, generateSecret2);
        byte[] doFinal2 = this.cipher.doFinal(bArr2, 0, 8);
        this.cipher.init(1, generateSecret3);
        byte[] doFinal3 = this.cipher.doFinal(bArr2, 0, 8);
        byte[] bArr3 = new byte[24];
        System.arraycopy(doFinal, 0, bArr3, 0, 8);
        System.arraycopy(doFinal2, 0, bArr3, 8, 8);
        System.arraycopy(doFinal3, 0, bArr3, 16, 8);
        return bArr3;
    }

    private byte[] calcV2Response(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArr4;
        try {
            bArr4 = (this.username.toUpperCase(Locale.ENGLISH) + this.ntdomain).getBytes("UnicodeLittleUnmarked");
        } catch (UnsupportedEncodingException unused) {
            bArr4 = null;
        }
        byte[] hmacMD5 = hmacMD5(bArr, bArr4);
        byte[] bArr5 = new byte[bArr2.length + 8];
        System.arraycopy(bArr3, 0, bArr5, 0, 8);
        System.arraycopy(bArr2, 0, bArr5, 8, bArr2.length);
        byte[] bArr6 = new byte[bArr2.length + 16];
        System.arraycopy(hmacMD5(hmacMD5, bArr5), 0, bArr6, 0, 16);
        System.arraycopy(bArr2, 0, bArr6, 16, bArr2.length);
        return bArr6;
    }

    public String generateType3Msg(String str) {
        byte[] bArr;
        byte[] calcResponse;
        byte[] bArr2;
        int i;
        try {
            try {
                bArr = BASE64DecoderStream.decode(str.getBytes("us-ascii"));
            } catch (UnsupportedEncodingException unused) {
                bArr = null;
            }
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("type 2 message: " + toHex(bArr));
            }
            byte[] bArr3 = new byte[8];
            int i2 = 0;
            System.arraycopy(bArr, 24, bArr3, 0, 8);
            int length = this.username.length() * 2;
            writeShort(this.type3, 36, length);
            writeShort(this.type3, 38, length);
            int length2 = this.ntdomain.length() * 2;
            writeShort(this.type3, 28, length2);
            writeShort(this.type3, 30, length2);
            int length3 = this.hostname.length() * 2;
            writeShort(this.type3, 44, length3);
            writeShort(this.type3, 46, length3);
            copybytes(this.type3, 64, this.ntdomain, "UnicodeLittleUnmarked");
            writeInt(this.type3, 32, 64);
            int i3 = length2 + 64;
            copybytes(this.type3, i3, this.username, "UnicodeLittleUnmarked");
            writeInt(this.type3, 40, i3);
            int i4 = i3 + length;
            copybytes(this.type3, i4, this.hostname, "UnicodeLittleUnmarked");
            writeInt(this.type3, 48, i4);
            int i5 = i4 + length3;
            int readInt = readInt(bArr, 20);
            if ((524288 & readInt) != 0) {
                this.logger.fine("Using NTLMv2");
                byte[] bArr4 = new byte[8];
                new Random().nextBytes(bArr4);
                byte[] calcNTHash = calcNTHash();
                byte[] calcV2Response = calcV2Response(calcNTHash, bArr4, bArr3);
                byte[] bArr5 = new byte[0];
                if ((readInt & 8388608) != 0) {
                    int readShort = readShort(bArr, 40);
                    bArr5 = new byte[readShort];
                    System.arraycopy(bArr, readInt(bArr, 44), bArr5, 0, readShort);
                }
                byte[] bArr6 = new byte[bArr5.length + 32];
                bArr6[0] = 1;
                bArr6[1] = 1;
                System.arraycopy(Z6, 0, bArr6, 2, 6);
                long currentTimeMillis = (System.currentTimeMillis() + 11644473600000L) * 10000;
                int i6 = 0;
                while (i6 < 8) {
                    bArr6[i6 + 8] = (byte) (currentTimeMillis & 255);
                    currentTimeMillis >>= 8;
                    i6++;
                    i2 = 0;
                }
                int i7 = i2;
                System.arraycopy(bArr4, i7, bArr6, 16, 8);
                System.arraycopy(Z4, i7, bArr6, 24, 4);
                System.arraycopy(bArr5, i7, bArr6, 28, bArr5.length);
                System.arraycopy(Z4, i7, bArr6, bArr5.length + 28, 4);
                calcResponse = calcV2Response(calcNTHash, bArr6, bArr3);
                bArr2 = calcV2Response;
                i = 557569;
            } else {
                byte[] calcResponse2 = calcResponse(calcLMHash(), bArr3);
                calcResponse = calcResponse(calcNTHash(), bArr3);
                bArr2 = calcResponse2;
                i = 33281;
            }
            System.arraycopy(bArr2, 0, this.type3, i5, bArr2.length);
            writeShort(this.type3, 12, bArr2.length);
            writeShort(this.type3, 14, bArr2.length);
            writeInt(this.type3, 16, i5);
            int i8 = i5 + 24;
            System.arraycopy(calcResponse, 0, this.type3, i8, calcResponse.length);
            writeShort(this.type3, 20, calcResponse.length);
            writeShort(this.type3, 22, calcResponse.length);
            writeInt(this.type3, 24, i8);
            int length4 = i8 + calcResponse.length;
            writeShort(this.type3, 56, length4);
            byte[] bArr7 = new byte[length4];
            System.arraycopy(this.type3, 0, bArr7, 0, length4);
            writeInt(this.type3, 60, i);
            if (this.logger.isLoggable(Level.FINE)) {
                this.logger.fine("type 3 message: " + toHex(bArr7));
            }
            try {
                return new String(BASE64EncoderStream.encode(bArr7), "iso-8859-1");
            } catch (UnsupportedEncodingException unused2) {
                return null;
            }
        } catch (GeneralSecurityException e) {
            this.logger.log(Level.FINE, "GeneralSecurityException", (Throwable) e);
            return "";
        }
    }

    private static int readShort(byte[] bArr, int i) {
        return ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | (bArr[i] & UByte.MAX_VALUE);
    }

    private void writeShort(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 & 255);
        bArr[i + 1] = (byte) ((i2 >> 8) & 255);
    }

    private static int readInt(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    private void writeInt(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 & 255);
        bArr[i + 1] = (byte) ((i2 >> 8) & 255);
        bArr[i + 2] = (byte) ((i2 >> 16) & 255);
        bArr[i + 3] = (byte) ((i2 >> 24) & 255);
    }

    private static String toHex(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 3);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(hex[(bArr[i] >> 4) & 15]);
            sb.append(hex[bArr[i] & 15]);
            sb.append(' ');
        }
        return sb.toString();
    }
}
