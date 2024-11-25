package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/* loaded from: classes.dex */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    private static final String TAG = "KeyCycle";
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
    private String mTransitionEasing = null;
    private int mCurveFit = 0;
    private int mWaveShape = -1;
    private String mCustomWaveShpe = null;
    private float mWavePeriod = Float.NaN;
    private float mWaveOffset = 0.0f;
    private float mWavePhase = 0.0f;
    private float mProgress = Float.NaN;
    private int mWaveVariesBy = -1;
    private float mAlpha = Float.NaN;
    private float mElevation = Float.NaN;
    private float mRotation = Float.NaN;
    private float mTransitionPathRotate = Float.NaN;
    private float mRotationX = Float.NaN;
    private float mRotationY = Float.NaN;
    private float mScaleX = Float.NaN;
    private float mScaleY = Float.NaN;
    private float mTranslationX = Float.NaN;
    private float mTranslationY = Float.NaN;
    private float mTranslationZ = Float.NaN;

    public KeyCycle() {
        this.mType = 4;
        this.mCustomConstraints = new HashMap<>();
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.mAlpha)) {
            hashSet.add(Key.ALPHA);
        }
        if (!Float.isNaN(this.mElevation)) {
            hashSet.add(Key.ELEVATION);
        }
        if (!Float.isNaN(this.mRotation)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.mRotationX)) {
            hashSet.add(Key.ROTATION_X);
        }
        if (!Float.isNaN(this.mRotationY)) {
            hashSet.add(Key.ROTATION_Y);
        }
        if (!Float.isNaN(this.mScaleX)) {
            hashSet.add(Key.SCALE_X);
        }
        if (!Float.isNaN(this.mScaleY)) {
            hashSet.add(Key.SCALE_Y);
        }
        if (!Float.isNaN(this.mTransitionPathRotate)) {
            hashSet.add(Key.TRANSITION_PATH_ROTATE);
        }
        if (!Float.isNaN(this.mTranslationX)) {
            hashSet.add(Key.TRANSLATION_X);
        }
        if (!Float.isNaN(this.mTranslationY)) {
            hashSet.add(Key.TRANSLATION_Y);
        }
        if (!Float.isNaN(this.mTranslationZ)) {
            hashSet.add(Key.TRANSLATION_Z);
        }
        if (this.mCustomConstraints.size() > 0) {
            Iterator<String> it = this.mCustomConstraints.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add("CUSTOM," + it.next());
            }
        }
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        for (String str : hashMap.keySet()) {
            if (str.startsWith(Key.CUSTOM)) {
                ConstraintAttribute constraintAttribute = this.mCustomConstraints.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE) {
                    hashMap.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShpe, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value)) {
                    hashMap.get(str).setPoint(this.mFramePosition, this.mWaveShape, this.mCustomWaveShpe, this.mWaveVariesBy, this.mWavePeriod, this.mWaveOffset, this.mWavePhase, value);
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public float getValue(String str) {
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
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals(Key.TRANSLATION_Z)) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals(Key.SCALE_X)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals(Key.SCALE_Y)) {
                    c = 7;
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
                    c = 5;
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
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c = '\f';
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
                return this.mAlpha;
            case 1:
                return this.mElevation;
            case 2:
                return this.mRotation;
            case 3:
                return this.mRotationX;
            case 4:
                return this.mRotationY;
            case 5:
                return this.mTransitionPathRotate;
            case 6:
                return this.mScaleX;
            case 7:
                return this.mScaleY;
            case '\b':
                return this.mTranslationX;
            case '\t':
                return this.mTranslationY;
            case '\n':
                return this.mTranslationZ;
            case 11:
                return this.mWaveOffset;
            case '\f':
                return this.mWavePhase;
            case '\r':
                return this.mProgress;
            default:
                if (str.startsWith(Key.CUSTOM)) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, SplineSet> hashMap) {
        Debug.logStack("KeyCycle", "add " + hashMap.size() + " values", 2);
        for (String str : hashMap.keySet()) {
            SplineSet splineSet = hashMap.get(str);
            char c = 65535;
            switch (str.hashCode()) {
                case -1249320806:
                    if (str.equals(Key.ROTATION_X)) {
                        c = 3;
                        break;
                    }
                    break;
                case -1249320805:
                    if (str.equals(Key.ROTATION_Y)) {
                        c = 4;
                        break;
                    }
                    break;
                case -1225497657:
                    if (str.equals(Key.TRANSLATION_X)) {
                        c = '\b';
                        break;
                    }
                    break;
                case -1225497656:
                    if (str.equals(Key.TRANSLATION_Y)) {
                        c = '\t';
                        break;
                    }
                    break;
                case -1225497655:
                    if (str.equals(Key.TRANSLATION_Z)) {
                        c = '\n';
                        break;
                    }
                    break;
                case -1001078227:
                    if (str.equals("progress")) {
                        c = '\r';
                        break;
                    }
                    break;
                case -908189618:
                    if (str.equals(Key.SCALE_X)) {
                        c = 6;
                        break;
                    }
                    break;
                case -908189617:
                    if (str.equals(Key.SCALE_Y)) {
                        c = 7;
                        break;
                    }
                    break;
                case -40300674:
                    if (str.equals(Key.ROTATION)) {
                        c = 2;
                        break;
                    }
                    break;
                case -4379043:
                    if (str.equals(Key.ELEVATION)) {
                        c = 1;
                        break;
                    }
                    break;
                case 37232917:
                    if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                        c = 5;
                        break;
                    }
                    break;
                case 92909918:
                    if (str.equals(Key.ALPHA)) {
                        c = 0;
                        break;
                    }
                    break;
                case 156108012:
                    if (str.equals("waveOffset")) {
                        c = 11;
                        break;
                    }
                    break;
                case 1530034690:
                    if (str.equals("wavePhase")) {
                        c = '\f';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    splineSet.setPoint(this.mFramePosition, this.mAlpha);
                    break;
                case 1:
                    splineSet.setPoint(this.mFramePosition, this.mElevation);
                    break;
                case 2:
                    splineSet.setPoint(this.mFramePosition, this.mRotation);
                    break;
                case 3:
                    splineSet.setPoint(this.mFramePosition, this.mRotationX);
                    break;
                case 4:
                    splineSet.setPoint(this.mFramePosition, this.mRotationY);
                    break;
                case 5:
                    splineSet.setPoint(this.mFramePosition, this.mTransitionPathRotate);
                    break;
                case 6:
                    splineSet.setPoint(this.mFramePosition, this.mScaleX);
                    break;
                case 7:
                    splineSet.setPoint(this.mFramePosition, this.mScaleY);
                    break;
                case '\b':
                    splineSet.setPoint(this.mFramePosition, this.mTranslationX);
                    break;
                case '\t':
                    splineSet.setPoint(this.mFramePosition, this.mTranslationY);
                    break;
                case '\n':
                    splineSet.setPoint(this.mFramePosition, this.mTranslationZ);
                    break;
                case 11:
                    splineSet.setPoint(this.mFramePosition, this.mWaveOffset);
                    break;
                case '\f':
                    splineSet.setPoint(this.mFramePosition, this.mWavePhase);
                    break;
                case '\r':
                    splineSet.setPoint(this.mFramePosition, this.mProgress);
                    break;
                default:
                    if (str.startsWith(Key.CUSTOM)) {
                        break;
                    } else {
                        Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                        break;
                    }
            }
        }
    }

    /* loaded from: classes.dex */
    private static class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_PHASE = 21;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        private Loader() {
        }

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            mAttrMap = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            mAttrMap.append(R.styleable.KeyCycle_framePosition, 2);
            mAttrMap.append(R.styleable.KeyCycle_transitionEasing, 3);
            mAttrMap.append(R.styleable.KeyCycle_curveFit, 4);
            mAttrMap.append(R.styleable.KeyCycle_waveShape, 5);
            mAttrMap.append(R.styleable.KeyCycle_wavePeriod, 6);
            mAttrMap.append(R.styleable.KeyCycle_waveOffset, 7);
            mAttrMap.append(R.styleable.KeyCycle_waveVariesBy, 8);
            mAttrMap.append(R.styleable.KeyCycle_android_alpha, 9);
            mAttrMap.append(R.styleable.KeyCycle_android_elevation, 10);
            mAttrMap.append(R.styleable.KeyCycle_android_rotation, 11);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationX, 12);
            mAttrMap.append(R.styleable.KeyCycle_android_rotationY, 13);
            mAttrMap.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleX, 15);
            mAttrMap.append(R.styleable.KeyCycle_android_scaleY, 16);
            mAttrMap.append(R.styleable.KeyCycle_android_translationX, 17);
            mAttrMap.append(R.styleable.KeyCycle_android_translationY, 18);
            mAttrMap.append(R.styleable.KeyCycle_android_translationZ, 19);
            mAttrMap.append(R.styleable.KeyCycle_motionProgress, 20);
            mAttrMap.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void read(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = typedArray.getIndex(i);
                switch (mAttrMap.get(index)) {
                    case 1:
                        if (MotionLayout.IS_IN_EDIT_MODE) {
                            keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            if (keyCycle.mTargetId == -1) {
                                keyCycle.mTargetString = typedArray.getString(index);
                                break;
                            } else {
                                break;
                            }
                        } else if (typedArray.peekValue(index).type == 3) {
                            keyCycle.mTargetString = typedArray.getString(index);
                            break;
                        } else {
                            keyCycle.mTargetId = typedArray.getResourceId(index, keyCycle.mTargetId);
                            break;
                        }
                    case 2:
                        keyCycle.mFramePosition = typedArray.getInt(index, keyCycle.mFramePosition);
                        break;
                    case 3:
                        keyCycle.mTransitionEasing = typedArray.getString(index);
                        break;
                    case 4:
                        keyCycle.mCurveFit = typedArray.getInteger(index, keyCycle.mCurveFit);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type == 3) {
                            keyCycle.mCustomWaveShpe = typedArray.getString(index);
                            keyCycle.mWaveShape = 7;
                            break;
                        } else {
                            keyCycle.mWaveShape = typedArray.getInt(index, keyCycle.mWaveShape);
                            break;
                        }
                    case 6:
                        keyCycle.mWavePeriod = typedArray.getFloat(index, keyCycle.mWavePeriod);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type == 5) {
                            keyCycle.mWaveOffset = typedArray.getDimension(index, keyCycle.mWaveOffset);
                            break;
                        } else {
                            keyCycle.mWaveOffset = typedArray.getFloat(index, keyCycle.mWaveOffset);
                            break;
                        }
                    case 8:
                        keyCycle.mWaveVariesBy = typedArray.getInt(index, keyCycle.mWaveVariesBy);
                        break;
                    case 9:
                        keyCycle.mAlpha = typedArray.getFloat(index, keyCycle.mAlpha);
                        break;
                    case 10:
                        keyCycle.mElevation = typedArray.getDimension(index, keyCycle.mElevation);
                        break;
                    case 11:
                        keyCycle.mRotation = typedArray.getFloat(index, keyCycle.mRotation);
                        break;
                    case 12:
                        keyCycle.mRotationX = typedArray.getFloat(index, keyCycle.mRotationX);
                        break;
                    case 13:
                        keyCycle.mRotationY = typedArray.getFloat(index, keyCycle.mRotationY);
                        break;
                    case 14:
                        keyCycle.mTransitionPathRotate = typedArray.getFloat(index, keyCycle.mTransitionPathRotate);
                        break;
                    case 15:
                        keyCycle.mScaleX = typedArray.getFloat(index, keyCycle.mScaleX);
                        break;
                    case 16:
                        keyCycle.mScaleY = typedArray.getFloat(index, keyCycle.mScaleY);
                        break;
                    case 17:
                        keyCycle.mTranslationX = typedArray.getDimension(index, keyCycle.mTranslationX);
                        break;
                    case 18:
                        keyCycle.mTranslationY = typedArray.getDimension(index, keyCycle.mTranslationY);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT >= 21) {
                            keyCycle.mTranslationZ = typedArray.getDimension(index, keyCycle.mTranslationZ);
                            break;
                        } else {
                            break;
                        }
                    case 20:
                        keyCycle.mProgress = typedArray.getFloat(index, keyCycle.mProgress);
                        break;
                    case 21:
                        keyCycle.mWavePhase = typedArray.getFloat(index, keyCycle.mWavePhase) / 360.0f;
                        break;
                    default:
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + mAttrMap.get(index));
                        break;
                }
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        char c;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals(Key.MOTIONPROGRESS)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -1249320806:
                if (str.equals(Key.ROTATION_X)) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case -1249320805:
                if (str.equals(Key.ROTATION_Y)) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case -1225497657:
                if (str.equals(Key.TRANSLATION_X)) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1225497656:
                if (str.equals(Key.TRANSLATION_Y)) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case -1225497655:
                if (str.equals(Key.TRANSLATION_Z)) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case -908189618:
                if (str.equals(Key.SCALE_X)) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case -908189617:
                if (str.equals(Key.SCALE_Y)) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -40300674:
                if (str.equals(Key.ROTATION)) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case -4379043:
                if (str.equals(Key.ELEVATION)) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 37232917:
                if (str.equals(Key.TRANSITION_PATH_ROTATE)) {
                    c = '\n';
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
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case 184161818:
                if (str.equals("wavePeriod")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 579057826:
                if (str.equals(Key.CURVEFIT)) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1532805160:
                if (str.equals("waveShape")) {
                    c = 17;
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
                this.mAlpha = toFloat(obj);
                return;
            case 1:
                this.mCurveFit = toInt(obj);
                return;
            case 2:
                this.mElevation = toFloat(obj);
                return;
            case 3:
                this.mProgress = toFloat(obj);
                return;
            case 4:
                this.mRotation = toFloat(obj);
                return;
            case 5:
                this.mRotationX = toFloat(obj);
                return;
            case 6:
                this.mRotationY = toFloat(obj);
                return;
            case 7:
                this.mScaleX = toFloat(obj);
                return;
            case '\b':
                this.mScaleY = toFloat(obj);
                return;
            case '\t':
                this.mTransitionEasing = obj.toString();
                return;
            case '\n':
                this.mTransitionPathRotate = toFloat(obj);
                return;
            case 11:
                this.mTranslationX = toFloat(obj);
                return;
            case '\f':
                this.mTranslationY = toFloat(obj);
                return;
            case '\r':
                this.mTranslationZ = toFloat(obj);
                return;
            case 14:
                this.mWavePeriod = toFloat(obj);
                return;
            case 15:
                this.mWaveOffset = toFloat(obj);
                return;
            case 16:
                this.mWavePhase = toFloat(obj);
                return;
            case 17:
                if (obj instanceof Integer) {
                    this.mWaveShape = toInt(obj);
                    return;
                }
                this.mWaveShape = 7;
                this.mCustomWaveShpe = obj.toString();
                return;
            default:
                return;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.mTransitionEasing = keyCycle.mTransitionEasing;
        this.mCurveFit = keyCycle.mCurveFit;
        this.mWaveShape = keyCycle.mWaveShape;
        this.mCustomWaveShpe = keyCycle.mCustomWaveShpe;
        this.mWavePeriod = keyCycle.mWavePeriod;
        this.mWaveOffset = keyCycle.mWaveOffset;
        this.mWavePhase = keyCycle.mWavePhase;
        this.mProgress = keyCycle.mProgress;
        this.mWaveVariesBy = keyCycle.mWaveVariesBy;
        this.mAlpha = keyCycle.mAlpha;
        this.mElevation = keyCycle.mElevation;
        this.mRotation = keyCycle.mRotation;
        this.mTransitionPathRotate = keyCycle.mTransitionPathRotate;
        this.mRotationX = keyCycle.mRotationX;
        this.mRotationY = keyCycle.mRotationY;
        this.mScaleX = keyCycle.mScaleX;
        this.mScaleY = keyCycle.mScaleY;
        this.mTranslationX = keyCycle.mTranslationX;
        this.mTranslationY = keyCycle.mTranslationY;
        this.mTranslationZ = keyCycle.mTranslationZ;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo2clone() {
        return new KeyCycle().copy(this);
    }
}
