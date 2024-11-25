package com.rigol.scope.views.histogram;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.databinding.PopupviewResultHistogramBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.BaseDeletePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: HistogramSettingPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+J\u0010\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010.\u001a\u00020)J\u0018\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\u0010\u00105\u001a\u0002002\u0006\u00106\u001a\u00020\u000bH\u0016J\u0010\u00107\u001a\u0002002\u0006\u00108\u001a\u00020)H\u0016J\u000e\u00109\u001a\u0002002\u0006\u0010.\u001a\u00020)J\u0006\u0010:\u001a\u000200J\u0006\u0010;\u001a\u000200J\u000e\u0010<\u001a\u0002002\u0006\u0010.\u001a\u00020)J\u000e\u0010=\u001a\u0002002\u0006\u0010.\u001a\u00020)R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\f\u001a\u0004\u0018\u00010\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/rigol/scope/views/histogram/HistogramSettingPopupView;", "Lcom/rigol/scope/views/baseview/BaseDeletePopupView;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/view/View$OnClickListener;", "Lcom/rigol/scope/utilities/AorBManager$OnTextReset;", "()V", "aorBManager", "Lcom/rigol/scope/utilities/AorBManager;", "binding", "Lcom/rigol/scope/databinding/PopupviewResultHistogramBinding;", "clickedView", "Landroid/view/View;", "horParam", "Lcom/rigol/scope/data/HorizontalParam;", "getHorParam", "()Lcom/rigol/scope/data/HorizontalParam;", "horizontalParam", "keyboardPopupView", "Lcom/rigol/scope/views/keyboard/KeyboardPopupView;", "list_aorbParam", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/AorBParam;", "Lkotlin/collections/ArrayList;", "mappingObjects", "", "Lcom/rigol/scope/data/MappingObject;", "panelKeyViewModel", "Lcom/rigol/scope/viewmodels/PanelKeyViewModel;", "param", "Lcom/rigol/scope/views/histogram/HistogramResultParam;", "getParam", "()Lcom/rigol/scope/views/histogram/HistogramResultParam;", "setParam", "(Lcom/rigol/scope/views/histogram/HistogramResultParam;)V", "popupSpinner", "Lcom/rigol/scope/views/spinner/PopupSpinner;", "spinnerAdapter", "Lcom/rigol/scope/adapters/SpinnerAdapter;", "syncDataViewModel", "Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "getServiceIDByChan", "", "chan", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "getVerticalParamByServiceID", "Lcom/rigol/scope/data/VerticalParam;", "serviceID", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "onClick", "v", "onResetDefault", "viewId", "updateBottomAttr", "updateLeftAttr", "updateRightAttr", "updateTopAttr", "updateVerUnit", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HistogramSettingPopupView extends BaseDeletePopupView implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    private final PopupviewResultHistogramBinding binding;
    private final View clickedView;
    private HorizontalParam horizontalParam;
    private KeyboardPopupView keyboardPopupView;
    private final ArrayList<AorBParam> list_aorbParam;
    private final List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    public HistogramResultParam param;
    private final PopupSpinner popupSpinner;
    private final SpinnerAdapter spinnerAdapter;
    private final SyncDataViewModel syncDataViewModel;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServiceEnum.Chan.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ServiceEnum.Chan.chan1.ordinal()] = 1;
            $EnumSwitchMapping$0[ServiceEnum.Chan.chan2.ordinal()] = 2;
            $EnumSwitchMapping$0[ServiceEnum.Chan.chan3.ordinal()] = 3;
            $EnumSwitchMapping$0[ServiceEnum.Chan.chan4.ordinal()] = 4;
        }
    }

    public HistogramSettingPopupView() {
        super(R.style.App_PopupWindow_ResultHistogram);
        LiveData<HorizontalParam> liveData;
        LiveData<HistogramResultParam> liveData2;
        this.list_aorbParam = new ArrayList<>();
        final PopupviewResultHistogramBinding inflate = PopupviewResultHistogramBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewResultHistogram…utInflater.from(context))");
        inflate.enable.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Timber.d("Histogram:UI:SAVE:EN: Clicked", new Object[0]);
                HistogramResultParam param = PopupviewResultHistogramBinding.this.getParam();
                if (param != null) {
                    HistogramResultParam param2 = PopupviewResultHistogramBinding.this.getParam();
                    param.saveEnable(!(param2 != null ? param2.getEnable() : false));
                }
            }
        });
        Unit unit = Unit.INSTANCE;
        this.binding = inflate;
        setContentView(inflate.getRoot());
        HistogramViewModel histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class);
        if (histogramViewModel != null && (liveData2 = histogramViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData2.observe((LifecycleOwner) topActivity, new Observer<HistogramResultParam>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(HistogramResultParam histogramResultParam) {
                    HistogramSettingPopupView histogramSettingPopupView = HistogramSettingPopupView.this;
                    Intrinsics.checkNotNullExpressionValue(histogramResultParam, "histogramResultParam");
                    histogramSettingPopupView.setParam(histogramResultParam);
                    HistogramSettingPopupView.this.binding.setParam(HistogramSettingPopupView.this.getParam());
                }
            });
        }
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null && (liveData = horizontalViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData.observe((LifecycleOwner) topActivity2, new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(HorizontalParam horizontalParam) {
                    HistogramSettingPopupView.this.horizontalParam = horizontalParam;
                }
            });
        }
        HistogramSettingPopupView histogramSettingPopupView = this;
        this.binding.setOnClickListener(histogramSettingPopupView);
        this.binding.setHorizontalMappingObject(ViewUtil.getMappingObject(R.array.msg_histo_type, ServiceEnum.HistoType.histoHori.value1));
        this.binding.setVerticalMappingObject(ViewUtil.getMappingObject(R.array.msg_histo_type, ServiceEnum.HistoType.histoVert.value1));
        this.binding.setMeasureMappingObject(ViewUtil.getMappingObject(R.array.msg_histo_type, ServiceEnum.HistoType.histoMeas.value1));
        this.binding.setChanNoneMappingObject(ViewUtil.getMappingObject(R.array.msg_histo_source, ServiceEnum.Chan.chan_none.value1));
        this.binding.setChan1MappingObject(ViewUtil.getMappingObject(R.array.msg_histo_source, ServiceEnum.Chan.chan1.value1));
        this.binding.setChan2MappingObject(ViewUtil.getMappingObject(R.array.msg_histo_source, ServiceEnum.Chan.chan2.value1));
        this.binding.setChan3MappingObject(ViewUtil.getMappingObject(R.array.msg_histo_source, ServiceEnum.Chan.chan3.value1));
        this.binding.setChan4MappingObject(ViewUtil.getMappingObject(R.array.msg_histo_source, ServiceEnum.Chan.chan4.value1));
        this.binding.histogramTypeSpinner.setOnClickListener(histogramSettingPopupView);
        this.binding.histoReset.setOnClickListener(histogramSettingPopupView);
        this.binding.sourceSpinner.setOnClickListener(histogramSettingPopupView);
        ViewUtil.setSwitchButton(this.binding.histogramEn);
        HistogramSettingPopupView histogramSettingPopupView2 = this;
        this.binding.histogramEn.setOnCheckedChangeListener(histogramSettingPopupView2);
        ViewUtil.setSwitchButton(this.binding.statisenSwitch);
        this.binding.statisenSwitch.setOnCheckedChangeListener(histogramSettingPopupView2);
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        for (final int i = 1; i <= 4; i++) {
            MutableLiveData<Object> mutableLiveData = this.syncDataViewModel.get(i, MessageID.MSG_CHAN_SCALE_VALUE);
            Context context = this.context;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    int i2 = ServiceEnum.Chan.chan1.value1;
                    int i3 = HistogramSettingPopupView.this.getParam().getSourceA().value1;
                }
            });
            MutableLiveData<Object> mutableLiveData2 = this.syncDataViewModel.get(i, MessageID.MSG_CHAN_OFFSET_VALUE);
            Context context2 = this.context;
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    int i2 = ServiceEnum.Chan.chan1.value1;
                    int i3 = HistogramSettingPopupView.this.getParam().getSourceA().value1;
                }
            });
            MutableLiveData<Object> mutableLiveData3 = this.syncDataViewModel.get(i, MessageID.MSG_CHAN_UNIT);
            Context context3 = this.context;
            if (context3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (1 - i == ServiceEnum.Chan.chan1.value1 - HistogramSettingPopupView.this.getParam().getSourceA().value1) {
                        HistogramSettingPopupView.this.updateVerUnit(i);
                    }
                }
            });
        }
        MutableLiveData<Object> mutableLiveData4 = this.syncDataViewModel.get(10, MessageID.MSG_HOR_MAIN_SCALE);
        Context context4 = this.context;
        if (context4 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData4.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
            }
        });
        MutableLiveData<Object> mutableLiveData5 = this.syncDataViewModel.get(10, MessageID.MSG_HOR_MAIN_OFFSET);
        Context context5 = this.context;
        if (context5 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData5.observe((LifecycleOwner) context5, new Observer<Object>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
            }
        });
        MutableLiveData<Object> mutableLiveData6 = this.syncDataViewModel.get(34, MessageID.MSG_HISTO_EN);
        Context context6 = this.context;
        if (context6 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData6.observe((LifecycleOwner) context6, new Observer<Object>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.9
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HistogramSettingPopupView.this.getParam().readEnable();
            }
        });
        this.list_aorbParam.add(new AorBParam(this.binding.highposEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.dispgridEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.leftposEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.rightposEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam((TextView) this.binding.histogramEn, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.lowposEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceSpinner, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.histogramTypeSpinner, 0, true, ViewUtil.KEY_A, 3));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, new AorBManager.OnSetTextById() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.11
            @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
            public void onViewIdCallback(KeyEvent keyEvent, int i2, boolean z) {
                HistogramSettingPopupView.this.getParam().readHeightAttr();
                switch (i2) {
                    case R.id.dispgrid_edit_text /* 2131362689 */:
                        HistogramSettingPopupView.this.getParam().saveHeight(HistogramSettingPopupView.this.getParam().getIntStep(HistogramSettingPopupView.this.getParam().getHeight(), HistogramSettingPopupView.this.getParam().getHeightAttr(), z, keyEvent));
                        return;
                    case R.id.highpos_edit_text /* 2131363051 */:
                        HistogramSettingPopupView.this.getParam().saveRealTop(HistogramSettingPopupView.this.getParam().getLongStep(HistogramSettingPopupView.this.getParam().getRealTop(), HistogramSettingPopupView.this.getParam().getRealTopAttr(), z, keyEvent));
                        return;
                    case R.id.leftpos_edit_text /* 2131363312 */:
                        HistogramSettingPopupView.this.getParam().saveRealLeft(HistogramSettingPopupView.this.getParam().getLongStep(HistogramSettingPopupView.this.getParam().getRealLeft(), HistogramSettingPopupView.this.getParam().getRealLeftAttr(), z, keyEvent));
                        return;
                    case R.id.lowpos_edit_text /* 2131363344 */:
                        HistogramSettingPopupView.this.getParam().saveRealBottom(HistogramSettingPopupView.this.getParam().getLongStep(HistogramSettingPopupView.this.getParam().getRealBottom(), HistogramSettingPopupView.this.getParam().getRealBottomAttr(), z, keyEvent));
                        return;
                    case R.id.rightpos_edit_text /* 2131363765 */:
                        HistogramSettingPopupView.this.getParam().saveRealRight(HistogramSettingPopupView.this.getParam().getLongStep(HistogramSettingPopupView.this.getParam().getRealRight(), HistogramSettingPopupView.this.getParam().getRealRightAttr(), z, keyEvent));
                        return;
                    default:
                        return;
                }
            }
        }, new AorBManager.OnTextReset() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.12
            @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
            public void onResetDefault(int i2) {
                HistogramSettingPopupView.this.getParam().readRealLeft();
                HistogramSettingPopupView.this.getParam().readRealRight();
                HistogramSettingPopupView.this.getParam().readRealTop();
                HistogramSettingPopupView.this.getParam().readRealBottom();
                switch (i2) {
                    case R.id.dispgrid_edit_text /* 2131362689 */:
                        HistogramSettingPopupView.this.getParam().resetSaveHeight();
                        return;
                    case R.id.highpos_edit_text /* 2131363051 */:
                        HistogramSettingPopupView.this.getParam().resetSaveRealTop();
                        return;
                    case R.id.leftpos_edit_text /* 2131363312 */:
                        HistogramSettingPopupView.this.getParam().resetSaveRealLeft();
                        return;
                    case R.id.lowpos_edit_text /* 2131363344 */:
                        HistogramSettingPopupView.this.getParam().resetSaveRealBottom();
                        return;
                    case R.id.rightpos_edit_text /* 2131363765 */:
                        HistogramSettingPopupView.this.getParam().resetSaveRealRight();
                        return;
                    default:
                        return;
                }
            }
        }) { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.10
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                Context context7 = HistogramSettingPopupView.this.context;
                AorBParam aorBParam = getList_aorbParam().get(i2);
                Intrinsics.checkNotNullExpressionValue(aorBParam, "list_aorbParam[change_position]");
                EditText editText = aorBParam.getEditText();
                AorBParam aorBParam2 = getList_aorbParam().get(i2);
                Intrinsics.checkNotNullExpressionValue(aorBParam2, "list_aorbParam[change_position]");
                showKey(context7, editText, true, aorBParam2.getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                Context context7 = HistogramSettingPopupView.this.context;
                AorBParam aorBParam = getList_aorbParam().get(i2);
                Intrinsics.checkNotNullExpressionValue(aorBParam, "list_aorbParam[recovery_position]");
                EditText editText = aorBParam.getEditText();
                AorBParam aorBParam2 = getList_aorbParam().get(i2);
                Intrinsics.checkNotNullExpressionValue(aorBParam2, "list_aorbParam[recovery_position]");
                showKey(context7, editText, false, aorBParam2.getAorb());
            }
        };
        this.aorBManager = aorBManager;
        if (aorBManager != null) {
            aorBManager.showKey(this.context, this.binding.highposEditText, true, ViewUtil.KEY_A);
            AorBManager aorBManager2 = this.aorBManager;
            if (aorBManager2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.utilities.AorBManager");
            }
            aorBManager2.showKey(this.context, this.binding.dispgridEditText, true, ViewUtil.KEY_B);
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                Intrinsics.checkNotNull(panelKeyViewModel);
                MutableLiveData<KeyEvent> onKeyUpData = panelKeyViewModel.getOnKeyUpData();
                Activity topActivity3 = ActivityUtils.getTopActivity();
                if (topActivity3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                onKeyUpData.observe((LifecycleOwner) topActivity3, new Observer<KeyEvent>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.13
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(KeyEvent keyEvent) {
                        if (PopupViewManager.getInstance().isShowing(HistogramSettingPopupView.class)) {
                            PanelKeyViewModel panelKeyViewModel2 = HistogramSettingPopupView.this.panelKeyViewModel;
                            Intrinsics.checkNotNull(panelKeyViewModel2);
                            panelKeyViewModel2.abSwitch(keyEvent, HistogramSettingPopupView.this.clickedView, HistogramSettingPopupView.this.popupSpinner, HistogramSettingPopupView.this.mappingObjects, HistogramSettingPopupView.this.spinnerAdapter, HistogramSettingPopupView.this.aorBManager, HistogramSettingPopupView.this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.13.1
                                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                                public final void onCall(KeyboardPopupView keyboard) {
                                    Intrinsics.checkNotNullParameter(keyboard, "keyboard");
                                    HistogramSettingPopupView.this.keyboardPopupView = keyboard;
                                }
                            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView.13.2
                                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                                public final void onCall(int i2, MappingObject mappingObject) {
                                    LogUtils.e("position1", Integer.valueOf(i2), mappingObject);
                                }
                            });
                        }
                    }
                });
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.utilities.AorBManager");
    }

    public final HistogramResultParam getParam() {
        HistogramResultParam histogramResultParam = this.param;
        if (histogramResultParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("param");
        }
        return histogramResultParam;
    }

    public final void setParam(HistogramResultParam histogramResultParam) {
        Intrinsics.checkNotNullParameter(histogramResultParam, "<set-?>");
        this.param = histogramResultParam;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean z) {
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        int id = buttonView.getId();
        if (buttonView.isPressed()) {
            if (id != R.id.histogram_en) {
                if (id == R.id.none_radio_button && z) {
                    HistogramResultParam histogramResultParam = this.param;
                    if (histogramResultParam == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                    }
                    histogramResultParam.saveSource(ServiceEnum.Chan.chan_none);
                    return;
                }
                return;
            }
            Timber.d("Histogram:UI:SAVE:EN: Clicked", new Object[0]);
            HistogramResultParam histogramResultParam2 = this.param;
            if (histogramResultParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            HistogramResultParam histogramResultParam3 = this.param;
            if (histogramResultParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam2.saveEnable(!histogramResultParam3.getEnable());
        }
    }

    @Override // com.rigol.scope.views.baseview.BaseDeletePopupView, android.view.View.OnClickListener
    public void onClick(View v) {
        HistogramResultParam histogramResultParam;
        HistogramResultParam histogramResultParam2;
        Intrinsics.checkNotNullParameter(v, "v");
        int id = v.getId();
        if (id == R.id.enable) {
            Timber.d("Histogram:UI:SAVE:EN: Clicked", new Object[0]);
            HistogramResultParam histogramResultParam3 = this.param;
            if (histogramResultParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            if (this.param == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam3.saveEnable(!histogramResultParam2.getEnable());
        }
        switch (id) {
            case R.id.dispgrid_edit_text /* 2131362689 */:
                AorBManager aorBManager = this.aorBManager;
                if (aorBManager == null || !aorBManager.setClick_showab(id)) {
                    return;
                }
                HistogramResultParam histogramResultParam4 = this.param;
                if (histogramResultParam4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                histogramResultParam4.readHeightAttr();
                View view = this.anchor;
                ServiceEnum.Unit unit = ServiceEnum.Unit.Unit_Div;
                HistogramResultParam histogramResultParam5 = this.param;
                if (histogramResultParam5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long maxIntValue = histogramResultParam5.getHeightAttr().getMaxIntValue();
                HistogramResultParam histogramResultParam6 = this.param;
                if (histogramResultParam6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long minIntValue = histogramResultParam6.getHeightAttr().getMinIntValue();
                HistogramResultParam histogramResultParam7 = this.param;
                if (histogramResultParam7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long defIntValue = histogramResultParam7.getHeightAttr().getDefIntValue();
                if (this.param == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                ViewUtil.showKeyboard(view, v, unit, maxIntValue, minIntValue, defIntValue, histogramResultParam.getHeight(), new KeyboardListener() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView$onClick$3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        HistogramResultParam param = HistogramSettingPopupView.this.getParam();
                        if (t == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        param.saveHeight((int) ((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboard) {
                        Intrinsics.checkNotNullParameter(keyboard, "keyboard");
                        HistogramSettingPopupView.this.keyboardPopupView = keyboard;
                    }
                });
                return;
            case R.id.highpos_edit_text /* 2131363051 */:
                AorBManager aorBManager2 = this.aorBManager;
                if (aorBManager2 == null || !aorBManager2.setClick_showab(id)) {
                    return;
                }
                View view2 = this.anchor;
                HistogramResultParam histogramResultParam8 = this.param;
                if (histogramResultParam8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                ServiceEnum.Unit verUnit = histogramResultParam8.getVerUnit();
                HistogramResultParam histogramResultParam9 = this.param;
                if (histogramResultParam9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long maxLongValue = histogramResultParam9.getRealTopAttr().getMaxLongValue();
                HistogramResultParam histogramResultParam10 = this.param;
                if (histogramResultParam10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long minLongValue = histogramResultParam10.getRealTopAttr().getMinLongValue();
                HistogramResultParam histogramResultParam11 = this.param;
                if (histogramResultParam11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long defLongValue = histogramResultParam11.getRealTopAttr().getDefLongValue();
                HistogramResultParam histogramResultParam12 = this.param;
                if (histogramResultParam12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                ViewUtil.showKeyboard(view2, v, verUnit, maxLongValue, minLongValue, defLongValue, histogramResultParam12.getRealTop(), new KeyboardListener() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView$onClick$4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        HistogramResultParam param = HistogramSettingPopupView.this.getParam();
                        if (t == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        param.saveRealTop(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboard) {
                        Intrinsics.checkNotNullParameter(keyboard, "keyboard");
                        HistogramSettingPopupView.this.keyboardPopupView = keyboard;
                    }
                });
                return;
            case R.id.histo_reset /* 2131363054 */:
                HistogramResultParam histogramResultParam13 = this.param;
                if (histogramResultParam13 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                histogramResultParam13.resetHistoStatis();
                return;
            case R.id.histogram_type_spinner /* 2131363057 */:
                final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_histo_type);
                ViewUtil.showSpinner(this.anchor, v, list, new PopupSpinner.OnItemClickListener<MappingObject>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView$onClick$2
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
                        MappingObject mappingObject2 = (MappingObject) list.get(i);
                        Intrinsics.checkNotNullExpressionValue(mappingObject2, "mappingObject");
                        ServiceEnum.HistoType source = ServiceEnum.getHistoTypeFromValue1(mappingObject2.getValue());
                        HistogramResultParam param = HistogramSettingPopupView.this.getParam();
                        Intrinsics.checkNotNullExpressionValue(source, "source");
                        param.saveType(source);
                    }
                });
                return;
            case R.id.leftpos_edit_text /* 2131363312 */:
                AorBManager aorBManager3 = this.aorBManager;
                if (aorBManager3 == null || !aorBManager3.setClick_showab(id)) {
                    return;
                }
                View view3 = this.anchor;
                ServiceEnum.Unit unit2 = ServiceEnum.Unit.Unit_s;
                HistogramResultParam histogramResultParam14 = this.param;
                if (histogramResultParam14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long maxLongValue2 = histogramResultParam14.getRealLeftAttr().getMaxLongValue();
                HistogramResultParam histogramResultParam15 = this.param;
                if (histogramResultParam15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long minLongValue2 = histogramResultParam15.getRealLeftAttr().getMinLongValue();
                HistogramResultParam histogramResultParam16 = this.param;
                if (histogramResultParam16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long defLongValue2 = histogramResultParam16.getRealLeftAttr().getDefLongValue();
                HistogramResultParam histogramResultParam17 = this.param;
                if (histogramResultParam17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                ViewUtil.showKeyboard(view3, v, unit2, maxLongValue2, minLongValue2, defLongValue2, histogramResultParam17.getRealLeft(), new KeyboardListener() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView$onClick$6
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        HistogramResultParam param = HistogramSettingPopupView.this.getParam();
                        if (t == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        param.saveRealLeft(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboard) {
                        Intrinsics.checkNotNullParameter(keyboard, "keyboard");
                        HistogramSettingPopupView.this.keyboardPopupView = keyboard;
                    }
                });
                return;
            case R.id.lowpos_edit_text /* 2131363344 */:
                AorBManager aorBManager4 = this.aorBManager;
                if (aorBManager4 == null || !aorBManager4.setClick_showab(id)) {
                    return;
                }
                View view4 = this.anchor;
                HistogramResultParam histogramResultParam18 = this.param;
                if (histogramResultParam18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                ServiceEnum.Unit verUnit2 = histogramResultParam18.getVerUnit();
                HistogramResultParam histogramResultParam19 = this.param;
                if (histogramResultParam19 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long maxLongValue3 = histogramResultParam19.getRealBottomAttr().getMaxLongValue();
                HistogramResultParam histogramResultParam20 = this.param;
                if (histogramResultParam20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long minLongValue3 = histogramResultParam20.getRealBottomAttr().getMinLongValue();
                HistogramResultParam histogramResultParam21 = this.param;
                if (histogramResultParam21 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long defLongValue3 = histogramResultParam21.getRealBottomAttr().getDefLongValue();
                HistogramResultParam histogramResultParam22 = this.param;
                if (histogramResultParam22 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                ViewUtil.showKeyboard(view4, v, verUnit2, maxLongValue3, minLongValue3, defLongValue3, histogramResultParam22.getRealBottom(), new KeyboardListener() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView$onClick$5
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        HistogramResultParam param = HistogramSettingPopupView.this.getParam();
                        if (t == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        param.saveRealBottom(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboard) {
                        Intrinsics.checkNotNullParameter(keyboard, "keyboard");
                        HistogramSettingPopupView.this.keyboardPopupView = keyboard;
                    }
                });
                return;
            case R.id.rightpos_edit_text /* 2131363765 */:
                AorBManager aorBManager5 = this.aorBManager;
                if (aorBManager5 == null || !aorBManager5.setClick_showab(id)) {
                    return;
                }
                View view5 = this.anchor;
                ServiceEnum.Unit unit3 = ServiceEnum.Unit.Unit_s;
                HistogramResultParam histogramResultParam23 = this.param;
                if (histogramResultParam23 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long maxLongValue4 = histogramResultParam23.getRealRightAttr().getMaxLongValue();
                HistogramResultParam histogramResultParam24 = this.param;
                if (histogramResultParam24 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long minLongValue4 = histogramResultParam24.getRealRightAttr().getMinLongValue();
                HistogramResultParam histogramResultParam25 = this.param;
                if (histogramResultParam25 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                long defLongValue4 = histogramResultParam25.getRealRightAttr().getDefLongValue();
                HistogramResultParam histogramResultParam26 = this.param;
                if (histogramResultParam26 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                }
                ViewUtil.showKeyboard(view5, v, unit3, maxLongValue4, minLongValue4, defLongValue4, histogramResultParam26.getRealRight(), new KeyboardListener() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView$onClick$7
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        HistogramResultParam param = HistogramSettingPopupView.this.getParam();
                        if (t == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        param.saveRealRight(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboard) {
                        Intrinsics.checkNotNullParameter(keyboard, "keyboard");
                        HistogramSettingPopupView.this.keyboardPopupView = keyboard;
                    }
                });
                return;
            case R.id.source_spinner /* 2131363901 */:
                final List<MappingObject> filterChan = ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_chan_list));
                ViewUtil.showChanSpinner(this.anchor, v, filterChan, new PopupSpinner.OnItemClickListener<MappingObject>() { // from class: com.rigol.scope.views.histogram.HistogramSettingPopupView$onClick$1
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view6, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
                        MappingObject mappingObject2 = (MappingObject) filterChan.get(i);
                        Intrinsics.checkNotNullExpressionValue(mappingObject2, "mappingObject");
                        ServiceEnum.Chan source = ServiceEnum.getChanFromValue1(mappingObject2.getValue());
                        HistogramResultParam param = HistogramSettingPopupView.this.getParam();
                        Intrinsics.checkNotNullExpressionValue(source, "source");
                        param.saveSource(source);
                    }
                });
                return;
            default:
                return;
        }
    }

    public final void updateTopAttr(int i) {
        VerticalParam verticalParamByServiceID = getVerticalParamByServiceID(i);
        if (verticalParamByServiceID != null) {
            HistogramResultParam histogramResultParam = this.param;
            if (histogramResultParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam.getTopAttr().setMaxValue(((verticalParamByServiceID.getScale() * 8) / 2) - verticalParamByServiceID.getOffset());
            HistogramResultParam histogramResultParam2 = this.param;
            if (histogramResultParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            MessageAttr topAttr = histogramResultParam2.getTopAttr();
            HistogramResultParam histogramResultParam3 = this.param;
            if (histogramResultParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            topAttr.setMinValue(histogramResultParam3.getBottom() + (verticalParamByServiceID.getScale() / 50));
            HistogramResultParam histogramResultParam4 = this.param;
            if (histogramResultParam4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam4.getTopAttr().setDefValue(verticalParamByServiceID.getOffset() + verticalParamByServiceID.getScale());
        }
    }

    public final void updateBottomAttr(int i) {
        VerticalParam verticalParamByServiceID = getVerticalParamByServiceID(i);
        if (verticalParamByServiceID != null) {
            HistogramResultParam histogramResultParam = this.param;
            if (histogramResultParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            MessageAttr bottomAttr = histogramResultParam.getBottomAttr();
            HistogramResultParam histogramResultParam2 = this.param;
            if (histogramResultParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            bottomAttr.setMaxValue(histogramResultParam2.getTop() - (verticalParamByServiceID.getScale() / 50));
            HistogramResultParam histogramResultParam3 = this.param;
            if (histogramResultParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam3.getBottomAttr().setMinValue(((verticalParamByServiceID.getScale() * (-8)) / 2) - verticalParamByServiceID.getOffset());
            HistogramResultParam histogramResultParam4 = this.param;
            if (histogramResultParam4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam4.getBottomAttr().setDefValue(verticalParamByServiceID.getOffset() - verticalParamByServiceID.getScale());
        }
    }

    public final void updateLeftAttr() {
        HorizontalParam horParam = getHorParam();
        if (horParam != null) {
            HistogramResultParam histogramResultParam = this.param;
            if (histogramResultParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            MessageAttr leftAttr = histogramResultParam.getLeftAttr();
            HistogramResultParam histogramResultParam2 = this.param;
            if (histogramResultParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            leftAttr.setMaxValue(histogramResultParam2.getRight() - (horParam.getMainScale() / 100));
            HistogramResultParam histogramResultParam3 = this.param;
            if (histogramResultParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam3.getLeftAttr().setMinValue(((horParam.getMainScale() * (-10)) / 2) + horParam.getMainOffset());
            HistogramResultParam histogramResultParam4 = this.param;
            if (histogramResultParam4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam4.getLeftAttr().setDefValue(horParam.getMainOffset() - horParam.getMainScale());
        }
    }

    public final void updateRightAttr() {
        HorizontalParam horParam = getHorParam();
        if (horParam != null) {
            HistogramResultParam histogramResultParam = this.param;
            if (histogramResultParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam.getRightAttr().setMaxValue(((horParam.getMainScale() * 10) / 2) + horParam.getMainOffset());
            HistogramResultParam histogramResultParam2 = this.param;
            if (histogramResultParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            MessageAttr rightAttr = histogramResultParam2.getRightAttr();
            HistogramResultParam histogramResultParam3 = this.param;
            if (histogramResultParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            rightAttr.setMinValue(histogramResultParam3.getLeft() + (horParam.getMainScale() / 100));
            HistogramResultParam histogramResultParam4 = this.param;
            if (histogramResultParam4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam4.getRightAttr().setDefValue(horParam.getMainOffset() + horParam.getMainScale());
        }
    }

    public final void updateVerUnit(int i) {
        VerticalParam verticalParamByServiceID = getVerticalParamByServiceID(i);
        if (verticalParamByServiceID != null) {
            HistogramResultParam histogramResultParam = this.param;
            if (histogramResultParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("param");
            }
            histogramResultParam.setVerUnit(verticalParamByServiceID.getUnit());
        }
    }

    public final VerticalParam getVerticalParamByServiceID(int i) {
        ArrayList<VerticalParam> value;
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel == null || (value = verticalViewModel.getLiveData().getValue()) == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(value, "verticalViewModel.liveData.value ?: return null");
        return value.get(i - 1);
    }

    public final int getServiceIDByChan(ServiceEnum.Chan chan) {
        if (chan != null) {
            int i = WhenMappings.$EnumSwitchMapping$0[chan.ordinal()];
            if (i == 1) {
                return 1;
            }
            if (i == 2) {
                return 2;
            }
            if (i == 3) {
                return 3;
            }
            if (i == 4) {
                return 4;
            }
        }
        return 0;
    }

    public final HorizontalParam getHorParam() {
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null) {
            return horizontalViewModel.getLiveData().getValue();
        }
        return null;
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }
}
