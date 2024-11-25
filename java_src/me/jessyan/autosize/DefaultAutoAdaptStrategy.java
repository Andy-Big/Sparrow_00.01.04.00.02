package me.jessyan.autosize;

import android.app.Activity;
import java.util.Locale;
import me.jessyan.autosize.external.ExternalAdaptInfo;
import me.jessyan.autosize.internal.CancelAdapt;
import me.jessyan.autosize.internal.CustomAdapt;
import me.jessyan.autosize.utils.AutoSizeLog;
/* loaded from: classes2.dex */
public class DefaultAutoAdaptStrategy implements AutoAdaptStrategy {
    @Override // me.jessyan.autosize.AutoAdaptStrategy
    public void applyAdapt(Object obj, Activity activity) {
        if (AutoSizeConfig.getInstance().getExternalAdaptManager().isRun()) {
            if (AutoSizeConfig.getInstance().getExternalAdaptManager().isCancelAdapt(obj.getClass())) {
                AutoSizeLog.w(String.format(Locale.ENGLISH, "%s canceled the adaptation!", obj.getClass().getName()));
                AutoSize.cancelAdapt(activity);
                return;
            }
            ExternalAdaptInfo externalAdaptInfoOfActivity = AutoSizeConfig.getInstance().getExternalAdaptManager().getExternalAdaptInfoOfActivity(obj.getClass());
            if (externalAdaptInfoOfActivity != null) {
                AutoSizeLog.d(String.format(Locale.ENGLISH, "%s used %s for adaptation!", obj.getClass().getName(), ExternalAdaptInfo.class.getName()));
                AutoSize.autoConvertDensityOfExternalAdaptInfo(activity, externalAdaptInfoOfActivity);
                return;
            }
        }
        if (obj instanceof CancelAdapt) {
            AutoSizeLog.w(String.format(Locale.ENGLISH, "%s canceled the adaptation!", obj.getClass().getName()));
            AutoSize.cancelAdapt(activity);
        } else if (obj instanceof CustomAdapt) {
            AutoSizeLog.d(String.format(Locale.ENGLISH, "%s implemented by %s!", obj.getClass().getName(), CustomAdapt.class.getName()));
            AutoSize.autoConvertDensityOfCustomAdapt(activity, (CustomAdapt) obj);
        } else {
            AutoSizeLog.d(String.format(Locale.ENGLISH, "%s used the global configuration.", obj.getClass().getName()));
            AutoSize.autoConvertDensityOfGlobal(activity);
        }
    }
}
