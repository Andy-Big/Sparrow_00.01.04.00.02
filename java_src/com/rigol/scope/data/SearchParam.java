package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;

/* loaded from: classes2.dex */
public class SearchParam extends BaseParam {
    private AorBManager edgeAorBManager;
    private ServiceEnum.EdgeSlope edgeSlope;
    private ServiceEnum.Chan edgeSrc;
    private boolean enable;
    private MessageAttr lowAttr;
    private boolean markTableEn;
    private MessageAttr maxAttr;
    private int navigation;
    private MessageAttr navigationAttr;
    private ServiceEnum.EMoreThan polaritySlope;
    private AorBManager pulseAorBManager;
    private long pulseLower;
    private long pulseMax;
    private int pulsePolarty;
    private ServiceEnum.Chan pulseSrc;
    private boolean searcceAvailble;
    private boolean tableOnOff;
    private long thre;
    private int threA;
    private MessageAttr threAAttr;
    private MessageAttr threAttr;
    private int threB;
    private MessageAttr threBAttr;
    private ServiceEnum.enumSearchType type;

    public SearchParam() {
        super(25);
        this.enable = false;
        this.tableOnOff = false;
        this.type = ServiceEnum.enumSearchType.SEARCH_TYPE_EDGE;
        this.markTableEn = false;
        this.navigation = 1;
        this.thre = 0L;
        this.threA = 0;
        this.threB = 0;
        this.pulsePolarty = 0;
        this.searcceAvailble = false;
        this.pulseLower = 0L;
        this.pulseMax = 0L;
        this.edgeSrc = ServiceEnum.Chan.chan1;
        this.pulseSrc = ServiceEnum.Chan.chan1;
        this.edgeSlope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.polaritySlope = ServiceEnum.EMoreThan.Trigger_When_Morethan;
        this.navigationAttr = new MessageAttr();
        this.threAttr = new MessageAttr();
        this.threAAttr = new MessageAttr();
        this.threBAttr = new MessageAttr();
        this.lowAttr = new MessageAttr();
        this.maxAttr = new MessageAttr();
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readAllParam();
        readAllAttr();
    }

    public AorBManager getEdgeAorBManager() {
        return this.edgeAorBManager;
    }

    public void setEdgeAorBManager(AorBManager aorBManager) {
        this.edgeAorBManager = aorBManager;
    }

    public AorBManager getPulseAorBManager() {
        return this.pulseAorBManager;
    }

    public void setPulseAorBManager(AorBManager aorBManager) {
        this.pulseAorBManager = aorBManager;
    }

    @Bindable
    public ServiceEnum.EMoreThan getPolaritySlope() {
        return this.polaritySlope;
    }

    public void setPolaritySlope(ServiceEnum.EMoreThan eMoreThan) {
        this.polaritySlope = eMoreThan;
        notifyPropertyChanged(645);
    }

    public void savePolaritySlope(ServiceEnum.EMoreThan eMoreThan) {
        setPolaritySlope(eMoreThan);
        saveInt(MessageID.MSG_SEARCH_PULSE_WHEN, eMoreThan.value1);
    }

    public void readPolaritySlope() {
        ServiceEnum.EMoreThan eMoreThanFromValue1 = ServiceEnum.getEMoreThanFromValue1(readInt(MessageID.MSG_SEARCH_PULSE_WHEN));
        this.polaritySlope = eMoreThanFromValue1;
        setPolaritySlope(eMoreThanFromValue1);
    }

    @Bindable
    public int getPulsePolarty() {
        return this.pulsePolarty;
    }

    public void setPulsePolarty(int i) {
        this.pulsePolarty = i;
        notifyPropertyChanged(681);
    }

    public void savePulsePolarty(int i) {
        this.pulsePolarty = i;
        saveInt(MessageID.MSG_SEARCH_PULSE_POLARITY, i);
        setPulsePolarty(i);
        notifyPropertyChanged(681);
    }

