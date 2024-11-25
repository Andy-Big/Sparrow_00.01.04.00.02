package androidx.databinding.adapters;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
/* loaded from: classes.dex */
public class Converters {
    public static ColorDrawable convertColorToDrawable(int i) {
        return new ColorDrawable(i);
    }

    public static ColorStateList convertColorToColorStateList(int i) {
        return ColorStateList.valueOf(i);
    }
}
