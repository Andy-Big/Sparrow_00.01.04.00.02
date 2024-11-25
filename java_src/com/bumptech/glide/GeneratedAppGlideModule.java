package com.bumptech.glide;

import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.AppGlideModule;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class GeneratedAppGlideModule extends AppGlideModule {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Set<Class<?>> getExcludedModuleClasses();

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestManagerRetriever.RequestManagerFactory getRequestManagerFactory() {
        return null;
    }

    GeneratedAppGlideModule() {
    }
}
