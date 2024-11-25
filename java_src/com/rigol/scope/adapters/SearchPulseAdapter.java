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
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.databinding.AdapterSearchTriggerPulseBinding;
import com.rigol.scope.databinding.AdapterSearchTriggerPulseBindingImpl;
import com.rigol.scope.databinding.PopupviewSearchBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.search.SearchPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class SearchPulseAdapter extends RecyclerView.Adapter<AdapterSearchTriggerPulseHolder> implements View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchor;
    private AorBManager aorBManager;
    private AdapterSearchTriggerPulseBinding binding;
    private View clickedView;
    private Context context;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private AorBManager.OnOutOrInAdapterClickChangeListener listener;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private PopupSpinner popupSpinner;
    private PopupviewSearchBinding popupviewSearchBinding;
    private SearchParam searchParam;
    private SpinnerAdapter spinnerAdapter;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AdapterSearchTriggerPulseHolder adapterSearchTriggerPulseHolder, int i) {
    }

    public boolean isMove() {
        return this.isMove;
    }

    public void setMove(boolean z) {
        this.isMove = z;
    }

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public void setListener(PopupviewSearchBinding popupviewSearchBinding, AorBManager.OnOutOrInAdapterClickChangeListener onOutOrInAdapterClickChangeListener) {
        this.popupviewSearchBinding = popupviewSearchBinding;
        this.listener = onOutOrInAdapterClickChangeListener;
    }

    public SearchPulseAdapter(SearchParam searchParam, Context context) {
        this.context = context;
        this.searchParam = searchParam;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AdapterSearchTriggerPulseHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterSearchTriggerPulseBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()));
        BasePopupView basePopupView = PopupViewManager.getInstance().get(SearchPopupView.class);
        if (basePopupView != null) {
            this.anchor = basePopupView.getAnchor();
        }
        this.binding.setParam(this.searchParam);
        this.binding.triggerSource.setOnClickListener(this);
        this.binding.polarityP.setOnClickListener(this);
        this.binding.polarityN.setOnClickListener(this);
        this.binding.lessMore.setOnClickListener(this);
        this.binding.moreThan.setOnClickListener(this);
        this.binding.lessThan.setOnClickListener(this);
        this.binding.threEditText.setOnClickListener(this);
        this.binding.upperLimitEditText.setOnClickListener(this);
        this.binding.lowerLimitEditText.setOnClickListener(this);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.threEditText, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.lowerLimitEditText, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.upperLimitEditText, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.triggerSource, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.SearchPulseAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(SearchPulseAdapter.this.context, ((AorBParam) SearchPulseAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) SearchPulseAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(SearchPulseAdapter.this.context, ((AorBParam) SearchPulseAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) SearchPulseAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.threEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.lowerLimitEditText, true, ViewUtil.KEY_B);
        if (this.searchParam.getPolaritySlope() == ServiceEnum.getEMoreThanFromValue1(1)) {
            this.aorBManager.set_RadioButton(0, 1);
        } else {
            this.aorBManager.set_RadioButton(0, 2);
        }
        this.searchParam.setPulseAorBManager(this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchPulseAdapter$6zRKsjoGPEafwIo7fBQVsvKAOlg
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SearchPulseAdapter.this.lambda$onCreateViewHolder$2$SearchPulseAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new AdapterSearchTriggerPulseHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$SearchPulseAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(SearchPopupView.class) && (this.popupviewSearchBinding.searchView.getAdapter() instanceof SearchPulseAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchPulseAdapter$30d4RflKyDFy3-i2MRUYGTwC-YU
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    SearchPulseAdapter.this.lambda$onCreateViewHolder$0$SearchPulseAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchPulseAdapter$3xjBvPki40_Y8fcEnDivSTagoNo
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    SearchPulseAdapter.this.lambda$onCreateViewHolder$1$SearchPulseAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$SearchPulseAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$SearchPulseAdapter(int i, MappingObject mappingObject) {
        selectAdapter(mappingObject);
    }

    private void selectAdapter(MappingObject mappingObject) {
        this.searchParam.savePulseSrc(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        switch (view.getId()) {
            case R.id.less_more /* 2131363313 */:
                this.aorBManager.set_RadioButton(0, 2);
                this.searchParam.savePolaritySlope(ServiceEnum.getEMoreThanFromValue1(3));
                PopupViewManager.getInstance().showCurrentWindowLight(PopupViewManager.getInstance().get(SearchPopupView.class));
                break;
            case R.id.less_than /* 2131363314 */:
                this.aorBManager.set_RadioButton(0, 2);
                this.searchParam.savePolaritySlope(ServiceEnum.getEMoreThanFromValue1(2));
                PopupViewManager.getInstance().showCurrentWindowLight(PopupViewManager.getInstance().get(SearchPopupView.class));
                break;
            case R.id.lower_limit_edit_text /* 2131363341 */:
                if (this.aorBManager.setClick_showab(id)) {
                    this.searchParam.readlowAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, this.searchParam.getreadlowAttr().getMaxLongValue(), this.searchParam.getreadlowAttr().getMinLongValue(), this.searchParam.getreadlowAttr().getDefLongValue(), this.searchParam.getPulseLower().longValue(), new KeyboardListener() { // from class: com.rigol.scope.adapters.SearchPulseAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            SearchPulseAdapter.this.searchParam.savePulseLower((Long) t);
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            SearchPulseAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.more_than /* 2131363421 */:
                this.aorBManager.set_RadioButton(0, 1);
                this.searchParam.savePolaritySlope(ServiceEnum.getEMoreThanFromValue1(1));
                PopupViewManager.getInstance().showCurrentWindowLight(PopupViewManager.getInstance().get(SearchPopupView.class));
                break;
            case R.id.polarity_n /* 2131363608 */:
                this.searchParam.savePulsePolarty(1);
                break;
            case R.id.polarity_p /* 2131363609 */:
                this.searchParam.savePulsePolarty(0);
                break;
            case R.id.thre_edit_text /* 2131364066 */:
                if (this.aorBManager.setClick_showab(id)) {
                    this.searchParam.readThreAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_V, this.searchParam.getThreAttr().getMaxLongValue(), this.searchParam.getThreAttr().getMinLongValue(), this.searchParam.getThreAttr().getDefLongValue(), this.searchParam.getThre(), new KeyboardListener() { // from class: com.rigol.scope.adapters.SearchPulseAdapter.2
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            SearchPulseAdapter.this.searchParam.saveThre((Long) t);
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            SearchPulseAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
            case R.id.trigger_source /* 2131364336 */:
                ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_search_pulse_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchPulseAdapter$kcS7RtKEzscuIF1trcMMrAoZf18
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        SearchPulseAdapter.this.lambda$onClick$3$SearchPulseAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchPulseAdapter$aFr2adt4VgA0EoQE7SpV8An0DmI
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        SearchPulseAdapter.this.lambda$onClick$4$SearchPulseAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
                break;
            case R.id.upper_limit_edit_text /* 2131364523 */:
                if (this.aorBManager.setClick_showab(id)) {
                    this.searchParam.readmaxAttr();
                    ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, this.searchParam.getreadmaxAttr().getMaxLongValue(), this.searchParam.getreadmaxAttr().getMinLongValue(), this.searchParam.getreadmaxAttr().getDefLongValue(), this.searchParam.getPulseMax().longValue(), new KeyboardListener() { // from class: com.rigol.scope.adapters.SearchPulseAdapter.4
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            SearchPulseAdapter.this.searchParam.savePulseMax((Long) t);
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            SearchPulseAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    break;
                }
                break;
        }
        AorBManager.OnOutOrInAdapterClickChangeListener onOutOrInAdapterClickChangeListener = this.listener;
        if (onOutOrInAdapterClickChangeListener != null) {
            onOutOrInAdapterClickChangeListener.onChange(false);
        }
    }

    public /* synthetic */ void lambda$onClick$3$SearchPulseAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$SearchPulseAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAdapter(mappingObject);
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.searchParam == null || !isMove()) {
            return;
        }
        if (i == R.id.lower_limit_edit_text) {
            this.searchParam.readlowAttr();
            SearchParam searchParam = this.searchParam;
            searchParam.savePulseLower(Long.valueOf(searchParam.getLongStep(searchParam.getPulseLower().longValue(), this.searchParam.getreadlowAttr(), z, keyEvent)));
        } else if (i == R.id.thre_edit_text) {
            SearchParam searchParam2 = this.searchParam;
            searchParam2.saveThre(Long.valueOf(searchParam2.getLongStep(searchParam2.getThre(), this.searchParam.getThreAttr(), z, keyEvent)));
        } else if (i != R.id.upper_limit_edit_text) {
        } else {
            this.searchParam.readmaxAttr();
            SearchParam searchParam3 = this.searchParam;
            searchParam3.savePulseMax(Long.valueOf(searchParam3.getLongStep(searchParam3.getPulseMax().longValue(), this.searchParam.getreadmaxAttr(), z, keyEvent)));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.searchParam == null || !isMove()) {
            return;
        }
        if (i == R.id.lower_limit_edit_text) {
            this.searchParam.readlowAttr();
            SearchParam searchParam = this.searchParam;
            searchParam.savePulseLower(Long.valueOf(searchParam.getLongDef(searchParam.getreadlowAttr())));
        } else if (i == R.id.thre_edit_text) {
            SearchParam searchParam2 = this.searchParam;
            searchParam2.saveThre(Long.valueOf(searchParam2.getLongDef(searchParam2.getThreAttr())));
        } else if (i != R.id.upper_limit_edit_text) {
        } else {
            this.searchParam.readmaxAttr();
            SearchParam searchParam3 = this.searchParam;
            searchParam3.savePulseMax(Long.valueOf(searchParam3.getLongDef(searchParam3.getreadmaxAttr())));
        }
    }

    /* loaded from: classes.dex */
    public static class AdapterSearchTriggerPulseHolder extends RecyclerView.ViewHolder {
        public AdapterSearchTriggerPulseHolder(AdapterSearchTriggerPulseBinding adapterSearchTriggerPulseBinding) {
            super(adapterSearchTriggerPulseBinding.getRoot());
        }
    }
}