    public void readPulsePolarty() {
        int readInt = readInt(MessageID.MSG_SEARCH_PULSE_POLARITY);
        this.pulsePolarty = readInt;
        setPulsePolarty(readInt);
    }

    @Bindable
    public boolean isEnable() {
        return this.enable;
    }

    @Bindable
    public boolean getTabelOnOff() {
        return this.tableOnOff;
    }

    public void saveTabelOnOff(boolean z) {
        setTabelOnOff(z);
        saveBool(MessageID.MSG_SEARCH_MARK_TABEL_EN, z);
    }

    public void setEnable(boolean z) {
        this.enable = z;
        notifyPropertyChanged(271);
    }

    public void setTabelOnOff(boolean z) {
        this.tableOnOff = z;
        notifyPropertyChanged(271);
    }

    @Bindable
    public ServiceEnum.enumSearchType getType() {
        return this.type;
    }

    public void setType(ServiceEnum.enumSearchType enumsearchtype) {
        this.type = enumsearchtype;
        notifyPropertyChanged(978);
        syncData(MessageID.MSG_SEARCH_EN, null);
    }

    @Bindable
    public boolean isMarkTableEn() {
        return this.markTableEn;
    }

    public void setMarkTableEn(boolean z) {
        this.markTableEn = z;
        notifyPropertyChanged(519);
    }

    @Bindable
    public int getNavigation() {
        return this.navigation;
    }

    public void setNavigation(int i) {
        this.navigation = i;
        notifyPropertyChanged(557);
    }

    @Bindable
    public long getThre() {
        return this.thre;
    }

    public void setThre(long j) {
        this.thre = j;
        notifyPropertyChanged(921);
    }

    @Bindable
    public int getThreA() {
        return this.threA;
    }

    public void setThreA(int i) {
        this.threA = i;
        notifyPropertyChanged(922);
    }

    @Bindable
    public int getThreB() {
        return this.threB;
    }

    public void setThreB(int i) {
        this.threB = i;
        notifyPropertyChanged(923);
    }

    @Bindable
    public ServiceEnum.Chan getEdgeSrc() {
        return this.edgeSrc;
    }

    public void setEdgeSrc(ServiceEnum.Chan chan) {
        this.edgeSrc = chan;
        notifyPropertyChanged(269);
    }

    public void setPulseSrc(ServiceEnum.Chan chan) {
        this.pulseSrc = chan;
        notifyPropertyChanged(682);
    }

