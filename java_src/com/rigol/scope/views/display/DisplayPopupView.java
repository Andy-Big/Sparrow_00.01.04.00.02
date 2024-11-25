package com.rigol.scope.views.display;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.PopupviewDisplayBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public class DisplayPopupView extends BasePopupView implements CompoundButton.OnCheckedChangeListener {
    private AorBManager aorBManager;
    private final PopupviewDisplayBinding binding;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;

    public DisplayPopupView() {
        super((int) R.style.App_PopupWindow_Display);
        this.list_aorbParam = new ArrayList();
        PopupviewDisplayBinding inflate = PopupviewDisplayBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.setParam(this.displayParam);
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null) {
            final PopupviewDisplayBinding popupviewDisplayBinding = this.binding;
            Objects.requireNonNull(popupviewDisplayBinding);
            horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.display.-$$Lambda$ML1QVXDqAAyiYZxNxv7hda6ZoII
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PopupviewDisplayBinding.this.setHori((HorizontalParam) obj);
                }
            });
        }
        ViewUtil.setSwitchButton(this.binding.rulerSwitchButton);
        ViewUtil.setSwitchButton(this.binding.paletteSwitchButton);
        ViewUtil.setSwitchButton(this.binding.freezeSwitchButton);
        this.binding.rulerSwitchButton.setOnCheckedChangeListener(this);
        this.binding.paletteSwitchButton.setOnCheckedChangeListener(this);
        this.binding.freezeSwitchButton.setOnCheckedChangeListener(this);
        this.binding.setTypeVectorMapping(ViewUtil.getMappingObject(R.array.msg_display_type, ServiceEnum.EWaveFormat.FORMAT_IS_VECTOR.value1));
        this.binding.setTypeDptsMapping(ViewUtil.getMappingObject(R.array.msg_display_type, ServiceEnum.EWaveFormat.FORMAT_IS_DOTS.value1));
        this.binding.setGridFullMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        this.binding.setGridHalfMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        this.binding.setGridNoneMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        this.binding.vectorRadioButton.setOnCheckedChangeListener(this);
        this.binding.dotsRadioButton.setOnCheckedChangeListener(this);
        this.binding.fullRadioButton.setOnCheckedChangeListener(this);
        this.binding.halfRadioButton.setOnCheckedChangeListener(this);
        this.binding.noneRadioButton.setOnCheckedChangeListener(this);
        this.binding.persisTimeText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.display.-$$Lambda$DisplayPopupView$8FDFJXbph902JM7dfhv0xBTvwvE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DisplayPopupView.this.lambda$new$2$DisplayPopupView(view);
            }
        });
        this.binding.waveIntensitySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.views.display.DisplayPopupView.1
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                DisplayPopupView.this.displayParam.saveWaveIntensity(i);
            }
        });
        this.binding.gridIntensitySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.views.display.DisplayPopupView.2
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                DisplayPopupView.this.displayParam.saveGridIntensity(i);
            }
        });
        this.binding.popupViewBgAlphaSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.views.display.DisplayPopupView.3
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                DisplayPopupView.this.displayParam.saveWindowTransparency(i);
            }
        });
        this.binding.cViewBgAlphaSeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.views.display.DisplayPopupView.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                DisplayPopupView.this.displayParam.saveCursor(i);
                ViewUtil.getViewABkeyViewModel().viewpager_postion.setValue(Float.valueOf(i / 100.0f));
            }
        });
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.display.DisplayPopupView.5
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
            }
        };
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.persisTimeText, 0, false, "", 2));
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.display.-$$Lambda$DisplayPopupView$HvrDPPC261SKN-ZjWrzEP1_tpHg
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DisplayPopupView.this.lambda$new$5$DisplayPopupView((KeyEvent) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$new$2$DisplayPopupView(View view) {
        ViewUtil.showSpinner(this.anchor, this.binding.persisTimeText, ViewUtil.getList((int) R.array.msg_display_persistime), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.display.-$$Lambda$DisplayPopupView$w4HHaJdy-Y3mDoDpPQ3V4uUXj9g
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                DisplayPopupView.this.lambda$new$0$DisplayPopupView(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.display.-$$Lambda$DisplayPopupView$vwXIugNTMQp3zJhPhXxCKQZ77nc
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                DisplayPopupView.this.lambda$new$1$DisplayPopupView(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$new$0$DisplayPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$new$1$DisplayPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectPersisTime(mappingObject);
    }

    public /* synthetic */ void lambda$new$5$DisplayPopupView(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        if (!PopupViewManager.getInstance().isShowing(DisplayPopupView.class) || (popupSpinner = this.popupSpinner) == null) {
            return;
        }
        this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.display.-$$Lambda$DisplayPopupView$S-FoDDwkH_q80E2cOitGXbRaw5A
            @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
            public final void onCall(KeyboardPopupView keyboardPopupView) {
                DisplayPopupView.this.lambda$new$3$DisplayPopupView(keyboardPopupView);
            }
        }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.display.-$$Lambda$DisplayPopupView$F_EzLU-YsU9bXnwF6yWaqdhtbUc
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
            public final void onCall(int i, MappingObject mappingObject) {
                DisplayPopupView.this.lambda$new$4$DisplayPopupView(i, mappingObject);
            }
        });
    }

    public /* synthetic */ void lambda$new$3$DisplayPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$4$DisplayPopupView(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view != null && view.getId() == R.id.persis_time_text) {
            selectPersisTime(mappingObject);
        }
    }

    private void selectPersisTime(MappingObject mappingObject) {
        ServiceEnum.EWavePersis eWavePersisFromValue1 = ServiceEnum.getEWavePersisFromValue1(mappingObject.getValue());
        if (eWavePersisFromValue1 != null) {
            this.displayParam.savePersisTime(eWavePersisFromValue1);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            int id = compoundButton.getId();
            if (id == R.id.ruler_switch_button) {
                this.displayParam.saveRulerEnable(z);
            } else if (id == R.id.palette_switch_button) {
                this.displayParam.savePaletteEnable(z);
            } else if (id == R.id.freeze_switch_button) {
                this.displayParam.saveWaveFreeze(z);
            } else if (id == R.id.vector_radio_button) {
                if (z) {
                    this.displayParam.saveType(ServiceEnum.EWaveFormat.FORMAT_IS_VECTOR);
                }
            } else if (id == R.id.dots_radio_button) {
                if (z) {
                    this.displayParam.saveType(ServiceEnum.EWaveFormat.FORMAT_IS_DOTS);
                }
            } else if (id == R.id.full_radio_button) {
                if (z) {
                    this.displayParam.saveGridType(ServiceEnum.EWaveGrids.GRID_IS_FULL);
                }
            } else if (id == R.id.half_radio_button) {
                if (z) {
                    this.displayParam.saveGridType(ServiceEnum.EWaveGrids.GRID_IS_HALF);
                }
            } else if (id == R.id.none_radio_button && z) {
                this.displayParam.saveGridType(ServiceEnum.EWaveGrids.GRID_IS_NONE);
            }
        }
    }
}
