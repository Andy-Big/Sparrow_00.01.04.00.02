package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.core.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    private GradientColorInflaterCompat() {
    }

    static Shader createFromXml(Resources resources, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlPullParser);
        do {
            next = xmlPullParser.next();
            if (next == 2) {
                break;
            }
        } while (next != 1);
        if (next != 2) {
            throw new XmlPullParserException("No start tag found");
        }
        return createFromXmlInner(resources, xmlPullParser, asAttributeSet, theme);
    }

    static Shader createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        String name = xmlPullParser.getName();
        if (!name.equals("gradient")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.GradientColor);
        float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startX", R.styleable.GradientColor_android_startX, 0.0f);
        float namedFloat2 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "startY", R.styleable.GradientColor_android_startY, 0.0f);
        float namedFloat3 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endX", R.styleable.GradientColor_android_endX, 0.0f);
        float namedFloat4 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "endY", R.styleable.GradientColor_android_endY, 0.0f);
        float namedFloat5 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
        float namedFloat6 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
        int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "type", R.styleable.GradientColor_android_type, 0);
        int namedColor = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "startColor", R.styleable.GradientColor_android_startColor, 0);
        boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser, "centerColor");
        int namedColor2 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
        int namedColor3 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser, "endColor", R.styleable.GradientColor_android_endColor, 0);
        int namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
        float namedFloat7 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
        obtainAttributes.recycle();
        ColorStops checkColors = checkColors(inflateChildElements(resources, xmlPullParser, attributeSet, theme), namedColor, namedColor3, hasAttribute, namedColor2);
        if (namedInt != 1) {
            if (namedInt == 2) {
                return new SweepGradient(namedFloat5, namedFloat6, checkColors.mColors, checkColors.mOffsets);
            }
            return new LinearGradient(namedFloat, namedFloat2, namedFloat3, namedFloat4, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2));
        } else if (namedFloat7 <= 0.0f) {
            throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
        } else {
            return new RadialGradient(namedFloat5, namedFloat6, namedFloat7, checkColors.mColors, checkColors.mOffsets, parseTileMode(namedInt2));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0084, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r9.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static ColorStops inflateChildElements(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth;
        int depth2 = xmlPullParser.getDepth() + 1;
        ArrayList arrayList = new ArrayList(20);
        ArrayList arrayList2 = new ArrayList(20);
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || ((depth = xmlPullParser.getDepth()) < depth2 && next == 3)) {
                break;
            } else if (next == 2 && depth <= depth2 && xmlPullParser.getName().equals("item")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.GradientColorItem);
                boolean hasValue = obtainAttributes.hasValue(R.styleable.GradientColorItem_android_color);
                boolean hasValue2 = obtainAttributes.hasValue(R.styleable.GradientColorItem_android_offset);
                if (!hasValue || !hasValue2) {
                    break;
                }
                int color = obtainAttributes.getColor(R.styleable.GradientColorItem_android_color, 0);
                float f = obtainAttributes.getFloat(R.styleable.GradientColorItem_android_offset, 0.0f);
                obtainAttributes.recycle();
                arrayList2.add(Integer.valueOf(color));
                arrayList.add(Float.valueOf(f));
            }
        }
        if (arrayList2.size() > 0) {
            return new ColorStops(arrayList2, arrayList);
        }
        return null;
    }

    private static ColorStops checkColors(ColorStops colorStops, int i, int i2, boolean z, int i3) {
        if (colorStops != null) {
            return colorStops;
        }
        if (z) {
            return new ColorStops(i, i3, i2);
        }
        return new ColorStops(i, i2);
    }

    private static Shader.TileMode parseTileMode(int i) {
        if (i != 1) {
            if (i == 2) {
                return Shader.TileMode.MIRROR;
            }
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.REPEAT;
    }

    /* loaded from: classes.dex */
    static final class ColorStops {
        final int[] mColors;
        final float[] mOffsets;

        ColorStops(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.mColors = new int[size];
            this.mOffsets = new float[size];
            for (int i = 0; i < size; i++) {
                this.mColors[i] = list.get(i).intValue();
                this.mOffsets[i] = list2.get(i).floatValue();
            }
        }

        ColorStops(int i, int i2) {
            this.mColors = new int[]{i, i2};
            this.mOffsets = new float[]{0.0f, 1.0f};
        }

        ColorStops(int i, int i2, int i3) {
            this.mColors = new int[]{i, i2, i3};
            this.mOffsets = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
