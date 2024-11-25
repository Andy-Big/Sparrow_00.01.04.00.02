package com.rigol.scope.utilities;

import android.hardware.input.InputManager;
import android.os.SystemClock;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import androidx.core.view.InputDeviceCompat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class ControlEvent {
    private long downTime;
    private InputManager im = (InputManager) InputManager.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
    private Method injectInputEventMethod = InputManager.class.getMethod("injectInputEvent", InputEvent.class, Integer.TYPE);
    private boolean isDown;

    public void onMessage(float f, float f2) {
        this.downTime = SystemClock.uptimeMillis();
        Timber.d(">>> type:" + f2 + " ,clientX:" + f + " ,clientY:" + f2, new Object[0]);
        long uptimeMillis = SystemClock.uptimeMillis();
        this.downTime = uptimeMillis;
        sendMotionEvent(this.im, this.injectInputEventMethod, 0, uptimeMillis, uptimeMillis, f, f2);
        InputManager inputManager = this.im;
        Method method = this.injectInputEventMethod;
        long j = this.downTime;
        sendMotionEvent(inputManager, method, 1, j, 1000 + j, f, f2);
    }

    public void sendMotionEvent(InputManager inputManager, Method method, int i, long j, long j2, float f, float f2) {
        Timber.d("downTime:" + j + " ,eventTime:" + j2, new Object[0]);
        try {
            injectMotionEvent(inputManager, method, InputDeviceCompat.SOURCE_TOUCHSCREEN, i, j, j2, f, f2, 1.0f);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void injectMotionEvent(InputManager inputManager, Method method, int i, int i2, long j, long j2, float f, float f2, float f3) throws InvocationTargetException, IllegalAccessException {
        MotionEvent obtain = MotionEvent.obtain(j, j2, i2, f, f2, f3, 1.0f, 0, 1.0f, 1.0f, 0, 0);
        obtain.setSource(i);
        method.invoke(inputManager, obtain, 0);
        obtain.recycle();
    }

    public void sendKeyEvent(InputManager inputManager, Method method, int i) {
        try {
            sendKeyEvent(inputManager, method, 257, i, false);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void sendKeyEvent(InputManager inputManager, Method method, int i, int i2, boolean z) throws InvocationTargetException, IllegalAccessException {
        long uptimeMillis = SystemClock.uptimeMillis();
        injectKeyEvent(inputManager, method, new KeyEvent(uptimeMillis, uptimeMillis, 0, i2, 0, z ? 1 : 0, -1, 0, 0, i));
        injectKeyEvent(inputManager, method, new KeyEvent(uptimeMillis, uptimeMillis, 1, i2, 0, z ? 1 : 0, -1, 0, 0, i));
    }

    private void injectKeyEvent(InputManager inputManager, Method method, KeyEvent keyEvent) throws InvocationTargetException, IllegalAccessException {
        method.invoke(inputManager, keyEvent, 0);
    }
}
