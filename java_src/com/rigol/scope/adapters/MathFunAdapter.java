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
import com.rigol.scope.databinding.AdapterMathFunBinding;
import com.rigol.scope.databinding.AdapterMathFunBindingImpl;
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
public class MathFunAdapter extends RecyclerView.Adapter<MathFunHolder> implements AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterMathFunBinding binding;
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

    public MathFunAdapter(Context context, View view, MathParam mathParam, PopupviewMathBinding popupviewMathBinding, MathPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = mathParam;
        this.context = context;
        this.serviceId = mathParam.getServiceId();
        this.anchorView = view;
        this.popupviewMathBinding = popupviewMathBinding;
        this.holder = viewPagerHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MathFunHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterMathFunBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.scaleEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.offsetEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.paramAEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.paramBEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.biasEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.smoothEditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceASpinner, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.MathFunAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                MathFunAdapter.this.aorBManager.showKey(MathFunAdapter.this.context, ((AorBParam) MathFunAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) MathFunAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                MathFunAdapter.this.aorBManager.showKey(MathFunAdapter.this.context, ((AorBParam) MathFunAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) MathFunAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$NG1eprWjN37lK6WCT_wLGAwh2R4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathFunAdapter.this.lambda$onCreateViewHolder$2$MathFunAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new MathFunHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$MathFunAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MathPopupView.class) && this.holder.getLayoutPosition() == this.popupviewMathBinding.tabs.getSelectedTabPosition() && this.isNowView) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$GPHQ9xmNRdXV3lbW56029gIywjs
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFunAdapter.this.lambda$onCreateViewHolder$0$MathFunAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$eruW9h1emLrp8uJ9U4YHWIh89k0
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MathFunAdapter.this.lambda$onCreateViewHolder$1$MathFunAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$MathFunAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$MathFunAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.sourceA_spinner) {
            selectSourceA(mappingObject);
        }
    }

    private void selectSourceA(MappingObject mappingObject) {
        if (this.param != null) {
            this.param.saveSourceArithA(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MathFunHolder mathFunHolder, int i) {
        showMathFun();
        mathFunHolder.binding.executePendingBindings();
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.bias_edit_text /* 2131362036 */:
                MathParam mathParam = this.param;
                mathParam.saveIntgBias(mathParam.getLongStep(mathParam.getIntgBias(), this.param.getIntgBiasAttr(), z, keyEvent));
                return;
            case R.id.offset_edit_text /* 2131363501 */:
                this.param.offsetRoll(z);
                return;
            case R.id.param_a_edit_text /* 2131363536 */:
                MathParam mathParam2 = this.param;
                mathParam2.saveLineA(mathParam2.getLongStep(mathParam2.getLineA(), this.param.getLineAAttr(), z, keyEvent));
                return;
            case R.id.param_b_edit_text /* 2131363538 */:
                MathParam mathParam3 = this.param;
                mathParam3.saveLineB(mathParam3.getLongStep(mathParam3.getLineB(), this.param.getLineBAttr(), z, keyEvent));
                return;
            case R.id.scale_edit_text /* 2131363795 */:
                this.param.scaleRoll(z);
                return;
            case R.id.smooth_edit_text /* 2131363881 */:
                MathParam mathParam4 = this.param;
                mathParam4.saveDiffSmooth(mathParam4.getIntStep(mathParam4.getDiffSmooth(), this.param.getDiffSmoothAttr(), z, keyEvent));
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
            case R.id.bias_edit_text /* 2131362036 */:
                MathParam mathParam = this.param;
                mathParam.saveIntgBias(mathParam.getLongDef(mathParam.getIntgBiasAttr()));
                return;
            case R.id.offset_edit_text /* 2131363501 */:
                this.param.offsetReset();
                return;
            case R.id.param_a_edit_text /* 2131363536 */:
                MathParam mathParam2 = this.param;
                mathParam2.saveLineA(mathParam2.getLongDef(mathParam2.getLineAAttr()));
                return;
            case R.id.param_b_edit_text /* 2131363538 */:
                MathParam mathParam3 = this.param;
                mathParam3.saveLineB(mathParam3.getLongDef(mathParam3.getLineBAttr()));
                return;
            case R.id.scale_edit_text /* 2131363795 */:
                this.param.scaleReset();
                return;
            case R.id.smooth_edit_text /* 2131363881 */:
                MathParam mathParam4 = this.param;
                mathParam4.saveDiffSmooth(mathParam4.getIntDef(mathParam4.getDiffSmoothAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class MathFunHolder extends RecyclerView.ViewHolder {
        private AdapterMathFunBinding binding;

        public MathFunHolder(AdapterMathFunBinding adapterMathFunBinding) {
            super(adapterMathFunBinding.getRoot());
            this.binding = adapterMathFunBinding;
        }
    }

    public void showMathFun() {
        ViewUtil.setSwitchButton(this.binding.labelSwitch);
        ViewUtil.setSwitchButton(this.binding.invertSwitch);
        ViewUtil.setSwitchButton(R.array.msg_math_wave_type, this.binding.waveTypeSwitch);
        this.binding.setParam(this.param);
        this.binding.setGndMapping(ViewUtil.getMappingObject(R.array.msg_math_expand, ServiceEnum.VertExpand.vert_expand_gnd.value1));
        this.binding.setCenterMapping(ViewUtil.getMappingObject(R.array.msg_math_expand, ServiceEnum.VertExpand.vert_expand_center.value1));
        this.binding.setGridFullMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        this.binding.setGridHalfMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        this.binding.setGridNoneMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        this.binding.sourceASpinner.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$vz8rV8PVuyIwXqFEylpmSBN2TuQ
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$5$MathFunAdapter(view);
            }
        });
        this.binding.offsetEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$ypvA_b2Si_X99KUDedfHd6ylj6g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$6$MathFunAdapter(view);
            }
        });
        this.binding.scaleEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$2ZXC41j5aOv2-lWmcUZBlRfAfdY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$7$MathFunAdapter(view);
            }
        });
        this.binding.mainScaleVertical.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$0aphLa_aJZgq-aHoJKlX3b9w7Qg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$8$MathFunAdapter(view);
            }
        });
        this.binding.mainScaleNomal.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$GpG3tbMWkcNAkBTKMGywrZXwykU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$9$MathFunAdapter(view);
            }
        });
        this.binding.mathOffsetUp.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$a1bGeEighuGXmM-nErTe4557sDw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$10$MathFunAdapter(view);
            }
        });
        this.binding.mathOffsetDown.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$McrTgSQNdEnf4Hi8tC9op6jAeo0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$11$MathFunAdapter(view);
            }
        });
        this.binding.autoSettingBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$JUS5yuqvj_pjxZ3dkA-K3UxYxzM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$12$MathFunAdapter(view);
            }
        });
        this.binding.waveTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$2t1SysXGbGiAibkG3Xd1UZHATgA
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFunAdapter.this.lambda$showMathFun$13$MathFunAdapter(compoundButton, z);
            }
        });
        this.binding.invertSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$scL_-FW1QWURsGMt2WkTZrnA4eI
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFunAdapter.this.lambda$showMathFun$14$MathFunAdapter(compoundButton, z);
            }
        });
        this.binding.labelSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$IeGZAUZ0xdLXiGU4BJVxHWHh8Fc
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFunAdapter.this.lambda$showMathFun$15$MathFunAdapter(compoundButton, z);
            }
        });
        this.binding.labelEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$tvgT5aCpO_Fpa60RZbWpnGE_jfo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$17$MathFunAdapter(view);
            }
        });
        this.binding.paramAEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$EHA-hfdCSm1rprSFtjSA0_o9fIA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$18$MathFunAdapter(view);
            }
        });
        this.binding.paramBEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$J2GA_3y84gvNZLbwyLLbyeOKb1A
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$19$MathFunAdapter(view);
            }
        });
        this.binding.biasEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$qOVmf4M2MZ29Zl-g7xySPs4Y1WI
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$20$MathFunAdapter(view);
            }
        });
        this.binding.smoothEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$kh14UkUI1GIipNJwWnv9PFkf-b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathFunAdapter.this.lambda$showMathFun$21$MathFunAdapter(view);
            }
        });
        this.binding.gndRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$oLV3UTJcDbWrVE4AJWlh21aWEdk
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFunAdapter.this.lambda$showMathFun$22$MathFunAdapter(compoundButton, z);
            }
        });
        this.binding.centerRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$M5XIjg8m3sO47f-7Xd_JaCsmrvA
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFunAdapter.this.lambda$showMathFun$23$MathFunAdapter(compoundButton, z);
            }
        });
        this.binding.fullRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$5EbcS_4TUA-6bI0oPp-lsrUwsTc
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFunAdapter.this.lambda$showMathFun$24$MathFunAdapter(compoundButton, z);
            }
        });
        this.binding.halfRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$GdYKQwRCBRa8f0B45okxFf0_U00
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFunAdapter.this.lambda$showMathFun$25$MathFunAdapter(compoundButton, z);
            }
        });
        this.binding.noneRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$4BszRlGYKZ6EeoAF87br9F6_sHQ
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathFunAdapter.this.lambda$showMathFun$26$MathFunAdapter(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$showMathFun$5$MathFunAdapter(View view) {
        MathParam mathParam = this.param;
        ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(mathParam.getSpinnerList(mathParam.getServiceId(), R.array.msg_math_s32aritha)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$ZRMs1jaQ88dCyMO7SC1FOKVrfMc
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                MathFunAdapter.this.lambda$showMathFun$3$MathFunAdapter(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$EfxXHxy3zjA7kpsMqUYiS4oinpo
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                MathFunAdapter.this.lambda$showMathFun$4$MathFunAdapter(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$showMathFun$3$MathFunAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$showMathFun$4$MathFunAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$showMathFun$6$MathFunAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readAnaOffsetAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnitIndex(), this.param.getAnaOffsetAttr().getMaxLongValue(), this.param.getAnaOffsetAttr().getMinLongValue(), this.param.getAnaOffsetAttr().getDefLongValue(), this.param.getOffset(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFunAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFunAdapter.this.param.saveOffset(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFunAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFun$7$MathFunAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readAnaScaleAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnitIndex(), this.param.getAnaScaleAttr().getMaxLongValue(), this.param.getAnaScaleAttr().getMinLongValue(), this.param.getAnaScaleAttr().getDefLongValue(), this.param.getScale(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFunAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFunAdapter.this.param.saveScale(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFunAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFun$8$MathFunAdapter(View view) {
        this.param.scaleUp();
    }

    public /* synthetic */ void lambda$showMathFun$9$MathFunAdapter(View view) {
        this.param.scaleDown();
    }

    public /* synthetic */ void lambda$showMathFun$10$MathFunAdapter(View view) {
        this.param.offsetUp();
    }

    public /* synthetic */ void lambda$showMathFun$11$MathFunAdapter(View view) {
        this.param.offsetDown();
    }

    public /* synthetic */ void lambda$showMathFun$12$MathFunAdapter(View view) {
        API.getInstance().UI_PostBool(this.serviceId, MessageID.MSG_MATH_AUTO_SCALE, true);
    }

    public /* synthetic */ void lambda$showMathFun$13$MathFunAdapter(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Zoom);
        } else {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Main);
        }
    }

    public /* synthetic */ void lambda$showMathFun$14$MathFunAdapter(CompoundButton compoundButton, boolean z) {
        this.param.saveInvert(z);
    }

    public /* synthetic */ void lambda$showMathFun$15$MathFunAdapter(CompoundButton compoundButton, boolean z) {
        this.param.saveLabel(z);
    }

    public /* synthetic */ void lambda$showMathFun$17$MathFunAdapter(View view) {
        ViewUtil.showPinyinKeyboard(this.context, this.anchorView, view, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$MathFunAdapter$687_B67jQxf3yP0jLhCvxvfrzt0
            @Override // com.rigol.pinyinkeyboard.ExternalInterface
            public final void resultShow(String str) {
                MathFunAdapter.this.lambda$showMathFun$16$MathFunAdapter(str);
            }
        });
    }

    public /* synthetic */ void lambda$showMathFun$16$MathFunAdapter(String str) {
        this.param.saveLableString(str);
    }

    public /* synthetic */ void lambda$showMathFun$18$MathFunAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readLinAAttr();
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getLineAAttr().getMaxLongValue(), this.param.getLineAAttr().getMinLongValue(), this.param.getLineAAttr().getDefLongValue(), this.param.getLineA(), UnitFormat.SI.MICRO, new UnitFormat.SI[]{UnitFormat.SI.KILO}, "0.00", new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFunAdapter.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFunAdapter.this.param.saveLineA(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFunAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFun$19$MathFunAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readLinBAttr();
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_decimal, this.param.getLineBAttr().getMaxLongValue(), this.param.getLineBAttr().getMinLongValue(), this.param.getLineBAttr().getDefLongValue(), this.param.getLineB(), UnitFormat.SI.MICRO, new UnitFormat.SI[]{UnitFormat.SI.KILO}, "0.00", new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFunAdapter.5
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFunAdapter.this.param.saveLineB(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFunAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFun$20$MathFunAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readIntgBiasAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getIntgBiasUnit(), this.param.getIntgBiasAttr().getMaxLongValue(), this.param.getIntgBiasAttr().getMinLongValue(), this.param.getIntgBiasAttr().getDefLongValue(), this.param.getIntgBias(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFunAdapter.6
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFunAdapter.this.param.saveIntgBias(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFunAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFun$21$MathFunAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readDiffSmoothAttr();
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_number, this.param.getDiffSmoothAttr().getMaxIntValue(), this.param.getDiffSmoothAttr().getMinIntValue(), this.param.getDiffSmoothAttr().getDefIntValue(), this.param.getDiffSmooth(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathFunAdapter.7
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathFunAdapter.this.param.saveDiffSmooth(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathFunAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathFun$22$MathFunAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveExpand(ServiceEnum.VertExpand.vert_expand_gnd);
        }
    }

    public /* synthetic */ void lambda$showMathFun$23$MathFunAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveExpand(ServiceEnum.VertExpand.vert_expand_center);
        }
    }

    public /* synthetic */ void lambda$showMathFun$24$MathFunAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_FULL);
        }
    }

    public /* synthetic */ void lambda$showMathFun$25$MathFunAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_HALF);
        }
    }

    public /* synthetic */ void lambda$showMathFun$26$MathFunAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_NONE);
        }
    }

    public void setisNowView(boolean z) {
        this.isNowView = z;
    }
}
