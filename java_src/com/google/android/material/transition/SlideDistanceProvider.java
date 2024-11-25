package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
/* loaded from: classes.dex */
public final class SlideDistanceProvider implements VisibilityAnimatorProvider {
    private static final int DEFAULT_DISTANCE = -1;
    private int slideDistance = -1;
    private int slideEdge;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface GravityFlag {
    }

    public SlideDistanceProvider(int i) {
        this.slideEdge = i;
    }

    public int getSlideEdge() {
        return this.slideEdge;
    }

    public void setSlideEdge(int i) {
        this.slideEdge = i;
    }

    public int getSlideDistance() {
        return this.slideDistance;
    }

    public void setSlideDistance(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
        }
        this.slideDistance = i;
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup viewGroup, View view) {
        return createTranslationAppearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup viewGroup, View view) {
        return createTranslationDisappearAnimator(viewGroup, view, this.slideEdge, getSlideDistanceOrDefault(view.getContext()));
    }

    private int getSlideDistanceOrDefault(Context context) {
        int i = this.slideDistance;
        return i != -1 ? i : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static Animator createTranslationAppearAnimator(View view, View view2, int i, int i2) {
        if (i != 3) {
            if (i != 5) {
                if (i != 48) {
                    if (i != 80) {
                        if (i == 8388611) {
                            return createTranslationXAnimator(view2, isRtl(view) ? i2 : -i2, 0.0f);
                        } else if (i == 8388613) {
                            return createTranslationXAnimator(view2, isRtl(view) ? -i2 : i2, 0.0f);
                        } else {
                            throw new IllegalArgumentException("Invalid slide direction: " + i);
                        }
                    }
                    return createTranslationYAnimator(view2, i2, 0.0f);
                }
                return createTranslationYAnimator(view2, -i2, 0.0f);
            }
            return createTranslationXAnimator(view2, -i2, 0.0f);
        }
        return createTranslationXAnimator(view2, i2, 0.0f);
    }

    private static Animator createTranslationDisappearAnimator(View view, View view2, int i, int i2) {
        if (i != 3) {
            if (i != 5) {
                if (i != 48) {
                    if (i != 80) {
                        if (i == 8388611) {
                            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? -i2 : i2);
                        } else if (i == 8388613) {
                            return createTranslationXAnimator(view2, 0.0f, isRtl(view) ? i2 : -i2);
                        } else {
                            throw new IllegalArgumentException("Invalid slide direction: " + i);
                        }
                    }
                    return createTranslationYAnimator(view2, 0.0f, -i2);
                }
                return createTranslationYAnimator(view2, 0.0f, i2);
            }
            return createTranslationXAnimator(view2, 0.0f, i2);
        }
        return createTranslationXAnimator(view2, 0.0f, -i2);
    }

    private static Animator createTranslationXAnimator(View view, float f, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f, f2));
    }

    private static Animator createTranslationYAnimator(View view, float f, float f2) {
        return ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f, f2));
    }

    private static boolean isRtl(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }
}
