package com.rigol.scope.adapters;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.NavigateParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.NavigateViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
/* compiled from: TableAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010(\u001a\u00020\u0004H\u0016J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u0004H\u0016J\b\u0010+\u001a\u0004\u0018\u00010%J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0004H\u0016J\u0018\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0004H\u0016J\u000e\u00103\u001a\u00020-2\u0006\u0010$\u001a\u00020%R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR|\u0010\u0012\u001a.\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000fj\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011`\u001122\u0010\u000e\u001a.\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f0\u000fj\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011`\u0011@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010!\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u001b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u00064"}, d2 = {"Lcom/rigol/scope/adapters/TableAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/rigol/scope/adapters/TableHolder;", "rowHeight", "", "cellPercents", "", "divider", "Landroid/graphics/drawable/Drawable;", "(I[FLandroid/graphics/drawable/Drawable;)V", "getCellPercents", "()[F", "setCellPercents", "([F)V", "value", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "data", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "getDivider", "()Landroid/graphics/drawable/Drawable;", "headerInfo", "iPosition", "", "isTouch", "()Z", "setTouch", "(Z)V", "itemViewType", "oNavEnable", "getONavEnable", "setONavEnable", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRowHeight", "()I", "getItemCount", "getItemViewType", "position", "getRecyclerView", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setRecyclerView", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public class TableAdapter extends RecyclerView.Adapter<TableHolder> {
    private float[] cellPercents;
    private final Drawable divider;
    private ArrayList<String> headerInfo;
    private boolean oNavEnable;
    private RecyclerView recyclerView;
    private final int rowHeight;
    private int itemViewType = -1;
    private int iPosition = 1;
    private boolean isTouch = true;
    private ArrayList<ArrayList<String>> data = new ArrayList<>();

    public final float[] getCellPercents() {
        return this.cellPercents;
    }

    public final Drawable getDivider() {
        return this.divider;
    }

    public final int getRowHeight() {
        return this.rowHeight;
    }

    public final void setCellPercents(float[] fArr) {
        this.cellPercents = fArr;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [T, com.rigol.scope.data.NavigateParam] */
    public TableAdapter(int i, float[] fArr, Drawable drawable) {
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        this.rowHeight = i;
        this.cellPercents = fArr;
        this.divider = drawable;
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(25, MessageID.MSG_SEARCH_NAVIGATION_EVENT_DIRECTION)) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) topActivity, new Observer<Object>() { // from class: com.rigol.scope.adapters.TableAdapter.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(Object obj) {
                    if (obj != null) {
                        if (((Integer) obj).intValue() == 0) {
                            TableAdapter.this.iPosition = 1;
                        } else {
                            TableAdapter.this.iPosition = ((Number) obj).intValue();
                        }
                        TableAdapter.this.notifyDataSetChanged();
                        RecyclerView recyclerView = TableAdapter.this.getRecyclerView();
                        if (recyclerView != null) {
                            recyclerView.scrollToPosition(TableAdapter.this.iPosition);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            });
        }
        final NavigateViewModel navigateViewModel = (NavigateViewModel) ContextUtil.getActivityViewModel(NavigateViewModel.class);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = (NavigateParam) 0;
        SyncDataViewModel syncDataViewModel2 = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel2 == null || (mutableLiveData = syncDataViewModel2.get(58, MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING)) == null) {
            return;
        }
        Activity topActivity2 = ActivityUtils.getTopActivity();
        if (topActivity2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) topActivity2, new Observer<Object>() { // from class: com.rigol.scope.adapters.TableAdapter.2
            /* JADX WARN: Type inference failed for: r2v8, types: [T, com.rigol.scope.data.NavigateParam] */
            @Override // androidx.lifecycle.Observer
            public void onChanged(Object obj) {
                if ((obj instanceof Integer) && 12 == ((Integer) obj).intValue()) {
                    NavigateViewModel navigateViewModel2 = navigateViewModel;
                    if (navigateViewModel2 != null) {
                        objectRef.element = navigateViewModel2.getLiveData().getValue();
                    }
                    TableAdapter tableAdapter = TableAdapter.this;
                    NavigateParam navigateParam = (NavigateParam) objectRef.element;
                    Boolean valueOf = navigateParam != null ? Boolean.valueOf(navigateParam.readHorRun()) : null;
                    Intrinsics.checkNotNull(valueOf);
                    tableAdapter.setONavEnable(valueOf.booleanValue());
                    TableAdapter.this.setTouch(true);
                }
            }
        });
    }

    public final boolean getONavEnable() {
        return this.oNavEnable;
    }

    public final void setONavEnable(boolean z) {
        this.oNavEnable = z;
    }

    public final boolean isTouch() {
        return this.isTouch;
    }

    public final void setTouch(boolean z) {
        this.isTouch = z;
    }

    public final ArrayList<ArrayList<String>> getData() {
        return this.data;
    }

    public final void setData(ArrayList<ArrayList<String>> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.data = value;
        ArrayList<String> arrayList = value.size() >= 1 ? this.data.get(0) : null;
        this.headerInfo = arrayList;
        this.itemViewType = arrayList != null ? arrayList.size() : -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.itemViewType;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0107  */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.rigol.scope.adapters.TableHolder onCreateViewHolder(android.view.ViewGroup r17, int r18) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.adapters.TableAdapter.onCreateViewHolder(android.view.ViewGroup, int):com.rigol.scope.adapters.TableHolder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TableHolder holder, final int i) {
        ArrayList<String> arrayList;
        Intrinsics.checkNotNullParameter(holder, "holder");
        View view = holder.itemView;
        Intrinsics.checkNotNullExpressionValue(view, "holder.itemView");
        if (this.data.isEmpty() || (arrayList = this.data.get(i)) == null || arrayList.isEmpty()) {
            return;
        }
        boolean z = i == 0;
        boolean z2 = i % 2 == 0;
        if (this.iPosition == i && 40 == this.rowHeight) {
            if (this.oNavEnable) {
                view.setBackgroundColor(ContextUtil.getColor(R.color.medium_sea_green));
            } else {
                view.setBackgroundColor(z2 ? ContextUtil.getColor(R.color.silver) : -1);
            }
        } else {
            view.setBackgroundColor(z2 ? ContextUtil.getColor(R.color.silver) : -1);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() > 0) {
                int childCount = viewGroup.getChildCount();
                int i2 = 0;
                while (i2 < childCount) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (childAt instanceof TextView) {
                        if (z) {
                            if (!this.oNavEnable) {
                                TextView textView = (TextView) childAt;
                                textView.setTypeface(textView.getTypeface(), 1);
                            }
                        } else {
                            TextView textView2 = (TextView) childAt;
                            textView2.setTypeface(textView2.getTypeface(), 0);
                        }
                        String str = i2 < arrayList.size() ? arrayList.get(i2) : "null";
                        Intrinsics.checkNotNullExpressionValue(str, "if (i < rowInfo.size) rowInfo[i] else \"null\"");
                        TextView textView3 = (TextView) childAt;
                        textView3.setText(str);
                        textView3.setTextSize(12.0f);
                        textView3.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                    }
                    i2++;
                }
            }
        }
        if (40 == this.rowHeight && this.oNavEnable) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.TableAdapter$onBindViewHolder$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    if (i != 0) {
                        if (TableAdapter.this.isTouch()) {
                            TableAdapter.this.notifyDataSetChanged();
                        }
                        TableAdapter.this.setTouch(false);
                        TableAdapter.this.iPosition = i;
                        MessageBus.getInstance().onSyncData(MessageBus.getKey(25, MessageID.MSG_SEARCH_NAVIGATION_EVENT), Integer.valueOf(i));
                    }
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    public final void setRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerView = recyclerView;
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }
}
