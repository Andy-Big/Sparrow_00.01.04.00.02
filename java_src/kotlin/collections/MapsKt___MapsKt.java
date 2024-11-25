package kotlin.collections;

import androidx.exifinterface.media.ExifInterface;
import com.daimajia.numberprogressbar.BuildConfig;
import com.sun.mail.imap.IMAPStore;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
/* compiled from: _Maps.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0080\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000f\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001aJ\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a$\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010\b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a9\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\n\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001a6\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070\f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001a'\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004H\u0087\b\u001aJ\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001a\\\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\n0\u0006H\u0086\bø\u0001\u0000\u001aa\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\b\u0013\u001au\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011\"\u0010\b\u0003\u0010\u0015*\n\u0012\u0006\b\u0000\u0012\u0002H\u00110\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0017\u001a\u0002H\u00152$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\n0\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001aw\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011\"\u0010\b\u0003\u0010\u0015*\n\u0012\u0006\b\u0000\u0012\u0002H\u00110\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0017\u001a\u0002H\u00152$\u0010\u0012\u001a \u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\f0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0018\u001aJ\u0010\u001a\u001a\u00020\u001b\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u001c\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001b0\u0006H\u0087\bø\u0001\u0000\u001aV\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0086\bø\u0001\u0000\u001a\\\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0011*\u00020\u001f*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0006H\u0086\bø\u0001\u0000\u001au\u0010 \u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\b\b\u0002\u0010\u0011*\u00020\u001f\"\u0010\b\u0003\u0010\u0015*\n\u0012\u0006\b\u0000\u0012\u0002H\u00110\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0017\u001a\u0002H\u00152 \u0010\u0012\u001a\u001c\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ao\u0010!\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011\"\u0010\b\u0003\u0010\u0015*\n\u0012\u0006\b\u0000\u0012\u0002H\u00110\u0016*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0017\u001a\u0002H\u00152\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0086\bø\u0001\u0000¢\u0006\u0002\u0010\u0018\u001ah\u0010\"\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110#*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000\u001ah\u0010%\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110#*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000\u001a_\u0010&\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110#*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010'\u001aJ\u0010&\u001a\u00020(\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020(0\u0006H\u0087\bø\u0001\u0000\u001aJ\u0010&\u001a\u00020)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020)0\u0006H\u0087\bø\u0001\u0000\u001aa\u0010*\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110#*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010'\u001aQ\u0010*\u001a\u0004\u0018\u00010(\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020(0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u0010*\u001a\u0004\u0018\u00010)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020)0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010,\u001aq\u0010-\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u0010.\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00110/j\n\u0012\u0006\b\u0000\u0012\u0002H\u0011`02\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00101\u001as\u00102\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u0010.\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00110/j\n\u0012\u0006\b\u0000\u0012\u0002H\u0011`02\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00101\u001ai\u00103\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u0010.\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070/j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`0H\u0087\b\u001ai\u00104\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u0010.\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070/j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`0H\u0087\b\u001ah\u00105\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110#*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000\u001ah\u00106\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110#*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000\u001a_\u00107\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110#*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010'\u001aJ\u00107\u001a\u00020(\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020(0\u0006H\u0087\bø\u0001\u0000\u001aJ\u00107\u001a\u00020)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020)0\u0006H\u0087\bø\u0001\u0000\u001aa\u00108\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000e\b\u0002\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00110#*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010'\u001aQ\u00108\u001a\u0004\u0018\u00010(\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020(0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010+\u001aQ\u00108\u001a\u0004\u0018\u00010)\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020)0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010,\u001aq\u00109\u001a\u0002H\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u0010.\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00110/j\n\u0012\u0006\b\u0000\u0012\u0002H\u0011`02\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00101\u001as\u0010:\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0011*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001a\u0010.\u001a\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00110/j\n\u0012\u0006\b\u0000\u0012\u0002H\u0011`02\u001e\u0010$\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u0002H\u00110\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u00101\u001ah\u0010;\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u0010.\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070/j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`0H\u0007\u001ai\u0010<\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000422\u0010.\u001a.\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00070/j\u0016\u0012\u0012\b\u0000\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007`0H\u0087\b\u001a$\u0010=\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u001aJ\u0010=\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00042\u001e\u0010\u0005\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\bø\u0001\u0000\u001aY\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010?*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002H?2\u001e\u0010\u001c\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001b0\u0006H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010@\u001an\u0010A\u001a\u0002H?\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0016\b\u0002\u0010?*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004*\u0002H?23\u0010\u001c\u001a/\u0012\u0013\u0012\u00110\u000e¢\u0006\f\bC\u0012\b\bD\u0012\u0004\b\b(E\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0007\u0012\u0004\u0012\u00020\u001b0BH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010F\u001a6\u0010G\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030H0\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006I"}, d2 = {"all", "", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", "predicate", "Lkotlin/Function1;", "", "any", "asIterable", "", "asSequence", "Lkotlin/sequences/Sequence;", "count", "", "flatMap", "", "R", "transform", "flatMapSequence", "flatMapTo", "C", "", "destination", "(Ljava/util/Map;Ljava/util/Collection;Lkotlin/jvm/functions/Function1;)Ljava/util/Collection;", "flatMapSequenceTo", "forEach", "", "action", "map", "mapNotNull", "", "mapNotNullTo", "mapTo", "maxBy", "", "selector", "maxByOrNull", "maxOf", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Comparable;", "", "", "maxOfOrNull", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Double;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/lang/Float;", "maxOfWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Map;Ljava/util/Comparator;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxOfWithOrNull", "maxWith", "maxWithOrNull", "minBy", "minByOrNull", "minOf", "minOfOrNull", "minOfWith", "minOfWithOrNull", "minWith", "minWithOrNull", "none", "onEach", "M", "(Ljava/util/Map;Lkotlin/jvm/functions/Function1;)Ljava/util/Map;", "onEachIndexed", "Lkotlin/Function2;", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "index", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "toList", "Lkotlin/Pair;", "kotlin-stdlib"}, k = 5, mv = {1, 4, 0}, xi = 1, xs = "kotlin/collections/MapsKt")
/* loaded from: classes2.dex */
class MapsKt___MapsKt extends MapsKt__MapsKt {
    public static final <K, V> List<Pair<K, V>> toList(Map<? extends K, ? extends V> toList) {
        Intrinsics.checkNotNullParameter(toList, "$this$toList");
        if (toList.size() == 0) {
            return CollectionsKt.emptyList();
        }
        Iterator<Map.Entry<? extends K, ? extends V>> it = toList.entrySet().iterator();
        if (!it.hasNext()) {
            return CollectionsKt.emptyList();
        }
        Map.Entry<? extends K, ? extends V> next = it.next();
        if (!it.hasNext()) {
            return CollectionsKt.listOf(new Pair(next.getKey(), next.getValue()));
        }
        ArrayList arrayList = new ArrayList(toList.size());
        arrayList.add(new Pair(next.getKey(), next.getValue()));
        do {
            Map.Entry<? extends K, ? extends V> next2 = it.next();
            arrayList.add(new Pair(next2.getKey(), next2.getValue()));
        } while (it.hasNext());
        return arrayList;
    }

