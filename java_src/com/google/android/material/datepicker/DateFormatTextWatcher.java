package com.google.android.material.datepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
/* loaded from: classes.dex */
abstract class DateFormatTextWatcher implements TextWatcher {
    private final CalendarConstraints constraints;
    private final DateFormat dateFormat;
    private final String formatHint;
    private final String outOfRange;
    private final TextInputLayout textInputLayout;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    void onInvalidDate() {
    }

    abstract void onValidDate(Long l);

    /* JADX INFO: Access modifiers changed from: package-private */
    public DateFormatTextWatcher(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.formatHint = str;
        this.dateFormat = dateFormat;
        this.textInputLayout = textInputLayout;
        this.constraints = calendarConstraints;
        this.outOfRange = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            this.textInputLayout.setError(null);
            onValidDate(null);
            return;
        }
        try {
            Date parse = this.dateFormat.parse(charSequence.toString());
            this.textInputLayout.setError(null);
            long time = parse.getTime();
            if (this.constraints.getDateValidator().isValid(time) && this.constraints.isWithinBounds(time)) {
                onValidDate(Long.valueOf(parse.getTime()));
            } else {
                this.textInputLayout.setError(String.format(this.outOfRange, DateStrings.getDateString(time)));
                onInvalidDate();
            }
        } catch (ParseException unused) {
            String string = this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format);
            String format = String.format(this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format_use), this.formatHint);
            String format2 = String.format(this.textInputLayout.getContext().getString(R.string.mtrl_picker_invalid_format_example), this.dateFormat.format(new Date(UtcDates.getTodayCalendar().getTimeInMillis())));
            TextInputLayout textInputLayout = this.textInputLayout;
            textInputLayout.setError(string + "\n" + format + "\n" + format2);
            onInvalidDate();
        }
    }
}
