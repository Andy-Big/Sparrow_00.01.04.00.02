package com.rigol.scope.data;

import android.content.Context;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.EyeViewModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class EyeResultParam extends ResultParam {
    private transient String cross;
    private transient String eyeAmp;
    private transient String eyeHeight;
    private transient String eyeWidth;
    private transient String one;
    private transient String qFactor;
    private transient String zero;

    public EyeResultParam() {
        super(51);
    }

    public EyeResultParam(Context context) {
        super(51);
    }

    public String getOne() {
        return this.one;
    }

    public void setOne(String str) {
        this.one = str;
    }

    public String getZero() {
        return this.zero;
    }

    public void setZero(String str) {
        this.zero = str;
    }

    public String getEyeWidth() {
        return this.eyeWidth;
    }

    public void setEyeWidth(String str) {
        this.eyeWidth = str;
    }

    public String getEyeHeight() {
        return this.eyeHeight;
    }

    public void setEyeHeight(String str) {
        this.eyeHeight = str;
    }

    public String getEyeAmp() {
        return this.eyeAmp;
    }

    public void setEyeAmp(String str) {
        this.eyeAmp = str;
    }

    public String getCross() {
        return this.cross;
    }

    public void setCross(String str) {
        this.cross = str;
    }

    public String getQFactor() {
        return this.qFactor;
    }

    public void setQFactor(String str) {
        this.qFactor = str;
    }

    public void setData(String[] strArr) {
        getItemData().clear();
        setSourceA(getSource(strArr[1]));
        setMeasType(ServiceEnum.MeasType.EYE_RESULT);
        setOne(ContextUtil.getResultText(strArr[3]));
        ArrayList<ThreeTuple<String, String, Float>> itemData = getItemData();
        String one = getOne();
        Float valueOf = Float.valueOf(0.4f);
        itemData.add(new ThreeTuple<>("One:", one, valueOf));
        setZero(ContextUtil.getResultText(strArr[4]));
        getItemData().add(new ThreeTuple<>("Zero:", getZero(), valueOf));
        setEyeWidth(ContextUtil.getResultText(strArr[5]));
        getItemData().add(new ThreeTuple<>("Width:", getEyeWidth(), valueOf));
        setEyeHeight(ContextUtil.getResultText(strArr[6]));
        getItemData().add(new ThreeTuple<>("Height:", getEyeHeight(), valueOf));
        setEyeAmp(ContextUtil.getResultText(strArr[7]));
        getItemData().add(new ThreeTuple<>("Amp:", getEyeAmp(), valueOf));
        setCross(ContextUtil.getResultText(strArr[8]));
        getItemData().add(new ThreeTuple<>("Cross:", getCross(), valueOf));
        setQFactor(ContextUtil.getResultText(strArr[9]));
        getItemData().add(new ThreeTuple<>("Q Factor:", getQFactor(), Float.valueOf(0.55f)));
        getItemData().add(new ThreeTuple<>("BR:", ContextUtil.getResultText(strArr[10]), valueOf));
    }

    public List<ThreeTuple<String, String, Float>> getData() {
        if (getItemData().isEmpty()) {
            getItemData().add(new ThreeTuple<>("One:", "*****", Float.valueOf(0.4f)));
            getItemData().add(new ThreeTuple<>("Zero:", "*****", Float.valueOf(0.4f)));
            getItemData().add(new ThreeTuple<>("Width:", "*****", Float.valueOf(0.4f)));
            getItemData().add(new ThreeTuple<>("Height:", "*****", Float.valueOf(0.4f)));
            getItemData().add(new ThreeTuple<>("Amp:", "*****", Float.valueOf(0.4f)));
            getItemData().add(new ThreeTuple<>("Cross:", "*****", Float.valueOf(0.4f)));
            getItemData().add(new ThreeTuple<>("Q Factor:", "*****", Float.valueOf(0.55f)));
            getItemData().add(new ThreeTuple<>("BR:", "*****", Float.valueOf(0.4f)));
        }
        return getItemData();
    }

    public void remove() {
        EyeParam value;
        EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
        if (eyeViewModel == null || (value = eyeViewModel.getLiveData().getValue()) == null) {
            return;
        }
        value.getResult().save(false);
    }
}
