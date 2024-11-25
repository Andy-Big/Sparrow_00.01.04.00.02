package com.rigol.scope.views.baseview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.rigol.scope.R;
import com.rigol.scope.utilities.MotorManager;
/* loaded from: classes2.dex */
public class FanScaleView extends View {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private float curAngle;
    private Bitmap dragBitmap;
    private int dragBitmapHight;
    private Paint dragBitmapPaint;
    private int dragBitmapWidth;
    private int fanBgColor;
    private Bitmap fanBgLeftBitmap;
    private Paint fanBgLeftBitmapPaint;
    private int fanBgLeftBitmapWidth;
    private Paint fanBgPaint;
    private RectF fanBgRectF;
    private float fanCentralPointMarginLeft;
    private float fanCentralPointMarginTop;
    private float fanPaintStartAngle;
    private float fanPaintedAngle;
    private int fanRadius;
    private boolean mIsOnSlideRingTouchingEvent;
    private int maxAngle;
    private int minAngle;
    private NotifyToRefreshAngleTypeEnum notifyToRefreshAngleType;
    private int percentage;
    private int ringBgColor;
    private Paint ringBgDesPaint;
    private Paint ringBgPaint;
    private float ringWidth;
    private int slideAbleLocation;
    private int slideRingColor;
    private Paint slideRingPaint;
    private int slideRingProcessColor;
    private Paint slideRingProcessPaint;
    private RectF slideRingRectF;
    private String toShowAngle;
    private int toShowAngleColor;
    private int toShowAngleFontsize;
    private Paint toShowAnglePaint;
    private Rect toShowAngleRect;

    /* loaded from: classes2.dex */
    public enum NotifyToRefreshAngleTypeEnum {
        NULL,
        ARC_MOVE_TOUCHED,
        SETTING_BUTTON_CLICKED,
        PHYSIAL_BUTTON_CLICKED,
        PHYSIAL_KNOB_DRIVED
    }

    public NotifyToRefreshAngleTypeEnum getNotifyToRefreshAngleType() {
        return this.notifyToRefreshAngleType;
    }

    public void setNotifyToRefreshAngleType(NotifyToRefreshAngleTypeEnum notifyToRefreshAngleTypeEnum) {
        this.notifyToRefreshAngleType = notifyToRefreshAngleTypeEnum;
    }

    public String getToShowAngle() {
        return this.toShowAngle;
    }

    public FanScaleView(Context context) {
        this(context, null);
    }

