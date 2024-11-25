package com.rigol.scope.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
/* loaded from: classes2.dex */
public class ViewABkeyViewModel extends ViewModel {
    public MutableLiveData<Boolean> ax_boolean = new MutableLiveData<>();
    public MutableLiveData<Boolean> ay_boolean = new MutableLiveData<>();
    public MutableLiveData<Boolean> bx_boolean = new MutableLiveData<>();
    public MutableLiveData<Boolean> by_boolean = new MutableLiveData<>();
    public MutableLiveData<Float> viewpager_postion = new MutableLiveData<>();
    public MutableLiveData<Boolean> popuwind_boolean = new MutableLiveData<>();

    public MutableLiveData<Boolean> getPopuwind_boolean() {
        if (this.popuwind_boolean.getValue() == null) {
            this.popuwind_boolean.setValue(true);
        }
        return this.popuwind_boolean;
    }

    public MutableLiveData<Float> getViewpager_postion() {
        if (this.viewpager_postion.getValue() == null) {
            this.viewpager_postion.setValue(Float.valueOf(10.0f));
        }
        return this.viewpager_postion;
    }

    public MutableLiveData<Boolean> getAx_boolean() {
        if (this.ax_boolean.getValue() == null) {
            this.ax_boolean.setValue(true);
        }
        return this.ax_boolean;
    }

    public MutableLiveData<Boolean> getBx_boolean() {
        if (this.bx_boolean.getValue() == null) {
            this.bx_boolean.setValue(true);
        }
        return this.bx_boolean;
    }

    public MutableLiveData<Boolean> getAy_boolean() {
        if (this.ay_boolean.getValue() == null) {
            this.ay_boolean.setValue(false);
        }
        return this.ay_boolean;
    }

    public MutableLiveData<Boolean> getBy_boolean() {
        if (this.by_boolean.getValue() == null) {
            this.by_boolean.setValue(false);
        }
        return this.by_boolean;
    }

    public void reset() {
        this.ax_boolean.setValue(false);
        this.bx_boolean.setValue(false);
        this.ay_boolean.setValue(false);
        this.by_boolean.setValue(false);
    }
}
