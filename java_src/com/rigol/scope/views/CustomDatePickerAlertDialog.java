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
import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import com.blankj.utilcode.util.ConvertUtils;
import com.rigol.scope.R;
import com.rigol.scope.databinding.CustomDatepickerDialogAntBinding;
import com.rigol.scope.views.baseview.BasePopupView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/* loaded from: classes2.dex */
public class CustomDatePickerAlertDialog extends BasePopupView {
    private final Context context;
    private int day;
    private final AlertDialog dialog;
    private CustomDatepickerDialogAntBinding dialogBinding;
    private View dialogView;
    private int month;
    private int year;

    /* loaded from: classes2.dex */
    public interface AntDatePickerDialogClickListener {
        void onClick(View view, int i, int i2, int i3);
    }

    public CustomDatePickerAlertDialog(Context context, int i, int i2, int i3) {
        super((int) R.style.App_PopupWindow_Date);
        this.context = context;
        this.dialog = new AlertDialog.Builder(context).create();
        initDate(i, i2, i3);
        initDialogView();
    }

    private void initDate(int i, int i2, int i3) {
        if (i == 0 || i3 == 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.get(1);
            this.month = calendar.get(2);
            this.day = calendar.get(5);
            return;
        }
        this.year = i;
        this.month = i2;
        this.day = i3;
    }

    private void initDialogView() {
        CustomDatepickerDialogAntBinding customDatepickerDialogAntBinding = (CustomDatepickerDialogAntBinding) DataBindingUtil.inflate(LayoutInflater.from(this.context), R.layout.custom_datepicker_dialog_ant, null, false);
        this.dialogBinding = customDatepickerDialogAntBinding;
        View root = customDatepickerDialogAntBinding.getRoot();
        this.dialogView = root;
        this.dialog.setView(root);
        setDimAmount(0.15f);
        initDatePicker();
        ((ImageView) this.dialogBinding.getRoot().findViewById(R.id.close)).setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.CustomDatePickerAlertDialog.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                CustomDatePickerAlertDialog.this.dialog.dismiss();
            }
        });
        ((TextView) this.dialogBinding.getRoot().findViewById(R.id.title)).setText(this.context.getText(R.string.msg_app_utility_date));
    }

    private void initDatePicker() {
        DatePicker datePicker = this.dialogBinding.datePicker;
        datePicker.init(this.year, this.month, this.day, new DatePicker.OnDateChangedListener() { // from class: com.rigol.scope.views.CustomDatePickerAlertDialog.2
            @Override // android.widget.DatePicker.OnDateChangedListener
            public void onDateChanged(DatePicker datePicker2, int i, int i2, int i3) {
                CustomDatePickerAlertDialog.this.year = i;
                CustomDatePickerAlertDialog.this.month = i2;
                CustomDatePickerAlertDialog.this.day = i3;
                CustomDatePickerAlertDialog.this.resizePikcer(datePicker2);
            }
        });
        Calendar calendar = Calendar.getInstance();
        calendar.set(1970, 0, 2, 0, 0, 1);
        datePicker.setMinDate(calendar.getTimeInMillis());
        calendar.set(2037, 11, 31, 0, 0, 1);
        datePicker.setMaxDate(calendar.getTimeInMillis());
        resizePikcer(datePicker);
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

    public void setPositiveButton(final AntDatePickerDialogClickListener antDatePickerDialogClickListener) {
        this.dialogBinding.confirmButton.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.CustomDatePickerAlertDialog.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AntDatePickerDialogClickListener antDatePickerDialogClickListener2 = antDatePickerDialogClickListener;
                if (antDatePickerDialogClickListener2 != null) {
                    antDatePickerDialogClickListener2.onClick(view, CustomDatePickerAlertDialog.this.year, CustomDatePickerAlertDialog.this.month, CustomDatePickerAlertDialog.this.day);
                }
                CustomDatePickerAlertDialog.this.dismissDialog();
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
