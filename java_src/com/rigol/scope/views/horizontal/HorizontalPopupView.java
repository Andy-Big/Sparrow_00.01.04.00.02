package com.rigol.scope.views.horizontal;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.WaveformFragment;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.Roll;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.PopupviewHorizontalBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.vertical.VerticalPopupView;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HorizontalPopupView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000º\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020O2\u0006\u0010P\u001a\u00020QH\u0016J\u0010\u0010R\u001a\u00020M2\u0006\u0010S\u001a\u00020\u0012H\u0016J\b\u0010T\u001a\u00020MH\u0016J\u0010\u0010U\u001a\u00020M2\u0006\u0010V\u001a\u00020WH\u0016J \u0010X\u001a\u00020M2\u0006\u0010Y\u001a\u00020Z2\u0006\u0010V\u001a\u00020W2\u0006\u0010[\u001a\u00020QH\u0016J\b\u0010\\\u001a\u00020MH\u0002J\u0010\u0010]\u001a\u00020M2\u0006\u0010^\u001a\u00020%H\u0002J\u0010\u0010_\u001a\u00020M2\u0006\u0010^\u001a\u00020%H\u0002J\u0010\u0010`\u001a\u00020M2\u0006\u0010^\u001a\u00020%H\u0002J\u0010\u0010a\u001a\u00020M2\u0006\u0010^\u001a\u00020%H\u0002J,\u0010b\u001a\u00020M2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010S\u001a\u00020\u00122\f\u0010c\u001a\b\u0012\u0004\u0012\u00020%0dH\u0002R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR!\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u001f0\u001ej\b\u0012\u0004\u0012\u00020\u001f` ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\"\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001c\u0010:\u001a\u0004\u0018\u00010;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u001c\u0010@\u001a\u0004\u0018\u00010AX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010K¨\u0006e"}, d2 = {"Lcom/rigol/scope/views/horizontal/HorizontalPopupView;", "Lcom/rigol/scope/views/baseview/BasePopupView;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/view/View$OnClickListener;", "Lcom/rigol/scope/utilities/AorBManager$OnSetTextById;", "Lcom/rigol/scope/utilities/AorBManager$OnTextReset;", "()V", "aorBManager", "Lcom/rigol/scope/utilities/AorBManager;", "getAorBManager", "()Lcom/rigol/scope/utilities/AorBManager;", "setAorBManager", "(Lcom/rigol/scope/utilities/AorBManager;)V", "binding", "Lcom/rigol/scope/databinding/PopupviewHorizontalBinding;", "bodeParam", "Lcom/rigol/scope/data/BodeParam;", "clickedView", "Landroid/view/View;", "getClickedView", "()Landroid/view/View;", "setClickedView", "(Landroid/view/View;)V", "keyboardPopupView", "Lcom/rigol/scope/views/keyboard/KeyboardPopupView;", "getKeyboardPopupView", "()Lcom/rigol/scope/views/keyboard/KeyboardPopupView;", "setKeyboardPopupView", "(Lcom/rigol/scope/views/keyboard/KeyboardPopupView;)V", "list_aorbParam", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/AorBParam;", "Lkotlin/collections/ArrayList;", "getList_aorbParam", "()Ljava/util/ArrayList;", "mappingObjects", "", "Lcom/rigol/scope/data/MappingObject;", "getMappingObjects", "()Ljava/util/List;", "setMappingObjects", "(Ljava/util/List;)V", "measureSettingParam", "Lcom/rigol/scope/data/MeasureSettingParam;", "panelKeyViewModel", "Lcom/rigol/scope/viewmodels/PanelKeyViewModel;", "getPanelKeyViewModel", "()Lcom/rigol/scope/viewmodels/PanelKeyViewModel;", "setPanelKeyViewModel", "(Lcom/rigol/scope/viewmodels/PanelKeyViewModel;)V", "param", "Lcom/rigol/scope/data/HorizontalParam;", "popupSpinner", "Lcom/rigol/scope/views/spinner/PopupSpinner;", "getPopupSpinner", "()Lcom/rigol/scope/views/spinner/PopupSpinner;", "setPopupSpinner", "(Lcom/rigol/scope/views/spinner/PopupSpinner;)V", "spinnerAdapter", "Lcom/rigol/scope/adapters/SpinnerAdapter;", "getSpinnerAdapter", "()Lcom/rigol/scope/adapters/SpinnerAdapter;", "setSpinnerAdapter", "(Lcom/rigol/scope/adapters/SpinnerAdapter;)V", "waveformFragment", "Lcom/rigol/scope/WaveformFragment;", "getWaveformFragment", "()Lcom/rigol/scope/WaveformFragment;", "setWaveformFragment", "(Lcom/rigol/scope/WaveformFragment;)V", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "getWindowParam", "()Lcom/rigol/scope/data/WindowParam;", "setWindowParam", "(Lcom/rigol/scope/data/WindowParam;)V", "onCheckedChanged", "", "buttonView", "Landroid/widget/CompoundButton;", "isChecked", "", "onClick", "v", "onLocaleChanged", "onResetDefault", "viewId", "", "onViewIdCallback", "keyEvent", "Landroid/view/KeyEvent;", "isRoll", "refreshUltraAndXYStatus", "selectBandWidth", "item", "selectDisplay", "selectExpand", "selectMemDepth", "spinnerClick", "onSpinnerClickListener", "Lcom/rigol/scope/utilities/AorBManager$OnSpinnerClickListener;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HorizontalPopupView extends BasePopupView implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    private PopupviewHorizontalBinding binding;
    private BodeParam bodeParam;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    private final ArrayList<AorBParam> list_aorbParam;
    private List<? extends MappingObject> mappingObjects;
    private MeasureSettingParam measureSettingParam;
    private PanelKeyViewModel panelKeyViewModel;
    private final HorizontalParam param;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;
    private WaveformFragment waveformFragment;
    private WindowParam windowParam;

    public HorizontalPopupView() {
        super((int) R.style.App_PopupWindow_Horizontal);
        MutableLiveData<KeyEvent> onKeyUpData;
        MutableLiveData<Object> mutableLiveData;
        LiveData<MeasureSettingParam> liveData;
        LiveData<HorizontalParam> liveData2;
        this.list_aorbParam = new ArrayList<>();
        this.mappingObjects = new ArrayList();
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.param = (horizontalViewModel == null || (liveData2 = horizontalViewModel.getLiveData()) == null) ? null : liveData2.getValue();
        PopupviewHorizontalBinding inflate = PopupviewHorizontalBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "PopupviewHorizontalBindi…utInflater.from(context))");
        this.binding = inflate;
        setContentView(inflate.getRoot());
        BodeViewModel bodeViewModel = (BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class);
        this.bodeParam = bodeViewModel != null ? bodeViewModel.getValue() : null;
        this.binding.setParam(this.param);
        this.binding.setBodeParam(this.bodeParam);
        this.binding.setFunctionManager(FunctionManager.getInstance());
        this.binding.setClickListener(this);
        this.binding.setCheckedChangeListener(this);
        this.binding.setNormalMappingObj(ViewUtil.getMappingObject(R.array.msg_acq_mode, ServiceEnum.AcquireMode.Acquire_Normal.value1));
        this.binding.setAverageMappingObj(ViewUtil.getMappingObject(R.array.msg_acq_mode, ServiceEnum.AcquireMode.Acquire_Average.value1));
        this.binding.setPeakMappingObj(ViewUtil.getMappingObject(R.array.msg_acq_mode, ServiceEnum.AcquireMode.Acquire_Peak.value1));
        this.binding.setHresMappingObj(ViewUtil.getMappingObject(R.array.msg_acq_mode, ServiceEnum.AcquireMode.Acquire_HighResolution.value1));
        this.binding.setUltraMappingObj(ViewUtil.getMappingObject(R.array.msg_acq_mode, ServiceEnum.AcquireMode.Acquire_Ultra.value1));
        this.binding.setAutoMappingObj(ViewUtil.getMappingObject(R.array.msg_hor_auto_roll, Roll.AUTO.getValue()));
        this.binding.setOffMappingObj(ViewUtil.getMappingObject(R.array.msg_hor_auto_roll, Roll.OFF.getValue()));
        ViewUtil.setSwitchButton(this.binding.histogramEn);
        ViewUtil.setSwitchButton(this.binding.fineOnSwitch);
        ViewUtil.setSwitchButton(this.binding.zoomOnSwitch);
        ViewUtil.setSwitchButton(R.array.tek_msg_hor_delay_sample, this.binding.delaySample);
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null && (liveData = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData.observe((LifecycleOwner) topActivity, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView.1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        HorizontalPopupView.this.measureSettingParam = measureSettingParam;
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        this.binding.verticalSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().show(VerticalPopupView.class);
            }
        });
        CheckBox checkBox = this.binding.xyCheck;
        Intrinsics.checkNotNullExpressionValue(checkBox, "binding.xyCheck");
        RadioButton radioButton = this.binding.ultraRadioButton;
        Intrinsics.checkNotNullExpressionValue(radioButton, "binding.ultraRadioButton");
        checkBox.setEnabled(!radioButton.isChecked());
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE)) != null) {
            Context context = this.context;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView.3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    HorizontalPopupView.this.refreshUltraAndXYStatus();
                }
            });
        }
        this.list_aorbParam.add(new AorBParam(this.binding.mainScaleEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.mainOffsetEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.avgTimesEditText, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.zoomScaleEditText, 0, false, ViewUtil.KEY_A, 1));
        this.list_aorbParam.add(new AorBParam(this.binding.zoomOffsetEditText, 0, false, ViewUtil.KEY_A, 1));
        this.list_aorbParam.add(new AorBParam(this.binding.expandUserEditText, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.maxFrameEdit, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.timeOutEdit, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.memdepthSpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.expandSpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.highBitSpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.displaySpinner, 0, false, "", 2));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView.4
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                AorBManager aorBManager2 = HorizontalPopupView.this.getAorBManager();
                if (aorBManager2 != null) {
                    Context context2 = HorizontalPopupView.this.context;
                    AorBParam aorBParam = getList_aorbParam().get(i);
                    Intrinsics.checkNotNullExpressionValue(aorBParam, "list_aorbParam.get(change_position)");
                    EditText editText = aorBParam.getEditText();
                    AorBParam aorBParam2 = getList_aorbParam().get(i);
                    Intrinsics.checkNotNullExpressionValue(aorBParam2, "list_aorbParam.get(change_position)");
                    aorBManager2.showKey(context2, editText, true, aorBParam2.getAorb());
                }
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                AorBManager aorBManager2 = HorizontalPopupView.this.getAorBManager();
                if (aorBManager2 != null) {
                    Context context2 = HorizontalPopupView.this.context;
                    AorBParam aorBParam = getList_aorbParam().get(i);
                    Intrinsics.checkNotNullExpressionValue(aorBParam, "list_aorbParam.get(recovery_position)");
                    EditText editText = aorBParam.getEditText();
                    AorBParam aorBParam2 = getList_aorbParam().get(i);
                    Intrinsics.checkNotNullExpressionValue(aorBParam2, "list_aorbParam.get(recovery_position)");
                    aorBManager2.showKey(context2, editText, false, aorBParam2.getAorb());
                }
            }
        };
        this.aorBManager = aorBManager;
        if (aorBManager != null) {
            aorBManager.showKey(this.context, this.binding.mainScaleEditText, true, ViewUtil.KEY_A);
        }
        AorBManager aorBManager2 = this.aorBManager;
        if (aorBManager2 != null) {
            aorBManager2.showKey(this.context, this.binding.mainOffsetEditText, true, ViewUtil.KEY_B);
        }
        PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        this.panelKeyViewModel = panelKeyViewModel;
        if (panelKeyViewModel != null && (onKeyUpData = panelKeyViewModel.getOnKeyUpData()) != null) {
            Context context2 = this.context;
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            onKeyUpData.observe((LifecycleOwner) context2, new Observer<KeyEvent>() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(KeyEvent keyEvent) {
                    if (PopupViewManager.getInstance().isShowing(HorizontalPopupView.class)) {
                        PanelKeyViewModel panelKeyViewModel2 = HorizontalPopupView.this.getPanelKeyViewModel();
                        Intrinsics.checkNotNull(panelKeyViewModel2);
                        panelKeyViewModel2.abSwitch(keyEvent, HorizontalPopupView.this.getClickedView(), HorizontalPopupView.this.getPopupSpinner(), HorizontalPopupView.this.getMappingObjects(), HorizontalPopupView.this.getSpinnerAdapter(), HorizontalPopupView.this.getAorBManager(), HorizontalPopupView.this.getKeyboardPopupView(), new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView.5.1
                            @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                            public final void onCall(KeyboardPopupView keyboardPopupView) {
                                HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                            }
                        }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView.5.2
                            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                            public final void onCall(int i, MappingObject mappingObject) {
                                View clickedView = HorizontalPopupView.this.getClickedView();
                                Integer valueOf = clickedView != null ? Integer.valueOf(clickedView.getId()) : null;
                                if (valueOf != null && valueOf.intValue() == R.id.memdepth_spinner) {
                                    HorizontalPopupView horizontalPopupView = HorizontalPopupView.this;
                                    Intrinsics.checkNotNullExpressionValue(mappingObject, "mappingObject");
                                    horizontalPopupView.selectMemDepth(mappingObject);
                                } else if (valueOf != null && valueOf.intValue() == R.id.expand_spinner) {
                                    HorizontalPopupView horizontalPopupView2 = HorizontalPopupView.this;
                                    Intrinsics.checkNotNullExpressionValue(mappingObject, "mappingObject");
                                    horizontalPopupView2.selectExpand(mappingObject);
                                } else if (valueOf != null && valueOf.intValue() == R.id.high_bit_spinner) {
                                    HorizontalPopupView horizontalPopupView3 = HorizontalPopupView.this;
                                    Intrinsics.checkNotNullExpressionValue(mappingObject, "mappingObject");
                                    horizontalPopupView3.selectBandWidth(mappingObject);
                                } else if (valueOf != null && valueOf.intValue() == R.id.displaySpinner) {
                                    HorizontalPopupView horizontalPopupView4 = HorizontalPopupView.this;
                                    Intrinsics.checkNotNullExpressionValue(mappingObject, "mappingObject");
                                    horizontalPopupView4.selectDisplay(mappingObject);
                                }
                            }
                        });
                    }
                }
            });
        }
        if (this.windowParam == null) {
            WindowParam windowParam = new WindowParam();
            this.windowParam = windowParam;
            if (windowParam != null) {
                windowParam.setType(ServiceEnum.WindowType.WIN_XY);
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 != null) {
                windowParam2.setServiceID(56);
            }
            WindowParam windowParam3 = this.windowParam;
            if (windowParam3 != null) {
                windowParam3.setSource1(ServiceEnum.Chan.chan1);
            }
            WindowParam windowParam4 = this.windowParam;
            if (windowParam4 != null) {
                windowParam4.setSource2(ServiceEnum.Chan.chan2);
            }
            WindowParam windowParam5 = this.windowParam;
            if (windowParam5 != null) {
                windowParam5.setSource3(ServiceEnum.Chan.chan_none);
            }
        }
        Context context3 = this.context;
        if (context3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.MainActivity");
        }
        this.waveformFragment = ((MainActivity) context3).getWaveformFragment();
    }

    public final PanelKeyViewModel getPanelKeyViewModel() {
        return this.panelKeyViewModel;
    }

    public final void setPanelKeyViewModel(PanelKeyViewModel panelKeyViewModel) {
        this.panelKeyViewModel = panelKeyViewModel;
    }

    public final AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public final void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public final ArrayList<AorBParam> getList_aorbParam() {
        return this.list_aorbParam;
    }

    public final PopupSpinner getPopupSpinner() {
        return this.popupSpinner;
    }

    public final void setPopupSpinner(PopupSpinner popupSpinner) {
        this.popupSpinner = popupSpinner;
    }

    public final View getClickedView() {
        return this.clickedView;
    }

    public final void setClickedView(View view) {
        this.clickedView = view;
    }

    public final List<MappingObject> getMappingObjects() {
        return this.mappingObjects;
    }

    public final void setMappingObjects(List<? extends MappingObject> list) {
        this.mappingObjects = list;
    }

    public final SpinnerAdapter getSpinnerAdapter() {
        return this.spinnerAdapter;
    }

    public final void setSpinnerAdapter(SpinnerAdapter spinnerAdapter) {
        this.spinnerAdapter = spinnerAdapter;
    }

    public final KeyboardPopupView getKeyboardPopupView() {
        return this.keyboardPopupView;
    }

    public final void setKeyboardPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public final WindowParam getWindowParam() {
        return this.windowParam;
    }

    public final void setWindowParam(WindowParam windowParam) {
        this.windowParam = windowParam;
    }

    public final WaveformFragment getWaveformFragment() {
        return this.waveformFragment;
    }

    public final void setWaveformFragment(WaveformFragment waveformFragment) {
        this.waveformFragment = waveformFragment;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton buttonView, boolean z) {
        ServiceEnum.AcquireDepth depth;
        WaveformFragment waveformFragment;
        AorBManager aorBManager;
        Intrinsics.checkNotNullParameter(buttonView, "buttonView");
        if (buttonView.isPressed()) {
            switch (buttonView.getId()) {
                case R.id.auto_radio_button /* 2131361987 */:
                    AorBManager aorBManager2 = this.aorBManager;
                    if (aorBManager2 != null) {
                        aorBManager2.set_RadioButton();
                    }
                    HorizontalParam horizontalParam = this.param;
                    if (horizontalParam != null) {
                        horizontalParam.saveRoll(Roll.AUTO.getValue());
                        return;
                    }
                    return;
                case R.id.average_radio_button /* 2131361992 */:
                    AorBManager aorBManager3 = this.aorBManager;
                    if (aorBManager3 != null) {
                        aorBManager3.set_RadioButton();
                    }
                    HorizontalParam horizontalParam2 = this.param;
                    if (horizontalParam2 != null) {
                        horizontalParam2.saveAcquireMode(ServiceEnum.AcquireMode.Acquire_Average);
                    }
                    int i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                    HorizontalParam horizontalParam3 = this.param;
                    Integer valueOf = (horizontalParam3 == null || (depth = horizontalParam3.getDepth()) == null) ? null : Integer.valueOf(depth.value1);
                    Intrinsics.checkNotNull(valueOf);
                    if (i < valueOf.intValue()) {
                        this.param.saveDepth(ServiceEnum.AcquireDepth.Acquire_Depth_50M);
                    }
                    refreshUltraAndXYStatus();
                    return;
                case R.id.delay_sample /* 2131362660 */:
                    HorizontalParam horizontalParam4 = this.param;
                    if (horizontalParam4 != null) {
                        horizontalParam4.saveDelaySample(z);
                        return;
                    }
                    return;
                case R.id.fine_on_switch /* 2131362958 */:
                    HorizontalParam horizontalParam5 = this.param;
                    if (horizontalParam5 != null) {
                        horizontalParam5.saveFine(z);
                        return;
                    }
                    return;
                case R.id.histogram_en /* 2131363055 */:
                    HorizontalParam horizontalParam6 = this.param;
                    if (horizontalParam6 != null) {
                        horizontalParam6.saveAntiAliasing(z);
                        return;
                    }
                    return;
                case R.id.hres_radio_button /* 2131363081 */:
                    AorBManager aorBManager4 = this.aorBManager;
                    if (aorBManager4 != null) {
                        aorBManager4.set_RadioButton();
                    }
                    HorizontalParam horizontalParam7 = this.param;
                    if (horizontalParam7 != null) {
                        horizontalParam7.saveAcquireMode(ServiceEnum.AcquireMode.Acquire_HighResolution);
                    }
                    refreshUltraAndXYStatus();
                    return;
                case R.id.normal_radio_button /* 2131363483 */:
                    AorBManager aorBManager5 = this.aorBManager;
                    if (aorBManager5 != null) {
                        aorBManager5.set_RadioButton();
                    }
                    HorizontalParam horizontalParam8 = this.param;
                    if (horizontalParam8 != null) {
                        horizontalParam8.saveAcquireMode(ServiceEnum.AcquireMode.Acquire_Normal);
                    }
                    refreshUltraAndXYStatus();
                    return;
                case R.id.off_radio_button /* 2131363499 */:
                    AorBManager aorBManager6 = this.aorBManager;
                    if (aorBManager6 != null) {
                        aorBManager6.set_RadioButton();
                    }
                    HorizontalParam horizontalParam9 = this.param;
                    if (horizontalParam9 != null) {
                        horizontalParam9.saveRoll(Roll.OFF.getValue());
                        return;
                    }
                    return;
                case R.id.peak_radio_button /* 2131363560 */:
                    AorBManager aorBManager7 = this.aorBManager;
                    if (aorBManager7 != null) {
                        aorBManager7.set_RadioButton();
                    }
                    HorizontalParam horizontalParam10 = this.param;
                    if (horizontalParam10 != null) {
                        horizontalParam10.saveAcquireMode(ServiceEnum.AcquireMode.Acquire_Peak);
                    }
                    refreshUltraAndXYStatus();
                    return;
                case R.id.ultra_radio_button /* 2131364485 */:
                    AorBManager aorBManager8 = this.aorBManager;
                    if (aorBManager8 != null) {
                        aorBManager8.set_RadioButton();
                    }
                    HorizontalParam horizontalParam11 = this.param;
                    if (horizontalParam11 != null) {
                        horizontalParam11.saveAcquireMode(ServiceEnum.AcquireMode.Acquire_Ultra);
                    }
                    MeasureSettingParam measureSettingParam = this.measureSettingParam;
                    if (measureSettingParam != null) {
                        measureSettingParam.saveCursorIndicator(false);
                    }
                    MeasureSettingParam measureSettingParam2 = this.measureSettingParam;
                    if (measureSettingParam2 != null) {
                        measureSettingParam2.saveCursorThreshold(false);
                    }
                    refreshUltraAndXYStatus();
                    return;
                case R.id.xyCheck /* 2131364705 */:
                    this.binding.xyCheck.jumpDrawablesToCurrentState();
                    if (z) {
                        if ((this.context instanceof MainActivity) && (waveformFragment = this.waveformFragment) != null) {
                            waveformFragment.addWindow(this.windowParam);
                        }
                    } else {
                        FunctionManager.getInstance().xySwitch = false;
                        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_XY);
                    }
                    HorizontalParam horizontalParam12 = this.param;
                    if (horizontalParam12 != null) {
                        horizontalParam12.setXyCheck(z);
                    }
                    refreshUltraAndXYStatus();
                    return;
                case R.id.zoom_on_switch /* 2131364751 */:
                    if (!z && (aorBManager = this.aorBManager) != null) {
                        aorBManager.set_switch_show(R.id.zoom_on_switch);
                    }
                    HorizontalParam horizontalParam13 = this.param;
                    if (horizontalParam13 != null) {
                        horizontalParam13.saveZoom(z);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private final void spinnerClick(List<? extends MappingObject> list, View view, final AorBManager.OnSpinnerClickListener<MappingObject> onSpinnerClickListener) {
        if (this.anchor != null) {
            ViewUtil.showSpinner(this.anchor, view, (List<MappingObject>) list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$spinnerClick$1
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List<MappingObject> list2, View view2) {
                    HorizontalPopupView.this.setPopupSpinner(popupSpinner);
                    HorizontalPopupView.this.setSpinnerAdapter(spinnerAdapter);
                    HorizontalPopupView.this.setMappingObjects(list2);
                    HorizontalPopupView.this.setClickedView(view2);
                }
            }, new PopupSpinner.OnItemClickListener<MappingObject>() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$spinnerClick$2
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
                    AorBManager.OnSpinnerClickListener.this.onSpinnerClick(mappingObject);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectMemDepth(MappingObject mappingObject) {
        ServiceEnum.AcquireDepth depth = ServiceEnum.getAcquireDepthFromValue1(mappingObject.getValue());
        HorizontalParam horizontalParam = this.param;
        if (horizontalParam != null) {
            Intrinsics.checkNotNullExpressionValue(depth, "depth");
            horizontalParam.saveDepth(depth);
        }
        HorizontalParam horizontalParam2 = this.param;
        Long valueOf = horizontalParam2 != null ? Long.valueOf(horizontalParam2.getMaxFrame()) : null;
        Intrinsics.checkNotNull(valueOf);
        if (valueOf.longValue() > this.param.getMaxFrameAttr().getMaxLongValue()) {
            HorizontalParam horizontalParam3 = this.param;
            horizontalParam3.saveMaxFrame(horizontalParam3.getMaxFrameAttr().getMaxLongValue());
            return;
        }
        HorizontalParam horizontalParam4 = this.param;
        horizontalParam4.saveMaxFrame(horizontalParam4.getMaxFrame());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectExpand(MappingObject mappingObject) {
        ServiceEnum.HorizontalExpand expandMode = ServiceEnum.getHorizontalExpandFromValue1(mappingObject.getValue());
        HorizontalParam horizontalParam = this.param;
        if (horizontalParam != null) {
            Intrinsics.checkNotNullExpressionValue(expandMode, "expandMode");
            horizontalParam.saveExpandMode(expandMode);
        }
        AorBManager aorBManager = this.aorBManager;
        if (aorBManager != null) {
            aorBManager.set_RadioButton();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectBandWidth(MappingObject mappingObject) {
        ServiceEnum.HighResBit highResBit = ServiceEnum.getHighResBitFromValue1(mappingObject.getValue());
        HorizontalParam horizontalParam = this.param;
        if (horizontalParam != null) {
            Intrinsics.checkNotNullExpressionValue(highResBit, "highResBit");
            horizontalParam.saveHighBits(highResBit);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void selectDisplay(MappingObject mappingObject) {
        HorizontalParam horizontalParam = this.param;
        if (horizontalParam != null) {
            horizontalParam.saveDisplay(mappingObject.getValue());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Boolean valueOf;
        Intrinsics.checkNotNullParameter(v, "v");
        if (this.param == null) {
            return;
        }
        this.clickedView = v;
        int id = v.getId();
        if (id == R.id.memdepth_spinner) {
            List<MappingObject> depthMappings = ViewUtil.getDepthSpinnerList();
            Intrinsics.checkNotNullExpressionValue(depthMappings, "depthMappings");
            spinnerClick(depthMappings, v, new AorBManager.OnSpinnerClickListener<MappingObject>() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$1
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerClickListener
                public final void onSpinnerClick(MappingObject it) {
                    HorizontalPopupView horizontalPopupView = HorizontalPopupView.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    horizontalPopupView.selectMemDepth(it);
                }
            });
        } else if (id == R.id.expand_spinner) {
            List<MappingObject> list = ViewUtil.getList((int) R.array.msg_hor_expand);
            Intrinsics.checkNotNullExpressionValue(list, "ViewUtil.getList(R.array.msg_hor_expand)");
            spinnerClick(list, v, new AorBManager.OnSpinnerClickListener<MappingObject>() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$2
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerClickListener
                public final void onSpinnerClick(MappingObject it) {
                    HorizontalPopupView horizontalPopupView = HorizontalPopupView.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    horizontalPopupView.selectExpand(it);
                }
            });
        } else if (id == R.id.high_bit_spinner) {
            List<MappingObject> listBIt = ViewUtil.getList((int) R.array.msg_acq_highres_bit);
            if (listBIt.size() == 3 && ViewUtil.checkModelEDU()) {
                listBIt.remove(0);
            }
            Intrinsics.checkNotNullExpressionValue(listBIt, "listBIt");
            spinnerClick(listBIt, v, new AorBManager.OnSpinnerClickListener<MappingObject>() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$3
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerClickListener
                public final void onSpinnerClick(MappingObject it) {
                    HorizontalPopupView horizontalPopupView = HorizontalPopupView.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    horizontalPopupView.selectBandWidth(it);
                }
            });
        } else if (id == R.id.displaySpinner) {
            List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_acq_ultra_displaymode);
            Intrinsics.checkNotNullExpressionValue(list2, "ViewUtil.getList(R.array…sg_acq_ultra_displaymode)");
            spinnerClick(list2, v, new AorBManager.OnSpinnerClickListener<MappingObject>() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$4
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerClickListener
                public final void onSpinnerClick(MappingObject it) {
                    HorizontalPopupView horizontalPopupView = HorizontalPopupView.this;
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    horizontalPopupView.selectDisplay(it);
                }
            });
        } else {
            if (id == R.id.avg_times_edit_text) {
                AorBManager aorBManager = this.aorBManager;
                valueOf = aorBManager != null ? Boolean.valueOf(aorBManager.setClick_showab(id)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    ViewUtil.showKeyboard(this.anchor, v, ServiceEnum.Unit.Unit_number, this.param.getAvgTimesAttr().getMaxIntValue(), this.param.getAvgTimesAttr().getMinIntValue(), this.param.getAvgTimesAttr().getDefIntValue(), this.param.getAvgTimes(), new KeyboardListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$5
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            HorizontalParam horizontalParam;
                            HorizontalParam horizontalParam2;
                            if (t != null) {
                                TwoTuple<Boolean, Double> trimByNth = KtUtilKt.trimByNth(((Long) t).longValue(), 2.0d);
                                Boolean first = trimByNth.getFirst();
                                Intrinsics.checkNotNullExpressionValue(first, "result.first");
                                if (first.booleanValue()) {
                                    ToastUtils.showShort((int) R.string.err_average_trim);
                                    horizontalParam2 = HorizontalPopupView.this.param;
                                    horizontalParam2.saveAvgTimes((int) trimByNth.getSecond().doubleValue());
                                }
                                horizontalParam = HorizontalPopupView.this.param;
                                horizontalParam.saveAvgTimes((int) trimByNth.getSecond().doubleValue());
                                return;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                        }
                    });
                }
            } else if (id == R.id.main_scale_edit_text) {
                AorBManager aorBManager2 = this.aorBManager;
                valueOf = aorBManager2 != null ? Boolean.valueOf(aorBManager2.setClick_showab(id)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    ViewUtil.showKeyboard(this.anchor, v, ServiceEnum.Unit.Unit_s, this.param.getMainScaleAttr().getMaxLongValue(), this.param.getMainScaleAttr().getMinLongValue(), this.param.getMainScaleAttr().getDefLongValue(), this.param.getMainScale(), new KeyboardListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$6
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            HorizontalParam horizontalParam;
                            horizontalParam = HorizontalPopupView.this.param;
                            if (t == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            horizontalParam.saveMainScale(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                        }
                    });
                }
            } else if (id == R.id.main_offset_edit_text) {
                AorBManager aorBManager3 = this.aorBManager;
                valueOf = aorBManager3 != null ? Boolean.valueOf(aorBManager3.setClick_showab(id)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    ViewUtil.showKeyboard(this.anchor, v, ServiceEnum.Unit.Unit_s, this.param.getMainOffsetAttr().getMaxLongValue(), this.param.getMainOffsetAttr().getMinLongValue(), this.param.getMainOffsetAttr().getDefLongValue(), this.param.getMainOffset(), "0.00####", 11, new KeyboardListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$7
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            HorizontalParam horizontalParam;
                            horizontalParam = HorizontalPopupView.this.param;
                            if (t == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            horizontalParam.saveMainOffset(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                        }
                    });
                }
            } else if (id == R.id.zoom_scale_edit_text) {
                AorBManager aorBManager4 = this.aorBManager;
                valueOf = aorBManager4 != null ? Boolean.valueOf(aorBManager4.setClick_showab(id)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    ViewUtil.showKeyboard(this.anchor, v, ServiceEnum.Unit.Unit_s, this.param.getZoomScaleAttr().getMaxLongValue(), this.param.getZoomScaleAttr().getMinLongValue(), this.param.getZoomScaleAttr().getDefLongValue(), this.param.getZoomScale(), new KeyboardListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$8
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            HorizontalParam horizontalParam;
                            horizontalParam = HorizontalPopupView.this.param;
                            if (t == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            horizontalParam.saveZoomScale(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                        }
                    });
                }
            } else if (id == R.id.zoom_offset_edit_text) {
                AorBManager aorBManager5 = this.aorBManager;
                valueOf = aorBManager5 != null ? Boolean.valueOf(aorBManager5.setClick_showab(id)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    ViewUtil.showKeyboard(this.anchor, v, ServiceEnum.Unit.Unit_s, this.param.getZoomOffsetAttr().getMaxLongValue(), this.param.getZoomOffsetAttr().getMinLongValue(), this.param.getZoomOffsetAttr().getDefLongValue(), this.param.getZoomOffset(), "0.00####", 8, new KeyboardListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$9
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            HorizontalParam horizontalParam;
                            horizontalParam = HorizontalPopupView.this.param;
                            if (t == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            horizontalParam.saveZoomOffset(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                        }
                    });
                }
            } else if (id == R.id.expand_user_edit_text) {
                if (this.param.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL || this.param.getExpandMode() != ServiceEnum.HorizontalExpand.Horizontal_Expand_User) {
                    return;
                }
                AorBManager aorBManager6 = this.aorBManager;
                valueOf = aorBManager6 != null ? Boolean.valueOf(aorBManager6.setClick_showab(id)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    ViewUtil.showKeyboard(this.anchor, v, ServiceEnum.Unit.Unit_number, this.param.getExpandUserAttr().getMaxIntValue(), this.param.getExpandUserAttr().getMinIntValue(), this.param.getExpandUserAttr().getDefIntValue(), this.param.getExpandUser(), new KeyboardListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$10
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            HorizontalParam horizontalParam;
                            horizontalParam = HorizontalPopupView.this.param;
                            if (t == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            horizontalParam.saveExpandUser(Math.toIntExact(((Long) t).longValue()));
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                        }
                    });
                }
            } else if (id == R.id.maxFrameEdit) {
                AorBManager aorBManager7 = this.aorBManager;
                valueOf = aorBManager7 != null ? Boolean.valueOf(aorBManager7.setClick_showab(id)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    ViewUtil.showKeyboard(this.anchor, v, ServiceEnum.Unit.Unit_number, this.param.getMaxFrameAttr().getMaxLongValue(), this.param.getMaxFrameAttr().getMinLongValue(), this.param.getMaxFrameAttr().getDefLongValue(), this.param.readMaxFrame(), new KeyboardListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$11
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            HorizontalParam horizontalParam;
                            horizontalParam = HorizontalPopupView.this.param;
                            if (t == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            horizontalParam.saveMaxFrame(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                        }
                    });
                }
            } else if (id == R.id.timeOutEdit) {
                AorBManager aorBManager8 = this.aorBManager;
                valueOf = aorBManager8 != null ? Boolean.valueOf(aorBManager8.setClick_showab(id)) : null;
                Intrinsics.checkNotNull(valueOf);
                if (valueOf.booleanValue()) {
                    ViewUtil.showKeyboard(this.anchor, v, ServiceEnum.Unit.Unit_s, this.param.getTimeOutAttr().getMaxLongValue(), this.param.getTimeOutAttr().getMinLongValue(), this.param.getTimeOutAttr().getDefLongValue(), this.param.readTimeOut(), new KeyboardListener() { // from class: com.rigol.scope.views.horizontal.HorizontalPopupView$onClick$12
                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            HorizontalParam horizontalParam;
                            horizontalParam = HorizontalPopupView.this.param;
                            if (t == null) {
                                throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                            }
                            horizontalParam.saveTimeOut(((Long) t).longValue());
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            HorizontalPopupView.this.setKeyboardPopupView(keyboardPopupView);
                        }
                    });
                }
            } else if (id == R.id.main_scale_left) {
                HorizontalParam horizontalParam = this.param;
                horizontalParam.saveMainScale(horizontalParam.getScaleLager(horizontalParam.getMainScale()));
            } else if (id == R.id.main_scale_right) {
                HorizontalParam horizontalParam2 = this.param;
                horizontalParam2.saveMainScale(horizontalParam2.getScaleSmaller(horizontalParam2.getMainScale()));
            } else if (id == R.id.main_offset_left) {
                HorizontalParam horizontalParam3 = this.param;
                this.param.saveMainOffset(horizontalParam3.offsetLarger(horizontalParam3.getMainScale(), this.param.getMainOffset(), 1));
            } else if (id == R.id.main_offset_right) {
                HorizontalParam horizontalParam4 = this.param;
                this.param.saveMainOffset(horizontalParam4.offsetSmaller(horizontalParam4.getMainScale(), this.param.getMainOffset(), 1));
            } else if (id == R.id.zoom_scale_left) {
                HorizontalParam horizontalParam5 = this.param;
                horizontalParam5.saveZoomScale(horizontalParam5.getScaleLager(horizontalParam5.getZoomScale()));
            } else if (id == R.id.zoom_scale_right) {
                HorizontalParam horizontalParam6 = this.param;
                horizontalParam6.saveZoomScale(horizontalParam6.getScaleSmaller(horizontalParam6.getZoomScale()));
            } else if (id == R.id.zoom_offset_left) {
                HorizontalParam horizontalParam7 = this.param;
                this.param.saveZoomOffset(horizontalParam7.offsetLarger(horizontalParam7.getZoomScale(), this.param.getZoomOffset(), 1));
            } else if (id == R.id.zoom_offset_right) {
                HorizontalParam horizontalParam8 = this.param;
                this.param.saveZoomOffset(horizontalParam8.offsetSmaller(horizontalParam8.getZoomScale(), this.param.getZoomOffset(), 1));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshUltraAndXYStatus() {
        HorizontalParam horizontalParam = this.param;
        if (horizontalParam != null) {
            horizontalParam.setUltraEnable(FunctionManager.getInstance().getUltraStatus(this.param));
        }
        HorizontalParam horizontalParam2 = this.param;
        if (horizontalParam2 != null) {
            horizontalParam2.setXyCheck(FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_XY));
        }
        HorizontalParam horizontalParam3 = this.param;
        if (horizontalParam3 != null) {
            horizontalParam3.setXyCheckEnable(FunctionManager.getInstance().getXYEnable(this.param));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        int avgTimes;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        HorizontalParam horizontalParam = this.param;
        if (horizontalParam == null) {
            return;
        }
        switch (i) {
            case R.id.avg_times_edit_text /* 2131361995 */:
                if (z) {
                    avgTimes = horizontalParam.getAvgTimes() * 2;
                    if (avgTimes > this.param.getAvgTimesAttr().getMaxIntValue()) {
                        avgTimes = this.param.getAvgTimesAttr().getMaxIntValue();
                    }
                } else {
                    avgTimes = horizontalParam.getAvgTimes() / 2;
                    if (avgTimes < this.param.getAvgTimesAttr().getMinIntValue()) {
                        avgTimes = this.param.getAvgTimesAttr().getMinIntValue();
                    }
                }
                this.param.saveAvgTimes(avgTimes);
                return;
            case R.id.expand_user_edit_text /* 2131362863 */:
                if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL || this.param.getExpandMode() != ServiceEnum.HorizontalExpand.Horizontal_Expand_User) {
                    return;
                }
                HorizontalParam horizontalParam2 = this.param;
                horizontalParam2.saveExpandUser(horizontalParam2.getIntStep(horizontalParam2.getExpandUser(), this.param.getExpandUserAttr(), z, keyEvent));
                return;
            case R.id.main_offset_edit_text /* 2131363355 */:
                if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_ROLL || this.param.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                    if (z) {
                        HorizontalParam horizontalParam3 = this.param;
                        long mainScale = horizontalParam3.getMainScale();
                        HorizontalParam horizontalParam4 = this.param;
                        horizontalParam3.saveMainOffset(horizontalParam4.offsetSmaller(mainScale, horizontalParam4.getMainOffset(), 1));
                        return;
                    }
                    HorizontalParam horizontalParam5 = this.param;
                    horizontalParam5.saveMainOffset(horizontalParam5.offsetLarger(horizontalParam5.getMainScale(), this.param.getMainOffset(), 1));
                    return;
                }
                return;
            case R.id.main_scale_edit_text /* 2131363359 */:
                if (z) {
                    horizontalParam.saveMainScale(horizontalParam.getScaleSmaller(horizontalParam.getMainScale()));
                    return;
                } else {
                    horizontalParam.saveMainScale(horizontalParam.getScaleLager(horizontalParam.getMainScale()));
                    return;
                }
            case R.id.maxFrameEdit /* 2131363383 */:
                horizontalParam.saveMaxFrame(horizontalParam.getLongStep(horizontalParam.getMaxFrame(), this.param.getMaxFrameAttr(), z, keyEvent));
                return;
            case R.id.timeOutEdit /* 2131364085 */:
                if (z) {
                    horizontalParam.saveTimeOut(horizontalParam.getScaleSmaller(horizontalParam.getTimeOut()));
                    return;
                } else {
                    horizontalParam.saveTimeOut(horizontalParam.getScaleLager(horizontalParam.getTimeOut()));
                    return;
                }
            case R.id.zoom_offset_edit_text /* 2131364747 */:
                if (z) {
                    horizontalParam.saveZoomOffset(horizontalParam.offsetLarger(horizontalParam.getZoomScale(), this.param.getZoomOffset(), 1));
                    return;
                } else {
                    horizontalParam.saveZoomOffset(horizontalParam.offsetSmaller(horizontalParam.getZoomScale(), this.param.getZoomOffset(), 1));
                    return;
                }
            case R.id.zoom_scale_edit_text /* 2131364753 */:
                if (z) {
                    horizontalParam.saveZoomScale(horizontalParam.getScaleLager(horizontalParam.getZoomScale()));
                    return;
                } else {
                    horizontalParam.saveZoomScale(horizontalParam.getScaleSmaller(horizontalParam.getZoomScale()));
                    return;
                }
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        HorizontalParam horizontalParam = this.param;
        if (horizontalParam == null) {
            return;
        }
        switch (i) {
            case R.id.avg_times_edit_text /* 2131361995 */:
                horizontalParam.saveAvgTimes(horizontalParam.getIntDef(horizontalParam.getAvgTimesAttr()));
                return;
            case R.id.expand_user_edit_text /* 2131362863 */:
                if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL || this.param.getExpandMode() != ServiceEnum.HorizontalExpand.Horizontal_Expand_User) {
                    return;
                }
                HorizontalParam horizontalParam2 = this.param;
                horizontalParam2.saveExpandUser(horizontalParam2.getIntDef(horizontalParam2.getExpandUserAttr()));
                return;
            case R.id.main_offset_edit_text /* 2131363355 */:
                if (horizontalParam.getTimeMode() != ServiceEnum.HoriTimeMode.Horizontal_ROLL || this.param.getRunStop() == ServiceEnum.ControlAction.Control_Stop) {
                    HorizontalParam horizontalParam3 = this.param;
                    horizontalParam3.saveMainOffset(horizontalParam3.getLongDef(horizontalParam3.getMainOffsetAttr()));
                    return;
                }
                return;
            case R.id.main_scale_edit_text /* 2131363359 */:
                horizontalParam.saveMainScale(horizontalParam.getLongDef(horizontalParam.getMainScaleAttr()));
                return;
            case R.id.maxFrameEdit /* 2131363383 */:
                horizontalParam.saveMaxFrame(horizontalParam.getLongDef(horizontalParam.getMaxFrameAttr()));
                return;
            case R.id.timeOutEdit /* 2131364085 */:
                horizontalParam.saveTimeOut(horizontalParam.getLongDef(horizontalParam.getTimeOutAttr()));
                return;
            case R.id.zoom_offset_edit_text /* 2131364747 */:
                horizontalParam.saveZoomOffset(horizontalParam.getLongDef(horizontalParam.getZoomOffsetAttr()));
                return;
            case R.id.zoom_scale_edit_text /* 2131364753 */:
                horizontalParam.saveZoomScale(horizontalParam.getLongDef(horizontalParam.getZoomScaleAttr()));
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        ViewUtil.updateSwitchText(R.array.tek_msg_hor_delay_sample, this.binding.delaySample);
    }
}
