package kotlinx.coroutines;

import androidx.exifinterface.media.ExifInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* compiled from: Await.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\u001a=\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0\u0004\"\u00020\nH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001b\u0010\u0007\u001a\u00020\b*\b\u0012\u0004\u0012\u00020\n0\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"awaitAll", "", ExifInterface.GPS_DIRECTION_TRUE, "deferreds", "", "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", "", "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class AwaitKt {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitAll(Deferred<? extends T>[] deferredArr, Continuation<? super List<? extends T>> continuation) {
        AwaitKt$awaitAll$1 awaitKt$awaitAll$1;
        int i;
        if (continuation instanceof AwaitKt$awaitAll$1) {
            awaitKt$awaitAll$1 = (AwaitKt$awaitAll$1) continuation;
            if ((awaitKt$awaitAll$1.label & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitAll$1.label -= Integer.MIN_VALUE;
                Object obj = awaitKt$awaitAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$awaitAll$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (deferredArr.length == 0) {
                        return CollectionsKt.emptyList();
                    }
                    AwaitAll awaitAll = new AwaitAll(deferredArr);
                    awaitKt$awaitAll$1.L$0 = deferredArr;
                    awaitKt$awaitAll$1.label = 1;
                    obj = awaitAll.await(awaitKt$awaitAll$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Deferred[] deferredArr2 = (Deferred[]) awaitKt$awaitAll$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return (List) obj;
            }
        }
        awaitKt$awaitAll$1 = new AwaitKt$awaitAll$1(continuation);
        Object obj2 = awaitKt$awaitAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$awaitAll$1.label;
        if (i != 0) {
        }
        return (List) obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object awaitAll(Collection<? extends Deferred<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        AwaitKt$awaitAll$2 awaitKt$awaitAll$2;
        int i;
        if (continuation instanceof AwaitKt$awaitAll$2) {
            awaitKt$awaitAll$2 = (AwaitKt$awaitAll$2) continuation;
            if ((awaitKt$awaitAll$2.label & Integer.MIN_VALUE) != 0) {
                awaitKt$awaitAll$2.label -= Integer.MIN_VALUE;
                Object obj = awaitKt$awaitAll$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$awaitAll$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (collection.isEmpty()) {
                        return CollectionsKt.emptyList();
                    }
                    Object[] array = collection.toArray(new Deferred[0]);
                    if (array != null) {
                        AwaitAll awaitAll = new AwaitAll((Deferred[]) array);
                        awaitKt$awaitAll$2.L$0 = collection;
                        awaitKt$awaitAll$2.label = 1;
                        obj = awaitAll.await(awaitKt$awaitAll$2);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Collection collection2 = (Collection) awaitKt$awaitAll$2.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                return (List) obj;
            }
        }
        awaitKt$awaitAll$2 = new AwaitKt$awaitAll$2(continuation);
        Object obj2 = awaitKt$awaitAll$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$awaitAll$2.label;
        if (i != 0) {
        }
        return (List) obj2;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0074 -> B:19:0x0077). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinAll(Job[] jobArr, Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$1 awaitKt$joinAll$1;
        int i;
        int length;
        Object obj;
        Job[] jobArr2;
        Job[] jobArr3;
        int i2;
        AwaitKt$joinAll$1 awaitKt$joinAll$12;
        Job[] jobArr4;
        if (continuation instanceof AwaitKt$joinAll$1) {
            awaitKt$joinAll$1 = (AwaitKt$joinAll$1) continuation;
            if ((awaitKt$joinAll$1.label & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$1.label -= Integer.MIN_VALUE;
                Object obj2 = awaitKt$joinAll$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$joinAll$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    length = jobArr.length;
                    obj = coroutine_suspended;
                    jobArr2 = jobArr;
                    jobArr3 = jobArr2;
                    i2 = 0;
                    awaitKt$joinAll$12 = awaitKt$joinAll$1;
                    jobArr4 = jobArr3;
                    if (i2 < length) {
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Job job = (Job) awaitKt$joinAll$1.L$4;
                    Job job2 = (Job) awaitKt$joinAll$1.L$3;
                    i2 = awaitKt$joinAll$1.I$1;
                    int i3 = awaitKt$joinAll$1.I$0;
                    ResultKt.throwOnFailure(obj2);
                    jobArr2 = (Job[]) awaitKt$joinAll$1.L$2;
                    obj = coroutine_suspended;
                    jobArr3 = (Job[]) awaitKt$joinAll$1.L$1;
                    length = i3;
                    awaitKt$joinAll$12 = awaitKt$joinAll$1;
                    jobArr4 = (Job[]) awaitKt$joinAll$1.L$0;
                    i2++;
                    if (i2 < length) {
                        Job job3 = jobArr2[i2];
                        awaitKt$joinAll$12.L$0 = jobArr4;
                        awaitKt$joinAll$12.L$1 = jobArr3;
                        awaitKt$joinAll$12.L$2 = jobArr2;
                        awaitKt$joinAll$12.I$0 = length;
                        awaitKt$joinAll$12.I$1 = i2;
                        awaitKt$joinAll$12.L$3 = job3;
                        awaitKt$joinAll$12.L$4 = job3;
                        awaitKt$joinAll$12.label = 1;
                        if (job3.join(awaitKt$joinAll$12) == obj) {
                            return obj;
                        }
                        i2++;
                        if (i2 < length) {
                            return Unit.INSTANCE;
                        }
                    }
                }
            }
        }
        awaitKt$joinAll$1 = new AwaitKt$joinAll$1(continuation);
        Object obj22 = awaitKt$joinAll$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$joinAll$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0059  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object joinAll(Collection<? extends Job> collection, Continuation<? super Unit> continuation) {
        AwaitKt$joinAll$3 awaitKt$joinAll$3;
        int i;
        Collection<? extends Job> collection2;
        Iterator it;
        Iterable iterable;
        if (continuation instanceof AwaitKt$joinAll$3) {
            awaitKt$joinAll$3 = (AwaitKt$joinAll$3) continuation;
            if ((awaitKt$joinAll$3.label & Integer.MIN_VALUE) != 0) {
                awaitKt$joinAll$3.label -= Integer.MIN_VALUE;
                Object obj = awaitKt$joinAll$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = awaitKt$joinAll$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Collection<? extends Job> collection3 = collection;
                    Iterator it2 = collection3.iterator();
                    collection2 = collection;
                    it = it2;
                    iterable = collection3;
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Job job = (Job) awaitKt$joinAll$3.L$4;
                    Object obj2 = awaitKt$joinAll$3.L$3;
                    it = (Iterator) awaitKt$joinAll$3.L$2;
                    iterable = (Iterable) awaitKt$joinAll$3.L$1;
                    ResultKt.throwOnFailure(obj);
                    collection2 = (Collection) awaitKt$joinAll$3.L$0;
                }
                while (it.hasNext()) {
                    Object next = it.next();
                    Job job2 = (Job) next;
                    awaitKt$joinAll$3.L$0 = collection2;
                    awaitKt$joinAll$3.L$1 = iterable;
                    awaitKt$joinAll$3.L$2 = it;
                    awaitKt$joinAll$3.L$3 = next;
                    awaitKt$joinAll$3.L$4 = job2;
                    awaitKt$joinAll$3.label = 1;
                    if (job2.join(awaitKt$joinAll$3) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return Unit.INSTANCE;
            }
        }
        awaitKt$joinAll$3 = new AwaitKt$joinAll$3(continuation);
        Object obj3 = awaitKt$joinAll$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = awaitKt$joinAll$3.label;
        if (i != 0) {
        }
        while (it.hasNext()) {
        }
        return Unit.INSTANCE;
    }
}
