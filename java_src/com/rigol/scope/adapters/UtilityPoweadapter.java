package com.rigol.scope.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.databinding.AdapterUtiltyPowerItemBinding;
/* loaded from: classes.dex */
public class UtilityPoweadapter extends RecyclerView.Adapter<PowerkHolder> {
    private AdapterUtiltyPowerItemBinding binding;
    private Context context;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(PowerkHolder powerkHolder, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public PowerkHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterUtiltyPowerItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new PowerkHolder(this.binding);
    }

    public UtilityPoweadapter(Context context) {
        this.context = context;
    }

    /* loaded from: classes.dex */
    public static class PowerkHolder extends RecyclerView.ViewHolder {
        private AdapterUtiltyPowerItemBinding binding;

        public PowerkHolder(AdapterUtiltyPowerItemBinding adapterUtiltyPowerItemBinding) {
            super(adapterUtiltyPowerItemBinding.getRoot());
            this.binding = adapterUtiltyPowerItemBinding;
        }
    }
}
