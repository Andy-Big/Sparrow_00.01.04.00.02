package com.rigol.scope.views.mask;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioGroup;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.PopupviewMaskBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.MaskViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.load.LoadPopupView;
import com.rigol.scope.views.save.SavePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class MaskPopupView extends BasePopupView implements RadioGroup.OnCheckedChangeListener, CompoundButton.OnCheckedChangeListener, View.OnClickListener, PopupWindow.OnDismissListener, AorBManager.OnTextReset, AorBManager.OnSetTextById {
    private final String BIGGER;
    private final String SMALLER;
    private final int TWOHUNDREDFIVE;
    private AorBManager aorBManager;
    private PopupviewMaskBinding binding;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private MaskParam param;
    private PopupSpinner popupSpinner;
    private ImageView small;
    private SpinnerAdapter spinnerAdapter;
    private StorageLoadParam storageLoadParam;
    private StorageSaveParam storageSaveParam;

    public MaskPopupView() {
        super((int) R.style.App_PopupWindow_Mask);
        this.SMALLER = "ic_smaller";
        this.BIGGER = "ic_bigger";
        this.list_aorbParam = new ArrayList();
        this.TWOHUNDREDFIVE = 250;
        PopupviewMaskBinding inflate = PopupviewMaskBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$tU3FPa2JeD591OTAv5OEa7MTdH4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MaskPopupView.this.lambda$new$0$MaskPopupView((HorizontalParam) obj);
                }
            });
        }
        MaskViewModel maskViewModel = (MaskViewModel) ContextUtil.getAppViewModel(MaskViewModel.class);
        if (maskViewModel != null) {
            maskViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$nzAsp29Gel_Jv3l330MhUezMuek
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MaskPopupView.this.lambda$new$1$MaskPopupView((MaskParam) obj);
                }
            });
        }
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel != null) {
            storageViewModel.getSaveLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$xasZnyEzQuZEoEzrFsw87IwcyGE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MaskPopupView.this.lambda$new$2$MaskPopupView((StorageSaveParam) obj);
                }
            });
            storageViewModel.getLoadLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$Y_vhOa3_azU0HO2pEcpmTlAOUj0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MaskPopupView.this.lambda$new$3$MaskPopupView((StorageLoadParam) obj);
                }
            });
        }
        ViewUtil.setSwitchButton(this.binding.enableSwitch);
        ViewUtil.setSwitchButton(this.binding.switchButtonMaskOut);
        this.binding.radioGroupMaskOutEvent.setOnCheckedChangeListener(this);
        this.binding.radioGroupMaskOutHl.setOnCheckedChangeListener(this);
        this.binding.radioGroupMaskRange.setOnCheckedChangeListener(this);
        this.binding.setScreenMapping(ViewUtil.getMappingObject(R.array.msg_mask_range, ServiceEnum.MaskRange.mask_range_screen.value1));
        this.binding.setCursorMapping(ViewUtil.getMappingObject(R.array.msg_mask_range, ServiceEnum.MaskRange.mask_range_user.value1));
        this.binding.setFailMapping(ViewUtil.getMappingObject(R.array.msg_mask_out_event, ServiceEnum.MaskActionEvent.mask_action_on_fail.value1));
        this.binding.setPassMapping(ViewUtil.getMappingObject(R.array.msg_mask_out_event, ServiceEnum.MaskActionEvent.mask_action_on_pass.value1));
        this.binding.setPositiveMapping(ViewUtil.getMappingObject(R.array.msg_mask_out_hl, ServiceEnum.MaskPolarity.mask_polarity_positive.value1));
        this.binding.setNegativeMapping(ViewUtil.getMappingObject(R.array.msg_mask_out_hl, ServiceEnum.MaskPolarity.mask_polarity_negative.value1));
        this.binding.enableSwitch.setOnCheckedChangeListener(this);
        this.binding.switchButtonMaskOut.setOnCheckedChangeListener(this);
        this.binding.checkBoxMaskBeeper.setOnCheckedChangeListener(this);
        this.binding.checkBoxMaskScreen.setOnCheckedChangeListener(this);
        this.binding.checkBoxMaskStop.setOnCheckedChangeListener(this);
        this.binding.operateButton.setOnClickListener(this);
        this.binding.sourceSpinner.setOnClickListener(this);
        this.binding.buttonMaskCreateMenu.setOnClickListener(this);
        this.binding.buttonMaskLoad.setOnClickListener(this);
        this.binding.buttonMaskSave.setOnClickListener(this);
        this.binding.valueMaskOUtPulse.setOnClickListener(this);
        this.binding.valueMaskXmask.setOnClickListener(this);
        this.binding.valueMaskYmask.setOnClickListener(this);
        this.binding.imageButtonMaskXmaskLeft.setOnClickListener(this);
        this.binding.imageButtonMaskXmaskRight.setOnClickListener(this);
        this.binding.imageButtonMaskYmaskDown.setOnClickListener(this);
        this.binding.imageButtonMaskYmaskUP.setOnClickListener(this);
        this.binding.resetButton.setOnClickListener(this);
        ImageView imageView = (ImageView) this.binding.getRoot().findViewById(R.id.small);
        this.small = imageView;
        imageView.setTag("ic_smaller");
        this.small.setVisibility(0);
        this.small.setOnClickListener(this);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.valueMaskYmask, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.valueMaskXmask, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.valueMaskOUtPulse, 0, false, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.sourceSpinner, 0, false, "", 2));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.mask.MaskPopupView.2
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                showKey(MaskPopupView.this.context, ((AorBParam) MaskPopupView.this.list_aorbParam.get(i)).getTextView(), true, ((AorBParam) MaskPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                showKey(MaskPopupView.this.context, ((AorBParam) MaskPopupView.this.list_aorbParam.get(i)).getTextView(), false, ((AorBParam) MaskPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.valueMaskYmask, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.valueMaskXmask, true, ViewUtil.KEY_B);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$3WlreO8cZtn556qg96AbjRyfcN0
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MaskPopupView.this.lambda$new$6$MaskPopupView((KeyEvent) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$new$0$MaskPopupView(HorizontalParam horizontalParam) {
        this.binding.setHorizontalParam(horizontalParam);
    }

    public /* synthetic */ void lambda$new$1$MaskPopupView(MaskParam maskParam) {
        this.param = maskParam;
        this.binding.setParam(maskParam);
        MaskParam maskParam2 = this.param;
        if (maskParam2 != null) {
            maskParam2.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.mask.MaskPopupView.1
                @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                public void onPropertyChanged(Observable observable, int i) {
                    if (i == 271 || i == 572) {
                        View findViewById = MaskPopupView.this.binding.getRoot().findViewById(R.id.close);
                        if (MaskPopupView.this.param.isEnable() && MaskPopupView.this.param.isOperate()) {
                            findViewById.setAlpha(ContextUtil.getAlpha(false));
                            findViewById.setEnabled(false);
                            MaskPopupView.this.setOutsideTouchable(false);
                        } else {
                            findViewById.setAlpha(ContextUtil.getAlpha(true));
                            findViewById.setEnabled(true);
                            MaskPopupView.this.setOutsideTouchable(true);
                        }
                        MaskPopupView.this.update();
                    }
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$2$MaskPopupView(StorageSaveParam storageSaveParam) {
        this.storageSaveParam = storageSaveParam;
    }

    public /* synthetic */ void lambda$new$3$MaskPopupView(StorageLoadParam storageLoadParam) {
        this.storageLoadParam = storageLoadParam;
    }

    public /* synthetic */ void lambda$new$6$MaskPopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(MaskPopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$rXWWaecXi4XGzhGGg3JxAW48hbM
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    MaskPopupView.this.lambda$new$4$MaskPopupView(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$ZLsS7ewWTxJ2Qz68EcJH3hZHFms
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    MaskPopupView.this.lambda$new$5$MaskPopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$4$MaskPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$5$MaskPopupView(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.source_spinner) {
            this.param.saveSource(mappingObject.getValue());
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.radioButton_maskCursor /* 2131363660 */:
                this.param.saveRang(ServiceEnum.MaskRange.mask_range_user);
                return;
            case R.id.radioButton_maskFaile /* 2131363661 */:
                this.param.saveOutEvent(ServiceEnum.MaskActionEvent.mask_action_on_fail);
                return;
            case R.id.radioButton_maskNegativePulse /* 2131363662 */:
                this.param.saveOutHl(ServiceEnum.MaskPolarity.mask_polarity_negative);
                return;
            case R.id.radioButton_maskPass /* 2131363663 */:
                this.param.saveOutEvent(ServiceEnum.MaskActionEvent.mask_action_on_pass);
                return;
            case R.id.radioButton_maskPositionPulse /* 2131363664 */:
                this.param.saveOutHl(ServiceEnum.MaskPolarity.mask_polarity_positive);
                return;
            case R.id.radioButton_maskScreen /* 2131363665 */:
                this.param.saveRang(ServiceEnum.MaskRange.mask_range_screen);
                return;
            default:
                return;
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        int id = compoundButton.getId();
        if (compoundButton.isPressed()) {
            if (id == R.id.enable_switch) {
                this.param.saveEnable(z);
                maskLight();
                if (FunctionManager.getInstance().checkUltraIsOpen()) {
                    ToastUtils.showShort(this.context.getResources().getString(R.string.err_action_disabled));
                }
            } else if (id == R.id.switchButton_maskOut) {
                this.param.saveAuxOut(z);
            } else if (id == R.id.checkBox_maskStop) {
                if (z) {
                    MaskParam maskParam = this.param;
                    maskParam.saveErrAction(ViewUtil.setSpecifiedBitTo1(maskParam.getErrAction(), 0));
                    return;
                }
                MaskParam maskParam2 = this.param;
                maskParam2.saveErrAction(ViewUtil.setSpecifiedBitTo0(maskParam2.getErrAction(), 0));
            } else if (id == R.id.checkBox_maskBeeper) {
                if (z) {
                    MaskParam maskParam3 = this.param;
                    maskParam3.saveErrAction(ViewUtil.setSpecifiedBitTo1(maskParam3.getErrAction(), 1));
                    return;
                }
                MaskParam maskParam4 = this.param;
                maskParam4.saveErrAction(ViewUtil.setSpecifiedBitTo0(maskParam4.getErrAction(), 1));
            } else if (id == R.id.checkBox_maskScreen) {
                if (z) {
                    MaskParam maskParam5 = this.param;
                    maskParam5.saveErrAction(ViewUtil.setSpecifiedBitTo1(maskParam5.getErrAction(), 2));
                    return;
                }
                MaskParam maskParam6 = this.param;
                maskParam6.saveErrAction(ViewUtil.setSpecifiedBitTo0(maskParam6.getErrAction(), 2));
            }
        }
    }

    public void maskLight() {
        if (this.binding.enableSwitch.isChecked()) {
            if (this.param != null) {
                PopupViewManager.getInstance().setLight(this.aorBManager);
                return;
            }
            return;
        }
        PopupViewManager.getInstance().closeAllLight();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.source_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_mask_source)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$Q_p_LV16FNDqQSypvYDTN-ysJaw
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    MaskPopupView.this.lambda$onClick$7$MaskPopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.mask.-$$Lambda$MaskPopupView$Bg1uMYtJDlbjACDK9VrN5C4ApkU
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    MaskPopupView.this.lambda$onClick$8$MaskPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.operate_button) {
            MaskParam maskParam = this.param;
            maskParam.saveOperate(!maskParam.isOperate());
        } else if (id == R.id.value_maskYmask) {
            if (this.aorBManager.setClick_showab_textview(id)) {
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_Div, this.param.getYValueAttr().getMaxIntValue() * this.param.getYRatio(), this.param.getYValueAttr().getMinIntValue() * this.param.getYRatio(), this.param.getYValueAttr().getDefIntValue() * this.param.getYRatio(), this.param.getYValue(), new KeyboardListener() { // from class: com.rigol.scope.views.mask.MaskPopupView.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        MaskPopupView.this.param.saveYMask(((Long) t).intValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MaskPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.value_maskXmask) {
            if (this.aorBManager.setClick_showab_textview(id)) {
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_Div, this.param.getXValueAttr().getMaxIntValue() * this.param.getXRatio(), this.param.getXValueAttr().getMinIntValue() * this.param.getXRatio(), this.param.getXValueAttr().getDefIntValue() * this.param.getXRatio(), this.param.getXValue(), new KeyboardListener() { // from class: com.rigol.scope.views.mask.MaskPopupView.4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        MaskPopupView.this.param.saveXMask(((Long) t).intValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MaskPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.value_maskOUtPulse) {
            if (this.aorBManager.setClick_showab_textview(id)) {
                this.param.readOutPulseAttr();
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_s, this.param.getOutPulseAttr().getMaxLongValue(), this.param.getOutPulseAttr().getMinLongValue(), this.param.getOutPulseAttr().getDefLongValue(), this.param.getOutPulse(), new KeyboardListener() { // from class: com.rigol.scope.views.mask.MaskPopupView.5
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        MaskPopupView.this.param.saveOutPulse(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        MaskPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.imageButton_maskYmaskUP) {
            MaskParam maskParam2 = this.param;
            maskParam2.saveYMask((int) (maskParam2.getYValue() + (this.param.getYRatio() * this.param.getYValueAttr().getStepValue())));
        } else if (id == R.id.imageButton_maskYmaskDown) {
            MaskParam maskParam3 = this.param;
            maskParam3.saveYMask((int) (maskParam3.getYValue() - (this.param.getYRatio() * this.param.getYValueAttr().getStepValue())));
        } else if (id == R.id.imageButton_maskXmaskLeft) {
            MaskParam maskParam4 = this.param;
            maskParam4.saveXMask((int) (maskParam4.getXValue() - (this.param.getXRatio() * this.param.getXValueAttr().getStepValue())));
        } else if (id == R.id.imageButton_maskXmaskRight) {
            MaskParam maskParam5 = this.param;
            maskParam5.saveXMask((int) (maskParam5.getXValue() + (this.param.getXRatio() * this.param.getXValueAttr().getStepValue())));
        } else if (id == R.id.reset_button) {
            this.param.saveResetStat();
        } else if (id == R.id.button_maskCreateMenu) {
            API.getInstance().UI_PostBool(46, MessageID.MSG_MASK_CREATE, true);
        } else if (id == R.id.button_maskSave) {
            StorageSaveParam storageSaveParam = this.storageSaveParam;
            if (storageSaveParam != null) {
                storageSaveParam.setFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_MSK);
                this.storageSaveParam.setFileType(ServiceEnum.enFileType.FILETYPE_PF.value1);
                PopupViewManager.getInstance().toggle(SavePopupView.class);
            }
        } else if (id == R.id.button_maskLoad) {
            StorageLoadParam storageLoadParam = this.storageLoadParam;
            if (storageLoadParam != null) {
                storageLoadParam.saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_MSK);
                this.storageLoadParam.saveFileType(ServiceEnum.enFileType.FILETYPE_PF.value1);
                PopupViewManager.getInstance().toggle(LoadPopupView.class);
            }
        } else if (id == R.id.small) {
            if (!"ic_smaller".equals(this.small.getTag())) {
                PopupViewManager.getInstance().dismiss(MaskPopupView.class);
                this.small.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_smaller));
                this.small.setTag("ic_smaller");
                this.param.setMinPop1(false);
                PopupViewManager.getInstance().toggle(MaskPopupView.class);
                updateLocation((getWidth() / 2) - 200, 150);
                return;
            }
            this.small.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_bigger));
            this.small.setTag("ic_bigger");
            this.param.setMinPop1(true);
            updateLocation((getWidth() / 2) - 200, 150);
        }
    }

    public /* synthetic */ void lambda$onClick$7$MaskPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$MaskPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveSource(mappingObject.getValue());
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        PopupviewMaskBinding popupviewMaskBinding;
        if (this.param == null || (popupviewMaskBinding = this.binding) == null || !popupviewMaskBinding.enableSwitch.isChecked()) {
            return;
        }
        switch (i) {
            case R.id.value_maskOUtPulse /* 2131364556 */:
                this.param.readOutPulseAttr();
                MaskParam maskParam = this.param;
                maskParam.saveOutPulse(maskParam.getLongStep(maskParam.getOutPulse(), this.param.getOutPulseAttr(), z, keyEvent));
                return;
            case R.id.value_maskXmask /* 2131364557 */:
                this.param.updateXMask(keyEvent, z);
                return;
            case R.id.value_maskYmask /* 2131364558 */:
                this.param.updateYMask(keyEvent, z);
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        PopupviewMaskBinding popupviewMaskBinding;
        if (this.param == null || (popupviewMaskBinding = this.binding) == null || !popupviewMaskBinding.enableSwitch.isChecked()) {
            return;
        }
        switch (i) {
            case R.id.value_maskOUtPulse /* 2131364556 */:
                this.param.readOutPulseAttr();
                MaskParam maskParam = this.param;
                maskParam.saveOutPulse(maskParam.getLongDef(maskParam.getOutPulseAttr()));
                return;
            case R.id.value_maskXmask /* 2131364557 */:
                MessageAttr messageAttr = new MessageAttr();
                messageAttr.setMinValue(this.param.getXValueAttr().getMinIntValue() * this.param.getXRatio());
                messageAttr.setMaxValue(this.param.getXValueAttr().getMaxIntValue() * this.param.getXRatio());
                messageAttr.setDefValue(this.param.getXValueAttr().getDefIntValue() * this.param.getXRatio());
                messageAttr.setStepValue(this.param.getXValueAttr().getStepValue());
                MaskParam maskParam2 = this.param;
                maskParam2.saveXMask(maskParam2.getIntDef(messageAttr));
                return;
            case R.id.value_maskYmask /* 2131364558 */:
                MessageAttr messageAttr2 = new MessageAttr();
                messageAttr2.setMinValue(this.param.getYValueAttr().getMinIntValue() * this.param.getYRatio());
                messageAttr2.setMaxValue(this.param.getYValueAttr().getMaxIntValue() * this.param.getYRatio());
                messageAttr2.setDefValue(this.param.getYValueAttr().getDefIntValue() * this.param.getYRatio());
                messageAttr2.setStepValue(this.param.getYValueAttr().getStepValue());
                MaskParam maskParam3 = this.param;
                maskParam3.saveYMask(maskParam3.getIntDef(messageAttr2));
                return;
            default:
                return;
        }
    }
}
