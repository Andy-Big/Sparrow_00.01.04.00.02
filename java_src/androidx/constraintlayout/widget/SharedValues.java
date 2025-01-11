package androidx.constraintlayout.widget;

import android.util.SparseIntArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SharedValues {
    public static final int UNSET = -1;
    private SparseIntArray mValues = new SparseIntArray();
    private HashMap<Integer, HashSet<WeakReference<SharedValuesListener>>> mValuesListeners = new HashMap<>();

    /* loaded from: classes.dex */
    public interface SharedValuesListener {
        void onNewValue(int i, int i2, int i3);
    }

    public void addListener(SharedValuesListener sharedValuesListener, int i) {
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.mValuesListeners.get(Integer.valueOf(i));
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.mValuesListeners.put(Integer.valueOf(i), hashSet);
        }
        hashSet.add(new WeakReference<>(sharedValuesListener));
    }

    public void removeListener(SharedValuesListener sharedValuesListener, int i) {
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.mValuesListeners.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<WeakReference<SharedValuesListener>> it = hashSet.iterator();
        while (it.hasNext()) {
            WeakReference<SharedValuesListener> next = it.next();
            SharedValuesListener sharedValuesListener2 = next.get();
            if (sharedValuesListener2 == null || sharedValuesListener2 == sharedValuesListener) {
                arrayList.add(next);
            }
        }
        hashSet.removeAll(arrayList);
    }

    public void removeListener(SharedValuesListener sharedValuesListener) {
        for (Integer num : this.mValuesListeners.keySet()) {
            removeListener(sharedValuesListener, num.intValue());
        }
    }

    public void clearListeners() {
        this.mValuesListeners.clear();
    }

    public int getValue(int i) {
        return this.mValues.get(i, -1);
    }

    public void fireNewValue(int i, int i2) {
        int i3 = this.mValues.get(i, -1);
        if (i3 == i2) {
            return;
        }
        this.mValues.put(i, i2);
        HashSet<WeakReference<SharedValuesListener>> hashSet = this.mValuesListeners.get(Integer.valueOf(i));
        if (hashSet == null) {
            return;
        }
        Iterator<WeakReference<SharedValuesListener>> it = hashSet.iterator();
        boolean z = false;
        while (it.hasNext()) {
            SharedValuesListener sharedValuesListener = it.next().get();
            if (sharedValuesListener != null) {
                sharedValuesListener.onNewValue(i, i2, i3);
            } else {
                z = true;
            }
        }
        if (z) {
            ArrayList arrayList = new ArrayList();
            Iterator<WeakReference<SharedValuesListener>> it2 = hashSet.iterator();
            while (it2.hasNext()) {
                WeakReference<SharedValuesListener> next = it2.next();
                if (next.get() == null) {
                    arrayList.add(next);
                }
            }
            hashSet.removeAll(arrayList);
        }
    }
}
