package com.rigol.scope.utilities;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.AppUtils;
import com.rigol.scope.App;
import com.rigol.scope.BaseActivity;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.views.cursor.CustomTypefaceSpan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* loaded from: classes2.dex */
public class ContextUtil {
    public static final int NOT_A_VALID_RESOURCE_ID = 0;

    public static String[] getStringArray(Context context, int i) {
        return context.getResources().getStringArray(i);
    }

    public static List<String> getStringList(Context context, int i) {
        return Arrays.asList(getStringArray(context, i));
    }

    public static Drawable[] getDrawableArray(Context context, int i) {
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i);
        Drawable[] drawableArr = new Drawable[obtainTypedArray.length()];
        for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
            int resourceId = obtainTypedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                drawableArr[i2] = ContextCompat.getDrawable(context, resourceId);
            }
        }
        obtainTypedArray.recycle();
        return drawableArr;
    }

    public static List<Drawable> getDrawableList(Context context, int i) {
        return Arrays.asList(getDrawableArray(context, i));
    }

    public static int[] getIdArray(Context context, int i) {
        TypedArray obtainTypedArray = context.getResources().obtainTypedArray(i);
        int[] iArr = new int[obtainTypedArray.length()];
        for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
            int resourceId = obtainTypedArray.getResourceId(i2, 0);
            if (resourceId != 0) {
                iArr[i2] = resourceId;
            }
        }
        obtainTypedArray.recycle();
        return iArr;
    }

    public static List<Integer> getIdList(Context context, int i) {
        ArrayList arrayList = new ArrayList();
        for (int i2 : getIdArray(context, i)) {
            arrayList.add(Integer.valueOf(i2));
        }
        return arrayList;
    }

    public static int getInteger(Context context, int i) {
        return context.getResources().getInteger(i);
    }

    public static String getString(Context context, String str) {
        int identifier = getIdentifier(context, str, "string");
        if (identifier == 0) {
            return null;
        }
        return context.getResources().getString(identifier);
    }

    public static Drawable getDrawable(int i) {
        return getDrawable(ActivityUtils.getTopActivity(), i);
    }

    public static Drawable getDrawable(Context context, int i) {
        return ContextCompat.getDrawable(context, i);
    }

    public static Drawable getDrawable(Context context, String str) {
        int identifier = getIdentifier(context, str, "drawable");
        if (identifier == 0) {
            return null;
        }
        return getDrawable(context, identifier);
    }

    public static Bitmap DrawableToBitmap(Drawable drawable) {
        if (drawable == null) {
            return null;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public static int getIdentifier(Context context, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, AppUtils.getAppPackageName());
    }

    public static void setTextFormat(TextView textView, int i, String str) {
        textView.setText(String.format(textView.getContext().getString(i), str));
    }

    public static Drawable getSelectedBackground(int i, int i2) {
        return getSelectedBackground(ActivityUtils.getTopActivity(), i, i2);
    }

    public static Drawable getSelectedBackground(Context context, int i, int i2) {
        Drawable drawable = ContextCompat.getDrawable(context, i);
        if (drawable != null) {
            drawable = drawable.mutate();
            if (drawable instanceof LayerDrawable) {
                ((LayerDrawable) drawable).findDrawableByLayerId(R.id.background).setTint(i2);
            }
        }
        return drawable;
    }

    public static SpannableString getValueWithFont(Context context, int i, String str) {
        return getValueWithFont(context, i, str, 0, getLastNumIndex(str) + 1);
    }

    public static SpannableString getValueWithFont(Context context, int i, String str, int i2, int i3) {
        Typeface font;
        SpannableString spannableString = new SpannableString(str);
        if (!TextUtils.isEmpty(str) && i2 >= 0 && i3 < str.length() && i2 <= i3 && (font = ResourcesCompat.getFont(context, i)) != null) {
            spannableString.setSpan(new CustomTypefaceSpan(font), i2, i3, 33);
        }
        return spannableString;
    }

    private static int getLastNumIndex(String str) {
        if (str != null && str.length() != 0) {
            for (int length = str.length() - 1; length >= 0; length--) {
                char charAt = str.charAt(length);
                if (charAt >= '0' && charAt <= '9') {
                    return length;
                }
            }
        }
        return -1;
    }

    public static String getResultText(String str) {
        return TextUtils.isEmpty(str) ? "*****" : str;
    }

    public static String getMessage(int i) {
        String variableNameByValue = ReflectUtil.getVariableNameByValue(MessageID.class, Integer.valueOf(i));
        if (variableNameByValue == null || TextUtils.isEmpty(variableNameByValue)) {
            return null;
        }
        return getString(ActivityUtils.getTopActivity(), variableNameByValue.toLowerCase());
    }

    public static String getString(int i) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity != null) {
            return topActivity.getString(i);
        }
        return null;
    }

    public static int getColor(int i) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity != null) {
            return topActivity.getColor(i);
        }
        return 0;
    }

    public static float getAlpha(boolean z) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity != null) {
            TypedValue typedValue = new TypedValue();
            topActivity.getResources().getValue(z ? R.dimen.enable_alpha : R.dimen.disable_alpha, typedValue, true);
            return typedValue.getFloat();
        }
        return 1.0f;
    }

    public static ViewModelProvider getActivityViewModelProvider() {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity instanceof BaseActivity) {
            BaseActivity baseActivity = (BaseActivity) topActivity;
            return baseActivity.getActivityViewModelProvider(baseActivity);
        }
        return null;
    }

    public static ViewModelProvider getAppViewModelProvider() {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity instanceof BaseActivity) {
            Application application = topActivity.getApplication();
            if (application instanceof App) {
                return ((App) application).getAppViewModelProvider(topActivity);
            }
            return null;
        }
        return null;
    }

    public static <T extends ViewModel> T getActivityViewModel(Class<T> cls) {
        ViewModelProvider activityViewModelProvider = getActivityViewModelProvider();
        if (activityViewModelProvider != null) {
            return (T) activityViewModelProvider.get(cls);
        }
        return null;
    }

    public static <T extends ViewModel> T getAppViewModel(Class<T> cls) {
        ViewModelProvider appViewModelProvider = getAppViewModelProvider();
        if (appViewModelProvider != null) {
            return (T) appViewModelProvider.get(cls);
        }
        return null;
    }
}
