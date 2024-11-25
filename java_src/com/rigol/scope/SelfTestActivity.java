package com.rigol.scope;

import android.view.KeyEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.rigol.scope.utilities.KeyCodeUtil;
/* loaded from: classes.dex */
public class SelfTestActivity extends AppCompatActivity {
    private int runStopClickCount;

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (KeyCodeUtil.getPanelKey(i) == 12) {
            int i2 = this.runStopClickCount + 1;
            this.runStopClickCount = i2;
            if (i2 == 3) {
                finish();
            }
        } else {
            this.runStopClickCount = 0;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
