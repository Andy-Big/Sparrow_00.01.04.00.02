package com.rigol.scope.cil;

import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.util.ToastUtils;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class API {
    private static API instance;

    public native int UI_AddSurface(Surface surface, int i, int i2, int i3, int i4, int i5);

    public native void UI_DelSurface(int i);

    public native int UI_PostBool(int i, int i2, boolean z);

    public native int UI_PostInt16(int i, int i2, short s);

    public native int UI_PostInt32(int i, int i2, int i3);

    public native int UI_PostInt32Int32(int i, int i2, int i3, int i4);

    public native int UI_PostInt32Int64(int i, int i2, int i3, long j);

    public native int UI_PostInt64(int i, int i2, long j);

    public native int UI_PostStr(int i, int i2, String str);

    public native int UI_QueryAttr(int i, int i2, MessageAttr messageAttr);

    public native boolean UI_QueryBool(int i, int i2);

    public native boolean UI_QueryBoolBy(int i, int i2, int i3);

    public native double UI_QueryDouble(int i, int i2);

    public native double UI_QueryDoubleBy(int i, int i2, int i3);

    public native float UI_QueryFloat(int i, int i2);

    public native float UI_QueryFloatBy(int i, int i2, int i3);

    public native short UI_QueryInt16(int i, int i2);

    public native int UI_QueryInt32(int i, int i2);

    public native int UI_QueryInt32By(int i, int i2, int i3);

    public native long UI_QueryInt64(int i, int i2);

    public native long UI_QueryInt64By(int i, int i2, int i3);

    public native String UI_QueryStr(int i, int i2);

    public native String UI_QueryStrBy(int i, int i2, int i3);

    public native void UI_SetSurface(int i, Surface surface);

    public native int UI_StartBusiness(int i);

    static {
        System.loadLibrary("scope-auklet");
        instance = null;
    }

    private API() {
    }

    public static API getInstance() {
        return getInstance(0);
    }

    public static API getInstance(int i) {
        if (instance == null) {
            synchronized (API.class) {
                Timber.d("launchParam: %s", Integer.valueOf(i));
                instance = new API();
            }
        }
        return instance;
    }

    private void logOut(String str, int i, int i2, Object obj) {
        Log.i(str, ("ServiceID:" + String.valueOf(i)) + (" MessageID:" + String.valueOf(i2)) + (" Value:" + String.valueOf(obj)));
    }

    public void UI_Redraw(int i, int i2, long j) {
        if (i == 0 && i2 == 0 && j == 0) {
            Timber.tag("StandBy").d("UI_StartBusiness method execution completed", new Object[0]);
        }
        if (j == -1) {
            MessageBus.getInstance().onUpdateUI(i, i2, true);
        } else {
            MessageBus.getInstance().onUpdateUI(i, i2, j, true);
        }
    }

    public void UI_SetErrCode(int i, int i2, int i3) {
        String message = ContextUtil.getMessage(i3);
        if (!TextUtils.isEmpty(message)) {
            ToastUtils.showShort(message);
        }
        MessageBus.getInstance().onUpdateUI(i, i2, i3, true);
    }
}
