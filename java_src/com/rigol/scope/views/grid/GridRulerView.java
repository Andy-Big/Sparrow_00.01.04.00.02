package com.rigol.scope.views.grid;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.motion.widget.Key;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: GridRulerView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b$\b\u0016\u0018\u0000 w2\u00020\u0001:\u0001wB\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ \u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00122\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020\tH\u0002J \u0010V\u001a\u00020Q2\u0006\u0010W\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u00122\u0006\u0010S\u001a\u00020TH\u0002J \u0010X\u001a\u00020Q2\u0006\u0010Y\u001a\u00020\t2\u0006\u0010S\u001a\u00020T2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010Z\u001a\u00020Q2\u0006\u0010W\u001a\u00020\t2\u0006\u0010S\u001a\u00020T2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010[\u001a\u00020Q2\u0006\u0010\\\u001a\u00020T2\u0006\u0010]\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010^\u001a\u00020Q2\u0006\u0010\\\u001a\u00020T2\u0006\u0010]\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0010\u0010_\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010`\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u00122\u0006\u0010a\u001a\u00020T2\u0006\u0010U\u001a\u00020\tH\u0002J \u0010b\u001a\u00020Q2\u0006\u0010c\u001a\u00020\t2\u0006\u0010a\u001a\u00020T2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010d\u001a\u00020Q2\u0006\u0010U\u001a\u00020\t2\u0006\u0010a\u001a\u00020T2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010e\u001a\u00020Q2\u0006\u0010c\u001a\u00020\t2\u0006\u0010a\u001a\u00020T2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010f\u001a\u00020Q2\u0006\u0010\\\u001a\u00020T2\u0006\u0010]\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u0012H\u0002J \u0010g\u001a\u00020Q2\u0006\u0010\\\u001a\u00020T2\u0006\u0010]\u001a\u00020\t2\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0010\u0010h\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0012H\u0002J\u0010\u0010i\u001a\u00020T2\u0006\u0010U\u001a\u00020\tH\u0002J\u000e\u00104\u001a\u00020Q2\u0006\u00104\u001a\u00020$J\u0010\u0010j\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0012H\u0014J(\u0010k\u001a\u00020Q2\u0006\u0010l\u001a\u00020\t2\u0006\u0010m\u001a\u00020\t2\u0006\u0010n\u001a\u00020\t2\u0006\u0010o\u001a\u00020\tH\u0014J\u000e\u0010p\u001a\u00020Q2\u0006\u0010q\u001a\u00020\tJ\u000e\u0010r\u001a\u00020Q2\u0006\u0010s\u001a\u00020TJ\u000e\u0010t\u001a\u00020Q2\u0006\u0010q\u001a\u00020\tJ\b\u0010u\u001a\u00020QH\u0002J\b\u0010v\u001a\u00020QH\u0002R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R6\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\u001c\u0010,\u001a\u0004\u0018\u00010-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001a\u00102\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010&\"\u0004\b3\u0010(R\u001a\u00104\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010&\"\u0004\b5\u0010(R\u001a\u00106\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R\u001a\u00108\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010&\"\u0004\b9\u0010(R\u000e\u0010:\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010;\u001a\u00020$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010&\"\u0004\b<\u0010(R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010?\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00182\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001f\u001a\u0004\b@\u0010\u001c\"\u0004\bA\u0010\u001eR\u000e\u0010B\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010F\u001a\u0004\u0018\u00010G¢\u0006\b\n\u0000\u001a\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020KX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010O¨\u0006x"}, d2 = {"Lcom/rigol/scope/views/grid/GridRulerView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bufferBitmap", "Landroid/graphics/Bitmap;", "getBufferBitmap", "()Landroid/graphics/Bitmap;", "setBufferBitmap", "(Landroid/graphics/Bitmap;)V", "bufferCanvas", "Landroid/graphics/Canvas;", "getBufferCanvas", "()Landroid/graphics/Canvas;", "setBufferCanvas", "(Landroid/graphics/Canvas;)V", "value", "", "", "columnContents", "getColumnContents", "()[Ljava/lang/String;", "setColumnContents", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "columnLinePaint", "Landroid/graphics/Paint;", "columnTextPaint", "fromStart", "", "getFromStart", "()Z", "setFromStart", "(Z)V", "fromTop", "getFromTop", "setFromTop", "horizontal", "Lcom/rigol/scope/data/HorizontalParam;", "getHorizontal", "()Lcom/rigol/scope/data/HorizontalParam;", "setHorizontal", "(Lcom/rigol/scope/data/HorizontalParam;)V", "isAbout", "setAbout", "isMain", "setMain", "isShowAllCol", "setShowAllCol", "isShowAllRow", "setShowAllRow", "isShowLine", "isShowRuler", "setShowRuler", "path", "Landroid/graphics/Path;", "rowContents", "getRowContents", "setRowContents", "rowLinePaint", "rowTextPaint", "scaleLinePaint", "solidLinePaint", "syncDataView", "Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "getSyncDataView", "()Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "type", "Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;", "getType", "()Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;", "setType", "(Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;)V", "drawColumn", "", "canvas", "columnWidth", "", "i", "drawColumnContents", "columnContentsSize", "drawColumnLine", "j", "drawColumnLines", "drawColumnMiddleScale", "scaleSize", "totalSize", "drawColumnSideScaleLine", "drawColumns", "drawRowContent", "rowHeight", "drawRowContents", "rowContentsSize", "drawRowLine", "drawRowLines", "drawRowMiddleScaleLine", "drawRowSideScaleLine", "drawRows", "getScaleLineSize", "onDraw", "onSizeChanged", "w", "h", "oldw", "oldh", "setColumnTextColor", "color", "setLineAlpha", Key.ALPHA, "setRowTextColor", "updateColumnLinePathEffect", "updateRowLinePathEffect", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class GridRulerView extends View {
    public static final Companion Companion = new Companion(null);
    private static final PathEffect DEFAULT_DASH_PATH_EFFECT = new DashPathEffect(new float[]{1.0f, 10.0f}, 0);
    public static final float DEFAULT_PADDING = 10.0f;
    public static final float DEFAULT_TEXT_SIZE = 16.0f;
    private Bitmap bufferBitmap;
    private Canvas bufferCanvas;
    private String[] columnContents;
    private final Paint columnLinePaint;
    private final Paint columnTextPaint;
    private boolean fromStart;
    private boolean fromTop;
    private HorizontalParam horizontal;
    private boolean isAbout;
    private boolean isMain;
    private boolean isShowAllCol;
    private boolean isShowAllRow;
    private boolean isShowLine;
    private boolean isShowRuler;
    private final Path path;
    private String[] rowContents;
    private final Paint rowLinePaint;
    private final Paint rowTextPaint;
    private final Paint scaleLinePaint;
    private final Paint solidLinePaint;
    private final SyncDataViewModel syncDataView;
    private ServiceEnum.EWaveGrids type;

    public final String[] getColumnContents() {
        return this.columnContents;
    }

    public final void setColumnContents(String[] strArr) {
        this.columnContents = strArr;
        updateRowLinePathEffect();
    }

    public final boolean isAbout() {
        return this.isAbout;
    }

    public final void setAbout(boolean z) {
        this.isAbout = z;
    }

    private final void updateRowLinePathEffect() {
        String[] strArr = this.columnContents;
        Integer valueOf = strArr != null ? Integer.valueOf(strArr.length) : null;
        if (valueOf == null) {
            return;
        }
        this.rowLinePaint.setPathEffect(new DashPathEffect(new float[]{1.0f, (((getWidth() - 1) / (valueOf.intValue() - 1)) / 10) - 1}, 0));
    }

    public final String[] getRowContents() {
        return this.rowContents;
    }

    public final void setRowContents(String[] strArr) {
        this.rowContents = strArr;
        updateColumnLinePathEffect();
    }

    private final void updateColumnLinePathEffect() {
        String[] strArr = this.rowContents;
        Integer valueOf = strArr != null ? Integer.valueOf(strArr.length) : null;
        if (valueOf == null) {
            return;
        }
        this.columnLinePaint.setPathEffect(new DashPathEffect(new float[]{1.0f, (((getHeight() - 1) / (valueOf.intValue() - 1)) / 10) - 1}, 0));
    }

    public final boolean getFromTop() {
        return this.fromTop;
    }

    public final void setFromTop(boolean z) {
        this.fromTop = z;
    }

    public final boolean getFromStart() {
        return this.fromStart;
    }

    public final void setFromStart(boolean z) {
        this.fromStart = z;
    }

    public final boolean isShowAllCol() {
        return this.isShowAllCol;
    }

    public final void setShowAllCol(boolean z) {
        this.isShowAllCol = z;
    }

    public final boolean isShowAllRow() {
        return this.isShowAllRow;
    }

    public final void setShowAllRow(boolean z) {
        this.isShowAllRow = z;
    }

    public final ServiceEnum.EWaveGrids getType() {
        return this.type;
    }

    public final void setType(ServiceEnum.EWaveGrids eWaveGrids) {
        Intrinsics.checkNotNullParameter(eWaveGrids, "<set-?>");
        this.type = eWaveGrids;
    }

    public final boolean isShowRuler() {
        return this.isShowRuler;
    }

    public final void setShowRuler(boolean z) {
        this.isShowRuler = z;
    }

    public final boolean isMain() {
        return this.isMain;
    }

    public final void setMain(boolean z) {
        this.isMain = z;
    }

    public GridRulerView(Context context) {
        super(context);
        MutableLiveData<Object> mutableLiveData;
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(1.0f);
        paint2.setAntiAlias(true);
        paint2.setTextSize(16.0f);
        paint2.setColor(-3355444);
        Unit unit2 = Unit.INSTANCE;
        this.rowTextPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.0f);
        paint3.setColor(-1);
        Unit unit3 = Unit.INSTANCE;
        this.columnLinePaint = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(1.0f);
        paint4.setColor(-1);
        Unit unit4 = Unit.INSTANCE;
        this.rowLinePaint = paint4;
        Paint paint5 = new Paint();
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(1.0f);
        paint5.setPathEffect(new PathEffect());
        paint5.setColor(-1);
        Unit unit5 = Unit.INSTANCE;
        this.scaleLinePaint = paint5;
        Paint paint6 = new Paint();
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeWidth(1.0f);
        paint6.setPathEffect(new PathEffect());
        paint6.setColor(-3355444);
        Unit unit6 = Unit.INSTANCE;
        this.solidLinePaint = paint6;
        this.path = new Path();
        this.isAbout = true;
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowLine = true;
        this.isShowRuler = true;
        this.syncDataView = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.horizontal = ((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue();
        SyncDataViewModel syncDataViewModel = this.syncDataView;
        if (syncDataViewModel == null || (mutableLiveData = syncDataViewModel.get(10, MessageID.MSG_ACQ_MODE)) == null) {
            return;
        }
        Context context2 = getContext();
        if (context2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.GridRulerView.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GridRulerView.this.invalidate();
            }
        });
    }

    public GridRulerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        MutableLiveData<Object> mutableLiveData;
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(1.0f);
        paint2.setAntiAlias(true);
        paint2.setTextSize(16.0f);
        paint2.setColor(-3355444);
        Unit unit2 = Unit.INSTANCE;
        this.rowTextPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.0f);
        paint3.setColor(-1);
        Unit unit3 = Unit.INSTANCE;
        this.columnLinePaint = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(1.0f);
        paint4.setColor(-1);
        Unit unit4 = Unit.INSTANCE;
        this.rowLinePaint = paint4;
        Paint paint5 = new Paint();
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(1.0f);
        paint5.setPathEffect(new PathEffect());
        paint5.setColor(-1);
        Unit unit5 = Unit.INSTANCE;
        this.scaleLinePaint = paint5;
        Paint paint6 = new Paint();
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeWidth(1.0f);
        paint6.setPathEffect(new PathEffect());
        paint6.setColor(-3355444);
        Unit unit6 = Unit.INSTANCE;
        this.solidLinePaint = paint6;
        this.path = new Path();
        this.isAbout = true;
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowLine = true;
        this.isShowRuler = true;
        this.syncDataView = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.horizontal = ((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue();
        SyncDataViewModel syncDataViewModel = this.syncDataView;
        if (syncDataViewModel == null || (mutableLiveData = syncDataViewModel.get(10, MessageID.MSG_ACQ_MODE)) == null) {
            return;
        }
        Context context2 = getContext();
        if (context2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.GridRulerView.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GridRulerView.this.invalidate();
            }
        });
    }

    public GridRulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        MutableLiveData<Object> mutableLiveData;
        Paint paint = new Paint();
        paint.setStrokeWidth(1.0f);
        paint.setAntiAlias(true);
        paint.setTextSize(16.0f);
        paint.setColor(-3355444);
        Unit unit = Unit.INSTANCE;
        this.columnTextPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStrokeWidth(1.0f);
        paint2.setAntiAlias(true);
        paint2.setTextSize(16.0f);
        paint2.setColor(-3355444);
        Unit unit2 = Unit.INSTANCE;
        this.rowTextPaint = paint2;
        Paint paint3 = new Paint();
        paint3.setStyle(Paint.Style.STROKE);
        paint3.setStrokeWidth(1.0f);
        paint3.setColor(-1);
        Unit unit3 = Unit.INSTANCE;
        this.columnLinePaint = paint3;
        Paint paint4 = new Paint();
        paint4.setStyle(Paint.Style.STROKE);
        paint4.setStrokeWidth(1.0f);
        paint4.setColor(-1);
        Unit unit4 = Unit.INSTANCE;
        this.rowLinePaint = paint4;
        Paint paint5 = new Paint();
        paint5.setStyle(Paint.Style.STROKE);
        paint5.setStrokeWidth(1.0f);
        paint5.setPathEffect(new PathEffect());
        paint5.setColor(-1);
        Unit unit5 = Unit.INSTANCE;
        this.scaleLinePaint = paint5;
        Paint paint6 = new Paint();
        paint6.setStyle(Paint.Style.STROKE);
        paint6.setStrokeWidth(1.0f);
        paint6.setPathEffect(new PathEffect());
        paint6.setColor(-3355444);
        Unit unit6 = Unit.INSTANCE;
        this.solidLinePaint = paint6;
        this.path = new Path();
        this.isAbout = true;
        this.type = ServiceEnum.EWaveGrids.GRID_IS_FULL;
        this.isShowLine = true;
        this.isShowRuler = true;
        this.syncDataView = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.horizontal = ((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue();
        SyncDataViewModel syncDataViewModel = this.syncDataView;
        if (syncDataViewModel == null || (mutableLiveData = syncDataViewModel.get(10, MessageID.MSG_ACQ_MODE)) == null) {
            return;
        }
        Context context2 = getContext();
        if (context2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context2, new Observer<Object>() { // from class: com.rigol.scope.views.grid.GridRulerView.1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GridRulerView.this.invalidate();
            }
        });
    }

    public final void setRowTextColor(int i) {
        this.rowTextPaint.setColor(i);
    }

    public final void setColumnTextColor(int i) {
        this.columnTextPaint.setColor(i);
    }

    public final void isMain(boolean z) {
        this.isMain = z;
    }

    public final void setLineAlpha(float f) {
        float f2 = f * 255;
        int i = (int) f2;
        this.columnLinePaint.setAlpha(i);
        this.rowLinePaint.setAlpha(i);
        this.scaleLinePaint.setAlpha(i);
        this.solidLinePaint.setAlpha((int) (f2 * 0.5d));
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

    public final Bitmap getBufferBitmap() {
        return this.bufferBitmap;
    }

    public final void setBufferBitmap(Bitmap bitmap) {
        this.bufferBitmap = bitmap;
    }

    public final Canvas getBufferCanvas() {
        return this.bufferCanvas;
    }

    public final void setBufferCanvas(Canvas canvas) {
        this.bufferCanvas = canvas;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            updateRowLinePathEffect();
        }
        if (i2 != i4) {
            updateColumnLinePathEffect();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        drawColumns(canvas);
        drawRows(canvas);
    }

    private final void drawRows(Canvas canvas) {
        String[] strArr = this.rowContents;
        Intrinsics.checkNotNull(strArr);
        int length = strArr.length;
        float height = getHeight() / (length - 1);
        HorizontalParam horizontalParam = this.horizontal;
        if ((horizontalParam != null ? horizontalParam.getAcquireMode() : null) != ServiceEnum.AcquireMode.Acquire_Ultra || !this.isMain) {
            drawRowContents(length, height, canvas);
        }
        drawRowLines(length, height, canvas);
    }

    private final void drawRowContents(int i, float f, Canvas canvas) {
        if (this.isShowRuler) {
            int i2 = i - 1;
            for (int i3 = 1; i3 < i2; i3++) {
                drawRowContent(canvas, f, i3);
            }
            if (!this.isShowAllRow) {
                for (int i4 = 1; i4 < i2; i4++) {
                    drawRowContent(canvas, f, i4);
                }
                return;
            }
            for (int i5 = 0; i5 < i; i5++) {
                drawRowContent(canvas, f, i5);
            }
        }
    }

    private final void drawRowContent(Canvas canvas, float f, int i) {
        String[] strArr = this.rowContents;
        Intrinsics.checkNotNull(strArr);
        String str = strArr[i];
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int i2 = (int) (i * f);
        float measureText = this.columnTextPaint.measureText(str);
        if (this.isAbout) {
            if (i == 0) {
                canvas.drawText(str, this.fromStart ? 10.0f : (getWidth() - measureText) - 10.0f, i2 + 16.0f, this.rowTextPaint);
                return;
            }
            String[] strArr2 = this.rowContents;
            Intrinsics.checkNotNull(strArr2);
            if (i == strArr2.length - 1) {
                canvas.drawText(str, this.fromStart ? 10.0f : (getWidth() - measureText) - 10.0f, i2 - 10.0f, this.rowTextPaint);
            } else {
                canvas.drawText(str, this.fromStart ? 10.0f : (getWidth() - measureText) - 10.0f, i2 + 8.0f, this.rowTextPaint);
            }
        } else if (i == 0) {
            canvas.drawText(str, 10.0f, i2 + 16.0f, this.rowTextPaint);
        } else {
            String[] strArr3 = this.rowContents;
            Intrinsics.checkNotNull(strArr3);
            if (i == strArr3.length - 1) {
                canvas.drawText(str, 10.0f, i2 - 10.0f, this.rowTextPaint);
            } else {
                canvas.drawText(str, 10.0f, i2 + 8.0f, this.rowTextPaint);
            }
        }
    }

    private final void drawRowLines(int i, float f, Canvas canvas) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        if (this.isShowLine) {
            if (this.type == ServiceEnum.EWaveGrids.GRID_IS_FULL) {
                int i2 = i - 1;
                for (int i3 = 1; i3 < i2; i3++) {
                    if (i % 2 == 0 || i3 != i2 / 2) {
                        drawRowLine(i3, f, canvas);
                    }
                }
                Intrinsics.checkNotNull(this.columnContents);
                float width = (getWidth() / (strArr3.length - 1)) / 5;
                String[] strArr4 = this.columnContents;
                Intrinsics.checkNotNull(strArr4);
                drawRowMiddleScaleLine(width, ((strArr4.length - 1) * 5) + 1, canvas);
            } else if (this.type == ServiceEnum.EWaveGrids.GRID_IS_HALF) {
                Intrinsics.checkNotNull(this.columnContents);
                float width2 = (getWidth() / (strArr.length - 1)) / 5;
                String[] strArr5 = this.columnContents;
                Intrinsics.checkNotNull(strArr5);
                drawRowMiddleScaleLine(width2, ((strArr5.length - 1) * 5) + 1, canvas);
            }
            Intrinsics.checkNotNull(this.columnContents);
            float width3 = (getWidth() / (strArr2.length - 1)) / 5;
            String[] strArr6 = this.columnContents;
            Intrinsics.checkNotNull(strArr6);
            drawRowSideScaleLine(width3, ((strArr6.length - 1) * 5) + 1, canvas);
        }
    }

    private final void drawRowLine(int i, float f, Canvas canvas) {
        float f2 = i * f;
        this.path.reset();
        this.path.moveTo(0, f2);
        this.path.lineTo(getWidth(), f2);
        canvas.drawPath(this.path, this.rowLinePaint);
    }

    private final void drawRowSideScaleLine(float f, int i, Canvas canvas) {
        int i2 = 0;
        float f2 = 0;
        canvas.drawLine(f2, f2, getWidth(), f2, this.scaleLinePaint);
        int i3 = 0;
        while (i3 < i) {
            float scaleLineSize = getScaleLineSize(i3);
            float strokeWidth = i3 == i + (-1) ? (i3 * f) - this.scaleLinePaint.getStrokeWidth() : i3 * f;
            canvas.drawLine(strokeWidth, f2, strokeWidth, scaleLineSize, this.scaleLinePaint);
            i3++;
        }
        float height = getHeight() - this.scaleLinePaint.getStrokeWidth();
        canvas.drawLine(f2, height, getWidth(), height, this.scaleLinePaint);
        while (i2 < i) {
            float scaleLineSize2 = getScaleLineSize(i2);
            float strokeWidth2 = i2 == i + (-1) ? (i2 * f) - this.scaleLinePaint.getStrokeWidth() : i2 * f;
            canvas.drawLine(strokeWidth2, height - scaleLineSize2, strokeWidth2, height, this.scaleLinePaint);
            i2++;
        }
    }

    private final void drawRowMiddleScaleLine(float f, int i, Canvas canvas) {
        this.path.reset();
        float f2 = 2;
        float height = getHeight() / f2;
        int i2 = 0;
        canvas.drawLine(0, height, getWidth(), height, this.solidLinePaint);
        while (i2 < i) {
            float scaleLineSize = getScaleLineSize(i2);
            float strokeWidth = i2 == i + (-1) ? (i2 * f) - this.scaleLinePaint.getStrokeWidth() : i2 * f;
            float f3 = scaleLineSize / f2;
            canvas.drawLine(strokeWidth, height - f3, strokeWidth, height + f3, this.scaleLinePaint);
            i2++;
        }
    }

    private final float getScaleLineSize(int i) {
        return i % 5 == 0 ? 10 : 5;
    }

    private final void drawColumnSideScaleLine(float f, int i, Canvas canvas) {
        int i2 = 0;
        float f2 = 0;
        canvas.drawLine(f2, f2, f2, getHeight(), this.scaleLinePaint);
        int i3 = 0;
        while (i3 < i) {
            float scaleLineSize = getScaleLineSize(i3);
            float strokeWidth = i3 == i + (-1) ? (i3 * f) - this.scaleLinePaint.getStrokeWidth() : i3 * f;
            canvas.drawLine(f2, strokeWidth, scaleLineSize, strokeWidth, this.scaleLinePaint);
            i3++;
        }
        float width = getWidth() - this.scaleLinePaint.getStrokeWidth();
        canvas.drawLine(width, f2, width, getHeight(), this.scaleLinePaint);
        while (i2 < i) {
            float scaleLineSize2 = getScaleLineSize(i2);
            float strokeWidth2 = i2 == i + (-1) ? (i2 * f) - this.scaleLinePaint.getStrokeWidth() : i2 * f;
            canvas.drawLine(getWidth() - scaleLineSize2, strokeWidth2, getWidth(), strokeWidth2, this.scaleLinePaint);
            i2++;
        }
    }

    private final void drawColumnMiddleScale(float f, int i, Canvas canvas) {
        float f2 = 2;
        float width = getWidth() / f2;
        int i2 = 0;
        canvas.drawLine(width, 0, width, getHeight(), this.solidLinePaint);
        while (i2 < i) {
            float scaleLineSize = getScaleLineSize(i2);
            float strokeWidth = i2 == i + (-1) ? (i2 * f) - this.scaleLinePaint.getStrokeWidth() : i2 * f;
            float f3 = scaleLineSize / f2;
            canvas.drawLine(width - f3, strokeWidth, width + f3, strokeWidth, this.scaleLinePaint);
            i2++;
        }
    }

    private final void drawColumns(Canvas canvas) {
        String[] strArr = this.columnContents;
        Intrinsics.checkNotNull(strArr);
        int length = strArr.length;
        float width = getWidth() / (length - 1);
        HorizontalParam horizontalParam = this.horizontal;
        if ((horizontalParam != null ? horizontalParam.getAcquireMode() : null) != ServiceEnum.AcquireMode.Acquire_Ultra || !this.isMain) {
            drawColumnContents(length, canvas, width);
        }
        drawColumnLines(length, width, canvas);
    }

    private final void drawColumnContents(int i, Canvas canvas, float f) {
        int i2;
        float width;
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.columnContents;
        Intrinsics.checkNotNull(strArr);
        for (String str : strArr) {
            sb.append(str);
        }
        float measureText = this.columnTextPaint.measureText(sb.toString());
        if (measureText > getWidth()) {
            if (measureText % getWidth() == 0.0f) {
                width = measureText / getWidth();
            } else {
                width = (measureText / getWidth()) + 1;
            }
            i2 = (int) width;
        } else {
            i2 = ((float) getWidth()) - measureText < ((float) 30) ? 2 : 1;
        }
        int i3 = i / i2;
        if (i % i2 != 0) {
            i3++;
        }
        int i4 = i / 2;
        if (i % 2 != 0) {
            i4++;
        }
        if (this.isShowRuler) {
            int i5 = 1;
            for (int i6 = i3 - 2; i5 < i4 && i6 >= 0; i6 -= 2) {
                if (i5 == 0) {
                    if (this.fromStart) {
                        drawColumn(canvas, f, (i - 1) - i5);
                    } else {
                        drawColumn(canvas, f, i5);
                    }
                } else {
                    drawColumn(canvas, f, i5);
                    drawColumn(canvas, f, (i - 1) - i5);
                }
                i5 += i2;
            }
            if (this.isShowAllCol) {
                drawColumn(canvas, f, 0);
                drawColumn(canvas, f, i - 1);
            }
        }
    }

    private final void drawColumn(Canvas canvas, float f, int i) {
        String[] strArr = this.columnContents;
        Intrinsics.checkNotNull(strArr);
        String str = strArr[i];
        if (TextUtils.isEmpty(str)) {
            return;
        }
        float f2 = i * f;
        float measureText = this.columnTextPaint.measureText(str);
        if (i == 0) {
            canvas.drawText(str, 10.0f, this.fromTop ? 16.0f : getHeight(), this.columnTextPaint);
            canvas.drawText(str, 10.0f, this.fromTop ? 16.0f : getHeight(), this.columnTextPaint);
            return;
        }
        String[] strArr2 = this.columnContents;
        Intrinsics.checkNotNull(strArr2);
        if (i == strArr2.length - 1) {
            canvas.drawText(str, (f2 - measureText) - 10.0f, this.fromTop ? 16.0f : getHeight(), this.columnTextPaint);
        } else {
            canvas.drawText(str, f2 - (measureText / 2), this.fromTop ? 16.0f : getHeight() - 10.0f, this.columnTextPaint);
        }
    }

    private final void drawColumnLines(int i, float f, Canvas canvas) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        if (this.isShowLine) {
            if (this.type == ServiceEnum.EWaveGrids.GRID_IS_FULL) {
                int i2 = i - 1;
                for (int i3 = 1; i3 < i2; i3++) {
                    if (i % 2 == 0 || i3 != i2 / 2) {
                        drawColumnLine(i3, f, canvas);
                    }
                }
                Intrinsics.checkNotNull(this.rowContents);
                float height = (getHeight() / (strArr3.length - 1)) / 5;
                String[] strArr4 = this.rowContents;
                Intrinsics.checkNotNull(strArr4);
                drawColumnMiddleScale(height, ((strArr4.length - 1) * 5) + 1, canvas);
            } else if (this.type == ServiceEnum.EWaveGrids.GRID_IS_HALF) {
                Intrinsics.checkNotNull(this.rowContents);
                float height2 = (getHeight() / (strArr.length - 1)) / 5;
                String[] strArr5 = this.rowContents;
                Intrinsics.checkNotNull(strArr5);
                drawColumnMiddleScale(height2, ((strArr5.length - 1) * 5) + 1, canvas);
            }
            Intrinsics.checkNotNull(this.rowContents);
            float height3 = (getHeight() / (strArr2.length - 1)) / 5;
            String[] strArr6 = this.rowContents;
            Intrinsics.checkNotNull(strArr6);
            drawColumnSideScaleLine(height3, ((strArr6.length - 1) * 5) + 1, canvas);
        }
    }

    private final void drawColumnLine(int i, float f, Canvas canvas) {
        float f2 = i * f;
        this.path.reset();
        this.path.moveTo(f2, 0);
        this.path.lineTo(f2, getHeight());
        canvas.drawPath(this.path, this.columnLinePaint);
    }

    /* compiled from: GridRulerView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/rigol/scope/views/grid/GridRulerView$Companion;", "", "()V", "DEFAULT_DASH_PATH_EFFECT", "Landroid/graphics/PathEffect;", "getDEFAULT_DASH_PATH_EFFECT", "()Landroid/graphics/PathEffect;", "DEFAULT_PADDING", "", "DEFAULT_TEXT_SIZE", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PathEffect getDEFAULT_DASH_PATH_EFFECT() {
            return GridRulerView.DEFAULT_DASH_PATH_EFFECT;
        }
    }
}
