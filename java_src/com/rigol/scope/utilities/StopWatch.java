package com.rigol.scope.utilities;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: StopWatch.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/rigol/scope/utilities/StopWatch;", "Ljava/lang/AutoCloseable;", "tag", "", "(Ljava/lang/String;)V", "cost", "", "getCost", "()J", "setCost", "(J)V", "startTimeMillis", "getStartTimeMillis", "getTag", "()Ljava/lang/String;", "close", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class StopWatch implements AutoCloseable {
    private long cost;
    private final long startTimeMillis;
    private final String tag;

    public StopWatch(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        this.tag = tag;
        this.startTimeMillis = System.currentTimeMillis();
    }

    public final String getTag() {
        return this.tag;
    }

    public final long getCost() {
        return this.cost;
    }

    public final void setCost(long j) {
        this.cost = j;
    }

    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        long currentTimeMillis = System.currentTimeMillis() - this.startTimeMillis;
        this.cost = currentTimeMillis;
        Timber.v("%s, cost: %s", this.tag, Long.valueOf(currentTimeMillis));
    }
}
