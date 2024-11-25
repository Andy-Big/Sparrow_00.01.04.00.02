package kotlinx.coroutines;

import com.sun.mail.imap.IMAPStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0007"}, d2 = {"newFixedThreadPoolContext", "Lkotlinx/coroutines/ExecutorCoroutineDispatcher;", "nThreads", "", IMAPStore.ID_NAME, "", "newSingleThreadContext", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ThreadPoolDispatcherKt {
    public static final ExecutorCoroutineDispatcher newSingleThreadContext(String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        return newFixedThreadPoolContext(1, name);
    }

    public static final ExecutorCoroutineDispatcher newFixedThreadPoolContext(int i, String name) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("Expected at least one thread, but " + i + " specified").toString());
        }
        return new ThreadPoolDispatcher(i, name);
    }
}
