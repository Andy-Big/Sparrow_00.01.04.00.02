package com.rigol.scope.views.la;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LaLienView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ\u0016\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tJ\u0012\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\u0018\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0014J\u0006\u0010%\u001a\u00020\u001fJ\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u0010J\u0016\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/rigol/scope/views/la/LaLienView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "listLaText", "", "locationY", "", "getLocationY", "()F", "setLocationY", "(F)V", "markerId", "paint", "Landroid/graphics/Paint;", "paintText", "path", "Landroid/graphics/Path;", "getPosition", "spacing", "old_locationY", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setMain", "setPosition", "position", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class LaLienView extends View {
    private String listLaText;
    private float locationY;
    private final int markerId;
    private final Paint paint;
    private final Paint paintText;
    private final Path path;

    public final float getLocationY() {
        return this.locationY;
    }

    public final void setLocationY(float f) {
        this.locationY = f;
    }

    public LaLienView(Context context) {
        super(context);
        this.paint = new Paint();
        this.paintText = new Paint();
        this.path = new Path();
        this.markerId = 1;
        this.locationY = 35.0f;
        this.listLaText = "0";
    }

    public LaLienView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint();
        this.paintText = new Paint();
        this.path = new Path();
        this.markerId = 1;
        this.locationY = 35.0f;
        this.listLaText = "0";
    }

    public LaLienView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.paint = new Paint();
        this.paintText = new Paint();
        this.path = new Path();
        this.markerId = 1;
        this.locationY = 35.0f;
        this.listLaText = "0";
    }

    public LaLienView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.paint = new Paint();
        this.paintText = new Paint();
        this.path = new Path();
        this.markerId = 1;
        this.locationY = 35.0f;
        this.listLaText = "0";
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setMain();
        this.path.reset();
        this.path.moveTo(0.0f, this.locationY);
        this.path.lineTo(getWidth() * 1.0f, this.locationY);
        this.path.close();
        Intrinsics.checkNotNull(canvas);
        canvas.drawPath(this.path, this.paint);
        canvas.drawText(this.listLaText, 0.0f, this.locationY, this.paintText);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    public final void setMain() {
        this.paint.setColor(SupportMenu.CATEGORY_MASK);
        this.paint.setStrokeWidth(2.0f);
        this.paint.setStyle(Paint.Style.STROKE);
        this.paintText.setColor(-16776961);
        this.paintText.setTextSize(18.0f);
    }

    public final void setPosition(float f, String listLaText) {
        Intrinsics.checkNotNullParameter(listLaText, "listLaText");
        this.listLaText = listLaText;
        this.locationY = f;
        invalidate();
    }

    public final void setPosition(float f) {
        this.locationY = f;
        invalidate();
    }

    public final float getPosition(int i, int i2) {
        return (this.locationY / i2) * i;
    }
}
