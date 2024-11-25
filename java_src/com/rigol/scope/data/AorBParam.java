package com.rigol.scope.data;

import android.widget.EditText;
import android.widget.TextView;
/* loaded from: classes2.dex */
public class AorBParam {
    String aorb;
    int click_mun;
    EditText editText;
    int edittext_id;
    boolean is_show;
    int sup_id;
    TextView textView;

    public int getSup_id() {
        return this.sup_id;
    }

    public void setSup_id(int i) {
        this.sup_id = i;
    }

    public TextView getTextView() {
        return this.textView;
    }

    public void setTextView(TextView textView) {
        this.textView = textView;
    }

    public EditText getEditText() {
        return this.editText;
    }

    public void setEditText(EditText editText) {
        this.editText = editText;
    }

    public AorBParam(int i, int i2, boolean z, String str, int i3) {
        this.aorb = str;
        this.click_mun = i2;
        this.edittext_id = i;
        this.is_show = z;
        this.sup_id = i3;
    }

    public AorBParam(TextView textView, int i, boolean z, String str, int i2) {
        this.sup_id = i2;
        this.aorb = str;
        this.click_mun = i;
        this.textView = textView;
        this.is_show = z;
    }

    public AorBParam(EditText editText, int i, boolean z, String str, int i2) {
        this.sup_id = i2;
        this.aorb = str;
        this.click_mun = i;
        this.editText = editText;
        this.is_show = z;
    }

    public int getEdittext_id() {
        return this.edittext_id;
    }

    public void setEdittext_id(int i) {
        this.edittext_id = i;
    }

    public int getClick_mun() {
        return this.click_mun;
    }

    public void setClick_mun(int i) {
        this.click_mun = i;
    }

    public boolean isIs_show() {
        return this.is_show;
    }

    public void setIs_show(boolean z) {
        this.is_show = z;
    }

    public String getAorb() {
        return this.aorb;
    }

    public void setAorb(String str) {
        this.aorb = str;
    }
}
