package com.sun.mail.imap.protocol;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import kotlin.UByte;
import kotlin.text.Typography;
/* loaded from: classes2.dex */
public class BASE64MailboxDecoder {
    static final char[] pem_array = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', ','};
    private static final byte[] pem_convert_array = new byte[256];

    public static String decode(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        char[] cArr = new char[str.length()];
        StringCharacterIterator stringCharacterIterator = new StringCharacterIterator(str);
        boolean z = false;
        int i = 0;
        for (char first = stringCharacterIterator.first(); first != 65535; first = stringCharacterIterator.next()) {
            if (first == '&') {
                z = true;
                i = base64decode(cArr, i, stringCharacterIterator);
            } else {
                cArr[i] = first;
                i++;
            }
        }
        return z ? new String(cArr, 0, i) : str;
    }

    protected static int base64decode(char[] cArr, int i, CharacterIterator characterIterator) {
        boolean z = true;
        int i2 = -1;
        while (true) {
            byte next = (byte) characterIterator.next();
            if (next == -1) {
                return i;
            }
            if (next == 45) {
                if (z) {
                    int i3 = i + 1;
                    cArr[i] = Typography.amp;
                    return i3;
                }
                return i;
            }
            z = false;
            byte next2 = (byte) characterIterator.next();
            if (next2 == -1 || next2 == 45) {
                return i;
            }
            byte[] bArr = pem_convert_array;
            byte b = bArr[next & UByte.MAX_VALUE];
            byte b2 = bArr[next2 & UByte.MAX_VALUE];
            byte b3 = (byte) (((b << 2) & 252) | ((b2 >>> 4) & 3));
            if (i2 != -1) {
                cArr[i] = (char) ((i2 << 8) | (b3 & UByte.MAX_VALUE));
                i2 = -1;
                i++;
            } else {
                i2 = b3 & UByte.MAX_VALUE;
            }
            byte next3 = (byte) characterIterator.next();
            if (next3 != 61) {
                if (next3 == -1 || next3 == 45) {
                    return i;
                }
                byte b4 = pem_convert_array[next3 & UByte.MAX_VALUE];
                byte b5 = (byte) (((b2 << 4) & 240) | ((b4 >>> 2) & 15));
                if (i2 != -1) {
                    cArr[i] = (char) ((i2 << 8) | (b5 & UByte.MAX_VALUE));
                    i2 = -1;
                    i++;
                } else {
                    i2 = b5 & UByte.MAX_VALUE;
                }
                byte next4 = (byte) characterIterator.next();
                if (next4 == 61) {
                    continue;
                } else if (next4 == -1 || next4 == 45) {
                    return i;
                } else {
                    byte b6 = (byte) (((b4 << 6) & 192) | (pem_convert_array[next4 & UByte.MAX_VALUE] & 63));
                    if (i2 != -1) {
                        cArr[i] = (char) ((i2 << 8) | (b6 & UByte.MAX_VALUE));
                        i2 = -1;
                        i++;
                    } else {
                        i2 = b6 & UByte.MAX_VALUE;
                    }
                }
            }
        }
    }

    static {
        int i = 0;
        for (int i2 = 0; i2 < 255; i2++) {
            pem_convert_array[i2] = -1;
        }
        while (true) {
            char[] cArr = pem_array;
            if (i >= cArr.length) {
                return;
            }
            pem_convert_array[cArr[i]] = (byte) i;
            i++;
        }
    }
}
