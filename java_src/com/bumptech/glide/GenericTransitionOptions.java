package com.bumptech.glide;

import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.request.transition.ViewPropertyTransition;
/* loaded from: classes.dex */
public final class GenericTransitionOptions<TranscodeType> extends TransitionOptions<GenericTransitionOptions<TranscodeType>, TranscodeType> {
    public static <TranscodeType> GenericTransitionOptions<TranscodeType> withNoTransition() {
        return new GenericTransitionOptions().dontTransition();
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(int i) {
        return new GenericTransitionOptions().transition(i);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(ViewPropertyTransition.Animator animator) {
        return new GenericTransitionOptions().transition(animator);
    }

    public static <TranscodeType> GenericTransitionOptions<TranscodeType> with(TransitionFactory<? super TranscodeType> transitionFactory) {
        return new GenericTransitionOptions().transition(transitionFactory);
    }
}
