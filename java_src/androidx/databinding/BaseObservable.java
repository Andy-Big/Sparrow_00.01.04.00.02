package androidx.databinding;

import androidx.databinding.Observable;
/* loaded from: classes.dex */
public class BaseObservable implements Observable {
    private transient PropertyChangeRegistry mCallbacks;

    @Override // androidx.databinding.Observable
    public void addOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                this.mCallbacks = new PropertyChangeRegistry();
            }
        }
        this.mCallbacks.add(onPropertyChangedCallback);
    }

    @Override // androidx.databinding.Observable
    public void removeOnPropertyChangedCallback(Observable.OnPropertyChangedCallback onPropertyChangedCallback) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            this.mCallbacks.remove(onPropertyChangedCallback);
        }
    }

    public void notifyChange() {
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            this.mCallbacks.notifyCallbacks(this, 0, null);
        }
    }

    public void notifyPropertyChanged(int i) {
        synchronized (this) {
            if (this.mCallbacks == null) {
                return;
            }
            this.mCallbacks.notifyCallbacks(this, i, null);
        }
    }
}
