package com.rigol.scope.adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemSimpleBinding;
import java.util.List;
/* loaded from: classes.dex */
public class UtilityAdapter extends RecyclerView.Adapter<UtilViewHolder> {
    private List<MappingObject> data;
    private OnItemClickListener onItemClickListener;
    int selectPosition = 0;

    public UtilityAdapter(List<MappingObject> list) {
        this.data = list;
    }

    public void setSelectPosition(int i) {
        this.selectPosition = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UtilViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterItemSimpleBinding inflate = AdapterItemSimpleBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        inflate.icon.setVisibility(8);
        return new UtilViewHolder(inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final UtilViewHolder utilViewHolder, final int i) {
        if (this.selectPosition == i) {
            utilViewHolder.binding.getRoot().setBackgroundColor(Color.parseColor("#4F5C5F"));
        } else {
            utilViewHolder.binding.getRoot().setBackgroundColor(0);
        }
        utilViewHolder.binding.text1.setText(this.data.get(i).getStr());
        utilViewHolder.binding.text1.setTextColor(Color.parseColor("#ffffff"));
        utilViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityAdapter$8ZgR7JH9_WgiOnZltZ-RI9tG54g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityAdapter.this.lambda$onBindViewHolder$0$UtilityAdapter(utilViewHolder, i, view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$UtilityAdapter(UtilViewHolder utilViewHolder, int i, View view) {
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, utilViewHolder, i);
        }
        this.selectPosition = i;
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public void setData(List<MappingObject> list) {
        this.data = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public List<MappingObject> getData() {
        return this.data;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class UtilViewHolder extends RecyclerView.ViewHolder {
        private AdapterItemSimpleBinding binding;

        public UtilViewHolder(AdapterItemSimpleBinding adapterItemSimpleBinding) {
            super(adapterItemSimpleBinding.getRoot());
            this.binding = adapterItemSimpleBinding;
        }
    }
}
