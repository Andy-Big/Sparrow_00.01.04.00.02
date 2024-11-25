package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DebugKt;
/* compiled from: AbstractChannel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u000f\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0014\u0010\u0016\u001a\u00020\u00122\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0000H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J!\u0010\u001a\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00028\u00002\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0002\u0010\u001dJ\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u00142\b\u0010\u001c\u001a\u0004\u0018\u00010\u0014H\u0016R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/channels/Closed;", ExifInterface.LONGITUDE_EAST, "Lkotlinx/coroutines/channels/Send;", "Lkotlinx/coroutines/channels/ReceiveOrClosed;", "closeCause", "", "(Ljava/lang/Throwable;)V", "offerResult", "getOfferResult", "()Lkotlinx/coroutines/channels/Closed;", "pollResult", "getPollResult", "receiveException", "getReceiveException", "()Ljava/lang/Throwable;", "sendException", "getSendException", "completeResumeReceive", "", "token", "", "completeResumeSend", "resumeSendClosed", "closed", "toString", "", "tryResumeReceive", "value", "idempotent", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryResumeSend", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class Closed<E> extends Send implements ReceiveOrClosed<E> {
    public final Throwable closeCause;

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Closed<E> getOfferResult() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.Send
    public Closed<E> getPollResult() {
        return this;
    }

    public Closed(Throwable th) {
        this.closeCause = th;
    }

    public final Throwable getSendException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    public final Throwable getReceiveException() {
        Throwable th = this.closeCause;
        return th != null ? th : new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE);
    }

    @Override // kotlinx.coroutines.channels.Send
    public Object tryResumeSend(Object obj) {
        return AbstractChannelKt.CLOSE_RESUMED;
    }

    @Override // kotlinx.coroutines.channels.Send
    public void completeResumeSend(Object token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(token == AbstractChannelKt.CLOSE_RESUMED)) {
                throw new AssertionError();
            }
        }
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public Object tryResumeReceive(E e, Object obj) {
        return AbstractChannelKt.CLOSE_RESUMED;
    }

    @Override // kotlinx.coroutines.channels.ReceiveOrClosed
    public void completeResumeReceive(Object token) {
        Intrinsics.checkParameterIsNotNull(token, "token");
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(token == AbstractChannelKt.CLOSE_RESUMED)) {
                throw new AssertionError();
            }
        }
    }

    @Override // kotlinx.coroutines.channels.Send
    public void resumeSendClosed(Closed<?> closed) {
        Intrinsics.checkParameterIsNotNull(closed, "closed");
        if (DebugKt.getASSERTIONS_ENABLED()) {
            throw new AssertionError();
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public String toString() {
        return "Closed[" + this.closeCause + ']';
    }
}
