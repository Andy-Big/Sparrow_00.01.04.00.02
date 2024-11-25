package com.rigol.scope.viewmodels;

import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.function.Consumer;
import kotlin.Metadata;
/* compiled from: VerticalViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/viewmodels/VerticalViewModel;", "Lcom/rigol/scope/viewmodels/BaseViewModel;", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/VerticalParam;", "Lkotlin/collections/ArrayList;", "()V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class VerticalViewModel extends BaseViewModel<ArrayList<VerticalParam>> {
    public VerticalViewModel() {
        super(new ArrayList());
        ViewUtil.getList((int) R.array.msg_chan_sparrow_list).forEach(new Consumer<MappingObject>() { // from class: com.rigol.scope.viewmodels.VerticalViewModel.1
            @Override // java.util.function.Consumer
            public final void accept(MappingObject mappingObject) {
                if (mappingObject != null) {
                    String str = mappingObject.getStr();
                    int value = mappingObject.getValue();
                    if (API.getInstance().UI_QueryInt32(value, MessageID.MSG_CHAN_ACTIVE) != ServiceEnum.enChanStatus.CHAN_HIDE.value1) {
                        VerticalViewModel.this.getValue().add(new VerticalParam(str, value));
                    }
                }
            }
        });
    }
}
