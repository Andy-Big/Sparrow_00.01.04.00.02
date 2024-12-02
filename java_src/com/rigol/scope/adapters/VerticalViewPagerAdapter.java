package com.rigol.scope.adapters;

import android.content.Context;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.AdapterItemPopupviewVerticalBinding;
import com.rigol.scope.databinding.PopupviewVerticalBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.views.horizontal.HorizontalPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.trigger.TriggerPopupView;
import com.rigol.scope.views.vertical.VerticalPopupView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* loaded from: classes.dex */
public class VerticalViewPagerAdapter extends BaseAdapter<List<VerticalParam>> implements AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private boolean[] adapterInitArr;
    private View anchor;
    private AorBManager aorBManager;
    private View clickedView;
    private final Context context;
    private int currentItem;
    private KeyboardPopupView keyboardPopupView;
    private Map<Integer, AdapterItemPopupviewVerticalBinding> mapBindings;
    private Map<Integer, List<AorBParam>> mapList;
    private Map<Integer, AorBManager> mapManager;
    private List<MappingObject> mappingObjects;
    private VerticalParam param;
    private PopupSpinner popupSpinner;
    private PopupviewVerticalBinding popupviewVerticalBinding;
    private SpinnerAdapter spinnerAdapter;
    private TriggerViewModel triggerViewModel;

    public AorBManager getAorBManager() {
        boolean[] zArr = this.adapterInitArr;
        int i = this.currentItem;
        if (zArr[i] && this.mapManager.get(Integer.valueOf(i)) != null) {
            this.aorBManager = this.mapManager.get(Integer.valueOf(this.currentItem));
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$3T6t5jgZDoEiXY_K45RCCpPKo5E
                @Override // java.lang.Runnable
                public final void run() {
                    VerticalViewPagerAdapter.this.lambda$getAorBManager$0$VerticalViewPagerAdapter();
                }
            }, 500L);
        }
        return this.aorBManager;
    }

    public /* synthetic */ void lambda$getAorBManager$0$VerticalViewPagerAdapter() {
        this.aorBManager = this.mapManager.get(Integer.valueOf(this.currentItem));
    }

    public void setPanelKeyViewModel(final PanelKeyViewModel panelKeyViewModel) {
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$CXvMBRDbLADG4NOHFxoG3I6Yox4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    VerticalViewPagerAdapter.this.lambda$setPanelKeyViewModel$3$VerticalViewPagerAdapter(panelKeyViewModel, (KeyEvent) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$setPanelKeyViewModel$3$VerticalViewPagerAdapter(PanelKeyViewModel panelKeyViewModel, KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(VerticalPopupView.class)) {
            panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$PmZx4yj7UoR9vAI4rd_3XKEkgTs
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    VerticalViewPagerAdapter.this.lambda$setPanelKeyViewModel$1$VerticalViewPagerAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$HActoa_bzLvbmHyreTdGNCMAJpM
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    VerticalViewPagerAdapter.this.lambda$setPanelKeyViewModel$2$VerticalViewPagerAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$setPanelKeyViewModel$1$VerticalViewPagerAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$setPanelKeyViewModel$2$VerticalViewPagerAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.coupling_spinner) {
            selectCoupling(mappingObject);
        } else if (this.clickedView.getId() == R.id.bandwidth_limit_spinner) {
            selectBandWidthLimit(mappingObject);
        } else if (this.clickedView.getId() == R.id.unit_spinner) {
            selectUnit(mappingObject);
        }
    }

    public VerticalViewPagerAdapter(Context context, int i, View view, PopupviewVerticalBinding popupviewVerticalBinding) {
        super(context, i);
        this.mapManager = new HashMap();
        this.mapBindings = new HashMap();
        this.mapList = new HashMap();
        this.adapterInitArr = new boolean[4];
        this.context = context;
        this.anchor = view;
        this.popupviewVerticalBinding = popupviewVerticalBinding;
    }

    public void setAnchor(View view) {
        this.anchor = view;
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<VerticalParam> list, int i) {
        HorizontalParam value;
        AdapterItemPopupviewVerticalBinding adapterItemPopupviewVerticalBinding = (AdapterItemPopupviewVerticalBinding) baseViewHolder.getBinding();
        this.aorBManager = getAorBManager(baseViewHolder, baseViewHolder.getLayoutPosition());
        this.mapBindings.put(Integer.valueOf(baseViewHolder.getLayoutPosition()), adapterItemPopupviewVerticalBinding);
        ViewUtil.setSwitchButton(adapterItemPopupviewVerticalBinding.displaySwitch);
        ViewUtil.setSwitchButton(adapterItemPopupviewVerticalBinding.invertSwitch);
        ViewUtil.setSwitchButton(adapterItemPopupviewVerticalBinding.fineSwitch);
        ViewUtil.setSwitchButton(R.array.msg_chan_impedance, adapterItemPopupviewVerticalBinding.impedanceSwitch);
        ViewUtil.setSwitchButton(adapterItemPopupviewVerticalBinding.labelSwitch);
        adapterItemPopupviewVerticalBinding.setParam(list.get(i));
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.triggerViewModel = (TriggerViewModel) ContextUtil.getAppViewModel(TriggerViewModel.class);
        if (horizontalViewModel == null || (value = horizontalViewModel.getLiveData().getValue()) == null) {
            return;
        }
        adapterItemPopupviewVerticalBinding.setHorizontalParam(value);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        AdapterItemPopupviewVerticalBinding adapterItemPopupviewVerticalBinding = (AdapterItemPopupviewVerticalBinding) onCreateViewHolder.getBinding();
        adapterItemPopupviewVerticalBinding.displaySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$UMZdDLvGppZtdkON2RLqzxOqz-E
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VerticalViewPagerAdapter.this.change(compoundButton, z);
            }
        });
        adapterItemPopupviewVerticalBinding.invertSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$UMZdDLvGppZtdkON2RLqzxOqz-E
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VerticalViewPagerAdapter.this.change(compoundButton, z);
            }
        });
        adapterItemPopupviewVerticalBinding.impedanceSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$UMZdDLvGppZtdkON2RLqzxOqz-E
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VerticalViewPagerAdapter.this.change(compoundButton, z);
            }
        });
        adapterItemPopupviewVerticalBinding.fineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$UMZdDLvGppZtdkON2RLqzxOqz-E
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VerticalViewPagerAdapter.this.change(compoundButton, z);
            }
        });
        adapterItemPopupviewVerticalBinding.labelSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$UMZdDLvGppZtdkON2RLqzxOqz-E
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                VerticalViewPagerAdapter.this.change(compoundButton, z);
            }
        });
        adapterItemPopupviewVerticalBinding.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$zIg4P3V2IRbbezmAAUaKkxdGw08
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VerticalViewPagerAdapter.this.click(view);
            }
        });
        return onCreateViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    public void click(View view) {
        List filter;
        VerticalParam verticalItem = ViewUtil.getVerticalItem((List<VerticalParam>) getItems(), getCurrentItem());
        this.param = verticalItem;
        if (verticalItem == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.scale_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, this.param.getUnit(), this.param.getScaleAttr().getMaxLongValue(), this.param.getScaleAttr().getMinLongValue(), this.param.getScaleAttr().getDefLongValue(), this.param.getScale(), new KeyboardListener() { // from class: com.rigol.scope.adapters.VerticalViewPagerAdapter.1
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        VerticalViewPagerAdapter.this.param.saveScale(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        VerticalViewPagerAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.offset_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, this.param.getUnit(), this.param.getOffsetAttr().getMaxLongValue(), this.param.getOffsetAttr().getMinLongValue(), this.param.getOffsetAttr().getDefLongValue(), this.param.getOffset(), new KeyboardListener() { // from class: com.rigol.scope.adapters.VerticalViewPagerAdapter.2
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        VerticalViewPagerAdapter.this.param.moveOffset(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        VerticalViewPagerAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.position_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, this.param.getUnit(), this.param.getPositionAttr().getMaxLongValue(), this.param.getPositionAttr().getMinLongValue(), this.param.getPositionAttr().getDefLongValue(), this.param.getPosition(), new KeyboardListener() { // from class: com.rigol.scope.adapters.VerticalViewPagerAdapter.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        VerticalViewPagerAdapter.this.param.savePosition(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        VerticalViewPagerAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.delay_edit_text) {
            if (this.aorBManager.setClick_showab(id)) {
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, 100000000L, -100000000L, 0L, this.param.getChanDelay(), new KeyboardListener() { // from class: com.rigol.scope.adapters.VerticalViewPagerAdapter.4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        VerticalViewPagerAdapter.this.param.saveChanDelay(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        VerticalViewPagerAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.coupling_spinner) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_chan_coup), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$7Lh_Xx0S8hCkjtVxlJU7HcaQ0hE
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    VerticalViewPagerAdapter.this.lambda$click$4$VerticalViewPagerAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$IQAHmHyDEXJA32F9AegPDHfN_E4
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    VerticalViewPagerAdapter.this.lambda$click$5$VerticalViewPagerAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.bandwidth_limit_spinner) {
            List<MappingObject> list = ViewUtil.getList((int) R.array.msg_chan_bwlimit);
            int UI_QueryInt32 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_BW);
            long scaleValue = this.param.getScaleValue();
            if (scaleValue <= 200000) {
                filter = KtUtilKt.filter(list, new Function1() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$b-Ghyfd4LQhSQHnMvr6Z-tL7wRM
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean valueOf;
                        MappingObject mappingObject = (MappingObject) obj;
                        valueOf = Boolean.valueOf(r1 == null || r1.getValue() == ServiceEnum.Bandwidth.BW_20M.value1);
                        return valueOf;
                    }
                });
            } else if (scaleValue <= 500000) {
                if (UI_QueryInt32 > ServiceEnum.Bandwidth.BW_250M.value1) {
                    filter = KtUtilKt.filter(list, new Function1() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$fZp4EEKuNQp9QeeGT8Q7MhoToVw
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Boolean valueOf;
                            MappingObject mappingObject = (MappingObject) obj;
                            valueOf = Boolean.valueOf(r1.getValue() <= ServiceEnum.Bandwidth.BW_250M.value1);
                            return valueOf;
                        }
                    });
                } else {
                    filter = KtUtilKt.filter(list, new Function1() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$W-T7wSn5s9V4BrZx-bO9T9ves4I
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Boolean valueOf;
                            MappingObject mappingObject = (MappingObject) obj;
                            valueOf = Boolean.valueOf(r1.getValue() <= ServiceEnum.Bandwidth.BW_20M.value1);
                            return valueOf;
                        }
                    });
                }
            } else if (UI_QueryInt32 > ServiceEnum.Bandwidth.BW_250M.value1) {
                filter = KtUtilKt.filter(list, new Function1() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$5BwQxUzu2N0hy24JsCV_ASWh_y4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean valueOf;
                        MappingObject mappingObject = (MappingObject) obj;
                        valueOf = Boolean.valueOf(r1.getValue() <= ServiceEnum.Bandwidth.BW_250M.value1);
                        return valueOf;
                    }
                });
            } else {
                filter = KtUtilKt.filter(list, new Function1() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$ezx9eEo24XyUW1bvZ_570af-n_Q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Boolean valueOf;
                        MappingObject mappingObject = (MappingObject) obj;
                        valueOf = Boolean.valueOf(r1.getValue() <= ServiceEnum.Bandwidth.BW_20M.value1);
                        return valueOf;
                    }
                });
            }
            ViewUtil.showSpinner(this.anchor, view, filter, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$3wQROlRfMlRGU-7ASuXakG5rsmU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    VerticalViewPagerAdapter.this.lambda$click$11$VerticalViewPagerAdapter(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$PP1dFzUCbfMP1Pit7fTlFktTpY8
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    VerticalViewPagerAdapter.this.lambda$click$12$VerticalViewPagerAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.unit_spinner) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_chan_unit), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$hBU7hJlIoevNXFaYHBFGayC7AKM
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    VerticalViewPagerAdapter.this.lambda$click$13$VerticalViewPagerAdapter(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$dgskbpgFqKcIVZVIVCVhiSfbzBo
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    VerticalViewPagerAdapter.this.lambda$click$14$VerticalViewPagerAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.acquire_btn) {
            PopupViewManager.getInstance().show(HorizontalPopupView.class);
        } else if (id == R.id.trigger_btn) {
            PopupViewManager.getInstance().show(TriggerPopupView.class);
        } else if (id == R.id.measure_btn) {
            PopupViewManager.getInstance().show(MeasurePopupView.class);
        } else if (id == R.id.probe_setting_btn) {
            this.param.readProbeDetail();
            ViewUtil.showSpinner(this.anchor, view, getList(ViewUtil.getList((int) R.array.msg_chan_probe), this.param.getProbeRatioUnit().value2), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$3BNL60tnUpuBjTm1Qu4Y04NTRgU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    VerticalViewPagerAdapter.this.lambda$click$15$VerticalViewPagerAdapter(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$toTPabwwSDxMOc2h8m870Ga6Msk
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    VerticalViewPagerAdapter.this.lambda$click$16$VerticalViewPagerAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.label_edit_text) {
            if (view instanceof TextView) {
                ViewUtil.showPinyinKeyboard(this.context, this.anchor, view, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$AmauAMeQ4D1SOovqYdcS1wElMkM
                    @Override // com.rigol.pinyinkeyboard.ExternalInterface
                    public final void resultShow(String str) {
                        VerticalViewPagerAdapter.this.lambda$click$17$VerticalViewPagerAdapter(str);
                    }
                });
            }
        } else if (id == R.id.scale_left) {
            this.param.scaleLarger(1);
        } else if (id == R.id.scale_right) {
            this.param.scaleSmaller(1);
        } else if (id == R.id.offset_left) {
            this.param.moveOffset(this.param.offsetSmaller(1));
        } else if (id == R.id.offset_right) {
            this.param.moveOffset(this.param.offsetLarger(1));
        } else if (id == R.id.position_left) {
            VerticalParam verticalParam = this.param;
            verticalParam.savePosition(verticalParam.positionSmaller(1));
        } else if (id == R.id.position_right) {
            VerticalParam verticalParam2 = this.param;
            verticalParam2.savePosition(verticalParam2.positionLarger(1));
        } else if (id == R.id.gud_button) {
            if (this.param.getStatus() != ServiceEnum.enChanStatus.CHAN_OFF) {
                if (this.param.readCoupling() == ServiceEnum.Coupling.DC || this.param.readCoupling() == ServiceEnum.Coupling.AC) {
                    if (this.param.getImpedance() != ServiceEnum.Impedance.IMP_50) {
                        this.param.saveCoupling(ServiceEnum.Coupling.GND);
                        return;
                    }
                    return;
                }
                this.param.saveCoupling(ServiceEnum.Coupling.DC);
            }
        } else if (id == R.id.ac_button) {
            if (this.param.getStatus() == ServiceEnum.enChanStatus.CHAN_OFF || this.param.getImpedance() == ServiceEnum.Impedance.IMP_50) {
                return;
            }
            if (this.param.readCoupling() == ServiceEnum.Coupling.DC) {
                this.param.saveCoupling(ServiceEnum.Coupling.AC);
            } else if (this.param.readCoupling() == ServiceEnum.Coupling.GND) {
                this.param.saveCoupling(ServiceEnum.Coupling.AC);
            } else {
                this.param.saveCoupling(ServiceEnum.Coupling.DC);
            }
        } else if (id == R.id.iv_impedance_50) {
        } else {
            if (id == R.id.iv_impedance_1) {
                if (this.param.getStatus() != ServiceEnum.enChanStatus.CHAN_OFF) {
                    this.param.saveImpedance(ServiceEnum.Impedance.IMP_1M);
                }
            } else if (id == R.id.iv_line_impedance_50) {
                if (this.param.getStatus() != ServiceEnum.enChanStatus.CHAN_OFF) {
                    this.param.saveImpedance(ServiceEnum.Impedance.IMP_1M);
                }
            } else if (id != R.id.iv_line_impedance_1 || ViewUtil.serialize == ServiceEnum.ProductSeries.SERIES_1000.value1) {
            } else {
                this.param.getStatus();
                ServiceEnum.enChanStatus enchanstatus = ServiceEnum.enChanStatus.CHAN_OFF;
            }
        }
    }

    public /* synthetic */ void lambda$click$4$VerticalViewPagerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$click$5$VerticalViewPagerAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectCoupling(mappingObject);
    }

    public /* synthetic */ void lambda$click$11$VerticalViewPagerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$click$12$VerticalViewPagerAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectBandWidthLimit(mappingObject);
    }

    public /* synthetic */ void lambda$click$13$VerticalViewPagerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$click$14$VerticalViewPagerAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectUnit(mappingObject);
    }

    public /* synthetic */ void lambda$click$15$VerticalViewPagerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
        this.param.setPopupSpinner(popupSpinner);
    }

    public /* synthetic */ void lambda$click$16$VerticalViewPagerAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectProbeRatio(mappingObject);
    }

    public /* synthetic */ void lambda$click$17$VerticalViewPagerAdapter(String str) {
        this.param.saveLabel(str);
    }

    private void selectUnit(MappingObject mappingObject) {
        ServiceEnum.Unit unitFromValue1 = ServiceEnum.getUnitFromValue1(mappingObject.getValue());
        if (unitFromValue1 == null || this.param == null) {
            return;
        }
        if (unitFromValue1 == ServiceEnum.Unit.Unit_A) {
            this.param.saveProbeRatioUnit(ServiceEnum.Unit.Unit_VdivA);
        } else {
            this.param.saveProbeRatioUnit(ServiceEnum.Unit.Unit_X);
        }
        TriggerParam value = this.triggerViewModel.getLiveData().getValue();
        if (value != null) {
            value.setUnit(unitFromValue1, unitFromValue1.value1);
            this.param.saveUnit(unitFromValue1);
        }
    }

    private void selectBandWidthLimit(MappingObject mappingObject) {
        VerticalParam verticalParam;
        ServiceEnum.Bandwidth bandwidthFromValue1 = ServiceEnum.getBandwidthFromValue1(mappingObject.getValue());
        if (bandwidthFromValue1 == null || (verticalParam = this.param) == null) {
            return;
        }
        verticalParam.saveBandwidth(bandwidthFromValue1);
    }

    private void selectCoupling(MappingObject mappingObject) {
        ServiceEnum.Coupling couplingFromValue1;
        if (this.param == null || mappingObject == null || (couplingFromValue1 = ServiceEnum.getCouplingFromValue1(mappingObject.getValue())) == null) {
            return;
        }
        this.param.saveCoupling(couplingFromValue1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    public void change(View view, boolean z) {
        if (view.isPressed()) {
            VerticalParam verticalItem = ViewUtil.getVerticalItem((List<VerticalParam>) getItems(), getCurrentItem());
            this.param = verticalItem;
            if (verticalItem == null) {
                return;
            }
            if (view.getId() == R.id.display_switch) {
                if (this.param.getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE || this.param.getStatus() == ServiceEnum.enChanStatus.CHAN_ON) {
                    this.param.saveStatus(ServiceEnum.enChanStatus.CHAN_OFF);
                } else {
                    this.param.saveStatus(ServiceEnum.enChanStatus.CHAN_ACTIVE);
                }
                setCurrentItemForce(getCurrentItem());
            } else if (view.getId() == R.id.invert_switch) {
                this.param.saveInvert(z);
            } else if (view.getId() == R.id.impedance_switch) {
                if (z) {
                    this.param.saveCoupling(ServiceEnum.Coupling.DC);
                }
                this.param.saveImpedance(z ? ServiceEnum.Impedance.IMP_50 : ServiceEnum.Impedance.IMP_1M);
            } else if (view.getId() == R.id.fine_switch) {
                this.param.saveFine(z);
            } else if (view.getId() == R.id.label_switch) {
                this.param.saveShowLabel(z);
            }
        }
    }

    public AorBManager getAorBManager(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, final int i) {
        AdapterItemPopupviewVerticalBinding adapterItemPopupviewVerticalBinding = (AdapterItemPopupviewVerticalBinding) baseViewHolder.getBinding();
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AorBParam(adapterItemPopupviewVerticalBinding.scaleEditText, 0, true, ViewUtil.KEY_A, 0));
        arrayList.add(new AorBParam(adapterItemPopupviewVerticalBinding.offsetEditText, 0, true, ViewUtil.KEY_A, 0));
        arrayList.add(new AorBParam(adapterItemPopupviewVerticalBinding.positionEditText, 0, false, ViewUtil.KEY_A, 0));
        arrayList.add(new AorBParam(adapterItemPopupviewVerticalBinding.delayEditText, 0, false, ViewUtil.KEY_A, 0));
        arrayList.add(new AorBParam(adapterItemPopupviewVerticalBinding.unitSpinner, 0, false, "", 2));
        arrayList.add(new AorBParam(adapterItemPopupviewVerticalBinding.couplingSpinner, 0, false, "", 2));
        arrayList.add(new AorBParam(adapterItemPopupviewVerticalBinding.bandwidthLimitSpinner, 0, false, "", 2));
        this.mapList.put(Integer.valueOf(i), arrayList);
        AorBManager aorBManager = new AorBManager(this.context, arrayList, this, this) { // from class: com.rigol.scope.adapters.VerticalViewPagerAdapter.5
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                List list = (List) Objects.requireNonNull((List) VerticalViewPagerAdapter.this.mapList.get(Integer.valueOf(i)));
                showKey(VerticalViewPagerAdapter.this.context, ((AorBParam) list.get(i2)).getEditText(), true, ((AorBParam) list.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                List list = (List) Objects.requireNonNull((List) VerticalViewPagerAdapter.this.mapList.get(Integer.valueOf(i)));
                showKey(VerticalViewPagerAdapter.this.context, ((AorBParam) list.get(i2)).getEditText(), false, ((AorBParam) list.get(i2)).getAorb());
            }
        };
        aorBManager.showKey(this.context, adapterItemPopupviewVerticalBinding.scaleEditText, true, ViewUtil.KEY_A);
        aorBManager.showKey(this.context, adapterItemPopupviewVerticalBinding.offsetEditText, true, ViewUtil.KEY_B);
        this.mapManager.put(Integer.valueOf(i), aorBManager);
        this.adapterInitArr[i] = true;
        return aorBManager;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter
    public void setCurrentItemForce(final int i) {
        this.currentItem = i;
        super.setCurrentItem(i);
        if (this.adapterInitArr[i] && this.mapManager.get(Integer.valueOf(i)) != null) {
            this.aorBManager = this.mapManager.get(Integer.valueOf(i));
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.rigol.scope.adapters.-$$Lambda$VerticalViewPagerAdapter$8ppQ21-wARP70rLnSIw-b3Iu7hA
                @Override // java.lang.Runnable
                public final void run() {
                    VerticalViewPagerAdapter.this.lambda$setCurrentItemForce$18$VerticalViewPagerAdapter(i);
                }
            }, 500L);
        }
        VerticalParam verticalItem = ViewUtil.getVerticalItem((List<VerticalParam>) getItems(), i);
        this.param = verticalItem;
        if (verticalItem.getStatus() == ServiceEnum.enChanStatus.CHAN_OFF) {
            PopupViewManager.getInstance().closeAllLight();
        } else if (this.param.getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE || this.param.getStatus() == ServiceEnum.enChanStatus.CHAN_ON) {
            PopupViewManager.getInstance().setLight(this.aorBManager);
            if (this.param.getStatus() == ServiceEnum.enChanStatus.CHAN_ON) {
                this.param.saveStatus(ServiceEnum.enChanStatus.CHAN_ACTIVE);
            }
        }
    }

    public /* synthetic */ void lambda$setCurrentItemForce$18$VerticalViewPagerAdapter(int i) {
        this.aorBManager = this.mapManager.get(Integer.valueOf(i));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter
    public void setCurrentItem(int i) {
        super.setCurrentItem(i);
        VerticalParam verticalItem = ViewUtil.getVerticalItem((List<VerticalParam>) getItems(), i);
        if (verticalItem != null) {
            verticalItem.turnActive();
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        AdapterItemPopupviewVerticalBinding adapterItemPopupviewVerticalBinding = this.mapBindings.get(Integer.valueOf(getCurrentItem()));
        if (this.param == null || adapterItemPopupviewVerticalBinding == null || !adapterItemPopupviewVerticalBinding.displaySwitch.isChecked()) {
            return;
        }
        switch (i) {
            case R.id.delay_edit_text /* 2131362659 */:
                MessageAttr messageAttr = new MessageAttr();
                messageAttr.setMinValue(-100000000);
                messageAttr.setMaxValue(100000000);
                messageAttr.setDefValue(0);
                messageAttr.setStepValue(10000L);
                VerticalParam verticalParam = this.param;
                verticalParam.saveChanDelay(verticalParam.getLongStep(verticalParam.getChanDelay(), messageAttr, z, keyEvent));
                return;
            case R.id.offset_edit_text /* 2131363501 */:
                if (z) {
                    offsetUp();
                    return;
                } else {
                    offsetDown();
                    return;
                }
            case R.id.position_edit_text /* 2131363617 */:
                if (z) {
                    positionUp();
                    return;
                } else {
                    positionDown();
                    return;
                }
            case R.id.scale_edit_text /* 2131363795 */:
                if (z) {
                    this.param.scaleSmaller(1);
                    return;
                } else {
                    this.param.scaleLarger(1);
                    return;
                }
            default:
                return;
        }
    }

    private void positionUp() {
        VerticalParam verticalParam = this.param;
        verticalParam.savePosition(verticalParam.positionLarger(1));
    }

    private void positionDown() {
        VerticalParam verticalParam = this.param;
        verticalParam.savePosition(verticalParam.positionSmaller(1));
    }

    private void offsetUp() {
        this.param.moveOffset(this.param.offsetLarger(1));
    }

    private void offsetDown() {
        this.param.moveOffset(this.param.offsetSmaller(1));
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        VerticalParam verticalParam = this.param;
        if (verticalParam == null) {
            return;
        }
        switch (i) {
            case R.id.delay_edit_text /* 2131362659 */:
                MessageAttr messageAttr = new MessageAttr();
                messageAttr.setMinValue(-100000000);
                messageAttr.setMaxValue(100000000);
                messageAttr.setDefValue(0);
                messageAttr.setStepValue(10000L);
                VerticalParam verticalParam2 = this.param;
                verticalParam2.saveChanDelay(verticalParam2.getLongDef(messageAttr));
                return;
            case R.id.offset_edit_text /* 2131363501 */:
                verticalParam.moveOffset(verticalParam.getLongDef(verticalParam.getOffsetAttr()));
                return;
            case R.id.position_edit_text /* 2131363617 */:
                verticalParam.savePosition(verticalParam.getLongDef(verticalParam.getPositionAttr()));
                return;
            case R.id.scale_edit_text /* 2131363795 */:
                verticalParam.saveScale(verticalParam.getLongDef(verticalParam.getScaleAttr()));
                return;
            default:
                return;
        }
    }

    public List<MappingObject> getList(List<MappingObject> list, String str) {
        ArrayList arrayList = new ArrayList();
        ServiceEnum.Unit probeRatioUnit = this.param.getProbeRatioUnit();
        for (MappingObject mappingObject : list) {
            if (probeRatioUnit != ServiceEnum.Unit.Unit_VdivA || mappingObject.getValue() <= ServiceEnum.ProbeX.Probe_10X.value1) {
                String str2 = mappingObject.getStr();
                if (str2.contains(ServiceEnum.Unit.Unit_X.value2)) {
                    str2 = str2.replace(ServiceEnum.Unit.Unit_X.value2, "");
                } else if (str2.contains(ServiceEnum.Unit.Unit_VdivA.value2)) {
                    str2 = str2.replace(ServiceEnum.Unit.Unit_VdivA.value2, "");
                }
                mappingObject.setStr(str2 + str);
                arrayList.add(mappingObject);
            }
        }
        return arrayList;
    }

    private void selectProbeRatio(MappingObject mappingObject) {
        ServiceEnum.ProbeX probeXFromValue1 = ServiceEnum.getProbeXFromValue1(mappingObject.getValue());
        if (probeXFromValue1 == null || !this.param.getProbeRatioEnable()) {
            return;
        }
        this.param.saveProbeRatio(probeXFromValue1);
    }
}
