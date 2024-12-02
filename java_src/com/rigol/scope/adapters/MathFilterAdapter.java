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
import com.rigol.scope.databinding.AdapterMathFilterBindingImpl;
import com.rigol.scope.databinding.PopupviewMathBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MathFilterAdapter extends RecyclerView.Adapter<MathFilterHolder> implements AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterMathFilterBindingImpl binding;
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

    public MathFilterAdapter(Context context, View view, MathParam mathParam, PopupviewMathBinding popupviewMathBinding, MathPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = mathParam;
        this.context = context;
        this.serviceId = mathParam.getServiceId();
        this.anchorView = view;
        this.popupviewMathBinding = popupviewMathBinding;
        this.holder = viewPagerHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MathFilterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = (AdapterMathFilterBindingImpl) AdapterMathFilterBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.scaleEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.offsetEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.hpWcEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.lpWcEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.bpWc1EditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.bpWc2EditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.btWc1EditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.btWc2EditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceASpinner, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.MathFilterAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                MathFilterAdapter.this.aorBManager.showKey(MathFilterAdapter.this.context, ((AorBParam) MathFilterAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) MathFilterAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                MathFilterAdapter.this.aorBManager.showKey(MathFilterAdapter.this.context, ((AorBParam) MathFilterAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) MathFilterAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.scaleEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.offsetEditText, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$_7Na-5Ip42pZEKG9UwmPs4rW1wQ
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathFilterAdapter.this.lambda$onCreateViewHolder$2$MathFilterAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new MathFilterHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$MathFilterAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MathPopupView.class) && this.holder.getLayoutPosition() == this.popupviewMathBinding.tabs.getSelectedTabPosition() && this.isNowView) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$r_XOiipgtC0cgKc6jUiKR18ehgA
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.lambda$onCreateViewHolder$0$MathFilterAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$zWUPBE2SnoWssKeKKml9WPPO5ck
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MathFilterAdapter.this.lambda$onCreateViewHolder$1$MathFilterAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$MathFilterAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$MathFilterAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.sourceA_spinner) {
            selectSourceA(mappingObject);
        }
    }

    private void selectSourceA(MappingObject mappingObject) {
        if (this.param != null) {
            this.param.saveSourceArithA(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MathFilterHolder mathFilterHolder, int i) {
        showMathFilter();
        mathFilterHolder.binding.executePendingBindings();
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.bp_wc1_edit_text /* 2131362081 */:
                this.param.readBpFreq1Attr();
                MathParam mathParam = this.param;
                mathParam.saveBpFreq1(mathParam.getLongStep(mathParam.getBpFreq1(), this.param.getBpFreq1Attr(), z, keyEvent));
                return;
            case R.id.bp_wc2_edit_text /* 2131362083 */:
                this.param.readBpFreq2Attr();
                MathParam mathParam2 = this.param;
                mathParam2.saveBpFreq2(mathParam2.getLongStep(mathParam2.getBpFreq2(), this.param.getBpFreq2Attr(), z, keyEvent));
                return;
            case R.id.bt_wc1_edit_text /* 2131362085 */:
                this.param.readBtFreq1Attr();
                MathParam mathParam3 = this.param;
                mathParam3.saveBtFreq1(mathParam3.getLongStep(mathParam3.getBtFreq1(), this.param.getBtFreq1Attr(), z, keyEvent));
                return;
            case R.id.bt_wc2_edit_text /* 2131362087 */:
                this.param.readBtFreq2Attr();
                MathParam mathParam4 = this.param;
                mathParam4.saveBtFreq2(mathParam4.getLongStep(mathParam4.getBtFreq2(), this.param.getBtFreq2Attr(), z, keyEvent));
                return;
            case R.id.hp_wc_edit_text /* 2131363080 */:
                this.param.readHpFreqAttr();
                MathParam mathParam5 = this.param;
                mathParam5.saveHpFreq(mathParam5.getLongStep(mathParam5.getHpFreq(), this.param.getHpFreqAttr(), z, keyEvent));
                return;
            case R.id.lp_wc_edit_text /* 2131363346 */:
                this.param.readLpFreqAttr();
                MathParam mathParam6 = this.param;
                mathParam6.saveLpFreq(mathParam6.getLongStep(mathParam6.getLpFreq(), this.param.getLpFreqAttr(), z, keyEvent));
                return;
            case R.id.offset_edit_text /* 2131363501 */:
                this.param.offsetRoll(z);
                return;
            case R.id.scale_edit_text /* 2131363795 */:
                this.param.scaleRoll(z);
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
            case R.id.bp_wc1_edit_text /* 2131362081 */:
                this.param.readBpFreq1Attr();
                MathParam mathParam = this.param;
                mathParam.saveBpFreq1(mathParam.getLongDef(mathParam.getBpFreq1Attr()));
                return;
            case R.id.bp_wc2_edit_text /* 2131362083 */:
                this.param.readBpFreq2Attr();
                MathParam mathParam2 = this.param;
                mathParam2.saveBpFreq2(mathParam2.getLongDef(mathParam2.getBpFreq2Attr()));
                return;
            case R.id.bt_wc1_edit_text /* 2131362085 */:
                this.param.readBtFreq1Attr();
                MathParam mathParam3 = this.param;
                mathParam3.saveBtFreq1(mathParam3.getLongDef(mathParam3.getBtFreq1Attr()));
                return;
            case R.id.bt_wc2_edit_text /* 2131362087 */:
                this.param.readBtFreq2Attr();
                MathParam mathParam4 = this.param;
                mathParam4.saveBtFreq2(mathParam4.getLongDef(mathParam4.getBtFreq2Attr()));
                return;
            case R.id.hp_wc_edit_text /* 2131363080 */:
                this.param.readHpFreqAttr();
                MathParam mathParam5 = this.param;
                mathParam5.saveHpFreq(mathParam5.getLongDef(mathParam5.getHpFreqAttr()));
                return;
            case R.id.lp_wc_edit_text /* 2131363346 */:
                this.param.readLpFreqAttr();
                MathParam mathParam6 = this.param;
                mathParam6.saveLpFreq(mathParam6.getLongDef(mathParam6.getLpFreqAttr()));
                return;
            case R.id.offset_edit_text /* 2131363501 */:
                this.param.offsetReset();
                return;
            case R.id.scale_edit_text /* 2131363795 */:
                this.param.scaleReset();
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public static class MathFilterHolder extends RecyclerView.ViewHolder {
        private AdapterMathFilterBindingImpl binding;

        public MathFilterHolder(AdapterMathFilterBindingImpl adapterMathFilterBindingImpl) {
            super(adapterMathFilterBindingImpl.getRoot());
            this.binding = adapterMathFilterBindingImpl;
        }
    }

    public void showMathFilter() {
        ViewUtil.setSwitchButton(this.binding.labelSwitch);
        ViewUtil.setSwitchButton(this.binding.invertSwitch);
        ViewUtil.setSwitchButton(R.array.msg_math_wave_type, this.binding.waveTypeSwitch);
        this.binding.setParam(this.param);
        this.binding.setGndMapping(ViewUtil.getMappingObject(R.array.msg_math_expand, ServiceEnum.VertExpand.vert_expand_gnd.value1));
        this.binding.setCenterMapping(ViewUtil.getMappingObject(R.array.msg_math_expand, ServiceEnum.VertExpand.vert_expand_center.value1));
        this.binding.setGridFullMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        this.binding.setGridHalfMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        this.binding.setGridNoneMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        this.binding.lpWcEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$JrHmyVyAAGHIgPCPjyPNOCpCg-o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$3$MathFilterAdapter(view);
            }
        });
        this.binding.hpWcEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$OsTSrOlW2IeHDp26PD-LsT5XIMU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$4$MathFilterAdapter(view);
            }
        });
        this.binding.bpWc1EditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$el3Y02QnBJiUgoDO44QirysFEX4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$5$MathFilterAdapter(view);
            }
        });
        this.binding.bpWc2EditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$Ak3PUlXEGbtoJhubmL9n61lgHSU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$6$MathFilterAdapter(view);
            }
        });
        this.binding.btWc1EditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$hG7-zMiZiH8uu4PhbWJ5gUt0jmk
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$7$MathFilterAdapter(view);
            }
        });
        this.binding.btWc2EditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$bYrnkjCHkoAp7WcKMcdTw0tGAyM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$8$MathFilterAdapter(view);
            }
        });
        this.binding.sourceASpinner.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$Ao1hiKYdb93iaHl94uGMJCe03wA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$11$MathFilterAdapter(view);
            }
        });
        this.binding.offsetEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$WW1C19sTNIbm6J1YMeMqVNfCO08
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$12$MathFilterAdapter(view);
            }
        });
        this.binding.scaleEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$oLgLZjZblN7mIiGX6yE-qhSOHHI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$13$MathFilterAdapter(view);
            }
        });
        this.binding.mainScaleVertical.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$rwbYK4ArQfFTvo7aW6NE68iVm_4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$14$MathFilterAdapter(view);
            }
        });
        this.binding.mainScaleNomal.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$gthNRhFV0d25XFZjKOY3nXhhZvo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$15$MathFilterAdapter(view);
            }
        });
        this.binding.mathOffsetUp.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$-sUg55mGIXQRCI9mUAsdqwsnI8I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$16$MathFilterAdapter(view);
            }
        });
        this.binding.mathOffsetDown.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$h1ixKvjJJTZqZhrUHICiFM7Ove8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$17$MathFilterAdapter(view);
            }
        });
        this.binding.autoSettingBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$6swGzG5hueQ0amrU80EtQiLa5x0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$18$MathFilterAdapter(view);
            }
        });
        this.binding.waveTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$XRgQL7_rphfExsFSS2cYofnJjwU
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFilterAdapter.this.lambda$showMathFilter$19$MathFilterAdapter(compoundButton, z);
            }
        });
        this.binding.invertSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$DprOJYaypJ0Ig9fz12Qeb31UANg
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFilterAdapter.this.lambda$showMathFilter$20$MathFilterAdapter(compoundButton, z);
            }
        });
        this.binding.labelSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$-43r6A2s_q-IRMDOtKCAA--yrV0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFilterAdapter.this.lambda$showMathFilter$21$MathFilterAdapter(compoundButton, z);
            }
        });
        this.binding.labelEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$J6rIHtFJMnqPdR2N52d4HR_6N10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFilterAdapter.this.lambda$showMathFilter$23$MathFilterAdapter(view);
            }
        });
        this.binding.gndRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$9c4yKeFRu_91cy38pzmzMBQhrAM
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFilterAdapter.this.lambda$showMathFilter$24$MathFilterAdapter(compoundButton, z);
            }
        });
        this.binding.centerRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$GchvED0cb3tqvHQIpXmJ-9-dmR0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFilterAdapter.this.lambda$showMathFilter$25$MathFilterAdapter(compoundButton, z);
            }
        });
        this.binding.fullRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$Fq_9PW965ONbjuOagUBo1lgdvTg
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFilterAdapter.this.lambda$showMathFilter$26$MathFilterAdapter(compoundButton, z);
            }
        });
        this.binding.halfRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$HJMEKDCSUU56a9HdYjgZhJQkg6k
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFilterAdapter.this.lambda$showMathFilter$27$MathFilterAdapter(compoundButton, z);
            }
        });
        this.binding.noneRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$R2ATtS4urbty81xHFGPwiDB8qA8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFilterAdapter.this.lambda$showMathFilter$28$MathFilterAdapter(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$showMathFilter$3$MathFilterAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readLpFreqAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFilterUnit(), this.param.getLpFreqAttr().getMaxLongValue(), this.param.getLpFreqAttr().getMinLongValue(), this.param.getLpFreqAttr().getDefLongValue(), this.param.getLpFreq(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFilterAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFilterAdapter.this.param.saveLpFreq(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFilter$4$MathFilterAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readHpFreqAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFilterUnit(), this.param.getHpFreqAttr().getMaxLongValue(), this.param.getHpFreqAttr().getMinLongValue(), this.param.getHpFreqAttr().getDefLongValue(), this.param.getHpFreq(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFilterAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFilterAdapter.this.param.saveHpFreq(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFilter$5$MathFilterAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readBpFreq1Attr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFilterUnit(), this.param.getBpFreq1Attr().getMaxLongValue(), this.param.getBpFreq1Attr().getMinLongValue(), this.param.getBpFreq1Attr().getDefLongValue(), this.param.getBpFreq1(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFilterAdapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFilterAdapter.this.param.saveBpFreq1(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFilter$6$MathFilterAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readBpFreq2Attr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFilterUnit(), this.param.getBpFreq2Attr().getMaxLongValue(), this.param.getBpFreq2Attr().getMinLongValue(), this.param.getBpFreq2Attr().getDefLongValue(), this.param.getBpFreq2(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFilterAdapter.5
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFilterAdapter.this.param.saveBpFreq2(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFilter$7$MathFilterAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readBtFreq1Attr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFilterUnit(), this.param.getBtFreq1Attr().getMaxLongValue(), this.param.getBtFreq1Attr().getMinLongValue(), this.param.getBtFreq1Attr().getDefLongValue(), this.param.getBtFreq1(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFilterAdapter.6
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFilterAdapter.this.param.saveBtFreq1(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFilter$8$MathFilterAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readBtFreq2Attr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getFilterUnit(), this.param.getBtFreq2Attr().getMaxLongValue(), this.param.getBtFreq2Attr().getMinLongValue(), this.param.getBtFreq2Attr().getDefLongValue(), this.param.getBtFreq2(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFilterAdapter.7
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFilterAdapter.this.param.saveBtFreq2(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFilter$11$MathFilterAdapter(View view) {
        MathParam mathParam = this.param;
        ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(mathParam.getSpinnerList(mathParam.getServiceId(), R.array.msg_math_s32aritha)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$4G03mNv8cUWhmZV_t9kdEQ16xsU
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                MathFilterAdapter.this.lambda$showMathFilter$9$MathFilterAdapter(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$bGe0QWIKBlFg16XGBIOMiniz9co
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                MathFilterAdapter.this.lambda$showMathFilter$10$MathFilterAdapter(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$showMathFilter$9$MathFilterAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$showMathFilter$10$MathFilterAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$showMathFilter$12$MathFilterAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readAnaOffsetAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnitIndex(), this.param.getAnaOffsetAttr().getMaxLongValue(), this.param.getAnaOffsetAttr().getMinLongValue(), this.param.getAnaOffsetAttr().getDefLongValue(), this.param.getOffset(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFilterAdapter.8
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFilterAdapter.this.param.saveOffset(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFilter$13$MathFilterAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readAnaScaleAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnitIndex(), this.param.getAnaScaleAttr().getMaxLongValue(), this.param.getAnaScaleAttr().getMinLongValue(), this.param.getAnaScaleAttr().getDefLongValue(), this.param.getScale(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFilterAdapter.9
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFilterAdapter.this.param.saveScale(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFilterAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFilter$14$MathFilterAdapter(View view) {
        this.param.scaleUp();
    }

    public /* synthetic */ void lambda$showMathFilter$15$MathFilterAdapter(View view) {
        this.param.scaleDown();
    }

    public /* synthetic */ void lambda$showMathFilter$16$MathFilterAdapter(View view) {
        this.param.offsetUp();
    }

    public /* synthetic */ void lambda$showMathFilter$17$MathFilterAdapter(View view) {
        this.param.offsetDown();
    }

    public /* synthetic */ void lambda$showMathFilter$18$MathFilterAdapter(View view) {
        API.getInstance().UI_PostBool(this.serviceId, MessageID.MSG_MATH_AUTO_SCALE, true);
    }

    public /* synthetic */ void lambda$showMathFilter$19$MathFilterAdapter(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Zoom);
        } else {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Main);
        }
    }

    public /* synthetic */ void lambda$showMathFilter$20$MathFilterAdapter(CompoundButton compoundButton, boolean z) {
        this.param.saveInvert(z);
    }

    public /* synthetic */ void lambda$showMathFilter$21$MathFilterAdapter(CompoundButton compoundButton, boolean z) {
        this.param.saveLabel(z);
    }

    public /* synthetic */ void lambda$showMathFilter$23$MathFilterAdapter(View view) {
        ViewUtil.showPinyinKeyboard(this.context, this.anchorView, view, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFilterAdapter$mnoyoohZWVDqYQ-EfuEgdLJe32I
            @Override // com.rigol.pinyinkeyboard.ExternalInterface
            public final void resultShow(String str) {
                MathFilterAdapter.this.lambda$showMathFilter$22$MathFilterAdapter(str);
            }
        });
    }

    public /* synthetic */ void lambda$showMathFilter$22$MathFilterAdapter(String str) {
        this.param.saveLableString(str);
    }

    public /* synthetic */ void lambda$showMathFilter$24$MathFilterAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveExpand(ServiceEnum.VertExpand.vert_expand_gnd);
        }
    }

    public /* synthetic */ void lambda$showMathFilter$25$MathFilterAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveExpand(ServiceEnum.VertExpand.vert_expand_center);
        }
    }

    public /* synthetic */ void lambda$showMathFilter$26$MathFilterAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_FULL);
        }
    }

    public /* synthetic */ void lambda$showMathFilter$27$MathFilterAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_HALF);
        }
    }

    public /* synthetic */ void lambda$showMathFilter$28$MathFilterAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_NONE);
        }
    }
}
