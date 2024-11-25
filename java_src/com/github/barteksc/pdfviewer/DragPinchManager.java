package com.github.barteksc.pdfviewer;

import android.graphics.PointF;
import android.graphics.RectF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import com.github.barteksc.pdfviewer.model.LinkTapEvent;
import com.github.barteksc.pdfviewer.scroll.ScrollHandle;
import com.github.barteksc.pdfviewer.util.Constants;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.SizeF;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DragPinchManager implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, ScaleGestureDetector.OnScaleGestureListener, View.OnTouchListener {
    private AnimationManager animationManager;
    private GestureDetector gestureDetector;
    private PDFView pdfView;
    private ScaleGestureDetector scaleGestureDetector;
    private boolean scrolling = false;
    private boolean scaling = false;
    private boolean enabled = false;

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DragPinchManager(PDFView pDFView, AnimationManager animationManager) {
        this.pdfView = pDFView;
        this.animationManager = animationManager;
        this.gestureDetector = new GestureDetector(pDFView.getContext(), this);
        this.scaleGestureDetector = new ScaleGestureDetector(pDFView.getContext(), this);
        pDFView.setOnTouchListener(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void enable() {
        this.enabled = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void disable() {
        this.enabled = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void disableLongpress() {
        this.gestureDetector.setIsLongpressEnabled(false);
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        ScrollHandle scrollHandle;
        boolean callOnTap = this.pdfView.callbacks.callOnTap(motionEvent);
        boolean checkLinkTapped = checkLinkTapped(motionEvent.getX(), motionEvent.getY());
        if (!callOnTap && !checkLinkTapped && (scrollHandle = this.pdfView.getScrollHandle()) != null && !this.pdfView.documentFitsView()) {
            if (!scrollHandle.shown()) {
                scrollHandle.show();
            } else {
                scrollHandle.hide();
            }
        }
        this.pdfView.performClick();
        return true;
    }

    private boolean checkLinkTapped(float f, float f2) {
        int secondaryPageOffset;
        int pageOffset;
        PdfFile pdfFile = this.pdfView.pdfFile;
        if (pdfFile == null) {
            return false;
        }
        float f3 = (-this.pdfView.getCurrentXOffset()) + f;
        float f4 = (-this.pdfView.getCurrentYOffset()) + f2;
        int pageAtOffset = pdfFile.getPageAtOffset(this.pdfView.isSwipeVertical() ? f4 : f3, this.pdfView.getZoom());
        SizeF scaledPageSize = pdfFile.getScaledPageSize(pageAtOffset, this.pdfView.getZoom());
        if (this.pdfView.isSwipeVertical()) {
            pageOffset = (int) pdfFile.getSecondaryPageOffset(pageAtOffset, this.pdfView.getZoom());
            secondaryPageOffset = (int) pdfFile.getPageOffset(pageAtOffset, this.pdfView.getZoom());
        } else {
            secondaryPageOffset = (int) pdfFile.getSecondaryPageOffset(pageAtOffset, this.pdfView.getZoom());
            pageOffset = (int) pdfFile.getPageOffset(pageAtOffset, this.pdfView.getZoom());
        }
        int i = pageOffset;
        int i2 = secondaryPageOffset;
        for (PdfDocument.Link link : pdfFile.getPageLinks(pageAtOffset)) {
            RectF mapRectToDevice = pdfFile.mapRectToDevice(pageAtOffset, i, i2, (int) scaledPageSize.getWidth(), (int) scaledPageSize.getHeight(), link.getBounds());
            mapRectToDevice.sort();
            if (mapRectToDevice.contains(f3, f4)) {
                this.pdfView.callbacks.callLinkHandler(new LinkTapEvent(f, f2, f3, f4, mapRectToDevice, link));
                return true;
            }
        }
        return false;
    }

    private void startPageFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float x;
        float x2;
        if (checkDoPageFling(f, f2)) {
            int i = -1;
            if (!this.pdfView.isSwipeVertical() ? f <= 0.0f : f2 <= 0.0f) {
                i = 1;
            }
            if (this.pdfView.isSwipeVertical()) {
                x = motionEvent2.getY();
                x2 = motionEvent.getY();
            } else {
                x = motionEvent2.getX();
                x2 = motionEvent.getX();
            }
            float f3 = x - x2;
            int max = Math.max(0, Math.min(this.pdfView.getPageCount() - 1, this.pdfView.findFocusPage(this.pdfView.getCurrentXOffset() - (this.pdfView.getZoom() * f3), this.pdfView.getCurrentYOffset() - (f3 * this.pdfView.getZoom())) + i));
            this.animationManager.startPageFlingAnimation(-this.pdfView.snapOffsetForPage(max, this.pdfView.findSnapEdge(max)));
        }
    }

    @Override // android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        if (this.pdfView.isDoubletapEnabled()) {
            if (this.pdfView.getZoom() < this.pdfView.getMidZoom()) {
                this.pdfView.zoomWithAnimation(motionEvent.getX(), motionEvent.getY(), this.pdfView.getMidZoom());
                return true;
            } else if (this.pdfView.getZoom() < this.pdfView.getMaxZoom()) {
                this.pdfView.zoomWithAnimation(motionEvent.getX(), motionEvent.getY(), this.pdfView.getMaxZoom());
                return true;
            } else {
                this.pdfView.resetZoomWithAnimation();
                return true;
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        this.animationManager.stopFling();
        return true;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.scrolling = true;
        if (this.pdfView.isZooming() || this.pdfView.isSwipeEnabled()) {
            this.pdfView.moveRelativeTo(-f, -f2);
        }
        if (!this.scaling || this.pdfView.doRenderDuringScale()) {
            this.pdfView.loadPageByOffset();
        }
        return true;
    }

    private void onScrollEnd(MotionEvent motionEvent) {
        this.pdfView.loadPages();
        hideHandle();
        if (this.animationManager.isFlinging()) {
            return;
        }
        this.pdfView.performPageSnap();
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
        this.pdfView.callbacks.callOnLongPress(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        float f3;
        float currentScale;
        int height;
        if (this.pdfView.isSwipeEnabled()) {
            if (this.pdfView.isPageFlingEnabled()) {
                if (this.pdfView.pageFillsScreen()) {
                    onBoundedFling(f, f2);
                } else {
                    startPageFling(motionEvent, motionEvent2, f, f2);
                }
                return true;
            }
            int currentXOffset = (int) this.pdfView.getCurrentXOffset();
            int currentYOffset = (int) this.pdfView.getCurrentYOffset();
            PdfFile pdfFile = this.pdfView.pdfFile;
            if (this.pdfView.isSwipeVertical()) {
                f3 = -(this.pdfView.toCurrentScale(pdfFile.getMaxPageWidth()) - this.pdfView.getWidth());
                currentScale = pdfFile.getDocLen(this.pdfView.getZoom());
                height = this.pdfView.getHeight();
            } else {
                f3 = -(pdfFile.getDocLen(this.pdfView.getZoom()) - this.pdfView.getWidth());
                currentScale = this.pdfView.toCurrentScale(pdfFile.getMaxPageHeight());
                height = this.pdfView.getHeight();
            }
            this.animationManager.startFlingAnimation(currentXOffset, currentYOffset, (int) f, (int) f2, (int) f3, 0, (int) (-(currentScale - height)), 0);
            return true;
        }
        return false;
    }

    private void onBoundedFling(float f, float f2) {
        float f3;
        float f4;
        int currentXOffset = (int) this.pdfView.getCurrentXOffset();
        int currentYOffset = (int) this.pdfView.getCurrentYOffset();
        PdfFile pdfFile = this.pdfView.pdfFile;
        float f5 = -pdfFile.getPageOffset(this.pdfView.getCurrentPage(), this.pdfView.getZoom());
        float pageLength = f5 - pdfFile.getPageLength(this.pdfView.getCurrentPage(), this.pdfView.getZoom());
        float f6 = 0.0f;
        if (this.pdfView.isSwipeVertical()) {
            f4 = -(this.pdfView.toCurrentScale(pdfFile.getMaxPageWidth()) - this.pdfView.getWidth());
            f3 = pageLength + this.pdfView.getHeight();
            f6 = f5;
            f5 = 0.0f;
        } else {
            float width = pageLength + this.pdfView.getWidth();
            f3 = -(this.pdfView.toCurrentScale(pdfFile.getMaxPageHeight()) - this.pdfView.getHeight());
            f4 = width;
        }
        this.animationManager.startFlingAnimation(currentXOffset, currentYOffset, (int) f, (int) f2, (int) f4, (int) f5, (int) f3, (int) f6);
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        float scaleFactor = scaleGestureDetector.getScaleFactor();
        float zoom = this.pdfView.getZoom() * scaleFactor;
        float min = Math.min(Constants.Pinch.MINIMUM_ZOOM, this.pdfView.getMinZoom());
        float min2 = Math.min(Constants.Pinch.MAXIMUM_ZOOM, this.pdfView.getMaxZoom());
        if (zoom < min) {
            scaleFactor = min / this.pdfView.getZoom();
        } else if (zoom > min2) {
            scaleFactor = min2 / this.pdfView.getZoom();
        }
        this.pdfView.zoomCenteredRelativeTo(scaleFactor, new PointF(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY()));
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        this.scaling = true;
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        this.pdfView.loadPages();
        hideHandle();
        this.scaling = false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.enabled) {
            boolean z = this.gestureDetector.onTouchEvent(motionEvent) || this.scaleGestureDetector.onTouchEvent(motionEvent);
            if (motionEvent.getAction() == 1 && this.scrolling) {
                this.scrolling = false;
                onScrollEnd(motionEvent);
            }
            return z;
        }
        return false;
    }

    private void hideHandle() {
        ScrollHandle scrollHandle = this.pdfView.getScrollHandle();
        if (scrollHandle == null || !scrollHandle.shown()) {
            return;
        }
        scrollHandle.hideDelayed();
    }

    private boolean checkDoPageFling(float f, float f2) {
        float abs = Math.abs(f);
        float abs2 = Math.abs(f2);
        if (this.pdfView.isSwipeVertical()) {
            if (abs2 > abs) {
                return true;
            }
        } else if (abs > abs2) {
            return true;
        }
        return false;
    }
}
