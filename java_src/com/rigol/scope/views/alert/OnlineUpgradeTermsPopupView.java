package com.rigol.scope.views.alert;

import android.text.Html;
import android.text.Spanned;
import android.widget.Button;
import android.widget.TextView;
import com.rigol.scope.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AlertPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/rigol/scope/views/alert/OnlineUpgradeTermsPopupView;", "Lcom/rigol/scope/views/alert/AlertPopupView;", "()V", "onLocaleChanged", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class OnlineUpgradeTermsPopupView extends AlertPopupView {
    public OnlineUpgradeTermsPopupView() {
        super(R.style.App_PopupWindow_OnlineUpgradeTerms);
        setTitle(this.context.getString(R.string.inf_upgrade_title));
        TextView textView = getBinding().content;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.content");
        textView.setGravity(0);
        TextView textView2 = getBinding().content;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.content");
        textView2.setTextSize(16.0f);
        Spanned fromHtml = Html.fromHtml(this.context.getString(R.string.inf_upgrade_context), 0);
        TextView textView3 = getBinding().content;
        Intrinsics.checkNotNullExpressionValue(textView3, "binding.content");
        textView3.setText(fromHtml);
        Button button = getBinding().ok;
        Intrinsics.checkNotNullExpressionValue(button, "binding.ok");
        button.setText(this.context.getString(R.string.inf_upgrade_agree));
    }

    @Override // com.rigol.scope.views.alert.AlertPopupView, com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        getBinding().title.setText(R.string.inf_upgrade_title);
        Spanned fromHtml = Html.fromHtml(this.context.getString(R.string.inf_upgrade_context), 0);
        TextView textView = getBinding().content;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.content");
        textView.setText(fromHtml);
        getBinding().ok.setText(R.string.inf_upgrade_agree);
    }
}
