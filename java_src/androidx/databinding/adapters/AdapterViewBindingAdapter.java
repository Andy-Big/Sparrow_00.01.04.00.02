package androidx.databinding.adapters;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.databinding.InverseBindingListener;
/* loaded from: classes.dex */
public class AdapterViewBindingAdapter {

    /* loaded from: classes.dex */
    public interface OnItemSelected {
        void onItemSelected(AdapterView<?> adapterView, View view, int i, long j);
    }

    /* loaded from: classes.dex */
    public interface OnNothingSelected {
        void onNothingSelected(AdapterView<?> adapterView);
    }

    public static void setSelectedItemPosition(AdapterView adapterView, int i) {
        if (adapterView.getSelectedItemPosition() != i) {
            adapterView.setSelection(i);
        }
    }

    public static void setSelection(AdapterView adapterView, int i) {
        setSelectedItemPosition(adapterView, i);
    }

    public static void setSelectedItemPosition(AdapterView adapterView, int i, Adapter adapter) {
        if (adapter != adapterView.getAdapter()) {
            adapterView.setAdapter(adapter);
            adapterView.setSelection(i);
        } else if (adapterView.getSelectedItemPosition() != i) {
            adapterView.setSelection(i);
        }
    }

    public static void setSelection(AdapterView adapterView, int i, Adapter adapter) {
        setSelectedItemPosition(adapterView, i, adapter);
    }

    public static void setOnItemSelectedListener(AdapterView adapterView, OnItemSelected onItemSelected, OnNothingSelected onNothingSelected, InverseBindingListener inverseBindingListener) {
        if (onItemSelected == null && onNothingSelected == null && inverseBindingListener == null) {
            adapterView.setOnItemSelectedListener(null);
        } else {
            adapterView.setOnItemSelectedListener(new OnItemSelectedComponentListener(onItemSelected, onNothingSelected, inverseBindingListener));
        }
    }

    /* loaded from: classes.dex */
    public static class OnItemSelectedComponentListener implements AdapterView.OnItemSelectedListener {
        private final InverseBindingListener mAttrChanged;
        private final OnNothingSelected mNothingSelected;
        private final OnItemSelected mSelected;

        public OnItemSelectedComponentListener(OnItemSelected onItemSelected, OnNothingSelected onNothingSelected, InverseBindingListener inverseBindingListener) {
            this.mSelected = onItemSelected;
            this.mNothingSelected = onNothingSelected;
            this.mAttrChanged = inverseBindingListener;
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            OnItemSelected onItemSelected = this.mSelected;
            if (onItemSelected != null) {
                onItemSelected.onItemSelected(adapterView, view, i, j);
            }
            InverseBindingListener inverseBindingListener = this.mAttrChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            OnNothingSelected onNothingSelected = this.mNothingSelected;
            if (onNothingSelected != null) {
                onNothingSelected.onNothingSelected(adapterView);
            }
            InverseBindingListener inverseBindingListener = this.mAttrChanged;
            if (inverseBindingListener != null) {
                inverseBindingListener.onChange();
            }
        }
    }
}
