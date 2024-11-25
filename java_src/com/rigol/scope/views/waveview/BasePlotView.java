package com.rigol.scope.views.waveview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.R;
import com.rigol.scope.views.waveview.PlotEnum;
/* loaded from: classes2.dex */
public class BasePlotView extends View {
    protected static final int LINE_MARGIN_8 = 8;
    protected static final int PLOT_MARGIN_2 = 2;
    protected static final int STROKE_WIDTH = 3;
    protected boolean mBConvertPlotData;
    protected boolean mBDrawDashLine;
    private boolean mBDrawMidDashLine;
    protected boolean mBDrawPlot;
    protected boolean mBDrawRect;
    protected float[] mConvertedPlotData;
    protected DashPathEffect mDashPathEffect;
    protected int mDefColor;
    protected PlotEnum.ConnectionTypeEnum mEuConnType;
    protected PlotEnum.PlotDisplayModeEnum mEuDisplayMode;
    protected short mMaxVal;
    protected short mMinVal;
    protected short[] mOriginPlotData;
    protected Paint mPaint;
    protected Path mPath;
    protected int mPlotColor;
    protected int mPlotHeight;
    protected int mPlotWidth;
    protected int mRectColor;
    protected int mViewHeight;
    protected int mViewWidth;

    protected void initPlotParams() {
    }

    public BasePlotView(Context context) {
        super(context);
        this.mEuConnType = PlotEnum.ConnectionTypeEnum.LINE;
        this.mEuDisplayMode = PlotEnum.PlotDisplayModeEnum.OFFSET_VIEW;
        this.mDashPathEffect = new DashPathEffect(new float[]{10.0f, 4.0f}, 0.0f);
        this.mPlotWidth = 0;
        this.mPlotHeight = 0;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mMaxVal = (short) 0;
        this.mMinVal = (short) 0;
        this.mBConvertPlotData = false;
        this.mOriginPlotData = new short[0];
        this.mConvertedPlotData = new float[0];
        this.mBDrawDashLine = false;
        this.mBDrawMidDashLine = false;
        this.mBDrawRect = false;
        this.mBDrawPlot = true;
        this.mPaint = new Paint();
        int color = getContext().getColor(R.color.light_gray);
        this.mPlotColor = color;
        this.mPaint.setColor(color);
        this.mDefColor = getContext().getColor(R.color.light_gray);
        this.mRectColor = getContext().getColor(R.color.light_gray);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(3.0f);
        this.mPaint.setAntiAlias(true);
        this.mPath = new Path();
    }

