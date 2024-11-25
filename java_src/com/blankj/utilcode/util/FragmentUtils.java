package com.blankj.utilcode.util;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class FragmentUtils {
    private static final String ARGS_ID = "args_id";
    private static final String ARGS_IS_ADD_STACK = "args_is_add_stack";
    private static final String ARGS_IS_HIDE = "args_is_hide";
    private static final String ARGS_TAG = "args_tag";
    private static final int TYPE_ADD_FRAGMENT = 1;
    private static final int TYPE_HIDE_FRAGMENT = 4;
    private static final int TYPE_REMOVE_FRAGMENT = 32;
    private static final int TYPE_REMOVE_TO_FRAGMENT = 64;
    private static final int TYPE_REPLACE_FRAGMENT = 16;
    private static final int TYPE_SHOW_FRAGMENT = 2;
    private static final int TYPE_SHOW_HIDE_FRAGMENT = 8;

    /* loaded from: classes.dex */
    public interface OnBackClickListener {
        boolean onBackClick();
    }

    private FragmentUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, (String) null, false, false);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, (String) null, z, false);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, boolean z2) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, (String) null, z, z2);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, int i2, int i3) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, null, false, i2, i3, 0, 0);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, int i2, int i3) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, null, z, i2, i3, 0, 0);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, int i2, int i3, int i4, int i5) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, null, false, i2, i3, i4, i5);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, int i2, int i3, int i4, int i5) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, null, z, i2, i3, i4, i5);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, View... viewArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (viewArr == null) {
            throw new NullPointerException("Argument 'sharedElements' of type View[] (#3 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, (String) null, false, viewArr);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, View... viewArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (viewArr == null) {
            throw new NullPointerException("Argument 'sharedElements' of type View[] (#4 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, (String) null, z, viewArr);
    }

    public static void add(FragmentManager fragmentManager, List<Fragment> list, int i, int i2) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (list == null) {
            throw new NullPointerException("Argument 'adds' of type List<Fragment> (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, (Fragment[]) list.toArray(new Fragment[0]), i, (String[]) null, i2);
    }

    public static void add(FragmentManager fragmentManager, Fragment[] fragmentArr, int i, int i2) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragmentArr == null) {
            throw new NullPointerException("Argument 'adds' of type Fragment[] (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragmentArr, i, (String[]) null, i2);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, str, false, false);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, str, z, false);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z, boolean z2) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        putArgs(fragment, new Args(i, str, z, z2));
        operateNoAnim(1, fragmentManager, null, fragment);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str, int i2, int i3) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, str, false, i2, i3, 0, 0);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z, int i2, int i3) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, str, z, i2, i3, 0, 0);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str, int i2, int i3, int i4, int i5) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, str, false, i2, i3, i4, i5);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z, int i2, int i3, int i4, int i5) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        putArgs(fragment, new Args(i, str, false, z));
        addAnim(beginTransaction, i2, i3, i4, i5);
        operate(1, fragmentManager, beginTransaction, null, fragment);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str, View... viewArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (viewArr == null) {
            throw new NullPointerException("Argument 'sharedElements' of type View[] (#4 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, fragment, i, str, false, viewArr);
    }

    public static void add(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z, View... viewArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'add' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (viewArr == null) {
            throw new NullPointerException("Argument 'sharedElements' of type View[] (#5 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        putArgs(fragment, new Args(i, str, false, z));
        addSharedElement(beginTransaction, viewArr);
        operate(1, fragmentManager, beginTransaction, null, fragment);
    }

    public static void add(FragmentManager fragmentManager, List<Fragment> list, int i, String[] strArr, int i2) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (list == null) {
            throw new NullPointerException("Argument 'adds' of type List<Fragment> (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        add(fragmentManager, (Fragment[]) list.toArray(new Fragment[0]), i, strArr, i2);
    }

    public static void add(FragmentManager fragmentManager, Fragment[] fragmentArr, int i, String[] strArr, int i2) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragmentArr == null) {
            throw new NullPointerException("Argument 'adds' of type Fragment[] (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (strArr == null) {
            int length = fragmentArr.length;
            int i3 = 0;
            while (i3 < length) {
                putArgs(fragmentArr[i3], new Args(i, null, i2 != i3, false));
                i3++;
            }
        } else {
            int length2 = fragmentArr.length;
            int i4 = 0;
            while (i4 < length2) {
                putArgs(fragmentArr[i4], new Args(i, strArr[i4], i2 != i4, false));
                i4++;
            }
        }
        operateNoAnim(1, fragmentManager, null, fragmentArr);
    }

    public static void show(Fragment fragment) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'show' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        putArgs(fragment, false);
        operateNoAnim(2, fragment.getFragmentManager(), null, fragment);
    }

    public static void show(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        for (Fragment fragment : fragments) {
            putArgs(fragment, false);
        }
        operateNoAnim(2, fragmentManager, null, (Fragment[]) fragments.toArray(new Fragment[0]));
    }

    public static void hide(Fragment fragment) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'hide' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        putArgs(fragment, true);
        operateNoAnim(4, fragment.getFragmentManager(), null, fragment);
    }

    public static void hide(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        for (Fragment fragment : fragments) {
            putArgs(fragment, true);
        }
        operateNoAnim(4, fragmentManager, null, (Fragment[]) fragments.toArray(new Fragment[0]));
    }

    public static void showHide(Fragment fragment, Fragment fragment2) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'hide' of type Fragment (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        showHide(fragment, Collections.singletonList(fragment2));
    }

    public static void showHide(int i, Fragment... fragmentArr) {
        if (fragmentArr == null) {
            throw new NullPointerException("Argument 'fragments' of type Fragment[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        showHide(fragmentArr[i], fragmentArr);
    }

    public static void showHide(Fragment fragment, Fragment... fragmentArr) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragmentArr == null) {
            throw new NullPointerException("Argument 'hide' of type Fragment[] (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        showHide(fragment, Arrays.asList(fragmentArr));
    }

    public static void showHide(int i, List<Fragment> list) {
        if (list == null) {
            throw new NullPointerException("Argument 'fragments' of type List<Fragment> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        showHide(list.get(i), list);
    }

    public static void showHide(Fragment fragment, List<Fragment> list) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'show' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (list == null) {
            throw new NullPointerException("Argument 'hide' of type List<Fragment> (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        Iterator<Fragment> it = list.iterator();
        while (true) {
            boolean z = false;
            if (it.hasNext()) {
                Fragment next = it.next();
                if (next != fragment) {
                    z = true;
                }
                putArgs(next, z);
            } else {
                operateNoAnim(8, fragment.getFragmentManager(), fragment, (Fragment[]) list.toArray(new Fragment[0]));
                return;
            }
        }
    }

    public static void showHide(Fragment fragment, Fragment fragment2, int i, int i2, int i3, int i4) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'show' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'hide' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        showHide(fragment, Collections.singletonList(fragment2), i, i2, i3, i4);
    }

    public static void showHide(int i, List<Fragment> list, int i2, int i3, int i4, int i5) {
        if (list == null) {
            throw new NullPointerException("Argument 'fragments' of type List<Fragment> (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        showHide(list.get(i), list, i2, i3, i4, i5);
    }

    public static void showHide(Fragment fragment, List<Fragment> list, int i, int i2, int i3, int i4) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'show' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (list == null) {
            throw new NullPointerException("Argument 'hide' of type List<Fragment> (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        Iterator<Fragment> it = list.iterator();
        while (true) {
            boolean z = false;
            if (!it.hasNext()) {
                break;
            }
            Fragment next = it.next();
            if (next != fragment) {
                z = true;
            }
            putArgs(next, z);
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            addAnim(beginTransaction, i, i2, i3, i4);
            operate(8, fragmentManager, beginTransaction, fragment, (Fragment[]) list.toArray(new Fragment[0]));
        }
    }

    public static void replace(Fragment fragment, Fragment fragment2) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, (String) null, false);
    }

    public static void replace(Fragment fragment, Fragment fragment2, boolean z) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, (String) null, z);
    }

    public static void replace(Fragment fragment, Fragment fragment2, int i, int i2) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, (String) null, false, i, i2, 0, 0);
    }

    public static void replace(Fragment fragment, Fragment fragment2, boolean z, int i, int i2) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, (String) null, z, i, i2, 0, 0);
    }

    public static void replace(Fragment fragment, Fragment fragment2, int i, int i2, int i3, int i4) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, (String) null, false, i, i2, i3, i4);
    }

    public static void replace(Fragment fragment, Fragment fragment2, boolean z, int i, int i2, int i3, int i4) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, (String) null, z, i, i2, i3, i4);
    }

    public static void replace(Fragment fragment, Fragment fragment2, View... viewArr) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, (String) null, false, viewArr);
    }

    public static void replace(Fragment fragment, Fragment fragment2, boolean z, View... viewArr) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, (String) null, z, viewArr);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, (String) null, false);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, (String) null, z);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, int i2, int i3) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, null, false, i2, i3, 0, 0);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, int i2, int i3) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, null, z, i2, i3, 0, 0);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, int i2, int i3, int i4, int i5) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, null, false, i2, i3, i4, i5);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, int i2, int i3, int i4, int i5) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, null, z, i2, i3, i4, i5);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, View... viewArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, (String) null, false, viewArr);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, boolean z, View... viewArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, (String) null, z, viewArr);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, str, false);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, boolean z) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        replace(fragmentManager, fragment2, getArgs(fragment).id, str, z);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, int i, int i2) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, str, false, i, i2, 0, 0);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, boolean z, int i, int i2) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, str, z, i, i2, 0, 0);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, int i, int i2, int i3, int i4) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, str, false, i, i2, i3, i4);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, boolean z, int i, int i2, int i3, int i4) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        replace(fragmentManager, fragment2, getArgs(fragment).id, str, z, i, i2, i3, i4);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, View... viewArr) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragment, fragment2, str, false, viewArr);
    }

    public static void replace(Fragment fragment, Fragment fragment2, String str, boolean z, View... viewArr) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'srcFragment' of type Fragment (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment2 == null) {
            throw new NullPointerException("Argument 'destFragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        FragmentManager fragmentManager = fragment.getFragmentManager();
        if (fragmentManager == null) {
            return;
        }
        replace(fragmentManager, fragment2, getArgs(fragment).id, str, z, viewArr);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, String str) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, str, false);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        putArgs(fragment, new Args(i, str, false, z));
        operate(16, fragmentManager, beginTransaction, null, fragment);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, String str, int i2, int i3) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, str, false, i2, i3, 0, 0);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z, int i2, int i3) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 7, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, str, z, i2, i3, 0, 0);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, String str, int i2, int i3, int i4, int i5) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 8, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, str, false, i2, i3, i4, i5);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z, int i2, int i3, int i4, int i5) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 9, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        putArgs(fragment, new Args(i, str, false, z));
        addAnim(beginTransaction, i2, i3, i4, i5);
        operate(16, fragmentManager, beginTransaction, null, fragment);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, String str, View... viewArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        replace(fragmentManager, fragment, i, str, false, viewArr);
    }

    public static void replace(FragmentManager fragmentManager, Fragment fragment, int i, String str, boolean z, View... viewArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#1 out of 6, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        putArgs(fragment, new Args(i, str, false, z));
        addSharedElement(beginTransaction, viewArr);
        operate(16, fragmentManager, beginTransaction, null, fragment);
    }

    public static void pop(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        pop(fragmentManager, true);
    }

    public static void pop(FragmentManager fragmentManager, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (z) {
            fragmentManager.popBackStackImmediate();
        } else {
            fragmentManager.popBackStack();
        }
    }

    public static void popTo(FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        popTo(fragmentManager, cls, z, true);
    }

    public static void popTo(FragmentManager fragmentManager, Class<? extends Fragment> cls, boolean z, boolean z2) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 4, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (z2) {
            fragmentManager.popBackStackImmediate(cls.getName(), z ? 1 : 0);
        } else {
            fragmentManager.popBackStack(cls.getName(), z ? 1 : 0);
        }
    }

    public static void popAll(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        popAll(fragmentManager, true);
    }

    public static void popAll(FragmentManager fragmentManager, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragmentManager.getBackStackEntryCount() > 0) {
            FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(0);
            if (z) {
                fragmentManager.popBackStackImmediate(backStackEntryAt.getId(), 1);
            } else {
                fragmentManager.popBackStack(backStackEntryAt.getId(), 1);
            }
        }
    }

    public static void remove(Fragment fragment) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'remove' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        operateNoAnim(32, fragment.getFragmentManager(), null, fragment);
    }

    public static void removeTo(Fragment fragment, boolean z) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'removeTo' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        operateNoAnim(64, fragment.getFragmentManager(), z ? fragment : null, fragment);
    }

    public static void removeAll(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        operateNoAnim(32, fragmentManager, null, (Fragment[]) getFragments(fragmentManager).toArray(new Fragment[0]));
    }

    private static void putArgs(Fragment fragment, Args args) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        arguments.putInt(ARGS_ID, args.id);
        arguments.putBoolean(ARGS_IS_HIDE, args.isHide);
        arguments.putBoolean(ARGS_IS_ADD_STACK, args.isAddStack);
        arguments.putString(ARGS_TAG, args.tag);
    }

    private static void putArgs(Fragment fragment, boolean z) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = new Bundle();
            fragment.setArguments(arguments);
        }
        arguments.putBoolean(ARGS_IS_HIDE, z);
    }

    private static Args getArgs(Fragment fragment) {
        Bundle arguments = fragment.getArguments();
        if (arguments == null) {
            arguments = Bundle.EMPTY;
        }
        return new Args(arguments.getInt(ARGS_ID, fragment.getId()), arguments.getBoolean(ARGS_IS_HIDE), arguments.getBoolean(ARGS_IS_ADD_STACK));
    }

    private static void operateNoAnim(int i, FragmentManager fragmentManager, Fragment fragment, Fragment... fragmentArr) {
        if (fragmentManager == null) {
            return;
        }
        operate(i, fragmentManager, fragmentManager.beginTransaction(), fragment, fragmentArr);
    }

    private static void operate(int i, FragmentManager fragmentManager, FragmentTransaction fragmentTransaction, Fragment fragment, Fragment... fragmentArr) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#1 out of 5, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        if (fragment != null && fragment.isRemoving()) {
            Log.e("FragmentUtils", fragment.getClass().getName() + " is isRemoving");
            return;
        }
        int i2 = 0;
        if (i == 1) {
            int length = fragmentArr.length;
            while (i2 < length) {
                Fragment fragment2 = fragmentArr[i2];
                Bundle arguments = fragment2.getArguments();
                if (arguments == null) {
                    return;
                }
                String string = arguments.getString(ARGS_TAG, fragment2.getClass().getName());
                Fragment findFragmentByTag = fragmentManager.findFragmentByTag(string);
                if (findFragmentByTag != null && findFragmentByTag.isAdded()) {
                    fragmentTransaction.remove(findFragmentByTag);
                }
                fragmentTransaction.add(arguments.getInt(ARGS_ID), fragment2, string);
                if (arguments.getBoolean(ARGS_IS_HIDE)) {
                    fragmentTransaction.hide(fragment2);
                }
                if (arguments.getBoolean(ARGS_IS_ADD_STACK)) {
                    fragmentTransaction.addToBackStack(string);
                }
                i2++;
            }
        } else if (i == 2) {
            int length2 = fragmentArr.length;
            while (i2 < length2) {
                fragmentTransaction.show(fragmentArr[i2]);
                i2++;
            }
        } else if (i == 4) {
            int length3 = fragmentArr.length;
            while (i2 < length3) {
                fragmentTransaction.hide(fragmentArr[i2]);
                i2++;
            }
        } else if (i == 8) {
            fragmentTransaction.show(fragment);
            int length4 = fragmentArr.length;
            while (i2 < length4) {
                Fragment fragment3 = fragmentArr[i2];
                if (fragment3 != fragment) {
                    fragmentTransaction.hide(fragment3);
                }
                i2++;
            }
        } else if (i == 16) {
            Bundle arguments2 = fragmentArr[0].getArguments();
            if (arguments2 == null) {
                return;
            }
            String string2 = arguments2.getString(ARGS_TAG, fragmentArr[0].getClass().getName());
            fragmentTransaction.replace(arguments2.getInt(ARGS_ID), fragmentArr[0], string2);
            if (arguments2.getBoolean(ARGS_IS_ADD_STACK)) {
                fragmentTransaction.addToBackStack(string2);
            }
        } else if (i == 32) {
            int length5 = fragmentArr.length;
            while (i2 < length5) {
                Fragment fragment4 = fragmentArr[i2];
                if (fragment4 != fragment) {
                    fragmentTransaction.remove(fragment4);
                }
                i2++;
            }
        } else if (i == 64) {
            int length6 = fragmentArr.length - 1;
            while (true) {
                if (length6 < 0) {
                    break;
                }
                Fragment fragment5 = fragmentArr[length6];
                if (fragment5 != fragmentArr[0]) {
                    fragmentTransaction.remove(fragment5);
                    length6--;
                } else if (fragment != null) {
                    fragmentTransaction.remove(fragment5);
                }
            }
        }
        fragmentTransaction.commitAllowingStateLoss();
    }

    private static void addAnim(FragmentTransaction fragmentTransaction, int i, int i2, int i3, int i4) {
        fragmentTransaction.setCustomAnimations(i, i2, i3, i4);
    }

    private static void addSharedElement(FragmentTransaction fragmentTransaction, View... viewArr) {
        if (Build.VERSION.SDK_INT >= 21) {
            for (View view : viewArr) {
                fragmentTransaction.addSharedElement(view, view.getTransitionName());
            }
        }
    }

    public static Fragment getTop(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getTopIsInStack(fragmentManager, null, false);
    }

    public static Fragment getTopInStack(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getTopIsInStack(fragmentManager, null, true);
    }

    private static Fragment getTopIsInStack(FragmentManager fragmentManager, Fragment fragment, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment2 = fragments.get(size);
            if (fragment2 != null) {
                if (z) {
                    Bundle arguments = fragment2.getArguments();
                    if (arguments != null && arguments.getBoolean(ARGS_IS_ADD_STACK)) {
                        return getTopIsInStack(fragment2.getChildFragmentManager(), fragment2, true);
                    }
                } else {
                    return getTopIsInStack(fragment2.getChildFragmentManager(), fragment2, false);
                }
            }
        }
        return fragment;
    }

    public static Fragment getTopShow(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getTopShowIsInStack(fragmentManager, null, false);
    }

    public static Fragment getTopShowInStack(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getTopShowIsInStack(fragmentManager, null, true);
    }

    private static Fragment getTopShowIsInStack(FragmentManager fragmentManager, Fragment fragment, boolean z) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 3, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment2 = fragments.get(size);
            if (fragment2 != null && fragment2.isResumed() && fragment2.isVisible() && fragment2.getUserVisibleHint()) {
                if (z) {
                    Bundle arguments = fragment2.getArguments();
                    if (arguments != null && arguments.getBoolean(ARGS_IS_ADD_STACK)) {
                        return getTopShowIsInStack(fragment2.getChildFragmentManager(), fragment2, true);
                    }
                } else {
                    return getTopShowIsInStack(fragment2.getChildFragmentManager(), fragment2, false);
                }
            }
        }
        return fragment;
    }

    public static List<Fragment> getFragments(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = fragmentManager.getFragments();
        return (fragments == null || fragments.isEmpty()) ? Collections.emptyList() : fragments;
    }

    public static List<Fragment> getFragmentsInStack(FragmentManager fragmentManager) {
        Bundle arguments;
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        ArrayList arrayList = new ArrayList();
        for (Fragment fragment : fragments) {
            if (fragment != null && (arguments = fragment.getArguments()) != null && arguments.getBoolean(ARGS_IS_ADD_STACK)) {
                arrayList.add(fragment);
            }
        }
        return arrayList;
    }

    public static List<FragmentNode> getAllFragments(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getAllFragments(fragmentManager, new ArrayList());
    }

    private static List<FragmentNode> getAllFragments(FragmentManager fragmentManager, List<FragmentNode> list) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null) {
                list.add(new FragmentNode(fragment, getAllFragments(fragment.getChildFragmentManager(), new ArrayList())));
            }
        }
        return list;
    }

    public static List<FragmentNode> getAllFragmentsInStack(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return getAllFragmentsInStack(fragmentManager, new ArrayList());
    }

    private static List<FragmentNode> getAllFragmentsInStack(FragmentManager fragmentManager, List<FragmentNode> list) {
        Bundle arguments;
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        for (int size = fragments.size() - 1; size >= 0; size--) {
            Fragment fragment = fragments.get(size);
            if (fragment != null && (arguments = fragment.getArguments()) != null && arguments.getBoolean(ARGS_IS_ADD_STACK)) {
                list.add(new FragmentNode(fragment, getAllFragmentsInStack(fragment.getChildFragmentManager(), new ArrayList())));
            }
        }
        return list;
    }

    public static Fragment findFragment(FragmentManager fragmentManager, Class<? extends Fragment> cls) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        return fragmentManager.findFragmentByTag(cls.getName());
    }

    public static Fragment findFragment(FragmentManager fragmentManager, String str) {
        if (fragmentManager != null) {
            if (str == null) {
                throw new NullPointerException("Argument 'tag' of type String (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
            }
            return fragmentManager.findFragmentByTag(str);
        }
        throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static boolean dispatchBackPress(Fragment fragment) {
        if (fragment != null) {
            return fragment.isResumed() && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof OnBackClickListener) && ((OnBackClickListener) fragment).onBackClick();
        }
        throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
    }

    public static boolean dispatchBackPress(FragmentManager fragmentManager) {
        if (fragmentManager == null) {
            throw new NullPointerException("Argument 'fm' of type FragmentManager (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        List<Fragment> fragments = getFragments(fragmentManager);
        if (fragments != null && !fragments.isEmpty()) {
            for (int size = fragments.size() - 1; size >= 0; size--) {
                Fragment fragment = fragments.get(size);
                if (fragment != null && fragment.isResumed() && fragment.isVisible() && fragment.getUserVisibleHint() && (fragment instanceof OnBackClickListener) && ((OnBackClickListener) fragment).onBackClick()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void setBackgroundColor(Fragment fragment, int i) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        View view = fragment.getView();
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public static void setBackgroundResource(Fragment fragment, int i) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        View view = fragment.getView();
        if (view != null) {
            view.setBackgroundResource(i);
        }
    }

    public static void setBackground(Fragment fragment, Drawable drawable) {
        if (fragment == null) {
            throw new NullPointerException("Argument 'fragment' of type Fragment (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        }
        View view = fragment.getView();
        if (view == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static String getSimpleName(Fragment fragment) {
        return fragment == null ? "null" : fragment.getClass().getSimpleName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class Args {
        final int id;
        final boolean isAddStack;
        final boolean isHide;
        final String tag;

        Args(int i, boolean z, boolean z2) {
            this(i, null, z, z2);
        }

        Args(int i, String str, boolean z, boolean z2) {
            this.id = i;
            this.tag = str;
            this.isHide = z;
            this.isAddStack = z2;
        }
    }

    /* loaded from: classes.dex */
    public static class FragmentNode {
        final Fragment fragment;
        final List<FragmentNode> next;

        public FragmentNode(Fragment fragment, List<FragmentNode> list) {
            this.fragment = fragment;
            this.next = list;
        }

        public Fragment getFragment() {
            return this.fragment;
        }

        public List<FragmentNode> getNext() {
            return this.next;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.fragment.getClass().getSimpleName());
            sb.append("->");
            List<FragmentNode> list = this.next;
            sb.append((list == null || list.isEmpty()) ? "no child" : this.next.toString());
            return sb.toString();
        }
    }
}
