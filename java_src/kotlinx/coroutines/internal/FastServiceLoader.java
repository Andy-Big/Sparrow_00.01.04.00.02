package kotlinx.coroutines.internal;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.rigol.scope.utilities.UnitFormat;
import com.sun.mail.imap.IMAPStore;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: FastServiceLoader.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000bH\u0002¢\u0006\u0002\u0010\fJ/\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e\"\u0004\b\u0000\u0010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u000fJ/\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000e\"\u0004\b\u0000\u0010\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00060\u000b2\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\b\u0011J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0016\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u000e2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J,\u0010\u0018\u001a\u0002H\u0019\"\u0004\b\u0000\u0010\u0019*\u00020\u001a2\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u0002H\u00190\u001cH\u0082\b¢\u0006\u0002\u0010\u001dR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lkotlinx/coroutines/internal/FastServiceLoader;", "", "()V", "PREFIX", "", "getProviderInstance", ExifInterface.LATITUDE_SOUTH, IMAPStore.ID_NAME, "loader", "Ljava/lang/ClassLoader;", NotificationCompat.CATEGORY_SERVICE, "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/ClassLoader;Ljava/lang/Class;)Ljava/lang/Object;", "load", "", "load$kotlinx_coroutines_core", "loadProviders", "loadProviders$kotlinx_coroutines_core", "parse", "url", "Ljava/net/URL;", "parseFile", "r", "Ljava/io/BufferedReader;", "use", "R", "Ljava/util/jar/JarFile;", "block", "Lkotlin/Function1;", "(Ljava/util/jar/JarFile;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class FastServiceLoader {
    public static final FastServiceLoader INSTANCE = new FastServiceLoader();
    private static final String PREFIX = "META-INF/services/";

    private FastServiceLoader() {
    }

    public final <S> List<S> load$kotlinx_coroutines_core(Class<S> service, ClassLoader loader) {
        Intrinsics.checkParameterIsNotNull(service, "service");
        Intrinsics.checkParameterIsNotNull(loader, "loader");
        try {
            return loadProviders$kotlinx_coroutines_core(service, loader);
        } catch (Throwable unused) {
            ServiceLoader load = ServiceLoader.load(service, loader);
            Intrinsics.checkExpressionValueIsNotNull(load, "ServiceLoader.load(service, loader)");
            return CollectionsKt.toList(load);
        }
    }

    public final <S> List<S> loadProviders$kotlinx_coroutines_core(Class<S> service, ClassLoader loader) {
        Intrinsics.checkParameterIsNotNull(service, "service");
        Intrinsics.checkParameterIsNotNull(loader, "loader");
        Enumeration<URL> urls = loader.getResources(PREFIX + service.getName());
        Intrinsics.checkExpressionValueIsNotNull(urls, "urls");
        ArrayList<URL> list = Collections.list(urls);
        Intrinsics.checkExpressionValueIsNotNull(list, "java.util.Collections.list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL it : list) {
            FastServiceLoader fastServiceLoader = INSTANCE;
            Intrinsics.checkExpressionValueIsNotNull(it, "it");
            CollectionsKt.addAll(arrayList, fastServiceLoader.parse(it));
        }
        Set set = CollectionsKt.toSet(arrayList);
        if (!(!set.isEmpty())) {
            throw new IllegalArgumentException("No providers were loaded with FastServiceLoader".toString());
        }
        Set<String> set2 = set;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(set2, 10));
        for (String str : set2) {
            arrayList2.add(INSTANCE.getProviderInstance(str, loader, service));
        }
        return arrayList2;
    }

    private final <S> S getProviderInstance(String str, ClassLoader classLoader, Class<S> cls) {
        Class<?> cls2 = Class.forName(str, false, classLoader);
        if (!cls.isAssignableFrom(cls2)) {
            throw new IllegalArgumentException(("Expected service of class " + cls + ", but found " + cls2).toString());
        }
        return cls.cast(cls2.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }

    private final List<String> parse(URL url) {
        String url2 = url.toString();
        Intrinsics.checkExpressionValueIsNotNull(url2, "url.toString()");
        if (StringsKt.startsWith$default(url2, "jar", false, 2, (Object) null)) {
            String substringBefore$default = StringsKt.substringBefore$default(StringsKt.substringAfter$default(url2, "jar:file:", (String) null, 2, (Object) null), '!', (String) null, 2, (Object) null);
            String substringAfter$default = StringsKt.substringAfter$default(url2, "!/", (String) null, 2, (Object) null);
            JarFile jarFile = new JarFile(substringBefore$default, false);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(jarFile.getInputStream(new ZipEntry(substringAfter$default)), "UTF-8"));
                Throwable th = null;
                List<String> parseFile = INSTANCE.parseFile(bufferedReader);
                CloseableKt.closeFinally(bufferedReader, th);
                jarFile.close();
                return parseFile;
            } catch (Throwable th2) {
                try {
                    throw th2;
                } catch (Throwable th3) {
                    try {
                        jarFile.close();
                        throw th3;
                    } catch (Throwable th4) {
                        ExceptionsKt.addSuppressed(th2, th4);
                        throw th2;
                    }
                }
            }
        }
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(url.openStream()));
        Throwable th5 = null;
        try {
            List<String> parseFile2 = INSTANCE.parseFile(bufferedReader2);
            CloseableKt.closeFinally(bufferedReader2, th5);
            return parseFile2;
        } catch (Throwable th6) {
            try {
                throw th6;
            } catch (Throwable th7) {
                CloseableKt.closeFinally(bufferedReader2, th6);
                throw th7;
            }
        }
    }

    private final <R> R use(JarFile jarFile, Function1<? super JarFile, ? extends R> function1) {
        try {
            R invoke = function1.invoke(jarFile);
            InlineMarker.finallyStart(1);
            jarFile.close();
            InlineMarker.finallyEnd(1);
            return invoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                try {
                    jarFile.close();
                    InlineMarker.finallyEnd(1);
                    throw th2;
                } catch (Throwable th3) {
                    ExceptionsKt.addSuppressed(th, th3);
                    throw th;
                }
            }
        }
    }

    private final List<String> parseFile(BufferedReader bufferedReader) {
        boolean z;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String substringBefore$default = StringsKt.substringBefore$default(readLine, UnitFormat.PATTERN_SIGN, (String) null, 2, (Object) null);
                if (substringBefore$default == null) {
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                }
                String obj = StringsKt.trim((CharSequence) substringBefore$default).toString();
                String str = obj;
                int i = 0;
                while (true) {
                    if (i >= str.length()) {
                        z = true;
                        break;
                    }
                    char charAt = str.charAt(i);
                    if (!(charAt == '.' || Character.isJavaIdentifierPart(charAt))) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (!z) {
                    throw new IllegalArgumentException(("Illegal service provider class name: " + obj).toString());
                }
                if (str.length() > 0) {
                    linkedHashSet.add(obj);
                }
            } else {
                return CollectionsKt.toList(linkedHashSet);
            }
        }
    }
}
