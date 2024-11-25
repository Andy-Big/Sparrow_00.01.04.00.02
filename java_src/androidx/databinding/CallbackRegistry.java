package androidx.databinding;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class CallbackRegistry<C, T, A> implements Cloneable {
    private static final String TAG = "CallbackRegistry";
    private List<C> mCallbacks = new ArrayList();
    private long mFirst64Removed = 0;
    private int mNotificationLevel;
    private final NotifierCallback<C, T, A> mNotifier;
    private long[] mRemainderRemoved;

    /* loaded from: classes.dex */
    public static abstract class NotifierCallback<C, T, A> {
        public abstract void onNotifyCallback(C c, T t, int i, A a);
    }

    public CallbackRegistry(NotifierCallback<C, T, A> notifierCallback) {
        this.mNotifier = notifierCallback;
    }

    public synchronized void notifyCallbacks(T t, int i, A a) {
        this.mNotificationLevel++;
        notifyRecurse(t, i, a);
        int i2 = this.mNotificationLevel - 1;
        this.mNotificationLevel = i2;
        if (i2 == 0) {
            if (this.mRemainderRemoved != null) {
                for (int length = this.mRemainderRemoved.length - 1; length >= 0; length--) {
                    long j = this.mRemainderRemoved[length];
                    if (j != 0) {
                        removeRemovedCallbacks((length + 1) * 64, j);
                        this.mRemainderRemoved[length] = 0;
                    }
                }
            }
            if (this.mFirst64Removed != 0) {
                removeRemovedCallbacks(0, this.mFirst64Removed);
                this.mFirst64Removed = 0L;
            }
        }
    }

    private void notifyFirst64(T t, int i, A a) {
        notifyCallbacks(t, i, a, 0, Math.min(64, this.mCallbacks.size()), this.mFirst64Removed);
    }

    private void notifyRecurse(T t, int i, A a) {
        int size = this.mCallbacks.size();
        long[] jArr = this.mRemainderRemoved;
        int length = jArr == null ? -1 : jArr.length - 1;
        notifyRemainder(t, i, a, length);
        notifyCallbacks(t, i, a, (length + 2) * 64, size, 0L);
    }

    private void notifyRemainder(T t, int i, A a, int i2) {
        if (i2 < 0) {
            notifyFirst64(t, i, a);
            return;
        }
        long j = this.mRemainderRemoved[i2];
        int i3 = (i2 + 1) * 64;
        int min = Math.min(this.mCallbacks.size(), i3 + 64);
        notifyRemainder(t, i, a, i2 - 1);
        notifyCallbacks(t, i, a, i3, min, j);
    }

    private void notifyCallbacks(T t, int i, A a, int i2, int i3, long j) {
        long j2 = 1;
        while (i2 < i3) {
            if ((j & j2) == 0) {
                this.mNotifier.onNotifyCallback(this.mCallbacks.get(i2), t, i, a);
            }
            j2 <<= 1;
            i2++;
        }
    }

    public synchronized void add(C c) {
        if (c == null) {
            throw new IllegalArgumentException("callback cannot be null");
        }
        int lastIndexOf = this.mCallbacks.lastIndexOf(c);
        if (lastIndexOf < 0 || isRemoved(lastIndexOf)) {
            this.mCallbacks.add(c);
        }
    }

    private boolean isRemoved(int i) {
        int i2;
        if (i < 64) {
            return ((1 << i) & this.mFirst64Removed) != 0;
        }
        long[] jArr = this.mRemainderRemoved;
        if (jArr != null && (i2 = (i / 64) - 1) < jArr.length) {
            return ((1 << (i % 64)) & jArr[i2]) != 0;
        }
        return false;
    }

    private void removeRemovedCallbacks(int i, long j) {
        long j2 = Long.MIN_VALUE;
        for (int i2 = (i + 64) - 1; i2 >= i; i2--) {
            if ((j & j2) != 0) {
                this.mCallbacks.remove(i2);
            }
            j2 >>>= 1;
        }
    }

    public synchronized void remove(C c) {
        if (this.mNotificationLevel == 0) {
            this.mCallbacks.remove(c);
        } else {
            int lastIndexOf = this.mCallbacks.lastIndexOf(c);
            if (lastIndexOf >= 0) {
                setRemovalBit(lastIndexOf);
            }
        }
    }

    private void setRemovalBit(int i) {
        if (i < 64) {
            this.mFirst64Removed = (1 << i) | this.mFirst64Removed;
            return;
        }
        int i2 = (i / 64) - 1;
        long[] jArr = this.mRemainderRemoved;
        if (jArr == null) {
            this.mRemainderRemoved = new long[this.mCallbacks.size() / 64];
        } else if (jArr.length <= i2) {
            long[] jArr2 = new long[this.mCallbacks.size() / 64];
            long[] jArr3 = this.mRemainderRemoved;
            System.arraycopy(jArr3, 0, jArr2, 0, jArr3.length);
            this.mRemainderRemoved = jArr2;
        }
        long j = 1 << (i % 64);
        long[] jArr4 = this.mRemainderRemoved;
        jArr4[i2] = j | jArr4[i2];
    }

    public synchronized ArrayList<C> copyCallbacks() {
        ArrayList<C> arrayList;
        arrayList = new ArrayList<>(this.mCallbacks.size());
        int size = this.mCallbacks.size();
        for (int i = 0; i < size; i++) {
            if (!isRemoved(i)) {
                arrayList.add(this.mCallbacks.get(i));
            }
        }
        return arrayList;
    }

    public synchronized void copyCallbacks(List<C> list) {
        list.clear();
        int size = this.mCallbacks.size();
        for (int i = 0; i < size; i++) {
            if (!isRemoved(i)) {
                list.add(this.mCallbacks.get(i));
            }
        }
    }

    public synchronized boolean isEmpty() {
        if (this.mCallbacks.isEmpty()) {
            return true;
        }
        if (this.mNotificationLevel == 0) {
            return false;
        }
        int size = this.mCallbacks.size();
        for (int i = 0; i < size; i++) {
            if (!isRemoved(i)) {
                return false;
            }
        }
        return true;
    }

    public synchronized void clear() {
        if (this.mNotificationLevel == 0) {
            this.mCallbacks.clear();
        } else if (!this.mCallbacks.isEmpty()) {
            for (int size = this.mCallbacks.size() - 1; size >= 0; size--) {
                setRemovalBit(size);
            }
        }
    }

    /* renamed from: clone */
    public synchronized CallbackRegistry<C, T, A> m6clone() {
        CallbackRegistry<C, T, A> callbackRegistry;
        CloneNotSupportedException e;
        try {
            callbackRegistry = (CallbackRegistry) super.clone();
            try {
                callbackRegistry.mFirst64Removed = 0L;
                callbackRegistry.mRemainderRemoved = null;
                callbackRegistry.mNotificationLevel = 0;
                callbackRegistry.mCallbacks = new ArrayList();
                int size = this.mCallbacks.size();
                for (int i = 0; i < size; i++) {
                    if (!isRemoved(i)) {
                        callbackRegistry.mCallbacks.add(this.mCallbacks.get(i));
                    }
                }
            } catch (CloneNotSupportedException e2) {
                e = e2;
                e.printStackTrace();
                return callbackRegistry;
            }
        } catch (CloneNotSupportedException e3) {
            callbackRegistry = null;
            e = e3;
        }
        return callbackRegistry;
    }
}
