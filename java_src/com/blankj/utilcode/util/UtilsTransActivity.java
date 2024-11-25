package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.Utils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class UtilsTransActivity extends AppCompatActivity {
    private static final Map<UtilsTransActivity, TransActivityDelegate> CALLBACK_MAP = new HashMap();
    protected static final String EXTRA_DELEGATE = "extra_delegate";

    public static void start(TransActivityDelegate transActivityDelegate) {
        start(null, null, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void start(Utils.Consumer<Intent> consumer, TransActivityDelegate transActivityDelegate) {
        start(null, consumer, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void start(Activity activity, TransActivityDelegate transActivityDelegate) {
        start(activity, null, transActivityDelegate, UtilsTransActivity.class);
    }

    public static void start(Activity activity, Utils.Consumer<Intent> consumer, TransActivityDelegate transActivityDelegate) {
        start(activity, consumer, transActivityDelegate, UtilsTransActivity.class);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void start(Activity activity, Utils.Consumer<Intent> consumer, TransActivityDelegate transActivityDelegate, Class<?> cls) {
        if (transActivityDelegate == null) {
            return;
        }
        Intent intent = new Intent(Utils.getApp(), cls);
        intent.putExtra(EXTRA_DELEGATE, transActivityDelegate);
        if (consumer != null) {
            consumer.accept(intent);
        }
        if (activity == null) {
            intent.addFlags(268435456);
            Utils.getApp().startActivity(intent);
            return;
        }
        activity.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        overridePendingTransition(0, 0);
        Serializable serializableExtra = getIntent().getSerializableExtra(EXTRA_DELEGATE);
        if (!(serializableExtra instanceof TransActivityDelegate)) {
            super.onCreate(bundle);
            finish();
            return;
        }
        TransActivityDelegate transActivityDelegate = (TransActivityDelegate) serializableExtra;
        CALLBACK_MAP.put(this, transActivityDelegate);
        transActivityDelegate.onCreateBefore(this, bundle);
        super.onCreate(bundle);
        transActivityDelegate.onCreated(this, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onStarted(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onResumed(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onPaused(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onStopped(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onSaveInstanceState(this, bundle);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onDestroy(this);
        CALLBACK_MAP.remove(this);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (strArr == null) {
            throw new NullPointerException("Argument 'permissions' of type String[] (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (iArr == null) {
            throw new NullPointerException("Argument 'grantResults' of type int[] (#2 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        super.onRequestPermissionsResult(i, strArr, iArr);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onRequestPermissionsResult(this, i, strArr, iArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return;
        }
        transActivityDelegate.onActivityResult(this, i, i2, intent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        TransActivityDelegate transActivityDelegate = CALLBACK_MAP.get(this);
        if (transActivityDelegate == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        if (transActivityDelegate.dispatchTouchEvent(this, motionEvent)) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* loaded from: classes.dex */
    public static abstract class TransActivityDelegate implements Serializable {
        public void onCreateBefore(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onCreated(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onStarted(UtilsTransActivity utilsTransActivity) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onDestroy(UtilsTransActivity utilsTransActivity) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onResumed(UtilsTransActivity utilsTransActivity) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onPaused(UtilsTransActivity utilsTransActivity) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onStopped(UtilsTransActivity utilsTransActivity) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onSaveInstanceState(UtilsTransActivity utilsTransActivity, Bundle bundle) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onRequestPermissionsResult(UtilsTransActivity utilsTransActivity, int i, String[] strArr, int[] iArr) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            if (strArr == null) {
                throw new NullPointerException("Argument 'permissions' of type String[] (#2 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            if (iArr == null) {
                throw new NullPointerException("Argument 'grantResults' of type int[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public void onActivityResult(UtilsTransActivity utilsTransActivity, int i, int i2, Intent intent) {
            if (utilsTransActivity == null) {
                throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
        }

        public boolean dispatchTouchEvent(UtilsTransActivity utilsTransActivity, MotionEvent motionEvent) {
            if (utilsTransActivity != null) {
                return false;
            }
            throw new NullPointerException("Argument 'activity' of type UtilsTransActivity (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
    }
}
