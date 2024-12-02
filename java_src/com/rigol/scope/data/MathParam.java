package com.rigol.scope.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.Bindable;
import androidx.exifinterface.media.ExifInterface;
import com.rigol.scope.R;
import com.rigol.scope.adapters.MathLogicAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ScaleNumUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;

/* loaded from: classes2.dex */
public class MathParam extends BaseParam {
    private static final boolean DEFAULT_COLORGRADE = false;
    private static final int DEFAULT_DIFFSMOOTH = 5;
    private static final long DEFAULT_FFTOFFSET = 0;
    private static final int DEFAULT_INTGBIAS = 0;
    private static final boolean DEFAULT_INVERT = false;
    private static final boolean DEFAULT_LABELONOFF = false;
    private static final long DEFAULT_LINEA = 1000000;
    private static final long DEFAULT_LINEB = 0;
    private static final long DEFAULT_LOGICOFFSET = 0;
    private static final long DEFAULT_OFFSET = 0;
    private static final int DEFAULT_PEAKNUM = 5;
    private static final boolean DEFAULT_PEAKSEARCH = false;
    private static final boolean DEFAULT_PEAKSETTING = false;
    private static final int DEFAULT_SENS = 300;
    private static final long DEFAULT_START = 0;
    private static final boolean DEFAULT_STATUS = false;
    private static final long DEFAULT_THREADCHAN1 = 0;
    private static final long DEFAULT_THREADCHAN2 = 0;
    private static final long DEFAULT_THREADCHAN3 = 0;
    private static final long DEFAULT_THREADCHAN4 = 0;
    public static final int LOGICOFFSET_RATIO = 1000000;
    public static final int SENS_RATIO = 100;
    private final MessageAttr anaOffsetAttr;
    private final MessageAttr anaScaleAttr;
    private AorBManager aorBManager;
    private long bpFreq1;
    private final MessageAttr bpFreq1Attr;
    private long bpFreq2;
    private final MessageAttr bpFreq2Attr;
    private long btFreq1;
    private final MessageAttr btFreq1Attr;
    private long btFreq2;
    private final MessageAttr btFreq2Attr;
    private ServiceEnum.Chan chan;
    private int closedColor;
    private boolean colorGrade;
    private Drawable defaultBackground;
    private int defaultColor;
    private int diffSmooth;
    private final MessageAttr diffSmoothAttr;
    private ServiceEnum.VertExpand expandIndex;
    private long fftCenter;
    private final MessageAttr fftCenterAttr;
    private long fftEnd;
    private final MessageAttr fftEndAttr;
    private ServiceEnum.Unit fftFreqUnit;
    private long fftOffset;
    private final MessageAttr fftOffsetAttr;
    private String fftOffsetStr;
    private ServiceEnum.enPeakOrder fftPeakOrderIndex;
    private long fftScale;
    private final MessageAttr fftScaleAttr;
    private String fftScaleStr;
    private long fftSpan;
    private final MessageAttr fftSpanAttr;
    private long fftStart;
    private final MessageAttr fftStartAttr;
    private ServiceEnum.fftSpecUnit fftUnitIndex;
    private ServiceEnum.fftWindow fftWindowIndex;
    private long fftZoomCenter;
    private long fftZoomEnd;
    private long fftZoomHScale;
    private long fftZoomSpan;
    private long fftZoomStart;
    private ServiceEnum.FftxType fftxTypeIndex;
    private ServiceEnum.Unit filterUnit;
    private ServiceEnum.EWaveGrids grids;
    private long hpFreq;
    private final MessageAttr hpFreqAttr;
    private long intgBias;
    private final MessageAttr intgBiasAttr;
    private ServiceEnum.Unit intgBiasUnit;
    private boolean invert;
    private boolean label;
    private String labelString;
    private long lineA;
    private final MessageAttr lineAAttr;
    private long lineB;
    private final MessageAttr lineBAttr;
    private long logicOffset;
    private final MessageAttr logicOffsetAttr;
    private long logicScale;
    private ServiceEnum.LaScale logicSizeIndex;
    private long lpFreq;
    private final MessageAttr lpFreqAttr;
    private MathLogicAdapter mathLogicAdapter;
    private long offset;
    private String offsetString;
    private ServiceEnum.MathOperator operator;
    private String operatorString;
    private long peakExcursion;
    private final MessageAttr peakExcursionAttr;
    private String peakExcursionStr;
    private int peakNum;
    private final MessageAttr peakNumAttr;
    private boolean peakSearch;
    private long peakThreshold;
    private final MessageAttr peakThresholdAttr;
    private String peakThresholdStr;
    private long scale;
    private String scaleString;
    private Drawable selectedBackground;
    private int sens;
    private boolean showPeakSetting;
    private ServiceEnum.Chan sourceArithAIndex;
    private ServiceEnum.Chan sourceArithBIndex;
    private ServiceEnum.Chan sourceFftIndex;
    private ServiceEnum.Chan sourceLogicAIndex;
    private ServiceEnum.Chan sourceLogicBIndex;
    private long srcSa;
    private boolean status;
    private long thresholdCH1;
    private final MessageAttr thresholdCH1Attr;
    private long thresholdCH2;
    private final MessageAttr thresholdCH2Attr;
    private long thresholdCH3;
    private final MessageAttr thresholdCH3Attr;
    private long thresholdCH4;
    private final MessageAttr thresholdCH4Attr;
    private final MessageAttr thresholdSensAttr;
    private ServiceEnum.Unit thresholdUnit;
    private String title;
    private ServiceEnum.Unit unitIndex;
    private ServiceEnum.MathWaveType waveType;
    private String windowTitleString;
    private boolean zoomEn;
    private static final ServiceEnum.EWaveGrids DEFAULT_GRIDS = ServiceEnum.EWaveGrids.GRID_IS_FULL;
    private static final ServiceEnum.MathWaveType DEFAULT_WAVETYPE = ServiceEnum.MathWaveType.MathWave_Main;
    private static final ServiceEnum.MathOperator DEFAULT_OPERATOR = ServiceEnum.MathOperator.operator_add;
    private static final ServiceEnum.Chan DEFAULT_SOURCEARITHA = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.Chan DEFAULT_SOURCEARITHB = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.Chan DEFAULT_SOURCELOGICA = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.Chan DEFAULT_SOURCELOGICB = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.Chan DEFAULT_SOURCEFFT = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.VertExpand DEFAULT_EXPAND = ServiceEnum.VertExpand.vert_expand_gnd;
    private static final ServiceEnum.LaScale DEFAULT_LOGICSIZE = ServiceEnum.LaScale.Medium;
    private static final ServiceEnum.fftWindow DEFAULT_FFTWIN = ServiceEnum.fftWindow.fft_hanning;
    private static final ServiceEnum.enPeakOrder DEFAULT_PEAKORDER = ServiceEnum.enPeakOrder.fft_peak_AmpOrder;
    private static final ServiceEnum.fftSpecUnit DEFAULT_FFTUNIT = ServiceEnum.fftSpecUnit.fft_spec_db;
    private static final long DEFAULT_SCALE = (long) (Math.pow(1000.0d, UnitFormat.SI.MILLI.scale - UnitFormat.SI.NANO.scale) * 500.0d);
    private static final long DEFAULT_LOGICSCALE = (long) (Math.pow(1000.0d, UnitFormat.SI.NONE.scale - UnitFormat.SI.NANO.scale) * 1.0d);
    private static final long DEFAULT_FFTSCALE = (long) (Math.pow(1000.0d, UnitFormat.SI.NONE.scale - UnitFormat.SI.NANO.scale) * 20.0d);
    private static final long DEFAULT_LP = (long) (Math.pow(1000.0d, UnitFormat.SI.KILO.scale - UnitFormat.SI.MICRO.scale) * 20000.0d);
    private static final long DEFAULT_HP = (long) (Math.pow(1000.0d, UnitFormat.SI.KILO.scale - UnitFormat.SI.MICRO.scale) * 20000.0d);
    private static final long DEFAULT_BP1 = (long) (Math.pow(1000.0d, UnitFormat.SI.KILO.scale - UnitFormat.SI.MICRO.scale) * 20000.0d);
    private static final long DEFAULT_BP2 = (long) (Math.pow(1000.0d, UnitFormat.SI.KILO.scale - UnitFormat.SI.MICRO.scale) * 40000.0d);
    private static final long DEFAULT_BT1 = (long) (Math.pow(1000.0d, UnitFormat.SI.KILO.scale - UnitFormat.SI.MICRO.scale) * 20000.0d);
    private static final long DEFAULT_BT2 = (long) (Math.pow(1000.0d, UnitFormat.SI.KILO.scale - UnitFormat.SI.MICRO.scale) * 40000.0d);
    private static final ServiceEnum.Unit DEFAULT_BISAUNIT = ServiceEnum.Unit.Unit_V;
    private static final long DEFAULT_CENTER = (long) (Math.pow(1000.0d, UnitFormat.SI.MEGA.scale - UnitFormat.SI.MICRO.scale) * 5.0d);
    private static final long DEFAULT_SPAN = (long) (Math.pow(1000.0d, UnitFormat.SI.MEGA.scale - UnitFormat.SI.MICRO.scale) * 10.0d);
    private static final long DEFAULT_END = (long) (Math.pow(1000.0d, UnitFormat.SI.MEGA.scale - UnitFormat.SI.MICRO.scale) * 10.0d);
    private static final long DEFAULT_PEAKTHRE = (long) (Math.pow(1000.0d, UnitFormat.SI.NONE.scale - UnitFormat.SI.NANO.scale) * 5.5d);
    private static final long DEFAULT_EXCURSION = (long) (Math.pow(1000.0d, UnitFormat.SI.NONE.scale - UnitFormat.SI.NANO.scale) * 1.8d);
    private static final String TAG = MathParam.class.getSimpleName();

