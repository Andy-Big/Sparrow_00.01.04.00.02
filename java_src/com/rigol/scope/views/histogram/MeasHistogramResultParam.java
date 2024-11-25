package com.rigol.scope.views.histogram;

import androidx.collection.SparseArrayCompat;
import androidx.databinding.Bindable;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.data.ThreeTuple;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MeasHistogramResultParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010>\u001a\u00020?J\u001b\u0010@\u001a\u00020?2\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040A¢\u0006\u0002\u0010BR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR)\u0010\f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e0\r8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0006\"\u0004\b!\u0010\bR\u001c\u0010\"\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0006\"\u0004\b$\u0010\bR\u001c\u0010%\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR\u001c\u0010(\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\bR\u001c\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR\u001c\u0010.\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0006\"\u0004\b0\u0010\bR\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u000402¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0006\"\u0004\b7\u0010\bR&\u00109\u001a\u0002082\u0006\u0010\u0012\u001a\u0002088G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/rigol/scope/views/histogram/MeasHistogramResultParam;", "Lcom/rigol/scope/data/ResultParam;", "()V", "XScale", "", "getXScale", "()Ljava/lang/String;", "setXScale", "(Ljava/lang/String;)V", "binWidth", "getBinWidth", "setBinWidth", "data", "", "Lcom/rigol/scope/data/ThreeTuple;", "", "getData", "()Ljava/util/List;", "value", "", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "hmode", "getHmode", "setHmode", "max", "getMax", "setMax", "mean", "getMean", "setMean", "median", "getMedian", "setMedian", "min", "getMin", "setMin", "peaks", "getPeaks", "setPeaks", "pkpk", "getPkpk", "setPkpk", "sigma", "getSigma", "setSigma", "sourceArray", "Landroidx/collection/SparseArrayCompat;", "getSourceArray", "()Landroidx/collection/SparseArrayCompat;", "sum", "getSum", "setSum", "Lcom/rigol/scope/cil/ServiceEnum$Unit;", "verUnit", "getVerUnit", "()Lcom/rigol/scope/cil/ServiceEnum$Unit;", "setVerUnit", "(Lcom/rigol/scope/cil/ServiceEnum$Unit;)V", "remove", "", "setData", "", "([Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MeasHistogramResultParam extends ResultParam {
    private transient String XScale;
    private transient String binWidth;
    private boolean enable;
    private transient String hmode;
    private transient String max;
    private transient String mean;
    private transient String median;
    private transient String min;
    private transient String peaks;
    private transient String pkpk;
    private transient String sigma;
    private final transient SparseArrayCompat<String> sourceArray;
    private transient String sum;
    private ServiceEnum.Unit verUnit;

    public MeasHistogramResultParam() {
        super(28);
        boolean z;
        z = MeasHistogramResultParamKt.DEFAULT_HISTO_ENABLE;
        this.enable = z;
        this.verUnit = ServiceEnum.Unit.Unit_V;
        this.sourceArray = new SparseArrayCompat<>();
        for (MappingObject mappingObject : ViewUtil.getList((int) R.array.msg_histo_source)) {
            SparseArrayCompat<String> sparseArrayCompat = this.sourceArray;
            Intrinsics.checkNotNullExpressionValue(mappingObject, "mappingObject");
            sparseArrayCompat.append(mappingObject.getValue(), mappingObject.getStr());
        }
    }

    @Bindable
    public final boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
        notifyPropertyChanged(271);
    }

    @Bindable
    public final ServiceEnum.Unit getVerUnit() {
        return this.verUnit;
    }

    public final void setVerUnit(ServiceEnum.Unit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.verUnit = value;
        notifyPropertyChanged(1021);
    }

    public final SparseArrayCompat<String> getSourceArray() {
        return this.sourceArray;
    }

    public final String getSum() {
        return this.sum;
    }

    public final void setSum(String str) {
        this.sum = str;
    }

    public final String getPeaks() {
        return this.peaks;
    }

    public final void setPeaks(String str) {
        this.peaks = str;
    }

    public final String getMax() {
        return this.max;
    }

    public final void setMax(String str) {
        this.max = str;
    }

    public final String getMin() {
        return this.min;
    }

    public final void setMin(String str) {
        this.min = str;
    }

    public final String getPkpk() {
        return this.pkpk;
    }

    public final void setPkpk(String str) {
        this.pkpk = str;
    }

    public final String getMean() {
        return this.mean;
    }

    public final void setMean(String str) {
        this.mean = str;
    }

    public final String getMedian() {
        return this.median;
    }

    public final void setMedian(String str) {
        this.median = str;
    }

    public final String getHmode() {
        return this.hmode;
    }

    public final void setHmode(String str) {
        this.hmode = str;
    }

    public final String getBinWidth() {
        return this.binWidth;
    }

    public final void setBinWidth(String str) {
        this.binWidth = str;
    }

    public final String getSigma() {
        return this.sigma;
    }

    public final void setSigma(String str) {
        this.sigma = str;
    }

    public final String getXScale() {
        return this.XScale;
    }

    public final void setXScale(String str) {
        this.XScale = str;
    }

    public final void setData(String[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getItemData().clear();
        String str = data[1];
        Intrinsics.checkNotNull(str);
        setSourceA(getSource(str));
        String str2 = data[2];
        Intrinsics.checkNotNull(str2);
        setSourceB(getSource(str2));
        String resultText = ContextUtil.getResultText(data[3]);
        ArrayList<ThreeTuple<String, String, Float>> itemData = getItemData();
        Float valueOf = Float.valueOf(0.5f);
        itemData.add(new ThreeTuple<>("Type:", resultText, valueOf));
        this.sum = ContextUtil.getResultText(data[5]);
        getItemData().add(new ThreeTuple<>("Sum:", this.sum, valueOf));
        this.peaks = ContextUtil.getResultText(data[6]);
        getItemData().add(new ThreeTuple<>("Peaks:", this.peaks, valueOf));
        this.max = ContextUtil.getResultText(data[7]);
        getItemData().add(new ThreeTuple<>("Max:", this.max, valueOf));
        this.min = ContextUtil.getResultText(data[8]);
        getItemData().add(new ThreeTuple<>("Min:", this.min, valueOf));
        this.pkpk = ContextUtil.getResultText(data[9]);
        getItemData().add(new ThreeTuple<>("Pk_Pk:", this.pkpk, valueOf));
        this.mean = ContextUtil.getResultText(data[10]);
        getItemData().add(new ThreeTuple<>("Mean:", this.mean, valueOf));
        this.median = ContextUtil.getResultText(data[11]);
        getItemData().add(new ThreeTuple<>("Median:", this.median, valueOf));
        this.hmode = ContextUtil.getResultText(data[12]);
        getItemData().add(new ThreeTuple<>("Mode:", this.hmode, valueOf));
        this.binWidth = ContextUtil.getResultText(data[13]);
        getItemData().add(new ThreeTuple<>("Bin width:", this.binWidth, valueOf));
        this.sigma = ContextUtil.getResultText(data[14]);
        getItemData().add(new ThreeTuple<>("Sigma:", this.sigma, valueOf));
        this.XScale = ContextUtil.getResultText(data[15]);
        getItemData().add(new ThreeTuple<>("XScale:", this.XScale, valueOf));
    }

    public final List<ThreeTuple<String, String, Float>> getData() {
        if (getItemData().isEmpty()) {
            getItemData().add(new ThreeTuple<>("Type:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Sum:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Peaks:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Max:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Min:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Pk_Pk:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Mean:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Median:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Mode:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Bin width:", "*****", Float.valueOf(0.6f)));
            getItemData().add(new ThreeTuple<>("Sigma:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("XScale:", "*****", Float.valueOf(0.5f)));
        }
        return getItemData();
    }

    public final void remove() {
        saveBool(MessageID.MSG_APP_MEAS_HISTO_ENABLE, false);
        syncData(MessageID.MSG_APP_MEAS_HISTO_ENABLE, false);
    }
}
