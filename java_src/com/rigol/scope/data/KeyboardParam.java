package com.rigol.scope.data;

import androidx.collection.SparseArrayCompat;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.UnitFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;
/* compiled from: KeyboardParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u0016\u0010)\u001a\u00020\f2\u0006\u0010*\u001a\u00020\f2\u0006\u0010+\u001a\u00020\u0006J\u0006\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u0003R&\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR&\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R&\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R&\u0010\u0019\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000f\"\u0004\b\u001b\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u0004R\"\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060 8GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006/"}, d2 = {"Lcom/rigol/scope/data/KeyboardParam;", "Landroidx/databinding/BaseObservable;", "unit", "Lcom/rigol/scope/cil/ServiceEnum$Unit;", "(Lcom/rigol/scope/cil/ServiceEnum$Unit;)V", "value", "Lcom/rigol/scope/utilities/UnitFormat$SI;", "baseSi", "getBaseSi", "()Lcom/rigol/scope/utilities/UnitFormat$SI;", "setBaseSi", "(Lcom/rigol/scope/utilities/UnitFormat$SI;)V", "", "defaultValue", "getDefaultValue", "()D", "setDefaultValue", "(D)V", "format", "Lcom/rigol/scope/utilities/UnitFormat;", "getFormat", "()Lcom/rigol/scope/utilities/UnitFormat;", "maxValue", "getMaxValue", "setMaxValue", "minValue", "getMinValue", "setMinValue", "getUnit", "()Lcom/rigol/scope/cil/ServiceEnum$Unit;", "setUnit", "unitSiList", "Landroidx/collection/SparseArrayCompat;", "getUnitSiList", "()Landroidx/collection/SparseArrayCompat;", "setUnitSiList", "(Landroidx/collection/SparseArrayCompat;)V", "getUnitStr", "", "key", "", "getValue", "number", "si", "setUnitSi", "", "setupBaseSi", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class KeyboardParam extends BaseObservable {
    private UnitFormat.SI baseSi;
    private double defaultValue;
    private final UnitFormat format;
    private double maxValue;
    private double minValue;
    private ServiceEnum.Unit unit;
    private SparseArrayCompat<UnitFormat.SI> unitSiList;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ServiceEnum.Unit.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ServiceEnum.Unit.Unit_s.ordinal()] = 1;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_A.ordinal()] = 2;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_V.ordinal()] = 3;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_W.ordinal()] = 4;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_U.ordinal()] = 5;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_VmulS.ordinal()] = 6;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_VdivS.ordinal()] = 7;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_hz.ordinal()] = 8;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_decimal.ordinal()] = 9;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_Div.ordinal()] = 10;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_degree.ordinal()] = 11;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_percent.ordinal()] = 12;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_SaS.ordinal()] = 13;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_oum.ordinal()] = 14;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_number.ordinal()] = 15;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_bps.ordinal()] = 16;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_password.ordinal()] = 17;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_ip.ordinal()] = 18;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_dbm.ordinal()] = 19;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_dBmV.ordinal()] = 20;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_dBuV.ordinal()] = 21;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_dbV.ordinal()] = 22;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_db.ordinal()] = 23;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_VdivA.ordinal()] = 24;
            $EnumSwitchMapping$0[ServiceEnum.Unit.Unit_Vrms.ordinal()] = 25;
            int[] iArr2 = new int[ServiceEnum.Unit.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ServiceEnum.Unit.Unit_W.ordinal()] = 1;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_A.ordinal()] = 2;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_V.ordinal()] = 3;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_U.ordinal()] = 4;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_Div.ordinal()] = 5;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_VdivA.ordinal()] = 6;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_db.ordinal()] = 7;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_dbV.ordinal()] = 8;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_dbm.ordinal()] = 9;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_Vrms.ordinal()] = 10;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_dBmV.ordinal()] = 11;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_dBuV.ordinal()] = 12;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_VmulS.ordinal()] = 13;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_VdivS.ordinal()] = 14;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_s.ordinal()] = 15;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_hz.ordinal()] = 16;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_degree.ordinal()] = 17;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_percent.ordinal()] = 18;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_oum.ordinal()] = 19;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_number.ordinal()] = 20;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_decimal.ordinal()] = 21;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_bps.ordinal()] = 22;
            $EnumSwitchMapping$1[ServiceEnum.Unit.Unit_SaS.ordinal()] = 23;
        }
    }

    public KeyboardParam(ServiceEnum.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.format = new UnitFormat();
        this.unitSiList = new SparseArrayCompat<>();
        this.baseSi = UnitFormat.SI.NONE;
    }

    public final ServiceEnum.Unit getUnit() {
        return this.unit;
    }

    public final void setUnit(ServiceEnum.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<set-?>");
        this.unit = unit;
    }

    public final UnitFormat getFormat() {
        return this.format;
    }

    @Bindable
    public final SparseArrayCompat<UnitFormat.SI> getUnitSiList() {
        return this.unitSiList;
    }

    public final void setUnitSiList(SparseArrayCompat<UnitFormat.SI> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<set-?>");
        this.unitSiList = sparseArrayCompat;
    }

    @Bindable
    public final double getMaxValue() {
        return this.maxValue;
    }

    public final void setMaxValue(double d) {
        this.maxValue = d;
        notifyPropertyChanged(525);
    }

    @Bindable
    public final double getMinValue() {
        return this.minValue;
    }

    public final void setMinValue(double d) {
        this.minValue = d;
        notifyPropertyChanged(542);
    }

    @Bindable
    public final double getDefaultValue() {
        return this.defaultValue;
    }

    public final void setDefaultValue(double d) {
        this.defaultValue = d;
        notifyPropertyChanged(224);
    }

    @Bindable
    public final UnitFormat.SI getBaseSi() {
        return this.baseSi;
    }

    public final void setBaseSi(UnitFormat.SI value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.baseSi = value;
        this.format.setSi(value);
        Timber.d("baseSi:" + this.baseSi, new Object[0]);
        notifyPropertyChanged(73);
    }

    public final String getUnitStr(int i) {
        if (this.unitSiList.containsKey(i)) {
            UnitFormat.SI si = this.unitSiList.get(i);
            return Intrinsics.stringPlus(si != null ? si.prefixes : null, this.unit.value2);
        }
        return "";
    }

    public final double getValue(double d, UnitFormat.SI si) {
        Intrinsics.checkNotNullParameter(si, "si");
        return d * Math.pow(1000.0d, si.scale - this.baseSi.scale);
    }

    public final void setupBaseSi(ServiceEnum.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        int i = WhenMappings.$EnumSwitchMapping$0[unit.ordinal()];
        switch (i) {
            case 1:
                setBaseSi(UnitFormat.SI.FEMTO);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                setBaseSi(UnitFormat.SI.NANO);
                return;
            case 8:
            case 9:
                setBaseSi(UnitFormat.SI.MICRO);
                return;
            case 10:
                setBaseSi(UnitFormat.SI.MILLI);
                return;
            case 11:
                setBaseSi(UnitFormat.SI.MILLI);
                return;
            default:
                switch (i) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                        setBaseSi(UnitFormat.SI.MILLI);
                        return;
                    default:
                        return;
                }
        }
    }

    public final void setUnitSi() {
        switch (WhenMappings.$EnumSwitchMapping$1[this.unit.ordinal()]) {
            case 1:
                this.unitSiList.append(0, UnitFormat.SI.MEGA);
                this.unitSiList.append(1, UnitFormat.SI.KILO);
                this.unitSiList.append(2, UnitFormat.SI.NONE);
                this.unitSiList.append(3, UnitFormat.SI.MILLI);
                this.unitSiList.append(4, UnitFormat.SI.MICRO);
                return;
            case 2:
            case 3:
                this.unitSiList.append(0, UnitFormat.SI.KILO);
                this.unitSiList.append(1, UnitFormat.SI.NONE);
                this.unitSiList.append(2, UnitFormat.SI.MILLI);
                this.unitSiList.append(3, UnitFormat.SI.MICRO);
                this.unitSiList.append(4, UnitFormat.SI.NANO);
                return;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
                this.unitSiList.append(0, UnitFormat.SI.NONE);
                this.unitSiList.append(1, UnitFormat.SI.MILLI);
                return;
            case 13:
                this.unitSiList.append(0, UnitFormat.SI.KILO);
                this.unitSiList.append(1, UnitFormat.SI.NONE);
                this.unitSiList.append(2, UnitFormat.SI.MILLI);
                this.unitSiList.append(3, UnitFormat.SI.MICRO);
                this.unitSiList.append(4, UnitFormat.SI.NANO);
                return;
            case 14:
                this.unitSiList.append(0, UnitFormat.SI.MEGA);
                this.unitSiList.append(1, UnitFormat.SI.KILO);
                this.unitSiList.append(2, UnitFormat.SI.NONE);
                this.unitSiList.append(3, UnitFormat.SI.MILLI);
                this.unitSiList.append(4, UnitFormat.SI.MICRO);
                return;
            case 15:
                this.unitSiList.append(0, UnitFormat.SI.NONE);
                this.unitSiList.append(1, UnitFormat.SI.MILLI);
                this.unitSiList.append(2, UnitFormat.SI.MICRO);
                this.unitSiList.append(3, UnitFormat.SI.NANO);
                this.unitSiList.append(4, UnitFormat.SI.PICO);
                return;
            case 16:
                this.unitSiList.append(0, UnitFormat.SI.GIGA);
                this.unitSiList.append(1, UnitFormat.SI.MEGA);
                this.unitSiList.append(2, UnitFormat.SI.KILO);
                this.unitSiList.append(3, UnitFormat.SI.NONE);
                this.unitSiList.append(4, UnitFormat.SI.MILLI);
                return;
            case 17:
            case 18:
            case 19:
                this.unitSiList.append(0, UnitFormat.SI.NONE);
                return;
            case 20:
            case 21:
            default:
                return;
            case 22:
            case 23:
                this.unitSiList.append(0, UnitFormat.SI.GIGA);
                this.unitSiList.append(1, UnitFormat.SI.MEGA);
                this.unitSiList.append(2, UnitFormat.SI.KILO);
                this.unitSiList.append(3, UnitFormat.SI.NONE);
                return;
        }
    }
}
