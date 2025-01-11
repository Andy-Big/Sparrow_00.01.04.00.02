package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: Collection.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u0010\u0001*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a7\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\n\u001a7\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\rH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, d2 = {"toCollection", "C", ExifInterface.GPS_DIRECTION_TRUE, "", "Lkotlinx/coroutines/flow/Flow;", "destination", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toList", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", "", "", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
final /* synthetic */ class FlowKt__CollectionKt {
    public static final <T> Object toList(Flow<? extends T> flow, List<T> list, Continuation<? super List<? extends T>> continuation) {
        return FlowKt.toCollection(flow, list, continuation);
    }

    public static /* synthetic */ Object toList$default(Flow flow, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return FlowKt.toList(flow, list, continuation);
    }

    public static final <T> Object toSet(Flow<? extends T> flow, Set<T> set, Continuation<? super Set<? extends T>> continuation) {
        return FlowKt.toCollection(flow, set, continuation);
    }

    public static /* synthetic */ Object toSet$default(Flow flow, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return FlowKt.toSet(flow, set, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, C extends Collection<? super T>> Object toCollection(Flow<? extends T> flow, final C c, Continuation<? super C> continuation) {
        FlowKt__CollectionKt$toCollection$1 flowKt__CollectionKt$toCollection$1;
        int i;
        if (continuation instanceof FlowKt__CollectionKt$toCollection$1) {
            flowKt__CollectionKt$toCollection$1 = (FlowKt__CollectionKt$toCollection$1) continuation;
            if ((flowKt__CollectionKt$toCollection$1.label & Integer.MIN_VALUE) != 0) {
                flowKt__CollectionKt$toCollection$1.label -= Integer.MIN_VALUE;
                Object obj = flowKt__CollectionKt$toCollection$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = flowKt__CollectionKt$toCollection$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    flowKt__CollectionKt$toCollection$1.L$0 = flow;
                    flowKt__CollectionKt$toCollection$1.L$1 = c;
                    flowKt__CollectionKt$toCollection$1.L$2 = flow;
                    flowKt__CollectionKt$toCollection$1.label = 1;
                    return flow.collect(new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$$inlined$collect$1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public Object emit(Object obj2, Continuation continuation2) {
                            c.add(obj2);
                            return Unit.INSTANCE;
                        }
                    }, flowKt__CollectionKt$toCollection$1) == coroutine_suspended ? coroutine_suspended : c;
                } else if (i == 1) {
                    Flow flow2 = (Flow) flowKt__CollectionKt$toCollection$1.L$2;
                    Collection collection = (Collection) flowKt__CollectionKt$toCollection$1.L$1;
                    Flow flow3 = (Flow) flowKt__CollectionKt$toCollection$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    return collection;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        flowKt__CollectionKt$toCollection$1 = new FlowKt__CollectionKt$toCollection$1(continuation);
        Object obj2 = flowKt__CollectionKt$toCollection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = flowKt__CollectionKt$toCollection$1.label;
        if (i != 0) {
        }
    }
}
