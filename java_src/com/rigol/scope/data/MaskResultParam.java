package com.rigol.scope.data;

import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MaskResultParam extends ResultParam {
    private final transient DecimalFormat decimalFormat;
    private transient String fail;
    private transient String pass;
    private transient String total;

    public MaskResultParam() {
        super(46);
        DecimalFormat decimalFormat = new DecimalFormat("0.##E0");
        this.decimalFormat = decimalFormat;
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
    }

    public String getPass() {
        return this.pass;
    }

    public void setPass(String str) {
        this.pass = ViewUtil.convert(str, 5, "wfm", this.decimalFormat);
    }

    public String getFail() {
        return this.fail;
    }

    public void setFail(String str) {
        this.fail = ViewUtil.convert(str, 5, "wfm", this.decimalFormat);
    }

    public String getTotal() {
        return this.total;
    }

    public void setTotal(String str) {
        this.total = ViewUtil.convert(str, 5, "wfm", this.decimalFormat);
    }

    public void setData(String[] strArr) {
        getItemData().clear();
        setSourceA(getSource(strArr[1]));
        setMeasType(ServiceEnum.MeasType.MASK_RESULT);
        setFail(ContextUtil.getResultText(strArr[3]));
        ArrayList<ThreeTuple<String, String, Float>> itemData = getItemData();
        String fail = getFail();
        Float valueOf = Float.valueOf(0.33f);
        itemData.add(new ThreeTuple<>("Fail:", fail, valueOf));
        setPass(ContextUtil.getResultText(strArr[4]));
        getItemData().add(new ThreeTuple<>("Pass:", getPass(), valueOf));
        setTotal(ContextUtil.getResultText(strArr[5]));
        getItemData().add(new ThreeTuple<>("Total:", getTotal(), valueOf));
    }

    public List<ThreeTuple<String, String, Float>> getData() {
        if (getItemData().isEmpty()) {
            getItemData().add(new ThreeTuple<>("Fail:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Pass:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Total:", "*****", Float.valueOf(0.33f)));
        }
        return getItemData();
    }

    public void remove() {
        API.getInstance().UI_PostBool(46, MessageID.MSG_MASK_ENABLE, false);
    }
}
