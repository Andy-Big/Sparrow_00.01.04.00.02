package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.internal.ConcurrentKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
/* compiled from: ArrayBroadcastChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00019B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010 \u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0017J\u0018\u0010 \u001a\u00020#2\u000e\u0010!\u001a\n\u0018\u00010$j\u0004\u0018\u0001`%H\u0016J\u0012\u0010&\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010'\u001a\u00020#H\u0002J\u0012\u0010(\u001a\u00020\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010)\u001a\u00020\u0015H\u0002J\u0015\u0010*\u001a\u00028\u00002\u0006\u0010+\u001a\u00020\u0015H\u0002¢\u0006\u0002\u0010,J\u0015\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010/J!\u00100\u001a\u00020\t2\u0006\u0010.\u001a\u00028\u00002\n\u00101\u001a\u0006\u0012\u0002\b\u000302H\u0014¢\u0006\u0002\u00103J\u000e\u00104\u001a\b\u0012\u0004\u0012\u00028\u000005H\u0016J-\u00106\u001a\u00020#2\u0010\b\u0002\u00107\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d2\u0010\b\u0002\u00108\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001dH\u0082\u0010R\u0018\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00178TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u001b\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d`\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/BroadcastChannel;", "capacity", "", "(I)V", "buffer", "", "", "[Ljava/lang/Object;", "bufferDebugString", "", "getBufferDebugString", "()Ljava/lang/String;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "getCapacity", "()I", "head", "", "isBufferAlwaysFull", "", "()Z", "isBufferFull", "size", "subscribers", "", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", "Lkotlinx/coroutines/internal/SubscribersList;", "tail", "cancel", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "checkSubOffers", "close", "computeMinHead", "elementAt", "index", "(J)Ljava/lang/Object;", "offerInternal", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "offerSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)Ljava/lang/Object;", "openSubscription", "Lkotlinx/coroutines/channels/ReceiveChannel;", "updateHead", "addSub", "removeSub", "Subscriber", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ArrayBroadcastChannel<E> extends AbstractSendChannel<E> implements BroadcastChannel<E> {
    private final Object[] buffer;
    private final ReentrantLock bufferLock;
    private final int capacity;
    private volatile long head;
    private volatile int size;
    private final List<Subscriber<E>> subscribers;
    private volatile long tail;

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected boolean isBufferAlwaysFull() {
        return false;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public ArrayBroadcastChannel(int i) {
        this.capacity = i;
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("ArrayBroadcastChannel capacity must be at least 1, but " + this.capacity + " was specified").toString());
        }
        this.bufferLock = new ReentrantLock();
        this.buffer = new Object[this.capacity];
        this.subscribers = ConcurrentKt.subscriberList();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public boolean isBufferFull() {
        return this.size >= this.capacity;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public ReceiveChannel<E> openSubscription() {
        Subscriber subscriber = new Subscriber(this);
        updateHead$default(this, subscriber, null, 2, null);
        return subscriber;
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel, kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable th) {
        if (super.close(th)) {
            checkSubOffers();
            return true;
        }
        return false;
    }

    @Override // kotlinx.coroutines.channels.BroadcastChannel
    public void cancel(CancellationException cancellationException) {
        cancel(cancellationException);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // kotlinx.coroutines.channels.BroadcastChannel
    /* renamed from: cancelInternal */
    public final boolean cancel(Throwable th) {
        boolean close = close(th);
        for (Subscriber<E> subscriber : this.subscribers) {
            subscriber.cancelInternal$kotlinx_coroutines_core(th);
        }
        return close;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object offerInternal(E e) {
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this.size;
            if (i >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            long j = this.tail;
            this.buffer[(int) (j % this.capacity)] = e;
            this.size = i + 1;
            this.tail = j + 1;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public Object offerSelectInternal(E e, SelectInstance<?> select) {
        Intrinsics.checkParameterIsNotNull(select, "select");
        ReentrantLock reentrantLock = this.bufferLock;
        reentrantLock.lock();
        try {
            Closed<?> closedForSend = getClosedForSend();
            if (closedForSend != null) {
                return closedForSend;
            }
            int i = this.size;
            if (i >= this.capacity) {
                return AbstractChannelKt.OFFER_FAILED;
            }
            if (!select.trySelect(null)) {
                return SelectKt.getALREADY_SELECTED();
            }
            long j = this.tail;
            this.buffer[(int) (j % this.capacity)] = e;
            this.size = i + 1;
            this.tail = j + 1;
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            checkSubOffers();
            return AbstractChannelKt.OFFER_SUCCESS;
        } finally {
            reentrantLock.unlock();
        }
    }

    private final void checkSubOffers() {
        boolean z = false;
        boolean z2 = false;
        for (Subscriber<E> subscriber : this.subscribers) {
            if (subscriber.checkOffer()) {
                z = true;
            }
            z2 = true;
        }
        if (z || !z2) {
            updateHead$default(this, null, null, 3, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void updateHead$default(ArrayBroadcastChannel arrayBroadcastChannel, Subscriber subscriber, Subscriber subscriber2, int i, Object obj) {
        if ((i & 1) != 0) {
            subscriber = null;
        }
        if ((i & 2) != 0) {
            subscriber2 = null;
        }
        arrayBroadcastChannel.updateHead(subscriber, subscriber2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b6, code lost:
        throw new kotlin.TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.Send");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void updateHead(kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> r12, kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber<E> r13) {
        /*
            r11 = this;
            r0 = 0
        L1:
            r1 = r0
            kotlinx.coroutines.channels.Send r1 = (kotlinx.coroutines.channels.Send) r1
            java.util.concurrent.locks.ReentrantLock r1 = r11.bufferLock
            java.util.concurrent.locks.Lock r1 = (java.util.concurrent.locks.Lock) r1
            r1.lock()
            if (r12 == 0) goto L25
            long r2 = r11.tail     // Catch: java.lang.Throwable -> L22
            r12.subHead = r2     // Catch: java.lang.Throwable -> L22
            java.util.List<kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber<E>> r2 = r11.subscribers     // Catch: java.lang.Throwable -> L22
            boolean r2 = r2.isEmpty()     // Catch: java.lang.Throwable -> L22
            java.util.List<kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber<E>> r3 = r11.subscribers     // Catch: java.lang.Throwable -> L22
            r3.add(r12)     // Catch: java.lang.Throwable -> L22
            if (r2 != 0) goto L25
            r1.unlock()
            return
        L22:
            r12 = move-exception
            goto Lbb
        L25:
            if (r13 == 0) goto L38
            java.util.List<kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber<E>> r12 = r11.subscribers     // Catch: java.lang.Throwable -> L22
            r12.remove(r13)     // Catch: java.lang.Throwable -> L22
            long r2 = r11.head     // Catch: java.lang.Throwable -> L22
            long r12 = r13.subHead     // Catch: java.lang.Throwable -> L22
            int r12 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r12 == 0) goto L38
            r1.unlock()
            return
        L38:
            long r12 = r11.computeMinHead()     // Catch: java.lang.Throwable -> L22
            long r2 = r11.tail     // Catch: java.lang.Throwable -> L22
            long r4 = r11.head     // Catch: java.lang.Throwable -> L22
            long r12 = kotlin.ranges.RangesKt.coerceAtMost(r12, r2)     // Catch: java.lang.Throwable -> L22
            int r6 = (r12 > r4 ? 1 : (r12 == r4 ? 0 : -1))
            if (r6 > 0) goto L4c
            r1.unlock()
            return
        L4c:
            int r6 = r11.size     // Catch: java.lang.Throwable -> L22
        L4e:
            int r7 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r7 >= 0) goto Lb7
            java.lang.Object[] r7 = r11.buffer     // Catch: java.lang.Throwable -> L22
            int r8 = r11.capacity     // Catch: java.lang.Throwable -> L22
            long r8 = (long) r8     // Catch: java.lang.Throwable -> L22
            long r8 = r4 % r8
            int r8 = (int) r8     // Catch: java.lang.Throwable -> L22
            r7[r8] = r0     // Catch: java.lang.Throwable -> L22
            int r7 = r11.capacity     // Catch: java.lang.Throwable -> L22
            if (r6 < r7) goto L62
            r7 = 1
            goto L63
        L62:
            r7 = 0
        L63:
            r8 = 1
            long r4 = r4 + r8
            r11.head = r4     // Catch: java.lang.Throwable -> L22
            int r6 = r6 + (-1)
            r11.size = r6     // Catch: java.lang.Throwable -> L22
            if (r7 == 0) goto L4e
        L6e:
            kotlinx.coroutines.channels.Send r7 = r11.takeFirstSendOrPeekClosed()     // Catch: java.lang.Throwable -> L22
            if (r7 == 0) goto L4e
            boolean r10 = r7 instanceof kotlinx.coroutines.channels.Closed     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L79
            goto L4e
        L79:
            if (r7 != 0) goto L7e
            kotlin.jvm.internal.Intrinsics.throwNpe()     // Catch: java.lang.Throwable -> L22
        L7e:
            java.lang.Object r10 = r7.tryResumeSend(r0)     // Catch: java.lang.Throwable -> L22
            if (r10 == 0) goto L6e
            java.lang.Object[] r12 = r11.buffer     // Catch: java.lang.Throwable -> L22
            int r13 = r11.capacity     // Catch: java.lang.Throwable -> L22
            long r4 = (long) r13     // Catch: java.lang.Throwable -> L22
            long r4 = r2 % r4
            int r13 = (int) r4     // Catch: java.lang.Throwable -> L22
            if (r7 == 0) goto Laf
            java.lang.Object r4 = r7.getPollResult()     // Catch: java.lang.Throwable -> L22
            r12[r13] = r4     // Catch: java.lang.Throwable -> L22
            int r6 = r6 + 1
            r11.size = r6     // Catch: java.lang.Throwable -> L22
            long r2 = r2 + r8
            r11.tail = r2     // Catch: java.lang.Throwable -> L22
            kotlin.Unit r12 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L22
            r1.unlock()
            if (r7 != 0) goto La5
            kotlin.jvm.internal.Intrinsics.throwNpe()
        La5:
            r7.completeResumeSend(r10)
            r11.checkSubOffers()
            r12 = r0
            r13 = r12
            goto L1
        Laf:
            kotlin.TypeCastException r12 = new kotlin.TypeCastException     // Catch: java.lang.Throwable -> L22
            java.lang.String r13 = "null cannot be cast to non-null type kotlinx.coroutines.channels.Send"
            r12.<init>(r13)     // Catch: java.lang.Throwable -> L22
            throw r12     // Catch: java.lang.Throwable -> L22
        Lb7:
            r1.unlock()
            return
        Lbb:
            r1.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.updateHead(kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber, kotlinx.coroutines.channels.ArrayBroadcastChannel$Subscriber):void");
    }

    private final long computeMinHead() {
        long j = LongCompanionObject.MAX_VALUE;
        for (Subscriber<E> subscriber : this.subscribers) {
            j = RangesKt.coerceAtMost(j, subscriber.subHead);
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final E elementAt(long j) {
        return (E) this.buffer[(int) (j % this.capacity)];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: ArrayBroadcastChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0017\u0010\u0012\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0010¢\u0006\u0002\b\u0015J\u0006\u0010\u0016\u001a\u00020\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\n\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\n\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u0016\u0010\u001d\u001a\u0004\u0018\u00010\u001b2\n\u0010\u001e\u001a\u0006\u0012\u0002\b\u00030\u001fH\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\n\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\f\u001a\u00020\b8TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\tR\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00060\u0010j\u0002`\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lkotlinx/coroutines/channels/ArrayBroadcastChannel$Subscriber;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "broadcastChannel", "Lkotlinx/coroutines/channels/ArrayBroadcastChannel;", "(Lkotlinx/coroutines/channels/ArrayBroadcastChannel;)V", "isBufferAlwaysEmpty", "", "()Z", "isBufferAlwaysFull", "isBufferEmpty", "isBufferFull", "subHead", "", "subLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Lkotlinx/coroutines/internal/ReentrantLock;", "cancelInternal", "cause", "", "cancelInternal$kotlinx_coroutines_core", "checkOffer", "clearBuffer", "", "needsToCheckOfferWithoutLock", "peekUnderLock", "", "pollInternal", "pollSelectInternal", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class Subscriber<E> extends AbstractChannel<E> implements ReceiveChannel<E> {
        private final ArrayBroadcastChannel<E> broadcastChannel;
        public volatile long subHead;
        private final ReentrantLock subLock;

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected boolean isBufferAlwaysEmpty() {
            return false;
        }

        public Subscriber(ArrayBroadcastChannel<E> broadcastChannel) {
            Intrinsics.checkParameterIsNotNull(broadcastChannel, "broadcastChannel");
            this.broadcastChannel = broadcastChannel;
            this.subLock = new ReentrantLock();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean isBufferEmpty() {
            return this.subHead >= ((ArrayBroadcastChannel) this.broadcastChannel).tail;
        }

        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        protected boolean isBufferAlwaysFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.channels.AbstractSendChannel
        public boolean isBufferFull() {
            throw new IllegalStateException("Should not be used".toString());
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        public boolean cancelInternal$kotlinx_coroutines_core(Throwable th) {
            boolean close = close(th);
            if (close) {
                ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, this, 1, null);
            }
            clearBuffer();
            return close;
        }

        private final void clearBuffer() {
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                this.subHead = ((ArrayBroadcastChannel) this.broadcastChannel).tail;
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean checkOffer() {
            Closed closed = null;
            boolean z = false;
            while (needsToCheckOfferWithoutLock() && this.subLock.tryLock()) {
                try {
                    E e = (E) peekUnderLock();
                    if (e != AbstractChannelKt.POLL_FAILED) {
                        if (e instanceof Closed) {
                            closed = (Closed) e;
                        } else {
                            ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = takeFirstReceiveOrPeekClosed();
                            if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
                                Object tryResumeReceive = takeFirstReceiveOrPeekClosed.tryResumeReceive(e, null);
                                if (tryResumeReceive != null) {
                                    this.subHead++;
                                    z = true;
                                    this.subLock.unlock();
                                    if (takeFirstReceiveOrPeekClosed == null) {
                                        Intrinsics.throwNpe();
                                    }
                                    takeFirstReceiveOrPeekClosed.completeResumeReceive(tryResumeReceive);
                                }
                            }
                        }
                        break;
                    }
                } finally {
                    this.subLock.unlock();
                }
            }
            if (closed != null) {
                close(closed.closeCause);
            }
            return z;
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0029  */
        /* JADX WARN: Removed duplicated region for block: B:17:0x002e  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x003a  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x003d  */
        @Override // kotlinx.coroutines.channels.AbstractChannel
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        protected java.lang.Object pollInternal() {
            /*
                r8 = this;
                java.util.concurrent.locks.ReentrantLock r0 = r8.subLock
                java.util.concurrent.locks.Lock r0 = (java.util.concurrent.locks.Lock) r0
                r0.lock()
                java.lang.Object r1 = r8.peekUnderLock()     // Catch: java.lang.Throwable -> L44
                boolean r2 = r1 instanceof kotlinx.coroutines.channels.Closed     // Catch: java.lang.Throwable -> L44
                r3 = 1
                if (r2 == 0) goto L11
                goto L15
            L11:
                java.lang.Object r2 = kotlinx.coroutines.channels.AbstractChannelKt.POLL_FAILED     // Catch: java.lang.Throwable -> L44
                if (r1 != r2) goto L17
            L15:
                r2 = 0
                goto L1f
            L17:
                long r4 = r8.subHead     // Catch: java.lang.Throwable -> L44
                r6 = 1
                long r4 = r4 + r6
                r8.subHead = r4     // Catch: java.lang.Throwable -> L44
                r2 = r3
            L1f:
                r0.unlock()
                boolean r0 = r1 instanceof kotlinx.coroutines.channels.Closed
                r4 = 0
                if (r0 != 0) goto L29
                r0 = r4
                goto L2a
            L29:
                r0 = r1
            L2a:
                kotlinx.coroutines.channels.Closed r0 = (kotlinx.coroutines.channels.Closed) r0
                if (r0 == 0) goto L33
                java.lang.Throwable r0 = r0.closeCause
                r8.close(r0)
            L33:
                boolean r0 = r8.checkOffer()
                if (r0 == 0) goto L3a
                goto L3b
            L3a:
                r3 = r2
            L3b:
                if (r3 == 0) goto L43
                kotlinx.coroutines.channels.ArrayBroadcastChannel<E> r0 = r8.broadcastChannel
                r2 = 3
                kotlinx.coroutines.channels.ArrayBroadcastChannel.updateHead$default(r0, r4, r4, r2, r4)
            L43:
                return r1
            L44:
                r1 = move-exception
                r0.unlock()
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.ArrayBroadcastChannel.Subscriber.pollInternal():java.lang.Object");
        }

        @Override // kotlinx.coroutines.channels.AbstractChannel
        protected Object pollSelectInternal(SelectInstance<?> select) {
            Intrinsics.checkParameterIsNotNull(select, "select");
            ReentrantLock reentrantLock = this.subLock;
            reentrantLock.lock();
            try {
                Object peekUnderLock = peekUnderLock();
                boolean z = false;
                if (!(peekUnderLock instanceof Closed) && peekUnderLock != AbstractChannelKt.POLL_FAILED) {
                    if (!select.trySelect(null)) {
                        peekUnderLock = SelectKt.getALREADY_SELECTED();
                    } else {
                        this.subHead++;
                        z = true;
                    }
                }
                reentrantLock.unlock();
                Closed closed = (Closed) (!(peekUnderLock instanceof Closed) ? null : peekUnderLock);
                if (closed != null) {
                    close(closed.closeCause);
                }
                if (checkOffer() ? true : z) {
                    ArrayBroadcastChannel.updateHead$default(this.broadcastChannel, null, null, 3, null);
                }
                return peekUnderLock;
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }

        private final boolean needsToCheckOfferWithoutLock() {
            if (getClosedForReceive() != null) {
                return false;
            }
            return (isBufferEmpty() && this.broadcastChannel.getClosedForReceive() == null) ? false : true;
        }

        private final Object peekUnderLock() {
            long j = this.subHead;
            Closed<?> closedForReceive = this.broadcastChannel.getClosedForReceive();
            if (j >= ((ArrayBroadcastChannel) this.broadcastChannel).tail) {
                if (closedForReceive == null) {
                    closedForReceive = getClosedForReceive();
                }
                return closedForReceive != null ? closedForReceive : AbstractChannelKt.POLL_FAILED;
            }
            Object elementAt = this.broadcastChannel.elementAt(j);
            Closed<?> closedForReceive2 = getClosedForReceive();
            return closedForReceive2 != null ? closedForReceive2 : elementAt;
        }
    }

    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    protected String getBufferDebugString() {
        return "(buffer:capacity=" + this.buffer.length + ",size=" + this.size + ')';
    }
}
