package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
/* loaded from: classes2.dex */
public class CounterResultParam extends ResultParam {
    private static final boolean DEFAULT_COUNTER_SWITCH = false;
    private static final boolean DEFAULT_EN = false;
    private static final int DEFAULT_RESOLUTION = 5;
    private static final ServiceEnum.Chan DEFAULT_SRC = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.CounterType DEFAULT_TYPE = ServiceEnum.CounterType.FREQ;
    private AorBManager aorBManager;
    private transient String avgValue;
    private transient boolean counterSwitch;
    private transient ServiceEnum.CounterType counterType;
    private transient boolean isEnable;
    private transient String maxValue;
    private transient String minValue;
    private transient int resolution;
    private final transient MessageAttr resolutionAttr;
    private transient String value;

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public CounterResultParam() {
        super(29);
        this.counterSwitch = false;
        this.counterType = ServiceEnum.CounterType.FREQ;
        this.isEnable = false;
        this.resolutionAttr = new MessageAttr();
        setMode(1);
    }

    @Bindable
    public String getValue() {
        return this.value;
    }

    public void setValue(String str) {
        this.value = str;
        notifyPropertyChanged(1015);
    }

    @Bindable
    public ServiceEnum.CounterType getCounterType() {
        return this.counterType;
    }

    public void setCounterType(ServiceEnum.CounterType counterType) {
        this.counterType = counterType;
        notifyPropertyChanged(192);
    }

    @Bindable
    public boolean isCounterSwitch() {
        return this.counterSwitch;
    }

    public void setCounterSwitch(boolean z) {
        this.counterSwitch = z;
        saveBool(MessageID.MSG_COUNTER_1_STAT, z);
        notifyPropertyChanged(191);
    }

    @Bindable
    public String getMaxValue() {
        return this.maxValue;
    }

    public void setMaxValue(String str) {
        this.maxValue = str;
        notifyPropertyChanged(525);
    }

    @Bindable
    public String getMinValue() {
        return this.minValue;
    }

    public void setMinValue(String str) {
        this.minValue = str;
        notifyPropertyChanged(542);
    }

    @Bindable
    public String getAvgValue() {
        return this.avgValue;
    }

    public void setAvgValue(String str) {
        this.avgValue = str;
        notifyPropertyChanged(66);
    }

    @Bindable
    public int getResolution() {
        return this.resolution;
    }

    public void setResolution(int i) {
        this.resolution = i;
        notifyPropertyChanged(738);
    }

    public MessageAttr getResolutionAttr() {
        return this.resolutionAttr;
    }

    @Bindable
    public boolean isEnable() {
        return this.isEnable;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
        notifyPropertyChanged(271);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readCounterType();
        readResolution();
        readSource();
        readEnable();
        readCounterSwitch();
        readAttr(MessageID.MSG_COUNTER_1_RESOLUTION, this.resolutionAttr);
    }

    public boolean readEnable() {
        setEnable(readBool(MessageID.MSG_COUNTER_1_ENABLE));
        return this.isEnable;
    }

    public boolean readCounterSwitch() {
        setCounterSwitch(readBool(MessageID.MSG_COUNTER_1_STAT));
        return this.counterSwitch;
    }

    public ServiceEnum.CounterType readCounterType() {
        ServiceEnum.CounterType counterTypeFromValue1 = ServiceEnum.getCounterTypeFromValue1(readInt(MessageID.MSG_COUNTER_1_MEAS_TYPE));
        this.counterType = counterTypeFromValue1;
        setCounterType(counterTypeFromValue1);
        return this.counterType;
    }

    public int readResolution() {
        int readInt = readInt(MessageID.MSG_COUNTER_1_RESOLUTION);
        this.resolution = readInt;
        setResolution(readInt);
        return this.resolution;
    }

    public ServiceEnum.Chan readSource() {
        setSourceA(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_COUNTER_1_SRC)));
        return getSourceA();
    }

    public void saveEnable(boolean z) {
        setEnable(z);
        saveInt(MessageID.MSG_COUNTER_1_ENABLE, z ? 1 : 0);
    }

    public void saveCounterType(ServiceEnum.CounterType counterType) {
        setCounterType(counterType);
        saveInt(MessageID.MSG_COUNTER_1_MEAS_TYPE, counterType.value1);
    }

    public void saveSource(ServiceEnum.Chan chan) {
        setSourceA(chan);
        saveInt(MessageID.MSG_COUNTER_1_SRC, chan.value1);
    }

    public void saveResolution(int i) {
        setResolution(i);
        saveInt(MessageID.MSG_COUNTER_1_RESOLUTION, i);
    }

    public void setData(String[] strArr) {
        setSourceA(getSource(strArr[1]));
        setValue(ContextUtil.getResultText(strArr[3]));
        setMaxValue(ContextUtil.getResultText(strArr[4]));
        setMinValue(ContextUtil.getResultText(strArr[5]));
        setAvgValue(ContextUtil.getResultText(strArr[6]));
    }

    public void remove() {
        saveEnable(false);
        syncData(MessageID.MSG_COUNTER_1_ENABLE, false);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setEnable(false);
        setCounterType(DEFAULT_TYPE);
        setResolution(5);
        setSourceA(DEFAULT_SRC);
        setCounterSwitch(false);
    }
}
