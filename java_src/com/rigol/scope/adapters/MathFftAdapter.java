package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.AdapterMathFftBinding;
import com.rigol.scope.databinding.PopupviewMathBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ScaleNumUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.save.SavePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MathFftAdapter extends RecyclerView.Adapter<MathFftHolder> implements AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterMathFftBinding binding;
    private View clickedView;
    private Context context;
    private MathPopupView.ViewPagerAdapter.ViewPagerHolder holder;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private MathParam param;
    private PopupSpinner popupSpinner;
    private PopupviewMathBinding popupviewMathBinding;
    private int serviceId;
    private SpinnerAdapter spinnerAdapter;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private boolean isNowView = false;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public boolean isMove() {
        return this.isMove;
    }

    public void setMove(boolean z) {
        this.isMove = z;
        this.isNowView = z;
    }

    public MathParam getParam() {
        return this.param;
    }

    public MathFftAdapter(Context context, View view, MathParam mathParam, PopupviewMathBinding popupviewMathBinding, MathPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = mathParam;
        this.context = context;
        this.serviceId = mathParam.getServiceId();
        this.anchorView = view;
        this.popupviewMathBinding = popupviewMathBinding;
        this.holder = viewPagerHolder;
        onCreateViewHolder((ViewGroup) popupviewMathBinding.viewPager, 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MathFftHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterMathFftBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.fftCenterEditText, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.fftSpanEditText, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.fftStartEditText, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.fftEndEditText, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.scaleEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.offsetEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.peakNumberEditText, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.thresholdEditText, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.excursionEditText, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceASpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.windowSpinner, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.MathFftAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(MathFftAdapter.this.context, ((AorBParam) MathFftAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) MathFftAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(MathFftAdapter.this.context, ((AorBParam) MathFftAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) MathFftAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.fftCenterEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.fftSpanEditText, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$M2N7MPwDrUMOjsxqexs_HRuqnHo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathFftAdapter.this.lambda$onCreateViewHolder$2$MathFftAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new MathFftHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$MathFftAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MathPopupView.class) && this.holder.getLayoutPosition() == this.popupviewMathBinding.tabs.getSelectedTabPosition() && this.isNowView) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$UBUdua5MpD9X12yVmq5ZOxdXoZc
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.lambda$onCreateViewHolder$0$MathFftAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$J5Yu5YMTQ6Ng6WlPy6-ehkNgOGA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MathFftAdapter.this.lambda$onCreateViewHolder$1$MathFftAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$MathFftAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$MathFftAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.sourceA_spinner) {
            selectSourceA(mappingObject);
        } else if (this.clickedView.getId() == R.id.window_spinner) {
            selectWindow(i);
        }
    }

    private void selectSourceA(MappingObject mappingObject) {
        if (this.param != null) {
            this.param.saveSourceFft(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MathFftHolder mathFftHolder, int i) {
        ShowMathFft();
        mathFftHolder.binding.executePendingBindings();
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.excursion_edit_text /* 2131362854 */:
                this.param.fftPeakExcursionRoll(keyEvent, z);
                return;
            case R.id.fftCenter_edit_text /* 2131362931 */:
                this.param.fftCenterRoll(keyEvent, z);
                return;
            case R.id.fftEnd_edit_text /* 2131362933 */:
                this.param.fftEndRoll(keyEvent, z);
                return;
            case R.id.fftSpan_edit_text /* 2131362935 */:
                this.param.fftSpanRoll(keyEvent, z);
                return;
            case R.id.fftStart_edit_text /* 2131362937 */:
                this.param.fftStartRoll(keyEvent, z);
                return;
            case R.id.offset_edit_text /* 2131363501 */:
                if (z) {
                    fftOffsetUp();
                    return;
                } else {
                    fftOffsetDown();
                    return;
                }
            case R.id.peak_number_edit_text /* 2131363559 */:
                this.param.fftPeakNumRoll(keyEvent, z);
                return;
            case R.id.scale_edit_text /* 2131363795 */:
                if (z) {
                    fftScaleDown();
                    return;
                } else {
                    fftScaleUp();
                    return;
                }
            case R.id.threshold_edit_text /* 2131364080 */:
                this.param.fftPeakThresholdRoll(keyEvent, z);
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
            case R.id.excursion_edit_text /* 2131362854 */:
                this.param.fftPeakExcursionReset();
                return;
            case R.id.fftCenter_edit_text /* 2131362931 */:
                this.param.fftCenterReset();
                return;
            case R.id.fftEnd_edit_text /* 2131362933 */:
                this.param.fftEndReset();
                return;
            case R.id.fftSpan_edit_text /* 2131362935 */:
                this.param.fftSpanReset();
                return;
            case R.id.fftStart_edit_text /* 2131362937 */:
                this.param.fftStartReset();
                return;
            case R.id.offset_edit_text /* 2131363501 */:
                MathParam mathParam = this.param;
                mathParam.saveFftOffset(this.aorBManager.getLongDef(mathParam.getFftOffsetAttr()));
                return;
            case R.id.peak_number_edit_text /* 2131363559 */:
                this.param.fftPeakNumReset();
                return;
            case R.id.scale_edit_text /* 2131363795 */:
                MathParam mathParam2 = this.param;
                mathParam2.saveFftScale(this.aorBManager.getLongDef(mathParam2.getFftScaleAttr()));
                return;
            case R.id.threshold_edit_text /* 2131364080 */:
                this.param.fftPeakThresholdReset();
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class MathFftHolder extends RecyclerView.ViewHolder {
        private AdapterMathFftBinding binding;

        public MathFftHolder(AdapterMathFftBinding adapterMathFftBinding) {
            super(adapterMathFftBinding.getRoot());
            this.binding = adapterMathFftBinding;
        }
    }

    public void ShowMathFft() {
        ViewUtil.setSwitchButton(this.binding.colorGradeSwitch);
        ViewUtil.setSwitchButton(this.binding.peakSearchSwitch);
        ViewUtil.setSwitchButton(R.array.msg_math_wave_type, this.binding.waveTypeSwitch);
        ViewUtil.setSwitchButton(this.binding.labelSwitch);
        this.binding.setSPanCenterMapping(ViewUtil.getMappingObject(R.array.msg_math_fft_x_type, ServiceEnum.FftxType.fft_span_center.value1));
        this.binding.setStartEndMapping(ViewUtil.getMappingObject(R.array.msg_math_fft_x_type, ServiceEnum.FftxType.fft_start_end.value1));
        this.binding.setDbMapping(ViewUtil.getMappingObject(R.array.msg_math_fft_s32unit, ServiceEnum.fftSpecUnit.fft_spec_db.value1));
        this.binding.setVrmsMapping(ViewUtil.getMappingObject(R.array.msg_math_fft_s32unit, ServiceEnum.fftSpecUnit.fft_spec_rms.value1));
        this.binding.setAmpOrderMapping(ViewUtil.getMappingObject(R.array.msg_math_fft_peak_tabelorder, ServiceEnum.enPeakOrder.fft_peak_AmpOrder.value1));
        this.binding.setFreqOrderMapping(ViewUtil.getMappingObject(R.array.msg_math_fft_peak_tabelorder, ServiceEnum.enPeakOrder.fft_peak_FreqOrder.value1));
        this.binding.setGridFullMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        this.binding.setGridHalfMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        this.binding.setGridNoneMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        this.binding.setParam(this.param);
        this.binding.sourceASpinner.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$Vm0c_akse3uCHlLNlPbmij29TkA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$5$MathFftAdapter(view);
            }
        });
        this.binding.spanCenterRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$Kv90O_qgN8yl6vlgRnW1OcLXdcg
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$6$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.startEndRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$18m38dQtoHssv9wnsCwsYHz1gc0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$7$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.fftSpanEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$MUy1O5dtCXW_JSYD2iaURFiYSMQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$8$MathFftAdapter(view);
            }
        });
        this.binding.fftCenterEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$th3p4h6J7z28vBfcFkiGcSkAWqQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$9$MathFftAdapter(view);
            }
        });
        this.binding.fftStartEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$i1tbkZnj85eqniKAHVzgG2L--rA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$10$MathFftAdapter(view);
            }
        });
        this.binding.fftEndEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$tq0voVAFY1lr5OEjWXpGBzn3two
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$11$MathFftAdapter(view);
            }
        });
        this.binding.dbRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$fppSDkrgdQY42b1yQg5XiIkEV4I
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$12$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.vrmsRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$pwfr5Zeh1E_m0LBFu6BUm7FcCEU
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$13$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.windowSpinner.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$ORg_hSD876gRgtVscNJwm9GrjEQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$16$MathFftAdapter(view);
            }
        });
        this.binding.offsetEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$BD6sC4TVVQgC1M2UjQ9G_uFeKu8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$17$MathFftAdapter(view);
            }
        });
        this.binding.scaleEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$tyOHV9wA1lJpCA4tWvcQoFn8f6M
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$18$MathFftAdapter(view);
            }
        });
        this.binding.mainScaleVertical.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$HWIPWZu81lVK1cDIgFDf8fDZNLM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$19$MathFftAdapter(view);
            }
        });
        this.binding.mainScaleNomal.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$kk65Re0uCARbn1qaADICwhggccM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$20$MathFftAdapter(view);
            }
        });
        this.binding.mathOffsetUp.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$tHyzbXO0BAqCAmmTDaDnKq91Pds
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$21$MathFftAdapter(view);
            }
        });
        this.binding.mathOffsetDown.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$XU5p3AuoyiDDR3EOIXERhqSUG28
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$22$MathFftAdapter(view);
            }
        });
        this.binding.autoSettingBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$dpqjd7bQh4zb9L9l3PCFcwbkRtQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$23$MathFftAdapter(view);
            }
        });
        this.binding.waveTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$X4AdISx7FZG-1-BhSTZXMcSG190
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$24$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.labelSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$oVTi42jQxCRnej8t0jTxMAxMEcE
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$25$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.labelEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$5CRPweDwmx6CYWHqIayGdLx2ZoY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$27$MathFftAdapter(view);
            }
        });
        this.binding.colorGradeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$M6MaResddyuiPgBplp_qDsq8NbE
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$28$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.colorGradeReset.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$DAHcqzA1OBx-MSNzb0UYa-xdLFw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$29$MathFftAdapter(view);
            }
        });
        this.binding.peakSearchTitle.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$WghOZdwCsaAEtlLp5aZ1GBfpRno
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$30$MathFftAdapter(view);
            }
        });
        this.binding.peakSearchSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$6wPXzJccCg_9aFE262P2FtYXRio
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$31$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.peakNumberEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$CmghKxvR69LCyDFyny8ARAXhWFs
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$32$MathFftAdapter(view);
            }
        });
        this.binding.thresholdEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$NUlh6cjkQPd4ks4x59bfvWWuizk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$33$MathFftAdapter(view);
            }
        });
        this.binding.excursionEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$Dzb2_iAwlCY3c-3V-xGTLwUQzAc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$34$MathFftAdapter(view);
            }
        });
        this.binding.AmpRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$QSxP7tqdi8kM8WL8DSGEeEzu34o
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$35$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.FreqRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$WqUq_HeLOwRg64d2PoNJqPsWGN8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$36$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.exportBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$vZv_EbxsiZ69TlkxIZOumHq4Wss
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFftAdapter.this.lambda$ShowMathFft$37$MathFftAdapter(view);
            }
        });
        this.binding.fullRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$CMCg_wXyyn-zB61e9g8SGF2HNik
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$38$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.halfRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$2FDs9BgkkUT3g8cTUd-DPKjzM1Y
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$39$MathFftAdapter(compoundButton, z);
            }
        });
        this.binding.noneRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$P7CElq3e4YpGevpTggta3gGhNG8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFftAdapter.this.lambda$ShowMathFft$40$MathFftAdapter(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$ShowMathFft$5$MathFftAdapter(View view) {
        MathParam mathParam = this.param;
        ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(mathParam.getSpinnerList(mathParam.getServiceId(), R.array.msg_math_fft_s32src)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$dGkmjMQBNleJd1Y2AZ363d09bCg
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                MathFftAdapter.this.lambda$ShowMathFft$3$MathFftAdapter(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$mUA4RDce6AMXKEEk42Sx5kB_b3o
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                MathFftAdapter.this.lambda$ShowMathFft$4$MathFftAdapter(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$ShowMathFft$3$MathFftAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$ShowMathFft$4$MathFftAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$ShowMathFft$6$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.aorBManager.set_RadioButton(0, 1);
            this.param.saveFftXType(ServiceEnum.FftxType.fft_span_center);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$7$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.aorBManager.set_RadioButton(2, 3);
            this.param.saveFftXType(ServiceEnum.FftxType.fft_start_end);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$8$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readFftSpanAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFftFreqUnit(), this.param.getFftSpanAttr().getMaxLongValue(), this.param.getFftSpanAttr().getMinLongValue(), this.param.getFftSpanAttr().getDefLongValue(), this.param.getFftSpan(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.saveFftSpan(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$9$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readFftCenterAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFftFreqUnit(), this.param.getFftCenterAttr().getMaxLongValue(), this.param.getFftCenterAttr().getMinLongValue(), this.param.getFftCenterAttr().getDefLongValue(), this.param.getFftCenter(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.saveFftCenter(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$10$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readFftStartAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFftFreqUnit(), this.param.getFftStartAttr().getMaxLongValue(), this.param.getFftStartAttr().getMinLongValue(), this.param.getFftStartAttr().getDefLongValue(), this.param.getFftStart(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.saveFftStart(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$11$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readFftEndAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFftFreqUnit(), this.param.getFftEndAttr().getMaxLongValue(), this.param.getFftEndAttr().getMinLongValue(), this.param.getFftEndAttr().getDefLongValue(), this.param.getFftEnd(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.5
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.saveFftEnd(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$12$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveFftUnit(ServiceEnum.fftSpecUnit.fft_spec_db);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$13$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveFftUnit(ServiceEnum.fftSpecUnit.fft_spec_rms);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$16$MathFftAdapter(View view) {
        MathParam mathParam = this.param;
        ViewUtil.showSpinner(this.anchorView, view, mathParam.getSpinnerList(mathParam.getServiceId(), R.array.msg_math_fft_s32window), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$wSr64zp5ASwGwYPiIbjI_xuHBOQ
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                MathFftAdapter.this.lambda$ShowMathFft$14$MathFftAdapter(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$bU9SoHnHXw6G2cltJeqjdfFtvuw
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                MathFftAdapter.this.lambda$ShowMathFft$15$MathFftAdapter(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$ShowMathFft$14$MathFftAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$ShowMathFft$15$MathFftAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectWindow(i);
    }

    public /* synthetic */ void lambda$ShowMathFft$17$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readFftOffsetAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnitIndex(), this.param.getFftOffsetAttr().getMaxLongValue(), this.param.getFftOffsetAttr().getMinLongValue(), this.param.getFftOffsetAttr().getDefLongValue(), this.param.getFftOffset(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.6
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.saveFftOffset(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$18$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readFftScaleAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFftUnitIndex() == ServiceEnum.fftSpecUnit.fft_spec_rms ? this.param.getUnitIndex() : ServiceEnum.Unit.Unit_db, this.param.getFftScaleAttr().getMaxLongValue(), this.param.getFftScaleAttr().getMinLongValue(), this.param.getFftScaleAttr().getDefLongValue(), this.param.getFftScale(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.7
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.saveFftScale(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$19$MathFftAdapter(View view) {
        fftScaleUp();
    }

    public /* synthetic */ void lambda$ShowMathFft$20$MathFftAdapter(View view) {
        fftScaleDown();
    }

    public /* synthetic */ void lambda$ShowMathFft$21$MathFftAdapter(View view) {
        fftOffsetUp();
    }

    public /* synthetic */ void lambda$ShowMathFft$22$MathFftAdapter(View view) {
        fftOffsetDown();
    }

    public /* synthetic */ void lambda$ShowMathFft$23$MathFftAdapter(View view) {
        API.getInstance().UI_PostBool(this.serviceId, MessageID.MSG_MATH_AUTO_SCALE, true);
    }

    public /* synthetic */ void lambda$ShowMathFft$24$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Zoom);
        } else {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Main);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$25$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        this.param.saveLabel(z);
    }

    public /* synthetic */ void lambda$ShowMathFft$27$MathFftAdapter(View view) {
        ViewUtil.showPinyinKeyboard(this.context, this.anchorView, view, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFftAdapter$kMCVIwgwMAC3yDJDXBDFtVGxoMg
            @Override // com.rigol.pinyinkeyboard.ExternalInterface
            public final void resultShow(String str) {
                MathFftAdapter.this.lambda$ShowMathFft$26$MathFftAdapter(str);
            }
        });
    }

    public /* synthetic */ void lambda$ShowMathFft$26$MathFftAdapter(String str) {
        this.param.saveLableString(str);
    }

    public /* synthetic */ void lambda$ShowMathFft$28$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.saveColorGrade(z);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$29$MathFftAdapter(View view) {
        API.getInstance().UI_PostBool(this.serviceId, MessageID.MSG_MATH_COLOR_RESET, true);
    }

    public /* synthetic */ void lambda$ShowMathFft$30$MathFftAdapter(View view) {
        MathParam mathParam = this.param;
        mathParam.setShowPeakSetting(!mathParam.isShowPeakSetting());
    }

    public /* synthetic */ void lambda$ShowMathFft$31$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.savePeakSearch(z);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$32$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readPeakNumAttr();
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_number, this.param.getPeakNumAttr().getMaxIntValue(), this.param.getPeakNumAttr().getMinIntValue(), this.param.getPeakNumAttr().getDefIntValue(), this.param.getPeakNum(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.8
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.savePeakNum(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$33$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readPeakThresholdAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnitIndex(), this.param.getPeakThresholdAttr().getMaxLongValue(), this.param.getPeakThresholdAttr().getMinLongValue(), this.param.getPeakThresholdAttr().getDefLongValue(), this.param.getPeakThreshold(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.9
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.savePeakThreshold(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$34$MathFftAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readPeakExcursionAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFftUnitIndex() == ServiceEnum.fftSpecUnit.fft_spec_rms ? this.param.getUnitIndex() : ServiceEnum.Unit.Unit_db, this.param.getPeakExcursionAttr().getMaxLongValue(), this.param.getPeakExcursionAttr().getMinLongValue(), this.param.getPeakExcursionAttr().getDefLongValue(), this.param.getPeakExcursion(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFftAdapter.10
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFftAdapter.this.param.savePeakExcursion(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFftAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$35$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveFftPeakOrder(ServiceEnum.enPeakOrder.fft_peak_AmpOrder);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$36$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveFftPeakOrder(ServiceEnum.enPeakOrder.fft_peak_FreqOrder);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$37$MathFftAdapter(View view) {
        StorageSaveParam value;
        API.getInstance().UI_PostBool(this.param.getServiceId(), MessageID.MSG_MATH_FFT_PEAK_EXPORT, true);
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel != null && (value = storageViewModel.getSaveLiveData().getValue()) != null) {
            value.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_FFT);
            value.saveFileType(ServiceEnum.enFileType.FILETYPE_CSV.value1);
        }
        PopupViewManager.getInstance().toggle(SavePopupView.class);
    }

    public /* synthetic */ void lambda$ShowMathFft$38$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_FULL);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$39$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_HALF);
        }
    }

    public /* synthetic */ void lambda$ShowMathFft$40$MathFftAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_NONE);
        }
    }

    private void selectWindow(int i) {
        MathParam mathParam = this.param;
        if (mathParam != null) {
            mathParam.saveFftWindow(ServiceEnum.getfftWindowFromValue1(i));
        }
    }

    private void fftScaleUp() {
        long fftScale = this.param.getFftScale();
        this.param.readFftScaleAttr();
        if (fftScale == this.param.getFftScaleAttr().getMaxLongValue()) {
            return;
        }
        this.param.saveFftScale(ScaleNumUtil.getPlusNum(fftScale, 1.0f));
    }

    private void fftScaleDown() {
        this.param.saveFftScale(ScaleNumUtil.getMinusNum(this.param.getFftScale(), 1.0f));
    }

    private void fftOffsetUp() {
        long fftScale = this.param.getFftScale();
        long fftOffset = this.param.getFftOffset();
        long j = (fftScale * 40) / 1000;
        if (j <= 0) {
            j = 1;
        }
        this.param.saveFftOffset(fftOffset + j);
    }

    private void fftOffsetDown() {
        long fftScale = this.param.getFftScale();
        long fftOffset = this.param.getFftOffset();
        long j = (fftScale * 40) / 1000;
        if (j <= 0) {
            j = 1;
        }
        this.param.saveFftOffset(fftOffset - j);
    }
}
