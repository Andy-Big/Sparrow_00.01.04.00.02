package com.rigol.scope.adapters;

import android.content.Context;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
/* loaded from: classes.dex */
public class MultiItemTypeAdapter<T extends List<?>> extends RecyclerView.Adapter<BaseViewHolder<? extends ViewDataBinding>> {
    private static final int DEFAULT_SELECTED_POSITION = 0;
    protected Context context;
    private int currentItem;
    protected AdapterDelegatesManager<T> delegatesManager = new AdapterDelegatesManager<>();
    protected T items;
    private OnItemClickListener onItemClickListener;
    private OnItemGestureDetectorListener onItemGestureDetectorListener;
    private OnItemLongClickListener onItemLongClickListener;

    public MultiItemTypeAdapter(Context context, T t) {
        this.context = context;
        this.items = t;
    }

    public MultiItemTypeAdapter(Context context) {
        this.context = context;
    }

    public AdapterDelegatesManager<T> getDelegatesManager() {
        return this.delegatesManager;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        if (this.delegatesManager.delegates.isEmpty()) {
            return super.getItemViewType(i);
        }
        return this.delegatesManager.getItemViewType(this.items, i);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = this.delegatesManager.onCreateViewHolder(viewGroup, i);
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener != null) {
            onCreateViewHolder.setOnItemClickListener(onItemClickListener);
        }
        OnItemLongClickListener onItemLongClickListener = this.onItemLongClickListener;
        if (onItemLongClickListener != null) {
            onCreateViewHolder.setOnItemLongClickListener(onItemLongClickListener);
        }
        OnItemGestureDetectorListener onItemGestureDetectorListener = this.onItemGestureDetectorListener;
        if (onItemGestureDetectorListener != null) {
            onCreateViewHolder.setOnGestureListener(onItemGestureDetectorListener);
        }
        return onCreateViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, int i) {
        this.delegatesManager.onBindViewHolder(this.items, i, baseViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        T t = this.items;
        if (t == null) {
            return 0;
        }
        return t.size();
    }

    public T getItems() {
        return this.items;
    }

    public void setItems(T t) {
        this.items = t;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return this.onItemLongClickListener;
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public OnItemGestureDetectorListener getOnItemGestureDetectorListener() {
        return this.onItemGestureDetectorListener;
    }

    public void setOnItemGestureDetectorListener(OnItemGestureDetectorListener onItemGestureDetectorListener) {
        this.onItemGestureDetectorListener = onItemGestureDetectorListener;
    }

    public void setCurrentItem(int i) {
        if (i < 0) {
            this.currentItem = 0;
        } else {
            this.currentItem = Math.min(i, getItemCount() - 1);
        }
    }

    public void setCurrentItemForce(int i) {
        this.currentItem = Math.min(i, getItemCount() - 1);
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public void resetCurrentItem() {
        setCurrentItem(0);
    }

    public boolean checkPositionIsOutOfRange(int i) {
        return i < 0 || i >= getItemCount();
    }
}
