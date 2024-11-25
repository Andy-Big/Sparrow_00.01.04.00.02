package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Transformations.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\b\u001a;\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0014\b\u0004\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\u0006H\u0086\b\u001aA\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001a\b\u0004\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\u0006H\u0086\b¨\u0006\b"}, d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "switchMap", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class TransformationsKt {
    public static final <X, Y> LiveData<Y> map(LiveData<X> map, final Function1<? super X, ? extends Y> transform) {
        Intrinsics.checkParameterIsNotNull(map, "$this$map");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        LiveData<Y> map2 = Transformations.map(map, new Function<X, Y>() { // from class: androidx.lifecycle.TransformationsKt$map$1
            @Override // androidx.arch.core.util.Function
            public final Y apply(X x) {
                return (Y) Function1.this.invoke(x);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(map2, "Transformations.map(this) { transform(it) }");
        return map2;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> switchMap, final Function1<? super X, ? extends LiveData<Y>> transform) {
        Intrinsics.checkParameterIsNotNull(switchMap, "$this$switchMap");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        LiveData<Y> switchMap2 = Transformations.switchMap(switchMap, new Function<X, LiveData<Y>>() { // from class: androidx.lifecycle.TransformationsKt$switchMap$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.arch.core.util.Function
            public /* bridge */ /* synthetic */ Object apply(Object obj) {
                return apply((TransformationsKt$switchMap$1<I, O, X, Y>) obj);
            }

            @Override // androidx.arch.core.util.Function
            public final LiveData<Y> apply(X x) {
                return (LiveData) Function1.this.invoke(x);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(switchMap2, "Transformations.switchMap(this) { transform(it) }");
        return switchMap2;
    }

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> distinctUntilChanged) {
        Intrinsics.checkParameterIsNotNull(distinctUntilChanged, "$this$distinctUntilChanged");
        LiveData<X> distinctUntilChanged2 = Transformations.distinctUntilChanged(distinctUntilChanged);
        Intrinsics.checkExpressionValueIsNotNull(distinctUntilChanged2, "Transformations.distinctUntilChanged(this)");
        return distinctUntilChanged2;
    }
}
