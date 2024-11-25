package com.rigol.scope.utilities;

import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MathParam;
import com.rigol.util.PackageUtilKt;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class OffsetUtil {
    public static final long ENABLE_TO_SET_OFFSET_DELAY = 550;
    public static final int[] _acc_e = {0, 1, 5, 10, 20, 50, 100, 200, 500, 1000, PackageUtilKt.ERROR_PACKAGE_FILE_DOWNLOAD};
    public static final int[] _acc_square = {0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196, 225};
    public static final int[] _acc_trible = {0, 1, 8, 27, 64, 125, 216, 343, 512, 729, 1000};
    public static final int[] _acc_one = {0, 1, 1, 1, 1, 1, 1, 1, 1};

    public static boolean isCloseToAndOverZero(int i, int i2) {
        return i > 0 ? i2 < 0 : i < 0 && i2 > 0;
    }

    public static boolean isCloseToZero(int i, int i2) {
        return i >= 0 ? i2 < i : i2 > i;
    }

    public static long getVerticalOffsetStep(long j) {
        return (j * 40) / 1000;
    }

    public static long getVerticalOffsetStep(long j, int i) {
        return getVerticalOffsetStep(j, i, _acc_square);
    }

    public static long getVerticalOffsetStep(long j, int i, int[] iArr) {
        long verticalOffsetStep;
        int i2;
        if (i < 1) {
            return getVerticalOffsetStep(j);
        }
        if (iArr == null || iArr.length == 0) {
            return getVerticalOffsetStep(j);
        }
        if (i >= iArr.length) {
            verticalOffsetStep = getVerticalOffsetStep(j);
            i2 = iArr[iArr.length - 1];
        } else {
            verticalOffsetStep = getVerticalOffsetStep(j);
            i2 = iArr[i];
        }
        return verticalOffsetStep * i2;
    }

    public static long getMathOffsetStep(MathParam mathParam, int i) {
        if (mathParam == null) {
            return 0L;
        }
        if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_fft) {
            return getVerticalOffsetStep(mathParam.getFftScale(), i);
        }
        if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_and || mathParam.getOperator() == ServiceEnum.MathOperator.operator_or || mathParam.getOperator() == ServiceEnum.MathOperator.operator_xor || mathParam.getOperator() == ServiceEnum.MathOperator.operator_not) {
            return getVerticalOffsetStep(mathParam.getLogicScale(), i);
        }
        return getVerticalOffsetStep(mathParam.getScale(), i);
    }

    public static long getHorizontalOffsetStep(long j) {
        return (j * 40) / 1000;
    }

    public static long getHorizontalOffsetStep(long j, int i) {
        return getHorizontalOffsetStep(j, i, _acc_square);
    }

    public static long getHorizontalOffsetStep(long j, int i, int[] iArr) {
        long horizontalOffsetStep;
        int i2;
        if (i < 1) {
            return getHorizontalOffsetStep(j);
        }
        if (iArr == null || iArr.length == 0) {
            return getHorizontalOffsetStep(j);
        }
        if (i >= iArr.length) {
            horizontalOffsetStep = getHorizontalOffsetStep(j);
            i2 = iArr[iArr.length - 1];
        } else {
            horizontalOffsetStep = getHorizontalOffsetStep(j);
            i2 = iArr[i];
        }
        return horizontalOffsetStep * i2;
    }

    public static boolean isCloseToAndOverZero(long j, long j2) {
        Timber.d("oldOffset:" + j + ", newOffset:" + j2, new Object[0]);
        int i = (j > 0L ? 1 : (j == 0L ? 0 : -1));
        return i > 0 ? j2 < 0 : i < 0 && j2 > 0;
    }
}
