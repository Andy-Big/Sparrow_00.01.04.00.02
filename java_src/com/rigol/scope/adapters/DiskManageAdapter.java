package com.rigol.scope.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.FileParam;
import com.rigol.scope.databinding.AdapterItemDiskManageBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.DiskManageViewModel;
import java.util.List;
/* loaded from: classes.dex */
public class DiskManageAdapter extends BaseAdapter<List<FileParam>> {
    private DiskManageParam diskManageParam;
    private OnSelectedListener onSelectedListener;

    /* loaded from: classes.dex */
    public interface OnSelectedListener {
        void onSelected(View view, FileParam fileParam);
    }

    public DiskManageAdapter(Context context, int i) {
        super(context, i);
        DiskManageViewModel diskManageViewModel = (DiskManageViewModel) ContextUtil.getAppViewModel(DiskManageViewModel.class);
        if (diskManageViewModel != null) {
            diskManageViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DiskManageAdapter$Nc0j-9LzGekb3iXvPzgZw1npfu8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DiskManageAdapter.this.lambda$new$0$DiskManageAdapter((DiskManageParam) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$DiskManageAdapter(DiskManageParam diskManageParam) {
        this.diskManageParam = diskManageParam;
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.onSelectedListener = onSelectedListener;
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        final BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        final AdapterItemDiskManageBinding adapterItemDiskManageBinding = (AdapterItemDiskManageBinding) onCreateViewHolder.getBinding();
        adapterItemDiskManageBinding.status.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DiskManageAdapter$yyOQB1g_0aK-OTmuZKJQsI5orvo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DiskManageAdapter.this.lambda$onCreateViewHolder$1$DiskManageAdapter(onCreateViewHolder, adapterItemDiskManageBinding, view);
            }
        });
        return onCreateViewHolder;
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    public /* synthetic */ void lambda$onCreateViewHolder$1$DiskManageAdapter(BaseViewHolder baseViewHolder, AdapterItemDiskManageBinding adapterItemDiskManageBinding, View view) {
        int absoluteAdapterPosition = baseViewHolder.getAbsoluteAdapterPosition();
        FileParam fileParam = (FileParam) getItems().get(absoluteAdapterPosition);
        if (fileParam != null) {
            fileParam.setSelected(!fileParam.isSelected());
        }
        notifyItemChanged(absoluteAdapterPosition);
        OnSelectedListener onSelectedListener = this.onSelectedListener;
        if (onSelectedListener != null) {
            onSelectedListener.onSelected(adapterItemDiskManageBinding.getRoot(), fileParam);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [java.util.List] */
    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<FileParam> list, int i) {
        AdapterItemDiskManageBinding adapterItemDiskManageBinding = (AdapterItemDiskManageBinding) baseViewHolder.getBinding();
        FileParam fileParam = (FileParam) getItems().get(i);
        adapterItemDiskManageBinding.image.setImageDrawable(null);
        adapterItemDiskManageBinding.fileName.setText(fileParam.getName());
        if (fileParam.isDirectory()) {
            adapterItemDiskManageBinding.image.setImageResource(R.drawable.ic_folder);
        } else {
            adapterItemDiskManageBinding.image.setImageResource(R.drawable.ic_file);
        }
        if (fileParam.isDirectory()) {
            adapterItemDiskManageBinding.fileSize.setVisibility(4);
        } else {
            adapterItemDiskManageBinding.fileSize.setVisibility(0);
            adapterItemDiskManageBinding.fileSize.setText(fileParam.getSize());
        }
        adapterItemDiskManageBinding.fileInfo.setText(fileParam.getLastModified());
        adapterItemDiskManageBinding.status.setSelected(fileParam.isSelected());
        DiskManageParam diskManageParam = this.diskManageParam;
        if (diskManageParam != null) {
            DiskManageParam.SelectionMode selectionMode = diskManageParam.getSelectionMode();
            if (fileParam.isDirectory()) {
                if (selectionMode == DiskManageParam.SelectionMode.NONE || selectionMode == DiskManageParam.SelectionMode.FILE) {
                    adapterItemDiskManageBinding.status.setEnabled(false);
                    adapterItemDiskManageBinding.status.setAlpha(ContextUtil.getAlpha(false));
                    return;
                }
                adapterItemDiskManageBinding.status.setEnabled(true);
                adapterItemDiskManageBinding.status.setAlpha(ContextUtil.getAlpha(true));
            } else if (selectionMode == DiskManageParam.SelectionMode.NONE || selectionMode == DiskManageParam.SelectionMode.DIR) {
                adapterItemDiskManageBinding.status.setEnabled(false);
                adapterItemDiskManageBinding.status.setAlpha(ContextUtil.getAlpha(false));
            } else {
                adapterItemDiskManageBinding.status.setEnabled(true);
                adapterItemDiskManageBinding.status.setAlpha(ContextUtil.getAlpha(true));
            }
        }
    }
}
