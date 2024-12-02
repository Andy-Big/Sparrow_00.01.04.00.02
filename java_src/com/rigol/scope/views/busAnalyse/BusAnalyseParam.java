package com.rigol.scope.views.busAnalyse;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseParam;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.OptionViewModel;

/* loaded from: classes2.dex */
public class BusAnalyseParam extends BaseParam {
    private static final int DEFAULT_ANASELECT = ServiceEnum.BusAnalyseType.AnalyseUsb.value1;
    private int analyse_select;
    private final BusAnalyseEthParam eth;
    private final BusAnalyseUsbParam usb;

    public BusAnalyseParam() {
        super(0);
        this.analyse_select = DEFAULT_ANASELECT;
        this.usb = new BusAnalyseUsbParam();
        this.eth = new BusAnalyseEthParam();
    }

    @Bindable
    public int getAnalyse_select() {
        return this.analyse_select;
    }

    public void setAnalyse_select(int i) {
        this.analyse_select = i;
        notifyPropertyChanged(45);
    }

    public BusAnalyseUsbParam getUsb() {
        return this.usb;
    }

    public BusAnalyseEthParam getEth() {
        return this.eth;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        super.readAll();
        this.usb.readAll();
        this.eth.readAll();
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        OptionParam value;
        super.reset();
        this.usb.reset();
        this.eth.reset();
        int i = DEFAULT_ANASELECT;
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null && (value = optionViewModel.getLiveData().getValue()) != null && !value.get(ServiceEnum.OptType.OPT_CM_USB)) {
            i = ServiceEnum.BusAnalyseType.AnalyseEth.value1;
        }
        setAnalyse_select(i);
    }
}
