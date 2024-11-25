package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Migration.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "e", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", f = "Migration.kt", i = {0, 0}, l = {316}, m = "invokeSuspend", n = {"$this$catch", "e"}, s = {"L$0", "L$1"})
/* loaded from: classes2.dex */
public final class FlowKt__MigrationKt$onErrorReturn$2<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ Object $fallback;
    final /* synthetic */ Function1 $predicate;
    Object L$0;
    Object L$1;
    int label;
    private FlowCollector p$;
    private Throwable p$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowKt__MigrationKt$onErrorReturn$2(Function1 function1, Object obj, Continuation continuation) {
        super(3, continuation);
        this.$predicate = function1;
        this.$fallback = obj;
    }

    public final Continuation<Unit> create(FlowCollector<? super T> create, Throwable e, Continuation<? super Unit> continuation) {
        Intrinsics.checkParameterIsNotNull(create, "$this$create");
        Intrinsics.checkParameterIsNotNull(e, "e");
        Intrinsics.checkParameterIsNotNull(continuation, "continuation");
        FlowKt__MigrationKt$onErrorReturn$2 flowKt__MigrationKt$onErrorReturn$2 = new FlowKt__MigrationKt$onErrorReturn$2(this.$predicate, this.$fallback, continuation);
        flowKt__MigrationKt$onErrorReturn$2.p$ = create;
        flowKt__MigrationKt$onErrorReturn$2.p$0 = e;
        return flowKt__MigrationKt$onErrorReturn$2;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Throwable th, Continuation<? super Unit> continuation) {
        return ((FlowKt__MigrationKt$onErrorReturn$2) create((FlowCollector) obj, th, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = this.p$;
            Throwable th = this.p$0;
            if (!((Boolean) this.$predicate.invoke(th)).booleanValue()) {
                throw th;
            }
            Object obj2 = this.$fallback;
            this.L$0 = flowCollector;
            this.L$1 = th;
            this.label = 1;
            if (flowCollector.emit(obj2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Throwable th2 = (Throwable) this.L$1;
            FlowCollector flowCollector2 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
