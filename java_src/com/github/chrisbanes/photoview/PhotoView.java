package com.github.chrisbanes.photoview;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;

/* loaded from: classes.dex */
public class PhotoView extends AppCompatImageView {
    private PhotoViewAttacher attacher;
    private ImageView.ScaleType pendingScaleType;

    public PhotoView(Context context) {
        this(context, null);
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        this.attacher = new PhotoViewAttacher(this);
        super.setScaleType(ImageView.ScaleType.MATRIX);
        ImageView.ScaleType scaleType = this.pendingScaleType;
        if (scaleType != null) {
            setScaleType(scaleType);
            this.pendingScaleType = null;
        }
    }

    public PhotoViewAttacher getAttacher() {
        return this.attacher;
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.attacher.getScaleType();
    }

    @Override // android.widget.ImageView
    public Matrix getImageMatrix() {
        return this.attacher.getImageMatrix();
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.attacher.setOnLongClickListener(onLongClickListener);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.attacher.setOnClickListener(onClickListener);
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher == null) {
            this.pendingScaleType = scaleType;
        } else {
            photoViewAttacher.setScaleType(scaleType);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        super.setImageResource(i);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        PhotoViewAttacher photoViewAttacher = this.attacher;
        if (photoViewAttacher != null) {
            photoViewAttacher.update();
        }
    }

    @Override // android.widget.ImageView
    protected boolean setFrame(int i, int i2, int i3, int i4) {
        boolean frame = super.setFrame(i, i2, i3, i4);
        if (frame) {
            this.attacher.update();
        }
        return frame;
    }

    public void setRotationTo(float f) {
        this.attacher.setRotationTo(f);
    }

    public void setRotationBy(float f) {
        this.attacher.setRotationBy(f);
    }

    public boolean isZoomable() {
        return this.attacher.isZoomable();
    }

    public void setZoomable(boolean z) {
        this.attacher.setZoomable(z);
    }

    public RectF getDisplayRect() {
        return this.attacher.getDisplayRect();
    }

    public void getDisplayMatrix(Matrix matrix) {
        this.attacher.getDisplayMatrix(matrix);
    }

    public boolean setDisplayMatrix(Matrix matrix) {
        return this.attacher.setDisplayMatrix(matrix);
    }

    public void getSuppMatrix(Matrix matrix) {
        this.attacher.getSuppMatrix(matrix);
    }

    public boolean setSuppMatrix(Matrix matrix) {
        return this.attacher.setDisplayMatrix(matrix);
    }

    public float getMinimumScale() {
        return this.attacher.getMinimumScale();
    }

    public float getMediumScale() {
        return this.attacher.getMediumScale();
    }

    public float getMaximumScale() {
        return this.attacher.getMaximumScale();
    }

    public float getScale() {
        return this.attacher.getScale();
    }

    public void setAllowParentInterceptOnEdge(boolean z) {
        this.attacher.setAllowParentInterceptOnEdge(z);
    }

    public void setMinimumScale(float f) {
        this.attacher.setMinimumScale(f);
    }

    public void setMediumScale(float f) {
        this.attacher.setMediumScale(f);
    }

    public void setMaximumScale(float f) {
        this.attacher.setMaximumScale(f);
    }

    public void setScaleLevels(float f, float f2, float f3) {
        this.attacher.setScaleLevels(f, f2, f3);
    }

    public void setOnMatrixChangeListener(OnMatrixChangedListener onMatrixChangedListener) {
        this.attacher.setOnMatrixChangeListener(onMatrixChangedListener);
    }

    public void setOnPhotoTapListener(OnPhotoTapListener onPhotoTapListener) {
        this.attacher.setOnPhotoTapListener(onPhotoTapListener);
    }

    public void setOnOutsidePhotoTapListener(OnOutsidePhotoTapListener onOutsidePhotoTapListener) {
        this.attacher.setOnOutsidePhotoTapListener(onOutsidePhotoTapListener);
    }

    public void setOnViewTapListener(OnViewTapListener onViewTapListener) {
        this.attacher.setOnViewTapListener(onViewTapListener);
    }

    public void setOnViewDragListener(OnViewDragListener onViewDragListener) {
        this.attacher.setOnViewDragListener(onViewDragListener);
    }

    public void setScale(float f) {
        this.attacher.setScale(f);
    }

    public void setScale(float f, boolean z) {
        this.attacher.setScale(f, z);
    }

    public void setScale(float f, float f2, float f3, boolean z) {
        this.attacher.setScale(f, f2, f3, z);
    }

    public void setZoomTransitionDuration(int i) {
        this.attacher.setZoomTransitionDuration(i);
    }

    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.attacher.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void setOnScaleChangeListener(OnScaleChangedListener onScaleChangedListener) {
        this.attacher.setOnScaleChangeListener(onScaleChangedListener);
    }

    public void setOnSingleFlingListener(OnSingleFlingListener onSingleFlingListener) {
        this.attacher.setOnSingleFlingListener(onSingleFlingListener);
    }
}
