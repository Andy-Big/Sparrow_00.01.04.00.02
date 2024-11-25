package com.rigol.scope.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.FlexKnobParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
/* loaded from: classes2.dex */
public class FlexKnobParamViewModel extends ViewModel {
    private MutableLiveData<FlexKnobParam> paramMutableLiveData = new MutableLiveData<>();

    public MutableLiveData<FlexKnobParam> getParam() {
        this.paramMutableLiveData.setValue(new FlexKnobParam());
        return this.paramMutableLiveData;
    }

    public void refreshCHList() {
        FlexKnobViewModel flexKnobViewModel = (FlexKnobViewModel) ContextUtil.getAppViewModel(FlexKnobViewModel.class);
        if (flexKnobViewModel != null) {
            flexKnobViewModel.getLiveData();
            FlexKnobParam value = flexKnobViewModel.getLiveData().getValue();
            if (value != null) {
                value.readCHList();
            }
        }
    }

    public boolean isFlexAutoDirection() {
        FlexKnobViewModel flexKnobViewModel = (FlexKnobViewModel) ContextUtil.getAppViewModel(FlexKnobViewModel.class);
        if (flexKnobViewModel != null) {
            flexKnobViewModel.getLiveData();
            FlexKnobParam value = flexKnobViewModel.getLiveData().getValue();
            if (value != null) {
                return value.isCheckDirection();
            }
        }
        return false;
    }

    public boolean isAllowSetFlexParam(boolean z) {
        if (isFlexAutoDirection()) {
            if (FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                FunctionManager.getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Cursor);
                return false;
            }
            return true;
        }
        return z;
    }
}
