package com.rigol.scope.data;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LeftStatusBarParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0007\"\u0004\b\u0010\u0010\tR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\u001a\u0010\u001a\u001a\u00020\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016¨\u0006\u001d"}, d2 = {"Lcom/rigol/scope/data/LeftStatusBarParam;", "", "()V", "SelectChanEnable", "Landroidx/lifecycle/MutableLiveData;", "", "getSelectChanEnable", "()Landroidx/lifecycle/MutableLiveData;", "setSelectChanEnable", "(Landroidx/lifecycle/MutableLiveData;)V", "channelEnable", "getChannelEnable", "setChannelEnable", "color", "", "getColor", "setColor", "message1", "", "getMessage1", "()Ljava/lang/String;", "setMessage1", "(Ljava/lang/String;)V", "message2", "getMessage2", "setMessage2", "title", "getTitle", "setTitle", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class LeftStatusBarParam {
    private String title = "";
    private String message1 = "";
    private String message2 = "";
    private MutableLiveData<Integer> color = new MutableLiveData<>(0);
    private MutableLiveData<Boolean> channelEnable = new MutableLiveData<>(false);
    private MutableLiveData<Boolean> SelectChanEnable = new MutableLiveData<>(false);

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    public final String getMessage1() {
        return this.message1;
    }

    public final void setMessage1(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message1 = str;
    }

    public final String getMessage2() {
        return this.message2;
    }

    public final void setMessage2(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message2 = str;
    }

    public final MutableLiveData<Integer> getColor() {
        return this.color;
    }

    public final void setColor(MutableLiveData<Integer> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.color = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getChannelEnable() {
        return this.channelEnable;
    }

    public final void setChannelEnable(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.channelEnable = mutableLiveData;
    }

    public final MutableLiveData<Boolean> getSelectChanEnable() {
        return this.SelectChanEnable;
    }

    public final void setSelectChanEnable(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<set-?>");
        this.SelectChanEnable = mutableLiveData;
    }
}