    public static final <K, V, R> List<R> flatMap(Map<? extends K, ? extends V> flatMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMap, "$this$flatMap");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : flatMap.entrySet()) {
            CollectionsKt.addAll(arrayList, transform.invoke(entry));
        }
        return arrayList;
    }

    public static final <K, V, R> List<R> flatMapSequence(Map<? extends K, ? extends V> flatMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMap, "$this$flatMap");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : flatMap.entrySet()) {
            CollectionsKt.addAll(arrayList, transform.invoke(entry));
        }
        return arrayList;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapTo(Map<? extends K, ? extends V> flatMapTo, C destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Iterable<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapTo, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (Map.Entry<? extends K, ? extends V> entry : flatMapTo.entrySet()) {
            CollectionsKt.addAll(destination, transform.invoke(entry));
        }
        return destination;
    }

    public static final <K, V, R, C extends Collection<? super R>> C flatMapSequenceTo(Map<? extends K, ? extends V> flatMapTo, C destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends Sequence<? extends R>> transform) {
        Intrinsics.checkNotNullParameter(flatMapTo, "$this$flatMapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (Map.Entry<? extends K, ? extends V> entry : flatMapTo.entrySet()) {
            CollectionsKt.addAll(destination, transform.invoke(entry));
        }
        return destination;
    }

    public static final <K, V, R> List<R> map(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(map, "$this$map");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            arrayList.add(transform.invoke(entry));
        }
        return arrayList;
    }

    public static final <K, V, R> List<R> mapNotNull(Map<? extends K, ? extends V> mapNotNull, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapNotNull, "$this$mapNotNull");
        Intrinsics.checkNotNullParameter(transform, "transform");
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<? extends K, ? extends V> entry : mapNotNull.entrySet()) {
            R invoke = transform.invoke(entry);
            if (invoke != null) {
                arrayList.add(invoke);
            }
        }
        return arrayList;
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapTo(Map<? extends K, ? extends V> mapTo, C destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapTo, "$this$mapTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (Map.Entry<? extends K, ? extends V> entry : mapTo.entrySet()) {
            destination.add(transform.invoke(entry));
        }
        return destination;
    }

    public static final <K, V> boolean all(Map<? extends K, ? extends V> all, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(all, "$this$all");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (all.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> entry : all.entrySet()) {
            if (!predicate.invoke(entry).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> any) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        return !any.isEmpty();
    }

    public static final <K, V> boolean any(Map<? extends K, ? extends V> any, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(any, "$this$any");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (any.isEmpty()) {
            return false;
        }
        for (Map.Entry<? extends K, ? extends V> entry : any.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    private static final <K, V> int count(Map<? extends K, ? extends V> map) {
        return map.size();
    }

    public static final <K, V> int count(Map<? extends K, ? extends V> count, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(count, "$this$count");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        int i = 0;
        if (count.isEmpty()) {
            return 0;
        }
        for (Map.Entry<? extends K, ? extends V> entry : count.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                i++;
            }
        }
        return i;
    }

    public static final <K, V> void forEach(Map<? extends K, ? extends V> forEach, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        Intrinsics.checkNotNullParameter(forEach, "$this$forEach");
        Intrinsics.checkNotNullParameter(action, "action");
        for (Map.Entry<? extends K, ? extends V> entry : forEach.entrySet()) {
            action.invoke(entry);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Use maxByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = BuildConfig.VERSION_NAME)
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxBy(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = function1.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = function1.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) < 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> maxByOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = function1.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = function1.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) < 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    private static final <K, V> double maxOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = function1.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, function1.invoke((Object) it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOf  reason: collision with other method in class */
    private static final <K, V> float m435maxOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = function1.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, function1.invoke((Object) it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOf  reason: collision with other method in class */
    private static final <K, V, R extends Comparable<? super R>> R m436maxOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = function1.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = function1.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: maxOfOrNull  reason: collision with other method in class */
    private static final <K, V> Double m437maxOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = function1.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.max(doubleValue, function1.invoke((Object) it.next()).doubleValue());
            }
            return Double.valueOf(doubleValue);
        }
        return null;
    }

    /* renamed from: maxOfOrNull  reason: collision with other method in class */
    private static final <K, V> Float m438maxOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = function1.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.max(floatValue, function1.invoke((Object) it.next()).floatValue());
            }
            return Float.valueOf(floatValue);
        }
        return null;
    }

    private static final <K, V, R extends Comparable<? super R>> R maxOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = function1.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = function1.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) < 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V, R> R maxOfWith(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) function1.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = function1.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) < 0) {
                    obj = invoke;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V, R> R maxOfWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) function1.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = function1.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) < 0) {
                    obj = (Object) invoke;
                }
            }
            return obj;
        }
        return null;
    }

    @Deprecated(message = "Use maxWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.maxWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = BuildConfig.VERSION_NAME)
    private static final <K, V> Map.Entry<K, V> maxWith(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) CollectionsKt.maxWithOrNull(map.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> maxWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) CollectionsKt.maxWithOrNull(map.entrySet(), comparator);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated(message = "Use minByOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minByOrNull(selector)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = BuildConfig.VERSION_NAME)
    public static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minBy(Map<? extends K, ? extends V> minBy, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> selector) {
        Object obj;
        Intrinsics.checkNotNullParameter(minBy, "$this$minBy");
        Intrinsics.checkNotNullParameter(selector, "selector");
        Iterator it = minBy.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = selector.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = selector.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) > 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V, R extends Comparable<? super R>> Map.Entry<K, V> minByOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Object obj;
        Iterator it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj2 = (Object) it.next();
            if (it.hasNext()) {
                R invoke = function1.invoke(obj2);
                Object obj3 = obj2;
                do {
                    Object obj4 = (Object) it.next();
                    R invoke2 = function1.invoke(obj4);
                    obj2 = obj3;
                    if (invoke.compareTo(invoke2) > 0) {
                        invoke = invoke2;
                        obj2 = (Object) obj4;
                    }
                    obj3 = obj2;
                } while (it.hasNext());
                obj = obj2;
            } else {
                obj = obj2;
            }
        } else {
            obj = null;
        }
        return (Map.Entry) obj;
    }

    private static final <K, V> double minOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = function1.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, function1.invoke((Object) it.next()).doubleValue());
            }
            return doubleValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOf  reason: collision with other method in class */
    private static final <K, V> float m439minOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = function1.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, function1.invoke((Object) it.next()).floatValue());
            }
            return floatValue;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOf  reason: collision with other method in class */
    private static final <K, V, R extends Comparable<? super R>> R m440minOf(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = function1.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = function1.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        throw new NoSuchElementException();
    }

    /* renamed from: minOfOrNull  reason: collision with other method in class */
    private static final <K, V> Double m441minOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Double> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            double doubleValue = function1.invoke((Object) it.next()).doubleValue();
            while (it.hasNext()) {
                doubleValue = Math.min(doubleValue, function1.invoke((Object) it.next()).doubleValue());
            }
            return Double.valueOf(doubleValue);
        }
        return null;
    }

    /* renamed from: minOfOrNull  reason: collision with other method in class */
    private static final <K, V> Float m442minOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, Float> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            float floatValue = function1.invoke((Object) it.next()).floatValue();
            while (it.hasNext()) {
                floatValue = Math.min(floatValue, function1.invoke((Object) it.next()).floatValue());
            }
            return Float.valueOf(floatValue);
        }
        return null;
    }

    private static final <K, V, R extends Comparable<? super R>> R minOfOrNull(Map<? extends K, ? extends V> map, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            R invoke = function1.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke2 = function1.invoke((Object) it.next());
                if (invoke.compareTo(invoke2) > 0) {
                    invoke = invoke2;
                }
            }
            return invoke;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V, R> R minOfWith(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) function1.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = function1.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) > 0) {
                    obj = invoke;
                }
            }
            return (R) obj;
        }
        throw new NoSuchElementException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final <K, V, R> R minOfWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super R> comparator, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> function1) {
        Iterator<T> it = map.entrySet().iterator();
        if (it.hasNext()) {
            Object obj = (R) function1.invoke((Object) it.next());
            while (it.hasNext()) {
                R invoke = function1.invoke((Object) it.next());
                if (comparator.compare(obj, invoke) > 0) {
                    obj = (Object) invoke;
                }
            }
            return obj;
        }
        return null;
    }

    @Deprecated(message = "Use minWithOrNull instead.", replaceWith = @ReplaceWith(expression = "this.minWithOrNull(comparator)", imports = {}))
    @DeprecatedSinceKotlin(warningSince = BuildConfig.VERSION_NAME)
    public static final <K, V> Map.Entry<K, V> minWith(Map<? extends K, ? extends V> minWith, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        Intrinsics.checkNotNullParameter(minWith, "$this$minWith");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        return (Map.Entry) CollectionsKt.minWithOrNull(minWith.entrySet(), comparator);
    }

    private static final <K, V> Map.Entry<K, V> minWithOrNull(Map<? extends K, ? extends V> map, Comparator<? super Map.Entry<? extends K, ? extends V>> comparator) {
        return (Map.Entry) CollectionsKt.minWithOrNull(map.entrySet(), comparator);
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> none) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        return none.isEmpty();
    }

    public static final <K, V> boolean none(Map<? extends K, ? extends V> none, Function1<? super Map.Entry<? extends K, ? extends V>, Boolean> predicate) {
        Intrinsics.checkNotNullParameter(none, "$this$none");
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        if (none.isEmpty()) {
            return true;
        }
        for (Map.Entry<? extends K, ? extends V> entry : none.entrySet()) {
            if (predicate.invoke(entry).booleanValue()) {
                return false;
            }
        }
        return true;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEach(M onEach, Function1<? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        Intrinsics.checkNotNullParameter(onEach, "$this$onEach");
        Intrinsics.checkNotNullParameter(action, "action");
        for (Map.Entry<K, V> entry : onEach.entrySet()) {
            action.invoke(entry);
        }
        return onEach;
    }

    public static final <K, V, M extends Map<? extends K, ? extends V>> M onEachIndexed(M onEachIndexed, Function2<? super Integer, ? super Map.Entry<? extends K, ? extends V>, Unit> action) {
        Intrinsics.checkNotNullParameter(onEachIndexed, "$this$onEachIndexed");
        Intrinsics.checkNotNullParameter(action, "action");
        int i = 0;
        for (Object obj : onEachIndexed.entrySet()) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            action.invoke(Integer.valueOf(i), obj);
            i = i2;
        }
        return onEachIndexed;
    }

    private static final <K, V> Iterable<Map.Entry<K, V>> asIterable(Map<? extends K, ? extends V> map) {
        return map.entrySet();
    }

    public static final <K, V> Sequence<Map.Entry<K, V>> asSequence(Map<? extends K, ? extends V> asSequence) {
        Intrinsics.checkNotNullParameter(asSequence, "$this$asSequence");
        return CollectionsKt.asSequence(asSequence.entrySet());
    }

    public static final <K, V, R, C extends Collection<? super R>> C mapNotNullTo(Map<? extends K, ? extends V> mapNotNullTo, C destination, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> transform) {
        Intrinsics.checkNotNullParameter(mapNotNullTo, "$this$mapNotNullTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        Intrinsics.checkNotNullParameter(transform, "transform");
        for (Map.Entry<? extends K, ? extends V> entry : mapNotNullTo.entrySet()) {
            R invoke = transform.invoke(entry);
            if (invoke != null) {
                destination.add(invoke);
            }
        }
        return destination;
    }
}
