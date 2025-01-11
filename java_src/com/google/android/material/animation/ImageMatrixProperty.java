package com.google.android.material.animation;

import android.graphics.Matrix;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class ImageMatrixProperty extends Property<ImageView, Matrix> {
    private final Matrix matrix;

    public ImageMatrixProperty() {
        super(Matrix.class, "imageMatrixProperty");
        this.matrix = new Matrix();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    public void set(ImageView imageView, Matrix matrix) {
        imageView.setImageMatrix(matrix);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.util.Property
    public Matrix get(ImageView imageView) {
        this.matrix.set(imageView.getImageMatrix());
        return this.matrix;
    }
}
