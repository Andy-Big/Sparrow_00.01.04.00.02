package com.blankj.utilcode.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.blankj.utilcode.R;
import com.blankj.utilcode.util.Utils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
/* loaded from: classes.dex */
public final class ToastUtils {
    private static final int COLOR_DEFAULT = -16777217;
    private static final ToastUtils DEFAULT_MAKER = make();
    private static final String NOTHING = "toast nothing";
    private static final String NULL = "toast null";
    private static final String TAG_TOAST = "TAG_TOAST";
    private static IToast iToast;
    private String mMode;
    private int mGravity = -1;
    private int mXOffset = -1;
    private int mYOffset = -1;
    private int mBgColor = COLOR_DEFAULT;
    private int mBgResource = -1;
    private int mTextColor = COLOR_DEFAULT;
    private int mTextSize = -1;
    private boolean isLong = false;
    private Drawable[] mIcons = new Drawable[4];
    private boolean isNotUseSystemToast = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface IToast {
        void cancel();

        void setToastView(View view);

        void setToastView(CharSequence charSequence);

        void show(int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MODE {
        public static final String DARK = "dark";
        public static final String LIGHT = "light";
    }

    public static ToastUtils make() {
        return new ToastUtils();
    }

    public final ToastUtils setMode(String str) {
        this.mMode = str;
        return this;
    }

    public final ToastUtils setGravity(int i, int i2, int i3) {
        this.mGravity = i;
        this.mXOffset = i2;
        this.mYOffset = i3;
        return this;
    }

    public final ToastUtils setBgColor(int i) {
        this.mBgColor = i;
        return this;
    }

    public final ToastUtils setBgResource(int i) {
        this.mBgResource = i;
        return this;
    }

    public final ToastUtils setTextColor(int i) {
        this.mTextColor = i;
        return this;
    }

    public final ToastUtils setTextSize(int i) {
        this.mTextSize = i;
        return this;
    }

    public final ToastUtils setDurationIsLong(boolean z) {
        this.isLong = z;
        return this;
    }

    public final ToastUtils setLeftIcon(int i) {
        return setLeftIcon(ContextCompat.getDrawable(Utils.getApp(), i));
    }

    public final ToastUtils setLeftIcon(Drawable drawable) {
        this.mIcons[0] = drawable;
        return this;
    }

    public final ToastUtils setTopIcon(int i) {
        return setTopIcon(ContextCompat.getDrawable(Utils.getApp(), i));
    }

    public final ToastUtils setTopIcon(Drawable drawable) {
        this.mIcons[1] = drawable;
        return this;
    }

    public final ToastUtils setRightIcon(int i) {
        return setRightIcon(ContextCompat.getDrawable(Utils.getApp(), i));
    }

    public final ToastUtils setRightIcon(Drawable drawable) {
        this.mIcons[2] = drawable;
        return this;
    }

    public final ToastUtils setBottomIcon(int i) {
        return setBottomIcon(ContextCompat.getDrawable(Utils.getApp(), i));
    }

    public final ToastUtils setBottomIcon(Drawable drawable) {
        this.mIcons[3] = drawable;
        return this;
    }

    public final ToastUtils setNotUseSystemToast() {
        this.isNotUseSystemToast = true;
        return this;
    }

    public static ToastUtils getDefaultMaker() {
        return DEFAULT_MAKER;
    }

    public final void show(CharSequence charSequence) {
        show(charSequence, getDuration(), this);
    }

    public final void show(int i) {
        show(UtilsBridge.getString(i), getDuration(), this);
    }

    public final void show(int i, Object... objArr) {
        show(UtilsBridge.getString(i, objArr), getDuration(), this);
    }

    public final void show(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), getDuration(), this);
    }

    public final void show(View view) {
        show(view, getDuration(), this);
    }

