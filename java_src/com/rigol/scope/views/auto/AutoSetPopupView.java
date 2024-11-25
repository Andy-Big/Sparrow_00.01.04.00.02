package com.rigol.scope.views.auto;

import android.view.LayoutInflater;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.OnItemClickListener;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterItemAutosetBinding;
import com.rigol.scope.databinding.PopupviewAutosetBinding;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.horizontal.HorizontalSpaceItemDecoration;
import java.util.List;
/* loaded from: classes2.dex */
public class AutoSetPopupView extends BasePopupView {
    public AutoSetPopupView() {
        super((int) R.style.App_PopupWindow_AutoSet);
        PopupviewAutosetBinding inflate = PopupviewAutosetBinding.inflate(LayoutInflater.from(this.context));
        setContentView(inflate.getRoot());
        final List<MappingObject> list = ViewUtil.getList((int) R.array.msg_auto_list);
        BaseAdapter<List<MappingObject>> baseAdapter = new BaseAdapter<List<MappingObject>>(this.context, list, R.layout.adapter_item_autoset) { // from class: com.rigol.scope.views.auto.AutoSetPopupView.1
            @Override // com.rigol.scope.adapters.BaseAdapter
            protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<MappingObject> list2, int i) {
                ((AdapterItemAutosetBinding) baseViewHolder.getBinding()).setObj(list2.get(i));
            }
        };
        ViewUtil.setSupportsChangeAnimations(inflate.list, false);
        inflate.list.addItemDecoration(new HorizontalSpaceItemDecoration(5));
        inflate.list.setAdapter(baseAdapter);
        baseAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.auto.-$$Lambda$AutoSetPopupView$yF-c8ycMI5PtQJjzhk3DQX6_IA0
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                AutoSetPopupView.this.lambda$new$0$AutoSetPopupView(list, view, viewHolder, i);
            }
        });
        if (list != null || list.size() > 0) {
            setWidth((list.size() * 91) + ((list.size() - 1) * 5));
        }
    }

    public /* synthetic */ void lambda$new$0$AutoSetPopupView(List list, View view, RecyclerView.ViewHolder viewHolder, int i) {
        ServiceEnum.AutoSetItemType autoSetItemTypeFromValue1 = ServiceEnum.getAutoSetItemTypeFromValue1(((MappingObject) list.get(i)).getValue());
        if (autoSetItemTypeFromValue1 == null) {
            return;
        }
        switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType[autoSetItemTypeFromValue1.ordinal()]) {
            case 1:
                API.getInstance().UI_PostInt32(35, 769, 0);
                break;
            case 2:
                API.getInstance().UI_PostInt32(35, 770, 0);
                break;
            case 3:
                API.getInstance().UI_PostInt32(35, 771, 0);
                break;
            case 4:
                API.getInstance().UI_PostInt32(35, 772, 0);
                break;
            case 5:
                API.getInstance().UI_PostInt32(35, 779, 0);
                break;
            case 6:
                BasePopupView basePopupView = PopupViewManager.getInstance().get(UtilityPopupView.class);
                if (basePopupView instanceof UtilityPopupView) {
                    ((UtilityPopupView) basePopupView).setAutoSetAdapter();
                    basePopupView.show();
                    break;
                }
                break;
            case 7:
                API.getInstance().UI_PostInt32(35, 773, 0);
                break;
        }
        dismiss();
    }

    /* renamed from: com.rigol.scope.views.auto.AutoSetPopupView$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType;

        static {
            int[] iArr = new int[ServiceEnum.AutoSetItemType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType = iArr;
            try {
                iArr[ServiceEnum.AutoSetItemType.AUTO_CYCLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType[ServiceEnum.AutoSetItemType.AUTO_NCYCLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType[ServiceEnum.AutoSetItemType.AUTO_RISE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType[ServiceEnum.AutoSetItemType.AUTO_FALL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType[ServiceEnum.AutoSetItemType.AUTO_BACK.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType[ServiceEnum.AutoSetItemType.AUTO_MENU.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$AutoSetItemType[ServiceEnum.AutoSetItemType.AUTO_UNDO.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }
}
