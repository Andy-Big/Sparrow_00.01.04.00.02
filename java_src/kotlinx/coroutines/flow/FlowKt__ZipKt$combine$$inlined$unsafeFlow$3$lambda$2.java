package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Add missing generic type declarations: [R, T] */
/* compiled from: Zip.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0006H\u008a@¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__ZipKt$combine$5$2"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2", f = "Zip.kt", i = {0, 0}, l = {246}, m = "invokeSuspend", n = {"$receiver", "it"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2<R, T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    private FlowCollector p$;
    private Object[] p$0;
    final /* synthetic */ FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2(Continuation continuation, FlowKt__ZipKt$combine$$inlined$unsafeFlow$3 flowKt__ZipKt$combine$$inlined$unsafeFlow$3) {
        super(3, continuation);
        this.this$0 = flowKt__ZipKt$combine$$inlined$unsafeFlow$3;
    }

    public final Continuation<Unit> create(FlowCollector<? super R> create, T[] it, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(create, "$this$create");
        Intrinsics.checkParameterIsNotNull(it, "it");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2 flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2 = new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2(continuation, this.this$0);
        flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2.p$ = create;
        flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2.p$0 = it;
        return flowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Continuation<? super Unit> continuation) {
        return ((FlowKt__ZipKt$combine$$inlined$unsafeFlow$3$lambda$2) create((FlowCollector) obj, (Object[]) obj2, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.p$;
            Object[] objArr = this.p$0;
            Object invoke = this.this$0.$transform$inlined.invoke(objArr, this);
            this.L$0 = flowCollector;
            this.L$1 = objArr;
            this.label = 1;
            if (flowCollector.emit(invoke, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object[] objArr2 = (Object[]) this.L$1;
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend$$forInline(Object obj) {
        FlowCollector flowCollector = this.p$;
        Object invoke = this.this$0.$transform$inlined.invoke(this.p$0, this);
        InlineMarker.mark(0);
        flowCollector.emit(invoke, this);
        InlineMarker.mark(2);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }
}
