package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FlowLiveData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0, 0, 1, 1, 1, 2, 2, 2, 2}, l = {91, 95, 96}, m = "invokeSuspend", n = {"$this$flow", "channel", "observer", "$this$flow", "channel", "observer", "$this$flow", "channel", "observer", "value"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"})
/* loaded from: classes.dex */
final class FlowLiveDataConversions$asFlow$1<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveData $this_asFlow;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    private FlowCollector p$;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FlowLiveDataConversions$asFlow$1(LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.$this_asFlow = liveData;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
        Intrinsics.checkParameterIsNotNull(completion, "completion");
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.$this_asFlow, completion);
        flowLiveDataConversions$asFlow$1.p$ = (FlowCollector) obj;
        return flowLiveDataConversions$asFlow$1;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((FlowLiveDataConversions$asFlow$1) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:36:0x00f3 */
    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(4:(1:(2:33|(1:(7:36|37|38|19|8|9|(1:11)(4:13|14|15|(6:17|(1:20)|19|8|9|(0)(0))(2:21|22)))(2:39|40))(6:41|42|43|14|15|(0)(0)))(1:4))(2:46|(1:48)(1:49))|8|9|(0)(0))|5|6|7|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00f7, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f8, code lost:
        r9 = r17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00bb A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #0 {all -> 0x00f3, blocks: (B:29:0x00b3, B:31:0x00bb), top: B:45:0x00b3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d2  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [androidx.lifecycle.Observer] */
    /* JADX WARN: Type inference failed for: r5v7, types: [androidx.lifecycle.Observer, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x0028 -> B:47:0x009b). Please submit an issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        FlowCollector flowCollector;
        Channel channel;
        Observer<T> observer;
        FlowLiveDataConversions$asFlow$1<T> flowLiveDataConversions$asFlow$1;
        Throwable th;
        FlowCollector flowCollector2;
        Channel channel2;
        ChannelIterator channelIterator;
        ChannelIterator channelIterator2;
        Object obj2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        ?? r5 = 1;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                flowCollector = this.p$;
                final Channel Channel = ChannelKt.Channel(-1);
                Observer<T> observer2 = new Observer<T>() { // from class: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(T t) {
                        Channel.this.offer(t);
                    }
                };
                this.L$0 = flowCollector;
                this.L$1 = Channel;
                this.L$2 = observer2;
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new AnonymousClass1(observer2, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                channel = Channel;
                observer = observer2;
            } else if (i != 1) {
                try {
                    if (i == 2) {
                        channelIterator = (ChannelIterator) this.L$3;
                        Observer observer3 = (Observer) this.L$2;
                        channel2 = (Channel) this.L$1;
                        flowCollector2 = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        obj2 = obj;
                        flowLiveDataConversions$asFlow$1 = this;
                        r5 = observer3;
                        if (((Boolean) obj2).booleanValue()) {
                        }
                    } else if (i != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        channelIterator = (ChannelIterator) this.L$4;
                        Observer<T> observer4 = (Observer) this.L$2;
                        channel2 = (Channel) this.L$1;
                        flowCollector2 = (FlowCollector) this.L$0;
                        ResultKt.throwOnFailure(obj);
                        flowLiveDataConversions$asFlow$1 = this;
                        Observer<T> observer5 = observer4;
                        FlowCollector flowCollector3 = flowCollector2;
                        channelIterator2 = channelIterator;
                        observer = observer5;
                        channel = channel2;
                        flowCollector = flowCollector3;
                        flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                        flowLiveDataConversions$asFlow$1.L$1 = channel;
                        flowLiveDataConversions$asFlow$1.L$2 = observer;
                        flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
                        flowLiveDataConversions$asFlow$1.label = 2;
                        obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                        if (obj2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        Channel channel3 = channel;
                        r5 = observer;
                        channelIterator = channelIterator2;
                        flowCollector2 = flowCollector;
                        channel2 = channel3;
                        try {
                            if (((Boolean) obj2).booleanValue()) {
                                BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
                                return Unit.INSTANCE;
                            }
                            Object next = channelIterator.next();
                            flowLiveDataConversions$asFlow$1.L$0 = flowCollector2;
                            flowLiveDataConversions$asFlow$1.L$1 = channel2;
                            flowLiveDataConversions$asFlow$1.L$2 = r5;
                            flowLiveDataConversions$asFlow$1.L$3 = next;
                            flowLiveDataConversions$asFlow$1.L$4 = channelIterator;
                            flowLiveDataConversions$asFlow$1.label = 3;
                            observer5 = r5;
                            if (flowCollector2.emit(next, flowLiveDataConversions$asFlow$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            FlowCollector flowCollector32 = flowCollector2;
                            channelIterator2 = channelIterator;
                            observer = observer5;
                            channel = channel2;
                            flowCollector = flowCollector32;
                            flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
                            flowLiveDataConversions$asFlow$1.L$1 = channel;
                            flowLiveDataConversions$asFlow$1.L$2 = observer;
                            flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
                            flowLiveDataConversions$asFlow$1.label = 2;
                            obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
                            if (obj2 == coroutine_suspended) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    flowLiveDataConversions$asFlow$1 = this;
                    BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
                    throw th;
                }
            } else {
                observer = (Observer) this.L$2;
                channel = (Channel) this.L$1;
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            flowLiveDataConversions$asFlow$1.L$0 = flowCollector;
            flowLiveDataConversions$asFlow$1.L$1 = channel;
            flowLiveDataConversions$asFlow$1.L$2 = observer;
            flowLiveDataConversions$asFlow$1.L$3 = channelIterator2;
            flowLiveDataConversions$asFlow$1.label = 2;
            obj2 = channelIterator2.hasNext(flowLiveDataConversions$asFlow$1);
            if (obj2 == coroutine_suspended) {
            }
        } catch (Throwable th4) {
            th = th4;
            r5 = observer;
            BuildersKt__Builders_commonKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain().getImmediate(), null, new AnonymousClass2(r5, null), 2, null);
            throw th;
        }
        channelIterator2 = channel.iterator();
        flowLiveDataConversions$asFlow$1 = this;
    }

    /* compiled from: FlowLiveData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Observer $observer;
        int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Observer observer, Continuation continuation) {
            super(2, continuation);
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$observer, completion);
            anonymousClass1.p$ = (CoroutineScope) obj;
            return anonymousClass1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FlowLiveDataConversions$asFlow$1.this.$this_asFlow.observeForever(this.$observer);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* compiled from: FlowLiveData.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 1, 15})
    @DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2", f = "FlowLiveData.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2  reason: invalid class name */
    /* loaded from: classes.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Observer $observer;
        int label;
        private CoroutineScope p$;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Observer observer, Continuation continuation) {
            super(2, continuation);
            this.$observer = observer;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> completion) {
            Intrinsics.checkParameterIsNotNull(completion, "completion");
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$observer, completion);
            anonymousClass2.p$ = (CoroutineScope) obj;
            return anonymousClass2;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                FlowLiveDataConversions$asFlow$1.this.$this_asFlow.removeObserver(this.$observer);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
