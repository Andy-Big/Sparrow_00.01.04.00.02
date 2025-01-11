package org.apache.commons.csv;

/* loaded from: classes2.dex */
final class Assertions {
    private Assertions() {
    }

    static void notNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new IllegalArgumentException("Parameter '" + str + "' must not be null!");
    }
}
