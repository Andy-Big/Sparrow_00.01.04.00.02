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
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ScaleNumUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.MathTag;
import com.rigol.scope.views.TagView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.BaseSurfaceView;
import com.rigol.scope.views.grid.MathGridRulerView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.window.Window;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001aH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/rigol/scope/views/window/MathWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "content", "Lcom/rigol/scope/views/window/WindowContent;", "getContext", "()Landroid/content/Context;", "gnd", "Lcom/rigol/scope/views/MathTag;", "mathParam", "Lcom/rigol/scope/data/MathParam;", "mathYRulerView", "Lcom/rigol/scope/views/grid/MathGridRulerView;", "surfaceView", "Lcom/rigol/scope/views/baseview/BaseSurfaceView;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateTitle", "", "updateWarningText", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MathWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final WindowContent content;
    private final Context context;
    private final MathTag gnd;
    private MathParam mathParam;
    private final MathGridRulerView mathYRulerView;
    private final BaseSurfaceView surfaceView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MathWindowHolder(Context context, final WindowParam windowParam) {
        super(windowParam);
        MutableLiveData<Object> mutableLiveData;
        LiveData<ArrayList<MathParam>> liveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        this.context = context;
        MathGridRulerView mathGridRulerView = new MathGridRulerView(this.context, windowParam.getServiceID(), null, 0);
        mathGridRulerView.setId(R.id.window_ruler_y);
        Unit unit = Unit.INSTANCE;
        this.mathYRulerView = mathGridRulerView;
        final BaseSurfaceView baseSurfaceView = new BaseSurfaceView(this.context);
        baseSurfaceView.setId(View.generateViewId());
        baseSurfaceView.setLayerType(1, null);
        baseSurfaceView.setOnScrollCalledInterval(3);
        baseSurfaceView.setOnScaleCalledInterval(10);
        baseSurfaceView.setParam(windowParam);
        baseSurfaceView.setGestureListener(new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f) > Math.abs(f2)) {
                    float f3 = BaseSurfaceView.this.getTotalScrollDistance()[0];
                    MathParam access$getMathParam$p = MathWindowHolder.access$getMathParam$p(this);
                    if (access$getMathParam$p != null && access$getMathParam$p.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        float fftEnd = (((float) (access$getMathParam$p.getFftEnd() - access$getMathParam$p.getFftStart())) * f3) / BaseSurfaceView.this.getWidth();
                        access$getMathParam$p.saveFftEnd(((float) access$getMathParam$p.getFftEnd()) + fftEnd);
                        access$getMathParam$p.saveFftStart(((float) access$getMathParam$p.getFftStart()) + fftEnd);
                    }
                } else {
                    float f4 = BaseSurfaceView.this.getTotalScrollDistance()[1];
                    MathParam access$getMathParam$p2 = MathWindowHolder.access$getMathParam$p(this);
                    if (access$getMathParam$p2 != null) {
                        if (access$getMathParam$p2.getOperator() == ServiceEnum.MathOperator.operator_and || access$getMathParam$p2.getOperator() == ServiceEnum.MathOperator.operator_or || access$getMathParam$p2.getOperator() == ServiceEnum.MathOperator.operator_not || access$getMathParam$p2.getOperator() == ServiceEnum.MathOperator.operator_xor) {
                            access$getMathParam$p2.saveLogicOffset(((float) access$getMathParam$p2.getLogicOffset()) + ((((float) (access$getMathParam$p2.getLogicScale() * 8)) * f4) / BaseSurfaceView.this.getHeight()));
                        } else if (access$getMathParam$p2.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                            access$getMathParam$p2.saveFftOffset(((float) access$getMathParam$p2.getFftOffset()) + ((((float) (access$getMathParam$p2.getFftScale() * 8)) * f4) / BaseSurfaceView.this.getHeight()));
                        } else {
                            access$getMathParam$p2.saveOffset(((float) access$getMathParam$p2.getOffset()) + ((((float) (access$getMathParam$p2.getScale() * 8)) * f4) / BaseSurfaceView.this.getHeight()));
                        }
                    }
                }
                return true;
            }
        });
        baseSurfaceView.setOnScaleGestureListener(new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$2
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector detector) {
                Intrinsics.checkNotNullParameter(detector, "detector");
                if (Math.abs(BaseSurfaceView.this.getTotalScaleSpan()[0]) > Math.abs(BaseSurfaceView.this.getTotalScaleSpan()[1])) {
                    float currentSpanX = detector.getCurrentSpanX() / detector.getPreviousSpanX();
                    MathParam access$getMathParam$p = MathWindowHolder.access$getMathParam$p(this);
                    if (access$getMathParam$p != null && access$getMathParam$p.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        long fftCenter = access$getMathParam$p.getFftCenter();
                        long j = 10;
                        long fftEnd = (access$getMathParam$p.getFftEnd() - access$getMathParam$p.getFftStart()) / j;
                        float f = 1;
                        if (currentSpanX < f) {
                            long plusNum = ScaleNumUtil.getPlusNum(fftEnd, 1.0f);
                            if (access$getMathParam$p.getFftStart() == 0) {
                                access$getMathParam$p.saveFftEnd(plusNum * j);
                            } else {
                                long j2 = plusNum * 5;
                                access$getMathParam$p.saveFftStart(fftCenter - j2);
                                access$getMathParam$p.saveFftEnd(fftCenter + j2);
                            }
                        } else if (currentSpanX > f) {
                            long minusNum = ScaleNumUtil.getMinusNum(fftEnd, 1.0f) * 5;
                            access$getMathParam$p.saveFftStart(fftCenter - minusNum);
                            access$getMathParam$p.saveFftEnd(fftCenter + minusNum);
                        }
                    }
                } else {
                    float currentSpanY = detector.getCurrentSpanY() / detector.getPreviousSpanY();
                    MathParam access$getMathParam$p2 = MathWindowHolder.access$getMathParam$p(this);
                    if (access$getMathParam$p2 != null && access$getMathParam$p2.getOperator() != ServiceEnum.MathOperator.operator_and && access$getMathParam$p2.getOperator() != ServiceEnum.MathOperator.operator_or && access$getMathParam$p2.getOperator() != ServiceEnum.MathOperator.operator_not && access$getMathParam$p2.getOperator() != ServiceEnum.MathOperator.operator_xor) {
                        if (access$getMathParam$p2.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                            float f2 = 1;
                            if (currentSpanY < f2) {
                                access$getMathParam$p2.saveFftScale(ScaleNumUtil.getPlusNum(access$getMathParam$p2.getFftScale(), 1.0f));
                            } else if (currentSpanY > f2) {
                                access$getMathParam$p2.saveFftScale(ScaleNumUtil.getMinusNum(access$getMathParam$p2.getFftScale(), 1.0f));
                            }
                        } else {
                            float f3 = 1;
                            if (currentSpanY < f3) {
                                access$getMathParam$p2.saveScale(ScaleNumUtil.getPlusNum(access$getMathParam$p2.getScale(), 1.0f));
                            } else if (currentSpanY > f3) {
                                access$getMathParam$p2.saveScale(ScaleNumUtil.getMinusNum(access$getMathParam$p2.getScale(), 1.0f));
                            }
                        }
                    }
                }
                return true;
            }
        });
        Unit unit2 = Unit.INSTANCE;
        this.surfaceView = baseSurfaceView;
        MathTag mathTag = new MathTag(this.context, null, windowParam.getServiceID());
        mathTag.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$3
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                MathParam access$getMathParam$p = MathWindowHolder.access$getMathParam$p(MathWindowHolder.this);
                if (access$getMathParam$p != null) {
                    if (access$getMathParam$p.getOperator() == ServiceEnum.MathOperator.operator_and || access$getMathParam$p.getOperator() == ServiceEnum.MathOperator.operator_or || access$getMathParam$p.getOperator() == ServiceEnum.MathOperator.operator_not || access$getMathParam$p.getOperator() == ServiceEnum.MathOperator.operator_xor) {
                        access$getMathParam$p.saveLogicOffset(((float) access$getMathParam$p.getLogicOffset()) - (((i2 / MathWindowHolder.access$getContent$p(MathWindowHolder.this).getHeight()) * ((float) access$getMathParam$p.getLogicScale())) * 8));
                    } else if (access$getMathParam$p.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        access$getMathParam$p.saveFftOffset(((float) access$getMathParam$p.getFftOffset()) - (((i2 / MathWindowHolder.access$getContent$p(MathWindowHolder.this).getHeight()) * ((float) access$getMathParam$p.getFftScale())) * 8));
                    } else {
                        access$getMathParam$p.saveOffset(((float) access$getMathParam$p.getOffset()) - (((i2 / MathWindowHolder.access$getContent$p(MathWindowHolder.this).getHeight()) * ((float) access$getMathParam$p.getScale())) * 8));
                    }
                    FunctionManager.getInstance().setFlexKnobEnum(ServiceEnum.Function.FUN_MATH, windowParam.getServiceID() - 17, false);
                }
            }
        });
        Unit unit3 = Unit.INSTANCE;
        this.gnd = mathTag;
        WindowContent windowContent = new WindowContent(this.context);
        windowContent.setWindowParam(windowParam);
        windowContent.addView(this.mathYRulerView);
        ConstraintSet constraintSet = new ConstraintSet();
        WindowContent windowContent2 = windowContent;
        constraintSet.clone(windowContent2);
        constraintSet.connect(this.mathYRulerView.getId(), 6, 0, 6);
        constraintSet.connect(this.mathYRulerView.getId(), 7, 0, 7);
        constraintSet.connect(this.mathYRulerView.getId(), 3, 0, 3);
        constraintSet.applyTo(windowContent2);
        windowContent.addView(this.surfaceView);
        windowContent.addCursorTags();
        windowContent.addCursorShadowTags();
        windowContent.bindCursor();
        windowContent.bindMeasureCursor();
        windowContent.addIndicators();
        windowContent.bindIndicator();
        windowContent.bindRef();
        windowContent.addView(this.gnd, -2, 35);
        ViewUtil.applyToTopAndLeft(new ConstraintSet(), windowContent2, this.gnd);
        Unit unit4 = Unit.INSTANCE;
        this.content = windowContent;
        final WindowSimpleBinding inflate = WindowSimpleBinding.inflate(LayoutInflater.from(this.context));
        Intrinsics.checkNotNullExpressionValue(inflate, "WindowSimpleBinding.infl…utInflater.from(context))");
        inflate.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$4
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
        TextView title = inflate.title;
        Intrinsics.checkNotNullExpressionValue(title, "title");
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_MATH.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…MATH.value1\n            )");
        title.setText(mappingObject.getStr());
        inflate.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WindowHolderManager.getInstance().remove(MathWindowHolder.this);
            }
        });
        inflate.windowLayout.setOnSizeChangedCallback(new Window.OnSizeChangedCallback() { // from class: com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$6
            @Override // com.rigol.scope.views.window.Window.OnSizeChangedCallback
            public void onSizeChanged(int i, int i2, int i3, int i4) {
                if (i2 != i4) {
                    View findViewWithTag = WindowSimpleBinding.this.windowLayout.findViewWithTag(Integer.valueOf(windowParam.getServiceID()));
                    Intrinsics.checkNotNullExpressionValue(findViewWithTag, "windowLayout.findViewWit…ag(windowParam.serviceID)");
                    final MathTag mathTag2 = (MathTag) findViewWithTag;
                    mathTag2.postDelayed(new Runnable() { // from class: com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$6.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            mathTag2.setPosition();
                            MathWindowHolder.access$getContent$p(this).updateCursorA_B();
                        }
                    }, 200L);
                }
            }
        });
        inflate.contentLayout.addView(this.content, -1, -1);
        Unit unit5 = Unit.INSTANCE;
        this.binding = inflate;
        updateWarningText();
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        if (mathViewModel != null && (liveData = mathViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData.observe((LifecycleOwner) topActivity, new AnonymousClass1(windowParam));
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(windowParam.getServiceID(), MessageID.MSG_WINDOW_TITLE)) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity2, new Observer<Object>() { // from class: com.rigol.scope.views.window.MathWindowHolder.2
                {
                    MathWindowHolder.this = this;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MathWindowHolder.this.updateTitle();
                }
            });
        }
        LiveData<SharedParam> liveData2 = ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData();
        Activity topActivity3 = ActivityUtils.getTopActivity();
        if (topActivity3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        liveData2.observe((LifecycleOwner) topActivity3, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.MathWindowHolder.3
            {
                MathWindowHolder.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(final SharedParam sharedParam) {
                sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.MathWindowHolder.3.1
                    {
                        AnonymousClass3.this = this;
                    }

                    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                    public void onPropertyChanged(Observable observable, int i) {
                        if (sharedParam.getShowResultBar()) {
                            MathWindowHolder.this.mathYRulerView.setAbout(false);
                            MathWindowHolder.this.mathYRulerView.invalidate();
                            return;
                        }
                        MathWindowHolder.this.mathYRulerView.setAbout(true);
                        MathWindowHolder.this.mathYRulerView.invalidate();
                    }
                });
            }
        });
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$3.onMove(int, int, int, int):void, com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$6.1.run():void] */
    public static final /* synthetic */ WindowContent access$getContent$p(MathWindowHolder mathWindowHolder) {
        return mathWindowHolder.content;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$1.onScroll(android.view.MotionEvent, android.view.MotionEvent, float, float):boolean, com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$2.onScale(android.view.ScaleGestureDetector):boolean, com.rigol.scope.views.window.MathWindowHolder$$special$$inlined$apply$lambda$3.onMove(int, int, int, int):void, com.rigol.scope.views.window.MathWindowHolder$1$$special$$inlined$let$lambda$1.onChanged(java.lang.Boolean):void] */
    public static final /* synthetic */ MathParam access$getMathParam$p(MathWindowHolder mathWindowHolder) {
        return mathWindowHolder.mathParam;
    }

    public final Context getContext() {
        return this.context;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    /* compiled from: WindowHolder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u000120\u0010\u0002\u001a,\u0012\u0004\u0012\u00020\u0004 \u0006*\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005H\n¢\u0006\u0002\b\u0007"}, d2 = {"<anonymous>", "", "t", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/MathParam;", "Lkotlin/collections/ArrayList;", "kotlin.jvm.PlatformType", "onChanged"}, k = 3, mv = {1, 4, 1})
    /* renamed from: com.rigol.scope.views.window.MathWindowHolder$1 */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1<T> implements Observer<ArrayList<MathParam>> {
        final /* synthetic */ WindowParam $windowParam;

        AnonymousClass1(WindowParam windowParam) {
            MathWindowHolder.this = r1;
            this.$windowParam = windowParam;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(ArrayList<MathParam> arrayList) {
            MutableLiveData<Boolean> mutableLiveData;
            int serviceID;
            if (arrayList != null && this.$windowParam.getServiceID() - 17 >= 0 && serviceID < arrayList.size()) {
                MathWindowHolder.this.mathParam = arrayList.get(serviceID);
            }
            MathWindowHolder.this.updateTitle();
            MathParam mathParam = MathWindowHolder.this.mathParam;
            if (mathParam != null) {
                int serviceId = mathParam.getServiceId();
                UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
                if (updateUIViewModel == null || (mutableLiveData = updateUIViewModel.get(serviceId, MessageID.MSG_MATH_INPUT_VALID)) == null) {
                    return;
                }
                Activity topActivity = ActivityUtils.getTopActivity();
                if (topActivity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData.observe((LifecycleOwner) topActivity, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.MathWindowHolder$1$$special$$inlined$let$lambda$1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Boolean bool) {
                        API api = API.getInstance();
                        MathParam access$getMathParam$p = MathWindowHolder.access$getMathParam$p(MathWindowHolder.this);
                        Integer valueOf = access$getMathParam$p != null ? Integer.valueOf(access$getMathParam$p.getServiceId()) : null;
                        Intrinsics.checkNotNull(valueOf);
                        boolean UI_QueryBool = api.UI_QueryBool(valueOf.intValue(), MessageID.MSG_MATH_INPUT_VALID);
                        TextView textView = MathWindowHolder.this.getBinding().warning;
                        Intrinsics.checkNotNullExpressionValue(textView, "binding.warning");
                        textView.setVisibility(UI_QueryBool ? 8 : 0);
                    }
                });
            }
        }
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        MathParam mathParam = this.mathParam;
        if (mathParam != null) {
            this.binding.title.setTextColor(ColorUtil.getColor(this.context, mathParam.getServiceId()));
            TextView textView = this.binding.title;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
            textView.setText(mathParam.getWindowTitleString());
        }
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateWarningText() {
        super.updateWarningText();
        this.binding.warning.setText(R.string.msg_math_input_valid);
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }
}
