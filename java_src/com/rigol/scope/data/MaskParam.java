package com.rigol.scope.data;

import android.view.KeyEvent;
import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MaskParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b-\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010[\u001a\u00020\\H\u0016J\u0006\u0010]\u001a\u00020\\J\u0006\u0010^\u001a\u00020\\J\u0006\u0010_\u001a\u00020\\J\u0006\u0010`\u001a\u00020\\J\u0006\u0010a\u001a\u00020\\J\u0006\u0010b\u001a\u00020\\J\u0006\u0010c\u001a\u00020\\J\u0006\u0010d\u001a\u00020\\J\u0006\u0010e\u001a\u00020\\J\u0006\u0010f\u001a\u00020\\J\u0006\u0010g\u001a\u00020\\J\u0006\u0010h\u001a\u00020\\J\u0006\u0010i\u001a\u00020\\J\u0006\u0010j\u001a\u00020\\J\u0006\u0010k\u001a\u00020\\J\u0006\u0010l\u001a\u00020\\J\u0006\u0010m\u001a\u00020\\J\u0006\u0010n\u001a\u00020\\J\u0006\u0010o\u001a\u00020\\J\b\u0010p\u001a\u00020\\H\u0016J\u0006\u0010q\u001a\u00020\\J\u0006\u0010r\u001a\u00020\\J\u000e\u0010s\u001a\u00020\\2\u0006\u0010\u001f\u001a\u00020\u0019J\u000e\u0010t\u001a\u00020\\2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010u\u001a\u00020\\2\u0006\u0010\u0010\u001a\u00020\nJ\u000e\u0010v\u001a\u00020\\2\u0006\u0010\u0013\u001a\u00020\nJ\u000e\u0010w\u001a\u00020\\2\u0006\u0010!\u001a\u00020\u0019J\u000e\u0010x\u001a\u00020\\2\u0006\u0010\u0016\u001a\u00020\nJ\u000e\u0010y\u001a\u00020\\2\u0006\u0010z\u001a\u00020\u0019J\u000e\u0010{\u001a\u00020\\2\u0006\u0010#\u001a\u00020\u0019J\u000e\u0010|\u001a\u00020\\2\u0006\u0010+\u001a\u00020*J\u000e\u0010}\u001a\u00020\\2\u0006\u00101\u001a\u000200J\u000e\u0010~\u001a\u00020\\2\u0006\u00107\u001a\u000206J\u000e\u0010\u007f\u001a\u00020\\2\u0006\u0010C\u001a\u00020BJ\u0007\u0010\u0080\u0001\u001a\u00020\\J\u000f\u0010\u0081\u0001\u001a\u00020\\2\u0006\u0010%\u001a\u00020\u0019J\u000f\u0010\u0082\u0001\u001a\u00020\\2\u0006\u0010H\u001a\u00020\nJ\u000f\u0010\u0083\u0001\u001a\u00020\\2\u0006\u0010M\u001a\u00020\nJ\u000f\u0010\u0084\u0001\u001a\u00020\\2\u0006\u0010U\u001a\u00020\nJ\u0010\u0010\u0085\u0001\u001a\u00020\\2\u0007\u0010\u0086\u0001\u001a\u00020\u0019J\u0010\u0010\u0087\u0001\u001a\u00020\n2\u0007\u0010\u0088\u0001\u001a\u00020\nJ\n\u0010\u0089\u0001\u001a\u00030\u008a\u0001H\u0016J\u001a\u0010\u008b\u0001\u001a\u00020\\2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0019J\u001a\u0010\u008f\u0001\u001a\u00020\\2\b\u0010\u008c\u0001\u001a\u00030\u008d\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0019R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR&\u0010\u0013\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR&\u0010\u0016\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR&\u0010\u001a\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u001f\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR&\u0010!\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR&\u0010#\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR&\u0010%\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR&\u0010'\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR&\u0010+\u001a\u00020*2\u0006\u0010\t\u001a\u00020*8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R&\u00101\u001a\u0002002\u0006\u0010\t\u001a\u0002008G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R&\u00107\u001a\u0002062\u0006\u0010\t\u001a\u0002068G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001a\u0010<\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR&\u0010C\u001a\u00020B2\u0006\u0010\t\u001a\u00020B8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR&\u0010H\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\r\"\u0004\bJ\u0010\u000fR\u0014\u0010K\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\rR&\u0010M\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\r\"\u0004\bO\u0010\u000fR\u001a\u0010P\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010?\"\u0004\bR\u0010AR\u0014\u0010S\u001a\u00020\nX\u0086D¢\u0006\b\n\u0000\u001a\u0004\bT\u0010\rR&\u0010U\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\r\"\u0004\bW\u0010\u000fR\u001a\u0010X\u001a\u00020=X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010?\"\u0004\bZ\u0010A¨\u0006\u0090\u0001"}, d2 = {"Lcom/rigol/scope/data/MaskParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "aorBManager", "Lcom/rigol/scope/utilities/AorBManager;", "getAorBManager", "()Lcom/rigol/scope/utilities/AorBManager;", "setAorBManager", "(Lcom/rigol/scope/utilities/AorBManager;)V", "value", "", "cursorA", "getCursorA", "()I", "setCursorA", "(I)V", "cursorAB", "getCursorAB", "setCursorAB", "cursorB", "getCursorB", "setCursorB", "errAction", "getErrAction", "setErrAction", "", "forceStop", "getForceStop", "()Z", "setForceStop", "(Z)V", "isAuxOut", "setAuxOut", "isEnable", "setEnable", "isOperate", "setOperate", "isShowStat", "setShowStat", "minPop", "getMinPop", "setMinPop", "Lcom/rigol/scope/cil/ServiceEnum$MaskActionEvent;", "outEvent", "getOutEvent", "()Lcom/rigol/scope/cil/ServiceEnum$MaskActionEvent;", "setOutEvent", "(Lcom/rigol/scope/cil/ServiceEnum$MaskActionEvent;)V", "Lcom/rigol/scope/cil/ServiceEnum$MaskPolarity;", "outHl", "getOutHl", "()Lcom/rigol/scope/cil/ServiceEnum$MaskPolarity;", "setOutHl", "(Lcom/rigol/scope/cil/ServiceEnum$MaskPolarity;)V", "", "outPulse", "getOutPulse", "()J", "setOutPulse", "(J)V", "outPulseAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getOutPulseAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "setOutPulseAttr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "Lcom/rigol/scope/cil/ServiceEnum$MaskRange;", "range", "getRange", "()Lcom/rigol/scope/cil/ServiceEnum$MaskRange;", "setRange", "(Lcom/rigol/scope/cil/ServiceEnum$MaskRange;)V", "source", "getSource", "setSource", "xRatio", "getXRatio", "xValue", "getXValue", "setXValue", "xValueAttr", "getXValueAttr", "setXValueAttr", "yRatio", "getYRatio", "yValue", "getYValue", "setYValue", "yValueAttr", "getYValueAttr", "setYValueAttr", "readAll", "", "readAuxOut", "readCursorA", "readCursorAB", "readCursorB", "readEnable", "readErrAction", "readForceStop", "readOperate", "readOutEvent", "readOutHl", "readOutPulse", "readOutPulseAttr", "readRang", "readShowStat", "readSource", "readXMask", "readXValueAttr", "readYMask", "readYValueAttr", "reset", "resetXMask", "resetYMask", "saveAuxOut", "saveCursorA", "saveCursorAB", "saveCursorB", "saveEnable", "saveErrAction", "saveForceStop", "isStop", "saveOperate", "saveOutEvent", "saveOutHl", "saveOutPulse", "saveRang", "saveResetStat", "saveShowStat", "saveSource", "saveXMask", "saveYMask", "setMinPop1", "isMin", "superRepeat", "repeat", "toString", "", "updateXMask", "keyEvent", "Landroid/view/KeyEvent;", "isRoll", "updateYMask", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MaskParam extends BaseParam {
    public AorBManager aorBManager;
    private int cursorA;
    private int cursorAB;
    private int cursorB;
    private int errAction;
    private boolean forceStop;
    private boolean isAuxOut;
    private boolean isEnable;
    private boolean isOperate;
    private boolean isShowStat;
    private boolean minPop;
    private ServiceEnum.MaskActionEvent outEvent;
    private ServiceEnum.MaskPolarity outHl;
    private long outPulse;
    private MessageAttr outPulseAttr;
    private ServiceEnum.MaskRange range;
    private int source;
    private final int xRatio;
    private int xValue;
    private MessageAttr xValueAttr;
    private final int yRatio;
    private int yValue;
    private MessageAttr yValueAttr;

    public MaskParam() {
        super(46);
        int i;
        ServiceEnum.MaskRange maskRange;
        float f;
        ServiceEnum.MaskActionEvent maskActionEvent;
        ServiceEnum.MaskPolarity maskPolarity;
        i = MaskParamKt.DEFAULT_SOURCE;
        this.source = i;
        maskRange = MaskParamKt.DEFAULT_RANGE;
        this.range = maskRange;
        this.yValue = 480;
        this.yRatio = 2;
        this.xValue = 240;
        this.xRatio = 10;
        f = MaskParamKt.DEFAULT_OUTPULSE;
        this.outPulse = f;
        maskActionEvent = MaskParamKt.DEFAULT_OUTEVENT;
        this.outEvent = maskActionEvent;
        maskPolarity = MaskParamKt.DEFAULT_OUTHL;
        this.outHl = maskPolarity;
        this.errAction = 1;
        this.yValueAttr = new MessageAttr();
        this.xValueAttr = new MessageAttr();
        this.outPulseAttr = new MessageAttr();
    }

    public final AorBManager getAorBManager() {
        AorBManager aorBManager = this.aorBManager;
        if (aorBManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aorBManager");
        }
        return aorBManager;
    }

    public final void setAorBManager(AorBManager aorBManager) {
        Intrinsics.checkNotNullParameter(aorBManager, "<set-?>");
        this.aorBManager = aorBManager;
    }

    @Bindable
    public final boolean getMinPop() {
        return this.minPop;
    }

    public final void setMinPop(boolean z) {
        log("isEnable", Boolean.valueOf(this.minPop), Boolean.valueOf(z));
        this.minPop = z;
        notifyPropertyChanged(541);
    }

    @Bindable
    public final boolean isEnable() {
        return this.isEnable;
    }

    public final void setEnable(boolean z) {
        log("isEnable", Boolean.valueOf(this.isEnable), Boolean.valueOf(z));
        this.isEnable = z;
        notifyPropertyChanged(271);
    }

    @Bindable
    public final boolean isShowStat() {
        return this.isShowStat;
    }

    public final void setShowStat(boolean z) {
        log("isShowStat", Boolean.valueOf(this.isShowStat), Boolean.valueOf(z));
        this.isShowStat = z;
        notifyPropertyChanged(839);
    }

    @Bindable
    public final boolean isAuxOut() {
        return this.isAuxOut;
    }

    public final void setAuxOut(boolean z) {
        log("isAuxOut", Boolean.valueOf(this.isAuxOut), Boolean.valueOf(z));
        this.isAuxOut = z;
        notifyPropertyChanged(63);
    }

    @Bindable
    public final boolean isOperate() {
        return this.isOperate;
    }

    public final void setOperate(boolean z) {
        log("isOperate", Boolean.valueOf(this.isOperate), Boolean.valueOf(z));
        this.isOperate = z;
        notifyPropertyChanged(572);
    }

    @Bindable
    public final boolean getForceStop() {
        return this.forceStop;
    }

    public final void setForceStop(boolean z) {
        log("forceStop", Boolean.valueOf(this.forceStop), Boolean.valueOf(z));
        this.forceStop = z;
        notifyPropertyChanged(333);
    }

    @Bindable
    public final int getSource() {
        return this.source;
    }

    public final void setSource(int i) {
        log("source", Integer.valueOf(this.source), Integer.valueOf(i));
        this.source = i;
        notifyPropertyChanged(858);
    }

    @Bindable
    public final ServiceEnum.MaskRange getRange() {
        return this.range;
    }

    public final void setRange(ServiceEnum.MaskRange value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("range", this.range, value);
        this.range = value;
        notifyPropertyChanged(685);
    }

    @Bindable
    public final int getCursorA() {
        return this.cursorA;
    }

    public final void setCursorA(int i) {
        log("cursorA", Integer.valueOf(this.cursorA), Integer.valueOf(i));
        this.cursorA = i;
        notifyPropertyChanged(199);
    }

    @Bindable
    public final int getCursorB() {
        return this.cursorB;
    }

    public final void setCursorB(int i) {
        log("cursorB", Integer.valueOf(this.cursorB), Integer.valueOf(i));
        this.cursorB = i;
        notifyPropertyChanged(201);
    }

    @Bindable
    public final int getCursorAB() {
        return this.cursorAB;
    }

    public final void setCursorAB(int i) {
        log("cursorAB", Integer.valueOf(this.cursorAB), Integer.valueOf(i));
        this.cursorAB = i;
        notifyPropertyChanged(200);
    }

    @Bindable
    public final int getYValue() {
        return this.yValue;
    }

    public final void setYValue(int i) {
        log("yValue", Integer.valueOf(this.yValue), Integer.valueOf(i));
        this.yValue = i;
        notifyPropertyChanged(1086);
    }

    public final int getYRatio() {
        return this.yRatio;
    }

    @Bindable
    public final int getXValue() {
        return this.xValue;
    }

    public final void setXValue(int i) {
        log("xValue", Integer.valueOf(this.xValue), Integer.valueOf(i));
        this.xValue = i;
        notifyPropertyChanged(1080);
    }

    public final int getXRatio() {
        return this.xRatio;
    }

    @Bindable
    public final long getOutPulse() {
        return this.outPulse;
    }

    public final void setOutPulse(long j) {
        log("outPulse", Long.valueOf(this.outPulse), Long.valueOf(j));
        this.outPulse = j;
        notifyPropertyChanged(577);
    }

    @Bindable
    public final ServiceEnum.MaskActionEvent getOutEvent() {
        return this.outEvent;
    }

    public final void setOutEvent(ServiceEnum.MaskActionEvent value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("outEvent", this.outEvent, value);
        this.outEvent = value;
        notifyPropertyChanged(575);
    }

    @Bindable
    public final ServiceEnum.MaskPolarity getOutHl() {
        return this.outHl;
    }

    public final void setOutHl(ServiceEnum.MaskPolarity value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("outHl", this.outHl, value);
        this.outHl = value;
        notifyPropertyChanged(576);
    }

    @Bindable
    public final int getErrAction() {
        return this.errAction;
    }

    public final void setErrAction(int i) {
        log("errAction", Integer.valueOf(this.errAction), Integer.valueOf(i));
        this.errAction = i;
        notifyPropertyChanged(277);
    }

    public final MessageAttr getYValueAttr() {
        return this.yValueAttr;
    }

    public final void setYValueAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.yValueAttr = messageAttr;
    }

    public final MessageAttr getXValueAttr() {
        return this.xValueAttr;
    }

    public final void setXValueAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.xValueAttr = messageAttr;
    }

    public final MessageAttr getOutPulseAttr() {
        return this.outPulseAttr;
    }

    public final void setOutPulseAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.outPulseAttr = messageAttr;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readEnable();
        readShowStat();
        readAuxOut();
        readOperate();
        readSource();
        readRang();
        readCursorA();
        readCursorB();
        readCursorAB();
        readYMask();
        readXMask();
        readOutPulse();
        readOutEvent();
        readOutHl();
        readErrAction();
        readYValueAttr();
        readXValueAttr();
        readOutPulseAttr();
        setForceStop(false);
    }

    public final int superRepeat(int i) {
        return Math.abs(i) > 1 ? i * 4 : i;
    }

    public final void setMinPop1(boolean z) {
        setMinPop(z);
    }

    public final void readEnable() {
        setEnable(readBool(MessageID.MSG_MASK_ENABLE));
    }

    public final void readShowStat() {
        setShowStat(readBool(MessageID.MSG_MASK_SHOW_STAT));
    }

    public final void readAuxOut() {
        setAuxOut(readBool(MessageID.MSG_MASK_OUT_ONOFF));
    }

    public final void readOperate() {
        setOperate(readBool(MessageID.MSG_MASK_OPERATE));
    }

    public final void readSource() {
        setSource(readInt(MessageID.MSG_MASK_SOURCE));
    }

    public final void readRang() {
        ServiceEnum.MaskRange maskRangeFromValue1 = ServiceEnum.getMaskRangeFromValue1(readInt(MessageID.MSG_MASK_RANGE));
        Intrinsics.checkNotNullExpressionValue(maskRangeFromValue1, "ServiceEnum.getMaskRange…essageID.MSG_MASK_RANGE))");
        setRange(maskRangeFromValue1);
    }

    public final void readCursorA() {
        setCursorA(readInt(MessageID.MSG_MASK_RANGE_A));
    }

    public final void readCursorB() {
        setCursorB(readInt(MessageID.MSG_MASK_RANGE_B));
    }

    public final void readCursorAB() {
        setCursorAB(readInt(MessageID.MSG_MASK_RANGE_AB));
    }

    public final void readYMask() {
        setYValue(readInt(MessageID.MSG_MASK_Y_MASK) * this.yRatio);
    }

    public final void readXMask() {
        setXValue(readInt(MessageID.MSG_MASK_X_MASK) * this.xRatio);
    }

    public final void readOutPulse() {
        setOutPulse(readLong(MessageID.MSG_MASK_OUT_PULSE));
    }

    public final void readOutEvent() {
        ServiceEnum.MaskActionEvent maskActionEventFromValue1 = ServiceEnum.getMaskActionEventFromValue1(readInt(MessageID.MSG_MASK_OUT_EVENT));
        Intrinsics.checkNotNullExpressionValue(maskActionEventFromValue1, "ServiceEnum.getMaskActio…geID.MSG_MASK_OUT_EVENT))");
        setOutEvent(maskActionEventFromValue1);
    }

    public final void readOutHl() {
        ServiceEnum.MaskPolarity maskPolarityFromValue1 = ServiceEnum.getMaskPolarityFromValue1(readInt(MessageID.MSG_MASK_OUT_HL));
        Intrinsics.checkNotNullExpressionValue(maskPolarityFromValue1, "ServiceEnum.getMaskPolar…ssageID.MSG_MASK_OUT_HL))");
        setOutHl(maskPolarityFromValue1);
    }

    public final void readYValueAttr() {
        readAttr(MessageID.MSG_MASK_Y_MASK, this.yValueAttr);
    }

    public final void readXValueAttr() {
        readAttr(MessageID.MSG_MASK_X_MASK, this.xValueAttr);
    }

    public final void readOutPulseAttr() {
        readAttr(MessageID.MSG_MASK_OUT_PULSE, this.outPulseAttr);
    }

    public final void readErrAction() {
        setErrAction(readInt(MessageID.MSG_MASK_ERR_ACTION));
    }

    public final void readForceStop() {
        setForceStop(readBool(MessageID.MSG_MASK_FORCESTOP));
    }

    public final void saveEnable(boolean z) {
        setEnable(z);
        saveBool(MessageID.MSG_MASK_ENABLE, z);
    }

    public final void saveShowStat(boolean z) {
        setShowStat(z);
        saveBool(MessageID.MSG_MASK_SHOW_STAT, z);
    }

    public final void saveAuxOut(boolean z) {
        setAuxOut(z);
        saveBool(MessageID.MSG_MASK_OUT_ONOFF, z);
    }

    public final void saveOperate(boolean z) {
        setOperate(z);
        saveBool(MessageID.MSG_MASK_OPERATE, z);
    }

    public final void saveForceStop(boolean z) {
        setForceStop(z);
        saveBool(MessageID.MSG_MASK_FORCESTOP, this.forceStop);
    }

    public final void saveSource(int i) {
        setSource(i);
        saveInt(MessageID.MSG_MASK_SOURCE, i);
    }

    public final void saveRang(ServiceEnum.MaskRange range) {
        Intrinsics.checkNotNullParameter(range, "range");
        setRange(range);
        saveInt(MessageID.MSG_MASK_RANGE, range.value1);
    }

    public final void saveCursorA(int i) {
        setCursorA(i);
        saveInt(MessageID.MSG_MASK_RANGE_A, i);
    }

    public final void saveCursorB(int i) {
        setCursorB(i);
        saveInt(MessageID.MSG_MASK_RANGE_B, i);
    }

    public final void saveCursorAB(int i) {
        setCursorAB(i);
        saveInt(MessageID.MSG_MASK_RANGE_AB, i);
    }

    public final void saveYMask(int i) {
        if (i > this.yValueAttr.getMaxIntValue() * this.yRatio) {
            setYValue(this.yValueAttr.getMaxIntValue() * this.yRatio);
        } else {
            int minIntValue = this.yValueAttr.getMinIntValue();
            int i2 = this.yRatio;
            if (i < minIntValue * i2) {
                setYValue(this.yValueAttr.getMinIntValue() * this.yRatio);
            } else {
                setYValue((i / i2) * i2);
            }
        }
        saveInt(MessageID.MSG_MASK_Y_MASK, this.yValue / this.yRatio);
    }

    public final void saveXMask(int i) {
        if (i > this.xValueAttr.getMaxIntValue() * this.xRatio) {
            setXValue(this.xValueAttr.getMaxIntValue() * this.xRatio);
        } else {
            int minIntValue = this.xValueAttr.getMinIntValue();
            int i2 = this.xRatio;
            if (i < minIntValue * i2) {
                setXValue(this.xValueAttr.getMinIntValue() * this.xRatio);
            } else {
                setXValue((i / i2) * i2);
            }
        }
        saveInt(MessageID.MSG_MASK_X_MASK, this.xValue / this.xRatio);
    }

    public final void saveOutPulse(long j) {
        setOutPulse(j);
        saveLong(MessageID.MSG_MASK_OUT_PULSE, j);
    }

    public final void saveOutEvent(ServiceEnum.MaskActionEvent outEvent) {
        Intrinsics.checkNotNullParameter(outEvent, "outEvent");
        setOutEvent(outEvent);
        saveInt(MessageID.MSG_MASK_OUT_EVENT, outEvent.value1);
    }

    public final void saveOutHl(ServiceEnum.MaskPolarity outHl) {
        Intrinsics.checkNotNullParameter(outHl, "outHl");
        setOutHl(outHl);
        saveInt(MessageID.MSG_MASK_OUT_HL, outHl.value1);
    }

    public final void saveErrAction(int i) {
        setErrAction(i);
        saveInt(MessageID.MSG_MASK_ERR_ACTION, i);
    }

    public final void saveResetStat() {
        saveInt(MessageID.MSG_MASK_RESET_STAT, 0);
    }

    public final void updateYMask(KeyEvent keyEvent, boolean z) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        if (z) {
            saveYMask(this.yValue + (superRepeat(keyEvent.getRepeatCount()) * this.yRatio * ((int) this.yValueAttr.getStepValue())));
        } else {
            saveYMask(this.yValue - ((superRepeat(keyEvent.getRepeatCount()) * this.yRatio) * ((int) this.yValueAttr.getStepValue())));
        }
    }

    public final void updateXMask(KeyEvent keyEvent, boolean z) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        if (z) {
            saveXMask(this.xValue + (superRepeat(keyEvent.getRepeatCount()) * this.xRatio));
        } else {
            saveXMask(this.xValue - (superRepeat(keyEvent.getRepeatCount()) * this.xRatio));
        }
    }

    public final void resetYMask() {
        MessageAttr messageAttr = new MessageAttr();
        messageAttr.setMinValue(this.yValueAttr.getMinIntValue() * this.yRatio);
        messageAttr.setMaxValue(this.yValueAttr.getMaxIntValue() * this.yRatio);
        messageAttr.setDefValue(this.yValueAttr.getDefIntValue() * this.yRatio);
        messageAttr.setStepValue(this.yValueAttr.getStepValue());
        saveYMask(getIntDef(messageAttr));
    }

    public final void resetXMask() {
        MessageAttr messageAttr = new MessageAttr();
        messageAttr.setMinValue(this.xValueAttr.getMinIntValue() * this.xRatio);
        messageAttr.setMaxValue(this.xValueAttr.getMaxIntValue() * this.xRatio);
        messageAttr.setDefValue(this.xValueAttr.getDefIntValue() * this.xRatio);
        messageAttr.setStepValue(this.xValueAttr.getStepValue());
        saveXMask(getIntDef(messageAttr));
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        int i;
        ServiceEnum.MaskRange maskRange;
        float f;
        ServiceEnum.MaskActionEvent maskActionEvent;
        ServiceEnum.MaskPolarity maskPolarity;
        super.reset();
        setEnable(false);
        setShowStat(false);
        setAuxOut(false);
        setOperate(false);
        i = MaskParamKt.DEFAULT_SOURCE;
        setSource(i);
        maskRange = MaskParamKt.DEFAULT_RANGE;
        setRange(maskRange);
        setYValue(480);
        setXValue(240);
        f = MaskParamKt.DEFAULT_OUTPULSE;
        setOutPulse(f);
        maskActionEvent = MaskParamKt.DEFAULT_OUTEVENT;
        setOutEvent(maskActionEvent);
        maskPolarity = MaskParamKt.DEFAULT_OUTHL;
        setOutHl(maskPolarity);
        setErrAction(1);
    }

    public String toString() {
        return "MaskParam{maskEnable=" + this.isEnable + ", maskShowStat=" + this.isShowStat + ", maskAuxOut=" + this.isAuxOut + ", maskSource=" + this.source + ", maskRange=" + this.range + ", maskCursorA=" + this.cursorA + ", maskCursorB=" + this.cursorB + ", maskCursorAB=" + this.cursorAB + ", maskYMaskValue=" + this.yValue + ", maskXMaskValue=" + this.xValue + ", maskOutPulse=" + this.outPulse + ", maskOutEvent=" + this.outEvent + ", maskOutHl=" + this.outHl + '}';
    }
}
