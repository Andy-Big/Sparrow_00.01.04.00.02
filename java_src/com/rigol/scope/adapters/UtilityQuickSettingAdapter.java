package com.rigol.scope.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.UtilityQuickSettingAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.AdapterStatResetBinding;
import com.rigol.scope.databinding.AdapterUtilityAllmeasureBinding;
import com.rigol.scope.databinding.AdapterUtilityQuickBinding;
import com.rigol.scope.databinding.AdapterUtilityQuickScreenshotBinding;
import com.rigol.scope.databinding.AdapterUtilityQuickTitleBinding;
import com.rigol.scope.databinding.AdapterUtilitySaveGroupBinding;
import com.rigol.scope.databinding.AdapterUtilitySaveWaveBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.List;

/* loaded from: classes.dex */
public class UtilityQuickSettingAdapter extends RecyclerView.Adapter<QuickViewHolder> {
    private final View baseView;
    private AdapterUtilityQuickBinding binding;
    private final Context context;
    private final List<MappingObject> titleList = ViewUtil.getList((int) R.array.msg_quick_operation);
    private UtilitQuickOperationTitleAdapter utilitQuickOperationTitleAdapter;
    private UtilityParam utilityParam;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilityQuickSettingAdapter(Context context, View view) {
        this.baseView = view;
        this.context = context;
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel == null || utilityViewModel.getLiveData().getValue() == null) {
            return;
        }
        this.utilityParam = utilityViewModel.getLiveData().getValue();
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(27, MessageID.MSG_QUICK_OPERATION).observe((LifecycleOwner) context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityQuickSettingAdapter$Sr0rsSqk_hH9XCSNE0z9lL-gK2o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UtilityQuickSettingAdapter.this.lambda$new$0$UtilityQuickSettingAdapter(obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$UtilityQuickSettingAdapter(Object obj) {
        updateQuickOperationUI();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public QuickViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterUtilityQuickBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new QuickViewHolder(this.binding);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(QuickViewHolder quickViewHolder, int i) {
        this.utilitQuickOperationTitleAdapter = new UtilitQuickOperationTitleAdapter(this.context, this.titleList, this.utilityParam);
        quickViewHolder.binding.recyclerLable.setAdapter(this.utilitQuickOperationTitleAdapter);
        setContent(this.utilityParam.getQuickOper().value1);
    }

    /* loaded from: classes.dex */
    protected static class QuickViewHolder extends RecyclerView.ViewHolder {
        private final AdapterUtilityQuickBinding binding;

        public QuickViewHolder(AdapterUtilityQuickBinding adapterUtilityQuickBinding) {
            super(adapterUtilityQuickBinding.getRoot());
            this.binding = adapterUtilityQuickBinding;
        }
    }

    public void setContent(int i) {
        ServiceEnum.UtilityQuickOperationType utilityQuickOperationTypeFromValue1;
        if (this.binding == null || (utilityQuickOperationTypeFromValue1 = ServiceEnum.getUtilityQuickOperationTypeFromValue1(i)) == null) {
            return;
        }
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[utilityQuickOperationTypeFromValue1.ordinal()]) {
            case 1:
                this.binding.operationValue.setText(this.titleList.get(0).getStr());
                this.binding.recyclerContent.setAdapter(new QuickScreenshotAdapter(this.context));
                hideRecyclerContent(false);
                return;
            case 2:
            case 3:
            case 4:
                this.binding.operationValue.setText(this.titleList.get(5).getStr());
                hideRecyclerContent(true);
                return;
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                this.binding.operationValue.setText(this.titleList.get(2).getStr());
                hideRecyclerContent(true);
                return;
            case 11:
                this.binding.operationValue.setText(this.titleList.get(1).getStr());
                this.binding.recyclerContent.setAdapter(new QuickSaveWaveAdapter(this.context));
                hideRecyclerContent(false);
                return;
            case 12:
                this.binding.operationValue.setText(this.titleList.get(6).getStr());
                this.binding.recyclerContent.setAdapter(new QuickSaveGroupAdapter(this.context, this.utilityParam));
                hideRecyclerContent(false);
                return;
            case 13:
                this.binding.operationValue.setText(this.titleList.get(4).getStr());
                this.binding.recyclerContent.setAdapter(new QuickStatResetAdapter(this.context, this.utilityParam));
                hideRecyclerContent(false);
                return;
            case 14:
                this.binding.operationValue.setText(this.titleList.get(3).getStr());
                this.binding.recyclerContent.setAdapter(new QuickAllMeasureAdapter(this.context, this.baseView, this.utilityParam));
                hideRecyclerContent(false);
                return;
            default:
                return;
        }
    }

    /* renamed from: com.rigol.scope.adapters.UtilityQuickSettingAdapter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType;

        static {
            int[] iArr = new int[ServiceEnum.UtilityQuickOperationType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType = iArr;
            try {
                iArr[ServiceEnum.UtilityQuickOperationType.QUICK_SaveImage.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_Email.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_Print.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_Record.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_LoadArb.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_LoadMask.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_LoadWave.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_LoadSetup.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_FreezeWave.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_SaveSetup.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_SaveWave.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_SelectSave.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_StatReset.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_AllMeasure.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
        }
    }

    private void hideRecyclerContent(boolean z) {
        if (z) {
            this.binding.recyclerContent.setVisibility(8);
            this.binding.view9.setVisibility(8);
            return;
        }
        this.binding.recyclerContent.setVisibility(0);
        this.binding.view9.setVisibility(0);
    }

    public void updateQuickOperationUI() {
        if (this.binding == null) {
            return;
        }
        UtilitQuickOperationTitleAdapter utilitQuickOperationTitleAdapter = this.utilitQuickOperationTitleAdapter;
        if (utilitQuickOperationTitleAdapter != null) {
            utilitQuickOperationTitleAdapter.notifyDataSetChanged();
        }
        setContent(this.utilityParam.getQuickOper().value1);
    }

    /* loaded from: classes.dex */
    public static class UtilitQuickOperationTitleAdapter extends RecyclerView.Adapter<UtilityQuickOperationTitleViewHolder> {
        private final Context context;
        private List<MappingObject> titleList;
        private final UtilityParam utilityParam;

        public UtilitQuickOperationTitleAdapter(Context context, List<MappingObject> list, UtilityParam utilityParam) {
            this.context = context;
            this.titleList = list;
            this.utilityParam = utilityParam;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public UtilityQuickOperationTitleViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            final UtilityQuickOperationTitleViewHolder utilityQuickOperationTitleViewHolder = new UtilityQuickOperationTitleViewHolder(AdapterUtilityQuickTitleBinding.inflate(LayoutInflater.from(this.context), viewGroup, false));
            utilityQuickOperationTitleViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityQuickSettingAdapter$UtilitQuickOperationTitleAdapter$5i-eGbQaRUvEI8bzQHZEM4hCDuE
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UtilityQuickSettingAdapter.UtilitQuickOperationTitleAdapter.this.lambda$onCreateViewHolder$0$UtilityQuickSettingAdapter$UtilitQuickOperationTitleAdapter(utilityQuickOperationTitleViewHolder, view);
                }
            });
            return utilityQuickOperationTitleViewHolder;
        }

