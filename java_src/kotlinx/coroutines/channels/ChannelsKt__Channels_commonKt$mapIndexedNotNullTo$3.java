package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.sun.mail.imap.IMAPStore;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
/* compiled from: Channels.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u0001\"\u000e\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00030\u0005*\b\u0012\u0004\u0012\u0002H\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042)\u0010\b\u001a%\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00040\u000fH\u0087H"}, d2 = {"mapIndexedNotNullTo", "", ExifInterface.LONGITUDE_EAST, "R", "C", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "destination", "transform", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "index", "continuation", "Lkotlin/coroutines/Continuation;"}, k = 3, mv = {1, 1, 15})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt", f = "Channels.common.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, l = {3136, 1488}, m = "mapIndexedNotNullTo", n = {"$this$mapIndexedNotNullTo", "destination", "transform", "$this$consumeEachIndexed$iv", "index$iv", "$this$consumeEach$iv$iv", "$this$consume$iv$iv$iv", "cause$iv$iv$iv", "$this$consume$iv$iv", "$this$mapIndexedNotNullTo", "destination", "transform", "$this$consumeEachIndexed$iv", "index$iv", "$this$consumeEach$iv$iv", "$this$consume$iv$iv$iv", "cause$iv$iv$iv", "$this$consume$iv$iv", "e$iv$iv", "it$iv", "$dstr$index$element", "index", "element", "it"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$7", "L$8", "L$10", "L$11", "L$12", "I$0", "L$13", "L$14"})
/* loaded from: classes2.dex */
public final class ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$10;
    Object L$11;
    Object L$12;
    Object L$13;
    Object L$14;
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

    public ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3(Continuation continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ChannelsKt.mapIndexedNotNullTo((ReceiveChannel) null, (SendChannel) null, (Function2) null, this);
    }
}
