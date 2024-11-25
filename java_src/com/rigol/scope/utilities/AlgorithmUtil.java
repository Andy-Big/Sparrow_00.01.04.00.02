package com.rigol.scope.utilities;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
/* loaded from: classes2.dex */
public class AlgorithmUtil {
    public static float easeOutQuart(float f) {
        BigDecimal subtract = new BigDecimal(f, new MathContext(2, RoundingMode.DOWN)).subtract(BigDecimal.valueOf(1L));
        return 1.0f - subtract.multiply(subtract).multiply(subtract).multiply(subtract).floatValue();
    }

    public static float easeOutCubic(float f) {
        BigDecimal subtract = new BigDecimal(f, new MathContext(2, RoundingMode.DOWN)).subtract(BigDecimal.valueOf(1L));
        return subtract.multiply(subtract).multiply(subtract).floatValue() + 1.0f;
    }

    public static float easeOutQuad(float f) {
        BigDecimal bigDecimal = new BigDecimal(f, new MathContext(2, RoundingMode.DOWN));
        return bigDecimal.multiply(BigDecimal.valueOf(2.0f - bigDecimal.floatValue())).floatValue();
    }

    public static float easeOutCirc(float f) {
        return BigDecimal.valueOf(Math.sqrt(1.0f - new BigDecimal(f, new MathContext(2, RoundingMode.DOWN)).subtract(BigDecimal.valueOf(1L)).pow(2).floatValue())).floatValue();
    }
}
