package com.rigol.scope.views.adc;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import com.rigol.scope.R;
import com.rigol.scope.databinding.PopupviewAdcserBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.baseview.BasePopupView;
/* loaded from: classes2.dex */
public class AdcSerPopupView extends BasePopupView implements CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener, View.OnClickListener {
    private final AdcSerParam param;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public AdcSerPopupView() {
        super((int) R.style.App_PopupWindow_ADCSer);
        PopupviewAdcserBinding inflate = PopupviewAdcserBinding.inflate(LayoutInflater.from(this.context));
        setContentView(inflate.getRoot());
        AdcSerParam adcSerParam = new AdcSerParam();
        this.param = adcSerParam;
        adcSerParam.readAll();
        inflate.setParam(this.param);
        ViewUtil.setSwitchButton(inflate.adc1TdmxSwitch);
        ViewUtil.setSwitchButton(inflate.adc2TdmxSwitch);
        ViewUtil.setSwitchButton(inflate.adc3TdmxSwitch);
        ViewUtil.setSwitchButton(inflate.adc4TdmxSwitch);
        inflate.adc1TdmxSwitch.setOnCheckedChangeListener(this);
        inflate.adc2TdmxSwitch.setOnCheckedChangeListener(this);
        inflate.adc3TdmxSwitch.setOnCheckedChangeListener(this);
        inflate.adc4TdmxSwitch.setOnCheckedChangeListener(this);
        inflate.adc1TcmpSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc2TcmpSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc3TcmpSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc4TcmpSeekBar.setOnSeekBarChangeListener(this);
        inflate.saveBtn.setOnClickListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            if (compoundButton.getId() == R.id.adc1_tdmx_switch) {
                this.param.saveAdc1Tdmx(z);
            } else if (compoundButton.getId() == R.id.adc2_tdmx_switch) {
                this.param.saveAdc2Tdmx(z);
            } else if (compoundButton.getId() == R.id.adc3_tdmx_switch) {
                this.param.saveAdc3Tdmx(z);
            } else if (compoundButton.getId() == R.id.adc4_tdmx_switch) {
                this.param.saveAdc4Tdmx(z);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            if (seekBar.getId() == R.id.adc1_tcmp_seek_bar) {
                this.param.saveAdc1Tcmp(i);
            } else if (seekBar.getId() == R.id.adc2_tcmp_seek_bar) {
                this.param.saveAdc2Tcmp(i);
            } else if (seekBar.getId() == R.id.adc3_tcmp_seek_bar) {
                this.param.saveAdc3Tcmp(i);
            } else if (seekBar.getId() == R.id.adc4_tcmp_seek_bar) {
                this.param.saveAdc4Tcmp(i);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.isPressed() && view.getId() == R.id.save_btn) {
            this.param.doSave();
        }
    }
}
