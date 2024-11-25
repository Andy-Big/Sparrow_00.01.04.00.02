package com.rigol.scope.utilities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BodeView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010@\u001a\u00020AJ\u0006\u0010B\u001a\u00020AJ\u0010\u0010C\u001a\u00020A2\u0006\u0010D\u001a\u00020EH\u0014J\u0018\u0010F\u001a\u00020A2\u0006\u0010G\u001a\u00020\u00112\u0006\u0010H\u001a\u00020\u0011H\u0014J(\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020\u00112\u0006\u0010K\u001a\u00020\u00112\u0006\u0010L\u001a\u00020\u00112\u0006\u0010M\u001a\u00020\u0011H\u0014J\u000e\u0010N\u001a\u00020A2\u0006\u0010\u0012\u001a\u00020\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001d\"\u0004\b-\u0010\u001fR\u001a\u0010.\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\"\"\u0004\b0\u0010$R\u001a\u00101\u001a\u000202X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u0010\u00107\u001a\u0004\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u0012\u0012\u0004\u0012\u00020>0=j\b\u0012\u0004\u0012\u00020>`?X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/rigol/scope/utilities/BodeView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bodeParam", "Lcom/rigol/scope/data/BodeParam;", "getBodeParam", "()Lcom/rigol/scope/data/BodeParam;", "setBodeParam", "(Lcom/rigol/scope/data/BodeParam;)V", "bode_lienX", "", "bodegain", "", "bodephase", "columnLinePaint", "Landroid/graphics/Paint;", "linePaint", "linePaintPhase", "linePaint_last", "path", "Landroid/graphics/Path;", "path_line", "spacing", "getSpacing", "()I", "setSpacing", "(I)V", "spacing_height", "getSpacing_height", "()F", "setSpacing_height", "(F)V", "spacing_lien", "", "getSpacing_lien", "()Z", "setSpacing_lien", "(Z)V", "spacing_lien_mun", "getSpacing_lien_mun", "setSpacing_lien_mun", "spacing_width", "getSpacing_width", "setSpacing_width", "stopFreqs", "", "getStopFreqs", "()J", "setStopFreqs", "(J)V", "syncDataViewModel", "Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "textPaint", "textPaint1", "unitBodephase", "unit_hz", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "drawBodeLien", "", "nowHZ", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "setBodephase", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class BodeView extends View {
    private BodeParam bodeParam;
    private float bode_lienX;
    private int bodegain;
    private int bodephase;
    private final Paint columnLinePaint;
    private final Paint linePaint;
    private final Paint linePaintPhase;
    private final Paint linePaint_last;
    private final Path path;
    private final Path path_line;
    private int spacing;
    private float spacing_height;
    private boolean spacing_lien;
    private int spacing_lien_mun;
    private float spacing_width;
    private long stopFreqs;
    private SyncDataViewModel syncDataViewModel;
    private final Paint textPaint;
    private final Paint textPaint1;
    private int unitBodephase;
    private ArrayList<String> unit_hz;

    public final int getSpacing() {
        return this.spacing;
    }

    public final void setSpacing(int i) {
        this.spacing = i;
    }

    public final float getSpacing_width() {
        return this.spacing_width;
    }

    public final void setSpacing_width(float f) {
        this.spacing_width = f;
    }

    public final float getSpacing_height() {
        return this.spacing_height;
    }

    public final void setSpacing_height(float f) {
        this.spacing_height = f;
    }

    public final boolean getSpacing_lien() {
        return this.spacing_lien;
    }

    public final void setSpacing_lien(boolean z) {
        this.spacing_lien = z;
    }

    public final int getSpacing_lien_mun() {
        return this.spacing_lien_mun;
    }

    public final void setSpacing_lien_mun(int i) {
        this.spacing_lien_mun = i;
    }

    public final long getStopFreqs() {
        return this.stopFreqs;
    }

    public final void setStopFreqs(long j) {
        this.stopFreqs = j;
    }

    public final BodeParam getBodeParam() {
        return this.bodeParam;
    }

    public final void setBodeParam(BodeParam bodeParam) {
        this.bodeParam = bodeParam;
    }

    public BodeView(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-1);
        Unit unit = Unit.INSTANCE;
        this.columnLinePaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(1.0f);
        paint2.setColor(-1);
        paint2.setTextSize(15.0f);
        Unit unit2 = Unit.INSTANCE;
        this.textPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.FILL);
        paint3.setStrokeWidth(1.0f);
        paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint3.setTextSize(15.0f);
        Unit unit3 = Unit.INSTANCE;
        this.textPaint1 = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.FILL);
        paint4.setStrokeWidth(1.0f);
        paint4.setColor(SupportMenu.CATEGORY_MASK);
        Unit unit4 = Unit.INSTANCE;
        this.linePaint = paint4;
        Paint paint5 = new Paint();
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(1.0f);
        paint5.setColor(SupportMenu.CATEGORY_MASK);
        Unit unit5 = Unit.INSTANCE;
        this.linePaint_last = paint5;
        Paint paint6 = new Paint();
        paint6.setStyle(Paint.Style.FILL);
        paint6.setStrokeWidth(1.0f);
        paint6.setColor(-16711936);
        Unit unit6 = Unit.INSTANCE;
        this.linePaintPhase = paint6;
        this.spacing_lien = true;
        this.spacing_lien_mun = 1;
        this.path = new Path();
        this.unitBodephase = 15;
        this.bodephase = 60;
        this.bodegain = 180;
        this.unit_hz = new ArrayList<>();
        this.path_line = new Path();
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.bodeParam = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue();
    }

    public BodeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-1);
        Unit unit = Unit.INSTANCE;
        this.columnLinePaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(1.0f);
        paint2.setColor(-1);
        paint2.setTextSize(15.0f);
        Unit unit2 = Unit.INSTANCE;
        this.textPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.FILL);
        paint3.setStrokeWidth(1.0f);
        paint3.setColor(ViewCompat.MEASURED_STATE_MASK);
        paint3.setTextSize(15.0f);
        Unit unit3 = Unit.INSTANCE;
        this.textPaint1 = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.FILL);
        paint4.setStrokeWidth(1.0f);
        paint4.setColor(SupportMenu.CATEGORY_MASK);
        Unit unit4 = Unit.INSTANCE;
        this.linePaint = paint4;
        Paint paint5 = new Paint();
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(1.0f);
        paint5.setColor(SupportMenu.CATEGORY_MASK);
        Unit unit5 = Unit.INSTANCE;
        this.linePaint_last = paint5;
        Paint paint6 = new Paint();
        paint6.setStyle(Paint.Style.FILL);
        paint6.setStrokeWidth(1.0f);
        paint6.setColor(-16711936);
        Unit unit6 = Unit.INSTANCE;
        this.linePaintPhase = paint6;
        this.spacing_lien = true;
        this.spacing_lien_mun = 1;
        this.path = new Path();
        this.unitBodephase = 15;
        this.bodephase = 60;
        this.bodegain = 180;
        this.unit_hz = new ArrayList<>();
        this.path_line = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Long valueOf;
        int i;
        double d;
        char c;
        char c2;
        double d2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        nowHZ();
        float f = 9;
        float f2 = (this.spacing_height - 60) / f;
        BodeParam bodeParam = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam != null ? Long.valueOf(bodeParam.getBodeStopFreq()) : null);
        double longValue = valueOf.longValue() / ((float) this.stopFreqs);
        double size = this.spacing_width / (this.unit_hz.size() + longValue);
        BodeParam bodeParam2 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam2);
        bodeParam2.setSpacing_width_unit(size);
        BodeParam bodeParam3 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam3);
        bodeParam3.setSpacing_heightunit(f2);
        this.spacing_height = this.spacing_height;
        int i2 = 1;
        for (int i3 = 1; i3 < 10; i3++) {
            this.path.reset();
            float f3 = (i3 * f2) + 20;
            this.path.moveTo(60.0f, f3);
            this.path.lineTo(60.0f, f3);
            this.path.lineTo(this.spacing_width - 60.0f, f3);
            if (i3 == 1) {
                canvas.drawText(String.valueOf(this.bodephase), 30.0f, f3, this.linePaint);
                canvas.drawText(String.valueOf(this.bodegain) + "°", this.spacing_width - 60.0f, f3, this.linePaintPhase);
                canvas.drawText(String.valueOf(this.bodephase) + "dB", 30.0f, f3, this.linePaint);
                canvas.drawPath(this.path, this.columnLinePaint);
            } else {
                canvas.drawText(String.valueOf(this.bodephase), 30.0f, f3, this.linePaint);
                canvas.drawText(String.valueOf(this.bodegain), this.spacing_width - 60.0f, f3, this.linePaintPhase);
                canvas.drawPath(this.path, this.columnLinePaint);
            }
            if (i3 == 9) {
                BodeParam bodeParam4 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam4);
                bodeParam4.setSpacing_width_middley(292.0f);
            }
            this.bodephase -= this.unitBodephase;
            this.bodegain -= 45;
        }
        int i4 = 0;
        int size2 = this.unit_hz.size();
        while (i4 < size2) {
            if (this.unit_hz.size() - i2 != i4) {
                if (this.unit_hz.size() - 2 == i4) {
                    double d3 = 100;
                    double size3 = ((this.unit_hz.size() - i2) * size) + (((float) longValue) * size) + d3;
                    double d4 = i4 * size;
                    double d5 = d3 + d4;
                    i = size2;
                    d2 = longValue;
                    if (size3 - d5 > 300) {
                        canvas.drawText(this.unit_hz.get(i4), (float) d5, (f2 * f) + 40, this.textPaint);
                    }
                    this.path.reset();
                    float f4 = (float) (d4 + 120);
                    float f5 = f2 * f;
                    float f6 = 10 + f5;
                    this.path.moveTo(f4, f6);
                    this.path.lineTo(f4, f6);
                    this.path.lineTo(f4, f5 + 20);
                    canvas.drawPath(this.path, this.linePaint_last);
                    this.bodephase = 60;
                    this.bodegain = 180;
                } else {
                    i = size2;
                    d2 = longValue;
                    double d6 = i4 * size;
                    float f7 = f2 * f;
                    canvas.drawText(this.unit_hz.get(i4), (float) (100 + d6), 40 + f7, this.textPaint);
                    this.path.reset();
                    float f8 = (float) (d6 + 120);
                    float f9 = 10 + f7;
                    this.path.moveTo(f8, f9);
                    this.path.lineTo(f8, f9);
                    this.path.lineTo(f8, f7 + 20);
                    canvas.drawPath(this.path, this.linePaint_last);
                    this.bodephase = 60;
                    this.bodegain = 180;
                }
                d = d2;
                c = '\n';
                c2 = 20;
            } else {
                i = size2;
                d = longValue;
                float f10 = (float) (((i4 - 1) * size) + (((float) d) * size));
                float f11 = f2 * f;
                canvas.drawText(this.unit_hz.get(i4), 100 + f10, 40 + f11, this.textPaint);
                this.path.reset();
                float f12 = f10 + 120;
                c = '\n';
                float f13 = 10 + f11;
                this.path.moveTo(f12, f13);
                this.path.lineTo(f12, f13);
                c2 = 20;
                this.path.lineTo(f12, f11 + 20);
                canvas.drawPath(this.path, this.linePaint_last);
                this.bodephase = 60;
                this.bodegain = 180;
            }
            i4++;
            size2 = i;
            longValue = d;
            i2 = 1;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.spacing_width = View.MeasureSpec.getSize(i);
        this.spacing_height = View.MeasureSpec.getSize(i2);
        this.columnLinePaint.setPathEffect(new DashPathEffect(new float[]{2.0f, 2.0f}, 0.0f));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    public final void drawBodeLien() {
        invalidate();
    }

    public final void nowHZ() {
        this.unit_hz.clear();
        BodeParam bodeParam = this.bodeParam;
        Long valueOf = bodeParam != null ? Long.valueOf(bodeParam.getBodeStartFreq()) : null;
        BodeParam bodeParam2 = this.bodeParam;
        Long valueOf2 = bodeParam2 != null ? Long.valueOf(bodeParam2.getBodeStopFreq()) : null;
        this.unit_hz.add(ViewUtil.subNumber(Intrinsics.stringPlus(valueOf != null ? UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(valueOf.longValue()) : null, ServiceEnum.Unit.Unit_hz.value2), 6));
        if (valueOf != null) {
            do {
                Intrinsics.checkNotNull(valueOf2);
                long j = 10;
                if (valueOf2.longValue() / (valueOf.longValue() * j) > 1) {
                    this.unit_hz.add(ViewUtil.subNumber(UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(valueOf.longValue() * j) + ServiceEnum.Unit.Unit_hz.value2, 6));
                } else {
                    this.unit_hz.add(ViewUtil.subNumber(UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(valueOf2.longValue()) + ServiceEnum.Unit.Unit_hz.value2, 6));
                }
                valueOf = Long.valueOf(valueOf.longValue() * j);
                this.stopFreqs = valueOf.longValue();
            } while (valueOf.longValue() < valueOf2.longValue());
            BodeParam bodeParam3 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam3);
            bodeParam3.setBodeDataWidth(this.unit_hz.size());
        }
        BodeParam bodeParam32 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam32);
        bodeParam32.setBodeDataWidth(this.unit_hz.size());
    }

    public final void setBodephase(int i) {
        this.bodephase = i;
        this.linePaint.reset();
        this.unitBodephase = i / 4;
        this.linePaint.setStyle(Paint.Style.FILL);
        this.linePaint.setStrokeWidth(1.0f);
        this.linePaint.setColor(SupportMenu.CATEGORY_MASK);
        invalidate();
    }
}
