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
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeCanBinding;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KtUtilKt;
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
public class DecodeCanAdapter extends RecyclerView.Adapter<DecodeCanHolder> implements View.OnClickListener, View.OnLongClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecodeCanBinding binding;
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

    public DecodeCanAdapter(View view, DecodeParam decodeParam, Context context) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
    }

    public DecodeCanAdapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeCanHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeCanBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeCanHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeCanHolder decodeCanHolder, int i) {
        this.binding.decodeCanSrcValue.setOnClickListener(this);
        this.binding.decodeCanThresValue.setOnClickListener(this);
        this.binding.decodeCanSignalValue.setOnClickListener(this);
        this.binding.decodeCanBaudValue.setOnClickListener(this);
        this.binding.decodeCanBaudValue.setOnLongClickListener(this);
        this.binding.decodeCanFdBaudValue.setOnClickListener(this);
        this.binding.decodeCanFdBaudValue.setOnLongClickListener(this);
        this.binding.decodeCanSampValue.setOnClickListener(this);
        this.binding.decodeCanFdSampValue.setOnClickListener(this);
        this.param.readCan_source();
        this.param.readCan_singal();
        this.param.readCan_baud();
        this.param.readCan_samp();
        this.param.readCan_fd_baud();
        this.param.readCan_fd_samp();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_CAN_THRE) != this.param.getCan_threas()) {
            this.param.readCan_threas();
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodeCanThresValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeCanSampValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeCanFdSampValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeCanSrcValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeCanBaudValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeCanFdBaudValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeCanSignalValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.DecodeCanAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(DecodeCanAdapter.this.context, ((AorBParam) DecodeCanAdapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) DecodeCanAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(DecodeCanAdapter.this.context, ((AorBParam) DecodeCanAdapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) DecodeCanAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decodeCanThresValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.decodeCanSampValue, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$4g3J68IlsI-HXmxYfWqTI468kgc
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeCanAdapter.this.lambda$onBindViewHolder$2$DecodeCanAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        KtUtilKt.isOptAuto();
        API.getInstance().UI_QueryInt32(11, MessageID.MSG_PRODUCT_SERIES);
        int i2 = ServiceEnum.ProductSeries.SERIES_1000.value1;
        this.binding.setParam(this.param);
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DecodeCanAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$k1_Z1oHXJqagoq4jzltENr09RF8
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeCanAdapter.this.lambda$onBindViewHolder$0$DecodeCanAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$HDHAOidhchP0Ff_2EvI7wQ6WoNQ
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeCanAdapter.this.lambda$onBindViewHolder$1$DecodeCanAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DecodeCanAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DecodeCanAdapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.decode_can_signal_value) {
            selectSignalValue(i);
        } else if (id != R.id.decode_can_src_value) {
        } else {
            selectSrcValue(mappingObject);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(final View view) {
        int id = view.getId();
        if (id == R.id.decode_can_src_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_can_src)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$1GIEeW-A5p8WM7FLvLKd2rKLT9A
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeCanAdapter.this.lambda$onClick$3$DecodeCanAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$1c8qTmmGtmw62COmJqE6-XMg2ao
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeCanAdapter.this.lambda$onClick$4$DecodeCanAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_can_baud_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_can_baud), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$YnGyS5IYsRArlHXXp6EN5It2FFU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeCanAdapter.this.lambda$onClick$5$DecodeCanAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$T_KbKyZK3cbWeCUx4B6eyodb-E4
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeCanAdapter.this.lambda$onClick$6$DecodeCanAdapter(view, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_can_fd_baud_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_canfd_baud), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$dCH1-IE9qf8LOyJWV1T7Cij2aAg
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeCanAdapter.this.lambda$onClick$7$DecodeCanAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$Ef2gzTvZpqG1_a27R9cwBXKDGi0
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeCanAdapter.this.lambda$onClick$8$DecodeCanAdapter(view, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_can_thres_value) {
            this.param.readCan_threas();
            this.param.readCanThresAttr();
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getCanThresAttr().getMaxLongValue(), this.param.getCanThresAttr().getMinLongValue(), this.param.getCanThresAttr().getDefLongValue(), this.param.getCan_threas(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeCanAdapter.4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeCanAdapter.this.param.saveCan_threas(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeCanAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_can_signal_value) {
            ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_can_signal), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$5-oTiUFseB3V1b9JEwuf3e6r_XI
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeCanAdapter.this.lambda$onClick$9$DecodeCanAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCanAdapter$2q4eW5lbWVaxT46X-59dYZHd4Go
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeCanAdapter.this.lambda$onClick$10$DecodeCanAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_can_samp_value) {
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                this.param.readCan_samp();
                this.param.readCanSamplePosAttr();
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_percent, this.param.getCanSamplePosAttr().getMaxIntValue(), this.param.getCanSamplePosAttr().getMinIntValue(), this.param.getCanSamplePosAttr().getDefIntValue(), this.param.getCan_samp(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeCanAdapter.5
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeCanAdapter.this.param.saveCan_samp(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeCanAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_can_fd_samp_value && this.aorBManager.setClick_showab_textview(view.getId())) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_percent, this.param.getCanFdSamplePosAttr().getMaxIntValue(), this.param.getCanFdSamplePosAttr().getMinIntValue(), this.param.getCanFdSamplePosAttr().getDefIntValue(), this.param.getCan_fd_samp(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeCanAdapter.6
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeCanAdapter.this.param.saveCan_fd_samp(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeCanAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$DecodeCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$DecodeCanAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSrcValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$DecodeCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DecodeCanAdapter(View view, View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (mappingObject.getValue() != 0) {
            this.param.saveCan_baud(mappingObject.getValue());
            return;
        }
        DecodeParam decodeParam = this.param;
        decodeParam.setCan_baud(decodeParam.getCan_baud());
        ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getCanBaudAttr().getMaxIntValue(), this.param.getCanBaudAttr().getMinIntValue(), this.param.getCanBaudAttr().getDefIntValue(), this.param.getCan_baud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeCanAdapter.2
            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public <T> void resultMinUnitValueListener(T t) {
                DecodeCanAdapter.this.param.saveCan_baud(((Long) t).intValue());
            }

            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public void onCall(KeyboardPopupView keyboardPopupView) {
                DecodeCanAdapter.this.keyboardPopupView = keyboardPopupView;
            }
        });
    }

    public /* synthetic */ void lambda$onClick$7$DecodeCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$DecodeCanAdapter(View view, View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (mappingObject.getValue() != 0) {
            this.param.saveCan_fd_baud(mappingObject.getValue());
            return;
        }
        DecodeParam decodeParam = this.param;
        decodeParam.setCan_fd_baud(decodeParam.getCan_fd_baud());
        ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getCanFdBaudAttr().getMaxIntValue(), this.param.getCanFdBaudAttr().getMinIntValue(), this.param.getCanFdBaudAttr().getDefIntValue(), this.param.getCan_fd_baud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeCanAdapter.3
            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public <T> void resultMinUnitValueListener(T t) {
                DecodeCanAdapter.this.param.saveCan_fd_baud(((Long) t).intValue());
            }

            @Override // com.rigol.scope.views.keyboard.KeyboardListener
            public void onCall(KeyboardPopupView keyboardPopupView) {
                DecodeCanAdapter.this.keyboardPopupView = keyboardPopupView;
            }
        });
    }

    public /* synthetic */ void lambda$onClick$9$DecodeCanAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$DecodeCanAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSignalValue(i);
    }

    private void selectSignalValue(int i) {
        this.param.saveCan_singal(i);
    }

    private void selectSrcValue(MappingObject mappingObject) {
        this.param.saveCan_source(mappingObject.getValue());
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        if (view.getId() == R.id.decode_can_baud_value) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getCanBaudAttr().getMaxIntValue(), this.param.getCanBaudAttr().getMinIntValue(), this.param.getCanBaudAttr().getDefIntValue(), this.param.getCan_baud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeCanAdapter.7
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeCanAdapter.this.param.saveCan_baud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeCanAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
            return true;
        } else if (view.getId() == R.id.decode_can_fd_baud_value) {
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getCanFdBaudAttr().getMaxIntValue(), this.param.getCanFdBaudAttr().getMinIntValue(), this.param.getCanFdBaudAttr().getDefIntValue(), this.param.getCan_fd_baud(), UnitFormat.SI.NONE, new UnitFormat.SI[]{UnitFormat.SI.MEGA, UnitFormat.SI.KILO}, "0.###", new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeCanAdapter.8
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeCanAdapter.this.param.saveCan_fd_baud(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeCanAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
            return true;
        } else {
            return true;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        if (i == R.id.decode_can_fd_samp_value) {
            this.param.readCan_fd_samp();
            this.param.readCanFdSamplePosAttr();
            DecodeParam decodeParam = this.param;
            decodeParam.saveCan_fd_samp(decodeParam.getLongStep(decodeParam.getCan_fd_samp(), this.param.getCanFdSamplePosAttr(), z, keyEvent));
        } else if (i != R.id.decode_can_samp_value) {
            if (i == R.id.decode_can_thres_value && this.param.getCan_source() < 8) {
                this.param.readCan_threas();
                this.param.readCanThresAttr();
                DecodeParam decodeParam2 = this.param;
                decodeParam2.saveCan_threas(decodeParam2.getLongStep(decodeParam2.getCan_threas(), this.param.getCanThresAttr(), z, keyEvent));
            }
        } else {
            this.param.readCan_samp();
            this.param.readCanSamplePosAttr();
            DecodeParam decodeParam3 = this.param;
            decodeParam3.saveCan_samp(decodeParam3.getLongStep(decodeParam3.getCan_samp(), this.param.getCanSamplePosAttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        if (i == R.id.decode_can_fd_samp_value) {
            this.param.readCan_fd_samp();
            this.param.readCanFdSamplePosAttr();
            DecodeParam decodeParam = this.param;
            decodeParam.saveCan_fd_samp(decodeParam.getLongDef(decodeParam.getCanFdSamplePosAttr()));
        } else if (i == R.id.decode_can_samp_value) {
            this.param.readCan_samp();
            this.param.readCanSamplePosAttr();
            DecodeParam decodeParam2 = this.param;
            decodeParam2.saveCan_samp(decodeParam2.getLongDef(decodeParam2.getCanSamplePosAttr()));
        } else if (i != R.id.decode_can_thres_value) {
        } else {
            this.param.readCan_threas();
            this.param.readCanThresAttr();
            DecodeParam decodeParam3 = this.param;
            decodeParam3.saveCan_threas(decodeParam3.getLongDef(decodeParam3.getCanThresAttr()));
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeCanHolder extends RecyclerView.ViewHolder {
        public DecodeCanHolder(AdapterDecodeCanBinding adapterDecodeCanBinding) {
            super(adapterDecodeCanBinding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
