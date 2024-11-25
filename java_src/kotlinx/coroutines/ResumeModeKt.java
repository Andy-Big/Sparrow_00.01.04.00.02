package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.internal.ThreadContextKt;
/* compiled from: ResumeMode.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\u001a-\u0010\u0010\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a-\u0010\u0017\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0014\u001a\u0002H\u00122\u0006\u0010\u0015\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0016\u001a(\u0010\u0018\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\u001a(\u0010\u001b\u001a\u00020\u0011\"\u0004\b\u0000\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00120\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0015\u001a\u00020\u0001H\u0000\"\u0016\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u000e\"\u0018\u0010\u000f\u001a\u00020\r*\u00020\u00018@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001c"}, d2 = {"MODE_ATOMIC_DEFAULT", "", "MODE_ATOMIC_DEFAULT$annotations", "()V", "MODE_CANCELLABLE", "MODE_CANCELLABLE$annotations", "MODE_DIRECT", "MODE_DIRECT$annotations", "MODE_IGNORE", "MODE_IGNORE$annotations", "MODE_UNDISPATCHED", "MODE_UNDISPATCHED$annotations", "isCancellableMode", "", "(I)Z", "isDispatchedMode", "resumeMode", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/coroutines/Continuation;", "value", "mode", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;I)V", "resumeUninterceptedMode", "resumeUninterceptedWithExceptionMode", "exception", "", "resumeWithExceptionMode", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ResumeModeKt {
    public static final int MODE_ATOMIC_DEFAULT = 0;
    public static final int MODE_CANCELLABLE = 1;
    public static final int MODE_DIRECT = 2;
    public static final int MODE_IGNORE = 4;
    public static final int MODE_UNDISPATCHED = 3;

    public static /* synthetic */ void MODE_ATOMIC_DEFAULT$annotations() {
    }

    public static /* synthetic */ void MODE_CANCELLABLE$annotations() {
    }

    public static /* synthetic */ void MODE_DIRECT$annotations() {
    }

    public static /* synthetic */ void MODE_IGNORE$annotations() {
    }

    public static /* synthetic */ void MODE_UNDISPATCHED$annotations() {
    }

    public static final boolean isCancellableMode(int i) {
        return i == 1;
    }

    public static final boolean isDispatchedMode(int i) {
        return i == 0 || i == 1;
    }

    public static final <T> void resumeMode(Continuation<? super T> resumeMode, T t, int i) {
        Intrinsics.checkParameterIsNotNull(resumeMode, "$this$resumeMode");
        if (i == 0) {
            Result.Companion companion = Result.Companion;
            resumeMode.resumeWith(Result.m28constructorimpl(t));
        } else if (i == 1) {
            DispatchedKt.resumeCancellable(resumeMode, t);
        } else if (i == 2) {
            DispatchedKt.resumeDirect(resumeMode, t);
        } else if (i != 3) {
            if (i == 4) {
                return;
            }
            throw new IllegalStateException(("Invalid mode " + i).toString());
        } else {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) resumeMode;
            CoroutineContext context = dispatchedContinuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            try {
                Continuation<T> continuation = dispatchedContinuation.continuation;
                Result.Companion companion2 = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(t));
                Unit unit = Unit.INSTANCE;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        }
    }

    public static final <T> void resumeWithExceptionMode(Continuation<? super T> resumeWithExceptionMode, Throwable exception, int i) {
        Intrinsics.checkParameterIsNotNull(resumeWithExceptionMode, "$this$resumeWithExceptionMode");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (i == 0) {
            Result.Companion companion = Result.Companion;
            resumeWithExceptionMode.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(exception)));
        } else if (i == 1) {
            DispatchedKt.resumeCancellableWithException(resumeWithExceptionMode, exception);
        } else if (i == 2) {
            DispatchedKt.resumeDirectWithException(resumeWithExceptionMode, exception);
        } else if (i != 3) {
            if (i == 4) {
                return;
            }
            throw new IllegalStateException(("Invalid mode " + i).toString());
        } else {
            DispatchedContinuation dispatchedContinuation = (DispatchedContinuation) resumeWithExceptionMode;
            CoroutineContext context = dispatchedContinuation.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, dispatchedContinuation.countOrElement);
            try {
                Continuation<T> continuation = dispatchedContinuation.continuation;
                Result.Companion companion2 = Result.Companion;
                continuation.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(StackTraceRecoveryKt.recoverStackTrace(exception, continuation))));
                Unit unit = Unit.INSTANCE;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        }
    }

    public static final <T> void resumeUninterceptedMode(Continuation<? super T> resumeUninterceptedMode, T t, int i) {
        Intrinsics.checkParameterIsNotNull(resumeUninterceptedMode, "$this$resumeUninterceptedMode");
        if (i == 0) {
            Continuation intercepted = IntrinsicsKt.intercepted(resumeUninterceptedMode);
            Result.Companion companion = Result.Companion;
            intercepted.resumeWith(Result.m28constructorimpl(t));
        } else if (i == 1) {
            DispatchedKt.resumeCancellable(IntrinsicsKt.intercepted(resumeUninterceptedMode), t);
        } else if (i == 2) {
            Result.Companion companion2 = Result.Companion;
            resumeUninterceptedMode.resumeWith(Result.m28constructorimpl(t));
        } else if (i != 3) {
            if (i == 4) {
                return;
            }
            throw new IllegalStateException(("Invalid mode " + i).toString());
        } else {
            CoroutineContext context = resumeUninterceptedMode.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Result.Companion companion3 = Result.Companion;
                resumeUninterceptedMode.resumeWith(Result.m28constructorimpl(t));
                Unit unit = Unit.INSTANCE;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        }
    }

    public static final <T> void resumeUninterceptedWithExceptionMode(Continuation<? super T> resumeUninterceptedWithExceptionMode, Throwable exception, int i) {
        Intrinsics.checkParameterIsNotNull(resumeUninterceptedWithExceptionMode, "$this$resumeUninterceptedWithExceptionMode");
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (i == 0) {
            Continuation intercepted = IntrinsicsKt.intercepted(resumeUninterceptedWithExceptionMode);
            Result.Companion companion = Result.Companion;
            intercepted.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(exception)));
        } else if (i == 1) {
            DispatchedKt.resumeCancellableWithException(IntrinsicsKt.intercepted(resumeUninterceptedWithExceptionMode), exception);
        } else if (i == 2) {
            Result.Companion companion2 = Result.Companion;
            resumeUninterceptedWithExceptionMode.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(exception)));
        } else if (i != 3) {
            if (i == 4) {
                return;
            }
            throw new IllegalStateException(("Invalid mode " + i).toString());
        } else {
            CoroutineContext context = resumeUninterceptedWithExceptionMode.getContext();
            Object updateThreadContext = ThreadContextKt.updateThreadContext(context, null);
            try {
                Result.Companion companion3 = Result.Companion;
                resumeUninterceptedWithExceptionMode.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(exception)));
                Unit unit = Unit.INSTANCE;
            } finally {
                ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            }
        }
    }
}
