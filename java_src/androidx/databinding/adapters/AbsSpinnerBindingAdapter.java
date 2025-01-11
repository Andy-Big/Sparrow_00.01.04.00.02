package androidx.databinding.adapters;

import android.widget.AbsSpinner;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;
import java.util.List;

/* loaded from: classes.dex */
public class AbsSpinnerBindingAdapter {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <T extends CharSequence> void setEntries(AbsSpinner absSpinner, T[] tArr) {
        if (tArr != null) {
            SpinnerAdapter adapter = absSpinner.getAdapter();
            boolean z = false;
            if (adapter != null && adapter.getCount() == tArr.length) {
                for (int i = 0; i < tArr.length; i++) {
                    if (tArr[i].equals(adapter.getItem(i))) {
                    }
                }
                if (z) {
                    return;
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(absSpinner.getContext(), 17367048, tArr);
                arrayAdapter.setDropDownViewResource(17367049);
                absSpinner.setAdapter((SpinnerAdapter) arrayAdapter);
                return;
            }
            z = true;
            if (z) {
            }
        } else {
            absSpinner.setAdapter((SpinnerAdapter) null);
        }
    }

    public static <T> void setEntries(AbsSpinner absSpinner, List<T> list) {
        if (list != null) {
            SpinnerAdapter adapter = absSpinner.getAdapter();
            if (adapter instanceof ObservableListAdapter) {
                ((ObservableListAdapter) adapter).setList(list);
                return;
            } else {
                absSpinner.setAdapter((SpinnerAdapter) new ObservableListAdapter(absSpinner.getContext(), list, 17367048, 17367049, 0));
                return;
            }
        }
        absSpinner.setAdapter((SpinnerAdapter) null);
    }
}
