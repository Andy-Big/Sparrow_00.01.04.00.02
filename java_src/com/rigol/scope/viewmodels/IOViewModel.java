package com.rigol.scope.viewmodels;

import android.app.Application;
import com.rigol.scope.data.IOParam;
import com.rigol.scope.utilities.ViewUtil;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: IOViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J&\u0010\u0006\u001a\u00020\u00072\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\n0\t\"\u0004\u0018\u00010\nH\u0096\u0002¢\u0006\u0002\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/rigol/scope/viewmodels/IOViewModel;", "Lcom/rigol/scope/viewmodels/BaseAndroidViewModel;", "Lcom/rigol/scope/data/IOParam;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "get", "", "objects", "", "", "([Ljava/lang/Object;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class IOViewModel extends BaseAndroidViewModel<IOParam> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IOViewModel(Application application) {
        super(application, new IOParam());
        Intrinsics.checkNotNullParameter(application, "application");
    }

    @Override // com.rigol.scope.viewmodels.BaseAndroidViewModel, com.rigol.scope.viewmodels.ViewModelRequest
    public void get(Object... objects) {
        Intrinsics.checkNotNullParameter(objects, "objects");
        super.get(Arrays.copyOf(objects, objects.length));
        ViewUtil.getNetworkInfo(getApplication(), getValue());
    }
}
