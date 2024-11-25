package androidx.databinding;
/* loaded from: classes.dex */
public interface Observable {

    /* loaded from: classes.dex */
    public static abstract class OnPropertyChangedCallback {
        public abstract void onPropertyChanged(Observable observable, int i);
    }

    void addOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);

    void removeOnPropertyChangedCallback(OnPropertyChangedCallback onPropertyChangedCallback);
}
