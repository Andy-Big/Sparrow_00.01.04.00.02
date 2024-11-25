package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
/* loaded from: classes.dex */
public final class FadeThroughProvider implements VisibilityAnimatorProvider {
    static final float PROGRESS_THRESHOLD = 0.35f;

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createAppear(ViewGroup viewGroup, View view) {
        return createFadeThroughAnimator(view, 0.0f, 1.0f, PROGRESS_THRESHOLD, 1.0f);
    }

    @Override // com.google.android.material.transition.VisibilityAnimatorProvider
    public Animator createDisappear(ViewGroup viewGroup, View view) {
        return createFadeThroughAnimator(view, 1.0f, 0.0f, 0.0f, PROGRESS_THRESHOLD);
    }

    private static Animator createFadeThroughAnimator(final View view, final float f, final float f2, final float f3, final float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.transition.FadeThroughProvider.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                view.setAlpha(TransitionUtils.lerp(f, f2, f3, f4, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
            }
        });
        return ofFloat;
    }
}
