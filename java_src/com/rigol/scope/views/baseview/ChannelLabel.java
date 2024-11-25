package com.rigol.scope.views.baseview;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LabelView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/rigol/scope/views/baseview/ChannelLabel;", "Lcom/rigol/scope/views/baseview/LabelView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "param", "Lcom/rigol/scope/data/VerticalParam;", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/rigol/scope/data/VerticalParam;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class ChannelLabel extends LabelView {
    public ChannelLabel(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null, 4, null);
    }

    public /* synthetic */ ChannelLabel(Context context, AttributeSet attributeSet, VerticalParam verticalParam, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i & 4) != 0 ? null : verticalParam);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelLabel(final Context context, AttributeSet attributeSet, final VerticalParam verticalParam) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        setVisibility(8);
        if (verticalParam != null) {
            setTextColor(ColorUtil.getColor(context, verticalParam.getServiceId()));
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            if (syncDataViewModel != null) {
                MutableLiveData<Object> mutableLiveData = syncDataViewModel.get(verticalParam.getServiceId(), MessageID.MSG_CHAN_ACTIVE);
                if (mutableLiveData != null) {
                    Activity topActivity = ActivityUtils.getTopActivity();
                    if (topActivity == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                    }
                    mutableLiveData.observe((LifecycleOwner) topActivity, new Observer<Object>() { // from class: com.rigol.scope.views.baseview.ChannelLabel$$special$$inlined$let$lambda$3
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            if (verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE) {
                                ChannelLabel.this.bringToFront();
                            }
                        }
                    });
                }
                MutableLiveData<Object> mutableLiveData2 = syncDataViewModel.get(verticalParam.getServiceId(), MessageID.MSG_CHAN_ON_OFF);
                if (mutableLiveData2 != null) {
                    Activity topActivity2 = ActivityUtils.getTopActivity();
                    if (topActivity2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                    }
                    mutableLiveData2.observe((LifecycleOwner) topActivity2, new Observer<Object>() { // from class: com.rigol.scope.views.baseview.ChannelLabel$$special$$inlined$let$lambda$4
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            if (verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE) {
                                ChannelLabel.this.bringToFront();
                            }
                        }
                    });
                }
            }
        }
    }
}
