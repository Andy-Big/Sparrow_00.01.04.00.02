package com.rigol.scope.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterJitterExplicitBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.List;
/* loaded from: classes.dex */
public class JitterExplicitAdapter extends RecyclerView.Adapter<JitterExplicitHolder> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private View anchorView;
    private AdapterJitterExplicitBinding binding;
    private Context context;
    private JitterParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
    }

    public JitterExplicitAdapter(Context context, View view, JitterParam jitterParam) {
        this.param = jitterParam;
        this.anchorView = view;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public JitterExplicitHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterJitterExplicitBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new JitterExplicitHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(JitterExplicitHolder jitterExplicitHolder, int i) {
        ShowJitterExplicit();
    }

    public void ShowJitterExplicit() {
        this.binding.jitterExternalClockSourceValue.setOnClickListener(this);
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.jitter_external_clock_source_value && this.anchorView != null) {
            final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_jitter_external_clock_src);
            ViewUtil.showChanSpinner(this.anchorView, view, list, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$JitterExplicitAdapter$fMmRCRDNts9kTySrsqKkYuru7jY
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    JitterExplicitAdapter.this.lambda$onClick$0$JitterExplicitAdapter(list, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$0$JitterExplicitAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (this.param != null) {
            this.param.saveExternalClock(ServiceEnum.getChanFromValue1(((MappingObject) list.get(i)).getValue()));
        }
    }

    /* loaded from: classes.dex */
    public class JitterExplicitHolder extends RecyclerView.ViewHolder {
        private AdapterJitterExplicitBinding binding;

        public JitterExplicitHolder(AdapterJitterExplicitBinding adapterJitterExplicitBinding) {
            super(adapterJitterExplicitBinding.getRoot());
            this.binding = adapterJitterExplicitBinding;
        }
    }
}
