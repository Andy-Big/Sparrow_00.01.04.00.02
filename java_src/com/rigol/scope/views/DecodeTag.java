package com.rigol.scope.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.ViewCompat;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ViewUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: TagView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B'\b\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\t\u001a\u00020\nR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/rigol/scope/views/DecodeTag;", "Lcom/rigol/scope/views/TagView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "param", "Lcom/rigol/scope/data/DecodeParam;", "(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/rigol/scope/data/DecodeParam;)V", "updatePosition", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DecodeTag extends TagView {
    private final DecodeParam param;

    public DecodeTag(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, null, 4, null);
    }

    public /* synthetic */ DecodeTag(Context context, AttributeSet attributeSet, DecodeParam decodeParam, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, attributeSet, (i & 4) != 0 ? null : decodeParam);
    }

    public DecodeTag(Context context, AttributeSet attributeSet, DecodeParam decodeParam) {
        super(context, attributeSet);
        this.param = decodeParam;
        setId(View.generateViewId());
        DecodeParam decodeParam2 = this.param;
        setTag(decodeParam2 != null ? Integer.valueOf(decodeParam2.getServiceId()) : null);
        setTagWidth(35);
        setTagHeight(20);
        int i = 0;
        setShowLine(false);
        setText(ViewUtil.getDecodeSimpleStr(this.param));
        setTextColor(ViewCompat.MEASURED_STATE_MASK);
        setLabelColor(-1);
        DecodeParam decodeParam3 = this.param;
        setTagColor(ColorUtil.getColor(getContext(), decodeParam3 != null ? decodeParam3.getServiceId() : 42));
        DecodeParam decodeParam4 = this.param;
        if (decodeParam4 != null && !decodeParam4.isOnOff()) {
            i = 4;
        }
        setVisibility(i);
    }

    public final void updatePosition() {
        if (getParent() == null) {
            return;
        }
        ViewParent parent = getParent();
        if (parent == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        }
        setPosition((int) (((ViewGroup) parent).getHeight() * 0.5d));
    }
}
