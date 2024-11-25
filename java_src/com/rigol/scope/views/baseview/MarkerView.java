package com.rigol.scope.views.baseview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.DragViewUtil;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
/* loaded from: classes2.dex */
public class MarkerView extends View {
    private boolean checked;
    private boolean draging;
    private FftParam fftParam;
    private int marginLeft;
    private ServiceEnum.RtsaMarker markerId;
    private Path path;
    private String text;
    private final Paint textPaint;
    private final Paint trianglePaint;

    public String getText() {
        return this.text;
    }

    public void setText(String str) {
        this.text = str;
    }

    public int getMarginLeft() {
        return this.marginLeft;
    }

    public void setMarginLeft(int i) {
        this.marginLeft = i;
    }

    public MarkerView(Context context, AttributeSet attributeSet, ServiceEnum.RtsaMarker rtsaMarker) {
        super(context, attributeSet);
        this.textPaint = new Paint();
        this.trianglePaint = new Paint();
        this.path = new Path();
        this.text = "";
        this.markerId = ServiceEnum.RtsaMarker.Rtsa_Marker1;
        this.draging = false;
        this.checked = false;
        FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
        if (fftViewModel != null) {
            fftViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$MarkerView$-vOp-MFVskQAsJH0BBNMkldGb48
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MarkerView.this.lambda$new$0$MarkerView((FftParam) obj);
                }
            });
        }
        this.markerId = rtsaMarker;
        this.text = String.valueOf(rtsaMarker.value1);
        init();
    }

    public /* synthetic */ void lambda$new$0$MarkerView(FftParam fftParam) {
        this.fftParam = fftParam;
    }

    public void init() {
        initTextPaint();
        initTrianglePaint();
        addDragListener();
        addListener();
        setVisibility(8);
    }

    private void initTextPaint() {
        this.textPaint.setStrokeWidth(2.0f);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setColor(-1);
        this.textPaint.setTextSize(20.0f);
    }

    private void initTrianglePaint() {
        this.trianglePaint.setStrokeWidth(2.0f);
        this.trianglePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.trianglePaint.setColor(-1);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawText(canvas);
        drawTriangle(canvas);
    }

    private void drawText(Canvas canvas) {
        canvas.drawText(this.text, (getWidth() - this.textPaint.measureText(this.text)) / 2.0f, (getHeight() / 2.0f) - (getHeight() / 10.0f), this.textPaint);
    }

    private void drawTriangle(Canvas canvas) {
        this.path.reset();
        this.path.moveTo((getWidth() / 2.0f) - 15.0f, getHeight() / 2.0f);
        this.path.lineTo((getWidth() / 2.0f) + 15.0f, getHeight() / 2.0f);
        this.path.lineTo(getWidth() / 2.0f, (getHeight() / 2.0f) + 25.0f);
        this.path.close();
        canvas.drawPath(this.path, this.trianglePaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void drawChecked() {
        if (this.checked) {
            this.trianglePaint.setColor(InputDeviceCompat.SOURCE_ANY);
        } else {
            this.trianglePaint.setColor(-1);
        }
        invalidate();
    }

    public void addDragListener() {
        DragViewUtil.drag(this, this, new DragViewUtil.Callback2() { // from class: com.rigol.scope.views.baseview.MarkerView.1
            @Override // com.rigol.scope.utilities.DragViewUtil.Callback2
            public void onMovePoint(PointF pointF, float f, float f2) {
            }

            @Override // com.rigol.scope.utilities.DragViewUtil.Callback2
            public void onMoveStart() {
                MarkerView.this.checked = true;
                MarkerView.this.fftParam.saveMarkerChecked(MarkerView.this.markerId, MarkerView.this.checked);
                MarkerView.this.drawChecked();
                MarkerView.this.draging = true;
            }

            @Override // com.rigol.scope.utilities.DragViewUtil.Callback2
            public void onMoveEnd() {
                ViewGroup viewGroup = (ViewGroup) MarkerView.this.getParent();
                if (viewGroup == null) {
                    return;
                }
                int width = viewGroup.getWidth();
                MarkerView markerView = MarkerView.this;
                markerView.marginLeft = markerView.getLeft() + (MarkerView.this.getWidth() / 2);
                double d = (MarkerView.this.marginLeft * 1.0d) / width;
                if (MarkerView.this.fftParam == null) {
                    return;
                }
                MarkerView.this.fftParam.saveMarkerFreq(MarkerView.this.markerId, (long) ((d * MarkerView.this.fftParam.getSpan()) + MarkerView.this.fftParam.getStart()));
                MarkerView.this.draging = false;
            }
        });
    }

    public void addListener() {
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel == null) {
            return;
        }
        syncDataViewModel.get(this.fftParam.getServiceId(), MessageID.MSG_FFT_MARKER_CHANGE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$MarkerView$K3LS2shqlQVlPsLIlcFAi1AEKFg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MarkerView.this.lambda$addListener$1$MarkerView(obj);
            }
        });
    }

    public /* synthetic */ void lambda$addListener$1$MarkerView(Object obj) {
        if (this.draging) {
            return;
        }
        updatePostion();
        updateChecked();
        updateVisibility();
    }

    public void updatePostion() {
        double markerXpos = this.fftParam.getMarkerXpos(this.markerId);
        double markerYpos = this.fftParam.getMarkerYpos(this.markerId);
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup == null) {
            return;
        }
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.startMargin = (int) ((width * markerXpos) - (getWidth() / 2));
        layoutParams.topMargin = (int) (((height * markerYpos) - (getHeight() / 2)) - 25.0d);
        setLayoutParams(layoutParams);
    }

    public void updateChecked() {
        boolean markerChecked = this.fftParam.getMarkerChecked(this.markerId);
        if (this.checked != markerChecked) {
            this.checked = markerChecked;
            drawChecked();
        }
    }

    public void updateVisibility() {
        if (this.fftParam.findMarkerById(this.markerId) != null) {
            setVisibility(0);
        } else {
            setVisibility(8);
        }
    }
}
