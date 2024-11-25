package kotlinx.coroutines.intrinsics;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DispatchedKt;
/* compiled from: Cancellable.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a#\u0010\u0000\u001a\u00020\u00012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b\u001a>\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0007*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0003H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aR\u0010\u0006\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0007*\u001e\b\u0001\u0012\u0004\u0012\u0002H\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u0003\u0012\u0006\u0012\u0004\u0018\u00010\t0\f2\u0006\u0010\r\u001a\u0002H\u000b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0003H\u0000ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"runSafely", "", "completion", "Lkotlin/coroutines/Continuation;", "block", "Lkotlin/Function0;", "startCoroutineCancellable", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)V", "R", "Lkotlin/Function2;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CancellableKt {
    public static final <T> void startCoroutineCancellable(Function1<? super Continuation<? super T>, ? extends Object> startCoroutineCancellable, Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull(startCoroutineCancellable, "$this$startCoroutineCancellable");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        try {
            DispatchedKt.resumeCancellable(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(startCoroutineCancellable, completion)), Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            completion.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(th)));
        }
    }

    public static final <R, T> void startCoroutineCancellable(Function2<? super R, ? super Continuation<? super T>, ? extends Object> startCoroutineCancellable, R r, Continuation<? super T> completion) {
        Intrinsics.checkParameterIsNotNull(startCoroutineCancellable, "$this$startCoroutineCancellable");
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        try {
            DispatchedKt.resumeCancellable(IntrinsicsKt.intercepted(IntrinsicsKt.createCoroutineUnintercepted(startCoroutineCancellable, r, completion)), Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            completion.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(th)));
        }
    }

    private static final void runSafely(Continuation<?> continuation, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Throwable th) {
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(th)));
        }
    }
}
