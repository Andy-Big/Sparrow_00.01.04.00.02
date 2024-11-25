package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.util.AttributeSet;
import com.scwang.smartrefresh.header.internal.pathview.PathsView;
import com.scwang.smartrefresh.layout.util.DensityUtil;
/* loaded from: classes2.dex */
public class FlyView extends PathsView {
    public FlyView(Context context) {
        this(context, null);
    }

    public FlyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.parserColors(-1);
        if (!this.mPathsDrawable.parserPaths("M2.01,21L23,12 2.01,3 2,10l15,2 -15,2z")) {
            this.mPathsDrawable.declareOriginal(2, 3, 20, 18);
        }
        int dp2px = DensityUtil.dp2px(25.0f);
        this.mPathsDrawable.setBounds(0, 0, dp2px, dp2px);
    }
}
