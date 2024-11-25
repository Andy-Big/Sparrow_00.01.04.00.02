package com.rigol.scope.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TagView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fR\"\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\f\u0010\rR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/rigol/scope/views/MathTag;", "Lcom/rigol/scope/views/TagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "serviceID", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/rigol/scope/data/MathParam;", "mathParam", "setMathParam", "(Lcom/rigol/scope/data/MathParam;)V", "setPosition", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MathTag extends TagView {
    private MathParam mathParam;
    private final int serviceID;

    public MathTag(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ MathTag(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public MathTag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        LiveData<ArrayList<MathParam>> liveData;
        ArrayList<MathParam> value;
        int i2;
        this.serviceID = i;
        setId(View.generateViewId());
        setTag(Integer.valueOf(this.serviceID));
        setShowBorder(true);
        setShowLine(false);
        setTextColor(ViewCompat.MEASURED_STATE_MASK);
        if (getOrientation() == 0) {
            setTagWidth(35);
            setTagHeight(25);
        } else {
            setTagWidth(25);
            setTagHeight(35);
        }
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        if (mathViewModel != null && (liveData = mathViewModel.getLiveData()) != null && (value = liveData.getValue()) != null && this.serviceID - 17 >= 0 && i2 < value.size()) {
            setMathParam(value.get(i2));
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            MutableLiveData<Object> mutableLiveData = syncDataViewModel.get(this.serviceID, MessageID.MSG_MATH_VIEW_OFFSET);
            if (mutableLiveData != null) {
                Context context2 = getContext();
                if (context2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.MathTag$$special$$inlined$let$lambda$1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathTag.this.setPosition();
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData2 = syncDataViewModel.get(this.serviceID, MessageID.MSG_MATH_FFT_OFFSET);
            if (mutableLiveData2 != null) {
                Context context3 = getContext();
                if (context3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData2.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.MathTag$$special$$inlined$let$lambda$2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathTag.this.setPosition();
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData3 = syncDataViewModel.get(this.serviceID, MessageID.MSG_MATH_LOGIC_OFFSET);
            if (mutableLiveData3 != null) {
                Context context4 = getContext();
                if (context4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData3.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.MathTag$$special$$inlined$let$lambda$3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathTag.this.setPosition();
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData4 = syncDataViewModel.get(this.serviceID, MessageID.MSG_MATH_LOGIC_SCALE);
            if (mutableLiveData4 != null) {
                Context context5 = getContext();
                if (context5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData4.observe((LifecycleOwner) context5, new Observer<Object>() { // from class: com.rigol.scope.views.MathTag$$special$$inlined$let$lambda$4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathTag.this.setPosition();
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData5 = syncDataViewModel.get(this.serviceID, MessageID.MSG_MATH_SHOW_S32LABEL);
            if (mutableLiveData5 != null) {
                Context context6 = getContext();
                if (context6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData5.observe((LifecycleOwner) context6, new Observer<Object>() { // from class: com.rigol.scope.views.MathTag$$special$$inlined$let$lambda$5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathParam mathParam;
                        MathParam mathParam2;
                        mathParam = MathTag.this.mathParam;
                        if (mathParam != null) {
                            MathTag.this.setShowLabel(mathParam.isLabel());
                        }
                        MathTag mathTag = MathTag.this;
                        mathParam2 = mathTag.mathParam;
                        mathTag.setLabel(mathParam2 != null ? mathParam2.getLabelString() : null);
                        MathTag.this.invalidate();
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData6 = syncDataViewModel.get(this.serviceID, MessageID.MSG_MATH_LABEL_STR);
            if (mutableLiveData6 != null) {
                Context context7 = getContext();
                if (context7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData6.observe((LifecycleOwner) context7, new Observer<Object>() { // from class: com.rigol.scope.views.MathTag$$special$$inlined$let$lambda$6
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        MathParam mathParam;
                        MathTag mathTag = MathTag.this;
                        mathParam = mathTag.mathParam;
                        mathTag.setLabel(mathParam != null ? mathParam.getLabelString() : null);
                        MathTag.this.invalidate();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setMathParam(MathParam mathParam) {
        this.mathParam = mathParam;
        setText(ViewUtil.getShortChanStr(mathParam != null ? mathParam.getChan() : null));
        Context context = getContext();
        MathParam mathParam2 = this.mathParam;
        setLabelColor(ColorUtil.getColor(context, mathParam2 != null ? mathParam2.getChan() : null));
        Context context2 = getContext();
        MathParam mathParam3 = this.mathParam;
        setTagColor(ColorUtil.getColor(context2, mathParam3 != null ? mathParam3.getChan() : null));
    }

    public final void setPosition() {
        if (getParent() == null) {
            return;
        }
        float valuePercent = ViewUtil.getValuePercent(this.mathParam, 0L);
        ViewParent parent = getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        setPosition((int) (valuePercent * ((ViewGroup) parent).getHeight()));
    }
}
