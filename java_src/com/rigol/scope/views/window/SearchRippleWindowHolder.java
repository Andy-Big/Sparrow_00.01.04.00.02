package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.adapters.TableAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.TableSimpleBinding;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.decoration.BackgroundItemDecoration;
import com.rigol.scope.views.search.SearchPopupView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010 \u001a\u00020!H\u0016J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000eJ\b\u0010%\u001a\u00020#H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006&"}, d2 = {"Lcom/rigol/scope/views/window/SearchRippleWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "MAX_CSV_LENGTH", "", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "decodeTypeStr", "", "tableAdapter", "Lcom/rigol/scope/adapters/TableAdapter;", "getTableAdapter", "()Lcom/rigol/scope/adapters/TableAdapter;", "tableBinding", "Lcom/rigol/scope/databinding/TableSimpleBinding;", "titlesArray", "Landroid/util/SparseArray;", "Lcom/rigol/scope/data/MappingObject;", "getTitlesArray", "()Landroid/util/SparseArray;", "setTitlesArray", "(Landroid/util/SparseArray;)V", "updateUIViewModel", "Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "getUpdateUIViewModel", "()Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateContent", "", "csvFilePath", "updateTitle", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class SearchRippleWindowHolder extends WindowHolder {
    private final int MAX_CSV_LENGTH;
    private final WindowSimpleBinding binding;
    private String decodeTypeStr;
    private final TableAdapter tableAdapter;
    private final TableSimpleBinding tableBinding;
    private SparseArray<MappingObject> titlesArray;
    private final UpdateUIViewModel updateUIViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchRippleWindowHolder(Context context, WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Boolean> mutableLiveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.MAX_CSV_LENGTH = 1003;
        LiveData<SharedParam> liveData = ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData();
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        liveData.observe((LifecycleOwner) topActivity, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.SearchRippleWindowHolder.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(final SharedParam sharedParam) {
                sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.SearchRippleWindowHolder.1.1
                    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                    public void onPropertyChanged(Observable observable, int i) {
                        if (sharedParam.getShowResultBar()) {
                            SearchRippleWindowHolder.this.getBinding().getRoot().getLocationInWindow(new int[2]);
                        }
                    }
                });
            }
        });
        SparseArray<MappingObject> createMappingByValue = MappingObject.createMappingByValue(context, R.array.msg_upa_power_volt, R.array.msg_upa_power_curr, R.array.msg_app_meas_other_type);
        Intrinsics.checkNotNullExpressionValue(createMappingByValue, "MappingObject.createMapp…app_meas_other_type\n    )");
        this.titlesArray = createMappingByValue;
        this.tableAdapter = new TableAdapter(40, null, ContextCompat.getDrawable(context, R.drawable.divider));
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel != null && (mutableLiveData = updateUIViewModel.get(ResultListAdapter.ON_ITEM_DATA_SEACH_KEY)) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity2, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.SearchRippleWindowHolder$$special$$inlined$apply$lambda$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Boolean bool) {
                    String json = API.getInstance().UI_QueryStr(25, MessageID.MSG_APP_SEARCH_QUERY_DATA_EVT);
                    SearchRippleWindowHolder searchRippleWindowHolder = SearchRippleWindowHolder.this;
                    Intrinsics.checkNotNullExpressionValue(json, "json");
                    searchRippleWindowHolder.updateContent(json);
                }
            });
        }
        Unit unit = Unit.INSTANCE;
        this.updateUIViewModel = updateUIViewModel;
        TableSimpleBinding inflate = TableSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "TableSimpleBinding.infla…utInflater.from(context))");
        BackgroundItemDecoration backgroundItemDecoration = new BackgroundItemDecoration();
        backgroundItemDecoration.setItemHeight(40);
        inflate.list.addItemDecoration(backgroundItemDecoration);
        RecyclerView list = inflate.list;
        Intrinsics.checkNotNullExpressionValue(list, "list");
        list.setAdapter(this.tableAdapter);
        TableAdapter tableAdapter = this.tableAdapter;
        RecyclerView list2 = inflate.list;
        Intrinsics.checkNotNullExpressionValue(list2, "list");
        tableAdapter.setRecyclerView(list2);
        Unit unit2 = Unit.INSTANCE;
        this.tableBinding = inflate;
        WindowSimpleBinding inflate2 = WindowSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate2, "WindowSimpleBinding.infl…utInflater.from(context))");
        inflate2.title.setText(R.string.msg_search_app);
        inflate2.contentLayout.addView(this.tableBinding.getRoot(), -1, -1);
        inflate2.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.SearchRippleWindowHolder$$special$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(SearchRippleWindowHolder.this);
                API.getInstance().UI_PostBool(25, MessageID.MSG_SEARCH_MARK_TABEL_EN, false);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_MARK_TABEL_EN), false);
            }
        });
        inflate2.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.SearchRippleWindowHolder$binding$1$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(SearchPopupView.class);
            }
        });
        Unit unit3 = Unit.INSTANCE;
        this.binding = inflate2;
    }

    public final SparseArray<MappingObject> getTitlesArray() {
        return this.titlesArray;
    }

    public final void setTitlesArray(SparseArray<MappingObject> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<set-?>");
        this.titlesArray = sparseArray;
    }

    public final TableAdapter getTableAdapter() {
        return this.tableAdapter;
    }

    public final UpdateUIViewModel getUpdateUIViewModel() {
        return this.updateUIViewModel;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_SEARCH.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…N_SEARCH.value1\n        )");
        textView.setText(mappingObject.getStr());
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }

    public final void updateContent(String csvFilePath) {
        Intrinsics.checkNotNullParameter(csvFilePath, "csvFilePath");
        final Handler handler = new Handler(Looper.getMainLooper());
        final ArrayList<String[]> csvInfo = ViewUtil.getCsvInfo(csvFilePath, Integer.valueOf(this.MAX_CSV_LENGTH), true);
        if (csvInfo != null) {
            new Thread(new Runnable() { // from class: com.rigol.scope.views.window.SearchRippleWindowHolder$updateContent$$inlined$let$lambda$1
                @Override // java.lang.Runnable
                public final void run() {
                    int i;
                    List subList;
                    if (csvInfo.size() >= 2) {
                        String[] strArr = (String[]) csvInfo.get(0);
                        if (strArr.length >= 2) {
                            SearchRippleWindowHolder.this.decodeTypeStr = strArr[1];
                        }
                        String[] headInfo = (String[]) csvInfo.get(1);
                        Intrinsics.checkNotNullExpressionValue(headInfo, "headInfo");
                        if (headInfo.length == 0) {
                            return;
                        }
                        final ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add("Index");
                        for (String str : headInfo) {
                            if (!TextUtils.isEmpty(str)) {
                                arrayList2.add(str);
                            }
                        }
                        arrayList.add(arrayList2);
                        int size = csvInfo.size();
                        i = SearchRippleWindowHolder.this.MAX_CSV_LENGTH;
                        if (size == i) {
                            ArrayList arrayList3 = csvInfo;
                            subList = arrayList3.subList(2, arrayList3.size() - 1);
                        } else {
                            ArrayList arrayList4 = csvInfo;
                            subList = arrayList4.subList(2, arrayList4.size());
                        }
                        Intrinsics.checkNotNullExpressionValue(subList, "if (csvInfo.size == MAX_…ze)\n                    }");
                        if (subList.isEmpty()) {
                            return;
                        }
                        int i2 = 0;
                        for (Object obj : subList) {
                            int i3 = i2 + 1;
                            if (i2 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            String[] strArr2 = (String[]) obj;
                            if (strArr2 != null) {
                                if (!(strArr2.length == 0)) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.add(String.valueOf(i3));
                                    int length = headInfo.length;
                                    for (int i4 = 1; i4 < length; i4++) {
                                        int i5 = i4 - 1;
                                        if (i5 >= strArr2.length) {
                                            arrayList5.add("null");
                                        } else {
                                            arrayList5.add(strArr2[i5]);
                                        }
                                    }
                                    arrayList.add(arrayList5);
                                }
                            }
                            i2 = i3;
                        }
                        handler.post(new Runnable() { // from class: com.rigol.scope.views.window.SearchRippleWindowHolder$updateContent$$inlined$let$lambda$1.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                if (SearchRippleWindowHolder.this.getTableAdapter().isTouch()) {
                                    SearchRippleWindowHolder.this.getTableAdapter().setData(arrayList);
                                    SearchRippleWindowHolder.this.getTableAdapter().notifyDataSetChanged();
                                }
                            }
                        });
                    }
                }
            }).start();
        }
        if (csvInfo == null) {
            this.tableAdapter.setData(new ArrayList<>());
            this.tableAdapter.notifyDataSetChanged();
        }
    }
}
