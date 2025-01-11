package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ScaleNumUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BaseSurfaceView;
import com.rigol.scope.views.baseview.MarkerView;
import com.rigol.scope.views.grid.RtsaGridRulerView;
import com.rigol.scope.views.rtsa.RtsaPopupView;
import com.rigol.scope.views.window.FFTWindowHolder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/rigol/scope/views/window/FFTWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "content", "Lcom/rigol/scope/views/window/WindowContent;", "getContext", "()Landroid/content/Context;", "fftParam", "Lcom/rigol/scope/data/FftParam;", "gridRulerView", "Lcom/rigol/scope/views/grid/RtsaGridRulerView;", "horizontalParam", "Lcom/rigol/scope/data/HorizontalParam;", "surfaceView", "Lcom/rigol/scope/views/baseview/BaseSurfaceView;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateTitle", "", "updateWarningText", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class FFTWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final WindowContent content;
    private final Context context;
    private FftParam fftParam;
    private final RtsaGridRulerView gridRulerView;
    private HorizontalParam horizontalParam;
    private final BaseSurfaceView surfaceView;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServiceEnum.HoriTimeMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ServiceEnum.HoriTimeMode.Horizontal_ROLL.ordinal()] = 1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FFTWindowHolder(Context context, final WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Object> mutableLiveData;
        LiveData<HorizontalParam> liveData;
        LiveData<FftParam> liveData2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.context = context;
        RtsaGridRulerView rtsaGridRulerView = new RtsaGridRulerView(this.context, null, 0, 6, null);
        rtsaGridRulerView.setId(R.id.window_grid_line);
        Unit unit = Unit.INSTANCE;
        this.gridRulerView = rtsaGridRulerView;
        final BaseSurfaceView baseSurfaceView = new BaseSurfaceView(this.context);
        baseSurfaceView.setId(View.generateViewId());
        baseSurfaceView.setOnScrollCalledInterval(3);
        baseSurfaceView.setOnScaleCalledInterval(10);
        baseSurfaceView.setParam(windowParam);
        baseSurfaceView.setGestureListener(new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                HorizontalParam access$getHorizontalParam$p = FFTWindowHolder.access$getHorizontalParam$p(this);
                return (access$getHorizontalParam$p != null ? access$getHorizontalParam$p.getRunStop() : null) != ServiceEnum.ControlAction.Control_Stop;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f) > Math.abs(f2)) {
                    float f3 = BaseSurfaceView.this.getTotalScrollDistance()[0];
                    FftParam access$getFftParam$p = FFTWindowHolder.access$getFftParam$p(this);
                    if (access$getFftParam$p != null) {
                        float end = (((float) (access$getFftParam$p.getEnd() - access$getFftParam$p.getStart())) * f3) / BaseSurfaceView.this.getWidth();
                        access$getFftParam$p.saveEnd(((float) access$getFftParam$p.getEnd()) + end);
                        access$getFftParam$p.saveStart(((float) access$getFftParam$p.getStart()) + end);
                    }
                } else {
                    float f4 = BaseSurfaceView.this.getTotalScrollDistance()[1];
                    FftParam access$getFftParam$p2 = FFTWindowHolder.access$getFftParam$p(this);
                    if (access$getFftParam$p2 != null) {
                        float scale = (((float) (access$getFftParam$p2.getScale() * 10)) * f4) / BaseSurfaceView.this.getHeight();
                        if (access$getFftParam$p2.getUnit() == ServiceEnum.Unit.Unit_dbm || access$getFftParam$p2.getUnit() == ServiceEnum.Unit.Unit_dBmV || access$getFftParam$p2.getUnit() == ServiceEnum.Unit.Unit_dBuV) {
                            access$getFftParam$p2.saveRefLevel(access$getFftParam$p2.getRefLevel() - scale);
                        }
                    }
                }
                return true;
            }
        });
        baseSurfaceView.setOnScaleGestureListener(new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$apply$lambda$2
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector detector) {
                Intrinsics.checkNotNullParameter(detector, "detector");
                HorizontalParam access$getHorizontalParam$p = FFTWindowHolder.access$getHorizontalParam$p(this);
                if ((access$getHorizontalParam$p != null ? access$getHorizontalParam$p.getRunStop() : null) == ServiceEnum.ControlAction.Control_Stop) {
                    return true;
                }
                if (Math.abs(BaseSurfaceView.this.getTotalScaleSpan()[0]) > Math.abs(BaseSurfaceView.this.getTotalScaleSpan()[1])) {
                    float currentSpanX = detector.getCurrentSpanX() / detector.getPreviousSpanX();
                    FftParam access$getFftParam$p = FFTWindowHolder.access$getFftParam$p(this);
                    if (access$getFftParam$p != null) {
                        long center = access$getFftParam$p.getCenter();
                        long j = 10;
                        long end = (access$getFftParam$p.getEnd() - access$getFftParam$p.getStart()) / j;
                        float f = 1;
                        if (currentSpanX < f) {
                            long plusNum = ScaleNumUtil.getPlusNum(end, 1.0f);
                            if (access$getFftParam$p.getStart() == 0) {
                                access$getFftParam$p.saveEnd(plusNum * j);
                            } else {
                                long j2 = plusNum * 5;
                                access$getFftParam$p.saveStart(center - j2);
                                access$getFftParam$p.saveEnd(center + j2);
                            }
                        } else if (currentSpanX > f) {
                            long minusNum = ScaleNumUtil.getMinusNum(end, 1.0f) * 5;
                            access$getFftParam$p.saveStart(center - minusNum);
                            access$getFftParam$p.saveEnd(center + minusNum);
                        }
                    }
                } else {
                    float currentSpanY = detector.getCurrentSpanY() / detector.getPreviousSpanY();
                    FftParam access$getFftParam$p2 = FFTWindowHolder.access$getFftParam$p(this);
                    if (access$getFftParam$p2 != null && access$getFftParam$p2.getUnit() != ServiceEnum.Unit.Unit_V && access$getFftParam$p2.getUnit() != ServiceEnum.Unit.Unit_W) {
                        float f2 = 1;
                        if (currentSpanY < f2) {
                            access$getFftParam$p2.saveScale(ScaleNumUtil.getPlusNum(access$getFftParam$p2.getScale(), 1.0f));
                        } else if (currentSpanY > f2) {
                            access$getFftParam$p2.saveScale(ScaleNumUtil.getMinusNum(access$getFftParam$p2.getScale(), 1.0f));
                        }
                    }
                }
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                HorizontalParam access$getHorizontalParam$p = FFTWindowHolder.access$getHorizontalParam$p(this);
                return (access$getHorizontalParam$p != null ? access$getHorizontalParam$p.getRunStop() : null) != ServiceEnum.ControlAction.Control_Stop;
            }
        });
        Unit unit2 = Unit.INSTANCE;
        this.surfaceView = baseSurfaceView;
        WindowContent windowContent = new WindowContent(this.context);
        windowContent.setWindowParam(windowParam);
        windowContent.addView(this.surfaceView);
        windowContent.addView(this.gridRulerView);
        for (int i = 1; i <= 8; i++) {
            MarkerView markerView = new MarkerView(windowContent.getContext(), null, ServiceEnum.getRtsaMarkerFromValue1(i));
            markerView.setId(View.generateViewId());
            MarkerView markerView2 = markerView;
            windowContent.addView(markerView2, 100, 100);
            ViewUtil.applyToTopAndLeft(new ConstraintSet(), windowContent, markerView2);
        }
        Unit unit3 = Unit.INSTANCE;
        this.content = windowContent;
        WindowSimpleBinding inflate = WindowSimpleBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "WindowSimpleBinding.infl…utInflater.from(context))");
        TextView title = inflate.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_FFT.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…_FFT.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$apply$lambda$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(FFTWindowHolder.this);
            }
        });
        inflate.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.FFTWindowHolder$binding$1$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PopupViewManager.getInstance().toggle(RtsaPopupView.class);
            }
        });
        inflate.contentLayout.addView(this.content, -1, -1);
        Unit unit4 = Unit.INSTANCE;
        this.binding = inflate;
        updateWarningText();
        FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
        if (fftViewModel != null && (liveData2 = fftViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData2.observe((LifecycleOwner) topActivity, new Observer<FftParam>() { // from class: com.rigol.scope.views.window.FFTWindowHolder.1
                    {
                        FFTWindowHolder.this = this;
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(FftParam fftParam) {
                        FFTWindowHolder.this.fftParam = fftParam;
                        FFTWindowHolder.this.updateTitle();
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null && (liveData = horizontalViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 != null) {
                liveData.observe((LifecycleOwner) topActivity2, new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.window.FFTWindowHolder.2
                    {
                        FFTWindowHolder.this = this;
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HorizontalParam horizontalParam) {
                        FFTWindowHolder.this.horizontalParam = horizontalParam;
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(50, MessageID.MSG_WINDOW_TITLE)) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity3, new Observer<Object>() { // from class: com.rigol.scope.views.window.FFTWindowHolder.3
                {
                    FFTWindowHolder.this = this;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FFTWindowHolder.this.updateTitle();
                }
            });
        }
        SyncDataViewModel syncDataViewModel2 = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel2 != null) {
            MutableLiveData<Object> mutableLiveData2 = syncDataViewModel2.get(50, MessageID.MSG_WINDOW_TITLE);
            if (mutableLiveData2 != null) {
                Activity topActivity4 = ActivityUtils.getTopActivity();
                if (topActivity4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData2.observe((LifecycleOwner) topActivity4, new Observer<Object>() { // from class: com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$let$lambda$1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        FFTWindowHolder.this.updateTitle();
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData3 = syncDataViewModel2.get(10, MessageID.MSG_HOR_UI_TIME_VIEW_MODE);
            if (mutableLiveData3 != null) {
                Activity topActivity5 = ActivityUtils.getTopActivity();
                if (topActivity5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData3.observe((LifecycleOwner) topActivity5, new Observer<Object>() { // from class: com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$let$lambda$2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        HorizontalParam access$getHorizontalParam$p = FFTWindowHolder.access$getHorizontalParam$p(FFTWindowHolder.this);
                        if (access$getHorizontalParam$p != null) {
                            if (FFTWindowHolder.WhenMappings.$EnumSwitchMapping$0[access$getHorizontalParam$p.getTimeMode().ordinal()] == 1) {
                                TextView textView = FFTWindowHolder.this.getBinding().warning;
                                Intrinsics.checkNotNullExpressionValue(textView, "binding.warning");
                                textView.setVisibility(0);
                                return;
                            }
                            TextView textView2 = FFTWindowHolder.this.getBinding().warning;
                            Intrinsics.checkNotNullExpressionValue(textView2, "binding.warning");
                            textView2.setVisibility(8);
                        }
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$apply$lambda$1.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean, com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$apply$lambda$2.onScale(android.view.ScaleGestureDetector):boolean] */
    public static final /* synthetic */ FftParam access$getFftParam$p(FFTWindowHolder fFTWindowHolder) {
        return fFTWindowHolder.fftParam;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$apply$lambda$1.onDown(android.view.MotionEvent):boolean, com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$apply$lambda$2.onScale(android.view.ScaleGestureDetector):boolean, com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$apply$lambda$2.onScaleBegin(android.view.ScaleGestureDetector):boolean, com.rigol.scope.views.window.FFTWindowHolder$$special$$inlined$let$lambda$2.onChanged(java.lang.Object):void] */
    public static final /* synthetic */ HorizontalParam access$getHorizontalParam$p(FFTWindowHolder fFTWindowHolder) {
        return fFTWindowHolder.horizontalParam;
    }

    public final Context getContext() {
        return this.context;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        FftParam fftParam = this.fftParam;
        if (fftParam != null) {
            this.binding.title.setTextColor(ColorUtil.getColor(this.context, fftParam.getServiceId()));
            TextView textView = this.binding.title;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
            textView.setText(fftParam.getTitle());
        }
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateWarningText() {
        super.updateWarningText();
        this.binding.warning.setText(R.string.inf_rtsa_ng);
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }
}
