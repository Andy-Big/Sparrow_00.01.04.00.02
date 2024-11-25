package com.rigol.scope.data;

import com.rigol.scope.cil.MessageAttr;
/* loaded from: classes2.dex */
public class CommonDataParam {
    public static final int AFG_CH_COUNT = 4;
    public static final long AFG_KS_SIZE = 1000000000000000L;
    public static final long AFG_MS_SIZE = 1000000000;
    public static final long AFG_NS_SIZE = 1000;
    public static final long AFG_S_SIZE = 1000000000000L;
    public static final long AFG_US_SIZE = 1000000;
    public static int AWG_CH_COUNT = 4;
    public static final boolean BOOL_OFF = false;
    public static final boolean BOOL_ON = true;
    public static final float CYCLER_PRECISION = 1.0E-6f;
    public static final long DB_SIZE = 1000;
    public static final long DUTY_INTEGER_SIZE = 1000;
    public static final float DUTY_PRECISION = 0.01f;
    public static final float DUTY_TO_NORMAL = 0.001f;
    public static final float FUN_RAMP_SYMM_MINI_UNIT = 0.001f;
    public static final float FUN_SQUARE_DUTY_MINI_UNIT = 1.0E-5f;
    public static final long GHZ_2_HZ = 1000000000;
    public static final long GHZ_SIZE = 1000000000000000L;
    public static final long GHZ_US_SIZE = 1000000000;
    public static final float GUI_MAX_OFFSET_NEG = 3.5E-7f;
    public static final float GUI_PULSE_FIFTY_PERCENT = 0.5f;
    public static final int G_BIT_SIZE = 1073741824;
    public static final int G_SIZE = 1000000000;
    public static final long HZ_2_UHZ = 1000000;
    public static final long HZ_SIZE = 1000000;
    public static final long HZ_US_SIZE = 1;
    public static final int INT_OFF = 0;
    public static final int INT_ON = 1;
    public static final int INT_ZERO = 0;
    public static final long KHZ_2_HZ = 1000;
    public static final long KHZ_SIZE = 1000000000;
    public static final long KHZ_US_SIZE = 1000;
    public static final int K_BIT_SIZE = 1024;
    public static final int K_SIZE = 1000;
    public static final long LENGTH_G_SIZE = 1000000000;
    public static final long LENGTH_K_SIZE = 1000;
    public static final long LENGTH_M_SIZE = 1000000;
    public static final int LINE_1 = 0;
    public static final int LINE_10 = 9;
    public static final int LINE_11 = 10;
    public static final int LINE_2 = 1;
    public static final int LINE_3 = 2;
    public static final int LINE_4 = 3;
    public static final int LINE_5 = 4;
    public static final int LINE_6 = 5;
    public static final int LINE_7 = 6;
    public static final int LINE_8 = 7;
    public static final int LINE_9 = 8;
    public static final float MAX_ANGLE_RANGE = 360.0f;
    public static final long MAX_LENGTH = 1610612736;
    public static final int MAX_SHORT = 32767;
    public static final int MAX_UNSIGNED_SHORT = 32767;
    public static final long MHZ_2_HZ = 1000000;
    public static final long MHZ_SIZE = 1000000000000L;
    public static final long MHZ_US_SIZE = 1000000;
    public static final long MILEHZ_2_UHZ = 1000;
    public static final long MILE_HZ_SIZE = 1000;
    public static final long MILE_V_SIZE = 1000;
    public static final int MIN_SHORT = -32768;
    public static final long MS_SIZE = 1000000;
    public static final int M_BIT_SIZE = 1048576;
    public static final int M_SIZE = 1000000;
    public static final double NONE_2_G = 1.0E-9d;
    public static final float NONE_2_K = 0.001f;
    public static final double NONE_2_M = 1.0E-6d;
    public static final int NO_CHAN_FOCUSED = 100;
    public static final int NS_2_PS = 1000;
    public static final long PHASE_INTEGER_SIZE = 1000;
    public static final float PHSER_TO_NORMAL = 0.001f;
    public static final float PS_2_NS = 0.001f;
    public static final long SYMM_INTEGER_SIZE = 1000;
    public static final long S_2_NS = 1000000000;
    public static final long S_SIZE = 1000000000;
    public static final double TWO_PI = 6.283185307179586d;
    public static final double UHZ_2_HZ = 1.0E-6d;
    public static final long US_SIZE = 1000;
    public static final int VPP_TO_V = 2;
    public static final long V_SIZE = 1000000;
    public static int modelType = 1;

    /* loaded from: classes2.dex */
    public enum ModelTypeEu {
        DG70002,
        DG70004
    }

    /* loaded from: classes2.dex */
    public enum MotionWheelDir {
        WHEEL_UP,
        WHEEL_DOWN
    }

    /* loaded from: classes2.dex */
    public enum PowerOnSet {
        DEFAULT,
        LAST
    }

    /* loaded from: classes2.dex */
    public enum StationFuncEnum {
        AWG,
        AFG
    }

    /* loaded from: classes2.dex */
    public enum StationFuncEu {
        STATION_FUNC_NONE,
        STATION_FUNC_SYS,
        STATION_FUNC_AWG,
        STATION_FUNC_AFG,
        STATION_FUNC_OSC,
        STATION_FUNC_WHC,
        STATION_FUNC_VNA,
        STATION_FUNC_IQ,
        STATION_FUNC_CNT
    }

    /* loaded from: classes2.dex */
    public enum StationMaxFunc {
        ONLY_AWG,
        MAX_AWG_AFG_DSO
    }

    /* loaded from: classes2.dex */
    public enum SwitchStuEnum {
        OFF,
        ON
    }

