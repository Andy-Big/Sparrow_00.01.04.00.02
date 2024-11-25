package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: Transform.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001aM\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\u001f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0006\b\u0000\u0010\n\u0018\u0001*\u0006\u0012\u0002\b\u00030\u0001H\u0086\b\u001aM\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\b\u0004\u0010\u0003\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001a\"\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0007*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\u001ab\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u000123\b\u0004\u0010\u000e\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001ah\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\n*\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u000125\b\u0004\u0010\u000e\u001a/\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\b\u001aH\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\"\u0010\u0014\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0004ø\u0001\u0000¢\u0006\u0002\u0010\b\u001a~\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\n0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0017\u001a\u0002H\n2H\b\u0001\u0010\u0018\u001aB\b\u0001\u0012\u0013\u0012\u0011H\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\n0\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001b\u001an\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012F\u0010\u0018\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0019H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u001d\u001a$\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u001f0\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"filter", "Lkotlinx/coroutines/flow/Flow;", ExifInterface.GPS_DIRECTION_TRUE, "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "filterIsInstance", "R", "filterNot", "filterNotNull", "map", "transform", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "value", "mapNotNull", "onEach", "action", "", "scan", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "scanReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "withIndex", "Lkotlin/collections/IndexedValue;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes2.dex */
public final /* synthetic */ class FlowKt__TransformKt {
    public static final <T> Flow<T> filter(Flow<? extends T> filter, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(filter, "$this$filter");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return new FlowKt__TransformKt$filter$$inlined$unsafeTransform$1(filter, predicate);
    }

    public static final <T> Flow<T> filterNot(Flow<? extends T> filterNot, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(filterNot, "$this$filterNot");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return new FlowKt__TransformKt$filterNot$$inlined$unsafeTransform$1(filterNot, predicate);
    }

    public static final /* synthetic */ <R> Flow<R> filterIsInstance(Flow<?> filterIsInstance) {
        Intrinsics.checkParameterIsNotNull(filterIsInstance, "$this$filterIsInstance");
        Intrinsics.needClassReification();
        return new FlowKt__TransformKt$filterIsInstance$$inlined$filter$1(filterIsInstance);
    }

    public static final <T> Flow<T> filterNotNull(final Flow<? extends T> filterNotNull) {
        Intrinsics.checkParameterIsNotNull(filterNotNull, "$this$filterNotNull");
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(final FlowCollector flowCollector, Continuation continuation) {
                return Flow.this.collect((FlowCollector) ((FlowCollector<T>) new FlowCollector<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$filterNotNull$$inlined$unsafeTransform$1.2
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(Object obj, Continuation continuation2) {
                        FlowCollector flowCollector2 = FlowCollector.this;
                        if (obj != null) {
                            return flowCollector2.emit(obj, continuation2);
                        }
                        return Unit.INSTANCE;
                    }
                }), continuation);
            }
        };
    }

    public static final <T, R> Flow<R> map(Flow<? extends T> map, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        Intrinsics.checkParameterIsNotNull(map, "$this$map");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return new FlowKt__TransformKt$map$$inlined$unsafeTransform$1(map, transform);
    }

    public static final <T, R> Flow<R> mapNotNull(Flow<? extends T> mapNotNull, Function2<? super T, ? super Continuation<? super R>, ? extends Object> transform) {
        Intrinsics.checkParameterIsNotNull(mapNotNull, "$this$mapNotNull");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return new FlowKt__TransformKt$mapNotNull$$inlined$unsafeTransform$1(mapNotNull, transform);
    }

    public static final <T> Flow<IndexedValue<T>> withIndex(final Flow<? extends T> withIndex) {
        Intrinsics.checkParameterIsNotNull(withIndex, "$this$withIndex");
        return (Flow) ((Flow<IndexedValue<? extends T>>) new Flow<IndexedValue<? extends T>>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1
            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = 0;
                return Flow.this.collect(new FlowKt__TransformKt$withIndex$$inlined$unsafeFlow$1$lambda$1(flowCollector, intRef), continuation);
            }
        });
    }

    public static final <T> Flow<T> onEach(final Flow<? extends T> onEach, final Function2<? super T, ? super Continuation<? super Unit>, ? extends Object> action) {
        Intrinsics.checkParameterIsNotNull(onEach, "$this$onEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        return new Flow<T>() { // from class: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1

            /* compiled from: Collect.kt */
            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u007f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\b"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$8", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1"}, k = 1, mv = {1, 1, 15})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2  reason: invalid class name */
            /* loaded from: classes2.dex */
            public static final class AnonymousClass2 implements FlowCollector<T> {
                final /* synthetic */ FlowCollector $this_unsafeFlow$inlined;
                final /* synthetic */ FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 this$0;

                @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0096@¨\u0006\t"}, d2 = {"emit", "", ExifInterface.GPS_DIRECTION_TRUE, "value", "continuation", "Lkotlin/coroutines/Continuation;", "", "kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3$emit$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$$special$$inlined$collect$8$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$unsafeTransform$$inlined$unsafeFlow$7$lambda$1$1"}, k = 3, mv = {1, 1, 15})
                @DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2", f = "Transform.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {137, 138}, m = "emit", n = {"this", "value", "continuation", "value", "continuation", "value", "$receiver", "this", "value", "continuation", "value", "continuation", "value", "$receiver"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6"})
                /* renamed from: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1  reason: invalid class name */
                /* loaded from: classes2.dex */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    Object L$1;
                    Object L$2;
                    Object L$3;
                    Object L$4;
                    Object L$5;
                    Object L$6;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector, FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 flowKt__TransformKt$onEach$$inlined$unsafeTransform$1) {
                    this.$this_unsafeFlow$inlined = flowCollector;
                    this.this$0 = flowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
                }

                /* JADX WARN: Removed duplicated region for block: B:10:0x0025  */
                /* JADX WARN: Removed duplicated region for block: B:16:0x0065  */
                /* JADX WARN: Removed duplicated region for block: B:22:0x00a5 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:23:0x00a6 A[PHI: r11 
                  PHI: (r11v4 java.lang.Object) = (r11v3 java.lang.Object), (r11v1 java.lang.Object) binds: [B:21:0x00a3, B:12:0x0029] A[DONT_GENERATE, DONT_INLINE], RETURN] */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object emit(java.lang.Object r10, kotlin.coroutines.Continuation r11) {
                    /*
                        r9 = this;
                        boolean r0 = r11 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L14
                        r0 = r11
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.label
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r1 = r1 & r2
                        if (r1 == 0) goto L14
                        int r11 = r0.label
                        int r11 = r11 - r2
                        r0.label = r11
                        goto L19
                    L14:
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1
                        r0.<init>(r11)
                    L19:
                        java.lang.Object r11 = r0.result
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.label
                        r3 = 2
                        r4 = 1
                        if (r2 == 0) goto L65
                        if (r2 == r4) goto L4b
                        if (r2 != r3) goto L43
                        java.lang.Object r10 = r0.L$6
                        kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                        java.lang.Object r10 = r0.L$5
                        java.lang.Object r10 = r0.L$4
                        kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
                        java.lang.Object r10 = r0.L$3
                        java.lang.Object r10 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r10
                        java.lang.Object r10 = r0.L$1
                        java.lang.Object r10 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 r10 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2) r10
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto La6
                    L43:
                        java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                        java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                        r10.<init>(r11)
                        throw r10
                    L4b:
                        java.lang.Object r10 = r0.L$6
                        kotlinx.coroutines.flow.FlowCollector r10 = (kotlinx.coroutines.flow.FlowCollector) r10
                        java.lang.Object r2 = r0.L$5
                        java.lang.Object r4 = r0.L$4
                        kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                        java.lang.Object r5 = r0.L$3
                        java.lang.Object r6 = r0.L$2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2$1 r6 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.AnonymousClass1) r6
                        java.lang.Object r7 = r0.L$1
                        java.lang.Object r8 = r0.L$0
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1$2 r8 = (kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2) r8
                        kotlin.ResultKt.throwOnFailure(r11)
                        goto L8f
                    L65:
                        kotlin.ResultKt.throwOnFailure(r11)
                        kotlinx.coroutines.flow.FlowCollector r11 = r9.$this_unsafeFlow$inlined
                        r2 = r0
                        kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                        kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 r5 = r9.this$0
                        kotlin.jvm.functions.Function2 r5 = r2
                        r0.L$0 = r9
                        r0.L$1 = r10
                        r0.L$2 = r0
                        r0.L$3 = r10
                        r0.L$4 = r2
                        r0.L$5 = r10
                        r0.L$6 = r11
                        r0.label = r4
                        java.lang.Object r4 = r5.invoke(r10, r0)
                        if (r4 != r1) goto L88
                        return r1
                    L88:
                        r8 = r9
                        r5 = r10
                        r7 = r5
                        r6 = r0
                        r4 = r2
                        r2 = r7
                        r10 = r11
                    L8f:
                        r0.L$0 = r8
                        r0.L$1 = r7
                        r0.L$2 = r6
                        r0.L$3 = r5
                        r0.L$4 = r4
                        r0.L$5 = r2
                        r0.L$6 = r10
                        r0.label = r3
                        java.lang.Object r11 = r10.emit(r2, r0)
                        if (r11 != r1) goto La6
                        return r1
                    La6:
                        return r11
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                return Flow.this.collect(new AnonymousClass2(flowCollector, this), continuation);
            }
        };
    }

    public static final <T, R> Flow<R> scan(Flow<? extends T> scan, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> operation) {
        Intrinsics.checkParameterIsNotNull(scan, "$this$scan");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        return new FlowKt__TransformKt$scan$$inlined$unsafeFlow$1(scan, r, operation);
    }

    public static final <T> Flow<T> scanReduce(Flow<? extends T> scanReduce, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> operation) {
        Intrinsics.checkParameterIsNotNull(scanReduce, "$this$scanReduce");
        Intrinsics.checkParameterIsNotNull(operation, "operation");
        return new FlowKt__TransformKt$scanReduce$$inlined$unsafeFlow$1(scanReduce, operation);
    }
}
