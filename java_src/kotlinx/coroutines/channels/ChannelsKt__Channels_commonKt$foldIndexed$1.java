package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.rigol.scope.cil.MessageID;
import com.sun.mail.imap.IMAPStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
/* compiled from: Channels.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\u0006\u0010\u0005\u001a\u0002H\u00032<\u0010\u0006\u001a8\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00072\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00030\u000eH\u0087H"}, d2 = {"foldIndexed", "", ExifInterface.LONGITUDE_EAST, "R", "Lkotlinx/coroutines/channels/ReceiveChannel;", "initial", "operation", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "index", "acc", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {MessageID.MSG_CURSOR_TRACK_DX}, m = "foldIndexed", n = {"$this$foldIndexed", "initial", "operation", "index", "accumulator", "$this$consumeEach$iv", "$this$consume$iv$iv", "cause$iv$iv", "$this$consume$iv"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8"})
/* loaded from: classes2.dex */
public final class ChannelsKt__Channels_commonKt$foldIndexed$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    Object L$8;
    Object L$9;
    int label;
    /* synthetic */ Object result;

    public ChannelsKt__Channels_commonKt$foldIndexed$1(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.foldIndexed(null, null, null, this);
    }
}
