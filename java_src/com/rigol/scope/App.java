package com.rigol.scope;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.Network;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.IOParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.IOViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.util.ActivityLifecycleAdapter;
import com.rigol.util.ToastUtils;
import timber.log.Timber;

/* loaded from: classes.dex */
public class App extends Application implements ViewModelStoreOwner {
    private ViewModelProvider.Factory mFactory;
    private ViewModelStore mViewModelStore;
    private final ActivityLifecycleAdapter lifecycleAdapter = new ActivityLifecycleAdapter();
    private final HDMIReceiver hdmiReceiver = new HDMIReceiver();

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        BaseApplicationContext.setContext(this);
        Timber.plant(new Timber.DebugTree());
        ToastUtils.INSTANCE.setGravity(17, 0, 0).setTextSize(25);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HDMI_PLUGGED");
        registerReceiver(this.hdmiReceiver, intentFilter);
        registerComponentCallbacks(new ComponentCallbacks2() { // from class: com.rigol.scope.App.1
            @Override // android.content.ComponentCallbacks
            public void onLowMemory() {
            }

            @Override // android.content.ComponentCallbacks2
            public void onTrimMemory(int i) {
            }

            @Override // android.content.ComponentCallbacks
            public void onConfigurationChanged(Configuration configuration) {
                Timber.d("newConfig:%s", configuration);
            }
        });
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null) {
            connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() { // from class: com.rigol.scope.App.2
                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onAvailable(Network network) {
                    super.onAvailable(network);
                    UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
                    IOViewModel iOViewModel = (IOViewModel) ContextUtil.getAppViewModel(IOViewModel.class);
                    if (utilityViewModel == null || iOViewModel == null) {
                        return;
                    }
                    UtilityParam value = utilityViewModel.getLiveData().getValue();
                    IOParam value2 = iOViewModel.getLiveData().getValue();
                    if (value == null || value2 == null) {
                        return;
                    }
                    ViewUtil.identification("/mnt/tmp/identification", value.getModel(), value.getSerial(), AppUtils.getAppVersionName(), value2.getIpAddress(), value2.getMask(), value2.getMacAddress(), value2.getGateway(), value2.isDHCPSelected(), value2.isAutoSelected());
                }

                @Override // android.net.ConnectivityManager.NetworkCallback
                public void onLost(Network network) {
                    super.onLost(network);
                    API.getInstance().UI_PostInt32(15, MessageID.MSG_SCPI_SOCKET_DISCONNECT, 0);
                }
            });
        }
        this.mViewModelStore = new ViewModelStore();
        Utils.init(this);
        registerActivityLifecycleCallbacks(this.lifecycleAdapter);
    }

    public boolean isAppForeground() {
        return this.lifecycleAdapter.getForegroundActivityCount() != 0;
    }

    public ViewModelProvider getAppViewModelProvider(Activity activity) {
        return new ViewModelProvider((App) activity.getApplicationContext(), ((App) activity.getApplicationContext()).getAppFactory(activity));
    }

    private ViewModelProvider.Factory getAppFactory(Activity activity) {
        Application checkApplication = checkApplication(activity);
        if (this.mFactory == null) {
            this.mFactory = ViewModelProvider.AndroidViewModelFactory.getInstance(checkApplication);
        }
        return this.mFactory;
    }

    private Application checkApplication(Activity activity) {
        Application application = activity.getApplication();
        if (application != null) {
            return application;
        }
        throw new IllegalStateException("Your activity/fragment is not yet attached to Application. You can't request ViewModel before onCreate call.");
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        return this.mViewModelStore;
    }
}
