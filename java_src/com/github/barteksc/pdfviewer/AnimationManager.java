package com.github.barteksc.pdfviewer;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.PointF;
import android.view.animation.DecelerateInterpolator;
import android.widget.OverScroller;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class AnimationManager {
    private ValueAnimator animation;
    private boolean flinging = false;
    private boolean pageFlinging = false;
    private PDFView pdfView;
    private OverScroller scroller;

    public AnimationManager(PDFView pDFView) {
        this.pdfView = pDFView;
        this.scroller = new OverScroller(pDFView.getContext());
    }

    public void startXAnimation(float f, float f2) {
        stopAll();
        this.animation = ValueAnimator.ofFloat(f, f2);
        XAnimation xAnimation = new XAnimation();
        this.animation.setInterpolator(new DecelerateInterpolator());
        this.animation.addUpdateListener(xAnimation);
        this.animation.addListener(xAnimation);
        this.animation.setDuration(400L);
        this.animation.start();
    }

    public void startYAnimation(float f, float f2) {
        stopAll();
        this.animation = ValueAnimator.ofFloat(f, f2);
        YAnimation yAnimation = new YAnimation();
        this.animation.setInterpolator(new DecelerateInterpolator());
        this.animation.addUpdateListener(yAnimation);
        this.animation.addListener(yAnimation);
        this.animation.setDuration(400L);
        this.animation.start();
    }

    public void startZoomAnimation(float f, float f2, float f3, float f4) {
        stopAll();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(f3, f4);
        this.animation = ofFloat;
        ofFloat.setInterpolator(new DecelerateInterpolator());
        ZoomAnimation zoomAnimation = new ZoomAnimation(f, f2);
        this.animation.addUpdateListener(zoomAnimation);
        this.animation.addListener(zoomAnimation);
        this.animation.setDuration(400L);
        this.animation.start();
    }

    public void startFlingAnimation(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        stopAll();
        this.flinging = true;
        this.scroller.fling(i, i2, i3, i4, i5, i6, i7, i8);
    }

    public void startPageFlingAnimation(float f) {
        if (this.pdfView.isSwipeVertical()) {
            startYAnimation(this.pdfView.getCurrentYOffset(), f);
        } else {
            startXAnimation(this.pdfView.getCurrentXOffset(), f);
        }
        this.pageFlinging = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void computeFling() {
        if (this.scroller.computeScrollOffset()) {
            this.pdfView.moveTo(this.scroller.getCurrX(), this.scroller.getCurrY());
            this.pdfView.loadPageByOffset();
        } else if (this.flinging) {
            this.flinging = false;
            this.pdfView.loadPages();
            hideHandle();
            this.pdfView.performPageSnap();
        }
    }

    public void stopAll() {
        ValueAnimator valueAnimator = this.animation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.animation = null;
        }
        stopFling();
    }

    public void stopFling() {
        this.flinging = false;
        this.scroller.forceFinished(true);
    }

    public boolean isFlinging() {
        return this.flinging || this.pageFlinging;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class XAnimation extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        XAnimation() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.moveTo(((Float) valueAnimator.getAnimatedValue()).floatValue(), AnimationManager.this.pdfView.getCurrentYOffset());
            AnimationManager.this.pdfView.loadPageByOffset();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pageFlinging = false;
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pageFlinging = false;
            AnimationManager.this.hideHandle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class YAnimation extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        YAnimation() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.moveTo(AnimationManager.this.pdfView.getCurrentXOffset(), ((Float) valueAnimator.getAnimatedValue()).floatValue());
            AnimationManager.this.pdfView.loadPageByOffset();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pageFlinging = false;
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pageFlinging = false;
            AnimationManager.this.hideHandle();
        }
    }

    /* loaded from: classes.dex */
    class ZoomAnimation implements ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
        private final float centerX;
        private final float centerY;

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        public ZoomAnimation(float f, float f2) {
            this.centerX = f;
            this.centerY = f2;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            AnimationManager.this.pdfView.zoomCenteredTo(((Float) valueAnimator.getAnimatedValue()).floatValue(), new PointF(this.centerX, this.centerY));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.hideHandle();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            AnimationManager.this.pdfView.loadPages();
            AnimationManager.this.pdfView.performPageSnap();
            AnimationManager.this.hideHandle();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideHandle() {
        if (this.pdfView.getScrollHandle() != null) {
            this.pdfView.getScrollHandle().hideDelayed();
        }
    }
}
