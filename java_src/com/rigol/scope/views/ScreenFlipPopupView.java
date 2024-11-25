package com.rigol.scope.views;

import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.rigol.scope.R;
import com.rigol.scope.databinding.PopupviewScreenFlipBinding;
import com.rigol.scope.utilities.WeakRefHandler;
import com.rigol.scope.views.baseview.BasePopupView;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ScreenFlipPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR$\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u001a"}, d2 = {"Lcom/rigol/scope/views/ScreenFlipPopupView;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "()V", "binding", "Lcom/rigol/scope/databinding/PopupviewScreenFlipBinding;", "flag", "", "handler", "Lcom/rigol/scope/utilities/WeakRefHandler;", "getHandler", "()Lcom/rigol/scope/utilities/WeakRefHandler;", "handler$delegate", "Lkotlin/Lazy;", "value", "obstacleFlag", "getObstacleFlag", "()Z", "setObstacleFlag", "(Z)V", "opening", "getOpening", "setOpening", "delayToDismiss", "", "onDismiss", "onShow", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class ScreenFlipPopupView extends BasePopupView {
    private final PopupviewScreenFlipBinding binding;
    private boolean flag;
    private final Lazy handler$delegate;
    private boolean obstacleFlag;
    private boolean opening;

    /* JADX INFO: Access modifiers changed from: private */
    public final WeakRefHandler getHandler() {
        return (WeakRefHandler) this.handler$delegate.getValue();
    }

    public ScreenFlipPopupView() {
        super((int) R.style.App_PopupWindow_ScreenFlip);
        PopupviewScreenFlipBinding inflate = PopupviewScreenFlipBinding.inflate(LayoutInflater.from(this.context));
        setContentView(inflate.getRoot());
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewScreenFlipBindi… contentView = root\n    }");
        this.binding = inflate;
        this.opening = true;
        this.handler$delegate = LazyKt.lazy(new Function0<WeakRefHandler>() { // from class: com.rigol.scope.views.ScreenFlipPopupView$handler$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final WeakRefHandler invoke() {
                return new WeakRefHandler(new Handler.Callback() { // from class: com.rigol.scope.views.ScreenFlipPopupView$handler$2.1
                    @Override // android.os.Handler.Callback
                    public final boolean handleMessage(Message message) {
                        PopupviewScreenFlipBinding popupviewScreenFlipBinding;
                        boolean z;
                        boolean z2;
                        WeakRefHandler handler;
                        int i = message.what;
                        if (i == 0) {
                            popupviewScreenFlipBinding = ScreenFlipPopupView.this.binding;
                            TextView textView = popupviewScreenFlipBinding.content;
                            Intrinsics.checkNotNullExpressionValue(textView, "binding.content");
                            z = ScreenFlipPopupView.this.flag;
                            textView.setVisibility(z ? 0 : 4);
                            ScreenFlipPopupView screenFlipPopupView = ScreenFlipPopupView.this;
                            z2 = ScreenFlipPopupView.this.flag;
                            screenFlipPopupView.flag = !z2;
                            handler = ScreenFlipPopupView.this.getHandler();
                            handler.sendEmptyMessageDelayed(0, 300L);
                        } else if (i == 1) {
                            ScreenFlipPopupView.this.dismiss();
                        }
                        return true;
                    }
                });
            }
        });
    }

    public final boolean getOpening() {
        return this.opening;
    }

    public final void setOpening(boolean z) {
        this.opening = z;
        if (this.obstacleFlag) {
            return;
        }
        this.binding.content.setText(z ? R.string.inf_screen_opening : R.string.inf_screen_closing);
    }

    public final boolean getObstacleFlag() {
        return this.obstacleFlag;
    }

    public final void setObstacleFlag(boolean z) {
        this.obstacleFlag = z;
        if (z) {
            this.binding.content.setText(R.string.inf_screen_obstacle);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onShow() {
        super.onShow();
        getHandler().sendEmptyMessageDelayed(0, 300L);
        setObstacleFlag(false);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        getHandler().removeMessages(0);
    }

    public final void delayToDismiss() {
        getHandler().removeMessages(1);
        getHandler().sendEmptyMessageDelayed(1, 1000L);
    }
}
