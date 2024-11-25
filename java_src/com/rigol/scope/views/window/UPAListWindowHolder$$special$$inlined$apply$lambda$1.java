package com.rigol.scope.views.window;

import android.util.Log;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "it", "", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Boolean;)V", "com/rigol/scope/views/window/UPAListWindowHolder$updateUIViewModel$1$1"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes2.dex */
final class UPAListWindowHolder$$special$$inlined$apply$lambda$1<T> implements Observer<Boolean> {
    final /* synthetic */ UPAListWindowHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public UPAListWindowHolder$$special$$inlined$apply$lambda$1(UPAListWindowHolder uPAListWindowHolder) {
        this.this$0 = uPAListWindowHolder;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Boolean bool) {
        new Thread(new Runnable() { // from class: com.rigol.scope.views.window.UPAListWindowHolder$$special$$inlined$apply$lambda$1.1
            @Override // java.lang.Runnable
            public final void run() {
                String source;
                UPAListWindowHolder$$special$$inlined$apply$lambda$1.this.this$0.setJson(API.getInstance().UI_QueryStr(31, MessageID.MSG_APP_UPA_QUERY_POWER_DATA));
                try {
                    String[][] strArr = (String[][]) GsonUtils.fromJson(UPAListWindowHolder$$special$$inlined$apply$lambda$1.this.this$0.getJson(), (Class<Object>) String[][].class);
                    if (strArr != null) {
                        if (strArr.length == 0) {
                            return;
                        }
                        UPAListWindowHolder$$special$$inlined$apply$lambda$1.this.this$0.getBinding().windowLayout.showContentView();
                        final ArrayList arrayList = new ArrayList();
                        arrayList.add(CollectionsKt.arrayListOf("Index", "Name", "Source", "Current", "Average", "Maximum", "Minimum", "Deviation", "Count"));
                        int length = strArr.length;
                        for (int i = 0; i < length; i++) {
                            String[] strArr2 = strArr[i];
                            if (strArr2.length < 9) {
                                arrayList.add(CollectionsKt.arrayListOf("", "", "", "", "", "", "", "", "", ""));
                            } else {
                                int parseInt = Integer.parseInt(strArr2[0]);
                                MappingObject mappingObject = UPAListWindowHolder$$special$$inlined$apply$lambda$1.this.this$0.getTitlesArray().get(parseInt);
                                if (parseInt >= ServiceEnum.MeasType.Meas_DelayRR.value1 && parseInt <= ServiceEnum.MeasType.Meas_PhaseFF.value1) {
                                    source = ViewUtil.getFullChanStr(ServiceEnum.getChanFromValue1(Integer.parseInt(strArr2[1])), ServiceEnum.getChanFromValue1(Integer.parseInt(strArr2[2])));
                                } else {
                                    source = ViewUtil.getFullChanStr(ServiceEnum.getChanFromValue1(Integer.parseInt(strArr2[1])));
                                }
                                Intrinsics.checkNotNullExpressionValue(mappingObject, "mappingObject");
                                String str = mappingObject.getStr();
                                Intrinsics.checkNotNullExpressionValue(str, "mappingObject.str");
                                Intrinsics.checkNotNullExpressionValue(source, "source");
                                arrayList.add(CollectionsKt.arrayListOf(String.valueOf(i + 1), str, source, strArr2[3], strArr2[4], strArr2[5], strArr2[6], strArr2[7], strArr2[8]));
                            }
                        }
                        UPAListWindowHolder$$special$$inlined$apply$lambda$1.this.this$0.getHandler().post(new Runnable() { // from class: com.rigol.scope.views.window.UPAListWindowHolder$$special$.inlined.apply.lambda.1.1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                UPAListWindowHolder$$special$$inlined$apply$lambda$1.this.this$0.getTableAdapter().setData(arrayList);
                                UPAListWindowHolder$$special$$inlined$apply$lambda$1.this.this$0.getTableAdapter().notifyItemRangeChanged(1, arrayList.size());
                            }
                        });
                    }
                } catch (Exception e) {
                    Log.e("tableAdapter", String.valueOf(e.getMessage()));
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
