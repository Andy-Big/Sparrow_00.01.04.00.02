package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R;
import androidx.fragment.app.FragmentTransition;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class FragmentAnim {
    private FragmentAnim() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimationOrAnimator loadAnimation(Context context, FragmentContainer fragmentContainer, Fragment fragment, boolean z) {
        int transitToAnimResourceId;
        int nextTransition = fragment.getNextTransition();
        int nextAnim = fragment.getNextAnim();
        boolean z2 = false;
        fragment.setNextAnim(0);
        View onFindViewById = fragmentContainer.onFindViewById(fragment.mContainerId);
        if (onFindViewById != null && onFindViewById.getTag(R.id.visible_removing_fragment_view_tag) != null) {
            onFindViewById.setTag(R.id.visible_removing_fragment_view_tag, null);
        }
        if (fragment.mContainer == null || fragment.mContainer.getLayoutTransition() == null) {
            Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z, nextAnim);
            if (onCreateAnimation != null) {
                return new AnimationOrAnimator(onCreateAnimation);
            }
            Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z, nextAnim);
            if (onCreateAnimator != null) {
                return new AnimationOrAnimator(onCreateAnimator);
            }
            if (nextAnim != 0) {
                boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
                if (equals) {
                    try {
                        Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation != null) {
                            return new AnimationOrAnimator(loadAnimation);
                        }
                        z2 = true;
                    } catch (Resources.NotFoundException e) {
                        throw e;
                    } catch (RuntimeException unused) {
                    }
                }
                if (!z2) {
                    try {
                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                        if (loadAnimator != null) {
                            return new AnimationOrAnimator(loadAnimator);
                        }
                    } catch (RuntimeException e2) {
                        if (equals) {
                            throw e2;
                        }
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                        if (loadAnimation2 != null) {
                            return new AnimationOrAnimator(loadAnimation2);
                        }
                    }
                }
            }
            if (nextTransition != 0 && (transitToAnimResourceId = transitToAnimResourceId(nextTransition, z)) >= 0) {
                return new AnimationOrAnimator(AnimationUtils.loadAnimation(context, transitToAnimResourceId));
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void animateRemoveFragment(final Fragment fragment, AnimationOrAnimator animationOrAnimator, final FragmentTransition.Callback callback) {
        final View view = fragment.mView;
        final ViewGroup viewGroup = fragment.mContainer;
        viewGroup.startViewTransition(view);
        final CancellationSignal cancellationSignal = new CancellationSignal();
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.FragmentAnim.1
            @Override // androidx.core.os.CancellationSignal.OnCancelListener
            public void onCancel() {
                if (Fragment.this.getAnimatingAway() != null) {
                    View animatingAway = Fragment.this.getAnimatingAway();
                    Fragment.this.setAnimatingAway(null);
                    animatingAway.clearAnimation();
                }
                Fragment.this.setAnimator(null);
            }
        });
        callback.onStart(fragment, cancellationSignal);
        if (animationOrAnimator.animation != null) {
            EndViewTransitionAnimation endViewTransitionAnimation = new EndViewTransitionAnimation(animationOrAnimator.animation, viewGroup, view);
            fragment.setAnimatingAway(fragment.mView);
            endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.FragmentAnim.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    viewGroup.post(new Runnable() { // from class: androidx.fragment.app.FragmentAnim.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (fragment.getAnimatingAway() != null) {
                                fragment.setAnimatingAway(null);
                                callback.onComplete(fragment, cancellationSignal);
                            }
                        }
                    });
                }
            });
            fragment.mView.startAnimation(endViewTransitionAnimation);
            return;
        }
        Animator animator = animationOrAnimator.animator;
        fragment.setAnimator(animationOrAnimator.animator);
        animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.FragmentAnim.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                viewGroup.endViewTransition(view);
                Animator animator3 = fragment.getAnimator();
                fragment.setAnimator(null);
                if (animator3 == null || viewGroup.indexOfChild(view) >= 0) {
                    return;
                }
                callback.onComplete(fragment, cancellationSignal);
            }
        });
        animator.setTarget(fragment.mView);
        animator.start();
    }

    private static int transitToAnimResourceId(int i, boolean z) {
        if (i == 4097) {
            return z ? R.anim.fragment_open_enter : R.anim.fragment_open_exit;
        } else if (i == 4099) {
            return z ? R.anim.fragment_fade_enter : R.anim.fragment_fade_exit;
        } else if (i != 8194) {
            return -1;
        } else {
            return z ? R.anim.fragment_close_enter : R.anim.fragment_close_exit;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.mAnimating = true;
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            this.mParent.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.mEnded && this.mAnimating) {
                this.mAnimating = false;
                this.mParent.post(this);
                return;
            }
            this.mParent.endViewTransition(this.mChild);
            this.mTransitionEnded = true;
        }
    }
}
