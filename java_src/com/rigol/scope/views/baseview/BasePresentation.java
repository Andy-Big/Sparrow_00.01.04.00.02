package com.rigol.scope.views.baseview;

import android.app.Presentation;
import android.content.Context;
import android.view.Display;
import android.view.MotionEvent;
import com.rigol.scope.R;
import com.rigol.scope.data.UtilityParamKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.util.ToastUtils;
/* loaded from: classes2.dex */
public class BasePresentation extends Presentation {
    public void onLocaleChanged() {
    }

    public BasePresentation(Context context, Display display) {
        super(context, display);
    }

    public BasePresentation(Context context, Display display, int i) {
        super(context, display, i);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (ViewUtil.isCalibrationStarted() || ViewUtil.isRecording() || ViewUtil.isPassFailRunning() || PopupViewManager.getInstance().isLoadingClassShowing()) {
            ToastUtils.showShort((int) R.string.err_action_disabled);
            return true;
        }
        if (motionEvent.getActionMasked() == 1) {
            UtilityParamKt.saveTone();
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
