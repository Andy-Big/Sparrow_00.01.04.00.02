package com.rigol.scope.viewmodels;

import android.app.Application;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.rigol.scope.data.BaseParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BaseAndroidViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000¢\u0006\u0002\u0010\u0007J&\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0096\u0002¢\u0006\u0002\u0010\u0014R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/rigol/scope/viewmodels/BaseAndroidViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/AndroidViewModel;", "Lcom/rigol/scope/viewmodels/ViewModelRequest;", "application", "Landroid/app/Application;", "value", "(Landroid/app/Application;Ljava/lang/Object;)V", "liveData", "Landroidx/lifecycle/LiveData;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "get", "", "objects", "", "", "([Ljava/lang/Object;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class BaseAndroidViewModel<T> extends AndroidViewModel implements ViewModelRequest {
    private final LiveData<T> liveData;
    private final T value;

    public final T getValue() {
        return this.value;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseAndroidViewModel(Application application, T t) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.value = t;
        this.liveData = new MutableLiveData(this.value);
    }

    public final LiveData<T> getLiveData() {
        return this.liveData;
    }

    @Override // com.rigol.scope.viewmodels.ViewModelRequest
    public void get(Object... objects) {
        Intrinsics.checkNotNullParameter(objects, "objects");
        T t = this.value;
        if (t instanceof BaseParam) {
            ((BaseParam) t).readAll();
        } else if (t instanceof List) {
            for (T t2 : (Iterable) t) {
                if (t2 instanceof BaseParam) {
                    ((BaseParam) t2).readAll();
                }
            }
        }
    }
}
