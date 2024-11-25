package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.internal.Symbol;
/* compiled from: Combine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "value", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/internal/CombineKt$combineInternal$2$2$2"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel[] $channels$inlined;
    final /* synthetic */ int $i;
    final /* synthetic */ Boolean[] $isClosed$inlined;
    final /* synthetic */ Object[] $latestValues$inlined;
    final /* synthetic */ int $size$inlined;
    Object L$0;
    Object L$1;
    int label;
    private Object p$0;
    final /* synthetic */ CombineKt$combineInternal$2 this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1(int i, Continuation continuation, CombineKt$combineInternal$2 combineKt$combineInternal$2, int i2, Boolean[] boolArr, ReceiveChannel[] receiveChannelArr, Object[] objArr) {
        super(2, continuation);
        this.$i = i;
        this.this$0 = combineKt$combineInternal$2;
        this.$size$inlined = i2;
        this.$isClosed$inlined = boolArr;
        this.$channels$inlined = receiveChannelArr;
        this.$latestValues$inlined = objArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 = new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1(this.$i, completion, this.this$0, this.$size$inlined, this.$isClosed$inlined, this.$channels$inlined, this.$latestValues$inlined);
        combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1.p$0 = obj;
        return combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean z;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.p$0;
            Object[] objArr = this.$latestValues$inlined;
            objArr[this.$i] = obj2;
            int length = objArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    z = true;
                    break;
                }
                if (!Boxing.boxBoolean(objArr[i2] != null).booleanValue()) {
                    z = false;
                    break;
                }
                i2++;
            }
            if (z) {
                Object[] objArr2 = (Object[]) this.this$0.$arrayFactory.invoke();
                int i3 = this.$size$inlined;
                for (int i4 = 0; i4 < i3; i4++) {
                    Symbol symbol = NullSurrogateKt.NULL;
                    Object obj3 = this.$latestValues$inlined[i4];
                    if (obj3 == symbol) {
                        obj3 = null;
                    }
                    objArr2[i4] = obj3;
                }
                Function3 function3 = this.this$0.$transform;
                FlowCollector flowCollector = this.this$0.$this_combineInternal;
                if (objArr2 == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                this.L$0 = obj2;
                this.L$1 = objArr2;
                this.label = 1;
                if (function3.invoke(flowCollector, objArr2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            Object[] objArr3 = (Object[]) this.L$1;
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }
}
