package com.rigol.scope;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.hardware.display.DisplayManager;
import android.hardware.input.InputManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.view.Display;
import android.view.InputEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.bumptech.glide.Glide;
import com.rigol.iguardservice.IGuardListener;
import com.rigol.iguardservice.IGuardService;
import com.rigol.lib.data.Firmware;
import com.rigol.scope.MainActivity;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.data.IOParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.ActivityMainBinding;
import com.rigol.scope.databinding.FragmentWaveformBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KeyCodeUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ScreenSaverUtil;
import com.rigol.scope.utilities.UtilityUtil;
import com.rigol.scope.utilities.ViewModelManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.IOViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.viewmodels.UpdateViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.ScreenFlipPopupView;
import com.rigol.scope.views.UpdatePopupView;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.alert.AppSwitchPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.FanScaleView;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.presentation.MiniScreenPresentation;
import com.rigol.scope.views.presentation.MotorPresentation;
import com.rigol.util.DiskUtil;
import com.rigol.util.PackageUtilKt;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import timber.log.Timber;
/* loaded from: classes.dex */
public class MainActivity extends BaseActivity {
    private static final String GUARD_SERVICE_ACTION = "com.rigol.watchdog.Watchdog";
    private ActivityMainBinding binding;
    private Method injectInputEventMethod;
    private IGuardService mGuardService;
    private MiniScreenPresentation miniScreenPresentation;
    private MotorPresentation motorPresentation;
    private UpdateUIViewModel updateUIViewModel;
    private final Handler mHandler = new Handler();
    private boolean bConnectLauncher = false;
    private UpdatePopupView updatePopupView = null;
    private BasePopupView screenFlipPopupView = null;
    private int lastPosition = -1;
    private SharedParam sharedParam = null;
    private IOParam ioParam = null;
    private OptionParam optionParam = null;
    private InputManager im = null;
    ThreadPoolExecutor executor = null;
    private ObservableBoolean showMainContent = new ObservableBoolean(true);
    private boolean isShowMainActivity = false;
    private final String PROP_QUICK_POWER_ON = "persist.rigol.quick_power_on";
    private final String PROP_QUICK_POWER_OFF = "persist.rigol.quick_power_off";
    private final Handler handler = new AnonymousClass1(Looper.getMainLooper());
    private final int MSG_QUICK_POWER_ON = 0;
    private final int MSG_QUICK_POWER_OFF = 1;
    private final Runnable heartbeat = new Runnable() { // from class: com.rigol.scope.MainActivity.5
        @Override // java.lang.Runnable
        public void run() {
            if (!MainActivity.this.bConnectLauncher) {
                Intent intent = new Intent();
                intent.setAction(MainActivity.GUARD_SERVICE_ACTION);
                intent.setPackage(PackageUtilKt.PACKAGE_NAME_LAUNCHER);
                MainActivity mainActivity = MainActivity.this;
                mainActivity.bConnectLauncher = mainActivity.bindService(intent, mainActivity.mGuardConn, 1);
            }
            if (MainActivity.this.mGuardService != null) {
                try {
                    MainActivity.this.mGuardService.heartbeat();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            MainActivity.this.mHandler.postDelayed(MainActivity.this.heartbeat, 5000L);
        }
    };
    private final ServiceConnection mGuardConn = new ServiceConnection() { // from class: com.rigol.scope.MainActivity.6
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainActivity.this.mGuardService = IGuardService.Stub.asInterface(iBinder);
            if (MainActivity.this.mGuardService != null) {
                try {
                    MainActivity.this.mGuardService.setListener(MainActivity.this.guardListener);
                    MainActivity.this.mGuardService.setLocked(false);
                    MainActivity.this.setPackageName();
                    ThreadUtils.executeByCpuWithDelay(new ThreadUtils.Task<Object>() { // from class: com.rigol.scope.MainActivity.6.1
                        @Override // com.blankj.utilcode.util.ThreadUtils.Task
                        public void onCancel() {
                        }

                        @Override // com.blankj.utilcode.util.ThreadUtils.Task
                        public void onFail(Throwable th) {
                        }

                        @Override // com.blankj.utilcode.util.ThreadUtils.Task
                        public void onSuccess(Object obj) {
                        }

                        @Override // com.blankj.utilcode.util.ThreadUtils.Task
                        public Object doInBackground() throws Throwable {
                            MainActivity.this.checkNewVersion();
                            return null;
                        }
                    }, 60L, TimeUnit.SECONDS);
                    return;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return;
                }
            }
            Timber.e("Watchdog Bind Fail = Serial Service is Null", new Object[0]);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MainActivity.this.mGuardService = null;
            Timber.d("Watchdog onServiceDisconnected, name: %s", componentName);
        }
    };
    private final IGuardListener.Stub guardListener = new AnonymousClass7();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.MainActivity$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            final int i = message.what;
            try {
                if (i == 0) {
                    ShellUtils.execCmdAsync("getprop persist.rigol.quick_power_on", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$1$xljkTYIoO4pRoy2gX0gi8PwrUkE
                        @Override // com.blankj.utilcode.util.Utils.Consumer
                        public final void accept(Object obj) {
                            MainActivity.AnonymousClass1.this.lambda$handleMessage$0$MainActivity$1(i, (ShellUtils.CommandResult) obj);
                        }
                    });
                } else if (i != 1) {
                } else {
                    ShellUtils.execCmdAsync("getprop persist.rigol.quick_power_off", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$1$yOcO2I910n5vxb09FmABxGB_jMw
                        @Override // com.blankj.utilcode.util.Utils.Consumer
                        public final void accept(Object obj) {
                            MainActivity.AnonymousClass1.this.lambda$handleMessage$1$MainActivity$1(i, (ShellUtils.CommandResult) obj);
                        }
                    });
                }
            } catch (Exception e) {
                Timber.e(e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: handleCommandResult */
        public void lambda$handleMessage$1$MainActivity$1(ShellUtils.CommandResult commandResult, int i) {
            PrintStream printStream = System.out;
            printStream.println(commandResult.toString() + ", " + i);
            if ((commandResult.successMsg.isEmpty() ? 100 : Integer.parseInt(commandResult.successMsg)) < 100) {
                sendEmptyMessageDelayed(i, 100L);
            } else {
                removeMessages(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getResources().getConfiguration();
        API.getInstance().UI_StartBusiness(0);
        API.getInstance().UI_PostStr(11, MessageID.MSG_MISC_SOFT_VER, "00.01.04.00.02");
        ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.-$$Lambda$MainActivity$V200sj20CupUghpKR2pkFLu3VyQ
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.this.lambda$onCreate$0$MainActivity();
            }
        });
        Timber.tag("StandBy").d("Read All Data", new Object[0]);
        ViewModelManager.INSTANCE.readAll(getAppViewModelProvider());
        if (getIntent().hasExtra(PackageUtilKt.INTENT_EXTRA_LAUNCH_DEFAULT)) {
            int intExtra = getIntent().getIntExtra(PackageUtilKt.INTENT_EXTRA_LAUNCH_DEFAULT, 0);
            Timber.d("launchParam:%s", Integer.valueOf(intExtra));
            API.getInstance(intExtra);
        } else {
            Timber.d("has no launchParam", new Object[0]);
            API.getInstance();
        }
        ViewUtil.serialize = API.getInstance().UI_QueryInt32(11, MessageID.MSG_PRODUCT_SERIES);
        ActivityMainBinding inflate = ActivityMainBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        inflate.setShowMainContent(this.showMainContent);
        setContentView(this.binding.getRoot());
        Glide.with((FragmentActivity) this).asGif().load(Integer.valueOf((int) R.drawable.loading)).into(this.binding.progress);
        this.im = getInputManager();
        try {
            MotionEvent.class.getDeclaredMethod("obtain", new Class[0]).setAccessible(true);
            this.injectInputEventMethod = InputManager.class.getMethod("injectInputEvent", InputEvent.class, Integer.TYPE);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        this.mHandler.postDelayed(new Runnable() { // from class: com.rigol.scope.MainActivity.3
            @Override // java.lang.Runnable
            public void run() {
                MainActivity mainActivity = MainActivity.this;
                mainActivity.sendMotionEvent(mainActivity.im, MainActivity.this.injectInputEventMethod, 0, System.currentTimeMillis(), System.currentTimeMillis(), 50.0f, 100.0f);
                MainActivity mainActivity2 = MainActivity.this;
                mainActivity2.sendMotionEvent(mainActivity2.im, MainActivity.this.injectInputEventMethod, 1, System.currentTimeMillis(), System.currentTimeMillis(), 50.0f, 100.0f);
            }
        }, 500L);
        Intent intent = new Intent();
        intent.setAction(GUARD_SERVICE_ACTION);
        intent.setPackage(PackageUtilKt.PACKAGE_NAME_LAUNCHER);
        this.bConnectLauncher = bindService(intent, this.mGuardConn, 1);
        this.mHandler.post(this.heartbeat);
        ViewModelProvider appViewModelProvider = getAppViewModelProvider();
        ViewModelManager.INSTANCE.readAll(appViewModelProvider);
        IOViewModel iOViewModel = (IOViewModel) appViewModelProvider.get(IOViewModel.class);
        iOViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$vz0P1eyugvi-JxBg96YYWZZvhfU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$onCreate$1$MainActivity((IOParam) obj);
            }
        });
        this.ioParam = iOViewModel.getLiveData().getValue();
        UtilityParam value = ((UtilityViewModel) appViewModelProvider.get(UtilityViewModel.class)).getLiveData().getValue();
        IOParam iOParam = this.ioParam;
        if (iOParam != null && value != null) {
            iOParam.saveHostName("RIGOL_" + value.getSerial());
            ViewUtil.identification("/mnt/tmp/identification", value.getModel(), value.getSerial(), AppUtils.getAppVersionName(), this.ioParam.getIpAddress(), this.ioParam.getMask(), this.ioParam.getMacAddress(), this.ioParam.getGateway(), this.ioParam.isDHCPSelected(), this.ioParam.isAutoSelected());
        }
        ((OptionViewModel) appViewModelProvider.get(OptionViewModel.class)).getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$R1ArSb0AI-gWg1fzsFaMvNEfOCM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$onCreate$2$MainActivity((OptionParam) obj);
            }
        });
        getUpdateUIViewModel().bindAll(this, appViewModelProvider);
        this.updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        getPanelKeyViewModel().getOnKeyUpData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$lYnwMT0nZRgrG-Bz52FVBcnFIjI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$onCreate$3$MainActivity((KeyEvent) obj);
            }
        });
        Display[] displays = ((DisplayManager) getSystemService("display")).getDisplays();
        if (displays != null && displays.length == 2 && !displays[1].getName().contains("HDMI")) {
            try {
                MiniScreenPresentation miniScreenPresentation = new MiniScreenPresentation(this, displays[1]);
                this.miniScreenPresentation = miniScreenPresentation;
                miniScreenPresentation.show();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        getSyncDataViewModel().get(MessageBus.SYNC_DATA_KEY_MOTOR_FORWARD).observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$xgbtelrLq9vMyUJHuIs5zGy7epA
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$onCreate$4$MainActivity(obj);
            }
        });
        getSyncDataViewModel().get(MessageBus.SYNC_DATA_KEY_MOTOR_REVERSE).observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$pcTjeobzbyJv10kqTDvTj28sPbc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$onCreate$5$MainActivity(obj);
            }
        });
        getSyncDataViewModel().get(MessageBus.SYNC_DATA_KEY_MOTOR_SET_POSITION).observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$VMa9ZBISMEstg14x-UKvBu8317s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$onCreate$6$MainActivity(obj);
            }
        });
        getSyncDataViewModel().get(MessageBus.SYNC_DATA_KEY_MOTOR_RECOVERY).observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$XsXjNhso7wLAMj5evtzld37s1PI
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$onCreate$7$MainActivity(obj);
            }
        });
        getSharedViewModel().getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$MainActivity$rjGDWwom0l-jRn61OqQ31Tbizg0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                MainActivity.this.lambda$onCreate$8$MainActivity((SharedParam) obj);
            }
        });
        this.binding.resultsBarIcon.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.-$$Lambda$MainActivity$rkhiAE_RKL1N1grFc_z8yPqOpXY
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainActivity.this.lambda$onCreate$9$MainActivity(view);
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(new NetChangeReceiver(), intentFilter);
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("android.intent.action.MEDIA_MOUNTED");
        registerReceiver(new UsbReceiver(), intentFilter2);
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel != null) {
            sharedViewModel.getLiveData();
            SharedParam value2 = sharedViewModel.getLiveData().getValue();
            if (value2 != null) {
                value2.setShowUsb(DiskUtil.INSTANCE.hasRemovableDisk());
                if (value2.getShowUsb()) {
                    sendBroadcast(new Intent("android.intent.action.MEDIA_MOUNTED"));
                }
                if (UtilityUtil.getDiskList().size() > 1) {
                    value2.setShowSmb(true);
                } else {
                    value2.setShowSmb(false);
                }
            }
        }
        this.handler.sendEmptyMessageDelayed(0, 100L);
        this.binding.getRoot().postDelayed(new Runnable() { // from class: com.rigol.scope.-$$Lambda$MainActivity$HTEf2qIqF90dzOioGnrQ0kdnys4
            @Override // java.lang.Runnable
            public final void run() {
                MainActivity.lambda$onCreate$10();
            }
        }, 300L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.MainActivity$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends ThreadUtils.SimpleTask<Object> {
        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(Object obj) {
        }

        AnonymousClass2() {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public Object doInBackground() throws Throwable {
            Timber.tag("StandBy").d("Call UI_StartBusiness Method", new Object[0]);
            API.getInstance().UI_StartBusiness(0);
            API.getInstance().UI_PostStr(11, MessageID.MSG_MISC_SOFT_VER, "00.01.04.00.02");
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.-$$Lambda$MainActivity$2$XDyImiO_KResgakkCl9kuJQmz1I
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.AnonymousClass2.this.lambda$doInBackground$0$MainActivity$2();
                }
            });
            Timber.tag("StandBy").d("Read All Data", new Object[0]);
            ViewModelManager.INSTANCE.readAll(MainActivity.this.getAppViewModelProvider());
            return true;
        }

        public /* synthetic */ void lambda$doInBackground$0$MainActivity$2() {
            MainActivity.this.showMainContent.set(true);
        }
    }

    public /* synthetic */ void lambda$onCreate$0$MainActivity() {
        this.showMainContent.set(true);
    }

    public /* synthetic */ void lambda$onCreate$1$MainActivity(IOParam iOParam) {
        this.ioParam = iOParam;
    }

    public /* synthetic */ void lambda$onCreate$2$MainActivity(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$onCreate$3$MainActivity(KeyEvent keyEvent) {
        int panelKey = KeyCodeUtil.getPanelKey(keyEvent.getKeyCode());
        if (PopupViewManager.getInstance().isShowing(MeasurePopupView.class)) {
            BasePopupView basePopupView = PopupViewManager.getInstance().get(MeasurePopupView.class);
            if (basePopupView instanceof MeasurePopupView) {
                basePopupView.onPanelKeyUp(panelKey, keyEvent);
            }
        }
        MotorPresentation motorPresentation = this.motorPresentation;
        if (motorPresentation != null && motorPresentation.isShowing()) {
            if (panelKey == 2118) {
                if (this.motorPresentation.isScreenPresentationReady) {
                    this.motorPresentation.notifyMotorRotateForward();
                    IGuardService iGuardService = this.mGuardService;
                    if (iGuardService != null) {
                        try {
                            iGuardService.setMotorForward();
                        } catch (RemoteException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (panelKey == 4166) {
                if (this.motorPresentation.isScreenPresentationReady) {
                    this.motorPresentation.notifyMotorRotateReversal();
                    IGuardService iGuardService2 = this.mGuardService;
                    if (iGuardService2 != null) {
                        try {
                            iGuardService2.setMotorReverse();
                        } catch (RemoteException e2) {
                            e2.printStackTrace();
                        }
                    }
                }
            } else if (panelKey == 72 && this.motorPresentation.isScreenPresentationReady) {
                this.motorPresentation.notifyMotorResetToDefalut();
                IGuardService iGuardService3 = this.mGuardService;
                if (iGuardService3 != null) {
                    try {
                        iGuardService3.setMotorPos(0, true);
                    } catch (RemoteException e3) {
                        e3.printStackTrace();
                    }
                }
            }
        }
        if (panelKey == 66) {
            MotorPresentation motorPresentation2 = this.motorPresentation;
            if (motorPresentation2 != null) {
                if (motorPresentation2.isShowing()) {
                    this.motorPresentation.dismiss();
                } else {
                    this.motorPresentation.show();
                }
            }
        } else if (panelKey == 17 || panelKey == 12) {
        } else {
            if (panelKey == 97) {
                PopupViewManager.getInstance().toggle(AppSwitchPopupView.class);
            } else if (panelKey == 82) {
                ViewUtil.quickAction();
            } else if (panelKey == 186) {
                getPanelKeyViewModel().abText(keyEvent, 0);
            }
        }
    }

    public /* synthetic */ void lambda$onCreate$4$MainActivity(Object obj) {
        IGuardService iGuardService = this.mGuardService;
        if (iGuardService != null) {
            try {
                iGuardService.setMotorForward();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$onCreate$5$MainActivity(Object obj) {
        IGuardService iGuardService = this.mGuardService;
        if (iGuardService != null) {
            try {
                iGuardService.setMotorReverse();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$onCreate$6$MainActivity(Object obj) {
        IGuardService iGuardService = this.mGuardService;
        if (iGuardService != null) {
            try {
                iGuardService.setMotorPos(((Integer) obj).intValue(), true);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$onCreate$7$MainActivity(Object obj) {
        IGuardService iGuardService = this.mGuardService;
        if (iGuardService != null) {
            try {
                iGuardService.setMotorRecovery();
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$onCreate$8$MainActivity(final SharedParam sharedParam) {
        this.sharedParam = sharedParam;
        this.binding.setSharedParam(sharedParam);
        sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.MainActivity.4
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                FragmentWaveformBinding binding;
                if (i == 833) {
                    sharedParam.getShowResultBar();
                    WaveformFragment waveformFragment = MainActivity.this.getWaveformFragment();
                    if (waveformFragment == null || (binding = waveformFragment.getBinding()) == null) {
                        return;
                    }
                    binding.multiWindow.parseNodeTreeRelative();
                }
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$9$MainActivity(View view) {
        if (this.sharedParam != null) {
            if (this.binding.resultsBar.getVisibility() == 0) {
                this.sharedParam.setShowResultBar(false);
                this.sharedParam.setClosedResultBar(true);
                return;
            }
            this.sharedParam.setShowResultBar(true);
            this.sharedParam.setClosedResultBar(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onCreate$10() {
        Timber.tag("StandBy").d("Init All PopupWindow", new Object[0]);
        PopupViewManager.getInstance().addAll();
    }

    public void checkNewVersion() {
        UtilityViewModel utilityViewModel;
        UtilityParam value;
        if (this.mGuardService == null || (utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)) == null || (value = utilityViewModel.getLiveData().getValue()) == null) {
            return;
        }
        try {
            this.mGuardService.checkNewVersion(value.getSerial());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    public boolean isMotorShowing() {
        MotorPresentation motorPresentation = this.motorPresentation;
        if (motorPresentation != null) {
            return motorPresentation.isShowing();
        }
        return false;
    }

    public boolean isMiniScreenShowing() {
        MiniScreenPresentation miniScreenPresentation = this.miniScreenPresentation;
        if (miniScreenPresentation != null) {
            return miniScreenPresentation.isShowing();
        }
        return false;
    }

    public void locked(boolean z) {
        UtilityParam value;
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null && (value = utilityViewModel.getLiveData().getValue()) != null) {
            value.setLockKeyboard(z);
        }
        ViewUtil.lock(getWindow(), z);
        MotorPresentation motorPresentation = this.motorPresentation;
        if (motorPresentation != null) {
            ViewUtil.lock(motorPresentation.getWindow(), z);
        }
        MiniScreenPresentation miniScreenPresentation = this.miniScreenPresentation;
        if (miniScreenPresentation != null) {
            ViewUtil.lock(miniScreenPresentation.getWindow(), z);
        }
        if (z) {
            PopupViewManager.getInstance().dismiss(UtilityPopupView.class);
        }
    }

    public NavigationBarFragment getNavigationBarFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.navigation_bar);
        if (findFragmentById instanceof NavigationBarFragment) {
            return (NavigationBarFragment) findFragmentById;
        }
        return null;
    }

    public SettingsBarFragment getSettingsBarFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.settings_bar);
        if (findFragmentById instanceof SettingsBarFragment) {
            return (SettingsBarFragment) findFragmentById;
        }
        return null;
    }

    public WaveformFragment getWaveformFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.waveform);
        if (findFragmentById instanceof WaveformFragment) {
            return (WaveformFragment) findFragmentById;
        }
        return null;
    }

    public ResultsBarFragment getResultBarFragment() {
        Fragment findFragmentById = getSupportFragmentManager().findFragmentById(R.id.results_bar);
        if (findFragmentById instanceof ResultsBarFragment) {
            return (ResultsBarFragment) findFragmentById;
        }
        return null;
    }

    @Override // android.app.Activity
    protected void onRestart() {
        Timber.d("onRestart", new Object[0]);
        super.onRestart();
        ScreenSaverUtil.getInstance(this).OnStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        setPackageName();
        IGuardService iGuardService = this.mGuardService;
        if (iGuardService != null) {
            try {
                iGuardService.setLocked(false);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPackageName() {
        IGuardService iGuardService = this.mGuardService;
        if (iGuardService != null) {
            try {
                iGuardService.setPackageName(getPackageName());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveLog() {
        IGuardService iGuardService = this.mGuardService;
        if (iGuardService != null) {
            try {
                iGuardService.saveLog("");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        ServiceConnection serviceConnection = this.mGuardConn;
        if (serviceConnection != null) {
            unbindService(serviceConnection);
        }
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacks(this.heartbeat);
        }
        MotorPresentation motorPresentation = this.motorPresentation;
        if (motorPresentation != null) {
            motorPresentation.cancel();
        }
        MiniScreenPresentation miniScreenPresentation = this.miniScreenPresentation;
        if (miniScreenPresentation != null) {
            miniScreenPresentation.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.MainActivity$7  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass7 extends IGuardListener.Stub {
        @Override // com.rigol.iguardservice.IGuardListener
        public void onMotorError() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onMotorNeedManualReset() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onPowerOffMotorError() throws RemoteException {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onPowerOffMotorPinch() throws RemoteException {
        }

        AnonymousClass7() {
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onUpdate(Firmware firmware) throws RemoteException {
            MainActivity.this.getSharedViewModel().hasUpdate.postValue(new TwoTuple<>(true, true));
            ((UpdateViewModel) MainActivity.this.getAppViewModelProvider().get(UpdateViewModel.class)).getLiveData().postValue(firmware);
            if (MainActivity.this.updatePopupView == null) {
                BasePopupView basePopupView = PopupViewManager.getInstance().get(UpdatePopupView.class);
                if (basePopupView instanceof UpdatePopupView) {
                    MainActivity.this.updatePopupView = (UpdatePopupView) basePopupView;
                }
            }
            if (MainActivity.this.updatePopupView != null) {
                MainActivity.this.updatePopupView.reset();
            }
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onDownload(int i) throws RemoteException {
            if (MainActivity.this.updatePopupView == null) {
                BasePopupView basePopupView = PopupViewManager.getInstance().get(UpdatePopupView.class);
                if (basePopupView instanceof UpdatePopupView) {
                    MainActivity.this.updatePopupView = (UpdatePopupView) basePopupView;
                }
            }
            if (MainActivity.this.updatePopupView != null) {
                MainActivity.this.updatePopupView.setProgress(i);
                MainActivity.this.updatePopupView.setDownding(i != 100);
            }
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onInstall(int i, String str) throws RemoteException {
            if (MainActivity.this.updatePopupView == null) {
                BasePopupView basePopupView = PopupViewManager.getInstance().get(UpdatePopupView.class);
                if (basePopupView instanceof UpdatePopupView) {
                    MainActivity.this.updatePopupView = (UpdatePopupView) basePopupView;
                }
            }
            if (MainActivity.this.updatePopupView != null) {
                MainActivity.this.updatePopupView.setInstalling(true);
                MainActivity.this.updatePopupView.setMessage(str);
            }
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onError(int i, String str) throws RemoteException {
            if (MainActivity.this.updatePopupView == null) {
                BasePopupView basePopupView = PopupViewManager.getInstance().get(UpdatePopupView.class);
                if (basePopupView instanceof UpdatePopupView) {
                    MainActivity.this.updatePopupView = (UpdatePopupView) basePopupView;
                }
            }
            if (MainActivity.this.updatePopupView != null) {
                MainActivity.this.updatePopupView.setErrorCode(i);
                MainActivity.this.updatePopupView.setErrorMessage(str);
                MainActivity.this.updatePopupView.setInstalling(false);
                MainActivity.this.updatePopupView.setDownding(false);
            }
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onLocked(final boolean z) throws RemoteException {
            Timber.d("lockEnable:%s", Boolean.valueOf(z));
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.rigol.scope.-$$Lambda$MainActivity$7$j-QSKhRUZRLEvcbEi1s74L8dRow
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.AnonymousClass7.this.lambda$onLocked$0$MainActivity$7(z);
                }
            });
        }

        public /* synthetic */ void lambda$onLocked$0$MainActivity$7(boolean z) {
            MainActivity.this.locked(z);
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onMotorPos(final int i, boolean z) throws RemoteException {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.rigol.scope.-$$Lambda$MainActivity$7$rQnNrcce6V4YVdtKnLBYBc3AyCI
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.AnonymousClass7.this.lambda$onMotorPos$1$MainActivity$7(i);
                }
            });
        }

        public /* synthetic */ void lambda$onMotorPos$1$MainActivity$7(int i) {
            if (MainActivity.this.screenFlipPopupView == null) {
                MainActivity.this.screenFlipPopupView = PopupViewManager.getInstance().get(ScreenFlipPopupView.class);
            }
            if (MainActivity.this.screenFlipPopupView instanceof ScreenFlipPopupView) {
                ((ScreenFlipPopupView) MainActivity.this.screenFlipPopupView).setOpening(i > MainActivity.this.lastPosition);
                if (!MainActivity.this.screenFlipPopupView.isShowing()) {
                    MainActivity.this.screenFlipPopupView.show();
                }
                ((ScreenFlipPopupView) MainActivity.this.screenFlipPopupView).delayToDismiss();
            }
            MainActivity.this.lastPosition = i;
            if (MainActivity.this.motorPresentation == null || MainActivity.this.motorPresentation.mBinding.fanScaleView.getNotifyToRefreshAngleType() == FanScaleView.NotifyToRefreshAngleTypeEnum.NULL || MainActivity.this.motorPresentation.mBinding.fanScaleView.getNotifyToRefreshAngleType() == FanScaleView.NotifyToRefreshAngleTypeEnum.ARC_MOVE_TOUCHED) {
                return;
            }
            MainActivity.this.motorPresentation.refreshFanByFilpAngle(i);
        }

        @Override // com.rigol.iguardservice.IGuardListener
        public void onMotorPinchHand() throws RemoteException {
            MainActivity.this.runOnUiThread(new Runnable() { // from class: com.rigol.scope.-$$Lambda$MainActivity$7$7T5cxVE6qkdAZEMQKzL_7XYGnYI
                @Override // java.lang.Runnable
                public final void run() {
                    MainActivity.AnonymousClass7.this.lambda$onMotorPinchHand$2$MainActivity$7();
                }
            });
        }

        public /* synthetic */ void lambda$onMotorPinchHand$2$MainActivity$7() {
            if (MainActivity.this.screenFlipPopupView == null) {
                MainActivity.this.screenFlipPopupView = PopupViewManager.getInstance().get(ScreenFlipPopupView.class);
            }
            if (MainActivity.this.screenFlipPopupView instanceof ScreenFlipPopupView) {
                ((ScreenFlipPopupView) MainActivity.this.screenFlipPopupView).setObstacleFlag(true);
                if (!MainActivity.this.screenFlipPopupView.isShowing()) {
                    MainActivity.this.screenFlipPopupView.show();
                }
                ((ScreenFlipPopupView) MainActivity.this.screenFlipPopupView).delayToDismiss();
            }
        }
    }

    @Override // com.rigol.scope.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.rigol.scope.BaseActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            ScreenSaverUtil.getInstance(this).OnStart();
        } else {
            ScreenSaverUtil.getInstance(this).onStop();
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public ActivityMainBinding getBinding() {
        return this.binding;
    }

    @Override // com.rigol.scope.BaseActivity
    public void onLocaleChanged() {
        super.onLocaleChanged();
        MiniScreenPresentation miniScreenPresentation = this.miniScreenPresentation;
        if (miniScreenPresentation != null) {
            miniScreenPresentation.onLocaleChanged();
        }
    }

    private InputManager getInputManager() {
        try {
            return (InputManager) InputManager.class.getDeclaredMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        } catch (InvocationTargetException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public void sendMotionEvent(InputManager inputManager, Method method, int i, long j, long j2, float f, float f2) {
        Timber.d("downTime:" + j + " ,eventTime:" + j2, new Object[0]);
        try {
            injectMotionEvent(inputManager, method, InputDeviceCompat.SOURCE_TOUCHSCREEN, i, j, j2, f, f2, 1.0f);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void injectMotionEvent(InputManager inputManager, Method method, int i, int i2, long j, long j2, float f, float f2, float f3) throws InvocationTargetException, IllegalAccessException {
        MotionEvent obtain = MotionEvent.obtain(j, j2, i2, f, f2, f3, 1.0f, 0, 1.0f, 1.0f, 0, 0);
        obtain.setSource(i);
        method.invoke(inputManager, obtain, 0);
    }

    private void setIsKeyInput() throws RemoteException {
        IGuardService iGuardService;
        if (!this.isShowMainActivity || (iGuardService = this.mGuardService) == null) {
            return;
        }
        iGuardService.setLocked(false);
    }
}
