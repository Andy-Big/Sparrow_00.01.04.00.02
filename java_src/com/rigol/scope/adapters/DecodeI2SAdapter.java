package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeI2sBinding;
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
public class DecodeI2SAdapter extends RecyclerView.Adapter<DecodeI2SHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecodeI2sBinding binding;
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

    public DecodeI2SAdapter(View view, DecodeParam decodeParam, Context context) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
    }

    public DecodeI2SAdapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeI2SHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeI2sBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeI2SHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeI2SHolder decodeI2SHolder, int i) {
        this.binding.setEdgeUpMapping(ViewUtil.getMappingObject(R.array.msg_decode_i2s_sclkedge, 0));
        this.binding.setEdgeDownMapping(ViewUtil.getMappingObject(R.array.msg_decode_i2s_sclkedge, 1));
        this.binding.setEndianMsbMapping(ViewUtil.getMappingObject(R.array.msg_decode_i2s_endian, 0));
        this.binding.setEndianLsbMapping(ViewUtil.getMappingObject(R.array.msg_decode_i2s_endian, 1));
        this.binding.setDataNegativeMapping(ViewUtil.getMappingObject(R.array.msg_decode_i2s_pol, 0));
        this.binding.setDataPositiveMapping(ViewUtil.getMappingObject(R.array.msg_decode_i2s_pol, 1));
        this.binding.decodeI2sSclkValue.setOnClickListener(this);
        this.binding.decodeI2sSclkThresValue.setOnClickListener(this);
        this.binding.decodeI2sWsValue.setOnClickListener(this);
        this.binding.decodeI2sWsThresValue.setOnClickListener(this);
        this.binding.decodeI2sDataValue.setOnClickListener(this);
        this.binding.decodeI2sDataThresValue.setOnClickListener(this);
        this.binding.decodeI2sSclkedgeRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeI2sWordValue.setOnClickListener(this);
        this.binding.decodeI2sReceiveValue.setOnClickListener(this);
        this.binding.decodeI2sEndianRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeI2sAlignValue.setOnClickListener(this);
        this.binding.decodeI2sWslowValue.setOnClickListener(this);
        this.binding.decodeI2sPolRadioGroup.setOnCheckedChangeListener(this);
        this.param.readI2s_sclock();
        this.param.readI2s_ws();
        this.param.readI2s_data();
        this.param.readI2s_word();
        this.param.readI2s_align();
        this.param.readI2s_ws_low();
        this.param.readI2s_word();
        this.param.readI2s_receive();
        this.param.readI2s_sclock_edge();
        this.param.readI2s_endian();
        this.param.readI2s_data_polarity();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_I2S_SCLK_THRE) != this.param.getI2s_sclock_thres()) {
            this.param.readI2s_sclock_thres();
        }
        DecodeParam decodeParam2 = this.param;
        if (decodeParam2.getDecodeThres(decodeParam2.getServiceId(), MessageID.MSG_DECODE_I2S_WS_THRE) != this.param.getI2s_wave_singal_thres()) {
            this.param.readI2s_wave_singal_thres();
        }
        DecodeParam decodeParam3 = this.param;
        if (decodeParam3.getDecodeThres(decodeParam3.getServiceId(), MessageID.MSG_DECODE_I2S_DATA_THRE) != this.param.getI2s_data_thres()) {
            this.param.readI2s_data_thres();
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sSclkThresValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sWsThresValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sDataThresValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sReceiveValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sWordValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sSclkValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sWsValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sDataValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sAlignValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2sWslowValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.DecodeI2SAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(DecodeI2SAdapter.this.context, ((AorBParam) DecodeI2SAdapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) DecodeI2SAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(DecodeI2SAdapter.this.context, ((AorBParam) DecodeI2SAdapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) DecodeI2SAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decodeI2sSclkThresValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.decodeI2sWsThresValue, true, ViewUtil.KEY_B);
        this.aorBManager.aorBParam_a = 0;
        this.aorBManager.aorBParam_b = 1;
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$nCnBYK9L8vdcKGD51eIQBy-O-lA
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeI2SAdapter.this.lambda$onBindViewHolder$2$DecodeI2SAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        this.binding.setParam(this.param);
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DecodeI2SAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$_E3YJJsyRsWl2zjtvriRJDGEcWg
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeI2SAdapter.this.lambda$onBindViewHolder$0$DecodeI2SAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$rW1UAdp-o-EHK8z8HCr6wamz6AA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeI2SAdapter.this.lambda$onBindViewHolder$1$DecodeI2SAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DecodeI2SAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DecodeI2SAdapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.decode_i2s_align_value /* 2131362463 */:
                selectAlignValue(i);
                return;
            case R.id.decode_i2s_data_value /* 2131362467 */:
                selectDataValue(mappingObject);
                return;
            case R.id.decode_i2s_sclk_value /* 2131362482 */:
                selectSclkValue(mappingObject);
                return;
            case R.id.decode_i2s_ws_value /* 2131362492 */:
                selectWSValue(mappingObject);
                return;
            case R.id.decode_i2s_wslow_value /* 2131362494 */:
                selectWslowValue(i);
                return;
            default:
                return;
        }
    }

    private void selectWslowValue(int i) {
        this.param.saveI2s_ws_low(i);
    }

    private void selectAlignValue(int i) {
        this.param.saveI2s_align(i);
    }

    private void selectDataValue(MappingObject mappingObject) {
        this.param.saveI2s_data(mappingObject.getValue());
    }

    private void selectWSValue(MappingObject mappingObject) {
        this.param.saveI2s_ws(mappingObject.getValue());
    }

    private void selectSclkValue(MappingObject mappingObject) {
        this.param.saveI2s_sclock(mappingObject.getValue());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_i2s_sclk_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_i2s_sclk)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$Hqj321oeJgP6OGAVUfw7QVxxV6Q
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeI2SAdapter.this.lambda$onClick$3$DecodeI2SAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$grlow_lhETfEZ1o-PrYW66XgYps
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeI2SAdapter.this.lambda$onClick$4$DecodeI2SAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_i2s_sclk_thres_value) {
            this.param.readI2s_sclock_thres();
            this.param.readI2sSclkThresAttr();
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getI2sSclkThresAttr().getMaxLongValue(), this.param.getI2sSclkThresAttr().getMinLongValue(), this.param.getI2sSclkThresAttr().getDefLongValue(), this.param.getI2s_sclock_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeI2SAdapter.2
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeI2SAdapter.this.param.saveI2s_sclock_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeI2SAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_i2s_ws_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_i2s_ws)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$F7YpsBv9cvw8iGYFHceZ-GWuw7E
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeI2SAdapter.this.lambda$onClick$5$DecodeI2SAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$QGXfvhSkd8Fg2qwRQc-2_CG7fL0
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeI2SAdapter.this.lambda$onClick$6$DecodeI2SAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_i2s_ws_thres_value) {
            this.param.readI2s_wave_singal_thres();
            this.param.readI2sWsThresAttr();
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getI2sWsThresAttr().getMaxLongValue(), this.param.getI2sWsThresAttr().getMinLongValue(), this.param.getI2sWsThresAttr().getDefLongValue(), this.param.getI2s_wave_singal_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeI2SAdapter.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeI2SAdapter.this.param.saveI2s_wave_singal_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeI2SAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_i2s_data_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_i2s_data)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$bUt4iiwo7xRL3jvsqjOvcPQe8SU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeI2SAdapter.this.lambda$onClick$7$DecodeI2SAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$4mytcMHLeyxH9w55foqJOrfjcqE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeI2SAdapter.this.lambda$onClick$8$DecodeI2SAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_i2s_data_thres_value) {
            this.param.readI2s_data_thres();
            this.param.readI2sDataThresAttr();
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getI2sDataThresAttr().getMaxLongValue(), this.param.getI2sDataThresAttr().getMinLongValue(), this.param.getI2sDataThresAttr().getDefLongValue(), this.param.getI2s_data_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeI2SAdapter.4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeI2SAdapter.this.param.saveI2s_data_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeI2SAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_i2s_word_value) {
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_number, this.param.getI2sWordValueAttr().getMaxIntValue(), this.param.getI2sWordValueAttr().getMinIntValue(), this.param.getI2sWordValueAttr().getDefIntValue(), this.param.getI2s_word(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeI2SAdapter.5
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeI2SAdapter.this.param.saveI2s_word(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeI2SAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_i2s_receive_value) {
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_number, this.param.getI2sReceiveValueAttr().getMaxIntValue(), this.param.getI2sReceiveValueAttr().getMinIntValue(), this.param.getI2sReceiveValueAttr().getDefIntValue(), this.param.getI2s_receive(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeI2SAdapter.6
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeI2SAdapter.this.param.saveI2s_receive(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeI2SAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_i2s_align_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_i2s_align), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$JhmTV8gC-oi89w6nTG3kT-grYD4
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeI2SAdapter.this.lambda$onClick$9$DecodeI2SAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$ZP-mJu7FqjbLb9ARAx6XOFYAHmI
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeI2SAdapter.this.lambda$onClick$10$DecodeI2SAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_i2s_wslow_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_i2s_wslow), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$3Jrb2nA27h9ZXZpqIwyr9pzoZ_M
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeI2SAdapter.this.lambda$onClick$11$DecodeI2SAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2SAdapter$WzSAYmjzvnpJLeKU8JfgxH_BdS0
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeI2SAdapter.this.lambda$onClick$12$DecodeI2SAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$DecodeI2SAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$DecodeI2SAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSclkValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$DecodeI2SAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DecodeI2SAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectWSValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$DecodeI2SAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$DecodeI2SAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectDataValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$DecodeI2SAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$DecodeI2SAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAlignValue(i);
    }

    public /* synthetic */ void lambda$onClick$11$DecodeI2SAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$12$DecodeI2SAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectWslowValue(i);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.findViewById(i).isPressed()) {
            if (i == R.id.decode_i2s_sclkedge_down_radioButton) {
                this.param.saveI2s_sclock_edge(0);
            } else if (i == R.id.decode_i2s_sclkedge_up_radioButton) {
                this.param.saveI2s_sclock_edge(1);
            } else if (i == R.id.decode_i2s_endian_LSB_radioButton) {
                this.param.saveI2s_endian(true);
            } else if (i == R.id.decode_i2s_endian_MSB_radioButton) {
                this.param.saveI2s_endian(false);
            } else if (i == R.id.decode_i2s_pol_negative_radioButton) {
                this.param.saveI2s_data_polarity(false);
            } else if (i == R.id.decode_i2s_pol_positive_radioButton) {
                this.param.saveI2s_data_polarity(true);
            }
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        switch (i) {
            case R.id.decode_i2s_data_thres_value /* 2131362466 */:
                this.param.readI2s_data_thres();
                this.param.readI2sDataThresAttr();
                DecodeParam decodeParam = this.param;
                decodeParam.saveI2s_data_thres(decodeParam.getLongStep(decodeParam.getI2s_data_thres(), this.param.getI2sDataThresAttr(), z, keyEvent));
                return;
            case R.id.decode_i2s_receive_value /* 2131362478 */:
                DecodeParam decodeParam2 = this.param;
                decodeParam2.saveI2s_receive(decodeParam2.getLongStep(decodeParam2.getI2s_receive(), this.param.getI2sReceiveValueAttr(), z, keyEvent));
                return;
            case R.id.decode_i2s_sclk_thres_value /* 2131362481 */:
                this.param.readI2s_sclock_thres();
                this.param.readI2sSclkThresAttr();
                DecodeParam decodeParam3 = this.param;
                decodeParam3.saveI2s_sclock_thres(decodeParam3.getLongStep(decodeParam3.getI2s_sclock_thres(), this.param.getI2sSclkThresAttr(), z, keyEvent));
                return;
            case R.id.decode_i2s_word_value /* 2131362488 */:
                DecodeParam decodeParam4 = this.param;
                decodeParam4.saveI2s_word(decodeParam4.getLongStep(decodeParam4.getI2s_word(), this.param.getI2sWordValueAttr(), z, keyEvent));
                return;
            case R.id.decode_i2s_ws_thres_value /* 2131362491 */:
                this.param.readI2s_wave_singal_thres();
                this.param.readI2sWsThresAttr();
                DecodeParam decodeParam5 = this.param;
                decodeParam5.saveI2s_wave_singal_thres(decodeParam5.getLongStep(decodeParam5.getI2s_wave_singal_thres(), this.param.getI2sWsThresAttr(), z, keyEvent));
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
            case R.id.decode_i2s_data_thres_value /* 2131362466 */:
                this.param.readI2s_data_thres();
                this.param.readI2sDataThresAttr();
                DecodeParam decodeParam = this.param;
                decodeParam.saveI2s_data_thres(decodeParam.getLongDef(decodeParam.getI2sDataThresAttr()));
                return;
            case R.id.decode_i2s_receive_value /* 2131362478 */:
                DecodeParam decodeParam2 = this.param;
                decodeParam2.saveI2s_receive(decodeParam2.getLongDef(decodeParam2.getI2sReceiveValueAttr()));
                return;
            case R.id.decode_i2s_sclk_thres_value /* 2131362481 */:
                this.param.readI2s_sclock_thres();
                this.param.readI2sSclkThresAttr();
                DecodeParam decodeParam3 = this.param;
                decodeParam3.saveI2s_sclock_thres(decodeParam3.getLongDef(decodeParam3.getI2sSclkThresAttr()));
                return;
            case R.id.decode_i2s_word_value /* 2131362488 */:
                DecodeParam decodeParam4 = this.param;
                decodeParam4.saveI2s_word(decodeParam4.getLongDef(decodeParam4.getI2sWordValueAttr()));
                return;
            case R.id.decode_i2s_ws_thres_value /* 2131362491 */:
                this.param.readI2s_wave_singal_thres();
                this.param.readI2sWsThresAttr();
                DecodeParam decodeParam5 = this.param;
                decodeParam5.saveI2s_wave_singal_thres(decodeParam5.getLongDef(decodeParam5.getI2sWsThresAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeI2SHolder extends RecyclerView.ViewHolder {
        public DecodeI2SHolder(AdapterDecodeI2sBinding adapterDecodeI2sBinding) {
            super(adapterDecodeI2sBinding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
