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
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeI2cBinding;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DecodeI2CAdapter extends RecyclerView.Adapter<DecodeI2CHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecodeI2cBinding binding;
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

    public DecodeI2CAdapter(View view, DecodeParam decodeParam, Context context) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
    }

    public DecodeI2CAdapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeI2CHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeI2cBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeI2CHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeI2CHolder decodeI2CHolder, int i) {
        this.binding.setRwWithMapping(ViewUtil.getMappingObject(R.array.msg_decode_i2c_rw, 1));
        this.binding.setRwWithoutMapping(ViewUtil.getMappingObject(R.array.msg_decode_i2c_rw, 0));
        ViewUtil.setSwitchButton(R.array.msg_decode_i2c_exc, this.binding.decodeI2cExcSwtichButton);
        this.binding.decodeI2cClkValue.setOnClickListener(this);
        this.binding.decodeI2cSdaValue.setOnClickListener(this);
        this.binding.decodeI2cSclThresValue.setOnClickListener(this);
        this.binding.decodeI2cSdaThresValue.setOnClickListener(this);
        this.binding.decodeI2cExcSwtichButton.setOnCheckedChangeListener(this);
        this.binding.decodeI2cRwRadioGroup.setOnCheckedChangeListener(this);
        this.param.readI2c_scl();
        this.param.readI2c_sda();
        this.param.readI2c_exchange();
        this.param.readI2c_read_write();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_SCL_THRE) != this.param.getI2c_scl_thres()) {
            this.param.readI2c_scl_thres();
        }
        DecodeParam decodeParam2 = this.param;
        if (decodeParam2.getDecodeThres(decodeParam2.getServiceId(), MessageID.MSG_DECODE_SDA_THRE) != this.param.getI2c_sda_thres()) {
            this.param.readI2c_sda_thres();
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2cSclThresValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2cSdaThresValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2cClkValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeI2cSdaValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.DecodeI2CAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(DecodeI2CAdapter.this.context, ((AorBParam) DecodeI2CAdapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) DecodeI2CAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(DecodeI2CAdapter.this.context, ((AorBParam) DecodeI2CAdapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) DecodeI2CAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decodeI2cSclThresValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.decodeI2cSdaThresValue, true, ViewUtil.KEY_B);
        this.aorBManager.aorBParam_a = 0;
        this.aorBManager.aorBParam_b = 1;
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2CAdapter$5N4PD_O7C2QLRksipPko0HWg7C4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeI2CAdapter.this.lambda$onBindViewHolder$2$DecodeI2CAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(42, MessageID.MSG_DECODE_EVT_I2C).observe((LifecycleOwner) this.context, new Observer<Object>() { // from class: com.rigol.scope.adapters.DecodeI2CAdapter.2
                @Override // androidx.lifecycle.Observer
                public void onChanged(Object obj) {
                    ViewUtil.updateSwitchText(R.array.msg_decode_i2c_exc, DecodeI2CAdapter.this.binding.decodeI2cExcSwtichButton);
                }
            });
        }
        this.binding.setParam(this.param);
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DecodeI2CAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2CAdapter$aQIi-be-dy9crFZP_4wgwwdQsAk
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeI2CAdapter.this.lambda$onBindViewHolder$0$DecodeI2CAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2CAdapter$gfS2P7NRTjfFHWxyG31tkVW7cAc
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeI2CAdapter.this.lambda$onBindViewHolder$1$DecodeI2CAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DecodeI2CAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DecodeI2CAdapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.decode_i2c_clk_value) {
            selectClkValue(mappingObject);
        } else if (id != R.id.decode_i2c_sda_value) {
        } else {
            selectSdaValue(mappingObject);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_i2c_clk_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_i2c_scl)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2CAdapter$CldP22uLoVv12tZ81IqIPhORPXo
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeI2CAdapter.this.lambda$onClick$3$DecodeI2CAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2CAdapter$tPvsPHQCiPb0Pa0PpWioqeOLgUI
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeI2CAdapter.this.lambda$onClick$4$DecodeI2CAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_i2c_sda_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_i2c_sda)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2CAdapter$1PtGUMcyYNRH-9Gs3vkJUwNuEuA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeI2CAdapter.this.lambda$onClick$5$DecodeI2CAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeI2CAdapter$rAXekoIWPpFEl0USQ3aKOMGgFMk
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeI2CAdapter.this.lambda$onClick$6$DecodeI2CAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_i2c_scl_thres_value) {
            if (this.aorBManager.setClick_showab_textview(id)) {
                this.param.readI2c_scl_thres();
                this.param.readI2cClkThresAttr();
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_V, this.param.getI2cClkThresAttr().getMaxLongValue(), this.param.getI2cClkThresAttr().getMinLongValue(), this.param.getI2cClkThresAttr().getDefLongValue(), this.param.getI2c_scl_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeI2CAdapter.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeI2CAdapter.this.param.saveI2c_scl_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeI2CAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_i2c_sda_thres_value && this.aorBManager.setClick_showab_textview(id)) {
            this.param.readI2c_sda_thres();
            this.param.readI2cDataThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_V, this.param.getI2cDataThresAttr().getMaxLongValue(), this.param.getI2cDataThresAttr().getMinLongValue(), this.param.getI2cDataThresAttr().getDefLongValue(), this.param.getI2c_sda_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeI2CAdapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeI2CAdapter.this.param.saveI2c_sda_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeI2CAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$DecodeI2CAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$DecodeI2CAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectClkValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$DecodeI2CAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DecodeI2CAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSdaValue(mappingObject);
    }

    private void selectSdaValue(MappingObject mappingObject) {
        this.param.saveI2c_sda(mappingObject.getValue());
    }

    private void selectClkValue(MappingObject mappingObject) {
        this.param.saveI2c_scl(mappingObject.getValue());
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && compoundButton.getId() == R.id.decode_i2c_exc_swtichButton) {
            this.param.saveI2c_exchange(z);
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.findViewById(i).isPressed()) {
            if (i == R.id.decode_i2c_rw_with_radioButton) {
                this.param.saveI2c_read_write(true);
            } else if (i == R.id.decode_i2c_rw_without_radioButton) {
                this.param.saveI2c_read_write(false);
            }
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        if (i == R.id.decode_i2c_scl_thres_value) {
            if (this.param.getI2c_scl() < 8) {
                this.param.readI2c_scl_thres();
                this.param.readI2cClkThresAttr();
                DecodeParam decodeParam = this.param;
                decodeParam.saveI2c_scl_thres(decodeParam.getLongStep(decodeParam.getI2c_scl_thres(), this.param.getI2cClkThresAttr(), z, keyEvent));
            }
        } else if (i == R.id.decode_i2c_sda_thres_value && this.param.getI2c_sda() < 8) {
            this.param.readI2c_sda_thres();
            this.param.readI2cDataThresAttr();
            DecodeParam decodeParam2 = this.param;
            decodeParam2.saveI2c_sda_thres(decodeParam2.getLongStep(decodeParam2.getI2c_sda_thres(), this.param.getI2cDataThresAttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        if (i == R.id.decode_i2c_scl_thres_value) {
            this.param.readI2c_scl_thres();
            this.param.readI2cClkThresAttr();
            DecodeParam decodeParam = this.param;
            decodeParam.saveI2c_scl_thres(decodeParam.getLongDef(decodeParam.getI2cClkThresAttr()));
        } else if (i != R.id.decode_i2c_sda_thres_value) {
        } else {
            this.param.readI2c_sda_thres();
            this.param.readI2cDataThresAttr();
            DecodeParam decodeParam2 = this.param;
            decodeParam2.saveI2c_sda_thres(decodeParam2.getLongDef(decodeParam2.getI2cDataThresAttr()));
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeI2CHolder extends RecyclerView.ViewHolder {
        public DecodeI2CHolder(AdapterDecodeI2cBinding adapterDecodeI2cBinding) {
            super(adapterDecodeI2cBinding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
