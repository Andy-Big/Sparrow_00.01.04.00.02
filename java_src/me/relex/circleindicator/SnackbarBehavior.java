package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;
/* loaded from: classes2.dex */
public class SnackbarBehavior extends CoordinatorLayout.Behavior<BaseCircleIndicator> {
    public SnackbarBehavior() {
    }

    public SnackbarBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, BaseCircleIndicator baseCircleIndicator, View view) {
        return view instanceof Snackbar.SnackbarLayout;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, BaseCircleIndicator baseCircleIndicator, View view) {
        baseCircleIndicator.setTranslationY(getTranslationYForSnackbar(coordinatorLayout, baseCircleIndicator));
        return true;
    }

    private float getTranslationYForSnackbar(CoordinatorLayout coordinatorLayout, BaseCircleIndicator baseCircleIndicator) {
        List<View> dependencies = coordinatorLayout.getDependencies(baseCircleIndicator);
        int size = dependencies.size();
        float f = 0.0f;
        for (int i = 0; i < size; i++) {
            View view = dependencies.get(i);
            if ((view instanceof Snackbar.SnackbarLayout) && coordinatorLayout.doViewsOverlap(baseCircleIndicator, view)) {
                f = Math.min(f, view.getTranslationY() - view.getHeight());
            }
        }
        return f;
    }
}
