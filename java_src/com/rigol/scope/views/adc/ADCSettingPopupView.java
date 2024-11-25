package com.rigol.scope.views.adc;

import android.view.LayoutInflater;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import com.rigol.scope.R;
import com.rigol.scope.databinding.PopupviewAdcSettingBinding;
import com.rigol.scope.views.baseview.BasePopupView;
/* loaded from: classes2.dex */
public class ADCSettingPopupView extends BasePopupView implements CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {
    private final AdcSettingParam param;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public ADCSettingPopupView() {
        super((int) R.style.App_PopupWindow_ADCTest);
        PopupviewAdcSettingBinding inflate = PopupviewAdcSettingBinding.inflate(LayoutInflater.from(this.context));
        setContentView(inflate.getRoot());
        getContentView().setOnTouchListener(null);
        AdcSettingParam adcSettingParam = new AdcSettingParam();
        this.param = adcSettingParam;
        adcSettingParam.readAll();
        inflate.setParam(this.param);
        inflate.adc1FlipCheckbox.setOnCheckedChangeListener(this);
        inflate.adc2FlipCheckbox.setOnCheckedChangeListener(this);
        inflate.adc1CoarseSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc2CoarseSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc1InterSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc2InterSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc1FineSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc2FineSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc1ASeekBar.setOnSeekBarChangeListener(this);
        inflate.adc1BSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc1CSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc1DSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc2ASeekBar.setOnSeekBarChangeListener(this);
        inflate.adc2BSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc2CSeekBar.setOnSeekBarChangeListener(this);
        inflate.adc2DSeekBar.setOnSeekBarChangeListener(this);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            if (compoundButton.getId() == R.id.adc1_flip_checkbox) {
                this.param.saveFlip1(z);
            } else if (compoundButton.getId() == R.id.adc2_flip_checkbox) {
                this.param.saveFlip2(z);
            }
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        if (z) {
            if (seekBar.getId() == R.id.adc1_coarse_seek_bar) {
                AdcSettingParam adcSettingParam = this.param;
                adcSettingParam.saveCoarse1(adcSettingParam.getCoarseProgress(i));
            } else if (seekBar.getId() == R.id.adc2_coarse_seek_bar) {
                AdcSettingParam adcSettingParam2 = this.param;
                adcSettingParam2.saveCoarse2(adcSettingParam2.getCoarseProgress(i));
            } else if (seekBar.getId() == R.id.adc1_inter_seek_bar) {
                AdcSettingParam adcSettingParam3 = this.param;
                adcSettingParam3.saveInter1(adcSettingParam3.getInterProgress(i));
            } else if (seekBar.getId() == R.id.adc2_inter_seek_bar) {
                AdcSettingParam adcSettingParam4 = this.param;
                adcSettingParam4.saveInter2(adcSettingParam4.getInterProgress(i));
            } else if (seekBar.getId() == R.id.adc1_fine_seek_bar) {
                AdcSettingParam adcSettingParam5 = this.param;
                adcSettingParam5.saveFine1(adcSettingParam5.getFineProgress(i));
            } else if (seekBar.getId() == R.id.adc2_fine_seek_bar) {
                AdcSettingParam adcSettingParam6 = this.param;
                adcSettingParam6.saveFine2(adcSettingParam6.getFineProgress(i));
            } else if (seekBar.getId() == R.id.adc1_a_seek_bar) {
                AdcSettingParam adcSettingParam7 = this.param;
                adcSettingParam7.savePhase1Core1(adcSettingParam7.getProgress2(i));
            } else if (seekBar.getId() == R.id.adc1_b_seek_bar) {
                AdcSettingParam adcSettingParam8 = this.param;
                adcSettingParam8.savePhase1Core2(adcSettingParam8.getProgress2(i));
            } else if (seekBar.getId() == R.id.adc1_c_seek_bar) {
                AdcSettingParam adcSettingParam9 = this.param;
                adcSettingParam9.savePhase1Core3(adcSettingParam9.getProgress2(i));
            } else if (seekBar.getId() == R.id.adc1_d_seek_bar) {
                AdcSettingParam adcSettingParam10 = this.param;
                adcSettingParam10.savePhase1Core4(adcSettingParam10.getProgress2(i));
            } else if (seekBar.getId() == R.id.adc2_a_seek_bar) {
                AdcSettingParam adcSettingParam11 = this.param;
                adcSettingParam11.savePhase2Core1(adcSettingParam11.getProgress2(i));
            } else if (seekBar.getId() == R.id.adc2_b_seek_bar) {
                AdcSettingParam adcSettingParam12 = this.param;
                adcSettingParam12.savePhase2Core2(adcSettingParam12.getProgress2(i));
            } else if (seekBar.getId() == R.id.adc2_c_seek_bar) {
                AdcSettingParam adcSettingParam13 = this.param;
                adcSettingParam13.savePhase2Core3(adcSettingParam13.getProgress2(i));
            } else if (seekBar.getId() == R.id.adc2_d_seek_bar) {
                AdcSettingParam adcSettingParam14 = this.param;
                adcSettingParam14.savePhase2Core4(adcSettingParam14.getProgress2(i));
            }
        }
    }
}
