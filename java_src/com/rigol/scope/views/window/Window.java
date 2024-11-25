package com.rigol.scope.views.window;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.rigol.scope.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Window.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001aB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\u0006\u0010\u0017\u001a\u00020\u0011J\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u0019\u001a\u00020\u0011R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lcom/rigol/scope/views/window/Window;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "onSizeChangedCallback", "Lcom/rigol/scope/views/window/Window$OnSizeChangedCallback;", "getOnSizeChangedCallback", "()Lcom/rigol/scope/views/window/Window$OnSizeChangedCallback;", "setOnSizeChangedCallback", "(Lcom/rigol/scope/views/window/Window$OnSizeChangedCallback;)V", "getContentLayout", "Landroid/view/View;", "getTitleLayout", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "showContentView", "showEmptyView", "showLoadingView", "OnSizeChangedCallback", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class Window extends ConstraintLayout {
    private OnSizeChangedCallback onSizeChangedCallback;

    /* compiled from: Window.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&¨\u0006\t"}, d2 = {"Lcom/rigol/scope/views/window/Window$OnSizeChangedCallback;", "", "onSizeChanged", "", "w", "", "h", "oldw", "oldh", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public interface OnSizeChangedCallback {
        void onSizeChanged(int i, int i2, int i3, int i4);
    }

    public final void showContentView() {
    }

    public final void showEmptyView() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Window(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final OnSizeChangedCallback getOnSizeChangedCallback() {
        return this.onSizeChangedCallback;
    }

    public final void setOnSizeChangedCallback(OnSizeChangedCallback onSizeChangedCallback) {
        this.onSizeChangedCallback = onSizeChangedCallback;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        OnSizeChangedCallback onSizeChangedCallback = this.onSizeChangedCallback;
        if (onSizeChangedCallback != null) {
            onSizeChangedCallback.onSizeChanged(i, i2, i3, i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    public final View getTitleLayout() {
        return findViewById(R.id.title_layout);
    }

    public final View getContentLayout() {
        return findViewById(R.id.content_layout);
    }

    public final void showLoadingView() {
        View contentLayout = getContentLayout();
        if (contentLayout != null) {
            contentLayout.setVisibility(8);
        }
        View findViewById = findViewById(R.id.empty);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        View findViewById2 = findViewById(R.id.loading);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
    }
}
