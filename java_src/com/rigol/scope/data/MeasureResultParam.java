package com.rigol.scope.data;

import com.rigol.scope.cil.MessageID;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import java.util.List;
/* loaded from: classes2.dex */
public class MeasureResultParam extends ResultParam {
    private transient String avg;
    private transient String cnt;
    private transient String cur;
    private transient String dev;
    private transient String max;
    private transient String min;

    public MeasureResultParam() {
        super(28);
    }

    public String getCur() {
        return this.cur;
    }

    public void setCur(String str) {
        this.cur = str;
    }

    public void setIndicator(int i) {
        saveInt(MessageID.MSG_MEAS_ITEM_ABXY, i);
    }

    public String readIndicator() {
        return readStr(MessageID.MSG_MEAS_ITEM_ABXY);
    }

    public List<ThreeTuple<String, String, Float>> getData() {
        if (getItemData().isEmpty()) {
            getItemData().add(new ThreeTuple<>("Cur:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Avg:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Max:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Min:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Dev:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Cnt:", "*****", Float.valueOf(0.33f)));
        }
        return getItemData();
    }

    public void setData(String[] strArr) {
        getItemData().clear();
        this.cur = ContextUtil.getResultText(strArr[3]);
        getItemData().add(new ThreeTuple<>("Cur:", "" + this.cur, Float.valueOf(0.5f)));
        Float valueOf = Float.valueOf(0.33f);
        getItemData().add(new ThreeTuple<>("Avg:", "" + strArr[4], valueOf));
        getItemData().add(new ThreeTuple<>("Max:", strArr[5], valueOf));
        getItemData().add(new ThreeTuple<>("Min:", strArr[6], valueOf));
        getItemData().add(new ThreeTuple<>("Dev:", strArr[7], valueOf));
        getItemData().add(new ThreeTuple<>("Cnt:", strArr[8], valueOf));
    }

    public void remove() {
        saveInt(MessageID.MSG_APP_MEAS_CLEAR_ONE, ViewUtil.getMeasureItem(getMeasType().value1, getSourceA().value1, getSourceB().value1));
    }
}
