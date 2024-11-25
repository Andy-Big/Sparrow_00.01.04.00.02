package com.scwang.smartrefresh.header;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.header.internal.pathview.PathsDrawable;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.scwang.smartrefresh.layout.util.DensityUtil;
/* loaded from: classes2.dex */
public class DropBoxHeader extends InternalAbstract implements RefreshHeader {
    protected int mAccentColor;
    protected BoxBody mBoxBody;
    protected Drawable mDrawable1;
    protected Drawable mDrawable2;
    protected Drawable mDrawable3;
    protected ValueAnimator mDropOutAnimator;
    protected boolean mDropOutOverFlow;
    protected float mDropOutPercent;
    protected int mHeaderHeight;
    protected Paint mPaint;
    protected Path mPath;
    protected ValueAnimator mReboundAnimator;
    protected float mReboundPercent;
    protected RefreshState mState;
    protected static String[] drawable1Paths = {"M3 2h18v20h-18z", "m4,1c-1.105,0 -2,0.895 -2,2v3,11 3,1c0,1.105 0.895,2 2,2h2,12 2c1.105,0 2,-0.895 2,-2v-1,-3 -11,-3c0,-1.105 -0.895,-2 -2,-2h-2,-12 -2zM3.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,3h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,6h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,9h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,12h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,15h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM3.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5zM19.5,18h1c0.276,0 0.5,0.224 0.5,0.5v1c0,0.276 -0.224,0.5 -0.5,0.5h-1c-0.276,0 -0.5,-0.224 -0.5,-0.5v-1c0,-0.276 0.224,-0.5 0.5,-0.5z"};
    protected static int[] drawable1Colors = {-1249039, -245496};
    protected static String[] drawable2Paths = {"M49,16.5l-14,-14l-27,0l0,53l41,0z", "m16,23.5h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,21.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "m16,15.5h10c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1L16,13.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1z", "M41,29.5L16,29.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,37.5L16,37.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M41,45.5L16,45.5c-0.55,0 -1,0.45 -1,1 0,0.55 0.45,1 1,1h25c0.55,0 1,-0.45 1,-1 0,-0.55 -0.45,-1 -1,-1z", "M49,16.5l-14,-14l0,14z"};
    protected static int[] drawable2Colors = {-76695, -2773417};
    protected static String[] drawable3Paths = {"M6.021,2.188L6.021,11.362C5.46,11.327 4.843,11.414 4.229,11.663C2.624,12.312 1.696,13.729 2.155,14.825C2.62,15.924 4.294,16.284 5.898,15.634C7.131,15.134 7.856,14.184 7.965,13.272L7.958,4.387L15.02,3.028L15.02,9.406C14.422,9.343 13.746,9.432 13.076,9.703C11.471,10.353 10.544,11.77 11.004,12.866C11.467,13.964 13.141,14.325 14.746,13.675C15.979,13.174 16.836,12.224 16.947,11.313L16.958,0.002L6.021,2.188L6.021,2.188Z"};
    protected static int[] drawable3Colors = {-6760607};

    public DropBoxHeader(Context context) {
        this(context, null);
    }

    public DropBoxHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DropBoxHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mPaint = new Paint();
        this.mBoxBody = new BoxBody();
        this.mPaint.setAntiAlias(true);
        this.mAccentColor = -9524737;
        setBackgroundColor(-14141883);
        setMinimumHeight(DensityUtil.dp2px(150.0f));
        this.mSpinnerStyle = SpinnerStyle.Scale;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DropBoxHeader);
        if (obtainStyledAttributes.hasValue(R.styleable.DropBoxHeader_dhDrawable1)) {
            this.mDrawable1 = obtainStyledAttributes.getDrawable(R.styleable.DropBoxHeader_dhDrawable1);
        } else {
            PathsDrawable pathsDrawable = new PathsDrawable();
            pathsDrawable.parserColors(drawable1Colors);
            if (!pathsDrawable.parserPaths(drawable1Paths)) {
                pathsDrawable.declareOriginal(2, 1, 20, 22);
            }
            this.mDrawable1 = pathsDrawable;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.DropBoxHeader_dhDrawable2)) {
            this.mDrawable2 = obtainStyledAttributes.getDrawable(R.styleable.DropBoxHeader_dhDrawable2);
        } else {
            PathsDrawable pathsDrawable2 = new PathsDrawable();
            pathsDrawable2.parserColors(drawable2Colors);
            if (!pathsDrawable2.parserPaths(drawable2Paths)) {
                pathsDrawable2.declareOriginal(8, 3, 41, 53);
            }
            this.mDrawable2 = pathsDrawable2;
        }
        if (obtainStyledAttributes.hasValue(R.styleable.DropBoxHeader_dhDrawable3)) {
            this.mDrawable3 = obtainStyledAttributes.getDrawable(R.styleable.DropBoxHeader_dhDrawable3);
        } else {
            PathsDrawable pathsDrawable3 = new PathsDrawable();
            pathsDrawable3.parserColors(drawable3Colors);
            if (!pathsDrawable3.parserPaths(drawable3Paths)) {
                pathsDrawable3.declareOriginal(2, 0, 15, 16);
            }
            this.mDrawable3 = pathsDrawable3;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f, 0.0f);
        this.mReboundAnimator = ofFloat;
        ofFloat.setInterpolator(accelerateInterpolator);
        this.mReboundAnimator.setDuration(300L);
        this.mReboundAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.header.DropBoxHeader.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                DropBoxHeader dropBoxHeader = DropBoxHeader.this;
                dropBoxHeader.mReboundPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                dropBoxHeader.invalidate();
            }
        });
        this.mReboundAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.header.DropBoxHeader.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (DropBoxHeader.this.mState == RefreshState.Refreshing) {
                    if (DropBoxHeader.this.mDropOutAnimator != null) {
                        DropBoxHeader.this.mDropOutAnimator.start();
                        return;
                    }
                    return;
                }
                DropBoxHeader.this.mDropOutPercent = 0.0f;
            }
        });
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropOutAnimator = ofFloat2;
        ofFloat2.setInterpolator(accelerateInterpolator);
        this.mDropOutAnimator.setDuration(300L);
        this.mDropOutAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.scwang.smartrefresh.header.DropBoxHeader.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (DropBoxHeader.this.mDropOutPercent < 1.0f || DropBoxHeader.this.mDropOutPercent >= 3.0f) {
                    DropBoxHeader.this.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } else if (DropBoxHeader.this.mDropOutPercent < 2.0f) {
                    DropBoxHeader.this.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 1.0f;
                } else if (DropBoxHeader.this.mDropOutPercent < 3.0f) {
                    DropBoxHeader.this.mDropOutPercent = ((Float) valueAnimator.getAnimatedValue()).floatValue() + 2.0f;
                    if (DropBoxHeader.this.mDropOutPercent == 3.0f) {
                        DropBoxHeader.this.mDropOutOverFlow = true;
                    }
                }
                DropBoxHeader.this.invalidate();
            }
        });
        this.mDropOutAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.scwang.smartrefresh.header.DropBoxHeader.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (DropBoxHeader.this.mReboundAnimator != null) {
                    DropBoxHeader.this.mReboundAnimator.start();
                }
            }
        });
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.mReboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mReboundAnimator.removeAllListeners();
            this.mReboundAnimator = null;
        }
        ValueAnimator valueAnimator2 = this.mDropOutAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllUpdateListeners();
            this.mDropOutAnimator.removeAllListeners();
            this.mDropOutAnimator = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        BoxBody generateBoxBody = generateBoxBody(width, getHeight(), generateSideLength());
        this.mPaint.setColor(ColorUtils.setAlphaComponent(this.mAccentColor, 150));
        canvas.drawPath(generateBoxBodyPath(generateBoxBody), this.mPaint);
        this.mPaint.setColor(this.mAccentColor);
        canvas.drawPath(generateBoxCoverPath(generateBoxBody), this.mPaint);
        if (isInEditMode()) {
            this.mDropOutPercent = 2.5f;
        }
        if (this.mDropOutPercent > 0.0f) {
            canvas.clipPath(generateClipPath(generateBoxBody, width));
            float min = Math.min(this.mDropOutPercent, 1.0f);
            Rect bounds = this.mDrawable1.getBounds();
            int i = width / 2;
            bounds.offsetTo(i - (bounds.width() / 2), ((int) (((generateBoxBody.boxCenterY - (bounds.height() / 2)) + bounds.height()) * min)) - bounds.height());
            this.mDrawable1.draw(canvas);
            float min2 = Math.min(Math.max(this.mDropOutPercent - 1.0f, 0.0f), 1.0f);
            Rect bounds2 = this.mDrawable2.getBounds();
            bounds2.offsetTo(i - (bounds2.width() / 2), ((int) (((generateBoxBody.boxCenterY - (bounds2.height() / 2)) + bounds2.height()) * min2)) - bounds2.height());
            this.mDrawable2.draw(canvas);
            float min3 = Math.min(Math.max(this.mDropOutPercent - 2.0f, 0.0f), 1.0f);
            Rect bounds3 = this.mDrawable3.getBounds();
            bounds3.offsetTo(i - (bounds3.width() / 2), ((int) (((generateBoxBody.boxCenterY - (bounds3.height() / 2)) + bounds3.height()) * min3)) - bounds3.height());
            this.mDrawable3.draw(canvas);
            if (this.mDropOutOverFlow) {
                bounds.offsetTo(i - (bounds.width() / 2), generateBoxBody.boxCenterY - (bounds.height() / 2));
                this.mDrawable1.draw(canvas);
                bounds2.offsetTo(i - (bounds2.width() / 2), generateBoxBody.boxCenterY - (bounds2.height() / 2));
                this.mDrawable2.draw(canvas);
                bounds3.offsetTo(i - (bounds3.width() / 2), generateBoxBody.boxCenterY - (bounds3.height() / 2));
                this.mDrawable3.draw(canvas);
            }
        }
        super.dispatchDraw(canvas);
    }

    private int generateSideLength() {
        return this.mHeaderHeight / 5;
    }

    private Path generateClipPath(BoxBody boxBody, int i) {
        this.mPath.reset();
        this.mPath.lineTo(0.0f, boxBody.boxCenterTop);
        this.mPath.lineTo(boxBody.boxLeft, boxBody.boxCenterTop);
        this.mPath.lineTo(boxBody.boxCenterX, boxBody.boxCenterY);
        this.mPath.lineTo(boxBody.boxRight, boxBody.boxCenterTop);
        float f = i;
        this.mPath.lineTo(f, boxBody.boxCenterTop);
        this.mPath.lineTo(f, 0.0f);
        this.mPath.close();
        return this.mPath;
    }

    private BoxBody generateBoxBody(int i, int i2, int i3) {
        return this.mBoxBody.measure(i, i2, i3, i3 / 2);
    }

    private Path generateBoxCoverPath(BoxBody boxBody) {
        this.mPath.reset();
        double d = this.mReboundPercent * 1.2566370614359172d;
        float f = ((boxBody.boxCenterX - boxBody.boxLeft) * 4) / 5;
        double d2 = 1.0471975511965976d - (d / 2.0d);
        float sin = ((float) Math.sin(d2)) * f;
        float cos = ((float) Math.cos(d2)) * f;
        this.mPath.moveTo(boxBody.boxLeft, boxBody.boxCenterTop);
        this.mPath.lineTo(boxBody.boxCenterX, boxBody.boxTop);
        this.mPath.lineTo(boxBody.boxCenterX - sin, boxBody.boxTop - cos);
        this.mPath.lineTo(boxBody.boxLeft - sin, boxBody.boxCenterTop - cos);
        this.mPath.close();
        double d3 = d + 1.0471975511965976d;
        float sin2 = ((float) Math.sin(d3)) * f;
        float cos2 = ((float) Math.cos(d3)) * f;
        this.mPath.moveTo(boxBody.boxLeft, boxBody.boxCenterTop);
        this.mPath.lineTo(boxBody.boxCenterX, (boxBody.boxBottom + boxBody.boxTop) / 2);
        this.mPath.lineTo(boxBody.boxCenterX - sin2, ((boxBody.boxBottom + boxBody.boxTop) / 2) + cos2);
        this.mPath.lineTo(boxBody.boxLeft - sin2, boxBody.boxCenterTop + cos2);
        this.mPath.close();
        float sin3 = ((float) Math.sin(d2)) * f;
        float cos3 = ((float) Math.cos(d2)) * f;
        this.mPath.moveTo(boxBody.boxRight, boxBody.boxCenterTop);
        this.mPath.lineTo(boxBody.boxCenterX, boxBody.boxTop);
        this.mPath.lineTo(boxBody.boxCenterX + sin3, boxBody.boxTop - cos3);
        this.mPath.lineTo(boxBody.boxRight + sin3, boxBody.boxCenterTop - cos3);
        this.mPath.close();
        float sin4 = ((float) Math.sin(d3)) * f;
        float cos4 = f * ((float) Math.cos(d3));
        this.mPath.moveTo(boxBody.boxRight, boxBody.boxCenterTop);
        this.mPath.lineTo(boxBody.boxCenterX, (boxBody.boxBottom + boxBody.boxTop) / 2);
        this.mPath.lineTo(boxBody.boxCenterX + sin4, ((boxBody.boxBottom + boxBody.boxTop) / 2) + cos4);
        this.mPath.lineTo(boxBody.boxRight + sin4, boxBody.boxCenterTop + cos4);
        this.mPath.close();
        return this.mPath;
    }

    private Path generateBoxBodyPath(BoxBody boxBody) {
        this.mPath.reset();
        this.mPath.moveTo(boxBody.boxLeft, boxBody.boxCenterBottom);
        this.mPath.lineTo(boxBody.boxCenterX, boxBody.boxBottom);
        this.mPath.lineTo(boxBody.boxRight, boxBody.boxCenterBottom);
        this.mPath.quadTo(boxBody.boxRight + ((boxBody.boxSideLength / 2) * this.mReboundPercent), boxBody.boxCenterY, boxBody.boxRight, boxBody.boxCenterTop);
        this.mPath.lineTo(boxBody.boxCenterX, boxBody.boxTop);
        this.mPath.lineTo(boxBody.boxLeft, boxBody.boxCenterTop);
        this.mPath.quadTo(boxBody.boxLeft - ((boxBody.boxSideLength / 2) * this.mReboundPercent), boxBody.boxCenterY, boxBody.boxLeft, boxBody.boxCenterBottom);
        this.mPath.close();
        return this.mPath;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z && this.mState == RefreshState.Refreshing) {
            return;
        }
        this.mReboundPercent = (Math.max(0, i - i2) * 1.0f) / i3;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.listener.OnStateChangedListener
    public void onStateChanged(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.mState = refreshState2;
        if (refreshState2 == RefreshState.None) {
            this.mDropOutOverFlow = false;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(int... iArr) {
        if (iArr.length > 0) {
            setBackgroundColor(iArr[0]);
            if (iArr.length > 1) {
                this.mAccentColor = iArr[1];
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(RefreshKernel refreshKernel, int i, int i2) {
        this.mHeaderHeight = i;
        int generateSideLength = generateSideLength();
        this.mDrawable1.setBounds(0, 0, generateSideLength, generateSideLength);
        this.mDrawable2.setBounds(0, 0, generateSideLength, generateSideLength);
        this.mDrawable3.setBounds(0, 0, generateSideLength, generateSideLength);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onStartAnimator(RefreshLayout refreshLayout, int i, int i2) {
        ValueAnimator valueAnimator = this.mDropOutAnimator;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(RefreshLayout refreshLayout, boolean z) {
        this.mDropOutPercent = 0.0f;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class BoxBody {
        int boxBottom;
        int boxCenterBottom;
        int boxCenterTop;
        int boxCenterX;
        int boxCenterY;
        int boxLeft;
        int boxRight;
        int boxSideLength;
        int boxTop;

        private BoxBody() {
        }

        BoxBody measure(int i, int i2, int i3, int i4) {
            this.boxSideLength = i3;
            int i5 = i / 2;
            this.boxCenterX = i5;
            int i6 = i2 - i4;
            this.boxBottom = i6;
            this.boxTop = i6 - (i3 * 2);
            int sin = i5 - ((int) (i3 * Math.sin(1.0471975511965976d)));
            this.boxLeft = sin;
            int i7 = i3 / 2;
            this.boxCenterTop = this.boxTop + i7;
            int i8 = this.boxBottom;
            this.boxCenterBottom = i8 - i7;
            this.boxRight = i - sin;
            this.boxCenterY = i8 - i3;
            return this;
        }
    }
}
