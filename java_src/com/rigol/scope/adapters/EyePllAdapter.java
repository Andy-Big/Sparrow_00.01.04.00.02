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
import com.rigol.scope.databinding.AdapterEyePllBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.eye.EyePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
/* loaded from: classes.dex */
public class EyePllAdapter extends RecyclerView.Adapter<EyePllHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private final BasePopupView basePopupView;
    private AdapterEyePllBinding binding;
    final EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
    private KeyboardPopupView keyboardPopupView;
    private EyeParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EyePllHolder eyePllHolder, int i) {
    }

    public EyePllAdapter(EyePopupView eyePopupView) {
        this.basePopupView = eyePopupView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EyePllHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterEyePllBinding inflate = AdapterEyePllBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.binding = inflate;
        inflate.setOnCheckedChangeListener(this);
        this.binding.setOnClickListener(this);
        this.binding.setFirstOrderMapping(ViewUtil.getMappingObject(R.array.msg_eye_cr_pllorder, 0));
        this.binding.setSecondOrderMapping(ViewUtil.getMappingObject(R.array.msg_eye_cr_pllorder, 1));
        EyeViewModel eyeViewModel = this.eyeViewModel;
        if (eyeViewModel != null) {
            this.binding.setParam(eyeViewModel.getLiveData().getValue());
            this.eyeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$EyePllAdapter$EYgGVjvLEPyglWxuQaC5F0RPszE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EyePllAdapter.this.lambda$onCreateViewHolder$0$EyePllAdapter((EyeParam) obj);
                }
            });
        }
        return new EyePllHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$EyePllAdapter(EyeParam eyeParam) {
        this.param = eyeParam;
        this.binding.setParam(eyeParam);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.param == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.eye_dataRate_value) {
            ViewUtil.showKeyboard(this.basePopupView.getAnchor(), view, ServiceEnum.Unit.Unit_bps, this.param.getDataRate().getAttr().getMaxLongValue(), this.param.getDataRate().getAttr().getMinLongValue(), this.param.getDataRate().getAttr().getDefLongValue(), this.param.getDataRate().getValue().longValue(), "0.000", 7, new KeyboardListener() { // from class: com.rigol.scope.adapters.EyePllAdapter.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    EyePllAdapter.this.param.getDataRate().save((Long) t);
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    EyePllAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.eye_pllWidth_value) {
            ViewUtil.showKeyboard(this.basePopupView.getAnchor(), view, ServiceEnum.Unit.Unit_hz, this.param.getLoopBw().getAttr().getMaxLongValue(), this.param.getLoopBw().getAttr().getMinLongValue(), this.param.getLoopBw().getAttr().getDefLongValue(), this.param.getLoopBw().getValue().longValue(), UnitFormat.SI.NONE, new KeyboardListener() { // from class: com.rigol.scope.adapters.EyePllAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    EyePllAdapter.this.param.getLoopBw().save((Long) t);
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    EyePllAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.eye_dampFactor_value) {
            ViewUtil.showKeyboard(this.basePopupView.getAnchor(), view, ServiceEnum.Unit.Unit_U, this.param.getDampFactor().getAttr().getMaxIntValue(), this.param.getDampFactor().getAttr().getMinIntValue(), this.param.getDampFactor().getAttr().getDefIntValue(), this.param.getDampFactor().getValue().intValue(), new KeyboardListener() { // from class: com.rigol.scope.adapters.EyePllAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    EyePllAdapter.this.param.getDampFactor().save(Integer.valueOf(Math.toIntExact(((Long) t).longValue())));
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    EyePllAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.eye_firstOrder_radioButton) {
            this.param.getPllOrder().save(0);
        } else if (i == R.id.eye_secondOrder_radioButton) {
            this.param.getPllOrder().save(1);
        }
    }

    /* loaded from: classes.dex */
    public static class EyePllHolder extends RecyclerView.ViewHolder {
        public EyePllHolder(AdapterEyePllBinding adapterEyePllBinding) {
            super(adapterEyePllBinding.getRoot());
        }
    }
}
