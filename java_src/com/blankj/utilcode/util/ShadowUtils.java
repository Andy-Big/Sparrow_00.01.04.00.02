package com.blankj.utilcode.util;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.StateSet;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
/* loaded from: classes.dex */
public class ShadowUtils {
    private static final int SHADOW_TAG = -16;

    public static void apply(View... viewArr) {
        if (viewArr == null) {
            return;
        }
        for (View view : viewArr) {
            apply(view, new Config());
        }
    }

    public static void apply(View view, Config config) {
        if (view == null || config == null) {
            return;
        }
        Drawable background = view.getBackground();
        Object tag = view.getTag(SHADOW_TAG);
        if (tag instanceof Drawable) {
            ViewCompat.setBackground(view, (Drawable) tag);
            return;
        }
        Drawable apply = config.apply(background);
        ViewCompat.setBackground(view, apply);
        view.setTag(SHADOW_TAG, apply);
    }

    /* loaded from: classes.dex */
    public static class Config {
        private static final int SHADOW_COLOR_DEFAULT = 1140850688;
        private static final int SHADOW_SIZE = UtilsBridge.dp2px(8.0f);
        private float mShadowRadius = -1.0f;
        private float mShadowSizeNormal = -1.0f;
        private float mShadowSizePressed = -1.0f;
        private float mShadowMaxSizeNormal = -1.0f;
        private float mShadowMaxSizePressed = -1.0f;
        private int mShadowColorNormal = SHADOW_COLOR_DEFAULT;
        private int mShadowColorPressed = SHADOW_COLOR_DEFAULT;
        private boolean isCircle = false;

        public Config setShadowRadius(float f) {
            this.mShadowRadius = f;
            if (this.isCircle) {
                throw new IllegalArgumentException("Set circle needn't set radius.");
            }
            return this;
        }

        public Config setCircle() {
            this.isCircle = true;
            if (this.mShadowRadius == -1.0f) {
                return this;
            }
            throw new IllegalArgumentException("Set circle needn't set radius.");
        }

        public Config setShadowSize(int i) {
            return setShadowSize(i, i);
        }

        public Config setShadowSize(int i, int i2) {
            this.mShadowSizeNormal = i;
            this.mShadowSizePressed = i2;
            return this;
        }

        public Config setShadowMaxSize(int i) {
            return setShadowMaxSize(i, i);
        }

        public Config setShadowMaxSize(int i, int i2) {
            this.mShadowMaxSizeNormal = i;
            this.mShadowMaxSizePressed = i2;
            return this;
        }

        public Config setShadowColor(int i) {
            return setShadowColor(i, i);
        }

        public Config setShadowColor(int i, int i2) {
            this.mShadowColorNormal = i;
            this.mShadowColorPressed = i2;
            return this;
        }

        Drawable apply(Drawable drawable) {
            if (drawable == null) {
                drawable = new ColorDrawable(0);
            }
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = drawable;
            stateListDrawable.addState(new int[]{16842919}, new ShadowDrawable(drawable2, getShadowRadius(), getShadowSizeNormal(), getShadowMaxSizeNormal(), this.mShadowColorPressed, this.isCircle));
            stateListDrawable.addState(StateSet.WILD_CARD, new ShadowDrawable(drawable2, getShadowRadius(), getShadowSizePressed(), getShadowMaxSizePressed(), this.mShadowColorNormal, this.isCircle));
            return stateListDrawable;
        }

        private float getShadowRadius() {
            if (this.mShadowRadius < 0.0f) {
                this.mShadowRadius = 0.0f;
            }
            return this.mShadowRadius;
        }

        private float getShadowSizeNormal() {
            if (this.mShadowSizeNormal == -1.0f) {
                this.mShadowSizeNormal = SHADOW_SIZE;
            }
            return this.mShadowSizeNormal;
        }

        private float getShadowSizePressed() {
            if (this.mShadowSizePressed == -1.0f) {
                this.mShadowSizePressed = getShadowSizeNormal();
            }
            return this.mShadowSizePressed;
        }

        private float getShadowMaxSizeNormal() {
            if (this.mShadowMaxSizeNormal == -1.0f) {
                this.mShadowMaxSizeNormal = getShadowSizeNormal();
            }
            return this.mShadowMaxSizeNormal;
        }

        private float getShadowMaxSizePressed() {
            if (this.mShadowMaxSizePressed == -1.0f) {
                this.mShadowMaxSizePressed = getShadowSizePressed();
            }
            return this.mShadowMaxSizePressed;
        }
    }

