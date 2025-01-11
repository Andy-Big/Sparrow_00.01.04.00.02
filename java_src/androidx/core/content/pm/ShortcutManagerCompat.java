package androidx.core.content.pm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ShortcutInfoCompat;
import androidx.core.content.pm.ShortcutInfoCompatSaver;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ShortcutManagerCompat {
    static final String ACTION_INSTALL_SHORTCUT = "com.android.launcher.action.INSTALL_SHORTCUT";
    public static final String EXTRA_SHORTCUT_ID = "android.intent.extra.shortcut.ID";
    static final String INSTALL_SHORTCUT_PERMISSION = "com.android.launcher.permission.INSTALL_SHORTCUT";
    private static volatile ShortcutInfoCompatSaver<?> sShortcutInfoCompatSaver;

    private ShortcutManagerCompat() {
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isRequestPinShortcutSupported(Context context) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).isRequestPinShortcutSupported();
        }
        if (ContextCompat.checkSelfPermission(context, INSTALL_SHORTCUT_PERMISSION) != 0) {
            return false;
        }
        for (ResolveInfo resolveInfo : context.getPackageManager().queryBroadcastReceivers(new Intent(ACTION_INSTALL_SHORTCUT), 0)) {
            String str = resolveInfo.activityInfo.permission;
            if (TextUtils.isEmpty(str) || INSTALL_SHORTCUT_PERMISSION.equals(str)) {
                return true;
            }
            while (r4.hasNext()) {
            }
        }
        return false;
    }

    public static boolean requestPinShortcut(Context context, ShortcutInfoCompat shortcutInfoCompat, final IntentSender intentSender) {
        if (Build.VERSION.SDK_INT >= 26) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).requestPinShortcut(shortcutInfoCompat.toShortcutInfo(), intentSender);
        }
        if (isRequestPinShortcutSupported(context)) {
            Intent addToIntent = shortcutInfoCompat.addToIntent(new Intent(ACTION_INSTALL_SHORTCUT));
            if (intentSender == null) {
                context.sendBroadcast(addToIntent);
                return true;
            }
            context.sendOrderedBroadcast(addToIntent, null, new BroadcastReceiver() { // from class: androidx.core.content.pm.ShortcutManagerCompat.1
                @Override // android.content.BroadcastReceiver
                public void onReceive(Context context2, Intent intent) {
                    try {
                        intentSender.sendIntent(context2, 0, null, null, null);
                    } catch (IntentSender.SendIntentException unused) {
                    }
                }
            }, null, -1, null, null);
            return true;
        }
        return false;
    }

    public static Intent createShortcutResultIntent(Context context, ShortcutInfoCompat shortcutInfoCompat) {
        Intent createShortcutResultIntent = Build.VERSION.SDK_INT >= 26 ? ((ShortcutManager) context.getSystemService(ShortcutManager.class)).createShortcutResultIntent(shortcutInfoCompat.toShortcutInfo()) : null;
        if (createShortcutResultIntent == null) {
            createShortcutResultIntent = new Intent();
        }
        return shortcutInfoCompat.addToIntent(createShortcutResultIntent);
    }

    public static boolean addDynamicShortcuts(Context context, List<ShortcutInfoCompat> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList();
            for (ShortcutInfoCompat shortcutInfoCompat : list) {
                arrayList.add(shortcutInfoCompat.toShortcutInfo());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).addDynamicShortcuts(arrayList)) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        return true;
    }

    public static int getMaxShortcutCountPerActivity(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            return ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getMaxShortcutCountPerActivity();
        }
        return 0;
    }

    public static List<ShortcutInfoCompat> getDynamicShortcuts(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            List<ShortcutInfo> dynamicShortcuts = ((ShortcutManager) context.getSystemService(ShortcutManager.class)).getDynamicShortcuts();
            ArrayList arrayList = new ArrayList(dynamicShortcuts.size());
            for (ShortcutInfo shortcutInfo : dynamicShortcuts) {
                arrayList.add(new ShortcutInfoCompat.Builder(context, shortcutInfo).build());
            }
            return arrayList;
        }
        try {
            return getShortcutInfoSaverInstance(context).getShortcuts();
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static boolean updateShortcuts(Context context, List<ShortcutInfoCompat> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ArrayList arrayList = new ArrayList();
            for (ShortcutInfoCompat shortcutInfoCompat : list) {
                arrayList.add(shortcutInfoCompat.toShortcutInfo());
            }
            if (!((ShortcutManager) context.getSystemService(ShortcutManager.class)).updateShortcuts(arrayList)) {
                return false;
            }
        }
        getShortcutInfoSaverInstance(context).addShortcuts(list);
        return true;
    }

    public static void removeDynamicShortcuts(Context context, List<String> list) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeDynamicShortcuts(list);
        }
        getShortcutInfoSaverInstance(context).removeShortcuts(list);
    }

    public static void removeAllDynamicShortcuts(Context context) {
        if (Build.VERSION.SDK_INT >= 25) {
            ((ShortcutManager) context.getSystemService(ShortcutManager.class)).removeAllDynamicShortcuts();
        }
        getShortcutInfoSaverInstance(context).removeAllShortcuts();
    }

    private static ShortcutInfoCompatSaver<?> getShortcutInfoSaverInstance(Context context) {
        if (sShortcutInfoCompatSaver == null) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    sShortcutInfoCompatSaver = (ShortcutInfoCompatSaver) Class.forName("androidx.sharetarget.ShortcutInfoCompatSaverImpl", false, ShortcutManagerCompat.class.getClassLoader()).getMethod("getInstance", Context.class).invoke(null, context);
                } catch (Exception unused) {
                }
            }
            if (sShortcutInfoCompatSaver == null) {
                sShortcutInfoCompatSaver = new ShortcutInfoCompatSaver.NoopImpl();
            }
        }
        return sShortcutInfoCompatSaver;
    }
}
