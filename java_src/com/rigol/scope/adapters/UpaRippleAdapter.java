package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.data.UpaRippleParam;
import com.rigol.scope.databinding.AdapterItemRippleBinding;
import com.rigol.scope.databinding.AdapterItemRippleBindingImpl;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.upa.UpaPopuViewRippel;
import com.rigol.scope.views.upa.UpaPopupview;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class UpaRippleAdapter extends RecyclerView.Adapter<UpaHolder> implements View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    AdapterItemRippleBinding binding;
    private View clickedView;
    Context context;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    UpaRippleParam param;
    private PopupSpinner popupSpinner;
    BasePopupView popupView;
    private SpinnerAdapter spinnerAdapter;
    UpaParam upaParam;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public boolean isMove() {
        return this.isMove;
    }

    public void setMove(boolean z) {
        this.isMove = z;
    }

    public UpaRippleAdapter(Context context, BasePopupView basePopupView, UpaRippleParam upaRippleParam, UpaParam upaParam) {
        this.context = context;
        this.popupView = basePopupView;
        this.param = upaRippleParam;
        this.upaParam = upaParam;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UpaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterItemRippleBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.upaRippleEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.upaRippleSpinner, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.UpaRippleAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(UpaRippleAdapter.this.context, ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getTextView() : null, true, ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(UpaRippleAdapter.this.context, ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getTextView() : null, false, ((AorBParam) UpaRippleAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.upaRippleEditText, true, ViewUtil.KEY_A);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaRippleAdapter$IK1OgICM28NzYITO3rUpUrZe1vo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UpaRippleAdapter.this.lambda$onCreateViewHolder$2$UpaRippleAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new UpaHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$UpaRippleAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(UpaPopupview.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaRippleAdapter$3cu1VHCF-E34Pd5H6WIzrfTKv_U
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    UpaRippleAdapter.this.lambda$onCreateViewHolder$0$UpaRippleAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaRippleAdapter$uu3lEMsM2fk7vPJR6TuOo-0Eib4
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    UpaRippleAdapter.this.lambda$onCreateViewHolder$1$UpaRippleAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$UpaRippleAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$UpaRippleAdapter(int i, MappingObject mappingObject) {
        this.param.savePowerCurr(mappingObject.getValue());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(UpaHolder upaHolder, int i) {
        this.binding.upaRippleSpinner.setOnClickListener(this);
        this.binding.upaRippleEditText.setOnClickListener(this);
        this.binding.upaRippelReccovery.setOnClickListener(this);
        this.binding.upaReccovery.setOnClickListener(this);
        this.binding.setParam(this.param);
        this.binding.setQualityParam(this.upaParam);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        switch (view.getId()) {
            case R.id.upa_reccovery /* 2131364509 */:
                this.param.resetRippleCount();
                return;
            case R.id.upa_record_mun /* 2131364510 */:
            case R.id.upa_record_text /* 2131364511 */:
            default:
                return;
            case R.id.upa_rippel_reccovery /* 2131364512 */:
                new UpaPopuViewRippel().show();
                return;
            case R.id.upa_ripple_edit_text /* 2131364513 */:
                if (this.aorBManager.setClick_showab(id)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getUpaCountttr().getMaxLongValue(), this.param.getUpaCountttr().getMinLongValue(), this.param.getUpaCountttr().getDefLongValue(), this.upaParam.getStatCount(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UpaRippleAdapter.2
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UpaRippleAdapter.this.param.saveRippleCount(Integer.parseInt(t.toString()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UpaRippleAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.upa_ripple_spinner /* 2131364514 */:
                BasePopupView basePopupView = this.popupView;
                if (basePopupView != null) {
                    ViewUtil.showChanSpinner(basePopupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_upa_ripple_source), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaRippleAdapter$t98TZqPl1HETLi50StXKIDhdlsM
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            UpaRippleAdapter.this.lambda$onClick$3$UpaRippleAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaRippleAdapter$hVEzCdkU7sapvJJVsaujiK5eLpI
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            UpaRippleAdapter.this.lambda$onClick$4$UpaRippleAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                }
                return;
        }
    }

    public /* synthetic */ void lambda$onClick$3$UpaRippleAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$UpaRippleAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.savePowerCurr(mappingObject.getValue());
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param != null && isMove() && i == R.id.upa_ripple_edit_text) {
            UpaRippleParam upaRippleParam = this.param;
            upaRippleParam.saveRippleCount(upaRippleParam.getIntStep(upaRippleParam.getStatCounts(), this.param.getUpaCountttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param != null && isMove() && i == R.id.upa_ripple_edit_text) {
            UpaRippleParam upaRippleParam = this.param;
            upaRippleParam.saveRippleCount(upaRippleParam.getIntDef(upaRippleParam.getUpaCountttr()));
        }
    }

    /* loaded from: classes.dex */
    public static class UpaHolder extends RecyclerView.ViewHolder {
        public UpaHolder(AdapterItemRippleBinding adapterItemRippleBinding) {
            super(adapterItemRippleBinding.getRoot());
        }
    }
}