    public static int getServiceId(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    return i != 3 ? 0 : 20;
                }
                return 19;
            }
            return 18;
        }
        return 17;
    }

    public void setMathLogicAdapter(MathLogicAdapter mathLogicAdapter) {
        this.mathLogicAdapter = mathLogicAdapter;
    }

    public MathLogicAdapter getMathLogicAdapter() {
        return this.mathLogicAdapter;
    }

    public MathParam(Context context, String str, int i) {
        super(i);
        this.operator = ServiceEnum.MathOperator.operator_add;
        this.sourceArithAIndex = ServiceEnum.Chan.chan1;
        this.sourceArithBIndex = ServiceEnum.Chan.chan1;
        this.sourceLogicAIndex = ServiceEnum.Chan.chan1;
        this.sourceLogicBIndex = ServiceEnum.Chan.chan1;
        this.sourceFftIndex = ServiceEnum.Chan.chan1;
        this.unitIndex = ServiceEnum.Unit.Unit_none;
        this.thresholdUnit = ServiceEnum.Unit.Unit_V;
        this.filterUnit = ServiceEnum.Unit.Unit_hz;
        this.fftFreqUnit = ServiceEnum.Unit.Unit_hz;
        this.expandIndex = ServiceEnum.VertExpand.vert_expand_gnd;
        this.logicSizeIndex = ServiceEnum.LaScale.Small;
        this.fftxTypeIndex = ServiceEnum.FftxType.fft_span_center;
        this.fftWindowIndex = ServiceEnum.fftWindow.fft_rectangle;
        this.fftPeakOrderIndex = ServiceEnum.enPeakOrder.fft_peak_AmpOrder;
        this.fftUnitIndex = ServiceEnum.fftSpecUnit.fft_spec_db;
        this.logicScale = DEFAULT_LOGICSCALE;
        this.showPeakSetting = false;
        this.anaOffsetAttr = new MessageAttr();
        this.anaScaleAttr = new MessageAttr();
        this.fftOffsetAttr = new MessageAttr();
        this.fftScaleAttr = new MessageAttr();
        this.logicOffsetAttr = new MessageAttr();
        this.intgBiasAttr = new MessageAttr();
        this.diffSmoothAttr = new MessageAttr();
        this.lineAAttr = new MessageAttr();
        this.lineBAttr = new MessageAttr();
        this.thresholdSensAttr = new MessageAttr();
        this.thresholdCH1Attr = new MessageAttr();
        this.thresholdCH2Attr = new MessageAttr();
        this.thresholdCH3Attr = new MessageAttr();
        this.thresholdCH4Attr = new MessageAttr();
        this.lpFreqAttr = new MessageAttr();
        this.hpFreqAttr = new MessageAttr();
        this.bpFreq1Attr = new MessageAttr();
        this.bpFreq2Attr = new MessageAttr();
        this.btFreq1Attr = new MessageAttr();
        this.btFreq2Attr = new MessageAttr();
        this.fftSpanAttr = new MessageAttr();
        this.fftCenterAttr = new MessageAttr();
        this.fftStartAttr = new MessageAttr();
        this.fftEndAttr = new MessageAttr();
        this.peakNumAttr = new MessageAttr();
        this.peakThresholdAttr = new MessageAttr();
        this.peakExcursionAttr = new MessageAttr();
        this.mathLogicAdapter = null;
        this.title = str;
        this.defaultColor = ColorUtil.getColor(context, i);
        this.closedColor = ContextCompat.getColor(context, R.color.gray_regent);
        this.defaultBackground = ContextUtil.getDrawable(context, (int) R.drawable.bg_item_math);
        this.selectedBackground = ContextUtil.getSelectedBackground(context, R.drawable.bg_item_math, this.defaultColor);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readAllParam();
        readAllAttr();
    }

    public void readAllParam() {
        readOperator();
        readStatus();
        readUnit();
        readLable();
        readLableString();
        readGrids();
        readZoomEn();
        readWaveType();
        readSourceArithA();
        readSourceArithB();
        readScale();
        readOffset();
        readInvert();
        readExpand();
        readSourceFft();
        readFftXType();
        readFftUnit();
        readFftStart();
        readFftEnd();
        readFftCenter();
        readFftSpan();
        readFftWindow();
        readFftOffset();
        readFftScale();
        readColorGrade();
        readPeakSearch();
        readPeakNum();
        readPeakThreshold();
        readPeakExcursion();
        readFftPeakOrder();
        readFftZoomStart();
        readFftZoomHScale();
        readIntgBias();
        readSmooth();
        readLineA();
        readLineB();
        readSourceLogicA();
        readSourceLogicB();
        readLogicScale();
        readLogicOffset();
        readSens();
        readThresholdCH1();
        readThresholdCH2();
        readThresholdCH3();
        readThresholdCH4();
        readLpFreq();
        readHpFreq();
        readBpFreq1();
        readBpFreq2();
        readBtFreq1();
        readBtFreq2();
    }

    public void readAllAttr() {
        readAnaOffsetAttr();
        readAnaScaleAttr();
        readFftOffsetAttr();
        readFftScaleAttr();
        readLogicOffsetAttr();
        readIntgBiasAttr();
        readDiffSmoothAttr();
        readLinAAttr();
        readLinBAttr();
        readThresholdSensAttr();
        readThresholdCH1Attr();
        readThresholdCH2Attr();
        readThresholdCH3Attr();
        readThresholdCH4Attr();
        readLpFreqAttr();
        readHpFreqAttr();
        readBpFreq1Attr();
        readBpFreq2Attr();
        readBtFreq1Attr();
        readBtFreq2Attr();
        readFftSpanAttr();
        readFftCenterAttr();
        readFftStartAttr();
        readFftEndAttr();
        readPeakNumAttr();
        readPeakThresholdAttr();
        readPeakExcursionAttr();
    }

    public MessageAttr getAnaOffsetAttr() {
        return this.anaOffsetAttr;
    }

    public MessageAttr getAnaScaleAttr() {
        return this.anaScaleAttr;
    }

    public MessageAttr getFftOffsetAttr() {
        return this.fftOffsetAttr;
    }

    public MessageAttr getFftScaleAttr() {
        return this.fftScaleAttr;
    }

    public MessageAttr getLogicOffsetAttr() {
        return this.logicOffsetAttr;
    }

    public MessageAttr getThresholdSensAttr() {
        return this.thresholdSensAttr;
    }

    public MessageAttr getThresholdCH1Attr() {
        return this.thresholdCH1Attr;
    }

    public MessageAttr getThresholdCH2Attr() {
        return this.thresholdCH2Attr;
    }

    public MessageAttr getThresholdCH3Attr() {
        return this.thresholdCH3Attr;
    }

    public MessageAttr getThresholdCH4Attr() {
        return this.thresholdCH4Attr;
    }

    public MessageAttr getLpFreqAttr() {
        return this.lpFreqAttr;
    }

    public MessageAttr getHpFreqAttr() {
        return this.hpFreqAttr;
    }

    public MessageAttr getBpFreq1Attr() {
        return this.bpFreq1Attr;
    }

    public MessageAttr getBpFreq2Attr() {
        return this.bpFreq2Attr;
    }

    public MessageAttr getBtFreq1Attr() {
        return this.btFreq1Attr;
    }

    public MessageAttr getBtFreq2Attr() {
        return this.btFreq2Attr;
    }

    public MessageAttr getDiffSmoothAttr() {
        return this.diffSmoothAttr;
    }

    public MessageAttr getIntgBiasAttr() {
        return this.intgBiasAttr;
    }

    public MessageAttr getLineAAttr() {
        return this.lineAAttr;
    }

    public MessageAttr getLineBAttr() {
        return this.lineBAttr;
    }

    public MessageAttr getFftSpanAttr() {
        return this.fftSpanAttr;
    }

    public MessageAttr getFftCenterAttr() {
        return this.fftCenterAttr;
    }

    public MessageAttr getFftStartAttr() {
        return this.fftStartAttr;
    }

    public MessageAttr getFftEndAttr() {
        return this.fftEndAttr;
    }

    public MessageAttr getPeakNumAttr() {
        return this.peakNumAttr;
    }

    public MessageAttr getPeakThresholdAttr() {
        return this.peakThresholdAttr;
    }

    public MessageAttr getPeakExcursionAttr() {
        return this.peakExcursionAttr;
    }

    public void readAnaOffsetAttr() {
        readAttr(MessageID.MSG_MATH_VIEW_OFFSET, this.anaOffsetAttr);
    }

    public void readAnaScaleAttr() {
        readAttr(MessageID.MSG_MATH_ANALOG_S32SCALE, this.anaScaleAttr);
    }

    public void readFftOffsetAttr() {
        readAttr(MessageID.MSG_MATH_FFT_OFFSET, this.fftOffsetAttr);
    }

    public void readFftScaleAttr() {
        readAttr(MessageID.MSG_MATH_FFT_SCALE, this.fftScaleAttr);
    }

    public void readLogicOffsetAttr() {
        readAttr(MessageID.MSG_MATH_LOGIC_OFFSET, this.logicOffsetAttr);
    }

    public void readIntgBiasAttr() {
        readAttr(MessageID.MSG_MATH_INTGOPT_BIAS, this.intgBiasAttr);
    }

    public void readDiffSmoothAttr() {
        readAttr(MessageID.MSG_MATH_DIFF_SMOOTH, this.diffSmoothAttr);
    }

    public void readLinAAttr() {
        readAttr(MessageID.MSG_MATH_LINEOPT_A, this.lineAAttr);
    }

    public void readLinBAttr() {
        readAttr(MessageID.MSG_MATH_LINEOPT_B, this.lineBAttr);
    }

    public void readThresholdSensAttr() {
        readAttr(MessageID.MSG_MATH_LOGIC_S32SENS, this.thresholdSensAttr);
    }

    public void readThresholdCH1Attr() {
        readAttr(MessageID.MSG_MATH_LOGIC_S32THRE1, this.thresholdCH1Attr);
    }

    public void readThresholdCH2Attr() {
        readAttr(MessageID.MSG_MATH_LOGIC_S32THRE2, this.thresholdCH2Attr);
    }

    public void readThresholdCH3Attr() {
        readAttr(MessageID.MSG_MATH_LOGIC_S32THRE3, this.thresholdCH3Attr);
    }

    public void readThresholdCH4Attr() {
        readAttr(MessageID.MSG_MATH_LOGIC_S32THRE4, this.thresholdCH4Attr);
    }

    public void readLpFreqAttr() {
        readAttr(MessageID.MSG_MATH_S32FILTER_LP, this.lpFreqAttr);
    }

    public void readHpFreqAttr() {
        readAttr(MessageID.MSG_MATH_S32FILTER_HP, this.hpFreqAttr);
    }

    public void readBpFreq1Attr() {
        readAttr(MessageID.MSG_MATH_S32FILTER_BP1, this.bpFreq1Attr);
    }

    public void readBpFreq2Attr() {
        readAttr(MessageID.MSG_MATH_S32FILTER_BP2, this.bpFreq2Attr);
    }

    public void readBtFreq1Attr() {
        readAttr(MessageID.MSG_MATH_S32FILTER_BT1, this.btFreq1Attr);
    }

    public void readBtFreq2Attr() {
        readAttr(MessageID.MSG_MATH_S32FILTER_BT2, this.btFreq2Attr);
    }

    public void readFftSpanAttr() {
        readAttr(MessageID.MSG_MATH_FFT_H_SPAN, this.fftSpanAttr);
    }

    public void readFftCenterAttr() {
        readAttr(MessageID.MSG_MATH_FFT_H_CENTER, this.fftCenterAttr);
    }

    public void readFftStartAttr() {
        readAttr(MessageID.MSG_MATH_FFT_H_START, this.fftStartAttr);
    }

    public void readFftEndAttr() {
        readAttr(MessageID.MSG_MATH_FFT_H_END, this.fftEndAttr);
    }

    public void readPeakNumAttr() {
        readAttr(MessageID.MSG_MATH_FFT_PEAK_MAXPEAKS, this.peakNumAttr);
    }

    public void readPeakThresholdAttr() {
        readAttr(MessageID.MSG_MATH_FFT_PEAK_THRESHOLD, this.peakThresholdAttr);
    }

    public void readPeakExcursionAttr() {
        readAttr(MessageID.MSG_MATH_FFT_PEAK_EXCURSION, this.peakExcursionAttr);
    }

    public ServiceEnum.Chan getChan() {
        switch (getServiceId()) {
            case 17:
                this.chan = ServiceEnum.Chan.m1;
                break;
            case 18:
                this.chan = ServiceEnum.Chan.m2;
                break;
            case 19:
                this.chan = ServiceEnum.Chan.m3;
                break;
            case 20:
                this.chan = ServiceEnum.Chan.m4;
                break;
            default:
                this.chan = ServiceEnum.Chan.chan_none;
                break;
        }
        return this.chan;
    }

    public void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    @Bindable
    public boolean isZoomEn() {
        return this.zoomEn;
    }

    public void setZoomEn(boolean z) {
        this.zoomEn = z;
        notifyPropertyChanged(1089);
    }

    @Bindable
    public ServiceEnum.MathWaveType getWaveType() {
        return this.waveType;
    }

    public void setWaveType(ServiceEnum.MathWaveType mathWaveType) {
        this.waveType = mathWaveType;
        notifyPropertyChanged(1039);
        syncData(MessageID.MSG_MATH_WAVE_TYPE, mathWaveType);
    }

    @Bindable
    public String getLabelString() {
        return this.labelString;
    }

    public void setLabelString(String str) {
        this.labelString = str;
        notifyPropertyChanged(477);
        syncData(MessageID.MSG_MATH_LABEL_STR, str);
    }

    @Bindable
    public boolean getStatus() {
        return this.status;
    }

    public void setStatus(boolean z) {
        this.status = z;
        notifyPropertyChanged(909);
        syncData(MessageID.MSG_MATH_EN, Boolean.valueOf(z));
    }

    @Bindable
    public ServiceEnum.EWaveGrids getGrids() {
        return this.grids;
    }

    public void setGrids(ServiceEnum.EWaveGrids eWaveGrids) {
        this.grids = eWaveGrids;
        notifyPropertyChanged(363);
        syncData(MessageID.MSG_DISPLAY_GRID, eWaveGrids);
    }

    public String getTitle() {
        return this.title;
    }

    public int getDefaultColor() {
        return this.defaultColor;
    }

    public void setDefaultColor(int i) {
        this.defaultColor = i;
    }

    public int getClosedColor() {
        return this.closedColor;
    }

    public void setClosedColor(int i) {
        this.closedColor = i;
    }

    public Drawable getDefaultBackground() {
        return this.defaultBackground;
    }

    public void setDefaultBackground(Drawable drawable) {
        this.defaultBackground = drawable;
    }

    public Drawable getSelectedBackground() {
        return this.selectedBackground;
    }

    public void setSelectedBackground(Drawable drawable) {
        this.selectedBackground = drawable;
    }

    @Bindable
    public long getOffset() {
        return this.offset;
    }

    public void setOffset(long j) {
        this.offset = j;
        updeteOffsetString();
        notifyPropertyChanged(565);
        syncData(MessageID.MSG_MATH_VIEW_OFFSET, Long.valueOf(j));
    }

    @Bindable
    public long getScale() {
        return this.scale;
    }

    public void setScale(long j) {
        this.scale = j;
        updateScaleString();
        updateWindowTitle();
        notifyPropertyChanged(774);
        syncData(MessageID.MSG_MATH_ANALOG_S32SCALE, Long.valueOf(j));
    }

    @Bindable
    public long getLogicOffset() {
        return this.logicOffset;
    }

    public void setLogicOffset(long j) {
        this.logicOffset = j;
        updeteOffsetString();
        notifyPropertyChanged(507);
        syncData(MessageID.MSG_MATH_LOGIC_OFFSET, Long.valueOf(j));
    }

    public long getLogicScale() {
        return this.logicScale;
    }

    public void setLogicScale(long j) {
        this.logicScale = j;
    }

    public void updateLogicScale() {
        if (getLogicSizeIndex() == ServiceEnum.LaScale.Large) {
            setLogicScale(500000000L);
        } else if (getLogicSizeIndex() == ServiceEnum.LaScale.Medium) {
            setLogicScale(1000000000L);
        } else if (getLogicSizeIndex() == ServiceEnum.LaScale.Small) {
            setLogicScale(2000000000L);
        } else {
            setLogicScale(1000000000L);
        }
    }

    @Bindable
    public long getFftOffset() {
        return this.fftOffset;
    }

    public void setFftOffset(long j) {
        this.fftOffset = j;
        updateFftOffsetStr();
        notifyPropertyChanged(296);
        syncData(MessageID.MSG_MATH_FFT_OFFSET, Long.valueOf(j));
    }

    @Bindable
    public long getFftScale() {
        return this.fftScale;
    }

    public void setFftScale(long j) {
        this.fftScale = j;
        updateFftScaleStr();
        notifyPropertyChanged(299);
        syncData(MessageID.MSG_MATH_FFT_SCALE, Long.valueOf(j));
    }

    @Bindable
    public String getFftOffsetStr() {
        return this.fftOffsetStr;
    }

    public void setFftOffsetStr(String str) {
        this.fftOffsetStr = str;
        updeteOffsetString();
        notifyPropertyChanged(297);
    }

    @Bindable
    public String getFftScaleStr() {
        return this.fftScaleStr;
    }

    public void setFftScaleStr(String str) {
        this.fftScaleStr = str;
        updateScaleString();
        notifyPropertyChanged(300);
    }

    public void updateFftOffsetStr() {
        String convert;
        double fftOffset;
        if (getFftUnitIndex() != ServiceEnum.fftSpecUnit.fft_spec_rms) {
            if (Math.abs((getFftOffset() * 1.0d) / 1.0E9d) > 1000.0d) {
                convert = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getFftOffset(), getUnitIndex());
            } else {
                convert = ViewUtil.subNumber(String.valueOf(fftOffset), 5) + getUnitIndex().value2;
            }
        } else {
            convert = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getFftOffset(), getUnitIndex());
        }
        setFftOffsetStr(convert);
    }

    public void updateFftScaleStr() {
        String convert;
        double fftScale;
        if (getFftUnitIndex() != ServiceEnum.fftSpecUnit.fft_spec_rms) {
            if (Math.abs((getFftScale() * 1.0d) / 1.0E9d) > 1000.0d) {
                convert = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getFftScale(), ServiceEnum.Unit.Unit_db);
            } else {
                convert = ViewUtil.subNumber(String.valueOf(fftScale), 5) + ServiceEnum.Unit.Unit_db.value2;
            }
        } else {
            convert = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getFftScale(), getUnitIndex());
        }
        setFftScaleStr(convert);
    }

    public void setOperator(ServiceEnum.MathOperator mathOperator) {
        this.operator = mathOperator;
        updateOperatorString();
        updeteOffsetString();
        updateScaleString();
        updateWindowTitle();
        notifyPropertyChanged(573);
        syncData(MessageID.MSG_MATH_OPERATOR, mathOperator);
    }

    @Bindable
    public ServiceEnum.MathOperator getOperator() {
        return this.operator;
    }

    public void setExpandIndex(ServiceEnum.VertExpand vertExpand) {
        this.expandIndex = vertExpand;
        notifyPropertyChanged(288);
    }

    @Bindable
    public ServiceEnum.VertExpand getExpandIndex() {
        return this.expandIndex;
    }

    public SparseArrayCompat<MappingObject> getSourceLogicA() {
        return ViewUtil.getArray(R.array.msg_math_s32logica);
    }

    public void setSourceLogicAIndex(ServiceEnum.Chan chan) {
        this.sourceLogicAIndex = chan;
        notifyPropertyChanged(868);
        updateOperatorString();
        updateWindowTitle();
    }

    @Bindable
    public ServiceEnum.Chan getSourceLogicAIndex() {
        return this.sourceLogicAIndex;
    }

    public String getSourceLogicAStr() {
        return ViewUtil.getMappingObject(R.array.msg_math_s32logica, getSourceLogicAIndex().value1).getStr();
    }

    public void setLogicSizeIndex(ServiceEnum.LaScale laScale) {
        this.logicSizeIndex = laScale;
        updateScaleString();
        updateLogicScale();
        updateWindowTitle();
        notifyPropertyChanged(508);
    }

    @Bindable
    public ServiceEnum.LaScale getLogicSizeIndex() {
        return this.logicSizeIndex;
    }

    @Bindable
    public ServiceEnum.Chan getSourceArithAIndex() {
        return this.sourceArithAIndex;
    }

    public void setSourceArithAIndex(ServiceEnum.Chan chan) {
        this.sourceArithAIndex = chan;
        notifyPropertyChanged(863);
        updateOperatorString();
    }

    public String getSourceArithAStr() {
        return ViewUtil.getMappingObject(R.array.msg_math_s32aritha, getSourceArithAIndex().value1) == null ? "" : ViewUtil.getMappingObject(R.array.msg_math_s32aritha, getSourceArithAIndex().value1).getStr();
    }

    @Bindable
    public ServiceEnum.Chan getSourceArithBIndex() {
        return this.sourceArithBIndex;
    }

    public void setSourceArithBIndex(ServiceEnum.Chan chan) {
        this.sourceArithBIndex = chan;
        notifyPropertyChanged(864);
        updateOperatorString();
    }

    public String getSourceArithBStr() {
        return ViewUtil.getMappingObject(R.array.msg_math_s32arithb, getSourceArithBIndex().value1) == null ? "" : ViewUtil.getMappingObject(R.array.msg_math_s32arithb, getSourceArithBIndex().value1).getStr();
    }

    @Bindable
    public ServiceEnum.Chan getSourceLogicBIndex() {
        return this.sourceLogicBIndex;
    }

    public void setSourceLogicBIndex(ServiceEnum.Chan chan) {
        this.sourceLogicBIndex = chan;
        notifyPropertyChanged(869);
        updateOperatorString();
        updateWindowTitle();
    }

    public SparseArrayCompat<MappingObject> getSourceLogicB() {
        return ViewUtil.getArray(R.array.msg_math_s32logicb);
    }

    public String getSourceLogicBStr() {
        return ViewUtil.getMappingObject(R.array.msg_math_s32logicb, getSourceLogicBIndex().value1).getStr();
    }

    @Bindable
    public ServiceEnum.Chan getSourceFftIndex() {
        return this.sourceFftIndex;
    }

    public void setSourceFftIndex(ServiceEnum.Chan chan) {
        this.sourceFftIndex = chan;
        notifyPropertyChanged(867);
        updateOperatorString();
    }

    public String getSourceFftStr() {
        return ViewUtil.getMappingObject(R.array.msg_math_fft_s32src, getSourceFftIndex().value1).getStr();
    }

    public SparseArrayCompat<MappingObject> getFftWindow() {
        return ViewUtil.getArray(R.array.msg_math_fft_s32window);
    }

    @Bindable
    public ServiceEnum.fftWindow getFftWindowIndex() {
        return this.fftWindowIndex;
    }

    public void setFftWindowIndex(ServiceEnum.fftWindow fftwindow) {
        this.fftWindowIndex = fftwindow;
        notifyPropertyChanged(304);
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Bindable
    public boolean isColorGrade() {
        return this.colorGrade;
    }

    public void setColorGrade(boolean z) {
        this.colorGrade = z;
        notifyPropertyChanged(185);
    }

    @Bindable
    public boolean getInvert() {
        return this.invert;
    }

    public void setInvert(boolean z) {
        this.invert = z;
        notifyPropertyChanged(444);
    }

    @Bindable
    public boolean isLabel() {
        return this.label;
    }

    public void setLabel(boolean z) {
        this.label = z;
        notifyPropertyChanged(475);
        syncData(MessageID.MSG_MATH_SHOW_S32LABEL, Boolean.valueOf(z));
    }

    @Bindable
    public boolean isPeakSearch() {
        return this.peakSearch;
    }

    public void setPeakSearch(boolean z) {
        this.peakSearch = z;
        notifyPropertyChanged(614);
        syncData(MessageID.MSG_MATH_FFT_PEAK_ENABLE, Boolean.valueOf(z));
    }

    @Bindable
    public ServiceEnum.Unit getUnitIndex() {
        return this.unitIndex;
    }

    public void setUnitIndex(ServiceEnum.Unit unit) {
        if (unit.value1 == this.unitIndex.value1) {
            return;
        }
        this.unitIndex = unit;
        notifyPropertyChanged(988);
        syncData(MessageID.MSG_MATH_UNIT, unit);
        updateScaleString();
        updeteOffsetString();
        updateFftOffsetStr();
        updatePeakThresholdStr();
        updateFftScaleStr();
        updatePeakExcursionStr();
        updateWindowTitle();
    }

    @Bindable
    public int getSens() {
        return this.sens;
    }

    public void setSens(int i) {
        this.sens = i;
        notifyPropertyChanged(797);
    }

    @Bindable
    public long getThresholdCH1() {
        return this.thresholdCH1;
    }

    public void setThresholdCH1(long j) {
        this.thresholdCH1 = j;
        notifyPropertyChanged(924);
    }

    @Bindable
    public long getThresholdCH4() {
        return this.thresholdCH4;
    }

    public void setThresholdCH4(long j) {
        this.thresholdCH4 = j;
        notifyPropertyChanged(927);
    }

    @Bindable
    public long getThresholdCH3() {
        return this.thresholdCH3;
    }

    public void setThresholdCH3(long j) {
        this.thresholdCH3 = j;
        notifyPropertyChanged(926);
    }

    @Bindable
    public long getThresholdCH2() {
        return this.thresholdCH2;
    }

    public void setThresholdCH2(long j) {
        this.thresholdCH2 = j;
        notifyPropertyChanged(925);
    }

    @Bindable
    public int getDiffSmooth() {
        return this.diffSmooth;
    }

    public void setDiffSmooth(int i) {
        this.diffSmooth = i;
        notifyPropertyChanged(241);
    }

    @Bindable
    public long getIntgBias() {
        return this.intgBias;
    }

    public void setIntgBias(long j) {
        this.intgBias = j;
        notifyPropertyChanged(442);
    }

    @Bindable
    public ServiceEnum.Unit getIntgBiasUnit() {
        return this.intgBiasUnit;
    }

    public void setIntgBiasUnit(ServiceEnum.Unit unit) {
        this.intgBiasUnit = unit;
        notifyPropertyChanged(443);
    }

    @Bindable
    public long getLineA() {
        return this.lineA;
    }

    public void setLineA(long j) {
        this.lineA = j;
        notifyPropertyChanged(501);
    }

    @Bindable
    public long getLineB() {
        return this.lineB;
    }

    public void setLineB(long j) {
        this.lineB = j;
        notifyPropertyChanged(502);
    }

    public long getSrcSa() {
        return this.srcSa;
    }

    public void setSrcSa(long j) {
        this.srcSa = j;
    }

    @Bindable
    public long getLpFreq() {
        return this.lpFreq;
    }

    public void setLpFreq(long j) {
        this.lpFreq = j;
        notifyPropertyChanged(512);
    }

    @Bindable
    public long getHpFreq() {
        return this.hpFreq;
    }

    public void setHpFreq(long j) {
        this.hpFreq = j;
        notifyPropertyChanged(384);
    }

    @Bindable
    public long getBpFreq1() {
        return this.bpFreq1;
    }

    public void setBpFreq1(long j) {
        this.bpFreq1 = j;
        notifyPropertyChanged(122);
    }

    @Bindable
    public long getBpFreq2() {
        return this.bpFreq2;
    }

    public void setBpFreq2(long j) {
        this.bpFreq2 = j;
        notifyPropertyChanged(123);
    }

    @Bindable
    public long getBtFreq1() {
        return this.btFreq1;
    }

    public void setBtFreq1(long j) {
        this.btFreq1 = j;
        notifyPropertyChanged(124);
    }

    @Bindable
    public long getBtFreq2() {
        return this.btFreq2;
    }

    public void setBtFreq2(long j) {
        this.btFreq2 = j;
        notifyPropertyChanged(125);
    }

    public ServiceEnum.Unit getThresholdUnit() {
        return this.thresholdUnit;
    }

    @Bindable
    public long getFftSpan() {
        return this.fftSpan;
    }

    public void setFftSpan(long j) {
        this.fftSpan = j;
        updateWindowTitle();
        notifyPropertyChanged(301);
        syncData(MessageID.MSG_MATH_FFT_H_SPAN, Long.valueOf(j));
    }

    @Bindable
    public long getFftCenter() {
        return this.fftCenter;
    }

    public void setFftCenter(long j) {
        this.fftCenter = j;
        updateWindowTitle();
        notifyPropertyChanged(294);
        syncData(MessageID.MSG_MATH_FFT_H_CENTER, Long.valueOf(j));
    }

    @Bindable
    public long getFftStart() {
        return this.fftStart;
    }

    public void setFftStart(long j) {
        this.fftStart = j;
        updateWindowTitle();
        notifyPropertyChanged(302);
        syncData(MessageID.MSG_MATH_FFT_H_START, Long.valueOf(j));
    }

    @Bindable
    public long getFftEnd() {
        return this.fftEnd;
    }

    public void setFftEnd(long j) {
        this.fftEnd = j;
        updateWindowTitle();
        notifyPropertyChanged(295);
        syncData(MessageID.MSG_MATH_FFT_H_END, Long.valueOf(j));
    }

    @Bindable
    public int getPeakNum() {
        return this.peakNum;
    }

    public void setPeakNum(int i) {
        this.peakNum = i;
        notifyPropertyChanged(612);
    }

    @Bindable
    public ServiceEnum.enPeakOrder getFftPeakOrderIndex() {
        return this.fftPeakOrderIndex;
    }

    public void setFftPeakOrderIndex(ServiceEnum.enPeakOrder enpeakorder) {
        this.fftPeakOrderIndex = enpeakorder;
        notifyPropertyChanged(298);
    }

    @Bindable
    public long getPeakThreshold() {
        return this.peakThreshold;
    }

    public void setPeakThreshold(long j) {
        this.peakThreshold = j;
        updatePeakThresholdStr();
        notifyPropertyChanged(616);
    }

    @Bindable
    public String getPeakThresholdStr() {
        return this.peakThresholdStr;
    }

    public void setPeakThresholdStr(String str) {
        this.peakThresholdStr = str;
        notifyPropertyChanged(617);
    }

    public void updatePeakThresholdStr() {
        String convert;
        double peakThreshold;
        if (getFftUnitIndex() != ServiceEnum.fftSpecUnit.fft_spec_rms) {
            if (Math.abs((getPeakThreshold() * 1.0d) / 1.0E9d) > 1000.0d) {
                convert = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getPeakThreshold(), getUnitIndex());
            } else {
                convert = ViewUtil.subNumber(String.valueOf(peakThreshold), 5) + getUnitIndex().value2;
            }
        } else {
            convert = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getPeakThreshold(), getUnitIndex());
        }
        setPeakThresholdStr(convert);
    }

    @Bindable
    public long getPeakExcursion() {
        return this.peakExcursion;
    }

    public void setPeakExcursion(long j) {
        this.peakExcursion = j;
        updatePeakExcursionStr();
        notifyPropertyChanged(609);
    }

    @Bindable
    public String getPeakExcursionStr() {
        return this.peakExcursionStr;
    }

    public void setPeakExcursionStr(String str) {
        this.peakExcursionStr = str;
        notifyPropertyChanged(610);
    }

    public void updatePeakExcursionStr() {
        String convert;
        double peakExcursion;
        if (getFftUnitIndex() != ServiceEnum.fftSpecUnit.fft_spec_rms) {
            if (Math.abs((getPeakExcursion() * 1.0d) / 1.0E9d) > 1000.0d) {
                convert = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getPeakExcursion(), ServiceEnum.Unit.Unit_db);
            } else {
                convert = ViewUtil.subNumber(String.valueOf(peakExcursion), 5) + ServiceEnum.Unit.Unit_db.value2;
            }
        } else {
            convert = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getPeakExcursion(), getUnitIndex());
        }
        setPeakExcursionStr(convert);
    }

    @Bindable
    public ServiceEnum.fftSpecUnit getFftUnitIndex() {
        return this.fftUnitIndex;
    }

    public void setFftUnitIndex(ServiceEnum.fftSpecUnit fftspecunit) {
        this.fftUnitIndex = fftspecunit;
        notifyPropertyChanged(303);
    }

    public ServiceEnum.Unit getFilterUnit() {
        return this.filterUnit;
    }

    public ServiceEnum.Unit getFftFreqUnit() {
        return this.fftFreqUnit;
    }

    public String getDiffSmoothConvertStr() {
        return UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(this.diffSmooth);
    }

    @Bindable
    public ServiceEnum.FftxType getFftxTypeIndex() {
        return this.fftxTypeIndex;
    }

    public void setFftxTypeIndex(ServiceEnum.FftxType fftxType) {
        this.fftxTypeIndex = fftxType;
        notifyPropertyChanged(309);
    }

    public void setOperatorString(String str) {
        this.operatorString = str;
        notifyPropertyChanged(574);
    }

    @Bindable
    public String getOperatorString() {
        return this.operatorString;
    }

    @Bindable
    public String getScaleString() {
        return this.scaleString;
    }

    public void setScaleString(String str) {
        this.scaleString = str;
        notifyPropertyChanged(777);
    }

    @Bindable
    public String getWindowTitleString() {
        return this.windowTitleString;
    }

    public void setWindowTitleString(String str) {
        this.windowTitleString = str;
        notifyPropertyChanged(1078);
        syncData(MessageID.MSG_WINDOW_TITLE, str);
    }

    @Bindable
    public String getOffsetString() {
        return this.offsetString;
    }

    public void setOffsetString(String str) {
        this.offsetString = str;
        notifyPropertyChanged(566);
    }

    @Bindable
    public boolean isShowPeakSetting() {
        return this.showPeakSetting;
    }

    public void setShowPeakSetting(boolean z) {
        this.showPeakSetting = z;
        notifyPropertyChanged(831);
    }

    @Bindable
    public long getFftZoomStart() {
        return this.fftZoomStart;
    }

    public void setFftZoomStart(long j) {
        this.fftZoomStart = j;
        updateFftZoomFreq();
        notifyPropertyChanged(308);
        syncData(MessageID.MSG_MATH_FFT_START_ZOOM, Long.valueOf(j));
    }

    public long getFftZoomHScale() {
        return this.fftZoomHScale;
    }

    public void setFftZoomHScale(long j) {
        this.fftZoomHScale = j;
        updateFftZoomFreq();
        syncData(MessageID.MSG_MATH_FFT_SCALE_ZOOM, Long.valueOf(j));
    }

    @Bindable
    public long getFftZoomEnd() {
        return this.fftZoomEnd;
    }

    public void setFftZoomEnd(long j) {
        this.fftZoomEnd = j;
        notifyPropertyChanged(306);
    }

    @Bindable
    public long getFftZoomCenter() {
        return this.fftZoomCenter;
    }

    public void setFftZoomCenter(long j) {
        this.fftZoomCenter = j;
        notifyPropertyChanged(305);
    }

    @Bindable
    public long getFftZoomSpan() {
        return this.fftZoomSpan;
    }

    public void setFftZoomSpan(long j) {
        this.fftZoomSpan = j;
        notifyPropertyChanged(307);
    }

    public void updateFftZoomFreq() {
        setFftZoomEnd(getFftZoomStart() + (getFftZoomHScale() * 10));
        setFftZoomCenter(getFftZoomStart() + (getFftZoomHScale() * 5));
        setFftZoomSpan(getFftZoomHScale() * 10);
    }

    private void updateOperatorString() {
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[getOperator().ordinal()]) {
            case 1:
                this.operatorString = getSourceArithAStr() + Marker.ANY_NON_NULL_MARKER + getSourceArithBStr();
                break;
            case 2:
                this.operatorString = getSourceArithAStr() + "-" + getSourceArithBStr();
                break;
            case 3:
                this.operatorString = getSourceArithAStr() + Marker.ANY_MARKER + getSourceArithBStr();
                break;
            case 4:
                this.operatorString = getSourceArithAStr() + "/" + getSourceArithBStr();
                break;
            case 5:
                this.operatorString = getSourceLogicAStr() + "&&" + getSourceLogicBStr();
                break;
            case 6:
                this.operatorString = getSourceLogicAStr() + "||" + getSourceLogicBStr();
                break;
            case 7:
                this.operatorString = getSourceLogicAStr() + "^" + getSourceLogicBStr();
                break;
            case 8:
                this.operatorString = "!" + getSourceLogicAStr();
                break;
            case 9:
                this.operatorString = "FFT(" + getSourceFftStr() + ")";
                break;
            case 10:
                this.operatorString = "Intg(" + getSourceArithAStr() + ")";
                break;
            case 11:
                this.operatorString = "Diff(" + getSourceArithAStr() + ")";
                break;
            case 12:
                this.operatorString = "Sqrt(" + getSourceArithAStr() + ")";
                break;
            case 13:
                this.operatorString = "Lg(" + getSourceArithAStr() + ")";
                break;
            case 14:
                this.operatorString = "Ln(" + getSourceArithAStr() + ")";
                break;
            case 15:
                this.operatorString = "Exp(" + getSourceArithAStr() + ")";
                break;
            case 16:
                this.operatorString = "Abs(" + getSourceArithAStr() + ")";
                break;
            case 17:
                this.operatorString = "LPF(" + getSourceArithAStr() + ")";
                break;
            case 18:
                this.operatorString = "HPF(" + getSourceArithAStr() + ")";
                break;
            case 19:
                this.operatorString = "BPF(" + getSourceArithAStr() + ")";
                break;
            case 20:
                this.operatorString = "BTF(" + getSourceArithAStr() + ")";
                break;
            case 21:
                this.operatorString = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + getSourceArithAStr() + " + B";
                break;
        }
        setOperatorString(this.operatorString);
    }

    public void updateScaleString() {
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[getOperator().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                this.scaleString = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(this.scale) + this.unitIndex.value2 + '/';
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                this.scaleString = ViewUtil.getMappingObject(R.array.msg_math_logic_scale, getLogicSizeIndex().value1).getStr();
                break;
            case 9:
                this.scaleString = getFftScaleStr() + '/';
                break;
        }
        setScaleString(this.scaleString);
    }

    private void updeteOffsetString() {
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[getOperator().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                this.offsetString = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(this.offset) + this.unitIndex.value2;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                this.offsetString = UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(this.logicOffset) + this.unitIndex.value2;
                break;
            case 9:
                this.offsetString = getFftOffsetStr();
                break;
        }
        setOffsetString(this.offsetString);
    }

    public boolean readStatus() {
        setStatus(readBool(MessageID.MSG_MATH_EN));
        return getStatus();
    }

    public void saveStatus(boolean z) {
        if (!API.getInstance().UI_QueryBool(61, MessageID.MSG_BODE_ENABLE)) {
            setStatus(z);
            saveBool(MessageID.MSG_MATH_EN, z);
            return;
        }
        setStatus(false);
        saveBool(MessageID.MSG_MATH_EN, false);
    }

    public ServiceEnum.MathOperator readOperator() {
        setOperator(ServiceEnum.getMathOperatorFromValue1(readInt(MessageID.MSG_MATH_OPERATOR)));
        return this.operator;
    }

    public void saveOperator(ServiceEnum.MathOperator mathOperator) {
        saveInt(MessageID.MSG_MATH_OPERATOR, mathOperator.value1);
        setOperator(mathOperator);
    }

    public ServiceEnum.Unit readUnit() {
        setUnitIndex(ServiceEnum.getUnitFromValue1(readInt(MessageID.MSG_MATH_UNIT)));
        return getUnitIndex();
    }

    public void saveUnit(ServiceEnum.Unit unit) {
        setUnitIndex(unit);
        saveInt(MessageID.MSG_MATH_UNIT, unit.value1);
    }

    public ServiceEnum.Chan readSourceArithA() {
        setSourceArithAIndex(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_MATH_S32ARITHA)));
        return this.sourceArithAIndex;
    }

    public void saveSourceArithA(ServiceEnum.Chan chan) {
        setSourceArithAIndex(chan);
        saveInt(MessageID.MSG_MATH_S32ARITHA, chan.value1);
    }

    public ServiceEnum.Chan readSourceArithB() {
        setSourceArithBIndex(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_MATH_S32ARITHB)));
        return this.sourceArithBIndex;
    }

    public void saveSourceArithB(ServiceEnum.Chan chan) {
        setSourceArithBIndex(chan);
        saveInt(MessageID.MSG_MATH_S32ARITHB, chan.value1);
    }

    public ServiceEnum.Chan readSourceLogicA() {
        setSourceLogicAIndex(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_MATH_S32LOGICA)));
        return this.sourceLogicAIndex;
    }

    public void saveSourceLogicA(ServiceEnum.Chan chan) {
        setSourceLogicAIndex(chan);
        saveInt(MessageID.MSG_MATH_S32LOGICA, chan.value1);
    }

    public ServiceEnum.Chan readSourceLogicB() {
        setSourceLogicBIndex(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_MATH_S32LOGICB)));
        return this.sourceLogicBIndex;
    }

    public void saveSourceLogicB(ServiceEnum.Chan chan) {
        setSourceLogicBIndex(chan);
        saveInt(MessageID.MSG_MATH_S32LOGICB, chan.value1);
    }

    public ServiceEnum.Chan readSourceFft() {
        setSourceFftIndex(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_MATH_FFT_S32SRC)));
        return this.sourceFftIndex;
    }

    public void saveSourceFft(ServiceEnum.Chan chan) {
        setSourceFftIndex(chan);
        saveInt(MessageID.MSG_MATH_FFT_S32SRC, chan.value1);
    }

    public long readScale() {
        setScale(readLong(MessageID.MSG_MATH_ANALOG_S32SCALE));
        return getScale();
    }

    public void saveScale(long j) {
        readAnaScaleAttr();
        if (j < getAnaScaleAttr().getMinLongValue()) {
            j = getAnaScaleAttr().getMinLongValue();
        }
        if (j > getAnaScaleAttr().getMaxLongValue()) {
            j = getAnaScaleAttr().getMaxLongValue();
        }
        setScale(j);
        saveLong(MessageID.MSG_MATH_ANALOG_S32SCALE, j);
    }

    public long readOffset() {
        setOffset(readLong(MessageID.MSG_MATH_VIEW_OFFSET));
        return getOffset();
    }

    public void saveOffset(long j) {
        readAnaOffsetAttr();
        if (j < getAnaOffsetAttr().getMinLongValue()) {
            j = getAnaOffsetAttr().getMinLongValue();
        }
        if (j > getAnaOffsetAttr().getMaxLongValue()) {
            j = getAnaOffsetAttr().getMaxLongValue();
        }
        setOffset(j);
        saveLong(MessageID.MSG_MATH_VIEW_OFFSET, j);
    }

    public long readLogicOffset() {
        setLogicOffset(readLong(MessageID.MSG_MATH_LOGIC_OFFSET));
        return getLogicOffset();
    }

    public void saveLogicOffset(long j) {
        readLogicOffsetAttr();
        if (j < getLogicOffsetAttr().getMinLongValue()) {
            j = getLogicOffsetAttr().getMinLongValue();
        }
        if (j > getLogicOffsetAttr().getMaxLongValue()) {
            j = getLogicOffsetAttr().getMaxLongValue();
        }
        setLogicOffset(j);
        saveLong(MessageID.MSG_MATH_LOGIC_OFFSET, j);
    }

    public ServiceEnum.LaScale readLogicScale() {
        setLogicSizeIndex(ServiceEnum.getLaScaleFromValue1(readInt(MessageID.MSG_MATH_LOGIC_SCALE)));
        return getLogicSizeIndex();
    }

    public void saveLogicScale(ServiceEnum.LaScale laScale) {
        setLogicSizeIndex(laScale);
        saveInt(MessageID.MSG_MATH_LOGIC_SCALE, laScale.value1);
    }

    public long readFftOffset() {
        setFftOffset(readLong(MessageID.MSG_MATH_FFT_OFFSET));
        return getFftOffset();
    }

    public void saveFftOffset(long j) {
        readFftOffsetAttr();
        if (j < getFftOffsetAttr().getMinLongValue()) {
            j = getFftOffsetAttr().getMinLongValue();
        }
        if (j > getFftOffsetAttr().getMaxLongValue()) {
            j = getFftOffsetAttr().getMaxLongValue();
        }
        setFftOffset(j);
        saveLong(MessageID.MSG_MATH_FFT_OFFSET, j);
    }

    public long readFftScale() {
        setFftScale(readLong(MessageID.MSG_MATH_FFT_SCALE));
        return getFftScale();
    }

    public void saveFftScale(long j) {
        readFftScaleAttr();
        if (j < getFftScaleAttr().getMinLongValue()) {
            j = getFftScaleAttr().getMinLongValue();
        }
        if (j > getFftScaleAttr().getMaxLongValue()) {
            j = getFftScaleAttr().getMaxLongValue();
        }
        setFftScale(j);
        saveLong(MessageID.MSG_MATH_FFT_SCALE, j);
    }

    public boolean readInvert() {
        setInvert(readBool(MessageID.MSG_MATH_S32INVERT));
        return getInvert();
    }

    public void saveInvert(boolean z) {
        setInvert(z);
        saveBool(MessageID.MSG_MATH_S32INVERT, z);
    }

    public ServiceEnum.VertExpand readExpand() {
        setExpandIndex(ServiceEnum.getVertExpandFromValue1(readInt(MessageID.MSG_MATH_EXPAND)));
        return getExpandIndex();
    }

    public void saveExpand(ServiceEnum.VertExpand vertExpand) {
        setExpandIndex(vertExpand);
        saveInt(MessageID.MSG_MATH_EXPAND, vertExpand.value1);
    }

    public int readSens() {
        setSens(readInt(MessageID.MSG_MATH_LOGIC_S32SENS) * 100);
        return getSens();
    }

    public void saveSens(int i) {
        setSens(i);
        saveInt(MessageID.MSG_MATH_LOGIC_S32SENS, i / 100);
    }

    public long readIntgBias() {
        setIntgBias(readLong(MessageID.MSG_MATH_INTGOPT_BIAS));
        return getIntgBias();
    }

    public void saveIntgBias(long j) {
        setIntgBias(j);
        saveLong(MessageID.MSG_MATH_INTGOPT_BIAS, j);
    }

    public ServiceEnum.Unit readIntgBiasUnit() {
        setIntgBiasUnit(ServiceEnum.getUnitFromValue1(readInt(MessageID.MSG_MATH_INTGBIAS_UNIT)));
        return getIntgBiasUnit();
    }

    public long readLineA() {
        setLineA(readLong(MessageID.MSG_MATH_LINEOPT_A));
        return getLineA();
    }

    public void saveLineA(long j) {
        setLineA(j);
        saveLong(MessageID.MSG_MATH_LINEOPT_A, j);
    }

    public long readLineB() {
        setLineB(readLong(MessageID.MSG_MATH_LINEOPT_B));
        return getLineB();
    }

    public void saveLineB(long j) {
        setLineB(j);
        saveLong(MessageID.MSG_MATH_LINEOPT_B, j);
    }

    public long readThresholdCH1() {
        setThresholdCH1(readLong(MessageID.MSG_MATH_LOGIC_S32THRE1));
        return getThresholdCH1();
    }

    public void saveThresholdCH1(long j) {
        if (j < getThresholdCH1Attr().getMinLongValue()) {
            j = getThresholdCH1Attr().getMinLongValue();
        }
        if (j > getThresholdCH1Attr().getMaxLongValue()) {
            j = getThresholdCH1Attr().getMaxLongValue();
        }
        setThresholdCH1(j);
        saveLong(MessageID.MSG_MATH_LOGIC_S32THRE1, j);
        syncData(MessageID.MSG_MATH_LOGIC_S32THRE1, Long.valueOf(j));
    }

    public long readThresholdCH2() {
        setThresholdCH2(readLong(MessageID.MSG_MATH_LOGIC_S32THRE2));
        return getThresholdCH2();
    }

    public void saveThresholdCH2(long j) {
        if (j < getThresholdCH2Attr().getMinLongValue()) {
            j = getThresholdCH2Attr().getMinLongValue();
        }
        if (j > getThresholdCH2Attr().getMaxLongValue()) {
            j = getThresholdCH2Attr().getMaxLongValue();
        }
        setThresholdCH2(j);
        saveLong(MessageID.MSG_MATH_LOGIC_S32THRE2, j);
        syncData(MessageID.MSG_MATH_LOGIC_S32THRE2, Long.valueOf(j));
    }

    public long readThresholdCH3() {
        setThresholdCH3(readLong(MessageID.MSG_MATH_LOGIC_S32THRE3));
        return getThresholdCH3();
    }

    public void saveThresholdCH3(long j) {
        if (j < getThresholdCH3Attr().getMinLongValue()) {
            j = getThresholdCH3Attr().getMinLongValue();
        }
        if (j > getThresholdCH3Attr().getMaxLongValue()) {
            j = getThresholdCH3Attr().getMaxLongValue();
        }
        setThresholdCH3(j);
        saveLong(MessageID.MSG_MATH_LOGIC_S32THRE3, j);
        syncData(MessageID.MSG_MATH_LOGIC_S32THRE3, Long.valueOf(j));
    }

    public long readThresholdCH4() {
        setThresholdCH4(readLong(MessageID.MSG_MATH_LOGIC_S32THRE4));
        return getThresholdCH4();
    }

    public void saveThresholdCH4(long j) {
        if (j < getThresholdCH4Attr().getMinLongValue()) {
            j = getThresholdCH4Attr().getMinLongValue();
        }
        if (j > getThresholdCH4Attr().getMaxLongValue()) {
            j = getThresholdCH4Attr().getMaxLongValue();
        }
        setThresholdCH4(j);
        saveLong(MessageID.MSG_MATH_LOGIC_S32THRE4, j);
        syncData(MessageID.MSG_MATH_LOGIC_S32THRE4, Long.valueOf(j));
    }

    public int readSmooth() {
        setDiffSmooth(readInt(MessageID.MSG_MATH_DIFF_SMOOTH));
        return getDiffSmooth();
    }

    public void saveDiffSmooth(int i) {
        setDiffSmooth(i);
        saveInt(MessageID.MSG_MATH_DIFF_SMOOTH, i);
    }

    public void readSrcSa() {
        setSrcSa(readLong(MessageID.MSG_MATH_SRC_SA));
    }

    public long readLpFreq() {
        setLpFreq(readLong(MessageID.MSG_MATH_S32FILTER_LP));
        return getLpFreq();
    }

    public void saveLpFreq(long j) {
        setLpFreq(j);
        saveLong(MessageID.MSG_MATH_S32FILTER_LP, j);
    }

    public long readHpFreq() {
        setHpFreq(readLong(MessageID.MSG_MATH_S32FILTER_HP));
        return getHpFreq();
    }

    public void saveHpFreq(long j) {
        setHpFreq(j);
        saveLong(MessageID.MSG_MATH_S32FILTER_HP, j);
    }

    public long readBpFreq1() {
        setBpFreq1(readLong(MessageID.MSG_MATH_S32FILTER_BP1));
        return getBpFreq1();
    }

    public void saveBpFreq1(long j) {
        setBpFreq1(j);
        saveLong(MessageID.MSG_MATH_S32FILTER_BP1, j);
    }

    public long readBpFreq2() {
        setBpFreq2(readLong(MessageID.MSG_MATH_S32FILTER_BP2));
        return getBpFreq2();
    }

    public void saveBpFreq2(long j) {
        setBpFreq2(j);
        saveLong(MessageID.MSG_MATH_S32FILTER_BP2, j);
    }

    public long readBtFreq1() {
        setBtFreq1(readLong(MessageID.MSG_MATH_S32FILTER_BT1));
        return getBtFreq1();
    }

    public void saveBtFreq1(long j) {
        setBtFreq1(j);
        saveLong(MessageID.MSG_MATH_S32FILTER_BT1, j);
    }

    public long readBtFreq2() {
        setBtFreq2(readLong(MessageID.MSG_MATH_S32FILTER_BT2));
        return getBtFreq2();
    }

    public void saveBtFreq2(long j) {
        setBtFreq2(j);
        saveLong(MessageID.MSG_MATH_S32FILTER_BT2, j);
    }

    public long readFftSpan() {
        setFftSpan(readLong(MessageID.MSG_MATH_FFT_H_SPAN));
        return getFftSpan();
    }

    public void saveFftSpan(long j) {
        readFftSpanAttr();
        if (j < getFftSpanAttr().getMinLongValue()) {
            j = getFftSpanAttr().getMinLongValue();
        }
        if (j > getFftSpanAttr().getMaxLongValue()) {
            j = getFftSpanAttr().getMaxLongValue();
        }
        setFftSpan(j);
        saveLong(MessageID.MSG_MATH_FFT_H_SPAN, j);
    }

    public long readFftCenter() {
        setFftCenter(readLong(MessageID.MSG_MATH_FFT_H_CENTER));
        return getFftCenter();
    }

    public void saveFftCenter(long j) {
        readFftCenterAttr();
        if (j < getFftCenterAttr().getMinLongValue()) {
            j = getFftCenterAttr().getMinLongValue();
        }
        if (j > getFftCenterAttr().getMaxLongValue()) {
            j = getFftCenterAttr().getMaxLongValue();
        }
        setFftCenter(j);
        saveLong(MessageID.MSG_MATH_FFT_H_CENTER, j);
    }

    public long readFftStart() {
        setFftStart(readLong(MessageID.MSG_MATH_FFT_H_START));
        return getFftStart();
    }

    public void saveFftStart(long j) {
        readFftStartAttr();
        if (j < getFftStartAttr().getMinLongValue()) {
            j = getFftStartAttr().getMinLongValue();
        }
        if (j > getFftStartAttr().getMaxLongValue()) {
            j = getFftStartAttr().getMaxLongValue();
        }
        setFftStart(j);
        saveLong(MessageID.MSG_MATH_FFT_H_START, j);
    }

    public long readFftEnd() {
        setFftEnd(readLong(MessageID.MSG_MATH_FFT_H_END));
        return getFftEnd();
    }

    public void saveFftEnd(long j) {
        readFftEndAttr();
        if (j < getFftEndAttr().getMinLongValue()) {
            j = getFftEndAttr().getMinLongValue();
        }
        if (j > getFftEndAttr().getMaxLongValue()) {
            j = getFftEndAttr().getMaxLongValue();
        }
        setFftEnd(j);
        saveLong(MessageID.MSG_MATH_FFT_H_END, j);
    }

    public int readPeakNum() {
        setPeakNum(readInt(MessageID.MSG_MATH_FFT_PEAK_MAXPEAKS));
        return getPeakNum();
    }

    public void savePeakNum(int i) {
        setPeakNum(i);
        saveInt(MessageID.MSG_MATH_FFT_PEAK_MAXPEAKS, i);
    }

    public long readPeakThreshold() {
        setPeakThreshold(readLong(MessageID.MSG_MATH_FFT_PEAK_THRESHOLD));
        return getPeakThreshold();
    }

    public void savePeakThreshold(long j) {
        setPeakThreshold(j);
        saveLong(MessageID.MSG_MATH_FFT_PEAK_THRESHOLD, j);
    }

    public long readPeakExcursion() {
        setPeakExcursion(readLong(MessageID.MSG_MATH_FFT_PEAK_EXCURSION));
        return getPeakExcursion();
    }

    public void savePeakExcursion(long j) {
        setPeakExcursion(j);
        saveLong(MessageID.MSG_MATH_FFT_PEAK_EXCURSION, j);
    }

    public ServiceEnum.FftxType readFftXType() {
        setFftxTypeIndex(ServiceEnum.getFftxTypeFromValue1(readBool(MessageID.MSG_MATH_FFT_X_TYPE) ? 1 : 0));
        return getFftxTypeIndex();
    }

    public void saveFftXType(ServiceEnum.FftxType fftxType) {
        setFftxTypeIndex(fftxType);
        saveBool(MessageID.MSG_MATH_FFT_X_TYPE, fftxType.value1 == 1);
    }

    public ServiceEnum.fftSpecUnit readFftUnit() {
        setFftUnitIndex(ServiceEnum.getfftSpecUnitFromValue1(readInt(MessageID.MSG_MATH_FFT_S32UNIT)));
        return getFftUnitIndex();
    }

    public void saveFftUnit(ServiceEnum.fftSpecUnit fftspecunit) {
        setFftUnitIndex(fftspecunit);
        saveInt(MessageID.MSG_MATH_FFT_S32UNIT, fftspecunit.value1);
    }

    public ServiceEnum.fftWindow readFftWindow() {
        setFftWindowIndex(ServiceEnum.getfftWindowFromValue1(readInt(MessageID.MSG_MATH_FFT_S32WINDOW)));
        return getFftWindowIndex();
    }

    public void saveFftWindow(ServiceEnum.fftWindow fftwindow) {
        setFftWindowIndex(fftwindow);
        saveInt(MessageID.MSG_MATH_FFT_S32WINDOW, fftwindow.value1);
    }

    public boolean readPeakSearch() {
        setPeakSearch(readBool(MessageID.MSG_MATH_FFT_PEAK_ENABLE));
        return isPeakSearch();
    }

    public void savePeakSearch(boolean z) {
        setPeakSearch(z);
        saveBool(MessageID.MSG_MATH_FFT_PEAK_ENABLE, z);
    }

    public ServiceEnum.enPeakOrder readFftPeakOrder() {
        setFftPeakOrderIndex(ServiceEnum.getenPeakOrderFromValue1(readInt(MessageID.MSG_MATH_FFT_PEAK_TABELORDER)));
        return getFftPeakOrderIndex();
    }

    public void saveFftPeakOrder(ServiceEnum.enPeakOrder enpeakorder) {
        setFftPeakOrderIndex(enpeakorder);
        saveInt(MessageID.MSG_MATH_FFT_PEAK_TABELORDER, enpeakorder.value1);
    }

    public boolean readColorGrade() {
        setColorGrade(readBool(MessageID.MSG_MATH_COLOR_ONOFF));
        return isColorGrade();
    }

    public void saveColorGrade(boolean z) {
        setColorGrade(z);
        saveBool(MessageID.MSG_MATH_COLOR_ONOFF, z);
    }

    public String readLableString() {
        setLabelString(readStr(MessageID.MSG_MATH_LABEL_STR));
        return getLabelString();
    }

    public void saveLableString(String str) {
        setLabelString(str);
        saveStr(MessageID.MSG_MATH_LABEL_STR, str);
    }

    public boolean readLable() {
        setLabel(readBool(MessageID.MSG_MATH_SHOW_S32LABEL));
        return isLabel();
    }

    public void saveLabel(boolean z) {
        setLabel(z);
        saveBool(MessageID.MSG_MATH_SHOW_S32LABEL, z);
    }

    public ServiceEnum.EWaveGrids readGrids() {
        setGrids(ServiceEnum.getEWaveGridsFromValue1(readInt(MessageID.MSG_DISPLAY_GRID)));
        return getGrids();
    }

    public void saveGrids(ServiceEnum.EWaveGrids eWaveGrids) {
        setGrids(eWaveGrids);
        saveInt(MessageID.MSG_DISPLAY_GRID, eWaveGrids.value1);
    }

    public void readZoomEn() {
        setZoomEn(readBool(MessageID.MSG_MATH_SPY_ZOOM_EN));
    }

    public void readWaveType() {
        setWaveType(ServiceEnum.getMathWaveTypeFromValue1(readInt(MessageID.MSG_MATH_WAVE_TYPE)));
    }

    public void saveWaveType(ServiceEnum.MathWaveType mathWaveType) {
        setWaveType(mathWaveType);
        saveInt(MessageID.MSG_MATH_WAVE_TYPE, mathWaveType.value1);
    }

    public void readFftZoomStart() {
        setFftZoomStart(readLong(MessageID.MSG_MATH_FFT_START_ZOOM));
    }

    public void readFftZoomHScale() {
        setFftZoomHScale(readLong(MessageID.MSG_MATH_FFT_SCALE_ZOOM));
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setStatus(false);
        setGrids(DEFAULT_GRIDS);
        setWaveType(DEFAULT_WAVETYPE);
        setInvert(false);
        setColorGrade(false);
        setPeakSearch(false);
        setLabel(false);
        setOperator(DEFAULT_OPERATOR);
        setSourceArithAIndex(DEFAULT_SOURCEARITHA);
        setSourceArithBIndex(DEFAULT_SOURCEARITHB);
        setSourceLogicAIndex(DEFAULT_SOURCELOGICA);
        setSourceLogicBIndex(DEFAULT_SOURCELOGICB);
        setSourceFftIndex(DEFAULT_SOURCEFFT);
        setExpandIndex(DEFAULT_EXPAND);
        setLogicSizeIndex(DEFAULT_LOGICSIZE);
        setFftWindowIndex(DEFAULT_FFTWIN);
        setFftPeakOrderIndex(DEFAULT_PEAKORDER);
        setFftUnitIndex(DEFAULT_FFTUNIT);
        setScale(DEFAULT_SCALE);
        setOffset(0L);
        setLogicOffset(0L);
        setFftOffset(0L);
        setFftScale(DEFAULT_FFTSCALE);
        setThresholdCH1(0L);
        setThresholdCH2(0L);
        setThresholdCH3(0L);
        setThresholdCH4(0L);
        setLpFreq(DEFAULT_LP);
        setHpFreq(DEFAULT_HP);
        setBpFreq1(DEFAULT_BP1);
        setBpFreq2(DEFAULT_BP2);
        setBtFreq1(DEFAULT_BT1);
        setBtFreq2(DEFAULT_BT2);
        setDiffSmooth(5);
        setIntgBias(0L);
        setIntgBiasUnit(DEFAULT_BISAUNIT);
        setLineA(1000000L);
        setLineB(0L);
        setFftCenter(DEFAULT_CENTER);
        setFftSpan(DEFAULT_SPAN);
        setFftStart(0L);
        setFftEnd(DEFAULT_END);
        setPeakNum(5);
        setPeakThreshold(DEFAULT_PEAKTHRE);
        setPeakExcursion(DEFAULT_EXCURSION);
        setShowPeakSetting(false);
        setSens(300);
        setUnitIndex(ServiceEnum.Unit.Unit_V);
        if (getServiceId() == 17) {
            setLabelString("Math1");
        } else if (getServiceId() == 18) {
            setLabelString("Math2");
        } else if (getServiceId() == 19) {
            setLabelString("Math3");
        } else if (getServiceId() == 20) {
            setLabelString("Math4");
        }
    }

    public String readWindowTitle() {
        setWindowTitleString(readStr(MessageID.MSG_WINDOW_TITLE));
        return getWindowTitleString();
    }

    public void setChanColor(View view, ServiceEnum.Chan chan) {
        if (chan != null) {
            ((TextView) view).setTextColor(ColorUtil.getColor(view.getContext(), chan));
        }
    }

    public List<MappingObject> getSpinnerList(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        int i3 = i - 17;
        for (MappingObject mappingObject : ViewUtil.getList(i2)) {
            if (mappingObject.getValue() - ServiceEnum.Chan.m1.value1 < i3) {
                arrayList.add(mappingObject);
            }
        }
        return arrayList;
    }

    public void updateWindowTitle() {
        String str = "Math" + ((getServiceId() - 17) + 1);
        String operatorString = getOperatorString();
        readSrcSa();
        String str2 = UnitFormat.newBuilder("0.##", UnitFormat.SI.NONE).convert(getSrcSa()) + ServiceEnum.Unit.Unit_SaS.value2;
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[getOperator().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
                setWindowTitleString(str + "     " + operatorString + "     Sa:" + str2 + "     Scale:" + (UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(getScale()) + getUnitIndex().value2));
                return;
            case 5:
            case 6:
            case 7:
            case 8:
                int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$LaScale[getLogicSizeIndex().ordinal()];
                setWindowTitleString(str + "     " + operatorString + "     Size:" + (i != 1 ? i != 2 ? i != 3 ? "" : "Large" : "Medium" : "Small"));
                return;
            case 9:
                String convert = UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(getFftCenter());
                String convert2 = UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(getFftSpan());
                setWindowTitleString(str + "     " + operatorString + "     Sa:" + str2 + "     Center:" + (ViewUtil.subNumber(convert, 6) + ServiceEnum.Unit.Unit_hz.value2) + "     Span:" + (ViewUtil.subNumber(convert2, 6) + ServiceEnum.Unit.Unit_hz.value2) + "     RBW:" + ViewUtil.subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.NONE).convert(readFloat(MessageID.MSG_MATH_FFT_RBW)), 5));
                return;
            default:
                return;
        }
    }

    /* renamed from: com.rigol.scope.data.MathParam$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$LaScale;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator;

        static {
            int[] iArr = new int[ServiceEnum.LaScale.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$LaScale = iArr;
            try {
                iArr[ServiceEnum.LaScale.Small.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$LaScale[ServiceEnum.LaScale.Medium.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$LaScale[ServiceEnum.LaScale.Large.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[ServiceEnum.MathOperator.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator = iArr2;
            try {
                iArr2[ServiceEnum.MathOperator.operator_add.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_sub.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_mul.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_div.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_and.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_or.ordinal()] = 6;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_xor.ordinal()] = 7;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_not.ordinal()] = 8;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_fft.ordinal()] = 9;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_intg.ordinal()] = 10;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_diff.ordinal()] = 11;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_root.ordinal()] = 12;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_lg.ordinal()] = 13;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_ln.ordinal()] = 14;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_exp.ordinal()] = 15;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_abs.ordinal()] = 16;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_lp.ordinal()] = 17;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_hp.ordinal()] = 18;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_bp.ordinal()] = 19;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_bt.ordinal()] = 20;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_ax_b.ordinal()] = 21;
            } catch (NoSuchFieldError unused24) {
            }
        }
    }

    public void scaleUp() {
        long scale = getScale();
        readAnaScaleAttr();
        if (scale == getAnaScaleAttr().getMaxLongValue()) {
            return;
        }
        saveScale(ScaleNumUtil.getPlusNum(scale, 1.0f));
    }

    public void scaleDown() {
        saveScale(ScaleNumUtil.getMinusNum(getScale(), 1.0f));
    }

    public void offsetUp() {
        long scale = getScale();
        long offset = getOffset();
        long j = (scale * 40) / 1000;
        if (j <= 0) {
            j = 1;
        }
        saveOffset(offset + j);
    }

    public void offsetDown() {
        long scale = getScale();
        long offset = getOffset();
        long j = (scale * 40) / 1000;
        if (j <= 0) {
            j = 1;
        }
        saveOffset(offset - j);
    }

    public void scaleRoll(boolean z) {
        if (z) {
            scaleDown();
        } else {
            scaleUp();
        }
    }

    public void offsetRoll(boolean z) {
        if (z) {
            offsetUp();
        } else {
            offsetDown();
        }
    }

    public void fftCenterRoll(KeyEvent keyEvent, boolean z) {
        saveFftCenter(getLongStep(getFftCenter(), getFftCenterAttr(), z, keyEvent));
    }

    public void fftSpanRoll(KeyEvent keyEvent, boolean z) {
        saveFftSpan(getLongStep(getFftSpan(), getFftSpanAttr(), z, keyEvent));
    }

    public void fftStartRoll(KeyEvent keyEvent, boolean z) {
        saveFftStart(getLongStep(getFftStart(), getFftStartAttr(), z, keyEvent));
    }

    public void fftEndRoll(KeyEvent keyEvent, boolean z) {
        saveFftEnd(getLongStep(getFftEnd(), getFftEndAttr(), z, keyEvent));
    }

    public void fftPeakNumRoll(KeyEvent keyEvent, boolean z) {
        savePeakNum(getIntStep(getPeakNum(), getPeakNumAttr(), z, keyEvent));
    }

    public void fftPeakThresholdRoll(KeyEvent keyEvent, boolean z) {
        savePeakThreshold(getLongStep(getPeakThreshold(), getPeakThresholdAttr(), z, keyEvent));
    }

    public void fftPeakExcursionRoll(KeyEvent keyEvent, boolean z) {
        savePeakExcursion(getLongStep(getPeakExcursion(), getPeakExcursionAttr(), z, keyEvent));
    }

    public void scaleReset() {
        saveScale(getLongDef(getAnaScaleAttr()));
    }

    public void offsetReset() {
        saveOffset(getLongDef(getAnaOffsetAttr()));
    }

    public void fftCenterReset() {
        saveFftCenter(getLongDef(getFftCenterAttr()));
    }

    public void fftSpanReset() {
        saveFftSpan(getLongDef(getFftSpanAttr()));
    }

    public void fftStartReset() {
        saveFftStart(getLongDef(getFftStartAttr()));
    }

    public void fftEndReset() {
        saveFftEnd(getLongDef(getFftEndAttr()));
    }

    public void fftPeakNumReset() {
        savePeakNum(getIntDef(getPeakNumAttr()));
    }

    public void fftPeakThresholdReset() {
        savePeakThreshold(getLongDef(getPeakThresholdAttr()));
    }

    public void fftPeakExcursionReset() {
        savePeakExcursion(getLongDef(getPeakExcursionAttr()));
    }

    public void logicScaleRoll(KeyEvent keyEvent, boolean z) {
        if (z) {
            if (this.logicSizeIndex == ServiceEnum.LaScale.Small) {
                saveLogicScale(ServiceEnum.LaScale.Medium);
            } else if (this.logicSizeIndex == ServiceEnum.LaScale.Medium) {
                saveLogicScale(ServiceEnum.LaScale.Large);
            } else if (this.logicSizeIndex == ServiceEnum.LaScale.Large) {
                saveLogicScale(ServiceEnum.LaScale.Small);
            }
        } else if (this.logicSizeIndex == ServiceEnum.LaScale.Large) {
            saveLogicScale(ServiceEnum.LaScale.Medium);
        } else if (this.logicSizeIndex == ServiceEnum.LaScale.Medium) {
            saveLogicScale(ServiceEnum.LaScale.Small);
        } else if (this.logicSizeIndex == ServiceEnum.LaScale.Small) {
            saveLogicScale(ServiceEnum.LaScale.Large);
        }
    }

    public void logicOffsetRoll(KeyEvent keyEvent, boolean z) {
        if (z) {
            saveLogicOffset(getLogicOffset() + 100000000);
        } else {
            saveLogicOffset(getLogicOffset() - 100000000);
        }
    }

    public void logicSenstRoll(KeyEvent keyEvent, boolean z) {
        saveSens(getIntStep(getSens(), getThresholdSensAttr(), z, keyEvent));
    }

    public void logicOffsetReset() {
        saveLogicOffset(getLongDef(getLogicOffsetAttr()));
    }

    public void logicScaleReset() {
        saveLogicScale(ServiceEnum.LaScale.Small);
    }

    public void logicSensReset() {
        readThresholdSensAttr();
        MessageAttr messageAttr = new MessageAttr();
        messageAttr.setMaxValue(getThresholdSensAttr().getMaxIntValue() * 100);
        messageAttr.setMinValue(getThresholdSensAttr().getMinIntValue() * 100);
        messageAttr.setDefValue(getThresholdSensAttr().getDefIntValue() * 100);
        messageAttr.setStepValue(100L);
        saveSens(getIntDef(messageAttr));
    }

    public String toString() {
        return "MathParam{status=" + this.status + ", title='" + this.title + "', invert=" + this.invert + '}';
    }
}
