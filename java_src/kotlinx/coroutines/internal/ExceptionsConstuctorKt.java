package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Comparator;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CopyableThrowable;
/* compiled from: ExceptionsConstuctor.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\n\u001a\u0018\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\fH\u0002\u001a1\u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00072\u0014\b\u0004\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0006H\u0082\b\u001a!\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020\u00052\u0006\u0010\u0011\u001a\u0002H\u0010H\u0000¢\u0006\u0002\u0010\u0012\u001a\u001b\u0010\u0013\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\u0014\u001a\u00020\tH\u0082\u0010\u001a\u0018\u0010\u0015\u001a\u00020\t*\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0016\u001a\u00020\tH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"4\u0010\u0002\u001a(\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006j\u0002`\u00070\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0017\"\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00062\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0006¨\u0006\u0018"}, d2 = {"cacheLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "exceptionCtors", "Ljava/util/WeakHashMap;", "Ljava/lang/Class;", "", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Ctor;", "throwableFields", "", "createConstructor", "constructor", "Ljava/lang/reflect/Constructor;", "safeCtor", "block", "tryCopyException", ExifInterface.LONGITUDE_EAST, "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "fieldsCount", "accumulator", "fieldsCountOrDefault", "defaultValue", "Ctor", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ExceptionsConstuctorKt {
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);
    private static final ReentrantReadWriteLock cacheLock = new ReentrantReadWriteLock();
    private static final WeakHashMap<Class<? extends Throwable>, Function1<Throwable, Throwable>> exceptionCtors = new WeakHashMap<>();

    public static final <E extends Throwable> E tryCopyException(E exception) {
        Object m28constructorimpl;
        ReentrantReadWriteLock.ReadLock readLock;
        int readHoldCount;
        ReentrantReadWriteLock.WriteLock writeLock;
        Intrinsics.checkParameterIsNotNull(exception, "exception");
        if (exception instanceof CopyableThrowable) {
            try {
                Result.Companion companion = Result.Companion;
                m28constructorimpl = Result.m28constructorimpl(((CopyableThrowable) exception).createCopy());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
            }
            return (E) (Result.m34isFailureimpl(m28constructorimpl) ? null : m28constructorimpl);
        }
        ReentrantReadWriteLock.ReadLock readLock2 = cacheLock.readLock();
        readLock2.lock();
        try {
            Function1<Throwable, Throwable> function1 = exceptionCtors.get(exception.getClass());
            if (function1 != null) {
                return (E) function1.invoke(exception);
            }
            int i = 0;
            if (throwableFields != fieldsCountOrDefault(exception.getClass(), 0)) {
                ReentrantReadWriteLock reentrantReadWriteLock = cacheLock;
                readLock = reentrantReadWriteLock.readLock();
                readHoldCount = reentrantReadWriteLock.getWriteHoldCount() == 0 ? reentrantReadWriteLock.getReadHoldCount() : 0;
                for (int i2 = 0; i2 < readHoldCount; i2++) {
                    readLock.unlock();
                }
                writeLock = reentrantReadWriteLock.writeLock();
                writeLock.lock();
                try {
                    exceptionCtors.put(exception.getClass(), new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$4$1
                        @Override // kotlin.jvm.functions.Function1
                        public final Void invoke(Throwable it) {
                            Intrinsics.checkParameterIsNotNull(it, "it");
                            return null;
                        }
                    });
                    Unit unit = Unit.INSTANCE;
                    return null;
                } finally {
                    while (i < readHoldCount) {
                        readLock.lock();
                        i++;
                    }
                    writeLock.unlock();
                }
            }
            Function1<Throwable, Throwable> function12 = null;
            Constructor<?>[] constructors = exception.getClass().getConstructors();
            Intrinsics.checkExpressionValueIsNotNull(constructors, "exception.javaClass.constructors");
            for (Constructor constructor : ArraysKt.sortedWith(constructors, new Comparator<T>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$$inlined$sortedByDescending$1
                @Override // java.util.Comparator
                public final int compare(T t, T t2) {
                    Constructor it = (Constructor) t2;
                    Intrinsics.checkExpressionValueIsNotNull(it, "it");
                    Constructor it2 = (Constructor) t;
                    Intrinsics.checkExpressionValueIsNotNull(it2, "it");
                    return ComparisonsKt.compareValues(Integer.valueOf(it.getParameterTypes().length), Integer.valueOf(it2.getParameterTypes().length));
                }
            })) {
                Intrinsics.checkExpressionValueIsNotNull(constructor, "constructor");
                function12 = createConstructor(constructor);
                if (function12 != null) {
                    break;
                }
            }
            ReentrantReadWriteLock reentrantReadWriteLock2 = cacheLock;
            readLock = reentrantReadWriteLock2.readLock();
            readHoldCount = reentrantReadWriteLock2.getWriteHoldCount() == 0 ? reentrantReadWriteLock2.getReadHoldCount() : 0;
            for (int i3 = 0; i3 < readHoldCount; i3++) {
                readLock.unlock();
            }
            writeLock = reentrantReadWriteLock2.writeLock();
            writeLock.lock();
            try {
                exceptionCtors.put(exception.getClass(), function12 != null ? function12 : new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$tryCopyException$5$1
                    @Override // kotlin.jvm.functions.Function1
                    public final Void invoke(Throwable it) {
                        Intrinsics.checkParameterIsNotNull(it, "it");
                        return null;
                    }
                });
                Unit unit2 = Unit.INSTANCE;
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
                if (function12 != null) {
                    return (E) function12.invoke(exception);
                }
                return null;
            } finally {
                while (i < readHoldCount) {
                    readLock.lock();
                    i++;
                }
                writeLock.unlock();
            }
        } finally {
            readLock2.unlock();
        }
    }

    private static final Function1<Throwable, Throwable> createConstructor(final Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        if (length != 0) {
            if (length != 1) {
                if (length == 2 && Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) {
                    return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Throwable invoke(Throwable e) {
                            Object m28constructorimpl;
                            Object newInstance;
                            Intrinsics.checkParameterIsNotNull(e, "e");
                            try {
                                Result.Companion companion = Result.Companion;
                                newInstance = constructor.newInstance(e.getMessage(), e);
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
                            }
                            if (newInstance != null) {
                                m28constructorimpl = Result.m28constructorimpl((Throwable) newInstance);
                                if (Result.m34isFailureimpl(m28constructorimpl)) {
                                    m28constructorimpl = null;
                                }
                                return (Throwable) m28constructorimpl;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
                return null;
            }
            Class<?> cls = parameterTypes[0];
            if (!Intrinsics.areEqual(cls, Throwable.class)) {
                if (Intrinsics.areEqual(cls, String.class)) {
                    return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final Throwable invoke(Throwable e) {
                            Object m28constructorimpl;
                            Object newInstance;
                            Intrinsics.checkParameterIsNotNull(e, "e");
                            try {
                                Result.Companion companion = Result.Companion;
                                newInstance = constructor.newInstance(e.getMessage());
                            } catch (Throwable th) {
                                Result.Companion companion2 = Result.Companion;
                                m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
                            }
                            if (newInstance != null) {
                                Throwable th2 = (Throwable) newInstance;
                                th2.initCause(e);
                                m28constructorimpl = Result.m28constructorimpl(th2);
                                if (Result.m34isFailureimpl(m28constructorimpl)) {
                                    m28constructorimpl = null;
                                }
                                return (Throwable) m28constructorimpl;
                            }
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
                        }
                    };
                }
                return null;
            }
            return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Throwable invoke(Throwable e) {
                    Object m28constructorimpl;
                    Object newInstance;
                    Intrinsics.checkParameterIsNotNull(e, "e");
                    try {
                        Result.Companion companion = Result.Companion;
                        newInstance = constructor.newInstance(e);
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.Companion;
                        m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
                    }
                    if (newInstance != null) {
                        m28constructorimpl = Result.m28constructorimpl((Throwable) newInstance);
                        if (Result.m34isFailureimpl(m28constructorimpl)) {
                            m28constructorimpl = null;
                        }
                        return (Throwable) m28constructorimpl;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
                }
            };
        }
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$createConstructor$$inlined$safeCtor$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable e) {
                Object m28constructorimpl;
                Object newInstance;
                Intrinsics.checkParameterIsNotNull(e, "e");
                try {
                    Result.Companion companion = Result.Companion;
                    newInstance = constructor.newInstance(new Object[0]);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
                }
                if (newInstance != null) {
                    Throwable th2 = (Throwable) newInstance;
                    th2.initCause(e);
                    m28constructorimpl = Result.m28constructorimpl(th2);
                    if (Result.m34isFailureimpl(m28constructorimpl)) {
                        m28constructorimpl = null;
                    }
                    return (Throwable) m28constructorimpl;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlin.Throwable");
            }
        };
    }

    private static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> function1) {
        return new Function1<Throwable, Throwable>() { // from class: kotlinx.coroutines.internal.ExceptionsConstuctorKt$safeCtor$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Throwable invoke(Throwable e) {
                Object m28constructorimpl;
                Intrinsics.checkParameterIsNotNull(e, "e");
                try {
                    Result.Companion companion = Result.Companion;
                    m28constructorimpl = Result.m28constructorimpl((Throwable) Function1.this.invoke(e));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m34isFailureimpl(m28constructorimpl)) {
                    m28constructorimpl = null;
                }
                return (Throwable) m28constructorimpl;
            }
        };
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Integer m28constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            Result.Companion companion = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            m28constructorimpl = Result.m28constructorimpl(ResultKt.createFailure(th));
        }
        Integer valueOf = Integer.valueOf(i);
        if (Result.m34isFailureimpl(m28constructorimpl)) {
            m28constructorimpl = valueOf;
        }
        return ((Number) m28constructorimpl).intValue();
    }

    static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        do {
            Field[] declaredFields = cls.getDeclaredFields();
            Intrinsics.checkExpressionValueIsNotNull(declaredFields, "declaredFields");
            int i2 = 0;
            for (Field it : declaredFields) {
                Intrinsics.checkExpressionValueIsNotNull(it, "it");
                if (!Modifier.isStatic(it.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }
}
