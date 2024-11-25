package com.rigol.scope.views.grid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: YRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\b\u0016\u0018\u0000 52\u00020\u0001:\u00015B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\tH\u0002J \u0010/\u001a\u00020)2\u0006\u00100\u001a\u00020\t2\u0006\u0010,\u001a\u00020-2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00101\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0002J\u0010\u00102\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0014J\u000e\u00103\u001a\u00020)2\u0006\u00104\u001a\u00020\tR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u001a\u0010\u001d\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0012\"\u0004\b\u001e\u0010\u0014R$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u0010\n\u0002\u0010&\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u000e\u0010'\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/rigol/scope/views/grid/YRulerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "columnTextPaint", "Landroid/graphics/Paint;", "getColumnTextPaint", "()Landroid/graphics/Paint;", "fromStart", "", "getFromStart", "()Z", "setFromStart", "(Z)V", "horizontal", "Lcom/rigol/scope/data/HorizontalParam;", "getHorizontal", "()Lcom/rigol/scope/data/HorizontalParam;", "setHorizontal", "(Lcom/rigol/scope/data/HorizontalParam;)V", "isShowAllRow", "setShowAllRow", "isShowRuler", "setShowRuler", "rowContents", "", "", "getRowContents", "()[Ljava/lang/String;", "setRowContents", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "rowTextPaint", "drawRowContent", "", "canvas", "Landroid/graphics/Canvas;", "rowHeight", "", "i", "drawRowContents", "rowContentsSize", "drawRows", "onDraw", "setRowTextColor", "color", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class YRulerView extends View {
    public static final Companion Companion = new Companion(null);
    public static final float DEFAULT_PADDING = 10.0f;
    public static final float DEFAULT_TEXT_SIZE = 16.0f;
    private final Paint columnTextPaint;
    private boolean fromStart;
    private HorizontalParam horizontal;
    private boolean isShowAllRow;
    private boolean isShowRuler;
    private String[] rowContents;
    private final Paint rowTextPaint;

    public final Paint getColumnTextPaint() {
        return this.columnTextPaint;
    }

    public final String[] getRowContents() {
        return this.rowContents;
    }

    public final void setRowContents(String[] strArr) {
        this.rowContents = strArr;
    }

    public final boolean getFromStart() {
        return this.fromStart;
    }

    public final void setFromStart(boolean z) {
        this.fromStart = z;
    }

    public final boolean isShowAllRow() {
        return this.isShowAllRow;
    }

    public final void setShowAllRow(boolean z) {
        this.isShowAllRow = z;
    }

    public final boolean isShowRuler() {
        return this.isShowRuler;
    }

    public final void setShowRuler(boolean z) {
        this.isShowRuler = z;
    }

    public final void setRowTextColor(int i) {
        this.rowTextPaint.setColor(i);
    }

    public YRulerView(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(1.0f);
        paint2.setAntiAlias(true);
        paint2.setTextSize(16.0f);
        paint2.setColor(-3355444);
        Unit unit2 = Unit.INSTANCE;
        this.rowTextPaint = paint2;
        this.isShowRuler = true;
        this.horizontal = ((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue();
    }

    public YRulerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(1.0f);
        paint2.setAntiAlias(true);
        paint2.setTextSize(16.0f);
        paint2.setColor(-3355444);
        Unit unit2 = Unit.INSTANCE;
        this.rowTextPaint = paint2;
        this.isShowRuler = true;
        this.horizontal = ((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue();
    }

    public YRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(1.0f);
        paint2.setAntiAlias(true);
        paint2.setTextSize(16.0f);
        paint2.setColor(-3355444);
        Unit unit2 = Unit.INSTANCE;
        this.rowTextPaint = paint2;
        this.isShowRuler = true;
        this.horizontal = ((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue();
    }

    public final HorizontalParam getHorizontal() {
        return this.horizontal;
    }

    public final void setHorizontal(HorizontalParam horizontalParam) {
        this.horizontal = horizontalParam;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawRows(canvas);
    }

    private final void drawRows(Canvas canvas) {
        String[] strArr = this.rowContents;
        int length = strArr != null ? strArr.length : 0;
        if (length <= 0) {
            return;
        }
        drawRowContents(length, getHeight() / (length - 1), canvas);
    }

    private final void drawRowContents(int i, float f, Canvas canvas) {
        if (this.isShowRuler) {
            int i2 = i - 1;
            for (int i3 = 1; i3 < i2; i3++) {
                drawRowContent(canvas, f, i3);
            }
            if (!this.isShowAllRow) {
                for (int i4 = 1; i4 < i2; i4++) {
                    drawRowContent(canvas, f, i4);
                }
                return;
            }
            for (int i5 = 0; i5 < i; i5++) {
                drawRowContent(canvas, f, i5);
            }
        }
    }

    private final void drawRowContent(Canvas canvas, float f, int i) {
        String[] strArr = this.rowContents;
        Intrinsics.checkNotNull(strArr);
        String str = strArr[i];
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = (int) (i * f);
        float measureText = this.columnTextPaint.measureText(str);
        if (i == 0) {
            canvas.drawText(str, this.fromStart ? 10.0f : (getWidth() - measureText) - 10.0f, i2 + 16.0f, this.rowTextPaint);
            return;
        }
        String[] strArr2 = this.rowContents;
        Intrinsics.checkNotNull(strArr2);
        if (i == strArr2.length - 1) {
            canvas.drawText(str, this.fromStart ? 10.0f : (getWidth() - measureText) - 10.0f, i2 - 10.0f, this.rowTextPaint);
        } else {
            canvas.drawText(str, this.fromStart ? 10.0f : (getWidth() - measureText) - 10.0f, i2 + 8.0f, this.rowTextPaint);
        }
    }

    /* compiled from: YRulerView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/views/grid/YRulerView$Companion;", "", "()V", "DEFAULT_PADDING", "", "DEFAULT_TEXT_SIZE", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
