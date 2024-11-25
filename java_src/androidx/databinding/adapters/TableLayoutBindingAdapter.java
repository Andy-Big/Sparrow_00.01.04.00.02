package androidx.databinding.adapters;

import android.util.SparseBooleanArray;
import android.widget.TableLayout;
import java.util.regex.Pattern;
/* loaded from: classes.dex */
public class TableLayoutBindingAdapter {
    private static final int MAX_COLUMNS = 20;
    private static Pattern sColumnPattern = Pattern.compile("\\s*,\\s*");

    public static void setCollapseColumns(TableLayout tableLayout, CharSequence charSequence) {
        SparseBooleanArray parseColumns = parseColumns(charSequence);
        for (int i = 0; i < 20; i++) {
            boolean z = parseColumns.get(i, false);
            if (z != tableLayout.isColumnCollapsed(i)) {
                tableLayout.setColumnCollapsed(i, z);
            }
        }
    }

    public static void setShrinkColumns(TableLayout tableLayout, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setShrinkAllColumns(true);
            return;
        }
        tableLayout.setShrinkAllColumns(false);
        SparseBooleanArray parseColumns = parseColumns(charSequence);
        int size = parseColumns.size();
        for (int i = 0; i < size; i++) {
            int keyAt = parseColumns.keyAt(i);
            boolean valueAt = parseColumns.valueAt(i);
            if (valueAt) {
                tableLayout.setColumnShrinkable(keyAt, valueAt);
            }
        }
    }

    public static void setStretchColumns(TableLayout tableLayout, CharSequence charSequence) {
        if (charSequence != null && charSequence.length() > 0 && charSequence.charAt(0) == '*') {
            tableLayout.setStretchAllColumns(true);
            return;
        }
        tableLayout.setStretchAllColumns(false);
        SparseBooleanArray parseColumns = parseColumns(charSequence);
        int size = parseColumns.size();
        for (int i = 0; i < size; i++) {
            int keyAt = parseColumns.keyAt(i);
            boolean valueAt = parseColumns.valueAt(i);
            if (valueAt) {
                tableLayout.setColumnStretchable(keyAt, valueAt);
            }
        }
    }

    private static SparseBooleanArray parseColumns(CharSequence charSequence) {
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        if (charSequence == null) {
            return sparseBooleanArray;
        }
        for (String str : sColumnPattern.split(charSequence)) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt >= 0) {
                    sparseBooleanArray.put(parseInt, true);
                }
            } catch (NumberFormatException unused) {
            }
        }
        return sparseBooleanArray;
    }
}
