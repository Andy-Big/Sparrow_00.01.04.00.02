package com.rigol.scope.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeMostBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
/* loaded from: classes.dex */
public class DecodeMostAdapter extends RecyclerView.Adapter<DecodeMostHolder> implements View.OnClickListener {
    private final View anchorView;
    private AdapterDecodeMostBinding binding;
    private KeyboardPopupView keyboardPopupView;
    private final DecodeParam param;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public DecodeMostAdapter(View view, DecodeParam decodeParam) {
        this.param = decodeParam;
        this.anchorView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeMostHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeMostBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeMostHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeMostHolder decodeMostHolder, int i) {
        this.binding.decodeMostSrcValue.setOnClickListener(this);
        this.binding.decodeMostSignalTypeValue.setOnClickListener(this);
        this.binding.decodeMostThresValue.setOnClickListener(this);
        this.param.readMost_source();
        this.param.readMost_signal_type();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_MOST_THRE) != this.param.getMost_thres()) {
            this.param.readMost_thres();
        }
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_most_src_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, (int) R.array.msg_decode_most_src, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeMostAdapter$k0MOPmz_el0fZxkXqi_dJllLqcI
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeMostAdapter.this.lambda$onClick$0$DecodeMostAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_most_signal_type_value) {
            ViewUtil.showSpinner(this.anchorView, view, (int) R.array.msg_decode_most_signal_type, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeMostAdapter$WCoEFsrJVKPrMH0QvSJMhMn-mpw
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeMostAdapter.this.lambda$onClick$1$DecodeMostAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_most_thres_value) {
            API.getInstance().UI_QueryInt64(this.param.getServiceId(), MessageID.MSG_DECODE_MOST_THRE);
            this.param.readMostThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getMostThresAttr().getMaxLongValue(), this.param.getMostThresAttr().getMinLongValue(), this.param.getMostThresAttr().getDefLongValue(), this.param.getMost_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeMostAdapter.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeMostAdapter.this.param.saveMost_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeMostAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$0$DecodeMostAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveMost_source(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$1$DecodeMostAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveMost_signal_type(i);
    }

    /* loaded from: classes.dex */
    public static class DecodeMostHolder extends RecyclerView.ViewHolder {
        public DecodeMostHolder(AdapterDecodeMostBinding adapterDecodeMostBinding) {
            super(adapterDecodeMostBinding.getRoot());
        }
    }
}
