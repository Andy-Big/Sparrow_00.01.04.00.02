package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.selects.SelectBuilderImpl;

/* compiled from: Combine.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u00020\u0004H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "R", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$combineInternal$2", f = "Combine.kt", i = {0, 0, 0, 0, 0}, l = {146}, m = "invokeSuspend", n = {"$this$coroutineScope", "size", "channels", "latestValues", "isClosed"}, s = {"L$0", "I$0", "L$1", "L$2", "L$3"})
/* loaded from: classes2.dex */
final class CombineKt$combineInternal$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0 $arrayFactory;
    final /* synthetic */ Flow[] $flows;
    final /* synthetic */ FlowCollector $this_combineInternal;
    final /* synthetic */ Function3 $transform;
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private CoroutineScope p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CombineKt$combineInternal$2(FlowCollector flowCollector, Flow[] flowArr, Function0 function0, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.$this_combineInternal = flowCollector;
        this.$flows = flowArr;
        this.$arrayFactory = function0;
        this.$transform = function3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        CombineKt$combineInternal$2 combineKt$combineInternal$2 = new CombineKt$combineInternal$2(this.$this_combineInternal, this.$flows, this.$arrayFactory, this.$transform, completion);
        combineKt$combineInternal$2.p$ = (CoroutineScope) obj;
        return combineKt$combineInternal$2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CombineKt$combineInternal$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x013e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x013f -> B:50:0x0147). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        CombineKt$combineInternal$2 combineKt$combineInternal$2;
        CoroutineScope coroutineScope;
        int i;
        ReceiveChannel[] receiveChannelArr;
        Object[] objArr;
        Boolean[] boolArr;
        Object obj2;
        ReceiveChannel asFairChannel;
        int length;
        int i2;
        int i3;
        SelectBuilderImpl selectBuilderImpl;
        CombineKt$combineInternal$2 combineKt$combineInternal$22;
        CombineKt$combineInternal$2 combineKt$combineInternal$23;
        CoroutineScope coroutineScope2;
        int i4;
        ReceiveChannel[] receiveChannelArr2;
        Object result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        int i6 = 0;
        int i7 = 1;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope3 = this.p$;
            int length2 = this.$flows.length;
            ReceiveChannel[] receiveChannelArr3 = new ReceiveChannel[length2];
            for (int i8 = 0; i8 < length2; i8++) {
                asFairChannel = CombineKt.asFairChannel(coroutineScope3, this.$flows[Boxing.boxInt(i8).intValue()]);
                receiveChannelArr3[i8] = asFairChannel;
            }
            Object[] objArr2 = new Object[length2];
            Boolean[] boolArr2 = new Boolean[length2];
            for (int i9 = 0; i9 < length2; i9++) {
                Boxing.boxInt(i9).intValue();
                boolArr2[i9] = Boxing.boxBoolean(false);
            }
            combineKt$combineInternal$2 = this;
            coroutineScope = coroutineScope3;
            i = length2;
            receiveChannelArr = receiveChannelArr3;
            objArr = objArr2;
            boolArr = boolArr2;
            obj2 = coroutine_suspended;
            length = boolArr.length;
            i2 = i6;
            while (true) {
                if (i2 >= length) {
                }
                i2++;
            }
            if (i3 == 0) {
            }
        } else if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else {
            CombineKt$combineInternal$2 combineKt$combineInternal$24 = (CombineKt$combineInternal$2) this.L$4;
            int i10 = this.I$0;
            ResultKt.throwOnFailure(obj);
            combineKt$combineInternal$2 = this;
            boolArr = (Boolean[]) this.L$3;
            objArr = (Object[]) this.L$2;
            receiveChannelArr = (ReceiveChannel[]) this.L$1;
            i = i10;
            coroutineScope = (CoroutineScope) this.L$0;
            obj2 = coroutine_suspended;
            i6 = 0;
            i7 = 1;
            length = boolArr.length;
            i2 = i6;
            while (true) {
                if (i2 >= length) {
                    i3 = i7;
                    break;
                } else if (!Boxing.boxBoolean(boolArr[i2].booleanValue()).booleanValue()) {
                    i3 = i6;
                    break;
                } else {
                    i2++;
                }
            }
            if (i3 == 0) {
                combineKt$combineInternal$2.L$0 = coroutineScope;
                combineKt$combineInternal$2.I$0 = i;
                combineKt$combineInternal$2.L$1 = receiveChannelArr;
                combineKt$combineInternal$2.L$2 = objArr;
                combineKt$combineInternal$2.L$3 = boolArr;
                combineKt$combineInternal$2.L$4 = combineKt$combineInternal$2;
                combineKt$combineInternal$2.label = i7;
                CombineKt$combineInternal$2 combineKt$combineInternal$25 = combineKt$combineInternal$2;
                SelectBuilderImpl selectBuilderImpl2 = new SelectBuilderImpl(combineKt$combineInternal$25);
                try {
                } catch (Throwable th) {
                    th = th;
                    selectBuilderImpl = selectBuilderImpl2;
                    combineKt$combineInternal$22 = combineKt$combineInternal$25;
                    combineKt$combineInternal$23 = combineKt$combineInternal$2;
                    coroutineScope2 = coroutineScope;
                    i4 = i;
                }
                SelectBuilderImpl selectBuilderImpl3 = selectBuilderImpl2;
                int i11 = i6;
                while (i11 < i) {
                    boolean booleanValue = boolArr[i11].booleanValue();
                    ReceiveChannel receiveChannel = receiveChannelArr[i11];
                    int i12 = i11;
                    selectBuilderImpl = selectBuilderImpl2;
                    combineKt$combineInternal$22 = combineKt$combineInternal$25;
                    combineKt$combineInternal$23 = combineKt$combineInternal$2;
                    coroutineScope2 = coroutineScope;
                    i4 = i;
                    try {
                    } catch (Throwable th2) {
                        th = th2;
                        receiveChannelArr2 = receiveChannelArr;
                        selectBuilderImpl.handleBuilderException(th);
                        result = selectBuilderImpl.getResult();
                        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        }
                        if (result == obj2) {
                        }
                    }
                    CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1 = new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1(i11, null, combineKt$combineInternal$2, i, boolArr, receiveChannelArr, objArr);
                    if (booleanValue) {
                        receiveChannelArr2 = receiveChannelArr;
                    } else {
                        receiveChannelArr2 = receiveChannelArr;
                        try {
                        } catch (Throwable th3) {
                            th = th3;
                            selectBuilderImpl.handleBuilderException(th);
                            result = selectBuilderImpl.getResult();
                            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                            }
                            if (result == obj2) {
                            }
                        }
                        selectBuilderImpl3.invoke(receiveChannel.getOnReceiveOrNull(), new CombineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$2(combineKt$combineInternal$2$invokeSuspend$$inlined$select$lambda$1, null, i12, combineKt$combineInternal$23, i4, boolArr, receiveChannelArr, objArr));
                    }
                    i11 = i12 + 1;
                    selectBuilderImpl2 = selectBuilderImpl;
                    receiveChannelArr = receiveChannelArr2;
                    combineKt$combineInternal$25 = combineKt$combineInternal$22;
                    combineKt$combineInternal$2 = combineKt$combineInternal$23;
                    coroutineScope = coroutineScope2;
                    i = i4;
                }
                selectBuilderImpl = selectBuilderImpl2;
                combineKt$combineInternal$22 = combineKt$combineInternal$25;
                combineKt$combineInternal$23 = combineKt$combineInternal$2;
                coroutineScope2 = coroutineScope;
                i4 = i;
                receiveChannelArr2 = receiveChannelArr;
                result = selectBuilderImpl.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(combineKt$combineInternal$22);
                }
                if (result == obj2) {
                    return obj2;
                }
                receiveChannelArr = receiveChannelArr2;
                combineKt$combineInternal$2 = combineKt$combineInternal$23;
                coroutineScope = coroutineScope2;
                i = i4;
                i6 = 0;
                i7 = 1;
                length = boolArr.length;
                i2 = i6;
                while (true) {
                    if (i2 >= length) {
                    }
                    i2++;
                }
                if (i3 == 0) {
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
