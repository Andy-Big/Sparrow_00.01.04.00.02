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
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeLinBinding;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DecodeLinAdapter extends RecyclerView.Adapter<DecodeLinHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, View.OnLongClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecodeLinBinding binding;
    private View clickedView;
    private final Context context;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private final DecodeParam param;
    private PopupSpinner popupSpinner;
    private PopupviewDecodeBinding popupviewDecodeBinding;
    private SpinnerAdapter spinnerAdapter;
    private DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public DecodeLinAdapter(View view, DecodeParam decodeParam, Context context) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
    }

    public DecodeLinAdapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeLinHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeLinBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeLinHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeLinHolder decodeLinHolder, int i) {
        this.binding.setParityWithMapping(ViewUtil.getMappingObject(R.array.msg_decode_lin_parity, 1));
        this.binding.setParityWithoutMapping(ViewUtil.getMappingObject(R.array.msg_decode_lin_parity, 0));
        this.binding.setVer1Mapping(ViewUtil.getMappingObject(R.array.msg_decode_lin_ver, 0));
        this.binding.setVer2Mapping(ViewUtil.getMappingObject(R.array.msg_decode_lin_ver, 1));
        this.binding.setVerBothMapping(ViewUtil.getMappingObject(R.array.msg_decode_lin_ver, 2));
        this.binding.decodeLinSrcValue.setOnClickListener(this);
        this.binding.decodeLinThresValue.setOnClickListener(this);
        this.binding.decodeLinBaudValue.setOnClickListener(this);
        this.binding.decodeLinBaudValue.setOnLongClickListener(this);
        this.binding.decodeLinParityRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeLinVersionRadioGroup.setOnCheckedChangeListener(this);
        this.param.readLin_source();
        this.param.readLin_baud();
        this.param.readLin_polarity();
        this.param.readLin_version();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_LIN_THRE) != this.param.getLin_thres()) {
            this.param.readLin_thres();
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodeLinThresValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeLinSrcValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeLinBaudValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.DecodeLinAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(DecodeLinAdapter.this.context, ((AorBParam) DecodeLinAdapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) DecodeLinAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(DecodeLinAdapter.this.context, ((AorBParam) DecodeLinAdapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) DecodeLinAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decodeLinThresValue, true, ViewUtil.KEY_A);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeLinAdapter$cIM4EkfaN_BtJCFRAbr66nMS7_g
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeLinAdapter.this.lambda$onBindViewHolder$2$DecodeLinAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        this.binding.setParam(this.param);
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DecodeLinAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeLinAdapter$RM_BUYEndDP0GrGqS2bTS35Radg
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeLinAdapter.this.lambda$onBindViewHolder$0$DecodeLinAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeLinAdapter$xn_vVnzeRzWDUe_I81S4E2oTvsI
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeLinAdapter.this.lambda$onBindViewHolder$1$DecodeLinAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DecodeLinAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DecodeLinAdapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view != null && view.getId() == R.id.decode_lin_src_value) {
            selectSrcValue(mappingObject);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        int id = view.getId();
        if (id == R.id.decode_lin_src_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_lin_src)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeLinAdapter$mrc885anb5pY3wSo1x2SRSzLmrE
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeLinAdapter.this.lambda$onClick$3$DecodeLinAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeLinAdapter$nQdLOVsjlQthBj8t05BvU0idcsM
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeLinAdapter.this.lambda$onClick$4$DecodeLinAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_lin_thres_value) {
            this.param.readLin_thres();
            this.param.readLinThresAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getLinThresAttr().getMaxLongValue(), this.param.getLinThresAttr().getMinLongValue(), this.param.getLinThresAttr().getDefLongValue(), this.param.getLin_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeLinAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeLinAdapter.this.param.saveLin_thres(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeLinAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.decode_lin_baud_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_lin_baud), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeLinAdapter$Qac-VJqPoZLYz8EEP9p7WkwBeg8
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeLinAdapter.this.lambda$onClick$5$DecodeLinAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeLinAdapter$k1EWm2ZwdT0YSJ4NSem9sZfKQ2M
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeLinAdapter.this.lambda$onClick$6$DecodeLinAdapter(view, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$DecodeLinAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$DecodeLinAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSrcValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$DecodeLinAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DecodeLinAdapter(View view, View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (mappingObject.getValue() != 0) {
            this.param.saveLin_baud(mappingObject.getValue());
            return;
        }
        DecodeParam decodeParam = this.param;
        decodeParam.setLin_baud(decodeParam.getLin_baud());
        ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getLinBaudAttr().getMaxIntValue(), this.param.getLinBaudAttr().getMinIntValue(), this.param.getLinBaudAttr().getDefIntValue(), this.param.getLin_baud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeLinAdapter.3
            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public <T> void resultMinUnitValueListener(T t) {
                DecodeLinAdapter.this.param.saveLin_baud(((Long) t).intValue());
            }

            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public void onCall(KeyboardPopupView keyboardPopupView) {
                DecodeLinAdapter.this.keyboardPopupView = keyboardPopupView;
            }
        });
    }

    private void selectSrcValue(MappingObject mappingObject) {
        this.param.saveLin_source(mappingObject.getValue());
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.findViewById(i).isPressed()) {
            if (i == R.id.decode_lin_with_radioButton) {
                this.param.saveLin_parity_bit(true);
            } else if (i == R.id.decode_lin_without_radioButton) {
                this.param.saveLin_parity_bit(false);
            } else if (i == R.id.decode_lin_1x_radioButton) {
                this.param.saveLin_version(0);
            } else if (i == R.id.decode_lin_2x_radioButton) {
                this.param.saveLin_version(1);
            } else if (i == R.id.decode_lin_both_radioButton) {
                this.param.saveLin_version(2);
            }
        }
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.decode_lin_baud_value) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getLinBaudAttr().getMaxIntValue(), this.param.getLinBaudAttr().getMinIntValue(), this.param.getLinBaudAttr().getDefIntValue(), this.param.getLin_baud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeLinAdapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeLinAdapter.this.param.saveLin_baud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeLinAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
        return true;
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !getIsMove() || i != R.id.decode_lin_thres_value || this.param.getLin_source() >= 8) {
            return;
        }
        this.param.readLin_thres();
        this.param.readLinThresAttr();
        DecodeParam decodeParam = this.param;
        decodeParam.saveLin_thres(decodeParam.getLongStep(decodeParam.getLin_thres(), this.param.getLinThresAttr(), z, keyEvent));
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param != null && getIsMove() && i == R.id.decode_lin_thres_value) {
            this.param.readLin_thres();
            this.param.readLinThresAttr();
            DecodeParam decodeParam = this.param;
            decodeParam.saveLin_thres(decodeParam.getLongDef(decodeParam.getLinThresAttr()));
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeLinHolder extends RecyclerView.ViewHolder {
        public DecodeLinHolder(AdapterDecodeLinBinding adapterDecodeLinBinding) {
            super(adapterDecodeLinBinding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
