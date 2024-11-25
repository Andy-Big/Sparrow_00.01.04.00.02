package com.rigol.scope;

import android.content.Context;
/* loaded from: classes.dex */
public class BaseApplicationContext {
    private static Context mContext;

    public static void setContext(Context context) {
        mContext = context;
    }

    public static Context getContext() {
        return mContext;
    }
}
