package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;

/* loaded from: classes2.dex */
public class DvmResultParam extends ResultParam {
    private static final boolean DEFAULT_BEEPER = false;
    private static final boolean DEFAULT_EN = false;
    private static final long DEFAULT_LIMITLOWER = 0;
    private static final int DEFAULT_LIMITTYPE = 0;
    private AorBManager aorBManager;
    private transient boolean beeper;
    private transient int bwv;
    private transient ServiceEnum.DvmMode dvmMode;
    private transient boolean isEnable;
    private transient long limitLower;
    private transient int limitType;
    private transient long limitUpper;
    private transient MessageAttr lowerAttr;
    private transient MessageAttr upperAttr;
    private transient String value;
    private static final ServiceEnum.Chan DEFAULT_SRC = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.DvmMode DEFAULT_DVMMODE = ServiceEnum.DvmMode.DVM_AC_RMS;
    private static final long DEFAULT_LIMITUPPER = (long) (Math.pow(1000.0d, UnitFormat.SI.NONE.scale - UnitFormat.SI.MICRO.scale) * 1.0d);

    public DvmResultParam() {
        super(30);
        this.isEnable = false;
        this.bwv = 1;
        this.upperAttr = new MessageAttr();
        this.lowerAttr = new MessageAttr();
    }

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    @Bindable
    public ServiceEnum.DvmMode getDvmMode() {
        return this.dvmMode;
    }

    public void setDvmMode(ServiceEnum.DvmMode dvmMode) {
        this.dvmMode = dvmMode;
        setMode(dvmMode.value1);
        notifyPropertyChanged(252);
    }

    public String getValue() {
        return ContextUtil.getResultText(this.value);
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String getBwv() {
        return this.bwv + "MHz";
    }

    public void setBwv(int i) {
        this.bwv = i;
    }

    @Bindable
    public boolean isBeeper() {
        return this.beeper;
    }

    public void setBeeper(boolean z) {
        this.beeper = z;
        notifyPropertyChanged(88);
    }

    @Bindable
    public int getLimitType() {
        return this.limitType;
    }

    public void setLimitType(int i) {
        this.limitType = i;
        notifyPropertyChanged(488);
    }

    @Bindable
    public long getLimitUpper() {
        return this.limitUpper;
    }

    public void setLimitUpper(long j) {
        this.limitUpper = j;
        notifyPropertyChanged(489);
    }

    @Bindable
    public long getLimitLower() {
        return this.limitLower;
    }

    public void setLimitLower(long j) {
        this.limitLower = j;
        notifyPropertyChanged(487);
    }

    public boolean isEnable() {
        return this.isEnable;
    }

    public void setEnable(boolean z) {
        this.isEnable = z;
    }

    public MessageAttr getUpperAttr() {
        return this.upperAttr;
    }

    public void setUpperAttr(MessageAttr messageAttr) {
        this.upperAttr = messageAttr;
    }

    public MessageAttr getLowerAttr() {
        return this.lowerAttr;
    }

    public void setLowerAttr(MessageAttr messageAttr) {
        this.lowerAttr = messageAttr;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readSource();
        readMode();
        readBeeper();
        readLimitType();
        readLimitUpper();
        readLimitLower();
        readEnable();
        readUpperAttr();
        readLowerAttr();
        readDVMBandwidth();
    }

    public boolean readEnable() {
        setEnable(readBool(MessageID.MSG_DVM_ENABLE));
        return this.isEnable;
    }

    public ServiceEnum.Chan readSource() {
        setSourceA(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_DVM_SRC)));
        return getSourceA();
    }

    public int readDVMBandwidth() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(getSourceA().value1, MessageID.MSG_DVM_BW);
        this.bwv = UI_QueryInt32;
        setBwv(UI_QueryInt32);
        return this.bwv;
    }

    public ServiceEnum.DvmMode readMode() {
        setDvmMode(ServiceEnum.getDvmModeFromValue1(readInt(MessageID.MSG_DVM_MODE)));
        return getDvmMode();
    }

    public boolean readBeeper() {
        setBeeper(readBool(MessageID.MSG_DVM_BEEP_ENABLE));
        return isBeeper();
    }

    public int readLimitType() {
        setLimitType(readInt(MessageID.MSG_DVM_LIMIT_TYPE));
        return getLimitType();
    }

    public long readLimitUpper() {
        setLimitUpper(readLong(MessageID.MSG_DVM_LIMIT_UPPER));
        return getLimitUpper();
    }

    public long readLimitLower() {
        setLimitLower(readLong(MessageID.MSG_DVM_LIMIT_LOWER));
        return getLimitLower();
    }

    public void readUpperAttr() {
        readAttr(MessageID.MSG_DVM_LIMIT_UPPER, this.upperAttr);
    }

    public void readLowerAttr() {
        readAttr(MessageID.MSG_DVM_LIMIT_LOWER, this.lowerAttr);
    }

    public void saveEnable(boolean z) {
        setEnable(z);
        saveInt(MessageID.MSG_DVM_ENABLE, z ? 1 : 0);
    }

    public void saveSource(ServiceEnum.Chan chan) {
        if (getSourceA() == chan) {
            return;
        }
        setSourceA(chan);
        saveInt(MessageID.MSG_DVM_SRC, chan.value1);
    }

    public void saveMode(ServiceEnum.DvmMode dvmMode) {
        if (this.dvmMode == dvmMode) {
            return;
        }
        setDvmMode(dvmMode);
        saveInt(MessageID.MSG_DVM_MODE, dvmMode.value1);
    }

    public void saveBeeper(boolean z) {
        if (this.beeper == z) {
            return;
        }
        setBeeper(z);
        saveInt(MessageID.MSG_DVM_BEEP_ENABLE, isBeeper() ? 1 : 0);
    }

    public void saveLimitType(int i) {
        if (this.limitType == i) {
            return;
        }
        setLimitType(i);
        saveInt(MessageID.MSG_DVM_LIMIT_TYPE, i);
    }

    public void saveLimitUpper(long j) {
        if (this.limitUpper == j) {
            return;
        }
        setLimitUpper(j);
        saveLong(MessageID.MSG_DVM_LIMIT_UPPER, j);
    }

    public void saveLimitLower(long j) {
        if (this.limitLower == j) {
            return;
        }
        setLimitLower(j);
        saveLong(MessageID.MSG_DVM_LIMIT_LOWER, j);
    }

    public void setData(String[] strArr) {
        setSourceA(getSource(strArr[1]));
        setValue(ContextUtil.getResultText(strArr[3]));
    }

    public void remove() {
        saveEnable(false);
        syncData(MessageID.MSG_DVM_ENABLE, false);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setSourceA(DEFAULT_SRC);
        setDvmMode(DEFAULT_DVMMODE);
        setBeeper(false);
        setLimitType(0);
        setLimitUpper(DEFAULT_LIMITUPPER);
        setLimitLower(0L);
        setEnable(false);
    }
}
