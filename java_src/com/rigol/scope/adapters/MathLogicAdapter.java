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
import com.blankj.utilcode.util.LogUtils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.adapters.MathLogicAdapter;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.databinding.AdapterMathLogicBindingImpl;
import com.rigol.scope.databinding.PopupviewMathBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class MathLogicAdapter extends RecyclerView.Adapter<MathLogicHolder> implements AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private View anchorView;
    private AorBManager aorBManager;
    private AdapterMathLogicBindingImpl binding;
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

    public MathLogicAdapter(Context context, View view, MathParam mathParam, PopupviewMathBinding popupviewMathBinding, MathPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = mathParam;
        this.context = context;
        this.serviceId = mathParam.getServiceId();
        this.anchorView = view;
        this.popupviewMathBinding = popupviewMathBinding;
        this.holder = viewPagerHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MathLogicHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = (AdapterMathLogicBindingImpl) AdapterMathLogicBindingImpl.inflate(LayoutInflater.from(viewGroup.getContext()));
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        LogUtils.e("list_aorbParam", Integer.valueOf(this.list_aorbParam.size()));
        this.list_aorbParam.add(new AorBParam(this.binding.offsetEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.sensitivityEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.thresholdCh1EditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.thresholdCh2EditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.thresholdCh3EditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.thresholdCh4EditText, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceASpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceBSpinner, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.MathLogicAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(MathLogicAdapter.this.context, MathLogicAdapter.this.aorBManager.getList_aorbParam().get(i2).getEditText(), true, MathLogicAdapter.this.aorBManager.getList_aorbParam().get(i2).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(MathLogicAdapter.this.context, ((AorBParam) MathLogicAdapter.this.list_aorbParam.get(i2)).getEditText(), false, ((AorBParam) MathLogicAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.offsetEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.sensitivityEditText, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$4aYBUDFzlPLHEdTxUmiFnOR-Yv8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathLogicAdapter.this.lambda$onCreateViewHolder$2$MathLogicAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new MathLogicHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$2$MathLogicAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MathPopupView.class) && this.holder.getLayoutPosition() == this.popupviewMathBinding.tabs.getSelectedTabPosition() && this.isNowView) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$stcTMk_hciZd_TKIKM1IHm6mk-0
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    MathLogicAdapter.this.lambda$onCreateViewHolder$0$MathLogicAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$ohEInQu07Qzkn76QEoGacwkBJ1c
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MathLogicAdapter.this.lambda$onCreateViewHolder$1$MathLogicAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$MathLogicAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$MathLogicAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.sourceA_spinner) {
            selectSourceA(i);
        } else if (this.clickedView.getId() == R.id.sourceB_spinner) {
            selectSourceB(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectSourceB(int i) {
        MathParam mathParam = this.param;
        if (mathParam != null) {
            this.param.saveSourceLogicB(ServiceEnum.getChanFromValue1(mathParam.getSourceLogicB().keyAt(i)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void selectSourceA(int i) {
        MathParam mathParam = this.param;
        if (mathParam != null) {
            this.param.saveSourceLogicA(ServiceEnum.getChanFromValue1(mathParam.getSourceLogicA().keyAt(i)));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(MathLogicHolder mathLogicHolder, int i) {
        ShowMathLogic();
        mathLogicHolder.binding.executePendingBindings();
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !isMove()) {
            return;
        }
        switch (i) {
            case R.id.offset_edit_text /* 2131363501 */:
                if (z) {
                    offsetUp();
                    return;
                } else {
                    offsetDown();
                    return;
                }
            case R.id.sensitivity_edit_text /* 2131363829 */:
                this.param.readThresholdSensAttr();
                MessageAttr messageAttr = new MessageAttr();
                messageAttr.setMaxValue(this.param.getThresholdSensAttr().getMaxIntValue() * 100);
                messageAttr.setMinValue(this.param.getThresholdSensAttr().getMinIntValue() * 100);
                messageAttr.setDefValue(this.param.getThresholdSensAttr().getDefIntValue() * 100);
                messageAttr.setStepValue(100L);
                MathParam mathParam = this.param;
                mathParam.saveSens(mathParam.getIntStep(mathParam.getSens(), messageAttr, z, keyEvent));
                return;
            case R.id.threshold_ch1_edit_text /* 2131364069 */:
                this.param.readThresholdCH1Attr();
                MathParam mathParam2 = this.param;
                mathParam2.saveThresholdCH1(mathParam2.getLongStep(mathParam2.getThresholdCH1(), this.param.getThresholdCH1Attr(), z, keyEvent));
                return;
            case R.id.threshold_ch2_edit_text /* 2131364071 */:
                this.param.readThresholdCH2Attr();
                MathParam mathParam3 = this.param;
                mathParam3.saveThresholdCH2(mathParam3.getLongStep(mathParam3.getThresholdCH2(), this.param.getThresholdCH2Attr(), z, keyEvent));
                return;
            case R.id.threshold_ch3_edit_text /* 2131364073 */:
                this.param.readThresholdCH3Attr();
                MathParam mathParam4 = this.param;
                mathParam4.saveThresholdCH3(mathParam4.getLongStep(mathParam4.getThresholdCH3(), this.param.getThresholdCH3Attr(), z, keyEvent));
                return;
            case R.id.threshold_ch4_edit_text /* 2131364075 */:
                this.param.readThresholdCH4Attr();
                MathParam mathParam5 = this.param;
                mathParam5.saveThresholdCH4(mathParam5.getLongStep(mathParam5.getThresholdCH4(), this.param.getThresholdCH4Attr(), z, keyEvent));
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
            case R.id.offset_edit_text /* 2131363501 */:
                this.param.logicOffsetReset();
                return;
            case R.id.sensitivity_edit_text /* 2131363829 */:
                this.param.logicSensReset();
                return;
            case R.id.threshold_ch1_edit_text /* 2131364069 */:
                this.param.readThresholdCH1Attr();
                MathParam mathParam = this.param;
                mathParam.saveThresholdCH1(mathParam.getLongDef(mathParam.getThresholdCH1Attr()));
                return;
            case R.id.threshold_ch2_edit_text /* 2131364071 */:
                this.param.readThresholdCH2Attr();
                MathParam mathParam2 = this.param;
                mathParam2.saveThresholdCH2(mathParam2.getLongDef(mathParam2.getThresholdCH2Attr()));
                return;
            case R.id.threshold_ch3_edit_text /* 2131364073 */:
                this.param.readThresholdCH3Attr();
                MathParam mathParam3 = this.param;
                mathParam3.saveThresholdCH3(mathParam3.getLongDef(mathParam3.getThresholdCH3Attr()));
                return;
            case R.id.threshold_ch4_edit_text /* 2131364075 */:
                this.param.readThresholdCH4Attr();
                MathParam mathParam4 = this.param;
                mathParam4.saveThresholdCH4(mathParam4.getLongDef(mathParam4.getThresholdCH4Attr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public class MathLogicHolder extends RecyclerView.ViewHolder {
        private AdapterMathLogicBindingImpl binding;

        public MathLogicHolder(AdapterMathLogicBindingImpl adapterMathLogicBindingImpl) {
            super(adapterMathLogicBindingImpl.getRoot());
            this.binding = adapterMathLogicBindingImpl;
        }
    }

    public void ShowMathLogic() {
        ViewUtil.setSwitchButton(this.binding.labelSwitch);
        ViewUtil.setSwitchButton(R.array.msg_math_wave_type, this.binding.waveTypeSwitch);
        this.binding.setParam(this.param);
        this.binding.setSmallMapping(ViewUtil.getMappingObject(R.array.msg_math_logic_scale, ServiceEnum.LaScale.Small.value1));
        this.binding.setMediumMapping(ViewUtil.getMappingObject(R.array.msg_math_logic_scale, ServiceEnum.LaScale.Medium.value1));
        this.binding.setLargeMapping(ViewUtil.getMappingObject(R.array.msg_math_logic_scale, ServiceEnum.LaScale.Large.value1));
        this.binding.setGridFullMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_FULL.value1));
        this.binding.setGridHalfMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_HALF.value1));
        this.binding.setGridNoneMapping(ViewUtil.getMappingObject(R.array.msg_display_grid, ServiceEnum.EWaveGrids.GRID_IS_NONE.value1));
        this.binding.sourceASpinner.setOnClickListener(new AnonymousClass2());
        this.binding.sourceBSpinner.setOnClickListener(new AnonymousClass3());
        this.binding.offsetEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MathLogicAdapter.this.aorBManager.setClick_showab(view.getId())) {
                    MathLogicAdapter.this.param.readLogicOffsetAttr();
                    View view2 = MathLogicAdapter.this.anchorView;
                    ServiceEnum.Unit unitIndex = MathLogicAdapter.this.param.getUnitIndex();
                    long maxLongValue = MathLogicAdapter.this.param.getLogicOffsetAttr().getMaxLongValue();
                    MathParam unused = MathLogicAdapter.this.param;
                    long minLongValue = MathLogicAdapter.this.param.getLogicOffsetAttr().getMinLongValue();
                    MathParam unused2 = MathLogicAdapter.this.param;
                    long defLongValue = MathLogicAdapter.this.param.getLogicOffsetAttr().getDefLongValue();
                    MathParam unused3 = MathLogicAdapter.this.param;
                    long logicOffset = MathLogicAdapter.this.param.getLogicOffset();
                    MathParam unused4 = MathLogicAdapter.this.param;
                    ViewUtil.showKeyboard(view2, view, unitIndex, maxLongValue / 1000000, minLongValue / 1000000, defLongValue / 1000000, logicOffset / 1000000, new KeyboardListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.4.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            MathParam mathParam = MathLogicAdapter.this.param;
                            long longValue = ((Long) t).longValue();
                            MathParam unused5 = MathLogicAdapter.this.param;
                            mathParam.saveLogicOffset(longValue * 1000000);
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            MathLogicAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            }
        });
        this.binding.mathOffsetUp.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$hDm3sATY51Jw1Hgy2R9hbhshB68
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathLogicAdapter.this.lambda$ShowMathLogic$3$MathLogicAdapter(view);
            }
        });
        this.binding.mathOffsetDown.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$0nng33E0NmL3bhUnlK_Xnd8piV0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathLogicAdapter.this.lambda$ShowMathLogic$4$MathLogicAdapter(view);
            }
        });
        this.binding.sensitivityEditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MathLogicAdapter.this.aorBManager.setClick_showab(view.getId())) {
                    MathLogicAdapter.this.param.readThresholdSensAttr();
                    View view2 = MathLogicAdapter.this.anchorView;
                    ServiceEnum.Unit unitIndex = MathLogicAdapter.this.param.getUnitIndex();
                    int maxIntValue = MathLogicAdapter.this.param.getThresholdSensAttr().getMaxIntValue();
                    MathParam unused = MathLogicAdapter.this.param;
                    long j = maxIntValue * 100;
                    int minIntValue = MathLogicAdapter.this.param.getThresholdSensAttr().getMinIntValue();
                    MathParam unused2 = MathLogicAdapter.this.param;
                    long j2 = minIntValue * 100;
                    int defIntValue = MathLogicAdapter.this.param.getThresholdSensAttr().getDefIntValue();
                    MathParam unused3 = MathLogicAdapter.this.param;
                    ViewUtil.showKeyboard(view2, view, unitIndex, j, j2, defIntValue * 100, MathLogicAdapter.this.param.getSens(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.5.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            MathLogicAdapter.this.param.saveSens(((Long) t).intValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            MathLogicAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            }
        });
        this.binding.thresholdCh1EditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MathLogicAdapter.this.aorBManager.setClick_showab(view.getId())) {
                    MathLogicAdapter.this.param.readThresholdCH1Attr();
                    ViewUtil.showKeyboard(MathLogicAdapter.this.anchorView, view, MathLogicAdapter.this.param.getThresholdUnit(), MathLogicAdapter.this.param.getThresholdCH1Attr().getMaxLongValue(), MathLogicAdapter.this.param.getThresholdCH1Attr().getMinLongValue(), MathLogicAdapter.this.param.getThresholdCH1Attr().getDefLongValue(), MathLogicAdapter.this.param.getThresholdCH1(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.6.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            ArrayList<MathParam> value;
                            Long l = (Long) t;
                            MathLogicAdapter.this.param.saveThresholdCH1(l.longValue());
                            MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
                            if (mathViewModel == null || (value = mathViewModel.getLiveData().getValue()) == null) {
                                return;
                            }
                            for (MathParam mathParam : value) {
                                if (mathParam.getServiceId() != MathLogicAdapter.this.param.getServiceId()) {
                                    mathParam.setThresholdCH1(l.longValue());
                                }
                            }
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            MathLogicAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            }
        });
        this.binding.thresholdCh2EditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MathLogicAdapter.this.aorBManager.setClick_showab(view.getId())) {
                    MathLogicAdapter.this.param.readThresholdCH2Attr();
                    ViewUtil.showKeyboard(MathLogicAdapter.this.anchorView, view, MathLogicAdapter.this.param.getThresholdUnit(), MathLogicAdapter.this.param.getThresholdCH2Attr().getMaxLongValue(), MathLogicAdapter.this.param.getThresholdCH2Attr().getMinLongValue(), MathLogicAdapter.this.param.getThresholdCH2Attr().getDefLongValue(), MathLogicAdapter.this.param.getThresholdCH2(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.7.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            ArrayList<MathParam> value;
                            Long l = (Long) t;
                            MathLogicAdapter.this.param.saveThresholdCH2(l.longValue());
                            MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
                            if (mathViewModel == null || (value = mathViewModel.getLiveData().getValue()) == null) {
                                return;
                            }
                            for (MathParam mathParam : value) {
                                if (mathParam.getServiceId() != MathLogicAdapter.this.param.getServiceId()) {
                                    mathParam.setThresholdCH2(l.longValue());
                                }
                            }
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            MathLogicAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            }
        });
        this.binding.thresholdCh3EditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MathLogicAdapter.this.aorBManager.setClick_showab(view.getId())) {
                    MathLogicAdapter.this.param.readThresholdCH3Attr();
                    ViewUtil.showKeyboard(MathLogicAdapter.this.anchorView, view, MathLogicAdapter.this.param.getThresholdUnit(), MathLogicAdapter.this.param.getThresholdCH3Attr().getMaxLongValue(), MathLogicAdapter.this.param.getThresholdCH3Attr().getMinLongValue(), MathLogicAdapter.this.param.getThresholdCH3Attr().getDefLongValue(), MathLogicAdapter.this.param.getThresholdCH3(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.8.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            ArrayList<MathParam> value;
                            Long l = (Long) t;
                            MathLogicAdapter.this.param.saveThresholdCH3(l.longValue());
                            MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
                            if (mathViewModel == null || (value = mathViewModel.getLiveData().getValue()) == null) {
                                return;
                            }
                            for (MathParam mathParam : value) {
                                if (mathParam.getServiceId() != MathLogicAdapter.this.param.getServiceId()) {
                                    mathParam.setThresholdCH3(l.longValue());
                                }
                            }
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            MathLogicAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            }
        });
        this.binding.thresholdCh4EditText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MathLogicAdapter.this.aorBManager.setClick_showab(view.getId())) {
                    MathLogicAdapter.this.param.readThresholdCH4Attr();
                    ViewUtil.showKeyboard(MathLogicAdapter.this.anchorView, view, MathLogicAdapter.this.param.getThresholdUnit(), MathLogicAdapter.this.param.getThresholdCH4Attr().getMaxLongValue(), MathLogicAdapter.this.param.getThresholdCH4Attr().getMinLongValue(), MathLogicAdapter.this.param.getThresholdCH4Attr().getDefLongValue(), MathLogicAdapter.this.param.getThresholdCH4(), new KeyboardListener() { // from class: com.rigol.scope.adapters.MathLogicAdapter.9.1
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            ArrayList<MathParam> value;
                            Long l = (Long) t;
                            MathLogicAdapter.this.param.saveThresholdCH4(l.longValue());
                            MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
                            if (mathViewModel == null || (value = mathViewModel.getLiveData().getValue()) == null) {
                                return;
                            }
                            for (MathParam mathParam : value) {
                                if (mathParam.getServiceId() != MathLogicAdapter.this.param.getServiceId()) {
                                    mathParam.setThresholdCH4(l.longValue());
                                }
                            }
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            MathLogicAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    });
                }
            }
        });
        this.binding.waveTypeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$rtU5hyTH5xFCZeNixFcBzID6rL8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathLogicAdapter.this.lambda$ShowMathLogic$5$MathLogicAdapter(compoundButton, z);
            }
        });
        this.binding.labelSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$IEL2SvbilDFF4FuAMKbORLZeRNQ
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathLogicAdapter.this.lambda$ShowMathLogic$6$MathLogicAdapter(compoundButton, z);
            }
        });
        this.binding.labelEditText.setOnClickListener(new AnonymousClass10());
        this.binding.smallRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$LMSqHOg-so02yUWRunYRarVcjwo
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathLogicAdapter.this.lambda$ShowMathLogic$7$MathLogicAdapter(compoundButton, z);
            }
        });
        this.binding.mediumRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$_9UwFuZ8XRm-T54GoJOfXAyxh30
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathLogicAdapter.this.lambda$ShowMathLogic$8$MathLogicAdapter(compoundButton, z);
            }
        });
        this.binding.largeRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$HFetszxHe-aFwTrqYM2iSyTq-gA
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathLogicAdapter.this.lambda$ShowMathLogic$9$MathLogicAdapter(compoundButton, z);
            }
        });
        this.binding.fullRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$XAyitCisPgN83jNTBIHv2TmNYzU
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathLogicAdapter.this.lambda$ShowMathLogic$10$MathLogicAdapter(compoundButton, z);
            }
        });
        this.binding.halfRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$bidGtfafBjC2JZT7Yj7Q2zGT3L4
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathLogicAdapter.this.lambda$ShowMathLogic$11$MathLogicAdapter(compoundButton, z);
            }
        });
        this.binding.noneRadioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$HAaMGsQpe9oEyWITin8xEEx9uYs
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathLogicAdapter.this.lambda$ShowMathLogic$12$MathLogicAdapter(compoundButton, z);
            }
        });
    }

    /* renamed from: com.rigol.scope.adapters.MathLogicAdapter$2  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtil.showChanSpinner(MathLogicAdapter.this.anchorView, view, ViewUtil.filterChan(MathLogicAdapter.this.param.getSpinnerList(MathLogicAdapter.this.param.getServiceId(), R.array.msg_math_s32logica)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$2$uaI0RPpMzAr_Lfg6UYdHTbVXt4Y
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    MathLogicAdapter.AnonymousClass2.this.lambda$onClick$0$MathLogicAdapter$2(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$2$QDBpifbMexkj3iaKmR8wgzoJsJ4
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MathLogicAdapter.AnonymousClass2.this.lambda$onClick$1$MathLogicAdapter$2(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }

        public /* synthetic */ void lambda$onClick$0$MathLogicAdapter$2(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            MathLogicAdapter.this.popupSpinner = popupSpinner;
            MathLogicAdapter.this.spinnerAdapter = spinnerAdapter;
            MathLogicAdapter.this.mappingObjects = list;
            MathLogicAdapter.this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$MathLogicAdapter$2(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            MathLogicAdapter.this.selectSourceA(i);
        }
    }

    /* renamed from: com.rigol.scope.adapters.MathLogicAdapter$3  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements View.OnClickListener {
        AnonymousClass3() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtil.showChanSpinner(MathLogicAdapter.this.anchorView, view, ViewUtil.filterChan(MathLogicAdapter.this.param.getSpinnerList(MathLogicAdapter.this.param.getServiceId(), R.array.msg_math_s32logicb)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$3$tu57AiwEPotgr7q8qWJyjVrWnM0
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    MathLogicAdapter.AnonymousClass3.this.lambda$onClick$0$MathLogicAdapter$3(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$3$3VjHt4olthsezamLboMG0Rpcj9U
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MathLogicAdapter.AnonymousClass3.this.lambda$onClick$1$MathLogicAdapter$3(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }

        public /* synthetic */ void lambda$onClick$0$MathLogicAdapter$3(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
            MathLogicAdapter.this.popupSpinner = popupSpinner;
            MathLogicAdapter.this.spinnerAdapter = spinnerAdapter;
            MathLogicAdapter.this.mappingObjects = list;
            MathLogicAdapter.this.clickedView = view;
        }

        public /* synthetic */ void lambda$onClick$1$MathLogicAdapter$3(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            MathLogicAdapter.this.selectSourceB(i);
        }
    }

    public /* synthetic */ void lambda$ShowMathLogic$3$MathLogicAdapter(View view) {
        offsetUp();
    }

    public /* synthetic */ void lambda$ShowMathLogic$4$MathLogicAdapter(View view) {
        offsetDown();
    }

    public /* synthetic */ void lambda$ShowMathLogic$5$MathLogicAdapter(CompoundButton compoundButton, boolean z) {
        if (z) {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Zoom);
        } else {
            this.param.saveWaveType(ServiceEnum.MathWaveType.MathWave_Main);
        }
    }

    public /* synthetic */ void lambda$ShowMathLogic$6$MathLogicAdapter(CompoundButton compoundButton, boolean z) {
        this.param.saveLabel(z);
    }

    /* renamed from: com.rigol.scope.adapters.MathLogicAdapter$10  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass10 implements View.OnClickListener {
        AnonymousClass10() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ViewUtil.showPinyinKeyboard(MathLogicAdapter.this.context, MathLogicAdapter.this.anchorView, view, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$MathLogicAdapter$10$acvprn14u3dA2w2eHHiqU-xUE0k
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str) {
                    MathLogicAdapter.AnonymousClass10.this.lambda$onClick$0$MathLogicAdapter$10(str);
                }
            });
        }

        public /* synthetic */ void lambda$onClick$0$MathLogicAdapter$10(String str) {
            MathLogicAdapter.this.param.saveLableString(str);
        }
    }

    public /* synthetic */ void lambda$ShowMathLogic$7$MathLogicAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveLogicScale(ServiceEnum.LaScale.Small);
        }
    }

    public /* synthetic */ void lambda$ShowMathLogic$8$MathLogicAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveLogicScale(ServiceEnum.LaScale.Medium);
        }
    }

    public /* synthetic */ void lambda$ShowMathLogic$9$MathLogicAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveLogicScale(ServiceEnum.LaScale.Large);
        }
    }

    public /* synthetic */ void lambda$ShowMathLogic$10$MathLogicAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_FULL);
        }
    }

    public /* synthetic */ void lambda$ShowMathLogic$11$MathLogicAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_HALF);
        }
    }

    public /* synthetic */ void lambda$ShowMathLogic$12$MathLogicAdapter(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && z) {
            this.param.saveGrids(ServiceEnum.EWaveGrids.GRID_IS_NONE);
        }
    }

    private void offsetUp() {
        MathParam mathParam = this.param;
        mathParam.saveLogicOffset(mathParam.getLogicOffset() + 100000000);
    }

    private void offsetDown() {
        MathParam mathParam = this.param;
        mathParam.saveLogicOffset(mathParam.getLogicOffset() - 100000000);
    }

    public void setisNowView(boolean z) {
        this.isNowView = z;
    }
}
