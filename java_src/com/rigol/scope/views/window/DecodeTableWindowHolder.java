package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
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
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.TableAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.TableSimpleBinding;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.StateManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.decoration.BackgroundItemDecoration;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\b\u0010 \u001a\u00020\u001cH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/rigol/scope/views/window/DecodeTableWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "MAX_CSV_LENGTH", "", "backgroundItemDecoration", "Lcom/rigol/scope/views/decoration/BackgroundItemDecoration;", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "decodeParam", "Lcom/rigol/scope/data/DecodeParam;", "decodeTypeStr", "", "tableAdapter", "Lcom/rigol/scope/adapters/TableAdapter;", "getTableAdapter", "()Lcom/rigol/scope/adapters/TableAdapter;", "tableBinding", "Lcom/rigol/scope/databinding/TableSimpleBinding;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "showContentView", "", "isShow", "", "updateContent", "updateTitle", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DecodeTableWindowHolder extends WindowHolder {
    private final int MAX_CSV_LENGTH;
    private final BackgroundItemDecoration backgroundItemDecoration;
    private final WindowSimpleBinding binding;
    private DecodeParam decodeParam;
    private String decodeTypeStr;
    private final TableAdapter tableAdapter;
    private final TableSimpleBinding tableBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DecodeTableWindowHolder(Context context, final WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3;
        LiveData<ArrayList<DecodeParam>> liveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        LiveData<SharedParam> liveData2 = ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData();
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        liveData2.observe((LifecycleOwner) topActivity, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.DecodeTableWindowHolder.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(final SharedParam sharedParam) {
                sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.DecodeTableWindowHolder.1.1
                    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                    public void onPropertyChanged(Observable observable, int i) {
                        if (!sharedParam.getShowResultBar() || DecodeTableWindowHolder.this.getBinding().getRoot() == null) {
                            return;
                        }
                        View root = DecodeTableWindowHolder.this.getBinding().getRoot();
                        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
                        if (root.getParent() != null) {
                            View root2 = DecodeTableWindowHolder.this.getBinding().getRoot();
                            Intrinsics.checkNotNullExpressionValue(root2, "binding.root");
                            ViewParent parent = root2.getParent();
                            if (parent == null) {
                                throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                            }
                            View root3 = DecodeTableWindowHolder.this.getBinding().getRoot();
                            Intrinsics.checkNotNullExpressionValue(root3, "binding.root");
                            if (root3.getRight() == ((View) parent).getWidth()) {
                                View root4 = DecodeTableWindowHolder.this.getBinding().getRoot();
                                Intrinsics.checkNotNullExpressionValue(root4, "binding.root");
                                ViewGroup.LayoutParams layoutParams = root4.getLayoutParams();
                                View contentLayout = DecodeTableWindowHolder.this.getWindow().getContentLayout();
                                Intrinsics.checkNotNull(contentLayout);
                                layoutParams.width = contentLayout.getWidth() - 140;
                                View root5 = DecodeTableWindowHolder.this.getBinding().getRoot();
                                Intrinsics.checkNotNullExpressionValue(root5, "binding.root");
                                root5.setLayoutParams(layoutParams);
                            }
                        }
                    }
                });
            }
        });
        this.MAX_CSV_LENGTH = 1003;
        this.tableAdapter = new TableAdapter(30, null, ContextCompat.getDrawable(context, R.drawable.divider));
        BackgroundItemDecoration backgroundItemDecoration = new BackgroundItemDecoration();
        backgroundItemDecoration.setItemHeight(30);
        Unit unit = Unit.INSTANCE;
        this.backgroundItemDecoration = backgroundItemDecoration;
        TableSimpleBinding inflate = TableSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "TableSimpleBinding.infla…utInflater.from(context))");
        inflate.list.addItemDecoration(this.backgroundItemDecoration);
        RecyclerView list = inflate.list;
        Intrinsics.checkNotNullExpressionValue(list, "list");
        list.setAdapter(this.tableAdapter);
        Unit unit2 = Unit.INSTANCE;
        this.tableBinding = inflate;
        WindowSimpleBinding inflate2 = WindowSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate2, "WindowSimpleBinding.infl…utInflater.from(context))");
        TextView title = inflate2.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_DECODE.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…CODE.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate2.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.DecodeTableWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DecodeParam decodeParam = DecodeTableWindowHolder.this.decodeParam;
                if (decodeParam != null) {
                    decodeParam.saveEvent(false);
                }
            }
        });
        inflate2.contentLayout.addView(this.tableBinding.getRoot(), -1, -1);
        inflate2.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.DecodeTableWindowHolder$binding$1$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(DecodeNewPopupView.class);
            }
        });
        Unit unit3 = Unit.INSTANCE;
        this.binding = inflate2;
        DecodeViewModel decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
        if (decodeViewModel != null && (liveData = decodeViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            liveData.observe((LifecycleOwner) topActivity2, new Observer<ArrayList<DecodeParam>>() { // from class: com.rigol.scope.views.window.DecodeTableWindowHolder.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(ArrayList<DecodeParam> arrayList) {
                    if (arrayList != null) {
                        DecodeTableWindowHolder.this.decodeParam = ViewUtil.getDecodeItem(arrayList, windowParam.getServiceID() - 42);
                    }
                }
            });
        }
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel != null && (mutableLiveData3 = updateUIViewModel.get(windowParam.getServiceID(), MessageID.MSG_APP_DECODE_QUERY_EVT_CONTENT)) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 != null) {
                mutableLiveData3.observe((LifecycleOwner) topActivity3, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.DecodeTableWindowHolder.3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Boolean bool) {
                        DecodeTableWindowHolder.this.updateContent(windowParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(windowParam.getServiceID(), MessageID.MSG_DECODE_ONOFF)) != null) {
            Activity topActivity4 = ActivityUtils.getTopActivity();
            if (topActivity4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) topActivity4, new Observer<Object>() { // from class: com.rigol.scope.views.window.DecodeTableWindowHolder.4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DecodeParam decodeParam = DecodeTableWindowHolder.this.decodeParam;
                    if (decodeParam != null) {
                        DecodeTableWindowHolder.this.showContentView(decodeParam.isOnOff());
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel2 != null && (mutableLiveData = syncDataViewModel2.get(windowParam.getServiceID(), MessageID.MSG_DECODE_TYPE)) != null) {
            Activity topActivity5 = ActivityUtils.getTopActivity();
            if (topActivity5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity5, new Observer<Object>() { // from class: com.rigol.scope.views.window.DecodeTableWindowHolder.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (DecodeTableWindowHolder.this.decodeParam != null) {
                        DecodeTableWindowHolder.this.updateTitle();
                    }
                }
            });
        }
        StateManager.INSTANCE.setState(ServiceEnum.WindowType.WIN_DECODE, 1, 4, Integer.valueOf(windowParam.getServiceID() - 42), true);
    }

    public final TableAdapter getTableAdapter() {
        return this.tableAdapter;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        int serviceID = getWindowParam().getServiceID() - 42;
        int i = R.string.ids_decode1;
        if (serviceID != 0) {
            if (serviceID == 1) {
                i = R.string.ids_decode2;
            } else if (serviceID == 2) {
                i = R.string.ids_decode3;
            } else if (serviceID == 3) {
                i = R.string.ids_decode4;
            }
        }
        String string = ContextUtil.getString(i);
        if (this.decodeParam != null) {
            TextView textView = this.binding.title;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(" (");
            DecodeParam decodeParam = this.decodeParam;
            Intrinsics.checkNotNull(decodeParam);
            sb.append(decodeParam.getType().value2);
            sb.append(')');
            textView.setText(sb.toString());
            return;
        }
        TextView textView2 = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.title");
        textView2.setText(string);
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showContentView(boolean z) {
        if (z) {
            this.binding.windowLayout.showContentView();
        } else {
            this.binding.windowLayout.showEmptyView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateContent(WindowParam windowParam) {
        List<String[]> subList;
        ArrayList<String[]> csvInfo = ViewUtil.getCsvInfo(API.getInstance().UI_QueryStr(windowParam.getServiceID(), MessageID.MSG_APP_DECODE_QUERY_EVT_CONTENT), Integer.valueOf(this.MAX_CSV_LENGTH), true);
        if (csvInfo != null && csvInfo.size() >= 2) {
            String[] strArr = csvInfo.get(0);
            if (strArr.length >= 2) {
                this.decodeTypeStr = strArr[1];
                updateTitle();
            }
            String[] headInfo = csvInfo.get(1);
            Intrinsics.checkNotNullExpressionValue(headInfo, "headInfo");
            if (headInfo.length == 0) {
                return;
            }
            ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
            ArrayList<String> arrayList2 = new ArrayList<>();
            arrayList2.add("Index");
            for (String str : headInfo) {
                if (!TextUtils.isEmpty(str)) {
                    arrayList2.add(str);
                }
            }
            arrayList.add(arrayList2);
            if (csvInfo.size() == this.MAX_CSV_LENGTH) {
                subList = csvInfo.subList(2, csvInfo.size() - 1);
            } else {
                subList = csvInfo.subList(2, csvInfo.size());
            }
            Intrinsics.checkNotNullExpressionValue(subList, "if (csvInfo.size == MAX_…o.size)\n                }");
            if (subList.isEmpty()) {
                return;
            }
            int i = 0;
            for (Object obj : subList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                String[] strArr2 = (String[]) obj;
                if (strArr2 != null) {
                    if (!(strArr2.length == 0)) {
                        ArrayList<String> arrayList3 = new ArrayList<>();
                        arrayList3.add(String.valueOf(i2));
                        int length = headInfo.length;
                        for (int i3 = 1; i3 < length; i3++) {
                            int i4 = i3 - 1;
                            if (i4 >= strArr2.length) {
                                arrayList3.add("null");
                            } else {
                                arrayList3.add(strArr2[i4]);
                            }
                        }
                        arrayList.add(arrayList3);
                    }
                }
                i = i2;
            }
            this.tableAdapter.setData(arrayList);
            this.tableAdapter.notifyDataSetChanged();
        }
        if (csvInfo == null) {
            this.tableAdapter.setData(new ArrayList<>());
            this.tableAdapter.notifyDataSetChanged();
        }
    }
}
