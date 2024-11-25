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
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UpaParam;
import com.rigol.scope.databinding.AdapterItemQualityBinding;
import com.rigol.scope.databinding.AdapterItemQualityBindingImpl;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.upa.UpaPopupViewConnection;
import com.rigol.scope.views.upa.UpaPopupview;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class UpaQualityAdapter extends RecyclerView.Adapter<UpaHolder> implements View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    View anchorView;
    private AorBManager aorBManager;
    AdapterItemQualityBinding binding;
    private View clickedView;
    Context context;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    UpaParam param;
    private PopupSpinner popupSpinner;
    BasePopupView popupView;
    private SpinnerAdapter spinnerAdapter;

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

    public UpaQualityAdapter(Context context, BasePopupView basePopupView, UpaParam upaParam) {
        this.popupView = basePopupView;
        this.param = upaParam;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public UpaHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterItemQualityBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.upaEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.upaMiddleText, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.upaDownEdit, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.upaRecordText, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.upaPassageway, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.upaCurrentSpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.upaCurrentSpinner2, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.upaSetTypeSpinner, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.UpaQualityAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(UpaQualityAdapter.this.context, ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getTextView() : null, true, ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(UpaQualityAdapter.this.context, ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getEditText() != null ? ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getEditText() : ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getTextView() != null ? ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getTextView() : null, false, ((AorBParam) UpaQualityAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.upaEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.upaMiddleText, true, ViewUtil.KEY_B);
        this.param.setAorBManager(this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$3zY5FwO7yLBtJY-e2Jz5bTMJBEc
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UpaQualityAdapter.this.lambda$onCreateViewHolder$2$UpaQualityAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new UpaHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$UpaQualityAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(UpaPopupview.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$ALc7b3mec_zM1ATI80tgOM7_B5I
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    UpaQualityAdapter.this.lambda$onCreateViewHolder$0$UpaQualityAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$HyuqzUC-7Hxw7PKzBcNP8cHq6H0
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    UpaQualityAdapter.this.lambda$onCreateViewHolder$1$UpaQualityAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$UpaQualityAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$UpaQualityAdapter(int i, MappingObject mappingObject) {
        if (this.param != null) {
            if (this.clickedView.getId() == R.id.upa_passageway) {
                this.param.savePowerVolt(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.upa_current_spinner) {
                this.param.savePowerCurr(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.upa_current_spinner2) {
                this.param.setRefLevel(mappingObject.getValue());
            } else if (this.clickedView.getId() == R.id.upa_set_type_spinner) {
                this.param.savePowerFref(mappingObject.getValue());
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(UpaHolder upaHolder, int i) {
        this.binding.upaPassageway.setOnClickListener(this);
        this.binding.upaCurrentSpinner.setOnClickListener(this);
        this.binding.upaSetTypeSpinner.setOnClickListener(this);
        this.binding.upaCurrentSpinner2.setOnClickListener(this);
        this.binding.upaEditText.setOnClickListener(this);
        this.binding.upaDownEdit.setOnClickListener(this);
        this.binding.upaFoundDefault.setOnClickListener(this);
        this.binding.upaRecordText.setOnClickListener(this);
        this.binding.upaReccovery.setOnClickListener(this);
        this.binding.upaLinkDrawing.setOnClickListener(this);
        this.binding.upaMiddleText.setOnClickListener(this);
        this.binding.setParam(this.param);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        switch (view.getId()) {
            case R.id.upa_current_spinner /* 2131364497 */:
                ViewUtil.showChanSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_upa_power_curr), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$cn5NzZ4D4BAqYooW_NgE8d_eG4s
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        UpaQualityAdapter.this.lambda$onClick$5$UpaQualityAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$ZloeEHxqRfhnNolRKbrfkoTJfCU
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        UpaQualityAdapter.this.lambda$onClick$6$UpaQualityAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
                return;
            case R.id.upa_current_spinner2 /* 2131364498 */:
                ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_upa_power_fref), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$nCI6984rOmeMXCKInFG9tXhq44k
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        UpaQualityAdapter.this.lambda$onClick$9$UpaQualityAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$LcrYs8rZv-ShghKp9Bhqn7BDnWM
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        UpaQualityAdapter.this.lambda$onClick$10$UpaQualityAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
                return;
            case R.id.upa_current_text /* 2131364499 */:
            case R.id.upa_max_mun /* 2131364504 */:
            case R.id.upa_middle_mun /* 2131364505 */:
            case R.id.upa_option /* 2131364507 */:
            case R.id.upa_record_mun /* 2131364510 */:
            case R.id.upa_rippel_reccovery /* 2131364512 */:
            case R.id.upa_ripple_edit_text /* 2131364513 */:
            case R.id.upa_ripple_spinner /* 2131364514 */:
            default:
                return;
            case R.id.upa_down_edit /* 2131364500 */:
                if (getUnit() == ServiceEnum.Unit.Unit_percent) {
                    if (this.aorBManager.setClick_showab(id)) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, getUnit(), this.param.getUpaholdLowAttr().getMaxLongValue(), this.param.getUpaholdLowAttr().getMinLongValue(), this.param.getUpaholdLowAttr().getDefLongValue(), this.param.getRefPctLow(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UpaQualityAdapter.4
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                UpaQualityAdapter.this.param.saveRefPctMidLow(Integer.parseInt(t.toString()));
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                UpaQualityAdapter.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    }
                    return;
                } else if (this.aorBManager.setClick_showab(id)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, getUnit(), this.param.getUpaAbsLowAttr().getMaxLongValue(), this.param.getUpaAbsLowAttr().getMinLongValue(), this.param.getUpaAbsLowAttr().getDefLongValue(), this.param.getRefAbsLow(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UpaQualityAdapter.5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UpaQualityAdapter.this.param.saveRefPctAbsLow(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UpaQualityAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                } else {
                    return;
                }
            case R.id.upa_edit_text /* 2131364501 */:
                if (getUnit() == ServiceEnum.Unit.Unit_percent) {
                    if (this.aorBManager.setClick_showab(id)) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, getUnit(), this.param.getUpaholdHighAttr().getMaxLongValue(), this.param.getUpaholdHighAttr().getMinLongValue(), this.param.getUpaholdHighAttr().getDefLongValue(), this.param.getRefPctlHigh(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UpaQualityAdapter.2
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                UpaQualityAdapter.this.param.saveReflHigh(Integer.parseInt(t.toString()));
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                UpaQualityAdapter.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    }
                    return;
                } else if (this.aorBManager.setClick_showab(id)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, getUnit(), this.param.getUpaAbsHighAttr().getMaxLongValue(), this.param.getUpaAbsHighAttr().getMinLongValue(), this.param.getUpaAbsHighAttr().getDefLongValue(), this.param.getRefAbsHigh(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UpaQualityAdapter.3
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UpaQualityAdapter.this.param.saveReflAbsHigh(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UpaQualityAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                } else {
                    return;
                }
            case R.id.upa_found_default /* 2131364502 */:
                API.getInstance().UI_PostInt32(31, MessageID.MSG_UPA_REFL_DEFAULT, 1);
                this.param.upaFoundDefault();
                return;
            case R.id.upa_link_drawing /* 2131364503 */:
                PopupViewManager.getInstance().get(UpaPopupViewConnection.class).show();
                return;
            case R.id.upa_middle_text /* 2131364506 */:
                if (getUnit() == ServiceEnum.Unit.Unit_percent) {
                    if (this.aorBManager.setClick_showab(id)) {
                        ViewUtil.showKeyboard(this.popupView.getAnchor(), view, getUnit(), this.param.getUpaholdMiddleAttr().getMaxLongValue(), this.param.getUpaholdMiddleAttr().getMinLongValue(), this.param.getUpaholdMiddleAttr().getDefLongValue(), this.param.getRefPctMid(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UpaQualityAdapter.7
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                UpaQualityAdapter.this.param.saveRefPctMid(Integer.parseInt(t.toString()));
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                UpaQualityAdapter.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    }
                    return;
                } else if (this.aorBManager.setClick_showab(id)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, getUnit(), this.param.getUpaAbsMiddleAttr().getMaxLongValue(), this.param.getUpaAbsMiddleAttr().getMinLongValue(), this.param.getUpaAbsMiddleAttr().getDefLongValue(), this.param.getRefAbsMid(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UpaQualityAdapter.8
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UpaQualityAdapter.this.param.saveRefAbsMid(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UpaQualityAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                } else {
                    return;
                }
            case R.id.upa_passageway /* 2131364508 */:
                BasePopupView basePopupView = this.popupView;
                if (basePopupView != null) {
                    ViewUtil.showChanSpinner(basePopupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_upa_power_volt), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$fUROdWobeCgD-3ZVw7rSBCQTjBU
                        @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                        public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                            UpaQualityAdapter.this.lambda$onClick$3$UpaQualityAdapter(popupSpinner, spinnerAdapter, list, view2);
                        }
                    }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$0vytoaOpxd_VLTYsv3qpcXF5hEU
                        @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                        public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                            UpaQualityAdapter.this.lambda$onClick$4$UpaQualityAdapter(view2, viewHolder, i, (MappingObject) obj);
                        }
                    });
                    return;
                }
                return;
            case R.id.upa_reccovery /* 2131364509 */:
                this.param.resetPowerCount();
                return;
            case R.id.upa_record_text /* 2131364511 */:
                if (this.aorBManager.setClick_showab(id)) {
                    ViewUtil.showKeyboard(this.popupView.getAnchor(), view, ServiceEnum.Unit.Unit_number, this.param.getUpaCountttr().getMaxLongValue(), this.param.getUpaCountttr().getMinLongValue(), this.param.getUpaCountttr().getDefLongValue(), this.param.getStatCount(), new KeyboardListener() { // from class: com.rigol.scope.adapters.UpaQualityAdapter.6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UpaQualityAdapter.this.param.savePowerCount(Integer.parseInt(t.toString()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UpaQualityAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                    return;
                }
                return;
            case R.id.upa_set_type_spinner /* 2131364515 */:
                ViewUtil.showSpinner(this.popupView.getAnchor(), view, ViewUtil.getList((int) R.array.msg_upa_refl_type), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$GGApHM2UaagXTz83jTkjmUeTjUY
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        UpaQualityAdapter.this.lambda$onClick$7$UpaQualityAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UpaQualityAdapter$9FmsZw_so6jQJ4jI_1IZ985AGxU
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        UpaQualityAdapter.this.lambda$onClick$8$UpaQualityAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
                return;
        }
    }

    public /* synthetic */ void lambda$onClick$3$UpaQualityAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$UpaQualityAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.savePowerVolt(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$5$UpaQualityAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$UpaQualityAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.savePowerCurr(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$7$UpaQualityAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$UpaQualityAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.savePowerFref(mappingObject.getValue());
    }

    public /* synthetic */ void lambda$onClick$9$UpaQualityAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$UpaQualityAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.setRefLevel(mappingObject.getValue());
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.upa_down_edit /* 2131364500 */:
                if (this.param.getRefPowerFref() == 0) {
                    UpaParam upaParam = this.param;
                    upaParam.saveRefPctMidLow(upaParam.getIntStep(upaParam.getRefPctLow(), this.param.getUpaholdLowAttr(), z, keyEvent));
                    return;
                }
                UpaParam upaParam2 = this.param;
                upaParam2.saveRefPctAbsLow(upaParam2.getLongStep(upaParam2.getRefAbsLow(), this.param.getUpaAbsLowAttr(), z, keyEvent));
                return;
            case R.id.upa_edit_text /* 2131364501 */:
                if (this.param.getRefPowerFref() == 0) {
                    UpaParam upaParam3 = this.param;
                    upaParam3.saveReflHigh(upaParam3.getIntStep(upaParam3.getRefPctlHigh(), this.param.getUpaholdHighAttr(), z, keyEvent));
                    return;
                }
                UpaParam upaParam4 = this.param;
                upaParam4.saveReflAbsHigh(upaParam4.getLongStep(upaParam4.getRefAbsHigh(), this.param.getUpaAbsHighAttr(), z, keyEvent));
                return;
            case R.id.upa_middle_text /* 2131364506 */:
                if (this.param.getRefPowerFref() == 0) {
                    UpaParam upaParam5 = this.param;
                    upaParam5.saveRefPctMid(upaParam5.getIntStep(upaParam5.getRefPctMid(), this.param.getUpaholdMiddleAttr(), z, keyEvent));
                    return;
                }
                UpaParam upaParam6 = this.param;
                upaParam6.saveRefAbsMid(upaParam6.getLongStep(upaParam6.getRefAbsMid(), this.param.getUpaAbsMiddleAttr(), z, keyEvent));
                return;
            case R.id.upa_record_text /* 2131364511 */:
                UpaParam upaParam7 = this.param;
                upaParam7.savePowerCount(upaParam7.getIntStep(upaParam7.getStatCount(), this.param.getUpaCountttr(), z, keyEvent));
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.upa_down_edit /* 2131364500 */:
                if (this.param.getRefPowerFref() == 0) {
                    UpaParam upaParam = this.param;
                    upaParam.saveRefPctMidLow(upaParam.getIntDef(upaParam.getUpaholdLowAttr()));
                    return;
                }
                UpaParam upaParam2 = this.param;
                upaParam2.saveRefPctAbsLow(upaParam2.getLongDef(upaParam2.getUpaAbsLowAttr()));
                return;
            case R.id.upa_edit_text /* 2131364501 */:
                if (this.param.getRefPowerFref() == 0) {
                    UpaParam upaParam3 = this.param;
                    upaParam3.saveReflHigh(upaParam3.getIntDef(upaParam3.getUpaholdHighAttr()));
                    return;
                }
                UpaParam upaParam4 = this.param;
                upaParam4.saveReflAbsHigh(upaParam4.getLongDef(upaParam4.getUpaAbsHighAttr()));
                return;
            case R.id.upa_middle_text /* 2131364506 */:
                if (this.param.getRefPowerFref() == 0) {
                    UpaParam upaParam5 = this.param;
                    upaParam5.saveRefPctMid(upaParam5.getIntDef(upaParam5.getUpaholdMiddleAttr()));
                    return;
                }
                UpaParam upaParam6 = this.param;
                upaParam6.saveRefAbsMid(upaParam6.getLongDef(upaParam6.getUpaAbsMiddleAttr()));
                return;
            case R.id.upa_record_text /* 2131364511 */:
                UpaParam upaParam7 = this.param;
                upaParam7.savePowerCount(upaParam7.getIntDef(upaParam7.getUpaCountttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public static class UpaHolder extends RecyclerView.ViewHolder {
        public UpaHolder(AdapterItemQualityBinding adapterItemQualityBinding) {
            super(adapterItemQualityBinding.getRoot());
        }
    }

    public ServiceEnum.Unit getUnit() {
        if (this.param.getRefPowerFref() == 0) {
            return ServiceEnum.Unit.Unit_percent;
        }
        return ServiceEnum.Unit.Unit_V;
    }
}
