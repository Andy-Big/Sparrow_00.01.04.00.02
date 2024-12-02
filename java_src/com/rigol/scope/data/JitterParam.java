package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.viewmodels.HorizontalViewModel;

/* loaded from: classes2.dex */
public class JitterParam extends BaseParam {
    private static final boolean DEFAULT_BATHTUBCURVE = false;
    private static final int DEFAULT_DAMPFACTOR = 707;
    private static final long DEFAULT_DATARATE;
    private static final boolean DEFAULT_ENABLE = false;
    private static final ServiceEnum.Chan DEFAULT_EXCLOCK;
    private static final int DEFAULT_HIGHTHRES = 90;
    private static final boolean DEFAULT_HISTOGRAM = false;
    private static final int DEFAULT_LOOPBW;
    private static final int DEFAULT_LOWTHRES = 10;
    private static final int DEFAULT_MIDTHRES = 50;
    private static final boolean DEFAULT_PERSISTACE = false;
    private static final int DEFAULT_PLLORDER = 0;
    private static final int DEFAULT_RECOVERYTYPE = 0;
    private static final boolean DEFAULT_RESULT = false;
    private static final boolean DEFAULT_SMOOTH = false;
    private static final boolean DEFAULT_SPECTRUM = false;
    private static final boolean DEFAULT_TRACK = true;
    private static final int DEFAULT_TYPE = 0;
    private boolean bathtubCurve;
    private int dampFactor;
    private long dataRate;
    private final MessageAttr dataRateThresAttr;
    private boolean enabled;
    private ServiceEnum.Chan externalClock;
    private int highThres;
    private MessageAttr highThresAttr;
    private boolean histogram;
    private long loopBw;
    private final MessageAttr loopBwThresAttr;
    private int lowThres;
    private MessageAttr lowThresAttr;
    private int midThres;
    private MessageAttr midThresAttr;
    private boolean persistance;
    private int pllOrder;
    private int recoveryType;
    private boolean result;
    private boolean smooth;
    private ServiceEnum.Chan source;
    private boolean spectrum;
    private int tieSlope;
    private boolean track;
    private int type;
    private static final ServiceEnum.Chan DEFAULT_SOURCE = ServiceEnum.Chan.chan1;
    private static final int DEFAULT_TIE_SLOPE = ServiceEnum.ClockSlope.CLOCK_BOTH.value1;

    public JitterParam() {
        super(52);
        this.enabled = false;
        this.source = DEFAULT_SOURCE;
        this.highThres = 90;
        this.highThresAttr = new MessageAttr();
        this.midThres = 50;
        this.midThresAttr = new MessageAttr();
        this.lowThres = 50;
        this.lowThresAttr = new MessageAttr();
        this.recoveryType = 0;
        this.tieSlope = DEFAULT_TIE_SLOPE;
        this.type = 0;
        this.dataRate = DEFAULT_DATARATE;
        this.dataRateThresAttr = new MessageAttr();
        this.pllOrder = 0;
        this.dampFactor = 707;
        this.loopBw = DEFAULT_LOOPBW;
        this.loopBwThresAttr = new MessageAttr();
        this.externalClock = DEFAULT_EXCLOCK;
        this.result = false;
        this.persistance = false;
        this.track = true;
        this.spectrum = false;
        this.histogram = false;
        this.bathtubCurve = false;
        this.smooth = false;
    }

    static {
        long pow = (long) (Math.pow(1000.0d, UnitFormat.SI.NONE.scale - UnitFormat.SI.MICRO.scale) * 50.0d);
        DEFAULT_DATARATE = pow;
        DEFAULT_LOOPBW = (int) (pow / 1667.0d);
        DEFAULT_EXCLOCK = ServiceEnum.Chan.chan3;
    }

