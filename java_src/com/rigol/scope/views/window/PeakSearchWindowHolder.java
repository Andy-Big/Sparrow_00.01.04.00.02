package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.TableAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.TableSimpleBinding;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.decoration.BackgroundItemDecoration;
import com.rigol.scope.views.math.MathPopupView;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/rigol/scope/views/window/PeakSearchWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getContext", "()Landroid/content/Context;", "value", "Lcom/rigol/scope/data/MathParam;", "mathParam", "setMathParam", "(Lcom/rigol/scope/data/MathParam;)V", "mathParamIndex", "", "getMathParamIndex", "()I", "setMathParamIndex", "(I)V", "tableAdapter", "Lcom/rigol/scope/adapters/TableAdapter;", "getTableAdapter", "()Lcom/rigol/scope/adapters/TableAdapter;", "tableBinding", "Lcom/rigol/scope/databinding/TableSimpleBinding;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateTitle", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class PeakSearchWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final Context context;
    private MathParam mathParam;
    private int mathParamIndex;
    private final TableAdapter tableAdapter;
    private final TableSimpleBinding tableBinding;

    public final Context getContext() {
        return this.context;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PeakSearchWindowHolder(Context context, final WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Boolean> mutableLiveData;
        LiveData<ArrayList<MathParam>> liveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.context = context;
        this.tableAdapter = new TableAdapter(30, null, ContextCompat.getDrawable(this.context, R.drawable.divider));
        TableSimpleBinding inflate = TableSimpleBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "TableSimpleBinding.infla…utInflater.from(context))");
        BackgroundItemDecoration backgroundItemDecoration = new BackgroundItemDecoration();
        backgroundItemDecoration.setItemHeight(30);
        inflate.list.addItemDecoration(backgroundItemDecoration);
        RecyclerView list = inflate.list;
        Intrinsics.checkNotNullExpressionValue(list, "list");
        list.setAdapter(this.tableAdapter);
        Unit unit = Unit.INSTANCE;
        this.tableBinding = inflate;
        WindowSimpleBinding inflate2 = WindowSimpleBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate2, "WindowSimpleBinding.infl…utInflater.from(context))");
        TextView title = inflate2.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_MATH.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…MATH.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate2.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.PeakSearchWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(PeakSearchWindowHolder.this);
            }
        });
        inflate2.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.PeakSearchWindowHolder$$special$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int serviceID = windowParam.getServiceID() - 17;
                BasePopupView mathPopupView = PopupViewManager.getInstance().get(MathPopupView.class);
                if (mathPopupView instanceof MathPopupView) {
                    ((MathPopupView) mathPopupView).setCurrentItem(serviceID);
                }
                Intrinsics.checkNotNullExpressionValue(mathPopupView, "mathPopupView");
                if (mathPopupView.isShowing()) {
                    mathPopupView.dismiss();
                } else {
                    mathPopupView.show();
                }
            }
        });
        inflate2.contentLayout.addView(this.tableBinding.getRoot(), -1, -1);
        Unit unit2 = Unit.INSTANCE;
        this.binding = inflate2;
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        if (mathViewModel != null && (liveData = mathViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData.observe((LifecycleOwner) topActivity, new Observer<ArrayList<MathParam>>() { // from class: com.rigol.scope.views.window.PeakSearchWindowHolder$$special$$inlined$apply$lambda$3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<MathParam> arrayList) {
                        PeakSearchWindowHolder.this.setMathParamIndex(windowParam.getServiceID() - 17);
                        if (PeakSearchWindowHolder.this.getMathParamIndex() < 0 || PeakSearchWindowHolder.this.getMathParamIndex() >= arrayList.size()) {
                            return;
                        }
                        PeakSearchWindowHolder peakSearchWindowHolder = PeakSearchWindowHolder.this;
                        peakSearchWindowHolder.setMathParam(arrayList.get(peakSearchWindowHolder.getMathParamIndex()));
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        if (updateUIViewModel == null || (mutableLiveData = updateUIViewModel.get(windowParam.getServiceID(), MessageID.MSG_FFT_PEAK_STR)) == null) {
            return;
        }
        Activity topActivity2 = ActivityUtils.getTopActivity();
        if (topActivity2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) topActivity2, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.PeakSearchWindowHolder.2
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                String UI_QueryStr = API.getInstance().UI_QueryStr(windowParam.getServiceID(), MessageID.MSG_FFT_PEAK_STR);
                try {
                    if (Intrinsics.areEqual(UI_QueryStr, "[]")) {
                        PeakSearchWindowHolder.this.getTableAdapter().setData(new ArrayList<>());
                        PeakSearchWindowHolder.this.getTableAdapter().notifyDataSetChanged();
                        return;
                    }
                    PeakSearchWindowHolder.this.getBinding().windowLayout.showContentView();
                    String[][] strArr = (String[][]) GsonUtils.fromJson(UI_QueryStr, (Class<Object>) String[][].class);
                    if (strArr != null) {
                        if (!(strArr.length == 0)) {
                            ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
                            arrayList.add(CollectionsKt.arrayListOf("Index", "Freq", "Ampl"));
                            int length = strArr.length;
                            int i = 0;
                            while (i < length) {
                                ArrayList<String> arrayList2 = new ArrayList<>();
                                int i2 = i + 1;
                                arrayList2.add(String.valueOf(i2));
                                String[] strArr2 = strArr[i];
                                for (int i3 = 0; i3 <= 2; i3++) {
                                    if (i3 >= strArr2.length) {
                                        arrayList2.add("");
                                    } else {
                                        arrayList2.add(String.valueOf(strArr2[i3]));
                                    }
                                }
                                arrayList.add(arrayList2);
                                i = i2;
                            }
                            PeakSearchWindowHolder.this.getTableAdapter().setData(arrayList);
                            PeakSearchWindowHolder.this.getTableAdapter().notifyDataSetChanged();
                            return;
                        }
                    }
                    PeakSearchWindowHolder.this.getTableAdapter().setData(new ArrayList<>());
                    PeakSearchWindowHolder.this.getTableAdapter().notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public final TableAdapter getTableAdapter() {
        return this.tableAdapter;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMathParam(MathParam mathParam) {
        this.mathParam = mathParam;
        updateTitle();
    }

    public final int getMathParamIndex() {
        return this.mathParamIndex;
    }

    public final void setMathParamIndex(int i) {
        this.mathParamIndex = i;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        if (this.mathParam != null) {
            this.binding.title.setTextColor(ColorUtil.getColor(this.context, getWindowParam().getServiceID()));
            TextView textView = this.binding.title;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
            textView.setText(ContextUtil.getString(R.string.multiwindow_10) + (this.mathParamIndex + 1));
        }
    }
}
