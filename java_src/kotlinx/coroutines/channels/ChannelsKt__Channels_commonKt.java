package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import com.rigol.scope.utilities.ViewUtil;
import com.sun.mail.imap.IMAPStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.selects.SelectClause1;

/* compiled from: Channels.common.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ø\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0010\u000f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010#\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\u001aJ\u0010\u0002\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t2\u001a\u0010\n\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\f0\u000b\"\u0006\u0012\u0002\b\u00030\fH\u0007¢\u0006\u0002\u0010\r\u001a5\u0010\u000e\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a!\u0010\u0013\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a5\u0010\u0013\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aY\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017\"\u0004\b\u0002\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00100\f2\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u0002H\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u001a0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aG\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00100\u0016\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00170\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aa\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017\"\u0004\b\u0002\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00170\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00180\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001a]\u0010\u001f\u001a\u0002H \"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017\"\u0018\b\u0002\u0010 *\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0017\u0012\u0006\b\u0000\u0012\u0002H\u00100!*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002H 2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00170\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010#\u001aw\u0010\u001f\u001a\u0002H \"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017\"\u0004\b\u0002\u0010\u0018\"\u0018\b\u0003\u0010 *\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0017\u0012\u0006\b\u0000\u0012\u0002H\u00180!*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002H 2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00170\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00180\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010$\u001ao\u0010%\u001a\u0002H \"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017\"\u0004\b\u0002\u0010\u0018\"\u0018\b\u0003\u0010 *\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0017\u0012\u0006\b\u0000\u0012\u0002H\u00180!*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002H 2\u001e\u0010\u0019\u001a\u001a\u0012\u0004\u0012\u0002H\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u001a0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010#\u001a\u001a\u0010&\u001a\u00020\b*\u0006\u0012\u0002\b\u00030\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0001\u001aC\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00100)2\u001d\u0010*\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f\u0012\u0004\u0012\u0002H(0\u0003¢\u0006\u0002\b+H\u0087\b¢\u0006\u0002\u0010,\u001aC\u0010'\u001a\u0002H(\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00100\f2\u001d\u0010*\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\f\u0012\u0004\u0012\u0002H(0\u0003¢\u0006\u0002\b+H\u0087\b¢\u0006\u0002\u0010-\u001a5\u0010.\u001a\u00020\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100)2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\b0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u00100\u001a5\u0010.\u001a\u00020\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\b0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a;\u00101\u001a\u00020\b\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0018\u0010/\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001002\u0012\u0004\u0012\u00020\b0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a1\u00103\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0003j\u0002`\t*\u0006\u0012\u0002\b\u00030\fH\u0007\u001a!\u00104\u001a\u000205\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a5\u00104\u001a\u000205\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a\u001e\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0007\u001aZ\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u0002092\"\u0010:\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170<\u0012\u0006\u0012\u0004\u0018\u00010=0;H\u0007ø\u0001\u0000¢\u0006\u0002\u0010>\u001a0\u0010?\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010@\u001a\u0002052\b\b\u0002\u00108\u001a\u000209H\u0007\u001aT\u0010A\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u0002092\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0<\u0012\u0006\u0012\u0004\u0018\u00010=0;H\u0007ø\u0001\u0000¢\u0006\u0002\u0010>\u001a)\u0010B\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010C\u001a\u000205H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010D\u001a=\u0010E\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010C\u001a\u0002052\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u0002H\u00100\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010G\u001a+\u0010H\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010C\u001a\u000205H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010D\u001aT\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u0002092\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0<\u0012\u0006\u0012\u0004\u0018\u00010=0;H\u0007ø\u0001\u0000¢\u0006\u0002\u0010>\u001ai\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u00020927\u0010\u0011\u001a3\b\u0001\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0<\u0012\u0006\u0012\u0004\u0018\u00010=0KH\u0007ø\u0001\u0000¢\u0006\u0002\u0010L\u001ad\u0010M\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u0010\b\u0001\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100O*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2'\u0010\u0011\u001a#\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0;H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010P\u001ab\u0010M\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u000e\b\u0001\u0010N*\b\u0012\u0004\u0012\u0002H\u00100Q*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2'\u0010\u0011\u001a#\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0;H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010R\u001aT\u0010S\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u0002092\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0<\u0012\u0006\u0012\u0004\u0018\u00010=0;H\u0007ø\u0001\u0000¢\u0006\u0002\u0010>\u001a$\u0010T\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\b\b\u0000\u0010\u0010*\u00020=*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\fH\u0007\u001aA\u0010U\u001a\u0002HN\"\b\b\u0000\u0010\u0010*\u00020=\"\u0010\b\u0001\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100O*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\f2\u0006\u0010\"\u001a\u0002HNH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010V\u001a?\u0010U\u001a\u0002HN\"\b\b\u0000\u0010\u0010*\u00020=\"\u000e\b\u0001\u0010N*\b\u0012\u0004\u0012\u0002H\u00100Q*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\f2\u0006\u0010\"\u001a\u0002HNH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010W\u001aO\u0010X\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u0010\b\u0001\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100O*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010Y\u001aM\u0010X\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u000e\b\u0001\u0010N*\b\u0012\u0004\u0012\u0002H\u00100Q*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010Z\u001aO\u0010[\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u0010\b\u0001\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100O*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010Y\u001aM\u0010[\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u000e\b\u0001\u0010N*\b\u0012\u0004\u0012\u0002H\u00100Q*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010Z\u001a7\u0010\\\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a7\u0010]\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a!\u0010^\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a5\u0010^\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a#\u0010_\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a7\u0010_\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a`\u0010`\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u0002092(\u0010\u0019\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0\f0<\u0012\u0006\u0012\u0004\u0018\u00010=0;H\u0007ø\u0001\u0000¢\u0006\u0002\u0010>\u001aX\u0010a\u001a\u0002H(\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010b\u001a\u0002H(2'\u0010c\u001a#\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(d\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0;H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010e\u001am\u0010f\u001a\u0002H(\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010b\u001a\u0002H(2<\u0010c\u001a8\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0013\u0012\u0011H(¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(d\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0KH\u0087Hø\u0001\u0000¢\u0006\u0002\u0010g\u001aM\u0010h\u001a\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100i0\u0016\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00170\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001ag\u0010h\u001a\u0014\u0012\u0004\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180i0\u0016\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017\"\u0004\b\u0002\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00170\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00180\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u001e\u001aa\u0010j\u001a\u0002H \"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017\"\u001c\b\u0002\u0010 *\u0016\u0012\u0006\b\u0000\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100k0!*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002H 2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00170\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010#\u001a{\u0010j\u001a\u0002H \"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010\u0017\"\u0004\b\u0002\u0010\u0018\"\u001c\b\u0003\u0010 *\u0016\u0012\u0006\b\u0000\u0012\u0002H\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180k0!*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002H 2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00170\u00032\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H\u00180\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010$\u001a)\u0010l\u001a\u000205\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010m\u001a\u0002H\u0010H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010n\u001a5\u0010o\u001a\u000205\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a5\u0010p\u001a\u000205\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a!\u0010q\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a5\u0010q\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a)\u0010r\u001a\u000205\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010m\u001a\u0002H\u0010H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010n\u001a#\u0010s\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a7\u0010s\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aZ\u0010t\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u0002092\"\u0010\u0019\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0<\u0012\u0006\u0012\u0004\u0018\u00010=0;H\u0007ø\u0001\u0000¢\u0006\u0002\u0010>\u001ao\u0010u\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u00020927\u0010\u0019\u001a3\b\u0001\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u0002H(0<\u0012\u0006\u0012\u0004\u0018\u00010=0KH\u0007ø\u0001\u0000¢\u0006\u0002\u0010L\u001au\u0010v\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010(*\u00020=*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u00020929\u0010\u0019\u001a5\b\u0001\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H(0<\u0012\u0006\u0012\u0004\u0018\u00010=0KH\u0007ø\u0001\u0000¢\u0006\u0002\u0010L\u001ap\u0010w\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010(*\u00020=\"\u0010\b\u0002\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H(0O*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2)\u0010\u0019\u001a%\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u0001H(0;H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010P\u001an\u0010w\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010(*\u00020=\"\u000e\b\u0002\u0010N*\b\u0012\u0004\u0012\u0002H(0Q*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2)\u0010\u0019\u001a%\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u0001H(0;H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010R\u001aj\u0010x\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(\"\u0010\b\u0002\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H(0O*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2'\u0010\u0019\u001a#\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0;H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010P\u001ah\u0010x\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(\"\u000e\b\u0002\u0010N*\b\u0012\u0004\u0012\u0002H(0Q*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2'\u0010\u0019\u001a#\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0;H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010R\u001a`\u0010y\u001a\b\u0012\u0004\u0012\u0002H(0\f\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010(*\u00020=*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u0002092$\u0010\u0019\u001a \b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H(0<\u0012\u0006\u0012\u0004\u0018\u00010=0;H\u0007ø\u0001\u0000¢\u0006\u0002\u0010>\u001a[\u0010z\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010(*\u00020=\"\u0010\b\u0002\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H(0O*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u0001H(0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010Y\u001aY\u0010z\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\b\b\u0001\u0010(*\u00020=\"\u000e\b\u0002\u0010N*\b\u0012\u0004\u0012\u0002H(0Q*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u0002H\u0010\u0012\u0006\u0012\u0004\u0018\u0001H(0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010Z\u001aU\u0010{\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(\"\u0010\b\u0002\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H(0O*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010Y\u001aS\u0010{\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(\"\u000e\b\u0002\u0010N*\b\u0012\u0004\u0012\u0002H(0Q*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HN2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010Z\u001aG\u0010|\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010\"\u000e\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H(0}*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aB\u0010~\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u001c\u0010\u007f\u001a\u0018\u0012\u0006\b\u0000\u0012\u0002H\u00100\u0080\u0001j\u000b\u0012\u0006\b\u0000\u0012\u0002H\u0010`\u0081\u0001H\u0087@ø\u0001\u0000¢\u0006\u0003\u0010\u0082\u0001\u001aH\u0010\u0083\u0001\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010\"\u000e\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H(0}*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001aC\u0010\u0084\u0001\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u001c\u0010\u007f\u001a\u0018\u0012\u0006\b\u0000\u0012\u0002H\u00100\u0080\u0001j\u000b\u0012\u0006\b\u0000\u0012\u0002H\u0010`\u0081\u0001H\u0087@ø\u0001\u0000¢\u0006\u0003\u0010\u0082\u0001\u001a\"\u0010\u0085\u0001\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a6\u0010\u0085\u0001\u001a\u00020\u000f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a&\u0010\u0086\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\u0087\u0001\"\b\b\u0000\u0010\u0010*\u00020=*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0007\u001aN\u0010\u0088\u0001\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100i\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100i0\u001a\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a(\u0010\u0089\u0001\u001a\u0004\u0018\u0001H\u0010\"\b\b\u0000\u0010\u0010*\u00020=*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a[\u0010\u008a\u0001\u001a\u0003H\u008b\u0001\"\u0005\b\u0000\u0010\u008b\u0001\"\t\b\u0001\u0010\u0010*\u0003H\u008b\u0001*\b\u0012\u0004\u0012\u0002H\u00100\f2)\u0010c\u001a%\u0012\u0014\u0012\u0012H\u008b\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(d\u0012\u0004\u0012\u0002H\u0010\u0012\u0005\u0012\u0003H\u008b\u00010;H\u0087Hø\u0001\u0000¢\u0006\u0003\u0010\u008c\u0001\u001ap\u0010\u008d\u0001\u001a\u0003H\u008b\u0001\"\u0005\b\u0000\u0010\u008b\u0001\"\t\b\u0001\u0010\u0010*\u0003H\u008b\u0001*\b\u0012\u0004\u0012\u0002H\u00100\f2>\u0010c\u001a:\u0012\u0013\u0012\u001105¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(C\u0012\u0014\u0012\u0012H\u008b\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(d\u0012\u0004\u0012\u0002H\u0010\u0012\u0005\u0012\u0003H\u008b\u00010KH\u0087Hø\u0001\u0000¢\u0006\u0003\u0010\u008e\u0001\u001a%\u0010\u008f\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\b\b\u0000\u0010\u0010*\u00020=*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00100\fH\u0007\u001a\"\u0010\u0090\u0001\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a6\u0010\u0090\u0001\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a$\u0010\u0091\u0001\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a8\u0010\u0091\u0001\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u00020\u000f0\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a6\u0010\u0092\u0001\u001a\u000205\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002050\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a8\u0010\u0093\u0001\u001a\u00030\u0094\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0013\u0010:\u001a\u000f\u0012\u0004\u0012\u0002H\u0010\u0012\u0005\u0012\u00030\u0094\u00010\u0003H\u0087Hø\u0001\u0000¢\u0006\u0002\u0010\u0012\u001a1\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010@\u001a\u0002052\b\b\u0002\u00108\u001a\u000209H\u0007\u001aU\u0010\u0096\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00100\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u0002092\"\u0010\u0011\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0<\u0012\u0006\u0012\u0004\u0018\u00010=0;H\u0007ø\u0001\u0000¢\u0006\u0002\u0010>\u001a:\u0010\u0097\u0001\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u000e\b\u0001\u0010N*\b\u0012\u0004\u0012\u0002H\u00100Q*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HNH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010W\u001a<\u0010\u0098\u0001\u001a\u0002HN\"\u0004\b\u0000\u0010\u0010\"\u0010\b\u0001\u0010N*\n\u0012\u0006\b\u0000\u0012\u0002H\u00100O*\b\u0012\u0004\u0012\u0002H\u00100\f2\u0006\u0010\"\u001a\u0002HNH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010V\u001a(\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00100i\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a@\u0010\u009a\u0001\u001a\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u0016\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u001a0\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001aW\u0010\u009a\u0001\u001a\u0002H \"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018\"\u0018\b\u0002\u0010 *\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0017\u0012\u0006\b\u0000\u0012\u0002H\u00180!*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00180\u001a0\f2\u0006\u0010\"\u001a\u0002H H\u0087@ø\u0001\u0000¢\u0006\u0003\u0010\u009b\u0001\u001a(\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00100k\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a)\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u0002H\u00100\u009e\u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a)\u0010\u009f\u0001\u001a\t\u0012\u0004\u0012\u0002H\u00100 \u0001\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\fH\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a/\u0010¡\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u0010020\f\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\f2\b\b\u0002\u00108\u001a\u000209H\u0007\u001aA\u0010¢\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0010\u0012\u0004\u0012\u0002H(0\u001a0\f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(*\b\u0012\u0004\u0012\u0002H\u00100\f2\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u0002H(0\fH\u0087\u0004\u001a~\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u0002H\u00180\f\"\u0004\b\u0000\u0010\u0010\"\u0004\b\u0001\u0010(\"\u0004\b\u0002\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u00100\f2\r\u0010£\u0001\u001a\b\u0012\u0004\u0012\u0002H(0\f2\b\b\u0002\u00108\u001a\u00020928\u0010\u0019\u001a4\u0012\u0014\u0012\u0012H\u0010¢\u0006\r\b\u0005\u0012\t\b\u0006\u0012\u0005\b\b(¤\u0001\u0012\u0014\u0012\u0012H(¢\u0006\r\b\u0005\u0012\t\b\u0006\u0012\u0005\b\b(¥\u0001\u0012\u0004\u0012\u0002H\u00180;H\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006¦\u0001"}, d2 = {"DEFAULT_CLOSE_MESSAGE", "", "consumesAll", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "cause", "", "Lkotlinx/coroutines/CompletionHandler;", "channels", "", "Lkotlinx/coroutines/channels/ReceiveChannel;", "([Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlin/jvm/functions/Function1;", "all", "", ExifInterface.LONGITUDE_EAST, "predicate", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "any", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associate", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "transform", "Lkotlin/Pair;", "associateBy", "keySelector", "valueTransform", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateByTo", "M", "", "destination", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateTo", "cancelConsumed", "consume", "R", "Lkotlinx/coroutines/channels/BroadcastChannel;", "block", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "consumeEach", "action", "(Lkotlinx/coroutines/channels/BroadcastChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "consumeEachIndexed", "Lkotlin/collections/IndexedValue;", "consumes", "count", "", "distinct", "distinctBy", "context", "Lkotlin/coroutines/CoroutineContext;", "selector", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/channels/ReceiveChannel;", "drop", "n", "dropWhile", "elementAt", "index", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrElse", "defaultValue", "(Lkotlinx/coroutines/channels/ReceiveChannel;ILkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "elementAtOrNull", "filter", "filterIndexed", "Lkotlin/Function3;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/channels/ReceiveChannel;", "filterIndexedTo", "C", "", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/SendChannel;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterNot", "filterNotNull", "filterNotNullTo", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterNotTo", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlinx/coroutines/channels/SendChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "filterTo", "find", "findLast", "first", "firstOrNull", "flatMap", "fold", "initial", "operation", "acc", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foldIndexed", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "groupBy", "", "groupByTo", "", "indexOf", "element", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "indexOfFirst", "indexOfLast", "last", "lastIndexOf", "lastOrNull", "map", "mapIndexed", "mapIndexedNotNull", "mapIndexedNotNullTo", "mapIndexedTo", "mapNotNull", "mapNotNullTo", "mapTo", "maxBy", "", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Comparator;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "minBy", "minWith", "none", "onReceiveOrNull", "Lkotlinx/coroutines/selects/SelectClause1;", "partition", "receiveOrNull", "reduce", ExifInterface.LATITUDE_SOUTH, "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reduceIndexed", "(Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requireNoNulls", "single", "singleOrNull", "sumBy", "sumByDouble", "", "take", "takeWhile", "toChannel", "toCollection", "toList", "toMap", "(Lkotlinx/coroutines/channels/ReceiveChannel;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toMutableList", "toMutableSet", "", "toSet", "", "withIndex", "zip", "other", ViewUtil.KEY_A, ViewUtil.KEY_B, "kotlinx-coroutines-core"}, k = 5, mv = {1, 1, 15}, xs = "kotlinx/coroutines/channels/ChannelsKt")
/* loaded from: classes2.dex */
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    public static final <E, R> R consume(BroadcastChannel<E> consume, Function1<? super ReceiveChannel<? extends E>, ? extends R> block) {
        Intrinsics.checkParameterIsNotNull(consume, "$this$consume");
        Intrinsics.checkParameterIsNotNull(block, "block");
        ReceiveChannel<E> openSubscription = consume.openSubscription();
        try {
            return block.invoke(openSubscription);
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: kotlin.coroutines.Continuation<? super E> */
    /* JADX WARN: Multi-variable type inference failed */
    public static final <E> Object receiveOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        if (receiveChannel != null) {
            return receiveChannel.receiveOrNull(continuation);
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E?>");
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: kotlinx.coroutines.selects.SelectClause1<? extends E>, kotlinx.coroutines.selects.SelectClause1<E> */
    public static final <E> SelectClause1<E> onReceiveOrNull(ReceiveChannel<? extends E> onReceiveOrNull) {
        Intrinsics.checkParameterIsNotNull(onReceiveOrNull, "$this$onReceiveOrNull");
        return (SelectClause1<? extends E>) onReceiveOrNull.getOnReceiveOrNull();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:74:0x00a4 */
    /* JADX DEBUG: Type inference failed for r12v9. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0079 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0087 A[Catch: all -> 0x009e, TryCatch #2 {all -> 0x009e, blocks: (B:64:0x007f, B:66:0x0087, B:67:0x0092), top: B:80:0x007f }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0092 A[Catch: all -> 0x009e, TRY_LEAVE, TryCatch #2 {all -> 0x009e, blocks: (B:64:0x007f, B:66:0x0087, B:67:0x0092), top: B:80:0x007f }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x007a -> B:80:0x007f). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(BroadcastChannel<E> broadcastChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$1;
        ?? r2;
        ReceiveChannel<E> openSubscription;
        Object obj;
        ReceiveChannel<E> receiveChannel;
        ChannelsKt__Channels_commonKt$consumeEach$1 channelsKt__Channels_commonKt$consumeEach$12;
        Function1<? super E, Unit> function12;
        BroadcastChannel<E> broadcastChannel2;
        ChannelIterator<E> it;
        BroadcastChannel<E> broadcastChannel3;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$1) {
                channelsKt__Channels_commonKt$consumeEach$1 = (ChannelsKt__Channels_commonKt$consumeEach$1) continuation;
                if ((channelsKt__Channels_commonKt$consumeEach$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$consumeEach$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$consumeEach$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = channelsKt__Channels_commonKt$consumeEach$1.label;
                    if (r2 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        openSubscription = broadcastChannel.openSubscription();
                        obj = coroutine_suspended;
                        receiveChannel = openSubscription;
                        channelsKt__Channels_commonKt$consumeEach$12 = channelsKt__Channels_commonKt$consumeEach$1;
                        function12 = function1;
                        broadcastChannel2 = broadcastChannel;
                        it = openSubscription.iterator();
                        broadcastChannel3 = broadcastChannel2;
                        channelsKt__Channels_commonKt$consumeEach$12.L$0 = broadcastChannel2;
                        channelsKt__Channels_commonKt$consumeEach$12.L$1 = function12;
                        channelsKt__Channels_commonKt$consumeEach$12.L$2 = broadcastChannel3;
                        channelsKt__Channels_commonKt$consumeEach$12.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$consumeEach$12.L$4 = openSubscription;
                        channelsKt__Channels_commonKt$consumeEach$12.L$5 = it;
                        channelsKt__Channels_commonKt$consumeEach$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$12);
                        if (hasNext != obj) {
                        }
                    } else if (r2 == 1) {
                        ChannelIterator<E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$1.L$5;
                        ReceiveChannel<E> receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$4;
                        ReceiveChannel<E> receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$1.L$3;
                        BroadcastChannel<E> broadcastChannel4 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$1.L$2;
                        Function1<? super E, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEach$1.L$1;
                        BroadcastChannel<E> broadcastChannel5 = (BroadcastChannel) channelsKt__Channels_commonKt$consumeEach$1.L$0;
                        ResultKt.throwOnFailure(obj2);
                        openSubscription = receiveChannel2;
                        broadcastChannel2 = broadcastChannel5;
                        ReceiveChannel<E> receiveChannel4 = receiveChannel3;
                        channelsKt__Channels_commonKt$consumeEach$12 = channelsKt__Channels_commonKt$consumeEach$1;
                        function12 = function13;
                        Object obj3 = coroutine_suspended;
                        ChannelIterator<E> channelIterator2 = channelIterator;
                        try {
                            if (!((Boolean) obj2).booleanValue()) {
                                function12.invoke((Object) channelIterator2.next());
                                broadcastChannel3 = broadcastChannel4;
                                obj = obj3;
                                receiveChannel = receiveChannel4;
                                it = channelIterator2;
                                try {
                                    channelsKt__Channels_commonKt$consumeEach$12.L$0 = broadcastChannel2;
                                    channelsKt__Channels_commonKt$consumeEach$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$consumeEach$12.L$2 = broadcastChannel3;
                                    channelsKt__Channels_commonKt$consumeEach$12.L$3 = receiveChannel;
                                    channelsKt__Channels_commonKt$consumeEach$12.L$4 = openSubscription;
                                    channelsKt__Channels_commonKt$consumeEach$12.L$5 = it;
                                    channelsKt__Channels_commonKt$consumeEach$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    broadcastChannel4 = broadcastChannel3;
                                    obj2 = hasNext;
                                    receiveChannel4 = receiveChannel;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) receiveChannel4, (CancellationException) null, 1, (Object) null);
                                        InlineMarker.finallyEnd(1);
                                        return unit;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    r2 = receiveChannel;
                                    InlineMarker.finallyStart(1);
                                    ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) r2, (CancellationException) null, 1, (Object) null);
                                    InlineMarker.finallyEnd(1);
                                    throw th;
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            r2 = receiveChannel4;
                            InlineMarker.finallyStart(1);
                            ReceiveChannel.DefaultImpls.cancel$default((ReceiveChannel) r2, (CancellationException) null, 1, (Object) null);
                            InlineMarker.finallyEnd(1);
                            throw th;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            if (r2 != 0) {
            }
        } catch (Throwable th3) {
            th = th3;
        }
        channelsKt__Channels_commonKt$consumeEach$1 = new ChannelsKt__Channels_commonKt$consumeEach$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$consumeEach$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = channelsKt__Channels_commonKt$consumeEach$1.label;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Function1<Throwable, Unit> consumes(final ReceiveChannel<?> consumes) {
        Intrinsics.checkParameterIsNotNull(consumes, "$this$consumes");
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumes$1
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                ChannelsKt.cancelConsumed(ReceiveChannel.this, th);
            }
        };
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v7, resolved type: java.util.concurrent.CancellationException */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void cancelConsumed(ReceiveChannel<?> cancelConsumed, Throwable th) {
        Intrinsics.checkParameterIsNotNull(cancelConsumed, "$this$cancelConsumed");
        if (th != null) {
            r0 = th instanceof CancellationException ? th : null;
            if (r0 == null) {
                r0 = ExceptionsKt.CancellationException("Channel was consumed, consumer had failed", th);
            }
        }
        cancelConsumed.cancel(r0);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final Function1<Throwable, Unit> consumesAll(final ReceiveChannel<?>... channels) {
        Intrinsics.checkParameterIsNotNull(channels, "channels");
        return new Function1<Throwable, Unit>() { // from class: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$consumesAll$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                Throwable th2 = null;
                for (ReceiveChannel receiveChannel : channels) {
                    try {
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                    } catch (Throwable th3) {
                        if (th2 == null) {
                            th2 = th3;
                        } else {
                            kotlin.ExceptionsKt.addSuppressed(th2, th3);
                        }
                    }
                }
                if (th2 != null) {
                    throw th2;
                }
            }
        };
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final <E, R> R consume(ReceiveChannel<? extends E> consume, Function1<? super ReceiveChannel<? extends E>, ? extends R> block) {
        Intrinsics.checkParameterIsNotNull(consume, "$this$consume");
        Intrinsics.checkParameterIsNotNull(block, "block");
        Throwable th = null;
        try {
            R invoke = block.invoke(consume);
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(consume, th);
            InlineMarker.finallyEnd(1);
            return invoke;
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x007c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008a A[Catch: all -> 0x004a, TryCatch #3 {all -> 0x004a, blocks: (B:59:0x003e, B:72:0x0082, B:74:0x008a, B:75:0x0095), top: B:92:0x003e }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0095 A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #3 {all -> 0x004a, blocks: (B:59:0x003e, B:72:0x0082, B:74:0x008a, B:75:0x0095), top: B:92:0x003e }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x007d -> B:72:0x0082). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEach(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        Object obj;
        Function1<? super E, Unit> function12;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$32;
        ReceiveChannel<? extends E> receiveChannel4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEach$3) {
            channelsKt__Channels_commonKt$consumeEach$3 = (ChannelsKt__Channels_commonKt$consumeEach$3) continuation;
            if ((channelsKt__Channels_commonKt$consumeEach$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEach$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$consumeEach$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$consumeEach$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        th2 = null;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        function12 = function1;
                        receiveChannel3 = receiveChannel2;
                        it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$3;
                        receiveChannel4 = receiveChannel3;
                        channelsKt__Channels_commonKt$consumeEach$32.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$consumeEach$32.L$1 = function12;
                        channelsKt__Channels_commonKt$consumeEach$32.L$2 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeEach$32.L$3 = th2;
                        channelsKt__Channels_commonKt$consumeEach$32.L$4 = receiveChannel4;
                        channelsKt__Channels_commonKt$consumeEach$32.L$5 = it;
                        channelsKt__Channels_commonKt$consumeEach$32.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$32);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$consumeEach$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$4;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$consumeEach$3.L$3;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$2;
                    Function1<? super E, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEach$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEach$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelsKt__Channels_commonKt$consumeEach$3 channelsKt__Channels_commonKt$consumeEach$33 = channelsKt__Channels_commonKt$consumeEach$3;
                        receiveChannel4 = receiveChannel5;
                        receiveChannel3 = receiveChannel7;
                        Throwable th5 = th4;
                        channelsKt__Channels_commonKt$consumeEach$32 = channelsKt__Channels_commonKt$consumeEach$33;
                        Object obj3 = coroutine_suspended;
                        function12 = function13;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (!((Boolean) obj2).booleanValue()) {
                            function12.invoke((Object) channelIterator2.next());
                            receiveChannel2 = receiveChannel6;
                            obj = obj3;
                            th2 = th5;
                            it = channelIterator2;
                            try {
                                channelsKt__Channels_commonKt$consumeEach$32.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$consumeEach$32.L$1 = function12;
                                channelsKt__Channels_commonKt$consumeEach$32.L$2 = receiveChannel2;
                                channelsKt__Channels_commonKt$consumeEach$32.L$3 = th2;
                                channelsKt__Channels_commonKt$consumeEach$32.L$4 = receiveChannel4;
                                channelsKt__Channels_commonKt$consumeEach$32.L$5 = it;
                                channelsKt__Channels_commonKt$consumeEach$32.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEach$32);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Object obj4 = obj;
                                receiveChannel6 = receiveChannel2;
                                obj2 = hasNext;
                                th5 = th2;
                                obj3 = obj4;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel6, th5);
                                    InlineMarker.finallyEnd(1);
                                    return unit;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                try {
                                    throw th;
                                } catch (Throwable th7) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    throw th7;
                                }
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        receiveChannel2 = receiveChannel6;
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$consumeEach$3 = new ChannelsKt__Channels_commonKt$consumeEach$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$consumeEach$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeEach$3.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a8 A[Catch: all -> 0x00ca, TryCatch #2 {all -> 0x00ca, blocks: (B:73:0x00a0, B:75:0x00a8, B:69:0x0084, B:76:0x00bc), top: B:92:0x00a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00bc A[Catch: all -> 0x00ca, TRY_LEAVE, TryCatch #2 {all -> 0x00ca, blocks: (B:73:0x00a0, B:75:0x00a8, B:69:0x0084, B:76:0x00bc), top: B:92:0x00a0 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x009d -> B:92:0x00a0). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object consumeEachIndexed(ReceiveChannel<? extends E> receiveChannel, Function1<? super IndexedValue<? extends E>, Unit> function1, Continuation<? super Unit> continuation) {
        ChannelsKt__Channels_commonKt$consumeEachIndexed$1 channelsKt__Channels_commonKt$consumeEachIndexed$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Ref.IntRef intRef;
        ChannelsKt__Channels_commonKt$consumeEachIndexed$1 channelsKt__Channels_commonKt$consumeEachIndexed$12;
        Object obj;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Function1<? super IndexedValue<? extends E>, Unit> function12;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$consumeEachIndexed$1) {
            channelsKt__Channels_commonKt$consumeEachIndexed$1 = (ChannelsKt__Channels_commonKt$consumeEachIndexed$1) continuation;
            if ((channelsKt__Channels_commonKt$consumeEachIndexed$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$consumeEachIndexed$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$consumeEachIndexed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$consumeEachIndexed$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12 = channelsKt__Channels_commonKt$consumeEachIndexed$1;
                        obj = coroutine_suspended;
                        th = null;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel2 = receiveChannel4;
                        receiveChannel5 = receiveChannel2;
                        function12 = function1;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.L$1 = function12;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.L$2 = intRef;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.L$3 = receiveChannel4;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.L$5 = th;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.L$6 = receiveChannel5;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.L$7 = it;
                        channelsKt__Channels_commonKt$consumeEachIndexed$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEachIndexed$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$3;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$2;
                    Function1<? super IndexedValue<? extends E>, Unit> function13 = (Function1) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$consumeEachIndexed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$consumeEachIndexed$12 = channelsKt__Channels_commonKt$consumeEachIndexed$1;
                        receiveChannel4 = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        receiveChannel5 = receiveChannel6;
                        function12 = function13;
                        intRef = intRef3;
                        th = th4;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel7;
                        try {
                            if (!((Boolean) obj2).booleanValue()) {
                                E next = channelIterator2.next();
                                int i2 = intRef.element;
                                intRef.element = i2 + 1;
                                function12.invoke(new IndexedValue(i2, next));
                                receiveChannel3 = receiveChannel9;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$1 = function12;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$2 = intRef;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$3 = receiveChannel4;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$5 = th;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$6 = receiveChannel5;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.L$7 = it;
                                channelsKt__Channels_commonKt$consumeEachIndexed$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$consumeEachIndexed$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel9 = receiveChannel3;
                                obj2 = hasNext;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    return Unit.INSTANCE;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            try {
                                throw th2;
                            } catch (Throwable th6) {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                InlineMarker.finallyEnd(1);
                                throw th6;
                            }
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$consumeEachIndexed$1 = new ChannelsKt__Channels_commonKt$consumeEachIndexed$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$consumeEachIndexed$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$consumeEachIndexed$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a2 A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #1 {all -> 0x00d6, blocks: (B:82:0x009a, B:84:0x00a2, B:78:0x007b, B:90:0x00b3, B:91:0x00d5), top: B:105:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00b3 A[Catch: all -> 0x00d6, TRY_ENTER, TryCatch #1 {all -> 0x00d6, blocks: (B:82:0x009a, B:84:0x00a2, B:78:0x007b, B:90:0x00b3, B:91:0x00d5), top: B:105:0x009a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x0094 -> B:105:0x009a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object elementAt(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$elementAt$1 channelsKt__Channels_commonKt$elementAt$1;
        int i2;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ChannelsKt__Channels_commonKt$elementAt$1 channelsKt__Channels_commonKt$elementAt$12;
        Object obj;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        int i3;
        int i4;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        Object hasNext;
        ChannelIterator<? extends E> channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$elementAt$1) {
            channelsKt__Channels_commonKt$elementAt$1 = (ChannelsKt__Channels_commonKt$elementAt$1) continuation;
            if ((channelsKt__Channels_commonKt$elementAt$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$elementAt$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$elementAt$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelsKt__Channels_commonKt$elementAt$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th3 = null;
                    try {
                        if (i < 0) {
                            Boxing.boxInt(i).intValue();
                            throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i + '.');
                        }
                        th = th3;
                        channelsKt__Channels_commonKt$elementAt$12 = channelsKt__Channels_commonKt$elementAt$1;
                        obj = coroutine_suspended;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel2 = receiveChannel3;
                        receiveChannel4 = receiveChannel2;
                        i3 = 0;
                        i4 = i;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$elementAt$12.L$0 = receiveChannel5;
                        channelsKt__Channels_commonKt$elementAt$12.I$0 = i4;
                        channelsKt__Channels_commonKt$elementAt$12.L$1 = receiveChannel3;
                        channelsKt__Channels_commonKt$elementAt$12.L$2 = receiveChannel2;
                        channelsKt__Channels_commonKt$elementAt$12.L$3 = th;
                        channelsKt__Channels_commonKt$elementAt$12.L$4 = receiveChannel4;
                        channelsKt__Channels_commonKt$elementAt$12.L$5 = it;
                        channelsKt__Channels_commonKt$elementAt$12.I$1 = i3;
                        channelsKt__Channels_commonKt$elementAt$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$elementAt$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    int i5 = channelsKt__Channels_commonKt$elementAt$1.I$1;
                    ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$elementAt$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$4;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$elementAt$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$2;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$1;
                    int i6 = channelsKt__Channels_commonKt$elementAt$1.I$0;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAt$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$elementAt$12 = channelsKt__Channels_commonKt$elementAt$1;
                        receiveChannel2 = receiveChannel7;
                        obj = coroutine_suspended;
                        receiveChannel4 = receiveChannel6;
                        channelIterator = channelIterator2;
                        i4 = i6;
                        th = th5;
                    } catch (Throwable th6) {
                        th2 = th6;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th2;
                        } finally {
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        }
                    }
                    try {
                        if (!((Boolean) obj2).booleanValue()) {
                            E next = channelIterator.next();
                            int i7 = i5 + 1;
                            if (i4 == i5) {
                                return next;
                            }
                            receiveChannel3 = receiveChannel8;
                            receiveChannel5 = receiveChannel9;
                            it = channelIterator;
                            i3 = i7;
                            channelsKt__Channels_commonKt$elementAt$12.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$elementAt$12.I$0 = i4;
                            channelsKt__Channels_commonKt$elementAt$12.L$1 = receiveChannel3;
                            channelsKt__Channels_commonKt$elementAt$12.L$2 = receiveChannel2;
                            channelsKt__Channels_commonKt$elementAt$12.L$3 = th;
                            channelsKt__Channels_commonKt$elementAt$12.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$elementAt$12.L$5 = it;
                            channelsKt__Channels_commonKt$elementAt$12.I$1 = i3;
                            channelsKt__Channels_commonKt$elementAt$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$elementAt$12);
                            if (hasNext != obj) {
                                return obj;
                            }
                            receiveChannel9 = receiveChannel5;
                            i5 = i3;
                            channelIterator = it;
                            receiveChannel8 = receiveChannel3;
                            obj2 = hasNext;
                            if (!((Boolean) obj2).booleanValue()) {
                                Boxing.boxInt(i4).intValue();
                                throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + i4 + '.');
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        th2 = th;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$elementAt$1 = new ChannelsKt__Channels_commonKt$elementAt$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$elementAt$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__Channels_commonKt$elementAt$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2272=5] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x009a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00aa A[Catch: all -> 0x00d6, TRY_LEAVE, TryCatch #0 {all -> 0x00d6, blocks: (B:86:0x00a2, B:88:0x00aa, B:82:0x0082, B:94:0x00c3), top: B:105:0x00a2 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c3 A[Catch: all -> 0x00d6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00d6, blocks: (B:86:0x00a2, B:88:0x00aa, B:82:0x0082, B:94:0x00c3), top: B:105:0x00a2 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:85:0x009b -> B:105:0x00a2). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object elementAtOrElse(ReceiveChannel<? extends E> receiveChannel, int i, Function1<? super Integer, ? extends E> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$elementAtOrElse$1 channelsKt__Channels_commonKt$elementAtOrElse$1;
        int i2;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        int i3;
        Throwable th2;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        Function1<? super Integer, ? extends E> function12;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$elementAtOrElse$1 channelsKt__Channels_commonKt$elementAtOrElse$12;
        int i4;
        ReceiveChannel<? extends E> receiveChannel4;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$elementAtOrElse$1) {
                channelsKt__Channels_commonKt$elementAtOrElse$1 = (ChannelsKt__Channels_commonKt$elementAtOrElse$1) continuation;
                if ((channelsKt__Channels_commonKt$elementAtOrElse$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$elementAtOrElse$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$elementAtOrElse$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i2 = channelsKt__Channels_commonKt$elementAtOrElse$1.label;
                    if (i2 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th3 = null;
                        try {
                            if (i < 0) {
                                E invoke = function1.invoke(Boxing.boxInt(i));
                                InlineMarker.finallyStart(4);
                                ChannelsKt.cancelConsumed(receiveChannel, th3);
                                InlineMarker.finallyEnd(4);
                                return invoke;
                            }
                            i3 = 0;
                            th2 = th3;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            function12 = function1;
                            receiveChannel2 = receiveChannel3;
                            it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$elementAtOrElse$12 = channelsKt__Channels_commonKt$elementAtOrElse$1;
                            i4 = i;
                            receiveChannel4 = receiveChannel2;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.L$0 = receiveChannel4;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.I$0 = i4;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.L$1 = function12;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.L$2 = receiveChannel2;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.L$3 = th2;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.L$4 = receiveChannel3;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.I$1 = i3;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.L$5 = it;
                            channelsKt__Channels_commonKt$elementAtOrElse$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$elementAtOrElse$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th4) {
                            receiveChannel2 = receiveChannel;
                            th = th4;
                        }
                    } else if (i2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$elementAtOrElse$1.L$5;
                        int i5 = channelsKt__Channels_commonKt$elementAtOrElse$1.I$1;
                        ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrElse$1.L$4;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$elementAtOrElse$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrElse$1.L$2;
                        Function1<? super Integer, ? extends E> function13 = (Function1) channelsKt__Channels_commonKt$elementAtOrElse$1.L$1;
                        int i6 = channelsKt__Channels_commonKt$elementAtOrElse$1.I$0;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrElse$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            ChannelsKt__Channels_commonKt$elementAtOrElse$1 channelsKt__Channels_commonKt$elementAtOrElse$13 = channelsKt__Channels_commonKt$elementAtOrElse$1;
                            ReceiveChannel<? extends E> receiveChannel8 = receiveChannel5;
                            receiveChannel2 = receiveChannel6;
                            channelsKt__Channels_commonKt$elementAtOrElse$12 = channelsKt__Channels_commonKt$elementAtOrElse$13;
                            obj = coroutine_suspended;
                            function12 = function13;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    E next = channelIterator2.next();
                                    int i7 = i5 + 1;
                                    if (i6 == i5) {
                                        InlineMarker.finallyStart(3);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(3);
                                        return next;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    i4 = i6;
                                    receiveChannel4 = receiveChannel7;
                                    th2 = th5;
                                    i3 = i7;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.L$0 = receiveChannel4;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.I$0 = i4;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.L$2 = receiveChannel2;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.L$3 = th2;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.L$4 = receiveChannel3;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.I$1 = i3;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.L$5 = it;
                                    channelsKt__Channels_commonKt$elementAtOrElse$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$elementAtOrElse$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    receiveChannel7 = receiveChannel4;
                                    i5 = i3;
                                    th5 = th2;
                                    i6 = i4;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        E invoke2 = function12.invoke(Boxing.boxInt(i6));
                                        InlineMarker.finallyStart(2);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(2);
                                        return invoke2;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel6;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$elementAtOrElse$1 = new ChannelsKt__Channels_commonKt$elementAtOrElse$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$elementAtOrElse$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__Channels_commonKt$elementAtOrElse$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2294=4] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0093 A[Catch: all -> 0x0049, TRY_LEAVE, TryCatch #1 {all -> 0x0049, blocks: (B:67:0x003f, B:84:0x008b, B:86:0x0093), top: B:104:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00a4  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x0085 -> B:84:0x008b). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object elementAtOrNull(ReceiveChannel<? extends E> receiveChannel, int i, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$elementAtOrNull$1 channelsKt__Channels_commonKt$elementAtOrNull$1;
        int i2;
        int i3;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        Object obj;
        int i4;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$elementAtOrNull$1 channelsKt__Channels_commonKt$elementAtOrNull$12;
        ReceiveChannel<? extends E> receiveChannel4;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$elementAtOrNull$1) {
            channelsKt__Channels_commonKt$elementAtOrNull$1 = (ChannelsKt__Channels_commonKt$elementAtOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$elementAtOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$elementAtOrNull$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$elementAtOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i2 = channelsKt__Channels_commonKt$elementAtOrNull$1.label;
                if (i2 != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th3 = null;
                    if (i < 0) {
                        ChannelsKt.cancelConsumed(receiveChannel, th3);
                        return null;
                    }
                    i3 = 0;
                    try {
                        th2 = th3;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        i4 = i;
                        receiveChannel3 = receiveChannel2;
                        it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$elementAtOrNull$12 = channelsKt__Channels_commonKt$elementAtOrNull$1;
                        receiveChannel4 = receiveChannel3;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.I$0 = i4;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$1 = receiveChannel2;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$2 = th2;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$3 = receiveChannel4;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.I$1 = i3;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.L$4 = it;
                        channelsKt__Channels_commonKt$elementAtOrNull$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$elementAtOrNull$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$elementAtOrNull$1.L$4;
                    int i5 = channelsKt__Channels_commonKt$elementAtOrNull$1.I$1;
                    ReceiveChannel<? extends E> receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$3;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$elementAtOrNull$1.L$2;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$1;
                    int i6 = channelsKt__Channels_commonKt$elementAtOrNull$1.I$0;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$elementAtOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$elementAtOrNull$12 = channelsKt__Channels_commonKt$elementAtOrNull$1;
                        receiveChannel4 = receiveChannel5;
                        Object obj3 = coroutine_suspended;
                        i4 = i6;
                        th2 = th5;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (!((Boolean) obj2).booleanValue()) {
                            E next = channelIterator2.next();
                            int i7 = i5 + 1;
                            if (i4 == i5) {
                                ChannelsKt.cancelConsumed(receiveChannel6, th2);
                                return next;
                            }
                            receiveChannel2 = receiveChannel6;
                            receiveChannel3 = receiveChannel7;
                            obj = obj3;
                            i3 = i7;
                            it = channelIterator2;
                            try {
                                channelsKt__Channels_commonKt$elementAtOrNull$12.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$elementAtOrNull$12.I$0 = i4;
                                channelsKt__Channels_commonKt$elementAtOrNull$12.L$1 = receiveChannel2;
                                channelsKt__Channels_commonKt$elementAtOrNull$12.L$2 = th2;
                                channelsKt__Channels_commonKt$elementAtOrNull$12.L$3 = receiveChannel4;
                                channelsKt__Channels_commonKt$elementAtOrNull$12.I$1 = i3;
                                channelsKt__Channels_commonKt$elementAtOrNull$12.L$4 = it;
                                channelsKt__Channels_commonKt$elementAtOrNull$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$elementAtOrNull$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel7 = receiveChannel3;
                                i5 = i3;
                                obj3 = obj;
                                receiveChannel6 = receiveChannel2;
                                obj2 = hasNext;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    ChannelsKt.cancelConsumed(receiveChannel6, th2);
                                    return null;
                                }
                            } catch (Throwable th6) {
                                th = th6;
                                try {
                                    throw th;
                                } catch (Throwable th7) {
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    throw th7;
                                }
                            }
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        receiveChannel2 = receiveChannel6;
                        throw th;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$elementAtOrNull$1 = new ChannelsKt__Channels_commonKt$elementAtOrNull$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$elementAtOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i2 = channelsKt__Channels_commonKt$elementAtOrNull$1.label;
        if (i2 != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00a1 A[Catch: all -> 0x00cb, TRY_LEAVE, TryCatch #2 {all -> 0x00cb, blocks: (B:77:0x0099, B:79:0x00a1, B:73:0x007d, B:83:0x00bf), top: B:99:0x0099 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00bf A[Catch: all -> 0x00cb, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x00cb, blocks: (B:77:0x0099, B:79:0x00a1, B:73:0x007d, B:83:0x00bf), top: B:99:0x0099 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x0096 -> B:99:0x0099). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object find(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$find$1 channelsKt__Channels_commonKt$find$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        Function1<? super E, Boolean> function12;
        Throwable th;
        ChannelsKt__Channels_commonKt$find$1 channelsKt__Channels_commonKt$find$12;
        Object obj;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$find$1) {
            channelsKt__Channels_commonKt$find$1 = (ChannelsKt__Channels_commonKt$find$1) continuation;
            if ((channelsKt__Channels_commonKt$find$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$find$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$find$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$find$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        receiveChannel3 = receiveChannel;
                        function12 = function1;
                        th = null;
                        channelsKt__Channels_commonKt$find$12 = channelsKt__Channels_commonKt$find$1;
                        obj = coroutine_suspended;
                        it = receiveChannel.iterator();
                        receiveChannel4 = receiveChannel3;
                        receiveChannel5 = receiveChannel4;
                        receiveChannel6 = receiveChannel5;
                        receiveChannel2 = receiveChannel6;
                        channelsKt__Channels_commonKt$find$12.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$find$12.L$1 = function12;
                        channelsKt__Channels_commonKt$find$12.L$2 = receiveChannel5;
                        channelsKt__Channels_commonKt$find$12.L$3 = receiveChannel6;
                        channelsKt__Channels_commonKt$find$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$find$12.L$5 = th;
                        channelsKt__Channels_commonKt$find$12.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$find$12.L$7 = it;
                        channelsKt__Channels_commonKt$find$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$find$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$find$1.L$7;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$find$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$find$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$find$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$find$12 = channelsKt__Channels_commonKt$find$1;
                        receiveChannel5 = receiveChannel9;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        receiveChannel2 = receiveChannel7;
                        obj = coroutine_suspended;
                        receiveChannel6 = receiveChannel8;
                        th = th4;
                        function12 = function13;
                        try {
                            if (!((Boolean) obj2).booleanValue()) {
                                Object obj3 = (Object) channelIterator2.next();
                                if (function12.invoke(obj3).booleanValue()) {
                                    InlineMarker.finallyStart(2);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(2);
                                    return obj3;
                                }
                                receiveChannel4 = receiveChannel10;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$find$12.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$find$12.L$1 = function12;
                                channelsKt__Channels_commonKt$find$12.L$2 = receiveChannel5;
                                channelsKt__Channels_commonKt$find$12.L$3 = receiveChannel6;
                                channelsKt__Channels_commonKt$find$12.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$find$12.L$5 = th;
                                channelsKt__Channels_commonKt$find$12.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$find$12.L$7 = it;
                                channelsKt__Channels_commonKt$find$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$find$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel10 = receiveChannel4;
                                obj2 = hasNext;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    return null;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            try {
                                throw th2;
                            } finally {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                InlineMarker.finallyEnd(1);
                            }
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        receiveChannel2 = receiveChannel7;
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$find$1 = new ChannelsKt__Channels_commonKt$find$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$find$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$find$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a9 A[Catch: all -> 0x00cd, TryCatch #2 {all -> 0x00cd, blocks: (B:75:0x00a1, B:77:0x00a9, B:79:0x00b9, B:71:0x0081, B:81:0x00bf), top: B:96:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bf A[Catch: all -> 0x00cd, TRY_LEAVE, TryCatch #2 {all -> 0x00cd, blocks: (B:75:0x00a1, B:77:0x00a9, B:79:0x00b9, B:71:0x0081, B:81:0x00bf), top: B:96:0x00a1 }] */
    /* JADX WARN: Type inference failed for: r15v9, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x009c -> B:96:0x00a1). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object findLast(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$findLast$1 channelsKt__Channels_commonKt$findLast$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.ObjectRef objectRef;
        ChannelsKt__Channels_commonKt$findLast$1 channelsKt__Channels_commonKt$findLast$12;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$findLast$1) {
                channelsKt__Channels_commonKt$findLast$1 = (ChannelsKt__Channels_commonKt$findLast$1) continuation;
                if ((channelsKt__Channels_commonKt$findLast$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$findLast$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$findLast$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$findLast$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = null;
                        try {
                            objectRef = objectRef2;
                            channelsKt__Channels_commonKt$findLast$12 = channelsKt__Channels_commonKt$findLast$1;
                            obj = coroutine_suspended;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            receiveChannel2 = receiveChannel4;
                            receiveChannel5 = receiveChannel2;
                            it = receiveChannel.iterator();
                            function12 = function1;
                            receiveChannel6 = receiveChannel5;
                            channelsKt__Channels_commonKt$findLast$12.L$0 = receiveChannel6;
                            channelsKt__Channels_commonKt$findLast$12.L$1 = function12;
                            channelsKt__Channels_commonKt$findLast$12.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$findLast$12.L$3 = objectRef;
                            channelsKt__Channels_commonKt$findLast$12.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$findLast$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$findLast$12.L$6 = th2;
                            channelsKt__Channels_commonKt$findLast$12.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$findLast$12.L$8 = it;
                            channelsKt__Channels_commonKt$findLast$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$findLast$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$findLast$1.L$8;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$7;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$findLast$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$4;
                        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$findLast$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$findLast$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$findLast$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel5 = receiveChannel7;
                            receiveChannel6 = receiveChannel11;
                            Ref.ObjectRef objectRef4 = objectRef3;
                            obj = coroutine_suspended;
                            receiveChannel2 = receiveChannel8;
                            function12 = function13;
                            Throwable th5 = th4;
                            channelsKt__Channels_commonKt$findLast$12 = channelsKt__Channels_commonKt$findLast$1;
                            receiveChannel4 = receiveChannel9;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    ?? r15 = (Object) channelIterator2.next();
                                    if (function12.invoke(r15).booleanValue()) {
                                        objectRef4.element = r15;
                                    }
                                    receiveChannel3 = receiveChannel10;
                                    th2 = th5;
                                    objectRef = objectRef4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$findLast$12.L$0 = receiveChannel6;
                                    channelsKt__Channels_commonKt$findLast$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$findLast$12.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$findLast$12.L$3 = objectRef;
                                    channelsKt__Channels_commonKt$findLast$12.L$4 = receiveChannel4;
                                    channelsKt__Channels_commonKt$findLast$12.L$5 = receiveChannel2;
                                    channelsKt__Channels_commonKt$findLast$12.L$6 = th2;
                                    channelsKt__Channels_commonKt$findLast$12.L$7 = receiveChannel5;
                                    channelsKt__Channels_commonKt$findLast$12.L$8 = it;
                                    channelsKt__Channels_commonKt$findLast$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$findLast$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Throwable th6 = th2;
                                    receiveChannel10 = receiveChannel3;
                                    obj2 = hasNext;
                                    objectRef4 = objectRef;
                                    th5 = th6;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(1);
                                        return objectRef4.element;
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            receiveChannel2 = receiveChannel8;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th9) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th9;
        }
        channelsKt__Channels_commonKt$findLast$1 = new ChannelsKt__Channels_commonKt$findLast$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$findLast$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$findLast$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0072 A[Catch: all -> 0x003e, TRY_LEAVE, TryCatch #2 {all -> 0x003e, blocks: (B:53:0x003a, B:64:0x006a, B:66:0x0072, B:69:0x007a, B:70:0x0083), top: B:81:0x003a }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x007a A[Catch: all -> 0x003e, TRY_ENTER, TryCatch #2 {all -> 0x003e, blocks: (B:53:0x003a, B:64:0x006a, B:66:0x0072, B:69:0x007a, B:70:0x0083), top: B:81:0x003a }] */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$first$1 channelsKt__Channels_commonKt$first$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$first$1) {
            channelsKt__Channels_commonKt$first$1 = (ChannelsKt__Channels_commonKt$first$1) continuation;
            if ((channelsKt__Channels_commonKt$first$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$first$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$first$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$first$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th3 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$first$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$2 = th3;
                        channelsKt__Channels_commonKt$first$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$first$1.L$4 = it;
                        channelsKt__Channels_commonKt$first$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__Channels_commonKt$first$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th2 = th3;
                        obj = hasNext;
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$first$1.L$4;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$first$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$first$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            throw th;
                        } finally {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                        }
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                return channelIterator.next();
            }
        }
        channelsKt__Channels_commonKt$first$1 = new ChannelsKt__Channels_commonKt$first$1(continuation);
        obj = channelsKt__Channels_commonKt$first$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$first$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0092 A[Catch: all -> 0x00c6, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:76:0x008a, B:78:0x0092, B:72:0x006e, B:83:0x00b1), top: B:94:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00b1 A[Catch: all -> 0x00c6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:76:0x008a, B:78:0x0092, B:72:0x006e, B:83:0x00b1), top: B:94:0x008a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0085 -> B:94:0x008a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object first(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$first$3 channelsKt__Channels_commonKt$first$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$first$3 channelsKt__Channels_commonKt$first$32;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$first$3) {
                channelsKt__Channels_commonKt$first$3 = (ChannelsKt__Channels_commonKt$first$3) continuation;
                if ((channelsKt__Channels_commonKt$first$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$first$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$first$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$first$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            th2 = null;
                            channelsKt__Channels_commonKt$first$32 = channelsKt__Channels_commonKt$first$3;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$first$32.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$first$32.L$1 = function12;
                            channelsKt__Channels_commonKt$first$32.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$first$32.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$first$32.L$4 = th2;
                            channelsKt__Channels_commonKt$first$32.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$first$32.L$6 = it;
                            channelsKt__Channels_commonKt$first$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$first$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$first$3.L$6;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$first$3.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$first$3.L$4;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$first$3.L$3;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$first$3.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$first$3.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$first$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Throwable th5 = th4;
                            function12 = function13;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$first$32 = channelsKt__Channels_commonKt$first$3;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    Object obj4 = (Object) channelIterator2.next();
                                    if (function12.invoke(obj4).booleanValue()) {
                                        InlineMarker.finallyStart(2);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(2);
                                        return obj4;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$first$32.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$first$32.L$1 = function12;
                                    channelsKt__Channels_commonKt$first$32.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$first$32.L$3 = receiveChannel2;
                                    channelsKt__Channels_commonKt$first$32.L$4 = th2;
                                    channelsKt__Channels_commonKt$first$32.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$first$32.L$6 = it;
                                    channelsKt__Channels_commonKt$first$32.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$first$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj5 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    th5 = th2;
                                    obj3 = obj5;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(1);
                                        throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$first$3 = new ChannelsKt__Channels_commonKt$first$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$first$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$first$3.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2398=4] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0073 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0077 A[Catch: all -> 0x003f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x003f, blocks: (B:54:0x003b, B:65:0x006b, B:69:0x0077), top: B:82:0x003b }] */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$firstOrNull$1 channelsKt__Channels_commonKt$firstOrNull$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelIterator channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$firstOrNull$1) {
            channelsKt__Channels_commonKt$firstOrNull$1 = (ChannelsKt__Channels_commonKt$firstOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$firstOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$firstOrNull$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$firstOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$firstOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th3 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$firstOrNull$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$2 = th3;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$firstOrNull$1.L$4 = it;
                        channelsKt__Channels_commonKt$firstOrNull$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__Channels_commonKt$firstOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        th2 = th3;
                        obj = hasNext;
                        receiveChannel2 = receiveChannel;
                        channelIterator = it;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$firstOrNull$1.L$4;
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$firstOrNull$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th5) {
                        th = th5;
                        try {
                            throw th;
                        } finally {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                        }
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    return null;
                }
                return channelIterator.next();
            }
        }
        channelsKt__Channels_commonKt$firstOrNull$1 = new ChannelsKt__Channels_commonKt$firstOrNull$1(continuation);
        obj = channelsKt__Channels_commonKt$firstOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$firstOrNull$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0085 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0093 A[Catch: all -> 0x00be, TRY_LEAVE, TryCatch #3 {all -> 0x00be, blocks: (B:76:0x008b, B:78:0x0093, B:72:0x006f, B:83:0x00b2), top: B:100:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00b2 A[Catch: all -> 0x00be, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x00be, blocks: (B:76:0x008b, B:78:0x0093, B:72:0x006f, B:83:0x00b2), top: B:100:0x008b }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0086 -> B:100:0x008b). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object firstOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$firstOrNull$3 channelsKt__Channels_commonKt$firstOrNull$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$firstOrNull$3 channelsKt__Channels_commonKt$firstOrNull$32;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$firstOrNull$3) {
                channelsKt__Channels_commonKt$firstOrNull$3 = (ChannelsKt__Channels_commonKt$firstOrNull$3) continuation;
                if ((channelsKt__Channels_commonKt$firstOrNull$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$firstOrNull$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$firstOrNull$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$firstOrNull$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            th2 = null;
                            channelsKt__Channels_commonKt$firstOrNull$32 = channelsKt__Channels_commonKt$firstOrNull$3;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$firstOrNull$32.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$firstOrNull$32.L$1 = function12;
                            channelsKt__Channels_commonKt$firstOrNull$32.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$firstOrNull$32.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$firstOrNull$32.L$4 = th2;
                            channelsKt__Channels_commonKt$firstOrNull$32.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$firstOrNull$32.L$6 = it;
                            channelsKt__Channels_commonKt$firstOrNull$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$firstOrNull$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$firstOrNull$3.L$6;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$3.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$firstOrNull$3.L$4;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$3.L$3;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$3.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$firstOrNull$3.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$firstOrNull$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Throwable th5 = th4;
                            function12 = function13;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$firstOrNull$32 = channelsKt__Channels_commonKt$firstOrNull$3;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    Object obj4 = (Object) channelIterator2.next();
                                    if (function12.invoke(obj4).booleanValue()) {
                                        InlineMarker.finallyStart(2);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(2);
                                        return obj4;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$firstOrNull$32.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$firstOrNull$32.L$1 = function12;
                                    channelsKt__Channels_commonKt$firstOrNull$32.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$firstOrNull$32.L$3 = receiveChannel2;
                                    channelsKt__Channels_commonKt$firstOrNull$32.L$4 = th2;
                                    channelsKt__Channels_commonKt$firstOrNull$32.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$firstOrNull$32.L$6 = it;
                                    channelsKt__Channels_commonKt$firstOrNull$32.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$firstOrNull$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj5 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    th5 = th2;
                                    obj3 = obj5;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(1);
                                        return null;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$firstOrNull$3 = new ChannelsKt__Channels_commonKt$firstOrNull$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$firstOrNull$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$firstOrNull$3.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0093 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a2 A[Catch: all -> 0x00cb, TryCatch #2 {all -> 0x00cb, blocks: (B:76:0x009a, B:78:0x00a2, B:80:0x00ac, B:83:0x00b6, B:72:0x007b, B:84:0x00c0), top: B:99:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00c0 A[Catch: all -> 0x00cb, TRY_LEAVE, TryCatch #2 {all -> 0x00cb, blocks: (B:76:0x009a, B:78:0x00a2, B:80:0x00ac, B:83:0x00b6, B:72:0x007b, B:84:0x00c0), top: B:99:0x009a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0094 -> B:99:0x009a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object indexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$indexOf$1 channelsKt__Channels_commonKt$indexOf$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$indexOf$1 channelsKt__Channels_commonKt$indexOf$12;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$indexOf$1) {
                channelsKt__Channels_commonKt$indexOf$1 = (ChannelsKt__Channels_commonKt$indexOf$1) continuation;
                if ((channelsKt__Channels_commonKt$indexOf$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$indexOf$1.label -= Integer.MIN_VALUE;
                    Object obj3 = channelsKt__Channels_commonKt$indexOf$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$indexOf$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj3);
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        intRef2.element = 0;
                        try {
                            intRef = intRef2;
                            obj = coroutine_suspended;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            obj2 = e;
                            receiveChannel5 = receiveChannel4;
                            it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$indexOf$12 = channelsKt__Channels_commonKt$indexOf$1;
                            receiveChannel2 = receiveChannel5;
                            channelsKt__Channels_commonKt$indexOf$12.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$indexOf$12.L$1 = obj2;
                            channelsKt__Channels_commonKt$indexOf$12.L$2 = intRef;
                            channelsKt__Channels_commonKt$indexOf$12.L$3 = receiveChannel3;
                            channelsKt__Channels_commonKt$indexOf$12.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$indexOf$12.L$5 = th2;
                            channelsKt__Channels_commonKt$indexOf$12.L$6 = receiveChannel4;
                            channelsKt__Channels_commonKt$indexOf$12.L$7 = it;
                            channelsKt__Channels_commonKt$indexOf$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$indexOf$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$indexOf$1.L$7;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$6;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$indexOf$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$3;
                        Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$indexOf$1.L$2;
                        Object obj4 = channelsKt__Channels_commonKt$indexOf$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOf$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Ref.IntRef intRef4 = intRef3;
                            Object obj5 = coroutine_suspended;
                            channelsKt__Channels_commonKt$indexOf$12 = channelsKt__Channels_commonKt$indexOf$1;
                            receiveChannel2 = receiveChannel7;
                            Throwable th5 = th4;
                            obj2 = obj4;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (((Boolean) obj3).booleanValue()) {
                                    if (Intrinsics.areEqual(obj2, channelIterator2.next())) {
                                        Integer boxInt = Boxing.boxInt(intRef4.element);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        return boxInt;
                                    }
                                    intRef4.element++;
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj5;
                                    th2 = th5;
                                    intRef = intRef4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$indexOf$12.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$indexOf$12.L$1 = obj2;
                                    channelsKt__Channels_commonKt$indexOf$12.L$2 = intRef;
                                    channelsKt__Channels_commonKt$indexOf$12.L$3 = receiveChannel3;
                                    channelsKt__Channels_commonKt$indexOf$12.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$indexOf$12.L$5 = th2;
                                    channelsKt__Channels_commonKt$indexOf$12.L$6 = receiveChannel4;
                                    channelsKt__Channels_commonKt$indexOf$12.L$7 = it;
                                    channelsKt__Channels_commonKt$indexOf$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$indexOf$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj6 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj3 = hasNext;
                                    intRef4 = intRef;
                                    th5 = th2;
                                    obj5 = obj6;
                                    channelIterator2 = it;
                                    if (((Boolean) obj3).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    return Boxing.boxInt(-1);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th8;
        }
        channelsKt__Channels_commonKt$indexOf$1 = new ChannelsKt__Channels_commonKt$indexOf$1(continuation);
        Object obj32 = channelsKt__Channels_commonKt$indexOf$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$indexOf$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a4 A[Catch: all -> 0x00e0, TryCatch #0 {all -> 0x00e0, blocks: (B:76:0x009c, B:78:0x00a4, B:80:0x00b4, B:83:0x00c5, B:72:0x007d, B:84:0x00cf), top: B:95:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00cf A[Catch: all -> 0x00e0, TRY_LEAVE, TryCatch #0 {all -> 0x00e0, blocks: (B:76:0x009c, B:78:0x00a4, B:80:0x00b4, B:83:0x00c5, B:72:0x007d, B:84:0x00cf), top: B:95:0x009c }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0096 -> B:95:0x009c). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object indexOfFirst(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$indexOfFirst$1 channelsKt__Channels_commonKt$indexOfFirst$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$indexOfFirst$1 channelsKt__Channels_commonKt$indexOfFirst$12;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$indexOfFirst$1) {
                channelsKt__Channels_commonKt$indexOfFirst$1 = (ChannelsKt__Channels_commonKt$indexOfFirst$1) continuation;
                if ((channelsKt__Channels_commonKt$indexOfFirst$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$indexOfFirst$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$indexOfFirst$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$indexOfFirst$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        intRef2.element = 0;
                        try {
                            intRef = intRef2;
                            obj = coroutine_suspended;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$indexOfFirst$12 = channelsKt__Channels_commonKt$indexOfFirst$1;
                            receiveChannel2 = receiveChannel5;
                            channelsKt__Channels_commonKt$indexOfFirst$12.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$indexOfFirst$12.L$1 = function12;
                            channelsKt__Channels_commonKt$indexOfFirst$12.L$2 = intRef;
                            channelsKt__Channels_commonKt$indexOfFirst$12.L$3 = receiveChannel3;
                            channelsKt__Channels_commonKt$indexOfFirst$12.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$indexOfFirst$12.L$5 = th2;
                            channelsKt__Channels_commonKt$indexOfFirst$12.L$6 = receiveChannel4;
                            channelsKt__Channels_commonKt$indexOfFirst$12.L$7 = it;
                            channelsKt__Channels_commonKt$indexOfFirst$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$indexOfFirst$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$indexOfFirst$1.L$7;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfFirst$1.L$6;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$indexOfFirst$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfFirst$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfFirst$1.L$3;
                        Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$indexOfFirst$1.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$indexOfFirst$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfFirst$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Ref.IntRef intRef4 = intRef3;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$indexOfFirst$12 = channelsKt__Channels_commonKt$indexOfFirst$1;
                            receiveChannel2 = receiveChannel7;
                            Throwable th5 = th4;
                            function12 = function13;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (((Boolean) obj2).booleanValue()) {
                                    if (function12.invoke((Object) channelIterator2.next()).booleanValue()) {
                                        Integer boxInt = Boxing.boxInt(intRef4.element);
                                        InlineMarker.finallyStart(2);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(2);
                                        return boxInt;
                                    }
                                    intRef4.element++;
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    intRef = intRef4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.L$2 = intRef;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.L$3 = receiveChannel3;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.L$5 = th2;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.L$6 = receiveChannel4;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.L$7 = it;
                                    channelsKt__Channels_commonKt$indexOfFirst$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$indexOfFirst$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    intRef4 = intRef;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (((Boolean) obj2).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    InlineMarker.finallyEnd(1);
                                    return Boxing.boxInt(-1);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$indexOfFirst$1 = new ChannelsKt__Channels_commonKt$indexOfFirst$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$indexOfFirst$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$indexOfFirst$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b4 A[Catch: all -> 0x00e5, TryCatch #0 {all -> 0x00e5, blocks: (B:75:0x00ac, B:77:0x00b4, B:79:0x00c4, B:80:0x00c8, B:71:0x008a, B:81:0x00d3), top: B:92:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00d3 A[Catch: all -> 0x00e5, TRY_LEAVE, TryCatch #0 {all -> 0x00e5, blocks: (B:75:0x00ac, B:77:0x00b4, B:79:0x00c4, B:80:0x00c8, B:71:0x008a, B:81:0x00d3), top: B:92:0x00ac }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x00a5 -> B:92:0x00ac). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object indexOfLast(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$indexOfLast$1 channelsKt__Channels_commonKt$indexOfLast$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Function1<? super E, Boolean> function12;
        ChannelsKt__Channels_commonKt$indexOfLast$1 channelsKt__Channels_commonKt$indexOfLast$12;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$indexOfLast$1) {
                channelsKt__Channels_commonKt$indexOfLast$1 = (ChannelsKt__Channels_commonKt$indexOfLast$1) continuation;
                if ((channelsKt__Channels_commonKt$indexOfLast$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$indexOfLast$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$indexOfLast$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$indexOfLast$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.IntRef intRef3 = new Ref.IntRef();
                        intRef3.element = -1;
                        Ref.IntRef intRef4 = new Ref.IntRef();
                        intRef4.element = 0;
                        try {
                            intRef = intRef3;
                            intRef2 = intRef4;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            function12 = function1;
                            channelsKt__Channels_commonKt$indexOfLast$12 = channelsKt__Channels_commonKt$indexOfLast$1;
                            receiveChannel4 = receiveChannel3;
                            receiveChannel2 = receiveChannel4;
                            it = receiveChannel.iterator();
                            obj = coroutine_suspended;
                            receiveChannel5 = receiveChannel2;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$0 = receiveChannel4;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$1 = function12;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$2 = intRef;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$3 = intRef2;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$4 = receiveChannel3;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$6 = th2;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$indexOfLast$12.L$8 = it;
                            channelsKt__Channels_commonKt$indexOfLast$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$indexOfLast$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$indexOfLast$1.L$8;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfLast$1.L$7;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$indexOfLast$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfLast$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfLast$1.L$4;
                        Ref.IntRef intRef5 = (Ref.IntRef) channelsKt__Channels_commonKt$indexOfLast$1.L$3;
                        Ref.IntRef intRef6 = (Ref.IntRef) channelsKt__Channels_commonKt$indexOfLast$1.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$indexOfLast$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$indexOfLast$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel5 = receiveChannel6;
                            receiveChannel4 = receiveChannel9;
                            Ref.IntRef intRef7 = intRef6;
                            Throwable th5 = th4;
                            function12 = function13;
                            Ref.IntRef intRef8 = intRef5;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$indexOfLast$12 = channelsKt__Channels_commonKt$indexOfLast$1;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (((Boolean) obj2).booleanValue()) {
                                    if (function12.invoke((Object) channelIterator2.next()).booleanValue()) {
                                        intRef7.element = intRef8.element;
                                    }
                                    intRef8.element++;
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    intRef2 = intRef8;
                                    intRef = intRef7;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$0 = receiveChannel4;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$2 = intRef;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$3 = intRef2;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$4 = receiveChannel3;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$5 = receiveChannel2;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$6 = th2;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$7 = receiveChannel5;
                                    channelsKt__Channels_commonKt$indexOfLast$12.L$8 = it;
                                    channelsKt__Channels_commonKt$indexOfLast$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$indexOfLast$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    intRef7 = intRef;
                                    intRef8 = intRef2;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (((Boolean) obj2).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    InlineMarker.finallyEnd(1);
                                    return Boxing.boxInt(intRef7.element);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$indexOfLast$1 = new ChannelsKt__Channels_commonKt$indexOfLast$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$indexOfLast$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$indexOfLast$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [469=4] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00cc A[Catch: all -> 0x0068, TRY_ENTER, TryCatch #2 {all -> 0x0068, blocks: (B:78:0x0064, B:87:0x008f, B:89:0x0097, B:101:0x00cc, B:102:0x00d5), top: B:113:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0097 A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #2 {all -> 0x0068, blocks: (B:78:0x0064, B:87:0x008f, B:89:0x0097, B:101:0x00cc, B:102:0x00d5), top: B:113:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00c2 A[Catch: all -> 0x0044, TRY_LEAVE, TryCatch #0 {all -> 0x0044, blocks: (B:71:0x003f, B:95:0x00ba, B:97:0x00c2), top: B:109:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00c8  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x00b6 -> B:95:0x00ba). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$last$1 channelsKt__Channels_commonKt$last$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th;
        Object next;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$last$1) {
            channelsKt__Channels_commonKt$last$1 = (ChannelsKt__Channels_commonKt$last$1) continuation;
            if ((channelsKt__Channels_commonKt$last$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$last$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$last$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$last$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th3 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$2 = th3;
                        channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$last$1.L$4 = it;
                        channelsKt__Channels_commonKt$last$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$last$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        channelIterator = it;
                        receiveChannel4 = receiveChannel3;
                        th = th3;
                        obj = hasNext2;
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$last$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$3;
                    th = (Throwable) channelsKt__Channels_commonKt$last$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th5) {
                        th = th5;
                        throw th;
                    }
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Object obj2 = channelsKt__Channels_commonKt$last$1.L$5;
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$last$1.L$4;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$last$1.L$2;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$1;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$last$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator2.next();
                            receiveChannel = receiveChannel7;
                            channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel;
                            channelsKt__Channels_commonKt$last$1.L$2 = th2;
                            channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel6;
                            channelsKt__Channels_commonKt$last$1.L$4 = channelIterator2;
                            channelsKt__Channels_commonKt$last$1.L$5 = next;
                            channelsKt__Channels_commonKt$last$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$last$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel7 = receiveChannel;
                            obj2 = next;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                ChannelsKt.cancelConsumed(receiveChannel7, th2);
                                return obj2;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th;
                        } catch (Throwable th7) {
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            throw th7;
                        }
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                next = channelIterator.next();
                receiveChannel5 = receiveChannel3;
                ReceiveChannel<? extends E> receiveChannel8 = receiveChannel4;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel2;
                th2 = th;
                receiveChannel6 = receiveChannel8;
                channelsKt__Channels_commonKt$last$1.L$0 = receiveChannel5;
                channelsKt__Channels_commonKt$last$1.L$1 = receiveChannel;
                channelsKt__Channels_commonKt$last$1.L$2 = th2;
                channelsKt__Channels_commonKt$last$1.L$3 = receiveChannel6;
                channelsKt__Channels_commonKt$last$1.L$4 = channelIterator2;
                channelsKt__Channels_commonKt$last$1.L$5 = next;
                channelsKt__Channels_commonKt$last$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$last$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__Channels_commonKt$last$1 = new ChannelsKt__Channels_commonKt$last$1(continuation);
        obj = channelsKt__Channels_commonKt$last$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$last$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b3 A[Catch: all -> 0x00e9, TryCatch #0 {all -> 0x00e9, blocks: (B:79:0x00ab, B:81:0x00b3, B:83:0x00c3, B:75:0x0089, B:85:0x00cd), top: B:100:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00cd A[Catch: all -> 0x00e9, TRY_LEAVE, TryCatch #0 {all -> 0x00e9, blocks: (B:79:0x00ab, B:81:0x00b3, B:83:0x00c3, B:75:0x0089, B:85:0x00cd), top: B:100:0x00ab }] */
    /* JADX WARN: Type inference failed for: r15v9, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x00a4 -> B:100:0x00ab). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object last(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$last$3 channelsKt__Channels_commonKt$last$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.ObjectRef objectRef;
        Throwable th2;
        Ref.BooleanRef booleanRef;
        ReceiveChannel<? extends E> receiveChannel3;
        Function1<? super E, Boolean> function12;
        ChannelsKt__Channels_commonKt$last$3 channelsKt__Channels_commonKt$last$32;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$last$3) {
                channelsKt__Channels_commonKt$last$3 = (ChannelsKt__Channels_commonKt$last$3) continuation;
                if ((channelsKt__Channels_commonKt$last$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$last$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$last$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$last$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = null;
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        booleanRef2.element = false;
                        try {
                            objectRef = objectRef2;
                            th2 = null;
                            booleanRef = booleanRef2;
                            receiveChannel3 = receiveChannel;
                            function12 = function1;
                            channelsKt__Channels_commonKt$last$32 = channelsKt__Channels_commonKt$last$3;
                            receiveChannel4 = receiveChannel3;
                            receiveChannel2 = receiveChannel4;
                            it = receiveChannel.iterator();
                            obj = coroutine_suspended;
                            receiveChannel5 = receiveChannel2;
                            channelsKt__Channels_commonKt$last$32.L$0 = receiveChannel4;
                            channelsKt__Channels_commonKt$last$32.L$1 = function12;
                            channelsKt__Channels_commonKt$last$32.L$2 = objectRef;
                            channelsKt__Channels_commonKt$last$32.L$3 = booleanRef;
                            channelsKt__Channels_commonKt$last$32.L$4 = receiveChannel3;
                            channelsKt__Channels_commonKt$last$32.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$last$32.L$6 = th2;
                            channelsKt__Channels_commonKt$last$32.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$last$32.L$8 = it;
                            channelsKt__Channels_commonKt$last$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$last$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$last$3.L$8;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$last$3.L$7;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$last$3.L$6;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$last$3.L$5;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$last$3.L$4;
                        Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) channelsKt__Channels_commonKt$last$3.L$3;
                        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$last$3.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$last$3.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$last$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel5 = receiveChannel6;
                            receiveChannel4 = receiveChannel9;
                            Ref.ObjectRef objectRef4 = objectRef3;
                            Throwable th5 = th4;
                            function12 = function13;
                            Ref.BooleanRef booleanRef4 = booleanRef3;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$last$32 = channelsKt__Channels_commonKt$last$3;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    ?? r15 = (Object) channelIterator2.next();
                                    if (function12.invoke(r15).booleanValue()) {
                                        objectRef4.element = r15;
                                        booleanRef4.element = true;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    booleanRef = booleanRef4;
                                    objectRef = objectRef4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$last$32.L$0 = receiveChannel4;
                                    channelsKt__Channels_commonKt$last$32.L$1 = function12;
                                    channelsKt__Channels_commonKt$last$32.L$2 = objectRef;
                                    channelsKt__Channels_commonKt$last$32.L$3 = booleanRef;
                                    channelsKt__Channels_commonKt$last$32.L$4 = receiveChannel3;
                                    channelsKt__Channels_commonKt$last$32.L$5 = receiveChannel2;
                                    channelsKt__Channels_commonKt$last$32.L$6 = th2;
                                    channelsKt__Channels_commonKt$last$32.L$7 = receiveChannel5;
                                    channelsKt__Channels_commonKt$last$32.L$8 = it;
                                    channelsKt__Channels_commonKt$last$32.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$last$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    objectRef4 = objectRef;
                                    booleanRef4 = booleanRef;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(1);
                                        if (!booleanRef4.element) {
                                            throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                                        }
                                        return objectRef4.element;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$last$3 = new ChannelsKt__Channels_commonKt$last$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$last$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$last$3.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b2 A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:75:0x00aa, B:77:0x00b2, B:79:0x00bc, B:80:0x00c0, B:71:0x0088, B:81:0x00cb), top: B:92:0x00aa }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00cb A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #0 {all -> 0x00d7, blocks: (B:75:0x00aa, B:77:0x00b2, B:79:0x00bc, B:80:0x00c0, B:71:0x0088, B:81:0x00cb), top: B:92:0x00aa }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x00a3 -> B:92:0x00aa). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object lastIndexOf(ReceiveChannel<? extends E> receiveChannel, E e, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$lastIndexOf$1 channelsKt__Channels_commonKt$lastIndexOf$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        Ref.IntRef intRef2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Object obj;
        ChannelsKt__Channels_commonKt$lastIndexOf$1 channelsKt__Channels_commonKt$lastIndexOf$12;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$lastIndexOf$1) {
                channelsKt__Channels_commonKt$lastIndexOf$1 = (ChannelsKt__Channels_commonKt$lastIndexOf$1) continuation;
                if ((channelsKt__Channels_commonKt$lastIndexOf$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$lastIndexOf$1.label -= Integer.MIN_VALUE;
                    Object obj3 = channelsKt__Channels_commonKt$lastIndexOf$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$lastIndexOf$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj3);
                        Ref.IntRef intRef3 = new Ref.IntRef();
                        intRef3.element = -1;
                        Ref.IntRef intRef4 = new Ref.IntRef();
                        intRef4.element = 0;
                        try {
                            intRef = intRef3;
                            intRef2 = intRef4;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            obj = e;
                            channelsKt__Channels_commonKt$lastIndexOf$12 = channelsKt__Channels_commonKt$lastIndexOf$1;
                            receiveChannel4 = receiveChannel3;
                            receiveChannel2 = receiveChannel4;
                            it = receiveChannel.iterator();
                            obj2 = coroutine_suspended;
                            receiveChannel5 = receiveChannel2;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$0 = receiveChannel4;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$1 = obj;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$2 = intRef;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$3 = intRef2;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$4 = receiveChannel3;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$6 = th2;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$lastIndexOf$12.L$8 = it;
                            channelsKt__Channels_commonKt$lastIndexOf$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$lastIndexOf$12);
                            if (hasNext != obj2) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$lastIndexOf$1.L$8;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$7;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$lastIndexOf$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$4;
                        Ref.IntRef intRef5 = (Ref.IntRef) channelsKt__Channels_commonKt$lastIndexOf$1.L$3;
                        Ref.IntRef intRef6 = (Ref.IntRef) channelsKt__Channels_commonKt$lastIndexOf$1.L$2;
                        Object obj4 = channelsKt__Channels_commonKt$lastIndexOf$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$lastIndexOf$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj3);
                            receiveChannel5 = receiveChannel6;
                            receiveChannel4 = receiveChannel9;
                            Ref.IntRef intRef7 = intRef6;
                            Throwable th5 = th4;
                            obj = obj4;
                            Ref.IntRef intRef8 = intRef5;
                            Object obj5 = coroutine_suspended;
                            channelsKt__Channels_commonKt$lastIndexOf$12 = channelsKt__Channels_commonKt$lastIndexOf$1;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (((Boolean) obj3).booleanValue()) {
                                    if (Intrinsics.areEqual(obj, channelIterator2.next())) {
                                        intRef7.element = intRef8.element;
                                    }
                                    intRef8.element++;
                                    receiveChannel3 = receiveChannel8;
                                    obj2 = obj5;
                                    th2 = th5;
                                    intRef2 = intRef8;
                                    intRef = intRef7;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$0 = receiveChannel4;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$1 = obj;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$2 = intRef;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$3 = intRef2;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$4 = receiveChannel3;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$5 = receiveChannel2;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$6 = th2;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$7 = receiveChannel5;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.L$8 = it;
                                    channelsKt__Channels_commonKt$lastIndexOf$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$lastIndexOf$12);
                                    if (hasNext != obj2) {
                                        return obj2;
                                    }
                                    Object obj6 = obj2;
                                    receiveChannel8 = receiveChannel3;
                                    obj3 = hasNext;
                                    intRef7 = intRef;
                                    intRef8 = intRef2;
                                    th5 = th2;
                                    obj5 = obj6;
                                    channelIterator2 = it;
                                    if (((Boolean) obj3).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    return Boxing.boxInt(intRef7.element);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th8;
        }
        channelsKt__Channels_commonKt$lastIndexOf$1 = new ChannelsKt__Channels_commonKt$lastIndexOf$1(continuation);
        Object obj32 = channelsKt__Channels_commonKt$lastIndexOf$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$lastIndexOf$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [545=4, 2520=4] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0094 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0098 A[Catch: all -> 0x0065, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0065, blocks: (B:69:0x0040, B:94:0x00b8, B:96:0x00c0, B:74:0x0061, B:83:0x008c, B:87:0x0098), top: B:106:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00b3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c0 A[Catch: all -> 0x0065, TRY_LEAVE, TryCatch #0 {all -> 0x0065, blocks: (B:69:0x0040, B:94:0x00b8, B:96:0x00c0, B:74:0x0061, B:83:0x008c, B:87:0x0098), top: B:106:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00c5 A[DONT_GENERATE] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:93:0x00b4 -> B:94:0x00b8). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$lastOrNull$1 channelsKt__Channels_commonKt$lastOrNull$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th;
        Object next;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator2;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$lastOrNull$1) {
                channelsKt__Channels_commonKt$lastOrNull$1 = (ChannelsKt__Channels_commonKt$lastOrNull$1) continuation;
                if ((channelsKt__Channels_commonKt$lastOrNull$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$lastOrNull$1.label -= Integer.MIN_VALUE;
                    obj = channelsKt__Channels_commonKt$lastOrNull$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$lastOrNull$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        Throwable th2 = null;
                        try {
                            ChannelIterator<? extends E> it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th2;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$4 = it;
                            channelsKt__Channels_commonKt$lastOrNull$1.label = 1;
                            Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                            if (hasNext2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel2 = receiveChannel;
                            receiveChannel3 = receiveChannel2;
                            channelIterator = it;
                            receiveChannel4 = receiveChannel3;
                            th = th2;
                            obj = hasNext2;
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                            try {
                                throw th;
                            } finally {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                            }
                        }
                    } else if (i == 1) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$1.L$4;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$3;
                        th = (Throwable) channelsKt__Channels_commonKt$lastOrNull$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object obj2 = channelsKt__Channels_commonKt$lastOrNull$1.L$5;
                        channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$1.L$4;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$3;
                        th = (Throwable) channelsKt__Channels_commonKt$lastOrNull$1.L$2;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$1;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator2.next();
                            receiveChannel = receiveChannel2;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel5;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$4 = channelIterator2;
                            channelsKt__Channels_commonKt$lastOrNull$1.L$5 = next;
                            channelsKt__Channels_commonKt$lastOrNull$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel2 = receiveChannel;
                            obj2 = next;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                return obj2;
                            }
                        }
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return null;
                    }
                    next = channelIterator.next();
                    receiveChannel5 = receiveChannel4;
                    channelIterator2 = channelIterator;
                    receiveChannel = receiveChannel2;
                    channelsKt__Channels_commonKt$lastOrNull$1.L$0 = receiveChannel3;
                    channelsKt__Channels_commonKt$lastOrNull$1.L$1 = receiveChannel;
                    channelsKt__Channels_commonKt$lastOrNull$1.L$2 = th;
                    channelsKt__Channels_commonKt$lastOrNull$1.L$3 = receiveChannel5;
                    channelsKt__Channels_commonKt$lastOrNull$1.L$4 = channelIterator2;
                    channelsKt__Channels_commonKt$lastOrNull$1.L$5 = next;
                    channelsKt__Channels_commonKt$lastOrNull$1.label = 2;
                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$lastOrNull$1);
                    if (hasNext != coroutine_suspended) {
                    }
                }
            }
            if (i != 0) {
            }
            if (((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
        channelsKt__Channels_commonKt$lastOrNull$1 = new ChannelsKt__Channels_commonKt$lastOrNull$1(continuation);
        obj = channelsKt__Channels_commonKt$lastOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$lastOrNull$1.label;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a3 A[Catch: all -> 0x00c8, TryCatch #1 {all -> 0x00c8, blocks: (B:75:0x009b, B:77:0x00a3, B:79:0x00b3, B:71:0x007c, B:81:0x00ba), top: B:94:0x009b }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ba A[Catch: all -> 0x00c8, TRY_LEAVE, TryCatch #1 {all -> 0x00c8, blocks: (B:75:0x009b, B:77:0x00a3, B:79:0x00b3, B:71:0x007c, B:81:0x00ba), top: B:94:0x009b }] */
    /* JADX WARN: Type inference failed for: r15v9, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0095 -> B:94:0x009b). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object lastOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$lastOrNull$3 channelsKt__Channels_commonKt$lastOrNull$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.ObjectRef objectRef;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$lastOrNull$3 channelsKt__Channels_commonKt$lastOrNull$32;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$lastOrNull$3) {
                channelsKt__Channels_commonKt$lastOrNull$3 = (ChannelsKt__Channels_commonKt$lastOrNull$3) continuation;
                if ((channelsKt__Channels_commonKt$lastOrNull$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$lastOrNull$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$lastOrNull$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$lastOrNull$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = null;
                        try {
                            objectRef = objectRef2;
                            obj = coroutine_suspended;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$lastOrNull$32 = channelsKt__Channels_commonKt$lastOrNull$3;
                            receiveChannel2 = receiveChannel5;
                            channelsKt__Channels_commonKt$lastOrNull$32.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$lastOrNull$32.L$1 = function12;
                            channelsKt__Channels_commonKt$lastOrNull$32.L$2 = objectRef;
                            channelsKt__Channels_commonKt$lastOrNull$32.L$3 = receiveChannel3;
                            channelsKt__Channels_commonKt$lastOrNull$32.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$lastOrNull$32.L$5 = th2;
                            channelsKt__Channels_commonKt$lastOrNull$32.L$6 = receiveChannel4;
                            channelsKt__Channels_commonKt$lastOrNull$32.L$7 = it;
                            channelsKt__Channels_commonKt$lastOrNull$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$lastOrNull$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$lastOrNull$3.L$7;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$3.L$6;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$lastOrNull$3.L$5;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$3.L$4;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$3.L$3;
                        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$lastOrNull$3.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$lastOrNull$3.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$lastOrNull$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Ref.ObjectRef objectRef4 = objectRef3;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$lastOrNull$32 = channelsKt__Channels_commonKt$lastOrNull$3;
                            receiveChannel2 = receiveChannel7;
                            Throwable th5 = th4;
                            function12 = function13;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    ?? r15 = (Object) channelIterator2.next();
                                    if (function12.invoke(r15).booleanValue()) {
                                        objectRef4.element = r15;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    objectRef = objectRef4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$lastOrNull$32.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$lastOrNull$32.L$1 = function12;
                                    channelsKt__Channels_commonKt$lastOrNull$32.L$2 = objectRef;
                                    channelsKt__Channels_commonKt$lastOrNull$32.L$3 = receiveChannel3;
                                    channelsKt__Channels_commonKt$lastOrNull$32.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$lastOrNull$32.L$5 = th2;
                                    channelsKt__Channels_commonKt$lastOrNull$32.L$6 = receiveChannel4;
                                    channelsKt__Channels_commonKt$lastOrNull$32.L$7 = it;
                                    channelsKt__Channels_commonKt$lastOrNull$32.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$lastOrNull$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    objectRef4 = objectRef;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(1);
                                        return objectRef4.element;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$lastOrNull$3 = new ChannelsKt__Channels_commonKt$lastOrNull$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$lastOrNull$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$lastOrNull$3.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [592=4] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0097 A[Catch: all -> 0x0068, TRY_LEAVE, TryCatch #2 {all -> 0x0068, blocks: (B:76:0x0064, B:85:0x008f, B:87:0x0097, B:97:0x00cb, B:98:0x00d4), top: B:109:0x0064 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c1 A[Catch: all -> 0x0044, TRY_ENTER, TryCatch #0 {all -> 0x0044, blocks: (B:69:0x003f, B:91:0x00b5, B:95:0x00c1, B:96:0x00ca), top: B:105:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00cb A[Catch: all -> 0x0068, TRY_ENTER, TryCatch #2 {all -> 0x0068, blocks: (B:76:0x0064, B:85:0x008f, B:87:0x0097, B:97:0x00cb, B:98:0x00d4), top: B:109:0x0064 }] */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$single$1 channelsKt__Channels_commonKt$single$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th2;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel5;
        Object obj2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$single$1) {
            channelsKt__Channels_commonKt$single$1 = (ChannelsKt__Channels_commonKt$single$1) continuation;
            if ((channelsKt__Channels_commonKt$single$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$single$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$single$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$single$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th4 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$single$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$2 = th4;
                        channelsKt__Channels_commonKt$single$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$single$1.L$4 = it;
                        channelsKt__Channels_commonKt$single$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__Channels_commonKt$single$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        channelIterator = it;
                        receiveChannel4 = receiveChannel3;
                        th2 = th4;
                        obj = hasNext;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        obj2 = channelsKt__Channels_commonKt$single$1.L$5;
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$single$1.L$4;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$3;
                        th3 = (Throwable) channelsKt__Channels_commonKt$single$1.L$2;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$1;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (!((Boolean) obj).booleanValue()) {
                                throw new IllegalArgumentException("ReceiveChannel has more than one element.");
                            }
                            ChannelsKt.cancelConsumed(receiveChannel5, th3);
                            return obj2;
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = receiveChannel5;
                            try {
                                throw th;
                            } catch (Throwable th7) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th7;
                            }
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$single$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$single$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$single$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th8) {
                        th = th8;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new NoSuchElementException("ReceiveChannel is empty.");
                }
                Object next = channelIterator.next();
                channelsKt__Channels_commonKt$single$1.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$single$1.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$single$1.L$2 = th2;
                channelsKt__Channels_commonKt$single$1.L$3 = receiveChannel4;
                channelsKt__Channels_commonKt$single$1.L$4 = channelIterator;
                channelsKt__Channels_commonKt$single$1.L$5 = next;
                channelsKt__Channels_commonKt$single$1.label = 2;
                Object hasNext2 = channelIterator.hasNext(channelsKt__Channels_commonKt$single$1);
                if (hasNext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                th3 = th2;
                receiveChannel5 = receiveChannel2;
                obj = hasNext2;
                obj2 = next;
                if (!((Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__Channels_commonKt$single$1 = new ChannelsKt__Channels_commonKt$single$1(continuation);
        obj = channelsKt__Channels_commonKt$single$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$single$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:67:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00a3 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b3 A[Catch: all -> 0x00f8, TryCatch #0 {all -> 0x00f8, blocks: (B:82:0x00ab, B:84:0x00b3, B:86:0x00c3, B:88:0x00c7, B:89:0x00cc, B:90:0x00d5, B:78:0x0089, B:92:0x00dc), top: B:107:0x00ab }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00dc A[Catch: all -> 0x00f8, TRY_LEAVE, TryCatch #0 {all -> 0x00f8, blocks: (B:82:0x00ab, B:84:0x00b3, B:86:0x00c3, B:88:0x00c7, B:89:0x00cc, B:90:0x00d5, B:78:0x0089, B:92:0x00dc), top: B:107:0x00ab }] */
    /* JADX WARN: Type inference failed for: r15v9, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:81:0x00a4 -> B:107:0x00ab). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object single(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$single$3 channelsKt__Channels_commonKt$single$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.ObjectRef objectRef;
        Throwable th2;
        Ref.BooleanRef booleanRef;
        ReceiveChannel<? extends E> receiveChannel3;
        Function1<? super E, Boolean> function12;
        ChannelsKt__Channels_commonKt$single$3 channelsKt__Channels_commonKt$single$32;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$single$3) {
                channelsKt__Channels_commonKt$single$3 = (ChannelsKt__Channels_commonKt$single$3) continuation;
                if ((channelsKt__Channels_commonKt$single$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$single$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$single$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$single$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                        objectRef2.element = null;
                        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                        booleanRef2.element = false;
                        try {
                            objectRef = objectRef2;
                            th2 = null;
                            booleanRef = booleanRef2;
                            receiveChannel3 = receiveChannel;
                            function12 = function1;
                            channelsKt__Channels_commonKt$single$32 = channelsKt__Channels_commonKt$single$3;
                            receiveChannel4 = receiveChannel3;
                            receiveChannel2 = receiveChannel4;
                            it = receiveChannel.iterator();
                            obj = coroutine_suspended;
                            receiveChannel5 = receiveChannel2;
                            channelsKt__Channels_commonKt$single$32.L$0 = receiveChannel4;
                            channelsKt__Channels_commonKt$single$32.L$1 = function12;
                            channelsKt__Channels_commonKt$single$32.L$2 = objectRef;
                            channelsKt__Channels_commonKt$single$32.L$3 = booleanRef;
                            channelsKt__Channels_commonKt$single$32.L$4 = receiveChannel3;
                            channelsKt__Channels_commonKt$single$32.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$single$32.L$6 = th2;
                            channelsKt__Channels_commonKt$single$32.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$single$32.L$8 = it;
                            channelsKt__Channels_commonKt$single$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$single$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$single$3.L$8;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$single$3.L$7;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$single$3.L$6;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$single$3.L$5;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$single$3.L$4;
                        Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) channelsKt__Channels_commonKt$single$3.L$3;
                        Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$single$3.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$single$3.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$single$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel5 = receiveChannel6;
                            receiveChannel4 = receiveChannel9;
                            Ref.ObjectRef objectRef4 = objectRef3;
                            Throwable th5 = th4;
                            function12 = function13;
                            Ref.BooleanRef booleanRef4 = booleanRef3;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$single$32 = channelsKt__Channels_commonKt$single$3;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    ?? r15 = (Object) channelIterator2.next();
                                    if (function12.invoke(r15).booleanValue()) {
                                        if (booleanRef4.element) {
                                            throw new IllegalArgumentException("ReceiveChannel contains more than one matching element.");
                                        }
                                        objectRef4.element = r15;
                                        booleanRef4.element = true;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    booleanRef = booleanRef4;
                                    objectRef = objectRef4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$single$32.L$0 = receiveChannel4;
                                    channelsKt__Channels_commonKt$single$32.L$1 = function12;
                                    channelsKt__Channels_commonKt$single$32.L$2 = objectRef;
                                    channelsKt__Channels_commonKt$single$32.L$3 = booleanRef;
                                    channelsKt__Channels_commonKt$single$32.L$4 = receiveChannel3;
                                    channelsKt__Channels_commonKt$single$32.L$5 = receiveChannel2;
                                    channelsKt__Channels_commonKt$single$32.L$6 = th2;
                                    channelsKt__Channels_commonKt$single$32.L$7 = receiveChannel5;
                                    channelsKt__Channels_commonKt$single$32.L$8 = it;
                                    channelsKt__Channels_commonKt$single$32.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$single$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    objectRef4 = objectRef;
                                    booleanRef4 = booleanRef;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(1);
                                        if (!booleanRef4.element) {
                                            throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                                        }
                                        return objectRef4.element;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$single$3 = new ChannelsKt__Channels_commonKt$single$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$single$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$single$3.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [644=4, 2582=4] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x009c A[Catch: all -> 0x0069, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x0069, blocks: (B:77:0x0065, B:86:0x0090, B:90:0x009c), top: B:108:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00c6  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$singleOrNull$1 channelsKt__Channels_commonKt$singleOrNull$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th2;
        Throwable th3;
        ReceiveChannel<? extends E> receiveChannel5;
        Object obj2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$singleOrNull$1) {
            channelsKt__Channels_commonKt$singleOrNull$1 = (ChannelsKt__Channels_commonKt$singleOrNull$1) continuation;
            if ((channelsKt__Channels_commonKt$singleOrNull$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$singleOrNull$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$singleOrNull$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$singleOrNull$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    Throwable th4 = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$singleOrNull$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$2 = th4;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$singleOrNull$1.L$4 = it;
                        channelsKt__Channels_commonKt$singleOrNull$1.label = 1;
                        Object hasNext = it.hasNext(channelsKt__Channels_commonKt$singleOrNull$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        channelIterator = it;
                        receiveChannel4 = receiveChannel3;
                        th2 = th4;
                        obj = hasNext;
                    } catch (Throwable th5) {
                        receiveChannel2 = receiveChannel;
                        th = th5;
                        throw th;
                    }
                } else if (i != 1) {
                    if (i == 2) {
                        obj2 = channelsKt__Channels_commonKt$singleOrNull$1.L$5;
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$1.L$4;
                        ReceiveChannel receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$3;
                        th3 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$1.L$2;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$1;
                        ReceiveChannel receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            if (((Boolean) obj).booleanValue()) {
                                ChannelsKt.cancelConsumed(receiveChannel5, th3);
                                return obj2;
                            }
                            ChannelsKt.cancelConsumed(receiveChannel5, th3);
                            return null;
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = receiveChannel5;
                            try {
                                throw th;
                            } catch (Throwable th7) {
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                throw th7;
                            }
                        }
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$1.L$4;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$3;
                    th2 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$1;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th8) {
                        th = th8;
                        throw th;
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    ChannelsKt.cancelConsumed(receiveChannel2, th2);
                    return null;
                }
                Object next = channelIterator.next();
                channelsKt__Channels_commonKt$singleOrNull$1.L$0 = receiveChannel3;
                channelsKt__Channels_commonKt$singleOrNull$1.L$1 = receiveChannel2;
                channelsKt__Channels_commonKt$singleOrNull$1.L$2 = th2;
                channelsKt__Channels_commonKt$singleOrNull$1.L$3 = receiveChannel4;
                channelsKt__Channels_commonKt$singleOrNull$1.L$4 = channelIterator;
                channelsKt__Channels_commonKt$singleOrNull$1.L$5 = next;
                channelsKt__Channels_commonKt$singleOrNull$1.label = 2;
                Object hasNext2 = channelIterator.hasNext(channelsKt__Channels_commonKt$singleOrNull$1);
                if (hasNext2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                th3 = th2;
                receiveChannel5 = receiveChannel2;
                obj = hasNext2;
                obj2 = next;
                if (((Boolean) obj).booleanValue()) {
                }
            }
        }
        channelsKt__Channels_commonKt$singleOrNull$1 = new ChannelsKt__Channels_commonKt$singleOrNull$1(continuation);
        obj = channelsKt__Channels_commonKt$singleOrNull$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$singleOrNull$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ac A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00b8 A[Catch: all -> 0x00f0, TryCatch #0 {all -> 0x00f0, blocks: (B:83:0x00b0, B:85:0x00b8, B:87:0x00c8, B:91:0x00d7, B:79:0x0092, B:93:0x00dd), top: B:108:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00dd A[Catch: all -> 0x00f0, TRY_LEAVE, TryCatch #0 {all -> 0x00f0, blocks: (B:83:0x00b0, B:85:0x00b8, B:87:0x00c8, B:91:0x00d7, B:79:0x0092, B:93:0x00dd), top: B:108:0x00b0 }] */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:82:0x00ad -> B:108:0x00b0). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object singleOrNull(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$singleOrNull$3 channelsKt__Channels_commonKt$singleOrNull$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Ref.ObjectRef objectRef;
        Object obj;
        Ref.BooleanRef booleanRef;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, Boolean> function12;
        ChannelsKt__Channels_commonKt$singleOrNull$3 channelsKt__Channels_commonKt$singleOrNull$32;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        Object hasNext;
        ChannelIterator<? extends E> channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$singleOrNull$3) {
            channelsKt__Channels_commonKt$singleOrNull$3 = (ChannelsKt__Channels_commonKt$singleOrNull$3) continuation;
            if ((channelsKt__Channels_commonKt$singleOrNull$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$singleOrNull$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$singleOrNull$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$singleOrNull$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = null;
                    Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
                    booleanRef2.element = false;
                    try {
                        objectRef = objectRef2;
                        obj = coroutine_suspended;
                        booleanRef = booleanRef2;
                        th = null;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel2 = receiveChannel3;
                        receiveChannel4 = receiveChannel2;
                        function12 = function1;
                        channelsKt__Channels_commonKt$singleOrNull$32 = channelsKt__Channels_commonKt$singleOrNull$3;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$1 = function12;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$2 = objectRef;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$3 = booleanRef;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$4 = receiveChannel5;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$6 = th;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$7 = receiveChannel4;
                        channelsKt__Channels_commonKt$singleOrNull$32.L$8 = it;
                        channelsKt__Channels_commonKt$singleOrNull$32.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$singleOrNull$32);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$singleOrNull$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$3.L$7;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$singleOrNull$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$3.L$4;
                    Ref.BooleanRef booleanRef3 = (Ref.BooleanRef) channelsKt__Channels_commonKt$singleOrNull$3.L$3;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$singleOrNull$3.L$2;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$singleOrNull$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$singleOrNull$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$singleOrNull$32 = channelsKt__Channels_commonKt$singleOrNull$3;
                        receiveChannel5 = receiveChannel8;
                        channelIterator = channelIterator2;
                        receiveChannel4 = receiveChannel6;
                        function12 = function13;
                        objectRef = objectRef3;
                        booleanRef = booleanRef3;
                        th = th4;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel7;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th2;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                    try {
                        if (!((Boolean) obj2).booleanValue()) {
                            ?? r0 = (Object) channelIterator.next();
                            if (function12.invoke(r0).booleanValue()) {
                                if (!booleanRef.element) {
                                    objectRef.element = r0;
                                    booleanRef.element = true;
                                } else {
                                    InlineMarker.finallyStart(2);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(2);
                                    return null;
                                }
                            }
                            receiveChannel3 = receiveChannel9;
                            it = channelIterator;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$1 = function12;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$2 = objectRef;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$3 = booleanRef;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$4 = receiveChannel5;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$6 = th;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$7 = receiveChannel4;
                            channelsKt__Channels_commonKt$singleOrNull$32.L$8 = it;
                            channelsKt__Channels_commonKt$singleOrNull$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$singleOrNull$32);
                            if (hasNext != obj) {
                                return obj;
                            }
                            receiveChannel9 = receiveChannel3;
                            obj2 = hasNext;
                            channelIterator = it;
                            if (!((Boolean) obj2).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                InlineMarker.finallyEnd(1);
                                if (booleanRef.element) {
                                    return objectRef.element;
                                }
                                return null;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        th2 = th;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$singleOrNull$3 = new ChannelsKt__Channels_commonKt$singleOrNull$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$singleOrNull$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$singleOrNull$3.label;
        if (i != 0) {
        }
    }

    public static /* synthetic */ ReceiveChannel drop$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.drop(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> drop(ReceiveChannel<? extends E> drop, int i, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(drop, "$this$drop");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(drop), new ChannelsKt__Channels_commonKt$drop$1(drop, i, null), 2, null);
    }

    public static /* synthetic */ ReceiveChannel dropWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.dropWhile(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> dropWhile(ReceiveChannel<? extends E> dropWhile, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(dropWhile, "$this$dropWhile");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(dropWhile), new ChannelsKt__Channels_commonKt$dropWhile$1(dropWhile, predicate, null), 2, null);
    }

    public static /* synthetic */ ReceiveChannel filter$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filter(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> filter(ReceiveChannel<? extends E> filter, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(filter, "$this$filter");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(filter), new ChannelsKt__Channels_commonKt$filter$1(filter, predicate, null), 2, null);
    }

    public static /* synthetic */ ReceiveChannel filterIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> filterIndexed(ReceiveChannel<? extends E> filterIndexed, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(filterIndexed, "$this$filterIndexed");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(filterIndexed), new ChannelsKt__Channels_commonKt$filterIndexed$1(filterIndexed, predicate, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b9 A[Catch: all -> 0x00f3, TryCatch #1 {all -> 0x00f3, blocks: (B:76:0x00b1, B:78:0x00b9, B:80:0x00e0, B:72:0x008f, B:82:0x00e6), top: B:96:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6 A[Catch: all -> 0x00f3, TRY_LEAVE, TryCatch #1 {all -> 0x00f3, blocks: (B:76:0x00b1, B:78:0x00b9, B:80:0x00e0, B:72:0x008f, B:82:0x00e6), top: B:96:0x00b1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00ac -> B:96:0x00b1). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, Boolean> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterIndexedTo$1 channelsKt__Channels_commonKt$filterIndexedTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Collection collection;
        Function2<? super Integer, ? super E, Boolean> function22;
        Ref.IntRef intRef;
        ChannelsKt__Channels_commonKt$filterIndexedTo$1 channelsKt__Channels_commonKt$filterIndexedTo$12;
        Object obj;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterIndexedTo$1) {
            channelsKt__Channels_commonKt$filterIndexedTo$1 = (ChannelsKt__Channels_commonKt$filterIndexedTo$1) continuation;
            if ((channelsKt__Channels_commonKt$filterIndexedTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterIndexedTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$filterIndexedTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterIndexedTo$1.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        collection = c;
                        function22 = function2;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$filterIndexedTo$12 = channelsKt__Channels_commonKt$filterIndexedTo$1;
                        obj = coroutine_suspended;
                        th = null;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel5 = receiveChannel4;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel6 = receiveChannel2;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$1 = collection;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$2 = function22;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$3 = receiveChannel4;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$4 = intRef;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$5 = receiveChannel5;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$6 = receiveChannel2;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$7 = th;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$8 = receiveChannel6;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.L$9 = it;
                        channelsKt__Channels_commonKt$filterIndexedTo$12.label = i2;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterIndexedTo$1.L$9;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$8;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$filterIndexedTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$5;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$filterIndexedTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$3;
                    Function2<? super Integer, ? super E, Boolean> function23 = (Function2) channelsKt__Channels_commonKt$filterIndexedTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$filterIndexedTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$filterIndexedTo$12 = channelsKt__Channels_commonKt$filterIndexedTo$1;
                        receiveChannel4 = receiveChannel9;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        receiveChannel2 = receiveChannel7;
                        function22 = function23;
                        th = th4;
                        collection = collection2;
                        intRef = intRef3;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel8;
                        try {
                            if (!((Boolean) obj2).booleanValue()) {
                                E next = channelIterator2.next();
                                int i3 = intRef.element;
                                intRef.element = i3 + 1;
                                IndexedValue indexedValue = new IndexedValue(i3, next);
                                int component1 = indexedValue.component1();
                                Object obj3 = (Object) indexedValue.component2();
                                if (function22.invoke(Boxing.boxInt(component1), obj3).booleanValue()) {
                                    collection.add(obj3);
                                }
                                receiveChannel3 = receiveChannel10;
                                i2 = 1;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$1 = collection;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$2 = function22;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$3 = receiveChannel4;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$4 = intRef;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$5 = receiveChannel5;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$6 = receiveChannel2;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$7 = th;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$8 = receiveChannel6;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.L$9 = it;
                                channelsKt__Channels_commonKt$filterIndexedTo$12.label = i2;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel10 = receiveChannel3;
                                obj2 = hasNext;
                                collection = collection;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    return collection;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            try {
                                throw th2;
                            } finally {
                                int i4 = 1;
                                InlineMarker.finallyStart(i4);
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                InlineMarker.finallyEnd(i4);
                            }
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        receiveChannel2 = receiveChannel7;
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$filterIndexedTo$1 = new ChannelsKt__Channels_commonKt$filterIndexedTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$filterIndexedTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterIndexedTo$1.label;
        int i22 = 1;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00a2: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:80:0x00a1 */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fe A[Catch: all -> 0x0189, TryCatch #2 {all -> 0x0189, blocks: (B:84:0x00c6, B:88:0x00f6, B:90:0x00fe, B:92:0x0127, B:99:0x017c), top: B:114:0x00c6 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017c A[Catch: all -> 0x0189, TRY_LEAVE, TryCatch #2 {all -> 0x0189, blocks: (B:84:0x00c6, B:88:0x00f6, B:90:0x00fe, B:92:0x0127, B:99:0x017c), top: B:114:0x00c6 }] */
    /* JADX WARN: Type inference failed for: r13v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0177 -> B:114:0x00c6). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object filterIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, Boolean> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterIndexedTo$3 channelsKt__Channels_commonKt$filterIndexedTo$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Ref.IntRef intRef;
        ReceiveChannel<? extends E> receiveChannel6;
        Function2<? super Integer, ? super E, Boolean> function22;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator;
        C c2;
        Throwable th3;
        Throwable th4;
        Object obj;
        ChannelsKt__Channels_commonKt$filterIndexedTo$3 channelsKt__Channels_commonKt$filterIndexedTo$32;
        Ref.IntRef intRef2;
        Function2<? super Integer, ? super E, Boolean> function23;
        C c3;
        ReceiveChannel<? extends E> receiveChannel8;
        ReceiveChannel<? extends E> receiveChannel9;
        ReceiveChannel<? extends E> receiveChannel10;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterIndexedTo$3) {
            channelsKt__Channels_commonKt$filterIndexedTo$3 = (ChannelsKt__Channels_commonKt$filterIndexedTo$3) continuation;
            if ((channelsKt__Channels_commonKt$filterIndexedTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterIndexedTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$filterIndexedTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterIndexedTo$3.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        c3 = c;
                        function23 = function2;
                        intRef2 = intRef3;
                        channelsKt__Channels_commonKt$filterIndexedTo$32 = channelsKt__Channels_commonKt$filterIndexedTo$3;
                        obj = coroutine_suspended;
                        th4 = null;
                        channelIterator = receiveChannel.iterator();
                        receiveChannel10 = receiveChannel;
                        receiveChannel9 = receiveChannel10;
                        receiveChannel8 = receiveChannel9;
                        receiveChannel3 = receiveChannel8;
                        receiveChannel4 = receiveChannel3;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$0 = receiveChannel10;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$1 = c3;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$2 = function23;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$3 = receiveChannel9;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$4 = intRef2;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$5 = receiveChannel8;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$7 = th4;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$8 = receiveChannel4;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$9 = channelIterator;
                        channelsKt__Channels_commonKt$filterIndexedTo$32.label = i2;
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$32);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th5) {
                        th3 = th5;
                        receiveChannel3 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else {
                    try {
                        if (i == 1) {
                            ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$filterIndexedTo$3.L$9;
                            receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$8;
                            th2 = (Throwable) channelsKt__Channels_commonKt$filterIndexedTo$3.L$7;
                            ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$6;
                            receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$5;
                            intRef = (Ref.IntRef) channelsKt__Channels_commonKt$filterIndexedTo$3.L$4;
                            receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$3;
                            function22 = (Function2) channelsKt__Channels_commonKt$filterIndexedTo$3.L$2;
                            ?? r13 = (SendChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$1;
                            receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$0;
                            ResultKt.throwOnFailure(obj2);
                            channelIterator = channelIterator2;
                            receiveChannel3 = receiveChannel11;
                            c2 = r13;
                            if (!((Boolean) obj2).booleanValue()) {
                            }
                        } else if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            Object obj3 = channelsKt__Channels_commonKt$filterIndexedTo$3.L$13;
                            int i3 = channelsKt__Channels_commonKt$filterIndexedTo$3.I$0;
                            IndexedValue indexedValue = (IndexedValue) channelsKt__Channels_commonKt$filterIndexedTo$3.L$12;
                            Object obj4 = channelsKt__Channels_commonKt$filterIndexedTo$3.L$11;
                            Object obj5 = channelsKt__Channels_commonKt$filterIndexedTo$3.L$10;
                            ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$filterIndexedTo$3.L$9;
                            receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$8;
                            th2 = (Throwable) channelsKt__Channels_commonKt$filterIndexedTo$3.L$7;
                            ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$6;
                            receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$5;
                            intRef = (Ref.IntRef) channelsKt__Channels_commonKt$filterIndexedTo$3.L$4;
                            receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$3;
                            function22 = (Function2) channelsKt__Channels_commonKt$filterIndexedTo$3.L$2;
                            Object obj6 = (SendChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$1;
                            receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterIndexedTo$3.L$0;
                            ResultKt.throwOnFailure(obj2);
                            char c4 = 2;
                            try {
                                Ref.IntRef intRef4 = intRef;
                                channelsKt__Channels_commonKt$filterIndexedTo$32 = channelsKt__Channels_commonKt$filterIndexedTo$3;
                                receiveChannel9 = receiveChannel6;
                                obj = coroutine_suspended;
                                receiveChannel8 = receiveChannel5;
                                intRef2 = intRef4;
                                C c5 = obj6;
                                channelIterator = channelIterator3;
                                receiveChannel3 = receiveChannel12;
                                function23 = function22;
                                th4 = th2;
                                c3 = c5;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$0 = receiveChannel10;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$1 = c3;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$2 = function23;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$3 = receiveChannel9;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$4 = intRef2;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$5 = receiveChannel8;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$7 = th4;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$8 = receiveChannel4;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.L$9 = channelIterator;
                                channelsKt__Channels_commonKt$filterIndexedTo$32.label = i2;
                                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$32);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel7 = receiveChannel10;
                                obj2 = hasNext;
                                Object obj7 = obj;
                                receiveChannel6 = receiveChannel9;
                                channelsKt__Channels_commonKt$filterIndexedTo$3 = channelsKt__Channels_commonKt$filterIndexedTo$32;
                                intRef = intRef2;
                                receiveChannel5 = receiveChannel8;
                                coroutine_suspended = obj7;
                                Function2<? super Integer, ? super E, Boolean> function24 = function23;
                                c2 = c3;
                                th2 = th4;
                                function22 = function24;
                                if (!((Boolean) obj2).booleanValue()) {
                                    E next = channelIterator.next();
                                    int i4 = intRef.element;
                                    intRef.element = i4 + 1;
                                    IndexedValue indexedValue2 = new IndexedValue(i4, next);
                                    int component1 = indexedValue2.component1();
                                    Object obj8 = (Object) indexedValue2.component2();
                                    Object obj9 = coroutine_suspended;
                                    if (function22.invoke(Boxing.boxInt(component1), obj8).booleanValue()) {
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$0 = receiveChannel7;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$1 = c2;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$2 = function22;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$3 = receiveChannel6;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$4 = intRef;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$5 = receiveChannel5;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$6 = receiveChannel3;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$7 = th2;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$8 = receiveChannel4;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$9 = channelIterator;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$10 = next;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$11 = next;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$12 = indexedValue2;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.I$0 = component1;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.L$13 = obj8;
                                        c4 = 2;
                                        channelsKt__Channels_commonKt$filterIndexedTo$3.label = 2;
                                        if (c2.send(obj8, channelsKt__Channels_commonKt$filterIndexedTo$3) == obj9) {
                                            return obj9;
                                        }
                                        coroutine_suspended = obj9;
                                        Object obj10 = c2;
                                        receiveChannel12 = receiveChannel3;
                                        channelIterator3 = channelIterator;
                                        obj6 = obj10;
                                        Ref.IntRef intRef42 = intRef;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32 = channelsKt__Channels_commonKt$filterIndexedTo$3;
                                        receiveChannel9 = receiveChannel6;
                                        obj = coroutine_suspended;
                                        receiveChannel8 = receiveChannel5;
                                        intRef2 = intRef42;
                                        C c52 = obj6;
                                        channelIterator = channelIterator3;
                                        receiveChannel3 = receiveChannel12;
                                        function23 = function22;
                                        th4 = th2;
                                        c3 = c52;
                                        receiveChannel10 = receiveChannel7;
                                        i2 = 1;
                                        channelIterator = channelIterator;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$0 = receiveChannel10;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$1 = c3;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$2 = function23;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$3 = receiveChannel9;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$4 = intRef2;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$5 = receiveChannel8;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$6 = receiveChannel3;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$7 = th4;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$8 = receiveChannel4;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$9 = channelIterator;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.label = i2;
                                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$32);
                                        if (hasNext != obj) {
                                        }
                                    } else {
                                        c4 = 2;
                                        receiveChannel8 = receiveChannel5;
                                        intRef2 = intRef;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32 = channelsKt__Channels_commonKt$filterIndexedTo$3;
                                        receiveChannel9 = receiveChannel6;
                                        obj = obj9;
                                        Function2<? super Integer, ? super E, Boolean> function25 = function22;
                                        th4 = th2;
                                        c3 = c2;
                                        function23 = function25;
                                        receiveChannel10 = receiveChannel7;
                                        i2 = 1;
                                        channelIterator = channelIterator;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$0 = receiveChannel10;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$1 = c3;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$2 = function23;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$3 = receiveChannel9;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$4 = intRef2;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$5 = receiveChannel8;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$6 = receiveChannel3;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$7 = th4;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$8 = receiveChannel4;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.L$9 = channelIterator;
                                        channelsKt__Channels_commonKt$filterIndexedTo$32.label = i2;
                                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$filterIndexedTo$32);
                                        if (hasNext != obj) {
                                        }
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    return c2;
                                }
                            } catch (Throwable th6) {
                                th3 = th6;
                                th = th3;
                                try {
                                    throw th;
                                } finally {
                                    int i5 = 1;
                                    InlineMarker.finallyStart(i5);
                                    ChannelsKt.cancelConsumed(receiveChannel3, th);
                                    InlineMarker.finallyEnd(i5);
                                }
                            }
                            receiveChannel10 = receiveChannel7;
                            i2 = 1;
                            channelIterator = channelIterator;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel3 = receiveChannel2;
                        throw th;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$filterIndexedTo$3 = new ChannelsKt__Channels_commonKt$filterIndexedTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$filterIndexedTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterIndexedTo$3.label;
        int i22 = 1;
        if (i != 0) {
        }
    }

    public static /* synthetic */ ReceiveChannel filterNot$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.filterNot(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> filterNot(ReceiveChannel<? extends E> filterNot, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(filterNot, "$this$filterNot");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return ChannelsKt.filter(filterNot, context, new ChannelsKt__Channels_commonKt$filterNot$1(predicate, null));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> filterNotNull(ReceiveChannel<? extends E> filterNotNull) {
        ReceiveChannel<E> filter$default;
        Intrinsics.checkParameterIsNotNull(filterNotNull, "$this$filterNotNull");
        filter$default = filter$default(filterNotNull, null, new ChannelsKt__Channels_commonKt$filterNotNull$1(null), 1, null);
        if (filter$default != null) {
            return filter$default;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveChannel<E>");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0092 A[Catch: all -> 0x00a5, TryCatch #0 {all -> 0x00a5, blocks: (B:75:0x008a, B:77:0x0092, B:79:0x0098, B:71:0x006e, B:81:0x009f), top: B:92:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x009f A[Catch: all -> 0x00a5, TRY_LEAVE, TryCatch #0 {all -> 0x00a5, blocks: (B:75:0x008a, B:77:0x0092, B:79:0x0098, B:71:0x006e, B:81:0x009f), top: B:92:0x008a }] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0085 -> B:92:0x008a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotNullTo$1 channelsKt__Channels_commonKt$filterNotNullTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$filterNotNullTo$1 channelsKt__Channels_commonKt$filterNotNullTo$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        C c2;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotNullTo$1) {
                channelsKt__Channels_commonKt$filterNotNullTo$1 = (ChannelsKt__Channels_commonKt$filterNotNullTo$1) continuation;
                if ((channelsKt__Channels_commonKt$filterNotNullTo$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$filterNotNullTo$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$filterNotNullTo$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$filterNotNullTo$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            th2 = null;
                            channelsKt__Channels_commonKt$filterNotNullTo$12 = channelsKt__Channels_commonKt$filterNotNullTo$1;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            c2 = c;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$filterNotNullTo$12.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$filterNotNullTo$12.L$1 = c2;
                            channelsKt__Channels_commonKt$filterNotNullTo$12.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$filterNotNullTo$12.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterNotNullTo$12.L$4 = th2;
                            channelsKt__Channels_commonKt$filterNotNullTo$12.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$filterNotNullTo$12.L$6 = it;
                            channelsKt__Channels_commonKt$filterNotNullTo$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$2;
                        ?? r6 = (Collection) channelsKt__Channels_commonKt$filterNotNullTo$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Throwable th5 = th4;
                            c2 = r6;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$filterNotNullTo$12 = channelsKt__Channels_commonKt$filterNotNullTo$1;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    return c2;
                                }
                                E next = channelIterator2.next();
                                if (next != null) {
                                    c2.add(next);
                                }
                                receiveChannel3 = receiveChannel8;
                                obj = obj3;
                                th2 = th5;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$filterNotNullTo$12.L$0 = receiveChannel5;
                                channelsKt__Channels_commonKt$filterNotNullTo$12.L$1 = c2;
                                channelsKt__Channels_commonKt$filterNotNullTo$12.L$2 = receiveChannel3;
                                channelsKt__Channels_commonKt$filterNotNullTo$12.L$3 = receiveChannel2;
                                channelsKt__Channels_commonKt$filterNotNullTo$12.L$4 = th2;
                                channelsKt__Channels_commonKt$filterNotNullTo$12.L$5 = receiveChannel4;
                                channelsKt__Channels_commonKt$filterNotNullTo$12.L$6 = it;
                                channelsKt__Channels_commonKt$filterNotNullTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Object obj4 = obj;
                                receiveChannel8 = receiveChannel3;
                                obj2 = hasNext;
                                th5 = th2;
                                obj3 = obj4;
                                c2 = c2;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th8;
        }
        channelsKt__Channels_commonKt$filterNotNullTo$1 = new ChannelsKt__Channels_commonKt$filterNotNullTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$filterNotNullTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterNotNullTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x007b: MOVE  (r12 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:78:0x007b */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00b7 A[Catch: all -> 0x00f2, TryCatch #0 {all -> 0x00f2, blocks: (B:82:0x0090, B:86:0x00af, B:88:0x00b7, B:90:0x00bd, B:96:0x00ec), top: B:107:0x0090 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00ec A[Catch: all -> 0x00f2, TRY_LEAVE, TryCatch #0 {all -> 0x00f2, blocks: (B:82:0x0090, B:86:0x00af, B:88:0x00b7, B:90:0x00bd, B:96:0x00ec), top: B:107:0x0090 }] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x00da -> B:107:0x0090). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x00e3 -> B:107:0x0090). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object filterNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel5;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$32;
        ReceiveChannel<? extends E> receiveChannel7;
        ReceiveChannel<? extends E> receiveChannel8;
        Object obj2;
        C c2;
        ChannelIterator<? extends E> channelIterator2;
        C c3;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotNullTo$3) {
                channelsKt__Channels_commonKt$filterNotNullTo$3 = (ChannelsKt__Channels_commonKt$filterNotNullTo$3) continuation;
                if ((channelsKt__Channels_commonKt$filterNotNullTo$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$filterNotNullTo$3.label -= Integer.MIN_VALUE;
                    Object obj3 = channelsKt__Channels_commonKt$filterNotNullTo$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$filterNotNullTo$3.label;
                    if (i == 0) {
                        try {
                            if (i == 1) {
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$3.L$6;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$5;
                                th = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$3.L$4;
                                ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$3;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$2;
                                ?? r7 = (SendChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$1;
                                ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$0;
                                ResultKt.throwOnFailure(obj3);
                                obj = obj3;
                                receiveChannel3 = receiveChannel9;
                                receiveChannel6 = receiveChannel10;
                                c3 = r7;
                                if (!((Boolean) obj).booleanValue()) {
                                }
                            } else if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj4 = channelsKt__Channels_commonKt$filterNotNullTo$3.L$8;
                                Object obj5 = channelsKt__Channels_commonKt$filterNotNullTo$3.L$7;
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotNullTo$3.L$6;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$5;
                                th = (Throwable) channelsKt__Channels_commonKt$filterNotNullTo$3.L$4;
                                ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$3;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$2;
                                ?? r72 = (SendChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$1;
                                ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotNullTo$3.L$0;
                                ResultKt.throwOnFailure(obj3);
                                C c4 = r72;
                                receiveChannel3 = receiveChannel11;
                                channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                                receiveChannel7 = receiveChannel4;
                                receiveChannel8 = receiveChannel5;
                                obj2 = coroutine_suspended;
                                c2 = c4;
                                channelIterator2 = channelIterator;
                                receiveChannel = receiveChannel12;
                                try {
                                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel;
                                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = c2;
                                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel8;
                                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel3;
                                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th;
                                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
                                    channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator2;
                                    channelsKt__Channels_commonKt$filterNotNullTo$32.label = 1;
                                    obj = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
                                    if (obj != obj2) {
                                        return obj2;
                                    }
                                    ChannelsKt__Channels_commonKt$filterNotNullTo$3 channelsKt__Channels_commonKt$filterNotNullTo$33 = channelsKt__Channels_commonKt$filterNotNullTo$32;
                                    receiveChannel6 = receiveChannel;
                                    channelIterator = channelIterator2;
                                    c3 = c2;
                                    coroutine_suspended = obj2;
                                    receiveChannel5 = receiveChannel8;
                                    receiveChannel4 = receiveChannel7;
                                    channelsKt__Channels_commonKt$filterNotNullTo$3 = channelsKt__Channels_commonKt$filterNotNullTo$33;
                                    if (!((Boolean) obj).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel3, th);
                                        return c3;
                                    }
                                    E next = channelIterator.next();
                                    if (next != null) {
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$0 = receiveChannel6;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$1 = c3;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$2 = receiveChannel5;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$3 = receiveChannel3;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$4 = th;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$5 = receiveChannel4;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$6 = channelIterator;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$7 = next;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.L$8 = next;
                                        channelsKt__Channels_commonKt$filterNotNullTo$3.label = 2;
                                        if (c3.send(next, channelsKt__Channels_commonKt$filterNotNullTo$3) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        receiveChannel12 = receiveChannel6;
                                        receiveChannel11 = receiveChannel3;
                                        c4 = c3;
                                        receiveChannel3 = receiveChannel11;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                                        receiveChannel7 = receiveChannel4;
                                        receiveChannel8 = receiveChannel5;
                                        obj2 = coroutine_suspended;
                                        c2 = c4;
                                        channelIterator2 = channelIterator;
                                        receiveChannel = receiveChannel12;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = c2;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel8;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel3;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator2;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.label = 1;
                                        obj = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
                                        if (obj != obj2) {
                                        }
                                    } else {
                                        C c5 = c3;
                                        channelIterator2 = channelIterator;
                                        receiveChannel = receiveChannel6;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                                        receiveChannel7 = receiveChannel4;
                                        receiveChannel8 = receiveChannel5;
                                        obj2 = coroutine_suspended;
                                        c2 = c5;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = c2;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel8;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel3;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator2;
                                        channelsKt__Channels_commonKt$filterNotNullTo$32.label = 1;
                                        obj = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
                                        if (obj != obj2) {
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            receiveChannel3 = receiveChannel2;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj3);
                        Throwable th4 = null;
                        try {
                            channelsKt__Channels_commonKt$filterNotNullTo$32 = channelsKt__Channels_commonKt$filterNotNullTo$3;
                            obj2 = coroutine_suspended;
                            channelIterator2 = receiveChannel.iterator();
                            receiveChannel7 = receiveChannel;
                            c2 = c;
                            th = th4;
                            receiveChannel8 = receiveChannel7;
                            receiveChannel3 = receiveChannel8;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$0 = receiveChannel;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$1 = c2;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$2 = receiveChannel8;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$3 = receiveChannel3;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$4 = th;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$5 = receiveChannel7;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.L$6 = channelIterator2;
                            channelsKt__Channels_commonKt$filterNotNullTo$32.label = 1;
                            obj = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotNullTo$32);
                            if (obj != obj2) {
                            }
                        } catch (Throwable th5) {
                            receiveChannel3 = receiveChannel;
                            th = th5;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th6) {
            ChannelsKt.cancelConsumed(receiveChannel3, th);
            throw th6;
        }
        channelsKt__Channels_commonKt$filterNotNullTo$3 = new ChannelsKt__Channels_commonKt$filterNotNullTo$3(continuation);
        Object obj32 = channelsKt__Channels_commonKt$filterNotNullTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterNotNullTo$3.label;
        if (i == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x009a A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:62:0x0046, B:75:0x0092, B:77:0x009a, B:79:0x00aa, B:81:0x00b2), top: B:94:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b2 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:62:0x0046, B:75:0x0092, B:77:0x009a, B:79:0x00aa, B:81:0x00b2), top: B:94:0x0046 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x008c -> B:75:0x0092). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object filterNotTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotTo$1 channelsKt__Channels_commonKt$filterNotTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$filterNotTo$1 channelsKt__Channels_commonKt$filterNotTo$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotTo$1) {
            channelsKt__Channels_commonKt$filterNotTo$1 = (ChannelsKt__Channels_commonKt$filterNotTo$1) continuation;
            if ((channelsKt__Channels_commonKt$filterNotTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterNotTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$filterNotTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterNotTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$filterNotTo$12 = channelsKt__Channels_commonKt$filterNotTo$1;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        collection = c;
                        receiveChannel4 = receiveChannel3;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$filterNotTo$12.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$filterNotTo$12.L$1 = collection;
                        channelsKt__Channels_commonKt$filterNotTo$12.L$2 = function12;
                        channelsKt__Channels_commonKt$filterNotTo$12.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$filterNotTo$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$filterNotTo$12.L$5 = th2;
                        channelsKt__Channels_commonKt$filterNotTo$12.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$filterNotTo$12.L$7 = it;
                        channelsKt__Channels_commonKt$filterNotTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$filterNotTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$filterNotTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$1.L$3;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$filterNotTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$filterNotTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelsKt__Channels_commonKt$filterNotTo$1 channelsKt__Channels_commonKt$filterNotTo$13 = channelsKt__Channels_commonKt$filterNotTo$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel4 = receiveChannel9;
                        Object obj3 = coroutine_suspended;
                        collection = collection2;
                        ChannelsKt__Channels_commonKt$filterNotTo$1 channelsKt__Channels_commonKt$filterNotTo$14 = channelsKt__Channels_commonKt$filterNotTo$13;
                        th2 = th4;
                        receiveChannel5 = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (!((Boolean) obj2).booleanValue()) {
                            try {
                                Object obj4 = (Object) channelIterator2.next();
                                if (!function13.invoke(obj4).booleanValue()) {
                                    collection.add(obj4);
                                }
                                channelsKt__Channels_commonKt$filterNotTo$12.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$filterNotTo$12.L$1 = collection;
                                channelsKt__Channels_commonKt$filterNotTo$12.L$2 = function12;
                                channelsKt__Channels_commonKt$filterNotTo$12.L$3 = receiveChannel5;
                                channelsKt__Channels_commonKt$filterNotTo$12.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$filterNotTo$12.L$5 = th2;
                                channelsKt__Channels_commonKt$filterNotTo$12.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$filterNotTo$12.L$7 = it;
                                channelsKt__Channels_commonKt$filterNotTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$filterNotTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Function1<? super E, Boolean> function14 = function12;
                                receiveChannel7 = receiveChannel2;
                                obj2 = hasNext;
                                obj3 = obj;
                                channelsKt__Channels_commonKt$filterNotTo$14 = channelsKt__Channels_commonKt$filterNotTo$12;
                                function13 = function14;
                                collection = collection;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel7, th2);
                                    InlineMarker.finallyEnd(1);
                                    return collection;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    throw th6;
                                }
                            }
                            receiveChannel2 = receiveChannel7;
                            function12 = function13;
                            channelsKt__Channels_commonKt$filterNotTo$12 = channelsKt__Channels_commonKt$filterNotTo$14;
                            obj = obj3;
                            it = channelIterator2;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$filterNotTo$1 = new ChannelsKt__Channels_commonKt$filterNotTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$filterNotTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterNotTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00c4 A[Catch: all -> 0x0117, TryCatch #1 {all -> 0x0117, blocks: (B:82:0x0098, B:86:0x00bc, B:88:0x00c4, B:90:0x00d4, B:96:0x010b), top: B:108:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010b A[Catch: all -> 0x0117, TRY_LEAVE, TryCatch #1 {all -> 0x0117, blocks: (B:82:0x0098, B:86:0x00bc, B:88:0x00c4, B:90:0x00d4, B:96:0x010b), top: B:108:0x0098 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x00f4 -> B:108:0x0098). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x0101 -> B:108:0x0098). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object filterNotTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterNotTo$3 channelsKt__Channels_commonKt$filterNotTo$3;
        ?? r2;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelsKt__Channels_commonKt$filterNotTo$3 channelsKt__Channels_commonKt$filterNotTo$32;
        C c2;
        ChannelIterator<? extends E> channelIterator2;
        Object obj;
        Function1<? super E, Boolean> function13;
        C c3;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$filterNotTo$3) {
                channelsKt__Channels_commonKt$filterNotTo$3 = (ChannelsKt__Channels_commonKt$filterNotTo$3) continuation;
                if ((channelsKt__Channels_commonKt$filterNotTo$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$filterNotTo$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$filterNotTo$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = channelsKt__Channels_commonKt$filterNotTo$3.label;
                    if (r2 == 0) {
                        try {
                            if (r2 == 1) {
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotTo$3.L$7;
                                receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$6;
                                Throwable th2 = (Throwable) channelsKt__Channels_commonKt$filterNotTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$4;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$3;
                                function12 = (Function1) channelsKt__Channels_commonKt$filterNotTo$3.L$2;
                                ?? r7 = (SendChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$1;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                th = th2;
                                receiveChannel2 = receiveChannel8;
                                c3 = r7;
                                if (!((Boolean) obj2).booleanValue()) {
                                }
                            } else if (r2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj3 = channelsKt__Channels_commonKt$filterNotTo$3.L$9;
                                Object obj4 = channelsKt__Channels_commonKt$filterNotTo$3.L$8;
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterNotTo$3.L$7;
                                receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$6;
                                Throwable th3 = (Throwable) channelsKt__Channels_commonKt$filterNotTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$4;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$3;
                                function12 = (Function1) channelsKt__Channels_commonKt$filterNotTo$3.L$2;
                                ?? r72 = (SendChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$1;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterNotTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                C c4 = r72;
                                receiveChannel6 = receiveChannel3;
                                receiveChannel7 = receiveChannel4;
                                channelsKt__Channels_commonKt$filterNotTo$32 = channelsKt__Channels_commonKt$filterNotTo$3;
                                c2 = c4;
                                channelIterator2 = channelIterator;
                                receiveChannel = receiveChannel5;
                                ReceiveChannel<? extends E> receiveChannel10 = receiveChannel9;
                                th = th3;
                                receiveChannel2 = receiveChannel10;
                                Function1<? super E, Boolean> function14 = function12;
                                obj = coroutine_suspended;
                                function13 = function14;
                                try {
                                    channelsKt__Channels_commonKt$filterNotTo$32.L$0 = receiveChannel;
                                    channelsKt__Channels_commonKt$filterNotTo$32.L$1 = c2;
                                    channelsKt__Channels_commonKt$filterNotTo$32.L$2 = function13;
                                    channelsKt__Channels_commonKt$filterNotTo$32.L$3 = receiveChannel7;
                                    channelsKt__Channels_commonKt$filterNotTo$32.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$filterNotTo$32.L$5 = th;
                                    channelsKt__Channels_commonKt$filterNotTo$32.L$6 = receiveChannel6;
                                    channelsKt__Channels_commonKt$filterNotTo$32.L$7 = channelIterator2;
                                    channelsKt__Channels_commonKt$filterNotTo$32.label = 1;
                                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotTo$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    receiveChannel5 = receiveChannel;
                                    channelIterator = channelIterator2;
                                    c3 = c2;
                                    channelsKt__Channels_commonKt$filterNotTo$3 = channelsKt__Channels_commonKt$filterNotTo$32;
                                    receiveChannel4 = receiveChannel7;
                                    receiveChannel3 = receiveChannel6;
                                    obj2 = hasNext;
                                    Object obj5 = obj;
                                    function12 = function13;
                                    coroutine_suspended = obj5;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        E next = channelIterator.next();
                                        if (function12.invoke(next).booleanValue()) {
                                            receiveChannel6 = receiveChannel3;
                                            receiveChannel7 = receiveChannel4;
                                            channelsKt__Channels_commonKt$filterNotTo$32 = channelsKt__Channels_commonKt$filterNotTo$3;
                                            c2 = c3;
                                            channelIterator2 = channelIterator;
                                            receiveChannel = receiveChannel5;
                                            Function1<? super E, Boolean> function15 = function12;
                                            obj = coroutine_suspended;
                                            function13 = function15;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$0 = receiveChannel;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$1 = c2;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$2 = function13;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$3 = receiveChannel7;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$5 = th;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$6 = receiveChannel6;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$7 = channelIterator2;
                                            channelsKt__Channels_commonKt$filterNotTo$32.label = 1;
                                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotTo$32);
                                            if (hasNext != obj) {
                                            }
                                        } else {
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$0 = receiveChannel5;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$1 = c3;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$2 = function12;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$3 = receiveChannel4;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$5 = th;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$6 = receiveChannel3;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$7 = channelIterator;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$8 = next;
                                            channelsKt__Channels_commonKt$filterNotTo$3.L$9 = next;
                                            channelsKt__Channels_commonKt$filterNotTo$3.label = 2;
                                            if (c3.send(next, channelsKt__Channels_commonKt$filterNotTo$3) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            Throwable th4 = th;
                                            receiveChannel9 = receiveChannel2;
                                            th3 = th4;
                                            c4 = c3;
                                            receiveChannel6 = receiveChannel3;
                                            receiveChannel7 = receiveChannel4;
                                            channelsKt__Channels_commonKt$filterNotTo$32 = channelsKt__Channels_commonKt$filterNotTo$3;
                                            c2 = c4;
                                            channelIterator2 = channelIterator;
                                            receiveChannel = receiveChannel5;
                                            ReceiveChannel<? extends E> receiveChannel102 = receiveChannel9;
                                            th = th3;
                                            receiveChannel2 = receiveChannel102;
                                            Function1<? super E, Boolean> function142 = function12;
                                            obj = coroutine_suspended;
                                            function13 = function142;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$0 = receiveChannel;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$1 = c2;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$2 = function13;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$3 = receiveChannel7;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$5 = th;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$6 = receiveChannel6;
                                            channelsKt__Channels_commonKt$filterNotTo$32.L$7 = channelIterator2;
                                            channelsKt__Channels_commonKt$filterNotTo$32.label = 1;
                                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotTo$32);
                                            if (hasNext != obj) {
                                            }
                                        }
                                    } else {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                                        InlineMarker.finallyEnd(1);
                                        return c3;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = r2;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th7 = null;
                        try {
                            channelsKt__Channels_commonKt$filterNotTo$32 = channelsKt__Channels_commonKt$filterNotTo$3;
                            obj = coroutine_suspended;
                            channelIterator2 = receiveChannel.iterator();
                            c2 = c;
                            function13 = function1;
                            th = th7;
                            receiveChannel7 = receiveChannel;
                            receiveChannel2 = receiveChannel7;
                            receiveChannel6 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$0 = receiveChannel;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$1 = c2;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$2 = function13;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$3 = receiveChannel7;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$5 = th;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$6 = receiveChannel6;
                            channelsKt__Channels_commonKt$filterNotTo$32.L$7 = channelIterator2;
                            channelsKt__Channels_commonKt$filterNotTo$32.label = 1;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterNotTo$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th8) {
                            receiveChannel2 = receiveChannel;
                            th = th8;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th9) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th9;
        }
        channelsKt__Channels_commonKt$filterNotTo$3 = new ChannelsKt__Channels_commonKt$filterNotTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$filterNotTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = channelsKt__Channels_commonKt$filterNotTo$3.label;
        if (r2 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x009a A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:62:0x0046, B:75:0x0092, B:77:0x009a, B:79:0x00aa, B:81:0x00b2), top: B:94:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b2 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:62:0x0046, B:75:0x0092, B:77:0x009a, B:79:0x00aa, B:81:0x00b2), top: B:94:0x0046 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x008c -> B:75:0x0092). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object filterTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterTo$1 channelsKt__Channels_commonKt$filterTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$filterTo$1 channelsKt__Channels_commonKt$filterTo$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$filterTo$1) {
            channelsKt__Channels_commonKt$filterTo$1 = (ChannelsKt__Channels_commonKt$filterTo$1) continuation;
            if ((channelsKt__Channels_commonKt$filterTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$filterTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$filterTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$filterTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$filterTo$12 = channelsKt__Channels_commonKt$filterTo$1;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        collection = c;
                        receiveChannel4 = receiveChannel3;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$filterTo$12.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$filterTo$12.L$1 = collection;
                        channelsKt__Channels_commonKt$filterTo$12.L$2 = function12;
                        channelsKt__Channels_commonKt$filterTo$12.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$filterTo$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$filterTo$12.L$5 = th2;
                        channelsKt__Channels_commonKt$filterTo$12.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$filterTo$12.L$7 = it;
                        channelsKt__Channels_commonKt$filterTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$filterTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$filterTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$1.L$3;
                    Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$filterTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$filterTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelsKt__Channels_commonKt$filterTo$1 channelsKt__Channels_commonKt$filterTo$13 = channelsKt__Channels_commonKt$filterTo$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel4 = receiveChannel9;
                        Object obj3 = coroutine_suspended;
                        collection = collection2;
                        ChannelsKt__Channels_commonKt$filterTo$1 channelsKt__Channels_commonKt$filterTo$14 = channelsKt__Channels_commonKt$filterTo$13;
                        th2 = th4;
                        receiveChannel5 = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (!((Boolean) obj2).booleanValue()) {
                            try {
                                Object obj4 = (Object) channelIterator2.next();
                                if (function13.invoke(obj4).booleanValue()) {
                                    collection.add(obj4);
                                }
                                channelsKt__Channels_commonKt$filterTo$12.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$filterTo$12.L$1 = collection;
                                channelsKt__Channels_commonKt$filterTo$12.L$2 = function12;
                                channelsKt__Channels_commonKt$filterTo$12.L$3 = receiveChannel5;
                                channelsKt__Channels_commonKt$filterTo$12.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$filterTo$12.L$5 = th2;
                                channelsKt__Channels_commonKt$filterTo$12.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$filterTo$12.L$7 = it;
                                channelsKt__Channels_commonKt$filterTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$filterTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Function1<? super E, Boolean> function14 = function12;
                                receiveChannel7 = receiveChannel2;
                                obj2 = hasNext;
                                obj3 = obj;
                                channelsKt__Channels_commonKt$filterTo$14 = channelsKt__Channels_commonKt$filterTo$12;
                                function13 = function14;
                                collection = collection;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel7, th2);
                                    InlineMarker.finallyEnd(1);
                                    return collection;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    throw th6;
                                }
                            }
                            receiveChannel2 = receiveChannel7;
                            function12 = function13;
                            channelsKt__Channels_commonKt$filterTo$12 = channelsKt__Channels_commonKt$filterTo$14;
                            obj = obj3;
                            it = channelIterator2;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$filterTo$1 = new ChannelsKt__Channels_commonKt$filterTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$filterTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$filterTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00c4 A[Catch: all -> 0x0117, TryCatch #1 {all -> 0x0117, blocks: (B:82:0x0098, B:86:0x00bc, B:88:0x00c4, B:90:0x00d4, B:96:0x010b), top: B:108:0x0098 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x010b A[Catch: all -> 0x0117, TRY_LEAVE, TryCatch #1 {all -> 0x0117, blocks: (B:82:0x0098, B:86:0x00bc, B:88:0x00c4, B:90:0x00d4, B:96:0x010b), top: B:108:0x0098 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x00f4 -> B:108:0x0098). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x0101 -> B:108:0x0098). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object filterTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, Boolean> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$filterTo$3 channelsKt__Channels_commonKt$filterTo$3;
        ?? r2;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelsKt__Channels_commonKt$filterTo$3 channelsKt__Channels_commonKt$filterTo$32;
        C c2;
        ChannelIterator<? extends E> channelIterator2;
        Object obj;
        Function1<? super E, Boolean> function13;
        C c3;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$filterTo$3) {
                channelsKt__Channels_commonKt$filterTo$3 = (ChannelsKt__Channels_commonKt$filterTo$3) continuation;
                if ((channelsKt__Channels_commonKt$filterTo$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$filterTo$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$filterTo$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = channelsKt__Channels_commonKt$filterTo$3.label;
                    if (r2 == 0) {
                        try {
                            if (r2 == 1) {
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterTo$3.L$7;
                                receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$6;
                                Throwable th2 = (Throwable) channelsKt__Channels_commonKt$filterTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$4;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$3;
                                function12 = (Function1) channelsKt__Channels_commonKt$filterTo$3.L$2;
                                ?? r7 = (SendChannel) channelsKt__Channels_commonKt$filterTo$3.L$1;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                th = th2;
                                receiveChannel2 = receiveChannel8;
                                c3 = r7;
                                if (!((Boolean) obj2).booleanValue()) {
                                }
                            } else if (r2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj3 = channelsKt__Channels_commonKt$filterTo$3.L$9;
                                Object obj4 = channelsKt__Channels_commonKt$filterTo$3.L$8;
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$filterTo$3.L$7;
                                receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$6;
                                Throwable th3 = (Throwable) channelsKt__Channels_commonKt$filterTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$4;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$3;
                                function12 = (Function1) channelsKt__Channels_commonKt$filterTo$3.L$2;
                                ?? r72 = (SendChannel) channelsKt__Channels_commonKt$filterTo$3.L$1;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$filterTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                C c4 = r72;
                                receiveChannel6 = receiveChannel3;
                                receiveChannel7 = receiveChannel4;
                                channelsKt__Channels_commonKt$filterTo$32 = channelsKt__Channels_commonKt$filterTo$3;
                                c2 = c4;
                                channelIterator2 = channelIterator;
                                receiveChannel = receiveChannel5;
                                ReceiveChannel<? extends E> receiveChannel10 = receiveChannel9;
                                th = th3;
                                receiveChannel2 = receiveChannel10;
                                Function1<? super E, Boolean> function14 = function12;
                                obj = coroutine_suspended;
                                function13 = function14;
                                try {
                                    channelsKt__Channels_commonKt$filterTo$32.L$0 = receiveChannel;
                                    channelsKt__Channels_commonKt$filterTo$32.L$1 = c2;
                                    channelsKt__Channels_commonKt$filterTo$32.L$2 = function13;
                                    channelsKt__Channels_commonKt$filterTo$32.L$3 = receiveChannel7;
                                    channelsKt__Channels_commonKt$filterTo$32.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$filterTo$32.L$5 = th;
                                    channelsKt__Channels_commonKt$filterTo$32.L$6 = receiveChannel6;
                                    channelsKt__Channels_commonKt$filterTo$32.L$7 = channelIterator2;
                                    channelsKt__Channels_commonKt$filterTo$32.label = 1;
                                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterTo$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    receiveChannel5 = receiveChannel;
                                    channelIterator = channelIterator2;
                                    c3 = c2;
                                    channelsKt__Channels_commonKt$filterTo$3 = channelsKt__Channels_commonKt$filterTo$32;
                                    receiveChannel4 = receiveChannel7;
                                    receiveChannel3 = receiveChannel6;
                                    obj2 = hasNext;
                                    Object obj5 = obj;
                                    function12 = function13;
                                    coroutine_suspended = obj5;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        E next = channelIterator.next();
                                        if (function12.invoke(next).booleanValue()) {
                                            channelsKt__Channels_commonKt$filterTo$3.L$0 = receiveChannel5;
                                            channelsKt__Channels_commonKt$filterTo$3.L$1 = c3;
                                            channelsKt__Channels_commonKt$filterTo$3.L$2 = function12;
                                            channelsKt__Channels_commonKt$filterTo$3.L$3 = receiveChannel4;
                                            channelsKt__Channels_commonKt$filterTo$3.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$filterTo$3.L$5 = th;
                                            channelsKt__Channels_commonKt$filterTo$3.L$6 = receiveChannel3;
                                            channelsKt__Channels_commonKt$filterTo$3.L$7 = channelIterator;
                                            channelsKt__Channels_commonKt$filterTo$3.L$8 = next;
                                            channelsKt__Channels_commonKt$filterTo$3.L$9 = next;
                                            channelsKt__Channels_commonKt$filterTo$3.label = 2;
                                            if (c3.send(next, channelsKt__Channels_commonKt$filterTo$3) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            Throwable th4 = th;
                                            receiveChannel9 = receiveChannel2;
                                            th3 = th4;
                                            c4 = c3;
                                            receiveChannel6 = receiveChannel3;
                                            receiveChannel7 = receiveChannel4;
                                            channelsKt__Channels_commonKt$filterTo$32 = channelsKt__Channels_commonKt$filterTo$3;
                                            c2 = c4;
                                            channelIterator2 = channelIterator;
                                            receiveChannel = receiveChannel5;
                                            ReceiveChannel<? extends E> receiveChannel102 = receiveChannel9;
                                            th = th3;
                                            receiveChannel2 = receiveChannel102;
                                            Function1<? super E, Boolean> function142 = function12;
                                            obj = coroutine_suspended;
                                            function13 = function142;
                                            channelsKt__Channels_commonKt$filterTo$32.L$0 = receiveChannel;
                                            channelsKt__Channels_commonKt$filterTo$32.L$1 = c2;
                                            channelsKt__Channels_commonKt$filterTo$32.L$2 = function13;
                                            channelsKt__Channels_commonKt$filterTo$32.L$3 = receiveChannel7;
                                            channelsKt__Channels_commonKt$filterTo$32.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$filterTo$32.L$5 = th;
                                            channelsKt__Channels_commonKt$filterTo$32.L$6 = receiveChannel6;
                                            channelsKt__Channels_commonKt$filterTo$32.L$7 = channelIterator2;
                                            channelsKt__Channels_commonKt$filterTo$32.label = 1;
                                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterTo$32);
                                            if (hasNext != obj) {
                                            }
                                        } else {
                                            receiveChannel6 = receiveChannel3;
                                            receiveChannel7 = receiveChannel4;
                                            channelsKt__Channels_commonKt$filterTo$32 = channelsKt__Channels_commonKt$filterTo$3;
                                            c2 = c3;
                                            channelIterator2 = channelIterator;
                                            receiveChannel = receiveChannel5;
                                            Function1<? super E, Boolean> function15 = function12;
                                            obj = coroutine_suspended;
                                            function13 = function15;
                                            channelsKt__Channels_commonKt$filterTo$32.L$0 = receiveChannel;
                                            channelsKt__Channels_commonKt$filterTo$32.L$1 = c2;
                                            channelsKt__Channels_commonKt$filterTo$32.L$2 = function13;
                                            channelsKt__Channels_commonKt$filterTo$32.L$3 = receiveChannel7;
                                            channelsKt__Channels_commonKt$filterTo$32.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$filterTo$32.L$5 = th;
                                            channelsKt__Channels_commonKt$filterTo$32.L$6 = receiveChannel6;
                                            channelsKt__Channels_commonKt$filterTo$32.L$7 = channelIterator2;
                                            channelsKt__Channels_commonKt$filterTo$32.label = 1;
                                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterTo$32);
                                            if (hasNext != obj) {
                                            }
                                        }
                                    } else {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                                        InlineMarker.finallyEnd(1);
                                        return c3;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = r2;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th7 = null;
                        try {
                            channelsKt__Channels_commonKt$filterTo$32 = channelsKt__Channels_commonKt$filterTo$3;
                            obj = coroutine_suspended;
                            channelIterator2 = receiveChannel.iterator();
                            c2 = c;
                            function13 = function1;
                            th = th7;
                            receiveChannel7 = receiveChannel;
                            receiveChannel2 = receiveChannel7;
                            receiveChannel6 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterTo$32.L$0 = receiveChannel;
                            channelsKt__Channels_commonKt$filterTo$32.L$1 = c2;
                            channelsKt__Channels_commonKt$filterTo$32.L$2 = function13;
                            channelsKt__Channels_commonKt$filterTo$32.L$3 = receiveChannel7;
                            channelsKt__Channels_commonKt$filterTo$32.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$filterTo$32.L$5 = th;
                            channelsKt__Channels_commonKt$filterTo$32.L$6 = receiveChannel6;
                            channelsKt__Channels_commonKt$filterTo$32.L$7 = channelIterator2;
                            channelsKt__Channels_commonKt$filterTo$32.label = 1;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$filterTo$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th8) {
                            receiveChannel2 = receiveChannel;
                            th = th8;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th9) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th9;
        }
        channelsKt__Channels_commonKt$filterTo$3 = new ChannelsKt__Channels_commonKt$filterTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$filterTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = channelsKt__Channels_commonKt$filterTo$3.label;
        if (r2 == 0) {
        }
    }

    public static /* synthetic */ ReceiveChannel take$default(ReceiveChannel receiveChannel, int i, CoroutineContext coroutineContext, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.take(receiveChannel, i, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> take(ReceiveChannel<? extends E> take, int i, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(take, "$this$take");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(take), new ChannelsKt__Channels_commonKt$take$1(take, i, null), 2, null);
    }

    public static /* synthetic */ ReceiveChannel takeWhile$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.takeWhile(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> takeWhile(ReceiveChannel<? extends E> takeWhile, CoroutineContext context, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> predicate) {
        Intrinsics.checkParameterIsNotNull(takeWhile, "$this$takeWhile");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(predicate, "predicate");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(takeWhile), new ChannelsKt__Channels_commonKt$takeWhile$1(takeWhile, predicate, null), 2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a9 A[Catch: all -> 0x00ce, TryCatch #3 {all -> 0x00ce, blocks: (B:72:0x00a1, B:74:0x00a9, B:68:0x0081, B:75:0x00c2), top: B:92:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c2 A[Catch: all -> 0x00ce, TRY_LEAVE, TryCatch #3 {all -> 0x00ce, blocks: (B:72:0x00a1, B:74:0x00a9, B:68:0x0081, B:75:0x00c2), top: B:92:0x00a1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x009c -> B:92:0x00a1). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K, V> Object associate(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, Continuation<? super Map<K, ? extends V>> continuation) {
        ChannelsKt__Channels_commonKt$associate$1 channelsKt__Channels_commonKt$associate$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        LinkedHashMap linkedHashMap;
        ChannelsKt__Channels_commonKt$associate$1 channelsKt__Channels_commonKt$associate$12;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        Function1<? super E, ? extends Pair<? extends K, ? extends V>> function12;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$associate$1) {
                channelsKt__Channels_commonKt$associate$1 = (ChannelsKt__Channels_commonKt$associate$1) continuation;
                if ((channelsKt__Channels_commonKt$associate$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$associate$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$associate$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$associate$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th3 = null;
                        try {
                            linkedHashMap = new LinkedHashMap();
                            channelsKt__Channels_commonKt$associate$12 = channelsKt__Channels_commonKt$associate$1;
                            obj = coroutine_suspended;
                            th2 = th3;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            receiveChannel2 = receiveChannel4;
                            receiveChannel5 = receiveChannel2;
                            it = receiveChannel.iterator();
                            function12 = function1;
                            receiveChannel6 = receiveChannel5;
                            channelsKt__Channels_commonKt$associate$12.L$0 = receiveChannel6;
                            channelsKt__Channels_commonKt$associate$12.L$1 = function12;
                            channelsKt__Channels_commonKt$associate$12.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$associate$12.L$3 = linkedHashMap;
                            channelsKt__Channels_commonKt$associate$12.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$associate$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$associate$12.L$6 = th2;
                            channelsKt__Channels_commonKt$associate$12.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$associate$12.L$8 = it;
                            channelsKt__Channels_commonKt$associate$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$associate$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th4) {
                            receiveChannel2 = receiveChannel;
                            th = th4;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$associate$1.L$8;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$7;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$associate$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$4;
                        Map map = (Map) channelsKt__Channels_commonKt$associate$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$2;
                        Function1<? super E, ? extends Pair<? extends K, ? extends V>> function13 = (Function1) channelsKt__Channels_commonKt$associate$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$associate$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel5 = receiveChannel7;
                            receiveChannel6 = receiveChannel11;
                            Map map2 = map;
                            obj = coroutine_suspended;
                            receiveChannel2 = receiveChannel8;
                            function12 = function13;
                            Throwable th6 = th5;
                            channelsKt__Channels_commonKt$associate$12 = channelsKt__Channels_commonKt$associate$1;
                            receiveChannel4 = receiveChannel9;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    Pair<? extends K, ? extends V> invoke = function12.invoke((Object) channelIterator2.next());
                                    map2.put(invoke.getFirst(), invoke.getSecond());
                                    receiveChannel3 = receiveChannel10;
                                    th2 = th6;
                                    linkedHashMap = map2;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$associate$12.L$0 = receiveChannel6;
                                    channelsKt__Channels_commonKt$associate$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$associate$12.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$associate$12.L$3 = linkedHashMap;
                                    channelsKt__Channels_commonKt$associate$12.L$4 = receiveChannel4;
                                    channelsKt__Channels_commonKt$associate$12.L$5 = receiveChannel2;
                                    channelsKt__Channels_commonKt$associate$12.L$6 = th2;
                                    channelsKt__Channels_commonKt$associate$12.L$7 = receiveChannel5;
                                    channelsKt__Channels_commonKt$associate$12.L$8 = it;
                                    channelsKt__Channels_commonKt$associate$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$associate$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Throwable th7 = th2;
                                    receiveChannel10 = receiveChannel3;
                                    obj2 = hasNext;
                                    map2 = linkedHashMap;
                                    th6 = th7;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th6);
                                        InlineMarker.finallyEnd(1);
                                        return map2;
                                    }
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            receiveChannel2 = receiveChannel8;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th10) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th10;
        }
        channelsKt__Channels_commonKt$associate$1 = new ChannelsKt__Channels_commonKt$associate$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$associate$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associate$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object associate$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Pair pair = (Pair) function1.invoke(it.next());
                    linkedHashMap.put(pair.getFirst(), pair.getSecond());
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return linkedHashMap;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Type inference failed for r15v10. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x009b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a9 A[Catch: all -> 0x00c4, TryCatch #0 {all -> 0x00c4, blocks: (B:72:0x00a1, B:74:0x00a9, B:68:0x0081, B:75:0x00b8), top: B:86:0x00a1 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b8 A[Catch: all -> 0x00c4, TRY_LEAVE, TryCatch #0 {all -> 0x00c4, blocks: (B:72:0x00a1, B:74:0x00a9, B:68:0x0081, B:75:0x00b8), top: B:86:0x00a1 }] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x009c -> B:86:0x00a1). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K> Object associateBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Continuation<? super Map<K, ? extends E>> continuation) {
        ChannelsKt__Channels_commonKt$associateBy$1 channelsKt__Channels_commonKt$associateBy$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        LinkedHashMap linkedHashMap;
        ChannelsKt__Channels_commonKt$associateBy$1 channelsKt__Channels_commonKt$associateBy$12;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        Function1<? super E, ? extends K> function12;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$associateBy$1) {
                channelsKt__Channels_commonKt$associateBy$1 = (ChannelsKt__Channels_commonKt$associateBy$1) continuation;
                if ((channelsKt__Channels_commonKt$associateBy$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$associateBy$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$associateBy$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$associateBy$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th3 = null;
                        try {
                            linkedHashMap = new LinkedHashMap();
                            channelsKt__Channels_commonKt$associateBy$12 = channelsKt__Channels_commonKt$associateBy$1;
                            obj = coroutine_suspended;
                            th2 = th3;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            receiveChannel2 = receiveChannel4;
                            receiveChannel5 = receiveChannel2;
                            it = receiveChannel.iterator();
                            function12 = function1;
                            receiveChannel6 = receiveChannel5;
                            channelsKt__Channels_commonKt$associateBy$12.L$0 = receiveChannel6;
                            channelsKt__Channels_commonKt$associateBy$12.L$1 = function12;
                            channelsKt__Channels_commonKt$associateBy$12.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$associateBy$12.L$3 = linkedHashMap;
                            channelsKt__Channels_commonKt$associateBy$12.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$associateBy$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$associateBy$12.L$6 = th2;
                            channelsKt__Channels_commonKt$associateBy$12.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$associateBy$12.L$8 = it;
                            channelsKt__Channels_commonKt$associateBy$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$associateBy$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th4) {
                            receiveChannel2 = receiveChannel;
                            th = th4;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$associateBy$1.L$8;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$7;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$associateBy$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$4;
                        ?? r6 = (Map) channelsKt__Channels_commonKt$associateBy$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$2;
                        Function1<? super E, ? extends K> function13 = (Function1) channelsKt__Channels_commonKt$associateBy$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel5 = receiveChannel7;
                            receiveChannel6 = receiveChannel11;
                            LinkedHashMap linkedHashMap2 = r6;
                            obj = coroutine_suspended;
                            receiveChannel2 = receiveChannel8;
                            function12 = function13;
                            Throwable th6 = th5;
                            channelsKt__Channels_commonKt$associateBy$12 = channelsKt__Channels_commonKt$associateBy$1;
                            receiveChannel4 = receiveChannel9;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    Object obj3 = (Object) channelIterator2.next();
                                    linkedHashMap2.put(function12.invoke(obj3), obj3);
                                    receiveChannel3 = receiveChannel10;
                                    th2 = th6;
                                    linkedHashMap = linkedHashMap2;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$associateBy$12.L$0 = receiveChannel6;
                                    channelsKt__Channels_commonKt$associateBy$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$associateBy$12.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$associateBy$12.L$3 = linkedHashMap;
                                    channelsKt__Channels_commonKt$associateBy$12.L$4 = receiveChannel4;
                                    channelsKt__Channels_commonKt$associateBy$12.L$5 = receiveChannel2;
                                    channelsKt__Channels_commonKt$associateBy$12.L$6 = th2;
                                    channelsKt__Channels_commonKt$associateBy$12.L$7 = receiveChannel5;
                                    channelsKt__Channels_commonKt$associateBy$12.L$8 = it;
                                    channelsKt__Channels_commonKt$associateBy$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$associateBy$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Throwable th7 = th2;
                                    receiveChannel10 = receiveChannel3;
                                    obj2 = hasNext;
                                    linkedHashMap2 = linkedHashMap;
                                    th6 = th7;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th6);
                                        InlineMarker.finallyEnd(1);
                                        return linkedHashMap2;
                                    }
                                }
                            } catch (Throwable th8) {
                                th = th8;
                            }
                        } catch (Throwable th9) {
                            th = th9;
                            receiveChannel2 = receiveChannel8;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th10) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th10;
        }
        channelsKt__Channels_commonKt$associateBy$1 = new ChannelsKt__Channels_commonKt$associateBy$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$associateBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateBy$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object associateBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    linkedHashMap.put(function1.invoke(next), next);
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return linkedHashMap;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Type inference failed for r15v10. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00b0 A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:72:0x00a8, B:74:0x00b0, B:68:0x0085, B:75:0x00c4), top: B:86:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c4 A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:72:0x00a8, B:74:0x00b0, B:68:0x0085, B:75:0x00c4), top: B:86:0x00a8 }] */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x00a2 -> B:86:0x00a8). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K, V> Object associateBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super Map<K, ? extends V>> continuation) {
        ChannelsKt__Channels_commonKt$associateBy$2 channelsKt__Channels_commonKt$associateBy$2;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        LinkedHashMap linkedHashMap;
        ChannelsKt__Channels_commonKt$associateBy$2 channelsKt__Channels_commonKt$associateBy$22;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, ? extends K> function13;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        Function1<? super E, ? extends V> function14;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$associateBy$2) {
                channelsKt__Channels_commonKt$associateBy$2 = (ChannelsKt__Channels_commonKt$associateBy$2) continuation;
                if ((channelsKt__Channels_commonKt$associateBy$2.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$associateBy$2.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$associateBy$2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$associateBy$2.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th3 = null;
                        try {
                            linkedHashMap = new LinkedHashMap();
                            channelsKt__Channels_commonKt$associateBy$22 = channelsKt__Channels_commonKt$associateBy$2;
                            obj = coroutine_suspended;
                            th2 = th3;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            function13 = function1;
                            receiveChannel5 = receiveChannel4;
                            it = receiveChannel.iterator();
                            function14 = function12;
                            receiveChannel6 = receiveChannel5;
                            channelsKt__Channels_commonKt$associateBy$22.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$associateBy$22.L$1 = function13;
                            channelsKt__Channels_commonKt$associateBy$22.L$2 = function14;
                            channelsKt__Channels_commonKt$associateBy$22.L$3 = receiveChannel6;
                            channelsKt__Channels_commonKt$associateBy$22.L$4 = linkedHashMap;
                            channelsKt__Channels_commonKt$associateBy$22.L$5 = receiveChannel3;
                            channelsKt__Channels_commonKt$associateBy$22.L$6 = receiveChannel2;
                            channelsKt__Channels_commonKt$associateBy$22.L$7 = th2;
                            channelsKt__Channels_commonKt$associateBy$22.L$8 = receiveChannel4;
                            channelsKt__Channels_commonKt$associateBy$22.L$9 = it;
                            channelsKt__Channels_commonKt$associateBy$22.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$associateBy$22);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th4) {
                            receiveChannel2 = receiveChannel;
                            th = th4;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$associateBy$2.L$9;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$8;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$associateBy$2.L$7;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$6;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$5;
                        ?? r5 = (Map) channelsKt__Channels_commonKt$associateBy$2.L$4;
                        ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$3;
                        Function1<? super E, ? extends V> function15 = (Function1) channelsKt__Channels_commonKt$associateBy$2.L$2;
                        Function1<? super E, ? extends K> function16 = (Function1) channelsKt__Channels_commonKt$associateBy$2.L$1;
                        ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$associateBy$2.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel7;
                            receiveChannel5 = receiveChannel11;
                            LinkedHashMap linkedHashMap2 = r5;
                            th2 = th5;
                            receiveChannel6 = receiveChannel10;
                            channelsKt__Channels_commonKt$associateBy$22 = channelsKt__Channels_commonKt$associateBy$2;
                            receiveChannel2 = receiveChannel8;
                            function13 = function16;
                            Object obj3 = coroutine_suspended;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    Object obj4 = (Object) channelIterator2.next();
                                    linkedHashMap2.put(function13.invoke(obj4), function15.invoke(obj4));
                                    receiveChannel3 = receiveChannel9;
                                    function14 = function15;
                                    obj = obj3;
                                    linkedHashMap = linkedHashMap2;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$associateBy$22.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$associateBy$22.L$1 = function13;
                                    channelsKt__Channels_commonKt$associateBy$22.L$2 = function14;
                                    channelsKt__Channels_commonKt$associateBy$22.L$3 = receiveChannel6;
                                    channelsKt__Channels_commonKt$associateBy$22.L$4 = linkedHashMap;
                                    channelsKt__Channels_commonKt$associateBy$22.L$5 = receiveChannel3;
                                    channelsKt__Channels_commonKt$associateBy$22.L$6 = receiveChannel2;
                                    channelsKt__Channels_commonKt$associateBy$22.L$7 = th2;
                                    channelsKt__Channels_commonKt$associateBy$22.L$8 = receiveChannel4;
                                    channelsKt__Channels_commonKt$associateBy$22.L$9 = it;
                                    channelsKt__Channels_commonKt$associateBy$22.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$associateBy$22);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Function1<? super E, ? extends V> function17 = function14;
                                    receiveChannel9 = receiveChannel3;
                                    obj2 = hasNext;
                                    linkedHashMap2 = linkedHashMap;
                                    obj3 = obj;
                                    function15 = function17;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                        InlineMarker.finallyEnd(1);
                                        return linkedHashMap2;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel8;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$associateBy$2 = new ChannelsKt__Channels_commonKt$associateBy$2(continuation);
        Object obj22 = channelsKt__Channels_commonKt$associateBy$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateBy$2.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object associateBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Function1 function12, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    linkedHashMap.put(function1.invoke(next), function12.invoke(next));
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return linkedHashMap;
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009a A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:59:0x0046, B:72:0x0092, B:74:0x009a, B:75:0x00aa), top: B:86:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00aa A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:59:0x0046, B:72:0x0092, B:74:0x009a, B:75:0x00aa), top: B:86:0x0046 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x008c -> B:72:0x0092). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K, M extends Map<? super K, ? super E>> Object associateByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$associateByTo$1 channelsKt__Channels_commonKt$associateByTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$associateByTo$1 channelsKt__Channels_commonKt$associateByTo$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        Map map;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, ? extends K> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associateByTo$1) {
            channelsKt__Channels_commonKt$associateByTo$1 = (ChannelsKt__Channels_commonKt$associateByTo$1) continuation;
            if ((channelsKt__Channels_commonKt$associateByTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associateByTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$associateByTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associateByTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$associateByTo$12 = channelsKt__Channels_commonKt$associateByTo$1;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        map = m;
                        receiveChannel4 = receiveChannel3;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$associateByTo$12.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$associateByTo$12.L$1 = map;
                        channelsKt__Channels_commonKt$associateByTo$12.L$2 = function12;
                        channelsKt__Channels_commonKt$associateByTo$12.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$associateByTo$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$associateByTo$12.L$5 = th2;
                        channelsKt__Channels_commonKt$associateByTo$12.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$associateByTo$12.L$7 = it;
                        channelsKt__Channels_commonKt$associateByTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$associateByTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$associateByTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$associateByTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$1.L$3;
                    Function1<? super E, ? extends K> function13 = (Function1) channelsKt__Channels_commonKt$associateByTo$1.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$associateByTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelsKt__Channels_commonKt$associateByTo$1 channelsKt__Channels_commonKt$associateByTo$13 = channelsKt__Channels_commonKt$associateByTo$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel4 = receiveChannel9;
                        Object obj3 = coroutine_suspended;
                        map = map2;
                        ChannelsKt__Channels_commonKt$associateByTo$1 channelsKt__Channels_commonKt$associateByTo$14 = channelsKt__Channels_commonKt$associateByTo$13;
                        th2 = th4;
                        receiveChannel5 = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object obj4 = (Object) channelIterator2.next();
                            map.put(function13.invoke(obj4), obj4);
                            receiveChannel2 = receiveChannel7;
                            function12 = function13;
                            channelsKt__Channels_commonKt$associateByTo$12 = channelsKt__Channels_commonKt$associateByTo$14;
                            obj = obj3;
                            it = channelIterator2;
                            try {
                                channelsKt__Channels_commonKt$associateByTo$12.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$associateByTo$12.L$1 = map;
                                channelsKt__Channels_commonKt$associateByTo$12.L$2 = function12;
                                channelsKt__Channels_commonKt$associateByTo$12.L$3 = receiveChannel5;
                                channelsKt__Channels_commonKt$associateByTo$12.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$associateByTo$12.L$5 = th2;
                                channelsKt__Channels_commonKt$associateByTo$12.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$associateByTo$12.L$7 = it;
                                channelsKt__Channels_commonKt$associateByTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$associateByTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Function1<? super E, ? extends K> function14 = function12;
                                receiveChannel7 = receiveChannel2;
                                obj2 = hasNext;
                                obj3 = obj;
                                channelsKt__Channels_commonKt$associateByTo$14 = channelsKt__Channels_commonKt$associateByTo$12;
                                function13 = function14;
                                map = map;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel7, th2);
                                    InlineMarker.finallyEnd(1);
                                    return map;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$associateByTo$1 = new ChannelsKt__Channels_commonKt$associateByTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$associateByTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateByTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x009f A[Catch: all -> 0x0057, TryCatch #1 {all -> 0x0057, blocks: (B:55:0x004a, B:68:0x0097, B:70:0x009f, B:64:0x0077, B:71:0x00b2), top: B:82:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b2 A[Catch: all -> 0x0057, TRY_LEAVE, TryCatch #1 {all -> 0x0057, blocks: (B:55:0x004a, B:68:0x0097, B:70:0x009f, B:64:0x0077, B:71:0x00b2), top: B:82:0x004a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0092 -> B:68:0x0097). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$associateByTo$3 channelsKt__Channels_commonKt$associateByTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Function1<? super E, ? extends V> function13;
        ChannelsKt__Channels_commonKt$associateByTo$3 channelsKt__Channels_commonKt$associateByTo$32;
        Object obj;
        M m2;
        Function1<? super E, ? extends K> function14;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associateByTo$3) {
            channelsKt__Channels_commonKt$associateByTo$3 = (ChannelsKt__Channels_commonKt$associateByTo$3) continuation;
            if ((channelsKt__Channels_commonKt$associateByTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associateByTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$associateByTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associateByTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th3 = null;
                    try {
                        function13 = function12;
                        channelsKt__Channels_commonKt$associateByTo$32 = channelsKt__Channels_commonKt$associateByTo$3;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        m2 = m;
                        function14 = function1;
                        receiveChannel3 = receiveChannel2;
                        receiveChannel4 = receiveChannel3;
                        it = receiveChannel.iterator();
                        th2 = th3;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$associateByTo$32.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$associateByTo$32.L$1 = m2;
                        channelsKt__Channels_commonKt$associateByTo$32.L$2 = function14;
                        channelsKt__Channels_commonKt$associateByTo$32.L$3 = function13;
                        channelsKt__Channels_commonKt$associateByTo$32.L$4 = receiveChannel4;
                        channelsKt__Channels_commonKt$associateByTo$32.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$associateByTo$32.L$6 = th2;
                        channelsKt__Channels_commonKt$associateByTo$32.L$7 = receiveChannel5;
                        channelsKt__Channels_commonKt$associateByTo$32.L$8 = it;
                        channelsKt__Channels_commonKt$associateByTo$32.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$associateByTo$32);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th4) {
                        receiveChannel2 = receiveChannel;
                        th = th4;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$associateByTo$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$3.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$associateByTo$3.L$6;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$3.L$4;
                    function13 = (Function1) channelsKt__Channels_commonKt$associateByTo$3.L$3;
                    Function1<? super E, ? extends K> function15 = (Function1) channelsKt__Channels_commonKt$associateByTo$3.L$2;
                    Map map = (Map) channelsKt__Channels_commonKt$associateByTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateByTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelsKt__Channels_commonKt$associateByTo$3 channelsKt__Channels_commonKt$associateByTo$33 = channelsKt__Channels_commonKt$associateByTo$3;
                        ReceiveChannel<? extends E> receiveChannel9 = receiveChannel6;
                        receiveChannel3 = receiveChannel8;
                        Object obj3 = coroutine_suspended;
                        function14 = function15;
                        channelsKt__Channels_commonKt$associateByTo$32 = channelsKt__Channels_commonKt$associateByTo$33;
                        th2 = th5;
                        receiveChannel4 = receiveChannel7;
                        Map map2 = map;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (!((Boolean) obj2).booleanValue()) {
                            Object obj4 = (Object) channelIterator2.next();
                            map2.put(function14.invoke(obj4), function13.invoke(obj4));
                            receiveChannel5 = receiveChannel9;
                            m2 = map2;
                            obj = obj3;
                            it = channelIterator2;
                            channelsKt__Channels_commonKt$associateByTo$32.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$associateByTo$32.L$1 = m2;
                            channelsKt__Channels_commonKt$associateByTo$32.L$2 = function14;
                            channelsKt__Channels_commonKt$associateByTo$32.L$3 = function13;
                            channelsKt__Channels_commonKt$associateByTo$32.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$associateByTo$32.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$associateByTo$32.L$6 = th2;
                            channelsKt__Channels_commonKt$associateByTo$32.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$associateByTo$32.L$8 = it;
                            channelsKt__Channels_commonKt$associateByTo$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$associateByTo$32);
                            if (hasNext != obj) {
                                return obj;
                            }
                            M m3 = m2;
                            receiveChannel9 = receiveChannel5;
                            obj2 = hasNext;
                            obj3 = obj;
                            map2 = m3;
                            channelIterator2 = it;
                            if (!((Boolean) obj2).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                return map2;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        try {
                            throw th;
                        } finally {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th);
                            InlineMarker.finallyEnd(1);
                        }
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$associateByTo$3 = new ChannelsKt__Channels_commonKt$associateByTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$associateByTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateByTo$3.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009a A[Catch: all -> 0x0053, TryCatch #2 {all -> 0x0053, blocks: (B:59:0x0046, B:72:0x0092, B:74:0x009a, B:75:0x00b4), top: B:90:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b4 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #2 {all -> 0x0053, blocks: (B:59:0x0046, B:72:0x0092, B:74:0x009a, B:75:0x00b4), top: B:90:0x0046 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x008c -> B:72:0x0092). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K, V, M extends Map<? super K, ? super V>> Object associateTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends Pair<? extends K, ? extends V>> function1, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$associateTo$1 channelsKt__Channels_commonKt$associateTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$associateTo$1 channelsKt__Channels_commonKt$associateTo$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        Map map;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, ? extends Pair<? extends K, ? extends V>> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$associateTo$1) {
            channelsKt__Channels_commonKt$associateTo$1 = (ChannelsKt__Channels_commonKt$associateTo$1) continuation;
            if ((channelsKt__Channels_commonKt$associateTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$associateTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$associateTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$associateTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$associateTo$12 = channelsKt__Channels_commonKt$associateTo$1;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        map = m;
                        receiveChannel4 = receiveChannel3;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$associateTo$12.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$associateTo$12.L$1 = map;
                        channelsKt__Channels_commonKt$associateTo$12.L$2 = function12;
                        channelsKt__Channels_commonKt$associateTo$12.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$associateTo$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$associateTo$12.L$5 = th2;
                        channelsKt__Channels_commonKt$associateTo$12.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$associateTo$12.L$7 = it;
                        channelsKt__Channels_commonKt$associateTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$associateTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$associateTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$associateTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$associateTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$associateTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$associateTo$1.L$3;
                    Function1<? super E, ? extends Pair<? extends K, ? extends V>> function13 = (Function1) channelsKt__Channels_commonKt$associateTo$1.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$associateTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$associateTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelsKt__Channels_commonKt$associateTo$1 channelsKt__Channels_commonKt$associateTo$13 = channelsKt__Channels_commonKt$associateTo$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel4 = receiveChannel9;
                        Object obj3 = coroutine_suspended;
                        map = map2;
                        ChannelsKt__Channels_commonKt$associateTo$1 channelsKt__Channels_commonKt$associateTo$14 = channelsKt__Channels_commonKt$associateTo$13;
                        th2 = th4;
                        receiveChannel5 = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (!((Boolean) obj2).booleanValue()) {
                            Pair<? extends K, ? extends V> invoke = function13.invoke((Object) channelIterator2.next());
                            map.put(invoke.getFirst(), invoke.getSecond());
                            receiveChannel2 = receiveChannel7;
                            function12 = function13;
                            channelsKt__Channels_commonKt$associateTo$12 = channelsKt__Channels_commonKt$associateTo$14;
                            obj = obj3;
                            it = channelIterator2;
                            try {
                                channelsKt__Channels_commonKt$associateTo$12.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$associateTo$12.L$1 = map;
                                channelsKt__Channels_commonKt$associateTo$12.L$2 = function12;
                                channelsKt__Channels_commonKt$associateTo$12.L$3 = receiveChannel5;
                                channelsKt__Channels_commonKt$associateTo$12.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$associateTo$12.L$5 = th2;
                                channelsKt__Channels_commonKt$associateTo$12.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$associateTo$12.L$7 = it;
                                channelsKt__Channels_commonKt$associateTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$associateTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Function1<? super E, ? extends Pair<? extends K, ? extends V>> function14 = function12;
                                receiveChannel7 = receiveChannel2;
                                obj2 = hasNext;
                                obj3 = obj;
                                channelsKt__Channels_commonKt$associateTo$14 = channelsKt__Channels_commonKt$associateTo$12;
                                function13 = function14;
                                map = map;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel7, th2);
                                    InlineMarker.finallyEnd(1);
                                    return map;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$associateTo$1 = new ChannelsKt__Channels_commonKt$associateTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$associateTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$associateTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x0082: MOVE  (r12 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:74:0x0082 */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00ad A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00be A[Catch: all -> 0x00ec, TryCatch #2 {all -> 0x00ec, blocks: (B:78:0x0097, B:82:0x00b6, B:84:0x00be, B:88:0x00e6), top: B:102:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00e6 A[Catch: all -> 0x00ec, TRY_LEAVE, TryCatch #2 {all -> 0x00ec, blocks: (B:78:0x0097, B:82:0x00b6, B:84:0x00be, B:88:0x00e6), top: B:102:0x0097 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x00dd -> B:102:0x0097). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends SendChannel<? super E>> Object toChannel(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$toChannel$1 channelsKt__Channels_commonKt$toChannel$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel5;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel6;
        ChannelsKt__Channels_commonKt$toChannel$1 channelsKt__Channels_commonKt$toChannel$12;
        ReceiveChannel<? extends E> receiveChannel7;
        ReceiveChannel<? extends E> receiveChannel8;
        Object obj2;
        C c2;
        ChannelIterator channelIterator2;
        C c3;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$toChannel$1) {
                channelsKt__Channels_commonKt$toChannel$1 = (ChannelsKt__Channels_commonKt$toChannel$1) continuation;
                if ((channelsKt__Channels_commonKt$toChannel$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$toChannel$1.label -= Integer.MIN_VALUE;
                    Object obj3 = channelsKt__Channels_commonKt$toChannel$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$toChannel$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj3);
                        Throwable th2 = null;
                        try {
                            channelsKt__Channels_commonKt$toChannel$12 = channelsKt__Channels_commonKt$toChannel$1;
                            obj2 = coroutine_suspended;
                            channelIterator2 = receiveChannel.iterator();
                            receiveChannel7 = receiveChannel;
                            c2 = c;
                            th = th2;
                            receiveChannel8 = receiveChannel7;
                            receiveChannel3 = receiveChannel8;
                        } catch (Throwable th3) {
                            receiveChannel3 = receiveChannel;
                            th = th3;
                            throw th;
                        }
                    } else {
                        try {
                            if (i == 1) {
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$toChannel$1.L$6;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$5;
                                th = (Throwable) channelsKt__Channels_commonKt$toChannel$1.L$4;
                                ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$3;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$2;
                                ?? r7 = (SendChannel) channelsKt__Channels_commonKt$toChannel$1.L$1;
                                ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$0;
                                ResultKt.throwOnFailure(obj3);
                                obj = obj3;
                                receiveChannel3 = receiveChannel9;
                                receiveChannel6 = receiveChannel10;
                                c3 = r7;
                                if (!((Boolean) obj).booleanValue()) {
                                    Object next = channelIterator.next();
                                    channelsKt__Channels_commonKt$toChannel$1.L$0 = receiveChannel6;
                                    channelsKt__Channels_commonKt$toChannel$1.L$1 = c3;
                                    channelsKt__Channels_commonKt$toChannel$1.L$2 = receiveChannel5;
                                    channelsKt__Channels_commonKt$toChannel$1.L$3 = receiveChannel3;
                                    channelsKt__Channels_commonKt$toChannel$1.L$4 = th;
                                    channelsKt__Channels_commonKt$toChannel$1.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$toChannel$1.L$6 = channelIterator;
                                    channelsKt__Channels_commonKt$toChannel$1.L$7 = next;
                                    channelsKt__Channels_commonKt$toChannel$1.L$8 = next;
                                    channelsKt__Channels_commonKt$toChannel$1.label = 2;
                                    if (c3.send(next, channelsKt__Channels_commonKt$toChannel$1) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    C c4 = c3;
                                    channelIterator2 = channelIterator;
                                    receiveChannel = receiveChannel6;
                                    channelsKt__Channels_commonKt$toChannel$12 = channelsKt__Channels_commonKt$toChannel$1;
                                    receiveChannel7 = receiveChannel4;
                                    receiveChannel8 = receiveChannel5;
                                    obj2 = coroutine_suspended;
                                    c2 = c4;
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    ChannelsKt.cancelConsumed(receiveChannel3, th);
                                    return c3;
                                }
                            } else if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj4 = channelsKt__Channels_commonKt$toChannel$1.L$8;
                                Object obj5 = channelsKt__Channels_commonKt$toChannel$1.L$7;
                                ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$toChannel$1.L$6;
                                ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$5;
                                th = (Throwable) channelsKt__Channels_commonKt$toChannel$1.L$4;
                                ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$3;
                                ReceiveChannel<? extends E> receiveChannel13 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$2;
                                ?? r72 = (SendChannel) channelsKt__Channels_commonKt$toChannel$1.L$1;
                                ReceiveChannel<? extends E> receiveChannel14 = (ReceiveChannel) channelsKt__Channels_commonKt$toChannel$1.L$0;
                                ResultKt.throwOnFailure(obj3);
                                receiveChannel3 = receiveChannel12;
                                channelsKt__Channels_commonKt$toChannel$12 = channelsKt__Channels_commonKt$toChannel$1;
                                receiveChannel7 = receiveChannel11;
                                receiveChannel8 = receiveChannel13;
                                obj2 = coroutine_suspended;
                                c2 = r72;
                                channelIterator2 = channelIterator3;
                                receiveChannel = receiveChannel14;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            receiveChannel3 = receiveChannel2;
                            try {
                                throw th;
                            } catch (Throwable th5) {
                                ChannelsKt.cancelConsumed(receiveChannel3, th);
                                throw th5;
                            }
                        }
                    }
                    channelsKt__Channels_commonKt$toChannel$12.L$0 = receiveChannel;
                    channelsKt__Channels_commonKt$toChannel$12.L$1 = c2;
                    channelsKt__Channels_commonKt$toChannel$12.L$2 = receiveChannel8;
                    channelsKt__Channels_commonKt$toChannel$12.L$3 = receiveChannel3;
                    channelsKt__Channels_commonKt$toChannel$12.L$4 = th;
                    channelsKt__Channels_commonKt$toChannel$12.L$5 = receiveChannel7;
                    channelsKt__Channels_commonKt$toChannel$12.L$6 = channelIterator2;
                    channelsKt__Channels_commonKt$toChannel$12.label = 1;
                    obj = channelIterator2.hasNext(channelsKt__Channels_commonKt$toChannel$12);
                    if (obj != obj2) {
                        return obj2;
                    }
                    ChannelsKt__Channels_commonKt$toChannel$1 channelsKt__Channels_commonKt$toChannel$13 = channelsKt__Channels_commonKt$toChannel$12;
                    receiveChannel6 = receiveChannel;
                    channelIterator = channelIterator2;
                    c3 = c2;
                    coroutine_suspended = obj2;
                    receiveChannel5 = receiveChannel8;
                    receiveChannel4 = receiveChannel7;
                    channelsKt__Channels_commonKt$toChannel$1 = channelsKt__Channels_commonKt$toChannel$13;
                    if (!((Boolean) obj).booleanValue()) {
                    }
                }
            }
            channelsKt__Channels_commonKt$toChannel$12.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$toChannel$12.L$1 = c2;
            channelsKt__Channels_commonKt$toChannel$12.L$2 = receiveChannel8;
            channelsKt__Channels_commonKt$toChannel$12.L$3 = receiveChannel3;
            channelsKt__Channels_commonKt$toChannel$12.L$4 = th;
            channelsKt__Channels_commonKt$toChannel$12.L$5 = receiveChannel7;
            channelsKt__Channels_commonKt$toChannel$12.L$6 = channelIterator2;
            channelsKt__Channels_commonKt$toChannel$12.label = 1;
            obj = channelIterator2.hasNext(channelsKt__Channels_commonKt$toChannel$12);
            if (obj != obj2) {
            }
        } catch (Throwable th6) {
            th = th6;
            throw th;
        }
        channelsKt__Channels_commonKt$toChannel$1 = new ChannelsKt__Channels_commonKt$toChannel$1(continuation);
        Object obj32 = channelsKt__Channels_commonKt$toChannel$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$toChannel$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0092 A[Catch: all -> 0x00a3, TryCatch #0 {all -> 0x00a3, blocks: (B:72:0x008a, B:74:0x0092, B:68:0x006e, B:75:0x009d), top: B:86:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x009d A[Catch: all -> 0x00a3, TRY_LEAVE, TryCatch #0 {all -> 0x00a3, blocks: (B:72:0x008a, B:74:0x0092, B:68:0x006e, B:75:0x009d), top: B:86:0x008a }] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.util.Collection] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0085 -> B:86:0x008a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, C extends Collection<? super E>> Object toCollection(ReceiveChannel<? extends E> receiveChannel, C c, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$toCollection$1 channelsKt__Channels_commonKt$toCollection$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$toCollection$1 channelsKt__Channels_commonKt$toCollection$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        C c2;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$toCollection$1) {
                channelsKt__Channels_commonKt$toCollection$1 = (ChannelsKt__Channels_commonKt$toCollection$1) continuation;
                if ((channelsKt__Channels_commonKt$toCollection$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$toCollection$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$toCollection$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$toCollection$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            th2 = null;
                            channelsKt__Channels_commonKt$toCollection$12 = channelsKt__Channels_commonKt$toCollection$1;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            c2 = c;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$toCollection$12.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$toCollection$12.L$1 = c2;
                            channelsKt__Channels_commonKt$toCollection$12.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$toCollection$12.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$toCollection$12.L$4 = th2;
                            channelsKt__Channels_commonKt$toCollection$12.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$toCollection$12.L$6 = it;
                            channelsKt__Channels_commonKt$toCollection$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$toCollection$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$toCollection$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$toCollection$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$2;
                        ?? r6 = (Collection) channelsKt__Channels_commonKt$toCollection$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toCollection$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Throwable th5 = th4;
                            c2 = r6;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$toCollection$12 = channelsKt__Channels_commonKt$toCollection$1;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    c2.add(channelIterator2.next());
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$toCollection$12.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$toCollection$12.L$1 = c2;
                                    channelsKt__Channels_commonKt$toCollection$12.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$toCollection$12.L$3 = receiveChannel2;
                                    channelsKt__Channels_commonKt$toCollection$12.L$4 = th2;
                                    channelsKt__Channels_commonKt$toCollection$12.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$toCollection$12.L$6 = it;
                                    channelsKt__Channels_commonKt$toCollection$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$toCollection$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    th5 = th2;
                                    obj3 = obj4;
                                    c2 = c2;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        return c2;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th8;
        }
        channelsKt__Channels_commonKt$toCollection$1 = new ChannelsKt__Channels_commonKt$toCollection$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$toCollection$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$toCollection$1.label;
        if (i != 0) {
        }
    }

    public static final <E> Object toList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<? extends E>> continuation) {
        return ChannelsKt.toMutableList(receiveChannel, continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <K, V> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, Continuation<? super Map<K, ? extends V>> continuation) {
        return ChannelsKt.toMap(receiveChannel, new LinkedHashMap(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0092 A[Catch: all -> 0x00ad, TryCatch #1 {all -> 0x00ad, blocks: (B:72:0x008a, B:74:0x0092, B:68:0x006e, B:75:0x00a7), top: B:88:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a7 A[Catch: all -> 0x00ad, TRY_LEAVE, TryCatch #1 {all -> 0x00ad, blocks: (B:72:0x008a, B:74:0x0092, B:68:0x006e, B:75:0x00a7), top: B:88:0x008a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0085 -> B:88:0x008a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object toMap(ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel, M m, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$toMap$2 channelsKt__Channels_commonKt$toMap$2;
        int i;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$toMap$2 channelsKt__Channels_commonKt$toMap$22;
        Object obj;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel3;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel4;
        ChannelIterator<? extends Pair<? extends K, ? extends V>> it;
        Map map;
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$toMap$2) {
                channelsKt__Channels_commonKt$toMap$2 = (ChannelsKt__Channels_commonKt$toMap$2) continuation;
                if ((channelsKt__Channels_commonKt$toMap$2.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$toMap$2.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$toMap$2.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$toMap$2.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            th2 = null;
                            channelsKt__Channels_commonKt$toMap$22 = channelsKt__Channels_commonKt$toMap$2;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            map = m;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$toMap$22.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$toMap$22.L$1 = map;
                            channelsKt__Channels_commonKt$toMap$22.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$toMap$22.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$toMap$22.L$4 = th2;
                            channelsKt__Channels_commonKt$toMap$22.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$toMap$22.L$6 = it;
                            channelsKt__Channels_commonKt$toMap$22.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$toMap$22);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$toMap$2.L$6;
                        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$toMap$2.L$4;
                        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$3;
                        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$2;
                        Map map2 = (Map) channelsKt__Channels_commonKt$toMap$2.L$1;
                        ReceiveChannel<? extends Pair<? extends K, ? extends V>> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$toMap$2.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Throwable th5 = th4;
                            map = map2;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$toMap$22 = channelsKt__Channels_commonKt$toMap$2;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends Pair<? extends K, ? extends V>> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    Pair<? extends K, ? extends V> next = channelIterator2.next();
                                    map.put(next.getFirst(), next.getSecond());
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$toMap$22.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$toMap$22.L$1 = map;
                                    channelsKt__Channels_commonKt$toMap$22.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$toMap$22.L$3 = receiveChannel2;
                                    channelsKt__Channels_commonKt$toMap$22.L$4 = th2;
                                    channelsKt__Channels_commonKt$toMap$22.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$toMap$22.L$6 = it;
                                    channelsKt__Channels_commonKt$toMap$22.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$toMap$22);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    th5 = th2;
                                    obj3 = obj4;
                                    map = map;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        return map;
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th8;
        }
        channelsKt__Channels_commonKt$toMap$2 = new ChannelsKt__Channels_commonKt$toMap$2(continuation);
        Object obj22 = channelsKt__Channels_commonKt$toMap$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$toMap$2.label;
        if (i != 0) {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object toMutableList(ReceiveChannel<? extends E> receiveChannel, Continuation<? super List<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new ArrayList(), continuation);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object toSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<? extends E>> continuation) {
        return ChannelsKt.toMutableSet(receiveChannel, continuation);
    }

    public static /* synthetic */ ReceiveChannel flatMap$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.flatMap(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> flatMap(ReceiveChannel<? extends E> flatMap, CoroutineContext context, Function2<? super E, ? super Continuation<? super ReceiveChannel<? extends R>>, ? extends Object> transform) {
        Intrinsics.checkParameterIsNotNull(flatMap, "$this$flatMap");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(flatMap), new ChannelsKt__Channels_commonKt$flatMap$1(flatMap, transform, null), 2, null);
    }

    /* JADX DEBUG: Type inference failed for r0v15. Raw type applied. Possible types: ? super E */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ae A[Catch: all -> 0x00d7, TryCatch #0 {all -> 0x00d7, blocks: (B:76:0x00a6, B:78:0x00ae, B:80:0x00bc, B:81:0x00c4, B:72:0x0088, B:82:0x00cb), top: B:94:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00cb A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #0 {all -> 0x00d7, blocks: (B:76:0x00a6, B:78:0x00ae, B:80:0x00bc, B:81:0x00c4, B:72:0x0088, B:82:0x00cb), top: B:94:0x00a6 }] */
    /* JADX WARN: Type inference failed for: r14v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r9v4, types: [java.util.Map] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00a3 -> B:94:0x00a6). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K> Object groupBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Continuation<? super Map<K, ? extends List<? extends E>>> continuation) {
        ChannelsKt__Channels_commonKt$groupBy$1 channelsKt__Channels_commonKt$groupBy$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Function1<? super E, ? extends K> function12;
        LinkedHashMap linkedHashMap;
        ChannelsKt__Channels_commonKt$groupBy$1 channelsKt__Channels_commonKt$groupBy$12;
        Object obj;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th2;
        Object hasNext;
        ChannelIterator<? extends E> channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$groupBy$1) {
            channelsKt__Channels_commonKt$groupBy$1 = (ChannelsKt__Channels_commonKt$groupBy$1) continuation;
            if ((channelsKt__Channels_commonKt$groupBy$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$groupBy$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$groupBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$groupBy$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th3 = null;
                    try {
                        function12 = function1;
                        linkedHashMap = new LinkedHashMap();
                        channelsKt__Channels_commonKt$groupBy$12 = channelsKt__Channels_commonKt$groupBy$1;
                        obj = coroutine_suspended;
                        th = th3;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel5 = receiveChannel4;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel6 = receiveChannel2;
                        channelsKt__Channels_commonKt$groupBy$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$groupBy$12.L$1 = function12;
                        channelsKt__Channels_commonKt$groupBy$12.L$2 = receiveChannel4;
                        channelsKt__Channels_commonKt$groupBy$12.L$3 = linkedHashMap;
                        channelsKt__Channels_commonKt$groupBy$12.L$4 = receiveChannel5;
                        channelsKt__Channels_commonKt$groupBy$12.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$groupBy$12.L$6 = th;
                        channelsKt__Channels_commonKt$groupBy$12.L$7 = receiveChannel6;
                        channelsKt__Channels_commonKt$groupBy$12.L$8 = it;
                        channelsKt__Channels_commonKt$groupBy$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$groupBy$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$groupBy$1.L$8;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$7;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$groupBy$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$4;
                    ?? r9 = (Map) channelsKt__Channels_commonKt$groupBy$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$2;
                    Function1<? super E, ? extends K> function13 = (Function1) channelsKt__Channels_commonKt$groupBy$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$groupBy$12 = channelsKt__Channels_commonKt$groupBy$1;
                        receiveChannel4 = receiveChannel9;
                        th = th5;
                        function12 = function13;
                        linkedHashMap = r9;
                        channelIterator = channelIterator2;
                        receiveChannel2 = receiveChannel7;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel8;
                    } catch (Throwable th6) {
                        th2 = th6;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th2;
                        } finally {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(1);
                        }
                    }
                    try {
                        if (((Boolean) obj2).booleanValue()) {
                            Object obj3 = (Object) channelIterator.next();
                            K invoke = function12.invoke(obj3);
                            Object obj4 = linkedHashMap.get(invoke);
                            if (obj4 == null) {
                                obj4 = new ArrayList();
                                linkedHashMap.put(invoke, obj4);
                            }
                            ((List) obj4).add(obj3);
                            receiveChannel3 = receiveChannel10;
                            it = channelIterator;
                            channelsKt__Channels_commonKt$groupBy$12.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$groupBy$12.L$1 = function12;
                            channelsKt__Channels_commonKt$groupBy$12.L$2 = receiveChannel4;
                            channelsKt__Channels_commonKt$groupBy$12.L$3 = linkedHashMap;
                            channelsKt__Channels_commonKt$groupBy$12.L$4 = receiveChannel5;
                            channelsKt__Channels_commonKt$groupBy$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$groupBy$12.L$6 = th;
                            channelsKt__Channels_commonKt$groupBy$12.L$7 = receiveChannel6;
                            channelsKt__Channels_commonKt$groupBy$12.L$8 = it;
                            channelsKt__Channels_commonKt$groupBy$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$groupBy$12);
                            if (hasNext != obj) {
                                return obj;
                            }
                            receiveChannel10 = receiveChannel3;
                            obj2 = hasNext;
                            channelIterator = it;
                            if (((Boolean) obj2).booleanValue()) {
                            }
                        } else {
                            Unit unit = Unit.INSTANCE;
                            return linkedHashMap;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        th2 = th;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$groupBy$1 = new ChannelsKt__Channels_commonKt$groupBy$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$groupBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$groupBy$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object groupBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    Object invoke = function1.invoke(next);
                    Object obj = linkedHashMap.get(invoke);
                    if (obj == null) {
                        obj = new ArrayList();
                        linkedHashMap.put(invoke, obj);
                    }
                    ((List) obj).add(next);
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return linkedHashMap;
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00aa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b8 A[Catch: all -> 0x00e5, TryCatch #1 {all -> 0x00e5, blocks: (B:76:0x00b0, B:78:0x00b8, B:80:0x00c6, B:81:0x00ce, B:72:0x008e, B:82:0x00d9), top: B:96:0x00b0 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00d9 A[Catch: all -> 0x00e5, TRY_LEAVE, TryCatch #1 {all -> 0x00e5, blocks: (B:76:0x00b0, B:78:0x00b8, B:80:0x00c6, B:81:0x00ce, B:72:0x008e, B:82:0x00d9), top: B:96:0x00b0 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00ab -> B:96:0x00b0). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K, V> Object groupBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        ChannelsKt__Channels_commonKt$groupBy$2 channelsKt__Channels_commonKt$groupBy$2;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Function1<? super E, ? extends K> function13;
        Function1<? super E, ? extends V> function14;
        Map linkedHashMap;
        ChannelsKt__Channels_commonKt$groupBy$2 channelsKt__Channels_commonKt$groupBy$22;
        Object obj;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$groupBy$2) {
            channelsKt__Channels_commonKt$groupBy$2 = (ChannelsKt__Channels_commonKt$groupBy$2) continuation;
            if ((channelsKt__Channels_commonKt$groupBy$2.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$groupBy$2.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$groupBy$2.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$groupBy$2.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Throwable th3 = null;
                    try {
                        function13 = function1;
                        function14 = function12;
                        linkedHashMap = new LinkedHashMap();
                        channelsKt__Channels_commonKt$groupBy$22 = channelsKt__Channels_commonKt$groupBy$2;
                        obj = coroutine_suspended;
                        th = th3;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel5 = receiveChannel4;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel6 = receiveChannel2;
                        channelsKt__Channels_commonKt$groupBy$22.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$groupBy$22.L$1 = function13;
                        channelsKt__Channels_commonKt$groupBy$22.L$2 = function14;
                        channelsKt__Channels_commonKt$groupBy$22.L$3 = receiveChannel4;
                        channelsKt__Channels_commonKt$groupBy$22.L$4 = linkedHashMap;
                        channelsKt__Channels_commonKt$groupBy$22.L$5 = receiveChannel5;
                        channelsKt__Channels_commonKt$groupBy$22.L$6 = receiveChannel2;
                        channelsKt__Channels_commonKt$groupBy$22.L$7 = th;
                        channelsKt__Channels_commonKt$groupBy$22.L$8 = receiveChannel6;
                        channelsKt__Channels_commonKt$groupBy$22.L$9 = it;
                        channelsKt__Channels_commonKt$groupBy$22.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$groupBy$22);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$groupBy$2.L$9;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$8;
                    Throwable th5 = (Throwable) channelsKt__Channels_commonKt$groupBy$2.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$5;
                    Map map = (Map) channelsKt__Channels_commonKt$groupBy$2.L$4;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$3;
                    Function1<? super E, ? extends V> function15 = (Function1) channelsKt__Channels_commonKt$groupBy$2.L$2;
                    Function1<? super E, ? extends K> function16 = (Function1) channelsKt__Channels_commonKt$groupBy$2.L$1;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$groupBy$2.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$groupBy$22 = channelsKt__Channels_commonKt$groupBy$2;
                        receiveChannel4 = receiveChannel9;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        receiveChannel2 = receiveChannel7;
                        function14 = function15;
                        th = th5;
                        function13 = function16;
                        linkedHashMap = map;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel8;
                        try {
                            if (((Boolean) obj2).booleanValue()) {
                                Object obj3 = (Object) channelIterator2.next();
                                K invoke = function13.invoke(obj3);
                                Object obj4 = linkedHashMap.get(invoke);
                                if (obj4 == null) {
                                    obj4 = new ArrayList();
                                    linkedHashMap.put(invoke, obj4);
                                }
                                ((List) obj4).add(function14.invoke(obj3));
                                receiveChannel3 = receiveChannel10;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$groupBy$22.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$groupBy$22.L$1 = function13;
                                channelsKt__Channels_commonKt$groupBy$22.L$2 = function14;
                                channelsKt__Channels_commonKt$groupBy$22.L$3 = receiveChannel4;
                                channelsKt__Channels_commonKt$groupBy$22.L$4 = linkedHashMap;
                                channelsKt__Channels_commonKt$groupBy$22.L$5 = receiveChannel5;
                                channelsKt__Channels_commonKt$groupBy$22.L$6 = receiveChannel2;
                                channelsKt__Channels_commonKt$groupBy$22.L$7 = th;
                                channelsKt__Channels_commonKt$groupBy$22.L$8 = receiveChannel6;
                                channelsKt__Channels_commonKt$groupBy$22.L$9 = it;
                                channelsKt__Channels_commonKt$groupBy$22.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$groupBy$22);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel10 = receiveChannel3;
                                obj2 = hasNext;
                                channelIterator2 = it;
                                linkedHashMap = linkedHashMap;
                                if (((Boolean) obj2).booleanValue()) {
                                }
                            } else {
                                Unit unit = Unit.INSTANCE;
                                return linkedHashMap;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            th2 = th;
                            try {
                                throw th2;
                            } finally {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                InlineMarker.finallyEnd(1);
                            }
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$groupBy$2 = new ChannelsKt__Channels_commonKt$groupBy$2(continuation);
        Object obj22 = channelsKt__Channels_commonKt$groupBy$2.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$groupBy$2.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object groupBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Function1 function12, Continuation continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    Object invoke = function1.invoke(next);
                    Object obj = linkedHashMap.get(invoke);
                    if (obj == null) {
                        obj = new ArrayList();
                        linkedHashMap.put(invoke, obj);
                    }
                    ((List) obj).add(function12.invoke(next));
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return linkedHashMap;
                }
            }
        } finally {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0099 A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:62:0x0046, B:75:0x0091, B:77:0x0099, B:79:0x00a7, B:80:0x00af, B:81:0x00b9), top: B:92:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b9 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:62:0x0046, B:75:0x0091, B:77:0x0099, B:79:0x00a7, B:80:0x00af, B:81:0x00b9), top: B:92:0x0046 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x008b -> B:75:0x0091). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K, M extends Map<? super K, List<E>>> Object groupByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$groupByTo$1 channelsKt__Channels_commonKt$groupByTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$groupByTo$1 channelsKt__Channels_commonKt$groupByTo$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Map map;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        Function1<? super E, ? extends K> function12;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        Object obj2;
        Object obj3;
        if (continuation instanceof ChannelsKt__Channels_commonKt$groupByTo$1) {
            channelsKt__Channels_commonKt$groupByTo$1 = (ChannelsKt__Channels_commonKt$groupByTo$1) continuation;
            if ((channelsKt__Channels_commonKt$groupByTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$groupByTo$1.label -= Integer.MIN_VALUE;
                Object obj4 = channelsKt__Channels_commonKt$groupByTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$groupByTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj4);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$groupByTo$12 = channelsKt__Channels_commonKt$groupByTo$1;
                        obj = coroutine_suspended;
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        map = m;
                        receiveChannel5 = receiveChannel4;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel6 = receiveChannel5;
                        channelsKt__Channels_commonKt$groupByTo$12.L$0 = receiveChannel5;
                        channelsKt__Channels_commonKt$groupByTo$12.L$1 = map;
                        channelsKt__Channels_commonKt$groupByTo$12.L$2 = function12;
                        channelsKt__Channels_commonKt$groupByTo$12.L$3 = receiveChannel6;
                        channelsKt__Channels_commonKt$groupByTo$12.L$4 = receiveChannel3;
                        channelsKt__Channels_commonKt$groupByTo$12.L$5 = th2;
                        channelsKt__Channels_commonKt$groupByTo$12.L$6 = receiveChannel4;
                        channelsKt__Channels_commonKt$groupByTo$12.L$7 = it;
                        channelsKt__Channels_commonKt$groupByTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$groupByTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$groupByTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$groupByTo$1.L$5;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$1.L$3;
                    Function1<? super E, ? extends K> function13 = (Function1) channelsKt__Channels_commonKt$groupByTo$1.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$groupByTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj4);
                        ChannelsKt__Channels_commonKt$groupByTo$1 channelsKt__Channels_commonKt$groupByTo$13 = channelsKt__Channels_commonKt$groupByTo$1;
                        receiveChannel4 = receiveChannel7;
                        receiveChannel5 = receiveChannel9;
                        Object obj5 = coroutine_suspended;
                        map = map2;
                        ChannelsKt__Channels_commonKt$groupByTo$1 channelsKt__Channels_commonKt$groupByTo$14 = channelsKt__Channels_commonKt$groupByTo$13;
                        th2 = th4;
                        receiveChannel6 = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (((Boolean) obj4).booleanValue()) {
                            try {
                                obj2 = (Object) channelIterator2.next();
                                K invoke = function13.invoke(obj2);
                                obj3 = map.get(invoke);
                                if (obj3 == null) {
                                    obj3 = new ArrayList();
                                    map.put(invoke, obj3);
                                }
                                channelsKt__Channels_commonKt$groupByTo$12.L$0 = receiveChannel5;
                                channelsKt__Channels_commonKt$groupByTo$12.L$1 = map;
                                channelsKt__Channels_commonKt$groupByTo$12.L$2 = function12;
                                channelsKt__Channels_commonKt$groupByTo$12.L$3 = receiveChannel6;
                                channelsKt__Channels_commonKt$groupByTo$12.L$4 = receiveChannel3;
                                channelsKt__Channels_commonKt$groupByTo$12.L$5 = th2;
                                channelsKt__Channels_commonKt$groupByTo$12.L$6 = receiveChannel4;
                                channelsKt__Channels_commonKt$groupByTo$12.L$7 = it;
                                channelsKt__Channels_commonKt$groupByTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$groupByTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Function1<? super E, ? extends K> function14 = function12;
                                receiveChannel2 = receiveChannel3;
                                obj4 = hasNext;
                                obj5 = obj;
                                channelsKt__Channels_commonKt$groupByTo$14 = channelsKt__Channels_commonKt$groupByTo$12;
                                function13 = function14;
                                map = map;
                                channelIterator2 = it;
                                if (((Boolean) obj4).booleanValue()) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                receiveChannel2 = receiveChannel3;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    throw th6;
                                }
                            }
                            ((List) obj3).add(obj2);
                            receiveChannel3 = receiveChannel2;
                            function12 = function13;
                            channelsKt__Channels_commonKt$groupByTo$12 = channelsKt__Channels_commonKt$groupByTo$14;
                            obj = obj5;
                            it = channelIterator2;
                        } else {
                            Unit unit = Unit.INSTANCE;
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(1);
                            return map;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$groupByTo$1 = new ChannelsKt__Channels_commonKt$groupByTo$1(continuation);
        Object obj42 = channelsKt__Channels_commonKt$groupByTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$groupByTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ad A[Catch: all -> 0x00da, TryCatch #2 {all -> 0x00da, blocks: (B:76:0x00a5, B:78:0x00ad, B:80:0x00bb, B:81:0x00c3, B:72:0x0087, B:82:0x00ce), top: B:98:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00ce A[Catch: all -> 0x00da, TRY_LEAVE, TryCatch #2 {all -> 0x00da, blocks: (B:76:0x00a5, B:78:0x00ad, B:80:0x00bb, B:81:0x00c3, B:72:0x0087, B:82:0x00ce), top: B:98:0x00a5 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00a2 -> B:98:0x00a5). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, K, V, M extends Map<? super K, List<V>>> Object groupByTo(ReceiveChannel<? extends E> receiveChannel, M m, Function1<? super E, ? extends K> function1, Function1<? super E, ? extends V> function12, Continuation<? super M> continuation) {
        ChannelsKt__Channels_commonKt$groupByTo$3 channelsKt__Channels_commonKt$groupByTo$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Map map;
        Function1<? super E, ? extends K> function13;
        Function1<? super E, ? extends V> function14;
        Throwable th;
        ChannelsKt__Channels_commonKt$groupByTo$3 channelsKt__Channels_commonKt$groupByTo$32;
        Object obj;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$groupByTo$3) {
            channelsKt__Channels_commonKt$groupByTo$3 = (ChannelsKt__Channels_commonKt$groupByTo$3) continuation;
            if ((channelsKt__Channels_commonKt$groupByTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$groupByTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$groupByTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$groupByTo$3.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        map = m;
                        function13 = function1;
                        function14 = function12;
                        th = null;
                        channelsKt__Channels_commonKt$groupByTo$32 = channelsKt__Channels_commonKt$groupByTo$3;
                        obj = coroutine_suspended;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel2 = receiveChannel4;
                        receiveChannel5 = receiveChannel2;
                        channelsKt__Channels_commonKt$groupByTo$32.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$groupByTo$32.L$1 = map;
                        channelsKt__Channels_commonKt$groupByTo$32.L$2 = function13;
                        channelsKt__Channels_commonKt$groupByTo$32.L$3 = function14;
                        channelsKt__Channels_commonKt$groupByTo$32.L$4 = receiveChannel4;
                        channelsKt__Channels_commonKt$groupByTo$32.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$groupByTo$32.L$6 = th;
                        channelsKt__Channels_commonKt$groupByTo$32.L$7 = receiveChannel5;
                        channelsKt__Channels_commonKt$groupByTo$32.L$8 = it;
                        channelsKt__Channels_commonKt$groupByTo$32.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$groupByTo$32);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$groupByTo$3.L$8;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$3.L$7;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$groupByTo$3.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$3.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$3.L$4;
                    Function1<? super E, ? extends V> function15 = (Function1) channelsKt__Channels_commonKt$groupByTo$3.L$3;
                    Function1<? super E, ? extends K> function16 = (Function1) channelsKt__Channels_commonKt$groupByTo$3.L$2;
                    Map map2 = (Map) channelsKt__Channels_commonKt$groupByTo$3.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$groupByTo$3.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$groupByTo$32 = channelsKt__Channels_commonKt$groupByTo$3;
                        receiveChannel4 = receiveChannel8;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel7;
                        function14 = function15;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        receiveChannel5 = receiveChannel6;
                        map = map2;
                        th = th4;
                        function13 = function16;
                        try {
                            if (((Boolean) obj2).booleanValue()) {
                                Object obj3 = (Object) channelIterator2.next();
                                K invoke = function13.invoke(obj3);
                                Object obj4 = map.get(invoke);
                                if (obj4 == null) {
                                    obj4 = new ArrayList();
                                    map.put(invoke, obj4);
                                }
                                ((List) obj4).add(function14.invoke(obj3));
                                receiveChannel3 = receiveChannel9;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$groupByTo$32.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$groupByTo$32.L$1 = map;
                                channelsKt__Channels_commonKt$groupByTo$32.L$2 = function13;
                                channelsKt__Channels_commonKt$groupByTo$32.L$3 = function14;
                                channelsKt__Channels_commonKt$groupByTo$32.L$4 = receiveChannel4;
                                channelsKt__Channels_commonKt$groupByTo$32.L$5 = receiveChannel2;
                                channelsKt__Channels_commonKt$groupByTo$32.L$6 = th;
                                channelsKt__Channels_commonKt$groupByTo$32.L$7 = receiveChannel5;
                                channelsKt__Channels_commonKt$groupByTo$32.L$8 = it;
                                channelsKt__Channels_commonKt$groupByTo$32.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$groupByTo$32);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel9 = receiveChannel3;
                                obj2 = hasNext;
                                map = map;
                                channelIterator2 = it;
                                if (((Boolean) obj2).booleanValue()) {
                                }
                            } else {
                                Unit unit = Unit.INSTANCE;
                                return map;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            try {
                                throw th2;
                            } finally {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                InlineMarker.finallyEnd(1);
                            }
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        receiveChannel2 = receiveChannel7;
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$groupByTo$3 = new ChannelsKt__Channels_commonKt$groupByTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$groupByTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$groupByTo$3.label;
        if (i != 0) {
        }
    }

    public static /* synthetic */ ReceiveChannel map$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.map(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> map(ReceiveChannel<? extends E> map, CoroutineContext context, Function2<? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        Intrinsics.checkParameterIsNotNull(map, "$this$map");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(map), new ChannelsKt__Channels_commonKt$map$1(map, transform, null), 2, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexed$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexed(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> mapIndexed(ReceiveChannel<? extends E> mapIndexed, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        Intrinsics.checkParameterIsNotNull(mapIndexed, "$this$mapIndexed");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(mapIndexed), new ChannelsKt__Channels_commonKt$mapIndexed$1(mapIndexed, transform, null), 2, null);
    }

    public static /* synthetic */ ReceiveChannel mapIndexedNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapIndexedNotNull(receiveChannel, coroutineContext, function3);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> mapIndexedNotNull(ReceiveChannel<? extends E> mapIndexedNotNull, CoroutineContext context, Function3<? super Integer, ? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        Intrinsics.checkParameterIsNotNull(mapIndexedNotNull, "$this$mapIndexedNotNull");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ChannelsKt.filterNotNull(ChannelsKt.mapIndexed(mapIndexedNotNull, context, transform));
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00b9 A[Catch: all -> 0x00f1, TryCatch #0 {all -> 0x00f1, blocks: (B:76:0x00b1, B:78:0x00b9, B:80:0x00da, B:72:0x008f, B:82:0x00e4), top: B:94:0x00b1 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e4 A[Catch: all -> 0x00f1, TRY_LEAVE, TryCatch #0 {all -> 0x00f1, blocks: (B:76:0x00b1, B:78:0x00b9, B:80:0x00da, B:72:0x008f, B:82:0x00e4), top: B:94:0x00b1 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x00ac -> B:94:0x00b1). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R, C extends Collection<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1 channelsKt__Channels_commonKt$mapIndexedNotNullTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Collection collection;
        Function2<? super Integer, ? super E, ? extends R> function22;
        Ref.IntRef intRef;
        ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1 channelsKt__Channels_commonKt$mapIndexedNotNullTo$12;
        Object obj;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        ReceiveChannel<? extends E> receiveChannel6;
        Throwable th2;
        Object hasNext;
        ChannelIterator<? extends E> channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1) {
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$1 = (ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1) continuation;
            if ((channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        collection = c;
                        function22 = function2;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1;
                        obj = coroutine_suspended;
                        th = null;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel5 = receiveChannel4;
                        receiveChannel2 = receiveChannel5;
                        receiveChannel6 = receiveChannel2;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$1 = collection;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$2 = function22;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$3 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$4 = intRef;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$5 = receiveChannel5;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$6 = receiveChannel2;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$7 = th;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$8 = receiveChannel6;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$9 = it;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.label = i2;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$9;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$8;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$5;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$3;
                    Function2<? super Integer, ? super E, ? extends R> function23 = (Function2) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$12 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1;
                        receiveChannel4 = receiveChannel9;
                        channelIterator = channelIterator2;
                        receiveChannel2 = receiveChannel7;
                        function22 = function23;
                        th = th4;
                        collection = collection2;
                        intRef = intRef3;
                        obj = coroutine_suspended;
                        receiveChannel5 = receiveChannel8;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th2;
                        } finally {
                            int i3 = 1;
                            InlineMarker.finallyStart(i3);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(i3);
                        }
                    }
                    try {
                        if (!((Boolean) obj2).booleanValue()) {
                            E next = channelIterator.next();
                            int i4 = intRef.element;
                            intRef.element = i4 + 1;
                            IndexedValue indexedValue = new IndexedValue(i4, next);
                            R invoke = function22.invoke(Boxing.boxInt(indexedValue.component1()), (Object) indexedValue.component2());
                            if (invoke != null) {
                                Boxing.boxBoolean(collection.add(invoke));
                            }
                            receiveChannel3 = receiveChannel10;
                            i2 = 1;
                            it = channelIterator;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$1 = collection;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$2 = function22;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$3 = receiveChannel4;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$4 = intRef;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$5 = receiveChannel5;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$6 = receiveChannel2;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$7 = th;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$8 = receiveChannel6;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.L$9 = it;
                            channelsKt__Channels_commonKt$mapIndexedNotNullTo$12.label = i2;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$12);
                            if (hasNext != obj) {
                                return obj;
                            }
                            receiveChannel10 = receiveChannel3;
                            obj2 = hasNext;
                            collection = collection;
                            channelIterator = it;
                            if (!((Boolean) obj2).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                return collection;
                            }
                        }
                    } catch (Throwable th6) {
                        th = th6;
                        th2 = th;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$mapIndexedNotNullTo$1 = new ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapIndexedNotNullTo$1.label;
        int i22 = 1;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Type inference failed for r5v3. Raw type applied. Possible types: ? super E, java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00a4: MOVE  (r3 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:80:0x00a3 */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100 A[Catch: all -> 0x0187, TryCatch #1 {all -> 0x0187, blocks: (B:84:0x00c8, B:88:0x00f8, B:90:0x0100, B:92:0x0123, B:99:0x017a), top: B:112:0x00c8 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x017a A[Catch: all -> 0x0187, TRY_LEAVE, TryCatch #1 {all -> 0x0187, blocks: (B:84:0x00c8, B:88:0x00f8, B:90:0x0100, B:92:0x0123, B:99:0x017a), top: B:112:0x00c8 }] */
    /* JADX WARN: Type inference failed for: r13v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:98:0x0175 -> B:112:0x00c8). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3 channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Ref.IntRef intRef;
        ReceiveChannel<? extends E> receiveChannel6;
        Function2<? super Integer, ? super E, ? extends R> function22;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelIterator<? extends E> channelIterator;
        C c2;
        Throwable th3;
        Throwable th4;
        Object obj;
        ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3 channelsKt__Channels_commonKt$mapIndexedNotNullTo$32;
        Ref.IntRef intRef2;
        Function2<? super Integer, ? super E, ? extends R> function23;
        C c3;
        ReceiveChannel<? extends E> receiveChannel8;
        ReceiveChannel<? extends E> receiveChannel9;
        ReceiveChannel<? extends E> receiveChannel10;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3) {
            channelsKt__Channels_commonKt$mapIndexedNotNullTo$3 = (ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3) continuation;
            if ((channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label;
                int i2 = 1;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef3 = new Ref.IntRef();
                    intRef3.element = 0;
                    try {
                        c3 = c;
                        function23 = function2;
                        intRef2 = intRef3;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
                        obj = coroutine_suspended;
                        th4 = null;
                        channelIterator = receiveChannel.iterator();
                        receiveChannel10 = receiveChannel;
                        receiveChannel9 = receiveChannel10;
                        receiveChannel8 = receiveChannel9;
                        receiveChannel3 = receiveChannel8;
                        receiveChannel4 = receiveChannel3;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$0 = receiveChannel10;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$1 = c3;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$2 = function23;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$3 = receiveChannel9;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$4 = intRef2;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$5 = receiveChannel8;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$7 = th4;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$8 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$9 = channelIterator;
                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.label = i2;
                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$32);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th5) {
                        th3 = th5;
                        receiveChannel3 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else {
                    try {
                        if (i == 1) {
                            ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$9;
                            receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$8;
                            th2 = (Throwable) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$7;
                            ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$6;
                            receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$5;
                            intRef = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$4;
                            receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$3;
                            function22 = (Function2) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$2;
                            ?? r13 = (SendChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$1;
                            receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$0;
                            ResultKt.throwOnFailure(obj2);
                            channelIterator = channelIterator2;
                            receiveChannel3 = receiveChannel11;
                            c2 = r13;
                            if (!((Boolean) obj2).booleanValue()) {
                            }
                        } else if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        } else {
                            Object obj3 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$14;
                            Object obj4 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$13;
                            int i3 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.I$0;
                            IndexedValue indexedValue = (IndexedValue) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$12;
                            Object obj5 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$11;
                            Object obj6 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$10;
                            ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$9;
                            receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$8;
                            th2 = (Throwable) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$7;
                            ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$6;
                            receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$5;
                            intRef = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$4;
                            receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$3;
                            function22 = (Function2) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$2;
                            Object obj7 = (SendChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$1;
                            receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$0;
                            ResultKt.throwOnFailure(obj2);
                            char c4 = 2;
                            try {
                                Ref.IntRef intRef4 = intRef;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
                                receiveChannel9 = receiveChannel6;
                                obj = coroutine_suspended;
                                receiveChannel8 = receiveChannel5;
                                intRef2 = intRef4;
                                C c5 = obj7;
                                channelIterator = channelIterator3;
                                receiveChannel3 = receiveChannel12;
                                function23 = function22;
                                th4 = th2;
                                c3 = c5;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$0 = receiveChannel10;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$1 = c3;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$2 = function23;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$3 = receiveChannel9;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$4 = intRef2;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$5 = receiveChannel8;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$7 = th4;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$8 = receiveChannel4;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$9 = channelIterator;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.label = i2;
                                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$32);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel7 = receiveChannel10;
                                obj2 = hasNext;
                                Object obj8 = obj;
                                receiveChannel6 = receiveChannel9;
                                channelsKt__Channels_commonKt$mapIndexedNotNullTo$3 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$32;
                                intRef = intRef2;
                                receiveChannel5 = receiveChannel8;
                                coroutine_suspended = obj8;
                                Function2<? super Integer, ? super E, ? extends R> function24 = function23;
                                c2 = c3;
                                th2 = th4;
                                function22 = function24;
                                if (!((Boolean) obj2).booleanValue()) {
                                    E next = channelIterator.next();
                                    int i4 = intRef.element;
                                    intRef.element = i4 + 1;
                                    IndexedValue indexedValue2 = new IndexedValue(i4, next);
                                    int component1 = indexedValue2.component1();
                                    Object obj9 = (Object) indexedValue2.component2();
                                    Object obj10 = coroutine_suspended;
                                    R invoke = function22.invoke(Boxing.boxInt(component1), obj9);
                                    if (invoke != null) {
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$0 = receiveChannel7;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$1 = c2;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$2 = function22;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$3 = receiveChannel6;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$4 = intRef;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$5 = receiveChannel5;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$6 = receiveChannel3;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$7 = th2;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$8 = receiveChannel4;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$9 = channelIterator;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$10 = next;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$11 = next;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$12 = indexedValue2;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.I$0 = component1;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$13 = obj9;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.L$14 = invoke;
                                        c4 = 2;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label = 2;
                                        if (c2.send(invoke, channelsKt__Channels_commonKt$mapIndexedNotNullTo$3) == obj10) {
                                            return obj10;
                                        }
                                        coroutine_suspended = obj10;
                                        Object obj11 = c2;
                                        receiveChannel12 = receiveChannel3;
                                        channelIterator3 = channelIterator;
                                        obj7 = obj11;
                                        Ref.IntRef intRef42 = intRef;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
                                        receiveChannel9 = receiveChannel6;
                                        obj = coroutine_suspended;
                                        receiveChannel8 = receiveChannel5;
                                        intRef2 = intRef42;
                                        C c52 = obj7;
                                        channelIterator = channelIterator3;
                                        receiveChannel3 = receiveChannel12;
                                        function23 = function22;
                                        th4 = th2;
                                        c3 = c52;
                                        receiveChannel10 = receiveChannel7;
                                        i2 = 1;
                                        channelIterator = channelIterator;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$0 = receiveChannel10;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$1 = c3;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$2 = function23;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$3 = receiveChannel9;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$4 = intRef2;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$5 = receiveChannel8;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$6 = receiveChannel3;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$7 = th4;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$8 = receiveChannel4;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$9 = channelIterator;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.label = i2;
                                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$32);
                                        if (hasNext != obj) {
                                        }
                                    } else {
                                        c4 = 2;
                                        receiveChannel8 = receiveChannel5;
                                        intRef2 = intRef;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3;
                                        receiveChannel9 = receiveChannel6;
                                        obj = obj10;
                                        Function2<? super Integer, ? super E, ? extends R> function25 = function22;
                                        th4 = th2;
                                        c3 = c2;
                                        function23 = function25;
                                        receiveChannel10 = receiveChannel7;
                                        i2 = 1;
                                        channelIterator = channelIterator;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$0 = receiveChannel10;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$1 = c3;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$2 = function23;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$3 = receiveChannel9;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$4 = intRef2;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$5 = receiveChannel8;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$6 = receiveChannel3;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$7 = th4;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$8 = receiveChannel4;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.L$9 = channelIterator;
                                        channelsKt__Channels_commonKt$mapIndexedNotNullTo$32.label = i2;
                                        hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$mapIndexedNotNullTo$32);
                                        if (hasNext != obj) {
                                        }
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    return c2;
                                }
                            } catch (Throwable th6) {
                                th3 = th6;
                                th = th3;
                                try {
                                    throw th;
                                } finally {
                                    int i5 = 1;
                                    InlineMarker.finallyStart(i5);
                                    ChannelsKt.cancelConsumed(receiveChannel3, th);
                                    InlineMarker.finallyEnd(i5);
                                }
                            }
                            receiveChannel10 = receiveChannel7;
                            i2 = 1;
                            channelIterator = channelIterator;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel3 = receiveChannel2;
                        throw th;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$mapIndexedNotNullTo$3 = new ChannelsKt__Channels_commonKt$mapIndexedNotNullTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapIndexedNotNullTo$3.label;
        int i22 = 1;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b4 A[Catch: all -> 0x00d7, TryCatch #1 {all -> 0x00d7, blocks: (B:73:0x00ac, B:75:0x00b4, B:69:0x008e, B:76:0x00cb), top: B:90:0x00ac }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00cb A[Catch: all -> 0x00d7, TRY_LEAVE, TryCatch #1 {all -> 0x00d7, blocks: (B:73:0x00ac, B:75:0x00b4, B:69:0x008e, B:76:0x00cb), top: B:90:0x00ac }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x00a9 -> B:90:0x00ac). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R, C extends Collection<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexedTo$1 channelsKt__Channels_commonKt$mapIndexedTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Function2<? super Integer, ? super E, ? extends R> function22;
        Ref.IntRef intRef;
        ChannelsKt__Channels_commonKt$mapIndexedTo$1 channelsKt__Channels_commonKt$mapIndexedTo$12;
        Object obj;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Collection collection;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapIndexedTo$1) {
            channelsKt__Channels_commonKt$mapIndexedTo$1 = (ChannelsKt__Channels_commonKt$mapIndexedTo$1) continuation;
            if ((channelsKt__Channels_commonKt$mapIndexedTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapIndexedTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapIndexedTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapIndexedTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    try {
                        function22 = function2;
                        intRef = intRef2;
                        channelsKt__Channels_commonKt$mapIndexedTo$12 = channelsKt__Channels_commonKt$mapIndexedTo$1;
                        obj = coroutine_suspended;
                        th = null;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel2 = receiveChannel4;
                        receiveChannel5 = receiveChannel2;
                        collection = c;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$1 = collection;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$2 = function22;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$3 = intRef;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$4 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$6 = th;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$7 = receiveChannel5;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.L$8 = it;
                        channelsKt__Channels_commonKt$mapIndexedTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$mapIndexedTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedTo$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$1.L$7;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$mapIndexedTo$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$1.L$4;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedTo$1.L$3;
                    Function2<? super Integer, ? super E, ? extends R> function23 = (Function2) channelsKt__Channels_commonKt$mapIndexedTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$mapIndexedTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$mapIndexedTo$12 = channelsKt__Channels_commonKt$mapIndexedTo$1;
                        receiveChannel4 = receiveChannel8;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel7;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        receiveChannel5 = receiveChannel6;
                        collection = collection2;
                        intRef = intRef3;
                        th = th4;
                        function22 = function23;
                        try {
                            if (!((Boolean) obj2).booleanValue()) {
                                int i2 = intRef.element;
                                intRef.element = i2 + 1;
                                collection.add(function22.invoke(Boxing.boxInt(i2), (Object) channelIterator2.next()));
                                receiveChannel3 = receiveChannel9;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$1 = collection;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$2 = function22;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$3 = intRef;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$4 = receiveChannel4;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$5 = receiveChannel2;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$6 = th;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$7 = receiveChannel5;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.L$8 = it;
                                channelsKt__Channels_commonKt$mapIndexedTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$mapIndexedTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel9 = receiveChannel3;
                                obj2 = hasNext;
                                collection = collection;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    return collection;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            try {
                                throw th2;
                            } finally {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                InlineMarker.finallyEnd(1);
                            }
                        }
                    } catch (Throwable th6) {
                        th2 = th6;
                        receiveChannel2 = receiveChannel7;
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$mapIndexedTo$1 = new ChannelsKt__Channels_commonKt$mapIndexedTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$mapIndexedTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapIndexedTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Not initialized variable reg: 8, insn: 0x00a7: MOVE  (r2 I:??[OBJECT, ARRAY]) = (r8 I:??[OBJECT, ARRAY]), block:B:75:0x00a6 */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0027 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0102 A[Catch: all -> 0x0151, TryCatch #0 {all -> 0x0151, blocks: (B:79:0x00ca, B:83:0x00fa, B:85:0x0102, B:89:0x0145), top: B:101:0x00ca }] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0145 A[Catch: all -> 0x0151, TRY_LEAVE, TryCatch #0 {all -> 0x0151, blocks: (B:79:0x00ca, B:83:0x00fa, B:85:0x0102, B:89:0x0145), top: B:101:0x00ca }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:88:0x0133 -> B:101:0x00ca). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R, C extends SendChannel<? super R>> Object mapIndexedTo(ReceiveChannel<? extends E> receiveChannel, C c, Function2<? super Integer, ? super E, ? extends R> function2, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapIndexedTo$3 channelsKt__Channels_commonKt$mapIndexedTo$3;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        Function2<? super Integer, ? super E, ? extends R> function22;
        SendChannel sendChannel;
        ReceiveChannel<? extends E> receiveChannel6;
        Object obj;
        Ref.IntRef intRef;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelsKt__Channels_commonKt$mapIndexedTo$3 channelsKt__Channels_commonKt$mapIndexedTo$32;
        ReceiveChannel<? extends E> receiveChannel8;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel9;
        SendChannel sendChannel2;
        Throwable th3;
        Function2<? super Integer, ? super E, ? extends R> function23;
        Throwable th4;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$mapIndexedTo$3) {
                channelsKt__Channels_commonKt$mapIndexedTo$3 = (ChannelsKt__Channels_commonKt$mapIndexedTo$3) continuation;
                if ((channelsKt__Channels_commonKt$mapIndexedTo$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$mapIndexedTo$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$mapIndexedTo$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$mapIndexedTo$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        intRef2.element = 0;
                        try {
                            function23 = function2;
                            intRef = intRef2;
                            channelsKt__Channels_commonKt$mapIndexedTo$32 = channelsKt__Channels_commonKt$mapIndexedTo$3;
                            obj = coroutine_suspended;
                            th3 = null;
                            channelIterator2 = receiveChannel.iterator();
                            receiveChannel7 = receiveChannel;
                            receiveChannel8 = receiveChannel7;
                            receiveChannel3 = receiveChannel8;
                            receiveChannel9 = receiveChannel3;
                            sendChannel2 = c;
                        } catch (Throwable th5) {
                            th4 = th5;
                            receiveChannel3 = receiveChannel;
                            th = th4;
                            throw th;
                        }
                    } else {
                        try {
                            if (i == 1) {
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedTo$3.L$8;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$7;
                                th2 = (Throwable) channelsKt__Channels_commonKt$mapIndexedTo$3.L$6;
                                ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$5;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$4;
                                Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedTo$3.L$3;
                                function22 = (Function2) channelsKt__Channels_commonKt$mapIndexedTo$3.L$2;
                                sendChannel = (SendChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$1;
                                receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                obj = coroutine_suspended;
                                receiveChannel3 = receiveChannel10;
                                intRef = intRef3;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Object obj3 = (Object) channelIterator.next();
                                    int i2 = intRef.element;
                                    intRef.element = i2 + 1;
                                    R invoke = function22.invoke(Boxing.boxInt(i2), obj3);
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$0 = receiveChannel6;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$1 = sendChannel;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$2 = function22;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$3 = intRef;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$4 = receiveChannel5;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$5 = receiveChannel3;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$6 = th2;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$7 = receiveChannel4;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$8 = channelIterator;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$9 = obj3;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.L$10 = obj3;
                                    channelsKt__Channels_commonKt$mapIndexedTo$3.label = 2;
                                    if (sendChannel.send(invoke, channelsKt__Channels_commonKt$mapIndexedTo$3) == obj) {
                                        return obj;
                                    }
                                    receiveChannel7 = receiveChannel6;
                                    ReceiveChannel<? extends E> receiveChannel11 = receiveChannel5;
                                    channelsKt__Channels_commonKt$mapIndexedTo$32 = channelsKt__Channels_commonKt$mapIndexedTo$3;
                                    receiveChannel8 = receiveChannel11;
                                    SendChannel sendChannel3 = sendChannel;
                                    channelIterator2 = channelIterator;
                                    receiveChannel9 = receiveChannel4;
                                    sendChannel2 = sendChannel3;
                                    Function2<? super Integer, ? super E, ? extends R> function24 = function22;
                                    th3 = th2;
                                    function23 = function24;
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    return sendChannel;
                                }
                            } else if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj4 = channelsKt__Channels_commonKt$mapIndexedTo$3.L$10;
                                Object obj5 = channelsKt__Channels_commonKt$mapIndexedTo$3.L$9;
                                ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapIndexedTo$3.L$8;
                                ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$7;
                                Throwable th6 = (Throwable) channelsKt__Channels_commonKt$mapIndexedTo$3.L$6;
                                ReceiveChannel<? extends E> receiveChannel13 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel14 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$4;
                                Ref.IntRef intRef4 = (Ref.IntRef) channelsKt__Channels_commonKt$mapIndexedTo$3.L$3;
                                Function2<? super Integer, ? super E, ? extends R> function25 = (Function2) channelsKt__Channels_commonKt$mapIndexedTo$3.L$2;
                                SendChannel sendChannel4 = (SendChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$1;
                                ReceiveChannel<? extends E> receiveChannel15 = (ReceiveChannel) channelsKt__Channels_commonKt$mapIndexedTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                receiveChannel7 = receiveChannel15;
                                channelsKt__Channels_commonKt$mapIndexedTo$32 = channelsKt__Channels_commonKt$mapIndexedTo$3;
                                receiveChannel8 = receiveChannel14;
                                obj = coroutine_suspended;
                                receiveChannel3 = receiveChannel13;
                                intRef = intRef4;
                                channelIterator2 = channelIterator3;
                                receiveChannel9 = receiveChannel12;
                                sendChannel2 = sendChannel4;
                                th3 = th6;
                                function23 = function25;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel3 = receiveChannel2;
                            try {
                                throw th;
                            } finally {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel3, th);
                                InlineMarker.finallyEnd(1);
                            }
                        }
                    }
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$0 = receiveChannel7;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$1 = sendChannel2;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$2 = function23;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$3 = intRef;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$4 = receiveChannel8;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$5 = receiveChannel3;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$6 = th3;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$7 = receiveChannel9;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.L$8 = channelIterator2;
                    channelsKt__Channels_commonKt$mapIndexedTo$32.label = 1;
                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexedTo$32);
                    if (hasNext != obj) {
                        return obj;
                    }
                    receiveChannel6 = receiveChannel7;
                    obj2 = hasNext;
                    ChannelsKt__Channels_commonKt$mapIndexedTo$3 channelsKt__Channels_commonKt$mapIndexedTo$33 = channelsKt__Channels_commonKt$mapIndexedTo$32;
                    receiveChannel5 = receiveChannel8;
                    channelsKt__Channels_commonKt$mapIndexedTo$3 = channelsKt__Channels_commonKt$mapIndexedTo$33;
                    SendChannel sendChannel5 = sendChannel2;
                    receiveChannel4 = receiveChannel9;
                    channelIterator = channelIterator2;
                    sendChannel = sendChannel5;
                    Throwable th8 = th3;
                    function22 = function23;
                    th2 = th8;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                }
            }
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$0 = receiveChannel7;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$1 = sendChannel2;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$2 = function23;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$3 = intRef;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$4 = receiveChannel8;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$5 = receiveChannel3;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$6 = th3;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$7 = receiveChannel9;
            channelsKt__Channels_commonKt$mapIndexedTo$32.L$8 = channelIterator2;
            channelsKt__Channels_commonKt$mapIndexedTo$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapIndexedTo$32);
            if (hasNext != obj) {
            }
        } catch (Throwable th9) {
            th4 = th9;
            th = th4;
            throw th;
        }
        channelsKt__Channels_commonKt$mapIndexedTo$3 = new ChannelsKt__Channels_commonKt$mapIndexedTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$mapIndexedTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapIndexedTo$3.label;
        if (i != 0) {
        }
    }

    public static /* synthetic */ ReceiveChannel mapNotNull$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.mapNotNull(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<R> mapNotNull(ReceiveChannel<? extends E> mapNotNull, CoroutineContext context, Function2<? super E, ? super Continuation<? super R>, ? extends Object> transform) {
        Intrinsics.checkParameterIsNotNull(mapNotNull, "$this$mapNotNull");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ChannelsKt.filterNotNull(ChannelsKt.map(mapNotNull, context, transform));
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x009a A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:62:0x0046, B:75:0x0092, B:77:0x009a, B:79:0x00a4, B:81:0x00b0), top: B:94:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00b0 A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #1 {all -> 0x0053, blocks: (B:62:0x0046, B:75:0x0092, B:77:0x009a, B:79:0x00a4, B:81:0x00b0), top: B:94:0x0046 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x008c -> B:75:0x0092). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R, C extends Collection<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapNotNullTo$1 channelsKt__Channels_commonKt$mapNotNullTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$mapNotNullTo$1 channelsKt__Channels_commonKt$mapNotNullTo$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, ? extends R> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapNotNullTo$1) {
            channelsKt__Channels_commonKt$mapNotNullTo$1 = (ChannelsKt__Channels_commonKt$mapNotNullTo$1) continuation;
            if ((channelsKt__Channels_commonKt$mapNotNullTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapNotNullTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapNotNullTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapNotNullTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$mapNotNullTo$12 = channelsKt__Channels_commonKt$mapNotNullTo$1;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        collection = c;
                        receiveChannel4 = receiveChannel3;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.L$1 = collection;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.L$2 = function12;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.L$5 = th2;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.L$7 = it;
                        channelsKt__Channels_commonKt$mapNotNullTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapNotNullTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$mapNotNullTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$1.L$3;
                    Function1<? super E, ? extends R> function13 = (Function1) channelsKt__Channels_commonKt$mapNotNullTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$mapNotNullTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelsKt__Channels_commonKt$mapNotNullTo$1 channelsKt__Channels_commonKt$mapNotNullTo$13 = channelsKt__Channels_commonKt$mapNotNullTo$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel4 = receiveChannel9;
                        Object obj3 = coroutine_suspended;
                        collection = collection2;
                        ChannelsKt__Channels_commonKt$mapNotNullTo$1 channelsKt__Channels_commonKt$mapNotNullTo$14 = channelsKt__Channels_commonKt$mapNotNullTo$13;
                        th2 = th4;
                        receiveChannel5 = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (((Boolean) obj2).booleanValue()) {
                            try {
                                R invoke = function13.invoke((Object) channelIterator2.next());
                                if (invoke != null) {
                                    Boxing.boxBoolean(collection.add(invoke));
                                }
                                channelsKt__Channels_commonKt$mapNotNullTo$12.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$mapNotNullTo$12.L$1 = collection;
                                channelsKt__Channels_commonKt$mapNotNullTo$12.L$2 = function12;
                                channelsKt__Channels_commonKt$mapNotNullTo$12.L$3 = receiveChannel5;
                                channelsKt__Channels_commonKt$mapNotNullTo$12.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$mapNotNullTo$12.L$5 = th2;
                                channelsKt__Channels_commonKt$mapNotNullTo$12.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$mapNotNullTo$12.L$7 = it;
                                channelsKt__Channels_commonKt$mapNotNullTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Function1<? super E, ? extends R> function14 = function12;
                                receiveChannel7 = receiveChannel2;
                                obj2 = hasNext;
                                obj3 = obj;
                                channelsKt__Channels_commonKt$mapNotNullTo$14 = channelsKt__Channels_commonKt$mapNotNullTo$12;
                                function13 = function14;
                                collection = collection;
                                channelIterator2 = it;
                                if (((Boolean) obj2).booleanValue()) {
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    throw th6;
                                }
                            }
                            receiveChannel2 = receiveChannel7;
                            function12 = function13;
                            channelsKt__Channels_commonKt$mapNotNullTo$12 = channelsKt__Channels_commonKt$mapNotNullTo$14;
                            obj = obj3;
                            it = channelIterator2;
                        } else {
                            Unit unit = Unit.INSTANCE;
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel7, th2);
                            InlineMarker.finallyEnd(1);
                            return collection;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$mapNotNullTo$1 = new ChannelsKt__Channels_commonKt$mapNotNullTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$mapNotNullTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapNotNullTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Type inference failed for r15v6. Raw type applied. Possible types: E, ? super E, java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00c6 A[Catch: all -> 0x0115, TryCatch #1 {all -> 0x0115, blocks: (B:82:0x009a, B:86:0x00be, B:88:0x00c6, B:90:0x00d0, B:96:0x0109), top: B:108:0x009a }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0109 A[Catch: all -> 0x0115, TRY_LEAVE, TryCatch #1 {all -> 0x0115, blocks: (B:82:0x009a, B:86:0x00be, B:88:0x00c6, B:90:0x00d0, B:96:0x0109), top: B:108:0x009a }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Type inference failed for: r7v1, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Type inference failed for: r7v3, types: [kotlinx.coroutines.channels.SendChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x00f2 -> B:108:0x009a). Please submit an issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x00ff -> B:108:0x009a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R, C extends SendChannel<? super R>> Object mapNotNullTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapNotNullTo$3 channelsKt__Channels_commonKt$mapNotNullTo$3;
        ?? r2;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator<? extends E> channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, ? extends R> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelsKt__Channels_commonKt$mapNotNullTo$3 channelsKt__Channels_commonKt$mapNotNullTo$32;
        C c2;
        ChannelIterator<? extends E> channelIterator2;
        Object obj;
        Function1<? super E, ? extends R> function13;
        C c3;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$mapNotNullTo$3) {
                channelsKt__Channels_commonKt$mapNotNullTo$3 = (ChannelsKt__Channels_commonKt$mapNotNullTo$3) continuation;
                if ((channelsKt__Channels_commonKt$mapNotNullTo$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$mapNotNullTo$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$mapNotNullTo$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = channelsKt__Channels_commonKt$mapNotNullTo$3.label;
                    if (r2 == 0) {
                        try {
                            if (r2 == 1) {
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapNotNullTo$3.L$7;
                                receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$6;
                                Throwable th2 = (Throwable) channelsKt__Channels_commonKt$mapNotNullTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$4;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$3;
                                function12 = (Function1) channelsKt__Channels_commonKt$mapNotNullTo$3.L$2;
                                ?? r7 = (SendChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$1;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                th = th2;
                                receiveChannel2 = receiveChannel8;
                                c3 = r7;
                                if (((Boolean) obj2).booleanValue()) {
                                }
                            } else if (r2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj3 = channelsKt__Channels_commonKt$mapNotNullTo$3.L$10;
                                Object obj4 = channelsKt__Channels_commonKt$mapNotNullTo$3.L$9;
                                Object obj5 = channelsKt__Channels_commonKt$mapNotNullTo$3.L$8;
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapNotNullTo$3.L$7;
                                receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$6;
                                Throwable th3 = (Throwable) channelsKt__Channels_commonKt$mapNotNullTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$4;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$3;
                                function12 = (Function1) channelsKt__Channels_commonKt$mapNotNullTo$3.L$2;
                                ?? r72 = (SendChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$1;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapNotNullTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                C c4 = r72;
                                receiveChannel6 = receiveChannel3;
                                receiveChannel7 = receiveChannel4;
                                channelsKt__Channels_commonKt$mapNotNullTo$32 = channelsKt__Channels_commonKt$mapNotNullTo$3;
                                c2 = c4;
                                channelIterator2 = channelIterator;
                                receiveChannel = receiveChannel5;
                                ReceiveChannel<? extends E> receiveChannel10 = receiveChannel9;
                                th = th3;
                                receiveChannel2 = receiveChannel10;
                                Function1<? super E, ? extends R> function14 = function12;
                                obj = coroutine_suspended;
                                function13 = function14;
                                try {
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.L$0 = receiveChannel;
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.L$1 = c2;
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.L$2 = function13;
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.L$3 = receiveChannel7;
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.L$5 = th;
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.L$6 = receiveChannel6;
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.L$7 = channelIterator2;
                                    channelsKt__Channels_commonKt$mapNotNullTo$32.label = 1;
                                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    receiveChannel5 = receiveChannel;
                                    channelIterator = channelIterator2;
                                    c3 = c2;
                                    channelsKt__Channels_commonKt$mapNotNullTo$3 = channelsKt__Channels_commonKt$mapNotNullTo$32;
                                    receiveChannel4 = receiveChannel7;
                                    receiveChannel3 = receiveChannel6;
                                    obj2 = hasNext;
                                    Object obj6 = obj;
                                    function12 = function13;
                                    coroutine_suspended = obj6;
                                    if (((Boolean) obj2).booleanValue()) {
                                        Object obj7 = (E) channelIterator.next();
                                        R invoke = function12.invoke(obj7);
                                        if (invoke != null) {
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$0 = receiveChannel5;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$1 = c3;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$2 = function12;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$3 = receiveChannel4;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$5 = th;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$6 = receiveChannel3;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$7 = channelIterator;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$8 = obj7;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$9 = obj7;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.L$10 = invoke;
                                            channelsKt__Channels_commonKt$mapNotNullTo$3.label = 2;
                                            if (c3.send(invoke, channelsKt__Channels_commonKt$mapNotNullTo$3) == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            Throwable th4 = th;
                                            receiveChannel9 = receiveChannel2;
                                            th3 = th4;
                                            c4 = c3;
                                            receiveChannel6 = receiveChannel3;
                                            receiveChannel7 = receiveChannel4;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32 = channelsKt__Channels_commonKt$mapNotNullTo$3;
                                            c2 = c4;
                                            channelIterator2 = channelIterator;
                                            receiveChannel = receiveChannel5;
                                            ReceiveChannel<? extends E> receiveChannel102 = receiveChannel9;
                                            th = th3;
                                            receiveChannel2 = receiveChannel102;
                                            Function1<? super E, ? extends R> function142 = function12;
                                            obj = coroutine_suspended;
                                            function13 = function142;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$0 = receiveChannel;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$1 = c2;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$2 = function13;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$3 = receiveChannel7;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$5 = th;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$6 = receiveChannel6;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$7 = channelIterator2;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.label = 1;
                                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$32);
                                            if (hasNext != obj) {
                                            }
                                        } else {
                                            receiveChannel6 = receiveChannel3;
                                            receiveChannel7 = receiveChannel4;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32 = channelsKt__Channels_commonKt$mapNotNullTo$3;
                                            c2 = c3;
                                            channelIterator2 = channelIterator;
                                            receiveChannel = receiveChannel5;
                                            Function1<? super E, ? extends R> function15 = function12;
                                            obj = coroutine_suspended;
                                            function13 = function15;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$0 = receiveChannel;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$1 = c2;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$2 = function13;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$3 = receiveChannel7;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$4 = receiveChannel2;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$5 = th;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$6 = receiveChannel6;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$7 = channelIterator2;
                                            channelsKt__Channels_commonKt$mapNotNullTo$32.label = 1;
                                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$32);
                                            if (hasNext != obj) {
                                            }
                                        }
                                    } else {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th);
                                        InlineMarker.finallyEnd(1);
                                        return c3;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                }
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = r2;
                        }
                    } else {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th7 = null;
                        try {
                            channelsKt__Channels_commonKt$mapNotNullTo$32 = channelsKt__Channels_commonKt$mapNotNullTo$3;
                            obj = coroutine_suspended;
                            channelIterator2 = receiveChannel.iterator();
                            c2 = c;
                            function13 = function1;
                            th = th7;
                            receiveChannel7 = receiveChannel;
                            receiveChannel2 = receiveChannel7;
                            receiveChannel6 = receiveChannel2;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$0 = receiveChannel;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$1 = c2;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$2 = function13;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$3 = receiveChannel7;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$5 = th;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$6 = receiveChannel6;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.L$7 = channelIterator2;
                            channelsKt__Channels_commonKt$mapNotNullTo$32.label = 1;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapNotNullTo$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th8) {
                            receiveChannel2 = receiveChannel;
                            th = th8;
                        }
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th9) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th9;
        }
        channelsKt__Channels_commonKt$mapNotNullTo$3 = new ChannelsKt__Channels_commonKt$mapNotNullTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$mapNotNullTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = channelsKt__Channels_commonKt$mapNotNullTo$3.label;
        if (r2 == 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009a A[Catch: all -> 0x0053, TryCatch #0 {all -> 0x0053, blocks: (B:59:0x0046, B:72:0x0092, B:74:0x009a, B:75:0x00aa), top: B:86:0x0046 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00aa A[Catch: all -> 0x0053, TRY_LEAVE, TryCatch #0 {all -> 0x0053, blocks: (B:59:0x0046, B:72:0x0092, B:74:0x009a, B:75:0x00aa), top: B:86:0x0046 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x008c -> B:72:0x0092). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R, C extends Collection<? super R>> Object mapTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapTo$1 channelsKt__Channels_commonKt$mapTo$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$mapTo$1 channelsKt__Channels_commonKt$mapTo$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        Collection collection;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, ? extends R> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$mapTo$1) {
            channelsKt__Channels_commonKt$mapTo$1 = (ChannelsKt__Channels_commonKt$mapTo$1) continuation;
            if ((channelsKt__Channels_commonKt$mapTo$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$mapTo$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$mapTo$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$mapTo$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    try {
                        th2 = null;
                        channelsKt__Channels_commonKt$mapTo$12 = channelsKt__Channels_commonKt$mapTo$1;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel;
                        receiveChannel3 = receiveChannel2;
                        collection = c;
                        receiveChannel4 = receiveChannel3;
                        it = receiveChannel.iterator();
                        function12 = function1;
                        receiveChannel5 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapTo$12.L$0 = receiveChannel4;
                        channelsKt__Channels_commonKt$mapTo$12.L$1 = collection;
                        channelsKt__Channels_commonKt$mapTo$12.L$2 = function12;
                        channelsKt__Channels_commonKt$mapTo$12.L$3 = receiveChannel5;
                        channelsKt__Channels_commonKt$mapTo$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$mapTo$12.L$5 = th2;
                        channelsKt__Channels_commonKt$mapTo$12.L$6 = receiveChannel3;
                        channelsKt__Channels_commonKt$mapTo$12.L$7 = it;
                        channelsKt__Channels_commonKt$mapTo$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$mapTo$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapTo$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$mapTo$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$1.L$3;
                    Function1<? super E, ? extends R> function13 = (Function1) channelsKt__Channels_commonKt$mapTo$1.L$2;
                    Collection collection2 = (Collection) channelsKt__Channels_commonKt$mapTo$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        ChannelsKt__Channels_commonKt$mapTo$1 channelsKt__Channels_commonKt$mapTo$13 = channelsKt__Channels_commonKt$mapTo$1;
                        receiveChannel3 = receiveChannel6;
                        receiveChannel4 = receiveChannel9;
                        Object obj3 = coroutine_suspended;
                        collection = collection2;
                        ChannelsKt__Channels_commonKt$mapTo$1 channelsKt__Channels_commonKt$mapTo$14 = channelsKt__Channels_commonKt$mapTo$13;
                        th2 = th4;
                        receiveChannel5 = receiveChannel8;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        if (!((Boolean) obj2).booleanValue()) {
                            collection.add(function13.invoke((Object) channelIterator2.next()));
                            receiveChannel2 = receiveChannel7;
                            function12 = function13;
                            channelsKt__Channels_commonKt$mapTo$12 = channelsKt__Channels_commonKt$mapTo$14;
                            obj = obj3;
                            it = channelIterator2;
                            try {
                                channelsKt__Channels_commonKt$mapTo$12.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$mapTo$12.L$1 = collection;
                                channelsKt__Channels_commonKt$mapTo$12.L$2 = function12;
                                channelsKt__Channels_commonKt$mapTo$12.L$3 = receiveChannel5;
                                channelsKt__Channels_commonKt$mapTo$12.L$4 = receiveChannel2;
                                channelsKt__Channels_commonKt$mapTo$12.L$5 = th2;
                                channelsKt__Channels_commonKt$mapTo$12.L$6 = receiveChannel3;
                                channelsKt__Channels_commonKt$mapTo$12.L$7 = it;
                                channelsKt__Channels_commonKt$mapTo$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$mapTo$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                Function1<? super E, ? extends R> function14 = function12;
                                receiveChannel7 = receiveChannel2;
                                obj2 = hasNext;
                                obj3 = obj;
                                channelsKt__Channels_commonKt$mapTo$14 = channelsKt__Channels_commonKt$mapTo$12;
                                function13 = function14;
                                collection = collection;
                                channelIterator2 = it;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel7, th2);
                                    InlineMarker.finallyEnd(1);
                                    return collection;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                try {
                                    throw th;
                                } catch (Throwable th6) {
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    throw th6;
                                }
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$mapTo$1 = new ChannelsKt__Channels_commonKt$mapTo$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$mapTo$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$mapTo$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0025 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00cf A[Catch: all -> 0x010a, TryCatch #1 {all -> 0x010a, blocks: (B:78:0x00a3, B:82:0x00c7, B:84:0x00cf, B:88:0x00fe), top: B:101:0x00a3 }] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fe A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #1 {all -> 0x010a, blocks: (B:78:0x00a3, B:82:0x00c7, B:84:0x00cf, B:88:0x00fe), top: B:101:0x00a3 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:87:0x00f4 -> B:101:0x00a3). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R, C extends SendChannel<? super R>> Object mapTo(ReceiveChannel<? extends E> receiveChannel, C c, Function1<? super E, ? extends R> function1, Continuation<? super C> continuation) {
        ChannelsKt__Channels_commonKt$mapTo$3 channelsKt__Channels_commonKt$mapTo$3;
        ?? r2;
        ReceiveChannel<? extends E> receiveChannel2;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, ? extends R> function12;
        SendChannel sendChannel;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel6;
        ReceiveChannel<? extends E> receiveChannel7;
        ChannelsKt__Channels_commonKt$mapTo$3 channelsKt__Channels_commonKt$mapTo$32;
        SendChannel sendChannel2;
        ChannelIterator channelIterator2;
        Object obj;
        Function1<? super E, ? extends R> function13;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$mapTo$3) {
                channelsKt__Channels_commonKt$mapTo$3 = (ChannelsKt__Channels_commonKt$mapTo$3) continuation;
                if ((channelsKt__Channels_commonKt$mapTo$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$mapTo$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$mapTo$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    r2 = channelsKt__Channels_commonKt$mapTo$3.label;
                    if (r2 != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th2 = null;
                        try {
                            channelsKt__Channels_commonKt$mapTo$32 = channelsKt__Channels_commonKt$mapTo$3;
                            obj = coroutine_suspended;
                            channelIterator2 = receiveChannel.iterator();
                            sendChannel2 = c;
                            function13 = function1;
                            th = th2;
                            receiveChannel7 = receiveChannel;
                            receiveChannel2 = receiveChannel7;
                            receiveChannel6 = receiveChannel2;
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                            throw th;
                        }
                    } else {
                        try {
                            if (r2 == 1) {
                                channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$mapTo$3.L$7;
                                receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$6;
                                Throwable th4 = (Throwable) channelsKt__Channels_commonKt$mapTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$4;
                                receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$3;
                                function12 = (Function1) channelsKt__Channels_commonKt$mapTo$3.L$2;
                                sendChannel = (SendChannel) channelsKt__Channels_commonKt$mapTo$3.L$1;
                                receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                th = th4;
                                receiveChannel2 = receiveChannel8;
                                if (!((Boolean) obj2).booleanValue()) {
                                    Object obj3 = (Object) channelIterator.next();
                                    R invoke = function12.invoke(obj3);
                                    channelsKt__Channels_commonKt$mapTo$3.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$mapTo$3.L$1 = sendChannel;
                                    channelsKt__Channels_commonKt$mapTo$3.L$2 = function12;
                                    channelsKt__Channels_commonKt$mapTo$3.L$3 = receiveChannel4;
                                    channelsKt__Channels_commonKt$mapTo$3.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$mapTo$3.L$5 = th;
                                    channelsKt__Channels_commonKt$mapTo$3.L$6 = receiveChannel3;
                                    channelsKt__Channels_commonKt$mapTo$3.L$7 = channelIterator;
                                    channelsKt__Channels_commonKt$mapTo$3.L$8 = obj3;
                                    channelsKt__Channels_commonKt$mapTo$3.L$9 = obj3;
                                    channelsKt__Channels_commonKt$mapTo$3.label = 2;
                                    if (sendChannel.send(invoke, channelsKt__Channels_commonKt$mapTo$3) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    receiveChannel6 = receiveChannel3;
                                    receiveChannel7 = receiveChannel4;
                                    channelsKt__Channels_commonKt$mapTo$32 = channelsKt__Channels_commonKt$mapTo$3;
                                    sendChannel2 = sendChannel;
                                    channelIterator2 = channelIterator;
                                    receiveChannel = receiveChannel5;
                                    Function1<? super E, ? extends R> function14 = function12;
                                    obj = coroutine_suspended;
                                    function13 = function14;
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    return sendChannel;
                                }
                            } else if (r2 != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            } else {
                                Object obj4 = channelsKt__Channels_commonKt$mapTo$3.L$9;
                                Object obj5 = channelsKt__Channels_commonKt$mapTo$3.L$8;
                                ChannelIterator<? extends E> channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$mapTo$3.L$7;
                                ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$6;
                                Throwable th5 = (Throwable) channelsKt__Channels_commonKt$mapTo$3.L$5;
                                ReceiveChannel<? extends E> receiveChannel10 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$4;
                                ReceiveChannel<? extends E> receiveChannel11 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$3;
                                Function1<? super E, ? extends R> function15 = (Function1) channelsKt__Channels_commonKt$mapTo$3.L$2;
                                SendChannel sendChannel3 = (SendChannel) channelsKt__Channels_commonKt$mapTo$3.L$1;
                                ReceiveChannel<? extends E> receiveChannel12 = (ReceiveChannel) channelsKt__Channels_commonKt$mapTo$3.L$0;
                                ResultKt.throwOnFailure(obj2);
                                receiveChannel6 = receiveChannel9;
                                receiveChannel7 = receiveChannel11;
                                channelsKt__Channels_commonKt$mapTo$32 = channelsKt__Channels_commonKt$mapTo$3;
                                sendChannel2 = sendChannel3;
                                channelIterator2 = channelIterator3;
                                receiveChannel = receiveChannel12;
                                th = th5;
                                receiveChannel2 = receiveChannel10;
                                obj = coroutine_suspended;
                                function13 = function15;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = r2;
                            try {
                                throw th;
                            } catch (Throwable th7) {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                InlineMarker.finallyEnd(1);
                                throw th7;
                            }
                        }
                    }
                    channelsKt__Channels_commonKt$mapTo$32.L$0 = receiveChannel;
                    channelsKt__Channels_commonKt$mapTo$32.L$1 = sendChannel2;
                    channelsKt__Channels_commonKt$mapTo$32.L$2 = function13;
                    channelsKt__Channels_commonKt$mapTo$32.L$3 = receiveChannel7;
                    channelsKt__Channels_commonKt$mapTo$32.L$4 = receiveChannel2;
                    channelsKt__Channels_commonKt$mapTo$32.L$5 = th;
                    channelsKt__Channels_commonKt$mapTo$32.L$6 = receiveChannel6;
                    channelsKt__Channels_commonKt$mapTo$32.L$7 = channelIterator2;
                    channelsKt__Channels_commonKt$mapTo$32.label = 1;
                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapTo$32);
                    if (hasNext != obj) {
                        return obj;
                    }
                    receiveChannel5 = receiveChannel;
                    channelIterator = channelIterator2;
                    sendChannel = sendChannel2;
                    channelsKt__Channels_commonKt$mapTo$3 = channelsKt__Channels_commonKt$mapTo$32;
                    receiveChannel4 = receiveChannel7;
                    receiveChannel3 = receiveChannel6;
                    obj2 = hasNext;
                    Object obj6 = obj;
                    function12 = function13;
                    coroutine_suspended = obj6;
                    if (!((Boolean) obj2).booleanValue()) {
                    }
                }
            }
            channelsKt__Channels_commonKt$mapTo$32.L$0 = receiveChannel;
            channelsKt__Channels_commonKt$mapTo$32.L$1 = sendChannel2;
            channelsKt__Channels_commonKt$mapTo$32.L$2 = function13;
            channelsKt__Channels_commonKt$mapTo$32.L$3 = receiveChannel7;
            channelsKt__Channels_commonKt$mapTo$32.L$4 = receiveChannel2;
            channelsKt__Channels_commonKt$mapTo$32.L$5 = th;
            channelsKt__Channels_commonKt$mapTo$32.L$6 = receiveChannel6;
            channelsKt__Channels_commonKt$mapTo$32.L$7 = channelIterator2;
            channelsKt__Channels_commonKt$mapTo$32.label = 1;
            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$mapTo$32);
            if (hasNext != obj) {
            }
        } catch (Throwable th8) {
            th = th8;
            throw th;
        }
        channelsKt__Channels_commonKt$mapTo$3 = new ChannelsKt__Channels_commonKt$mapTo$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$mapTo$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        r2 = channelsKt__Channels_commonKt$mapTo$3.label;
        if (r2 != 0) {
        }
    }

    public static /* synthetic */ ReceiveChannel withIndex$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.withIndex(receiveChannel, coroutineContext);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<IndexedValue<E>> withIndex(ReceiveChannel<? extends E> withIndex, CoroutineContext context) {
        Intrinsics.checkParameterIsNotNull(withIndex, "$this$withIndex");
        Intrinsics.checkParameterIsNotNull(context, "context");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(withIndex), new ChannelsKt__Channels_commonKt$withIndex$1(withIndex, null), 2, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> distinct(ReceiveChannel<? extends E> distinct) {
        ReceiveChannel<E> distinctBy$default;
        Intrinsics.checkParameterIsNotNull(distinct, "$this$distinct");
        distinctBy$default = distinctBy$default(distinct, null, new ChannelsKt__Channels_commonKt$distinct$1(null), 1, null);
        return distinctBy$default;
    }

    public static /* synthetic */ ReceiveChannel distinctBy$default(ReceiveChannel receiveChannel, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.distinctBy(receiveChannel, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, K> ReceiveChannel<E> distinctBy(ReceiveChannel<? extends E> distinctBy, CoroutineContext context, Function2<? super E, ? super Continuation<? super K>, ? extends Object> selector) {
        Intrinsics.checkParameterIsNotNull(distinctBy, "$this$distinctBy");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(selector, "selector");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumes(distinctBy), new ChannelsKt__Channels_commonKt$distinctBy$1(distinctBy, selector, null), 2, null);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> Object toMutableSet(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Set<E>> continuation) {
        return ChannelsKt.toCollection(receiveChannel, new LinkedHashSet(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0092 A[Catch: all -> 0x00c6, TryCatch #0 {all -> 0x00c6, blocks: (B:76:0x008a, B:78:0x0092, B:80:0x00a2, B:72:0x006e, B:84:0x00b6), top: B:95:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b6 A[Catch: all -> 0x00c6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:76:0x008a, B:78:0x0092, B:80:0x00a2, B:72:0x006e, B:84:0x00b6), top: B:95:0x008a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0085 -> B:95:0x008a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object all(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$all$1 channelsKt__Channels_commonKt$all$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$all$1 channelsKt__Channels_commonKt$all$12;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$all$1) {
                channelsKt__Channels_commonKt$all$1 = (ChannelsKt__Channels_commonKt$all$1) continuation;
                if ((channelsKt__Channels_commonKt$all$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$all$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$all$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$all$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            th2 = null;
                            channelsKt__Channels_commonKt$all$12 = channelsKt__Channels_commonKt$all$1;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$all$12.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$all$12.L$1 = function12;
                            channelsKt__Channels_commonKt$all$12.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$all$12.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$all$12.L$4 = th2;
                            channelsKt__Channels_commonKt$all$12.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$all$12.L$6 = it;
                            channelsKt__Channels_commonKt$all$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$all$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$all$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$all$1.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$all$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$all$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$all$1.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$all$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$all$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Throwable th5 = th4;
                            function12 = function13;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$all$12 = channelsKt__Channels_commonKt$all$1;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (((Boolean) obj2).booleanValue()) {
                                    if (!function12.invoke((Object) channelIterator2.next()).booleanValue()) {
                                        Boolean boxBoolean = Boxing.boxBoolean(false);
                                        InlineMarker.finallyStart(2);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(2);
                                        return boxBoolean;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$all$12.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$all$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$all$12.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$all$12.L$3 = receiveChannel2;
                                    channelsKt__Channels_commonKt$all$12.L$4 = th2;
                                    channelsKt__Channels_commonKt$all$12.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$all$12.L$6 = it;
                                    channelsKt__Channels_commonKt$all$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$all$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (((Boolean) obj2).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    InlineMarker.finallyEnd(1);
                                    return Boxing.boxBoolean(true);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$all$1 = new ChannelsKt__Channels_commonKt$all$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$all$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$all$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0047  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$any$1 channelsKt__Channels_commonKt$any$1;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$any$1) {
            channelsKt__Channels_commonKt$any$1 = (ChannelsKt__Channels_commonKt$any$1) continuation;
            if ((channelsKt__Channels_commonKt$any$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$any$1.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$any$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$any$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$any$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.L$2 = th;
                        channelsKt__Channels_commonKt$any$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$any$1.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$any$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th2 = th3;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$3;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$any$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$any$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        hasNext = obj;
                        th = th4;
                        receiveChannel = receiveChannel2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        try {
                            throw th2;
                        } finally {
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        }
                    }
                }
                return hasNext;
            }
        }
        channelsKt__Channels_commonKt$any$1 = new ChannelsKt__Channels_commonKt$any$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$any$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$any$1.label;
        if (i != 0) {
        }
        return hasNext;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0092 A[Catch: all -> 0x00c6, TryCatch #0 {all -> 0x00c6, blocks: (B:76:0x008a, B:78:0x0092, B:80:0x00a2, B:72:0x006e, B:84:0x00b5), top: B:95:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b5 A[Catch: all -> 0x00c6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:76:0x008a, B:78:0x0092, B:80:0x00a2, B:72:0x006e, B:84:0x00b5), top: B:95:0x008a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0085 -> B:95:0x008a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object any(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$any$3 channelsKt__Channels_commonKt$any$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$any$3 channelsKt__Channels_commonKt$any$32;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$any$3) {
                channelsKt__Channels_commonKt$any$3 = (ChannelsKt__Channels_commonKt$any$3) continuation;
                if ((channelsKt__Channels_commonKt$any$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$any$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$any$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$any$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            th2 = null;
                            channelsKt__Channels_commonKt$any$32 = channelsKt__Channels_commonKt$any$3;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$any$32.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$any$32.L$1 = function12;
                            channelsKt__Channels_commonKt$any$32.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$any$32.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$any$32.L$4 = th2;
                            channelsKt__Channels_commonKt$any$32.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$any$32.L$6 = it;
                            channelsKt__Channels_commonKt$any$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$any$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$any$3.L$6;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$any$3.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$any$3.L$4;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$any$3.L$3;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$any$3.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$any$3.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$any$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Throwable th5 = th4;
                            function12 = function13;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$any$32 = channelsKt__Channels_commonKt$any$3;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (((Boolean) obj2).booleanValue()) {
                                    if (function12.invoke((Object) channelIterator2.next()).booleanValue()) {
                                        Boolean boxBoolean = Boxing.boxBoolean(true);
                                        InlineMarker.finallyStart(2);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(2);
                                        return boxBoolean;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$any$32.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$any$32.L$1 = function12;
                                    channelsKt__Channels_commonKt$any$32.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$any$32.L$3 = receiveChannel2;
                                    channelsKt__Channels_commonKt$any$32.L$4 = th2;
                                    channelsKt__Channels_commonKt$any$32.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$any$32.L$6 = it;
                                    channelsKt__Channels_commonKt$any$32.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$any$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (((Boolean) obj2).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    InlineMarker.finallyEnd(1);
                                    return Boxing.boxBoolean(false);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$any$3 = new ChannelsKt__Channels_commonKt$any$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$any$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$any$3.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0096 A[Catch: all -> 0x00ac, TryCatch #1 {all -> 0x00ac, blocks: (B:72:0x008e, B:74:0x0096, B:68:0x0074, B:75:0x00a0), top: B:88:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00a0 A[Catch: all -> 0x00ac, TRY_LEAVE, TryCatch #1 {all -> 0x00ac, blocks: (B:72:0x008e, B:74:0x0096, B:68:0x0074, B:75:0x00a0), top: B:88:0x008e }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x008b -> B:88:0x008e). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$count$1 channelsKt__Channels_commonKt$count$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$count$1 channelsKt__Channels_commonKt$count$12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$count$1) {
                channelsKt__Channels_commonKt$count$1 = (ChannelsKt__Channels_commonKt$count$1) continuation;
                if ((channelsKt__Channels_commonKt$count$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$count$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$count$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$count$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        intRef2.element = 0;
                        try {
                            intRef = intRef2;
                            obj = coroutine_suspended;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$count$12 = channelsKt__Channels_commonKt$count$1;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$count$12.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$count$12.L$1 = intRef;
                            channelsKt__Channels_commonKt$count$12.L$2 = receiveChannel5;
                            channelsKt__Channels_commonKt$count$12.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$count$12.L$4 = th2;
                            channelsKt__Channels_commonKt$count$12.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$count$12.L$6 = it;
                            channelsKt__Channels_commonKt$count$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$count$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$count$1.L$6;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$count$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$2;
                        intRef = (Ref.IntRef) channelsKt__Channels_commonKt$count$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$count$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            channelsKt__Channels_commonKt$count$12 = channelsKt__Channels_commonKt$count$1;
                            receiveChannel5 = receiveChannel7;
                            th2 = th4;
                            obj = coroutine_suspended;
                            receiveChannel2 = receiveChannel6;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    channelIterator2.next();
                                    intRef.element++;
                                    receiveChannel3 = receiveChannel8;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$count$12.L$0 = receiveChannel3;
                                    channelsKt__Channels_commonKt$count$12.L$1 = intRef;
                                    channelsKt__Channels_commonKt$count$12.L$2 = receiveChannel5;
                                    channelsKt__Channels_commonKt$count$12.L$3 = receiveChannel2;
                                    channelsKt__Channels_commonKt$count$12.L$4 = th2;
                                    channelsKt__Channels_commonKt$count$12.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$count$12.L$6 = it;
                                    channelsKt__Channels_commonKt$count$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$count$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                        return Boxing.boxInt(intRef.element);
                                    }
                                }
                            } catch (Throwable th5) {
                                th = th5;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            receiveChannel2 = receiveChannel6;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th7) {
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            throw th7;
        }
        channelsKt__Channels_commonKt$count$1 = new ChannelsKt__Channels_commonKt$count$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$count$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$count$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00a4 A[Catch: all -> 0x00d0, TryCatch #0 {all -> 0x00d0, blocks: (B:75:0x009c, B:77:0x00a4, B:79:0x00b4, B:71:0x007d, B:81:0x00be), top: B:92:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00be A[Catch: all -> 0x00d0, TRY_LEAVE, TryCatch #0 {all -> 0x00d0, blocks: (B:75:0x009c, B:77:0x00a4, B:79:0x00b4, B:71:0x007d, B:81:0x00be), top: B:92:0x009c }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x0096 -> B:92:0x009c). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object count(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$count$3 channelsKt__Channels_commonKt$count$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$count$3 channelsKt__Channels_commonKt$count$32;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$count$3) {
                channelsKt__Channels_commonKt$count$3 = (ChannelsKt__Channels_commonKt$count$3) continuation;
                if ((channelsKt__Channels_commonKt$count$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$count$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$count$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$count$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        intRef2.element = 0;
                        try {
                            intRef = intRef2;
                            obj = coroutine_suspended;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$count$32 = channelsKt__Channels_commonKt$count$3;
                            receiveChannel2 = receiveChannel5;
                            channelsKt__Channels_commonKt$count$32.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$count$32.L$1 = function12;
                            channelsKt__Channels_commonKt$count$32.L$2 = intRef;
                            channelsKt__Channels_commonKt$count$32.L$3 = receiveChannel3;
                            channelsKt__Channels_commonKt$count$32.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$count$32.L$5 = th2;
                            channelsKt__Channels_commonKt$count$32.L$6 = receiveChannel4;
                            channelsKt__Channels_commonKt$count$32.L$7 = it;
                            channelsKt__Channels_commonKt$count$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$count$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$count$3.L$7;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$count$3.L$6;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$count$3.L$5;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$count$3.L$4;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$count$3.L$3;
                        Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$count$3.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$count$3.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$count$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Ref.IntRef intRef4 = intRef3;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$count$32 = channelsKt__Channels_commonKt$count$3;
                            receiveChannel2 = receiveChannel7;
                            Throwable th5 = th4;
                            function12 = function13;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (((Boolean) obj2).booleanValue()) {
                                    if (function12.invoke((Object) channelIterator2.next()).booleanValue()) {
                                        intRef4.element++;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    intRef = intRef4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$count$32.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$count$32.L$1 = function12;
                                    channelsKt__Channels_commonKt$count$32.L$2 = intRef;
                                    channelsKt__Channels_commonKt$count$32.L$3 = receiveChannel3;
                                    channelsKt__Channels_commonKt$count$32.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$count$32.L$5 = th2;
                                    channelsKt__Channels_commonKt$count$32.L$6 = receiveChannel4;
                                    channelsKt__Channels_commonKt$count$32.L$7 = it;
                                    channelsKt__Channels_commonKt$count$32.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$count$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    intRef4 = intRef;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (((Boolean) obj2).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    InlineMarker.finallyEnd(1);
                                    return Boxing.boxInt(intRef4.element);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$count$3 = new ChannelsKt__Channels_commonKt$count$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$count$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$count$3.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: R */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00b0 A[Catch: all -> 0x00cc, TryCatch #1 {all -> 0x00cc, blocks: (B:73:0x00a8, B:75:0x00b0, B:69:0x008a, B:76:0x00be), top: B:90:0x00a8 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00be A[Catch: all -> 0x00cc, TRY_LEAVE, TryCatch #1 {all -> 0x00cc, blocks: (B:73:0x00a8, B:75:0x00b0, B:69:0x008a, B:76:0x00be), top: B:90:0x00a8 }] */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x00a5 -> B:90:0x00a8). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R> Object fold(ReceiveChannel<? extends E> receiveChannel, R r, Function2<? super R, ? super E, ? extends R> function2, Continuation<? super R> continuation) {
        ChannelsKt__Channels_commonKt$fold$1 channelsKt__Channels_commonKt$fold$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Ref.ObjectRef objectRef;
        ChannelsKt__Channels_commonKt$fold$1 channelsKt__Channels_commonKt$fold$12;
        Object obj;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function2<? super R, ? super E, ? extends R> function22;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        Object hasNext;
        ChannelIterator<? extends E> channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$fold$1) {
            channelsKt__Channels_commonKt$fold$1 = (ChannelsKt__Channels_commonKt$fold$1) continuation;
            if ((channelsKt__Channels_commonKt$fold$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$fold$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$fold$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$fold$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    objectRef2.element = r;
                    try {
                        objectRef = objectRef2;
                        channelsKt__Channels_commonKt$fold$12 = channelsKt__Channels_commonKt$fold$1;
                        obj = coroutine_suspended;
                        th = null;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel2 = receiveChannel4;
                        function22 = function2;
                        obj2 = r;
                        receiveChannel5 = receiveChannel2;
                        channelsKt__Channels_commonKt$fold$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$fold$12.L$1 = obj2;
                        channelsKt__Channels_commonKt$fold$12.L$2 = function22;
                        channelsKt__Channels_commonKt$fold$12.L$3 = objectRef;
                        channelsKt__Channels_commonKt$fold$12.L$4 = receiveChannel4;
                        channelsKt__Channels_commonKt$fold$12.L$5 = receiveChannel2;
                        channelsKt__Channels_commonKt$fold$12.L$6 = th;
                        channelsKt__Channels_commonKt$fold$12.L$7 = receiveChannel5;
                        channelsKt__Channels_commonKt$fold$12.L$8 = it;
                        channelsKt__Channels_commonKt$fold$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$fold$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$fold$1.L$8;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$fold$1.L$7;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$fold$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$fold$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$fold$1.L$4;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$fold$1.L$3;
                    Function2<? super R, ? super E, ? extends R> function23 = (Function2) channelsKt__Channels_commonKt$fold$1.L$2;
                    Object obj4 = channelsKt__Channels_commonKt$fold$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$fold$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        channelsKt__Channels_commonKt$fold$12 = channelsKt__Channels_commonKt$fold$1;
                        receiveChannel4 = receiveChannel8;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel7;
                        channelIterator = channelIterator2;
                        receiveChannel5 = receiveChannel6;
                        obj2 = obj4;
                        objectRef = objectRef3;
                        th = th4;
                        function22 = function23;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th2;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                    try {
                        if (!((Boolean) obj3).booleanValue()) {
                            objectRef.element = function22.invoke((Object) objectRef.element, (Object) channelIterator.next());
                            receiveChannel3 = receiveChannel9;
                            it = channelIterator;
                            channelsKt__Channels_commonKt$fold$12.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$fold$12.L$1 = obj2;
                            channelsKt__Channels_commonKt$fold$12.L$2 = function22;
                            channelsKt__Channels_commonKt$fold$12.L$3 = objectRef;
                            channelsKt__Channels_commonKt$fold$12.L$4 = receiveChannel4;
                            channelsKt__Channels_commonKt$fold$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$fold$12.L$6 = th;
                            channelsKt__Channels_commonKt$fold$12.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$fold$12.L$8 = it;
                            channelsKt__Channels_commonKt$fold$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$fold$12);
                            if (hasNext != obj) {
                                return obj;
                            }
                            receiveChannel9 = receiveChannel3;
                            obj3 = hasNext;
                            channelIterator = it;
                            if (!((Boolean) obj3).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                InlineMarker.finallyEnd(1);
                                return objectRef.element;
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        th2 = th;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$fold$1 = new ChannelsKt__Channels_commonKt$fold$1(continuation);
        Object obj32 = channelsKt__Channels_commonKt$fold$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$fold$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: T */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00b4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00c2 A[Catch: all -> 0x00e8, TryCatch #1 {all -> 0x00e8, blocks: (B:73:0x00ba, B:75:0x00c2, B:69:0x0098, B:76:0x00da), top: B:90:0x00ba }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da A[Catch: all -> 0x00e8, TRY_LEAVE, TryCatch #1 {all -> 0x00e8, blocks: (B:73:0x00ba, B:75:0x00c2, B:69:0x0098, B:76:0x00da), top: B:90:0x00ba }] */
    /* JADX WARN: Type inference failed for: r0v16, types: [T, java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x00b5 -> B:90:0x00ba). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R> Object foldIndexed(ReceiveChannel<? extends E> receiveChannel, R r, Function3<? super Integer, ? super R, ? super E, ? extends R> function3, Continuation<? super R> continuation) {
        ChannelsKt__Channels_commonKt$foldIndexed$1 channelsKt__Channels_commonKt$foldIndexed$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Ref.IntRef intRef;
        Object obj;
        Ref.ObjectRef objectRef;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function3<? super Integer, ? super R, ? super E, ? extends R> function32;
        ChannelsKt__Channels_commonKt$foldIndexed$1 channelsKt__Channels_commonKt$foldIndexed$12;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        Object obj2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$foldIndexed$1) {
            channelsKt__Channels_commonKt$foldIndexed$1 = (ChannelsKt__Channels_commonKt$foldIndexed$1) continuation;
            if ((channelsKt__Channels_commonKt$foldIndexed$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$foldIndexed$1.label -= Integer.MIN_VALUE;
                Object obj3 = channelsKt__Channels_commonKt$foldIndexed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$foldIndexed$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj3);
                    Ref.IntRef intRef2 = new Ref.IntRef();
                    intRef2.element = 0;
                    Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    T t = r;
                    objectRef2.element = t;
                    try {
                        intRef = intRef2;
                        obj = coroutine_suspended;
                        objectRef = objectRef2;
                        th = null;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel2 = receiveChannel3;
                        receiveChannel4 = receiveChannel2;
                        function32 = function3;
                        channelsKt__Channels_commonKt$foldIndexed$12 = channelsKt__Channels_commonKt$foldIndexed$1;
                        receiveChannel5 = receiveChannel4;
                        obj2 = t;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$1 = obj2;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$2 = function32;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$3 = intRef;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$4 = objectRef;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$5 = receiveChannel5;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$6 = receiveChannel2;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$7 = th;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$8 = receiveChannel4;
                        channelsKt__Channels_commonKt$foldIndexed$12.L$9 = it;
                        channelsKt__Channels_commonKt$foldIndexed$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$foldIndexed$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i == 1) {
                    ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$foldIndexed$1.L$9;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$foldIndexed$1.L$8;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$foldIndexed$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$foldIndexed$1.L$6;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$foldIndexed$1.L$5;
                    Ref.ObjectRef objectRef3 = (Ref.ObjectRef) channelsKt__Channels_commonKt$foldIndexed$1.L$4;
                    Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$foldIndexed$1.L$3;
                    Function3<? super Integer, ? super R, ? super E, ? extends R> function33 = (Function3) channelsKt__Channels_commonKt$foldIndexed$1.L$2;
                    Object obj4 = channelsKt__Channels_commonKt$foldIndexed$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$foldIndexed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj3);
                        channelsKt__Channels_commonKt$foldIndexed$12 = channelsKt__Channels_commonKt$foldIndexed$1;
                        receiveChannel5 = receiveChannel8;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel7;
                        ChannelIterator<? extends E> channelIterator2 = channelIterator;
                        receiveChannel4 = receiveChannel6;
                        Object obj5 = obj4;
                        intRef = intRef3;
                        th = th4;
                        function32 = function33;
                        objectRef = objectRef3;
                        try {
                            if (!((Boolean) obj3).booleanValue()) {
                                int i2 = intRef.element;
                                intRef.element = i2 + 1;
                                objectRef.element = function32.invoke(Boxing.boxInt(i2), (Object) objectRef.element, (Object) channelIterator2.next());
                                receiveChannel3 = receiveChannel9;
                                obj2 = obj5;
                                it = channelIterator2;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$0 = receiveChannel3;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$1 = obj2;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$2 = function32;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$3 = intRef;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$4 = objectRef;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$5 = receiveChannel5;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$6 = receiveChannel2;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$7 = th;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$8 = receiveChannel4;
                                channelsKt__Channels_commonKt$foldIndexed$12.L$9 = it;
                                channelsKt__Channels_commonKt$foldIndexed$12.label = 1;
                                hasNext = it.hasNext(channelsKt__Channels_commonKt$foldIndexed$12);
                                if (hasNext != obj) {
                                    return obj;
                                }
                                receiveChannel9 = receiveChannel3;
                                obj3 = hasNext;
                                obj5 = obj2;
                                channelIterator2 = it;
                                if (!((Boolean) obj3).booleanValue()) {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th);
                                    InlineMarker.finallyEnd(1);
                                    return objectRef.element;
                                }
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            th2 = th;
                            try {
                                throw th2;
                            } catch (Throwable th6) {
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th2);
                                InlineMarker.finallyEnd(1);
                                throw th6;
                            }
                        }
                    } catch (Throwable th7) {
                        th2 = th7;
                        receiveChannel2 = receiveChannel7;
                        throw th2;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        channelsKt__Channels_commonKt$foldIndexed$1 = new ChannelsKt__Channels_commonKt$foldIndexed$1(continuation);
        Object obj32 = channelsKt__Channels_commonKt$foldIndexed$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$foldIndexed$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3408=4, 1884=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00f8 A[Catch: all -> 0x0118, TRY_LEAVE, TryCatch #2 {all -> 0x0118, blocks: (B:102:0x00f0, B:104:0x00f8, B:98:0x00d2, B:93:0x00b0, B:97:0x00c3, B:89:0x008e), top: B:120:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00c3 A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #2 {all -> 0x0118, blocks: (B:102:0x00f0, B:104:0x00f8, B:98:0x00d2, B:93:0x00b0, B:97:0x00c3, B:89:0x008e), top: B:120:0x008e }] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Comparable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x00eb -> B:77:0x0052). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R extends Comparable<? super R>> Object maxBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends R> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$maxBy$1 channelsKt__Channels_commonKt$maxBy$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Function1<? super E, ? extends R> function12;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th;
        ChannelIterator channelIterator;
        Throwable th2;
        R invoke;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, ? extends R> function13;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th3;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel6 = receiveChannel;
        if (continuation instanceof ChannelsKt__Channels_commonKt$maxBy$1) {
            channelsKt__Channels_commonKt$maxBy$1 = (ChannelsKt__Channels_commonKt$maxBy$1) continuation;
            if ((channelsKt__Channels_commonKt$maxBy$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$maxBy$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$maxBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$maxBy$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$maxBy$1.L$5;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$4;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$maxBy$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$2;
                        function12 = (Function1) channelsKt__Channels_commonKt$maxBy$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            th = th4;
                            channelIterator = channelIterator2;
                            receiveChannel6 = receiveChannel7;
                        } catch (Throwable th5) {
                            th3 = th5;
                            receiveChannel6 = receiveChannel7;
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ?? r1 = (Comparable) channelsKt__Channels_commonKt$maxBy$1.L$7;
                        obj2 = channelsKt__Channels_commonKt$maxBy$1.L$6;
                        ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$maxBy$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$4;
                        th2 = (Throwable) channelsKt__Channels_commonKt$maxBy$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$2;
                        function13 = (Function1) channelsKt__Channels_commonKt$maxBy$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$maxBy$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ChannelIterator channelIterator4 = channelIterator3;
                            invoke = r1;
                            receiveChannel6 = receiveChannel9;
                            Throwable th6 = th2;
                            ChannelIterator channelIterator5 = channelIterator4;
                            if (!((Boolean) obj).booleanValue()) {
                                Object next = channelIterator5.next();
                                R invoke2 = function13.invoke(next);
                                if (invoke.compareTo(invoke2) < 0) {
                                    obj2 = next;
                                    invoke = invoke2;
                                }
                                receiveChannel5 = receiveChannel8;
                                channelIterator = channelIterator5;
                                th2 = th6;
                                channelsKt__Channels_commonKt$maxBy$1.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$maxBy$1.L$1 = function13;
                                channelsKt__Channels_commonKt$maxBy$1.L$2 = receiveChannel6;
                                channelsKt__Channels_commonKt$maxBy$1.L$3 = th2;
                                channelsKt__Channels_commonKt$maxBy$1.L$4 = receiveChannel5;
                                channelsKt__Channels_commonKt$maxBy$1.L$5 = channelIterator;
                                channelsKt__Channels_commonKt$maxBy$1.L$6 = obj2;
                                channelsKt__Channels_commonKt$maxBy$1.L$7 = invoke;
                                channelsKt__Channels_commonKt$maxBy$1.label = 2;
                                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$maxBy$1);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channelIterator4 = channelIterator;
                                receiveChannel8 = receiveChannel5;
                                obj = hasNext;
                                Throwable th62 = th2;
                                ChannelIterator channelIterator52 = channelIterator4;
                                if (!((Boolean) obj).booleanValue()) {
                                    InlineMarker.finallyStart(2);
                                    ChannelsKt.cancelConsumed(receiveChannel6, th62);
                                    InlineMarker.finallyEnd(2);
                                    return obj2;
                                }
                            }
                        } catch (Throwable th7) {
                            th3 = th7;
                            receiveChannel6 = receiveChannel9;
                        }
                    }
                    try {
                        throw th3;
                    } catch (Throwable th8) {
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel6, th3);
                        InlineMarker.finallyEnd(1);
                        throw th8;
                    }
                }
                ResultKt.throwOnFailure(obj);
                Throwable th9 = null;
                try {
                    ChannelIterator<? extends E> it = receiveChannel.iterator();
                    channelsKt__Channels_commonKt$maxBy$1.L$0 = receiveChannel6;
                    channelsKt__Channels_commonKt$maxBy$1.L$1 = function1;
                    channelsKt__Channels_commonKt$maxBy$1.L$2 = receiveChannel6;
                    channelsKt__Channels_commonKt$maxBy$1.L$3 = th9;
                    channelsKt__Channels_commonKt$maxBy$1.L$4 = receiveChannel6;
                    channelsKt__Channels_commonKt$maxBy$1.L$5 = it;
                    channelsKt__Channels_commonKt$maxBy$1.label = 1;
                    Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$maxBy$1);
                    if (hasNext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel2 = receiveChannel6;
                    function12 = function1;
                    receiveChannel3 = receiveChannel2;
                    th = th9;
                    channelIterator = it;
                    obj = hasNext2;
                } catch (Throwable th10) {
                    th3 = th10;
                }
                th2 = th;
                if (((Boolean) obj).booleanValue()) {
                    InlineMarker.finallyStart(3);
                    ChannelsKt.cancelConsumed(receiveChannel6, th2);
                    InlineMarker.finallyEnd(3);
                    return null;
                }
                Object next2 = channelIterator.next();
                invoke = function12.invoke(next2);
                receiveChannel4 = receiveChannel2;
                function13 = function12;
                ReceiveChannel<? extends E> receiveChannel10 = receiveChannel3;
                obj2 = next2;
                receiveChannel5 = receiveChannel10;
                channelsKt__Channels_commonKt$maxBy$1.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$maxBy$1.L$1 = function13;
                channelsKt__Channels_commonKt$maxBy$1.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$maxBy$1.L$3 = th2;
                channelsKt__Channels_commonKt$maxBy$1.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$maxBy$1.L$5 = channelIterator;
                channelsKt__Channels_commonKt$maxBy$1.L$6 = obj2;
                channelsKt__Channels_commonKt$maxBy$1.L$7 = invoke;
                channelsKt__Channels_commonKt$maxBy$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$maxBy$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__Channels_commonKt$maxBy$1 = new ChannelsKt__Channels_commonKt$maxBy$1(continuation);
        obj = channelsKt__Channels_commonKt$maxBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$maxBy$1.label;
        if (i == 0) {
        }
        th2 = th;
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3430=4, 1914=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x006d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00d9 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x009d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00a1 A[Catch: all -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:71:0x0044, B:96:0x00c4, B:98:0x00cc, B:76:0x0069, B:85:0x0095, B:89:0x00a1), top: B:114:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00cc A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:71:0x0044, B:96:0x00c4, B:98:0x00cc, B:76:0x0069, B:85:0x0095, B:89:0x00a1), top: B:114:0x0024 }] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x00c0 -> B:96:0x00c4). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object maxWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$maxWith$1 channelsKt__Channels_commonKt$maxWith$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Comparator<? super E> comparator2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Object next;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$maxWith$1) {
                channelsKt__Channels_commonKt$maxWith$1 = (ChannelsKt__Channels_commonKt$maxWith$1) continuation;
                if ((channelsKt__Channels_commonKt$maxWith$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$maxWith$1.label -= Integer.MIN_VALUE;
                    obj = channelsKt__Channels_commonKt$maxWith$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$maxWith$1.label;
                    ReceiveChannel<? extends E> receiveChannel7 = 1;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        th = null;
                        try {
                            ChannelIterator<? extends E> it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel;
                            channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator;
                            channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel;
                            channelsKt__Channels_commonKt$maxWith$1.L$3 = th;
                            channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel;
                            channelsKt__Channels_commonKt$maxWith$1.L$5 = it;
                            channelsKt__Channels_commonKt$maxWith$1.label = 1;
                            Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                            if (hasNext2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel2 = receiveChannel;
                            comparator2 = comparator;
                            receiveChannel3 = receiveChannel2;
                            channelIterator = it;
                            obj = hasNext2;
                            receiveChannel4 = receiveChannel3;
                        } catch (Throwable th3) {
                            receiveChannel7 = receiveChannel;
                            th = th3;
                            try {
                                throw th;
                            } finally {
                                ChannelsKt.cancelConsumed(receiveChannel7, th);
                            }
                        }
                    } else if (i == 1) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$maxWith$1.L$5;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$4;
                        th = (Throwable) channelsKt__Channels_commonKt$maxWith$1.L$3;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__Channels_commonKt$maxWith$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object obj2 = channelsKt__Channels_commonKt$maxWith$1.L$6;
                        channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$maxWith$1.L$5;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$4;
                        th2 = (Throwable) channelsKt__Channels_commonKt$maxWith$1.L$3;
                        ReceiveChannel receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__Channels_commonKt$maxWith$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$maxWith$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        receiveChannel7 = receiveChannel8;
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator2.next();
                            receiveChannel6 = receiveChannel7;
                            if (comparator2.compare(obj2, next) >= 0) {
                                next = obj2;
                                receiveChannel6 = receiveChannel7;
                            }
                            receiveChannel = receiveChannel6;
                            channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel2;
                            channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator2;
                            channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel;
                            channelsKt__Channels_commonKt$maxWith$1.L$3 = th2;
                            channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel5;
                            channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator2;
                            channelsKt__Channels_commonKt$maxWith$1.L$6 = next;
                            channelsKt__Channels_commonKt$maxWith$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel7 = receiveChannel;
                            obj2 = next;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                return obj2;
                            }
                        }
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return null;
                    }
                    next = channelIterator.next();
                    th2 = th;
                    receiveChannel5 = receiveChannel3;
                    channelIterator2 = channelIterator;
                    receiveChannel6 = receiveChannel4;
                    receiveChannel = receiveChannel6;
                    channelsKt__Channels_commonKt$maxWith$1.L$0 = receiveChannel2;
                    channelsKt__Channels_commonKt$maxWith$1.L$1 = comparator2;
                    channelsKt__Channels_commonKt$maxWith$1.L$2 = receiveChannel;
                    channelsKt__Channels_commonKt$maxWith$1.L$3 = th2;
                    channelsKt__Channels_commonKt$maxWith$1.L$4 = receiveChannel5;
                    channelsKt__Channels_commonKt$maxWith$1.L$5 = channelIterator2;
                    channelsKt__Channels_commonKt$maxWith$1.L$6 = next;
                    channelsKt__Channels_commonKt$maxWith$1.label = 2;
                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$maxWith$1);
                    if (hasNext != coroutine_suspended) {
                    }
                }
            }
            if (i != 0) {
            }
            if (((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
        channelsKt__Channels_commonKt$maxWith$1 = new ChannelsKt__Channels_commonKt$maxWith$1(continuation);
        obj = channelsKt__Channels_commonKt$maxWith$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$maxWith$1.label;
        ReceiveChannel<? extends E> receiveChannel72 = 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [3441=4, 1939=4] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x00ea A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x00f8 A[Catch: all -> 0x0118, TRY_LEAVE, TryCatch #2 {all -> 0x0118, blocks: (B:102:0x00f0, B:104:0x00f8, B:98:0x00d2, B:93:0x00b0, B:97:0x00c3, B:89:0x008e), top: B:120:0x008e }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00c3 A[Catch: all -> 0x0118, TRY_ENTER, TryCatch #2 {all -> 0x0118, blocks: (B:102:0x00f0, B:104:0x00f8, B:98:0x00d2, B:93:0x00b0, B:97:0x00c3, B:89:0x008e), top: B:120:0x008e }] */
    /* JADX WARN: Type inference failed for: r1v12, types: [java.lang.Comparable] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:101:0x00eb -> B:77:0x0052). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E, R extends Comparable<? super R>> Object minBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, ? extends R> function1, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$minBy$1 channelsKt__Channels_commonKt$minBy$1;
        Object obj;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Function1<? super E, ? extends R> function12;
        ReceiveChannel<? extends E> receiveChannel3;
        Throwable th;
        ChannelIterator channelIterator;
        Throwable th2;
        R invoke;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, ? extends R> function13;
        Object obj2;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th3;
        Object hasNext;
        ReceiveChannel<? extends E> receiveChannel6 = receiveChannel;
        if (continuation instanceof ChannelsKt__Channels_commonKt$minBy$1) {
            channelsKt__Channels_commonKt$minBy$1 = (ChannelsKt__Channels_commonKt$minBy$1) continuation;
            if ((channelsKt__Channels_commonKt$minBy$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$minBy$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$minBy$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$minBy$1.label;
                if (i == 0) {
                    if (i == 1) {
                        ChannelIterator channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$minBy$1.L$5;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$4;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$minBy$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$2;
                        function12 = (Function1) channelsKt__Channels_commonKt$minBy$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            th = th4;
                            channelIterator = channelIterator2;
                            receiveChannel6 = receiveChannel7;
                        } catch (Throwable th5) {
                            th3 = th5;
                            receiveChannel6 = receiveChannel7;
                        }
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        ?? r1 = (Comparable) channelsKt__Channels_commonKt$minBy$1.L$7;
                        obj2 = channelsKt__Channels_commonKt$minBy$1.L$6;
                        ChannelIterator channelIterator3 = (ChannelIterator) channelsKt__Channels_commonKt$minBy$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$4;
                        th2 = (Throwable) channelsKt__Channels_commonKt$minBy$1.L$3;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$2;
                        function13 = (Function1) channelsKt__Channels_commonKt$minBy$1.L$1;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$minBy$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj);
                            ChannelIterator channelIterator4 = channelIterator3;
                            invoke = r1;
                            receiveChannel6 = receiveChannel9;
                            Throwable th6 = th2;
                            ChannelIterator channelIterator5 = channelIterator4;
                            if (!((Boolean) obj).booleanValue()) {
                                Object next = channelIterator5.next();
                                R invoke2 = function13.invoke(next);
                                if (invoke.compareTo(invoke2) > 0) {
                                    obj2 = next;
                                    invoke = invoke2;
                                }
                                receiveChannel5 = receiveChannel8;
                                channelIterator = channelIterator5;
                                th2 = th6;
                                channelsKt__Channels_commonKt$minBy$1.L$0 = receiveChannel4;
                                channelsKt__Channels_commonKt$minBy$1.L$1 = function13;
                                channelsKt__Channels_commonKt$minBy$1.L$2 = receiveChannel6;
                                channelsKt__Channels_commonKt$minBy$1.L$3 = th2;
                                channelsKt__Channels_commonKt$minBy$1.L$4 = receiveChannel5;
                                channelsKt__Channels_commonKt$minBy$1.L$5 = channelIterator;
                                channelsKt__Channels_commonKt$minBy$1.L$6 = obj2;
                                channelsKt__Channels_commonKt$minBy$1.L$7 = invoke;
                                channelsKt__Channels_commonKt$minBy$1.label = 2;
                                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$minBy$1);
                                if (hasNext != coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                channelIterator4 = channelIterator;
                                receiveChannel8 = receiveChannel5;
                                obj = hasNext;
                                Throwable th62 = th2;
                                ChannelIterator channelIterator52 = channelIterator4;
                                if (!((Boolean) obj).booleanValue()) {
                                    InlineMarker.finallyStart(2);
                                    ChannelsKt.cancelConsumed(receiveChannel6, th62);
                                    InlineMarker.finallyEnd(2);
                                    return obj2;
                                }
                            }
                        } catch (Throwable th7) {
                            th3 = th7;
                            receiveChannel6 = receiveChannel9;
                        }
                    }
                    try {
                        throw th3;
                    } catch (Throwable th8) {
                        InlineMarker.finallyStart(1);
                        ChannelsKt.cancelConsumed(receiveChannel6, th3);
                        InlineMarker.finallyEnd(1);
                        throw th8;
                    }
                }
                ResultKt.throwOnFailure(obj);
                Throwable th9 = null;
                try {
                    ChannelIterator<? extends E> it = receiveChannel.iterator();
                    channelsKt__Channels_commonKt$minBy$1.L$0 = receiveChannel6;
                    channelsKt__Channels_commonKt$minBy$1.L$1 = function1;
                    channelsKt__Channels_commonKt$minBy$1.L$2 = receiveChannel6;
                    channelsKt__Channels_commonKt$minBy$1.L$3 = th9;
                    channelsKt__Channels_commonKt$minBy$1.L$4 = receiveChannel6;
                    channelsKt__Channels_commonKt$minBy$1.L$5 = it;
                    channelsKt__Channels_commonKt$minBy$1.label = 1;
                    Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$minBy$1);
                    if (hasNext2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    receiveChannel2 = receiveChannel6;
                    function12 = function1;
                    receiveChannel3 = receiveChannel2;
                    th = th9;
                    channelIterator = it;
                    obj = hasNext2;
                } catch (Throwable th10) {
                    th3 = th10;
                }
                th2 = th;
                if (((Boolean) obj).booleanValue()) {
                    InlineMarker.finallyStart(3);
                    ChannelsKt.cancelConsumed(receiveChannel6, th2);
                    InlineMarker.finallyEnd(3);
                    return null;
                }
                Object next2 = channelIterator.next();
                invoke = function12.invoke(next2);
                receiveChannel4 = receiveChannel2;
                function13 = function12;
                ReceiveChannel<? extends E> receiveChannel10 = receiveChannel3;
                obj2 = next2;
                receiveChannel5 = receiveChannel10;
                channelsKt__Channels_commonKt$minBy$1.L$0 = receiveChannel4;
                channelsKt__Channels_commonKt$minBy$1.L$1 = function13;
                channelsKt__Channels_commonKt$minBy$1.L$2 = receiveChannel6;
                channelsKt__Channels_commonKt$minBy$1.L$3 = th2;
                channelsKt__Channels_commonKt$minBy$1.L$4 = receiveChannel5;
                channelsKt__Channels_commonKt$minBy$1.L$5 = channelIterator;
                channelsKt__Channels_commonKt$minBy$1.L$6 = obj2;
                channelsKt__Channels_commonKt$minBy$1.L$7 = invoke;
                channelsKt__Channels_commonKt$minBy$1.label = 2;
                hasNext = channelIterator.hasNext(channelsKt__Channels_commonKt$minBy$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__Channels_commonKt$minBy$1 = new ChannelsKt__Channels_commonKt$minBy$1(continuation);
        obj = channelsKt__Channels_commonKt$minBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$minBy$1.label;
        if (i == 0) {
        }
        th2 = th;
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [1969=4, 3463=4] */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:114:0x0024 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:0x006d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00d9 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x009d A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00a1 A[Catch: all -> 0x006d, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:71:0x0044, B:96:0x00c4, B:98:0x00cc, B:76:0x0069, B:85:0x0095, B:89:0x00a1), top: B:114:0x0024 }] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x00cc A[Catch: all -> 0x006d, TRY_LEAVE, TryCatch #2 {all -> 0x006d, blocks: (B:71:0x0044, B:96:0x00c4, B:98:0x00cc, B:76:0x0069, B:85:0x0095, B:89:0x00a1), top: B:114:0x0024 }] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:95:0x00c0 -> B:96:0x00c4). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object minWith(ReceiveChannel<? extends E> receiveChannel, Comparator<? super E> comparator, Continuation<? super E> continuation) {
        ChannelsKt__Channels_commonKt$minWith$1 channelsKt__Channels_commonKt$minWith$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Comparator<? super E> comparator2;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Object next;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$minWith$1) {
                channelsKt__Channels_commonKt$minWith$1 = (ChannelsKt__Channels_commonKt$minWith$1) continuation;
                if ((channelsKt__Channels_commonKt$minWith$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$minWith$1.label -= Integer.MIN_VALUE;
                    obj = channelsKt__Channels_commonKt$minWith$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$minWith$1.label;
                    ReceiveChannel<? extends E> receiveChannel7 = 1;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj);
                        th = null;
                        try {
                            ChannelIterator<? extends E> it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel;
                            channelsKt__Channels_commonKt$minWith$1.L$1 = comparator;
                            channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel;
                            channelsKt__Channels_commonKt$minWith$1.L$3 = th;
                            channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel;
                            channelsKt__Channels_commonKt$minWith$1.L$5 = it;
                            channelsKt__Channels_commonKt$minWith$1.label = 1;
                            Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$minWith$1);
                            if (hasNext2 == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel2 = receiveChannel;
                            comparator2 = comparator;
                            receiveChannel3 = receiveChannel2;
                            channelIterator = it;
                            obj = hasNext2;
                            receiveChannel4 = receiveChannel3;
                        } catch (Throwable th3) {
                            receiveChannel7 = receiveChannel;
                            th = th3;
                            try {
                                throw th;
                            } finally {
                                ChannelsKt.cancelConsumed(receiveChannel7, th);
                            }
                        }
                    } else if (i == 1) {
                        channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$minWith$1.L$5;
                        receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$4;
                        th = (Throwable) channelsKt__Channels_commonKt$minWith$1.L$3;
                        receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__Channels_commonKt$minWith$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    } else {
                        Object obj2 = channelsKt__Channels_commonKt$minWith$1.L$6;
                        channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$minWith$1.L$5;
                        receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$4;
                        th2 = (Throwable) channelsKt__Channels_commonKt$minWith$1.L$3;
                        ReceiveChannel receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$2;
                        comparator2 = (Comparator) channelsKt__Channels_commonKt$minWith$1.L$1;
                        receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$minWith$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        receiveChannel7 = receiveChannel8;
                        if (!((Boolean) obj).booleanValue()) {
                            next = channelIterator2.next();
                            receiveChannel6 = receiveChannel7;
                            if (comparator2.compare(obj2, next) <= 0) {
                                next = obj2;
                                receiveChannel6 = receiveChannel7;
                            }
                            receiveChannel = receiveChannel6;
                            channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel2;
                            channelsKt__Channels_commonKt$minWith$1.L$1 = comparator2;
                            channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel;
                            channelsKt__Channels_commonKt$minWith$1.L$3 = th2;
                            channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel5;
                            channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator2;
                            channelsKt__Channels_commonKt$minWith$1.L$6 = next;
                            channelsKt__Channels_commonKt$minWith$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$minWith$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel7 = receiveChannel;
                            obj2 = next;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                return obj2;
                            }
                        }
                    }
                    if (((Boolean) obj).booleanValue()) {
                        return null;
                    }
                    next = channelIterator.next();
                    th2 = th;
                    receiveChannel5 = receiveChannel3;
                    channelIterator2 = channelIterator;
                    receiveChannel6 = receiveChannel4;
                    receiveChannel = receiveChannel6;
                    channelsKt__Channels_commonKt$minWith$1.L$0 = receiveChannel2;
                    channelsKt__Channels_commonKt$minWith$1.L$1 = comparator2;
                    channelsKt__Channels_commonKt$minWith$1.L$2 = receiveChannel;
                    channelsKt__Channels_commonKt$minWith$1.L$3 = th2;
                    channelsKt__Channels_commonKt$minWith$1.L$4 = receiveChannel5;
                    channelsKt__Channels_commonKt$minWith$1.L$5 = channelIterator2;
                    channelsKt__Channels_commonKt$minWith$1.L$6 = next;
                    channelsKt__Channels_commonKt$minWith$1.label = 2;
                    hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$minWith$1);
                    if (hasNext != coroutine_suspended) {
                    }
                }
            }
            if (i != 0) {
            }
            if (((Boolean) obj).booleanValue()) {
            }
        } catch (Throwable th4) {
            th = th4;
        }
        channelsKt__Channels_commonKt$minWith$1 = new ChannelsKt__Channels_commonKt$minWith$1(continuation);
        obj = channelsKt__Channels_commonKt$minWith$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$minWith$1.label;
        ReceiveChannel<? extends E> receiveChannel72 = 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x006b  */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$none$1 channelsKt__Channels_commonKt$none$1;
        int i;
        Throwable th;
        Object hasNext;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel2;
        if (continuation instanceof ChannelsKt__Channels_commonKt$none$1) {
            channelsKt__Channels_commonKt$none$1 = (ChannelsKt__Channels_commonKt$none$1) continuation;
            if ((channelsKt__Channels_commonKt$none$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$none$1.label -= Integer.MIN_VALUE;
                Object obj = channelsKt__Channels_commonKt$none$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$none$1.label;
                boolean z = true;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$none$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.L$1 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.L$2 = th;
                        channelsKt__Channels_commonKt$none$1.L$3 = receiveChannel;
                        channelsKt__Channels_commonKt$none$1.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$none$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Throwable th3) {
                        receiveChannel2 = receiveChannel;
                        th2 = th3;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ReceiveChannel receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$3;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$none$1.L$2;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$1;
                    ReceiveChannel receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$none$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        hasNext = obj;
                        th = th4;
                        receiveChannel = receiveChannel2;
                    } catch (Throwable th5) {
                        th2 = th5;
                        try {
                            throw th2;
                        } finally {
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                        }
                    }
                }
                if (!((Boolean) hasNext).booleanValue()) {
                    z = false;
                }
                return Boxing.boxBoolean(z);
            }
        }
        channelsKt__Channels_commonKt$none$1 = new ChannelsKt__Channels_commonKt$none$1(continuation);
        Object obj2 = channelsKt__Channels_commonKt$none$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$none$1.label;
        boolean z2 = true;
        if (i != 0) {
        }
        if (!((Boolean) hasNext).booleanValue()) {
        }
        return Boxing.boxBoolean(z2);
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0084 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0092 A[Catch: all -> 0x00c6, TryCatch #0 {all -> 0x00c6, blocks: (B:76:0x008a, B:78:0x0092, B:80:0x00a2, B:72:0x006e, B:84:0x00b6), top: B:95:0x008a }] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00b6 A[Catch: all -> 0x00c6, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x00c6, blocks: (B:76:0x008a, B:78:0x0092, B:80:0x00a2, B:72:0x006e, B:84:0x00b6), top: B:95:0x008a }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x0085 -> B:95:0x008a). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object none(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Boolean> continuation) {
        ChannelsKt__Channels_commonKt$none$3 channelsKt__Channels_commonKt$none$3;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Throwable th2;
        ChannelsKt__Channels_commonKt$none$3 channelsKt__Channels_commonKt$none$32;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Function1<? super E, Boolean> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$none$3) {
                channelsKt__Channels_commonKt$none$3 = (ChannelsKt__Channels_commonKt$none$3) continuation;
                if ((channelsKt__Channels_commonKt$none$3.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$none$3.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$none$3.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$none$3.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        try {
                            th2 = null;
                            channelsKt__Channels_commonKt$none$32 = channelsKt__Channels_commonKt$none$3;
                            obj = coroutine_suspended;
                            receiveChannel3 = receiveChannel;
                            receiveChannel2 = receiveChannel3;
                            receiveChannel4 = receiveChannel2;
                            it = receiveChannel.iterator();
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            channelsKt__Channels_commonKt$none$32.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$none$32.L$1 = function12;
                            channelsKt__Channels_commonKt$none$32.L$2 = receiveChannel3;
                            channelsKt__Channels_commonKt$none$32.L$3 = receiveChannel2;
                            channelsKt__Channels_commonKt$none$32.L$4 = th2;
                            channelsKt__Channels_commonKt$none$32.L$5 = receiveChannel4;
                            channelsKt__Channels_commonKt$none$32.L$6 = it;
                            channelsKt__Channels_commonKt$none$32.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$none$32);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$none$3.L$6;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$none$3.L$5;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$none$3.L$4;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$none$3.L$3;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$none$3.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$none$3.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$none$3.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Throwable th5 = th4;
                            function12 = function13;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$none$32 = channelsKt__Channels_commonKt$none$3;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (((Boolean) obj2).booleanValue()) {
                                    if (function12.invoke((Object) channelIterator2.next()).booleanValue()) {
                                        Boolean boxBoolean = Boxing.boxBoolean(false);
                                        InlineMarker.finallyStart(2);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(2);
                                        return boxBoolean;
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$none$32.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$none$32.L$1 = function12;
                                    channelsKt__Channels_commonKt$none$32.L$2 = receiveChannel3;
                                    channelsKt__Channels_commonKt$none$32.L$3 = receiveChannel2;
                                    channelsKt__Channels_commonKt$none$32.L$4 = th2;
                                    channelsKt__Channels_commonKt$none$32.L$5 = receiveChannel4;
                                    channelsKt__Channels_commonKt$none$32.L$6 = it;
                                    channelsKt__Channels_commonKt$none$32.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$none$32);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (((Boolean) obj2).booleanValue()) {
                                    }
                                } else {
                                    Unit unit = Unit.INSTANCE;
                                    InlineMarker.finallyStart(1);
                                    ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                    InlineMarker.finallyEnd(1);
                                    return Boxing.boxBoolean(true);
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$none$3 = new ChannelsKt__Channels_commonKt$none$3(continuation);
        Object obj22 = channelsKt__Channels_commonKt$none$3.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$none$3.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2032=5] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00e3 A[Catch: all -> 0x0070, TRY_ENTER, TryCatch #0 {all -> 0x0070, blocks: (B:78:0x006c, B:87:0x0099, B:89:0x00a1, B:101:0x00e3, B:102:0x00ec), top: B:109:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00a1 A[Catch: all -> 0x0070, TRY_LEAVE, TryCatch #0 {all -> 0x0070, blocks: (B:78:0x006c, B:87:0x0099, B:89:0x00a1, B:101:0x00e3, B:102:0x00ec), top: B:109:0x006c }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00cf A[Catch: all -> 0x0048, TRY_LEAVE, TryCatch #2 {all -> 0x0048, blocks: (B:71:0x0043, B:95:0x00c7, B:97:0x00cf), top: B:112:0x0043 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00d9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x00c3 -> B:95:0x00c7). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S, E extends S> Object reduce(ReceiveChannel<? extends E> receiveChannel, Function2<? super S, ? super E, ? extends S> function2, Continuation<? super S> continuation) {
        ChannelsKt__Channels_commonKt$reduce$1 channelsKt__Channels_commonKt$reduce$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Function2<? super S, ? super E, ? extends S> function22;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Object next;
        ReceiveChannel<? extends E> receiveChannel5;
        Function2<? super S, ? super E, ? extends S> function23;
        ChannelIterator channelIterator2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel6;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$reduce$1) {
            channelsKt__Channels_commonKt$reduce$1 = (ChannelsKt__Channels_commonKt$reduce$1) continuation;
            if ((channelsKt__Channels_commonKt$reduce$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$reduce$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$reduce$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$reduce$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$reduce$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$reduce$1.L$1 = function2;
                        channelsKt__Channels_commonKt$reduce$1.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$reduce$1.L$3 = th;
                        channelsKt__Channels_commonKt$reduce$1.L$4 = receiveChannel;
                        channelsKt__Channels_commonKt$reduce$1.L$5 = it;
                        channelsKt__Channels_commonKt$reduce$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$reduce$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        function22 = function2;
                        receiveChannel3 = receiveChannel2;
                        channelIterator = it;
                        obj = hasNext2;
                        receiveChannel4 = receiveChannel3;
                    } catch (Throwable th3) {
                        receiveChannel4 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$reduce$1.L$5;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$4;
                    th = (Throwable) channelsKt__Channels_commonKt$reduce$1.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$2;
                    function22 = (Function2) channelsKt__Channels_commonKt$reduce$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Object obj2 = channelsKt__Channels_commonKt$reduce$1.L$6;
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$reduce$1.L$5;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$reduce$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$2;
                    function23 = (Function2) channelsKt__Channels_commonKt$reduce$1.L$1;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$reduce$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            next = function23.invoke(obj2, (Object) channelIterator2.next());
                            receiveChannel = receiveChannel7;
                            channelsKt__Channels_commonKt$reduce$1.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$reduce$1.L$1 = function23;
                            channelsKt__Channels_commonKt$reduce$1.L$2 = receiveChannel;
                            channelsKt__Channels_commonKt$reduce$1.L$3 = th2;
                            channelsKt__Channels_commonKt$reduce$1.L$4 = receiveChannel6;
                            channelsKt__Channels_commonKt$reduce$1.L$5 = channelIterator2;
                            channelsKt__Channels_commonKt$reduce$1.L$6 = next;
                            channelsKt__Channels_commonKt$reduce$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$reduce$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel7 = receiveChannel;
                            obj2 = next;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                InlineMarker.finallyStart(2);
                                ChannelsKt.cancelConsumed(receiveChannel7, th2);
                                InlineMarker.finallyEnd(2);
                                return obj2;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel4 = receiveChannel7;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel4, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new UnsupportedOperationException("Empty channel can't be reduced.");
                }
                next = channelIterator.next();
                receiveChannel5 = receiveChannel2;
                function23 = function22;
                ReceiveChannel<? extends E> receiveChannel8 = receiveChannel3;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                th2 = th;
                receiveChannel6 = receiveChannel8;
                channelsKt__Channels_commonKt$reduce$1.L$0 = receiveChannel5;
                channelsKt__Channels_commonKt$reduce$1.L$1 = function23;
                channelsKt__Channels_commonKt$reduce$1.L$2 = receiveChannel;
                channelsKt__Channels_commonKt$reduce$1.L$3 = th2;
                channelsKt__Channels_commonKt$reduce$1.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$reduce$1.L$5 = channelIterator2;
                channelsKt__Channels_commonKt$reduce$1.L$6 = next;
                channelsKt__Channels_commonKt$reduce$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$reduce$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__Channels_commonKt$reduce$1 = new ChannelsKt__Channels_commonKt$reduce$1(continuation);
        obj = channelsKt__Channels_commonKt$reduce$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$reduce$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [2059=5] */
    /* JADX WARN: Removed duplicated region for block: B:101:0x00ed A[Catch: all -> 0x0072, TRY_ENTER, TryCatch #0 {all -> 0x0072, blocks: (B:78:0x006e, B:87:0x009b, B:89:0x00a3, B:101:0x00ed, B:102:0x00f6), top: B:109:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00a3 A[Catch: all -> 0x0072, TRY_LEAVE, TryCatch #0 {all -> 0x0072, blocks: (B:78:0x006e, B:87:0x009b, B:89:0x00a3, B:101:0x00ed, B:102:0x00f6), top: B:109:0x006e }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00d3 A[Catch: all -> 0x004a, TRY_LEAVE, TryCatch #2 {all -> 0x004a, blocks: (B:71:0x0045, B:95:0x00cb, B:97:0x00d3), top: B:112:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00e3  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:94:0x00c7 -> B:95:0x00cb). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <S, E extends S> Object reduceIndexed(ReceiveChannel<? extends E> receiveChannel, Function3<? super Integer, ? super S, ? super E, ? extends S> function3, Continuation<? super S> continuation) {
        ChannelsKt__Channels_commonKt$reduceIndexed$1 channelsKt__Channels_commonKt$reduceIndexed$1;
        Object obj;
        int i;
        Throwable th;
        ReceiveChannel<? extends E> receiveChannel2;
        Function3<? super Integer, ? super S, ? super E, ? extends S> function32;
        ReceiveChannel<? extends E> receiveChannel3;
        ChannelIterator channelIterator;
        ReceiveChannel<? extends E> receiveChannel4;
        Object next;
        Function3<? super Integer, ? super S, ? super E, ? extends S> function33;
        ReceiveChannel<? extends E> receiveChannel5;
        Throwable th2;
        ChannelIterator channelIterator2;
        ReceiveChannel<? extends E> receiveChannel6;
        int i2;
        Object hasNext;
        if (continuation instanceof ChannelsKt__Channels_commonKt$reduceIndexed$1) {
            channelsKt__Channels_commonKt$reduceIndexed$1 = (ChannelsKt__Channels_commonKt$reduceIndexed$1) continuation;
            if ((channelsKt__Channels_commonKt$reduceIndexed$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$reduceIndexed$1.label -= Integer.MIN_VALUE;
                obj = channelsKt__Channels_commonKt$reduceIndexed$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$reduceIndexed$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj);
                    th = null;
                    try {
                        ChannelIterator<? extends E> it = receiveChannel.iterator();
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$0 = receiveChannel;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$1 = function3;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$2 = receiveChannel;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$3 = th;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$4 = receiveChannel;
                        channelsKt__Channels_commonKt$reduceIndexed$1.L$5 = it;
                        channelsKt__Channels_commonKt$reduceIndexed$1.label = 1;
                        Object hasNext2 = it.hasNext(channelsKt__Channels_commonKt$reduceIndexed$1);
                        if (hasNext2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        receiveChannel2 = receiveChannel;
                        function32 = function3;
                        receiveChannel3 = receiveChannel2;
                        channelIterator = it;
                        obj = hasNext2;
                        receiveChannel4 = receiveChannel3;
                    } catch (Throwable th3) {
                        receiveChannel4 = receiveChannel;
                        th = th3;
                        throw th;
                    }
                } else if (i == 1) {
                    channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$reduceIndexed$1.L$5;
                    receiveChannel3 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$4;
                    th = (Throwable) channelsKt__Channels_commonKt$reduceIndexed$1.L$3;
                    receiveChannel4 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$2;
                    function32 = (Function3) channelsKt__Channels_commonKt$reduceIndexed$1.L$1;
                    receiveChannel2 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Throwable th4) {
                        th = th4;
                        throw th;
                    }
                } else if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    Object obj2 = channelsKt__Channels_commonKt$reduceIndexed$1.L$6;
                    i2 = channelsKt__Channels_commonKt$reduceIndexed$1.I$0;
                    channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$reduceIndexed$1.L$5;
                    receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$4;
                    th2 = (Throwable) channelsKt__Channels_commonKt$reduceIndexed$1.L$3;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$2;
                    function33 = (Function3) channelsKt__Channels_commonKt$reduceIndexed$1.L$1;
                    receiveChannel5 = (ReceiveChannel) channelsKt__Channels_commonKt$reduceIndexed$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                        if (!((Boolean) obj).booleanValue()) {
                            Integer boxInt = Boxing.boxInt(i2);
                            i2++;
                            next = function33.invoke(boxInt, obj2, (Object) channelIterator2.next());
                            receiveChannel = receiveChannel7;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$1 = function33;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$2 = receiveChannel;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$3 = th2;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$4 = receiveChannel6;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$5 = channelIterator2;
                            channelsKt__Channels_commonKt$reduceIndexed$1.I$0 = i2;
                            channelsKt__Channels_commonKt$reduceIndexed$1.L$6 = next;
                            channelsKt__Channels_commonKt$reduceIndexed$1.label = 2;
                            hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$reduceIndexed$1);
                            if (hasNext != coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            receiveChannel7 = receiveChannel;
                            obj2 = next;
                            obj = hasNext;
                            if (!((Boolean) obj).booleanValue()) {
                                InlineMarker.finallyStart(2);
                                ChannelsKt.cancelConsumed(receiveChannel7, th2);
                                InlineMarker.finallyEnd(2);
                                return obj2;
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        receiveChannel4 = receiveChannel7;
                        try {
                            throw th;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel4, th);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                }
                if (((Boolean) obj).booleanValue()) {
                    throw new UnsupportedOperationException("Empty channel can't be reduced.");
                }
                next = channelIterator.next();
                function33 = function32;
                receiveChannel5 = receiveChannel2;
                th2 = th;
                channelIterator2 = channelIterator;
                receiveChannel = receiveChannel4;
                receiveChannel6 = receiveChannel3;
                i2 = 1;
                channelsKt__Channels_commonKt$reduceIndexed$1.L$0 = receiveChannel5;
                channelsKt__Channels_commonKt$reduceIndexed$1.L$1 = function33;
                channelsKt__Channels_commonKt$reduceIndexed$1.L$2 = receiveChannel;
                channelsKt__Channels_commonKt$reduceIndexed$1.L$3 = th2;
                channelsKt__Channels_commonKt$reduceIndexed$1.L$4 = receiveChannel6;
                channelsKt__Channels_commonKt$reduceIndexed$1.L$5 = channelIterator2;
                channelsKt__Channels_commonKt$reduceIndexed$1.I$0 = i2;
                channelsKt__Channels_commonKt$reduceIndexed$1.L$6 = next;
                channelsKt__Channels_commonKt$reduceIndexed$1.label = 2;
                hasNext = channelIterator2.hasNext(channelsKt__Channels_commonKt$reduceIndexed$1);
                if (hasNext != coroutine_suspended) {
                }
            }
        }
        channelsKt__Channels_commonKt$reduceIndexed$1 = new ChannelsKt__Channels_commonKt$reduceIndexed$1(continuation);
        obj = channelsKt__Channels_commonKt$reduceIndexed$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$reduceIndexed$1.label;
        if (i != 0) {
        }
        if (((Boolean) obj).booleanValue()) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0095 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00a4 A[Catch: all -> 0x00ce, TryCatch #3 {all -> 0x00ce, blocks: (B:72:0x009c, B:74:0x00a4, B:68:0x007d, B:75:0x00bc), top: B:92:0x009c }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00bc A[Catch: all -> 0x00ce, TRY_LEAVE, TryCatch #3 {all -> 0x00ce, blocks: (B:72:0x009c, B:74:0x00a4, B:68:0x007d, B:75:0x00bc), top: B:92:0x009c }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0096 -> B:92:0x009c). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object sumBy(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Integer> function1, Continuation<? super Integer> continuation) {
        ChannelsKt__Channels_commonKt$sumBy$1 channelsKt__Channels_commonKt$sumBy$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        Ref.IntRef intRef;
        Object obj;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        Function1<? super E, Integer> function12;
        ReceiveChannel<? extends E> receiveChannel5;
        ChannelIterator<? extends E> it;
        ChannelsKt__Channels_commonKt$sumBy$1 channelsKt__Channels_commonKt$sumBy$12;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$sumBy$1) {
                channelsKt__Channels_commonKt$sumBy$1 = (ChannelsKt__Channels_commonKt$sumBy$1) continuation;
                if ((channelsKt__Channels_commonKt$sumBy$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$sumBy$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$sumBy$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$sumBy$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Ref.IntRef intRef2 = new Ref.IntRef();
                        intRef2.element = 0;
                        try {
                            intRef = intRef2;
                            obj = coroutine_suspended;
                            th2 = null;
                            receiveChannel3 = receiveChannel;
                            receiveChannel4 = receiveChannel3;
                            function12 = function1;
                            receiveChannel5 = receiveChannel4;
                            it = receiveChannel.iterator();
                            channelsKt__Channels_commonKt$sumBy$12 = channelsKt__Channels_commonKt$sumBy$1;
                            receiveChannel2 = receiveChannel5;
                            channelsKt__Channels_commonKt$sumBy$12.L$0 = receiveChannel5;
                            channelsKt__Channels_commonKt$sumBy$12.L$1 = function12;
                            channelsKt__Channels_commonKt$sumBy$12.L$2 = intRef;
                            channelsKt__Channels_commonKt$sumBy$12.L$3 = receiveChannel3;
                            channelsKt__Channels_commonKt$sumBy$12.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$sumBy$12.L$5 = th2;
                            channelsKt__Channels_commonKt$sumBy$12.L$6 = receiveChannel4;
                            channelsKt__Channels_commonKt$sumBy$12.L$7 = it;
                            channelsKt__Channels_commonKt$sumBy$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$sumBy$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th3) {
                            receiveChannel2 = receiveChannel;
                            th = th3;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$sumBy$1.L$7;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$sumBy$1.L$6;
                        Throwable th4 = (Throwable) channelsKt__Channels_commonKt$sumBy$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$sumBy$1.L$4;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$sumBy$1.L$3;
                        Ref.IntRef intRef3 = (Ref.IntRef) channelsKt__Channels_commonKt$sumBy$1.L$2;
                        Function1<? super E, Integer> function13 = (Function1) channelsKt__Channels_commonKt$sumBy$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$sumBy$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel4 = receiveChannel6;
                            receiveChannel5 = receiveChannel9;
                            Ref.IntRef intRef4 = intRef3;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$sumBy$12 = channelsKt__Channels_commonKt$sumBy$1;
                            receiveChannel2 = receiveChannel7;
                            Throwable th5 = th4;
                            function12 = function13;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    intRef4.element += function12.invoke((Object) channelIterator2.next()).intValue();
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th5;
                                    intRef = intRef4;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$sumBy$12.L$0 = receiveChannel5;
                                    channelsKt__Channels_commonKt$sumBy$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$sumBy$12.L$2 = intRef;
                                    channelsKt__Channels_commonKt$sumBy$12.L$3 = receiveChannel3;
                                    channelsKt__Channels_commonKt$sumBy$12.L$4 = receiveChannel2;
                                    channelsKt__Channels_commonKt$sumBy$12.L$5 = th2;
                                    channelsKt__Channels_commonKt$sumBy$12.L$6 = receiveChannel4;
                                    channelsKt__Channels_commonKt$sumBy$12.L$7 = it;
                                    channelsKt__Channels_commonKt$sumBy$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$sumBy$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj4 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    intRef4 = intRef;
                                    th5 = th2;
                                    obj3 = obj4;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th5);
                                        InlineMarker.finallyEnd(1);
                                        return Boxing.boxInt(intRef4.element);
                                    }
                                }
                            } catch (Throwable th6) {
                                th = th6;
                            }
                        } catch (Throwable th7) {
                            th = th7;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th8) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th8;
        }
        channelsKt__Channels_commonKt$sumBy$1 = new ChannelsKt__Channels_commonKt$sumBy$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$sumBy$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$sumBy$1.label;
        if (i != 0) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x009f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00ad A[Catch: all -> 0x00d4, TryCatch #0 {all -> 0x00d4, blocks: (B:73:0x00a5, B:75:0x00ad, B:69:0x0087, B:76:0x00c2), top: B:88:0x00a5 }] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00c2 A[Catch: all -> 0x00d4, TRY_LEAVE, TryCatch #0 {all -> 0x00d4, blocks: (B:73:0x00a5, B:75:0x00ad, B:69:0x0087, B:76:0x00c2), top: B:88:0x00a5 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:72:0x00a0 -> B:88:0x00a5). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object sumByDouble(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Double> function1, Continuation<? super Double> continuation) {
        ChannelsKt__Channels_commonKt$sumByDouble$1 channelsKt__Channels_commonKt$sumByDouble$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Ref.DoubleRef doubleRef;
        ChannelsKt__Channels_commonKt$sumByDouble$1 channelsKt__Channels_commonKt$sumByDouble$12;
        Object obj;
        Throwable th;
        ChannelIterator<? extends E> it;
        ReceiveChannel<? extends E> receiveChannel3;
        ReceiveChannel<? extends E> receiveChannel4;
        ReceiveChannel<? extends E> receiveChannel5;
        Function1<? super E, Double> function12;
        Throwable th2;
        Object hasNext;
        ChannelIterator<? extends E> channelIterator;
        if (continuation instanceof ChannelsKt__Channels_commonKt$sumByDouble$1) {
            channelsKt__Channels_commonKt$sumByDouble$1 = (ChannelsKt__Channels_commonKt$sumByDouble$1) continuation;
            if ((channelsKt__Channels_commonKt$sumByDouble$1.label & Integer.MIN_VALUE) != 0) {
                channelsKt__Channels_commonKt$sumByDouble$1.label -= Integer.MIN_VALUE;
                Object obj2 = channelsKt__Channels_commonKt$sumByDouble$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i = channelsKt__Channels_commonKt$sumByDouble$1.label;
                if (i != 0) {
                    ResultKt.throwOnFailure(obj2);
                    Ref.DoubleRef doubleRef2 = new Ref.DoubleRef();
                    doubleRef2.element = 0.0d;
                    try {
                        doubleRef = doubleRef2;
                        channelsKt__Channels_commonKt$sumByDouble$12 = channelsKt__Channels_commonKt$sumByDouble$1;
                        obj = coroutine_suspended;
                        th = null;
                        it = receiveChannel.iterator();
                        receiveChannel3 = receiveChannel;
                        receiveChannel4 = receiveChannel3;
                        receiveChannel2 = receiveChannel4;
                        receiveChannel5 = receiveChannel2;
                        function12 = function1;
                        channelsKt__Channels_commonKt$sumByDouble$12.L$0 = receiveChannel3;
                        channelsKt__Channels_commonKt$sumByDouble$12.L$1 = function12;
                        channelsKt__Channels_commonKt$sumByDouble$12.L$2 = doubleRef;
                        channelsKt__Channels_commonKt$sumByDouble$12.L$3 = receiveChannel4;
                        channelsKt__Channels_commonKt$sumByDouble$12.L$4 = receiveChannel2;
                        channelsKt__Channels_commonKt$sumByDouble$12.L$5 = th;
                        channelsKt__Channels_commonKt$sumByDouble$12.L$6 = receiveChannel5;
                        channelsKt__Channels_commonKt$sumByDouble$12.L$7 = it;
                        channelsKt__Channels_commonKt$sumByDouble$12.label = 1;
                        hasNext = it.hasNext(channelsKt__Channels_commonKt$sumByDouble$12);
                        if (hasNext != obj) {
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        receiveChannel2 = receiveChannel;
                        th2 = th;
                        throw th2;
                    }
                } else if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                } else {
                    ChannelIterator<? extends E> channelIterator2 = (ChannelIterator) channelsKt__Channels_commonKt$sumByDouble$1.L$7;
                    ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$sumByDouble$1.L$6;
                    Throwable th4 = (Throwable) channelsKt__Channels_commonKt$sumByDouble$1.L$5;
                    ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$sumByDouble$1.L$4;
                    ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$sumByDouble$1.L$3;
                    Ref.DoubleRef doubleRef3 = (Ref.DoubleRef) channelsKt__Channels_commonKt$sumByDouble$1.L$2;
                    Function1<? super E, Double> function13 = (Function1) channelsKt__Channels_commonKt$sumByDouble$1.L$1;
                    ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$sumByDouble$1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj2);
                        channelsKt__Channels_commonKt$sumByDouble$12 = channelsKt__Channels_commonKt$sumByDouble$1;
                        receiveChannel4 = receiveChannel8;
                        channelIterator = channelIterator2;
                        receiveChannel5 = receiveChannel6;
                        function12 = function13;
                        doubleRef = doubleRef3;
                        th = th4;
                        obj = coroutine_suspended;
                        receiveChannel2 = receiveChannel7;
                    } catch (Throwable th5) {
                        th2 = th5;
                        receiveChannel2 = receiveChannel7;
                        try {
                            throw th2;
                        } catch (Throwable th6) {
                            InlineMarker.finallyStart(1);
                            ChannelsKt.cancelConsumed(receiveChannel2, th2);
                            InlineMarker.finallyEnd(1);
                            throw th6;
                        }
                    }
                    try {
                        if (!((Boolean) obj2).booleanValue()) {
                            doubleRef.element += function12.invoke((Object) channelIterator.next()).doubleValue();
                            receiveChannel3 = receiveChannel9;
                            it = channelIterator;
                            channelsKt__Channels_commonKt$sumByDouble$12.L$0 = receiveChannel3;
                            channelsKt__Channels_commonKt$sumByDouble$12.L$1 = function12;
                            channelsKt__Channels_commonKt$sumByDouble$12.L$2 = doubleRef;
                            channelsKt__Channels_commonKt$sumByDouble$12.L$3 = receiveChannel4;
                            channelsKt__Channels_commonKt$sumByDouble$12.L$4 = receiveChannel2;
                            channelsKt__Channels_commonKt$sumByDouble$12.L$5 = th;
                            channelsKt__Channels_commonKt$sumByDouble$12.L$6 = receiveChannel5;
                            channelsKt__Channels_commonKt$sumByDouble$12.L$7 = it;
                            channelsKt__Channels_commonKt$sumByDouble$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$sumByDouble$12);
                            if (hasNext != obj) {
                                return obj;
                            }
                            receiveChannel9 = receiveChannel3;
                            obj2 = hasNext;
                            channelIterator = it;
                            if (!((Boolean) obj2).booleanValue()) {
                                Unit unit = Unit.INSTANCE;
                                InlineMarker.finallyStart(1);
                                ChannelsKt.cancelConsumed(receiveChannel2, th);
                                InlineMarker.finallyEnd(1);
                                return Boxing.boxDouble(doubleRef.element);
                            }
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        th2 = th;
                        throw th2;
                    }
                }
            }
        }
        channelsKt__Channels_commonKt$sumByDouble$1 = new ChannelsKt__Channels_commonKt$sumByDouble$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$sumByDouble$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$sumByDouble$1.label;
        if (i != 0) {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E> ReceiveChannel<E> requireNoNulls(ReceiveChannel<? extends E> requireNoNulls) {
        ReceiveChannel<E> map$default;
        Intrinsics.checkParameterIsNotNull(requireNoNulls, "$this$requireNoNulls");
        map$default = map$default(requireNoNulls, null, new ChannelsKt__Channels_commonKt$requireNoNulls$1(requireNoNulls, null), 1, null);
        return map$default;
    }

    /* JADX WARN: Removed duplicated region for block: B:61:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x009e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00ae A[Catch: all -> 0x00dc, TryCatch #2 {all -> 0x00dc, blocks: (B:76:0x00a6, B:78:0x00ae, B:80:0x00be, B:72:0x0084, B:81:0x00c2, B:83:0x00cb), top: B:98:0x00a6 }] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00cb A[Catch: all -> 0x00dc, TRY_LEAVE, TryCatch #2 {all -> 0x00dc, blocks: (B:76:0x00a6, B:78:0x00ae, B:80:0x00be, B:72:0x0084, B:81:0x00c2, B:83:0x00cb), top: B:98:0x00a6 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:75:0x009f -> B:98:0x00a6). Please submit an issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <E> Object partition(ReceiveChannel<? extends E> receiveChannel, Function1<? super E, Boolean> function1, Continuation<? super Pair<? extends List<? extends E>, ? extends List<? extends E>>> continuation) {
        ChannelsKt__Channels_commonKt$partition$1 channelsKt__Channels_commonKt$partition$1;
        int i;
        ReceiveChannel<? extends E> receiveChannel2;
        Throwable th;
        ArrayList arrayList;
        ArrayList arrayList2;
        Throwable th2;
        ReceiveChannel<? extends E> receiveChannel3;
        Function1<? super E, Boolean> function12;
        ChannelsKt__Channels_commonKt$partition$1 channelsKt__Channels_commonKt$partition$12;
        ReceiveChannel<? extends E> receiveChannel4;
        ChannelIterator<? extends E> it;
        Object obj;
        ReceiveChannel<? extends E> receiveChannel5;
        Object hasNext;
        try {
            if (continuation instanceof ChannelsKt__Channels_commonKt$partition$1) {
                channelsKt__Channels_commonKt$partition$1 = (ChannelsKt__Channels_commonKt$partition$1) continuation;
                if ((channelsKt__Channels_commonKt$partition$1.label & Integer.MIN_VALUE) != 0) {
                    channelsKt__Channels_commonKt$partition$1.label -= Integer.MIN_VALUE;
                    Object obj2 = channelsKt__Channels_commonKt$partition$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i = channelsKt__Channels_commonKt$partition$1.label;
                    if (i != 0) {
                        ResultKt.throwOnFailure(obj2);
                        Throwable th3 = null;
                        try {
                            arrayList = new ArrayList();
                            arrayList2 = new ArrayList();
                            th2 = th3;
                            receiveChannel3 = receiveChannel;
                            function12 = function1;
                            channelsKt__Channels_commonKt$partition$12 = channelsKt__Channels_commonKt$partition$1;
                            receiveChannel4 = receiveChannel3;
                            receiveChannel2 = receiveChannel4;
                            it = receiveChannel.iterator();
                            obj = coroutine_suspended;
                            receiveChannel5 = receiveChannel2;
                            channelsKt__Channels_commonKt$partition$12.L$0 = receiveChannel4;
                            channelsKt__Channels_commonKt$partition$12.L$1 = function12;
                            channelsKt__Channels_commonKt$partition$12.L$2 = arrayList;
                            channelsKt__Channels_commonKt$partition$12.L$3 = arrayList2;
                            channelsKt__Channels_commonKt$partition$12.L$4 = receiveChannel3;
                            channelsKt__Channels_commonKt$partition$12.L$5 = receiveChannel2;
                            channelsKt__Channels_commonKt$partition$12.L$6 = th2;
                            channelsKt__Channels_commonKt$partition$12.L$7 = receiveChannel5;
                            channelsKt__Channels_commonKt$partition$12.L$8 = it;
                            channelsKt__Channels_commonKt$partition$12.label = 1;
                            hasNext = it.hasNext(channelsKt__Channels_commonKt$partition$12);
                            if (hasNext != obj) {
                            }
                        } catch (Throwable th4) {
                            receiveChannel2 = receiveChannel;
                            th = th4;
                        }
                    } else if (i == 1) {
                        ChannelIterator<? extends E> channelIterator = (ChannelIterator) channelsKt__Channels_commonKt$partition$1.L$8;
                        ReceiveChannel<? extends E> receiveChannel6 = (ReceiveChannel) channelsKt__Channels_commonKt$partition$1.L$7;
                        Throwable th5 = (Throwable) channelsKt__Channels_commonKt$partition$1.L$6;
                        ReceiveChannel<? extends E> receiveChannel7 = (ReceiveChannel) channelsKt__Channels_commonKt$partition$1.L$5;
                        ReceiveChannel<? extends E> receiveChannel8 = (ReceiveChannel) channelsKt__Channels_commonKt$partition$1.L$4;
                        ArrayList arrayList3 = (ArrayList) channelsKt__Channels_commonKt$partition$1.L$3;
                        ArrayList arrayList4 = (ArrayList) channelsKt__Channels_commonKt$partition$1.L$2;
                        Function1<? super E, Boolean> function13 = (Function1) channelsKt__Channels_commonKt$partition$1.L$1;
                        ReceiveChannel<? extends E> receiveChannel9 = (ReceiveChannel) channelsKt__Channels_commonKt$partition$1.L$0;
                        try {
                            ResultKt.throwOnFailure(obj2);
                            receiveChannel5 = receiveChannel6;
                            receiveChannel4 = receiveChannel9;
                            ArrayList arrayList5 = arrayList4;
                            Throwable th6 = th5;
                            function12 = function13;
                            ArrayList arrayList6 = arrayList3;
                            Object obj3 = coroutine_suspended;
                            channelsKt__Channels_commonKt$partition$12 = channelsKt__Channels_commonKt$partition$1;
                            receiveChannel2 = receiveChannel7;
                            ChannelIterator<? extends E> channelIterator2 = channelIterator;
                            try {
                                if (!((Boolean) obj2).booleanValue()) {
                                    Object obj4 = (Object) channelIterator2.next();
                                    if (function12.invoke(obj4).booleanValue()) {
                                        arrayList5.add(obj4);
                                    } else {
                                        arrayList6.add(obj4);
                                    }
                                    receiveChannel3 = receiveChannel8;
                                    obj = obj3;
                                    th2 = th6;
                                    arrayList2 = arrayList6;
                                    arrayList = arrayList5;
                                    it = channelIterator2;
                                    channelsKt__Channels_commonKt$partition$12.L$0 = receiveChannel4;
                                    channelsKt__Channels_commonKt$partition$12.L$1 = function12;
                                    channelsKt__Channels_commonKt$partition$12.L$2 = arrayList;
                                    channelsKt__Channels_commonKt$partition$12.L$3 = arrayList2;
                                    channelsKt__Channels_commonKt$partition$12.L$4 = receiveChannel3;
                                    channelsKt__Channels_commonKt$partition$12.L$5 = receiveChannel2;
                                    channelsKt__Channels_commonKt$partition$12.L$6 = th2;
                                    channelsKt__Channels_commonKt$partition$12.L$7 = receiveChannel5;
                                    channelsKt__Channels_commonKt$partition$12.L$8 = it;
                                    channelsKt__Channels_commonKt$partition$12.label = 1;
                                    hasNext = it.hasNext(channelsKt__Channels_commonKt$partition$12);
                                    if (hasNext != obj) {
                                        return obj;
                                    }
                                    Object obj5 = obj;
                                    receiveChannel8 = receiveChannel3;
                                    obj2 = hasNext;
                                    arrayList5 = arrayList;
                                    arrayList6 = arrayList2;
                                    th6 = th2;
                                    obj3 = obj5;
                                    channelIterator2 = it;
                                    if (!((Boolean) obj2).booleanValue()) {
                                        Unit unit = Unit.INSTANCE;
                                        InlineMarker.finallyStart(1);
                                        ChannelsKt.cancelConsumed(receiveChannel2, th6);
                                        InlineMarker.finallyEnd(1);
                                        return new Pair(arrayList5, arrayList6);
                                    }
                                }
                            } catch (Throwable th7) {
                                th = th7;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            receiveChannel2 = receiveChannel7;
                        }
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    throw th;
                }
            }
            throw th;
        } catch (Throwable th9) {
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel2, th);
            InlineMarker.finallyEnd(1);
            throw th9;
        }
        channelsKt__Channels_commonKt$partition$1 = new ChannelsKt__Channels_commonKt$partition$1(continuation);
        Object obj22 = channelsKt__Channels_commonKt$partition$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i = channelsKt__Channels_commonKt$partition$1.label;
        if (i != 0) {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object partition$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    if (((Boolean) function1.invoke(next)).booleanValue()) {
                        arrayList.add(next);
                    } else {
                        arrayList2.add(next);
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return new Pair(arrayList, arrayList2);
                }
            }
        } finally {
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R> ReceiveChannel<Pair<E, R>> zip(ReceiveChannel<? extends E> zip, ReceiveChannel<? extends R> other) {
        ReceiveChannel<Pair<E, R>> zip$default;
        Intrinsics.checkParameterIsNotNull(zip, "$this$zip");
        Intrinsics.checkParameterIsNotNull(other, "other");
        zip$default = zip$default(zip, other, null, new Function2<E, R, Pair<? extends E, ? extends R>>() { // from class: kotlinx.coroutines.channels.ChannelsKt__Channels_commonKt$zip$1
            /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
            /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Object */
            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke((ChannelsKt__Channels_commonKt$zip$1<E, R>) obj, obj2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Pair<E, R> invoke(E e, R r) {
                return TuplesKt.to(e, r);
            }
        }, 2, null);
        return zip$default;
    }

    public static /* synthetic */ ReceiveChannel zip$default(ReceiveChannel receiveChannel, ReceiveChannel receiveChannel2, CoroutineContext coroutineContext, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            coroutineContext = Dispatchers.getUnconfined();
        }
        return ChannelsKt.zip(receiveChannel, receiveChannel2, coroutineContext, function2);
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    public static final <E, R, V> ReceiveChannel<V> zip(ReceiveChannel<? extends E> zip, ReceiveChannel<? extends R> other, CoroutineContext context, Function2<? super E, ? super R, ? extends V> transform) {
        Intrinsics.checkParameterIsNotNull(zip, "$this$zip");
        Intrinsics.checkParameterIsNotNull(other, "other");
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(transform, "transform");
        return ProduceKt.produce$default(GlobalScope.INSTANCE, context, 0, ChannelsKt.consumesAll(zip, other), new ChannelsKt__Channels_commonKt$zip$2(zip, other, transform, null), 2, null);
    }

    private static final Object consumeEach$$forInline(BroadcastChannel broadcastChannel, Function1 function1, Continuation continuation) {
        ReceiveChannel openSubscription = broadcastChannel.openSubscription();
        try {
            ChannelIterator it = openSubscription.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    return Unit.INSTANCE;
                }
                function1.invoke(it.next());
            }
        } finally {
            InlineMarker.finallyStart(1);
            ReceiveChannel.DefaultImpls.cancel$default(openSubscription, (CancellationException) null, 1, (Object) null);
            InlineMarker.finallyEnd(1);
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    private static final Object consumeEach$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return unit;
                }
                function1.invoke(it.next());
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object consumeEachIndexed$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    function1.invoke(new IndexedValue(i, it.next()));
                    i++;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return Unit.INSTANCE;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object elementAtOrElse$$forInline(ReceiveChannel receiveChannel, int i, Function1 function1, Continuation continuation) {
        Object invoke;
        int i2;
        Throwable th = null;
        try {
            if (i < 0) {
                invoke = function1.invoke(Integer.valueOf(i));
                i2 = 4;
                InlineMarker.finallyStart(4);
            } else {
                ChannelIterator it = receiveChannel.iterator();
                int i3 = 0;
                while (true) {
                    InlineMarker.mark(0);
                    Object hasNext = it.hasNext(continuation);
                    InlineMarker.mark(1);
                    if (!((Boolean) hasNext).booleanValue()) {
                        invoke = function1.invoke(Integer.valueOf(i));
                        i2 = 2;
                        InlineMarker.finallyStart(2);
                        break;
                    }
                    Object next = it.next();
                    int i4 = i3 + 1;
                    if (i == i3) {
                        InlineMarker.finallyStart(3);
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                        InlineMarker.finallyEnd(3);
                        return next;
                    }
                    i3 = i4;
                }
            }
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(i2);
            return invoke;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object find$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object next;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            do {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return null;
                }
                next = it.next();
            } while (!((Boolean) function1.invoke(next)).booleanValue());
            InlineMarker.finallyStart(2);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(2);
            return next;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object findLast$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object obj = null;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    if (((Boolean) function1.invoke(next)).booleanValue()) {
                        obj = next;
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return obj;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object first$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object next;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            do {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                }
                next = it.next();
            } while (!((Boolean) function1.invoke(next)).booleanValue());
            InlineMarker.finallyStart(2);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(2);
            return next;
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object firstOrNull$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object next;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            do {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return null;
                }
                next = it.next();
            } while (!((Boolean) function1.invoke(next)).booleanValue());
            InlineMarker.finallyStart(2);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(2);
            return next;
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object indexOfFirst$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    if (((Boolean) function1.invoke(it.next())).booleanValue()) {
                        Integer valueOf = Integer.valueOf(i);
                        InlineMarker.finallyStart(2);
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                        InlineMarker.finallyEnd(2);
                        return valueOf;
                    }
                    i++;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return -1;
                }
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object indexOfLast$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = -1;
            int i2 = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    if (((Boolean) function1.invoke(it.next())).booleanValue()) {
                        i = i2;
                    }
                    i2++;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return Integer.valueOf(i);
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object last$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object obj = null;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            boolean z = false;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    break;
                }
                Object next = it.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    z = true;
                    obj = next;
                }
            }
            Unit unit = Unit.INSTANCE;
            InlineMarker.finallyStart(1);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(1);
            if (z) {
                return obj;
            }
            throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object lastOrNull$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object obj = null;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    if (((Boolean) function1.invoke(next)).booleanValue()) {
                        obj = next;
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return obj;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object single$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Object obj = null;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            boolean z = false;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    if (((Boolean) function1.invoke(next)).booleanValue()) {
                        if (z) {
                            throw new IllegalArgumentException("ReceiveChannel contains more than one matching element.");
                        }
                        z = true;
                        obj = next;
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    if (z) {
                        return obj;
                    }
                    throw new NoSuchElementException("ReceiveChannel contains no element matching the predicate.");
                }
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x003e, code lost:
        r10 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0040, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
        kotlinx.coroutines.channels.ChannelsKt.cancelConsumed(r9, r1);
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0049, code lost:
        if (r5 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x004b, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x004c, code lost:
        return r6;
     */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final Object singleOrNull$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            Object obj = null;
            boolean z = false;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    break;
                }
                Object next = it.next();
                if (((Boolean) function1.invoke(next)).booleanValue()) {
                    if (z) {
                        InlineMarker.finallyStart(2);
                        ChannelsKt.cancelConsumed(receiveChannel, th);
                        InlineMarker.finallyEnd(2);
                        return null;
                    }
                    z = true;
                    obj = next;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object filterIndexedTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    int i2 = i + 1;
                    IndexedValue indexedValue = new IndexedValue(i, it.next());
                    int component1 = indexedValue.component1();
                    Object component2 = indexedValue.component2();
                    if (((Boolean) function2.invoke(Integer.valueOf(component1), component2)).booleanValue()) {
                        collection.add(component2);
                    }
                    i = i2;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object filterIndexedTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    int i2 = i + 1;
                    IndexedValue indexedValue = new IndexedValue(i, it.next());
                    int component1 = indexedValue.component1();
                    Object component2 = indexedValue.component2();
                    if (((Boolean) function2.invoke(Integer.valueOf(component1), component2)).booleanValue()) {
                        InlineMarker.mark(0);
                        sendChannel.send(component2, continuation);
                        InlineMarker.mark(2);
                        InlineMarker.mark(1);
                    }
                    i = i2;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object filterNotTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    if (!((Boolean) function1.invoke(next)).booleanValue()) {
                        collection.add(next);
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object filterNotTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    if (!((Boolean) function1.invoke(next)).booleanValue()) {
                        InlineMarker.mark(0);
                        sendChannel.send(next, continuation);
                        InlineMarker.mark(2);
                        InlineMarker.mark(1);
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object filterTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    if (((Boolean) function1.invoke(next)).booleanValue()) {
                        collection.add(next);
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object filterTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    if (((Boolean) function1.invoke(next)).booleanValue()) {
                        InlineMarker.mark(0);
                        sendChannel.send(next, continuation);
                        InlineMarker.mark(2);
                        InlineMarker.mark(1);
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object associateByTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    map.put(function1.invoke(next), next);
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object associateByTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Function1 function12, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    map.put(function1.invoke(next), function12.invoke(next));
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object associateTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Pair pair = (Pair) function1.invoke(it.next());
                    map.put(pair.getFirst(), pair.getSecond());
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object groupByTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    Object invoke = function1.invoke(next);
                    Object obj = map.get(invoke);
                    if (obj == null) {
                        obj = new ArrayList();
                        map.put(invoke, obj);
                    }
                    ((List) obj).add(next);
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object groupByTo$$forInline(ReceiveChannel receiveChannel, Map map, Function1 function1, Function1 function12, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object next = it.next();
                    Object invoke = function1.invoke(next);
                    Object obj = map.get(invoke);
                    if (obj == null) {
                        obj = new ArrayList();
                        map.put(invoke, obj);
                    }
                    ((List) obj).add(function12.invoke(next));
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return map;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object mapIndexedNotNullTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    int i2 = i + 1;
                    IndexedValue indexedValue = new IndexedValue(i, it.next());
                    Object invoke = function2.invoke(Integer.valueOf(indexedValue.component1()), indexedValue.component2());
                    if (invoke != null) {
                        collection.add(invoke);
                    }
                    i = i2;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object mapIndexedNotNullTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    int i2 = i + 1;
                    IndexedValue indexedValue = new IndexedValue(i, it.next());
                    Object invoke = function2.invoke(Integer.valueOf(indexedValue.component1()), indexedValue.component2());
                    if (invoke != null) {
                        InlineMarker.mark(0);
                        sendChannel.send(invoke, continuation);
                        InlineMarker.mark(2);
                        InlineMarker.mark(1);
                    }
                    i = i2;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object mapIndexedTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function2 function2, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    collection.add(function2.invoke(Integer.valueOf(i), it.next()));
                    i++;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object mapIndexedTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function2 function2, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    int i2 = i + 1;
                    Object invoke = function2.invoke(Integer.valueOf(i), it.next());
                    InlineMarker.mark(0);
                    sendChannel.send(invoke, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                    i = i2;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object mapNotNullTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object invoke = function1.invoke(it.next());
                    if (invoke != null) {
                        collection.add(invoke);
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object mapNotNullTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object invoke = function1.invoke(it.next());
                    if (invoke != null) {
                        InlineMarker.mark(0);
                        sendChannel.send(invoke, continuation);
                        InlineMarker.mark(2);
                        InlineMarker.mark(1);
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object mapTo$$forInline(ReceiveChannel receiveChannel, Collection collection, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    collection.add(function1.invoke(it.next()));
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return collection;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object mapTo$$forInline(ReceiveChannel receiveChannel, SendChannel sendChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    Object invoke = function1.invoke(it.next());
                    InlineMarker.mark(0);
                    sendChannel.send(invoke, continuation);
                    InlineMarker.mark(2);
                    InlineMarker.mark(1);
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return sendChannel;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object all$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            do {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return true;
                }
            } while (((Boolean) function1.invoke(it.next())).booleanValue());
            InlineMarker.finallyStart(2);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(2);
            return false;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object any$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            do {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return false;
                }
            } while (!((Boolean) function1.invoke(it.next())).booleanValue());
            InlineMarker.finallyStart(2);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(2);
            return true;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object count$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    if (((Boolean) function1.invoke(it.next())).booleanValue()) {
                        i++;
                    }
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return Integer.valueOf(i);
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object fold$$forInline(ReceiveChannel receiveChannel, Object obj, Function2 function2, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    obj = function2.invoke(obj, it.next());
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return obj;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object foldIndexed$$forInline(ReceiveChannel receiveChannel, Object obj, Function3 function3, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    obj = function3.invoke(Integer.valueOf(i), obj, it.next());
                    i++;
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return obj;
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object maxBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        int i;
        Object obj = null;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                obj = it.next();
                Comparable comparable = (Comparable) function1.invoke(obj);
                while (true) {
                    InlineMarker.mark(0);
                    Object hasNext2 = it.hasNext(continuation);
                    InlineMarker.mark(1);
                    if (!((Boolean) hasNext2).booleanValue()) {
                        break;
                    }
                    Object next = it.next();
                    Comparable comparable2 = (Comparable) function1.invoke(next);
                    if (comparable.compareTo(comparable2) < 0) {
                        obj = next;
                        comparable = comparable2;
                    }
                }
                i = 2;
                InlineMarker.finallyStart(2);
            } else {
                i = 3;
                InlineMarker.finallyStart(3);
            }
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(i);
            return obj;
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object minBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        int i;
        Object obj = null;
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (((Boolean) hasNext).booleanValue()) {
                obj = it.next();
                Comparable comparable = (Comparable) function1.invoke(obj);
                while (true) {
                    InlineMarker.mark(0);
                    Object hasNext2 = it.hasNext(continuation);
                    InlineMarker.mark(1);
                    if (!((Boolean) hasNext2).booleanValue()) {
                        break;
                    }
                    Object next = it.next();
                    Comparable comparable2 = (Comparable) function1.invoke(next);
                    if (comparable.compareTo(comparable2) > 0) {
                        obj = next;
                        comparable = comparable2;
                    }
                }
                i = 2;
                InlineMarker.finallyStart(2);
            } else {
                i = 3;
                InlineMarker.finallyStart(3);
            }
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(i);
            return obj;
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object none$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            do {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (!((Boolean) hasNext).booleanValue()) {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return true;
                }
            } while (!((Boolean) function1.invoke(it.next())).booleanValue());
            InlineMarker.finallyStart(2);
            ChannelsKt.cancelConsumed(receiveChannel, th);
            InlineMarker.finallyEnd(2);
            return false;
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object reduce$$forInline(ReceiveChannel receiveChannel, Function2 function2, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                throw new UnsupportedOperationException("Empty channel can't be reduced.");
            }
            Object next = it.next();
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext2).booleanValue()) {
                    next = function2.invoke(next, it.next());
                } else {
                    InlineMarker.finallyStart(2);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(2);
                    return next;
                }
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object reduceIndexed$$forInline(ReceiveChannel receiveChannel, Function3 function3, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            InlineMarker.mark(0);
            Object hasNext = it.hasNext(continuation);
            InlineMarker.mark(1);
            if (!((Boolean) hasNext).booleanValue()) {
                throw new UnsupportedOperationException("Empty channel can't be reduced.");
            }
            Object next = it.next();
            int i = 1;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext2 = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext2).booleanValue()) {
                    Integer valueOf = Integer.valueOf(i);
                    i++;
                    next = function3.invoke(valueOf, next, it.next());
                } else {
                    InlineMarker.finallyStart(2);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(2);
                    return next;
                }
            }
        } catch (Throwable th2) {
            try {
                throw th2;
            } catch (Throwable th3) {
                InlineMarker.finallyStart(1);
                ChannelsKt.cancelConsumed(receiveChannel, th2);
                InlineMarker.finallyEnd(1);
                throw th3;
            }
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object sumBy$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            int i = 0;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    i += ((Number) function1.invoke(it.next())).intValue();
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return Integer.valueOf(i);
                }
            }
        } finally {
        }
    }

    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    @Deprecated(level = DeprecationLevel.WARNING, message = "Channel operators are deprecated in favour of Flow and will be removed in 1.4")
    private static final Object sumByDouble$$forInline(ReceiveChannel receiveChannel, Function1 function1, Continuation continuation) {
        Throwable th = null;
        try {
            ChannelIterator it = receiveChannel.iterator();
            double d = 0.0d;
            while (true) {
                InlineMarker.mark(0);
                Object hasNext = it.hasNext(continuation);
                InlineMarker.mark(1);
                if (((Boolean) hasNext).booleanValue()) {
                    d += ((Number) function1.invoke(it.next())).doubleValue();
                } else {
                    Unit unit = Unit.INSTANCE;
                    InlineMarker.finallyStart(1);
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                    InlineMarker.finallyEnd(1);
                    return Double.valueOf(d);
                }
            }
        } finally {
        }
    }
}
