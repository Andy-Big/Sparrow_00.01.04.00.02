package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.TableAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.TableSimpleBinding;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.decoration.BackgroundItemDecoration;
import com.rigol.scope.views.measure.MeasurePopupView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010&\u001a\u00020'H\u0016J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020!H\u0002J\b\u0010+\u001a\u00020)H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/rigol/scope/views/window/AllMeasureWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "tableAdapter", "Lcom/rigol/scope/adapters/TableAdapter;", "getTableAdapter", "()Lcom/rigol/scope/adapters/TableAdapter;", "tableBinding", "Lcom/rigol/scope/databinding/TableSimpleBinding;", "getTableBinding", "()Lcom/rigol/scope/databinding/TableSimpleBinding;", "setTableBinding", "(Lcom/rigol/scope/databinding/TableSimpleBinding;)V", "titlesArray", "Landroid/util/SparseArray;", "Lcom/rigol/scope/data/MappingObject;", "getTitlesArray", "()Landroid/util/SparseArray;", "setTitlesArray", "(Landroid/util/SparseArray;)V", "updateUIViewModel", "Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "getUpdateUIViewModel", "()Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "verticalParam", "Lcom/rigol/scope/data/VerticalParam;", "getVerticalParam", "()Lcom/rigol/scope/data/VerticalParam;", "setVerticalParam", "(Lcom/rigol/scope/data/VerticalParam;)V", "getWindow", "Lcom/rigol/scope/views/window/Window;", "showContentView", "", "it", "updateTitle", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class AllMeasureWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final TableAdapter tableAdapter;
    private TableSimpleBinding tableBinding;
    private SparseArray<MappingObject> titlesArray;
    private final UpdateUIViewModel updateUIViewModel;
    private VerticalParam verticalParam;

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.AllMeasureWindowHolder$2$$special$$inlined$let$lambda$2.onPropertyChanged(androidx.databinding.Observable, int):void] */
    public static final /* synthetic */ void access$showContentView(AllMeasureWindowHolder allMeasureWindowHolder, VerticalParam verticalParam) {
        allMeasureWindowHolder.showContentView(verticalParam);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AllMeasureWindowHolder(Context context, final WindowParam windowParam) {
        super(windowParam);
        LiveData<ArrayList<VerticalParam>> liveData;
        MutableLiveData<Boolean> mutableLiveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        LiveData<SharedParam> liveData2 = ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData();
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        liveData2.observe((LifecycleOwner) topActivity, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.AllMeasureWindowHolder.1
            {
                AllMeasureWindowHolder.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(final SharedParam sharedParam) {
                sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.AllMeasureWindowHolder.1.1
                    {
                        AnonymousClass1.this = this;
                    }

                    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                    public void onPropertyChanged(Observable observable, int i) {
                        if (!sharedParam.getShowResultBar() || AllMeasureWindowHolder.this.getBinding().getRoot() == null) {
                            return;
                        }
                        View root = AllMeasureWindowHolder.this.getBinding().getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        if (root.getParent() != null) {
                            View root2 = AllMeasureWindowHolder.this.getBinding().getRoot();
                            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                            ViewParent parent = root2.getParent();
                            if (parent == null) {
                                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                            }
                            View root3 = AllMeasureWindowHolder.this.getBinding().getRoot();
                            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
                            if (root3.getRight() == ((View) parent).getWidth()) {
                                View root4 = AllMeasureWindowHolder.this.getBinding().getRoot();
                                Intrinsics.checkNotNullExpressionValue(root4, "binding.root");
                                ViewGroup.LayoutParams layoutParams = root4.getLayoutParams();
                                View contentLayout = AllMeasureWindowHolder.this.getWindow().getContentLayout();
                                Intrinsics.checkNotNull(contentLayout);
                                layoutParams.width = contentLayout.getWidth() - 140;
                                View root5 = AllMeasureWindowHolder.this.getBinding().getRoot();
                                Intrinsics.checkNotNullExpressionValue(root5, "binding.root");
                                root5.setLayoutParams(layoutParams);
                            }
                        }
                    }
                });
            }
        });
        SparseArray<MappingObject> createMappingByValue = MappingObject.createMappingByValue(context, R.array.msg_app_meas_hor_type, R.array.msg_app_meas_vertical_type, R.array.msg_app_meas_other_type);
        Intrinsics.checkNotNullExpressionValue(createMappingByValue, "MappingObject.createMapp…app_meas_other_type\n    )");
        this.titlesArray = createMappingByValue;
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel != null && (mutableLiveData = updateUIViewModel.get(28, MessageID.MSG_APP_MEAS_QUERY_DATA_ALL)) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity2, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.AllMeasureWindowHolder$$special$$inlined$apply$lambda$1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Boolean bool) {
                    try {
                        String[][] strArr = (String[][]) GsonUtils.fromJson(API.getInstance().UI_QueryStr(28, MessageID.MSG_APP_MEAS_QUERY_DATA_ALL), (Class<Object>) String[][].class);
                        if (strArr != null && strArr.length > 1) {
                            ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
                            arrayList.add(CollectionsKt.arrayListOf("Index", "Name", "Source", "Current"));
                            int length = strArr.length;
                            for (int i = 1; i < length; i++) {
                                String[] strArr2 = strArr[i];
                                if (strArr2.length < 2) {
                                    arrayList.add(CollectionsKt.arrayListOf("", "", "", ""));
                                } else {
                                    MappingObject mappingObject = AllMeasureWindowHolder.this.getTitlesArray().get(Integer.parseInt(strArr2[0]));
                                    Intrinsics.checkNotNullExpressionValue(mappingObject, "mappingObject");
                                    String str = mappingObject.getStr();
                                    Intrinsics.checkNotNullExpressionValue(str, "mappingObject.str");
                                    String fullChanStr = ViewUtil.getFullChanStr(windowParam.getSource1());
                                    Intrinsics.checkNotNullExpressionValue(fullChanStr, "ViewUtil.getFullChanStr(windowParam.source1)");
                                    arrayList.add(CollectionsKt.arrayListOf(String.valueOf(i), str, fullChanStr, strArr2[1]));
                                }
                            }
                            AllMeasureWindowHolder.this.getTableAdapter().setData(arrayList);
                            AllMeasureWindowHolder.this.getTableAdapter().notifyItemRangeChanged(0, AllMeasureWindowHolder.this.getTableAdapter().getData().size());
                            return;
                        }
                        ArrayList<ArrayList<String>> arrayList2 = new ArrayList<>();
                        arrayList2.add(CollectionsKt.arrayListOf("Index", "Name", "Source", "Current"));
                        int size = AllMeasureWindowHolder.this.getTitlesArray().size();
                        for (int i2 = 1; i2 < size; i2++) {
                            arrayList2.add(CollectionsKt.arrayListOf("", "", "", ""));
                        }
                        AllMeasureWindowHolder.this.getTableAdapter().setData(arrayList2);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        Unit unit = Unit.INSTANCE;
        this.updateUIViewModel = updateUIViewModel;
        this.tableAdapter = new TableAdapter(30, null, ContextCompat.getDrawable(context, R.drawable.divider));
        TableSimpleBinding inflate = TableSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "TableSimpleBinding.infla…utInflater.from(context))");
        BackgroundItemDecoration backgroundItemDecoration = new BackgroundItemDecoration();
        backgroundItemDecoration.setItemHeight(30);
        inflate.list.addItemDecoration(backgroundItemDecoration);
        RecyclerView list = inflate.list;
        Intrinsics.checkNotNullExpressionValue(list, "list");
        list.setAdapter(this.tableAdapter);
        RecyclerView list2 = inflate.list;
        Intrinsics.checkNotNullExpressionValue(list2, "list");
        RecyclerView.ItemAnimator itemAnimator = list2.getItemAnimator();
        if (itemAnimator == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.SimpleItemAnimator");
        }
        ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        Unit unit2 = Unit.INSTANCE;
        this.tableBinding = inflate;
        WindowSimpleBinding inflate2 = WindowSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate2, "WindowSimpleBinding.infl…utInflater.from(context))");
        TextView title = inflate2.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_ALL_MEASURE.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…SURE.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate2.contentLayout.addView(this.tableBinding.getRoot(), -1, -1);
        inflate2.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.AllMeasureWindowHolder$$special$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(AllMeasureWindowHolder.this);
                API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_ALL_SRC, ServiceEnum.Chan.chan_none.value1);
            }
        });
        inflate2.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.AllMeasureWindowHolder$binding$1$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(MeasurePopupView.class);
            }
        });
        Unit unit3 = Unit.INSTANCE;
        this.binding = inflate2;
        API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_ALL_SRC, windowParam.getSource1().value1);
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        if (verticalViewModel == null || (liveData = verticalViewModel.getLiveData()) == null) {
            return;
        }
        Activity topActivity3 = ActivityUtils.getTopActivity();
        if (topActivity3 != null) {
            liveData.observe((LifecycleOwner) topActivity3, new AnonymousClass2(windowParam));
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public final SparseArray<MappingObject> getTitlesArray() {
        return this.titlesArray;
    }

    public final void setTitlesArray(SparseArray<MappingObject> sparseArray) {
        Intrinsics.checkNotNullParameter(sparseArray, "<set-?>");
        this.titlesArray = sparseArray;
    }

    public final UpdateUIViewModel getUpdateUIViewModel() {
        return this.updateUIViewModel;
    }

    public final VerticalParam getVerticalParam() {
        return this.verticalParam;
    }

    public final void setVerticalParam(VerticalParam verticalParam) {
        this.verticalParam = verticalParam;
    }

    public final TableAdapter getTableAdapter() {
        return this.tableAdapter;
    }

    public final TableSimpleBinding getTableBinding() {
        return this.tableBinding;
    }

    public final void setTableBinding(TableSimpleBinding tableSimpleBinding) {
        Intrinsics.checkNotNullParameter(tableSimpleBinding, "<set-?>");
        this.tableBinding = tableSimpleBinding;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_ALL_MEASURE.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…_MEASURE.value1\n        )");
        textView.setText(mappingObject.getStr());
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }

    /* compiled from: WindowHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "it", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/VerticalParam;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.rigol.scope.views.window.AllMeasureWindowHolder$2 */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2<T> implements Observer<ArrayList<VerticalParam>> {
        final /* synthetic */ WindowParam $windowParam;

        AnonymousClass2(WindowParam windowParam) {
            AllMeasureWindowHolder.this = r1;
            this.$windowParam = windowParam;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(ArrayList<VerticalParam> arrayList) {
            if (arrayList != null) {
                AllMeasureWindowHolder.this.setVerticalParam(ViewUtil.getVerticalItem(arrayList, this.$windowParam.getSource1().value1 - ServiceEnum.Chan.chan1.value1));
                final VerticalParam verticalParam = AllMeasureWindowHolder.this.getVerticalParam();
                if (verticalParam != null) {
                    AllMeasureWindowHolder.this.showContentView(verticalParam);
                    verticalParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.AllMeasureWindowHolder$2$$special$$inlined$let$lambda$2
                        @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                        public void onPropertyChanged(Observable observable, int i) {
                            if (i == 909) {
                                AllMeasureWindowHolder.access$showContentView(AllMeasureWindowHolder.this, VerticalParam.this);
                            }
                        }
                    });
                }
            }
        }
    }

    public final void showContentView(VerticalParam verticalParam) {
        if (verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_OFF) {
            this.binding.windowLayout.showEmptyView();
        } else {
            this.binding.windowLayout.showContentView();
        }
    }
}
