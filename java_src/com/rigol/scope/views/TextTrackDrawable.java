package com.rigol.scope.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
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
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r13) {
        /*
            r12 = this;
            android.graphics.Rect r0 = r13.getClipBounds()
            int r8 = r0.width()
            int r0 = r12.mSelectedWidth
            if (r0 == 0) goto L16
            boolean r1 = r12.mSwitchChecked
            if (r1 == 0) goto L11
            goto L18
        L11:
            int r1 = r8 - r0
            r10 = r0
            r9 = r1
            goto L1c
        L16:
            int r0 = r8 / 2
        L18:
            int r1 = r8 - r0
            r9 = r0
            r10 = r1
        L1c:
            boolean r0 = r12.mSwitchChecked
            if (r0 == 0) goto L4f
            boolean r0 = r12.mShowFullBackground
            if (r0 != 0) goto L4f
            r1 = 0
            r2 = 0
            float r11 = (float) r9
            android.graphics.Rect r0 = r13.getClipBounds()
            int r0 = r0.height()
            float r4 = (float) r0
            r5 = 1084227584(0x40a00000, float:5.0)
            r6 = 1084227584(0x40a00000, float:5.0)
            android.graphics.Paint r7 = r12.mBackgroundPaint
            r0 = r13
            r3 = r11
            r0.drawRoundRect(r1, r2, r3, r4, r5, r6, r7)
            int r0 = r9 + (-5)
            float r1 = (float) r0
            android.graphics.Rect r0 = r13.getClipBounds()
            int r0 = r0.height()
            float r4 = (float) r0
            r5 = 0
            r6 = 0
            android.graphics.Paint r7 = r12.mBackgroundPaint
            r0 = r13
            r0.drawRoundRect(r1, r2, r3, r4, r5, r6, r7)
        L4f:
            boolean r0 = r12.mShowFullBackground
            if (r0 == 0) goto L69
            r1 = 0
            r2 = 0
            float r3 = (float) r8
            android.graphics.Rect r0 = r13.getClipBounds()
            int r0 = r0.height()
            float r4 = (float) r0
            r5 = 1084227584(0x40a00000, float:5.0)
            r6 = 1084227584(0x40a00000, float:5.0)
            android.graphics.Paint r7 = r12.mBackgroundPaint
            r0 = r13
            r0.drawRoundRect(r1, r2, r3, r4, r5, r6, r7)
        L69:
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            android.graphics.Paint r1 = r12.mTextPaint
            java.lang.String r2 = r12.mRightText
            r3 = 0
            int r4 = r2.length()
            r1.getTextBounds(r2, r3, r4, r0)
            android.graphics.Rect r1 = r13.getClipBounds()
            int r1 = r1.height()
            int r1 = r1 / 2
            int r0 = r0.height()
            int r0 = r0 / 2
            int r1 = r1 + r0
            int r0 = r12.mSelectedWidth
            if (r0 == 0) goto L9a
            double r2 = (double) r9
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r6 = r2 / r4
            float r0 = (float) r6
            double r6 = (double) r10
            double r6 = r6 / r4
            double r2 = r2 + r6
            float r2 = (float) r2
            goto La1
        L9a:
            int r0 = r9 >> 1
            float r0 = (float) r0
            int r2 = r10 >> 1
            int r9 = r9 + r2
            float r2 = (float) r9
        La1:
            r12.drawLeftText(r13, r0, r1)
            r12.drawRightText(r13, r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.TextTrackDrawable.draw(android.graphics.Canvas):void");
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
