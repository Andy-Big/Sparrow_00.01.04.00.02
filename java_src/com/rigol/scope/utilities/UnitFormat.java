package com.rigol.scope.utilities;

import androidx.exifinterface.media.ExifInterface;
import ch.obermuhlner.math.big.BigDecimalMath;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.TwoTuple;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.function.BiConsumer;
/* loaded from: classes2.dex */
public class UnitFormat {
    private static final int DEFAULT_BASE = 1000;
    public static final String DEFAULT_PATTERN = "0.00";
    public static final String DEFAULT_PATTERN1 = "0.00";
    public static final String PATTERN_SIGN = "#";
    public static DecimalFormat format;
    private SI si = SI.NONE;
    private int base = 1000;
    private String pattern = "0.00";

    private static int getScaleLevel(double d) {
        if (d < 1.0d && d % 1.0d != 0.0d) {
            d -= 1.0d;
        }
        return (int) d;
    }

    public void setSi(SI si) {
        this.si = si;
    }

    public void setBase(int i) {
        this.base = i;
    }

    public void setPattern(String str) {
        this.pattern = str;
    }

    public static UnitFormat newBuilder() {
        return (UnitFormat) GenericBuilder.of($$Lambda$TrmQtJAKZPgWxUiTsa1erxTFMnA.INSTANCE).build();
    }

    public static UnitFormat newBuilder(String str, SI si) {
        return (UnitFormat) GenericBuilder.of($$Lambda$TrmQtJAKZPgWxUiTsa1erxTFMnA.INSTANCE).with($$Lambda$sN0T5cju86166G9mE5SGwx1VY5o.INSTANCE, str).with($$Lambda$oaqgS9Tp7RjmWj7NUqXDmeHwPA.INSTANCE, si).build();
    }

    public static UnitFormat newBuilder(int i) {
        return (UnitFormat) GenericBuilder.of($$Lambda$TrmQtJAKZPgWxUiTsa1erxTFMnA.INSTANCE).with(new BiConsumer() { // from class: com.rigol.scope.utilities.-$$Lambda$DPaqy_UxRQMMHhHIGy9aeZDdKUY
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                ((UnitFormat) obj).setBase(((Integer) obj2).intValue());
            }
        }, Integer.valueOf(i)).build();
    }

    public static UnitFormat newBuilder(String str) {
        return (UnitFormat) GenericBuilder.of($$Lambda$TrmQtJAKZPgWxUiTsa1erxTFMnA.INSTANCE).with($$Lambda$sN0T5cju86166G9mE5SGwx1VY5o.INSTANCE, str).build();
    }

    public static UnitFormat newBuilder(SI si) {
        return (UnitFormat) GenericBuilder.of($$Lambda$TrmQtJAKZPgWxUiTsa1erxTFMnA.INSTANCE).with($$Lambda$oaqgS9Tp7RjmWj7NUqXDmeHwPA.INSTANCE, si).build();
    }

    /* loaded from: classes2.dex */
    public enum SI {
        YOTTA(8, "Y"),
        ZETTA(7, "Z"),
        EXA(6, ExifInterface.LONGITUDE_EAST),
        PETA(5, "P"),
        TERA(4, ExifInterface.GPS_DIRECTION_TRUE),
        GIGA(3, "G"),
        MEGA(2, "M"),
        KILO(1, "k"),
        NONE(0, ""),
        MILLI(-1, "m"),
        MICRO(-2, "μ"),
        NANO(-3, "n"),
        PICO(-4, "p"),
        FEMTO(-5, "f"),
        ATTO(-6, ViewUtil.KEY_A),
        ZEPTO(-7, "z"),
        YOCTO(-8, "y");
        
        public final String prefixes;
        public final int scale;

        SI(int i, String str) {
            this.scale = i;
            this.prefixes = str;
        }

        public static SI get(int i) {
            SI[] values;
            for (SI si : values()) {
                if (si.scale == i) {
                    return si;
                }
            }
            return NONE;
        }

        public static SI get(String str) {
            SI[] values;
            for (SI si : values()) {
                if (si.prefixes.equals(str)) {
                    return si;
                }
            }
            return NONE;
        }
    }

    public String convert(long j, ServiceEnum.Unit unit) {
        return convert(j) + unit.value2;
    }

    public String convert(double d, ServiceEnum.Unit unit) {
        return convert(d) + unit.value2;
    }

    public String convert(BigDecimal bigDecimal, ServiceEnum.Unit unit) {
        return convert(bigDecimal) + unit.value2;
    }

    public String convert(long j) {
        return convert(j * Math.pow(this.base, this.si.scale), this.base, this.pattern);
    }

    public String convert(double d) {
        return convert(d * Math.pow(this.base, this.si.scale), this.base, this.pattern);
    }

    public String convert(BigDecimal bigDecimal) {
        DecimalFormat decimalFormat = new DecimalFormat(this.pattern);
        if (bigDecimal.compareTo(BigDecimal.ZERO) == 0) {
            return decimalFormat.format(0L);
        }
        BigDecimal valueOf = BigDecimal.valueOf(this.base);
        MathContext mathContext = new MathContext(100);
        BigDecimal multiply = bigDecimal.multiply(BigDecimalMath.pow(valueOf, BigDecimal.valueOf(this.si.scale), mathContext));
        int scaleLevel = getScaleLevel(BigDecimalMath.log(multiply.abs(), mathContext).divide(BigDecimalMath.log(valueOf, mathContext), mathContext));
        return convert(this.base, decimalFormat, scaleLevel, multiply.divide(BigDecimalMath.pow(valueOf, BigDecimal.valueOf(scaleLevel), mathContext), mathContext).doubleValue());
    }

    private static String convert(double d, int i, String str) {
        if (format == null) {
            format = new DecimalFormat();
        }
        format.applyPattern(str);
        if (d == 0.0d) {
            return format.format(0L);
        }
        double d2 = i;
        int scaleLevel = getScaleLevel(Math.log(Math.abs(d)) / Math.log(d2));
        return convert(i, format, scaleLevel, d / Math.pow(d2, scaleLevel));
    }

    private static String convert(int i, DecimalFormat decimalFormat, int i2, double d) {
        double d2 = i;
        TwoTuple<Boolean, BigDecimal> isRoundingChangeFirst = isRoundingChangeFirst(d2, d);
        if (isRoundingChangeFirst.getFirst().booleanValue()) {
            i2++;
            d = isRoundingChangeFirst.getSecond().doubleValue() / d2;
        }
        SI si = SI.get(i2);
        return decimalFormat.format(d) + si.prefixes;
    }

    private static TwoTuple<Boolean, BigDecimal> isRoundingChangeFirst(double d, double d2) {
        BigDecimal scale = BigDecimal.valueOf(d2).setScale(3, RoundingMode.UP);
        boolean z = false;
        if (!String.valueOf(scale.doubleValue()).substring(0, 1).equals(String.valueOf(d2).substring(0, 1)) && scale.doubleValue() >= d) {
            z = true;
        }
        return new TwoTuple<>(Boolean.valueOf(z), scale);
    }

    private int getScaleLevel(BigDecimal bigDecimal) {
        if (bigDecimal.doubleValue() < 1.0d && bigDecimal.doubleValue() % 1.0d != 0.0d) {
            return bigDecimal.intValue() - 1;
        }
        return bigDecimal.intValue();
    }

    public String toString() {
        return "UnitUtils{base=" + this.base + ", pattern=" + this.pattern + "}";
    }
}
