package com.rigol.scope.data;

import android.content.Context;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.JitterViewModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class JitterResultParam extends ResultParam {
    private transient String BitRate;
    private transient String DCD;
    private transient String DDj;
    private transient String Dj;
    private transient String ISI;
    private transient String Pj;
    private transient String Rj;
    private transient String Tie_pkpk;
    private transient String Tie_stdev;
    private transient String Tj;

    public JitterResultParam() {
        super(52);
    }

    public JitterResultParam(Context context) {
        super(52);
    }

    public String getTj() {
        return this.Tj;
    }

    public void setTj(String str) {
        this.Tj = str;
    }

    public String getRj() {
        return this.Rj;
    }

    public void setRj(String str) {
        this.Rj = str;
    }

    public String getDj() {
        return this.Dj;
    }

    public void setDj(String str) {
        this.Dj = str;
    }

    public String getPj() {
        return this.Pj;
    }

    public void setPj(String str) {
        this.Pj = str;
    }

    public String getDDj() {
        return this.DDj;
    }

    public void setDDj(String str) {
        this.DDj = str;
    }

    public String getDCD() {
        return this.DCD;
    }

    public void setDCD(String str) {
        this.DCD = str;
    }

    public String getISI() {
        return this.ISI;
    }

    public void setISI(String str) {
        this.ISI = str;
    }

    public String getBitRate() {
        return this.BitRate;
    }

    public void setBitRate(String str) {
        this.BitRate = str;
    }

    public String getTie_pkpk() {
        return this.Tie_pkpk;
    }

    public void setTie_pkpk(String str) {
        this.Tie_pkpk = str;
    }

    public String getTie_stdev() {
        return this.Tie_stdev;
    }

    public void setTie_stdev(String str) {
        this.Tie_stdev = str;
    }

    public ServiceEnum.Chan readSource() {
        setSourceA(ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_JITTER_SOURCE)));
        return getSourceA();
    }

    public void setData(String[] strArr) {
        getItemData().clear();
        setSourceA(getSource(strArr[1]));
        setMeasType(ServiceEnum.MeasType.Jitter_Result);
        setTj(ContextUtil.getResultText(strArr[3]));
        ArrayList<ThreeTuple<String, String, Float>> itemData = getItemData();
        String tj = getTj();
        Float valueOf = Float.valueOf(0.33f);
        itemData.add(new ThreeTuple<>("Tj:", tj, valueOf));
        setRj(ContextUtil.getResultText(strArr[4]));
        getItemData().add(new ThreeTuple<>("Rj:", getRj(), valueOf));
        setDj(ContextUtil.getResultText(strArr[5]));
        getItemData().add(new ThreeTuple<>("Dj:", getDj(), valueOf));
        setPj(ContextUtil.getResultText(strArr[6]));
        getItemData().add(new ThreeTuple<>("Pj:", getPj(), valueOf));
        setDDj(ContextUtil.getResultText(strArr[7]));
        getItemData().add(new ThreeTuple<>("DDj:", getDDj(), valueOf));
        setDCD(ContextUtil.getResultText(strArr[8]));
        getItemData().add(new ThreeTuple<>("DCD:", getDCD(), valueOf));
        setISI(ContextUtil.getResultText(strArr[9]));
        getItemData().add(new ThreeTuple<>("ISI:", getISI(), valueOf));
        setBitRate(ContextUtil.getResultText(strArr[10]));
        getItemData().add(new ThreeTuple<>("BR:", getBitRate(), valueOf));
    }

    public List<ThreeTuple<String, String, Float>> getData() {
        if (getItemData().isEmpty()) {
            getItemData().add(new ThreeTuple<>("Tj:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Rj:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Dj:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Pj:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("DDj:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("DCD:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("ISI:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("BR:", "*****", Float.valueOf(0.33f)));
        }
        return getItemData();
    }

    public void remove() {
        JitterParam value;
        JitterViewModel jitterViewModel = (JitterViewModel) ContextUtil.getAppViewModel(JitterViewModel.class);
        if (jitterViewModel == null || (value = jitterViewModel.getLiveData().getValue()) == null) {
            return;
        }
        value.saveResult(false);
    }
}