    public FanScaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FanScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.percentage = -1;
        init(context, attributeSet, i);
    }

    private void init(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FanScaleView);
        this.fanRadius = obtainStyledAttributes.getInt(5, 200);
        this.fanPaintStartAngle = obtainStyledAttributes.getInt(3, 90);
        this.fanPaintedAngle = obtainStyledAttributes.getInt(4, 45);
        int i2 = this.fanRadius;
        this.fanCentralPointMarginLeft = (0 - i2) + 60;
        this.fanCentralPointMarginTop = 0 - i2;
        this.fanBgColor = obtainStyledAttributes.getInt(1, ViewCompat.MEASURED_STATE_MASK);
        this.ringWidth = obtainStyledAttributes.getInt(9, 2);
        this.ringBgColor = obtainStyledAttributes.getInt(8, -6513508);
        this.slideRingColor = obtainStyledAttributes.getInt(8, -15513486);
        this.slideRingProcessColor = obtainStyledAttributes.getInt(11, -12403002);
        this.maxAngle = obtainStyledAttributes.getInt(6, 45);
        this.minAngle = obtainStyledAttributes.getInt(7, 0);
        this.curAngle = obtainStyledAttributes.getInt(0, 0);
        this.dragBitmapWidth = dp2px(60.0f);
        this.dragBitmapHight = dp2px(60.0f);
        Bitmap bitmapFromVectorDrawable = getBitmapFromVectorDrawable(context, R.drawable.ic_dragring);
        this.dragBitmap = bitmapFromVectorDrawable;
        this.dragBitmap = zoomBitmap(bitmapFromVectorDrawable, this.dragBitmapWidth, this.dragBitmapHight);
        this.fanBgLeftBitmapWidth = obtainStyledAttributes.getInt(2, 10);
        Bitmap bitmapFromVectorDrawable2 = getBitmapFromVectorDrawable(context, R.drawable.ic_fannedleftline);
        this.fanBgLeftBitmap = bitmapFromVectorDrawable2;
        this.fanBgLeftBitmap = zoomBitmap(bitmapFromVectorDrawable2, this.fanBgLeftBitmapWidth, this.fanRadius);
        this.slideAbleLocation = dp2px(30.0f);
        this.toShowAngle = "0%";
        this.toShowAngleColor = obtainStyledAttributes.getInt(12, -16731474);
        this.toShowAngleFontsize = obtainStyledAttributes.getInt(13, 32);
        this.notifyToRefreshAngleType = NotifyToRefreshAngleTypeEnum.NULL;
        initPaint(context);
    }

    private void initPaint(Context context) {
        Paint paint = new Paint();
        this.fanBgPaint = paint;
        paint.setColor(this.fanBgColor);
        this.fanBgPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.ringBgPaint = paint2;
        paint2.setColor(this.ringBgColor);
        this.ringBgPaint.setAntiAlias(true);
        this.ringBgPaint.setStyle(Paint.Style.STROKE);
        this.ringBgPaint.setStrokeWidth(this.ringWidth);
        this.ringBgPaint.setStrokeCap(Paint.Cap.BUTT);
        this.ringBgPaint.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f}, 0.0f));
        Paint paint3 = new Paint();
        this.ringBgDesPaint = paint3;
        paint3.setColor(this.fanBgColor);
        Paint paint4 = new Paint();
        this.slideRingPaint = paint4;
        paint4.setColor(this.slideRingColor);
        this.slideRingPaint.setAntiAlias(true);
        Paint paint5 = new Paint();
        this.slideRingProcessPaint = paint5;
        paint5.setColor(this.slideRingProcessColor);
        this.slideRingProcessPaint.setAntiAlias(true);
        this.slideRingProcessPaint.setStyle(Paint.Style.STROKE);
        this.slideRingProcessPaint.setStrokeWidth(this.ringWidth);
        this.slideRingProcessPaint.setStrokeCap(Paint.Cap.BUTT);
        Paint paint6 = new Paint();
        this.fanBgLeftBitmapPaint = paint6;
        paint6.setDither(true);
        this.fanBgLeftBitmapPaint.setFilterBitmap(true);
        this.fanBgLeftBitmapPaint.setAntiAlias(true);
        Paint paint7 = new Paint();
        this.dragBitmapPaint = paint7;
        paint7.setDither(true);
        this.dragBitmapPaint.setFilterBitmap(true);
        this.dragBitmapPaint.setAntiAlias(true);
        Paint paint8 = new Paint();
        this.toShowAnglePaint = paint8;
        paint8.setColor(this.toShowAngleColor);
        this.toShowAnglePaint.setTypeface(Typeface.DEFAULT);
        this.toShowAnglePaint.setTextSize(sp2px(this.toShowAngleFontsize));
        if (this.toShowAngleRect == null) {
            this.toShowAngleRect = new Rect();
        }
        Paint paint9 = this.toShowAnglePaint;
        String str = this.toShowAngle;
        paint9.getTextBounds(str, 0, str.length(), this.toShowAngleRect);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            size = this.fanRadius + getPaddingLeft() + getPaddingRight();
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            size2 = this.fanRadius + getPaddingTop() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        if (this.fanBgRectF == null) {
            this.fanBgRectF = new RectF();
        }
        RectF rectF = this.fanBgRectF;
        float f = this.ringWidth;
        float f2 = paddingLeft;
        float f3 = this.fanCentralPointMarginLeft;
        float f4 = paddingTop;
        float f5 = this.fanCentralPointMarginTop;
        int i2 = this.fanRadius;
        rectF.set((f / 2.0f) + f2 + f3, (f / 2.0f) + f4 + f5, ((i2 * 2) - (f / 2.0f)) + f2 + f3, ((i2 * 2) - (f / 2.0f)) + f4 + f5);
        canvas.drawArc(this.fanBgRectF, this.fanPaintStartAngle, 0.0f - this.fanPaintedAngle, true, this.fanBgPaint);
        canvas.drawArc(this.fanBgRectF, this.fanPaintStartAngle, 0.0f - this.fanPaintedAngle, true, this.ringBgPaint);
        this.ringBgDesPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        int i3 = this.fanRadius;
        float f6 = this.fanCentralPointMarginLeft;
        canvas.drawLine(i3 + paddingLeft + f6, i3 + paddingTop + this.fanCentralPointMarginTop, i3 + paddingLeft + f6, i3, this.ringBgDesPaint);
        if (this.slideRingRectF == null) {
            this.slideRingRectF = new RectF();
        }
        RectF rectF2 = this.slideRingRectF;
        float f7 = this.ringWidth;
        float f8 = this.fanCentralPointMarginLeft;
        float f9 = this.fanCentralPointMarginTop;
        int i4 = this.fanRadius;
        rectF2.set((f7 / 2.0f) + f2 + f8, (f7 / 2.0f) + f4 + f9, ((i4 * 2) - (f7 / 2.0f)) + f2 + f8, ((i4 * 2) - (f7 / 2.0f)) + f4 + f9);
        canvas.drawArc(this.slideRingRectF, this.fanPaintStartAngle, 0.0f - this.curAngle, true, this.slideRingPaint);
        canvas.drawArc(this.slideRingRectF, this.fanPaintStartAngle, 0.0f - this.curAngle, false, this.slideRingProcessPaint);
        Bitmap bitmap = this.fanBgLeftBitmap;
        int i5 = this.fanRadius;
        canvas.drawBitmap(bitmap, ((i5 + paddingLeft) + this.fanCentralPointMarginLeft) - this.fanBgLeftBitmapWidth, i5 + paddingTop + this.fanCentralPointMarginTop, this.fanBgLeftBitmapPaint);
        PointF calcArcEndPointXY = calcArcEndPointXY(i + paddingLeft + this.fanCentralPointMarginLeft, i + paddingTop + this.fanCentralPointMarginTop, this.fanRadius - (this.ringWidth / 2.0f), this.curAngle, this.fanPaintStartAngle);
        canvas.drawBitmap(this.dragBitmap, ((int) calcArcEndPointXY.x) - (this.dragBitmap.getWidth() / 2), ((int) calcArcEndPointXY.y) - (this.dragBitmap.getHeight() / 2), this.dragBitmapPaint);
        Paint paint = this.toShowAnglePaint;
        String str = this.toShowAngle;
        paint.getTextBounds(str, 0, str.length(), this.toShowAngleRect);
        canvas.drawText(this.toShowAngle, (((this.fanRadius + paddingLeft) + this.fanCentralPointMarginLeft) + 120.0f) - ((this.toShowAngleRect.width() * 1.0f) / 2.0f), this.fanRadius + paddingTop + this.fanCentralPointMarginTop + 10.0f + (this.toShowAngleRect.height() * 1.0f), this.toShowAnglePaint);
    }

    @Override // android.view.View
    public synchronized boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        if (action != 0) {
            if (action != 1) {
                if (action == 2 && validateIsSlidingOnRing(x, y)) {
                    updatAangle(x, y);
                    this.mIsOnSlideRingTouchingEvent = true;
                }
            } else {
                invalidate();
                if (this.mIsOnSlideRingTouchingEvent) {
                    this.notifyToRefreshAngleType = NotifyToRefreshAngleTypeEnum.ARC_MOVE_TOUCHED;
                    MotorManager.getInstance().setPosition(Integer.valueOf(this.toShowAngle.replace("%", "")).intValue());
                    this.mIsOnSlideRingTouchingEvent = false;
                }
            }
        } else if (validateIsSlidingOnRing(x, y)) {
            updatAangle(x, y);
            this.mIsOnSlideRingTouchingEvent = true;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0057, code lost:
        if (r2 > r3) goto L3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean validateIsSlidingOnRing(float r8, float r9) {
        /*
            r7 = this;
            int r0 = r7.fanRadius
            int r1 = r7.getPaddingLeft()
            int r0 = r0 + r1
            float r0 = (float) r0
            float r1 = r7.fanCentralPointMarginLeft
            float r0 = r0 + r1
            float r0 = r8 - r0
            double r0 = (double) r0
            r2 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = java.lang.Math.pow(r0, r2)
            int r4 = r7.fanRadius
            int r5 = r7.getPaddingTop()
            int r4 = r4 + r5
            float r4 = (float) r4
            float r5 = r7.fanCentralPointMarginTop
            float r4 = r4 + r5
            float r4 = r9 - r4
            double r4 = (double) r4
            double r2 = java.lang.Math.pow(r4, r2)
            double r0 = r0 + r2
            double r0 = java.lang.Math.sqrt(r0)
            int r2 = r7.fanRadius
            int r3 = r7.getPaddingLeft()
            int r2 = r2 + r3
            float r2 = (float) r2
            float r3 = r7.fanCentralPointMarginLeft
            float r2 = r2 + r3
            float r2 = r8 - r2
            int r3 = r7.fanRadius
            int r4 = r7.getPaddingTop()
            int r3 = r3 + r4
            float r3 = (float) r3
            float r4 = r7.fanCentralPointMarginTop
            float r3 = r3 + r4
            float r3 = r9 - r3
            float r2 = r7.calcAngleWithPointXY(r2, r3)
            int r3 = r7.minAngle
            float r4 = (float) r3
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 >= 0) goto L52
        L50:
            float r2 = (float) r3
            goto L5a
        L52:
            int r3 = r7.maxAngle
            float r4 = (float) r3
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 <= 0) goto L5a
            goto L50
        L5a:
            int r3 = r7.fanRadius
            int r4 = r7.slideAbleLocation
            int r5 = r3 + r4
            double r5 = (double) r5
            int r5 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r5 >= 0) goto L9e
            int r3 = r3 - r4
            double r3 = (double) r3
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L9e
            int r0 = r7.minAngle
            float r0 = (float) r0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 < 0) goto L9e
            int r0 = r7.maxAngle
            float r0 = (float) r0
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 > 0) goto L9e
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r8)
            java.lang.String r8 = ","
            r0.append(r8)
            r0.append(r9)
            java.lang.String r8 = ", 当前角度："
            r0.append(r8)
            r0.append(r2)
            java.lang.String r8 = r0.toString()
            java.lang.String r9 = "当前位置："
            android.util.Log.d(r9, r8)
            r7.curAngle = r2
            r8 = 1
            goto L9f
        L9e:
            r8 = 0
        L9f:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.baseview.FanScaleView.validateIsSlidingOnRing(float, float):boolean");
    }

    public boolean refreshFanByInputAngle(int i) {
        float f;
        if (i < 0 || i > 100) {
            return false;
        }
        String str = this.toShowAngle;
        StringBuilder sb = new StringBuilder();
        sb.append(Math.round(i));
        sb.append("%");
        if (str.equals(sb.toString())) {
            return true;
        }
        this.percentage = i;
        this.toShowAngle = Math.round(f) + "%";
        this.curAngle = (float) ((this.maxAngle * i) / 100);
        Log.d("当前刷新角度：", this.curAngle + "");
        invalidate();
        return true;
    }

    protected void updatAangle(int i, int i2) {
        this.percentage = Math.round((this.curAngle / this.maxAngle) * 100.0f);
        String str = this.percentage + "%";
        this.toShowAngle = str;
        Log.d("当前角度百分比：", str);
        invalidate();
    }

    protected int dp2px(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    protected int sp2px(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    protected Bitmap getBitmapFromVectorDrawable(Context context, int i) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (Build.VERSION.SDK_INT < 21) {
            drawable = DrawableCompat.wrap(drawable).mutate();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    protected Bitmap zoomBitmap(Bitmap bitmap, int i, int i2) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(i / width, i2 / height);
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
    }

    protected PointF calcArcEndPointXY(float f, float f2, float f3, float f4, float f5) {
        return calcArcEndPointXY(f, f2, f3, (f5 - f4) % 360.0f);
    }

    protected PointF calcArcEndPointXY(float f, float f2, float f3, float f4) {
        double sin;
        double sin2;
        float f5 = (float) ((f4 * 3.141592653589793d) / 180.0d);
        if (f4 < 90.0f) {
            double d = f5;
            f += ((float) Math.cos(d)) * f3;
            sin2 = Math.sin(d);
        } else {
            int i = (f4 > 90.0f ? 1 : (f4 == 90.0f ? 0 : -1));
            if (i == 0) {
                f2 += f3;
            } else if (i <= 0 || f4 >= 180.0f) {
                int i2 = (f4 > 180.0f ? 1 : (f4 == 180.0f ? 0 : -1));
                if (i2 == 0) {
                    f -= f3;
                } else {
                    if (i2 > 0 && f4 < 270.0f) {
                        double d2 = (float) (((f4 - 180.0f) * 3.141592653589793d) / 180.0d);
                        f -= ((float) Math.cos(d2)) * f3;
                        sin = Math.sin(d2);
                    } else if (f4 == 270.0f) {
                        f2 -= f3;
                    } else {
                        double d3 = (float) (((360.0f - f4) * 3.141592653589793d) / 180.0d);
                        f += ((float) Math.cos(d3)) * f3;
                        sin = Math.sin(d3);
                    }
                    f2 -= ((float) sin) * f3;
                }
            } else {
                double d4 = (float) (((180.0f - f4) * 3.141592653589793d) / 180.0d);
                f -= ((float) Math.cos(d4)) * f3;
                sin2 = Math.sin(d4);
            }
            return new PointF(f, f2);
        }
        f2 += ((float) sin2) * f3;
        return new PointF(f, f2);
    }

    protected float calcAngleWithPointXY(float f, float f2) {
        return (float) (Math.atan2(f, f2) * 57.29577951308232d);
    }

    public float getCurAngle() {
        return this.curAngle;
    }

    public int getPercentage() {
        return this.percentage;
    }
}
