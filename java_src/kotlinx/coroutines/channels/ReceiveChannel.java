package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.selects.SelectClause1;
/* compiled from: Channel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0017J\u0014\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0018H'J\u001a\u0010\u0015\u001a\u00020\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0018\u00010\u0019j\u0004\u0018\u0001`\u001aH&J\u000f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00000\u001cH¦\u0002J\u000f\u0010\u001d\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u001eJ\u0011\u0010\u001f\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010 J\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u000fH§@ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010 J\u0013\u0010\"\u001a\u0004\u0018\u00018\u0000H§@ø\u0001\u0000¢\u0006\u0002\u0010 R\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0007R\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR)\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000f0\u000b8&X§\u0004ø\u0001\u0000¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\rR\"\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b8&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlinx/coroutines/channels/ReceiveChannel;", ExifInterface.LONGITUDE_EAST, "", "isClosedForReceive", "", "isClosedForReceive$annotations", "()V", "()Z", "isEmpty", "isEmpty$annotations", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveOrClosed", "Lkotlinx/coroutines/channels/ValueOrClosed;", "onReceiveOrClosed$annotations", "getOnReceiveOrClosed", "onReceiveOrNull", "onReceiveOrNull$annotations", "getOnReceiveOrNull", "cancel", "", "cause", "", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "poll", "()Ljava/lang/Object;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOrClosed", "receiveOrNull", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface ReceiveChannel<E> {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ void cancel();

    void cancel(CancellationException cancellationException);

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Since 1.2.0, binary compatibility with versions <= 1.1.x")
    /* synthetic */ boolean cancel(Throwable th);

    SelectClause1<E> getOnReceive();

    SelectClause1<ValueOrClosed<E>> getOnReceiveOrClosed();

    SelectClause1<E> getOnReceiveOrNull();

    boolean isClosedForReceive();

    boolean isEmpty();

    ChannelIterator<E> iterator();

    E poll();

    Object receive(Continuation<? super E> continuation);

    Object receiveOrClosed(Continuation<? super ValueOrClosed<? extends E>> continuation);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of receiveOrClosed and receiveOrNull extension", replaceWith = @ReplaceWith(expression = "receiveOrNull", imports = {"kotlinx.coroutines.channels.receiveOrNull"}))
    Object receiveOrNull(Continuation<? super E> continuation);

    /* compiled from: Channel.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void isClosedForReceive$annotations() {
        }

        public static /* synthetic */ void isEmpty$annotations() {
        }

        public static /* synthetic */ void onReceiveOrClosed$annotations() {
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of onReceiveOrClosed and onReceiveOrNull extension", replaceWith = @ReplaceWith(expression = "onReceiveOrNull", imports = {"kotlinx.coroutines.channels.onReceiveOrNull"}))
        public static /* synthetic */ void onReceiveOrNull$annotations() {
        }

        public static /* synthetic */ void cancel$default(ReceiveChannel receiveChannel, CancellationException cancellationException, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
            }
            if ((i & 1) != 0) {
                cancellationException = null;
            }
            receiveChannel.cancel(cancellationException);
        }

        public static /* synthetic */ boolean cancel$default(ReceiveChannel receiveChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return receiveChannel.cancel(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cancel");
        }
    }
}
