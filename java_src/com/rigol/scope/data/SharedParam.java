package com.rigol.scope.data;

import androidx.databinding.Bindable;
import kotlin.Metadata;
/* compiled from: SharedParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b$\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR&\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\tR&\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR&\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR&\u0010\"\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR&\u0010%\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR&\u0010(\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000fR&\u0010+\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000f¨\u0006."}, d2 = {"Lcom/rigol/scope/data/SharedParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "closedResultBar", "getClosedResultBar", "()Z", "setClosedResultBar", "(Z)V", "", "currentResultItem", "getCurrentResultItem", "()I", "setCurrentResultItem", "(I)V", "launcheNum", "getLauncheNum", "setLauncheNum", "probeRequestCal", "getProbeRequestCal", "setProbeRequestCal", "showNetwork", "getShowNetwork", "setShowNetwork", "showRMT", "getShowRMT", "setShowRMT", "showResultBar", "getShowResultBar", "setShowResultBar", "showSmb", "getShowSmb", "setShowSmb", "showUsb", "getShowUsb", "setShowUsb", "viewonDrag", "getViewonDrag", "setViewonDrag", "windowCount", "getWindowCount", "setWindowCount", "xyWindowCount", "getXyWindowCount", "setXyWindowCount", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class SharedParam extends BaseParam {
    private boolean closedResultBar;
    private int currentResultItem;
    private boolean launcheNum;
    private boolean probeRequestCal;
    private boolean showNetwork;
    private boolean showRMT;
    private boolean showResultBar;
    private boolean showSmb;
    private boolean showUsb;
    private boolean viewonDrag;
    private int windowCount;
    private int xyWindowCount;

    public SharedParam() {
        super(0);
        this.windowCount = 1;
    }

    @Bindable
    public final int getCurrentResultItem() {
        return this.currentResultItem;
    }

    public final void setCurrentResultItem(int i) {
        log("currentResultItem", Integer.valueOf(this.currentResultItem), Integer.valueOf(i));
        this.currentResultItem = i;
        notifyPropertyChanged(198);
    }

    @Bindable
    public final int getWindowCount() {
        return this.windowCount;
    }

    public final void setWindowCount(int i) {
        log("windowCount", Integer.valueOf(this.windowCount), Integer.valueOf(i));
        this.windowCount = i;
        notifyPropertyChanged(1076);
    }

    @Bindable
    public final int getXyWindowCount() {
        return this.xyWindowCount;
    }

    public final void setXyWindowCount(int i) {
        log("xyWindowCount", Integer.valueOf(this.xyWindowCount), Integer.valueOf(i));
        this.xyWindowCount = i;
        notifyPropertyChanged(1085);
    }

    @Bindable
    public final boolean getShowResultBar() {
        return this.showResultBar;
    }

    public final void setShowResultBar(boolean z) {
        log("showResultBar", Boolean.valueOf(this.showResultBar), Boolean.valueOf(z));
        this.showResultBar = z;
        notifyPropertyChanged(833);
    }

    @Bindable
    public final boolean getClosedResultBar() {
        return this.closedResultBar;
    }

    public final void setClosedResultBar(boolean z) {
        log("closedResultBar", Boolean.valueOf(this.closedResultBar), Boolean.valueOf(z));
        this.closedResultBar = z;
        notifyPropertyChanged(180);
    }

    @Bindable
    public final boolean getShowUsb() {
        return this.showUsb;
    }

    public final void setShowUsb(boolean z) {
        log("showUsb", Boolean.valueOf(this.showUsb), Boolean.valueOf(z));
        this.showUsb = z;
        notifyPropertyChanged(843);
    }

    @Bindable
    public final boolean getShowSmb() {
        return this.showSmb;
    }

    public final void setShowSmb(boolean z) {
        log("showSmb", Boolean.valueOf(this.showSmb), Boolean.valueOf(z));
        this.showSmb = z;
        notifyPropertyChanged(835);
    }

    @Bindable
    public final boolean getShowNetwork() {
        return this.showNetwork;
    }

    public final void setShowNetwork(boolean z) {
        log("showNetwork", Boolean.valueOf(this.showNetwork), Boolean.valueOf(z));
        this.showNetwork = z;
        notifyPropertyChanged(830);
    }

    @Bindable
    public final boolean getShowRMT() {
        return this.showRMT;
    }

    public final void setShowRMT(boolean z) {
        log("showRMT", Boolean.valueOf(this.showRMT), Boolean.valueOf(z));
        this.showRMT = z;
        notifyPropertyChanged(832);
    }

    @Bindable
    public final boolean getProbeRequestCal() {
        return this.probeRequestCal;
    }

    public final void setProbeRequestCal(boolean z) {
        log("probeRequestCal", Boolean.valueOf(this.probeRequestCal), Boolean.valueOf(z));
        this.probeRequestCal = z;
        notifyPropertyChanged(668);
    }

    @Bindable
    public final boolean getViewonDrag() {
        return this.viewonDrag;
    }

    public final void setViewonDrag(boolean z) {
        log("probeRequestCal", Boolean.valueOf(this.viewonDrag), Boolean.valueOf(z));
        this.viewonDrag = z;
        notifyPropertyChanged(1033);
    }

    @Bindable
    public final boolean getLauncheNum() {
        return this.launcheNum;
    }

    public final void setLauncheNum(boolean z) {
        log("probeRequestCal", Boolean.valueOf(this.launcheNum), Boolean.valueOf(z));
        this.launcheNum = z;
        notifyPropertyChanged(481);
    }
}
