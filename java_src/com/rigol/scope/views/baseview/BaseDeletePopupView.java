package com.rigol.scope.views.baseview;

import android.view.View;
import com.rigol.scope.R;
/* loaded from: classes2.dex */
public class BaseDeletePopupView extends BasePopupView implements View.OnClickListener {
    protected View.OnClickListener onDeleteAllClickListener;
    protected View.OnClickListener onDeleteClickListener;

    public BaseDeletePopupView(int i) {
        super(i);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void setContentView(View view) {
        super.setContentView(view);
        View findViewById = view.findViewById(R.id.delete_button);
        if (findViewById != null) {
            findViewById.setOnClickListener(this);
        }
        View findViewById2 = view.findViewById(R.id.delete_all_button);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(this);
        }
    }

    public void setDeleteListener(View.OnClickListener onClickListener) {
        this.onDeleteClickListener = onClickListener;
    }

    public void setDeleteAllListener(View.OnClickListener onClickListener) {
        this.onDeleteAllClickListener = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View.OnClickListener onClickListener;
        int id = view.getId();
        if (id == R.id.delete_button) {
            View.OnClickListener onClickListener2 = this.onDeleteClickListener;
            if (onClickListener2 != null) {
                onClickListener2.onClick(view);
            }
        } else if (id != R.id.delete_all_button || (onClickListener = this.onDeleteAllClickListener) == null) {
        } else {
            onClickListener.onClick(view);
        }
    }
}
