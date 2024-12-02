package com.rigol.scope.views.bode;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.PopuviewMiniBodeBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.views.baseview.BasePopupView;

/* loaded from: classes2.dex */
public class BodeResultPopuwin extends BasePopupView implements View.OnClickListener {
    private final String SMALLER;
    PopuviewMiniBodeBinding binding;
    BodeParam bodeParam;
    private ImageView small;

    public BodeResultPopuwin() {
        super((int) R.style.App_PopupWindow_MINIBODE);
        this.SMALLER = "ic_smaller";
        PopuviewMiniBodeBinding inflate = PopuviewMiniBodeBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        BodeParam value = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue();
        this.bodeParam = value;
        this.binding.setParma(value);
        ViewUtil.setSwitchButton(this.binding.showBodeSwitch);
        ImageView imageView = (ImageView) this.binding.getRoot().findViewById(R.id.small);
        this.small = imageView;
        imageView.setTag("ic_smaller");
        this.small.setVisibility(0);
        this.small.setOnClickListener(this);
        this.small.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_bigger));
        this.binding.showBodeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.bode.BodeResultPopuwin.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (compoundButton.isPressed()) {
                    if (z) {
                        WindowHolderManager.getInstance().removeAll();
                        if (BodeResultPopuwin.this.bodeParam.getBodedispType() == 1) {
                            WindowParam windowParam = new WindowParam();
                            windowParam.setServiceID(61);
                            windowParam.setType(ServiceEnum.WindowType.WIN_BODE);
                            ((MainActivity) ActivityUtils.getTopActivity()).getWaveformFragment().addWindow(windowParam);
                        }
                    } else {
                        BodeResultPopuwin.this.bodeParam.setBodeImpedace(false);
                        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_BODE);
                    }
                    BodeResultPopuwin.this.bodeParam.saveBodeEnable(z);
                }
            }
        });
        this.binding.operateButton.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.bode.BodeResultPopuwin.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                BodeResultPopuwin.this.bodeParam.saveBodeRunStopEnable(!BodeResultPopuwin.this.bodeParam.getBodeRunStopEnable());
            }
        });
        this.bodeParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.bode.BodeResultPopuwin.3
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (i == 104) {
                    BodeResultPopuwin.this.binding.getRoot().findViewById(R.id.close);
                    if (BodeResultPopuwin.this.bodeParam.getBodeRunStopEnable()) {
                        BodeResultPopuwin.this.setOutsideTouchable(false);
                    } else {
                        BodeResultPopuwin.this.setOutsideTouchable(true);
                    }
                    BodeResultPopuwin.this.update();
                }
            }
        });
    }

    public BodeResultPopuwin(Context context) {
        super(context);
        this.SMALLER = "ic_smaller";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (!this.bodeParam.getBodeMinPop()) {
            PopupViewManager.getInstance().dismiss(BodeResultPopuwin.class);
            this.bodeParam.setBodeshow(true);
            PopupViewManager.getInstance().toggle(BodePopupWin.class);
            return;
        }
        PopupViewManager.getInstance().dismiss(BodePopupWin.class);
        this.bodeParam.setBodeshow(false);
        PopupViewManager.getInstance().toggle(BodeResultPopuwin.class);
    }
}
