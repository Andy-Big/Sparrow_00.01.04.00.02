package com.rigol.scope.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: YRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rigol/scope/views/grid/MathYRulerView;", "Lcom/rigol/scope/views/grid/YRulerViewWrapper;", "context", "Landroid/content/Context;", "serviceID", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;ILandroid/util/AttributeSet;I)V", "mathParam", "Lcom/rigol/scope/data/MathParam;", "mathViewModel", "Lcom/rigol/scope/viewmodels/MathViewModel;", "updateYRuler", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MathYRulerView extends YRulerViewWrapper {
    private MathParam mathParam;
    private final MathViewModel mathViewModel;

    public MathYRulerView(Context context) {
        this(context, 0, null, 0, 14, null);
    }

    public MathYRulerView(Context context, int i) {
        this(context, i, null, 0, 12, null);
    }

    public MathYRulerView(Context context, int i, AttributeSet attributeSet) {
        this(context, i, attributeSet, 0, 8, null);
    }

    public static final /* synthetic */ MathParam access$getMathParam$p(MathYRulerView mathYRulerView) {
        MathParam mathParam = mathYRulerView.mathParam;
        if (mathParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mathParam");
        }
        return mathParam;
    }

    public /* synthetic */ MathYRulerView(Context context, int i, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2);
    }

    public MathYRulerView(Context context, int i, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        MutableLiveData<Object> mutableLiveData5;
        MutableLiveData<Object> mutableLiveData6;
        LiveData<ArrayList<MathParam>> liveData;
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        this.mathViewModel = mathViewModel;
        int i3 = i - 17;
        ArrayList<MathParam> value = (mathViewModel == null || (liveData = mathViewModel.getLiveData()) == null) ? null : liveData.getValue();
        if (value != null && i3 >= 0 && i3 < value.size()) {
            MathParam mathParam = value.get(i3);
            Intrinsics.checkNotNullExpressionValue(mathParam, "it[mathParamIndex]");
            this.mathParam = mathParam;
        }
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel != null && (mutableLiveData6 = syncDataViewModel.get(i, MessageID.MSG_MATH_ANALOG_S32SCALE)) != null) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData6.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathYRulerView.2
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathYRulerView mathYRulerView = MathYRulerView.this;
                    mathYRulerView.updateYRuler(MathYRulerView.access$getMathParam$p(mathYRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
        if (syncDataViewModel2 != null && (mutableLiveData5 = syncDataViewModel2.get(i, MessageID.MSG_MATH_VIEW_OFFSET)) != null) {
            Context context3 = getContext();
            if (context3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData5.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathYRulerView.3
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathYRulerView mathYRulerView = MathYRulerView.this;
                    mathYRulerView.updateYRuler(MathYRulerView.access$getMathParam$p(mathYRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel3 = getSyncDataViewModel();
        if (syncDataViewModel3 != null && (mutableLiveData4 = syncDataViewModel3.get(i, MessageID.MSG_MATH_FFT_OFFSET)) != null) {
            Context context4 = getContext();
            if (context4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData4.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathYRulerView.4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathYRulerView mathYRulerView = MathYRulerView.this;
                    mathYRulerView.updateYRuler(MathYRulerView.access$getMathParam$p(mathYRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel4 = getSyncDataViewModel();
        if (syncDataViewModel4 != null && (mutableLiveData3 = syncDataViewModel4.get(i, MessageID.MSG_MATH_FFT_SCALE)) != null) {
            Context context5 = getContext();
            if (context5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) context5, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathYRulerView.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathYRulerView mathYRulerView = MathYRulerView.this;
                    mathYRulerView.updateYRuler(MathYRulerView.access$getMathParam$p(mathYRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel5 = getSyncDataViewModel();
        if (syncDataViewModel5 != null && (mutableLiveData2 = syncDataViewModel5.get(i, MessageID.MSG_MATH_UNIT)) != null) {
            Context context6 = getContext();
            if (context6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context6, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathYRulerView.6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathYRulerView mathYRulerView = MathYRulerView.this;
                    mathYRulerView.updateYRuler(MathYRulerView.access$getMathParam$p(mathYRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel6 = getSyncDataViewModel();
        if (syncDataViewModel6 == null || (mutableLiveData = syncDataViewModel6.get(i, MessageID.MSG_MATH_OPERATOR)) == null) {
            return;
        }
        Context context7 = getContext();
        if (context7 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context7, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathYRulerView.7
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MathYRulerView mathYRulerView = MathYRulerView.this;
                mathYRulerView.updateYRuler(MathYRulerView.access$getMathParam$p(mathYRulerView));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateYRuler(MathParam mathParam) {
        setRowContents(ViewUtil.getMathYRulers(mathParam));
        invalidate();
    }
}
