package me.jessyan.autosize.external;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.jessyan.autosize.utils.Preconditions;
/* loaded from: classes2.dex */
public class ExternalAdaptManager {
    private boolean isRun;
    private List<String> mCancelAdaptList;
    private Map<String, ExternalAdaptInfo> mExternalAdaptInfos;

    public synchronized ExternalAdaptManager addCancelAdaptOfActivity(Class<?> cls) {
        Preconditions.checkNotNull(cls, "targetClass == null");
        if (!this.isRun) {
            this.isRun = true;
        }
        if (this.mCancelAdaptList == null) {
            this.mCancelAdaptList = new ArrayList();
        }
        this.mCancelAdaptList.add(cls.getCanonicalName());
        return this;
    }

    public synchronized ExternalAdaptManager addExternalAdaptInfoOfActivity(Class<?> cls, ExternalAdaptInfo externalAdaptInfo) {
        Preconditions.checkNotNull(cls, "targetClass == null");
        if (!this.isRun) {
            this.isRun = true;
        }
        if (this.mExternalAdaptInfos == null) {
            this.mExternalAdaptInfos = new HashMap(16);
        }
        this.mExternalAdaptInfos.put(cls.getCanonicalName(), externalAdaptInfo);
        return this;
    }

    public synchronized boolean isCancelAdapt(Class<?> cls) {
        Preconditions.checkNotNull(cls, "targetClass == null");
        if (this.mCancelAdaptList == null) {
            return false;
        }
        return this.mCancelAdaptList.contains(cls.getCanonicalName());
    }

    public synchronized ExternalAdaptInfo getExternalAdaptInfoOfActivity(Class<?> cls) {
        Preconditions.checkNotNull(cls, "targetClass == null");
        if (this.mExternalAdaptInfos == null) {
            return null;
        }
        return this.mExternalAdaptInfos.get(cls.getCanonicalName());
    }

    public boolean isRun() {
        return this.isRun;
    }

    public ExternalAdaptManager setRun(boolean z) {
        this.isRun = z;
        return this;
    }
}
