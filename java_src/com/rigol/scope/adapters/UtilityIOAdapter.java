package com.rigol.scope.adapters;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import androidx.core.view.GravityCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.StringUtils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.adapters.UtilityIOAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.IOParam;
import com.rigol.scope.databinding.AdapterUtilityLansettingItemBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.IOViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.util.ToastUtils;
/* loaded from: classes.dex */
public class UtilityIOAdapter extends RecyclerView.Adapter<LanViewHolder> {
    private AdapterUtilityLansettingItemBinding binding;
    private final Context context;
    private KeyboardPopupView keyboardPopupView;
    private final BasePopupView popupView;
    private IOParam ioParam = null;
    private Long clickTime = 0L;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilityIOAdapter(Context context, BasePopupView basePopupView) {
        this.context = context;
        this.popupView = basePopupView;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public LanViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterUtilityLansettingItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        IOViewModel iOViewModel = (IOViewModel) ContextUtil.getAppViewModel(IOViewModel.class);
        if (iOViewModel != null) {
            iOViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$KVcx6zHAboPg_y9IbQS1TXbJon4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    UtilityIOAdapter.this.lambda$onCreateViewHolder$0$UtilityIOAdapter((IOParam) obj);
                }
            });
        }
        return new LanViewHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$UtilityIOAdapter(IOParam iOParam) {
        this.binding.setIoParam(iOParam);
        this.ioParam = iOParam;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final LanViewHolder lanViewHolder, int i) {
        ViewUtil.setSwitchButton(this.binding.switchMdns);
        initEditText(lanViewHolder);
        initCheckBox(lanViewHolder);
        lanViewHolder.binding.switchMdns.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$503v-JMOk9X3lZS6Y8Ms1zP6Is0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityIOAdapter.this.lambda$onBindViewHolder$1$UtilityIOAdapter(compoundButton, z);
            }
        });
        lanViewHolder.binding.edtHostNameValue.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$3IARvwCGOlRtE4x9uduJGnXZjP0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityIOAdapter.this.lambda$onBindViewHolder$3$UtilityIOAdapter(lanViewHolder, view);
            }
        });
        lanViewHolder.binding.mDnslayout.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$ntZ056PhPh2u7vF2PdpJl8ul5yI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityIOAdapter.lambda$onBindViewHolder$4(UtilityIOAdapter.LanViewHolder.this, view);
            }
        });
        lanViewHolder.binding.tvgpib.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$-NRNNdqDtAnCUXHsXkr2SIpg3pg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityIOAdapter.this.lambda$onBindViewHolder$5$UtilityIOAdapter(view);
            }
        });
        lanViewHolder.binding.apply.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$vWn3BG6ko9oZsTOw5cXFAmu_ThU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityIOAdapter.this.lambda$onBindViewHolder$6$UtilityIOAdapter(view);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$UtilityIOAdapter(CompoundButton compoundButton, boolean z) {
        IOParam iOParam;
        if (this.binding.switchMdns.isPressed() && (iOParam = this.ioParam) != null) {
            iOParam.savemDns(z);
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$3$UtilityIOAdapter(LanViewHolder lanViewHolder, View view) {
        ViewUtil.showPinyinKeyboard(this.context, this.popupView.getAnchor(), lanViewHolder.binding.edtHostNameValue, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$F4P_WRriAR_-2LCoaZgZwljIpbI
            @Override // com.rigol.pinyinkeyboard.ExternalInterface
            public final void resultShow(String str) {
                UtilityIOAdapter.this.lambda$onBindViewHolder$2$UtilityIOAdapter(str);
            }
        });
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$UtilityIOAdapter(String str) {
        IOParam iOParam = this.ioParam;
        if (iOParam != null) {
            iOParam.saveHostName(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onBindViewHolder$4(LanViewHolder lanViewHolder, View view) {
        lanViewHolder.binding.switchMdns.setPressed(true);
        lanViewHolder.binding.switchMdns.toggle();
    }

    public /* synthetic */ void lambda$onBindViewHolder$5$UtilityIOAdapter(View view) {
        if (this.ioParam != null) {
            ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.ioParam.getGpibAttr().getMaxIntValue(), this.ioParam.getGpibAttr().getMinIntValue(), this.ioParam.getGpibAttr().getDefIntValue(), this.ioParam.getGpib(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UtilityIOAdapter.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    UtilityIOAdapter.this.ioParam.saveGPIB(Math.toIntExact(((Long) t).longValue()));
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    UtilityIOAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$6$UtilityIOAdapter(View view) {
        UtilityViewModel utilityViewModel;
        if (view.isPressed() && this.ioParam != null && System.currentTimeMillis() - this.clickTime.longValue() > 2000 && this.ioParam.getStatus() == ServiceEnum.tagNET_STATUS_EN.NET_STATUS_CONNECTED) {
            this.clickTime = Long.valueOf(System.currentTimeMillis());
            try {
                String hostName = this.ioParam.getHostName();
                if ((StringUtils.isEmpty(hostName) || hostName.replaceAll("\\s*", "").length() == 0) && (utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)) != null) {
                    IOParam iOParam = this.ioParam;
                    iOParam.saveHostName("RIGOL_" + utilityViewModel.getLiveData().getValue().getSerial());
                }
                Thread.sleep(100L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.ioParam.apply();
        }
    }

    private void initCheckBox(LanViewHolder lanViewHolder) {
        lanViewHolder.binding.ipDhcp.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$qwSCpXmb4W2eQDBZx8SO3BMEYUo
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityIOAdapter.this.lambda$initCheckBox$7$UtilityIOAdapter(compoundButton, z);
            }
        });
        lanViewHolder.binding.ipAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$ht-RLbY7wg06HzJDeBhD9GAGzD4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityIOAdapter.this.lambda$initCheckBox$8$UtilityIOAdapter(compoundButton, z);
            }
        });
        lanViewHolder.binding.ipStatic.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$YebTVJPuf8uLiC0XXue3-4MRr6o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityIOAdapter.this.lambda$initCheckBox$9$UtilityIOAdapter(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$initCheckBox$7$UtilityIOAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.ioParam.saveDhcp(z);
        }
    }

    public /* synthetic */ void lambda$initCheckBox$8$UtilityIOAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.ioParam.saveAuto(z);
        }
    }

    public /* synthetic */ void lambda$initCheckBox$9$UtilityIOAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.ioParam.saveStatic(z);
        }
    }

    private void initEditText(final LanViewHolder lanViewHolder) {
        lanViewHolder.binding.edtipAddress.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$F-KuzEN4IVRTpwlJRCmoTA4CJYM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityIOAdapter.this.lambda$initEditText$10$UtilityIOAdapter(lanViewHolder, view);
            }
        });
        lanViewHolder.binding.edtsubMask.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$OgycUdXfHnmUqI8GnFT-JPryXDw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityIOAdapter.this.lambda$initEditText$11$UtilityIOAdapter(lanViewHolder, view);
            }
        });
        lanViewHolder.binding.edtdefaultGateway.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$TNhVkz3Jsr304hN-dZ6BNcNI8_k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityIOAdapter.this.lambda$initEditText$12$UtilityIOAdapter(lanViewHolder, view);
            }
        });
        lanViewHolder.binding.edtdns.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityIOAdapter$bclyLRfX9TpILkshDbLjWWwd_IA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityIOAdapter.this.lambda$initEditText$13$UtilityIOAdapter(lanViewHolder, view);
            }
        });
    }

    public /* synthetic */ void lambda$initEditText$10$UtilityIOAdapter(LanViewHolder lanViewHolder, View view) {
        showKeyBoardView(lanViewHolder.binding.edtipAddress);
    }

    public /* synthetic */ void lambda$initEditText$11$UtilityIOAdapter(LanViewHolder lanViewHolder, View view) {
        showKeyBoardView(lanViewHolder.binding.edtsubMask);
    }

    public /* synthetic */ void lambda$initEditText$12$UtilityIOAdapter(LanViewHolder lanViewHolder, View view) {
        showKeyBoardView(lanViewHolder.binding.edtdefaultGateway);
    }

    public /* synthetic */ void lambda$initEditText$13$UtilityIOAdapter(LanViewHolder lanViewHolder, View view) {
        showKeyBoardView(lanViewHolder.binding.edtdns);
    }

    private void showKeyBoardView(final EditText editText) {
        int[] offset = BasePopupView.getOffset(this.popupView.getAnchor(), editText);
        new KeyboardPopupView(new KeyboardPopupView.Builder(ServiceEnum.Unit.Unit_ip, "255.255.255.255", "0.0.0.0", "192.168.1.1", editText.getText().toString()).setKeyboardListener(new KeyboardListener() { // from class: com.rigol.scope.adapters.UtilityIOAdapter.2
            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public <T> void resultMinUnitValueListener(T t) {
                if (editText != UtilityIOAdapter.this.binding.edtipAddress) {
                    if (editText != UtilityIOAdapter.this.binding.edtsubMask) {
                        if (editText != UtilityIOAdapter.this.binding.edtdefaultGateway) {
                            if (editText == UtilityIOAdapter.this.binding.edtdns) {
                                UtilityIOAdapter.this.configDns(t.toString());
                                Editable text = editText.getText();
                                if (text != null) {
                                    UtilityIOAdapter.this.ioParam.saveDNS(text.toString());
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        UtilityIOAdapter.this.configGateway(t.toString());
                        Editable text2 = editText.getText();
                        if (text2 != null) {
                            UtilityIOAdapter.this.ioParam.saveGateWay(text2.toString());
                            return;
                        }
                        return;
                    }
                    UtilityIOAdapter.this.configMask(t.toString());
                    Editable text3 = editText.getText();
                    if (text3 != null) {
                        UtilityIOAdapter.this.ioParam.saveMask(text3.toString());
                        return;
                    }
                    return;
                }
                UtilityIOAdapter.this.configIp(t.toString());
                Editable text4 = editText.getText();
                if (text4 != null) {
                    UtilityIOAdapter.this.ioParam.saveIPAddress(text4.toString());
                }
            }

            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public void onCall(KeyboardPopupView keyboardPopupView) {
                UtilityIOAdapter.this.keyboardPopupView = keyboardPopupView;
            }
        })).showAsDropDown(this.popupView.getAnchor(), offset[0], offset[1], GravityCompat.START);
    }

    public void configGateway(String str) {
        if (str.contains("s")) {
            str = str.replace("s", "");
        } else if (str.contains("\"")) {
            str = str.replace("\"", "");
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            ToastUtils.showShort("GateWay Format Error");
            return;
        }
        boolean z = false;
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int parseInt3 = Integer.parseInt(split[2]);
        int parseInt4 = Integer.parseInt(split[3]);
        boolean z2 = parseInt >= 0 && parseInt <= 223 && parseInt != 127;
        boolean z3 = parseInt2 >= 0 && parseInt2 <= 255;
        boolean z4 = parseInt3 >= 0 && parseInt3 <= 255;
        if (parseInt4 >= 0 && parseInt4 <= 255) {
            z = true;
        }
        if (!this.binding.ipDhcp.isChecked() && z2 && z3 && z4 && z) {
            this.binding.edtdefaultGateway.setText(str);
        }
    }

    public void configDns(String str) {
        if (str.contains("s")) {
            str = str.replace("s", "");
        } else if (str.contains("\"")) {
            str = str.replace("\"", "");
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            ToastUtils.showShort("Dns Format Error");
            return;
        }
        boolean z = false;
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int parseInt3 = Integer.parseInt(split[2]);
        int parseInt4 = Integer.parseInt(split[3]);
        boolean z2 = parseInt >= 0 && parseInt <= 223 && parseInt != 127;
        boolean z3 = parseInt2 >= 0 && parseInt2 <= 255;
        boolean z4 = parseInt3 >= 0 && parseInt3 <= 255;
        if (parseInt4 >= 0 && parseInt4 <= 255) {
            z = true;
        }
        if (!this.binding.ipDhcp.isChecked() && z2 && z3 && z4 && z) {
            this.binding.edtdns.setText(str);
        }
    }

    public void configIp(String str) {
        if (str.contains("s")) {
            str = str.replace("s", "");
        } else if (str.contains("\"")) {
            str = str.replace("\"", "");
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            ToastUtils.showShort("Ip Format Error");
            return;
        }
        boolean z = false;
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int parseInt3 = Integer.parseInt(split[2]);
        int parseInt4 = Integer.parseInt(split[3]);
        boolean z2 = parseInt >= 0 && parseInt <= 223 && parseInt != 127;
        boolean z3 = parseInt2 >= 0 && parseInt2 <= 255;
        boolean z4 = parseInt3 >= 0 && parseInt3 <= 255;
        if (parseInt4 >= 0 && parseInt4 <= 255) {
            z = true;
        }
        if (!this.binding.ipDhcp.isChecked() && !this.binding.ipAuto.isChecked() && z2 && z3 && z4 && z) {
            this.binding.edtipAddress.setText(str);
        }
    }

    public void configMask(String str) {
        if (str.contains("s")) {
            str = str.replace("s", "");
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            ToastUtils.showShort("Mask Format Error");
            return;
        }
        boolean z = false;
        int parseInt = Integer.parseInt(split[0]);
        int parseInt2 = Integer.parseInt(split[1]);
        int parseInt3 = Integer.parseInt(split[2]);
        int parseInt4 = Integer.parseInt(split[3]);
        boolean z2 = parseInt >= 0 && parseInt <= 255;
        boolean z3 = parseInt2 >= 0 && parseInt2 <= 255;
        boolean z4 = parseInt3 >= 0 && parseInt3 <= 255;
        if (parseInt4 >= 0 && parseInt4 <= 255) {
            z = true;
        }
        if (!this.binding.ipDhcp.isChecked() && !this.binding.ipAuto.isChecked() && z2 && z3 && z4 && z) {
            this.binding.edtsubMask.setText(str);
        }
    }

    /* loaded from: classes.dex */
    public static class LanViewHolder extends RecyclerView.ViewHolder {
        private final AdapterUtilityLansettingItemBinding binding;

        public LanViewHolder(AdapterUtilityLansettingItemBinding adapterUtilityLansettingItemBinding) {
            super(adapterUtilityLansettingItemBinding.getRoot());
            this.binding = adapterUtilityLansettingItemBinding;
        }
    }
}
