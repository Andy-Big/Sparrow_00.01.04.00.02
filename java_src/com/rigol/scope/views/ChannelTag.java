package com.rigol.scope.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TagView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\nH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/rigol/scope/views/ChannelTag;", "Lcom/rigol/scope/views/TagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "param", "Lcom/rigol/scope/data/VerticalParam;", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/rigol/scope/data/VerticalParam;)V", "updatePosition", "", "updateTag", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class ChannelTag extends TagView {
    private final VerticalParam param;

    public ChannelTag(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null, 4, null);
    }

    public /* synthetic */ ChannelTag(Context context, AttributeSet attributeSet, VerticalParam verticalParam, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i & 4) != 0 ? null : verticalParam);
    }

    public ChannelTag(Context context, AttributeSet attributeSet, VerticalParam verticalParam) {
        super(context, attributeSet);
        this.param = verticalParam;
        setId(View.generateViewId());
        VerticalParam verticalParam2 = this.param;
        setTag(verticalParam2 != null ? Integer.valueOf(verticalParam2.getServiceId()) : null);
        setShowBorder(true);
        setShowLine(false);
        setTextColor(ViewCompat.MEASURED_STATE_MASK);
        setTagWidth(35);
        setTagHeight(20);
        final VerticalParam verticalParam3 = this.param;
        if (verticalParam3 != null) {
            setText(String.valueOf((verticalParam3.getServiceId() - 1) + 1));
            setLabel(verticalParam3.getLabel());
            int color = ColorUtil.getColor(getContext(), verticalParam3.getChan());
            setLabelColor(color);
            setTagColor(color);
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            if (syncDataViewModel != null) {
                MutableLiveData<Object> mutableLiveData = syncDataViewModel.get(verticalParam3.getServiceId(), MessageID.MSG_CHAN_ACTIVE);
                if (mutableLiveData != null) {
                    Context context2 = getContext();
                    if (context2 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                    }
                    mutableLiveData.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.ChannelTag$$special$$inlined$let$lambda$4
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            this.updateTag();
                        }
                    });
                }
                MutableLiveData<Object> mutableLiveData2 = syncDataViewModel.get(verticalParam3.getServiceId(), MessageID.MSG_CHAN_ON_OFF);
                if (mutableLiveData2 != null) {
                    Context context3 = getContext();
                    if (context3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                    }
                    mutableLiveData2.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.ChannelTag$$special$$inlined$let$lambda$5
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            this.updateTag();
                        }
                    });
                }
                MutableLiveData<Object> mutableLiveData3 = syncDataViewModel.get(verticalParam3.getServiceId(), MessageID.MSG_CHAN_OFFSET_REAL);
                if (mutableLiveData3 != null) {
                    Context context4 = getContext();
                    if (context4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                    }
                    mutableLiveData3.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.ChannelTag$$special$$inlined$let$lambda$6
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            this.updatePosition();
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTag() {
        updatePosition();
        VerticalParam verticalParam = this.param;
        if (verticalParam != null) {
            setVisibility(verticalParam.getStatus() != ServiceEnum.enChanStatus.CHAN_OFF ? 0 : 8);
            boolean z = this.param.getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE;
            setTagStyle(z ? Paint.Style.FILL : Paint.Style.STROKE);
            int color = ColorUtil.getColor(getContext(), this.param.getChan());
            if (z) {
                color = ViewCompat.MEASURED_STATE_MASK;
            }
            setTextColor(color);
            if (z) {
                bringToFront();
            }
        }
    }

    public final void updatePosition() {
        if (getParent() == null) {
            return;
        }
        float valuePercent = ViewUtil.getValuePercent(this.param, 0L);
        ViewParent parent = getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        setPosition((int) (valuePercent * ((ViewGroup) parent).getHeight()));
    }
}
