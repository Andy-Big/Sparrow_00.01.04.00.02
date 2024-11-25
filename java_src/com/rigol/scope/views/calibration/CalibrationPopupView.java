package com.rigol.scope.views.calibration;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.CalibrationParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.PopupviewCalibrationBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.CalibrationViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import java.util.Objects;
/* loaded from: classes2.dex */
public class CalibrationPopupView extends BasePopupView implements View.OnClickListener {
    private final PopupviewCalibrationBinding binding;
    StringBuilder builder;
    private CalibrationParam calibrationParam;
    final int[] i;
    private final ObservableBoolean isProbe;
    private int probeCalServiceID;
    private SyncDataViewModel syncDataViewModel;
    private final Runnable testAutoMessageRunnable;

    /* loaded from: classes2.dex */
    public static abstract class AutoScrollTextWatcher implements TextWatcher {
        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    public CalibrationPopupView() {
        super((int) R.style.App_PopupWindow_Calibration);
        this.isProbe = new ObservableBoolean(false);
        this.probeCalServiceID = 1;
        this.i = new int[]{0};
        this.builder = new StringBuilder("start\r\n");
        this.testAutoMessageRunnable = new Runnable() { // from class: com.rigol.scope.views.calibration.CalibrationPopupView.3
            @Override // java.lang.Runnable
            public void run() {
                int[] iArr = CalibrationPopupView.this.i;
                iArr[0] = iArr[0] + 1;
                StringBuilder sb = CalibrationPopupView.this.builder;
                sb.append("message");
                sb.append(CalibrationPopupView.this.i[0]);
                sb.append("\r\n");
                CalibrationPopupView.this.calibrationParam.setDetail(CalibrationPopupView.this.builder.toString());
            }
        };
        PopupviewCalibrationBinding inflate = PopupviewCalibrationBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.setOnClickListener(this);
        CalibrationViewModel calibrationViewModel = (CalibrationViewModel) ContextUtil.getAppViewModel(CalibrationViewModel.class);
        if (calibrationViewModel != null) {
            calibrationViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.calibration.-$$Lambda$CalibrationPopupView$BcJKAMtVcbtZUByWtSPecyntyls
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CalibrationPopupView.this.lambda$new$0$CalibrationPopupView((CalibrationParam) obj);
                }
            });
        }
        if (this.syncDataViewModel == null) {
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            this.syncDataViewModel = syncDataViewModel;
            if (syncDataViewModel != null) {
                syncDataViewModel.get(9, MessageID.MSG_SELF_CAL_START).observe((LifecycleOwner) this.context, new Observer<Object>() { // from class: com.rigol.scope.views.calibration.CalibrationPopupView.1
                    @Override // androidx.lifecycle.Observer
                    public void onChanged(Object obj) {
                        CalibrationPopupView.this.startOrStopCalibration();
                    }
                });
            }
        }
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null) {
            final PopupviewCalibrationBinding popupviewCalibrationBinding = this.binding;
            Objects.requireNonNull(popupviewCalibrationBinding);
            utilityViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.calibration.-$$Lambda$x3-SFN7jBURcTTkXC_78xc3IbSg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PopupviewCalibrationBinding.this.setUtilityParam((UtilityParam) obj);
                }
            });
        }
        this.binding.detailContent.addTextChangedListener(new AutoScrollTextWatcher() { // from class: com.rigol.scope.views.calibration.CalibrationPopupView.2
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                CalibrationPopupView.this.binding.detailScroll.fullScroll(130);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$CalibrationPopupView(CalibrationParam calibrationParam) {
        this.calibrationParam = calibrationParam;
        this.binding.setCalibrationParam(calibrationParam);
        this.binding.setIsProbe(this.isProbe);
    }

    public void setProbe(boolean z) {
        this.isProbe.set(z);
    }

    public boolean isProbe() {
        return this.isProbe.get();
    }

    public void setProbeCalServiceID(int i) {
        this.probeCalServiceID = i;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.calibrationParam == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.detail_arrow) {
            CalibrationParam calibrationParam = this.calibrationParam;
            calibrationParam.setShowDetail(!calibrationParam.isShowDetail());
        } else if (id != R.id.close) {
            if (id == R.id.start_or_stop) {
                startOrStopCalibration();
            }
        } else {
            dismiss();
            if (this.calibrationParam.isStarted()) {
                this.calibrationParam.postQuit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startOrStopCalibration() {
        VerticalParam verticalItem;
        CalibrationParam calibrationParam = this.calibrationParam;
        if (calibrationParam == null) {
            return;
        }
        if (!calibrationParam.isStarted() && this.isProbe.get()) {
            VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
            if (verticalViewModel == null || (verticalItem = ViewUtil.getVerticalItem(verticalViewModel.getLiveData().getValue(), this.probeCalServiceID - 1)) == null) {
                return;
            }
            verticalItem.probeCal();
            return;
        }
        this.calibrationParam.start();
    }

    private void scrollToBottom(TextView textView) {
        int lineCount = textView.getLineCount();
        int lineHeight = textView.getLineHeight();
        int height = textView.getHeight();
        int i = lineCount * lineHeight;
        if (i > height) {
            textView.scrollTo(0, ((i - height) - textView.getPaddingTop()) - ((ConstraintLayout.LayoutParams) textView.getLayoutParams()).topMargin);
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        PopupviewCalibrationBinding popupviewCalibrationBinding = this.binding;
        if (popupviewCalibrationBinding != null) {
            popupviewCalibrationBinding.noticeContent.setText(this.isProbe.get() ? R.string.inf_cal_probe : R.string.inf_cal_info);
        }
    }
}
