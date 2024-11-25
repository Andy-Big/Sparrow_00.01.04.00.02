package com.rigol.scope.utilities;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.text.DecimalFormat;
/* loaded from: classes2.dex */
public class ScaleNumUtil {
    private static final float[] nums1 = {1.0f, 2.0f, 5.0f, 10.0f, 20.0f, 50.0f, 100.0f};
    private static final float[] nums2 = {1.0f, 2.0f, 4.0f, 10.0f};
    private static final float[] nums5 = {1.0f, 2.5f, 5.0f, 10.0f};

    private static float getPlusNewFirstNum(long j, int i, float f) {
        char c;
        float[] fArr;
        String floatFirstNumStr = getFloatFirstNumStr(f);
        int hashCode = floatFirstNumStr.hashCode();
        if (hashCode == 49) {
            if (floatFirstNumStr.equals("1")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 50) {
            if (hashCode == 53 && floatFirstNumStr.equals("5")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (floatFirstNumStr.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            fArr = nums1;
        } else if (c == 1) {
            fArr = nums2;
        } else if (c == 2) {
            fArr = nums5;
        } else {
            fArr = nums1;
        }
        float f2 = fArr[0];
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        double powPointer = getPowPointer(String.valueOf(j));
        double parseDouble = Double.parseDouble(decimalFormat.format(j / Math.pow(10.0d, powPointer)).replace(",", "."));
        int length = fArr.length - 2;
        for (int i2 = 0; i2 < fArr.length; i2++) {
            int i3 = length;
            if (parseDouble >= Double.parseDouble(decimalFormat.format(new BigDecimal(String.valueOf(fArr[length])).movePointRight(i - 1).longValue() / Math.pow(10.0d, powPointer)).replace(",", "."))) {
                return fArr[i3 + 1];
            }
            length = i3 > 0 ? i3 - 1 : i3;
        }
        return f2;
    }

    private static float getMinusNewFirstNum(long j, int i, float f) {
        char c;
        float[] fArr;
        String floatFirstNumStr = getFloatFirstNumStr(f);
        int hashCode = floatFirstNumStr.hashCode();
        if (hashCode == 49) {
            if (floatFirstNumStr.equals("1")) {
                c = 0;
            }
            c = 65535;
        } else if (hashCode != 50) {
            if (hashCode == 53 && floatFirstNumStr.equals("5")) {
                c = 2;
            }
            c = 65535;
        } else {
            if (floatFirstNumStr.equals(ExifInterface.GPS_MEASUREMENT_2D)) {
                c = 1;
            }
            c = 65535;
        }
        if (c == 0) {
            fArr = nums1;
        } else if (c == 1) {
            fArr = nums2;
        } else if (c == 2) {
            fArr = nums5;
        } else {
            fArr = nums1;
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        int i2 = i - 1;
        double powPointer = getPowPointer(String.valueOf(j));
        double parseDouble = Double.parseDouble(decimalFormat.format(new BigDecimal(String.valueOf(fArr[0])).movePointRight(i2).longValue() / Math.pow(10.0d, powPointer)).replace(",", "."));
        double parseDouble2 = Double.parseDouble(decimalFormat.format(j / Math.pow(10.0d, powPointer)).replace(",", "."));
        int i3 = 1;
        int i4 = 0;
        while (i4 < fArr.length) {
            double d = parseDouble2;
            int i5 = i4;
            double parseDouble3 = Double.parseDouble(decimalFormat.format(new BigDecimal(String.valueOf(fArr[i3])).movePointRight(i2).longValue() / Math.pow(10.0d, powPointer)).replace(",", "."));
            if (d <= parseDouble) {
                return new BigDecimal(String.valueOf(fArr[2])).movePointLeft(1).floatValue();
            }
            if (d <= parseDouble3) {
                return fArr[i3 - 1];
            }
            if (i3 < fArr.length - 2) {
                i3++;
            }
            i4 = i5 + 1;
            parseDouble2 = d;
        }
        return 0.0f;
    }

    private static int getPowPointer(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (str.length() >= 9) {
            return 9;
        }
        return (str.length() < 6 && str.length() >= 3) ? 3 : 6;
    }

    private static String getLongFirstNumStr(long j) {
        return Math.abs(j) >= 1 ? Long.toString(Math.abs(j)).substring(0, 1) : "0";
    }

    private static String getFloatFirstNumStr(float f) {
        String f2 = Float.toString(Math.abs(f));
        int i = 0;
        if (Math.abs(f) >= 1.0f) {
            return f2.substring(0, 1);
        }
        if (Math.abs(f) == 0.0f) {
            return "0";
        }
        while (true) {
            if (f2.charAt(i) != '0' && f2.charAt(i) != '.') {
                return f2.charAt(i) + "";
            }
            i++;
        }
    }

    private static int getNumDigits(long j) {
        if (j == 0) {
            return 1;
        }
        BigDecimal bigDecimal = new BigDecimal(Long.toString(Math.abs(j)));
        int i = 0;
        if (bigDecimal.longValue() >= 1) {
            while (bigDecimal.longValue() >= 1) {
                bigDecimal = bigDecimal.movePointLeft(1);
                i++;
            }
        } else {
            while (bigDecimal.longValue() < 1) {
                bigDecimal = bigDecimal.movePointRight(1);
                i--;
            }
        }
        return i;
    }

    public static long getPlusNum(long j, float f) {
        if (j < 0) {
            return -getMinusNum(Math.abs(j), f);
        }
        int numDigits = getNumDigits(j);
        getLongFirstNumStr(j);
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(getPlusNewFirstNum(j, numDigits, f)));
        if (Math.abs(j) != 0) {
            if (Math.abs(j) >= 1) {
                bigDecimal = bigDecimal.movePointRight(numDigits - 1);
            } else {
                bigDecimal = bigDecimal.movePointLeft(Math.abs(numDigits));
            }
        }
        return bigDecimal.longValue();
    }

    public static long getMinusNum(long j, float f) {
        if (j <= 0) {
            return -getPlusNum(Math.abs(j), f);
        }
        int numDigits = getNumDigits(j);
        getLongFirstNumStr(j);
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(getMinusNewFirstNum(j, numDigits, f)));
        if (Math.abs(j) != 0) {
            if (Math.abs(j) >= 1) {
                bigDecimal = bigDecimal.movePointRight(numDigits - 1);
            } else {
                bigDecimal = bigDecimal.movePointLeft(Math.abs(numDigits));
            }
        }
        return bigDecimal.longValue();
    }

    private static boolean isWholeNumber(long j, int i) {
        if (i == 1) {
            return true;
        }
        String l = Long.toString(Math.abs(j));
        for (int i2 = 1; i2 < l.length(); i2++) {
            if (l.charAt(i2) != '0') {
                return false;
            }
        }
        return true;
    }
}
