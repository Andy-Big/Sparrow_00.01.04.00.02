package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecode1553bBinding;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class Decode1553bAdapter extends RecyclerView.Adapter<Decode1553bHolder> implements View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecode1553bBinding binding;
    private View clickedView;
    private final Context context;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private final DecodeParam param;
    private PopupSpinner popupSpinner;
    private PopupviewDecodeBinding popupviewDecodeBinding;
    private SpinnerAdapter spinnerAdapter;
    private DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public Decode1553bAdapter(View view, DecodeParam decodeParam, Context context) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
    }

    public Decode1553bAdapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public Decode1553bHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecode1553bBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new Decode1553bHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(Decode1553bHolder decode1553bHolder, int i) {
        this.binding.decode1553bSrcValue.setOnClickListener(this);
        this.binding.decode1553bThresValue.setOnClickListener(this);
        this.param.read_1553b_source();
        this.param.read_1553b_polarity();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_1553B_THRE1) != this.param.get_1553b_thres1()) {
            this.param.read_1553b_thres1();
        }
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decode1553bThresValue, 0, true, ViewUtil.KEY_A, 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decode1553bSrcValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.Decode1553bAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(Decode1553bAdapter.this.context, ((AorBParam) Decode1553bAdapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) Decode1553bAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(Decode1553bAdapter.this.context, ((AorBParam) Decode1553bAdapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) Decode1553bAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decode1553bThresValue, true, ViewUtil.KEY_A);
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$Decode1553bAdapter$qy2K049-eSYBx8VYX9z3oIXofMk
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        Decode1553bAdapter.this.lambda$onBindViewHolder$2$Decode1553bAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        this.binding.setParam(this.param);
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$Decode1553bAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Decode1553bAdapter$ZvH4-99W-9Og52OeehaO-YsRPuU
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    Decode1553bAdapter.this.lambda$onBindViewHolder$0$Decode1553bAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Decode1553bAdapter$4xHE9vv90gsGwe6eDGje7uezNZQ
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    Decode1553bAdapter.this.lambda$onBindViewHolder$1$Decode1553bAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$Decode1553bAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$Decode1553bAdapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view != null && view.getId() == R.id.decode_1553b_src_value) {
            selectSrcValue(mappingObject);
        }
    }

    private void selectSrcValue(MappingObject mappingObject) {
        this.param.save_1553b_source(mappingObject.getValue());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_1553b_src_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_1553b_src)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Decode1553bAdapter$ztpn-ZaLhV61zQTsAtS2AiD1aJc
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    Decode1553bAdapter.this.lambda$onClick$3$Decode1553bAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$Decode1553bAdapter$eYbm7mrI7BfPedjUzCldpuqhR1M
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    Decode1553bAdapter.this.lambda$onClick$4$Decode1553bAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_1553b_thres_value && this.aorBManager.setClick_showab_textview(id)) {
            this.param.read_1553b_thres1();
            this.param.readMilstdThres1Attr();
            ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getMilstdThres1Attr().getMaxLongValue(), this.param.getMilstdThres1Attr().getMinLongValue(), this.param.getMilstdThres1Attr().getDefLongValue(), this.param.get_1553b_thres1(), new KeyboardListener() { // from class: com.rigol.scope.adapters.Decode1553bAdapter.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    Decode1553bAdapter.this.param.save_1553b_thres1(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    Decode1553bAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$Decode1553bAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$Decode1553bAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSrcValue(mappingObject);
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param != null && getIsMove() && i == R.id.decode_1553b_thres_value) {
            this.param.read_1553b_thres1();
            this.param.readMilstdThres1Attr();
            DecodeParam decodeParam = this.param;
            decodeParam.save_1553b_thres1(decodeParam.getLongStep(decodeParam.get_1553b_thres1(), this.param.getPalBusThresAttr(), z, keyEvent));
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param != null && getIsMove() && i == R.id.decode_1553b_thres_value) {
            this.param.read_1553b_thres1();
            this.param.readMilstdThres1Attr();
            DecodeParam decodeParam = this.param;
            decodeParam.save_1553b_thres1(decodeParam.getLongDef(decodeParam.getPalBusThresAttr()));
        }
    }

    /* loaded from: classes.dex */
    public static class Decode1553bHolder extends RecyclerView.ViewHolder {
        public Decode1553bHolder(AdapterDecode1553bBinding adapterDecode1553bBinding) {
            super(adapterDecode1553bBinding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
