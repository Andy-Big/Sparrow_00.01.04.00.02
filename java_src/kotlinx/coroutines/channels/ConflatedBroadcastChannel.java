package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.internal.Symbol;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause2;
import kotlinx.coroutines.selects.SelectInstance;
/* compiled from: ConflatedBroadcastChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 B*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u0002:\u0004CBDEB\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0004\u0010\u0005B\u0007¢\u0006\u0004\b\u0004\u0010\u0006J?\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u00072\u0014\u0010\t\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0018\u00010\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0010\u001a\u00020\u00142\u000e\u0010\u000e\u001a\n\u0018\u00010\u0012j\u0004\u0018\u0001`\u0013H\u0016¢\u0006\u0004\b\u0010\u0010\u0015J\u0019\u0010\u0016\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0016\u0010\u0011J\u001d\u0010\u0017\u001a\u00020\u00142\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J)\u0010\u001c\u001a\u00020\u00142\u0018\u0010\u001b\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00140\u0019j\u0002`\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001e\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\u000f2\u0006\u0010 \u001a\u00028\u0000H\u0016¢\u0006\u0004\b!\u0010\"J\u0019\u0010$\u001a\u0004\u0018\u00010#2\u0006\u0010 \u001a\u00028\u0000H\u0002¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000&H\u0016¢\u0006\u0004\b'\u0010(JX\u00101\u001a\u00020\u0014\"\u0004\b\u0001\u0010)2\f\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00010*2\u0006\u0010 \u001a\u00028\u00002(\u00100\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000-\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010.\u0012\u0006\u0012\u0004\u0018\u00010/0,H\u0002ø\u0001\u0000¢\u0006\u0004\b1\u00102J?\u00103\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0018\u00010\u00072\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0002¢\u0006\u0004\b3\u0010\fJ\u001b\u00104\u001a\u00020\u00142\u0006\u0010 \u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u000f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u0016\u00108\u001a\u00020\u000f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b8\u00107R(\u0010<\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000-098V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u0019\u0010\u0003\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b?\u0010\u0006\u001a\u0004\b=\u0010>R\u0015\u0010A\u001a\u0004\u0018\u00018\u00008F@\u0006¢\u0006\u0006\u001a\u0004\b@\u0010>\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006F"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/BroadcastChannel;", "value", "<init>", "(Ljava/lang/Object;)V", "()V", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "list", "subscriber", "addSubscriber", "([Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "", "cause", "", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "", "(Ljava/util/concurrent/CancellationException;)V", "close", "closeSubscriber", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "Lkotlin/Function1;", "Lkotlinx/coroutines/channels/Handler;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "invokeOnCloseHandler", "(Ljava/lang/Throwable;)V", "element", "offer", "(Ljava/lang/Object;)Z", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "offerInternal", "(Ljava/lang/Object;)Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "openSubscription", "()Lkotlinx/coroutines/channels/ReceiveChannel;", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/Function2;", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlin/coroutines/Continuation;", "", "block", "registerSelectSend", "(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeSubscriber", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isClosedForSend", "()Z", "isFull", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "onSend", "getValue", "()Ljava/lang/Object;", "value$annotations", "getValueOrNull", "valueOrNull", "Companion", "Closed", "State", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ConflatedBroadcastChannel<E> implements BroadcastChannel<E> {
    private volatile Object _state;
    private volatile int _updating;
    private volatile Object onCloseHandler;
    private static final Companion Companion = new Companion(null);
    private static final Closed CLOSED = new Closed(null);
    private static final Symbol UNDEFINED = new Symbol("UNDEFINED");
    private static final State<Object> INITIAL_STATE = new State<>(UNDEFINED, null);
    private static final AtomicReferenceFieldUpdater _state$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "_state");
    private static final AtomicIntegerFieldUpdater _updating$FU = AtomicIntegerFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, "_updating");
    private static final AtomicReferenceFieldUpdater onCloseHandler$FU = AtomicReferenceFieldUpdater.newUpdater(ConflatedBroadcastChannel.class, Object.class, "onCloseHandler");

    public static /* synthetic */ void value$annotations() {
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isFull() {
        return false;
    }

    public ConflatedBroadcastChannel() {
        this._state = INITIAL_STATE;
        this._updating = 0;
        this.onCloseHandler = null;
    }

    public ConflatedBroadcastChannel(E e) {
        this();
        _state$FU.lazySet(this, new State(e, null));
    }

    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0005\u0010\u0002R\u0016\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\t8\u0002X\u0083\u0004¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u0002¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Companion;", "", "()V", "CLOSED", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "CLOSED$annotations", "INITIAL_STATE", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", "UNDEFINED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED$annotations", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    private static final class Companion {
        private static /* synthetic */ void CLOSED$annotations() {
        }

        private static /* synthetic */ void UNDEFINED$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0014\u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007R \u0010\u0004\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$State;", ExifInterface.LONGITUDE_EAST, "", "value", "subscribers", "", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "(Ljava/lang/Object;[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;)V", "[Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class State<E> {
        public final Subscriber<E>[] subscribers;
        public final Object value;

        public State(Object obj, Subscriber<E>[] subscriberArr) {
            this.value = obj;
            this.subscribers = subscriberArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Closed;", "", "closeCause", "", "(Ljava/lang/Throwable;)V", "sendException", "getSendException", "()Ljava/lang/Throwable;", "valueException", "getValueException", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class Closed {
        public final Throwable closeCause;

        public Closed(Throwable th) {
            this.closeCause = th;
        }

        public final Throwable getSendException() {
            Throwable th = this.closeCause;
            return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }

        public final Throwable getValueException() {
            Throwable th = this.closeCause;
            return th != null ? th : new IllegalStateException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
        }
    }

    public final E getValueOrNull() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            return null;
        }
        if (!(obj instanceof State)) {
            throw new IllegalStateException(("Invalid state " + obj).toString());
        }
        Symbol symbol = UNDEFINED;
        E e = (E) ((State) obj).value;
        if (e == symbol) {
            return null;
        }
        return e;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._state instanceof Closed;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Object obj;
        State state;
        Object obj2;
        Subscriber subscriber = new Subscriber(this);
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                subscriber.close(((Closed) obj).closeCause);
                return subscriber;
            } else if (obj instanceof State) {
                state = (State) obj;
                if (state.value != UNDEFINED) {
                    subscriber.offerInternal(state.value);
                }
                obj2 = state.value;
                if (obj != null) {
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                }
            } else {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(obj2, addSubscriber(state.subscribers, subscriber))));
        return subscriber;
    }

    private final Subscriber<E>[] addSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        if (subscriberArr == null) {
            Subscriber<E>[] subscriberArr2 = new Subscriber[1];
            for (int i = 0; i < 1; i++) {
                subscriberArr2[i] = subscriber;
            }
            return subscriberArr2;
        }
        return (Subscriber[]) ArraysKt.plus(subscriberArr, subscriber);
    }

    private final Subscriber<E>[] removeSubscriber(Subscriber<E>[] subscriberArr, Subscriber<E> subscriber) {
        int length = subscriberArr.length;
        int indexOf = ArraysKt.indexOf(subscriberArr, subscriber);
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(indexOf >= 0)) {
                throw new AssertionError();
            }
        }
        if (length == 1) {
            return null;
        }
        Subscriber<E>[] subscriberArr2 = new Subscriber[length - 1];
        ArraysKt.copyInto$default(subscriberArr, subscriberArr2, 0, 0, indexOf, 6, (Object) null);
        ArraysKt.copyInto$default(subscriberArr, subscriberArr2, indexOf, indexOf + 1, 0, 8, (Object) null);
        return subscriberArr2;
    }

    private final void invokeOnCloseHandler(Throwable th) {
        Object obj = this.onCloseHandler;
        if (obj == null || obj == AbstractChannelKt.HANDLER_INVOKED || !onCloseHandler$FU.compareAndSet(this, obj, AbstractChannelKt.HANDLER_INVOKED)) {
            return;
        }
        ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(obj, 1)).invoke(th);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        Intrinsics.checkParameterIsNotNull(handler, "handler");
        if (!onCloseHandler$FU.compareAndSet(this, null, handler)) {
            Object obj = this.onCloseHandler;
            if (obj == AbstractChannelKt.HANDLER_INVOKED) {
                throw new IllegalStateException("Another handler was already registered and successfully invoked");
            }
            throw new IllegalStateException("Another handler was already registered: " + obj);
        }
        Object obj2 = this._state;
        if ((obj2 instanceof Closed) && onCloseHandler$FU.compareAndSet(this, handler, AbstractChannelKt.HANDLER_INVOKED)) {
            handler.invoke(((Closed) obj2).closeCause);
        }
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException cancellationException) {
        cancel(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e, Continuation<? super Unit> continuation) {
        Closed offerInternal = offerInternal(e);
        if (offerInternal != null) {
            throw offerInternal.getSendException();
        }
        return Unit.INSTANCE;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean offer(E e) {
        Closed offerInternal = offerInternal(e);
        if (offerInternal == null) {
            return true;
        }
        throw offerInternal.getSendException();
    }

    private final Closed offerInternal(E e) {
        Object obj;
        if (_updating$FU.compareAndSet(this, 0, 1)) {
            do {
                try {
                    obj = this._state;
                    if (obj instanceof Closed) {
                        return (Closed) obj;
                    }
                    if (!(obj instanceof State)) {
                        throw new IllegalStateException(("Invalid state " + obj).toString());
                    } else if (obj == null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
                    }
                } finally {
                    this._updating = 0;
                }
            } while (!_state$FU.compareAndSet(this, obj, new State(e, ((State) obj).subscribers)));
            Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
            if (subscriberArr != null) {
                for (Subscriber<E> subscriber : subscriberArr) {
                    subscriber.offerInternal(e);
                }
            }
            return null;
        }
        return null;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, SendChannel<E>> getOnSend() {
        return (SelectClause2) ((SelectClause2<E, SendChannel<? super E>>) new SelectClause2<E, SendChannel<? super E>>() { // from class: kotlinx.coroutines.channels.ConflatedBroadcastChannel$onSend$1
            @Override // kotlinx.coroutines.selects.SelectClause2
            public <R> void registerSelectClause2(SelectInstance<? super R> select, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> block) {
                Intrinsics.checkParameterIsNotNull(select, "select");
                Intrinsics.checkParameterIsNotNull(block, "block");
                ConflatedBroadcastChannel.this.registerSelectSend(select, e, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectSend(SelectInstance<? super R> selectInstance, E e, Function2<? super SendChannel<? super E>, ? super Continuation<? super R>, ? extends Object> function2) {
        if (selectInstance.trySelect(null)) {
            Closed offerInternal = offerInternal(e);
            if (offerInternal != null) {
                selectInstance.resumeSelectCancellableWithException(offerInternal.getSendException());
            } else {
                UndispatchedKt.startCoroutineUnintercepted(function2, this, selectInstance.getCompletion());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ConflatedBroadcastChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0010¢\u0006\u0002\b\u000bJ\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0001H\u0016¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lkotlinx/coroutines/channels/ConflatedBroadcastChannel$Subscriber;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ConflatedChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;", "(Lkotlinx/coroutines/channels/ConflatedBroadcastChannel;)V", "cancelInternal", "", "cause", "", "cancelInternal$kotlinx_coroutines_core", "offerInternal", "", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class Subscriber<E> extends ConflatedChannel<E> implements ReceiveChannel<E> {
        private final ConflatedBroadcastChannel<E> broadcastChannel;

        public Subscriber(ConflatedBroadcastChannel<E> broadcastChannel) {
            Intrinsics.checkParameterIsNotNull(broadcastChannel, "broadcastChannel");
            this.broadcastChannel = broadcastChannel;
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean cancelInternal$kotlinx_coroutines_core(Throwable th) {
            boolean close = close(th);
            if (close) {
                this.broadcastChannel.closeSubscriber(this);
            }
            return close;
        }

        @Override // kotlinx.coroutines.channels.ConflatedChannel, kotlinx.coroutines.channels.AbstractSendChannel
        public Object offerInternal(E e) {
            return super.offerInternal(e);
        }
    }

    public final E getValue() {
        Object obj = this._state;
        if (obj instanceof Closed) {
            throw ((Closed) obj).getValueException();
        }
        if (obj instanceof State) {
            State state = (State) obj;
            if (state.value == UNDEFINED) {
                throw new IllegalStateException("No value");
            }
            return (E) state.value;
        }
        throw new IllegalStateException(("Invalid state " + obj).toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeSubscriber(Subscriber<E> subscriber) {
        Object obj;
        Object obj2;
        Subscriber<E>[] subscriberArr;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return;
            }
            if (!(obj instanceof State)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
            State state = (State) obj;
            obj2 = state.value;
            if (obj != null) {
                subscriberArr = state.subscribers;
                if (subscriberArr == null) {
                    Intrinsics.throwNpe();
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
            }
        } while (!_state$FU.compareAndSet(this, obj, new State(obj2, removeSubscriber(subscriberArr, subscriber))));
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: close */
    public boolean cancel(Throwable th) {
        Object obj;
        int i;
        do {
            obj = this._state;
            if (obj instanceof Closed) {
                return false;
            }
            if (!(obj instanceof State)) {
                throw new IllegalStateException(("Invalid state " + obj).toString());
            }
        } while (!_state$FU.compareAndSet(this, obj, th == null ? CLOSED : new Closed(th)));
        if (obj != null) {
            Subscriber<E>[] subscriberArr = ((State) obj).subscribers;
            if (subscriberArr != null) {
                for (Subscriber<E> subscriber : subscriberArr) {
                    subscriber.close(th);
                }
            }
            invokeOnCloseHandler(th);
            return true;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ConflatedBroadcastChannel.State<E>");
    }
}
