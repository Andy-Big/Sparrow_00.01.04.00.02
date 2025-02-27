package com.rigol.scope.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import java.util.List;

/* loaded from: classes.dex */
public abstract class BaseAdapter<T extends List<?>> extends MultiItemTypeAdapter<T> {
    protected abstract void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, T t, int i);

    public BaseAdapter(Context context, T t, int i) {
        super(context, t);
        addDelegate(context, i);
    }

    public BaseAdapter(Context context, int i) {
        super(context);
        addDelegate(context, i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.rigol.scope.adapters.AdapterDelegatesManager<T extends java.util.List<?>> */
    /* JADX WARN: Multi-variable type inference failed */
    private void addDelegate(final Context context, final int i) {
        this.delegatesManager.addDelegate(new AdapterDelegate<T>() { // from class: com.rigol.scope.adapters.BaseAdapter.1
            protected boolean isForViewType(T t, int i2) {
                return true;
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.rigol.scope.adapters.BaseAdapter$1 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.rigol.scope.adapters.AdapterDelegate
            protected /* bridge */ /* synthetic */ boolean isForViewType(Object obj, int i2) {
                return isForViewType((AnonymousClass1) ((List) obj), i2);
            }

            /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.rigol.scope.adapters.BaseAdapter$1 */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.rigol.scope.adapters.AdapterDelegate
            protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i2, BaseViewHolder baseViewHolder) {
                onBindViewHolder((AnonymousClass1) ((List) obj), i2, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
            }

            @Override // com.rigol.scope.adapters.AdapterDelegate
            protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
                return new BaseViewHolder<>(DataBindingUtil.inflate(LayoutInflater.from(context), i, viewGroup, false));
            }

            protected void onBindViewHolder(T t, int i2, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
                BaseAdapter.this.convert(baseViewHolder, t, i2);
            }
        });
    }
}
