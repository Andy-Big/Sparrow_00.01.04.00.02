package kotlin.internal;

import com.sun.mail.imap.IMAPStore;
import java.lang.reflect.Method;
import java.util.List;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;

/* compiled from: PlatformImplementations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u00112\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0013"}, d2 = {"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", IMAPStore.ID_NAME, "", "getSuppressed", "", "ReflectThrowable", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public class PlatformImplementations {

    /* compiled from: PlatformImplementations.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lkotlin/internal/PlatformImplementations$ReflectThrowable;", "", "()V", "addSuppressed", "Ljava/lang/reflect/Method;", "getSuppressed", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes2.dex */
    private static final class ReflectThrowable {
        public static final ReflectThrowable INSTANCE = new ReflectThrowable();
        public static final Method addSuppressed;
        public static final Method getSuppressed;

        /* JADX WARN: Removed duplicated region for block: B:13:0x0046 A[LOOP:0: B:3:0x0015->B:13:0x0046, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x004a A[EDGE_INSN: B:23:0x004a->B:15:0x004a ?: BREAK  , SYNTHETIC] */
        static {
            Method method;
            Method it;
            boolean z;
            Method[] throwableMethods = Throwable.class.getMethods();
            Intrinsics.checkNotNullExpressionValue(throwableMethods, "throwableMethods");
            int length = throwableMethods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    it = null;
                    break;
                }
                it = throwableMethods[i2];
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (Intrinsics.areEqual(it.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = it.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (Intrinsics.areEqual((Class) ArraysKt.singleOrNull(parameterTypes), Throwable.class)) {
                        z = true;
                        if (!z) {
                            break;
                        }
                        i2++;
                    }
                }
                z = false;
                if (!z) {
                }
            }
            addSuppressed = it;
            int length2 = throwableMethods.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Method it2 = throwableMethods[i];
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                if (Intrinsics.areEqual(it2.getName(), "getSuppressed")) {
                    method = it2;
                    break;
                }
                i++;
            }
            getSuppressed = method;
        }

        private ReflectThrowable() {
        }
    }

    public void addSuppressed(Throwable cause, Throwable exception) {
        Intrinsics.checkNotNullParameter(cause, "cause");
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.addSuppressed;
        if (method != null) {
            method.invoke(cause, exception);
        }
    }

    public List<Throwable> getSuppressed(Throwable exception) {
        Object invoke;
        Intrinsics.checkNotNullParameter(exception, "exception");
        Method method = ReflectThrowable.getSuppressed;
        if (method != null && (invoke = method.invoke(exception, new Object[0])) != null) {
            if (invoke == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Throwable>");
            }
            List<Throwable> asList = ArraysKt.asList((Throwable[]) invoke);
            if (asList != null) {
                return asList;
            }
        }
        return CollectionsKt.emptyList();
    }

    public MatchGroup getMatchResultNamedGroup(MatchResult matchResult, String name) {
        Intrinsics.checkNotNullParameter(matchResult, "matchResult");
        Intrinsics.checkNotNullParameter(name, "name");
        throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
    }

    public Random defaultPlatformRandom() {
        return new FallbackThreadLocalRandom();
    }
}
