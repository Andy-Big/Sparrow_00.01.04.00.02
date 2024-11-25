package com.rigol.scope;

import android.app.Application;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.UtilityParamKt;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.KeyCodeUtil;
import com.rigol.scope.utilities.MappingHelper;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.util.FragmentLifecycleAdapter;
import com.rigol.util.ToastUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import me.jessyan.autosize.AutoSizeCompat;
import timber.log.Timber;
/* loaded from: classes.dex */
public class BaseActivity extends AppCompatActivity {
    public static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    public static final String NAMESPACE_AUTO = "http://schemas.android.com/apk/res-auto";
    private PanelKeyViewModel panelKeyViewModel;
    private SharedViewModel sharedViewModel;
    protected SyncDataViewModel syncDataViewModel;
    private TriggerParam triggerParam;
    private UpdateUIViewModel updateUIViewModel;
    private final SparseArray<String> themeViewIds = new SparseArray<>();
    private final HashMap<View, Integer> textViews = new HashMap<>();
    private long lastTouchDownTime = 0;
    private boolean touchEventValid = false;
    private int KeyNewCode = 0;
    private final FragmentLifecycleAdapter fragmentLifecycleCallbacks = new FragmentLifecycleAdapter();
    private List<Integer> arrayList_ch = new ArrayList();
    private List<Integer> arrayList_inputCh = new ArrayList();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        ViewUtil.hideSystemUI(getWindow().getDecorView());
        super.onCreate(bundle);
        this.arrayList_ch.add(21);
        this.arrayList_ch.add(22);
        this.arrayList_ch.add(22);
        SharedViewModel sharedViewModel = (SharedViewModel) getAppViewModelProvider().get(SharedViewModel.class);
        this.sharedViewModel = sharedViewModel;
        sharedViewModel.nightThemeEnable.observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$BaseActivity$_fOJPw9SuDSBbspVEASM1ho8YlY
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseActivity.this.setNightTheme((Boolean) obj);
            }
        });
        this.panelKeyViewModel = (PanelKeyViewModel) getAppViewModelProvider().get(PanelKeyViewModel.class);
        this.updateUIViewModel = (UpdateUIViewModel) MessageBus.getInstance().with(getAppViewModelProvider()).get(UpdateUIViewModel.class);
        this.syncDataViewModel = (SyncDataViewModel) MessageBus.getInstance().with(getAppViewModelProvider()).get(SyncDataViewModel.class);
        this.triggerParam = ((TriggerViewModel) MessageBus.getInstance().with(getAppViewModelProvider()).get(TriggerViewModel.class)).getValue();
        getSupportFragmentManager().registerFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks, true);
    }

    public SharedViewModel getSharedViewModel() {
        return this.sharedViewModel;
    }

    public SyncDataViewModel getSyncDataViewModel() {
        return this.syncDataViewModel;
    }

    public PanelKeyViewModel getPanelKeyViewModel() {
        return this.panelKeyViewModel;
    }

    public UpdateUIViewModel getUpdateUIViewModel() {
        return this.updateUIViewModel;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        for (Map.Entry<View, Integer> entry : this.textViews.entrySet()) {
            TextView textView = (TextView) entry.getKey();
            int intValue = entry.getValue().intValue();
            if (textView != null) {
                try {
                    textView.setText(intValue);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        MappingHelper.getInstance().reload(this);
        this.sharedViewModel.localeChanged.setValue(true);
        onLocaleChanged();
        Timber.d("onConfigurationChanged: %s", configuration.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setNightTheme(Boolean bool) {
        if (bool.booleanValue()) {
            setTheme(R.style.AppTheme_Night);
        } else {
            setTheme(R.style.AppTheme_Day);
        }
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(R.styleable.ThemeView);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        int resourceId2 = obtainStyledAttributes.getResourceId(1, -1);
        for (int i = 0; i < this.themeViewIds.size(); i++) {
            int keyAt = this.themeViewIds.keyAt(i);
            View findViewById = findViewById(keyAt);
            for (String str : this.themeViewIds.get(keyAt).split("\\|")) {
                if (str.split(":")[1].equals("custom_attr_app_bg")) {
                    findViewById.setBackgroundResource(resourceId);
                } else {
                    findViewById.setBackgroundResource(resourceId2);
                }
            }
        }
    }

    @Override // android.app.Activity
    public LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = super.getLayoutInflater();
        try {
            Field declaredField = LayoutInflater.class.getDeclaredField("mFactorySet");
            declaredField.setAccessible(true);
            declaredField.set(layoutInflater, false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        layoutInflater.setFactory2(new LayoutInflater.Factory2() { // from class: com.rigol.scope.BaseActivity.1
            @Override // android.view.LayoutInflater.Factory
            public View onCreateView(String str, Context context, AttributeSet attributeSet) {
                return null;
            }

            @Override // android.view.LayoutInflater.Factory2
            public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
                View createView = BaseActivity.this.getDelegate().createView(view, str, context, attributeSet);
                String attributeValue = attributeSet.getAttributeValue(BaseActivity.NAMESPACE_AUTO, "skin_tag");
                String attributeValue2 = attributeSet.getAttributeValue(BaseActivity.NAMESPACE_ANDROID, "text");
                if (!TextUtils.isEmpty(attributeValue2) && attributeValue2.startsWith("@")) {
                    BaseActivity.this.textViews.put(createView, Integer.valueOf(Integer.parseInt(attributeValue2.substring(1))));
                }
                if (!TextUtils.isEmpty(attributeValue)) {
                    BaseActivity.this.themeViewIds.put(Integer.parseInt(attributeSet.getAttributeValue(BaseActivity.NAMESPACE_ANDROID, "id").substring(1)), attributeValue);
                }
                return createView;
            }
        });
        return layoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ViewModelProvider getAppViewModelProvider() {
        return ((App) getApplicationContext()).getAppViewModelProvider(this);
    }

    public ViewModelProvider getActivityViewModelProvider(AppCompatActivity appCompatActivity) {
        return new ViewModelProvider(appCompatActivity, appCompatActivity.getDefaultViewModelProviderFactory());
    }

    public ViewModelProvider getActivityViewModelProvider() {
        return new ViewModelProvider(this, getDefaultViewModelProviderFactory());
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            ViewUtil.hideSystemUI(getWindow().getDecorView());
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int panelKey = KeyCodeUtil.getPanelKey(i);
        if (ViewUtil.isCalibrationStarted() || ViewUtil.isRecording() || ((ViewUtil.isPassFailRunning() && panelKey != 12) || PopupViewManager.getInstance().isLoadingClassShowing() || ((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getLiveData().getValue().readLockKeyboard())) {
            ToastUtils.showShort(getResources().getString(R.string.err_action_disabled));
            return true;
        }
        if (panelKey > 0) {
            Timber.d("onPanelkeyDownonPanelkeyDown, panelKey:" + panelKey + ", keyEvent.getRepeatCount():" + keyEvent.getRepeatCount() + ", toString():" + keyEvent.toString(), new Object[0]);
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int panelKey = KeyCodeUtil.getPanelKey(i);
        if (panelKey == 27) {
            this.panelKeyViewModel.getOnKeyUpData().setValue(keyEvent);
            UtilityParamKt.saveTone();
            return super.onKeyUp(i, keyEvent);
        }
        int i2 = this.KeyNewCode;
        if (i2 == 0 || (i2 >= 138 && i2 != 25 && i2 != 20 && i2 != 12 && i2 != 4 && i2 != 32 && i2 != 5)) {
            this.KeyNewCode = panelKey;
            if (panelKey == this.arrayList_ch.get(0).intValue()) {
                this.arrayList_inputCh.clear();
            }
            if (((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getLiveData().getValue().readLockKeyboard()) {
                this.arrayList_inputCh.add(Integer.valueOf(panelKey));
                if (this.arrayList_inputCh.size() == 3) {
                    if (this.arrayList_inputCh.get(0) == this.arrayList_ch.get(0) && this.arrayList_inputCh.get(1) == this.arrayList_ch.get(1) && this.arrayList_inputCh.get(2) == this.arrayList_ch.get(2)) {
                        ((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getLiveData().getValue().saveLockKeyboard(false);
                        ViewUtil.lock(ActivityUtils.getTopActivity().getWindow(), false);
                        ToastUtils.showShort(getResources().getString(R.string.utility_50));
                        API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.TOUCH_LED_WHITE.value1, 0);
                        return true;
                    }
                    this.arrayList_inputCh.clear();
                }
            }
            if (this.KeyNewCode != 0 && (API.getInstance().UI_QueryBool(14, MessageID.MSG_RECORD_START) || API.getInstance().UI_QueryBool(14, MessageID.MSG_RECORD_PLAY) || API.getInstance().UI_QueryBool(61, MessageID.MSG_BODE_RUNSTOP) || ViewUtil.isCalibrationStarted() || ((ViewUtil.isPassFailRunning() && panelKey != 12) || PopupViewManager.getInstance().isLoadingClassShowing() || (((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getLiveData().getValue().readLockKeyboard() && panelKey != 27)))) {
                if (7 == KeyCodeUtil.getPanelKey(keyEvent.getKeyCode())) {
                    this.panelKeyViewModel.getOnKeyUpData().setValue(keyEvent);
                    return super.onKeyUp(7, keyEvent);
                }
                ToastUtils.showShort(getResources().getString(R.string.err_action_disabled));
                return true;
            }
            if (panelKey > 0) {
                this.panelKeyViewModel.getOnKeyUpData().setValue(keyEvent);
                UtilityParamKt.saveTone();
            }
            return super.onKeyUp(i, keyEvent);
        }
        this.KeyNewCode = panelKey;
        return true;
    }

    @Override // android.app.Activity
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            long eventTime = motionEvent.getEventTime() - this.lastTouchDownTime;
            this.lastTouchDownTime = motionEvent.getEventTime();
            if (eventTime > 200 || eventTime < -200) {
                this.touchEventValid = true;
            } else {
                this.touchEventValid = false;
                return true;
            }
        } else if (!this.touchEventValid) {
            return true;
        }
        if (ViewUtil.isCalibrationStarted() || ViewUtil.isRecording() || ViewUtil.isPassFailRunning() || PopupViewManager.getInstance().isLoadingClassShowing()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_touch_disable));
            return true;
        }
        if (motionEvent.getActionMasked() == 1) {
            UtilityParamKt.saveTone();
            PopupViewManager.getInstance().setShowingWhenClickDown(false);
        }
        if (PopupViewManager.getInstance().isShowingCloseable()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }

    public void onLocaleChanged() {
        OptionParam value;
        Timber.d("onLocaleChanged", new Object[0]);
        PopupViewManager.getInstance().onLocaleChanged();
        WindowHolderManager.getInstance().onLocaleChanged();
        OptionViewModel optionViewModel = (OptionViewModel) ContextUtil.getAppViewModel(OptionViewModel.class);
        if (optionViewModel == null || (value = optionViewModel.getLiveData().getValue()) == null) {
            return;
        }
        value.readInfo();
    }

    @Override // android.app.Activity
    public void recreate() {
        getViewModelStore().clear();
        Application application = getApplication();
        if (application instanceof App) {
            ((App) application).getViewModelStore().clear();
        }
        super.recreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fragmentLifecycleCallbacks != null) {
            getSupportFragmentManager().unregisterFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks);
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources());
        }
        return super.getResources();
    }
}
