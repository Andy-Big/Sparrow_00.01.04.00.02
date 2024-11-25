package com.rigol.scope.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.UtilityCalibrationAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.CalibrationParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.AdapterItemSimple3Binding;
import com.rigol.scope.databinding.AdapterUtilityCalibrationBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.CalibrationViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.calibration.CalibrationPopupView;
import com.rigol.scope.views.grid.GridSpaceItemDecoration;
import java.util.List;
/* loaded from: classes.dex */
public class UtilityCalibrationAdapter extends RecyclerView.Adapter<CalibrationViewHolder> {
    private AdapterUtilityCalibrationBinding binding;
    private List<Integer> bits;
    private final Context context;
    private BaseAdapter<List<MappingObject>> currentAdapter;
    private SyncDataViewModel syncDataViewModel;
    private final UtilityViewModel utilityViewModel;
    private CalibrationParam calibrationParam = null;
    private boolean calItemsCheckChanged = false;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilityCalibrationAdapter(Context context) {
        this.context = context;
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        this.utilityViewModel = utilityViewModel;
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityCalibrationAdapter$8GnNlv3as_4DIqZwqxwIO7xKKZA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UtilityCalibrationAdapter.this.lambda$new$0$UtilityCalibrationAdapter((UtilityParam) obj);
                }
            });
        }
        if (this.syncDataViewModel == null) {
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            this.syncDataViewModel = syncDataViewModel;
            if (syncDataViewModel != null) {
                LifecycleOwner lifecycleOwner = (LifecycleOwner) context;
                syncDataViewModel.get(9, MessageID.MSG_CAL_START).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityCalibrationAdapter$wvGv2jBRHYWha9IdtdP-rJYQUrs
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UtilityCalibrationAdapter.this.lambda$new$1$UtilityCalibrationAdapter(obj);
                    }
                });
                this.syncDataViewModel.get(9, MessageID.MSG_CAL_ITEMS).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityCalibrationAdapter$HB5daDpmJKz1B7QRtR0BrScG5X0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UtilityCalibrationAdapter.this.lambda$new$3$UtilityCalibrationAdapter(obj);
                    }
                });
            }
        }
        CalibrationViewModel calibrationViewModel = (CalibrationViewModel) ContextUtil.getAppViewModel(CalibrationViewModel.class);
        if (calibrationViewModel != null) {
            calibrationViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityCalibrationAdapter$vmPpVpesDq0BdksAc1-_VILz7cI
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UtilityCalibrationAdapter.this.lambda$new$4$UtilityCalibrationAdapter((CalibrationParam) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$UtilityCalibrationAdapter(UtilityParam utilityParam) {
        AdapterUtilityCalibrationBinding adapterUtilityCalibrationBinding = this.binding;
        if (adapterUtilityCalibrationBinding != null) {
            adapterUtilityCalibrationBinding.setParam(utilityParam);
        }
    }

    public /* synthetic */ void lambda$new$1$UtilityCalibrationAdapter(Object obj) {
        startCalibration(true);
    }

    public /* synthetic */ void lambda$new$3$UtilityCalibrationAdapter(Object obj) {
        new Handler().postDelayed(new Runnable() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityCalibrationAdapter$mYXp24Ax10BoJBGsjkPgAT_37lw
            @Override // java.lang.Runnable
            public final void run() {
                UtilityCalibrationAdapter.this.lambda$new$2$UtilityCalibrationAdapter();
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$new$2$UtilityCalibrationAdapter() {
        getBits(ViewUtil.getList((int) R.array.msg_cal_items).size());
        BaseAdapter<List<MappingObject>> baseAdapter = this.currentAdapter;
        if (baseAdapter != null) {
            baseAdapter.notifyDataSetChanged();
        }
    }

    public /* synthetic */ void lambda$new$4$UtilityCalibrationAdapter(CalibrationParam calibrationParam) {
        this.calibrationParam = calibrationParam;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public CalibrationViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        UtilityParam value;
        this.binding = AdapterUtilityCalibrationBinding.inflate(LayoutInflater.from(this.context), viewGroup, false);
        UtilityViewModel utilityViewModel = this.utilityViewModel;
        if (utilityViewModel != null && (value = utilityViewModel.getLiveData().getValue()) != null) {
            this.binding.setParam(value);
            this.binding.executePendingBindings();
        }
        this.binding.start.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityCalibrationAdapter$01j89cXbxio_Ps8KRchfbhACfjI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityCalibrationAdapter.this.lambda$onCreateViewHolder$5$UtilityCalibrationAdapter(view);
            }
        });
        return new CalibrationViewHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$5$UtilityCalibrationAdapter(View view) {
        startCalibration(false);
    }

    private void startCalibration(boolean z) {
        CalibrationParam calibrationParam = this.calibrationParam;
        if (calibrationParam == null) {
            return;
        }
        if (!this.calItemsCheckChanged) {
            this.bits = ViewUtil.getBitsFromValue(calibrationParam.getItemBits());
            LogUtils.e("   bits =", "getBits3", Integer.valueOf(this.calibrationParam.getItemBits()));
            this.calibrationParam.saveItems(getValueFromBits(this.bits));
        }
        this.calibrationParam.setShowDetail(false);
        if (z) {
            this.calibrationParam.postStart();
        } else {
            this.calibrationParam.start();
        }
        PopupViewManager.getInstance().dismiss(UtilityPopupView.class);
        BasePopupView basePopupView = PopupViewManager.getInstance().get(CalibrationPopupView.class);
        if (basePopupView instanceof CalibrationPopupView) {
            ((CalibrationPopupView) basePopupView).setProbe(false);
            if (basePopupView.isShowing()) {
                return;
            }
            basePopupView.show();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(CalibrationViewHolder calibrationViewHolder, int i) {
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_cal_items);
        BaseAdapter<List<MappingObject>> createAdapter = createAdapter(this.calibrationParam);
        this.currentAdapter = createAdapter;
        this.binding.calItemsList.setAdapter(createAdapter);
        this.binding.calItemsList.addItemDecoration(new GridSpaceItemDecoration(2, false));
        createAdapter.setItems(list);
        createAdapter.notifyDataSetChanged();
        getBits(list.size());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBits(int i) {
        CalibrationParam calibrationParam = this.calibrationParam;
        if (calibrationParam == null) {
            return;
        }
        List<Integer> bitsFromValue = ViewUtil.getBitsFromValue(calibrationParam.getItemBits());
        this.bits = bitsFromValue;
        ViewUtil.checkLengthIfNotEnoughThenAdd(bitsFromValue, i);
        ViewUtil.selectAllBitWhenFirstBitOn(this.bits);
        LogUtils.e("BuildConfigbits", Integer.valueOf(this.bits.size()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.adapters.UtilityCalibrationAdapter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends BaseAdapter<List<MappingObject>> {
        final /* synthetic */ CalibrationParam val$param;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Context context, int i, CalibrationParam calibrationParam) {
            super(context, i);
            this.val$param = calibrationParam;
        }

        @Override // com.rigol.scope.adapters.BaseAdapter
        protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list, int i) {
            AdapterItemSimple3Binding adapterItemSimple3Binding = (AdapterItemSimple3Binding) baseViewHolder.getBinding();
            UtilityCalibrationAdapter.this.getBits(ViewUtil.getList((int) R.array.msg_cal_items).size());
            adapterItemSimple3Binding.checkbox.setText(list.get(i).getStr());
            adapterItemSimple3Binding.checkbox.setChecked(((Integer) UtilityCalibrationAdapter.this.bits.get(i)).intValue() == 1);
            if (!UtilityCalibrationAdapter.assertCheckboxEnable(i)) {
                adapterItemSimple3Binding.checkbox.setEnabled(false);
                adapterItemSimple3Binding.checkbox.setChecked(false);
            }
            if (i == 0) {
                adapterItemSimple3Binding.checkbox.setEnabled(true);
            }
        }

        @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
            final BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
            ViewDataBinding binding = onCreateViewHolder.getBinding();
            if (binding instanceof AdapterItemSimple3Binding) {
                CheckBox checkBox = ((AdapterItemSimple3Binding) binding).checkbox;
                final CalibrationParam calibrationParam = this.val$param;
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityCalibrationAdapter$1$BNgIGTLKWTiWdTNiTB2WPbjDv9g
                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                        UtilityCalibrationAdapter.AnonymousClass1.this.lambda$onCreateViewHolder$0$UtilityCalibrationAdapter$1(onCreateViewHolder, calibrationParam, compoundButton, z);
                    }
                });
            }
            return onCreateViewHolder;
        }

        public /* synthetic */ void lambda$onCreateViewHolder$0$UtilityCalibrationAdapter$1(BaseViewHolder baseViewHolder, CalibrationParam calibrationParam, CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                UtilityCalibrationAdapter.this.getBits(ViewUtil.getList((int) R.array.msg_cal_items).size());
                UtilityCalibrationAdapter.this.calItemsCheckChanged = true;
                int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
                UtilityCalibrationAdapter.this.bits.set(bindingAdapterPosition, Integer.valueOf(z ? 1 : 0));
                if (bindingAdapterPosition != 0) {
                    Integer num = (Integer) UtilityCalibrationAdapter.this.bits.get(0);
                    if (z) {
                        if (UtilityCalibrationAdapter.isAllBitsSelected(UtilityCalibrationAdapter.this.bits, 1, UtilityCalibrationAdapter.this.bits.size()) && num.intValue() == 0) {
                            UtilityCalibrationAdapter.this.bits.set(0, 1);
                            notifyDataSetChanged();
                        }
                    } else if (num.intValue() == 1) {
                        UtilityCalibrationAdapter.this.bits.set(0, 0);
                        notifyDataSetChanged();
                    }
                } else {
                    if (z) {
                        ViewUtil.selectAllBits(UtilityCalibrationAdapter.this.bits);
                    } else {
                        ViewUtil.unSelectAllBits(UtilityCalibrationAdapter.this.bits);
                    }
                    notifyDataSetChanged();
                }
                calibrationParam.saveItems(UtilityCalibrationAdapter.getValueFromBits(UtilityCalibrationAdapter.this.bits));
                UtilityCalibrationAdapter utilityCalibrationAdapter = UtilityCalibrationAdapter.this;
                utilityCalibrationAdapter.getBits(utilityCalibrationAdapter.bits.size());
            }
        }
    }

    private BaseAdapter<List<MappingObject>> createAdapter(CalibrationParam calibrationParam) {
        return new AnonymousClass1(this.context, R.layout.adapter_item_simple3, calibrationParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int getValueFromBits(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (assertCheckboxEnable(i2)) {
                Integer num = list.get(i2);
                if (num.intValue() == 1) {
                    i += num.intValue() << i2;
                }
            }
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean isAllBitsSelected(List<Integer> list, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        while (i < i2) {
            if (assertCheckboxEnable(i) && list.get(i).intValue() != 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean assertCheckboxEnable(int i) {
        if (((VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class)).getValue().size() == 2 && (i == 7 || i == 8)) {
            LogUtils.e("assertCheckboxEnable", Integer.valueOf(i));
            return false;
        }
        return true;
    }

    /* loaded from: classes.dex */
    public static class CalibrationViewHolder extends RecyclerView.ViewHolder {
        public CalibrationViewHolder(AdapterUtilityCalibrationBinding adapterUtilityCalibrationBinding) {
            super(adapterUtilityCalibrationBinding.getRoot());
        }
    }
}
