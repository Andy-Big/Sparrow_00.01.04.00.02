package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.AbstractCoroutine;
/* compiled from: Scopes.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"tryRecover", "", "Lkotlinx/coroutines/AbstractCoroutine;", "exception", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ScopesKt {
    public static final Throwable tryRecover(AbstractCoroutine<?> tryRecover, Throwable exception) {
        Continuation<T> continuation;
        Intrinsics.checkParameterIsNotNull(tryRecover, "$this$tryRecover");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (!(tryRecover instanceof ScopeCoroutine)) {
            tryRecover = null;
        }
        ScopeCoroutine scopeCoroutine = (ScopeCoroutine) tryRecover;
        return (scopeCoroutine == null || (continuation = scopeCoroutine.uCont) == 0) ? exception : StackTraceRecoveryKt.recoverStackTrace(exception, continuation);
    }
}
