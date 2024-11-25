package com.rigol.scope.views.wave;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.widget.SeekBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.DisplayParam;
import com.rigol.scope.databinding.PopupviewWaveIntensityBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.DisplayViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WaveIntensityPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/rigol/scope/views/wave/WaveIntensityPopupView;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "()V", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "runnable", "Ljava/lang/Runnable;", "getRunnable", "()Ljava/lang/Runnable;", "setRunnable", "(Ljava/lang/Runnable;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class WaveIntensityPopupView extends BasePopupView {
    private Handler handler;
    private Runnable runnable;

    public WaveIntensityPopupView() {
        super((int) R.style.App_PopupWindow_WaveIntensity);
        LiveData<DisplayParam> liveData;
        this.handler = new Handler();
        this.runnable = new Runnable() { // from class: com.rigol.scope.views.wave.WaveIntensityPopupView$runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                WaveIntensityPopupView.this.dismiss();
            }
        };
        PopupviewWaveIntensityBinding inflate = PopupviewWaveIntensityBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewWaveIntensityBi…utInflater.from(context))");
        setContentView(inflate.getRoot());
        ViewModel appViewModel = ContextUtil.getAppViewModel(SyncDataViewModel.class);
        Intrinsics.checkNotNullExpressionValue(appViewModel, "ContextUtil.getAppViewMo…ataViewModel::class.java)");
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) appViewModel;
        DisplayViewModel displayViewModel = (DisplayViewModel) ContextUtil.getAppViewModel(DisplayViewModel.class);
        final DisplayParam value = (displayViewModel == null || (liveData = displayViewModel.getLiveData()) == null) ? null : liveData.getValue();
        inflate.setParam(value);
        MutableLiveData<Object> mutableLiveData = syncDataViewModel.get(26, MessageID.MSG_DISPLAY_WAVE_INTENSITY);
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) topActivity, new Observer<Object>() { // from class: com.rigol.scope.views.wave.WaveIntensityPopupView.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DisplayParam displayParam = value;
                Intrinsics.checkNotNull(displayParam);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                displayParam.setWaveIntensity(((Integer) obj).intValue());
                value.saveWaveIntensity(((Number) obj).intValue());
                WaveIntensityPopupView.this.getHandler().removeCallbacks(WaveIntensityPopupView.this.getRunnable());
                WaveIntensityPopupView.this.getHandler().postDelayed(WaveIntensityPopupView.this.getRunnable(), 3000L);
            }
        });
        inflate.waveIntensitySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.views.wave.WaveIntensityPopupView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                Intrinsics.checkNotNullParameter(seekBar, "seekBar");
                DisplayParam displayParam = value;
                if (displayParam != null) {
                    displayParam.saveWaveIntensity(i);
                }
                WaveIntensityPopupView.this.getHandler().removeCallbacks(WaveIntensityPopupView.this.getRunnable());
                WaveIntensityPopupView.this.getHandler().postDelayed(WaveIntensityPopupView.this.getRunnable(), 3000L);
            }
        });
    }

    public final Handler getHandler() {
        return this.handler;
    }

    public final void setHandler(Handler handler) {
        Intrinsics.checkNotNullParameter(handler, "<set-?>");
        this.handler = handler;
    }

    public final Runnable getRunnable() {
        return this.runnable;
    }

    public final void setRunnable(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.runnable = runnable;
    }
}
