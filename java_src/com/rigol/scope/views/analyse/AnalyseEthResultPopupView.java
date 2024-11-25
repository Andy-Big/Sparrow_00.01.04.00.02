package com.rigol.scope.views.analyse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.AdapterItemResultTableContentBinding;
import com.rigol.scope.databinding.AdapterItemResultTableHeaderBinding;
import com.rigol.scope.databinding.PopupviewAnalyseEthResultBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.BusAnalyseViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.busAnalyse.BusAnalyseParam;
import com.rigol.scope.views.decoration.BackgroundItemDecoration;
import com.rigol.scope.views.save.SavePopupView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class AnalyseEthResultPopupView extends BasePopupView implements View.OnClickListener {
    private final PopupviewAnalyseEthResultBinding binding;
    private BusAnalyseParam param;

    public AnalyseEthResultPopupView() {
        super((int) R.style.App_PopupWindow_Analyse_eth_result);
        PopupviewAnalyseEthResultBinding inflate = PopupviewAnalyseEthResultBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        BusAnalyseViewModel busAnalyseViewModel = (BusAnalyseViewModel) ContextUtil.getAppViewModel(BusAnalyseViewModel.class);
        if (busAnalyseViewModel != null) {
            busAnalyseViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.analyse.-$$Lambda$AnalyseEthResultPopupView$qWBnf_V328afb6ha4qNbWwXWxzI
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AnalyseEthResultPopupView.this.lambda$new$0$AnalyseEthResultPopupView((BusAnalyseParam) obj);
                }
            });
        }
        this.binding.eye.setImageBitmap(getDiskBitmap("/mnt/tmp/AnalyseImage/eth100Eye.bmp"));
        this.binding.jitter.setImageBitmap(getDiskBitmap("/mnt/tmp/AnalyseImage/eth100Jitter.bmp"));
        this.binding.busAnalyseEthResultSave.setOnClickListener(this);
    }

    public /* synthetic */ void lambda$new$0$AnalyseEthResultPopupView(BusAnalyseParam busAnalyseParam) {
        this.param = busAnalyseParam;
        this.binding.setParam(busAnalyseParam);
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        PopupviewAnalyseEthResultBinding popupviewAnalyseEthResultBinding = this.binding;
        if (popupviewAnalyseEthResultBinding != null) {
            popupviewAnalyseEthResultBinding.getRoot().post(new Runnable() { // from class: com.rigol.scope.views.analyse.-$$Lambda$AnalyseEthResultPopupView$vgYWc4CtiDqs6W752UkvVlb9Q2I
                @Override // java.lang.Runnable
                public final void run() {
                    AnalyseEthResultPopupView.this.updateContent();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContent() {
        if (this.titleView != null) {
            this.titleView.setText(getTitle());
        }
        this.binding.eye.setImageBitmap(getDiskBitmap("/mnt/tmp/AnalyseImage/eth100Eye.bmp"));
        this.binding.jitter.setImageBitmap(getDiskBitmap("/mnt/tmp/AnalyseImage/eth100Jitter.bmp"));
        showTable();
    }

    private Bitmap getDiskBitmap(String str) {
        try {
            if (new File(str).exists()) {
                return BitmapFactory.decodeFile(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    private void showTable() {
        BaseAdapter<List<String>> baseAdapter = new BaseAdapter<List<String>>(this.context, R.layout.adapter_item_result_table_header) { // from class: com.rigol.scope.views.analyse.AnalyseEthResultPopupView.1
            @Override // com.rigol.scope.adapters.BaseAdapter
            protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<String> list, int i) {
                AdapterItemResultTableHeaderBinding adapterItemResultTableHeaderBinding = (AdapterItemResultTableHeaderBinding) baseViewHolder.getBinding();
                adapterItemResultTableHeaderBinding.text.setText(list.get(i));
                ViewGroup.LayoutParams layoutParams = adapterItemResultTableHeaderBinding.text.getLayoutParams();
                layoutParams.width = AnalyseEthResultPopupView.this.binding.header.getWidth() / list.size();
                adapterItemResultTableHeaderBinding.text.setLayoutParams(layoutParams);
            }
        };
        this.binding.header.setAdapter(baseAdapter);
        BaseAdapter<List<String>> baseAdapter2 = new BaseAdapter<List<String>>(this.context, R.layout.adapter_item_result_table_content) { // from class: com.rigol.scope.views.analyse.AnalyseEthResultPopupView.2
            @Override // com.rigol.scope.adapters.BaseAdapter
            protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<String> list, int i) {
                ((AdapterItemResultTableContentBinding) baseViewHolder.getBinding()).content.setText(list.get(i));
            }

            @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
            public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i) {
                BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i);
                ViewDataBinding binding = onCreateViewHolder.getBinding();
                if (binding instanceof AdapterItemResultTableContentBinding) {
                    RecyclerView.LayoutManager layoutManager = AnalyseEthResultPopupView.this.binding.result.getLayoutManager();
                    if (layoutManager instanceof GridLayoutManager) {
                        AdapterItemResultTableContentBinding adapterItemResultTableContentBinding = (AdapterItemResultTableContentBinding) binding;
                        ViewGroup.LayoutParams layoutParams = adapterItemResultTableContentBinding.content.getLayoutParams();
                        layoutParams.width = AnalyseEthResultPopupView.this.binding.header.getWidth() / ((GridLayoutManager) layoutManager).getSpanCount();
                        adapterItemResultTableContentBinding.content.setLayoutParams(layoutParams);
                    }
                }
                return onCreateViewHolder;
            }
        };
        final BackgroundItemDecoration backgroundItemDecoration = new BackgroundItemDecoration();
        this.binding.result.addItemDecoration(backgroundItemDecoration);
        this.binding.result.setAdapter(baseAdapter2);
        this.binding.result.post(new Runnable() { // from class: com.rigol.scope.views.analyse.-$$Lambda$AnalyseEthResultPopupView$Sao_44irn9aN05MoZtALLZ9HiJ0
            @Override // java.lang.Runnable
            public final void run() {
                BackgroundItemDecoration.this.setItemHeight(30);
            }
        });
        ArrayList arrayList = new ArrayList();
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_eth_analyse_100baset_result_table_row);
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(list.get(i).getStr());
        }
        baseAdapter.setItems(arrayList);
        baseAdapter.notifyDataSetChanged();
        RecyclerView.LayoutManager layoutManager = this.binding.result.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            ((GridLayoutManager) layoutManager).setSpanCount(arrayList.size());
        }
        String UI_QueryStr = API.getInstance().UI_QueryStr(49, MessageID.MSG_APP_ANALYSE_ETH100_QUERY_EVT_CONTENT);
        if (UI_QueryStr.equals("[ ]")) {
            UI_QueryStr = API.getInstance().UI_QueryStr(49, MessageID.MSG_APP_ANALYSE_ETH100_QUERY_EVT_CONTENT);
        }
        Timber.d(UI_QueryStr, new Object[0]);
        try {
            List<MappingObject> list2 = ViewUtil.getList((int) R.array.msg_eth_analyse_100baset_result_table_col);
            String[][] strArr = (String[][]) GsonUtils.fromJson(UI_QueryStr, (Class<Object>) String[][].class);
            ArrayList arrayList2 = new ArrayList();
            RecyclerView.LayoutManager layoutManager2 = this.binding.header.getLayoutManager();
            if (layoutManager2 == null) {
                return;
            }
            int itemCount = layoutManager2.getItemCount();
            int i2 = 0;
            for (String[] strArr2 : strArr) {
                if (strArr2 != null && strArr2.length != 0) {
                    arrayList2.add(list2.get(i2).getStr());
                    for (String str : strArr2) {
                        if (str == null) {
                            arrayList2.add(null);
                        } else {
                            arrayList2.add(str);
                        }
                    }
                    i2++;
                }
                arrayList2.add(null);
                for (int i3 = 0; i3 < itemCount - 1; i3++) {
                    arrayList2.add(null);
                }
                i2++;
            }
            baseAdapter2.setItems(arrayList2);
            baseAdapter2.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public int getTitle() {
        BusAnalyseParam busAnalyseParam = this.param;
        if (busAnalyseParam != null) {
            int eth_type = busAnalyseParam.getEth().getEth_type();
            return eth_type != 0 ? (eth_type == 1 || eth_type != 2) ? R.string.msg_eth_analyse_result_100baset : R.string.msg_eth_analyse_result_1000baset : R.string.msg_eth_analyse_result_10baset;
        }
        return R.string.msg_eth_analyse_result_100baset;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StorageSaveParam value;
        if (view.getId() != R.id.bus_analyse_eth_result_save) {
            return;
        }
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel != null && (value = storageViewModel.getSaveLiveData().getValue()) != null) {
            value.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_HTML);
            value.saveFileType(ServiceEnum.enFileType.FILETYPE_HTML.value1);
        }
        PopupViewManager.getInstance().toggle(SavePopupView.class);
    }
}
