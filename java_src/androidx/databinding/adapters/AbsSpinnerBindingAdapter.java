package androidx.databinding.adapters;

import android.widget.AbsSpinner;
import android.widget.SpinnerAdapter;
import java.util.List;
/* loaded from: classes.dex */
public class AbsSpinnerBindingAdapter {
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <T extends java.lang.CharSequence> void setEntries(android.widget.AbsSpinner r6, T[] r7) {
        /*
            if (r7 == 0) goto L3e
            android.widget.SpinnerAdapter r0 = r6.getAdapter()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L25
            int r3 = r0.getCount()
            int r4 = r7.length
            if (r3 != r4) goto L25
            r3 = r1
        L12:
            int r4 = r7.length
            if (r3 >= r4) goto L26
            r4 = r7[r3]
            java.lang.Object r5 = r0.getItem(r3)
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L22
            goto L25
        L22:
            int r3 = r3 + 1
            goto L12
        L25:
            r1 = r2
        L26:
            if (r1 == 0) goto L42
            android.widget.ArrayAdapter r0 = new android.widget.ArrayAdapter
            android.content.Context r1 = r6.getContext()
            r2 = 17367048(0x1090008, float:2.5162948E-38)
            r0.<init>(r1, r2, r7)
            r7 = 17367049(0x1090009, float:2.516295E-38)
            r0.setDropDownViewResource(r7)
            r6.setAdapter(r0)
            goto L42
        L3e:
            r7 = 0
            r6.setAdapter(r7)
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.adapters.AbsSpinnerBindingAdapter.setEntries(android.widget.AbsSpinner, java.lang.CharSequence[]):void");
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
