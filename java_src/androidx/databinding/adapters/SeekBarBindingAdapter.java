package androidx.databinding.adapters;

import android.widget.SeekBar;
import androidx.databinding.InverseBindingListener;
/* loaded from: classes.dex */
public class SeekBarBindingAdapter {

    /* loaded from: classes.dex */
    public interface OnProgressChanged {
        void onProgressChanged(SeekBar seekBar, int i, boolean z);
    }

    /* loaded from: classes.dex */
    public interface OnStartTrackingTouch {
        void onStartTrackingTouch(SeekBar seekBar);
    }

    /* loaded from: classes.dex */
    public interface OnStopTrackingTouch {
        void onStopTrackingTouch(SeekBar seekBar);
    }

    public static void setProgress(SeekBar seekBar, int i) {
        if (i != seekBar.getProgress()) {
            seekBar.setProgress(i);
        }
    }

    public static void setOnSeekBarChangeListener(SeekBar seekBar, final OnStartTrackingTouch onStartTrackingTouch, final OnStopTrackingTouch onStopTrackingTouch, final OnProgressChanged onProgressChanged, final InverseBindingListener inverseBindingListener) {
        if (onStartTrackingTouch == null && onStopTrackingTouch == null && onProgressChanged == null && inverseBindingListener == null) {
            seekBar.setOnSeekBarChangeListener(null);
        } else {
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: androidx.databinding.adapters.SeekBarBindingAdapter.1
                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onProgressChanged(SeekBar seekBar2, int i, boolean z) {
                    OnProgressChanged onProgressChanged2 = OnProgressChanged.this;
                    if (onProgressChanged2 != null) {
                        onProgressChanged2.onProgressChanged(seekBar2, i, z);
                    }
                    InverseBindingListener inverseBindingListener2 = inverseBindingListener;
                    if (inverseBindingListener2 != null) {
                        inverseBindingListener2.onChange();
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStartTrackingTouch(SeekBar seekBar2) {
                    OnStartTrackingTouch onStartTrackingTouch2 = onStartTrackingTouch;
                    if (onStartTrackingTouch2 != null) {
                        onStartTrackingTouch2.onStartTrackingTouch(seekBar2);
                    }
                }

                @Override // android.widget.SeekBar.OnSeekBarChangeListener
                public void onStopTrackingTouch(SeekBar seekBar2) {
                    OnStopTrackingTouch onStopTrackingTouch2 = onStopTrackingTouch;
                    if (onStopTrackingTouch2 != null) {
                        onStopTrackingTouch2.onStopTrackingTouch(seekBar2);
                    }
                }
            });
        }
    }
}
