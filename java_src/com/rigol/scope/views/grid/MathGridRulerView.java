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
/* compiled from: GridRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/rigol/scope/views/grid/MathGridRulerView;", "Lcom/rigol/scope/views/grid/GridRulerViewWrapper;", "context", "Landroid/content/Context;", "serviceID", "", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "(Landroid/content/Context;ILandroid/util/AttributeSet;I)V", "horizontalParam", "Lcom/rigol/scope/data/HorizontalParam;", "horizontalViewModel", "Lcom/rigol/scope/viewmodels/HorizontalViewModel;", "long_time", "", "mathParam", "Lcom/rigol/scope/data/MathParam;", "mathViewModel", "Lcom/rigol/scope/viewmodels/MathViewModel;", "updateXRuler", "", "updateYRuler", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MathGridRulerView extends GridRulerViewWrapper {
    private final HorizontalParam horizontalParam;
    private final HorizontalViewModel horizontalViewModel;
    private long long_time;
    private MathParam mathParam;
    private final MathViewModel mathViewModel;

    public MathGridRulerView(Context context) {
        this(context, 0, null, 0, 14, null);
    }

    public MathGridRulerView(Context context, int i) {
        this(context, i, null, 0, 12, null);
    }

    public MathGridRulerView(Context context, int i, AttributeSet attributeSet) {
        this(context, i, attributeSet, 0, 8, null);
    }

    public static final /* synthetic */ MathParam access$getMathParam$p(MathGridRulerView mathGridRulerView) {
        MathParam mathParam = mathGridRulerView.mathParam;
        if (mathParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mathParam");
        }
        return mathParam;
    }

    public /* synthetic */ MathGridRulerView(Context context, int i, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? 0 : i, (i3 & 4) != 0 ? null : attributeSet, (i3 & 8) != 0 ? 0 : i2);
    }

    public MathGridRulerView(Context context, int i, AttributeSet attributeSet, int i2) {
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
        MutableLiveData<Object> mutableLiveData12;
        MutableLiveData<Object> mutableLiveData13;
        MutableLiveData<Object> mutableLiveData14;
        MutableLiveData<Object> mutableLiveData15;
        MutableLiveData<Object> mutableLiveData16;
        MutableLiveData<Object> mutableLiveData17;
        MutableLiveData<Object> mutableLiveData18;
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
            setRowTextColor(ColorUtil.getColor(context, mathParam2.getChan()));
        }
        if (context != null) {
            MathParam mathParam3 = this.mathParam;
            if (mathParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mathParam");
            }
            setColumnTextColor(ColorUtil.getColor(context, mathParam3.getChan()));
        }
        SyncDataViewModel syncDataViewModel = getSyncDataViewModel();
        if (syncDataViewModel != null && (mutableLiveData18 = syncDataViewModel.get(i, MessageID.MSG_DISPLAY_GRID)) != null) {
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData18.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.6
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (obj instanceof ServiceEnum.EWaveGrids) {
                        MathGridRulerView.this.setType((ServiceEnum.EWaveGrids) obj);
                        MathGridRulerView.this.invalidate();
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = getSyncDataViewModel();
        if (syncDataViewModel2 != null && (mutableLiveData17 = syncDataViewModel2.get(10, MessageID.MSG_HOR_MAIN_SCALE)) != null) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData17.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.7
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam == null || !MathGridRulerView.this.isShown()) {
                        return;
                    }
                    MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                    mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                }
            });
        }
        SyncDataViewModel syncDataViewModel3 = getSyncDataViewModel();
        if (syncDataViewModel3 != null && (mutableLiveData16 = syncDataViewModel3.get(10, MessageID.MSG_HOR_MAIN_OFFSET)) != null) {
            Context context3 = getContext();
            if (context3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData16.observe((LifecycleOwner) context3, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam == null || !MathGridRulerView.this.isShown()) {
                        return;
                    }
                    MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                    mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                }
            });
        }
        SyncDataViewModel syncDataViewModel4 = getSyncDataViewModel();
        if (syncDataViewModel4 != null && (mutableLiveData15 = syncDataViewModel4.get(10, MessageID.MSG_HOR_ZOOM_SCALE)) != null) {
            Context context4 = getContext();
            if (context4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData15.observe((LifecycleOwner) context4, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.9
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel5 = getSyncDataViewModel();
        if (syncDataViewModel5 != null && (mutableLiveData14 = syncDataViewModel5.get(10, MessageID.MSG_HOR_ZOOM_OFFSET)) != null) {
            Context context5 = getContext();
            if (context5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData14.observe((LifecycleOwner) context5, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.10
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel6 = getSyncDataViewModel();
        if (syncDataViewModel6 != null && (mutableLiveData13 = syncDataViewModel6.get(i, MessageID.MSG_MATH_FFT_H_CENTER)) != null) {
            Context context6 = getContext();
            if (context6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData13.observe((LifecycleOwner) context6, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.11
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel7 = getSyncDataViewModel();
        if (syncDataViewModel7 != null && (mutableLiveData12 = syncDataViewModel7.get(i, MessageID.MSG_MATH_FFT_H_SPAN)) != null) {
            Context context7 = getContext();
            if (context7 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData12.observe((LifecycleOwner) context7, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.12
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel8 = getSyncDataViewModel();
        if (syncDataViewModel8 != null && (mutableLiveData11 = syncDataViewModel8.get(i, MessageID.MSG_MATH_FFT_H_START)) != null) {
            Context context8 = getContext();
            if (context8 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData11.observe((LifecycleOwner) context8, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.13
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel9 = getSyncDataViewModel();
        if (syncDataViewModel9 != null && (mutableLiveData10 = syncDataViewModel9.get(i, MessageID.MSG_MATH_FFT_START_ZOOM)) != null) {
            Context context9 = getContext();
            if (context9 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData10.observe((LifecycleOwner) context9, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.14
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel10 = getSyncDataViewModel();
        if (syncDataViewModel10 != null && (mutableLiveData9 = syncDataViewModel10.get(i, MessageID.MSG_MATH_FFT_SCALE_ZOOM)) != null) {
            Context context10 = getContext();
            if (context10 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData9.observe((LifecycleOwner) context10, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.15
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel11 = getSyncDataViewModel();
        if (syncDataViewModel11 != null && (mutableLiveData8 = syncDataViewModel11.get(i, MessageID.MSG_MATH_FFT_H_END)) != null) {
            Context context11 = getContext();
            if (context11 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData8.observe((LifecycleOwner) context11, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.16
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel12 = getSyncDataViewModel();
        if (syncDataViewModel12 != null && (mutableLiveData7 = syncDataViewModel12.get(i, MessageID.MSG_MATH_WAVE_TYPE)) != null) {
            Context context12 = getContext();
            if (context12 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData7.observe((LifecycleOwner) context12, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.17
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    if (MathGridRulerView.this.horizontalParam != null) {
                        MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                        mathGridRulerView.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView), MathGridRulerView.this.horizontalParam);
                    }
                }
            });
        }
        SyncDataViewModel syncDataViewModel13 = getSyncDataViewModel();
        if (syncDataViewModel13 != null && (mutableLiveData6 = syncDataViewModel13.get(i, MessageID.MSG_MATH_ANALOG_S32SCALE)) != null) {
            Context context13 = getContext();
            if (context13 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData6.observe((LifecycleOwner) context13, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.18
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                    mathGridRulerView.updateYRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel14 = getSyncDataViewModel();
        if (syncDataViewModel14 != null && (mutableLiveData5 = syncDataViewModel14.get(i, MessageID.MSG_MATH_VIEW_OFFSET)) != null) {
            Context context14 = getContext();
            if (context14 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData5.observe((LifecycleOwner) context14, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.19
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                    mathGridRulerView.updateYRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel15 = getSyncDataViewModel();
        if (syncDataViewModel15 != null && (mutableLiveData4 = syncDataViewModel15.get(i, MessageID.MSG_MATH_FFT_OFFSET)) != null) {
            Context context15 = getContext();
            if (context15 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData4.observe((LifecycleOwner) context15, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.20
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                    mathGridRulerView.updateYRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel16 = getSyncDataViewModel();
        if (syncDataViewModel16 != null && (mutableLiveData3 = syncDataViewModel16.get(i, MessageID.MSG_MATH_FFT_SCALE)) != null) {
            Context context16 = getContext();
            if (context16 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) context16, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.21
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                    mathGridRulerView.updateYRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel17 = getSyncDataViewModel();
        if (syncDataViewModel17 != null && (mutableLiveData2 = syncDataViewModel17.get(i, MessageID.MSG_MATH_UNIT)) != null) {
            Context context17 = getContext();
            if (context17 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context17, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.22
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                    mathGridRulerView.updateYRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView));
                }
            });
        }
        SyncDataViewModel syncDataViewModel18 = getSyncDataViewModel();
        if (syncDataViewModel18 == null || (mutableLiveData = syncDataViewModel18.get(i, MessageID.MSG_MATH_OPERATOR)) == null) {
            return;
        }
        Context context18 = getContext();
        if (context18 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context18, new Observer<Object>() { // from class: com.rigol.scope.views.grid.MathGridRulerView.23
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MathGridRulerView mathGridRulerView = MathGridRulerView.this;
                mathGridRulerView.updateYRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView));
                if (MathGridRulerView.this.horizontalParam != null) {
                    MathGridRulerView mathGridRulerView2 = MathGridRulerView.this;
                    mathGridRulerView2.updateXRuler(MathGridRulerView.access$getMathParam$p(mathGridRulerView2), MathGridRulerView.this.horizontalParam);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateYRuler(MathParam mathParam) {
        setRowContents(ViewUtil.getMathYRulers(mathParam));
        invalidate();
    }
}
