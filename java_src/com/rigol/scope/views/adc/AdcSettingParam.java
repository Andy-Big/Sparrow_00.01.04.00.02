package com.rigol.scope.views.adc;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.BaseParam;
import kotlin.Metadata;
/* compiled from: AdcSettingParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\bV\n\u0002\u0010\u0002\n\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010j\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010l\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010m\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010n\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010o\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010p\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010q\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010r\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010s\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\u000e\u0010t\u001a\u00020\u00042\u0006\u0010k\u001a\u00020\u0004J\b\u0010u\u001a\u00020vH\u0016J\u0006\u0010w\u001a\u00020\u0004J\u0006\u0010x\u001a\u00020\u0004J\u0006\u0010y\u001a\u00020\u0004J\u0006\u0010z\u001a\u00020\u0004J\u0006\u0010{\u001a\u00020\u001fJ\u0006\u0010|\u001a\u00020\u001fJ\u0006\u0010}\u001a\u00020\u0004J\u0006\u0010~\u001a\u00020\u0004J\u0006\u0010\u007f\u001a\u00020\u0004J\u0007\u0010\u0080\u0001\u001a\u00020\u0004J\u0007\u0010\u0081\u0001\u001a\u00020\u0004J\u0007\u0010\u0082\u0001\u001a\u00020\u0004J\u0007\u0010\u0083\u0001\u001a\u00020\u0004J\u0007\u0010\u0084\u0001\u001a\u00020\u0004J\u0007\u0010\u0085\u0001\u001a\u00020\u0004J\u0007\u0010\u0086\u0001\u001a\u00020\u0004J\u0010\u0010\u0087\u0001\u001a\u00020v2\u0007\u0010\u0088\u0001\u001a\u00020\u0004J\u0010\u0010\u0089\u0001\u001a\u00020v2\u0007\u0010\u0088\u0001\u001a\u00020\u0004J\u0010\u0010\u008a\u0001\u001a\u00020v2\u0007\u0010\u008b\u0001\u001a\u00020\u0004J\u0010\u0010\u008c\u0001\u001a\u00020v2\u0007\u0010\u008b\u0001\u001a\u00020\u0004J\u0010\u0010\u008d\u0001\u001a\u00020v2\u0007\u0010\u008e\u0001\u001a\u00020\u001fJ\u0010\u0010\u008f\u0001\u001a\u00020v2\u0007\u0010\u008e\u0001\u001a\u00020\u001fJ\u0010\u0010\u0090\u0001\u001a\u00020v2\u0007\u0010\u0091\u0001\u001a\u00020\u0004J\u0010\u0010\u0092\u0001\u001a\u00020v2\u0007\u0010\u0091\u0001\u001a\u00020\u0004J\u0010\u0010\u0093\u0001\u001a\u00020v2\u0007\u0010\u0094\u0001\u001a\u00020\u0004J\u0010\u0010\u0095\u0001\u001a\u00020v2\u0007\u0010\u0094\u0001\u001a\u00020\u0004J\u0010\u0010\u0096\u0001\u001a\u00020v2\u0007\u0010\u0094\u0001\u001a\u00020\u0004J\u0010\u0010\u0097\u0001\u001a\u00020v2\u0007\u0010\u0094\u0001\u001a\u00020\u0004J\u0010\u0010\u0098\u0001\u001a\u00020v2\u0007\u0010\u0094\u0001\u001a\u00020\u0004J\u0010\u0010\u0099\u0001\u001a\u00020v2\u0007\u0010\u0094\u0001\u001a\u00020\u0004J\u0010\u0010\u009a\u0001\u001a\u00020v2\u0007\u0010\u0094\u0001\u001a\u00020\u0004J\u0010\u0010\u009b\u0001\u001a\u00020v2\u0007\u0010\u0094\u0001\u001a\u00020\u0004R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR&\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010%\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R&\u0010(\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R&\u0010+\u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R&\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR&\u00101\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\tR&\u00104\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0007\"\u0004\b6\u0010\tR&\u00107\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR&\u0010:\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR&\u0010=\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR&\u0010@\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0007\"\u0004\bB\u0010\tR&\u0010C\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR&\u0010F\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR&\u0010I\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0007\"\u0004\bK\u0010\tR&\u0010L\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0007\"\u0004\bN\u0010\tR&\u0010O\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR&\u0010R\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0007\"\u0004\bT\u0010\tR&\u0010U\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0007\"\u0004\bW\u0010\tR&\u0010X\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0007\"\u0004\bZ\u0010\tR&\u0010[\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0007\"\u0004\b]\u0010\tR&\u0010^\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0007\"\u0004\b`\u0010\tR&\u0010a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0007\"\u0004\bc\u0010\tR&\u0010d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0007\"\u0004\bf\u0010\tR&\u0010g\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\t¨\u0006\u009c\u0001"}, d2 = {"Lcom/rigol/scope/views/adc/AdcSettingParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "coarse1", "getCoarse1", "()I", "setCoarse1", "(I)V", "coarse2", "getCoarse2", "setCoarse2", "coarse3", "getCoarse3", "setCoarse3", "coarse4", "getCoarse4", "setCoarse4", "fine1", "getFine1", "setFine1", "fine2", "getFine2", "setFine2", "fine3", "getFine3", "setFine3", "fine4", "getFine4", "setFine4", "", "flip1", "getFlip1", "()Z", "setFlip1", "(Z)V", "flip2", "getFlip2", "setFlip2", "flip3", "getFlip3", "setFlip3", "flip4", "getFlip4", "setFlip4", "inter1", "getInter1", "setInter1", "inter2", "getInter2", "setInter2", "inter3", "getInter3", "setInter3", "inter4", "getInter4", "setInter4", "phase1Core1", "getPhase1Core1", "setPhase1Core1", "phase1Core2", "getPhase1Core2", "setPhase1Core2", "phase1Core3", "getPhase1Core3", "setPhase1Core3", "phase1Core4", "getPhase1Core4", "setPhase1Core4", "phase2Core1", "getPhase2Core1", "setPhase2Core1", "phase2Core2", "getPhase2Core2", "setPhase2Core2", "phase2Core3", "getPhase2Core3", "setPhase2Core3", "phase2Core4", "getPhase2Core4", "setPhase2Core4", "phase3Core1", "getPhase3Core1", "setPhase3Core1", "phase3Core2", "getPhase3Core2", "setPhase3Core2", "phase3Core3", "getPhase3Core3", "setPhase3Core3", "phase3Core4", "getPhase3Core4", "setPhase3Core4", "phase4Core1", "getPhase4Core1", "setPhase4Core1", "phase4Core2", "getPhase4Core2", "setPhase4Core2", "phase4Core3", "getPhase4Core3", "setPhase4Core3", "phase4Core4", "getPhase4Core4", "setPhase4Core4", "getCoarseProgress", "progress", "getFineProgress", "getInterProgress", "getProgress1", "getProgress2", "parseCoarseProgress", "parseFineProgress", "parseInterProgress", "parseProgress1", "parseProgress2", "readAll", "", "readCoarse1", "readCoarse2", "readFine1", "readFine2", "readFlip1", "readFlip2", "readInter1", "readInter2", "readPhase1Core1", "readPhase1Core2", "readPhase1Core3", "readPhase1Core4", "readPhase2Core1", "readPhase2Core2", "readPhase2Core3", "readPhase2Core4", "saveCoarse1", "coarse", "saveCoarse2", "saveFine1", "fine", "saveFine2", "saveFlip1", "flip", "saveFlip2", "saveInter1", "inter", "saveInter2", "savePhase1Core1", "phase", "savePhase1Core2", "savePhase1Core3", "savePhase1Core4", "savePhase2Core1", "savePhase2Core2", "savePhase2Core3", "savePhase2Core4", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class AdcSettingParam extends BaseParam {
    private int coarse1;
    private int coarse2;
    private int coarse3;
    private int coarse4;
    private int fine1;
    private int fine2;
    private int fine3;
    private int fine4;
    private boolean flip1;
    private boolean flip2;
    private boolean flip3;
    private boolean flip4;
    private int inter1;
    private int inter2;
    private int inter3;
    private int inter4;
    private int phase1Core1;
    private int phase1Core2;
    private int phase1Core3;
    private int phase1Core4;
    private int phase2Core1;
    private int phase2Core2;
    private int phase2Core3;
    private int phase2Core4;
    private int phase3Core1;
    private int phase3Core2;
    private int phase3Core3;
    private int phase3Core4;
    private int phase4Core1;
    private int phase4Core2;
    private int phase4Core3;
    private int phase4Core4;

    public final int getCoarseProgress(int i) {
        return (int) ((i / 100.0f) * 7);
    }

    public final int getFineProgress(int i) {
        return (int) ((i / 100.0f) * 1023);
    }

    public final int getInterProgress(int i) {
        return (int) ((i / 100.0f) * 15);
    }

    public final int getProgress1(int i) {
        return (int) ((i / 100.0f) * 63);
    }

    public final int getProgress2(int i) {
        return (int) ((i / 100.0f) * 1023);
    }

    public final int parseCoarseProgress(int i) {
        return (int) ((i * 100.0f) / 7);
    }

    public final int parseFineProgress(int i) {
        return (int) ((i * 100.0f) / 1023);
    }

    public final int parseInterProgress(int i) {
        return (int) ((i * 100.0f) / 15);
    }

    public final int parseProgress1(int i) {
        return (int) ((i * 100.0f) / 63);
    }

    public final int parseProgress2(int i) {
        return (int) ((i * 100.0f) / 1023);
    }

    public AdcSettingParam() {
        super(9);
    }

    @Bindable
    public final boolean getFlip1() {
        return this.flip1;
    }

    public final void setFlip1(boolean z) {
        this.flip1 = z;
        notifyPropertyChanged(329);
    }

    @Bindable
    public final boolean getFlip2() {
        return this.flip2;
    }

    public final void setFlip2(boolean z) {
        this.flip2 = z;
        notifyPropertyChanged(330);
    }

    @Bindable
    public final boolean getFlip3() {
        return this.flip3;
    }

    public final void setFlip3(boolean z) {
        this.flip3 = z;
        notifyPropertyChanged(331);
    }

    @Bindable
    public final boolean getFlip4() {
        return this.flip4;
    }

    public final void setFlip4(boolean z) {
        this.flip4 = z;
        notifyPropertyChanged(332);
    }

    @Bindable
    public final int getCoarse1() {
        return this.coarse1;
    }

    public final void setCoarse1(int i) {
        this.coarse1 = i;
        notifyPropertyChanged(181);
    }

    @Bindable
    public final int getCoarse2() {
        return this.coarse2;
    }

    public final void setCoarse2(int i) {
        this.coarse2 = i;
        notifyPropertyChanged(182);
    }

    @Bindable
    public final int getCoarse3() {
        return this.coarse3;
    }

    public final void setCoarse3(int i) {
        this.coarse3 = i;
        notifyPropertyChanged(183);
    }

    @Bindable
    public final int getCoarse4() {
        return this.coarse4;
    }

    public final void setCoarse4(int i) {
        this.coarse4 = i;
        notifyPropertyChanged(184);
    }

    @Bindable
    public final int getInter1() {
        return this.inter1;
    }

    public final void setInter1(int i) {
        this.inter1 = i;
        notifyPropertyChanged(438);
    }

    @Bindable
    public final int getInter2() {
        return this.inter2;
    }

    public final void setInter2(int i) {
        this.inter2 = i;
        notifyPropertyChanged(439);
    }

    @Bindable
    public final int getInter3() {
        return this.inter3;
    }

    public final void setInter3(int i) {
        this.inter3 = i;
        notifyPropertyChanged(440);
    }

    @Bindable
    public final int getInter4() {
        return this.inter4;
    }

    public final void setInter4(int i) {
        this.inter4 = i;
        notifyPropertyChanged(441);
    }

    @Bindable
    public final int getFine1() {
        return this.fine1;
    }

    public final void setFine1(int i) {
        this.fine1 = i;
        notifyPropertyChanged(315);
    }

    @Bindable
    public final int getFine2() {
        return this.fine2;
    }

    public final void setFine2(int i) {
        this.fine2 = i;
        notifyPropertyChanged(316);
    }

    @Bindable
    public final int getFine3() {
        return this.fine3;
    }

    public final void setFine3(int i) {
        this.fine3 = i;
        notifyPropertyChanged(317);
    }

    @Bindable
    public final int getFine4() {
        return this.fine4;
    }

    public final void setFine4(int i) {
        this.fine4 = i;
        notifyPropertyChanged(318);
    }

    @Bindable
    public final int getPhase1Core1() {
        return this.phase1Core1;
    }

    public final void setPhase1Core1(int i) {
        this.phase1Core1 = i;
        notifyPropertyChanged(622);
    }

    @Bindable
    public final int getPhase1Core2() {
        return this.phase1Core2;
    }

    public final void setPhase1Core2(int i) {
        this.phase1Core2 = i;
        notifyPropertyChanged(623);
    }

    @Bindable
    public final int getPhase1Core3() {
        return this.phase1Core3;
    }

    public final void setPhase1Core3(int i) {
        this.phase1Core3 = i;
        notifyPropertyChanged(624);
    }

    @Bindable
    public final int getPhase1Core4() {
        return this.phase1Core4;
    }

    public final void setPhase1Core4(int i) {
        this.phase1Core4 = i;
        notifyPropertyChanged(625);
    }

    @Bindable
    public final int getPhase2Core1() {
        return this.phase2Core1;
    }

    public final void setPhase2Core1(int i) {
        this.phase2Core1 = i;
        notifyPropertyChanged(626);
    }

    @Bindable
    public final int getPhase2Core2() {
        return this.phase2Core2;
    }

    public final void setPhase2Core2(int i) {
        this.phase2Core2 = i;
        notifyPropertyChanged(627);
    }

    @Bindable
    public final int getPhase2Core3() {
        return this.phase2Core3;
    }

    public final void setPhase2Core3(int i) {
        this.phase2Core3 = i;
        notifyPropertyChanged(628);
    }

    @Bindable
    public final int getPhase2Core4() {
        return this.phase2Core4;
    }

    public final void setPhase2Core4(int i) {
        this.phase2Core4 = i;
        notifyPropertyChanged(629);
    }

    @Bindable
    public final int getPhase3Core1() {
        return this.phase3Core1;
    }

    public final void setPhase3Core1(int i) {
        this.phase3Core1 = i;
        notifyPropertyChanged(630);
    }

    @Bindable
    public final int getPhase3Core2() {
        return this.phase3Core2;
    }

    public final void setPhase3Core2(int i) {
        this.phase3Core2 = i;
        notifyPropertyChanged(631);
    }

    @Bindable
    public final int getPhase3Core3() {
        return this.phase3Core3;
    }

    public final void setPhase3Core3(int i) {
        this.phase3Core3 = i;
        notifyPropertyChanged(632);
    }

    @Bindable
    public final int getPhase3Core4() {
        return this.phase3Core4;
    }

    public final void setPhase3Core4(int i) {
        this.phase3Core4 = i;
        notifyPropertyChanged(633);
    }

    @Bindable
    public final int getPhase4Core1() {
        return this.phase4Core1;
    }

    public final void setPhase4Core1(int i) {
        this.phase4Core1 = i;
        notifyPropertyChanged(634);
    }

    @Bindable
    public final int getPhase4Core2() {
        return this.phase4Core2;
    }

    public final void setPhase4Core2(int i) {
        this.phase4Core2 = i;
        notifyPropertyChanged(635);
    }

    @Bindable
    public final int getPhase4Core3() {
        return this.phase4Core3;
    }

    public final void setPhase4Core3(int i) {
        this.phase4Core3 = i;
        notifyPropertyChanged(636);
    }

    @Bindable
    public final int getPhase4Core4() {
        return this.phase4Core4;
    }

    public final void setPhase4Core4(int i) {
        this.phase4Core4 = i;
        notifyPropertyChanged(637);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readFlip1();
        readFlip2();
        readFine1();
        readFine2();
        readCoarse1();
        readCoarse2();
        readInter1();
        readInter2();
        readPhase1Core1();
        readPhase1Core2();
        readPhase1Core3();
        readPhase1Core4();
        readPhase2Core1();
        readPhase2Core2();
        readPhase2Core3();
        readPhase2Core4();
    }

    public final boolean readFlip1() {
        setFlip1(readBool(MessageID.MSG_DEBUG_ADC1_CLK_FLIP));
        return this.flip1;
    }

    public final boolean readFlip2() {
        setFlip2(readBool(MessageID.MSG_CAL_ADC2_CLK_FLIP));
        return this.flip2;
    }

    public final int readCoarse1() {
        setCoarse1(readInt(MessageID.MSG_DEBUG_ADC1_PHASE_COA));
        return this.coarse1;
    }

    public final int readCoarse2() {
        setCoarse2(readInt(MessageID.MSG_CAL_ADC2_PHASE_COA));
        return this.coarse2;
    }

    public final int readInter1() {
        setInter1(readInt(MessageID.MSG_DEBUG_ADC1_PHASE_INT));
        return this.inter1;
    }

    public final int readInter2() {
        setInter2(readInt(MessageID.MSG_CAL_ADC2_PHASE_INT));
        return this.inter2;
    }

    public final int readFine1() {
        setFine1(readInt(MessageID.MSG_DEBUG_ADC1_PHASE_FIN));
        return this.fine1;
    }

    public final int readFine2() {
        setFine2(readInt(MessageID.MSG_CAL_ADC2_PHASE_FIN));
        return this.fine2;
    }

    public final int readPhase1Core1() {
        setPhase1Core1(readInt(MessageID.MSG_DEBUG_ADC1_CORE1_PHASE));
        return this.phase1Core1;
    }

    public final int readPhase1Core2() {
        setPhase1Core2(readInt(MessageID.MSG_DEBUG_ADC1_CORE2_PHASE));
        return this.phase1Core2;
    }

    public final int readPhase1Core3() {
        setPhase1Core3(readInt(MessageID.MSG_DEBUG_ADC1_CORE3_PHASE));
        return this.phase1Core3;
    }

    public final int readPhase1Core4() {
        setPhase1Core4(readInt(MessageID.MSG_DEBUG_ADC1_CORE4_PHASE));
        return this.phase1Core4;
    }

    public final int readPhase2Core1() {
        setPhase2Core1(readInt(MessageID.MSG_CAL_ADC2_CORE1_PHASE));
        return this.phase2Core1;
    }

    public final int readPhase2Core2() {
        setPhase2Core2(readInt(MessageID.MSG_CAL_ADC2_CORE2_PHASE));
        return this.phase2Core2;
    }

    public final int readPhase2Core3() {
        setPhase2Core3(readInt(MessageID.MSG_CAL_ADC2_CORE3_PHASE));
        return this.phase2Core3;
    }

    public final int readPhase2Core4() {
        setPhase2Core4(readInt(MessageID.MSG_CAL_ADC2_CORE4_PHASE));
        return this.phase2Core4;
    }

    public final void saveFlip1(boolean z) {
        setFlip1(z);
        saveInt(MessageID.MSG_DEBUG_ADC1_CLK_FLIP, z);
    }

    public final void saveFlip2(boolean z) {
        setFlip2(z);
        saveInt(MessageID.MSG_CAL_ADC2_CLK_FLIP, z);
    }

    public final void saveCoarse1(int i) {
        setCoarse1(i);
        saveInt(MessageID.MSG_DEBUG_ADC1_PHASE_COA, i);
    }

    public final void saveCoarse2(int i) {
        setCoarse2(i);
        saveInt(MessageID.MSG_CAL_ADC2_PHASE_COA, i);
    }

    public final void saveInter1(int i) {
        setInter1(i);
        saveInt(MessageID.MSG_DEBUG_ADC1_PHASE_INT, i);
    }

    public final void saveInter2(int i) {
        setInter2(i);
        saveInt(MessageID.MSG_CAL_ADC2_PHASE_INT, i);
    }

    public final void saveFine1(int i) {
        setFine1(i);
        saveInt(MessageID.MSG_DEBUG_ADC1_PHASE_FIN, i);
    }

    public final void saveFine2(int i) {
        setFine2(i);
        saveInt(MessageID.MSG_CAL_ADC2_PHASE_FIN, i);
    }

    public final void savePhase1Core1(int i) {
        setPhase1Core1(i);
        saveInt(MessageID.MSG_DEBUG_ADC1_CORE1_PHASE, i);
    }

    public final void savePhase1Core2(int i) {
        setPhase1Core2(i);
        saveInt(MessageID.MSG_DEBUG_ADC1_CORE2_PHASE, i);
    }

    public final void savePhase1Core3(int i) {
        setPhase1Core3(i);
        saveInt(MessageID.MSG_DEBUG_ADC1_CORE3_PHASE, i);
    }

    public final void savePhase1Core4(int i) {
        setPhase1Core4(i);
        saveInt(MessageID.MSG_DEBUG_ADC1_CORE4_PHASE, i);
    }

    public final void savePhase2Core1(int i) {
        setPhase2Core1(i);
        saveInt(MessageID.MSG_CAL_ADC2_CORE1_PHASE, i);
    }

    public final void savePhase2Core2(int i) {
        setPhase2Core2(i);
        saveInt(MessageID.MSG_CAL_ADC2_CORE2_PHASE, i);
    }

    public final void savePhase2Core3(int i) {
        setPhase2Core3(i);
        saveInt(MessageID.MSG_CAL_ADC2_CORE3_PHASE, i);
    }

    public final void savePhase2Core4(int i) {
        setPhase2Core4(i);
        saveInt(MessageID.MSG_CAL_ADC2_CORE4_PHASE, i);
    }
}
