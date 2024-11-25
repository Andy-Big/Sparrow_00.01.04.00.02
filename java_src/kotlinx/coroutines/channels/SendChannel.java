package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.selects.SelectClause2;
/* compiled from: Channel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J\u0014\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J-\u0010\u0011\u001a\u00020\u00122#\u0010\u0013\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00120\u0014H'J\u0015\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0019J\u0019\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00028\u0000H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0007R\u001a\u0010\b\u001a\u00020\u00048&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0007R$\u0010\n\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Lkotlinx/coroutines/channels/SendChannel;", ExifInterface.LONGITUDE_EAST, "", "isClosedForSend", "", "isClosedForSend$annotations", "()V", "()Z", "isFull", "isFull$annotations", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "close", "cause", "", "invokeOnClose", "", "handler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "offer", "element", "(Ljava/lang/Object;)Z", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface SendChannel<E> {
    boolean close(Throwable th);

    SelectClause2<E, SendChannel<E>> getOnSend();

    void invokeOnClose(Function1<? super Throwable, Unit> function1);

    boolean isClosedForSend();

    boolean isFull();

    boolean offer(E e);

    Object send(E e, Continuation<? super Unit> continuation);

    /* compiled from: Channel.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 15})
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void isClosedForSend$annotations() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Will be removed in next releases without replacement")
        public static /* synthetic */ void isFull$annotations() {
        }

        public static /* synthetic */ boolean close$default(SendChannel sendChannel, Throwable th, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    th = null;
                }
                return sendChannel.close(th);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: close");
        }
    }
}
