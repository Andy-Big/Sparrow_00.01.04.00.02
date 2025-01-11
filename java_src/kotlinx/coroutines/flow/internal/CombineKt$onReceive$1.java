package kotlinx.coroutines.flow.internal;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Combine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$onReceive$1", f = "Combine.kt", i = {0, 1}, l = {90, 90}, m = "invokeSuspend", n = {"it", "it"}, s = {"L$0", "L$0"})
/* loaded from: classes2.dex */
public final class CombineKt$onReceive$1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $onClosed;
    final /* synthetic */ Function2 $onReceive;
    Object L$0;
    int label;
    private Object p$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$onReceive$1(Function0 function0, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$onClosed = function0;
        this.$onReceive = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        CombineKt$onReceive$1 combineKt$onReceive$1 = new CombineKt$onReceive$1(this.$onClosed, this.$onReceive, completion);
        combineKt$onReceive$1.p$0 = obj;
        return combineKt$onReceive$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((CombineKt$onReceive$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003e A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.p$0;
            if (obj2 == null) {
                this.$onClosed.invoke();
            } else {
                Function2 function2 = this.$onReceive;
                this.L$0 = obj2;
                this.label = 2;
                this.L$0 = obj2;
                this.label = 1;
                obj = function2.invoke(obj2, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                if (obj == coroutine_suspended) {
                }
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i != 2) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    public final Object invokeSuspend$$forInline(Object obj) {
        Object obj2 = this.p$0;
        if (obj2 == null) {
            this.$onClosed.invoke();
        } else {
            Function2 function2 = this.$onReceive;
            InlineMarker.mark(0);
            function2.invoke(obj2, this);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
        }
        return Unit.INSTANCE;
    }
}
