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
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeRs232Binding;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DecodeRs232Adapter extends RecyclerView.Adapter<DecodeRs232Holder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener, View.OnLongClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecodeRs232Binding binding;
    private View clickedView;
    private final Context context;
    private KeyboardPopupView keyboardPopupView;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private final DecodeParam param;
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

    public DecodeRs232Adapter(View view, DecodeParam decodeParam, Context context) {
        this.context = context;
        this.param = decodeParam;
        this.anchorView = view;
    }

    public DecodeRs232Adapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.context = context;
        this.param = decodeParam;
        this.anchorView = view;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeRs232Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeRs232Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeRs232Holder(this.binding);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeRs232Holder decodeRs232Holder, int i) {
        this.binding.setPositiveMapping(ViewUtil.getMappingObject(R.array.msg_decode_rs232_pol, 1));
        this.binding.setNegativeMapping(ViewUtil.getMappingObject(R.array.msg_decode_rs232_pol, 0));
        ViewUtil.setSwitchButton(this.binding.decodeRs232PackenValue);
        this.binding.decodeRs232TxValue.setOnClickListener(this);
        this.binding.decodeRs232RxValue.setOnClickListener(this);
        this.binding.decodeRs232BaudValue.setOnClickListener(this);
        this.binding.decodeRs232BaudValue.setOnLongClickListener(this);
        this.binding.decodeRs232WidthValue.setOnClickListener(this);
        this.binding.decodeRs232ParityValue.setOnClickListener(this);
        this.binding.decodeRs232StopValue.setOnClickListener(this);
        this.binding.decodeRs232EndianValue.setOnClickListener(this);
        this.binding.decodeRs232PackenValue.setOnCheckedChangeListener(this);
        this.binding.decodeRs232PolRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeRs232PackendValue.setOnClickListener(this);
        this.binding.decodeRxThresValue.setOnClickListener(this);
        this.binding.decodeTxThresValue.setOnClickListener(this);
        this.param.readRs232_rx();
        this.param.readRs232_tx();
        this.param.readRs232_pol();
        this.param.readRs232_baud();
        this.param.readRs232_width();
        this.param.readRs232_parity();
        this.param.readRs232_stop();
        this.param.readRs232_endian();
        this.param.readRs232_package();
        this.param.readRs232_package_end();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_TX_THRE) != this.param.getRs232_tx_thres()) {
            this.param.readRs232_tx_thres();
        }
        DecodeParam decodeParam2 = this.param;
        if (decodeParam2.getDecodeThres(decodeParam2.getServiceId(), MessageID.MSG_DECODE_RX_THRE) != this.param.getRs232_rx_thres()) {
            this.param.readRs232_rx_thres();
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodeTxThresValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRxThresValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRs232TxValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRs232RxValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRs232BaudValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRs232WidthValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRs232ParityValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRs232StopValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRs232EndianValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeRs232PackendValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.DecodeRs232Adapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(DecodeRs232Adapter.this.context, ((AorBParam) DecodeRs232Adapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) DecodeRs232Adapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(DecodeRs232Adapter.this.context, ((AorBParam) DecodeRs232Adapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) DecodeRs232Adapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decodeTxThresValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.decodeRxThresValue, true, ViewUtil.KEY_B);
        this.aorBManager.aorBParam_a = 0;
        this.aorBManager.aorBParam_b = 1;
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$hFEwBaeyh-UzBgD037yXlz-Ld_Q
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeRs232Adapter.this.lambda$onBindViewHolder$2$DecodeRs232Adapter((KeyEvent) obj);
                    }
                });
            }
        }
        this.binding.setParam(this.param);
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DecodeRs232Adapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$LZnxqcnvE70ckaWqSb9uK7UUdyI
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeRs232Adapter.this.lambda$onBindViewHolder$0$DecodeRs232Adapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$62zkPevvP_hZjPEq9Zje8QjUeHs
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeRs232Adapter.this.lambda$onBindViewHolder$1$DecodeRs232Adapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DecodeRs232Adapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DecodeRs232Adapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.decode_rs232_endian_value /* 2131362551 */:
                selectEndianValue(i);
                return;
            case R.id.decode_rs232_packend_value /* 2131362558 */:
                selectPackendValue(mappingObject);
                return;
            case R.id.decode_rs232_parity_value /* 2131362560 */:
                selectParityValue(i);
                return;
            case R.id.decode_rs232_rx_value /* 2131362564 */:
                selectRxValue(mappingObject);
                return;
            case R.id.decode_rs232_stop_value /* 2131362566 */:
                selectStopValue(mappingObject);
                return;
            case R.id.decode_rs232_tx_value /* 2131362568 */:
                selectTxValue(mappingObject);
                return;
            case R.id.decode_rs232_width_value /* 2131362570 */:
                selectWidthValue(mappingObject);
                return;
            default:
                return;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        int id = view.getId();
        if (id == R.id.decode_rs232_tx_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(this.param.getTxChanList()), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$V9_nRSEmauvq_8irl7atRtAJIfI
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRs232Adapter.this.lambda$onClick$3$DecodeRs232Adapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$se2gRAmbNKPUMNaxdxv94zYQCXw
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRs232Adapter.this.lambda$onClick$4$DecodeRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_rs232_rx_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(this.param.getRxChanList()), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$lbVjl49XyYeHAwY64AJQjERGrDY
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRs232Adapter.this.lambda$onClick$5$DecodeRs232Adapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$M5o3gfUJiJ9P5U7qJhahja3Dtqk
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRs232Adapter.this.lambda$onClick$6$DecodeRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_rs232_baud_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_rs232_baud), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$AW3HIVXfANSTzITOUWwJS23EY7M
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRs232Adapter.this.lambda$onClick$7$DecodeRs232Adapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$HAxH81gpRmwd3CXq2Rz2uYlO7YQ
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRs232Adapter.this.lambda$onClick$8$DecodeRs232Adapter(view, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_rs232_width_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_rs232_width), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$AMZ7ejrW11OQuydJvf9V3DB2QWU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRs232Adapter.this.lambda$onClick$9$DecodeRs232Adapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$0oA7g2lnHM0_H7H3TFA3Yl3KyRc
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRs232Adapter.this.lambda$onClick$10$DecodeRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_rs232_parity_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_rs232_parity), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$zXDHRQwPbqfDPMAzRhzsszvc5PU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRs232Adapter.this.lambda$onClick$11$DecodeRs232Adapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$563gXoYBB2KnvJols6_c97m5JhE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRs232Adapter.this.lambda$onClick$12$DecodeRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_rs232_stop_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_rs232_stop), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$YU5FGbKlrNMbj2vMWN_Dswvb3mo
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRs232Adapter.this.lambda$onClick$13$DecodeRs232Adapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$GcJUaMT1hBE6ayDssgDRuT-VHDk
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRs232Adapter.this.lambda$onClick$14$DecodeRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_rs232_endian_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_rs232_endian), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$nz8AdOdoUaJqYLNodzy4YdgxDsM
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRs232Adapter.this.lambda$onClick$15$DecodeRs232Adapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$F_FzDiXJVnGwlBOQQbphHW68gJE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRs232Adapter.this.lambda$onClick$16$DecodeRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_rs232_packend_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_rs232_packend), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$XRUbyVvcztQ-hNw9aqPO0NpjAaA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRs232Adapter.this.lambda$onClick$17$DecodeRs232Adapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeRs232Adapter$D64b9ycbKEiF5kA_KEZ-Be9mCII
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRs232Adapter.this.lambda$onClick$18$DecodeRs232Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_rx_thres_value) {
            this.param.readRs232_rx_thres();
            this.param.readRxThresAttr();
            if (this.aorBManager.setClick_showab_textview(id)) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getRxThresAttr().getMaxLongValue(), this.param.getRxThresAttr().getMinLongValue(), this.param.getRxThresAttr().getDefLongValue(), this.param.getRs232_rx_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeRs232Adapter.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeRs232Adapter.this.param.saveRs232_rx_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeRs232Adapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_tx_thres_value && this.aorBManager.setClick_showab_textview(id)) {
            this.param.readRs232_tx_thres();
            this.param.readTxThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getTxThresAttr().getMaxLongValue(), this.param.getTxThresAttr().getMinLongValue(), this.param.getTxThresAttr().getDefLongValue(), this.param.getRs232_tx_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeRs232Adapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeRs232Adapter.this.param.saveRs232_tx_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeRs232Adapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$DecodeRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$DecodeRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectTxValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$DecodeRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DecodeRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectRxValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$DecodeRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$DecodeRs232Adapter(View view, View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (mappingObject.getValue() != 0) {
            this.param.saveRs232_baud(mappingObject.getValue());
            return;
        }
        DecodeParam decodeParam = this.param;
        decodeParam.setRs232_baud(decodeParam.getRs232_baud());
        ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getRs232BaudAttr().getMaxIntValue(), this.param.getRs232BaudAttr().getMinIntValue(), this.param.getRs232BaudAttr().getDefIntValue(), this.param.getRs232_baud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeRs232Adapter.2
            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public <T> void resultMinUnitValueListener(T t) {
                DecodeRs232Adapter.this.param.saveRs232_baud(((Long) t).intValue());
            }

            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public void onCall(KeyboardPopupView keyboardPopupView) {
                DecodeRs232Adapter.this.keyboardPopupView = keyboardPopupView;
            }
        });
    }

    public /* synthetic */ void lambda$onClick$9$DecodeRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$DecodeRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectWidthValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$11$DecodeRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$12$DecodeRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectParityValue(i);
    }

    public /* synthetic */ void lambda$onClick$13$DecodeRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$14$DecodeRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectStopValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$15$DecodeRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$16$DecodeRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectEndianValue(i);
    }

    public /* synthetic */ void lambda$onClick$17$DecodeRs232Adapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$18$DecodeRs232Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectPackendValue(mappingObject);
    }

    private void selectPackendValue(MappingObject mappingObject) {
        this.param.saveRs232_package_end(mappingObject.getValue());
    }

    private void selectEndianValue(int i) {
        this.param.saveRs232_endian(i == 1);
    }

    private void selectStopValue(MappingObject mappingObject) {
        this.param.saveRs232_stop(mappingObject.getValue());
    }

    private void selectParityValue(int i) {
        this.param.saveRs232_parity(i);
    }

    private void selectWidthValue(MappingObject mappingObject) {
        this.param.saveRs232_width(mappingObject.getValue());
    }

    private void selectRxValue(MappingObject mappingObject) {
        this.param.saveRs232_rx(mappingObject.getValue());
        PopupViewManager.getInstance().decodeLightType();
    }

    private void selectTxValue(MappingObject mappingObject) {
        this.param.saveRs232_tx(mappingObject.getValue());
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && compoundButton.getId() == R.id.decode_rs232_packen_value) {
            this.param.saveRs232_package(z);
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.findViewById(i).isPressed()) {
            if (i == R.id.decode_rs232_invert_radioButton) {
                this.param.saveRs232_pol(true);
            } else if (i == R.id.decode_rs232_negative_radioButton) {
                this.param.saveRs232_pol(false);
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.decode_rs232_baud_value) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getRs232BaudAttr().getMaxIntValue(), this.param.getRs232BaudAttr().getMinIntValue(), this.param.getRs232BaudAttr().getDefIntValue(), this.param.getRs232_baud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeRs232Adapter.5
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeRs232Adapter.this.param.saveRs232_baud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeRs232Adapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
        return true;
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        if (i != R.id.decode_rx_thres_value) {
            if (i == R.id.decode_tx_thres_value && this.param.getRs232_tx() < 8) {
                this.param.readRs232_tx_thres();
                this.param.readTxThresAttr();
                DecodeParam decodeParam = this.param;
                decodeParam.saveRs232_tx_thres(decodeParam.getLongStep(decodeParam.getRs232_tx_thres(), this.param.getTxThresAttr(), z, keyEvent));
            }
        } else if (this.param.getRs232_rx() < 8) {
            this.param.readRs232_rx_thres();
            this.param.readRxThresAttr();
            DecodeParam decodeParam2 = this.param;
            decodeParam2.saveRs232_rx_thres(decodeParam2.getLongStep(decodeParam2.getRs232_rx_thres(), this.param.getRxThresAttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        if (i == R.id.decode_rx_thres_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_RX_THRE);
            this.param.readRs232_rx_thres();
            this.param.readRxThresAttr();
            DecodeParam decodeParam = this.param;
            decodeParam.saveRs232_rx_thres(decodeParam.getLongDef(decodeParam.getRxThresAttr()));
        } else if (i != R.id.decode_tx_thres_value) {
        } else {
            this.param.readRs232_tx_thres();
            this.param.readTxThresAttr();
            DecodeParam decodeParam2 = this.param;
            decodeParam2.saveRs232_tx_thres(decodeParam2.getLongDef(decodeParam2.getTxThresAttr()));
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeRs232Holder extends RecyclerView.ViewHolder {
        public DecodeRs232Holder(AdapterDecodeRs232Binding adapterDecodeRs232Binding) {
            super(adapterDecodeRs232Binding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
