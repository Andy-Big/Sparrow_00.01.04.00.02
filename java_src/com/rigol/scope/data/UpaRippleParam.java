package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.utilities.AorBManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpaRippleParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010%\u001a\u00020&H\u0016J\u0006\u0010'\u001a\u00020&J\u0006\u0010(\u001a\u00020&J\u0006\u0010)\u001a\u00020\nJ\b\u0010*\u001a\u00020&H\u0016J\u0006\u0010+\u001a\u00020&J\u000e\u0010,\u001a\u00020&2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010-\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010.\u001a\u00020&2\u0006\u0010\u0019\u001a\u00020\nR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R&\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006/"}, d2 = {"Lcom/rigol/scope/data/UpaRippleParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "aorBManager", "Lcom/rigol/scope/utilities/AorBManager;", "getAorBManager", "()Lcom/rigol/scope/utilities/AorBManager;", "setAorBManager", "(Lcom/rigol/scope/utilities/AorBManager;)V", "value", "", "refPowerCurr", "getRefPowerCurr", "()I", "setRefPowerCurr", "(I)V", "", "refPowerDisp", "getRefPowerDisp", "()Z", "setRefPowerDisp", "(Z)V", "ripplShowList", "getRipplShowList", "setRipplShowList", "statCounts", "getStatCounts", "setStatCounts", "upaCountttr", "Lcom/rigol/scope/cil/MessageAttr;", "getUpaCountttr", "()Lcom/rigol/scope/cil/MessageAttr;", "setUpaCountttr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "upaRippLowAttr", "getUpaRippLowAttr", "setUpaRippLowAttr", "readAll", "", "readPowerCurr", "readPowerDisp", "readRippleCount", "reset", "resetRippleCount", "savePowerCurr", "savePowerDisp", "saveRippleCount", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class UpaRippleParam extends BaseParam {
    private AorBManager aorBManager;
    private int refPowerCurr;
    private boolean refPowerDisp;
    private boolean ripplShowList;
    private int statCounts;
    private MessageAttr upaCountttr;
    private MessageAttr upaRippLowAttr;

    public UpaRippleParam() {
        super(31);
        this.upaRippLowAttr = new MessageAttr();
        this.upaCountttr = new MessageAttr();
        this.statCounts = 100;
        this.refPowerCurr = 100;
    }

    @Bindable
    public final boolean getRipplShowList() {
        return this.ripplShowList;
    }

    public final void setRipplShowList(boolean z) {
        this.ripplShowList = z;
    }

    public final AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public final void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public final MessageAttr getUpaRippLowAttr() {
        return this.upaRippLowAttr;
    }

    public final void setUpaRippLowAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaRippLowAttr = messageAttr;
    }

    public final MessageAttr getUpaCountttr() {
        return this.upaCountttr;
    }

    public final void setUpaCountttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaCountttr = messageAttr;
    }

    @Bindable
    public final int getStatCounts() {
        return this.statCounts;
    }

    public final void setStatCounts(int i) {
        log("statCount", Integer.valueOf(this.statCounts), Integer.valueOf(i));
        this.statCounts = i;
        notifyPropertyChanged(904);
    }

    @Bindable
    public final int getRefPowerCurr() {
        return this.refPowerCurr;
    }

    public final void setRefPowerCurr(int i) {
        log("statCount", Integer.valueOf(this.refPowerCurr), Integer.valueOf(i));
        this.refPowerCurr = i;
        notifyPropertyChanged(724);
    }

    @Bindable
    public final boolean getRefPowerDisp() {
        return this.refPowerDisp;
    }

    public final void setRefPowerDisp(boolean z) {
        log("statCount", Boolean.valueOf(this.refPowerDisp), Boolean.valueOf(z));
        this.refPowerDisp = z;
        notifyPropertyChanged(726);
    }

    public final void saveRippleCount(int i) {
        setStatCounts(i);
        saveInt(MessageID.MSG_UPA_RIPPLE_STAT_COUNT, i);
    }

    public final int readRippleCount() {
        setStatCounts(readInt(MessageID.MSG_UPA_RIPPLE_STAT_COUNT));
        return this.statCounts;
    }

    public final void resetRippleCount() {
        readInt(MessageID.MSG_UPA_RIPPLE_STAT_RESET);
    }

    public final void readPowerCurr() {
        setRefPowerCurr(readInt(MessageID.MSG_UPA_RIPPLE_SOURCE));
        notifyPropertyChanged(724);
    }

    public final void savePowerCurr(int i) {
        setRefPowerCurr(i);
        saveInt(MessageID.MSG_UPA_RIPPLE_SOURCE, i);
    }

    public final void readPowerDisp() {
        setRefPowerDisp(readBool(MessageID.MSG_UPA_RIPPLE_DISP));
        notifyPropertyChanged(726);
    }

    public final void savePowerDisp(boolean z) {
        setRefPowerDisp(z);
        saveBool(MessageID.MSG_UPA_RIPPLE_DISP, z);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readPowerDisp();
        readPowerCurr();
        readRippleCount();
        readAttr(MessageID.MSG_APP_RIPPLE_CNT, this.upaRippLowAttr);
        readAttr(MessageID.MSG_UPA_RIPPLE_STAT_COUNT, this.upaCountttr);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setRefPowerDisp(false);
    }
}
