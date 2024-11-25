package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.databinding.AdapterEyeConstantBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
/* loaded from: classes.dex */
public class EyeConstantAdapter extends RecyclerView.Adapter<EyeConstantHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private AdapterEyeConstantBinding binding;
    final EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
    private KeyboardPopupView keyboardPopupView;
    private EyeParam param;
    private final BasePopupView popupView;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EyeConstantHolder eyeConstantHolder, int i) {
    }

    public EyeConstantAdapter(BasePopupView basePopupView) {
        this.popupView = basePopupView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EyeConstantHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterEyeConstantBinding inflate = AdapterEyeConstantBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.binding = inflate;
        inflate.setOnCheckedChangeListener(this);
        this.binding.setOnClickListener(this);
        this.binding.setAtuoMapping(ViewUtil.getMappingObject(R.array.msg_eye_cr_freqtype, 0));
        this.binding.setSemiautoMapping(ViewUtil.getMappingObject(R.array.msg_eye_cr_freqtype, 1));
        this.binding.setManualMapping(ViewUtil.getMappingObject(R.array.msg_eye_cr_freqtype, 2));
        EyeViewModel eyeViewModel = this.eyeViewModel;
        if (eyeViewModel != null) {
            this.binding.setParam(eyeViewModel.getLiveData().getValue());
            this.eyeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$EyeConstantAdapter$vpeZHiDFNKMzWQ913579N5PARrg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EyeConstantAdapter.this.lambda$onCreateViewHolder$0$EyeConstantAdapter((EyeParam) obj);
                }
            });
        }
        return new EyeConstantHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$EyeConstantAdapter(EyeParam eyeParam) {
        this.param = eyeParam;
        this.binding.setParam(eyeParam);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.param != null && view.getId() == R.id.eye_dataRate_value) {
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_bps, this.param.getDataRate().getAttr().getMaxLongValue(), this.param.getDataRate().getAttr().getMinLongValue(), this.param.getDataRate().getAttr().getDefLongValue(), this.param.getDataRate().getValue().longValue(), "0.000", 7, new KeyboardListener() { // from class: com.rigol.scope.adapters.EyeConstantAdapter.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    EyeConstantAdapter.this.param.getDataRate().save((Long) t);
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    EyeConstantAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        EyeParam eyeParam = this.param;
        if (eyeParam == null) {
            return;
        }
        if (i == R.id.eye_type_atuo_radioButton) {
            eyeParam.getType().save(0);
        } else if (i == R.id.eye_type_semiauto_radioButton) {
            eyeParam.getType().save(1);
        } else if (i == R.id.eye_type_manual_radioButton) {
            eyeParam.getType().save(2);
        }
    }

    /* loaded from: classes.dex */
    public static class EyeConstantHolder extends RecyclerView.ViewHolder {
        public EyeConstantHolder(AdapterEyeConstantBinding adapterEyeConstantBinding) {
            super(adapterEyeConstantBinding.getRoot());
        }
    }
}
