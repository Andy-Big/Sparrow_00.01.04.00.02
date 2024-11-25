package com.rigol.scope.viewmodels;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.rigol.scope.data.BaseParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BaseViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000¢\u0006\u0002\u0010\u0005J&\u0010\r\u001a\u00020\u000e2\u0016\u0010\u000f\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00110\u0010\"\u0004\u0018\u00010\u0011H\u0096\u0002¢\u0006\u0002\u0010\u0012R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/rigol/scope/viewmodels/BaseViewModel;", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/lifecycle/ViewModel;", "Lcom/rigol/scope/viewmodels/ViewModelRequest;", "value", "(Ljava/lang/Object;)V", "liveData", "Landroidx/lifecycle/LiveData;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "get", "", "objects", "", "", "([Ljava/lang/Object;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class BaseViewModel<T> extends ViewModel implements ViewModelRequest {
    private final LiveData<T> liveData;
    private final T value;

    public BaseViewModel(T t) {
        this.value = t;
        this.liveData = new MutableLiveData(this.value);
    }

    public final T getValue() {
        return this.value;
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
