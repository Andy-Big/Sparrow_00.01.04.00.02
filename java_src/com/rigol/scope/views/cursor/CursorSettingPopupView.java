package com.rigol.scope.views.cursor;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.PopupviewResultCursorBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.baseview.BaseDeletePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.window.WindowHolder;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class CursorSettingPopupView extends BaseDeletePopupView implements CompoundButton.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private AorBManager aorBManager;
    PopupviewResultCursorBinding binding;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private List<MathParam> mathParams;
    private PanelKeyViewModel panelKeyViewModel;
    public CursorResultParam param;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;
    private SyncDataViewModel syncDataViewModel;
    private List<VerticalParam> verticalParams;
    private WindowParam windowParam;

    private void selectSyncArea(MappingObject mappingObject) {
    }

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public CursorSettingPopupView() {
        super(R.style.App_PopupWindow_ResultCursor);
        this.list_aorbParam = new ArrayList();
        this.windowParam = null;
        this.syncDataViewModel = null;
        PopupviewResultCursorBinding inflate = PopupviewResultCursorBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (cursorViewModel == null) {
            return;
        }
        cursorViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$BUb0CA4XYbaFElgMZRc_wf-dm6c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CursorSettingPopupView.this.lambda$new$0$CursorSettingPopupView((CursorResultParam) obj);
            }
        });
        if (sharedViewModel != null) {
            sharedViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$ZZ-W6wpNK0rYN8JNrnTewhsx_So
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CursorSettingPopupView.this.lambda$new$1$CursorSettingPopupView((SharedParam) obj);
                }
            });
        }
        this.binding.setOnClickListener(this);
        this.binding.setManualMapping(ViewUtil.getMappingObject(R.array.msg_cursor_mode, ServiceEnum.CursorMode.cursor_mode_manual.value1));
        this.binding.setTrackMapping(ViewUtil.getMappingObject(R.array.msg_cursor_mode, ServiceEnum.CursorMode.cursor_mode_track.value1));
        this.binding.setXyMapping(ViewUtil.getMappingObject(R.array.msg_cursor_mode, ServiceEnum.CursorMode.cursor_mode_xy.value1));
        this.binding.xOrYSwitch.setOnCheckedChangeListener(this);
        this.binding.bothAbSwitch.setOnCheckedChangeListener(this);
        this.binding.manualRadioButton.setOnCheckedChangeListener(this);
        this.binding.trackRadioButton.setOnCheckedChangeListener(this);
        this.binding.xyRadioButton.setOnCheckedChangeListener(this);
        this.list_aorbParam.add(new AorBParam(this.binding.aLocationEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.bLocationEditText, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.aSrcSpinnertrack, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.aSrcSpinnermanual, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.aSrcSpinnerxy, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.unitSpinner, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.bSrcSpinner, 0, false, "", 2));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                showKey(CursorSettingPopupView.this.context, ((AorBParam) CursorSettingPopupView.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) CursorSettingPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                showKey(CursorSettingPopupView.this.context, ((AorBParam) CursorSettingPopupView.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) CursorSettingPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.aLocationEditText, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.bLocationEditText, true, ViewUtil.KEY_B);
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.syncDataViewModel = syncDataViewModel;
        if (syncDataViewModel != null) {
            syncDataViewModel.get(21, MessageID.MSG_CURSOR_MODE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<Object>() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.2
                @Override // androidx.lifecycle.Observer
                public void onChanged(Object obj) {
                }
            });
        }
        PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        this.panelKeyViewModel = panelKeyViewModel;
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$JRWbYTrx7xpTGNCSHGoQXX5zNMA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CursorSettingPopupView.this.lambda$new$4$CursorSettingPopupView((KeyEvent) obj);
                }
            });
        }
        ViewUtil.setSwitchButton(R.array.msg_cursor_type, this.binding.xOrYSwitch);
        ViewUtil.setSwitchButton(this.binding.bothAbSwitch);
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (mathViewModel != null) {
            mathViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$vHFlVlc8Ln5h1idfK-KfyJo7k2c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CursorSettingPopupView.this.lambda$new$5$CursorSettingPopupView((ArrayList) obj);
                }
            });
        }
        if (verticalViewModel != null) {
            verticalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$cmxTnZd229Tp6hNRK0K5sWSaHxY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    CursorSettingPopupView.this.lambda$new$6$CursorSettingPopupView((ArrayList) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$CursorSettingPopupView(CursorResultParam cursorResultParam) {
        this.param = cursorResultParam;
        this.binding.setCursorParam(cursorResultParam);
    }

    public /* synthetic */ void lambda$new$1$CursorSettingPopupView(SharedParam sharedParam) {
        if (this.param.getCursorMode() == ServiceEnum.CursorMode.cursor_mode_xy && sharedParam.getWindowCount() == 0) {
            this.param.setCursorMode(ServiceEnum.CursorMode.cursor_mode_manual);
        }
        this.binding.setSharedParam(sharedParam);
    }

    public /* synthetic */ void lambda$new$4$CursorSettingPopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(CursorSettingPopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$rUgdDpQw8ruBXtwuYq2Gn0Sa2LE
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    CursorSettingPopupView.this.lambda$new$2$CursorSettingPopupView(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$_syf28RGwtrBQyOugHhC6Q-1FkU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    CursorSettingPopupView.this.lambda$new$3$CursorSettingPopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$2$CursorSettingPopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$3$CursorSettingPopupView(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.a_src_spinnermanual /* 2131361830 */:
                selectASourceManual(mappingObject);
                return;
            case R.id.a_src_spinnertrack /* 2131361831 */:
                selectSourceTrack(mappingObject);
                return;
            case R.id.a_src_spinnerxy /* 2131361832 */:
                selectSourceXY(mappingObject);
                return;
            case R.id.b_src_spinner /* 2131362000 */:
                selectBSource(mappingObject);
                return;
            case R.id.sync_area_spinner /* 2131363984 */:
                selectSyncArea(mappingObject);
                return;
            case R.id.unit_spinner /* 2131364490 */:
                selectUnit(mappingObject);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ void lambda$new$5$CursorSettingPopupView(ArrayList arrayList) {
        this.mathParams = arrayList;
    }

    public /* synthetic */ void lambda$new$6$CursorSettingPopupView(ArrayList arrayList) {
        this.verticalParams = arrayList;
    }

    @Override // com.rigol.scope.views.baseview.BaseDeletePopupView, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == R.id.a_src_spinnermanual) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_cursor_manualsrc)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$XfSdgENrnoQmatYaERmmiBDBGYE
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    CursorSettingPopupView.this.lambda$onClick$7$CursorSettingPopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$HXeUuXEVH0lsVSGFRNphTvygOwE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    CursorSettingPopupView.this.lambda$onClick$8$CursorSettingPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.a_src_spinnertrack) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_cursor_tasrc)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$SZl7aucRYdwZMa6hoLcs8Ee4iw0
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    CursorSettingPopupView.this.lambda$onClick$9$CursorSettingPopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$JkxO95RfdUF-Z3hjm-wE3k_9Y78
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    CursorSettingPopupView.this.lambda$onClick$10$CursorSettingPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.sync_area_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_cursor_sync_area)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$sMZVWexmvBZZAtg6D4RofUYaymM
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    CursorSettingPopupView.this.lambda$onClick$11$CursorSettingPopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$alP_P3wbYZ8k4oAcWN5_YEZQJto
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    CursorSettingPopupView.this.lambda$onClick$12$CursorSettingPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.a_src_spinnerxy) {
            List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_XY);
            if (list == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                WindowHolder windowHolder = list.get(i);
                MappingObject mappingObject = new MappingObject();
                mappingObject.setValue(i);
                mappingObject.setStr("XY(CH" + ((windowHolder.getWindowParam().getSource1().value1 - ServiceEnum.Chan.chan1.value1) + 1) + ", CH" + ((windowHolder.getWindowParam().getSource2().value1 - ServiceEnum.Chan.chan1.value1) + 1) + ")");
                arrayList.add(mappingObject);
            }
            ViewUtil.showSpinner(this.anchor, view, arrayList, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$9SUhMqbNfrvzwvul0FAjzgBSGyU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    CursorSettingPopupView.this.lambda$onClick$13$CursorSettingPopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$3oetYeaRyOMG5dcr240D2FX9auQ
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, Object obj) {
                    CursorSettingPopupView.this.lambda$onClick$14$CursorSettingPopupView(view2, viewHolder, i2, (MappingObject) obj);
                }
            });
        } else if (id == R.id.b_src_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_cursor_tbsrc)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$RNUYkWO1RzAwzf6aK78JjT4W2Ds
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    CursorSettingPopupView.this.lambda$onClick$15$CursorSettingPopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$c_kJRHjo5uUm_GS40MV70vHALss
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, Object obj) {
                    CursorSettingPopupView.this.lambda$onClick$16$CursorSettingPopupView(view2, viewHolder, i2, (MappingObject) obj);
                }
            });
        } else if (id == R.id.unit_spinner) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList(this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? R.array.msg_cursor_timeunit : R.array.msg_cursor_vunit), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$zo1mKZLik5meshmQ_CjpkCx6cvc
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    CursorSettingPopupView.this.lambda$onClick$17$CursorSettingPopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.cursor.-$$Lambda$CursorSettingPopupView$pCZMUilzNz27K2UiwvIGJCyKwb0
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2, Object obj) {
                    CursorSettingPopupView.this.lambda$onClick$18$CursorSettingPopupView(view2, viewHolder, i2, (MappingObject) obj);
                }
            });
        } else if (id == R.id.a_location_edit_text) {
            int serviceIdFromChan = ViewUtil.getServiceIdFromChan(this.param.getSourceA());
            int serviceIdFromChan2 = ViewUtil.getServiceIdFromChan(this.param.getSourceB());
            if (this.param.readMode() == ServiceEnum.CursorMode.cursor_mode_manual) {
                int i2 = serviceIdFromChan - 17;
                if (i2 >= 0 && i2 <= 3) {
                    List<MathParam> list2 = this.mathParams;
                    if (list2 == null) {
                        return;
                    }
                    if (list2.get(i2).getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        if (this.aorBManager.setClick_showab(view.getId())) {
                            ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.mathParams.get(i2).getFftFreqUnit() : this.mathParams.get(i2).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.MICRO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.3
                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public <T> void resultMinUnitValueListener(T t) {
                                    if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                        CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                                    } else {
                                        CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                                    }
                                }

                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public void onCall(KeyboardPopupView keyboardPopupView) {
                                    CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                                }
                            });
                            return;
                        }
                        return;
                    } else if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getUnit() : this.mathParams.get(i2).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.FEMTO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.4
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                    CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                                } else {
                                    CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                                }
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                int i3 = serviceIdFromChan - 1;
                if (i3 < 0 || i3 > 3 || !this.aorBManager.setClick_showab(view.getId())) {
                    return;
                }
                ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getUnit() : this.verticalParams.get(i3).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.5
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                            CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                        } else {
                            CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                        }
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            } else if (this.param.readMode() == ServiceEnum.CursorMode.cursor_mode_track) {
                int i4 = serviceIdFromChan - 17;
                if (i4 >= 0 && i4 <= 3) {
                    List<MathParam> list3 = this.mathParams;
                    if (list3 == null) {
                        return;
                    }
                    if (list3.get(i4).getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        if (this.aorBManager.setClick_showab(view.getId())) {
                            ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.mathParams.get(i4).getFftFreqUnit() : this.mathParams.get(i4).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.MICRO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.6
                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public <T> void resultMinUnitValueListener(T t) {
                                    if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                        CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                                    } else {
                                        CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                                    }
                                }

                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public void onCall(KeyboardPopupView keyboardPopupView) {
                                    CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                                }
                            });
                            return;
                        }
                        return;
                    } else if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getUnit() : this.mathParams.get(i4).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.FEMTO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.7
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                    CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                                } else {
                                    CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                                }
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                int i5 = serviceIdFromChan - 1;
                if (i5 < 0 || i5 > 3 || !this.aorBManager.setClick_showab(view.getId())) {
                    return;
                }
                ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getUnit() : this.verticalParams.get(i5).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.8
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                            CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                        } else {
                            CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                        }
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            } else if (this.param.readMode() == ServiceEnum.CursorMode.cursor_mode_xy) {
                int i6 = serviceIdFromChan - 17;
                if (i6 >= 0 && i6 <= 3) {
                    List<MathParam> list4 = this.mathParams;
                    if (list4 == null) {
                        return;
                    }
                    if (list4.get(i6).getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        if (this.aorBManager.setClick_showab(view.getId())) {
                            ViewUtil.showKeyboard(this.anchor, view, (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.mathParams.get(i6) : this.mathParams.get(serviceIdFromChan2 - 17)).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.MICRO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.9
                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public <T> void resultMinUnitValueListener(T t) {
                                    if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                        CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                                    } else {
                                        CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                                    }
                                }

                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public void onCall(KeyboardPopupView keyboardPopupView) {
                                    CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                                }
                            });
                            return;
                        }
                        return;
                    } else if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.anchor, view, (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.mathParams.get(i6) : this.mathParams.get(serviceIdFromChan2 - 17)).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.FEMTO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.10
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                    CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                                } else {
                                    CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                                }
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                int i7 = serviceIdFromChan - 1;
                if (i7 < 0 || i7 > 3 || !this.aorBManager.setClick_showab(view.getId())) {
                    return;
                }
                ViewUtil.showKeyboard(this.anchor, view, (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.verticalParams.get(i7) : this.verticalParams.get(serviceIdFromChan2 - 1)).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAxAttr() : this.param.getAyAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getAx() : this.param.getAy(), new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.11
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                            CursorSettingPopupView.this.param.saveAx(((Long) t).longValue());
                        } else {
                            CursorSettingPopupView.this.param.saveAy(((Long) t).longValue());
                        }
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.b_location_edit_text) {
            int serviceIdFromChan3 = ViewUtil.getServiceIdFromChan(this.param.getSourceA());
            int serviceIdFromChan4 = ViewUtil.getServiceIdFromChan(this.param.getSourceB());
            if (this.param.readMode() == ServiceEnum.CursorMode.cursor_mode_manual) {
                int i8 = serviceIdFromChan3 - 17;
                if (i8 >= 0 && i8 <= 3) {
                    List<MathParam> list5 = this.mathParams;
                    if (list5 == null) {
                        return;
                    }
                    if (list5.get(i8).getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        if (this.aorBManager.setClick_showab(view.getId())) {
                            ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.mathParams.get(i8).getFftFreqUnit() : this.mathParams.get(i8).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.MICRO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.12
                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public <T> void resultMinUnitValueListener(T t) {
                                    if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                        CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                                    } else {
                                        CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                                    }
                                }

                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public void onCall(KeyboardPopupView keyboardPopupView) {
                                    CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                                }
                            });
                            return;
                        }
                        return;
                    } else if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getUnit() : this.mathParams.get(i8).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.FEMTO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.13
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                    CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                                } else {
                                    CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                                }
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                int i9 = serviceIdFromChan3 - 1;
                if (i9 < 0 || i9 > 3 || !this.aorBManager.setClick_showab(view.getId())) {
                    return;
                }
                ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getUnit() : this.verticalParams.get(i9).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.14
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                            CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                        } else {
                            CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                        }
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            } else if (this.param.readMode() == ServiceEnum.CursorMode.cursor_mode_track) {
                int i10 = serviceIdFromChan4 - 17;
                if (i10 >= 0 && i10 <= 3) {
                    if (this.mathParams.get(i10).getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        if (this.aorBManager.setClick_showab(view.getId())) {
                            ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.mathParams.get(i10).getFftFreqUnit() : this.mathParams.get(i10).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.MICRO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.15
                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public <T> void resultMinUnitValueListener(T t) {
                                    if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                        CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                                    } else {
                                        CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                                    }
                                }

                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public void onCall(KeyboardPopupView keyboardPopupView) {
                                    CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                                }
                            });
                            return;
                        }
                        return;
                    } else if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getUnit() : this.mathParams.get(i10).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.FEMTO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.16
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                    CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                                } else {
                                    CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                                }
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                int i11 = serviceIdFromChan4 - 1;
                if (i11 < 0 || i11 > 3 || !this.aorBManager.setClick_showab(view.getId())) {
                    return;
                }
                ViewUtil.showKeyboard(this.anchor, view, this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getUnit() : this.verticalParams.get(i11).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.17
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                            CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                        } else {
                            CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                        }
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            } else if (this.param.readMode() == ServiceEnum.CursorMode.cursor_mode_xy) {
                int i12 = serviceIdFromChan4 - 17;
                if (i12 >= 0 && i12 <= 3) {
                    List<MathParam> list6 = this.mathParams;
                    if (list6 == null) {
                        return;
                    }
                    if (list6.get(i12).getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        if (this.aorBManager.setClick_showab(view.getId())) {
                            ViewUtil.showKeyboard(this.anchor, view, (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.mathParams.get(serviceIdFromChan3 - 17) : this.mathParams.get(i12)).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.MICRO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.18
                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public <T> void resultMinUnitValueListener(T t) {
                                    if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                        CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                                    } else {
                                        CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                                    }
                                }

                                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                                public void onCall(KeyboardPopupView keyboardPopupView) {
                                    CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                                }
                            });
                            return;
                        }
                        return;
                    } else if (this.aorBManager.setClick_showab(view.getId())) {
                        ViewUtil.showKeyboard(this.anchor, view, (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.mathParams.get(serviceIdFromChan3 - 17) : this.mathParams.get(i12)).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? UnitFormat.SI.FEMTO : UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.19
                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public <T> void resultMinUnitValueListener(T t) {
                                if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                                    CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                                } else {
                                    CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                                }
                            }

                            @Override // com.rigol.scope.views.keyboard.KeyboardListener
                            public void onCall(KeyboardPopupView keyboardPopupView) {
                                CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                            }
                        });
                        return;
                    } else {
                        return;
                    }
                }
                int i13 = serviceIdFromChan4 - 1;
                if (i13 < 0 || i13 > 3 || !this.aorBManager.setClick_showab(view.getId())) {
                    return;
                }
                ViewUtil.showKeyboard(this.anchor, view, (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.verticalParams.get(serviceIdFromChan3 - 1) : this.verticalParams.get(i13)).readUnit(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMaxLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getMinLongValue(), (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBxAttr() : this.param.getByAttr()).getDefLongValue(), this.param.getView() == ServiceEnum.CursorView.cursor_view_hori ? this.param.getBx() : this.param.getBy(), new KeyboardListener() { // from class: com.rigol.scope.views.cursor.CursorSettingPopupView.20
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        if (CursorSettingPopupView.this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                            CursorSettingPopupView.this.param.saveBx(((Long) t).longValue());
                        } else {
                            CursorSettingPopupView.this.param.saveBy(((Long) t).longValue());
                        }
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        CursorSettingPopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$onClick$7$CursorSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$CursorSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectASourceManual(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$CursorSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$CursorSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceTrack(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$11$CursorSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$12$CursorSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSyncArea(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$13$CursorSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$14$CursorSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSourceXY(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$15$CursorSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$16$CursorSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectBSource(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$17$CursorSettingPopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$18$CursorSettingPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectUnit(mappingObject);
    }

    private void selectUnit(MappingObject mappingObject) {
        ServiceEnum.Unit unitFromValue1 = ServiceEnum.getUnitFromValue1(mappingObject.getValue());
        if (unitFromValue1 != null) {
            this.param.saveUnit(unitFromValue1);
        }
    }

    private void selectBSource(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.saveSourceB(chanFromValue1);
        }
    }

    private void selectSourceXY(MappingObject mappingObject) {
        WindowHolder windowXy = ViewUtil.getWindowXy(mappingObject.getValue());
        if (windowXy != null) {
            WindowParam windowParam = windowXy.getWindowParam();
            this.param.saveSourceA(windowParam.getSource1());
            this.param.saveSourceB(windowParam.getSource2());
        }
    }

    private void selectSourceTrack(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.saveSourceA(chanFromValue1);
            WindowParam windowParam = this.windowParam;
            if (windowParam != null) {
                windowParam.setSource1(chanFromValue1);
            }
        }
    }

    private void selectASourceManual(MappingObject mappingObject) {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
        if (chanFromValue1 != null) {
            this.param.saveSourceA(chanFromValue1);
        }
    }

    public void cursorSettingLight() {
        PopupViewManager.getInstance().closeAllLight();
        LogUtils.e("getCursorMode", "getCursorMode");
        int i = AnonymousClass21.$SwitchMap$com$rigol$scope$cil$ServiceEnum$CursorMode[this.param.getCursorMode().ordinal()];
        if (i != 1 && i != 2) {
            if (i != 3) {
                return;
            }
            if (this.param.getView() == ServiceEnum.CursorView.cursor_view_vert) {
                PopupViewManager.getInstance().verticalLight();
                return;
            }
            PopupViewManager.getInstance().horizontalLight();
            ViewUtil.getViewABkeyViewModel().getPopuwind_boolean().setValue(false);
        } else if (this.param.getView() == ServiceEnum.CursorView.cursor_view_vert) {
            PopupViewManager.getInstance().verticalLight();
            ViewUtil.getViewABkeyViewModel().getAx_boolean().setValue(false);
            ViewUtil.getViewABkeyViewModel().getBx_boolean().setValue(false);
            ViewUtil.getViewABkeyViewModel().getAy_boolean().setValue(true);
            ViewUtil.getViewABkeyViewModel().getBy_boolean().setValue(true);
        } else {
            PopupViewManager.getInstance().horizontalLight();
            ViewUtil.getViewABkeyViewModel().getAx_boolean().setValue(true);
            ViewUtil.getViewABkeyViewModel().getBx_boolean().setValue(true);
            ViewUtil.getViewABkeyViewModel().getAy_boolean().setValue(false);
            ViewUtil.getViewABkeyViewModel().getBy_boolean().setValue(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.cursor.CursorSettingPopupView$21  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass21 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$CursorMode;

        static {
            int[] iArr = new int[ServiceEnum.CursorMode.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$CursorMode = iArr;
            try {
                iArr[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$CursorMode[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$CursorMode[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        WindowHolder windowXy;
        int id = compoundButton.getId();
        if (compoundButton.isPressed()) {
            if (id == R.id.x_or_y_switch) {
                this.param.saveXorY(z);
                cursorSettingLight();
                if (this.param.isBothAB() || this.param.readMode() == ServiceEnum.CursorMode.cursor_mode_track) {
                    if (z) {
                        ViewUtil.getViewABkeyViewModel().getAx_boolean().setValue(false);
                        ViewUtil.getViewABkeyViewModel().getBx_boolean().setValue(false);
                        ViewUtil.getViewABkeyViewModel().getAy_boolean().setValue(true);
                        ViewUtil.getViewABkeyViewModel().getBy_boolean().setValue(true);
                        return;
                    }
                    ViewUtil.getViewABkeyViewModel().getAx_boolean().setValue(true);
                    ViewUtil.getViewABkeyViewModel().getBx_boolean().setValue(true);
                    ViewUtil.getViewABkeyViewModel().getAy_boolean().setValue(false);
                    ViewUtil.getViewABkeyViewModel().getBy_boolean().setValue(false);
                }
            } else if (id == R.id.manual_radio_button) {
                if (z) {
                    this.param.saveMode(ServiceEnum.CursorMode.cursor_mode_manual);
                    cursorSettingLight();
                }
            } else if (id == R.id.track_radio_button) {
                if (z) {
                    this.param.saveMode(ServiceEnum.CursorMode.cursor_mode_track);
                    cursorSettingLight();
                }
            } else if (id == R.id.xy_radio_button) {
                if (z) {
                    if (ViewUtil.getWindowXyIndex(this.param.getSourceA(), this.param.getSourceB()) == -1 && (windowXy = ViewUtil.getWindowXy(0)) != null) {
                        windowXy.getWindowParam();
                    }
                    this.param.saveMode(ServiceEnum.CursorMode.cursor_mode_xy);
                }
            } else if (id == R.id.both_ab_switch) {
                if (z) {
                    if (this.binding.xOrYSwitch.isChecked()) {
                        ViewUtil.getViewABkeyViewModel().getAx_boolean().setValue(false);
                        ViewUtil.getViewABkeyViewModel().getBx_boolean().setValue(false);
                        ViewUtil.getViewABkeyViewModel().getAy_boolean().setValue(true);
                        ViewUtil.getViewABkeyViewModel().getBy_boolean().setValue(true);
                    } else {
                        ViewUtil.getViewABkeyViewModel().getAx_boolean().setValue(true);
                        ViewUtil.getViewABkeyViewModel().getBx_boolean().setValue(true);
                        ViewUtil.getViewABkeyViewModel().getAy_boolean().setValue(false);
                        ViewUtil.getViewABkeyViewModel().getBy_boolean().setValue(false);
                    }
                }
                this.param.saveBothAB(z);
            }
        }
    }

    public void cursorLight() {
        PopupViewManager.getInstance().setLight(this.aorBManager);
        cursorHintHide();
    }

    public void cursorHintHide() {
        if (this.param.getView() == ServiceEnum.CursorView.cursor_view_hori) {
            CursorResultParam cursorResultParam = this.param;
            cursorResultParam.saveAx(cursorResultParam.readAx());
            CursorResultParam cursorResultParam2 = this.param;
            cursorResultParam2.saveBx(cursorResultParam2.readBx());
            return;
        }
        CursorResultParam cursorResultParam3 = this.param;
        cursorResultParam3.saveAy(cursorResultParam3.readAy());
        CursorResultParam cursorResultParam4 = this.param;
        cursorResultParam4.saveBy(cursorResultParam4.readBy());
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        CursorResultParam cursorResultParam = this.param;
        if (cursorResultParam != null) {
            cursorResultParam.notifyPropertyChanged(205);
            this.param.notifyPropertyChanged(1032);
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        CursorResultParam cursorResultParam = this.param;
        if (cursorResultParam == null) {
            return;
        }
        if (i == R.id.a_location_edit_text) {
            if (cursorResultParam.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                CursorResultParam cursorResultParam2 = this.param;
                cursorResultParam2.saveAx(cursorResultParam2.getLongStep(cursorResultParam2.readAx(), this.param.getAxAttr(), z, keyEvent));
                return;
            }
            CursorResultParam cursorResultParam3 = this.param;
            cursorResultParam3.saveAy(cursorResultParam3.getLongStep(cursorResultParam3.readAy(), this.param.getAyAttr(), z, keyEvent));
        } else if (i != R.id.b_location_edit_text) {
        } else {
            if (cursorResultParam.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                CursorResultParam cursorResultParam4 = this.param;
                cursorResultParam4.saveBx(cursorResultParam4.getLongStep(cursorResultParam4.readBx(), this.param.getBxAttr(), z, keyEvent));
                return;
            }
            CursorResultParam cursorResultParam5 = this.param;
            cursorResultParam5.saveBy(cursorResultParam5.getLongStep(cursorResultParam5.readBy(), this.param.getByAttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        CursorResultParam cursorResultParam = this.param;
        if (cursorResultParam == null) {
            return;
        }
        if (i == R.id.a_location_edit_text) {
            if (cursorResultParam.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                CursorResultParam cursorResultParam2 = this.param;
                cursorResultParam2.saveAx(cursorResultParam2.getLongDef(cursorResultParam2.getAxAttr()));
                return;
            }
            CursorResultParam cursorResultParam3 = this.param;
            cursorResultParam3.saveAy(cursorResultParam3.getLongDef(cursorResultParam3.getAyAttr()));
        } else if (i != R.id.b_location_edit_text) {
        } else {
            if (cursorResultParam.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                CursorResultParam cursorResultParam4 = this.param;
                cursorResultParam4.saveBx(cursorResultParam4.getLongDef(cursorResultParam4.getBxAttr()));
                return;
            }
            CursorResultParam cursorResultParam5 = this.param;
            cursorResultParam5.saveBy(cursorResultParam5.getLongDef(cursorResultParam5.getByAttr()));
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        PopupViewManager.getInstance().cursorABHint();
        CursorResultParam cursorResultParam = this.param;
        cursorResultParam.saveBx(cursorResultParam.readBx());
    }

    public void setWindowParam(WindowParam windowParam) {
        this.windowParam = windowParam;
    }

    public WindowParam getWindowParam() {
        return this.windowParam;
    }
}
