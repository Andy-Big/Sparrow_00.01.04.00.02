package com.rigol.scope.views.la;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.Observable;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.databinding.PopupviewLaCalibrationBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.LaViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
/* loaded from: classes2.dex */
public class LaCalibrationPopuView extends BasePopupView {
    LaParam laParam;
    PopupviewLaCalibrationBinding popupviewLaCalibrationBinding;

    public LaCalibrationPopuView() {
        super((int) R.style.App_PopupWindow_Calibration);
        PopupviewLaCalibrationBinding inflate = PopupviewLaCalibrationBinding.inflate(LayoutInflater.from(this.context));
        this.popupviewLaCalibrationBinding = inflate;
        setContentView(inflate.getRoot());
        LaParam value = ((LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class)).getValue();
        this.laParam = value;
        this.popupviewLaCalibrationBinding.setLaParam(value);
        this.laParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.la.LaCalibrationPopuView.1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (i == 469) {
                    if (LaCalibrationPopuView.this.laParam.getLa_probe_cal_pro() == 2) {
                        LaCalibrationPopuView.this.popupviewLaCalibrationBinding.resultContent.setTextColor(LaCalibrationPopuView.this.context.getColor(R.color.lime));
                    } else if (LaCalibrationPopuView.this.laParam.getLa_probe_cal_pro() == 0) {
                        LaCalibrationPopuView.this.popupviewLaCalibrationBinding.resultContent.setTextColor(LaCalibrationPopuView.this.context.getColor(R.color.white));
                    }
                }
            }
        });
        this.popupviewLaCalibrationBinding.startOrStop.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.la.LaCalibrationPopuView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class)).getLiveData().getValue().setLaProbeCalPros(1);
                ((LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class)).getLiveData().getValue().saveCalibrationEnable(true);
            }
        });
    }
}
