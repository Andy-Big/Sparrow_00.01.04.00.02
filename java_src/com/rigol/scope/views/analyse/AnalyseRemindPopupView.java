package com.rigol.scope.views.analyse;

import android.view.LayoutInflater;
import android.view.View;
import com.rigol.scope.R;
import com.rigol.scope.databinding.PopupviewRemindBinding;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.busAnalyse.BusAnalysePopupView;
/* loaded from: classes2.dex */
public class AnalyseRemindPopupView extends BasePopupView implements View.OnClickListener {
    private PopupviewRemindBinding binding;

    public AnalyseRemindPopupView() {
        super((int) R.style.App_PopupWindow_Common);
        PopupviewRemindBinding inflate = PopupviewRemindBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.title.setText(R.string.msg_analyse_remind_title);
        this.binding.content.setText(R.string.msg_analyse_remind_text);
        this.binding.cancel.setOnClickListener(this);
        this.binding.ok.setOnClickListener(this);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        updateContent();
    }

    private void updateContent() {
        if (this.binding.title != null) {
            this.binding.title.setText(R.string.msg_analyse_remind_title);
        }
        if (this.binding.content != null) {
            this.binding.content.setText(R.string.msg_analyse_remind_text);
        }
        notifyDataSetChanged();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.cancel) {
            dismiss();
        } else if (id != R.id.ok) {
        } else {
            PopupViewManager.getInstance().show(BusAnalysePopupView.class);
        }
    }
}
