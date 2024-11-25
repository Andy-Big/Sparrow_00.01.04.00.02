package com.rigol.scope.utilities;

import com.rigol.scope.data.MessageBus;
/* loaded from: classes2.dex */
public class MotorManager {
    private static MotorManager instance;

    private MotorManager() {
    }

    public static MotorManager getInstance() {
        if (instance == null) {
            synchronized (MotorManager.class) {
                if (instance == null) {
                    instance = new MotorManager();
                }
            }
        }
        return instance;
    }

    public void reverse() {
        MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_MOTOR_REVERSE, true);
    }

    public void forward() {
        MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_MOTOR_FORWARD, true);
    }

    public void recovery() {
        MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_MOTOR_RECOVERY, true);
    }

    public void setPosition(int i) {
        MessageBus.getInstance().onSyncData(MessageBus.SYNC_DATA_KEY_MOTOR_SET_POSITION, Integer.valueOf(i));
    }
}
