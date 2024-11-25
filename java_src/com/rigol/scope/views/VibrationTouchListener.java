package com.rigol.scope.views;

import android.view.MotionEvent;
import android.view.View;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.UtilityViewModel;
/* loaded from: classes2.dex */
public class VibrationTouchListener implements View.OnTouchListener {
    private final UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            ViewUtil.makeVibration(this.utilityViewModel);
            return false;
        }
        return false;
    }
}
