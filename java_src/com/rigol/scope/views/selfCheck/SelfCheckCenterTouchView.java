package com.rigol.scope.views.selfCheck;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Array;
/* loaded from: classes2.dex */
public class SelfCheckCenterTouchView extends View {
    private static final int LINES = 10;
    private static final Point[][] POINTS = (Point[][]) Array.newInstance(Point.class, 10, 2);
    private Paint mBackgroundPaint;
    private boolean[] mFlags;
    private Paint mGuideLinePaint;
    private SelfCheckOnTouchChangedListener mListener;
    private int mPadding;
    private Paint mPaint;
    private Path mPath;
    private Point mPoint;
    private int mX;
    private int mY;

    public SelfCheckCenterTouchView(Context context) {
        this(context, null);
    }

    public SelfCheckCenterTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mFlags = new boolean[10];
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setColor(-16711936);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeJoin(Paint.Join.ROUND);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mPaint.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        Paint paint2 = new Paint(1);
        this.mGuideLinePaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mGuideLinePaint.setColor(-7829368);
        this.mGuideLinePaint.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        Paint paint3 = new Paint();
        this.mBackgroundPaint = paint3;
        paint3.setStyle(Paint.Style.FILL);
        this.mBackgroundPaint.setColor(-1);
        this.mPadding = (int) TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics());
    }

    public void setOnTouchChangedListener(SelfCheckOnTouchChangedListener selfCheckOnTouchChangedListener) {
        this.mListener = selfCheckOnTouchChangedListener;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            touchDown(x, y);
            invalidate();
        } else if (action == 1) {
            touchUp();
            invalidate();
        } else if (action == 2) {
            touchMove(x, y);
            invalidate();
        }
        return true;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5 = this.mPadding;
        Point[][] pointArr = POINTS;
        Point[] pointArr2 = new Point[2];
        pointArr2[0] = new Point(i5, i5);
        int i6 = i - i5;
        int i7 = i2 - i5;
        pointArr2[1] = new Point(i6, i7);
        pointArr[0] = pointArr2;
        Point[][] pointArr3 = POINTS;
        Point[] pointArr4 = new Point[2];
        pointArr4[0] = new Point(i6, i5);
        pointArr4[1] = new Point(i5, i7);
        pointArr3[1] = pointArr4;
        Point[][] pointArr5 = POINTS;
        Point[] pointArr6 = new Point[2];
        int i8 = (i + i5) / 3;
        pointArr6[0] = new Point(i8, i5);
        int i9 = i2 - (i5 * 2);
        int i10 = ((i9 * 2) / 3) + i5;
        pointArr6[1] = new Point(i6, i10);
        pointArr5[2] = pointArr6;
        Point[][] pointArr7 = POINTS;
        Point[] pointArr8 = new Point[2];
        int i11 = ((i * 2) - i5) / 3;
        pointArr8[0] = new Point(i11, i5);
        int i12 = (i9 / 3) + i5;
        pointArr8[1] = new Point(i6, i12);
        pointArr7[3] = pointArr8;
        Point[][] pointArr9 = POINTS;
        Point[] pointArr10 = new Point[2];
        pointArr10[0] = new Point(i5, (i2 + i5) / 3);
        pointArr10[1] = new Point(i11, i7);
        pointArr9[4] = pointArr10;
        Point[][] pointArr11 = POINTS;
        Point[] pointArr12 = new Point[2];
        pointArr12[0] = new Point(i5, i10);
        pointArr12[1] = new Point(i8, i7);
        pointArr11[5] = pointArr12;
        Point[][] pointArr13 = POINTS;
        Point[] pointArr14 = new Point[2];
        pointArr14[0] = new Point(i11, i5);
        pointArr14[1] = new Point(i5, i10);
        pointArr13[6] = pointArr14;
        Point[][] pointArr15 = POINTS;
        Point[] pointArr16 = new Point[2];
        pointArr16[0] = new Point(i8, i5);
        pointArr16[1] = new Point(i5, i12);
        pointArr15[7] = pointArr16;
        Point[][] pointArr17 = POINTS;
        Point[] pointArr18 = new Point[2];
        pointArr18[0] = new Point(i6, i12);
        pointArr18[1] = new Point(i8, i7);
        pointArr17[8] = pointArr18;
        Point[][] pointArr19 = POINTS;
        Point[] pointArr20 = new Point[2];
        pointArr20[0] = new Point(i6, i10);
        pointArr20[1] = new Point(i11, i7);
        pointArr19[9] = pointArr20;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
        int i = this.mPadding;
        canvas.drawRect(i, i, getWidth() - this.mPadding, getHeight() - this.mPadding, this.mBackgroundPaint);
        for (int i2 = 0; i2 < 10; i2++) {
            this.mGuideLinePaint.setColor(this.mFlags[i2] ? -16711936 : -7829368);
            canvas.drawLine(POINTS[i2][0].x, POINTS[i2][0].y, POINTS[i2][1].x, POINTS[i2][1].y, this.mGuideLinePaint);
        }
        canvas.drawPath(this.mPath, this.mPaint);
    }

    private void touchDown(int i, int i2) {
        this.mPath.reset();
        Point locate = locate(i, i2);
        this.mPoint = locate;
        if (locate != null) {
            this.mPath.moveTo(i, i2);
            this.mX = i;
            this.mY = i2;
        }
    }

    private void touchMove(int i, int i2) {
        if (this.mPoint != null) {
            Path path = this.mPath;
            int i3 = this.mX;
            int i4 = this.mY;
            path.quadTo(i3, i4, (i3 + i) / 2, (i4 + i2) / 2);
            this.mX = i;
            this.mY = i2;
        }
    }

    private void touchUp() {
        int indexOfLines = indexOfLines(this.mPoint, locate(this.mX, this.mY));
        if (indexOfLines > -1) {
            this.mFlags[indexOfLines] = true;
        }
        this.mPath.reset();
        if (this.mListener == null || !checkLines()) {
            return;
        }
        this.mListener.onTouchFinish(this);
    }

    private Point locate(int i, int i2) {
        for (int i3 = 0; i3 < 10; i3++) {
            int abs = Math.abs(i - POINTS[i3][0].x);
            int abs2 = Math.abs(i2 - POINTS[i3][0].y);
            int i4 = this.mPadding;
            if (abs < i4 && abs2 < i4) {
                return POINTS[i3][0];
            }
            int abs3 = Math.abs(i - POINTS[i3][1].x);
            int abs4 = Math.abs(i2 - POINTS[i3][1].y);
            int i5 = this.mPadding;
            if (abs3 < i5 && abs4 < i5) {
                return POINTS[i3][1];
            }
        }
        return null;
    }

    private int indexOfLines(Point point, Point point2) {
        for (int i = 0; i < 10; i++) {
            if ((POINTS[i][0].equals(point) && POINTS[i][1].equals(point2)) || (POINTS[i][0].equals(point2) && POINTS[i][1].equals(point))) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkLines() {
        for (int i = 0; i < 10; i++) {
            if (!this.mFlags[i]) {
                return false;
            }
        }
        return true;
    }
}
