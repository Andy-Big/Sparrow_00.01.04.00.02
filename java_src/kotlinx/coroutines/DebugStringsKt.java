package kotlinx.coroutines;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DebugStrings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0007\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\bH\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0018\u0010\u0005\u001a\u00020\u0001*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004¨\u0006\t"}, d2 = {"classSimpleName", "", "", "getClassSimpleName", "(Ljava/lang/Object;)Ljava/lang/String;", "hexAddress", "getHexAddress", "toDebugString", "Lkotlin/coroutines/Continuation;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class DebugStringsKt {
    public static final String getHexAddress(Object hexAddress) {
        Intrinsics.checkParameterIsNotNull(hexAddress, "$this$hexAddress");
        String hexString = Integer.toHexString(System.identityHashCode(hexAddress));
        Intrinsics.checkExpressionValueIsNotNull(hexString, "Integer.toHexString(System.identityHashCode(this))");
        return hexString;
    }

    public static final String toDebugString(Continuation<?> toDebugString) {
        String m28constructorimpl;
        Intrinsics.checkParameterIsNotNull(toDebugString, "$this$toDebugString");
        if (toDebugString instanceof DispatchedContinuation) {
            return toDebugString.toString();
        }
        try {
            Result.Companion companion = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(toDebugString + '@' + getHexAddress(toDebugString));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m31exceptionOrNullimpl(m28constructorimpl) != null) {
            m28constructorimpl = toDebugString.getClass().getName() + '@' + getHexAddress(toDebugString);
        }
        return (String) m28constructorimpl;
    }

    public static final String getClassSimpleName(Object classSimpleName) {
        Intrinsics.checkParameterIsNotNull(classSimpleName, "$this$classSimpleName");
        String simpleName = classSimpleName.getClass().getSimpleName();
        Intrinsics.checkExpressionValueIsNotNull(simpleName, "this::class.java.simpleName");
        return simpleName;
    }
}
