package com.rigol.scope.views.auto;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.data.BaseParam;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AutosetParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007¨\u0006!"}, d2 = {"Lcom/rigol/scope/views/auto/AutosetParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "channel", "Lcom/rigol/scope/data/BaseProperty;", "", "getChannel", "()Lcom/rigol/scope/data/BaseProperty;", "keepcoup", "getKeepcoup", "lock", "getLock", "option", "getOption", "overlay", "getOverlay", "password", "", "getPassword", "passwordAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getPasswordAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "setPasswordAttr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "range", "getRange", "bindAll", "", "viewModel", "Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class AutosetParam extends BaseParam {
    private final BaseProperty<Boolean> channel;
    private final BaseProperty<Boolean> keepcoup;
    private final BaseProperty<Boolean> lock;
    private final BaseProperty<Boolean> option;
    private final BaseProperty<Boolean> overlay;
    private final BaseProperty<String> password;
    private MessageAttr passwordAttr;
    private final BaseProperty<Boolean> range;

    public AutosetParam() {
        super(35);
        MessageAttr messageAttr = new MessageAttr();
        messageAttr.setMaxValue(999999);
        messageAttr.setMinValue(0);
        messageAttr.setDefValue(666666);
        Unit unit = Unit.INSTANCE;
        this.passwordAttr = messageAttr;
        final int serviceId = getServiceId();
        final String logPrefix = getLogPrefix("option");
        this.option = new BaseProperty<Boolean>(serviceId, 782, false, logPrefix, false) { // from class: com.rigol.scope.views.auto.AutosetParam$option$1
            @Override // com.rigol.scope.data.BaseProperty
            public void onChanged(boolean z) {
                super.onChanged(z);
                if (getValue().booleanValue()) {
                    PopupViewManager.getInstance().show(AutoSetPopupView.class);
                }
            }
        };
        this.lock = new BaseProperty<>(getServiceId(), 776, false, null, getLogPrefix("lock"), false, false, false, 168, null);
        this.password = new BaseProperty<>(getServiceId(), 786, "", null, getLogPrefix("password"), false, false, false, 168, null);
        this.range = new BaseProperty<>(getServiceId(), 777, true, null, getLogPrefix("range"), false, false, false, 232, null);
        this.channel = new BaseProperty<>(getServiceId(), 778, false, null, getLogPrefix("channel"), false, false, false, 232, null);
        this.overlay = new BaseProperty<>(getServiceId(), 780, true, null, getLogPrefix("overlay"), false, false, false, 232, null);
        this.keepcoup = new BaseProperty<>(getServiceId(), 781, false, null, getLogPrefix("keepcoup"), false, false, false, 232, null);
    }

    public final MessageAttr getPasswordAttr() {
        return this.passwordAttr;
    }

    public final void setPasswordAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.passwordAttr = messageAttr;
    }

    public final BaseProperty<Boolean> getOption() {
        return this.option;
    }

    public final BaseProperty<Boolean> getLock() {
        return this.lock;
    }

    public final BaseProperty<String> getPassword() {
        return this.password;
    }

    public final BaseProperty<Boolean> getRange() {
        return this.range;
    }

    public final BaseProperty<Boolean> getChannel() {
        return this.channel;
    }

    public final BaseProperty<Boolean> getOverlay() {
        return this.overlay;
    }

    public final BaseProperty<Boolean> getKeepcoup() {
        return this.keepcoup;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void bindAll(UpdateUIViewModel viewModel, LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        super.bindAll(viewModel, lifecycleOwner);
        BaseProperty<Boolean> baseProperty = this.lock;
        MutableLiveData<Boolean> mutableLiveData = viewModel.get(getServiceId(), 776);
        Intrinsics.checkNotNullExpressionValue(mutableLiveData, "viewModel.get(serviceId, MessageID.MSG_AUTO_LOCK)");
        baseProperty.bind(mutableLiveData, lifecycleOwner);
    }
}
