package com.rigol.scope.views.math;

import android.content.Context;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.adapters.MathArithAdapter;
import com.rigol.scope.adapters.MathFftAdapter;
import com.rigol.scope.adapters.MathFilterAdapter;
import com.rigol.scope.adapters.MathFunAdapter;
import com.rigol.scope.adapters.MathLogicAdapter;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.databinding.MathRecyclerviewBindingImpl;
import com.rigol.scope.databinding.PopupviewMathBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MathRecyclerView {
    private View anchorview;
    private AorBManager aorBManager;
    private MathRecyclerviewBindingImpl binding;
    private View clickedView;
    private Context context;
    private MathPopupView.ViewPagerAdapter.ViewPagerHolder holder;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private List<MappingObject> mappingObjects;
    private MathArithAdapter mathArithAdapter;
    private MathFftAdapter mathFftAdapter;
    private MathFilterAdapter mathFilterAdapter;
    private MathFunAdapter mathFunAdapter;
    private MathLogicAdapter mathLogicAdapter;
    private PanelKeyViewModel panelKeyViewModel;
    private MathParam param;
    private PopupSpinner popupSpinner;
    private PopupviewMathBinding popupviewMathBinding;
    private SpinnerAdapter spinnerAdapter;
    private SyncDataViewModel syncDataViewModel;

    public MathRecyclerView(Context context, final MathParam mathParam, View view, MathRecyclerviewBindingImpl mathRecyclerviewBindingImpl, PopupviewMathBinding popupviewMathBinding, MathPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = mathParam;
        this.context = context;
        this.binding = mathRecyclerviewBindingImpl;
        this.popupviewMathBinding = popupviewMathBinding;
        this.anchorview = view;
        this.holder = viewPagerHolder;
        initView();
        if (this.syncDataViewModel == null) {
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            this.syncDataViewModel = syncDataViewModel;
            if (syncDataViewModel != null) {
                syncDataViewModel.get(mathParam.getServiceId(), MessageID.MSG_MATH_OPERATOR).observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.math.MathRecyclerView.1
                    @Override // androidx.lifecycle.Observer
                    public void onChanged(Object obj) {
                        MathRecyclerView.this.showMath(mathParam.getOperator());
                    }
                });
            }
        }
    }

    public void mathShowView() {
        this.binding.setParam(this.param);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.operatorSpinner, 0, false, "", 2));
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.math.MathRecyclerView.2
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
            }
        };
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.math.-$$Lambda$MathRecyclerView$1CHcda8txZO17zxBFlQ0EKpxcs8
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathRecyclerView.this.lambda$mathShowView$1$MathRecyclerView((KeyEvent) obj);
                    }
                });
            }
        }
        ViewUtil.setSwitchButton(this.binding.operatorSwitch);
        this.binding.operatorSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.views.math.-$$Lambda$MathRecyclerView$52RNuX17l3MSGWLsvt7VbOYmpDE
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                MathRecyclerView.this.lambda$mathShowView$2$MathRecyclerView(compoundButton, z);
            }
        });
        this.binding.operatorSpinner.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.math.-$$Lambda$MathRecyclerView$Kz807xv-x7bUN7cMrzEQU03UKro
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MathRecyclerView.this.lambda$mathShowView$5$MathRecyclerView(view);
            }
        });
    }

    public /* synthetic */ void lambda$mathShowView$1$MathRecyclerView(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        List<MappingObject> list;
        if (!PopupViewManager.getInstance().isShowing(MathPopupView.class) || (popupSpinner = this.popupSpinner) == null || !popupSpinner.isShowing() || (list = this.mappingObjects) == null) {
            return;
        }
        this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, list, this.spinnerAdapter, this.aorBManager, null, null, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.math.-$$Lambda$MathRecyclerView$I9aPZ28dHesHUQFC1Gn2hilSNcU
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
            public final void onCall(int i, MappingObject mappingObject) {
                MathRecyclerView.this.lambda$mathShowView$0$MathRecyclerView(i, mappingObject);
            }
        });
    }

    public /* synthetic */ void lambda$mathShowView$0$MathRecyclerView(int i, MappingObject mappingObject) {
        selectAdapter(mappingObject);
    }

    public /* synthetic */ void lambda$mathShowView$2$MathRecyclerView(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            this.param.saveStatus(z);
        }
    }

    public /* synthetic */ void lambda$mathShowView$5$MathRecyclerView(View view) {
        ViewUtil.showSpinner(this.anchorview, view, ViewUtil.getList((int) R.array.msg_math_operator), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.math.-$$Lambda$MathRecyclerView$86Lopuj-dfF_AumwIKh3ZG4P3NM
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                MathRecyclerView.this.lambda$mathShowView$3$MathRecyclerView(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.math.-$$Lambda$MathRecyclerView$1qntk5eQh4V7buH0k_aFcujcwIs
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                MathRecyclerView.this.lambda$mathShowView$4$MathRecyclerView(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$mathShowView$3$MathRecyclerView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$mathShowView$4$MathRecyclerView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectAdapter(mappingObject);
    }

    private void initView() {
        if (this.mathArithAdapter == null) {
            this.mathArithAdapter = new MathArithAdapter(this.context, this.anchorview, this.param, this.popupviewMathBinding, this.holder);
        }
        if (this.mathFftAdapter == null) {
            this.mathFftAdapter = new MathFftAdapter(this.context, this.anchorview, this.param, this.popupviewMathBinding, this.holder);
        }
        if (this.mathLogicAdapter == null) {
            MathLogicAdapter mathLogicAdapter = new MathLogicAdapter(this.context, this.anchorview, this.param, this.popupviewMathBinding, this.holder);
            this.mathLogicAdapter = mathLogicAdapter;
            this.param.setMathLogicAdapter(mathLogicAdapter);
        }
        if (this.mathFunAdapter == null) {
            this.mathFunAdapter = new MathFunAdapter(this.context, this.anchorview, this.param, this.popupviewMathBinding, this.holder);
        }
        if (this.mathFilterAdapter == null) {
            this.mathFilterAdapter = new MathFilterAdapter(this.context, this.anchorview, this.param, this.popupviewMathBinding, this.holder);
        }
        resetAdapterIsMove();
    }

    private void resetAdapterIsMove() {
        this.mathArithAdapter.setMove(false);
        this.mathFftAdapter.setMove(false);
        this.mathLogicAdapter.setMove(false);
        this.mathFunAdapter.setMove(false);
        this.mathFilterAdapter.setMove(false);
        this.mathArithAdapter.setisNowView(false);
        this.mathLogicAdapter.setisNowView(false);
    }

    private void selectAdapter(MappingObject mappingObject) {
        ServiceEnum.MathOperator mathOperatorFromValue1 = ServiceEnum.getMathOperatorFromValue1(mappingObject.getValue());
        this.param.saveOperator(mathOperatorFromValue1);
        showMath(mathOperatorFromValue1);
        PopupViewManager.getInstance().openMathLight((MathPopupView) PopupViewManager.getInstance().get(MathPopupView.class));
    }

    public void showMath(ServiceEnum.MathOperator mathOperator) {
        this.binding.mathViewRecycle.setAdapter(getAdapter(mathOperator));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.math.MathRecyclerView$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator;

        static {
            int[] iArr = new int[ServiceEnum.MathOperator.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator = iArr;
            try {
                iArr[ServiceEnum.MathOperator.operator_add.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_sub.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_mul.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_div.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_fft.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_and.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_or.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_xor.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_not.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_intg.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_diff.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_root.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_lg.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_ln.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_exp.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_abs.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_ax_b.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_lp.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_hp.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_bp.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_bt.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_trend.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_max.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_min.ordinal()] = 24;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[ServiceEnum.MathOperator.operator_envelope.ordinal()] = 25;
            } catch (NoSuchFieldError unused25) {
            }
        }
    }

    private RecyclerView.Adapter<?> getAdapter(ServiceEnum.MathOperator mathOperator) {
        if (mathOperator == null) {
            return null;
        }
        initView();
        switch (AnonymousClass3.$SwitchMap$com$rigol$scope$cil$ServiceEnum$MathOperator[mathOperator.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                this.mathArithAdapter.setisNowView(true);
                this.mathArithAdapter.setMove(true);
                return this.mathArithAdapter;
            case 5:
                this.mathFftAdapter.setMove(true);
                return this.mathFftAdapter;
            case 6:
            case 7:
            case 8:
            case 9:
                this.mathLogicAdapter.setisNowView(true);
                this.mathLogicAdapter.setMove(true);
                return this.mathLogicAdapter;
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                this.mathFunAdapter.setisNowView(true);
                this.mathFunAdapter.setMove(true);
                return this.mathFunAdapter;
            case 18:
            case 19:
            case 20:
            case 21:
                this.mathFilterAdapter.setMove(true);
                return this.mathFilterAdapter;
            default:
                return null;
        }
    }
}
