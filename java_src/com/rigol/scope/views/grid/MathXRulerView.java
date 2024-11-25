package com.rigol.scope.views.grid;

import android.content.Context;
import android.util.AttributeSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: XRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/rigol/scope/views/grid/MathXRulerView;", "Lcom/rigol/scope/views/grid/XRulerViewWrapper;", "context", "Landroid/content/Context;", "serviceID", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;ILandroid/util/AttributeSet;I)V", "horizontalParam", "Lcom/rigol/scope/data/HorizontalParam;", "horizontalViewModel", "Lcom/rigol/scope/viewmodels/HorizontalViewModel;", "long_time", "", "mathParam", "Lcom/rigol/scope/data/MathParam;", "mathViewModel", "Lcom/rigol/scope/viewmodels/MathViewModel;", "updateXRuler", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MathXRulerView extends XRulerViewWrapper {
    private final HorizontalParam horizontalParam;
    private final HorizontalViewModel horizontalViewModel;
    private long long_time;
    private MathParam mathParam;
    private final MathViewModel mathViewModel;

    public MathXRulerView(Context context) {
        this(context, 0, null, 0, 14, null);
    }

    public MathXRulerView(Context context, int i) {
        this(context, i, null, 0, 12, null);
    }

    public MathXRulerView(Context context, int i, AttributeSet attributeSet) {
        this(context, i, attributeSet, 0, 8, null);
    }

    public static final /* synthetic */ MathParam access$getMathParam$p(MathXRulerView mathXRulerView) {
        MathParam mathParam = mathXRulerView.mathParam;
        if (mathParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mathParam");
        }
        return mathParam;
    }

    public /* synthetic */ MathXRulerView(Context context, int i, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2);
    }

    public MathXRulerView(Context context, int i, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        MutableLiveData<Object> mutableLiveData5;
        MutableLiveData<Object> mutableLiveData6;
        MutableLiveData<Object> mutableLiveData7;
        MutableLiveData<Object> mutableLiveData8;
        MutableLiveData<Object> mutableLiveData9;
        MutableLiveData<Object> mutableLiveData10;
        MutableLiveData<Object> mutableLiveData11;
        LiveData<ArrayList<MathParam>> liveData;
        LiveData<HorizontalParam> liveData2;
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.horizontalViewModel = horizontalViewModel;
        ArrayList<MathParam> arrayList = null;
        this.horizontalParam = (horizontalViewModel == null || (liveData2 = horizontalViewModel.getLiveData()) == null) ? null : liveData2.getValue();
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        this.mathViewModel = mathViewModel;
        int i3 = i - 17;
        if (mathViewModel != null && (liveData = mathViewModel.getLiveData()) != null) {
            arrayList = liveData.getValue();
        }
        if (arrayList != null && i3 >= 0 && i3 < arrayList.size()) {
            MathParam mathParam = arrayList.get(i3);
            Intrinsics.checkNotNullExpressionValue(mathParam, "it[mathParamIndex]");
            this.mathParam = mathParam;
        }
        if (context != null) {
            MathParam mathParam2 = this.mathParam;
            if (mathParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mathParam");
            }
            setColumnTextColor(ColorUtil.getColor(context, mathParam2.getChan()));
        }
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel != null && (mutableLiveData11 = syncDataViewModel.get(10, MessageID.MSG_HOR_MAIN_SCALE)) != null) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData11.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam == null || !MathXRulerView.this.isShown()) {
                        return;
                    }
                    MathXRulerView mathXRulerView = MathXRulerView.this;
                    mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
        if (syncDataViewModel2 != null && (mutableLiveData10 = syncDataViewModel2.get(10, MessageID.MSG_HOR_MAIN_OFFSET)) != null) {
            Context context3 = getContext();
            if (context3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData10.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.5
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam == null || !MathXRulerView.this.isShown()) {
                        return;
                    }
                    MathXRulerView mathXRulerView = MathXRulerView.this;
                    mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                }
            });
        }
        SyncDataViewModel syncDataViewModel3 = getSyncDataViewModel();
        if (syncDataViewModel3 != null && (mutableLiveData9 = syncDataViewModel3.get(10, MessageID.MSG_HOR_ZOOM_SCALE)) != null) {
            Context context4 = getContext();
            if (context4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData9.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam != null) {
                        MathXRulerView mathXRulerView = MathXRulerView.this;
                        mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel4 = getSyncDataViewModel();
        if (syncDataViewModel4 != null && (mutableLiveData8 = syncDataViewModel4.get(10, MessageID.MSG_HOR_ZOOM_OFFSET)) != null) {
            Context context5 = getContext();
            if (context5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData8.observe((LifecycleOwner) context5, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam != null) {
                        MathXRulerView mathXRulerView = MathXRulerView.this;
                        mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel5 = getSyncDataViewModel();
        if (syncDataViewModel5 != null && (mutableLiveData7 = syncDataViewModel5.get(i, MessageID.MSG_MATH_FFT_H_CENTER)) != null) {
            Context context6 = getContext();
            if (context6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData7.observe((LifecycleOwner) context6, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam != null) {
                        MathXRulerView mathXRulerView = MathXRulerView.this;
                        mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel6 = getSyncDataViewModel();
        if (syncDataViewModel6 != null && (mutableLiveData6 = syncDataViewModel6.get(i, MessageID.MSG_MATH_FFT_H_SPAN)) != null) {
            Context context7 = getContext();
            if (context7 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData6.observe((LifecycleOwner) context7, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.9
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam != null) {
                        MathXRulerView mathXRulerView = MathXRulerView.this;
                        mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel7 = getSyncDataViewModel();
        if (syncDataViewModel7 != null && (mutableLiveData5 = syncDataViewModel7.get(i, MessageID.MSG_MATH_FFT_H_START)) != null) {
            Context context8 = getContext();
            if (context8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData5.observe((LifecycleOwner) context8, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.10
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam != null) {
                        MathXRulerView mathXRulerView = MathXRulerView.this;
                        mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel8 = getSyncDataViewModel();
        if (syncDataViewModel8 != null && (mutableLiveData4 = syncDataViewModel8.get(i, MessageID.MSG_MATH_FFT_START_ZOOM)) != null) {
            Context context9 = getContext();
            if (context9 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData4.observe((LifecycleOwner) context9, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.11
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam != null) {
                        MathXRulerView mathXRulerView = MathXRulerView.this;
                        mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel9 = getSyncDataViewModel();
        if (syncDataViewModel9 != null && (mutableLiveData3 = syncDataViewModel9.get(i, MessageID.MSG_MATH_FFT_SCALE_ZOOM)) != null) {
            Context context10 = getContext();
            if (context10 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) context10, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.12
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam != null) {
                        MathXRulerView mathXRulerView = MathXRulerView.this;
                        mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel10 = getSyncDataViewModel();
        if (syncDataViewModel10 != null && (mutableLiveData2 = syncDataViewModel10.get(i, MessageID.MSG_MATH_FFT_H_END)) != null) {
            Context context11 = getContext();
            if (context11 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context11, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.13
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathXRulerView.this.horizontalParam != null) {
                        MathXRulerView mathXRulerView = MathXRulerView.this;
                        mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel11 = getSyncDataViewModel();
        if (syncDataViewModel11 == null || (mutableLiveData = syncDataViewModel11.get(i, MessageID.MSG_MATH_WAVE_TYPE)) == null) {
            return;
        }
        Context context12 = getContext();
        if (context12 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context12, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathXRulerView.14
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                if (MathXRulerView.this.horizontalParam != null) {
                    MathXRulerView mathXRulerView = MathXRulerView.this;
                    mathXRulerView.updateXRuler(MathXRulerView.access$getMathParam$p(mathXRulerView), MathXRulerView.this.horizontalParam);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateXRuler(MathParam mathParam, HorizontalParam horizontalParam) {
        String[] mathXZoomRulers;
        if (mathParam.getWaveType() == ServiceEnum.MathWaveType.MathWave_Main) {
            mathXZoomRulers = ViewUtil.getMathXMainRulers(mathParam, horizontalParam);
        } else {
            mathXZoomRulers = ViewUtil.getMathXZoomRulers(mathParam, horizontalParam);
        }
        setColumnContents(mathXZoomRulers);
        if (System.currentTimeMillis() - this.long_time > 200) {
            this.long_time = System.currentTimeMillis();
            postInvalidate();
        }
    }
}
