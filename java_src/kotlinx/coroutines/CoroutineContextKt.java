package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.SystemPropsKt;
import kotlinx.coroutines.internal.ThreadContextKt;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: CoroutineContext.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u000b\u001a\u00020\fH\u0000\u001a4\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000e0\u0013H\u0080\b¢\u0006\u0002\u0010\u0014\u001a\u0014\u0010\u0015\u001a\u00020\b*\u00020\u00162\u0006\u0010\u000f\u001a\u00020\bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"COROUTINES_SCHEDULER_PROPERTY_NAME", "", "DEBUG_THREAD_NAME_SEPARATOR", "useCoroutinesScheduler", "", "getUseCoroutinesScheduler", "()Z", "coroutineName", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineName", "(Lkotlin/coroutines/CoroutineContext;)Ljava/lang/String;", "createDefaultDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "withCoroutineContext", ExifInterface.GPS_DIRECTION_TRUE, "context", "countOrElement", "", "block", "Lkotlin/Function0;", "(Lkotlin/coroutines/CoroutineContext;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "newCoroutineContext", "Lkotlinx/coroutines/CoroutineScope;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class CoroutineContextKt {
    public static final String COROUTINES_SCHEDULER_PROPERTY_NAME = "kotlinx.coroutines.scheduler";
    private static final String DEBUG_THREAD_NAME_SEPARATOR = " @";
    private static final boolean useCoroutinesScheduler;

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0028, code lost:
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0031, code lost:
        if (r0.equals("") != false) goto L21;
     */
    static {
        boolean z;
        String systemProp = SystemPropsKt.systemProp(COROUTINES_SCHEDULER_PROPERTY_NAME);
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    z = (hashCode == 109935 && systemProp.equals(DebugKt.DEBUG_PROPERTY_VALUE_OFF)) ? false : true;
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.scheduler' has unrecognized value '" + systemProp + '\'').toString());
            }
            useCoroutinesScheduler = z;
        }
        useCoroutinesScheduler = z;
    }

    public static final boolean getUseCoroutinesScheduler() {
        return useCoroutinesScheduler;
    }

    public static final CoroutineDispatcher createDefaultDispatcher() {
        return useCoroutinesScheduler ? DefaultScheduler.INSTANCE : CommonPool.INSTANCE;
    }

    public static final CoroutineContext newCoroutineContext(CoroutineScope newCoroutineContext, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(newCoroutineContext, "$this$newCoroutineContext");
        Intrinsics.checkParameterIsNotNull(context, "context");
        CoroutineContext plus = newCoroutineContext.getCoroutineContext().plus(context);
        CoroutineContext plus2 = DebugKt.getDEBUG() ? plus.plus(new CoroutineId(DebugKt.getCOROUTINE_ID().incrementAndGet())) : plus;
        return (plus == Dispatchers.getDefault() || plus.get(ContinuationInterceptor.Key) != null) ? plus2 : plus2.plus(Dispatchers.getDefault());
    }

    public static final <T> T withCoroutineContext(CoroutineContext context, Object obj, Function0<? extends T> block) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Object updateThreadContext = ThreadContextKt.updateThreadContext(context, obj);
        try {
            return block.invoke();
        } finally {
            InlineMarker.finallyStart(1);
            ThreadContextKt.restoreThreadContext(context, updateThreadContext);
            InlineMarker.finallyEnd(1);
        }
    }

    public static final String getCoroutineName(CoroutineContext coroutineName) {
        CoroutineId coroutineId;
        Intrinsics.checkParameterIsNotNull(coroutineName, "$this$coroutineName");
        if (DebugKt.getDEBUG() && (coroutineId = (CoroutineId) coroutineName.get(CoroutineId.Key)) != null) {
            CoroutineName coroutineName2 = (CoroutineName) coroutineName.get(CoroutineName.Key);
            String str = (coroutineName2 == null || (str = coroutineName2.getName()) == null) ? "coroutine" : "coroutine";
            return str + '#' + coroutineId.getId();
        }
        return null;
    }
}
