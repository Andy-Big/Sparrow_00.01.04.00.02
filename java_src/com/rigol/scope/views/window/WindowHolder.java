package com.rigol.scope.views.window;

import com.rigol.scope.data.WindowParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH&J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u000f"}, d2 = {"Lcom/rigol/scope/views/window/WindowHolder;", "", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Lcom/rigol/scope/data/WindowParam;)V", "getWindowParam", "()Lcom/rigol/scope/data/WindowParam;", "setWindowParam", "getWindow", "Lcom/rigol/scope/views/window/Window;", "onLocaleChanged", "", "updateStatusText", "updateTitle", "updateWarningText", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public abstract class WindowHolder {
    private WindowParam windowParam;

    public abstract Window getWindow();

    public void updateStatusText() {
    }

    public abstract void updateTitle();

    public void updateWarningText() {
    }

    public WindowHolder(WindowParam windowParam) {
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.windowParam = windowParam;
    }

    public final WindowParam getWindowParam() {
        return this.windowParam;
    }

    public final void setWindowParam(WindowParam windowParam) {
        Intrinsics.checkNotNullParameter(windowParam, "<set-?>");
        this.windowParam = windowParam;
    }

    public void onLocaleChanged() {
        updateTitle();
        updateWarningText();
        updateStatusText();
    }
}
