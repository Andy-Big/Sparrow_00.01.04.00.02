package com.rigol.scope.utilities;

import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StateManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ$\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fJ\"\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\n\u0010\u0011\u001a\u00020\u0012\"\u00020\fJ\"\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\fH\u0002J7\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0018\"\u00020\u0001¢\u0006\u0002\u0010\u0019R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, d2 = {"Lcom/rigol/scope/utilities/StateManager;", "", "()V", "states", "Landroidx/collection/SimpleArrayMap;", "getStates", "()Landroidx/collection/SimpleArrayMap;", "getColumnState", "Landroidx/collection/SparseArrayCompat;", "", "key", "n", "", "whichColumn", "getSource2State", "whichRow", "getState", "args", "", "isNArray", "value", "length", "setState", "", "", "(Ljava/lang/Object;II[Ljava/lang/Object;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class StateManager {
    public static final StateManager INSTANCE = new StateManager();
    private static final SimpleArrayMap<Object, Object> states = new SimpleArrayMap<>();

    private StateManager() {
    }

    public final SimpleArrayMap<Object, Object> getStates() {
        return states;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v11, types: [boolean[][]] */
    /* JADX WARN: Type inference failed for: r1v12, types: [boolean[][][]] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v9, types: [boolean[]] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.rigol.scope.utilities.StateManager] */
    public final void setState(Object key, int i, int i2, Object... args) {
        Number number;
        int intValue;
        Number number2;
        int intValue2;
        Number number3;
        int intValue3;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        if (i <= 2) {
            if (!(args.length == 0) && args.length == i + 1 && i2 > 0) {
                Object obj = states.containsKey(key) ? states.get(key) : null;
                if (obj == null) {
                    if (i == 1) {
                        obj = new boolean[i2];
                    } else if (i == 2) {
                        obj = new boolean[i2];
                        for (int i3 = 0; i3 < i2; i3++) {
                            obj[i3] = new boolean[i2];
                        }
                    } else {
                        obj = new boolean[i2][];
                        for (int i4 = 0; i4 < i2; i4++) {
                            boolean[][] zArr = new boolean[i2];
                            for (int i5 = 0; i5 < i2; i5++) {
                                zArr[i5] = new boolean[i2];
                            }
                            obj[i4] = zArr;
                        }
                    }
                    states.put(key, obj);
                }
                if (isNArray(obj, i, i2)) {
                    if (i == 1) {
                        Object obj2 = args[0];
                        Object obj3 = args[1];
                        if (!(obj2 instanceof Integer) || (intValue3 = (number3 = (Number) obj2).intValue()) < 0 || i2 <= intValue3 || !(obj3 instanceof Boolean)) {
                            return;
                        }
                        ((boolean[]) obj)[number3.intValue()] = ((Boolean) obj3).booleanValue();
                    } else if (i == 2) {
                        Object obj4 = args[0];
                        Object obj5 = args[1];
                        Object obj6 = args[2];
                        if (!(obj4 instanceof Integer) || !(obj5 instanceof Integer) || !(obj6 instanceof Boolean) || (intValue = (number = (Number) obj4).intValue()) < 0 || i2 <= intValue || (intValue2 = (number2 = (Number) obj5).intValue()) < 0 || i2 <= intValue2) {
                            return;
                        }
                        Object obj7 = ((Object[]) obj)[number.intValue()];
                        if (obj7 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.BooleanArray");
                        }
                        ((boolean[]) obj7)[number2.intValue()] = ((Boolean) obj6).booleanValue();
                    }
                }
            }
        }
    }

    private final boolean isNArray(Object obj, int i, int i2) {
        if (obj != null && i > 0 && i <= 2 && i2 > 0) {
            if (i == 1) {
                if ((obj instanceof boolean[]) && ((boolean[]) obj).length == i2) {
                    return true;
                }
            } else if (i == 2 && (obj instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length == i2) {
                    Object obj2 = objArr[0];
                    if ((obj2 instanceof boolean[]) && ((boolean[]) obj2).length == i2) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public final boolean getState(Object key, int i, int... args) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(args, "args");
        if (i <= 0 || i > 2 || args.length != i || !states.containsKey(key)) {
            return false;
        }
        Object obj = states.get(key);
        if (i == 1) {
            if (obj instanceof boolean[]) {
                int i2 = args[0];
                boolean[] zArr = (boolean[]) obj;
                int length = zArr.length;
                if (i2 >= 0 && length > i2) {
                    return zArr[i2];
                }
            }
        } else if (i == 2 && (obj instanceof Object[])) {
            int i3 = args[0];
            Object[] objArr = (Object[]) obj;
            int length2 = objArr.length;
            if (i3 >= 0 && length2 > i3) {
                Object obj2 = objArr[i3];
                if (obj2 instanceof boolean[]) {
                    int i4 = args[1];
                    boolean[] zArr2 = (boolean[]) obj2;
                    int length3 = zArr2.length;
                    if (i4 >= 0 && length3 > i4) {
                        return zArr2[i4];
                    }
                }
            }
        }
        return false;
    }

    public final SparseArrayCompat<Boolean> getColumnState(Object key, int i, int i2) {
        Intrinsics.checkNotNullParameter(key, "key");
        SparseArrayCompat<Boolean> sparseArrayCompat = new SparseArrayCompat<>();
        if (i > 1 && i <= 2) {
            Object obj = states.get(key);
            int i3 = 0;
            if (i == 1) {
                if (obj instanceof boolean[]) {
                    boolean[] zArr = (boolean[]) obj;
                    if (zArr.length < 0) {
                        return sparseArrayCompat;
                    }
                    int length = zArr.length;
                    int i4 = 0;
                    while (i3 < length) {
                        sparseArrayCompat.put(i4, Boolean.valueOf(zArr[i3]));
                        i3++;
                        i4++;
                    }
                }
            } else if (i == 2 && (obj instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length == 0) {
                    return sparseArrayCompat;
                }
                int length2 = objArr.length;
                int i5 = 0;
                int i6 = 0;
                while (i5 < length2) {
                    Object obj2 = objArr[i5];
                    int i7 = i6 + 1;
                    if (obj2 instanceof boolean[]) {
                        boolean[] zArr2 = (boolean[]) obj2;
                        if (zArr2.length >= 0 && i2 < zArr2.length) {
                            sparseArrayCompat.put(i6, Boolean.valueOf(!zArr2[i2]));
                            i5++;
                            i6 = i7;
                        }
                    }
                    sparseArrayCompat.put(i6, false);
                    i5++;
                    i6 = i7;
                }
            }
        }
        return sparseArrayCompat;
    }

    public final SparseArrayCompat<Boolean> getSource2State(Object key, int i, int i2) {
        Object obj;
        boolean[] zArr;
        boolean[] zArr2;
        Intrinsics.checkNotNullParameter(key, "key");
        SparseArrayCompat<Boolean> sparseArrayCompat = new SparseArrayCompat<>();
        if (i > 0 && i <= 2 && (obj = states.get(key)) != null) {
            Intrinsics.checkNotNullExpressionValue(obj, "states.get(key) ?: return stateArray");
            int i3 = 0;
            if (i == 1) {
                if (obj instanceof boolean[]) {
                    int length = ((boolean[]) obj).length;
                    int i4 = 0;
                    while (i3 < length) {
                        sparseArrayCompat.put(i4, Boolean.valueOf(!zArr2[i3]));
                        i3++;
                        i4++;
                    }
                }
            } else if (i == 2 && (obj instanceof Object[])) {
                Object[] objArr = (Object[]) obj;
                if (objArr.length > i2) {
                    Object obj2 = objArr[i2];
                    if (obj2 instanceof boolean[]) {
                        int length2 = ((boolean[]) obj2).length;
                        int i5 = 0;
                        while (i3 < length2) {
                            sparseArrayCompat.put(i5, Boolean.valueOf(!zArr[i3]));
                            i3++;
                            i5++;
                        }
                    }
                }
            }
        }
        return sparseArrayCompat;
    }
}
