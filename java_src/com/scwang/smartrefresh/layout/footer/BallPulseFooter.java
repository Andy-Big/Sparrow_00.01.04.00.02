package com.scwang.smartrefresh.layout.footer;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class BallPulseFooter extends InternalAbstract implements RefreshFooter {
    public static final int DEFAULT_SIZE = 50;
    protected int mAnimatingColor;
    protected ArrayList<ValueAnimator> mAnimators;
    protected float mCircleSpacing;
    protected boolean mIsStarted;
    protected boolean mManualAnimationColor;
    protected boolean mManualNormalColor;
    protected int mNormalColor;
    protected Paint mPaint;
    protected float[] mScaleFloats;
    protected Map<ValueAnimator, ValueAnimator.AnimatorUpdateListener> mUpdateListeners;

    @Override // com.scwang.smartrefresh.layout.api.RefreshFooter
    public boolean setNoMoreData(boolean z) {
        return false;
    }

    public BallPulseFooter(Context context) {
        this(context, null);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BallPulseFooter(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNormalColor = -1118482;
        this.mAnimatingColor = -1615546;
        this.mScaleFloats = new float[]{1.0f, 1.0f, 1.0f};
        this.mIsStarted = false;
        this.mUpdateListeners = new HashMap();
        setMinimumHeight(DensityUtil.dp2px(60.0f));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BallPulseFooter);
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setAntiAlias(true);
        this.mSpinnerStyle = SpinnerStyle.Translate;
        this.mSpinnerStyle = SpinnerStyle.values()[obtainStyledAttributes.getInt(R.styleable.BallPulseFooter_srlClassicsSpinnerStyle, this.mSpinnerStyle.ordinal())];
        if (obtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlNormalColor)) {
            setNormalColor(obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlNormalColor, 0));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BallPulseFooter_srlAnimatingColor)) {
            setAnimatingColor(obtainStyledAttributes.getColor(R.styleable.BallPulseFooter_srlAnimatingColor, 0));
        }
        obtainStyledAttributes.recycle();
        this.mCircleSpacing = DensityUtil.dp2px(4.0f);
        this.mAnimators = new ArrayList<>();
        int[] iArr = {120, 240, 360};
        for (final int i2 = 0; i2 < 3; i2++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.3f, 1.0f);
            ofFloat.setDuration(750L);
            ofFloat.setRepeatCount(-1);
            ofFloat.setTarget(Integer.valueOf(i2));
            ofFloat.setStartDelay(iArr[i2]);
            this.mUpdateListeners.put(ofFloat, new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.layout.footer.BallPulseFooter.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallPulseFooter.this.mScaleFloats[i2] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    this.postInvalidate();
                }
            });
            this.mAnimators.add(ofFloat);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mAnimators != null) {
            for (int i = 0; i < this.mAnimators.size(); i++) {
                this.mAnimators.get(i).cancel();
                this.mAnimators.get(i).removeAllListeners();
                this.mAnimators.get(i).removeAllUpdateListeners();
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        float f = this.mCircleSpacing;
        float min = (Math.min(width, height) - (f * 2.0f)) / 6.0f;
        float f2 = 2.0f * min;
        float f3 = (width / 2) - (f + f2);
        float f4 = height / 2;
        for (int i = 0; i < 3; i++) {
            canvas.save();
            float f5 = i;
            canvas.translate((f2 * f5) + f3 + (this.mCircleSpacing * f5), f4);
            float[] fArr = this.mScaleFloats;
            canvas.scale(fArr[i], fArr[i]);
            canvas.drawCircle(0.0f, 0.0f, min, this.mPaint);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(RefreshLayout refreshLayout, int i, int i2) {
        if (this.mIsStarted) {
            return;
        }
        for (int i3 = 0; i3 < this.mAnimators.size(); i3++) {
            ValueAnimator valueAnimator = this.mAnimators.get(i3);
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mUpdateListeners.get(valueAnimator);
            if (animatorUpdateListener != null) {
                valueAnimator.addUpdateListener(animatorUpdateListener);
            }
            valueAnimator.start();
        }
        this.mIsStarted = true;
        this.mPaint.setColor(this.mAnimatingColor);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        ArrayList<ValueAnimator> arrayList = this.mAnimators;
        if (arrayList != null && this.mIsStarted) {
            this.mIsStarted = false;
            this.mScaleFloats = new float[]{1.0f, 1.0f, 1.0f};
            Iterator<ValueAnimator> it = arrayList.iterator();
            while (it.hasNext()) {
                ValueAnimator next = it.next();
                if (next != null) {
                    next.removeAllUpdateListeners();
                    next.end();
                }
            }
        }
        this.mPaint.setColor(this.mNormalColor);
        return 0;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (!this.mManualAnimationColor && iArr.length > 1) {
            setAnimatingColor(iArr[0]);
            this.mManualAnimationColor = false;
        }
        if (this.mManualNormalColor) {
            return;
        }
        if (iArr.length > 1) {
            setNormalColor(iArr[1]);
        } else if (iArr.length > 0) {
            setNormalColor(ColorUtils.compositeColors(-1711276033, iArr[0]));
        }
        this.mManualNormalColor = false;
    }

    public BallPulseFooter setSpinnerStyle(SpinnerStyle spinnerStyle) {
        this.mSpinnerStyle = spinnerStyle;
        return this;
    }

    public BallPulseFooter setNormalColor(int i) {
        this.mNormalColor = i;
        this.mManualNormalColor = true;
        if (!this.mIsStarted) {
            this.mPaint.setColor(i);
        }
        return this;
    }

    public BallPulseFooter setAnimatingColor(int i) {
        this.mAnimatingColor = i;
        this.mManualAnimationColor = true;
        if (this.mIsStarted) {
            this.mPaint.setColor(i);
        }
        return this;
    }
}
