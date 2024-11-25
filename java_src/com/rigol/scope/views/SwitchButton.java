package com.rigol.scope.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.appcompat.widget.SwitchCompat;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public class SwitchButton extends SwitchCompat {
    private final float thumbHeight;
    private final float thumbWidth;

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.switchStyle);
    }

    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SwitchButton, i, 0);
        this.thumbWidth = obtainStyledAttributes.getDimension(1, 0.0f);
        this.thumbHeight = obtainStyledAttributes.getDimension(0, 0.0f);
        obtainStyledAttributes.recycle();
    }

    @Override // androidx.appcompat.widget.SwitchCompat, android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
    }

    public void setTrackDrawable(int i) {
        TextTrackDrawable textTrackDrawable = new TextTrackDrawable();
        setTrackDrawable(textTrackDrawable);
        textTrackDrawable.setSelectedWidth(i);
        textTrackDrawable.setSwitchChecked(isChecked());
    }

    public void setTrackDrawable(String str, String str2) {
        TextTrackDrawable textTrackDrawable = new TextTrackDrawable(str, str2);
        setTrackDrawable(textTrackDrawable);
        textTrackDrawable.setSwitchChecked(isChecked());
        textTrackDrawable.setShowFullBackground(true);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setSize((int) this.thumbWidth, (int) this.thumbHeight);
        gradientDrawable.setColor(Color.rgb(31, 201, 128));
        gradientDrawable.setCornerRadii(new float[]{5.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 5.0f});
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setSize((int) this.thumbWidth, (int) this.thumbHeight);
        gradientDrawable2.setColor(Color.rgb(31, 201, 128));
        gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 5.0f, 5.0f, 5.0f, 5.0f, 0.0f, 0.0f});
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        setThumbDrawable(stateListDrawable);
    }
}
