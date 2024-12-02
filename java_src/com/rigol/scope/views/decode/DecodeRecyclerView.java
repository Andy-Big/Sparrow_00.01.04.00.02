package com.rigol.scope.views.decode;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.Decode1553bAdapter;
import com.rigol.scope.adapters.DecodeArinc429Adapter;
import com.rigol.scope.adapters.DecodeCanAdapter;
import com.rigol.scope.adapters.DecodeFlexrayAdapter;
import com.rigol.scope.adapters.DecodeI2CAdapter;
import com.rigol.scope.adapters.DecodeI2SAdapter;
import com.rigol.scope.adapters.DecodeLinAdapter;
import com.rigol.scope.adapters.DecodeMostAdapter;
import com.rigol.scope.adapters.DecodeParallelAdapter;
import com.rigol.scope.adapters.DecodeRs232Adapter;
import com.rigol.scope.adapters.DecodeSentAdapter;
import com.rigol.scope.adapters.DecodeSpiAdapter;
import com.rigol.scope.adapters.DecodeUsbAdapter;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.AdapterItemPopupviewDecodeBinding;
import com.rigol.scope.databinding.AdapterItemPopupviewDecodeBindingImpl;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.save.SavePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* loaded from: classes2.dex */
public class DecodeRecyclerView {
    private View anchorview;
    private AorBManager aorBManager;
    private AdapterItemPopupviewDecodeBindingImpl binding;
    private View clickedView;
    private Context context;
    Decode1553bAdapter decode1553bAdapter;
    DecodeCanAdapter decodeCanAdapter;
    DecodeFlexrayAdapter decodeFlexrayAdapter;
    DecodeI2CAdapter decodeI2CAdapter;
    DecodeI2SAdapter decodeI2SAdapter;
    DecodeLinAdapter decodeLinAdapter;
    DecodeParallelAdapter decodeParallelAdapter;
    DecodeRs232Adapter decodeRs232Adapter;
    DecodeSpiAdapter decodeSpiAdapter;
    private DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder holder;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private List<MappingObject> mappingObjects;
    private OptionParam optionParam;
    private PanelKeyViewModel panelKeyViewModel;
    private DecodeParam param;
    private PopupSpinner popupSpinner;
    private PopupviewDecodeBinding popupviewDecodeBinding;
    private SpinnerAdapter spinnerAdapter;
    private SyncDataViewModel syncDataViewModel;

    public DecodeRecyclerView(Context context, DecodeParam decodeParam, View view, AdapterItemPopupviewDecodeBindingImpl adapterItemPopupviewDecodeBindingImpl, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.context = context;
        this.binding = adapterItemPopupviewDecodeBindingImpl;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.anchorview = view;
        this.holder = viewPagerHolder;
        initView(adapterItemPopupviewDecodeBindingImpl);
    }

