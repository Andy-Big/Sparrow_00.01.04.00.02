package com.rigol.scope.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.internal.view.SupportMenu;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
/* compiled from: TagView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/rigol/scope/views/SearchTag;", "Lcom/rigol/scope/views/TagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "triggerViewModel", "Lcom/rigol/scope/viewmodels/TriggerViewModel;", "verticalViewModel", "Lcom/rigol/scope/viewmodels/VerticalViewModel;", "setPosition", "", "isShowLine", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class SearchTag extends TagView {
    private TriggerViewModel triggerViewModel;
    private VerticalViewModel verticalViewModel;

    public SearchTag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        setId(View.generateViewId());
        setTagWidth(35);
        setTagHeight(20);
        setTagColor(SupportMenu.CATEGORY_MASK);
        setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        setShowLine(false);
        setReverse(true);
        this.triggerViewModel = (TriggerViewModel) ContextUtil.getAppViewModel(TriggerViewModel.class);
        this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(41, MessageID.MSG_TRIGGER_COUPLING)) != null) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.SearchTag.1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SearchTag.this.setPosition(true);
                }
            });
        }
        if (syncDataViewModel == null || (mutableLiveData = syncDataViewModel.get(41, MessageID.MSG_TRIGGER_LEVEL)) == null) {
            return;
        }
        Context context3 = getContext();
        if (context3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.SearchTag.2
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchTag.this.setPosition(true);
            }
        });
    }

    public final void setPosition(boolean z) {
        TriggerViewModel triggerViewModel;
        LiveData<TriggerParam> liveData;
        TriggerParam value;
        LiveData<ArrayList<VerticalParam>> liveData2;
        if (getParent() == null || (triggerViewModel = this.triggerViewModel) == null || (liveData = triggerViewModel.getLiveData()) == null || (value = liveData.getValue()) == null) {
            return;
        }
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        ArrayList<VerticalParam> value2 = (verticalViewModel == null || (liveData2 = verticalViewModel.getLiveData()) == null) ? null : liveData2.getValue();
        if (value2 == null || !value2.isEmpty()) {
            float valuePercent = ViewUtil.getValuePercent(ViewUtil.getVerticalItem(value2, value.getChan()), value.getLevel());
            ViewParent parent = getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            setPosition((int) (valuePercent * ((ViewGroup) parent).getHeight()));
            setLineColor(ColorUtil.getColor(getContext(), value.getChan()));
            if (z) {
                showLine();
                hideLineDelay(3000L);
            }
        }
    }
}
