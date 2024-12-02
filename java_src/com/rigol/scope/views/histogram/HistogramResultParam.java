package com.rigol.scope.views.histogram;

import androidx.collection.SparseArrayCompat;
import androidx.databinding.Bindable;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.data.ThreeTuple;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: HistogramResultParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010\t\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b(\n\u0002\u0010\u0011\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010|\u001a\u00020}H\u0016J\u0006\u0010~\u001a\u00020\nJ\u0006\u0010\u007f\u001a\u00020 J\u0007\u0010\u0080\u0001\u001a\u00020\nJ\u0007\u0010\u0081\u0001\u001a\u00020}J\u0007\u0010\u0082\u0001\u001a\u00020\nJ\u0007\u0010\u0083\u0001\u001a\u00020EJ\t\u0010\u0084\u0001\u001a\u00020}H\u0002J\u0007\u0010\u0085\u0001\u001a\u00020EJ\t\u0010\u0086\u0001\u001a\u00020}H\u0002J\u0007\u0010\u0087\u0001\u001a\u00020EJ\t\u0010\u0088\u0001\u001a\u00020}H\u0002J\u0007\u0010\u0089\u0001\u001a\u00020EJ\t\u0010\u008a\u0001\u001a\u00020}H\u0002J\u0007\u0010\u008b\u0001\u001a\u00020\nJ\u0007\u0010\u008c\u0001\u001a\u00020\u0014J\u0007\u0010\u008d\u0001\u001a\u00020\nJ\t\u0010\u008e\u0001\u001a\u0004\u0018\u00010pJ\u0007\u0010\u008f\u0001\u001a\u00020}J\t\u0010\u0090\u0001\u001a\u00020}H\u0016J\u0007\u0010\u0091\u0001\u001a\u00020}J\u0007\u0010\u0092\u0001\u001a\u00020}J\u0007\u0010\u0093\u0001\u001a\u00020}J\u0007\u0010\u0094\u0001\u001a\u00020}J\u0007\u0010\u0095\u0001\u001a\u00020}J\u0007\u0010\u0096\u0001\u001a\u00020}J\u000f\u0010\u0097\u0001\u001a\u00020}2\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u0098\u0001\u001a\u00020}2\u0007\u0010\u0099\u0001\u001a\u00020 J\u000f\u0010\u009a\u0001\u001a\u00020}2\u0006\u0010&\u001a\u00020\nJ\u000f\u0010\u009b\u0001\u001a\u00020}2\u0006\u0010.\u001a\u00020\nJ\u000f\u0010\u009c\u0001\u001a\u00020}2\u0006\u0010F\u001a\u00020EJ\u000f\u0010\u009d\u0001\u001a\u00020}2\u0006\u0010M\u001a\u00020EJ\u000f\u0010\u009e\u0001\u001a\u00020}2\u0006\u0010R\u001a\u00020EJ\u000f\u0010\u009f\u0001\u001a\u00020}2\u0006\u0010W\u001a\u00020EJ\u000f\u0010 \u0001\u001a\u00020}2\u0006\u0010\\\u001a\u00020\nJ\u0010\u0010¡\u0001\u001a\u00020}2\u0007\u0010¢\u0001\u001a\u00020\u0014J\u000f\u0010£\u0001\u001a\u00020}2\u0006\u0010k\u001a\u00020\nJ\u000f\u0010¤\u0001\u001a\u00020}2\u0006\u0010q\u001a\u00020pJ\u001e\u0010¥\u0001\u001a\u00020}2\u000f\u0010\u001a\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00040¦\u0001¢\u0006\u0003\u0010§\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u00148G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R)\u0010\u001a\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001d0\u001c0\u001b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR&\u0010!\u001a\u00020 2\u0006\u0010\t\u001a\u00020 8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010&\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\r\"\u0004\b(\u0010\u000fR\u0011\u0010)\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0013R\u001c\u0010+\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010\bR&\u0010.\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000fR\u0011\u00101\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0013R\u001c\u00103\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u0006\"\u0004\b5\u0010\bR\u001c\u00106\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u0006\"\u0004\b8\u0010\bR\u001c\u00109\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0006\"\u0004\b;\u0010\bR\u001c\u0010<\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0006\"\u0004\b>\u0010\bR\u001c\u0010?\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u0006\"\u0004\bA\u0010\bR\u001c\u0010B\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0006\"\u0004\bD\u0010\bR&\u0010F\u001a\u00020E2\u0006\u0010\t\u001a\u00020E8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u0011\u0010K\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bL\u0010\u0013R&\u0010M\u001a\u00020E2\u0006\u0010\t\u001a\u00020E8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010H\"\u0004\bO\u0010JR\u0011\u0010P\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bQ\u0010\u0013R&\u0010R\u001a\u00020E2\u0006\u0010\t\u001a\u00020E8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010H\"\u0004\bT\u0010JR\u0011\u0010U\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bV\u0010\u0013R&\u0010W\u001a\u00020E2\u0006\u0010\t\u001a\u00020E8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010H\"\u0004\bY\u0010JR\u0011\u0010Z\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b[\u0010\u0013R&\u0010\\\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\r\"\u0004\b^\u0010\u000fR\u0011\u0010_\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b`\u0010\u0013R\u001c\u0010a\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0006\"\u0004\bc\u0010\bR\u0017\u0010d\u001a\b\u0012\u0004\u0012\u00020\u00040e¢\u0006\b\n\u0000\u001a\u0004\bf\u0010gR\u001c\u0010h\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0006\"\u0004\bj\u0010\bR&\u0010k\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\r\"\u0004\bm\u0010\u000fR\u0011\u0010n\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\bo\u0010\u0013R*\u0010q\u001a\u0004\u0018\u00010p2\b\u0010\t\u001a\u0004\u0018\u00010p8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR&\u0010w\u001a\u00020v2\u0006\u0010\t\u001a\u00020v8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010y\"\u0004\bz\u0010{¨\u0006¨\u0001"}, d2 = {"Lcom/rigol/scope/views/histogram/HistogramResultParam;", "Lcom/rigol/scope/data/ResultParam;", "()V", "binWidth", "", "getBinWidth", "()Ljava/lang/String;", "setBinWidth", "(Ljava/lang/String;)V", "value", "", "bottom", "getBottom", "()I", "setBottom", "(I)V", "bottomAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getBottomAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "chan", "getChan", "()Lcom/rigol/scope/cil/ServiceEnum$Chan;", "setChan", "(Lcom/rigol/scope/cil/ServiceEnum$Chan;)V", "data", "", "Lcom/rigol/scope/data/ThreeTuple;", "", "getData", "()Ljava/util/List;", "", "enable", "getEnable", "()Z", "setEnable", "(Z)V", "height", "getHeight", "setHeight", "heightAttr", "getHeightAttr", "hmode", "getHmode", "setHmode", "left", "getLeft", "setLeft", "leftAttr", "getLeftAttr", "max", "getMax", "setMax", "mean", "getMean", "setMean", "median", "getMedian", "setMedian", "min", "getMin", "setMin", "peaks", "getPeaks", "setPeaks", "pkpk", "getPkpk", "setPkpk", "", "realBottom", "getRealBottom", "()J", "setRealBottom", "(J)V", "realBottomAttr", "getRealBottomAttr", "realLeft", "getRealLeft", "setRealLeft", "realLeftAttr", "getRealLeftAttr", "realRight", "getRealRight", "setRealRight", "realRightAttr", "getRealRightAttr", "realTop", "getRealTop", "setRealTop", "realTopAttr", "getRealTopAttr", "right", "getRight", "setRight", "rightAttr", "getRightAttr", "sigma", "getSigma", "setSigma", "sourceArray", "Landroidx/collection/SparseArrayCompat;", "getSourceArray", "()Landroidx/collection/SparseArrayCompat;", "sum", "getSum", "setSum", "top", "getTop", "setTop", "topAttr", "getTopAttr", "Lcom/rigol/scope/cil/ServiceEnum$HistoType;", "type", "getType", "()Lcom/rigol/scope/cil/ServiceEnum$HistoType;", "setType", "(Lcom/rigol/scope/cil/ServiceEnum$HistoType;)V", "Lcom/rigol/scope/cil/ServiceEnum$Unit;", "verUnit", "getVerUnit", "()Lcom/rigol/scope/cil/ServiceEnum$Unit;", "setVerUnit", "(Lcom/rigol/scope/cil/ServiceEnum$Unit;)V", "readAll", "", "readBottomPosition", "readEnable", "readHeight", "readHeightAttr", "readLeftPosition", "readRealBottom", "readRealBottomAttr", "readRealLeft", "readRealLeftAttr", "readRealRight", "readRealRightAttr", "readRealTop", "readRealTopAttr", "readRightPosition", "readSource", "readTopPosition", "readType", "remove", "reset", "resetHistoStatis", "resetSaveHeight", "resetSaveRealBottom", "resetSaveRealLeft", "resetSaveRealRight", "resetSaveRealTop", "saveBottomPosition", "saveEnable", "isEnable", "saveHeight", "saveLeftPosition", "saveRealBottom", "saveRealLeft", "saveRealRight", "saveRealTop", "saveRightPosition", "saveSource", "source", "saveTopPosition", "saveType", "setData", "", "([Ljava/lang/String;)V", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HistogramResultParam extends ResultParam {
    private transient String binWidth;
    private int bottom;
    private final transient MessageAttr bottomAttr;
    private ServiceEnum.Chan chan;
    private boolean enable;
    private int height;
    private final transient MessageAttr heightAttr;
    private transient String hmode;
    private int left;
    private final transient MessageAttr leftAttr;
    private transient String max;
    private transient String mean;
    private transient String median;
    private transient String min;
    private transient String peaks;
    private transient String pkpk;
    private long realBottom;
    private final transient MessageAttr realBottomAttr;
    private long realLeft;
    private final transient MessageAttr realLeftAttr;
    private long realRight;
    private final transient MessageAttr realRightAttr;
    private long realTop;
    private final transient MessageAttr realTopAttr;
    private int right;
    private final transient MessageAttr rightAttr;
    private transient String sigma;
    private final transient SparseArrayCompat<String> sourceArray;
    private transient String sum;
    private int top;
    private final transient MessageAttr topAttr;
    private ServiceEnum.HistoType type;
    private ServiceEnum.Unit verUnit;

    public HistogramResultParam() {
        super(34);
        ServiceEnum.HistoType histoType;
        ServiceEnum.Chan chan;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        long j2;
        long j3;
        long j4;
        boolean z;
        histoType = HistogramResultParamKt.DEFAULT_HISTO_TYPE;
        this.type = histoType;
        chan = HistogramResultParamKt.DEFAULT_HISTO_CHAN;
        this.chan = chan;
        i = HistogramResultParamKt.DEFAULT_HISTO_HEIGHT;
        this.height = i;
        i2 = HistogramResultParamKt.DEFAULT_HISTO_LEFT;
        this.left = i2;
        i3 = HistogramResultParamKt.DEFAULT_HISTO_RIGHT;
        this.right = i3;
        i4 = HistogramResultParamKt.DEFAULT_HISTO_TOP;
        this.top = i4;
        i5 = HistogramResultParamKt.DEFAULT_HISTO_BOTTOM;
        this.bottom = i5;
        j = HistogramResultParamKt.DEFAULT_HISTO_REAL_LEFT;
        this.realLeft = j;
        j2 = HistogramResultParamKt.DEFAULT_HISTO_REAL_RIGHT;
        this.realRight = j2;
        j3 = HistogramResultParamKt.DEFAULT_HISTO_REAL_TOP;
        this.realTop = j3;
        j4 = HistogramResultParamKt.DEFAULT_HISTO_REAL_BOTTOM;
        this.realBottom = j4;
        z = HistogramResultParamKt.DEFAULT_HISTO_ENABLE;
        this.enable = z;
        this.verUnit = ServiceEnum.Unit.Unit_V;
        this.heightAttr = new MessageAttr();
        this.leftAttr = new MessageAttr();
        this.rightAttr = new MessageAttr();
        this.topAttr = new MessageAttr();
        this.bottomAttr = new MessageAttr();
        this.realLeftAttr = new MessageAttr();
        this.realRightAttr = new MessageAttr();
        this.realTopAttr = new MessageAttr();
        this.realBottomAttr = new MessageAttr();
        this.sourceArray = new SparseArrayCompat<>();
        for (MappingObject mappingObject : ViewUtil.getList((int) R.array.msg_histo_source)) {
            SparseArrayCompat<String> sparseArrayCompat = this.sourceArray;
            Intrinsics.checkNotNullExpressionValue(mappingObject, "mappingObject");
            sparseArrayCompat.append(mappingObject.getValue(), mappingObject.getStr());
        }
    }

    @Bindable
    public final ServiceEnum.HistoType getType() {
        return this.type;
    }

    public final void setType(ServiceEnum.HistoType histoType) {
        this.type = histoType;
        notifyPropertyChanged(978);
    }

    @Bindable
    public final ServiceEnum.Chan getChan() {
        return this.chan;
    }

    public final void setChan(ServiceEnum.Chan value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.chan = value;
        notifyPropertyChanged(152);
    }

    @Bindable
    public final int getHeight() {
        return this.height;
    }

    public final void setHeight(int i) {
        this.height = i;
        notifyPropertyChanged(369);
    }

    @Bindable
    public final int getLeft() {
        return this.left;
    }

    public final void setLeft(int i) {
        this.left = i;
        notifyPropertyChanged(482);
    }

    @Bindable
    public final int getRight() {
        return this.right;
    }

    public final void setRight(int i) {
        this.right = i;
        notifyPropertyChanged(740);
    }

    @Bindable
    public final int getTop() {
        return this.top;
    }

    public final void setTop(int i) {
        this.top = i;
        notifyPropertyChanged(940);
    }

    @Bindable
    public final int getBottom() {
        return this.bottom;
    }

    public final void setBottom(int i) {
        this.bottom = i;
        notifyPropertyChanged(121);
    }

    @Bindable
    public final long getRealLeft() {
        return this.realLeft;
    }

    public final void setRealLeft(long j) {
        this.realLeft = j;
        notifyPropertyChanged(690);
    }

    @Bindable
    public final long getRealRight() {
        return this.realRight;
    }

    public final void setRealRight(long j) {
        this.realRight = j;
        notifyPropertyChanged(691);
    }

    @Bindable
    public final long getRealTop() {
        return this.realTop;
    }

    public final void setRealTop(long j) {
        this.realTop = j;
        notifyPropertyChanged(693);
    }

    @Bindable
    public final long getRealBottom() {
        return this.realBottom;
    }

    public final void setRealBottom(long j) {
        this.realBottom = j;
        notifyPropertyChanged(689);
    }

    @Bindable
    public final boolean getEnable() {
        return this.enable;
    }

    public final void setEnable(boolean z) {
        this.enable = z;
        notifyPropertyChanged(271);
    }

    @Bindable
    public final ServiceEnum.Unit getVerUnit() {
        return this.verUnit;
    }

    public final void setVerUnit(ServiceEnum.Unit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.verUnit = value;
        notifyPropertyChanged(1021);
    }

    public final MessageAttr getHeightAttr() {
        return this.heightAttr;
    }

    public final MessageAttr getLeftAttr() {
        return this.leftAttr;
    }

    public final MessageAttr getRightAttr() {
        return this.rightAttr;
    }

    public final MessageAttr getTopAttr() {
        return this.topAttr;
    }

    public final MessageAttr getBottomAttr() {
        return this.bottomAttr;
    }

    public final MessageAttr getRealLeftAttr() {
        return this.realLeftAttr;
    }

    public final MessageAttr getRealRightAttr() {
        return this.realRightAttr;
    }

    public final MessageAttr getRealTopAttr() {
        return this.realTopAttr;
    }

    public final MessageAttr getRealBottomAttr() {
        return this.realBottomAttr;
    }

    public final SparseArrayCompat<String> getSourceArray() {
        return this.sourceArray;
    }

    public final String getSum() {
        return this.sum;
    }

    public final void setSum(String str) {
        this.sum = str;
    }

    public final String getPeaks() {
        return this.peaks;
    }

    public final void setPeaks(String str) {
        this.peaks = str;
    }

    public final String getMax() {
        return this.max;
    }

    public final void setMax(String str) {
        this.max = str;
    }

    public final String getMin() {
        return this.min;
    }

    public final void setMin(String str) {
        this.min = str;
    }

    public final String getPkpk() {
        return this.pkpk;
    }

    public final void setPkpk(String str) {
        this.pkpk = str;
    }

    public final String getMean() {
        return this.mean;
    }

    public final void setMean(String str) {
        this.mean = str;
    }

    public final String getMedian() {
        return this.median;
    }

    public final void setMedian(String str) {
        this.median = str;
    }

    public final String getHmode() {
        return this.hmode;
    }

    public final void setHmode(String str) {
        this.hmode = str;
    }

    public final String getBinWidth() {
        return this.binWidth;
    }

    public final void setBinWidth(String str) {
        this.binWidth = str;
    }

    public final String getSigma() {
        return this.sigma;
    }

    public final void setSigma(String str) {
        this.sigma = str;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        super.readAll();
        setSourceA(readSource());
        setChan(readSource());
        setType(readType());
        setHeight(readHeight());
        setLeft(readLeftPosition());
        setRight(readRightPosition());
        setTop(readTopPosition());
        setBottom(readBottomPosition());
        readRealTop();
        readRealLeft();
        readRealRight();
        readRealBottom();
        readRealTopAttr();
        readRealLeftAttr();
        readRealRightAttr();
        readRealBottomAttr();
        readHeightAttr();
        readEnable();
    }

    private final void readRealBottomAttr() {
        readAttr(MessageID.MSG_HISTO_REALLOWPOS, this.realBottomAttr);
    }

    private final void readRealRightAttr() {
        readAttr(MessageID.MSG_HISTO_REALRIGHTPOS, this.realRightAttr);
    }

    private final void readRealLeftAttr() {
        readAttr(MessageID.MSG_HISTO_REALLEFTPOS, this.realLeftAttr);
    }

    private final void readRealTopAttr() {
        readAttr(MessageID.MSG_HISTO_REALHIGHPOS, this.realTopAttr);
    }

    public final void readHeightAttr() {
        readAttr(MessageID.MSG_HISTO_DISPGRID, this.heightAttr);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        boolean z;
        ServiceEnum.HistoType histoType;
        ServiceEnum.Chan chan;
        ServiceEnum.Chan chan2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        long j;
        long j2;
        long j3;
        long j4;
        super.reset();
        z = HistogramResultParamKt.DEFAULT_HISTO_ENABLE;
        setEnable(z);
        histoType = HistogramResultParamKt.DEFAULT_HISTO_TYPE;
        setType(histoType);
        chan = HistogramResultParamKt.DEFAULT_HISTO_CHAN;
        setChan(chan);
        chan2 = HistogramResultParamKt.DEFAULT_HISTO_CHAN;
        setSourceA(chan2);
        i = HistogramResultParamKt.DEFAULT_HISTO_HEIGHT;
        setHeight(i);
        i2 = HistogramResultParamKt.DEFAULT_HISTO_TOP;
        setTop(i2);
        i3 = HistogramResultParamKt.DEFAULT_HISTO_BOTTOM;
        setBottom(i3);
        i4 = HistogramResultParamKt.DEFAULT_HISTO_LEFT;
        setLeft(i4);
        i5 = HistogramResultParamKt.DEFAULT_HISTO_RIGHT;
        setRight(i5);
        j = HistogramResultParamKt.DEFAULT_HISTO_REAL_TOP;
        setRealTop(j);
        j2 = HistogramResultParamKt.DEFAULT_HISTO_REAL_BOTTOM;
        setRealBottom(j2);
        j3 = HistogramResultParamKt.DEFAULT_HISTO_REAL_LEFT;
        setRealLeft(j3);
        j4 = HistogramResultParamKt.DEFAULT_HISTO_REAL_RIGHT;
        setRealRight(j4);
    }

    public final boolean readEnable() {
        setEnable(readBool(MessageID.MSG_HISTO_EN));
        return this.enable;
    }

    public final ServiceEnum.HistoType readType() {
        setType(ServiceEnum.getHistoTypeFromValue1(readInt(MessageID.MSG_HISTO_TYPE)));
        return this.type;
    }

    public final ServiceEnum.Chan readSource() {
        ServiceEnum.Chan sourceA = ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_HISTO_SOURCE));
        Intrinsics.checkNotNullExpressionValue(sourceA, "sourceA");
        setChan(sourceA);
        return this.chan;
    }

    public final int readHeight() {
        setHeight(readInt(MessageID.MSG_HISTO_DISPGRID));
        return this.height;
    }

    public final int readLeftPosition() {
        setLeft(readInt(MessageID.MSG_HISTO_LEFTPOS));
        return this.left;
    }

    public final int readRightPosition() {
        setRight(readInt(MessageID.MSG_HISTO_RIGHTPOS));
        return this.right;
    }

    public final int readTopPosition() {
        setTop(readInt(MessageID.MSG_HISTO_HIGHPOS));
        return this.top;
    }

    public final int readBottomPosition() {
        setBottom(readInt(MessageID.MSG_HISTO_LOWPOS));
        return this.bottom;
    }

    public final long readRealLeft() {
        setRealLeft(readLong(MessageID.MSG_HISTO_REALLEFTPOS));
        readRealLeftAttr();
        return this.realLeft;
    }

    public final long readRealRight() {
        setRealRight(readLong(MessageID.MSG_HISTO_REALRIGHTPOS));
        readRealRightAttr();
        return this.realRight;
    }

    public final long readRealTop() {
        setRealTop(readLong(MessageID.MSG_HISTO_REALHIGHPOS));
        readRealTopAttr();
        return this.realTop;
    }

    public final long readRealBottom() {
        setRealBottom(readLong(MessageID.MSG_HISTO_REALLOWPOS));
        readRealBottomAttr();
        return this.realBottom;
    }

    public final void saveEnable(boolean z) {
        Timber.d("Histogram:UI:SAVE:EN: %s", Boolean.valueOf(z));
        setEnable(z);
        saveBool(MessageID.MSG_HISTO_EN, z);
    }

    public final void saveType(ServiceEnum.HistoType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (this.type == type) {
            return;
        }
        setType(type);
        saveInt(MessageID.MSG_HISTO_TYPE, type.value1);
    }

    public final void saveSource(ServiceEnum.Chan source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (getSourceA() == source) {
            return;
        }
        setSourceA(source);
        saveInt(MessageID.MSG_HISTO_SOURCE, source.value1);
    }

    public final void saveHeight(int i) {
        setHeight(i);
        saveInt(MessageID.MSG_HISTO_DISPGRID, i);
    }

    public final void resetSaveHeight() {
        int i;
        i = HistogramResultParamKt.DEFAULT_HISTO_HEIGHT;
        setHeight(i);
        saveInt(MessageID.MSG_HISTO_DISPGRID, this.height);
    }

    public final void saveLeftPosition(int i) {
        if (this.left == i) {
            return;
        }
        setLeft(i);
        saveInt(MessageID.MSG_HISTO_LEFTPOS, i);
    }

    public final void saveRightPosition(int i) {
        if (this.right == i) {
            return;
        }
        setRight(i);
        saveInt(MessageID.MSG_HISTO_RIGHTPOS, i);
    }

    public final void saveTopPosition(int i) {
        if (this.top == i) {
            return;
        }
        setTop(i);
        saveInt(MessageID.MSG_HISTO_HIGHPOS, i);
    }

    public final void saveBottomPosition(int i) {
        if (this.bottom == i) {
            return;
        }
        setBottom(i);
        saveInt(MessageID.MSG_HISTO_LOWPOS, i);
    }

    public final void saveRealRight(long j) {
        setRealRight(j);
        saveLong(MessageID.MSG_HISTO_REALRIGHTPOS, j);
    }

    public final void resetSaveRealRight() {
        setRealRight(this.realRightAttr.getDefLongValue());
        saveLong(MessageID.MSG_HISTO_REALRIGHTPOS, this.realRight);
    }

    public final void saveRealLeft(long j) {
        setRealLeft(j);
        Timber.e("UI:HIS:readRealLeft:" + j, new Object[0]);
        saveLong(MessageID.MSG_HISTO_REALLEFTPOS, j);
    }

    public final void resetHistoStatis() {
        saveInt(MessageID.MSG_HISTO_RESET, 1);
    }

    public final void resetSaveRealLeft() {
        setRealLeft(this.realLeftAttr.getDefLongValue());
        Timber.e("UI:HIS:readRealLeft:" + this.realLeft, new Object[0]);
        saveLong(MessageID.MSG_HISTO_REALLEFTPOS, this.realLeft);
    }

    public final void saveRealTop(long j) {
        setRealTop(j);
        saveLong(MessageID.MSG_HISTO_REALHIGHPOS, j);
    }

    public final void resetSaveRealTop() {
        setRealTop(this.realTopAttr.getDefLongValue());
        saveLong(MessageID.MSG_HISTO_REALHIGHPOS, this.realTop);
    }

    public final void saveRealBottom(long j) {
        setRealBottom(j);
        saveLong(MessageID.MSG_HISTO_REALLOWPOS, j);
    }

    public final void resetSaveRealBottom() {
        setRealBottom(this.realBottomAttr.getDefLongValue());
        saveLong(MessageID.MSG_HISTO_REALLOWPOS, this.realBottom);
    }

    public final void setData(String[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getItemData().clear();
        String str = data[1];
        Intrinsics.checkNotNull(str);
        setSourceA(getSource(str));
        this.sum = ContextUtil.getResultText(data[3]);
        ArrayList<ThreeTuple<String, String, Float>> itemData = getItemData();
        String str2 = this.sum;
        Float valueOf = Float.valueOf(0.5f);
        itemData.add(new ThreeTuple<>("Sum:", str2, valueOf));
        this.peaks = ContextUtil.getResultText(data[4]);
        getItemData().add(new ThreeTuple<>("Peaks:", this.peaks, valueOf));
        this.max = ContextUtil.getResultText(data[5]);
        getItemData().add(new ThreeTuple<>("Max:", this.max, valueOf));
        this.min = ContextUtil.getResultText(data[6]);
        getItemData().add(new ThreeTuple<>("Min:", this.min, valueOf));
        this.pkpk = ContextUtil.getResultText(data[7]);
        getItemData().add(new ThreeTuple<>("Pk_Pk:", this.pkpk, valueOf));
        this.mean = ContextUtil.getResultText(data[8]);
        getItemData().add(new ThreeTuple<>("Mean:", this.mean, valueOf));
        this.median = ContextUtil.getResultText(data[9]);
        getItemData().add(new ThreeTuple<>("Median:", this.median, valueOf));
        this.hmode = ContextUtil.getResultText(data[10]);
        getItemData().add(new ThreeTuple<>("Mode:", this.hmode, valueOf));
        this.binWidth = ContextUtil.getResultText(data[11]);
        getItemData().add(new ThreeTuple<>("Bin width:", this.binWidth, valueOf));
        this.sigma = ContextUtil.getResultText(data[12]);
        getItemData().add(new ThreeTuple<>("Sigma:", this.sigma, valueOf));
    }

    public final List<ThreeTuple<String, String, Float>> getData() {
        if (getItemData().isEmpty()) {
            getItemData().add(new ThreeTuple<>("Sum:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Peaks:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Max:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Min:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Pk_Pk:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Mean:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Median:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Mode:", "*****", Float.valueOf(0.5f)));
            getItemData().add(new ThreeTuple<>("Bin width:", "*****", Float.valueOf(0.6f)));
            getItemData().add(new ThreeTuple<>("Sigma:", "*****", Float.valueOf(0.5f)));
        }
        return getItemData();
    }

    public final void remove() {
        saveEnable(false);
        syncData(MessageID.MSG_HISTO_EN, false);
    }
}
