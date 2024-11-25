package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ThreadContextElement;
/* compiled from: ThreadContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0000\u001a\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u0010\u0002\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\",\u0010\u0006\u001a \u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\n\u001a\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"ZERO", "Lkotlinx/coroutines/internal/Symbol;", "countAll", "Lkotlin/Function2;", "", "Lkotlin/coroutines/CoroutineContext$Element;", "findOne", "Lkotlinx/coroutines/ThreadContextElement;", "restoreState", "Lkotlinx/coroutines/internal/ThreadState;", "updateState", "restoreThreadContext", "", "context", "Lkotlin/coroutines/CoroutineContext;", "oldState", "threadContextElements", "updateThreadContext", "countOrElement", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ThreadContextKt {
    private static final Symbol ZERO = new Symbol("ZERO");
    private static final Function2<Object, CoroutineContext.Element, Object> countAll = new Function2<Object, CoroutineContext.Element, Object>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$countAll$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, CoroutineContext.Element element) {
            Intrinsics.checkParameterIsNotNull(element, "element");
            if (element instanceof ThreadContextElement) {
                if (!(obj instanceof Integer)) {
                    obj = null;
                }
                Integer num = (Integer) obj;
                int intValue = num != null ? num.intValue() : 1;
                return intValue == 0 ? element : Integer.valueOf(intValue + 1);
            }
            return obj;
        }
    };
    private static final Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>> findOne = new Function2<ThreadContextElement<?>, CoroutineContext.Element, ThreadContextElement<?>>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$findOne$1
        @Override // kotlin.jvm.functions.Function2
        public final ThreadContextElement<?> invoke(ThreadContextElement<?> threadContextElement, CoroutineContext.Element element) {
            Intrinsics.checkParameterIsNotNull(element, "element");
            if (threadContextElement != null) {
                return threadContextElement;
            }
            if (!(element instanceof ThreadContextElement)) {
                element = null;
            }
            return (ThreadContextElement) element;
        }
    };
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> updateState = new Function2<ThreadState, CoroutineContext.Element, ThreadState>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$updateState$1
        @Override // kotlin.jvm.functions.Function2
        public final ThreadState invoke(ThreadState state, CoroutineContext.Element element) {
            Intrinsics.checkParameterIsNotNull(state, "state");
            Intrinsics.checkParameterIsNotNull(element, "element");
            if (element instanceof ThreadContextElement) {
                state.append(((ThreadContextElement) element).updateThreadContext(state.getContext()));
            }
            return state;
        }
    };
    private static final Function2<ThreadState, CoroutineContext.Element, ThreadState> restoreState = new Function2<ThreadState, CoroutineContext.Element, ThreadState>() { // from class: kotlinx.coroutines.internal.ThreadContextKt$restoreState$1
        @Override // kotlin.jvm.functions.Function2
        public final ThreadState invoke(ThreadState state, CoroutineContext.Element element) {
            Intrinsics.checkParameterIsNotNull(state, "state");
            Intrinsics.checkParameterIsNotNull(element, "element");
            if (element instanceof ThreadContextElement) {
                ((ThreadContextElement) element).restoreThreadContext(state.getContext(), state.take());
            }
            return state;
        }
    };

    public static final Object threadContextElements(CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Object fold = context.fold(0, countAll);
        if (fold == null) {
            Intrinsics.throwNpe();
        }
        return fold;
    }

    public static final Object updateThreadContext(CoroutineContext context, Object obj) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (obj == null) {
            obj = threadContextElements(context);
        }
        if (obj == 0) {
            return ZERO;
        }
        if (obj instanceof Integer) {
            return context.fold(new ThreadState(context, ((Number) obj).intValue()), updateState);
        }
        if (obj == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        return ((ThreadContextElement) obj).updateThreadContext(context);
    }

    public static final void restoreThreadContext(CoroutineContext context, Object obj) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (obj == ZERO) {
            return;
        }
        if (obj instanceof ThreadState) {
            ((ThreadState) obj).start();
            context.fold(obj, restoreState);
            return;
        }
        Object fold = context.fold(null, findOne);
        if (fold == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        }
        ((ThreadContextElement) fold).restoreThreadContext(context, obj);
    }
}
