package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import com.sun.mail.imap.IMAPStore;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Region.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0004\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\n\u001a0\u0010\b\u001a\u00020\t*\u00020\u00012!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\t0\u000bH\u0086\b\u001a\u0013\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010*\u00020\u0001H\u0086\u0002\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0012\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\n\u001a\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\n\u001a\r\u0010\u0015\u001a\u00020\u0001*\u00020\u0001H\u0086\n\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\f\u001a\u0015\u0010\u0016\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\f¨\u0006\u0017"}, d2 = {"and", "Landroid/graphics/Region;", "r", "Landroid/graphics/Rect;", "contains", "", "p", "Landroid/graphics/Point;", "forEach", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", IMAPStore.ID_NAME, "rect", "iterator", "", "minus", "not", "or", "plus", "unaryMinus", "xor", "core-ktx_release"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes.dex */
public final class RegionKt {
    public static final boolean contains(Region contains, Point p) {
        Intrinsics.checkParameterIsNotNull(contains, "$this$contains");
        Intrinsics.checkParameterIsNotNull(p, "p");
        return contains.contains(p.x, p.y);
    }

    public static final Region plus(Region plus, Rect r) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(plus);
        region.union(r);
        return region;
    }

    public static final Region plus(Region plus, Region r) {
        Intrinsics.checkParameterIsNotNull(plus, "$this$plus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(plus);
        region.op(r, Region.Op.UNION);
        return region;
    }

    public static final Region minus(Region minus, Rect r) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(minus);
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region minus(Region minus, Region r) {
        Intrinsics.checkParameterIsNotNull(minus, "$this$minus");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(minus);
        region.op(r, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region unaryMinus(Region unaryMinus) {
        Intrinsics.checkParameterIsNotNull(unaryMinus, "$this$unaryMinus");
        Region region = new Region(unaryMinus.getBounds());
        region.op(unaryMinus, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region and(Region and, Rect r) {
        Intrinsics.checkParameterIsNotNull(and, "$this$and");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(and);
        region.op(r, Region.Op.INTERSECT);
        return region;
    }

    public static final Region and(Region and, Region r) {
        Intrinsics.checkParameterIsNotNull(and, "$this$and");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(and);
        region.op(r, Region.Op.INTERSECT);
        return region;
    }

    public static final Region xor(Region xor, Rect r) {
        Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(xor);
        region.op(r, Region.Op.XOR);
        return region;
    }

    public static final Region xor(Region xor, Region r) {
        Intrinsics.checkParameterIsNotNull(xor, "$this$xor");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(xor);
        region.op(r, Region.Op.XOR);
        return region;
    }

    public static final void forEach(Region forEach, Function1<? super Rect, Unit> action) {
        Intrinsics.checkParameterIsNotNull(forEach, "$this$forEach");
        Intrinsics.checkParameterIsNotNull(action, "action");
        RegionIterator regionIterator = new RegionIterator(forEach);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            }
            action.invoke(rect);
        }
    }

    public static final Iterator<Rect> iterator(Region iterator) {
        Intrinsics.checkParameterIsNotNull(iterator, "$this$iterator");
        return new RegionKt$iterator$1(iterator);
    }

    public static final Region not(Region not) {
        Intrinsics.checkParameterIsNotNull(not, "$this$not");
        Region region = new Region(not.getBounds());
        region.op(not, Region.Op.DIFFERENCE);
        return region;
    }

    public static final Region or(Region or, Rect r) {
        Intrinsics.checkParameterIsNotNull(or, "$this$or");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(or);
        region.union(r);
        return region;
    }

    public static final Region or(Region or, Region r) {
        Intrinsics.checkParameterIsNotNull(or, "$this$or");
        Intrinsics.checkParameterIsNotNull(r, "r");
        Region region = new Region(or);
        region.op(r, Region.Op.UNION);
        return region;
    }
}
