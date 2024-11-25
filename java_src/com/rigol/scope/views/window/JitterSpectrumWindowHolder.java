package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.JitterViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.baseview.BaseSurfaceView;
import com.rigol.scope.views.grid.JitterSpectrumGridRulerView;
import com.rigol.scope.views.jitter.JitterPopupView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/rigol/scope/views/window/JitterSpectrumWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "content", "Lcom/rigol/scope/views/window/WindowContent;", "getContent", "()Lcom/rigol/scope/views/window/WindowContent;", "getContext", "()Landroid/content/Context;", "gridRulerView", "Lcom/rigol/scope/views/grid/JitterSpectrumGridRulerView;", "jitterParam", "Lcom/rigol/scope/data/JitterParam;", "surfaceView", "Lcom/rigol/scope/views/baseview/BaseSurfaceView;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateStatusText", "", "updateTitle", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class JitterSpectrumWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final WindowContent content;
    private final Context context;
    private final JitterSpectrumGridRulerView gridRulerView;
    private JitterParam jitterParam;
    private final BaseSurfaceView surfaceView;

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JitterSpectrumWindowHolder(Context context, WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Boolean> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        LiveData<JitterParam> liveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.context = context;
        JitterSpectrumGridRulerView jitterSpectrumGridRulerView = new JitterSpectrumGridRulerView(this.context, null, 0, 6, null);
        jitterSpectrumGridRulerView.setId(R.id.window_grid_line);
        Unit unit = Unit.INSTANCE;
        this.gridRulerView = jitterSpectrumGridRulerView;
        BaseSurfaceView baseSurfaceView = new BaseSurfaceView(this.context);
        baseSurfaceView.setId(View.generateViewId());
        baseSurfaceView.setParam(windowParam);
        Unit unit2 = Unit.INSTANCE;
        this.surfaceView = baseSurfaceView;
        WindowContent windowContent = new WindowContent(this.context);
        windowContent.setWindowParam(windowParam);
        windowContent.addView(this.surfaceView);
        windowContent.addView(this.gridRulerView);
        Unit unit3 = Unit.INSTANCE;
        this.content = windowContent;
        WindowSimpleBinding inflate = WindowSimpleBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "WindowSimpleBinding.infl…utInflater.from(context))");
        inflate.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.JitterSpectrumWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(JitterSpectrumWindowHolder.this);
            }
        });
        inflate.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.JitterSpectrumWindowHolder$binding$1$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(JitterPopupView.class);
            }
        });
        inflate.contentLayout.addView(this.content, -1, -1);
        Unit unit4 = Unit.INSTANCE;
        this.binding = inflate;
        updateStatusText();
        JitterViewModel jitterViewModel = (JitterViewModel) ContextUtil.getAppViewModel(JitterViewModel.class);
        if (jitterViewModel != null && (liveData = jitterViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData.observe((LifecycleOwner) topActivity, new Observer<JitterParam>() { // from class: com.rigol.scope.views.window.JitterSpectrumWindowHolder.1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(JitterParam jitterParam) {
                        JitterSpectrumWindowHolder.this.jitterParam = jitterParam;
                        JitterSpectrumWindowHolder.this.updateTitle();
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(52, MessageID.MSG_JITTER_SOURCE)) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) topActivity2, new Observer<Object>() { // from class: com.rigol.scope.views.window.JitterSpectrumWindowHolder.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    JitterSpectrumWindowHolder.this.updateTitle();
                }
            });
        }
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel == null || (mutableLiveData = updateUIViewModel.get(52, MessageID.MSG_JITTER_STATUS)) == null) {
            return;
        }
        Activity topActivity3 = ActivityUtils.getTopActivity();
        if (topActivity3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) topActivity3, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.JitterSpectrumWindowHolder.3
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean bool) {
                boolean UI_QueryBool = API.getInstance().UI_QueryBool(52, MessageID.MSG_JITTER_STATUS);
                TextView textView = JitterSpectrumWindowHolder.this.getBinding().status;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.status");
                textView.setVisibility(UI_QueryBool ? 0 : 8);
            }
        });
    }

    public final WindowContent getContent() {
        return this.content;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        JitterParam jitterParam = this.jitterParam;
        if (jitterParam != null) {
            this.binding.title.setTextColor(ColorUtil.getColor(this.context, jitterParam.getSource()));
            TextView textView = this.binding.title;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
            StringBuilder sb = new StringBuilder();
            MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_JITTER_SPECTRUM.value1);
            Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…TRUM.value1\n            )");
            sb.append(mappingObject.getStr());
            sb.append("(");
            sb.append(ViewUtil.getChanWinTitleStr(jitterParam.getSource()));
            sb.append(")");
            textView.setText(sb.toString());
        }
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateStatusText() {
        super.updateStatusText();
        this.binding.status.setText(R.string.inf_jit_analyzing);
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }
}
