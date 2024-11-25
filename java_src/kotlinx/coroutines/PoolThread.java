package kotlinx.coroutines;

import com.sun.mail.imap.IMAPStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ThreadPoolDispatcher.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/PoolThread;", "Ljava/lang/Thread;", "dispatcher", "Lkotlinx/coroutines/ThreadPoolDispatcher;", "target", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", IMAPStore.ID_NAME, "", "(Lkotlinx/coroutines/ThreadPoolDispatcher;Ljava/lang/Runnable;Ljava/lang/String;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class PoolThread extends Thread {
    public final ThreadPoolDispatcher dispatcher;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PoolThread(ThreadPoolDispatcher dispatcher, Runnable target, String name) {
        super(target, name);
        Intrinsics.checkParameterIsNotNull(dispatcher, "dispatcher");
        Intrinsics.checkParameterIsNotNull(target, "target");
        Intrinsics.checkParameterIsNotNull(name, "name");
        this.dispatcher = dispatcher;
        setDaemon(true);
    }
}
