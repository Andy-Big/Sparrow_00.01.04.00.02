package com.just.agentweb;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public final class ActionActivity extends Activity {
    public static final String KEY_ACTION = "KEY_ACTION";
    public static final String KEY_FILE_CHOOSER_INTENT = "KEY_FILE_CHOOSER_INTENT";
    public static final String KEY_FROM_INTENTION = "KEY_FROM_INTENTION";
    public static final String KEY_URI = "KEY_URI";
    public static final int REQUEST_CODE = 596;
    private static final String TAG = ActionActivity.class.getSimpleName();
    private static ChooserListener mChooserListener;
    private static PermissionListener mPermissionListener;
    private static RationaleListener mRationaleListener;
    private Action mAction;
    private Uri mUri;

    /* loaded from: classes.dex */
    public interface ChooserListener {
        void onChoiceResult(int i, int i2, Intent intent);
    }

    /* loaded from: classes.dex */
    public interface PermissionListener {
        void onRequestPermissionsResult(String[] strArr, int[] iArr, Bundle bundle);
    }

    /* loaded from: classes.dex */
    public interface RationaleListener {
        void onRationaleResult(boolean z, Bundle bundle);
    }

    public static void start(Activity activity, Action action) {
        Intent intent = new Intent(activity, ActionActivity.class);
        intent.putExtra(KEY_ACTION, action);
        activity.startActivity(intent);
    }

    public static void setChooserListener(ChooserListener chooserListener) {
        mChooserListener = chooserListener;
    }

    public static void setPermissionListener(PermissionListener permissionListener) {
        mPermissionListener = permissionListener;
    }

    private void cancelAction() {
        mChooserListener = null;
        mPermissionListener = null;
        mRationaleListener = null;
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            String str = TAG;
            LogUtils.i(str, "savedInstanceState:" + bundle);
            return;
        }
        Action action = (Action) getIntent().getParcelableExtra(KEY_ACTION);
        this.mAction = action;
        if (action == null) {
            cancelAction();
            finish();
        } else if (action.getAction() == 1) {
            permission(this.mAction);
        } else if (this.mAction.getAction() == 3) {
            realOpenCamera();
        } else if (this.mAction.getAction() == 4) {
            realOpenVideo();
        } else {
            fetchFile(this.mAction);
        }
    }

    private void fetchFile(Action action) {
        if (mChooserListener == null) {
            finish();
        }
        realOpenFileChooser();
    }

    private void realOpenFileChooser() {
        try {
            if (mChooserListener == null) {
                finish();
                return;
            }
            Intent intent = (Intent) getIntent().getParcelableExtra(KEY_FILE_CHOOSER_INTENT);
            if (intent == null) {
                cancelAction();
            } else {
                startActivityForResult(intent, 596);
            }
        } catch (Throwable th) {
            LogUtils.i(TAG, "找不到文件选择器");
            chooserActionCallback(-1, null);
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    private void chooserActionCallback(int i, Intent intent) {
        ChooserListener chooserListener = mChooserListener;
        if (chooserListener != null) {
            chooserListener.onChoiceResult(596, i, intent);
            mChooserListener = null;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 596) {
            if (this.mUri != null) {
                intent = new Intent().putExtra(KEY_URI, this.mUri);
            }
            chooserActionCallback(i2, intent);
        }
    }

    private void permission(Action action) {
        ArrayList<String> permissions = action.getPermissions();
        if (AgentWebUtils.isEmptyCollection(permissions)) {
            mPermissionListener = null;
            mRationaleListener = null;
            finish();
            return;
        }
        boolean z = false;
        if (mRationaleListener != null) {
            Iterator<String> it = permissions.iterator();
            while (it.hasNext() && !(z = shouldShowRequestPermissionRationale(it.next()))) {
            }
            mRationaleListener.onRationaleResult(z, new Bundle());
            mRationaleListener = null;
            finish();
        } else if (mPermissionListener != null) {
            requestPermissions((String[]) permissions.toArray(new String[0]), 1);
        }
    }

    private void realOpenCamera() {
        try {
            if (mChooserListener == null) {
                finish();
            }
            File createImageFile = AgentWebUtils.createImageFile(this);
            if (createImageFile == null) {
                mChooserListener.onChoiceResult(596, 0, null);
                mChooserListener = null;
                finish();
            }
            Intent intentCaptureCompat = AgentWebUtils.getIntentCaptureCompat(this, createImageFile);
            this.mUri = (Uri) intentCaptureCompat.getParcelableExtra("output");
            startActivityForResult(intentCaptureCompat, 596);
        } catch (Throwable th) {
            LogUtils.e(TAG, "找不到系统相机");
            ChooserListener chooserListener = mChooserListener;
            if (chooserListener != null) {
                chooserListener.onChoiceResult(596, 0, null);
            }
            mChooserListener = null;
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    private void realOpenVideo() {
        try {
            if (mChooserListener == null) {
                finish();
            }
            File createVideoFile = AgentWebUtils.createVideoFile(this);
            if (createVideoFile == null) {
                mChooserListener.onChoiceResult(596, 0, null);
                mChooserListener = null;
                finish();
            }
            Intent intentVideoCompat = AgentWebUtils.getIntentVideoCompat(this, createVideoFile);
            this.mUri = (Uri) intentVideoCompat.getParcelableExtra("output");
            startActivityForResult(intentVideoCompat, 596);
        } catch (Throwable th) {
            LogUtils.e(TAG, "找不到系统相机");
            ChooserListener chooserListener = mChooserListener;
            if (chooserListener != null) {
                chooserListener.onChoiceResult(596, 0, null);
            }
            mChooserListener = null;
            if (LogUtils.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (mPermissionListener != null) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_FROM_INTENTION, this.mAction.getFromIntention());
            mPermissionListener.onRequestPermissionsResult(strArr, iArr, bundle);
        }
        mPermissionListener = null;
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }
}
