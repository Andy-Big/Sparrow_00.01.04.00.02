package com.rigol.scope.viewmodels;

import android.app.Application;
import com.rigol.scope.R;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MathViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/rigol/scope/viewmodels/MathViewModel;", "Lcom/rigol/scope/viewmodels/BaseAndroidViewModel;", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/MathParam;", "Lkotlin/collections/ArrayList;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MathViewModel extends BaseAndroidViewModel<ArrayList<MathParam>> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MathViewModel(final Application application) {
        super(application, new ArrayList());
        Intrinsics.checkNotNullParameter(application, "application");
        ViewUtil.getList((int) R.array.msg_math_list).forEach(new Consumer<MappingObject>() { // from class: com.rigol.scope.viewmodels.MathViewModel.1
            @Override // java.util.function.Consumer
            public final void accept(MappingObject mappingObject) {
                if (mappingObject != null) {
                    MathViewModel.this.getValue().add(new MathParam(application, mappingObject.getStr(), mappingObject.getValue()));
                }
            }
        });
    }
}
