package com.rigol.scope.views.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import com.rigol.scope.cil.ServiceEnum;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GridView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0016\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J \u0010-\u001a\u00020'2\u0006\u0010.\u001a\u00020\t2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J \u0010/\u001a\u00020'2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J \u00102\u001a\u00020'2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u00103\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J \u00104\u001a\u00020'2\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J \u00107\u001a\u00020'2\u0006\u00108\u001a\u00020\t2\u0006\u00106\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0002J \u00109\u001a\u00020'2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J \u0010:\u001a\u00020'2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020\t2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010;\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010<\u001a\u00020*2\u0006\u00105\u001a\u00020\tH\u0002J\u0010\u0010=\u001a\u00020'2\u0006\u0010+\u001a\u00020,H\u0014J(\u0010>\u001a\u00020'2\u0006\u0010?\u001a\u00020\t2\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\t2\u0006\u0010B\u001a\u00020\tH\u0014J\u000e\u0010C\u001a\u00020'2\u0006\u0010D\u001a\u00020*J\b\u0010E\u001a\u00020'H\u0002J\b\u0010F\u001a\u00020'H\u0002R6\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u000e\u0010\u001d\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006G"}, d2 = {"Lcom/rigol/scope/views/grid/GridView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "", "columnContents", "getColumnContents", "()[Ljava/lang/String;", "setColumnContents", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "columnLinePaint", "Landroid/graphics/Paint;", "isShowLine", "", "path", "Landroid/graphics/Path;", "rowContents", "getRowContents", "setRowContents", "rowLinePaint", "scaleLinePaint", "solidLinePaint", "type", "Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;", "getType", "()Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;", "setType", "(Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;)V", "drawColumnLine", "", "j", "columnWidth", "", "canvas", "Landroid/graphics/Canvas;", "drawColumnLines", "columnContentsSize", "drawColumnMiddleScale", "scaleSize", "totalSize", "drawColumnSideScaleLine", "drawColumns", "drawRowLine", "i", "rowHeight", "drawRowLines", "rowContentsSize", "drawRowMiddleScaleLine", "drawRowSideScaleLine", "drawRows", "getScaleLineSize", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setLineAlpha", Key.ALPHA, "updateColumnLinePathEffect", "updateRowLinePathEffect", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class GridView extends View {
    private String[] columnContents;
    private final Paint columnLinePaint;
    private boolean isShowLine;
    private final Path path;
    private String[] rowContents;
    private final Paint rowLinePaint;
    private final Paint scaleLinePaint;
    private final Paint solidLinePaint;
    private ServiceEnum.EWaveGrids type;

    public final String[] getColumnContents() {
        return this.columnContents;
    }

    public final void setColumnContents(String[] strArr) {
        this.columnContents = strArr;
        updateRowLinePathEffect();
    }

    private final void updateRowLinePathEffect() {
        String[] strArr = this.columnContents;
        Integer valueOf = strArr != null ? Integer.valueOf(strArr.length) : null;
        if (valueOf == null) {
            return;
        }
        this.rowLinePaint.setPathEffect(new DashPathEffect(new float[]{1.0f, (((getWidth() - 1) / (valueOf.intValue() - 1)) / 10) - 1}, 0));
    }

    public final String[] getRowContents() {
        return this.rowContents;
    }

    public final void setRowContents(String[] strArr) {
        this.rowContents = strArr;
        updateColumnLinePathEffect();
    }

    private final void updateColumnLinePathEffect() {
        String[] strArr = this.rowContents;
        Integer valueOf = strArr != null ? Integer.valueOf(strArr.length) : null;
        if (valueOf == null) {
            return;
        }
        this.columnLinePaint.setPathEffect(new DashPathEffect(new float[]{1.0f, (((getHeight() - 1) / (valueOf.intValue() - 1)) / 10) - 1}, 0));
    }

    public final ServiceEnum.EWaveGrids getType() {
        return this.type;
    }

    public final void setType(ServiceEnum.EWaveGrids eWaveGrids) {
        Intrinsics.checkNotNullParameter(eWaveGrids, "<set-?>");
        this.type = eWaveGrids;
    }

    public GridView(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-1);
        Unit unit = Unit.INSTANCE;
        this.columnLinePaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(1.0f);
        paint2.setColor(-1);
        Unit unit2 = Unit.INSTANCE;
        this.rowLinePaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.0f);
        paint3.setPathEffect(new PathEffect());
        paint3.setColor(-1);
        Unit unit3 = Unit.INSTANCE;
        this.scaleLinePaint = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(1.0f);
        paint4.setPathEffect(new PathEffect());
        paint4.setColor(-3355444);
        Unit unit4 = Unit.INSTANCE;
        this.solidLinePaint = paint4;
        this.path = new Path();
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowLine = true;
    }

    public GridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-1);
        Unit unit = Unit.INSTANCE;
        this.columnLinePaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(1.0f);
        paint2.setColor(-1);
        Unit unit2 = Unit.INSTANCE;
        this.rowLinePaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.0f);
        paint3.setPathEffect(new PathEffect());
        paint3.setColor(-1);
        Unit unit3 = Unit.INSTANCE;
        this.scaleLinePaint = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(1.0f);
        paint4.setPathEffect(new PathEffect());
        paint4.setColor(-3355444);
        Unit unit4 = Unit.INSTANCE;
        this.solidLinePaint = paint4;
        this.path = new Path();
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowLine = true;
    }

    public GridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(1.0f);
        paint.setColor(-1);
        Unit unit = Unit.INSTANCE;
        this.columnLinePaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(1.0f);
        paint2.setColor(-1);
        Unit unit2 = Unit.INSTANCE;
        this.rowLinePaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.0f);
        paint3.setPathEffect(new PathEffect());
        paint3.setColor(-1);
        Unit unit3 = Unit.INSTANCE;
        this.scaleLinePaint = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(1.0f);
        paint4.setPathEffect(new PathEffect());
        paint4.setColor(-3355444);
        Unit unit4 = Unit.INSTANCE;
        this.solidLinePaint = paint4;
        this.path = new Path();
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowLine = true;
    }

    public final void setLineAlpha(float f) {
        float f2 = f * 255;
        int i = (int) f2;
        this.columnLinePaint.setAlpha(i);
        this.rowLinePaint.setAlpha(i);
        this.scaleLinePaint.setAlpha(i);
        this.solidLinePaint.setAlpha((int) (f2 * 0.5d));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            updateRowLinePathEffect();
        }
        if (i2 != i4) {
            updateColumnLinePathEffect();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawColumns(canvas);
        drawRows(canvas);
    }

    private final void drawRows(Canvas canvas) {
        String[] strArr = this.rowContents;
        Intrinsics.checkNotNull(strArr);
        int length = strArr.length;
        drawRowLines(length, getHeight() / (length - 1), canvas);
    }

    private final void drawRowLines(int i, float f, Canvas canvas) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        if (this.isShowLine) {
            if (this.type == ServiceEnum.EWaveGrids.GRID_IS_FULL) {
                int i2 = i - 1;
                for (int i3 = 1; i3 < i2; i3++) {
                    if (i % 2 == 0 || i3 != i2 / 2) {
                        drawRowLine(i3, f, canvas);
                    }
                }
                Intrinsics.checkNotNull(this.columnContents);
                float width = (getWidth() / (strArr3.length - 1)) / 5;
                String[] strArr4 = this.columnContents;
                Intrinsics.checkNotNull(strArr4);
                drawRowMiddleScaleLine(width, ((strArr4.length - 1) * 5) + 1, canvas);
            } else if (this.type == ServiceEnum.EWaveGrids.GRID_IS_HALF) {
                Intrinsics.checkNotNull(this.columnContents);
                float width2 = (getWidth() / (strArr.length - 1)) / 5;
                String[] strArr5 = this.columnContents;
                Intrinsics.checkNotNull(strArr5);
                drawRowMiddleScaleLine(width2, ((strArr5.length - 1) * 5) + 1, canvas);
            }
            Intrinsics.checkNotNull(this.columnContents);
            float width3 = (getWidth() / (strArr2.length - 1)) / 5;
            String[] strArr6 = this.columnContents;
            Intrinsics.checkNotNull(strArr6);
            drawRowSideScaleLine(width3, ((strArr6.length - 1) * 5) + 1, canvas);
        }
    }

    private final void drawRowLine(int i, float f, Canvas canvas) {
        float f2 = i * f;
        this.path.reset();
        this.path.moveTo(0, f2);
        this.path.lineTo(getWidth(), f2);
        canvas.drawPath(this.path, this.rowLinePaint);
    }

    private final void drawRowSideScaleLine(float f, int i, Canvas canvas) {
        int i2 = 0;
        float f2 = 0;
        canvas.drawLine(f2, f2, getWidth(), f2, this.scaleLinePaint);
        int i3 = 0;
        while (i3 < i) {
            float scaleLineSize = getScaleLineSize(i3);
            float strokeWidth = i3 == i + (-1) ? (i3 * f) - this.scaleLinePaint.getStrokeWidth() : i3 * f;
            canvas.drawLine(strokeWidth, f2, strokeWidth, scaleLineSize, this.scaleLinePaint);
            i3++;
        }
        float height = getHeight() - this.scaleLinePaint.getStrokeWidth();
        canvas.drawLine(f2, height, getWidth(), height, this.scaleLinePaint);
        while (i2 < i) {
            float scaleLineSize2 = getScaleLineSize(i2);
            float strokeWidth2 = i2 == i + (-1) ? (i2 * f) - this.scaleLinePaint.getStrokeWidth() : i2 * f;
            canvas.drawLine(strokeWidth2, height - scaleLineSize2, strokeWidth2, height, this.scaleLinePaint);
            i2++;
        }
    }

    private final void drawRowMiddleScaleLine(float f, int i, Canvas canvas) {
        this.path.reset();
        float f2 = 2;
        float height = getHeight() / f2;
        int i2 = 0;
        canvas.drawLine(0, height, getWidth(), height, this.solidLinePaint);
        while (i2 < i) {
            float scaleLineSize = getScaleLineSize(i2);
            float strokeWidth = i2 == i + (-1) ? (i2 * f) - this.scaleLinePaint.getStrokeWidth() : i2 * f;
            float f3 = scaleLineSize / f2;
            canvas.drawLine(strokeWidth, height - f3, strokeWidth, height + f3, this.scaleLinePaint);
            i2++;
        }
    }

    private final float getScaleLineSize(int i) {
        return i % 5 == 0 ? 10 : 5;
    }

    private final void drawColumnSideScaleLine(float f, int i, Canvas canvas) {
        int i2 = 0;
        float f2 = 0;
        canvas.drawLine(f2, f2, f2, getHeight(), this.scaleLinePaint);
        int i3 = 0;
        while (i3 < i) {
            float scaleLineSize = getScaleLineSize(i3);
            float strokeWidth = i3 == i + (-1) ? (i3 * f) - this.scaleLinePaint.getStrokeWidth() : i3 * f;
            canvas.drawLine(f2, strokeWidth, scaleLineSize, strokeWidth, this.scaleLinePaint);
            i3++;
        }
        float width = getWidth() - this.scaleLinePaint.getStrokeWidth();
        canvas.drawLine(width, f2, width, getHeight(), this.scaleLinePaint);
        while (i2 < i) {
            float scaleLineSize2 = getScaleLineSize(i2);
            float strokeWidth2 = i2 == i + (-1) ? (i2 * f) - this.scaleLinePaint.getStrokeWidth() : i2 * f;
            canvas.drawLine(getWidth() - scaleLineSize2, strokeWidth2, getWidth(), strokeWidth2, this.scaleLinePaint);
            i2++;
        }
    }

    private final void drawColumnMiddleScale(float f, int i, Canvas canvas) {
        float f2 = 2;
        float width = getWidth() / f2;
        int i2 = 0;
        canvas.drawLine(width, 0, width, getHeight(), this.solidLinePaint);
        while (i2 < i) {
            float scaleLineSize = getScaleLineSize(i2);
            float strokeWidth = i2 == i + (-1) ? (i2 * f) - this.scaleLinePaint.getStrokeWidth() : i2 * f;
            float f3 = scaleLineSize / f2;
            canvas.drawLine(width - f3, strokeWidth, width + f3, strokeWidth, this.scaleLinePaint);
            i2++;
        }
    }

    private final void drawColumns(Canvas canvas) {
        String[] strArr = this.columnContents;
        Intrinsics.checkNotNull(strArr);
        int length = strArr.length;
        drawColumnLines(length, getWidth() / (length - 1), canvas);
    }

    private final void drawColumnLines(int i, float f, Canvas canvas) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        if (this.isShowLine) {
            if (this.type == ServiceEnum.EWaveGrids.GRID_IS_FULL) {
                int i2 = i - 1;
                for (int i3 = 1; i3 < i2; i3++) {
                    if (i % 2 == 0 || i3 != i2 / 2) {
                        drawColumnLine(i3, f, canvas);
                    }
                }
                Intrinsics.checkNotNull(this.rowContents);
                float height = (getHeight() / (strArr3.length - 1)) / 5;
                String[] strArr4 = this.rowContents;
                Intrinsics.checkNotNull(strArr4);
                drawColumnMiddleScale(height, ((strArr4.length - 1) * 5) + 1, canvas);
            } else if (this.type == ServiceEnum.EWaveGrids.GRID_IS_HALF) {
                Intrinsics.checkNotNull(this.rowContents);
                float height2 = (getHeight() / (strArr.length - 1)) / 5;
                String[] strArr5 = this.rowContents;
                Intrinsics.checkNotNull(strArr5);
                drawColumnMiddleScale(height2, ((strArr5.length - 1) * 5) + 1, canvas);
            }
            Intrinsics.checkNotNull(this.rowContents);
            float height3 = (getHeight() / (strArr2.length - 1)) / 5;
            String[] strArr6 = this.rowContents;
            Intrinsics.checkNotNull(strArr6);
            drawColumnSideScaleLine(height3, ((strArr6.length - 1) * 5) + 1, canvas);
        }
    }

    private final void drawColumnLine(int i, float f, Canvas canvas) {
        float f2 = i * f;
        this.path.reset();
        this.path.moveTo(f2, 0);
        this.path.lineTo(f2, getHeight());
        canvas.drawPath(this.path, this.columnLinePaint);
    }
}
