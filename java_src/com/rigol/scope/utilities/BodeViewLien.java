package com.rigol.scope.utilities;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: BodeViewLien.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001e\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\tJ\u001e\u0010`\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\tJ\u0010\u0010a\u001a\u00020]2\u0006\u0010b\u001a\u00020cH\u0014J\u0018\u0010d\u001a\u00020]2\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tH\u0014J(\u0010g\u001a\u00020]2\u0006\u0010h\u001a\u00020\t2\u0006\u0010i\u001a\u00020\t2\u0006\u0010j\u001a\u00020\t2\u0006\u0010k\u001a\u00020\tH\u0014J\u0006\u0010l\u001a\u00020]J.\u0010m\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010n\u001a\u00020\u001b2\u0006\u0010o\u001a\u00020\tJ\u0006\u0010p\u001a\u00020]J\u0016\u0010q\u001a\u00020]2\u0006\u0010^\u001a\u00020\u00182\u0006\u0010_\u001a\u00020\u0018J\u000e\u0010r\u001a\u00020]2\u0006\u0010s\u001a\u00020\tR\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010#\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\u001a\u0010&\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010*R\u001a\u0010.\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u001a\u00101\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R*\u00107\u001a\u0012\u0012\u0004\u0012\u00020\u001808j\b\u0012\u0004\u0012\u00020\u0018`9X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R*\u0010>\u001a\u0012\u0012\u0004\u0012\u00020\u001808j\b\u0012\u0004\u0012\u00020\u0018`9X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R\u001a\u0010A\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u000b\"\u0004\bC\u0010\rR\u001a\u0010D\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010(\"\u0004\bF\u0010*R\u001a\u0010G\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u001c\"\u0004\bI\u0010\u001eR\u001a\u0010J\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010(\"\u0004\bL\u0010*R\u001a\u0010M\u001a\u00020NX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010V\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010(\"\u0004\bX\u0010*R\u001a\u0010Y\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010(\"\u0004\b[\u0010*¨\u0006t"}, d2 = {"Lcom/rigol/scope/utilities/BodeViewLien;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "basis_times", "", "getBasis_times", "()I", "setBasis_times", "(I)V", "bodeDataGain", "getBodeDataGain", "setBodeDataGain", "bodeParam", "Lcom/rigol/scope/data/BodeParam;", "getBodeParam", "()Lcom/rigol/scope/data/BodeParam;", "setBodeParam", "(Lcom/rigol/scope/data/BodeParam;)V", "bode_lienX", "", "bodephase", "isReset", "", "()Z", "setReset", "(Z)V", "isShowCircle", "setShowCircle", "linePaint", "Landroid/graphics/Paint;", "mCount", "getMCount", "setMCount", "newx", "getNewx", "()F", "setNewx", "(F)V", "newy", "getNewy", "setNewy", "oldX", "getOldX", "setOldX", "oldy", "getOldy", "setOldy", "path", "Landroid/graphics/Path;", "path_line", "position_listx", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPosition_listx", "()Ljava/util/ArrayList;", "setPosition_listx", "(Ljava/util/ArrayList;)V", "position_listy", "getPosition_listy", "setPosition_listy", "spacing", "getSpacing", "setSpacing", "spacing_height", "getSpacing_height", "setSpacing_height", "spacing_lien", "getSpacing_lien", "setSpacing_lien", "spacing_width", "getSpacing_width", "setSpacing_width", "startFreq", "", "getStartFreq", "()J", "setStartFreq", "(J)V", "syncDataViewModel", "Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "textPaint", "xCircle", "getXCircle", "setXCircle", "yCircle", "getYCircle", "setYCircle", "drawBodeLien", "", "floatx", "floaty", "drawBodeLien1", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "resetLien", "resetdrawBodeLien", "last_boolean", "firstOne", "resetisShowCircleS", "setCircle", "setColor", "colors", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class BodeViewLien extends View {
    private int basis_times;
    private int bodeDataGain;
    private BodeParam bodeParam;
    private float bode_lienX;
    private int bodephase;
    private boolean isReset;
    private boolean isShowCircle;
    private final Paint linePaint;
    private int mCount;
    private float newx;
    private float newy;
    private float oldX;
    private float oldy;
    private final Path path;
    private final Path path_line;
    private ArrayList<Float> position_listx;
    private ArrayList<Float> position_listy;
    private int spacing;
    private float spacing_height;
    private boolean spacing_lien;
    private float spacing_width;
    private long startFreq;
    private SyncDataViewModel syncDataViewModel;
    private final Paint textPaint;
    private float xCircle;
    private float yCircle;

    public final int getSpacing() {
        return this.spacing;
    }

    public final void setSpacing(int i) {
        this.spacing = i;
    }

    public final float getSpacing_width() {
        return this.spacing_width;
    }

    public final void setSpacing_width(float f) {
        this.spacing_width = f;
    }

    public final float getSpacing_height() {
        return this.spacing_height;
    }

    public final void setSpacing_height(float f) {
        this.spacing_height = f;
    }

    public final boolean getSpacing_lien() {
        return this.spacing_lien;
    }

    public final void setSpacing_lien(boolean z) {
        this.spacing_lien = z;
    }

    public final int getMCount() {
        return this.mCount;
    }

    public final void setMCount(int i) {
        this.mCount = i;
    }

    public final float getOldX() {
        return this.oldX;
    }

    public final void setOldX(float f) {
        this.oldX = f;
    }

    public final float getOldy() {
        return this.oldy;
    }

    public final void setOldy(float f) {
        this.oldy = f;
    }

    public final float getNewx() {
        return this.newx;
    }

    public final void setNewx(float f) {
        this.newx = f;
    }

    public final float getNewy() {
        return this.newy;
    }

    public final void setNewy(float f) {
        this.newy = f;
    }

    public final ArrayList<Float> getPosition_listx() {
        return this.position_listx;
    }

    public final void setPosition_listx(ArrayList<Float> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.position_listx = arrayList;
    }

    public final ArrayList<Float> getPosition_listy() {
        return this.position_listy;
    }

    public final void setPosition_listy(ArrayList<Float> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.position_listy = arrayList;
    }

    public final int getBodeDataGain() {
        return this.bodeDataGain;
    }

    public final void setBodeDataGain(int i) {
        this.bodeDataGain = i;
    }

    public final long getStartFreq() {
        return this.startFreq;
    }

    public final void setStartFreq(long j) {
        this.startFreq = j;
    }

    public final float getXCircle() {
        return this.xCircle;
    }

    public final void setXCircle(float f) {
        this.xCircle = f;
    }

    public final float getYCircle() {
        return this.yCircle;
    }

    public final void setYCircle(float f) {
        this.yCircle = f;
    }

    public final boolean isShowCircle() {
        return this.isShowCircle;
    }

    public final void setShowCircle(boolean z) {
        this.isShowCircle = z;
    }

    public final boolean isReset() {
        return this.isReset;
    }

    public final void setReset(boolean z) {
        this.isReset = z;
    }

    public final int getBasis_times() {
        return this.basis_times;
    }

    public final void setBasis_times(int i) {
        this.basis_times = i;
    }

    public final BodeParam getBodeParam() {
        return this.bodeParam;
    }

    public final void setBodeParam(BodeParam bodeParam) {
        this.bodeParam = bodeParam;
    }

    public BodeViewLien(Context context) {
        super(context);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2.0f);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.textPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2.0f);
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        paint2.setAntiAlias(true);
        Unit unit2 = Unit.INSTANCE;
        this.linePaint = paint2;
        this.spacing_lien = true;
        this.oldy = 90.0f;
        this.newy = 90.0f;
        this.position_listx = new ArrayList<>();
        this.position_listy = new ArrayList<>();
        this.path = new Path();
        this.bodephase = 60;
        this.path_line = new Path();
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.bodeParam = ((BodeViewModel) ContextUtil.getAppViewModel(BodeViewModel.class)).getValue();
    }

    public BodeViewLien(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2.0f);
        paint.setColor(-1);
        paint.setAntiAlias(true);
        Unit unit = Unit.INSTANCE;
        this.textPaint = paint;
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth(2.0f);
        paint2.setColor(SupportMenu.CATEGORY_MASK);
        paint2.setAntiAlias(true);
        Unit unit2 = Unit.INSTANCE;
        this.linePaint = paint2;
        this.spacing_lien = true;
        this.oldy = 90.0f;
        this.newy = 90.0f;
        this.position_listx = new ArrayList<>();
        this.position_listy = new ArrayList<>();
        this.path = new Path();
        this.bodephase = 60;
        this.path_line = new Path();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!this.isReset) {
            this.path_line.moveTo(this.oldX + 120.0f, this.oldy);
            this.path_line.lineTo(this.oldX + 120.0f, this.oldy);
            this.path_line.lineTo(this.newx + 120.0f, this.newy);
            canvas.drawPath(this.path_line, this.linePaint);
            this.oldX = this.newx;
            this.oldy = this.newy;
        } else if (this.mCount < this.position_listx.size()) {
            postDelayed(new Runnable() { // from class: com.rigol.scope.utilities.BodeViewLien$onDraw$1
                @Override // java.lang.Runnable
                public final void run() {
                    Path path;
                    Path path2;
                    path = BodeViewLien.this.path_line;
                    path.moveTo(BodeViewLien.this.getOldX() + 120.0f, BodeViewLien.this.getOldy());
                    path2 = BodeViewLien.this.path_line;
                    Float f = BodeViewLien.this.getPosition_listy().get(BodeViewLien.this.getMCount());
                    Intrinsics.checkNotNullExpressionValue(f, "position_listy[mCount]");
                    path2.lineTo(BodeViewLien.this.getPosition_listx().get(BodeViewLien.this.getMCount()).floatValue() + 120.0f, f.floatValue());
                    BodeViewLien bodeViewLien = BodeViewLien.this;
                    Float f2 = bodeViewLien.getPosition_listx().get(BodeViewLien.this.getMCount());
                    Intrinsics.checkNotNullExpressionValue(f2, "position_listx[mCount]");
                    bodeViewLien.setOldX(f2.floatValue());
                    BodeViewLien bodeViewLien2 = BodeViewLien.this;
                    Float f3 = bodeViewLien2.getPosition_listy().get(BodeViewLien.this.getMCount());
                    Intrinsics.checkNotNullExpressionValue(f3, "position_listy[mCount]");
                    bodeViewLien2.setOldy(f3.floatValue());
                    BodeViewLien bodeViewLien3 = BodeViewLien.this;
                    bodeViewLien3.setMCount(bodeViewLien3.getMCount() + 1);
                    BodeViewLien.this.postInvalidate();
                }
            }, 1L);
        } else {
            canvas.drawPath(this.path_line, this.linePaint);
            this.isReset = false;
            this.mCount = 0;
        }
        if (this.isShowCircle) {
            canvas.drawCircle(this.xCircle + 120.0f, this.yCircle, 4.0f, this.textPaint);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.spacing_width = View.MeasureSpec.getSize(i);
        this.spacing_height = View.MeasureSpec.getSize(i2) - 30;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.spacing_width = i;
        this.spacing_height = i2 - 30;
    }

    public final void drawBodeLien(float f, float f2, int i) {
        float f3;
        BodeParam bodeParam;
        BodeParam bodeParam2;
        this.bodeDataGain = i;
        this.spacing_lien = false;
        BodeParam bodeParam3 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam3);
        long bodeStartFreq = bodeParam3.getBodeStartFreq();
        this.position_listx.add(Float.valueOf(f));
        this.position_listy.add(Float.valueOf(f2));
        BodeParam bodeParam4 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam4);
        int i2 = -1;
        if (bodeParam4.getPosition_listx().size() == 0) {
            Intrinsics.checkNotNull(this.bodeParam);
            BodeParam bodeParam5 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam5);
            this.newx = (float) (((float) (bodeParam2.getSpacing_width_unit() * (-1))) + ((f / (((float) bodeStartFreq) * 1.00000005d)) * bodeParam5.getSpacing_width_unit()));
            BodeParam bodeParam6 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam6);
            float f4 = 50;
            this.newy = (((bodeParam6.getSpacing_width_middley() - f4) * (i - f2)) / (i * 2)) + f4;
            BodeParam bodeParam7 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam7);
            bodeParam7.getPosition_listx().add(Float.valueOf(this.newx));
            BodeParam bodeParam8 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam8);
            bodeParam8.getPosition_listy().add(Float.valueOf(this.newy));
            if (this.oldX == 0.0f) {
                this.oldy = this.newy;
                this.oldX = this.newx;
            }
        } else {
            do {
                bodeStartFreq *= 10;
                i2++;
                f3 = (float) bodeStartFreq;
            } while (f3 < f);
            Intrinsics.checkNotNull(this.bodeParam);
            double d = f / f3;
            BodeParam bodeParam9 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam9);
            this.newx = (float) (((float) (bodeParam.getSpacing_width_unit() * i2)) + (d * bodeParam9.getSpacing_width_unit()));
            BodeParam bodeParam10 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam10);
            float f5 = 50;
            this.newy = (((bodeParam10.getSpacing_width_middley() - f5) * (i - f2)) / (i * 2)) + f5;
            BodeParam bodeParam11 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam11);
            bodeParam11.getPosition_listx().add(Float.valueOf(this.newx));
            BodeParam bodeParam12 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam12);
            bodeParam12.getPosition_listy().add(Float.valueOf(this.newy));
            if (this.oldX == 0.0f) {
                this.oldy = this.newy;
                this.oldX = this.newx;
            }
        }
        postInvalidateDelayed(50L);
    }

    public final void drawBodeLien1(float f, float f2, int i) {
        float f3;
        BodeParam bodeParam;
        BodeParam bodeParam2;
        this.bodeDataGain = i;
        this.spacing_lien = false;
        BodeParam bodeParam3 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam3);
        long bodeStartFreq = bodeParam3.getBodeStartFreq();
        this.position_listx.add(Float.valueOf(f));
        this.position_listy.add(Float.valueOf(f2));
        BodeParam bodeParam4 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam4);
        int i2 = -1;
        if (bodeParam4.getPosition_listx().size() == 1) {
            Intrinsics.checkNotNull(this.bodeParam);
            BodeParam bodeParam5 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam5);
            this.newx = (float) (((float) (bodeParam2.getSpacing_width_unit() * (-1))) + ((f / (((float) bodeStartFreq) * 1.00000005d)) * bodeParam5.getSpacing_width_unit()));
            BodeParam bodeParam6 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam6);
            float f4 = 50;
            float spacing_width_middley = (((bodeParam6.getSpacing_width_middley() - f4) * (i - f2)) / (i * 2)) + f4;
            this.newy = spacing_width_middley;
            if (this.oldX == 0.0f) {
                this.oldy = spacing_width_middley;
                this.oldX = this.newx;
            }
        } else {
            do {
                bodeStartFreq *= 10;
                i2++;
                f3 = (float) bodeStartFreq;
            } while (f3 < f);
            Intrinsics.checkNotNull(this.bodeParam);
            double d = f / f3;
            BodeParam bodeParam7 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam7);
            this.newx = (float) (((float) (bodeParam.getSpacing_width_unit() * i2)) + (d * bodeParam7.getSpacing_width_unit()));
            BodeParam bodeParam8 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam8);
            float f5 = 50;
            float spacing_width_middley2 = (((bodeParam8.getSpacing_width_middley() - f5) * (i - f2)) / (i * 2)) + f5;
            this.newy = spacing_width_middley2;
            LogUtils.e("spacing_width_middley", Float.valueOf(spacing_width_middley2));
            if (this.oldX == 0.0f) {
                this.oldy = this.newy;
                this.oldX = this.newx;
            }
        }
        invalidate();
    }

    public final void resetdrawBodeLien(float f, float f2, int i, boolean z, int i2) {
        float f3;
        BodeParam bodeParam;
        this.bodeDataGain = i;
        this.spacing_lien = false;
        BodeParam bodeParam2 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam2);
        long bodeStartFreq = bodeParam2.getBodeStartFreq();
        if (i2 == 0) {
            this.position_listx.clear();
            this.position_listy.clear();
            BodeParam bodeParam3 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam3);
            bodeParam3.getPosition_listx().clear();
            BodeParam bodeParam4 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam4);
            bodeParam4.getPosition_listy().clear();
        }
        BodeParam bodeParam5 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam5);
        int i3 = -1;
        if (bodeParam5.getPosition_listx().size() == 0) {
            BodeParam bodeParam6 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam6);
            double spacing_width_unit = (float) (bodeParam6.getSpacing_width_unit() * (-1));
            double d = f / ((float) bodeStartFreq);
            BodeParam bodeParam7 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam7);
            this.newx = (float) (spacing_width_unit + (d * bodeParam7.getSpacing_width_unit()));
            BodeParam bodeParam8 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam8);
            float f4 = 50;
            this.newy = (((bodeParam8.getSpacing_width_middley() - f4) * (i - f2)) / (i * 2)) + f4;
            BodeParam bodeParam9 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam9);
            bodeParam9.getPosition_listx().add(Float.valueOf(this.newx));
            BodeParam bodeParam10 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam10);
            bodeParam10.getPosition_listy().add(Float.valueOf(this.newy));
            if (this.oldX == 0.0f) {
                this.oldy = this.newy;
                this.oldX = this.newx;
            }
        } else {
            do {
                bodeStartFreq *= 10;
                i3++;
                f3 = (float) bodeStartFreq;
            } while (f3 < f);
            Intrinsics.checkNotNull(this.bodeParam);
            double d2 = f / f3;
            BodeParam bodeParam11 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam11);
            this.newx = (float) (((float) (bodeParam.getSpacing_width_unit() * i3)) + (d2 * bodeParam11.getSpacing_width_unit()));
            BodeParam bodeParam12 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam12);
            float f5 = 50;
            this.newy = (((bodeParam12.getSpacing_width_middley() - f5) * (i - f2)) / (i * 2)) + f5;
            BodeParam bodeParam13 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam13);
            bodeParam13.getPosition_listx().add(Float.valueOf(this.newx));
            BodeParam bodeParam14 = this.bodeParam;
            Intrinsics.checkNotNull(bodeParam14);
            bodeParam14.getPosition_listy().add(Float.valueOf(this.newy));
            if (this.oldX == 0.0f) {
                this.oldy = this.newy;
                this.oldX = this.newx;
            }
        }
        this.position_listx.add(Float.valueOf(this.newx));
        this.position_listy.add(Float.valueOf(this.newy));
        if (z) {
            invalidate();
        }
    }

    public final void resetLien() {
        this.oldX = 0.0f;
        this.oldy = 90.0f;
        this.newx = 0.0f;
        this.newy = 90.0f;
        this.path_line.reset();
        this.position_listx.clear();
        this.position_listy.clear();
        invalidate();
    }

    public final void setColor(int i) {
        this.linePaint.setColor(i);
    }

    public final void setCircle(float f, float f2) {
        float f3;
        BodeParam bodeParam;
        int i;
        BodeParam bodeParam2 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam2);
        long bodeStartFreq = bodeParam2.getBodeStartFreq();
        int i2 = -1;
        do {
            bodeStartFreq *= 10;
            i2++;
            f3 = (float) bodeStartFreq;
        } while (f3 < f);
        Intrinsics.checkNotNull(this.bodeParam);
        double d = f / f3;
        BodeParam bodeParam3 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam3);
        this.xCircle = (float) (((float) (bodeParam.getSpacing_width_unit() * i2)) + (d * bodeParam3.getSpacing_width_unit()));
        BodeParam bodeParam4 = this.bodeParam;
        Intrinsics.checkNotNull(bodeParam4);
        float f4 = 50;
        this.yCircle = (((bodeParam4.getSpacing_width_middley() - f4) * (this.bodeDataGain - f2)) / (i * 2)) + f4;
        this.isShowCircle = true;
        invalidate();
    }

    public final void resetisShowCircleS() {
        this.isShowCircle = false;
    }
}
