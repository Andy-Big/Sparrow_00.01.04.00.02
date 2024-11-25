package com.rigol.scope.views.baseview;

import android.graphics.DashPathEffect;
import android.graphics.PathEffect;
import kotlin.Metadata;
/* compiled from: OrientationView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"DEFAULT_DASH_PATH_EFFECT", "Landroid/graphics/PathEffect;", "getDEFAULT_DASH_PATH_EFFECT", "()Landroid/graphics/PathEffect;", "DEFAULT_LINE_STROKE_WIDTH", "", "HORIZONTAL", "", "MSG_HIDE_INDICATOR_LINE", "MSG_SHOW_INDICATOR_LINE", "VERTICAL", "app_release"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class OrientationViewKt {
    private static final PathEffect DEFAULT_DASH_PATH_EFFECT = new DashPathEffect(new float[]{10.0f, 3.0f, 1.0f, 3.0f}, 0);
    public static final float DEFAULT_LINE_STROKE_WIDTH = 2.0f;
    public static final int HORIZONTAL = 0;
    public static final int MSG_HIDE_INDICATOR_LINE = 1;
    public static final int MSG_SHOW_INDICATOR_LINE = 2;
    public static final int VERTICAL = 1;

    public static final PathEffect getDEFAULT_DASH_PATH_EFFECT() {
        return DEFAULT_DASH_PATH_EFFECT;
    }
}
