package com.rigol.scope.data;

import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import kotlin.Metadata;
/* compiled from: XYParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0007R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0007R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0007R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007¨\u0006\u001f"}, d2 = {"Lcom/rigol/scope/data/XYParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "advSetting", "Lcom/rigol/scope/data/BaseProperty;", "", "getAdvSetting", "()Lcom/rigol/scope/data/BaseProperty;", "autoCompression", "getAutoCompression", "compressionRatio", "", "getCompressionRatio", "enable", "getEnable", "framePersist", "getFramePersist", "grids", "getGrids", "persistTime", "getPersistTime", "sourceA", "getSourceA", "sourceB", "getSourceB", "sourceC", "getSourceC", "waveIntensity", "getWaveIntensity", "waveWidth", "getWaveWidth", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class XYParam extends BaseParam {
    private final BaseProperty<Boolean> advSetting;
    private final BaseProperty<Boolean> autoCompression;
    private final BaseProperty<Integer> compressionRatio;
    private final BaseProperty<Boolean> enable;
    private final BaseProperty<Integer> framePersist;
    private final BaseProperty<Integer> grids;
    private final BaseProperty<Integer> persistTime;
    private final BaseProperty<Integer> sourceA;
    private final BaseProperty<Integer> sourceB;
    private final BaseProperty<Integer> sourceC;
    private final BaseProperty<Integer> waveIntensity;
    private final BaseProperty<Integer> waveWidth;

    public XYParam() {
        super(40);
        this.enable = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_ENABLE, false, null, getLogPrefix("enable"), false, false, true, 104, null);
        this.sourceA = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_SOURCE_A, Integer.valueOf(ServiceEnum.Chan.chan1.value1), null, getLogPrefix("sourceA"), false, false, true, 104, null);
        this.sourceB = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_SOURCE_B, Integer.valueOf(ServiceEnum.Chan.chan2.value1), null, getLogPrefix("sourceB"), false, false, true, 104, null);
        this.sourceC = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_SOURCE_C, Integer.valueOf(ServiceEnum.Chan.chan_none.value1), null, getLogPrefix("sourceC"), false, false, true, 104, null);
        this.advSetting = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_SETTING_ADV, false, null, getLogPrefix("advSetting"), false, false, false, 232, null);
        int i = (int) 62258.25f;
        this.persistTime = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_AFTERGLOW_SCALE, Integer.valueOf(i), new MessageAttr(65535, 1, 1), getLogPrefix("persistTime"), false, false, false, 224, null);
        this.waveWidth = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_WAVEFORM_SIZE, Integer.valueOf((int) 196.605f), new MessageAttr(65535, 1, 1), getLogPrefix("waveWidth"), false, false, false, 224, null);
        this.waveIntensity = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_INTENSITY, Integer.valueOf((int) 21626.55f), new MessageAttr(65535, 1, 1), getLogPrefix("waveIntensity"), false, false, false, 224, null);
        this.framePersist = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_AFTERGLOWINFRAME_SCALE, Integer.valueOf(i), new MessageAttr(65535, 1, 1), getLogPrefix("framePersist"), false, false, false, 224, null);
        this.autoCompression = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_AUTOCOMPRESS, true, null, getLogPrefix("autoCompression"), false, false, false, 232, null);
        this.compressionRatio = new BaseProperty<>(getServiceId(), MessageID.MSG_XY_SAMPLERATE, 2, new MessageAttr(5, 1, 2), getLogPrefix("compressionRatio"), false, false, false, 224, null);
        this.grids = new BaseProperty<>(getServiceId(), MessageID.MSG_DISPLAY_GRID, Integer.valueOf(ServiceEnum.EWaveGrids.GRID_IS_FULL.value1), null, getLogPrefix("grids"), false, false, true, 104, null);
    }

    public final BaseProperty<Boolean> getEnable() {
        return this.enable;
    }

    public final BaseProperty<Integer> getSourceA() {
        return this.sourceA;
    }

    public final BaseProperty<Integer> getSourceB() {
        return this.sourceB;
    }

    public final BaseProperty<Integer> getSourceC() {
        return this.sourceC;
    }

    public final BaseProperty<Boolean> getAdvSetting() {
        return this.advSetting;
    }

    public final BaseProperty<Integer> getPersistTime() {
        return this.persistTime;
    }

    public final BaseProperty<Integer> getWaveWidth() {
        return this.waveWidth;
    }

    public final BaseProperty<Integer> getWaveIntensity() {
        return this.waveIntensity;
    }

    public final BaseProperty<Integer> getFramePersist() {
        return this.framePersist;
    }

    public final BaseProperty<Boolean> getAutoCompression() {
        return this.autoCompression;
    }

    public final BaseProperty<Integer> getCompressionRatio() {
        return this.compressionRatio;
    }

    public final BaseProperty<Integer> getGrids() {
        return this.grids;
    }
}
