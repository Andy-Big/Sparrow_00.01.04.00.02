package com.google.android.material.datepicker;

/* loaded from: classes.dex */
abstract class OnSelectionChangedListener<S> {
    void onIncompleteSelectionChanged() {
    }

    abstract void onSelectionChanged(S s);

    OnSelectionChangedListener() {
    }
}
