package com.rigol.scope.views.waveview;

import com.blankj.utilcode.util.CollectionUtils;
import com.blankj.utilcode.util.LogUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class AwgConvertPlotDataUtil {
    public static float[] convertShortPlotDataToFullView(short[] sArr, short s, short s2, int i, int i2) {
        if (sArr == null || sArr.length <= 0 || i2 == 0 || i == 0) {
            LogUtils.e("plot origin data is null or view width is 0!");
            return null;
        }
        int length = sArr.length;
        float[] fArr = new float[length];
        float f = (i2 - 6) / (s2 - s);
        for (int i3 = 0; i3 < length; i3++) {
            fArr[i3] = ((s2 - sArr[i3]) * f) + 2.0f;
        }
        return fArr;
    }

    public static float[] convertFloatPlotDataToFullView(float[] fArr, int i, int i2, int i3, int i4) {
        if (fArr == null || fArr.length <= 0 || i4 == 0 || i3 == 0) {
            LogUtils.e("plot origin data is null or view width is 0!");
            return null;
        }
        int length = fArr.length;
        float[] fArr2 = new float[length];
        float f = i4 / (i2 - i);
        for (int i5 = 0; i5 < length; i5++) {
            fArr2[i5] = (i2 - fArr[i5]) * f;
        }
        return fArr2;
    }

    public static ArrayList<Float> convertPlotDataToOffsetView(float[] fArr, float f, float f2, float f3, float f4) {
        if (fArr.length <= 0 || 0.0f == f4 || 0.0f == f3) {
            return null;
        }
        double d = f4 / 2.0d;
        float f5 = (float) d;
        float max = (float) (d / Math.max(Math.abs(f), Math.abs(f2)));
        int min = (int) Math.min(fArr.length, f3);
        ArrayList<Float> arrayList = new ArrayList<>();
        for (int i = 0; i < min; i++) {
            arrayList.add(Float.valueOf(f5 - (fArr[i] * max)));
        }
        return arrayList;
    }

    public static float[] convertShortPlotDataToOffsetView(short[] sArr, short s, short s2, int i, int i2) {
        if (sArr == null || sArr.length <= 0 || i2 == 0 || i == 0) {
            LogUtils.e("plot origin data is null or view width is 0!");
            return null;
        }
        double d = (i2 - 6) * 0.5d;
        float f = (float) d;
        float max = (float) (d / Math.max(Math.abs((int) s), Math.abs((int) s2)));
        int length = sArr.length;
        float[] fArr = new float[length];
        for (int i3 = 0; i3 < length; i3++) {
            fArr[i3] = (f - ((sArr[i3] * 0.999f) * max)) + 2.0f;
        }
        return fArr;
    }

    public static float[] convertPlotDataToOffsetView(float[] fArr, int i, int i2, int i3, int i4) {
        if (fArr == null || fArr.length <= 0 || i4 == 0 || i3 == 0) {
            LogUtils.e("plot origin data is null or view width is 0!");
            return null;
        }
        double d = i4 * 0.5d;
        float f = (float) d;
        float max = (float) (d / Math.max(Math.abs(i), Math.abs(i2)));
        int length = fArr.length;
        float[] fArr2 = new float[length];
        for (int i5 = 0; i5 < length; i5++) {
            fArr2[i5] = f - (fArr[i5] * max);
        }
        return fArr2;
    }

    public static ArrayList<Float> convertPlotDataToOffsetView(List<Float> list, float f, float f2, float f3, float f4) {
        if (CollectionUtils.isEmpty(list) || 0.0f == f4 || 0.0f == f3) {
            return null;
        }
        double d = f4 / 2.0d;
        float f5 = (float) d;
        float max = (float) (d / Math.max(Math.abs(f), Math.abs(f2)));
        int min = (int) Math.min(list.size(), f3);
        ArrayList<Float> arrayList = new ArrayList<>();
        for (int i = 0; i < min; i++) {
            arrayList.add(Float.valueOf(f5 - (list.get(i).floatValue() * max)));
        }
        return arrayList;
    }
}