        public /* synthetic */ void lambda$onCreateViewHolder$0$UtilityQuickSettingAdapter$UtilitQuickOperationTitleAdapter(UtilityQuickOperationTitleViewHolder utilityQuickOperationTitleViewHolder, View view) {
            ServiceEnum.UtilityQuickOperationType utilityQuickOperationTypeFromValue1 = ServiceEnum.getUtilityQuickOperationTypeFromValue1(this.titleList.get(utilityQuickOperationTitleViewHolder.getBindingAdapterPosition()).getValue());
            if (utilityQuickOperationTypeFromValue1 == null) {
                return;
            }
            this.utilityParam.saveQuickOper(utilityQuickOperationTypeFromValue1);
            notifyDataSetChanged();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(UtilityQuickOperationTitleViewHolder utilityQuickOperationTitleViewHolder, int i) {
            if (this.utilityParam.getQuickOper().value1 == this.titleList.get(i).getValue()) {
                utilityQuickOperationTitleViewHolder.binding.utilityQuickTitle.setBackground(this.context.getDrawable(R.drawable.bg_rectangle_deepbg));
            } else {
                utilityQuickOperationTitleViewHolder.binding.utilityQuickTitle.setBackground(this.context.getDrawable(R.drawable.bg_rectangle_normal));
            }
            utilityQuickOperationTitleViewHolder.binding.utilityQuickTitle.setText(this.titleList.get(i).getStr());
        }

        public void updateData(List<MappingObject> list) {
            this.titleList = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.titleList.size();
        }

        /* loaded from: classes.dex */
        public static class UtilityQuickOperationTitleViewHolder extends RecyclerView.ViewHolder {
            private AdapterUtilityQuickTitleBinding binding;

            public UtilityQuickOperationTitleViewHolder(AdapterUtilityQuickTitleBinding adapterUtilityQuickTitleBinding) {
                super(adapterUtilityQuickTitleBinding.getRoot());
                this.binding = adapterUtilityQuickTitleBinding;
            }
        }

        public void setData(List<MappingObject> list) {
            this.titleList = list;
            notifyDataSetChanged();
        }
    }

