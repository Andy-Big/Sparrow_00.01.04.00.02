package com.just.agentweb;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public abstract class BaseIndicatorView extends FrameLayout implements BaseIndicatorSpec, LayoutParamsOffer {
    @Override // com.just.agentweb.BaseIndicatorSpec
    public void hide() {
    }

    @Override // com.just.agentweb.BaseIndicatorSpec
    public void reset() {
    }

    @Override // com.just.agentweb.BaseIndicatorSpec
    public void setProgress(int i) {
    }

    @Override // com.just.agentweb.BaseIndicatorSpec
    public void show() {
    }

    public BaseIndicatorView(Context context) {
        super(context);
    }

    public BaseIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BaseIndicatorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
