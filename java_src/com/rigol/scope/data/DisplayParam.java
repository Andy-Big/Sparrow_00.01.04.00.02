package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AlgorithmUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DisplayParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0018\u0018\u0000 O2\u00020\u0001:\u0001OB\u0005¢\u0006\u0002\u0010\u0002J\b\u00107\u001a\u000208H\u0016J\u0006\u00109\u001a\u000208J\u0006\u0010:\u001a\u00020\u0004J\u0006\u0010;\u001a\u00020\rJ\u0006\u0010<\u001a\u00020\u0013J\u0006\u0010=\u001a\u00020\u0019J\u0006\u0010>\u001a\u00020\u0013J\u0006\u0010?\u001a\u00020\"J\u0006\u0010@\u001a\u00020\u0013J\u0006\u0010A\u001a\u00020\u0004J\u0006\u0010B\u001a\u00020\u0004J\b\u0010C\u001a\u000208H\u0016J\u000e\u0010D\u001a\u0002082\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010E\u001a\u0002082\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010F\u001a\u0002082\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010G\u001a\u0002082\u0006\u0010H\u001a\u00020\u0013J\u000e\u0010I\u001a\u0002082\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010J\u001a\u0002082\u0006\u0010H\u001a\u00020\u0013J\u000e\u0010K\u001a\u0002082\u0006\u0010#\u001a\u00020\"J\u000e\u0010L\u001a\u0002082\u0006\u0010(\u001a\u00020\u0013J\u000e\u0010M\u001a\u0002082\u0006\u0010+\u001a\u00020\u0004J\u000e\u0010N\u001a\u0002082\u0006\u0010.\u001a\u00020\u0004R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u00198G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R&\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010(\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010\u0018R&\u0010+\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR&\u0010.\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR$\u00102\u001a\u0002012\u0006\u0010\u0003\u001a\u000201@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006P"}, d2 = {"Lcom/rigol/scope/data/DisplayParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "cursorsIntensity", "getCursorsIntensity", "()I", "setCursorsIntensity", "(I)V", "gridIntensity", "getGridIntensity", "setGridIntensity", "Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;", "gridType", "getGridType", "()Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;", "setGridType", "(Lcom/rigol/scope/cil/ServiceEnum$EWaveGrids;)V", "", "paletteEnable", "getPaletteEnable", "()Z", "setPaletteEnable", "(Z)V", "Lcom/rigol/scope/cil/ServiceEnum$EWavePersis;", "persisTime", "getPersisTime", "()Lcom/rigol/scope/cil/ServiceEnum$EWavePersis;", "setPersisTime", "(Lcom/rigol/scope/cil/ServiceEnum$EWavePersis;)V", "rulerEnable", "getRulerEnable", "setRulerEnable", "Lcom/rigol/scope/cil/ServiceEnum$EWaveFormat;", "type", "getType", "()Lcom/rigol/scope/cil/ServiceEnum$EWaveFormat;", "setType", "(Lcom/rigol/scope/cil/ServiceEnum$EWaveFormat;)V", "waveFreeze", "getWaveFreeze", "setWaveFreeze", "waveIntensity", "getWaveIntensity", "setWaveIntensity", "windowTransparency", "getWindowTransparency", "setWindowTransparency", "", "windowTransparency255", "getWindowTransparency255", "()F", "setWindowTransparency255", "(F)V", "readAll", "", "readCursorIntensity", "readGridIntensity", "readGridType", "readPaletteEnable", "readPersisTime", "readRulerEnable", "readType", "readWaveFreeze", "readWaveIntensity", "readWindowTransparency", "reset", "saveCursor", "saveGridIntensity", "saveGridType", "savePaletteEnable", "enable", "savePersisTime", "saveRulerEnable", "saveType", "saveWaveFreeze", "saveWaveIntensity", "saveWindowTransparency", "Companion", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class DisplayParam extends BaseParam {
    public static final Companion Companion = new Companion(null);
    public static final int GRID_COLUMNS = 10;
    public static final int GRID_ROWS = 8;
    private int cursorsIntensity;
    private int gridIntensity;
    private ServiceEnum.EWaveGrids gridType;
    private boolean paletteEnable;
    private ServiceEnum.EWavePersis persisTime;
    private boolean rulerEnable;
    private ServiceEnum.EWaveFormat type;
    private boolean waveFreeze;
    private int waveIntensity;
    private int windowTransparency;
    private float windowTransparency255;

    public DisplayParam() {
        super(26);
        ServiceEnum.EWaveFormat eWaveFormat;
        ServiceEnum.EWavePersis eWavePersis;
        ServiceEnum.EWaveGrids eWaveGrids;
        eWaveFormat = DisplayParamKt.DEFAULT_WAVE_FORMAT;
        this.type = eWaveFormat;
        eWavePersis = DisplayParamKt.DEFAULT_WAVE_PERSIS;
        this.persisTime = eWavePersis;
        this.waveIntensity = 50;
        eWaveGrids = DisplayParamKt.DEFAULT_WAVE_GRID;
        this.gridType = eWaveGrids;
        this.gridIntensity = 50;
        this.cursorsIntensity = 80;
        this.rulerEnable = true;
        this.waveFreeze = true;
        this.windowTransparency = 50;
        this.windowTransparency255 = 50 * 2.55f;
    }

    /* compiled from: DisplayParam.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/rigol/scope/data/DisplayParam$Companion;", "", "()V", "GRID_COLUMNS", "", "GRID_ROWS", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Bindable
    public final ServiceEnum.EWaveFormat getType() {
        return this.type;
    }

    public final void setType(ServiceEnum.EWaveFormat value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("type", this.type, value);
        this.type = value;
        notifyPropertyChanged(978);
    }

    @Bindable
    public final ServiceEnum.EWavePersis getPersisTime() {
        return this.persisTime;
    }

    public final void setPersisTime(ServiceEnum.EWavePersis value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("persisTime", this.persisTime, value);
        this.persisTime = value;
        notifyPropertyChanged(619);
    }

    @Bindable
    public final int getWaveIntensity() {
        return this.waveIntensity;
    }

    public final void setWaveIntensity(int i) {
        log("waveIntensity", Integer.valueOf(this.waveIntensity), Integer.valueOf(i));
        if (i < 0) {
            i = 0;
        } else if (i > 100) {
            i = 100;
        }
        this.waveIntensity = i;
        notifyPropertyChanged(1038);
    }

    @Bindable
    public final ServiceEnum.EWaveGrids getGridType() {
        return this.gridType;
    }

    public final void setGridType(ServiceEnum.EWaveGrids value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("gridType", this.gridType, value);
        this.gridType = value;
        notifyPropertyChanged(362);
        syncData(MessageID.MSG_DISPLAY_GRID, Integer.valueOf(this.gridType.value1));
    }

    @Bindable
    public final int getGridIntensity() {
        return this.gridIntensity;
    }

    public final void setGridIntensity(int i) {
        log("gridIntensity", Integer.valueOf(this.gridIntensity), Integer.valueOf(i));
        this.gridIntensity = i;
        notifyPropertyChanged(360);
        syncData(MessageID.MSG_DISPLAY_GRID_INTENSITY, Integer.valueOf(this.gridIntensity));
    }

    @Bindable
    public final int getCursorsIntensity() {
        return this.cursorsIntensity;
    }

    public final void setCursorsIntensity(int i) {
        log("cursorIntensity", Integer.valueOf(this.cursorsIntensity), Integer.valueOf(i));
        this.cursorsIntensity = i;
        notifyPropertyChanged(208);
        syncData(MessageID.MSG_DISPLAY_APP_CURSORS, Integer.valueOf(this.cursorsIntensity));
    }

    @Bindable
    public final boolean getRulerEnable() {
        return this.rulerEnable;
    }

    public final void setRulerEnable(boolean z) {
        log("rulerEnable", Boolean.valueOf(this.rulerEnable), Boolean.valueOf(z));
        this.rulerEnable = z;
        notifyPropertyChanged(759);
        syncData(MessageID.MSG_DISPLAY_RULERS, Boolean.valueOf(this.rulerEnable));
    }

    @Bindable
    public final boolean getPaletteEnable() {
        return this.paletteEnable;
    }

    public final void setPaletteEnable(boolean z) {
        log("paletteEnable", Boolean.valueOf(this.paletteEnable), Boolean.valueOf(z));
        this.paletteEnable = z;
        notifyPropertyChanged(593);
    }

    @Bindable
    public final boolean getWaveFreeze() {
        return this.waveFreeze;
    }

    public final void setWaveFreeze(boolean z) {
        log("waveFreeze", Boolean.valueOf(this.waveFreeze), Boolean.valueOf(z));
        this.waveFreeze = z;
        notifyPropertyChanged(1037);
    }

    @Bindable
    public final int getWindowTransparency() {
        return this.windowTransparency;
    }

    public final void setWindowTransparency(int i) {
        log("windowTransparency", Integer.valueOf(this.windowTransparency), Integer.valueOf(i));
        this.windowTransparency = i;
        notifyPropertyChanged(1079);
        syncData(MessageID.MSG_WINDOW_TRANSPARENCY, Integer.valueOf(this.windowTransparency));
        setWindowTransparency255((100 - this.windowTransparency) * 2.55f);
    }

    public final float getWindowTransparency255() {
        return this.windowTransparency255;
    }

    public final void setWindowTransparency255(float f) {
        this.windowTransparency255 = AlgorithmUtil.easeOutCirc(f / 255.0f) * 255;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readType();
        readPersisTime();
        readWaveIntensity();
        readGridType();
        readGridIntensity();
        readRulerEnable();
        readPaletteEnable();
        readWaveFreeze();
        readWindowTransparency();
        readCursorIntensity();
    }

    public final ServiceEnum.EWaveFormat readType() {
        ServiceEnum.EWaveFormat eWaveFormatFromValue1 = ServiceEnum.getEWaveFormatFromValue1(readInt(MessageID.MSG_DISPLAY_TYPE));
        Intrinsics.checkNotNullExpressionValue(eWaveFormatFromValue1, "ServiceEnum.getEWaveForm…sageID.MSG_DISPLAY_TYPE))");
        setType(eWaveFormatFromValue1);
        return this.type;
    }

    public final ServiceEnum.EWavePersis readPersisTime() {
        ServiceEnum.EWavePersis eWavePersisFromValue1 = ServiceEnum.getEWavePersisFromValue1(readInt(MessageID.MSG_DISPLAY_PERSISTIME));
        Intrinsics.checkNotNullExpressionValue(eWavePersisFromValue1, "ServiceEnum.getEWavePers….MSG_DISPLAY_PERSISTIME))");
        setPersisTime(eWavePersisFromValue1);
        return this.persisTime;
    }

    public final int readWaveIntensity() {
        setWaveIntensity(readInt(MessageID.MSG_DISPLAY_WAVE_INTENSITY));
        return this.waveIntensity;
    }

    public final int readWindowTransparency() {
        setWindowTransparency(readInt(MessageID.MSG_WINDOW_TRANSPARENCY));
        return this.windowTransparency;
    }

    public final void readCursorIntensity() {
        setCursorsIntensity(readInt(MessageID.MSG_DISPLAY_APP_CURSORS));
    }

    public final ServiceEnum.EWaveGrids readGridType() {
        ServiceEnum.EWaveGrids eWaveGridsFromValue1 = ServiceEnum.getEWaveGridsFromValue1(readInt(MessageID.MSG_DISPLAY_GRID));
        Intrinsics.checkNotNullExpressionValue(eWaveGridsFromValue1, "ServiceEnum.getEWaveGrid…sageID.MSG_DISPLAY_GRID))");
        setGridType(eWaveGridsFromValue1);
        return this.gridType;
    }

    public final int readGridIntensity() {
        setGridIntensity(readInt(MessageID.MSG_DISPLAY_GRID_INTENSITY));
        return this.gridIntensity;
    }

    public final boolean readRulerEnable() {
        setRulerEnable(readBool(MessageID.MSG_DISPLAY_RULERS));
        return this.rulerEnable;
    }

    public final boolean readPaletteEnable() {
        setPaletteEnable(readBool(MessageID.MSG_DISPLAY_PALETTE));
        return this.paletteEnable;
    }

    public final boolean readWaveFreeze() {
        setWaveFreeze(readBool(MessageID.MSG_DISPLAY_FREEZE));
        return this.waveFreeze;
    }

    public final void saveType(ServiceEnum.EWaveFormat type) {
        Intrinsics.checkNotNullParameter(type, "type");
        setType(type);
        saveInt(MessageID.MSG_DISPLAY_TYPE, type.value1);
    }

    public final void saveCursor(int i) {
        setCursorsIntensity(i);
        saveInt(MessageID.MSG_DISPLAY_APP_CURSORS, i);
    }

    public final void savePersisTime(ServiceEnum.EWavePersis persisTime) {
        Intrinsics.checkNotNullParameter(persisTime, "persisTime");
        setPersisTime(persisTime);
        saveInt(MessageID.MSG_DISPLAY_PERSISTIME, persisTime.value1);
    }

    public final void saveWaveIntensity(int i) {
        if (i > 0) {
            setWaveIntensity(i);
        } else {
            setWaveIntensity(1);
        }
        saveInt(MessageID.MSG_DISPLAY_WAVE_INTENSITY, i);
    }

    public final void saveWindowTransparency(int i) {
        setWindowTransparency(i);
        saveInt(MessageID.MSG_WINDOW_TRANSPARENCY, i);
    }

    public final void saveGridType(ServiceEnum.EWaveGrids gridType) {
        Intrinsics.checkNotNullParameter(gridType, "gridType");
        setGridType(gridType);
        saveInt(MessageID.MSG_DISPLAY_GRID, gridType.value1);
    }

    public final void saveGridIntensity(int i) {
        setGridIntensity(i);
        saveInt(MessageID.MSG_DISPLAY_GRID_INTENSITY, i);
    }

    public final void saveRulerEnable(boolean z) {
        setRulerEnable(z);
        String.valueOf(saveInt(MessageID.MSG_DISPLAY_RULERS, this.rulerEnable));
    }

    public final void savePaletteEnable(boolean z) {
        setPaletteEnable(z);
        saveInt(MessageID.MSG_DISPLAY_PALETTE, this.paletteEnable);
    }

    public final void saveWaveFreeze(boolean z) {
        setWaveFreeze(z);
        saveInt(MessageID.MSG_DISPLAY_FREEZE, z);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        ServiceEnum.EWaveFormat eWaveFormat;
        ServiceEnum.EWavePersis eWavePersis;
        ServiceEnum.EWaveGrids eWaveGrids;
        super.reset();
        eWaveFormat = DisplayParamKt.DEFAULT_WAVE_FORMAT;
        setType(eWaveFormat);
        eWavePersis = DisplayParamKt.DEFAULT_WAVE_PERSIS;
        setPersisTime(eWavePersis);
        setWaveIntensity(50);
        eWaveGrids = DisplayParamKt.DEFAULT_WAVE_GRID;
        setGridType(eWaveGrids);
        setGridIntensity(50);
        setRulerEnable(true);
        setPaletteEnable(false);
        setWaveFreeze(true);
        setWindowTransparency(50);
        setCursorsIntensity(80);
    }
}
