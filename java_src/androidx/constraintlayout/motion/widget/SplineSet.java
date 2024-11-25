package androidx.constraintlayout.motion.widget;

import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.Arrays;
/* loaded from: classes.dex */
public abstract class SplineSet {
    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    private String mType;
    protected int[] mTimePoints = new int[10];
    protected float[] mValues = new float[10];

    public abstract void setProperty(View view, float f);

    public String toString() {
        String str = this.mType;
        DecimalFormat decimalFormat = new DecimalFormat("##.##");
        for (int i = 0; i < this.count; i++) {
            str = str + "[" + this.mTimePoints[i] + " , " + decimalFormat.format(this.mValues[i]) + "] ";
        }
        return str;
    }

    public void setType(String str) {
        this.mType = str;
    }

    public float get(float f) {
        return (float) this.mCurveFit.getPos(f, 0);
    }

    public float getSlope(float f) {
        return (float) this.mCurveFit.getSlope(f, 0);
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static SplineSet makeCustomSpline(String str, SparseArray<ConstraintAttribute> sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static SplineSet makeSpline(String str) {
        char c;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals(Key.ROTATION_X)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals(Key.ROTATION_Y)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals(Key.TRANSLATION_X)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals(Key.TRANSLATION_Z)) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals(Key.SCALE_X)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals(Key.SCALE_Y)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -797520672:
                if (str.equals(Key.WAVE_VARIES_BY)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -760884510:
                if (str.equals(Key.PIVOT_X)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -760884509:
                if (str.equals(Key.PIVOT_Y)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals(Key.ELEVATION)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 92909918:
                if (str.equals(Key.ALPHA)) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return new AlphaSet();
            case 1:
                return new ElevationSet();
            case 2:
                return new RotationSet();
            case 3:
                return new RotationXset();
            case 4:
                return new RotationYset();
            case 5:
                return new PivotXset();
            case 6:
                return new PivotYset();
            case 7:
                return new PathRotate();
            case '\b':
                return new ScaleXset();
            case '\t':
                return new ScaleYset();
            case '\n':
                return new AlphaSet();
            case 11:
                return new AlphaSet();
            case '\f':
                return new TranslationXset();
            case '\r':
                return new TranslationYset();
            case 14:
                return new TranslationZset();
            case 15:
                return new ProgressSet();
            default:
                return null;
        }
    }

    public void setPoint(int i, float f) {
        int[] iArr = this.mTimePoints;
        if (iArr.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(iArr, iArr.length * 2);
            float[] fArr = this.mValues;
            this.mValues = Arrays.copyOf(fArr, fArr.length * 2);
        }
        int[] iArr2 = this.mTimePoints;
        int i2 = this.count;
        iArr2[i2] = i;
        this.mValues[i2] = f;
        this.count = i2 + 1;
    }

    public void setup(int i) {
        int i2;
        int i3 = this.count;
        if (i3 == 0) {
            return;
        }
        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, i3 - 1);
        int i4 = 1;
        for (int i5 = 1; i5 < this.count; i5++) {
            int[] iArr = this.mTimePoints;
            if (iArr[i5 - 1] != iArr[i5]) {
                i4++;
            }
        }
        double[] dArr = new double[i4];
        double[][] dArr2 = (double[][]) Array.newInstance(double.class, i4, 1);
        int i6 = 0;
        for (i2 = 0; i2 < this.count; i2 = i2 + 1) {
            if (i2 > 0) {
                int[] iArr2 = this.mTimePoints;
                i2 = iArr2[i2] == iArr2[i2 - 1] ? i2 + 1 : 0;
            }
            dArr[i6] = this.mTimePoints[i2] * 0.01d;
            dArr2[i6][0] = this.mValues[i2];
            i6++;
        }
        this.mCurveFit = CurveFit.get(i, dArr, dArr2);
    }

    /* loaded from: classes.dex */
    static class ElevationSet extends SplineSet {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setElevation(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    static class AlphaSet extends SplineSet {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setAlpha(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class RotationSet extends SplineSet {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setRotation(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class RotationXset extends SplineSet {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setRotationX(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class RotationYset extends SplineSet {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setRotationY(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class PivotXset extends SplineSet {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setPivotX(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class PivotYset extends SplineSet {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setPivotY(get(f));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class PathRotate extends SplineSet {
        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
        }

        PathRotate() {
        }

        public void setPathRotate(View view, float f, double d, double d2) {
            view.setRotation(get(f) + ((float) Math.toDegrees(Math.atan2(d2, d))));
        }
    }

    /* loaded from: classes.dex */
    static class ScaleXset extends SplineSet {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setScaleX(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class ScaleYset extends SplineSet {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setScaleY(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class TranslationXset extends SplineSet {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setTranslationX(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class TranslationYset extends SplineSet {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            view.setTranslationY(get(f));
        }
    }

    /* loaded from: classes.dex */
    static class TranslationZset extends SplineSet {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            if (Build.VERSION.SDK_INT >= 21) {
                view.setTranslationZ(get(f));
            }
        }
    }

    /* loaded from: classes.dex */
    static class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray<ConstraintAttribute> mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String str, SparseArray<ConstraintAttribute> sparseArray) {
            this.mAttributeName = str.split(",")[1];
            this.mConstraintAttributeList = sparseArray;
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setup(int i) {
            float[] fArr;
            int size = this.mConstraintAttributeList.size();
            int noOfInterpValues = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] dArr = new double[size];
            this.mTempValues = new float[noOfInterpValues];
            double[][] dArr2 = (double[][]) Array.newInstance(double.class, size, noOfInterpValues);
            for (int i2 = 0; i2 < size; i2++) {
                dArr[i2] = this.mConstraintAttributeList.keyAt(i2) * 0.01d;
                this.mConstraintAttributeList.valueAt(i2).getValuesToInterpolate(this.mTempValues);
                int i3 = 0;
                while (true) {
                    if (i3 < this.mTempValues.length) {
                        dArr2[i2][i3] = fArr[i3];
                        i3++;
                    }
                }
            }
            this.mCurveFit = CurveFit.get(i, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setPoint(int i, float f) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setPoint(int i, ConstraintAttribute constraintAttribute) {
            this.mConstraintAttributeList.append(i, constraintAttribute);
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            this.mCurveFit.getPos(f, this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(view, this.mTempValues);
        }
    }

    /* loaded from: classes.dex */
    static class ProgressSet extends SplineSet {
        boolean mNoMethod = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.widget.SplineSet
        public void setProperty(View view, float f) {
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(get(f));
            } else if (this.mNoMethod) {
            } else {
                Method method = null;
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    this.mNoMethod = true;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(get(f)));
                    } catch (IllegalAccessException e) {
                        Log.e(SplineSet.TAG, "unable to setProgress", e);
                    } catch (InvocationTargetException e2) {
                        Log.e(SplineSet.TAG, "unable to setProgress", e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class Sort {
        private Sort() {
        }

        static void doubleQuickSort(int[] iArr, float[] fArr, int i, int i2) {
            int[] iArr2 = new int[iArr.length + 10];
            iArr2[0] = i2;
            iArr2[1] = i;
            int i3 = 2;
            while (i3 > 0) {
                int i4 = i3 - 1;
                int i5 = iArr2[i4];
                i3 = i4 - 1;
                int i6 = iArr2[i3];
                if (i5 < i6) {
                    int partition = partition(iArr, fArr, i5, i6);
                    int i7 = i3 + 1;
                    iArr2[i3] = partition - 1;
                    int i8 = i7 + 1;
                    iArr2[i7] = i5;
                    int i9 = i8 + 1;
                    iArr2[i8] = i6;
                    i3 = i9 + 1;
                    iArr2[i9] = partition + 1;
                }
            }
        }

        private static int partition(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i2];
            int i4 = i;
            while (i < i2) {
                if (iArr[i] <= i3) {
                    swap(iArr, fArr, i4, i);
                    i4++;
                }
                i++;
            }
            swap(iArr, fArr, i4, i2);
            return i4;
        }

        private static void swap(int[] iArr, float[] fArr, int i, int i2) {
            int i3 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i3;
            float f = fArr[i];
            fArr[i] = fArr[i2];
            fArr[i2] = f;
        }
    }
}
