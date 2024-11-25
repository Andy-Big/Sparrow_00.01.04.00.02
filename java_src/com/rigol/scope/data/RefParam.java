package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.ScaleNumUtil;
import com.rigol.scope.utilities.UnitFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RefParam extends BaseParam {
    private static final boolean DEFAULT_LABELONOFF = false;
    private static final long DEFAULT_OFFSET = 0;
    private static final boolean DEFAULT_ONOFF = false;
    private static final int DEFAULT_REFCHAN = 0;
    private AorBManager aorBManager;
    private Param param;
    private final List<Param> paramList;
    private int refChan;
    private boolean showLabel;
    private static final ServiceEnum.Chan DEFAULT_SRC = ServiceEnum.Chan.chan1;
    private static final ServiceEnum.Chan DEFAULT_SAVESRC = ServiceEnum.Chan.chan1;
    private static final long DEFAULT_SCALE = (long) (Math.pow(1000.0d, UnitFormat.SI.NONE.scale - UnitFormat.SI.MICRO.scale) * 1.0d);
    private static final ServiceEnum.Unit DEFAULT_UNIT = ServiceEnum.Unit.Unit_V;
    private static final String DEFAULT_UNITSTR = ServiceEnum.Unit.Unit_V.value2;

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public void getRefIsOpen() {
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= (ServiceEnum.Chan.r10.value1 - ServiceEnum.Chan.r1.value1) + 1) {
                break;
            } else if (new Param(i).readOnOff()) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        FunctionManager.getInstance().refSwitch = z;
        MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
    }

    @Bindable
    public Param getParam() {
        return this.param;
    }

    public void setParam(Param param) {
        this.param = param;
        notifyPropertyChanged(594);
    }

    public Param getParam(int i) {
        if (i < 0 || i >= this.paramList.size()) {
            return null;
        }
        return this.paramList.get(i);
    }

    public Param getParamByValue(int i) {
        for (Param param : this.paramList) {
            if (i == param.getRefIndex()) {
                return param;
            }
        }
        return null;
    }

    public RefParam() {
        super(22);
        this.refChan = 0;
        this.showLabel = false;
        this.paramList = new ArrayList();
        this.param = null;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        this.paramList.clear();
        for (int i = 0; i < (ServiceEnum.Chan.r10.value1 - ServiceEnum.Chan.r1.value1) + 1; i++) {
            Param param = new Param(i);
            param.readAll();
            this.paramList.add(param);
        }
        readRefChan();
        readShowLabel();
    }

    @Bindable
    public boolean isShowLabel() {
        return this.showLabel;
    }

    public void setShowLabel(boolean z) {
        this.showLabel = z;
        notifyPropertyChanged(828);
        syncData(MessageID.MSG_REF_LABEL_ONOFF, Boolean.valueOf(z));
    }

    @Bindable
    public int getRefChan() {
        return this.refChan;
    }

    public void setRefChan(int i) {
        this.refChan = i;
        notifyPropertyChanged(714);
        syncData(MessageID.MSG_REF_CHANNEL, Integer.valueOf(i));
        List<Param> list = this.paramList;
        if (list == null || i < 0 || i >= list.size()) {
            return;
        }
        setParam(this.paramList.get(i));
    }

    public int readRefChan() {
        setRefChan(readInt(MessageID.MSG_REF_CHANNEL));
        return getRefChan();
    }

    public void saveRefChan(int i) {
        setRefChan(i);
        saveInt(MessageID.MSG_REF_CHANNEL, i);
    }

    public boolean readShowLabel() {
        setShowLabel(readBool(MessageID.MSG_REF_LABEL_ONOFF));
        return isShowLabel();
    }

    public void saveShowLabel(boolean z) {
        setShowLabel(z);
        saveBool(MessageID.MSG_REF_LABEL_ONOFF, z);
    }

    /* loaded from: classes2.dex */
    public static class Param extends BaseParam {
        private String label;
        private boolean onOff;
        private int refChan;
        private ServiceEnum.RefColor refColor;
        private final int refIndex;
        private ServiceEnum.Chan saveChan;
        private ServiceEnum.Chan srcChan;
        private ServiceEnum.Unit unit;
        private String unitStr;
        private long verOffset;
        private MessageAttr verOffsetAttr;
        private long verScale;
        private MessageAttr verScaleAttr;

        public Param(int i) {
            super(22);
            this.onOff = false;
            this.refChan = -1;
            this.srcChan = RefParam.DEFAULT_SRC;
            this.saveChan = RefParam.DEFAULT_SAVESRC;
            this.verScale = RefParam.DEFAULT_SCALE;
            this.verOffset = 0L;
            this.unitStr = RefParam.DEFAULT_UNITSTR;
            this.unit = RefParam.DEFAULT_UNIT;
            this.label = "";
            this.refColor = ServiceEnum.RefColor.REF_COLOR_GRAY;
            this.verOffsetAttr = new MessageAttr();
            this.verScaleAttr = new MessageAttr();
            this.refIndex = i;
        }

        public int getRefIndex() {
            return this.refIndex;
        }

        @Bindable
        public ServiceEnum.Chan getSrcChan() {
            return this.srcChan;
        }

        public void setSrcChan(ServiceEnum.Chan chan) {
            this.srcChan = chan;
            notifyPropertyChanged(897);
            int i = this.refIndex;
            syncData(MessageID.MSG_REFID_SOURCE, i, Integer.valueOf(i));
        }

        @Bindable
        public long getVerScale() {
            return this.verScale;
        }

        public void setVerScale(long j) {
            this.verScale = j;
            notifyPropertyChanged(1020);
            int i = this.refIndex;
            syncData(MessageID.MSG_REFID_SCALE, i, Integer.valueOf(i));
        }

        @Bindable
        public long getVerOffset() {
            return this.verOffset;
        }

        public void setVerOffset(long j) {
            this.verOffset = j;
            notifyPropertyChanged(1019);
            int i = this.refIndex;
            syncData(MessageID.MSG_REFID_OFFSET, i, Integer.valueOf(i));
        }

        @Bindable
        public String getUnitStr() {
            return this.unitStr;
        }

        public void setUnitStr(String str) {
            this.unitStr = str;
            notifyPropertyChanged(990);
        }

        @Bindable
        public ServiceEnum.Unit getUnit() {
            return this.unit;
        }

        public void setUnit(ServiceEnum.Unit unit) {
            this.unit = unit;
            notifyPropertyChanged(987);
        }

        @Bindable
        public String getLabel() {
            return this.label;
        }

        public void setLabel(String str) {
            this.label = str;
            notifyPropertyChanged(475);
            int i = this.refIndex;
            syncData(MessageID.MSG_REFID_LABEL_EDIT, i, Integer.valueOf(i));
        }

        @Bindable
        public ServiceEnum.RefColor getRefColor() {
            return this.refColor;
        }

        public void setRefColor(ServiceEnum.RefColor refColor) {
            this.refColor = refColor;
            notifyPropertyChanged(716);
            int i = this.refIndex;
            syncData(MessageID.MSG_REFID_COLOR, i, Integer.valueOf(i));
        }

        @Bindable
        public boolean isOnOff() {
            setOnOff(readBool(MessageID.MSG_REFID_ENABLE, this.refIndex));
            return this.onOff;
        }

        public void setOnOff(boolean z) {
            this.onOff = z;
            notifyPropertyChanged(570);
            int i = this.refIndex;
            syncData(MessageID.MSG_REFID_ENABLE, i, Integer.valueOf(i));
        }

        public ServiceEnum.Chan getSaveChan() {
            return this.saveChan;
        }

        public void setSaveChan(ServiceEnum.Chan chan) {
            this.saveChan = chan;
            int i = this.refIndex;
            syncData(MessageID.MSG_REFID_SAVE_SRC, i, Integer.valueOf(i));
        }

        public MessageAttr getVerOffsetAttr() {
            return this.verOffsetAttr;
        }

        public void setVerOffsetAttr(MessageAttr messageAttr) {
            this.verOffsetAttr = messageAttr;
        }

        public MessageAttr getVerScaleAttr() {
            return this.verScaleAttr;
        }

        public void setVerScaleAttr(MessageAttr messageAttr) {
            this.verScaleAttr = messageAttr;
        }

        public ServiceEnum.Chan readSrcChan() {
            setSrcChan(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_REFID_SOURCE, this.refIndex)));
            return getSrcChan();
        }

        public void saveSrcChan(ServiceEnum.Chan chan) {
            setSrcChan(chan);
            saveInt(MessageID.MSG_REF_SOURCE, chan.value1);
        }

        public long readVerScale() {
            setVerScale(readLong(MessageID.MSG_REFID_SCALE, this.refIndex));
            return getVerScale();
        }

        public void saveVerScale(long j) {
            readScaleAttr();
            if (j > getVerScaleAttr().getMaxLongValue()) {
                j = getVerScaleAttr().getMaxLongValue();
            }
            if (j < getVerScaleAttr().getMinLongValue()) {
                j = getVerScaleAttr().getMinLongValue();
            }
            setVerScale(j);
            saveLong(MessageID.MSG_REF_SCALE, j);
        }

        public long readVerOffset() {
            setVerOffset(readLong(MessageID.MSG_REFID_OFFSET, this.refIndex));
            return getVerOffset();
        }

        public void saveVerOffset(long j) {
            readOffsetAttr();
            if (j > getVerOffsetAttr().getMaxLongValue()) {
                j = getVerOffsetAttr().getMaxLongValue();
            }
            if (j < getVerOffsetAttr().getMinLongValue()) {
                j = getVerOffsetAttr().getMinLongValue();
            }
            setVerOffset(j);
            saveLong(MessageID.MSG_REF_OFFSET, j);
        }

        public String readLabel() {
            setLabel(readStr(MessageID.MSG_REFID_LABEL_EDIT, this.refIndex));
            return getLabel();
        }

        public void saveLabel(String str) {
            setLabel(str);
            saveStr(MessageID.MSG_REF_LABEL_EDIT, str);
        }

        public ServiceEnum.RefColor readRefColor() {
            setRefColor(ServiceEnum.getRefColorFromValue1(readInt(MessageID.MSG_REFID_COLOR, this.refIndex)));
            return getRefColor();
        }

        public void saveRefColor(ServiceEnum.RefColor refColor) {
            setRefColor(refColor);
            saveInt(MessageID.MSG_REF_COLOR, refColor.value1);
        }

        public String readUnitStr() {
            setUnitStr(readStr(MessageID.MSG_REF_UNIT_STR, this.refIndex));
            return getUnitStr();
        }

        public ServiceEnum.Unit readUnit() {
            setUnit(ServiceEnum.getUnitFromValue1(readInt(MessageID.MSG_REF_UNIT, this.refIndex)));
            return getUnit();
        }

        public boolean readOnOff() {
            setOnOff(readBool(MessageID.MSG_REFID_ENABLE, this.refIndex));
            return isOnOff();
        }

        public ServiceEnum.Chan readSaveChan() {
            setSaveChan(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_REFID_SAVE_SRC, this.refIndex)));
            return getSaveChan();
        }

        public void scaleDown() {
            saveVerScale(ScaleNumUtil.getMinusNum(getVerScale(), 1.0f));
        }

        public void scaleUp() {
            saveVerScale(ScaleNumUtil.getPlusNum(getVerScale(), 1.0f));
        }

        public void offsetDown() {
            long verScale = getVerScale();
            long verOffset = getVerOffset();
            long j = (verScale * 40) / 1000;
            if (j <= 0) {
                j = 1;
            }
            saveVerOffset(verOffset - j);
        }

        public void offsetUp() {
            long verScale = getVerScale();
            long verOffset = getVerOffset();
            long j = (verScale * 40) / 1000;
            if (j <= 0) {
                j = 1;
            }
            saveVerOffset(verOffset + j);
        }

        public MessageAttr readScaleAttr() {
            readLong(MessageID.MSG_REF_SCALE);
            readAttr(MessageID.MSG_REF_SCALE, this.verScaleAttr);
            return getVerScaleAttr();
        }

        public MessageAttr readOffsetAttr() {
            readLong(MessageID.MSG_REF_OFFSET);
            readAttr(MessageID.MSG_REF_OFFSET, this.verOffsetAttr);
            return getVerOffsetAttr();
        }

        @Override // com.rigol.scope.data.BaseParam
        public void readAll() {
            super.readAll();
            readSrcChan();
            readVerScale();
            readVerOffset();
            readLabel();
            readRefColor();
            readUnitStr();
            readUnit();
            readOnOff();
            readSaveChan();
            readAllAttr();
        }

        public void readAllAttr() {
            readScaleAttr();
            readOffsetAttr();
        }
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        for (int i = 0; i < (ServiceEnum.Chan.r10.value1 - ServiceEnum.Chan.r1.value1) + 1; i++) {
            Param param = getParam(i);
            if (param != null) {
                param.setOnOff(false);
                param.setSaveChan(DEFAULT_SAVESRC);
                param.setSrcChan(DEFAULT_SRC);
                param.setUnit(DEFAULT_UNIT);
                param.setUnitStr(DEFAULT_UNITSTR);
                param.setVerOffset(0L);
                param.setVerScale(DEFAULT_SCALE);
                param.setLabel("REF" + String.valueOf(i + 1));
                param.setRefColor(ServiceEnum.getRefColorFromValue1(4 - (i % 5)));
            }
        }
        setRefChan(0);
        setShowLabel(false);
    }
}
