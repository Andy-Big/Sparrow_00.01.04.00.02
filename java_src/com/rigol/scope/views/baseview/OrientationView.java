package com.rigol.scope.views.baseview;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.WeakRefHandler;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.views.TagView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: OrientationView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\bA\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 ~2\u00020\u0001:\u0001~B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J \u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020Y2\u0006\u0010q\u001a\u00020Y2\u0006\u0010r\u001a\u00020sH\u0002J\u000e\u0010t\u001a\u00020o2\u0006\u0010u\u001a\u00020vJ\u0010\u0010w\u001a\u00020o2\u0006\u0010r\u001a\u00020sH\u0014J\u000e\u0010x\u001a\u00020o2\u0006\u0010y\u001a\u00020YJ\u0010\u0010z\u001a\u00020o2\b\u0010{\u001a\u0004\u0018\u00010|J\u0006\u0010}\u001a\u00020oR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u001a\u0010\u0010\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR\u001a\u0010\u0013\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u001a\u0010\u0016\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR\u001a\u0010\u0019\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR\u001a\u0010\u001c\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u001a\u0010\u001f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\n\"\u0004\b$\u0010\fR\u001a\u0010%\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001a\u0010(\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\n\"\u0004\b*\u0010\fR\u001a\u0010+\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR\u001a\u0010.\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\n\"\u0004\b0\u0010\fR\u001a\u00101\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\fR\u001a\u00104\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\n\"\u0004\b6\u0010\fR\u001a\u00107\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010\fR\u001a\u0010:\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\n\"\u0004\b<\u0010\fR\u001a\u0010=\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\n\"\u0004\b?\u0010\fR\u001a\u0010@\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\n\"\u0004\bB\u0010\fR\u001a\u0010C\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\n\"\u0004\bE\u0010\fR\u001a\u0010F\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\n\"\u0004\bH\u0010\fR\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010K\u001a\u00020LX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010M\"\u0004\bN\u0010OR\u000e\u0010P\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010S\u001a\u00020\b2\u0006\u0010R\u001a\u00020\b@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\n\"\u0004\bU\u0010\fR\u000e\u0010V\u001a\u00020WX\u0082.¢\u0006\u0002\n\u0000R \u0010X\u001a\u00020YX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0011\u0010`\u001a\u00020a¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR$\u0010d\u001a\u00020Y2\u0006\u0010R\u001a\u00020Y@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010]\"\u0004\bf\u0010_R\u001a\u0010g\u001a\u00020hX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\u000e\u0010m\u001a\u00020QX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u007f"}, d2 = {"Lcom/rigol/scope/views/baseview/OrientationView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Meas_DelayFF", "", "getMeas_DelayFF", "()Ljava/lang/String;", "setMeas_DelayFF", "(Ljava/lang/String;)V", "Meas_DelayFR", "getMeas_DelayFR", "setMeas_DelayFR", "Meas_DelayRF", "getMeas_DelayRF", "setMeas_DelayRF", "Meas_DelayRR", "getMeas_DelayRR", "setMeas_DelayRR", "Meas_FallTime", "getMeas_FallTime", "setMeas_FallTime", "Meas_Freq", "getMeas_Freq", "setMeas_Freq", "Meas_NEdges", "getMeas_NEdges", "setMeas_NEdges", "Meas_NPulses", "getMeas_NPulses", "setMeas_NPulses", "Meas_Nslew_rate", "getMeas_Nslew_rate", "setMeas_Nslew_rate", "Meas_PEdges", "getMeas_PEdges", "setMeas_PEdges", "Meas_PPulses", "getMeas_PPulses", "setMeas_PPulses", "Meas_Period", "getMeas_Period", "setMeas_Period", "Meas_PhaseFF", "getMeas_PhaseFF", "setMeas_PhaseFF", "Meas_PhaseFR", "getMeas_PhaseFR", "setMeas_PhaseFR", "Meas_PhaseRF", "getMeas_PhaseRF", "setMeas_PhaseRF", "Meas_PhaseRR", "getMeas_PhaseRR", "setMeas_PhaseRR", "Meas_Pslew_rate", "getMeas_Pslew_rate", "setMeas_Pslew_rate", "Meas_RiseTime", "getMeas_RiseTime", "setMeas_RiseTime", "Meas_Vlower", "getMeas_Vlower", "setMeas_Vlower", "Meas_Vmid", "getMeas_Vmid", "setMeas_Vmid", "Meas_Vupper", "getMeas_Vupper", "setMeas_Vupper", "handler", "Lcom/rigol/scope/utilities/WeakRefHandler;", "isShowLine", "", "()Z", "setShowLine", "(Z)V", "linePaint", "Landroid/graphics/Paint;", "value", "meaType", "getMeaType", "setMeaType", "measureSettingParam", "Lcom/rigol/scope/data/MeasureSettingParam;", "orientation", "", "getOrientation$annotations", "()V", "getOrientation", "()I", "setOrientation", "(I)V", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "position", "getPosition", "setPosition", "tagAlphaLine", "", "getTagAlphaLine", "()F", "setTagAlphaLine", "(F)V", "textPaint", "drawLine", "", "halfHeight", "halfWidth", "canvas", "Landroid/graphics/Canvas;", "hideLineDelay", "delayMillis", "", "onDraw", "setLineColor", "color", "setLinePathEffect", "linePathEffect", "Landroid/graphics/PathEffect;", "showLine", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class OrientationView extends View {
    private static boolean isShowThreshold;
    private String Meas_DelayFF;
    private String Meas_DelayFR;
    private String Meas_DelayRF;
    private String Meas_DelayRR;
    private String Meas_FallTime;
    private String Meas_Freq;
    private String Meas_NEdges;
    private String Meas_NPulses;
    private String Meas_Nslew_rate;
    private String Meas_PEdges;
    private String Meas_PPulses;
    private String Meas_Period;
    private String Meas_PhaseFF;
    private String Meas_PhaseFR;
    private String Meas_PhaseRF;
    private String Meas_PhaseRR;
    private String Meas_Pslew_rate;
    private String Meas_RiseTime;
    private String Meas_Vlower;
    private String Meas_Vmid;
    private String Meas_Vupper;
    private final WeakRefHandler handler;
    private boolean isShowLine;
    private final Paint linePaint;
    private String meaType;
    private MeasureSettingParam measureSettingParam;
    private int orientation;
    private final Path path;
    private int position;
    private float tagAlphaLine;
    private final Paint textPaint;
    public static final Companion Companion = new Companion(null);
    private static String strThresholdLow = "";
    private static String strThresholdMiddle = "";
    private static String strThresholdHigh = "";
    private static String drawType = "";
    private static String sourceA = "";
    private static String sourceB = "";
    private static String sourceAMiddle = "";
    private static String sourceBMiddle = "";

    public static /* synthetic */ void getOrientation$annotations() {
    }

    public OrientationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LiveData<MeasureSettingParam> liveData;
        this.tagAlphaLine = 10.0f;
        this.Meas_Vupper = "25";
        this.Meas_Vmid = "26";
        this.Meas_Vlower = "27";
        this.Meas_DelayRR = "38";
        this.Meas_DelayRF = "39";
        this.Meas_DelayFR = "40";
        this.Meas_DelayFF = "41";
        this.Meas_PhaseRR = "42";
        this.Meas_PhaseRF = "43";
        this.Meas_PhaseFR = "44";
        this.Meas_PhaseFF = "45";
        this.Meas_Freq = ExifInterface.GPS_MEASUREMENT_2D;
        this.Meas_Period = "1";
        this.Meas_RiseTime = ExifInterface.GPS_MEASUREMENT_3D;
        this.Meas_FallTime = "4";
        this.Meas_PPulses = "9";
        this.Meas_NPulses = "10";
        this.Meas_PEdges = "11";
        this.Meas_NEdges = "12";
        this.Meas_Pslew_rate = "15";
        this.Meas_Nslew_rate = "16";
        this.path = new Path();
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setPathEffect(new PathEffect());
        paint.setColor(-1);
        Unit unit = Unit.INSTANCE;
        this.linePaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setTypeface(Typeface.DEFAULT_BOLD);
        paint2.setPathEffect(new PathEffect());
        paint2.setColor(-1);
        paint2.setTextSize(18.0f);
        Unit unit2 = Unit.INSTANCE;
        this.textPaint = paint2;
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel != null && (liveData = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData.observe((LifecycleOwner) topActivity, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.baseview.OrientationView.1
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        OrientationView orientationView = OrientationView.this;
                        Intrinsics.checkNotNullExpressionValue(measureSettingParam, "measureSettingParam");
                        orientationView.measureSettingParam = measureSettingParam;
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        this.meaType = "top";
        this.handler = new WeakRefHandler(new Handler.Callback() { // from class: com.rigol.scope.views.baseview.OrientationView$handler$1
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message msg) {
                Intrinsics.checkNotNullParameter(msg, "msg");
                int i = msg.what;
                if (i == 1) {
                    OrientationView.this.setShowLine(false);
                    OrientationView.this.invalidate();
                } else if (i == 2) {
                    OrientationView.this.setShowLine(true);
                    OrientationView.this.invalidate();
                }
                return false;
            }
        });
    }

    public static final /* synthetic */ MeasureSettingParam access$getMeasureSettingParam$p(OrientationView orientationView) {
        MeasureSettingParam measureSettingParam = orientationView.measureSettingParam;
        if (measureSettingParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
        }
        return measureSettingParam;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final void setOrientation(int i) {
        this.orientation = i;
    }

    public final float getTagAlphaLine() {
        return this.tagAlphaLine;
    }

    public final void setTagAlphaLine(float f) {
        this.tagAlphaLine = f;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            if (this.orientation == 0) {
                ((ConstraintLayout.LayoutParams) layoutParams).topMargin = getPosition();
            } else {
                ((ConstraintLayout.LayoutParams) layoutParams).startMargin = getPosition();
            }
        }
        setLayoutParams(layoutParams);
    }

    public final String getMeas_Vupper() {
        return this.Meas_Vupper;
    }

    public final void setMeas_Vupper(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_Vupper = str;
    }

    public final String getMeas_Vmid() {
        return this.Meas_Vmid;
    }

    public final void setMeas_Vmid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_Vmid = str;
    }

    public final String getMeas_Vlower() {
        return this.Meas_Vlower;
    }

    public final void setMeas_Vlower(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_Vlower = str;
    }

    public final String getMeas_DelayRR() {
        return this.Meas_DelayRR;
    }

    public final void setMeas_DelayRR(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_DelayRR = str;
    }

    public final String getMeas_DelayRF() {
        return this.Meas_DelayRF;
    }

    public final void setMeas_DelayRF(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_DelayRF = str;
    }

    public final String getMeas_DelayFR() {
        return this.Meas_DelayFR;
    }

    public final void setMeas_DelayFR(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_DelayFR = str;
    }

    public final String getMeas_DelayFF() {
        return this.Meas_DelayFF;
    }

    public final void setMeas_DelayFF(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_DelayFF = str;
    }

    public final String getMeas_PhaseRR() {
        return this.Meas_PhaseRR;
    }

    public final void setMeas_PhaseRR(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_PhaseRR = str;
    }

    public final String getMeas_PhaseRF() {
        return this.Meas_PhaseRF;
    }

    public final void setMeas_PhaseRF(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_PhaseRF = str;
    }

    public final String getMeas_PhaseFR() {
        return this.Meas_PhaseFR;
    }

    public final void setMeas_PhaseFR(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_PhaseFR = str;
    }

    public final String getMeas_PhaseFF() {
        return this.Meas_PhaseFF;
    }

    public final void setMeas_PhaseFF(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_PhaseFF = str;
    }

    public final String getMeas_Freq() {
        return this.Meas_Freq;
    }

    public final void setMeas_Freq(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_Freq = str;
    }

    public final String getMeas_Period() {
        return this.Meas_Period;
    }

    public final void setMeas_Period(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_Period = str;
    }

    public final String getMeas_RiseTime() {
        return this.Meas_RiseTime;
    }

    public final void setMeas_RiseTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_RiseTime = str;
    }

    public final String getMeas_FallTime() {
        return this.Meas_FallTime;
    }

    public final void setMeas_FallTime(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_FallTime = str;
    }

    public final String getMeas_PPulses() {
        return this.Meas_PPulses;
    }

    public final void setMeas_PPulses(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_PPulses = str;
    }

    public final String getMeas_NPulses() {
        return this.Meas_NPulses;
    }

    public final void setMeas_NPulses(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_NPulses = str;
    }

    public final String getMeas_PEdges() {
        return this.Meas_PEdges;
    }

    public final void setMeas_PEdges(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_PEdges = str;
    }

    public final String getMeas_NEdges() {
        return this.Meas_NEdges;
    }

    public final void setMeas_NEdges(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_NEdges = str;
    }

    public final String getMeas_Pslew_rate() {
        return this.Meas_Pslew_rate;
    }

    public final void setMeas_Pslew_rate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_Pslew_rate = str;
    }

    public final String getMeas_Nslew_rate() {
        return this.Meas_Nslew_rate;
    }

    public final void setMeas_Nslew_rate(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.Meas_Nslew_rate = str;
    }

    public final Path getPath() {
        return this.path;
    }

    public final boolean isShowLine() {
        return this.isShowLine;
    }

    public final void setShowLine(boolean z) {
        this.isShowLine = z;
    }

    /* compiled from: OrientationView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0019\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\u001a\u0010\u0011\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0006\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0006\"\u0004\b\u0016\u0010\bR\u001a\u0010\u0017\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\bR\u001a\u0010\u001a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\bR\u001a\u0010\u001d\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006#"}, d2 = {"Lcom/rigol/scope/views/baseview/OrientationView$Companion;", "", "()V", "drawType", "", "getDrawType", "()Ljava/lang/String;", "setDrawType", "(Ljava/lang/String;)V", "isShowThreshold", "", "()Z", "setShowThreshold", "(Z)V", "sourceA", "getSourceA", "setSourceA", "sourceAMiddle", "getSourceAMiddle", "setSourceAMiddle", "sourceB", "getSourceB", "setSourceB", "sourceBMiddle", "getSourceBMiddle", "setSourceBMiddle", "strThresholdHigh", "getStrThresholdHigh", "setStrThresholdHigh", "strThresholdLow", "getStrThresholdLow", "setStrThresholdLow", "strThresholdMiddle", "getStrThresholdMiddle", "setStrThresholdMiddle", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getStrThresholdLow() {
            return OrientationView.strThresholdLow;
        }

        public final void setStrThresholdLow(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OrientationView.strThresholdLow = str;
        }

        public final String getStrThresholdMiddle() {
            return OrientationView.strThresholdMiddle;
        }

        public final void setStrThresholdMiddle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OrientationView.strThresholdMiddle = str;
        }

        public final String getStrThresholdHigh() {
            return OrientationView.strThresholdHigh;
        }

        public final void setStrThresholdHigh(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OrientationView.strThresholdHigh = str;
        }

        public final boolean isShowThreshold() {
            return OrientationView.isShowThreshold;
        }

        public final void setShowThreshold(boolean z) {
            OrientationView.isShowThreshold = z;
        }

        public final String getDrawType() {
            return OrientationView.drawType;
        }

        public final void setDrawType(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OrientationView.drawType = str;
        }

        public final String getSourceA() {
            return OrientationView.sourceA;
        }

        public final void setSourceA(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OrientationView.sourceA = str;
        }

        public final String getSourceB() {
            return OrientationView.sourceB;
        }

        public final void setSourceB(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OrientationView.sourceB = str;
        }

        public final String getSourceAMiddle() {
            return OrientationView.sourceAMiddle;
        }

        public final void setSourceAMiddle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OrientationView.sourceAMiddle = str;
        }

        public final String getSourceBMiddle() {
            return OrientationView.sourceBMiddle;
        }

        public final void setSourceBMiddle(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            OrientationView.sourceBMiddle = str;
        }
    }

    public String getMeaType() {
        return this.meaType;
    }

    public void setMeaType(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.meaType = value;
    }

    public final void setLineColor(int i) {
        this.linePaint.setColor(i);
    }

    public final void showLine() {
        this.handler.sendEmptyMessage(2);
    }

    public final void hideLineDelay(long j) {
        this.handler.removeMessages(1);
        this.handler.sendEmptyMessageDelayed(1, j);
    }

    public final void setLinePathEffect(PathEffect pathEffect) {
        this.linePaint.setPathEffect(pathEffect);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawLine(getHeight() >> 1, getWidth() >> 1, canvas);
    }

    private final void drawLine(int i, int i2, Canvas canvas) {
        if (this.isShowLine) {
            this.path.reset();
            float strokeWidth = this.linePaint.getStrokeWidth() / 2;
            if (this.orientation == 0) {
                if (Intrinsics.areEqual(this.linePaint.getPathEffect(), TagView.DEFAULT_DASH_PATH_EFFECT)) {
                    float f = i;
                    this.path.moveTo(0.0f, f);
                    this.path.lineTo(getWidth(), f);
                } else {
                    float f2 = i + strokeWidth;
                    this.path.moveTo(0.0f, f2);
                    this.path.lineTo(getWidth(), f2);
                }
            } else if (Intrinsics.areEqual(this.linePaint.getPathEffect(), TagView.DEFAULT_DASH_PATH_EFFECT)) {
                float f3 = i2;
                this.path.moveTo(f3, 0.0f);
                this.path.lineTo(f3, getHeight());
            } else {
                float f4 = i2 + strokeWidth;
                this.path.moveTo(f4, 0.0f);
                this.path.lineTo(f4, getHeight());
            }
            if (isShowThreshold && this.orientation == 0 && this.linePaint.getColor() == -29369) {
                if (Intrinsics.areEqual(this.Meas_Vlower, drawType) || Intrinsics.areEqual("Meas_Vlower", drawType)) {
                    canvas.drawText(strThresholdLow, 40.0f, getHeight() - 10, this.textPaint);
                } else if (Intrinsics.areEqual(this.Meas_FallTime, drawType) || Intrinsics.areEqual("Meas_FallTime", drawType) || Intrinsics.areEqual(this.Meas_PPulses, drawType) || Intrinsics.areEqual("Meas_PPulses", drawType) || Intrinsics.areEqual(this.Meas_NPulses, drawType) || Intrinsics.areEqual("Meas_NPulses", drawType) || Intrinsics.areEqual(this.Meas_PEdges, drawType) || Intrinsics.areEqual("Meas_PEdges", drawType) || Intrinsics.areEqual(this.Meas_NEdges, drawType) || Intrinsics.areEqual("Meas_NEdges", drawType) || Intrinsics.areEqual(this.Meas_Nslew_rate, drawType) || Intrinsics.areEqual("Meas_Nslew_rate", drawType)) {
                    if (Intrinsics.areEqual(getMeaType(), "top")) {
                        canvas.drawText(strThresholdHigh, 40.0f, getHeight() - 10, this.textPaint);
                    } else if (Intrinsics.areEqual(getMeaType(), "low")) {
                        canvas.drawText(strThresholdLow, 40.0f, getHeight() - 10, this.textPaint);
                    }
                } else if (Intrinsics.areEqual(this.Meas_RiseTime, drawType) || Intrinsics.areEqual("Meas_RiseTime", drawType) || Intrinsics.areEqual(this.Meas_Pslew_rate, drawType) || Intrinsics.areEqual("Meas_Pslew_rate", drawType)) {
                    if (Intrinsics.areEqual(getMeaType(), "top")) {
                        canvas.drawText(strThresholdLow, 40.0f, getHeight() - 10, this.textPaint);
                    } else if (Intrinsics.areEqual(getMeaType(), "low")) {
                        canvas.drawText(strThresholdHigh, 40.0f, getHeight() - 10, this.textPaint);
                    }
                } else if (Intrinsics.areEqual(this.Meas_Vupper, drawType) || Intrinsics.areEqual("Meas_Vupper", drawType)) {
                    canvas.drawText(strThresholdHigh, 40.0f, getHeight() - 10, this.textPaint);
                } else if (Intrinsics.areEqual(this.Meas_DelayRR, drawType) || Intrinsics.areEqual(this.Meas_PhaseFF, drawType) || Intrinsics.areEqual(this.Meas_DelayRF, drawType) || Intrinsics.areEqual(this.Meas_DelayFR, drawType) || Intrinsics.areEqual(this.Meas_DelayFF, drawType) || Intrinsics.areEqual(this.Meas_PhaseRR, drawType) || Intrinsics.areEqual(this.Meas_PhaseRF, drawType) || Intrinsics.areEqual(this.Meas_PhaseFR, drawType) || Intrinsics.areEqual("Meas_DelayRR", drawType) || Intrinsics.areEqual("Meas_PhaseFF", drawType) || Intrinsics.areEqual("Meas_DelayRF", drawType) || Intrinsics.areEqual("Meas_DelayFR", drawType) || Intrinsics.areEqual("Meas_DelayFF", drawType) || Intrinsics.areEqual("Meas_PhaseRR", drawType) || Intrinsics.areEqual("Meas_PhaseRF", drawType) || Intrinsics.areEqual("Meas_PhaseFR", drawType)) {
                    if (Intrinsics.areEqual(this.linePaint.getPathEffect(), TagView.DEFAULT_DASH_PATH_EFFECT)) {
                        MeasureSettingParam measureSettingParam = this.measureSettingParam;
                        if (measureSettingParam == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
                        }
                        if (Intrinsics.areEqual(String.valueOf(measureSettingParam.readThresholdSource().value1), sourceB)) {
                            canvas.drawText(strThresholdMiddle, 40.0f, getHeight() - 10, this.textPaint);
                        } else {
                            canvas.drawText(sourceAMiddle, 40.0f, getHeight() - 10, this.textPaint);
                        }
                    } else {
                        MeasureSettingParam measureSettingParam2 = this.measureSettingParam;
                        if (measureSettingParam2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("measureSettingParam");
                        }
                        if (Intrinsics.areEqual(String.valueOf(measureSettingParam2.readThresholdSource().value1), sourceA)) {
                            canvas.drawText(strThresholdMiddle, 40.0f, getHeight() - 10, this.textPaint);
                        } else {
                            canvas.drawText(sourceBMiddle, 40.0f, getHeight() - 10, this.textPaint);
                        }
                    }
                } else if (Intrinsics.areEqual(this.Meas_Vmid, drawType) || Intrinsics.areEqual("Meas_Vmid", drawType) || Intrinsics.areEqual(this.Meas_Freq, drawType) || Intrinsics.areEqual("Meas_Freq", drawType) || Intrinsics.areEqual(this.Meas_Period, drawType) || Intrinsics.areEqual("Meas_Period", drawType)) {
                    canvas.drawText(strThresholdMiddle, 40.0f, getHeight() - 10, this.textPaint);
                }
            }
            float f5 = this.tagAlphaLine;
            if (f5 != 10.0f) {
                this.linePaint.setAlpha((int) (f5 * 255));
            }
            canvas.drawPath(this.path, this.linePaint);
        }
    }
}
