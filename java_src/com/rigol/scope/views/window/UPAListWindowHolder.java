package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
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
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.decoration.BackgroundItemDecoration;
import com.rigol.scope.views.upa.UpaPopupview;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%¨\u0006*"}, d2 = {"Lcom/rigol/scope/views/window/UPAListWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "json", "", "getJson", "()Ljava/lang/String;", "setJson", "(Ljava/lang/String;)V", "tableAdapter", "Lcom/rigol/scope/adapters/TableAdapter;", "getTableAdapter", "()Lcom/rigol/scope/adapters/TableAdapter;", "tableBinding", "Lcom/rigol/scope/databinding/TableSimpleBinding;", "titlesArray", "Landroid/util/SparseArray;", "Lcom/rigol/scope/data/MappingObject;", "getTitlesArray", "()Landroid/util/SparseArray;", "setTitlesArray", "(Landroid/util/SparseArray;)V", "updateUIViewModel", "Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "getUpdateUIViewModel", "()Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateTitle", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class UPAListWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final Handler handler;
    private String json;
    private final TableAdapter tableAdapter;
    private final TableSimpleBinding tableBinding;
    private SparseArray<MappingObject> titlesArray;
    private final UpdateUIViewModel updateUIViewModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UPAListWindowHolder(Context context, WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Boolean> mutableLiveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        SparseArray<MappingObject> createMappingByValue = MappingObject.createMappingByValue(context, R.array.msg_upa_power_volt, R.array.msg_upa_power_curr, R.array.msg_app_upa_query_power_data);
        Intrinsics.checkNotNullExpressionValue(createMappingByValue, "MappingObject.createMapp…pa_query_power_data\n    )");
        this.titlesArray = createMappingByValue;
        this.handler = new Handler(Looper.getMainLooper());
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel != null && (mutableLiveData = updateUIViewModel.get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_UPA)) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity, new UPAListWindowHolder$$special$$inlined$apply$lambda$1(this));
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
        Unit unit2 = Unit.INSTANCE;
        this.tableBinding = inflate;
        WindowSimpleBinding inflate2 = WindowSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate2, "WindowSimpleBinding.infl…utInflater.from(context))");
        TextView title = inflate2.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_UPA.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…_UPA.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate2.contentLayout.addView(this.tableBinding.getRoot(), -1, -1);
        inflate2.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.UPAListWindowHolder$$special$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(UPAListWindowHolder.this);
                API.getInstance().UI_PostBool(31, MessageID.MSG_UPA_POWER_DISP, false);
                MessageBus.getInstance().onSyncData(MessageBus.getKey(31, MessageID.MSG_UPA_POWER_DISP), false);
            }
        });
        inflate2.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.UPAListWindowHolder$binding$1$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(UpaPopupview.class);
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

    public final Handler getHandler() {
        return this.handler;
    }

    public final String getJson() {
        return this.json;
    }

    public final void setJson(String str) {
        this.json = str;
    }

    public final UpdateUIViewModel getUpdateUIViewModel() {
        return this.updateUIViewModel;
    }

    public final TableAdapter getTableAdapter() {
        return this.tableAdapter;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_UPA.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec….WIN_UPA.value1\n        )");
        textView.setText(mappingObject.getStr());
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }
}
