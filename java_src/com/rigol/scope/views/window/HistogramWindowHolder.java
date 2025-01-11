package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BaseSurfaceView;
import com.rigol.scope.views.grid.MeasHistogramGridRulerView;
import com.rigol.scope.views.histogram.HistogramResultParam;
import com.rigol.scope.views.histogram.HistogramViewModel;
import com.rigol.scope.views.measure.MeasureSettingPopupView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/rigol/scope/views/window/HistogramWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "content", "Lcom/rigol/scope/views/window/WindowContent;", "getContent", "()Lcom/rigol/scope/views/window/WindowContent;", "getContext", "()Landroid/content/Context;", "gridRulerView", "Lcom/rigol/scope/views/grid/MeasHistogramGridRulerView;", "histogramResultParam", "Lcom/rigol/scope/views/histogram/HistogramResultParam;", "measureSettingParam", "Lcom/rigol/scope/data/MeasureSettingParam;", "surfaceView", "Lcom/rigol/scope/views/baseview/BaseSurfaceView;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateStatusText", "", "updateTitle", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HistogramWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final WindowContent content;
    private final Context context;
    private final MeasHistogramGridRulerView gridRulerView;
    private HistogramResultParam histogramResultParam;
    private MeasureSettingParam measureSettingParam;
    private final BaseSurfaceView surfaceView;

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.HistogramWindowHolder$$special$$inlined$apply$lambda$1.onClick(android.view.View):void, com.rigol.scope.views.window.HistogramWindowHolder$$special$$inlined$apply$lambda$2.onClick(android.view.View):void] */
    public static final /* synthetic */ MeasureSettingParam access$getMeasureSettingParam$p(HistogramWindowHolder histogramWindowHolder) {
        return histogramWindowHolder.measureSettingParam;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistogramWindowHolder(Context context, WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Object> mutableLiveData;
        LiveData<MeasureSettingParam> liveData;
        LiveData<HistogramResultParam> liveData2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.context = context;
        MeasHistogramGridRulerView measHistogramGridRulerView = new MeasHistogramGridRulerView(this.context, null, 0, 6, null);
        measHistogramGridRulerView.setId(R.id.window_grid_line);
        Unit unit = Unit.INSTANCE;
        this.gridRulerView = measHistogramGridRulerView;
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
        inflate.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.HistogramWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(HistogramWindowHolder.this);
                MeasureSettingParam access$getMeasureSettingParam$p = HistogramWindowHolder.access$getMeasureSettingParam$p(HistogramWindowHolder.this);
                if (access$getMeasureSettingParam$p != null) {
                    access$getMeasureSettingParam$p.saveHistoEnable(false);
                }
            }
        });
        inflate.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.HistogramWindowHolder$$special$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(MeasureSettingPopupView.class);
                MeasureSettingParam access$getMeasureSettingParam$p = HistogramWindowHolder.access$getMeasureSettingParam$p(HistogramWindowHolder.this);
                if (access$getMeasureSettingParam$p != null) {
                    access$getMeasureSettingParam$p.saveHistoEnable(false);
                }
            }
        });
        ImageButton windowSetting = inflate.windowSetting;
        Intrinsics.checkNotNullExpressionValue(windowSetting, "windowSetting");
        windowSetting.setVisibility(8);
        inflate.contentLayout.addView(this.content, -1, -1);
        Unit unit4 = Unit.INSTANCE;
        this.binding = inflate;
        updateStatusText();
        HistogramViewModel histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class);
        if (histogramViewModel != null && (liveData2 = histogramViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData2.observe((LifecycleOwner) topActivity, new Observer<HistogramResultParam>() { // from class: com.rigol.scope.views.window.HistogramWindowHolder.1
                    {
                        HistogramWindowHolder.this = this;
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HistogramResultParam histogramResultParam) {
                        HistogramWindowHolder.this.histogramResultParam = histogramResultParam;
                        HistogramWindowHolder.this.updateTitle();
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null && (liveData = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 != null) {
                liveData.observe((LifecycleOwner) topActivity2, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.window.HistogramWindowHolder.2
                    {
                        HistogramWindowHolder.this = this;
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        HistogramWindowHolder.this.measureSettingParam = measureSettingParam;
                        HistogramWindowHolder.this.updateTitle();
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_HISTO_WINDOW_TITLE)) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity3, new Observer<Object>() { // from class: com.rigol.scope.views.window.HistogramWindowHolder.3
                {
                    HistogramWindowHolder.this = this;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HistogramWindowHolder.this.updateTitle();
                }
            });
        }
        LiveData<SharedParam> liveData3 = ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData();
        Activity topActivity4 = ActivityUtils.getTopActivity();
        if (topActivity4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        liveData3.observe((LifecycleOwner) topActivity4, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.HistogramWindowHolder.4
            {
                HistogramWindowHolder.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(final SharedParam sharedParam) {
                sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.HistogramWindowHolder.4.1
                    {
                        AnonymousClass4.this = this;
                    }

                    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                    public void onPropertyChanged(Observable observable, int i) {
                        if (sharedParam.getShowResultBar()) {
                            HistogramWindowHolder.this.gridRulerView.setAbout(false);
                            HistogramWindowHolder.this.gridRulerView.invalidate();
                            return;
                        }
                        HistogramWindowHolder.this.gridRulerView.setAbout(true);
                        HistogramWindowHolder.this.gridRulerView.invalidate();
                    }
                });
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
        if (this.histogramResultParam != null) {
            this.binding.title.setTextColor(ColorUtil.getColor(this.context, 28));
            TextView textView = this.binding.title;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
            MeasureSettingParam measureSettingParam = this.measureSettingParam;
            textView.setText(measureSettingParam != null ? measureSettingParam.readMeasHistoWindowTitle() : null);
        }
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateStatusText() {
        super.updateStatusText();
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }
}
