package com.rigol.scope.adapters;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
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
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.decode.DecodePopupView;
import com.rigol.scope.views.save.SavePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
/* loaded from: classes.dex */
public class DecodeCommonAdapter extends BaseAdapter<List<DecodeParam>> {
    private boolean[] adapterInitArr;
    private View anchorView;
    private AorBManager aorBManager;
    private View clickedView;
    private Context context;
    private AdapterItemPopupviewDecodeBinding decodeBinding;
    private boolean isEnable;
    private Map<Integer, List<AorBParam>> mapList;
    private Map<Integer, AorBManager> mapManager;
    private List<MappingObject> mappingObjects;
    private OptionParam optionParam;
    private DecodeParam param;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;
    private int tabInt;

    public void setPanelKeyViewModel(final PanelKeyViewModel panelKeyViewModel) {
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$wsgp3NfJpXcR97dYHH69KnYcM_4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DecodeCommonAdapter.this.lambda$setPanelKeyViewModel$1$DecodeCommonAdapter(panelKeyViewModel, (KeyEvent) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$setPanelKeyViewModel$1$DecodeCommonAdapter(PanelKeyViewModel panelKeyViewModel, KeyEvent keyEvent) {
        if (this.isEnable && PopupViewManager.getInstance().isShowing(DecodePopupView.class)) {
            panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, null, null, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$iawdU7QFlYxfhkC59NBuPp7-3ho
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeCommonAdapter.this.lambda$setPanelKeyViewModel$0$DecodeCommonAdapter(i, mappingObject);
                }
            });
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    public /* synthetic */ void lambda$setPanelKeyViewModel$0$DecodeCommonAdapter(int i, MappingObject mappingObject) {
        if (this.clickedView.getId() == R.id.decode_type_value) {
            DecodeParam decodeParam = (DecodeParam) getItems().get(getCurrentItem());
            if (decodeParam == null) {
                return;
            }
            decodeParam.saveType(ServiceEnum.getDecodeBusTypeFromValue1(mappingObject.getValue()));
            showDecode(this.decodeBinding, ServiceEnum.getDecodeBusTypeFromValue1(mappingObject.getValue()), this.param);
        }
    }

    public DecodeCommonAdapter(Context context, int i) {
        super(context, i);
        this.mappingObjects = ViewUtil.getList((int) R.array.msg_decode_type);
        this.mapManager = new HashMap();
        this.mapList = new HashMap();
        this.adapterInitArr = new boolean[4];
        this.isEnable = true;
        this.tabInt = 0;
        this.context = context;
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$CRNvr7n1n1MEwZ5zqpv66OdYi_U
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DecodeCommonAdapter.this.lambda$new$2$DecodeCommonAdapter((OptionParam) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$2$DecodeCommonAdapter(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public AorBManager getAorBManager(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, int i) {
        AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding = (AdapterItemPopupviewDecodeBinding) baseViewHolder.getBinding();
        this.decodeBinding = adapterItemPopupviewDecodeBinding;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new AorBParam(adapterItemPopupviewDecodeBinding.decodeTypeValue, 0, false, "", 2));
        arrayList.add(new AorBParam(adapterItemPopupviewDecodeBinding.decodeFormatValue, 0, false, "", 2));
        arrayList.add(new AorBParam(adapterItemPopupviewDecodeBinding.decodeEvtFormatValue, 0, false, "", 2));
        arrayList.add(new AorBParam(adapterItemPopupviewDecodeBinding.decodeEvtViewValue, 0, false, "", 2));
        this.mapList.put(Integer.valueOf(i), arrayList);
        this.aorBManager = new AorBManager(this.context, arrayList) { // from class: com.rigol.scope.adapters.DecodeCommonAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
            }
        };
        this.mapManager.put(Integer.valueOf(i), this.aorBManager);
        this.adapterInitArr[i] = true;
        return this.aorBManager;
    }

    @Override // com.rigol.scope.adapters.BaseAdapter
    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<DecodeParam> list, int i) {
        HorizontalParam value;
        AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding = (AdapterItemPopupviewDecodeBinding) baseViewHolder.getBinding();
        ViewUtil.getViewABkeyViewModel().getViewpager_postion().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$3eBdBCaguKBWNd_tmJ7W-jRA-Ew
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DecodeCommonAdapter.this.lambda$convert$3$DecodeCommonAdapter((Float) obj);
            }
        });
        adapterItemPopupviewDecodeBinding.setParam(this.param);
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null && (value = horizontalViewModel.getLiveData().getValue()) != null) {
            adapterItemPopupviewDecodeBinding.setHorizontalParam(value);
        }
        ViewUtil.setSwitchButton(adapterItemPopupviewDecodeBinding.decodeOnOffValue);
        ViewUtil.setSwitchButton(adapterItemPopupviewDecodeBinding.decodeEvtValue);
        ViewUtil.setSwitchButton(adapterItemPopupviewDecodeBinding.decodeLabelValue);
        showDecode(adapterItemPopupviewDecodeBinding, this.param.getType(), this.param);
        getAorBManager(baseViewHolder, baseViewHolder.getLayoutPosition());
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List] */
    public /* synthetic */ void lambda$convert$3$DecodeCommonAdapter(Float f) {
        for (int i = 0; i < getItems().size(); i++) {
            if (ViewUtil.getViewABkeyViewModel().getViewpager_postion().getValue() != null) {
                ((DecodeParam) getItems().get(i)).setDecodeIsShow(false);
            } else {
                ((DecodeParam) getItems().get(i)).setDecodeIsShow(true);
            }
        }
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
        final BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
        final AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding = (AdapterItemPopupviewDecodeBinding) onCreateViewHolder.getBinding();
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$laSR6kbKdRsIEWCo9-iTmTSzbaU
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DecodeCommonAdapter.this.lambda$onCreateViewHolder$13$DecodeCommonAdapter(adapterItemPopupviewDecodeBinding, view);
            }
        };
        adapterItemPopupviewDecodeBinding.decodeCopyTrig.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeTypeValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeFormatValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeEvtFormatValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeEvtViewValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeOnOffValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeLabelValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeEvtValue.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeEvtExport.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeEvtJump.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.decodeCopyTrig.setOnClickListener(onClickListener);
        adapterItemPopupviewDecodeBinding.getRoot().post(new Runnable() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$Gmw1vTwFUcUd6T2_oeydX_x_CV8
            @Override // java.lang.Runnable
            public final void run() {
                DecodeCommonAdapter.this.lambda$onCreateViewHolder$15$DecodeCommonAdapter(onCreateViewHolder, adapterItemPopupviewDecodeBinding);
            }
        });
        return onCreateViewHolder;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$13$DecodeCommonAdapter(final AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, View view) {
        StorageSaveParam value;
        int currentItem = getCurrentItem();
        DecodeParam decodeParam = this.param;
        if (decodeParam == null) {
            return;
        }
        decodeParam.setCurrentItem(currentItem);
        if (this.anchorView != null) {
            this.isEnable = true;
            int id = view.getId();
            if (id == R.id.decode_onOff_value) {
                if (view instanceof CompoundButton) {
                    this.param.saveOnOff(((CompoundButton) view).isChecked());
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
                ViewUtil.showSpinner(this.anchorView, view, KtUtilKt.filter(ViewUtil.getList((int) R.array.msg_decode_type), new Function1() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$28Nw8cRcFQvb4sP04koSXaPU-Y0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return DecodeCommonAdapter.this.lambda$onCreateViewHolder$4$DecodeCommonAdapter((MappingObject) obj);
                    }
                }), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$SYk62tAwswEipnXBazewlrf4zyA
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        DecodeCommonAdapter.this.lambda$onCreateViewHolder$5$DecodeCommonAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$uATgb0ZEynGFErC3ZvLhcq1BTY8
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        DecodeCommonAdapter.this.lambda$onCreateViewHolder$6$DecodeCommonAdapter(adapterItemPopupviewDecodeBinding, view2, viewHolder, i, (MappingObject) obj);
                    }
                });
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
                ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_format), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$w8MmtoEk5vEXe9Wi1hJnqel55qU
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        DecodeCommonAdapter.this.lambda$onCreateViewHolder$7$DecodeCommonAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$PaFHz2FP8Zor4h8C6AvNo0LMUpQ
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        DecodeCommonAdapter.this.lambda$onCreateViewHolder$8$DecodeCommonAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else if (id == R.id.decode_evt_format_value) {
                ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_evt_format), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$2qWG_vJJqdhme1Ts5ddsR7ac4hY
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        DecodeCommonAdapter.this.lambda$onCreateViewHolder$9$DecodeCommonAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$CCQTuA0ubWtZlngOmSQTBw1pDVg
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        DecodeCommonAdapter.this.lambda$onCreateViewHolder$10$DecodeCommonAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            } else if (id == R.id.decode_evt_view_value) {
                ViewUtil.showSpinner(this.anchorView, view, ViewUtil.getList((int) R.array.msg_decode_evt_view), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$37zKqQucg8I9cfn3rCrfDgLCa1A
                    @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                    public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                        DecodeCommonAdapter.this.lambda$onCreateViewHolder$11$DecodeCommonAdapter(popupSpinner, spinnerAdapter, list, view2);
                    }
                }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$YWVLRtH_fUtS7dqsuasQEgpsFuY
                    @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                        DecodeCommonAdapter.this.lambda$onCreateViewHolder$12$DecodeCommonAdapter(view2, viewHolder, i, (MappingObject) obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ Boolean lambda$onCreateViewHolder$4$DecodeCommonAdapter(MappingObject mappingObject) {
        ServiceEnum.DecodeBusType decodeBusTypeFromValue1;
        if (mappingObject == null || (decodeBusTypeFromValue1 = ServiceEnum.getDecodeBusTypeFromValue1(mappingObject.getValue())) == null) {
            return true;
        }
        return Boolean.valueOf(KtUtilKt.decodeBusTypeEnable(decodeBusTypeFromValue1, this.optionParam, Boolean.valueOf(((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getSeries() == 800)));
    }

    public /* synthetic */ void lambda$onCreateViewHolder$5$DecodeCommonAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$6$DecodeCommonAdapter(AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveType(ServiceEnum.getDecodeBusTypeFromValue1(mappingObject.getValue()));
        showDecode(adapterItemPopupviewDecodeBinding, ServiceEnum.getDecodeBusTypeFromValue1(mappingObject.getValue()), this.param);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$7$DecodeCommonAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$8$DecodeCommonAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveFormat(i);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$9$DecodeCommonAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$10$DecodeCommonAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveEvent_format(i);
    }

    public /* synthetic */ void lambda$onCreateViewHolder$11$DecodeCommonAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onCreateViewHolder$12$DecodeCommonAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        this.param.saveEvent_view(i);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    public /* synthetic */ void lambda$onCreateViewHolder$15$DecodeCommonAdapter(BaseViewHolder baseViewHolder, final AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding) {
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition < 0 || bindingAdapterPosition >= getItems().size()) {
            return;
        }
        final DecodeParam decodeParam = (DecodeParam) getItems().get(bindingAdapterPosition);
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel == null || decodeParam == null) {
            return;
        }
        syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_TYPE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$OC3gEftg-1pKuf9-V8fwiL6OGgg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                DecodeCommonAdapter.this.lambda$onCreateViewHolder$14$DecodeCommonAdapter(adapterItemPopupviewDecodeBinding, decodeParam, obj);
            }
        });
    }

    public /* synthetic */ void lambda$onCreateViewHolder$14$DecodeCommonAdapter(AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam, Object obj) {
        showDecode(adapterItemPopupviewDecodeBinding, decodeParam.getType(), decodeParam);
    }

    public void setAnchor(View view) {
        this.anchorView = view;
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter
    public void setCurrentItem(final int i) {
        super.setCurrentItem(i);
        this.param.setCurrentItem(i);
        if (this.adapterInitArr[i] && this.mapManager.get(Integer.valueOf(i)) != null) {
            this.aorBManager = this.mapManager.get(Integer.valueOf(i));
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeCommonAdapter$5jzt8UrL7_7rriJIM9wLvfLqfhs
                @Override // java.lang.Runnable
                public final void run() {
                    DecodeCommonAdapter.this.lambda$setCurrentItem$16$DecodeCommonAdapter(i);
                }
            }, 500L);
        }
    }

    public /* synthetic */ void lambda$setCurrentItem$16$DecodeCommonAdapter(int i) {
        this.aorBManager = this.mapManager.get(Integer.valueOf(i));
    }

    private void getParam(boolean z) {
        this.isEnable = z;
    }

    private void showParallelAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeParallelAdapter(view, decodeParam, this.context));
    }

    private void showRS232Adapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeRs232Adapter(view, decodeParam, this.context));
    }

    private void showI2CAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeI2CAdapter(view, decodeParam, this.context));
    }

    private void showSPIAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeSpiAdapter(view, decodeParam, this.context));
    }

    private void showLINAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeLinAdapter(view, decodeParam, this.context));
    }

    private void showCANAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeCanAdapter(view, decodeParam, this.context));
    }

    private void showFlexRayAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeFlexrayAdapter(view, decodeParam, this.context));
    }

    private void showI2SAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new DecodeI2SAdapter(view, decodeParam, this.context));
    }

    private void show1553BAdapter(View view, AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, DecodeParam decodeParam) {
        adapterItemPopupviewDecodeBinding.decodeBusTypeView.setAdapter(new Decode1553bAdapter(view, decodeParam, this.context));
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

    public void showDecode(AdapterItemPopupviewDecodeBinding adapterItemPopupviewDecodeBinding, ServiceEnum.DecodeBusType decodeBusType, DecodeParam decodeParam) {
        if (decodeBusType == null) {
            return;
        }
        switch (decodeBusType) {
            case Decode_RS232:
                showRS232Adapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_I2C:
                showI2CAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_SPI:
                showSPIAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_LIN:
                showLINAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_CAN:
                showCANAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_FlexRay:
                showFlexRayAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_I2S:
                showI2SAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_1553B:
                show1553BAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_ARINC429:
                showARINC429Adapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_SENT:
                showSENTAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_MOST:
                showMOSTAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
            case Decode_USB:
                showUSBAdapter(this.anchorView, adapterItemPopupviewDecodeBinding, decodeParam);
                break;
        }
        PopupViewManager.getInstance().decodeLightType();
    }

    public void settabInt(int i) {
        this.tabInt = i;
    }

    private int getTabInt() {
        return this.tabInt;
    }
}
