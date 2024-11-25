package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayDeque;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.DebugKt;
/* compiled from: StackTraceRecovery.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u001a\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0007\u001a9\u0010\t\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\f\u001a\u0002H\n2\u0006\u0010\r\u001a\u0002H\n2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u000fH\u0002¢\u0006\u0002\u0010\u0011\u001a\u001e\u0010\u0012\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u000f2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002\u001a1\u0010\u0016\u001a\u00020\u00172\u0010\u0010\u0018\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u00192\u0010\u0010\r\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u000fH\u0002¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000bH\u0080Hø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a+\u0010\u001f\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\n2\n\u0010\u0013\u001a\u00060\u0014j\u0002`\u0015H\u0002¢\u0006\u0002\u0010 \u001a\u001f\u0010!\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\nH\u0000¢\u0006\u0002\u0010\"\u001a+\u0010!\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\n2\n\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030#H\u0000¢\u0006\u0002\u0010$\u001a\u001f\u0010%\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b2\u0006\u0010\u001d\u001a\u0002H\nH\u0000¢\u0006\u0002\u0010\"\u001a1\u0010&\u001a\u0018\u0012\u0004\u0012\u0002H\n\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u00190'\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\nH\u0002¢\u0006\u0002\u0010(\u001a\u001c\u0010)\u001a\u00020**\u00060\u0007j\u0002`\u00102\n\u0010+\u001a\u00060\u0007j\u0002`\u0010H\u0002\u001a#\u0010,\u001a\u00020-*\f\u0012\b\u0012\u00060\u0007j\u0002`\u00100\u00192\u0006\u0010.\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010/\u001a\u0010\u00100\u001a\u00020**\u00060\u0007j\u0002`\u0010H\u0000\u001a\u001b\u00101\u001a\u0002H\n\"\b\b\u0000\u0010\n*\u00020\u000b*\u0002H\nH\u0002¢\u0006\u0002\u0010\"\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0005\u001a\n \u0003*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000*\f\b\u0000\u00102\"\u00020\u00142\u00020\u0014*\f\b\u0000\u00103\"\u00020\u00072\u00020\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u00064"}, d2 = {"baseContinuationImplClass", "", "baseContinuationImplClassName", "kotlin.jvm.PlatformType", "stackTraceRecoveryClass", "stackTraceRecoveryClassName", "artificialFrame", "Ljava/lang/StackTraceElement;", "message", "createFinalException", ExifInterface.LONGITUDE_EAST, "", "cause", "result", "resultStackTrace", "Ljava/util/ArrayDeque;", "Lkotlinx/coroutines/internal/StackTraceElement;", "(Ljava/lang/Throwable;Ljava/lang/Throwable;Ljava/util/ArrayDeque;)Ljava/lang/Throwable;", "createStackTrace", "continuation", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "mergeRecoveredTraces", "", "recoveredStacktrace", "", "([Ljava/lang/StackTraceElement;Ljava/util/ArrayDeque;)V", "recoverAndThrow", "", "exception", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recoverFromStackFrame", "(Ljava/lang/Throwable;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Ljava/lang/Throwable;", "recoverStackTrace", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/Throwable;Lkotlin/coroutines/Continuation;)Ljava/lang/Throwable;", "unwrap", "causeAndStacktrace", "Lkotlin/Pair;", "(Ljava/lang/Throwable;)Lkotlin/Pair;", "elementWiseEquals", "", "e", "frameIndex", "", "methodName", "([Ljava/lang/StackTraceElement;Ljava/lang/String;)I", "isArtificial", "sanitizeStackTrace", "CoroutineStackFrame", "StackTraceElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class StackTraceRecoveryKt {
    private static final String baseContinuationImplClass = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
    private static final String baseContinuationImplClassName;
    private static final String stackTraceRecoveryClass = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
    private static final String stackTraceRecoveryClassName;

    public static /* synthetic */ void CoroutineStackFrame$annotations() {
    }

    public static /* synthetic */ void StackTraceElement$annotations() {
    }

    static {
        Object obj;
        Object obj2;
        Object obj3 = stackTraceRecoveryClass;
        Object obj4 = baseContinuationImplClass;
        try {
            Result.Companion companion = Result.Companion;
            Class<?> cls = Class.forName(baseContinuationImplClass);
            Intrinsics.checkExpressionValueIsNotNull(cls, "Class.forName(baseContinuationImplClass)");
            obj = Result.m28constructorimpl(cls.getCanonicalName());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m28constructorimpl(ResultKt.createFailure(th));
        }
        if (Result.m31exceptionOrNullimpl(obj) == null) {
            obj4 = obj;
        }
        baseContinuationImplClassName = (String) obj4;
        try {
            Result.Companion companion3 = Result.Companion;
            Class<?> cls2 = Class.forName(stackTraceRecoveryClass);
            Intrinsics.checkExpressionValueIsNotNull(cls2, "Class.forName(stackTraceRecoveryClass)");
            obj2 = Result.m28constructorimpl(cls2.getCanonicalName());
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.m28constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m31exceptionOrNullimpl(obj2) == null) {
            obj3 = obj2;
        }
        stackTraceRecoveryClassName = (String) obj3;
    }

    public static final <E extends Throwable> E recoverStackTrace(E exception) {
        Throwable tryCopyException;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        return (DebugKt.getRECOVER_STACK_TRACES() && (tryCopyException = ExceptionsConstuctorKt.tryCopyException(exception)) != null) ? (E) sanitizeStackTrace(tryCopyException) : exception;
    }

    private static final <E extends Throwable> E sanitizeStackTrace(E e) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e.getStackTrace();
        int length = stackTrace.length;
        Intrinsics.checkExpressionValueIsNotNull(stackTrace, "stackTrace");
        String stackTraceRecoveryClassName2 = stackTraceRecoveryClassName;
        Intrinsics.checkExpressionValueIsNotNull(stackTraceRecoveryClassName2, "stackTraceRecoveryClassName");
        int frameIndex = frameIndex(stackTrace, stackTraceRecoveryClassName2);
        int i = frameIndex + 1;
        String baseContinuationImplClassName2 = baseContinuationImplClassName;
        Intrinsics.checkExpressionValueIsNotNull(baseContinuationImplClassName2, "baseContinuationImplClassName");
        int frameIndex2 = frameIndex(stackTrace, baseContinuationImplClassName2);
        int i2 = (length - frameIndex) - (frameIndex2 == -1 ? 0 : length - frameIndex2);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 == 0) {
                stackTraceElement = artificialFrame("Coroutine boundary");
            } else {
                stackTraceElement = stackTrace[(i + i3) - 1];
            }
            stackTraceElementArr[i3] = stackTraceElement;
        }
        e.setStackTrace(stackTraceElementArr);
        return e;
    }

    public static final <E extends Throwable> E recoverStackTrace(E exception, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        return (DebugKt.getRECOVER_STACK_TRACES() && (continuation instanceof CoroutineStackFrame)) ? (E) recoverFromStackFrame(exception, (CoroutineStackFrame) continuation) : exception;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> E recoverFromStackFrame(E e, CoroutineStackFrame coroutineStackFrame) {
        Pair causeAndStacktrace = causeAndStacktrace(e);
        Throwable th = (Throwable) causeAndStacktrace.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) causeAndStacktrace.component2();
        Throwable tryCopyException = ExceptionsConstuctorKt.tryCopyException(th);
        if (tryCopyException != null) {
            ArrayDeque<StackTraceElement> createStackTrace = createStackTrace(coroutineStackFrame);
            if (createStackTrace.isEmpty()) {
                return e;
            }
            if (th != e) {
                mergeRecoveredTraces(stackTraceElementArr, createStackTrace);
            }
            return (E) createFinalException(th, tryCopyException, createStackTrace);
        }
        return e;
    }

    private static final <E extends Throwable> E createFinalException(E e, E e2, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(artificialFrame("Coroutine boundary"));
        StackTraceElement[] causeTrace = e.getStackTrace();
        Intrinsics.checkExpressionValueIsNotNull(causeTrace, "causeTrace");
        String baseContinuationImplClassName2 = baseContinuationImplClassName;
        Intrinsics.checkExpressionValueIsNotNull(baseContinuationImplClassName2, "baseContinuationImplClassName");
        int frameIndex = frameIndex(causeTrace, baseContinuationImplClassName2);
        int i = 0;
        if (frameIndex != -1) {
            StackTraceElement[] stackTraceElementArr = new StackTraceElement[arrayDeque.size() + frameIndex];
            for (int i2 = 0; i2 < frameIndex; i2++) {
                stackTraceElementArr[i2] = causeTrace[i2];
            }
            for (StackTraceElement stackTraceElement : arrayDeque) {
                stackTraceElementArr[frameIndex + i] = stackTraceElement;
                i++;
            }
            e2.setStackTrace(stackTraceElementArr);
            return e2;
        }
        Object[] array = arrayDeque.toArray(new StackTraceElement[0]);
        if (array != null) {
            e2.setStackTrace((StackTraceElement[]) array);
            return e2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    private static final <E extends Throwable> Pair<E, StackTraceElement[]> causeAndStacktrace(E e) {
        boolean z;
        Throwable cause = e.getCause();
        if (cause != null && Intrinsics.areEqual(cause.getClass(), e.getClass())) {
            StackTraceElement[] currentTrace = e.getStackTrace();
            Intrinsics.checkExpressionValueIsNotNull(currentTrace, "currentTrace");
            int length = currentTrace.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                }
                StackTraceElement it = currentTrace[i];
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if (isArtificial(it)) {
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return TuplesKt.to(cause, currentTrace);
            }
            return TuplesKt.to(e, new StackTraceElement[0]);
        }
        return TuplesKt.to(e, new StackTraceElement[0]);
    }

    public static final Object recoverAndThrow(Throwable th, Continuation<?> continuation) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw th;
        }
        if (continuation instanceof CoroutineStackFrame) {
            throw recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
        }
        throw th;
    }

    private static final Object recoverAndThrow$$forInline(Throwable th, Continuation continuation) {
        if (!DebugKt.getRECOVER_STACK_TRACES()) {
            throw th;
        }
        InlineMarker.mark(0);
        if (continuation instanceof CoroutineStackFrame) {
            throw recoverFromStackFrame(th, (CoroutineStackFrame) continuation);
        }
        throw th;
    }

    public static final <E extends Throwable> E unwrap(E exception) {
        E e;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (DebugKt.getRECOVER_STACK_TRACES() && (e = (E) exception.getCause()) != null) {
            boolean z = true;
            if (!(!Intrinsics.areEqual(e.getClass(), exception.getClass()))) {
                StackTraceElement[] stackTrace = exception.getStackTrace();
                Intrinsics.checkExpressionValueIsNotNull(stackTrace, "exception.stackTrace");
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    }
                    StackTraceElement it = stackTrace[i];
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    if (isArtificial(it)) {
                        break;
                    }
                    i++;
                }
                if (z) {
                    return e;
                }
            }
        }
        return exception;
    }

    private static final ArrayDeque<StackTraceElement> createStackTrace(CoroutineStackFrame coroutineStackFrame) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = coroutineStackFrame.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            if (!(coroutineStackFrame instanceof CoroutineStackFrame)) {
                coroutineStackFrame = null;
            }
            if (coroutineStackFrame == null || (coroutineStackFrame = coroutineStackFrame.getCallerFrame()) == null) {
                break;
            }
            StackTraceElement stackTraceElement2 = coroutineStackFrame.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
        return arrayDeque;
    }

    public static final StackTraceElement artificialFrame(String message) {
        Intrinsics.checkParameterIsNotNull(message, "message");
        return new StackTraceElement("\b\b\b(" + message, "\b", "\b", -1);
    }

    public static final boolean isArtificial(StackTraceElement isArtificial) {
        Intrinsics.checkParameterIsNotNull(isArtificial, "$this$isArtificial");
        String className = isArtificial.getClassName();
        Intrinsics.checkExpressionValueIsNotNull(className, "className");
        return StringsKt.startsWith$default(className, "\b\b\b", false, 2, (Object) null);
    }

    private static final boolean elementWiseEquals(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && Intrinsics.areEqual(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && Intrinsics.areEqual(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && Intrinsics.areEqual(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    private static final void mergeRecoveredTraces(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            } else if (isArtificial(stackTraceElementArr[i])) {
                break;
            } else {
                i++;
            }
        }
        int i2 = i + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (length2 < i2) {
            return;
        }
        while (true) {
            StackTraceElement stackTraceElement = stackTraceElementArr[length2];
            StackTraceElement last = arrayDeque.getLast();
            Intrinsics.checkExpressionValueIsNotNull(last, "result.last");
            if (elementWiseEquals(stackTraceElement, last)) {
                arrayDeque.removeLast();
            }
            arrayDeque.addFirst(stackTraceElementArr[length2]);
            if (length2 == i2) {
                return;
            }
            length2--;
        }
    }

    private static final int frameIndex(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i = 0; i < length; i++) {
            if (Intrinsics.areEqual(str, stackTraceElementArr[i].getClassName())) {
                return i;
            }
        }
        return -1;
    }
}
