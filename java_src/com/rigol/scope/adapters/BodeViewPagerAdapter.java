package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BodeViewPagerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.AdapterBodeAfSeniorBinding;
import com.rigol.scope.databinding.AdapterBodeBasicSeniorBinding;
import com.rigol.scope.databinding.AdapterBodeSavingSeniorBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.bode.BodePopupWin;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.upa.UpaPopupViewConnection;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class BodeViewPagerAdapter extends MultiItemTypeAdapter<List<MappingObject>> {
    View anchor;
    BodeParam bodeParam;
    BodeafDelegate bodeafDelegate;
    BodeasicDelegate bodeasicDelegate;
    BodesavingDelegate bodesavingDelegate;

    public BodeViewPagerAdapter(Context context, List<MappingObject> list, BasePopupView basePopupView) {
        super(context, list);
        this.bodeParam = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue();
        this.bodeasicDelegate = new BodeasicDelegate(R.layout.adapter_bode_basic_senior, basePopupView, this.bodeParam);
        this.bodeafDelegate = new BodeafDelegate(R.layout.adapter_bode_af_senior, basePopupView, this.bodeParam);
        this.bodesavingDelegate = new BodesavingDelegate(R.layout.adapter_bode_saving_senior, basePopupView, this.bodeParam);
        this.delegatesManager.addDelegate(this.bodeasicDelegate).addDelegate(this.bodeafDelegate).addDelegate(this.bodesavingDelegate);
    }

    public BodeViewPagerAdapter(Context context) {
        super(context);
    }

    /* loaded from: classes.dex */
    public static class BodeasicDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnTextReset, AorBManager.OnSetTextById {
        AdapterBodeBasicSeniorBinding adapterBodeBasicSeniorBinding;
        private AorBManager aorBManager;
        BodeParam bodeParam;
        private View clickedView;
        private KeyboardPopupView keyboardPopupView;
        private List<AorBParam> list_aorbParam;
        private List<MappingObject> mappingObjects;
        private PanelKeyViewModel panelKeyViewModel;
        private PopupSpinner popupSpinner;
        BasePopupView popupView;
        private SpinnerAdapter spinnerAdapter;
        private SyncDataViewModel syncDataViewModel;

        @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
        public void onResetDefault(int i) {
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
        public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        }

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public BodeasicDelegate(int i, BasePopupView basePopupView, BodeParam bodeParam) {
            super(i);
            this.list_aorbParam = new ArrayList();
            this.bodeParam = bodeParam;
            this.popupView = basePopupView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bode_disp /* 2131362052 */:
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_bode_disp_type);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$CvVj98GOzqMHeHGfSdFqQIOsfDY
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onClick$6$BodeViewPagerAdapter$BodeasicDelegate(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$qCkiPtinMnbYG6IN5dy8_IkfgOk
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onClick$7$BodeViewPagerAdapter$BodeasicDelegate(list, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.bode_source_out /* 2131362057 */:
                    final List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_bode_source_out);
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$IvVY8J4jKUcbIeSeIjOkZHp3wu4
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onClick$2$BodeViewPagerAdapter$BodeasicDelegate(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$367nCahO50fmFqD3tw_7MgWnpFs
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onClick$3$BodeViewPagerAdapter$BodeasicDelegate(list2, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.bode_sweep_type /* 2131362060 */:
                    final List<MappingObject> list3 = ViewUtil.getList((int) R.array.msg_bode_sweep_type);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list3, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$ho4ny1y5abXpfTN4oM9e5MZ8Bnw
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                            BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onClick$4$BodeViewPagerAdapter$BodeasicDelegate(popupSpinner, spinnerAdapter, list4, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$OpNsvYVyq-xMXZYFQm2Vh8E8Ee8
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onClick$5$BodeViewPagerAdapter$BodeasicDelegate(list3, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.msg_bode_source_in /* 2131363429 */:
                    final List<MappingObject> list4 = ViewUtil.getList((int) R.array.msg_bode_source_in);
                    ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, list4, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$ucJFPqgHws3ysuPT1tpSRDMHDy8
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list5, View view2) {
                            BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onClick$0$BodeViewPagerAdapter$BodeasicDelegate(popupSpinner, spinnerAdapter, list5, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$J7uWeiusHJufMo90HZ5KtxuLVuA
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onClick$1$BodeViewPagerAdapter$BodeasicDelegate(list4, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.operate_button /* 2131363514 */:
                    BodeParam bodeParam = this.bodeParam;
                    bodeParam.saveBodeRunStopEnable(!bodeParam.getBodeRunStopEnable());
                    if (this.bodeParam.getBodeRunStopEnable()) {
                        PopupViewManager.getInstance().toggle(BodePopupWin.class);
                        return;
                    }
                    return;
                case R.id.tips_button /* 2131364092 */:
                    PopupViewManager.getInstance().get(UpaPopupViewConnection.class).show();
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ void lambda$onClick$0$BodeViewPagerAdapter$BodeasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$BodeViewPagerAdapter$BodeasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.bodeParam.saveBodeSourceIn(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$2$BodeViewPagerAdapter$BodeasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$3$BodeViewPagerAdapter$BodeasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.bodeParam.saveBodeSourceOut(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$4$BodeViewPagerAdapter$BodeasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$5$BodeViewPagerAdapter$BodeasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.bodeParam.saveBodeSweepType(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$6$BodeViewPagerAdapter$BodeasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$7$BodeViewPagerAdapter$BodeasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_BODE);
            this.bodeParam.saveBodedispType(((MappingObject) list.get(i)).getValue());
            if (((MappingObject) list.get(i)).getValue() == 0) {
                return;
            }
            WindowParam windowParam = new WindowParam();
            windowParam.setServiceID(61);
            windowParam.setType(ServiceEnum.WindowType.WIN_BODE);
            ((MainActivity) ActivityUtils.getTopActivity()).getWaveformFragment().addWindow(windowParam);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                int id = compoundButton.getId();
                if (id == R.id.bode_fir_enable) {
                    this.bodeParam.saveFirEnable(z);
                } else if (id != R.id.show_bode_switch) {
                } else {
                    if (z) {
                        WindowHolderManager.getInstance().removeAll();
                        if (this.bodeParam.getBodedispType() == 1) {
                            WindowParam windowParam = new WindowParam();
                            windowParam.setServiceID(61);
                            windowParam.setType(ServiceEnum.WindowType.WIN_BODE);
                            ((MainActivity) ActivityUtils.getTopActivity()).getWaveformFragment().addWindow(windowParam);
                        }
                    } else {
                        this.bodeParam.setBodeImpedace(false);
                        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_BODE);
                    }
                    this.bodeParam.saveBodeEnable(z);
                }
            }
        }

        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            return list.get(i).getValue() == 0;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterBodeBasicSeniorBinding adapterBodeBasicSeniorBinding = (AdapterBodeBasicSeniorBinding) baseViewHolder.getBinding();
            this.adapterBodeBasicSeniorBinding = adapterBodeBasicSeniorBinding;
            adapterBodeBasicSeniorBinding.showBodeSwitch.setOnCheckedChangeListener(this);
            this.adapterBodeBasicSeniorBinding.bodeFirEnable.setOnCheckedChangeListener(this);
            this.adapterBodeBasicSeniorBinding.operateButton.setOnClickListener(this);
            this.adapterBodeBasicSeniorBinding.msgBodeSourceIn.setOnClickListener(this);
            this.adapterBodeBasicSeniorBinding.bodeSourceOut.setOnClickListener(this);
            this.adapterBodeBasicSeniorBinding.bodeSweepType.setOnClickListener(this);
            this.adapterBodeBasicSeniorBinding.bodeDisp.setOnClickListener(this);
            this.adapterBodeBasicSeniorBinding.tipsButton.setOnClickListener(this);
            ViewUtil.setSwitchButton(this.adapterBodeBasicSeniorBinding.showBodeSwitch);
            ViewUtil.setSwitchButton(R.array.msg_bode_impedance, this.adapterBodeBasicSeniorBinding.bodeImpedance);
            ViewUtil.setSwitchButton(this.adapterBodeBasicSeniorBinding.bodeFirEnable);
            this.adapterBodeBasicSeniorBinding.setParma(this.bodeParam);
            this.list_aorbParam.add(new AorBParam(this.adapterBodeBasicSeniorBinding.msgBodeSourceIn, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeBasicSeniorBinding.bodeSweepType, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeBasicSeniorBinding.bodeDisp, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeBasicSeniorBinding.bodeSourceOut, 0, true, ViewUtil.KEY_A, 2));
            this.aorBManager = new AorBManager(this.popupView.getAnchor().getContext(), this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeasicDelegate.1
                @Override // com.rigol.scope.utilities.AorBManager
                protected void setSwitch_num(int i2) {
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setrecovery_num(int i2) {
                }

                {
                    BodeasicDelegate.this = this;
                }
            };
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            this.syncDataViewModel = syncDataViewModel;
            syncDataViewModel.get(61, MessageID.MSG_BODE_DISP_TYPE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$4-WmpTGaDtfftfNmPD28OtTOYuY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onBindViewHolder$8$BodeViewPagerAdapter$BodeasicDelegate(obj);
                }
            });
            PanelKeyViewModel panelKeyViewModel = this.panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$7AiWeqlBWRKwt9j7Djgu4hwm-x0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onBindViewHolder$11$BodeViewPagerAdapter$BodeasicDelegate((KeyEvent) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$8$BodeViewPagerAdapter$BodeasicDelegate(Object obj) {
            this.bodeParam.setBodeEnable1(false);
        }

        public /* synthetic */ void lambda$onBindViewHolder$11$BodeViewPagerAdapter$BodeasicDelegate(KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(BodePopupWin.class)) {
                this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$4Ug3Ljge0wqVo37F6vus7pkCONM
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onBindViewHolder$9$BodeViewPagerAdapter$BodeasicDelegate(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeasicDelegate$LvSmUr7hb2IF55Pi03gJl6fRf58
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        BodeViewPagerAdapter.BodeasicDelegate.this.lambda$onBindViewHolder$10$BodeViewPagerAdapter$BodeasicDelegate(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$9$BodeViewPagerAdapter$BodeasicDelegate(KeyboardPopupView keyboardPopupView) {
            this.keyboardPopupView = keyboardPopupView;
        }

        public /* synthetic */ void lambda$onBindViewHolder$10$BodeViewPagerAdapter$BodeasicDelegate(int i, MappingObject mappingObject) {
            if (this.clickedView.getId() == R.id.bode_disp) {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_BODE);
                this.bodeParam.saveBodedispType(mappingObject.getValue());
                if (mappingObject.getValue() == 0) {
                    return;
                }
                WindowParam windowParam = new WindowParam();
                windowParam.setServiceID(61);
                windowParam.setType(ServiceEnum.WindowType.WIN_BODE);
                ((MainActivity) ActivityUtils.getTopActivity()).getWaveformFragment().addWindow(windowParam);
            } else if (this.clickedView.getId() == R.id.bode_sweep_type) {
                this.bodeParam.saveBodeSweepType(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.bode_source_out) {
                this.bodeParam.saveBodeSourceOut(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.msg_bode_source_in) {
                this.bodeParam.saveBodeSourceIn(mappingObject.getValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BodeafDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnTextReset, AorBManager.OnSetTextById {
        AdapterBodeAfSeniorBinding adapterBodeAfSeniorBinding;
        private AorBManager aorBManager;
        BodeParam bodeParam;
        private View clickedView;
        private KeyboardPopupView keyboardPopupView;
        private List<AorBParam> list_aorbParam;
        private List<MappingObject> mappingObjects;
        private PanelKeyViewModel panelKeyViewModel;
        private PopupSpinner popupSpinner;
        BasePopupView popupView;
        private SpinnerAdapter spinnerAdapter;

        static /* synthetic */ void lambda$onBindViewHolder$1(int i, MappingObject mappingObject) {
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
        public void onResetDefault(int i) {
        }

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public BodeafDelegate(int i, BasePopupView basePopupView, BodeParam bodeParam) {
            super(i);
            this.list_aorbParam = new ArrayList();
            this.bodeParam = bodeParam;
            this.popupView = basePopupView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bode_ampout /* 2131362043 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodeAmpoutAttr().getMaxLongValue(), this.bodeParam.getBodeAmpoutAttr().getMinLongValue(), this.bodeParam.getBodeAmpoutAttr().getDefLongValue(), this.bodeParam.getBodeAmpout(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.4
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodeAmpout(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_bodevaramp1 /* 2131362044 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodevaramp1Attr().getMaxLongValue(), this.bodeParam.getBodevaramp1Attr().getMinLongValue(), this.bodeParam.getBodevaramp1Attr().getDefLongValue(), this.bodeParam.getBodevaramp1(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.5
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodevaramp1(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_bodevaramp2 /* 2131362045 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodevaramp2Attr().getMaxLongValue(), this.bodeParam.getBodevaramp2Attr().getMinLongValue(), this.bodeParam.getBodevaramp2Attr().getDefLongValue(), this.bodeParam.getBodevaramp2(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.6
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodevaramp2(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_bodevaramp3 /* 2131362046 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodevaramp3Attr().getMaxLongValue(), this.bodeParam.getBodevaramp3Attr().getMinLongValue(), this.bodeParam.getBodevaramp3Attr().getDefLongValue(), this.bodeParam.getBodevaramp3(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.7
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodevaramp3(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_bodevaramp4 /* 2131362047 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodevaramp4Attr().getMaxLongValue(), this.bodeParam.getBodevaramp4Attr().getMinLongValue(), this.bodeParam.getBodevaramp4Attr().getDefLongValue(), this.bodeParam.getBodevaramp4(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.8
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodevaramp4(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_bodevaramp5 /* 2131362048 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodevaramp5Attr().getMaxLongValue(), this.bodeParam.getBodevaramp5Attr().getMinLongValue(), this.bodeParam.getBodevaramp5Attr().getDefLongValue(), this.bodeParam.getBodevaramp5(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.9
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodevaramp5(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_bodevaramp6 /* 2131362049 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodevaramp6Attr().getMaxLongValue(), this.bodeParam.getBodevaramp6Attr().getMinLongValue(), this.bodeParam.getBodevaramp6Attr().getDefLongValue(), this.bodeParam.getBodevaramp6(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.10
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodevaramp6(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_bodevaramp7 /* 2131362050 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodevaramp7Attr().getMaxLongValue(), this.bodeParam.getBodevaramp7Attr().getMinLongValue(), this.bodeParam.getBodevaramp7Attr().getDefLongValue(), this.bodeParam.getBodevaramp7(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.11
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodevaramp7(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_bodevaramp8 /* 2131362051 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_V, this.bodeParam.getBodevaramp8Attr().getMaxLongValue(), this.bodeParam.getBodevaramp8Attr().getMinLongValue(), this.bodeParam.getBodevaramp8Attr().getDefLongValue(), this.bodeParam.getBodevaramp8(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.12
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodevaramp8(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_disp /* 2131362052 */:
                case R.id.bode_fir_enable /* 2131362053 */:
                case R.id.bode_impedance /* 2131362054 */:
                case R.id.bode_list /* 2131362055 */:
                case R.id.bode_source_out /* 2131362057 */:
                default:
                    return;
                case R.id.bode_point_num /* 2131362056 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_none, this.bodeParam.getBodePointNumAttr().getMaxLongValue(), this.bodeParam.getBodePointNumAttr().getMinLongValue(), this.bodeParam.getBodePointNumAttr().getDefLongValue(), this.bodeParam.getBodePointNum(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.2
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodePointNum(Integer.parseInt(t.toString()));
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_start_freq /* 2131362058 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_hz, this.bodeParam.getBodeStartFreqAttr().getMaxLongValue(), this.bodeParam.getBodeStartFreqAttr().getMinLongValue(), this.bodeParam.getBodeStartFreqAttr().getDefLongValue(), this.bodeParam.getBodeStartFreq(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.1
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodeStartFreq(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
                case R.id.bode_stop_freq /* 2131362059 */:
                    if (this.aorBManager.setClick_showab_textview(view.getId())) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_hz, this.bodeParam.getBodeStopFreqAttr().getMaxLongValue(), this.bodeParam.getBodeStopFreqAttr().getMinLongValue(), this.bodeParam.getBodeStopFreqAttr().getDefLongValue(), this.bodeParam.getBodeStopFreq(), new KeyboardListener() { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.3
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                            }

                            {
                                BodeafDelegate.this = this;
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                BodeafDelegate.this.bodeParam.saveBodeStopFreq(((Long) t).longValue());
                            }
                        });
                        return;
                    }
                    return;
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                this.bodeParam.saveBodeVaramp(z);
            }
        }

        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            return list.get(i).getValue() == 1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterBodeAfSeniorBinding adapterBodeAfSeniorBinding = (AdapterBodeAfSeniorBinding) baseViewHolder.getBinding();
            this.adapterBodeAfSeniorBinding = adapterBodeAfSeniorBinding;
            adapterBodeAfSeniorBinding.setParam(this.bodeParam);
            ViewUtil.setSwitchButton(this.adapterBodeAfSeniorBinding.bodeVaramp);
            this.adapterBodeAfSeniorBinding.bodeVaramp.setOnCheckedChangeListener(this);
            this.adapterBodeAfSeniorBinding.bodeStartFreq.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodePointNum.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeStopFreq.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeAmpout.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeBodevaramp1.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeBodevaramp2.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeBodevaramp3.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeBodevaramp4.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeBodevaramp5.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeBodevaramp6.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeBodevaramp7.setOnClickListener(this);
            this.adapterBodeAfSeniorBinding.bodeBodevaramp8.setOnClickListener(this);
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeStartFreq, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodePointNum, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeStopFreq, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeAmpout, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeBodevaramp1, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeBodevaramp2, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeBodevaramp3, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeBodevaramp4, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeBodevaramp5, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeBodevaramp6, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeBodevaramp7, 0, true, ViewUtil.KEY_A, 0));
            this.list_aorbParam.add(new AorBParam(this.adapterBodeAfSeniorBinding.bodeBodevaramp8, 0, true, ViewUtil.KEY_A, 0));
            AorBManager aorBManager = new AorBManager(this.popupView.getAnchor().getContext(), this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.BodeViewPagerAdapter.BodeafDelegate.13
                {
                    BodeafDelegate.this = this;
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setSwitch_num(int i2) {
                    showKey(BodeafDelegate.this.popupView.getAnchor().getContext(), ((AorBParam) BodeafDelegate.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) BodeafDelegate.this.list_aorbParam.get(i2)).getAorb());
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setrecovery_num(int i2) {
                    showKey(BodeafDelegate.this.popupView.getAnchor().getContext(), ((AorBParam) BodeafDelegate.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) BodeafDelegate.this.list_aorbParam.get(i2)).getAorb());
                }
            };
            this.aorBManager = aorBManager;
            aorBManager.showKey(this.popupView.getAnchor().getContext(), this.adapterBodeAfSeniorBinding.bodeStartFreq, true, ViewUtil.KEY_A);
            this.aorBManager.showKey(this.popupView.getAnchor().getContext(), this.adapterBodeAfSeniorBinding.bodePointNum, true, ViewUtil.KEY_B);
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeafDelegate$9xe3vZFZQQAisHJ1ljMuQ3A9eBs
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BodeViewPagerAdapter.BodeafDelegate.this.lambda$onBindViewHolder$2$BodeViewPagerAdapter$BodeafDelegate((KeyEvent) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$2$BodeViewPagerAdapter$BodeafDelegate(KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(BodePopupWin.class)) {
                this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeafDelegate$fsKGVgzOZipwiV3krOGOlNPfeys
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        BodeViewPagerAdapter.BodeafDelegate.this.lambda$onBindViewHolder$0$BodeViewPagerAdapter$BodeafDelegate(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodeafDelegate$XxJ4FYkVRB8XMjBKvYjZPyeTsrY
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        BodeViewPagerAdapter.BodeafDelegate.lambda$onBindViewHolder$1(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$BodeViewPagerAdapter$BodeafDelegate(KeyboardPopupView keyboardPopupView) {
            this.keyboardPopupView = keyboardPopupView;
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
        public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
            if (this.bodeParam.getBodeEnable()) {
                switch (i) {
                    case R.id.bode_ampout /* 2131362043 */:
                        BodeParam bodeParam = this.bodeParam;
                        bodeParam.saveBodeAmpout(bodeParam.getLongStep(bodeParam.getBodeAmpout(), this.bodeParam.getBodeAmpoutAttr(), z, keyEvent));
                        return;
                    case R.id.bode_bodevaramp1 /* 2131362044 */:
                        if (this.bodeParam.getBodeVaramp()) {
                            BodeParam bodeParam2 = this.bodeParam;
                            bodeParam2.saveBodevaramp1(bodeParam2.getLongStep(bodeParam2.getBodevaramp1(), this.bodeParam.getBodevaramp1Attr(), z, keyEvent));
                            return;
                        }
                        return;
                    case R.id.bode_bodevaramp2 /* 2131362045 */:
                        if (this.bodeParam.getBodeVaramp()) {
                            BodeParam bodeParam3 = this.bodeParam;
                            bodeParam3.saveBodevaramp2(bodeParam3.getLongStep(bodeParam3.getBodevaramp2(), this.bodeParam.getBodevaramp1Attr(), z, keyEvent));
                            return;
                        }
                        return;
                    case R.id.bode_bodevaramp3 /* 2131362046 */:
                        if (this.bodeParam.getBodeVaramp()) {
                            BodeParam bodeParam4 = this.bodeParam;
                            bodeParam4.saveBodevaramp3(bodeParam4.getLongStep(bodeParam4.getBodevaramp3(), this.bodeParam.getBodevaramp1Attr(), z, keyEvent));
                            return;
                        }
                        return;
                    case R.id.bode_bodevaramp4 /* 2131362047 */:
                        if (this.bodeParam.getBodeVaramp()) {
                            BodeParam bodeParam5 = this.bodeParam;
                            bodeParam5.saveBodevaramp4(bodeParam5.getLongStep(bodeParam5.getBodevaramp4(), this.bodeParam.getBodevaramp1Attr(), z, keyEvent));
                            return;
                        }
                        return;
                    case R.id.bode_bodevaramp5 /* 2131362048 */:
                        if (this.bodeParam.getBodeVaramp()) {
                            BodeParam bodeParam6 = this.bodeParam;
                            bodeParam6.saveBodevaramp5(bodeParam6.getLongStep(bodeParam6.getBodevaramp5(), this.bodeParam.getBodevaramp1Attr(), z, keyEvent));
                            return;
                        }
                        return;
                    case R.id.bode_bodevaramp6 /* 2131362049 */:
                        if (this.bodeParam.getBodeVaramp()) {
                            BodeParam bodeParam7 = this.bodeParam;
                            bodeParam7.saveBodevaramp6(bodeParam7.getLongStep(bodeParam7.getBodevaramp6(), this.bodeParam.getBodevaramp1Attr(), z, keyEvent));
                            return;
                        }
                        return;
                    case R.id.bode_bodevaramp7 /* 2131362050 */:
                        if (this.bodeParam.getBodeVaramp()) {
                            BodeParam bodeParam8 = this.bodeParam;
                            bodeParam8.saveBodevaramp7(bodeParam8.getLongStep(bodeParam8.getBodevaramp7(), this.bodeParam.getBodevaramp1Attr(), z, keyEvent));
                            return;
                        }
                        return;
                    case R.id.bode_bodevaramp8 /* 2131362051 */:
                        if (this.bodeParam.getBodeVaramp()) {
                            BodeParam bodeParam9 = this.bodeParam;
                            bodeParam9.saveBodevaramp8(bodeParam9.getLongStep(bodeParam9.getBodevaramp8(), this.bodeParam.getBodevaramp1Attr(), z, keyEvent));
                            return;
                        }
                        return;
                    case R.id.bode_disp /* 2131362052 */:
                    case R.id.bode_fir_enable /* 2131362053 */:
                    case R.id.bode_impedance /* 2131362054 */:
                    case R.id.bode_list /* 2131362055 */:
                    case R.id.bode_source_out /* 2131362057 */:
                    default:
                        return;
                    case R.id.bode_point_num /* 2131362056 */:
                        BodeParam bodeParam10 = this.bodeParam;
                        bodeParam10.saveBodePointNum(bodeParam10.getIntStep(bodeParam10.getBodePointNum(), this.bodeParam.getBodePointNumAttr(), z, keyEvent));
                        return;
                    case R.id.bode_start_freq /* 2131362058 */:
                        BodeParam bodeParam11 = this.bodeParam;
                        bodeParam11.saveBodeStartFreq(bodeParam11.getLongStep(bodeParam11.getBodeStartFreq(), this.bodeParam.getBodeStartFreqAttr(), z, keyEvent));
                        return;
                    case R.id.bode_stop_freq /* 2131362059 */:
                        BodeParam bodeParam12 = this.bodeParam;
                        bodeParam12.saveBodeStopFreq(bodeParam12.getLongStep(bodeParam12.getBodeStopFreq(), this.bodeParam.getBodeStopFreqAttr(), z, keyEvent));
                        return;
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class BodesavingDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
        AdapterBodeSavingSeniorBinding adapterBodeSavingSeniorBinding;
        private BodeParam bodeParam;
        List<MappingObject> fileTypeMappings;
        List<MappingObject> loadfileTypeMappings;
        private StorageSaveParam param;
        BasePopupView popupView;
        private StorageLoadParam storagelParam;

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        }

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public BodesavingDelegate(int i, BasePopupView basePopupView, BodeParam bodeParam) {
            super(i);
            this.fileTypeMappings = new ArrayList();
            this.loadfileTypeMappings = new ArrayList();
            this.popupView = basePopupView;
            this.bodeParam = bodeParam;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.file_format_spinner /* 2131362943 */:
                    if (this.fileTypeMappings != null) {
                        ViewUtil.showSpinner(this.popupView.getAnchor(), view, this.fileTypeMappings, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodesavingDelegate$KAOM7rOXGxhTMPtXPQbL4J6_QRs
                            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                                BodeViewPagerAdapter.BodesavingDelegate.this.lambda$onClick$0$BodeViewPagerAdapter$BodesavingDelegate(view2, viewHolder, i, (MappingObject) obj);
                            }
                        });
                        return;
                    }
                    return;
                case R.id.file_name_text /* 2131362946 */:
                    Context context = this.popupView.getContentView().getContext();
                    View anchor = this.popupView.getAnchor();
                    String prefix = this.param.getPrefix();
                    final StorageSaveParam storageSaveParam = this.param;
                    Objects.requireNonNull(storageSaveParam);
                    ViewUtil.showSavePinyinKeyboard(context, anchor, view, true, prefix, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$i9NRwQVRXRz5denMFitBirafr2w
                        @Override // com.rigol.pinyinkeyboard.ExternalInterface
                        public final void resultShow(String str) {
                            StorageSaveParam.this.savePrefix(str);
                        }
                    }, 17, 0, 0);
                    return;
                case R.id.file_path_text /* 2131362948 */:
                    final ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(this.param.getFileType());
                    FileFilter fileFilter = enfiletype != null ? new FileFilter() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodesavingDelegate$mXJBEOtA6AG9Q9tVOTMJqq7-ijo
                        @Override // java.io.FileFilter
                        public final boolean accept(File file) {
                            return BodeViewPagerAdapter.BodesavingDelegate.lambda$onClick$1(ServiceEnum.enFileType.this, file);
                        }
                    } : null;
                    String pathName = this.param.getPathName();
                    DiskManageParam.SelectionMode selectionMode = DiskManageParam.SelectionMode.FILE;
                    final StorageSaveParam storageSaveParam2 = this.param;
                    Objects.requireNonNull(storageSaveParam2);
                    ViewUtil.showDiskManage(pathName, selectionMode, fileFilter, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.adapters.-$$Lambda$FtnkS5Qj29C5AJZD93PQtkUcPos
                        @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                        public final void onFolderSelected(String str) {
                            StorageSaveParam.this.savePathName(str);
                        }
                    });
                    return;
                case R.id.load_btn /* 2131363329 */:
                    StorageLoadParam storageLoadParam = this.storagelParam;
                    storageLoadParam.saveFileType(storageLoadParam.getBodeFileType());
                    this.storagelParam.loadBode();
                    this.storagelParam.doLoad();
                    return;
                case R.id.path_name_edit_load /* 2131363552 */:
                    final ServiceEnum.enFileType enfiletype2 = ServiceEnum.getenFileTypeFromValue1(this.storagelParam.getFileType());
                    if (enfiletype2 != null) {
                        new FileFilter() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodesavingDelegate$JKtKC5v6ExqQ_MbArvTBPaGuO38
                            @Override // java.io.FileFilter
                            public final boolean accept(File file) {
                                return BodeViewPagerAdapter.BodesavingDelegate.lambda$onClick$3(ServiceEnum.enFileType.this, file);
                            }
                        };
                    }
                    String pathName2 = this.storagelParam.getPathName();
                    DiskManageParam.SelectionMode selectionMode2 = DiskManageParam.SelectionMode.FILE;
                    final StorageLoadParam storageLoadParam2 = this.storagelParam;
                    Objects.requireNonNull(storageLoadParam2);
                    ViewUtil.showDiskManage(pathName2, selectionMode2, null, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.adapters.-$$Lambda$gdWAoUf1TpGS31Lcs9y1uuv3718
                        @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                        public final void onFolderSelected(String str) {
                            StorageLoadParam.this.savePathName(str);
                        }
                    });
                    return;
                case R.id.save_btn /* 2131363789 */:
                    StorageSaveParam storageSaveParam3 = this.param;
                    storageSaveParam3.saveFileType(storageSaveParam3.getBodeFileType());
                    this.param.saveBODE();
                    this.param.doSave();
                    return;
                case R.id.wave_file_format_spinner /* 2131364627 */:
                    if (this.loadfileTypeMappings != null) {
                        ViewUtil.showSpinner(this.popupView.getAnchor(), view, this.loadfileTypeMappings, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$BodeViewPagerAdapter$BodesavingDelegate$_d9sGluG0AHVyyZ4SvCvY7aH7_M
                            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                                BodeViewPagerAdapter.BodesavingDelegate.this.lambda$onClick$2$BodeViewPagerAdapter$BodesavingDelegate(view2, viewHolder, i, (MappingObject) obj);
                            }
                        });
                        return;
                    }
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ void lambda$onClick$0$BodeViewPagerAdapter$BodesavingDelegate(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(mappingObject.getValue());
            if (enfiletype != null) {
                this.param.saveFileType(enfiletype.value1);
                this.param.setBodeFileType(enfiletype.value1);
            }
        }

        static /* synthetic */ boolean lambda$onClick$1(ServiceEnum.enFileType enfiletype, File file) {
            if (file != null) {
                String path = file.getPath();
                if (path.endsWith("." + enfiletype.value2) || file.isDirectory()) {
                    return true;
                }
            }
            return false;
        }

        public /* synthetic */ void lambda$onClick$2$BodeViewPagerAdapter$BodesavingDelegate(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(mappingObject.getValue());
            if (enfiletype != null) {
                this.storagelParam.saveFileType(enfiletype.value1);
            }
        }

        static /* synthetic */ boolean lambda$onClick$3(ServiceEnum.enFileType enfiletype, File file) {
            if (file != null) {
                String path = file.getPath();
                if (path.endsWith("." + enfiletype.value2) || file.isDirectory()) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            return list.get(i).getValue() == 2;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterBodeSavingSeniorBinding adapterBodeSavingSeniorBinding = (AdapterBodeSavingSeniorBinding) baseViewHolder.getBinding();
            this.adapterBodeSavingSeniorBinding = adapterBodeSavingSeniorBinding;
            adapterBodeSavingSeniorBinding.fileFormatSpinner.setOnClickListener(this);
            this.adapterBodeSavingSeniorBinding.fileNameText.setOnClickListener(this);
            this.adapterBodeSavingSeniorBinding.filePathText.setOnClickListener(this);
            this.adapterBodeSavingSeniorBinding.saveBtn.setOnClickListener(this);
            this.adapterBodeSavingSeniorBinding.waveFileFormatSpinner.setOnClickListener(this);
            this.adapterBodeSavingSeniorBinding.pathNameEditLoad.setOnClickListener(this);
            this.adapterBodeSavingSeniorBinding.loadBtn.setOnClickListener(this);
            List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_storage_filetype);
            this.fileTypeMappings.add(list2.get(7));
            this.fileTypeMappings.add(list2.get(18));
            this.loadfileTypeMappings.add(list2.get(7));
            this.param = ((StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class)).getSaveLiveData().getValue();
            this.storagelParam = ((StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class)).getLoadLiveData().getValue();
            ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(this.fileTypeMappings.get(0).getValue());
            this.param.setBodeFileType(enfiletype.value1);
            this.storagelParam.saveFileType(enfiletype.value1);
            this.adapterBodeSavingSeniorBinding.setParam(this.param);
            this.adapterBodeSavingSeniorBinding.setStorageParam(this.storagelParam);
            this.adapterBodeSavingSeniorBinding.setBodeParam(this.bodeParam);
        }
    }
}
