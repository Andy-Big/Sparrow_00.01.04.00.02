package com.rigol.scope.views.baseview;

import android.content.Context;
import android.util.AttributeSet;
import com.rigol.scope.utilities.Colors;
import kotlin.Metadata;
/* compiled from: LineView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R$\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR$\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR$\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/rigol/scope/views/baseview/Indicator;", "Lcom/rigol/scope/views/baseview/LineView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "value", "", "endX", "getEndX", "()J", "setEndX", "(J)V", "endY", "getEndY", "setEndY", "startX", "getStartX", "setStartX", "startY", "getStartY", "setStartY", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class Indicator extends LineView {
    private long endX;
    private long endY;
    private long startX;
    private long startY;

    public Indicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setLineColor(Colors.INDICATOR);
    }

    public final long getStartX() {
        return this.startX;
    }

    public final void setStartX(long j) {
        this.startX = j;
    }

    public final long getEndX() {
        return this.endX;
    }

    public final void setEndX(long j) {
        this.endX = j;
    }

    public final long getStartY() {
        return this.startY;
    }

    public final void setStartY(long j) {
        this.startY = j;
    }

    public final long getEndY() {
        return this.endY;
    }

    public final void setEndY(long j) {
        this.endY = j;
    }
}
