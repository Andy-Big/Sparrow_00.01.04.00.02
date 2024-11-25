package com.just.agentweb;

import android.webkit.WebView;
/* loaded from: classes.dex */
public class IndicatorHandler implements IndicatorController {
    private BaseIndicatorSpec mBaseIndicatorSpec;

    @Override // com.just.agentweb.IndicatorController
    public void progress(WebView webView, int i) {
        if (i == 0) {
            reset();
        } else if (i > 0 && i <= 10) {
            showIndicator();
        } else if (i > 10 && i < 95) {
            setProgress(i);
        } else {
            setProgress(i);
            finish();
        }
    }

    @Override // com.just.agentweb.IndicatorController
    public BaseIndicatorSpec offerIndicator() {
        return this.mBaseIndicatorSpec;
    }

    public void reset() {
        BaseIndicatorSpec baseIndicatorSpec = this.mBaseIndicatorSpec;
        if (baseIndicatorSpec != null) {
            baseIndicatorSpec.reset();
        }
    }

    @Override // com.just.agentweb.IndicatorController
    public void finish() {
        BaseIndicatorSpec baseIndicatorSpec = this.mBaseIndicatorSpec;
        if (baseIndicatorSpec != null) {
            baseIndicatorSpec.hide();
        }
    }

    @Override // com.just.agentweb.IndicatorController
    public void setProgress(int i) {
        BaseIndicatorSpec baseIndicatorSpec = this.mBaseIndicatorSpec;
        if (baseIndicatorSpec != null) {
            baseIndicatorSpec.setProgress(i);
        }
    }

    @Override // com.just.agentweb.IndicatorController
    public void showIndicator() {
        BaseIndicatorSpec baseIndicatorSpec = this.mBaseIndicatorSpec;
        if (baseIndicatorSpec != null) {
            baseIndicatorSpec.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static IndicatorHandler getInstance() {
        return new IndicatorHandler();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public IndicatorHandler inJectIndicator(BaseIndicatorSpec baseIndicatorSpec) {
        this.mBaseIndicatorSpec = baseIndicatorSpec;
        return this;
    }
}
