package com.github.barteksc.pdfviewer.scroll;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.R;
import com.github.barteksc.pdfviewer.util.Util;

/* loaded from: classes.dex */
public class DefaultScrollHandle extends RelativeLayout implements ScrollHandle {
    private static final int DEFAULT_TEXT_SIZE = 16;
    private static final int HANDLE_LONG = 65;
    private static final int HANDLE_SHORT = 40;
    protected Context context;
    private float currentPos;
    private Handler handler;
    private Runnable hidePageScrollerRunnable;
    private boolean inverted;
    private PDFView pdfView;
    private float relativeHandlerMiddle;
    protected TextView textView;

    public DefaultScrollHandle(Context context) {
        this(context, false);
    }

    public DefaultScrollHandle(Context context, boolean z) {
        super(context);
        this.relativeHandlerMiddle = 0.0f;
        this.handler = new Handler();
        this.hidePageScrollerRunnable = new Runnable() { // from class: com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle.1
            @Override // java.lang.Runnable
            public void run() {
                DefaultScrollHandle.this.hide();
            }
        };
        this.context = context;
        this.inverted = z;
        this.textView = new TextView(context);
        setVisibility(4);
        setTextColor(ViewCompat.MEASURED_STATE_MASK);
        setTextSize(16);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setupLayout(PDFView pDFView) {
        int i;
        Drawable drawable;
        int i2 = 65;
        int i3 = 40;
        if (pDFView.isSwipeVertical()) {
            if (this.inverted) {
                i = 9;
                drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_left);
            } else {
                i = 11;
                drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_right);
            }
        } else {
            if (this.inverted) {
                i = 10;
                drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_top);
            } else {
                i = 12;
                drawable = ContextCompat.getDrawable(this.context, R.drawable.default_scroll_handle_bottom);
            }
            i3 = 65;
            i2 = 40;
        }
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(drawable);
        } else {
            setBackground(drawable);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Util.getDP(this.context, i2), Util.getDP(this.context, i3));
        layoutParams.setMargins(0, 0, 0, 0);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.addRule(13, -1);
        addView(this.textView, layoutParams2);
        layoutParams.addRule(i);
        pDFView.addView(this, layoutParams);
        this.pdfView = pDFView;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void destroyLayout() {
        this.pdfView.removeView(this);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setScroll(float f) {
        if (!shown()) {
            show();
        } else {
            this.handler.removeCallbacks(this.hidePageScrollerRunnable);
        }
        PDFView pDFView = this.pdfView;
        if (pDFView != null) {
            setPosition((pDFView.isSwipeVertical() ? this.pdfView.getHeight() : this.pdfView.getWidth()) * f);
        }
    }

    private void setPosition(float f) {
        int width;
        if (Float.isInfinite(f) || Float.isNaN(f)) {
            return;
        }
        if (this.pdfView.isSwipeVertical()) {
            width = this.pdfView.getHeight();
        } else {
            width = this.pdfView.getWidth();
        }
        float f2 = width;
        float f3 = f - this.relativeHandlerMiddle;
        if (f3 < 0.0f) {
            f3 = 0.0f;
        } else if (f3 > f2 - Util.getDP(this.context, 40)) {
            f3 = f2 - Util.getDP(this.context, 40);
        }
        if (this.pdfView.isSwipeVertical()) {
            setY(f3);
        } else {
            setX(f3);
        }
        calculateMiddle();
        invalidate();
    }

    private void calculateMiddle() {
        float x;
        float width;
        int width2;
        if (this.pdfView.isSwipeVertical()) {
            x = getY();
            width = getHeight();
            width2 = this.pdfView.getHeight();
        } else {
            x = getX();
            width = getWidth();
            width2 = this.pdfView.getWidth();
        }
        this.relativeHandlerMiddle = ((x + this.relativeHandlerMiddle) / width2) * width;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void hideDelayed() {
        this.handler.postDelayed(this.hidePageScrollerRunnable, 1000L);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void setPageNum(int i) {
        String valueOf = String.valueOf(i);
        if (this.textView.getText().equals(valueOf)) {
            return;
        }
        this.textView.setText(valueOf);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public boolean shown() {
        return getVisibility() == 0;
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void show() {
        setVisibility(0);
    }

    @Override // com.github.barteksc.pdfviewer.scroll.ScrollHandle
    public void hide() {
        setVisibility(4);
    }

    public void setTextColor(int i) {
        this.textView.setTextColor(i);
    }

    public void setTextSize(int i) {
        this.textView.setTextSize(1, i);
    }

    private boolean isPDFViewReady() {
        PDFView pDFView = this.pdfView;
        return (pDFView == null || pDFView.getPageCount() <= 0 || this.pdfView.documentFitsView()) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isPDFViewReady()) {
            return super.onTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action != 3) {
                        if (action != 5) {
                            if (action != 6) {
                                return super.onTouchEvent(motionEvent);
                            }
                        }
                    }
                }
                if (!this.pdfView.isSwipeVertical()) {
                    setPosition((motionEvent.getRawY() - this.currentPos) + this.relativeHandlerMiddle);
                    this.pdfView.setPositionOffset(this.relativeHandlerMiddle / getHeight(), false);
                } else {
                    setPosition((motionEvent.getRawX() - this.currentPos) + this.relativeHandlerMiddle);
                    this.pdfView.setPositionOffset(this.relativeHandlerMiddle / getWidth(), false);
                }
                return true;
            }
            hideDelayed();
            this.pdfView.performPageSnap();
            return true;
        }
        this.pdfView.stopFling();
        this.handler.removeCallbacks(this.hidePageScrollerRunnable);
        if (this.pdfView.isSwipeVertical()) {
            this.currentPos = motionEvent.getRawY() - getY();
        } else {
            this.currentPos = motionEvent.getRawX() - getX();
        }
        if (!this.pdfView.isSwipeVertical()) {
        }
        return true;
    }
}
