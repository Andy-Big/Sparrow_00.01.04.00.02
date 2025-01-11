package me.jessyan.autosize;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* loaded from: classes2.dex */
public class FragmentLifecycleCallbacksImplToAndroidx extends FragmentManager.FragmentLifecycleCallbacks {
    private AutoAdaptStrategy mAutoAdaptStrategy;

    public FragmentLifecycleCallbacksImplToAndroidx(AutoAdaptStrategy autoAdaptStrategy) {
        this.mAutoAdaptStrategy = autoAdaptStrategy;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentCreated(FragmentManager fragmentManager, Fragment fragment, Bundle bundle) {
        AutoAdaptStrategy autoAdaptStrategy = this.mAutoAdaptStrategy;
        if (autoAdaptStrategy != null) {
            autoAdaptStrategy.applyAdapt(fragment, fragment.getActivity());
        }
    }

    public void setAutoAdaptStrategy(AutoAdaptStrategy autoAdaptStrategy) {
        this.mAutoAdaptStrategy = autoAdaptStrategy;
    }
}
