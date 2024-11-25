package com.rigol.util;

import android.content.Intent;
import android.text.TextUtils;
import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.IntentUtils;
import com.blankj.utilcode.util.SPUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
/* compiled from: PackageUtil.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007J\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/rigol/util/PackageUtil;", "", "()V", "launchWhiteList", "", "", "getLaunchAppIntent", "Landroid/content/Intent;", "getLaunchAppPackageName", "lib_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class PackageUtil {
    public static final PackageUtil INSTANCE = new PackageUtil();
    private static final List<String> launchWhiteList = CollectionsKt.listOf((Object[]) new String[]{"com.rigol.scope", PackageUtilKt.PACKAGE_NAME_AWG});

    private PackageUtil() {
    }

    public final String getLaunchAppPackageName() {
        String string = SPUtils.getInstance().getString(PackageUtilKt.SHARED_PREFERENCES_LAUNCH_PACKAGE_NAME, "com.rigol.scope");
        if (TextUtils.isEmpty(string) || !AppUtils.isAppInstalled(string)) {
            for (String str : launchWhiteList) {
                if (AppUtils.isAppInstalled(str)) {
                    return str;
                }
            }
            return null;
        }
        return string;
    }

    public final Intent getLaunchAppIntent() {
        String launchAppPackageName = getLaunchAppPackageName();
        if (TextUtils.isEmpty(launchAppPackageName)) {
            return null;
        }
        return IntentUtils.getLaunchAppIntent(launchAppPackageName);
    }
}
