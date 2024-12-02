package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.utilities.KtUtilKt;
import kotlin.Metadata;

/* compiled from: CalibrationParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#J\b\u0010%\u001a\u00020#H\u0016J\b\u0010&\u001a\u0004\u0018\u00010\u0004J\b\u0010'\u001a\u0004\u0018\u00010\u0004J\u0006\u0010(\u001a\u00020\u0013J\u0006\u0010)\u001a\u00020\u0013J\b\u0010*\u001a\u0004\u0018\u00010\u0004J\u000e\u0010+\u001a\u00020#2\u0006\u0010,\u001a\u00020\u0013J\u0006\u0010-\u001a\u00020#J\b\u0010.\u001a\u00020\u0004H\u0016R*\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0019\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR&\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R*\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006/"}, d2 = {"Lcom/rigol/scope/data/CalibrationParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "detail", "getDetail", "()Ljava/lang/String;", "setDetail", "(Ljava/lang/String;)V", "showDetail", "", "isShowDetail", "()Z", "setShowDetail", "(Z)V", "started", "isStarted", "setStarted", "", "itemBits", "getItemBits", "()I", "setItemBits", "(I)V", "lastDate", "getLastDate", "setLastDate", "progressNow", "getProgressNow", "setProgressNow", "result", "getResult", "setResult", "postQuit", "", "postStart", "readAll", "readDate", "readDetail", "readItemBits", "readProgressNow", "readResult", "saveItems", "items", "start", "toString", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class CalibrationParam extends BaseParam {
    private String detail;
    private boolean isShowDetail;
    private boolean isStarted;
    @Bindable
    private int itemBits;
    private String lastDate;
    @Bindable
    private int progressNow;
    private String result;

    public CalibrationParam() {
        super(9);
        this.result = "Calibrating";
    }

    @Bindable
    public final String getDetail() {
        return this.detail;
    }

    public final void setDetail(String str) {
        this.detail = str;
        notifyPropertyChanged(240);
    }

    @Bindable
    public final String getResult() {
        return this.result;
    }

    public final void setResult(String str) {
        this.result = str;
        notifyPropertyChanged(739);
    }

    @Bindable
    public final String getLastDate() {
        return this.lastDate;
    }

    public final void setLastDate(String str) {
        this.lastDate = str;
        notifyPropertyChanged(479);
    }

    public final int getProgressNow() {
        return this.progressNow;
    }

    public final void setProgressNow(int i) {
        this.progressNow = i;
        notifyPropertyChanged(675);
    }

    @Bindable
    public final boolean isShowDetail() {
        return this.isShowDetail;
    }

    public final void setShowDetail(boolean z) {
        this.isShowDetail = z;
        notifyPropertyChanged(827);
    }

    @Bindable
    public final boolean isStarted() {
        return this.isStarted;
    }

    public final void setStarted(boolean z) {
        this.isStarted = z;
        notifyPropertyChanged(901);
    }

    public final int getItemBits() {
        return this.itemBits;
    }

    public final void setItemBits(int i) {
        log("itemBits", Integer.valueOf(this.itemBits), Integer.valueOf(i));
        this.itemBits = i;
        notifyPropertyChanged(450);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readDate();
        readProgressNow();
        readItemBits();
    }

    public final String readDetail() {
        setDetail(readStr(MessageID.MSG_CAL_DETAIL));
        return this.detail;
    }

    public final String readResult() {
        setResult(readStr(MessageID.MSG_CAL_RESULT));
        return this.result;
    }

    public final String readDate() {
        setLastDate(readStr(MessageID.MSG_CAL_DATE));
        return this.lastDate;
    }

    public final int readProgressNow() {
        setProgressNow(readInt(MessageID.MSG_CAL_PROGRESS_NOW));
        return this.progressNow;
    }

    public final int readItemBits() {
        setItemBits(readInt(MessageID.MSG_CAL_ITEMS));
        return this.itemBits;
    }

    public final void saveItems(int i) {
        saveInt(MessageID.MSG_CAL_ITEMS, i);
        setItemBits(i);
    }

    public final void start() {
        if (this.isStarted) {
            postQuit();
        } else {
            postStart();
        }
    }

    public final void postStart() {
        API.getInstance().UI_PostInt32(12, MessageID.MSG_RESTORE_DEFAULT, 0);
        KtUtilKt.resetAll();
        saveInt(MessageID.MSG_SELF_CAL_START, this.itemBits);
        setStarted(true);
    }

    public final void postQuit() {
        API.getInstance().UI_PostInt32(12, MessageID.MSG_RESTORE_DEFAULT, 0);
        KtUtilKt.resetAll();
        saveInt(MessageID.MSG_SELF_CAL_QUIT, 0);
        setStarted(false);
    }

    public String toString() {
        return "SelfCalibrationParam(detail=" + this.detail + ", result=" + this.result + ", lastDate=" + this.lastDate + ", progressNow=" + this.progressNow + ", isShowDetail=" + this.isShowDetail + ", isStarted=" + this.isStarted + ", itemBits=" + this.itemBits + ')';
    }
}
