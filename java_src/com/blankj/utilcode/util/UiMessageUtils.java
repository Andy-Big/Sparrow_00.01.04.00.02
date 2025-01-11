package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class UiMessageUtils implements Handler.Callback {
    private static final boolean DEBUG = UtilsBridge.isAppDebug();
    private static final String TAG = "UiMessageUtils";
    private final List<UiMessageCallback> mDefensiveCopyList;
    private final Handler mHandler;
    private final SparseArray<List<UiMessageCallback>> mListenersSpecific;
    private final List<UiMessageCallback> mListenersUniversal;
    private final UiMessage mMessage;

    /* loaded from: classes.dex */
    public interface UiMessageCallback {
        void handleMessage(UiMessage uiMessage);
    }

    public static UiMessageUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private UiMessageUtils() {
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mMessage = new UiMessage(null);
        this.mListenersSpecific = new SparseArray<>();
        this.mListenersUniversal = new ArrayList();
        this.mDefensiveCopyList = new ArrayList();
    }

    public final void send(int i) {
        this.mHandler.sendEmptyMessage(i);
    }

    public final void send(int i, Object obj) {
        if (obj == null) {
            throw new NullPointerException("Argument 'obj' of type Object (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        Handler handler = this.mHandler;
        handler.sendMessage(handler.obtainMessage(i, obj));
    }

    public void addListener(int i, UiMessageCallback uiMessageCallback) {
        if (uiMessageCallback == null) {
            throw new NullPointerException("Argument 'listener' of type UiMessageCallback (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        synchronized (this.mListenersSpecific) {
            List<UiMessageCallback> list = this.mListenersSpecific.get(i);
            if (list == null) {
                list = new ArrayList<>();
                this.mListenersSpecific.put(i, list);
            }
            if (!list.contains(uiMessageCallback)) {
                list.add(uiMessageCallback);
            }
        }
    }

    public void addListener(UiMessageCallback uiMessageCallback) {
        if (uiMessageCallback == null) {
            throw new NullPointerException("Argument 'listener' of type UiMessageCallback (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        synchronized (this.mListenersUniversal) {
            if (!this.mListenersUniversal.contains(uiMessageCallback)) {
                this.mListenersUniversal.add(uiMessageCallback);
            } else if (DEBUG) {
                Log.w(TAG, "Listener is already added. " + uiMessageCallback.toString());
            }
        }
    }

    public void removeListener(UiMessageCallback uiMessageCallback) {
        if (uiMessageCallback == null) {
            throw new NullPointerException("Argument 'listener' of type UiMessageCallback (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        synchronized (this.mListenersUniversal) {
            if (DEBUG && !this.mListenersUniversal.contains(uiMessageCallback)) {
                Log.w(TAG, "Trying to remove a listener that is not registered. " + uiMessageCallback.toString());
            }
            this.mListenersUniversal.remove(uiMessageCallback);
        }
    }

    public void removeListeners(int i) {
        List<UiMessageCallback> list;
        if (DEBUG && ((list = this.mListenersSpecific.get(i)) == null || list.size() == 0)) {
            Log.w(TAG, "Trying to remove specific listeners that are not registered. ID " + i);
        }
        synchronized (this.mListenersSpecific) {
            this.mListenersSpecific.delete(i);
        }
    }

    public void removeListener(int i, UiMessageCallback uiMessageCallback) {
        if (uiMessageCallback == null) {
            throw new NullPointerException("Argument 'listener' of type UiMessageCallback (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        synchronized (this.mListenersSpecific) {
            List<UiMessageCallback> list = this.mListenersSpecific.get(i);
            if (list != null && !list.isEmpty()) {
                if (DEBUG && !list.contains(uiMessageCallback)) {
                    Log.w(TAG, "Trying to remove specific listener that is not registered. ID " + i + ", " + uiMessageCallback);
                    return;
                }
                list.remove(uiMessageCallback);
            } else if (DEBUG) {
                Log.w(TAG, "Trying to remove specific listener that is not registered. ID " + i + ", " + uiMessageCallback);
            }
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        this.mMessage.setMessage(message);
        if (DEBUG) {
            logMessageHandling(this.mMessage);
        }
        synchronized (this.mListenersSpecific) {
            List<UiMessageCallback> list = this.mListenersSpecific.get(message.what);
            if (list != null) {
                if (list.size() == 0) {
                    this.mListenersSpecific.remove(message.what);
                } else {
                    this.mDefensiveCopyList.addAll(list);
                    for (UiMessageCallback uiMessageCallback : this.mDefensiveCopyList) {
                        uiMessageCallback.handleMessage(this.mMessage);
                    }
                    this.mDefensiveCopyList.clear();
                }
            }
        }
        synchronized (this.mListenersUniversal) {
            if (this.mListenersUniversal.size() > 0) {
                this.mDefensiveCopyList.addAll(this.mListenersUniversal);
                for (UiMessageCallback uiMessageCallback2 : this.mDefensiveCopyList) {
                    uiMessageCallback2.handleMessage(this.mMessage);
                }
                this.mDefensiveCopyList.clear();
            }
        }
        this.mMessage.setMessage(null);
        return true;
    }

    private void logMessageHandling(UiMessage uiMessage) {
        if (uiMessage == null) {
            throw new NullPointerException("Argument 'msg' of type UiMessage (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<UiMessageCallback> list = this.mListenersSpecific.get(uiMessage.getId());
        if ((list == null || list.size() == 0) && this.mListenersUniversal.size() == 0) {
            Log.w(TAG, "Delivering FAILED for message ID " + uiMessage.getId() + ". No listeners. " + uiMessage.toString());
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Delivering message ID ");
        sb.append(uiMessage.getId());
        sb.append(", Specific listeners: ");
        if (list == null || list.size() == 0) {
            sb.append(0);
        } else {
            sb.append(list.size());
            sb.append(" [");
            for (int i = 0; i < list.size(); i++) {
                sb.append(list.get(i).getClass().getSimpleName());
                if (i < list.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
        }
        sb.append(", Universal listeners: ");
        synchronized (this.mListenersUniversal) {
            if (this.mListenersUniversal.size() == 0) {
                sb.append(0);
            } else {
                sb.append(this.mListenersUniversal.size());
                sb.append(" [");
                for (int i2 = 0; i2 < this.mListenersUniversal.size(); i2++) {
                    sb.append(this.mListenersUniversal.get(i2).getClass().getSimpleName());
                    if (i2 < this.mListenersUniversal.size() - 1) {
                        sb.append(",");
                    }
                }
                sb.append("], Message: ");
            }
        }
        sb.append(uiMessage.toString());
        Log.v(TAG, sb.toString());
    }

    /* loaded from: classes.dex */
    public static final class UiMessage {
        private Message mMessage;

        private UiMessage(Message message) {
            this.mMessage = message;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(Message message) {
            this.mMessage = message;
        }

        public int getId() {
            return this.mMessage.what;
        }

        public Object getObject() {
            return this.mMessage.obj;
        }

        public String toString() {
            return "{ id=" + getId() + ", obj=" + getObject() + " }";
        }
    }

    /* loaded from: classes.dex */
    private static final class LazyHolder {
        private static final UiMessageUtils INSTANCE = new UiMessageUtils();

        private LazyHolder() {
        }
    }
}
