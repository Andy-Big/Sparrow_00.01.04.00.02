package com.rigol.scope.data;

import android.view.View;
/* loaded from: classes2.dex */
public class KeyBean {
    private int index;
    private boolean isChecked;
    private View view;

    public KeyBean(int i, boolean z) {
        this.index = i;
        this.isChecked = z;
    }

    public int getIndex() {
        return this.index;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public View getView() {
        return this.view;
    }

    public void setView(View view) {
        this.view = view;
    }

    public boolean isChecked() {
        return this.isChecked;
    }

    public void setChecked(boolean z) {
        this.isChecked = z;
    }
}
