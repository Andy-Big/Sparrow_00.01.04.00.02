package com.sun.mail.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.UByte;
/* loaded from: classes2.dex */
public class ASCIIUtility {
    private ASCIIUtility() {
    }

    public static int parseInt(byte[] bArr, int i, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        boolean z;
        if (bArr != null) {
            if (i2 > i) {
                int i6 = 0;
                if (bArr[i] == 45) {
                    i4 = Integer.MIN_VALUE;
                    i5 = i + 1;
                    z = true;
                } else {
                    i4 = -2147483647;
                    i5 = i;
                    z = false;
                }
                int i7 = i4 / i3;
                if (i5 < i2) {
                    int i8 = i5 + 1;
                    int digit = Character.digit((char) bArr[i5], i3);
                    if (digit < 0) {
                        throw new NumberFormatException("illegal number: " + toString(bArr, i, i2));
                    }
                    i6 = -digit;
                    i5 = i8;
                }
                while (i5 < i2) {
                    int i9 = i5 + 1;
                    int digit2 = Character.digit((char) bArr[i5], i3);
                    if (digit2 < 0) {
                        throw new NumberFormatException("illegal number");
                    }
                    if (i6 < i7) {
                        throw new NumberFormatException("illegal number");
                    }
                    int i10 = i6 * i3;
                    if (i10 < i4 + digit2) {
                        throw new NumberFormatException("illegal number");
                    }
                    i6 = i10 - digit2;
                    i5 = i9;
                }
                if (z) {
                    if (i5 > i + 1) {
                        return i6;
                    }
                    throw new NumberFormatException("illegal number");
                }
                return -i6;
            }
            throw new NumberFormatException("illegal number");
        }
        throw new NumberFormatException("null");
    }

    public static int parseInt(byte[] bArr, int i, int i2) throws NumberFormatException {
        return parseInt(bArr, i, i2, 10);
    }

    public static long parseLong(byte[] bArr, int i, int i2, int i3) throws NumberFormatException {
        long j;
        boolean z;
        int i4;
        int i5 = i2;
        int i6 = i3;
        if (bArr != null) {
            long j2 = 0;
            if (i5 > i) {
                if (bArr[i] == 45) {
                    i4 = i + 1;
                    j = Long.MIN_VALUE;
                    z = true;
                } else {
                    j = -9223372036854775807L;
                    z = false;
                    i4 = i;
                }
                long j3 = i6;
                long j4 = j / j3;
                if (i4 < i5) {
                    int i7 = i4 + 1;
                    int digit = Character.digit((char) bArr[i4], i6);
                    if (digit < 0) {
                        throw new NumberFormatException("illegal number: " + toString(bArr, i, i2));
                    }
                    i4 = i7;
                    j2 = -digit;
                }
                while (i4 < i5) {
                    int i8 = i4 + 1;
                    int digit2 = Character.digit((char) bArr[i4], i6);
                    if (digit2 < 0) {
                        throw new NumberFormatException("illegal number");
                    }
                    if (j2 < j4) {
                        throw new NumberFormatException("illegal number");
                    }
                    long j5 = j2 * j3;
                    long j6 = digit2;
                    if (j5 < j + j6) {
                        throw new NumberFormatException("illegal number");
                    }
                    j2 = j5 - j6;
                    i5 = i2;
                    i6 = i3;
                    i4 = i8;
                }
                if (z) {
                    if (i4 > i + 1) {
                        return j2;
                    }
                    throw new NumberFormatException("illegal number");
                }
                return -j2;
            }
            throw new NumberFormatException("illegal number");
        }
        throw new NumberFormatException("null");
    }

    public static long parseLong(byte[] bArr, int i, int i2) throws NumberFormatException {
        return parseLong(bArr, i, i2, 10);
    }

    public static String toString(byte[] bArr, int i, int i2) {
        int i3 = i2 - i;
        char[] cArr = new char[i3];
        int i4 = 0;
        while (i4 < i3) {
            cArr[i4] = (char) (bArr[i] & UByte.MAX_VALUE);
            i4++;
            i++;
        }
        return new String(cArr);
    }

    public static String toString(byte[] bArr) {
        return toString(bArr, 0, bArr.length);
    }

    public static String toString(ByteArrayInputStream byteArrayInputStream) {
        int available = byteArrayInputStream.available();
        char[] cArr = new char[available];
        byte[] bArr = new byte[available];
        byteArrayInputStream.read(bArr, 0, available);
        for (int i = 0; i < available; i++) {
            cArr[i] = (char) (bArr[i] & UByte.MAX_VALUE);
        }
        return new String(cArr);
    }

    public static byte[] getBytes(String str) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) charArray[i];
        }
        return bArr;
    }

    public static byte[] getBytes(InputStream inputStream) throws IOException {
        if (inputStream instanceof ByteArrayInputStream) {
            int available = inputStream.available();
            byte[] bArr = new byte[available];
            inputStream.read(bArr, 0, available);
            return bArr;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr2 = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr2, 0, 1024);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }
}
