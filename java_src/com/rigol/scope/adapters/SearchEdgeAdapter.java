package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.databinding.AdapterSearchEdgeBinding;
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
public class SearchEdgeAdapter extends RecyclerView.Adapter<SearchEdgeHolder> implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchor;
    private AorBManager aorBManager;
    private AdapterSearchEdgeBinding binding;
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
    public void onBindViewHolder(SearchEdgeHolder searchEdgeHolder, int i) {
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

    public SearchEdgeAdapter(SearchParam searchParam, Context context) {
        this.searchParam = searchParam;
        this.context = context;
    }

    private void initStyle(AdapterSearchEdgeBinding adapterSearchEdgeBinding) {
        adapterSearchEdgeBinding.setEdgeRisingMapping(ViewUtil.getMappingObject(R.array.msg_search_edge_slope, ServiceEnum.EdgeSlope.Trigger_Edge_Rising.value1));
        adapterSearchEdgeBinding.setEdgeFallingMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_b, ServiceEnum.EdgeSlope.Trigger_Edge_Falling.value1));
        adapterSearchEdgeBinding.setEdgeEitherMapping(ViewUtil.getMappingObject(R.array.msg_trigger_edge_b, ServiceEnum.EdgeSlope.Trigger_Edge_Any.value1));
        adapterSearchEdgeBinding.edgeSourceSpinner.setOnClickListener(this);
        adapterSearchEdgeBinding.threEditText.setOnClickListener(this);
        adapterSearchEdgeBinding.edgeSlopetypeRadioGroup.setOnCheckedChangeListener(this);
        adapterSearchEdgeBinding.edgeSlopeImage.setOnClickListener(this);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(adapterSearchEdgeBinding.threEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(adapterSearchEdgeBinding.edgeSourceSpinner, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.SearchEdgeAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                showKey(SearchEdgeAdapter.this.context, ((AorBParam) SearchEdgeAdapter.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) SearchEdgeAdapter.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                showKey(SearchEdgeAdapter.this.context, ((AorBParam) SearchEdgeAdapter.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) SearchEdgeAdapter.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, adapterSearchEdgeBinding.threEditText, true, ViewUtil.KEY_A);
        this.searchParam.setEdgeAorBManager(this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchEdgeAdapter$BDH3blFYg691G_ecADMgY4WrUkg
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        SearchEdgeAdapter.this.lambda$initStyle$2$SearchEdgeAdapter((KeyEvent) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$initStyle$2$SearchEdgeAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(SearchPopupView.class) && (this.popupviewSearchBinding.searchView.getAdapter() instanceof SearchEdgeAdapter)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchEdgeAdapter$gsTQQiO60lrysSWE-rygPGnWoJY
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    SearchEdgeAdapter.this.lambda$initStyle$0$SearchEdgeAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchEdgeAdapter$jfCGHDF7AjFcMvZTWw-OJoTHBYs
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    SearchEdgeAdapter.this.lambda$initStyle$1$SearchEdgeAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$initStyle$0$SearchEdgeAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$initStyle$1$SearchEdgeAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.edge_source_spinner) {
            selectAdapter(mappingObject);
        }
    }

    private void selectAdapter(MappingObject mappingObject) {
        this.searchParam.saveEageSrc(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public SearchEdgeHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterSearchEdgeBinding inflate = AdapterSearchEdgeBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        SearchParam searchParam = this.searchParam;
        if (searchParam != null) {
            inflate.setParam(searchParam);
        }
        initStyle(this.binding);
        BasePopupView basePopupView = PopupViewManager.getInstance().get(SearchPopupView.class);
        if (basePopupView != null) {
            this.anchor = basePopupView.getAnchor();
        }
        return new SearchEdgeHolder(this.binding);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (view.isPressed()) {
            if (id == R.id.edge_source_spinner) {
                ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_search_edge_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchEdgeAdapter$GOvT5G47CdK3aZf5N9jhlFMU7XI
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        SearchEdgeAdapter.this.lambda$onClick$3$SearchEdgeAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$SearchEdgeAdapter$_Kl0YI7AsLiGFq5dhCsArFpgpOA
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        SearchEdgeAdapter.this.lambda$onClick$4$SearchEdgeAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else if (id == R.id.edge_slope_image) {
                if (this.searchParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
                    this.searchParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling);
                } else if (this.searchParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
                    this.searchParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any);
                } else if (this.searchParam.getEdgeSlope() == ServiceEnum.EdgeSlope.Trigger_Edge_Any) {
                    this.searchParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising);
                }
            } else if (id == R.id.thre_edit_text && this.aorBManager.setClick_showab(id)) {
                this.searchParam.readThreAttr();
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_V, this.searchParam.getThreAttr().getMaxLongValue(), this.searchParam.getThreAttr().getMinLongValue(), this.searchParam.getThreAttr().getDefLongValue(), this.searchParam.getThre(), new KeyboardListener() { // from class: com.rigol.scope.adapters.SearchEdgeAdapter.2
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        SearchEdgeAdapter.this.searchParam.saveThre((Long) t);
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        SearchEdgeAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
            AorBManager.OnOutOrInAdapterClickChangeListener onOutOrInAdapterClickChangeListener = this.listener;
            if (onOutOrInAdapterClickChangeListener != null) {
                onOutOrInAdapterClickChangeListener.onChange(false);
            }
        }
    }

    public /* synthetic */ void lambda$onClick$3$SearchEdgeAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$SearchEdgeAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAdapter(mappingObject);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.edge_rising_radio_button) {
            this.searchParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Rising);
        } else if (i == R.id.edge_falling_radio_button) {
            this.searchParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Falling);
        } else if (i == R.id.edge_either_radio_button) {
            this.searchParam.saveEdgeSlope(ServiceEnum.EdgeSlope.Trigger_Edge_Any);
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.searchParam != null && isMove() && i == R.id.thre_edit_text) {
            SearchParam searchParam = this.searchParam;
            searchParam.saveThre(Long.valueOf(searchParam.getLongStep(searchParam.getThre(), this.searchParam.getThreAttr(), z, keyEvent)));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.searchParam != null && isMove() && i == R.id.thre_edit_text) {
            SearchParam searchParam = this.searchParam;
            searchParam.saveThre(Long.valueOf(searchParam.getLongDef(searchParam.getThreAttr())));
        }
    }

    /* loaded from: classes.dex */
    public class SearchEdgeHolder extends RecyclerView.ViewHolder {
        private AdapterSearchEdgeBinding binding;

        public SearchEdgeHolder(AdapterSearchEdgeBinding adapterSearchEdgeBinding) {
            super(adapterSearchEdgeBinding.getRoot());
            this.binding = adapterSearchEdgeBinding;
        }
    }
}
