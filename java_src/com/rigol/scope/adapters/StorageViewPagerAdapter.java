package com.rigol.scope.adapters;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.StorageViewPagerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.AdapterStorageLoadBinding;
import com.rigol.scope.databinding.AdapterStorageSaveBinding;
import com.rigol.scope.databinding.AdapterStorageUpgradeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import java.util.List;

/* loaded from: classes.dex */
public class StorageViewPagerAdapter extends MultiItemTypeAdapter<List<MappingObject>> {
    private LoadDelegate loadDelegate;
    private SaveDelegate saveDelegate;
    private UpgradeDelegate upgradeDelegate;

    /* loaded from: classes.dex */
    public interface OnItemClickCallback {
        void onLoadItemClick(AdapterStorageLoadBinding adapterStorageLoadBinding, StorageLoadParam storageLoadParam, View view);

        void onManagerCall(AorBManager aorBManager);

        void onSaveItemClick(AdapterStorageSaveBinding adapterStorageSaveBinding, StorageSaveParam storageSaveParam, View view);

        void onUpgradeItemClick(AdapterStorageUpgradeBinding adapterStorageUpgradeBinding, View view);
    }

    public StorageViewPagerAdapter(Context context, List<MappingObject> list) {
        super(context, list);
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel != null) {
            this.saveDelegate = new SaveDelegate(R.layout.adapter_storage_save, storageViewModel.getSaveLiveData().getValue());
            this.loadDelegate = new LoadDelegate(R.layout.adapter_storage_load, storageViewModel.getLoadLiveData().getValue());
            this.upgradeDelegate = new UpgradeDelegate(R.layout.adapter_storage_upgrade);
            this.delegatesManager.addDelegate(this.saveDelegate).addDelegate(this.loadDelegate).addDelegate(this.upgradeDelegate);
        }
    }

    /* loaded from: classes.dex */
    public static class SaveDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener {
        private AorBManager aorBManager;
        private AdapterStorageSaveBinding binding;
        private OnItemClickCallback onItemClickCallback;
        private final StorageSaveParam param;

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public SaveDelegate(int i, StorageSaveParam storageSaveParam) {
            super(i);
            this.param = storageSaveParam;
        }

        public AorBManager getAorBManager() {
            return this.aorBManager;
        }

        public void setAorBManager(AorBManager aorBManager) {
            this.aorBManager = aorBManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            MappingObject mappingObject = list.get(i);
            return mappingObject != null && mappingObject.getValue() == ServiceEnum.StorageOperation.SAVE.value1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterStorageSaveBinding adapterStorageSaveBinding = (AdapterStorageSaveBinding) baseViewHolder.getBinding();
            this.binding = adapterStorageSaveBinding;
            adapterStorageSaveBinding.setParam(this.param);
            this.binding.getRoot().getContext();
            this.binding.chooseSpinnerSave.setOnClickListener(this);
            this.binding.imageFormatSpinner.setOnClickListener(this);
            this.binding.waveFormatSpinner.setOnClickListener(this);
            this.binding.setupFormatSpinner.setOnClickListener(this);
            this.binding.waveDepthSpinner.setOnClickListener(this);
            this.binding.prefixEditText.setOnClickListener(this);
            this.binding.pathNameEditText.setOnClickListener(this);
            this.binding.imageInvertSwitch.setOnClickListener(this);
            this.binding.imageColorSwitch.setOnClickListener(this);
            this.binding.imageHeaderSwitch.setOnClickListener(this);
            this.binding.autoNameSwitch.setOnClickListener(this);
            this.binding.save.setOnClickListener(this);
            this.binding.checkBoxCH1.setOnClickListener(this);
            this.binding.checkBoxCH2.setOnClickListener(this);
            this.binding.checkBoxCH3.setOnClickListener(this);
            this.binding.checkBoxCH4.setOnClickListener(this);
            this.binding.smbEnSwitch.setOnClickListener(this);
            ViewUtil.setSwitchButton(this.binding.autoNameSwitch);
            ViewUtil.setSwitchButton(R.array.msg_storage_image_color, this.binding.imageColorSwitch);
            ViewUtil.setSwitchButton(this.binding.imageHeaderSwitch);
            ViewUtil.setSwitchButton(this.binding.imageInvertSwitch);
            ViewUtil.setSwitchButton(this.binding.smbEnSwitch);
            AorBManager aorBManager = this.aorBManager;
            if (aorBManager == null || aorBManager.getList_aorbParam() == null) {
                return;
            }
            this.aorBManager.getList_aorbParam().add(new AorBParam(this.binding.chooseSpinnerSave, 0, false, "", 2));
            this.aorBManager.getList_aorbParam().add(new AorBParam(this.binding.imageFormatSpinner, 0, false, "", 2));
            this.aorBManager.getList_aorbParam().add(new AorBParam(this.binding.waveFormatSpinner, 0, false, "", 2));
            this.aorBManager.getList_aorbParam().add(new AorBParam(this.binding.setupFormatSpinner, 0, false, "", 2));
            this.aorBManager.getList_aorbParam().add(new AorBParam(this.binding.waveDepthSpinner, 0, false, "", 2));
            OnItemClickCallback onItemClickCallback = this.onItemClickCallback;
            if (onItemClickCallback != null) {
                onItemClickCallback.onManagerCall(this.aorBManager);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickCallback onItemClickCallback = this.onItemClickCallback;
            if (onItemClickCallback != null) {
                onItemClickCallback.onSaveItemClick(this.binding, this.param, view);
            }
        }

        public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }

        public void onLocaleChanged() {
            AdapterStorageSaveBinding adapterStorageSaveBinding = this.binding;
            if (adapterStorageSaveBinding != null) {
                ViewUtil.updateSwitchText(R.array.msg_storage_image_color, adapterStorageSaveBinding.imageColorSwitch);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LoadDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener {
        private AorBManager aorBManager;
        private AdapterStorageLoadBinding binding;
        private OnItemClickCallback onItemClickCallback;
        private final StorageLoadParam param;

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public LoadDelegate(int i, StorageLoadParam storageLoadParam) {
            super(i);
            this.param = storageLoadParam;
        }

        public AorBManager getAorBManager() {
            return this.aorBManager;
        }

        public void setAorBManager(AorBManager aorBManager) {
            this.aorBManager = aorBManager;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            MappingObject mappingObject = list.get(i);
            return mappingObject != null && mappingObject.getValue() == ServiceEnum.StorageOperation.LOAD.value1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterStorageLoadBinding adapterStorageLoadBinding = (AdapterStorageLoadBinding) baseViewHolder.getBinding();
            this.binding = adapterStorageLoadBinding;
            adapterStorageLoadBinding.setParam(this.param);
            this.binding.chooseSpinnerLoad.setOnClickListener(this);
            this.binding.waveFileFormatSpinner.setOnClickListener(this);
            this.binding.setupFileFormatSpinner.setOnClickListener(this);
            this.binding.pathNameEditText.setOnClickListener(this);
            this.binding.load.setOnClickListener(this);
            AorBManager aorBManager = this.aorBManager;
            if (aorBManager == null || aorBManager.getList_aorbParam() == null) {
                return;
            }
            this.aorBManager.getList_aorbParam().add(new AorBParam(this.binding.chooseSpinnerLoad, 0, false, "", 2));
            this.aorBManager.getList_aorbParam().add(new AorBParam(this.binding.waveFileFormatSpinner, 0, false, "", 2));
            this.aorBManager.getList_aorbParam().add(new AorBParam(this.binding.setupFileFormatSpinner, 0, false, "", 2));
            OnItemClickCallback onItemClickCallback = this.onItemClickCallback;
            if (onItemClickCallback != null) {
                onItemClickCallback.onManagerCall(this.aorBManager);
            }
        }

        public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickCallback onItemClickCallback = this.onItemClickCallback;
            if (onItemClickCallback != null) {
                onItemClickCallback.onLoadItemClick(this.binding, this.param, view);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class UpgradeDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener {
        private AdapterStorageUpgradeBinding binding;
        private OnItemClickCallback onItemClickCallback;
        private SyncDataViewModel syncDataViewModel;

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public UpgradeDelegate(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            MappingObject mappingObject = list.get(i);
            return mappingObject != null && mappingObject.getValue() == ServiceEnum.StorageOperation.UPGRADE.value1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterStorageUpgradeBinding adapterStorageUpgradeBinding = (AdapterStorageUpgradeBinding) baseViewHolder.getBinding();
            this.binding = adapterStorageUpgradeBinding;
            adapterStorageUpgradeBinding.pathNameEditText.setOnClickListener(this);
            this.binding.upgrade.setOnClickListener(this);
            if (this.syncDataViewModel == null) {
                SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
                this.syncDataViewModel = syncDataViewModel;
                if (syncDataViewModel != null) {
                    syncDataViewModel.get(12, MessageID.MSG_STORAGE_RESULT).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$StorageViewPagerAdapter$UpgradeDelegate$kVj-hYRpM9MfWRNYkqoUGPCrfOQ
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            StorageViewPagerAdapter.UpgradeDelegate.this.lambda$onBindViewHolder$0$StorageViewPagerAdapter$UpgradeDelegate(obj);
                        }
                    });
                }
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$StorageViewPagerAdapter$UpgradeDelegate(Object obj) {
            this.binding.tvHint.setVisibility(PopupViewManager.getInstance().getAvailableSize() < 200 ? 8 : 0);
            this.binding.tvMemUnenoughHint.setVisibility(PopupViewManager.getInstance().getAvailableSize() < 200 ? 0 : 8);
        }

        public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickCallback onItemClickCallback = this.onItemClickCallback;
            if (onItemClickCallback != null) {
                onItemClickCallback.onUpgradeItemClick(this.binding, view);
            }
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback, AorBManager aorBManager) {
        SaveDelegate saveDelegate = this.saveDelegate;
        if (saveDelegate != null) {
            saveDelegate.setOnItemClickCallback(onItemClickCallback);
            this.saveDelegate.setAorBManager(aorBManager);
        }
        LoadDelegate loadDelegate = this.loadDelegate;
        if (loadDelegate != null) {
            loadDelegate.setOnItemClickCallback(onItemClickCallback);
            this.loadDelegate.setAorBManager(aorBManager);
        }
        UpgradeDelegate upgradeDelegate = this.upgradeDelegate;
        if (upgradeDelegate != null) {
            upgradeDelegate.setOnItemClickCallback(onItemClickCallback);
        }
    }

    public void onLocaleChanged() {
        SaveDelegate saveDelegate = this.saveDelegate;
        if (saveDelegate != null) {
            saveDelegate.onLocaleChanged();
        }
    }
}