    public void readPulseSrc() {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_SEARCH_PULSE_SOURCE));
        this.pulseSrc = chanFromValue1;
        setPulseSrc(chanFromValue1);
    }

    public void setSearcceAvailblec(boolean z) {
        this.searcceAvailble = z;
        notifyPropertyChanged(785);
    }

    @Bindable
    public boolean getSearcceAvailblec() {
        return this.searcceAvailble;
    }

    @Bindable
    public ServiceEnum.Chan getPulseSrc() {
        return this.pulseSrc;
    }

    @Bindable
    public ServiceEnum.EdgeSlope getEdgeSlope() {
        return this.edgeSlope;
    }

    public void setEdgeSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.edgeSlope = edgeSlope;
        notifyPropertyChanged(266);
    }

    @Bindable
    public Long getPulseLower() {
        readpulseLower();
        return Long.valueOf(this.pulseLower);
    }

    public void readpulseLower() {
        this.pulseLower = readLong(MessageID.MSG_SEARCH_PULSE_LOWER);
        notifyPropertyChanged(678);
    }

    @Bindable
    public Long getPulseMax() {
        readPulseMax();
        return Long.valueOf(this.pulseMax);
    }

    public void setPulseLower(Long l) {
        this.pulseLower = l.longValue();
    }

    public void setPulseMax(Long l) {
        this.pulseMax = l.longValue();
    }

    public void savePulseLower(Long l) {
        setPulseLower(l);
        saveLong(MessageID.MSG_SEARCH_PULSE_LOWER, l.longValue());
        notifyPropertyChanged(678);
    }

    public void savePulseMax(Long l) {
        setPulseMax(l);
        notifyPropertyChanged(679);
        saveLong(MessageID.MSG_SEARCH_PULSE_UPPER, l.longValue());
    }

    public void readPulseMax() {
        this.pulseMax = readLong(MessageID.MSG_SEARCH_PULSE_UPPER);
        notifyPropertyChanged(679);
    }

    public void readAllParam() {
        readEnable();
        readType();
        readMarkTableEn();
        readNavigation();
        readPolaritySlope();
        readThre();
        readThreA();
        readThreB();
        readPulsePolarty();
        readpulseLower();
        readEdgeSrc();
        readEdgeSlope();
        readlowAttr();
        readmaxAttr();
        readPulseSrc();
        readPulseMax();
    }

    public void readEnable() {
        setEnable(readBool(MessageID.MSG_SEARCH_EN));
        syncData(MessageID.MSG_SEARCH_EN, Boolean.valueOf(this.enable));
    }

    public void saveEnable(boolean z) {
        setEnable(z);
        syncData(MessageID.MSG_SEARCH_EN, Boolean.valueOf(z));
        saveBool(MessageID.MSG_SEARCH_EN, z);
    }

    public void readType() {
        setType(ServiceEnum.getenumSearchTypeFromValue1(readInt(MessageID.MSG_SEARCH_TYPE)));
    }

    public void saveType(ServiceEnum.enumSearchType enumsearchtype) {
        setType(enumsearchtype);
        if (ServiceEnum.enumSearchType.SEARCH_TYPE_PULSE == enumsearchtype) {
            saveInt(MessageID.MSG_SEARCH_TYPE, enumsearchtype.value1);
            saveInt(MessageID.MSG_SEARCH_TYPE, enumsearchtype.value1);
            return;
        }
        saveInt(MessageID.MSG_SEARCH_TYPE, enumsearchtype.value1);
    }

    public void saveNext(int i) {
        readNavigation();
    }

    public void saveLast(int i) {
        readNavigation();
    }

    public void readMarkTableEn() {
        setMarkTableEn(readBool(MessageID.MSG_SEARCH_MARK_TABEL_EN));
    }

    public void saveMarkTableEn(boolean z) {
        setMarkTableEn(z);
        saveBool(MessageID.MSG_SEARCH_MARK_TABEL_EN, z);
        syncData(MessageID.MSG_SEARCH_MARK_TABEL_EN, Boolean.valueOf(z));
    }

    public int readNavigation() {
        int readInt = readInt(MessageID.MSG_SEARCH_NAVIGATION_EVENT);
        setNavigation(readInt);
        syncData(MessageID.MSG_SEARCH_NAVIGATION_EVENT_DIRECTION, Integer.valueOf(readInt));
        return readInt;
    }

    public void saveNavigation(int i) {
        setNavigation(i);
        saveInt(MessageID.MSG_SEARCH_NAVIGATION_EVENT, i);
    }

    public void savenewNavigation(int i) {
        saveInt(MessageID.MSG_SEARCH_NAVIGATION_EVENT_DIRECTION, i);
        syncData(MessageID.MSG_SEARCH_NAVIGATION_EVENT_DIRECTION, Integer.valueOf(i));
    }

    public void readThre() {
        setThre(readLong(MessageID.MSG_SEARCH_THRE));
    }

    public void saveThre(Long l) {
        setThre(l.longValue());
        saveLong(MessageID.MSG_SEARCH_THRE, l.longValue());
        syncData(MessageID.MSG_SEARCH_THRE, l);
    }

    public void readThreA() {
        setThreA(readInt(MessageID.MSG_SEARCH_THRE_A));
    }

    public void saveThreA(int i) {
        setThreA(i);
        saveInt(MessageID.MSG_SEARCH_THRE_A, i);
    }

    public void readThreB() {
        setThreB(readInt(MessageID.MSG_SEARCH_THRE_B));
    }

    public void saveThreB(int i) {
        setThreB(i);
        saveInt(MessageID.MSG_SEARCH_THRE_B, i);
    }

    public void readEdgeSrc() {
        setEdgeSrc(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_SEARCH_EDGE_SOURCE)));
    }

    public void saveEageSrc(ServiceEnum.Chan chan) {
        setEdgeSrc(chan);
        saveInt(MessageID.MSG_SEARCH_EDGE_SOURCE, chan.value1);
    }

    public void savePulseSrc(ServiceEnum.Chan chan) {
        setPulseSrc(chan);
        saveInt(MessageID.MSG_SEARCH_PULSE_SOURCE, chan.value1);
    }

    public void readEdgeSlope() {
        setEdgeSlope(ServiceEnum.getEdgeSlopeFromValue1(readInt(MessageID.MSG_SEARCH_EDGE_SLOPE)));
    }

    public void saveEdgeSlope(ServiceEnum.EdgeSlope edgeSlope) {
        setEdgeSlope(edgeSlope);
        saveInt(MessageID.MSG_SEARCH_EDGE_SLOPE, edgeSlope.value1);
    }

    public MessageAttr getNavigationAttr() {
        return this.navigationAttr;
    }

    public MessageAttr getreadlowAttr() {
        return this.lowAttr;
    }

    public MessageAttr getreadmaxAttr() {
        return this.maxAttr;
    }

    public void setLowAttr(MessageAttr messageAttr) {
        this.lowAttr = messageAttr;
    }

    public void setMaxAttr(MessageAttr messageAttr) {
        this.maxAttr = messageAttr;
    }

    public void setNavigationAttr(MessageAttr messageAttr) {
        this.navigationAttr = messageAttr;
    }

    public MessageAttr getThreAttr() {
        return this.threAttr;
    }

    public void setThreAttr(MessageAttr messageAttr) {
        this.threAttr = messageAttr;
    }

    public MessageAttr getThreAAttr() {
        return this.threAAttr;
    }

    public void setThreAAttr(MessageAttr messageAttr) {
        this.threAAttr = messageAttr;
    }

    public MessageAttr getThreBAttr() {
        return this.threBAttr;
    }

    public void setThreBAttr(MessageAttr messageAttr) {
        this.threBAttr = messageAttr;
    }

    public void readAllAttr() {
        readNavigationAttr();
        readThreAttr();
        readThreAAttr();
        readThreBAttr();
    }

    public void readNavigationAttr() {
        readAttr(MessageID.MSG_SEARCH_NAVIGATION_EVENT, this.navigationAttr);
    }

    public void readlowAttr() {
        readAttr(MessageID.MSG_SEARCH_PULSE_LOWER, this.lowAttr);
    }

    public void readmaxAttr() {
        readAttr(MessageID.MSG_SEARCH_PULSE_UPPER, this.maxAttr);
    }

    public void readThreAttr() {
        readAttr(MessageID.MSG_SEARCH_THRE, this.threAttr);
    }

    public void readThreAAttr() {
        readAttr(MessageID.MSG_SEARCH_THRE_A, this.threAAttr);
    }

    public void readThreBAttr() {
        readAttr(MessageID.MSG_SEARCH_THRE_B, this.threBAttr);
    }

    public void copyToTrigger() {
        saveBool(MessageID.MSG_SEARCH_CPY_TO_TRIGGER, true);
    }

    public void copyFromTrigger() {
        saveBool(MessageID.MSG_SEARCH_CPY_FROM_TRIGGER, true);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        this.enable = false;
        this.type = ServiceEnum.enumSearchType.SEARCH_TYPE_EDGE;
        MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_EN), false);
    }
}