    /* loaded from: classes2.dex */
    public enum TxEnum {
        TX1,
        TX2,
        TX3,
        TX4
    }

    /* loaded from: classes2.dex */
    public enum TxEnum2 {
        TX1,
        TX2
    }

    /* loaded from: classes2.dex */
    public enum TxOutputPath {
        AC,
        DC_HBW,
        DC_AMP
    }

    /* loaded from: classes2.dex */
    public enum UtilityScreenSaver {
        Off,
        text
    }

    /* loaded from: classes2.dex */
    public enum UtilityTypeEnum {
        Utility_IO,
        Utility_Setup,
        Utility_About,
        Utility_Screen_Saver,
        Utility_Self_Check,
        Utility_OPTICAL,
        Utility_Email,
        Utility_Screen_Capture
    }

    public static int convertBoolToInt(boolean z) {
        return !z ? 0 : 1;
    }

    public static boolean convertIntToBool(int i) {
        return i != 0;
    }

    public static boolean isLegal(int i, int i2) {
        return i >= 0 && i <= i2;
    }

    public static MessageAttr convertFreqHzToUHz(MessageAttr messageAttr) {
        return new MessageAttr(messageAttr.getMaxLongValue() * 1000000, messageAttr.getMinLongValue() * 1000000, messageAttr.getDefLongValue() * 1000000);
    }

    public static MessageAttr convertFreqUHzToHz(MessageAttr messageAttr) {
        return new MessageAttr((long) (messageAttr.getMaxLongValue() * 1.0E-6d), (long) (messageAttr.getMinLongValue() * 1.0E-6d), (long) (messageAttr.getDefLongValue() * 1.0E-6d));
    }

    /* loaded from: classes2.dex */
    public enum SystemLanguage {
        language_english(0, "US", "", ""),
        language_chinese(1, "CN", "", ""),
        language_traditional_chinese(2, "HK", "", ""),
        language_portugal(3, "PT", "", ""),
        language_german(4, "DE", "", ""),
        language_borland(5, "PL", "", ""),
        language_korean(6, "KR", "", ""),
        language_japan(7, "JP", "", ""),
        language_french(8, "FR", "", ""),
        language_russia(9, "RU", "", ""),
        language_spanish(10, "ES", "", ""),
        language_thailand(11, "TH", "", ""),
        language_indonesia(12, "ID", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SystemLanguage(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SystemLanguage getSystemLanguageFromValue1(int i) {
        SystemLanguage[] values;
        for (SystemLanguage systemLanguage : SystemLanguage.values()) {
            if (i == systemLanguage.value1) {
                return systemLanguage;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum UtilityQuickStatReset {
        Measure(0, "", "", ""),
        PassFail(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        UtilityQuickStatReset(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static UtilityQuickStatReset getUtilityQuickStatResetFromValue1(int i) {
        UtilityQuickStatReset[] values;
        for (UtilityQuickStatReset utilityQuickStatReset : UtilityQuickStatReset.values()) {
            if (i == utilityQuickStatReset.value1) {
                return utilityQuickStatReset;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum UtilityQuickFormat {
        bin(0, "", "", ""),
        scv(1, "", "", ""),
        wfm(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        UtilityQuickFormat(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static UtilityQuickFormat getUtilityQuickFormatFromValue1(int i) {
        UtilityQuickFormat[] values;
        for (UtilityQuickFormat utilityQuickFormat : UtilityQuickFormat.values()) {
            if (i == utilityQuickFormat.value1) {
                return utilityQuickFormat;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum UtilityQuickDataSource {
        Screen(0, "", "", ""),
        Memory(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        UtilityQuickDataSource(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static UtilityQuickDataSource getUtilityQuickDataSourceFromValue1(int i) {
        UtilityQuickDataSource[] values;
        for (UtilityQuickDataSource utilityQuickDataSource : UtilityQuickDataSource.values()) {
            if (i == utilityQuickDataSource.value1) {
                return utilityQuickDataSource;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum UtilityQuickSaveImage {
        png(0, "", "", ""),
        bmp(1, "", "", ""),
        jpg(2, "", "", ""),
        tif(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        UtilityQuickSaveImage(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static UtilityQuickSaveImage getUtilityQuickSaveImageFromValue1(int i) {
        UtilityQuickSaveImage[] values;
        for (UtilityQuickSaveImage utilityQuickSaveImage : UtilityQuickSaveImage.values()) {
            if (i == utilityQuickSaveImage.value1) {
                return utilityQuickSaveImage;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum UtilityQuickOperationType {
        Save_Image(0, "", "", ""),
        Save_Wave(1, "", "", ""),
        Save_Setup(2, "", "", ""),
        Load_Setup(3, "", "", ""),
        Load_Wave(4, "", "", ""),
        Freeze_Wave(5, "", "", ""),
        All_Measure(6, "", "", ""),
        Stat_Reset(7, "", "", ""),
        Print(8, "", "", ""),
        Email(9, "", "", ""),
        Load_Mask(10, "", "", ""),
        Load_Arb(11, "", "", ""),
        Record(12, "", "", ""),
        Save_Group(13, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        UtilityQuickOperationType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static UtilityQuickOperationType getUtilityQuickOperationTypeFromValue1(int i) {
        UtilityQuickOperationType[] values;
        for (UtilityQuickOperationType utilityQuickOperationType : UtilityQuickOperationType.values()) {
            if (i == utilityQuickOperationType.value1) {
                return utilityQuickOperationType;
            }
        }
        return null;
    }

    public static UtilityScreenSaver getUtilityScreenSaverFromValue(int i) {
        return UtilityScreenSaver.values()[i];
    }
}
