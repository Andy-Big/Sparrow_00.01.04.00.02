package kotlin.text;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: Strings.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000%\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\t\u0010\u0019\u001a\u00020\u001aH\u0096\u0002J\t\u0010\u001b\u001a\u00020\u0002H\u0096\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\b¨\u0006\u001c"}, d2 = {"kotlin/text/DelimitedRangesSequence$iterator$1", "", "Lkotlin/ranges/IntRange;", "counter", "", "getCounter", "()I", "setCounter", "(I)V", "currentStartIndex", "getCurrentStartIndex", "setCurrentStartIndex", "nextItem", "getNextItem", "()Lkotlin/ranges/IntRange;", "setNextItem", "(Lkotlin/ranges/IntRange;)V", "nextSearchIndex", "getNextSearchIndex", "setNextSearchIndex", "nextState", "getNextState", "setNextState", "calcNext", "", "hasNext", "", "next", "kotlin-stdlib"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes2.dex */
public final class DelimitedRangesSequence$iterator$1 implements Iterator<IntRange>, KMappedMarker {
    private int counter;
    private int currentStartIndex;
    private IntRange nextItem;
    private int nextSearchIndex;
    private int nextState = -1;
    final /* synthetic */ DelimitedRangesSequence this$0;

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX DEBUG: Incorrect args count in method signature: ()V */
    DelimitedRangesSequence$iterator$1(DelimitedRangesSequence delimitedRangesSequence) {
        int i;
        CharSequence charSequence;
        this.this$0 = delimitedRangesSequence;
        i = delimitedRangesSequence.startIndex;
        charSequence = delimitedRangesSequence.input;
        int coerceIn = RangesKt.coerceIn(i, 0, charSequence.length());
        this.currentStartIndex = coerceIn;
        this.nextSearchIndex = coerceIn;
    }

    public final int getNextState() {
        return this.nextState;
    }

    public final void setNextState(int i) {
        this.nextState = i;
    }

    public final int getCurrentStartIndex() {
        return this.currentStartIndex;
    }

    public final void setCurrentStartIndex(int i) {
        this.currentStartIndex = i;
    }

    public final int getNextSearchIndex() {
        return this.nextSearchIndex;
    }

    public final void setNextSearchIndex(int i) {
        this.nextSearchIndex = i;
    }

    public final IntRange getNextItem() {
        return this.nextItem;
    }

    public final void setNextItem(IntRange intRange) {
        this.nextItem = intRange;
    }

    public final int getCounter() {
        return this.counter;
    }

    public final void setCounter(int i) {
        this.counter = i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
        if (r0 < r4) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void calcNext() {
        int i;
        CharSequence charSequence;
        Function2 function2;
        CharSequence charSequence2;
        CharSequence charSequence3;
        CharSequence charSequence4;
        int i2;
        if (this.nextSearchIndex >= 0) {
            i = this.this$0.limit;
            if (i > 0) {
                int i3 = this.counter + 1;
                this.counter = i3;
                i2 = this.this$0.limit;
            }
            int i4 = this.nextSearchIndex;
            charSequence = this.this$0.input;
            if (i4 <= charSequence.length()) {
                function2 = this.this$0.getNextMatch;
                charSequence2 = this.this$0.input;
                Pair pair = (Pair) function2.invoke(charSequence2, Integer.valueOf(this.nextSearchIndex));
                if (pair == null) {
                    int i5 = this.currentStartIndex;
                    charSequence3 = this.this$0.input;
                    this.nextItem = new IntRange(i5, StringsKt.getLastIndex(charSequence3));
                    this.nextSearchIndex = -1;
                } else {
                    int intValue = ((Number) pair.component1()).intValue();
                    int intValue2 = ((Number) pair.component2()).intValue();
                    this.nextItem = RangesKt.until(this.currentStartIndex, intValue);
                    int i6 = intValue + intValue2;
                    this.currentStartIndex = i6;
                    this.nextSearchIndex = i6 + (intValue2 == 0 ? 1 : 0);
                }
                this.nextState = 1;
                return;
            }
            int i7 = this.currentStartIndex;
            charSequence4 = this.this$0.input;
            this.nextItem = new IntRange(i7, StringsKt.getLastIndex(charSequence4));
            this.nextSearchIndex = -1;
            this.nextState = 1;
            return;
        }
        this.nextState = 0;
        this.nextItem = null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Iterator
    public IntRange next() {
        if (this.nextState == -1) {
            calcNext();
        }
        if (this.nextState == 0) {
            throw new NoSuchElementException();
        }
        IntRange intRange = this.nextItem;
        if (intRange == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.ranges.IntRange");
        }
        this.nextItem = null;
        this.nextState = -1;
        return intRange;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextState == -1) {
            calcNext();
        }
        return this.nextState == 1;
    }
}
