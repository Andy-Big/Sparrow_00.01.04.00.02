package kotlin.collections;

import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
class ArraysUtilJVM {
    ArraysUtilJVM() {
    }

    static <T> List<T> asList(T[] tArr) {
        return Arrays.asList(tArr);
    }
}