    private void initView(final AdapterItemPopupviewDecodeBindingImpl adapterItemPopupviewDecodeBindingImpl) {
        HorizontalParam value;
        adapterItemPopupviewDecodeBindingImpl.setParam(this.param);
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null && (value = horizontalViewModel.getLiveData().getValue()) != null) {
            adapterItemPopupviewDecodeBindingImpl.setHorizontalParam(value);
        }
        ViewUtil.setSwitchButton(adapterItemPopupviewDecodeBindingImpl.decodeOnOffValue);
        ViewUtil.setSwitchButton(adapterItemPopupviewDecodeBindingImpl.decodeEvtValue);
        ViewUtil.setSwitchButton(adapterItemPopupviewDecodeBindingImpl.decodeLabelValue);
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$EHm1fWoHhDd3O_T0s9QwSfoKZFc
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DecodeRecyclerView.this.lambda$initView$0$DecodeRecyclerView((OptionParam) obj);
                }
            });
        }
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$ofO38GwjpkJ6wlWANx-SxwzrBX8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DecodeRecyclerView.this.lambda$initView$12$DecodeRecyclerView(view);
            }
        };
        adapterItemPopupviewDecodeBindingImpl.decodeCopyTrig.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeTypeValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeFormatValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeEvtFormatValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeEvtViewValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeOnOffValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeLabelValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeEvtValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeEvtExport.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeEvtJump.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBindingImpl.decodeCopyTrig.setOnClickListener(onClickListener);
        this.decodeParallelAdapter = new DecodeParallelAdapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        this.decodeRs232Adapter = new DecodeRs232Adapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        this.decodeI2CAdapter = new DecodeI2CAdapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        this.decodeI2SAdapter = new DecodeI2SAdapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        this.decodeLinAdapter = new DecodeLinAdapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        this.decodeSpiAdapter = new DecodeSpiAdapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        this.decodeCanAdapter = new DecodeCanAdapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        this.decodeFlexrayAdapter = new DecodeFlexrayAdapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        this.decode1553bAdapter = new Decode1553bAdapter(this.anchorview, this.param, this.context, this.popupviewDecodeBinding, this.holder);
        showDecode(adapterItemPopupviewDecodeBindingImpl, this.param.getType(), this.param);
        aBKeyInit();
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.syncDataViewModel = syncDataViewModel;
        if (syncDataViewModel != null) {
            syncDataViewModel.get(this.param.getServiceId(), MessageID.MSG_DECODE_TYPE).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$eEERoyCV2Hst64679t2ioA2lkJA
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DecodeRecyclerView.this.lambda$initView$13$DecodeRecyclerView(adapterItemPopupviewDecodeBindingImpl, obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$initView$0$DecodeRecyclerView(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$initView$12$DecodeRecyclerView(View view) {
        StorageSaveParam value;
        int id = view.getId();
        if (id == R.id.decode_onOff_value) {
            if (view instanceof CompoundButton) {
                this.param.saveOnOff(((CompoundButton) view).isChecked());
                FunctionManager.getInstance().setFlexKnobEnum(ServiceEnum.Function.FUN_DECODE, this.popupviewDecodeBinding.tabs.getSelectedTabPosition(), false);
                if (FunctionManager.getInstance().checkUltraIsOpen()) {
                    ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                }
            }
        } else if (id == R.id.decode_label_value) {
            if (view instanceof CompoundButton) {
                this.param.saveLabel(((CompoundButton) view).isChecked());
            }
        } else if (id == R.id.decode_evt_value) {
            if (view instanceof CompoundButton) {
                this.param.saveEvent(((CompoundButton) view).isChecked());
            }
        } else if (id == R.id.decode_type_value) {
            if (ViewUtil.checkModelEDU()) {
                ViewUtil.showSpinner(this.anchorview, view, KtUtilKt.filter(ViewUtil.getList((int) R.array.msg_decode_type), new Function1() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$ENDt0hjwR4D_K9iUDOHQEKj6lCw
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DecodeRecyclerView.this.lambda$initView$1$DecodeRecyclerView((MappingObject) obj);
                    }
                }), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$uAkELh_KCmjb4Wu5RwOr2XvOqhs
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        DecodeRecyclerView.this.lambda$initView$2$DecodeRecyclerView(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$2GfdLYmsppA49XtNuyta2jq5zpI
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        DecodeRecyclerView.this.lambda$initView$3$DecodeRecyclerView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else {
                ViewUtil.showSpinner(this.anchorview, view, ViewUtil.getList((int) R.array.msg_decode_type1), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$v4g9KV8oDwccLSpVOF1Y7uD5f2Y
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        DecodeRecyclerView.this.lambda$initView$4$DecodeRecyclerView(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$Oguito7ORQqFTQWW1c7dy-JspaU
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        DecodeRecyclerView.this.lambda$initView$5$DecodeRecyclerView(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        } else if (id == R.id.decode_evt_jump) {
            API.getInstance().UI_PostInt32(this.param.getServiceId(), MessageID.MSG_DECODE_EVT_JUMP, 0);
        } else if (id == R.id.decode_evt_export) {
            String UI_QueryStr = API.getInstance().UI_QueryStr(this.param.getServiceId(), MessageID.MSG_APP_DECODE_QUERY_EVT_CONTENT);
            if (TextUtils.isEmpty(UI_QueryStr)) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                return;
            }
            StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
            if (storageViewModel != null && (value = storageViewModel.getSaveLiveData().getValue()) != null) {
                value.setDecodeDataPath(UI_QueryStr);
                value.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_DECDAT);
                value.saveFileType(ServiceEnum.enFileType.FILETYPE_CSV.value1);
            }
            PopupViewManager.getInstance().toggle(SavePopupView.class);
        } else if (id == R.id.decode_copy_trig) {
            API.getInstance().UI_PostInt32(this.param.getServiceId(), MessageID.MSG_DECODE_COPY_TRIG, 0);
        } else if (id == R.id.decode_format_value) {
            ViewUtil.showSpinner(this.anchorview, view, ViewUtil.getList((int) R.array.msg_decode_format), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$gIE80XjJ1mtZ4-bBpf2YK1xi_Ks
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRecyclerView.this.lambda$initView$6$DecodeRecyclerView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$uwVINqJ67iKdXsSwXn7842H1D1M
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRecyclerView.this.lambda$initView$7$DecodeRecyclerView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_evt_format_value) {
            ViewUtil.showSpinner(this.anchorview, view, ViewUtil.getList((int) R.array.msg_decode_evt_format), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$7oWOYR21IdM92T0mvbw3VfeVpjk
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRecyclerView.this.lambda$initView$8$DecodeRecyclerView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$H5l0-UgMFMDKx-KNDMy7jGJRKbU
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRecyclerView.this.lambda$initView$9$DecodeRecyclerView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_evt_view_value) {
            ViewUtil.showSpinner(this.anchorview, view, ViewUtil.getList((int) R.array.msg_decode_evt_view), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$QZ1AJ0mPHttLnqzrZWwdAiVJbqc
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeRecyclerView.this.lambda$initView$10$DecodeRecyclerView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$_oefYXwO_kEp2fq5e8RWbRDlJaM
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeRecyclerView.this.lambda$initView$11$DecodeRecyclerView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        }
    }

    public /* synthetic */ Boolean lambda$initView$1$DecodeRecyclerView(MappingObject mappingObject) {
        ServiceEnum.DecodeBusType decodeBusTypeFromValue1;
        if (mappingObject == null || (decodeBusTypeFromValue1 = ServiceEnum.getDecodeBusTypeFromValue1(mappingObject.getValue())) == null) {
            return true;
        }
        return Boolean.valueOf(KtUtilKt.decodeBusTypeEnable(decodeBusTypeFromValue1, this.optionParam, Boolean.valueOf(((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getSeries() == 800)));
    }

    public /* synthetic */ void lambda$initView$2$DecodeRecyclerView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$initView$3$DecodeRecyclerView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectTypeValue(mappingObject);
    }

    public /* synthetic */ void lambda$initView$4$DecodeRecyclerView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$initView$5$DecodeRecyclerView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectTypeValue(mappingObject);
    }

    public /* synthetic */ void lambda$initView$6$DecodeRecyclerView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$initView$7$DecodeRecyclerView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectFormatValue(i);
    }

    public /* synthetic */ void lambda$initView$8$DecodeRecyclerView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$initView$9$DecodeRecyclerView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectEventFormatValue(i);
    }

    public /* synthetic */ void lambda$initView$10$DecodeRecyclerView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$initView$11$DecodeRecyclerView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectEventViewValue(i);
    }

    public /* synthetic */ void lambda$initView$13$DecodeRecyclerView(AdapterItemPopupviewDecodeBindingImpl adapterItemPopupviewDecodeBindingImpl, Object obj) {
        showDecode(adapterItemPopupviewDecodeBindingImpl, this.param.getType(), this.param);
    }

    private void selectEventFormatValue(int i) {
        DecodeParam decodeParam = this.param;
        if (decodeParam != null) {
            decodeParam.saveEvent_format(i);
        }
    }

    private void selectEventViewValue(int i) {
        DecodeParam decodeParam = this.param;
        if (decodeParam != null) {
            decodeParam.saveEvent_view(i);
        }
    }

    private void selectFormatValue(int i) {
        DecodeParam decodeParam = this.param;
        if (decodeParam != null) {
            decodeParam.saveFormat(i);
        }
    }

    private void selectTypeValue(MappingObject mappingObject) {
        if (this.param == null || mappingObject.getValue() >= 100) {
            return;
        }
        this.param.saveType(ServiceEnum.getDecodeBusTypeFromValue1(mappingObject.getValue()));
        showDecode(this.binding, ServiceEnum.getDecodeBusTypeFromValue1(mappingObject.getValue()), this.param);
    }

    private void setIsMOveAdapter() {
        this.decodeParallelAdapter.setIsMove(false);
        this.decodeRs232Adapter.setIsMove(false);
        this.decodeI2CAdapter.setIsMove(false);
        this.decodeI2SAdapter.setIsMove(false);
        this.decodeLinAdapter.setIsMove(false);
        this.decodeSpiAdapter.setIsMove(false);
        this.decodeCanAdapter.setIsMove(false);
        this.decodeFlexrayAdapter.setIsMove(false);
        this.decode1553bAdapter.setIsMove(false);
    }

    private void aBKeyInit() {
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodeTypeValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeFormatValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeEvtFormatValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeEvtViewValue, 0, false, "", 2));
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.decode.DecodeRecyclerView.1
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
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$yk_ePAlCaRDolZl-9ZOE4WoUTXo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeRecyclerView.this.lambda$aBKeyInit$15$DecodeRecyclerView((KeyEvent) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$aBKeyInit$15$DecodeRecyclerView(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        List<MappingObject> list;
        if (!PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) || (popupSpinner = this.popupSpinner) == null || !popupSpinner.isShowing() || (list = this.mappingObjects) == null) {
            return;
        }
        this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, list, this.spinnerAdapter, this.aorBManager, null, null, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.decode.-$$Lambda$DecodeRecyclerView$EGtQjEx-OdDnaEvKooCXSQT43kc
            @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
            public final void onCall(int i, MappingObject mappingObject) {
                DecodeRecyclerView.this.lambda$aBKeyInit$14$DecodeRecyclerView(i, mappingObject);
            }
        });
    }

    public /* synthetic */ void lambda$aBKeyInit$14$DecodeRecyclerView(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.decode_evt_format_value /* 2131362424 */:
                selectEventFormatValue(i);
                return;
            case R.id.decode_evt_view_value /* 2131362429 */:
                selectEventViewValue(i);
                return;
            case R.id.decode_format_value /* 2131362446 */:
                selectFormatValue(i);
                return;
            case R.id.decode_type_value /* 2131362636 */:
                selectTypeValue(mappingObject);
                return;
            default:
                return;
        }
    }

    private void showParallelAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        this.decodeParallelAdapter.setIsMove(true);
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decodeParallelAdapter);
    }

    private void showRS232Adapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        this.decodeRs232Adapter.setIsMove(true);
        decodeParam.readRs232_tx_thres();
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decodeRs232Adapter);
    }

    private void showI2CAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        decodeParam.readI2c_scl_thres();
        this.decodeI2CAdapter.setIsMove(true);
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decodeI2CAdapter);
    }

    private void showSPIAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        decodeParam.readSpi_miso_thres();
        decodeParam.readSpi_cs_thres();
        this.decodeSpiAdapter.setIsMove(true);
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decodeSpiAdapter);
    }

    private void showLINAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        this.decodeLinAdapter.setIsMove(true);
        decodeParam.readLin_thres();
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decodeLinAdapter);
    }

    private void showCANAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        this.decodeCanAdapter.setIsMove(true);
        decodeParam.readCan_threas();
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decodeCanAdapter);
    }

    private void showFlexRayAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        this.decodeFlexrayAdapter.setIsMove(true);
        decodeParam.readFlex_thres();
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decodeFlexrayAdapter);
    }

    private void showI2SAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        this.decodeI2SAdapter.setIsMove(true);
        decodeParam.readI2c_scl_thres();
        decodeParam.readI2c_sda_thres();
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decodeI2SAdapter);
    }

    private void show1553BAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        setIsMOveAdapter();
        this.decode1553bAdapter.setIsMove(true);
        decodeParam.read_1553b_thres1();
        decodeParam.read_1553b_thres2();
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(this.decode1553bAdapter);
    }

    private void showARINC429Adapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeArinc429Adapter(view, decodeParam));
    }

    private void showSENTAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeSentAdapter(view, decodeParam));
    }

    private void showMOSTAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeMostAdapter(view, decodeParam));
    }

    private void showUSBAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeUsbAdapter(view, decodeParam));
    }

    /* renamed from: com.rigol.scope.views.decode.DecodeRecyclerView$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType;

        static {
            int[] iArr = new int[ServiceEnum.DecodeBusType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType = iArr;
            try {
                iArr[ServiceEnum.DecodeBusType.Decode_Parallel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_RS232.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_I2C.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_SPI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_LIN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_CAN.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_FlexRay.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_I2S.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_1553B.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_ARINC429.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_SENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_MOST.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[ServiceEnum.DecodeBusType.Decode_USB.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
        }
    }

    public void showDecode(AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, ServiceEnum.DecodeBusType decodeBusType, DecodeParam decodeParam) {
        if (decodeBusType == null) {
            return;
        }
        switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$DecodeBusType[decodeBusType.ordinal()]) {
            case 1:
                showParallelAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 2:
                showRS232Adapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 3:
                showI2CAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 4:
                showSPIAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 5:
                showLINAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 6:
                showCANAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 7:
                showFlexRayAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 8:
                showI2SAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 9:
                show1553BAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 10:
                showARINC429Adapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 11:
                showSENTAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 12:
                showMOSTAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case 13:
                showUSBAdapter(this.anchorview, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
        }
        PopupViewManager.getInstance().decodeLightType();
    }
}