    /* loaded from: classes.dex */
    public static class ShadowDrawable extends DrawableWrapper {
        private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
        private boolean isCircle;
        private boolean mAddPaddingForCorners;
        private RectF mContentBounds;
        private float mCornerRadius;
        private Paint mCornerShadowPaint;
        private Path mCornerShadowPath;
        private boolean mDirty;
        private Paint mEdgeShadowPaint;
        private float mMaxShadowSize;
        private float mRawMaxShadowSize;
        private float mRawShadowSize;
        private float mRotation;
        private float mShadowBottomScale;
        private final int mShadowEndColor;
        private float mShadowHorizScale;
        private float mShadowMultiplier;
        private float mShadowSize;
        private final int mShadowStartColor;
        private float mShadowTopScale;

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getChangingConfigurations() {
            return super.getChangingConfigurations();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ Drawable getCurrent() {
            return super.getCurrent();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
            return super.getIntrinsicHeight();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
            return super.getIntrinsicWidth();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getMinimumHeight() {
            return super.getMinimumHeight();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int getMinimumWidth() {
            return super.getMinimumWidth();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ int[] getState() {
            return super.getState();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ Region getTransparentRegion() {
            return super.getTransparentRegion();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper
        public /* bridge */ /* synthetic */ Drawable getWrappedDrawable() {
            return super.getWrappedDrawable();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
            super.invalidateDrawable(drawable);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
            return super.isAutoMirrored();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean isStateful() {
            return super.isStateful();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void jumpToCurrentState() {
            super.jumpToCurrentState();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            super.scheduleDrawable(drawable, runnable, j);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
            super.setAutoMirrored(z);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
            super.setChangingConfigurations(i);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
            super.setColorFilter(colorFilter);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setDither(boolean z) {
            super.setDither(z);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
            super.setFilterBitmap(z);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
            super.setHotspot(f, f2);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
            super.setHotspotBounds(i, i2, i3, i4);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
            return super.setState(iArr);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTint(int i) {
            super.setTint(i);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
            super.setTintList(colorStateList);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
            super.setTintMode(mode);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
            return super.setVisible(z, z2);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper
        public /* bridge */ /* synthetic */ void setWrappedDrawable(Drawable drawable) {
            super.setWrappedDrawable(drawable);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable.Callback
        public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            super.unscheduleDrawable(drawable, runnable);
        }

        public ShadowDrawable(Drawable drawable, float f, float f2, float f3, int i, boolean z) {
            super(drawable);
            this.mShadowMultiplier = 1.0f;
            this.mShadowTopScale = 1.0f;
            this.mShadowHorizScale = 1.0f;
            this.mShadowBottomScale = 1.0f;
            this.mDirty = true;
            this.mAddPaddingForCorners = false;
            this.mShadowStartColor = i;
            this.mShadowEndColor = i & ViewCompat.MEASURED_SIZE_MASK;
            this.isCircle = z;
            if (z) {
                this.mShadowMultiplier = 1.0f;
                this.mShadowTopScale = 1.0f;
                this.mShadowHorizScale = 1.0f;
                this.mShadowBottomScale = 1.0f;
            }
            Paint paint = new Paint(5);
            this.mCornerShadowPaint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.mCornerRadius = Math.round(f);
            this.mContentBounds = new RectF();
            Paint paint2 = new Paint(this.mCornerShadowPaint);
            this.mEdgeShadowPaint = paint2;
            paint2.setAntiAlias(false);
            setShadowSize(f2, f3);
        }

        private static int toEven(float f) {
            int round = Math.round(f);
            return round % 2 == 1 ? round - 1 : round;
        }

        public void setAddPaddingForCorners(boolean z) {
            this.mAddPaddingForCorners = z;
            invalidateSelf();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            super.setAlpha(i);
            this.mCornerShadowPaint.setAlpha(i);
            this.mEdgeShadowPaint.setAlpha(i);
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            this.mDirty = true;
        }

        void setShadowSize(float f, float f2) {
            if (f < 0.0f || f2 < 0.0f) {
                throw new IllegalArgumentException("invalid shadow size");
            }
            float even = toEven(f);
            float even2 = toEven(f2);
            if (even > even2) {
                even = even2;
            }
            if (this.mRawShadowSize == even && this.mRawMaxShadowSize == even2) {
                return;
            }
            this.mRawShadowSize = even;
            this.mRawMaxShadowSize = even2;
            this.mShadowSize = Math.round(even * this.mShadowMultiplier);
            this.mMaxShadowSize = even2;
            this.mDirty = true;
            invalidateSelf();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            int ceil = (int) Math.ceil(calculateVerticalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
            int ceil2 = (int) Math.ceil(calculateHorizontalPadding(this.mRawMaxShadowSize, this.mCornerRadius, this.mAddPaddingForCorners));
            rect.set(ceil2, ceil, ceil2, ceil);
            return true;
        }

        private float calculateVerticalPadding(float f, float f2, boolean z) {
            if (z) {
                return (float) ((f * this.mShadowMultiplier) + ((1.0d - COS_45) * f2));
            }
            return f * this.mShadowMultiplier;
        }

        private static float calculateHorizontalPadding(float f, float f2, boolean z) {
            return z ? (float) (f + ((1.0d - COS_45) * f2)) : f;
        }

        public void setCornerRadius(float f) {
            float round = Math.round(f);
            if (this.mCornerRadius == round) {
                return;
            }
            this.mCornerRadius = round;
            this.mDirty = true;
            invalidateSelf();
        }

        @Override // com.blankj.utilcode.util.ShadowUtils.DrawableWrapper, android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            if (this.mDirty) {
                buildComponents(getBounds());
                this.mDirty = false;
            }
            drawShadow(canvas);
            super.draw(canvas);
        }

        final void setRotation(float f) {
            if (this.mRotation != f) {
                this.mRotation = f;
                invalidateSelf();
            }
        }

        private void drawShadow(Canvas canvas) {
            int i;
            float f;
            int i2;
            float f2;
            float f3;
            float f4;
            if (this.isCircle) {
                int save = canvas.save();
                canvas.translate(this.mContentBounds.centerX(), this.mContentBounds.centerY());
                canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
                canvas.restoreToCount(save);
                return;
            }
            int save2 = canvas.save();
            canvas.rotate(this.mRotation, this.mContentBounds.centerX(), this.mContentBounds.centerY());
            float f5 = this.mCornerRadius;
            float f6 = (-f5) - this.mShadowSize;
            float f7 = f5 * 2.0f;
            boolean z = this.mContentBounds.width() - f7 > 0.0f;
            boolean z2 = this.mContentBounds.height() - f7 > 0.0f;
            float f8 = this.mRawShadowSize;
            float f9 = f8 - (this.mShadowTopScale * f8);
            float f10 = f8 - (this.mShadowHorizScale * f8);
            float f11 = f8 - (this.mShadowBottomScale * f8);
            int i3 = (f5 > 0.0f ? 1 : (f5 == 0.0f ? 0 : -1));
            float f12 = i3 == 0 ? 1.0f : f5 / (f10 + f5);
            float f13 = i3 == 0 ? 1.0f : f5 / (f9 + f5);
            float f14 = i3 == 0 ? 1.0f : f5 / (f11 + f5);
            int save3 = canvas.save();
            canvas.translate(this.mContentBounds.left + f5, this.mContentBounds.top + f5);
            canvas.scale(f12, f13);
            canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            if (z) {
                canvas.scale(1.0f / f12, 1.0f);
                i = save3;
                f = f14;
                i2 = save2;
                f2 = f13;
                canvas.drawRect(0.0f, f6, this.mContentBounds.width() - f7, -this.mCornerRadius, this.mEdgeShadowPaint);
            } else {
                i = save3;
                f = f14;
                i2 = save2;
                f2 = f13;
            }
            canvas.restoreToCount(i);
            int save4 = canvas.save();
            canvas.translate(this.mContentBounds.right - f5, this.mContentBounds.bottom - f5);
            float f15 = f;
            canvas.scale(f12, f15);
            canvas.rotate(180.0f);
            canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            if (z) {
                canvas.scale(1.0f / f12, 1.0f);
                f3 = f2;
                f4 = f15;
                canvas.drawRect(0.0f, f6, this.mContentBounds.width() - f7, -this.mCornerRadius, this.mEdgeShadowPaint);
            } else {
                f3 = f2;
                f4 = f15;
            }
            canvas.restoreToCount(save4);
            int save5 = canvas.save();
            canvas.translate(this.mContentBounds.left + f5, this.mContentBounds.bottom - f5);
            canvas.scale(f12, f4);
            canvas.rotate(270.0f);
            canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            if (z2) {
                canvas.scale(1.0f / f4, 1.0f);
                canvas.drawRect(0.0f, f6, this.mContentBounds.height() - f7, -this.mCornerRadius, this.mEdgeShadowPaint);
            }
            canvas.restoreToCount(save5);
            int save6 = canvas.save();
            canvas.translate(this.mContentBounds.right - f5, this.mContentBounds.top + f5);
            float f16 = f3;
            canvas.scale(f12, f16);
            canvas.rotate(90.0f);
            canvas.drawPath(this.mCornerShadowPath, this.mCornerShadowPaint);
            if (z2) {
                canvas.scale(1.0f / f16, 1.0f);
                canvas.drawRect(0.0f, f6, this.mContentBounds.height() - f7, -this.mCornerRadius, this.mEdgeShadowPaint);
            }
            canvas.restoreToCount(save6);
            canvas.restoreToCount(i2);
        }

        private void buildShadowCorners() {
            if (this.isCircle) {
                float width = (this.mContentBounds.width() / 2.0f) - 1.0f;
                float f = -width;
                RectF rectF = new RectF(f, f, width, width);
                RectF rectF2 = new RectF(rectF);
                float f2 = this.mShadowSize;
                rectF2.inset(-f2, -f2);
                Path path = this.mCornerShadowPath;
                if (path == null) {
                    this.mCornerShadowPath = new Path();
                } else {
                    path.reset();
                }
                this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
                this.mCornerShadowPath.moveTo(f, 0.0f);
                this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
                this.mCornerShadowPath.arcTo(rectF2, 180.0f, 180.0f, false);
                this.mCornerShadowPath.arcTo(rectF2, 0.0f, 180.0f, false);
                this.mCornerShadowPath.arcTo(rectF, 180.0f, 180.0f, false);
                this.mCornerShadowPath.arcTo(rectF, 0.0f, 180.0f, false);
                this.mCornerShadowPath.close();
                float f3 = -rectF2.top;
                if (f3 > 0.0f) {
                    this.mCornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f3, new int[]{0, this.mShadowStartColor, this.mShadowEndColor}, new float[]{0.0f, width / f3, 1.0f}, Shader.TileMode.CLAMP));
                    return;
                }
                return;
            }
            float f4 = this.mCornerRadius;
            RectF rectF3 = new RectF(-f4, -f4, f4, f4);
            RectF rectF4 = new RectF(rectF3);
            float f5 = this.mShadowSize;
            rectF4.inset(-f5, -f5);
            Path path2 = this.mCornerShadowPath;
            if (path2 == null) {
                this.mCornerShadowPath = new Path();
            } else {
                path2.reset();
            }
            this.mCornerShadowPath.setFillType(Path.FillType.EVEN_ODD);
            this.mCornerShadowPath.moveTo(-this.mCornerRadius, 0.0f);
            this.mCornerShadowPath.rLineTo(-this.mShadowSize, 0.0f);
            this.mCornerShadowPath.arcTo(rectF4, 180.0f, 90.0f, false);
            this.mCornerShadowPath.arcTo(rectF3, 270.0f, -90.0f, false);
            this.mCornerShadowPath.close();
            float f6 = -rectF4.top;
            if (f6 > 0.0f) {
                this.mCornerShadowPaint.setShader(new RadialGradient(0.0f, 0.0f, f6, new int[]{0, this.mShadowStartColor, this.mShadowEndColor}, new float[]{0.0f, this.mCornerRadius / f6, 1.0f}, Shader.TileMode.CLAMP));
            }
            this.mEdgeShadowPaint.setShader(new LinearGradient(0.0f, rectF3.top, 0.0f, rectF4.top, this.mShadowStartColor, this.mShadowEndColor, Shader.TileMode.CLAMP));
            this.mEdgeShadowPaint.setAntiAlias(false);
        }

        private void buildComponents(Rect rect) {
            if (this.isCircle) {
                this.mCornerRadius = rect.width() / 2;
            }
            float f = this.mRawMaxShadowSize * this.mShadowMultiplier;
            this.mContentBounds.set(rect.left + this.mRawMaxShadowSize, rect.top + f, rect.right - this.mRawMaxShadowSize, rect.bottom - f);
            getWrappedDrawable().setBounds((int) this.mContentBounds.left, (int) this.mContentBounds.top, (int) this.mContentBounds.right, (int) this.mContentBounds.bottom);
            buildShadowCorners();
        }

        public float getCornerRadius() {
            return this.mCornerRadius;
        }

        public void setShadowSize(float f) {
            setShadowSize(f, this.mRawMaxShadowSize);
        }

        public void setMaxShadowSize(float f) {
            setShadowSize(this.mRawShadowSize, f);
        }

        public float getShadowSize() {
            return this.mRawShadowSize;
        }

        public float getMaxShadowSize() {
            return this.mRawMaxShadowSize;
        }

        public float getMinWidth() {
            float f = this.mRawMaxShadowSize;
            return (Math.max(f, this.mCornerRadius + (f / 2.0f)) * 2.0f) + (this.mRawMaxShadowSize * 2.0f);
        }

        public float getMinHeight() {
            float f = this.mRawMaxShadowSize;
            return (Math.max(f, this.mCornerRadius + ((this.mShadowMultiplier * f) / 2.0f)) * 2.0f) + (this.mRawMaxShadowSize * this.mShadowMultiplier * 2.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class DrawableWrapper extends Drawable implements Drawable.Callback {
        private Drawable mDrawable;

        public DrawableWrapper(Drawable drawable) {
            setWrappedDrawable(drawable);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            this.mDrawable.draw(canvas);
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            this.mDrawable.setBounds(rect);
        }

        @Override // android.graphics.drawable.Drawable
        public void setChangingConfigurations(int i) {
            this.mDrawable.setChangingConfigurations(i);
        }

        @Override // android.graphics.drawable.Drawable
        public int getChangingConfigurations() {
            return this.mDrawable.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable
        public void setDither(boolean z) {
            this.mDrawable.setDither(z);
        }

        @Override // android.graphics.drawable.Drawable
        public void setFilterBitmap(boolean z) {
            this.mDrawable.setFilterBitmap(z);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
            this.mDrawable.setAlpha(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
            this.mDrawable.setColorFilter(colorFilter);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isStateful() {
            return this.mDrawable.isStateful();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setState(int[] iArr) {
            return this.mDrawable.setState(iArr);
        }

        @Override // android.graphics.drawable.Drawable
        public int[] getState() {
            return this.mDrawable.getState();
        }

        @Override // android.graphics.drawable.Drawable
        public void jumpToCurrentState() {
            DrawableCompat.jumpToCurrentState(this.mDrawable);
        }

        @Override // android.graphics.drawable.Drawable
        public Drawable getCurrent() {
            return this.mDrawable.getCurrent();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean setVisible(boolean z, boolean z2) {
            return super.setVisible(z, z2) || this.mDrawable.setVisible(z, z2);
        }

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return this.mDrawable.getOpacity();
        }

        @Override // android.graphics.drawable.Drawable
        public Region getTransparentRegion() {
            return this.mDrawable.getTransparentRegion();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return this.mDrawable.getIntrinsicWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return this.mDrawable.getIntrinsicHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return this.mDrawable.getMinimumWidth();
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return this.mDrawable.getMinimumHeight();
        }

        @Override // android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return this.mDrawable.getPadding(rect);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidateSelf();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            scheduleSelf(runnable, j);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            unscheduleSelf(runnable);
        }

        @Override // android.graphics.drawable.Drawable
        protected boolean onLevelChange(int i) {
            return this.mDrawable.setLevel(i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setAutoMirrored(boolean z) {
            DrawableCompat.setAutoMirrored(this.mDrawable, z);
        }

        @Override // android.graphics.drawable.Drawable
        public boolean isAutoMirrored() {
            return DrawableCompat.isAutoMirrored(this.mDrawable);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTint(int i) {
            DrawableCompat.setTint(this.mDrawable, i);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintList(ColorStateList colorStateList) {
            DrawableCompat.setTintList(this.mDrawable, colorStateList);
        }

        @Override // android.graphics.drawable.Drawable
        public void setTintMode(PorterDuff.Mode mode) {
            DrawableCompat.setTintMode(this.mDrawable, mode);
        }

        @Override // android.graphics.drawable.Drawable
        public void setHotspot(float f, float f2) {
            DrawableCompat.setHotspot(this.mDrawable, f, f2);
        }

        @Override // android.graphics.drawable.Drawable
        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            DrawableCompat.setHotspotBounds(this.mDrawable, i, i2, i3, i4);
        }

        public Drawable getWrappedDrawable() {
            return this.mDrawable;
        }

        public void setWrappedDrawable(Drawable drawable) {
            Drawable drawable2 = this.mDrawable;
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            this.mDrawable = drawable;
            if (drawable != null) {
                drawable.setCallback(this);
            }
        }
    }
}
