package com.rigol.scope.views.waveview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.data.WaveParam;
import com.rigol.scope.views.waveview.PlotEnum;
/* loaded from: classes2.dex */
public class AwgPlotView extends View {
    protected static final int LINE_MARGIN_8 = 8;
    protected static final int STROKE_WIDTH = 1;
    private int haikuiTotalLen;
    protected boolean mBConvertPlotData;
    protected boolean mBDrawDashLine;
    private boolean mBDrawMidDashLine;
    protected boolean mBDrawPlot;
    protected boolean mBDrawRect;
    protected boolean mBIConvertPlotData;
    protected boolean mBQConvertPlotData;
    protected float[] mConvertedPlotData;
    protected DashPathEffect mDashPathEffect;
    protected PlotEnum.ConnectionTypeEnum mEuConnType;
    protected PlotEnum.PlotDisplayModeEnum mEuDisplayMode;
    protected float[] mIConvertedPlotData;
    protected short mIMaxVal;
    protected short mIMinVal;
    protected short[] mIOriginPlotData;
    private WaveParam.WaveEditTypeEnum mIWaveEditTypeEnum;
    protected short mMaxVal;
    protected short mMinVal;
    protected short[] mOriginPlotData;
    protected Paint mPaint;
    protected Path mPath;
    protected int mPlotColor;
    protected int mPlotHeight;
    protected int mPlotWidth;
    protected float[] mQConvertedPlotData;
    protected short mQMaxVal;
    protected short mQMinVal;
    protected short[] mQOriginPlotData;
    private WaveParam.WaveEditTypeEnum mQWaveEditTypeEnum;
    private int[] mS32CommonArray;
    private int[] mS32ICommonArray;
    private int[] mS32QCommonArray;
    protected int mViewHeight;
    protected int mViewWidth;
    private WaveParam.WaveEditTypeEnum mWaveEditTypeEnum;

    protected void drawMarker(WaveParam.MarkerTypeEnum markerTypeEnum, Canvas canvas) {
    }

    protected void initPlotParams() {
    }

    public void setHaikuiTotalLen(int i) {
        this.haikuiTotalLen = i;
    }

    public AwgPlotView(Context context) {
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
        this.mBIConvertPlotData = false;
        this.mBQConvertPlotData = false;
        this.mOriginPlotData = new short[0];
        this.mConvertedPlotData = new float[0];
        this.mIConvertedPlotData = new float[0];
        this.mQConvertedPlotData = new float[0];
        this.mBDrawDashLine = false;
        this.mBDrawMidDashLine = false;
        this.mBDrawRect = false;
        this.mBDrawPlot = true;
        this.mS32CommonArray = new int[2];
        this.mS32ICommonArray = new int[2];
        this.mS32QCommonArray = new int[2];
        this.mIOriginPlotData = new short[0];
        this.mQOriginPlotData = new short[0];
        this.mIMaxVal = (short) 0;
        this.mIMinVal = (short) 0;
        this.mQMaxVal = (short) 0;
        this.mQMinVal = (short) 0;
        this.haikuiTotalLen = 0;
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mPlotColor = -1;
        paint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(1.0f);
        this.mPath = new Path();
    }

