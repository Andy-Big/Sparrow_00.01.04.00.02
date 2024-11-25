package com.rigol.scope.views.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import androidx.appcompat.widget.AppCompatEditText;
import com.rigol.scope.BaseActivity;
import com.rigol.scope.utilities.ViewUtil;
/* loaded from: classes2.dex */
public class BaseEditText extends AppCompatEditText {
    public BaseEditText(Context context) {
        super(context);
    }

    public BaseEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1 && (getContext() instanceof BaseActivity)) {
            ViewUtil.hideSystemUI(((BaseActivity) getContext()).getWindow().getDecorView());
            ((BaseActivity) getContext()).getSharedViewModel().softInputChanged.setValue(true);
        }
        return super.onKeyPreIme(i, keyEvent);
    }
}
