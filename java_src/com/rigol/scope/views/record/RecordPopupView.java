package com.rigol.scope.views.record;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.databinding.PopupviewWaveRecordBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.WaveRecordViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class RecordPopupView extends BasePopupView implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    private final PopupviewWaveRecordBinding binding;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private WaveRecordParam param;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public RecordPopupView() {
        super((int) R.style.App_PopupWindow_Record);
        this.list_aorbParam = new ArrayList();
        PopupviewWaveRecordBinding inflate = PopupviewWaveRecordBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        WaveRecordViewModel waveRecordViewModel = (WaveRecordViewModel) ContextUtil.getAppViewModel(WaveRecordViewModel.class);
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.record.-$$Lambda$RecordPopupView$_PmXx3WGKl17TlTy9RZuWcyZXak
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecordPopupView.this.lambda$new$0$RecordPopupView((HorizontalParam) obj);
                }
            });
        }
        if (waveRecordViewModel != null) {
            waveRecordViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.record.-$$Lambda$RecordPopupView$wRLhX1u-FCeJnoOnvhRrEFOUM6g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecordPopupView.this.lambda$new$1$RecordPopupView((WaveRecordParam) obj);
                }
            });
        }
        initPopWindow();
    }

    public /* synthetic */ void lambda$new$0$RecordPopupView(HorizontalParam horizontalParam) {
        this.binding.setHorizontalParam(horizontalParam);
    }

    public /* synthetic */ void lambda$new$1$RecordPopupView(final WaveRecordParam waveRecordParam) {
        this.param = waveRecordParam;
        this.binding.setParam(waveRecordParam);
        if (waveRecordParam != null) {
            waveRecordParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.record.RecordPopupView.1
                @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                public void onPropertyChanged(Observable observable, int i) {
                    if (i == 906) {
                        View findViewById = RecordPopupView.this.binding.getRoot().findViewById(R.id.close);
                        if (waveRecordParam.getState() == ServiceEnum.RecordState.Play_ing || waveRecordParam.getState() == ServiceEnum.RecordState.Record_ing) {
                            findViewById.setEnabled(false);
                            findViewById.setAlpha(ContextUtil.getAlpha(false));
                            RecordPopupView.this.setOutsideTouchable(false);
                        } else {
                            findViewById.setEnabled(true);
                            findViewById.setAlpha(ContextUtil.getAlpha(true));
                            RecordPopupView.this.setOutsideTouchable(true);
                        }
                        RecordPopupView.this.update();
                    }
                }
            });
        }
    }

    private void initPopWindow() {
        ViewUtil.setSwitchButton(this.binding.recordOnoffSwitchButton);
        ViewUtil.setSwitchButton(this.binding.recordMinSwitchButton);
        this.binding.recordOnoffSwitchButton.setOnCheckedChangeListener(this);
        this.binding.recordMinSwitchButton.setOnCheckedChangeListener(this);
        this.binding.recordCurrentValue.setOnClickListener(this);
        this.binding.recordPlayintervalValue.setOnClickListener(this);
        this.binding.recordIntervalValue.setOnClickListener(this);
        this.binding.recordFramesValue.setOnClickListener(this);
        this.binding.recordMaxframesButton.setOnClickListener(this);
        this.binding.recordStartframeValue.setOnClickListener(this);
        this.binding.recordEndframeValue.setOnClickListener(this);
        this.binding.recordStartImageView.setOnClickListener(this);
        this.binding.recordBeeperImageView.setOnClickListener(this);
        this.binding.playMode.setOnClickListener(this);
        this.binding.recordTostart.setOnClickListener(this);
        this.binding.playLast.setOnClickListener(this);
        this.binding.play.setOnClickListener(this);
        this.binding.playNext.setOnClickListener(this);
        this.binding.recordToend.setOnClickListener(this);
        this.binding.playOrder.setOnClickListener(this);
        this.binding.recordSeekBar.setOnSeekBarChangeListener(this);
        this.binding.playSeekBar.setOnSeekBarChangeListener(this);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.recordFramesValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.recordIntervalValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.recordCurrentValue, 0, false, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.recordPlayintervalValue, 0, false, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.recordStartframeValue, 0, false, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.recordEndframeValue, 0, false, ViewUtil.KEY_A, 2));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.record.RecordPopupView.2
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                RecordPopupView.this.aorBManager.showKey(RecordPopupView.this.context, ((AorBParam) RecordPopupView.this.list_aorbParam.get(i)).getTextView(), true, ((AorBParam) RecordPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                RecordPopupView.this.aorBManager.showKey(RecordPopupView.this.context, ((AorBParam) RecordPopupView.this.list_aorbParam.get(i)).getTextView(), false, ((AorBParam) RecordPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.recordFramesValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.recordIntervalValue, true, ViewUtil.KEY_B);
        PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        this.panelKeyViewModel = panelKeyViewModel;
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.record.-$$Lambda$RecordPopupView$GovUF0E3m-Hrldij_o-vF-v98RQ
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    RecordPopupView.this.lambda$initPopWindow$3$RecordPopupView((KeyEvent) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$initPopWindow$3$RecordPopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(RecordPopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.record.-$$Lambda$RecordPopupView$ibZpRNSgMJ05no8fGSua5CUd1P0
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    RecordPopupView.this.lambda$initPopWindow$2$RecordPopupView(keyboardPopupView);
                }
            });
        }
    }

    public /* synthetic */ void lambda$initPopWindow$2$RecordPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        switch (view.getId()) {
            case R.id.play /* 2131363590 */:
                WaveRecordParam waveRecordParam = this.param;
                waveRecordParam.saveRecordPlay(!waveRecordParam.isRecordPlay());
                return;
            case R.id.play_last /* 2131363595 */:
                WaveRecordParam waveRecordParam2 = this.param;
                waveRecordParam2.saveRecordCurrent(waveRecordParam2.getRecordCurrent() - 1);
                return;
            case R.id.play_mode /* 2131363596 */:
                WaveRecordParam waveRecordParam3 = this.param;
                waveRecordParam3.saveRecordPlayMode(!waveRecordParam3.isRecordPlayMode());
                return;
            case R.id.play_next /* 2131363597 */:
                WaveRecordParam waveRecordParam4 = this.param;
                waveRecordParam4.saveRecordCurrent(waveRecordParam4.getRecordCurrent() + 1);
                return;
            case R.id.play_order /* 2131363601 */:
                WaveRecordParam waveRecordParam5 = this.param;
                waveRecordParam5.saveRecordPlayDir(!waveRecordParam5.isRecordPlayDir());
                return;
            case R.id.record_beeper_imageView /* 2131363693 */:
                WaveRecordParam waveRecordParam6 = this.param;
                waveRecordParam6.saveRecordBeeper(!waveRecordParam6.isRecordBeeper());
                return;
            case R.id.record_current_value /* 2131363695 */:
                if (this.aorBManager.setClick_showab_textview(id)) {
                    this.param.readCurrentAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, this.param.getCurrentAttr().getMaxIntValue(), this.param.getCurrentAttr().getMinIntValue(), this.param.getCurrentAttr().getDefIntValue(), this.param.getRecordCurrent(), new KeyboardListener() { // from class: com.rigol.scope.views.record.RecordPopupView.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            RecordPopupView.this.param.saveRecordCurrent(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            RecordPopupView.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.record_endframe_value /* 2131363696 */:
                if (this.aorBManager.setClick_showab_textview(id)) {
                    this.param.readEndFrameAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, this.param.getEndFrameAttr().getMaxIntValue(), this.param.getEndFrameAttr().getMinIntValue(), this.param.getEndFrameAttr().getDefIntValue(), this.param.getRecordEndFrame(), new KeyboardListener() { // from class: com.rigol.scope.views.record.RecordPopupView.8
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            RecordPopupView.this.param.saveRecordEndFrame(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            RecordPopupView.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.record_frames_value /* 2131363698 */:
                if (this.aorBManager.setClick_showab_textview(id)) {
                    this.param.readRecordFramesAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, this.param.getRecordMaxFrames(), this.param.getRecordFramesAttr().getMinIntValue(), this.param.getRecordFramesAttr().getDefIntValue(), this.param.getRecordFrames(), new KeyboardListener() { // from class: com.rigol.scope.views.record.RecordPopupView.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            RecordPopupView.this.param.saveRecordFrames(((Long) t).intValue());
                            RecordPopupView.this.param.setRecordCurrentFrames(0);
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            RecordPopupView.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.record_interval_value /* 2131363700 */:
                if (this.aorBManager.setClick_showab_textview(id)) {
                    this.param.readRecordIntervalAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, this.param.getRecordIntervalAttr().getMaxLongValue(), this.param.getRecordIntervalAttr().getMinLongValue(), this.param.getRecordIntervalAttr().getDefLongValue(), this.param.getRecordInterval(), new KeyboardListener() { // from class: com.rigol.scope.views.record.RecordPopupView.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            RecordPopupView.this.param.saveRecordInterval(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            RecordPopupView.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.record_maxframes_button /* 2131363702 */:
                WaveRecordParam waveRecordParam7 = this.param;
                waveRecordParam7.saveRecordFrames(waveRecordParam7.getRecordMaxFrames());
                this.param.setRecordCurrentFrames(0);
                return;
            case R.id.record_playinterval_value /* 2131363710 */:
                if (this.aorBManager.setClick_showab_textview(id)) {
                    this.param.readPlayIntervalAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, this.param.getPlayIntervalAttr().getMaxLongValue(), this.param.getPlayIntervalAttr().getMinLongValue(), this.param.getPlayIntervalAttr().getDefLongValue(), this.param.getRecordPlayInterval(), new KeyboardListener() { // from class: com.rigol.scope.views.record.RecordPopupView.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            RecordPopupView.this.param.saveRecordPlayInterval(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            RecordPopupView.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.record_start_imageView /* 2131363714 */:
                WaveRecordParam waveRecordParam8 = this.param;
                waveRecordParam8.saveRecordStart(!waveRecordParam8.isRecordStart());
                return;
            case R.id.record_startframe_value /* 2131363715 */:
                if (this.aorBManager.setClick_showab_textview(id)) {
                    this.param.readStartFrameAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, this.param.getStartFrameAttr().getMaxIntValue(), this.param.getStartFrameAttr().getMinIntValue(), this.param.getStartFrameAttr().getDefIntValue(), this.param.getRecordStartFrame(), new KeyboardListener() { // from class: com.rigol.scope.views.record.RecordPopupView.7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            RecordPopupView.this.param.saveRecordStartFrame(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            RecordPopupView.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.record_toend /* 2131363718 */:
                this.param.saveRecordFrameStart(false);
                return;
            case R.id.record_tostart /* 2131363719 */:
                this.param.saveRecordFrameStart(true);
                return;
            default:
                return;
        }
    }

    public void setRecordLight() {
        if (this.binding.recordOnoffSwitchButton.isChecked()) {
            PopupViewManager.getInstance().openRecordLight();
        } else {
            PopupViewManager.getInstance().closeAllLight();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            int id = compoundButton.getId();
            if (id == R.id.record_min_switchButton) {
                this.param.setRecordMin(z);
            } else if (id != R.id.record_onoff_switchButton) {
            } else {
                this.param.saveRecordOnOff(z);
                setRecordLight();
                if (FunctionManager.getInstance().checkUltraIsOpen()) {
                    ToastUtils.showShort(this.context.getResources().getString(R.string.err_action_disabled));
                }
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z && seekBar.getId() == R.id.play_seek_bar) {
            WaveRecordParam waveRecordParam = this.param;
            waveRecordParam.saveRecordCurrent(i + waveRecordParam.getRecordStartFrame());
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    protected View findAnchor() {
        if (ActivityUtils.getTopActivity() instanceof MainActivity) {
            return ((MainActivity) ActivityUtils.getTopActivity()).getSettingsBarFragment().getBinding().starterLayout;
        }
        return null;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !this.binding.recordOnoffSwitchButton.isChecked() || this.param.readRecordStart() || this.param.readRecordPlay()) {
            return;
        }
        switch (i) {
            case R.id.record_current_value /* 2131363695 */:
                WaveRecordParam waveRecordParam = this.param;
                waveRecordParam.saveRecordCurrent(waveRecordParam.getIntStep(waveRecordParam.getRecordCurrent(), this.param.getCurrentAttr(), z, keyEvent));
                return;
            case R.id.record_endframe_value /* 2131363696 */:
                this.param.readEndFrameAttr();
                WaveRecordParam waveRecordParam2 = this.param;
                waveRecordParam2.saveRecordEndFrame(waveRecordParam2.getIntStep(waveRecordParam2.getRecordEndFrame(), this.param.getEndFrameAttr(), z, keyEvent));
                return;
            case R.id.record_frames_value /* 2131363698 */:
                this.param.readRecordFramesAttr();
                this.param.setRecordCurrentFrames(0);
                WaveRecordParam waveRecordParam3 = this.param;
                waveRecordParam3.saveRecordFrames(waveRecordParam3.getIntStep(waveRecordParam3.getRecordFrames(), this.param.getRecordFramesAttr(), z, keyEvent));
                return;
            case R.id.record_interval_value /* 2131363700 */:
                WaveRecordParam waveRecordParam4 = this.param;
                waveRecordParam4.saveRecordInterval(waveRecordParam4.getLongStep(waveRecordParam4.getRecordInterval(), this.param.getRecordIntervalAttr(), z, keyEvent));
                return;
            case R.id.record_playinterval_value /* 2131363710 */:
                WaveRecordParam waveRecordParam5 = this.param;
                waveRecordParam5.saveRecordPlayInterval(waveRecordParam5.getLongStep(waveRecordParam5.getRecordPlayInterval(), this.param.getPlayIntervalAttr(), z, keyEvent));
                return;
            case R.id.record_startframe_value /* 2131363715 */:
                this.param.readStartFrameAttr();
                WaveRecordParam waveRecordParam6 = this.param;
                waveRecordParam6.saveRecordStartFrame(waveRecordParam6.getIntStep(waveRecordParam6.getRecordStartFrame(), this.param.getStartFrameAttr(), z, keyEvent));
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        WaveRecordParam waveRecordParam = this.param;
        if (waveRecordParam == null || waveRecordParam.readRecordStart() || this.param.readRecordPlay()) {
            return;
        }
        switch (i) {
            case R.id.record_current_value /* 2131363695 */:
                WaveRecordParam waveRecordParam2 = this.param;
                waveRecordParam2.saveRecordCurrent(waveRecordParam2.getIntDef(waveRecordParam2.getCurrentAttr()));
                return;
            case R.id.record_endframe_value /* 2131363696 */:
                this.param.readEndFrameAttr();
                WaveRecordParam waveRecordParam3 = this.param;
                waveRecordParam3.saveRecordEndFrame(waveRecordParam3.getIntDef(waveRecordParam3.getEndFrameAttr()));
                return;
            case R.id.record_frames_value /* 2131363698 */:
                this.param.readRecordFramesAttr();
                WaveRecordParam waveRecordParam4 = this.param;
                waveRecordParam4.saveRecordFrames(waveRecordParam4.getIntDef(waveRecordParam4.getRecordFramesAttr()));
                return;
            case R.id.record_interval_value /* 2131363700 */:
                WaveRecordParam waveRecordParam5 = this.param;
                waveRecordParam5.saveRecordInterval(waveRecordParam5.getLongDef(waveRecordParam5.getRecordIntervalAttr()));
                return;
            case R.id.record_playinterval_value /* 2131363710 */:
                WaveRecordParam waveRecordParam6 = this.param;
                waveRecordParam6.saveRecordPlayInterval(waveRecordParam6.getLongDef(waveRecordParam6.getPlayIntervalAttr()));
                return;
            case R.id.record_startframe_value /* 2131363715 */:
                this.param.readStartFrameAttr();
                WaveRecordParam waveRecordParam7 = this.param;
                waveRecordParam7.saveRecordStartFrame(waveRecordParam7.getIntDef(waveRecordParam7.getStartFrameAttr()));
                return;
            default:
                return;
        }
    }
}
