package com.rigol.scope.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.ActivityRigolKeyTest;
import com.rigol.scope.ActivityRigolLcdTest;
import com.rigol.scope.ActivityRigolTouchTest;
import com.rigol.scope.R;
import com.rigol.scope.databinding.AdapterUtilitySelfcheckBinding;
import com.rigol.scope.views.boardTest.BoardTestPopupView;

/* loaded from: classes.dex */
public class UtilitySelfCheckAdapter extends RecyclerView.Adapter<SelfCheckHolder> implements View.OnClickListener {
    private AdapterUtilitySelfcheckBinding binding;
    private Context context;
    private SelfCheckClosePop selfCheckClosePop;

    /* loaded from: classes.dex */
    public interface SelfCheckClosePop {
        void setClosePop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilitySelfCheckAdapter(Context context) {
        this.context = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SelfCheckHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterUtilitySelfcheckBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new SelfCheckHolder(this.binding);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(SelfCheckHolder selfCheckHolder, int i) {
        initClick(selfCheckHolder);
    }

    private void initClick(SelfCheckHolder selfCheckHolder) {
        selfCheckHolder.binding.keycheckLayout.setOnClickListener(this);
        selfCheckHolder.binding.touchLayout.setOnClickListener(this);
        selfCheckHolder.binding.screenLayout.setOnClickListener(this);
        selfCheckHolder.binding.selfTest.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.keycheck_layout /* 2131363239 */:
                ActivityUtils.getTopActivity().startActivity(new Intent(this.context, ActivityRigolKeyTest.class));
                return;
            case R.id.screen_layout /* 2131363802 */:
                ActivityUtils.getTopActivity().startActivity(new Intent(this.context, ActivityRigolLcdTest.class));
                return;
            case R.id.self_test /* 2131363826 */:
                this.selfCheckClosePop.setClosePop();
                new BoardTestPopupView().showAtLocation(ActivityUtils.getTopActivity().getWindow().getDecorView(), 17, 0, 0);
                return;
            case R.id.touch_layout /* 2131364117 */:
                ActivityUtils.getTopActivity().startActivity(new Intent(this.context, ActivityRigolTouchTest.class));
                return;
            default:
                return;
        }
    }

    public void setCloseUtilityPopListener(SelfCheckClosePop selfCheckClosePop) {
        this.selfCheckClosePop = selfCheckClosePop;
    }

    /* loaded from: classes.dex */
    public static class SelfCheckHolder extends RecyclerView.ViewHolder {
        private AdapterUtilitySelfcheckBinding binding;

        public SelfCheckHolder(AdapterUtilitySelfcheckBinding adapterUtilitySelfcheckBinding) {
            super(adapterUtilitySelfcheckBinding.getRoot());
            this.binding = adapterUtilitySelfcheckBinding;
        }
    }
}
