package androidx.lifecycle;

import androidx.exifinterface.media.ExifInterface;
import java.time.Duration;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
/* compiled from: CoroutineLiveData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a_\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2/\b\u0001\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n¢\u0006\u0002\b\u000fH\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a_\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0011\u001a\u00020\u00012/\b\u0001\u0010\t\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n¢\u0006\u0002\b\u000fø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a/\u0010\u0013\u001a\u00020\u0014\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0080@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000*`\b\u0000\u0010\u0018\u001a\u0004\b\u0000\u0010\u0004\")\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n¢\u0006\u0002\b\u000f2)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\f\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n¢\u0006\u0002\b\u000f\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"DEFAULT_TIMEOUT", "", "liveData", "Landroidx/lifecycle/LiveData;", ExifInterface.GPS_DIRECTION_TRUE, "context", "Lkotlin/coroutines/CoroutineContext;", "timeout", "Ljava/time/Duration;", "block", "Lkotlin/Function2;", "Landroidx/lifecycle/LiveDataScope;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/coroutines/CoroutineContext;Ljava/time/Duration;Lkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "timeoutInMs", "(Lkotlin/coroutines/CoroutineContext;JLkotlin/jvm/functions/Function2;)Landroidx/lifecycle/LiveData;", "addDisposableSource", "Landroidx/lifecycle/EmittedSource;", "Landroidx/lifecycle/MediatorLiveData;", "source", "(Landroidx/lifecycle/MediatorLiveData;Landroidx/lifecycle/LiveData;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Block", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class CoroutineLiveDataKt {
    public static final long DEFAULT_TIMEOUT = 5000;

    public static final <T> Object addDisposableSource(MediatorLiveData<T> mediatorLiveData, LiveData<T> liveData, Continuation<? super EmittedSource> continuation) {
        return BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new CoroutineLiveDataKt$addDisposableSource$2(mediatorLiveData, liveData, null), continuation);
    }

    public static /* synthetic */ LiveData liveData$default(CoroutineContext coroutineContext, long j, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        if ((i & 2) != 0) {
            j = 5000;
        }
        return liveData(coroutineContext, j, function2);
    }

    public static final <T> LiveData<T> liveData(CoroutineContext context, long j, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return new CoroutineLiveData(context, j, block);
    }

    public static /* synthetic */ LiveData liveData$default(CoroutineContext coroutineContext, Duration duration, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return liveData(coroutineContext, duration, function2);
    }

    public static final <T> LiveData<T> liveData(CoroutineContext context, Duration timeout, Function2<? super LiveDataScope<T>, ? super Continuation<? super Unit>, ? extends Object> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(timeout, "timeout");
        Intrinsics.checkParameterIsNotNull(block, "block");
        return new CoroutineLiveData(context, timeout.toMillis(), block);
    }
}