    @Bindable
    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        HorizontalParam value;
        this.enabled = z;
        notifyPropertyChanged(272);
        syncData(MessageID.MSG_JITTER_EN, Boolean.valueOf(z));
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel == null || (value = horizontalViewModel.getLiveData().getValue()) == null) {
            return;
        }
        value.updateDepthEn();
    }

    @Bindable
    public ServiceEnum.Chan getSource() {
        return this.source;
    }

    public void setSource(ServiceEnum.Chan chan) {
        this.source = chan;
        notifyPropertyChanged(858);
        syncData(MessageID.MSG_JITTER_SOURCE, chan);
    }

    @Bindable
    public int getHighThres() {
        return this.highThres;
    }

    public void setHighThres(int i) {
        this.highThres = i;
        notifyPropertyChanged(373);
    }

    @Bindable
    public int getMidThres() {
        return this.midThres;
    }

    public void setMidThres(int i) {
        this.midThres = i;
        notifyPropertyChanged(536);
    }

    @Bindable
    public int getLowThres() {
        return this.lowThres;
    }

    public void setLowThres(int i) {
        this.lowThres = i;
        notifyPropertyChanged(510);
    }

    @Bindable
    public int getRecoveryType() {
        return this.recoveryType;
    }

    public void setRecoveryType(int i) {
        this.recoveryType = i;
        notifyPropertyChanged(710);
    }

    @Bindable
    public int getTieSlope() {
        return this.tieSlope;
    }

    public void setTieSlope(int i) {
        this.tieSlope = i;
        notifyPropertyChanged(933);
    }

    @Bindable
    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
        notifyPropertyChanged(978);
    }

    @Bindable
    public long getDataRate() {
        return this.dataRate;
    }

    public void setDataRate(long j) {
        this.dataRate = j;
        notifyPropertyChanged(221);
    }

    @Bindable
    public int getPllOrder() {
        return this.pllOrder;
    }

    public void setPllOrder(int i) {
        log("pllOrder", Integer.valueOf(this.pllOrder), Integer.valueOf(i));
        this.pllOrder = i;
        notifyPropertyChanged(641);
    }

    @Bindable
    public long getLoopBw() {
        return this.loopBw;
    }

    public void setLoopBw(long j) {
        this.loopBw = j;
        notifyPropertyChanged(509);
    }

    @Bindable
    public int getDampFactor() {
        return this.dampFactor;
    }

    public void setDampFactor(int i) {
        this.dampFactor = i;
        notifyPropertyChanged(214);
    }

    @Bindable
    public ServiceEnum.Chan getExternalClock() {
        return this.externalClock;
    }

    public void setExternalClock(ServiceEnum.Chan chan) {
        this.externalClock = chan;
        notifyPropertyChanged(292);
    }

    @Bindable
    public boolean isResult() {
        return this.result;
    }

    public void setResult(boolean z) {
        this.result = z;
        notifyPropertyChanged(739);
    }

    @Bindable
    public boolean isPersistance() {
        return this.persistance;
    }

    public void setPersistance(boolean z) {
        this.persistance = z;
        notifyPropertyChanged(621);
    }

    @Bindable
    public boolean isTrack() {
        return this.track;
    }

    public void setTrack(boolean z) {
        log("track", Boolean.valueOf(this.track), Boolean.valueOf(z));
        this.track = z;
        updateCheckState();
        notifyPropertyChanged(943);
        if (isEnabled()) {
            syncData(MessageID.MSG_JITTER_TRACK, Boolean.valueOf(z));
        }
    }

    @Bindable
    public boolean isSpectrum() {
        return this.spectrum;
    }

    public void setSpectrum(boolean z) {
        log("spectrum", Boolean.valueOf(this.spectrum), Boolean.valueOf(z));
        this.spectrum = z;
        updateCheckState();
        notifyPropertyChanged(871);
        if (isEnabled()) {
            syncData(MessageID.MSG_JITTER_SPEC, Boolean.valueOf(z));
        }
    }

    @Bindable
    public boolean isHistogram() {
        return this.histogram;
    }

    public void setHistogram(boolean z) {
        log("histogram", Boolean.valueOf(this.histogram), Boolean.valueOf(z));
        this.histogram = z;
        updateCheckState();
        notifyPropertyChanged(375);
        if (isEnabled()) {
            syncData(MessageID.MSG_JITTER_HISTO, Boolean.valueOf(z));
        }
    }

    @Bindable
    public boolean isBathtubCurve() {
        return this.bathtubCurve;
    }

    public void setBathtubCurve(boolean z) {
        this.bathtubCurve = z;
        updateCheckState();
        notifyPropertyChanged(87);
        if (isEnabled()) {
            syncData(MessageID.MSG_JITTER_CURVE, Boolean.valueOf(z));
        }
    }

    @Bindable
    public boolean isSmooth() {
        return this.smooth;
    }

    public void setSmooth(boolean z) {
        this.smooth = z;
        notifyPropertyChanged(856);
    }

    public MessageAttr getHighThresAttr() {
        return this.highThresAttr;
    }

    public void setHighThresAttr(MessageAttr messageAttr) {
        this.highThresAttr = messageAttr;
    }

    public MessageAttr getMidThresAttr() {
        return this.midThresAttr;
    }

    public void setMidThresAttr(MessageAttr messageAttr) {
        this.midThresAttr = messageAttr;
    }

    public MessageAttr getLowThresAttr() {
        return this.lowThresAttr;
    }

    public void setLowThresAttr(MessageAttr messageAttr) {
        this.lowThresAttr = messageAttr;
    }

    public MessageAttr getLoopBwThresAttr() {
        return this.loopBwThresAttr;
    }

    public MessageAttr getDataRateThresAttr() {
        return this.dataRateThresAttr;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readEnable();
        readSource();
        readHighThres();
        readMidThres();
        readLowThres();
        readRecoveryType();
        readTieSlope();
        readType();
        readPllOrder();
        readDataRate();
        readDampFactor();
        readLoopBw();
        readExternalClock();
        readResult();
        readPersistance();
        readSmooth();
        readHighThresAttr();
        readMidThresAttr();
        readLowThresAttr();
        readLoopBwThresAttr();
        readDataRateThresAttr();
    }

    public boolean readEnable() {
        setEnabled(readBool(MessageID.MSG_JITTER_EN));
        return isEnabled();
    }

    public void saveEnable(boolean z) {
        setEnabled(z);
        saveBool(MessageID.MSG_JITTER_EN, z);
    }

    public ServiceEnum.Chan readSource() {
        setSource(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_JITTER_SOURCE)));
        return getSource();
    }

    public void saveSource(ServiceEnum.Chan chan) {
        setSource(chan);
        saveInt(MessageID.MSG_JITTER_SOURCE, chan.value1);
    }

    public int readHighThres() {
        setHighThres(readInt(MessageID.MSG_JITTER_HIGHTHRE_PER));
        return getHighThres();
    }

    public void saveHighThres(int i) {
        setHighThres(i);
        saveInt(MessageID.MSG_JITTER_HIGHTHRE_PER, i);
    }

    public int readMidThres() {
        setMidThres(readInt(MessageID.MSG_JITTER_MIDTHRE_PER));
        return getMidThres();
    }

    public void saveMidThres(int i) {
        setMidThres(i);
        saveInt(MessageID.MSG_JITTER_MIDTHRE_PER, i);
    }

    public int readLowThres() {
        setLowThres(readInt(MessageID.MSG_JITTER_LOWTHRE_PER));
        return getLowThres();
    }

    public void saveLowThres(int i) {
        setLowThres(i);
        saveInt(MessageID.MSG_JITTER_LOWTHRE_PER, i);
    }

    public int readRecoveryType() {
        setRecoveryType(readInt(MessageID.MSG_JITTER_CR_SELMETHOD));
        return getRecoveryType();
    }

    public void saveRecoveryType(int i) {
        setRecoveryType(i);
        saveInt(MessageID.MSG_JITTER_CR_SELMETHOD, i);
    }

    public int readTieSlope() {
        setTieSlope(readInt(MessageID.MSG_JITTER_TIE_SLOPE));
        return getTieSlope();
    }

    public void saveTieSlope(int i) {
        setTieSlope(i);
        saveInt(MessageID.MSG_JITTER_TIE_SLOPE, i);
    }

    public int readType() {
        setType(readInt(MessageID.MSG_JITTER_CR_FREQTYPE));
        return getType();
    }

    public void saveType(int i) {
        setType(i);
        saveInt(MessageID.MSG_JITTER_CR_FREQTYPE, i);
    }

    public long readDataRate() {
        setDataRate(readLong(MessageID.MSG_JITTER_CR_DATEFREQ));
        return getDataRate();
    }

    public void saveDataRate(long j) {
        setDataRate(j);
        saveLong(MessageID.MSG_JITTER_CR_DATEFREQ, j);
    }

    public int readPllOrder() {
        setPllOrder(readInt(MessageID.MSG_JITTER_CR_PLLORDER));
        return getPllOrder();
    }

    public void savePllOrder(int i) {
        setPllOrder(i);
        saveInt(MessageID.MSG_JITTER_CR_PLLORDER, i);
    }

    public int readDampFactor() {
        setDampFactor(readInt(MessageID.MSG_JITTER_CR_DAMPFACTOR));
        return getDampFactor();
    }

    public void saveDampFactor(int i) {
        setDampFactor(i);
        saveInt(MessageID.MSG_JITTER_CR_DAMPFACTOR, i);
    }

    public long readLoopBw() {
        setLoopBw(readInt(MessageID.MSG_JITTER_CR_PLLWIDTH));
        return getLoopBw();
    }

    public void saveLoopBw(long j) {
        setLoopBw(j);
        saveLong(MessageID.MSG_JITTER_CR_PLLWIDTH, j);
    }

    public ServiceEnum.Chan readExternalClock() {
        setExternalClock(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_JITTER_EXTERNAL_CLOCK_SRC)));
        return getExternalClock();
    }

    public void saveExternalClock(ServiceEnum.Chan chan) {
        setExternalClock(chan);
        saveInt(MessageID.MSG_JITTER_EXTERNAL_CLOCK_SRC, chan.value1);
    }

    public boolean readResult() {
        setResult(readBool(MessageID.MSG_JITTER_MEAS_EN));
        return isResult();
    }

    public void saveResult(boolean z) {
        setResult(z);
        saveBool(MessageID.MSG_JITTER_MEAS_EN, z);
    }

    public boolean readPersistance() {
        setPersistance(readBool(MessageID.MSG_JITTER_OVERLAP_DISPLAY));
        return isPersistance();
    }

    public void savePersistance(boolean z) {
        setPersistance(z);
        saveBool(MessageID.MSG_JITTER_OVERLAP_DISPLAY, z);
    }

    public boolean readTrack() {
        setTrack(readBool(MessageID.MSG_JITTER_TRACK));
        return isTrack();
    }

    public void saveTrack(boolean z) {
        setTrack(z);
        saveBool(MessageID.MSG_JITTER_TRACK, z);
    }

    public boolean readSpectrum() {
        setSpectrum(readBool(MessageID.MSG_JITTER_SPEC));
        return isSpectrum();
    }

    public void saveSpectrum(boolean z) {
        setSpectrum(z);
        saveBool(MessageID.MSG_JITTER_SPEC, z);
    }

    public boolean readHistogram() {
        setHistogram(readBool(MessageID.MSG_JITTER_HISTO));
        return isHistogram();
    }

    public void saveHistogram(boolean z) {
        setHistogram(z);
        saveBool(MessageID.MSG_JITTER_HISTO, z);
    }

    public boolean readBathtubCurve() {
        setBathtubCurve(readBool(MessageID.MSG_JITTER_CURVE));
        return isBathtubCurve();
    }

    public void saveBathtubCurve(boolean z) {
        setBathtubCurve(z);
        saveBool(MessageID.MSG_JITTER_CURVE, z);
    }

    public boolean readSmooth() {
        setSmooth(readBool(MessageID.MSG_JITTER_SMOOTH));
        return isSmooth();
    }

    public void saveSmooth(boolean z) {
        setSmooth(z);
        saveBool(MessageID.MSG_JITTER_SMOOTH, z);
    }

    public void readHighThresAttr() {
        readAttr(MessageID.MSG_JITTER_HIGHTHRE_PER, this.highThresAttr);
    }

    public void readMidThresAttr() {
        readAttr(MessageID.MSG_JITTER_MIDTHRE_PER, this.midThresAttr);
    }

    public void readLowThresAttr() {
        readAttr(MessageID.MSG_JITTER_LOWTHRE_PER, this.lowThresAttr);
    }

    public void readLoopBwThresAttr() {
        readAttr(MessageID.MSG_JITTER_CR_PLLWIDTH, this.loopBwThresAttr);
    }

    public void readDataRateThresAttr() {
        readAttr(MessageID.MSG_JITTER_CR_DATEFREQ, this.dataRateThresAttr);
    }

    public String getHighThresStr() {
        return UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(this.highThres, ServiceEnum.Unit.Unit_percent);
    }

    public String getMidThresStr() {
        return UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(this.midThres, ServiceEnum.Unit.Unit_percent);
    }

    public String getLowThresStr() {
        return UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(this.lowThres, ServiceEnum.Unit.Unit_percent);
    }

    public String getDataRateStr() {
        return UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(this.dataRate, ServiceEnum.Unit.Unit_bps);
    }

    public String getLoopBwStr() {
        return UnitFormat.newBuilder(UnitFormat.SI.NONE).convert(this.loopBw, ServiceEnum.Unit.Unit_hz);
    }

    public String getDampFactorStr() {
        return UnitFormat.newBuilder(UnitFormat.SI.MILLI).convert(this.dampFactor, ServiceEnum.Unit.Unit_U);
    }

    public void updateCheckState() {
        if (isTrack() || isSpectrum() || isHistogram() || isBathtubCurve()) {
            return;
        }
        if (isEnabled()) {
            saveEnable(false);
        }
        saveTrack(true);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setEnabled(false);
        setSource(DEFAULT_SOURCE);
        setHighThres(90);
        setMidThres(50);
        setLowThres(10);
        setRecoveryType(0);
        setTieSlope(DEFAULT_TIE_SLOPE);
        setType(0);
        setDataRate(DEFAULT_DATARATE);
        setPllOrder(0);
        setDampFactor(707);
        setLoopBw(DEFAULT_LOOPBW);
        setExternalClock(DEFAULT_EXCLOCK);
        setResult(false);
        setPersistance(false);
        setTrack(true);
        setSpectrum(false);
        setHistogram(false);
        setBathtubCurve(false);
        setSmooth(false);
    }
}