    private int getDuration() {
        return this.isLong ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public View tryApplyUtilsToastView(CharSequence charSequence) {
        if (!MODE.DARK.equals(this.mMode) && !MODE.LIGHT.equals(this.mMode)) {
            Drawable[] drawableArr = this.mIcons;
            if (drawableArr[0] == null && drawableArr[1] == null && drawableArr[2] == null && drawableArr[3] == null) {
                return null;
            }
        }
        View layoutId2View = UtilsBridge.layoutId2View(R.layout.utils_toast_view);
        TextView textView = (TextView) layoutId2View.findViewById(16908299);
        if (MODE.DARK.equals(this.mMode)) {
            ((GradientDrawable) layoutId2View.getBackground().mutate()).setColor(Color.parseColor("#BB000000"));
            textView.setTextColor(-1);
        }
        textView.setText(charSequence);
        if (this.mIcons[0] != null) {
            View findViewById = layoutId2View.findViewById(R.id.utvLeftIconView);
            ViewCompat.setBackground(findViewById, this.mIcons[0]);
            findViewById.setVisibility(0);
        }
        if (this.mIcons[1] != null) {
            View findViewById2 = layoutId2View.findViewById(R.id.utvTopIconView);
            ViewCompat.setBackground(findViewById2, this.mIcons[1]);
            findViewById2.setVisibility(0);
        }
        if (this.mIcons[2] != null) {
            View findViewById3 = layoutId2View.findViewById(R.id.utvRightIconView);
            ViewCompat.setBackground(findViewById3, this.mIcons[2]);
            findViewById3.setVisibility(0);
        }
        if (this.mIcons[3] != null) {
            View findViewById4 = layoutId2View.findViewById(R.id.utvBottomIconView);
            ViewCompat.setBackground(findViewById4, this.mIcons[3]);
            findViewById4.setVisibility(0);
        }
        return layoutId2View;
    }

    public static void showShort(CharSequence charSequence) {
        show(charSequence, 0, DEFAULT_MAKER);
    }

    public static void showShort(int i) {
        show(UtilsBridge.getString(i), 0, DEFAULT_MAKER);
    }

    public static void showShort(int i, Object... objArr) {
        show(UtilsBridge.getString(i, objArr), 0, DEFAULT_MAKER);
    }

    public static void showShort(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), 0, DEFAULT_MAKER);
    }

    public static void showLong(CharSequence charSequence) {
        show(charSequence, 1, DEFAULT_MAKER);
    }

    public static void showLong(int i) {
        show(UtilsBridge.getString(i), 1, DEFAULT_MAKER);
    }

    public static void showLong(int i, Object... objArr) {
        show(UtilsBridge.getString(i), 1, DEFAULT_MAKER);
    }

    public static void showLong(String str, Object... objArr) {
        show(UtilsBridge.format(str, objArr), 1, DEFAULT_MAKER);
    }

    public static void cancel() {
        IToast iToast2 = iToast;
        if (iToast2 != null) {
            iToast2.cancel();
            iToast = null;
        }
    }

    private static void show(CharSequence charSequence, int i, ToastUtils toastUtils) {
        show(null, getToastFriendlyText(charSequence), i, toastUtils);
    }

    private static void show(View view, int i, ToastUtils toastUtils) {
        show(view, null, i, toastUtils);
    }

    private static void show(final View view, final CharSequence charSequence, final int i, ToastUtils toastUtils) {
        UtilsBridge.runOnUiThread(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ToastUtils.cancel();
                IToast unused = ToastUtils.iToast = ToastUtils.newToast(ToastUtils.this);
                if (view != null) {
                    ToastUtils.iToast.setToastView(view);
                } else {
                    ToastUtils.iToast.setToastView(charSequence);
                }
                ToastUtils.iToast.show(i);
            }
        });
    }

    private static CharSequence getToastFriendlyText(CharSequence charSequence) {
        return charSequence == null ? NULL : charSequence.length() == 0 ? NOTHING : charSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static IToast newToast(ToastUtils toastUtils) {
        if (!toastUtils.isNotUseSystemToast && NotificationManagerCompat.from(Utils.getApp()).areNotificationsEnabled()) {
            if (Build.VERSION.SDK_INT < 23) {
                return new SystemToast(toastUtils);
            }
            if (!UtilsBridge.isGrantedDrawOverlays()) {
                return new SystemToast(toastUtils);
            }
        }
        if (Build.VERSION.SDK_INT < 25) {
            return new WindowManagerToast(toastUtils, 2005);
        }
        if (UtilsBridge.isGrantedDrawOverlays()) {
            if (Build.VERSION.SDK_INT >= 26) {
                new WindowManagerToast(toastUtils, 2038);
            } else {
                new WindowManagerToast(toastUtils, 2002);
            }
        }
        return new ActivityToast(toastUtils);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class SystemToast extends AbsToast {
        SystemToast(ToastUtils toastUtils) {
            super(toastUtils);
            if (Build.VERSION.SDK_INT == 25) {
                try {
                    Field declaredField = Toast.class.getDeclaredField("mTN");
                    declaredField.setAccessible(true);
                    Object obj = declaredField.get(this.mToast);
                    Field declaredField2 = declaredField.getType().getDeclaredField("mHandler");
                    declaredField2.setAccessible(true);
                    declaredField2.set(obj, new SafeHandler((Handler) declaredField2.get(obj)));
                } catch (Exception unused) {
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            if (this.mToast == null) {
                return;
            }
            this.mToast.setDuration(i);
            this.mToast.show();
        }

        /* loaded from: classes.dex */
        static class SafeHandler extends Handler {
            private Handler impl;

            SafeHandler(Handler handler) {
                this.impl = handler;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message == null) {
                    throw new NullPointerException("Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                }
                this.impl.handleMessage(message);
            }

            @Override // android.os.Handler
            public void dispatchMessage(Message message) {
                if (message == null) {
                    throw new NullPointerException("Argument 'msg' of type Message (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                }
                try {
                    this.impl.dispatchMessage(message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class WindowManagerToast extends AbsToast {
        private Utils.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;
        private WindowManager.LayoutParams mParams;
        private WindowManager mWM;

        WindowManagerToast(ToastUtils toastUtils, int i) {
            super(toastUtils);
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            this.mParams = layoutParams;
            layoutParams.type = i;
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            if (this.mToast == null) {
                return;
            }
            this.mParams.height = -2;
            this.mParams.width = -2;
            this.mParams.format = -3;
            this.mParams.windowAnimations = 16973828;
            this.mParams.setTitle("ToastWithoutNotification");
            this.mParams.flags = 152;
            this.mParams.packageName = Utils.getApp().getPackageName();
            this.mParams.gravity = this.mToast.getGravity();
            if ((this.mParams.gravity & 7) == 7) {
                this.mParams.horizontalWeight = 1.0f;
            }
            if ((this.mParams.gravity & 112) == 112) {
                this.mParams.verticalWeight = 1.0f;
            }
            this.mParams.x = this.mToast.getXOffset();
            this.mParams.y = this.mToast.getYOffset();
            this.mParams.horizontalMargin = this.mToast.getHorizontalMargin();
            this.mParams.verticalMargin = this.mToast.getVerticalMargin();
            WindowManager windowManager = (WindowManager) Utils.getApp().getSystemService("window");
            this.mWM = windowManager;
            if (windowManager != null) {
                try {
                    windowManager.addView(this.mToastView, this.mParams);
                } catch (Exception unused) {
                }
            }
            UtilsBridge.runOnUiThreadDelayed(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.WindowManagerToast.1
                @Override // java.lang.Runnable
                public void run() {
                    WindowManagerToast.this.cancel();
                }
            }, i == 0 ? 2000L : 3500L);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.AbsToast, com.blankj.utilcode.util.ToastUtils.IToast
        public void cancel() {
            try {
                if (this.mWM != null) {
                    this.mWM.removeViewImmediate(this.mToastView);
                    this.mWM = null;
                }
            } catch (Exception unused) {
            }
            super.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class ActivityToast extends AbsToast {
        private static int sShowingIndex;
        private Utils.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

        ActivityToast(ToastUtils toastUtils) {
            super(toastUtils);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void show(int i) {
            if (this.mToast == null) {
                return;
            }
            if (!UtilsBridge.isAppForeground()) {
                showSystemToast(i);
                return;
            }
            boolean z = false;
            for (Activity activity : UtilsBridge.getActivityList()) {
                if (UtilsBridge.isActivityAlive(activity)) {
                    showWithActivity(activity, sShowingIndex, true);
                    z = true;
                }
            }
            if (z) {
                registerLifecycleCallback();
                UtilsBridge.runOnUiThreadDelayed(new Runnable() { // from class: com.blankj.utilcode.util.ToastUtils.ActivityToast.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityToast.this.cancel();
                    }
                }, i == 0 ? 2000L : 3500L);
                sShowingIndex++;
                return;
            }
            showSystemToast(i);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.AbsToast, com.blankj.utilcode.util.ToastUtils.IToast
        public void cancel() {
            Window window;
            if (isShowing()) {
                unregisterLifecycleCallback();
                for (Activity activity : UtilsBridge.getActivityList()) {
                    if (UtilsBridge.isActivityAlive(activity) && (window = activity.getWindow()) != null) {
                        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                        StringBuilder sb = new StringBuilder();
                        sb.append(ToastUtils.TAG_TOAST);
                        sb.append(sShowingIndex - 1);
                        View findViewWithTag = viewGroup.findViewWithTag(sb.toString());
                        if (findViewWithTag != null) {
                            try {
                                viewGroup.removeView(findViewWithTag);
                            } catch (Exception unused) {
                            }
                        }
                    }
                }
            }
            super.cancel();
        }

        private void showSystemToast(int i) {
            SystemToast systemToast = new SystemToast(this.mToastUtils);
            systemToast.mToast = this.mToast;
            systemToast.show(i);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void showWithActivity(Activity activity, int i, boolean z) {
            Window window = activity.getWindow();
            if (window != null) {
                ViewGroup viewGroup = (ViewGroup) window.getDecorView();
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.gravity = this.mToast.getGravity();
                layoutParams.bottomMargin = this.mToast.getYOffset() + UtilsBridge.getNavBarHeight();
                layoutParams.leftMargin = this.mToast.getXOffset();
                View toastViewSnapshot = getToastViewSnapshot(i);
                if (z) {
                    toastViewSnapshot.setAlpha(0.0f);
                    toastViewSnapshot.animate().alpha(1.0f).setDuration(200L).start();
                }
                viewGroup.addView(toastViewSnapshot, layoutParams);
            }
        }

        private View getToastViewSnapshot(int i) {
            Bitmap view2Bitmap = UtilsBridge.view2Bitmap(this.mToastView);
            ImageView imageView = new ImageView(Utils.getApp());
            imageView.setTag(ToastUtils.TAG_TOAST + i);
            imageView.setImageBitmap(view2Bitmap);
            return imageView;
        }

        private void registerLifecycleCallback() {
            final int i = sShowingIndex;
            Utils.ActivityLifecycleCallbacks activityLifecycleCallbacks = new Utils.ActivityLifecycleCallbacks() { // from class: com.blankj.utilcode.util.ToastUtils.ActivityToast.2
                @Override // com.blankj.utilcode.util.Utils.ActivityLifecycleCallbacks
                public void onActivityCreated(Activity activity) {
                    if (activity != null) {
                        if (ActivityToast.this.isShowing()) {
                            ActivityToast.this.showWithActivity(activity, i, false);
                            return;
                        }
                        return;
                    }
                    throw new NullPointerException("Argument 'activity' of type Activity (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                }
            };
            this.mActivityLifecycleCallbacks = activityLifecycleCallbacks;
            UtilsBridge.addActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }

        private void unregisterLifecycleCallback() {
            UtilsBridge.removeActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
            this.mActivityLifecycleCallbacks = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isShowing() {
            return this.mActivityLifecycleCallbacks != null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static abstract class AbsToast implements IToast {
        protected Toast mToast = new Toast(Utils.getApp());
        protected ToastUtils mToastUtils;
        protected View mToastView;

        AbsToast(ToastUtils toastUtils) {
            this.mToastUtils = toastUtils;
            if (toastUtils.mGravity == -1 && this.mToastUtils.mXOffset == -1 && this.mToastUtils.mYOffset == -1) {
                return;
            }
            this.mToast.setGravity(this.mToastUtils.mGravity, this.mToastUtils.mXOffset, this.mToastUtils.mYOffset);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void setToastView(View view) {
            this.mToastView = view;
            this.mToast.setView(view);
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void setToastView(CharSequence charSequence) {
            View tryApplyUtilsToastView = this.mToastUtils.tryApplyUtilsToastView(charSequence);
            if (tryApplyUtilsToastView != null) {
                setToastView(tryApplyUtilsToastView);
                return;
            }
            View view = this.mToast.getView();
            this.mToastView = view;
            if (view == null || view.findViewById(16908299) == null) {
                setToastView(UtilsBridge.layoutId2View(R.layout.utils_toast_view));
            }
            TextView textView = (TextView) this.mToastView.findViewById(16908299);
            textView.setText(charSequence);
            if (this.mToastUtils.mTextColor != ToastUtils.COLOR_DEFAULT) {
                textView.setTextColor(this.mToastUtils.mTextColor);
            }
            if (this.mToastUtils.mTextSize != -1) {
                textView.setTextSize(this.mToastUtils.mTextSize);
            }
            setBg(textView);
        }

        protected void setBg(TextView textView) {
            if (this.mToastUtils.mBgResource != -1) {
                this.mToastView.setBackgroundResource(this.mToastUtils.mBgResource);
                textView.setBackgroundColor(0);
            } else if (this.mToastUtils.mBgColor != ToastUtils.COLOR_DEFAULT) {
                Drawable background = this.mToastView.getBackground();
                Drawable background2 = textView.getBackground();
                if (background != null && background2 != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                    textView.setBackgroundColor(0);
                } else if (background != null) {
                    background.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                } else if (background2 != null) {
                    background2.mutate().setColorFilter(new PorterDuffColorFilter(this.mToastUtils.mBgColor, PorterDuff.Mode.SRC_IN));
                } else {
                    this.mToastView.setBackgroundColor(this.mToastUtils.mBgColor);
                }
            }
        }

        @Override // com.blankj.utilcode.util.ToastUtils.IToast
        public void cancel() {
            Toast toast = this.mToast;
            if (toast != null) {
                toast.cancel();
            }
            this.mToast = null;
            this.mToastView = null;
        }
    }

    /* loaded from: classes.dex */
    public static final class UtilsMaxWidthRelativeLayout extends RelativeLayout {
        private static final int SPACING = UtilsBridge.dp2px(80.0f);

        public UtilsMaxWidthRelativeLayout(Context context) {
            super(context);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public UtilsMaxWidthRelativeLayout(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
        }

        @Override // android.widget.RelativeLayout, android.view.View
        protected void onMeasure(int i, int i2) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(UtilsBridge.getAppScreenWidth() - SPACING, Integer.MIN_VALUE), i2);
        }
    }
}
