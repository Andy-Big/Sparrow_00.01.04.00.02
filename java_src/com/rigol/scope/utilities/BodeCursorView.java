package com.rigol.scope.utilities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.viewmodels.BodeViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BodeCursorView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\u0018\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018H\u0014J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/rigol/scope/utilities/BodeCursorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "bodeParam", "Lcom/rigol/scope/data/BodeParam;", "getBodeParam", "()Lcom/rigol/scope/data/BodeParam;", "setBodeParam", "(Lcom/rigol/scope/data/BodeParam;)V", "path_line", "Landroid/graphics/Path;", "textPaint", "Landroid/graphics/Paint;", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "setCursor", "setCursorReset", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class BodeCursorView extends View {
    private BodeParam bodeParam;
    private final Path path_line;
    private final Paint textPaint;

    public final BodeParam getBodeParam() {
        return this.bodeParam;
    }

    public final void setBodeParam(BodeParam bodeParam) {
        this.bodeParam = bodeParam;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        BodeParam bodeParam;
        BodeParam bodeParam2;
        super.onDraw(canvas);
        BodeParam bodeParam3 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam3);
        if (bodeParam3.getBode_resultlist().size() > 0) {
            BodeParam bodeParam4 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam4);
            if (bodeParam4.getBodeCursorPosition() <= 0) {
                BodeParam bodeParam5 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam5);
                bodeParam5.setBodeCursorPosition(0);
            } else {
                BodeParam bodeParam6 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam6);
                int bodeCursorPosition = bodeParam6.getBodeCursorPosition();
                Intrinsics.checkNotNull(this.bodeParam);
                if (bodeCursorPosition >= bodeParam.getPosition_listx().size() - 1) {
                    BodeParam bodeParam7 = this.bodeParam;
                    Intrinsics.checkNotNull(bodeParam7);
                    Intrinsics.checkNotNull(this.bodeParam);
                    bodeParam7.setBodeCursorPosition(bodeParam2.getPosition_listx().size() - 1);
                }
            }
            BodeParam bodeParam8 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam8);
            if (bodeParam8.getPosition_listx().size() > 0) {
                Path path = this.path_line;
                BodeParam bodeParam9 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam9);
                ArrayList<Float> position_listx = bodeParam9.getPosition_listx();
                BodeParam bodeParam10 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam10);
                float f = 120;
                BodeParam bodeParam11 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam11);
                double d = 20;
                path.moveTo(position_listx.get(bodeParam10.getBodeCursorPosition()).floatValue() + f, (float) (bodeParam11.getSpacing_heightunit() + d));
                Path path2 = this.path_line;
                BodeParam bodeParam12 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam12);
                ArrayList<Float> position_listx2 = bodeParam12.getPosition_listx();
                BodeParam bodeParam13 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam13);
                BodeParam bodeParam14 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam14);
                path2.lineTo(position_listx2.get(bodeParam13.getBodeCursorPosition()).floatValue() + f, (float) (bodeParam14.getSpacing_heightunit() + d));
                Path path3 = this.path_line;
                BodeParam bodeParam15 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam15);
                ArrayList<Float> position_listx3 = bodeParam15.getPosition_listx();
                BodeParam bodeParam16 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam16);
                float floatValue = position_listx3.get(bodeParam16.getBodeCursorPosition()).floatValue() + f;
                BodeParam bodeParam17 = this.bodeParam;
                Intrinsics.checkNotNull(bodeParam17);
                path3.lineTo(floatValue, (float) ((bodeParam17.getSpacing_heightunit() * 9) + d));
                Intrinsics.checkNotNull(canvas);
                canvas.drawPath(this.path_line, this.textPaint);
            }
        }
    }

    public BodeCursorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.textPaint = paint;
        this.path_line = new Path();
        this.bodeParam = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue();
    }

    public BodeCursorView(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.textPaint = paint;
        this.path_line = new Path();
        this.bodeParam = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue();
    }

    public final void setCursor() {
        invalidate();
    }

    public final void setCursorReset() {
        this.path_line.reset();
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
