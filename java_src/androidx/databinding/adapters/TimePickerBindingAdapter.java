package androidx.databinding.adapters;

import android.os.Build;
import android.widget.TimePicker;
import androidx.databinding.InverseBindingListener;
/* loaded from: classes.dex */
public class TimePickerBindingAdapter {
    public static void setHour(TimePicker timePicker, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (timePicker.getHour() != i) {
                timePicker.setHour(i);
            }
        } else if (timePicker.getCurrentHour().intValue() != i) {
            timePicker.setCurrentHour(Integer.valueOf(i));
        }
    }

    public static void setMinute(TimePicker timePicker, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (timePicker.getMinute() != i) {
                timePicker.setMinute(i);
            }
        } else if (timePicker.getCurrentMinute().intValue() != i) {
            timePicker.setCurrentHour(Integer.valueOf(i));
        }
    }

    public static int getHour(TimePicker timePicker) {
        if (Build.VERSION.SDK_INT >= 23) {
            return timePicker.getHour();
        }
        Integer currentHour = timePicker.getCurrentHour();
        if (currentHour == null) {
            return 0;
        }
        return currentHour.intValue();
    }

    public static int getMinute(TimePicker timePicker) {
        if (Build.VERSION.SDK_INT >= 23) {
            return timePicker.getMinute();
        }
        Integer currentMinute = timePicker.getCurrentMinute();
        if (currentMinute == null) {
            return 0;
        }
        return currentMinute.intValue();
    }

    public static void setListeners(TimePicker timePicker, final TimePicker.OnTimeChangedListener onTimeChangedListener, final InverseBindingListener inverseBindingListener, final InverseBindingListener inverseBindingListener2) {
        if (inverseBindingListener == null && inverseBindingListener2 == null) {
            timePicker.setOnTimeChangedListener(onTimeChangedListener);
        } else {
            timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() { // from class: androidx.databinding.adapters.TimePickerBindingAdapter.1
                @Override // android.widget.TimePicker.OnTimeChangedListener
                public void onTimeChanged(TimePicker timePicker2, int i, int i2) {
                    TimePicker.OnTimeChangedListener onTimeChangedListener2 = onTimeChangedListener;
                    if (onTimeChangedListener2 != null) {
                        onTimeChangedListener2.onTimeChanged(timePicker2, i, i2);
                    }
                    InverseBindingListener inverseBindingListener3 = inverseBindingListener;
                    if (inverseBindingListener3 != null) {
                        inverseBindingListener3.onChange();
                    }
                    InverseBindingListener inverseBindingListener4 = inverseBindingListener2;
                    if (inverseBindingListener4 != null) {
                        inverseBindingListener4.onChange();
                    }
                }
            });
        }
    }
}
