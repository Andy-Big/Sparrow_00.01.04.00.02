package com.rigol.scope.views.eye;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.EyeConstantAdapter;
import com.rigol.scope.adapters.EyeExplicitAdapter;
import com.rigol.scope.adapters.EyePllAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.PopupviewEyeBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes2.dex */
public class EyePopupView extends BasePopupView implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener {
    private final PopupviewEyeBinding binding;
    private final EyeConstantAdapter eyeConstantAdapter;
    private final EyeExplicitAdapter eyeExplicitAdapter;
    private final EyePllAdapter eyePllAdapter;
    private KeyboardPopupView keyboardPopupView;
    private EyeParam param;
    private final SharedViewModel sharedViewModel;

    public EyePopupView() {
        super((int) R.style.App_PopupWindow_Eye);
        this.eyeConstantAdapter = new EyeConstantAdapter(this);
        this.eyePllAdapter = new EyePllAdapter(this);
        this.eyeExplicitAdapter = new EyeExplicitAdapter(this);
        PopupviewEyeBinding inflate = PopupviewEyeBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        inflate.setOnCheckedChangeListener(this);
        this.binding.setOnClickListener(this);
        this.binding.setOnSwitchCheckedChangeListener(this);
        this.binding.setGridFullMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        this.binding.setGridHalfMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        this.binding.setGridNoneMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        this.binding.setConstantMapping(ViewUtil.getMappingObject(R.array.msg_eye_cr_selmethod, 0));
        this.binding.setPllMapping(ViewUtil.getMappingObject(R.array.msg_eye_cr_selmethod, 1));
        this.binding.setExplicitMapping(ViewUtil.getMappingObject(R.array.msg_eye_cr_selmethod, 2));
        setContentView(this.binding.getRoot());
        ViewUtil.setSwitchButton(this.binding.eyeEyeEnSwitchButton);
        ViewUtil.setSwitchButton(this.binding.eyeMeasEnSwitchButton);
        ViewUtil.setSwitchButton(this.binding.eyePersistanceSwitchButton);
        ViewUtil.setSwitchButton(this.binding.eyeTemplateStatusSwitchButton);
        this.sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
        if (eyeViewModel != null) {
            eyeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.eye.-$$Lambda$EyePopupView$M92E_P_NWwG0I2FjPpjhyMv1tmM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EyePopupView.this.lambda$new$0$EyePopupView((EyeParam) obj);
                }
            });
        }
        this.binding.eyeRecoverTypeView.setAdapter(this.eyeConstantAdapter);
    }

    public /* synthetic */ void lambda$new$0$EyePopupView(EyeParam eyeParam) {
        this.param = eyeParam;
        this.binding.setParam(eyeParam);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.eye_source_value) {
            if (this.anchor != null) {
                ViewUtil.showChanSpinner(this.anchor, view, (int) R.array.msg_eye_source, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.eye.-$$Lambda$EyePopupView$n5f6GPgg4zGBaNKO5taklQ0P_1E
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        EyePopupView.this.lambda$onClick$1$EyePopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        } else if (id == R.id.eye_template_value) {
            if (this.anchor != null) {
                ViewUtil.showSpinner(this.anchor, view, (int) R.array.msg_eye_template, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.eye.-$$Lambda$EyePopupView$fwfNE5cDdd-JBKyHyr6PvKqaOWo
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        EyePopupView.this.lambda$onClick$2$EyePopupView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        } else if (id == R.id.reset_color_button) {
            this.param.getResetColor().save(true);
        } else if (id == R.id.eye_high_thres_value) {
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_percent, this.param.getHighThres().getAttr().getMaxIntValue(), this.param.getHighThres().getAttr().getMinIntValue(), this.param.getHighThres().getAttr().getDefIntValue(), this.param.getHighThres().getValue().intValue(), new KeyboardListener() { // from class: com.rigol.scope.views.eye.EyePopupView.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    EyePopupView.this.param.getHighThres().save(Integer.valueOf(((Long) t).intValue()));
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    EyePopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.eye_mid_thres_value) {
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_percent, this.param.getMidThres().getAttr().getMaxIntValue(), this.param.getMidThres().getAttr().getMinIntValue(), this.param.getMidThres().getAttr().getDefIntValue(), this.param.getMidThres().getValue().intValue(), new KeyboardListener() { // from class: com.rigol.scope.views.eye.EyePopupView.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    EyePopupView.this.param.getMidThres().save(Integer.valueOf(((Long) t).intValue()));
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    EyePopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.eye_low_thres_value) {
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_percent, this.param.getLowThres().getAttr().getMaxIntValue(), this.param.getLowThres().getAttr().getMinIntValue(), this.param.getLowThres().getAttr().getDefIntValue(), this.param.getLowThres().getValue().intValue(), new KeyboardListener() { // from class: com.rigol.scope.views.eye.EyePopupView.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    EyePopupView.this.param.getLowThres().save(Integer.valueOf(((Long) t).intValue()));
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    EyePopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.eye_noise_holdup_value) {
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_V, this.param.getNoiseHoldUp().getAttr().getMaxIntValue(), this.param.getNoiseHoldUp().getAttr().getMinIntValue(), this.param.getNoiseHoldUp().getAttr().getDefIntValue(), this.param.getNoiseHoldUp().getValue().intValue(), "0.000", 7, new KeyboardListener() { // from class: com.rigol.scope.views.eye.EyePopupView.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    EyePopupView.this.param.getNoiseHoldUp().save(Integer.valueOf(((Long) t).intValue()));
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    EyePopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$1$EyePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1;
        if (this.param == null || mappingObject == null || (chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        this.param.getChan().save(Integer.valueOf(chanFromValue1.value1));
    }

    public /* synthetic */ void lambda$onClick$2$EyePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (this.param == null || mappingObject == null) {
            return;
        }
        ServiceEnum.EyeTemplate eyeTemplateFromValue1 = ServiceEnum.getEyeTemplateFromValue1(mappingObject.getValue());
        if (eyeTemplateFromValue1 != null) {
            this.param.getEyeTemplate().setValue(Integer.valueOf(eyeTemplateFromValue1.value1));
        }
        this.sharedViewModel.eyeParamState.setValue(this.param);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && this.param != null) {
            int id = compoundButton.getId();
            if (id == R.id.eye_eye_en_switchButton) {
                this.param.getEnabled().save(Boolean.valueOf(z));
            } else if (id == R.id.eye_meas_en_switchButton) {
                this.param.getResult().save(Boolean.valueOf(z));
            } else if (id == R.id.eye_persistance_switchButton) {
                this.param.getPersistance().save(Boolean.valueOf(z));
            } else if (id == R.id.eye_template_status_switchButton) {
                this.param.getTemplateFlag().setValue(Boolean.valueOf(z));
                this.sharedViewModel.eyeParamState.setValue(this.param);
            }
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EyeParam eyeParam = this.param;
        if (eyeParam == null) {
            return;
        }
        if (i == R.id.eye_constant_radioButton) {
            eyeParam.getRecoveryType().save(0);
            this.binding.eyeRecoverTypeView.setAdapter(this.eyeConstantAdapter);
        } else if (i == R.id.eye_pll_radioButton) {
            eyeParam.getRecoveryType().save(1);
            this.binding.eyeRecoverTypeView.setAdapter(this.eyePllAdapter);
        } else if (i == R.id.eye_explicit_radioButton) {
            eyeParam.getRecoveryType().save(2);
            this.binding.eyeRecoverTypeView.setAdapter(this.eyeExplicitAdapter);
        } else if (i == R.id.full_radio_button) {
            eyeParam.getGrids().save(Integer.valueOf(ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        } else if (i == R.id.half_radio_button) {
            eyeParam.getGrids().save(Integer.valueOf(ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        } else if (i == R.id.none_radio_button) {
            eyeParam.getGrids().save(Integer.valueOf(ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        }
    }
}
