package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.SeekBar;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.constant.CacheConstants;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ConvertUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.AdapterUtilityBasesettingBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.SystemUtil;
import com.rigol.scope.utilities.UtilityUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MaskViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.CustomDatePickerAlertDialog;
import com.rigol.scope.views.CustomTimePickerAlertDialog;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import timber.log.Timber;

/* loaded from: classes.dex */
public class UtilitySetupSettingAdapter extends RecyclerView.Adapter<BaseSettingViewHolder> implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private AorBManager aorBManager;
    private final View baseView;
    private AdapterUtilityBasesettingBinding binding;
    private View clickedView;
    private final Context context;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;
    private UtilityParam utilityParam;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilitySetupSettingAdapter(Context context, View view) {
        this.context = context;
        this.baseView = view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterUtilityBasesettingBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<UtilityParam>() { // from class: com.rigol.scope.adapters.UtilitySetupSettingAdapter.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.lifecycle.Observer
                public void onChanged(UtilityParam utilityParam) {
                    UtilitySetupSettingAdapter.this.utilityParam = utilityParam;
                    UtilitySetupSettingAdapter.this.binding.setParam(utilityParam);
                }
            });
        }
        MaskViewModel maskViewModel = (MaskViewModel) ContextUtil.getAppViewModel(MaskViewModel.class);
        if (maskViewModel != null) {
            maskViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<MaskParam>() { // from class: com.rigol.scope.adapters.UtilitySetupSettingAdapter.2
                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.lifecycle.Observer
                public void onChanged(MaskParam maskParam) {
                    UtilitySetupSettingAdapter.this.binding.setMaskParam(maskParam);
                }
            });
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.spLanguage, 0, false, "", 2));
        this.aorBManager = null;
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.adapters.UtilitySetupSettingAdapter.3
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
            }
        };
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilitySetupSettingAdapter$5mekW44aU6EXZtUPdTmggcMZi0U
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        UtilitySetupSettingAdapter.this.lambda$onCreateViewHolder$1$UtilitySetupSettingAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        return new BaseSettingViewHolder(this.binding);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$1$UtilitySetupSettingAdapter(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        SpinnerAdapter spinnerAdapter;
        if (!PopupViewManager.getInstance().isShowing(UtilityPopupView.class) || (popupSpinner = this.popupSpinner) == null || (spinnerAdapter = this.spinnerAdapter) == null) {
            return;
        }
        this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, popupSpinner, this.mappingObjects, spinnerAdapter, this.aorBManager, null, null, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilitySetupSettingAdapter$dqlodaXexal9yvdkikZ8cP5ikCU
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
            public final void onCall(int i, MappingObject mappingObject) {
                UtilitySetupSettingAdapter.this.lambda$onCreateViewHolder$0$UtilitySetupSettingAdapter(i, mappingObject);
            }
        });
    }

    public /* synthetic */ void lambda$onCreateViewHolder$0$UtilitySetupSettingAdapter(int i, MappingObject mappingObject) {
        UtilityParam utilityParam = this.utilityParam;
        if (utilityParam != null) {
            utilityParam.saveLanguage(mappingObject.getValue());
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(BaseSettingViewHolder baseSettingViewHolder, int i) {
        initViewStyle();
    }

    private void initViewStyle() {
        this.binding.spLanguage.setOnClickListener(this);
        ViewUtil.setSwitchButton(this.binding.switchButtonBeeper);
        this.binding.switchButtonBeeper.setOnCheckedChangeListener(this);
        this.binding.beeperLayout.setOnClickListener(this);
        ViewUtil.setSwitchButton(this.binding.switchButtonVibration);
        this.binding.switchButtonVibration.setOnCheckedChangeListener(this);
        this.binding.vibrationLayout.setOnClickListener(this);
        this.binding.switchButtonAuxout.setOnCheckedChangeListener(this);
        this.binding.switchButtonOpenzoom.setOnCheckedChangeListener(this);
        this.binding.auxoutLayout.setOnClickListener(this);
        ViewUtil.setSwitchButton(this.binding.switchButtonScreenLock);
        this.binding.switchButtonScreenLock.setOnCheckedChangeListener(this);
        this.binding.screenLockLayout.setOnClickListener(this);
        this.binding.switchButtonPower.setOnCheckedChangeListener(this);
        this.binding.powerLayout.setOnClickListener(this);
        this.binding.switchButtonShowtime.setOnCheckedChangeListener(this);
        this.binding.showtimeLayout.setOnClickListener(this);
        this.binding.switchButtonLoadLast.setOnCheckedChangeListener(this);
        this.binding.loadLastLayout.setOnClickListener(this);
        this.binding.switchButtonVerticalExpand.setOnCheckedChangeListener(this);
        this.binding.verticalExpand.setOnClickListener(this);
        this.binding.yearLayout.setOnClickListener(this);
        this.binding.timeLayout.setOnClickListener(this);
        this.binding.screeIntensitySeekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.rigol.scope.adapters.UtilitySetupSettingAdapter.4
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                if (i == 0) {
                    i = 1;
                }
                UtilitySetupSettingAdapter.this.utilityParam.saveScreenBrightness(i);
            }
        });
        setupSwitchButton();
    }

    private void setupSwitchButton() {
        ViewUtil.setSwitchButton(R.array.msg_chan_ver_expand, this.binding.switchButtonVerticalExpand);
        ViewUtil.setSwitchButton(R.array.msg_app_utility_power_on_set, this.binding.switchButtonLoadLast);
        ViewUtil.setSwitchButton(R.array.msg_app_utility_show_time, this.binding.switchButtonShowtime);
        ViewUtil.setSwitchButton(R.array.msg_app_utility_power_status, this.binding.switchButtonPower);
        ViewUtil.setSwitchButton(R.array.msg_app_utility_auxout, this.binding.switchButtonAuxout);
        ViewUtil.setSwitchButton(R.array.msg_app_utility_model_open_zoom_text, this.binding.switchButtonOpenzoom);
    }

    public void updateSwitchButton() {
        ViewUtil.updateSwitchText(R.array.msg_chan_ver_expand, this.binding.switchButtonVerticalExpand);
        ViewUtil.updateSwitchText(R.array.msg_app_utility_power_on_set, this.binding.switchButtonLoadLast);
        ViewUtil.updateSwitchText(R.array.msg_app_utility_show_time, this.binding.switchButtonShowtime);
        ViewUtil.updateSwitchText(R.array.msg_app_utility_power_status, this.binding.switchButtonPower);
        ViewUtil.updateSwitchText(R.array.msg_app_utility_auxout, this.binding.switchButtonAuxout);
        ViewUtil.updateSwitchText(R.array.msg_app_utility_model_open_zoom_text, this.binding.switchButtonOpenzoom);
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && this.utilityParam != null) {
            int id = compoundButton.getId();
            if (id == R.id.switchButton_beeper) {
                this.utilityParam.saveBeeper(z);
            } else if (id == R.id.switchButton_vibration) {
                this.utilityParam.saveVibration(z);
            } else if (id == R.id.switchButton_power) {
                this.utilityParam.savePowerStatus(z);
            } else if (id == R.id.switchButton_auxout) {
                this.utilityParam.saveAuxOut(z);
            } else if (id != R.id.switchButton_screen_lock) {
                if (id == R.id.switchButton_openzoom) {
                    this.utilityParam.setShowzoom(z);
                } else if (id == R.id.switchButton_load_last) {
                    this.utilityParam.savePowerOnSet(z);
                } else if (id == R.id.switchButton_vertical_expand) {
                    this.utilityParam.saveVerticalExpand(z);
                }
            } else {
                UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
                if (utilityViewModel != null) {
                    utilityViewModel.getLiveData();
                    UtilityParam value = utilityViewModel.getLiveData().getValue();
                    if (value != null) {
                        boolean readLockKeyboard = value.readLockKeyboard();
                        if (readLockKeyboard) {
                            ToastUtils.showShort((int) R.string.inf_touch_enable);
                        } else {
                            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, 1);
                            ToastUtils.showShort((int) R.string.inf_touch_disable);
                        }
                        ViewUtil.lock(ActivityUtils.getTopActivity().getWindow(), !readLockKeyboard);
                        value.saveLockKeyboard(!readLockKeyboard);
                        PopupViewManager.getInstance().dismissAll(new Class[0]);
                    }
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.sp_language) {
            setLanguageSpinner(view);
        } else if (id == R.id.beeper_layout) {
            this.binding.switchButtonBeeper.setPressed(true);
            this.binding.switchButtonBeeper.toggle();
        } else if (id == R.id.vibration_layout) {
            this.binding.switchButtonVibration.setPressed(true);
            this.binding.switchButtonVibration.toggle();
        } else if (id == R.id.power_layout) {
            this.binding.switchButtonPower.setPressed(true);
            this.binding.switchButtonPower.toggle();
        } else if (id == R.id.auxout_layout) {
            this.binding.switchButtonAuxout.setPressed(true);
            this.binding.switchButtonAuxout.toggle();
        } else if (id == R.id.screen_lock_layout) {
            this.binding.switchButtonScreenLock.setPressed(true);
            this.binding.switchButtonScreenLock.toggle();
        } else if (id == R.id.showtime_layout) {
            this.binding.switchButtonShowtime.setPressed(true);
            this.binding.switchButtonShowtime.toggle();
        } else if (id == R.id.year_layout) {
            setYear();
        } else if (id == R.id.time_layout) {
            setTime();
        } else if (id == R.id.load_last_layout) {
            this.binding.switchButtonLoadLast.setPressed(true);
            this.binding.switchButtonLoadLast.toggle();
        } else if (id == R.id.vertical_expand_layout) {
            this.binding.switchButtonVerticalExpand.setPressed(true);
            this.binding.switchButtonVerticalExpand.toggle();
        } else {
            this.binding.switchButtonOpenzoom.setPressed(true);
            this.binding.switchButtonOpenzoom.toggle();
        }
    }

    private void setLanguageSpinner(View view) {
        ViewUtil.showSpinner(this.baseView, view, ViewUtil.getList((int) R.array.msg_app_utility_language), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilitySetupSettingAdapter$1OnJK5nNwomDAJ_c4z6xh1LWLUc
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
            public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                UtilitySetupSettingAdapter.this.lambda$setLanguageSpinner$2$UtilitySetupSettingAdapter(popupSpinner, spinnerAdapter, list, view2);
            }
        }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilitySetupSettingAdapter$jkt_fZP1O5xP6PAqPas-bJ-qYlk
            @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
            public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                UtilitySetupSettingAdapter.this.lambda$setLanguageSpinner$3$UtilitySetupSettingAdapter(view2, viewHolder, i, (MappingObject) obj);
            }
        });
    }

    public /* synthetic */ void lambda$setLanguageSpinner$2$UtilitySetupSettingAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$setLanguageSpinner$3$UtilitySetupSettingAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        UtilityParam utilityParam = this.utilityParam;
        if (utilityParam != null) {
            utilityParam.saveLanguage(mappingObject.getValue());
        }
    }

    private void setTime() {
        final int i = ServiceEnum.TimeZoneDiff.ZONE_DIFF.value1;
        Calendar calendar = Calendar.getInstance();
        CustomTimePickerAlertDialog customTimePickerAlertDialog = new CustomTimePickerAlertDialog(this.context, (calendar.get(11) + i) % 24, calendar.get(12), true);
        customTimePickerAlertDialog.show();
        customTimePickerAlertDialog.setCancelable(true);
        customTimePickerAlertDialog.setPositiveButton(new CustomTimePickerAlertDialog.AntTimePickerDialogClickListener() { // from class: com.rigol.scope.adapters.UtilitySetupSettingAdapter.5
            @Override // com.rigol.scope.views.CustomTimePickerAlertDialog.AntTimePickerDialogClickListener
            public void onClick(View view, int i2, int i3) {
                if (SystemUtil.isSystemApp(UtilitySetupSettingAdapter.this.context)) {
                    UtilityUtil.setAndroidSystemTime(((i2 - i) + 24) % 24, i3, UtilitySetupSettingAdapter.this.context);
                    if (UtilitySetupSettingAdapter.this.utilityParam != null) {
                        UtilitySetupSettingAdapter.this.utilityParam.saveTime(System.currentTimeMillis() + (i * CacheConstants.HOUR * 1000));
                    }
                }
            }
        });
    }

    private void setYear() {
        Calendar calendar = Calendar.getInstance();
        CustomDatePickerAlertDialog customDatePickerAlertDialog = new CustomDatePickerAlertDialog(this.context, calendar.get(1), calendar.get(2), calendar.get(5));
        customDatePickerAlertDialog.show();
        customDatePickerAlertDialog.setCancelable(true);
        customDatePickerAlertDialog.setPositiveButton(new CustomDatePickerAlertDialog.AntDatePickerDialogClickListener() { // from class: com.rigol.scope.adapters.UtilitySetupSettingAdapter.6
            @Override // com.rigol.scope.views.CustomDatePickerAlertDialog.AntDatePickerDialogClickListener
            public void onClick(View view, int i, int i2, int i3) {
                if (SystemUtil.isSystemApp(UtilitySetupSettingAdapter.this.context)) {
                    Timber.d("date set: , year1:" + i + ", month1:" + i2 + ", dayOfMonth:" + i3, new Object[0]);
                    UtilityUtil.setAndroidSystemDate(i, i2, i3, UtilitySetupSettingAdapter.this.context);
                    if (UtilitySetupSettingAdapter.this.utilityParam != null) {
                        UtilitySetupSettingAdapter.this.utilityParam.saveDate(System.currentTimeMillis());
                    }
                }
            }
        });
    }

    private void resizePikcer(FrameLayout frameLayout) {
        for (NumberPicker numberPicker : findNumberPicker(frameLayout)) {
            resizeNumberPicker(numberPicker);
            numberPicker.performClick();
        }
    }

    private List<NumberPicker> findNumberPicker(ViewGroup viewGroup) {
        ArrayList arrayList = new ArrayList();
        if (viewGroup != null) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt instanceof NumberPicker) {
                    arrayList.add((NumberPicker) childAt);
                } else if (childAt instanceof LinearLayout) {
                    List<NumberPicker> findNumberPicker = findNumberPicker((ViewGroup) childAt);
                    if (findNumberPicker.size() > 0) {
                        return findNumberPicker;
                    }
                } else {
                    continue;
                }
            }
        }
        return arrayList;
    }

    private void resizeNumberPicker(NumberPicker numberPicker) {
        setNumberPickerText(numberPicker);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ConvertUtils.dp2px(280.0f) / 3, -2);
        layoutParams.setMargins(10, 0, 10, 0);
        numberPicker.setLayoutParams(layoutParams);
    }

    public EditText setNumberPickerText(NumberPicker numberPicker) {
        try {
            Field declaredField = numberPicker.getClass().getDeclaredField("mInputText");
            declaredField.setAccessible(true);
            try {
                ((EditText) declaredField.get(numberPicker)).setTextSize(24.0f);
                ((EditText) declaredField.get(numberPicker)).setClickable(false);
                ((EditText) declaredField.get(numberPicker)).setFocusable(false);
                return (EditText) declaredField.get(numberPicker);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class BaseSettingViewHolder extends RecyclerView.ViewHolder {
        public BaseSettingViewHolder(AdapterUtilityBasesettingBinding adapterUtilityBasesettingBinding) {
            super(adapterUtilityBasesettingBinding.getRoot());
        }
    }
}
