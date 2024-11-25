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
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.WindowWaveformBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.acquire.AcquireDepthView;
import com.rigol.scope.views.display.DisplayPopupView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/rigol/scope/views/window/WaveformWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowWaveformBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowWaveformBinding;", "horizontalParam", "Lcom/rigol/scope/data/HorizontalParam;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateTitle", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class WaveformWindowHolder extends WindowHolder {
    private final WindowWaveformBinding binding;
    private HorizontalParam horizontalParam;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WaveformWindowHolder(Context context, WindowParam windowParam) {
        super(windowParam);
        LiveData<SharedParam> liveData;
        MutableLiveData<Object> mutableLiveData;
        LiveData<HorizontalParam> liveData2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        WindowWaveformBinding inflate = WindowWaveformBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "WindowWaveformBinding.in…utInflater.from(context))");
        inflate.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.WaveformWindowHolder$binding$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(DisplayPopupView.class);
            }
        });
        TextView title = inflate.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…FORM.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.WaveformWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Activity topActivity = ActivityUtils.getTopActivity();
                if (topActivity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.MainActivity");
                }
                ((MainActivity) topActivity).getWaveformFragment().show_is_main = false;
                WindowHolderManager.getInstance().remove(WaveformWindowHolder.this);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.binding = inflate;
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null && (liveData2 = horizontalViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData2.observe((LifecycleOwner) topActivity, new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.window.WaveformWindowHolder.1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HorizontalParam horizontalParam) {
                        WaveformWindowHolder.this.horizontalParam = horizontalParam;
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(10, MessageID.MSG_HOR_UI_TIME_VIEW_MODE)) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity2, new Observer<Object>() { // from class: com.rigol.scope.views.window.WaveformWindowHolder.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WindowWaveformBinding windowWaveformBinding;
                    AcquireDepthView acquireDepthView;
                    AcquireDepthView acquireDepthView2;
                    HorizontalParam horizontalParam = WaveformWindowHolder.this.horizontalParam;
                    if (horizontalParam != null) {
                        if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
                            WindowWaveformBinding binding = WaveformWindowHolder.this.getBinding();
                            windowWaveformBinding = binding instanceof WindowWaveformBinding ? binding : null;
                            if (windowWaveformBinding != null && (acquireDepthView2 = windowWaveformBinding.acquireDepth) != null) {
                                acquireDepthView2.setVisibility(8);
                            }
                        } else {
                            WindowWaveformBinding binding2 = WaveformWindowHolder.this.getBinding();
                            windowWaveformBinding = binding2 instanceof WindowWaveformBinding ? binding2 : null;
                            if (windowWaveformBinding != null && (acquireDepthView = windowWaveformBinding.acquireDepth) != null) {
                                acquireDepthView.setVisibility(0);
                            }
                        }
                    }
                    WaveformWindowHolder.this.updateTitle();
                }
            });
        }
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel == null || (liveData = sharedViewModel.getLiveData()) == null) {
            return;
        }
        Activity topActivity3 = ActivityUtils.getTopActivity();
        if (topActivity3 != null) {
            liveData.observe((LifecycleOwner) topActivity3, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.WaveformWindowHolder.3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(SharedParam sharedParam) {
                    WaveformWindowHolder.this.getBinding().setSharedParam(sharedParam);
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public final WindowWaveformBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        HorizontalParam horizontalParam = this.horizontalParam;
        if (horizontalParam != null) {
            if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
                TextView textView = this.binding.title;
                Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
                StringBuilder sb = new StringBuilder();
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.value1);
                Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…ue1\n                    )");
                sb.append(mappingObject.getStr());
                sb.append("(ROLL)");
                textView.setText(sb.toString());
                return;
            }
            TextView textView2 = this.binding.title;
            Intrinsics.checkNotNullExpressionValue(textView2, "binding.title");
            MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.value1);
            Intrinsics.checkNotNullExpressionValue(mappingObject2, "ViewUtil.getMappingObjec….value1\n                )");
            textView2.setText(mappingObject2.getStr());
        }
    }
}
