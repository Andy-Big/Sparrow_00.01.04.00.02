package com.rigol.scope.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.databinding.AdapterJitterConstantBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
/* loaded from: classes.dex */
public class JitterConstantAdapter extends RecyclerView.Adapter<JitterConstantHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private View anchorView;
    private AdapterJitterConstantBinding binding;
    private Context context;
    private KeyboardPopupView keyboardPopupView;
    private JitterParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public JitterConstantAdapter(Context context, View view, JitterParam jitterParam) {
        this.param = jitterParam;
        this.anchorView = view;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public JitterConstantHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterJitterConstantBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new JitterConstantHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(JitterConstantHolder jitterConstantHolder, int i) {
        ShowJitterConstant();
    }

    public void ShowJitterConstant() {
        this.binding.jitterTypeRadioGroup.setOnCheckedChangeListener(this);
        this.binding.jitterDataRateValue.setOnClickListener(this);
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.jitter_dataRate_value && (this.context instanceof Activity)) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_bps, 4000000000L, 100000L, 10000000L, this.param.getDataRate(), new KeyboardListener() { // from class: com.rigol.scope.adapters.JitterConstantAdapter.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    JitterConstantAdapter.this.param.saveDataRate(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    JitterConstantAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.jitter_type_atuo_radioButton) {
            this.param.saveType(0);
        } else if (i == R.id.jitter_type_manual_radioButton) {
            this.param.saveType(2);
        } else if (i != R.id.jitter_type_semiauto_radioButton) {
        } else {
            this.param.saveType(1);
        }
    }

    /* loaded from: classes.dex */
    public class JitterConstantHolder extends RecyclerView.ViewHolder {
        private AdapterJitterConstantBinding binding;

        public JitterConstantHolder(AdapterJitterConstantBinding adapterJitterConstantBinding) {
            super(adapterJitterConstantBinding.getRoot());
            this.binding = adapterJitterConstantBinding;
        }
    }
}
