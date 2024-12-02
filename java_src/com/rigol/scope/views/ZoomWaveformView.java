package com.rigol.scope.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.views.baseview.BaseWaveformView;

/* loaded from: classes2.dex */
public class ZoomWaveformView extends BaseWaveformView {
    public ZoomWaveformView(Context context) {
        super(context);
        init();
    }

    public ZoomWaveformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ZoomWaveformView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    @Override // com.rigol.scope.views.baseview.BaseWaveformView, com.rigol.scope.views.window.WindowContent, android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            postDelayed(new Runnable() { // from class: com.rigol.scope.views.-$$Lambda$ZoomWaveformView$DuwiN6PoXc51oDMF5xYl1mk4hpk
                @Override // java.lang.Runnable
                public final void run() {
                    ZoomWaveformView.this.lambda$onSizeChanged$0$ZoomWaveformView();
                }
            }, 200L);
        }
    }

    public /* synthetic */ void lambda$onSizeChanged$0$ZoomWaveformView() {
        lambda$addTriggerPointTag$46$BaseWaveformView(true);
        updateExpandTagPositionByMain();
        upAddLaTag(0.0f);
    }

    public void init() {
        WindowParam windowParam = new WindowParam();
        windowParam.setType(ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM);
        setWindowParam(windowParam);
        addDecodeViews();
        addDecodeThresLine();
        addMathThresLine();
        addSearchThresLine();
        addMeasureHighThresLine();
        addMeasureMidThresLine();
        addMeasureLowThresLine();
        addExpandTag();
        addTriggerPointTag(true);
        addTriggerLevelTag();
        addTriggerLevelTagA();
        addTriggerLevelTagB();
        addDecodeTags();
        addChannelTags();
        addCursorTags();
        bindCursor();
        bindMeasureCursor();
        addIndicators();
        bindIndicator();
        bindRef();
        if (this.syncDataViewModel != null) {
            this.syncDataViewModel.get(10, MessageID.MSG_HOR_ZOOM_SCALE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.-$$Lambda$ZoomWaveformView$gj-24TeazKEuOvgXjzannAjIiCg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZoomWaveformView.this.lambda$init$1$ZoomWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(10, MessageID.MSG_HOR_ZOOM_OFFSET).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.-$$Lambda$ZoomWaveformView$oVj_CEg0VmsZO9mjPqpM4ql0R8o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZoomWaveformView.this.lambda$init$2$ZoomWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(60, MessageID.MSG_LA_ENABLE).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.-$$Lambda$ZoomWaveformView$tFYn4HXDulq_uVzPw630Qpc4Mao
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ZoomWaveformView.this.lambda$init$3$ZoomWaveformView(obj);
                }
            });
        }
        ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.-$$Lambda$ZoomWaveformView$3MmWT9Yrjex7WQj2NtxzihYKF7Q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZoomWaveformView.this.lambda$init$4$ZoomWaveformView((SharedParam) obj);
            }
        });
    }

    public /* synthetic */ void lambda$init$1$ZoomWaveformView(Object obj) {
        lambda$addTriggerPointTag$46$BaseWaveformView(true);
        updateExpandTagPositionByMain();
    }

    public /* synthetic */ void lambda$init$2$ZoomWaveformView(Object obj) {
        lambda$addTriggerPointTag$46$BaseWaveformView(true);
        updateExpandTagPositionByMain();
    }

    public /* synthetic */ void lambda$init$3$ZoomWaveformView(Object obj) {
        addLaTag();
    }

    public /* synthetic */ void lambda$init$4$ZoomWaveformView(final SharedParam sharedParam) {
        sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.ZoomWaveformView.1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                int[] iArr = new int[2];
                ZoomWaveformView.this.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                View view = (View) ZoomWaveformView.this.getParent();
                if (i == 833) {
                    sharedParam.getShowResultBar();
                    if (ZoomWaveformView.this.getWidth() + i2 == view.getRootView().getWidth() - 12 && sharedParam.getShowResultBar()) {
                        ZoomWaveformView.this.setCursorTags();
                    } else {
                        ZoomWaveformView.this.resetCursorTags();
                    }
                }
                if (i == 1033) {
                    if (i2 + ZoomWaveformView.this.getWidth() == view.getRootView().getWidth() - 12 && sharedParam.getShowResultBar()) {
                        ZoomWaveformView.this.setCursorTags();
                    } else {
                        ZoomWaveformView.this.resetCursorTags();
                    }
                }
            }
        });
    }

    public void updateExpandTagPositionByMain() {
        HorizontalParam value;
        int width;
        if (this.horizontalViewModel == null || (value = this.horizontalViewModel.getLiveData().getValue()) == null) {
            return;
        }
        int expandTagPosition = getExpandTagPosition(getWidth());
        float valuePercent = ViewUtil.getValuePercent(this.horizontalViewModel.getLiveData().getValue(), 0L, false);
        if (getWidth() == 1000) {
            width = getWidth();
        } else {
            width = getWidth() - 1;
        }
        this.expandTag.setPosition((int) (this.triggerPointTag.getPosition() + (((expandTagPosition - (valuePercent * width)) * ((float) value.getMainScale())) / ((float) value.getZoomScale()))));
    }
}
