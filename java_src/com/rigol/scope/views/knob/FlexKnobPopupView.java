package com.rigol.scope.views.knob;

import android.content.Context;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.OnItemClickListener;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.FlexKnobParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemFlexKnobBinding;
import com.rigol.scope.databinding.PopupviewFlexKnobBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.viewmodels.FlexKnobViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.RefViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.knob.FlexKnobPopupView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class FlexKnobPopupView extends BasePopupView implements CompoundButton.OnCheckedChangeListener {
    private AorBManager aorBManager;
    private PopupviewFlexKnobBinding binding;
    private View clickedView;
    private ListAdapter flexKnobAdapter;
    private FlexKnobViewModel flexKnobViewModel;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    public FlexKnobParam param;
    private PopupSpinner popupSpinner;
    private RefViewModel refViewModel;
    private SpinnerAdapter spinnerAdapter;
    private SyncDataViewModel syncDataViewModel;

    public FlexKnobPopupView() {
        super((int) R.style.App_PopupWindow_FlexKnobPopupView);
        this.list_aorbParam = new ArrayList();
        PopupviewFlexKnobBinding inflate = PopupviewFlexKnobBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        initView();
        FlexKnobViewModel flexKnobViewModel = (FlexKnobViewModel) ContextUtil.getAppViewModel(FlexKnobViewModel.class);
        this.flexKnobViewModel = flexKnobViewModel;
        if (flexKnobViewModel != null) {
            flexKnobViewModel.getLiveData();
            this.flexKnobViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new AnonymousClass1());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.knob.FlexKnobPopupView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 implements Observer<FlexKnobParam> {
        AnonymousClass1() {
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(FlexKnobParam flexKnobParam) {
            FlexKnobPopupView.this.param = flexKnobParam;
            FlexKnobPopupView.this.binding.setParam(FlexKnobPopupView.this.param);
            if (FlexKnobPopupView.this.flexKnobAdapter != null) {
                FlexKnobPopupView.this.flexKnobAdapter.setFlexKnobParam(flexKnobParam);
            }
            FlexKnobPopupView.this.param.setOnRefreshListener(new FlexKnobParam.OnRefreshListener() { // from class: com.rigol.scope.views.knob.-$$Lambda$FlexKnobPopupView$1$Hd-IPj-sFMdy-xBl9cItsn-TLpg
                @Override // com.rigol.scope.data.FlexKnobParam.OnRefreshListener
                public final void call(List list) {
                    FlexKnobPopupView.AnonymousClass1.this.lambda$onChanged$0$FlexKnobPopupView$1(list);
                }
            });
        }

        public /* synthetic */ void lambda$onChanged$0$FlexKnobPopupView$1(List list) {
            if (FlexKnobPopupView.this.flexKnobAdapter != null) {
                FlexKnobPopupView.this.flexKnobAdapter.setList(list);
            }
        }
    }

    private void initView() {
        this.binding.setCheckedChangeListener(this);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.knob.FlexKnobPopupView.2
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
                showKey(FlexKnobPopupView.this.context, ((AorBParam) FlexKnobPopupView.this.list_aorbParam.get(i)).getEditText(), true, ((AorBParam) FlexKnobPopupView.this.list_aorbParam.get(i)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
                showKey(FlexKnobPopupView.this.context, ((AorBParam) FlexKnobPopupView.this.list_aorbParam.get(i)).getEditText(), false, ((AorBParam) FlexKnobPopupView.this.list_aorbParam.get(i)).getAorb());
            }
        };
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.knob.-$$Lambda$FlexKnobPopupView$stF7diJP4cEvemfdlfjokKX50Bw
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        FlexKnobPopupView.this.lambda$initView$0$FlexKnobPopupView((KeyEvent) obj);
                    }
                });
            }
        }
        if (this.syncDataViewModel == null) {
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            this.syncDataViewModel = syncDataViewModel;
            if (syncDataViewModel != null) {
                syncDataViewModel.get(57, MessageID.MSG_FLEX_KNOB_REFRESH_REF_CHAN_BY_TOUCH).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.knob.-$$Lambda$FlexKnobPopupView$iXqFgSa60jebnz3iQX0fvOA046s
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        FlexKnobPopupView.this.lambda$initView$1$FlexKnobPopupView(obj);
                    }
                });
            }
        }
        if (this.flexKnobAdapter == null) {
            this.flexKnobAdapter = new ListAdapter(this.context, R.layout.adapter_item_flex_knob);
        }
        this.flexKnobAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.knob.-$$Lambda$FlexKnobPopupView$eTPmPti8XvMjEBZP5__u0xzib6M
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                FlexKnobPopupView.this.lambda$initView$2$FlexKnobPopupView(view, viewHolder, i);
            }
        });
        this.binding.recyclerView.setAdapter(this.flexKnobAdapter);
    }

    public /* synthetic */ void lambda$initView$0$FlexKnobPopupView(KeyEvent keyEvent) {
        PopupSpinner popupSpinner;
        List<MappingObject> list;
        if (!PopupViewManager.getInstance().isShowing(MathPopupView.class) || (popupSpinner = this.popupSpinner) == null || (list = this.mappingObjects) == null) {
            return;
        }
        this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, popupSpinner, list, this.spinnerAdapter, this.aorBManager, null, null);
    }

    public /* synthetic */ void lambda$initView$1$FlexKnobPopupView(Object obj) {
        if (obj instanceof Integer) {
            int intValue = ((Integer) obj).intValue();
            for (int i = 0; i < this.flexKnobAdapter.getList().size(); i++) {
                MappingObject mappingObject = this.flexKnobAdapter.getList().get(i);
                if (intValue == this.param.getRefChanByMappingObject(mappingObject.getValue())) {
                    refreshItemAdapter(i, mappingObject);
                    return;
                }
            }
        }
    }

    public /* synthetic */ void lambda$initView$2$FlexKnobPopupView(View view, RecyclerView.ViewHolder viewHolder, int i) {
        refreshItemAdapter(i, this.flexKnobAdapter.getMappingObject(i));
    }

    private void refreshItemAdapter(int i, MappingObject mappingObject) {
        if (mappingObject != null) {
            this.param.changeIcon(mappingObject.getValue());
            this.flexKnobAdapter.setCurrentItem(i);
            this.flexKnobAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            int id = compoundButton.getId();
            if (id == R.id.auto_radio_button) {
                this.param.setCheckDirection(true);
            } else if (id == R.id.off_radio_button) {
                this.param.setCheckDirection(false);
            }
            this.param.readCHList();
            this.flexKnobAdapter.notifyDataSetChanged();
        }
    }

    /* loaded from: classes2.dex */
    public class ListAdapter extends BaseAdapter<List<MappingObject>> {
        private FlexKnobParam flexKnobParam;
        private List<MappingObject> list;

        public void setFlexKnobParam(FlexKnobParam flexKnobParam) {
            this.flexKnobParam = flexKnobParam;
            notifyDataSetChanged();
        }

        public void setList(List<MappingObject> list) {
            boolean z;
            this.list = list;
            setItems(list);
            int readFlexLatest = FlexKnobPopupView.this.param.readFlexLatest();
            if (list == null || list.size() <= 0) {
                return;
            }
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    z = false;
                    break;
                }
                MappingObject mappingObject = list.get(i);
                if (mappingObject.getValue() == readFlexLatest) {
                    refresh(mappingObject, i);
                    z = true;
                    break;
                }
                i++;
            }
            if (z) {
                return;
            }
            refresh(list.get(0), 0);
        }

        public void refresh(MappingObject mappingObject, int i) {
            FlexKnobPopupView.this.param.changeIcon(mappingObject.getValue());
            setCurrentItem(i);
            notifyDataSetChanged();
        }

        public List<MappingObject> getList() {
            List<MappingObject> list = this.list;
            return list == null ? new ArrayList() : list;
        }

        public MappingObject getMappingObject(int i) {
            List<MappingObject> list = this.list;
            if (list == null || list.size() < i) {
                return null;
            }
            return this.list.get(i);
        }

        public ListAdapter(Context context, int i) {
            super(context, i);
        }

        @Override // com.rigol.scope.adapters.BaseAdapter
        protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list, int i) {
            AdapterItemFlexKnobBinding adapterItemFlexKnobBinding = (AdapterItemFlexKnobBinding) baseViewHolder.getBinding();
            adapterItemFlexKnobBinding.text1.setText(list.get(i).getStr());
            ServiceEnum.FlexKnobEnum flexKnobEnumFromValue1 = ServiceEnum.getFlexKnobEnumFromValue1(list.get(i).getValue());
            if (flexKnobEnumFromValue1 != null && !TextUtils.isEmpty(flexKnobEnumFromValue1.pic1)) {
                adapterItemFlexKnobBinding.icon.setImageDrawable(ContextUtil.getDrawable(this.context, flexKnobEnumFromValue1.pic1));
            }
            adapterItemFlexKnobBinding.getRoot().setSelected(i == getCurrentItem());
            if (this.flexKnobParam != null) {
                adapterItemFlexKnobBinding.getRoot().setSelected(list.get(i).getValue() == FlexKnobPopupView.this.param.getCurrentMappingObject().getValue());
                adapterItemFlexKnobBinding.itemView.setEnabled(!this.flexKnobParam.isCheckDirection());
            }
        }
    }
}
