package com.rigol.scope.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.data.SelfTestParam;
import com.rigol.scope.databinding.AdapterItemSelfTestBinding;
import java.util.List;
/* loaded from: classes.dex */
public class SelfTestItemAdapter extends RecyclerView.Adapter<SelfTestViewHolder> {
    private Context context;
    private List<SelfTestParam> selfTestData;

    public SelfTestItemAdapter(Context context, List<SelfTestParam> list) {
        this.context = context;
        this.selfTestData = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelfTestViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new SelfTestViewHolder(AdapterItemSelfTestBinding.inflate(LayoutInflater.from(this.context), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SelfTestViewHolder selfTestViewHolder, int i) {
        selfTestViewHolder.binding.setParam(this.selfTestData.get(i));
        selfTestViewHolder.binding.setIndex(Integer.valueOf(i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.selfTestData.size();
    }

    /* loaded from: classes.dex */
    public static class SelfTestViewHolder extends RecyclerView.ViewHolder {
        private AdapterItemSelfTestBinding binding;

        public SelfTestViewHolder(AdapterItemSelfTestBinding adapterItemSelfTestBinding) {
            super(adapterItemSelfTestBinding.getRoot());
            this.binding = adapterItemSelfTestBinding;
        }
    }

    public void updateData(List<SelfTestParam> list) {
        DiffUtil.calculateDiff(new SelfTestDiffCallback(this.selfTestData, list)).dispatchUpdatesTo(this);
        this.selfTestData = list;
    }
}
