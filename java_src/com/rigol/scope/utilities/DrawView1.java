package com.rigol.scope.utilities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
/* loaded from: classes2.dex */
public class DrawView1 extends View {
    Paint paint;
    Paint paint1;
    Paint paint2;
    private float percent;

    public DrawView1(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.percent = 0.0f;
        this.paint = new Paint();
        this.paint1 = new Paint();
        this.paint2 = new Paint();
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint1.setAntiAlias(true);
        this.paint1.setStyle(Paint.Style.STROKE);
        this.paint1.setStrokeWidth(1.5f);
        this.paint1.setColor(-1);
        this.paint2.setAntiAlias(true);
        this.paint2.setStyle(Paint.Style.FILL);
        this.paint2.setColor(-1);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        Math.round(Math.min(displayMetrics.widthPixels / 12800.0f, displayMetrics.heightPixels / 8000.0f) * 20.0f);
        this.paint2.setTextSize(10.0f);
    }

    private int dip2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.percent > 0.3f) {
            this.paint.setColor(-16711936);
        } else {
            this.paint.setColor(SupportMenu.CATEGORY_MASK);
        }
        float f = 25;
        float dip2px = dip2px(2.5f);
        float dip2px2 = 15 + dip2px(1.5f);
        RectF rectF = new RectF(dip2px(0.5f), dip2px(0.5f), (this.percent * f) - dip2px, dip2px2);
        float f2 = f - dip2px;
        float f3 = 3;
        float f4 = dip2px2 - f3;
        RectF rectF2 = new RectF(0.0f, 0.0f, f2, f4);
        RectF rectF3 = new RectF(f2, f3, f, f4);
        canvas.drawRect(rectF, this.paint);
        canvas.drawRect(rectF2, this.paint1);
        canvas.drawRect(rectF3, this.paint2);
        canvas.drawText(String.valueOf((int) (this.percent * 100.0f)), (getWidth() / 3) - dip2px(3.0f), getHeight() - (getHeight() / 4), this.paint2);
    }

    public synchronized void setProgress(int i) {
        this.percent = (float) (i / 100.0d);
        postInvalidate();
    }
}
