package androidx.databinding.adapters;

import android.widget.RadioGroup;
import androidx.databinding.InverseBindingListener;
/* loaded from: classes.dex */
public class RadioGroupBindingAdapter {
    public static void setCheckedButton(RadioGroup radioGroup, int i) {
        if (i != radioGroup.getCheckedRadioButtonId()) {
            radioGroup.check(i);
        }
    }

    public static void setListeners(RadioGroup radioGroup, final RadioGroup.OnCheckedChangeListener onCheckedChangeListener, final InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener == null) {
            radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);
        } else {
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: androidx.databinding.adapters.RadioGroupBindingAdapter.1
                @Override // android.widget.RadioGroup.OnCheckedChangeListener
                public void onCheckedChanged(RadioGroup radioGroup2, int i) {
                    RadioGroup.OnCheckedChangeListener onCheckedChangeListener2 = onCheckedChangeListener;
                    if (onCheckedChangeListener2 != null) {
                        onCheckedChangeListener2.onCheckedChanged(radioGroup2, i);
                    }
                    inverseBindingListener.onChange();
                }
            });
        }
    }
}
