package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.internal.SystemPropsKt;

/* compiled from: Debug.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u0015H\u0081\b\u001a\b\u0010\u0016\u001a\u00020\u0013H\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0003\"\u000e\u0010\n\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000bX\u0086T¢\u0006\u0002\n\u0000\"\u0014\u0010\u000f\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0003\"\u000e\u0010\u0011\u001a\u00020\u000bX\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"ASSERTIONS_ENABLED", "", "getASSERTIONS_ENABLED", "()Z", "COROUTINE_ID", "Ljava/util/concurrent/atomic/AtomicLong;", "getCOROUTINE_ID", "()Ljava/util/concurrent/atomic/AtomicLong;", "DEBUG", "getDEBUG", "DEBUG_PROPERTY_NAME", "", "DEBUG_PROPERTY_VALUE_AUTO", "DEBUG_PROPERTY_VALUE_OFF", "DEBUG_PROPERTY_VALUE_ON", "RECOVER_STACK_TRACES", "getRECOVER_STACK_TRACES", "STACKTRACE_RECOVERY_PROPERTY_NAME", "assert", "", "value", "Lkotlin/Function0;", "resetCoroutineId", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class DebugKt {
    private static final boolean ASSERTIONS_ENABLED = CoroutineId.class.desiredAssertionStatus();
    private static final AtomicLong COROUTINE_ID;
    private static final boolean DEBUG;
    public static final String DEBUG_PROPERTY_NAME = "kotlinx.coroutines.debug";
    public static final String DEBUG_PROPERTY_VALUE_AUTO = "auto";
    public static final String DEBUG_PROPERTY_VALUE_OFF = "off";
    public static final String DEBUG_PROPERTY_VALUE_ON = "on";
    private static final boolean RECOVER_STACK_TRACES;
    public static final String STACKTRACE_RECOVERY_PROPERTY_NAME = "kotlinx.coroutines.stacktrace.recovery";

    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_AUTO) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
        if (r0.equals(kotlinx.coroutines.DebugKt.DEBUG_PROPERTY_VALUE_ON) != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r0.equals("") != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004d, code lost:
        r0 = true;
     */
    static {
        boolean z;
        String systemProp = SystemPropsKt.systemProp(DEBUG_PROPERTY_NAME);
        boolean z2 = false;
        if (systemProp != null) {
            int hashCode = systemProp.hashCode();
            if (hashCode != 0) {
                if (hashCode != 3551) {
                    if (hashCode != 109935) {
                        if (hashCode == 3005871) {
                        }
                    } else if (systemProp.equals(DEBUG_PROPERTY_VALUE_OFF)) {
                        z = false;
                    }
                }
                throw new IllegalStateException(("System property 'kotlinx.coroutines.debug' has unrecognized value '" + systemProp + '\'').toString());
            }
            DEBUG = z;
            if (z && SystemPropsKt.systemProp(STACKTRACE_RECOVERY_PROPERTY_NAME, true)) {
                z2 = true;
            }
            RECOVER_STACK_TRACES = z2;
            COROUTINE_ID = new AtomicLong(0L);
        }
        z = ASSERTIONS_ENABLED;
        DEBUG = z;
        if (z) {
            z2 = true;
        }
        RECOVER_STACK_TRACES = z2;
        COROUTINE_ID = new AtomicLong(0L);
    }

    public static final boolean getASSERTIONS_ENABLED() {
        return ASSERTIONS_ENABLED;
    }

    public static final boolean getDEBUG() {
        return DEBUG;
    }

    public static final boolean getRECOVER_STACK_TRACES() {
        return RECOVER_STACK_TRACES;
    }

    public static final AtomicLong getCOROUTINE_ID() {
        return COROUTINE_ID;
    }

    public static final void resetCoroutineId() {
        COROUTINE_ID.set(0L);
    }

    /* renamed from: assert  reason: not valid java name */
    private static final void m1341assert(Function0<Boolean> function0) {
        if (getASSERTIONS_ENABLED() && !function0.invoke().booleanValue()) {
            throw new AssertionError();
        }
    }
}
