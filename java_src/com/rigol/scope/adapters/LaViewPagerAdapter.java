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
import com.rigol.scope.R;
import com.rigol.scope.adapters.LaViewPagerAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AbapterLaSeniorBinding;
import com.rigol.scope.databinding.AdapterLaBasicBinding;
import com.rigol.scope.databinding.AdapterLaColorBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.LaViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.la.LaCalibrationPopuView;
import com.rigol.scope.views.la.LapopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class LaViewPagerAdapter extends MultiItemTypeAdapter<List<MappingObject>> {
    View anchor;
    LaBasicDelegate laBasicDelegate;
    LaColorDelegate laColorDelegate;
    LaSeniorDelegate laSeniorDelegate;
    private LaViewModel laViewModel;

    public LaViewPagerAdapter(Context context, List<MappingObject> list, BasePopupView basePopupView) {
        super(context, list);
        this.laViewModel = (LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class);
        this.laBasicDelegate = new LaBasicDelegate(R.layout.adapter_la_basic, basePopupView, context);
        this.laColorDelegate = new LaColorDelegate(R.layout.adapter_la_color, basePopupView);
        this.laBasicDelegate.anchor = this.anchor;
        this.delegatesManager.addDelegate(this.laBasicDelegate).addDelegate(this.laColorDelegate);
    }

    /* loaded from: classes.dex */
    public static class LaBasicDelegate extends BaseAdapterDelegate<List<MappingObject>> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
        private static final long LA_THRESHOLD = 0;
        AdapterLaBasicBinding adapterLaBasicBinding;
        private View anchor;
        private AorBManager aorBManager;
        private View clickedView;
        private Context context;
        private KeyboardPopupView keyboardPopupView;
        private LaParam laParam;
        LaViewModel laViewModel;
        List<MappingObject> list;
        private List<AorBParam> list_aorbParam;
        List<MappingObject> list_clon;
        private List<MappingObject> mappingObjects;
        private PanelKeyViewModel panelKeyViewModel;
        private PopupSpinner popupSpinner;
        BasePopupView popupView;
        private SpinnerAdapter spinnerAdapter;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public LaBasicDelegate(int i, BasePopupView basePopupView, Context context) {
            super(i);
            this.list_aorbParam = new ArrayList();
            this.popupView = basePopupView;
            this.context = context;
        }

        public AorBManager getAorBManager() {
            return this.aorBManager;
        }

        public void setAorBManager(AorBManager aorBManager) {
            this.aorBManager = aorBManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            MappingObject mappingObject = list.get(i);
            return mappingObject != null && mappingObject.getValue() == 1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            LaViewModel laViewModel = (LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class);
            this.laViewModel = laViewModel;
            this.laParam = laViewModel.getLiveData().getValue();
            AdapterLaBasicBinding adapterLaBasicBinding = (AdapterLaBasicBinding) baseViewHolder.getBinding();
            this.adapterLaBasicBinding = adapterLaBasicBinding;
            adapterLaBasicBinding.setParma(this.laViewModel.getValue());
            this.adapterLaBasicBinding.setCheckedChangeListener(this);
            this.adapterLaBasicBinding.d0.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d1.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d2.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d3.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d4.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d5.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d6.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d7.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d8.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d9.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d10.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d11.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d12.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d13.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d14.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.d15.setOnCheckedChangeListener(this);
            this.adapterLaBasicBinding.laOrder.setOnClickListener(this);
            this.adapterLaBasicBinding.laWaveSpinner.setOnClickListener(this);
            this.adapterLaBasicBinding.laPeakSpinner.setOnClickListener(this);
            this.adapterLaBasicBinding.laBasic.setOnClickListener(this);
            this.adapterLaBasicBinding.laBasicTwo.setOnClickListener(this);
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaBasicDelegate$YqyBWyGjeD0Lycn4YuZMSiEdmGM
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LaViewPagerAdapter.LaBasicDelegate.this.lambda$onBindViewHolder$2$LaViewPagerAdapter$LaBasicDelegate((KeyEvent) obj);
                    }
                });
            }
            this.list_aorbParam.add(new AorBParam(this.adapterLaBasicBinding.laBasic, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterLaBasicBinding.laBasicTwo, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterLaBasicBinding.laWaveSpinner, 0, false, "", 2));
            this.list_aorbParam.add(new AorBParam(this.adapterLaBasicBinding.laPeakSpinner, 0, false, "", 2));
            AorBManager aorBManager = new AorBManager(this.popupView.getAnchor().getContext(), this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.LaViewPagerAdapter.LaBasicDelegate.1
                @Override // com.rigol.scope.utilities.AorBManager
                protected void setSwitch_num(int i2) {
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setrecovery_num(int i2) {
                }
            };
            this.aorBManager = aorBManager;
            aorBManager.showKey(this.popupView.getAnchor().getContext(), this.adapterLaBasicBinding.laBasic, true, ViewUtil.KEY_A);
            this.aorBManager.showKey(this.popupView.getAnchor().getContext(), this.adapterLaBasicBinding.laBasicTwo, true, ViewUtil.KEY_B);
        }

        public /* synthetic */ void lambda$onBindViewHolder$2$LaViewPagerAdapter$LaBasicDelegate(KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(LapopupView.class)) {
                this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaBasicDelegate$37HSD6jHFnEv53s1y16Dv_K5h-A
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        LaViewPagerAdapter.LaBasicDelegate.this.lambda$onBindViewHolder$0$LaViewPagerAdapter$LaBasicDelegate(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaBasicDelegate$pjc4z8LhANgknVL2QrNvfYrscU8
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        LaViewPagerAdapter.LaBasicDelegate.this.lambda$onBindViewHolder$1$LaViewPagerAdapter$LaBasicDelegate(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$LaViewPagerAdapter$LaBasicDelegate(KeyboardPopupView keyboardPopupView) {
            this.keyboardPopupView = keyboardPopupView;
        }

        public /* synthetic */ void lambda$onBindViewHolder$1$LaViewPagerAdapter$LaBasicDelegate(int i, MappingObject mappingObject) {
            if (this.clickedView.getId() == R.id.la_wave_spinner) {
                this.laParam.saveLaSize(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.la_peak_spinner) {
                this.laParam.saveAutoOrder(mappingObject.getValue());
            }
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                switch (compoundButton.getId()) {
                    case R.id.d0 /* 2131362349 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d0.value1);
                        return;
                    case R.id.d0tod7 /* 2131362350 */:
                        this.laViewModel.getLiveData().getValue().saveD0TOd7(z);
                        return;
                    case R.id.d1 /* 2131362351 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d1.value1);
                        return;
                    case R.id.d10 /* 2131362352 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d10.value1);
                        return;
                    case R.id.d11 /* 2131362353 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d11.value1);
                        return;
                    case R.id.d12 /* 2131362354 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d12.value1);
                        return;
                    case R.id.d13 /* 2131362355 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d13.value1);
                        return;
                    case R.id.d14 /* 2131362356 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d14.value1);
                        return;
                    case R.id.d15 /* 2131362357 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d15.value1);
                        return;
                    case R.id.d2 /* 2131362358 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d2.value1);
                        return;
                    case R.id.d3 /* 2131362359 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d3.value1);
                        return;
                    case R.id.d4 /* 2131362360 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d4.value1);
                        return;
                    case R.id.d5 /* 2131362361 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d5.value1);
                        return;
                    case R.id.d6 /* 2131362362 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d6.value1);
                        return;
                    case R.id.d7 /* 2131362363 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d7.value1);
                        return;
                    case R.id.d8 /* 2131362364 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d8.value1);
                        return;
                    case R.id.d8tod15 /* 2131362365 */:
                        this.laViewModel.getLiveData().getValue().saveD8TOd15(z);
                        return;
                    case R.id.d9 /* 2131362366 */:
                        this.laViewModel.getLiveData().getValue().saveSelectChar(ServiceEnum.Chan.d9.value1);
                        return;
                    default:
                        return;
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.la_basic /* 2131363240 */:
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, this.laViewModel.getLiveData().getValue().getUnit(), this.laViewModel.getLiveData().getValue().getD0tod7Attr().getMaxLongValue(), this.laViewModel.getLiveData().getValue().getD0tod7Attr().getMinLongValue(), this.laViewModel.getLiveData().getValue().getD0tod7Attr().getDefLongValue(), this.laViewModel.getLiveData().getValue().getD0TOd7_threshold_(), new KeyboardListener() { // from class: com.rigol.scope.adapters.LaViewPagerAdapter.LaBasicDelegate.2
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            LaBasicDelegate.this.laViewModel.getLiveData().getValue().savedD0TOd7Threshold(Long.parseLong(t.toString()));
                        }
                    });
                    return;
                case R.id.la_basic_two /* 2131363241 */:
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, this.laViewModel.getLiveData().getValue().getUnit(), this.laViewModel.getLiveData().getValue().getD8tod15Attr().getMaxLongValue(), this.laViewModel.getLiveData().getValue().getD8tod15Attr().getMinLongValue(), this.laViewModel.getLiveData().getValue().getD8tod15Attr().getDefLongValue(), this.laViewModel.getLiveData().getValue().getD8TOd15_threshold_(), new KeyboardListener() { // from class: com.rigol.scope.adapters.LaViewPagerAdapter.LaBasicDelegate.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            LaBasicDelegate.this.laViewModel.getLiveData().getValue().savedD8TOd15Threshold(Long.parseLong(t.toString()));
                        }
                    });
                    return;
                case R.id.la_order /* 2131363247 */:
                    PopupViewManager.getInstance().get(LaCalibrationPopuView.class).show();
                    return;
                case R.id.la_peak_spinner /* 2131363249 */:
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_la_auto_set);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaBasicDelegate$lV4xCEUq_hGGJXXc1XlHmqedFKI
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            LaViewPagerAdapter.LaBasicDelegate.this.lambda$onClick$5$LaViewPagerAdapter$LaBasicDelegate(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaBasicDelegate$HZX_mngcn6rQ36XmguG6QY0K4Go
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaBasicDelegate.this.lambda$onClick$6$LaViewPagerAdapter$LaBasicDelegate(list, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.la_wave_spinner /* 2131363265 */:
                    this.list = ViewUtil.getList((int) R.array.msg_la_wave_size);
                    ArrayList arrayList = new ArrayList();
                    this.list_clon = arrayList;
                    arrayList.addAll(this.list);
                    if (this.laViewModel.getLiveData().getValue().getSizeNow() && this.list.size() > 2) {
                        this.list_clon.remove(2);
                    } else {
                        this.list_clon = this.list;
                    }
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, this.list_clon, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaBasicDelegate$ObKhy0yLDXGLla04rN-H6gVOZvk
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            LaViewPagerAdapter.LaBasicDelegate.this.lambda$onClick$3$LaViewPagerAdapter$LaBasicDelegate(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaBasicDelegate$NsHyMaQJB5suiez3RcFA4WiUhlY
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaBasicDelegate.this.lambda$onClick$4$LaViewPagerAdapter$LaBasicDelegate(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ void lambda$onClick$3$LaViewPagerAdapter$LaBasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$4$LaViewPagerAdapter$LaBasicDelegate(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().saveLaSize(this.list_clon.get(i).getValue());
        }

        public /* synthetic */ void lambda$onClick$5$LaViewPagerAdapter$LaBasicDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$6$LaViewPagerAdapter$LaBasicDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().saveAutoOrder(((MappingObject) list.get(i)).getValue());
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
        public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
            switch (i) {
                case R.id.la_basic /* 2131363240 */:
                    LaParam laParam = this.laParam;
                    laParam.savedD0TOd7Threshold(laParam.getLongStep(laParam.getD0TOd7_threshold_(), this.laParam.getD0tod7Attr(), z, keyEvent));
                    return;
                case R.id.la_basic_two /* 2131363241 */:
                    LaParam laParam2 = this.laParam;
                    laParam2.savedD8TOd15Threshold(laParam2.getLongStep(laParam2.getD8TOd15_threshold_(), this.laParam.getD8tod15Attr(), z, keyEvent));
                    return;
                default:
                    return;
            }
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
        public void onResetDefault(int i) {
            switch (i) {
                case R.id.la_basic /* 2131363240 */:
                    this.laParam.savedD0TOd7Threshold(0L);
                    return;
                case R.id.la_basic_two /* 2131363241 */:
                    this.laParam.savedD8TOd15Threshold(0L);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LaSeniorDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
        AbapterLaSeniorBinding abapterLaSeniorBinding;
        private AorBManager aorBManager;
        private View clickedView;
        private KeyboardPopupView keyboardPopupView;
        LaViewModel laViewModel;
        private List<AorBParam> list_aorbParam;
        private List<MappingObject> mappingObjects;
        private PanelKeyViewModel panelKeyViewModel;
        private PopupSpinner popupSpinner;
        BasePopupView popupView;
        private SpinnerAdapter spinnerAdapter;

        @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
        public void onResetDefault(int i) {
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
        public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public LaSeniorDelegate(int i, BasePopupView basePopupView) {
            super(i);
            this.list_aorbParam = new ArrayList();
            this.popupView = basePopupView;
        }

        public AorBManager getAorBManager() {
            return this.aorBManager;
        }

        public void setAorBManager(AorBManager aorBManager) {
            this.aorBManager = aorBManager;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            MappingObject mappingObject = list.get(i);
            return mappingObject != null && mappingObject.getValue() == 2;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            this.laViewModel = (LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class);
            AbapterLaSeniorBinding abapterLaSeniorBinding = (AbapterLaSeniorBinding) baseViewHolder.getBinding();
            this.abapterLaSeniorBinding = abapterLaSeniorBinding;
            abapterLaSeniorBinding.setParma(this.laViewModel.getLiveData().getValue());
            this.abapterLaSeniorBinding.laSourceSpinner.setOnClickListener(this);
            this.abapterLaSeniorBinding.laSourceGroup.setOnClickListener(this);
            this.abapterLaSeniorBinding.laSourceHigh.setOnClickListener(this);
            this.abapterLaSeniorBinding.laSourceCentre.setOnClickListener(this);
            this.abapterLaSeniorBinding.laSourceLow.setOnClickListener(this);
            this.abapterLaSeniorBinding.triggerNoiseSwitch.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.showLabelSwitch.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.laLabelEdit.setOnClickListener(this);
            this.abapterLaSeniorBinding.d0.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d1.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d2.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d3.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d4.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d5.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d6.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d7.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d8.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d9.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d10.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d11.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d12.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d13.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d14.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.d15.setOnCheckedChangeListener(this);
            this.abapterLaSeniorBinding.laGroupCancel.setOnClickListener(this);
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$RN8NXxxEXbd0cVrhlEobldV2Ge0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onBindViewHolder$2$LaViewPagerAdapter$LaSeniorDelegate((KeyEvent) obj);
                    }
                });
            }
            this.list_aorbParam.add(new AorBParam(this.abapterLaSeniorBinding.laSourceCentre, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.abapterLaSeniorBinding.laSourceGroup, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.abapterLaSeniorBinding.laSourceHigh, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.abapterLaSeniorBinding.laSourceSpinner, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.abapterLaSeniorBinding.laSourceLow, 0, true, ViewUtil.KEY_A, 2));
            this.aorBManager = new AorBManager(this.popupView.getAnchor().getContext(), this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.LaViewPagerAdapter.LaSeniorDelegate.1
                @Override // com.rigol.scope.utilities.AorBManager
                protected void setSwitch_num(int i2) {
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setrecovery_num(int i2) {
                }
            };
        }

        public /* synthetic */ void lambda$onBindViewHolder$2$LaViewPagerAdapter$LaSeniorDelegate(KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(LapopupView.class)) {
                this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$OzOUh0pcATVihPDHs2ghLiMVrVA
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onBindViewHolder$0$LaViewPagerAdapter$LaSeniorDelegate(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$gIWpu0UHIcEs1EC8BdqITFV2E0A
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onBindViewHolder$1$LaViewPagerAdapter$LaSeniorDelegate(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$0$LaViewPagerAdapter$LaSeniorDelegate(KeyboardPopupView keyboardPopupView) {
            this.keyboardPopupView = keyboardPopupView;
        }

        public /* synthetic */ void lambda$onBindViewHolder$1$LaViewPagerAdapter$LaSeniorDelegate(int i, MappingObject mappingObject) {
            if (this.clickedView.getId() == R.id.la_source_group) {
                this.laViewModel.getLiveData().getValue().saveGroup1(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.la_source_high) {
                this.laViewModel.getLiveData().getValue().savelaHighColor(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.la_source_centre) {
                this.laViewModel.getLiveData().getValue().savelaedgeColor(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.la_source_low) {
                this.laViewModel.getLiveData().getValue().savelLoweColor(mappingObject.getValue());
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.la_group_cancel /* 2131363242 */:
                    this.laViewModel.getLiveData().getValue().saveLaGroupCancel(true);
                    return;
                case R.id.la_label_edit /* 2131363243 */:
                    ViewUtil.showPinyinKeyboard(this.popupView.getContentView().getContext(), this.popupView.getAnchor(), view, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$N9DUptxgHiUGJezkzvVErpOJtHc
                        @Override // com.rigol.pinyinkeyboard.ExternalInterface
                        public final void resultShow(String str) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$7$LaViewPagerAdapter$LaSeniorDelegate(str);
                        }
                    });
                    return;
                case R.id.la_source_centre /* 2131363251 */:
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_la_high_color);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$nfRxDS6l0VYeIvw-N80TU1grWc4
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$10$LaViewPagerAdapter$LaSeniorDelegate(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$5WRsoVTNMMxgvavoHmNAh-VGVf4
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$11$LaViewPagerAdapter$LaSeniorDelegate(list, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.la_source_group /* 2131363252 */:
                    final List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_la_group_set);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$cfyu7U8b3sZzY9J9LXaVuuc0hX4
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$5$LaViewPagerAdapter$LaSeniorDelegate(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$zFLPAc34BH0Y1gAXubIR4gsftgw
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$6$LaViewPagerAdapter$LaSeniorDelegate(list2, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.la_source_high /* 2131363258 */:
                    final List<MappingObject> list3 = ViewUtil.getList((int) R.array.msg_la_high_color);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list3, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$ePY1PiY1y7-CTye2kFH65VK8XlE
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$8$LaViewPagerAdapter$LaSeniorDelegate(popupSpinner, spinnerAdapter, list4, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$8usiQ3gC4CuymHNR-xuDAfFiuKw
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$9$LaViewPagerAdapter$LaSeniorDelegate(list3, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.la_source_low /* 2131363259 */:
                    final List<MappingObject> list4 = ViewUtil.getList((int) R.array.msg_la_high_color);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list4, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$wz_vw6xpIqk5CehnmEaudhecWsU
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list5, View view2) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$12$LaViewPagerAdapter$LaSeniorDelegate(popupSpinner, spinnerAdapter, list5, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$d8O9QAyO-MreN9TWdl1U7LR_BSk
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$13$LaViewPagerAdapter$LaSeniorDelegate(list4, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.la_source_spinner /* 2131363261 */:
                    final List<MappingObject> list5 = ViewUtil.getList((int) R.array.msg_la_current_chan);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list5, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$8lkQo3qJnHk6YUMe4Pj1ihxQgjE
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list6, View view2) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$3$LaViewPagerAdapter$LaSeniorDelegate(popupSpinner, spinnerAdapter, list6, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaSeniorDelegate$3bk8mQ1lNu255Y4xj1L7cmUVIDM
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaSeniorDelegate.this.lambda$onClick$4$LaViewPagerAdapter$LaSeniorDelegate(list5, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ void lambda$onClick$3$LaViewPagerAdapter$LaSeniorDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$4$LaViewPagerAdapter$LaSeniorDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().savelaSource(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$5$LaViewPagerAdapter$LaSeniorDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$6$LaViewPagerAdapter$LaSeniorDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().saveGroup1(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$7$LaViewPagerAdapter$LaSeniorDelegate(String str) {
            this.laViewModel.getLiveData().getValue().saveInputLabel(str);
        }

        public /* synthetic */ void lambda$onClick$8$LaViewPagerAdapter$LaSeniorDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$9$LaViewPagerAdapter$LaSeniorDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().savelaHighColor(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$10$LaViewPagerAdapter$LaSeniorDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$11$LaViewPagerAdapter$LaSeniorDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().savelaedgeColor(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$12$LaViewPagerAdapter$LaSeniorDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$13$LaViewPagerAdapter$LaSeniorDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().savelLoweColor(((MappingObject) list.get(i)).getValue());
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                int id = compoundButton.getId();
                if (id == R.id.d0) {
                    this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d0.value1);
                } else if (id == R.id.d9) {
                    this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d9.value1);
                } else if (id == R.id.show_label_switch) {
                    this.laViewModel.getLiveData().getValue().savelabelGroup(z);
                } else {
                    switch (id) {
                        case R.id.d1 /* 2131362351 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d1.value1);
                            return;
                        case R.id.d10 /* 2131362352 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d10.value1);
                            return;
                        case R.id.d11 /* 2131362353 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d11.value1);
                            return;
                        case R.id.d12 /* 2131362354 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d12.value1);
                            return;
                        case R.id.d13 /* 2131362355 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d13.value1);
                            return;
                        case R.id.d14 /* 2131362356 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d14.value1);
                            return;
                        case R.id.d15 /* 2131362357 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d15.value1);
                            return;
                        case R.id.d2 /* 2131362358 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d2.value1);
                            return;
                        case R.id.d3 /* 2131362359 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d3.value1);
                            return;
                        case R.id.d4 /* 2131362360 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d4.value1);
                            return;
                        case R.id.d5 /* 2131362361 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d5.value1);
                            return;
                        case R.id.d6 /* 2131362362 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d6.value1);
                            return;
                        case R.id.d7 /* 2131362363 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d7.value1);
                            return;
                        case R.id.d8 /* 2131362364 */:
                            this.laViewModel.getLiveData().getValue().saveSelectAddDX(ServiceEnum.Chan.d8.value1);
                            return;
                        default:
                            return;
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class LaColorDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
        AdapterLaColorBinding adapterLaColorBinding;
        private AorBManager aorBManager;
        private View clickedView;
        private KeyboardPopupView keyboardPopupView;
        LaViewModel laViewModel;
        private List<AorBParam> list_aorbParam;
        private List<MappingObject> mappingObjects;
        private PanelKeyViewModel panelKeyViewModel;
        private PopupSpinner popupSpinner;
        BasePopupView popupView;
        private SpinnerAdapter spinnerAdapter;

        @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
        public void onResetDefault(int i) {
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
        public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public LaColorDelegate(int i, BasePopupView basePopupView) {
            super(i);
            this.list_aorbParam = new ArrayList();
            this.popupView = basePopupView;
        }

        public AorBManager getAorBManager() {
            return this.aorBManager;
        }

        public void setAorBManager(AorBManager aorBManager) {
            this.aorBManager = aorBManager;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.la_label_edit /* 2131363243 */:
                    ViewUtil.showPinyinKeyboard(this.popupView.getContentView().getContext(), this.popupView.getAnchor(), view, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaColorDelegate$3dZAIcHC5Fwi4jeO1Top3UNmoEM
                        @Override // com.rigol.pinyinkeyboard.ExternalInterface
                        public final void resultShow(String str) {
                            LaViewPagerAdapter.LaColorDelegate.this.lambda$onClick$2$LaViewPagerAdapter$LaColorDelegate(str);
                        }
                    });
                    return;
                case R.id.la_source_group /* 2131363252 */:
                    final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_la_label_select_chan);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaColorDelegate$CrGk6kCSRJ3LFzv6G_3x9hd0THM
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                            LaViewPagerAdapter.LaColorDelegate.this.lambda$onClick$3$LaViewPagerAdapter$LaColorDelegate(popupSpinner, spinnerAdapter, list2, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaColorDelegate$LMDLobdk3s5U7SaFgKHoZTJYcbg
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaColorDelegate.this.lambda$onClick$4$LaViewPagerAdapter$LaColorDelegate(list, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                case R.id.la_source_group2 /* 2131363253 */:
                    final List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_la_label_view_select);
                    ViewUtil.showSpinner(this.popupView.getAnchor(), view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaColorDelegate$DC7WgzD7l6sei29C242_yVPGUgM
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                            LaViewPagerAdapter.LaColorDelegate.this.lambda$onClick$0$LaViewPagerAdapter$LaColorDelegate(popupSpinner, spinnerAdapter, list3, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaColorDelegate$Y6F8srqrzrS4FPvecTuplzvYwuk
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            LaViewPagerAdapter.LaColorDelegate.this.lambda$onClick$1$LaViewPagerAdapter$LaColorDelegate(list2, view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                default:
                    return;
            }
        }

        public /* synthetic */ void lambda$onClick$0$LaViewPagerAdapter$LaColorDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$LaViewPagerAdapter$LaColorDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().saveLaLabelViewSelect(((MappingObject) list.get(i)).getValue());
        }

        public /* synthetic */ void lambda$onClick$2$LaViewPagerAdapter$LaColorDelegate(String str) {
            this.laViewModel.getLiveData().getValue().saveInputLabel(str);
        }

        public /* synthetic */ void lambda$onClick$3$LaViewPagerAdapter$LaColorDelegate(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$4$LaViewPagerAdapter$LaColorDelegate(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            this.laViewModel.getLiveData().getValue().savelaSelectChan(((MappingObject) list.get(i)).getValue());
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (compoundButton.isPressed()) {
                this.laViewModel.getLiveData().getValue().saveLaLabelEn(z);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            return list.get(i).getValue() == 3;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterLaColorBinding adapterLaColorBinding = (AdapterLaColorBinding) baseViewHolder.getBinding();
            this.adapterLaColorBinding = adapterLaColorBinding;
            adapterLaColorBinding.laSourceGroup2.setOnClickListener(this);
            this.adapterLaColorBinding.laSourceGroup.setOnClickListener(this);
            this.adapterLaColorBinding.laLabelEdit.setOnClickListener(this);
            this.adapterLaColorBinding.showLabelSwitch.setOnCheckedChangeListener(this);
            LaViewModel laViewModel = (LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class);
            this.laViewModel = laViewModel;
            this.adapterLaColorBinding.setParma(laViewModel.getValue());
            ViewUtil.setSwitchButton(this.adapterLaColorBinding.showLabelSwitch);
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaColorDelegate$_3rUgXIqJrBlXiIT9buJpNU4Lh0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        LaViewPagerAdapter.LaColorDelegate.this.lambda$onBindViewHolder$7$LaViewPagerAdapter$LaColorDelegate((KeyEvent) obj);
                    }
                });
            }
            this.list_aorbParam.add(new AorBParam(this.adapterLaColorBinding.laSourceGroup2, 0, true, ViewUtil.KEY_A, 2));
            this.list_aorbParam.add(new AorBParam(this.adapterLaColorBinding.laSourceGroup, 0, true, ViewUtil.KEY_A, 2));
            this.aorBManager = new AorBManager(this.popupView.getAnchor().getContext(), this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.LaViewPagerAdapter.LaColorDelegate.1
                @Override // com.rigol.scope.utilities.AorBManager
                protected void setSwitch_num(int i2) {
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setrecovery_num(int i2) {
                }
            };
        }

        public /* synthetic */ void lambda$onBindViewHolder$7$LaViewPagerAdapter$LaColorDelegate(KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(LapopupView.class)) {
                this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaColorDelegate$V6X27uF0Z4MqJXxU0R4Ew3UvoyU
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        LaViewPagerAdapter.LaColorDelegate.this.lambda$onBindViewHolder$5$LaViewPagerAdapter$LaColorDelegate(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$LaViewPagerAdapter$LaColorDelegate$donlvP665yzgTaxDIDQJmIZyoBg
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        LaViewPagerAdapter.LaColorDelegate.this.lambda$onBindViewHolder$6$LaViewPagerAdapter$LaColorDelegate(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onBindViewHolder$5$LaViewPagerAdapter$LaColorDelegate(KeyboardPopupView keyboardPopupView) {
            this.keyboardPopupView = keyboardPopupView;
        }

        public /* synthetic */ void lambda$onBindViewHolder$6$LaViewPagerAdapter$LaColorDelegate(int i, MappingObject mappingObject) {
            if (this.clickedView.getId() == R.id.la_source_group) {
                this.laViewModel.getLiveData().getValue().savelaSelectChan(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.la_source_group2) {
                this.laViewModel.getLiveData().getValue().saveLaLabelViewSelect(mappingObject.getValue());
            }
        }
    }
}
