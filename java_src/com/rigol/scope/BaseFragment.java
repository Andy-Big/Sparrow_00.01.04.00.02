package com.rigol.scope;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import timber.log.Timber;
/* loaded from: classes.dex */
public class BaseFragment extends Fragment {
    protected AppCompatActivity mActivity;
    protected PanelKeyViewModel panelKeyViewModel;
    protected SharedViewModel sharedViewModel;
    protected SyncDataViewModel syncDataViewModel;
    protected UpdateUIViewModel updateUIViewModel;

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.panelKeyViewModel = (PanelKeyViewModel) getAppViewModelProvider().get(PanelKeyViewModel.class);
        this.updateUIViewModel = (UpdateUIViewModel) MessageBus.getInstance().with(getAppViewModelProvider(), UpdateUIViewModel.class);
        this.sharedViewModel = (SharedViewModel) getAppViewModelProvider().get(SharedViewModel.class);
        this.syncDataViewModel = (SyncDataViewModel) MessageBus.getInstance().with(getAppViewModelProvider(), SyncDataViewModel.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.sharedViewModel.localeChanged.observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$BaseFragment$T4sUmkKaRFbBBigi8JFhz00zqPw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseFragment.this.lambda$onViewCreated$0$BaseFragment((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void lambda$onViewCreated$0$BaseFragment(Boolean bool) {
        onLocaleChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (AppCompatActivity) context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewModelProvider getAppViewModelProvider() {
        return ((App) this.mActivity.getApplicationContext()).getAppViewModelProvider(this.mActivity);
    }

    protected ViewModelProvider getFragmentViewModelProvider(Fragment fragment) {
        return new ViewModelProvider(fragment, fragment.getDefaultViewModelProviderFactory());
    }

    protected ViewModelProvider getActivityViewModelProvider(AppCompatActivity appCompatActivity) {
        return new ViewModelProvider(appCompatActivity, appCompatActivity.getDefaultViewModelProviderFactory());
    }

    public void onLocaleChanged() {
        Timber.d("onLocaleChanged", new Object[0]);
    }
}
