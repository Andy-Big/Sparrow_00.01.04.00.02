package com.rigol.scope.views.histogram;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.rigol.scope.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: HistogramRectView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0014\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u0089\u00012\u00020\u0001:\u0004\u0088\u0001\u0089\u0001B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\nB1\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\f¢\u0006\u0002\u0010\u0010J0\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010s\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010t\u001a\u00020oH\u0002J\b\u0010u\u001a\u00020oH\u0002J>\u0010v\u001a\u00020-2\u0006\u0010w\u001a\u00020\f2\u0006\u0010x\u001a\u00020\f2\u0006\u0010y\u001a\u00020\f2\u0006\u0010z\u001a\u00020\f2\u0006\u0010C\u001a\u00020D2\u0006\u0010{\u001a\u00020D2\u0006\u0010|\u001a\u00020DJ\u0010\u0010}\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0014J\u0019\u0010~\u001a\u00020o2\u0006\u0010\u007f\u001a\u00020\u00072\u0007\u0010\u0080\u0001\u001a\u00020\u0007H\u0014J\u0013\u0010\u0081\u0001\u001a\u00020-2\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0016J\u000f\u0010\u0084\u0001\u001a\u00020o2\u0006\u0010\u0011\u001a\u00020\fJ7\u0010\u0085\u0001\u001a\u00020o2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0003\u0010\u0086\u0001J5\u0010\u0085\u0001\u001a\u00020o2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0003\u0010\u0087\u0001R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R\u000e\u0010*\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010.\"\u0004\b/\u00100R\u001a\u00101\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010.\"\u0004\b2\u00100R\u001a\u00103\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010.\"\u0004\b4\u00100R\u001a\u00105\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010.\"\u0004\b6\u00100R\u001a\u00107\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010.\"\u0004\b8\u00100R\u001a\u00109\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010.\"\u0004\b:\u00100R\u001a\u0010;\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010.\"\u0004\b<\u00100R\u001a\u0010=\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010.\"\u0004\b>\u00100R\u001a\u0010?\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010.\"\u0004\b@\u00100R\u001a\u0010A\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010.\"\u0004\bB\u00100R\u001a\u0010C\u001a\u00020DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010$\"\u0004\bK\u0010&R\u001a\u0010L\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&R\u0010\u0010O\u001a\u0004\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010R\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010$\"\u0004\bT\u0010&R$\u0010U\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010$\"\u0004\bW\u0010&R$\u0010X\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010$\"\u0004\bZ\u0010&R$\u0010[\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010$\"\u0004\b]\u0010&R$\u0010^\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010$\"\u0004\b`\u0010&R\u0011\u0010a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bb\u0010\u001fR$\u0010c\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010$\"\u0004\be\u0010&R$\u0010f\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010$\"\u0004\bh\u0010&R$\u0010i\u001a\u00020\f2\u0006\u0010Q\u001a\u00020\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010$\"\u0004\bk\u0010&R\u0011\u0010l\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bm\u0010\u001f¨\u0006\u008a\u0001"}, d2 = {"Lcom/rigol/scope/views/histogram/HistogramRectView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "start", "", "end", "top", "bottom", "(Landroid/content/Context;FFFF)V", "aspect", "callback", "Lcom/rigol/scope/views/histogram/HistogramRectView$Callback;", "getCallback", "()Lcom/rigol/scope/views/histogram/HistogramRectView$Callback;", "setCallback", "(Lcom/rigol/scope/views/histogram/HistogramRectView$Callback;)V", "cornerLength", "cutArr", "", "getCutArr", "()[F", "distance", "getDistance", "()I", "setDistance", "(I)V", "downX", "getDownX", "()F", "setDownX", "(F)V", "downY", "getDownY", "setDownY", "dp1", "dp3", "isBottom", "", "()Z", "setBottom", "(Z)V", "isChangeSize", "setChangeSize", "isLeft", "setLeft", "isMove", "setMove", "isRight", "setRight", "isSlideBottom", "setSlideBottom", "isSlideLeft", "setSlideLeft", "isSlideRight", "setSlideRight", "isSlideTop", "setSlideTop", "isTop", "setTop", "lastDownTime", "", "getLastDownTime", "()J", "setLastDownTime", "(J)V", "lastDownX", "getLastDownX", "setLastDownX", "lastDownY", "getLastDownY", "setLastDownY", "paint", "Landroid/graphics/Paint;", "value", "realBottom", "getRealBottom", "setRealBottom", "realLeft", "getRealLeft", "setRealLeft", "realRight", "getRealRight", "setRealRight", "realTop", "getRealTop", "setRealTop", "rectBottom", "getRectBottom", "setRectBottom", "rectHeight", "getRectHeight", "rectLeft", "getRectLeft", "setRectLeft", "rectRight", "getRectRight", "setRectRight", "rectTop", "getRectTop", "setRectTop", "rectWidth", "getRectWidth", "drawLine", "", "canvas", "Landroid/graphics/Canvas;", "left", "right", "init", "initParams", "isClick", "lastX", "lastY", "thisX", "thisY", "thisEventTime", "longPressTime", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setAspect", "setRectPosition", "(Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Float;)V", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "Callback", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HistogramRectView extends View {
    public static final Companion Companion = new Companion(null);
    public static final int SCREEN_WAVE_HEIGHT = 480;
    public static final int SCREEN_WAVE_WIDTH = 1000;
    private float aspect;
    private Callback callback;
    private int cornerLength;
    private int distance;
    private float downX;
    private float downY;
    private int dp1;
    private int dp3;
    private boolean isBottom;
    private boolean isChangeSize;
    private boolean isLeft;
    private boolean isMove;
    private boolean isRight;
    private boolean isSlideBottom;
    private boolean isSlideLeft;
    private boolean isSlideRight;
    private boolean isSlideTop;
    private boolean isTop;
    private long lastDownTime;
    private float lastDownX;
    private float lastDownY;
    private Paint paint;
    private float realBottom;
    private float realLeft;
    private float realRight;
    private float realTop;
    private float rectBottom;
    private float rectLeft;
    private float rectRight;
    private float rectTop;

    /* compiled from: HistogramRectView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH&J\b\u0010\u0010\u001a\u00020\u0003H&¨\u0006\u0011"}, d2 = {"Lcom/rigol/scope/views/histogram/HistogramRectView$Callback;", "", "onClick", "", "onEnd", "rectLeft", "", "rectRight", "rectTop", "rectBottom", "onMove", "distanceX", "", "distanceY", "totalDistanceX", "totalDistanceY", "onStart", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public interface Callback {
        void onClick();

        void onEnd(float f, float f2, float f3, float f4);

        void onMove(int i, int i2, int i3, int i4);

        void onStart();
    }

    /* compiled from: HistogramRectView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/views/histogram/HistogramRectView$Companion;", "", "()V", "SCREEN_WAVE_HEIGHT", "", "SCREEN_WAVE_WIDTH", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final float getDownX() {
        return this.downX;
    }

    public final void setDownX(float f) {
        this.downX = f;
    }

    public final float getDownY() {
        return this.downY;
    }

    public final void setDownY(float f) {
        this.downY = f;
    }

    public final float getLastDownX() {
        return this.lastDownX;
    }

    public final void setLastDownX(float f) {
        this.lastDownX = f;
    }

    public final float getLastDownY() {
        return this.lastDownY;
    }

    public final void setLastDownY(float f) {
        this.lastDownY = f;
    }

    public final long getLastDownTime() {
        return this.lastDownTime;
    }

    public final void setLastDownTime(long j) {
        this.lastDownTime = j;
    }

    public final int getDistance() {
        return this.distance;
    }

    public final void setDistance(int i) {
        this.distance = i;
    }

    public final boolean isLeft() {
        return this.isLeft;
    }

    public final void setLeft(boolean z) {
        this.isLeft = z;
    }

    public final boolean isRight() {
        return this.isRight;
    }

    public final void setRight(boolean z) {
        this.isRight = z;
    }

    public final boolean isTop() {
        return this.isTop;
    }

    public final void setTop(boolean z) {
        this.isTop = z;
    }

    public final boolean isBottom() {
        return this.isBottom;
    }

    public final void setBottom(boolean z) {
        this.isBottom = z;
    }

    public final boolean isMove() {
        return this.isMove;
    }

    public final void setMove(boolean z) {
        this.isMove = z;
    }

    public final boolean isChangeSize() {
        return this.isChangeSize;
    }

    public final void setChangeSize(boolean z) {
        this.isChangeSize = z;
    }

    public final boolean isSlideLeft() {
        return this.isSlideLeft;
    }

    public final void setSlideLeft(boolean z) {
        this.isSlideLeft = z;
    }

    public final boolean isSlideRight() {
        return this.isSlideRight;
    }

    public final void setSlideRight(boolean z) {
        this.isSlideRight = z;
    }

    public final boolean isSlideTop() {
        return this.isSlideTop;
    }

    public final void setSlideTop(boolean z) {
        this.isSlideTop = z;
    }

    public final boolean isSlideBottom() {
        return this.isSlideBottom;
    }

    public final void setSlideBottom(boolean z) {
        this.isSlideBottom = z;
    }

    public final float getRectLeft() {
        return this.rectLeft;
    }

    public final void setRectLeft(float f) {
        this.rectLeft = f;
    }

    public final float getRectRight() {
        return this.rectRight;
    }

    public final void setRectRight(float f) {
        this.rectRight = f;
    }

    public final float getRectTop() {
        return this.rectTop;
    }

    public final void setRectTop(float f) {
        this.rectTop = f;
    }

    public final float getRectBottom() {
        return this.rectBottom;
    }

    public final void setRectBottom(float f) {
        this.rectBottom = f;
    }

    public final float getRealLeft() {
        return this.realLeft;
    }

    public final void setRealLeft(float f) {
        this.realLeft = f;
    }

    public final float getRealRight() {
        return this.realRight;
    }

    public final void setRealRight(float f) {
        this.realRight = f;
    }

    public final float getRealTop() {
        return this.realTop;
    }

    public final void setRealTop(float f) {
        this.realTop = f;
    }

    public final float getRealBottom() {
        return this.realBottom;
    }

    public final void setRealBottom(float f) {
        this.realBottom = f;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    public HistogramRectView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.distance = 40;
        this.aspect = -1.0f;
        init();
    }

    public HistogramRectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.distance = 40;
        this.aspect = -1.0f;
        init();
    }

    public HistogramRectView(Context context) {
        super(context);
        this.distance = 40;
        this.aspect = -1.0f;
        init();
    }

    public HistogramRectView(Context context, float f, float f2, float f3, float f4) {
        super(context);
        this.distance = 40;
        this.aspect = -1.0f;
        setRectPosition(Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4));
        init();
    }

    private final void init() {
        this.dp3 = (int) getResources().getDimension(R.dimen.module_spacing);
        this.dp1 = (int) getResources().getDimension(R.dimen.border_width);
        Paint paint = new Paint();
        this.paint = paint;
        Intrinsics.checkNotNull(paint);
        paint.setAntiAlias(true);
        Paint paint2 = this.paint;
        Intrinsics.checkNotNull(paint2);
        paint2.setColor(-1);
        Paint paint3 = this.paint;
        Intrinsics.checkNotNull(paint3);
        paint3.setStyle(Paint.Style.STROKE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0015, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent event) {
        Callback callback;
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 0) {
            this.downX = event.getX();
            this.downY = event.getY();
            this.lastDownX = event.getX();
            this.lastDownY = event.getY();
            this.lastDownTime = event.getEventTime();
            Timber.d("lastDownX:" + this.lastDownX, new Object[0]);
            float f = this.downX;
            float f2 = this.rectLeft;
            int i = this.distance;
            if (f >= f2 - i) {
                float f3 = this.rectRight;
                if (f <= i + f3) {
                    float f4 = this.downY;
                    if (f4 >= this.rectTop - i && f4 <= this.rectBottom + i) {
                        float f5 = 10;
                        int i2 = (int) ((f3 - f2) / f5);
                        if (f >= f2 - i && f <= f2 + i2) {
                            this.isLeft = true;
                        } else {
                            float f6 = this.downX;
                            float f7 = this.rectRight;
                            if (f6 <= this.distance + f7 && f6 >= f7 - i2) {
                                this.isRight = true;
                            }
                        }
                        float f8 = this.rectBottom;
                        float f9 = this.rectTop;
                        int i3 = (int) ((f8 - f9) / f5);
                        float f10 = this.downY;
                        if (f10 >= f9 - this.distance && f10 <= f9 + i3) {
                            this.isTop = true;
                        } else {
                            float f11 = this.downY;
                            float f12 = this.rectBottom;
                            if (f11 <= this.distance + f12 && f11 >= f12 - i3) {
                                this.isBottom = true;
                            }
                        }
                        if (!this.isLeft && !this.isTop && !this.isRight && !this.isBottom) {
                            this.isMove = true;
                        } else {
                            this.isChangeSize = true;
                        }
                        invalidate();
                        Callback callback2 = this.callback;
                        if (callback2 != null) {
                            callback2.onStart();
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            return super.onTouchEvent(event);
        }
        if (action != 1) {
            if (action == 2) {
                float x = event.getX();
                float y = event.getY();
                float f13 = x - this.downX;
                float f14 = y - this.downY;
                if (this.isMove) {
                    setRectLeft(this.rectLeft + f13);
                    setRectRight(this.rectRight + f13);
                    setRectTop(this.rectTop + f14);
                    setRectBottom(this.rectBottom + f14);
                    float f15 = 0;
                    if (this.rectLeft < f15 || this.rectRight > getMeasuredWidth()) {
                        setRectLeft(this.rectLeft - f13);
                        setRectRight(this.rectRight - f13);
                    }
                    if (this.rectTop < f15 || this.rectBottom > getMeasuredHeight()) {
                        setRectTop(this.rectTop - f14);
                        setRectBottom(this.rectBottom - f14);
                    }
                    invalidate();
                    this.downX = x;
                    this.downY = y;
                } else if (this.aspect != -1.0f) {
                    if (this.isLeft && (this.isTop || this.isBottom)) {
                        if (!this.isSlideLeft && !this.isSlideTop && !this.isSlideBottom) {
                            float abs = Math.abs(f13);
                            float abs2 = Math.abs(f14);
                            if (abs > abs2 && abs > 10) {
                                this.isSlideLeft = true;
                            } else if (abs < abs2 && abs2 > 10) {
                                if (this.isTop) {
                                    this.isSlideTop = true;
                                } else {
                                    this.isSlideBottom = true;
                                }
                            }
                        }
                    } else if (this.isRight && (this.isTop || this.isBottom)) {
                        if (!this.isSlideRight && !this.isSlideTop && !this.isSlideBottom) {
                            float abs3 = Math.abs(f13);
                            float abs4 = Math.abs(f14);
                            if (abs3 > abs4 && abs3 > 10) {
                                this.isSlideRight = true;
                            } else if (abs3 < abs4 && abs4 > 10) {
                                if (this.isTop) {
                                    this.isSlideTop = true;
                                } else {
                                    this.isSlideBottom = true;
                                }
                            }
                        }
                    } else if (this.isLeft && !this.isSlideLeft) {
                        this.isSlideLeft = true;
                    } else if (this.isRight && !this.isSlideLeft) {
                        this.isSlideRight = true;
                    } else if (this.isTop && !this.isSlideTop) {
                        this.isSlideTop = true;
                    } else if (this.isBottom && !this.isSlideBottom) {
                        this.isSlideBottom = true;
                    }
                    if (this.isSlideLeft) {
                        setRectLeft(this.rectLeft + f13);
                        float f16 = 0;
                        if (this.rectLeft < f16) {
                            setRectLeft(0.0f);
                        }
                        float f17 = this.rectRight;
                        float f18 = f17 - this.rectLeft;
                        int i4 = this.cornerLength;
                        if (f18 < i4 * 2) {
                            f18 = i4 * 2;
                            setRectLeft(f17 - f18);
                        }
                        float f19 = this.aspect;
                        float f20 = f18 / f19;
                        int i5 = this.cornerLength;
                        if (f20 < i5 * 2) {
                            f20 = i5 * 2;
                            setRectLeft(this.rectRight - (f19 * f20));
                        }
                        if (this.isTop) {
                            setRectBottom(this.rectTop + f20);
                        } else if (this.isBottom) {
                            setRectTop(this.rectBottom - f20);
                        } else {
                            float f21 = this.rectBottom;
                            float f22 = this.rectTop;
                            float f23 = ((f21 - f22) - f20) / 2;
                            setRectTop(f22 + f23);
                            setRectBottom(this.rectBottom - f23);
                        }
                        if (this.rectTop < f16) {
                            setRectTop(0.0f);
                            setRectBottom(f20);
                            if (this.rectBottom > getMeasuredHeight()) {
                                setRectBottom(getMeasuredHeight());
                            }
                            setRectLeft(this.rectRight - (this.rectBottom * this.aspect));
                        } else if (this.rectBottom > getMeasuredHeight()) {
                            setRectBottom(getMeasuredHeight());
                            setRectTop(getMeasuredHeight() - f20);
                            if (this.rectTop < f16) {
                                setRectTop(0.0f);
                            }
                            setRectLeft(this.rectRight - ((this.rectBottom - this.rectTop) * this.aspect));
                        }
                        invalidate();
                        this.downX = x;
                        this.downY = y;
                    } else if (this.isSlideRight) {
                        setRectRight(this.rectRight + f13);
                        if (this.rectRight > getMeasuredWidth()) {
                            setRectRight(getMeasuredWidth());
                        }
                        float f24 = this.rectRight;
                        float f25 = this.rectLeft;
                        float f26 = f24 - f25;
                        int i6 = this.cornerLength;
                        if (f26 < i6 * 2) {
                            f26 = i6 * 2;
                            setRectRight(f25 + f26);
                        }
                        float f27 = this.aspect;
                        float f28 = f26 / f27;
                        int i7 = this.cornerLength;
                        if (f28 < i7 * 2) {
                            f28 = i7 * 2;
                            setRectRight(this.rectLeft + (f27 * f28));
                        }
                        if (this.isTop) {
                            setRectBottom(this.rectTop + f28);
                        } else if (this.isBottom) {
                            setRectTop(this.rectBottom - f28);
                        } else {
                            float f29 = this.rectBottom;
                            float f30 = this.rectTop;
                            float f31 = ((f29 - f30) - f28) / 2;
                            setRectTop(f30 + f31);
                            setRectBottom(this.rectBottom - f31);
                        }
                        float f32 = 0;
                        if (this.rectTop < f32) {
                            setRectTop(0.0f);
                            setRectBottom(f28);
                            if (this.rectBottom > getMeasuredHeight()) {
                                setRectBottom(getMeasuredHeight());
                            }
                            setRectRight(this.rectLeft + (this.rectBottom * this.aspect));
                        } else if (this.rectBottom > getMeasuredHeight()) {
                            setRectBottom(getMeasuredHeight());
                            setRectTop(getMeasuredHeight() - f28);
                            if (this.rectTop < f32) {
                                setRectTop(0.0f);
                            }
                            setRectRight(this.rectLeft + ((this.rectBottom - this.rectTop) * this.aspect));
                        }
                        invalidate();
                        this.downX = x;
                        this.downY = y;
                    } else if (this.isSlideTop) {
                        setRectTop(this.rectTop + f14);
                        float f33 = 0;
                        if (this.rectTop < f33) {
                            setRectTop(0.0f);
                        }
                        float f34 = this.rectBottom;
                        float f35 = f34 - this.rectTop;
                        int i8 = this.cornerLength;
                        if (f35 < i8 * 2) {
                            f35 = i8 * 2;
                            setRectTop(f34 - f35);
                        }
                        float f36 = this.aspect;
                        float f37 = f35 * f36;
                        int i9 = this.cornerLength;
                        if (f37 < i9 * 2) {
                            f37 = i9 * 2;
                            setRectTop(this.rectBottom - (f37 / f36));
                        }
                        if (this.isLeft) {
                            setRectRight(this.rectLeft + f37);
                        } else if (this.isRight) {
                            setRectLeft(this.rectRight - f37);
                        } else {
                            float f38 = this.rectRight;
                            float f39 = this.rectLeft;
                            float f40 = ((f38 - f39) - f37) / 2;
                            setRectLeft(f39 + f40);
                            setRectRight(this.rectRight - f40);
                        }
                        if (this.rectLeft < f33) {
                            setRectLeft(0.0f);
                            setRectRight(f37);
                            if (this.rectRight > getMeasuredWidth()) {
                                setRectRight(getMeasuredWidth());
                            }
                            setRectTop(this.rectBottom - (this.rectRight / this.aspect));
                        } else if (this.rectRight > getMeasuredWidth()) {
                            setRectRight(getMeasuredWidth());
                            setRectLeft(getMeasuredWidth() - f37);
                            if (this.rectLeft < f33) {
                                setRectLeft(0.0f);
                                f37 = getMeasuredWidth();
                            }
                            setRectTop(this.rectBottom - (f37 / this.aspect));
                        }
                        invalidate();
                        this.downX = x;
                        this.downY = y;
                    } else if (this.isSlideBottom) {
                        setRectBottom(this.rectBottom + f14);
                        if (this.rectBottom > getMeasuredHeight()) {
                            setRectBottom(getMeasuredHeight());
                        }
                        float f41 = this.rectBottom;
                        float f42 = this.rectTop;
                        float f43 = f41 - f42;
                        int i10 = this.cornerLength;
                        if (f43 < i10 * 2) {
                            f43 = i10 * 2;
                            setRectBottom(f42 + f43);
                        }
                        float f44 = this.aspect;
                        float f45 = f43 * f44;
                        int i11 = this.cornerLength;
                        if (f45 < i11 * 2) {
                            f45 = i11 * 2;
                            setRectBottom(this.rectTop + (f45 / f44));
                        }
                        if (this.isLeft) {
                            setRectRight(this.rectLeft + f45);
                        } else if (this.isRight) {
                            setRectLeft(this.rectRight - f45);
                        } else {
                            float f46 = this.rectRight;
                            float f47 = this.rectLeft;
                            float f48 = ((f46 - f47) - f45) / 2;
                            setRectLeft(f47 + f48);
                            setRectRight(this.rectRight - f48);
                        }
                        float f49 = 0;
                        if (this.rectLeft < f49) {
                            setRectLeft(0.0f);
                            setRectRight(f45);
                            if (this.rectRight > getMeasuredWidth()) {
                                setRectRight(getMeasuredWidth());
                            }
                            setRectBottom(this.rectTop + (this.rectRight / this.aspect));
                        } else if (this.rectRight > getMeasuredWidth()) {
                            setRectRight(getMeasuredWidth());
                            setRectLeft(getMeasuredWidth() - f45);
                            if (this.rectLeft < f49) {
                                setRectLeft(0.0f);
                                f45 = getMeasuredWidth();
                            }
                            setRectBottom(this.rectTop + (f45 / this.aspect));
                        }
                        invalidate();
                        this.downX = x;
                        this.downY = y;
                    }
                } else {
                    if (this.isLeft) {
                        setRectLeft(this.rectLeft + f13);
                        if (this.rectLeft < 0) {
                            setRectLeft(0.0f);
                        }
                        float f50 = this.rectLeft;
                        float f51 = this.rectRight;
                        int i12 = this.cornerLength;
                        if (f50 > f51 - (i12 * 2)) {
                            setRectLeft(f51 - (i12 * 2));
                        }
                    } else if (this.isRight) {
                        Timber.d("Rect:" + f13, new Object[0]);
                        setRectRight(this.rectRight + f13);
                        Timber.d("Rect:" + this.rectRight, new Object[0]);
                        if (this.rectRight > getMeasuredWidth()) {
                            setRectRight(getMeasuredWidth());
                        }
                        float f52 = this.rectRight;
                        float f53 = this.rectLeft;
                        int i13 = this.cornerLength;
                        if (f52 < (i13 * 2) + f53) {
                            setRectRight(f53 + (i13 * 2));
                        }
                        Timber.d("Rect:" + this.rectRight, new Object[0]);
                    }
                    if (this.isTop) {
                        setRectTop(this.rectTop + f14);
                        if (this.rectTop < 0) {
                            setRectTop(0.0f);
                        }
                        float f54 = this.rectTop;
                        float f55 = this.rectBottom;
                        int i14 = this.cornerLength;
                        if (f54 > f55 - (i14 * 2)) {
                            setRectTop(f55 - (i14 * 2));
                        }
                    } else if (this.isBottom) {
                        setRectBottom(this.rectBottom + f14);
                        if (this.rectBottom > getMeasuredHeight()) {
                            setRectBottom(getMeasuredHeight());
                        }
                        float f56 = this.rectBottom;
                        float f57 = this.rectTop;
                        int i15 = this.cornerLength;
                        if (f56 < (i15 * 2) + f57) {
                            setRectBottom(f57 + (i15 * 2));
                        }
                    }
                    invalidate();
                    this.downX = x;
                    this.downY = y;
                }
            }
        }
        this.isLeft = false;
        this.isRight = false;
        this.isTop = false;
        this.isBottom = false;
        this.isMove = false;
        this.isChangeSize = false;
        this.isSlideLeft = false;
        this.isSlideRight = false;
        this.isSlideTop = false;
        this.isSlideBottom = false;
        float f58 = this.rectRight;
        if (f58 < 1200) {
            Callback callback3 = this.callback;
            if (callback3 != null) {
                callback3.onEnd(this.rectLeft, f58, this.rectTop, this.rectBottom);
                Unit unit2 = Unit.INSTANCE;
            }
            if (isClick(this.lastDownX, this.lastDownY, event.getX(), event.getY(), this.lastDownTime, event.getEventTime(), 100L) && (callback = this.callback) != null) {
                callback.onClick();
                Unit unit3 = Unit.INSTANCE;
            }
        }
        return true;
    }

    public final boolean isClick(float f, float f2, float f3, float f4, long j, long j2, long j3) {
        float abs = Math.abs(f3 - f);
        float f5 = 20;
        return abs <= f5 && Math.abs(f4 - f2) <= f5 && j2 - j <= j3;
    }

    public final float[] getCutArr() {
        return new float[]{this.rectLeft, this.rectTop, this.rectRight, this.rectBottom};
    }

    public final int getRectWidth() {
        return getMeasuredWidth();
    }

    public final int getRectHeight() {
        return getMeasuredHeight();
    }

    public final void setAspect(float f) {
        this.aspect = f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        initParams();
    }

    private final void initParams() {
        int measuredHeight;
        if (this.aspect == -1.0f) {
            this.cornerLength = getMeasuredWidth() / 100;
            setRectRight(getMeasuredWidth() * this.realRight);
            setRectLeft(getMeasuredWidth() * this.realLeft);
            setRectTop(getMeasuredHeight() * this.realTop);
            setRectBottom(getMeasuredHeight() * this.realBottom);
            return;
        }
        float measuredWidth = (getMeasuredWidth() * 1.0f) / getMeasuredHeight();
        if (this.aspect > 1) {
            measuredHeight = getMeasuredWidth() / 100;
        } else {
            measuredHeight = getMeasuredHeight() / 100;
        }
        this.cornerLength = measuredHeight;
        if (this.aspect > measuredWidth) {
            setRectLeft(0.0f);
            setRectRight(getMeasuredWidth());
            float measuredWidth2 = getMeasuredWidth() / this.aspect;
            setRectTop((getMeasuredHeight() - measuredWidth2) / 2);
            setRectBottom(this.rectTop + measuredWidth2);
            return;
        }
        setRectTop(0.0f);
        setRectBottom(getMeasuredHeight());
        float measuredHeight2 = getMeasuredHeight() * this.aspect;
        setRectLeft((getMeasuredWidth() - measuredHeight2) / 2);
        setRectRight(this.rectLeft + measuredHeight2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Paint paint = this.paint;
        Intrinsics.checkNotNull(paint);
        paint.setStrokeWidth(this.dp1);
        if (this.rectLeft < 0) {
            initParams();
        }
        float f = this.rectLeft;
        float f2 = this.rectTop;
        float f3 = this.rectRight;
        float f4 = this.rectBottom;
        Paint paint2 = this.paint;
        Intrinsics.checkNotNull(paint2);
        canvas.drawRect(f, f2, f3, f4, paint2);
        if (this.isChangeSize) {
            drawLine(canvas, this.rectLeft, this.rectTop, this.rectRight, this.rectBottom);
        }
    }

    private final void drawLine(Canvas canvas, float f, float f2, float f3, float f4) {
        Paint paint = this.paint;
        Intrinsics.checkNotNull(paint);
        paint.setStrokeWidth(1.0f);
        Paint paint2 = this.paint;
        Intrinsics.checkNotNull(paint2);
        paint2.setStrokeWidth(this.dp3);
        Paint paint3 = this.paint;
        Intrinsics.checkNotNull(paint3);
        canvas.drawLine(f - (this.dp3 / 2), f2, f + this.cornerLength, f2, paint3);
        Paint paint4 = this.paint;
        Intrinsics.checkNotNull(paint4);
        canvas.drawLine(f, f2, f, f2 + this.cornerLength, paint4);
        Paint paint5 = this.paint;
        Intrinsics.checkNotNull(paint5);
        canvas.drawLine(f3 + (this.dp3 / 2), f2, f3 - this.cornerLength, f2, paint5);
        Paint paint6 = this.paint;
        Intrinsics.checkNotNull(paint6);
        canvas.drawLine(f3, f2, f3, f2 + this.cornerLength, paint6);
        Paint paint7 = this.paint;
        Intrinsics.checkNotNull(paint7);
        canvas.drawLine(f, f4, f, f4 - this.cornerLength, paint7);
        Paint paint8 = this.paint;
        Intrinsics.checkNotNull(paint8);
        canvas.drawLine(f - (this.dp3 / 2), f4, f + this.cornerLength, f4, paint8);
        Paint paint9 = this.paint;
        Intrinsics.checkNotNull(paint9);
        canvas.drawLine(f3 + (this.dp3 / 2), f4, f3 - this.cornerLength, f4, paint9);
        Paint paint10 = this.paint;
        Intrinsics.checkNotNull(paint10);
        canvas.drawLine(f3, f4, f3, f4 - this.cornerLength, paint10);
    }

    private final void setRectPosition(Float f, Float f2, Float f3, Float f4) {
        setRectLeft(f != null ? f.floatValue() : 0.0f);
        setRectRight(f2 != null ? f2.floatValue() : 0.0f);
        setRectTop(f3 != null ? f3.floatValue() : 0.0f);
        setRectBottom(f4 != null ? f4.floatValue() : 0.0f);
        invalidate();
    }

    public final void setRectPosition(Integer num, Integer num2, Integer num3, Integer num4) {
        float f = 1000;
        setRealLeft((num != null ? num.intValue() : 0) / f);
        setRealRight((num2 != null ? num2.intValue() : 0) / f);
        float f2 = 480;
        setRealTop((num3 != null ? num3.intValue() : 0) / f2);
        setRealBottom((num4 != null ? num4.intValue() : 0) / f2);
        initParams();
        invalidate();
    }
}
