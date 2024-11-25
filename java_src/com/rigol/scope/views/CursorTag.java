package com.rigol.scope.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TagView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\r\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR$\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR$\u0010\u001c\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000fR\u001a\u0010\t\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b \u0010\u0018¨\u0006!"}, d2 = {"Lcom/rigol/scope/views/CursorTag;", "Lcom/rigol/scope/views/TagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "orientation", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "", "endX", "getEndX", "()J", "setEndX", "(J)V", "endY", "getEndY", "setEndY", "otherValue", "", "getOtherValue", "()D", "setOtherValue", "(D)V", "startX", "getStartX", "setStartX", "startY", "getStartY", "setStartY", "getValue", "setValue", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class CursorTag extends TagView {
    private long endX;
    private long endY;
    private double otherValue;
    private long startX;
    private long startY;
    private double value;

    public CursorTag(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ CursorTag(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public CursorTag(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setId(View.generateViewId());
        setShowLine(true);
        setOrientation(i);
        if (i == 0) {
            setTagWidth(35);
            setTagHeight(25);
        } else {
            setTagWidth(25);
            setTagHeight(35);
        }
        setTagColor(-1);
        setTagStyle(Paint.Style.STROKE);
        setLineColor(-1);
        setTextColor(-1);
        if (i == 0) {
            setReverse(true);
        }
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

    public final double getValue() {
        return this.value;
    }

    public final void setValue(double d) {
        this.value = d;
    }

    public final double getOtherValue() {
        return this.otherValue;
    }

    public final void setOtherValue(double d) {
        this.otherValue = d;
    }
}
