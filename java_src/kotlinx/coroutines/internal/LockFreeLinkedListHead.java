package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: LockFreeLinkedList.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J-\u0010\u0006\u001a\u00020\u0007\"\u000e\b\u0000\u0010\b\u0018\u0001*\u00060\u0001j\u0002`\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0086\bJ\u0006\u0010\f\u001a\u00020\u0004J\r\u0010\r\u001a\u00020\u0007H\u0000¢\u0006\u0002\b\u000eR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u000f"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "()V", "isEmpty", "", "()Z", "forEach", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/internal/Node;", "block", "Lkotlin/Function1;", "remove", "validate", "validate$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    public final boolean isEmpty() {
        return getNext() == this;
    }

    public final /* synthetic */ <T extends LockFreeLinkedListNode> void forEach(Function1<? super T, Unit> block) {
        Intrinsics.checkParameterIsNotNull(block, "block");
        Object next = getNext();
        if (next == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        for (LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next; !Intrinsics.areEqual(lockFreeLinkedListNode, this); lockFreeLinkedListNode = lockFreeLinkedListNode.getNextNode()) {
            Intrinsics.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
            if (lockFreeLinkedListNode instanceof LockFreeLinkedListNode) {
                block.invoke(lockFreeLinkedListNode);
            }
        }
    }

    @Override // kotlinx.coroutines.internal.LockFreeLinkedListNode
    public final boolean remove() {
        throw new UnsupportedOperationException();
    }

    public final void validate$kotlinx_coroutines_core() {
        LockFreeLinkedListHead lockFreeLinkedListHead = this;
        Object next = getNext();
        if (next == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        LockFreeLinkedListNode lockFreeLinkedListNode = (LockFreeLinkedListNode) next;
        LockFreeLinkedListHead lockFreeLinkedListHead2 = lockFreeLinkedListHead;
        LockFreeLinkedListNode lockFreeLinkedListNode2 = lockFreeLinkedListNode;
        while (!Intrinsics.areEqual(lockFreeLinkedListNode2, this)) {
            LockFreeLinkedListNode nextNode = lockFreeLinkedListNode2.getNextNode();
            lockFreeLinkedListNode2.validateNode$kotlinx_coroutines_core(lockFreeLinkedListHead2, nextNode);
            lockFreeLinkedListHead2 = lockFreeLinkedListNode2;
            lockFreeLinkedListNode2 = nextNode;
        }
        Object next2 = getNext();
        if (next2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        }
        validateNode$kotlinx_coroutines_core(lockFreeLinkedListHead2, (LockFreeLinkedListNode) next2);
    }
}
