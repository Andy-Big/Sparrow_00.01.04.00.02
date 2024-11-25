package com.rigol.scope.views.adc;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.BaseParam;
import kotlin.Metadata;
/* compiled from: AdcSerParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020\u0004J\u0006\u0010%\u001a\u00020\nJ\u0006\u0010&\u001a\u00020\u0004J\u0006\u0010'\u001a\u00020\nJ\u0006\u0010(\u001a\u00020\u0004J\u0006\u0010)\u001a\u00020\nJ\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\nJ\b\u0010,\u001a\u00020#H\u0016J\u000e\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0004J\u000e\u0010/\u001a\u00020#2\u0006\u00100\u001a\u00020\nJ\u000e\u00101\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0004J\u000e\u00102\u001a\u00020#2\u0006\u00100\u001a\u00020\nJ\u000e\u00103\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0004J\u000e\u00104\u001a\u00020#2\u0006\u00100\u001a\u00020\nJ\u000e\u00105\u001a\u00020#2\u0006\u0010.\u001a\u00020\u0004J\u000e\u00106\u001a\u00020#2\u0006\u00100\u001a\u00020\nR&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR&\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR&\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR&\u0010\u001f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u000f¨\u00067"}, d2 = {"Lcom/rigol/scope/views/adc/AdcSerParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "adc1Tcmp", "getAdc1Tcmp", "()I", "setAdc1Tcmp", "(I)V", "", "adc1Tdmx", "getAdc1Tdmx", "()Z", "setAdc1Tdmx", "(Z)V", "adc2Tcmp", "getAdc2Tcmp", "setAdc2Tcmp", "adc2Tdmx", "getAdc2Tdmx", "setAdc2Tdmx", "adc3Tcmp", "getAdc3Tcmp", "setAdc3Tcmp", "adc3Tdmx", "getAdc3Tdmx", "setAdc3Tdmx", "adc4Tcmp", "getAdc4Tcmp", "setAdc4Tcmp", "adc4Tdmx", "getAdc4Tdmx", "setAdc4Tdmx", "doSave", "", "readAdc1Tcmp", "readAdc1Tdmx", "readAdc2Tcmp", "readAdc2Tdmx", "readAdc3Tcmp", "readAdc3Tdmx", "readAdc4Tcmp", "readAdc4Tdmx", "readAll", "saveAdc1Tcmp", "tcmp", "saveAdc1Tdmx", "tdmx", "saveAdc2Tcmp", "saveAdc2Tdmx", "saveAdc3Tcmp", "saveAdc3Tdmx", "saveAdc4Tcmp", "saveAdc4Tdmx", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class AdcSerParam extends BaseParam {
    private int adc1Tcmp;
    private boolean adc1Tdmx;
    private int adc2Tcmp;
    private boolean adc2Tdmx;
    private int adc3Tcmp;
    private boolean adc3Tdmx;
    private int adc4Tcmp;
    private boolean adc4Tdmx;

    public final void doSave() {
    }

    public AdcSerParam() {
        super(9);
        this.adc1Tcmp = 4;
        this.adc2Tcmp = 4;
        this.adc3Tcmp = 4;
        this.adc4Tcmp = 4;
        this.adc1Tdmx = true;
        this.adc2Tdmx = true;
        this.adc3Tdmx = true;
        this.adc4Tdmx = true;
    }

    @Bindable
    public final int getAdc1Tcmp() {
        return this.adc1Tcmp;
    }

    public final void setAdc1Tcmp(int i) {
        this.adc1Tcmp = i;
        notifyPropertyChanged(29);
    }

    @Bindable
    public final int getAdc2Tcmp() {
        return this.adc2Tcmp;
    }

    public final void setAdc2Tcmp(int i) {
        this.adc2Tcmp = i;
        notifyPropertyChanged(31);
    }

    @Bindable
    public final int getAdc3Tcmp() {
        return this.adc3Tcmp;
    }

    public final void setAdc3Tcmp(int i) {
        this.adc3Tcmp = i;
        notifyPropertyChanged(33);
    }

    @Bindable
    public final int getAdc4Tcmp() {
        return this.adc4Tcmp;
    }

    public final void setAdc4Tcmp(int i) {
        this.adc4Tcmp = i;
        notifyPropertyChanged(35);
    }

    @Bindable
    public final boolean getAdc1Tdmx() {
        return this.adc1Tdmx;
    }

    public final void setAdc1Tdmx(boolean z) {
        this.adc1Tdmx = z;
        notifyPropertyChanged(30);
    }

    @Bindable
    public final boolean getAdc2Tdmx() {
        return this.adc2Tdmx;
    }

    public final void setAdc2Tdmx(boolean z) {
        this.adc2Tdmx = z;
        notifyPropertyChanged(32);
    }

    @Bindable
    public final boolean getAdc3Tdmx() {
        return this.adc3Tdmx;
    }

    public final void setAdc3Tdmx(boolean z) {
        this.adc3Tdmx = z;
        notifyPropertyChanged(34);
    }

    @Bindable
    public final boolean getAdc4Tdmx() {
        return this.adc4Tdmx;
    }

    public final void setAdc4Tdmx(boolean z) {
        this.adc4Tdmx = z;
        notifyPropertyChanged(36);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        super.readAll();
        readAdc1Tcmp();
        readAdc2Tcmp();
        readAdc3Tcmp();
        readAdc4Tcmp();
        readAdc1Tdmx();
        readAdc2Tdmx();
        readAdc3Tdmx();
        readAdc4Tdmx();
    }

    public final int readAdc1Tcmp() {
        setAdc1Tcmp(readInt(MessageID.MSG_ADC1_TCMP));
        return this.adc1Tcmp;
    }

    public final int readAdc2Tcmp() {
        setAdc2Tcmp(readInt(MessageID.MSG_ADC2_TCMP));
        return this.adc2Tcmp;
    }

    public final int readAdc3Tcmp() {
        setAdc3Tcmp(readInt(MessageID.MSG_ADC3_TCMP));
        return this.adc3Tcmp;
    }

    public final int readAdc4Tcmp() {
        setAdc4Tcmp(readInt(MessageID.MSG_ADC4_TCMP));
        return this.adc4Tcmp;
    }

    public final boolean readAdc1Tdmx() {
        setAdc1Tdmx(readInt(MessageID.MSG_ADC1_TDMX) == 1);
        return this.adc1Tdmx;
    }

    public final boolean readAdc2Tdmx() {
        setAdc2Tdmx(readInt(MessageID.MSG_ADC2_TDMX) == 1);
        return this.adc2Tdmx;
    }

    public final boolean readAdc3Tdmx() {
        setAdc3Tdmx(readInt(MessageID.MSG_ADC3_TDMX) == 1);
        return this.adc1Tdmx;
    }

    public final boolean readAdc4Tdmx() {
        setAdc4Tdmx(readInt(MessageID.MSG_ADC4_TDMX) == 1);
        return this.adc4Tdmx;
    }

    public final void saveAdc1Tdmx(boolean z) {
        setAdc1Tdmx(z);
        saveInt(MessageID.MSG_ADC1_TDMX, z);
    }

    public final void saveAdc2Tdmx(boolean z) {
        setAdc2Tdmx(z);
        saveInt(MessageID.MSG_ADC2_TDMX, z);
    }

    public final void saveAdc3Tdmx(boolean z) {
        setAdc3Tdmx(z);
        saveInt(MessageID.MSG_ADC3_TDMX, z);
    }

    public final void saveAdc4Tdmx(boolean z) {
        setAdc4Tdmx(z);
        saveInt(MessageID.MSG_ADC4_TDMX, z);
    }

    public final void saveAdc1Tcmp(int i) {
        setAdc1Tcmp(i);
        saveInt(MessageID.MSG_ADC1_TCMP, i);
    }

    public final void saveAdc2Tcmp(int i) {
        setAdc2Tcmp(i);
        saveInt(MessageID.MSG_ADC2_TCMP, i);
    }

    public final void saveAdc3Tcmp(int i) {
        setAdc3Tcmp(i);
        saveInt(MessageID.MSG_ADC3_TCMP, i);
    }

    public final void saveAdc4Tcmp(int i) {
        setAdc4Tcmp(i);
        saveInt(MessageID.MSG_ADC4_TCMP, i);
    }
}
