package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: Builders.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0012\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004B\u0015\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0011\u0010\r\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\r\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0010JH\u0010\u0011\u001a\u00020\u0012\"\u0004\b\u0001\u0010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00152\"\u0010\u0016\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00130\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0017H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u001aR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"Lkotlinx/coroutines/DeferredCoroutine;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/AbstractCoroutine;", "Lkotlinx/coroutines/Deferred;", "Lkotlinx/coroutines/selects/SelectClause1;", "parentContext", "Lkotlin/coroutines/CoroutineContext;", "active", "", "(Lkotlin/coroutines/CoroutineContext;Z)V", "onAwait", "getOnAwait", "()Lkotlinx/coroutines/selects/SelectClause1;", "await", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCompleted", "()Ljava/lang/Object;", "registerSelectClause1", "", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
class DeferredCoroutine<T> extends AbstractCoroutine<T> implements Deferred<T>, SelectClause1<T> {
    @Override // kotlinx.coroutines.Deferred
    public Object await(Continuation<? super T> continuation) {
        return await$suspendImpl(this, continuation);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeferredCoroutine(CoroutineContext parentContext, boolean z) {
        super(parentContext, z);
        Intrinsics.checkParameterIsNotNull(parentContext, "parentContext");
    }

    @Override // kotlinx.coroutines.Deferred
    public T getCompleted() {
        return (T) getCompletedInternal$kotlinx_coroutines_core();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static /* synthetic */ Object await$suspendImpl(DeferredCoroutine deferredCoroutine, Continuation continuation) {
        DeferredCoroutine$await$1 deferredCoroutine$await$1;
        int i;
        if (continuation instanceof DeferredCoroutine$await$1) {
            deferredCoroutine$await$1 = (DeferredCoroutine$await$1) continuation;
            if ((deferredCoroutine$await$1.label & Integer.MIN_VALUE) != 0) {
                deferredCoroutine$await$1.label -= Integer.MIN_VALUE;
                Object obj = deferredCoroutine$await$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = deferredCoroutine$await$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    deferredCoroutine$await$1.L$0 = deferredCoroutine;
                    deferredCoroutine$await$1.label = 1;
                    obj = deferredCoroutine.awaitInternal$kotlinx_coroutines_core(deferredCoroutine$await$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    DeferredCoroutine deferredCoroutine2 = (DeferredCoroutine) deferredCoroutine$await$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return obj;
            }
        }
        deferredCoroutine$await$1 = new DeferredCoroutine$await$1(deferredCoroutine, continuation);
        Object obj2 = deferredCoroutine$await$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = deferredCoroutine$await$1.label;
        if (i != 0) {
        }
        return obj2;
    }

    @Override // kotlinx.coroutines.Deferred
    public SelectClause1<T> getOnAwait() {
        return this;
    }

    @Override // kotlinx.coroutines.selects.SelectClause1
    public <R> void registerSelectClause1(SelectInstance<? super R> select, Function2<? super T, ? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(select, "select");
        Intrinsics.checkParameterIsNotNull(block, "block");
        registerSelectClause1Internal$kotlinx_coroutines_core(select, block);
    }
}
