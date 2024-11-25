package com.rigol.scope.viewmodels;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
/* loaded from: classes2.dex */
public class StorageViewModel extends AndroidViewModel {
    private final MutableLiveData<StorageLoadParam> loadLiveData;
    private final MutableLiveData<StorageSaveParam> saveLiveData;
    final StorageLoadParam storageLoadParam;
    final StorageSaveParam storageSaveParam;

    public StorageViewModel(Application application) {
        super(application);
        this.saveLiveData = new MutableLiveData<>();
        this.loadLiveData = new MutableLiveData<>();
        this.storageSaveParam = new StorageSaveParam();
        this.storageLoadParam = new StorageLoadParam();
        this.saveLiveData.setValue(this.storageSaveParam);
        this.loadLiveData.setValue(this.storageLoadParam);
    }

    public MutableLiveData<StorageSaveParam> getSaveLiveData() {
        return this.saveLiveData;
    }

    public MutableLiveData<StorageLoadParam> getLoadLiveData() {
        return this.loadLiveData;
    }

    public void get() {
        this.storageSaveParam.readAll();
        this.storageLoadParam.readAll();
    }
}
