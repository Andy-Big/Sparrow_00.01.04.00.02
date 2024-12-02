package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.utilities.AorBManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UpaParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0002\n\u0002\b*\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010k\u001a\u00020l2\u0006\u0010P\u001a\u00020\rJ\u0006\u0010m\u001a\u00020\rJ\b\u0010n\u001a\u00020lH\u0016J\u0006\u0010o\u001a\u00020lJ\u0006\u0010p\u001a\u00020lJ\u0006\u0010q\u001a\u00020\rJ\u0006\u0010r\u001a\u00020lJ\u0006\u0010s\u001a\u00020lJ\u0006\u0010t\u001a\u00020lJ\u0006\u0010u\u001a\u00020lJ\u0006\u0010v\u001a\u00020lJ\u0006\u0010w\u001a\u00020lJ\u0006\u0010x\u001a\u00020lJ\u0006\u0010y\u001a\u00020lJ\u0006\u0010z\u001a\u00020lJ\u0006\u0010{\u001a\u00020lJ\u0006\u0010|\u001a\u00020lJ\u0006\u0010}\u001a\u00020lJ\u0006\u0010~\u001a\u00020lJ\u0006\u0010\u007f\u001a\u00020lJ\u0007\u0010\u0080\u0001\u001a\u00020lJ\u0007\u0010\u0081\u0001\u001a\u00020lJ\u0007\u0010\u0082\u0001\u001a\u00020lJ\u0007\u0010\u0083\u0001\u001a\u00020lJ\t\u0010\u0084\u0001\u001a\u00020lH\u0016J\u0007\u0010\u0085\u0001\u001a\u00020lJ\u000f\u0010\u0086\u0001\u001a\u00020l2\u0006\u0010M\u001a\u00020\rJ\u000f\u0010\u0087\u0001\u001a\u00020l2\u0006\u0010.\u001a\u00020\rJ\u000f\u0010\u0088\u0001\u001a\u00020l2\u0006\u00101\u001a\u00020\rJ\u000f\u0010\u0089\u0001\u001a\u00020l2\u0006\u00104\u001a\u00020\nJ\u000f\u0010\u008a\u0001\u001a\u00020l2\u0006\u00108\u001a\u00020\rJ\u000f\u0010\u008b\u0001\u001a\u00020l2\u0006\u0010>\u001a\u00020\rJ\u000f\u0010\u008c\u0001\u001a\u00020l2\u0006\u0010\u001c\u001a\u00020\u0013J\u000f\u0010\u008d\u0001\u001a\u00020l2\u0006\u0010\u0019\u001a\u00020\u0013J\u000f\u0010\u008e\u0001\u001a\u00020l2\u0006\u0010%\u001a\u00020\rJ\u000f\u0010\u008f\u0001\u001a\u00020l2\u0006\u0010\"\u001a\u00020\rJ\u000f\u0010\u0090\u0001\u001a\u00020l2\u0006\u0010\u0014\u001a\u00020\u0013J\u000f\u0010\u0091\u0001\u001a\u00020l2\u0006\u0010(\u001a\u00020\rJ\u000f\u0010\u0092\u0001\u001a\u00020l2\u0006\u0010G\u001a\u00020\rJ\u000f\u0010\u0093\u0001\u001a\u00020l2\u0006\u0010A\u001a\u00020\rJ\u000f\u0010\u0094\u0001\u001a\u00020l2\u0006\u0010D\u001a\u00020\rJ\u000f\u0010\u0095\u0001\u001a\u00020l2\u0006\u0010J\u001a\u00020\rJ\n\u0010\u0096\u0001\u001a\u00030\u0097\u0001H\u0016J\u0007\u0010\u0098\u0001\u001a\u00020lJ\u0007\u0010\u0099\u0001\u001a\u00020lJ\u0007\u0010\u009a\u0001\u001a\u00020lR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u000bR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R&\u0010\u001c\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R&\u0010\u001f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0010\"\u0004\b!\u0010\u0012R&\u0010\"\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R&\u0010%\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R&\u0010(\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u0012R&\u0010+\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0010\"\u0004\b-\u0010\u0012R&\u0010.\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0010\"\u0004\b0\u0010\u0012R&\u00101\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0010\"\u0004\b3\u0010\u0012R&\u00104\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u000b\"\u0004\b6\u00107R&\u00108\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0010\"\u0004\b:\u0010\u0012R&\u0010;\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0010\"\u0004\b=\u0010\u0012R&\u0010>\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0010\"\u0004\b@\u0010\u0012R&\u0010A\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0010\"\u0004\bC\u0010\u0012R&\u0010D\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\u0010\"\u0004\bF\u0010\u0012R&\u0010G\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0010\"\u0004\bI\u0010\u0012R&\u0010J\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0010\"\u0004\bL\u0010\u0012R&\u0010M\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0010\"\u0004\bO\u0010\u0012R&\u0010P\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\u0010\"\u0004\bR\u0010\u0012R\u001a\u0010S\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010V\"\u0004\b[\u0010XR\u001a\u0010\\\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010V\"\u0004\b^\u0010XR\u001a\u0010_\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010V\"\u0004\ba\u0010XR\u001a\u0010b\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010V\"\u0004\bd\u0010XR\u001a\u0010e\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010V\"\u0004\bg\u0010XR\u001a\u0010h\u001a\u00020TX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010V\"\u0004\bj\u0010X¨\u0006\u009b\u0001"}, d2 = {"Lcom/rigol/scope/data/UpaParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "aorBManager", "Lcom/rigol/scope/utilities/AorBManager;", "getAorBManager", "()Lcom/rigol/scope/utilities/AorBManager;", "setAorBManager", "(Lcom/rigol/scope/utilities/AorBManager;)V", "isShowList", "", "()Z", "value", "", "pctHigt", "getPctHigt", "()I", "setPctHigt", "(I)V", "", "refAbsHigh", "getRefAbsHigh", "()J", "setRefAbsHigh", "(J)V", "refAbsLow", "getRefAbsLow", "setRefAbsLow", "refAbsMid", "getRefAbsMid", "setRefAbsMid", "refFerqrefSource", "getRefFerqrefSource", "setRefFerqrefSource", "refPctLow", "getRefPctLow", "setRefPctLow", "refPctMid", "getRefPctMid", "setRefPctMid", "refPctlHigh", "getRefPctlHigh", "setRefPctlHigh", "refPowerAutoset", "getRefPowerAutoset", "setRefPowerAutoset", "refPowerCurr", "getRefPowerCurr", "setRefPowerCurr", "refPowerCyc", "getRefPowerCyc", "setRefPowerCyc", "refPowerDisp", "getRefPowerDisp", "setRefPowerDisp", "(Z)V", "refPowerFref", "getRefPowerFref", "setRefPowerFref", "refPowerTips", "getRefPowerTips", "setRefPowerTips", "refPowerVolt", "getRefPowerVolt", "setRefPowerVolt", "refRippleDisp", "getRefRippleDisp", "setRefRippleDisp", "refRippleSource", "getRefRippleSource", "setRefRippleSource", "reflType", "getReflType", "setReflType", "reflevel", "getReflevel", "setReflevel", "statCount", "getStatCount", "setStatCount", "type", "getType", "setType", "upaAbsHighAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getUpaAbsHighAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "setUpaAbsHighAttr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "upaAbsLowAttr", "getUpaAbsLowAttr", "setUpaAbsLowAttr", "upaAbsMiddleAttr", "getUpaAbsMiddleAttr", "setUpaAbsMiddleAttr", "upaCountttr", "getUpaCountttr", "setUpaCountttr", "upaholdHighAttr", "getUpaholdHighAttr", "setUpaholdHighAttr", "upaholdLowAttr", "getUpaholdLowAttr", "setUpaholdLowAttr", "upaholdMiddleAttr", "getUpaholdMiddleAttr", "setUpaholdMiddleAttr", "disposeType", "", "getDisposeType", "readAll", "readFerqrefAutoset", "readFerqrefSource", "readPowerCount", "readPowerCurr", "readPowerCyc", "readPowerDisp", "readPowerFref", "readPowerTips", "readPowerVolt", "readRefAbsLow", "readRefAbsMid", "readRefLevel", "readRefPctLow", "readRefPctMid", "readReflAbsHigh", "readReflHigh", "readReflType", "readRippleAutoset", "readRippleDisp", "readRippleSource", "readRippleTips", "reset", "resetPowerCount", "savePowerCount", "savePowerCurr", "savePowerCyc", "savePowerDisp", "savePowerFref", "savePowerVolt", "saveRefAbsMid", "saveRefPctAbsLow", "saveRefPctMid", "saveRefPctMidLow", "saveReflAbsHigh", "saveReflHigh", "saveReflType", "saveRippleDisp", "saveRippleSource", "setRefLevel", "toString", "", "upaFoundDefault", "updateRefAbsAttr", "updateRefPctAttr", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class UpaParam extends BaseParam {
    private AorBManager aorBManager;
    private final boolean isShowList;
    private int pctHigt;
    private long refAbsHigh;
    private long refAbsLow;
    private long refAbsMid;
    private int refFerqrefSource;
    private int refPctLow;
    private int refPctMid;
    private int refPctlHigh;
    private int refPowerAutoset;
    private int refPowerCurr;
    private int refPowerCyc;
    private boolean refPowerDisp;
    private int refPowerFref;
    private int refPowerTips;
    private int refPowerVolt;
    private int refRippleDisp;
    private int refRippleSource;
    private int reflType;
    private int reflevel;
    private int statCount;
    private int type;
    private MessageAttr upaAbsHighAttr;
    private MessageAttr upaAbsLowAttr;
    private MessageAttr upaAbsMiddleAttr;
    private MessageAttr upaCountttr;
    private MessageAttr upaholdHighAttr;
    private MessageAttr upaholdLowAttr;
    private MessageAttr upaholdMiddleAttr;

    public UpaParam() {
        super(31);
        this.type = 100;
        this.pctHigt = 100;
        this.statCount = 100;
        this.reflType = 100;
        this.refPctlHigh = 100;
        this.refPctMid = 100;
        this.refPctLow = 100;
        this.refAbsHigh = 100L;
        this.refAbsMid = 100L;
        this.refAbsLow = 100L;
        this.refPowerVolt = 100;
        this.refPowerCurr = 100;
        this.refPowerFref = 100;
        this.refFerqrefSource = 100;
        this.refPowerCyc = 100;
        this.refPowerAutoset = 100;
        this.refPowerTips = 100;
        this.refRippleSource = 100;
        this.refRippleDisp = 100;
        this.reflevel = 100;
        this.upaholdHighAttr = new MessageAttr();
        this.upaAbsHighAttr = new MessageAttr();
        this.upaholdMiddleAttr = new MessageAttr();
        this.upaAbsMiddleAttr = new MessageAttr();
        this.upaholdLowAttr = new MessageAttr();
        this.upaAbsLowAttr = new MessageAttr();
        this.upaCountttr = new MessageAttr();
    }

    public final boolean isShowList() {
        return this.isShowList;
    }

    @Bindable
    public final int getType() {
        return this.type;
    }

    public final void setType(int i) {
        log("statCount", Integer.valueOf(this.type), Integer.valueOf(i));
        this.type = i;
        notifyPropertyChanged(978);
    }

    @Bindable
    public final int getPctHigt() {
        return this.pctHigt;
    }

    public final void setPctHigt(int i) {
        log("statCount", Integer.valueOf(this.pctHigt), Integer.valueOf(i));
        this.pctHigt = i;
    }

    @Bindable
    public final int getStatCount() {
        return this.statCount;
    }

    public final void setStatCount(int i) {
        log("statCount", Integer.valueOf(this.statCount), Integer.valueOf(i));
        this.statCount = i;
        notifyPropertyChanged(903);
    }

    @Bindable
    public final int getReflType() {
        return this.reflType;
    }

    public final void setReflType(int i) {
        log("statCount", Integer.valueOf(this.reflType), Integer.valueOf(i));
        this.reflType = i;
        notifyPropertyChanged(732);
    }

    @Bindable
    public final int getRefPctlHigh() {
        return this.refPctlHigh;
    }

    public final void setRefPctlHigh(int i) {
        log("statCount", Integer.valueOf(this.refPctlHigh), Integer.valueOf(i));
        this.refPctlHigh = i;
        notifyPropertyChanged(722);
    }

    @Bindable
    public final int getRefPctMid() {
        return this.refPctMid;
    }

    public final void setRefPctMid(int i) {
        log("statCount", Integer.valueOf(this.refPctMid), Integer.valueOf(i));
        this.refPctMid = i;
        notifyPropertyChanged(721);
    }

    @Bindable
    public final int getRefPctLow() {
        return this.refPctLow;
    }

    public final void setRefPctLow(int i) {
        log("statCount", Integer.valueOf(this.refPctLow), Integer.valueOf(i));
        this.refPctLow = i;
        notifyPropertyChanged(720);
    }

    @Bindable
    public final long getRefAbsHigh() {
        return this.refAbsHigh;
    }

    public final void setRefAbsHigh(long j) {
        log("statCount", Long.valueOf(this.refAbsHigh), Long.valueOf(j));
        this.refAbsHigh = j;
        notifyPropertyChanged(711);
    }

    @Bindable
    public final long getRefAbsMid() {
        return this.refAbsMid;
    }

    public final void setRefAbsMid(long j) {
        log("statCount", Long.valueOf(this.refAbsMid), Long.valueOf(j));
        this.refAbsMid = j;
        notifyPropertyChanged(713);
    }

    @Bindable
    public final long getRefAbsLow() {
        return this.refAbsLow;
    }

    public final void setRefAbsLow(long j) {
        log("statCount", Long.valueOf(this.refAbsLow), Long.valueOf(j));
        this.refAbsLow = j;
        notifyPropertyChanged(712);
    }

    @Bindable
    public final int getRefPowerVolt() {
        return this.refPowerVolt;
    }

    public final void setRefPowerVolt(int i) {
        log("statCount", Integer.valueOf(this.refPowerVolt), Integer.valueOf(i));
        this.refPowerVolt = i;
        notifyPropertyChanged(729);
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
    public final int getRefPowerFref() {
        return this.refPowerFref;
    }

    public final void setRefPowerFref(int i) {
        log("statCount", Integer.valueOf(this.refPowerFref), Integer.valueOf(i));
        this.refPowerFref = i;
        notifyPropertyChanged(727);
        syncData(MessageID.MSG_UPA_POWER_FREF, Integer.valueOf(this.refPowerFref));
    }

    @Bindable
    public final int getRefFerqrefSource() {
        return this.refFerqrefSource;
    }

    public final void setRefFerqrefSource(int i) {
        log("statCount", Integer.valueOf(this.refFerqrefSource), Integer.valueOf(i));
        this.refFerqrefSource = i;
    }

    @Bindable
    public final int getRefPowerCyc() {
        return this.refPowerCyc;
    }

    public final void setRefPowerCyc(int i) {
        log("statCount", Integer.valueOf(this.refPowerCyc), Integer.valueOf(i));
        this.refPowerCyc = i;
    }

    @Bindable
    public final int getRefPowerAutoset() {
        return this.refPowerAutoset;
    }

    public final void setRefPowerAutoset(int i) {
        log("statCount", Integer.valueOf(this.refPowerAutoset), Integer.valueOf(i));
        this.refPowerAutoset = i;
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

    @Bindable
    public final int getRefPowerTips() {
        return this.refPowerTips;
    }

    public final void setRefPowerTips(int i) {
        log("statCount", Integer.valueOf(this.refPowerTips), Integer.valueOf(i));
        this.refPowerTips = i;
    }

    @Bindable
    public final int getRefRippleSource() {
        return this.refRippleSource;
    }

    public final void setRefRippleSource(int i) {
        log("statCount", Integer.valueOf(this.refRippleSource), Integer.valueOf(i));
        this.refRippleSource = i;
    }

    @Bindable
    public final int getRefRippleDisp() {
        return this.refRippleDisp;
    }

    public final void setRefRippleDisp(int i) {
        log("statCount", Integer.valueOf(this.refRippleDisp), Integer.valueOf(i));
        this.refRippleDisp = i;
    }

    @Bindable
    public final int getReflevel() {
        return this.reflevel;
    }

    public final void setReflevel(int i) {
        log("statCount", Integer.valueOf(this.reflevel), Integer.valueOf(i));
        this.reflevel = i;
        notifyPropertyChanged(733);
    }

    public final AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public final void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public final MessageAttr getUpaholdHighAttr() {
        return this.upaholdHighAttr;
    }

    public final void setUpaholdHighAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaholdHighAttr = messageAttr;
    }

    public final MessageAttr getUpaAbsHighAttr() {
        return this.upaAbsHighAttr;
    }

    public final void setUpaAbsHighAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaAbsHighAttr = messageAttr;
    }

    public final MessageAttr getUpaholdMiddleAttr() {
        return this.upaholdMiddleAttr;
    }

    public final void setUpaholdMiddleAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaholdMiddleAttr = messageAttr;
    }

    public final MessageAttr getUpaAbsMiddleAttr() {
        return this.upaAbsMiddleAttr;
    }

    public final void setUpaAbsMiddleAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaAbsMiddleAttr = messageAttr;
    }

    public final MessageAttr getUpaholdLowAttr() {
        return this.upaholdLowAttr;
    }

    public final void setUpaholdLowAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaholdLowAttr = messageAttr;
    }

    public final MessageAttr getUpaAbsLowAttr() {
        return this.upaAbsLowAttr;
    }

    public final void setUpaAbsLowAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaAbsLowAttr = messageAttr;
    }

    public final MessageAttr getUpaCountttr() {
        return this.upaCountttr;
    }

    public final void setUpaCountttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.upaCountttr = messageAttr;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        getDisposeType();
        readPowerVolt();
        readPowerFref();
        readPowerCurr();
        readReflType();
        readReflAbsHigh();
        readRefAbsMid();
        readRefAbsLow();
        readReflHigh();
        readRefPctMid();
        readRefPctLow();
        readRefLevel();
        readPowerCount();
        readAttr(MessageID.MSG_UPA_REFL_PCT_HIGH, this.upaholdHighAttr);
        readAttr(MessageID.MSG_UPA_REFL_PCT_MID, this.upaholdMiddleAttr);
        readAttr(MessageID.MSG_UPA_REFL_PCT_LOW, this.upaholdLowAttr);
        readAttr(MessageID.MSG_UPA_REFL_ABS_HIGH, this.upaAbsHighAttr);
        readAttr(MessageID.MSG_UPA_REFL_ABS_MID, this.upaAbsMiddleAttr);
        readAttr(MessageID.MSG_UPA_REFL_ABS_LOW, this.upaAbsLowAttr);
        readAttr(MessageID.MSG_UPA_POWER_STAT_COUNT, this.upaCountttr);
        readPowerDisp();
    }

    public final void upaFoundDefault() {
        setRefPctlHigh(this.upaholdHighAttr.getDefIntValue());
        setRefPctMid(this.upaholdMiddleAttr.getDefIntValue());
        setRefPctLow(this.upaholdLowAttr.getDefIntValue());
        setRefAbsHigh(this.upaAbsHighAttr.getDefLongValue());
        setRefAbsMid(this.upaAbsMiddleAttr.getDefLongValue());
        setRefAbsLow(this.upaAbsLowAttr.getDefLongValue());
    }

    public final void disposeType(int i) {
        setType(i);
        saveInt(MessageID.MSG_UPA_TYPE, i);
        notifyPropertyChanged(978);
    }

    public final int getDisposeType() {
        setType(readInt(MessageID.MSG_UPA_TYPE));
        return this.type;
    }

    public final void savePowerCount(int i) {
        setStatCount(i);
        saveInt(MessageID.MSG_UPA_POWER_STAT_COUNT, i);
    }

    public final int readPowerCount() {
        setStatCount(readInt(MessageID.MSG_UPA_POWER_STAT_COUNT));
        return this.statCount;
    }

    public final void resetPowerCount() {
        readInt(MessageID.MSG_UPA_POWER_STAT_RESET);
        readPowerCount();
    }

    public final void readReflType() {
        setReflType(readInt(MessageID.MSG_UPA_REFL_TYPE));
    }

    public final void saveReflType(int i) {
        setReflType(i);
        saveInt(MessageID.MSG_UPA_REFL_TYPE, i);
    }

    public final void readReflHigh() {
        setRefPctlHigh(readInt(MessageID.MSG_UPA_REFL_PCT_HIGH));
    }

    public final void saveReflHigh(int i) {
        setRefPctlHigh(i);
        saveInt(MessageID.MSG_UPA_REFL_PCT_HIGH, i);
    }

    public final void readRefPctMid() {
        setRefPctMid(readInt(MessageID.MSG_UPA_REFL_PCT_MID));
    }

    public final void saveRefPctMid(int i) {
        setRefPctMid(i);
        saveInt(MessageID.MSG_UPA_REFL_PCT_MID, i);
    }

    public final void readRefPctLow() {
        setRefPctLow(readInt(MessageID.MSG_UPA_REFL_PCT_LOW));
    }

    public final void saveRefPctMidLow(int i) {
        setRefPctLow(i);
        saveInt(MessageID.MSG_UPA_REFL_PCT_LOW, i);
    }

    public final void readReflAbsHigh() {
        setRefAbsHigh(readLong(MessageID.MSG_UPA_REFL_ABS_HIGH));
    }

    public final void saveReflAbsHigh(long j) {
        setRefAbsHigh(j);
        saveLong(MessageID.MSG_UPA_REFL_ABS_HIGH, j);
    }

    public final void readRefAbsMid() {
        setRefAbsMid(readLong(MessageID.MSG_UPA_REFL_ABS_MID));
    }

    public final void saveRefAbsMid(long j) {
        setRefAbsMid(j);
        saveLong(MessageID.MSG_UPA_REFL_ABS_MID, j);
    }

    public final void readRefAbsLow() {
        setRefAbsLow(readLong(MessageID.MSG_UPA_REFL_ABS_LOW));
    }

    public final void saveRefPctAbsLow(long j) {
        setRefAbsLow(j);
        saveLong(MessageID.MSG_UPA_REFL_ABS_LOW, j);
    }

    public final void readPowerVolt() {
        setRefPowerVolt(readInt(MessageID.MSG_UPA_POWER_VOLT));
    }

    public final void savePowerVolt(int i) {
        setRefPowerVolt(i);
        saveInt(MessageID.MSG_UPA_POWER_VOLT, i);
    }

    public final void readPowerCurr() {
        setRefPowerCurr(readInt(MessageID.MSG_UPA_POWER_CURR));
    }

    public final void savePowerCurr(int i) {
        setRefPowerCurr(i);
        saveInt(MessageID.MSG_UPA_POWER_CURR, i);
    }

    public final void readPowerFref() {
        setRefPowerFref(readInt(MessageID.MSG_UPA_REFL_TYPE));
    }

    public final void savePowerFref(int i) {
        setRefPowerFref(i);
        saveInt(MessageID.MSG_UPA_REFL_TYPE, i);
    }

    public final void readFerqrefSource() {
        setRefFerqrefSource(readInt(MessageID.MSG_UPA_POWER_SOURCE));
    }

    public final void readPowerCyc() {
        setRefPowerCyc(readInt(MessageID.MSG_UPA_POWER_FREF));
    }

    public final void savePowerCyc(int i) {
        setRefPowerCyc(i);
        saveInt(MessageID.MSG_UPA_POWER_CYC, i);
    }

    public final void readFerqrefAutoset() {
        setRefPowerAutoset(readInt(MessageID.MSG_UPA_POWER_AUTOSET));
    }

    public final void readPowerDisp() {
        setRefPowerDisp(readBool(MessageID.MSG_UPA_POWER_DISP));
        notifyPropertyChanged(726);
    }

    public final void savePowerDisp(boolean z) {
        setRefPowerDisp(z);
        saveBool(MessageID.MSG_UPA_POWER_DISP, z);
        notifyPropertyChanged(726);
    }

    public final void readPowerTips() {
        setRefPowerTips(readInt(MessageID.MSG_UPA_RIPPLE_SOURCE));
    }

    public final void readRippleSource() {
        setRefRippleSource(readInt(MessageID.MSG_UPA_RIPPLE_SOURCE));
    }

    public final void saveRippleSource(int i) {
        setRefRippleSource(i);
        saveInt(MessageID.MSG_UPA_POWER_DISP, i);
    }

    public final void readRippleAutoset() {
        readInt(MessageID.MSG_UPA_RIPPLE_AUTOSET);
    }

    public final void readRippleDisp() {
        setRefRippleDisp(readInt(MessageID.MSG_UPA_RIPPLE_DISP));
    }

    public final void saveRippleDisp(int i) {
        setRefRippleDisp(i);
        saveInt(MessageID.MSG_UPA_RIPPLE_DISP, i);
    }

    public final void readRippleTips() {
        readInt(MessageID.MSG_UPA_RIPPLE_TIPS);
    }

    public final void readRefLevel() {
        if (readBool(MessageID.MSG_UPA_POWER_FREF)) {
            setReflevel(1);
        } else {
            setReflevel(0);
        }
        notifyPropertyChanged(733);
    }

    public final void setRefLevel(int i) {
        setReflevel(i);
        saveInt(MessageID.MSG_UPA_POWER_FREF, i);
    }

    public final void updateRefPctAttr() {
        readAttr(MessageID.MSG_UPA_REFL_PCT_HIGH, this.upaholdHighAttr);
        readAttr(MessageID.MSG_UPA_REFL_PCT_LOW, this.upaholdLowAttr);
        readAttr(MessageID.MSG_UPA_REFL_PCT_MID, this.upaholdMiddleAttr);
    }

    public final void updateRefAbsAttr() {
        readAttr(MessageID.MSG_UPA_REFL_ABS_HIGH, this.upaAbsHighAttr);
        readAttr(MessageID.MSG_UPA_REFL_ABS_LOW, this.upaAbsLowAttr);
        readAttr(MessageID.MSG_UPA_REFL_ABS_MID, this.upaAbsMiddleAttr);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setType(0);
        setRefPowerDisp(false);
        setReflevel(0);
        setRefPowerVolt(0);
        setRefPowerCurr(1);
        setRefPowerFref(0);
        setRefPctlHigh(this.upaholdHighAttr.getDefIntValue());
        setRefPctMid(this.upaholdMiddleAttr.getDefIntValue());
        setRefPctLow(this.upaholdLowAttr.getDefIntValue());
        setRefAbsHigh(this.upaAbsHighAttr.getDefLongValue());
        setRefAbsMid(this.upaAbsMiddleAttr.getDefLongValue());
        setRefAbsLow(this.upaAbsLowAttr.getDefLongValue());
    }

    public String toString() {
        return super.toString();
    }
}
