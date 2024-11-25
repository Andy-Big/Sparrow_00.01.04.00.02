package com.rigol.scope.viewmodels;

import com.rigol.scope.R;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.function.Consumer;
import kotlin.Metadata;
/* compiled from: DecodeViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00040\u0001B\u0005¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/viewmodels/DecodeViewModel;", "Lcom/rigol/scope/viewmodels/BaseViewModel;", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/DecodeParam;", "Lkotlin/collections/ArrayList;", "()V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DecodeViewModel extends BaseViewModel<ArrayList<DecodeParam>> {
    public DecodeViewModel() {
        super(new ArrayList());
        ViewUtil.getList((int) R.array.msg_decode_list).forEach(new Consumer<MappingObject>() { // from class: com.rigol.scope.viewmodels.DecodeViewModel.1
            @Override // java.util.function.Consumer
            public final void accept(MappingObject mappingObject) {
                if (mappingObject != null) {
                    DecodeViewModel.this.getValue().add(new DecodeParam(mappingObject.getStr(), mappingObject.getValue()));
                }
            }
        });
    }
}
