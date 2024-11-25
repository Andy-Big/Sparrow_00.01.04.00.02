package com.scwang.smartrefresh.header.internal;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import androidx.core.view.ViewCompat;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    private static final int ANIMATION_DURATION = 1332;
    private static final byte ARROW_HEIGHT = 5;
    private static final byte ARROW_HEIGHT_LARGE = 6;
    private static final float ARROW_OFFSET_ANGLE = 5.0f;
    private static final byte ARROW_WIDTH = 10;
    private static final byte ARROW_WIDTH_LARGE = 12;
    private static final float CENTER_RADIUS = 8.75f;
    private static final float CENTER_RADIUS_LARGE = 12.5f;
    private static final byte CIRCLE_DIAMETER = 40;
    private static final byte CIRCLE_DIAMETER_LARGE = 56;
    private static final float COLOR_START_DELAY_OFFSET = 0.75f;
    public static final byte DEFAULT = 1;
    private static final float END_TRIM_START_DELAY_OFFSET = 0.5f;
    private static final float FULL_ROTATION = 1080.0f;
    public static final byte LARGE = 0;
    private static final float MAX_PROGRESS_ARC = 0.8f;
    private static final byte NUM_POINTS = 5;
    private static final float START_TRIM_DURATION_OFFSET = 0.5f;
    private static final float STROKE_WIDTH = 2.5f;
    private static final float STROKE_WIDTH_LARGE = 3.0f;
    private Animation mAnimation;
    boolean mFinishing;
    private float mHeight;
    private View mParent;
    private float mRotation;
    float mRotationCount;
    private float mWidth;
    private static final Interpolator LINEAR_INTERPOLATOR = new LinearInterpolator();
    static final Interpolator MATERIAL_INTERPOLATOR = new FastOutSlowInInterpolator();
    private static final int[] COLORS = {ViewCompat.MEASURED_STATE_MASK};
    private final List<Animation> mAnimators = new ArrayList();
    private final Ring mRing = new Ring();

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface ProgressDrawableSize {
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public MaterialProgressDrawable(View view) {
        this.mParent = view;
        setColorSchemeColors(COLORS);
        updateSizes(1);
        setupAnimators();
    }

    private void setSizeParameters(int i, int i2, float f, float f2, float f3, float f4) {
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        this.mWidth = i * f5;
        this.mHeight = i2 * f5;
        this.mRing.setColorIndex(0);
        float f6 = f2 * f5;
        this.mRing.mPaint.setStrokeWidth(f6);
        this.mRing.mStrokeWidth = f6;
        this.mRing.mRingCenterRadius = f * f5;
        this.mRing.mArrowWidth = (int) (f3 * f5);
        this.mRing.mArrowHeight = (int) (f4 * f5);
        this.mRing.setInsets((int) this.mWidth, (int) this.mHeight);
        invalidateSelf();
    }

    public void updateSizes(int i) {
        if (i == 0) {
            setSizeParameters(56, 56, CENTER_RADIUS_LARGE, 3.0f, 12.0f, 6.0f);
        } else {
            setSizeParameters(40, 40, CENTER_RADIUS, STROKE_WIDTH, 10.0f, ARROW_OFFSET_ANGLE);
        }
    }

    public void showArrow(boolean z) {
        if (this.mRing.mShowArrow != z) {
            this.mRing.mShowArrow = z;
            invalidateSelf();
        }
    }

    public void setArrowScale(float f) {
        if (this.mRing.mArrowScale != f) {
            this.mRing.mArrowScale = f;
            invalidateSelf();
        }
    }

    public void setStartEndTrim(float f, float f2) {
        this.mRing.mStartTrim = f;
        this.mRing.mEndTrim = f2;
        invalidateSelf();
    }

    public void setProgressRotation(float f) {
        this.mRing.mRotation = f;
        invalidateSelf();
    }

    public void setBackgroundColor(int i) {
        this.mRing.mBackgroundColor = i;
    }

    public void setColorSchemeColors(int... iArr) {
        this.mRing.mColors = iArr;
        this.mRing.setColorIndex(0);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.mHeight;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return (int) this.mWidth;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.mRotation, bounds.exactCenterX(), bounds.exactCenterY());
        this.mRing.draw(canvas, bounds);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.mRing.mAlpha = i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.mRing.mAlpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.mRing.mPaint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    void setRotation(float f) {
        this.mRotation = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        List<Animation> list = this.mAnimators;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Animation animation = list.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.mAnimation.reset();
        this.mRing.storeOriginals();
        if (this.mRing.mEndTrim != this.mRing.mStartTrim) {
            this.mFinishing = true;
            this.mAnimation.setDuration(666L);
            this.mParent.startAnimation(this.mAnimation);
            return;
        }
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        this.mAnimation.setDuration(1332L);
        this.mParent.startAnimation(this.mAnimation);
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.mParent.clearAnimation();
        this.mRing.setColorIndex(0);
        this.mRing.resetOriginals();
        showArrow(false);
        setRotation(0.0f);
    }

    float getMinProgressArc(Ring ring) {
        return (float) Math.toRadians(ring.mStrokeWidth / (ring.mRingCenterRadius * 6.283185307179586d));
    }

    private int evaluateColorChange(float f, int i, int i2) {
        int intValue = Integer.valueOf(i).intValue();
        int i3 = (intValue >> 24) & 255;
        int i4 = (intValue >> 16) & 255;
        int i5 = (intValue >> 8) & 255;
        int i6 = intValue & 255;
        int intValue2 = Integer.valueOf(i2).intValue();
        return ((i3 + ((int) ((((intValue2 >> 24) & 255) - i3) * f))) << 24) | ((i4 + ((int) ((((intValue2 >> 16) & 255) - i4) * f))) << 16) | ((i5 + ((int) ((((intValue2 >> 8) & 255) - i5) * f))) << 8) | (i6 + ((int) (f * ((intValue2 & 255) - i6))));
    }

    void updateRingColor(float f, Ring ring) {
        if (f > COLOR_START_DELAY_OFFSET) {
            ring.mCurrentColor = evaluateColorChange((f - COLOR_START_DELAY_OFFSET) / 0.25f, ring.getStartingColor(), ring.getNextColor());
        }
    }

    void applyFinishTranslation(float f, Ring ring) {
        updateRingColor(f, ring);
        setStartEndTrim(ring.mStartingStartTrim + (((ring.mStartingEndTrim - getMinProgressArc(ring)) - ring.mStartingStartTrim) * f), ring.mStartingEndTrim);
        setProgressRotation(ring.mStartingRotation + ((((float) (Math.floor(ring.mStartingRotation / MAX_PROGRESS_ARC) + 1.0d)) - ring.mStartingRotation) * f));
    }

    private void setupAnimators() {
        final Ring ring = this.mRing;
        Animation animation = new Animation() { // from class: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                if (MaterialProgressDrawable.this.mFinishing) {
                    MaterialProgressDrawable.this.applyFinishTranslation(f, ring);
                    return;
                }
                float minProgressArc = MaterialProgressDrawable.this.getMinProgressArc(ring);
                float f2 = ring.mStartingEndTrim;
                float f3 = ring.mStartingStartTrim;
                float f4 = ring.mStartingRotation;
                MaterialProgressDrawable.this.updateRingColor(f, ring);
                if (f <= 0.5f) {
                    ring.mStartTrim = f3 + ((MaterialProgressDrawable.MAX_PROGRESS_ARC - minProgressArc) * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation(f / 0.5f));
                }
                if (f > 0.5f) {
                    float f5 = MaterialProgressDrawable.MAX_PROGRESS_ARC - minProgressArc;
                    ring.mEndTrim = f2 + (f5 * MaterialProgressDrawable.MATERIAL_INTERPOLATOR.getInterpolation((f - 0.5f) / 0.5f));
                }
                MaterialProgressDrawable.this.setProgressRotation(f4 + (0.25f * f));
                MaterialProgressDrawable.this.setRotation((f * 216.0f) + ((MaterialProgressDrawable.this.mRotationCount / MaterialProgressDrawable.ARROW_OFFSET_ANGLE) * MaterialProgressDrawable.FULL_ROTATION));
            }
        };
        animation.setRepeatCount(-1);
        animation.setRepeatMode(1);
        animation.setInterpolator(LINEAR_INTERPOLATOR);
        animation.setAnimationListener(new Animation.AnimationListener() { // from class: com.scwang.smartrefresh.header.internal.MaterialProgressDrawable.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation2) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation2) {
                MaterialProgressDrawable.this.mRotationCount = 0.0f;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation2) {
                ring.storeOriginals();
                ring.goToNextColor();
                Ring ring2 = ring;
                ring2.mStartTrim = ring2.mEndTrim;
                if (MaterialProgressDrawable.this.mFinishing) {
                    MaterialProgressDrawable.this.mFinishing = false;
                    animation2.setDuration(1332L);
                    MaterialProgressDrawable.this.showArrow(false);
                    return;
                }
                MaterialProgressDrawable materialProgressDrawable = MaterialProgressDrawable.this;
                materialProgressDrawable.mRotationCount = (materialProgressDrawable.mRotationCount + 1.0f) % MaterialProgressDrawable.ARROW_OFFSET_ANGLE;
            }
        });
        this.mAnimation = animation;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class Ring {
        int mAlpha;
        Path mArrow;
        int mArrowHeight;
        float mArrowScale;
        int mArrowWidth;
        int mBackgroundColor;
        int mColorIndex;
        int[] mColors;
        int mCurrentColor;
        double mRingCenterRadius;
        boolean mShowArrow;
        float mStartingEndTrim;
        float mStartingRotation;
        float mStartingStartTrim;
        final RectF mTempBounds = new RectF();
        final Paint mPaint = new Paint();
        final Paint mArrowPaint = new Paint();
        float mStartTrim = 0.0f;
        float mEndTrim = 0.0f;
        float mRotation = 0.0f;
        float mStrokeWidth = MaterialProgressDrawable.ARROW_OFFSET_ANGLE;
        float mStrokeInset = MaterialProgressDrawable.STROKE_WIDTH;
        final Paint mCirclePaint = new Paint(1);

        Ring() {
            this.mPaint.setStrokeCap(Paint.Cap.SQUARE);
            this.mPaint.setAntiAlias(true);
            this.mPaint.setStyle(Paint.Style.STROKE);
            this.mArrowPaint.setStyle(Paint.Style.FILL);
            this.mArrowPaint.setAntiAlias(true);
        }

        public void draw(Canvas canvas, Rect rect) {
            RectF rectF = this.mTempBounds;
            rectF.set(rect);
            float f = this.mStrokeInset;
            rectF.inset(f, f);
            float f2 = this.mStartTrim;
            float f3 = this.mRotation;
            float f4 = (f2 + f3) * 360.0f;
            float f5 = ((this.mEndTrim + f3) * 360.0f) - f4;
            if (f5 != 0.0f) {
                this.mPaint.setColor(this.mCurrentColor);
                canvas.drawArc(rectF, f4, f5, false, this.mPaint);
            }
            drawTriangle(canvas, f4, f5, rect);
            if (this.mAlpha < 255) {
                this.mCirclePaint.setColor(this.mBackgroundColor);
                this.mCirclePaint.setAlpha(255 - this.mAlpha);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), rect.width() / 2, this.mCirclePaint);
            }
        }

        private void drawTriangle(Canvas canvas, float f, float f2, Rect rect) {
            if (this.mShowArrow) {
                Path path = this.mArrow;
                if (path == null) {
                    Path path2 = new Path();
                    this.mArrow = path2;
                    path2.setFillType(Path.FillType.EVEN_ODD);
                } else {
                    path.reset();
                }
                float f3 = (((int) this.mStrokeInset) / 2) * this.mArrowScale;
                float sin = (float) ((this.mRingCenterRadius * Math.sin(0.0d)) + rect.exactCenterY());
                this.mArrow.moveTo(0.0f, 0.0f);
                this.mArrow.lineTo(this.mArrowWidth * this.mArrowScale, 0.0f);
                Path path3 = this.mArrow;
                float f4 = this.mArrowScale;
                path3.lineTo((this.mArrowWidth * f4) / 2.0f, this.mArrowHeight * f4);
                this.mArrow.offset(((float) ((this.mRingCenterRadius * Math.cos(0.0d)) + rect.exactCenterX())) - f3, sin);
                this.mArrow.close();
                this.mArrowPaint.setColor(this.mCurrentColor);
                canvas.rotate((f + f2) - MaterialProgressDrawable.ARROW_OFFSET_ANGLE, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.mArrow, this.mArrowPaint);
            }
        }

        public void setColorIndex(int i) {
            this.mColorIndex = i;
            this.mCurrentColor = this.mColors[i];
        }

        public int getNextColor() {
            return this.mColors[getNextColorIndex()];
        }

        private int getNextColorIndex() {
            return (this.mColorIndex + 1) % this.mColors.length;
        }

        public void goToNextColor() {
            setColorIndex(getNextColorIndex());
        }

        public int getStartingColor() {
            return this.mColors[this.mColorIndex];
        }

        public void setInsets(int i, int i2) {
            float min = Math.min(i, i2);
            double d = this.mRingCenterRadius;
            this.mStrokeInset = (float) ((d <= 0.0d || min < 0.0f) ? Math.ceil(this.mStrokeWidth / 2.0f) : (min / 2.0f) - d);
        }

        public void storeOriginals() {
            this.mStartingStartTrim = this.mStartTrim;
            this.mStartingEndTrim = this.mEndTrim;
            this.mStartingRotation = this.mRotation;
        }

        public void resetOriginals() {
            this.mStartingStartTrim = 0.0f;
            this.mStartingEndTrim = 0.0f;
            this.mStartingRotation = 0.0f;
            this.mStartTrim = 0.0f;
            this.mEndTrim = 0.0f;
            this.mRotation = 0.0f;
        }
    }
}
