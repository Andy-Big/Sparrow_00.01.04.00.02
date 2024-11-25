package com.rigol.scope.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import kotlin.Metadata;
/* compiled from: TagView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/rigol/scope/views/ExpandTag;", "Lcom/rigol/scope/views/TagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class ExpandTag extends TagView {
    public ExpandTag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setId(View.generateViewId());
        setTagWidth(20);
        setTagHeight(10);
        setTagColor(-29696);
        setOrientation(1);
        setTagStyle(Paint.Style.STROKE);
        setDraggable(false);
        setReverse(true);
        setBeyond(true);
    }
}
