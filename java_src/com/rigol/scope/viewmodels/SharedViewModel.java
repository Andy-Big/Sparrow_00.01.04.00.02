package com.rigol.scope.viewmodels;

import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.NetworkUtils;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.util.DiskUtil;

/* loaded from: classes2.dex */
public class SharedViewModel extends BaseViewModel<SharedParam> {
    public final MutableLiveData<EyeParam> eyeParamState;
    public final MutableLiveData<Boolean> hasChangeMeasureItem;
    public final MutableLiveData<Boolean> hasRemoveMeasureItem;
    public final MutableLiveData<TwoTuple<Boolean, Boolean>> hasUpdate;
    public final MutableLiveData<JitterParam> jitterParamState;
    public final MutableLiveData<Boolean> localeChanged;
    public final MutableLiveData<Boolean> nightThemeEnable;
    public final MutableLiveData<Boolean> softInputChanged;

    public SharedViewModel() {
        super(new SharedParam());
        this.nightThemeEnable = new MutableLiveData<>();
        this.localeChanged = new MutableLiveData<>();
        this.softInputChanged = new MutableLiveData<>();
        this.hasUpdate = new MutableLiveData<>();
        this.eyeParamState = new MutableLiveData<>();
        this.hasChangeMeasureItem = new MutableLiveData<>();
        this.hasRemoveMeasureItem = new MutableLiveData<>();
        this.jitterParamState = new MutableLiveData<>();
    }

    @Override // com.rigol.scope.viewmodels.BaseViewModel, com.rigol.scope.viewmodels.ViewModelRequest
    public void get(Object... objArr) {
        super.get(objArr);
        getValue().setShowUsb(DiskUtil.INSTANCE.hasRemovableDisk());
        getValue().setShowNetwork(NetworkUtils.isConnected());
    }
}
