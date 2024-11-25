package com.rigol.scope.utilities;

import android.content.Intent;
import android.os.CountDownTimer;
import com.rigol.scope.MainActivity;
import com.rigol.scope.ScreenSaverActivity;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
/* loaded from: classes2.dex */
public class ScreenSaverUtil extends CountDownTimer {
    public static int DEFAULTLOCKSCREENTIME = 60000;
    private static ScreenSaverUtil screenSaverUtil;
    private MainActivity activity;

    @Override // android.os.CountDownTimer
    public void onTick(long j) {
    }

    private ScreenSaverUtil(MainActivity mainActivity, long j, long j2) {
        super(j, j2);
        this.activity = mainActivity;
    }

    public static synchronized ScreenSaverUtil getInstance(MainActivity mainActivity) {
        ScreenSaverUtil screenSaverUtil2;
        synchronized (ScreenSaverUtil.class) {
            if (screenSaverUtil == null) {
                screenSaverUtil = new ScreenSaverUtil(mainActivity, API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_SCREEN_TIME) * 60, 1000L);
            }
            screenSaverUtil2 = screenSaverUtil;
        }
        return screenSaverUtil2;
    }

    public void setMillsInFuture() {
        cancel();
        screenSaverUtil = null;
    }

    @Override // android.os.CountDownTimer
    public void onFinish() {
        Intent intent = new Intent();
        intent.setClass(this.activity, ScreenSaverActivity.class);
        this.activity.startActivity(intent);
    }

    public void OnStart() {
        if (API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_SCREEN_SAVER) != ServiceEnum.UtilityScreenSaver.SCR_OFF.value1) {
            start();
        }
    }

    public void onStop() {
        cancel();
    }
}
