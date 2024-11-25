package androidx.databinding.adapters;

import android.widget.CalendarView;
import androidx.databinding.InverseBindingListener;
/* loaded from: classes.dex */
public class CalendarViewBindingAdapter {
    public static void setDate(CalendarView calendarView, long j) {
        if (calendarView.getDate() != j) {
            calendarView.setDate(j);
        }
    }

    public static void setListeners(CalendarView calendarView, final CalendarView.OnDateChangeListener onDateChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            calendarView.setOnDateChangeListener(onDateChangeListener);
        } else {
            calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() { // from class: androidx.databinding.adapters.CalendarViewBindingAdapter.1
                @Override // android.widget.CalendarView.OnDateChangeListener
                public void onSelectedDayChange(CalendarView calendarView2, int i, int i2, int i3) {
                    CalendarView.OnDateChangeListener onDateChangeListener2 = onDateChangeListener;
                    if (onDateChangeListener2 != null) {
                        onDateChangeListener2.onSelectedDayChange(calendarView2, i, i2, i3);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
