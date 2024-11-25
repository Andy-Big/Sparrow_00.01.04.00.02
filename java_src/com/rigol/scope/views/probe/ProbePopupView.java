package com.rigol.scope.views.probe;

import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ActivityUtils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.AdapterItemPopupviewProbeBinding;
import com.rigol.scope.databinding.PopupviewProbeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.probe.ProbePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.vertical.VerticalPopupView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
/* loaded from: classes2.dex */
public class ProbePopupView extends BasePopupView implements TabLayoutMediator.TabConfigurationStrategy, View.OnClickListener {
    private final PopupviewProbeBinding binding;
    private PanelKeyViewModel panelKeyViewModel;
    private final PopupViewAdapter popupViewAdapter;
    private VerticalViewModel verticalViewModel;

    public ProbePopupView() {
        super((int) R.style.App_PopupWindow_Probe);
        this.popupViewAdapter = new PopupViewAdapter(this.context, R.layout.adapter_item_popupview_probe);
        PopupviewProbeBinding inflate = PopupviewProbeBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.setClickListener(this);
        if (this.panelKeyViewModel == null) {
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        }
        if (this.verticalViewModel == null) {
            this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        }
        this.popupViewAdapter.setPanelKeyViewModel(this.panelKeyViewModel);
        this.binding.viewPager.setAdapter(this.popupViewAdapter);
        this.binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.probe.ProbePopupView.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                super.onPageSelected(i);
                ProbePopupView.this.binding.tabs.selectTab(ProbePopupView.this.binding.tabs.getTabAt(i));
                ProbePopupView.this.popupViewAdapter.setCurrentItemForce(i);
            }
        });
        new TabLayoutMediator(this.binding.tabs, this.binding.viewPager, this).attach();
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel != null) {
            verticalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.probe.-$$Lambda$ProbePopupView$Us4afrWg_T_b6CO0EY-VFxK85hk
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ProbePopupView.this.lambda$new$0$ProbePopupView((ArrayList) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$ProbePopupView(ArrayList arrayList) {
        this.popupViewAdapter.setItems(arrayList);
        this.popupViewAdapter.notifyDataSetChanged();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        VerticalParam verticalParam;
        TextView textView;
        tab.setCustomView(R.layout.adapter_item_tab);
        ?? items = this.popupViewAdapter.getItems();
        if (items == 0 || items.isEmpty() || (verticalParam = (VerticalParam) items.get(i)) == null || (textView = (TextView) tab.getCustomView()) == null) {
            return;
        }
        textView.setText("CH" + verticalParam.getTitle());
        int color = ColorUtil.getColor(this.context, verticalParam.getServiceId());
        if (verticalParam.getServiceId() == 4) {
            textView.setTextColor(ContextCompat.getColor(this.context, R.color.ch4));
        } else {
            textView.setTextColor(color);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.vertical_setting) {
            PopupViewManager.getInstance().show(VerticalPopupView.class);
        }
    }

    public void probeLight() {
        PopupViewManager.getInstance().closeAllLight();
        PopupViewManager.getInstance().AHorizontalLight_Open();
        int selectedTabPosition = this.binding.tabs.getSelectedTabPosition();
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        if (verticalViewModel != null) {
            verticalViewModel.getLiveData();
            ArrayList<VerticalParam> value = this.verticalViewModel.getLiveData().getValue();
            VerticalParam verticalParam = (value == null || value.size() < selectedTabPosition) ? null : value.get(selectedTabPosition);
            if (verticalParam != null && verticalParam.getProbeInsert() && verticalParam.getProbeType() != ServiceEnum.ProbeType.Probe_BNC) {
                PopupViewManager.getInstance().BVerticalLight_Open();
            } else {
                PopupViewManager.getInstance().closeBVerticalLight();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class PopupViewAdapter extends BaseAdapter<List<VerticalParam>> implements View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
        private boolean[] adapterInitArr;
        private View anchor;
        private AorBManager aorBManager;
        private View clickedView;
        private int currentPosition;
        private KeyboardPopupView keyboardPopupView;
        private Map<Integer, List<AorBParam>> mapList;
        private Map<Integer, AorBManager> mapManager;
        private List<MappingObject> mappingObjects;
        private VerticalParam param;
        private PopupSpinner popupSpinner;
        private SharedParam sharedParam;
        private SpinnerAdapter spinnerAdapter;

        public void setPanelKeyViewModel(final PanelKeyViewModel panelKeyViewModel) {
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.probe.-$$Lambda$ProbePopupView$PopupViewAdapter$-GVB6x5I9y_bIR1YqNDCskyE-3c
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ProbePopupView.PopupViewAdapter.this.lambda$setPanelKeyViewModel$2$ProbePopupView$PopupViewAdapter(panelKeyViewModel, (KeyEvent) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$setPanelKeyViewModel$2$ProbePopupView$PopupViewAdapter(PanelKeyViewModel panelKeyViewModel, KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(ProbePopupView.class)) {
                panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.probe.-$$Lambda$ProbePopupView$PopupViewAdapter$ae0FoVf18XQ8WJaqG0EfnDPzPnI
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        ProbePopupView.PopupViewAdapter.this.lambda$setPanelKeyViewModel$0$ProbePopupView$PopupViewAdapter(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.probe.-$$Lambda$ProbePopupView$PopupViewAdapter$nvExGISCszZF4YJEByXBHSDK6ms
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        ProbePopupView.PopupViewAdapter.this.lambda$setPanelKeyViewModel$1$ProbePopupView$PopupViewAdapter(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$setPanelKeyViewModel$0$ProbePopupView$PopupViewAdapter(KeyboardPopupView keyboardPopupView) {
            this.keyboardPopupView = keyboardPopupView;
        }

        public /* synthetic */ void lambda$setPanelKeyViewModel$1$ProbePopupView$PopupViewAdapter(int i, MappingObject mappingObject) {
            View view = this.clickedView;
            if (view != null && view.getId() == R.id.probe_ratio_spinner) {
                selectProbeRatio(mappingObject);
            }
        }

        public PopupViewAdapter(Context context, int i) {
            super(context, i);
            this.mapManager = new HashMap();
            this.mapList = new HashMap();
            this.adapterInitArr = new boolean[4];
            SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
            if (sharedViewModel != null) {
                sharedViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.probe.-$$Lambda$ProbePopupView$PopupViewAdapter$JFNp98iK1x-V9VK4OWbBdUAYUN0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        ProbePopupView.PopupViewAdapter.this.lambda$new$3$ProbePopupView$PopupViewAdapter((SharedParam) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$new$3$ProbePopupView$PopupViewAdapter(SharedParam sharedParam) {
            this.sharedParam = sharedParam;
        }

        @Override // com.rigol.scope.adapters.BaseAdapter
        protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<VerticalParam> list, int i) {
            AdapterItemPopupviewProbeBinding adapterItemPopupviewProbeBinding = (AdapterItemPopupviewProbeBinding) baseViewHolder.getBinding();
            adapterItemPopupviewProbeBinding.setVerticalParam(list.get(i));
            adapterItemPopupviewProbeBinding.setSharedParam(this.sharedParam);
            adapterItemPopupviewProbeBinding.probeRatioSpinner.setTag(Integer.valueOf(i));
            adapterItemPopupviewProbeBinding.probeDelayEditText.setTag(Integer.valueOf(i));
            adapterItemPopupviewProbeBinding.probeBiasEditText.setTag(Integer.valueOf(i));
            adapterItemPopupviewProbeBinding.probeCalButton.setTag(Integer.valueOf(i));
            adapterItemPopupviewProbeBinding.probeDemagButton.setTag(Integer.valueOf(i));
            this.aorBManager = getAorBManager(baseViewHolder, baseViewHolder.getLayoutPosition());
        }

        @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
        public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
            ((AdapterItemPopupviewProbeBinding) onCreateViewHolder.getBinding()).setClickListener(this);
            return onCreateViewHolder;
        }

        public void setAnchor(View view) {
            this.anchor = view;
        }

        public AorBManager getAorBManager(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, final int i) {
            AdapterItemPopupviewProbeBinding adapterItemPopupviewProbeBinding = (AdapterItemPopupviewProbeBinding) baseViewHolder.getBinding();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new AorBParam(adapterItemPopupviewProbeBinding.probeDelayEditText, 0, true, ViewUtil.KEY_A, 0));
            arrayList.add(new AorBParam(adapterItemPopupviewProbeBinding.probeBiasEditText, 0, true, ViewUtil.KEY_A, 0));
            arrayList.add(new AorBParam(adapterItemPopupviewProbeBinding.probeRatioSpinner, 0, false, "", 2));
            this.mapList.put(Integer.valueOf(i), arrayList);
            AorBManager aorBManager = new AorBManager(this.context, arrayList, this, this) { // from class: com.rigol.scope.views.probe.ProbePopupView.PopupViewAdapter.1
                @Override // com.rigol.scope.utilities.AorBManager
                protected void setSwitch_num(int i2) {
                    List list = (List) Objects.requireNonNull((List) PopupViewAdapter.this.mapList.get(Integer.valueOf(i)));
                    showKey(PopupViewAdapter.this.context, ((AorBParam) list.get(i2)).getEditText(), true, ((AorBParam) list.get(i2)).getAorb());
                }

                @Override // com.rigol.scope.utilities.AorBManager
                protected void setrecovery_num(int i2) {
                    List list = (List) Objects.requireNonNull((List) PopupViewAdapter.this.mapList.get(Integer.valueOf(i)));
                    showKey(PopupViewAdapter.this.context, ((AorBParam) list.get(i2)).getEditText(), false, ((AorBParam) list.get(i2)).getAorb());
                }
            };
            aorBManager.showKey(this.context, adapterItemPopupviewProbeBinding.probeDelayEditText, true, ViewUtil.KEY_A);
            aorBManager.showKey(this.context, adapterItemPopupviewProbeBinding.probeBiasEditText, true, ViewUtil.KEY_B);
            this.mapManager.put(Integer.valueOf(i), aorBManager);
            this.adapterInitArr[i] = true;
            return aorBManager;
        }

        /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
        @Override // com.rigol.scope.adapters.MultiItemTypeAdapter
        public void setCurrentItemForce(final int i) {
            super.setCurrentItem(i);
            this.currentPosition = i;
            if (this.adapterInitArr[i] && this.mapManager.get(Integer.valueOf(i)) != null) {
                this.aorBManager = this.mapManager.get(Integer.valueOf(i));
            } else {
                new Handler().postDelayed(new Runnable() { // from class: com.rigol.scope.views.probe.-$$Lambda$ProbePopupView$PopupViewAdapter$h8We5Lj0uWR8llyPrvVVTviiEQI
                    @Override // java.lang.Runnable
                    public final void run() {
                        ProbePopupView.PopupViewAdapter.this.lambda$setCurrentItemForce$4$ProbePopupView$PopupViewAdapter(i);
                    }
                }, 500L);
            }
            VerticalParam verticalParam = (VerticalParam) getItems().get(i);
            this.param = verticalParam;
            if (verticalParam.getProbeInsert() && verticalParam.readProbeType() != ServiceEnum.ProbeType.Probe_BNC) {
                PopupViewManager.getInstance().BVerticalLight_Open();
            } else {
                PopupViewManager.getInstance().closeBVerticalLight();
            }
        }

        public /* synthetic */ void lambda$setCurrentItemForce$4$ProbePopupView$PopupViewAdapter(int i) {
            this.aorBManager = this.mapManager.get(Integer.valueOf(i));
        }

        private void selectProbeRatio(MappingObject mappingObject) {
            ServiceEnum.ProbeX probeXFromValue1 = ServiceEnum.getProbeXFromValue1(mappingObject.getValue());
            if (probeXFromValue1 == null || !this.param.getProbeRatioEnable()) {
                return;
            }
            this.param.saveProbeRatio(probeXFromValue1);
        }

        /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List] */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            final VerticalParam verticalParam = (VerticalParam) getItems().get(((Integer) view.getTag()).intValue());
            if (verticalParam == null) {
                return;
            }
            int id = view.getId();
            if (id == R.id.probe_ratio_spinner) {
                ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_chan_probe), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.probe.-$$Lambda$ProbePopupView$PopupViewAdapter$gNGA0cjCYFvqkUrXDMVyn2JgEPU
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        ProbePopupView.PopupViewAdapter.this.lambda$onClick$5$ProbePopupView$PopupViewAdapter(verticalParam, popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.probe.-$$Lambda$ProbePopupView$PopupViewAdapter$09F49SvkBQUP1J9eUn3XJns2Uo8
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        ProbePopupView.PopupViewAdapter.this.lambda$onClick$6$ProbePopupView$PopupViewAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else if (id == R.id.probe_delay_edit_text) {
                if (this.aorBManager.setClick_showab(id)) {
                    verticalParam.readProbeDelayAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, verticalParam.getProbeDelayAttr().getMaxLongValue(), verticalParam.getProbeDelayAttr().getMinLongValue(), verticalParam.getProbeDelayAttr().getDefLongValue(), verticalParam.getProbeDelay(), new KeyboardListener() { // from class: com.rigol.scope.views.probe.ProbePopupView.PopupViewAdapter.2
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            verticalParam.saveProbeDelay(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            PopupViewAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            } else if (id != R.id.probe_bias_edit_text) {
                if (id == R.id.probe_cal_button) {
                    verticalParam.probeCal();
                } else if (id == R.id.probe_demag_button) {
                    verticalParam.probeDemag();
                }
            } else if (verticalParam.getProbeModel().startsWith("PCA")) {
                if (this.aorBManager.setClick_showab(id)) {
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_percent, verticalParam.getProbeBiasAttr().getMaxLongValue() / 1000000000, verticalParam.getProbeBiasAttr().getMinLongValue() / 1000000000, verticalParam.getProbeBiasAttr().getDefLongValue() / 1000000000, verticalParam.getProbeCurrentBias(), new KeyboardListener() { // from class: com.rigol.scope.views.probe.ProbePopupView.PopupViewAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            verticalParam.saveProbeCurrentBias(((Long) t).longValue() * 1000000000);
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            PopupViewAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            } else if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_V, verticalParam.getProbeBiasAttr().getMaxLongValue(), verticalParam.getProbeBiasAttr().getMinLongValue(), verticalParam.getProbeBiasAttr().getDefLongValue(), verticalParam.getProbeBias(), new KeyboardListener() { // from class: com.rigol.scope.views.probe.ProbePopupView.PopupViewAdapter.4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        verticalParam.saveProbeBias(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        PopupViewAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onClick$5$ProbePopupView$PopupViewAdapter(VerticalParam verticalParam, PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            this.popupSpinner = popupSpinner;
            this.spinnerAdapter = spinnerAdapter;
            this.mappingObjects = list;
            this.clickedView = view;
            verticalParam.setPopupSpinner(popupSpinner);
        }

        public /* synthetic */ void lambda$onClick$6$ProbePopupView$PopupViewAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            selectProbeRatio(mappingObject);
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
        public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
            VerticalParam verticalParam = this.param;
            if (verticalParam == null) {
                return;
            }
            if (i == R.id.probe_bias_edit_text) {
                if (!verticalParam.getProbeInsert() || this.param.readProbeType() == ServiceEnum.ProbeType.Probe_BNC) {
                    return;
                }
                VerticalParam verticalParam2 = this.param;
                verticalParam2.saveProbeCurrentBias(verticalParam2.getLongStep(verticalParam2.getProbeCurrentBias(), this.param.getProbeBiasAttr(), z, keyEvent));
            } else if (i != R.id.probe_delay_edit_text) {
            } else {
                MessageAttr messageAttr = new MessageAttr();
                messageAttr.setMinValue(-100000000);
                messageAttr.setMaxValue(100000000);
                messageAttr.setDefValue(0);
                messageAttr.setStepValue(10000L);
                VerticalParam verticalParam3 = this.param;
                verticalParam3.saveProbeDelay(verticalParam3.getLongStep(verticalParam3.getProbeDelay(), messageAttr, z, keyEvent));
            }
        }

        @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
        public void onResetDefault(int i) {
            VerticalParam verticalParam = this.param;
            if (verticalParam == null) {
                return;
            }
            if (i == R.id.probe_bias_edit_text) {
                if (!verticalParam.getProbeInsert() || this.param.readProbeType() == ServiceEnum.ProbeType.Probe_BNC) {
                    return;
                }
                VerticalParam verticalParam2 = this.param;
                verticalParam2.saveProbeCurrentBias(verticalParam2.getLongDef(verticalParam2.getOffsetAttr()));
            } else if (i != R.id.probe_delay_edit_text) {
            } else {
                MessageAttr messageAttr = new MessageAttr();
                messageAttr.setMinValue(-100000000);
                messageAttr.setMaxValue(100000000);
                messageAttr.setDefValue(0);
                messageAttr.setStepValue(10000L);
                VerticalParam verticalParam3 = this.param;
                verticalParam3.saveProbeDelay(verticalParam3.getLongDef(messageAttr));
            }
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        super.showAsDropDown(view, i, i2, i3);
        this.popupViewAdapter.setAnchor(view);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        this.popupViewAdapter.setAnchor(view);
    }

    public void setCurrentItem(int i) {
        this.binding.viewPager.setCurrentItem(i, false);
    }
}
