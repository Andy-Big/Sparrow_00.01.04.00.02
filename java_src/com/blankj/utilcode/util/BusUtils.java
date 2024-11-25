package com.blankj.utilcode.util;

import android.util.Log;
import com.rigol.scope.utilities.UnitFormat;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
/* loaded from: classes.dex */
public final class BusUtils {
    private static final Object NULL = "nULl";
    private static final String TAG = "BusUtils";
    private final Map<String, Set<Object>> mClassName_BusesMap;
    private final Map<String, Map<String, Object>> mClassName_Tag_Arg4StickyMap;
    private final Map<String, List<String>> mClassName_TagsMap;
    private final Map<String, List<BusInfo>> mTag_BusInfoListMap;

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes.dex */
    public @interface Bus {
        int priority() default 0;

        boolean sticky() default false;

        String tag();

        ThreadMode threadMode() default ThreadMode.POSTING;
    }

    /* loaded from: classes.dex */
    public enum ThreadMode {
        MAIN,
        IO,
        CPU,
        CACHED,
        SINGLE,
        POSTING
    }

    private void init() {
    }

    private BusUtils() {
        this.mTag_BusInfoListMap = new ConcurrentHashMap();
        this.mClassName_BusesMap = new ConcurrentHashMap();
        this.mClassName_TagsMap = new ConcurrentHashMap();
        this.mClassName_Tag_Arg4StickyMap = new ConcurrentHashMap();
        init();
    }

    private void registerBus(String str, String str2, String str3, String str4, String str5, boolean z, String str6) {
        registerBus(str, str2, str3, str4, str5, z, str6, 0);
    }