    public AwgPlotView(Context context, AttributeSet attributeSet) {
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
        this.mBIConvertPlotData = false;
        this.mBQConvertPlotData = false;
        this.mOriginPlotData = new short[0];
        this.mConvertedPlotData = new float[0];
        this.mIConvertedPlotData = new float[0];
        this.mQConvertedPlotData = new float[0];
        this.mBDrawDashLine = false;
        this.mBDrawMidDashLine = false;
        this.mBDrawRect = false;
        this.mBDrawPlot = true;
        this.mS32CommonArray = new int[2];
        this.mS32ICommonArray = new int[2];
        this.mS32QCommonArray = new int[2];
        this.mIOriginPlotData = new short[0];
        this.mQOriginPlotData = new short[0];
        this.mIMaxVal = (short) 0;
        this.mIMinVal = (short) 0;
        this.mQMaxVal = (short) 0;
        this.mQMinVal = (short) 0;
        this.haikuiTotalLen = 0;
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mPlotColor = -1;
        paint.setColor(-1);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(1.0f);
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

    public void setDrawPlot(boolean z) {
        this.mBDrawPlot = z;
    }

    public WaveParam.WaveEditTypeEnum getWaveEditTypeEnum() {
        return this.mWaveEditTypeEnum;
    }

    public void setWaveEditTypeEnum(WaveParam.WaveEditTypeEnum waveEditTypeEnum) {
        this.mWaveEditTypeEnum = waveEditTypeEnum;
    }

    public WaveParam.WaveEditTypeEnum getIWaveEditTypeEnum() {
        return this.mIWaveEditTypeEnum;
    }

    public void setIWaveEditTypeEnum(WaveParam.WaveEditTypeEnum waveEditTypeEnum) {
        this.mIWaveEditTypeEnum = waveEditTypeEnum;
    }

    public WaveParam.WaveEditTypeEnum getQWaveEditTypeEnum() {
        return this.mQWaveEditTypeEnum;
    }

    public void setQWaveEditTypeEnum(WaveParam.WaveEditTypeEnum waveEditTypeEnum) {
        this.mQWaveEditTypeEnum = waveEditTypeEnum;
    }

    public int[] getS32CommonArray() {
        return this.mS32CommonArray;
    }

    public void setS32CommonArray(int[] iArr) {
        this.mS32CommonArray = iArr;
    }

    public int[] getS32ICommonArray() {
        return this.mS32ICommonArray;
    }

    public void setS32ICommonArray(int[] iArr) {
        this.mS32ICommonArray = iArr;
    }

    public int[] getS32QCommonArray() {
        return this.mS32QCommonArray;
    }

    public void setS32QCommonArray(int[] iArr) {
        this.mS32CommonArray = iArr;
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

    public void setConvertPlotData(double[] dArr, double d, double d2, PlotEnum.PlotDisplayModeEnum plotDisplayModeEnum) {
        double d3 = d2 - d;
        double d4 = (-d3) / 2.0d;
        double d5 = d3 / 2.0d;
        double d6 = (d2 + d) / 2.0d;
        if (dArr == null || dArr.length <= 0) {
            return;
        }
        int i = 0;
        if (d4 < -32768.0d || d5 > 32767.0d) {
            if (d5 == d4) {
                return;
            }
            double d7 = 65535.0d / (d5 - d4);
            this.mOriginPlotData = new short[dArr.length];
            while (i < dArr.length) {
                this.mOriginPlotData[i] = (short) ((dArr[i] - d6) * d7 * 0.9998999834060669d);
                i++;
            }
            this.mMaxVal = (short) (d5 * d7);
            this.mMinVal = (short) (d4 * d7);
        } else if (d5 == d4) {
            return;
        } else {
            double d8 = 65535.0d / (d5 - d4);
            this.mOriginPlotData = new short[dArr.length];
            while (i < dArr.length) {
                this.mOriginPlotData[i] = (short) ((dArr[i] - d6) * d8 * 0.9998999834060669d);
                i++;
            }
            this.mMaxVal = (short) (d5 * d8);
            this.mMinVal = (short) (d4 * d8);
        }
        this.mBConvertPlotData = true;
        this.mEuDisplayMode = plotDisplayModeEnum;
    }

    public void setIConvertPlotData(float[] fArr, int i, int i2, PlotEnum.PlotDisplayModeEnum plotDisplayModeEnum) {
        int i3 = i2 - i;
        float f = (-i3) / 2.0f;
        float f2 = i3 / 2.0f;
        float f3 = (i2 + i) / 2.0f;
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        int i4 = 0;
        if (f >= -32768.0f && f2 <= 32767.0f) {
            this.mIOriginPlotData = new short[fArr.length];
            while (i4 < fArr.length) {
                this.mIOriginPlotData[i4] = (short) ((fArr[i4] - f3) * 0.9999f);
                i4++;
            }
            this.mIMaxVal = (short) f2;
            this.mIMinVal = (short) f;
        } else if (f2 == f) {
            return;
        } else {
            float f4 = 65535.0f / (f2 - f);
            this.mIOriginPlotData = new short[fArr.length];
            while (i4 < fArr.length) {
                this.mIOriginPlotData[i4] = (short) ((fArr[i4] - f3) * f4 * 0.9999f);
                i4++;
            }
            this.mIMaxVal = (short) (f2 * f4);
            this.mIMinVal = (short) (f * f4);
        }
        this.mBIConvertPlotData = true;
        this.mEuDisplayMode = plotDisplayModeEnum;
    }

    public void setQConvertPlotData(float[] fArr, int i, int i2, PlotEnum.PlotDisplayModeEnum plotDisplayModeEnum) {
        int i3 = i2 - i;
        float f = (-i3) / 2.0f;
        float f2 = i3 / 2.0f;
        float f3 = (i2 + i) / 2.0f;
        if (fArr == null || fArr.length <= 0) {
            return;
        }
        int i4 = 0;
        if (f >= -32768.0f && f2 <= 32767.0f) {
            this.mQOriginPlotData = new short[fArr.length];
            while (i4 < fArr.length) {
                this.mQOriginPlotData[i4] = (short) ((fArr[i4] - f3) * 0.9999f);
                i4++;
            }
            this.mQMaxVal = (short) f2;
            this.mQMinVal = (short) f;
        } else if (f2 == f) {
            return;
        } else {
            float f4 = 65535.0f / (f2 - f);
            this.mQOriginPlotData = new short[fArr.length];
            while (i4 < fArr.length) {
                this.mQOriginPlotData[i4] = (short) ((fArr[i4] - f3) * f4 * 0.9999f);
                i4++;
            }
            this.mQMaxVal = (short) (f2 * f4);
            this.mQMinVal = (short) (f * f4);
        }
        this.mBQConvertPlotData = true;
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
        int i2 = this.mViewHeight;
        if (i2 < 0 || (i = this.mViewWidth) < 0) {
            return;
        }
        canvas.drawRect(1.0f, 1.0f, i - 1, i2 - 1, this.mPaint);
    }

    protected void drawDashedLine(Canvas canvas) {
        if (canvas == null) {
            return;
        }
        this.mPaint.setPathEffect(this.mDashPathEffect);
        this.mPath.reset();
        this.mPath.moveTo(0.0f, 8.0f);
        this.mPath.lineTo(this.mViewWidth, 8.0f);
        canvas.drawPath(this.mPath, this.mPaint);
        this.mPath.moveTo(0.0f, this.mPlotHeight + 8);
        this.mPath.lineTo(this.mViewWidth, this.mPlotHeight + 8);
        canvas.drawPath(this.mPath, this.mPaint);
        if (true == this.mBDrawMidDashLine) {
            this.mPath.moveTo(0.0f, (this.mPlotHeight / 2.0f) + 8.0f);
            this.mPath.lineTo(this.mViewWidth, (this.mPlotHeight / 2.0f) + 8.0f);
            canvas.drawPath(this.mPath, this.mPaint);
        }
    }

    protected void drawPlot(Canvas canvas) {
        float[] convertShortPlotDataToOffsetView;
        float[] convertShortPlotDataToOffsetView2;
        int[] iArr;
        short[] sArr;
        if (canvas == null) {
            return;
        }
        short[] sArr2 = this.mOriginPlotData;
        if ((sArr2 == null || sArr2.length == 0) && this.mWaveEditTypeEnum != WaveParam.WaveEditTypeEnum.ADVANCE_IQ) {
            return;
        }
        short[] sArr3 = this.mIOriginPlotData;
        if ((sArr3 == null || sArr3.length == 0 || (sArr = this.mQOriginPlotData) == null || sArr.length == 0) && this.mWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.ADVANCE_IQ) {
            return;
        }
        int i = 1;
        if (this.mWaveEditTypeEnum != WaveParam.WaveEditTypeEnum.ADVANCE_IQ) {
            if (true == this.mBConvertPlotData) {
                if (this.mEuDisplayMode == PlotEnum.PlotDisplayModeEnum.FULL_VIEW) {
                    this.mConvertedPlotData = AwgConvertPlotDataUtil.convertShortPlotDataToFullView(this.mOriginPlotData, this.mMinVal, this.mMaxVal, this.mPlotWidth, this.mPlotHeight);
                } else if (this.mEuDisplayMode == PlotEnum.PlotDisplayModeEnum.HAIKUI_VIEW) {
                    this.mConvertedPlotData = AwgConvertPlotDataUtil.convertShortPlotDataToFullView(this.mOriginPlotData, this.mMinVal, this.mMaxVal, this.haikuiTotalLen, this.mPlotHeight);
                } else {
                    this.mConvertedPlotData = AwgConvertPlotDataUtil.convertShortPlotDataToOffsetView(this.mOriginPlotData, this.mMinVal, this.mMaxVal, this.mPlotWidth, this.mPlotHeight);
                }
                this.mBConvertPlotData = false;
            }
        } else {
            if (true == this.mBIConvertPlotData) {
                if (this.mEuDisplayMode == PlotEnum.PlotDisplayModeEnum.FULL_VIEW) {
                    convertShortPlotDataToOffsetView2 = AwgConvertPlotDataUtil.convertShortPlotDataToFullView(this.mIOriginPlotData, this.mIMinVal, this.mIMaxVal, this.mPlotWidth, this.mPlotHeight);
                } else if (this.mEuDisplayMode == PlotEnum.PlotDisplayModeEnum.HAIKUI_VIEW) {
                    convertShortPlotDataToOffsetView2 = AwgConvertPlotDataUtil.convertShortPlotDataToFullView(this.mIOriginPlotData, this.mIMinVal, this.mIMaxVal, this.haikuiTotalLen, this.mPlotHeight);
                } else {
                    convertShortPlotDataToOffsetView2 = AwgConvertPlotDataUtil.convertShortPlotDataToOffsetView(this.mIOriginPlotData, this.mIMinVal, this.mIMaxVal, this.mPlotWidth, this.mPlotHeight);
                }
                this.mIConvertedPlotData = new float[convertShortPlotDataToOffsetView2.length];
                for (int i2 = 0; i2 < convertShortPlotDataToOffsetView2.length; i2++) {
                    this.mIConvertedPlotData[i2] = convertShortPlotDataToOffsetView2[i2] * 0.42857143f;
                }
                this.mBIConvertPlotData = false;
            }
            if (true == this.mBQConvertPlotData) {
                if (this.mEuDisplayMode == PlotEnum.PlotDisplayModeEnum.FULL_VIEW) {
                    convertShortPlotDataToOffsetView = AwgConvertPlotDataUtil.convertShortPlotDataToFullView(this.mQOriginPlotData, this.mQMinVal, this.mQMaxVal, this.mPlotWidth, this.mPlotHeight);
                } else if (this.mEuDisplayMode == PlotEnum.PlotDisplayModeEnum.HAIKUI_VIEW) {
                    convertShortPlotDataToOffsetView = AwgConvertPlotDataUtil.convertShortPlotDataToFullView(this.mQOriginPlotData, this.mQMinVal, this.mQMaxVal, this.haikuiTotalLen, this.mPlotHeight);
                } else {
                    convertShortPlotDataToOffsetView = AwgConvertPlotDataUtil.convertShortPlotDataToOffsetView(this.mQOriginPlotData, this.mQMinVal, this.mQMaxVal, this.mPlotWidth, this.mPlotHeight);
                }
                this.mQConvertedPlotData = new float[convertShortPlotDataToOffsetView.length];
                for (int i3 = 0; i3 < convertShortPlotDataToOffsetView.length; i3++) {
                    this.mQConvertedPlotData[i3] = (convertShortPlotDataToOffsetView[i3] * 0.42857143f) + (this.mPlotHeight / 2);
                }
                this.mBQConvertPlotData = false;
            }
        }
        int i4 = this.mBDrawDashLine ? 8 : 0;
        if (this.mEuDisplayMode == PlotEnum.PlotDisplayModeEnum.HAIKUI_VIEW) {
            this.mPath.reset();
            this.mPaint.setPathEffect(null);
            this.mPaint.setColor(this.mPlotColor);
            float f = i4;
            this.mPath.moveTo(0.0f, this.mConvertedPlotData[0] + f);
            int i5 = (int) (this.haikuiTotalLen / this.mPlotWidth);
            for (int i6 = 1; i6 < this.mPlotWidth; i6++) {
                for (int i7 = 1; i7 < i5; i7++) {
                    int i8 = i6 - 1;
                    this.mPath.lineTo(i8, this.mConvertedPlotData[(i8 * i5) + i7] + f);
                }
                int i9 = i6 * i5;
                this.mPath.lineTo(i6 - 1, this.mConvertedPlotData[i9] + f);
                this.mPath.lineTo(i6, this.mConvertedPlotData[i9] + f);
            }
            canvas.drawPath(this.mPath, this.mPaint);
        } else if (this.mWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.BASIC_EDIT || this.mWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.TABLE_EDIT || this.mWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.FORMULA_EDIT) {
            this.mPath.reset();
            this.mPaint.setPathEffect(null);
            this.mPaint.setColor(this.mPlotColor);
            float f2 = i4;
            this.mPath.moveTo(0.0f, this.mConvertedPlotData[0] + f2);
            int min = Math.min(this.mConvertedPlotData.length, this.mPlotWidth);
            if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                while (i < min) {
                    this.mPath.lineTo(i - 1, this.mConvertedPlotData[i] + f2);
                    this.mPath.lineTo(i, this.mConvertedPlotData[i] + f2);
                    i++;
                }
            } else {
                for (int i10 = 0; i10 < min; i10++) {
                    this.mPath.lineTo(i10, this.mConvertedPlotData[i10] + f2);
                }
            }
            canvas.drawPath(this.mPath, this.mPaint);
        } else if (this.mWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.ADVANCE_MTONE) {
            this.mPath.reset();
            this.mPaint.setPathEffect(null);
            this.mPaint.setColor(this.mPlotColor);
            float f3 = i4;
            this.mPath.moveTo(0.0f, this.mConvertedPlotData[0] + f3);
            int min2 = Math.min(this.mConvertedPlotData.length, this.mPlotWidth);
            int[] iArr2 = this.mS32CommonArray;
            if (iArr2[0] == iArr2[1]) {
                if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                    while (i < min2) {
                        this.mPath.lineTo(i - 1, this.mConvertedPlotData[i] + f3);
                        this.mPath.lineTo(i, this.mConvertedPlotData[i] + f3);
                        i++;
                    }
                } else {
                    while (i < min2) {
                        this.mPath.lineTo(i, this.mConvertedPlotData[i] + f3);
                        i++;
                    }
                }
                canvas.drawPath(this.mPath, this.mPaint);
                return;
            }
            if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                for (int i11 = 1; i11 < this.mS32CommonArray[0]; i11++) {
                    this.mPath.lineTo(i11 - 1, this.mConvertedPlotData[i11] + f3);
                    this.mPath.lineTo(i11, this.mConvertedPlotData[i11] + f3);
                }
                canvas.drawPath(this.mPath, this.mPaint);
            } else {
                for (int i12 = 1; i12 < this.mS32CommonArray[0]; i12++) {
                    this.mPath.lineTo(i12, this.mConvertedPlotData[i12] + f3);
                }
                canvas.drawPath(this.mPath, this.mPaint);
            }
            this.mPath.reset();
            this.mPaint.setPathEffect(null);
            this.mPaint.setColor(this.mPlotColor);
            this.mPath.moveTo(iArr[1] - 1, this.mConvertedPlotData[this.mS32CommonArray[1] - 1] + f3);
            if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                for (int i13 = this.mS32CommonArray[1] + 1; i13 < min2; i13++) {
                    this.mPath.lineTo(i13 - 1, this.mConvertedPlotData[i13] + f3);
                    this.mPath.lineTo(i13, this.mConvertedPlotData[i13] + f3);
                }
                canvas.drawPath(this.mPath, this.mPaint);
            } else {
                for (int i14 = this.mS32CommonArray[1]; i14 < min2; i14++) {
                    this.mPath.lineTo(i14, this.mConvertedPlotData[i14] + f3);
                }
                canvas.drawPath(this.mPath, this.mPaint);
            }
            this.mPath.reset();
            this.mPaint.setPathEffect(null);
            this.mPaint.setColor(this.mPlotColor);
            for (int i15 = this.mS32CommonArray[0]; i15 < this.mS32CommonArray[1] - 1; i15 += 4) {
                canvas.drawPoint(i15, ((int) this.mConvertedPlotData[i15]) + i4, this.mPaint);
            }
        } else if (this.mWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.ADVANCE_IQ) {
            this.mPath.reset();
            this.mPaint.setPathEffect(null);
            this.mPaint.setColor(this.mPlotColor);
            float f4 = i4;
            this.mPath.moveTo(0.0f, this.mIConvertedPlotData[0] + f4);
            int min3 = Math.min(this.mIConvertedPlotData.length, this.mPlotWidth);
            if (this.mIWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.BASIC_EDIT) {
                if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                    for (int i16 = 1; i16 < min3; i16++) {
                        this.mPath.lineTo(i16 - 1, this.mIConvertedPlotData[i16] + f4);
                        this.mPath.lineTo(i16, this.mIConvertedPlotData[i16] + f4);
                    }
                } else {
                    for (int i17 = 1; i17 < min3; i17++) {
                        this.mPath.lineTo(i17, this.mIConvertedPlotData[i17] + f4);
                    }
                }
                canvas.drawPath(this.mPath, this.mPaint);
            } else if (this.mIWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.TABLE_EDIT) {
                if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                    for (int i18 = 1; i18 < min3; i18++) {
                        this.mPath.lineTo(i18 - 1, this.mIConvertedPlotData[i18] + f4);
                        this.mPath.lineTo(i18, this.mIConvertedPlotData[i18] + f4);
                    }
                } else {
                    for (int i19 = 1; i19 < min3; i19++) {
                        this.mPath.lineTo(i19, this.mIConvertedPlotData[i19] + f4);
                    }
                }
                canvas.drawPath(this.mPath, this.mPaint);
            } else if (this.mIWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.ADVANCE_MTONE) {
                int[] iArr3 = this.mS32ICommonArray;
                if (iArr3[0] == iArr3[1]) {
                    if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                        for (int i20 = 1; i20 < min3; i20++) {
                            this.mPath.lineTo(i20 - 1, this.mIConvertedPlotData[i20] + f4);
                            this.mPath.lineTo(i20, this.mIConvertedPlotData[i20] + f4);
                        }
                    } else {
                        for (int i21 = 1; i21 < min3; i21++) {
                            this.mPath.lineTo(i21, this.mIConvertedPlotData[i21] + f4);
                        }
                    }
                    canvas.drawPath(this.mPath, this.mPaint);
                } else {
                    if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                        for (int i22 = 1; i22 < this.mS32ICommonArray[0]; i22++) {
                            this.mPath.lineTo(i22 - 1, this.mIConvertedPlotData[i22] + f4);
                            this.mPath.lineTo(i22, this.mIConvertedPlotData[i22] + f4);
                        }
                        canvas.drawPath(this.mPath, this.mPaint);
                    } else {
                        for (int i23 = 1; i23 < this.mS32ICommonArray[0]; i23++) {
                            this.mPath.lineTo(i23, this.mIConvertedPlotData[i23] + f4);
                        }
                        canvas.drawPath(this.mPath, this.mPaint);
                    }
                    this.mPath.reset();
                    this.mPaint.setPathEffect(null);
                    this.mPaint.setColor(this.mPlotColor);
                    this.mPath.moveTo(this.mS32ICommonArray[1] - 1, this.mIConvertedPlotData[this.mS32CommonArray[1] - 1] + f4);
                    if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                        for (int i24 = this.mS32ICommonArray[1] + 1; i24 < min3; i24++) {
                            this.mPath.lineTo(i24 - 1, this.mIConvertedPlotData[i24] + f4);
                            this.mPath.lineTo(i24, this.mIConvertedPlotData[i24] + f4);
                        }
                        canvas.drawPath(this.mPath, this.mPaint);
                    } else {
                        for (int i25 = this.mS32ICommonArray[1]; i25 < min3; i25++) {
                            this.mPath.lineTo(i25, this.mIConvertedPlotData[i25] + f4);
                        }
                        canvas.drawPath(this.mPath, this.mPaint);
                    }
                    this.mPath.reset();
                    this.mPaint.setPathEffect(null);
                    this.mPaint.setColor(this.mPlotColor);
                    for (int i26 = this.mS32ICommonArray[0]; i26 < this.mS32ICommonArray[1] - 1; i26 += 4) {
                        canvas.drawPoint(i26, ((int) this.mIConvertedPlotData[i26]) + i4, this.mPaint);
                    }
                }
            }
            this.mPath.reset();
            this.mPaint.setPathEffect(null);
            this.mPaint.setColor(this.mPlotColor);
            this.mPath.moveTo(0.0f, this.mQConvertedPlotData[0] + f4);
            if (this.mQWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.BASIC_EDIT) {
                if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                    while (i < min3) {
                        this.mPath.lineTo(i - 1, this.mQConvertedPlotData[i] + f4);
                        this.mPath.lineTo(i, this.mQConvertedPlotData[i] + f4);
                        i++;
                    }
                } else {
                    while (i < min3) {
                        this.mPath.lineTo(i, this.mQConvertedPlotData[i] + f4);
                        i++;
                    }
                }
                canvas.drawPath(this.mPath, this.mPaint);
            } else if (this.mQWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.TABLE_EDIT) {
                if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                    while (i < min3) {
                        this.mPath.lineTo(i - 1, this.mQConvertedPlotData[i] + f4);
                        this.mPath.lineTo(i, this.mQConvertedPlotData[i] + f4);
                        i++;
                    }
                } else {
                    while (i < min3) {
                        this.mPath.lineTo(i, this.mQConvertedPlotData[i] + f4);
                        i++;
                    }
                }
                canvas.drawPath(this.mPath, this.mPaint);
            } else if (this.mQWaveEditTypeEnum == WaveParam.WaveEditTypeEnum.ADVANCE_MTONE) {
                int[] iArr4 = this.mS32QCommonArray;
                if (iArr4[0] == iArr4[1]) {
                    if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                        while (i < min3) {
                            this.mPath.lineTo(i - 1, this.mQConvertedPlotData[i] + f4);
                            this.mPath.lineTo(i, this.mQConvertedPlotData[i] + f4);
                            i++;
                        }
                    } else {
                        while (i < min3) {
                            this.mPath.lineTo(i, this.mQConvertedPlotData[i] + f4);
                            i++;
                        }
                    }
                    canvas.drawPath(this.mPath, this.mPaint);
                    return;
                }
                if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                    for (int i27 = 1; i27 < this.mS32QCommonArray[0]; i27++) {
                        this.mPath.lineTo(i27 - 1, this.mQConvertedPlotData[i27] + f4);
                        this.mPath.lineTo(i27, this.mQConvertedPlotData[i27] + f4);
                    }
                    canvas.drawPath(this.mPath, this.mPaint);
                } else {
                    for (int i28 = 1; i28 < this.mS32QCommonArray[0]; i28++) {
                        this.mPath.lineTo(i28, this.mQConvertedPlotData[i28] + f4);
                    }
                    canvas.drawPath(this.mPath, this.mPaint);
                }
                this.mPath.reset();
                this.mPaint.setPathEffect(null);
                this.mPaint.setColor(this.mPlotColor);
                this.mPath.moveTo(this.mS32QCommonArray[1] - 1, this.mQConvertedPlotData[this.mS32CommonArray[1] - 1] + f4);
                if (this.mEuConnType == PlotEnum.ConnectionTypeEnum.RIGHT_ANGLE) {
                    for (int i29 = this.mS32QCommonArray[1] + 1; i29 < min3; i29++) {
                        this.mPath.lineTo(i29 - 1, this.mQConvertedPlotData[i29] + f4);
                        this.mPath.lineTo(i29, this.mQConvertedPlotData[i29] + f4);
                    }
                    canvas.drawPath(this.mPath, this.mPaint);
                } else {
                    for (int i30 = this.mS32QCommonArray[1]; i30 < min3; i30++) {
                        this.mPath.lineTo(i30, this.mQConvertedPlotData[i30] + f4);
                    }
                    canvas.drawPath(this.mPath, this.mPaint);
                }
                this.mPath.reset();
                this.mPaint.setPathEffect(null);
                this.mPaint.setColor(this.mPlotColor);
                for (int i31 = this.mS32QCommonArray[0]; i31 < this.mS32QCommonArray[1] - 1; i31 += 4) {
                    canvas.drawPoint(i31, ((int) this.mQConvertedPlotData[i31]) + i4, this.mPaint);
                }
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.mViewWidth = getMeasuredWidth();
        this.mViewHeight = getMeasuredHeight();
        this.mPlotHeight = this.mViewHeight - (true == this.mBDrawDashLine ? 16 : 0);
        this.mPlotWidth = this.mViewWidth;
        this.mPath.reset();
        canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
        if (true == this.mBDrawPlot) {
            drawPlot(canvas);
        }
        if (this.mBDrawRect) {
            drawRect(canvas);
        }
        if (this.mBDrawDashLine) {
            drawDashedLine(canvas);
        }
    }

    public void updateView() {
        invalidate();
    }
}
