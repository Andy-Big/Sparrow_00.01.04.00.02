package com.rigol.scope.views.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
/* loaded from: classes2.dex */
public class MainWaveformView extends BaseWaveformView {
    public MainWaveformView(Context context) {
        super(context);
        init();
    }

    public MainWaveformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MainWaveformView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.BaseWaveformView, com.rigol.scope.views.window.WindowContent, android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            postDelayed(new Runnable() { // from class: com.rigol.scope.views.baseview.-$$Lambda$MainWaveformView$hMxzPn5PIrYFUpC1LjC2eILKqY0
                @Override // java.lang.Runnable
                public final void run() {
                    MainWaveformView.this.lambda$onSizeChanged$0$MainWaveformView();
                }
            }, 0L);
        }
    }

    public /* synthetic */ void lambda$onSizeChanged$0$MainWaveformView() {
        lambda$addTriggerPointTag$46$BaseWaveformView(false);
        updateExpandTagPosition();
        updateCursorA_B();
        upAddLaTag(0.0f);
    }

    public void init() {
        WindowParam windowParam = new WindowParam();
        windowParam.setType(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM);
        setWindowParam(windowParam);
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null) {
            measureSettingViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.baseview.MainWaveformView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(MeasureSettingParam measureSettingParam) {
                }
            });
        }
        addDecodeViews();
        addDecodeThresLine();
        addMathThresLine();
        addSearchThresLine();
        addMeasureHighThresLine();
        addMeasureMidThresLine();
        addMeasureLowThresLine();
        addExpandTag();
        addTriggerPointTag(false);
        addTriggerLevelTag();
        addTriggerLevelTagA();
        addTriggerLevelTagB();
        addDecodeTags();
        addChannelTags();
        addCursorTags();
        bindCursor();
        bindMeasureCursor();
        addHistogramRect();
        bindHistogram();
        addIndicators();
        bindIndicator();
        bindRef();
        if (this.syncDataViewModel != null) {
            this.syncDataViewModel.get(10, MessageID.MSG_HOR_MAIN_OFFSET).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$MainWaveformView$G5MxdG7oXKGEME6HANMwbPPnBWY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MainWaveformView.this.lambda$init$1$MainWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(10, MessageID.MSG_HOR_EXPAND).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$MainWaveformView$Qt3deS9so5530azYaL8YTZNY1ZM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MainWaveformView.this.lambda$init$2$MainWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(10, MessageID.MSG_HOR_EXPAND_USER).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$MainWaveformView$4NOG1vjsStcStJ0ZOJS5OX8VH2w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MainWaveformView.this.lambda$init$3$MainWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(60, MessageID.MSG_LA_ENABLE).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$MainWaveformView$O2X3LtCc_MCWFazvJCjuPgD8dms
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MainWaveformView.this.lambda$init$4$MainWaveformView(obj);
                }
            });
        }
        ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$MainWaveformView$Fb8OcpXYYm7CQfRYsmUzvviKbnQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainWaveformView.this.lambda$init$5$MainWaveformView((SharedParam) obj);
            }
        });
    }

    public /* synthetic */ void lambda$init$1$MainWaveformView(Object obj) {
        lambda$addTriggerPointTag$46$BaseWaveformView(false);
    }

    public /* synthetic */ void lambda$init$2$MainWaveformView(Object obj) {
        updateExpandTagPosition();
    }

    public /* synthetic */ void lambda$init$3$MainWaveformView(Object obj) {
        updateExpandTagPosition();
    }

    public /* synthetic */ void lambda$init$4$MainWaveformView(Object obj) {
        addLaTag();
    }

    public /* synthetic */ void lambda$init$5$MainWaveformView(final SharedParam sharedParam) {
        sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.baseview.MainWaveformView.2
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                int[] iArr = new int[2];
                MainWaveformView.this.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                View view = (View) MainWaveformView.this.getParent();
                if (i == 833) {
                    sharedParam.getShowResultBar();
                    if (MainWaveformView.this.getWidth() + i2 == view.getRootView().getWidth() - 12 && sharedParam.getShowResultBar()) {
                        MainWaveformView.this.setCursorTags();
                    } else {
                        MainWaveformView.this.resetCursorTags();
                    }
                }
                if (i == 1033) {
                    if (i2 + MainWaveformView.this.getWidth() == view.getRootView().getWidth() - 12 && sharedParam.getShowResultBar()) {
                        MainWaveformView.this.setCursorTags();
                    } else {
                        MainWaveformView.this.resetCursorTags();
                    }
                }
            }
        });
    }
}
