package com.rigol.scope.viewmodels;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.views.baseview.SearchThresholdLine;
import com.rigol.scope.views.baseview.ThresholdLine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* loaded from: classes2.dex */
public class SyncDataViewModel extends ViewModel {
    private final Map<String, MutableLiveData<Object>> bus = new HashMap();

    public MutableLiveData<Object> get(int i, int i2) {
        return get(MessageBus.getKey(i, i2));
    }

    public MutableLiveData<Object> get(int i, int i2, int i3) {
        return get(MessageBus.getKey(i, i2, i3));
    }

    public MutableLiveData<Object> get(String str) {
        if (!isContainsKey(str)) {
            put(str);
        }
        return this.bus.get(str);
    }

    public void put(String str) {
        this.bus.put(str, new MutableLiveData<>());
    }

    public void remove(String str) {
        Iterator<Map.Entry<String, MutableLiveData<Object>>> it = this.bus.entrySet().iterator();
        while (it.hasNext()) {
            if (it.next().getKey().equals(str)) {
                it.remove();
            }
        }
    }

    public boolean isContainsKey(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.bus.containsKey(str);
    }

    public void bind(LifecycleOwner lifecycleOwner, final SearchParam searchParam, final SearchThresholdLine searchThresholdLine) {
        if (searchThresholdLine == null || searchParam == null) {
            return;
        }
        get(searchParam.getServiceId(), MessageID.MSG_SEARCH_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$rieEkhrzuQAlIvyoNa-l6Bfc6jI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SearchThresholdLine.this.setPosition(r1.getEdgeSrc().value1, searchParam.getThre());
            }
        });
    }

    public void bind(LifecycleOwner lifecycleOwner, final DecodeParam decodeParam, final ThresholdLine thresholdLine) {
        if (thresholdLine == null || decodeParam == null) {
            return;
        }
        int serviceId = decodeParam.getServiceId();
        get(serviceId, MessageID.MSG_DECODE_PAL_CLK_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$zyZv1vEcTFC90OPOK_eqNnPBaKE
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getPal_clk(), decodeParam.getPal_clk_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_PAL_DAT_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$vacNAjoG8xa54CZ9h0ZCk33k8Nc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SyncDataViewModel.lambda$bind$2(DecodeParam.this, thresholdLine, obj);
            }
        });
        get(serviceId, MessageID.MSG_DECODE_TX_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$yVVof_A1c1yDdO0wXlG0y5Q6mic
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getRs232_tx(), decodeParam.getRs232_tx_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_RX_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$TDhLXsgMdQni-0s8GeMbqwdJtbg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getRs232_rx(), decodeParam.getRs232_rx_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SCL_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$6QuOp0xugSHOe-Cb7GwFWlEyh7E
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getI2c_scl(), decodeParam.getI2c_scl_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SDA_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$3GiC7Lm2ql71r4lr3vZ_IRhvX6I
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getI2c_sda(), decodeParam.getI2c_sda_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_LIN_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$kixK5gRvdIY8yBvBCmp2j-2c4tg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getLin_source(), decodeParam.getLin_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CAN_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$cNoJ-WMRHOWU99G3Qh-bQrYBPbU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getCan_source(), decodeParam.getCan_threas());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_FLEX_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$nq6XGPYBJrRZOWkXdISI3uBBnKo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getFlex_source(), decodeParam.getFlex_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_SCLK_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$GoTT7mTGbwGxiLDOVXpSlcz2dtk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getI2s_sclock(), decodeParam.getI2s_sclock_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_WS_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$2vUNqYL4uYiN1BTvZFxwi_sGSH8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getI2s_ws(), decodeParam.getI2s_wave_singal_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_I2S_DATA_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$-AjTSYa9yR2geD65Klv9TeURrJo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getI2s_data(), decodeParam.getI2s_data_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CLK_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$vzprvxv2q9TIoQDhuHG4byso9Vo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getSpi_clock(), decodeParam.getSpi_clock_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MISO_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$E9U6OKG0e1raQI3b3WUmKcV6Fns
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getSpi_miso(), decodeParam.getSpi_miso_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MOSI_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$j9Bzodf-crcRcXzQiRonIKLMVK8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getSpi_mosi(), decodeParam.getSpi_mosi_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_CS_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$47R8fYVoztgwXF6A3jiy1XFELLA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getSpi_cs(), decodeParam.getSpi_cs_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_1553B_THRE1).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$JiygLY2P9Xy2GoX0vCub0uAOzHk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.get_1553b_source(), decodeParam.get_1553b_thres1());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_1553B_THRE2).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$GT1wugRR6hybLWAoo1TFfueyh-U
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.get_1553b_source(), decodeParam.get_1553b_thres2());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ARINC429_DOWN_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$wWCM9wCS8A3t3_ZXZWgyJSgJDmY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getArinc429_source(), decodeParam.getArinc429_down_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_ARINC429_UP_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$Iib7ndP9tgJQojw2lK6SwhqoOT0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getArinc429_source(), decodeParam.getArinc429_up_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_SENT_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$CDWZhkWygh9-fP3tGj9UApCzXw4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getSent_source(), decodeParam.getSent_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_MOST_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$2kc3cog2ijJsKZoPPk-ojnC1mvQ
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getMost_source(), decodeParam.getMost_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DP_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$sFePROu5n5-Rz-LE7r3VSrRi8uY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getUsb_dp(), decodeParam.getUsb_dp_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DS_THRE).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$d8r6W4BPi3T7S-mfhpOvvKDnsyg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getUsb_ds(), decodeParam.getUsb_ds_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DIFF_THRE_H).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$yZ5KQf1_0AHB_3sB9lBqMr0eMno
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getUsb_diff(), decodeParam.getUsb_diff_high_thres());
            }
        });
        get(serviceId, MessageID.MSG_DECODE_USB_DIFF_THRE_L).observe(lifecycleOwner, new Observer() { // from class: com.rigol.scope.viewmodels.-$$Lambda$SyncDataViewModel$vFtLxOfcW5IMdngDcE8d6NDIMtA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ThresholdLine.this.setPosition(r1.getUsb_diff(), decodeParam.getUsb_diff_low_thres());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$bind$2(DecodeParam decodeParam, ThresholdLine thresholdLine, Object obj) {
        if (decodeParam.getPal_bus() == 11) {
            thresholdLine.setPosition(decodeParam.getBus_chan(), decodeParam.getPal_dat_thres());
        } else {
            thresholdLine.setPosition(decodeParam.getPal_bus(), decodeParam.getPal_dat_thres());
        }
    }
}
