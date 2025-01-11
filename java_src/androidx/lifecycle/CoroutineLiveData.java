package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* compiled from: CoroutineLiveData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002BK\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012-\u0010\u0007\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\b¢\u0006\u0002\b\rø\u0001\u0000¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u0013\u001a\u00020\u000bH\u0080@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J!\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u0019H\u0080@ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u001c\u001a\u00020\u000bH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Landroidx/lifecycle/CoroutineLiveData;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/MediatorLiveData;", "context", "Lkotlin/coroutines/CoroutineContext;", "timeoutInMs", "", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)V", "blockRunner", "Landroidx/lifecycle/BlockRunner;", "emittedSource", "Landroidx/lifecycle/EmittedSource;", "clearSource", "clearSource$lifecycle_livedata_ktx_release", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitSource", "Lkotlinx/coroutines/DisposableHandle;", "source", "Landroidx/lifecycle/LiveData;", "emitSource$lifecycle_livedata_ktx_release", "(Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onActive", "onInactive", "lifecycle-livedata-ktx_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class CoroutineLiveData<T> extends MediatorLiveData<T> {
    private BlockRunner<T> blockRunner;
    private EmittedSource emittedSource;

    public /* synthetic */ CoroutineLiveData(EmptyCoroutineContext emptyCoroutineContext, long j, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? EmptyCoroutineContext.INSTANCE : emptyCoroutineContext, (i & 2) != 0 ? 5000L : j, function2);
    }

    public CoroutineLiveData(CoroutineContext context, long j, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        this.blockRunner = new BlockRunner<>(this, block, j, CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().getImmediate().plus(context).plus(SupervisorKt.SupervisorJob((Job) context.get(Job.Key)))), new Function0<Unit>() { // from class: androidx.lifecycle.CoroutineLiveData.1
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CoroutineLiveData.this.blockRunner = null;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0069 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object emitSource$lifecycle_livedata_ktx_release(LiveData<T> liveData, Continuation<? super DisposableHandle> continuation) {
        CoroutineLiveData$emitSource$1 coroutineLiveData$emitSource$1;
        Object obj;
        Object coroutine_suspended;
        int i;
        LiveData<T> liveData2;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$emitSource$1) {
            coroutineLiveData$emitSource$1 = (CoroutineLiveData$emitSource$1) continuation;
            if ((coroutineLiveData$emitSource$1.label & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$emitSource$1.label -= Integer.MIN_VALUE;
                obj = coroutineLiveData$emitSource$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = coroutineLiveData$emitSource$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    coroutineLiveData$emitSource$1.L$0 = this;
                    coroutineLiveData$emitSource$1.L$1 = liveData;
                    coroutineLiveData$emitSource$1.label = 1;
                    if (clearSource$lifecycle_livedata_ktx_release(coroutineLiveData$emitSource$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    liveData2 = liveData;
                    coroutineLiveData = this;
                } else if (i != 1) {
                    if (i == 2) {
                        LiveData liveData3 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                        coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        EmittedSource emittedSource = (EmittedSource) obj;
                        coroutineLiveData.emittedSource = emittedSource;
                        return emittedSource;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ResultKt.throwOnFailure(obj);
                    liveData2 = (LiveData) coroutineLiveData$emitSource$1.L$1;
                    coroutineLiveData = (CoroutineLiveData) coroutineLiveData$emitSource$1.L$0;
                }
                coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
                coroutineLiveData$emitSource$1.L$1 = liveData2;
                coroutineLiveData$emitSource$1.label = 2;
                obj = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                EmittedSource emittedSource2 = (EmittedSource) obj;
                coroutineLiveData.emittedSource = emittedSource2;
                return emittedSource2;
            }
        }
        coroutineLiveData$emitSource$1 = new CoroutineLiveData$emitSource$1(this, continuation);
        obj = coroutineLiveData$emitSource$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = coroutineLiveData$emitSource$1.label;
        if (i != 0) {
        }
        coroutineLiveData$emitSource$1.L$0 = coroutineLiveData;
        coroutineLiveData$emitSource$1.L$1 = liveData2;
        coroutineLiveData$emitSource$1.label = 2;
        obj = CoroutineLiveDataKt.addDisposableSource(coroutineLiveData, liveData2, coroutineLiveData$emitSource$1);
        if (obj == coroutine_suspended) {
        }
        EmittedSource emittedSource22 = (EmittedSource) obj;
        coroutineLiveData.emittedSource = emittedSource22;
        return emittedSource22;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object clearSource$lifecycle_livedata_ktx_release(Continuation<? super Unit> continuation) {
        CoroutineLiveData$clearSource$1 coroutineLiveData$clearSource$1;
        int i;
        CoroutineLiveData<T> coroutineLiveData;
        if (continuation instanceof CoroutineLiveData$clearSource$1) {
            coroutineLiveData$clearSource$1 = (CoroutineLiveData$clearSource$1) continuation;
            if ((coroutineLiveData$clearSource$1.label & Integer.MIN_VALUE) != 0) {
                coroutineLiveData$clearSource$1.label -= Integer.MIN_VALUE;
                Object obj = coroutineLiveData$clearSource$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = coroutineLiveData$clearSource$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    EmittedSource emittedSource = this.emittedSource;
                    if (emittedSource == null) {
                        coroutineLiveData = this;
                        coroutineLiveData.emittedSource = null;
                        return Unit.INSTANCE;
                    }
                    coroutineLiveData$clearSource$1.L$0 = this;
                    coroutineLiveData$clearSource$1.label = 1;
                    obj = emittedSource.disposeNow(coroutineLiveData$clearSource$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineLiveData = this;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    coroutineLiveData = (CoroutineLiveData) coroutineLiveData$clearSource$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Unit unit = (Unit) obj;
                coroutineLiveData.emittedSource = null;
                return Unit.INSTANCE;
            }
        }
        coroutineLiveData$clearSource$1 = new CoroutineLiveData$clearSource$1(this, continuation);
        Object obj2 = coroutineLiveData$clearSource$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = coroutineLiveData$clearSource$1.label;
        if (i != 0) {
        }
        Unit unit2 = (Unit) obj2;
        coroutineLiveData.emittedSource = null;
        return Unit.INSTANCE;
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    protected void onActive() {
        super.onActive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.maybeRun();
        }
    }

    @Override // androidx.lifecycle.MediatorLiveData, androidx.lifecycle.LiveData
    protected void onInactive() {
        super.onInactive();
        BlockRunner<T> blockRunner = this.blockRunner;
        if (blockRunner != null) {
            blockRunner.cancel();
        }
    }
}
