package com.rigol.scope.utilities;

import android.graphics.Color;
import android.util.SparseIntArray;
import kotlin.Metadata;
/* compiled from: Colors.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000bR\u0010\u0010\u0011\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/rigol/scope/utilities/Colors;", "", "()V", "ACQUIRE_DEPTH", "", "ACQUIRE_VIEW_BG", "ACQUIRE_ZOOM_SHADOW", "CURSOR", "DECODE_COLORS", "Landroid/util/SparseIntArray;", "getDECODE_COLORS", "()Landroid/util/SparseIntArray;", "EXPAND", "HORIZONTAL_RULER", "INDICATOR", "REF_COLORS", "getREF_COLORS", "TRIGGER", "WINDOW_BACKGROUND", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class Colors {
    public static final int ACQUIRE_DEPTH = -9408400;
    public static final int ACQUIRE_VIEW_BG = -14800597;
    public static final int ACQUIRE_ZOOM_SHADOW = -14000982;
    public static final int CURSOR = -1;
    private static final SparseIntArray DECODE_COLORS;
    public static final int EXPAND = -29696;
    public static final int HORIZONTAL_RULER = -29696;
    public static final int INDICATOR = -29369;
    public static final Colors INSTANCE = new Colors();
    private static final SparseIntArray REF_COLORS;
    public static final int TRIGGER = -32768;
    public static final int WINDOW_BACKGROUND = -15724528;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.append(0, Color.argb(255, 0, 102, 0));
        sparseIntArray.append(1, Color.argb(255, 255, 0, 0));
        sparseIntArray.append(2, Color.argb(255, 0, 128, 128));
        sparseIntArray.append(3, Color.argb(255, 128, 128, 0));
        sparseIntArray.append(4, Color.argb(255, 102, 102, 0));
        sparseIntArray.append(5, Color.argb(255, 255, 128, 128));
        sparseIntArray.append(6, Color.argb(255, 255, 0, 128));
        sparseIntArray.append(7, Color.argb(255, 255, 0, 0));
        sparseIntArray.append(8, Color.argb(255, 0, 64, 128));
        sparseIntArray.append(9, Color.argb(255, 128, 128, 0));
        sparseIntArray.append(10, Color.argb(255, 64, 100, 255));
        sparseIntArray.append(11, Color.argb(255, 0, 102, 0));
        sparseIntArray.append(12, Color.argb(255, 128, 128, 0));
        sparseIntArray.append(13, Color.argb(255, 255, 100, 20));
        sparseIntArray.append(14, Color.argb(255, 255, 0, 0));
        sparseIntArray.append(15, Color.argb(255, 0, 255, 255));
        sparseIntArray.append(16, Color.argb(255, 0, 0, 255));
        sparseIntArray.append(17, Color.argb(255, 128, 128, 255));
        sparseIntArray.append(18, Color.argb(255, 255, 80, 0));
        sparseIntArray.append(19, Color.argb(255, 0, 128, 128));
        sparseIntArray.append(20, Color.argb(255, 0, 0, 255));
        sparseIntArray.append(21, Color.argb(255, 0, 0, 0));
        DECODE_COLORS = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        sparseIntArray2.append(0, Color.argb(255, 169, 169, 169));
        sparseIntArray2.append(1, Color.argb(255, 0, 100, 0));
        sparseIntArray2.append(2, Color.argb(255, 173, 216, 230));
        sparseIntArray2.append(3, Color.argb(255, 139, 0, 0));
        sparseIntArray2.append(4, Color.argb(255, 200, 64, 0));
        REF_COLORS = sparseIntArray2;
    }

    private Colors() {
    }

    public final SparseIntArray getDECODE_COLORS() {
        return DECODE_COLORS;
    }

    public final SparseIntArray getREF_COLORS() {
        return REF_COLORS;
    }
}
