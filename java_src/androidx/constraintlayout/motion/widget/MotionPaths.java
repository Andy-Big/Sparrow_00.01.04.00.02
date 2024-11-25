package androidx.constraintlayout.motion.widget;

import android.view.View;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintSet;
import java.util.Arrays;
import java.util.LinkedHashMap;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class MotionPaths implements Comparable<MotionPaths> {
    static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    static final int OFF_HEIGHT = 4;
    static final int OFF_PATH_ROTATE = 5;
    static final int OFF_POSITION = 0;
    static final int OFF_WIDTH = 3;
    static final int OFF_X = 1;
    static final int OFF_Y = 2;
    public static final boolean OLD_WAY = false;
    static final int PERPENDICULAR = 1;
    static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";
    static String[] names = {"position", "x", "y", "width", "height", "pathRotate"};
    LinkedHashMap<String, ConstraintAttribute> attributes;
    float height;
    int mAnimateCircleAngleTo;
    int mAnimateRelativeTo;
    int mDrawPath;
    Easing mKeyFrameEasing;
    int mMode;
    int mPathMotionArc;
    float mPathRotate;
    float mProgress;
    float mRelativeAngle;
    MotionController mRelativeToController;
    double[] mTempDelta;
    double[] mTempValue;
    float position;
    float time;
    float width;
    float x;
    float y;

    private static final float xRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private static final float yRotate(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f5 - f3) * f) + ((f6 - f4) * f2) + f4;
    }

    public MotionPaths() {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.mAnimateRelativeTo = Key.UNSET;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
    }

    void initCartesian(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width;
        float f5 = motionPaths.width;
        float f6 = motionPaths2.height;
        float f7 = motionPaths.height;
        this.position = this.time;
        float f8 = motionPaths.x;
        float f9 = motionPaths.y;
        float f10 = (motionPaths2.x + (f4 / 2.0f)) - ((f5 / 2.0f) + f8);
        float f11 = (motionPaths2.y + (f6 / 2.0f)) - (f9 + (f7 / 2.0f));
        float f12 = (f4 - f5) * f2;
        float f13 = f12 / 2.0f;
        this.x = (int) ((f8 + (f10 * f)) - f13);
        float f14 = (f6 - f7) * f3;
        float f15 = f14 / 2.0f;
        this.y = (int) ((f9 + (f11 * f)) - f15);
        this.width = (int) (f5 + f12);
        this.height = (int) (f7 + f14);
        float f16 = Float.isNaN(keyPosition.mPercentX) ? f : keyPosition.mPercentX;
        float f17 = Float.isNaN(keyPosition.mAltPercentY) ? 0.0f : keyPosition.mAltPercentY;
        if (!Float.isNaN(keyPosition.mPercentY)) {
            f = keyPosition.mPercentY;
        }
        float f18 = Float.isNaN(keyPosition.mAltPercentX) ? 0.0f : keyPosition.mAltPercentX;
        this.mMode = 0;
        this.x = (int) (((motionPaths.x + (f16 * f10)) + (f18 * f11)) - f13);
        this.y = (int) (((motionPaths.y + (f10 * f17)) + (f11 * f)) - f15);
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public MotionPaths(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.mDrawPath = 0;
        this.mPathRotate = Float.NaN;
        this.mProgress = Float.NaN;
        this.mPathMotionArc = Key.UNSET;
        this.mAnimateRelativeTo = Key.UNSET;
        this.mRelativeAngle = Float.NaN;
        this.mRelativeToController = null;
        this.attributes = new LinkedHashMap<>();
        this.mMode = 0;
        this.mTempValue = new double[18];
        this.mTempDelta = new double[18];
        if (motionPaths.mAnimateRelativeTo != Key.UNSET) {
            initPolar(i, i2, keyPosition, motionPaths, motionPaths2);
            return;
        }
        int i3 = keyPosition.mPositionType;
        if (i3 == 1) {
            initPath(keyPosition, motionPaths, motionPaths2);
        } else if (i3 == 2) {
            initScreen(i, i2, keyPosition, motionPaths, motionPaths2);
        } else {
            initCartesian(keyPosition, motionPaths, motionPaths2);
        }
    }

    void initPolar(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float min;
        float f;
        float f2 = keyPosition.mFramePosition / 100.0f;
        this.time = f2;
        this.mDrawPath = keyPosition.mDrawPath;
        this.mMode = keyPosition.mPositionType;
        float f3 = Float.isNaN(keyPosition.mPercentWidth) ? f2 : keyPosition.mPercentWidth;
        float f4 = Float.isNaN(keyPosition.mPercentHeight) ? f2 : keyPosition.mPercentHeight;
        float f5 = motionPaths2.width;
        float f6 = motionPaths.width;
        float f7 = motionPaths2.height;
        float f8 = motionPaths.height;
        this.position = this.time;
        this.width = (int) (f6 + ((f5 - f6) * f3));
        this.height = (int) (f8 + ((f7 - f8) * f4));
        int i3 = keyPosition.mPositionType;
        if (i3 == 1) {
            float f9 = Float.isNaN(keyPosition.mPercentX) ? f2 : keyPosition.mPercentX;
            float f10 = motionPaths2.x;
            float f11 = motionPaths.x;
            this.x = (f9 * (f10 - f11)) + f11;
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f2 = keyPosition.mPercentY;
            }
            float f12 = motionPaths2.y;
            float f13 = motionPaths.y;
            this.y = (f2 * (f12 - f13)) + f13;
        } else if (i3 == 2) {
            if (Float.isNaN(keyPosition.mPercentX)) {
                float f14 = motionPaths2.x;
                float f15 = motionPaths.x;
                min = ((f14 - f15) * f2) + f15;
            } else {
                min = Math.min(f4, f3) * keyPosition.mPercentX;
            }
            this.x = min;
            if (Float.isNaN(keyPosition.mPercentY)) {
                float f16 = motionPaths2.y;
                float f17 = motionPaths.y;
                f = (f2 * (f16 - f17)) + f17;
            } else {
                f = keyPosition.mPercentY;
            }
            this.y = f;
        } else {
            float f18 = Float.isNaN(keyPosition.mPercentX) ? f2 : keyPosition.mPercentX;
            float f19 = motionPaths2.x;
            float f20 = motionPaths.x;
            this.x = (f18 * (f19 - f20)) + f20;
            if (!Float.isNaN(keyPosition.mPercentY)) {
                f2 = keyPosition.mPercentY;
            }
            float f21 = motionPaths2.y;
            float f22 = motionPaths.y;
            this.y = (f2 * (f21 - f22)) + f22;
        }
        this.mAnimateRelativeTo = motionPaths.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    public void setupRelative(MotionController motionController, MotionPaths motionPaths) {
        double d = ((this.x + (this.width / 2.0f)) - motionPaths.x) - (motionPaths.width / 2.0f);
        double d2 = ((this.y + (this.height / 2.0f)) - motionPaths.y) - (motionPaths.height / 2.0f);
        this.mRelativeToController = motionController;
        this.x = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.mRelativeAngle)) {
            this.y = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.y = (float) Math.toRadians(this.mRelativeAngle);
        }
    }

    void initScreen(int i, int i2, KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = keyPosition.mFramePosition / 100.0f;
        this.time = f;
        this.mDrawPath = keyPosition.mDrawPath;
        float f2 = Float.isNaN(keyPosition.mPercentWidth) ? f : keyPosition.mPercentWidth;
        float f3 = Float.isNaN(keyPosition.mPercentHeight) ? f : keyPosition.mPercentHeight;
        float f4 = motionPaths2.width;
        float f5 = motionPaths.width;
        float f6 = motionPaths2.height;
        float f7 = motionPaths.height;
        this.position = this.time;
        float f8 = motionPaths.x;
        float f9 = motionPaths.y;
        float f10 = motionPaths2.x + (f4 / 2.0f);
        float f11 = motionPaths2.y + (f6 / 2.0f);
        float f12 = (f4 - f5) * f2;
        this.x = (int) ((f8 + ((f10 - ((f5 / 2.0f) + f8)) * f)) - (f12 / 2.0f));
        float f13 = (f6 - f7) * f3;
        this.y = (int) ((f9 + ((f11 - (f9 + (f7 / 2.0f))) * f)) - (f13 / 2.0f));
        this.width = (int) (f5 + f12);
        this.height = (int) (f7 + f13);
        this.mMode = 2;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            this.x = (int) (keyPosition.mPercentX * ((int) (i - this.width)));
        }
        if (!Float.isNaN(keyPosition.mPercentY)) {
            this.y = (int) (keyPosition.mPercentY * ((int) (i2 - this.height)));
        }
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    void initPath(KeyPosition keyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3 = keyPosition.mFramePosition / 100.0f;
        this.time = f3;
        this.mDrawPath = keyPosition.mDrawPath;
        float f4 = Float.isNaN(keyPosition.mPercentWidth) ? f3 : keyPosition.mPercentWidth;
        float f5 = Float.isNaN(keyPosition.mPercentHeight) ? f3 : keyPosition.mPercentHeight;
        float f6 = motionPaths2.width - motionPaths.width;
        float f7 = motionPaths2.height - motionPaths.height;
        this.position = this.time;
        if (!Float.isNaN(keyPosition.mPercentX)) {
            f3 = keyPosition.mPercentX;
        }
        float f8 = motionPaths.x;
        float f9 = motionPaths.width;
        float f10 = motionPaths.y;
        float f11 = motionPaths.height;
        float f12 = (motionPaths2.x + (motionPaths2.width / 2.0f)) - ((f9 / 2.0f) + f8);
        float f13 = (motionPaths2.y + (motionPaths2.height / 2.0f)) - ((f11 / 2.0f) + f10);
        float f14 = f12 * f3;
        float f15 = (f6 * f4) / 2.0f;
        this.x = (int) ((f8 + f14) - f15);
        float f16 = f3 * f13;
        float f17 = (f7 * f5) / 2.0f;
        this.y = (int) ((f10 + f16) - f17);
        this.width = (int) (f9 + f);
        this.height = (int) (f11 + f2);
        float f18 = Float.isNaN(keyPosition.mPercentY) ? 0.0f : keyPosition.mPercentY;
        this.mMode = 1;
        float f19 = (int) ((motionPaths.x + f14) - f15);
        this.x = f19;
        float f20 = (int) ((motionPaths.y + f16) - f17);
        this.y = f20;
        this.x = f19 + ((-f13) * f18);
        this.y = f20 + (f12 * f18);
        this.mAnimateRelativeTo = this.mAnimateRelativeTo;
        this.mKeyFrameEasing = Easing.getInterpolator(keyPosition.mTransitionEasing);
        this.mPathMotionArc = keyPosition.mPathMotionArc;
    }

    private boolean diff(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void different(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean diff = diff(this.x, motionPaths.x);
        boolean diff2 = diff(this.y, motionPaths.y);
        zArr[0] = zArr[0] | diff(this.position, motionPaths.position);
        boolean z2 = diff | diff2 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | diff(this.width, motionPaths.width);
        zArr[4] = diff(this.height, motionPaths.height) | zArr[4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = f6;
            double d3 = f;
            double d4 = f2;
            f = (float) ((d2 + (Math.sin(d4) * d3)) - (f3 / 2.0f));
            f2 = (float) ((f7 - (d3 * Math.cos(d4))) - (f4 / 2.0f));
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getCenter(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f;
        float f2 = this.x;
        float f3 = this.y;
        float f4 = this.width;
        float f5 = this.height;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f10 = (float) dArr[i];
            float f11 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f2 = f10;
                f6 = f11;
            } else if (i2 == 2) {
                f3 = f10;
                f8 = f11;
            } else if (i2 == 3) {
                f4 = f10;
                f7 = f11;
            } else if (i2 == 4) {
                f5 = f10;
                f9 = f11;
            }
        }
        float f12 = 2.0f;
        float f13 = (f7 / 2.0f) + f6;
        float f14 = (f9 / 2.0f) + f8;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motionController.getCenter(d, fArr3, fArr4);
            float f15 = fArr3[0];
            float f16 = fArr3[1];
            float f17 = fArr4[0];
            float f18 = fArr4[1];
            double d2 = f2;
            double d3 = f3;
            f = f4;
            double d4 = f6;
            double d5 = f8;
            float sin = (float) (f17 + (Math.sin(d3) * d4) + (Math.cos(d3) * d5));
            f14 = (float) ((f18 - (d4 * Math.cos(d3))) + (Math.sin(d3) * d5));
            f13 = sin;
            f2 = (float) ((f15 + (Math.sin(d3) * d2)) - (f4 / 2.0f));
            f3 = (float) ((f16 - (d2 * Math.cos(d3))) - (f5 / 2.0f));
            f12 = 2.0f;
        } else {
            f = f4;
        }
        fArr[0] = f2 + (f / f12) + 0.0f;
        fArr[1] = f3 + (f5 / f12) + 0.0f;
        fArr2[0] = f13;
        fArr2[1] = f14;
    }

    void getCenterVelocity(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr2 = new float[2];
            motionController.getCenter(d, fArr2, new float[2]);
            float f6 = fArr2[0];
            float f7 = fArr2[1];
            double d2 = f6;
            double d3 = f;
            double d4 = f2;
            f = (float) ((d2 + (Math.sin(d4) * d3)) - (f3 / 2.0f));
            f2 = (float) ((f7 - (d3 * Math.cos(d4))) - (f4 / 2.0f));
        }
        fArr[i] = f + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f2 + (f4 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getBounds(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.width;
        float f2 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f3 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 3) {
                f = f3;
            } else if (i3 == 4) {
                f2 = f3;
            }
        }
        fArr[i] = f;
        fArr[i + 1] = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setView(float f, View view, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f2;
        boolean z;
        boolean z2;
        float f3;
        float f4 = this.x;
        float f5 = this.y;
        float f6 = this.width;
        float f7 = this.height;
        if (iArr.length != 0 && this.mTempValue.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.mTempValue = new double[i];
            this.mTempDelta = new double[i];
        }
        Arrays.fill(this.mTempValue, Double.NaN);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            this.mTempValue[iArr[i2]] = dArr[i2];
            this.mTempDelta[iArr[i2]] = dArr2[i2];
        }
        float f8 = Float.NaN;
        int i3 = 0;
        float f9 = 0.0f;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        while (true) {
            double[] dArr4 = this.mTempValue;
            if (i3 >= dArr4.length) {
                break;
            }
            if (Double.isNaN(dArr4[i3]) && (dArr3 == null || dArr3[i3] == 0.0d)) {
                f3 = f8;
            } else {
                double d = dArr3 != null ? dArr3[i3] : 0.0d;
                if (!Double.isNaN(this.mTempValue[i3])) {
                    d = this.mTempValue[i3] + d;
                }
                f3 = f8;
                float f13 = (float) d;
                float f14 = (float) this.mTempDelta[i3];
                if (i3 == 1) {
                    f8 = f3;
                    f9 = f14;
                    f4 = f13;
                } else if (i3 == 2) {
                    f8 = f3;
                    f10 = f14;
                    f5 = f13;
                } else if (i3 == 3) {
                    f8 = f3;
                    f11 = f14;
                    f6 = f13;
                } else if (i3 == 4) {
                    f8 = f3;
                    f12 = f14;
                    f7 = f13;
                } else if (i3 == 5) {
                    f8 = f13;
                }
                i3++;
            }
            f8 = f3;
            i3++;
        }
        float f15 = f8;
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motionController.getCenter(f, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d2 = f4;
            double d3 = f5;
            float sin = (float) ((f16 + (Math.sin(d3) * d2)) - (f6 / 2.0f));
            f2 = f7;
            float cos = (float) ((f17 - (Math.cos(d3) * d2)) - (f7 / 2.0f));
            double d4 = f9;
            double d5 = f10;
            float sin2 = (float) (f18 + (Math.sin(d3) * d4) + (Math.cos(d3) * d2 * d5));
            float cos2 = (float) ((f19 - (d4 * Math.cos(d3))) + (d2 * Math.sin(d3) * d5));
            if (dArr2.length >= 2) {
                z = false;
                dArr2[0] = sin2;
                z2 = true;
                dArr2[1] = cos2;
            } else {
                z = false;
                z2 = true;
            }
            if (!Float.isNaN(f15)) {
                view.setRotation((float) (f15 + Math.toDegrees(Math.atan2(cos2, sin2))));
            }
            f4 = sin;
            f5 = cos;
        } else {
            f2 = f7;
            z = false;
            z2 = true;
            if (!Float.isNaN(f15)) {
                view.setRotation((float) (0.0f + f15 + Math.toDegrees(Math.atan2(f10 + (f12 / 2.0f), f9 + (f11 / 2.0f)))));
            }
        }
        if (view instanceof FloatLayout) {
            ((FloatLayout) view).layout(f4, f5, f6 + f4, f5 + f2);
            return;
        }
        float f20 = f4 + 0.5f;
        int i4 = (int) f20;
        float f21 = f5 + 0.5f;
        int i5 = (int) f21;
        int i6 = (int) (f20 + f6);
        int i7 = (int) (f21 + f2);
        int i8 = i6 - i4;
        int i9 = i7 - i5;
        if (i8 != view.getMeasuredWidth() || i9 != view.getMeasuredHeight()) {
            z = z2;
        }
        if (z) {
            view.measure(View.MeasureSpec.makeMeasureSpec(i8, 1073741824), View.MeasureSpec.makeMeasureSpec(i9, 1073741824));
        }
        view.layout(i4, i5, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void getRect(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.x;
        float f2 = this.y;
        float f3 = this.width;
        float f4 = this.height;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            float f5 = (float) dArr[i2];
            int i3 = iArr[i2];
            if (i3 == 1) {
                f = f5;
            } else if (i3 == 2) {
                f2 = f5;
            } else if (i3 == 3) {
                f3 = f5;
            } else if (i3 == 4) {
                f4 = f5;
            }
        }
        MotionController motionController = this.mRelativeToController;
        if (motionController != null) {
            float centerX = motionController.getCenterX();
            double d = f;
            double d2 = f2;
            f2 = (float) ((this.mRelativeToController.getCenterY() - (d * Math.cos(d2))) - (f4 / 2.0f));
            f = (float) ((centerX + (Math.sin(d2) * d)) - (f3 / 2.0f));
        }
        float f6 = f3 + f;
        float f7 = f4 + f2;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i4 = i + 1;
        fArr[i] = f + 0.0f;
        int i5 = i4 + 1;
        fArr[i4] = f2 + 0.0f;
        int i6 = i5 + 1;
        fArr[i5] = f6 + 0.0f;
        int i7 = i6 + 1;
        fArr[i6] = f2 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f6 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f7 + 0.0f;
        fArr[i9] = f + 0.0f;
        fArr[i9 + 1] = f7 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDpDt(float f, float f2, float[] fArr, int[] iArr, double[] dArr, double[] dArr2) {
        float f3 = 0.0f;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f7 = (float) dArr[i];
            double d = dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f3 = f7;
            } else if (i2 == 2) {
                f5 = f7;
            } else if (i2 == 3) {
                f4 = f7;
            } else if (i2 == 4) {
                f6 = f7;
            }
        }
        float f8 = f3 - ((0.0f * f4) / 2.0f);
        float f9 = f5 - ((0.0f * f6) / 2.0f);
        fArr[0] = (f8 * (1.0f - f)) + (((f4 * 1.0f) + f8) * f) + 0.0f;
        fArr[1] = (f9 * (1.0f - f2)) + (((f6 * 1.0f) + f9) * f2) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void fillStandard(double[] dArr, int[] iArr) {
        float[] fArr = {this.position, this.x, this.y, this.width, this.height, this.mPathRotate};
        int i = 0;
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] < 6) {
                dArr[i] = fArr[iArr[i2]];
                i++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCustomData(String str) {
        return this.attributes.containsKey(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomDataCount(String str) {
        return this.attributes.get(str).noOfInterpValues();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCustomData(String str, double[] dArr, int i) {
        ConstraintAttribute constraintAttribute = this.attributes.get(str);
        if (constraintAttribute.noOfInterpValues() == 1) {
            dArr[i] = constraintAttribute.getValueToInterpolate();
            return 1;
        }
        int noOfInterpValues = constraintAttribute.noOfInterpValues();
        float[] fArr = new float[noOfInterpValues];
        constraintAttribute.getValuesToInterpolate(fArr);
        int i2 = 0;
        while (i2 < noOfInterpValues) {
            dArr[i] = fArr[i2];
            i2++;
            i++;
        }
        return noOfInterpValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBounds(float f, float f2, float f3, float f4) {
        this.x = f;
        this.y = f2;
        this.width = f3;
        this.height = f4;
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.position, motionPaths.position);
    }

    public void applyParameters(ConstraintSet.Constraint constraint) {
        this.mKeyFrameEasing = Easing.getInterpolator(constraint.motion.mTransitionEasing);
        this.mPathMotionArc = constraint.motion.mPathMotionArc;
        this.mAnimateRelativeTo = constraint.motion.mAnimateRelativeTo;
        this.mPathRotate = constraint.motion.mPathRotate;
        this.mDrawPath = constraint.motion.mDrawPath;
        this.mAnimateCircleAngleTo = constraint.motion.mAnimateCircleAngleTo;
        this.mProgress = constraint.propertySet.mProgress;
        this.mRelativeAngle = constraint.layout.circleAngle;
        for (String str : constraint.mCustomConstraints.keySet()) {
            ConstraintAttribute constraintAttribute = constraint.mCustomConstraints.get(str);
            if (constraintAttribute.getType() != ConstraintAttribute.AttributeType.STRING_TYPE) {
                this.attributes.put(str, constraintAttribute);
            }
        }
    }

    public void configureRelativeTo(MotionController motionController) {
        motionController.getPos(this.mProgress);
    }
}