    /* loaded from: classes.dex */
    public static class QuickScreenshotAdapter extends RecyclerView.Adapter<UtilityQuickOperationContentViewHolder> implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener {
        private AdapterUtilityQuickScreenshotBinding binding;
        private Context context;
        private StorageSaveParam storageSaveParam;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(UtilityQuickOperationContentViewHolder utilityQuickOperationContentViewHolder, int i) {
        }

        public QuickScreenshotAdapter(Context context) {
            this.context = context;
            StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
            if (storageViewModel != null) {
                storageViewModel.getSaveLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityQuickSettingAdapter$QuickScreenshotAdapter$o7We5PQLW1vgVQawr3p3Cc19-0g
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UtilityQuickSettingAdapter.QuickScreenshotAdapter.this.lambda$new$0$UtilityQuickSettingAdapter$QuickScreenshotAdapter((StorageSaveParam) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$new$0$UtilityQuickSettingAdapter$QuickScreenshotAdapter(StorageSaveParam storageSaveParam) {
            this.storageSaveParam = storageSaveParam;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public UtilityQuickOperationContentViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            AdapterUtilityQuickScreenshotBinding inflate = AdapterUtilityQuickScreenshotBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
            this.binding = inflate;
            StorageSaveParam storageSaveParam = this.storageSaveParam;
            if (storageSaveParam != null) {
                inflate.setParam(storageSaveParam);
            }
            initStyle(this.binding);
            return new UtilityQuickOperationContentViewHolder(this.binding);
        }

        private void initStyle(AdapterUtilityQuickScreenshotBinding adapterUtilityQuickScreenshotBinding) {
            ViewUtil.setSwitchButton(R.array.msg_storage_image_color, adapterUtilityQuickScreenshotBinding.switchButtonImagecolor);
            ViewUtil.setSwitchButton(adapterUtilityQuickScreenshotBinding.switchButtonInvert);
            adapterUtilityQuickScreenshotBinding.radiogroupImageType.setOnCheckedChangeListener(this);
            adapterUtilityQuickScreenshotBinding.switchButtonImagecolor.setOnCheckedChangeListener(this);
            adapterUtilityQuickScreenshotBinding.switchButtonInvert.setOnCheckedChangeListener(this);
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.radioButton_bmp) {
                this.storageSaveParam.setImageFileType(ServiceEnum.enFileType.FILETYPE_BMP.value1);
            } else if (i == R.id.radioButton_jpg) {
                this.storageSaveParam.setImageFileType(ServiceEnum.enFileType.FILETYPE_JPG.value1);
            } else if (i != R.id.radioButton_png) {
            } else {
                this.storageSaveParam.setImageFileType(ServiceEnum.enFileType.FILETYPE_PNG.value1);
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                int id = compoundButton.getId();
                if (id == R.id.switchButton_invert) {
                    this.storageSaveParam.saveImageInvert(z);
                } else if (id == R.id.switchButton_imagecolor) {
                    this.storageSaveParam.saveImageColor(z);
                }
            }
        }

        /* loaded from: classes.dex */
        private static class UtilityQuickOperationContentViewHolder extends RecyclerView.ViewHolder {
            AdapterUtilityQuickScreenshotBinding binding;

            public UtilityQuickOperationContentViewHolder(AdapterUtilityQuickScreenshotBinding adapterUtilityQuickScreenshotBinding) {
                super(adapterUtilityQuickScreenshotBinding.getRoot());
                this.binding = adapterUtilityQuickScreenshotBinding;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class QuickSaveWaveAdapter extends RecyclerView.Adapter<UtilityQuickSaveWaveViewHolder> implements RadioGroup.OnCheckedChangeListener {
        private AdapterUtilitySaveWaveBinding binding;
        private Context context;
        private StorageSaveParam storageSaveParam;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(UtilityQuickSaveWaveViewHolder utilityQuickSaveWaveViewHolder, int i) {
        }

        public QuickSaveWaveAdapter(Context context) {
            this.context = context;
            StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
            if (storageViewModel != null) {
                storageViewModel.getSaveLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityQuickSettingAdapter$QuickSaveWaveAdapter$m1YMr2lzWknSfyEGdkz5qzvyMYo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UtilityQuickSettingAdapter.QuickSaveWaveAdapter.this.lambda$new$0$UtilityQuickSettingAdapter$QuickSaveWaveAdapter((StorageSaveParam) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$new$0$UtilityQuickSettingAdapter$QuickSaveWaveAdapter(StorageSaveParam storageSaveParam) {
            this.storageSaveParam = storageSaveParam;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public UtilityQuickSaveWaveViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            AdapterUtilitySaveWaveBinding inflate = AdapterUtilitySaveWaveBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
            this.binding = inflate;
            StorageSaveParam storageSaveParam = this.storageSaveParam;
            if (storageSaveParam != null) {
                inflate.setParam(storageSaveParam);
            }
            initStyle(this.binding);
            return new UtilityQuickSaveWaveViewHolder(this.binding);
        }

        private void initStyle(AdapterUtilitySaveWaveBinding adapterUtilitySaveWaveBinding) {
            adapterUtilitySaveWaveBinding.radiogroupDataSource.setOnCheckedChangeListener(this);
            adapterUtilitySaveWaveBinding.radiogroupFormat.setOnCheckedChangeListener(this);
            adapterUtilitySaveWaveBinding.setScreenMapping(ViewUtil.getMappingObject(R.array.msg_quick_wave_from, ServiceEnum.UtilityQuickDataSource.Screen.value1));
            adapterUtilitySaveWaveBinding.setMemoryMapping(ViewUtil.getMappingObject(R.array.msg_quick_wave_from, ServiceEnum.UtilityQuickDataSource.Memory.value1));
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.radioButton_bin /* 2131363654 */:
                    this.storageSaveParam.setWaveFileType(ServiceEnum.enFileType.FILETYPE_BIN.value1);
                    return;
                case R.id.radioButton_csv /* 2131363657 */:
                    this.storageSaveParam.setWaveFileType(ServiceEnum.enFileType.FILETYPE_CSV.value1);
                    return;
                case R.id.radioButton_memory /* 2131363667 */:
                    this.storageSaveParam.saveWaveDepth(ServiceEnum.UtilityQuickDataSource.Memory.value1);
                    return;
                case R.id.radioButton_screen /* 2131363670 */:
                    this.storageSaveParam.saveWaveDepth(ServiceEnum.UtilityQuickDataSource.Screen.value1);
                    return;
                case R.id.radioButton_wfm /* 2131363672 */:
                    this.storageSaveParam.setWaveFileType(ServiceEnum.enFileType.FILETYPE_WFM.value1);
                    return;
                default:
                    return;
            }
        }

        /* loaded from: classes.dex */
        private static class UtilityQuickSaveWaveViewHolder extends RecyclerView.ViewHolder {
            AdapterUtilitySaveWaveBinding binding;

            public UtilityQuickSaveWaveViewHolder(AdapterUtilitySaveWaveBinding adapterUtilitySaveWaveBinding) {
                super(adapterUtilitySaveWaveBinding.getRoot());
                this.binding = adapterUtilitySaveWaveBinding;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class QuickAllMeasureAdapter extends RecyclerView.Adapter<UtilityAllMeasureViewHolder> {
        private final View baseView;
        private AdapterUtilityAllmeasureBinding binding;
        private final Context context;
        private final UtilityParam utilityParam;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(UtilityAllMeasureViewHolder utilityAllMeasureViewHolder, int i) {
        }

        public QuickAllMeasureAdapter(Context context, View view, UtilityParam utilityParam) {
            this.context = context;
            this.baseView = view;
            this.utilityParam = utilityParam;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public UtilityAllMeasureViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            this.binding = AdapterUtilityAllmeasureBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
            UtilityAllMeasureViewHolder utilityAllMeasureViewHolder = new UtilityAllMeasureViewHolder(this.binding);
            UtilityParam utilityParam = this.utilityParam;
            if (utilityParam != null) {
                this.binding.setParam(utilityParam);
                utilityAllMeasureViewHolder.binding.tvAllmeasureValue.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityQuickSettingAdapter$QuickAllMeasureAdapter$9s6pZHpzShujof_c-co71MniMxc
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        UtilityQuickSettingAdapter.QuickAllMeasureAdapter.this.lambda$onCreateViewHolder$1$UtilityQuickSettingAdapter$QuickAllMeasureAdapter(view);
                    }
                });
            }
            return utilityAllMeasureViewHolder;
        }

        public /* synthetic */ void lambda$onCreateViewHolder$1$UtilityQuickSettingAdapter$QuickAllMeasureAdapter(View view) {
            ViewUtil.showChanSpinner(this.baseView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_quick_meas_all_src)), new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityQuickSettingAdapter$QuickAllMeasureAdapter$Mm2PUXgYbcTtzcg5r_PtRHVkXzI
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    UtilityQuickSettingAdapter.QuickAllMeasureAdapter.this.lambda$onCreateViewHolder$0$UtilityQuickSettingAdapter$QuickAllMeasureAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }

        public /* synthetic */ void lambda$onCreateViewHolder$0$UtilityQuickSettingAdapter$QuickAllMeasureAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
            if (chanFromValue1 == null) {
                return;
            }
            this.utilityParam.saveMeasSrc(chanFromValue1);
        }

        /* loaded from: classes.dex */
        private static class UtilityAllMeasureViewHolder extends RecyclerView.ViewHolder {
            AdapterUtilityAllmeasureBinding binding;

            public UtilityAllMeasureViewHolder(AdapterUtilityAllmeasureBinding adapterUtilityAllmeasureBinding) {
                super(adapterUtilityAllmeasureBinding.getRoot());
                this.binding = adapterUtilityAllmeasureBinding;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class QuickStatResetAdapter extends RecyclerView.Adapter<UtilityStatResetViewHolder> implements RadioGroup.OnCheckedChangeListener {
        private AdapterStatResetBinding binding;
        private Context context;
        private UtilityParam utilityParam;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(UtilityStatResetViewHolder utilityStatResetViewHolder, int i) {
        }

        public QuickStatResetAdapter(Context context, UtilityParam utilityParam) {
            this.context = context;
            this.utilityParam = utilityParam;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public UtilityStatResetViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            AdapterStatResetBinding inflate = AdapterStatResetBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
            this.binding = inflate;
            UtilityParam utilityParam = this.utilityParam;
            if (utilityParam != null) {
                inflate.setParam(utilityParam);
                this.binding.setMaskMapping(ViewUtil.getMappingObject(R.array.msg_quick_stat_reset, ServiceEnum.UtilityQuickStatReset.PassFail.value1));
                this.binding.setMeasureMapping(ViewUtil.getMappingObject(R.array.msg_quick_stat_reset, ServiceEnum.UtilityQuickStatReset.Measure.value1));
                this.binding.statResetRadioGroup.setOnCheckedChangeListener(this);
            }
            return new UtilityStatResetViewHolder(this.binding);
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.radioButton_mask) {
                this.utilityParam.saveStatReset(ServiceEnum.UtilityQuickStatReset.PassFail);
            } else if (i != R.id.radioButton_measure) {
            } else {
                this.utilityParam.saveStatReset(ServiceEnum.UtilityQuickStatReset.Measure);
            }
        }

        /* loaded from: classes.dex */
        private static class UtilityStatResetViewHolder extends RecyclerView.ViewHolder {
            AdapterStatResetBinding binding;

            public UtilityStatResetViewHolder(AdapterStatResetBinding adapterStatResetBinding) {
                super(adapterStatResetBinding.getRoot());
                this.binding = adapterStatResetBinding;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class QuickSaveGroupAdapter extends RecyclerView.Adapter<UtilitySaveGroupViewHolder> implements CompoundButton.OnCheckedChangeListener {
        private AdapterUtilitySaveGroupBinding binding;
        private Context context;
        private UtilityParam utilityParam;

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return 1;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(UtilitySaveGroupViewHolder utilitySaveGroupViewHolder, int i) {
        }

        public QuickSaveGroupAdapter(Context context, UtilityParam utilityParam) {
            this.context = context;
            this.utilityParam = utilityParam;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public UtilitySaveGroupViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            AdapterUtilitySaveGroupBinding inflate = AdapterUtilitySaveGroupBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
            this.binding = inflate;
            UtilityParam utilityParam = this.utilityParam;
            if (utilityParam != null) {
                inflate.setParam(utilityParam);
            }
            this.binding.checkBoxSaveWave.setOnCheckedChangeListener(this);
            this.binding.checkboxScreenshot.setOnCheckedChangeListener(this);
            this.binding.checkBoxSettingSave.setOnCheckedChangeListener(this);
            return new UtilitySaveGroupViewHolder(this.binding);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int id = compoundButton.getId();
            if (compoundButton.isPressed()) {
                if (id == R.id.checkbox_screenshot) {
                    if (z) {
                        UtilityParam utilityParam = this.utilityParam;
                        utilityParam.saveSaveGroup(ViewUtil.setSpecifiedBitTo1(utilityParam.getSaveGroup(), 0));
                        return;
                    }
                    UtilityParam utilityParam2 = this.utilityParam;
                    utilityParam2.saveSaveGroup(ViewUtil.setSpecifiedBitTo0(utilityParam2.getSaveGroup(), 0));
                } else if (id == R.id.checkBox_save_wave) {
                    if (z) {
                        UtilityParam utilityParam3 = this.utilityParam;
                        utilityParam3.saveSaveGroup(ViewUtil.setSpecifiedBitTo1(utilityParam3.getSaveGroup(), 1));
                        return;
                    }
                    UtilityParam utilityParam4 = this.utilityParam;
                    utilityParam4.saveSaveGroup(ViewUtil.setSpecifiedBitTo0(utilityParam4.getSaveGroup(), 1));
                } else if (id == R.id.checkBox_setting_save) {
                    if (z) {
                        UtilityParam utilityParam5 = this.utilityParam;
                        utilityParam5.saveSaveGroup(ViewUtil.setSpecifiedBitTo1(utilityParam5.getSaveGroup(), 2));
                        return;
                    }
                    UtilityParam utilityParam6 = this.utilityParam;
                    utilityParam6.saveSaveGroup(ViewUtil.setSpecifiedBitTo0(utilityParam6.getSaveGroup(), 2));
                }
            }
        }

        /* loaded from: classes.dex */
        private static class UtilitySaveGroupViewHolder extends RecyclerView.ViewHolder {
            AdapterUtilitySaveGroupBinding binding;

            public UtilitySaveGroupViewHolder(AdapterUtilitySaveGroupBinding adapterUtilitySaveGroupBinding) {
                super(adapterUtilitySaveGroupBinding.getRoot());
                this.binding = adapterUtilitySaveGroupBinding;
            }
        }
    }
}
