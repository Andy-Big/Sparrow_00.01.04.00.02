package com.rigol.scope.adapters;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeArinc429Binding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes.dex */
public class DecodeArinc429Adapter extends RecyclerView.Adapter<DecodeArinc429Holder> implements View.OnClickListener, AorBManager.OnSetTextById {
    private final View anchorView;
    private AdapterDecodeArinc429Binding binding;
    private KeyboardPopupView keyboardPopupView;
    private final DecodeParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
    }

    public DecodeArinc429Adapter(View view, DecodeParam decodeParam) {
        this.param = decodeParam;
        this.anchorView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeArinc429Holder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeArinc429Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeArinc429Holder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeArinc429Holder decodeArinc429Holder, int i) {
        this.binding.decodeArinc429BaudValue.setOnClickListener(this);
        this.binding.decodeArinc429ByteFormatTypeValue.setOnClickListener(this);
        this.binding.decodeArinc429SingalTypeValue.setOnClickListener(this);
        this.binding.decodeArinc429SrcValue.setOnClickListener(this);
        this.binding.decodeArinc429UpThresValue.setOnClickListener(this);
        this.binding.decodeArinc429DownThresValue.setOnClickListener(this);
        this.param.readArinc429_source();
        this.param.readArinc429_singal_type();
        this.param.readArinc429_baud();
        this.param.readArinc429_byte_format();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_ARINC429_UP_THRE) != this.param.getArinc429_up_thres()) {
            this.param.readArinc429_up_thres();
        }
        DecodeParam decodeParam2 = this.param;
        if (decodeParam2.getDecodeThres(decodeParam2.getServiceId(), MessageID.MSG_DECODE_ARINC429_DOWN_THRE) != this.param.getArinc429_down_thres()) {
            this.param.readArinc429_down_thres();
        }
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_arinc429_src_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, (int) R.array.msg_decode_arinc429_src, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeArinc429Adapter$-T4ZSbHR_QGvN2X_LmmZOImu2Rg
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeArinc429Adapter.this.lambda$onClick$0$DecodeArinc429Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_arinc429_singal_type_value) {
            ViewUtil.showSpinner(this.anchorView, view, (int) R.array.msg_decode_arinc429_signal_type, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeArinc429Adapter$ofMq4R1nSCBhIEo3PWxL9tGzmh8
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeArinc429Adapter.this.lambda$onClick$1$DecodeArinc429Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_arinc429_baud_value) {
            ViewUtil.showSpinner(this.anchorView, view, (int) R.array.msg_decode_arinc429_baud, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeArinc429Adapter$HK73ihDxCKIWz-sWOyDiGkEfQ48
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeArinc429Adapter.this.lambda$onClick$2$DecodeArinc429Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_arinc429_byte_format_type_value) {
            ViewUtil.showSpinner(this.anchorView, view, (int) R.array.msg_decode_arinc429_byte_format, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeArinc429Adapter$-35AseUBs7DFUsFyMB3Pugf7Xhw
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeArinc429Adapter.this.lambda$onClick$3$DecodeArinc429Adapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_arinc429_down_thres_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_ARINC429_DOWN_THRE);
            this.param.readArincDownThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getArincDownThresAttr().getMaxLongValue(), this.param.getArincDownThresAttr().getMinLongValue(), this.param.getArincDownThresAttr().getDefLongValue(), this.param.getArinc429_down_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeArinc429Adapter.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeArinc429Adapter.this.param.saveArinc429_down_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeArinc429Adapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_arinc429_up_thres_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_ARINC429_UP_THRE);
            this.param.readArincUpThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getArincUpThresAttr().getMaxLongValue(), this.param.getArincUpThresAttr().getMinLongValue(), this.param.getArincUpThresAttr().getDefLongValue(), this.param.getArinc429_up_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeArinc429Adapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeArinc429Adapter.this.param.saveArinc429_up_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeArinc429Adapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$0$DecodeArinc429Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveArinc429_source(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$1$DecodeArinc429Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveArinc429_singal_type(i);
    }

    public /* synthetic */ void lambda$onClick$2$DecodeArinc429Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveArinc429_baud(i);
    }

    public /* synthetic */ void lambda$onClick$3$DecodeArinc429Adapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveArinc429_byte_format(i);
    }

    /* loaded from: classes.dex */
    public static class DecodeArinc429Holder extends RecyclerView.ViewHolder {
        public DecodeArinc429Holder(AdapterDecodeArinc429Binding adapterDecodeArinc429Binding) {
            super(adapterDecodeArinc429Binding.getRoot());
        }
    }
}
