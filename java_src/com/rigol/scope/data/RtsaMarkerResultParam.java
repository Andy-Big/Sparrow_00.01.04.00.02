package com.rigol.scope.data;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.FftViewModel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class RtsaMarkerResultParam extends ResultParam {
    private transient String Ampt;
    private FftParam fftParam;
    private transient String freq;

    public RtsaMarkerResultParam() {
        super(50);
        FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
        if (fftViewModel != null) {
            fftViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.data.-$$Lambda$RtsaMarkerResultParam$YbOUrjnZTL73AyVkBJdJC9e0eGE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RtsaMarkerResultParam.this.lambda$new$0$RtsaMarkerResultParam((FftParam) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$RtsaMarkerResultParam(FftParam fftParam) {
        this.fftParam = fftParam;
    }

    public String getFreq() {
        return this.freq;
    }

    public void setFreq(String str) {
        this.freq = str;
    }

    public String getAmpt() {
        return this.Ampt;
    }

    public void setAmpt(String str) {
        this.Ampt = str;
    }

    public void setData(String[] strArr) {
        getItemData().clear();
        setFreq(ContextUtil.getResultText(strArr[3]));
        ArrayList<ThreeTuple<String, String, Float>> itemData = getItemData();
        String freq = getFreq();
        Float valueOf = Float.valueOf(0.33f);
        itemData.add(new ThreeTuple<>("Freq:", freq, valueOf));
        setAmpt(ContextUtil.getResultText(strArr[4]));
        getItemData().add(new ThreeTuple<>("Ampt:", getAmpt(), valueOf));
    }

    public List<ThreeTuple<String, String, Float>> getData() {
        if (getItemData().isEmpty()) {
            getItemData().add(new ThreeTuple<>("Freq:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("Ampt:", "*****", Float.valueOf(0.33f)));
        }
        return getItemData();
    }

    public void remove() {
        ServiceEnum.MeasType measType;
        if (this.fftParam != null && (measType = getMeasType()) != null && measType.value1 >= ServiceEnum.MeasType.RTSA_MARKER1.value1 && measType.value1 <= ServiceEnum.MeasType.RTSA_MARKER8.value1) {
            int i = (measType.value1 - ServiceEnum.MeasType.RTSA_MARKER1.value1) + 1;
            this.fftParam.removeMarker(ServiceEnum.getRtsaMarkerFromValue1(i));
            if (i == 1) {
                this.fftParam.savePeakEn(false);
            }
        }
    }
}