    public BasePlotView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mEuConnType = PlotEnum.ConnectionTypeEnum.LINE;
        this.mEuDisplayMode = PlotEnum.PlotDisplayModeEnum.OFFSET_VIEW;
        this.mDashPathEffect = new DashPathEffect(new float[]{10.0f, 4.0f}, 0.0f);
        this.mPlotWidth = 0;
        this.mPlotHeight = 0;
        this.mViewWidth = 0;
        this.mViewHeight = 0;
        this.mMaxVal = (short) 0;
        this.mMinVal = (short) 0;
        this.mBConvertPlotData = false;
        this.mOriginPlotData = new short[0];
        this.mConvertedPlotData = new float[0];
        this.mBDrawDashLine = false;
        this.mBDrawMidDashLine = false;
        this.mBDrawRect = false;
        this.mBDrawPlot = true;
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mPlotColor = -1;
        paint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(3.0f);
        this.mPath = new Path();
    }

    public void setPlotColor(int i) {
        this.mPlotColor = i;
    }

    public void setDrawDashLine(boolean z) {
        this.mBDrawDashLine = z;
    }

    public void setDrawRect(boolean z) {
        this.mBDrawRect = z;
    }

    public void setRectColor(int i) {
        this.mRectColor = i;
    }

    public void setDrawPlot(boolean z) {
        this.mBDrawPlot = z;
    }

    public void setEuConnType(PlotEnum.ConnectionTypeEnum connectionTypeEnum) {
        this.mEuConnType = connectionTypeEnum;
    }

    public void setBDrawMidDashLine(boolean z) {
        this.mBDrawMidDashLine = z;
    }

    public void setConvertPlotData(short[] sArr, short s, short s2, PlotEnum.PlotDisplayModeEnum plotDisplayModeEnum) {
        this.mOriginPlotData = sArr;
        this.mMaxVal = s2;
        this.mMinVal = s;
        this.mBConvertPlotData = true;
        this.mEuDisplayMode = plotDisplayModeEnum;
    }

    public void setConvertPlotData(float[] fArr, int i, int i2, PlotEnum.PlotDisplayModeEnum plotDisplayModeEnum) {
        int i3 = i2 - i;
        float f = (-i3) / 2.0f;
        float f2 = i3 / 2.0f;
        float f3 = (i2 + i) / 2.0f;
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        int i4 = 0;
        if (f >= -32768.0f && f2 <= 32767.0f) {
            this.mOriginPlotData = new short[fArr.length];
            while (i4 < fArr.length) {
                this.mOriginPlotData[i4] = (short) ((fArr[i4] - f3) * 0.9999f);
                i4++;
            }
            this.mMaxVal = (short) f2;
            this.mMinVal = (short) f;
        } else if (f2 == f) {
            return;
        } else {
            float f4 = 65535.0f / (f2 - f);
            this.mOriginPlotData = new short[fArr.length];
            while (i4 < fArr.length) {
                this.mOriginPlotData[i4] = (short) ((fArr[i4] - f3) * f4 * 0.9999f);
                i4++;
            }
            this.mMaxVal = (short) (f2 * f4);
            this.mMinVal = (short) (f * f4);
        }
        this.mBConvertPlotData = true;
        this.mEuDisplayMode = plotDisplayModeEnum;
    }

    public void setConvertPlotData(short[] sArr, short s, short s2, PlotEnum.PlotDisplayModeEnum plotDisplayModeEnum, PlotEnum.ConnectionTypeEnum connectionTypeEnum) {
        setConvertPlotData(sArr, s, s2, plotDisplayModeEnum);
        this.mEuConnType = connectionTypeEnum;
    }

    protected void drawRect(Canvas canvas) {
        int i;
        if (canvas == null) {
            LogUtils.dTag("drawWaveform: canvas is null", new Object[0]);
            return;
        }
        this.mPath.reset();
        this.mPaint.setPathEffect(null);
        this.mPaint.setColor(this.mRectColor);
        int i2 = this.mViewHeight;
        if (i2 < 0 || (i = this.mViewWidth) < 0) {
            return;
        }
        canvas.drawRect(0.0f, 0.0f, i, i2, this.mPaint);
    }

    protected void drawDashedLine(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        this.mPaint.setPathEffect(this.mDashPathEffect);
        this.mPath.reset();
        this.mPaint.setColor(this.mRectColor);
        this.mPath.moveTo(0.0f, 8.0f);
        this.mPath.lineTo(this.mViewWidth, 8.0f);
        canvas.drawPath(this.mPath, this.mPaint);
        if (this.mPlotHeight == 0) {
            this.mPlotHeight = this.mViewHeight - 16;
        }
        this.mPath.moveTo(0.0f, this.mPlotHeight + 8);
        this.mPath.lineTo(this.mViewWidth, this.mPlotHeight + 8);
        canvas.drawPath(this.mPath, this.mPaint);
        if (true == this.mBDrawMidDashLine) {
            this.mPath.moveTo(0.0f, (this.mPlotHeight / 2.0f) + 8.0f);
            this.mPath.lineTo(this.mViewWidth, (this.mPlotHeight / 2.0f) + 8.0f);
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    public void updateView() {
        invalidate();
    }
}
