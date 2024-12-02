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
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.baseview.BaseSurfaceView;
import com.rigol.scope.views.eye.EyePopupView;
import com.rigol.scope.views.eye.EyeTemplateView;
import com.rigol.scope.views.grid.EyeGridRulerView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/rigol/scope/views/window/EyeWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "content", "Lcom/rigol/scope/views/window/WindowContent;", "getContext", "()Landroid/content/Context;", "eyeParam", "Lcom/rigol/scope/data/EyeParam;", "gridRulerView", "Lcom/rigol/scope/views/grid/EyeGridRulerView;", "surfaceView", "Lcom/rigol/scope/views/baseview/BaseSurfaceView;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateStatusText", "", "updateTemplate", "updateTitle", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class EyeWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final WindowContent content;
    private final Context context;
    private EyeParam eyeParam;
    private final EyeGridRulerView gridRulerView;
    private final BaseSurfaceView surfaceView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EyeWindowHolder(Context context, final WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Boolean> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        MutableLiveData<Object> mutableLiveData5;
        LiveData<EyeParam> liveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.context = context;
        EyeGridRulerView eyeGridRulerView = new EyeGridRulerView(this.context, null, 0, 6, null);
        eyeGridRulerView.setId(R.id.window_grid_line);
        Unit unit = Unit.INSTANCE;
        this.gridRulerView = eyeGridRulerView;
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
        TextView title = inflate.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_EYE.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…_EYE.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.EyeWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(EyeWindowHolder.this);
            }
        });
        inflate.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.EyeWindowHolder$binding$1$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(EyePopupView.class);
            }
        });
        inflate.contentLayout.addView(this.content, -1, -1);
        Unit unit4 = Unit.INSTANCE;
        this.binding = inflate;
        updateWarningText();
        updateStatusText();
        EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
        if (eyeViewModel != null && (liveData = eyeViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData.observe((LifecycleOwner) topActivity, new Observer<EyeParam>() { // from class: com.rigol.scope.views.window.EyeWindowHolder.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(EyeParam eyeParam) {
                        BaseProperty<Integer> chan;
                        EyeWindowHolder.this.eyeParam = eyeParam;
                        EyeParam eyeParam2 = EyeWindowHolder.this.eyeParam;
                        if (eyeParam2 != null && (chan = eyeParam2.getChan()) != null) {
                            chan.save(Integer.valueOf(windowParam.getSource1().value1));
                        }
                        EyeWindowHolder.this.updateTitle();
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData5 = syncDataViewModel.get(51, MessageID.MSG_WINDOW_TITLE)) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData5.observe((LifecycleOwner) topActivity2, new Observer<Object>() { // from class: com.rigol.scope.views.window.EyeWindowHolder.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EyeWindowHolder.this.updateTitle();
                }
            });
        }
        if (syncDataViewModel != null && (mutableLiveData4 = syncDataViewModel.get(51, MessageID.MSG_EYE_TEMPLATE_STATUS)) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData4.observe((LifecycleOwner) topActivity3, new Observer<Object>() { // from class: com.rigol.scope.views.window.EyeWindowHolder.3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EyeWindowHolder.this.updateTemplate();
                }
            });
        }
        if (syncDataViewModel != null && (mutableLiveData3 = syncDataViewModel.get(51, MessageID.MSG_EYE_TEMPLATE)) != null) {
            Activity topActivity4 = ActivityUtils.getTopActivity();
            if (topActivity4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) topActivity4, new Observer<Object>() { // from class: com.rigol.scope.views.window.EyeWindowHolder.4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EyeWindowHolder.this.updateTemplate();
                }
            });
        }
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(51, MessageID.MSG_EYE_ERR)) != null) {
            Activity topActivity5 = ActivityUtils.getTopActivity();
            if (topActivity5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) topActivity5, new Observer<Object>() { // from class: com.rigol.scope.views.window.EyeWindowHolder.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EyeParam eyeParam = EyeWindowHolder.this.eyeParam;
                    if (eyeParam != null) {
                        if (eyeParam.getEyeErr().getValue().intValue() == ServiceEnum.EyeErr.EyeErr_Timebase_Large.value1) {
                            EyeWindowHolder.this.getBinding().warning.setText(R.string.err_eye_scale_large);
                        } else if (eyeParam.getEyeErr().getValue().intValue() == ServiceEnum.EyeErr.EyeErr_Timebase_Small.value1) {
                            EyeWindowHolder.this.getBinding().warning.setText(R.string.err_eye_scale_small);
                        }
                        TextView textView = EyeWindowHolder.this.getBinding().warning;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.warning");
                        textView.setVisibility(eyeParam.getEyeErr().getValue().intValue() == ServiceEnum.EyeErr.EyeErr_None.value1 ? 8 : 0);
                        TextView textView2 = EyeWindowHolder.this.getBinding().warning;
                        Intrinsics.checkNotNullExpressionValue(textView2, "binding.warning");
                        if (textView2.getVisibility() == 0) {
                            TextView textView3 = EyeWindowHolder.this.getBinding().status;
                            Intrinsics.checkNotNullExpressionValue(textView3, "binding.status");
                            textView3.setVisibility(8);
                        }
                    }
                }
            });
        }
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel == null || (mutableLiveData = updateUIViewModel.get(ResultListAdapter.MODULE_KEY_EYE_TEXT_STATUS)) == null) {
            return;
        }
        Activity topActivity6 = ActivityUtils.getTopActivity();
        if (topActivity6 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) topActivity6, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.EyeWindowHolder.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean bool) {
                boolean UI_QueryBool = API.getInstance().UI_QueryBool(51, MessageID.MSG_EYE_QUERY_STATUS);
                TextView textView = EyeWindowHolder.this.getBinding().status;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.status");
                textView.setVisibility(!UI_QueryBool ? 0 : 8);
            }
        });
    }

    public final Context getContext() {
        return this.context;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTemplate() {
        EyeParam eyeParam = this.eyeParam;
        if (eyeParam != null) {
            if (eyeParam.getTemplateFlag().getValue().booleanValue()) {
                if (this.content.findViewById(R.id.window_eye_template) == null) {
                    EyeTemplateView eyeTemplateView = new EyeTemplateView(this.context, ServiceEnum.getEyeTemplateFromValue1(eyeParam.getEyeTemplate().getValue().intValue()));
                    eyeTemplateView.setId(R.id.window_eye_template);
                    this.content.addView(eyeTemplateView);
                    return;
                }
                return;
            }
            View findViewById = this.content.findViewById(R.id.window_eye_template);
            if (findViewById != null) {
                this.content.removeView(findViewById);
            }
        }
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        EyeParam eyeParam = this.eyeParam;
        if (eyeParam != null) {
            this.binding.title.setTextColor(ColorUtil.getColor(this.context, ServiceEnum.getChanFromValue1(eyeParam.getChan().getValue().intValue())));
            TextView textView = this.binding.title;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
            textView.setText(eyeParam.getEyeTitleString().getValue());
        }
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateStatusText() {
        super.updateStatusText();
        this.binding.status.setText(R.string.inf_eye_analyzing);
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }
}
