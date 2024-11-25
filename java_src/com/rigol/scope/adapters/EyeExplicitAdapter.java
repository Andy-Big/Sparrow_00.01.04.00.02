package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterEyeExplicitBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.eye.EyePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes.dex */
public class EyeExplicitAdapter extends RecyclerView.Adapter<EyeExplicitHolder> implements View.OnClickListener {
    private final BasePopupView basePopupView;
    private AdapterEyeExplicitBinding binding;
    final EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
    private EyeParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(EyeExplicitHolder eyeExplicitHolder, int i) {
    }

    public EyeExplicitAdapter(EyePopupView eyePopupView) {
        this.basePopupView = eyePopupView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public EyeExplicitHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterEyeExplicitBinding inflate = AdapterEyeExplicitBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.binding = inflate;
        inflate.setOnClickListener(this);
        EyeViewModel eyeViewModel = this.eyeViewModel;
        if (eyeViewModel != null) {
            this.binding.setParam(eyeViewModel.getLiveData().getValue());
            this.eyeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$EyeExplicitAdapter$XTnnzzfMzueRXlLfAmJ3oZfaZTw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    EyeExplicitAdapter.this.lambda$onCreateViewHolder$0$EyeExplicitAdapter((EyeParam) obj);
                }
            });
        }
        return new EyeExplicitHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$EyeExplicitAdapter(EyeParam eyeParam) {
        this.param = eyeParam;
        this.binding.setParam(eyeParam);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.eye_external_clock_source_value) {
            ViewUtil.showChanSpinner(this.basePopupView.getAnchor(), view, (int) R.array.msg_eye_external_clock_src, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$EyeExplicitAdapter$5xR4FR29cLjoNPWmLhlbj9oetPY
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    EyeExplicitAdapter.this.lambda$onClick$1$EyeExplicitAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$1$EyeExplicitAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1;
        if (this.param == null || mappingObject == null || (chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        this.param.getChanExternalClock().save(Integer.valueOf(chanFromValue1.value1));
    }

    /* loaded from: classes.dex */
    public static class EyeExplicitHolder extends RecyclerView.ViewHolder {
        public EyeExplicitHolder(AdapterEyeExplicitBinding adapterEyeExplicitBinding) {
            super(adapterEyeExplicitBinding.getRoot());
        }
    }
}
