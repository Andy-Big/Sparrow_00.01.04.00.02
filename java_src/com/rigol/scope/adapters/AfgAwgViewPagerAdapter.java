package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.AfgAwgViewPagerAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AfgParam;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.databinding.AdapterAfgBinding;
import com.rigol.scope.databinding.AdapterAwgBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.AfgViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.afgawg.AfwAwgPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class AfgAwgViewPagerAdapter extends MultiItemTypeAdapter<List<MappingObject>> {
    public AfgBasicDelegate afgBasicDelegate;
    public AfgParam afgParam;
    AfgViewModel afgViewModel;
    public AwgBasicDelegate awgBasicDelegate;

    public AfgAwgViewPagerAdapter(Context context, List<MappingObject> list, final BasePopupView basePopupView) {
        super(context, list);
        AfgViewModel afgViewModel = (AfgViewModel) ContextUtil.getAppViewModel(AfgViewModel.class);
        this.afgViewModel = afgViewModel;
        if (afgViewModel != null) {
            afgViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$8MWBEVJRob1ECYtXrml2blSV6k0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AfgAwgViewPagerAdapter.this.lambda$new$0$AfgAwgViewPagerAdapter(basePopupView, (AfgParam) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$AfgAwgViewPagerAdapter(BasePopupView basePopupView, AfgParam afgParam) {
        this.afgParam = afgParam;
        this.afgBasicDelegate = new AfgBasicDelegate(R.layout.adapter_afg, basePopupView, afgParam);
        this.awgBasicDelegate = new AwgBasicDelegate(R.layout.adapter_awg, basePopupView, afgParam);
        this.delegatesManager.addDelegate(this.afgBasicDelegate).addDelegate(this.awgBasicDelegate);
    }

    /* loaded from: classes.dex */
    public static class AfgBasicDelegate extends BaseAdapterDelegate<List<MappingObject>> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
        AdapterAfgBinding adapterAfgBinding;
        public AfgParam afgParam;
        private AorBManager aorBManager;
        private View clickedView;
        private boolean isMove;
        private KeyboardPopupView keyboardPopupView;
        private List<AorBParam> list_aorbParam;
        private List<MappingObject> mappingObjects;
        private PanelKeyViewModel panelKeyViewModel;
        private PopupSpinner popupSpinner;
        BasePopupView popupView;
        private SpinnerAdapter spinnerAdapter;
        private StorageLoadParam storageLoadParam;
        private SyncDataViewModel syncDataViewModel;

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public AfgBasicDelegate(int i, BasePopupView basePopupView, AfgParam afgParam) {
            super(i);
            this.list_aorbParam = new ArrayList();
            this.popupView = basePopupView;
            this.afgParam = afgParam;
        }

        private static long formatNumber(long j) {
            int length = Long.toString(j).length();
            if (length <= 6) {
                return j;
            }
            int i = length;
            while (i > 6) {
                i -= 3;
            }
            long pow = (long) Math.pow(10.0d, length - i);
            return (j / pow) * pow;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.basic_amp_edit /* 2131362013 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.afgParam.getBasic_amp_freqAttr().getMaxLongValue(), this.afgParam.getBasic_amp_freqAttr().getMinLongValue(), this.afgParam.getBasic_amp_freqAttr().getDefLongValue(), this.afgParam.getBasic_amp(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.4
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveBasicamp(Long.parseLong(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.basic_deviation_edit /* 2131362017 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.afgParam.getBasic_offsetAttr().getMaxLongValue(), this.afgParam.getBasic_offsetAttr().getMinLongValue(), this.afgParam.getBasic_offsetAttr().getDefLongValue(), this.afgParam.getBasic_offset(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.8
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveOffset(Long.parseLong(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.basic_dutycycle_edit /* 2131362019 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_percent, this.afgParam.getBasic_pul_dutyAttr().getMaxLongValue() / 1000, this.afgParam.getBasic_pul_dutyAttr().getMinLongValue() / 1000, this.afgParam.getBasic_pul_dutyAttr().getDefLongValue() / 1000, this.afgParam.getBasic_pul_duty(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.5
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveBasicSquDuty(Integer.parseInt(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.basic_path_edit /* 2131362021 */:
                    $$Lambda$AfgAwgViewPagerAdapter$AfgBasicDelegate$iwT9YBMzlIDG_9RsnspMethBUQ __lambda_afgawgviewpageradapter_afgbasicdelegate_iwt9ybmzlidg_9rsnspmethbuq = new FileFilter() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AfgBasicDelegate$iwT9-YBMzlIDG_9RsnspMethBUQ
                        @Override // java.io.FileFilter
                        public final boolean accept(File file) {
                            return AfgAwgViewPagerAdapter.AfgBasicDelegate.lambda$onClick$2(file);
                        }
                    };
                    String wave_path = this.afgParam.getWave_path();
                    DiskManageParam.SelectionMode selectionMode = DiskManageParam.SelectionMode.FILE;
                    final AfgParam afgParam = this.afgParam;
                    Objects.requireNonNull(afgParam);
                    ViewUtil.showDiskManage(wave_path, selectionMode, __lambda_afgawgviewpageradapter_afgbasicdelegate_iwt9ybmzlidg_9rsnspmethbuq, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.adapters.-$$Lambda$IbyYdxCuyFHA9FwCFJ1e9VUUieI
                        @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                        public final void onFolderSelected(String str) {
                            AfgParam.this.saveWavePath(str);
                        }
                    });
                    return;
                case R.id.basic_phase_edit /* 2131362022 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_degree, this.afgParam.getBasic_phaseAttr().getMaxLongValue(), this.afgParam.getBasic_phaseAttr().getMinLongValue(), this.afgParam.getBasic_phaseAttr().getDefLongValue(), this.afgParam.getBasic_phase(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.7
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveBasicPhase(Integer.parseInt(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.basic_symmetry_edit /* 2131362025 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_percent, this.afgParam.getBasic_SYMMAttr().getMaxLongValue() / 1000, this.afgParam.getBasic_SYMMAttr().getMinLongValue() / 1000, this.afgParam.getBasic_SYMMAttr().getDefLongValue() / 1000, this.afgParam.getBasic_SYMM(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.6
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveBasicSymm(Integer.parseInt(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.basic_width_edit /* 2131362027 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_percent, this.afgParam.getBasic_pul_dutyAttr().getMaxLongValue() / 1000, this.afgParam.getBasic_pul_dutyAttr().getMinLongValue() / 1000, this.afgParam.getBasic_pul_dutyAttr().getDefLongValue() / 1000, this.afgParam.getBasic_pul_duty(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.9
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveBasicPulDuty(Integer.parseInt(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.label_decline_text /* 2131363267 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.afgParam.getBasic_falledgeAttr().getMaxLongValue(), this.afgParam.getBasic_falledgeAttr().getMinLongValue(), this.afgParam.getBasic_falledgeAttr().getDefLongValue(), this.afgParam.getBasic_falledge(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.3
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveBasicFalledge(Long.parseLong(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.label_edit_text /* 2131363268 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        this.afgParam.readBasicFreqAttr();
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, this.afgParam.getAfgFreqUnit(), this.afgParam.getBasic_freqAttr().getMaxLongValue(), this.afgParam.getBasic_freqAttr().getMinLongValue(), this.afgParam.getBasic_freqAttr().getDefLongValue(), this.afgParam.getBasic_freq(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.1
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveBasicFreq(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.label_riseedge_text /* 2131363269 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_s, this.afgParam.getBasic_riseedgeAttr().getMaxLongValue(), this.afgParam.getBasic_riseedgeAttr().getMinLongValue(), this.afgParam.getBasic_riseedgeAttr().getDefLongValue(), this.afgParam.getBasic_riseedge(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.2
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AfgBasicDelegate.this.afgParam.saveBasicRiseedge(Long.parseLong(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.load_btn /* 2131363329 */:
                    this.storageLoadParam.setPathName(this.afgParam.getWave_path());
                    this.storageLoadParam.loadAfg();
                    this.storageLoadParam.doLoad();
                    return;
                case R.id.source_type_spinner /* 2131363902 */:
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_afg_wave_function);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AfgBasicDelegate$yOX6eSe7tESf9hxwGLMqrC-f3IA
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            AfgAwgViewPagerAdapter.AfgBasicDelegate.this.lambda$onClick$0$AfgAwgViewPagerAdapter$AfgBasicDelegate(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AfgBasicDelegate$LVQMxhTIqkATwTNAgpmOzCdEEO8
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            AfgAwgViewPagerAdapter.AfgBasicDelegate.this.lambda$onClick$1$AfgAwgViewPagerAdapter$AfgBasicDelegate(list, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ void lambda$onClick$0$AfgAwgViewPagerAdapter$AfgBasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$AfgAwgViewPagerAdapter$AfgBasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.afgParam.saveWaveFunction(((MappingObject) list.get(i)).getValue());
            if (((MappingObject) list.get(i)).getValue() == 0 || ((MappingObject) list.get(i)).getValue() == 1 || ((MappingObject) list.get(i)).getValue() == 2 || ((MappingObject) list.get(i)).getValue() == 6) {
                this.aorBManager.set_RadioButton(1, 0);
                this.aorBManager.set_RadioButton(1, 0);
            } else if (((MappingObject) list.get(i)).getValue() == 4) {
                this.aorBManager.set_RadioButton(0, 2);
                this.aorBManager.set_RadioButton(0, 2);
            } else if (((MappingObject) list.get(i)).getValue() == 5) {
                this.aorBManager.set_RadioButton(2, 0);
                this.aorBManager.set_RadioButton(2, 0);
            }
        }

        static /* synthetic */ boolean lambda$onClick$2(File file) {
            return file.getName().endsWith(".csv") || file.isDirectory();
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                this.afgParam.saveBasicOutputEnable(z);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            return list.get(i).getValue() == 0;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterAfgBinding adapterAfgBinding = (AdapterAfgBinding) baseViewHolder.getBinding();
            this.adapterAfgBinding = adapterAfgBinding;
            adapterAfgBinding.setParam(this.afgParam);
            this.adapterAfgBinding.sourceTypeSpinner.setOnClickListener(this);
            this.storageLoadParam = ((StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class)).getLoadLiveData().getValue();
            this.adapterAfgBinding.basicAmpEdit.setOnClickListener(this);
            this.adapterAfgBinding.labelEditText.setOnClickListener(this);
            this.adapterAfgBinding.basicDeviationEdit.setOnClickListener(this);
            this.adapterAfgBinding.basicDutycycleEdit.setOnClickListener(this);
            this.adapterAfgBinding.basicPhaseEdit.setOnClickListener(this);
            this.adapterAfgBinding.basicSymmetryEdit.setOnClickListener(this);
            this.adapterAfgBinding.labelDeclineText.setOnClickListener(this);
            this.adapterAfgBinding.labelRiseedgeText.setOnClickListener(this);
            this.adapterAfgBinding.labelSwitch.setOnCheckedChangeListener(this);
            this.adapterAfgBinding.basicWidthEdit.setOnClickListener(this);
            this.adapterAfgBinding.basicPathEdit.setOnClickListener(this);
            this.adapterAfgBinding.loadBtn.setOnClickListener(this);
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.basicAmpEdit, 0, true, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.labelEditText, 0, true, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.basicDeviationEdit, 0, false, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.basicDutycycleEdit, 0, false, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.basicPhaseEdit, 0, false, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.basicSymmetryEdit, 0, false, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.labelDeclineText, 0, false, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.labelRiseedgeText, 0, false, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.basicWidthEdit, 0, false, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam(this.adapterAfgBinding.sourceTypeSpinner, 0, false, ViewUtil.KEY_A, 2));
            ViewUtil.setSwitchButton(this.adapterAfgBinding.labelSwitch);
            AorBManager aorBManager = new AorBManager(this.popupView.getAnchor().getContext(), this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AfgBasicDelegate.10
                @Override // com.rigol.scope.utilities.AorBManager
                protected void setSwitch_num(int i2) {
                    showKey(AfgBasicDelegate.this.popupView.getAnchor().getContext(), ((AorBParam) AfgBasicDelegate.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) AfgBasicDelegate.this.list_aorbParam.get(i2)).getAorb());
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setrecovery_num(int i2) {
                    showKey(AfgBasicDelegate.this.popupView.getAnchor().getContext(), ((AorBParam) AfgBasicDelegate.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) AfgBasicDelegate.this.list_aorbParam.get(i2)).getAorb());
                }
            };
            this.aorBManager = aorBManager;
            aorBManager.showKey(this.popupView.getAnchor().getContext(), (EditText) this.adapterAfgBinding.basicAmpEdit, true, ViewUtil.KEY_B);
            this.aorBManager.showKey(this.popupView.getAnchor().getContext(), (EditText) this.adapterAfgBinding.labelEditText, true, ViewUtil.KEY_A);
            this.aorBManager.set_RadioButton(1, 0);
            this.aorBManager.set_RadioButton(1, 0);
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AfgBasicDelegate$KgE4XkQ8bojLyETF94Umsfahr-k
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        AfgAwgViewPagerAdapter.AfgBasicDelegate.this.lambda$onBindViewHolder$5$AfgAwgViewPagerAdapter$AfgBasicDelegate((KeyEvent) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$5$AfgAwgViewPagerAdapter$AfgBasicDelegate(KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(AfwAwgPopupView.class)) {
                this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AfgBasicDelegate$6yFAvjRXjEfgXx4pz3Y0XTuXHWY
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        AfgAwgViewPagerAdapter.AfgBasicDelegate.this.lambda$onBindViewHolder$3$AfgAwgViewPagerAdapter$AfgBasicDelegate(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AfgBasicDelegate$nG4VHBqYwckKUKHzGsHkTkSd0H4
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        AfgAwgViewPagerAdapter.AfgBasicDelegate.this.lambda$onBindViewHolder$4$AfgAwgViewPagerAdapter$AfgBasicDelegate(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$3$AfgAwgViewPagerAdapter$AfgBasicDelegate(KeyboardPopupView keyboardPopupView) {
            this.keyboardPopupView = keyboardPopupView;
        }

        public /* synthetic */ void lambda$onBindViewHolder$4$AfgAwgViewPagerAdapter$AfgBasicDelegate(int i, MappingObject mappingObject) {
            this.afgParam.saveWaveFunction(mappingObject.getValue());
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
        public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
            if (getIsMove()) {
                switch (i) {
                    case R.id.basic_amp_edit /* 2131362013 */:
                        this.afgParam.readWaveModFmDeviationAttr();
                        AfgParam afgParam = this.afgParam;
                        afgParam.saveBasicamp(afgParam.getLongStep(afgParam.getBasic_amp(), this.afgParam.getBasic_amp_freqAttr(), z, keyEvent));
                        return;
                    case R.id.basic_deviation_edit /* 2131362017 */:
                        AfgParam afgParam2 = this.afgParam;
                        afgParam2.saveOffset(afgParam2.getLongStep(afgParam2.getBasic_offset(), this.afgParam.getBasic_offsetAttr(), z, keyEvent));
                        return;
                    case R.id.basic_dutycycle_edit /* 2131362019 */:
                        AfgParam afgParam3 = this.afgParam;
                        afgParam3.saveBasicSquDuty(afgParam3.getIntStep(afgParam3.readBasicSquDuty() * 1000, this.afgParam.getBasic_squ_dutyAttr(), z, keyEvent) / 1000);
                        return;
                    case R.id.basic_phase_edit /* 2131362022 */:
                        AfgParam afgParam4 = this.afgParam;
                        afgParam4.saveBasicPhase(afgParam4.getIntStep(afgParam4.getBasic_phase(), this.afgParam.getBasic_phaseAttr(), z, keyEvent));
                        return;
                    case R.id.basic_symmetry_edit /* 2131362025 */:
                        AfgParam afgParam5 = this.afgParam;
                        int intStep = afgParam5.getIntStep(afgParam5.getBasic_SYMM(), this.afgParam.getBasic_SYMMAttr(), z, keyEvent);
                        if (intStep <= 100) {
                            this.afgParam.saveBasicSymm(intStep);
                            return;
                        }
                        return;
                    case R.id.label_edit_text /* 2131363268 */:
                        this.afgParam.readBasicFreqAttr();
                        if (this.afgParam.getBasic_freq() <= this.afgParam.getBasic_freqAttr().getStepValue() * keyEvent.getRepeatCount() && !z) {
                            AfgParam afgParam6 = this.afgParam;
                            afgParam6.saveBasicFreq(afgParam6.getBasic_freqAttr().getStepValue());
                            return;
                        }
                        AfgParam afgParam7 = this.afgParam;
                        afgParam7.saveBasicFreq(formatNumber(afgParam7.getLongStep(afgParam7.getBasic_freq(), this.afgParam.getBasic_freqAttr(), z, keyEvent)));
                        return;
                    case R.id.phase_depth_edit /* 2131363581 */:
                        AfgParam afgParam8 = this.afgParam;
                        afgParam8.saveWaveModPmDev(afgParam8.getLongStep(afgParam8.getWave_mod_pm_dev(), this.afgParam.getAfg_mod_pm_devAtty(), z, keyEvent));
                        return;
                    case R.id.phase_edit_text /* 2131363583 */:
                        AfgParam afgParam9 = this.afgParam;
                        afgParam9.saveWaveModPmFreq(afgParam9.getLongStep(afgParam9.getWave_mod_pm_freq(), this.afgParam.getAfg_wave_pm_freqAttr(), z, keyEvent));
                        return;
                    case R.id.range_depth_edit /* 2131363681 */:
                        AfgParam afgParam10 = this.afgParam;
                        afgParam10.saveWaveModAmDepth(afgParam10.getLongStep(afgParam10.getWave_mod_am_depth(), this.afgParam.getAfg_wave_range_depthAttr(), z, keyEvent));
                        return;
                    case R.id.range_edit_text /* 2131363683 */:
                        AfgParam afgParam11 = this.afgParam;
                        afgParam11.saveWaveModFmFreq(afgParam11.getLongStep(afgParam11.getWave_mod_fm_freq(), this.afgParam.getAfg_wave_pm_freqAttr(), z, keyEvent));
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
        public void onResetDefault(int i) {
            if (getIsMove()) {
                switch (i) {
                    case R.id.basic_amp_edit /* 2131362013 */:
                        this.afgParam.readWaveModFmDeviationAttr();
                        AfgParam afgParam = this.afgParam;
                        afgParam.saveBasicamp(afgParam.getBasic_amp_freqAttr().getDefLongValue());
                        return;
                    case R.id.basic_deviation_edit /* 2131362017 */:
                        AfgParam afgParam2 = this.afgParam;
                        afgParam2.saveOffset(afgParam2.getBasic_offsetAttr().getDefLongValue());
                        return;
                    case R.id.basic_dutycycle_edit /* 2131362019 */:
                        AfgParam afgParam3 = this.afgParam;
                        afgParam3.saveBasicSquDuty(afgParam3.getBasic_squ_dutyAttr().getDefIntValue());
                        return;
                    case R.id.basic_phase_edit /* 2131362022 */:
                        AfgParam afgParam4 = this.afgParam;
                        afgParam4.saveBasicPhase(afgParam4.getBasic_phaseAttr().getDefIntValue());
                        return;
                    case R.id.basic_symmetry_edit /* 2131362025 */:
                        AfgParam afgParam5 = this.afgParam;
                        afgParam5.saveBasicSymm(afgParam5.getBasic_SYMMAttr().getDefIntValue() / 1000);
                        return;
                    case R.id.label_edit_text /* 2131363268 */:
                        this.afgParam.saveAttrStepPos();
                        AfgParam afgParam6 = this.afgParam;
                        afgParam6.saveBasicFreq(afgParam6.getBasic_freq());
                        return;
                    case R.id.phase_depth_edit /* 2131363581 */:
                        AfgParam afgParam7 = this.afgParam;
                        afgParam7.saveWaveModPmDev(afgParam7.getAfg_mod_pm_devAtty().getDefLongValue());
                        return;
                    case R.id.phase_edit_text /* 2131363583 */:
                        AfgParam afgParam8 = this.afgParam;
                        afgParam8.saveWaveModPmFreq(afgParam8.getAfg_wave_pm_freqAttr().getDefLongValue());
                        return;
                    case R.id.range_depth_edit /* 2131363681 */:
                        AfgParam afgParam9 = this.afgParam;
                        afgParam9.saveWaveModAmDepth(afgParam9.getAfg_wave_range_depthAttr().getDefLongValue());
                        return;
                    case R.id.range_edit_text /* 2131363683 */:
                        AfgParam afgParam10 = this.afgParam;
                        afgParam10.saveWaveModFmFreq(afgParam10.getAfg_wave_pm_freqAttr().getDefLongValue());
                        return;
                    default:
                        return;
                }
            }
        }

        public void setIsMove(boolean z) {
            this.isMove = z;
        }

        private boolean getIsMove() {
            return this.isMove;
        }
    }

    /* loaded from: classes.dex */
    public static class AwgBasicDelegate extends BaseAdapterDelegate<List<MappingObject>> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, AorBManager.OnTextReset, AorBManager.OnSetTextById {
        AdapterAwgBinding adapterAfgBinding;
        public AfgParam afgParam;
        private AorBManager aorBManager;
        private View clickedView;
        private boolean isMove;
        private KeyboardPopupView keyboardPopupView;
        private List<View> listViewText;
        private List<AorBParam> list_aorbParam;
        private List<MappingObject> mappingObjects;
        private PanelKeyViewModel panelKeyViewModel;
        private PopupSpinner popupSpinner;
        BasePopupView popupView;
        private SpinnerAdapter spinnerAdapter;
        private SyncDataViewModel syncDataViewModel;

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public AwgBasicDelegate(int i, BasePopupView basePopupView, AfgParam afgParam) {
            super(i);
            this.list_aorbParam = new ArrayList();
            this.listViewText = new ArrayList();
            this.popupView = basePopupView;
            this.afgParam = afgParam;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.basic_amp_edit /* 2131362013 */:
                    this.afgParam.readWaveModFmDeviationAttr();
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_hz, this.afgParam.getAfg_wave_fm_devAttr().getMaxLongValue(), this.afgParam.getAfg_wave_fm_devAttr().getMinLongValue(), this.afgParam.getAfg_wave_fm_devAttr().getDefLongValue(), this.afgParam.getWave_mod_fm_deviation(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AwgBasicDelegate.4
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AwgBasicDelegate.this.afgParam.saveWaveModFmDeviation(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.label_edit_text /* 2131363268 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, this.afgParam.getAfgFreqUnit(), this.afgParam.getAfg_wave_am_freqAttr().getMaxLongValue(), this.afgParam.getAfg_wave_am_freqAttr().getMinLongValue(), this.afgParam.getAfg_wave_am_freqAttr().getDefLongValue(), this.afgParam.getWave_mod_am_freq(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AwgBasicDelegate.1
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AwgBasicDelegate.this.afgParam.saveWaveModAmFreq(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.phase_depth_edit /* 2131363581 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_degree, this.afgParam.getAfg_mod_pm_devAtty().getMaxLongValue(), this.afgParam.getAfg_mod_pm_devAtty().getMinLongValue(), this.afgParam.getAfg_mod_pm_devAtty().getDefLongValue(), this.afgParam.getWave_mod_pm_dev(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AwgBasicDelegate.6
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AwgBasicDelegate.this.afgParam.saveWaveModPmDev(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.phase_edit_text /* 2131363583 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, this.afgParam.getAfgFreqUnit(), this.afgParam.getAfg_wave_pm_freqAttr().getMaxLongValue(), this.afgParam.getAfg_wave_pm_freqAttr().getMinLongValue(), this.afgParam.getAfg_wave_pm_freqAttr().getDefLongValue(), this.afgParam.getWave_mod_pm_freq(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AwgBasicDelegate.5
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AwgBasicDelegate.this.afgParam.saveWaveModPmFreq(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.range_depth_edit /* 2131363681 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_percent, this.afgParam.getAfg_wave_range_depthAttr().getMaxLongValue() / 1000, this.afgParam.getAfg_wave_range_depthAttr().getMinLongValue() / 1000, this.afgParam.getAfg_wave_range_depthAttr().getDefLongValue() / 1000, this.afgParam.getWave_mod_am_depth(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AwgBasicDelegate.2
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AwgBasicDelegate.this.afgParam.saveWaveModAmDepth(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.range_edit_text /* 2131363683 */:
                    if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, this.afgParam.getAfgFreqUnit(), this.afgParam.getAfg_wave_pm_freqAttr().getMaxLongValue(), this.afgParam.getAfg_wave_pm_freqAttr().getMinLongValue(), this.afgParam.getAfg_wave_pm_freqAttr().getDefLongValue(), this.afgParam.getWave_mod_fm_freq(), new KeyboardListener() { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AwgBasicDelegate.3
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                AwgBasicDelegate.this.afgParam.saveWaveModFmFreq(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.source_type_spinner /* 2131363902 */:
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_afg_wave_mod_type);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$Q8Cr3Onyhu_j9ZudZQpzTH23HbY
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onClick$0$AfgAwgViewPagerAdapter$AwgBasicDelegate(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$b9R2MF_UI-8Eb4hZxKImbLUV-xI
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onClick$1$AfgAwgViewPagerAdapter$AwgBasicDelegate(list, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.wave_type_spinner /* 2131364634 */:
                    final List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_afg_wave_mod_am_shape);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$THxTzyKlxTwGw3Qv2ngaeG7Ymzs
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onClick$2$AfgAwgViewPagerAdapter$AwgBasicDelegate(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$yAmhmeEEXZ0rxlrWk-k4l3jfnbQ
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onClick$3$AfgAwgViewPagerAdapter$AwgBasicDelegate(list2, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.wave_typefm_spinner /* 2131364636 */:
                    final List<MappingObject> list3 = ViewUtil.getList((int) R.array.msg_afg_wave_mod_am_shape);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list3, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$wGGq6VgIvAZQRb5nSOr1U92KvcI
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                            AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onClick$4$AfgAwgViewPagerAdapter$AwgBasicDelegate(popupSpinner, spinnerAdapter, list4, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$6skHaojyNaO-WKXgt5CYfr_suJo
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onClick$5$AfgAwgViewPagerAdapter$AwgBasicDelegate(list3, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.wave_typepm_spinner /* 2131364638 */:
                    final List<MappingObject> list4 = ViewUtil.getList((int) R.array.msg_afg_wave_mod_am_shape);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list4, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$YhHpTB5_PKDYJNDFMtavenH-P9U
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list5, View view2) {
                            AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onClick$6$AfgAwgViewPagerAdapter$AwgBasicDelegate(popupSpinner, spinnerAdapter, list5, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$t4xKYOc7tcV2J3uUfQSGj97syMo
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onClick$7$AfgAwgViewPagerAdapter$AwgBasicDelegate(list4, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ void lambda$onClick$0$AfgAwgViewPagerAdapter$AwgBasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$AfgAwgViewPagerAdapter$AwgBasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.afgParam.saveAfgWaveModType(((MappingObject) list.get(i)).getValue());
            getViewShow(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$2$AfgAwgViewPagerAdapter$AwgBasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$3$AfgAwgViewPagerAdapter$AwgBasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.afgParam.saveAfgWaveAmShape(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$4$AfgAwgViewPagerAdapter$AwgBasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$5$AfgAwgViewPagerAdapter$AwgBasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            LogUtils.e("saveAfgWaveAmShape", Integer.valueOf(((MappingObject) list.get(i)).getValue()));
            this.afgParam.saveAfgWaveFmShape(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$6$AfgAwgViewPagerAdapter$AwgBasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$7$AfgAwgViewPagerAdapter$AwgBasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            LogUtils.e("saveAfgWaveAmShape", Integer.valueOf(((MappingObject) list.get(i)).getValue()));
            this.afgParam.saveAfgWavePmShape(((MappingObject) list.get(i)).getValue());
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                this.afgParam.saveServiceOutputEnable(z);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            return list.get(i).getValue() == 1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterAwgBinding adapterAwgBinding = (AdapterAwgBinding) baseViewHolder.getBinding();
            this.adapterAfgBinding = adapterAwgBinding;
            adapterAwgBinding.labelEditText.setOnClickListener(this);
            this.adapterAfgBinding.sourceTypeSpinner.setOnClickListener(this);
            this.adapterAfgBinding.waveTypeSpinner.setOnClickListener(this);
            this.adapterAfgBinding.basicAmpEdit.setOnClickListener(this);
            this.adapterAfgBinding.rangeEditText.setOnClickListener(this);
            this.adapterAfgBinding.rangeDepthEdit.setOnClickListener(this);
            this.adapterAfgBinding.phaseEditText.setOnClickListener(this);
            this.adapterAfgBinding.phaseDepthEdit.setOnClickListener(this);
            this.adapterAfgBinding.waveTypefmSpinner.setOnClickListener(this);
            this.adapterAfgBinding.waveTypepmSpinner.setOnClickListener(this);
            this.adapterAfgBinding.labelSwitch.setOnCheckedChangeListener(this);
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.labelEditText, 0, true, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.basicAmpEdit, 0, true, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.rangeEditText, 0, true, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.rangeDepthEdit, 0, true, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.phaseEditText, 0, true, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam((EditText) this.adapterAfgBinding.phaseDepthEdit, 0, true, ViewUtil.KEY_A, 3));
            this.list_aorbParam.add(new AorBParam(this.adapterAfgBinding.waveTypefmSpinner, 0, false, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterAfgBinding.sourceTypeSpinner, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterAfgBinding.waveTypeSpinner, 0, false, ViewUtil.KEY_A, 2));
            this.listViewText.add(this.adapterAfgBinding.labelEditText);
            this.listViewText.add(this.adapterAfgBinding.basicAmpEdit);
            this.listViewText.add(this.adapterAfgBinding.rangeEditText);
            this.listViewText.add(this.adapterAfgBinding.rangeDepthEdit);
            this.listViewText.add(this.adapterAfgBinding.phaseEditText);
            this.listViewText.add(this.adapterAfgBinding.phaseDepthEdit);
            this.adapterAfgBinding.setParam(this.afgParam);
            ViewUtil.setSwitchButton(this.adapterAfgBinding.labelSwitch);
            AorBManager aorBManager = new AorBManager(this.popupView.getAnchor().getContext(), this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.AfgAwgViewPagerAdapter.AwgBasicDelegate.7
                @Override // com.rigol.scope.utilities.AorBManager
                protected void setSwitch_num(int i2) {
                    showKey(AwgBasicDelegate.this.popupView.getAnchor().getContext(), ((AorBParam) AwgBasicDelegate.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) AwgBasicDelegate.this.list_aorbParam.get(i2)).getAorb());
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setrecovery_num(int i2) {
                    showKey(AwgBasicDelegate.this.popupView.getAnchor().getContext(), ((AorBParam) AwgBasicDelegate.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) AwgBasicDelegate.this.list_aorbParam.get(i2)).getAorb());
                }
            };
            this.aorBManager = aorBManager;
            aorBManager.showKey(this.popupView.getAnchor().getContext(), (EditText) this.adapterAfgBinding.rangeDepthEdit, true, ViewUtil.KEY_A);
            this.aorBManager.showKey(this.popupView.getAnchor().getContext(), (EditText) this.adapterAfgBinding.labelEditText, true, ViewUtil.KEY_B);
            this.aorBManager.set_RadioButton(3, 0);
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$CzMtZFCZh7YLlwZgBGKgXpVZ1Qg
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onBindViewHolder$10$AfgAwgViewPagerAdapter$AwgBasicDelegate((KeyEvent) obj);
                    }
                });
            }
            getViewShow(this.afgParam.getAfg_wave_mod_type());
        }

        public /* synthetic */ void lambda$onBindViewHolder$10$AfgAwgViewPagerAdapter$AwgBasicDelegate(KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(AfwAwgPopupView.class)) {
                this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$g7Q4lcyzT4XC4S-0FwdcaH3uWkk
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onBindViewHolder$8$AfgAwgViewPagerAdapter$AwgBasicDelegate(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$AfgAwgViewPagerAdapter$AwgBasicDelegate$BkE9K_LbaluSn0NVfgO5tMLNPws
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        AfgAwgViewPagerAdapter.AwgBasicDelegate.this.lambda$onBindViewHolder$9$AfgAwgViewPagerAdapter$AwgBasicDelegate(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$8$AfgAwgViewPagerAdapter$AwgBasicDelegate(KeyboardPopupView keyboardPopupView) {
            this.keyboardPopupView = keyboardPopupView;
        }

        public /* synthetic */ void lambda$onBindViewHolder$9$AfgAwgViewPagerAdapter$AwgBasicDelegate(int i, MappingObject mappingObject) {
            this.afgParam.saveWaveFunction(mappingObject.getValue());
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
        public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
            if (getIsMove() && this.afgParam.getService_output_enable()) {
                switch (i) {
                    case R.id.basic_amp_edit /* 2131362013 */:
                        this.afgParam.readWaveModFmDeviationAttr();
                        AfgParam afgParam = this.afgParam;
                        afgParam.saveWaveModFmDeviation(afgParam.getLongStep(afgParam.getWave_mod_fm_deviation(), this.afgParam.getAfg_wave_fm_devAttr(), z, keyEvent));
                        return;
                    case R.id.label_edit_text /* 2131363268 */:
                        AfgParam afgParam2 = this.afgParam;
                        afgParam2.saveWaveModAmFreq(afgParam2.getLongStep(afgParam2.getWave_mod_am_freq(), this.afgParam.getAfg_wave_am_freqAttr(), z, keyEvent));
                        return;
                    case R.id.phase_depth_edit /* 2131363581 */:
                        AfgParam afgParam3 = this.afgParam;
                        afgParam3.saveWaveModPmDev(afgParam3.getLongStep(afgParam3.getWave_mod_pm_dev(), this.afgParam.getAfg_mod_pm_devAtty(), z, keyEvent));
                        return;
                    case R.id.phase_edit_text /* 2131363583 */:
                        AfgParam afgParam4 = this.afgParam;
                        afgParam4.saveWaveModPmFreq(afgParam4.getLongStep(afgParam4.getWave_mod_pm_freq(), this.afgParam.getAfg_wave_pm_freqAttr(), z, keyEvent));
                        return;
                    case R.id.range_depth_edit /* 2131363681 */:
                        AfgParam afgParam5 = this.afgParam;
                        afgParam5.saveWaveModAmDepth(afgParam5.getLongStep(afgParam5.getWave_mod_am_depth(), this.afgParam.getAfg_wave_range_depthAttr(), z, keyEvent));
                        return;
                    case R.id.range_edit_text /* 2131363683 */:
                        AfgParam afgParam6 = this.afgParam;
                        afgParam6.saveWaveModFmFreq(afgParam6.getLongStep(afgParam6.getWave_mod_fm_freq(), this.afgParam.getAfg_wave_pm_freqAttr(), z, keyEvent));
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
        public void onResetDefault(int i) {
            if (getIsMove() && this.afgParam.getService_output_enable()) {
                switch (i) {
                    case R.id.basic_amp_edit /* 2131362013 */:
                        this.afgParam.readWaveModFmDeviationAttr();
                        AfgParam afgParam = this.afgParam;
                        afgParam.saveWaveModFmDeviation(afgParam.getAfg_wave_fm_devAttr().getDefLongValue());
                        return;
                    case R.id.label_edit_text /* 2131363268 */:
                        AfgParam afgParam2 = this.afgParam;
                        afgParam2.saveWaveModAmFreq(afgParam2.getAfg_wave_am_freqAttr().getDefLongValue());
                        return;
                    case R.id.phase_depth_edit /* 2131363581 */:
                        AfgParam afgParam3 = this.afgParam;
                        afgParam3.saveWaveModPmDev(afgParam3.getAfg_mod_pm_devAtty().getDefLongValue());
                        return;
                    case R.id.phase_edit_text /* 2131363583 */:
                        AfgParam afgParam4 = this.afgParam;
                        afgParam4.saveWaveModPmFreq(afgParam4.getAfg_wave_pm_freqAttr().getDefLongValue());
                        return;
                    case R.id.range_depth_edit /* 2131363681 */:
                        AfgParam afgParam5 = this.afgParam;
                        afgParam5.saveWaveModAmDepth(afgParam5.getAfg_wave_range_depthAttr().getDefLongValue());
                        return;
                    case R.id.range_edit_text /* 2131363683 */:
                        AfgParam afgParam6 = this.afgParam;
                        afgParam6.saveWaveModFmFreq(afgParam6.getAfg_wave_pm_freqAttr().getDefLongValue());
                        return;
                    default:
                        return;
                }
            }
        }

        private void getViewShow(int i) {
            if (i == 0) {
                this.aorBManager.set_RadioButton(3, 0);
            } else if (i == 1) {
                this.aorBManager.set_RadioButton(1, 2);
                this.aorBManager.set_RadioButton(1, 2);
            } else {
                this.aorBManager.set_RadioButton(5, 4);
            }
        }

        public void setIsMove(boolean z) {
            this.isMove = z;
        }

        private boolean getIsMove() {
            return this.isMove;
        }
    }
}
