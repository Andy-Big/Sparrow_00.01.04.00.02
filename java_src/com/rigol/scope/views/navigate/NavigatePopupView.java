package com.rigol.scope.views.navigate;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.NavigateParam;
import com.rigol.scope.databinding.PopupviewNavigateBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.NavigateViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.navigate.NavigatePopupView;
import com.rigol.scope.views.search.SearchPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class NavigatePopupView extends BasePopupView implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final String BIGGER;
    private final int FIVEHUNDRED;
    private final String SMALLER;
    private final int TWOHUNDREDFIVE;
    private AorBManager aorBManager;
    private PopupviewNavigateBinding binding;
    private View clickedView;
    private HorizontalParam horizonParam;
    private HorizontalViewModel horizontalViewModel;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private NavigateParam navigateParam;
    private NavigateViewModel navigateViewModel;
    private PanelKeyViewModel panelKeyViewModel;
    private PopupSpinner popupSpinner;
    private ImageView small;
    private SpinnerAdapter spinnerAdapter;
    protected UpdateUIViewModel updateUIViewModel;

    public NavigatePopupView() {
        super((int) R.style.App_PopupWindow_Navigate);
        this.list_aorbParam = new ArrayList();
        this.SMALLER = "ic_smaller";
        this.BIGGER = "ic_bigger";
        this.FIVEHUNDRED = 500;
        this.TWOHUNDREDFIVE = 250;
        PopupviewNavigateBinding inflate = PopupviewNavigateBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        initPopWindow();
        NavigateViewModel navigateViewModel = (NavigateViewModel) ContextUtil.getAppViewModel(NavigateViewModel.class);
        this.navigateViewModel = navigateViewModel;
        if (navigateViewModel != null) {
            navigateViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$SyVcGtRKvI92XAjCHrHQUFBYavY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    NavigatePopupView.this.lambda$new$0$NavigatePopupView((NavigateParam) obj);
                }
            });
        }
        this.binding.getRoot().post(new Runnable() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$XyJSGx5pe4KtD7B9bcpwq3V54-k
            @Override // java.lang.Runnable
            public final void run() {
                NavigatePopupView.this.lambda$new$1$NavigatePopupView();
            }
        });
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.horizontalViewModel = horizontalViewModel;
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.navigate.NavigatePopupView.2
                @Override // androidx.lifecycle.Observer
                public void onChanged(HorizontalParam horizontalParam) {
                    NavigatePopupView.this.horizonParam = horizontalParam;
                    NavigatePopupView.this.binding.setHorizontal(horizontalParam);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$NavigatePopupView(NavigateParam navigateParam) {
        this.navigateParam = navigateParam;
        this.binding.setParam(navigateParam);
    }

    public /* synthetic */ void lambda$new$1$NavigatePopupView() {
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(58, MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<Object>() { // from class: com.rigol.scope.views.navigate.NavigatePopupView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(Object obj) {
                    if (NavigatePopupView.this.navigateParam.readNavMode() == 0) {
                        if (NavigatePopupView.this.navigateParam.readTimePlay()) {
                            NavigatePopupView.this.navigateParam.setIfPlaying(true);
                            NavigatePopupView.this.binding.playImage.setImageDrawable(ContextCompat.getDrawable(NavigatePopupView.this.context, R.drawable.record_play1));
                            NavigatePopupView.this.binding.playImage.setTag(true);
                            return;
                        }
                    } else if (2 == NavigatePopupView.this.navigateParam.readNavMode() && NavigatePopupView.this.navigateParam.readFramePlay()) {
                        NavigatePopupView.this.navigateParam.setIfPlaying(true);
                        NavigatePopupView.this.binding.playImage.setImageDrawable(ContextCompat.getDrawable(NavigatePopupView.this.context, R.drawable.record_play1));
                        NavigatePopupView.this.binding.playImage.setTag(true);
                        return;
                    }
                    if (12 == obj) {
                        NavigatePopupView.this.navigateParam.readHorRun();
                        return;
                    }
                    NavigatePopupView.this.navigateParam.setIfPlaying(false);
                    NavigatePopupView.this.binding.playImage.setImageDrawable(ContextCompat.getDrawable(NavigatePopupView.this.context, R.drawable.record_pause1));
                    NavigatePopupView.this.binding.playImage.setTag(false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onShow() {
        super.onShow();
        this.navigateParam.readHorRun();
        this.navigateParam.readNavMode();
        this.navigateParam.readDisPlayMode();
        this.navigateParam.readStartFrameAttr();
        this.navigateParam.readEndFrameAttr();
        this.navigateParam.readDisplayFrame();
        this.navigateParam.readStartFrame();
        this.navigateParam.readSerchType();
        this.navigateParam.setIfPlaying(false);
        if (ServiceEnum.AcquireMode.Acquire_Ultra == this.horizonParam.getAcquireMode()) {
            this.navigateParam.saveNavEnable(true);
            this.navigateParam.saveNavMode(2);
            this.binding.frameRadio.setChecked(true);
        } else if (1 == this.navigateParam.getSelectMode()) {
            this.navigateParam.saveNavEnable(true);
            this.navigateParam.saveNavMode(1);
        } else {
            this.navigateParam.saveNavEnable(true);
            this.navigateParam.saveNavMode(0);
        }
    }

    private void initPopWindow() {
        ImageView imageView = (ImageView) this.binding.getRoot().findViewById(R.id.small);
        this.small = imageView;
        imageView.setTag("ic_smaller");
        this.small.setVisibility(0);
        this.small.setOnClickListener(this);
        this.binding.serchButton.setOnClickListener(this);
        this.binding.speedSpinner.setOnClickListener(this);
        this.binding.typeSpinner.setOnClickListener(this);
        this.binding.frameSpeedSpinner.setOnClickListener(this);
        this.binding.visibleSpinner.setOnClickListener(this);
        this.binding.recordToStartImage.setOnClickListener(this);
        this.binding.playLastImage.setOnClickListener(this);
        this.binding.playImage.setOnClickListener(this);
        this.binding.playNextImage.setOnClickListener(this);
        this.binding.recordToEndImage.setOnClickListener(this);
        this.binding.startFrameEdit.setOnClickListener(this);
        this.binding.frameText.setOnClickListener(this);
        this.binding.modeRadio.setOnCheckedChangeListener(this);
        this.binding.playImage.setTag(false);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.startFrameEdit, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.frameText, 0, true, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.speedSpinner, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.typeSpinner, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.visibleSpinner, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.frameSpeedSpinner, 0, false, ViewUtil.KEY_A, 3));
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.views.navigate.NavigatePopupView.3
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                NavigatePopupView.this.aorBManager.showKey(NavigatePopupView.this.context, ((AorBParam) NavigatePopupView.this.list_aorbParam.get(i)).getTextView(), true, ((AorBParam) NavigatePopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                NavigatePopupView.this.aorBManager.showKey(NavigatePopupView.this.context, ((AorBParam) NavigatePopupView.this.list_aorbParam.get(i)).getTextView(), false, ((AorBParam) NavigatePopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.startFrameEdit, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.frameText, true, ViewUtil.KEY_B);
        if (this.panelKeyViewModel == null) {
            this.panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
        }
        PanelKeyViewModel panelKeyViewModel = this.panelKeyViewModel;
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new AnonymousClass4());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.navigate.NavigatePopupView$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass4 implements Observer<KeyEvent> {
        AnonymousClass4() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(KeyEvent keyEvent) {
            if (PopupViewManager.getInstance().isShowing(NavigatePopupView.class)) {
                NavigatePopupView.this.panelKeyViewModel.abSwitch(keyEvent, NavigatePopupView.this.clickedView, NavigatePopupView.this.popupSpinner, NavigatePopupView.this.mappingObjects, NavigatePopupView.this.spinnerAdapter, NavigatePopupView.this.aorBManager, NavigatePopupView.this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$4$_IwM2oJq2dUSjyRhqwYhIDtkiFg
                    @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                    public final void onCall(KeyboardPopupView keyboardPopupView) {
                        NavigatePopupView.AnonymousClass4.this.lambda$onChanged$0$NavigatePopupView$4(keyboardPopupView);
                    }
                }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$4$NLIMCrQ0aPXtLSdX-xovCl9i2Ao
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                    public final void onCall(int i, MappingObject mappingObject) {
                        NavigatePopupView.AnonymousClass4.this.lambda$onChanged$1$NavigatePopupView$4(i, mappingObject);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$onChanged$0$NavigatePopupView$4(KeyboardPopupView keyboardPopupView) {
            NavigatePopupView.this.keyboardPopupView = keyboardPopupView;
        }

        public /* synthetic */ void lambda$onChanged$1$NavigatePopupView$4(int i, MappingObject mappingObject) {
            if (NavigatePopupView.this.clickedView.getId() == R.id.speedSpinner) {
                NavigatePopupView.this.navigateParam.saveTimeSpeed(mappingObject.getValue());
            } else if (NavigatePopupView.this.clickedView.getId() == R.id.typeSpinner) {
                NavigatePopupView.this.navigateParam.saveSerchType(ServiceEnum.getenumSearchTypeFromValue1(mappingObject.getValue()).value1);
            } else if (NavigatePopupView.this.clickedView.getId() == R.id.visibleSpinner) {
                NavigatePopupView.this.navigateParam.saveDisPlayMode(mappingObject.getValue());
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.speedSpinner) {
            final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_navigate_timeoffset_speed);
            ViewUtil.showSpinner(this.anchor, view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$wouX6BvSKGDvoVMQhzufq1iCN2w
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    NavigatePopupView.this.lambda$onClick$2$NavigatePopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$RY1_8LP0SwRFhELcjZ4HhNT-qEI
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    NavigatePopupView.this.lambda$onClick$3$NavigatePopupView(list, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.typeSpinner) {
            final List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_search_type);
            ViewUtil.showSpinner(this.anchor, view, list2, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$-4QIGAmbwEvIXbKzldQM2Fvvsdc
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list3, View view2) {
                    NavigatePopupView.this.lambda$onClick$4$NavigatePopupView(popupSpinner, spinnerAdapter, list3, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$arJVao46Ty2dxR6foZTWRD_XJmo
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    NavigatePopupView.this.lambda$onClick$5$NavigatePopupView(list2, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.frameSpeedSpinner) {
            final List<MappingObject> list3 = ViewUtil.getList((int) R.array.msg_navigate_timeoffset_speed);
            ViewUtil.showSpinner(this.anchor, view, list3, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$jzlfRKrMq5Lf9yJOFjbk1tcNeSo
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list4, View view2) {
                    NavigatePopupView.this.lambda$onClick$6$NavigatePopupView(popupSpinner, spinnerAdapter, list4, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$RisrCK2Von9ZVm2jstO5AgkytGY
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    NavigatePopupView.this.lambda$onClick$7$NavigatePopupView(list3, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.visibleSpinner) {
            final List<MappingObject> list4 = ViewUtil.getList((int) R.array.msg_navigate_framedraw_displaymode);
            ViewUtil.showSpinner(this.anchor, view, list4, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$YcjQG1G4vk6t6vINOvEZSrdrUqw
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list5, View view2) {
                    NavigatePopupView.this.lambda$onClick$8$NavigatePopupView(popupSpinner, spinnerAdapter, list5, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.navigate.-$$Lambda$NavigatePopupView$UjXPRHZdWZxmIrYaO_X81o1kPA8
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    NavigatePopupView.this.lambda$onClick$9$NavigatePopupView(list4, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.small) {
            if ("ic_smaller".equals(this.small.getTag())) {
                this.small.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_bigger));
                this.small.setTag("ic_bigger");
                funSmallGone();
                updateLocation(getWidth() / 2, 250);
                return;
            }
            this.small.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_smaller));
            this.small.setTag("ic_smaller");
            funInitDialog();
            updateLocation(getWidth() / 2, 250);
        } else if (id == R.id.serchButton) {
            PopupViewManager.getInstance().toggle(SearchPopupView.class);
        } else if (id == R.id.recordToStartImage) {
            if (this.navigateParam.readNavMode() == 0) {
                NavigateParam navigateParam = this.navigateParam;
                navigateParam.saveStartFrame(MessageID.MSG_NAVIGATE_TIMEOFFSET_STARTFRAME, navigateParam.getTimeSpeed());
            } else if (1 == this.navigateParam.readNavMode()) {
                NavigateParam navigateParam2 = this.navigateParam;
                navigateParam2.saveStartFrame(MessageID.MSG_NAVIGATE_SEARCHEVENT_STARTFRAME, navigateParam2.getSerchType());
            } else {
                this.navigateParam.saveStartFrame(MessageID.MSG_NAVIGATE_FRAMEDRAW_PLAYSTARTFRAME, 0);
            }
        } else if (id == R.id.playLastImage) {
            if (this.navigateParam.readNavMode() == 0) {
                NavigateParam navigateParam3 = this.navigateParam;
                navigateParam3.saveBackFrame(MessageID.MSG_NAVIGATE_TIMEOFFSET_BACKFRAME, navigateParam3.getTimeSpeed());
            } else if (1 == this.navigateParam.readNavMode()) {
                NavigateParam navigateParam4 = this.navigateParam;
                navigateParam4.saveBackFrame(MessageID.MSG_NAVIGATE_SEARCHEVENT_BACKFRAME, navigateParam4.getSerchType());
            } else {
                this.navigateParam.saveEndFrame(MessageID.MSG_NAVIGATE_FRAMEDRAW_PLAYBACKFRAME, 0);
            }
        } else if (id == R.id.playImage) {
            if (((Boolean) this.binding.playImage.getTag()).booleanValue()) {
                funPause();
                return;
            }
            this.navigateParam.setIfPlaying(true);
            this.binding.playImage.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.record_play1));
            if (2 == this.navigateParam.readNavMode()) {
                this.navigateParam.savePlay(MessageID.MSG_NAVIGATE_FRAMEDRAW_PLAYING, true);
            } else if (this.navigateParam.readNavMode() == 0) {
                this.navigateParam.savePlay(MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING, true);
            }
            this.binding.playImage.setTag(true);
        } else if (id == R.id.playNextImage) {
            if (this.navigateParam.readNavMode() == 0) {
                NavigateParam navigateParam5 = this.navigateParam;
                navigateParam5.saveNextFrame(MessageID.MSG_NAVIGATE_TIMEOFFSET_NEXTFRAME, navigateParam5.getTimeSpeed());
            } else if (1 == this.navigateParam.readNavMode()) {
                NavigateParam navigateParam6 = this.navigateParam;
                navigateParam6.saveNextFrame(MessageID.MSG_NAVIGATE_SEARCHEVENT_NEXTFRAME, navigateParam6.getSerchType());
            } else {
                this.navigateParam.saveEndFrame(MessageID.MSG_NAVIGATE_FRAMEDRAW_PLAYNEXTFRAME, 0);
            }
        } else if (id != R.id.recordToEndImage) {
            if (id == R.id.startFrameEdit) {
                this.navigateParam.readStartFrameAttr();
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, this.navigateParam.getFramesAttr().getMaxIntValue(), this.navigateParam.getFramesAttr().getMinIntValue(), this.navigateParam.getFramesAttr().getDefIntValue(), this.navigateParam.readStartFrame(), new KeyboardListener() { // from class: com.rigol.scope.views.navigate.NavigatePopupView.5
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        NavigatePopupView.this.navigateParam.saveStartFrame(((Long) t).intValue());
                        NavigatePopupView.this.navigateParam.saveUsering();
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        NavigatePopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            } else if (id == R.id.frameText) {
                this.navigateParam.readEndFrameAttr();
                ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, this.navigateParam.getEndFrameAttr().getMaxIntValue(), this.navigateParam.getEndFrameAttr().getMinIntValue(), this.navigateParam.getEndFrameAttr().getDefIntValue(), this.navigateParam.readDisplayFrame(), new KeyboardListener() { // from class: com.rigol.scope.views.navigate.NavigatePopupView.6
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        NavigatePopupView.this.navigateParam.saveDisplayFrame(((Long) t).intValue());
                        NavigatePopupView.this.navigateParam.saveUsering();
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        NavigatePopupView.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (this.navigateParam.readNavMode() == 0) {
            NavigateParam navigateParam7 = this.navigateParam;
            navigateParam7.saveEndFrame(MessageID.MSG_NAVIGATE_TIMEOFFSET_ENDFRAME, navigateParam7.getTimeSpeed());
        } else if (1 == this.navigateParam.readNavMode()) {
            NavigateParam navigateParam8 = this.navigateParam;
            navigateParam8.saveEndFrame(MessageID.MSG_NAVIGATE_SEARCHEVENT_ENDFRAME, navigateParam8.getSerchType());
        } else {
            this.navigateParam.saveEndFrame(MessageID.MSG_NAVIGATE_FRAMEDRAW_PLAYENDFRAME, 0);
        }
    }

    public /* synthetic */ void lambda$onClick$2$NavigatePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$3$NavigatePopupView(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.navigateParam.saveTimeSpeed(((MappingObject) list.get(i)).getValue());
    }

    public /* synthetic */ void lambda$onClick$4$NavigatePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$5$NavigatePopupView(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.navigateParam.saveSerchType(((MappingObject) list.get(i)).getValue());
    }

    public /* synthetic */ void lambda$onClick$6$NavigatePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$7$NavigatePopupView(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.navigateParam.saveFrameSpeed(((MappingObject) list.get(i)).getValue());
    }

    public /* synthetic */ void lambda$onClick$8$NavigatePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$9$NavigatePopupView(List list, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.navigateParam.saveDisPlayMode(((MappingObject) list.get(i)).getValue());
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.eventRadio) {
            this.navigateParam.saveNavMode(1);
            funTypeVisible();
            this.binding.playImage.setVisibility(4);
            funPause();
        } else if (i == R.id.frameRadio) {
            this.navigateParam.saveNavMode(2);
            funFrameVisible();
            this.binding.playImage.setVisibility(0);
            funPause();
        } else if (i == R.id.timeRadio) {
            this.navigateParam.saveNavMode(0);
            funSpeedVisible();
            this.binding.playImage.setVisibility(0);
            funPause();
        }
        navigateLight();
    }

    public void navigateLight() {
        NavigateParam navigateParam = this.navigateParam;
        if (navigateParam == null) {
            return;
        }
        int selectMode = navigateParam.getSelectMode();
        if (selectMode == 0 || selectMode == 1) {
            PopupViewManager.getInstance().closeAllLight();
        } else if (selectMode != 2) {
        } else {
            PopupViewManager.getInstance().verticalLight();
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        this.small.setImageDrawable(ContextCompat.getDrawable(this.context, R.drawable.ic_smaller));
        this.small.setTag("ic_smaller");
        funInitDialog();
        funPause();
        this.navigateParam.saveNavEnable(false);
        this.navigateParam.setIfPlaying(false);
    }

    private void funSpeedVisible() {
        this.binding.speedLinear.setVisibility(0);
        this.binding.typeLinear.setVisibility(8);
        this.binding.frameLinear.setVisibility(8);
    }

    private void funTypeVisible() {
        this.binding.speedLinear.setVisibility(8);
        this.binding.typeLinear.setVisibility(0);
        this.binding.frameLinear.setVisibility(8);
    }

    private void funFrameVisible() {
        this.binding.speedLinear.setVisibility(8);
        this.binding.typeLinear.setVisibility(8);
        this.binding.frameLinear.setVisibility(0);
    }

    private void funSmallGone() {
        this.binding.modeRadio.setVisibility(8);
        this.binding.speedLinear.setVisibility(8);
        this.binding.typeLinear.setVisibility(8);
        this.binding.frameLinear.setVisibility(8);
        this.binding.lineView.setVisibility(8);
    }

    private void funInitDialog() {
        this.binding.modeRadio.setVisibility(0);
        this.binding.lineView.setVisibility(0);
        if (this.binding.timeRadio.isChecked()) {
            funSpeedVisible();
        } else if (this.binding.eventRadio.isChecked()) {
            funTypeVisible();
        } else if (this.binding.frameRadio.isChecked()) {
            funFrameVisible();
        }
    }

    private void funPause() {
        this.binding.playImage.setImageDrawable(this.context.getDrawable(R.drawable.record_pause1));
        if (2 == this.navigateParam.readNavMode()) {
            this.navigateParam.savePlay(MessageID.MSG_NAVIGATE_FRAMEDRAW_PLAYING, false);
        } else if (this.navigateParam.readNavMode() == 0) {
            this.navigateParam.savePlay(MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING, false);
        }
        this.binding.playImage.setTag(false);
        this.navigateParam.setIfPlaying(false);
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        NavigateParam navigateParam = this.navigateParam;
        if (navigateParam == null || !navigateParam.getNavEnable() || this.navigateParam.getIfPlaying()) {
            return;
        }
        if (i == R.id.frameText) {
            this.navigateParam.readEndFrameAttr();
            NavigateParam navigateParam2 = this.navigateParam;
            navigateParam2.saveDisplayFrame(this.aorBManager.getIntStep(navigateParam2.readDisplayFrame(), this.navigateParam.getEndFrameAttr(), z, keyEvent));
            this.navigateParam.saveUsering();
        } else if (i != R.id.startFrameEdit) {
        } else {
            this.navigateParam.readStartFrameAttr();
            NavigateParam navigateParam3 = this.navigateParam;
            navigateParam3.saveStartFrame(this.aorBManager.getIntStep(navigateParam3.readStartFrame(), this.navigateParam.getFramesAttr(), z, keyEvent));
            this.navigateParam.saveUsering();
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        NavigateParam navigateParam = this.navigateParam;
        if (navigateParam == null || !navigateParam.getNavEnable() || this.navigateParam.getIfPlaying()) {
            return;
        }
        if (i == R.id.frameText) {
            this.navigateParam.readEndFrameAttr();
            NavigateParam navigateParam2 = this.navigateParam;
            navigateParam2.saveDisplayFrame(this.aorBManager.getIntDef(navigateParam2.getEndFrameAttr()));
            this.navigateParam.saveUsering();
        } else if (i != R.id.startFrameEdit) {
        } else {
            this.navigateParam.readStartFrameAttr();
            NavigateParam navigateParam3 = this.navigateParam;
            navigateParam3.saveStartFrame(this.aorBManager.getIntDef(navigateParam3.getFramesAttr()));
            this.navigateParam.saveUsering();
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        NavigateParam navigateParam = this.navigateParam;
        if (navigateParam != null) {
            navigateParam.notifyPropertyChanged(937);
            this.navigateParam.notifyPropertyChanged(807);
            this.navigateParam.notifyPropertyChanged(348);
            this.navigateParam.notifyPropertyChanged(349);
        }
    }
}
