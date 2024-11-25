package com.just.agentweb;

import android.content.Context;
import android.content.pm.ProviderInfo;
import androidx.core.content.FileProvider;
/* loaded from: classes.dex */
public class AgentWebFileProvider extends FileProvider {
    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
    }
}
