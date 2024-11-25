package com.rigol.scope.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import com.rigol.scope.utilities.Colors;
import com.rigol.scope.utilities.ViewUtil;
import java.util.Random;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: DecodeInfoView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J \u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0002J0\u00102\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u00103\u001a\u00020\u000f2\u0006\u00104\u001a\u0002002\u0006\u00105\u001a\u0002002\u0006\u00106\u001a\u000200H\u0002J\u0010\u00107\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0014R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fRB\u0010\u0010\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\u000e2\u0014\u0010\r\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0018\u00010\u000e@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\f¨\u00068"}, d2 = {"Lcom/rigol/scope/views/DecodeInfoView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "bgPaint", "Landroid/graphics/Paint;", "getBgPaint", "()Landroid/graphics/Paint;", "setBgPaint", "(Landroid/graphics/Paint;)V", "value", "", "", "data", "getData", "()[[Ljava/lang/String;", "setData", "([[Ljava/lang/String;)V", "[[Ljava/lang/String;", "linePaint", "getLinePaint", "setLinePaint", "paint", "getPaint", "setPaint", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "setPath", "(Landroid/graphics/Path;)V", "random", "Ljava/util/Random;", "getRandom", "()Ljava/util/Random;", "setRandom", "(Ljava/util/Random;)V", "textPaint", "getTextPaint", "setTextPaint", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "start", "", "end", "drawText", "text", "x", "y", "width", "onDraw", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DecodeInfoView extends View {
    private Paint bgPaint;
    private String[][] data;
    private Paint linePaint;
    private Paint paint;
    private Path path;
    private Random random;
    private Paint textPaint;

    public DecodeInfoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        paint.setColor(-16776961);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);
        Unit unit = Unit.INSTANCE;
        this.paint = paint;
        Paint paint2 = new Paint();
        paint2.setColor(Color.argb(128, 255, 0, 0));
        paint2.setStyle(Paint.Style.FILL);
        Unit unit2 = Unit.INSTANCE;
        this.linePaint = paint2;
        Paint paint3 = new Paint();
        paint3.setColor(Color.argb(128, 128, 128, 128));
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);
        Unit unit3 = Unit.INSTANCE;
        this.bgPaint = paint3;
        Paint paint4 = new Paint();
        paint4.setColor(-1);
        paint4.setAntiAlias(true);
        paint4.setTextSize(18.0f);
        paint4.setTextAlign(Paint.Align.CENTER);
        Unit unit4 = Unit.INSTANCE;
        this.textPaint = paint4;
        this.random = new Random();
    }

    public final Path getPath() {
        return this.path;
    }

    public final void setPath(Path path) {
        this.path = path;
    }

    public final Paint getPaint() {
        return this.paint;
    }

    public final void setPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.paint = paint;
    }

    public final Paint getLinePaint() {
        return this.linePaint;
    }

    public final void setLinePaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.linePaint = paint;
    }

    public final Paint getBgPaint() {
        return this.bgPaint;
    }

    public final void setBgPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.bgPaint = paint;
    }

    public final Paint getTextPaint() {
        return this.textPaint;
    }

    public final void setTextPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.textPaint = paint;
    }

    public final Random getRandom() {
        return this.random;
    }

    public final void setRandom(Random random) {
        Intrinsics.checkNotNullParameter(random, "<set-?>");
        this.random = random;
    }

    public final String[][] getData() {
        return this.data;
    }

    public final void setData(String[][] strArr) {
        this.data = strArr;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String[][] strArr;
        String[][] strArr2;
        String[][] strArr3;
        String[][] strArr4;
        String[][] strArr5;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        super.onDraw(canvas);
        String[][] strArr6 = this.data;
        if (strArr6 == null) {
            return;
        }
        Intrinsics.checkNotNull(strArr6);
        char c = 0;
        if (strArr6.length == 0) {
            drawLine(canvas2, 0, getWidth());
            return;
        }
        float width = getWidth() / 1000.0f;
        Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
        char c2 = 2;
        float f = (((fontMetrics.bottom - fontMetrics.top) / 2) - fontMetrics.bottom) + 20;
        String[][] strArr7 = this.data;
        Intrinsics.checkNotNull(strArr7);
        int parseInt = Integer.parseInt(strArr7[0][0]);
        if (parseInt > 0) {
            drawLine(canvas2, 0, (int) (parseInt * width));
        }
        String[][] strArr8 = this.data;
        Intrinsics.checkNotNull(strArr8);
        int length = strArr8.length;
        int i = 0;
        while (i < length) {
            Intrinsics.checkNotNull(this.data);
            int parseInt2 = (int) (Integer.parseInt(strArr3[i][c]) * width);
            Intrinsics.checkNotNull(this.data);
            int parseInt3 = (int) (Integer.parseInt(strArr4[i][1]) * width);
            int i2 = parseInt2 + parseInt3;
            Paint paint = this.paint;
            SparseIntArray decode_colors = Colors.INSTANCE.getDECODE_COLORS();
            String[][] strArr9 = this.data;
            Intrinsics.checkNotNull(strArr9);
            paint.setColor(decode_colors.get(Integer.parseInt(strArr9[i][c2])));
            ViewUtil.drawPolygon(canvas, parseInt2, parseInt3, this.paint, 40, 20, 10, false, 2);
            ViewUtil.drawPolygon(canvas, parseInt2, parseInt3, this.bgPaint, 40, 20, 10, true, 2);
            String[][] strArr10 = this.data;
            Intrinsics.checkNotNull(strArr10);
            int i3 = length;
            float f2 = f;
            char c3 = c2;
            char c4 = c;
            Canvas canvas3 = canvas2;
            drawText(canvas, strArr10[i][3], parseInt2 + (parseInt3 / 2), (int) f, parseInt3);
            i++;
            String[][] strArr11 = this.data;
            Intrinsics.checkNotNull(strArr11);
            if (i < strArr11.length) {
                Intrinsics.checkNotNull(this.data);
                drawLine(canvas3, i2, (int) (Integer.parseInt(strArr5[i][c4]) * width));
            }
            c2 = c3;
            canvas2 = canvas3;
            length = i3;
            f = f2;
            c = c4;
        }
        Canvas canvas4 = canvas2;
        String[][] strArr12 = this.data;
        Intrinsics.checkNotNull(strArr12);
        Intrinsics.checkNotNull(this.data);
        int parseInt4 = Integer.parseInt(strArr12[strArr.length - 1][c]);
        String[][] strArr13 = this.data;
        Intrinsics.checkNotNull(strArr13);
        Intrinsics.checkNotNull(this.data);
        int parseInt5 = parseInt4 + Integer.parseInt(strArr13[strArr2.length - 1][1]);
        if (parseInt5 < 1000) {
            drawLine(canvas4, (int) (parseInt5 * width), getWidth());
        }
    }

    private final void drawText(Canvas canvas, String str, int i, int i2, int i3) {
        float f = i3;
        if (this.textPaint.measureText(str) >= f) {
            if (this.textPaint.measureText(str) >= f) {
                return;
            }
            canvas.drawText("···", i, i2, this.textPaint);
            return;
        }
        canvas.drawText(str, i, i2, this.textPaint);
    }

    private final void drawLine(Canvas canvas, int i, int i2) {
        if (i2 - i < 0) {
            return;
        }
        canvas.drawRect(i, 18, i2, 22, this.linePaint);
    }
}
