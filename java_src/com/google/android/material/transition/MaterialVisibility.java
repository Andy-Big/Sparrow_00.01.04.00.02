package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.TransitionValues;
import androidx.transition.Visibility;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.transition.VisibilityAnimatorProvider;
import java.util.ArrayList;
/* loaded from: classes.dex */
abstract class MaterialVisibility<P extends VisibilityAnimatorProvider> extends Visibility {
    private final P primaryAnimatorProvider;
    private VisibilityAnimatorProvider secondaryAnimatorProvider;

    /* JADX INFO: Access modifiers changed from: protected */
    public MaterialVisibility(P p, VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.primaryAnimatorProvider = p;
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
        setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
    }

    public P getPrimaryAnimatorProvider() {
        return this.primaryAnimatorProvider;
    }

    public VisibilityAnimatorProvider getSecondaryAnimatorProvider() {
        return this.secondaryAnimatorProvider;
    }

    public void setSecondaryAnimatorProvider(VisibilityAnimatorProvider visibilityAnimatorProvider) {
        this.secondaryAnimatorProvider = visibilityAnimatorProvider;
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, true);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return createAnimator(viewGroup, view, false);
    }

    private Animator createAnimator(ViewGroup viewGroup, View view, boolean z) {
        Animator createDisappear;
        Animator createDisappear2;
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        if (z) {
            createDisappear = this.primaryAnimatorProvider.createAppear(viewGroup, view);
        } else {
            createDisappear = this.primaryAnimatorProvider.createDisappear(viewGroup, view);
        }
        if (createDisappear != null) {
            arrayList.add(createDisappear);
        }
        VisibilityAnimatorProvider visibilityAnimatorProvider = this.secondaryAnimatorProvider;
        if (visibilityAnimatorProvider != null) {
            if (z) {
                createDisappear2 = visibilityAnimatorProvider.createAppear(viewGroup, view);
            } else {
                createDisappear2 = visibilityAnimatorProvider.createDisappear(viewGroup, view);
            }
            if (createDisappear2 != null) {
                arrayList.add(createDisappear2);
            }
        }
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }
}
