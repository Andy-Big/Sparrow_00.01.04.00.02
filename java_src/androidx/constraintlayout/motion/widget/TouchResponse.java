package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes.dex */
class TouchResponse {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-7f;
    static final int FLAG_DISABLE_POST_SCROLL = 1;
    static final int FLAG_DISABLE_SCROLL = 2;
    private static final int SEC_TO_MILLISECONDS = 1000;
    private static final int SIDE_BOTTOM = 3;
    private static final int SIDE_END = 6;
    private static final int SIDE_LEFT = 1;
    private static final int SIDE_MIDDLE = 4;
    private static final int SIDE_RIGHT = 2;
    private static final int SIDE_START = 5;
    private static final int SIDE_TOP = 0;
    private static final String TAG = "TouchResponse";
    private static final int TOUCH_DOWN = 1;
    private static final int TOUCH_END = 5;
    private static final int TOUCH_LEFT = 2;
    private static final int TOUCH_RIGHT = 3;
    private static final int TOUCH_START = 4;
    private static final int TOUCH_UP = 0;
    private float mLastTouchX;
    private float mLastTouchY;
    private final MotionLayout mMotionLayout;
    private static final float[][] TOUCH_SIDES = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] TOUCH_DIRECTION = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private int mTouchAnchorSide = 0;
    private int mTouchSide = 0;
    private int mOnTouchUp = 0;
    private int mTouchAnchorId = -1;
    private int mTouchRegionId = -1;
    private int mLimitBoundsTo = -1;
    private float mTouchAnchorY = 0.5f;
    private float mTouchAnchorX = 0.5f;
    float mRotateCenterX = 0.5f;
    float mRotateCenterY = 0.5f;
    private int mRotationCenterId = -1;
    boolean mIsRotateMode = false;
    private float mTouchDirectionX = 0.0f;
    private float mTouchDirectionY = 1.0f;
    private boolean mDragStarted = false;
    private float[] mAnchorDpDt = new float[2];
    private float mMaxVelocity = 4.0f;
    private float mMaxAcceleration = 1.2f;
    private boolean mMoveWhenScrollAtTop = true;
    private float mDragScale = 1.0f;
    private int mFlags = 0;
    private float mDragThreshold = 10.0f;

    TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.mMotionLayout = motionLayout;
        fillFromAttributeList(context, Xml.asAttributeSet(xmlPullParser));
    }

    public void setRTL(boolean z) {
        if (z) {
            float[][] fArr = TOUCH_DIRECTION;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = TOUCH_SIDES;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = TOUCH_DIRECTION;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = TOUCH_SIDES;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = TOUCH_SIDES;
        int i = this.mTouchAnchorSide;
        this.mTouchAnchorX = fArr5[i][0];
        this.mTouchAnchorY = fArr5[i][1];
        int i2 = this.mTouchSide;
        float[][] fArr6 = TOUCH_DIRECTION;
        if (i2 >= fArr6.length) {
            return;
        }
        this.mTouchDirectionX = fArr6[i2][0];
        this.mTouchDirectionY = fArr6[i2][1];
    }

    private void fillFromAttributeList(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        fill(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void fill(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.mTouchAnchorId = typedArray.getResourceId(index, this.mTouchAnchorId);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i2 = typedArray.getInt(index, this.mTouchAnchorSide);
                this.mTouchAnchorSide = i2;
                float[][] fArr = TOUCH_SIDES;
                this.mTouchAnchorX = fArr[i2][0];
                this.mTouchAnchorY = fArr[i2][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i3 = typedArray.getInt(index, this.mTouchSide);
                this.mTouchSide = i3;
                float[][] fArr2 = TOUCH_DIRECTION;
                if (i3 < fArr2.length) {
                    this.mTouchDirectionX = fArr2[i3][0];
                    this.mTouchDirectionY = fArr2[i3][1];
                } else {
                    this.mTouchDirectionY = Float.NaN;
                    this.mTouchDirectionX = Float.NaN;
                    this.mIsRotateMode = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.mMaxVelocity = typedArray.getFloat(index, this.mMaxVelocity);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.mMaxAcceleration = typedArray.getFloat(index, this.mMaxAcceleration);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.mMoveWhenScrollAtTop = typedArray.getBoolean(index, this.mMoveWhenScrollAtTop);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.mDragScale = typedArray.getFloat(index, this.mDragScale);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.mDragThreshold = typedArray.getFloat(index, this.mDragThreshold);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.mTouchRegionId = typedArray.getResourceId(index, this.mTouchRegionId);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.mOnTouchUp = typedArray.getInt(index, this.mOnTouchUp);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.mFlags = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.mLimitBoundsTo = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.mRotationCenterId = typedArray.getResourceId(index, this.mRotationCenterId);
            }
        }
    }

    void setUpTouchEvent(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
        this.mDragStarted = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0252  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void processTouchRotateEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i, MotionScene motionScene) {
        float left;
        int top;
        int bottom;
        float rawY;
        int i2;
        float f;
        int i3;
        float[] fArr;
        View findViewById;
        double atan2;
        float[] fArr2;
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            this.mDragStarted = false;
        } else if (action != 1) {
            if (action != 2) {
                return;
            }
            motionEvent.getRawY();
            motionEvent.getRawX();
            float width = this.mMotionLayout.getWidth() / 2.0f;
            float height = this.mMotionLayout.getHeight() / 2.0f;
            int i4 = this.mRotationCenterId;
            if (i4 != -1) {
                View findViewById2 = this.mMotionLayout.findViewById(i4);
                height = (findViewById2.getTop() + findViewById2.getBottom()) / 2.0f;
                width = (findViewById2.getLeft() + findViewById2.getRight()) / 2.0f;
            } else {
                int i5 = this.mTouchAnchorId;
                if (i5 != -1) {
                    if (this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(i5).getAnimateRelativeTo()) == null) {
                        Log.e(TAG, "could not find view to animate to");
                    } else {
                        width = (findViewById.getLeft() + findViewById.getRight()) / 2.0f;
                        height = (findViewById.getTop() + findViewById.getBottom()) / 2.0f;
                    }
                }
            }
            float rawX = motionEvent.getRawX() - width;
            float rawY2 = motionEvent.getRawY() - height;
            float atan22 = (float) (((Math.atan2(motionEvent.getRawY() - height, motionEvent.getRawX() - width) - Math.atan2(this.mLastTouchY - height, this.mLastTouchX - width)) * 180.0d) / 3.141592653589793d);
            if (atan22 > 330.0f) {
                atan22 -= 360.0f;
            } else if (atan22 < -330.0f) {
                atan22 += 360.0f;
            }
            if (Math.abs(atan22) > 0.01d || this.mDragStarted) {
                float progress = this.mMotionLayout.getProgress();
                if (!this.mDragStarted) {
                    this.mDragStarted = true;
                    this.mMotionLayout.setProgress(progress);
                }
                int i6 = this.mTouchAnchorId;
                if (i6 != -1) {
                    this.mMotionLayout.getAnchorDpDt(i6, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                    this.mAnchorDpDt[1] = (float) Math.toDegrees(fArr2[1]);
                } else {
                    this.mAnchorDpDt[1] = 360.0f;
                }
                float max = Math.max(Math.min(progress + ((atan22 * this.mDragScale) / this.mAnchorDpDt[1]), 1.0f), 0.0f);
                if (max != this.mMotionLayout.getProgress()) {
                    this.mMotionLayout.setProgress(max);
                    motionTracker.computeCurrentVelocity(1000);
                    float xVelocity = motionTracker.getXVelocity();
                    double yVelocity = motionTracker.getYVelocity();
                    double d = xVelocity;
                    this.mMotionLayout.mLastVelocity = (float) Math.toDegrees((float) ((Math.hypot(yVelocity, d) * Math.sin(Math.atan2(yVelocity, d) - atan2)) / Math.hypot(rawX, rawY2)));
                } else {
                    this.mMotionLayout.mLastVelocity = 0.0f;
                }
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
            }
        } else {
            this.mDragStarted = false;
            motionTracker.computeCurrentVelocity(16);
            float xVelocity2 = motionTracker.getXVelocity();
            float yVelocity2 = motionTracker.getYVelocity();
            float progress2 = this.mMotionLayout.getProgress();
            float width2 = this.mMotionLayout.getWidth() / 2.0f;
            float height2 = this.mMotionLayout.getHeight() / 2.0f;
            int i7 = this.mRotationCenterId;
            if (i7 != -1) {
                View findViewById3 = this.mMotionLayout.findViewById(i7);
                left = (findViewById3.getLeft() + findViewById3.getRight()) / 2.0f;
                top = findViewById3.getTop();
                bottom = findViewById3.getBottom();
            } else {
                int i8 = this.mTouchAnchorId;
                if (i8 != -1) {
                    View findViewById4 = this.mMotionLayout.findViewById(this.mMotionLayout.getMotionController(i8).getAnimateRelativeTo());
                    left = (findViewById4.getLeft() + findViewById4.getRight()) / 2.0f;
                    top = findViewById4.getTop();
                    bottom = findViewById4.getBottom();
                }
                float rawX2 = motionEvent.getRawX() - width2;
                double degrees = Math.toDegrees(Math.atan2(motionEvent.getRawY() - height2, rawX2));
                i2 = this.mTouchAnchorId;
                if (i2 == -1) {
                    this.mMotionLayout.getAnchorDpDt(i2, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                    this.mAnchorDpDt[1] = (float) Math.toDegrees(fArr[1]);
                } else {
                    this.mAnchorDpDt[1] = 360.0f;
                }
                float degrees2 = ((float) (Math.toDegrees(Math.atan2(yVelocity2 + rawY, xVelocity2 + rawX2)) - degrees)) * 62.5f;
                f = Float.isNaN(degrees2) ? (((degrees2 * 3.0f) * this.mDragScale) / this.mAnchorDpDt[1]) + progress2 : progress2;
                if (f != 0.0f || f == 1.0f || (i3 = this.mOnTouchUp) == 3) {
                    if (0.0f < f || 1.0f <= f) {
                        this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    }
                    return;
                }
                this.mMotionLayout.touchAnimateTo(i3, ((double) f) < 0.5d ? 0.0f : 1.0f, ((degrees2 * this.mDragScale) / this.mAnchorDpDt[1]) * 3.0f);
                if (0.0f >= progress2 || 1.0f <= progress2) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            float f2 = left;
            height2 = (top + bottom) / 2.0f;
            width2 = f2;
            float rawX22 = motionEvent.getRawX() - width2;
            double degrees3 = Math.toDegrees(Math.atan2(motionEvent.getRawY() - height2, rawX22));
            i2 = this.mTouchAnchorId;
            if (i2 == -1) {
            }
            float degrees22 = ((float) (Math.toDegrees(Math.atan2(yVelocity2 + rawY, xVelocity2 + rawX22)) - degrees3)) * 62.5f;
            if (Float.isNaN(degrees22)) {
            }
            if (f != 0.0f) {
            }
            if (0.0f < f) {
            }
            this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
        }
    }

    void processTouchEvent(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i, MotionScene motionScene) {
        float f;
        int i2;
        float f2;
        if (this.mIsRotateMode) {
            processTouchRotateEvent(motionEvent, motionTracker, i, motionScene);
            return;
        }
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mLastTouchX = motionEvent.getRawX();
            this.mLastTouchY = motionEvent.getRawY();
            this.mDragStarted = false;
        } else if (action == 1) {
            this.mDragStarted = false;
            motionTracker.computeCurrentVelocity(1000);
            float xVelocity = motionTracker.getXVelocity();
            float yVelocity = motionTracker.getYVelocity();
            float progress = this.mMotionLayout.getProgress();
            int i3 = this.mTouchAnchorId;
            if (i3 != -1) {
                this.mMotionLayout.getAnchorDpDt(i3, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
            } else {
                float min = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                float[] fArr = this.mAnchorDpDt;
                fArr[1] = this.mTouchDirectionY * min;
                fArr[0] = min * this.mTouchDirectionX;
            }
            float f3 = this.mTouchDirectionX;
            float[] fArr2 = this.mAnchorDpDt;
            float f4 = fArr2[0];
            float f5 = fArr2[1];
            if (f3 != 0.0f) {
                f = xVelocity / fArr2[0];
            } else {
                f = yVelocity / fArr2[1];
            }
            float f6 = !Float.isNaN(f) ? (f / 3.0f) + progress : progress;
            if (f6 == 0.0f || f6 == 1.0f || (i2 = this.mOnTouchUp) == 3) {
                if (0.0f >= f6 || 1.0f <= f6) {
                    this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            this.mMotionLayout.touchAnimateTo(i2, ((double) f6) < 0.5d ? 0.0f : 1.0f, f);
            if (0.0f >= progress || 1.0f <= progress) {
                this.mMotionLayout.setState(MotionLayout.TransitionState.FINISHED);
            }
        } else if (action != 2) {
        } else {
            float rawY = motionEvent.getRawY() - this.mLastTouchY;
            float rawX = motionEvent.getRawX() - this.mLastTouchX;
            if (Math.abs((this.mTouchDirectionX * rawX) + (this.mTouchDirectionY * rawY)) > this.mDragThreshold || this.mDragStarted) {
                float progress2 = this.mMotionLayout.getProgress();
                if (!this.mDragStarted) {
                    this.mDragStarted = true;
                    this.mMotionLayout.setProgress(progress2);
                }
                int i4 = this.mTouchAnchorId;
                if (i4 != -1) {
                    this.mMotionLayout.getAnchorDpDt(i4, progress2, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
                } else {
                    float min2 = Math.min(this.mMotionLayout.getWidth(), this.mMotionLayout.getHeight());
                    float[] fArr3 = this.mAnchorDpDt;
                    fArr3[1] = this.mTouchDirectionY * min2;
                    fArr3[0] = min2 * this.mTouchDirectionX;
                }
                float f7 = this.mTouchDirectionX;
                float[] fArr4 = this.mAnchorDpDt;
                if (Math.abs(((f7 * fArr4[0]) + (this.mTouchDirectionY * fArr4[1])) * this.mDragScale) < 0.01d) {
                    float[] fArr5 = this.mAnchorDpDt;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                if (this.mTouchDirectionX != 0.0f) {
                    f2 = rawX / this.mAnchorDpDt[0];
                } else {
                    f2 = rawY / this.mAnchorDpDt[1];
                }
                float max = Math.max(Math.min(progress2 + f2, 1.0f), 0.0f);
                if (max != this.mMotionLayout.getProgress()) {
                    this.mMotionLayout.setProgress(max);
                    motionTracker.computeCurrentVelocity(1000);
                    this.mMotionLayout.mLastVelocity = this.mTouchDirectionX != 0.0f ? motionTracker.getXVelocity() / this.mAnchorDpDt[0] : motionTracker.getYVelocity() / this.mAnchorDpDt[1];
                } else {
                    this.mMotionLayout.mLastVelocity = 0.0f;
                }
                this.mLastTouchX = motionEvent.getRawX();
                this.mLastTouchY = motionEvent.getRawY();
            }
        }
    }

    void setDown(float f, float f2) {
        this.mLastTouchX = f;
        this.mLastTouchY = f2;
    }

    float getProgressDirection(float f, float f2) {
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, this.mMotionLayout.getProgress(), this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        if (this.mTouchDirectionX != 0.0f) {
            float[] fArr = this.mAnchorDpDt;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f * this.mTouchDirectionX) / this.mAnchorDpDt[0];
        }
        float[] fArr2 = this.mAnchorDpDt;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f2 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
    }

    void scrollUp(float f, float f2) {
        float f3;
        this.mDragStarted = false;
        float progress = this.mMotionLayout.getProgress();
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f4 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        float f5 = fArr[0];
        float f6 = this.mTouchDirectionY;
        float f7 = fArr[1];
        if (f4 != 0.0f) {
            f3 = (f * f4) / fArr[0];
        } else {
            f3 = (f2 * f6) / fArr[1];
        }
        if (!Float.isNaN(f3)) {
            progress += f3 / 3.0f;
        }
        if (progress != 0.0f) {
            if ((this.mOnTouchUp != 3) && (progress != 1.0f)) {
                this.mMotionLayout.touchAnimateTo(this.mOnTouchUp, ((double) progress) >= 0.5d ? 1.0f : 0.0f, f3);
            }
        }
    }

    void scrollMove(float f, float f2) {
        float f3;
        float progress = this.mMotionLayout.getProgress();
        if (!this.mDragStarted) {
            this.mDragStarted = true;
            this.mMotionLayout.setProgress(progress);
        }
        this.mMotionLayout.getAnchorDpDt(this.mTouchAnchorId, progress, this.mTouchAnchorX, this.mTouchAnchorY, this.mAnchorDpDt);
        float f4 = this.mTouchDirectionX;
        float[] fArr = this.mAnchorDpDt;
        if (Math.abs((f4 * fArr[0]) + (this.mTouchDirectionY * fArr[1])) < 0.01d) {
            float[] fArr2 = this.mAnchorDpDt;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f5 = this.mTouchDirectionX;
        if (f5 != 0.0f) {
            f3 = (f * f5) / this.mAnchorDpDt[0];
        } else {
            f3 = (f2 * this.mTouchDirectionY) / this.mAnchorDpDt[1];
        }
        float max = Math.max(Math.min(progress + f3, 1.0f), 0.0f);
        if (max != this.mMotionLayout.getProgress()) {
            this.mMotionLayout.setProgress(max);
        }
    }

    void setupTouch() {
        View view;
        int i = this.mTouchAnchorId;
        if (i != -1) {
            view = this.mMotionLayout.findViewById(i);
            if (view == null) {
                Log.e(TAG, "cannot find TouchAnchorId @id/" + Debug.getName(this.mMotionLayout.getContext(), this.mTouchAnchorId));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view2, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView2, int i2, int i3, int i4, int i5) {
                }
            });
        }
    }

    public void setAnchorId(int i) {
        this.mTouchAnchorId = i;
    }

    public int getAnchorId() {
        return this.mTouchAnchorId;
    }

    public void setTouchAnchorLocation(float f, float f2) {
        this.mTouchAnchorX = f;
        this.mTouchAnchorY = f2;
    }

    public void setMaxVelocity(float f) {
        this.mMaxVelocity = f;
    }

    public void setMaxAcceleration(float f) {
        this.mMaxAcceleration = f;
    }

    float getMaxAcceleration() {
        return this.mMaxAcceleration;
    }

    public float getMaxVelocity() {
        return this.mMaxVelocity;
    }

    boolean getMoveWhenScrollAtTop() {
        return this.mMoveWhenScrollAtTop;
    }

    RectF getTouchRegion(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.mTouchRegionId;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    int getTouchRegionId() {
        return this.mTouchRegionId;
    }

    RectF getLimitBoundsTo(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.mLimitBoundsTo;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    int getLimitBoundsToId() {
        return this.mLimitBoundsTo;
    }

    float dot(float f, float f2) {
        return (f * this.mTouchDirectionX) + (f2 * this.mTouchDirectionY);
    }

    public String toString() {
        if (Float.isNaN(this.mTouchDirectionX)) {
            return Key.ROTATION;
        }
        return this.mTouchDirectionX + " , " + this.mTouchDirectionY;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public void setTouchUpMode(int i) {
        this.mOnTouchUp = i;
    }
}
