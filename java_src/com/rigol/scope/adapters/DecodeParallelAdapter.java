package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeParallelBinding;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DecodeParallelAdapter extends RecyclerView.Adapter<DecodeParallelHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecodeParallelBinding binding;
    private View clickedView;
    private final Context context;
    private KeyboardPopupView keyboardPopupView;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private DecodeParam param;
    private PopupSpinner popupSpinner;
    private PopupviewDecodeBinding popupviewDecodeBinding;
    private SpinnerAdapter spinnerAdapter;
    private DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private boolean isMove = false;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public DecodeParallelAdapter(View view, DecodeParam decodeParam, Context context) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
    }

    public DecodeParallelAdapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeParallelHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeParallelBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeParallelHolder(this.binding);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeParallelHolder decodeParallelHolder, int i) {
        this.binding.decodePalClkValue.setOnClickListener(this);
        this.binding.decodePalClkEdgeRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodePalBusValue.setOnClickListener(this);
        this.binding.decodeBusChValue.setOnClickListener(this);
        this.binding.decodePalThresValue.setOnClickListener(this);
        this.binding.decodeBusWidthValue.setOnClickListener(this);
        this.binding.decodePalDatThresValue.setOnClickListener(this);
        this.binding.decodePalPolarityRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodePalEndianRadioGroup.setOnCheckedChangeListener(this);
        this.binding.bitZero.setOnClickListener(this);
        this.binding.bitOne.setOnClickListener(this);
        this.binding.bitTwo.setOnClickListener(this);
        this.binding.bitThree.setOnClickListener(this);
        ViewUtil.setSwitchButton(this.binding.decodeNoiseSwitch);
        this.binding.decodeNoiseSwitch.setOnCheckedChangeListener(this);
        this.binding.decodePalNrjtimeValue.setOnClickListener(this);
        this.param.readPal_Nrj();
        this.param.readPal_Clk();
        this.param.readPal_ClkEdge();
        this.param.readPal_bus();
        this.param.readPalBus_width();
        this.param.readPal_Endian();
        this.param.readPal_Polarity();
        this.param.readRejectTime();
        this.param.readPalBus_bitx();
        this.param.readPalBus_width();
        this.param.readPalBus_chan();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_PAL_CLK_THRE) != this.param.getPal_clk_thres()) {
            this.param.readPal_clk_thres();
        }
        DecodeParam decodeParam2 = this.param;
        if (decodeParam2.getDecodeThres(decodeParam2.getServiceId(), MessageID.MSG_DECODE_PAL_DAT_THRE) != this.param.getPal_dat_thres()) {
            this.param.readPal_dat_thres();
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodePalDatThresValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodePalThresValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeBusWidthValue, 0, false, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodePalNrjtimeValue, 0, false, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodePalClkValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodePalBusValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.bitZero, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.DecodeParallelAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(DecodeParallelAdapter.this.context, ((AorBParam) DecodeParallelAdapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) DecodeParallelAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(DecodeParallelAdapter.this.context, ((AorBParam) DecodeParallelAdapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) DecodeParallelAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decodePalDatThresValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.decodePalThresValue, true, ViewUtil.KEY_B);
        this.aorBManager.aorBParam_a = 0;
        this.aorBManager.aorBParam_b = 1;
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        this.param.setAorBManager(this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$eOzScYzkNxqCxopUmpEbnagTcA0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeParallelAdapter.this.lambda$onBindViewHolder$2$DecodeParallelAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        this.binding.setParam(this.param);
        ShowParallelClk(this.param.getPal_clk());
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DecodeParallelAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$15DmdTznIM867YGL0lNFv94UipU
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeParallelAdapter.this.lambda$onBindViewHolder$0$DecodeParallelAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$CNYW0DjyKC02NgzagzZrZN_etlA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeParallelAdapter.this.lambda$onBindViewHolder$1$DecodeParallelAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DecodeParallelAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DecodeParallelAdapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.bit_zero /* 2131362041 */:
                this.param.saveBus_bitx(mappingObject.getValue());
                return;
            case R.id.decode_bus_ch_value /* 2131362400 */:
                selectChValue(mappingObject);
                return;
            case R.id.decode_pal_bus_value /* 2131362525 */:
                selectPalBusSpinner(mappingObject);
                return;
            case R.id.decode_pal_clk_value /* 2131362529 */:
                selectClkValue(mappingObject);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_pal_clk_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_pal_clk)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$8zWGqavMgCMqS3tPiB9SHRcVnsI
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeParallelAdapter.this.lambda$onClick$3$DecodeParallelAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$7KBAw0qVj0_gbXuEKSRZIdhMYVI
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeParallelAdapter.this.lambda$onClick$4$DecodeParallelAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_pal_bus_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_pal_bus)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$B-eAs-CN5slLHkzmx4d8oMq8Za4
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeParallelAdapter.this.lambda$onClick$5$DecodeParallelAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$sj_anqkGsUeBElQwlP2UfvzOr0o
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeParallelAdapter.this.lambda$onClick$6$DecodeParallelAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_bus_ch_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_bus_ch)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$9bI1SzxJZCtXQ4YA_tQ5JLO_Xvw
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeParallelAdapter.this.lambda$onClick$7$DecodeParallelAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$z9NUgXl2OnoazRYM_orMPnr4-lE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeParallelAdapter.this.lambda$onClick$8$DecodeParallelAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_pal_thres_value) {
            if (this.aorBManager.setClick_showab_textview(id)) {
                this.param.readPal_clk_thres();
                this.param.readPalClkThresAttr();
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getPalClkThresAttr().getMaxLongValue(), this.param.getPalClkThresAttr().getMinLongValue(), this.param.getPalClkThresAttr().getDefLongValue(), this.param.getPal_clk_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeParallelAdapter.2
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeParallelAdapter.this.param.savePal_clk_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeParallelAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.bit_zero) {
            this.param.readBusWidthAttr();
            List<MappingObject> filterChan = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_bus_bitx));
            final ArrayList arrayList = new ArrayList();
            arrayList.addAll(filterChan.subList(0, this.param.getBus_width()));
            ViewUtil.showSpinner(this.anchorView, view, arrayList, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$t4MqhMsP5GUgA1a6WtcW5SBloEQ
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeParallelAdapter.this.lambda$onClick$9$DecodeParallelAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeParallelAdapter$-x21e9xeGmcbIDOwQMyMTsYgmI8
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeParallelAdapter.this.lambda$onClick$10$DecodeParallelAdapter(arrayList, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.bit_one) {
            this.param.saveBus_bitx(1);
        } else if (id == R.id.bit_two) {
            this.param.saveBus_bitx(2);
        } else if (id == R.id.bit_three) {
            this.param.saveBus_bitx(3);
        } else if (id == R.id.decode_bus_width_value) {
            if (this.aorBManager.setClick_showab_textview(id)) {
                this.param.readBusWidthAttr();
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_number, this.param.getBusWidthAttr().getMaxIntValue(), this.param.getBusWidthAttr().getMinIntValue(), this.param.getBusWidthAttr().getDefIntValue(), this.param.readPalBus_width(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeParallelAdapter.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeParallelAdapter.this.param.saveBus_width(((Long) t).intValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeParallelAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_pal_dat_thres_value) {
            if (this.aorBManager.setClick_showab_textview(id)) {
                this.param.readPal_dat_thres();
                this.param.readPalBusThresAttr();
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_V, this.param.getPalBusThresAttr().getMaxLongValue(), this.param.getPalBusThresAttr().getMinLongValue(), this.param.getPalBusThresAttr().getDefLongValue(), this.param.getPal_dat_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeParallelAdapter.4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeParallelAdapter.this.param.savePal_dat_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeParallelAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_pal_nrjtime_value && this.aorBManager.setClick_showab_textview(id)) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_s, this.param.getRejectTimeAttr().getMaxLongValue(), this.param.getRejectTimeAttr().getMinLongValue(), this.param.getRejectTimeAttr().getDefLongValue(), this.param.getRejectTime(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeParallelAdapter.5
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeParallelAdapter.this.param.saveRejectTime(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeParallelAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$DecodeParallelAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$DecodeParallelAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectClkValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$DecodeParallelAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DecodeParallelAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectPalBusSpinner(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$DecodeParallelAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$DecodeParallelAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectChValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$DecodeParallelAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$DecodeParallelAdapter(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveBus_bitx(((MappingObject) list.get(i)).getValue());
    }

    private void selectChValue(MappingObject mappingObject) {
        DecodeParam decodeParam = this.param;
        if (decodeParam != null) {
            decodeParam.saveBus_chan(mappingObject.getValue());
        }
    }

    private void selectClkValue(MappingObject mappingObject) {
        DecodeParam decodeParam = this.param;
        if (decodeParam != null) {
            decodeParam.readPal_clk_thres();
            this.param.readPalClkThresAttr();
            this.param.savePal_clk(mappingObject.getValue());
        }
        PopupViewManager.getInstance().decodeLightType();
    }

    private void selectPalBusSpinner(MappingObject mappingObject) {
        if (this.param != null) {
            if (mappingObject.getValue() == 11) {
                DecodeParam decodeParam = this.param;
                decodeParam.setBus_chan(decodeParam.getPal_bus());
            } else {
                this.param.saveBus_chan(mappingObject.getValue());
            }
            this.param.savePal_bus(mappingObject.getValue());
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (compoundButton.isPressed() && id == R.id.decode_noise_switch) {
            this.param.saveNoiseProject(z);
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.findViewById(i).isPressed()) {
            if (i == R.id.decode_pal_up_radioButton) {
                this.param.savePal_clk_edge(0);
            } else if (i == R.id.decode_pal_down_radioButton) {
                this.param.savePal_clk_edge(1);
            } else if (i == R.id.decode_pal_updown_radioButton) {
                this.param.savePal_clk_edge(2);
            } else if (i == R.id.decode_pal_positive_radioButton) {
                this.param.savePolarity(true);
            } else if (i == R.id.decode_pal_negative_radioButton) {
                this.param.savePolarity(false);
            } else if (i == R.id.decode_pal_normal_radioButton) {
                this.param.savePal_endian(true);
            } else if (i == R.id.decode_pal_invert_radioButton) {
                this.param.savePal_endian(false);
            }
        }
    }

    public void ShowParallelClk(int i) {
        if (i == 0) {
            this.binding.decodePalThresLabel.setVisibility(8);
            this.binding.decodePalThresValue.setVisibility(8);
            this.binding.decodePalClkEdgeLabel.setVisibility(8);
            this.binding.decodePalClkEdgeRadioGroup.setVisibility(8);
            return;
        }
        this.binding.decodePalThresLabel.setVisibility(0);
        this.binding.decodePalThresValue.setVisibility(0);
        this.binding.decodePalClkEdgeRadioGroup.setVisibility(0);
        this.binding.decodePalClkEdgeLabel.setVisibility(0);
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        switch (i) {
            case R.id.decode_bus_width_value /* 2131362402 */:
                this.param.readBusWidthAttr();
                DecodeParam decodeParam = this.param;
                decodeParam.saveBus_width(decodeParam.getIntStep(decodeParam.getBus_width(), this.param.getBusWidthAttr(), z, keyEvent));
                return;
            case R.id.decode_pal_dat_thres_value /* 2131362531 */:
                this.param.readPalBusThresAttr();
                DecodeParam decodeParam2 = this.param;
                decodeParam2.savePal_dat_thres(decodeParam2.getLongStep(decodeParam2.getPal_dat_thres(), this.param.getPalBusThresAttr(), z, keyEvent));
                return;
            case R.id.decode_pal_nrjtime_value /* 2131362539 */:
                DecodeParam decodeParam3 = this.param;
                decodeParam3.saveRejectTime(decodeParam3.getLongStep(decodeParam3.getRejectTime(), this.param.getRejectTimeAttr(), z, keyEvent));
                return;
            case R.id.decode_pal_thres_value /* 2131362544 */:
                this.param.readPalClkThresAttr();
                DecodeParam decodeParam4 = this.param;
                decodeParam4.savePal_clk_thres(decodeParam4.getLongStep(decodeParam4.getPal_clk_thres(), this.param.getPalClkThresAttr(), z, keyEvent));
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        switch (i) {
            case R.id.decode_bus_width_value /* 2131362402 */:
                MessageAttr messageAttr = new MessageAttr();
                messageAttr.setMaxValue(4);
                messageAttr.setMinValue(1);
                messageAttr.setDefValue(1);
                messageAttr.setStepValue(1L);
                DecodeParam decodeParam = this.param;
                decodeParam.saveBus_width(decodeParam.getIntDef(messageAttr));
                return;
            case R.id.decode_pal_dat_thres_value /* 2131362531 */:
                this.param.readPalBusThresAttr();
                DecodeParam decodeParam2 = this.param;
                decodeParam2.savePal_dat_thres(decodeParam2.getLongDef(decodeParam2.getPalBusThresAttr()));
                return;
            case R.id.decode_pal_nrjtime_value /* 2131362539 */:
                DecodeParam decodeParam3 = this.param;
                decodeParam3.saveRejectTime(decodeParam3.getLongDef(decodeParam3.getRejectTimeAttr()));
                return;
            case R.id.decode_pal_thres_value /* 2131362544 */:
                this.param.readPalClkThresAttr();
                DecodeParam decodeParam4 = this.param;
                decodeParam4.savePal_clk_thres(decodeParam4.getLongDef(decodeParam4.getPalClkThresAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeParallelHolder extends RecyclerView.ViewHolder {
        public DecodeParallelHolder(AdapterDecodeParallelBinding adapterDecodeParallelBinding) {
            super(adapterDecodeParallelBinding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
