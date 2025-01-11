package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* compiled from: WhileSelect.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\u00020\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b"}, d2 = {"whileSelect", "", "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class WhileSelectKt {
    /* JADX WARN: Can't wrap try/catch for region: R(9:9|10|(2:12|13)|15|16|17|18|(1:20)|(1:22)(9:23|10|(0)|15|16|17|18|(0)|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0049, code lost:
        r4 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
        r2.handleBuilderException(r4);
     */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x005c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0067  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005d -> B:26:0x005e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object whileSelect(Function1<? super SelectBuilder<? super Boolean>, Unit> function1, Continuation<? super Unit> continuation) {
        WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$1;
        int i;
        Object result;
        if (continuation instanceof WhileSelectKt$whileSelect$1) {
            whileSelectKt$whileSelect$1 = (WhileSelectKt$whileSelect$1) continuation;
            if ((whileSelectKt$whileSelect$1.label & Integer.MIN_VALUE) != 0) {
                whileSelectKt$whileSelect$1.label -= Integer.MIN_VALUE;
                Object obj = whileSelectKt$whileSelect$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = whileSelectKt$whileSelect$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    whileSelectKt$whileSelect$1.L$0 = function1;
                    whileSelectKt$whileSelect$1.label = 1;
                    WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$12 = whileSelectKt$whileSelect$1;
                    SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(whileSelectKt$whileSelect$12);
                    function1.invoke(selectBuilderImpl);
                    result = selectBuilderImpl.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    }
                    if (result == coroutine_suspended) {
                    }
                } else if (i == 1) {
                    function1 = (Function1) whileSelectKt$whileSelect$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    if (!((Boolean) obj).booleanValue()) {
                        return Unit.INSTANCE;
                    }
                    whileSelectKt$whileSelect$1.L$0 = function1;
                    whileSelectKt$whileSelect$1.label = 1;
                    WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$122 = whileSelectKt$whileSelect$1;
                    SelectBuilderImpl selectBuilderImpl2 = new SelectBuilderImpl(whileSelectKt$whileSelect$122);
                    function1.invoke(selectBuilderImpl2);
                    result = selectBuilderImpl2.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(whileSelectKt$whileSelect$122);
                    }
                    if (result == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = result;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                    whileSelectKt$whileSelect$1.L$0 = function1;
                    whileSelectKt$whileSelect$1.label = 1;
                    WhileSelectKt$whileSelect$1 whileSelectKt$whileSelect$1222 = whileSelectKt$whileSelect$1;
                    SelectBuilderImpl selectBuilderImpl22 = new SelectBuilderImpl(whileSelectKt$whileSelect$1222);
                    function1.invoke(selectBuilderImpl22);
                    result = selectBuilderImpl22.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    }
                    if (result == coroutine_suspended) {
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        whileSelectKt$whileSelect$1 = new WhileSelectKt$whileSelect$1(continuation);
        Object obj2 = whileSelectKt$whileSelect$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = whileSelectKt$whileSelect$1.label;
        if (i != 0) {
        }
    }

    private static final Object whileSelect$$forInline(Function1 function1, Continuation continuation) {
        Object result;
        do {
            InlineMarker.mark(0);
            SelectBuilderImpl selectBuilderImpl = new SelectBuilderImpl(continuation);
            try {
                function1.invoke(selectBuilderImpl);
            } catch (Throwable th) {
                selectBuilderImpl.handleBuilderException(th);
            }
            result = selectBuilderImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            InlineMarker.mark(1);
        } while (((Boolean) result).booleanValue());
        return Unit.INSTANCE;
    }
}
