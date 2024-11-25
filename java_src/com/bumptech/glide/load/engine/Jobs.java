package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
final class Jobs {
    private final Map<Key, EngineJob<?>> jobs = new HashMap();
    private final Map<Key, EngineJob<?>> onlyCacheJobs = new HashMap();

    Map<Key, EngineJob<?>> getAll() {
        return Collections.unmodifiableMap(this.jobs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob<?> get(Key key, boolean z) {
        return getJobMap(z).get(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void put(Key key, EngineJob<?> engineJob) {
        getJobMap(engineJob.onlyRetrieveFromCache()).put(key, engineJob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeIfCurrent(Key key, EngineJob<?> engineJob) {
        Map<Key, EngineJob<?>> jobMap = getJobMap(engineJob.onlyRetrieveFromCache());
        if (engineJob.equals(jobMap.get(key))) {
            jobMap.remove(key);
        }
    }

    private Map<Key, EngineJob<?>> getJobMap(boolean z) {
        return z ? this.onlyCacheJobs : this.jobs;
    }
}
