package com.rigol.scope.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.databinding.AdapterJitterPllBinding;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
/* loaded from: classes.dex */
public class JitterPllAdapter extends RecyclerView.Adapter<JitterPllHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private View anchorView;
    private AdapterJitterPllBinding binding;
    private Context context;
    private KeyboardPopupView keyboardPopupView;
    private JitterParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
    }

    public JitterPllAdapter(Context context, View view, JitterParam jitterParam) {
        this.param = jitterParam;
        this.anchorView = view;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public JitterPllHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterJitterPllBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new JitterPllHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(JitterPllHolder jitterPllHolder, int i) {
        ShowJitterPll();
    }

    public void ShowJitterPll() {
        this.binding.jitterPllOrderRadioGroup.setOnCheckedChangeListener(this);
        this.binding.jitterDataRateValue.setOnClickListener(this);
        this.binding.jitterPllWidthValue.setOnClickListener(this);
        this.binding.jitterDampFactorValue.setOnClickListener(this);
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.jitter_dampFactor_value) {
            Integer valueOf = Integer.valueOf(this.param.getDampFactor() * 1000);
            if (this.context instanceof Activity) {
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_U, 1000000L, 0L, 707000L, valueOf.longValue(), new KeyboardListener() { // from class: com.rigol.scope.adapters.JitterPllAdapter.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        JitterPllAdapter.this.param.saveDampFactor(((Number) t).intValue() / 1000);
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        JitterPllAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.jitter_dataRate_value) {
            if (this.context instanceof Activity) {
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_bps, this.param.getDataRateThresAttr().getMaxLongValue(), this.param.getDataRateThresAttr().getMinLongValue(), this.param.getDataRateThresAttr().getDefLongValue(), this.param.getDataRate(), new KeyboardListener() { // from class: com.rigol.scope.adapters.JitterPllAdapter.1
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        JitterPllAdapter.this.param.saveDataRate(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        JitterPllAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.jitter_pllWidth_value && (this.context instanceof Activity)) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_hz, this.param.getLoopBwThresAttr().getMaxLongValue(), this.param.getLoopBwThresAttr().getMinLongValue(), this.param.getLoopBwThresAttr().getDefLongValue(), this.param.getLoopBw(), UnitFormat.SI.NONE, new KeyboardListener() { // from class: com.rigol.scope.adapters.JitterPllAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    JitterPllAdapter.this.param.saveLoopBw(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    JitterPllAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.jitter_firstOrder_radioButton) {
            this.param.savePllOrder(0);
        } else if (i == R.id.jitter_secondOrder_radioButton) {
            this.param.savePllOrder(1);
        }
        this.binding.setParam(this.param);
    }

    /* loaded from: classes.dex */
    public class JitterPllHolder extends RecyclerView.ViewHolder {
        private AdapterJitterPllBinding binding;

        public JitterPllHolder(AdapterJitterPllBinding adapterJitterPllBinding) {
            super(adapterJitterPllBinding.getRoot());
            this.binding = adapterJitterPllBinding;
        }
    }
}
