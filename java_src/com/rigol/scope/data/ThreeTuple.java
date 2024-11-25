package com.rigol.scope.data;
/* loaded from: classes2.dex */
public class ThreeTuple<A, B, C> {
    private final A first;
    private final B second;
    private final C third;

    public ThreeTuple(A a, B b, C c) {
        this.first = a;
        this.second = b;
        this.third = c;
    }

    public A getFirst() {
        return this.first;
    }

    public B getSecond() {
        return this.second;
    }

    public C getThird() {
        return this.third;
    }
}
