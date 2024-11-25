package com.rigol.scope.views;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.CollectionUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.OnItemClickListener;
import com.rigol.scope.adapters.UtilityAboutDeviceAdapter;
import com.rigol.scope.adapters.UtilityAdapter;
import com.rigol.scope.adapters.UtilityAutoConfigAdapter;
import com.rigol.scope.adapters.UtilityCalibrationAdapter;
import com.rigol.scope.adapters.UtilityEmailAdapter;
import com.rigol.scope.adapters.UtilityIOAdapter;
import com.rigol.scope.adapters.UtilityOptionAdapter;
import com.rigol.scope.adapters.UtilityOtherSettingAdapter;
import com.rigol.scope.adapters.UtilityPoweadapter;
import com.rigol.scope.adapters.UtilityQuickSettingAdapter;
import com.rigol.scope.adapters.UtilityScreenSaverAdapter;
import com.rigol.scope.adapters.UtilitySelfCheckAdapter;
import com.rigol.scope.adapters.UtilitySetupSettingAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionInfo;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.AdapterItemSimpleBinding;
import com.rigol.scope.databinding.PopupviewUtilityBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.adc.ADCSettingPopupView;
import com.rigol.scope.views.adc.AdcSerPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.LinearSpaceItemDecoration;
import com.rigol.scope.views.ddrDebug.DdrDebugPopupView;
import com.rigol.scope.views.xy.XYPopupView;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class UtilityPopupView extends BasePopupView {
    private int clickAboutCount;
    private long clickAboutTimeMillis;
    private OptionParam optionParam;
    private UtilityPoweadapter uilityPoweadapter;
    private UtilityAboutDeviceAdapter utilityAboutDeviceAdapter;
    private UtilityAdapter utilityAdapter;
    private UtilityAutoConfigAdapter utilityAutoConfigAdapter;
    private UtilityCalibrationAdapter utilityCalibrationAdapter;
    private UtilityEmailAdapter utilityEmailAdapter;
    private UtilityIOAdapter utilityIOAdapter;
    private UtilityOptionAdapter utilityOptionAdapter;
    private UtilityParam utilityParam;
    private UtilityQuickSettingAdapter utilityQuickSettingAdapter;
    private UtilityScreenSaverAdapter utilityScreenSaverAdapter;
    private UtilitySelfCheckAdapter utilitySelfCheckAdapter;
    private UtilitySetupSettingAdapter utilitySetupSettingAdapter;
    private final UtilityViewModel utilityViewModel;
    private final PopupviewUtilityBinding utilsBinding;

    public UtilityPopupView() {
        super((int) R.style.App_PopupWindow_Utility);
        this.clickAboutCount = 0;
        PopupviewUtilityBinding inflate = PopupviewUtilityBinding.inflate(LayoutInflater.from(this.context));
        this.utilsBinding = inflate;
        setContentView(inflate.getRoot());
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        this.utilityViewModel = utilityViewModel;
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<UtilityParam>() { // from class: com.rigol.scope.views.UtilityPopupView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(UtilityParam utilityParam) {
                    UtilityPopupView.this.utilityParam = utilityParam;
                }
            });
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.-$$Lambda$UtilityPopupView$-ULcXzEn1tGXNq10qYVAnSJdBcg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UtilityPopupView.this.lambda$new$0$UtilityPopupView((OptionParam) obj);
                }
            });
        }
        setUtilsTitleRecycler(getLeftMappingObjects(), this.utilsBinding, this);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(11, MessageID.MSG_APP_UTILITY_PROJECT).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.-$$Lambda$UtilityPopupView$A--ZbydPzdFq0oL69clBHie5FjI
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UtilityPopupView.this.lambda$new$1$UtilityPopupView(obj);
                }
            });
            syncDataViewModel.get(36, MessageID.MSG_LICENSE_CHANGED).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.-$$Lambda$UtilityPopupView$tRb12tZhDPtij49ys9luWPQMglA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UtilityPopupView.this.lambda$new$2$UtilityPopupView(obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$UtilityPopupView(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$new$1$UtilityPopupView(Object obj) {
        if (obj instanceof Boolean) {
            notifyLeftList();
        }
    }

    public /* synthetic */ void lambda$new$2$UtilityPopupView(Object obj) {
        OptionParam optionParam;
        if (this.utilityOptionAdapter == null || (optionParam = this.optionParam) == null || optionParam.getInfoList() == null) {
            return;
        }
        this.utilityOptionAdapter.setItems(Arrays.asList(this.optionParam.getInfoList()));
        this.utilityOptionAdapter.notifyDataSetChanged();
    }

    private void notifyLeftList() {
        List<MappingObject> leftMappingObjects = getLeftMappingObjects();
        if (this.utilityAdapter != null) {
            leftMappingObjects.remove(leftMappingObjects.size() - 1);
            this.utilityAdapter.setData(leftMappingObjects);
            this.utilityAdapter.notifyDataSetChanged();
        }
    }

    private List<MappingObject> getLeftMappingObjects() {
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_app_utility_title);
        UtilityViewModel utilityViewModel = this.utilityViewModel;
        if (utilityViewModel != null) {
            final UtilityParam value = utilityViewModel.getLiveData().getValue();
            return (List) CollectionUtils.select(list, new CollectionUtils.Predicate() { // from class: com.rigol.scope.views.-$$Lambda$UtilityPopupView$OXi0urhHibp2YxYbsbPU4F03N94
                @Override // com.blankj.utilcode.util.CollectionUtils.Predicate
                public final boolean evaluate(Object obj) {
                    return UtilityPopupView.lambda$getLeftMappingObjects$3(UtilityParam.this, (MappingObject) obj);
                }
            });
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$getLeftMappingObjects$3(UtilityParam utilityParam, MappingObject mappingObject) {
        ServiceEnum.UtilityType utilityTypeFromValue1;
        return mappingObject == null || (utilityTypeFromValue1 = ServiceEnum.getUtilityTypeFromValue1(mappingObject.getValue())) == null || utilityParam == null || utilityParam.getProjectMode() || utilityTypeFromValue1 != ServiceEnum.UtilityType.Utility_Debug;
    }

    private void setUtilsTitleRecycler(List<MappingObject> list, final PopupviewUtilityBinding popupviewUtilityBinding, final BasePopupView basePopupView) {
        this.utilityAdapter = new UtilityAdapter(list);
        popupviewUtilityBinding.utilLeft.setAdapter(this.utilityAdapter);
        popupviewUtilityBinding.utilRight.addItemDecoration(new LinearSpaceItemDecoration(5));
        this.utilityIOAdapter = new UtilityIOAdapter(this.context, basePopupView);
        popupviewUtilityBinding.utilRight.setAdapter(this.utilityIOAdapter);
        this.utilityAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.-$$Lambda$UtilityPopupView$z4l3QXGOPn9mO9cWkjcHr0uRe7U
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                UtilityPopupView.this.lambda$setUtilsTitleRecycler$5$UtilityPopupView(popupviewUtilityBinding, basePopupView, view, viewHolder, i);
            }
        });
    }

    public /* synthetic */ void lambda$setUtilsTitleRecycler$5$UtilityPopupView(PopupviewUtilityBinding popupviewUtilityBinding, BasePopupView basePopupView, View view, RecyclerView.ViewHolder viewHolder, int i) {
        OptionInfo[] infoList;
        UtilityParam value;
        ServiceEnum.UtilityType utilityTypeFromValue1 = ServiceEnum.getUtilityTypeFromValue1(this.utilityAdapter.getData().get(i).getValue());
        if (utilityTypeFromValue1 == null) {
            return;
        }
        if (utilityTypeFromValue1 == ServiceEnum.UtilityType.Utility_About) {
            System.currentTimeMillis();
            int i2 = this.clickAboutCount + 1;
            this.clickAboutCount = i2;
            if (i2 == 3) {
                UtilityViewModel utilityViewModel = this.utilityViewModel;
                if (utilityViewModel != null && (value = utilityViewModel.getLiveData().getValue()) != null) {
                    value.saveProjectMode(!value.getProjectMode());
                    ViewUtil.switchToast(R.string.msg_app_utility_project, value.getProjectMode());
                }
                this.clickAboutCount = 0;
            }
        } else {
            this.clickAboutCount = 0;
        }
        switch (AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[utilityTypeFromValue1.ordinal()]) {
            case 1:
                popupviewUtilityBinding.utilRight.setAdapter(this.utilityIOAdapter);
                return;
            case 2:
                if (this.utilitySetupSettingAdapter == null) {
                    this.utilitySetupSettingAdapter = new UtilitySetupSettingAdapter(this.context, basePopupView.getAnchor());
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.utilitySetupSettingAdapter);
                return;
            case 3:
                if (this.utilityAboutDeviceAdapter == null) {
                    this.utilityAboutDeviceAdapter = new UtilityAboutDeviceAdapter(this.context);
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.utilityAboutDeviceAdapter);
                return;
            case 4:
                popupviewUtilityBinding.utilRight.setAdapter(new UtilityOtherSettingAdapter(basePopupView.getAnchor()));
                return;
            case 5:
                if (this.utilityAutoConfigAdapter == null) {
                    this.utilityAutoConfigAdapter = new UtilityAutoConfigAdapter(this.context, basePopupView.getAnchor());
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.utilityAutoConfigAdapter);
                return;
            case 6:
                if (this.utilityCalibrationAdapter == null) {
                    this.utilityCalibrationAdapter = new UtilityCalibrationAdapter(this.context);
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.utilityCalibrationAdapter);
                return;
            case 7:
                if (this.utilityQuickSettingAdapter == null) {
                    this.utilityQuickSettingAdapter = new UtilityQuickSettingAdapter(this.context, basePopupView.getAnchor());
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.utilityQuickSettingAdapter);
                return;
            case 8:
                if (this.utilityScreenSaverAdapter == null) {
                    this.utilityScreenSaverAdapter = new UtilityScreenSaverAdapter((MainActivity) this.context, basePopupView.getAnchor(), this.utilityViewModel.getLiveData().getValue());
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.utilityScreenSaverAdapter);
                return;
            case 9:
                if (this.utilitySelfCheckAdapter == null) {
                    this.utilitySelfCheckAdapter = new UtilitySelfCheckAdapter(this.context);
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.utilitySelfCheckAdapter);
                this.utilitySelfCheckAdapter.setCloseUtilityPopListener(new UtilitySelfCheckAdapter.SelfCheckClosePop() { // from class: com.rigol.scope.views.-$$Lambda$UtilityPopupView$CfOd_j2siQ-EmeMoOB8A6UgZ9Os
                    @Override // com.rigol.scope.adapters.UtilitySelfCheckAdapter.SelfCheckClosePop
                    public final void setClosePop() {
                        UtilityPopupView.this.dismiss();
                    }
                });
                return;
            case 10:
                if (this.utilityEmailAdapter == null) {
                    this.utilityEmailAdapter = new UtilityEmailAdapter(this.context, basePopupView.getAnchor());
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.utilityEmailAdapter);
                return;
            case 11:
            default:
                return;
            case 12:
                final List<MappingObject> list = ViewUtil.getList((int) R.array.debug_msg_list);
                BaseAdapter<List<MappingObject>> baseAdapter = new BaseAdapter<List<MappingObject>>(this.context, list, R.layout.adapter_item_simple) { // from class: com.rigol.scope.views.UtilityPopupView.2
                    @Override // com.rigol.scope.adapters.BaseAdapter
                    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list2, int i3) {
                        MappingObject mappingObject = list2.get(i3);
                        ViewDataBinding binding = baseViewHolder.getBinding();
                        if (binding instanceof AdapterItemSimpleBinding) {
                            AdapterItemSimpleBinding adapterItemSimpleBinding = (AdapterItemSimpleBinding) binding;
                            adapterItemSimpleBinding.text1.setText(mappingObject.getStr());
                            Drawable drawable = ContextUtil.getDrawable(R.drawable.ic_arrow_right);
                            drawable.setTint(-1);
                            drawable.setBounds(0, 0, 30, 30);
                            adapterItemSimpleBinding.text1.setCompoundDrawables(null, null, drawable, null);
                            adapterItemSimpleBinding.icon.setVisibility(8);
                        }
                    }
                };
                baseAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.-$$Lambda$UtilityPopupView$P3jtWbe6VHARREfXZO54hY2ORA4
                    @Override // com.rigol.scope.adapters.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder2, int i3) {
                        UtilityPopupView.lambda$setUtilsTitleRecycler$4(list, view2, viewHolder2, i3);
                    }
                });
                popupviewUtilityBinding.utilRight.setAdapter(baseAdapter);
                return;
            case 13:
                if (this.utilityOptionAdapter == null) {
                    this.utilityOptionAdapter = new UtilityOptionAdapter(this.context);
                }
                OptionParam optionParam = this.optionParam;
                if (optionParam == null || (infoList = optionParam.getInfoList()) == null) {
                    return;
                }
                this.utilityOptionAdapter.setItems(Arrays.asList(infoList));
                popupviewUtilityBinding.utilRight.setAdapter(this.utilityOptionAdapter);
                return;
            case 14:
                if (this.uilityPoweadapter == null) {
                    this.uilityPoweadapter = new UtilityPoweadapter(this.context);
                }
                popupviewUtilityBinding.utilRight.setAdapter(this.uilityPoweadapter);
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setUtilsTitleRecycler$4(List list, View view, RecyclerView.ViewHolder viewHolder, int i) {
        ServiceEnum.DebugType debugTypeFromValue1;
        MappingObject mappingObject = (MappingObject) list.get(i);
        if (mappingObject == null || (debugTypeFromValue1 = ServiceEnum.getDebugTypeFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        int i2 = AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$DebugType[debugTypeFromValue1.ordinal()];
        if (i2 == 1) {
            PopupViewManager.getInstance().toggle(XYPopupView.class);
        } else if (i2 == 2) {
            PopupViewManager.getInstance().toggle(ADCSettingPopupView.class);
        } else if (i2 == 3) {
            PopupViewManager.getInstance().toggle(DdrDebugPopupView.class);
        } else if (i2 == 4) {
            PopupViewManager.getInstance().toggle(AdcSerPopupView.class);
        } else if (i2 != 5) {
        } else {
            PopupViewManager.getInstance().toggle(LogcatPopupView.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.UtilityPopupView$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$DebugType;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType;

        static {
            int[] iArr = new int[ServiceEnum.DebugType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$DebugType = iArr;
            try {
                iArr[ServiceEnum.DebugType.GPU_PLOT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DebugType[ServiceEnum.DebugType.ADC_CLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DebugType[ServiceEnum.DebugType.DDR_IO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DebugType[ServiceEnum.DebugType.ADC_SER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DebugType[ServiceEnum.DebugType.LogCat.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ServiceEnum.UtilityType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType = iArr2;
            try {
                iArr2[ServiceEnum.UtilityType.Utility_IO.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Setup.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_About.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Other.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Auto_Config.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_SelfCal.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Quick_Settings.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Screen_Saver.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Self_Check.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Email.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Printer.ordinal()] = 11;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Debug.ordinal()] = 12;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_Option.ordinal()] = 13;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityType[ServiceEnum.UtilityType.Utility_PMU.ordinal()] = 14;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    protected View findAnchor() {
        if (ActivityUtils.getTopActivity() instanceof MainActivity) {
            return ((MainActivity) ActivityUtils.getTopActivity()).getSettingsBarFragment().getBinding().systemTimeLayout;
        }
        return null;
    }

    public void setAutoSetAdapter() {
        if (this.utilsBinding != null) {
            this.utilityAutoConfigAdapter = new UtilityAutoConfigAdapter(this.context, getAnchor());
            this.utilsBinding.utilRight.setAdapter(this.utilityAutoConfigAdapter);
            if (this.utilityAdapter != null) {
                List<MappingObject> leftMappingObjects = getLeftMappingObjects();
                int i = 0;
                for (int i2 = 0; i2 < leftMappingObjects.size(); i2++) {
                    if (leftMappingObjects.get(i2).getValue() == ServiceEnum.UtilityType.Utility_Auto_Config.value1) {
                        i = i2;
                    }
                }
                this.utilityAdapter.setSelectPosition(i);
                this.utilityAdapter.notifyDataSetChanged();
            }
        }
    }

    public void setQuickAdapter() {
        if (this.utilsBinding != null) {
            if (this.utilityQuickSettingAdapter == null) {
                this.utilityQuickSettingAdapter = new UtilityQuickSettingAdapter(this.context, findAnchor());
            }
            this.utilsBinding.utilRight.setAdapter(this.utilityQuickSettingAdapter);
            if (this.utilityAdapter != null) {
                List<MappingObject> leftMappingObjects = getLeftMappingObjects();
                int i = 0;
                for (int i2 = 0; i2 < leftMappingObjects.size(); i2++) {
                    if (leftMappingObjects.get(i2).getValue() == ServiceEnum.UtilityType.Utility_Quick_Settings.value1) {
                        i = i2;
                    }
                }
                this.utilityAdapter.setSelectPosition(i);
                this.utilityAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        OptionParam optionParam;
        super.onLocaleChanged();
        notifyLeftList();
        UtilitySetupSettingAdapter utilitySetupSettingAdapter = this.utilitySetupSettingAdapter;
        if (utilitySetupSettingAdapter != null) {
            utilitySetupSettingAdapter.updateSwitchButton();
        }
        if (this.utilityOptionAdapter == null || (optionParam = this.optionParam) == null || optionParam.getInfoList() == null) {
            return;
        }
        this.utilityOptionAdapter.setItems(Arrays.asList(this.optionParam.getInfoList()));
        this.utilityOptionAdapter.notifyDataSetChanged();
    }
}
