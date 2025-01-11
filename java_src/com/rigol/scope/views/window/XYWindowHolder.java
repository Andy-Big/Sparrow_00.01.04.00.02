package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
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
import com.rigol.scope.data.BaseProperty;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.databinding.WindowSimpleBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.XYViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.BaseSurfaceView;
import com.rigol.scope.views.grid.XYGridRulderView;
import com.rigol.scope.views.window.Window;
import com.rigol.scope.views.xy.XYPopupView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WindowHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001c\u001a\u00020\u001aH\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/rigol/scope/views/window/XYWindowHolder;", "Lcom/rigol/scope/views/window/WindowHolder;", "context", "Landroid/content/Context;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "(Landroid/content/Context;Lcom/rigol/scope/data/WindowParam;)V", "binding", "Lcom/rigol/scope/databinding/WindowSimpleBinding;", "getBinding", "()Lcom/rigol/scope/databinding/WindowSimpleBinding;", "content", "Lcom/rigol/scope/views/window/WindowContent;", "getContent", "()Lcom/rigol/scope/views/window/WindowContent;", "gridRulerView", "Lcom/rigol/scope/views/grid/XYGridRulderView;", "horizontalParam", "Lcom/rigol/scope/data/HorizontalParam;", "surfaceView", "Lcom/rigol/scope/views/baseview/BaseSurfaceView;", "xyParam", "Lcom/rigol/scope/data/XYParam;", "getWindow", "Lcom/rigol/scope/views/window/Window;", "updateTips", "", "updateTitle", "updateWarningText", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class XYWindowHolder extends WindowHolder {
    private final WindowSimpleBinding binding;
    private final WindowContent content;
    private final XYGridRulderView gridRulerView;
    private HorizontalParam horizontalParam;
    private final BaseSurfaceView surfaceView;
    private XYParam xyParam;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public XYWindowHolder(Context context, final WindowParam windowParam) {
        super(windowParam);
        LiveData<XYParam> liveData;
        BaseProperty<Integer> sourceC;
        BaseProperty<Integer> sourceB;
        BaseProperty<Integer> sourceA;
        LiveData<HorizontalParam> liveData2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(windowParam, "windowParam");
        XYGridRulderView xYGridRulderView = new XYGridRulderView(context, null, 0, windowParam);
        xYGridRulderView.setId(R.id.window_grid_line);
        Unit unit = Unit.INSTANCE;
        this.gridRulerView = xYGridRulderView;
        BaseSurfaceView baseSurfaceView = new BaseSurfaceView(context);
        baseSurfaceView.setId(View.generateViewId());
        baseSurfaceView.setParam(windowParam);
        Unit unit2 = Unit.INSTANCE;
        this.surfaceView = baseSurfaceView;
        WindowContent windowContent = new WindowContent(context);
        windowContent.setWindowParam(windowParam);
        windowContent.addView(this.surfaceView);
        windowContent.addView(this.gridRulerView);
        windowContent.addCursorTags();
        windowContent.bindCursor();
        windowContent.bindMeasureCursor();
        Unit unit3 = Unit.INSTANCE;
        this.content = windowContent;
        WindowSimpleBinding inflate = WindowSimpleBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "WindowSimpleBinding.infl…utInflater.from(context))");
        inflate.windowClose.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveData<CursorResultParam> liveData3;
                CursorResultParam value;
                WindowHolderManager.getInstance().remove(XYWindowHolder.this);
                FunctionManager.getInstance().xySwitch = false;
                MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), true);
                FunctionManager.getInstance().setUltraEnable(true);
                ViewUtil.setState(windowParam.getSource1(), windowParam.getSource2(), false);
                ServiceEnum.CursorMode cursorMode = null;
                UnitFormat.format = null;
                CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
                if (cursorViewModel != null && (liveData3 = cursorViewModel.getLiveData()) != null && (value = liveData3.getValue()) != null) {
                    cursorMode = value.getCursorMode();
                }
                if (cursorMode == ServiceEnum.CursorMode.cursor_mode_xy && FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                    FunctionManager.getInstance().handleItemClick(ServiceEnum.Function.FUN_CURSOR);
                }
            }
        });
        inflate.windowSetting.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BasePopupView basePopupView = PopupViewManager.getInstance().get(XYPopupView.class);
                if (basePopupView instanceof XYPopupView) {
                    XYPopupView xYPopupView = (XYPopupView) basePopupView;
                    if (xYPopupView.isShowing()) {
                        basePopupView.dismiss();
                        return;
                    }
                    xYPopupView.setWindowParam(windowParam);
                    basePopupView.show();
                }
            }
        });
        inflate.contentLayout.addView(this.content, -1, -1);
        Unit unit4 = Unit.INSTANCE;
        this.binding = inflate;
        updateWarningText();
        ViewUtil.setState(windowParam.getSource1(), windowParam.getSource2(), windowParam.getSource3(), true);
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel != null && (liveData2 = horizontalViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData2.observe((LifecycleOwner) topActivity, new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.window.XYWindowHolder.1
                    {
                        XYWindowHolder.this = this;
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HorizontalParam horizontalParam) {
                        XYWindowHolder.this.horizontalParam = horizontalParam;
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        XYViewModel xYViewModel = (XYViewModel) ContextUtil.getAppViewModel(XYViewModel.class);
        if (xYViewModel != null && (liveData = xYViewModel.getLiveData()) != null) {
            XYParam value = liveData.getValue();
            if (value != null && (sourceA = value.getSourceA()) != null) {
                sourceA.setValue(Integer.valueOf(windowParam.getSource1().value1));
            }
            XYParam value2 = liveData.getValue();
            if (value2 != null && (sourceB = value2.getSourceB()) != null) {
                sourceB.setValue(Integer.valueOf(windowParam.getSource2().value1));
            }
            XYParam value3 = liveData.getValue();
            if (value3 != null && (sourceC = value3.getSourceC()) != null) {
                sourceC.setValue(Integer.valueOf(windowParam.getSource3().value1));
            }
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 != null) {
                liveData.observe((LifecycleOwner) topActivity2, new Observer<XYParam>() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(XYParam xYParam) {
                        XYWindowHolder.access$setXyParam$p(XYWindowHolder.this, xYParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            MutableLiveData<Object> mutableLiveData = syncDataViewModel.get(10, MessageID.MSG_HOR_UI_TIME_VIEW_MODE);
            if (mutableLiveData != null) {
                Activity topActivity3 = ActivityUtils.getTopActivity();
                if (topActivity3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData.observe((LifecycleOwner) topActivity3, new Observer<Object>() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$2
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        if (XYWindowHolder.access$getHorizontalParam$p(XYWindowHolder.this) != null) {
                            XYWindowHolder.access$updateTips(XYWindowHolder.this);
                        }
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData2 = syncDataViewModel.get(10, MessageID.MSG_HOR_MAIN_SCALE);
            if (mutableLiveData2 != null) {
                Activity topActivity4 = ActivityUtils.getTopActivity();
                if (topActivity4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData2.observe((LifecycleOwner) topActivity4, new Observer<Object>() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$3
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        if (XYWindowHolder.access$getHorizontalParam$p(XYWindowHolder.this) != null) {
                            XYWindowHolder.access$updateTips(XYWindowHolder.this);
                        }
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData3 = syncDataViewModel.get(40, MessageID.MSG_XY_USABLE);
            if (mutableLiveData3 != null) {
                Activity topActivity5 = ActivityUtils.getTopActivity();
                if (topActivity5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData3.observe((LifecycleOwner) topActivity5, new Observer<Object>() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$4
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        if (XYWindowHolder.access$getHorizontalParam$p(XYWindowHolder.this) != null) {
                            XYWindowHolder.access$updateTips(XYWindowHolder.this);
                        }
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData4 = syncDataViewModel.get(40, MessageID.MSG_XY_SOURCE_A);
            if (mutableLiveData4 != null) {
                Activity topActivity6 = ActivityUtils.getTopActivity();
                if (topActivity6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData4.observe((LifecycleOwner) topActivity6, new Observer<Object>() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$5
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        XYParam access$getXyParam$p = XYWindowHolder.access$getXyParam$p(XYWindowHolder.this);
                        if (access$getXyParam$p != null) {
                            WindowParam windowParam2 = windowParam;
                            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(access$getXyParam$p.getSourceA().getValue().intValue());
                            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromValue1(itxy.sourceA.value)");
                            windowParam2.setSource1(chanFromValue1);
                            XYWindowHolder.this.updateTitle();
                            XYWindowHolder.access$getGridRulerView$p(XYWindowHolder.this).updateColumnRulers(windowParam.getSource1());
                        }
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData5 = syncDataViewModel.get(40, MessageID.MSG_XY_SOURCE_B);
            if (mutableLiveData5 != null) {
                Activity topActivity7 = ActivityUtils.getTopActivity();
                if (topActivity7 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData5.observe((LifecycleOwner) topActivity7, new Observer<Object>() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$6
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        XYParam access$getXyParam$p = XYWindowHolder.access$getXyParam$p(XYWindowHolder.this);
                        if (access$getXyParam$p != null) {
                            WindowParam windowParam2 = windowParam;
                            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(access$getXyParam$p.getSourceB().getValue().intValue());
                            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromValue1(itxy.sourceB.value)");
                            windowParam2.setSource2(chanFromValue1);
                            XYWindowHolder.this.updateTitle();
                            XYWindowHolder.access$getGridRulerView$p(XYWindowHolder.this).updateRowRulers(windowParam.getSource2());
                        }
                    }
                });
            }
            MutableLiveData<Object> mutableLiveData6 = syncDataViewModel.get(40, MessageID.MSG_XY_SOURCE_C);
            if (mutableLiveData6 != null) {
                Activity topActivity8 = ActivityUtils.getTopActivity();
                if (topActivity8 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData6.observe((LifecycleOwner) topActivity8, new Observer<Object>() { // from class: com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$7
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        XYParam access$getXyParam$p = XYWindowHolder.access$getXyParam$p(XYWindowHolder.this);
                        if (access$getXyParam$p != null) {
                            WindowParam windowParam2 = windowParam;
                            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(access$getXyParam$p.getSourceC().getValue().intValue());
                            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromValue1(itxy.sourceC.value)");
                            windowParam2.setSource3(chanFromValue1);
                            XYWindowHolder.this.updateTitle();
                            XYWindowHolder.access$getGridRulerView$p(XYWindowHolder.this).updateRowRulers(windowParam.getSource3());
                        }
                    }
                });
            }
        }
        MutableLiveData<Object> mutableLiveData7 = ((SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class)).get(40, MessageID.MSG_XY_USABLE);
        Activity topActivity9 = ActivityUtils.getTopActivity();
        if (topActivity9 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData7.observe((LifecycleOwner) topActivity9, new Observer<Object>() { // from class: com.rigol.scope.views.window.XYWindowHolder.4
            {
                XYWindowHolder.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                if (XYWindowHolder.this.horizontalParam != null) {
                    XYWindowHolder.this.updateTips();
                }
            }
        });
        LiveData<SharedParam> liveData3 = ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData();
        Activity topActivity10 = ActivityUtils.getTopActivity();
        if (topActivity10 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        liveData3.observe((LifecycleOwner) topActivity10, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.XYWindowHolder.5
            {
                XYWindowHolder.this = this;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(final SharedParam sharedParam) {
                sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.XYWindowHolder.5.1
                    {
                        AnonymousClass5.this = this;
                    }

                    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                    public void onPropertyChanged(Observable observable, int i) {
                        if (sharedParam.getShowResultBar()) {
                            XYWindowHolder.this.gridRulerView.setAbout(false);
                            XYWindowHolder.this.gridRulerView.invalidate();
                            return;
                        }
                        XYWindowHolder.this.gridRulerView.setAbout(true);
                        XYWindowHolder.this.gridRulerView.invalidate();
                    }
                });
            }
        });
        updateTitle();
        this.binding.windowLayout.setOnSizeChangedCallback(new Window.OnSizeChangedCallback() { // from class: com.rigol.scope.views.window.XYWindowHolder.6
            @Override // com.rigol.scope.views.window.Window.OnSizeChangedCallback
            public void onSizeChanged(int i, int i2, int i3, int i4) {
            }
        });
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$5.onChanged(java.lang.Object):void, com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$6.onChanged(java.lang.Object):void, com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$7.onChanged(java.lang.Object):void] */
    public static final /* synthetic */ XYGridRulderView access$getGridRulerView$p(XYWindowHolder xYWindowHolder) {
        return xYWindowHolder.gridRulerView;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$2.onChanged(java.lang.Object):void, com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$3.onChanged(java.lang.Object):void, com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$4.onChanged(java.lang.Object):void] */
    public static final /* synthetic */ HorizontalParam access$getHorizontalParam$p(XYWindowHolder xYWindowHolder) {
        return xYWindowHolder.horizontalParam;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$5.onChanged(java.lang.Object):void, com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$6.onChanged(java.lang.Object):void, com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$7.onChanged(java.lang.Object):void] */
    public static final /* synthetic */ XYParam access$getXyParam$p(XYWindowHolder xYWindowHolder) {
        return xYWindowHolder.xyParam;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$1.onChanged(com.rigol.scope.data.XYParam):void] */
    public static final /* synthetic */ void access$setXyParam$p(XYWindowHolder xYWindowHolder, XYParam xYParam) {
        xYWindowHolder.xyParam = xYParam;
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$2.onChanged(java.lang.Object):void, com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$3.onChanged(java.lang.Object):void, com.rigol.scope.views.window.XYWindowHolder$$special$$inlined$let$lambda$4.onChanged(java.lang.Object):void] */
    public static final /* synthetic */ void access$updateTips(XYWindowHolder xYWindowHolder) {
        xYWindowHolder.updateTips();
    }

    public final WindowContent getContent() {
        return this.content;
    }

    public final WindowSimpleBinding getBinding() {
        return this.binding;
    }

    public final void updateTips() {
        if (API.getInstance().UI_QueryBool(40, MessageID.MSG_XY_USABLE)) {
            TextView textView = this.binding.warning;
            Intrinsics.checkNotNullExpressionValue(textView, "binding.warning");
            textView.setVisibility(8);
            return;
        }
        TextView textView2 = this.binding.warning;
        Intrinsics.checkNotNullExpressionValue(textView2, "binding.warning");
        textView2.setVisibility(0);
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateTitle() {
        TextView textView = this.binding.title;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.title");
        StringBuilder sb = new StringBuilder();
        MappingObject mappingObject = ViewUtil.getMappingObject(R.array.window_type_list, ServiceEnum.WindowType.WIN_XY.value1);
        Intrinsics.checkNotNullExpressionValue(mappingObject, "ViewUtil.getMappingObjec…e.WIN_XY.value1\n        )");
        sb.append(mappingObject.getStr());
        sb.append("(CH");
        sb.append(getWindowParam().getSource1().value1);
        sb.append(", CH");
        sb.append(getWindowParam().getSource2().value1);
        sb.append(')');
        textView.setText(sb.toString());
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public void updateWarningText() {
        super.updateWarningText();
        this.binding.warning.setText(R.string.inf_xy_ng);
    }

    @Override // com.rigol.scope.views.window.WindowHolder
    public Window getWindow() {
        Window window = this.binding.windowLayout;
        Intrinsics.checkNotNullExpressionValue(window, "binding.windowLayout");
        return window;
    }
}
