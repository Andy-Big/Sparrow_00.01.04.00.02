package com.rigol.scope.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public class TextTrackDrawable extends Drawable {
    private final Paint mBackgroundPaint;
    private String mLeftText;
    private String mRightText;
    private int mSelectedWidth;
    private boolean mShowFullBackground;
    private boolean mSwitchChecked;
    private final Paint mTextPaint;

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public TextTrackDrawable(String str, String str2) {
        this.mLeftText = str;
        this.mRightText = str2;
        this.mTextPaint = createTextPaint();
        this.mBackgroundPaint = createBackgroundPaint();
    }

    public TextTrackDrawable() {
        this("OFF", "ON");
    }

    private Paint createTextPaint() {
        Paint paint = new Paint();
        paint.setTextSize(12.0f);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        paint.setTextAlign(Paint.Align.CENTER);
        return paint;
    }

    private Paint createBackgroundPaint() {
        Paint paint = new Paint();
        paint.setColor(Color.parseColor("#94a2a5"));
        return paint;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009a  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        int i;
        int i2;
        float f;
        float f2;
        int width = canvas.getClipBounds().width();
        int i3 = this.mSelectedWidth;
        if (i3 != 0) {
            if (!this.mSwitchChecked) {
                i2 = i3;
                i = width - i3;
                if (this.mSwitchChecked && !this.mShowFullBackground) {
                    float f3 = i;
                    canvas.drawRoundRect(0.0f, 0.0f, f3, canvas.getClipBounds().height(), 5.0f, 5.0f, this.mBackgroundPaint);
                    canvas.drawRoundRect(i - 5, 0.0f, f3, canvas.getClipBounds().height(), 0.0f, 0.0f, this.mBackgroundPaint);
                }
                if (this.mShowFullBackground) {
                    canvas.drawRoundRect(0.0f, 0.0f, width, canvas.getClipBounds().height(), 5.0f, 5.0f, this.mBackgroundPaint);
                }
                Rect rect = new Rect();
                Paint paint = this.mTextPaint;
                String str = this.mRightText;
                paint.getTextBounds(str, 0, str.length(), rect);
                int height = (canvas.getClipBounds().height() / 2) + (rect.height() / 2);
                if (this.mSelectedWidth == 0) {
                    double d = i;
                    f = (float) (d / 2.0d);
                    f2 = (float) (d + (i2 / 2.0d));
                } else {
                    f = i >> 1;
                    f2 = i + (i2 >> 1);
                }
                drawLeftText(canvas, f, height);
                drawRightText(canvas, f2, height);
            }
        } else {
            i3 = width / 2;
        }
        i = i3;
        i2 = width - i3;
        if (this.mSwitchChecked) {
            float f32 = i;
            canvas.drawRoundRect(0.0f, 0.0f, f32, canvas.getClipBounds().height(), 5.0f, 5.0f, this.mBackgroundPaint);
            canvas.drawRoundRect(i - 5, 0.0f, f32, canvas.getClipBounds().height(), 0.0f, 0.0f, this.mBackgroundPaint);
        }
        if (this.mShowFullBackground) {
        }
        Rect rect2 = new Rect();
        Paint paint2 = this.mTextPaint;
        String str2 = this.mRightText;
        paint2.getTextBounds(str2, 0, str2.length(), rect2);
        int height2 = (canvas.getClipBounds().height() / 2) + (rect2.height() / 2);
        if (this.mSelectedWidth == 0) {
        }
        drawLeftText(canvas, f, height2);
        drawRightText(canvas, f2, height2);
    }

    private void drawLeftText(Canvas canvas, float f, int i) {
        this.mTextPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        String str = this.mLeftText;
        canvas.drawText(str, 0, str.length(), f, i, this.mTextPaint);
    }

    private void drawRightText(Canvas canvas, float f, int i) {
        if (this.mShowFullBackground) {
            this.mTextPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        } else {
            this.mTextPaint.setColor(-1);
        }
        String str = this.mRightText;
        canvas.drawText(str, 0, str.length(), f, i, this.mTextPaint);
    }

    public void setmLeftText(String str) {
        this.mLeftText = str;
    }

    public void setmRightText(String str) {
        this.mRightText = str;
    }

    public void setSwitchChecked(boolean z) {
        this.mSwitchChecked = z;
    }

    public void setSelectedWidth(int i) {
        this.mSelectedWidth = i;
    }

    public void setShowFullBackground(boolean z) {
        this.mShowFullBackground = z;
    }
}
