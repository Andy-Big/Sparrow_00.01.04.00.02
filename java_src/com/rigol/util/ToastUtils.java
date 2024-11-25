package com.rigol.util;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.blankj.utilcode.util.StringUtils;
import com.blankj.utilcode.util.Utils;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ToastUtils.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\rJ\u001e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006J\"\u0010\u0014\u001a\u00020\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0017\u001a\u00020\u0006J\u0016\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u001b\u001a\u00020\u0006H\u0007J/\u0010\u001a\u001a\u00020\r2\b\b\u0001\u0010\u001b\u001a\u00020\u00062\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001d\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u001eJ/\u0010\u001a\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001d\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J\u0012\u0010\"\u001a\u00020\r2\b\b\u0001\u0010\u001b\u001a\u00020\u0006H\u0007J/\u0010\"\u001a\u00020\r2\b\b\u0001\u0010\u001b\u001a\u00020\u00062\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001d\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u001eJ/\u0010\"\u001a\u00020\r2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0016\u0010\u001c\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u001d\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010!R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/rigol/util/ToastUtils;", "", "()V", "handler", "Landroid/os/Handler;", "mGravity", "", "mTextSize", "mXOffset", "mYOffset", "toast", "Landroid/widget/Toast;", "cancel", "", "setGravity", "gravity", "xOffset", "yOffset", "setTextSize", "textSize", "show", "view", "Landroid/view/View;", "duration", "text", "", "showLong", "resId", "args", "", "(I[Ljava/lang/Object;)V", "format", "", "(Ljava/lang/String;[Ljava/lang/Object;)V", "showShort", "lib_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class ToastUtils {
    private static final Handler handler;
    private static Toast toast;
    public static final ToastUtils INSTANCE = new ToastUtils();
    private static int mGravity = -1;
    private static int mXOffset = -1;
    private static int mYOffset = -1;
    private static int mTextSize = -1;

    static {
        final Looper mainLooper = Looper.getMainLooper();
        handler = new Handler(mainLooper) { // from class: com.rigol.util.ToastUtils$handler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Toast toast2;
                Toast toast3;
                int i;
                int i2;
                Toast toast4;
                Toast toast5;
                int i3;
                int i4;
                int i5;
                Toast toast6;
                int i6;
                Toast toast7;
                Intrinsics.checkNotNullParameter(msg, "msg");
                super.handleMessage(msg);
                int i7 = msg.what;
                if (i7 != 0) {
                    if (i7 == 1 && (msg.obj instanceof ToastParam)) {
                        ToastUtils toastUtils = ToastUtils.INSTANCE;
                        toast3 = ToastUtils.toast;
                        if (toast3 != null) {
                            toast3.cancel();
                        }
                        ToastUtils toastUtils2 = ToastUtils.INSTANCE;
                        Application app = Utils.getApp();
                        Object obj = msg.obj;
                        if (obj == null) {
                            throw new NullPointerException("null cannot be cast to non-null type com.rigol.util.ToastParam");
                        }
                        CharSequence text = ((ToastParam) obj).getText();
                        Object obj2 = msg.obj;
                        if (obj2 != null) {
                            ToastUtils.toast = Toast.makeText(app, text, ((ToastParam) obj2).getDuration());
                            Object obj3 = msg.obj;
                            if (obj3 == null) {
                                throw new NullPointerException("null cannot be cast to non-null type com.rigol.util.ToastParam");
                            }
                            if (((ToastParam) obj3).getView() != null) {
                                ToastUtils toastUtils3 = ToastUtils.INSTANCE;
                                toast7 = ToastUtils.toast;
                                if (toast7 != null) {
                                    Object obj4 = msg.obj;
                                    if (obj4 == null) {
                                        throw new NullPointerException("null cannot be cast to non-null type com.rigol.util.ToastParam");
                                    }
                                    toast7.setView(((ToastParam) obj4).getView());
                                }
                            }
                            ToastUtils toastUtils4 = ToastUtils.INSTANCE;
                            i = ToastUtils.mTextSize;
                            if (i != -1) {
                                ToastUtils toastUtils5 = ToastUtils.INSTANCE;
                                toast6 = ToastUtils.toast;
                                View view = toast6 != null ? toast6.getView() : null;
                                if (view == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
                                }
                                View childAt = ((ViewGroup) view).getChildAt(0);
                                if (childAt == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                                }
                                ToastUtils toastUtils6 = ToastUtils.INSTANCE;
                                i6 = ToastUtils.mTextSize;
                                ((TextView) childAt).setTextSize(i6);
                            }
                            ToastUtils toastUtils7 = ToastUtils.INSTANCE;
                            i2 = ToastUtils.mGravity;
                            if (i2 != -1) {
                                ToastUtils toastUtils8 = ToastUtils.INSTANCE;
                                toast5 = ToastUtils.toast;
                                if (toast5 != null) {
                                    ToastUtils toastUtils9 = ToastUtils.INSTANCE;
                                    i3 = ToastUtils.mGravity;
                                    ToastUtils toastUtils10 = ToastUtils.INSTANCE;
                                    i4 = ToastUtils.mXOffset;
                                    ToastUtils toastUtils11 = ToastUtils.INSTANCE;
                                    i5 = ToastUtils.mYOffset;
                                    toast5.setGravity(i3, i4, i5);
                                }
                            }
                            ToastUtils toastUtils12 = ToastUtils.INSTANCE;
                            toast4 = ToastUtils.toast;
                            if (toast4 != null) {
                                toast4.show();
                                return;
                            }
                            return;
                        }
                        throw new NullPointerException("null cannot be cast to non-null type com.rigol.util.ToastParam");
                    }
                    return;
                }
                ToastUtils toastUtils13 = ToastUtils.INSTANCE;
                toast2 = ToastUtils.toast;
                if (toast2 != null) {
                    toast2.cancel();
                }
            }
        };
    }

    private ToastUtils() {
    }

    public final ToastUtils setGravity(int i, int i2, int i3) {
        mGravity = i;
        mXOffset = i2;
        mYOffset = i3;
        return this;
    }

    public final ToastUtils setTextSize(int i) {
        mTextSize = i;
        return this;
    }

    @JvmStatic
    public static final void showShort(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        INSTANCE.show(text, 0);
    }

    @JvmStatic
    public static final void showShort(int i) {
        ToastUtils toastUtils = INSTANCE;
        String string = StringUtils.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "StringUtils.getString(resId)");
        toastUtils.show(string, 0);
    }

    @JvmStatic
    public static final void showShort(int i, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        ToastUtils toastUtils = INSTANCE;
        String string = StringUtils.getString(i, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(string, "StringUtils.getString(resId, *args)");
        toastUtils.show(string, 0);
    }

    @JvmStatic
    public static final void showShort(String str, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        ToastUtils toastUtils = INSTANCE;
        String format = StringUtils.format(str, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format, "StringUtils.format(format, *args)");
        toastUtils.show(format, 0);
    }

    @JvmStatic
    public static final void showLong(CharSequence text) {
        Intrinsics.checkNotNullParameter(text, "text");
        INSTANCE.show(text, 1);
    }

    @JvmStatic
    public static final void showLong(int i) {
        ToastUtils toastUtils = INSTANCE;
        String string = StringUtils.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "StringUtils.getString(resId)");
        toastUtils.show(string, 1);
    }

    @JvmStatic
    public static final void showLong(int i, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        ToastUtils toastUtils = INSTANCE;
        String string = StringUtils.getString(i, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(string, "StringUtils.getString(resId, *args)");
        toastUtils.show(string, 1);
    }

    @JvmStatic
    public static final void showLong(String str, Object... args) {
        Intrinsics.checkNotNullParameter(args, "args");
        ToastUtils toastUtils = INSTANCE;
        String format = StringUtils.format(str, Arrays.copyOf(args, args.length));
        Intrinsics.checkNotNullExpressionValue(format, "StringUtils.format(format, *args)");
        toastUtils.show(format, 1);
    }

    public final void show(CharSequence text, int i) {
        Intrinsics.checkNotNullParameter(text, "text");
        show(null, text, i);
    }

    public final void show(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        show(view, null, i);
    }

    public final void show(View view, CharSequence charSequence, int i) {
        handler.removeMessages(0);
        handler.removeMessages(1);
        Message obtain = Message.obtain();
        obtain.obj = new ToastParam(view, charSequence, i);
        obtain.what = 1;
        handler.sendMessage(obtain);
    }

    public final void cancel() {
        Toast toast2 = toast;
        if (toast2 != null) {
            toast2.cancel();
        }
        handler.removeMessages(0);
        handler.removeMessages(1);
        handler.sendEmptyMessage(0);
    }
}
