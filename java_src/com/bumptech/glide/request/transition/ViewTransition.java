package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import com.bumptech.glide.request.transition.Transition;
/* loaded from: classes.dex */
public class ViewTransition<R> implements Transition<R> {
    private final ViewTransitionAnimationFactory viewTransitionAnimationFactory;

    /* loaded from: classes.dex */
    interface ViewTransitionAnimationFactory {
        Animation build(Context context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewTransition(ViewTransitionAnimationFactory viewTransitionAnimationFactory) {
        this.viewTransitionAnimationFactory = viewTransitionAnimationFactory;
    }

    @Override // com.bumptech.glide.request.transition.Transition
    public boolean transition(R r, Transition.ViewAdapter viewAdapter) {
        View view = viewAdapter.getView();
        if (view != null) {
            view.clearAnimation();
            view.startAnimation(this.viewTransitionAnimationFactory.build(view.getContext()));
            return false;
        }
        return false;
    }
}
