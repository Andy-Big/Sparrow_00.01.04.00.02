package javax.jmdns.impl.util;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
/* loaded from: classes2.dex */
public class NamedThreadFactory implements ThreadFactory {
    private final ThreadFactory _delegate = Executors.defaultThreadFactory();
    private final String _namePrefix;

    public NamedThreadFactory(String str) {
        this._namePrefix = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this._delegate.newThread(runnable);
        newThread.setName(this._namePrefix + ' ' + newThread.getName());
        return newThread;
    }
}
