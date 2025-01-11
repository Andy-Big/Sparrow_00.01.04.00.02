package com.google.android.material.transition.platform;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Build;
import android.transition.Transition;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewParent;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.RelativeCornerSize;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes.dex */
class TransitionUtils {
    private static final RectF transformAlphaRectF = new RectF();

    /* loaded from: classes.dex */
    interface CanvasOperation {
        void run(Canvas canvas);
    }

    /* loaded from: classes.dex */
    interface CornerSizeBinaryOperator {
        CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2);
    }

    static <T> T defaultIfNull(T t, T t2) {
        return t != null ? t : t2;
    }

    static float lerp(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    private TransitionUtils() {
    }

    static ShapeAppearanceModel convertToRelativeCornerSizes(ShapeAppearanceModel shapeAppearanceModel, final RectF rectF) {
        return shapeAppearanceModel.withTransformedCornerSizes(new ShapeAppearanceModel.CornerSizeUnaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils.1
            @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
            public CornerSize apply(CornerSize cornerSize) {
                return cornerSize instanceof RelativeCornerSize ? cornerSize : new RelativeCornerSize(cornerSize.getCornerSize(rectF) / rectF.height());
            }
        });
    }

    static ShapeAppearanceModel transformCornerSizes(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, RectF rectF, CornerSizeBinaryOperator cornerSizeBinaryOperator) {
        return (isShapeAppearanceSignificant(shapeAppearanceModel, rectF) ? shapeAppearanceModel : shapeAppearanceModel2).toBuilder().setTopLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopLeftCornerSize(), shapeAppearanceModel2.getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getTopRightCornerSize(), shapeAppearanceModel2.getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomLeftCornerSize(), shapeAppearanceModel2.getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeBinaryOperator.apply(shapeAppearanceModel.getBottomRightCornerSize(), shapeAppearanceModel2.getBottomRightCornerSize())).build();
    }

    private static boolean isShapeAppearanceSignificant(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
        return (shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getTopRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomRightCornerSize().getCornerSize(rectF) == 0.0f && shapeAppearanceModel.getBottomLeftCornerSize().getCornerSize(rectF) == 0.0f) ? false : true;
    }

    static float lerp(float f, float f2, float f3, float f4, float f5) {
        return f5 < f3 ? f : f5 > f4 ? f2 : lerp(f, f2, (f5 - f3) / (f4 - f3));
    }

    static int lerp(int i, int i2, float f, float f2, float f3) {
        return f3 < f ? i : f3 > f2 ? i2 : (int) lerp(i, i2, (f3 - f) / (f2 - f));
    }

    static ShapeAppearanceModel lerp(ShapeAppearanceModel shapeAppearanceModel, ShapeAppearanceModel shapeAppearanceModel2, final RectF rectF, final RectF rectF2, final float f, final float f2, final float f3) {
        return f3 < f ? shapeAppearanceModel : f3 > f2 ? shapeAppearanceModel2 : transformCornerSizes(shapeAppearanceModel, shapeAppearanceModel2, rectF, new CornerSizeBinaryOperator() { // from class: com.google.android.material.transition.platform.TransitionUtils.2
            @Override // com.google.android.material.transition.platform.TransitionUtils.CornerSizeBinaryOperator
            public CornerSize apply(CornerSize cornerSize, CornerSize cornerSize2) {
                return new AbsoluteCornerSize(TransitionUtils.lerp(cornerSize.getCornerSize(rectF), cornerSize2.getCornerSize(rectF2), f, f2, f3));
            }
        });
    }

    static Shader createColorShader(int i) {
        return new LinearGradient(0.0f, 0.0f, 0.0f, 0.0f, i, i, Shader.TileMode.CLAMP);
    }

    static View findDescendantOrAncestorById(View view, int i) {
        View findViewById = view.findViewById(i);
        return findViewById != null ? findViewById : findAncestorById(view, i);
    }

    static View findAncestorById(View view, int i) {
        String resourceName = view.getResources().getResourceName(i);
        while (view != null) {
            if (view.getId() != i) {
                ViewParent parent = view.getParent();
                if (!(parent instanceof View)) {
                    break;
                }
                view = (View) parent;
            } else {
                return view;
            }
        }
        throw new IllegalArgumentException(resourceName + " is not a valid ancestor");
    }

    static RectF getRelativeBounds(View view) {
        return new RectF(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static Rect getRelativeBoundsRect(View view) {
        return new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
    }

    static RectF getLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return new RectF(i, i2, view.getWidth() + i, view.getHeight() + i2);
    }

    static float calculateArea(RectF rectF) {
        return rectF.width() * rectF.height();
    }

    private static int saveLayerAlphaCompat(Canvas canvas, Rect rect, int i) {
        transformAlphaRectF.set(rect);
        if (Build.VERSION.SDK_INT >= 21) {
            return canvas.saveLayerAlpha(transformAlphaRectF, i);
        }
        return canvas.saveLayerAlpha(transformAlphaRectF.left, transformAlphaRectF.top, transformAlphaRectF.right, transformAlphaRectF.bottom, i, 31);
    }

    static void transform(Canvas canvas, Rect rect, float f, float f2, float f3, int i, CanvasOperation canvasOperation) {
        if (i <= 0) {
            return;
        }
        int save = canvas.save();
        canvas.translate(f, f2);
        canvas.scale(f3, f3);
        if (i < 255) {
            saveLayerAlphaCompat(canvas, rect, i);
        }
        canvasOperation.run(canvas);
        canvas.restoreToCount(save);
    }

    static void maybeAddTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
    }

    static void maybeRemoveTransition(TransitionSet transitionSet, Transition transition) {
        if (transition != null) {
            transitionSet.removeTransition(transition);
        }
    }
}
