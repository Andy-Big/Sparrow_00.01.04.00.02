package com.rigol.scope.views.selfCheck;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.Arrays;
/* loaded from: classes2.dex */
public class SelfCheckBorderTouchViewNew extends View {
    private Paint PromptPaint;
    public Boolean[] lightList;
    private SelfCheckOnTouchChangedListener mListener;
    private Path mPath;
    private float mX;
    private float mY;
    private Paint paintFillRec;
    private Paint paintLine;
    private Paint paintRec;
    float recHeight;
    int recHorizontalNum;
    int recVerticalNum;
    float recWidth;
    public float x;
    public float y;

    public SelfCheckBorderTouchViewNew(Context context) {
        super(context);
        this.mPath = new Path();
        this.mX = 0.0f;
        this.mY = 0.0f;
        init();
    }

    public SelfCheckBorderTouchViewNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPath = new Path();
        this.mX = 0.0f;
        this.mY = 0.0f;
        init();
    }

    public SelfCheckBorderTouchViewNew(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPath = new Path();
        this.mX = 0.0f;
        this.mY = 0.0f;
        init();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        initList();
    }

    public void setOnTouchChangedListener(SelfCheckOnTouchChangedListener selfCheckOnTouchChangedListener) {
        this.mListener = selfCheckOnTouchChangedListener;
    }

    private void init() {
        Paint paint = new Paint();
        this.paintRec = paint;
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.paintRec.setStrokeWidth(1.5f);
        this.paintRec.setStyle(Paint.Style.STROKE);
        this.paintRec.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.paintLine = paint2;
        paint2.setColor(-16776961);
        this.paintLine.setStrokeWidth(2.0f);
        this.paintLine.setStyle(Paint.Style.STROKE);
        this.paintLine.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.paintFillRec = paint3;
        paint3.setColor(-16711936);
        this.paintFillRec.setStrokeWidth(1.0f);
        this.paintFillRec.setStyle(Paint.Style.FILL);
        this.paintLine.setAntiAlias(true);
    }

    private void initList() {
        this.recHorizontalNum = (getWidth() / 60) % 2 == 1 ? getWidth() / 60 : (getWidth() / 60) + 1;
        this.recVerticalNum = (getHeight() / 60) % 2 == 1 ? getHeight() / 60 : (getHeight() / 60) + 1;
        this.recWidth = getWidth() / this.recHorizontalNum;
        int i = this.recVerticalNum;
        this.recHeight = getHeight() / i;
        int i2 = this.recHorizontalNum;
        Boolean[] boolArr = new Boolean[(((i2 * 2) + ((i - 2) * 3)) + i2) - 3];
        this.lightList = boolArr;
        Arrays.fill(boolArr, Boolean.FALSE);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(-1);
        if (this.y < this.recHeight + 10.0f) {
            int i = 0;
            while (i < this.recHorizontalNum) {
                float f = this.x;
                float f2 = this.recWidth;
                int i2 = i + 1;
                if (f <= i2 * f2 && f > f2 * i) {
                    float f3 = this.y;
                    if (f3 <= this.recHeight && f3 >= 0.0f) {
                        this.lightList[i] = true;
                    }
                }
                i = i2;
            }
        }
        if (this.x > getWidth() - (this.recWidth + 10.0f)) {
            for (int i3 = 0; i3 < this.recVerticalNum - 2; i3++) {
                if (this.x >= getWidth() - this.recWidth && this.x <= getWidth()) {
                    float f4 = this.y;
                    float f5 = this.recHeight;
                    if (f4 >= (i3 + 1) * f5 && f4 <= f5 * (i3 + 2)) {
                        this.lightList[this.recHorizontalNum + i3] = true;
                    }
                }
            }
        }
        if (this.y > getHeight() - (this.recHeight + 10.0f)) {
            for (int i4 = 0; i4 < this.recHorizontalNum; i4++) {
                if (this.x <= getWidth() - (this.recWidth * i4) && this.x > getWidth() - (this.recWidth * (i4 + 1)) && this.y <= getHeight() && this.y > getHeight() - this.recHeight) {
                    this.lightList[((this.recHorizontalNum + i4) + this.recVerticalNum) - 2] = true;
                }
            }
        }
        if (this.x < this.recWidth + 10.0f) {
            for (int i5 = 0; i5 < this.recVerticalNum - 2; i5++) {
                float f6 = this.x;
                if (f6 >= 0.0f && f6 <= this.recWidth && this.y >= getHeight() - (this.recHeight * (i5 + 2)) && this.y <= getHeight() - (this.recHeight * (i5 + 1))) {
                    this.lightList[(((this.recHorizontalNum * 2) + i5) + this.recVerticalNum) - 2] = true;
                }
            }
        }
        if (this.y > (getHeight() / 2) - ((this.recHeight / 2.0f) + 10.0f) && this.y < (getHeight() / 2) + (this.recHeight / 2.0f) + 10.0f) {
            int i6 = 0;
            while (i6 < this.recHorizontalNum - 2) {
                float f7 = this.x;
                float f8 = this.recWidth;
                int i7 = i6 + 1;
                if (f7 >= i7 * f8 && f7 < f8 * (i6 + 2) && this.y <= (getHeight() / 2) + (this.recHeight / 2.0f) && this.y >= (getHeight() / 2) - (this.recHeight / 2.0f)) {
                    this.lightList[i6 + (this.recHorizontalNum * 2) + ((this.recVerticalNum - 2) * 2)] = true;
                }
                i6 = i7;
            }
        }
        if (this.x > (getWidth() / 2) - ((this.recWidth / 2.0f) + 10.0f) && this.x < (getWidth() / 2) + (this.recWidth / 2.0f) + 10.0f) {
            for (int i8 = 0; i8 < (this.recVerticalNum - 3) / 2; i8++) {
                if (this.x >= (getWidth() / 2) - (this.recWidth / 2.0f) && this.x <= (getWidth() / 2) + (this.recWidth / 2.0f)) {
                    float f9 = this.y;
                    float f10 = this.recHeight;
                    if (f9 >= (i8 + 1) * f10 && f9 <= f10 * (i8 + 2)) {
                        Boolean[] boolArr = this.lightList;
                        int i9 = this.recHorizontalNum;
                        boolArr[((((i9 * 2) + i8) + ((this.recVerticalNum - 2) * 2)) + i9) - 2] = true;
                    }
                }
            }
            for (int i10 = 0; i10 < (this.recVerticalNum - 3) / 2; i10++) {
                if (this.x >= (getWidth() / 2) - (this.recWidth / 2.0f) && this.x <= (getWidth() / 2) + (this.recWidth / 2.0f)) {
                    float f11 = this.y;
                    float f12 = this.recHeight;
                    int i11 = this.recVerticalNum;
                    if (f11 >= (i10 + 1 + ((i11 - 3) / 2) + 1) * f12 && f11 <= f12 * (i10 + 2 + ((i11 - 3) / 2) + 1)) {
                        Boolean[] boolArr2 = this.lightList;
                        int i12 = this.recHorizontalNum;
                        boolArr2[(((((i12 * 2) + i10) + ((i11 - 2) * 2)) + i12) - 2) + ((i11 - 3) / 2)] = true;
                    }
                }
            }
        }
        for (int i13 = 0; i13 < this.recHorizontalNum; i13++) {
            if (this.lightList[i13].booleanValue()) {
                float f13 = this.recWidth;
                canvas.drawRect(i13 * f13, 0.0f, (i13 + 1) * f13, this.recHeight, this.paintFillRec);
            }
            if (this.lightList[this.recHorizontalNum + i13].booleanValue() && i13 < this.recVerticalNum - 2) {
                canvas.drawRect(getWidth() - this.recWidth, (i13 + 1) * this.recHeight, getWidth(), (i13 + 2) * this.recHeight, this.paintFillRec);
            }
            if (this.lightList[((this.recHorizontalNum + i13) + this.recVerticalNum) - 2].booleanValue()) {
                canvas.drawRect(getWidth() - (this.recWidth * (i13 + 1)), getHeight() - this.recHeight, getWidth() - (this.recWidth * i13), getHeight(), this.paintFillRec);
            }
            if (this.lightList[(((this.recHorizontalNum * 2) + i13) + this.recVerticalNum) - 2].booleanValue() && i13 < this.recVerticalNum - 2) {
                canvas.drawRect(0.0f, getHeight() - (this.recHeight * (i13 + 2)), this.recWidth, getHeight() - (this.recHeight * (i13 + 1)), this.paintFillRec);
            }
            if (this.lightList[(this.recHorizontalNum * 2) + i13 + ((this.recVerticalNum - 2) * 2)].booleanValue() && i13 < this.recHorizontalNum - 2) {
                canvas.drawRect((i13 + 1) * this.recWidth, (getHeight() / 2) - (this.recHeight / 2.0f), (i13 + 2) * this.recWidth, (this.recHeight / 2.0f) + (getHeight() / 2), this.paintFillRec);
            }
            int i14 = this.recVerticalNum;
            if (i13 < (i14 - 3) / 2) {
                Boolean[] boolArr3 = this.lightList;
                int i15 = this.recHorizontalNum;
                if (boolArr3[((((i15 * 2) + i13) + ((i14 - 2) * 2)) + i15) - 2].booleanValue()) {
                    canvas.drawRect((getWidth() / 2) - (this.recWidth / 2.0f), (i13 + 1) * this.recHeight, (this.recWidth / 2.0f) + (getWidth() / 2), (i13 + 2) * this.recHeight, this.paintFillRec);
                }
            }
            int i16 = this.recVerticalNum;
            if (i13 < (i16 - 3) / 2) {
                Boolean[] boolArr4 = this.lightList;
                int i17 = this.recHorizontalNum;
                if (boolArr4[(((((i17 * 2) + i13) + ((i16 - 2) * 2)) + i17) - 2) + ((i16 - 3) / 2)].booleanValue()) {
                    canvas.drawRect((getWidth() / 2) - (this.recWidth / 2.0f), (i13 + 1 + ((this.recVerticalNum - 3) / 2) + 1) * this.recHeight, (this.recWidth / 2.0f) + (getWidth() / 2), (i13 + 2 + ((this.recVerticalNum - 3) / 2) + 1) * this.recHeight, this.paintFillRec);
                }
            }
        }
        canvas.drawRect(this.recWidth, this.recHeight, getWidth() - this.recWidth, getHeight() - this.recHeight, this.paintRec);
        for (float f14 = 1.0f; f14 < this.recHorizontalNum; f14 += 1.0f) {
            float f15 = this.recWidth;
            canvas.drawLine(f15 * f14, 0.0f, f15 * f14, this.recHeight, this.paintRec);
            canvas.drawLine(this.recWidth * f14, getHeight(), this.recWidth * f14, getHeight() - this.recHeight, this.paintRec);
        }
        for (int i18 = 1; i18 < this.recVerticalNum; i18++) {
            float f16 = this.recHeight;
            float f17 = i18;
            canvas.drawLine(0.0f, f16 * f17, this.recWidth, f16 * f17, this.paintRec);
            canvas.drawLine(getWidth() - this.recWidth, this.recHeight * f17, getWidth(), this.recHeight * f17, this.paintRec);
        }
        for (int i19 = 2; i19 <= this.recVerticalNum - 2; i19++) {
            float f18 = i19;
            canvas.drawLine((getWidth() / 2) - (this.recWidth / 2.0f), this.recHeight * f18, (this.recWidth / 2.0f) + (getWidth() / 2), this.recHeight * f18, this.paintRec);
        }
        canvas.drawLine((getWidth() / 2) - (this.recWidth / 2.0f), this.recHeight, (getWidth() / 2) - (this.recWidth / 2.0f), getHeight() - this.recHeight, this.paintRec);
        canvas.drawLine((this.recWidth / 2.0f) + (getWidth() / 2), this.recHeight, (this.recWidth / 2.0f) + (getWidth() / 2), getHeight() - this.recHeight, this.paintRec);
        for (int i20 = 2; i20 <= (this.recHorizontalNum - 3) / 2; i20++) {
            float f19 = i20;
            canvas.drawLine(this.recWidth * f19, (getHeight() / 2) - (this.recHeight / 2.0f), this.recWidth * f19, (getHeight() / 2) + (this.recHeight / 2.0f), this.paintRec);
        }
        canvas.drawLine(this.recWidth, (this.recHeight / 2.0f) + (getHeight() / 2), (getWidth() / 2) - (this.recWidth / 2.0f), (this.recHeight / 2.0f) + (getHeight() / 2), this.paintRec);
        canvas.drawLine(this.recWidth, (getHeight() / 2) - (this.recHeight / 2.0f), (getWidth() / 2) - (this.recWidth / 2.0f), (getHeight() / 2) - (this.recHeight / 2.0f), this.paintRec);
        for (int i21 = 2; i21 <= (this.recHorizontalNum - 3) / 2; i21++) {
            float f20 = this.recWidth;
            float f21 = i21;
            float f22 = this.recWidth;
            canvas.drawLine(((getWidth() / 2) + (f20 * f21)) - (f20 / 2.0f), (getHeight() / 2) - (this.recHeight / 2.0f), ((getWidth() / 2) + (f21 * f22)) - (f22 / 2.0f), (getHeight() / 2) + (this.recHeight / 2.0f), this.paintRec);
        }
        canvas.drawLine((this.recWidth / 2.0f) + (getWidth() / 2), (this.recHeight / 2.0f) + (getHeight() / 2), getWidth() - this.recWidth, (this.recHeight / 2.0f) + (getHeight() / 2), this.paintRec);
        canvas.drawLine((this.recWidth / 2.0f) + (getWidth() / 2), (getHeight() / 2) - (this.recHeight / 2.0f), getWidth() - this.recWidth, (getHeight() / 2) - (this.recHeight / 2.0f), this.paintRec);
        canvas.drawPath(this.mPath, this.paintLine);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.x = motionEvent.getX();
        this.y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            touchDown(motionEvent);
            invalidate();
        } else {
            if (action != 1) {
                if (action == 2) {
                    touchMove(motionEvent);
                    invalidate();
                }
            }
            int i = 0;
            boolean z = false;
            while (true) {
                Boolean[] boolArr = this.lightList;
                if (i >= boolArr.length) {
                    break;
                }
                if (!boolArr[i].booleanValue()) {
                    z = true;
                }
                i++;
            }
            SelfCheckOnTouchChangedListener selfCheckOnTouchChangedListener = this.mListener;
            if (selfCheckOnTouchChangedListener != null && !z) {
                selfCheckOnTouchChangedListener.onTouchFinish(this);
            }
            invalidate();
        }
        return true;
    }

    private void touchDown(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        this.mX = x;
        this.mY = y;
        this.mPath.moveTo(x, y);
    }

    private void touchMove(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float f = this.mX;
        float f2 = this.mY;
        float abs = Math.abs(x - f);
        float abs2 = Math.abs(y - f2);
        if (abs >= 3.0f || abs2 >= 3.0f) {
            this.mPath.quadTo(f, f2, (x + f) / 2.0f, (y + f2) / 2.0f);
            this.mX = x;
            this.mY = y;
        }
    }
}
