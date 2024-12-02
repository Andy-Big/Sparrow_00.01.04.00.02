package com.rigol.scope.views.baseview;

import android.app.Activity;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.Surface;
import android.view.TextureView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import timber.log.Timber;

/* loaded from: classes2.dex */
public class BaseSurfaceView extends TextureView implements TextureView.SurfaceTextureListener {
    GestureDetector gestureDetector;
    GestureDetector.SimpleOnGestureListener gestureListener;
    private boolean isScaling;
    private final float[] lastDownXY;
    private int onScaleCalledInterval;
    private int onScaleCalledTimes;
    ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener;
    private int onScrollCalledInterval;
    private int onScrollCalledTimes;
    ScaleGestureDetector scaleGestureDetector;
    private int surfaceID;
    private SurfaceTexture surfaceTexture;
    private final float[] totalScaleSpan;
    private final float[] totalScrollDistance;
    private WindowParam windowParam;

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    static /* synthetic */ int access$108(BaseSurfaceView baseSurfaceView) {
        int i = baseSurfaceView.onScaleCalledTimes;
        baseSurfaceView.onScaleCalledTimes = i + 1;
        return i;
    }

    static /* synthetic */ int access$508(BaseSurfaceView baseSurfaceView) {
        int i = baseSurfaceView.onScrollCalledTimes;
        baseSurfaceView.onScrollCalledTimes = i + 1;
        return i;
    }

