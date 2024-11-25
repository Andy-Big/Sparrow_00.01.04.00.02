package com.scwang.smartrefresh.layout.constant;
/* loaded from: classes2.dex */
public enum DimensionStatus {
    DefaultUnNotify(false),
    Default(true),
    XmlWrapUnNotify(false),
    XmlWrap(true),
    XmlExactUnNotify(false),
    XmlExact(true),
    XmlLayoutUnNotify(false),
    XmlLayout(true),
    CodeExactUnNotify(false),
    CodeExact(true),
    DeadLockUnNotify(false),
    DeadLock(true);
    
    public final boolean notified;

    DimensionStatus(boolean z) {
        this.notified = z;
    }

    public DimensionStatus unNotify() {
        if (this.notified) {
            DimensionStatus dimensionStatus = values()[ordinal() - 1];
            return !dimensionStatus.notified ? dimensionStatus : DefaultUnNotify;
        }
        return this;
    }

    public DimensionStatus notified() {
        return !this.notified ? values()[ordinal() + 1] : this;
    }

    public boolean canReplaceWith(DimensionStatus dimensionStatus) {
        return ordinal() < dimensionStatus.ordinal() || ((!this.notified || CodeExact == this) && ordinal() == dimensionStatus.ordinal());
    }
}
