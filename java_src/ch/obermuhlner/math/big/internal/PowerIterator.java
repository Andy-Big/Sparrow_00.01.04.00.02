package ch.obermuhlner.math.big.internal;

import java.math.BigDecimal;
/* loaded from: classes.dex */
public interface PowerIterator {
    void calculateNextPower();

    BigDecimal getCurrentPower();
}
