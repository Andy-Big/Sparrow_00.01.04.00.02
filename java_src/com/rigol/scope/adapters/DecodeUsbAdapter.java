package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeUsbBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes.dex */
public class DecodeUsbAdapter extends RecyclerView.Adapter<DecodeUsbHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private final View anchorView;
    private AdapterDecodeUsbBinding binding;
    private KeyboardPopupView keyboardPopupView;
    private final DecodeParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public DecodeUsbAdapter(View view, DecodeParam decodeParam) {
        this.param = decodeParam;
        this.anchorView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeUsbHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeUsbBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeUsbHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeUsbHolder decodeUsbHolder, int i) {
        this.binding.setUsbLowMapping(ViewUtil.getMappingObject(R.array.msg_decode_usb_rate, 0));
        this.binding.setUsbMidMapping(ViewUtil.getMappingObject(R.array.msg_decode_usb_rate, 1));
        this.binding.setUsbHighMapping(ViewUtil.getMappingObject(R.array.msg_decode_usb_rate, 2));
        this.binding.decodeUsbSigRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeUsbDiffValue.setOnClickListener(this);
        this.binding.decodeUsbDpValue.setOnClickListener(this);
        this.binding.decodeUsbDsValue.setOnClickListener(this);
        this.binding.decodeUsbDpThresValue.setOnClickListener(this);
        this.binding.decodeUsbDsThresValue.setOnClickListener(this);
        this.binding.decodeUsbDiffThreHValue.setOnClickListener(this);
        this.binding.decodeUsbDiffThreLValue.setOnClickListener(this);
        this.param.readUsb_dp();
        this.param.readUsb_ds();
        this.param.readUsb_diff();
        this.param.readRate();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_USB_DP_THRE) != this.param.getUsb_dp_thres()) {
            this.param.readUsb_dp_thres();
        }
        DecodeParam decodeParam2 = this.param;
        if (decodeParam2.getDecodeThres(decodeParam2.getServiceId(), MessageID.MSG_DECODE_USB_DS_THRE) != this.param.getUsb_ds_thres()) {
            this.param.readUsb_ds_thres();
        }
        DecodeParam decodeParam3 = this.param;
        if (decodeParam3.getDecodeThres(decodeParam3.getServiceId(), MessageID.MSG_DECODE_USB_DIFF_THRE_H) != this.param.getUsb_diff_high_thres()) {
            this.param.readUsb_diff_high_thres();
        }
        DecodeParam decodeParam4 = this.param;
        if (decodeParam4.getDecodeThres(decodeParam4.getServiceId(), MessageID.MSG_DECODE_USB_DIFF_THRE_L) != this.param.getUsb_diff_low_thres()) {
            this.param.readUsb_diff_low_thres();
        }
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_usb_diff_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, (int) R.array.msg_decode_usb_diff, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeUsbAdapter$avPD4LL9-j_2vhS9oqqaHDFOR3E
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeUsbAdapter.this.lambda$onClick$0$DecodeUsbAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_usb_dp_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, (int) R.array.msg_decode_usb_dp, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeUsbAdapter$COOI5UauE3UpxqxYqMFtKlmogpo
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeUsbAdapter.this.lambda$onClick$1$DecodeUsbAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_usb_ds_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, (int) R.array.msg_decode_usb_ds, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeUsbAdapter$TTZOHjaimFoQ-3FhnztD6N7n1DY
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeUsbAdapter.this.lambda$onClick$2$DecodeUsbAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_usb_dp_thres_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_USB_DP_THRE);
            this.param.readUsbDpThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getUsbDpThresAttr().getMaxIntValue(), this.param.getUsbDpThresAttr().getMinIntValue(), this.param.getUsbDpThresAttr().getDefIntValue(), this.param.getUsb_dp_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeUsbAdapter.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeUsbAdapter.this.param.saveUsb_dp_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeUsbAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_usb_ds_thres_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_USB_DS_THRE);
            this.param.readUsbDsThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getUsbDsThresAttr().getMaxIntValue(), this.param.getUsbDsThresAttr().getMinIntValue(), this.param.getUsbDsThresAttr().getDefIntValue(), this.param.getUsb_ds_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeUsbAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeUsbAdapter.this.param.saveUsb_ds_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeUsbAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_usb_diff_thre_h_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_USB_DIFF_THRE_H);
            this.param.readUsbDiffHthresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getUsbDiffHthresAttr().getMaxIntValue(), this.param.getUsbDiffHthresAttr().getMinIntValue(), this.param.getUsbDiffHthresAttr().getDefIntValue(), this.param.getUsb_diff_high_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeUsbAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeUsbAdapter.this.param.saveUsb_diff_high_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeUsbAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_usb_diff_thre_l_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_USB_DIFF_THRE_L);
            this.param.readUsbDiffLthresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getUsbDiffLthresAttr().getMaxIntValue(), this.param.getUsbDiffLthresAttr().getMinIntValue(), this.param.getUsbDiffLthresAttr().getDefIntValue(), this.param.getUsb_diff_low_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeUsbAdapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeUsbAdapter.this.param.saveUsb_diff_low_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeUsbAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$0$DecodeUsbAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveUsb_diff(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$1$DecodeUsbAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveUsb_dp(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$2$DecodeUsbAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveUsb_ds(mappingObject.getValue());
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.findViewById(i).isPressed()) {
            if (i == R.id.decode_usb_low_radioButton) {
                this.param.saveUsb_rate(0L);
            } else if (i == R.id.decode_usb_mid_radioButton) {
                this.param.saveUsb_rate(1L);
            } else if (i == R.id.decode_usb_high_radioButton) {
                this.param.saveUsb_rate(2L);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeUsbHolder extends RecyclerView.ViewHolder {
        public DecodeUsbHolder(AdapterDecodeUsbBinding adapterDecodeUsbBinding) {
            super(adapterDecodeUsbBinding.getRoot());
        }
    }
}
