package com.rigol.scope.cil;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.constant.TimeConstants;
import com.just.agentweb.AgentWebPermissions;
import com.just.agentweb.WebIndicator;
import com.rigol.util.PackageUtilKt;
import javax.jmdns.impl.constants.DNSConstants;

/* loaded from: classes2.dex */
public class ServiceEnum {

    /* loaded from: classes2.dex */
    public enum PhyDefineEnum {
        MAX_AFE_COUNT(4, "", "", ""),
        MAX_ADC_COUNT(2, "", "", ""),
        MAX_CORE_NUMS(8, "", "", ""),
        MAX_LA_GROUP_COUNT(2, "", "", ""),
        MAX_LA_COUNT(16, "", "", ""),
        MAX_AUTO_DEPTH(1000000, "", "", ""),
        MAX_FIXED_DEPTH(100000000, "", "", ""),
        MAX_SCAN_CHAN(8, "", "", ""),
        MAX_ROLL_CHAN(20, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        PhyDefineEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static PhyDefineEnum getPhyDefineEnumFromValue1(int i) {
        PhyDefineEnum[] values;
        for (PhyDefineEnum phyDefineEnum : PhyDefineEnum.values()) {
            if (i == phyDefineEnum.value1) {
                return phyDefineEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum enumExp {
        E_MIN(-19, "", "", ""),
        E_N18(-18, "", "", ""),
        E_N17(-17, "", "", ""),
        E_N16(-16, "", "", ""),
        E_N15(-15, "", "", ""),
        E_N14(-14, "", "", ""),
        E_N13(-13, "", "", ""),
        E_N12(-12, "", "", ""),
        E_N11(-11, "", "", ""),
        E_N10(-10, "", "", ""),
        E_N9(-9, "", "", ""),
        E_N8(-8, "", "", ""),
        E_N7(-7, "", "", ""),
        E_N6(-6, "", "", ""),
        E_N5(-5, "", "", ""),
        E_N4(-4, "", "", ""),
        E_N3(-3, "", "", ""),
        E_N2(-2, "", "", ""),
        E_N1(-1, "", "", ""),
        E_0(0, "", "", ""),
        E_P1(1, "", "", ""),
        E_P2(2, "", "", ""),
        E_P3(3, "", "", ""),
        E_P4(4, "", "", ""),
        E_P5(5, "", "", ""),
        E_P6(6, "", "", ""),
        E_P7(7, "", "", ""),
        E_P8(8, "", "", ""),
        E_P9(9, "", "", ""),
        E_P10(10, "", "", ""),
        E_P11(11, "", "", ""),
        E_P12(12, "", "", ""),
        E_P13(13, "", "", ""),
        E_P14(14, "", "", ""),
        E_P15(15, "", "", ""),
        E_P16(16, "", "", ""),
        E_P17(17, "", "", ""),
        E_P18(18, "", "", ""),
        E_P36(36, "", "", ""),
        E_MAX(37, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        enumExp(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static enumExp getenumExpFromValue1(int i) {
        enumExp[] values;
        for (enumExp enumexp : enumExp.values()) {
            if (i == enumexp.value1) {
                return enumexp;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DsoScreenMode {
        screen_unk(0, "", "", ""),
        screen_yt_main(1, "", "", ""),
        screen_yt_main_zoom(2, "", "", ""),
        screen_yt_main_zfft(3, "", "", ""),
        screen_xy_full(4, "", "", ""),
        screen_xy_normal(5, "", "", ""),
        screen_xy_fft(6, "", "", ""),
        screen_roll_main(7, "", "", ""),
        screen_roll_main_zoom(8, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DsoScreenMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DsoScreenMode getDsoScreenModeFromValue1(int i) {
        DsoScreenMode[] values;
        for (DsoScreenMode dsoScreenMode : DsoScreenMode.values()) {
            if (i == dsoScreenMode.value1) {
                return dsoScreenMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DsoViewFmt {
        fmt_unk(0, "", "", ""),
        fmt_bin(1, "", "", ""),
        fmt_hex(2, "", "", ""),
        fmt_int(3, "", "", ""),
        fmt_float(4, "", "", ""),
        fmt_f(5, "", "", ""),
        fmt_ip(6, "", "", ""),
        fmt_asc(7, "", "", ""),
        fmt_time(8, "", "", ""),
        fmt_date(9, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DsoViewFmt(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DsoViewFmt getDsoViewFmtFromValue1(int i) {
        DsoViewFmt[] values;
        for (DsoViewFmt dsoViewFmt : DsoViewFmt.values()) {
            if (i == dsoViewFmt.value1) {
                return dsoViewFmt;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DsoViewWidth {
        fmt_width_1(256, "", "", ""),
        fmt_width_2(512, "", "", ""),
        fmt_width_3(768, "", "", ""),
        fmt_width_4(1024, "", "", ""),
        fmt_width_5(MessageID.MSG_APP_BODE, "", "", ""),
        fmt_width_6(1536, "", "", ""),
        fmt_width_7(MessageID.MSG_CHAN_ACTIVE, "", "", ""),
        fmt_width_8(2048, "", "", ""),
        fmt_width_9(MessageID.MSG_APP_CARRIER, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DsoViewWidth(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DsoViewWidth getDsoViewWidthFromValue1(int i) {
        DsoViewWidth[] values;
        for (DsoViewWidth dsoViewWidth : DsoViewWidth.values()) {
            if (i == dsoViewWidth.value1) {
                return dsoViewWidth;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DsoViewPrecision {
        fmt_1f(256, "", "", ""),
        fmt_2f(512, "", "", ""),
        fmt_3f(768, "", "", ""),
        fmt_4f(1024, "", "", ""),
        fmt_5f(MessageID.MSG_APP_BODE, "", "", ""),
        fmt_6f(1536, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DsoViewPrecision(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DsoViewPrecision getDsoViewPrecisionFromValue1(int i) {
        DsoViewPrecision[] values;
        for (DsoViewPrecision dsoViewPrecision : DsoViewPrecision.values()) {
            if (i == dsoViewPrecision.value1) {
                return dsoViewPrecision;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DsoViewTrim {
        fmt_trim_0(0, "", "", ""),
        fmt_no_trim_0(65536, "", "", ""),
        fmt_trim_0_2(131072, "", "", ""),
        fmt_trim_0_3(196608, "", "", ""),
        fmt_trim_0_4(262144, "", "", ""),
        fmt_trim_0_5(327680, "", "", ""),
        fmt_trim_0_6(393216, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DsoViewTrim(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DsoViewTrim getDsoViewTrimFromValue1(int i) {
        DsoViewTrim[] values;
        for (DsoViewTrim dsoViewTrim : DsoViewTrim.values()) {
            if (i == dsoViewTrim.value1) {
                return dsoViewTrim;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DsoWorkMode {
        aim_normal(0, "", "", ""),
        aim_calibrate(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DsoWorkMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DsoWorkMode getDsoWorkModeFromValue1(int i) {
        DsoWorkMode[] values;
        for (DsoWorkMode dsoWorkMode : DsoWorkMode.values()) {
            if (i == dsoWorkMode.value1) {
                return dsoWorkMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Chan {
        chan_none(0, "none", "", ""),
        chan1(1, "chan1", "", ""),
        chan2(2, "chan2", "", ""),
        chan3(3, "chan3", "", ""),
        chan4(4, "chan4", "", ""),
        chan5(5, "chan5", "", ""),
        chan6(6, "chan6", "", ""),
        chan7(7, "chan7", "", ""),
        chan8(8, "chan8", "", ""),
        d0(9, "dx", "", ""),
        d1(10, "dx", "", ""),
        d2(11, "dx", "", ""),
        d3(12, "dx", "", ""),
        d4(13, "dx", "", ""),
        d5(14, "dx", "", ""),
        d6(15, "dx", "", ""),
        d7(16, "dx", "", ""),
        d8(17, "dx", "", ""),
        d9(18, "dx", "", ""),
        d10(19, "dx", "", ""),
        d11(20, "dx", "", ""),
        d12(21, "dx", "", ""),
        d13(22, "dx", "", ""),
        d14(23, "dx", "", ""),
        d15(24, "dx", "", ""),
        acline(25, "ac", "", ""),
        ext(26, "ext", "", ""),
        ext5(27, "ext", "", ""),
        ALL_TRIGGER_SOURCE(28, "", "", ""),
        r1(28, "", "", ""),
        r2(29, "", "", ""),
        r3(30, "", "", ""),
        r4(31, "", "", ""),
        r5(32, "", "", ""),
        r6(33, "", "", ""),
        r7(34, "", "", ""),
        r8(35, "", "", ""),
        r9(36, "", "", ""),
        r10(37, "", "", ""),
        m1(38, "math1", "", ""),
        m2(39, "math2", "", ""),
        m3(40, "math3", "", ""),
        m4(41, "math4", "", ""),
        dg1(42, "", "", ""),
        dg2(43, "", "", ""),
        cursor(44, "", "", ""),
        intensity(45, "", "", ""),
        bus1(46, "", "", ""),
        bus2(47, "", "", ""),
        bus3(48, "", "", ""),
        bus4(49, "", "", ""),
        la(50, "", "", ""),
        d0d7(51, "", "", ""),
        d8d15(52, "", "", ""),
        d0d15(53, "", "", ""),
        rtsa(54, "", "", ""),
        color_grade(55, "", "", ""),
        digi_ch1(56, "", "", ""),
        digi_ch2(57, "", "", ""),
        digi_ch3(58, "", "", ""),
        digi_ch4(59, "", "", ""),
        digi_ch5(60, "", "", ""),
        digi_ch6(61, "", "", ""),
        digi_ch7(62, "", "", ""),
        digi_ch8(63, "", "", ""),
        digi_ch1_l(64, "", "", ""),
        digi_ch2_l(65, "", "", ""),
        digi_ch3_l(66, "", "", ""),
        digi_ch4_l(67, "", "", ""),
        digi_ch5_l(68, "", "", ""),
        digi_ch6_l(69, "", "", ""),
        digi_ch7_l(70, "", "", ""),
        digi_ch8_l(71, "", "", ""),
        eye_ch1(72, "", "", ""),
        eye_ch2(73, "", "", ""),
        eye_ch3(74, "", "", ""),
        eye_ch4(75, "", "", ""),
        reference(76, "", "", ""),
        analog(77, "", "", ""),
        analog_la(78, "", "", ""),
        sch_ch(79, "", "", ""),
        chan_all(80, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Chan(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Chan getChanFromValue1(int i) {
        Chan[] values;
        for (Chan chan : Chan.values()) {
            if (i == chan.value1) {
                return chan;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum VertZone {
        vert_analog(0, "", "", ""),
        vert_la(1, "", "", ""),
        vert_ref(2, "", "", ""),
        vert_math(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        VertZone(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static VertZone getVertZoneFromValue1(int i) {
        VertZone[] values;
        for (VertZone vertZone : VertZone.values()) {
            if (i == vertZone.value1) {
                return vertZone;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Impedance {
        IMP_1M(0, "", "", ""),
        IMP_50(1, "", "", ""),
        IMP_1M_OL(2, "", "", ""),
        IMP_UNK(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Impedance(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Impedance getImpedanceFromValue1(int i) {
        Impedance[] values;
        for (Impedance impedance : Impedance.values()) {
            if (i == impedance.value1) {
                return impedance;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalChanID {
        Cal_Chan1(0, "", "", ""),
        Cal_Chan2(1, "", "", ""),
        Cal_Chan3(2, "", "", ""),
        Cal_Chan4(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalChanID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalChanID getCalChanIDFromValue1(int i) {
        CalChanID[] values;
        for (CalChanID calChanID : CalChanID.values()) {
            if (i == calChanID.value1) {
                return calChanID;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalLzGearID {
        Cal_LzGear1(0, "", "", ""),
        Cal_LzGear2(1, "", "", ""),
        Cal_LzGear3(2, "", "", ""),
        Cal_LzGear4(3, "", "", ""),
        Cal_LzGear5(4, "", "", ""),
        Cal_LzGear6(5, "", "", ""),
        Cal_LzGear7(6, "", "", ""),
        Cal_LzGear8(7, "", "", ""),
        Cal_LzGear9(8, "", "", ""),
        Cal_LzGear10(9, "", "", ""),
        Cal_LzGear11(10, "", "", ""),
        Cal_LzGear12(11, "", "", ""),
        Cal_LzGear13(12, "", "", ""),
        Max_Cal_LzGearCount(13, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalLzGearID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalLzGearID getCalLzGearIDFromValue1(int i) {
        CalLzGearID[] values;
        for (CalLzGearID calLzGearID : CalLzGearID.values()) {
            if (i == calLzGearID.value1) {
                return calLzGearID;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalHzGearID {
        Cal_HzGear1(0, "", "", ""),
        Cal_HzGear2(1, "", "", ""),
        Cal_HzGear3(2, "", "", ""),
        Cal_HzGear4(3, "", "", ""),
        Cal_HzGear5(4, "", "", ""),
        Cal_HzGear6(5, "", "", ""),
        Cal_HzGear7(6, "", "", ""),
        Cal_HzGear8(7, "", "", ""),
        Cal_HzGear9(8, "", "", ""),
        Cal_HzGear10(9, "", "", ""),
        Cal_HzGear11(10, "", "", ""),
        Cal_HzGear12(11, "", "", ""),
        Cal_HzGear13(12, "", "", ""),
        Cal_HzGear14(13, "", "", ""),
        Cal_HzGear15(14, "", "", ""),
        Cal_HzGear16(15, "", "", ""),
        Cal_HzGear17(16, "", "", ""),
        Max_Cal_HzGearCount(17, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalHzGearID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalHzGearID getCalHzGearIDFromValue1(int i) {
        CalHzGearID[] values;
        for (CalHzGearID calHzGearID : CalHzGearID.values()) {
            if (i == calHzGearID.value1) {
                return calHzGearID;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalLsbCaseID {
        Cal_LsbCase1(0, "", "", ""),
        Cal_LsbCase2(1, "", "", ""),
        Cal_LsbCase3(2, "", "", ""),
        Cal_LsbCase4(3, "", "", ""),
        Cal_LsbCase5(4, "", "", ""),
        Cal_LsbCase6(5, "", "", ""),
        Cal_LsbCase7(6, "", "", ""),
        Cal_LsbCase8(7, "", "", ""),
        Max_Cal_LsbCaseCount(8, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalLsbCaseID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalLsbCaseID getCalLsbCaseIDFromValue1(int i) {
        CalLsbCaseID[] values;
        for (CalLsbCaseID calLsbCaseID : CalLsbCaseID.values()) {
            if (i == calLsbCaseID.value1) {
                return calLsbCaseID;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalLsbGearID {
        Cal_LsbGear1(0, "", "", ""),
        Cal_LsbGear2(1, "", "", ""),
        Cal_LsbGear3(2, "", "", ""),
        Cal_LsbGear4(3, "", "", ""),
        Cal_LsbGear5(4, "", "", ""),
        Cal_LsbGear6(5, "", "", ""),
        Max_Cal_LsbGearCount(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalLsbGearID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalLsbGearID getCalLsbGearIDFromValue1(int i) {
        CalLsbGearID[] values;
        for (CalLsbGearID calLsbGearID : CalLsbGearID.values()) {
            if (i == calLsbGearID.value1) {
                return calLsbGearID;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum enChanStatus {
        CHAN_OFF(0, "", "", ""),
        CHAN_ON(1, "", "", ""),
        CHAN_ACTIVE(2, "", "", ""),
        CHAN_HIDE(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        enChanStatus(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static enChanStatus getenChanStatusFromValue1(int i) {
        enChanStatus[] values;
        for (enChanStatus enchanstatus : enChanStatus.values()) {
            if (i == enchanstatus.value1) {
                return enchanstatus;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ProbeHead {
        Probe_Single(0, "", "", ""),
        Probe_Diff(1, "", "", ""),
        Probe_Comm(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ProbeHead(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ProbeHead getProbeHeadFromValue1(int i) {
        ProbeHead[] values;
        for (ProbeHead probeHead : ProbeHead.values()) {
            if (i == probeHead.value1) {
                return probeHead;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ProbeType {
        Probe_BNC(0, "", "", ""),
        Probe_V(1, "", "", ""),
        Probe_A(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ProbeType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ProbeType getProbeTypeFromValue1(int i) {
        ProbeType[] values;
        for (ProbeType probeType : ProbeType.values()) {
            if (i == probeType.value1) {
                return probeType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ProbeModel {
        PROBE_BNC(0, "", "", ""),
        PROBE_RP1(1, "", "", ""),
        PROBE_TP1(2, "", "", ""),
        PROBE_KP1(3, "", "", ""),
        PROBE_LP1(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ProbeModel(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ProbeModel getProbeModelFromValue1(int i) {
        ProbeModel[] values;
        for (ProbeModel probeModel : ProbeModel.values()) {
            if (i == probeModel.value1) {
                return probeModel;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Unit {
        Unit_none(0, "", "", ""),
        Unit_W(1, ExifInterface.LONGITUDE_WEST, "", ""),
        Unit_A(2, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", ""),
        Unit_V(3, ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "", ""),
        Unit_U(4, "U", "", ""),
        Unit_s(5, "s", "", ""),
        Unit_hz(6, "Hz", "", ""),
        Unit_degree(7, "°", "", ""),
        Unit_percent(8, "%", "", ""),
        Unit_db(9, "dB", "", ""),
        Unit_dbm(10, "dBm", "", ""),
        Unit_dbV(11, "dBV", "", ""),
        Unit_VmulS(12, "V*s", "", ""),
        Unit_VdivS(13, "V/s", "", ""),
        Unit_Vrms(14, "Vrms", "", ""),
        Unit_oum(15, "", "", ""),
        Unit_Div(16, "div", "", ""),
        Unit_SaS(17, "Sa/s", "", ""),
        Unit_Pts(18, "pts", "", ""),
        Unit_Pts_(19, "", "", ""),
        Unit_VA(20, "", "", ""),
        Unit_VAR(21, "", "", ""),
        Unit_wfm(22, "", "", ""),
        Unit_V2(23, "", "", ""),
        Unit_W2(24, "", "", ""),
        Unit_A2(25, "", "", ""),
        Unit_U2(26, "", "", ""),
        Unit_WmulS(27, "", "", ""),
        Unit_AmulS(28, "", "", ""),
        Unit_UmulS(29, "", "", ""),
        Unit_WdivS(30, "", "", ""),
        Unit_AdivS(31, "", "", ""),
        Unit_UdivS(32, "", "", ""),
        Unit_bps(33, "", "", ""),
        Unit_End(34, "", "", ""),
        S_DIV(35, "s/div", "", ""),
        S_PT(36, "s/pt", "", ""),
        Unit_ip(37, "", "", ""),
        Unit_password(38, "", "", ""),
        Unit_number(39, "", "", ""),
        Unit_Hits(40, "", "", ""),
        Unit_dBmV(41, "dBmV", "", ""),
        Unit_dBuV(42, "dBuV", "", ""),
        Unit_decimal(43, "", "", ""),
        Unit_range(44, "Vpp", "", ""),
        Unit_X(45, "X", "", ""),
        Unit_VdivA(46, "V/A", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Unit(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Unit getUnitFromValue1(int i) {
        Unit[] values;
        for (Unit unit : Unit.values()) {
            if (i == unit.value1) {
                return unit;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Coupling {
        DC(0, "", "", ""),
        AC(1, "", "", ""),
        GND(2, "", "", ""),
        LF(3, "", "", ""),
        HF(4, "", "", ""),
        NOISE(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Coupling(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Coupling getCouplingFromValue1(int i) {
        Coupling[] values;
        for (Coupling coupling : Coupling.values()) {
            if (i == coupling.value1) {
                return coupling;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Bandwidth {
        BW_FULL(0, "FULL", "", ""),
        BW_OFF(1, "FULL", "", ""),
        BW_20M(2, "20M", "", ""),
        BW_25M(3, "25M", "", ""),
        BW_50M(4, "50M", "", ""),
        BW_70M(5, "70M", "", ""),
        BW_100M(6, "100M", "", ""),
        BW_125M(7, "125M", "", ""),
        BW_150M(8, "150M", "", ""),
        BW_200M(9, "200M", "", ""),
        BW_250M(10, "250M", "", ""),
        BW_300M(11, "300M", "", ""),
        BW_350M(12, "350M", "", ""),
        BW_400M(13, "400M", "", ""),
        BW_500M(14, "500M", "", ""),
        BW_600M(15, "600M", "", ""),
        BW_750M(16, "750M", "", ""),
        BW_800M(17, "800M", "", ""),
        BW_1G(18, "1G", "", ""),
        BW_2G(19, "2G", "", ""),
        BW_3G(20, "3G", "", ""),
        BW_4G(21, "4G", "", ""),
        BW_5G(22, "5G", "", ""),
        BW_6G(23, "6G", "", ""),
        BW_7G(24, "7G", "", ""),
        BW_8G(25, "8G", "", ""),
        BW_9G(26, "9G", "", ""),
        BW_10G(27, "10G", "", ""),
        BW_20G(28, "20G", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Bandwidth(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Bandwidth getBandwidthFromValue1(int i) {
        Bandwidth[] values;
        for (Bandwidth bandwidth : Bandwidth.values()) {
            if (i == bandwidth.value1) {
                return bandwidth;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Filter {
        Filter_lp(0, "", "", ""),
        Filter_hp(1, "", "", ""),
        Filter_bp(2, "", "", ""),
        Filter_bt(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Filter(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Filter getFilterFromValue1(int i) {
        Filter[] values;
        for (Filter filter : Filter.values()) {
            if (i == filter.value1) {
                return filter;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ProbeX {
        Probe_X0001(0, "0.0001", "", ""),
        Probe_X0002(1, "0.0002", "", ""),
        Probe_X0005(2, "0.0005", "", ""),
        Probe_X001(3, "0.001", "", ""),
        Probe_X002(4, "0.002", "", ""),
        Probe_X005(5, "0.005", "", ""),
        Probe_X01(6, "0.01", "", ""),
        Probe_X02(7, "0.02", "", ""),
        Probe_X05(8, "0.05", "", ""),
        Probe_X1(9, "0.1", "", ""),
        Probe_X2(10, "0.2", "", ""),
        Probe_X5(11, "0.5", "", ""),
        Probe_1X(12, "1.0", "", ""),
        Probe_2X(13, "2.0", "", ""),
        Probe_5X(14, "5.0", "", ""),
        Probe_10X(15, "10.0", "", ""),
        Probe_15X(16, "15.0", "", ""),
        Probe_20X(17, "20.0", "", ""),
        Probe_50X(18, "50.0", "", ""),
        Probe_100X(19, "100.0", "", ""),
        Probe_150X(20, "150.0", "", ""),
        Probe_200X(21, "200.0", "", ""),
        Probe_500X(22, "500.0", "", ""),
        Probe_1000X(23, "1000.0", "", ""),
        Probe_1500X(24, "1500.0", "", ""),
        Probe_2000X(25, "2000.0", "", ""),
        Probe_5000X(26, "5000.0", "", ""),
        Probe_10000X(27, "10000.0", "", ""),
        Probe_15000X(28, "15000.0", "", ""),
        Probe_20000X(29, "20000.0", "", ""),
        Probe_50000X(30, "50000.0", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ProbeX(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ProbeX getProbeXFromValue1(int i) {
        ProbeX[] values;
        for (ProbeX probeX : ProbeX.values()) {
            if (i == probeX.value1) {
                return probeX;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum LaScale {
        Small(0, "", "", ""),
        Medium(1, "", "", ""),
        Large(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        LaScale(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static LaScale getLaScaleFromValue1(int i) {
        LaScale[] values;
        for (LaScale laScale : LaScale.values()) {
            if (i == laScale.value1) {
                return laScale;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum chZone {
        time_zone(0, "", "", ""),
        freq_zone(1, "", "", ""),
        logic_zone(2, "", "", ""),
        trend_zone(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        chZone(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static chZone getchZoneFromValue1(int i) {
        chZone[] values;
        for (chZone chzone : chZone.values()) {
            if (i == chzone.value1) {
                return chzone;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum HorizontalZone {
        horizontal_time_zone(0, "", "", ""),
        horizontal_freq_zone(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        HorizontalZone(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static HorizontalZone getHorizontalZoneFromValue1(int i) {
        HorizontalZone[] values;
        for (HorizontalZone horizontalZone : HorizontalZone.values()) {
            if (i == horizontalZone.value1) {
                return horizontalZone;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AcquireMode {
        Acquire_Normal(0, "Norm", "", ""),
        Acquire_Peak(1, "Peak", "", ""),
        Acquire_Average(2, "Avg", "", ""),
        Acquire_HighResolution(3, "HiRes", "", ""),
        Acquire_Envelope(4, "Env", "", ""),
        Acquire_RMS(5, "RMS", "", ""),
        Acquire_Equ(6, "Equ", "", ""),
        Acquire_Ultra(7, "Ultra", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AcquireMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AcquireMode getAcquireModeFromValue1(int i) {
        AcquireMode[] values;
        for (AcquireMode acquireMode : AcquireMode.values()) {
            if (i == acquireMode.value1) {
                return acquireMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AcquireInterplate {
        Acquire_Auto(0, "", "", ""),
        Acquire_Line(1, "", "", ""),
        Acquire_Sinc(2, "", "", ""),
        Acquire_SH(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AcquireInterplate(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AcquireInterplate getAcquireInterplateFromValue1(int i) {
        AcquireInterplate[] values;
        for (AcquireInterplate acquireInterplate : AcquireInterplate.values()) {
            if (i == acquireInterplate.value1) {
                return acquireInterplate;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum HoriTimeMode {
        Horizontal_YT(0, "", "", ""),
        Horizontal_XY(1, "", "", ""),
        Horizontal_ROLL(2, "", "", ""),
        Horizontal_SCAN(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        HoriTimeMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static HoriTimeMode getHoriTimeModeFromValue1(int i) {
        HoriTimeMode[] values;
        for (HoriTimeMode horiTimeMode : HoriTimeMode.values()) {
            if (i == horiTimeMode.value1) {
                return horiTimeMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AcquireDepth {
        Acquire_Depth_Auto(0, "", "", ""),
        Acquire_Depth_1K(1, "", "", ""),
        Acquire_Depth_10K(2, "", "", ""),
        Acquire_Depth_100K(3, "", "", ""),
        Acquire_Depth_1M(4, "", "", ""),
        Acquire_Depth_5M(5, "", "", ""),
        Acquire_Depth_10M(6, "", "", ""),
        Acquire_Depth_25M(7, "", "", ""),
        Acquire_Depth_50M(8, "", "", ""),
        Acquire_Depth_100M(9, "", "", ""),
        Acquire_Depth_125M(10, "", "", ""),
        Acquire_Depth_200M(11, "", "", ""),
        Acquire_Depth_250M(12, "", "", ""),
        Acquire_Depth_500M(13, "", "", ""),
        Acquire_Depth_1G(14, "", "", ""),
        Acquire_Depth_2G(15, "", "", ""),
        Acquire_Depth_2_5G(16, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AcquireDepth(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AcquireDepth getAcquireDepthFromValue1(int i) {
        AcquireDepth[] values;
        for (AcquireDepth acquireDepth : AcquireDepth.values()) {
            if (i == acquireDepth.value1) {
                return acquireDepth;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum WaveView {
        Wave_View_Main(0, "", "", ""),
        Wave_View_Zoom(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        WaveView(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static WaveView getWaveViewFromValue1(int i) {
        WaveView[] values;
        for (WaveView waveView : WaveView.values()) {
            if (i == waveView.value1) {
                return waveView;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum HorizontalExpand {
        Horizontal_Expand_Center(0, "", "", ""),
        Horizontal_Expand_LB(1, "", "", ""),
        Horizontal_Expand_RB(2, "", "", ""),
        Horizontal_Expand_Trig(3, "", "", ""),
        Horizontal_Expand_User(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        HorizontalExpand(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static HorizontalExpand getHorizontalExpandFromValue1(int i) {
        HorizontalExpand[] values;
        for (HorizontalExpand horizontalExpand : HorizontalExpand.values()) {
            if (i == horizontalExpand.value1) {
                return horizontalExpand;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ControlAction {
        Control_Init(0, "", "", ""),
        Control_Stop(1, "", "", ""),
        Control_Run(2, "", "", ""),
        Control_Single(3, "", "", ""),
        Control_Play(4, "", "", ""),
        Control_Play_Last(5, "", "", ""),
        Control_Play_Run(6, "", "", ""),
        Control_Auto_Run(7, "", "", ""),
        Control_Scan_Play(8, "", "", ""),
        Control_Scan_Single(9, "", "", ""),
        Control_Play_Loop(10, "", "", ""),
        Control_Record(11, "", "", ""),
        Control_Record_Loop(12, "", "", ""),
        Control_Record_Play(13, "", "", ""),
        Control_Record_Play_Single(14, "", "", ""),
        Control_Import(15, "", "", ""),
        Control_Import_Play(16, "", "", ""),
        Control_Prepare_Param(17, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ControlAction(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ControlAction getControlActionFromValue1(int i) {
        ControlAction[] values;
        for (ControlAction controlAction : ControlAction.values()) {
            if (i == controlAction.value1) {
                return controlAction;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ControlStatus {
        Status_Stoped(0, "STOP", "", ""),
        Status_Running(1, "RUN", "", ""),
        Status_Autoing(2, "AUTO", "", ""),
        Status_Waiting(3, "WAIT", "", ""),
        Status_TD(4, "T'D", "", ""),
        Status_Playing(5, "Play", "", ""),
        Status_FPGA_ERR(6, "NULL", "", ""),
        Status_Force_Stoped(7, "STOP", "", ""),
        Status_Record(8, "RUN", "", ""),
        Status_Record_Play(9, "STOP", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ControlStatus(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ControlStatus getControlStatusFromValue1(int i) {
        ControlStatus[] values;
        for (ControlStatus controlStatus : ControlStatus.values()) {
            if (i == controlStatus.value1) {
                return controlStatus;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerMode {
        Trigger_Edge(0, "", "", ""),
        Trigger_Pulse(1, "", "", ""),
        Trigger_Slope(2, "", "", ""),
        Trigger_Video(3, "", "", ""),
        Trigger_Pattern(4, "", "", ""),
        Trigger_Duration(5, "", "", ""),
        Trigger_Timeout(6, "", "", ""),
        Trigger_Runt(7, "", "", ""),
        Trigger_Over(8, "", "", ""),
        Trigger_Window(9, "", "", ""),
        Trigger_Delay(10, "", "", ""),
        Trigger_Setup(11, "", "", ""),
        Trigger_NEdge(12, "", "", ""),
        Trigger_RS232(13, "", "", ""),
        Trigger_I2C(14, "", "", ""),
        Trigger_SPI(15, "", "", ""),
        Trigger_CAN(16, "", "", ""),
        Trigger_CANFD(17, "", "", ""),
        Trigger_FlexRay(18, "", "", ""),
        Trigger_LIN(19, "", "", ""),
        Trigger_I2S(20, "", "", ""),
        Trigger_SBUS(21, "", "", ""),
        Trigger_1553(22, "", "", ""),
        Trigger_429(23, "", "", ""),
        Trigger_SENT(24, "", "", ""),
        Trigger_Tmo(25, "", "", ""),
        Trigger_Logic(26, "", "", ""),
        Trigger_SH(27, "", "", ""),
        Trigger_AB(28, "", "", ""),
        Trigger_Area(29, "", "", ""),
        Trigger_All(30, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerMode getTriggerModeFromValue1(int i) {
        TriggerMode[] values;
        for (TriggerMode triggerMode : TriggerMode.values()) {
            if (i == triggerMode.value1) {
                return triggerMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum enumSearchType {
        SEARCH_TYPE_EDGE(0, "", "", ""),
        SEARCH_TYPE_PULSE(1, "", "", ""),
        SEARCH_TYPE_RUNT(2, "", "", ""),
        SEARCH_TYPE_SLOPE(3, "", "", ""),
        SEARCH_TYPE_RS232(4, "", "", ""),
        SEARCH_TYPE_IIC(5, "", "", ""),
        SEARCH_TYPE_SPI(6, "", "", ""),
        SEARCH_PATTREN(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        enumSearchType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static enumSearchType getenumSearchTypeFromValue1(int i) {
        enumSearchType[] values;
        for (enumSearchType enumsearchtype : enumSearchType.values()) {
            if (i == enumsearchtype.value1) {
                return enumsearchtype;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SearchCopyType {
        SEARCH_TO_TRIGGER(0, "", "", ""),
        TRIGGER_TO_SEARCH(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SearchCopyType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SearchCopyType getSearchCopyTypeFromValue1(int i) {
        SearchCopyType[] values;
        for (SearchCopyType searchCopyType : SearchCopyType.values()) {
            if (i == searchCopyType.value1) {
                return searchCopyType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerEvent {
        Trigger_A_Event(0, "", "", ""),
        Trigger_B_Event(1, "", "", ""),
        Trigger_R_Event(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerEvent(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerEvent getTriggerEventFromValue1(int i) {
        TriggerEvent[] values;
        for (TriggerEvent triggerEvent : TriggerEvent.values()) {
            if (i == triggerEvent.value1) {
                return triggerEvent;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggeMuxType {
        Trigger_Mux_A(0, "", "", ""),
        Trigger_Mux_A_or_B(1, "", "", ""),
        Trigger_Mux_A_and_B(2, "", "", ""),
        Trigger_Mux_ABR(3, "", "", ""),
        Trigger_Mux_Uart(4, "", "", ""),
        Trigger_Mux_I2S(5, "", "", ""),
        Trigger_Mux_Lin(6, "", "", ""),
        Trigger_Mux_Can(7, "", "", ""),
        Trigger_Mux_Flexray(8, "", "", ""),
        Trigger_Mux_Arinc429(9, "", "", ""),
        Trigger_Mux_Mil1553b(10, "", "", ""),
        Trigger_Mux_Sent(11, "", "", ""),
        Trigger_Mux_SPI(12, "", "", ""),
        Trigger_Mux_I2C(13, "", "", ""),
        Trigger_Mux_Video(14, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggeMuxType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggeMuxType getTriggeMuxTypeFromValue1(int i) {
        TriggeMuxType[] values;
        for (TriggeMuxType triggeMuxType : TriggeMuxType.values()) {
            if (i == triggeMuxType.value1) {
                return triggeMuxType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerSweep {
        Trigger_Sweep_Auto(0, "", "", ""),
        Trigger_Sweep_Normal(1, "", "", ""),
        Trigger_Sweep_Single(2, "", "", ""),
        Trigger_Sweep_Free(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerSweep(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerSweep getTriggerSweepFromValue1(int i) {
        TriggerSweep[] values;
        for (TriggerSweep triggerSweep : TriggerSweep.values()) {
            if (i == triggerSweep.value1) {
                return triggerSweep;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerHoldMode {
        Trigger_Hold_Random(0, "", "", ""),
        Trigger_Hold_Fixed(1, "", "", ""),
        Trigger_Hold_Auto(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerHoldMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerHoldMode getTriggerHoldModeFromValue1(int i) {
        TriggerHoldMode[] values;
        for (TriggerHoldMode triggerHoldMode : TriggerHoldMode.values()) {
            if (i == triggerHoldMode.value1) {
                return triggerHoldMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerHoldObj {
        Trigger_Hold_Time(0, "", "", ""),
        Trigger_Hold_Event(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerHoldObj(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerHoldObj getTriggerHoldObjFromValue1(int i) {
        TriggerHoldObj[] values;
        for (TriggerHoldObj triggerHoldObj : TriggerHoldObj.values()) {
            if (i == triggerHoldObj.value1) {
                return triggerHoldObj;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EdgeSlope {
        Trigger_Edge_Rising(0, "", "", ""),
        Trigger_Edge_Falling(1, "", "", ""),
        Trigger_Edge_Alternating(2, "", "", ""),
        Trigger_Edge_Any(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EdgeSlope(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EdgeSlope getEdgeSlopeFromValue1(int i) {
        EdgeSlope[] values;
        for (EdgeSlope edgeSlope : EdgeSlope.values()) {
            if (i == edgeSlope.value1) {
                return edgeSlope;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EMoreThan {
        Trigger_When_None(0, "", "", ""),
        Trigger_When_Morethan(1, "", "", ""),
        Trigger_When_Lessthan(2, "", "", ""),
        Trigger_When_MoreLess(3, "", "", ""),
        Trigger_When_UnMoreLess(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EMoreThan(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EMoreThan getEMoreThanFromValue1(int i) {
        EMoreThan[] values;
        for (EMoreThan eMoreThan : EMoreThan.values()) {
            if (i == eMoreThan.value1) {
                return eMoreThan;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerPulsePolarity {
        Trigger_pulse_positive(0, "", "", ""),
        Trigger_pulse_negative(1, "", "", ""),
        Trigger_pulse_any(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerPulsePolarity(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerPulsePolarity getTriggerPulsePolarityFromValue1(int i) {
        TriggerPulsePolarity[] values;
        for (TriggerPulsePolarity triggerPulsePolarity : TriggerPulsePolarity.values()) {
            if (i == triggerPulsePolarity.value1) {
                return triggerPulsePolarity;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum WindowEvent {
        Trigger_window_enter(0, "", "", ""),
        Trigger_window_exit(1, "", "", ""),
        Trigger_window_in_width(2, "", "", ""),
        Trigger_window_out_width(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        WindowEvent(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static WindowEvent getWindowEventFromValue1(int i) {
        WindowEvent[] values;
        for (WindowEvent windowEvent : WindowEvent.values()) {
            if (i == windowEvent.value1) {
                return windowEvent;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SHEvent {
        Trigger_SH_setup(0, "", "", ""),
        Trigger_SH_hold(1, "", "", ""),
        Trigger_SH_setup_hold(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SHEvent(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SHEvent getSHEventFromValue1(int i) {
        SHEvent[] values;
        for (SHEvent sHEvent : SHEvent.values()) {
            if (i == sHEvent.value1) {
                return sHEvent;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum OverEvent {
        Trigger_over_enter(0, "", "", ""),
        Trigger_over_exit(1, "", "", ""),
        Trigger_over_time(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        OverEvent(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static OverEvent getOverEventFromValue1(int i) {
        OverEvent[] values;
        for (OverEvent overEvent : OverEvent.values()) {
            if (i == overEvent.value1) {
                return overEvent;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerPattern {
        Trigger_pat_h(0, "", "", ""),
        Trigger_pat_l(1, "", "", ""),
        Trigger_pat_x(2, "", "", ""),
        Trigger_pat_rise(3, "", "", ""),
        Trigger_pat_fall(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerPattern(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerPattern getTriggerPatternFromValue1(int i) {
        TriggerPattern[] values;
        for (TriggerPattern triggerPattern : TriggerPattern.values()) {
            if (i == triggerPattern.value1) {
                return triggerPattern;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerLogicOperator {
        Trigger_logic_and(0, "", "", ""),
        Trigger_logic_or(1, "", "", ""),
        Trigger_logic_nand(2, "", "", ""),
        Trigger_logic_nor(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerLogicOperator(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerLogicOperator getTriggerLogicOperatorFromValue1(int i) {
        TriggerLogicOperator[] values;
        for (TriggerLogicOperator triggerLogicOperator : TriggerLogicOperator.values()) {
            if (i == triggerLogicOperator.value1) {
                return triggerLogicOperator;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Level_ID {
        Trigger_Level_High(0, "", "", ""),
        Trigger_Level_Low(1, "", "", ""),
        Trigger_Level_Double(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Level_ID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Level_ID getTrigger_Level_IDFromValue1(int i) {
        Trigger_Level_ID[] values;
        for (Trigger_Level_ID trigger_Level_ID : Trigger_Level_ID.values()) {
            if (i == trigger_Level_ID.value1) {
                return trigger_Level_ID;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Video_Sync {
        trig_video_any_line(0, "", "", ""),
        trig_video_x_line(1, "", "", ""),
        trig_video_odd(2, "", "", ""),
        trig_video_even(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Video_Sync(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Video_Sync getTrigger_Video_SyncFromValue1(int i) {
        Trigger_Video_Sync[] values;
        for (Trigger_Video_Sync trigger_Video_Sync : Trigger_Video_Sync.values()) {
            if (i == trigger_Video_Sync.value1) {
                return trigger_Video_Sync;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Video_Format {
        Video_Stardard_NTSC(0, "", "", ""),
        Video_Stardard_PAL(1, "", "", ""),
        Video_Stardard_480P_60Hz(2, "", "", ""),
        Video_Stardard_576P_60Hz(3, "", "", ""),
        Video_Stardard_720P_60Hz(4, "", "", ""),
        Video_Stardard_720P_50Hz(5, "", "", ""),
        Video_Stardard_720P_30Hz(6, "", "", ""),
        Video_Stardard_720P_25Hz(7, "", "", ""),
        Video_Stardard_720P_24Hz(8, "", "", ""),
        Video_Stardard_1080P_60Hz(9, "", "", ""),
        Video_Stardard_1080P_50Hz(10, "", "", ""),
        Video_Stardard_1080P_30Hz(11, "", "", ""),
        Video_Stardard_1080P_25Hz(12, "", "", ""),
        Video_Stardard_1080P_24Hz(13, "", "", ""),
        Video_Stardard_1080i_60Hz(14, "", "", ""),
        Video_Stardard_1080i_50Hz(15, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Video_Format(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Video_Format getTrigger_Video_FormatFromValue1(int i) {
        Trigger_Video_Format[] values;
        for (Trigger_Video_Format trigger_Video_Format : Trigger_Video_Format.values()) {
            if (i == trigger_Video_Format.value1) {
                return trigger_Video_Format;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Video_level {
        trig_video_bi(0, "", "", ""),
        trig_video_tri(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Video_level(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Video_level getTrigger_Video_levelFromValue1(int i) {
        Trigger_Video_level[] values;
        for (Trigger_Video_level trigger_Video_level : Trigger_Video_level.values()) {
            if (i == trigger_Video_level.value1) {
                return trigger_Video_level;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_value_cmp {
        cmp_eq(0, "", "", ""),
        cmp_neq(1, "", "", ""),
        cmp_gt(2, "", "", ""),
        cmp_lt(3, "", "", ""),
        cmp_in(4, "", "", ""),
        cmp_out(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_value_cmp(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_value_cmp getTrigger_value_cmpFromValue1(int i) {
        Trigger_value_cmp[] values;
        for (Trigger_value_cmp trigger_value_cmp : Trigger_value_cmp.values()) {
            if (i == trigger_value_cmp.value1) {
                return trigger_value_cmp;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_RS232_Event {
        RS232_When_Start(0, "", "", ""),
        RS232_When_Data(1, "", "", ""),
        RS232_When_Error(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_RS232_Event(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_RS232_Event getTrigger_RS232_EventFromValue1(int i) {
        Trigger_RS232_Event[] values;
        for (Trigger_RS232_Event trigger_RS232_Event : Trigger_RS232_Event.values()) {
            if (i == trigger_RS232_Event.value1) {
                return trigger_RS232_Event;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_RS232_Error {
        RS232_Err_Check(0, "", "", ""),
        RS232_Err_Stop(1, "", "", ""),
        RS232_Err_All(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_RS232_Error(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_RS232_Error getTrigger_RS232_ErrorFromValue1(int i) {
        Trigger_RS232_Error[] values;
        for (Trigger_RS232_Error trigger_RS232_Error : Trigger_RS232_Error.values()) {
            if (i == trigger_RS232_Error.value1) {
                return trigger_RS232_Error;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_RS232_When {
        rs232_when_start(0, "", "", ""),
        rs232_when_error(1, "", "", ""),
        rs232_when_check_error(2, "", "", ""),
        rs232_when_data(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_RS232_When(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_RS232_When getTrigger_RS232_WhenFromValue1(int i) {
        Trigger_RS232_When[] values;
        for (Trigger_RS232_When trigger_RS232_When : Trigger_RS232_When.values()) {
            if (i == trigger_RS232_When.value1) {
                return trigger_RS232_When;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_RS232_Stop {
        STOP_WIDTH_1(0, "", "", ""),
        STOP_WIDTH_2(1, "", "", ""),
        STOP_WIDTH_1_5(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_RS232_Stop(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_RS232_Stop getTrigger_RS232_StopFromValue1(int i) {
        Trigger_RS232_Stop[] values;
        for (Trigger_RS232_Stop trigger_RS232_Stop : Trigger_RS232_Stop.values()) {
            if (i == trigger_RS232_Stop.value1) {
                return trigger_RS232_Stop;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_RS232_Parity {
        RS232_Parity_None(0, "", "", ""),
        RS232_Parity_Odd(1, "", "", ""),
        RS232_Parity_Even(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_RS232_Parity(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_RS232_Parity getTrigger_RS232_ParityFromValue1(int i) {
        Trigger_RS232_Parity[] values;
        for (Trigger_RS232_Parity trigger_RS232_Parity : Trigger_RS232_Parity.values()) {
            if (i == trigger_RS232_Parity.value1) {
                return trigger_RS232_Parity;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_RS232_Width {
        RS232_Width_5(4, "", "", ""),
        RS232_Width_6(5, "", "", ""),
        RS232_Width_7(6, "", "", ""),
        RS232_Width_8(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_RS232_Width(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_RS232_Width getTrigger_RS232_WidthFromValue1(int i) {
        Trigger_RS232_Width[] values;
        for (Trigger_RS232_Width trigger_RS232_Width : Trigger_RS232_Width.values()) {
            if (i == trigger_RS232_Width.value1) {
                return trigger_RS232_Width;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EBaudRate {
        BaudRate_50(50, "", "", ""),
        BaudRate_75(75, "", "", ""),
        BaudRate_110(110, "", "", ""),
        BaudRate_134(134, "", "", ""),
        BaudRate_150(150, "", "", ""),
        BaudRate_300(300, "", "", ""),
        BaudRate_600(600, "", "", ""),
        BaudRate_1000(1000, "", "", ""),
        BaudRate_1200(1200, "", "", ""),
        BaudRate_1800(MessageID.MSG_CHAN_INVERT, "", "", ""),
        BaudRate_2000(PackageUtilKt.ERROR_PACKAGE_FILE_DOWNLOAD, "", "", ""),
        BaudRate_2400(2400, "", "", ""),
        BaudRate_4800(4800, "", "", ""),
        BaudRate_9600(9600, "", "", ""),
        BaudRate_10000(10000, "", "", ""),
        BaudRate_20000(20000, "", "", ""),
        BaudRate_19200(MessageID.MSG_APP_STORAGE, "", "", ""),
        BaudRate_33300(33300, "", "", ""),
        BaudRate_38400(48400, "", "", ""),
        BaudRate_50000(50000, "", "", ""),
        BaudRate_57600(57600, "", "", ""),
        BaudRate_62500(62500, "", "", ""),
        BaudRate_83300(83300, "", "", ""),
        BaudRate_100000(100000, "", "", ""),
        BaudRate_115200(115200, "", "", ""),
        BaudRate_125000(125000, "", "", ""),
        BaudRate_230400(230400, "", "", ""),
        BaudRate_250000(250000, "", "", ""),
        BaudRate_460800(460800, "", "", ""),
        BaudRate_500000(500000, "", "", ""),
        BaudRate_800000(800000, "", "", ""),
        BaudRate_921600(921600, "", "", ""),
        BaudRate_1Mbps(1000000, "", "", ""),
        BaudRate_2Mbps(2000000, "", "", ""),
        BaudRate_3Mbps(3000000, "", "", ""),
        BaudRate_4Mbps(4000000, "", "", ""),
        BaudRate_5Mbps(5000000, "", "", ""),
        BaudRate_6Mbps(6000000, "", "", ""),
        BaudRate_7Mbps(7000000, "", "", ""),
        BaudRate_8Mbps(8000000, "", "", ""),
        BaudRate_9Mbps(9000000, "", "", ""),
        BaudRate_10Mbps(10000000, "", "", ""),
        BaudRate_20Mbps(20000000, "", "", ""),
        BaudRate_Is_User(1, "", "", ""),
        BaudRate_All(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EBaudRate(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EBaudRate getEBaudRateFromValue1(int i) {
        EBaudRate[] values;
        for (EBaudRate eBaudRate : EBaudRate.values()) {
            if (i == eBaudRate.value1) {
                return eBaudRate;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_IIS_data_cmp {
        trig_iis_data_eq(0, "", "", ""),
        trig_iis_data_neq(1, "", "", ""),
        trig_iis_data_mt(2, "", "", ""),
        trig_iis_data_lt(3, "", "", ""),
        trig_iis_data_in(4, "", "", ""),
        trig_iis_data_out(5, "", "", ""),
        trig_iis_data_cross(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_IIS_data_cmp(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_IIS_data_cmp getTrigger_IIS_data_cmpFromValue1(int i) {
        Trigger_IIS_data_cmp[] values;
        for (Trigger_IIS_data_cmp trigger_IIS_data_cmp : Trigger_IIS_data_cmp.values()) {
            if (i == trigger_IIS_data_cmp.value1) {
                return trigger_IIS_data_cmp;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_IIS_Ch {
        trig_iis_lch(0, "", "", ""),
        trig_iis_rch(1, "", "", ""),
        trig_iis_anych(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_IIS_Ch(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_IIS_Ch getTrigger_IIS_ChFromValue1(int i) {
        Trigger_IIS_Ch[] values;
        for (Trigger_IIS_Ch trigger_IIS_Ch : Trigger_IIS_Ch.values()) {
            if (i == trigger_IIS_Ch.value1) {
                return trigger_IIS_Ch;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_IIS_Spec {
        trig_iis_standard(0, "", "", ""),
        trig_iis_left_justified(1, "", "", ""),
        trig_iis_right_justified(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_IIS_Spec(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_IIS_Spec getTrigger_IIS_SpecFromValue1(int i) {
        Trigger_IIS_Spec[] values;
        for (Trigger_IIS_Spec trigger_IIS_Spec : Trigger_IIS_Spec.values()) {
            if (i == trigger_IIS_Spec.value1) {
                return trigger_IIS_Spec;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Lin_When {
        trig_lin_sync(0, "", "", ""),
        trig_lin_id(1, "", "", ""),
        trig_lin_data(2, "", "", ""),
        trig_lin_id_data(3, "", "", ""),
        trig_lin_sleep(4, "", "", ""),
        trig_lin_wakeup(5, "", "", ""),
        trig_lin_err(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Lin_When(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Lin_When getTrigger_Lin_WhenFromValue1(int i) {
        Trigger_Lin_When[] values;
        for (Trigger_Lin_When trigger_Lin_When : Trigger_Lin_When.values()) {
            if (i == trigger_Lin_When.value1) {
                return trigger_Lin_When;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Lin_Err {
        trig_lin_sync_err(0, "", "", ""),
        trig_lin_id_err(1, "", "", ""),
        trig_lin_check_err(2, "", "", ""),
        trig_lin_any_err(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Lin_Err(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Lin_Err getTrigger_Lin_ErrFromValue1(int i) {
        Trigger_Lin_Err[] values;
        for (Trigger_Lin_Err trigger_Lin_Err : Trigger_Lin_Err.values()) {
            if (i == trigger_Lin_Err.value1) {
                return trigger_Lin_Err;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Lin_Ver {
        trig_lin_ver_1x(0, "", "", ""),
        trig_lin_ver_2x(1, "", "", ""),
        trig_lin_ver_any(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Lin_Ver(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Lin_Ver getTrigger_Lin_VerFromValue1(int i) {
        Trigger_Lin_Ver[] values;
        for (Trigger_Lin_Ver trigger_Lin_Ver : Trigger_Lin_Ver.values()) {
            if (i == trigger_Lin_Ver.value1) {
                return trigger_Lin_Ver;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Can_When {
        trig_can_field(0, "", "", ""),
        trig_can_frame(1, "", "", ""),
        trig_can_err(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Can_When(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Can_When getTrigger_Can_WhenFromValue1(int i) {
        Trigger_Can_When[] values;
        for (Trigger_Can_When trigger_Can_When : Trigger_Can_When.values()) {
            if (i == trigger_Can_When.value1) {
                return trigger_Can_When;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Can_Field {
        trig_can_filed_start(0, "", "", ""),
        trig_can_field_arb(1, "", "", ""),
        trig_can_field_con(2, "", "", ""),
        trig_can_field_data(3, "", "", ""),
        trig_can_field_crc(4, "", "", ""),
        trig_can_field_ack(5, "", "", ""),
        trig_can_field_end(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Can_Field(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Can_Field getTrigger_Can_FieldFromValue1(int i) {
        Trigger_Can_Field[] values;
        for (Trigger_Can_Field trigger_Can_Field : Trigger_Can_Field.values()) {
            if (i == trigger_Can_Field.value1) {
                return trigger_Can_Field;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Can_Frame {
        trig_can_frame_data(0, "", "", ""),
        trig_can_frame_rmt(1, "", "", ""),
        trig_can_frame_err(2, "", "", ""),
        trig_can_frame_overload(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Can_Frame(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Can_Frame getTrigger_Can_FrameFromValue1(int i) {
        Trigger_Can_Frame[] values;
        for (Trigger_Can_Frame trigger_Can_Frame : Trigger_Can_Frame.values()) {
            if (i == trigger_Can_Frame.value1) {
                return trigger_Can_Frame;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Can_Err {
        trig_can_err_bitfilled(0, "", "", ""),
        trig_can_err_crc(1, "", "", ""),
        trig_can_err_form(2, "", "", ""),
        trig_can_err_ack(3, "", "", ""),
        trig_can_err_any(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Can_Err(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Can_Err getTrigger_Can_ErrFromValue1(int i) {
        Trigger_Can_Err[] values;
        for (Trigger_Can_Err trigger_Can_Err : Trigger_Can_Err.values()) {
            if (i == trigger_Can_Err.value1) {
                return trigger_Can_Err;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Can_Phy {
        trig_can_h(0, "", "", ""),
        trig_can_l(1, "", "", ""),
        trig_can_tx_rx(2, "", "", ""),
        trig_can_diff(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Can_Phy(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Can_Phy getTrigger_Can_PhyFromValue1(int i) {
        Trigger_Can_Phy[] values;
        for (Trigger_Can_Phy trigger_Can_Phy : Trigger_Can_Phy.values()) {
            if (i == trigger_Can_Phy.value1) {
                return trigger_Can_Phy;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Can_Spec {
        trig_can_norm(0, "", "", ""),
        trig_can_extend(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Can_Spec(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Can_Spec getTrigger_Can_SpecFromValue1(int i) {
        Trigger_Can_Spec[] values;
        for (Trigger_Can_Spec trigger_Can_Spec : Trigger_Can_Spec.values()) {
            if (i == trigger_Can_Spec.value1) {
                return trigger_Can_Spec;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Serv_Can_When {
        trig_can_when_sof(0, "", "", ""),
        trig_can_when_eof(1, "", "", ""),
        trig_can_when_remote_id(2, "", "", ""),
        trig_can_when_overload(3, "", "", ""),
        trig_can_when_frame_id(4, "", "", ""),
        trig_can_when_frame_data(5, "", "", ""),
        trig_can_when_frame_data_id(6, "", "", ""),
        trig_can_when_frame_error(7, "", "", ""),
        trig_can_when_bit_error(8, "", "", ""),
        trig_can_when_answer_error(9, "", "", ""),
        trig_can_when_check_error(10, "", "", ""),
        trig_can_when_format_error(11, "", "", ""),
        trig_can_when_random_error(12, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Serv_Can_When(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Serv_Can_When getTrigger_Serv_Can_WhenFromValue1(int i) {
        Trigger_Serv_Can_When[] values;
        for (Trigger_Serv_Can_When trigger_Serv_Can_When : Trigger_Serv_Can_When.values()) {
            if (i == trigger_Serv_Can_When.value1) {
                return trigger_Serv_Can_When;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Flex_When {
        trig_flex_pos(0, "", "", ""),
        trig_flex_frame(1, "", "", ""),
        trig_flex_symbol(2, "", "", ""),
        trig_flex_err(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Flex_When(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Flex_When getTrigger_Flex_WhenFromValue1(int i) {
        Trigger_Flex_When[] values;
        for (Trigger_Flex_When trigger_Flex_When : Trigger_Flex_When.values()) {
            if (i == trigger_Flex_When.value1) {
                return trigger_Flex_When;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Flex_Pos {
        trig_flex_pos_tss_end(0, "", "", ""),
        trig_flex_pos_fss_bss_end(1, "", "", ""),
        trig_flex_pos_fes_end(2, "", "", ""),
        trig_flex_pos_dts_end(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Flex_Pos(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Flex_Pos getTrigger_Flex_PosFromValue1(int i) {
        Trigger_Flex_Pos[] values;
        for (Trigger_Flex_Pos trigger_Flex_Pos : Trigger_Flex_Pos.values()) {
            if (i == trigger_Flex_Pos.value1) {
                return trigger_Flex_Pos;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Flex_Frame {
        trig_flex_frame_invalid(0, "", "", ""),
        trig_flex_frame_sync(1, "", "", ""),
        trig_flex_frame_start(2, "", "", ""),
        trig_flex_frame_all(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Flex_Frame(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Flex_Frame getTrigger_Flex_FrameFromValue1(int i) {
        Trigger_Flex_Frame[] values;
        for (Trigger_Flex_Frame trigger_Flex_Frame : Trigger_Flex_Frame.values()) {
            if (i == trigger_Flex_Frame.value1) {
                return trigger_Flex_Frame;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Flex_Symbol {
        trig_flex_symbol_cas_mts(0, "", "", ""),
        trig_flex_symbol_wus(1, "", "", ""),
        trig_flex_symbol_wudop(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Flex_Symbol(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Flex_Symbol getTrigger_Flex_SymbolFromValue1(int i) {
        Trigger_Flex_Symbol[] values;
        for (Trigger_Flex_Symbol trigger_Flex_Symbol : Trigger_Flex_Symbol.values()) {
            if (i == trigger_Flex_Symbol.value1) {
                return trigger_Flex_Symbol;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Flex_Err {
        trig_flex_err_head_crc(0, "", "", ""),
        trig_flex_err_tail_crc(1, "", "", ""),
        trig_flex_err_decode(2, "", "", ""),
        trig_flex_err_any(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Flex_Err(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Flex_Err getTrigger_Flex_ErrFromValue1(int i) {
        Trigger_Flex_Err[] values;
        for (Trigger_Flex_Err trigger_Flex_Err : Trigger_Flex_Err.values()) {
            if (i == trigger_Flex_Err.value1) {
                return trigger_Flex_Err;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Flex_Baud {
        trig_flex_2_5M(2500000, "", "", ""),
        trig_flex_5M(5000000, "", "", ""),
        trig_flex_10M(10000000, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Flex_Baud(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Flex_Baud getTrigger_Flex_BaudFromValue1(int i) {
        Trigger_Flex_Baud[] values;
        for (Trigger_Flex_Baud trigger_Flex_Baud : Trigger_Flex_Baud.values()) {
            if (i == trigger_Flex_Baud.value1) {
                return trigger_Flex_Baud;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Flex_Phy {
        trig_flex_cha(0, "", "", ""),
        trig_flex_chb(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Flex_Phy(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Flex_Phy getTrigger_Flex_PhyFromValue1(int i) {
        Trigger_Flex_Phy[] values;
        for (Trigger_Flex_Phy trigger_Flex_Phy : Trigger_Flex_Phy.values()) {
            if (i == trigger_Flex_Phy.value1) {
                return trigger_Flex_Phy;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Spi_CS {
        trig_spi_cs(0, "", "", ""),
        trig_spi_idle(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Spi_CS(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Spi_CS getTrigger_Spi_CSFromValue1(int i) {
        Trigger_Spi_CS[] values;
        for (Trigger_Spi_CS trigger_Spi_CS : Trigger_Spi_CS.values()) {
            if (i == trigger_Spi_CS.value1) {
                return trigger_Spi_CS;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_I2C_When {
        trig_i2c_start(0, "", "", ""),
        trig_i2c_end(1, "", "", ""),
        trig_i2c_restart(2, "", "", ""),
        trig_i2c_nack(3, "", "", ""),
        trig_i2c_addr(4, "", "", ""),
        trig_i2c_data(5, "", "", ""),
        trig_i2c_addr_data(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_I2C_When(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_I2C_When getTrigger_I2C_WhenFromValue1(int i) {
        Trigger_I2C_When[] values;
        for (Trigger_I2C_When trigger_I2C_When : Trigger_I2C_When.values()) {
            if (i == trigger_I2C_When.value1) {
                return trigger_I2C_When;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_I2C_WR {
        trig_i2c_write(0, "", "", ""),
        trig_i2c_read(1, "", "", ""),
        trig_i2c_any(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_I2C_WR(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_I2C_WR getTrigger_I2C_WRFromValue1(int i) {
        Trigger_I2C_WR[] values;
        for (Trigger_I2C_WR trigger_I2C_WR : Trigger_I2C_WR.values()) {
            if (i == trigger_I2C_WR.value1) {
                return trigger_I2C_WR;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_I2C_Spec {
        trig_i2c_addr7(0, "", "", ""),
        trig_i2c_addr10(1, "", "", ""),
        trig_i2c_addr8(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_I2C_Spec(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_I2C_Spec getTrigger_I2C_SpecFromValue1(int i) {
        Trigger_I2C_Spec[] values;
        for (Trigger_I2C_Spec trigger_I2C_Spec : Trigger_I2C_Spec.values()) {
            if (i == trigger_I2C_Spec.value1) {
                return trigger_I2C_Spec;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_I2C_Width {
        trig_i2c_Width_1(0, "", "", ""),
        trig_i2c_Width_2(1, "", "", ""),
        trig_i2c_Width_3(2, "", "", ""),
        trig_i2c_Width_4(3, "", "", ""),
        trig_i2c_Width_5(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_I2C_Width(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_I2C_Width getTrigger_I2C_WidthFromValue1(int i) {
        Trigger_I2C_Width[] values;
        for (Trigger_I2C_Width trigger_I2C_Width : Trigger_I2C_Width.values()) {
            if (i == trigger_I2C_Width.value1) {
                return trigger_I2C_Width;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_1553_When {
        trig_1553_sync(0, "", "", ""),
        trig_1553_data(1, "", "", ""),
        trig_1553_cmd(2, "", "", ""),
        trig_1553_status(3, "", "", ""),
        trig_1553_err(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_1553_When(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_1553_When getTrigger_1553_WhenFromValue1(int i) {
        Trigger_1553_When[] values;
        for (Trigger_1553_When trigger_1553_When : Trigger_1553_When.values()) {
            if (i == trigger_1553_When.value1) {
                return trigger_1553_When;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_1553_Sync {
        trig_1553_sync_data(0, "", "", ""),
        trig_1553_sync_status(1, "", "", ""),
        trig_1553_sync_all(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_1553_Sync(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_1553_Sync getTrigger_1553_SyncFromValue1(int i) {
        Trigger_1553_Sync[] values;
        for (Trigger_1553_Sync trigger_1553_Sync : Trigger_1553_Sync.values()) {
            if (i == trigger_1553_Sync.value1) {
                return trigger_1553_Sync;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_1553_Err {
        trig_1553_err_sync(0, "", "", ""),
        trig_1553_err_check(1, "", "", ""),
        trig_1553_err_manchester(2, "", "", ""),
        trig_1553_err_trans_data_interval(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_1553_Err(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_1553_Err getTrigger_1553_ErrFromValue1(int i) {
        Trigger_1553_Err[] values;
        for (Trigger_1553_Err trigger_1553_Err : Trigger_1553_Err.values()) {
            if (i == trigger_1553_Err.value1) {
                return trigger_1553_Err;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum WfmPalette {
        Wfm_color(0, "", "", ""),
        Wfm_grade(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        WfmPalette(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static WfmPalette getWfmPaletteFromValue1(int i) {
        WfmPalette[] values;
        for (WfmPalette wfmPalette : WfmPalette.values()) {
            if (i == wfmPalette.value1) {
                return wfmPalette;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum WfmLineType {
        Wfm_Line(0, "", "", ""),
        Wfm_Dot(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        WfmLineType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static WfmLineType getWfmLineTypeFromValue1(int i) {
        WfmLineType[] values;
        for (WfmLineType wfmLineType : WfmLineType.values()) {
            if (i == wfmLineType.value1) {
                return wfmLineType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum enumRefID {
        REF1(0, "", "", ""),
        REF2(1, "", "", ""),
        REF3(2, "", "", ""),
        REF4(3, "", "", ""),
        REF5(4, "", "", ""),
        REF6(5, "", "", ""),
        REF7(6, "", "", ""),
        REF8(7, "", "", ""),
        REF9(8, "", "", ""),
        REF10(9, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        enumRefID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static enumRefID getenumRefIDFromValue1(int i) {
        enumRefID[] values;
        for (enumRefID enumrefid : enumRefID.values()) {
            if (i == enumrefid.value1) {
                return enumrefid;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DisplayFormat {
        F_HEX(0, "", "", ""),
        F_DEC(1, "", "", ""),
        F_BIN(2, "", "", ""),
        F_ASC(3, "", "", ""),
        F_LINE(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DisplayFormat(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DisplayFormat getDisplayFormatFromValue1(int i) {
        DisplayFormat[] values;
        for (DisplayFormat displayFormat : DisplayFormat.values()) {
            if (i == displayFormat.value1) {
                return displayFormat;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BitOrder {
        lsb(0, "", "", ""),
        msb(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BitOrder(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BitOrder getBitOrderFromValue1(int i) {
        BitOrder[] values;
        for (BitOrder bitOrder : BitOrder.values()) {
            if (i == bitOrder.value1) {
                return bitOrder;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum StopWidth {
        stop1(0, "", "", ""),
        stop1_5(1, "", "", ""),
        stop2(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        StopWidth(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static StopWidth getStopWidthFromValue1(int i) {
        StopWidth[] values;
        for (StopWidth stopWidth : StopWidth.values()) {
            if (i == stopWidth.value1) {
                return stopWidth;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum LinProtocol {
        Lin_1X(0, "", "", ""),
        Lin_2X(1, "", "", ""),
        Lin_both(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        LinProtocol(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static LinProtocol getLinProtocolFromValue1(int i) {
        LinProtocol[] values;
        for (LinProtocol linProtocol : LinProtocol.values()) {
            if (i == linProtocol.value1) {
                return linProtocol;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Parity {
        even(0, "", "", ""),
        odd(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Parity(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Parity getParityFromValue1(int i) {
        Parity[] values;
        for (Parity parity : Parity.values()) {
            if (i == parity.value1) {
                return parity;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MathOperator {
        operator_add(0, "", "", ""),
        operator_sub(1, "", "", ""),
        operator_mul(2, "", "", ""),
        operator_div(3, "", "", ""),
        operator_and(4, "", "", ""),
        operator_or(5, "", "", ""),
        operator_xor(6, "", "", ""),
        operator_not(7, "", "", ""),
        operator_fft(8, "", "", ""),
        operator_intg(9, "", "", ""),
        operator_diff(10, "", "", ""),
        operator_root(11, "", "", ""),
        operator_lg(12, "", "", ""),
        operator_ln(13, "", "", ""),
        operator_exp(14, "", "", ""),
        operator_abs(15, "", "", ""),
        operator_lp(16, "", "", ""),
        operator_hp(17, "", "", ""),
        operator_bp(18, "", "", ""),
        operator_bt(19, "", "", ""),
        operator_ax_b(20, "", "", ""),
        operator_trend(21, "", "", ""),
        operator_max(22, "", "", ""),
        operator_min(23, "", "", ""),
        operator_envelope(24, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MathOperator(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MathOperator getMathOperatorFromValue1(int i) {
        MathOperator[] values;
        for (MathOperator mathOperator : MathOperator.values()) {
            if (i == mathOperator.value1) {
                return mathOperator;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FftxType {
        fft_span_center(0, "", "", ""),
        fft_start_end(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FftxType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FftxType getFftxTypeFromValue1(int i) {
        FftxType[] values;
        for (FftxType fftxType : FftxType.values()) {
            if (i == fftxType.value1) {
                return fftxType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum VertExpand {
        vert_expand_gnd(0, "", "", ""),
        vert_expand_center(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        VertExpand(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static VertExpand getVertExpandFromValue1(int i) {
        VertExpand[] values;
        for (VertExpand vertExpand : VertExpand.values()) {
            if (i == vertExpand.value1) {
                return vertExpand;
            }
        }
        return null;
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
    public enum enVendorID {
        E_CFG_MANU(0, "", "", ""),
        E_CFG_MODEL(1, "", "", ""),
        E_CFG_BAND(2, "", "", ""),
        E_CFG_SN(3, "", "", ""),
        E_CFG_MODUELS(4, "", "", ""),
        E_CFG_MODEL_RAW(5, "", "", ""),
        E_CFG_BAND_RAW(6, "", "", ""),
        E_CFG_SN_RAW(7, "", "", ""),
        E_CFG_MODUELS_RAW(8, "", "", ""),
        E_CFG_MAC(9, "", "", ""),
        E_CFG_BUILD_TIME(10, "", "", ""),
        E_CFG_PROG_VER(11, "", "", ""),
        E_CFG_FIRM_VER(12, "", "", ""),
        E_CFG_CPLD_VER(13, "", "", ""),
        E_CFG_MCU_VER(14, "", "", ""),
        E_CFG_BOOT_VER(15, "", "", ""),
        E_CFG_BOARD_VER(16, "", "", ""),
        E_CFG_README(17, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        enVendorID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static enVendorID getenVendorIDFromValue1(int i) {
        enVendorID[] values;
        for (enVendorID envendorid : enVendorID.values()) {
            if (i == envendorid.value1) {
                return envendorid;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RefClock {
        REF_10MHz_OFF(1, "", "", ""),
        REF_10MHz_IN(0, "", "", ""),
        REF_10MHz_OUT(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RefClock(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RefClock getRefClockFromValue1(int i) {
        RefClock[] values;
        for (RefClock refClock : RefClock.values()) {
            if (i == refClock.value1) {
                return refClock;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum tagNET_STATUS_EN {
        NET_STATUS_UNLINK(0, "DISCONNECTED", "", ""),
        NET_STATUS_CONNECTED(1, "CONNECTED", "", ""),
        NET_STATUS_INIT(2, "INIT", "", ""),
        NET_STATUS_UNBOUND(3, "UNBOUND", "", ""),
        NET_STATUS_IPCONFLICT(4, "IP CONFLICT", "", ""),
        NET_STATUS_BUSY(5, "BUSY", "", ""),
        NET_STATUS_CONFIGURED(6, "CONFIGURED", "", ""),
        NET_STATUS_DHCP_FAILED(7, "DHCP FAILED", "", ""),
        NET_STATUS_INVALID_IP(8, "INVALID IP", "", ""),
        NET_STATUS_IP_LOSE(9, "IP LOSE", "", ""),
        NET_STATUS_SET_MAC(10, "SET MAC", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        tagNET_STATUS_EN(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static tagNET_STATUS_EN gettagNET_STATUS_ENFromValue1(int i) {
        tagNET_STATUS_EN[] values;
        for (tagNET_STATUS_EN tagnet_status_en : tagNET_STATUS_EN.values()) {
            if (i == tagnet_status_en.value1) {
                return tagnet_status_en;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum VisaType {
        visa_type_usb(0, "", "", ""),
        visa_type_lxi(1, "", "", ""),
        visa_type_socket(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        VisaType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static VisaType getVisaTypeFromValue1(int i) {
        VisaType[] values;
        for (VisaType visaType : VisaType.values()) {
            if (i == visaType.value1) {
                return visaType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MeasSrcType {
        Single_Src(0, "", "", ""),
        Delay_Double_Src(1, "", "", ""),
        Phase_Double_Src(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MeasSrcType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MeasSrcType getMeasSrcTypeFromValue1(int i) {
        MeasSrcType[] values;
        for (MeasSrcType measSrcType : MeasSrcType.values()) {
            if (i == measSrcType.value1) {
                return measSrcType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum StatType {
        STAT_MAX(0, "", "", ""),
        STAT_MIN(1, "", "", ""),
        STAT_CURR(2, "", "", ""),
        STAT_AVER(3, "", "", ""),
        STAT_DEV(4, "", "", ""),
        STAT_CNT(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        StatType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static StatType getStatTypeFromValue1(int i) {
        StatType[] values;
        for (StatType statType : StatType.values()) {
            if (i == statType.value1) {
                return statType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MeasType {
        Meas_HOR_TYPE(0, "", "", ""),
        Meas_Period(1, "", "ic_period", "diag_period"),
        Meas_Freq(2, "", "ic_freq", "diag_freq"),
        Meas_RiseTime(3, "", "ic_risetime", "diag_risetime"),
        Meas_FallTime(4, "", "ic_falltime", "diag_falltime"),
        Meas_PWidth(5, "", "ic_pwidth", "diag_pwidth"),
        Meas_NWidth(6, "", "ic_nwidth", "diag_nwidth"),
        Meas_PDuty(7, "", "ic_pduty", "diag_pduty"),
        Meas_NDuty(8, "", "ic_nduty", "diag_nduty"),
        Meas_PPulses(9, "", "ic_ppulses", "diag_ppulses"),
        Meas_NPulses(10, "", "ic_npulses", "diag_npulses"),
        Meas_PEdges(11, "", "ic_pedges", "diag_pedges"),
        Meas_NEdges(12, "", "ic_nedges", "diag_nedges"),
        Meas_Tvmax(13, "", "ic_tvmax", "diag_tvmax"),
        Meas_Tvmin(14, "", "ic_tvmin", "diag_tvmin"),
        Meas_Pslew_rate(15, "", "ic_pslew_rate", "diag_pslew_rate"),
        Meas_Nslew_rate(16, "", "ic_nslew_rate", "diag_nslew_rate"),
        Meas_HOR_TYPE_END(17, "", "", ""),
        Meas_VER_TYPE(18, "", "", ""),
        Meas_Vmax(19, "", "ic_vmax", "diag_vmax"),
        Meas_Vmin(20, "", "ic_vmin", "diag_vmin"),
        Meas_Vpp(21, "", "ic_vpp", "diag_vpp"),
        Meas_Vtop(22, "", "ic_vtop", "diag_vtop"),
        Meas_Vbase(23, "", "ic_vbase", "diag_vbase"),
        Meas_Vamp(24, "", "ic_vamp", "diag_vamp"),
        Meas_Vupper(25, "", "ic_vupper", "diag_vupper"),
        Meas_Vmid(26, "", "ic_vmid", "diag_vmid"),
        Meas_Vlower(27, "", "ic_vlower", "diag_vlower"),
        Meas_Vavg(28, "", "ic_vavg", "diag_vavg"),
        Meas_Vrms(29, "", "ic_vrms", "diag_vrms"),
        Meas_Vrms_S(30, "", "ic_vperiod_rms", "diag_vperiod_rms"),
        Meas_Overshoot(31, "", "ic_overshoot", "diag_overshoot"),
        Meas_Preshoot(32, "", "ic_preshoot", "diag_preshoot"),
        Meas_Area(33, "", "ic_area", "diag_area"),
        Meas_Area_S(34, "", "ic_periodarea", "diag_periodarea"),
        Meas_Variance(35, "", "ic_variance", "diag_variance"),
        Meas_VER_TYPE_END(36, "", "", ""),
        Meas_DOUBLE_SRC_TYPE(37, "", "", ""),
        Meas_DelayRR(38, "", "ic_delay_rise_rise", "diag_delayrr"),
        Meas_DelayRF(39, "", "ic_delay_rise_fall", "diag_delayrf"),
        Meas_DelayFR(40, "", "ic_delay_fall_rise", "diag_delayfr"),
        Meas_DelayFF(41, "", "ic_delay_fall_fall", "diag_delayff"),
        Meas_PhaseRR(42, "", "ic_phase_rise_rise", "diag_phaserr"),
        Meas_PhaseRF(43, "", "ic_phase_rise_fall", "diag_phaserf"),
        Meas_PhaseFR(44, "", "ic_phase_fall_rise", "diag_phasefr"),
        Meas_PhaseFF(45, "", "ic_phase_fall_fall", "diag_phaseff"),
        Meas_DOUBLE_SRC_TYPE_END(46, "", "", ""),
        UPA_Meas_Type(47, "", "", ""),
        UPA_Ref_Freq(48, "", "", ""),
        UPA_MAX(49, "", "", ""),
        UPA_RMS(50, "", "", ""),
        UPA_AVG(51, "", "", ""),
        UPA_Vrms(52, "", "", ""),
        UPA_Irms(53, "", "", ""),
        UPA_Real_P(54, "", "", ""),
        UPA_Apparent_P(55, "", "", ""),
        UPA_Reactive_P(56, "", "", ""),
        UPA_P_Factor(57, "", "", ""),
        UPA_Phase_Angle(58, "", "", ""),
        UPA_Imp(59, "", "", ""),
        UPA_V_CrestFactor(60, "", "", ""),
        UPA_I_CrestFactor(61, "", "", ""),
        UPA_Meas_END(62, "", "", ""),
        EYE_RESULT(63, "", "", ""),
        Jitter_CLK_TIE(64, "", "", ""),
        Jitter_DAT_TIE(65, "", "", ""),
        Jitter_CYC_CYC(66, "", "", ""),
        Jitter_POS_POS(67, "", "", ""),
        Jitter_NEG_NEG(68, "", "", ""),
        Jitter_Result(69, "", "", ""),
        Meas_DVM(70, "", "", ""),
        Meas_Counter(71, "", "", ""),
        Meas_Cursor(72, "", "", ""),
        Meas_Histogram(73, "", "", ""),
        Meas_Ripple(74, "", "", ""),
        Meas_Quality(75, "", "", ""),
        ALL_measData(76, "", "", ""),
        MASK_RESULT(77, "", "", ""),
        RTSA_MARKER1(78, "", "", ""),
        RTSA_MARKER2(79, "", "", ""),
        RTSA_MARKER3(80, "", "", ""),
        RTSA_MARKER4(81, "", "", ""),
        RTSA_MARKER5(82, "", "", ""),
        RTSA_MARKER6(83, "", "", ""),
        RTSA_MARKER7(84, "", "", ""),
        RTSA_MARKER8(85, "", "", ""),
        TEK_RISE(86, "", "", ""),
        TEK_FALL(87, "", "", ""),
        TEK_DELAY(88, "", "", ""),
        TEK_BACKW(89, "", "", ""),
        TEK_FORW(90, "", "", ""),
        TEK_Phase(91, "", "", ""),
        Meas_MHistogram(92, "", "", ""),
        Meas_Bode(93, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MeasType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MeasType getMeasTypeFromValue1(int i) {
        MeasType[] values;
        for (MeasType measType : MeasType.values()) {
            if (i == measType.value1) {
                return measType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CursorMode {
        cursor_mode_off(0, "", "", ""),
        cursor_mode_manual(1, "", "", ""),
        cursor_mode_track(2, "", "", ""),
        cursor_mode_auto(3, "", "", ""),
        cursor_mode_xy(4, "", "", ""),
        cursor_mode_meas(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CursorMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CursorMode getCursorModeFromValue1(int i) {
        CursorMode[] values;
        for (CursorMode cursorMode : CursorMode.values()) {
            if (i == cursorMode.value1) {
                return cursorMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CursorTrackMode {
        cursor_track_y(0, "", "", ""),
        cursor_track_x(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CursorTrackMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CursorTrackMode getCursorTrackModeFromValue1(int i) {
        CursorTrackMode[] values;
        for (CursorTrackMode cursorTrackMode : CursorTrackMode.values()) {
            if (i == cursorTrackMode.value1) {
                return cursorTrackMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CursorView {
        cursor_view_hori(0, "", "", ""),
        cursor_view_vert(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CursorView(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CursorView getCursorViewFromValue1(int i) {
        CursorView[] values;
        for (CursorView cursorView : CursorView.values()) {
            if (i == cursorView.value1) {
                return cursorView;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ThreType {
        TH_TYPE_PER(0, "", "", ""),
        TH_TYPE_ABS(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ThreType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ThreType getThreTypeFromValue1(int i) {
        ThreType[] values;
        for (ThreType threType : ThreType.values()) {
            if (i == threType.value1) {
                return threType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CounterMode {
        counter_freq(0, "", "", ""),
        counter_event(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CounterMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CounterMode getCounterModeFromValue1(int i) {
        CounterMode[] values;
        for (CounterMode counterMode : CounterMode.values()) {
            if (i == counterMode.value1) {
                return counterMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CounterType {
        FREQ(1, "", "", ""),
        PERIOD(2, "", "", ""),
        TOTALIZE(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CounterType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CounterType getCounterTypeFromValue1(int i) {
        CounterType[] values;
        for (CounterType counterType : CounterType.values()) {
            if (i == counterType.value1) {
                return counterType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CounterGate {
        counter_gate_high(0, "", "", ""),
        counter_gate_low(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CounterGate(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CounterGate getCounterGateFromValue1(int i) {
        CounterGate[] values;
        for (CounterGate counterGate : CounterGate.values()) {
            if (i == counterGate.value1) {
                return counterGate;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CounterEvent {
        counter_event_edge(0, "", "", ""),
        counter_event_trig(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CounterEvent(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CounterEvent getCounterEventFromValue1(int i) {
        CounterEvent[] values;
        for (CounterEvent counterEvent : CounterEvent.values()) {
            if (i == counterEvent.value1) {
                return counterEvent;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DvmMode {
        DVM_AC_RMS(0, "", "", ""),
        DVM_DC(1, "", "", ""),
        DVM_DC_RMS(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DvmMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DvmMode getDvmModeFromValue1(int i) {
        DvmMode[] values;
        for (DvmMode dvmMode : DvmMode.values()) {
            if (i == dvmMode.value1) {
                return dvmMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum HistoType {
        histoHori(0, "", "", ""),
        histoVert(1, "", "", ""),
        histoMeas(2, "", "", ""),
        histoJitter(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        HistoType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static HistoType getHistoTypeFromValue1(int i) {
        HistoType[] values;
        for (HistoType histoType : HistoType.values()) {
            if (i == histoType.value1) {
                return histoType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EyeMeasType {
        EYE_BEGIN(0, "", "", ""),
        EYE_ONE(0, "", "", ""),
        EYE_ZERO(1, "", "", ""),
        EYE_WIDTH(2, "", "", ""),
        EYE_HEIGHT(3, "", "", ""),
        EYE_AMP(4, "", "", ""),
        EYE_CROSSPER(5, "", "", ""),
        EYE_QFACTOR(6, "", "", ""),
        EYE_BR(7, "", "", ""),
        EYE_END(8, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EyeMeasType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EyeMeasType getEyeMeasTypeFromValue1(int i) {
        EyeMeasType[] values;
        for (EyeMeasType eyeMeasType : EyeMeasType.values()) {
            if (i == eyeMeasType.value1) {
                return eyeMeasType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum enFileType {
        FILETYPE_PNG(0, "png", "", ""),
        FILETYPE_BMP(1, "bmp", "", ""),
        FILETYPE_JPG(2, "jpg", "", ""),
        FILETYPE_TIF(3, "tif", "", ""),
        FILETYPE_GIF(4, "gif", "", ""),
        FILETYPE_BIN(5, "bin", "", ""),
        FILETYPE_CSV(6, "csv", "", ""),
        FILETYPE_WFM(7, "wfm", "", ""),
        FILETYPE_REF(8, "ref", "", ""),
        FILETYPE_STP(9, "stp", "", ""),
        FILETYPE_PF(10, "pf", "", ""),
        FILETYPE_HTM(11, "htm", "", ""),
        FILETYPE_ARB(12, "arb", "", ""),
        FILETYPE_REC(13, "rec", "", ""),
        FILETYPE_TXT(14, "txt", "", ""),
        FILETYPE_GEL(15, "gel", "", ""),
        FILETYPE_DAT(16, "dat", "", ""),
        FILETYPE_ANY(17, "any", "", ""),
        FILETYPE_HTML(18, "html", "", ""),
        All_FILETYPE(19, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        enFileType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static enFileType getenFileTypeFromValue1(int i) {
        enFileType[] values;
        for (enFileType enfiletype : enFileType.values()) {
            if (i == enfiletype.value1) {
                return enfiletype;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RecAction {
        Rec_start(0, "", "", ""),
        Rec_stop(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RecAction(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RecAction getRecActionFromValue1(int i) {
        RecAction[] values;
        for (RecAction recAction : RecAction.values()) {
            if (i == recAction.value1) {
                return recAction;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum PlayAction {
        Play_start(0, "", "", ""),
        Play_stop(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        PlayAction(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static PlayAction getPlayActionFromValue1(int i) {
        PlayAction[] values;
        for (PlayAction playAction : PlayAction.values()) {
            if (i == playAction.value1) {
                return playAction;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum PlayDirection {
        Play_Inc(0, "", "", ""),
        Play_Dec(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        PlayDirection(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static PlayDirection getPlayDirectionFromValue1(int i) {
        PlayDirection[] values;
        for (PlayDirection playDirection : PlayDirection.values()) {
            if (i == playDirection.value1) {
                return playDirection;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MaskActionEvent {
        mask_action_on_fail(0, "", "", ""),
        mask_action_on_pass(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MaskActionEvent(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MaskActionEvent getMaskActionEventFromValue1(int i) {
        MaskActionEvent[] values;
        for (MaskActionEvent maskActionEvent : MaskActionEvent.values()) {
            if (i == maskActionEvent.value1) {
                return maskActionEvent;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MaskActionAction {
        mask_action_none(0, "", "", ""),
        mask_action_stop(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MaskActionAction(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MaskActionAction getMaskActionActionFromValue1(int i) {
        MaskActionAction[] values;
        for (MaskActionAction maskActionAction : MaskActionAction.values()) {
            if (i == maskActionAction.value1) {
                return maskActionAction;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MaskRange {
        mask_range_screen(0, "", "", ""),
        mask_range_user(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MaskRange(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MaskRange getMaskRangeFromValue1(int i) {
        MaskRange[] values;
        for (MaskRange maskRange : MaskRange.values()) {
            if (i == maskRange.value1) {
                return maskRange;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MaskPolarity {
        mask_polarity_positive(1, "", "", ""),
        mask_polarity_negative(0, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MaskPolarity(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MaskPolarity getMaskPolarityFromValue1(int i) {
        MaskPolarity[] values;
        for (MaskPolarity maskPolarity : MaskPolarity.values()) {
            if (i == maskPolarity.value1) {
                return maskPolarity;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EWaveFormat {
        FORMAT_IS_VECTOR(0, "", "", ""),
        FORMAT_IS_DOTS(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EWaveFormat(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EWaveFormat getEWaveFormatFromValue1(int i) {
        EWaveFormat[] values;
        for (EWaveFormat eWaveFormat : EWaveFormat.values()) {
            if (i == eWaveFormat.value1) {
                return eWaveFormat;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EWavePersis {
        PERSIS_IS_NONE(0, "", "", ""),
        PERSIS_IS_100MS(1, "", "", ""),
        PERSIS_IS_200MS(2, "", "", ""),
        PERSIS_IS_500MS(3, "", "", ""),
        PERSIS_IS_1S(4, "", "", ""),
        PERSIS_IS_2S(5, "", "", ""),
        PERSIS_IS_5S(6, "", "", ""),
        PERSIS_IS_10S(7, "", "", ""),
        PERSIS_IS_INFINITE(8, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EWavePersis(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EWavePersis getEWavePersisFromValue1(int i) {
        EWavePersis[] values;
        for (EWavePersis eWavePersis : EWavePersis.values()) {
            if (i == eWavePersis.value1) {
                return eWavePersis;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EWaveGrids {
        GRID_IS_FULL(0, "", "", ""),
        GRID_IS_HALF(1, "", "", ""),
        GRID_IS_NONE(2, "", "", ""),
        GRID_IS_IRE(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EWaveGrids(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EWaveGrids getEWaveGridsFromValue1(int i) {
        EWaveGrids[] values;
        for (EWaveGrids eWaveGrids : EWaveGrids.values()) {
            if (i == eWaveGrids.value1) {
                return eWaveGrids;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum scpiEvent {
        scpi_event_ch1_overload(0, "", "", ""),
        scpi_event_ch2_overload(1, "", "", ""),
        scpi_event_ch3_overload(2, "", "", ""),
        scpi_event_ch4_overload(3, "", "", ""),
        scpi_event_ext_overload(4, "", "", ""),
        scpi_event_ch1_fault(5, "", "", ""),
        scpi_event_ch2_fault(6, "", "", ""),
        scpi_event_ch3_fault(7, "", "", ""),
        scpi_event_ch4_fault(8, "", "", ""),
        scpi_event_ext_fault(9, "", "", ""),
        scpi_event_mask_complete(10, "", "", ""),
        scpi_event_mask_fail(11, "", "", ""),
        scpi_event_mask_started(12, "", "", ""),
        scpi_event_io_complete(13, "", "", ""),
        scpi_event_io_fail(14, "", "", ""),
        scpi_event_calibrating(15, "", "", ""),
        scpi_event_setting(16, "", "", ""),
        scpi_event_ranging(17, "", "", ""),
        scpi_event_sweeping(18, "", "", ""),
        scpi_event_measuring(19, "", "", ""),
        scpi_event_waitingfortrigger(20, "", "", ""),
        scpi_event_waitingforarm(21, "", "", ""),
        scpi_event_correcting(22, "", "", ""),
        scpi_event_inst_summary(23, "", "", ""),
        scpi_event_command_warnning(24, "", "", ""),
        scpi_event_operation_complete(25, "", "", ""),
        scpi_event_request_control(26, "", "", ""),
        scpi_event_query_error(27, "", "", ""),
        scpi_event_device_depend_error(28, "", "", ""),
        scpi_event_execution_error(29, "", "", ""),
        scpi_event_command_error(30, "", "", ""),
        scpi_event_user_request(31, "", "", ""),
        scpi_event_power_on(32, "", "", ""),
        scpi_event_ques_voltage(33, "", "", ""),
        scpi_event_ques_current(34, "", "", ""),
        scpi_event_ques_time(35, "", "", ""),
        scpi_event_ques_power(36, "", "", ""),
        scpi_event_ques_temperature(37, "", "", ""),
        scpi_event_ques_frequency(38, "", "", ""),
        scpi_event_ques_phase(39, "", "", ""),
        scpi_event_ques_modulation(40, "", "", ""),
        scpi_event_ques_calibration(41, "", "", ""),
        scpi_event_ques_cdyno_summary(42, "", "", ""),
        scpi_event_ques_reserve1(43, "", "", ""),
        scpi_event_ques_reserve2(44, "", "", ""),
        scpi_event_ques_reserve3(45, "", "", ""),
        scpi_event_ques_instrument(46, "", "", ""),
        scpi_event_ques_cmdwarning(47, "", "", ""),
        scpi_event_ques_notused(48, "", "", ""),
        scpi_event_oper_calibrating(49, "", "", ""),
        scpi_event_oper_setting(50, "", "", ""),
        scpi_event_oper_ranging(51, "", "", ""),
        scpi_event_oper_sweoping(52, "", "", ""),
        scpi_event_oper_measuring(53, "", "", ""),
        scpi_event_oper_waiting_triger(54, "", "", ""),
        scpi_event_oper_waiting_arm(55, "", "", ""),
        scpi_event_oper_correcting(56, "", "", ""),
        scpi_event_oper_reserve1(57, "", "", ""),
        scpi_event_oper_cdyno_summary(58, "", "", ""),
        scpi_event_oper_reserve2(59, "", "", ""),
        scpi_event_oper_reserve3(60, "", "", ""),
        scpi_event_oper_reserve4(61, "", "", ""),
        scpi_event_oper_instrument(62, "", "", ""),
        scpi_event_oper_program_running(63, "", "", ""),
        scpi_event_oper_notused(64, "", "", ""),
        scpi_event_error_queue(65, "", "", ""),
        scpi_event_output_queue(66, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        scpiEvent(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static scpiEvent getscpiEventFromValue1(int i) {
        scpiEvent[] values;
        for (scpiEvent scpievent : scpiEvent.values()) {
            if (i == scpievent.value1) {
                return scpievent;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum OptType {
        OPT_BND(0, "", "", ""),
        OPT_MSO(1, "", "", ""),
        OPT_COMP(2, "", "", ""),
        OPT_EMBD(3, "", "", ""),
        OPT_AUTO(4, "", "", ""),
        OPT_FLEX(5, "", "", ""),
        OPT_AUDIO(6, "", "", ""),
        OPT_AERO(7, "", "", ""),
        OPT_ARINC(8, "", "", ""),
        OPT_DG(9, "", "", ""),
        OPT_JITTER(10, "", "", ""),
        OPT_EYE(11, "", "", ""),
        OPT_RTSA(12, "", "", ""),
        OPT_CM_USB(13, "", "", ""),
        OPT_CM_ENET(14, "", "", ""),
        OPT_CM_MIPI(15, "", "", ""),
        OPT_CM_HDMI(16, "", "", ""),
        OPT_PWR(17, "", "", ""),
        OPT_UPA(18, "", "", ""),
        OPT_RLU(19, "", "", ""),
        OPT_BODE(20, "", "", ""),
        OPT_BW7T10(21, "", "", ""),
        OPT_BW7T15(22, "", "", ""),
        OPT_BW7T20(23, "", "", ""),
        OPT_BW10T20(24, "", "", ""),
        OPT_BW15T25(25, "", "", ""),
        OPT_BW2T4(26, "", "", ""),
        OPT_BW2T8(27, "", "", ""),
        OPT_BW4T8(28, "", "", ""),
        OPT_COUNT(29, "", "", ""),
        OPT_UNKNOWN(30, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        OptType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static OptType getOptTypeFromValue1(int i) {
        OptType[] values;
        for (OptType optType : OptType.values()) {
            if (i == optType.value1) {
                return optType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum enumSampleAttr {
        e_sample_norm(1, "", "", ""),
        e_sample_peak(2, "", "", ""),
        e_sample_head(4, "", "", ""),
        e_sample_tail(8, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        enumSampleAttr(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static enumSampleAttr getenumSampleAttrFromValue1(int i) {
        enumSampleAttr[] values;
        for (enumSampleAttr enumsampleattr : enumSampleAttr.values()) {
            if (i == enumsampleattr.value1) {
                return enumsampleattr;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum LaNumType {
        LA_BIN_Val(0, "", "", ""),
        LA_HEX_Val(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        LaNumType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static LaNumType getLaNumTypeFromValue1(int i) {
        LaNumType[] values;
        for (LaNumType laNumType : LaNumType.values()) {
            if (i == laNumType.value1) {
                return laNumType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TriggerLevelMode {
        Trigger_level_abs(0, "", "", ""),
        Trigger_level_ref(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TriggerLevelMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TriggerLevelMode getTriggerLevelModeFromValue1(int i) {
        TriggerLevelMode[] values;
        for (TriggerLevelMode triggerLevelMode : TriggerLevelMode.values()) {
            if (i == triggerLevelMode.value1) {
                return triggerLevelMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum UtilityQuickOperationType {
        QUICK_SaveImage(0, "Save Image", "", ""),
        QUICK_SaveWave(1, "Save Wave", "", ""),
        QUICK_SaveSetup(2, "Save Setup", "", ""),
        QUICK_LoadSetup(3, "Load Setup", "", ""),
        QUICK_LoadWave(4, "Load Wave", "", ""),
        QUICK_FreezeWave(5, "Freeze Wave", "", ""),
        QUICK_AllMeasure(6, "All Measure", "", ""),
        QUICK_StatReset(7, "Stat Reset", "", ""),
        QUICK_Print(8, "Print", "", ""),
        QUICK_Email(9, "Email", "", ""),
        QUICK_LoadMask(10, "Load Mask", "", ""),
        QUICK_LoadArb(11, "Load Arb", "", ""),
        QUICK_Record(12, "Record", "", ""),
        QUICK_SelectSave(13, "Save Group", "", ""),
        QUICK_Resume(14, "Resume", "", "");
        
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
    public enum UtilityQuickSaveImage {
        IMG_PNG(0, "", "", ""),
        IMG_BMP(1, "", "", ""),
        IMG_JPG(2, "", "", ""),
        IMG_TIF(3, "", "", "");
        
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
    public enum UtilityQuickFormat {
        File_Format_BIN(0, "", "", ""),
        File_Format_CSV(1, "", "", ""),
        File_Format_WFM(2, "", "", "");
        
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
    public enum UtilityScreenSaver {
        SCR_OFF(0, "", "", ""),
        SCR_PICTURE(1, "", "", ""),
        SCR_TEXT(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        UtilityScreenSaver(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static UtilityScreenSaver getUtilityScreenSaverFromValue1(int i) {
        UtilityScreenSaver[] values;
        for (UtilityScreenSaver utilityScreenSaver : UtilityScreenSaver.values()) {
            if (i == utilityScreenSaver.value1) {
                return utilityScreenSaver;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum UtilityType {
        Utility_IO(0, "", "", ""),
        Utility_Setup(1, "", "", ""),
        Utility_About(2, "", "", ""),
        Utility_Other(3, "", "", ""),
        Utility_Auto_Config(4, "", "", ""),
        Utility_SelfCal(5, "", "", ""),
        Utility_Option(6, "", "", ""),
        Utility_Quick_Settings(7, "", "", ""),
        Utility_Screen_Saver(8, "", "", ""),
        Utility_Self_Check(9, "", "", ""),
        Utility_Email(10, "", "", ""),
        Utility_Printer(11, "", "", ""),
        Utility_Debug(12, "", "", ""),
        Utility_PMU(13, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        UtilityType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static UtilityType getUtilityTypeFromValue1(int i) {
        UtilityType[] values;
        for (UtilityType utilityType : UtilityType.values()) {
            if (i == utilityType.value1) {
                return utilityType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DacChan {
        DAC_HZ_CH1(0, "", "", ""),
        DAC_LZ_CH1(1, "", "", ""),
        DAC_HZ_CH2(2, "", "", ""),
        DAC_LZ_CH2(3, "", "", ""),
        DAC_HZ_CH3(4, "", "", ""),
        DAC_LZ_CH3(5, "", "", ""),
        DAC_HZ_CH4(6, "", "", ""),
        DAC_LZ_CH4(7, "", "", ""),
        DAC_TDR_VR(8, "", "", ""),
        DAC_EXT_LEVEL(9, "", "", ""),
        DAC_AWG_EXTA_LV(10, "", "", ""),
        DAC_AWG_EXTB_LV(11, "", "", ""),
        DAC_PROBE_OFFSET1(12, "", "", ""),
        DAC_PROBE_OFFSET2(13, "", "", ""),
        DAC_PROBE_OFFSET3(14, "", "", ""),
        DAC_PROBE_OFFSET4(15, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DacChan(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DacChan getDacChanFromValue1(int i) {
        DacChan[] values;
        for (DacChan dacChan : DacChan.values()) {
            if (i == dacChan.value1) {
                return dacChan;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MuxChannel {
        CH1_AFE(0, "", "", ""),
        CH2_AFE(1, "", "", ""),
        CH3_AFE(2, "", "", ""),
        CH4_AFE(3, "", "", ""),
        CH1_ADC(8, "", "", ""),
        CH2_ADC(9, "", "", ""),
        CH3_ADC(10, "", "", ""),
        CH4_ADC(11, "", "", ""),
        PLL_ADC(12, "", "", ""),
        PLL_CAL(13, "", "", ""),
        DAC_AFE(15, "", "", ""),
        DAC_EXT(17, "", "", ""),
        ZBD(18, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MuxChannel(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MuxChannel getMuxChannelFromValue1(int i) {
        MuxChannel[] values;
        for (MuxChannel muxChannel : MuxChannel.values()) {
            if (i == muxChannel.value1) {
                return muxChannel;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum PanelLed {
        CH1_YELLOW(0, "", "", ""),
        CH2_BLUE(1, "", "", ""),
        CH3_PINK(2, "", "", ""),
        CH4_DBLU2(3, "", "", ""),
        RUN_GREEN(4, "", "", ""),
        STOP_RED(5, "", "", ""),
        SINGLE_RED(6, "", "", ""),
        SINGLE_ORANG(7, "", "", ""),
        LA_LED_WHITE(8, "", "", ""),
        G1_LED_WHITE(9, "", "", ""),
        G2_LED_WHITE(10, "", "", ""),
        TOUCH_LED_WHITE(11, "", "", ""),
        A_UP_AND_DOWN_LED_WHITE(12, "", "", ""),
        B_LEFT_AND_RIGHT_LED_WHITE(13, "", "", ""),
        SLOP1_LED_WHITE(14, "", "", ""),
        SLOP2_LED_WHITE(15, "", "", ""),
        A_LEFT_AND_RIGHT_LED_WHITE(16, "", "", ""),
        B_UP_AND_DOWN_LED_WHITE(17, "", "", ""),
        INTEN_LED_WHITE(18, "", "", ""),
        ALL_LEDS(19, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        PanelLed(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static PanelLed getPanelLedFromValue1(int i) {
        PanelLed[] values;
        for (PanelLed panelLed : PanelLed.values()) {
            if (i == panelLed.value1) {
                return panelLed;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SysMessage {
        CMD_SERVICE_ACTIVE(65536, "", "", ""),
        CMD_SERVICE_DEACTIVE(65537, "", "", ""),
        CMD_SERVICE_ENTER_ACTIVE(65538, "", "", ""),
        CMD_SERVICE_EXIT_ACTIVE(65539, "", "", ""),
        CMD_SERVICE_RE_ENTER_ACTIVE(InputDeviceCompat.SOURCE_TRACKBALL, "", "", ""),
        CMD_SERVICE_VERT_ACTIVE(65541, "", "", ""),
        CMD_SERVICE_SUB_ENTER(65542, "", "", ""),
        CMD_SERVICE_SUB_RETURN(65543, "", "", ""),
        CMD_SERVICE_ITEM_FOCUS(65544, "", "", ""),
        CMD_SERVICE_ITEM_FOCUS_AGAIN(65545, "", "", ""),
        CMD_SERVICE_VIEW_CHANGE(65546, "", "", ""),
        CMD_SERVICE_INTENT(65547, "", "", ""),
        CMD_SERVICE_PROGRESS_CANCEL(65548, "", "", ""),
        CMD_SERVICE_INIT(65549, "", "", ""),
        CMD_SERVICE_RST(65550, "", "", ""),
        CMD_SERVICE_CONFIG(65551, "", "", ""),
        CMD_SERVICE_SERIALIN(65552, "", "", ""),
        CMD_SERVICE_SERIALOUT(65553, "", "", ""),
        CMD_SERVICE_START(65554, "", "", ""),
        CMD_SERVICE_LOAD(65555, "", "", ""),
        CMD_SERVICE_MODIFIED(65556, "", "", ""),
        CMD_SERVICE_SETTING_LOAD(65557, "", "", ""),
        CMD_SERVICE_SETUP_FLUSH(65558, "", "", ""),
        CMD_SERVICE_TIMEOUT(65559, "", "", ""),
        CMD_SERVICE_DO_ERR(65560, "", "", ""),
        CMD_SERVICE_HELP_REQUESST(65561, "", "", ""),
        CMD_SERVICE_LED_REQUESET(65562, "", "", ""),
        CMD_SERVICE_PRE_DO(65563, "", "", ""),
        CMD_SERVICE_POST_DO(65564, "", "", ""),
        CMD_SERVICE_ATTR_CHANGED(65565, "", "", ""),
        CMD_SERVICE_SOFT_INT(65566, "", "", ""),
        CMD_SERVICE_PHY_KEY(65567, "", "", ""),
        CMD_SERVICE_SERVICE_UP(65568, "", "", ""),
        CMD_SERVICE_CMD_EXIST(65569, "", "", ""),
        CMD_SERVICE_TICK(65570, "", "", ""),
        CMD_SERVICE_PAGE_SHOW(65571, "", "", ""),
        CMD_SERVICE_PAGE_HIDE(65572, "", "", ""),
        CMD_ENGINE_TICK(65573, "", "", ""),
        CMD_SERVICE_LOAD_PRIVACY(65574, "", "", ""),
        CMD_SERVICE_LICENSE_CHANGE(65575, "", "", ""),
        CMD_SERVICE_TEST(65576, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SysMessage(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SysMessage getSysMessageFromValue1(int i) {
        SysMessage[] values;
        for (SysMessage sysMessage : SysMessage.values()) {
            if (i == sysMessage.value1) {
                return sysMessage;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum WindowType {
        WIN_NONE(0, "", "", ""),
        WIN_MAIN_WAVEFORM(1, "", "ic_wave", "diag_wave"),
        WIN_ZOOM_WAVEFORM(2, "", "", ""),
        WIN_XY(3, "", "ic_xy", "diag_xy"),
        WIN_REF(4, "", "ic_nwidth", "diag_nwidth"),
        WIN_MATH(5, "", "ic_math", "diag_math"),
        WIN_MATH_PEAKSEARCH(6, "", "", ""),
        WIN_FFT(7, "", "ic_fft", "diag_fft"),
        WIN_EYE(8, "", "ic_eye", "diag_eye"),
        WIN_MEASURE(9, "", "ic_measure", "diag_measure"),
        WIN_ALL_MEASURE(10, "", "ic_all_measure", "diag_measure"),
        WIN_SEARCH(11, "", "ic_search", "diag_search"),
        WIN_DECODE(12, "", "ic_decode", "diag_decode"),
        WIN_HISTOGRAM(13, "", "ic_tvmin", "diag_tvmin"),
        WIN_UPA(14, "", "ic_upa", "diag_upda"),
        WIN_JITTER_TRACK(15, "", "", ""),
        WIN_JITTER_SPECTRUM(16, "", "", ""),
        WIN_JITTER_HISTOGRAM(17, "", "", ""),
        WIN_JITTER_BATHTUB_CURVE(18, "", "", ""),
        WIN_USB_ANALYSE_EYE(19, "", "", ""),
        WIN_USB_ANALYSE_PLOT(20, "", "", ""),
        WIN_USB_ANALYSE_RESULT(21, "", "", ""),
        WIN_LAN_ANALYSE_RESULT(22, "", "", ""),
        WIN_BASET100_ANALYSE_EYE(23, "", "", ""),
        WIN_BASET100_ANALYSE_JITTER(24, "", "", ""),
        WIN_BASET100_ANALYSE_RESULT(25, "", "", ""),
        WIN_RTSA_PEAKSEARCH(26, "", "", ""),
        WIN_BODE(27, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        WindowType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static WindowType getWindowTypeFromValue1(int i) {
        WindowType[] values;
        for (WindowType windowType : WindowType.values()) {
            if (i == windowType.value1) {
                return windowType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalAfeRegType {
        DC_TRIM(0, "", "", ""),
        LF_TRIM(1, "", "", ""),
        HIZ_CC_TRIM4_VGA(2, "", "", ""),
        HIZ_SGA2_CC_VGA(3, "", "", ""),
        K_INV(4, "", "", ""),
        CC_TRIM1_HF_INV(5, "", "", ""),
        MC_C_TRIM(6, "", "", ""),
        MHF_HTRIM(7, "", "", ""),
        MHF_LTRIM(8, "", "", ""),
        PK_TRIM(9, "", "", ""),
        D_COARSE_NINV(10, "", "", ""),
        D_FINE_NINV(11, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalAfeRegType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalAfeRegType getCalAfeRegTypeFromValue1(int i) {
        CalAfeRegType[] values;
        for (CalAfeRegType calAfeRegType : CalAfeRegType.values()) {
            if (i == calAfeRegType.value1) {
                return calAfeRegType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalItem {
        cal_item_all(0, "", "", ""),
        cal_data_line(1, "", "", ""),
        cal_adc_gain(2, "", "", ""),
        cal_adc_phase(3, "", "", ""),
        cal_vert_1M(4, "", "", ""),
        cal_vert_ch1(5, "", "", ""),
        cal_vert_ch2(6, "", "", ""),
        cal_vert_ch3(7, "", "", ""),
        cal_vert_ch4(8, "", "", ""),
        cal_ext(9, "", "", ""),
        cal_afe_zero(10, "", "", ""),
        cal_ddr(11, "", "", ""),
        cal_la(12, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalItem(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalItem getCalItemFromValue1(int i) {
        CalItem[] values;
        for (CalItem calItem : CalItem.values()) {
            if (i == calItem.value1) {
                return calItem;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalPath {
        cal_path_50_x2(0, "", "", ""),
        cal_path_50_x20(1, "", "", ""),
        cal_path_1m_x1(2, "", "", ""),
        cal_path_1m_x7(3, "", "", ""),
        cal_path_50_x2_sga1(4, "", "", ""),
        cal_path_50_x20_sga1(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalPath(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalPath getCalPathFromValue1(int i) {
        CalPath[] values;
        for (CalPath calPath : CalPath.values()) {
            if (i == calPath.value1) {
                return calPath;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum LfTrim {
        dc_trim(0, "", "", ""),
        lf_trim(1, "", "", ""),
        mf_c_trim(2, "", "", ""),
        hf_trim(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        LfTrim(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static LfTrim getLfTrimFromValue1(int i) {
        LfTrim[] values;
        for (LfTrim lfTrim : LfTrim.values()) {
            if (i == lfTrim.value1) {
                return lfTrim;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalBwIndex {
        BW_CCTRIM(0, "", "", ""),
        BW_CC2TRIM(1, "", "", ""),
        BW_BWTRIM(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalBwIndex(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalBwIndex getCalBwIndexFromValue1(int i) {
        CalBwIndex[] values;
        for (CalBwIndex calBwIndex : CalBwIndex.values()) {
            if (i == calBwIndex.value1) {
                return calBwIndex;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalFile {
        cal_file_adc(0, "", "", ""),
        cal_file_lsb(1, "", "", ""),
        cal_file_afe_zero(2, "", "", ""),
        cal_file_afe_bandwidth(3, "", "", ""),
        cal_file_vertical(4, "", "", ""),
        cal_file_ext(5, "", "", ""),
        cal_file_ddr(6, "", "", ""),
        cal_file_afg(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalFile(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalFile getCalFileFromValue1(int i) {
        CalFile[] values;
        for (CalFile calFile : CalFile.values()) {
            if (i == calFile.value1) {
                return calFile;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Function {
        FUN_MEASURE(1, "Measure", "ic_measure", ""),
        FUN_HISTOGRAM(2, "Histogram", "ic_histogram", ""),
        FUN_CURSOR(3, "Cursor", "ic_cursor", ""),
        FUN_RESULT_TABLE(4, "Result Table", "ic_result_table", ""),
        FUN_MULTI_WINDOW(5, "MultiWindow", "ic_multi_window", ""),
        FUN_MATH(6, "Math", "ic_math", ""),
        FUN_REF(7, "Ref", "ic_ref", ""),
        FUN_FFT(8, "FFT", "ic_fft", ""),
        FUN_COUNTER(9, "Counter", "ic_counter", ""),
        FUN_DVM(10, "DVM", "ic_dvm", ""),
        FUN_EYE(11, "Eye", "ic_eye", ""),
        FUN_JITTER(12, "Jitter", "ic_jitter", ""),
        FUN_DECODE(13, "Decode", "ic_decode", ""),
        FUN_BODE(49, "bode", "icon_bode", ""),
        FUN_UPA(14, "UPA", "ic_upa", ""),
        FUN_BUS_ANALYSE(15, "BusAnalyse", "ic_bus_analyse", ""),
        FUN_MASK(16, "Mask", "ic_mask", ""),
        FUN_SEARCH(17, "Search", "ic_search", ""),
        FUN_ZONE_TRIGGER(18, "ZoneTrigger", "ic_zone_trigger", ""),
        FUN_RECORD(19, "Record", "ic_record", ""),
        FUN_AUTO(20, "Auto", "ic_auto", ""),
        FUN_DISPLAY(21, "Display", "ic_display", ""),
        FUN_NOTE(22, "Note", "ic_note", ""),
        FUN_QUICK(23, "Quick", "ic_quick", ""),
        FUN_SHARE(24, "Share", "ic_share", ""),
        FUN_STORAGE(25, AgentWebPermissions.ACTION_STORAGE, "ic_storage", ""),
        FUN_HELP(26, "Help", "ic_help", ""),
        FUN_UPDATE(27, "Update", "ic_update", ""),
        FUN_UTILITY(28, "Utility", "ic_utility", ""),
        FUN_BACK(29, "Back", "ic_back", ""),
        FUN_RESTART(30, "Restart", "ic_restart", ""),
        FUN_SHUTDOWN(31, "ShutDown", "ic_shutdown", ""),
        FUN_RUN_STOP(32, "RunStop", "ic_run_stop", ""),
        FUN_SINGLE(33, "Single", "ic_single", ""),
        FUN_FORCE(34, "Force", "ic_force", ""),
        FUN_TRIGGER(35, "Trigger", "ic_trigger", ""),
        FUN_ACQUIRE(36, "Acquire", "ic_acquire", ""),
        FUN_DEFAULT(37, "Default", "ic_default", ""),
        FUN_HORIZONTAL(38, "Horizontal", "ic_horizontal", ""),
        FUN_VERTICAL(39, "Vertical", "ic_vertical", ""),
        FUN_CLEAR(40, "Clear", "ic_clean2", ""),
        FUN_WAVE_INTENSITY(41, "Intensity", "ic_wave_intensity", ""),
        FUN_NEXT_PAGE(42, "Next", "ic_next_page", ""),
        FUN_PREVIOUS_PAGE(43, "Previous", "ic_previous_page", ""),
        FUN_ZOOM(44, "Zoom", "ic_zoom", ""),
        FUN_XY(45, "XY", "ic_xy", ""),
        FUN_FLEX_KNOB(46, "Flex Knob", "ic_flex_knob_intensity", ""),
        FUN_NAVIGATE(47, "Navigate", "ic_navigate", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Function(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Function getFunctionFromValue1(int i) {
        Function[] values;
        for (Function function : Function.values()) {
            if (i == function.value1) {
                return function;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DecodeBusType {
        Decode_Parallel(0, "Parallel", "", ""),
        Decode_RS232(1, "RS232", "", ""),
        Decode_I2C(2, "I2C", "", ""),
        Decode_SPI(3, "SPI", "", ""),
        Decode_LIN(4, "LIN", "", ""),
        Decode_CAN(5, "CAN", "", ""),
        Decode_FlexRay(6, "FlexRay", "", ""),
        Decode_I2S(7, "I2S", "", ""),
        Decode_1553B(8, "1553B", "", ""),
        Decode_ARINC429(9, "ARINC429", "", ""),
        Decode_SENT(10, "SENT", "", ""),
        Decode_MOST(11, "MOST", "", ""),
        Decode_USB(12, "USB", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DecodeBusType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DecodeBusType getDecodeBusTypeFromValue1(int i) {
        DecodeBusType[] values;
        for (DecodeBusType decodeBusType : DecodeBusType.values()) {
            if (i == decodeBusType.value1) {
                return decodeBusType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EyeTemplate {
        eth100(0, "", "", ""),
        usbLow(1, "", "", ""),
        usbFull(2, "", "", ""),
        usbHighFar(3, "", "", ""),
        usbHighNear(4, "", "", ""),
        hdmi(5, "", "", ""),
        customize(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EyeTemplate(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EyeTemplate getEyeTemplateFromValue1(int i) {
        EyeTemplate[] values;
        for (EyeTemplate eyeTemplate : EyeTemplate.values()) {
            if (i == eyeTemplate.value1) {
                return eyeTemplate;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum WaveMode {
        wfm_normal(0, "", "", ""),
        wfm_maximum(1, "", "", ""),
        wfm_raw(2, "", "", ""),
        wfm_trace(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        WaveMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static WaveMode getWaveModeFromValue1(int i) {
        WaveMode[] values;
        for (WaveMode waveMode : WaveMode.values()) {
            if (i == waveMode.value1) {
                return waveMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum WaveFormat {
        wfm_byte(0, "", "", ""),
        wfm_word(1, "", "", ""),
        wfm_ascii(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        WaveFormat(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static WaveFormat getWaveFormatFromValue1(int i) {
        WaveFormat[] values;
        for (WaveFormat waveFormat : WaveFormat.values()) {
            if (i == waveFormat.value1) {
                return waveFormat;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum fftWindow {
        fft_rectangle(0, "", "", ""),
        fft_blackman(1, "", "", ""),
        fft_hanning(2, "", "", ""),
        fft_hamming(3, "", "", ""),
        fft_flattop(4, "", "", ""),
        fft_triangle(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        fftWindow(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static fftWindow getfftWindowFromValue1(int i) {
        fftWindow[] values;
        for (fftWindow fftwindow : fftWindow.values()) {
            if (i == fftwindow.value1) {
                return fftwindow;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum fftSpecUnit {
        fft_spec_rms(0, "", "", ""),
        fft_spec_db(1, "", "", ""),
        fft_spec_dbm(2, "", "", ""),
        fft_spec_phase(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        fftSpecUnit(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static fftSpecUnit getfftSpecUnitFromValue1(int i) {
        fftSpecUnit[] values;
        for (fftSpecUnit fftspecunit : fftSpecUnit.values()) {
            if (i == fftspecunit.value1) {
                return fftspecunit;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum enPeakOrder {
        fft_peak_AmpOrder(0, "", "", ""),
        fft_peak_FreqOrder(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        enPeakOrder(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static enPeakOrder getenPeakOrderFromValue1(int i) {
        enPeakOrder[] values;
        for (enPeakOrder enpeakorder : enPeakOrder.values()) {
            if (i == enpeakorder.value1) {
                return enpeakorder;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum jitterResult {
        jitter_Tj(0, "", "", ""),
        jitter_Rj(1, "", "", ""),
        jitter_Dj(2, "", "", ""),
        jitter_Pj(3, "", "", ""),
        jitter_Ddj(4, "", "", ""),
        jitter_DCD(5, "", "", ""),
        jitter_ISI(6, "", "", ""),
        jitter_BitRate(7, "", "", ""),
        jitter_Tie_pkpk(8, "", "", ""),
        jitter_Tie_stdev(9, "", "", ""),
        Jitter_Meas_Count(10, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        jitterResult(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static jitterResult getjitterResultFromValue1(int i) {
        jitterResult[] values;
        for (jitterResult jitterresult : jitterResult.values()) {
            if (i == jitterresult.value1) {
                return jitterresult;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum HighResBit {
        HIGH_RES_8(0, "", "", ""),
        HIGH_RES_9(1, "", "", ""),
        HIGH_RES_10(2, "", "", ""),
        HIGH_RES_11(3, "", "", ""),
        HIGH_RES_12(4, "", "", ""),
        HIGH_RES_13(5, "", "", ""),
        HIGH_RES_14(6, "", "", ""),
        HIGH_RES_15(7, "", "", ""),
        HIGH_RES_16(8, "", "", ""),
        HIGH_RES16_14(9, "", "", ""),
        HIGH_RES16_16(10, "", "", ""),
        HIGH_RES_NONE(11, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        HighResBit(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static HighResBit getHighResBitFromValue1(int i) {
        HighResBit[] values;
        for (HighResBit highResBit : HighResBit.values()) {
            if (i == highResBit.value1) {
                return highResBit;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BDHighResBit {
        HIGH_RES_01WC(0, "", "", ""),
        HIGH_RES_02WC(1, "", "", ""),
        HIGH_RES_03WC(2, "", "", ""),
        HIGH_RES_04WC(3, "", "", ""),
        HIGH_RES_005WC(4, "", "", ""),
        HIGH_RES_06WC(5, "", "", ""),
        HIGH_RES_007WC(6, "", "", ""),
        HIGH_RES_08WC(7, "", "", ""),
        HIGH_RES_014WC(8, "", "", ""),
        HIGH_RES_028WC(9, "", "", ""),
        HIGH_RES_0035WC(10, "", "", ""),
        HIGH_RES_056WC(11, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BDHighResBit(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BDHighResBit getBDHighResBitFromValue1(int i) {
        BDHighResBit[] values;
        for (BDHighResBit bDHighResBit : BDHighResBit.values()) {
            if (i == bDHighResBit.value1) {
                return bDHighResBit;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum StorageOperation {
        SAVE(0, "", "", ""),
        LOAD(1, "", "", ""),
        UPGRADE(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        StorageOperation(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static StorageOperation getStorageOperationFromValue1(int i) {
        StorageOperation[] values;
        for (StorageOperation storageOperation : StorageOperation.values()) {
            if (i == storageOperation.value1) {
                return storageOperation;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum StorageOperationChoose {
        IMAGE(0, "", "", ""),
        WAVE(1, "", "", ""),
        SETUP(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        StorageOperationChoose(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static StorageOperationChoose getStorageOperationChooseFromValue1(int i) {
        StorageOperationChoose[] values;
        for (StorageOperationChoose storageOperationChoose : StorageOperationChoose.values()) {
            if (i == storageOperationChoose.value1) {
                return storageOperationChoose;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MeasureQuickItemType {
        INDICATOR(0, "", "", ""),
        RESET(1, "", "", ""),
        REMOVE(2, "", "", ""),
        SETTING(3, "", "", ""),
        REMOVE_ALL(4, "", "", ""),
        CHANGE_ITEM(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MeasureQuickItemType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MeasureQuickItemType getMeasureQuickItemTypeFromValue1(int i) {
        MeasureQuickItemType[] values;
        for (MeasureQuickItemType measureQuickItemType : MeasureQuickItemType.values()) {
            if (i == measureQuickItemType.value1) {
                return measureQuickItemType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RefColor {
        REF_COLOR_GRAY(0, "", "", ""),
        REF_COLOR_GREEN(1, "", "", ""),
        REF_COLOR_BLUE(2, "", "", ""),
        REF_COLOR_RED(3, "", "", ""),
        REF_COLOR_ORANGE(4, "", "", ""),
        REF_COLOR_ALL(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RefColor(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RefColor getRefColorFromValue1(int i) {
        RefColor[] values;
        for (RefColor refColor : RefColor.values()) {
            if (i == refColor.value1) {
                return refColor;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum StorageFunc {
        FUNC_SAVE_IMG(0, "", "", ""),
        FUNC_SAVE_WAV(1, "", "", ""),
        FUNC_SAVE_STP(2, "", "", ""),
        FUNC_SAVE_REF(3, "", "", ""),
        FUNC_SAVE_MSK(4, "", "", ""),
        FUNC_SAVE_ARB(5, "", "", ""),
        FUNC_SAVE_REC(6, "", "", ""),
        FUNC_SAVE_DEC(7, "", "", ""),
        FUNC_SAVE_DG(8, "", "", ""),
        FUNC_SAVE_DECDAT(9, "", "", ""),
        FUNC_SAVE_SEARCH(10, "", "", ""),
        FUNC_SAVE_FFT(11, "", "", ""),
        FUNC_LOAD_WAV(12, "", "", ""),
        FUNC_LOAD_STP(13, "", "", ""),
        FUNC_LOAD_REF(14, "", "", ""),
        FUNC_LOAD_MSK(15, "", "", ""),
        FUNC_LOAD_ARB(16, "", "", ""),
        FUNC_LOAD_GEL(17, "", "", ""),
        FUNC_LOAD_ATT(18, "", "", ""),
        FUNC_LOAD_SCR(19, "", "", ""),
        FUNC_SAVE_DDR(20, "", "", ""),
        FUNC_LOAD_DDR(21, "", "", ""),
        FUNC_SECURITYCLEAR(22, "", "", ""),
        FUNC_SAVE_HTML(23, "", "", ""),
        FUNC_SAVE_BODE(24, "", "", ""),
        FUNC_LOAD_BODE(25, "", "", ""),
        FUNC_LOAD_AFG(26, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        StorageFunc(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static StorageFunc getStorageFuncFromValue1(int i) {
        StorageFunc[] values;
        for (StorageFunc storageFunc : StorageFunc.values()) {
            if (i == storageFunc.value1) {
                return storageFunc;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AutoSetItemType {
        AUTO_CYCLE(0, "", "", ""),
        AUTO_NCYCLE(1, "", "", ""),
        AUTO_RISE(2, "", "", ""),
        AUTO_FALL(3, "", "", ""),
        AUTO_BACK(4, "", "", ""),
        AUTO_MENU(5, "", "", ""),
        AUTO_UNDO(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AutoSetItemType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AutoSetItemType getAutoSetItemTypeFromValue1(int i) {
        AutoSetItemType[] values;
        for (AutoSetItemType autoSetItemType : AutoSetItemType.values()) {
            if (i == autoSetItemType.value1) {
                return autoSetItemType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DebugType {
        GPU_PLOT(0, "", "", ""),
        ADC_CLOCK(1, "", "", ""),
        DDR_IO(2, "", "", ""),
        ADC_SER(3, "", "", ""),
        LogCat(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DebugType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DebugType getDebugTypeFromValue1(int i) {
        DebugType[] values;
        for (DebugType debugType : DebugType.values()) {
            if (i == debugType.value1) {
                return debugType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FPGADlySrc {
        FPGA_LA0(0, "", "", ""),
        FPGA_LA1(1, "", "", ""),
        FPGA_LA2(2, "", "", ""),
        FPGA_LA3(3, "", "", ""),
        FPGA_LA4(4, "", "", ""),
        FPGA_LA5(5, "", "", ""),
        FPGA_LA6(6, "", "", ""),
        FPGA_LA7(7, "", "", ""),
        FPGA_LA8(8, "", "", ""),
        FPGA_LA9(9, "", "", ""),
        FPGA_LA10(10, "", "", ""),
        FPGA_LA11(11, "", "", ""),
        FPGA_LA12(12, "", "", ""),
        FPGA_LA13(13, "", "", ""),
        FPGA_LA14(14, "", "", ""),
        FPGA_LA15(15, "", "", ""),
        FPGA_Cha(16, "", "", ""),
        FPGA_Chb(17, "", "", ""),
        FPGA_Chc(18, "", "", ""),
        FPGA_Chd(19, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FPGADlySrc(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FPGADlySrc getFPGADlySrcFromValue1(int i) {
        FPGADlySrc[] values;
        for (FPGADlySrc fPGADlySrc : FPGADlySrc.values()) {
            if (i == fPGADlySrc.value1) {
                return fPGADlySrc;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FPGADlyEdgeType {
        FPGA_Dly_fall(0, "", "", ""),
        FPGA_Dly_Rise(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FPGADlyEdgeType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FPGADlyEdgeType getFPGADlyEdgeTypeFromValue1(int i) {
        FPGADlyEdgeType[] values;
        for (FPGADlyEdgeType fPGADlyEdgeType : FPGADlyEdgeType.values()) {
            if (i == fPGADlyEdgeType.value1) {
                return fPGADlyEdgeType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FPGACntEdgeType {
        FPGA_Cnt_Edge_Fall(0, "", "", ""),
        FPGA_Cnt_Edge_Rise(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FPGACntEdgeType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FPGACntEdgeType getFPGACntEdgeTypeFromValue1(int i) {
        FPGACntEdgeType[] values;
        for (FPGACntEdgeType fPGACntEdgeType : FPGACntEdgeType.values()) {
            if (i == fPGACntEdgeType.value1) {
                return fPGACntEdgeType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FPGACntPulseType {
        FPGA_Cnt_Pulse_N(0, "", "", ""),
        FPGA_Cnt_Pulse_P(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FPGACntPulseType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FPGACntPulseType getFPGACntPulseTypeFromValue1(int i) {
        FPGACntPulseType[] values;
        for (FPGACntPulseType fPGACntPulseType : FPGACntPulseType.values()) {
            if (i == fPGACntPulseType.value1) {
                return fPGACntPulseType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FPGAEnType {
        FPGA_CH_LA_DIS(0, "", "", ""),
        FPGA_ZOOM_EN(1, "", "", ""),
        FPGA_CH_MAIN_EN(2, "", "", ""),
        FPGA_LA_MAIN_EN(3, "", "", ""),
        FPGA_CH_LA_MAIN_EN(4, "", "", ""),
        FPGA_CH_ZOOM_EN(5, "", "", ""),
        FPGA_LA_ZOOM_EN(6, "", "", ""),
        FPGA_CH_LA_ZOOM_EN(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FPGAEnType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FPGAEnType getFPGAEnTypeFromValue1(int i) {
        FPGAEnType[] values;
        for (FPGAEnType fPGAEnType : FPGAEnType.values()) {
            if (i == fPGAEnType.value1) {
                return fPGAEnType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FPGATopBaseMethod {
        FPGA_TopBase_Auto(0, "", "", ""),
        FPGA_TopBase_Hist(1, "", "", ""),
        FPGA_TopBase_MaxMin(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FPGATopBaseMethod(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FPGATopBaseMethod getFPGATopBaseMethodFromValue1(int i) {
        FPGATopBaseMethod[] values;
        for (FPGATopBaseMethod fPGATopBaseMethod : FPGATopBaseMethod.values()) {
            if (i == fPGATopBaseMethod.value1) {
                return fPGATopBaseMethod;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EposType {
        EPOS_SA(0, "", "", ""),
        EPOS_SB(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EposType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EposType getEposTypeFromValue1(int i) {
        EposType[] values;
        for (EposType eposType : EposType.values()) {
            if (i == eposType.value1) {
                return eposType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum HardMeasIndex {
        Dly_none(0, "", "", ""),
        Dly1(1, "", "", ""),
        Dly2(2, "", "", ""),
        Dly3(3, "", "", ""),
        Dly4(4, "", "", ""),
        Dly5(5, "", "", ""),
        Dly6(6, "", "", ""),
        Dly7(7, "", "", ""),
        Dly8(8, "", "", ""),
        Dly9(9, "", "", ""),
        Dly10(10, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        HardMeasIndex(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static HardMeasIndex getHardMeasIndexFromValue1(int i) {
        HardMeasIndex[] values;
        for (HardMeasIndex hardMeasIndex : HardMeasIndex.values()) {
            if (i == hardMeasIndex.value1) {
                return hardMeasIndex;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CAL_Chmode {
        mode_1ch(0, "", "", ""),
        mode_2ch(1, "", "", ""),
        reserve1(2, "", "", ""),
        mode_4ch(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CAL_Chmode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CAL_Chmode getCAL_ChmodeFromValue1(int i) {
        CAL_Chmode[] values;
        for (CAL_Chmode cAL_Chmode : CAL_Chmode.values()) {
            if (i == cAL_Chmode.value1) {
                return cAL_Chmode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CAL_ChState {
        Imp50_100mv(0, "", "", ""),
        Imp50_200mv(1, "", "", ""),
        Imp1M_200mv(2, "", "", ""),
        ext_trig(3, "", "", ""),
        Imp1M_100mv(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CAL_ChState(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CAL_ChState getCAL_ChStateFromValue1(int i) {
        CAL_ChState[] values;
        for (CAL_ChState cAL_ChState : CAL_ChState.values()) {
            if (i == cAL_ChState.value1) {
                return cAL_ChState;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CAL_ChID {
        cal_ch1_id(0, "", "", ""),
        cal_ch2_id(1, "", "", ""),
        cal_ch3_id(2, "", "", ""),
        cal_ch4_id(3, "", "", ""),
        cal_ch5_id(4, "", "", ""),
        cal_ch6_id(5, "", "", ""),
        cal_ch7_id(6, "", "", ""),
        cal_ch8_id(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CAL_ChID(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CAL_ChID getCAL_ChIDFromValue1(int i) {
        CAL_ChID[] values;
        for (CAL_ChID cAL_ChID : CAL_ChID.values()) {
            if (i == cAL_ChID.value1) {
                return cAL_ChID;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum HoriMode {
        ACQUIRE_20G(0, "", "", ""),
        ACQUIRE_10G(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        HoriMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static HoriMode getHoriModeFromValue1(int i) {
        HoriMode[] values;
        for (HoriMode horiMode : HoriMode.values()) {
            if (i == horiMode.value1) {
                return horiMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RecordState {
        Record_disable(0, "", "", ""),
        Record_empty(1, "", "", ""),
        Record_ing(2, "", "", ""),
        Record_end(3, "", "", ""),
        Play_ing(4, "", "", ""),
        Play_end(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RecordState(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RecordState getRecordStateFromValue1(int i) {
        RecordState[] values;
        for (RecordState recordState : RecordState.values()) {
            if (i == recordState.value1) {
                return recordState;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DecThreType {
        thre_pal(0, "", "", ""),
        thre_tx(1, "", "", ""),
        thre_rx(2, "", "", ""),
        thre_scl(3, "", "", ""),
        thre_sda(4, "", "", ""),
        thre_data(5, "", "", ""),
        thre_ws(6, "", "", ""),
        thre_i2s_clk(7, "", "", ""),
        thre_cs(8, "", "", ""),
        thre_clk(9, "", "", ""),
        thre_miso(10, "", "", ""),
        thre_mosi(11, "", "", ""),
        thre_lin(12, "", "", ""),
        thre_can(13, "", "", ""),
        thre_can_sub_1(14, "", "", ""),
        thre_1553(15, "", "", ""),
        thre_flex(16, "", "", ""),
        thre_ch1(17, "", "", ""),
        thre_ch2(18, "", "", ""),
        thre_ch3(19, "", "", ""),
        thre_ch4(20, "", "", ""),
        thre_arinc_up(21, "", "", ""),
        thre_arinc_down(22, "", "", ""),
        thre_sent(23, "", "", ""),
        thre_most(24, "", "", ""),
        thre_usb_dp(25, "", "", ""),
        thre_usb_ds(26, "", "", ""),
        thre_usb_diff_h(27, "", "", ""),
        thre_usb_diff_l(28, "", "", ""),
        thre_pal_clk(29, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DecThreType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DecThreType getDecThreTypeFromValue1(int i) {
        DecThreType[] values;
        for (DecThreType decThreType : DecThreType.values()) {
            if (i == decThreType.value1) {
                return decThreType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Edge {
        EDGE_RISING(0, "", "", ""),
        EDGE_FALLING(1, "", "", ""),
        EDGE_ALL(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Edge(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Edge getEdgeFromValue1(int i) {
        Edge[] values;
        for (Edge edge : Edge.values()) {
            if (i == edge.value1) {
                return edge;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BusUser {
        CHAN_NONE(0, "", "", ""),
        CHAN1(1, "", "", ""),
        CHAN2(2, "", "", ""),
        CHAN3(3, "", "", ""),
        CHAN4(4, "", "", ""),
        D7_D0(9, "", "", ""),
        D15_D8(10, "", "", ""),
        D15_D0(11, "", "", ""),
        D0_D7(12, "", "", ""),
        D8_D15(13, "", "", ""),
        D0_D15(14, "", "", ""),
        USER(33, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BusUser(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BusUser getBusUserFromValue1(int i) {
        BusUser[] values;
        for (BusUser busUser : BusUser.values()) {
            if (i == busUser.value1) {
                return busUser;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum UartDataWid {
        Uart_DataWid_0(0, "", "", ""),
        Uart_DataWid_1(1, "", "", ""),
        Uart_DataWid_2(2, "", "", ""),
        Uart_DataWid_3(3, "", "", ""),
        Uart_DataWid_4(4, "", "", ""),
        Uart_DataWid_5(5, "", "", ""),
        Uart_DataWid_6(6, "", "", ""),
        Uart_DataWid_7(7, "", "", ""),
        Uart_DataWid_8(8, "", "", ""),
        Uart_DataWid_9(9, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        UartDataWid(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static UartDataWid getUartDataWidFromValue1(int i) {
        UartDataWid[] values;
        for (UartDataWid uartDataWid : UartDataWid.values()) {
            if (i == uartDataWid.value1) {
                return uartDataWid;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DECODEPARITY {
        PARITY_NONE(0, "", "", ""),
        PARITY_ODD(1, "", "", ""),
        PARITY_EVEN(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DECODEPARITY(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DECODEPARITY getDECODEPARITYFromValue1(int i) {
        DECODEPARITY[] values;
        for (DECODEPARITY decodeparity : DECODEPARITY.values()) {
            if (i == decodeparity.value1) {
                return decodeparity;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum PACKAGEEND {
        PACKAGEEND_NUL(0, "", "", ""),
        PACKAGEEND_LF(10, "", "", ""),
        PACKAGEEND_CR(13, "", "", ""),
        PACKAGEEND_SP(32, "", "", ""),
        PACKAGEEND_FFH(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        PACKAGEEND(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static PACKAGEEND getPACKAGEENDFromValue1(int i) {
        PACKAGEEND[] values;
        for (PACKAGEEND packageend : PACKAGEEND.values()) {
            if (i == packageend.value1) {
                return packageend;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SIGTYPECAN {
        SIGTYPE_CAN_H(0, "", "", ""),
        SIGTYPE_CAN_L(1, "", "", ""),
        SIGTYPE_RX(2, "", "", ""),
        SIGTYPE_TX(3, "", "", ""),
        SIGTYPE_CSNZ_H_L(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SIGTYPECAN(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SIGTYPECAN getSIGTYPECANFromValue1(int i) {
        SIGTYPECAN[] values;
        for (SIGTYPECAN sigtypecan : SIGTYPECAN.values()) {
            if (i == sigtypecan.value1) {
                return sigtypecan;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SIGTYPE {
        FLEX_BP(0, "", "", ""),
        FLEX_BM(1, "", "", ""),
        FLEX_TX_RX(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SIGTYPE(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SIGTYPE getSIGTYPEFromValue1(int i) {
        SIGTYPE[] values;
        for (SIGTYPE sigtype : SIGTYPE.values()) {
            if (i == sigtype.value1) {
                return sigtype;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Polarity {
        Polarity_Negtive(0, "", "", ""),
        Polarity_Positive(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Polarity(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Polarity getPolarityFromValue1(int i) {
        Polarity[] values;
        for (Polarity polarity : Polarity.values()) {
            if (i == polarity.value1) {
                return polarity;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BW_FILTER_CONFIG_EN {
        BW_FILTER_CONFIG_A_EN(1, "", "", ""),
        BW_FILTER_CONFIG_B_EN(2, "", "", ""),
        BW_FILTER_CONFIG_AB_EN(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BW_FILTER_CONFIG_EN(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BW_FILTER_CONFIG_EN getBW_FILTER_CONFIG_ENFromValue1(int i) {
        BW_FILTER_CONFIG_EN[] values;
        for (BW_FILTER_CONFIG_EN bw_filter_config_en : BW_FILTER_CONFIG_EN.values()) {
            if (i == bw_filter_config_en.value1) {
                return bw_filter_config_en;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum MathWaveType {
        MathWave_Main(0, "", "", ""),
        MathWave_Zoom(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        MathWaveType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static MathWaveType getMathWaveTypeFromValue1(int i) {
        MathWaveType[] values;
        for (MathWaveType mathWaveType : MathWaveType.values()) {
            if (i == mathWaveType.value1) {
                return mathWaveType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Bus_Status {
        BUS_OFF(0, "", "", ""),
        BUS_ON(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Bus_Status(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Bus_Status getBus_StatusFromValue1(int i) {
        Bus_Status[] values;
        for (Bus_Status bus_Status : Bus_Status.values()) {
            if (i == bus_Status.value1) {
                return bus_Status;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RtsaModule {
        RTSA_Basic(0, "", "", ""),
        RTSA_Peak(1, "", "", ""),
        RTSA_Marker(2, "", "", ""),
        RTSA_Density(3, "", "", ""),
        RTSA_Trigger(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RtsaModule(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RtsaModule getRtsaModuleFromValue1(int i) {
        RtsaModule[] values;
        for (RtsaModule rtsaModule : RtsaModule.values()) {
            if (i == rtsaModule.value1) {
                return rtsaModule;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RtsaRBW {
        RtsaRBW_64k(0, "", "", ""),
        RtsaRBW_32k(1, "", "", ""),
        RtsaRBW_16k(2, "", "", ""),
        RtsaRBW_8k(3, "", "", ""),
        RtsaRBW_4k(4, "", "", ""),
        RtsaRBW_2k(5, "", "", ""),
        RtsaRBW_1k(6, "", "", ""),
        RtsaRBW_Auto(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RtsaRBW(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RtsaRBW getRtsaRBWFromValue1(int i) {
        RtsaRBW[] values;
        for (RtsaRBW rtsaRBW : RtsaRBW.values()) {
            if (i == rtsaRBW.value1) {
                return rtsaRBW;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EngineTimer {
        Timer_Player(0, "", "", ""),
        Timer_Config(1, "", "", ""),
        Timer_Once(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EngineTimer(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EngineTimer getEngineTimerFromValue1(int i) {
        EngineTimer[] values;
        for (EngineTimer engineTimer : EngineTimer.values()) {
            if (i == engineTimer.value1) {
                return engineTimer;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RtsaSa {
        RtsaSa_500M(0, "", "", ""),
        RtsaSa_1G(1, "", "", ""),
        RtsaSa_2G(2, "", "", ""),
        RtsaSa_5G(3, "", "", ""),
        RtsaSa_10G(4, "", "", ""),
        RtsaSa_Auto(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RtsaSa(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RtsaSa getRtsaSaFromValue1(int i) {
        RtsaSa[] values;
        for (RtsaSa rtsaSa : RtsaSa.values()) {
            if (i == rtsaSa.value1) {
                return rtsaSa;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RtsaMarker {
        Rtsa_Marker1(1, "", "", ""),
        Rtsa_Marker2(2, "", "", ""),
        Rtsa_Marker3(3, "", "", ""),
        Rtsa_Marker4(4, "", "", ""),
        Rtsa_Marker5(5, "", "", ""),
        Rtsa_Marker6(6, "", "", ""),
        Rtsa_Marker7(7, "", "", ""),
        Rtsa_Marker8(8, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RtsaMarker(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RtsaMarker getRtsaMarkerFromValue1(int i) {
        RtsaMarker[] values;
        for (RtsaMarker rtsaMarker : RtsaMarker.values()) {
            if (i == rtsaMarker.value1) {
                return rtsaMarker;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Can_Define {
        trig_can_define_data(0, "", "", ""),
        trig_can_define_id(1, "", "", ""),
        trig_can_define_false(2, "", "", ""),
        trig_can_define_true(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Can_Define(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Can_Define getTrigger_Can_DefineFromValue1(int i) {
        Trigger_Can_Define[] values;
        for (Trigger_Can_Define trigger_Can_Define : Trigger_Can_Define.values()) {
            if (i == trigger_Can_Define.value1) {
                return trigger_Can_Define;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum Trigger_Flex_Define {
        trig_flex_define_id(0, "", "", ""),
        trig_flex_define_cyc(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        Trigger_Flex_Define(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static Trigger_Flex_Define getTrigger_Flex_DefineFromValue1(int i) {
        Trigger_Flex_Define[] values;
        for (Trigger_Flex_Define trigger_Flex_Define : Trigger_Flex_Define.values()) {
            if (i == trigger_Flex_Define.value1) {
                return trigger_Flex_Define;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ClockRecovery {
        CR_Auto(0, "", "", ""),
        CR_Pll(1, "", "", ""),
        CR_Ext(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ClockRecovery(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ClockRecovery getClockRecoveryFromValue1(int i) {
        ClockRecovery[] values;
        for (ClockRecovery clockRecovery : ClockRecovery.values()) {
            if (i == clockRecovery.value1) {
                return clockRecovery;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum RateType {
        Clock_Auto(0, "", "", ""),
        Clock_Semi(1, "", "", ""),
        Clock_Manu(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        RateType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static RateType getRateTypeFromValue1(int i) {
        RateType[] values;
        for (RateType rateType : RateType.values()) {
            if (i == rateType.value1) {
                return rateType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CRType {
        CONST_CR(0, "", "", ""),
        PLL_CR(1, "", "", ""),
        PARA_CR(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CRType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CRType getCRTypeFromValue1(int i) {
        CRType[] values;
        for (CRType cRType : CRType.values()) {
            if (i == cRType.value1) {
                return cRType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum PLLorder {
        ONE_ORDER(0, "", "", ""),
        TWO_ORDER(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        PLLorder(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static PLLorder getPLLorderFromValue1(int i) {
        PLLorder[] values;
        for (PLLorder pLLorder : PLLorder.values()) {
            if (i == pLLorder.value1) {
                return pLLorder;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FreqType {
        AUTO_FREQ(0, "", "", ""),
        SEMIAUTO_FREQ(1, "", "", ""),
        MANUAL_FREQ(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FreqType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FreqType getFreqTypeFromValue1(int i) {
        FreqType[] values;
        for (FreqType freqType : FreqType.values()) {
            if (i == freqType.value1) {
                return freqType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum EyeErr {
        EyeErr_None(0, "", "", ""),
        EyeErr_Timebase_Large(1, "", "", ""),
        EyeErr_Timebase_Small(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        EyeErr(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static EyeErr getEyeErrFromValue1(int i) {
        EyeErr[] values;
        for (EyeErr eyeErr : EyeErr.values()) {
            if (i == eyeErr.value1) {
                return eyeErr;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum LogGrade {
        Log_Verbose(0, "", "", ""),
        Log_DeBug(1, "", "", ""),
        Log_Info(2, "", "", ""),
        Log_Warn(3, "", "", ""),
        Log_Error(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        LogGrade(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static LogGrade getLogGradeFromValue1(int i) {
        LogGrade[] values;
        for (LogGrade logGrade : LogGrade.values()) {
            if (i == logGrade.value1) {
                return logGrade;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TimeZoneDiff {
        ZONE_DIFF(0, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TimeZoneDiff(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TimeZoneDiff getTimeZoneDiffFromValue1(int i) {
        TimeZoneDiff[] values;
        for (TimeZoneDiff timeZoneDiff : TimeZoneDiff.values()) {
            if (i == timeZoneDiff.value1) {
                return timeZoneDiff;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum HDMI_Ratio {
        HDMI_1920x1080(0, "", "", ""),
        HDMI_1600x900(1, "", "", ""),
        HDMI_1280x1024(2, "", "", ""),
        HDMI_1280x720(3, "", "", ""),
        HDMI_1024x768(4, "", "", ""),
        HDMI_800x600(5, "", "", ""),
        HDMI_720x480(6, "", "", ""),
        HDMI_640x480(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        HDMI_Ratio(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static HDMI_Ratio getHDMI_RatioFromValue1(int i) {
        HDMI_Ratio[] values;
        for (HDMI_Ratio hDMI_Ratio : HDMI_Ratio.values()) {
            if (i == hDMI_Ratio.value1) {
                return hDMI_Ratio;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ClockSlope {
        CLOCK_RISE(0, "", "", ""),
        CLOCK_FALL(1, "", "", ""),
        CLOCK_BOTH(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ClockSlope(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ClockSlope getClockSlopeFromValue1(int i) {
        ClockSlope[] values;
        for (ClockSlope clockSlope : ClockSlope.values()) {
            if (i == clockSlope.value1) {
                return clockSlope;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BusAnalyseType {
        AnalyseUsb(0, "", "", ""),
        AnalyseEth(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BusAnalyseType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BusAnalyseType getBusAnalyseTypeFromValue1(int i) {
        BusAnalyseType[] values;
        for (BusAnalyseType busAnalyseType : BusAnalyseType.values()) {
            if (i == busAnalyseType.value1) {
                return busAnalyseType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AnalyseEthType {
        ethernet_10_baset(0, "", "", ""),
        ethernet_100_baset(1, "", "", ""),
        ethernet_1000_baset(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AnalyseEthType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AnalyseEthType getAnalyseEthTypeFromValue1(int i) {
        AnalyseEthType[] values;
        for (AnalyseEthType analyseEthType : AnalyseEthType.values()) {
            if (i == analyseEthType.value1) {
                return analyseEthType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum PanelKey {
        KEY_CH1(0, "", "", ""),
        KEY_CH2(1, "", "", ""),
        KEY_CH3(2, "", "", ""),
        KEY_CH4(3, "", "", ""),
        KEY_VPOS1(4, "", "", ""),
        KEY_VPOS2(5, "", "", ""),
        KEY_VPOS3(6, "", "", ""),
        KEY_VPOS4(7, "", "", ""),
        KEY_VSCALE1(8, "", "", ""),
        KEY_VSCALE2(9, "", "", ""),
        KEY_VSCALE3(10, "", "", ""),
        KEY_VSCALE4(11, "", "", ""),
        KEY_MATH(12, "", "", ""),
        KEY_REF(13, "", "", ""),
        KEY_MEASURE(14, "", "", ""),
        KEY_CURSOR(15, "", "", ""),
        KEY_ACQUIRE(16, "", "", ""),
        KEY_RUNSTOP(17, "", "", ""),
        KEY_CLEAR(18, "", "", ""),
        KEY_DISPLAY(19, "", "", ""),
        KEY_FORCE(20, "", "", ""),
        KEY_AUTO(21, "", "", ""),
        KEY_SINGLE(22, "", "", ""),
        KEY_STORAGE(23, "", "", ""),
        KEY_QUICK(24, "", "", ""),
        KEY_DEFAULT(25, "", "", ""),
        KEY_HSCALE(26, "", "", ""),
        KEY_HPOS(27, "", "", ""),
        KEY_HMENU(28, "", "", ""),
        KEY_SEARCH(29, "", "", ""),
        KEY_ZOOM(30, "", "", ""),
        KEY_TRIGGER(31, "", "", ""),
        KEY_TRIGLEVEL(32, "", "", ""),
        KEY_BUS(33, "", "", ""),
        KEY_UTILITY(34, "", "", ""),
        KEY_LA(35, "", "", ""),
        KEY_VPOS(36, "", "", ""),
        KEY_VSCALE(37, "", "", ""),
        KEY_ANALYSE(38, "", "", ""),
        KEY_TOUCHLOCK(39, "", "", ""),
        KEY_SLOPE(40, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        PanelKey(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static PanelKey getPanelKeyFromValue1(int i) {
        PanelKey[] values;
        for (PanelKey panelKey : PanelKey.values()) {
            if (i == panelKey.value1) {
                return panelKey;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FlexKnobEnum {
        Intensity(45, "Intensity", "ic_flex_knob_intensity", ""),
        Cursor(44, "Cursor", "ic_flex_knob_cursor", ""),
        Math1(38, "Math1", "ic_flex_knob_math1", ""),
        Math2(39, "Math2", "ic_flex_knob_math2", ""),
        Math3(40, "Math3", "ic_flex_knob_math3", ""),
        Math4(41, "Math4", "ic_flex_knob_math4", ""),
        LA(50, "LA", "ic_flex_knob_la", ""),
        DG1(42, "DG1", "ic_flex_knob_g1", ""),
        DG2(43, "DG2", "ic_flex_knob_g2", ""),
        Ref1(28, "Ref1", "ic_flex_knob_ref1", ""),
        Ref2(29, "Ref2", "ic_flex_knob_ref2", ""),
        Ref3(30, "Ref3", "ic_flex_knob_ref3", ""),
        Ref4(31, "Ref4", "ic_flex_knob_ref4", ""),
        Ref5(32, "Ref5", "ic_flex_knob_ref5", ""),
        Ref6(33, "Ref6", "ic_flex_knob_ref6", ""),
        Ref7(34, "Ref7", "ic_flex_knob_ref7", ""),
        Ref8(35, "Ref8", "ic_flex_knob_ref8", ""),
        Ref9(36, "Ref9", "ic_flex_knob_ref9", ""),
        Ref10(37, "Ref10", "ic_flex_knob_ref10", ""),
        Decoder1(46, "Decoder1", "ic_flex_knob_decoder1", ""),
        Decoder2(47, "Decoder2", "ic_flex_knob_decoder2", ""),
        Decoder3(48, "Decoder3", "ic_flex_knob_decoder3", ""),
        Decoder4(49, "Decoder4", "ic_flex_knob_decoder4", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FlexKnobEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FlexKnobEnum getFlexKnobEnumFromValue1(int i) {
        FlexKnobEnum[] values;
        for (FlexKnobEnum flexKnobEnum : FlexKnobEnum.values()) {
            if (i == flexKnobEnum.value1) {
                return flexKnobEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TclockFor {
        FOR_EYE(10, "", "", ""),
        FOR_JIT(11, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TclockFor(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TclockFor getTclockForFromValue1(int i) {
        TclockFor[] values;
        for (TclockFor tclockFor : TclockFor.values()) {
            if (i == tclockFor.value1) {
                return tclockFor;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum TJITTER_TYPE {
        CLK_TIE(0, "", "", ""),
        DAT_TIE(1, "", "", ""),
        CYC_CYC(2, "", "", ""),
        POS_POS(3, "", "", ""),
        NEG_NEG(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        TJITTER_TYPE(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static TJITTER_TYPE getTJITTER_TYPEFromValue1(int i) {
        TJITTER_TYPE[] values;
        for (TJITTER_TYPE tjitter_type : TJITTER_TYPE.values()) {
            if (i == tjitter_type.value1) {
                return tjitter_type;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DevStatusEnum {
        DEV_OK(0, "", "", ""),
        DEV_BUS_ERROR(-1, "", "", ""),
        DEV_FPGA_ERROR(-2, "", "", ""),
        DEV_CONFIG_ERROR(-3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DevStatusEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DevStatusEnum getDevStatusEnumFromValue1(int i) {
        DevStatusEnum[] values;
        for (DevStatusEnum devStatusEnum : DevStatusEnum.values()) {
            if (i == devStatusEnum.value1) {
                return devStatusEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DrvStatus {
        DRV_OK(0, "", "", ""),
        DRV_INIT_ERROR(-1, "", "", ""),
        DRV_PARAM_ERROR(-2, "", "", ""),
        DRV_TRACE_ERROR(-3, "", "", ""),
        DRV_SAME_PARAM(-4, "", "", ""),
        DRV_READ_ERROR(-5, "", "", ""),
        DRV_FEM_ERROR(-6, "", "", ""),
        DRV_WPU_ZOOM_ERROR(-7, "", "", ""),
        DRV_NO_SIGNAL(-8, "", "", ""),
        DRV_CAL_ERROR(-9, "", "", ""),
        DRV_SCAN_PLAY(-10, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DrvStatus(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DrvStatus getDrvStatusFromValue1(int i) {
        DrvStatus[] values;
        for (DrvStatus drvStatus : DrvStatus.values()) {
            if (i == drvStatus.value1) {
                return drvStatus;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ApiStatus {
        API_OK(0, "", "", ""),
        API_ERROR(-1, "", "", ""),
        API_ERR_LIMIT(-2, "", "", ""),
        API_ERR_INVALID_CONFIG(-3, "", "", ""),
        API_ERR_AUTO_DISABLED(-4, "", "", ""),
        API_ERR_NO_SIGNAL(-5, "", "", ""),
        API_ERR_OPT_UNUSABLE(-6, "", "", ""),
        API_ERR_QUERY_ENGINE(-7, "", "", ""),
        API_ERR_DRV(-8, "", "", ""),
        API_ERR_FILE_SAVE_FAIL(-9, "", "", ""),
        API_ERR_FILE_NAME(-10, "", "", ""),
        API_ERR_FILE_NOT_FOUND(-11, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ApiStatus(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ApiStatus getApiStatusFromValue1(int i) {
        ApiStatus[] values;
        for (ApiStatus apiStatus : ApiStatus.values()) {
            if (i == apiStatus.value1) {
                return apiStatus;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SampleRateEnum {
        SAMPLE_RATE_2K(2000, "", "", ""),
        SAMPLE_RATE_2d5K(2500, "", "", ""),
        SAMPLE_RATE_125K(125000, "", "", ""),
        SAMPLE_RATE_200K(200000, "", "", ""),
        SAMPLE_RATE_500K(500000, "", "", ""),
        SAMPLE_RATE_1M(1000000, "", "", ""),
        SAMPLE_RATE_1d25M(1250000, "", "", ""),
        SAMPLE_RATE_2M(2000000, "", "", ""),
        SAMPLE_RATE_2d5M(2500000, "", "", ""),
        SAMPLE_RATE_5M(5000000, "", "", ""),
        SAMPLE_RATE_6d25M(6250000, "", "", ""),
        SAMPLE_RATE_10M(10000000, "", "", ""),
        SAMPLE_RATE_12d5M(12500000, "", "", ""),
        SAMPLE_RATE_20M(20000000, "", "", ""),
        SAMPLE_RATE_25M(25000000, "", "", ""),
        SAMPLE_RATE_31d25M(31250000, "", "", ""),
        SAMPLE_RATE_50M(50000000, "", "", ""),
        SAMPLE_RATE_62d5M(62500000, "", "", ""),
        SAMPLE_RATE_78d125M(78125000, "", "", ""),
        SAMPLE_RATE_100M(100000000, "", "", ""),
        SAMPLE_RATE_125M(125000000, "", "", ""),
        SAMPLE_RATE_156d25M(156250000, "", "", ""),
        SAMPLE_RATE_200M(200000000, "", "", ""),
        SAMPLE_RATE_250M(250000000, "", "", ""),
        SAMPLE_RATE_312d5M(312500000, "", "", ""),
        SAMPLE_RATE_400M(400000000, "", "", ""),
        SAMPLE_RATE_500M(500000000, "", "", ""),
        SAMPLE_RATE_625M(625000000, "", "", ""),
        SAMPLE_RATE_800M(800000000, "", "", ""),
        SAMPLE_RATE_1G(1000000000, "", "", ""),
        SAMPLE_RATE_1d25G(1250000000, "", "", ""),
        SAMPLE_RATE_1d6G(1600000000, "", "", ""),
        SAMPLE_RATE_2G(2000000000, "", "", ""),
        SAMPLE_RATE_2d5G(2500000000L, "", "", ""),
        SAMPLE_RATE_4G(4000000000L, "", "", ""),
        SAMPLE_RATE_5G(5000000000L, "", "", ""),
        SAMPLE_RATE_8G(8000000000L, "", "", ""),
        SAMPLE_RATE_10G(10000000000L, "", "", ""),
        SAMPLE_RATE_20G(20000000000L, "", "", ""),
        SAMPLE_RATE_40G(40000000000L, "", "", ""),
        SAMPLE_RATE_80G(80000000000L, "", "", ""),
        SAMPLE_RATE_100G(100000000000L, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final long value1;
        public final String value2;

        SampleRateEnum(long j, String str, String str2, String str3) {
            this.value1 = j;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SampleRateEnum getSampleRateEnumFromValue1(long j) {
        SampleRateEnum[] values;
        for (SampleRateEnum sampleRateEnum : SampleRateEnum.values()) {
            if (j == sampleRateEnum.value1) {
                return sampleRateEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SampleMode {
        SINGLE_SAMPLE_MODE(1, "", "", ""),
        DUAL_SAMPLE_MODE(2, "", "", ""),
        QUAD_SAMPLE_MODE(4, "", "", ""),
        OCTA_SAMPLE_MODE(8, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SampleMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SampleMode getSampleModeFromValue1(int i) {
        SampleMode[] values;
        for (SampleMode sampleMode : SampleMode.values()) {
            if (i == sampleMode.value1) {
                return sampleMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SaoLaCoreMode {
        ADC_MODE_ABCD(0, "", "", ""),
        ADC_MODE_EXT_THA_B(1, "", "", ""),
        ADC_MODE_EXT_THA_A(2, "", "", ""),
        ADC_MODE_CHABCD(3, "", "", ""),
        ADC_MODE_AC(4, "", "", ""),
        ADC_MODE_BC(5, "", "", ""),
        ADC_MODE_AD(6, "", "", ""),
        ADC_MODE_BD(7, "", "", ""),
        ADC_MODE_A(8, "", "", ""),
        ADC_MODE_B(9, "", "", ""),
        ADC_MODE_C(10, "", "", ""),
        ADC_MODE_D(11, "", "", ""),
        ADC_MODE_COM_A(12, "", "", ""),
        ADC_MODE_COM_B(13, "", "", ""),
        ADC_MODE_COM_C(14, "", "", ""),
        ADC_MODE_COM_D(15, "", "", ""),
        ADC_MODE_END(16, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SaoLaCoreMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SaoLaCoreMode getSaoLaCoreModeFromValue1(int i) {
        SaoLaCoreMode[] values;
        for (SaoLaCoreMode saoLaCoreMode : SaoLaCoreMode.values()) {
            if (i == saoLaCoreMode.value1) {
                return saoLaCoreMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum SpuTxType {
        CH_WAVE_MAIN(0, "", "", ""),
        CH_WAVE_ZOOM(1, "", "", ""),
        LA_WAVE_MAIN(2, "", "", ""),
        LA_WAVE_ZOOM(3, "", "", ""),
        CH_ROLL_COL(4, "", "", ""),
        LA_ROLL_COL(5, "", "", ""),
        CH_TRACE(6, "", "", ""),
        CH_EYE(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        SpuTxType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static SpuTxType getSpuTxTypeFromValue1(int i) {
        SpuTxType[] values;
        for (SpuTxType spuTxType : SpuTxType.values()) {
            if (i == spuTxType.value1) {
                return spuTxType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum VersionEnum {
        HDU_VERSION(0, "", "", ""),
        AFE_VERSION(1, "", "", ""),
        ADC_VERSION(2, "", "", ""),
        SCU_VERSION(3, "", "", ""),
        SPU_VERSION(4, "", "", ""),
        WPU_VERSION(5, "", "", ""),
        WAU_VERSION(6, "", "", ""),
        TPU_VERSION(7, "", "", ""),
        AFG_VERSION(8, "", "", ""),
        DCU_VERSION(9, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        VersionEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static VersionEnum getVersionEnumFromValue1(int i) {
        VersionEnum[] values;
        for (VersionEnum versionEnum : VersionEnum.values()) {
            if (i == versionEnum.value1) {
                return versionEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AdcCoreEnum {
        ADC_CORE_A(0, "", "", ""),
        ADC_CORE_B(1, "", "", ""),
        ADC_CORE_C(2, "", "", ""),
        ADC_CORE_D(3, "", "", ""),
        ADC_CORE_E(4, "", "", ""),
        ADC_CORE_F(5, "", "", ""),
        ADC_CORE_G(6, "", "", ""),
        ADC_CORE_H(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AdcCoreEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AdcCoreEnum getAdcCoreEnumFromValue1(int i) {
        AdcCoreEnum[] values;
        for (AdcCoreEnum adcCoreEnum : AdcCoreEnum.values()) {
            if (i == adcCoreEnum.value1) {
                return adcCoreEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AdcInterSwitchEnum {
        ADC_AI(0, "", "", ""),
        ADC_BI(1, "", "", ""),
        ADC_CI(2, "", "", ""),
        ADC_DI(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AdcInterSwitchEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AdcInterSwitchEnum getAdcInterSwitchEnumFromValue1(int i) {
        AdcInterSwitchEnum[] values;
        for (AdcInterSwitchEnum adcInterSwitchEnum : AdcInterSwitchEnum.values()) {
            if (i == adcInterSwitchEnum.value1) {
                return adcInterSwitchEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AdcChanInputModeEnum {
        ADC_SWITCH_ON_CH1(0, "", "", ""),
        ADC_SWITCH_ON_CH2(1, "", "", ""),
        ADC_SWITCH_ON_CH3(2, "", "", ""),
        ADC_SWITCH_ON_CH4(3, "", "", ""),
        ADC_SWITCH_ON_CH12(4, "", "", ""),
        ADC_SWITCH_ON_CH13(5, "", "", ""),
        ADC_SWITCH_ON_CH14(6, "", "", ""),
        ADC_SWITCH_ON_CH23(7, "", "", ""),
        ADC_SWITCH_ON_CH24(8, "", "", ""),
        ADC_SWITCH_ON_CH34(9, "", "", ""),
        ADC_SWITCH_ON_CH1234(10, "", "", ""),
        ADC_CHAN_MODE_NUM(11, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AdcChanInputModeEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AdcChanInputModeEnum getAdcChanInputModeEnumFromValue1(int i) {
        AdcChanInputModeEnum[] values;
        for (AdcChanInputModeEnum adcChanInputModeEnum : AdcChanInputModeEnum.values()) {
            if (i == adcChanInputModeEnum.value1) {
                return adcChanInputModeEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AdcChanEnum {
        ADC_CH1(0, "", "", ""),
        ADC_CH2(1, "", "", ""),
        ADC_CH3(2, "", "", ""),
        ADC_CH4(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AdcChanEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AdcChanEnum getAdcChanEnumFromValue1(int i) {
        AdcChanEnum[] values;
        for (AdcChanEnum adcChanEnum : AdcChanEnum.values()) {
            if (i == adcChanEnum.value1) {
                return adcChanEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AdcSerialNumEnum {
        ADC_1(0, "", "", ""),
        ADC_2(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AdcSerialNumEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AdcSerialNumEnum getAdcSerialNumEnumFromValue1(int i) {
        AdcSerialNumEnum[] values;
        for (AdcSerialNumEnum adcSerialNumEnum : AdcSerialNumEnum.values()) {
            if (i == adcSerialNumEnum.value1) {
                return adcSerialNumEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FEMStatus {
        FEM_ERR_NONE(0, "", "", ""),
        FEM_ERR_LOGGER_DISCONNECT(-1, "", "", ""),
        FEM_ERR_LOGGER_TIMEOUT(-2, "", "", ""),
        FEM_ERR_QUEUE_FULL(-10, "", "", ""),
        FEM_ERR_QUEUE_EMPTY(-11, "", "", ""),
        FEM_ERR_QUEUEE_INTERNALERROR(-12, "", "", ""),
        FEM_ERR_EXCUTE_TIMEOUT(-20, "", "", ""),
        FEM_ERR_EXCUTE_ERRPTR(-21, "", "", ""),
        FEM_ERR_EXCUTE_NULLPTR(-22, "", "", ""),
        FEM_ERR_EXCUTE_TIMEOUT_ERR(-23, "", "", ""),
        FEM_ERR_PARAMS_TOOMANY(-30, "", "", ""),
        FEM_ERR_FUNCTION_NOTEXIST(-40, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FEMStatus(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FEMStatus getFEMStatusFromValue1(int i) {
        FEMStatus[] values;
        for (FEMStatus fEMStatus : FEMStatus.values()) {
            if (i == fEMStatus.value1) {
                return fEMStatus;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum FuncPermissionControlEnum {
        FUNC_PERMISSION_USER(0, "", "", ""),
        FUNC_PERMISSION_PRIVIATE(1, "", "", ""),
        FUNC_PERMISSION_ROOT(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        FuncPermissionControlEnum(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static FuncPermissionControlEnum getFuncPermissionControlEnumFromValue1(int i) {
        FuncPermissionControlEnum[] values;
        for (FuncPermissionControlEnum funcPermissionControlEnum : FuncPermissionControlEnum.values()) {
            if (i == funcPermissionControlEnum.value1) {
                return funcPermissionControlEnum;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum struExectue {
        FUNC_ATTR_DIRECT(0, "", "", ""),
        FUNC_ATTR_CACHE(1, "", "", ""),
        FUNC_ATTR_SYNC(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        struExectue(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static struExectue getstruExectueFromValue1(int i) {
        struExectue[] values;
        for (struExectue struexectue : struExectue.values()) {
            if (i == struexectue.value1) {
                return struexectue;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ProductDomain {
        DOMAIN_DSO(0, "", "", ""),
        DOMAIN_MSO(1, "", "", ""),
        DOMAIN_HDO(2, "", "", ""),
        DOMAIN_DSA(3, "", "", ""),
        DOMAIN_RSA(4, "", "", ""),
        DOMAIN_AFG(5, "", "", ""),
        DOMAIN_AWG(6, "", "", ""),
        DOMAIN_MDO(7, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ProductDomain(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ProductDomain getProductDomainFromValue1(int i) {
        ProductDomain[] values;
        for (ProductDomain productDomain : ProductDomain.values()) {
            if (i == productDomain.value1) {
                return productDomain;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ProductSeries {
        SERIES_800(800, "", "", ""),
        SERIES_900(900, "", "", ""),
        SERIES_1000(1000, "", "", ""),
        SERIES_2000(PackageUtilKt.ERROR_PACKAGE_FILE_DOWNLOAD, "", "", ""),
        SERIES_3000(3000, "", "", ""),
        SERIES_4000(4000, "", "", ""),
        SERIES_5000(DNSConstants.PROBE_THROTTLE_COUNT_INTERVAL, "", "", ""),
        SERIES_6000(6000, "", "", ""),
        SERIES_7000(7000, "", "", ""),
        SERIES_8000(WebIndicator.MAX_UNIFORM_SPEED_DURATION, "", "", ""),
        SERIES_9000(MessageID.MSG_HOR_XYZ_X, "", "", ""),
        SERIES_10000(10000, "", "", ""),
        SERIES_20000(20000, "", "", ""),
        SERIES_30000(30000, "", "", ""),
        SERIES_40000(40000, "", "", ""),
        SERIES_50000(50000, "", "", ""),
        SERIES_60000(TimeConstants.MIN, "", "", ""),
        SERIES_70000(70000, "", "", ""),
        SERIES_80000(80000, "", "", ""),
        SERIES_90000(90000, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ProductSeries(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ProductSeries getProductSeriesFromValue1(int i) {
        ProductSeries[] values;
        for (ProductSeries productSeries : ProductSeries.values()) {
            if (i == productSeries.value1) {
                return productSeries;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum NavigateMode {
        TimeOffsetMode(0, "", "", ""),
        SearchEventMode(1, "", "", ""),
        CondensationTimeMode(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        NavigateMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static NavigateMode getNavigateModeFromValue1(int i) {
        NavigateMode[] values;
        for (NavigateMode navigateMode : NavigateMode.values()) {
            if (i == navigateMode.value1) {
                return navigateMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CondensationTimeDisplayMode {
        Adjacent(0, "", "", ""),
        Overlay(1, "", "", ""),
        Waterfall(2, "", "", ""),
        Perspective(3, "", "", ""),
        Mosaic(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CondensationTimeDisplayMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CondensationTimeDisplayMode getCondensationTimeDisplayModeFromValue1(int i) {
        CondensationTimeDisplayMode[] values;
        for (CondensationTimeDisplayMode condensationTimeDisplayMode : CondensationTimeDisplayMode.values()) {
            if (i == condensationTimeDisplayMode.value1) {
                return condensationTimeDisplayMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum NavigatePlayingSpeed {
        high(1, "", "", ""),
        normal(2, "", "", ""),
        low(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        NavigatePlayingSpeed(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static NavigatePlayingSpeed getNavigatePlayingSpeedFromValue1(int i) {
        NavigatePlayingSpeed[] values;
        for (NavigatePlayingSpeed navigatePlayingSpeed : NavigatePlayingSpeed.values()) {
            if (i == navigatePlayingSpeed.value1) {
                return navigatePlayingSpeed;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DvmLimitType {
        IN_LIMIT(0, "", "", ""),
        OUT_LIMIT(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DvmLimitType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DvmLimitType getDvmLimitTypeFromValue1(int i) {
        DvmLimitType[] values;
        for (DvmLimitType dvmLimitType : DvmLimitType.values()) {
            if (i == dvmLimitType.value1) {
                return dvmLimitType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum DeviceSelfTestType {
        ADC2_CHIP_TEMP(0, "", "", ""),
        ADC2_AMBIENT_TEMP(1, "", "", ""),
        ADC1_CHIP_TEMP(2, "", "", ""),
        ADC1_AMBIENT_TEMP(3, "", "", ""),
        CH4_CHIP_TEMP(4, "", "", ""),
        CH4_AMBIENT_TEMP(5, "", "", ""),
        CH1_CHIP_TEMP(6, "", "", ""),
        CH1_AMBIENT_TEMP(7, "", "", ""),
        CPU_CHIP_TEMP(8, "", "", ""),
        CPU_AMBIENT_TEMP(9, "", "", ""),
        SPU_CHIP_TEMP(10, "", "", ""),
        SPU_VCCINT(11, "", "", ""),
        SPU_MGTAVIT(12, "", "", ""),
        SPU_VCC_DDR(13, "", "", ""),
        AFE23_VCC(14, "", "", ""),
        AFE01_VCC(15, "", "", ""),
        ADC1_VCC(16, "", "", ""),
        ADC0_VCC(17, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        DeviceSelfTestType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static DeviceSelfTestType getDeviceSelfTestTypeFromValue1(int i) {
        DeviceSelfTestType[] values;
        for (DeviceSelfTestType deviceSelfTestType : DeviceSelfTestType.values()) {
            if (i == deviceSelfTestType.value1) {
                return deviceSelfTestType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum NavigationType {
        FORWARD(0, "", "", ""),
        BACKWARD(1, "", "", ""),
        FIRST(2, "", "", ""),
        LAST(3, "", "", ""),
        STATELESS(4, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        NavigationType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static NavigationType getNavigationTypeFromValue1(int i) {
        NavigationType[] values;
        for (NavigationType navigationType : NavigationType.values()) {
            if (i == navigationType.value1) {
                return navigationType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AutoExecuteType {
        EXECUTE(0, "", "", ""),
        UNDO(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AutoExecuteType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AutoExecuteType getAutoExecuteTypeFromValue1(int i) {
        AutoExecuteType[] values;
        for (AutoExecuteType autoExecuteType : AutoExecuteType.values()) {
            if (i == autoExecuteType.value1) {
                return autoExecuteType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum PowerMode {
        Power_Performance(0, "", "", ""),
        Power_Saver(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        PowerMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static PowerMode getPowerModeFromValue1(int i) {
        PowerMode[] values;
        for (PowerMode powerMode : PowerMode.values()) {
            if (i == powerMode.value1) {
                return powerMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum WaveDataType {
        TRACE_WFM(0, "", "", ""),
        TRACE_BUS(1, "", "", ""),
        TRACE_RTSA(2, "", "", ""),
        TRACE_SEARCH(3, "", "", ""),
        TRACE_HISTOGRAM(4, "", "", ""),
        TRACE_LA(5, "", "", ""),
        MEMORY_WFM(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        WaveDataType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static WaveDataType getWaveDataTypeFromValue1(int i) {
        WaveDataType[] values;
        for (WaveDataType waveDataType : WaveDataType.values()) {
            if (i == waveDataType.value1) {
                return waveDataType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ModType {
        Mod_AM(0, "", "", ""),
        Mod_FM(1, "", "", ""),
        Mod_PM(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ModType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ModType getModTypeFromValue1(int i) {
        ModType[] values;
        for (ModType modType : ModType.values()) {
            if (i == modType.value1) {
                return modType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ModSourceType {
        ModSource_Internal(0, "", "", ""),
        ModSource_External(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ModSourceType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ModSourceType getModSourceTypeFromValue1(int i) {
        ModSourceType[] values;
        for (ModSourceType modSourceType : ModSourceType.values()) {
            if (i == modSourceType.value1) {
                return modSourceType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ModShape {
        ModShape_Sine(0, "", "", ""),
        ModShape_Square(1, "", "", ""),
        ModShape_Triangle(2, "", "", ""),
        ModShape_Upramp(3, "", "", ""),
        ModShape_Dnramp(4, "", "", ""),
        ModShape_Noise(5, "", "", ""),
        ModShape_Arb(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ModShape(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ModShape getModShapeFromValue1(int i) {
        ModShape[] values;
        for (ModShape modShape : ModShape.values()) {
            if (i == modShape.value1) {
                return modShape;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ApiSweepType {
        API_SWEEP_LINEAR(0, "", "", ""),
        API_SWEEP_LOG(1, "", "", ""),
        API_SWEEP_STEP(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ApiSweepType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ApiSweepType getApiSweepTypeFromValue1(int i) {
        ApiSweepType[] values;
        for (ApiSweepType apiSweepType : ApiSweepType.values()) {
            if (i == apiSweepType.value1) {
                return apiSweepType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ApiTrigOutSource {
        INTERNAL(0, "", "", ""),
        EXTERNAL(1, "", "", ""),
        MANNUAL(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ApiTrigOutSource(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ApiTrigOutSource getApiTrigOutSourceFromValue1(int i) {
        ApiTrigOutSource[] values;
        for (ApiTrigOutSource apiTrigOutSource : ApiTrigOutSource.values()) {
            if (i == apiTrigOutSource.value1) {
                return apiTrigOutSource;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum ApiTrigInType {
        RISING(0, "", "", ""),
        FALLING(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        ApiTrigInType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static ApiTrigInType getApiTrigInTypeFromValue1(int i) {
        ApiTrigInType[] values;
        for (ApiTrigInType apiTrigInType : ApiTrigInType.values()) {
            if (i == apiTrigInType.value1) {
                return apiTrigInType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AfgWaveMode {
        WAVE_BASIC(0, "", "", ""),
        WAVE_MOD(1, "", "", ""),
        WAVE_SWEEP(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AfgWaveMode(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AfgWaveMode getAfgWaveModeFromValue1(int i) {
        AfgWaveMode[] values;
        for (AfgWaveMode afgWaveMode : AfgWaveMode.values()) {
            if (i == afgWaveMode.value1) {
                return afgWaveMode;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AfgBasicWaveType {
        BASIC_WAVE_SINE(0, "", "", ""),
        BASIC_WAVE_SQU(1, "", "", ""),
        BASIC_WAVE_RAMP(2, "", "", ""),
        BASIC_WAVE_PULSE(3, "", "", ""),
        BASIC_WAVE_NOISE(4, "", "", ""),
        BASIC_WAVE_DC(5, "", "", ""),
        BASIC_WAVE_ARB(6, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AfgBasicWaveType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AfgBasicWaveType getAfgBasicWaveTypeFromValue1(int i) {
        AfgBasicWaveType[] values;
        for (AfgBasicWaveType afgBasicWaveType : AfgBasicWaveType.values()) {
            if (i == afgBasicWaveType.value1) {
                return afgBasicWaveType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum LaGroup {
        la_g1(0, "", "", ""),
        la_g2(1, "", "", ""),
        la_g3(2, "", "", ""),
        la_g4(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        LaGroup(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static LaGroup getLaGroupFromValue1(int i) {
        LaGroup[] values;
        for (LaGroup laGroup : LaGroup.values()) {
            if (i == laGroup.value1) {
                return laGroup;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BodeFileType {
        SAVE_BMP(0, "", "", ""),
        SAVE_PNG(1, "", "", ""),
        SAVE_CSV(2, "", "", ""),
        SAVE_HTML(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BodeFileType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BodeFileType getBodeFileTypeFromValue1(int i) {
        BodeFileType[] values;
        for (BodeFileType bodeFileType : BodeFileType.values()) {
            if (i == bodeFileType.value1) {
                return bodeFileType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BodeDispType {
        DISP_WAVE(0, "", "", ""),
        DISP_TABLE(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BodeDispType(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BodeDispType getBodeDispTypeFromValue1(int i) {
        BodeDispType[] values;
        for (BodeDispType bodeDispType : BodeDispType.values()) {
            if (i == bodeDispType.value1) {
                return bodeDispType;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BodeSweep {
        LOG_SWEEP(0, "", "", ""),
        LINE_SWEEP(1, "", "", ""),
        POINT_SWEEP(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BodeSweep(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BodeSweep getBodeSweepFromValue1(int i) {
        BodeSweep[] values;
        for (BodeSweep bodeSweep : BodeSweep.values()) {
            if (i == bodeSweep.value1) {
                return bodeSweep;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum BodeSource {
        SOURCE1(0, "", "", ""),
        SOURCE2(1, "", "", ""),
        EXTSOURCE(2, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        BodeSource(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static BodeSource getBodeSourceFromValue1(int i) {
        BodeSource[] values;
        for (BodeSource bodeSource : BodeSource.values()) {
            if (i == bodeSource.value1) {
                return bodeSource;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum LaProbeCal {
        NO_CAL(0, "", "", ""),
        CAL_START(1, "", "", ""),
        CALING(2, "", "", ""),
        CAL_END(3, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        LaProbeCal(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static LaProbeCal getLaProbeCalFromValue1(int i) {
        LaProbeCal[] values;
        for (LaProbeCal laProbeCal : LaProbeCal.values()) {
            if (i == laProbeCal.value1) {
                return laProbeCal;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum CalAfgItem {
        CAL_AFG_FREQ(0, "", "", ""),
        CAL_AFG_OFFSET(1, "", "", ""),
        CAL_AFG_AC_AMPL(2, "", "", ""),
        CAL_AFG_LOFREQ_FLAT(3, "", "", ""),
        CAL_AFG_HIFREQ_FLAT(4, "", "", ""),
        CAL_AFG_INNER_LOAD(5, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        CalAfgItem(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static CalAfgItem getCalAfgItemFromValue1(int i) {
        CalAfgItem[] values;
        for (CalAfgItem calAfgItem : CalAfgItem.values()) {
            if (i == calAfgItem.value1) {
                return calAfgItem;
            }
        }
        return null;
    }

    /* loaded from: classes2.dex */
    public enum AfgImpedance {
        IMP_OMEG(0, "", "", ""),
        IMP_FIFTY(1, "", "", "");
        
        public final String pic1;
        public final String pic2;
        public final int value1;
        public final String value2;

        AfgImpedance(int i, String str, String str2, String str3) {
            this.value1 = i;
            this.value2 = str;
            this.pic1 = str2;
            this.pic2 = str3;
        }
    }

    public static AfgImpedance getAfgImpedanceFromValue1(int i) {
        AfgImpedance[] values;
        for (AfgImpedance afgImpedance : AfgImpedance.values()) {
            if (i == afgImpedance.value1) {
                return afgImpedance;
            }
        }
        return null;
    }
}
