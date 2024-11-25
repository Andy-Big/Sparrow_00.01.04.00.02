package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
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
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.TableSimpleBinding;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.bode.BodePopupWin;
import com.rigol.scope.views.decoration.BackgroundItemDecoration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Regex;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001f\u001a\u00020 H\u0016J\u0006\u0010!\u001a\u00020\"J\b\u0010#\u001a\u00020\"H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR=\u0010\u000b\u001a.\u0012\f\u0012\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f0\fj\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\r\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\r\u0018\u0001`\u000e`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\r0\fj\b\u0012\u0004\u0012\u00020\r`\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0010\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006$"}, d2 = {"Lcom/rigol/scope/views/window/BodeWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "datas", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getDatas", "()Ljava/util/ArrayList;", "listStringData", "getListStringData", "setListStringData", "(Ljava/util/ArrayList;)V", "tableAdapter", "Lcom/rigol/scope/adapters/TableAdapter;", "getTableAdapter", "()Lcom/rigol/scope/adapters/TableAdapter;", "tableBinding", "Lcom/rigol/scope/databinding/TableSimpleBinding;", "updateUIViewModel", "Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "getUpdateUIViewModel", "()Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "initlist", "", "updateTitle", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class BodeWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final ArrayList<ArrayList<String>> datas;
    private ArrayList<String> listStringData;
    private final TableAdapter tableAdapter;
    private final TableSimpleBinding tableBinding;
    private final UpdateUIViewModel updateUIViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BodeWindowHolder(Context context, WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Object> mutableLiveData;
        List emptyList;
        String convert;
        boolean z;
        MutableLiveData<Boolean> mutableLiveData2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.datas = new ArrayList<>();
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel != null && (mutableLiveData2 = updateUIViewModel.get(ResultListAdapter.ON_ITEM_DATA_BODE_KEY)) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) topActivity, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.BodeWindowHolder$$special$$inlined$apply$lambda$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Boolean bool) {
                    List emptyList2;
                    String convert2;
                    boolean z2;
                    String json = API.getInstance().UI_QueryStr(61, MessageID.MSG_BODE_PLOTDATA);
                    Intrinsics.checkNotNullExpressionValue(json, "json");
                    List<String> split = new Regex(",").split(json, 0);
                    if (!split.isEmpty()) {
                        ListIterator<String> listIterator = split.listIterator(split.size());
                        while (listIterator.hasPrevious()) {
                            if (listIterator.previous().length() == 0) {
                                z2 = true;
                                continue;
                            } else {
                                z2 = false;
                                continue;
                            }
                            if (!z2) {
                                emptyList2 = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                                break;
                            }
                        }
                    }
                    emptyList2 = CollectionsKt.emptyList();
                    Object[] array = emptyList2.toArray(new String[0]);
                    if (array != null) {
                        String[] strArr = (String[]) array;
                        try {
                            BodeWindowHolder.this.getBinding().windowLayout.showContentView();
                            Intrinsics.checkNotNullExpressionValue(UnitFormat.newBuilder("0.######", UnitFormat.SI.MICRO).convert(Double.parseDouble(strArr[0])), "UnitFormat.newBuilder(\"0…trings.get(0).toDouble())");
                            String str = ViewUtil.subNumber(convert2, 6) + ServiceEnum.Unit.Unit_hz.value2;
                            for (int i = 0; i < 1; i++) {
                                ArrayList<ArrayList<String>> datas = BodeWindowHolder.this.getDatas();
                                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                                String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(Float.parseFloat(strArr[1]))}, 1));
                                Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                                String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(Float.parseFloat(strArr[2]))}, 1));
                                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                                datas.add(CollectionsKt.arrayListOf(String.valueOf(BodeWindowHolder.this.getDatas().size()), str, format, format2));
                            }
                            BodeWindowHolder.this.getTableAdapter().setData(BodeWindowHolder.this.getDatas());
                            BodeWindowHolder.this.getTableAdapter().notifyItemRangeChanged(0, BodeWindowHolder.this.getDatas().size());
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
            });
        }
        Unit unit = Unit.INSTANCE;
        this.updateUIViewModel = updateUIViewModel;
        this.tableAdapter = new TableAdapter(30, null, ContextCompat.getDrawable(context, R.drawable.divider));
        this.listStringData = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBodeDataString();
        TableSimpleBinding inflate = TableSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "TableSimpleBinding.infla…utInflater.from(context))");
        BackgroundItemDecoration backgroundItemDecoration = new BackgroundItemDecoration();
        backgroundItemDecoration.setItemHeight(30);
        inflate.list.addItemDecoration(backgroundItemDecoration);
        RecyclerView list = inflate.list;
        Intrinsics.checkNotNullExpressionValue(list, "list");
        list.setAdapter(this.tableAdapter);
        Unit unit2 = Unit.INSTANCE;
        this.tableBinding = inflate;
        WindowSimpleBinding inflate2 = WindowSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate2, "WindowSimpleBinding.infl…utInflater.from(context))");
        TextView title = inflate2.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_BODE.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…BODE.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate2.contentLayout.addView(this.tableBinding.getRoot(), -1, -1);
        inflate2.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.BodeWindowHolder$binding$1$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_BODE);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(61, MessageID.MSG_BODE_DISP_TYPE), false);
            }
        });
        inflate2.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.BodeWindowHolder$binding$1$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(BodePopupWin.class);
            }
        });
        int size = this.listStringData.size();
        for (int i = 0; i < size; i++) {
            String str = this.listStringData.get(i);
            Intrinsics.checkNotNullExpressionValue(str, "listStringData.get(i)");
            List<String> split = new Regex(",").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (listIterator.hasPrevious()) {
                    if (listIterator.previous().length() == 0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        emptyList = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                        break;
                    }
                }
            }
            emptyList = CollectionsKt.emptyList();
            Object[] array = emptyList.toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                try {
                    this.tableAdapter.setData(new ArrayList<>());
                    this.tableAdapter.notifyDataSetChanged();
                    inflate2.windowLayout.showContentView();
                    Intrinsics.checkNotNullExpressionValue(UnitFormat.newBuilder("0.######", UnitFormat.SI.MICRO).convert(Double.parseDouble(strArr[0])), "UnitFormat.newBuilder(\"0…trings.get(0).toDouble())");
                    String str2 = ViewUtil.subNumber(convert, 6) + ServiceEnum.Unit.Unit_hz.value2;
                    if (this.datas.size() == 0) {
                        initlist();
                    }
                    for (int i2 = 0; i2 < 1; i2++) {
                        ArrayList<ArrayList<String>> arrayList = this.datas;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(Float.parseFloat(strArr[1]))}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                        String format2 = String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(Float.parseFloat(strArr[2]))}, 1));
                        Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                        arrayList.add(CollectionsKt.arrayListOf(String.valueOf(this.datas.size()), str2, format, format2));
                    }
                    this.tableAdapter.setData(this.datas);
                    this.tableAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(61, MessageID.MSG_BODE_RUNSTOP)) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity2, new Observer<Object>() { // from class: com.rigol.scope.views.window.BodeWindowHolder$$special$$inlined$apply$lambda$2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (API.getInstance().UI_QueryBool(61, MessageID.MSG_BODE_RUNSTOP)) {
                        BodeWindowHolder.this.getDatas().clear();
                        BodeWindowHolder.this.initlist();
                        BodeWindowHolder.this.getTableAdapter().setData(BodeWindowHolder.this.getDatas());
                        BodeWindowHolder.this.getTableAdapter().notifyDataSetChanged();
                    }
                }
            });
        }
        Unit unit3 = Unit.INSTANCE;
        this.binding = inflate2;
    }

    public final ArrayList<ArrayList<String>> getDatas() {
        return this.datas;
    }

    public final UpdateUIViewModel getUpdateUIViewModel() {
        return this.updateUIViewModel;
    }

    public final TableAdapter getTableAdapter() {
        return this.tableAdapter;
    }

    public final ArrayList<String> getListStringData() {
        return this.listStringData;
    }

    public final void setListStringData(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.listStringData = arrayList;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_BODE.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…WIN_BODE.value1\n        )");
        textView.setText(mappingObject.getStr());
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }

    public final void initlist() {
        this.datas.add(CollectionsKt.arrayListOf("Index", "Freq", "Gain", "Phase"));
    }
}
