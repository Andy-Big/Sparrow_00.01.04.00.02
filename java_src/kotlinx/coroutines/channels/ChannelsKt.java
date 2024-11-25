package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectClause1;
@Metadata(bv = {1, 0, 3}, d1 = {"kotlinx/coroutines/channels/ChannelsKt__ChannelsKt", "kotlinx/coroutines/channels/ChannelsKt__Channels_commonKt"}, k = 4, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ChannelsKt {
    public static final String DEFAULT_CLOSE_MESSAGE = "Channel was closed";

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object all(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.all(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.any(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.any(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K, V> Object associate(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.associate(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K> Object associateBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Continuation<? super Map<K, ? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.associateBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K, V> Object associateBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.associateBy(receiveChannel, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K, M extends Map<? super K, ? super E>> Object associateByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.associateByTo(receiveChannel, m, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.associateByTo(receiveChannel, m, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.associateTo(receiveChannel, m, function1, continuation);
    }

    public static final void cancelConsumed(ReceiveChannel<?> receiveChannel, Throwable th) {
        ChannelsKt__Channels_commonKt.cancelConsumed(receiveChannel, th);
    }

    public static final <E, R> R consume(BroadcastChannel<E> broadcastChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) ChannelsKt__Channels_commonKt.consume(broadcastChannel, function1);
    }

    public static final <E, R> R consume(ReceiveChannel<? extends E> receiveChannel, Function1<? super ReceiveChannel<? extends E>, ? extends R> function1) {
        return (R) ChannelsKt__Channels_commonKt.consume(receiveChannel, function1);
    }

    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(broadcastChannel, function1, continuation);
    }

    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEach(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object consumeEachIndexed(ReceiveChannel<? extends E> receiveChannel, Function1<? super IndexedValue<? extends E>, Unit> function1, Continuation<? super Unit> continuation) {
        return ChannelsKt__Channels_commonKt.consumeEachIndexed(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Function1<Throwable, Unit> consumes(ReceiveChannel<?> receiveChannel) {
        return ChannelsKt__Channels_commonKt.consumes(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Function1<Throwable, Unit> consumesAll(ReceiveChannel<?>... receiveChannelArr) {
        return ChannelsKt__Channels_commonKt.consumesAll(receiveChannelArr);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.count(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.count(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> distinct(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__Channels_commonKt.distinct(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super K>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> drop(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.drop(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> dropWhile(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object elementAt(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.elementAt(receiveChannel, i, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object elementAtOrElse(ReceiveChannel<? extends E> receiveChannel, int i, Function1<? super Integer, ? extends E> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.elementAtOrElse(receiveChannel, i, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object elementAtOrNull(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.elementAtOrNull(receiveChannel, i, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> filterIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return ChannelsKt__Channels_commonKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends Collection<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, Boolean> function2, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterIndexedTo(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends SendChannel<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, Boolean> function2, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterIndexedTo(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> filterNot(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__Channels_commonKt.filterNotNull(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends Collection<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotNullTo(receiveChannel, c, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends SendChannel<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotNullTo(receiveChannel, c, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends Collection<? super E>> Object filterNotTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotTo(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends SendChannel<? super E>> Object filterNotTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterNotTo(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends Collection<? super E>> Object filterTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterTo(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends SendChannel<? super E>> Object filterTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.filterTo(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object find(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.find(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object findLast(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.findLast(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.first(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.first(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.firstOrNull(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.firstOrNull(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> flatMap(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> Object fold(ReceiveChannel<? extends E> receiveChannel, R r, Function2<? super R, ? super E, ? extends R> function2, Continuation<? super R> continuation) {
        return ChannelsKt__Channels_commonKt.fold(receiveChannel, r, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> Object foldIndexed(ReceiveChannel<? extends E> receiveChannel, R r, Function3<? super Integer, ? super R, ? super E, ? extends R> function3, Continuation<? super R> continuation) {
        return ChannelsKt__Channels_commonKt.foldIndexed(receiveChannel, r, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K> Object groupBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Continuation<? super Map<K, ? extends List<? extends E>>> continuation) {
        return ChannelsKt__Channels_commonKt.groupBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K, V> Object groupBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        return ChannelsKt__Channels_commonKt.groupBy(receiveChannel, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K, M extends Map<? super K, List<E>>> Object groupByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.groupByTo(receiveChannel, m, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K, V, M extends Map<? super K, List<V>>> Object groupByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.groupByTo(receiveChannel, m, function1, function12, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object indexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.indexOf(receiveChannel, e, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object indexOfFirst(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.indexOfFirst(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object indexOfLast(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.indexOfLast(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.last(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.last(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object lastIndexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.lastIndexOf(receiveChannel, e, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.lastOrNull(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.lastOrNull(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.map(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt__Channels_commonKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> function3) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, C extends Collection<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedNotNullTo(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, C extends Collection<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedTo(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapIndexedTo(receiveChannel, c, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> mapNotNull(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super R>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, C extends Collection<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapNotNullTo(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, C extends SendChannel<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapNotNullTo(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, C extends Collection<? super R>> Object mapTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapTo(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, C extends SendChannel<? super R>> Object mapTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.mapTo(receiveChannel, c, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R extends Comparable<? super R>> Object maxBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends R> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.maxBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object maxWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.maxWith(receiveChannel, comparator, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R extends Comparable<? super R>> Object minBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends R> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.minBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object minWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.minWith(receiveChannel, comparator, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.none(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        return ChannelsKt__Channels_commonKt.none(receiveChannel, function1, continuation);
    }

    public static final <E> SelectClause1<E> onReceiveOrNull(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__Channels_commonKt.onReceiveOrNull(receiveChannel);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object partition(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Pair<? extends List<? extends E>, ? extends List<? extends E>>> continuation) {
        return ChannelsKt__Channels_commonKt.partition(receiveChannel, function1, continuation);
    }

    public static final <E> Object receiveOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.receiveOrNull(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <S, E extends S> Object reduce(ReceiveChannel<? extends E> receiveChannel, Function2<? super S, ? super E, ? extends S> function2, Continuation<? super S> continuation) {
        return ChannelsKt__Channels_commonKt.reduce(receiveChannel, function2, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <S, E extends S> Object reduceIndexed(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super S, ? super E, ? extends S> function3, Continuation<? super S> continuation) {
        return ChannelsKt__Channels_commonKt.reduceIndexed(receiveChannel, function3, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> requireNoNulls(ReceiveChannel<? extends E> receiveChannel) {
        return ChannelsKt__Channels_commonKt.requireNoNulls(receiveChannel);
    }

    public static final <E> void sendBlocking(SendChannel<? super E> sendChannel, E e) {
        ChannelsKt__ChannelsKt.sendBlocking(sendChannel, e);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.single(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.single(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.singleOrNull(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        return ChannelsKt__Channels_commonKt.singleOrNull(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object sumBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Integer> function1, Continuation<? super Integer> continuation) {
        return ChannelsKt__Channels_commonKt.sumBy(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object sumByDouble(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Double> function1, Continuation<? super Double> continuation) {
        return ChannelsKt__Channels_commonKt.sumByDouble(receiveChannel, function1, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> take(ReceiveChannel<? extends E> receiveChannel, int i, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.take(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> takeWhile(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return ChannelsKt__Channels_commonKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.toChannel(receiveChannel, c, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        return ChannelsKt__Channels_commonKt.toCollection(receiveChannel, c, continuation);
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.toList(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        return ChannelsKt__Channels_commonKt.toMap(receiveChannel, m, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <K, V> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt__Channels_commonKt.toMap(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object toMutableList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<E>> continuation) {
        return ChannelsKt__Channels_commonKt.toMutableList(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt__Channels_commonKt.toMutableSet(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object toSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<? extends E>> continuation) {
        return ChannelsKt__Channels_commonKt.toSet(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(ReceiveChannel<? extends E> receiveChannel, CoroutineContext coroutineContext) {
        return ChannelsKt__Channels_commonKt.withIndex(receiveChannel, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<Pair<E, R>> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2) {
        return ChannelsKt__Channels_commonKt.zip(receiveChannel, receiveChannel2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> receiveChannel, ReceiveChannel<? extends R> receiveChannel2, CoroutineContext coroutineContext, Function2<? super E, ? super R, ? extends V> function2) {
        return ChannelsKt__Channels_commonKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }
}
