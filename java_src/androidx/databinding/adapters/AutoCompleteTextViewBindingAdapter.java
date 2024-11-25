package androidx.databinding.adapters;

import android.widget.AutoCompleteTextView;
import androidx.databinding.adapters.AdapterViewBindingAdapter;
/* loaded from: classes.dex */
public class AutoCompleteTextViewBindingAdapter {

    /* loaded from: classes.dex */
    public interface FixText {
        CharSequence fixText(CharSequence charSequence);
    }

    /* loaded from: classes.dex */
    public interface IsValid {
        boolean isValid(CharSequence charSequence);
    }

    public static void setValidator(AutoCompleteTextView autoCompleteTextView, final FixText fixText, final IsValid isValid) {
        if (fixText == null && isValid == null) {
            autoCompleteTextView.setValidator(null);
        } else {
            autoCompleteTextView.setValidator(new AutoCompleteTextView.Validator() { // from class: androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.1
                @Override // android.widget.AutoCompleteTextView.Validator
                public boolean isValid(CharSequence charSequence) {
                    IsValid isValid2 = IsValid.this;
                    if (isValid2 != null) {
                        return isValid2.isValid(charSequence);
                    }
                    return true;
                }

                @Override // android.widget.AutoCompleteTextView.Validator
                public CharSequence fixText(CharSequence charSequence) {
                    FixText fixText2 = fixText;
                    return fixText2 != null ? fixText2.fixText(charSequence) : charSequence;
                }
            });
        }
    }

    public static void setOnItemSelectedListener(AutoCompleteTextView autoCompleteTextView, AdapterViewBindingAdapter.OnItemSelected onItemSelected, AdapterViewBindingAdapter.OnNothingSelected onNothingSelected) {
        if (onItemSelected == null && onNothingSelected == null) {
            autoCompleteTextView.setOnItemSelectedListener(null);
        } else {
            autoCompleteTextView.setOnItemSelectedListener(new AdapterViewBindingAdapter.OnItemSelectedComponentListener(onItemSelected, onNothingSelected, null));
        }
    }
}
