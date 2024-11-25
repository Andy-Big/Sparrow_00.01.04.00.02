package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancelHandler;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DebugStringsKt;
import kotlinx.coroutines.DisposableHandle;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ValueOrClosed;
import kotlinx.coroutines.internal.LockFreeLinkedListHead;
import kotlinx.coroutines.internal.LockFreeLinkedListNode;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.coroutines.intrinsics.UndispatchedKt;
import kotlinx.coroutines.selects.SelectClause1;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.selects.SelectKt;
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b \u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0007IJKLMNOB\u0005¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0016\u0010\u0016\u001a\u00020\u00192\u000e\u0010\u0017\u001a\n\u0018\u00010\u001aj\u0004\u0018\u0001`\u001bJ\u0017\u0010\u001c\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0010¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u0019H\u0014J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000 H\u0004J\u0016\u0010!\u001a\u00020\u00062\f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000#H\u0002JR\u0010$\u001a\u00020\u0006\"\u0004\b\u0001\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0'2$\u0010(\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0+\u0012\u0006\u0012\u0004\u0018\u00010*0)2\u0006\u0010,\u001a\u00020-H\u0002ø\u0001\u0000¢\u0006\u0002\u0010.J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0086\u0002J\b\u00101\u001a\u00020\u0019H\u0014J\b\u00102\u001a\u00020\u0019H\u0014J\r\u00103\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u00104J\n\u00105\u001a\u0004\u0018\u00010*H\u0014J\u0016\u00106\u001a\u0004\u0018\u00010*2\n\u0010&\u001a\u0006\u0012\u0002\b\u00030'H\u0014J\u0011\u0010\"\u001a\u00028\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u00107J\u001a\u00108\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H\u0086@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u00107J\u0013\u00109\u001a\u0004\u0018\u00018\u0000H\u0086@ø\u0001\u0000¢\u0006\u0002\u00107J\u0019\u0010:\u001a\u0004\u0018\u00018\u00002\b\u0010;\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010<J\u0017\u0010=\u001a\u00028\u00002\b\u0010;\u001a\u0004\u0018\u00010*H\u0002¢\u0006\u0002\u0010<J\u001f\u0010>\u001a\u0002H%\"\u0004\b\u0001\u0010%2\u0006\u0010,\u001a\u00020-H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010?JH\u0010@\u001a\u00020\u0019\"\u0004\b\u0001\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0'2\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0+\u0012\u0006\u0012\u0004\u0018\u00010*0)H\u0002ø\u0001\u0000¢\u0006\u0002\u0010AJQ\u0010B\u001a\u00020\u0019\"\u0004\b\u0001\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0'2(\u0010(\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0+\u0012\u0006\u0012\u0004\u0018\u00010*0)H\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010AJJ\u0010C\u001a\u00020\u0019\"\u0004\b\u0001\u0010%2\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H%0'2$\u0010(\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H%0+\u0012\u0006\u0012\u0004\u0018\u00010*0)H\u0002ø\u0001\u0000¢\u0006\u0002\u0010AJ \u0010D\u001a\u00020\u00192\n\u0010E\u001a\u0006\u0012\u0002\b\u00030F2\n\u0010\"\u001a\u0006\u0012\u0002\b\u00030#H\u0002J\u0010\u0010G\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010HH\u0014R\u0014\u0010\u0005\u001a\u00020\u00068DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\bR\u0012\u0010\n\u001a\u00020\u0006X¤\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR\u0011\u0010\f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u000e8VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000e8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006P"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/AbstractSendChannel;", "Lkotlinx/coroutines/channels/Channel;", "()V", "hasReceiveOrClosed", "", "getHasReceiveOrClosed", "()Z", "isBufferAlwaysEmpty", "isBufferEmpty", "isClosedForReceive", "isEmpty", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "getOnReceiveOrClosed", "onReceiveOrNull", "getOnReceiveOrNull", "cancel", "cause", "", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancelInternal", "cancelInternal$kotlinx_coroutines_core", "cleanupSendQueueOnCancel", "describeTryPoll", "Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", "enqueueReceive", "receive", "Lkotlinx/coroutines/channels/Receive;", "enqueueReceiveSelect", "R", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)Z", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "onReceiveDequeued", "onReceiveEnqueued", "poll", "()Ljava/lang/Object;", "pollInternal", "pollSelectInternal", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrClosed", "receiveOrNull", "receiveOrNullResult", "result", "(Ljava/lang/Object;)Ljava/lang/Object;", "receiveResult", "receiveSuspend", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerSelectReceive", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectReceiveOrClosed", "registerSelectReceiveOrNull", "removeReceiveOnCancel", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "takeFirstReceiveOrPeekClosed", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "IdempotentTokenValue", "Itr", "ReceiveElement", "ReceiveHasNext", "ReceiveSelect", "RemoveReceiveOnCancel", "TryPollDesc", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public abstract class AbstractChannel<E> extends AbstractSendChannel<E> implements Channel<E> {
    protected abstract boolean isBufferAlwaysEmpty();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isBufferEmpty();

    protected void onReceiveDequeued() {
    }

    protected void onReceiveEnqueued() {
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    public /* synthetic */ void cancel() {
        cancel((CancellationException) null);
    }

    protected Object pollInternal() {
        Send takeFirstSendOrPeekClosed;
        Object tryResumeSend;
        do {
            takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                return AbstractChannelKt.POLL_FAILED;
            }
            tryResumeSend = takeFirstSendOrPeekClosed.tryResumeSend(null);
        } while (tryResumeSend == null);
        takeFirstSendOrPeekClosed.completeResumeSend(tryResumeSend);
        return takeFirstSendOrPeekClosed.getPollResult();
    }

    protected Object pollSelectInternal(SelectInstance<?> select) {
        Intrinsics.checkParameterIsNotNull(select, "select");
        TryPollDesc<E> describeTryPoll = describeTryPoll();
        Object performAtomicTrySelect = select.performAtomicTrySelect(describeTryPoll);
        if (performAtomicTrySelect != null) {
            return performAtomicTrySelect;
        }
        Send result = describeTryPoll.getResult();
        Object obj = describeTryPoll.resumeToken;
        if (obj == null) {
            Intrinsics.throwNpe();
        }
        result.completeResumeSend(obj);
        return describeTryPoll.pollResult;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean getHasReceiveOrClosed() {
        return getQueue().getNextNode() instanceof ReceiveOrClosed;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isClosedForReceive() {
        return getClosedForReceive() != null && isBufferEmpty();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final boolean isEmpty() {
        return !(getQueue().getNextNode() instanceof Send) && isBufferEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receive(Continuation<? super E> continuation) {
        Object pollInternal = pollInternal();
        return pollInternal != AbstractChannelKt.POLL_FAILED ? receiveResult(pollInternal) : receiveSuspend(0, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final E receiveResult(Object obj) {
        if (obj instanceof Closed) {
            throw StackTraceRecoveryKt.recoverStackTrace(((Closed) obj).getReceiveException());
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0054  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean enqueueReceive(kotlinx.coroutines.channels.Receive<? super E> r8) {
        /*
            r7 = this;
            boolean r0 = r7.isBufferAlwaysEmpty()
        */
        //  java.lang.String r1 = "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */"
        /*
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L2c
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r7.getQueue()
        Le:
            java.lang.Object r4 = r0.getPrev()
            if (r4 == 0) goto L26
            kotlinx.coroutines.internal.LockFreeLinkedListNode r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r4
            boolean r5 = r4 instanceof kotlinx.coroutines.channels.Send
            r5 = r5 ^ r3
            if (r5 != 0) goto L1c
            goto L52
        L1c:
            r5 = r8
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r5
            boolean r4 = r4.addNext(r5, r0)
            if (r4 == 0) goto Le
            goto L51
        L26:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            r8.<init>(r1)
            throw r8
        L2c:
            kotlinx.coroutines.internal.LockFreeLinkedListHead r0 = r7.getQueue()
            kotlinx.coroutines.channels.AbstractChannel$enqueueReceive$$inlined$addLastIfPrevAndIf$1 r4 = new kotlinx.coroutines.channels.AbstractChannel$enqueueReceive$$inlined$addLastIfPrevAndIf$1
            kotlinx.coroutines.internal.LockFreeLinkedListNode r8 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r8
            r4.<init>(r8)
            kotlinx.coroutines.internal.LockFreeLinkedListNode$CondAddOp r4 = (kotlinx.coroutines.internal.LockFreeLinkedListNode.CondAddOp) r4
        L39:
            java.lang.Object r5 = r0.getPrev()
            if (r5 == 0) goto L58
            kotlinx.coroutines.internal.LockFreeLinkedListNode r5 = (kotlinx.coroutines.internal.LockFreeLinkedListNode) r5
            boolean r6 = r5 instanceof kotlinx.coroutines.channels.Send
            r6 = r6 ^ r3
            if (r6 != 0) goto L47
            goto L52
        L47:
            int r5 = r5.tryCondAddNext(r8, r0, r4)
            if (r5 == r3) goto L51
            r6 = 2
            if (r5 == r6) goto L52
            goto L39
        L51:
            r2 = r3
        L52:
            if (r2 == 0) goto L57
            r7.onReceiveEnqueued()
        L57:
            return r2
        L58:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            r8.<init>(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.AbstractChannel.enqueueReceive(kotlinx.coroutines.channels.Receive):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receiveOrNull(Continuation<? super E> continuation) {
        Object pollInternal = pollInternal();
        return pollInternal != AbstractChannelKt.POLL_FAILED ? receiveOrNullResult(pollInternal) : receiveSuspend(1, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final E receiveOrNullResult(Object obj) {
        if (obj instanceof Closed) {
            Closed closed = (Closed) obj;
            if (closed.closeCause == null) {
                return null;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closed.closeCause);
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final Object receiveOrClosed(Continuation<? super ValueOrClosed<? extends E>> continuation) {
        Object m1349constructorimpl;
        Object pollInternal = pollInternal();
        if (pollInternal == AbstractChannelKt.POLL_FAILED) {
            return receiveSuspend(2, continuation);
        }
        if (!(pollInternal instanceof Closed)) {
            ValueOrClosed.Companion companion = ValueOrClosed.Companion;
            m1349constructorimpl = ValueOrClosed.m1349constructorimpl(pollInternal);
        } else {
            ValueOrClosed.Companion companion2 = ValueOrClosed.Companion;
            m1349constructorimpl = ValueOrClosed.m1349constructorimpl(new ValueOrClosed.Closed(((Closed) pollInternal).closeCause));
        }
        return ValueOrClosed.m1348boximpl(m1349constructorimpl);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final E poll() {
        Object pollInternal = pollInternal();
        if (pollInternal == AbstractChannelKt.POLL_FAILED) {
            return null;
        }
        return receiveOrNullResult(pollInternal);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final void cancel(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException(DebugStringsKt.getClassSimpleName(this) + " was cancelled");
        }
        cancel(cancellationException);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: cancelInternal$kotlinx_coroutines_core */
    public boolean cancel(Throwable th) {
        boolean close = close(th);
        cleanupSendQueueOnCancel();
        return close;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void cleanupSendQueueOnCancel() {
        Closed<?> closedForSend = getClosedForSend();
        if (closedForSend == null) {
            throw new IllegalStateException("Cannot happen".toString());
        }
        while (true) {
            Send takeFirstSendOrPeekClosed = takeFirstSendOrPeekClosed();
            if (takeFirstSendOrPeekClosed == null) {
                throw new IllegalStateException("Cannot happen".toString());
            }
            if (takeFirstSendOrPeekClosed instanceof Closed) {
                if (DebugKt.getASSERTIONS_ENABLED()) {
                    if (!(takeFirstSendOrPeekClosed == closedForSend)) {
                        throw new AssertionError();
                    }
                    return;
                }
                return;
            }
            takeFirstSendOrPeekClosed.resumeSendClosed(closedForSend);
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final ChannelIterator<E> iterator() {
        return new Itr(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final TryPollDesc<E> describeTryPoll() {
        return new TryPollDesc<>(getQueue());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u0000*\u0004\b\u0001\u0010\u00012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0014J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0003H\u0014R\u0016\u0010\b\u001a\u0004\u0018\u00018\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\tR\u0014\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$TryPollDesc;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$RemoveFirstDesc;", "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/internal/RemoveFirstDesc;", "queue", "Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "(Lkotlinx/coroutines/internal/LockFreeLinkedListHead;)V", "pollResult", "Ljava/lang/Object;", "resumeToken", "", "failure", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "validatePrepared", "", "node", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class TryPollDesc<E> extends LockFreeLinkedListNode.RemoveFirstDesc<Send> {
        public E pollResult;
        public Object resumeToken;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TryPollDesc(LockFreeLinkedListHead queue) {
            super(queue);
            Intrinsics.checkParameterIsNotNull(queue, "queue");
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc, kotlinx.coroutines.internal.LockFreeLinkedListNode.AbstractAtomicDesc
        protected Object failure(LockFreeLinkedListNode affected) {
            Intrinsics.checkParameterIsNotNull(affected, "affected");
            if (affected instanceof Closed) {
                return affected;
            }
            if (affected instanceof Send) {
                return null;
            }
            return AbstractChannelKt.POLL_FAILED;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode.RemoveFirstDesc
        public boolean validatePrepared(Send node) {
            Intrinsics.checkParameterIsNotNull(node, "node");
            Object tryResumeSend = node.tryResumeSend(this);
            if (tryResumeSend != null) {
                this.resumeToken = tryResumeSend;
                this.pollResult = (E) node.getPollResult();
                return true;
            }
            return false;
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<E> getOnReceive() {
        return new SelectClause1<E>() { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceive$1
            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(SelectInstance<? super R> select, Function2<? super E, ? super Continuation<? super R>, ? extends Object> block) {
                Intrinsics.checkParameterIsNotNull(select, "select");
                Intrinsics.checkParameterIsNotNull(block, "block");
                AbstractChannel.this.registerSelectReceive(select, block);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectReceive(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (!isEmpty()) {
                Object pollSelectInternal = pollSelectInternal(selectInstance);
                if (pollSelectInternal == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (pollSelectInternal != AbstractChannelKt.POLL_FAILED) {
                    if (pollSelectInternal instanceof Closed) {
                        throw StackTraceRecoveryKt.recoverStackTrace(((Closed) pollSelectInternal).getReceiveException());
                    }
                    UndispatchedKt.startCoroutineUnintercepted(function2, pollSelectInternal, selectInstance.getCompletion());
                    return;
                }
            } else if (function2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            } else {
                if (enqueueReceiveSelect(selectInstance, function2, 0)) {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public final SelectClause1<E> getOnReceiveOrNull() {
        return new SelectClause1<E>() { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveOrNull$1
            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(SelectInstance<? super R> select, Function2<? super E, ? super Continuation<? super R>, ? extends Object> block) {
                Intrinsics.checkParameterIsNotNull(select, "select");
                Intrinsics.checkParameterIsNotNull(block, "block");
                AbstractChannel.this.registerSelectReceiveOrNull(select, block);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectReceiveOrNull(SelectInstance<? super R> selectInstance, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (!isEmpty()) {
                Object pollSelectInternal = pollSelectInternal(selectInstance);
                if (pollSelectInternal == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (pollSelectInternal != AbstractChannelKt.POLL_FAILED) {
                    if (pollSelectInternal instanceof Closed) {
                        Closed closed = (Closed) pollSelectInternal;
                        if (closed.closeCause == null) {
                            if (selectInstance.trySelect(null)) {
                                UndispatchedKt.startCoroutineUnintercepted(function2, null, selectInstance.getCompletion());
                                return;
                            }
                            return;
                        }
                        throw StackTraceRecoveryKt.recoverStackTrace(closed.closeCause);
                    }
                    UndispatchedKt.startCoroutineUnintercepted(function2, pollSelectInternal, selectInstance.getCompletion());
                    return;
                }
            } else if (function2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            } else {
                if (enqueueReceiveSelect(selectInstance, function2, 1)) {
                    return;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed() {
        return (SelectClause1) ((SelectClause1<ValueOrClosed<? extends E>>) new SelectClause1<ValueOrClosed<? extends E>>() { // from class: kotlinx.coroutines.channels.AbstractChannel$onReceiveOrClosed$1
            @Override // kotlinx.coroutines.selects.SelectClause1
            public <R> void registerSelectClause1(SelectInstance<? super R> select, Function2<? super ValueOrClosed<? extends E>, ? super Continuation<? super R>, ? extends Object> block) {
                Intrinsics.checkParameterIsNotNull(select, "select");
                Intrinsics.checkParameterIsNotNull(block, "block");
                AbstractChannel.this.registerSelectReceiveOrClosed(select, block);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <R> void registerSelectReceiveOrClosed(SelectInstance<? super R> selectInstance, Function2<? super ValueOrClosed<? extends E>, ? super Continuation<? super R>, ? extends Object> function2) {
        while (!selectInstance.isSelected()) {
            if (!isEmpty()) {
                Object pollSelectInternal = pollSelectInternal(selectInstance);
                if (pollSelectInternal == SelectKt.getALREADY_SELECTED()) {
                    return;
                }
                if (pollSelectInternal == AbstractChannelKt.POLL_FAILED) {
                    continue;
                } else if (pollSelectInternal instanceof Closed) {
                    ValueOrClosed.Companion companion = ValueOrClosed.Companion;
                    UndispatchedKt.startCoroutineUnintercepted(function2, ValueOrClosed.m1348boximpl(ValueOrClosed.m1349constructorimpl(new ValueOrClosed.Closed(((Closed) pollSelectInternal).closeCause))), selectInstance.getCompletion());
                } else {
                    ValueOrClosed.Companion companion2 = ValueOrClosed.Companion;
                    UndispatchedKt.startCoroutineUnintercepted(function2, ValueOrClosed.m1348boximpl(ValueOrClosed.m1349constructorimpl(pollSelectInternal)), selectInstance.getCompletion());
                    return;
                }
            } else if (function2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type suspend (kotlin.Any?) -> R");
            } else {
                if (enqueueReceiveSelect(selectInstance, function2, 2)) {
                    return;
                }
            }
        }
    }

    private final <R> boolean enqueueReceiveSelect(SelectInstance<? super R> selectInstance, Function2<Object, ? super Continuation<? super R>, ? extends Object> function2, int i) {
        ReceiveSelect receiveSelect = new ReceiveSelect(this, selectInstance, function2, i);
        boolean enqueueReceive = enqueueReceive(receiveSelect);
        if (enqueueReceive) {
            selectInstance.disposeOnSelect(receiveSelect);
        }
        return enqueueReceive;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlinx.coroutines.channels.AbstractSendChannel
    public ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed() {
        ReceiveOrClosed<E> takeFirstReceiveOrPeekClosed = super.takeFirstReceiveOrPeekClosed();
        if (takeFirstReceiveOrPeekClosed != null && !(takeFirstReceiveOrPeekClosed instanceof Closed)) {
            onReceiveDequeued();
        }
        return takeFirstReceiveOrPeekClosed;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void removeReceiveOnCancel(CancellableContinuation<?> cancellableContinuation, Receive<?> receive) {
        cancellableContinuation.invokeOnCancellation(new RemoveReceiveOnCancel(this, receive));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$RemoveReceiveOnCancel;", "Lkotlinx/coroutines/CancelHandler;", "receive", "Lkotlinx/coroutines/channels/Receive;", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/channels/Receive;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public final class RemoveReceiveOnCancel extends CancelHandler {
        private final Receive<?> receive;
        final /* synthetic */ AbstractChannel this$0;

        public RemoveReceiveOnCancel(AbstractChannel abstractChannel, Receive<?> receive) {
            Intrinsics.checkParameterIsNotNull(receive, "receive");
            this.this$0 = abstractChannel;
            this.receive = receive;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
            invoke2(th);
            return Unit.INSTANCE;
        }

        @Override // kotlinx.coroutines.CancelHandlerBase
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public void invoke2(Throwable th) {
            if (this.receive.remove()) {
                this.this$0.onReceiveDequeued();
            }
        }

        public String toString() {
            return "RemoveReceiveOnCancel[" + this.receive + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0011\u0010\u000e\u001a\u00020\u000fH\u0096Bø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0002J\u0011\u0010\u0012\u001a\u00020\u000fH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0010J\u000e\u0010\u0013\u001a\u00028\u0001H\u0096\u0002¢\u0006\u0002\u0010\u000bR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$Itr;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/ChannelIterator;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "(Lkotlinx/coroutines/channels/AbstractChannel;)V", "getChannel", "()Lkotlinx/coroutines/channels/AbstractChannel;", "result", "", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "hasNext", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "hasNextResult", "hasNextSuspend", "next", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    private static final class Itr<E> implements ChannelIterator<E> {
        private final AbstractChannel<E> channel;
        private Object result;

        public Itr(AbstractChannel<E> channel) {
            Intrinsics.checkParameterIsNotNull(channel, "channel");
            this.channel = channel;
            this.result = AbstractChannelKt.POLL_FAILED;
        }

        public final AbstractChannel<E> getChannel() {
            return this.channel;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        public /* synthetic */ Object next(Continuation<? super E> continuation) {
            return ChannelIterator.DefaultImpls.next(this, continuation);
        }

        public final Object getResult() {
            return this.result;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public Object hasNext(Continuation<? super Boolean> continuation) {
            if (this.result != AbstractChannelKt.POLL_FAILED) {
                return Boxing.boxBoolean(hasNextResult(this.result));
            }
            Object pollInternal = this.channel.pollInternal();
            this.result = pollInternal;
            return pollInternal != AbstractChannelKt.POLL_FAILED ? Boxing.boxBoolean(hasNextResult(this.result)) : hasNextSuspend(continuation);
        }

        private final boolean hasNextResult(Object obj) {
            if (obj instanceof Closed) {
                Closed closed = (Closed) obj;
                if (closed.closeCause == null) {
                    return false;
                }
                throw StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException());
            }
            return true;
        }

        @Override // kotlinx.coroutines.channels.ChannelIterator
        public E next() {
            E e = (E) this.result;
            if (e instanceof Closed) {
                throw StackTraceRecoveryKt.recoverStackTrace(((Closed) e).getReceiveException());
            }
            if (e != AbstractChannelKt.POLL_FAILED) {
                this.result = AbstractChannelKt.POLL_FAILED;
                return e;
            }
            throw new IllegalStateException("'hasNext' should be called prior to 'next' invocation");
        }

        final /* synthetic */ Object hasNextSuspend(Continuation<? super Boolean> continuation) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
            CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ReceiveHasNext receiveHasNext = new ReceiveHasNext(this, cancellableContinuationImpl2);
            while (true) {
                ReceiveHasNext receiveHasNext2 = receiveHasNext;
                if (getChannel().enqueueReceive(receiveHasNext2)) {
                    getChannel().removeReceiveOnCancel(cancellableContinuationImpl2, receiveHasNext2);
                    break;
                }
                Object pollInternal = getChannel().pollInternal();
                setResult(pollInternal);
                if (pollInternal instanceof Closed) {
                    Closed closed = (Closed) pollInternal;
                    if (closed.closeCause == null) {
                        Boolean boxBoolean = Boxing.boxBoolean(false);
                        Result.Companion companion = Result.Companion;
                        cancellableContinuationImpl2.resumeWith(Result.m28constructorimpl(boxBoolean));
                    } else {
                        Throwable receiveException = closed.getReceiveException();
                        Result.Companion companion2 = Result.Companion;
                        cancellableContinuationImpl2.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(receiveException)));
                    }
                } else if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                    Boolean boxBoolean2 = Boxing.boxBoolean(true);
                    Result.Companion companion3 = Result.Companion;
                    cancellableContinuationImpl2.resumeWith(Result.m28constructorimpl(boxBoolean2));
                    break;
                }
            }
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00002\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0014\u0010\f\u001a\u00020\n2\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0016J\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00028\u0001¢\u0006\u0002\u0010\u0011J\b\u0010\u0012\u001a\u00020\u0013H\u0016J!\u0010\u0014\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0010\u001a\u00028\u00012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010\u0016R\u0018\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveElement;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "receiveMode", "", "(Lkotlinx/coroutines/CancellableContinuation;I)V", "completeResumeReceive", "", "token", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "resumeValue", "value", "(Ljava/lang/Object;)Ljava/lang/Object;", "toString", "", "tryResumeReceive", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class ReceiveElement<E> extends Receive<E> {
        public final CancellableContinuation<Object> cont;
        public final int receiveMode;

        public ReceiveElement(CancellableContinuation<Object> cont, int i) {
            Intrinsics.checkParameterIsNotNull(cont, "cont");
            this.cont = cont;
            this.receiveMode = i;
        }

        public final Object resumeValue(E e) {
            if (this.receiveMode != 2) {
                return e;
            }
            ValueOrClosed.Companion companion = ValueOrClosed.Companion;
            return ValueOrClosed.m1348boximpl(ValueOrClosed.m1349constructorimpl(e));
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Object tryResumeReceive(E e, Object obj) {
            return this.cont.tryResume(resumeValue(e), obj);
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(Object token) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            this.cont.completeResume(token);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (this.receiveMode == 1 && closed.closeCause == null) {
                Result.Companion companion = Result.Companion;
                this.cont.resumeWith(Result.m28constructorimpl(null));
            } else if (this.receiveMode != 2) {
                Throwable receiveException = closed.getReceiveException();
                Result.Companion companion2 = Result.Companion;
                this.cont.resumeWith(Result.m28constructorimpl(ResultKt.createFailure(receiveException)));
            } else {
                ValueOrClosed.Companion companion3 = ValueOrClosed.Companion;
                ValueOrClosed m1348boximpl = ValueOrClosed.m1348boximpl(ValueOrClosed.m1349constructorimpl(new ValueOrClosed.Closed(closed.closeCause)));
                Result.Companion companion4 = Result.Companion;
                this.cont.resumeWith(Result.m28constructorimpl(m1348boximpl));
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveElement[receiveMode=" + this.receiveMode + ']';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0014\u0010\r\u001a\u00020\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0016J\b\u0010\u0010\u001a\u00020\u0011H\u0016J!\u0010\u0012\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0013\u001a\u00028\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0002\u0010\u0015R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0016"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveHasNext;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "iterator", "Lkotlinx/coroutines/channels/AbstractChannel$Itr;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "", "(Lkotlinx/coroutines/channels/AbstractChannel$Itr;Lkotlinx/coroutines/CancellableContinuation;)V", "completeResumeReceive", "", "token", "", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class ReceiveHasNext<E> extends Receive<E> {
        public final CancellableContinuation<Boolean> cont;
        public final Itr<E> iterator;

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveHasNext";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveHasNext(Itr<E> iterator, CancellableContinuation<? super Boolean> cont) {
            Intrinsics.checkParameterIsNotNull(iterator, "iterator");
            Intrinsics.checkParameterIsNotNull(cont, "cont");
            this.iterator = iterator;
            this.cont = cont;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Object tryResumeReceive(E e, Object obj) {
            Object tryResume = this.cont.tryResume(true, obj);
            if (tryResume != null) {
                if (obj != null) {
                    return new IdempotentTokenValue(tryResume, e);
                }
                this.iterator.setResult(e);
            }
            return tryResume;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(Object token) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            if (token instanceof IdempotentTokenValue) {
                IdempotentTokenValue idempotentTokenValue = (IdempotentTokenValue) token;
                this.iterator.setResult(idempotentTokenValue.value);
                this.cont.completeResume(idempotentTokenValue.token);
                return;
            }
            this.cont.completeResume(token);
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            Object tryResumeWithException;
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (closed.closeCause == null) {
                tryResumeWithException = CancellableContinuation.DefaultImpls.tryResume$default(this.cont, false, null, 2, null);
            } else {
                tryResumeWithException = this.cont.tryResumeWithException(StackTraceRecoveryKt.recoverStackTrace(closed.getReceiveException(), this.cont));
            }
            if (tryResumeWithException != null) {
                this.iterator.setResult(closed);
                this.cont.completeResume(tryResumeWithException);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u0001*\u0004\b\u0002\u0010\u00022\b\u0012\u0004\u0012\u0002H\u00020\u00032\u00020\u0004BR\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b\u0012$\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n\u0012\u0006\u0010\r\u001a\u00020\u000eø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000bH\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016J\u0014\u0010\u0015\u001a\u00020\u00122\n\u0010\u0016\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J!\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001b\u001a\u00028\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\u001dR3\u0010\t\u001a \b\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\n8\u0006X\u0087\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0010R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$ReceiveSelect;", "R", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Receive;", "Lkotlinx/coroutines/DisposableHandle;", "channel", "Lkotlinx/coroutines/channels/AbstractChannel;", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "block", "Lkotlin/Function2;", "", "Lkotlin/coroutines/Continuation;", "receiveMode", "", "(Lkotlinx/coroutines/channels/AbstractChannel;Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;I)V", "Lkotlin/jvm/functions/Function2;", "completeResumeReceive", "", "token", "dispose", "resumeReceiveClosed", "closed", "Lkotlinx/coroutines/channels/Closed;", "toString", "", "tryResumeReceive", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class ReceiveSelect<R, E> extends Receive<E> implements DisposableHandle {
        public final Function2<Object, Continuation<? super R>, Object> block;
        public final AbstractChannel<E> channel;
        public final int receiveMode;
        public final SelectInstance<R> select;

        /* JADX WARN: Multi-variable type inference failed */
        public ReceiveSelect(AbstractChannel<E> channel, SelectInstance<? super R> select, Function2<Object, ? super Continuation<? super R>, ? extends Object> block, int i) {
            Intrinsics.checkParameterIsNotNull(channel, "channel");
            Intrinsics.checkParameterIsNotNull(select, "select");
            Intrinsics.checkParameterIsNotNull(block, "block");
            this.channel = channel;
            this.select = select;
            this.block = block;
            this.receiveMode = i;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public Object tryResumeReceive(E e, Object obj) {
            if (this.select.trySelect(obj)) {
                return e != null ? e : AbstractChannelKt.NULL_VALUE;
            }
            return null;
        }

        @Override // kotlinx.coroutines.channels.ReceiveOrClosed
        public void completeResumeReceive(Object token) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            if (token == AbstractChannelKt.NULL_VALUE) {
                token = null;
            }
            Function2<Object, Continuation<? super R>, Object> function2 = this.block;
            if (this.receiveMode == 2) {
                ValueOrClosed.Companion companion = ValueOrClosed.Companion;
                token = ValueOrClosed.m1348boximpl(ValueOrClosed.m1349constructorimpl(token));
            }
            ContinuationKt.startCoroutine(function2, token, this.select.getCompletion());
        }

        @Override // kotlinx.coroutines.channels.Receive
        public void resumeReceiveClosed(Closed<?> closed) {
            Intrinsics.checkParameterIsNotNull(closed, "closed");
            if (this.select.trySelect(null)) {
                int i = this.receiveMode;
                if (i == 0) {
                    this.select.resumeSelectCancellableWithException(closed.getReceiveException());
                } else if (i == 1) {
                    if (closed.closeCause == null) {
                        ContinuationKt.startCoroutine(this.block, null, this.select.getCompletion());
                    } else {
                        this.select.resumeSelectCancellableWithException(closed.getReceiveException());
                    }
                } else if (i != 2) {
                } else {
                    Function2<Object, Continuation<? super R>, Object> function2 = this.block;
                    ValueOrClosed.Companion companion = ValueOrClosed.Companion;
                    ContinuationKt.startCoroutine(function2, ValueOrClosed.m1348boximpl(ValueOrClosed.m1349constructorimpl(new ValueOrClosed.Closed(closed.closeCause))), this.select.getCompletion());
                }
            }
        }

        @Override // kotlinx.coroutines.DisposableHandle
        public void dispose() {
            if (remove()) {
                this.channel.onReceiveDequeued();
            }
        }

        @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
        public String toString() {
            return "ReceiveSelect[" + this.select + ",receiveMode=" + this.receiveMode + ']';
        }
    }

    /* compiled from: AbstractChannel.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005R\u0010\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00028\u00018\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lkotlinx/coroutines/channels/AbstractChannel$IdempotentTokenValue;", ExifInterface.LONGITUDE_EAST, "", "token", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    private static final class IdempotentTokenValue<E> {
        public final Object token;
        public final E value;

        public IdempotentTokenValue(Object token, E e) {
            Intrinsics.checkParameterIsNotNull(token, "token");
            this.token = token;
            this.value = e;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    final /* synthetic */ <R> Object receiveSuspend(int i, Continuation<? super R> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 0);
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        ReceiveElement receiveElement = new ReceiveElement(cancellableContinuationImpl2, i);
        while (true) {
            ReceiveElement receiveElement2 = receiveElement;
            if (enqueueReceive(receiveElement2)) {
                removeReceiveOnCancel(cancellableContinuationImpl2, receiveElement2);
                break;
            }
            Object pollInternal = pollInternal();
            if (pollInternal instanceof Closed) {
                receiveElement.resumeReceiveClosed((Closed) pollInternal);
                break;
            } else if (pollInternal != AbstractChannelKt.POLL_FAILED) {
                Object resumeValue = receiveElement.resumeValue(pollInternal);
                Result.Companion companion = Result.Companion;
                cancellableContinuationImpl2.resumeWith(Result.m28constructorimpl(resumeValue));
                break;
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
