package com.rigol.scope.utilities;

import android.app.AlarmManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.rigol.scope.data.DiskParam;
import com.rigol.util.DiskInfo;
import com.rigol.util.DiskUtil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public class UtilityUtil {
    public static void setAndroidSystemDate(int i, int i2, int i3, Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, i);
        calendar.set(2, i2);
        calendar.set(5, i3);
        long timeInMillis = calendar.getTimeInMillis();
        if (timeInMillis / 1000 < 2147483647L) {
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setTime(timeInMillis);
        }
    }

    public static void setAndroidSystemTime(int i, int i2, Context context) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, i);
        calendar.set(12, i2);
        long timeInMillis = calendar.getTimeInMillis();
        if (timeInMillis / 1000 < 2147483647L) {
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setTime(timeInMillis);
        }
    }

    public static DiskParam getFirstUsbDisk() {
        for (DiskParam diskParam : getDiskList()) {
            if (diskParam != null && diskParam.getRemovable()) {
                return diskParam;
            }
        }
        return null;
    }

    public static List<DiskParam> getDiskList() {
        ArrayList arrayList = new ArrayList();
        DiskParam diskParam = new DiskParam();
        diskParam.setRemovable(false);
        arrayList.add(diskParam);
        try {
            List<DiskInfo> mountedDiskInfos = DiskUtil.INSTANCE.getMountedDiskInfos();
            Collections.reverse(mountedDiskInfos);
            int i = 0;
            for (int i2 = 0; i2 < mountedDiskInfos.size(); i2++) {
                DiskInfo diskInfo = mountedDiskInfos.get(i2);
                if (diskInfo != null) {
                    if (diskInfo.getPath().equals("/storage/smb")) {
                        DiskParam diskParam2 = new DiskParam();
                        diskParam2.setPath(diskInfo.getPath());
                        diskParam2.setName("SMB Disk (I)");
                        diskParam2.setRemovable(diskInfo.isRemovable());
                        diskParam2.setShorterName("I:");
                        diskParam2.setRoot(diskInfo.getPath());
                        arrayList.add(diskParam2);
                        i++;
                    }
                    if (diskInfo.isRemovable() && "mounted".equals(diskInfo.getState())) {
                        DiskParam diskParam3 = new DiskParam();
                        diskParam3.setPath(diskInfo.getPath());
                        char c = (char) (i + 68);
                        diskParam3.setName("Removable USB Disk (" + c + ")");
                        diskParam3.setRemovable(diskInfo.isRemovable());
                        diskParam3.setShorterName(c + ":");
                        diskParam3.setRoot(diskInfo.getPath());
                        arrayList.add(diskParam3);
                        i++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
