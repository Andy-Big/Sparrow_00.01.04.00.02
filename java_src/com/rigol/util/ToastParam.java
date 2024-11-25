package com.rigol.util;

import android.view.View;
import kotlin.Metadata;
/* compiled from: ToastUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/rigol/util/ToastParam;", "", "view", "Landroid/view/View;", "text", "", "duration", "", "(Landroid/view/View;Ljava/lang/CharSequence;I)V", "getDuration", "()I", "getText", "()Ljava/lang/CharSequence;", "getView", "()Landroid/view/View;", "lib_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class ToastParam {
    private final int duration;
    private final CharSequence text;
    private final View view;

    public ToastParam(View view, CharSequence charSequence, int i) {
        this.view = view;
        this.text = charSequence;
        this.duration = i;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final View getView() {
        return this.view;
    }
}
