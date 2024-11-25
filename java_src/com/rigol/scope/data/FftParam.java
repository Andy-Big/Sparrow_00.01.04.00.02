package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.VerticalViewModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FftParam extends BaseParam {
    private static final boolean DEFAULT_AUTORBW = true;
    private static final long DEFAULT_CENTER = 2500000000000000L;
    private static final boolean DEFAULT_ENABLE = false;
    private static final long DEFAULT_END = 5000000000000000L;
    private static final boolean DEFAULT_PEAKEN = false;
    private static final long DEFAULT_PEAKEXCUR = 0;
    private static final int DEFAULT_PEAKNUM = 5;
    private static final boolean DEFAULT_PEAKTABLEEN = false;
    private static final long DEFAULT_PEAKTHRESHOLD = 0;
    private static final long DEFAULT_REFLEVEL = 0;
    private static final long DEFAULT_SCALE = 10000000000L;
    private static final long DEFAULT_SPAN = 5000000000000000L;
    private static final long DEFAULT_START = 0;
    private static final String DEFAULT_TITLE = "RTSA";
    private static final long GHz = 1000000000000000L;
    private static final double MARKER_POS_BASE = 1.0E-6d;
    private static final long MHz = 1000000000000L;
    private static final long VER_UNIT_BASE = 1000000000;
    private boolean autoRbw;
    private long center;
    private MessageAttr centerAttr;
    private boolean enable;
    private long end;
    private MessageAttr endAttr;
    private MessageAttr excurAttr;
    private MessageAttr freqOffsetAttr;
    private ServiceEnum.EWaveGrids grids;
    private List<Marker> markerList;
    private int markersState;
    private boolean peakEn;
    private long peakExcur;
    private String peakExcurStr;
    private int peakNum;
    private MessageAttr peakNumAttr;
    private ServiceEnum.enPeakOrder peakOrder;
    private boolean peakTableEn;
    private long peakThreshold;
    private MessageAttr peakThresholdAttr;
    private String peakThresholdStr;
    private ServiceEnum.EWavePersis persistTime;
    private ServiceEnum.RtsaRBW rbw;
    private long refLevel;
    private MessageAttr refLevelAttr;
    private String refLevelStr;
    private long scale;
    private MessageAttr scaleAttr;
    private String scaleStr;
    private long span;
    private MessageAttr spanAttr;
    private ServiceEnum.Chan src;
    private long start;
    private MessageAttr startAttr;
    private String title;
    private ServiceEnum.Unit unit;
    private ServiceEnum.fftWindow window;
    private static final ServiceEnum.Chan DEFAULT_CHAN = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.Unit DEFAULT_UNIT = ServiceEnum.Unit.Unit_dBmV;
    private static final ServiceEnum.RtsaRBW DEFAULT_RBW = ServiceEnum.RtsaRBW.RtsaRBW_8k;
    private static final ServiceEnum.fftWindow DEFAULT_WINDOW = ServiceEnum.fftWindow.fft_hanning;
    private static final ServiceEnum.EWavePersis DEFAULT_PERSISTTIME = ServiceEnum.EWavePersis.PERSIS_IS_NONE;
    private static final ServiceEnum.EWaveGrids DEFAULT_GRIDS = ServiceEnum.EWaveGrids.GRID_IS_FULL;
    private static final ServiceEnum.enPeakOrder DEFAULT_PEAKORDER = ServiceEnum.enPeakOrder.fft_peak_AmpOrder;

    public void doAutoTune() {
    }

    public void doFullSpan() {
    }

    public void doLastSpan() {
    }

    public void doPreset() {
    }

    public void findLeftPeak() {
    }

    public void findNextPeak() {
    }

    public void findRightPeak() {
    }

    public void readAllParam() {
    }

    public void readAllPreset() {
    }

    public void readAutoRbw() {
    }

    public void readCenter() {
    }

    public void readCenterAttr() {
    }

    public void readEnable() {
    }

    public void readEnd() {
    }

    public void readEndAttr() {
    }

    public void readExcurAttr() {
    }

    public void readFreqOffsetAttr() {
    }

    public void readGrids() {
    }

    public void readMarkersState() {
    }

    public void readPeakEn() {
    }

    public void readPeakExcur() {
    }

    public void readPeakNum() {
    }

    public void readPeakNumAttr() {
    }

    public void readPeakOrder() {
    }

    public void readPeakTableEn() {
    }

    public void readPeakThreshold() {
    }

    public void readPeakThresholdAttr() {
    }

    public void readPersistTime() {
    }

    public void readRbw() {
    }

    public void readRefLevel() {
    }

    public void readRefLevelAttr() {
    }

    public void readScale() {
    }

    public void readScaleAttr() {
    }

    public void readSpan() {
    }

    public void readSpanAttr() {
    }

    public void readSrc() {
    }

    public void readStart() {
    }

    public void readStartAttr() {
    }

    public void readTitle() {
    }

    public void readUnit() {
    }

    public void readWindow() {
    }

    public void saveAutoRbw(boolean z) {
    }

    public void saveCenter(long j) {
    }

    public void saveEnable(boolean z) {
    }

    public void saveEnd(long j) {
    }

    public void saveGrids(ServiceEnum.EWaveGrids eWaveGrids) {
    }

    public void savePersistTime(ServiceEnum.EWavePersis eWavePersis) {
    }

    public void saveRbw(ServiceEnum.RtsaRBW rtsaRBW) {
    }

    public void saveRefLevel(long j) {
    }

    public void saveScale(long j) {
    }

    public void saveSpan(long j) {
    }

    public void saveSrc(ServiceEnum.Chan chan) {
    }

    public void saveStart(long j) {
    }

    public void saveUnit(ServiceEnum.Unit unit) {
    }

    public void saveWindow(ServiceEnum.fftWindow fftwindow) {
    }

    public FftParam() {
        super(50);
        this.enable = false;
        this.src = DEFAULT_CHAN;
        this.unit = DEFAULT_UNIT;
        this.rbw = DEFAULT_RBW;
        this.autoRbw = true;
        this.start = 0L;
        this.end = 5000000000000000L;
        this.center = DEFAULT_CENTER;
        this.span = 5000000000000000L;
        this.scale = DEFAULT_SCALE;
        this.refLevel = 0L;
        this.window = DEFAULT_WINDOW;
        this.persistTime = DEFAULT_PERSISTTIME;
        this.grids = DEFAULT_GRIDS;
        this.title = DEFAULT_TITLE;
        this.scaleAttr = new MessageAttr();
        this.refLevelAttr = new MessageAttr();
        this.startAttr = new MessageAttr();
        this.endAttr = new MessageAttr();
        this.centerAttr = new MessageAttr();
        this.spanAttr = new MessageAttr();
        this.freqOffsetAttr = new MessageAttr();
        this.markerList = new ArrayList();
        this.markersState = 0;
        this.peakEn = false;
        this.peakNum = 5;
        this.peakThreshold = 0L;
        this.peakExcur = 0L;
        this.peakTableEn = false;
        this.peakOrder = DEFAULT_PEAKORDER;
        this.peakThresholdAttr = new MessageAttr();
        this.excurAttr = new MessageAttr();
        this.peakNumAttr = new MessageAttr();
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readAllParam();
        readAllAttr();
    }

    @Bindable
    public boolean isEnable() {
        return this.enable;
    }

    public void setEnable(boolean z) {
        log("enable", Boolean.valueOf(this.enable), Boolean.valueOf(z));
        this.enable = z;
        notifyPropertyChanged(271);
    }

    @Bindable
    public ServiceEnum.Chan getSrc() {
        return this.src;
    }

    public void setSrc(ServiceEnum.Chan chan) {
        this.src = chan;
        notifyPropertyChanged(896);
    }

    @Bindable
    public ServiceEnum.Unit getUnit() {
        return this.unit;
    }

    public void setUnit(ServiceEnum.Unit unit) {
        this.unit = unit;
        notifyPropertyChanged(987);
        updateRefLevelStr();
        updateThresholdStr();
    }

    @Bindable
    public ServiceEnum.RtsaRBW getRbw() {
        return this.rbw;
    }

    public void setRbw(ServiceEnum.RtsaRBW rtsaRBW) {
        this.rbw = rtsaRBW;
        notifyPropertyChanged(686);
    }

    @Bindable
    public boolean isAutoRbw() {
        return this.autoRbw;
    }

    public void setAutoRbw(boolean z) {
        this.autoRbw = z;
        notifyPropertyChanged(61);
    }

    @Bindable
    public long getStart() {
        return this.start;
    }

    public void setStart(long j) {
        this.start = j;
        notifyPropertyChanged(900);
    }

    @Bindable
    public long getEnd() {
        return this.end;
    }

    public void setEnd(long j) {
        this.end = j;
        notifyPropertyChanged(273);
        setRbw(this.rbw);
    }

    @Bindable
    public long getCenter() {
        return this.center;
    }

    public void setCenter(long j) {
        this.center = j;
        notifyPropertyChanged(150);
    }

    @Bindable
    public long getSpan() {
        return this.span;
    }

    public void setSpan(long j) {
        this.span = j;
        notifyPropertyChanged(870);
    }

    @Bindable
    public long getScale() {
        return this.scale;
    }

    public void setScale(long j) {
        this.scale = j;
        notifyPropertyChanged(774);
        updateScaleStr();
    }

    @Bindable
    public String getScaleStr() {
        return this.scaleStr;
    }

    public void setScaleStr(String str) {
        this.scaleStr = str;
        notifyPropertyChanged(776);
    }

    public void updateScaleStr() {
        double scale;
        String str;
        if (Math.abs((getScale() * 1.0d) / 1.0E9d) > 1000.0d) {
            str = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getScale(), ServiceEnum.Unit.Unit_db);
        } else {
            str = ViewUtil.subNumber(String.valueOf(scale), 5) + ServiceEnum.Unit.Unit_db.value2;
        }
        setScaleStr(str);
    }

    @Bindable
    public long getRefLevel() {
        return this.refLevel;
    }

    public void setRefLevel(long j) {
        this.refLevel = j;
        notifyPropertyChanged(718);
        updateRefLevelStr();
    }

    @Bindable
    public String getRefLevelStr() {
        return this.refLevelStr;
    }

    public void setRefLevelStr(String str) {
        this.refLevelStr = str;
        notifyPropertyChanged(719);
    }

    public void updateRefLevelStr() {
        double refLevel;
        String str;
        if (getUnit() == ServiceEnum.Unit.Unit_dbm || getUnit() == ServiceEnum.Unit.Unit_dBmV || getUnit() == ServiceEnum.Unit.Unit_dBuV) {
            if (Math.abs((getRefLevel() * 1.0d) / 1.0E9d) > 1000.0d) {
                str = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getRefLevel(), getUnit());
            } else {
                str = ViewUtil.subNumber(String.valueOf(refLevel), 5) + getUnit().value2;
            }
        } else {
            str = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getRefLevel(), getUnit());
        }
        setRefLevelStr(str);
    }

    @Bindable
    public ServiceEnum.fftWindow getWindow() {
        return this.window;
    }

    public void setWindow(ServiceEnum.fftWindow fftwindow) {
        this.window = fftwindow;
        notifyPropertyChanged(1075);
    }

    @Bindable
    public ServiceEnum.EWavePersis getPersistTime() {
        return this.persistTime;
    }

    public void setPersistTime(ServiceEnum.EWavePersis eWavePersis) {
        this.persistTime = eWavePersis;
        notifyPropertyChanged(620);
    }

    @Bindable
    public ServiceEnum.EWaveGrids getGrids() {
        return this.grids;
    }

    public void setGrids(ServiceEnum.EWaveGrids eWaveGrids) {
        this.grids = eWaveGrids;
        notifyPropertyChanged(363);
    }

    @Bindable
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
        notifyPropertyChanged(939);
    }

    public MessageAttr getScaleAttr() {
        return this.scaleAttr;
    }

    public void setScaleAttr(MessageAttr messageAttr) {
        this.scaleAttr = messageAttr;
    }

    public MessageAttr getStartAttr() {
        return this.startAttr;
    }

    public void setStartAttr(MessageAttr messageAttr) {
        this.startAttr = messageAttr;
    }

    public MessageAttr getEndAttr() {
        return this.endAttr;
    }

    public void setEndAttr(MessageAttr messageAttr) {
        this.endAttr = messageAttr;
    }

    public MessageAttr getCenterAttr() {
        return this.centerAttr;
    }

    public void setCenterAttr(MessageAttr messageAttr) {
        this.centerAttr = messageAttr;
    }

    public MessageAttr getSpanAttr() {
        return this.spanAttr;
    }

    public void setSpanAttr(MessageAttr messageAttr) {
        this.spanAttr = messageAttr;
    }

    public MessageAttr getRefLevelAttr() {
        return this.refLevelAttr;
    }

    public void setRefLevelAttr(MessageAttr messageAttr) {
        this.refLevelAttr = messageAttr;
    }

    public MessageAttr getFreqOffsetAttr() {
        return this.freqOffsetAttr;
    }

    public void setFreqOffsetAttr(MessageAttr messageAttr) {
        this.freqOffsetAttr = messageAttr;
    }

    public void readAllAttr() {
        readScaleAttr();
        readStartAttr();
        readEndAttr();
        readCenterAttr();
        readSpanAttr();
        readFreqOffsetAttr();
        readRefLevelAttr();
        readPeakThresholdAttr();
        readExcurAttr();
        readPeakNumAttr();
    }

    public List<MappingObject> getRBWList() {
        long j = this.end;
        if (j > 0 && j <= 250000000000000L) {
            return ViewUtil.getList((int) R.array.msg_fft_rbwlist_500m);
        }
        long j2 = this.end;
        if (j2 > 250000000000000L && j2 <= 500000000000000L) {
            return ViewUtil.getList((int) R.array.msg_fft_rbwlist_1g);
        }
        long j3 = this.end;
        if (j3 > 500000000000000L && j3 <= 1000000000000000L) {
            return ViewUtil.getList((int) R.array.msg_fft_rbwlist_2g);
        }
        long j4 = this.end;
        if (j4 > 1000000000000000L && j4 <= 2.5E15d) {
            return ViewUtil.getList((int) R.array.msg_fft_rbwlist_5g);
        }
        long j5 = this.end;
        if (j5 > 2.5E15d && j5 < 5000000000000000L) {
            return ViewUtil.getList((int) R.array.msg_fft_rbwlist_10g);
        }
        return ViewUtil.getList((int) R.array.msg_fft_rbwlist_10g);
    }

    public int getSrcImp() {
        ArrayList<VerticalParam> value;
        VerticalParam verticalParam;
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null && (value = verticalViewModel.getLiveData().getValue()) != null && (verticalParam = value.get(getSrc().value1 - ServiceEnum.Chan.chan1.value1)) != null && verticalParam.getImpedance() == ServiceEnum.Impedance.IMP_1M) {
        }
        return 50;
    }

    public long doDBmtoDBmV(long j) {
        return Math.round((((j * 1.0d) / 1.0E9d) + 30.0d + (Math.log10(getSrcImp()) * 10.0d)) * 1.0E9d);
    }

    public long doDBmtoDBuV(long j) {
        return Math.round((((j * 1.0d) / 1.0E9d) + 90.0d + (Math.log10(getSrcImp()) * 10.0d)) * 1.0E9d);
    }

    public long doDBmtoV(long j) {
        return Math.round((Math.pow(10.0d, ((((j * 1.0d) / 1.0E9d) + 30.0d) + (Math.log10(getSrcImp()) * 10.0d)) / 20.0d) * 1.0E9d) / 1000.0d);
    }

    public long doDBmtoW(long j) {
        return Math.round((Math.pow(10.0d, ((j * 1.0d) / 1.0E9d) / 10.0d) * 1.0E9d) / 1000.0d);
    }

    public long doDbmVtoDBm(long j) {
        return Math.round(((((j * 1.0d) / 1.0E9d) - 30.0d) - (Math.log10(getSrcImp()) * 10.0d)) * 1.0E9d);
    }

    public long doDbuVtoDBm(long j) {
        return Math.round(((((j * 1.0d) / 1.0E9d) - 90.0d) - (Math.log10(getSrcImp()) * 10.0d)) * 1.0E9d);
    }

    public long doVtoDBm(long j) {
        return Math.round((((Math.log10(((j * 1.0d) / 1.0E9d) * 1000.0d) * 20.0d) - 30.0d) - (Math.log10(getSrcImp()) * 10.0d)) * 1.0E9d);
    }

    public long doWtoDBm(long j) {
        return Math.round(Math.log10(((j * 1.0d) / 1.0E9d) * 1000.0d) * 10.0d * 1.0E9d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public class Marker {
        public ServiceEnum.RtsaMarker markerId;
        public long freq = 0;
        public long vlot = 0;
        public double xPosition = 0.0d;
        public double yPosition = 0.0d;
        public boolean checked = false;

        Marker(ServiceEnum.RtsaMarker rtsaMarker) {
            this.markerId = ServiceEnum.RtsaMarker.Rtsa_Marker1;
            this.markerId = rtsaMarker;
        }
    }

    @Bindable
    public int getMarkersState() {
        return this.markersState;
    }

    public void setMarkersState(int i) {
        this.markersState = i;
        notifyPropertyChanged(520);
    }

    public List<Marker> getMarkerList() {
        return this.markerList;
    }

    public Marker findMarkerById(ServiceEnum.RtsaMarker rtsaMarker) {
        if (this.markerList.size() == 0) {
            return null;
        }
        for (Marker marker : this.markerList) {
            if (marker.markerId == rtsaMarker) {
                return marker;
            }
        }
        return null;
    }

    public void addMarker(ServiceEnum.RtsaMarker rtsaMarker) {
        if (findMarkerById(rtsaMarker) != null) {
            return;
        }
        this.markerList.add(new Marker(rtsaMarker));
    }

    public void removeMarker(ServiceEnum.RtsaMarker rtsaMarker) {
        Marker findMarkerById;
        if (this.markerList.size() == 0 || (findMarkerById = findMarkerById(rtsaMarker)) == null) {
            return;
        }
        this.markerList.remove(findMarkerById);
    }

    public void saveMarkerFreq(ServiceEnum.RtsaMarker rtsaMarker, long j) {
        Marker findMarkerById;
        if (this.markerList.size() == 0 || (findMarkerById = findMarkerById(rtsaMarker)) == null) {
            return;
        }
        findMarkerById.freq = j;
    }

    public void saveMarkerChecked(ServiceEnum.RtsaMarker rtsaMarker, boolean z) {
        Marker findMarkerById;
        if (this.markerList.size() == 0 || (findMarkerById = findMarkerById(rtsaMarker)) == null) {
            return;
        }
        findMarkerById.checked = z;
    }

    public void readMarkerParam(ServiceEnum.RtsaMarker rtsaMarker) {
        if (this.markerList.size() != 0 && findMarkerById(rtsaMarker) == null) {
        }
    }

    public double getMarkerXpos(ServiceEnum.RtsaMarker rtsaMarker) {
        Marker findMarkerById = findMarkerById(rtsaMarker);
        if (findMarkerById == null) {
            return 0.0d;
        }
        return findMarkerById.xPosition;
    }

    public double getMarkerYpos(ServiceEnum.RtsaMarker rtsaMarker) {
        Marker findMarkerById = findMarkerById(rtsaMarker);
        if (findMarkerById == null) {
            return 0.0d;
        }
        return findMarkerById.yPosition;
    }

    public boolean getMarkerChecked(ServiceEnum.RtsaMarker rtsaMarker) {
        Marker findMarkerById = findMarkerById(rtsaMarker);
        if (findMarkerById == null) {
            return false;
        }
        return findMarkerById.checked;
    }

    public void readAllMarkerParam() {
        if (this.markerList.size() == 0) {
            return;
        }
        for (Marker marker : this.markerList) {
            readMarkerParam(marker.markerId);
        }
    }

    public void doAddAllMarker() {
        for (int i = 1; i <= 8; i++) {
            addMarker(ServiceEnum.getRtsaMarkerFromValue1(i));
        }
    }

    public void doRemoveAllMarker() {
        for (int i = 1; i <= 8; i++) {
            removeMarker(ServiceEnum.getRtsaMarkerFromValue1(i));
        }
    }

    @Bindable
    public boolean isPeakEn() {
        return this.peakEn;
    }

    public void setPeakEn(boolean z) {
        this.peakEn = z;
        notifyPropertyChanged(606);
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
    public long getPeakThreshold() {
        return this.peakThreshold;
    }

    public void setPeakThreshold(long j) {
        this.peakThreshold = j;
        updateThresholdStr();
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

    public void updateThresholdStr() {
        double peakThreshold;
        String str;
        if (getUnit() == ServiceEnum.Unit.Unit_dbm || getUnit() == ServiceEnum.Unit.Unit_dBmV || getUnit() == ServiceEnum.Unit.Unit_dBuV) {
            if (Math.abs((getPeakThreshold() * 1.0d) / 1.0E9d) > 1000.0d) {
                str = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getPeakThreshold(), getUnit());
            } else {
                str = ViewUtil.subNumber(String.valueOf(peakThreshold), 5) + getUnit().value2;
            }
        } else {
            str = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getPeakThreshold(), getUnit());
        }
        setPeakThresholdStr(str);
    }

    @Bindable
    public long getPeakExcur() {
        return this.peakExcur;
    }

    public void setPeakExcur(long j) {
        this.peakExcur = j;
        updateExcurStr();
        notifyPropertyChanged(607);
    }

    @Bindable
    public String getPeakExcurStr() {
        return this.peakExcurStr;
    }

    public void setPeakExcurStr(String str) {
        this.peakExcurStr = str;
        notifyPropertyChanged(608);
    }

    public void updateExcurStr() {
        double peakExcur;
        String str;
        if (Math.abs((getPeakExcur() * 1.0d) / 1.0E9d) > 1000.0d) {
            str = UnitFormat.newBuilder("0.00", UnitFormat.SI.NANO).convert(getPeakExcur(), ServiceEnum.Unit.Unit_db);
        } else {
            str = ViewUtil.subNumber(String.valueOf(peakExcur), 5) + ServiceEnum.Unit.Unit_db.value2;
        }
        setPeakExcurStr(str);
    }

    @Bindable
    public ServiceEnum.enPeakOrder getPeakOrder() {
        return this.peakOrder;
    }

    public void setPeakOrder(ServiceEnum.enPeakOrder enpeakorder) {
        this.peakOrder = enpeakorder;
        notifyPropertyChanged(613);
    }

    @Bindable
    public boolean isPeakTableEn() {
        return this.peakTableEn;
    }

    public void setPeakTableEn(boolean z) {
        this.peakTableEn = z;
        notifyPropertyChanged(615);
    }

    public MessageAttr getPeakThresholdAttr() {
        return this.peakThresholdAttr;
    }

    public MessageAttr getExcurAttr() {
        return this.excurAttr;
    }

    public MessageAttr getPeakNumAttr() {
        return this.peakNumAttr;
    }

    public void savePeakEn(boolean z) {
        setPeakEn(z);
    }

    public void savePeakNum(int i) {
        setPeakNum(i);
    }

    public void savePeakThreshold(long j) {
        setPeakThreshold(j);
    }

    public void savePeakExcur(long j) {
        setPeakExcur(j);
    }

    public void savePeakTableEn(boolean z) {
        setPeakTableEn(z);
    }

    public void savePeakOrder(ServiceEnum.enPeakOrder enpeakorder) {
        setPeakOrder(enpeakorder);
    }

    public void addPeakMarker() {
        addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker1);
    }

    public void removePeakMarker() {
        removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker1);
    }

    public List<MappingObject> getUnitSpinnerList() {
        ArrayList<VerticalParam> value;
        VerticalParam verticalParam;
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_fft_1m_unit);
        List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_fft_unit);
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        return (verticalViewModel == null || (value = verticalViewModel.getLiveData().getValue()) == null || (verticalParam = value.get(getSrc().value1 - ServiceEnum.Chan.chan1.value1)) == null || verticalParam.getImpedance() != ServiceEnum.Impedance.IMP_1M) ? list2 : list;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
    }
}
