package com.rigol.scope.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.OrientationView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: TagView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0014\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 ª\u00012\u00020\u0001:\u0004©\u0001ª\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010h\u001a\u00020iH\u0002J\b\u0010j\u001a\u000207H\u0002J\u000e\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u000207J\u0018\u0010n\u001a\u00020i2\u0006\u0010o\u001a\u0002072\u0006\u0010p\u001a\u00020qH\u0002J0\u0010r\u001a\u00020i2\u0006\u0010p\u001a\u00020q2\u0006\u0010s\u001a\u0002072\u0006\u0010t\u001a\u0002072\u0006\u0010u\u001a\u0002072\u0006\u0010v\u001a\u000207H\u0002J1\u0010w\u001a\u00020i2\u0006\u0010p\u001a\u00020q2\u0006\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020\u00142\f\u0010z\u001a\b\u0012\u0004\u0012\u00020|0{¢\u0006\u0002\u0010}J \u0010~\u001a\u00020i2\u0006\u0010o\u001a\u0002072\u0006\u0010\u007f\u001a\u0002072\u0006\u0010p\u001a\u00020qH\u0002J1\u0010\u0080\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020q2\u0006\u0010s\u001a\u0002072\u0006\u0010t\u001a\u0002072\u0006\u0010u\u001a\u0002072\u0006\u0010v\u001a\u000207H\u0003J\u0019\u0010\u0081\u0001\u001a\u00020i2\u0006\u0010\u007f\u001a\u0002072\u0006\u0010p\u001a\u00020qH\u0002J\u0012\u0010\u0082\u0001\u001a\u00020i2\u0007\u0010\u0083\u0001\u001a\u000207H\u0002J\u001b\u0010\u0084\u0001\u001a\u00020\b2\u0007\u0010\u0085\u0001\u001a\u0002072\u0007\u0010\u0086\u0001\u001a\u000207H\u0002J\u0007\u0010\u0087\u0001\u001a\u00020iJ-\u0010\u0088\u0001\u001a\u00020i2\u0007\u0010\u0089\u0001\u001a\u0002072\u0007\u0010\u008a\u0001\u001a\u0002072\u0007\u0010\u008b\u0001\u001a\u0002072\u0007\u0010\u008c\u0001\u001a\u000207H\u0016J\u0011\u0010\u008d\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020qH\u0014J-\u0010\u008e\u0001\u001a\u00020i2\u0007\u0010\u008f\u0001\u001a\u0002072\u0007\u0010\u0090\u0001\u001a\u0002072\u0007\u0010\u0091\u0001\u001a\u0002072\u0007\u0010\u0092\u0001\u001a\u000207H\u0014J\u0013\u0010\u0093\u0001\u001a\u00020\b2\b\u0010\u0094\u0001\u001a\u00030\u0095\u0001H\u0016J\u0010\u0010\u0096\u0001\u001a\u00020i2\u0007\u0010\u0097\u0001\u001a\u000207J\u0010\u0010\u0098\u0001\u001a\u00020i2\u0007\u0010\u0099\u0001\u001a\u000207J\u0010\u0010\u009a\u0001\u001a\u00020i2\u0007\u0010\u009b\u0001\u001a\u000207J\u0010\u0010\u009c\u0001\u001a\u00020i2\u0007\u0010\u0097\u0001\u001a\u000207J\u0013\u0010\u009d\u0001\u001a\u00020i2\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001J\u0010\u0010 \u0001\u001a\u00020i2\u0007\u0010¡\u0001\u001a\u000207J\u0010\u0010¢\u0001\u001a\u00020i2\u0007\u0010£\u0001\u001a\u000207J\u000f\u0010¤\u0001\u001a\u00020l2\u0006\u0010m\u001a\u000207JA\u0010¥\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020q2\u0006\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020\u00142\u0006\u0010s\u001a\u0002072\u0006\u0010t\u001a\u0002072\u0006\u0010^\u001a\u0002072\u0006\u0010Z\u001a\u000207H\u0002JA\u0010¦\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020q2\u0006\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020\u00142\u0006\u0010s\u001a\u0002072\u0006\u0010t\u001a\u0002072\u0006\u0010^\u001a\u0002072\u0006\u0010Z\u001a\u000207H\u0002JA\u0010§\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020q2\u0006\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020\u00142\u0006\u0010s\u001a\u0002072\u0006\u0010t\u001a\u0002072\u0006\u0010^\u001a\u0002072\u0006\u0010Z\u001a\u000207H\u0002JA\u0010¨\u0001\u001a\u00020i2\u0006\u0010p\u001a\u00020q2\u0006\u0010x\u001a\u00020:2\u0006\u0010y\u001a\u00020\u00142\u0006\u0010s\u001a\u0002072\u0006\u0010t\u001a\u0002072\u0006\u0010^\u001a\u0002072\u0006\u0010Z\u001a\u000207H\u0002R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010!\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\fR\u000e\u0010$\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\n\"\u0004\b'\u0010\fR\u001c\u0010(\u001a\u0004\u0018\u00010)X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\n\"\u0004\b/\u0010\fR\u001a\u00100\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\n\"\u0004\b1\u0010\fR\u001c\u00102\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001e\"\u0004\b4\u0010 R\u000e\u00105\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00109\u001a\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010@\u001a\u0002072\u0006\u0010?\u001a\u000207@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020IX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\n\"\u0004\bL\u0010\fR\u001a\u0010M\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\n\"\u0004\bO\u0010\fR\u001a\u0010P\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\n\"\u0004\bR\u0010\fR\u001a\u0010S\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\n\"\u0004\bU\u0010\fR\u0013\u0010V\u001a\u0004\u0018\u00010W¢\u0006\b\n\u0000\u001a\u0004\bX\u0010YR\u001a\u0010Z\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010B\"\u0004\b\\\u0010DR\u000e\u0010]\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010^\u001a\u000207X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010B\"\u0004\b`\u0010DR\u001c\u0010a\u001a\u0004\u0018\u00010\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u001e\"\u0004\bc\u0010 R\u000e\u0010d\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010g\u001a\u000207X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006«\u0001"}, d2 = {"Lcom/rigol/scope/views/TagView;", "Lcom/rigol/scope/views/baseview/OrientationView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "beyond", "", "getBeyond", "()Z", "setBeyond", "(Z)V", "bitmapKeyA", "Landroid/graphics/Bitmap;", "getBitmapKeyA", "()Landroid/graphics/Bitmap;", "bitmapKeyB", "getBitmapKeyB", "borderPaint", "Landroid/graphics/Paint;", "callback", "Lcom/rigol/scope/views/TagView$Callback;", "getCallback", "()Lcom/rigol/scope/views/TagView$Callback;", "setCallback", "(Lcom/rigol/scope/views/TagView$Callback;)V", "cousor_label", "", "getCousor_label", "()Ljava/lang/String;", "setCousor_label", "(Ljava/lang/String;)V", "cousor_showLabel_now", "getCousor_showLabel_now", "setCousor_showLabel_now", "cursor_labelPaint", "draggable", "getDraggable", "setDraggable", "horizontal", "Lcom/rigol/scope/data/HorizontalParam;", "getHorizontal", "()Lcom/rigol/scope/data/HorizontalParam;", "setHorizontal", "(Lcom/rigol/scope/data/HorizontalParam;)V", "isDragging", "setDragging", "isShowHint", "setShowHint", "label", "getLabel", "setLabel", "labelPaint", "mPreviousX", "", "mPreviousY", "path_six", "Landroid/graphics/Path;", "getPath_six", "()Landroid/graphics/Path;", "setPath_six", "(Landroid/graphics/Path;)V", "value", "position", "getPosition", "()I", "setPosition", "(I)V", "positionEdgeWithTag", "", "positionEdgeWithView", "rect", "Landroid/graphics/Rect;", "reverse", "getReverse", "setReverse", "showBor", "getShowBor", "setShowBor", "showBorder", "getShowBorder", "setShowBorder", "showLabel", "getShowLabel", "setShowLabel", "syncDataView", "Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "getSyncDataView", "()Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "tagHeight", "getTagHeight", "setTagHeight", "tagPaint", "tagWidth", "getTagWidth", "setTagWidth", "text", "getText", "setText", "textPaint", "text_tag_Paint", "totalDeltaX", "totalDeltaY", "calAndSetPosition", "", "calculateOffset", "cos", "", "mun", "drawHorizontalTag", "halfHeight", "canvas", "Landroid/graphics/Canvas;", "drawLabel", "startX", "startY", "drawWidth", "drawHeight", "drawPolygon", "path", "paint", "points", "", "", "(Landroid/graphics/Canvas;Landroid/graphics/Path;Landroid/graphics/Paint;[[F)V", "drawTag", "halfWidth", "drawText", "drawVerticalTag", "handleMoveEvent", "moveDistance", "inDraggingArea", "x", "y", "initPositionEdge", "layout", "l", "t", "r", ViewUtil.KEY_B, "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setBorderColor", "color", "setLabelColor", "labelColor", "setLabelSize", "labelSize", "setTagColor", "setTagStyle", "style", "Landroid/graphics/Paint$Style;", "setTextColor", "textColor", "setTextSize", "textSize", "sin", "turnDown", "turnLeft", "turnRight", "turnUp", "Callback", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class TagView extends OrientationView {
    public static final Companion Companion = new Companion(null);
    public static final PathEffect DEFAULT_DASH_PATH_EFFECT = new DashPathEffect(new float[]{10.0f, 3.0f, 1.0f, 3.0f}, 0);
    private static final float DEFAULT_LABEL_TEXT_SIZE = 18.0f;
    private static final float DEFAULT_TAG_STROKE_WIDTH = 2.0f;
    private static final float DEFAULT_TEXT_SIZE = 16.0f;
    private static final int ERROR_RANG_OF_MOVING_DISTANCE = 5;
    private boolean beyond;
    private final Bitmap bitmapKeyA;
    private final Bitmap bitmapKeyB;
    private final Paint borderPaint;
    private Callback callback;
    private String cousor_label;
    private boolean cousor_showLabel_now;
    private final Paint cursor_labelPaint;
    private boolean draggable;
    private HorizontalParam horizontal;
    private boolean isDragging;
    private boolean isShowHint;
    private String label;
    private final Paint labelPaint;
    private int mPreviousX;
    private int mPreviousY;
    private Path path_six;
    private int position;
    private final int[] positionEdgeWithTag;
    private final int[] positionEdgeWithView;
    private final Rect rect;
    private boolean reverse;
    private boolean showBor;
    private boolean showBorder;
    private boolean showLabel;
    private final SyncDataViewModel syncDataView;
    private int tagHeight;
    private final Paint tagPaint;
    private int tagWidth;
    private String text;
    private final Paint textPaint;
    private final Paint text_tag_Paint;
    private int totalDeltaX;
    private int totalDeltaY;

    /* compiled from: TagView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J(\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Lcom/rigol/scope/views/TagView$Callback;", "", "onEnd", "", "onMove", "distanceX", "", "distanceY", "totalDistanceX", "totalDistanceY", "onStart", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public interface Callback {
        void onEnd();

        void onMove(int i, int i2, int i3, int i4);

        void onStart();
    }

    public TagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MutableLiveData<Object> mutableLiveData;
        Intrinsics.checkNotNull(context);
        Bitmap DrawableToBitmap = ContextUtil.DrawableToBitmap(ContextCompat.getDrawable(context, R.drawable.ic_bg_key_1));
        Intrinsics.checkNotNullExpressionValue(DrawableToBitmap, "ContextUtil.DrawableToBi… R.drawable.ic_bg_key_1))");
        this.bitmapKeyA = DrawableToBitmap;
        Bitmap DrawableToBitmap2 = ContextUtil.DrawableToBitmap(ContextCompat.getDrawable(context, R.drawable.ic_bg_key_2));
        Intrinsics.checkNotNullExpressionValue(DrawableToBitmap2, "ContextUtil.DrawableToBi… R.drawable.ic_bg_key_2))");
        this.bitmapKeyB = DrawableToBitmap2;
        this.isShowHint = true;
        this.draggable = true;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2.0f);
        paint.setColor(ViewCompat.MEASURED_STATE_MASK);
        Unit unit = Unit.INSTANCE;
        this.borderPaint = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(2.0f);
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        Unit unit2 = Unit.INSTANCE;
        this.tagPaint = paint2;
        Paint paint3 = new Paint(1);
        paint3.setStyle(Paint.Style.FILL);
        paint3.setTextSize(16.0f);
        paint3.setStrokeWidth(2.0f);
        paint3.setTextAlign(Paint.Align.CENTER);
        paint3.setColor(-1);
        Unit unit3 = Unit.INSTANCE;
        this.textPaint = paint3;
        Paint paint4 = new Paint(1);
        paint4.setStyle(Paint.Style.FILL);
        paint4.setTextSize(13.0f);
        paint4.setStrokeWidth(2.0f);
        paint4.setTextAlign(Paint.Align.CENTER);
        paint4.setColor(ViewCompat.MEASURED_STATE_MASK);
        Unit unit4 = Unit.INSTANCE;
        this.text_tag_Paint = paint4;
        Paint paint5 = new Paint(1);
        paint5.setStyle(Paint.Style.FILL);
        paint5.setStrokeWidth(2.0f);
        paint5.setTextSize(DEFAULT_LABEL_TEXT_SIZE);
        paint5.setColor(-1);
        paint5.setShadowLayer(1.0f, 1.0f, 1.0f, ViewCompat.MEASURED_STATE_MASK);
        Unit unit5 = Unit.INSTANCE;
        this.labelPaint = paint5;
        Paint paint6 = new Paint(1);
        paint6.setStyle(Paint.Style.FILL);
        paint6.setColor(ContextCompat.getColor(context, R.color.tag_color));
        paint6.setStrokeWidth(5.0f);
        Unit unit6 = Unit.INSTANCE;
        this.cursor_labelPaint = paint6;
        this.positionEdgeWithView = new int[]{0, 0, 0, 0};
        this.positionEdgeWithTag = new int[]{0, 0, 0, 0};
        this.rect = new Rect();
        this.path_six = new Path();
        this.syncDataView = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.horizontal = ((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue();
        SyncDataViewModel syncDataViewModel = this.syncDataView;
        if (syncDataViewModel == null || (mutableLiveData = syncDataViewModel.get(10, MessageID.MSG_ACQ_MODE)) == null) {
            return;
        }
        mutableLiveData.observe((LifecycleOwner) context, new Observer<Object>() { // from class: com.rigol.scope.views.TagView.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TagView.this.invalidate();
            }
        });
    }

    public final Bitmap getBitmapKeyA() {
        return this.bitmapKeyA;
    }

    public final Bitmap getBitmapKeyB() {
        return this.bitmapKeyB;
    }

    public final int getTagWidth() {
        return this.tagWidth;
    }

    public final void setTagWidth(int i) {
        this.tagWidth = i;
    }

    public final int getTagHeight() {
        return this.tagHeight;
    }

    public final void setTagHeight(int i) {
        this.tagHeight = i;
    }

    @Override // com.rigol.scope.views.baseview.OrientationView
    public int getPosition() {
        return this.position;
    }

    @Override // com.rigol.scope.views.baseview.OrientationView
    public void setPosition(int i) {
        this.position = i;
        if (getWidth() == 0 && getHeight() == 0) {
            post(new Runnable() { // from class: com.rigol.scope.views.TagView$position$1
                @Override // java.lang.Runnable
                public final void run() {
                    TagView.this.calAndSetPosition();
                }
            });
        } else {
            calAndSetPosition();
        }
    }

    public final String getText() {
        return this.text;
    }

    public final void setText(String str) {
        this.text = str;
    }

    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        this.label = str;
    }

    public final String getCousor_label() {
        return this.cousor_label;
    }

    public final void setCousor_label(String str) {
        this.cousor_label = str;
    }

    public final boolean isShowHint() {
        return this.isShowHint;
    }

    public final void setShowHint(boolean z) {
        this.isShowHint = z;
    }

    public final boolean getCousor_showLabel_now() {
        return this.cousor_showLabel_now;
    }

    public final void setCousor_showLabel_now(boolean z) {
        this.cousor_showLabel_now = z;
    }

    public final boolean getShowLabel() {
        return this.showLabel;
    }

    public final void setShowLabel(boolean z) {
        this.showLabel = z;
    }

    public final boolean getDraggable() {
        return this.draggable;
    }

    public final void setDraggable(boolean z) {
        this.draggable = z;
    }

    public final boolean isDragging() {
        return this.isDragging;
    }

    public final void setDragging(boolean z) {
        this.isDragging = z;
    }

    public final boolean getReverse() {
        return this.reverse;
    }

    public final void setReverse(boolean z) {
        this.reverse = z;
    }

    public final boolean getBeyond() {
        return this.beyond;
    }

    public final void setBeyond(boolean z) {
        this.beyond = z;
    }

    public final boolean getShowBorder() {
        return this.showBorder;
    }

    public final void setShowBorder(boolean z) {
        this.showBorder = z;
    }

    public final boolean getShowBor() {
        return this.showBor;
    }

    public final void setShowBor(boolean z) {
        this.showBor = z;
    }

    public final Callback getCallback() {
        return this.callback;
    }

    public final void setCallback(Callback callback) {
        this.callback = callback;
    }

    public final Path getPath_six() {
        return this.path_six;
    }

    public final void setPath_six(Path path) {
        Intrinsics.checkNotNullParameter(path, "<set-?>");
        this.path_six = path;
    }

    public final float sin(int i) {
        return (float) Math.sin((i * 3.141592653589793d) / 180);
    }

    public final float cos(int i) {
        return (float) Math.cos((i * 3.141592653589793d) / 180);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void calAndSetPosition() {
        int calculateOffset = calculateOffset();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            if (getOrientation() == 0) {
                ((ConstraintLayout.LayoutParams) layoutParams).topMargin = calculateOffset;
            } else {
                ((ConstraintLayout.LayoutParams) layoutParams).startMargin = calculateOffset;
            }
        }
        setLayoutParams(layoutParams);
    }

    private final int calculateOffset() {
        int width;
        int position;
        int height;
        int position2;
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            parent = null;
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        if (viewGroup != null) {
            if (getOrientation() == 0) {
                if (getHeight() == 0) {
                    measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                    height = getMeasuredHeight();
                } else {
                    height = getHeight();
                }
                int i = height >> 1;
                if (getPosition() < this.positionEdgeWithView[1]) {
                    return -i;
                }
                if (getPosition() > this.positionEdgeWithView[3]) {
                    position2 = viewGroup.getHeight();
                } else {
                    position2 = getPosition();
                }
                return position2 - i;
            }
            if (getWidth() == 0) {
                measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
                width = getMeasuredWidth();
            } else {
                width = getWidth();
            }
            int i2 = width >> 1;
            if (getPosition() < this.positionEdgeWithView[0]) {
                return -i2;
            }
            if (getPosition() > this.positionEdgeWithView[2]) {
                position = viewGroup.getWidth();
            } else {
                position = getPosition();
            }
            return position - i2;
        }
        return 0;
    }

    public final void initPositionEdge() {
        if (getParent() instanceof ViewGroup) {
            int i = this.tagHeight >> 1;
            int i2 = this.tagWidth >> 1;
            int[] iArr = this.positionEdgeWithView;
            iArr[0] = 0;
            iArr[1] = 0;
            ViewParent parent = getParent();
            if (parent == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            iArr[2] = ((ViewGroup) parent).getWidth();
            int[] iArr2 = this.positionEdgeWithView;
            ViewParent parent2 = getParent();
            if (parent2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            iArr2[3] = ((ViewGroup) parent2).getHeight();
            this.positionEdgeWithTag[0] = this.beyond ? 0 : i2;
            this.positionEdgeWithTag[1] = this.beyond ? 0 : i;
            int[] iArr3 = this.positionEdgeWithTag;
            ViewParent parent3 = getParent();
            if (parent3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            int width = ((ViewGroup) parent3).getWidth();
            if (this.beyond) {
                i2 = 0;
            }
            iArr3[2] = width - i2;
            int[] iArr4 = this.positionEdgeWithTag;
            ViewParent parent4 = getParent();
            if (parent4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
            }
            int height = ((ViewGroup) parent4).getHeight();
            if (this.beyond) {
                i = 0;
            }
            iArr4[3] = height - i;
        }
    }

    public final void setTextSize(int i) {
        this.textPaint.setTextSize(i);
    }

    public final void setTextColor(int i) {
        this.textPaint.setColor(i);
    }

    public final void setLabelSize(int i) {
        this.labelPaint.setTextSize(i);
    }

    public final void setLabelColor(int i) {
        this.labelPaint.setColor(i);
    }

    public final void setTagColor(int i) {
        this.tagPaint.setColor(i);
    }

    public final void setBorderColor(int i) {
        this.borderPaint.setColor(i);
    }

    public final void setTagStyle(Paint.Style style) {
        this.tagPaint.setStyle(style);
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        initPositionEdge();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!this.draggable) {
            return super.onTouchEvent(event);
        }
        int x = (int) event.getX();
        int y = (int) event.getY();
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                if (getOrientation() == 0) {
                    if (Math.abs(this.totalDeltaY) < 5) {
                        performClick();
                    }
                } else if (Math.abs(this.totalDeltaX) < 5) {
                    performClick();
                }
                this.isDragging = false;
                Callback callback = this.callback;
                if (callback != null) {
                    callback.onEnd();
                }
            } else if (actionMasked == 2) {
                int i = x - this.mPreviousX;
                int i2 = y - this.mPreviousY;
                this.totalDeltaX += i;
                this.totalDeltaY += i2;
                if (getOrientation() == 0) {
                    handleMoveEvent(i2);
                    Callback callback2 = this.callback;
                    if (callback2 != null) {
                        callback2.onMove(0, i2, this.totalDeltaX, this.totalDeltaY);
                    }
                } else {
                    handleMoveEvent(i);
                    Callback callback3 = this.callback;
                    if (callback3 != null) {
                        callback3.onMove(i, 0, this.totalDeltaX, this.totalDeltaY);
                    }
                }
                this.mPreviousX = x - i;
                this.mPreviousY = y - i2;
                this.isDragging = true;
            } else if (actionMasked == 3) {
                this.isDragging = false;
                Callback callback4 = this.callback;
                if (callback4 != null) {
                    callback4.onEnd();
                }
            }
        } else if (!inDraggingArea(x, y)) {
            return super.onTouchEvent(event);
        } else {
            this.mPreviousX = x;
            this.mPreviousY = y;
            this.totalDeltaX = 0;
            this.totalDeltaY = 0;
            Callback callback5 = this.callback;
            if (callback5 != null) {
                callback5.onStart();
            }
        }
        return true;
    }

    private final boolean inDraggingArea(int i, int i2) {
        if (getOrientation() == 0) {
            if (this.reverse) {
                if (this.showBor) {
                    int width = (getWidth() - this.tagWidth) - 140;
                    int width2 = getWidth();
                    if (width <= i && width2 >= i) {
                        return i2 >= 0 && getHeight() >= i2;
                    }
                    return false;
                }
                int width3 = getWidth() - this.tagWidth;
                int width4 = getWidth();
                if (width3 <= i && width4 >= i) {
                    return i2 >= 0 && getHeight() >= i2;
                }
                return false;
            }
            int i3 = this.tagWidth;
            if (i >= 0 && i3 >= i) {
                return i2 >= 0 && getHeight() >= i2;
            }
            return false;
        } else if (this.reverse) {
            int width5 = getWidth();
            if (i >= 0 && width5 >= i) {
                return i2 >= 0 && this.tagHeight >= i2;
            }
            return false;
        } else {
            int width6 = getWidth();
            if (i >= 0 && width6 >= i) {
                return getHeight() - this.tagHeight <= i2 && getHeight() >= i2;
            }
            return false;
        }
    }

    private final void handleMoveEvent(int i) {
        setPosition(getPosition() + i);
    }

    public final SyncDataViewModel getSyncDataView() {
        return this.syncDataView;
    }

    public final HorizontalParam getHorizontal() {
        return this.horizontal;
    }

    public final void setHorizontal(HorizontalParam horizontalParam) {
        this.horizontal = horizontalParam;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.OrientationView, android.view.View
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawTag(getHeight() >> 1, getWidth() >> 1, canvas);
    }

    private final void drawTag(int i, int i2, Canvas canvas) {
        getPath().reset();
        if (getOrientation() == 0) {
            HorizontalParam horizontalParam = this.horizontal;
            if ((horizontalParam != null ? horizontalParam.getAcquireMode() : null) != ServiceEnum.AcquireMode.Acquire_Ultra) {
                drawHorizontalTag(i, canvas);
                return;
            }
            return;
        }
        HorizontalParam horizontalParam2 = this.horizontal;
        if ((horizontalParam2 != null ? horizontalParam2.getAcquireMode() : null) != ServiceEnum.AcquireMode.Acquire_Ultra) {
            drawVerticalTag(i2, canvas);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawVerticalTag(int r11, android.graphics.Canvas r12) {
        /*
            Method dump skipped, instructions count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.TagView.drawVerticalTag(int, android.graphics.Canvas):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0101  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void drawHorizontalTag(int r10, android.graphics.Canvas r11) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.TagView.drawHorizontalTag(int, android.graphics.Canvas):void");
    }

    private final void turnDown(Canvas canvas, Path path, Paint paint, int i, int i2, int i3, int i4) {
        int i5 = i3 >> 1;
        float f = i;
        float f2 = i2;
        path.moveTo(f, f2);
        int i6 = i + i3;
        float f3 = i6;
        float[] fArr = {f3, f2};
        int i7 = i2 + i4;
        float f4 = i7 - i5;
        drawPolygon(canvas, path, paint, new float[][]{fArr, new float[]{f3, f4}, new float[]{i + i5, i7}, new float[]{f, f4}, new float[]{f, f2}});
        int i8 = i4 - i5;
        drawText(canvas, i, i2, i3, i8);
        drawLabel(canvas, i6, i2, i3, i8);
    }

    private final void turnUp(Canvas canvas, Path path, Paint paint, int i, int i2, int i3, int i4) {
        int i5 = i3 >> 1;
        float f = i;
        float f2 = i2;
        path.moveTo(f, f2);
        int i6 = i2 - i5;
        int i7 = i + i3;
        float f3 = i7;
        float f4 = i6 + i4;
        drawPolygon(canvas, path, paint, new float[][]{new float[]{i + i5, i6}, new float[]{f3, f2}, new float[]{f3, f4}, new float[]{f, f4}, new float[]{f, f2}});
        int i8 = i4 - i5;
        drawText(canvas, i, i2, i3, i8);
        drawLabel(canvas, i7, i2, i3, i8);
    }

    private final void turnRight(Canvas canvas, Path path, Paint paint, int i, int i2, int i3, int i4) {
        int i5 = i4 >> 1;
        float f = i;
        float f2 = i2;
        path.moveTo(f, f2);
        int i6 = i + i3;
        float f3 = i6 - i5;
        float f4 = i2 + i4;
        drawPolygon(canvas, path, paint, new float[][]{new float[]{f3, f2}, new float[]{i6, i2 + i5}, new float[]{f3, f4}, new float[]{f, f4}, new float[]{f, f2}});
        int i7 = i3 - i5;
        drawText(canvas, i, i2, i7, i4);
        drawLabel(canvas, i6, i2, i7, i4);
    }

    private final void turnLeft(Canvas canvas, Path path, Paint paint, int i, int i2, int i3, int i4) {
        int i5 = i4 >> 1;
        float f = i;
        float f2 = i2;
        path.moveTo(f, f2);
        int i6 = i + i5;
        float f3 = i6;
        int i7 = i2 - i5;
        float f4 = i7;
        float f5 = i + i3;
        float[] fArr = {f5, f4};
        float f6 = i2 + i5;
        drawPolygon(canvas, path, paint, new float[][]{new float[]{f3, f4}, fArr, new float[]{f5, f6}, new float[]{f3, f6}, new float[]{f, f2}});
        drawText(canvas, i6, i7, i3 - i5, i4);
    }

    private final void drawText(Canvas canvas, int i, int i2, int i3, int i4) {
        int i5 = i;
        int i6 = i2;
        if (!TextUtils.isEmpty(this.text)) {
            Paint paint = this.textPaint;
            String str = this.text;
            Intrinsics.checkNotNull(str);
            paint.getTextBounds(str, 0, str.length(), this.rect);
            String str2 = this.text;
            Intrinsics.checkNotNull(str2);
            canvas.drawText(str2, (i3 >> 1) + i5, (i4 >> 1) + i6 + ((this.rect.bottom - this.rect.top) >> 1), this.textPaint);
        }
        MutableLiveData<Boolean> popuwind_boolean = ViewUtil.getViewABkeyViewModel().getPopuwind_boolean();
        Intrinsics.checkNotNullExpressionValue(popuwind_boolean, "ViewUtil.getViewABkeyVie…l().getPopuwind_boolean()");
        Boolean value = popuwind_boolean.getValue();
        Intrinsics.checkNotNull(value);
        if (value.booleanValue() && this.isShowHint) {
            MutableLiveData<Boolean> mutableLiveData = ViewUtil.getViewABkeyViewModel().ax_boolean;
            Intrinsics.checkNotNullExpressionValue(mutableLiveData, "ViewUtil.getViewABkeyViewModel().ax_boolean");
            if (mutableLiveData.getValue() != null) {
                MutableLiveData<Boolean> mutableLiveData2 = ViewUtil.getViewABkeyViewModel().ay_boolean;
                Intrinsics.checkNotNullExpressionValue(mutableLiveData2, "ViewUtil.getViewABkeyViewModel().ay_boolean");
                if (mutableLiveData2.getValue() != null) {
                    MutableLiveData<Boolean> mutableLiveData3 = ViewUtil.getViewABkeyViewModel().by_boolean;
                    Intrinsics.checkNotNullExpressionValue(mutableLiveData3, "ViewUtil.getViewABkeyViewModel().by_boolean");
                    if (mutableLiveData3.getValue() != null) {
                        MutableLiveData<Boolean> mutableLiveData4 = ViewUtil.getViewABkeyViewModel().bx_boolean;
                        Intrinsics.checkNotNullExpressionValue(mutableLiveData4, "ViewUtil.getViewABkeyViewModel().bx_boolean");
                        if (mutableLiveData4.getValue() != null) {
                            if (StringsKt.equals$default(this.text, "AX", false, 2, null)) {
                                MutableLiveData<Boolean> mutableLiveData5 = ViewUtil.getViewABkeyViewModel().ax_boolean;
                                Intrinsics.checkNotNullExpressionValue(mutableLiveData5, "ViewUtil.getViewABkeyViewModel().ax_boolean");
                                Boolean value2 = mutableLiveData5.getValue();
                                Intrinsics.checkNotNull(value2);
                                if (value2.booleanValue() && getOrientation() == 1) {
                                    float f = i6 * 0.1f;
                                    float f2 = 30;
                                    float f3 = f - f2 < ((float) 0) ? 12 + 50.0f : 12 + f;
                                    double x = getX();
                                    if (x < -24.0d || x > 1.0d) {
                                        double left = getLeft() - 25;
                                        double left2 = getLeft();
                                        if (x >= left && x <= left2) {
                                            i5 = 14;
                                        }
                                    } else {
                                        i5 = 40;
                                    }
                                    Path path = new Path();
                                    float f4 = i5 - (i3 >> 1);
                                    float f5 = 3;
                                    float f6 = (9 + f4) - f5;
                                    float f7 = f3 - f2;
                                    float f8 = 12;
                                    float f9 = f7 + f8;
                                    path.moveTo(f6, f9);
                                    float f10 = (18 + f4) - f5;
                                    float f11 = (f3 - 37) + f8;
                                    float f12 = (f3 - 45) + f8;
                                    drawPolygon(canvas, path, this.cursor_labelPaint, new float[][]{new float[]{f6, f9}, new float[]{f10, f9}, new float[]{(22 + f4) - f5, f11}, new float[]{f10, f12}, new float[]{f6, f12}, new float[]{(5 + f4) - f5, f11}});
                                    String str3 = this.cousor_label;
                                    Intrinsics.checkNotNull(str3);
                                    canvas.drawText(str3, f4 + 10, (f3 - 32) + f8, this.text_tag_Paint);
                                    return;
                                }
                                return;
                            } else if (StringsKt.equals$default(this.text, "AY", false, 2, null)) {
                                MutableLiveData<Boolean> mutableLiveData6 = ViewUtil.getViewABkeyViewModel().ay_boolean;
                                Intrinsics.checkNotNullExpressionValue(mutableLiveData6, "ViewUtil.getViewABkeyViewModel().ay_boolean");
                                Boolean value3 = mutableLiveData6.getValue();
                                Intrinsics.checkNotNull(value3);
                                if (value3.booleanValue() && getOrientation() == 0) {
                                    Path path2 = new Path();
                                    float f13 = 9;
                                    float f14 = (((float) (i5 - (i3 >> 1))) + f13) - ((float) 1000) < ((float) 0) ? 45.0f : 80.0f;
                                    double y = getY();
                                    if (y < -24.0d || y > 10.0d) {
                                        double top = getTop() - 15;
                                        if (y >= getTop() - 25 && y <= top) {
                                            i6 -= 10;
                                        }
                                    } else {
                                        i6 = 45;
                                    }
                                    float f15 = f13 + f14;
                                    float f16 = i6;
                                    float f17 = f16 - 30;
                                    float f18 = 35;
                                    float f19 = f17 + f18;
                                    path2.moveTo(f15, f19);
                                    float f20 = 18 + f14;
                                    float f21 = (f16 - 37) + f18;
                                    float f22 = (f16 - 45) + f18;
                                    drawPolygon(canvas, path2, this.cursor_labelPaint, new float[][]{new float[]{f15, f19}, new float[]{f20, f19}, new float[]{22 + f14, f21}, new float[]{f20, f22}, new float[]{f15, f22}, new float[]{5 + f14, f21}});
                                    String str4 = this.cousor_label;
                                    Intrinsics.checkNotNull(str4);
                                    canvas.drawText(str4, f14 + 13, f17 + 32, this.text_tag_Paint);
                                    return;
                                }
                                return;
                            } else if (StringsKt.equals$default(this.text, "BX", false, 2, null)) {
                                MutableLiveData<Boolean> mutableLiveData7 = ViewUtil.getViewABkeyViewModel().bx_boolean;
                                Intrinsics.checkNotNullExpressionValue(mutableLiveData7, "ViewUtil.getViewABkeyViewModel().bx_boolean");
                                Boolean value4 = mutableLiveData7.getValue();
                                Intrinsics.checkNotNull(value4);
                                if (value4.booleanValue() && getOrientation() == 1) {
                                    float f23 = i6 * 0.1f;
                                    float f24 = 30;
                                    float f25 = f23 - f24 < ((float) 0) ? 12 + 50.0f : 12 + f23;
                                    Path path3 = new Path();
                                    double x2 = getX();
                                    if (x2 < -24.0d || x2 > 1.0d) {
                                        double left3 = getLeft() - 25;
                                        double left4 = getLeft();
                                        if (x2 >= left3 && x2 <= left4) {
                                            i5 = 14;
                                        }
                                    } else {
                                        i5 = 40;
                                    }
                                    float f26 = i5 - (i3 >> 1);
                                    float f27 = 3;
                                    float f28 = (9 + f26) - f27;
                                    float f29 = 12;
                                    float f30 = (f25 - f24) + f29;
                                    path3.moveTo(f28, f30);
                                    float f31 = (18 + f26) - f27;
                                    float f32 = (f25 - 37) + f29;
                                    float f33 = (f25 - 45) + f29;
                                    drawPolygon(canvas, path3, this.cursor_labelPaint, new float[][]{new float[]{f28, f30}, new float[]{f31, f30}, new float[]{(22 + f26) - f27, f32}, new float[]{f31, f33}, new float[]{f28, f33}, new float[]{(5 + f26) - f27, f32}});
                                    String str5 = this.cousor_label;
                                    Intrinsics.checkNotNull(str5);
                                    canvas.drawText(str5, f26 + 10, (f25 - 32) + f29, this.text_tag_Paint);
                                    return;
                                }
                                return;
                            } else if (StringsKt.equals$default(this.text, "BY", false, 2, null)) {
                                MutableLiveData<Boolean> mutableLiveData8 = ViewUtil.getViewABkeyViewModel().by_boolean;
                                Intrinsics.checkNotNullExpressionValue(mutableLiveData8, "ViewUtil.getViewABkeyViewModel().by_boolean");
                                Boolean value5 = mutableLiveData8.getValue();
                                Intrinsics.checkNotNull(value5);
                                if (value5.booleanValue() && getOrientation() == 0) {
                                    Path path4 = new Path();
                                    float f34 = 9;
                                    float f35 = (((float) (i5 - (i3 >> 1))) + f34) - ((float) 1000) < ((float) 0) ? 45.0f : 80.0f;
                                    double y2 = getY();
                                    if (y2 < -24.0d || y2 > 10.0d) {
                                        double top2 = getTop() - 15;
                                        if (y2 >= getTop() - 25 && y2 <= top2) {
                                            i6 -= 10;
                                        }
                                    } else {
                                        i6 = 45;
                                    }
                                    float f36 = f34 + f35;
                                    float f37 = i6;
                                    float f38 = f37 - 30;
                                    float f39 = 35;
                                    float f40 = f38 + f39;
                                    path4.moveTo(f36, f40);
                                    float f41 = 18 + f35;
                                    float f42 = (f37 - 37) + f39;
                                    float f43 = (f37 - 45) + f39;
                                    drawPolygon(canvas, path4, this.cursor_labelPaint, new float[][]{new float[]{f36, f40}, new float[]{f41, f40}, new float[]{22 + f35, f42}, new float[]{f41, f43}, new float[]{f36, f43}, new float[]{5 + f35, f42}});
                                    String str6 = this.cousor_label;
                                    Intrinsics.checkNotNull(str6);
                                    canvas.drawText(str6, f35 + 13, f38 + 32, this.text_tag_Paint);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        }
                    }
                }
            }
            if (this.cousor_showLabel_now && getOrientation() == 0) {
                float f44 = 80;
                float f45 = (i5 * 0.1f) - f44;
                int i7 = (i4 >> 1) + i6;
                float f46 = 8;
                canvas.drawCircle(f45, (i7 - ((this.rect.bottom - this.rect.top) >> 1)) - f46, 10, this.cursor_labelPaint);
                String str7 = this.cousor_label;
                Intrinsics.checkNotNull(str7);
                canvas.drawText(str7, f45, (i7 - ((this.rect.bottom - this.rect.top) >> 1)) - 3, this.text_tag_Paint);
                Path path5 = new Path();
                float f47 = i5 - (i3 >> 1);
                float f48 = f47 - f44;
                path5.moveTo(f48, (i7 - ((this.rect.bottom - this.rect.top) >> 1)) - f46);
                float f49 = i6 * 0.1f;
                float f50 = f49 - 30;
                float[] fArr = {f48, f50};
                float f51 = f47 - 62;
                float[] fArr2 = {f51, f50};
                float f52 = f49 - 37;
                float f53 = f49 - 45;
                drawPolygon(canvas, path5, this.cursor_labelPaint, new float[][]{fArr, fArr2, new float[]{f47 - 58, f52}, new float[]{f51, f53}, new float[]{f47 - 71, f53}, new float[]{f47 - 75, f52}});
            }
            if (this.cousor_showLabel_now && getOrientation() == 1) {
                String str8 = this.cousor_label;
                Intrinsics.checkNotNull(str8);
                float f54 = i5 - (i3 >> 1);
                float f55 = 9 + f54;
                float f56 = i6 * 0.1f;
                canvas.drawText(str8, f55, f56 - 25, this.text_tag_Paint);
                Path path6 = new Path();
                float f57 = 12;
                float f58 = (f56 - 30) + f57;
                path6.moveTo(f55, f58);
                float f59 = 18 + f54;
                float f60 = (f56 - 37) + f57;
                float f61 = (f56 - 45) + f57;
                drawPolygon(canvas, path6, this.cursor_labelPaint, new float[][]{new float[]{f55, f58}, new float[]{f59, f58}, new float[]{22 + f54, f60}, new float[]{f59, f61}, new float[]{f55, f61}, new float[]{5 + f54, f60}});
                String str9 = this.cousor_label;
                Intrinsics.checkNotNull(str9);
                canvas.drawText(str9, f54 + 13, (f56 - 32) + f57, this.text_tag_Paint);
            }
        }
    }

    private final void drawLabel(Canvas canvas, int i, int i2, int i3, int i4) {
        if (!this.showLabel || TextUtils.isEmpty(this.label)) {
            return;
        }
        Paint paint = this.labelPaint;
        String str = this.label;
        Intrinsics.checkNotNull(str);
        paint.getTextBounds(str, 0, str.length(), this.rect);
        String str2 = this.label;
        Intrinsics.checkNotNull(str2);
        canvas.drawText(str2, i + (i3 >> 1), i2 + (i4 >> 1) + ((this.rect.bottom - this.rect.top) >> 1), this.labelPaint);
    }

    public final void drawPolygon(Canvas canvas, Path path, Paint paint, float[][] points) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Intrinsics.checkNotNullParameter(points, "points");
        for (float[] fArr : points) {
            path.lineTo(fArr[0], fArr[1]);
        }
        canvas.drawPath(path, paint);
        if (this.showBorder && paint.getStyle() == Paint.Style.FILL) {
            canvas.drawPath(path, this.borderPaint);
        }
        if (paint.getStyle() == Paint.Style.STROKE) {
            int color = paint.getColor();
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path, paint);
            paint.setColor(color);
            paint.setStyle(Paint.Style.STROKE);
        }
    }

    /* compiled from: TagView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/rigol/scope/views/TagView$Companion;", "", "()V", "DEFAULT_DASH_PATH_EFFECT", "Landroid/graphics/PathEffect;", "DEFAULT_LABEL_TEXT_SIZE", "", "DEFAULT_TAG_STROKE_WIDTH", "DEFAULT_TEXT_SIZE", "ERROR_RANG_OF_MOVING_DISTANCE", "", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
