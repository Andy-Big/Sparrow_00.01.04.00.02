package com.rigol.scope.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
/* loaded from: classes2.dex */
public class ViewStateViewModel extends ViewModel {
    MutableLiveData<Boolean> isFirstShow;
    MutableLiveData<Integer> viewState;

    public ViewStateViewModel() {
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
        this.viewState = mutableLiveData;
        this.viewState = mutableLiveData;
        this.isFirstShow = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> getViewState() {
        if (this.viewState == null) {
            MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>();
            this.viewState = mutableLiveData;
            mutableLiveData.setValue(1);
        }
        return this.viewState;
    }

    public MutableLiveData<Boolean> getIsFirstShow() {
        if (this.isFirstShow == null) {
            MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
            this.isFirstShow = mutableLiveData;
            mutableLiveData.setValue(false);
        }
        return this.isFirstShow;
    }

    public void setIsFirstShow(boolean z) {
        if (this.isFirstShow == null) {
            getIsFirstShow().setValue(Boolean.valueOf(z));
        }
    }

    public void resetIsFirstShow() {
        if (this.isFirstShow == null) {
            getIsFirstShow();
        }
        this.isFirstShow.setValue(false);
    }
}
