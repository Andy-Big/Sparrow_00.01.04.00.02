package com.rigol.scope.data;
/* loaded from: classes2.dex */
public class WaveParam {
    public static final int DEFAULT_BASIC_WAVE_DRAW_HEIGHT = 278;
    public static final int DEFAULT_BASIC_WAVE_DRAW_POINT = 645;
    public static final int DEFAULT_DC_HIGH = 1000000;
    public static final int DEFAULT_DC_LOW = -1000000;
    public static final int DEFAULT_FORMULA_WAVE_DRAW_HEIGHT = 295;
    public static final int DEFAULT_FORMULA_WAVE_DRAW_POINT = 306;
    public static final WaveEditTypeEnum DEFAULT_WAVE_EDIT_TYPE = WaveEditTypeEnum.BASIC_EDIT;
    public static final String DEFAULT_WAVE_NAME = "Wave";
    public static final int DOWN_LOAD_UPDATE_POS = 350;
    public static final int DRAW_MLTONE_BY_TONES_MAX_SHOW_CNT = 6;
    public static final float DRAW_PULSE_THUMBILS_MAX_CYCLER = 10.0f;
    public static final float DRAW_THUMBILS_MAX_CYCLER = 1.0f;
    public static final String DUP_SAMPLE_UNIT = "Sas";
    public static final int PART_LENGTH = 496;
    public static final int PHASE_MAX = 360000;
    public static final String SIGNAL_SAMPLE_UNIT = "Sa";
    public static final int UP_LOAD_UPDATE_POS = 50;
    public static final int WAVE_POINT_ALIG = 16;

    /* loaded from: classes2.dex */
    public enum AdvanceSignalTypeEnum {
        REAL,
        COMPLEX
    }

    /* loaded from: classes2.dex */
    public enum AdvanceWaveTypeEnum {
        MULTITONE,
        OPTICAL,
        RF,
        SERIAL
    }

    /* loaded from: classes2.dex */
    public enum BasicWaveTypeEnum {
        SIN,
        DC,
        SQUARE,
        TRIANGLE,
        NOISE,
        SINC,
        SIN_IQ,
        PULSE,
        RECTAN,
        SAWTOOTH,
        EXPON,
        SWEEP,
        PRBS,
        NONE
    }

    /* loaded from: classes2.dex */
    public enum CalculateDataEnum {
        CALCULATE_LENGTH,
        CALCULATE_SAMPLING,
        CALCULATE_FREQUENCE,
        CALCULATE_CYCLER,
        CALCULATE_DURATION,
        CALCULATE_NO_NEED
    }

    /* loaded from: classes2.dex */
    public enum CalculateTypeEnum {
        CALCULATE_FIRST_TYPE,
        CALCULATE_SECOND_TYPE,
        CALCULATE_NONE
    }

    /* loaded from: classes2.dex */
    public enum ChirpTimeRateStuEnum {
        TIME_STU,
        RATE_STU
    }

    /* loaded from: classes2.dex */
    public enum DetJitterTypeEm {
        DET_JITTER_NONE_TYPE,
        DET_JITTER_SINE_TYPE,
        DET_JITTER_SQUARE_TYPE,
        DET_JITTER_DISCRETE_TYPE
    }

    /* loaded from: classes2.dex */
    public enum EdgeJitterMode {
        PULSE_EDGE_JITTER_MODE_EDGE,
        PULSE_EDGE_JITTER_MODE_WIDTH
    }

    /* loaded from: classes2.dex */
    public enum FormulaFuncInputTypeEnum {
        FORMULA_FUNC_COMMON,
        FORMULA_FUNC_CIRCULATAR,
        FORMULA_FUNC_MATH
    }

    /* loaded from: classes2.dex */
    public enum HighSpeedTypeEnum {
        PATTERN,
        TRANSMITTER,
        CHANNEL
    }

    /* loaded from: classes2.dex */
    public enum JitterTypeEm {
        JITTER_DET,
        JITTER_RAND,
        JITTER_DCD
    }

    /* loaded from: classes2.dex */
    public enum MarkerEditRangeEnum {
        ALL_RANGE,
        BETWEEN_CURSOR
    }

    /* loaded from: classes2.dex */
    public enum MarkerEditTypeEnum {
        LOW,
        HIGH,
        PULSE
    }

    /* loaded from: classes2.dex */
    public enum MarkerPulseStartLevelEnum {
        START_LEVEL_HIGH,
        START_LEVEL_LOW
    }

    /* loaded from: classes2.dex */
    public enum MarkerSelectEnum {
        MARKER_1,
        MARKER_2,
        MARKER_ALL,
        MARKER_NONE,
        MARKER_CNT
    }

