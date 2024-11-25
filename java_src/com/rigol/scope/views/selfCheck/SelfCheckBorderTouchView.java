package com.rigol.scope.views.selfCheck;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SelfCheckBorderTouchView extends View {
    private Paint PromptPaint;
    private Rect[] mCenterHorizontal;
    private boolean[] mCenterHorizontalFlags;
    private int mCenterHorizontalHeight;
    private Rect[] mCenterVertical;
    private boolean[] mCenterVerticalFlags;
    private int mCenterVerticalHeight;
    private boolean mDistanceValid;
    private Rect[] mEast;
    private boolean[] mEastFlags;
    private int mEastHeight;
    private SelfCheckOnTouchChangedListener mListener;
    private int mMaxDistance;
    private Rect[] mNorth;
    private boolean[] mNorthFlags;
    private int mNorthHeight;
    private Paint mPaint;
    private Path mPath;
    private int mRectHeight;
    private int mRectWidth;
    private Rect[] mSouth;
    private boolean[] mSouthFlags;
    private int mSouthHeight;
    private Paint mTextPaint;
    private Rect[] mWest;
    private boolean[] mWestFlags;
    private int mWestHeight;
    private int mX;
    private int mY;
    private List<Point> points;

    public SelfCheckBorderTouchView(Context context) {
        this(context, null);
    }

    public SelfCheckBorderTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mX = 0;
        this.mY = 0;
        this.points = new ArrayList();
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setAntiAlias(true);
        this.mTextPaint.setDither(true);
        this.mTextPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.mTextPaint.setStyle(Paint.Style.STROKE);
        this.mTextPaint.setStrokeWidth(getResources().getDisplayMetrics().density * 4.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.mRectWidth = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        this.mRectHeight = (int) TypedValue.applyDimension(1, 50.0f, displayMetrics);
        this.mMaxDistance = ((int) displayMetrics.density) * 50;
        Paint paint2 = new Paint(1);
        this.mPaint = paint2;
        paint2.setStyle(Paint.Style.STROKE);
        this.mPaint.setColor(-1);
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
        int i5;
        int i6;
        int i7 = this.mRectHeight;
        Rect[] rectArr = new Rect[i / i7];
        this.mNorth = rectArr;
        this.mNorthFlags = new boolean[rectArr.length];
        Rect[] rectArr2 = new Rect[rectArr.length];
        this.mSouth = rectArr2;
        this.mSouthFlags = new boolean[rectArr2.length];
        int i8 = this.mRectWidth;
        Rect[] rectArr3 = new Rect[(i2 - (i8 * 2)) / i7];
        this.mWest = rectArr3;
        this.mWestFlags = new boolean[rectArr3.length];
        Rect[] rectArr4 = new Rect[rectArr3.length];
        this.mEast = rectArr4;
        this.mEastFlags = new boolean[rectArr4.length];
        Rect[] rectArr5 = new Rect[(i - (i8 * 2)) / i7];
        this.mCenterHorizontal = rectArr5;
        this.mCenterHorizontalFlags = new boolean[rectArr5.length];
        Rect[] rectArr6 = new Rect[(i2 - (i8 * 2)) / i7];
        this.mCenterVertical = rectArr6;
        this.mCenterVerticalFlags = new boolean[rectArr6.length];
        this.mNorthHeight = i / rectArr.length;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            Rect[] rectArr7 = this.mNorth;
            if (i10 >= rectArr7.length) {
                break;
            }
            int i11 = this.mNorthHeight;
            int i12 = i11 * i10;
            this.mNorth[i10] = new Rect(i12 + 1, 1, (i10 == rectArr7.length - 1 ? i : i11 + i12) - 1, this.mRectWidth - 1);
            i10++;
        }
        this.mSouthHeight = i / this.mSouth.length;
        int i13 = 0;
        while (true) {
            Rect[] rectArr8 = this.mSouth;
            if (i13 >= rectArr8.length) {
                break;
            }
            int i14 = this.mSouthHeight;
            int i15 = i14 * i13;
            this.mSouth[i13] = new Rect(i15 + 1, (i2 - this.mRectWidth) + 1, (i13 == rectArr8.length - 1 ? i : i14 + i15) - 1, i2 - 1);
            i13++;
        }
        this.mWestHeight = (i2 - (this.mRectWidth * 2)) / this.mWest.length;
        int i16 = 0;
        while (true) {
            Rect[] rectArr9 = this.mWest;
            if (i16 >= rectArr9.length) {
                break;
            }
            int i17 = this.mNorthHeight;
            int i18 = this.mRectWidth;
            int i19 = this.mWestHeight;
            int i20 = (i19 * i16) + i18;
            this.mWest[i16] = new Rect(1, i20 + 1, i17 - 1, (i16 == rectArr9.length - 1 ? i2 - i18 : i20 + i19) - 1);
            i16++;
        }
        this.mEastHeight = (i2 - (this.mRectWidth * 2)) / this.mEast.length;
        int i21 = 0;
        while (true) {
            Rect[] rectArr10 = this.mEast;
            if (i21 >= rectArr10.length) {
                break;
            }
            int i22 = i - this.mNorthHeight;
            int i23 = this.mRectWidth;
            int i24 = this.mEastHeight;
            int i25 = (i24 * i21) + i23;
            this.mEast[i21] = new Rect(i22 + 1, i25 + 1, i - 1, (i21 == rectArr10.length - 1 ? i2 - i23 : i25 + i24) - 1);
            i21++;
        }
        this.mCenterHorizontalHeight = (i - (this.mNorthHeight * 2)) / this.mCenterHorizontal.length;
        int i26 = 0;
        while (true) {
            Rect[] rectArr11 = this.mCenterHorizontal;
            if (i26 >= rectArr11.length) {
                break;
            }
            int i27 = this.mNorthHeight;
            int i28 = (i27 * i26) + i27;
            int i29 = i26 == rectArr11.length - 1 ? i - i27 : this.mCenterHorizontalHeight + i28;
            if (this.mNorth.length % 2 == 0) {
                int i30 = i2 / 2;
                this.mCenterHorizontal[i26] = new Rect(i28 + 1, i30 - 30, i29 - 1, (int) (i30 + (this.mNorthHeight * 0.4d)));
            } else {
                double d = i2 / 2;
                int i31 = this.mNorthHeight;
                this.mCenterHorizontal[i26] = new Rect(i28 + 1, (int) (d - (i31 * 0.5d)), i29 - 1, (int) (d + (i31 * 0.5d)));
            }
            i26++;
        }
        this.mCenterVerticalHeight = (i2 - (this.mRectWidth * 2)) / this.mCenterVertical.length;
        while (i9 < this.mCenterVertical.length) {
            if (this.mNorth.length % 2 == 0) {
                double d2 = i / 2;
                int i32 = this.mWestHeight;
                i5 = (int) (d2 - (i32 * 0.01d));
                i6 = ((int) (d2 - (i32 * 0.2d))) + i32;
            } else {
                double d3 = i / 2;
                int i33 = this.mWestHeight;
                i5 = (int) (d3 - (i33 * 0.51d));
                i6 = (int) ((d3 - (i33 * 0.51d)) + i33);
            }
            int i34 = this.mRectWidth;
            int i35 = this.mEastHeight;
            int i36 = (i35 * i9) + i34;
            this.mCenterVertical[i9] = new Rect(i5 - 10, i36 + 1, i6, (i9 == this.mEast.length - 1 ? i2 - i34 : i36 + i35) - 1);
            i9++;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(-1);
        setPromptText(canvas);
        int i = 0;
        while (true) {
            int i2 = -16711936;
            if (i >= this.mNorth.length) {
                break;
            }
            this.mPaint.setStyle(this.mNorthFlags[i] ? Paint.Style.FILL : Paint.Style.STROKE);
            Paint paint = this.mPaint;
            if (!this.mNorthFlags[i]) {
                i2 = -7829368;
            }
            paint.setColor(i2);
            canvas.drawRect(this.mNorth[i], this.mPaint);
            i++;
        }
        for (int i3 = 0; i3 < this.mSouth.length; i3++) {
            this.mPaint.setStyle(this.mSouthFlags[i3] ? Paint.Style.FILL : Paint.Style.STROKE);
            this.mPaint.setColor(this.mSouthFlags[i3] ? -16711936 : -7829368);
            canvas.drawRect(this.mSouth[i3], this.mPaint);
        }
        for (int i4 = 0; i4 < this.mWest.length; i4++) {
            this.mPaint.setStyle(this.mWestFlags[i4] ? Paint.Style.FILL : Paint.Style.STROKE);
            this.mPaint.setColor(this.mWestFlags[i4] ? -16711936 : -7829368);
            canvas.drawRect(this.mWest[i4], this.mPaint);
        }
        for (int i5 = 0; i5 < this.mEast.length; i5++) {
            this.mPaint.setStyle(this.mEastFlags[i5] ? Paint.Style.FILL : Paint.Style.STROKE);
            this.mPaint.setColor(this.mEastFlags[i5] ? -16711936 : -7829368);
            canvas.drawRect(this.mEast[i5], this.mPaint);
        }
        for (int i6 = 0; i6 < this.mCenterHorizontal.length; i6++) {
            this.mPaint.setStyle(this.mCenterHorizontalFlags[i6] ? Paint.Style.FILL : Paint.Style.STROKE);
            this.mPaint.setColor(this.mCenterHorizontalFlags[i6] ? -16711936 : -7829368);
            canvas.drawRect(this.mCenterHorizontal[i6], this.mPaint);
        }
        for (int i7 = 0; i7 < this.mCenterVertical.length; i7++) {
            this.mPaint.setStyle(this.mCenterVerticalFlags[i7] ? Paint.Style.FILL : Paint.Style.STROKE);
            this.mPaint.setColor(this.mCenterVerticalFlags[i7] ? -16711936 : -7829368);
            canvas.drawRect(this.mCenterVertical[i7], this.mPaint);
        }
        canvas.drawPath(this.mPath, this.mTextPaint);
    }

    private void setPromptText(Canvas canvas) {
        Paint paint = new Paint();
        this.PromptPaint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.PromptPaint.setTextSize(25.0f);
        this.PromptPaint.setColor(-7829368);
        this.PromptPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawText("", this.mWestHeight * 2, getHeight() - (this.mSouthHeight * 2), this.PromptPaint);
    }

    private void touchDown(int i, int i2) {
        this.mPath.moveTo(i, i2);
        this.mDistanceValid = true;
        this.mX = i;
        this.mY = i2;
    }

    private void touchMove(int i, int i2) {
        Path path = this.mPath;
        int i3 = this.mX;
        int i4 = this.mY;
        path.quadTo(i3, i4, (i3 + i) / 2, (i4 + i2) / 2);
        int abs = Math.abs(i - this.mX);
        int abs2 = Math.abs(i2 - this.mY);
        this.mX = i;
        this.mY = i2;
        if (!this.mDistanceValid) {
            int i5 = this.mMaxDistance;
            this.mDistanceValid = abs < i5 && abs2 < i5;
        }
        if (this.mDistanceValid) {
            setBorderFlag(i, i2);
        }
    }

    private void touchUp() {
        if (this.mListener == null || !checkBorders()) {
            return;
        }
        this.mListener.onTouchFinish(this);
    }

    private void setBorderFlag(int i, int i2) {
        int i3;
        if (i2 < this.mRectWidth) {
            int i4 = i / this.mNorthHeight;
            if (i4 > -1) {
                boolean[] zArr = this.mNorthFlags;
                if (i4 < zArr.length) {
                    zArr[i4] = true;
                    return;
                }
                return;
            }
            return;
        }
        int height = getHeight();
        int i5 = this.mRectWidth;
        if (i2 > height - i5) {
            int i6 = i / this.mSouthHeight;
            if (i6 > -1) {
                boolean[] zArr2 = this.mSouthFlags;
                if (i6 < zArr2.length) {
                    zArr2[i6] = true;
                }
            }
        } else if (i < i5) {
            int i7 = (i2 - i5) / this.mWestHeight;
            if (i7 > -1) {
                boolean[] zArr3 = this.mWestFlags;
                if (i7 < zArr3.length) {
                    zArr3[i7] = true;
                }
            }
        } else {
            int width = getWidth();
            int i8 = this.mRectWidth;
            if (i > width - i8) {
                int i9 = (i2 - i8) / this.mEastHeight;
                if (i9 > -1) {
                    boolean[] zArr4 = this.mEastFlags;
                    if (i9 < zArr4.length) {
                        zArr4[i9] = true;
                    }
                }
            } else if (i2 > ((int) ((getHeight() / 2) - (this.mNorthHeight * 0.5d))) && i2 < ((int) ((getHeight() / 2) + (this.mNorthHeight * 0.5d)))) {
                int i10 = (i - this.mRectWidth) / this.mCenterHorizontalHeight;
                if (i10 > -1) {
                    boolean[] zArr5 = this.mCenterHorizontalFlags;
                    if (i10 < zArr5.length) {
                        zArr5[i10] = true;
                    }
                }
            } else if (i > ((int) ((getWidth() / 2) - (this.mWestHeight * 0.5d)))) {
                double width2 = getWidth() / 2;
                int i11 = this.mWestHeight;
                if (i >= ((int) ((width2 - (i11 * 0.5d)) + i11)) || (i3 = (i2 - this.mRectWidth) / this.mCenterVerticalHeight) <= -1) {
                    return;
                }
                boolean[] zArr6 = this.mCenterVerticalFlags;
                if (i3 < zArr6.length) {
                    zArr6[i3] = true;
                }
            }
        }
    }

    private boolean checkBorders() {
        int i = 0;
        while (true) {
            boolean[] zArr = this.mNorthFlags;
            if (i >= zArr.length) {
                int i2 = 0;
                while (true) {
                    boolean[] zArr2 = this.mSouthFlags;
                    if (i2 >= zArr2.length) {
                        int i3 = 0;
                        while (true) {
                            boolean[] zArr3 = this.mWestFlags;
                            if (i3 >= zArr3.length) {
                                int i4 = 0;
                                while (true) {
                                    boolean[] zArr4 = this.mEastFlags;
                                    if (i4 < zArr4.length) {
                                        if (!zArr4[i4]) {
                                            return false;
                                        }
                                        i4++;
                                    } else if (this.mCenterHorizontalFlags[18] || this.mCenterVerticalFlags[9]) {
                                        int i5 = 0;
                                        while (true) {
                                            boolean[] zArr5 = this.mCenterHorizontalFlags;
                                            if (i5 >= zArr5.length) {
                                                int i6 = 0;
                                                while (true) {
                                                    boolean[] zArr6 = this.mCenterVerticalFlags;
                                                    if (i6 >= zArr6.length) {
                                                        return true;
                                                    }
                                                    if (i6 != 9 && !zArr6[i6]) {
                                                        return false;
                                                    }
                                                    i6++;
                                                }
                                            } else if (i5 != 18 && !zArr5[i5]) {
                                                return false;
                                            } else {
                                                i5++;
                                            }
                                        }
                                    } else {
                                        int i7 = 0;
                                        while (true) {
                                            boolean[] zArr7 = this.mCenterHorizontalFlags;
                                            if (i7 >= zArr7.length) {
                                                int i8 = 0;
                                                while (true) {
                                                    boolean[] zArr8 = this.mCenterVerticalFlags;
                                                    if (i8 >= zArr8.length) {
                                                        return true;
                                                    }
                                                    if (!zArr8[i8]) {
                                                        return false;
                                                    }
                                                    i8++;
                                                }
                                            } else if (!zArr7[i7]) {
                                                return false;
                                            } else {
                                                i7++;
                                            }
                                        }
                                    }
                                }
                            } else if (!zArr3[i3]) {
                                return false;
                            } else {
                                i3++;
                            }
                        }
                    } else if (!zArr2[i2]) {
                        return false;
                    } else {
                        i2++;
                    }
                }
            } else if (!zArr[i]) {
                return false;
            } else {
                i++;
            }
        }
    }
}
