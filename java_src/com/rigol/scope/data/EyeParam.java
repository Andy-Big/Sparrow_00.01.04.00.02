package com.rigol.scope.data;

import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: EyeParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0007R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0007R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0007R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0007R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0007R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0007R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0007R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0007R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0007R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0007R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0007R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0007R\u0017\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0007R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0007R\u0017\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0007R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0007R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0007R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0007R\u0017\u00103\u001a\b\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0007¨\u00065"}, d2 = {"Lcom/rigol/scope/data/EyeParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "chan", "Lcom/rigol/scope/data/BaseProperty;", "", "getChan", "()Lcom/rigol/scope/data/BaseProperty;", "chanExternalClock", "getChanExternalClock", "dampFactor", "getDampFactor", "dataRate", "", "getDataRate", "enabled", "", "getEnabled", "eyeErr", "getEyeErr", "eyeTemplate", "getEyeTemplate", "eyeTitleString", "", "getEyeTitleString", "grids", "getGrids", "highThres", "getHighThres", "loopBw", "getLoopBw", "lowThres", "getLowThres", "midThres", "getMidThres", "noiseHoldUp", "getNoiseHoldUp", "persistance", "getPersistance", "pllOrder", "getPllOrder", "recoveryType", "getRecoveryType", "resetColor", "getResetColor", "result", "getResult", "templateFlag", "getTemplateFlag", "type", "getType", "uiTime", "getUiTime", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class EyeParam extends BaseParam {
    private final BaseProperty<Integer> chan;
    private final BaseProperty<Integer> chanExternalClock;
    private final BaseProperty<Integer> dampFactor;
    private final BaseProperty<Long> dataRate;
    private final BaseProperty<Boolean> enabled;
    private final BaseProperty<Integer> eyeErr;
    private final BaseProperty<Integer> eyeTemplate;
    private final BaseProperty<String> eyeTitleString;
    private final BaseProperty<Integer> grids;
    private final BaseProperty<Integer> highThres;
    private final BaseProperty<Long> loopBw;
    private final BaseProperty<Integer> lowThres;
    private final BaseProperty<Integer> midThres;
    private final BaseProperty<Integer> noiseHoldUp;
    private final BaseProperty<Boolean> persistance;
    private final BaseProperty<Integer> pllOrder;
    private final BaseProperty<Integer> recoveryType;
    private final BaseProperty<Boolean> resetColor;
    private final BaseProperty<Boolean> result;
    private final BaseProperty<Boolean> templateFlag;
    private final BaseProperty<Integer> type;
    private final BaseProperty<Long> uiTime;

    public EyeParam() {
        super(51);
        float f;
        float f2;
        double d;
        double d2;
        float f3;
        float f4;
        final int serviceId = getServiceId();
        final String logPrefix = getLogPrefix("enabled");
        this.enabled = new BaseProperty<Boolean>(serviceId, MessageID.MSG_EYE_EN, false, logPrefix, true) { // from class: com.rigol.scope.data.EyeParam$enabled$1
            @Override // com.rigol.scope.data.BaseProperty
            public /* bridge */ /* synthetic */ void onSet(Boolean bool, Boolean bool2) {
                onSet(bool.booleanValue(), bool2.booleanValue());
            }

            public void onSet(boolean z, boolean z2) {
                HorizontalParam value;
                super.onSet(Boolean.valueOf(z), Boolean.valueOf(z2));
                HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
                if (horizontalViewModel == null || (value = horizontalViewModel.getLiveData().getValue()) == null) {
                    return;
                }
                Intrinsics.checkNotNullExpressionValue(value, "horizontalViewModel.liveData.value ?: return");
                value.updateDepthEn();
            }
        };
        this.chan = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_SOURCE, Integer.valueOf(ServiceEnum.Chan.chan1.value1), null, getLogPrefix("chan"), false, false, true, 104, null);
        final int serviceId2 = getServiceId();
        final MessageAttr messageAttr = new MessageAttr(0, 0, 90);
        final String logPrefix2 = getLogPrefix("highThres");
        this.highThres = new BaseProperty<Integer>(serviceId2, MessageID.MSG_EYE_HIGHTHRE_PER, 90, messageAttr, logPrefix2) { // from class: com.rigol.scope.data.EyeParam$highThres$1
            @Override // com.rigol.scope.data.BaseProperty
            public void onChanged(boolean z) {
                super.onChanged(z);
                readAttr();
            }
        };
        final int serviceId3 = getServiceId();
        final MessageAttr messageAttr2 = new MessageAttr(0, 0, 50);
        final String logPrefix3 = getLogPrefix("midThres");
        this.midThres = new BaseProperty<Integer>(serviceId3, MessageID.MSG_EYE_MIDTHRE_PER, 50, messageAttr2, logPrefix3) { // from class: com.rigol.scope.data.EyeParam$midThres$1
            @Override // com.rigol.scope.data.BaseProperty
            public void onChanged(boolean z) {
                super.onChanged(z);
                readAttr();
            }
        };
        final int serviceId4 = getServiceId();
        final MessageAttr messageAttr3 = new MessageAttr(0, 0, 10);
        final String logPrefix4 = getLogPrefix("lowThres");
        this.lowThres = new BaseProperty<Integer>(serviceId4, MessageID.MSG_EYE_LOWTHRE_PER, 10, messageAttr3, logPrefix4) { // from class: com.rigol.scope.data.EyeParam$lowThres$1
            @Override // com.rigol.scope.data.BaseProperty
            public void onChanged(boolean z) {
                super.onChanged(z);
                readAttr();
            }
        };
        this.recoveryType = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_CR_SELMETHOD, 0, null, getLogPrefix("recoveryType"), false, false, false, 232, null);
        this.type = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_CR_FREQTYPE, 0, null, getLogPrefix("type"), false, false, false, 232, null);
        final int serviceId5 = getServiceId();
        f = EyeParamKt.DEFAULT_DATARATE;
        final Long valueOf = Long.valueOf(f);
        f2 = EyeParamKt.DEFAULT_DATARATE;
        final MessageAttr messageAttr4 = new MessageAttr(0L, 0L, f2);
        final String logPrefix5 = getLogPrefix("dataRate");
        this.dataRate = new BaseProperty<Long>(serviceId5, MessageID.MSG_EYE_CR_DATEFREQ, valueOf, messageAttr4, logPrefix5) { // from class: com.rigol.scope.data.EyeParam$dataRate$1
            @Override // com.rigol.scope.data.BaseProperty
            public void onChanged(boolean z) {
                super.onChanged(z);
                readAttr();
            }
        };
        this.pllOrder = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_CR_PLLORDER, 0, null, getLogPrefix("pllOrder"), false, false, false, 232, null);
        final int serviceId6 = getServiceId();
        d = EyeParamKt.DEFAULT_LOOPBW;
        final Long valueOf2 = Long.valueOf((long) d);
        d2 = EyeParamKt.DEFAULT_LOOPBW;
        final MessageAttr messageAttr5 = new MessageAttr(0L, 0L, (long) d2);
        final String logPrefix6 = getLogPrefix("loopBw");
        this.loopBw = new BaseProperty<Long>(serviceId6, MessageID.MSG_EYE_CR_PLLWIDTH, valueOf2, messageAttr5, logPrefix6) { // from class: com.rigol.scope.data.EyeParam$loopBw$1
            @Override // com.rigol.scope.data.BaseProperty
            public void onChanged(boolean z) {
                super.onChanged(z);
                readAttr();
            }
        };
        final int serviceId7 = getServiceId();
        final MessageAttr messageAttr6 = new MessageAttr(0, 0, 707);
        final String logPrefix7 = getLogPrefix("dampFactor");
        this.dampFactor = new BaseProperty<Integer>(serviceId7, MessageID.MSG_EYE_CR_DAMPFACTOR, 707, messageAttr6, logPrefix7) { // from class: com.rigol.scope.data.EyeParam$dampFactor$1
            @Override // com.rigol.scope.data.BaseProperty
            public void onChanged(boolean z) {
                super.onChanged(z);
                readAttr();
            }
        };
        this.chanExternalClock = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_EXTERNAL_CLOCK_SRC, Integer.valueOf(ServiceEnum.Chan.chan3.value1), null, getLogPrefix("chanExternalClock"), false, false, false, 232, null);
        this.eyeTemplate = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_TEMPLATE, Integer.valueOf(ServiceEnum.EyeTemplate.eth100.value1), null, getLogPrefix("eyeTemplate"), false, false, true, 72, null);
        this.templateFlag = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_TEMPLATE_STATUS, false, null, getLogPrefix("templateFlag"), false, false, true, 72, null);
        final int serviceId8 = getServiceId();
        f3 = EyeParamKt.DEFAULT_NOISEHOLDUP;
        final Integer valueOf3 = Integer.valueOf((int) f3);
        f4 = EyeParamKt.DEFAULT_NOISEHOLDUP;
        final MessageAttr messageAttr7 = new MessageAttr(0, 0, (int) f4);
        final String logPrefix8 = getLogPrefix("noiseHoldUp");
        this.noiseHoldUp = new BaseProperty<Integer>(serviceId8, MessageID.MSG_EYE_NOISE_HOLDUP, valueOf3, messageAttr7, logPrefix8) { // from class: com.rigol.scope.data.EyeParam$noiseHoldUp$1
            @Override // com.rigol.scope.data.BaseProperty
            public void onChanged(boolean z) {
                super.onChanged(z);
                readAttr();
            }
        };
        this.persistance = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_OVERLAP_DISPLAY, true, null, getLogPrefix("persistance"), false, false, false, 232, null);
        this.result = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_MEAS_EN, false, null, getLogPrefix("result"), false, false, false, 232, null);
        this.resetColor = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_RESET, false, null, getLogPrefix("resetColor"), false, false, false, 168, null);
        this.grids = new BaseProperty<>(getServiceId(), MessageID.MSG_DISPLAY_GRID, Integer.valueOf(ServiceEnum.EWaveGrids.GRID_IS_FULL.value1), null, getLogPrefix("grids"), false, false, true, 104, null);
        this.eyeTitleString = new BaseProperty<>(getServiceId(), MessageID.MSG_WINDOW_TITLE, "", null, getLogPrefix("eyeTitleString"), false, false, true, 104, null);
        this.uiTime = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_UI_TIME, 0L, null, getLogPrefix("uiTime"), false, false, true, 104, null);
        this.eyeErr = new BaseProperty<>(getServiceId(), MessageID.MSG_EYE_ERR, 0, null, getLogPrefix("eyeErr"), false, false, true, 104, null);
    }

    public final BaseProperty<Boolean> getEnabled() {
        return this.enabled;
    }

    public final BaseProperty<Integer> getChan() {
        return this.chan;
    }

    public final BaseProperty<Integer> getHighThres() {
        return this.highThres;
    }

    public final BaseProperty<Integer> getMidThres() {
        return this.midThres;
    }

    public final BaseProperty<Integer> getLowThres() {
        return this.lowThres;
    }

    public final BaseProperty<Integer> getRecoveryType() {
        return this.recoveryType;
    }

    public final BaseProperty<Integer> getType() {
        return this.type;
    }

    public final BaseProperty<Long> getDataRate() {
        return this.dataRate;
    }

    public final BaseProperty<Integer> getPllOrder() {
        return this.pllOrder;
    }

    public final BaseProperty<Long> getLoopBw() {
        return this.loopBw;
    }

    public final BaseProperty<Integer> getDampFactor() {
        return this.dampFactor;
    }

    public final BaseProperty<Integer> getChanExternalClock() {
        return this.chanExternalClock;
    }

    public final BaseProperty<Integer> getEyeTemplate() {
        return this.eyeTemplate;
    }

    public final BaseProperty<Boolean> getTemplateFlag() {
        return this.templateFlag;
    }

    public final BaseProperty<Integer> getNoiseHoldUp() {
        return this.noiseHoldUp;
    }

    public final BaseProperty<Boolean> getPersistance() {
        return this.persistance;
    }

    public final BaseProperty<Boolean> getResult() {
        return this.result;
    }

    public final BaseProperty<Boolean> getResetColor() {
        return this.resetColor;
    }

    public final BaseProperty<Integer> getGrids() {
        return this.grids;
    }

    public final BaseProperty<String> getEyeTitleString() {
        return this.eyeTitleString;
    }

    public final BaseProperty<Long> getUiTime() {
        return this.uiTime;
    }

    public final BaseProperty<Integer> getEyeErr() {
        return this.eyeErr;
    }
}
