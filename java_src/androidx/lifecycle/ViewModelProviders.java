package androidx.lifecycle;

import android.app.Application;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
@Deprecated
/* loaded from: classes.dex */
public class ViewModelProviders {
    @Deprecated
    public static ViewModelProvider of(Fragment fragment) {
        return new ViewModelProvider(fragment);
    }

    @Deprecated
    public static ViewModelProvider of(FragmentActivity fragmentActivity) {
        return new ViewModelProvider(fragmentActivity);
    }

    @Deprecated
    public static ViewModelProvider of(Fragment fragment, ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragment.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragment.getViewModelStore(), factory);
    }

    @Deprecated
    public static ViewModelProvider of(FragmentActivity fragmentActivity, ViewModelProvider.Factory factory) {
        if (factory == null) {
            factory = fragmentActivity.getDefaultViewModelProviderFactory();
        }
        return new ViewModelProvider(fragmentActivity.getViewModelStore(), factory);
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class DefaultFactory extends ViewModelProvider.AndroidViewModelFactory {
        @Deprecated
        public DefaultFactory(Application application) {
            super(application);
        }
    }
}
