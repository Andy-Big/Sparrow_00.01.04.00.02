package com.github.barteksc.pdfviewer.listener;

import android.view.MotionEvent;
import com.github.barteksc.pdfviewer.link.LinkHandler;
import com.github.barteksc.pdfviewer.model.LinkTapEvent;
/* loaded from: classes.dex */
public class Callbacks {
    private LinkHandler linkHandler;
    private OnDrawListener onDrawAllListener;
    private OnDrawListener onDrawListener;
    private OnErrorListener onErrorListener;
    private OnLoadCompleteListener onLoadCompleteListener;
    private OnLongPressListener onLongPressListener;
    private OnPageChangeListener onPageChangeListener;
    private OnPageErrorListener onPageErrorListener;
    private OnPageScrollListener onPageScrollListener;
    private OnRenderListener onRenderListener;
    private OnTapListener onTapListener;

    public void setOnLoadComplete(OnLoadCompleteListener onLoadCompleteListener) {
        this.onLoadCompleteListener = onLoadCompleteListener;
    }

    public void callOnLoadComplete(int i) {
        OnLoadCompleteListener onLoadCompleteListener = this.onLoadCompleteListener;
        if (onLoadCompleteListener != null) {
            onLoadCompleteListener.loadComplete(i);
        }
    }

    public void setOnError(OnErrorListener onErrorListener) {
        this.onErrorListener = onErrorListener;
    }

    public OnErrorListener getOnError() {
        return this.onErrorListener;
    }

    public void setOnPageError(OnPageErrorListener onPageErrorListener) {
        this.onPageErrorListener = onPageErrorListener;
    }

    public boolean callOnPageError(int i, Throwable th) {
        OnPageErrorListener onPageErrorListener = this.onPageErrorListener;
        if (onPageErrorListener != null) {
            onPageErrorListener.onPageError(i, th);
            return true;
        }
        return false;
    }

    public void setOnRender(OnRenderListener onRenderListener) {
        this.onRenderListener = onRenderListener;
    }

    public void callOnRender(int i) {
        OnRenderListener onRenderListener = this.onRenderListener;
        if (onRenderListener != null) {
            onRenderListener.onInitiallyRendered(i);
        }
    }

    public void setOnPageChange(OnPageChangeListener onPageChangeListener) {
        this.onPageChangeListener = onPageChangeListener;
    }

    public void callOnPageChange(int i, int i2) {
        OnPageChangeListener onPageChangeListener = this.onPageChangeListener;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageChanged(i, i2);
        }
    }

    public void setOnPageScroll(OnPageScrollListener onPageScrollListener) {
        this.onPageScrollListener = onPageScrollListener;
    }

    public void callOnPageScroll(int i, float f) {
        OnPageScrollListener onPageScrollListener = this.onPageScrollListener;
        if (onPageScrollListener != null) {
            onPageScrollListener.onPageScrolled(i, f);
        }
    }

    public void setOnDraw(OnDrawListener onDrawListener) {
        this.onDrawListener = onDrawListener;
    }

    public OnDrawListener getOnDraw() {
        return this.onDrawListener;
    }

    public void setOnDrawAll(OnDrawListener onDrawListener) {
        this.onDrawAllListener = onDrawListener;
    }

    public OnDrawListener getOnDrawAll() {
        return this.onDrawAllListener;
    }

    public void setOnTap(OnTapListener onTapListener) {
        this.onTapListener = onTapListener;
    }

    public boolean callOnTap(MotionEvent motionEvent) {
        OnTapListener onTapListener = this.onTapListener;
        return onTapListener != null && onTapListener.onTap(motionEvent);
    }

    public void setOnLongPress(OnLongPressListener onLongPressListener) {
        this.onLongPressListener = onLongPressListener;
    }

    public void callOnLongPress(MotionEvent motionEvent) {
        OnLongPressListener onLongPressListener = this.onLongPressListener;
        if (onLongPressListener != null) {
            onLongPressListener.onLongPress(motionEvent);
        }
    }

    public void setLinkHandler(LinkHandler linkHandler) {
        this.linkHandler = linkHandler;
    }

    public void callLinkHandler(LinkTapEvent linkTapEvent) {
        LinkHandler linkHandler = this.linkHandler;
        if (linkHandler != null) {
            linkHandler.handleLinkEvent(linkTapEvent);
        }
    }
}
