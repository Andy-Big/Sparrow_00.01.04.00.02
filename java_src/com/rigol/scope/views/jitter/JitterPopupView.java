package com.rigol.scope.views.jitter;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.JitterConstantAdapter;
import com.rigol.scope.adapters.JitterExplicitAdapter;
import com.rigol.scope.adapters.JitterPllAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.PopupviewJitterBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.JitterViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes2.dex */
public class JitterPopupView extends BasePopupView implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
    private final PopupviewJitterBinding binding;
    private JitterConstantAdapter jitterConstantAdapter;
    private KeyboardPopupView keyboardPopupView;
    private JitterParam param;

    public JitterPopupView() {
        super((int) R.style.App_PopupWindow_Jitter);
        PopupviewJitterBinding inflate = PopupviewJitterBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.jitterSourceValue.setOnClickListener(this);
        this.binding.resetColorButton.setOnClickListener(this);
        this.binding.jitterHighThresValue.setOnClickListener(this);
        this.binding.jitterMidThresValue.setOnClickListener(this);
        this.binding.jitterLowThresValue.setOnClickListener(this);
        ViewUtil.setSwitchButton(this.binding.jitterEnSwitchButton);
        ViewUtil.setSwitchButton(this.binding.jitterMeasEnSwitchButton);
        ViewUtil.setSwitchButton(this.binding.jitterPersistanceSwitchButton);
        ViewUtil.setSwitchButton(this.binding.jitterSmoothSwitchButton);
        this.binding.jitterEnSwitchButton.setOnCheckedChangeListener(this);
        this.binding.jitterMeasEnSwitchButton.setOnCheckedChangeListener(this);
        this.binding.jitterPersistanceSwitchButton.setOnCheckedChangeListener(this);
        this.binding.jitterSmoothSwitchButton.setOnCheckedChangeListener(this);
        this.binding.jitterTrack.setOnCheckedChangeListener(this);
        this.binding.jitterSpectrum.setOnCheckedChangeListener(this);
        this.binding.jitterHistogram.setOnCheckedChangeListener(this);
        this.binding.jitterCurve.setOnCheckedChangeListener(this);
        this.binding.jitterRecoverTypeRadioGroup.setOnCheckedChangeListener(this);
        this.binding.jitterTieSlopeRadioGroup.setOnCheckedChangeListener(this);
        JitterViewModel jitterViewModel = (JitterViewModel) ContextUtil.getAppViewModel(JitterViewModel.class);
        if (jitterViewModel != null) {
            jitterViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.jitter.-$$Lambda$JitterPopupView$mzPyTa41nvMBD2aqons7NZ6kD7g
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    JitterPopupView.this.lambda$new$0$JitterPopupView((JitterParam) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$JitterPopupView(JitterParam jitterParam) {
        this.binding.setParam(jitterParam);
        this.param = jitterParam;
        this.jitterConstantAdapter = new JitterConstantAdapter(this.context, this.anchor, this.param);
        this.binding.jitterRecoverTypeView.setAdapter(this.jitterConstantAdapter);
    }

    public void setSharedViewModel(SharedViewModel sharedViewModel) {
        sharedViewModel.jitterParamState.setValue(this.param);
    }

    private void showConstantJitter(View view, PopupviewJitterBinding popupviewJitterBinding, JitterParam jitterParam) {
        popupviewJitterBinding.jitterRecoverTypeView.setAdapter(new JitterConstantAdapter(this.context, view, jitterParam));
    }

    private void showPllJitter(View view, PopupviewJitterBinding popupviewJitterBinding, JitterParam jitterParam) {
        popupviewJitterBinding.jitterRecoverTypeView.setAdapter(new JitterPllAdapter(this.context, view, jitterParam));
    }

    private void showExplicit(View view, PopupviewJitterBinding popupviewJitterBinding, JitterParam jitterParam) {
        popupviewJitterBinding.jitterRecoverTypeView.setAdapter(new JitterExplicitAdapter(this.context, view, jitterParam));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.param == null) {
            return;
        }
        if (id == R.id.jitter_source_value) {
            if (this.anchor == null) {
                return;
            }
            ViewUtil.showChanSpinner(this.anchor, view, (int) R.array.msg_jitter_source, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.jitter.-$$Lambda$JitterPopupView$-rwD3FGfs9C_nOAF46p-WM5wPWE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    JitterPopupView.this.lambda$onClick$1$JitterPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.reset_color_button) {
            API.getInstance().UI_PostBool(52, 10000, true);
        } else if (id == R.id.jitter_high_thres_value) {
            if (this.anchor == null) {
                return;
            }
            this.param.readHighThresAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_percent, this.param.getHighThresAttr().getMaxIntValue(), this.param.getHighThresAttr().getMinIntValue(), this.param.getHighThresAttr().getDefIntValue(), this.param.getHighThres(), new KeyboardListener() { // from class: com.rigol.scope.views.jitter.JitterPopupView.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    JitterPopupView.this.param.saveHighThres(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    JitterPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.jitter_mid_thres_value) {
            if (this.anchor == null) {
                return;
            }
            this.param.readMidThresAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_percent, this.param.getMidThresAttr().getMaxIntValue(), this.param.getMidThresAttr().getMinIntValue(), this.param.getMidThresAttr().getDefIntValue(), this.param.getMidThres(), new KeyboardListener() { // from class: com.rigol.scope.views.jitter.JitterPopupView.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    JitterPopupView.this.param.saveMidThres(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    JitterPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id != R.id.jitter_low_thres_value || this.anchor == null) {
        } else {
            this.param.readLowThresAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_percent, this.param.getLowThresAttr().getMaxIntValue(), this.param.getLowThresAttr().getMinIntValue(), this.param.getLowThresAttr().getDefIntValue(), this.param.getLowThres(), new KeyboardListener() { // from class: com.rigol.scope.views.jitter.JitterPopupView.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    JitterPopupView.this.param.saveLowThres(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    JitterPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$1$JitterPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveSource(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && this.param != null) {
            int id = compoundButton.getId();
            if (id == R.id.jitter_en_switchButton) {
                this.param.saveEnable(z);
            } else if (id == R.id.jitter_meas_en_switchButton) {
                this.param.saveResult(z);
            } else if (id == R.id.jitter_persistance_switchButton) {
                this.param.savePersistance(z);
            } else if (id == R.id.jitter_smooth_switchButton) {
                this.param.saveSmooth(z);
            } else if (id == R.id.jitter_track) {
                this.param.saveTrack(z);
            } else if (id == R.id.jitter_spectrum) {
                this.param.saveSpectrum(z);
            } else if (id == R.id.jitter_histogram) {
                this.param.saveHistogram(z);
            } else if (id == R.id.jitter_curve) {
                this.param.saveBathtubCurve(z);
            }
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.jitter_constant_radioButton) {
            this.param.saveRecoveryType(ServiceEnum.ClockRecovery.CR_Auto.value1);
            showConstantJitter(this.anchor, this.binding, this.param);
        } else if (i == R.id.jitter_pll_radioButton) {
            this.param.saveRecoveryType(ServiceEnum.ClockRecovery.CR_Pll.value1);
            showPllJitter(this.anchor, this.binding, this.param);
        } else if (i == R.id.jitter_explicit_radioButton) {
            this.param.saveRecoveryType(ServiceEnum.ClockRecovery.CR_Ext.value1);
            showExplicit(this.anchor, this.binding, this.param);
        } else if (i == R.id.jitter_rise_radioButton) {
            this.param.saveTieSlope(ServiceEnum.ClockSlope.CLOCK_RISE.value1);
        } else if (i == R.id.jitter_fall_radioButton) {
            this.param.saveTieSlope(ServiceEnum.ClockSlope.CLOCK_FALL.value1);
        } else if (i == R.id.jitter_both_radioButton) {
            this.param.saveTieSlope(ServiceEnum.ClockSlope.CLOCK_BOTH.value1);
        }
    }
}
