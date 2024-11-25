package com.rigol.scope.views.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.rigol.scope.cil.ServiceEnum;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: XRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0016\u0018\u0000 52\u00020\u0001:\u00015B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\tH\u0002J \u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\t2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u00101\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00102\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0014J\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\tR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR\u001a\u0010\u001e\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0018\"\u0004\b\u001f\u0010\u001aR\u001a\u0010 \u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0018\"\u0004\b!\u0010\u001aR\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00066"}, d2 = {"Lcom/rigol/scope/views/grid/XRulerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "columnContents", "", "", "getColumnContents", "()[Ljava/lang/String;", "setColumnContents", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "columnTextPaint", "Landroid/graphics/Paint;", "fromStart", "", "getFromStart", "()Z", "setFromStart", "(Z)V", "fromTop", "getFromTop", "setFromTop", "isShowAllCol", "setShowAllCol", "isShowRuler", "setShowRuler", "type", "Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;", "getType", "()Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;", "setType", "(Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;)V", "drawColumn", "", "canvas", "Landroid/graphics/Canvas;", "columnWidth", "", "i", "drawColumnContents", "columnContentsSize", "drawColumns", "onDraw", "setColumnTextColor", "color", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class XRulerView extends View {
    public static final Companion Companion = new Companion(null);
    public static final float DEFAULT_PADDING = 10.0f;
    public static final float DEFAULT_TEXT_SIZE = 16.0f;
    private String[] columnContents;
    private final Paint columnTextPaint;
    private boolean fromStart;
    private boolean fromTop;
    private boolean isShowAllCol;
    private boolean isShowRuler;
    private ServiceEnum.EWaveGrids type;

    public final String[] getColumnContents() {
        return this.columnContents;
    }

    public final void setColumnContents(String[] strArr) {
        this.columnContents = strArr;
    }

    public final boolean getFromTop() {
        return this.fromTop;
    }

    public final void setFromTop(boolean z) {
        this.fromTop = z;
    }

    public final boolean getFromStart() {
        return this.fromStart;
    }

    public final void setFromStart(boolean z) {
        this.fromStart = z;
    }

    public final boolean isShowAllCol() {
        return this.isShowAllCol;
    }

    public final void setShowAllCol(boolean z) {
        this.isShowAllCol = z;
    }

    public final ServiceEnum.EWaveGrids getType() {
        return this.type;
    }

    public final void setType(ServiceEnum.EWaveGrids eWaveGrids) {
        Intrinsics.checkNotNullParameter(eWaveGrids, "<set-?>");
        this.type = eWaveGrids;
    }

    public final boolean isShowRuler() {
        return this.isShowRuler;
    }

    public final void setShowRuler(boolean z) {
        this.isShowRuler = z;
    }

    public final void setColumnTextColor(int i) {
        this.columnTextPaint.setColor(i);
    }

    public XRulerView(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowRuler = true;
    }

    public XRulerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowRuler = true;
    }

    public XRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowRuler = true;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawColumns(canvas);
    }

    private final void drawColumns(Canvas canvas) {
        String[] strArr = this.columnContents;
        Intrinsics.checkNotNull(strArr);
        int length = strArr.length;
        drawColumnContents(length, canvas, getWidth() / (length - 1));
    }

    private final void drawColumnContents(int i, Canvas canvas, float f) {
        int i2;
        float width;
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.columnContents;
        Intrinsics.checkNotNull(strArr);
        for (String str : strArr) {
            sb.append(str);
        }
        float measureText = this.columnTextPaint.measureText(sb.toString());
        if (measureText > getWidth()) {
            if (measureText % getWidth() == 0.0f) {
                width = measureText / getWidth();
            } else {
                width = (measureText / getWidth()) + 1;
            }
            i2 = (int) width;
        } else {
            i2 = ((float) getWidth()) - measureText < ((float) 30) ? 2 : 1;
        }
        int i3 = i / i2;
        if (i % i2 != 0) {
            i3++;
        }
        int i4 = i / 2;
        if (i % 2 != 0) {
            i4++;
        }
        if (this.isShowRuler) {
            int i5 = 1;
            for (int i6 = i3 - 2; i5 < i4 && i6 >= 0; i6 -= 2) {
                if (i5 == 0) {
                    if (this.fromStart) {
                        drawColumn(canvas, f, (i - 1) - i5);
                    } else {
                        drawColumn(canvas, f, i5);
                    }
                } else {
                    drawColumn(canvas, f, i5);
                    drawColumn(canvas, f, (i - 1) - i5);
                }
                i5 += i2;
            }
            if (this.isShowAllCol) {
                drawColumn(canvas, f, 0);
                drawColumn(canvas, f, i - 1);
            }
        }
    }

    private final void drawColumn(Canvas canvas, float f, int i) {
        String[] strArr = this.columnContents;
        Intrinsics.checkNotNull(strArr);
        String str = strArr[i];
        if (TextUtils.isEmpty(str)) {
            return;
        }
        float f2 = i * f;
        float measureText = this.columnTextPaint.measureText(str);
        if (i == 0) {
            canvas.drawText(str, 10.0f, this.fromTop ? 16.0f : getHeight(), this.columnTextPaint);
            canvas.drawText(str, 10.0f, this.fromTop ? 16.0f : getHeight(), this.columnTextPaint);
            return;
        }
        String[] strArr2 = this.columnContents;
        Intrinsics.checkNotNull(strArr2);
        if (i == strArr2.length - 1) {
            canvas.drawText(str, (f2 - measureText) - 10.0f, this.fromTop ? 16.0f : getHeight(), this.columnTextPaint);
        } else {
            canvas.drawText(str, f2 - (measureText / 2), this.fromTop ? 16.0f : getHeight() - 10.0f, this.columnTextPaint);
        }
    }

    /* compiled from: XRulerView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/views/grid/XRulerView$Companion;", "", "()V", "DEFAULT_PADDING", "", "DEFAULT_TEXT_SIZE", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