    public BaseSurfaceView(Context context) {
        super(context);
        this.isScaling = false;
        this.lastDownXY = new float[2];
        this.totalScrollDistance = new float[2];
        this.onScrollCalledTimes = 0;
        this.onScrollCalledInterval = 1;
        this.totalScaleSpan = new float[2];
        this.onScaleCalledTimes = 0;
        this.onScaleCalledInterval = 1;
        this.surfaceID = -1;
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.rigol.scope.views.baseview.BaseSurfaceView.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float[] fArr = BaseSurfaceView.this.totalScaleSpan;
                fArr[0] = fArr[0] + (scaleGestureDetector.getCurrentSpanX() - scaleGestureDetector.getPreviousSpanX());
                float[] fArr2 = BaseSurfaceView.this.totalScaleSpan;
                fArr2[1] = fArr2[1] + (scaleGestureDetector.getCurrentSpanY() - scaleGestureDetector.getPreviousSpanY());
                BaseSurfaceView.access$108(BaseSurfaceView.this);
                if (BaseSurfaceView.this.onScaleCalledInterval <= 0 || BaseSurfaceView.this.onScaleCalledTimes % BaseSurfaceView.this.onScaleCalledInterval == 0) {
                    if (BaseSurfaceView.this.onScaleGestureListener != null) {
                        return BaseSurfaceView.this.onScaleGestureListener.onScale(scaleGestureDetector);
                    }
                    return false;
                }
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                BaseSurfaceView.this.isScaling = true;
                BaseSurfaceView.this.totalScaleSpan[0] = 0.0f;
                BaseSurfaceView.this.totalScaleSpan[1] = 0.0f;
                BaseSurfaceView.this.onScaleCalledTimes = 0;
                if (BaseSurfaceView.this.onScaleGestureListener != null) {
                    return BaseSurfaceView.this.onScaleGestureListener.onScaleBegin(scaleGestureDetector);
                }
                return false;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                BaseSurfaceView.this.isScaling = false;
                if (BaseSurfaceView.this.onScaleGestureListener != null) {
                    BaseSurfaceView.this.onScaleGestureListener.onScaleEnd(scaleGestureDetector);
                }
            }
        });
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.views.baseview.BaseSurfaceView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                BaseSurfaceView.this.lastDownXY[0] = motionEvent.getX();
                BaseSurfaceView.this.lastDownXY[1] = motionEvent.getY();
                BaseSurfaceView.this.onScrollCalledTimes = 0;
                BaseSurfaceView.this.totalScrollDistance[0] = 0.0f;
                BaseSurfaceView.this.totalScrollDistance[1] = 0.0f;
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onDown(motionEvent);
                }
                return super.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onShowPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onSingleTapUp(motionEvent);
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                boolean z = Math.abs(f) > Math.abs(f2);
                if (z) {
                    float[] fArr = BaseSurfaceView.this.totalScrollDistance;
                    fArr[0] = fArr[0] + f;
                } else {
                    float[] fArr2 = BaseSurfaceView.this.totalScrollDistance;
                    fArr2[1] = fArr2[1] + f2;
                }
                BaseSurfaceView.access$508(BaseSurfaceView.this);
                if (BaseSurfaceView.this.onScrollCalledInterval <= 0 || BaseSurfaceView.this.onScrollCalledTimes % BaseSurfaceView.this.onScrollCalledInterval == 0) {
                    boolean onScroll = BaseSurfaceView.this.gestureListener != null ? BaseSurfaceView.this.gestureListener.onScroll(motionEvent, motionEvent2, f, f2) : false;
                    if (z) {
                        BaseSurfaceView.this.totalScrollDistance[0] = 0.0f;
                    } else {
                        BaseSurfaceView.this.totalScrollDistance[1] = 0.0f;
                    }
                    return onScroll;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.isScaling() || BaseSurfaceView.this.gestureListener == null) {
                    return;
                }
                BaseSurfaceView.this.gestureListener.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onFling(motionEvent, motionEvent2, f, f2);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onSingleTapConfirmed(motionEvent);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onDoubleTap(motionEvent);
                }
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onDoubleTapEvent(motionEvent);
                }
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
            public boolean onContextClick(MotionEvent motionEvent) {
                return super.onContextClick(motionEvent);
            }
        });
        init();
    }

    public BaseSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isScaling = false;
        this.lastDownXY = new float[2];
        this.totalScrollDistance = new float[2];
        this.onScrollCalledTimes = 0;
        this.onScrollCalledInterval = 1;
        this.totalScaleSpan = new float[2];
        this.onScaleCalledTimes = 0;
        this.onScaleCalledInterval = 1;
        this.surfaceID = -1;
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.rigol.scope.views.baseview.BaseSurfaceView.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float[] fArr = BaseSurfaceView.this.totalScaleSpan;
                fArr[0] = fArr[0] + (scaleGestureDetector.getCurrentSpanX() - scaleGestureDetector.getPreviousSpanX());
                float[] fArr2 = BaseSurfaceView.this.totalScaleSpan;
                fArr2[1] = fArr2[1] + (scaleGestureDetector.getCurrentSpanY() - scaleGestureDetector.getPreviousSpanY());
                BaseSurfaceView.access$108(BaseSurfaceView.this);
                if (BaseSurfaceView.this.onScaleCalledInterval <= 0 || BaseSurfaceView.this.onScaleCalledTimes % BaseSurfaceView.this.onScaleCalledInterval == 0) {
                    if (BaseSurfaceView.this.onScaleGestureListener != null) {
                        return BaseSurfaceView.this.onScaleGestureListener.onScale(scaleGestureDetector);
                    }
                    return false;
                }
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                BaseSurfaceView.this.isScaling = true;
                BaseSurfaceView.this.totalScaleSpan[0] = 0.0f;
                BaseSurfaceView.this.totalScaleSpan[1] = 0.0f;
                BaseSurfaceView.this.onScaleCalledTimes = 0;
                if (BaseSurfaceView.this.onScaleGestureListener != null) {
                    return BaseSurfaceView.this.onScaleGestureListener.onScaleBegin(scaleGestureDetector);
                }
                return false;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                BaseSurfaceView.this.isScaling = false;
                if (BaseSurfaceView.this.onScaleGestureListener != null) {
                    BaseSurfaceView.this.onScaleGestureListener.onScaleEnd(scaleGestureDetector);
                }
            }
        });
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.views.baseview.BaseSurfaceView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                BaseSurfaceView.this.lastDownXY[0] = motionEvent.getX();
                BaseSurfaceView.this.lastDownXY[1] = motionEvent.getY();
                BaseSurfaceView.this.onScrollCalledTimes = 0;
                BaseSurfaceView.this.totalScrollDistance[0] = 0.0f;
                BaseSurfaceView.this.totalScrollDistance[1] = 0.0f;
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onDown(motionEvent);
                }
                return super.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onShowPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onSingleTapUp(motionEvent);
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                boolean z = Math.abs(f) > Math.abs(f2);
                if (z) {
                    float[] fArr = BaseSurfaceView.this.totalScrollDistance;
                    fArr[0] = fArr[0] + f;
                } else {
                    float[] fArr2 = BaseSurfaceView.this.totalScrollDistance;
                    fArr2[1] = fArr2[1] + f2;
                }
                BaseSurfaceView.access$508(BaseSurfaceView.this);
                if (BaseSurfaceView.this.onScrollCalledInterval <= 0 || BaseSurfaceView.this.onScrollCalledTimes % BaseSurfaceView.this.onScrollCalledInterval == 0) {
                    boolean onScroll = BaseSurfaceView.this.gestureListener != null ? BaseSurfaceView.this.gestureListener.onScroll(motionEvent, motionEvent2, f, f2) : false;
                    if (z) {
                        BaseSurfaceView.this.totalScrollDistance[0] = 0.0f;
                    } else {
                        BaseSurfaceView.this.totalScrollDistance[1] = 0.0f;
                    }
                    return onScroll;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.isScaling() || BaseSurfaceView.this.gestureListener == null) {
                    return;
                }
                BaseSurfaceView.this.gestureListener.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onFling(motionEvent, motionEvent2, f, f2);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onSingleTapConfirmed(motionEvent);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onDoubleTap(motionEvent);
                }
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onDoubleTapEvent(motionEvent);
                }
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
            public boolean onContextClick(MotionEvent motionEvent) {
                return super.onContextClick(motionEvent);
            }
        });
        init();
    }

    public BaseSurfaceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isScaling = false;
        this.lastDownXY = new float[2];
        this.totalScrollDistance = new float[2];
        this.onScrollCalledTimes = 0;
        this.onScrollCalledInterval = 1;
        this.totalScaleSpan = new float[2];
        this.onScaleCalledTimes = 0;
        this.onScaleCalledInterval = 1;
        this.surfaceID = -1;
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.rigol.scope.views.baseview.BaseSurfaceView.1
            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float[] fArr = BaseSurfaceView.this.totalScaleSpan;
                fArr[0] = fArr[0] + (scaleGestureDetector.getCurrentSpanX() - scaleGestureDetector.getPreviousSpanX());
                float[] fArr2 = BaseSurfaceView.this.totalScaleSpan;
                fArr2[1] = fArr2[1] + (scaleGestureDetector.getCurrentSpanY() - scaleGestureDetector.getPreviousSpanY());
                BaseSurfaceView.access$108(BaseSurfaceView.this);
                if (BaseSurfaceView.this.onScaleCalledInterval <= 0 || BaseSurfaceView.this.onScaleCalledTimes % BaseSurfaceView.this.onScaleCalledInterval == 0) {
                    if (BaseSurfaceView.this.onScaleGestureListener != null) {
                        return BaseSurfaceView.this.onScaleGestureListener.onScale(scaleGestureDetector);
                    }
                    return false;
                }
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                BaseSurfaceView.this.isScaling = true;
                BaseSurfaceView.this.totalScaleSpan[0] = 0.0f;
                BaseSurfaceView.this.totalScaleSpan[1] = 0.0f;
                BaseSurfaceView.this.onScaleCalledTimes = 0;
                if (BaseSurfaceView.this.onScaleGestureListener != null) {
                    return BaseSurfaceView.this.onScaleGestureListener.onScaleBegin(scaleGestureDetector);
                }
                return false;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
                BaseSurfaceView.this.isScaling = false;
                if (BaseSurfaceView.this.onScaleGestureListener != null) {
                    BaseSurfaceView.this.onScaleGestureListener.onScaleEnd(scaleGestureDetector);
                }
            }
        });
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.views.baseview.BaseSurfaceView.2
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onDown(MotionEvent motionEvent) {
                BaseSurfaceView.this.lastDownXY[0] = motionEvent.getX();
                BaseSurfaceView.this.lastDownXY[1] = motionEvent.getY();
                BaseSurfaceView.this.onScrollCalledTimes = 0;
                BaseSurfaceView.this.totalScrollDistance[0] = 0.0f;
                BaseSurfaceView.this.totalScrollDistance[1] = 0.0f;
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onDown(motionEvent);
                }
                return super.onDown(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onShowPress(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onShowPress(motionEvent);
                }
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onSingleTapUp(motionEvent);
                }
                return super.onSingleTapUp(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                boolean z = Math.abs(f) > Math.abs(f2);
                if (z) {
                    float[] fArr = BaseSurfaceView.this.totalScrollDistance;
                    fArr[0] = fArr[0] + f;
                } else {
                    float[] fArr2 = BaseSurfaceView.this.totalScrollDistance;
                    fArr2[1] = fArr2[1] + f2;
                }
                BaseSurfaceView.access$508(BaseSurfaceView.this);
                if (BaseSurfaceView.this.onScrollCalledInterval <= 0 || BaseSurfaceView.this.onScrollCalledTimes % BaseSurfaceView.this.onScrollCalledInterval == 0) {
                    boolean onScroll = BaseSurfaceView.this.gestureListener != null ? BaseSurfaceView.this.gestureListener.onScroll(motionEvent, motionEvent2, f, f2) : false;
                    if (z) {
                        BaseSurfaceView.this.totalScrollDistance[0] = 0.0f;
                    } else {
                        BaseSurfaceView.this.totalScrollDistance[1] = 0.0f;
                    }
                    return onScroll;
                }
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public void onLongPress(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.isScaling() || BaseSurfaceView.this.gestureListener == null) {
                    return;
                }
                BaseSurfaceView.this.gestureListener.onLongPress(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onFling(motionEvent, motionEvent2, f, f2);
                }
                return super.onFling(motionEvent, motionEvent2, f, f2);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    return BaseSurfaceView.this.gestureListener.onSingleTapConfirmed(motionEvent);
                }
                return super.onSingleTapConfirmed(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onDoubleTap(motionEvent);
                }
                return super.onDoubleTap(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                if (BaseSurfaceView.this.gestureListener != null) {
                    BaseSurfaceView.this.gestureListener.onDoubleTapEvent(motionEvent);
                }
                return super.onDoubleTapEvent(motionEvent);
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
            public boolean onContextClick(MotionEvent motionEvent) {
                return super.onContextClick(motionEvent);
            }
        });
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
        setOpaque(false);
        UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        Activity topActivity = ActivityUtils.getTopActivity();
        if (updateUIViewModel == null || !(topActivity instanceof LifecycleOwner)) {
            return;
        }
        updateUIViewModel.get(0, 0, 0).observe((LifecycleOwner) topActivity, new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseSurfaceView$lCNHTsbyukwAE-t7ZaKlmC8Akxw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseSurfaceView.this.lambda$init$0$BaseSurfaceView((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$init$0$BaseSurfaceView(Boolean bool) {
        if (this.surfaceTexture == null || this.windowParam == null) {
            return;
        }
        Timber.tag("StandBy").d("UI_AddSurface", new Object[0]);
        this.surfaceID = API.getInstance().UI_AddSurface(new Surface(this.surfaceTexture), this.windowParam.getType().value1, this.windowParam.getSource1().value1, this.windowParam.getSource2().value1, this.windowParam.getSource3().value1, this.windowParam.getServiceID());
        Timber.d("surfaceID:" + this.surfaceID + ", surface:" + this.surfaceTexture, new Object[0]);
    }

    public void setParam(WindowParam windowParam) {
        this.windowParam = windowParam;
    }

    public int getSurfaceID() {
        return this.surfaceID;
    }

    public void setOnScaleGestureListener(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        this.onScaleGestureListener = onScaleGestureListener;
    }

    public void setGestureListener(GestureDetector.SimpleOnGestureListener simpleOnGestureListener) {
        this.gestureListener = simpleOnGestureListener;
    }

    public boolean isScaling() {
        return this.isScaling;
    }

    public float[] getLastDownXY() {
        return this.lastDownXY;
    }

    public float[] getTotalScrollDistance() {
        return this.totalScrollDistance;
    }

    public void setOnScrollCalledInterval(int i) {
        this.onScrollCalledInterval = i;
    }

    public float[] getTotalScaleSpan() {
        return this.totalScaleSpan;
    }

    public void setOnScaleCalledInterval(int i) {
        this.onScaleCalledInterval = i;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ScaleGestureDetector scaleGestureDetector;
        if (motionEvent.getPointerCount() <= 1 || (scaleGestureDetector = this.scaleGestureDetector) == null || !scaleGestureDetector.onTouchEvent(motionEvent)) {
            GestureDetector gestureDetector = this.gestureDetector;
            if (gestureDetector != null) {
                return gestureDetector.onTouchEvent(motionEvent);
            }
            return false;
        }
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.windowParam == null) {
            return;
        }
        this.surfaceTexture = surfaceTexture;
        this.surfaceID = API.getInstance().UI_AddSurface(new Surface(surfaceTexture), this.windowParam.getType().value1, this.windowParam.getSource1().value1, this.windowParam.getSource2().value1, this.windowParam.getSource3().value1, this.windowParam.getServiceID());
        Timber.d("surfaceID:" + this.surfaceID + ", surface:" + surfaceTexture, new Object[0]);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Timber.d("surfaceID:" + this.surfaceID + ", surface:" + surfaceTexture + ", width:" + i + ", height:" + i2, new Object[0]);
        API.getInstance().UI_SetSurface(this.surfaceID, new Surface(surfaceTexture));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Timber.d("surfaceID:" + this.surfaceID + ", surface:" + surfaceTexture, new Object[0]);
        this.surfaceTexture = null;
        API.getInstance().UI_DelSurface(this.surfaceID);
        return true;
    }
}