    private void registerBus(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            list = new CopyOnWriteArrayList<>();
            this.mTag_BusInfoListMap.put(str, list);
        }
        list.add(new BusInfo(str, str2, str3, str4, str5, z, str6, i));
    }

    public static void register(Object obj) {
        getInstance().registerInner(obj);
    }

    public static void unregister(Object obj) {
        getInstance().unregisterInner(obj);
    }

    public static void post(String str) {
        post(str, NULL);
    }

    public static void post(String str, Object obj) {
        getInstance().postInner(str, obj);
    }

    public static void postSticky(String str) {
        postSticky(str, NULL);
    }

    public static void postSticky(String str, Object obj) {
        getInstance().postStickyInner(str, obj);
    }

    public static void removeSticky(String str) {
        getInstance().removeStickyInner(str);
    }

    public static String toString_() {
        return getInstance().toString();
    }

    public String toString() {
        return "BusUtils: " + this.mTag_BusInfoListMap;
    }

    private static BusUtils getInstance() {
        return LazyHolder.INSTANCE;
    }

    private void registerInner(Object obj) {
        if (obj == null) {
            return;
        }
        Class<?> cls = obj.getClass();
        String name = cls.getName();
        boolean z = false;
        synchronized (this.mClassName_BusesMap) {
            Set<Object> set = this.mClassName_BusesMap.get(name);
            if (set == null) {
                set = new CopyOnWriteArraySet<>();
                this.mClassName_BusesMap.put(name, set);
                z = true;
            }
            if (set.contains(obj)) {
                Log.w(TAG, "The bus of <" + obj + "> already registered.");
                return;
            }
            set.add(obj);
            if (z) {
                recordTags(cls, name);
            }
            consumeStickyIfExist(obj);
        }
    }

    private void recordTags(Class<?> cls, String str) {
        if (this.mClassName_TagsMap.get(str) == null) {
            synchronized (this.mClassName_TagsMap) {
                if (this.mClassName_TagsMap.get(str) == null) {
                    CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                    for (Map.Entry<String, List<BusInfo>> entry : this.mTag_BusInfoListMap.entrySet()) {
                        for (BusInfo busInfo : entry.getValue()) {
                            try {
                                if (Class.forName(busInfo.className).isAssignableFrom(cls)) {
                                    copyOnWriteArrayList.add(entry.getKey());
                                    busInfo.subClassNames.add(str);
                                }
                            } catch (ClassNotFoundException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    this.mClassName_TagsMap.put(str, copyOnWriteArrayList);
                }
            }
        }
    }

    private void consumeStickyIfExist(Object obj) {
        Map<String, Object> map = this.mClassName_Tag_Arg4StickyMap.get(obj.getClass().getName());
        if (map == null) {
            return;
        }
        synchronized (this.mClassName_Tag_Arg4StickyMap) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                consumeSticky(obj, entry.getKey(), entry.getValue());
            }
        }
    }

    private void consumeSticky(Object obj, String str, Object obj2) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : list) {
            if (busInfo.subClassNames.contains(obj.getClass().getName()) && busInfo.sticky) {
                synchronized (this.mClassName_Tag_Arg4StickyMap) {
                    Map<String, Object> map = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                    if (map != null && map.containsKey(str)) {
                        invokeBus(obj, obj2, busInfo, true);
                    }
                }
            }
        }
    }

    private void unregisterInner(Object obj) {
        if (obj == null) {
            return;
        }
        String name = obj.getClass().getName();
        synchronized (this.mClassName_BusesMap) {
            Set<Object> set = this.mClassName_BusesMap.get(name);
            if (set != null && set.contains(obj)) {
                set.remove(obj);
                return;
            }
            Log.e(TAG, "The bus of <" + obj + "> was not registered before.");
        }
    }

    private void postInner(String str, Object obj) {
        postInner(str, obj, false);
    }

    private void postInner(String str, Object obj, boolean z) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            if (this.mTag_BusInfoListMap.isEmpty()) {
                Log.e(TAG, "Please check whether the bus plugin is applied.");
                return;
            }
            return;
        }
        for (BusInfo busInfo : list) {
            invokeBus(obj, busInfo, z);
        }
    }

    private void invokeBus(Object obj, BusInfo busInfo, boolean z) {
        invokeBus(null, obj, busInfo, z);
    }

    private void invokeBus(Object obj, Object obj2, BusInfo busInfo, boolean z) {
        if (busInfo.method == null) {
            Method methodByBusInfo = getMethodByBusInfo(busInfo);
            if (methodByBusInfo == null) {
                return;
            }
            busInfo.method = methodByBusInfo;
        }
        invokeMethod(obj, obj2, busInfo, z);
    }

    private Method getMethodByBusInfo(BusInfo busInfo) {
        try {
            return "".equals(busInfo.paramType) ? Class.forName(busInfo.className).getDeclaredMethod(busInfo.funName, new Class[0]) : Class.forName(busInfo.className).getDeclaredMethod(busInfo.funName, getClassName(busInfo.paramType));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Class getClassName(String str) throws ClassNotFoundException {
        char c;
        switch (str.hashCode()) {
            case -1325958191:
                if (str.equals("double")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 104431:
                if (str.equals("int")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3039496:
                if (str.equals("byte")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 3052374:
                if (str.equals("char")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 3327612:
                if (str.equals("long")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 64711720:
                if (str.equals("boolean")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 97526364:
                if (str.equals("float")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 109413500:
                if (str.equals("short")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                return Boolean.TYPE;
            case 1:
                return Integer.TYPE;
            case 2:
                return Long.TYPE;
            case 3:
                return Short.TYPE;
            case 4:
                return Byte.TYPE;
            case 5:
                return Double.TYPE;
            case 6:
                return Float.TYPE;
            case 7:
                return Character.TYPE;
            default:
                return Class.forName(str);
        }
    }

    private void invokeMethod(Object obj, BusInfo busInfo, boolean z) {
        invokeMethod(null, obj, busInfo, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void invokeMethod(final Object obj, final Object obj2, final BusInfo busInfo, final boolean z) {
        char c;
        Runnable runnable = new Runnable() { // from class: com.blankj.utilcode.util.BusUtils.1
            @Override // java.lang.Runnable
            public void run() {
                BusUtils.this.realInvokeMethod(obj, obj2, busInfo, z);
            }
        };
        String str = busInfo.threadMode;
        switch (str.hashCode()) {
            case -1848936376:
                if (str.equals("SINGLE")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 2342:
                if (str.equals("IO")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 66952:
                if (str.equals("CPU")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 2358713:
                if (str.equals("MAIN")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1980249378:
                if (str.equals("CACHED")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            ThreadUtils.runOnUiThread(runnable);
        } else if (c == 1) {
            ThreadUtils.getIoPool().execute(runnable);
        } else if (c == 2) {
            ThreadUtils.getCpuPool().execute(runnable);
        } else if (c == 3) {
            ThreadUtils.getCachedPool().execute(runnable);
        } else if (c == 4) {
            ThreadUtils.getSinglePool().execute(runnable);
        } else {
            runnable.run();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realInvokeMethod(Object obj, Object obj2, BusInfo busInfo, boolean z) {
        Set<Object> hashSet = new HashSet<>();
        if (obj == null) {
            for (String str : busInfo.subClassNames) {
                Set<Object> set = this.mClassName_BusesMap.get(str);
                if (set != null && !set.isEmpty()) {
                    hashSet.addAll(set);
                }
            }
            if (hashSet.size() == 0) {
                if (z) {
                    return;
                }
                Log.e(TAG, "The " + busInfo + " was not registered before.");
                return;
            }
        } else {
            hashSet.add(obj);
        }
        invokeBuses(obj2, busInfo, hashSet);
    }

    private void invokeBuses(Object obj, BusInfo busInfo, Set<Object> set) {
        try {
            if (obj == NULL) {
                for (Object obj2 : set) {
                    busInfo.method.invoke(obj2, new Object[0]);
                }
                return;
            }
            for (Object obj3 : set) {
                busInfo.method.invoke(obj3, obj);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    private void postStickyInner(String str, Object obj) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : list) {
            if (!busInfo.sticky) {
                invokeBus(obj, busInfo, false);
            } else {
                synchronized (this.mClassName_Tag_Arg4StickyMap) {
                    Map<String, Object> map = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                    if (map == null) {
                        map = new ConcurrentHashMap<>();
                        this.mClassName_Tag_Arg4StickyMap.put(busInfo.className, map);
                    }
                    map.put(str, obj);
                }
                invokeBus(obj, busInfo, true);
            }
        }
    }

    private void removeStickyInner(String str) {
        List<BusInfo> list = this.mTag_BusInfoListMap.get(str);
        if (list == null) {
            Log.e(TAG, "The bus of tag <" + str + "> is not exists.");
            return;
        }
        for (BusInfo busInfo : list) {
            if (busInfo.sticky) {
                synchronized (this.mClassName_Tag_Arg4StickyMap) {
                    Map<String, Object> map = this.mClassName_Tag_Arg4StickyMap.get(busInfo.className);
                    if (map != null && map.containsKey(str)) {
                        map.remove(str);
                    }
                    return;
                }
            }
        }
    }

    static void registerBus4Test(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i) {
        getInstance().registerBus(str, str2, str3, str4, str5, z, str6, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BusInfo {
        String className;
        String funName;
        Method method;
        String paramName;
        String paramType;
        int priority;
        boolean sticky;
        List<String> subClassNames = new CopyOnWriteArrayList();
        String tag;
        String threadMode;

        BusInfo(String str, String str2, String str3, String str4, String str5, boolean z, String str6, int i) {
            this.tag = str;
            this.className = str2;
            this.funName = str3;
            this.paramType = str4;
            this.paramName = str5;
            this.sticky = z;
            this.threadMode = str6;
            this.priority = i;
        }

        public String toString() {
            return "BusInfo { tag : " + this.tag + ", desc: " + getDesc() + ", sticky: " + this.sticky + ", threadMode: " + this.threadMode + ", method: " + this.method + ", priority: " + this.priority + " }";
        }

        private String getDesc() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(this.className);
            sb.append(UnitFormat.PATTERN_SIGN);
            sb.append(this.funName);
            if ("".equals(this.paramType)) {
                str = "()";
            } else {
                str = "(" + this.paramType + " " + this.paramName + ")";
            }
            sb.append(str);
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LazyHolder {
        private static final BusUtils INSTANCE = new BusUtils();

        private LazyHolder() {
        }
    }
}
