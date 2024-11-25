package com.rigol.scope.data;

import androidx.collection.SimpleArrayMap;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OptionParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\rJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0006\u0010\u0014\u001a\u00020\u0012R$\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/rigol/scope/data/OptionParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "infoList", "", "Lcom/rigol/scope/data/OptionInfo;", "getInfoList", "()[Lcom/rigol/scope/data/OptionInfo;", "setInfoList", "([Lcom/rigol/scope/data/OptionInfo;)V", "[Lcom/rigol/scope/data/OptionInfo;", "optionList", "Landroidx/collection/SimpleArrayMap;", "Lcom/rigol/scope/cil/ServiceEnum$OptType;", "", "get", "type", "read", "", "readAll", "readInfo", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class OptionParam extends BaseParam {
    private OptionInfo[] infoList;
    private final SimpleArrayMap<ServiceEnum.OptType, Boolean> optionList;

    public OptionParam() {
        super(36);
        this.optionList = new SimpleArrayMap<>();
    }

    public final OptionInfo[] getInfoList() {
        return this.infoList;
    }

    public final void setInfoList(OptionInfo[] optionInfoArr) {
        this.infoList = optionInfoArr;
    }

    public final boolean get(ServiceEnum.OptType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        Boolean bool = this.optionList.get(type);
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        super.readAll();
        readInfo();
        read(ServiceEnum.OptType.OPT_COMP);
        read(ServiceEnum.OptType.OPT_EMBD);
        read(ServiceEnum.OptType.OPT_AUTO);
        read(ServiceEnum.OptType.OPT_FLEX);
        read(ServiceEnum.OptType.OPT_AUDIO);
        read(ServiceEnum.OptType.OPT_AERO);
        read(ServiceEnum.OptType.OPT_EYE);
        read(ServiceEnum.OptType.OPT_JITTER);
        read(ServiceEnum.OptType.OPT_RTSA);
        read(ServiceEnum.OptType.OPT_CM_USB);
        read(ServiceEnum.OptType.OPT_CM_ENET);
        read(ServiceEnum.OptType.OPT_CM_MIPI);
        read(ServiceEnum.OptType.OPT_RLU);
        read(ServiceEnum.OptType.OPT_UPA);
        read(ServiceEnum.OptType.OPT_BW7T10);
        read(ServiceEnum.OptType.OPT_BW7T20);
        read(ServiceEnum.OptType.OPT_BW10T20);
        read(ServiceEnum.OptType.OPT_BW2T4);
        read(ServiceEnum.OptType.OPT_BW2T8);
        read(ServiceEnum.OptType.OPT_BW4T8);
        syncData(MessageID.MSG_LICENSE_CHANGED, true);
    }

    public final void readInfo() {
        try {
            OptionInfo[] optionInfoArr = (OptionInfo[]) GsonUtils.fromJson(readStr(MessageID.MSG_LICENSE_LIST), (Class<Object>) OptionInfo[].class);
            this.infoList = optionInfoArr;
            if (optionInfoArr != null) {
                for (OptionInfo optionInfo : optionInfoArr) {
                    optionInfo.setInfo(ContextUtil.getMessage(Integer.parseInt(optionInfo.getId())));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void read(ServiceEnum.OptType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        long readLong = readLong(MessageID.MSG_LICENSE_VALID, type.value1);
        log(type.name(), Boolean.valueOf(get(type)), Long.valueOf(readLong));
        this.optionList.put(type, Boolean.valueOf(readLong != 0));
    }
}
