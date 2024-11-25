package kotlinx.coroutines;

import com.sun.mail.imap.IMAPStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CompletionHandler.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a8\u0010\r\u001a\u00020\u0006*#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u00072\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0080\b\":\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u00020\b8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\":\u0010\u0000\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00060\u0001j\u0002`\u0007*\u00020\u000b8À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\f¨\u0006\u000e"}, d2 = {"asHandler", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "Lkotlinx/coroutines/CancelHandlerBase;", "getAsHandler", "(Lkotlinx/coroutines/CancelHandlerBase;)Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/CompletionHandlerBase;", "(Lkotlinx/coroutines/CompletionHandlerBase;)Lkotlin/jvm/functions/Function1;", "invokeIt", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CompletionHandlerKt {
    public static final Function1<Throwable, Unit> getAsHandler(CompletionHandlerBase asHandler) {
        Intrinsics.checkParameterIsNotNull(asHandler, "$this$asHandler");
        return asHandler;
    }

    public static final Function1<Throwable, Unit> getAsHandler(CancelHandlerBase asHandler) {
        Intrinsics.checkParameterIsNotNull(asHandler, "$this$asHandler");
        return asHandler;
    }

    public static final void invokeIt(Function1<? super Throwable, Unit> invokeIt, Throwable th) {
        Intrinsics.checkParameterIsNotNull(invokeIt, "$this$invokeIt");
        invokeIt.invoke(th);
    }
}
