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
import com.rigol.scope.databinding.AdapterMathArithBinding;
import com.rigol.scope.databinding.AdapterMathArithBindingImpl;
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
public class MathArithAdapter extends RecyclerView.Adapter<MathArithHolder> implements AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterMathArithBinding binding;
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
    }

    public MathParam getParam() {
        return this.param;
    }

    public MathArithAdapter(Context context, View view, MathParam mathParam, PopupviewMathBinding popupviewMathBinding, MathPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = mathParam;
        this.context = context;
        this.anchorView = view;
        this.serviceId = mathParam.getServiceId();
        this.popupviewMathBinding = popupviewMathBinding;
        this.holder = viewPagerHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MathArithHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterMathArithBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.scaleEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.offsetEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceASpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceBSpinner, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.MathArithAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(MathArithAdapter.this.context, ((AorBParam) MathArithAdapter.this.list_aorbParam.get(i2)).getEditText(), true, ((AorBParam) MathArithAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(MathArithAdapter.this.context, ((AorBParam) MathArithAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) MathArithAdapter.this.list_aorbParam.get(i2)).getAorb());
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$tzil41Ymgn1U3ALnvNzKDnWUyDw
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathArithAdapter.this.lambda$onCreateViewHolder$2$MathArithAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new MathArithHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$MathArithAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MathPopupView.class) && this.holder.getLayoutPosition() == this.popupviewMathBinding.tabs.getSelectedTabPosition() && this.isNowView) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$fZ2vI3d5LZ_KiCLY-fbBnO1MTmc
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    MathArithAdapter.this.lambda$onCreateViewHolder$0$MathArithAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$Xyb1XXTrNvW0hymfbrira_szsX4
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MathArithAdapter.this.lambda$onCreateViewHolder$1$MathArithAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$MathArithAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$MathArithAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.sourceA_spinner) {
            selectSourceA(mappingObject);
        } else if (this.clickedView.getId() == R.id.sourceB_spinner) {
            selectSourceB(mappingObject);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MathArithHolder mathArithHolder, int i) {
        showMathArith();
        mathArithHolder.binding.executePendingBindings();
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.offset_edit_text) {
            this.param.offsetRoll(z);
        } else if (i != R.id.scale_edit_text) {
        } else {
            this.param.scaleRoll(z);
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !isMove()) {
            return;
        }
        if (i == R.id.offset_edit_text) {
            this.param.offsetReset();
        } else if (i != R.id.scale_edit_text) {
        } else {
            this.param.scaleReset();
        }
    }

    /* loaded from: classes.dex */
    public class MathArithHolder extends RecyclerView.ViewHolder {
        private AdapterMathArithBinding binding;

        public MathArithHolder(AdapterMathArithBinding adapterMathArithBinding) {
            super(adapterMathArithBinding.getRoot());
            this.binding = adapterMathArithBinding;
        }
    }

    public void showMathArith() {
        ViewUtil.setSwitchButton(this.binding.invertSwitch);
        ViewUtil.setSwitchButton(this.binding.labelSwitch);
        ViewUtil.setSwitchButton(R.array.msg_math_wave_type, this.binding.waveTypeSwitch);
        this.binding.setParam(this.param);
        this.binding.setGndMapping(ViewUtil.getMappingObject(R.array.msg_math_expand, ServiceEnum.VertExpand.vert_expand_gnd.value1));
        this.binding.setCenterMapping(ViewUtil.getMappingObject(R.array.msg_math_expand, ServiceEnum.VertExpand.vert_expand_center.value1));
        this.binding.setGridFullMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        this.binding.setGridHalfMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        this.binding.setGridNoneMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        this.binding.sourceASpinner.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$gYdDQTR3D_oF0U2jNSwVCLdYIgM
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$5$MathArithAdapter(view);
            }
        });
        this.binding.sourceBSpinner.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$HISBWsqd8bGNWC5rrf_bCG6wRhE
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$8$MathArithAdapter(view);
            }
        });
        this.binding.offsetEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$qaJ7tZbLy_3TLPp_Kyzj0IfCPMY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$9$MathArithAdapter(view);
            }
        });
        this.binding.scaleEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$JqgBhv5UvoyT_4ujWiFZmwyyamo
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$10$MathArithAdapter(view);
            }
        });
        this.binding.mainScaleVertical.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$sfTSgUJvVG3rueydhIxH_KV4ot0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$11$MathArithAdapter(view);
            }
        });
        this.binding.mainScaleNomal.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$rICEdiJNvVDBbuLFQKYQwc8B96w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$12$MathArithAdapter(view);
            }
        });
        this.binding.mathOffsetUp.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$qvZvLjYIiEcS3rVY8Nf3b4JiRGU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$13$MathArithAdapter(view);
            }
        });
        this.binding.mathOffsetDown.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$QTdlUQz4TRE83d-uP77aBF_rIhA
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$14$MathArithAdapter(view);
            }
        });
        this.binding.autoSettingBtn.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$YnkN00Bn26xBCGS5Srxm2OD9gY8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$15$MathArithAdapter(view);
            }
        });
        this.binding.waveTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$_KMu4R9sOR16gB4ssHpLujh0hjM
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathArithAdapter.this.lambda$showMathArith$16$MathArithAdapter(compoundButton, z);
            }
        });
        this.binding.invertSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$a-zmddch6ZL0hgmCQPpwrT1SGtY
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathArithAdapter.this.lambda$showMathArith$17$MathArithAdapter(compoundButton, z);
            }
        });
        this.binding.labelSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$mDxIOciv4u2CAVGHupzzB7tdI-g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathArithAdapter.this.lambda$showMathArith$18$MathArithAdapter(compoundButton, z);
            }
        });
        this.binding.labelEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$dQG0CqxwLwLPoPKYb6E7xnj4NF4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathArithAdapter.this.lambda$showMathArith$20$MathArithAdapter(view);
            }
        });
        this.binding.gndRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$oEWWZaOrqat2o9LIdpS6WQcBTV0
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathArithAdapter.this.lambda$showMathArith$21$MathArithAdapter(compoundButton, z);
            }
        });
        this.binding.centerRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$8erPw6HbKBG_OuzW6QdIHkXSvD8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathArithAdapter.this.lambda$showMathArith$22$MathArithAdapter(compoundButton, z);
            }
        });
        this.binding.fullRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$EWIqwob2qk5FuKM3xhRKIOjZUj8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathArithAdapter.this.lambda$showMathArith$23$MathArithAdapter(compoundButton, z);
            }
        });
        this.binding.halfRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$aPCZ483Q1X8mLxfauXXcEXig6a4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathArithAdapter.this.lambda$showMathArith$24$MathArithAdapter(compoundButton, z);
            }
        });
        this.binding.noneRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$jrTMpMyhEUvxzBx42EOog1w-oOc
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathArithAdapter.this.lambda$showMathArith$25$MathArithAdapter(compoundButton, z);
            }
        });
    }

    public /* synthetic */ void lambda$showMathArith$5$MathArithAdapter(View view) {
        MathParam mathParam = this.param;
        ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(mathParam.getSpinnerList(mathParam.getServiceId(), R.array.msg_math_s32aritha)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$JjAiTcXBvw7_MRlWotMIr7A_sbQ
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                MathArithAdapter.this.lambda$showMathArith$3$MathArithAdapter(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$xgWra86kj_dK3oVzIBpMrbVbgXU
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                MathArithAdapter.this.lambda$showMathArith$4$MathArithAdapter(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$showMathArith$3$MathArithAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$showMathArith$4$MathArithAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceA(mappingObject);
    }

    public /* synthetic */ void lambda$showMathArith$8$MathArithAdapter(View view) {
        MathParam mathParam = this.param;
        ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(mathParam.getSpinnerList(mathParam.getServiceId(), R.array.msg_math_s32arithb)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$Jg26YOQl91rXBiIu0gebgGnNX7k
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                MathArithAdapter.this.lambda$showMathArith$6$MathArithAdapter(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$nuk-6abHzcqkDWhin9Wnj5EWBYA
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                MathArithAdapter.this.lambda$showMathArith$7$MathArithAdapter(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$showMathArith$6$MathArithAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$showMathArith$7$MathArithAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceB(mappingObject);
    }

    public /* synthetic */ void lambda$showMathArith$9$MathArithAdapter(View view) {
        try {
            if (this.aorBManager.setClick_showab(view.getId())) {
                this.param.readAnaOffsetAttr();
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnitIndex(), this.param.getAnaOffsetAttr().getMaxLongValue(), this.param.getAnaOffsetAttr().getMinLongValue(), this.param.getAnaOffsetAttr().getDefLongValue(), this.param.getOffset(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathArithAdapter.2
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        MathArithAdapter.this.param.saveOffset(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MathArithAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public /* synthetic */ void lambda$showMathArith$10$MathArithAdapter(View view) {
        if (this.aorBManager.setClick_showab(view.getId())) {
            this.param.readAnaScaleAttr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnitIndex(), this.param.getAnaScaleAttr().getMaxLongValue(), this.param.getAnaScaleAttr().getMinLongValue(), this.param.getAnaScaleAttr().getDefLongValue(), this.param.getScale(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathArithAdapter.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    MathArithAdapter.this.param.saveScale(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    MathArithAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$showMathArith$11$MathArithAdapter(View view) {
        this.param.scaleUp();
    }

    public /* synthetic */ void lambda$showMathArith$12$MathArithAdapter(View view) {
        this.param.scaleDown();
    }

    public /* synthetic */ void lambda$showMathArith$13$MathArithAdapter(View view) {
        this.param.offsetUp();
    }

    public /* synthetic */ void lambda$showMathArith$14$MathArithAdapter(View view) {
        this.param.offsetDown();
    }

    public /* synthetic */ void lambda$showMathArith$15$MathArithAdapter(View view) {
        API.getInstance().UI_PostBool(this.serviceId, MessageID.MSG_MATH_AUTO_SCALE, true);
    }

    public /* synthetic */ void lambda$showMathArith$16$MathArithAdapter(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Zoom);
        } else {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Main);
        }
    }

    public /* synthetic */ void lambda$showMathArith$17$MathArithAdapter(CompoundButton compoundButton, boolean z) {
        this.param.saveInvert(z);
    }

    public /* synthetic */ void lambda$showMathArith$18$MathArithAdapter(CompoundButton compoundButton, boolean z) {
        this.param.saveLabel(z);
    }

    public /* synthetic */ void lambda$showMathArith$20$MathArithAdapter(View view) {
        ViewUtil.showPinyinKeyboard(this.context, this.anchorView, view, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$MathArithAdapter$Tijij_IyAJvHESdBhvgOVRaXxkU
            @Override // com.rigol.pinyinkeyboard.ExternalInterface
            public final void resultShow(String str) {
                MathArithAdapter.this.lambda$showMathArith$19$MathArithAdapter(str);
            }
        });
    }

    public /* synthetic */ void lambda$showMathArith$19$MathArithAdapter(String str) {
        this.param.saveLableString(str);
    }

    public /* synthetic */ void lambda$showMathArith$21$MathArithAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveExpand(ServiceEnum.VertExpand.vert_expand_gnd);
        }
    }

    public /* synthetic */ void lambda$showMathArith$22$MathArithAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveExpand(ServiceEnum.VertExpand.vert_expand_center);
        }
    }

    public /* synthetic */ void lambda$showMathArith$23$MathArithAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_FULL);
        }
    }

    public /* synthetic */ void lambda$showMathArith$24$MathArithAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_HALF);
        }
    }

    public /* synthetic */ void lambda$showMathArith$25$MathArithAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_NONE);
        }
    }

    private void selectSourceA(MappingObject mappingObject) {
        if (this.param != null) {
            this.param.saveSourceArithA(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
        }
    }

    private void selectSourceB(MappingObject mappingObject) {
        if (this.param != null) {
            this.param.saveSourceArithB(ServiceEnum.getChanFromValue1(mappingObject.getValue()));
        }
    }

    public void setisNowView(boolean z) {
        this.isNowView = z;
    }
}
