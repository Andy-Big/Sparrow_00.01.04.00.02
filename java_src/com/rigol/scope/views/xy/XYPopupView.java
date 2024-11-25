package com.rigol.scope.views.xy;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import androidx.collection.SparseArrayCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.databinding.PopupviewXyBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.StateManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.XYViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.cursor.CursorSettingPopupView;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public class XYPopupView extends BasePopupView implements SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private AorBManager aorBManager;
    private final PopupviewXyBinding binding;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;
    private WindowParam windowParam;
    private XYParam xyParam;

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStartTrackingTouch(SeekBar seekBar) {
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onStopTrackingTouch(SeekBar seekBar) {
    }

    public XYPopupView() {
        super((int) R.style.App_PopupWindow_XY);
        this.xyParam = null;
        this.windowParam = null;
        this.list_aorbParam = new ArrayList();
        PopupviewXyBinding inflate = PopupviewXyBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        XYViewModel xYViewModel = (XYViewModel) ContextUtil.getAppViewModel(XYViewModel.class);
        if (xYViewModel != null) {
            xYViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$PtWatuQ5Zim6t1lArG6sjWPAXaw
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    XYPopupView.this.lambda$new$0$XYPopupView((XYParam) obj);
                }
            });
        }
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null) {
            final PopupviewXyBinding popupviewXyBinding = this.binding;
            Objects.requireNonNull(popupviewXyBinding);
            utilityViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.xy.-$$Lambda$_0QeRX0vch7CFVSHbB1IMNlAUx4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PopupviewXyBinding.this.setUtilityParam((UtilityParam) obj);
                }
            });
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(40, MessageID.MSG_XY_SOURCE_A).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$ElNprMDCY9uAG8i_3cjG_lrT-bY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    XYPopupView.this.lambda$new$1$XYPopupView(obj);
                }
            });
            syncDataViewModel.get(40, MessageID.MSG_XY_SOURCE_B).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$hSaIjz2kkRcKM2qFYPOMKnpt7t8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    XYPopupView.this.lambda$new$2$XYPopupView(obj);
                }
            });
            syncDataViewModel.get(40, MessageID.MSG_XY_SOURCE_C).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$7PlFLWEr40EamUde756DPQw_LeU
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    XYPopupView.this.lambda$new$3$XYPopupView(obj);
                }
            });
        }
        initPopWindow();
    }

    public /* synthetic */ void lambda$new$0$XYPopupView(XYParam xYParam) {
        this.xyParam = xYParam;
        this.binding.setXyParam(xYParam);
    }

    public /* synthetic */ void lambda$new$1$XYPopupView(Object obj) {
        XYParam xYParam;
        ServiceEnum.Chan chanFromValue1;
        if (this.windowParam == null || (xYParam = this.xyParam) == null || (chanFromValue1 = ServiceEnum.getChanFromValue1(xYParam.getSourceA().getValue().intValue())) == null) {
            return;
        }
        this.windowParam.setSource1(chanFromValue1);
    }

    public /* synthetic */ void lambda$new$2$XYPopupView(Object obj) {
        XYParam xYParam;
        ServiceEnum.Chan chanFromValue1;
        if (this.windowParam == null || (xYParam = this.xyParam) == null || (chanFromValue1 = ServiceEnum.getChanFromValue1(xYParam.getSourceB().getValue().intValue())) == null) {
            return;
        }
        this.windowParam.setSource2(chanFromValue1);
    }

    public /* synthetic */ void lambda$new$3$XYPopupView(Object obj) {
        XYParam xYParam;
        ServiceEnum.Chan chanFromValue1;
        if (this.windowParam == null || (xYParam = this.xyParam) == null || (chanFromValue1 = ServiceEnum.getChanFromValue1(xYParam.getSourceC().getValue().intValue())) == null) {
            return;
        }
        this.windowParam.setSource3(chanFromValue1);
    }

    private void initPopWindow() {
        ViewUtil.setSwitchButton(this.binding.settingADVSwitchButton);
        ViewUtil.setSwitchButton(this.binding.autoCompressionSwitchButton);
        this.binding.setGridFullMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        this.binding.setGridHalfMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        this.binding.setGridNoneMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        this.binding.settingADVSwitchButton.setOnCheckedChangeListener(this);
        this.binding.autoCompressionSwitchButton.setOnCheckedChangeListener(this);
        this.binding.gridTypeRadioGroup.setOnCheckedChangeListener(this);
        this.binding.afterglowSeekBar.setOnSeekBarChangeListener(this);
        this.binding.afterglowInframeSeekBar.setOnSeekBarChangeListener(this);
        this.binding.waveformSizeSeekBar.setOnSeekBarChangeListener(this);
        this.binding.intensitySeekBar.setOnSeekBarChangeListener(this);
        this.binding.samplerateSeekBar.setOnSeekBarChangeListener(this);
        this.binding.sourceASpinner.setOnClickListener(this);
        this.binding.sourceBSpinner.setOnClickListener(this);
        setWindowParam(null);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.sourceASpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceBSpinner, 0, false, "", 2));
        this.aorBManager = null;
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.xy.XYPopupView.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                showKey(XYPopupView.this.context, ((AorBParam) XYPopupView.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) XYPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                showKey(XYPopupView.this.context, ((AorBParam) XYPopupView.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) XYPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$1PMkPCgikMSIslAX_4_xTVgjjJI
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        XYPopupView.this.lambda$initPopWindow$6$XYPopupView((KeyEvent) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$initPopWindow$6$XYPopupView(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        SpinnerAdapter spinnerAdapter;
        if (!PopupViewManager.getInstance().isShowing(XYPopupView.class) || (popupSpinner = this.popupSpinner) == null || (spinnerAdapter = this.spinnerAdapter) == null) {
            return;
        }
        this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, popupSpinner, this.mappingObjects, spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$jTYZ0nWe0L7RH0v4YGRgMnr52lI
            @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
            public final void onCall(KeyboardPopupView keyboardPopupView) {
                XYPopupView.this.lambda$initPopWindow$4$XYPopupView(keyboardPopupView);
            }
        }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$xZ5idq6dPKjQB0D1cJ6xoyxhQKA
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
            public final void onCall(int i, MappingObject mappingObject) {
                XYPopupView.this.lambda$initPopWindow$5$XYPopupView(i, mappingObject);
            }
        });
    }

    public /* synthetic */ void lambda$initPopWindow$4$XYPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$initPopWindow$5$XYPopupView(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        int id = view.getId();
        if (id == R.id.source_a_spinner) {
            selectSourceX(mappingObject);
        } else if (id != R.id.source_b_spinner) {
        } else {
            selectSourceY(mappingObject);
        }
    }

    public void setWindowParam(WindowParam windowParam) {
        this.windowParam = windowParam;
        this.binding.setWindowParam(windowParam);
    }

    public WindowParam getWindowParam() {
        return this.windowParam;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        XYParam xYParam;
        int id = compoundButton.getId();
        if (compoundButton.isPressed() && (xYParam = this.xyParam) != null) {
            if (id == R.id.settingADV_switchButton) {
                xYParam.getAdvSetting().save(Boolean.valueOf(z));
            } else if (id == R.id.autoCompression_switchButton) {
                xYParam.getAutoCompression().save(Boolean.valueOf(z));
            }
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        XYParam xYParam = this.xyParam;
        if (xYParam == null) {
            return;
        }
        if (i == R.id.full_radio_button) {
            xYParam.getGrids().save(Integer.valueOf(ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        } else if (i == R.id.half_radio_button) {
            xYParam.getGrids().save(Integer.valueOf(ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        } else if (i == R.id.none_radio_button) {
            xYParam.getGrids().save(Integer.valueOf(ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        }
    }

    @Override // android.widget.SeekBar.OnSeekBarChangeListener
    public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
        XYParam xYParam;
        int id = seekBar.getId();
        if (z && (xYParam = this.xyParam) != null) {
            if (id == R.id.afterglow_seek_bar) {
                xYParam.getPersistTime().save(Integer.valueOf(i));
            } else if (id == R.id.afterglow_inframe_seek_bar) {
                xYParam.getFramePersist().save(Integer.valueOf(i));
            } else if (id == R.id.waveform_size_seek_bar) {
                xYParam.getWaveWidth().save(Integer.valueOf(i));
            } else if (id == R.id.intensity_seek_bar) {
                xYParam.getWaveIntensity().save(Integer.valueOf(i));
            } else if (id == R.id.samplerate_seek_bar) {
                xYParam.getCompressionRatio().save(Integer.valueOf(i));
            }
        }
    }

    private void selectSourceX(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            ViewUtil.setState(this.windowParam.getSource1(), this.windowParam.getSource2(), false);
            this.windowParam.setSource1(chanFromValue1);
            XYParam xYParam = this.xyParam;
            if (xYParam != null) {
                xYParam.getSourceA().save(Integer.valueOf(mappingObject.getValue()));
            }
            ((CursorSettingPopupView) PopupViewManager.getInstance().get(CursorSettingPopupView.class)).param.setSourceA(chanFromValue1);
            ViewUtil.setState(this.windowParam.getSource1(), this.windowParam.getSource2(), true);
        }
    }

    private void selectSourceY(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            ViewUtil.setState(this.windowParam.getSource1(), this.windowParam.getSource2(), false);
            this.windowParam.setSource2(chanFromValue1);
            XYParam xYParam = this.xyParam;
            if (xYParam != null) {
                xYParam.getSourceB().save(Integer.valueOf(mappingObject.getValue()));
            }
            ((CursorSettingPopupView) PopupViewManager.getInstance().get(CursorSettingPopupView.class)).param.setSourceB(chanFromValue1);
            ViewUtil.setState(this.windowParam.getSource1(), this.windowParam.getSource2(), true);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (this.windowParam == null) {
            return;
        }
        if (id == R.id.source_a_spinner) {
            SparseArrayCompat<Boolean> columnState = StateManager.INSTANCE.getColumnState(ServiceEnum.WindowType.WIN_XY, 2, this.windowParam.getSource2().value1 - ServiceEnum.Chan.chan1.value1);
            ViewUtil.showStateChanSpinner(getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_chan_list)), columnState, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$4r-uB5VgIsGF-hzkNeEKcnRjV-Q
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    XYPopupView.this.lambda$onClick$7$XYPopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$scIQpbWsu-at-5juRnc3NuNHmIE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    XYPopupView.this.lambda$onClick$8$XYPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.source_b_spinner) {
            SparseArrayCompat<Boolean> source2State = StateManager.INSTANCE.getSource2State(ServiceEnum.WindowType.WIN_XY, 2, this.windowParam.getSource1().value1 - ServiceEnum.Chan.chan1.value1);
            ViewUtil.showStateChanSpinner(getAnchor(), view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_chan_list)), source2State, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$kAoyGiZXMSKxZiLqZOcdE6z4im8
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    XYPopupView.this.lambda$onClick$9$XYPopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.xy.-$$Lambda$XYPopupView$SK_zFEtqhiGL9_djqVqvamCVW2o
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    XYPopupView.this.lambda$onClick$10$XYPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$7$XYPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$XYPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceX(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$XYPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$XYPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceY(mappingObject);
    }
}
