package com.rigol.scope.views.wave;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.DragEvent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.utilities.BodeCursorView;
import com.rigol.scope.utilities.BodeView;
import com.rigol.scope.utilities.BodeViewLien;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.OffsetUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.LaViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.ZoomWaveformView;
import com.rigol.scope.views.baseview.BaseSurfaceView;
import com.rigol.scope.views.baseview.BaseWaveformView;
import com.rigol.scope.views.baseview.MainWaveformView;
import com.rigol.scope.views.bode.BodePopupWin;
import com.rigol.scope.views.display.DisplayPopupView;
import com.rigol.scope.views.grid.GridRulerView;
import com.rigol.scope.views.grid.WaveformGridRulderView;
import com.rigol.scope.views.la.LaLienView;
import com.rigol.scope.views.la.MyDragshadow;
import com.rigol.scope.views.search.SearchMarkerView;
import com.rigol.scope.views.wave.WaveformLayout;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class WaveformLayout extends ConstraintLayout {
    private static final float SCALE_VIEW_DEFAULT_PERCENT = 0.033333335f;
    private static final float ZOOM_VIEW_DEFAULT_PERCENT = 0.6666667f;
    private ImageButton bodeCloseButton;
    private BodeCursorView bodeCursorView;
    private ConstraintLayout bodeLaoutView;
    private TextView bodeReseultText;
    private BodeView bodeView;
    private BodeViewLien bodeViewLien;
    private BodeViewLien bodeViewLienRange;
    private ImageButton bode_menu;
    private int bodephase;
    private List<Float> bodex_left;
    private List<Float> bodex_right;
    private List<Float> bodey_left;
    private List<Float> bodey_right;
    private boolean enableToSetHoriOffset;
    private boolean enableToSetVertOffset;
    private TextView freqText;
    private TextView gainText;
    private HorizontalParam horizontalParam;
    private boolean isFingerUp;
    private boolean isPopupViewShowing;
    private LaLienView laLienView;
    private LaParam laParam;
    LaViewModel laViewModel;
    private List<LaLienView> listla;
    int localisation;
    int localisationnew;
    int localisationold;
    private final GestureDetector.SimpleOnGestureListener mainOnGestureListener;
    private final ScaleGestureDetector.OnScaleGestureListener mainOnScaleGestureListener;
    private GridRulerView mainRulerView;
    private BaseSurfaceView mainSurfaceView;
    private BaseWaveformView mainView;
    private TextView phaseText;
    private boolean scrollDirect;
    private SearchMarkerView searchMarkerView;
    private final boolean shareSurface;
    private List<VerticalParam> verticalParams;
    private ImageButton zoomCloseButton;
    private TextView zoomInfoView;
    private final GestureDetector.SimpleOnGestureListener zoomOnGestureListener;
    private final ScaleGestureDetector.OnScaleGestureListener zoomOnScaleGestureListener;
    private GridRulerView zoomRulerView;
    private BaseSurfaceView zoomSurfaceView;
    private BaseWaveformView zoomView;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.wave.WaveformLayout$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass1 extends GestureDetector.SimpleOnGestureListener {
        AnonymousClass1() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            boolean isShowingWhenClickDown = PopupViewManager.getInstance().isShowingWhenClickDown();
            if (WaveformLayout.this.laParam.getLaEnable()) {
                float y = motionEvent.getY();
                int i = 0;
                int i2 = 0;
                while (i < WaveformLayout.this.mainView.getlist_textview().size()) {
                    int i3 = i + 1;
                    int i4 = i3 * 4;
                    if (Integer.parseInt(WaveformLayout.this.laParam.getInputLabellist64().get(i4 - 3)) == 1) {
                        int i5 = i4 - 2;
                        if (Math.abs(Integer.parseInt(WaveformLayout.this.laParam.getInputLabellist64().get(i5)) - motionEvent.getY()) < y) {
                            y = Math.abs(Integer.parseInt(WaveformLayout.this.laParam.getInputLabellist64().get(i5)) - motionEvent.getY());
                            i2 = i;
                        }
                    }
                    i = i3;
                }
                WaveformLayout.this.laParam.saveLaSelectPosition(i2);
            }
            if (!isShowingWhenClickDown) {
                WaveformLayout.this.isFingerUp = true;
                API.getInstance().UI_PostInt32Int32(40, MessageID.MSG_PLOT_MAIN_SELECT, (int) motionEvent.getX(), (int) motionEvent.getY());
            }
            WaveformLayout.this.isPopupViewShowing = false;
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            super.onShowPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
            if (defaultItem != null) {
                defaultItem.saveOffset(0L);
                Timber.d("plot, drag GND to:%s", Long.valueOf(defaultItem.getOffset()));
            }
            ToastUtils.showShort(WaveformLayout.this.getResources().getString(R.string.msg_setto_center));
            WaveformLayout.this.horizontalParam.setMainOffset(0L);
            WaveformLayout.this.horizontalParam.saveMainOffset(0L);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            long scale;
            long mainScale;
            if (WaveformLayout.this.isPopupViewShowing) {
                PopupViewManager.getInstance().dismiss(DisplayPopupView.class);
            }
            if (WaveformLayout.this.isFingerUp) {
                WaveformLayout.this.scrollDirect = Math.abs(f) > Math.abs(f2);
                WaveformLayout.this.isFingerUp = false;
            }
            if (!WaveformLayout.this.laParam.getLaEnable()) {
                if (WaveformLayout.this.scrollDirect) {
                    float f3 = WaveformLayout.this.mainSurfaceView.getTotalScrollDistance()[0];
                    if (WaveformLayout.this.horizontalParam != null) {
                        if (!WaveformLayout.this.enableToSetHoriOffset) {
                            WaveformLayout.this.horizontalParam.setMainOffset(0L);
                            WaveformLayout.this.horizontalParam.saveMainOffset(0L);
                            return false;
                        }
                        long verticalOffsetStep = OffsetUtil.getVerticalOffsetStep(WaveformLayout.this.horizontalParam.getMainScale());
                        long width = (((((float) (mainScale * 10)) * f3) / WaveformLayout.this.mainSurfaceView.getWidth()) / verticalOffsetStep) * verticalOffsetStep;
                        if (OffsetUtil.isCloseToAndOverZero(WaveformLayout.this.horizontalParam.getMainOffset(), WaveformLayout.this.horizontalParam.getMainOffset() + width)) {
                            WaveformLayout.this.enableToSetHoriOffset = false;
                            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$1$Eukhk2OBJIw0p-HD3hSW6xrQwfY
                                @Override // java.lang.Runnable
                                public final void run() {
                                    WaveformLayout.AnonymousClass1.this.lambda$onScroll$0$WaveformLayout$1();
                                }
                            }, 550L);
                        }
                        if (WaveformLayout.this.horizontalParam.isZoom()) {
                            WaveformLayout.this.horizontalParam.moveZoomOffset(WaveformLayout.this.horizontalParam.getZoomOffset() + (-width));
                        } else if (WaveformLayout.this.enableToSetHoriOffset) {
                            WaveformLayout.this.horizontalParam.moveMainOffset(WaveformLayout.this.horizontalParam.getMainOffset() + width);
                        }
                    }
                } else {
                    float f4 = WaveformLayout.this.mainSurfaceView.getTotalScrollDistance()[1];
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    if (defaultItem != null) {
                        if (!WaveformLayout.this.enableToSetVertOffset) {
                            defaultItem.saveOffset(0L);
                            Timber.d("plot, drag GND to:%s", Long.valueOf(defaultItem.getOffset()));
                            return false;
                        }
                        long verticalOffsetStep2 = OffsetUtil.getVerticalOffsetStep(defaultItem.getScale());
                        long height = (((((float) (scale * 8)) * f4) / WaveformLayout.this.mainSurfaceView.getHeight()) / verticalOffsetStep2) * verticalOffsetStep2;
                        if (OffsetUtil.isCloseToAndOverZero(defaultItem.getOffset(), defaultItem.getOffset() + height)) {
                            WaveformLayout.this.enableToSetVertOffset = false;
                            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$1$wXilh3ATAgU8dlhQ2ESuLh4BpXA
                                @Override // java.lang.Runnable
                                public final void run() {
                                    WaveformLayout.AnonymousClass1.this.lambda$onScroll$1$WaveformLayout$1();
                                }
                            }, 550L);
                        }
                        if (WaveformLayout.this.enableToSetVertOffset) {
                            defaultItem.saveOffset(defaultItem.getOffset() + height);
                        }
                    }
                }
            } else {
                float y = motionEvent.getY();
                int i = 0;
                int i2 = 0;
                while (i < WaveformLayout.this.mainView.getlist_textview().size()) {
                    int i3 = i + 1;
                    int i4 = i3 * 4;
                    if (Integer.parseInt(WaveformLayout.this.laParam.getInputLabellist64().get(i4 - 3)) == 1) {
                        WaveformLayout.this.mainView.getlist_textview().get(i).setVisibility(0);
                        WaveformLayout.this.mainView.getlist_textview().get(i).setText(WaveformLayout.this.laParam.getInputLabellist64().get(i4 - 1));
                        int i5 = i4 - 2;
                        if (Math.abs(Integer.parseInt(WaveformLayout.this.laParam.getInputLabellist64().get(i5)) - motionEvent2.getY()) < y) {
                            y = Math.abs(Integer.parseInt(WaveformLayout.this.laParam.getInputLabellist64().get(i5)) - motionEvent2.getY());
                            i2 = i;
                        }
                    }
                    i = i3;
                }
                WaveformLayout.this.laParam.saveLaPosition(i2);
            }
            return true;
        }

        public /* synthetic */ void lambda$onScroll$0$WaveformLayout$1() {
            WaveformLayout.this.enableToSetHoriOffset = true;
        }

        public /* synthetic */ void lambda$onScroll$1$WaveformLayout$1() {
            WaveformLayout.this.enableToSetVertOffset = true;
        }
    }

    public WaveformLayout(Context context) {
        super(context);
        this.shareSurface = false;
        this.bodephase = 60;
        this.listla = new ArrayList();
        this.bodex_left = new ArrayList();
        this.bodey_left = new ArrayList();
        this.bodex_right = new ArrayList();
        this.bodey_right = new ArrayList();
        this.localisation = 0;
        this.localisationold = 0;
        this.localisationnew = 0;
        this.isPopupViewShowing = false;
        this.isFingerUp = false;
        this.scrollDirect = false;
        this.enableToSetHoriOffset = true;
        this.enableToSetVertOffset = true;
        this.mainOnGestureListener = new AnonymousClass1();
        this.mainOnScaleGestureListener = new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.2
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                if (Math.abs(WaveformLayout.this.mainSurfaceView.getTotalScaleSpan()[0]) > Math.abs(WaveformLayout.this.mainSurfaceView.getTotalScaleSpan()[1])) {
                    Timber.d("横向缩放", new Object[0]);
                    float currentSpanX = scaleGestureDetector.getCurrentSpanX() / scaleGestureDetector.getPreviousSpanX();
                    if (WaveformLayout.this.horizontalParam == null) {
                        return false;
                    }
                    if (currentSpanX < 1.0f) {
                        WaveformLayout.this.horizontalParam.saveMainScale(WaveformLayout.this.horizontalParam.getScaleLager(WaveformLayout.this.horizontalParam.getMainScale()));
                    } else if (currentSpanX > 1.0f) {
                        WaveformLayout.this.horizontalParam.saveMainScale(WaveformLayout.this.horizontalParam.getScaleSmaller(WaveformLayout.this.horizontalParam.getMainScale()));
                    }
                } else {
                    Timber.d("纵向缩放", new Object[0]);
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    float currentSpanY = scaleGestureDetector.getCurrentSpanY() / scaleGestureDetector.getPreviousSpanY();
                    if (defaultItem != null) {
                        if (currentSpanY < 1.0f) {
                            defaultItem.scaleLarger(1);
                        } else if (currentSpanY > 1.0f) {
                            defaultItem.scaleSmaller(1);
                        }
                    }
                }
                return true;
            }
        };
        this.zoomOnGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (PopupViewManager.getInstance().isShowingWhenClickDown()) {
                    return true;
                }
                API.getInstance().UI_PostInt32Int32(40, MessageID.MSG_PLOT_ZOOM_SELECT, (int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f) > Math.abs(f2)) {
                    float f3 = WaveformLayout.this.zoomSurfaceView.getTotalScrollDistance()[0];
                    if (WaveformLayout.this.horizontalParam != null) {
                        long zoomScale = WaveformLayout.this.horizontalParam.getZoomScale();
                        long horizontalOffsetStep = OffsetUtil.getHorizontalOffsetStep(zoomScale);
                        WaveformLayout.this.horizontalParam.moveZoomOffset(WaveformLayout.this.horizontalParam.getZoomOffset() + ((((((float) (zoomScale * 10)) * f3) / WaveformLayout.this.zoomSurfaceView.getWidth()) / horizontalOffsetStep) * horizontalOffsetStep));
                    }
                } else {
                    float f4 = WaveformLayout.this.zoomSurfaceView.getTotalScrollDistance()[1];
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    if (defaultItem != null) {
                        long scale = defaultItem.getScale();
                        long verticalOffsetStep = OffsetUtil.getVerticalOffsetStep(scale);
                        defaultItem.saveOffset(defaultItem.getOffset() + ((((((float) (scale * 8)) * f4) / WaveformLayout.this.zoomSurfaceView.getHeight()) / verticalOffsetStep) * verticalOffsetStep));
                        Timber.d("plot, drag GND to:%s", Long.valueOf(defaultItem.getOffset()));
                    }
                }
                return true;
            }
        };
        this.zoomOnScaleGestureListener = new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.4
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                if (Math.abs(WaveformLayout.this.zoomSurfaceView.getTotalScaleSpan()[0]) > Math.abs(WaveformLayout.this.zoomSurfaceView.getTotalScaleSpan()[1])) {
                    Timber.d("横向缩放", new Object[0]);
                    float currentSpanX = scaleGestureDetector.getCurrentSpanX() / scaleGestureDetector.getPreviousSpanX();
                    if (WaveformLayout.this.horizontalParam == null) {
                        return false;
                    }
                    if (currentSpanX < 1.0f) {
                        WaveformLayout.this.horizontalParam.saveZoomScale(WaveformLayout.this.horizontalParam.getScaleLager(WaveformLayout.this.horizontalParam.getZoomScale()));
                    } else if (currentSpanX > 1.0f) {
                        WaveformLayout.this.horizontalParam.saveZoomScale(WaveformLayout.this.horizontalParam.getScaleSmaller(WaveformLayout.this.horizontalParam.getZoomScale()));
                    }
                } else {
                    Timber.d("纵向缩放", new Object[0]);
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    float currentSpanY = scaleGestureDetector.getCurrentSpanY() / scaleGestureDetector.getPreviousSpanY();
                    if (defaultItem != null) {
                        if (currentSpanY < 1.0f) {
                            defaultItem.scaleLarger(1);
                        } else if (currentSpanY > 1.0f) {
                            defaultItem.scaleSmaller(1);
                        }
                    }
                }
                return true;
            }
        };
        init();
    }

    public WaveformLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.shareSurface = false;
        this.bodephase = 60;
        this.listla = new ArrayList();
        this.bodex_left = new ArrayList();
        this.bodey_left = new ArrayList();
        this.bodex_right = new ArrayList();
        this.bodey_right = new ArrayList();
        this.localisation = 0;
        this.localisationold = 0;
        this.localisationnew = 0;
        this.isPopupViewShowing = false;
        this.isFingerUp = false;
        this.scrollDirect = false;
        this.enableToSetHoriOffset = true;
        this.enableToSetVertOffset = true;
        this.mainOnGestureListener = new AnonymousClass1();
        this.mainOnScaleGestureListener = new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.2
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                if (Math.abs(WaveformLayout.this.mainSurfaceView.getTotalScaleSpan()[0]) > Math.abs(WaveformLayout.this.mainSurfaceView.getTotalScaleSpan()[1])) {
                    Timber.d("横向缩放", new Object[0]);
                    float currentSpanX = scaleGestureDetector.getCurrentSpanX() / scaleGestureDetector.getPreviousSpanX();
                    if (WaveformLayout.this.horizontalParam == null) {
                        return false;
                    }
                    if (currentSpanX < 1.0f) {
                        WaveformLayout.this.horizontalParam.saveMainScale(WaveformLayout.this.horizontalParam.getScaleLager(WaveformLayout.this.horizontalParam.getMainScale()));
                    } else if (currentSpanX > 1.0f) {
                        WaveformLayout.this.horizontalParam.saveMainScale(WaveformLayout.this.horizontalParam.getScaleSmaller(WaveformLayout.this.horizontalParam.getMainScale()));
                    }
                } else {
                    Timber.d("纵向缩放", new Object[0]);
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    float currentSpanY = scaleGestureDetector.getCurrentSpanY() / scaleGestureDetector.getPreviousSpanY();
                    if (defaultItem != null) {
                        if (currentSpanY < 1.0f) {
                            defaultItem.scaleLarger(1);
                        } else if (currentSpanY > 1.0f) {
                            defaultItem.scaleSmaller(1);
                        }
                    }
                }
                return true;
            }
        };
        this.zoomOnGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (PopupViewManager.getInstance().isShowingWhenClickDown()) {
                    return true;
                }
                API.getInstance().UI_PostInt32Int32(40, MessageID.MSG_PLOT_ZOOM_SELECT, (int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f) > Math.abs(f2)) {
                    float f3 = WaveformLayout.this.zoomSurfaceView.getTotalScrollDistance()[0];
                    if (WaveformLayout.this.horizontalParam != null) {
                        long zoomScale = WaveformLayout.this.horizontalParam.getZoomScale();
                        long horizontalOffsetStep = OffsetUtil.getHorizontalOffsetStep(zoomScale);
                        WaveformLayout.this.horizontalParam.moveZoomOffset(WaveformLayout.this.horizontalParam.getZoomOffset() + ((((((float) (zoomScale * 10)) * f3) / WaveformLayout.this.zoomSurfaceView.getWidth()) / horizontalOffsetStep) * horizontalOffsetStep));
                    }
                } else {
                    float f4 = WaveformLayout.this.zoomSurfaceView.getTotalScrollDistance()[1];
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    if (defaultItem != null) {
                        long scale = defaultItem.getScale();
                        long verticalOffsetStep = OffsetUtil.getVerticalOffsetStep(scale);
                        defaultItem.saveOffset(defaultItem.getOffset() + ((((((float) (scale * 8)) * f4) / WaveformLayout.this.zoomSurfaceView.getHeight()) / verticalOffsetStep) * verticalOffsetStep));
                        Timber.d("plot, drag GND to:%s", Long.valueOf(defaultItem.getOffset()));
                    }
                }
                return true;
            }
        };
        this.zoomOnScaleGestureListener = new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.4
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                if (Math.abs(WaveformLayout.this.zoomSurfaceView.getTotalScaleSpan()[0]) > Math.abs(WaveformLayout.this.zoomSurfaceView.getTotalScaleSpan()[1])) {
                    Timber.d("横向缩放", new Object[0]);
                    float currentSpanX = scaleGestureDetector.getCurrentSpanX() / scaleGestureDetector.getPreviousSpanX();
                    if (WaveformLayout.this.horizontalParam == null) {
                        return false;
                    }
                    if (currentSpanX < 1.0f) {
                        WaveformLayout.this.horizontalParam.saveZoomScale(WaveformLayout.this.horizontalParam.getScaleLager(WaveformLayout.this.horizontalParam.getZoomScale()));
                    } else if (currentSpanX > 1.0f) {
                        WaveformLayout.this.horizontalParam.saveZoomScale(WaveformLayout.this.horizontalParam.getScaleSmaller(WaveformLayout.this.horizontalParam.getZoomScale()));
                    }
                } else {
                    Timber.d("纵向缩放", new Object[0]);
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    float currentSpanY = scaleGestureDetector.getCurrentSpanY() / scaleGestureDetector.getPreviousSpanY();
                    if (defaultItem != null) {
                        if (currentSpanY < 1.0f) {
                            defaultItem.scaleLarger(1);
                        } else if (currentSpanY > 1.0f) {
                            defaultItem.scaleSmaller(1);
                        }
                    }
                }
                return true;
            }
        };
        init();
    }

    public WaveformLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.shareSurface = false;
        this.bodephase = 60;
        this.listla = new ArrayList();
        this.bodex_left = new ArrayList();
        this.bodey_left = new ArrayList();
        this.bodex_right = new ArrayList();
        this.bodey_right = new ArrayList();
        this.localisation = 0;
        this.localisationold = 0;
        this.localisationnew = 0;
        this.isPopupViewShowing = false;
        this.isFingerUp = false;
        this.scrollDirect = false;
        this.enableToSetHoriOffset = true;
        this.enableToSetVertOffset = true;
        this.mainOnGestureListener = new AnonymousClass1();
        this.mainOnScaleGestureListener = new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.2
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                if (Math.abs(WaveformLayout.this.mainSurfaceView.getTotalScaleSpan()[0]) > Math.abs(WaveformLayout.this.mainSurfaceView.getTotalScaleSpan()[1])) {
                    Timber.d("横向缩放", new Object[0]);
                    float currentSpanX = scaleGestureDetector.getCurrentSpanX() / scaleGestureDetector.getPreviousSpanX();
                    if (WaveformLayout.this.horizontalParam == null) {
                        return false;
                    }
                    if (currentSpanX < 1.0f) {
                        WaveformLayout.this.horizontalParam.saveMainScale(WaveformLayout.this.horizontalParam.getScaleLager(WaveformLayout.this.horizontalParam.getMainScale()));
                    } else if (currentSpanX > 1.0f) {
                        WaveformLayout.this.horizontalParam.saveMainScale(WaveformLayout.this.horizontalParam.getScaleSmaller(WaveformLayout.this.horizontalParam.getMainScale()));
                    }
                } else {
                    Timber.d("纵向缩放", new Object[0]);
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    float currentSpanY = scaleGestureDetector.getCurrentSpanY() / scaleGestureDetector.getPreviousSpanY();
                    if (defaultItem != null) {
                        if (currentSpanY < 1.0f) {
                            defaultItem.scaleLarger(1);
                        } else if (currentSpanY > 1.0f) {
                            defaultItem.scaleSmaller(1);
                        }
                    }
                }
                return true;
            }
        };
        this.zoomOnGestureListener = new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.3
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                if (PopupViewManager.getInstance().isShowingWhenClickDown()) {
                    return true;
                }
                API.getInstance().UI_PostInt32Int32(40, MessageID.MSG_PLOT_ZOOM_SELECT, (int) motionEvent.getX(), (int) motionEvent.getY());
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (Math.abs(f) > Math.abs(f2)) {
                    float f3 = WaveformLayout.this.zoomSurfaceView.getTotalScrollDistance()[0];
                    if (WaveformLayout.this.horizontalParam != null) {
                        long zoomScale = WaveformLayout.this.horizontalParam.getZoomScale();
                        long horizontalOffsetStep = OffsetUtil.getHorizontalOffsetStep(zoomScale);
                        WaveformLayout.this.horizontalParam.moveZoomOffset(WaveformLayout.this.horizontalParam.getZoomOffset() + ((((((float) (zoomScale * 10)) * f3) / WaveformLayout.this.zoomSurfaceView.getWidth()) / horizontalOffsetStep) * horizontalOffsetStep));
                    }
                } else {
                    float f4 = WaveformLayout.this.zoomSurfaceView.getTotalScrollDistance()[1];
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    if (defaultItem != null) {
                        long scale = defaultItem.getScale();
                        long verticalOffsetStep = OffsetUtil.getVerticalOffsetStep(scale);
                        defaultItem.saveOffset(defaultItem.getOffset() + ((((((float) (scale * 8)) * f4) / WaveformLayout.this.zoomSurfaceView.getHeight()) / verticalOffsetStep) * verticalOffsetStep));
                        Timber.d("plot, drag GND to:%s", Long.valueOf(defaultItem.getOffset()));
                    }
                }
                return true;
            }
        };
        this.zoomOnScaleGestureListener = new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.4
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                if (Math.abs(WaveformLayout.this.zoomSurfaceView.getTotalScaleSpan()[0]) > Math.abs(WaveformLayout.this.zoomSurfaceView.getTotalScaleSpan()[1])) {
                    Timber.d("横向缩放", new Object[0]);
                    float currentSpanX = scaleGestureDetector.getCurrentSpanX() / scaleGestureDetector.getPreviousSpanX();
                    if (WaveformLayout.this.horizontalParam == null) {
                        return false;
                    }
                    if (currentSpanX < 1.0f) {
                        WaveformLayout.this.horizontalParam.saveZoomScale(WaveformLayout.this.horizontalParam.getScaleLager(WaveformLayout.this.horizontalParam.getZoomScale()));
                    } else if (currentSpanX > 1.0f) {
                        WaveformLayout.this.horizontalParam.saveZoomScale(WaveformLayout.this.horizontalParam.getScaleSmaller(WaveformLayout.this.horizontalParam.getZoomScale()));
                    }
                } else {
                    Timber.d("纵向缩放", new Object[0]);
                    VerticalParam defaultItem = ViewUtil.getDefaultItem(WaveformLayout.this.verticalParams);
                    float currentSpanY = scaleGestureDetector.getCurrentSpanY() / scaleGestureDetector.getPreviousSpanY();
                    if (defaultItem != null) {
                        if (currentSpanY < 1.0f) {
                            defaultItem.scaleLarger(1);
                        } else if (currentSpanY > 1.0f) {
                            defaultItem.scaleSmaller(1);
                        }
                    }
                }
                return true;
            }
        };
        init();
    }

    private void init() {
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        LaViewModel laViewModel = (LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class);
        this.laViewModel = laViewModel;
        if (laViewModel != null) {
            laViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$2bhJfj4lUW-sl8jxvd2AAMMKPkE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$0$WaveformLayout((LaParam) obj);
                }
            });
        }
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$O439SMopZnZJig1C_-9GhEnZnJs
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$1$WaveformLayout((HorizontalParam) obj);
                }
            });
        }
        if (verticalViewModel != null) {
            verticalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$eQMmZp0akM6xPleQT-JRkBGXS00
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$2$WaveformLayout((ArrayList) obj);
                }
            });
        }
        if (sharedViewModel != null) {
            sharedViewModel.localeChanged.observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$v28zdWo_xdwv_z37Iv6MOa3lAAo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$3$WaveformLayout((Boolean) obj);
                }
            });
        }
        addOnLayoutChangeListener(new AnonymousClass5(syncDataViewModel));
        if (syncDataViewModel != null) {
            syncDataViewModel.get(61, MessageID.MSG_BODE_ENABLE).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$_DwsKZK8jeXqhH_sN84UfkneqU8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$4$WaveformLayout(obj);
                }
            });
            syncDataViewModel.get(61, MessageID.MSG_BODE_RUNSTOP).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$VOuUabE7XBCaI6IYtyA37RbCZOs
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$5$WaveformLayout(obj);
                }
            });
            syncDataViewModel.get(61, MessageID.MSG_BODE_RESULT).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$9E0lmOT2BLn7yDLH9wbcJVV0B-8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$6$WaveformLayout(obj);
                }
            });
            syncDataViewModel.get(61, MessageID.MSG_BODE_PMGM).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$Ez1xgfwjRa5VMfSWQk-DDUZOmtQ
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$7$WaveformLayout(obj);
                }
            });
            syncDataViewModel.get(61, MessageID.MSG_BODE_PLOTDATA).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$p0sSLrqqvOoN2iH7augOKNcG_U4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$8$WaveformLayout(obj);
                }
            });
            syncDataViewModel.get(61, MessageID.MSG_BODE_SOURCE_OUT).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$byJigVh2teV_hEWySRY9dsh9eXg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformLayout.this.lambda$init$9$WaveformLayout(obj);
                }
            });
        }
        addMain();
    }

    public /* synthetic */ void lambda$init$0$WaveformLayout(LaParam laParam) {
        this.laParam = laParam;
    }

    public /* synthetic */ void lambda$init$1$WaveformLayout(HorizontalParam horizontalParam) {
        this.horizontalParam = horizontalParam;
    }

    public /* synthetic */ void lambda$init$2$WaveformLayout(ArrayList arrayList) {
        this.verticalParams = arrayList;
    }

    public /* synthetic */ void lambda$init$3$WaveformLayout(Boolean bool) {
        updateZoomInfo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.wave.WaveformLayout$5  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass5 implements View.OnLayoutChangeListener {
        final /* synthetic */ SyncDataViewModel val$syncDataViewModel;

        AnonymousClass5(SyncDataViewModel syncDataViewModel) {
            this.val$syncDataViewModel = syncDataViewModel;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            SyncDataViewModel syncDataViewModel = this.val$syncDataViewModel;
            if (syncDataViewModel != null) {
                syncDataViewModel.get(10, MessageID.MSG_HOR_ZOOM_SCALE).observe((LifecycleOwner) WaveformLayout.this.getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$5$oeSjkhd1I-IrxdIqkom5a5DdF8k
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WaveformLayout.AnonymousClass5.this.lambda$onLayoutChange$0$WaveformLayout$5(obj);
                    }
                });
                this.val$syncDataViewModel.get(10, MessageID.MSG_HOR_ZOOM_OFFSET).observe((LifecycleOwner) WaveformLayout.this.getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$5$PEZCWh8FsAON9zXyqbRJqK1Luzg
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WaveformLayout.AnonymousClass5.this.lambda$onLayoutChange$1$WaveformLayout$5(obj);
                    }
                });
                this.val$syncDataViewModel.get(10, MessageID.MSG_HOR_ZOOM_ON).observe((LifecycleOwner) WaveformLayout.this.getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$5$5nywMc4n0gBzEMGC8Kx3LzfMmuk
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WaveformLayout.AnonymousClass5.this.lambda$onLayoutChange$2$WaveformLayout$5(obj);
                    }
                });
            }
            WaveformLayout.this.removeOnLayoutChangeListener(this);
        }

        public /* synthetic */ void lambda$onLayoutChange$0$WaveformLayout$5(Object obj) {
            WaveformLayout.this.updateZoomInfo();
        }

        public /* synthetic */ void lambda$onLayoutChange$1$WaveformLayout$5(Object obj) {
            WaveformLayout.this.updateZoomInfo();
        }

        public /* synthetic */ void lambda$onLayoutChange$2$WaveformLayout$5(Object obj) {
            if (obj instanceof Boolean) {
                if (((Boolean) obj).booleanValue()) {
                    WaveformLayout.this.openZoom();
                } else {
                    WaveformLayout.this.closeZoom();
                }
            }
        }
    }

    public /* synthetic */ void lambda$init$4$WaveformLayout(Object obj) {
        if (((Boolean) obj).booleanValue() && ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBodedispType() == 0) {
            addBode();
        } else {
            closeBode();
        }
    }

    public /* synthetic */ void lambda$init$5$WaveformLayout(Object obj) {
        if (!((Boolean) obj).booleanValue() || this.bodeViewLien == null) {
            return;
        }
        this.bodeViewLienRange.resetisShowCircleS();
        this.bodeViewLien.resetisShowCircleS();
        this.bodeViewLien.resetLien();
        this.bodeViewLienRange.resetLien();
        this.bodeCursorView.setCursorReset();
        this.bodeView.setBodephase(60);
        this.bodephase = 60;
        ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultDatalist().clear();
        ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getPosition_listx().clear();
        ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().setBodeCursorPosition(0);
        ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBodeDataString().clear();
        this.bodeReseultText.setText("");
    }

    public /* synthetic */ void lambda$init$6$WaveformLayout(Object obj) {
        LogUtils.e("MSG_BODE_RESULT", "MSG_BODE_RESULT");
        this.bodeCursorView.setCursor();
        if (((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultlist().size() != 0) {
            TextView textView = this.bodeReseultText;
            textView.setText(((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultlist().get(3) + "    Freq:" + ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultlist().get(4) + "   Phase:" + ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultlist().get(5) + "   GM(°)    Freq:" + ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultlist().get(7) + "   Gain:" + ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultlist().get(8) + "     ");
        }
    }

    public /* synthetic */ void lambda$init$7$WaveformLayout(Object obj) {
        if (this.bodeViewLien != null) {
            String[] split = ((String) obj).split(",");
            if (((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(3)).floatValue() != 0.0f) {
                this.bodeViewLien.setCircle(((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(3)).floatValue(), ((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(4)).floatValue());
            }
            if (((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0)).floatValue() != 0.0f) {
                this.bodeViewLienRange.setCircle(((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0)).floatValue(), ((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(2)).floatValue());
            }
        }
    }

    public /* synthetic */ void lambda$init$8$WaveformLayout(Object obj) {
        if (this.bodeViewLien != null) {
            String str = (String) obj;
            ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultDatalist().add(str);
            String[] split = str.split(",");
            this.bodex_left.add((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0));
            this.bodey_left.add((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(1));
            this.bodex_right.add((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0));
            this.bodey_right.add((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(2));
            this.gainText.setText("Gain=" + String.format("%.2f", ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(1)) + "dB    ");
            this.phaseText.setText("Phase=" + String.format("%.2f", ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(2)) + "°   ");
            TextView textView = this.freqText;
            StringBuilder sb = new StringBuilder();
            sb.append("       Freq=");
            sb.append(ViewUtil.subNumber(UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0)).floatValue()) + ServiceEnum.Unit.Unit_hz.value2, 6));
            sb.append("    ");
            textView.setText(sb.toString());
            if (this.bodephase < Math.abs(((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(1)).floatValue())) {
                this.bodephase = Math.abs((int) (((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(1)).floatValue() * 1.0d));
                this.bodeViewLien.resetLien();
                this.bodeView.setBodephase(this.bodephase);
                this.bodeViewLien.setReset(true);
                int i = 0;
                while (i < ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultDatalist().size()) {
                    String[] split2 = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultDatalist().get(i).split(",");
                    this.bodeViewLien.resetdrawBodeLien(((Float) ((List) Stream.of((Object[]) split2).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0)).floatValue(), ((Float) ((List) Stream.of((Object[]) split2).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(1)).floatValue(), this.bodephase, ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultDatalist().size() == i, i);
                    i++;
                }
            } else {
                this.bodeViewLien.setReset(false);
                this.bodeViewLien.drawBodeLien(((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0)).floatValue(), ((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(1)).floatValue(), this.bodephase);
            }
            this.bodeViewLienRange.drawBodeLien1(((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0)).floatValue(), ((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(2)).floatValue(), 180);
            this.bodeViewLienRange.setColor(-16711936);
        }
    }

    public /* synthetic */ void lambda$init$9$WaveformLayout(Object obj) {
        String[] split;
        this.bodeCursorView.setCursorReset();
        this.bodeCursorView.setCursor();
        if (((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBodeCursorPosition() <= 0) {
            split = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultDatalist().get(0).split(",");
        } else if (((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBodeCursorPosition() >= ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getPosition_listx().size() - 1) {
            split = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultDatalist().get(((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getPosition_listx().size() - 1).split(",");
        } else {
            split = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBode_resultDatalist().get(((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().getBodeCursorPosition()).split(",");
        }
        TextView textView = this.gainText;
        textView.setText("Gain=" + String.format("%.2f", ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(1)) + "dB    ");
        TextView textView2 = this.phaseText;
        textView2.setText("Phase=" + String.format("%.2f", ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(2)) + "°   ");
        TextView textView3 = this.freqText;
        StringBuilder sb = new StringBuilder();
        sb.append("       Freq=");
        sb.append(ViewUtil.subNumber(UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(((Float) ((List) Stream.of((Object[]) split).map($$Lambda$WaveformLayout$DdUgxEkxA6iWf8LmYljsS8EFpc.INSTANCE).collect(Collectors.toList())).get(0)).floatValue()) + ServiceEnum.Unit.Unit_hz.value2, 6));
        sb.append("    ");
        textView3.setText(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateZoomInfo() {
        if (this.horizontalParam == null || this.zoomInfoView == null) {
            return;
        }
        this.zoomInfoView.setText(String.format("%s    %s: %s    %s: %s", ContextUtil.getString(R.string.msg_hor_zoom_on), ContextUtil.getString(R.string.msg_hor_main_scale), this.horizontalParam.getZoomScaleStr(), ContextUtil.getString(R.string.msg_hor_main_offset), this.horizontalParam.getZoomOffsetStr()));
    }

    public void addMain() {
        addMainSurfaceView();
        addMainRulerView();
        addMainTagLayoutView();
        addSearchMarkerView(1);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.connect(this.mainRulerView.getId(), 3, 0, 3);
        constraintSet.connect(this.mainRulerView.getId(), 4, 0, 4);
        constraintSet.connect(this.mainRulerView.getId(), 6, 0, 6);
        constraintSet.connect(this.mainRulerView.getId(), 7, 0, 7);
        constraintSet.connect(this.mainSurfaceView.getId(), 3, 0, 3);
        constraintSet.connect(this.mainSurfaceView.getId(), 4, 0, 4);
        constraintSet.connect(this.mainSurfaceView.getId(), 6, 0, 6);
        constraintSet.connect(this.mainSurfaceView.getId(), 7, 0, 7);
        constraintSet.connect(this.mainView.getId(), 3, 0, 3);
        constraintSet.connect(this.mainView.getId(), 4, 0, 4);
        constraintSet.connect(this.mainView.getId(), 6, 0, 6);
        constraintSet.connect(this.mainView.getId(), 7, 0, 7);
        constraintSet.connect(this.mainView.getId(), 3, this.searchMarkerView.getId(), 3);
        constraintSet.applyTo(this);
        ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$WGajUCJWSULpfllvlppvQdSTMgc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformLayout.this.lambda$addMain$10$WaveformLayout((SharedParam) obj);
            }
        });
    }

    public /* synthetic */ void lambda$addMain$10$WaveformLayout(final SharedParam sharedParam) {
        sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.wave.WaveformLayout.6
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                int[] iArr = new int[2];
                WaveformLayout.this.mainView.getLocationOnScreen(iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                View view = (View) WaveformLayout.this.mainView.getParent();
                if (i == 833) {
                    boolean showResultBar = sharedParam.getShowResultBar();
                    if (WaveformLayout.this.zoomRulerView != null) {
                        WaveformLayout.this.zoomRulerView.setAbout(!showResultBar);
                        WaveformLayout.this.zoomRulerView.invalidate();
                    }
                    WaveformLayout.this.mainRulerView.setAbout(true ^ showResultBar);
                    WaveformLayout.this.mainRulerView.invalidate();
                    if (WaveformLayout.this.mainView.getWidth() + i2 != view.getRootView().getWidth() - 12 || !sharedParam.getShowResultBar()) {
                        WaveformLayout.this.mainView.setresetAllTag();
                        if (WaveformLayout.this.zoomView != null) {
                            WaveformLayout.this.zoomView.setresetAllTag();
                        }
                    } else {
                        WaveformLayout.this.mainView.setAllTag();
                        if (WaveformLayout.this.zoomView != null) {
                            WaveformLayout.this.zoomView.setAllTag();
                        }
                    }
                }
                if (i == 1033) {
                    if (i2 + WaveformLayout.this.mainView.getWidth() != view.getRootView().getWidth() - 12 || !sharedParam.getShowResultBar()) {
                        if (WaveformLayout.this.zoomView != null) {
                            WaveformLayout.this.zoomView.setresetAllTag();
                        }
                        WaveformLayout.this.mainView.setresetAllTag();
                        return;
                    }
                    if (WaveformLayout.this.zoomView != null) {
                        WaveformLayout.this.zoomView.setAllTag();
                    }
                    WaveformLayout.this.mainView.setAllTag();
                }
            }
        });
    }

    private void addMainTagLayoutView() {
        MainWaveformView mainWaveformView = new MainWaveformView(getContext());
        this.mainView = mainWaveformView;
        mainWaveformView.setId(View.generateViewId());
        addView(this.mainView, -1, 0);
    }

    private void addMainSurfaceView() {
        BaseSurfaceView baseSurfaceView = new BaseSurfaceView(getContext());
        this.mainSurfaceView = baseSurfaceView;
        baseSurfaceView.setId(View.generateViewId());
        WindowParam windowParam = new WindowParam();
        windowParam.setType(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM);
        windowParam.setServiceID(55);
        this.mainSurfaceView.setParam(windowParam);
        this.mainSurfaceView.setOnScrollCalledInterval(1);
        this.mainSurfaceView.setOnScaleCalledInterval(10);
        this.mainSurfaceView.setGestureListener(this.mainOnGestureListener);
        this.mainSurfaceView.setOnScaleGestureListener(this.mainOnScaleGestureListener);
        addView(this.mainSurfaceView, -1, 0);
    }

    private void addMainRulerView() {
        WaveformGridRulderView waveformGridRulderView = new WaveformGridRulderView(getContext(), null, 0, false);
        this.mainRulerView = waveformGridRulderView;
        waveformGridRulderView.setId(View.generateViewId());
        this.mainRulerView.setColumnTextColor(-29696);
        this.mainRulerView.isMain(true);
        addView(this.mainRulerView, -1, 0);
    }

    public void addZoom() {
        addZoomSurfaceView();
        addZoomRulerView();
        addZoomTagLayoutView();
        addZoomScaleView();
        addZoomCloseView();
        addSearchMarkerView(2);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this);
        constraintSet.connect(this.mainRulerView.getId(), 4, this.zoomInfoView.getId(), 3);
        constraintSet.connect(this.mainSurfaceView.getId(), 4, this.zoomInfoView.getId(), 3);
        constraintSet.connect(this.mainView.getId(), 4, this.zoomInfoView.getId(), 3);
        constraintSet.connect(this.zoomRulerView.getId(), 3, this.zoomInfoView.getId(), 4);
        constraintSet.connect(this.zoomRulerView.getId(), 4, 0, 4);
        constraintSet.constrainPercentHeight(this.zoomRulerView.getId(), ZOOM_VIEW_DEFAULT_PERCENT);
        constraintSet.connect(this.zoomView.getId(), 3, this.zoomInfoView.getId(), 4);
        constraintSet.connect(this.zoomView.getId(), 4, 0, 4);
        constraintSet.constrainPercentHeight(this.zoomView.getId(), ZOOM_VIEW_DEFAULT_PERCENT);
        constraintSet.connect(this.zoomSurfaceView.getId(), 3, this.zoomInfoView.getId(), 4);
        constraintSet.connect(this.zoomSurfaceView.getId(), 4, 0, 4);
        constraintSet.constrainPercentHeight(this.zoomSurfaceView.getId(), ZOOM_VIEW_DEFAULT_PERCENT);
        constraintSet.connect(this.zoomInfoView.getId(), 3, this.mainView.getId(), 4);
        constraintSet.connect(this.zoomInfoView.getId(), 4, this.zoomView.getId(), 3);
        constraintSet.constrainHeight(this.zoomInfoView.getId(), 28);
        constraintSet.connect(this.zoomCloseButton.getId(), 3, this.mainView.getId(), 4);
        constraintSet.connect(this.zoomCloseButton.getId(), 4, this.zoomView.getId(), 3);
        constraintSet.connect(this.zoomCloseButton.getId(), 7, 0, 7);
        constraintSet.connect(this.searchMarkerView.getId(), 3, this.zoomView.getId(), 3);
        constraintSet.applyTo(this);
    }

    public void addBode() {
        addBodeLayoutView();
        ((SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class)).get(61, MessageID.MSG_BODE_START_FREQ).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$HOzzM8MRQBFTUkBPwFn1_I9dsJ0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformLayout.this.lambda$addBode$11$WaveformLayout(obj);
            }
        });
    }

    public /* synthetic */ void lambda$addBode$11$WaveformLayout(Object obj) {
        this.bodeView.drawBodeLien();
    }

    private void addZoomTagLayoutView() {
        ZoomWaveformView zoomWaveformView = new ZoomWaveformView(getContext());
        this.zoomView = zoomWaveformView;
        zoomWaveformView.setId(View.generateViewId());
        addView(this.zoomView, -1, 0);
    }

    private void addBodeLayoutView() {
        if (this.bodeLaoutView == null) {
            addBodeCloseView();
            this.bodeLaoutView = new ConstraintLayout(getContext());
            this.bodeViewLien = new BodeViewLien(getContext());
            this.bodeViewLienRange = new BodeViewLien(getContext());
            BodeCursorView bodeCursorView = new BodeCursorView(getContext());
            this.bodeCursorView = bodeCursorView;
            bodeCursorView.setId(View.generateViewId());
            this.bodeViewLienRange.setId(View.generateViewId());
            this.bodeViewLien.setId(View.generateViewId());
            this.bodeLaoutView.setId(View.generateViewId());
            addView(this.bodeLaoutView, -1, 0);
            BodeView bodeView = new BodeView(getContext());
            this.bodeView = bodeView;
            bodeView.setId(View.generateViewId());
            TextView textView = new TextView(getContext());
            this.bodeReseultText = textView;
            textView.setTextColor(getContext().getColor(R.color.white));
            this.bodeReseultText.setTextSize(15.0f);
            TextView textView2 = new TextView(getContext());
            this.freqText = textView2;
            textView2.setTextColor(getContext().getColor(R.color.white));
            this.freqText.setTextSize(15.0f);
            TextView textView3 = new TextView(getContext());
            this.gainText = textView3;
            textView3.setTextColor(getContext().getColor(R.color.red));
            this.gainText.setTextSize(15.0f);
            TextView textView4 = new TextView(getContext());
            this.phaseText = textView4;
            textView4.setTextColor(getContext().getColor(R.color.green));
            this.phaseText.setTextSize(15.0f);
            this.freqText.setId(View.generateViewId());
            this.gainText.setId(View.generateViewId());
            this.phaseText.setId(View.generateViewId());
            this.bodeReseultText.setId(View.generateViewId());
            addView(this.freqText, -2, 0);
            addView(this.gainText, -2, 0);
            addView(this.phaseText, -2, 0);
            addView(this.bodeReseultText, -2, 0);
            addView(this.bodeView, -1, 0);
            addView(this.bodeViewLienRange, -1, 0);
            addView(this.bodeViewLien, -1, 0);
            addView(this.bodeCursorView, -1, 0);
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            if (this.bodeView != null) {
                constraintSet.connect(this.mainView.getId(), 4, this.bodeLaoutView.getId(), 3);
                constraintSet.connect(this.mainSurfaceView.getId(), 4, this.bodeLaoutView.getId(), 3);
                constraintSet.connect(this.mainRulerView.getId(), 4, this.bodeLaoutView.getId(), 3);
                constraintSet.connect(this.bodeLaoutView.getId(), 4, 0, 4);
                constraintSet.constrainPercentHeight(this.bodeLaoutView.getId(), 0.8f);
                constraintSet.connect(this.bodeView.getId(), 4, 0, 4);
                constraintSet.setMargin(this.bodeView.getId(), 4, 0);
                constraintSet.constrainPercentHeight(this.bodeView.getId(), 0.8f);
                constraintSet.connect(this.bodeViewLien.getId(), 4, 0, 4);
                constraintSet.setMargin(this.bodeViewLien.getId(), 4, 0);
                constraintSet.constrainPercentHeight(this.bodeViewLien.getId(), 0.8f);
                constraintSet.connect(this.bodeViewLienRange.getId(), 4, 0, 4);
                constraintSet.setMargin(this.bodeViewLienRange.getId(), 4, 0);
                constraintSet.constrainPercentHeight(this.bodeViewLienRange.getId(), 0.8f);
                constraintSet.connect(this.freqText.getId(), 3, this.bodeView.getId(), 3);
                constraintSet.setMargin(this.freqText.getId(), 3, 15);
                constraintSet.setMargin(this.bodeViewLienRange.getId(), 1, 10);
                constraintSet.constrainPercentHeight(this.freqText.getId(), 0.2f);
                constraintSet.connect(this.gainText.getId(), 3, this.bodeView.getId(), 3);
                constraintSet.connect(this.gainText.getId(), 1, this.freqText.getId(), 2);
                constraintSet.setMargin(this.gainText.getId(), 3, 15);
                constraintSet.constrainPercentHeight(this.gainText.getId(), 0.2f);
                constraintSet.connect(this.bodeCursorView.getId(), 4, 0, 4);
                constraintSet.setMargin(this.bodeCursorView.getId(), 4, 0);
                constraintSet.constrainPercentHeight(this.bodeCursorView.getId(), 0.8f);
                constraintSet.connect(this.phaseText.getId(), 3, this.bodeView.getId(), 3);
                constraintSet.connect(this.phaseText.getId(), 1, this.gainText.getId(), 2);
                constraintSet.setMargin(this.phaseText.getId(), 3, 15);
                constraintSet.constrainPercentHeight(this.gainText.getId(), 0.2f);
                constraintSet.connect(this.bodeReseultText.getId(), 3, this.bodeView.getId(), 3);
                constraintSet.connect(this.bodeReseultText.getId(), 7, 0, 7, 100);
                constraintSet.setMargin(this.bodeReseultText.getId(), 3, 15);
                constraintSet.connect(this.bode_menu.getId(), 3, this.bodeView.getId(), 3);
                constraintSet.connect(this.bode_menu.getId(), 7, 0, 7, 50);
                constraintSet.setMargin(this.bode_menu.getId(), 3, 5);
                constraintSet.constrainPercentHeight(this.bode_menu.getId(), 0.2f);
                constraintSet.connect(this.bodeCloseButton.getId(), 3, this.bodeView.getId(), 3);
                constraintSet.connect(this.bodeCloseButton.getId(), 7, 0, 7, 15);
                constraintSet.setMargin(this.bodeCloseButton.getId(), 3, 5);
                constraintSet.constrainPercentHeight(this.bodeCloseButton.getId(), 0.2f);
                constraintSet.applyTo(this);
                return;
            }
            return;
        }
        ConstraintSet constraintSet2 = new ConstraintSet();
        constraintSet2.clone(this);
        if (this.bodeView != null) {
            constraintSet2.connect(this.mainView.getId(), 4, this.bodeLaoutView.getId(), 3);
            constraintSet2.connect(this.mainSurfaceView.getId(), 4, this.bodeLaoutView.getId(), 3);
            constraintSet2.connect(this.mainRulerView.getId(), 4, this.bodeLaoutView.getId(), 3);
            constraintSet2.connect(this.bodeLaoutView.getId(), 4, 0, 4);
            constraintSet2.constrainPercentHeight(this.bodeLaoutView.getId(), 0.8f);
            constraintSet2.connect(this.bodeView.getId(), 4, 0, 4);
            constraintSet2.setMargin(this.bodeView.getId(), 4, 0);
            constraintSet2.constrainPercentHeight(this.bodeView.getId(), 0.8f);
            constraintSet2.connect(this.bodeViewLien.getId(), 4, 0, 4);
            constraintSet2.setMargin(this.bodeViewLien.getId(), 4, 0);
            constraintSet2.constrainPercentHeight(this.bodeViewLien.getId(), 0.8f);
            constraintSet2.connect(this.bodeViewLienRange.getId(), 4, 0, 4);
            constraintSet2.setMargin(this.bodeViewLienRange.getId(), 4, 0);
            constraintSet2.constrainPercentHeight(this.bodeViewLienRange.getId(), 0.8f);
            constraintSet2.connect(this.freqText.getId(), 3, this.bodeView.getId(), 3);
            constraintSet2.setMargin(this.freqText.getId(), 3, 15);
            constraintSet2.setMargin(this.bodeViewLienRange.getId(), 1, 10);
            constraintSet2.constrainPercentHeight(this.freqText.getId(), 0.2f);
            constraintSet2.connect(this.gainText.getId(), 3, this.bodeView.getId(), 3);
            constraintSet2.connect(this.gainText.getId(), 1, this.freqText.getId(), 2);
            constraintSet2.setMargin(this.gainText.getId(), 3, 15);
            constraintSet2.constrainPercentHeight(this.gainText.getId(), 0.2f);
            constraintSet2.connect(this.bodeCursorView.getId(), 4, 0, 4);
            constraintSet2.setMargin(this.bodeCursorView.getId(), 4, 0);
            constraintSet2.constrainPercentHeight(this.bodeCursorView.getId(), 0.8f);
            constraintSet2.connect(this.phaseText.getId(), 3, this.bodeView.getId(), 3);
            constraintSet2.connect(this.phaseText.getId(), 1, this.gainText.getId(), 2);
            constraintSet2.setMargin(this.phaseText.getId(), 3, 15);
            constraintSet2.constrainPercentHeight(this.gainText.getId(), 0.2f);
            constraintSet2.connect(this.bodeReseultText.getId(), 3, this.bodeView.getId(), 3);
            constraintSet2.connect(this.bodeReseultText.getId(), 2, 0, 2, 400);
            constraintSet2.setMargin(this.bodeReseultText.getId(), 3, 15);
            constraintSet2.constrainPercentHeight(this.bodeReseultText.getId(), 0.2f);
            constraintSet2.connect(this.bode_menu.getId(), 3, this.bodeView.getId(), 3);
            constraintSet2.connect(this.bode_menu.getId(), 7, 0, 7, 50);
            constraintSet2.setMargin(this.bode_menu.getId(), 3, 5);
            constraintSet2.constrainPercentHeight(this.bode_menu.getId(), 0.2f);
            constraintSet2.connect(this.bodeCloseButton.getId(), 3, this.bodeView.getId(), 3);
            constraintSet2.connect(this.bodeCloseButton.getId(), 7, 0, 7, 25);
            constraintSet2.setMargin(this.bodeCloseButton.getId(), 3, 5);
            constraintSet2.constrainPercentHeight(this.bodeCloseButton.getId(), 0.2f);
            constraintSet2.applyTo(this);
        }
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$FKs4tex90bD0j9yrQJexiukbEb8
            @Override // java.lang.Runnable
            public final void run() {
                WaveformLayout.this.lambda$addBodeLayoutView$12$WaveformLayout();
            }
        }, 100L);
    }

    public /* synthetic */ void lambda$addBodeLayoutView$12$WaveformLayout() {
        ViewUtil.setVisibility(this.bodeView, 0);
        ViewUtil.setVisibility(this.bodeLaoutView, 0);
        ViewUtil.setVisibility(this.bodeViewLien, 0);
        ViewUtil.setVisibility(this.bodeViewLienRange, 0);
        ViewUtil.setVisibility(this.bodeCursorView, 0);
        ViewUtil.setVisibility(this.bodeCloseButton, 0);
        ViewUtil.setVisibility(this.bode_menu, 0);
    }

    private void addZoomSurfaceView() {
        BaseSurfaceView baseSurfaceView = new BaseSurfaceView(getContext());
        this.zoomSurfaceView = baseSurfaceView;
        baseSurfaceView.setId(View.generateViewId());
        WindowParam windowParam = new WindowParam();
        windowParam.setType(ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM);
        windowParam.setServiceID(55);
        this.zoomSurfaceView.setParam(windowParam);
        addView(this.zoomSurfaceView, -1, 0);
        this.zoomSurfaceView.setOnScrollCalledInterval(3);
        this.zoomSurfaceView.setOnScaleCalledInterval(10);
        this.zoomSurfaceView.setGestureListener(this.zoomOnGestureListener);
        this.zoomSurfaceView.setOnScaleGestureListener(this.zoomOnScaleGestureListener);
    }

    private void addZoomRulerView() {
        WaveformGridRulderView waveformGridRulderView = new WaveformGridRulderView(getContext(), null, 0, true);
        this.zoomRulerView = waveformGridRulderView;
        waveformGridRulderView.setId(View.generateViewId());
        this.zoomRulerView.setColumnTextColor(-29696);
        this.mainRulerView.isMain(true);
        addView(this.zoomRulerView, -1, 0);
    }

    private void addZoomCloseView() {
        ImageButton imageButton = new ImageButton(getContext());
        this.zoomCloseButton = imageButton;
        imageButton.setId(View.generateViewId());
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(16843534, typedValue, true);
        this.zoomCloseButton.setForeground(ContextCompat.getDrawable(getContext(), typedValue.resourceId));
        this.zoomCloseButton.setImageResource(R.drawable.ic_close);
        this.zoomCloseButton.setBackgroundColor(ContextCompat.getColor(getContext(), 17170445));
        addView(this.zoomCloseButton, 30, 30);
        this.zoomCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$8GR2gXYMq5t8eNeJiWNamqYImxw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WaveformLayout.this.lambda$addZoomCloseView$13$WaveformLayout(view);
            }
        });
    }

    public /* synthetic */ void lambda$addZoomCloseView$13$WaveformLayout(View view) {
        HorizontalParam horizontalParam = this.horizontalParam;
        if (horizontalParam != null) {
            horizontalParam.saveZoom(false);
        }
    }

    private void addBodeCloseView() {
        ImageButton imageButton = new ImageButton(getContext());
        this.bodeCloseButton = imageButton;
        imageButton.setId(View.generateViewId());
        ImageButton imageButton2 = new ImageButton(getContext());
        this.bode_menu = imageButton2;
        imageButton2.setId(View.generateViewId());
        TypedValue typedValue = new TypedValue();
        getContext().getTheme().resolveAttribute(16843534, typedValue, true);
        this.bodeCloseButton.setForeground(ContextCompat.getDrawable(getContext(), typedValue.resourceId));
        this.bodeCloseButton.setImageResource(R.drawable.ic_close);
        this.bodeCloseButton.setBackgroundColor(ContextCompat.getColor(getContext(), 17170445));
        this.bode_menu.setForeground(ContextCompat.getDrawable(getContext(), typedValue.resourceId));
        this.bode_menu.setImageResource(R.drawable.ic_menu);
        this.bode_menu.setBackgroundColor(ContextCompat.getColor(getContext(), 17170445));
        addView(this.bode_menu, 30, 30);
        addView(this.bodeCloseButton, 30, 30);
        this.bodeCloseButton.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$W3_JtsRuAEqmr4yta2UWyoiZ1tw
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue().saveBodeEnable(false);
            }
        });
        this.bode_menu.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PopupViewManager.getInstance().toggle(BodePopupWin.class);
            }
        });
    }

    private void addZoomScaleView() {
        TextView textView;
        TextView textView2 = new TextView(getContext());
        this.zoomInfoView = textView2;
        textView2.setId(View.generateViewId());
        this.zoomInfoView.setGravity(17);
        this.zoomInfoView.setTextColor(-1);
        addView(this.zoomInfoView, -1, 0);
        HorizontalParam horizontalParam = this.horizontalParam;
        if (horizontalParam == null || (textView = this.zoomInfoView) == null) {
            return;
        }
        textView.setText(String.format("Zoom:%s", horizontalParam.getZoomScaleStr().replace("%%", "%")));
    }

    public void openZoom() {
        if (this.zoomView != null) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.connect(this.mainRulerView.getId(), 4, this.zoomInfoView.getId(), 3);
            constraintSet.connect(this.mainSurfaceView.getId(), 4, this.zoomInfoView.getId(), 3);
            constraintSet.connect(this.mainView.getId(), 4, this.zoomInfoView.getId(), 3);
            constraintSet.connect(this.zoomRulerView.getId(), 3, this.zoomInfoView.getId(), 4);
            constraintSet.connect(this.zoomRulerView.getId(), 4, 0, 4);
            constraintSet.constrainPercentHeight(this.zoomRulerView.getId(), ZOOM_VIEW_DEFAULT_PERCENT);
            constraintSet.connect(this.zoomView.getId(), 3, this.zoomInfoView.getId(), 4);
            constraintSet.connect(this.zoomView.getId(), 4, 0, 4);
            constraintSet.constrainPercentHeight(this.zoomView.getId(), ZOOM_VIEW_DEFAULT_PERCENT);
            constraintSet.connect(this.zoomSurfaceView.getId(), 3, this.zoomInfoView.getId(), 4);
            constraintSet.connect(this.zoomSurfaceView.getId(), 4, 0, 4);
            constraintSet.constrainPercentHeight(this.zoomSurfaceView.getId(), ZOOM_VIEW_DEFAULT_PERCENT);
            constraintSet.connect(this.zoomInfoView.getId(), 3, this.mainView.getId(), 4);
            constraintSet.connect(this.zoomInfoView.getId(), 4, this.zoomView.getId(), 3);
            constraintSet.constrainHeight(this.zoomInfoView.getId(), 28);
            constraintSet.connect(this.zoomCloseButton.getId(), 3, this.mainView.getId(), 4);
            constraintSet.connect(this.zoomCloseButton.getId(), 4, this.zoomView.getId(), 3);
            constraintSet.connect(this.zoomCloseButton.getId(), 7, 0, 7);
            constraintSet.connect(this.searchMarkerView.getId(), 3, this.zoomView.getId(), 3);
            constraintSet.applyTo(this);
            ViewUtil.setVisibility(this.zoomSurfaceView, 0);
            ViewUtil.setVisibility(this.zoomView, 0);
            ViewUtil.setVisibility(this.zoomRulerView, 0);
            ViewUtil.setVisibility(this.zoomInfoView, 0);
            ViewUtil.setVisibility(this.zoomCloseButton, 0);
        } else {
            addZoom();
        }
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$pTMTa7kLLtdcGak4QkIGxWeXRQM
            @Override // java.lang.Runnable
            public final void run() {
                WaveformLayout.this.lambda$openZoom$15$WaveformLayout();
            }
        }, 100L);
    }

    public /* synthetic */ void lambda$openZoom$15$WaveformLayout() {
        this.zoomView.upAddLaTag(0.0f);
        this.mainView.upAddLaTag(0.0f);
    }

    public void closeBode() {
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$yR5RaKLC1N-QFN-KnubROaaIeyo
            @Override // java.lang.Runnable
            public final void run() {
                WaveformLayout.this.lambda$closeBode$16$WaveformLayout();
            }
        }, 100L);
    }

    public /* synthetic */ void lambda$closeBode$16$WaveformLayout() {
        ViewUtil.setVisibility(this.bodeView, 8);
        ViewUtil.setVisibility(this.bodeLaoutView, 8);
        ViewUtil.setVisibility(this.bodeViewLien, 8);
        ViewUtil.setVisibility(this.bodeViewLienRange, 8);
        ViewUtil.setVisibility(this.bodeCursorView, 8);
        ViewUtil.setVisibility(this.zoomCloseButton, 8);
    }

    public void closeZoom() {
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$3BXQIf94yotS3NirUSPkaBFBa8g
            @Override // java.lang.Runnable
            public final void run() {
                WaveformLayout.this.lambda$closeZoom$17$WaveformLayout();
            }
        }, 100L);
        if (this.mainView == null || this.zoomView == null) {
            return;
        }
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.wave.-$$Lambda$WaveformLayout$r9ALB68MeUIFBM3W8xoaTVa8FJg
            @Override // java.lang.Runnable
            public final void run() {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(60, MessageID.MSG_LA_ENABLE), true);
            }
        }, 200L);
    }

    public /* synthetic */ void lambda$closeZoom$17$WaveformLayout() {
        ViewUtil.setVisibility(this.zoomSurfaceView, 8);
        ViewUtil.setVisibility(this.zoomView, 8);
        ViewUtil.setVisibility(this.zoomRulerView, 8);
        ViewUtil.setVisibility(this.zoomInfoView, 8);
        ViewUtil.setVisibility(this.zoomCloseButton, 8);
    }

    public void toggleZoom() {
        BaseWaveformView baseWaveformView = this.zoomView;
        if (baseWaveformView == null || baseWaveformView.getVisibility() == 8) {
            HorizontalParam horizontalParam = this.horizontalParam;
            if (horizontalParam != null) {
                horizontalParam.saveZoom(true);
                return;
            }
            return;
        }
        HorizontalParam horizontalParam2 = this.horizontalParam;
        if (horizontalParam2 != null) {
            horizontalParam2.saveZoom(false);
        }
    }

    public BaseWaveformView getMainView() {
        return this.mainView;
    }

    public BaseWaveformView getZoomView() {
        return this.zoomView;
    }

    private void addSearchMarkerView(int i) {
        SearchMarkerView searchMarkerView = new SearchMarkerView(getContext(), null, i);
        this.searchMarkerView = searchMarkerView;
        searchMarkerView.setId(View.generateViewId());
        this.searchMarkerView.updateVisibility();
        addView(this.searchMarkerView, 500, 20);
    }

    private void addLalien(final int i, String str) {
        LaLienView laLienView = new LaLienView(getContext(), null, View.generateViewId());
        this.laLienView = laLienView;
        laLienView.setId(View.generateViewId());
        this.listla.add(this.laLienView);
        this.laViewModel.getLiveData().getValue().setList_lsview(this.listla);
        addView(this.laLienView, -1, -1);
        this.laLienView.setPosition(i, str);
        this.laLienView.setVisibility(0);
        this.laLienView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.8
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ClipData.Item item = new ClipData.Item(i + "");
                ClipData clipData = new ClipData(i + "", new String[]{"wsds"}, item);
                MyDragshadow myDragshadow = new MyDragshadow(WaveformLayout.this.laLienView);
                Point point = new Point();
                point.x = 1024;
                point.y = 80;
                view.startDragAndDrop(clipData, myDragshadow, null, 0);
                return false;
            }
        });
        this.laLienView.setOnDragListener(new View.OnDragListener() { // from class: com.rigol.scope.views.wave.WaveformLayout.9
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // android.view.View.OnDragListener
            public boolean onDrag(View view, DragEvent dragEvent) {
                int i2 = 0;
                switch (dragEvent.getAction()) {
                    case 1:
                        WaveformLayout.this.localisation = (int) dragEvent.getY();
                        while (i2 < WaveformLayout.this.listla.size()) {
                            if (Float.valueOf(dragEvent.getY() / WaveformLayout.this.laParam.getLa_spacing_()).intValue() * WaveformLayout.this.laParam.getLa_spacing_() == Float.valueOf(((LaLienView) WaveformLayout.this.listla.get(i2)).getLocationY()).floatValue()) {
                                WaveformLayout.this.localisationold = i2;
                            }
                            i2++;
                        }
                        return true;
                    case 2:
                        break;
                    case 3:
                        while (i2 < WaveformLayout.this.listla.size()) {
                            if (Float.valueOf(dragEvent.getY() / WaveformLayout.this.laParam.getLa_spacing_()).intValue() * WaveformLayout.this.laParam.getLa_spacing_() == Float.valueOf(((LaLienView) WaveformLayout.this.listla.get(i2)).getLocationY()).floatValue()) {
                                WaveformLayout.this.localisationnew = i2;
                            }
                            i2++;
                        }
                        ((LaLienView) WaveformLayout.this.listla.get(WaveformLayout.this.localisationnew)).setPosition(((LaLienView) WaveformLayout.this.listla.get(WaveformLayout.this.localisationold)).getLocationY());
                        ((LaLienView) WaveformLayout.this.listla.get(WaveformLayout.this.localisationold)).setPosition(Float.valueOf(dragEvent.getY() / WaveformLayout.this.laParam.getLa_spacing_()).intValue() * WaveformLayout.this.laParam.getLa_spacing_());
                        break;
                    case 4:
                    case 5:
                    case 6:
                        return true;
                    default:
                        return false;
                }
                return true;
            }
        });
    }
}
