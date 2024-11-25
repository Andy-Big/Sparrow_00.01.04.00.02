package com.rigol.scope.views;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import com.blankj.utilcode.util.ConvertUtils;
import com.rigol.scope.R;
import com.rigol.scope.databinding.CustomTimepickerDialogAntBinding;
import com.rigol.scope.views.baseview.BasePopupView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CustomTimePickerAlertDialog extends BasePopupView {
    private final Context context;
    private final AlertDialog dialog;
    private CustomTimepickerDialogAntBinding dialogBinding;
    private View dialogView;
    private int hourOfDay;
    private boolean is24HourView;
    private int minute;

    /* loaded from: classes2.dex */
    public interface AntTimePickerDialogClickListener {
        void onClick(View view, int i, int i2);
    }

    public CustomTimePickerAlertDialog(Context context, int i, int i2, boolean z) {
        super((int) R.style.App_PopupWindow_Time);
        this.context = context;
        this.dialog = new AlertDialog.Builder(context).create();
        initTime(i, i2, z);
        initDialogView();
    }

    private void initTime(int i, int i2, boolean z) {
        this.hourOfDay = i;
        this.minute = i2;
        this.is24HourView = z;
    }

    private void initDialogView() {
        CustomTimepickerDialogAntBinding customTimepickerDialogAntBinding = (CustomTimepickerDialogAntBinding) DataBindingUtil.inflate(LayoutInflater.from(this.context), R.layout.custom_timepicker_dialog_ant, null, false);
        this.dialogBinding = customTimepickerDialogAntBinding;
        View root = customTimepickerDialogAntBinding.getRoot();
        this.dialogView = root;
        this.dialog.setView(root);
        setDimAmount(0.15f);
        initTimePicker();
        ((ImageView) this.dialogBinding.getRoot().findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.CustomTimePickerAlertDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomTimePickerAlertDialog.this.dialog.dismiss();
            }
        });
        ((TextView) this.dialogBinding.getRoot().findViewById(R.id.title)).setText(this.context.getText(R.string.msg_app_utility_time));
    }

    private void initTimePicker() {
        TimePicker timePicker = this.dialogBinding.timePicker;
        timePicker.setHour(this.hourOfDay);
        timePicker.setMinute(this.minute);
        timePicker.setIs24HourView(Boolean.valueOf(this.is24HourView));
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: com.rigol.scope.views.CustomTimePickerAlertDialog.2
            @Override // android.widget.TimePicker.OnTimeChangedListener
            public void onTimeChanged(TimePicker timePicker2, int i, int i2) {
                CustomTimePickerAlertDialog.this.hourOfDay = i;
                CustomTimePickerAlertDialog.this.minute = i2;
                CustomTimePickerAlertDialog.this.resizePikcer(timePicker2);
            }
        });
        resizePikcer(timePicker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resizePikcer(FrameLayout frameLayout) {
        for (NumberPicker numberPicker : findNumberPicker(frameLayout)) {
            resizeNumberPicker(numberPicker);
            numberPicker.performClick();
        }
    }

    private List<NumberPicker> findNumberPicker(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof NumberPicker) {
                    arrayList.add((NumberPicker) childAt);
                } else if (childAt instanceof LinearLayout) {
                    List<NumberPicker> findNumberPicker = findNumberPicker((ViewGroup) childAt);
                    if (findNumberPicker.size() > 0) {
                        return findNumberPicker;
                    }
                } else {
                    continue;
                }
            }
        }
        return arrayList;
    }

    private void resizeNumberPicker(NumberPicker numberPicker) {
        setNumberPickerText(numberPicker);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ConvertUtils.dp2px(280.0f) / 3, -2);
        layoutParams.setMargins(10, 0, 10, 0);
        numberPicker.setLayoutParams(layoutParams);
    }

    public EditText setNumberPickerText(NumberPicker numberPicker) {
        try {
            Field declaredField = numberPicker.getClass().getDeclaredField("mInputText");
            declaredField.setAccessible(true);
            try {
                ((EditText) declaredField.get(numberPicker)).setTextSize(24.0f);
                ((EditText) declaredField.get(numberPicker)).setClickable(false);
                ((EditText) declaredField.get(numberPicker)).setFocusable(false);
                return (EditText) declaredField.get(numberPicker);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private void setPickerMargin(DatePicker datePicker) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) datePicker.getLayoutParams();
        layoutParams.width = ConvertUtils.dp2px(280.0f) / 3;
        layoutParams.height = ConvertUtils.dp2px(30.0f);
        layoutParams.setMargins(10, 0, 10, 0);
        if (Build.VERSION.SDK_INT > 17) {
            layoutParams.setMarginStart(0);
            layoutParams.setMarginEnd(0);
        }
        datePicker.setLayoutParams(layoutParams);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void show() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null || alertDialog.isShowing()) {
            return;
        }
        this.dialog.show();
    }

    public void dismissDialog() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.dialog.dismiss();
    }

    public View getDialogView() {
        return this.dialogView;
    }

    public Dialog getDialogObj() {
        return this.dialog;
    }

    public void setPositiveButton(final AntTimePickerDialogClickListener antTimePickerDialogClickListener) {
        this.dialogBinding.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.CustomTimePickerAlertDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AntTimePickerDialogClickListener antTimePickerDialogClickListener2 = antTimePickerDialogClickListener;
                if (antTimePickerDialogClickListener2 != null) {
                    antTimePickerDialogClickListener2.onClick(view, CustomTimePickerAlertDialog.this.hourOfDay, CustomTimePickerAlertDialog.this.minute);
                }
                CustomTimePickerAlertDialog.this.dismissDialog();
            }
        });
    }

    public void setDimAmount(float f) {
        Window window = this.dialog.getWindow();
        if (window != null) {
            if (f < 0.0f) {
                f = 0.0f;
            } else if (f > 1.0f) {
                f = 1.0f;
            }
            window.setDimAmount(f);
        }
    }

    public void setCancelable(boolean z) {
        this.dialog.setCancelable(z);
    }
}
