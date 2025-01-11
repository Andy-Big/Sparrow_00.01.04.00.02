package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Errors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u008a@¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "cause", "", "attempt", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {0, 0, 0}, l = {126}, m = "invokeSuspend", n = {"$this$retryWhen", "cause", "attempt"}, s = {"L$0", "L$1", "J$0"})
/* loaded from: classes2.dex */
final class FlowKt__ErrorsKt$retry$3<T> extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Function2 $predicate;
    final /* synthetic */ long $retries;
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    private FlowCollector p$;
    private Throwable p$0;
    private long p$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowKt__ErrorsKt$retry$3(long j, Function2 function2, Continuation continuation) {
        super(4, continuation);
        this.$retries = j;
        this.$predicate = function2;
    }

    public final Continuation<Unit> create(FlowCollector<? super T> create, Throwable cause, long j, Continuation<? super Boolean> continuation) {
        Intrinsics.checkParameterIsNotNull(create, "$this$create");
        Intrinsics.checkParameterIsNotNull(cause, "cause");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.$retries, this.$predicate, continuation);
        flowKt__ErrorsKt$retry$3.p$ = create;
        flowKt__ErrorsKt$retry$3.p$0 = cause;
        flowKt__ErrorsKt$retry$3.p$1 = j;
        return flowKt__ErrorsKt$retry$3;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object, java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function4
    public final Object invoke(Object obj, Throwable th, Long l, Continuation<? super Boolean> continuation) {
        return ((FlowKt__ErrorsKt$retry$3) create((FlowCollector) obj, th, l.longValue(), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0045, code lost:
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L8;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        boolean z = true;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.p$;
            Throwable th = this.p$0;
            long j = this.p$1;
            if (j < this.$retries) {
                Function2 function2 = this.$predicate;
                this.L$0 = flowCollector;
                this.L$1 = th;
                this.J$0 = j;
                this.label = 1;
                obj = function2.invoke(th, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            z = false;
            return Boxing.boxBoolean(z);
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Throwable th2 = (Throwable) this.L$1;
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
    }
}
