package kotlinx.coroutines.internal;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.MainCoroutineDispatcher;
/* compiled from: MainDispatchers.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\u001a\u0010\u0005\u001a\u00020\u0004*\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"FAST_SERVICE_LOADER_PROPERTY_NAME", "", "isMissing", "", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "tryCreateDispatcher", "Lkotlinx/coroutines/internal/MainDispatcherFactory;", "factories", "", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class MainDispatchersKt {
    private static final String FAST_SERVICE_LOADER_PROPERTY_NAME = "kotlinx.coroutines.fast.service.loader";

    public static final MainCoroutineDispatcher tryCreateDispatcher(MainDispatcherFactory tryCreateDispatcher, List<? extends MainDispatcherFactory> factories) {
        Intrinsics.checkParameterIsNotNull(tryCreateDispatcher, "$this$tryCreateDispatcher");
        Intrinsics.checkParameterIsNotNull(factories, "factories");
        try {
            return tryCreateDispatcher.createDispatcher(factories);
        } catch (Throwable th) {
            return new MissingMainCoroutineDispatcher(th, tryCreateDispatcher.hintOnError());
        }
    }

    public static final boolean isMissing(MainCoroutineDispatcher isMissing) {
        Intrinsics.checkParameterIsNotNull(isMissing, "$this$isMissing");
        return isMissing instanceof MissingMainCoroutineDispatcher;
    }
}
