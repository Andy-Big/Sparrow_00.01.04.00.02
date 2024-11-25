package com.rigol.scope.data;

import android.text.TextUtils;
import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ResultParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0096\u0002J\b\u0010.\u001a\u00020\u0003H\u0017J\u000e\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\tJ\b\u00101\u001a\u00020\u0003H\u0016J\u0010\u00102\u001a\u0002032\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\u000e\u00104\u001a\u0002032\u0006\u0010\u001e\u001a\u00020\u0003J\b\u00105\u001a\u00020\tH\u0016R)\u0010\u0006\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR*\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00158G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR&\u0010\u001b\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00158G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001aR&\u0010\u001e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\u0004R&\u0010\"\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\u00158G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR*\u0010%\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\t8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)¨\u00067"}, d2 = {"Lcom/rigol/scope/data/ResultParam;", "Lcom/rigol/scope/data/BaseParam;", "serviceId", "", "(I)V", "()V", "itemData", "Ljava/util/ArrayList;", "Lcom/rigol/scope/data/ThreeTuple;", "", "", "getItemData", "()Ljava/util/ArrayList;", "value", "Lcom/rigol/scope/cil/ServiceEnum$MeasType;", "measType", "getMeasType", "()Lcom/rigol/scope/cil/ServiceEnum$MeasType;", "setMeasType", "(Lcom/rigol/scope/cil/ServiceEnum$MeasType;)V", "mode", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "sourceA", "getSourceA", "()Lcom/rigol/scope/cil/ServiceEnum$Chan;", "setSourceA", "(Lcom/rigol/scope/cil/ServiceEnum$Chan;)V", "sourceB", "getSourceB", "setSourceB", "stat", "getStat", "()I", "setStat", "syncArea", "getSyncArea", "setSyncArea", "title", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "equals", "", "other", "", "getMode", "getSource", "source", "hashCode", "setMode", "", "setStats", "toString", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class ResultParam extends BaseParam {
    public static final Companion Companion = new Companion(null);
    public static final int STAT_COLLAPSE = 0;
    public static final int STAT_EXPANDED = 1;
    private final ArrayList<ThreeTuple<String, String, Float>> itemData;
    private ServiceEnum.MeasType measType;
    private int mode;
    private ServiceEnum.Chan sourceA;
    private ServiceEnum.Chan sourceB;
    private int stat;
    private ServiceEnum.Chan syncArea;
    private transient String title;

    @Bindable
    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        log("title", this.title, str);
        this.title = str;
        notifyPropertyChanged(939);
    }

    @Bindable
    public final ServiceEnum.MeasType getMeasType() {
        return this.measType;
    }

    public final void setMeasType(ServiceEnum.MeasType measType) {
        log("measType", this.measType, measType);
        this.measType = measType;
        notifyPropertyChanged(528);
    }

    @Bindable
    public final ServiceEnum.Chan getSyncArea() {
        return this.syncArea;
    }

    public final void setSyncArea(ServiceEnum.Chan value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("syncArea", this.syncArea, value);
        this.syncArea = value;
        notifyPropertyChanged(919);
        MessageBus.getInstance().onSyncData(MessageBus.getKey(21, MessageID.MSG_CURSOR_MANUAL_MIRROR_SRC), this.syncArea);
    }

    @Bindable
    public final ServiceEnum.Chan getSourceA() {
        return this.sourceA;
    }

    public final void setSourceA(ServiceEnum.Chan value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("sourceA", this.sourceA, value);
        this.sourceA = value;
        notifyPropertyChanged(862);
    }

    @Bindable
    public final ServiceEnum.Chan getSourceB() {
        return this.sourceB;
    }

    public final void setSourceB(ServiceEnum.Chan value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("sourceB", this.sourceB, value);
        this.sourceB = value;
        notifyPropertyChanged(866);
    }

    public final ArrayList<ThreeTuple<String, String, Float>> getItemData() {
        return this.itemData;
    }

    @Bindable
    public final int getStat() {
        return this.stat;
    }

    public final void setStat(int i) {
        log("stat", Integer.valueOf(this.stat), Integer.valueOf(i));
        this.stat = i;
        notifyPropertyChanged(902);
    }

    public ResultParam(int i) {
        super(i);
        this.syncArea = ServiceEnum.Chan.chan_none;
        this.sourceA = ServiceEnum.Chan.chan_none;
        this.sourceB = ServiceEnum.Chan.chan_none;
        this.itemData = new ArrayList<>();
    }

    public ResultParam() {
        super(-1);
        this.syncArea = ServiceEnum.Chan.chan_none;
        this.sourceA = ServiceEnum.Chan.chan_none;
        this.sourceB = ServiceEnum.Chan.chan_none;
        this.itemData = new ArrayList<>();
    }

    public final ServiceEnum.Chan getSource(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (TextUtils.isEmpty(source)) {
            return ServiceEnum.Chan.chan_none;
        }
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(Integer.parseInt(source));
        Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromValue1(source.toInt())");
        return chanFromValue1;
    }

    public void setMode(int i) {
        this.mode = i;
        notifyPropertyChanged(544);
    }

    @Bindable
    public int getMode() {
        return this.mode;
    }

    public final void setStats(int i) {
        setStat(i);
        MessageBus.getInstance().onSyncData(MessageBus.getKey(28, MessageID.MSG_APP_MEAS_STAT_ENABLE), Integer.valueOf(i));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResultParam) {
            if ((obj instanceof CursorResultParam) || (obj instanceof DvmResultParam) || (obj instanceof MaskResultParam) || (obj instanceof JitterResultParam) || (obj instanceof EyeResultParam)) {
                return this.measType == ((ResultParam) obj).measType;
            }
            ResultParam resultParam = (ResultParam) obj;
            if (this.measType != resultParam.measType) {
                return false;
            }
            return this.sourceA == resultParam.sourceA && this.sourceB == resultParam.sourceB;
        }
        return false;
    }

    public int hashCode() {
        ServiceEnum.MeasType measType = this.measType;
        return ((((measType != null ? measType.hashCode() : 0) * 31) + this.sourceA.hashCode()) * 31) + this.sourceB.hashCode();
    }

    public String toString() {
        return "ResultParam{title='" + this.title + "', measType=" + this.measType + ", sourceA=" + this.sourceA + ", sourceB=" + this.sourceB + ", stat=" + this.stat + ", mode=" + this.mode + '}';
    }

    /* compiled from: ResultParam.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/data/ResultParam$Companion;", "", "()V", "STAT_COLLAPSE", "", "STAT_EXPANDED", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
