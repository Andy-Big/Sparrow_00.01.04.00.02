package com.rigol.scope.views.alert;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.rigol.scope.R;
import com.rigol.scope.databinding.PopupviewAlertBinding;
import com.rigol.scope.views.baseview.BasePopupView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AlertPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0000J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00002\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u0019\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u001e"}, d2 = {"Lcom/rigol/scope/views/alert/AlertPopupView;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "defStyleRes", "", "(I)V", "()V", "binding", "Lcom/rigol/scope/databinding/PopupviewAlertBinding;", "getBinding", "()Lcom/rigol/scope/databinding/PopupviewAlertBinding;", "cancelListener", "Landroid/view/View$OnClickListener;", "getCancelListener", "()Landroid/view/View$OnClickListener;", "setCancelListener", "(Landroid/view/View$OnClickListener;)V", "confirmListener", "getConfirmListener", "setConfirmListener", "hideButton", "onLocaleChanged", "", "setContent", "content", "", "setDrawable", "drawable", "Landroid/graphics/drawable/Drawable;", "setTitle", "title", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class AlertPopupView extends BasePopupView {
    private final PopupviewAlertBinding binding;
    private View.OnClickListener cancelListener;
    private View.OnClickListener confirmListener;

    public AlertPopupView(int i) {
        super(i);
        PopupviewAlertBinding inflate = PopupviewAlertBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewAlertBinding.in…utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.ok.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.alert.AlertPopupView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertPopupView.this.dismiss();
                if (AlertPopupView.this.getConfirmListener() != null) {
                    View.OnClickListener confirmListener = AlertPopupView.this.getConfirmListener();
                    Intrinsics.checkNotNull(confirmListener);
                    confirmListener.onClick(view);
                }
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.alert.AlertPopupView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertPopupView.this.dismiss();
                if (AlertPopupView.this.getCancelListener() != null) {
                    View.OnClickListener cancelListener = AlertPopupView.this.getCancelListener();
                    Intrinsics.checkNotNull(cancelListener);
                    cancelListener.onClick(view);
                }
            }
        });
    }

    public AlertPopupView() {
        super((int) R.style.App_PopupWindow_Common_Alert);
        PopupviewAlertBinding inflate = PopupviewAlertBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewAlertBinding.in…utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.ok.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.alert.AlertPopupView.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertPopupView.this.dismiss();
                if (AlertPopupView.this.getConfirmListener() != null) {
                    View.OnClickListener confirmListener = AlertPopupView.this.getConfirmListener();
                    Intrinsics.checkNotNull(confirmListener);
                    confirmListener.onClick(view);
                }
            }
        });
        this.binding.cancel.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.alert.AlertPopupView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AlertPopupView.this.dismiss();
                if (AlertPopupView.this.getCancelListener() != null) {
                    View.OnClickListener cancelListener = AlertPopupView.this.getCancelListener();
                    Intrinsics.checkNotNull(cancelListener);
                    cancelListener.onClick(view);
                }
            }
        });
    }

    public final PopupviewAlertBinding getBinding() {
        return this.binding;
    }

    public final View.OnClickListener getConfirmListener() {
        return this.confirmListener;
    }

    public final void setConfirmListener(View.OnClickListener onClickListener) {
        this.confirmListener = onClickListener;
    }

    public final View.OnClickListener getCancelListener() {
        return this.cancelListener;
    }

    public final void setCancelListener(View.OnClickListener onClickListener) {
        this.cancelListener = onClickListener;
    }

    public final AlertPopupView setDrawable(Drawable drawable) {
        this.binding.icon.setImageDrawable(drawable);
        return this;
    }

    public final AlertPopupView setTitle(String str) {
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        textView.setText(str);
        return this;
    }

    public final AlertPopupView setContent(String str) {
        TextView textView = this.binding.content;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.content");
        textView.setText(str);
        return this;
    }

    public final AlertPopupView hideButton() {
        View view = this.binding.buttonBackground;
        Intrinsics.checkNotNullExpressionValue(view, "binding.buttonBackground");
        view.setVisibility(8);
        Button button = this.binding.ok;
        Intrinsics.checkNotNullExpressionValue(button, "binding.ok");
        button.setVisibility(8);
        Button button2 = this.binding.cancel;
        Intrinsics.checkNotNullExpressionValue(button2, "binding.cancel");
        button2.setVisibility(8);
        View view2 = this.binding.dividingLine;
        Intrinsics.checkNotNullExpressionValue(view2, "binding.dividingLine");
        view2.setVisibility(8);
        return this;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        this.binding.cancel.setText(R.string.inf_upgrade_cancel);
        this.binding.ok.setText(R.string.msg_gui_serv_ask_ok);
    }
}
