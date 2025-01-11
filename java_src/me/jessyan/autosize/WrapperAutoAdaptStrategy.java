package me.jessyan.autosize;

import android.app.Activity;

/* loaded from: classes2.dex */
public class WrapperAutoAdaptStrategy implements AutoAdaptStrategy {
    private final AutoAdaptStrategy mAutoAdaptStrategy;

    public WrapperAutoAdaptStrategy(AutoAdaptStrategy autoAdaptStrategy) {
        this.mAutoAdaptStrategy = autoAdaptStrategy;
    }

    @Override // me.jessyan.autosize.AutoAdaptStrategy
    public void applyAdapt(Object obj, Activity activity) {
        onAdaptListener onAdaptListener = AutoSizeConfig.getInstance().getOnAdaptListener();
        if (onAdaptListener != null) {
            onAdaptListener.onAdaptBefore(obj, activity);
        }
        AutoAdaptStrategy autoAdaptStrategy = this.mAutoAdaptStrategy;
        if (autoAdaptStrategy != null) {
            autoAdaptStrategy.applyAdapt(obj, activity);
        }
        if (onAdaptListener != null) {
            onAdaptListener.onAdaptAfter(obj, activity);
        }
    }
}