    /* loaded from: classes2.dex */
    public enum MarkerTypeEnum {
        MARKER_TYPE_MARKER1,
        MARKER_TYPE_MARKER2
    }

    /* loaded from: classes2.dex */
    public enum MutitoneEditTypeEnum {
        TONES,
        CHIRP
    }

    /* loaded from: classes2.dex */
    public enum MutitonePhaseTypeEnum {
        RANDOM,
        NEWMAN,
        USER_DEFINED
    }

    /* loaded from: classes2.dex */
    public enum MutitoneRateTypeEnum {
        MTONE_RATE_AUTO,
        MTONE_RATE_USER_DEFINED
    }

    /* loaded from: classes2.dex */
    public enum MutitoneSweepTypeEnum {
        LOW_TO_HIGH,
        HIGH_TO_LOW
    }

    /* loaded from: classes2.dex */
    public enum ParamDataTypeEnum {
        LENGTH,
        SAMPLE,
        FREQUENCE,
        CYCLER,
        DURATION,
        WIDTH,
        AMPLIFY,
        OFFSET,
        HIGH,
        LOW,
        DUTY,
        SYMM,
        PHASE,
        DELAY,
        PEAKPOS,
        LOOPWIDTH
    }

    /* loaded from: classes2.dex */
    public enum StartCode {
        LOW_LEVEL,
        HIGH_LEVEL
    }

    /* loaded from: classes2.dex */
    public enum TableCopyTypeEnum {
        TABLE_WAVE_NO_COPY,
        TABLE_WAVE_COPY_DATA_1,
        TABLE_WAVE_COPY_DATA_2,
        TABLE_WAVE_COPY_MARKER1,
        TABLE_WAVE_COPY_MARKER2,
        TABLE_WAVE_COPY_ROW
    }

    /* loaded from: classes2.dex */
    public enum TableFocuseTypeEnum {
        TABLE_WAVE_NO_FOCUSED,
        TABLE_WAVE_FOCUSED_DATA_1,
        TABLE_WAVE_FOCUSED_DATA_2,
        TABLE_WAVE_FOCUSED_MARKER1,
        TABLE_WAVE_FOCUSED_MARKER2,
        TABLE_WAVE_FOCUSED_ROW
    }

    /* loaded from: classes2.dex */
    public enum TonesSpacingCountStu {
        SPACING_STU,
        TONES_COUNT_STU
    }

    /* loaded from: classes2.dex */
    public enum WaveEditTypeEnum {
        BASIC_EDIT,
        TABLE_EDIT,
        FORMULA_EDIT,
        MOD_EDIT,
        SWEEP_EDIT,
        ADVANCE_IQ,
        ADVANCE_MTONE,
        PLUSE_JITTER,
        HIGH_SPEED_SERIAL,
        NO_WAVE_EDIT
    }

    /* loaded from: classes2.dex */
    public enum edgeTypeDataEnum {
        PULSE_EDGE_TIME_10_90_PERCENT,
        PULSE_EDGE_TIME_20_80_PERCENT
    }

    /* loaded from: classes2.dex */
    public enum pluseTypeDataEnum {
        TYPE_PRBS,
        TYPE_CLK,
        TYPE_USR
    }

    /* loaded from: classes2.dex */
    public enum prbsTypeDataEnum {
        PRBS5,
        PRBS6,
        PRBS7,
        PRBS8,
        PRBS9,
        PRBS10,
        PRBS11,
        PRBS12,
        PRBS13,
        PRBS14,
        PRBS15,
        PRBS23,
        PRBS31
    }

    /* loaded from: classes2.dex */
    public enum signalingSchemesEnum {
        NRZ(0),
        NRZ_I(1),
        PAM(2);
        
        private int s32TypeNum;

        signalingSchemesEnum(int i) {
            this.s32TypeNum = i;
        }

        public int getVal() {
            return this.s32TypeNum;
        }

        public static signalingSchemesEnum getByValue(int i) {
            signalingSchemesEnum[] values;
            for (signalingSchemesEnum signalingschemesenum : values()) {
                if (signalingschemesenum.getVal() == i) {
                    return signalingschemesenum;
                }
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    public enum edgeTimeTypeEnum {
        EDGE_TIME_10_90(0),
        EDGE_TIME_20_80(1);
        
        private int s32TypeNum;

        edgeTimeTypeEnum(int i) {
            this.s32TypeNum = i;
        }

        public int getVal() {
            return this.s32TypeNum;
        }

        public static edgeTimeTypeEnum getByValue(int i) {
            edgeTimeTypeEnum[] values;
            for (edgeTimeTypeEnum edgetimetypeenum : values()) {
                if (edgetimetypeenum.getVal() == i) {
                    return edgetimetypeenum;
                }
            }
            return null;
        }
    }
}
