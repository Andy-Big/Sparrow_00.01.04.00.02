package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeSentBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes.dex */
public class DecodeSentAdapter extends RecyclerView.Adapter<DecodeSentHolder> implements View.OnClickListener {
    private final View anchorView;
    private AdapterDecodeSentBinding binding;
    private KeyboardPopupView keyboardPopupView;
    private final DecodeParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public DecodeSentAdapter(View view, DecodeParam decodeParam) {
        this.param = decodeParam;
        this.anchorView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeSentHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeSentBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeSentHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeSentHolder decodeSentHolder, int i) {
        this.binding.decodeSentSrcValue.setOnClickListener(this);
        this.binding.decodeSentThresValue.setOnClickListener(this);
        this.binding.decodeSentToleranceValue.setOnClickListener(this);
        this.binding.decodeSentNibbnumValue.setOnClickListener(this);
        this.binding.decodeSentIdleValue.setOnClickListener(this);
        this.binding.decodeSentCrcValue.setOnClickListener(this);
        this.binding.decodeSentPauseValue.setOnClickListener(this);
        this.binding.decodeSentSignalTypeValue.setOnClickListener(this);
        this.binding.decodeSentTickValue.setOnClickListener(this);
        this.param.readSent_source();
        this.param.readSent_idle_state();
        this.param.readSent_crc_format();
        this.param.readSent_pause_plus();
        this.param.readSent_signal_type();
        this.param.readSent_tick();
        this.param.readSent_tolerance();
        this.param.readSent_nibbnum();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_SENT_THRE) != this.param.getSent_thres()) {
            this.param.readSent_thres();
        }
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_sent_src_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, (int) R.array.msg_decode_sent_src, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSentAdapter$jg_hl8qcfJg8PqPh7ArWXWdvxF0
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSentAdapter.this.lambda$onClick$0$DecodeSentAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_sent_thres_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_SENT_THRE);
            this.param.readSentThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getSentThresAttr().getMaxLongValue(), this.param.getSentThresAttr().getMinLongValue(), this.param.getSentThresAttr().getDefLongValue(), this.param.getSent_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSentAdapter.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeSentAdapter.this.param.saveSent_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeSentAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_sent_tick_value) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_none, this.param.getSentTickAttr().getMaxLongValue(), this.param.getSentTickAttr().getMinLongValue(), this.param.getSentTickAttr().getDefLongValue(), this.param.getSent_tick(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSentAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeSentAdapter.this.param.saveSent_tick(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeSentAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_sent_tolerance_value) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_none, this.param.getSentToleranceAttr().getMaxIntValue(), this.param.getSentToleranceAttr().getMinIntValue(), this.param.getSentToleranceAttr().getDefIntValue(), this.param.getSent_tolerance(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSentAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeSentAdapter.this.param.saveSent_tolerance(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeSentAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_sent_nibbnum_value) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_none, this.param.getSentNibbnumAttr().getMaxIntValue(), this.param.getSentNibbnumAttr().getMinIntValue(), this.param.getSentNibbnumAttr().getDefIntValue(), this.param.getSent_nibbnum(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSentAdapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeSentAdapter.this.param.saveSent_nibbnum(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeSentAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_sent_idle_value) {
            ViewUtil.showSpinner(this.anchorView, view, (int) R.array.msg_decode_sent_idle, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSentAdapter$eaSOrFTXcXfzNh2vBrkj_lK2Ru8
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSentAdapter.this.lambda$onClick$1$DecodeSentAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_sent_crc_value) {
            ViewUtil.showSpinner(this.anchorView, view, (int) R.array.msg_decode_sent_crc, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSentAdapter$xJt0Cu7I0irvx5ycNmvvpvxYwJ8
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSentAdapter.this.lambda$onClick$2$DecodeSentAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_sent_pause_value) {
            ViewUtil.showSpinner(this.anchorView, view, (int) R.array.msg_decode_sent_pause, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSentAdapter$hMwq8WLdy0302-dWr7fUFQI79MA
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSentAdapter.this.lambda$onClick$3$DecodeSentAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_sent_signal_type_value) {
            ViewUtil.showSpinner(this.anchorView, view, (int) R.array.msg_decode_sent_signal_type, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSentAdapter$xdt75k31WJij88uk354_7lirVwc
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSentAdapter.this.lambda$onClick$4$DecodeSentAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$0$DecodeSentAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveSent_source(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$1$DecodeSentAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveSent_idle_state(i);
    }

    public /* synthetic */ void lambda$onClick$2$DecodeSentAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveSent_crc_format(i);
    }

    public /* synthetic */ void lambda$onClick$3$DecodeSentAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveSent_pause_plus(i);
    }

    public /* synthetic */ void lambda$onClick$4$DecodeSentAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveSent_signal_type(i);
    }

    /* loaded from: classes.dex */
    public static class DecodeSentHolder extends RecyclerView.ViewHolder {
        public DecodeSentHolder(AdapterDecodeSentBinding adapterDecodeSentBinding) {
            super(adapterDecodeSentBinding.getRoot());
        }
    }
}
