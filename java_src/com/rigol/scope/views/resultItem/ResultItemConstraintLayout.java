package com.rigol.scope.views.resultItem;

import android.content.Context;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public class ResultItemConstraintLayout extends ConstraintLayout {
    public ResultItemConstraintLayout(Context context) {
        super(context);
    }

    public ResultItemConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ResultItemConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void initBackground() {
        int width = getViewById(R.id.title_layout).getWidth();
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842913}, new ResultItemDrawable(1, width));
        stateListDrawable.addState(new int[0], new ResultItemDrawable(0, width));
        setBackground(stateListDrawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        initBackground();
    }
}
