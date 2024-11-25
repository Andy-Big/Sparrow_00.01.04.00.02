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
import com.rigol.scope.databinding.AdapterDecodeFlexrayBinding;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class DecodeFlexrayAdapter extends RecyclerView.Adapter<DecodeFlexrayHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecodeFlexrayBinding binding;
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

    public DecodeFlexrayAdapter(View view, DecodeParam decodeParam, Context context) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
    }

    public DecodeFlexrayAdapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeFlexrayHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeFlexrayBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeFlexrayHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeFlexrayHolder decodeFlexrayHolder, int i) {
        this.binding.setChannelAMapping(ViewUtil.getMappingObject(R.array.msg_decode_flex_channel, 0));
        this.binding.setChannelBMapping(ViewUtil.getMappingObject(R.array.msg_decode_flex_channel, 1));
        this.binding.decodeFlexSrcValue.setOnClickListener(this);
        this.binding.decodeFlexThresValue.setOnClickListener(this);
        this.binding.decodeFlexSignalValue.setOnClickListener(this);
        this.binding.decodeFlexBaudValue.setOnClickListener(this);
        this.binding.decodeFlexSampValue.setOnClickListener(this);
        this.binding.decodeFlexChannelRadioGroup.setOnCheckedChangeListener(this);
        this.param.readFlex_source();
        this.param.readFlex_samp();
        this.param.readFlex_signal();
        this.param.readFlex_baud();
        this.param.readFlex_channel();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_FLEX_THRE) != this.param.getFlex_thres()) {
            this.param.readFlex_thres();
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodeFlexThresValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeFlexSampValue, 0, true, ViewUtil.KEY_B, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeFlexSrcValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeFlexSignalValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeFlexBaudValue, 0, false, "", 2));
        this.binding.setParam(this.param);
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.DecodeFlexrayAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(DecodeFlexrayAdapter.this.context, ((AorBParam) DecodeFlexrayAdapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) DecodeFlexrayAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(DecodeFlexrayAdapter.this.context, ((AorBParam) DecodeFlexrayAdapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) DecodeFlexrayAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decodeFlexThresValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.decodeFlexSampValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$yk8jNdUqJ0ZFs4VoGydt2bGCCzM
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeFlexrayAdapter.this.lambda$onBindViewHolder$2$DecodeFlexrayAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DecodeFlexrayAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$mhOkzT4MmMnSrxlA_kKqn7uvGzU
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeFlexrayAdapter.this.lambda$onBindViewHolder$0$DecodeFlexrayAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$fPouET4wLzfweQ0EMYGh69yHtsU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeFlexrayAdapter.this.lambda$onBindViewHolder$1$DecodeFlexrayAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DecodeFlexrayAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DecodeFlexrayAdapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.decode_flex_baud_value) {
            selectBaudValue(mappingObject);
        } else if (id == R.id.decode_flex_signal_value) {
            selectSignalValue(i);
        } else if (id != R.id.decode_flex_src_value) {
        } else {
            selectSrcValue(mappingObject);
        }
    }

    private void selectBaudValue(MappingObject mappingObject) {
        this.param.saveFlex_baud(mappingObject.getValue());
    }

    private void selectSignalValue(int i) {
        this.param.saveFlex_signal(i);
    }

    private void selectSrcValue(MappingObject mappingObject) {
        this.param.saveFlex_source(mappingObject.getValue());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_flex_src_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_flex_src)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$Cj2KeKnpSbF3cVqhACIw45EAxtc
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeFlexrayAdapter.this.lambda$onClick$3$DecodeFlexrayAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$flQmlII_4WMRASE2M9bd-s22WFw
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeFlexrayAdapter.this.lambda$onClick$4$DecodeFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_flex_thres_value) {
            this.param.readFlex_thres();
            this.param.readFlexThresAttr();
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getFlexThresAttr().getMaxLongValue(), this.param.getFlexThresAttr().getMinLongValue(), this.param.getFlexThresAttr().getDefLongValue(), this.param.getFlex_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeFlexrayAdapter.2
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeFlexrayAdapter.this.param.saveFlex_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeFlexrayAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_flex_signal_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_flex_signal), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$T--v9cyYSR8oetAlvEAaBFM7f4E
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeFlexrayAdapter.this.lambda$onClick$5$DecodeFlexrayAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$gIDHTXPwwu_8cEq581pslzfTY3o
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeFlexrayAdapter.this.lambda$onClick$6$DecodeFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_flex_baud_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_flex_baud), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$82dpl5CuK_gnXYjcmVpBmpmY79A
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeFlexrayAdapter.this.lambda$onClick$7$DecodeFlexrayAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeFlexrayAdapter$YFun-6IyaPQsJVFsYfIGhiPaW3o
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeFlexrayAdapter.this.lambda$onClick$8$DecodeFlexrayAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_flex_samp_value && this.aorBManager.setClick_showab_textview(view.getId())) {
            this.param.readFlex_samp();
            this.param.readFlexSamplePosAttr();
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_percent, this.param.getFlexSamplePosAttr().getMaxIntValue(), this.param.getFlexSamplePosAttr().getMinIntValue(), this.param.getFlexSamplePosAttr().getDefIntValue(), this.param.getFlex_samp(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeFlexrayAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeFlexrayAdapter.this.param.saveFlex_samp(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeFlexrayAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$DecodeFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$DecodeFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSrcValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$DecodeFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DecodeFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSignalValue(i);
    }

    public /* synthetic */ void lambda$onClick$7$DecodeFlexrayAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$DecodeFlexrayAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectBaudValue(mappingObject);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.findViewById(i).isPressed()) {
            if (i == R.id.decode_flex_channelA_radioButton) {
                this.param.saveFlex_channel(false);
            } else if (i == R.id.decode_flex_channelB_radioButton) {
                this.param.saveFlex_channel(true);
            }
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        if (i == R.id.decode_flex_samp_value) {
            this.param.readFlex_samp();
            this.param.readFlexSamplePosAttr();
            DecodeParam decodeParam = this.param;
            decodeParam.saveFlex_samp(decodeParam.getLongStep(decodeParam.getFlex_samp(), this.param.getFlexSamplePosAttr(), z, keyEvent));
        } else if (i != R.id.decode_flex_thres_value) {
        } else {
            this.param.readFlex_thres();
            this.param.readFlexThresAttr();
            DecodeParam decodeParam2 = this.param;
            decodeParam2.saveFlex_thres(decodeParam2.getLongStep(decodeParam2.getFlex_thres(), this.param.getFlexThresAttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        if (i == R.id.decode_flex_samp_value) {
            this.param.readFlex_samp();
            this.param.readFlexSamplePosAttr();
            DecodeParam decodeParam = this.param;
            decodeParam.saveFlex_samp(decodeParam.getLongDef(decodeParam.getFlexSamplePosAttr()));
        } else if (i != R.id.decode_flex_thres_value) {
        } else {
            this.param.readFlex_thres();
            this.param.readFlexThresAttr();
            DecodeParam decodeParam2 = this.param;
            decodeParam2.saveFlex_thres(decodeParam2.getLongDef(decodeParam2.getFlexThresAttr()));
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeFlexrayHolder extends RecyclerView.ViewHolder {
        public DecodeFlexrayHolder(AdapterDecodeFlexrayBinding adapterDecodeFlexrayBinding) {
            super(adapterDecodeFlexrayBinding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
