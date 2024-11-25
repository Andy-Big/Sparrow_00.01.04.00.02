package com.rigol.scope.views.acquire;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.utilities.Colors;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AcquireDepthView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010$\u001a\u00020\u00152\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0014J(\u0010*\u001a\u00020&2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020,2\u0006\u0010/\u001a\u00020,H\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001bR\u0016\u0010\u001c\u001a\n \u000e*\u0004\u0018\u00010\u001d0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R\u000e\u0010\"\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/rigol/scope/views/acquire/AcquireDepthView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "amplitude", "", "angularFrequency", "depthPaint", "Landroid/graphics/Paint;", "horizontalViewModel", "Lcom/rigol/scope/viewmodels/HorizontalViewModel;", "kotlin.jvm.PlatformType", "param", "Lcom/rigol/scope/data/HorizontalParam;", "path", "Landroid/graphics/Path;", "phaseAngle", "screenStartPosition", "", "getScreenStartPosition", "()F", "setScreenStartPosition", "(F)V", "screenWidth", "Ljava/lang/Float;", "syncDataViewModel", "Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "tagPaint", "tagPosition", "getTagPosition", "setTagPosition", "wavePaint", "zoomShadowPaint", "calTagPosition", "getParam", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onSizeChanged", "w", "", "h", "oldw", "oldh", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class AcquireDepthView extends ConstraintLayout {
    private double amplitude;
    private final double angularFrequency;
    private final Paint depthPaint;
    private final HorizontalViewModel horizontalViewModel;
    private final HorizontalParam param;
    private final Path path;
    private final double phaseAngle;
    private float screenStartPosition;
    private Float screenWidth;
    private final SyncDataViewModel syncDataViewModel;
    private final Paint tagPaint;
    private float tagPosition;
    private final Paint wavePaint;
    private final Paint zoomShadowPaint;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AcquireDepthView(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LiveData<HorizontalParam> liveData;
        Intrinsics.checkNotNullParameter(context, "context");
        Paint paint = new Paint(1);
        paint.setStrokeWidth(1.0f);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(-7829368);
        Unit unit = Unit.INSTANCE;
        this.wavePaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setColor(Colors.ACQUIRE_DEPTH);
        Unit unit2 = Unit.INSTANCE;
        this.depthPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStrokeWidth(2.0f);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setColor(-29696);
        Unit unit3 = Unit.INSTANCE;
        this.tagPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.FILL);
        paint4.setColor(Colors.ACQUIRE_ZOOM_SHADOW);
        Unit unit4 = Unit.INSTANCE;
        this.zoomShadowPaint = paint4;
        this.path = new Path();
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.screenWidth = Float.valueOf(getWidth());
        this.angularFrequency = 12.0d;
        this.phaseAngle = 1.5707963267948966d;
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.param = (horizontalViewModel == null || (liveData = horizontalViewModel.getLiveData()) == null) ? null : liveData.getValue();
        setBackgroundColor(Colors.ACQUIRE_VIEW_BG);
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null) {
            syncDataViewModel.get(10, MessageID.MSG_ACQ_SARATE).observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.acquire.AcquireDepthView$$special$$inlined$let$lambda$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AcquireDepthView.this.invalidate();
                }
            });
        }
    }

    public final float getTagPosition() {
        return this.tagPosition;
    }

    public final void setTagPosition(float f) {
        this.tagPosition = f;
    }

    public final float getScreenStartPosition() {
        return this.screenStartPosition;
    }

    public final void setScreenStartPosition(float f) {
        this.screenStartPosition = f;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.tagPosition = calTagPosition(this.horizontalViewModel);
        this.amplitude = i2 >> 1;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        LiveData<HorizontalParam> liveData;
        HorizontalParam value;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        getParam();
        HorizontalViewModel horizontalViewModel = this.horizontalViewModel;
        if (horizontalViewModel != null && (liveData = horizontalViewModel.getLiveData()) != null && (value = liveData.getValue()) != null) {
            long memStart = value.getMemStart();
            long memEnd = value.getMemEnd();
            long scrStart = value.getScrStart();
            float f2 = (float) (memEnd - memStart);
            float width = (((float) (scrStart - memStart)) / f2) * getWidth();
            float scrEnd = (((float) (value.getScrEnd() - memStart)) / f2) * getWidth();
            float f3 = scrEnd - width;
            if (Math.abs(f3) < 10) {
                float f4 = 5;
                float f5 = width - f4;
                canvas.drawRect(0.0f, 0.0f, f5, getHeight(), this.depthPaint);
                float f6 = scrEnd + f4;
                canvas.drawRect(f6, 0.0f, getWidth(), getHeight(), this.depthPaint);
                this.screenWidth = Float.valueOf(f6 - f5);
                this.screenStartPosition = f5;
            } else {
                canvas.drawRect(0.0f, 0.0f, width, getHeight(), this.depthPaint);
                canvas.drawRect(scrEnd, 0.0f, getWidth(), getHeight(), this.depthPaint);
                this.screenWidth = Float.valueOf(Math.abs(f3));
                this.screenStartPosition = width;
            }
            this.tagPosition = calTagPosition(this.horizontalViewModel);
        }
        this.path.reset();
        this.path.moveTo(0.0f, getHeight());
        int width2 = getWidth();
        for (int i = 0; i < width2; i++) {
            this.path.lineTo(i, (float) ((this.amplitude * Math.sin((((1.0f * f) / getWidth()) * 2 * 3.141592653589793d * this.angularFrequency) + this.phaseAngle)) + (getHeight() / 2)));
        }
        canvas.drawPath(this.path, this.wavePaint);
        this.path.reset();
        float f7 = this.tagPosition;
        if (f7 < 0) {
            float f8 = 10;
            this.path.moveTo(0.0f, f8);
            this.path.lineTo(f8, 0.0f);
            this.path.lineTo(f8, 20);
        } else if (f7 > getWidth()) {
            float f9 = 10;
            this.path.moveTo(getWidth(), f9);
            this.path.lineTo(getWidth() - f9, 0.0f);
            this.path.lineTo(getWidth() - f9, 20);
        } else {
            float f10 = 10;
            this.path.moveTo(this.tagPosition - f10, 0.0f);
            this.path.lineTo(this.tagPosition + f10, 0.0f);
            this.path.lineTo(this.tagPosition, f10);
        }
        canvas.drawPath(this.path, this.tagPaint);
    }

    private final float calTagPosition(HorizontalViewModel horizontalViewModel) {
        LiveData<HorizontalParam> liveData;
        float valuePercent = ViewUtil.getValuePercent((horizontalViewModel == null || (liveData = horizontalViewModel.getLiveData()) == null) ? null : liveData.getValue(), 0L, false);
        float f = this.screenStartPosition;
        Float f2 = this.screenWidth;
        Intrinsics.checkNotNull(f2);
        return f + (valuePercent * f2.floatValue());
    }

    private final void getParam() {
        HorizontalParam horizontalParam = this.param;
        if (horizontalParam != null) {
            horizontalParam.readMainScale();
        }
        HorizontalParam horizontalParam2 = this.param;
        if (horizontalParam2 != null) {
            horizontalParam2.readTimeMode();
        }
        HorizontalParam horizontalParam3 = this.param;
        if (horizontalParam3 != null) {
            horizontalParam3.readSample();
        }
        HorizontalParam horizontalParam4 = this.param;
        if (horizontalParam4 != null) {
            horizontalParam4.readMemStart();
        }
        HorizontalParam horizontalParam5 = this.param;
        if (horizontalParam5 != null) {
            horizontalParam5.readMemEnd();
        }
        HorizontalParam horizontalParam6 = this.param;
        if (horizontalParam6 != null) {
            horizontalParam6.readScrStart();
        }
        HorizontalParam horizontalParam7 = this.param;
        if (horizontalParam7 != null) {
            horizontalParam7.readScrEnd();
        }
    }
}
