package com.rigol.scope.data;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.databinding.Bindable;
import androidx.exifinterface.media.ExifInterface;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.OffsetUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import java.util.ArrayList;
import timber.log.Timber;

/* loaded from: classes2.dex */
public class TriggerParam extends BaseParam {
    private static final int DEFAULT_CAN_BYTR_COUNT = 1;
    private static final int DEFAULT_IIC_BYTECOUNT = 1;
    private static final int DEFAULT_LIN_BYTECOUNT = 1;
    private static final int DEFAULT_TIMEOUT_TIME = 1000000000;
    private boolean Define;
    private long address;
    private int allWidth;
    private MessageAttr allWidthAttr;
    private AorBManager aorBManager;
    private int bitType;
    private int byteLength;
    private int canBaud;
    private MessageAttr canBaudRateAttr;
    private MessageAttr canDataByteAttr;
    private int canDataIdType;
    private int canDataType;
    private boolean canDefine;
    private int canFdBaud;
    private MessageAttr canFdBaudRateAttr;
    private int canIdBits;
    private int canIdType;
    private ServiceEnum.Chan chan;
    private ServiceEnum.Chan chanB;
    private ServiceEnum.Chan chanC;
    private ServiceEnum.TriggerPattern[] chanDurationPattern;
    private long chanOffset;
    private ServiceEnum.TriggerPattern[] chanPattern;
    private long chanScale;
    private int channel;
    private int channelB;
    private int channelC;
    private long compareLowerLimit;
    private MessageAttr compareLowerLimitAttr;
    private long compareUperLimit;
    private MessageAttr compareUperLimitAttr;
    private ServiceEnum.Coupling coupling;
    private long data;
    private int dataBits;
    private MessageAttr dataBitsAttr;
    private int dataByte;
    private ServiceEnum.Chan delayChanA;
    private ServiceEnum.Chan delayChanB;
    private MessageAttr delayLevelAttr;
    private MessageAttr delayLevelBAttr;
    private MessageAttr delayLowerAttr;
    private long delayLowerLimit;
    private long delayUperLimit;
    private MessageAttr delayUpperAttr;
    private long delaylevelA;
    private long delaylevelB;
    private int downType;
    private MessageAttr durationLowerAttr;
    private long durationLowerLimit;
    private ServiceEnum.TriggerPattern durationPattern;
    String durationPatternValue;
    private long durationUperLimit;
    private MessageAttr durationUpperAttr;
    private ServiceEnum.EBaudRate eBaudRate;
    private ServiceEnum.EBaudRate eBaudRateCan;
    private ServiceEnum.EBaudRate eBaudRateLin;
    private ServiceEnum.EMoreThan eMoreThan;
    private int edgeNumber;
    private MessageAttr edgeNumberAttr;
    private ServiceEnum.EdgeSlope edgeSlope;
    private ServiceEnum.EdgeSlope edgeSlopeA;
    private ServiceEnum.EdgeSlope edgeSlopeB;
    private boolean enableToSetLevel;
    private long fdSamplePoints;
    private MessageAttr fdSamplePointsAttr;
    private int format;
    private String formatBinaryValue1Str;
    private String formatBinaryValue2Str;
    private String formatBinaryValue3DataStr;
    private String formatBinaryValue3IdStr;
    private String formatBinaryValue4Str;
    private String formatBinaryValue5MaxStr;
    private String formatBinaryValue5MinStr;
    private String formatBinaryValue5Str;
    private String formatBinaryValue6BitStr;
    private String formatBinaryValue6MaxStr;
    private String formatBinaryValue6RtaStr;
    private String formatBinaryValue6Str;
    private String formatValue1Str;
    private String formatValue2Str;
    private String formatValue3DataStr;
    private String formatValue3IdStr;
    private String formatValue4Str;
    private String formatValue5MaxStr;
    private String formatValue5MinStr;
    private String formatValue5Str;
    private String formatValue6BitStr;
    private String formatValue6MaxStr;
    private String formatValue6RtaStr;
    private String formatValue6Str;
    private long hold;
    private long holdOff;
    private MessageAttr holdOffAttr;
    private MessageAttr holdTimeAttr;
    private int i2cAddress;
    private MessageAttr i2cAddressAttr;
    private MessageAttr i2cByteLengthAttr;
    private int i2cDataType;
    private int i2sDataType;
    private boolean idExtended;
    private long idLowerLimit;
    private MessageAttr idLowerLimitAttr;
    private long idUperLimit;
    private MessageAttr idUperLimitAttr;
    private long idelTime;
    private MessageAttr idelTimeAttr;
    private ServiceEnum.Chan iicChanA;
    private ServiceEnum.Chan iicChanB;
    private MessageAttr iicLevelAttr;
    private MessageAttr iicLevelBAttr;
    private long iiclevelA;
    private long iiclevelB;
    private ServiceEnum.Chan iisChanA;
    private ServiceEnum.Chan iisChanB;
    private ServiceEnum.Chan iisChanC;
    private int iisDataType;
    private MessageAttr iisLevelAttr;
    private MessageAttr iisLevelBAttr;
    private MessageAttr iisLevelCAttr;
    private int iisMaxDataType;
    private int iisMinDataType;
    private ServiceEnum.EdgeSlope iisSlope;
    private long iislevelA;
    private long iislevelB;
    private long iislevelC;
    private boolean isNoise;
    private int itemPosition;
    private int keyNumMax;
    private long level;
    private MessageAttr levelAttr;
    private long levelB;
    private MessageAttr levelBAttr;
    private long levelC;
    private MessageAttr levelCAttr;
    private MessageAttr levelStepAttr;
    private int linBaud;
    private MessageAttr linBaudRateAttr;
    private int linByte;
    private MessageAttr linByteAttr;
    private int linDataType;
    private int linId;
    private MessageAttr linIdAttr;
    private long linSamplePosition;
    private MessageAttr linSamplePositionAttr;
    private int linesNumber;
    private MessageAttr lowerAttr;
    private long lowerLimit;
    private int messageId;
    private int milstdDataType;
    private MessageAttr milstdLevelAttr;
    private MessageAttr milstdLevelBAttr;
    private ServiceEnum.Trigger_Level_ID milstdTrigger_Level_ID;
    private long milstdlevelA;
    private long milstdlevelB;
    private int nMode;
    private ServiceEnum.EdgeSlope nthSlope;
    private ServiceEnum.OverEvent overEvent;
    private MessageAttr overLevelAttr;
    private MessageAttr overLevelBAttr;
    private ServiceEnum.EdgeSlope overSlope;
    private long overTime;
    private MessageAttr overTimeAttr;
    private ServiceEnum.Trigger_Level_ID overTrigger_Level_ID;
    private long overlevelA;
    private long overlevelB;
    private ServiceEnum.TriggerPattern pattern;
    String patternValue;
    private ServiceEnum.TriggerPulsePolarity polarity;
    private int progress;
    private int progressA;
    private int progressB;
    private int progressC;
    private ServiceEnum.TriggerPulsePolarity pulsePolarity;
    private int rs232BaudRate;
    private MessageAttr rs232BaudRateAttr;
    private long rs232Data;
    private MessageAttr rs232DataAttr;
    private int rtaType;
    private MessageAttr runtLevelAttr;
    private MessageAttr runtLevelBAttr;
    private MessageAttr runtLowerAttr;
    private long runtLowerLimit;
    private ServiceEnum.TriggerPulsePolarity runtPolarity;
    private ServiceEnum.Trigger_Level_ID runtTrigger_Level_ID;
    private long runtUperLimit;
    private MessageAttr runtUpperAttr;
    private long runtlevelA;
    private long runtlevelB;
    private ServiceEnum.SHEvent sHEvent;
    private long samplePoints;
    private MessageAttr samplePointsAttr;
    private final int scaleNum;
    private long setup;
    private boolean setupHold;
    private ServiceEnum.Chan setupHoldChanA;
    private ServiceEnum.Chan setupHoldChanB;
    private MessageAttr setupHoldLevelAttr;
    private MessageAttr setupHoldLevelBAttr;
    private ServiceEnum.TriggerPulsePolarity setupHoldPolarity;
    private ServiceEnum.EdgeSlope setupHoldSlope;
    private long setupHoldlevelA;
    private long setupHoldlevelB;
    private MessageAttr setupTimeAttr;
    private ServiceEnum.EdgeSlope slope;
    private MessageAttr slopeLevelAttr;
    private MessageAttr slopeLevelBAttr;
    private MessageAttr slopeLowerAttr;
    private long slopeLowerLimit;
    private ServiceEnum.Trigger_Level_ID slopeTrigger_Level_ID;
    private long slopeUperLimit;
    private MessageAttr slopeUpperAttr;
    private long slopelevelA;
    private long slopelevelB;
    private ServiceEnum.Chan spiChanA;
    private ServiceEnum.Chan spiChanB;
    private ServiceEnum.Chan spiChanC;
    private int spiDataType;
    private MessageAttr spiLevelAttr;
    private MessageAttr spiLevelBAttr;
    private MessageAttr spiLevelCAttr;
    private ServiceEnum.EdgeSlope spiSlope;
    private long spiTimeOut;
    private MessageAttr spiTimeoutAttr;
    private long spilevelA;
    private long spilevelB;
    private long spilevelC;
    private long timeOut;
    private ServiceEnum.EdgeSlope timeoutSlope;
    private MessageAttr timeoutTimeAttr;
    private ServiceEnum.TriggerMode triggerMode;
    private int triggerType;
    private ServiceEnum.Trigger_1553_Err trigger_1553_Err;
    private ServiceEnum.Trigger_1553_Sync trigger_1553_Sync;
    private ServiceEnum.Trigger_1553_When trigger_1553_When;
    private ServiceEnum.Trigger_Can_Phy trigger_Can_Phy;
    private ServiceEnum.Trigger_Flex_Baud trigger_Flex_Baud;
    private ServiceEnum.Trigger_Flex_Err trigger_Flex_Err;
    private ServiceEnum.Trigger_Flex_Frame trigger_Flex_Frame;
    private ServiceEnum.Trigger_Flex_Phy trigger_Flex_Phy;
    private ServiceEnum.Trigger_Flex_Pos trigger_Flex_Pos;
    private ServiceEnum.Trigger_Flex_Symbol trigger_Flex_Symbol;
    private ServiceEnum.Trigger_Flex_When trigger_Flex_When;
    private ServiceEnum.Trigger_I2C_Spec trigger_I2C_Spec;
    private ServiceEnum.Trigger_I2C_WR trigger_I2C_WR;
    private ServiceEnum.Trigger_I2C_When trigger_I2C_When;
    private ServiceEnum.Trigger_IIS_Ch trigger_IIS_Ch;
    private ServiceEnum.Trigger_IIS_Spec trigger_IIS_Spec;
    private ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp;
    private ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp_Cyc;
    private ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp_ID;
    private ServiceEnum.Trigger_Level_ID trigger_Level_ID;
    private ServiceEnum.Trigger_Lin_Err trigger_Lin_Err;
    private ServiceEnum.Trigger_Lin_Ver trigger_Lin_Ver;
    private ServiceEnum.Trigger_Lin_When trigger_Lin_When;
    private ServiceEnum.Trigger_RS232_Parity trigger_RS232_Parity;
    private ServiceEnum.Trigger_RS232_Stop trigger_RS232_Stop;
    private ServiceEnum.Trigger_RS232_When trigger_RS232_When;
    private ServiceEnum.Trigger_RS232_Width trigger_RS232_Width;
    private ServiceEnum.Trigger_Serv_Can_When trigger_Serv_Can_When;
    private ServiceEnum.Trigger_Spi_CS trigger_Spi_CS;
    public ServiceEnum.Trigger_value_cmp trigger_value_cmp;
    private ServiceEnum.Unit[] unit;
    private int upType;
    private long uperLimit;
    private MessageAttr upperAttr;
    private ServiceEnum.Trigger_Video_Format videoFormat;
    private MessageAttr videoLineNumber;
    private ServiceEnum.TriggerPulsePolarity videoPolarity;
    private ServiceEnum.Trigger_Video_Sync videoSync;
    private int width;
    private MessageAttr widthAttr;

    public int getServiceID(ServiceEnum.TriggerMode triggerMode) {
        return 41;
    }

    public String getTriggerModeDisplay(int i) {
        return i != 0 ? i != 1 ? ExifInterface.LATITUDE_SOUTH : "N" : ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    }

    public TriggerParam(Context context) {
        super(41);
        this.keyNumMax = 0;
        this.scaleNum = 10;
        this.nMode = ServiceEnum.TriggerSweep.Trigger_Sweep_Auto.value1;
        this.progress = 50;
        this.progressA = 50;
        this.progressB = 50;
        this.progressC = 50;
        this.channel = 1;
        this.channelB = 2;
        this.channelC = 3;
        this.setupHold = true;
        this.chan = ServiceEnum.Chan.chan1;
        this.chanB = ServiceEnum.Chan.chan2;
        this.chanC = ServiceEnum.Chan.chan3;
        this.delayChanA = ServiceEnum.Chan.chan1;
        this.delayChanB = ServiceEnum.Chan.chan2;
        this.setupHoldChanA = ServiceEnum.Chan.chan1;
        this.setupHoldChanB = ServiceEnum.Chan.chan1;
        this.iicChanA = ServiceEnum.Chan.chan1;
        this.iicChanB = ServiceEnum.Chan.chan1;
        this.spiChanA = ServiceEnum.Chan.chan1;
        this.spiChanB = ServiceEnum.Chan.chan1;
        this.spiChanC = ServiceEnum.Chan.chan1;
        this.iisChanA = ServiceEnum.Chan.chan1;
        this.iisChanB = ServiceEnum.Chan.chan1;
        this.iisChanC = ServiceEnum.Chan.chan1;
        this.chanScale = 0L;
        this.chanOffset = 0L;
        this.edgeSlope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.slope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.timeoutSlope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.overSlope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.setupHoldSlope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.nthSlope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.spiSlope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.iisSlope = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.edgeSlopeA = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.edgeSlopeB = ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
        this.pulsePolarity = ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
        this.polarity = ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
        this.videoPolarity = ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
        this.runtPolarity = ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
        this.setupHoldPolarity = ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive;
        this.eMoreThan = ServiceEnum.EMoreThan.Trigger_When_Morethan;
        this.overEvent = ServiceEnum.OverEvent.Trigger_over_enter;
        this.trigger_Level_ID = ServiceEnum.Trigger_Level_ID.Trigger_Level_High;
        this.slopeTrigger_Level_ID = ServiceEnum.Trigger_Level_ID.Trigger_Level_High;
        this.runtTrigger_Level_ID = ServiceEnum.Trigger_Level_ID.Trigger_Level_High;
        this.overTrigger_Level_ID = ServiceEnum.Trigger_Level_ID.Trigger_Level_High;
        this.milstdTrigger_Level_ID = ServiceEnum.Trigger_Level_ID.Trigger_Level_High;
        this.pattern = ServiceEnum.TriggerPattern.Trigger_pat_h;
        this.durationPattern = ServiceEnum.TriggerPattern.Trigger_pat_h;
        this.chanPattern = new ServiceEnum.TriggerPattern[]{ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x};
        this.chanDurationPattern = new ServiceEnum.TriggerPattern[]{ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x, ServiceEnum.TriggerPattern.Trigger_pat_x};
        this.sHEvent = ServiceEnum.SHEvent.Trigger_SH_setup;
        this.unit = new ServiceEnum.Unit[]{ServiceEnum.Unit.Unit_W, ServiceEnum.Unit.Unit_A, ServiceEnum.Unit.Unit_A, ServiceEnum.Unit.Unit_U, ServiceEnum.Unit.Unit_U, ServiceEnum.Unit.Unit_V};
        this.trigger_RS232_When = ServiceEnum.Trigger_RS232_When.rs232_when_start;
        this.eBaudRate = ServiceEnum.EBaudRate.BaudRate_9600;
        this.trigger_RS232_Width = ServiceEnum.Trigger_RS232_Width.RS232_Width_8;
        this.trigger_I2C_When = ServiceEnum.Trigger_I2C_When.trig_i2c_start;
        this.byteLength = 1;
        this.i2cDataType = 0;
        this.format = 0;
        this.formatValue1Str = "[bin]XXXXXXXX";
        this.formatBinaryValue1Str = "XXXXXXXX";
        this.formatValue2Str = "[bin]XXXXXXXX";
        this.formatBinaryValue2Str = "XXXXXXXX";
        this.formatValue3DataStr = "[bin]XXXXXXXX";
        this.formatBinaryValue3DataStr = "XXXXXXXX";
        this.formatValue3IdStr = "[bin]XXX XXXXXXXX";
        this.formatBinaryValue3IdStr = "XXX XXXXXXXX";
        this.formatValue4Str = "[bin]XXXXXXXX";
        this.formatBinaryValue4Str = "XXXXXXXX";
        this.formatValue5Str = "[bin]XXXX";
        this.formatBinaryValue5Str = "XXXX";
        this.formatValue5MinStr = "[bin]XXXX";
        this.formatBinaryValue5MinStr = "XXXX";
        this.formatValue5MaxStr = "[bin]XXXX";
        this.formatBinaryValue5MaxStr = "XXXX";
        this.formatValue6Str = "[bin]XXXXXXXX XXXXXXXX";
        this.formatBinaryValue6Str = "XXXXXXXX XXXXXXXX";
        this.formatValue6MaxStr = "[bin]XXXXXXXX XXXXXXXX";
        this.formatBinaryValue6MaxStr = "XXXXXXXX XXXXXXXX";
        this.formatValue6RtaStr = "[bin]XXXXX";
        this.formatBinaryValue6RtaStr = "XXXXX";
        this.formatValue6BitStr = "[bin]XXX XXXXXXXX";
        this.formatBinaryValue6BitStr = "XXX XXXXXXXX";
        this.trigger_Spi_CS = ServiceEnum.Trigger_Spi_CS.trig_spi_cs;
        this.spiDataType = 0;
        this.dataByte = 1;
        this.canDataType = 0;
        this.canIdType = 0;
        this.canIdBits = 11;
        this.trigger_Can_Phy = ServiceEnum.Trigger_Can_Phy.trig_can_h;
        this.trigger_Serv_Can_When = ServiceEnum.Trigger_Serv_Can_When.trig_can_when_sof;
        this.canDataIdType = 0;
        this.eBaudRateCan = ServiceEnum.EBaudRate.BaudRate_125000;
        this.trigger_Flex_Baud = ServiceEnum.Trigger_Flex_Baud.trig_flex_2_5M;
        this.trigger_Flex_Phy = ServiceEnum.Trigger_Flex_Phy.trig_flex_cha;
        this.trigger_Flex_When = ServiceEnum.Trigger_Flex_When.trig_flex_pos;
        this.trigger_Flex_Pos = ServiceEnum.Trigger_Flex_Pos.trig_flex_pos_tss_end;
        this.trigger_Flex_Frame = ServiceEnum.Trigger_Flex_Frame.trig_flex_frame_invalid;
        this.trigger_Flex_Symbol = ServiceEnum.Trigger_Flex_Symbol.trig_flex_symbol_cas_mts;
        this.trigger_Flex_Err = ServiceEnum.Trigger_Flex_Err.trig_flex_err_head_crc;
        this.trigger_IIS_data_cmp_ID = ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_eq;
        this.trigger_IIS_data_cmp_Cyc = ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_eq;
        this.trigger_Lin_Ver = ServiceEnum.Trigger_Lin_Ver.trig_lin_ver_1x;
        this.eBaudRateLin = ServiceEnum.EBaudRate.BaudRate_9600;
        this.trigger_Lin_Err = ServiceEnum.Trigger_Lin_Err.trig_lin_sync_err;
        this.trigger_Lin_When = ServiceEnum.Trigger_Lin_When.trig_lin_sync;
        this.linDataType = 0;
        this.trigger_IIS_Ch = ServiceEnum.Trigger_IIS_Ch.trig_iis_lch;
        this.trigger_IIS_data_cmp = ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_eq;
        this.trigger_IIS_Spec = ServiceEnum.Trigger_IIS_Spec.trig_iis_standard;
        this.width = 4;
        this.allWidth = 4;
        this.iisDataType = 0;
        this.iisMaxDataType = 0;
        this.iisMinDataType = 0;
        this.i2sDataType = 0;
        this.milstdDataType = 0;
        this.downType = 0;
        this.upType = 0;
        this.rtaType = 0;
        this.bitType = 0;
        this.trigger_1553_When = ServiceEnum.Trigger_1553_When.trig_1553_sync;
        this.trigger_1553_Sync = ServiceEnum.Trigger_1553_Sync.trig_1553_sync_data;
        this.trigger_1553_Err = ServiceEnum.Trigger_1553_Err.trig_1553_err_sync;
        this.trigger_value_cmp = ServiceEnum.Trigger_value_cmp.cmp_eq;
        this.enableToSetLevel = true;
        this.holdOffAttr = new MessageAttr();
        this.levelAttr = new MessageAttr();
        this.levelStepAttr = new MessageAttr();
        this.delayLevelAttr = new MessageAttr();
        this.delayLevelBAttr = new MessageAttr();
        this.setupHoldLevelAttr = new MessageAttr();
        this.setupHoldLevelBAttr = new MessageAttr();
        this.iicLevelAttr = new MessageAttr();
        this.iicLevelBAttr = new MessageAttr();
        this.spiLevelAttr = new MessageAttr();
        this.spiLevelBAttr = new MessageAttr();
        this.spiLevelCAttr = new MessageAttr();
        this.iisLevelAttr = new MessageAttr();
        this.iisLevelBAttr = new MessageAttr();
        this.iisLevelCAttr = new MessageAttr();
        this.levelBAttr = new MessageAttr();
        this.levelCAttr = new MessageAttr();
        this.slopeLevelAttr = new MessageAttr();
        this.slopeLevelBAttr = new MessageAttr();
        this.lowerAttr = new MessageAttr();
        this.upperAttr = new MessageAttr();
        this.slopeLowerAttr = new MessageAttr();
        this.slopeUpperAttr = new MessageAttr();
        this.videoLineNumber = new MessageAttr();
        this.durationLowerAttr = new MessageAttr();
        this.durationUpperAttr = new MessageAttr();
        this.timeoutTimeAttr = new MessageAttr();
        this.runtLevelAttr = new MessageAttr();
        this.runtLevelBAttr = new MessageAttr();
        this.runtLowerAttr = new MessageAttr();
        this.runtUpperAttr = new MessageAttr();
        this.overTimeAttr = new MessageAttr();
        this.overLevelAttr = new MessageAttr();
        this.overLevelBAttr = new MessageAttr();
        this.delayLowerAttr = new MessageAttr();
        this.delayUpperAttr = new MessageAttr();
        this.idelTimeAttr = new MessageAttr();
        this.edgeNumberAttr = new MessageAttr();
        this.setupTimeAttr = new MessageAttr();
        this.holdTimeAttr = new MessageAttr();
        this.rs232DataAttr = new MessageAttr();
        this.rs232BaudRateAttr = new MessageAttr();
        this.canBaudRateAttr = new MessageAttr();
        this.canFdBaudRateAttr = new MessageAttr();
        this.canDataByteAttr = new MessageAttr();
        this.linBaudRateAttr = new MessageAttr();
        this.i2cAddressAttr = new MessageAttr();
        this.i2cByteLengthAttr = new MessageAttr();
        this.linByteAttr = new MessageAttr();
        this.linIdAttr = new MessageAttr();
        this.samplePointsAttr = new MessageAttr();
        this.fdSamplePointsAttr = new MessageAttr();
        this.dataBitsAttr = new MessageAttr();
        this.linSamplePositionAttr = new MessageAttr();
        this.compareUperLimitAttr = new MessageAttr();
        this.compareLowerLimitAttr = new MessageAttr();
        this.idUperLimitAttr = new MessageAttr();
        this.idLowerLimitAttr = new MessageAttr();
        this.milstdLevelAttr = new MessageAttr();
        this.milstdLevelBAttr = new MessageAttr();
        this.spiTimeoutAttr = new MessageAttr();
        this.widthAttr = new MessageAttr();
        this.allWidthAttr = new MessageAttr();
        loadStrings(context);
    }

    public void loadStrings(Context context) {
        for (int i = 1; i <= 4; i++) {
            ServiceEnum.Unit unitFromValue1 = ServiceEnum.getUnitFromValue1(API.getInstance().UI_QueryInt32(i + 0, MessageID.MSG_CHAN_UNIT));
            if (unitFromValue1 != null) {
                setUnit(unitFromValue1, i);
            }
        }
    }

    public void setKeyNumMax(int i) {
        this.keyNumMax = i;
        notifyPropertyChanged(452);
    }

    @Bindable
    public int getKeyNumMax() {
        return this.keyNumMax;
    }

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public void setLevel(long j) {
        if (API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SOURCE) == getChan().value1) {
            this.level = j;
            updateProgress();
            notifyPropertyChanged(484);
        }
    }

    @Bindable
    public long getLevel() {
        return this.level;
    }

    public void setDelaylevelA(long j) {
        this.delaylevelA = j;
        updateProgressA();
        notifyPropertyChanged(233);
    }

    public void saveDelayLevelA(long j) {
        setDelaylevelA(j);
        setChan(getDelayChanA());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_DELAY_LEVEL_H, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    @Bindable
    public long getDelaylevelA() {
        return this.delaylevelA;
    }

    public void setDelaylevelB(long j) {
        this.delaylevelB = j;
        updateProgressB();
        notifyPropertyChanged(234);
    }

    public void saveDelayLevelB(long j) {
        setDelaylevelB(j);
        setChan(getDelayChanB());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_DELAY_LEVEL_L, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    @Bindable
    public long getDelaylevelB() {
        return this.delaylevelB;
    }

    public void setSetupHoldlevelA(long j) {
        this.setupHoldlevelA = j;
        updateProgressA();
        notifyPropertyChanged(820);
    }

    public void saveSetupHoldLevelA(long j) {
        setSetupHoldlevelA(j);
        setChan(getSetupHoldChanA());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_SETUP_LEVEL_L, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    @Bindable
    public long getSetupHoldlevelA() {
        return this.setupHoldlevelA;
    }

    public void setSetupHoldlevelB(long j) {
        this.setupHoldlevelB = j;
        updateProgressB();
        notifyPropertyChanged(821);
    }

    public void saveSetupHoldLevelB(long j) {
        setSetupHoldlevelB(j);
        setChan(getSetupHoldChanB());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_SETUP_LEVEL_H, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    @Bindable
    public long getSetupHoldlevelB() {
        return this.setupHoldlevelB;
    }

    public void setIiclevelA(long j) {
        this.iiclevelA = j;
        notifyPropertyChanged(415);
    }

    @Bindable
    public long getIiclevelA() {
        return this.iiclevelA;
    }

    public void saveIicLevelA(long j) {
        setIiclevelA(j);
        setChan(getIicChanA());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_I2C_LEVEL_CLK, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public void setIiclevelB(long j) {
        this.iiclevelB = j;
        notifyPropertyChanged(416);
    }

    @Bindable
    public long getIiclevelB() {
        return this.iiclevelB;
    }

    public void saveIicLevelB(long j) {
        setIiclevelB(j);
        setChan(getIicChanB());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_I2C_LEVEL_DATA, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public void setSpilevelA(long j) {
        this.spilevelA = j;
        notifyPropertyChanged(893);
    }

    @Bindable
    public long getSpilevelA() {
        return this.spilevelA;
    }

    public void saveSpiLevelA(long j) {
        setSpilevelA(j);
        setChan(getSpiChanA());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_CLK, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public void setSpilevelB(long j) {
        this.spilevelB = j;
        notifyPropertyChanged(894);
    }

    @Bindable
    public long getSpilevelB() {
        return this.spilevelB;
    }

    public void saveSpiLevelB(long j) {
        setSpilevelB(j);
        setChan(getSpiChanB());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_DATA, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public void setSpilevelC(long j) {
        this.spilevelC = j;
        notifyPropertyChanged(895);
    }

    @Bindable
    public long getSpilevelC() {
        return this.spilevelC;
    }

    public void saveSpiLevelC(long j) {
        setSpilevelC(j);
        setChan(getSpiChanC());
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_CS, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public void setIislevelA(long j) {
        this.iislevelA = j;
        notifyPropertyChanged(424);
    }

    @Bindable
    public long getIislevelA() {
        return this.iislevelA;
    }

    public void saveIisLevelA(long j) {
        setIislevelA(j);
        setChan(this.iisChanA);
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_CLK, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public void setIislevelB(long j) {
        this.iislevelB = j;
        notifyPropertyChanged(425);
    }

    @Bindable
    public long getIislevelB() {
        return this.iislevelB;
    }

    public void saveIisLevelB(long j) {
        setIislevelB(j);
        setChan(this.iisChanB);
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_CS, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public void setIislevelC(long j) {
        this.iislevelC = j;
        notifyPropertyChanged(426);
    }

    @Bindable
    public long getIislevelC() {
        return this.iislevelC;
    }

    public void saveIisLevelC(long j) {
        setIislevelC(j);
        setChan(this.iisChanC);
        setLevel(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_DATA, j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public void setLevelB(long j) {
        this.levelB = j;
        updateProgressB();
        notifyPropertyChanged(485);
    }

    @Bindable
    public long getLevelB() {
        return this.levelB;
    }

    public void setSlopelevelA(long j) {
        this.slopelevelA = j;
        updateProgressA();
        updateSlopeLevelDifferenceValue();
        notifyPropertyChanged(853);
    }

    @Bindable
    public long getSlopelevelA() {
        return this.slopelevelA;
    }

    public void setSlopelevelB(long j) {
        this.slopelevelB = j;
        updateProgressB();
        updateSlopeLevelDifferenceValue();
        notifyPropertyChanged(854);
    }

    @Bindable
    public long getSlopelevelB() {
        return this.slopelevelB;
    }

    public void setRuntlevelA(long j) {
        this.runtlevelA = j;
        updateProgressA();
        getRuntValue();
        notifyPropertyChanged(765);
    }

    @Bindable
    public long getRuntlevelA() {
        return this.runtlevelA;
    }

    public void setRuntlevelB(long j) {
        this.runtlevelB = j;
        updateProgressB();
        getRuntValue();
        notifyPropertyChanged(766);
    }

    @Bindable
    public long getRuntlevelB() {
        return this.runtlevelB;
    }

    public void setOverlevelA(long j) {
        this.overlevelA = j;
        updateProgressA();
        getOverValue();
        notifyPropertyChanged(582);
    }

    @Bindable
    public long getOverlevelA() {
        return this.overlevelA;
    }

    public void setOverlevelB(long j) {
        this.overlevelB = j;
        updateProgressB();
        getOverValue();
        notifyPropertyChanged(583);
    }

    @Bindable
    public long getOverlevelB() {
        return this.overlevelB;
    }

    public void setMilstdlevelA(long j) {
        this.milstdlevelA = j;
        notifyPropertyChanged(539);
    }

    @Bindable
    public long getMilstdlevelA() {
        return this.milstdlevelA;
    }

    public void setMilstdlevelB(long j) {
        this.milstdlevelB = j;
        notifyPropertyChanged(540);
    }

    @Bindable
    public long getMilstdlevelB() {
        return this.milstdlevelB;
    }

    public void setLevelC(long j) {
        this.levelC = j;
        updateProgressC();
        notifyPropertyChanged(486);
    }

    @Bindable
    public long getLevelC() {
        return this.levelC;
    }

    public void setProgress(int i) {
        this.progress = i;
        notifyPropertyChanged(671);
    }

    @Bindable
    public int getProgress() {
        return this.progress;
    }

    public void setProgressA(int i) {
        this.progressA = i;
        notifyPropertyChanged(672);
    }

    @Bindable
    public int getProgressA() {
        return this.progressA;
    }

    public void setProgressB(int i) {
        this.progressB = i;
        notifyPropertyChanged(673);
    }

    @Bindable
    public int getProgressB() {
        return this.progressB;
    }

    public void setProgressC(int i) {
        this.progressC = i;
        notifyPropertyChanged(674);
    }

    @Bindable
    public long getProgressC() {
        return this.progressC;
    }

    public void setUperLimit(long j) {
        this.uperLimit = j;
        notifyPropertyChanged(995);
    }

    @Bindable
    public long getUperLimit() {
        return this.uperLimit;
    }

    public void setLowerLimit(long j) {
        this.lowerLimit = j;
        notifyPropertyChanged(511);
    }

    @Bindable
    public long getLowerLimit() {
        return this.lowerLimit;
    }

    public void setSlopeUperLimit(long j) {
        this.slopeUperLimit = j;
        notifyPropertyChanged(852);
    }

    @Bindable
    public long getSlopeUperLimit() {
        return this.slopeUperLimit;
    }

    public void setSlopeLowerLimit(long j) {
        this.slopeLowerLimit = j;
        notifyPropertyChanged(849);
    }

    @Bindable
    public long getSlopeLowerLimit() {
        return this.slopeLowerLimit;
    }

    public void setDurationUperLimit(long j) {
        this.durationUperLimit = j;
        notifyPropertyChanged(251);
    }

    @Bindable
    public long getDurationUperLimit() {
        return this.durationUperLimit;
    }

    public void setDurationLowerLimit(long j) {
        this.durationLowerLimit = j;
        notifyPropertyChanged(249);
    }

    @Bindable
    public long getDurationLowerLimit() {
        return this.durationLowerLimit;
    }

    public void setRuntUperLimit(long j) {
        this.runtUperLimit = j;
        notifyPropertyChanged(764);
    }

    @Bindable
    public long getRuntUperLimit() {
        return this.runtUperLimit;
    }

    public void setRuntLowerLimit(long j) {
        this.runtLowerLimit = j;
        notifyPropertyChanged(761);
    }

    @Bindable
    public long getRuntLowerLimit() {
        return this.runtLowerLimit;
    }

    public void setDelayUperLimit(long j) {
        this.delayUperLimit = j;
        notifyPropertyChanged(232);
    }

    @Bindable
    public long getDelayUperLimit() {
        return this.delayUperLimit;
    }

    public void setDelayLowerLimit(long j) {
        this.delayLowerLimit = j;
        notifyPropertyChanged(231);
    }

    @Bindable
    public long getDelayLowerLimit() {
        return this.delayLowerLimit;
    }

    public void setLinesNumber(int i) {
        this.linesNumber = i;
        notifyPropertyChanged(503);
    }

    @Bindable
    public int getLinesNumber() {
        return this.linesNumber;
    }

    public void setTimeOut(long j) {
        this.timeOut = j;
        notifyPropertyChanged(936);
    }

    @Bindable
    public long getTimeOut() {
        return this.timeOut;
    }

    public void setSpiTimeOut(long j) {
        this.spiTimeOut = j;
        notifyPropertyChanged(877);
    }

    @Bindable
    public long getSpiTimeOut() {
        return this.spiTimeOut;
    }

    public void setDataBits(int i) {
        String str;
        String str2;
        this.dataBits = i;
        notifyPropertyChanged(216);
        String replaceAll = getFormatValue2Str().substring(5).replaceAll(" ", "");
        int length = replaceAll.length();
        char[] charArray = replaceAll.toCharArray();
        if (getSpiDataType() == 1) {
            int dataBits = getDataBits() / 4;
            if (length <= dataBits && getDataBits() % 4 > 0) {
                String str3 = "";
                for (int i2 = 0; i2 < (dataBits - length) + 1; i2++) {
                    str3 = "X" + str3;
                }
                str2 = str3 + replaceAll;
            } else if (length < dataBits && getDataBits() % 4 == 0) {
                String str4 = "";
                for (int i3 = 0; i3 < dataBits - length; i3++) {
                    str4 = "X" + str4;
                }
                str2 = str4 + replaceAll;
            } else if (length >= dataBits) {
                if (getDataBits() % 4 == 0) {
                    str = "";
                    for (int i4 = length - dataBits; i4 < length; i4++) {
                        str = str + charArray[i4];
                    }
                } else {
                    str = "";
                    for (int i5 = (length - dataBits) - 1; i5 < length; i5++) {
                        str = str + charArray[i5];
                    }
                }
                str2 = str;
            } else {
                str2 = "";
            }
        } else if (getDataBits() > length) {
            String str5 = "";
            for (int i6 = 0; i6 < getDataBits() - length; i6++) {
                str5 = "X" + str5;
            }
            str2 = str5 + replaceAll;
        } else {
            str = "";
            for (int dataBits2 = length - getDataBits(); dataBits2 < length; dataBits2++) {
                str = str + charArray[dataBits2];
            }
            str2 = str;
        }
        int i7 = getSpiDataType() == 1 ? 2 : 8;
        String stringBuffer = new StringBuffer(str2).reverse().toString();
        String str6 = "";
        for (int i8 = 0; i8 < str2.length(); i8++) {
            if (i8 % i7 == 0 && i8 != 0) {
                str6 = str6 + " ";
            }
            str6 = str6 + stringBuffer.toCharArray()[i8];
        }
        String stringBuffer2 = new StringBuffer(str6).reverse().toString();
        String str7 = getSpiDataType() == 0 ? "[bin]" + stringBuffer2 : "[hex]" + stringBuffer2;
        if (getSpiDataType() == 1) {
            String replaceAll2 = getTriggerBinaryData().replaceAll(" ", "");
            int length2 = replaceAll2.length() % 4;
            if (length2 != 0) {
                StringBuffer stringBuffer3 = new StringBuffer(str7);
                if (replaceAll2.substring(0, length2).contains("X")) {
                    str7 = stringBuffer3.replace(5, 6, "X").toString();
                } else {
                    String substring = replaceAll2.substring(0, length2);
                    if (str7.charAt(5) != 'X' && !substring.equals(Integer.toBinaryString(Integer.parseInt(str7.substring(5, 6), 16)))) {
                        str7 = stringBuffer3.replace(5, 6, Integer.toHexString(Integer.parseInt(substring, 2))).toString();
                    }
                }
            }
        }
        setFormatValue2Str(str7);
    }

    @Bindable
    public int getDataBits() {
        return this.dataBits;
    }

    public void setOverTime(long j) {
        this.overTime = j;
        notifyPropertyChanged(580);
    }

    @Bindable
    public long getOverTime() {
        return this.overTime;
    }

    public void setHoldOff(long j) {
        this.holdOff = j;
        notifyPropertyChanged(377);
    }

    @Bindable
    public long getHoldOff() {
        return this.holdOff;
    }

    public void setNMode(int i) {
        this.nMode = i;
        notifyPropertyChanged(554);
    }

    @Bindable
    public int getNMode() {
        return this.nMode;
    }

    public void setSetup(long j) {
        this.setup = j;
        notifyPropertyChanged(813);
    }

    @Bindable
    public long getSetup() {
        return this.setup;
    }

    public void setHold(long j) {
        this.hold = j;
        notifyPropertyChanged(376);
    }

    @Bindable
    public long getHold() {
        return this.hold;
    }

    public void setSetupHold(boolean z) {
        this.setupHold = z;
        notifyPropertyChanged(815);
    }

    @Bindable
    public boolean getSetupHold() {
        return this.setupHold;
    }

    public void setIdelTime(long j) {
        this.idelTime = j;
        notifyPropertyChanged(411);
    }

    @Bindable
    public long getIdelTime() {
        return this.idelTime;
    }

    public void setEdgeNumber(int i) {
        this.edgeNumber = i;
        notifyPropertyChanged(262);
    }

    @Bindable
    public int getEdgeNumber() {
        return this.edgeNumber;
    }

    @Bindable
    public long getRs232Data() {
        return this.rs232Data;
    }

    public void setRs232Data(long j) {
        this.rs232Data = j;
        notifyPropertyChanged(745);
    }

    public void saveRs232Data(int i) {
        setRs232Data(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RS232_DATA, i);
    }

    public void readRs232Data() {
        setRs232Data(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RS232_DATA));
    }

    @Bindable
    public int getI2cAddress() {
        return this.i2cAddress;
    }

    public void setI2cAddress(int i) {
        this.i2cAddress = i;
        notifyPropertyChanged(386);
    }

    public void saveI2cAddress(int i) {
        setI2cAddress(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_I2C_ADDRESS, i);
    }

    public void readI2cAddress() {
        setI2cAddress(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_ADDRESS));
    }

    public String i2cAddressConvert() {
        return Long.toHexString(getI2cAddress());
    }

    @Bindable
    public int getByteLength() {
        return this.byteLength;
    }

    public void setByteLength(int i) {
        String str;
        this.byteLength = i;
        notifyPropertyChanged(133);
        int i2 = this.i2cDataType == 1 ? 2 : 8;
        String str2 = "";
        String replaceAll = getFormatValue1Str().substring(5).replaceAll(" ", "");
        int length = replaceAll.length() / i2;
        if (length < i) {
            String str3 = "";
            for (int i3 = 0; i3 < (i - length) * i2; i3++) {
                str3 = "X" + str3;
            }
            str = str3 + replaceAll;
        } else {
            str = "";
            for (int i4 = (length - i) * i2; i4 < replaceAll.length(); i4++) {
                str = str + replaceAll.toCharArray()[i4];
            }
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            if (i5 % i2 == 0 && i5 != 0) {
                str2 = str2 + " ";
            }
            str2 = str2 + str.toCharArray()[i5];
        }
        setFormatValue1Str(this.i2cDataType == 0 ? "[bin]" + str2 : "[hex]" + str2);
    }

    public void saveByteLength(int i) {
        setByteLength(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_I2C_BYTELENGTH, i);
    }

    public void readByteLength() {
        setByteLength(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_BYTELENGTH));
    }

    public String rs232DataConvert() {
        return Long.toHexString(getRs232Data());
    }

    public String linIdConvert() {
        return Long.toHexString(getLinId());
    }

    public void setData(long j) {
        this.data = j;
        setFormatValue1Str("");
        notifyPropertyChanged(215);
    }

    @Bindable
    public long getData() {
        return this.data;
    }

    public void setAddress(long j) {
        this.address = j;
        notifyPropertyChanged(37);
    }

    @Bindable
    public long getAddress() {
        return this.address;
    }

    public void setFormat(int i) {
        this.format = i;
        notifyPropertyChanged(334);
    }

    @Bindable
    public int getFormat() {
        return this.format;
    }

    public void setSamplePoints(long j) {
        this.samplePoints = j;
        notifyPropertyChanged(771);
    }

    @Bindable
    public long getSamplePoints() {
        return this.samplePoints;
    }

    @Bindable
    public long getFdSamplePoints() {
        return this.fdSamplePoints;
    }

    public void setFdSamplePoints(long j) {
        this.fdSamplePoints = j;
        notifyPropertyChanged(293);
    }

    public void setDataByte(int i) {
        String str;
        this.dataByte = i;
        notifyPropertyChanged(217);
        int i2 = getCanDataType() == 1 ? 2 : 8;
        String str2 = "";
        String replaceAll = getFormatValue3DataStr().substring(5).replaceAll(" ", "");
        int length = replaceAll.length() / i2;
        if (length < getDataByte()) {
            String str3 = "";
            for (int i3 = 0; i3 < (getDataByte() - length) * i2; i3++) {
                str3 = "X" + str3;
            }
            str = str3 + replaceAll;
        } else {
            String str4 = "";
            for (int dataByte = (length - getDataByte()) * i2; dataByte < replaceAll.length(); dataByte++) {
                str4 = str4 + replaceAll.toCharArray()[dataByte];
            }
            str = str4;
        }
        for (int i4 = 0; i4 < str.length(); i4++) {
            if (i4 % i2 == 0 && i4 != 0) {
                str2 = str2 + " ";
            }
            str2 = str2 + str.toCharArray()[i4];
        }
        setFormatValue3DataStr(getCanDataType() == 0 ? "[bin]" + str2 : "[hex]" + str2);
    }

    @Bindable
    public int getDataByte() {
        return this.dataByte;
    }

    public void saveDataByte(int i) {
        setDataByte(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_DATA_BYTE, i);
    }

    @Bindable
    public int getCanDataType() {
        return this.canDataType;
    }

    public void setCanDataType(int i) {
        this.canDataType = i;
        notifyPropertyChanged(138);
    }

    @Bindable
    public int getCanIdType() {
        return this.canIdType;
    }

    public void setCanIdType(int i) {
        this.canIdType = i;
        notifyPropertyChanged(142);
    }

    @Bindable
    public int getCanIdBits() {
        return this.canIdBits;
    }

    public void setCanIdBits(int i) {
        this.canIdBits = i;
        notifyPropertyChanged(141);
    }

    public void setLinSamplePosition(long j) {
        this.linSamplePosition = j;
        notifyPropertyChanged(494);
    }

    @Bindable
    public long getLinSamplePosition() {
        return this.linSamplePosition;
    }

    public ServiceEnum.Unit getChanUnit(int i) {
        ServiceEnum.Unit unit = ServiceEnum.Unit.Unit_V;
        if (i == ServiceEnum.Chan.acline.value1) {
            return unit;
        }
        if (i == ServiceEnum.Chan.ext.value1) {
            return ServiceEnum.Unit.Unit_V;
        }
        if (i >= ServiceEnum.Chan.d0.value1) {
            return ServiceEnum.Unit.Unit_V;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[this.unit[i].ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    return i2 != 4 ? unit : ServiceEnum.Unit.Unit_U;
                }
                return ServiceEnum.Unit.Unit_A;
            }
            return ServiceEnum.Unit.Unit_V;
        }
        return ServiceEnum.Unit.Unit_W;
    }

    public String getTriggerLevelStr(long j) {
        int UI_QueryInt32;
        ServiceEnum.Unit unit = ServiceEnum.Unit.Unit_V;
        LogUtils.e("UnitFormat.newBuilderout", UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit));
        LogUtils.e("channel", Integer.valueOf(this.channel));
        if (this.channel == ServiceEnum.Chan.acline.value1 || this.channel == ServiceEnum.Chan.ext.value1) {
            LogUtils.e("UnitFormat.newBuilder", UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit));
            return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit);
        } else if (this.channel >= ServiceEnum.Chan.d0.value1) {
            return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit);
        } else {
            if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Delay) {
                UI_QueryInt32 = API.getInstance().UI_QueryInt32(getDelayChanA().value1, MessageID.MSG_CHAN_UNIT);
            } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Setup) {
                UI_QueryInt32 = API.getInstance().UI_QueryInt32(getSetupHoldChanA().value1, MessageID.MSG_CHAN_UNIT);
            } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                UI_QueryInt32 = API.getInstance().UI_QueryInt32(getIicChanA().value1, MessageID.MSG_CHAN_UNIT);
            } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                UI_QueryInt32 = API.getInstance().UI_QueryInt32(getSpiChanA().value1, MessageID.MSG_CHAN_UNIT);
            } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                UI_QueryInt32 = API.getInstance().UI_QueryInt32(getIisChanA().value1, MessageID.MSG_CHAN_UNIT);
            } else {
                UI_QueryInt32 = API.getInstance().UI_QueryInt32(getChan().value1, MessageID.MSG_CHAN_UNIT);
            }
            ServiceEnum.Unit unitFromValue1 = ServiceEnum.getUnitFromValue1(UI_QueryInt32);
            setUnit(unitFromValue1, getChan().value1);
            if (this.delayChanA.value1 >= ServiceEnum.Chan.d0.value1 && this.delayChanA.value1 <= ServiceEnum.Chan.d15.value1) {
                unitFromValue1 = ServiceEnum.Unit.Unit_V;
            }
            if (unitFromValue1 == ServiceEnum.Unit.Unit_none) {
                unitFromValue1 = ServiceEnum.Unit.Unit_V;
            }
            return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unitFromValue1);
        }
    }

    public String getTriggerLevelShowStr(ServiceEnum.Unit unit, ServiceEnum.TriggerMode triggerMode, long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21) {
        int UI_QueryInt32;
        int UI_QueryInt322;
        int UI_QueryInt323;
        int UI_QueryInt324;
        int UI_QueryInt325;
        int UI_QueryInt326;
        int UI_QueryInt327;
        int UI_QueryInt328;
        int UI_QueryInt329;
        int UI_QueryInt3210;
        int UI_QueryInt3211;
        int UI_QueryInt3212;
        if (triggerMode == ServiceEnum.TriggerMode.Trigger_Edge) {
            int readEdgeSource = readEdgeSource();
            ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(readEdgeSource);
            setChannel(readEdgeSource);
            setChan(chanFromValue1);
        }
        ServiceEnum.Unit unit2 = ServiceEnum.Unit.Unit_V;
        if (this.channel == ServiceEnum.Chan.acline.value1 || this.channel == ServiceEnum.Chan.ext.value1 || this.channel >= ServiceEnum.Chan.d0.value1) {
            return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit2);
        }
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[unit.ordinal()];
        if (i == 1) {
            unit2 = ServiceEnum.Unit.Unit_W;
        } else if (i == 2) {
            unit2 = ServiceEnum.Unit.Unit_V;
        } else if (i == 3) {
            unit2 = ServiceEnum.Unit.Unit_A;
        } else if (i == 4) {
            unit2 = ServiceEnum.Unit.Unit_U;
        }
        if (triggerMode == ServiceEnum.TriggerMode.Trigger_Slope) {
            return "Δ" + UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j2 - j3, unit2);
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Runt) {
            return "Δ" + UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j4 - j5, unit2);
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Over) {
            return "Δ" + UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j6 - j7, unit2);
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
            return "Δ" + UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j8 - j9, unit2);
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Delay) {
            if (getChan() == getDelayChanA()) {
                if (getDelayChanA().value1 >= ServiceEnum.Chan.d0.value1 && getDelayChanA().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt3212 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt3212 = API.getInstance().UI_QueryInt32(getDelayChanA().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j10, ServiceEnum.getUnitFromValue1(UI_QueryInt3212));
            } else if (getChan() == getDelayChanB()) {
                if (getDelayChanB().value1 >= ServiceEnum.Chan.d0.value1 && getDelayChanB().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt3211 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt3211 = API.getInstance().UI_QueryInt32(getDelayChanB().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j11, ServiceEnum.getUnitFromValue1(UI_QueryInt3211));
            } else {
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit2);
            }
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Setup) {
            if (getChan() == getSetupHoldChanA()) {
                if (getSetupHoldChanA().value1 >= ServiceEnum.Chan.d0.value1 && getSetupHoldChanA().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt3210 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt3210 = API.getInstance().UI_QueryInt32(getSetupHoldChanA().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j12, ServiceEnum.getUnitFromValue1(UI_QueryInt3210));
            } else if (getChan() == getSetupHoldChanB()) {
                if (getSetupHoldChanB().value1 >= ServiceEnum.Chan.d0.value1 && getSetupHoldChanB().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt329 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt329 = API.getInstance().UI_QueryInt32(getSetupHoldChanB().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j13, ServiceEnum.getUnitFromValue1(UI_QueryInt329));
            } else {
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit2);
            }
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_I2C) {
            if (getChan() == getIicChanA()) {
                if (getIicChanA().value1 >= ServiceEnum.Chan.d0.value1 && getIicChanA().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt328 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt328 = API.getInstance().UI_QueryInt32(getIicChanA().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j14, ServiceEnum.getUnitFromValue1(UI_QueryInt328));
            } else if (getChan() == getIicChanB()) {
                if (getIicChanB().value1 >= ServiceEnum.Chan.d0.value1 && getIicChanB().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt327 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt327 = API.getInstance().UI_QueryInt32(getIicChanB().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j15, ServiceEnum.getUnitFromValue1(UI_QueryInt327));
            } else {
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit2);
            }
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_SPI) {
            if (getChan() == getSpiChanA()) {
                if (getSpiChanA().value1 >= ServiceEnum.Chan.d0.value1 && getSpiChanA().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt326 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt326 = API.getInstance().UI_QueryInt32(getSpiChanA().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j16, ServiceEnum.getUnitFromValue1(UI_QueryInt326));
            } else if (getChan() == getSpiChanB()) {
                if (getSpiChanB().value1 >= ServiceEnum.Chan.d0.value1 && getSpiChanB().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt325 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt325 = API.getInstance().UI_QueryInt32(getSpiChanB().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j17, ServiceEnum.getUnitFromValue1(UI_QueryInt325));
            } else if (getChan() == getSpiChanC()) {
                if (getSpiChanC().value1 >= ServiceEnum.Chan.d0.value1 && getSpiChanC().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt324 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt324 = API.getInstance().UI_QueryInt32(getSpiChanC().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j18, ServiceEnum.getUnitFromValue1(UI_QueryInt324));
            } else {
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit2);
            }
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_I2S) {
            if (getChan() == getIisChanA()) {
                if (getIisChanA().value1 >= ServiceEnum.Chan.d0.value1 && getIisChanA().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt323 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt323 = API.getInstance().UI_QueryInt32(getIisChanA().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j19, ServiceEnum.getUnitFromValue1(UI_QueryInt323));
            } else if (getChan() == getIisChanB()) {
                if (getIisChanB().value1 >= ServiceEnum.Chan.d0.value1 && getIisChanB().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt322 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt322 = API.getInstance().UI_QueryInt32(getIisChanB().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j20, ServiceEnum.getUnitFromValue1(UI_QueryInt322));
            } else if (getChan() == getIisChanC()) {
                if (getIisChanC().value1 >= ServiceEnum.Chan.d0.value1 && getIisChanC().value1 <= ServiceEnum.Chan.d15.value1) {
                    UI_QueryInt32 = ServiceEnum.Unit.Unit_V.value1;
                } else {
                    UI_QueryInt32 = API.getInstance().UI_QueryInt32(getIisChanC().value1, MessageID.MSG_CHAN_UNIT);
                }
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j21, ServiceEnum.getUnitFromValue1(UI_QueryInt32));
            } else {
                return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit2);
            }
        } else {
            if (this.channel != getChan().value1) {
                unit2 = ServiceEnum.getUnitFromValue1(API.getInstance().UI_QueryInt32(getChan().value1, MessageID.MSG_CHAN_UNIT));
            }
            return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit2);
        }
    }

    public String getTriggerLevelBStr(long j) {
        int UI_QueryInt32;
        ServiceEnum.Unit unit = ServiceEnum.Unit.Unit_V;
        if (this.channelB == ServiceEnum.Chan.acline.value1 || this.channelB == ServiceEnum.Chan.ext.value1 || this.channelB >= ServiceEnum.Chan.d0.value1) {
            return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit);
        }
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Delay) {
            UI_QueryInt32 = API.getInstance().UI_QueryInt32(getDelayChanB().value1, MessageID.MSG_CHAN_UNIT);
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Setup) {
            UI_QueryInt32 = API.getInstance().UI_QueryInt32(getSetupHoldChanB().value1, MessageID.MSG_CHAN_UNIT);
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            UI_QueryInt32 = API.getInstance().UI_QueryInt32(getIicChanB().value1, MessageID.MSG_CHAN_UNIT);
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            UI_QueryInt32 = API.getInstance().UI_QueryInt32(getSpiChanB().value1, MessageID.MSG_CHAN_UNIT);
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            UI_QueryInt32 = API.getInstance().UI_QueryInt32(getIisChanB().value1, MessageID.MSG_CHAN_UNIT);
        } else {
            UI_QueryInt32 = API.getInstance().UI_QueryInt32(getChanB().value1, MessageID.MSG_CHAN_UNIT);
        }
        ServiceEnum.Unit unitFromValue1 = ServiceEnum.getUnitFromValue1(UI_QueryInt32);
        setUnit(unitFromValue1, getChanB().value1);
        if (this.delayChanB.value1 >= ServiceEnum.Chan.d0.value1 && this.delayChanB.value1 <= ServiceEnum.Chan.d15.value1) {
            unitFromValue1 = ServiceEnum.Unit.Unit_V;
        }
        return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unitFromValue1);
    }

    public String getTriggerLevelCStr(long j) {
        ServiceEnum.Unit unit = ServiceEnum.Unit.Unit_V;
        if (this.channel == ServiceEnum.Chan.acline.value1) {
            return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(this.level, unit);
        }
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            unit = ServiceEnum.getUnitFromValue1(API.getInstance().UI_QueryInt32(getSpiChanC().value1, MessageID.MSG_CHAN_UNIT));
            setUnit(unit, getSpiChanC().value1);
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            unit = ServiceEnum.getUnitFromValue1(API.getInstance().UI_QueryInt32(getIisChanC().value1, MessageID.MSG_CHAN_UNIT));
            setUnit(unit, getIisChanC().value1);
        }
        return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, unit);
    }

    public void readTriggerMode() {
        setTriggerMode(ServiceEnum.getTriggerModeFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_TYPE)));
    }

    public void readedgeSlope() {
        setEdgeSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_EDGE_WHEN)));
    }

    public void readsourceChan() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SOURCE_LA_EXT_AC)));
    }

    public void readpatternValue() {
        this.patternValue = API.getInstance().UI_QueryStr(41, MessageID.CMD_SCPI_PATTERN_GET_CODE);
        int i = 0;
        for (int i2 = 0; i2 < this.patternValue.length() && i >= 0 && i < this.chanPattern.length; i2 += 2) {
            if (this.patternValue.charAt(i2) == 'L') {
                this.chanPattern[i] = ServiceEnum.TriggerPattern.Trigger_pat_l;
            } else if (this.patternValue.charAt(i2) == 'H') {
                this.chanPattern[i] = ServiceEnum.TriggerPattern.Trigger_pat_h;
            } else if (this.patternValue.charAt(i2) == 'F') {
                this.chanPattern[i] = ServiceEnum.TriggerPattern.Trigger_pat_fall;
            } else if (this.patternValue.charAt(i2) == 'R') {
                this.chanPattern[i] = ServiceEnum.TriggerPattern.Trigger_pat_rise;
            } else {
                this.chanPattern[i] = ServiceEnum.TriggerPattern.Trigger_pat_x;
            }
            i++;
        }
        setChanPattern(this.chanPattern);
    }

    public void readdurationPatternValue() {
        this.durationPatternValue = API.getInstance().UI_QueryStr(41, MessageID.CMD_SCPI_DURATION_GET_CODE);
        int i = 0;
        for (int i2 = 0; i2 < this.durationPatternValue.length() && i >= 0 && i < this.chanDurationPattern.length; i2 += 2) {
            if (this.durationPatternValue.charAt(i2) == 'L') {
                this.chanDurationPattern[i] = ServiceEnum.TriggerPattern.Trigger_pat_l;
            } else if (this.durationPatternValue.charAt(i2) == 'H') {
                this.chanDurationPattern[i] = ServiceEnum.TriggerPattern.Trigger_pat_h;
            } else {
                this.chanDurationPattern[i] = ServiceEnum.TriggerPattern.Trigger_pat_x;
            }
            i++;
        }
        setChanDurationPattern(this.chanDurationPattern);
    }

    public void readSpiClkSource() {
        setSpiChanA(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_SCL)));
    }

    public void readSpiMisoSource() {
        setSpiChanB(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_SDA)));
    }

    public void readSpiCsSource() {
        setSpiChanC(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_CS)));
    }

    public void readFlexIdMax() {
        API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MAX);
    }

    public void readFlexIdMin() {
        API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MIN);
    }

    public void readI2CCodeString() {
        String UI_QueryStr;
        int length = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_I2C_CODE_STRING).length();
        String str = "";
        int i = 0;
        while (i < length) {
            str = str + UI_QueryStr.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue1Str("[bin]" + str);
    }

    public void readLinCodeString() {
        String UI_QueryStr;
        int length = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_LIN_CODE_STRING).length();
        String str = "";
        int i = 0;
        while (i < length) {
            str = str + UI_QueryStr.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue4Str("[bin]" + str);
    }

    public void readSpiCodeString() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_SPI_CODE_STRING);
        String sb = new StringBuilder(UI_QueryStr).reverse().toString();
        int length = UI_QueryStr.length();
        String str = "";
        int i = 0;
        while (i < length) {
            str = str + sb.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue2Str("[bin]" + new StringBuilder(str).reverse().toString().trim());
    }

    public void readCanDataString() {
        String UI_QueryStr;
        int length = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_CAN_DATA_CODE_STRING).length();
        String str = "";
        int i = 0;
        while (i < length) {
            str = str + UI_QueryStr.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue3DataStr("[bin]" + str);
    }

    public void readCanIdString() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_CAN_ID_CODE_STRING);
        String sb = new StringBuilder(UI_QueryStr).reverse().toString();
        int length = UI_QueryStr.length();
        String str = "";
        int i = 0;
        while (i < length) {
            str = str + sb.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue3IdStr("[bin]" + new StringBuilder(str).reverse().toString().trim());
    }

    public void readI2sMaxString() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_I2S_MAX_STRING);
        int i = 0;
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, 0);
        String sb = new StringBuilder(UI_QueryStr).reverse().toString();
        int length = UI_QueryStr.length();
        String str = "";
        while (i < length) {
            str = str + sb.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue5MaxStr("[bin]" + new StringBuilder(str).reverse().toString().trim());
    }

    public void readI2sMinString() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_I2S_MIN_STRING);
        int i = 0;
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, 0);
        String sb = new StringBuilder(UI_QueryStr).reverse().toString();
        int length = UI_QueryStr.length();
        String str = "";
        while (i < length) {
            str = str + sb.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        String trim = new StringBuilder(str).reverse().toString().trim();
        setFormatValue5MinStr("[bin]" + trim);
        setFormatValue5Str("[bin]" + trim);
    }

    public void readMaxString() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_1553_MAX_STRING);
        int i = 0;
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, 0);
        int length = UI_QueryStr.length();
        String str = "";
        while (i < length) {
            str = str + UI_QueryStr.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue6MaxStr("[bin]" + str);
    }

    public void readMinString() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_1553_MIN_STRING);
        int i = 0;
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, 0);
        int length = UI_QueryStr.length();
        String str = "";
        while (i < length) {
            str = str + UI_QueryStr.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue6Str("[bin]" + str);
    }

    public void readRtaString() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_1553_RTA_STRING);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_RTA, 0);
        setFormatValue6RtaStr("[bin]" + UI_QueryStr);
    }

    public void readBitString() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_1553_BIT_STRING);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_RTA_11, 0);
        String sb = new StringBuilder(UI_QueryStr).insert(3, " ").toString();
        setFormatValue6BitStr("[bin]" + sb);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readTriggerMode();
        readedgeSlope();
        readEdgeCoupling();
        readsourceChan();
        readPulsePolarity();
        readSlopePolarity();
        readVideoPolarity();
        readSpiClkSource();
        readSpiMisoSource();
        readSpiCsSource();
        this.nMode = API.getInstance().UI_QueryInt32(getServiceId(), MessageID.MSG_TRIGGER_SWEEP);
        this.holdOff = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_TRIGGER_HOLDOFF);
        this.isNoise = API.getInstance().UI_QueryBool(getServiceId(), MessageID.MSG_TRIGGER_NOISE);
        this.channel = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_EDGE_SOURCE);
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
        this.level = UI_QueryInt64;
        this.levelB = UI_QueryInt64;
        this.levelC = UI_QueryInt64;
        this.delaylevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_DELAY_LEVEL_H);
        this.delaylevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_DELAY_LEVEL_L);
        this.setupHoldlevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SETUP_LEVEL_H);
        this.setupHoldlevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SETUP_LEVEL_L);
        this.iiclevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2C_LEVEL_CLK);
        this.iiclevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2C_LEVEL_DATA);
        this.spilevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_CLK);
        this.spilevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_DATA);
        this.spilevelC = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_CS);
        this.iislevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_CLK);
        this.iislevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_DATA);
        this.iislevelC = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_CS);
        this.slopelevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_H);
        this.slopelevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_L);
        this.overlevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_H);
        this.overlevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_L);
        this.runtlevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_H);
        this.runtlevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_L);
        this.milstdlevelA = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_H);
        this.milstdlevelB = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_L);
        this.lowerLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_PULSE_LOWER);
        this.uperLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_PULSE_UPPER);
        this.slopeLowerLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SLOPE_LOWER);
        this.slopeUperLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SLOPE_UPPER);
        this.durationLowerLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_DURATION_LOWER);
        this.durationUperLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_DURATION_UPPER);
        this.runtLowerLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_RUNT_LOWER);
        this.runtUperLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_RUNT_UPPER);
        this.delayLowerLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_DELAY_LOWER);
        this.delayUperLimit = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_DELAY_UPPER);
        this.timeOut = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_TIMEOUT_TIME);
        this.linesNumber = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_VIDEO_LINENUM);
        this.overTime = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_OVER_TIME);
        readpatternValue();
        readdurationPatternValue();
        this.idelTime = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_NTH_IDLETIME);
        this.edgeNumber = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_NTH_EDGE);
        this.setup = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SETUP_TIME);
        this.hold = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_HOLD_TIME);
        readRs232Data();
        readRs232BaudRate();
        readI2cAddress();
        readI2CCodeString();
        readByteLength();
        readSpiWhen();
        readSpiSlope();
        readSpiCsMode();
        readSpiDataBits();
        readSpiTimeout();
        readSpiCodeString();
        readclkEdge();
        readCanSamplePoint();
        readCanFdSamplePoint();
        readCanBaud();
        readCanFdBaud();
        readCanDataByte();
        readCanDataString();
        readCanIdString();
        readFlexRayCYCmax();
        readFlexRayCYCmin();
        readFlexIdMax();
        readFlexIdMin();
        readLinSamplePosition();
        readLinBaud();
        readLinDataByte();
        readLinID();
        readLinCodeString();
        readwidth();
        readallWidth();
        readI2sMaxString();
        readI2sMinString();
        readMaxString();
        readMinString();
        readRtaString();
        readBitString();
        checkLevel();
        readLevelStepAttr();
        readHoldOffAttr();
        readLevelAttr();
        readLevelBAttr();
        readLevelCAttr();
        readdelayLevelAttr();
        readdelayLevelBAttr();
        readsetupHoldLevelAttr();
        readsetupHoldLevelBAttr();
        readiicLevelAttr();
        readiicLevelBAttr();
        readspiLevelAttr();
        readspiLevelBAttr();
        readspiLevelCAttr();
        readiisLevelAttr();
        readiisLevelBAttr();
        readiisLevelCAttr();
        readslopeLevelAttr();
        readslopeLevelBAttr();
        readvideoLineNumber();
        readPulseLowerLimitAttr();
        readPulseUpperLimitAttr();
        readSlopeLowerLimitAttr();
        readSlopeUpperLimitAttr();
        readDurationLowerLimitAttr();
        readDurationUpperLimitAttr();
        readTimeoutTimeAttr();
        readRuntLowerLimitAttr();
        readRuntUpperLimitAttr();
        readruntLevelAttr();
        readruntLevelBAttr();
        readOverTimeAttr();
        readoverLevelAttr();
        readoverLevelBAttr();
        readDelayLowerLimitAttr();
        readDelayUpperLimitAttr();
        readNthidelTimeAttr();
        readNthedgeNumberAttr();
        readSetupTimeAttr();
        readHoldTimeAttr();
        readRs232DataAttr();
        readRs232BaudRateAttr();
        readCanBaudRateAttr();
        readCanFdBaudRateAttr();
        readCanDataByteAttr();
        readLinBaudRateAttr();
        readI2cAddressAttr();
        readI2cByteLengthAttr();
        readLinByteAttr();
        readLinIdAttr();
        readdataBitsAttr();
        readSamplePointsAttr();
        readFdSamplePointsAttr();
        readcompareUperLimitAttr();
        readcompareLowerLimitAttr();
        readidUperLimitAttr();
        readidLowerLimitAttr();
        readlinSamplePositionAttr();
        readmilstdLevelAttr();
        readmilstdLevelBAttr();
        readspiTimeOutAttr();
        readwidthAttr();
        readallWidthAttr();
    }

    public MessageAttr getHoldOffAttr() {
        return this.holdOffAttr;
    }

    public MessageAttr getLevelAttr() {
        return this.levelAttr;
    }

    public MessageAttr getLevelStepAttr() {
        return this.levelStepAttr;
    }

    public MessageAttr getdelayLevelAttr() {
        return this.delayLevelAttr;
    }

    public MessageAttr getdelayLevelBAttr() {
        return this.delayLevelBAttr;
    }

    public MessageAttr getsetupHoldLevelAttr() {
        return this.setupHoldLevelAttr;
    }

    public MessageAttr getsetupHoldLevelBAttr() {
        return this.setupHoldLevelBAttr;
    }

    public MessageAttr getiicLevelAttr() {
        return this.iicLevelAttr;
    }

    public MessageAttr getiicLevelBAttr() {
        return this.iicLevelBAttr;
    }

    public MessageAttr getspiLevelAttr() {
        return this.spiLevelAttr;
    }

    public MessageAttr getspiLevelBAttr() {
        return this.spiLevelBAttr;
    }

    public MessageAttr getspiLevelCAttr() {
        return this.spiLevelCAttr;
    }

    public MessageAttr getiisLevelAttr() {
        return this.iisLevelAttr;
    }

    public MessageAttr getiisLevelBAttr() {
        return this.iisLevelBAttr;
    }

    public MessageAttr getiisLevelCAttr() {
        return this.iisLevelCAttr;
    }

    public MessageAttr getslopeLevelAttr() {
        return this.slopeLevelAttr;
    }

    public MessageAttr getslopeLevelBAttr() {
        return this.slopeLevelBAttr;
    }

    public MessageAttr getLowerAttr() {
        return this.lowerAttr;
    }

    public MessageAttr getUpperAttr() {
        return this.upperAttr;
    }

    public MessageAttr getVideoLineNumberAttr() {
        return this.videoLineNumber;
    }

    public MessageAttr getslopeLowerAttr() {
        return this.slopeLowerAttr;
    }

    public MessageAttr getslopeUpperAttr() {
        return this.slopeUpperAttr;
    }

    public MessageAttr getdurationLowerAttr() {
        return this.durationLowerAttr;
    }

    public MessageAttr getdurationUpperAttr() {
        return this.durationUpperAttr;
    }

    public MessageAttr getTimeoutTimeAttr() {
        return this.timeoutTimeAttr;
    }

    public MessageAttr getruntLowerAttr() {
        return this.runtLowerAttr;
    }

    public MessageAttr getruntUpperAttr() {
        return this.runtUpperAttr;
    }

    public MessageAttr getruntLevelAttr() {
        return this.runtLevelAttr;
    }

    public MessageAttr getruntLevelBAttr() {
        return this.runtLevelBAttr;
    }

    public MessageAttr getOverTimeAttr() {
        return this.overTimeAttr;
    }

    public MessageAttr getoverLevelAttr() {
        return this.overLevelAttr;
    }

    public MessageAttr getoverLevelBAttr() {
        return this.overLevelBAttr;
    }

    public MessageAttr getdelayLowerAttr() {
        return this.delayLowerAttr;
    }

    public MessageAttr getdelayUpperAttr() {
        return this.delayUpperAttr;
    }

    public MessageAttr getNthidelTimeAttr() {
        return this.idelTimeAttr;
    }

    public MessageAttr getNthedgeNumberAttr() {
        return this.edgeNumberAttr;
    }

    public MessageAttr getSetupTimeAttr() {
        return this.setupTimeAttr;
    }

    public MessageAttr getHoldTimeAttr() {
        return this.holdTimeAttr;
    }

    public MessageAttr getRs232DataAttr() {
        return this.rs232DataAttr;
    }

    public MessageAttr getRs232BaudRateAttr() {
        return this.rs232BaudRateAttr;
    }

    public MessageAttr getCanBaudRateAttr() {
        return this.canBaudRateAttr;
    }

    public MessageAttr getCanFdBaudRateAttr() {
        return this.canFdBaudRateAttr;
    }

    public MessageAttr getCanDataByteAttr() {
        return this.canDataByteAttr;
    }

    public MessageAttr getLinBaudRateAttr() {
        return this.linBaudRateAttr;
    }

    public MessageAttr getI2cAddressAttr() {
        return this.i2cAddressAttr;
    }

    public MessageAttr getI2cByteLengthAttr() {
        return this.i2cByteLengthAttr;
    }

    public MessageAttr getLinByteAttr() {
        return this.linByteAttr;
    }

    public MessageAttr getLinIdAttr() {
        return this.linIdAttr;
    }

    public MessageAttr getDataBitsAttr() {
        return this.dataBitsAttr;
    }

    public MessageAttr getSamplePointsAttr() {
        return this.samplePointsAttr;
    }

    public MessageAttr getFdSamplePointsAttr() {
        return this.fdSamplePointsAttr;
    }

    public MessageAttr getcompareUperLimitAttr() {
        return this.compareUperLimitAttr;
    }

    public MessageAttr getcompareLowerLimitAttr() {
        return this.compareLowerLimitAttr;
    }

    public MessageAttr getidUperLimitAttr() {
        return this.idUperLimitAttr;
    }

    public MessageAttr getidLowerLimitAttr() {
        return this.idLowerLimitAttr;
    }

    public MessageAttr getlinSamplePositonsAttr() {
        return this.linSamplePositionAttr;
    }

    public MessageAttr getmilstdLevelAttr() {
        return this.milstdLevelAttr;
    }

    public MessageAttr getmilstdLevelBAttr() {
        return this.milstdLevelBAttr;
    }

    public MessageAttr getspiTimeoutAttr() {
        return this.spiTimeoutAttr;
    }

    public MessageAttr getWidthAttr() {
        return this.widthAttr;
    }

    public MessageAttr getAllWidthAttr() {
        return this.allWidthAttr;
    }

    public void readHoldOffAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_HOLDOFF, this.holdOffAttr);
    }

    public void readLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.levelAttr);
    }

    public void readLevelStepAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL_STEP, this.levelStepAttr);
    }

    public void readLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_LEVEL, this.levelBAttr);
    }

    public void readLevelCAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_LEVEL, this.levelCAttr);
    }

    public void readvideoLineNumber() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_VIDEO_LINENUM, this.videoLineNumber);
    }

    public void readdelayLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_DELAY_LEVEL_H, this.delayLevelAttr);
    }

    public void readdelayLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_DELAY_LEVEL_L, this.delayLevelBAttr);
    }

    public void readsetupHoldLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_SETUP_LEVEL_L, this.setupHoldLevelAttr);
    }

    public void readsetupHoldLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_SETUP_LEVEL_H, this.setupHoldLevelBAttr);
    }

    public void readiicLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_I2C_LEVEL_CLK, this.iicLevelAttr);
    }

    public void readiicLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_I2C_LEVEL_DATA, this.iicLevelBAttr);
    }

    public void readspiLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_SPI_LEVEL_CLK, this.spiLevelAttr);
    }

    public void readspiLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_SPI_LEVEL_DATA, this.spiLevelBAttr);
    }

    public void readspiLevelCAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_SPI_LEVEL_CS, this.spiLevelCAttr);
    }

    public void readiisLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_I2S_LEVEL_CLK, this.iisLevelAttr);
    }

    public void readiisLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_I2S_LEVEL_CS, this.iisLevelBAttr);
    }

    public void readiisLevelCAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_SCPI_I2S_LEVEL_DATA, this.iisLevelCAttr);
    }

    public void readslopeLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.slopeLevelAttr);
    }

    public void readslopeLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.slopeLevelBAttr);
    }

    public void readPulseLowerLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_PULSE_LOWER, this.lowerAttr);
    }

    public void readPulseUpperLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_PULSE_UPPER, this.upperAttr);
    }

    public void readSlopeLowerLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_SLOPE_LOWER, this.slopeLowerAttr);
    }

    public void readSlopeUpperLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_SLOPE_LOWER, this.slopeUpperAttr);
    }

    public void readDurationLowerLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_DURATION_LOWER, this.durationLowerAttr);
    }

    public void readDurationUpperLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_DURATION_UPPER, this.durationUpperAttr);
    }

    public void readTimeoutTimeAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_TIMEOUT_TIME, this.timeoutTimeAttr);
    }

    public void readRuntLowerLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_RUNT_LOWER, this.runtLowerAttr);
    }

    public void readRuntUpperLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_RUNT_UPPER, this.runtUpperAttr);
    }

    public void readruntLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.runtLevelAttr);
    }

    public void readruntLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.runtLevelBAttr);
    }

    public void readOverTimeAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_OVER_TIME, this.overTimeAttr);
    }

    public void readoverLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.overLevelAttr);
    }

    public void readoverLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.overLevelBAttr);
    }

    public void readDelayLowerLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_DELAY_LOWER, this.delayLowerAttr);
    }

    public void readDelayUpperLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_DELAY_UPPER, this.delayUpperAttr);
    }

    public void readNthidelTimeAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_NTH_IDLETIME, this.idelTimeAttr);
    }

    public void readNthedgeNumberAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_NTH_EDGE, this.edgeNumberAttr);
    }

    public void readSetupTimeAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_SETUP_TIME, this.setupTimeAttr);
    }

    public void readHoldTimeAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_HOLD_TIME, this.holdTimeAttr);
    }

    public void readRs232DataAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_RS232_DATA, this.rs232DataAttr);
    }

    public void readRs232BaudRateAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_RS232_BAUDRATE, this.rs232BaudRateAttr);
    }

    public void readCanBaudRateAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_CAN_BAUD, this.canBaudRateAttr);
    }

    public void readCanFdBaudRateAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_CANFD_BAUD, this.canFdBaudRateAttr);
    }

    public void readCanDataByteAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_CAN_DATA_BYTE, this.canDataByteAttr);
    }

    public void readLinBaudRateAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_LIN_BAUD, this.linBaudRateAttr);
    }

    public void readI2cAddressAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_I2C_ADDRESS, this.i2cAddressAttr);
    }

    public void readI2cByteLengthAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_I2C_BYTELENGTH, this.i2cByteLengthAttr);
    }

    public void readLinByteAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_LIN_DATA_BYTE, this.linByteAttr);
    }

    public void readLinIdAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_LIN_ID, this.linIdAttr);
    }

    public void readdataBitsAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_SPI_DATABITS, this.dataBitsAttr);
    }

    public void readSamplePointsAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_CAN_SAMPLE_POINT, this.samplePointsAttr);
    }

    public void readFdSamplePointsAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_CAN_FD_SAMPLE_POINT, this.fdSamplePointsAttr);
    }

    public void readcompareUperLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_MAX, this.compareUperLimitAttr);
    }

    public void readcompareLowerLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_MIN, this.compareLowerLimitAttr);
    }

    public void readidUperLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MAX, this.idUperLimitAttr);
    }

    public void readidLowerLimitAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MIN, this.idLowerLimitAttr);
    }

    public void readlinSamplePositionAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_LIN_SAMPLE_POINT, this.linSamplePositionAttr);
    }

    public void readmilstdLevelAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.milstdLevelAttr);
    }

    public void readmilstdLevelBAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, this.milstdLevelBAttr);
    }

    public void readspiTimeOutAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_SPI_TIMEOUT, this.spiTimeoutAttr);
    }

    public void readwidthAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_IIS_USER_WIDTH, this.widthAttr);
    }

    public void readallWidthAttr() {
        API.getInstance().UI_QueryAttr(41, MessageID.MSG_TRIGGER_IIS_WIDTH, this.allWidthAttr);
    }

    @Bindable
    public int getScaleNum() {
        return getChan() == ServiceEnum.Chan.ext ? 8 : 10;
    }

    @Bindable
    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int i) {
        this.channel = i;
        notifyPropertyChanged(171);
    }

    @Bindable
    public int getChannelB() {
        return this.channelB;
    }

    public void setChannelB(int i) {
        this.channelB = i;
        notifyPropertyChanged(173);
    }

    @Bindable
    public int getChannelC() {
        return this.channelC;
    }

    public void setChannelC(int i) {
        this.channelC = i;
        notifyPropertyChanged(175);
    }

    public void setItemPosition(int i) {
        this.itemPosition = i;
        notifyPropertyChanged(451);
    }

    @Bindable
    public int getItemPosition() {
        return this.itemPosition;
    }

    @Bindable
    public boolean getIsNoise() {
        return this.isNoise;
    }

    public void setIsNoise(boolean z) {
        this.isNoise = z;
        notifyPropertyChanged(448);
    }

    @Bindable
    public ServiceEnum.TriggerMode getTriggerMode() {
        return this.triggerMode;
    }

    // Inform: изменение режима триггера
    public void setTriggerMode(ServiceEnum.TriggerMode triggerMode) {
        this.triggerMode = triggerMode;
        updateChanScaleOffset();
        updateProgress();
        updateProgressA();
        updateProgressB();
        notifyPropertyChanged(945);
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_TYPE), triggerMode);
    }

    @Bindable
    public ServiceEnum.Chan getChan() {
        return this.chan;
    }

    // Inform: изменение канала триггера
    public void setChan(ServiceEnum.Chan chan) {
        this.chan = chan;
        updateChanScaleOffset();
        updateProgress();
        notifyPropertyChanged(152);
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_EDGE_SOURCE), chan);
    }

    public long getChanScale() {
        return this.chanScale;
    }

    public void setChanScale(long j) {
        this.chanScale = j;
    }

    public long getChanOffset() {
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Edge && (getCoupling() == ServiceEnum.Coupling.AC || getCoupling() == ServiceEnum.Coupling.LF)) {
            return 0L;
        }
        return this.chanOffset;
    }

    public void setChanOffset(long j) {
        this.chanOffset = j;
    }

    @Bindable
    public String getFormatValue1Str() {
        return this.formatValue1Str;
    }

    public void setFormatValue1Str(String str) {
        this.formatValue1Str = str;
        notifyPropertyChanged(335);
    }

    @Bindable
    public String getFormatValue2Str() {
        return this.formatValue2Str;
    }

    public void setFormatValue2Str(String str) {
        this.formatValue2Str = str;
        notifyPropertyChanged(336);
    }

    @Bindable
    public String getFormatValue3DataStr() {
        return this.formatValue3DataStr;
    }

    public void setFormatValue3DataStr(String str) {
        this.formatValue3DataStr = str;
        notifyPropertyChanged(337);
    }

    @Bindable
    public String getFormatValue3IdStr() {
        return this.formatValue3IdStr;
    }

    public void setFormatValue3IdStr(String str) {
        this.formatValue3IdStr = str;
        notifyPropertyChanged(338);
    }

    @Bindable
    public String getFormatValue4Str() {
        return this.formatValue4Str;
    }

    public void setFormatValue4Str(String str) {
        this.formatValue4Str = str;
        notifyPropertyChanged(339);
    }

    @Bindable
    public String getFormatValue5Str() {
        return this.formatValue5Str;
    }

    public void setFormatValue5Str(String str) {
        this.formatValue5Str = str;
        notifyPropertyChanged(342);
    }

    @Bindable
    public String getFormatValue5MinStr() {
        return this.formatValue5MinStr;
    }

    public void setFormatValue5MinStr(String str) {
        this.formatValue5MinStr = str;
        notifyPropertyChanged(341);
    }

    @Bindable
    public String getFormatValue5MaxStr() {
        return this.formatValue5MaxStr;
    }

    public void setFormatValue5MaxStr(String str) {
        this.formatValue5MaxStr = str;
        notifyPropertyChanged(340);
    }

    @Bindable
    public String getFormatValue6Str() {
        return this.formatValue6Str;
    }

    public void setFormatValue6Str(String str) {
        this.formatValue6Str = str;
        notifyPropertyChanged(346);
    }

    @Bindable
    public String getFormatValue6MaxStr() {
        return this.formatValue6MaxStr;
    }

    public void setFormatValue6MaxStr(String str) {
        this.formatValue6MaxStr = str;
        notifyPropertyChanged(344);
    }

    @Bindable
    public String getFormatValue6RtaStr() {
        return this.formatValue6RtaStr;
    }

    public void setFormatValue6RtaStr(String str) {
        this.formatValue6RtaStr = str;
        notifyPropertyChanged(345);
    }

    @Bindable
    public String getFormatValue6BitStr() {
        return this.formatValue6BitStr;
    }

    public void setFormatValue6BitStr(String str) {
        this.formatValue6BitStr = str;
        notifyPropertyChanged(343);
    }

    public String getChanValuesDisplay(ServiceEnum.Chan chan) {
        int i = chan.value1;
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        switch (i) {
                            case 9:
                                return "d0";
                            case 10:
                                return "d1";
                            case 11:
                                return "d2";
                            case 12:
                                return "d3";
                            case 13:
                                return "d4";
                            case 14:
                                return "d5";
                            case 15:
                                return "d6";
                            case 16:
                                return "d7";
                            case 17:
                                return "d8";
                            case 18:
                                return "d9";
                            case 19:
                                return "d10";
                            case 20:
                                return "d11";
                            case 21:
                                return "d12";
                            case 22:
                                return "d13";
                            case 23:
                                return "d14";
                            case 24:
                                return "d15";
                            case 25:
                                return "AC";
                            case 26:
                                return ExifInterface.LONGITUDE_EAST;
                            default:
                                return "1";
                        }
                    }
                    return "4";
                }
                return ExifInterface.GPS_MEASUREMENT_3D;
            }
            return ExifInterface.GPS_MEASUREMENT_2D;
        }
        return "1";
    }

    /* renamed from: com.rigol.scope.data.TriggerParam$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit;

        static {
            int[] iArr = new int[ServiceEnum.TriggerMode.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode = iArr;
            try {
                iArr[ServiceEnum.TriggerMode.Trigger_Edge.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Pulse.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Slope.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Video.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Pattern.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Duration.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Timeout.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Runt.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Over.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Delay.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_Setup.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_NEdge.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_RS232.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_I2C.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_SPI.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_CAN.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_FlexRay.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_LIN.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_I2S.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[ServiceEnum.TriggerMode.Trigger_1553.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            int[] iArr2 = new int[ServiceEnum.OverEvent.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent = iArr2;
            try {
                iArr2[ServiceEnum.OverEvent.Trigger_over_enter.ordinal()] = 1;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[ServiceEnum.OverEvent.Trigger_over_exit.ordinal()] = 2;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[ServiceEnum.OverEvent.Trigger_over_time.ordinal()] = 3;
            } catch (NoSuchFieldError unused23) {
            }
            int[] iArr3 = new int[ServiceEnum.TriggerPulsePolarity.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity = iArr3;
            try {
                iArr3[ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.ordinal()] = 1;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity[ServiceEnum.TriggerPulsePolarity.Trigger_pulse_positive.ordinal()] = 2;
            } catch (NoSuchFieldError unused25) {
            }
            int[] iArr4 = new int[ServiceEnum.EdgeSlope.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope = iArr4;
            try {
                iArr4[ServiceEnum.EdgeSlope.Trigger_Edge_Falling.ordinal()] = 1;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[ServiceEnum.EdgeSlope.Trigger_Edge_Any.ordinal()] = 2;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[ServiceEnum.EdgeSlope.Trigger_Edge_Rising.ordinal()] = 3;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[ServiceEnum.EdgeSlope.Trigger_Edge_Alternating.ordinal()] = 4;
            } catch (NoSuchFieldError unused29) {
            }
            int[] iArr5 = new int[ServiceEnum.Unit.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit = iArr5;
            try {
                iArr5[ServiceEnum.Unit.Unit_W.ordinal()] = 1;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_V.ordinal()] = 2;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_A.ordinal()] = 3;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[ServiceEnum.Unit.Unit_U.ordinal()] = 4;
            } catch (NoSuchFieldError unused33) {
            }
        }
    }

// Inform: получение иконки триггера (?)
    public int getTriggerViewDisplay(ServiceEnum.TriggerMode triggerMode, ServiceEnum.TriggerPulsePolarity triggerPulsePolarity, ServiceEnum.TriggerPulsePolarity triggerPulsePolarity2, ServiceEnum.SHEvent sHEvent, ServiceEnum.EdgeSlope edgeSlope, ServiceEnum.EdgeSlope edgeSlope2, ServiceEnum.EdgeSlope edgeSlope3, ServiceEnum.EdgeSlope edgeSlope4, ServiceEnum.OverEvent overEvent, ServiceEnum.EdgeSlope edgeSlope5, ServiceEnum.EdgeSlope edgeSlope6, ServiceEnum.TriggerPulsePolarity triggerPulsePolarity3, ServiceEnum.EdgeSlope edgeSlope7, ServiceEnum.EdgeSlope edgeSlope8) {
        if (triggerMode == null || edgeSlope == null) {
            return R.drawable.ic_trigger_edge_rising;
        }
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerMode[triggerMode.ordinal()]) {
            case 1:
                int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope.ordinal()];
                return i != 1 ? i != 2 ? R.drawable.ic_trigger_edge_rising : R.drawable.ic_trigger_edge_either : R.drawable.ic_trigger_edge_falling;
            case 2:
                return AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity[triggerPulsePolarity3.ordinal()] != 1 ? R.drawable.ic_trigger_pulse_positive : R.drawable.ic_trigger_pulse_negative;
            case 3:
                return AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope2.ordinal()] != 1 ? R.drawable.ic_trigger_slope_rising : R.drawable.ic_trigger_slope_falling;
            case 4:
                return AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity[triggerPulsePolarity.ordinal()] != 1 ? R.drawable.ic_trigger_video_positive : R.drawable.ic_trigger_video_negative;
            case 5:
                return R.drawable.ic_trigger_pattern;
            case 6:
                return R.drawable.ic_trigger_duration;
            case 7:
                int i2 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope3.ordinal()];
                return i2 != 1 ? i2 != 4 ? R.drawable.ic_trigger_timeout_rising : R.drawable.ic_trigger_timeout_either : R.drawable.ic_trigger_timeout_falling;
            case 8:
                return AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity[triggerPulsePolarity2.ordinal()] != 1 ? R.drawable.ic_trigger_runt_positive : R.drawable.ic_trigger_runt_negative;
            case 9:
                int i3 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope4.ordinal()];
                if (i3 == 1) {
                    int i4 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[overEvent.ordinal()];
                    return i4 != 1 ? i4 != 2 ? i4 != 3 ? R.drawable.ic_trigger_edge_rising : R.drawable.ic_trigger_over_falling_time : R.drawable.ic_trigger_over_falling_exit : R.drawable.ic_trigger_over_falling_enter;
                } else if (i3 == 4) {
                    int i5 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[overEvent.ordinal()];
                    return i5 != 1 ? i5 != 2 ? i5 != 3 ? R.drawable.ic_trigger_edge_rising : R.drawable.ic_trigger_over_either_time : R.drawable.ic_trigger_over_either_exit : R.drawable.ic_trigger_over_either_enter;
                } else {
                    int i6 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[overEvent.ordinal()];
                    return i6 != 1 ? i6 != 2 ? i6 != 3 ? R.drawable.ic_trigger_edge_rising : R.drawable.ic_trigger_over_rising_time : R.drawable.ic_trigger_over_rising_exit : R.drawable.ic_trigger_over_rising_enter;
                }
            case 10:
                return (edgeSlope7 == ServiceEnum.EdgeSlope.Trigger_Edge_Rising && edgeSlope8 == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) ? R.drawable.ic_trigger_delay_rising : (edgeSlope7 == ServiceEnum.EdgeSlope.Trigger_Edge_Rising && edgeSlope8 == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) ? R.drawable.ic_trigger_delay_rising_falling : (edgeSlope7 == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && edgeSlope8 == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) ? R.drawable.ic_trigger_delay_falling_rising : (edgeSlope7 == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && edgeSlope8 == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) ? R.drawable.ic_trigger_delay_falling : R.drawable.ic_trigger_edge_rising;
            case 11:
                return edgeSlope5 == ServiceEnum.EdgeSlope.Trigger_Edge_Rising ? sHEvent == ServiceEnum.SHEvent.Trigger_SH_setup ? R.drawable.ic_trigger_setup_hold_rising_setup : sHEvent == ServiceEnum.SHEvent.Trigger_SH_hold ? R.drawable.ic_trigger_setup_hold_rising_hold : R.drawable.ic_trigger_setup_hold_rising_setup_hold : edgeSlope5 == ServiceEnum.EdgeSlope.Trigger_Edge_Falling ? sHEvent == ServiceEnum.SHEvent.Trigger_SH_setup ? R.drawable.ic_trigger_setup_hold_falling_setup : sHEvent == ServiceEnum.SHEvent.Trigger_SH_hold ? R.drawable.ic_trigger_setup_hold_falling_hold : R.drawable.ic_trigger_setup_hold_falling_setup_hold : R.drawable.ic_trigger_edge_rising;
            case 12:
                return AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope6.ordinal()] != 1 ? R.drawable.ic_trigger_nth_rising : R.drawable.ic_trigger_nth_falling;
            case 13:
                return R.drawable.ic_trigger_rs232;
            case 14:
                return R.drawable.ic_trigger_i2c;
            case 15:
                return R.drawable.ic_trigger_spi;
            case 16:
                return R.drawable.ic_trigger_can;
            case 17:
                return R.drawable.ic_trigger_flex;
            case 18:
                return R.drawable.ic_trigger_lin;
            case 19:
                return R.drawable.ic_trigger_i2s;
            case 20:
                return R.drawable.ic_trigger_1553b;
            default:
                return R.drawable.ic_trigger_edge_rising;
        }
    }

    @Bindable
    public ServiceEnum.Chan getChanB() {
        return this.chanB;
    }

    public void setChanB(ServiceEnum.Chan chan) {
        this.chanB = chan;
        updateChanScaleOffset();
        updateProgressB();
        notifyPropertyChanged(161);
    }

    @Bindable
    public ServiceEnum.Chan getChanC() {
        return this.chanC;
    }

    public void setChanC(ServiceEnum.Chan chan) {
        this.chanC = chan;
        notifyPropertyChanged(162);
    }

    @Bindable
    public ServiceEnum.Chan getDelayChanA() {
        return this.delayChanA;
    }

    public void setDelayChanA(ServiceEnum.Chan chan) {
        this.delayChanA = chan;
        updateChanScaleOffset();
        updateProgressA();
        notifyPropertyChanged(229);
    }

    @Bindable
    public ServiceEnum.Chan getDelayChanB() {
        return this.delayChanB;
    }

    public void setDelayChanB(ServiceEnum.Chan chan) {
        this.delayChanB = chan;
        updateChanScaleOffset();
        updateProgressB();
        notifyPropertyChanged(230);
    }

    @Bindable
    public ServiceEnum.Chan getSetupHoldChanA() {
        return this.setupHoldChanA;
    }

    public void setSetupHoldChanA(ServiceEnum.Chan chan) {
        this.setupHoldChanA = chan;
        updateChanScaleOffset();
        updateProgressA();
        notifyPropertyChanged(816);
    }

    @Bindable
    public ServiceEnum.Chan getSetupHoldChanB() {
        return this.setupHoldChanB;
    }

    public void setSetupHoldChanB(ServiceEnum.Chan chan) {
        this.setupHoldChanB = chan;
        updateChanScaleOffset();
        updateProgressB();
        notifyPropertyChanged(817);
    }

    public void setIicChanA(ServiceEnum.Chan chan) {
        this.iicChanA = chan;
        notifyPropertyChanged(413);
    }

    @Bindable
    public ServiceEnum.Chan getIicChanA() {
        return this.iicChanA;
    }

    @Bindable
    public ServiceEnum.Chan getIicChanB() {
        return this.iicChanB;
    }

    public void setIicChanB(ServiceEnum.Chan chan) {
        this.iicChanB = chan;
        notifyPropertyChanged(414);
    }

    public void setSpiChanA(ServiceEnum.Chan chan) {
        this.spiChanA = chan;
        notifyPropertyChanged(872);
    }

    @Bindable
    public ServiceEnum.Chan getSpiChanA() {
        return this.spiChanA;
    }

    @Bindable
    public ServiceEnum.Chan getSpiChanB() {
        return this.spiChanB;
    }

    public void setSpiChanB(ServiceEnum.Chan chan) {
        this.spiChanB = chan;
        notifyPropertyChanged(873);
    }

    @Bindable
    public ServiceEnum.Chan getSpiChanC() {
        return this.spiChanC;
    }

    public void setSpiChanC(ServiceEnum.Chan chan) {
        this.spiChanC = chan;
        notifyPropertyChanged(874);
    }

    public void setIisChanA(ServiceEnum.Chan chan) {
        this.iisChanA = chan;
        notifyPropertyChanged(417);
    }

    @Bindable
    public ServiceEnum.Chan getIisChanA() {
        return this.iisChanA;
    }

    @Bindable
    public ServiceEnum.Chan getIisChanB() {
        return this.iisChanB;
    }

    public void setIisChanB(ServiceEnum.Chan chan) {
        this.iisChanB = chan;
        notifyPropertyChanged(418);
    }

    @Bindable
    public ServiceEnum.Chan getIisChanC() {
        return this.iisChanC;
    }

    public void setIisChanC(ServiceEnum.Chan chan) {
        this.iisChanC = chan;
        notifyPropertyChanged(419);
    }

    @Bindable
    public ServiceEnum.Coupling getCoupling() {
        return this.coupling;
    }

    public void setCoupling(ServiceEnum.Coupling coupling) {
        this.coupling = coupling;
        notifyPropertyChanged(193);
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_COUPLING), coupling);
    }

    @Bindable
    public ServiceEnum.Trigger_Video_Format getVideoFormat() {
        return this.videoFormat;
    }

    public void setVideoFormat(ServiceEnum.Trigger_Video_Format trigger_Video_Format) {
        this.videoFormat = trigger_Video_Format;
        notifyPropertyChanged(1029);
    }

    @Bindable
    public ServiceEnum.TriggerPattern getPattern() {
        return this.pattern;
    }

    public void setPattern(ServiceEnum.TriggerPattern triggerPattern) {
        this.pattern = triggerPattern;
        if (getChan() == ServiceEnum.Chan.chan1) {
            this.chanPattern[0] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan2) {
            this.chanPattern[1] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan3) {
            this.chanPattern[2] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan4) {
            this.chanPattern[3] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan5) {
            this.chanPattern[4] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan6) {
            this.chanPattern[5] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan7) {
            this.chanPattern[6] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan8) {
            this.chanPattern[7] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d0) {
            this.chanPattern[8] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d1) {
            this.chanPattern[9] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d2) {
            this.chanPattern[10] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d3) {
            this.chanPattern[11] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d4) {
            this.chanPattern[12] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d5) {
            this.chanPattern[13] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d6) {
            this.chanPattern[14] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d7) {
            this.chanPattern[15] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d8) {
            this.chanPattern[16] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d9) {
            this.chanPattern[17] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d10) {
            this.chanPattern[18] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d11) {
            this.chanPattern[19] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d12) {
            this.chanPattern[20] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d13) {
            this.chanPattern[21] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d14) {
            this.chanPattern[22] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.d15) {
            this.chanPattern[23] = triggerPattern;
        }
        notifyPropertyChanged(604);
    }

    @Bindable
    public ServiceEnum.TriggerPattern getDurationPattern() {
        return this.durationPattern;
    }

    public void setDurationPattern(ServiceEnum.TriggerPattern triggerPattern) {
        this.durationPattern = triggerPattern;
        if (getChan() == ServiceEnum.Chan.chan1) {
            this.chanDurationPattern[0] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan2) {
            this.chanDurationPattern[1] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan3) {
            this.chanDurationPattern[2] = triggerPattern;
        } else if (getChan() == ServiceEnum.Chan.chan4) {
            this.chanDurationPattern[3] = triggerPattern;
        }
        notifyPropertyChanged(250);
    }

    @Bindable
    public ServiceEnum.TriggerPattern[] getChanPattern() {
        return this.chanPattern;
    }

    public void setChanPattern(ServiceEnum.TriggerPattern[] triggerPatternArr) {
        this.chanPattern = triggerPatternArr;
        notifyPropertyChanged(166);
    }

    @Bindable
    public ServiceEnum.TriggerPattern[] getChanDurationPattern() {
        return this.chanDurationPattern;
    }

    public void setChanDurationPattern(ServiceEnum.TriggerPattern[] triggerPatternArr) {
        this.chanDurationPattern = triggerPatternArr;
        notifyPropertyChanged(164);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getEdgeSlope() {
        return this.edgeSlope;
    }

    public void setEdgeSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.edgeSlope = edgeSlope;
        notifyPropertyChanged(266);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getSlope() {
        return this.slope;
    }

    public void setSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.slope = edgeSlope;
        notifyPropertyChanged(846);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getTimeoutSlope() {
        return this.timeoutSlope;
    }

    public void setTimeoutSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.timeoutSlope = edgeSlope;
        notifyPropertyChanged(938);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getOverSlope() {
        return this.overSlope;
    }

    public void setOverSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.overSlope = edgeSlope;
        notifyPropertyChanged(579);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getSetupHoldSlope() {
        return this.setupHoldSlope;
    }

    public void setSetupHoldSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.setupHoldSlope = edgeSlope;
        notifyPropertyChanged(819);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getNthSlope() {
        return this.nthSlope;
    }

    public void setNthSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.nthSlope = edgeSlope;
        notifyPropertyChanged(562);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getSpiSlope() {
        return this.spiSlope;
    }

    public void setSpiSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.spiSlope = edgeSlope;
        notifyPropertyChanged(876);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getIisSlope() {
        return this.iisSlope;
    }

    public void setIisSlope(ServiceEnum.EdgeSlope edgeSlope) {
        this.iisSlope = edgeSlope;
        notifyPropertyChanged(423);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getEdgeSlopeA() {
        return this.edgeSlopeA;
    }

    public void setEdgeSlopeA(ServiceEnum.EdgeSlope edgeSlope) {
        this.edgeSlopeA = edgeSlope;
        notifyPropertyChanged(267);
    }

    @Bindable
    public ServiceEnum.EdgeSlope getEdgeSlopeB() {
        return this.edgeSlopeB;
    }

    public void setEdgeSlopeB(ServiceEnum.EdgeSlope edgeSlope) {
        this.edgeSlopeB = edgeSlope;
        notifyPropertyChanged(268);
    }

    @Bindable
    public ServiceEnum.TriggerPulsePolarity getPulsePolarity() {
        return this.pulsePolarity;
    }


    public void setPulsePolarity(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        this.pulsePolarity = triggerPulsePolarity;
        notifyPropertyChanged(680);
    }

    @Bindable
    public ServiceEnum.TriggerPulsePolarity getPolarity() {
        return this.polarity;
    }

    public void setPolarity(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        this.polarity = triggerPulsePolarity;
        notifyPropertyChanged(642);
    }

    @Bindable
    public ServiceEnum.TriggerPulsePolarity getVideoPolarity() {
        return this.videoPolarity;
    }

    public void setVideoPolarity(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        this.videoPolarity = triggerPulsePolarity;
        notifyPropertyChanged(1030);
    }

    @Bindable
    public ServiceEnum.TriggerPulsePolarity getRuntPolarity() {
        return this.runtPolarity;
    }

    public void setRuntPolarity(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        this.runtPolarity = triggerPulsePolarity;
        notifyPropertyChanged(762);
    }

    @Bindable
    public ServiceEnum.TriggerPulsePolarity getSetupHoldPolarity() {
        return this.setupHoldPolarity;
    }

    public void setSetupHoldPolarity(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        this.setupHoldPolarity = triggerPulsePolarity;
        notifyPropertyChanged(818);
    }

    @Bindable
    public ServiceEnum.EMoreThan getEMoreThan() {
        return this.eMoreThan;
    }

    public void setEMoreThan(ServiceEnum.EMoreThan eMoreThan) {
        this.eMoreThan = eMoreThan;
        notifyPropertyChanged(256);
    }

    @Bindable
    public ServiceEnum.Trigger_Video_Sync getVideoSync() {
        return this.videoSync;
    }

    public void setVideoSync(ServiceEnum.Trigger_Video_Sync trigger_Video_Sync) {
        this.videoSync = trigger_Video_Sync;
        notifyPropertyChanged(1031);
    }

    @Bindable
    public ServiceEnum.OverEvent getOverEvent() {
        return this.overEvent;
    }

    public void setOverEvent(ServiceEnum.OverEvent overEvent) {
        this.overEvent = overEvent;
        notifyPropertyChanged(578);
    }

    @Bindable
    public ServiceEnum.Trigger_Level_ID getTrigger_Level_ID() {
        return this.trigger_Level_ID;
    }

    public void setTrigger_Level_ID(ServiceEnum.Trigger_Level_ID trigger_Level_ID) {
        this.trigger_Level_ID = trigger_Level_ID;
        notifyPropertyChanged(967);
    }

    @Bindable
    public ServiceEnum.Trigger_Level_ID getSlopeTrigger_Level_ID() {
        return this.slopeTrigger_Level_ID;
    }

    public void setSlopeTrigger_Level_ID(ServiceEnum.Trigger_Level_ID trigger_Level_ID) {
        this.slopeTrigger_Level_ID = trigger_Level_ID;
        notifyPropertyChanged(851);
    }

    @Bindable
    public ServiceEnum.Trigger_Level_ID getRuntTrigger_Level_ID() {
        return this.runtTrigger_Level_ID;
    }

    public void setRuntTrigger_Level_ID(ServiceEnum.Trigger_Level_ID trigger_Level_ID) {
        this.runtTrigger_Level_ID = trigger_Level_ID;
        notifyPropertyChanged(763);
    }

    @Bindable
    public ServiceEnum.Trigger_Level_ID getOverTrigger_Level_ID() {
        return this.overTrigger_Level_ID;
    }

    public void setOverTrigger_Level_ID(ServiceEnum.Trigger_Level_ID trigger_Level_ID) {
        this.overTrigger_Level_ID = trigger_Level_ID;
        notifyPropertyChanged(581);
    }

    @Bindable
    public ServiceEnum.Trigger_Level_ID getMilstdTrigger_Level_ID() {
        return this.milstdTrigger_Level_ID;
    }

    public void setMilstdTrigger_Level_ID(ServiceEnum.Trigger_Level_ID trigger_Level_ID) {
        this.milstdTrigger_Level_ID = trigger_Level_ID;
        notifyPropertyChanged(538);
    }

    @Bindable
    public ServiceEnum.SHEvent getSHEvent() {
        return this.sHEvent;
    }

    public void setSHEvent(ServiceEnum.SHEvent sHEvent) {
        this.sHEvent = sHEvent;
        notifyPropertyChanged(769);
    }

    @Bindable
    public ServiceEnum.Trigger_RS232_When getTrigger_RS232_When() {
        return this.trigger_RS232_When;
    }

    public void setTrigger_RS232_When(ServiceEnum.Trigger_RS232_When trigger_RS232_When) {
        this.trigger_RS232_When = trigger_RS232_When;
        notifyPropertyChanged(973);
    }

    @Bindable
    public ServiceEnum.EBaudRate getEBaudRate() {
        return this.eBaudRate;
    }

    public void setEBaudRate(ServiceEnum.EBaudRate eBaudRate) {
        this.eBaudRate = eBaudRate;
        notifyPropertyChanged(253);
    }

    @Bindable
    public int getRs232BaudRate() {
        return this.rs232BaudRate;
    }

    public void setRs232BaudRate(int i) {
        this.rs232BaudRate = i;
        notifyPropertyChanged(744);
    }

    public void readRs232BaudRate() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RS232_BAUDRATE);
        this.rs232BaudRate = UI_QueryInt32;
        setEBaudRate(ServiceEnum.getEBaudRateFromValue1(UI_QueryInt32));
    }

    @Bindable
    public ServiceEnum.Trigger_RS232_Width getTrigger_RS232_Width() {
        return this.trigger_RS232_Width;
    }

    public void setTrigger_RS232_Width(ServiceEnum.Trigger_RS232_Width trigger_RS232_Width) {
        this.trigger_RS232_Width = trigger_RS232_Width;
        notifyPropertyChanged(974);
    }

    @Bindable
    public ServiceEnum.Trigger_RS232_Stop getTrigger_RS232_Stop() {
        return this.trigger_RS232_Stop;
    }

    public void setTrigger_RS232_Stop(ServiceEnum.Trigger_RS232_Stop trigger_RS232_Stop) {
        this.trigger_RS232_Stop = trigger_RS232_Stop;
        notifyPropertyChanged(972);
    }

    @Bindable
    public ServiceEnum.Trigger_RS232_Parity getTrigger_RS232_Parity() {
        return this.trigger_RS232_Parity;
    }

    public void setTrigger_RS232_Parity(ServiceEnum.Trigger_RS232_Parity trigger_RS232_Parity) {
        this.trigger_RS232_Parity = trigger_RS232_Parity;
        notifyPropertyChanged(971);
    }

    @Bindable
    public ServiceEnum.Trigger_I2C_When getTrigger_I2C_When() {
        return this.trigger_I2C_When;
    }

    public void setTrigger_I2C_When(ServiceEnum.Trigger_I2C_When trigger_I2C_When) {
        this.trigger_I2C_When = trigger_I2C_When;
        notifyPropertyChanged(961);
    }

    @Bindable
    public ServiceEnum.Trigger_I2C_Spec getTrigger_I2C_Spec() {
        return this.trigger_I2C_Spec;
    }

    public void setTrigger_I2C_Spec(ServiceEnum.Trigger_I2C_Spec trigger_I2C_Spec) {
        this.trigger_I2C_Spec = trigger_I2C_Spec;
        notifyPropertyChanged(959);
    }

    @Bindable
    public ServiceEnum.Trigger_I2C_WR getTrigger_I2C_WR() {
        return this.trigger_I2C_WR;
    }

    public void setTrigger_I2C_WR(ServiceEnum.Trigger_I2C_WR trigger_I2C_WR) {
        this.trigger_I2C_WR = trigger_I2C_WR;
        notifyPropertyChanged(960);
    }

    @Bindable
    public int getI2cDataType() {
        return this.i2cDataType;
    }

    public void setI2cDataType(int i) {
        this.i2cDataType = i;
        notifyPropertyChanged(387);
    }

    @Bindable
    public ServiceEnum.Trigger_Spi_CS getTrigger_Spi_CS() {
        return this.trigger_Spi_CS;
    }

    public void setTrigger_Spi_CS(ServiceEnum.Trigger_Spi_CS trigger_Spi_CS) {
        this.trigger_Spi_CS = trigger_Spi_CS;
        notifyPropertyChanged(976);
    }

    @Bindable
    public int getSpiDataType() {
        return this.spiDataType;
    }

    public void setSpiDataType(int i) {
        this.spiDataType = i;
        notifyPropertyChanged(875);
    }

    @Bindable
    public ServiceEnum.Trigger_Can_Phy getTrigger_Can_Phy() {
        return this.trigger_Can_Phy;
    }

    public void setTrigger_Can_Phy(ServiceEnum.Trigger_Can_Phy trigger_Can_Phy) {
        this.trigger_Can_Phy = trigger_Can_Phy;
        notifyPropertyChanged(951);
    }

    @Bindable
    public ServiceEnum.Trigger_Serv_Can_When getTrigger_Serv_Can_When() {
        return this.trigger_Serv_Can_When;
    }

    public void setTrigger_Serv_Can_When(ServiceEnum.Trigger_Serv_Can_When trigger_Serv_Can_When) {
        this.trigger_Serv_Can_When = trigger_Serv_Can_When;
        notifyPropertyChanged(975);
    }

    @Bindable
    public ServiceEnum.EBaudRate getEBaudRateCan() {
        return this.eBaudRateCan;
    }

    public void setEBaudRateCan(ServiceEnum.EBaudRate eBaudRate) {
        this.eBaudRateCan = eBaudRate;
        notifyPropertyChanged(254);
    }

    @Bindable
    public int getCanBaud() {
        return this.canBaud;
    }

    public void setCanBaud(int i) {
        this.canBaud = i;
        notifyPropertyChanged(136);
    }

    @Bindable
    public int getCanFdBaud() {
        return this.canFdBaud;
    }

    public void setCanFdBaud(int i) {
        this.canFdBaud = i;
        notifyPropertyChanged(140);
    }

    public void saveCanBaud(int i) {
        setCanBaud(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_BAUD, i);
    }

    public void saveCanFdBaud(int i) {
        setCanFdBaud(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CANFD_BAUD, i);
    }

    @Bindable
    public boolean getIdExtended() {
        return this.idExtended;
    }

    public void setIdExtended(boolean z) {
        this.idExtended = z;
        notifyPropertyChanged(408);
        if (z) {
            setCanIdBits(29);
        } else {
            setCanIdBits(11);
        }
        String str = "";
        String replaceAll = getFormatValue3IdStr().substring(5).replaceAll(" ", "");
        int i = 0;
        int i2 = getFormatValue3IdStr().substring(0, 5).equals("[hex]") ? 8 : 29;
        if (getIdExtended() && replaceAll.length() != i2) {
            if (getCanIdType() == 0) {
                String str2 = "";
                for (int i3 = 0; i3 < 18; i3++) {
                    str2 = "X" + str2;
                }
                String str3 = str2 + replaceAll;
                char[] charArray = new StringBuffer(str3).reverse().toString().toCharArray();
                String str4 = "";
                for (int i4 = 0; i4 < str3.length(); i4++) {
                    if (i4 % 8 == 0 && i4 != 0) {
                        str4 = str4 + " ";
                    }
                    str4 = str4 + charArray[i4];
                }
                StringBuffer stringBuffer = new StringBuffer(str4);
                setFormatValue3IdStr("[bin]" + stringBuffer.reverse().toString());
            } else {
                String str5 = "";
                for (int i5 = 0; i5 < 5; i5++) {
                    str5 = "X" + str5;
                }
                String str6 = str5 + replaceAll;
                char[] charArray2 = new StringBuffer(str6).reverse().toString().toCharArray();
                String str7 = "";
                for (int i6 = 0; i6 < str6.length(); i6++) {
                    if (i6 % 2 == 0 && i6 != 0) {
                        str7 = str7 + " ";
                    }
                    str7 = str7 + charArray2[i6];
                }
                StringBuffer stringBuffer2 = new StringBuffer(str7);
                setFormatValue3IdStr("[hex]" + stringBuffer2.reverse().toString());
            }
        }
        if (getIdExtended()) {
            return;
        }
        int length = replaceAll.length();
        if (getCanIdType() != 0) {
            if (length == 3) {
                char[] charArray3 = new StringBuffer(replaceAll).reverse().toString().toCharArray();
                while (i < length) {
                    if (i % 2 == 0 && i != 0) {
                        str = str + " ";
                    }
                    str = str + charArray3[i];
                    i++;
                }
                StringBuffer stringBuffer3 = new StringBuffer(str);
                setFormatValue3IdStr("[hex]" + stringBuffer3.reverse().toString());
                return;
            }
            String substring = replaceAll.substring(5);
            char[] charArray4 = new StringBuffer(substring).reverse().toString().toCharArray();
            while (i < substring.length()) {
                if (i % 2 == 0 && i != 0) {
                    str = str + " ";
                }
                str = str + charArray4[i];
                i++;
            }
            StringBuffer stringBuffer4 = new StringBuffer(str);
            setFormatValue3IdStr("[hex]" + stringBuffer4.reverse().toString());
        } else if (length == 11) {
            char[] charArray5 = new StringBuffer(replaceAll).reverse().toString().toCharArray();
            while (i < length) {
                if (i % 8 == 0 && i != 0) {
                    str = str + " ";
                }
                str = str + charArray5[i];
                i++;
            }
            StringBuffer stringBuffer5 = new StringBuffer(str);
            setFormatValue3IdStr("[bin]" + stringBuffer5.reverse().toString());
        } else {
            try {
                String substring2 = replaceAll.substring(18);
                char[] charArray6 = new StringBuffer(substring2).reverse().toString().toCharArray();
                for (int i7 = 0; i7 < substring2.length(); i7++) {
                    if (i7 % 8 == 0 && i7 != 0) {
                        str = str + " ";
                    }
                    str = str + charArray6[i7];
                }
                StringBuffer stringBuffer6 = new StringBuffer(str);
                setFormatValue3IdStr("[bin]" + stringBuffer6.reverse().toString());
            } catch (Exception e) {
                LogUtils.e(GsonUtils.toJson(e));
            }
        }
    }

    @Bindable
    public boolean getCanDefine() {
        return this.canDefine;
    }

    public void setCanDefine(boolean z) {
        this.canDefine = z;
        if (!z) {
            setKeyNumMax(64);
        } else if (getIdExtended()) {
            setKeyNumMax(29);
        } else {
            setKeyNumMax(11);
        }
        notifyPropertyChanged(139);
    }

    @Bindable
    public boolean isDefine() {
        return this.Define;
    }

    public void setDefine(boolean z) {
        this.Define = z;
        notifyPropertyChanged(225);
    }

    @Bindable
    public long getCompareUperLimit() {
        return this.compareUperLimit;
    }

    public void setCompareUperLimit(long j) {
        this.compareUperLimit = j;
        notifyPropertyChanged(187);
    }

    @Bindable
    public long getCompareLowerLimit() {
        return this.compareLowerLimit;
    }

    public void setCompareLowerLimit(long j) {
        this.compareLowerLimit = j;
        notifyPropertyChanged(186);
    }

    @Bindable
    public long getIdUperLimit() {
        return this.idUperLimit;
    }

    public void setIdUperLimit(long j) {
        this.idUperLimit = j;
        notifyPropertyChanged(410);
    }

    @Bindable
    public long getIdLowerLimit() {
        return this.idLowerLimit;
    }

    public void setIdLowerLimit(long j) {
        this.idLowerLimit = j;
        notifyPropertyChanged(409);
    }

    @Bindable
    public ServiceEnum.Trigger_Flex_Baud getTrigger_Flex_Baud() {
        return this.trigger_Flex_Baud;
    }

    public void setTrigger_Flex_Baud(ServiceEnum.Trigger_Flex_Baud trigger_Flex_Baud) {
        this.trigger_Flex_Baud = trigger_Flex_Baud;
        notifyPropertyChanged(952);
    }

    @Bindable
    public ServiceEnum.Trigger_Flex_Phy getTrigger_Flex_Phy() {
        return this.trigger_Flex_Phy;
    }

    public void setTrigger_Flex_Phy(ServiceEnum.Trigger_Flex_Phy trigger_Flex_Phy) {
        this.trigger_Flex_Phy = trigger_Flex_Phy;
        notifyPropertyChanged(955);
    }

    @Bindable
    public ServiceEnum.Trigger_Flex_When getTrigger_Flex_When() {
        return this.trigger_Flex_When;
    }

    public void setTrigger_Flex_When(ServiceEnum.Trigger_Flex_When trigger_Flex_When) {
        this.trigger_Flex_When = trigger_Flex_When;
        notifyPropertyChanged(958);
    }

    @Bindable
    public ServiceEnum.Trigger_Flex_Pos getTrigger_Flex_Pos() {
        return this.trigger_Flex_Pos;
    }

    public void setTrigger_Flex_Pos(ServiceEnum.Trigger_Flex_Pos trigger_Flex_Pos) {
        this.trigger_Flex_Pos = trigger_Flex_Pos;
        notifyPropertyChanged(956);
    }

    @Bindable
    public ServiceEnum.Trigger_Flex_Frame getTrigger_Flex_Frame() {
        return this.trigger_Flex_Frame;
    }

    public void setTrigger_Flex_Frame(ServiceEnum.Trigger_Flex_Frame trigger_Flex_Frame) {
        this.trigger_Flex_Frame = trigger_Flex_Frame;
        notifyPropertyChanged(954);
    }

    @Bindable
    public ServiceEnum.Trigger_Flex_Symbol getTrigger_Flex_Symbol() {
        return this.trigger_Flex_Symbol;
    }

    public void setTrigger_Flex_Symbol(ServiceEnum.Trigger_Flex_Symbol trigger_Flex_Symbol) {
        this.trigger_Flex_Symbol = trigger_Flex_Symbol;
        notifyPropertyChanged(957);
    }

    @Bindable
    public ServiceEnum.Trigger_Flex_Err getTrigger_Flex_Err() {
        return this.trigger_Flex_Err;
    }

    public void setTrigger_Flex_Err(ServiceEnum.Trigger_Flex_Err trigger_Flex_Err) {
        this.trigger_Flex_Err = trigger_Flex_Err;
        notifyPropertyChanged(953);
    }

    @Bindable
    public ServiceEnum.Trigger_IIS_data_cmp getTrigger_IIS_data_cmp_ID() {
        return this.trigger_IIS_data_cmp_ID;
    }

    public void setTrigger_IIS_data_cmp_ID(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        this.trigger_IIS_data_cmp_ID = trigger_IIS_data_cmp;
        notifyPropertyChanged(966);
    }

    @Bindable
    public ServiceEnum.Trigger_IIS_data_cmp getTrigger_IIS_data_cmp_Cyc() {
        return this.trigger_IIS_data_cmp_Cyc;
    }

    public void setTrigger_IIS_data_cmp_Cyc(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        this.trigger_IIS_data_cmp_Cyc = trigger_IIS_data_cmp;
        notifyPropertyChanged(965);
    }

    @Bindable
    public ServiceEnum.Trigger_Lin_Ver getTrigger_Lin_Ver() {
        return this.trigger_Lin_Ver;
    }

    public void setTrigger_Lin_Ver(ServiceEnum.Trigger_Lin_Ver trigger_Lin_Ver) {
        this.trigger_Lin_Ver = trigger_Lin_Ver;
        notifyPropertyChanged(969);
    }

    @Bindable
    public ServiceEnum.EBaudRate getEBaudRateLin() {
        return this.eBaudRateLin;
    }

    public void setEBaudRateLin(ServiceEnum.EBaudRate eBaudRate) {
        this.eBaudRateLin = eBaudRate;
        notifyPropertyChanged(255);
    }

    @Bindable
    public int getLinByte() {
        return this.linByte;
    }

    public void setLinByte(int i) {
        String str;
        this.linByte = i;
        notifyPropertyChanged(491);
        int i2 = getLinDataType() == 1 ? 2 : 8;
        String str2 = "";
        String replaceAll = getFormatValue4Str().substring(5).replaceAll(" ", "");
        int length = replaceAll.length() / i2;
        if (length < i) {
            String str3 = "";
            for (int i3 = 0; i3 < (i - length) * i2; i3++) {
                str3 = "X" + str3;
            }
            str = str3 + replaceAll;
        } else {
            str = "";
            for (int i4 = (length - i) * i2; i4 < replaceAll.length(); i4++) {
                str = str + replaceAll.toCharArray()[i4];
            }
        }
        for (int i5 = 0; i5 < str.length(); i5++) {
            if (i5 % i2 == 0 && i5 != 0) {
                str2 = str2 + " ";
            }
            str2 = str2 + str.toCharArray()[i5];
        }
        setFormatValue4Str(getLinDataType() == 0 ? "[bin]" + str2 : "[hex]" + str2);
    }

    public void saveLinByte(int i) {
        setLinByte(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LIN_DATA_BYTE, i);
    }

    @Bindable
    public int getLinDataType() {
        return this.linDataType;
    }

    public void setLinDataType(int i) {
        this.linDataType = i;
        notifyPropertyChanged(492);
    }

    @Bindable
    public int getLinId() {
        return this.linId;
    }

    public void setLinId(int i) {
        this.linId = i;
        notifyPropertyChanged(493);
    }

    public void saveLinId(int i) {
        setLinId(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LIN_ID, i);
    }

    @Bindable
    public int getLinBaud() {
        return this.linBaud;
    }

    public void setLinBaud(int i) {
        this.linBaud = i;
        notifyPropertyChanged(490);
    }

    public void saveLinBaud(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LIN_BAUD, i);
        setLinBaud(i);
    }

    @Bindable
    public ServiceEnum.Trigger_Lin_Err getTrigger_Lin_Err() {
        return this.trigger_Lin_Err;
    }

    public void setTrigger_Lin_Err(ServiceEnum.Trigger_Lin_Err trigger_Lin_Err) {
        this.trigger_Lin_Err = trigger_Lin_Err;
        notifyPropertyChanged(968);
    }

    @Bindable
    public ServiceEnum.Trigger_Lin_When getTrigger_Lin_When() {
        return this.trigger_Lin_When;
    }

    public void setTrigger_Lin_When(ServiceEnum.Trigger_Lin_When trigger_Lin_When) {
        this.trigger_Lin_When = trigger_Lin_When;
        notifyPropertyChanged(970);
    }

    @Bindable
    public ServiceEnum.Trigger_IIS_Ch getTrigger_IIS_Ch() {
        return this.trigger_IIS_Ch;
    }

    public void setTrigger_IIS_Ch(ServiceEnum.Trigger_IIS_Ch trigger_IIS_Ch) {
        this.trigger_IIS_Ch = trigger_IIS_Ch;
        notifyPropertyChanged(962);
    }

    @Bindable
    public ServiceEnum.Trigger_IIS_data_cmp getTrigger_IIS_data_cmp() {
        return this.trigger_IIS_data_cmp;
    }

    public void setTrigger_IIS_data_cmp(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        this.trigger_IIS_data_cmp = trigger_IIS_data_cmp;
        notifyPropertyChanged(964);
    }

    @Bindable
    public ServiceEnum.Trigger_IIS_Spec getTrigger_IIS_Spec() {
        return this.trigger_IIS_Spec;
    }

    public void setTrigger_IIS_Spec(ServiceEnum.Trigger_IIS_Spec trigger_IIS_Spec) {
        this.trigger_IIS_Spec = trigger_IIS_Spec;
        notifyPropertyChanged(963);
    }

    @Bindable
    public int getWidth() {
        return this.width;
    }

    public void setWidth(int i) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        this.width = i;
        notifyPropertyChanged(1074);
        String replaceAll = getFormatValue5Str().substring(5).replaceAll(" ", "");
        int length = replaceAll.length();
        char[] charArray = replaceAll.toCharArray();
        if (getIisDataType() == 1) {
            int width = getWidth() / 4;
            if (length <= width && getWidth() % 4 > 0) {
                String str7 = "";
                for (int i2 = 0; i2 < (width - length) + 1; i2++) {
                    str7 = "X" + str7;
                }
                str2 = str7 + replaceAll;
            } else if (length < width && getWidth() % 4 == 0) {
                String str8 = "";
                for (int i3 = 0; i3 < width - length; i3++) {
                    str8 = "X" + str8;
                }
                str2 = str8 + replaceAll;
            } else if (length >= width) {
                if (getWidth() % 4 == 0) {
                    str = "";
                    for (int i4 = length - width; i4 < length; i4++) {
                        str = str + charArray[i4];
                    }
                } else {
                    str = "";
                    for (int i5 = (length - width) - 1; i5 < length; i5++) {
                        str = str + charArray[i5];
                    }
                }
                str2 = str;
            } else {
                str2 = "";
            }
        } else if (getWidth() > length) {
            String str9 = "";
            for (int i6 = 0; i6 < getWidth() - length; i6++) {
                str9 = "X" + str9;
            }
            str2 = str9 + replaceAll;
        } else {
            str = "";
            for (int width2 = length - getWidth(); width2 < length; width2++) {
                str = str + charArray[width2];
            }
            str2 = str;
        }
        int i7 = getIisDataType() == 1 ? 2 : 8;
        String stringBuffer = new StringBuffer(str2).reverse().toString();
        String str10 = "";
        for (int i8 = 0; i8 < str2.length(); i8++) {
            if (i8 % i7 == 0 && i8 != 0) {
                str10 = str10 + " ";
            }
            str10 = str10 + stringBuffer.toCharArray()[i8];
        }
        String stringBuffer2 = new StringBuffer(str10).reverse().toString();
        String str11 = getIisDataType() == 0 ? "[bin]" + stringBuffer2 : "[hex]" + stringBuffer2;
        if (getIisDataType() == 1) {
            String replaceAll2 = getTriggerBinaryData().replaceAll(" ", "");
            int length2 = replaceAll2.length() % 4;
            if (length2 != 0) {
                StringBuffer stringBuffer3 = new StringBuffer(str11);
                if (replaceAll2.substring(0, length2).contains("X")) {
                    str11 = stringBuffer3.replace(5, 6, "X").toString();
                } else {
                    String substring = replaceAll2.substring(0, length2);
                    if (str11.charAt(5) != 'X' && !substring.equals(Integer.toBinaryString(Integer.parseInt(str11.substring(5, 6), 16)))) {
                        str11 = stringBuffer3.replace(5, 6, Integer.toHexString(Integer.parseInt(substring, 2))).toString();
                    }
                }
            }
        }
        setFormatValue5Str(str11);
        String replaceAll3 = getFormatValue5MinStr().substring(5).replaceAll(" ", "");
        int length3 = replaceAll3.length();
        char[] charArray2 = replaceAll3.toCharArray();
        if (getIisMinDataType() == 1) {
            int width3 = getWidth() / 4;
            if (length3 <= width3 && getWidth() % 4 > 0) {
                String str12 = "";
                for (int i9 = 0; i9 < (width3 - length3) + 1; i9++) {
                    str12 = "X" + str12;
                }
                str4 = str12 + replaceAll3;
            } else if (length3 < width3 && getWidth() % 4 == 0) {
                String str13 = "";
                for (int i10 = 0; i10 < width3 - length3; i10++) {
                    str13 = "X" + str13;
                }
                str4 = str13 + replaceAll3;
            } else if (length3 >= width3) {
                if (getWidth() % 4 == 0) {
                    str3 = "";
                    for (int i11 = length3 - width3; i11 < length3; i11++) {
                        str3 = str3 + charArray2[i11];
                    }
                } else {
                    str3 = "";
                    for (int i12 = (length3 - width3) - 1; i12 < length3; i12++) {
                        str3 = str3 + charArray2[i12];
                    }
                }
                str4 = str3;
            } else {
                str4 = "";
            }
        } else if (getWidth() > length3) {
            String str14 = "";
            for (int i13 = 0; i13 < getWidth() - length3; i13++) {
                str14 = "X" + str14;
            }
            str4 = str14 + replaceAll3;
        } else {
            str3 = "";
            for (int width4 = length3 - getWidth(); width4 < length3; width4++) {
                str3 = str3 + charArray2[width4];
            }
            str4 = str3;
        }
        int i14 = getIisMinDataType() == 1 ? 2 : 8;
        String stringBuffer4 = new StringBuffer(str4).reverse().toString();
        String str15 = "";
        for (int i15 = 0; i15 < str4.length(); i15++) {
            if (i15 % i14 == 0 && i15 != 0) {
                str15 = str15 + " ";
            }
            str15 = str15 + stringBuffer4.toCharArray()[i15];
        }
        String stringBuffer5 = new StringBuffer(str15).reverse().toString();
        String str16 = getIisMinDataType() == 0 ? "[bin]" + stringBuffer5 : "[hex]" + stringBuffer5;
        if (getIisMinDataType() == 1) {
            String replaceAll4 = getTriggerBinaryData().replaceAll(" ", "");
            int length4 = replaceAll4.length() % 4;
            if (length4 != 0) {
                StringBuffer stringBuffer6 = new StringBuffer(str16);
                if (replaceAll4.substring(0, length4).contains("X")) {
                    str16 = stringBuffer6.replace(5, 6, "X").toString();
                } else {
                    String substring2 = replaceAll4.substring(0, length4);
                    if (str16.charAt(5) != 'X' && !substring2.equals(Integer.toBinaryString(Integer.parseInt(str16.substring(5, 6), 16)))) {
                        str16 = stringBuffer6.replace(5, 6, Integer.toHexString(Integer.parseInt(substring2, 2))).toString();
                    }
                }
            }
        }
        setFormatValue5MinStr(str16);
        String replaceAll5 = getFormatValue5MaxStr().substring(5).replaceAll(" ", "");
        int length5 = replaceAll5.length();
        char[] charArray3 = replaceAll5.toCharArray();
        if (getIisMaxDataType() == 1) {
            int width5 = getWidth() / 4;
            if (length5 <= width5 && getWidth() % 4 > 0) {
                String str17 = "";
                int i16 = 0;
                for (int i17 = 1; i16 < (width5 - length5) + i17; i17 = 1) {
                    str17 = "X" + str17;
                    i16++;
                }
                str6 = str17 + replaceAll5;
            } else if (length5 < width5 && getWidth() % 4 == 0) {
                String str18 = "";
                for (int i18 = 0; i18 < width5 - length5; i18++) {
                    str18 = "X" + str18;
                }
                str6 = str18 + replaceAll5;
            } else if (length5 >= width5) {
                if (getWidth() % 4 == 0) {
                    str5 = "";
                    for (int i19 = length5 - width5; i19 < length5; i19++) {
                        str5 = str5 + charArray3[i19];
                    }
                } else {
                    str5 = "";
                    for (int i20 = (length5 - width5) - 1; i20 < length5; i20++) {
                        str5 = str5 + charArray3[i20];
                    }
                }
                str6 = str5;
            } else {
                str6 = "";
            }
        } else if (getWidth() > length5) {
            String str19 = "";
            for (int i21 = 0; i21 < getWidth() - length5; i21++) {
                str19 = "X" + str19;
            }
            str6 = str19 + replaceAll5;
        } else {
            str5 = "";
            for (int width6 = length5 - getWidth(); width6 < length5; width6++) {
                str5 = str5 + charArray3[width6];
            }
            str6 = str5;
        }
        int i22 = getIisMaxDataType() == 1 ? 2 : 8;
        String stringBuffer7 = new StringBuffer(str6).reverse().toString();
        String str20 = "";
        for (int i23 = 0; i23 < str6.length(); i23++) {
            if (i23 % i22 == 0 && i23 != 0) {
                str20 = str20 + " ";
            }
            str20 = str20 + stringBuffer7.toCharArray()[i23];
        }
        String stringBuffer8 = new StringBuffer(str20).reverse().toString();
        String str21 = getIisMaxDataType() == 0 ? "[bin]" + stringBuffer8 : "[hex]" + stringBuffer8;
        if (getIisMaxDataType() == 1) {
            String replaceAll6 = getTriggerBinaryData().replaceAll(" ", "");
            int length6 = replaceAll6.length() % 4;
            if (length6 != 0) {
                StringBuffer stringBuffer9 = new StringBuffer(str21);
                if (replaceAll6.substring(0, length6).contains("X")) {
                    str21 = stringBuffer9.replace(5, 6, "X").toString();
                } else {
                    String substring3 = replaceAll6.substring(0, length6);
                    if (!substring3.equals(Integer.toBinaryString(Integer.parseInt(str21.substring(5, 6), 16)))) {
                        str21 = stringBuffer9.replace(5, 6, Integer.toHexString(Integer.parseInt(substring3, 2))).toString();
                    }
                }
            }
        }
        setFormatValue5MaxStr(str21);
    }

    @Bindable
    public int getAllWidth() {
        return this.allWidth;
    }

    public void setAllWidth(int i) {
        this.allWidth = i;
        notifyPropertyChanged(44);
    }

    @Bindable
    public int getIisDataType() {
        return this.iisDataType;
    }

    public void setIisDataType(int i) {
        this.iisDataType = i;
        notifyPropertyChanged(420);
    }

    @Bindable
    public int getIisMaxDataType() {
        return this.iisMaxDataType;
    }

    public void setIisMaxDataType(int i) {
        this.iisMaxDataType = i;
        notifyPropertyChanged(421);
    }

    @Bindable
    public int getIisMinDataType() {
        return this.iisMinDataType;
    }

    public void setIisMinDataType(int i) {
        this.iisMinDataType = i;
        notifyPropertyChanged(422);
    }

    @Bindable
    public ServiceEnum.Trigger_1553_When getTrigger_1553_When() {
        return this.trigger_1553_When;
    }

    public void setTrigger_1553_When(ServiceEnum.Trigger_1553_When trigger_1553_When) {
        this.trigger_1553_When = trigger_1553_When;
        notifyPropertyChanged(950);
    }

    @Bindable
    public ServiceEnum.Trigger_1553_Sync getTrigger_1553_Sync() {
        return this.trigger_1553_Sync;
    }

    public void setTrigger_1553_Sync(ServiceEnum.Trigger_1553_Sync trigger_1553_Sync) {
        this.trigger_1553_Sync = trigger_1553_Sync;
        notifyPropertyChanged(949);
    }

    @Bindable
    public ServiceEnum.Trigger_1553_Err getTrigger_1553_Err() {
        return this.trigger_1553_Err;
    }

    public void setTrigger_1553_Err(ServiceEnum.Trigger_1553_Err trigger_1553_Err) {
        this.trigger_1553_Err = trigger_1553_Err;
        notifyPropertyChanged(948);
    }

    @Bindable
    public ServiceEnum.Trigger_value_cmp getTrigger_value_cmp() {
        return this.trigger_value_cmp;
    }

    public void setTrigger_value_cmp(ServiceEnum.Trigger_value_cmp trigger_value_cmp) {
        this.trigger_value_cmp = trigger_value_cmp;
        notifyPropertyChanged(977);
    }

    @Bindable
    public int getDownType() {
        return this.downType;
    }

    public void setDownType(int i) {
        this.downType = i;
        notifyPropertyChanged(i);
    }

    @Bindable
    public int getUpType() {
        return this.upType;
    }

    public void setUpType(int i) {
        this.upType = i;
        notifyPropertyChanged(991);
    }

    @Bindable
    public int getRtaType() {
        return this.rtaType;
    }

    public void setRtaType(int i) {
        this.rtaType = i;
        notifyPropertyChanged(758);
    }

    @Bindable
    public int getBitType() {
        return this.bitType;
    }

    public void setBitType(int i) {
        this.bitType = i;
        notifyPropertyChanged(90);
    }

    @Bindable
    public ServiceEnum.Unit getUnit() {
        int i = this.channel;
        if (i == ServiceEnum.Chan.acline.value1) {
            return this.unit[0];
        }
        if (this.channel == ServiceEnum.Chan.ext.value1) {
            return ServiceEnum.Unit.Unit_V;
        }
        if (this.channel >= ServiceEnum.Chan.d0.value1) {
            return ServiceEnum.Unit.Unit_V;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Unit[this.unit[i].ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 == 4) {
                        return ServiceEnum.Unit.Unit_U;
                    }
                    return ServiceEnum.Unit.Unit_V;
                }
                return ServiceEnum.Unit.Unit_A;
            }
            return ServiceEnum.Unit.Unit_V;
        }
        return ServiceEnum.Unit.Unit_W;
    }

    public void setUnit(ServiceEnum.Unit unit, int i) {
        int i2 = i == ServiceEnum.Chan.acline.value1 ? 0 : i;
        if (i == ServiceEnum.Chan.ext.value1) {
            i2 = 5;
        }
        int i3 = i < ServiceEnum.Chan.d0.value1 ? i2 : 5;
        this.channel = i;
        this.unit[i3] = unit;
        notifyPropertyChanged(987);
    }

    public Drawable getChanColor(Context context, ServiceEnum.Chan chan) {
        Drawable drawable = ContextUtil.getDrawable(context, (int) R.drawable.bg_rectangle);
        DrawableCompat.setTint(drawable, ColorUtil.getColor(context, chan));
        return drawable;
    }

    public void setChanColor(View view, ServiceEnum.Chan chan) {
        if (chan != null) {
            ((TextView) view).setTextColor(ColorUtil.getColor(view.getContext(), chan));
        }
    }

    public void saveLinesNumber(int i) {
        setLinesNumber(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_VIDEO_LINENUM, i);
    }

    public void saveNthEdgeNumber(int i) {
        setEdgeNumber(i);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_NTH_EDGE, i);
    }

    public boolean ReadWriteDirection(ServiceEnum.Trigger_I2C_When trigger_I2C_When, ServiceEnum.Trigger_I2C_Spec trigger_I2C_Spec) {
        if (trigger_I2C_When != ServiceEnum.Trigger_I2C_When.trig_i2c_addr || trigger_I2C_Spec == ServiceEnum.Trigger_I2C_Spec.trig_i2c_addr8) {
            return trigger_I2C_When == ServiceEnum.Trigger_I2C_When.trig_i2c_addr_data && trigger_I2C_Spec != ServiceEnum.Trigger_I2C_Spec.trig_i2c_addr8;
        }
        return true;
    }

    public boolean symbolIDmin(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        return trigger_IIS_data_cmp != ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_lt;
    }

    public boolean symbolIDmax(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        return trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_lt || trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_in || trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_out;
    }

    public boolean frameIDmin(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        return trigger_IIS_data_cmp != ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_lt;
    }

    public boolean frameIDmax(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        return trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_lt || trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_in || trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_out;
    }

    public boolean Cycmax(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        return trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_lt || trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_out || trigger_IIS_data_cmp == ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_in;
    }

    public boolean Cycmin(ServiceEnum.Trigger_IIS_data_cmp trigger_IIS_data_cmp) {
        return trigger_IIS_data_cmp != ServiceEnum.Trigger_IIS_data_cmp.trig_iis_data_lt;
    }

    public float getfRatio() {
        ServiceEnum.Chan chan = getChan();
        if (getTriggerMode() != ServiceEnum.TriggerMode.Trigger_Delay && getTriggerMode() != ServiceEnum.TriggerMode.Trigger_Setup && getTriggerMode() != ServiceEnum.TriggerMode.Trigger_I2C && getTriggerMode() != ServiceEnum.TriggerMode.Trigger_SPI && getTriggerMode() != ServiceEnum.TriggerMode.Trigger_I2S) {
            chan = ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SOURCE_LA_EXT_AC));
        }
        if (chan == ServiceEnum.Chan.chan1) {
            return API.getInstance().UI_QueryFloat(1, MessageID.MSG_PROBE_RATIO);
        }
        if (chan == ServiceEnum.Chan.chan2) {
            return API.getInstance().UI_QueryFloat(2, MessageID.MSG_PROBE_RATIO);
        }
        if (chan == ServiceEnum.Chan.chan3) {
            return API.getInstance().UI_QueryFloat(3, MessageID.MSG_PROBE_RATIO);
        }
        if (chan == ServiceEnum.Chan.chan4) {
            return API.getInstance().UI_QueryFloat(4, MessageID.MSG_PROBE_RATIO);
        }
        return 1.0f;
    }

    public long floatToLong(float f) {
        if (f < 1.0f) {
            int i = 0;
            while (f < 1.0f) {
                f *= 10.0f;
                i++;
            }
            int i2 = 1;
            for (int i3 = 0; i3 < i; i3++) {
                i2 *= 10;
            }
            return i2 / f;
        }
        return f;
    }

    public void saveLevel(long j) {
        setLevel(j);
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Edge || this.triggerMode == ServiceEnum.TriggerMode.Trigger_Pulse || this.triggerMode == ServiceEnum.TriggerMode.Trigger_Video || this.triggerMode == ServiceEnum.TriggerMode.Trigger_Pattern || this.triggerMode == ServiceEnum.TriggerMode.Trigger_Duration || this.triggerMode == ServiceEnum.TriggerMode.Trigger_Timeout || this.triggerMode == ServiceEnum.TriggerMode.Trigger_NEdge || this.triggerMode == ServiceEnum.TriggerMode.Trigger_RS232 || this.triggerMode == ServiceEnum.TriggerMode.Trigger_CAN || this.triggerMode == ServiceEnum.TriggerMode.Trigger_FlexRay || this.triggerMode == ServiceEnum.TriggerMode.Trigger_LIN) {
            setLevelB(j);
        }
        API.getInstance().UI_PostInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, Long.valueOf(j).longValue());
    }

    public void saveLevelSync(long j) {
        saveLevel(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL, j);
    }

    public long updateSlopeLevelDifferenceValue() {
        return getSlopelevelA() - getSlopelevelB();
    }

    public long getOverValue() {
        return getOverlevelA() - getOverlevelB();
    }

    public long getRuntValue() {
        return getRuntlevelA() - getRuntlevelB();
    }

    public void saveSlopeLevelASync(long j) {
        setLevel(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, j);
        setSlopelevelA(j);
        if (getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High || getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
            API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_H, j);
        } else {
            API.getInstance().UI_PostInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, j);
        }
    }

    public void saveSlopeLevelBSync(long j) {
        setLevelB(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, j);
        setSlopelevelB(j);
        if (getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High || getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
            API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_L, j);
        }
    }

    public void saveRuntLevelASync(long j) {
        setLevel(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, j);
        setRuntlevelA(j);
        if (getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High || getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
            API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_H, j);
        } else {
            API.getInstance().UI_PostInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, j);
        }
    }

    public void saveRuntLevelBSync(long j) {
        setLevelB(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, j);
        setRuntlevelB(j);
        if (getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High || getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
            API.getInstance().UI_PostInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_L, j);
        }
    }

    public void saveOverLevelASync(long j) {
        setLevel(j);
        setOverlevelA(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, j);
        if (getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High || getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
            API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_H, j);
        } else {
            API.getInstance().UI_PostInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, j);
        }
    }

    public void saveOverLevelBSync(long j) {
        setLevelB(j);
        setOverlevelB(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, j);
        if (getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High || getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
            API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_L, j);
        }
    }

    public void saveMilstdLevelASync(long j) {
        setLevel(j);
        setMilstdlevelA(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, j);
        if (getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High || getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
            API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_H, j);
        } else {
            API.getInstance().UI_PostInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL, j);
        }
    }

    public void saveMilstdLevelBSync(long j) {
        setLevelB(j);
        setMilstdlevelB(j);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, j);
        if (getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_High || getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
            API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_L, j);
        }
    }

    public synchronized void saveLevel(long j, int i) {
        if (this.enableToSetLevel) {
            long j2 = this.level + j;
            boolean isCloseToAndOverZero = OffsetUtil.isCloseToAndOverZero(this.level, j2);
            Timber.d("closeToAndOverZero:" + isCloseToAndOverZero + ", enableToSetLevel:" + this.enableToSetLevel, new Object[0]);
            if (isCloseToAndOverZero) {
                j2 = 0;
                this.enableToSetLevel = false;
                ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.-$$Lambda$TriggerParam$uQPUXz0AW1RxdWp-JbQ5jWZF7g0
                    @Override // java.lang.Runnable
                    public final void run() {
                        TriggerParam.this.lambda$saveLevel$0$TriggerParam();
                    }
                }, 550L);
            }
            if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Slope) {
                if (this.slopeTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                    saveSlopeLevelASync(this.slopelevelA + j);
                    setLevelB(this.slopelevelB);
                    syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, this.slopelevelB);
                } else if (this.slopeTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                    saveSlopeLevelBSync(this.slopelevelB + j);
                    setLevel(this.slopelevelA);
                    syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, this.slopelevelA);
                } else if (this.slopeTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    saveSlopeLevelASync(j + this.slopelevelA);
                }
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Runt) {
                if (this.runtTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                    saveRuntLevelASync(this.runtlevelA + j);
                    setLevelB(this.runtlevelB);
                    syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, this.runtlevelB);
                } else if (this.runtTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                    saveRuntLevelBSync(this.runtlevelB + j);
                    setLevel(this.runtlevelA);
                    syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, this.runtlevelA);
                } else if (this.runtTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    saveRuntLevelASync(j + this.runtlevelA);
                }
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Over) {
                if (this.overTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                    saveOverLevelASync(this.overlevelA + j);
                    setLevelB(this.overlevelB);
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_B), Long.valueOf(this.overlevelB));
                } else if (this.overTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                    saveOverLevelBSync(this.overlevelB + j);
                    setLevel(this.overlevelA);
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_A), Long.valueOf(this.overlevelA));
                } else if (this.overTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    saveOverLevelASync(j + this.overlevelA);
                }
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
                if (this.milstdTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_High) {
                    saveMilstdLevelASync(this.milstdlevelA + j);
                    setLevelB(this.milstdlevelB);
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_B), Long.valueOf(this.milstdlevelB));
                } else if (this.milstdTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Low) {
                    saveMilstdLevelBSync(this.milstdlevelB + j);
                    setLevel(this.milstdlevelA);
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_A), Long.valueOf(this.milstdlevelA));
                } else if (this.milstdTrigger_Level_ID == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                    saveMilstdLevelASync(j + this.milstdlevelA);
                }
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Delay) {
                if (this.chan == this.delayChanA) {
                    saveDelayLevelA(this.delaylevelA + j);
                } else if (this.chan == this.delayChanB) {
                    saveDelayLevelB(this.delaylevelB + j);
                } else {
                    saveLevelSync(j2);
                }
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Setup) {
                if (this.chan == this.setupHoldChanA) {
                    saveSetupHoldLevelA(this.setupHoldlevelA + j);
                } else if (this.chan == this.setupHoldChanB) {
                    saveSetupHoldLevelB(this.setupHoldlevelB + j);
                } else {
                    saveLevelSync(j2);
                }
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_I2C) {
                if (this.chan == this.iicChanA) {
                    saveIicLevelA(this.iiclevelA + j);
                } else if (this.chan == this.iicChanB) {
                    saveIicLevelB(this.iiclevelB + j);
                } else {
                    saveLevelSync(j2);
                }
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_SPI) {
                if (this.chan == this.spiChanA) {
                    saveSpiLevelA(this.spilevelA + j);
                    LogUtils.e("triggerParam", "spilevelA");
                } else if (this.chan == this.spiChanB) {
                    saveSpiLevelB(this.spilevelB + j);
                    LogUtils.e("triggerParam", "spilevelB");
                } else if (this.chan == this.spiChanC) {
                    if (this.trigger_Spi_CS == ServiceEnum.Trigger_Spi_CS.trig_spi_cs) {
                        saveSpiLevelC(this.spilevelC + j);
                        LogUtils.e("triggerParam", "spilevelC");
                    }
                } else {
                    saveLevelSync(j2);
                }
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_I2S) {
                if (this.chan == this.iisChanA) {
                    saveIisLevelA(this.iislevelA + j);
                } else if (this.chan == this.iisChanB) {
                    saveIisLevelB(this.iislevelB + j);
                } else if (this.chan == this.iisChanC) {
                    saveIisLevelC(this.iislevelC + j);
                } else {
                    saveLevelSync(j2);
                }
            } else {
                saveLevelSync(j2);
            }
        }
    }

    public /* synthetic */ void lambda$saveLevel$0$TriggerParam() {
        this.enableToSetLevel = true;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setServiceId(41);
        setTimeOut(1000000000L);
        setByteLength(1);
        setDataByte(1);
        setLinByte(1);
        setTriggerMode(ServiceEnum.TriggerMode.Trigger_Edge);
        setFormatValue1Str("[bin]XXXXXXXX");
        this.formatBinaryValue1Str = "XXXXXXXX";
        setI2cDataType(0);
        setFormatValue2Str("[bin]XXXXXXXX");
        this.formatBinaryValue2Str = "XXXXXXXX";
        setSpiDataType(0);
        setFormatValue3DataStr("[bin]XXXXXXXX");
        this.formatBinaryValue3DataStr = "XXXXXXXX";
        setCanDataType(0);
        setFormatValue3IdStr("[bin]XXX XXXXXXXX");
        this.formatBinaryValue3IdStr = "XXX XXXXXXXX";
        setCanIdType(0);
        setFormatValue4Str("[bin]XXXXXXXX");
        this.formatBinaryValue4Str = "XXXXXXXX";
        setLinDataType(0);
        setFormatValue5Str("[bin]XXXX");
        this.formatBinaryValue5Str = "XXXX";
        setIisDataType(0);
        setFormatValue5MinStr("[bin]XXXX");
        this.formatBinaryValue5MinStr = "XXXX";
        setIisMinDataType(0);
        setFormatValue5MaxStr("[bin]XXXX");
        this.formatBinaryValue5MaxStr = "XXXX";
        setIisMaxDataType(0);
        setFormatValue6Str("[bin]XXXXXXXX XXXXXXXX");
        this.formatBinaryValue6Str = "XXXXXXXX XXXXXXXX";
        setDownType(0);
        setFormatValue6MaxStr("[bin]XXXXXXXX XXXXXXXX");
        this.formatBinaryValue6MaxStr = "XXXXXXXX XXXXXXXX";
        setUpType(0);
        setFormatValue6RtaStr("[bin]XXXXX");
        this.formatBinaryValue6RtaStr = "XXXXX";
        setRtaType(0);
        setFormatValue6BitStr("[bin]XXX XXXXXXXX");
        this.formatBinaryValue6BitStr = "XXX XXXXXXXX";
        setBitType(0);
        setChannel(3);
    }

    public void updateProgress() {
        long level = getLevel();
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Delay) {
            level = getDelaylevelA();
        }
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_Delay) {
            this.progress = (int) ((((float) ((level + ((getChanScale() * getScaleNum()) / 2)) + getChanOffset())) / ((float) (getChanScale() * getScaleNum()))) * 100.0f);
        } else {
            ServiceEnum.Chan chan = getChan();
            long UI_QueryInt64 = API.getInstance().UI_QueryInt64(chan.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            this.progress = (int) ((((float) ((level + ((getScaleNum() * UI_QueryInt64) / 2)) + API.getInstance().UI_QueryInt64(chan.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL))) / ((float) (UI_QueryInt64 * getScaleNum()))) * 100.0f);
        }
        int i = this.progress;
        if (i < 0) {
            this.progress = 0;
        } else if (i > 100) {
            this.progress = 100;
        }
        setProgress(this.progress);
    }

    public void updateProgressA() {
        long setupHoldlevelA;
        ServiceEnum.Chan setupHoldChanA;
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Slope) {
            setupHoldlevelA = getSlopelevelA();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Over) {
            setupHoldlevelA = getOverlevelA();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Runt) {
            setupHoldlevelA = getRuntlevelA();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
            setupHoldlevelA = getMilstdlevelA();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Delay) {
            setupHoldlevelA = getDelaylevelA();
        } else {
            setupHoldlevelA = this.triggerMode == ServiceEnum.TriggerMode.Trigger_Setup ? getSetupHoldlevelA() : 0L;
        }
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_Delay && this.triggerMode != ServiceEnum.TriggerMode.Trigger_Setup) {
            this.progressA = (int) ((((float) ((setupHoldlevelA + ((getChanScale() * getScaleNum()) / 2)) + getChanOffset())) / ((float) (getChanScale() * getScaleNum()))) * 100.0f);
        } else {
            ServiceEnum.Chan chan = ServiceEnum.Chan.chan1;
            if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Delay) {
                setupHoldChanA = getDelayChanA();
            } else {
                setupHoldChanA = getSetupHoldChanA();
            }
            long UI_QueryInt64 = API.getInstance().UI_QueryInt64(setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            this.progressA = (int) ((((float) ((setupHoldlevelA + ((getScaleNum() * UI_QueryInt64) / 2)) + API.getInstance().UI_QueryInt64(setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL))) / ((float) (UI_QueryInt64 * getScaleNum()))) * 100.0f);
        }
        int i = this.progressA;
        if (i < 0) {
            this.progressA = 0;
        } else if (i > 100) {
            this.progressA = 100;
        }
        setProgressA(this.progressA);
    }

    public void updateProgressB() {
        long levelB;
        ServiceEnum.Chan setupHoldChanB;
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Slope) {
            levelB = getSlopelevelB();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Over) {
            levelB = getOverlevelB();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Runt) {
            levelB = getRuntlevelB();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
            levelB = getMilstdlevelB();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Delay) {
            levelB = getDelaylevelB();
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Setup) {
            levelB = getSetupHoldlevelB();
        } else {
            levelB = getLevelB();
        }
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_Delay && this.triggerMode != ServiceEnum.TriggerMode.Trigger_Setup) {
            this.progressB = (int) ((((float) ((levelB + ((getChanScale() * getScaleNum()) / 2)) + getChanOffset())) / ((float) (getChanScale() * getScaleNum()))) * 100.0f);
        } else {
            ServiceEnum.Chan chan = ServiceEnum.Chan.chan1;
            if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Delay) {
                setupHoldChanB = getDelayChanB();
            } else {
                setupHoldChanB = getSetupHoldChanB();
            }
            long UI_QueryInt64 = API.getInstance().UI_QueryInt64(setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            this.progressB = (int) ((((float) ((levelB + ((getScaleNum() * UI_QueryInt64) / 2)) + API.getInstance().UI_QueryInt64(setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL))) / ((float) (UI_QueryInt64 * getScaleNum()))) * 100.0f);
        }
        int i = this.progressB;
        if (i < 0) {
            this.progressB = 0;
        } else if (i > 100) {
            this.progressB = 100;
        }
        setProgressB(this.progressB);
    }

    public void updateProgressC() {
        int levelC = (int) ((((float) ((getLevelC() + ((getChanScale() * getScaleNum()) / 2)) + getChanOffset())) / ((float) (getChanScale() * getScaleNum()))) * 100.0f);
        if (levelC < 0) {
            levelC = 0;
        } else if (levelC > 100) {
            levelC = 100;
        }
        setProgressC(levelC);
    }

    public void updateChanScaleOffset() {
        ServiceEnum.Chan chan = getChan();
        if (ServiceEnum.Chan.chan_none == chan) {
            chan = ServiceEnum.Chan.chan1;
        }
        if (chan.value1 <= ServiceEnum.Chan.chan4.value1) {
            setChanScale(API.getInstance().UI_QueryInt64(chan.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL));
            setChanOffset(API.getInstance().UI_QueryInt64(chan.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL));
        } else if (ServiceEnum.Chan.ext == chan) {
            setChanScale(2000000L);
            setChanOffset(0L);
        }
    }

    public void readPulseChan() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_PULSE_SOURCE)));
    }

    public void readPulsePolarity() {
        setPolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_PULSE_POLARITY)));
    }

    public void readPulseLwidth() {
        setLowerLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_PULSE_LOWER));
    }

    public void readPulseUwidth() {
        setUperLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_PULSE_UPPER));
    }

    public void readPulseWhen() {
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_PULSE_WHEN)));
    }

    public void readSlopeChan() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SLOPE_SOURCE)));
    }

    public void readSlopeWhen() {
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SLOPE_WHEN)));
    }

    public void readSlopeLwidth() {
        setSlopeLowerLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SLOPE_LOWER));
    }

    public void readSlopeUwidth() {
        setSlopeUperLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SLOPE_UPPER));
    }

    public void readSlopePolarity() {
        setSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SLOPE_POLARITY)));
    }

    public void readLevelSelect() {
        setSlopeTrigger_Level_ID(ServiceEnum.getTrigger_Level_IDFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SLOPE_LEVELSELECT)));
    }

    public void readSlopeHighLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_H);
        if (getTriggerMode() != ServiceEnum.TriggerMode.Trigger_Slope || UI_QueryInt64 == getSlopelevelA()) {
            return;
        }
        setLevel(UI_QueryInt64);
        setLevelB(getSlopelevelB());
        setSlopelevelA(UI_QueryInt64);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, UI_QueryInt64);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, getSlopelevelB());
    }

    public void readSlopeLowLevel() {
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Slope) {
            long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_L);
            setSlopelevelB(UI_QueryInt64);
            setLevel(getSlopelevelA());
            setLevelB(UI_QueryInt64);
            syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, UI_QueryInt64);
            syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, getSlopelevelA());
        }
    }

    public void readVideoChan() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_VIDEO_SOURCE)));
    }

    public void readVideoPolarity() {
        setVideoPolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_VIDEO_POLARITY) ? 1 : 0));
    }

    public void readVideoStandard() {
        setVideoFormat(ServiceEnum.getTrigger_Video_FormatFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_VIDEO_STANDARD)));
    }

    public void readVideoSync() {
        setVideoSync(ServiceEnum.getTrigger_Video_SyncFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_VIDEO_SYNC)));
    }

    public void readVideoLine() {
        setLinesNumber(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_VIDEO_LINENUM));
    }

    public void readPatternChan() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_PATTERN_SOURCE)));
    }

    public void readPatternLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_PATTERN_LEVEL);
        if (API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SOURCE) == getChan().value1 && this.triggerMode == ServiceEnum.TriggerMode.Trigger_Pattern) {
            setLevel(UI_QueryInt64);
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt64));
        }
    }

    public void readDurationSource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_DURATION_SOURCE)));
    }

    public void readDurationWhen() {
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_DURATION_WHEN)));
    }

    public void readDurationLwidth() {
        setDurationLowerLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_DURATION_LOWER));
    }

    public void readDurationUwidth() {
        setDurationUperLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_DURATION_UPPER));
    }

    public void readDurationLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_DURATION_LEVEL);
        if (API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SOURCE) == getChan().value1 && this.triggerMode == ServiceEnum.TriggerMode.Trigger_Duration) {
            setLevel(UI_QueryInt64);
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt64));
        }
    }

    public void readTimeoutSource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_TIMEOUT_SOURCE)));
    }

    public void readTimeoutSlope() {
        setTimeoutSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_TIMEOUT_SLOPE)));
    }

    public void readTimeoutTime() {
        setTimeOut(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_TIMEOUT_TIME));
    }

    public void readRuntSource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RUNT_SOURCE)));
    }

    public void readRuntPolarity() {
        setRuntPolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_RUNT_POLARITY) ? 1 : 0));
    }

    public void readRuntLevelSelect() {
        setRuntTrigger_Level_ID(ServiceEnum.getTrigger_Level_IDFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RUNT_LEVELSELECT)));
    }

    public void readRuntWhen() {
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RUNT_WHEN)));
    }

    public void readRuntLwidth() {
        setRuntLowerLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_RUNT_LOWER));
    }

    public void readRuntUwidth() {
        setRuntUperLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_RUNT_UPPER));
    }

    public void readRuntHighLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_H);
        if (getTriggerMode() != ServiceEnum.TriggerMode.Trigger_Runt || UI_QueryInt64 == getRuntlevelA()) {
            return;
        }
        setLevel(UI_QueryInt64);
        setRuntlevelA(UI_QueryInt64);
        setLevelB(getRuntlevelB());
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, UI_QueryInt64);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, getRuntlevelB());
    }

    public void readRuntLowLevel() {
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Runt) {
            long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_L);
            setRuntlevelB(UI_QueryInt64);
            setLevel(getRuntlevelA());
            setLevelB(UI_QueryInt64);
            syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, getRuntlevelA());
            syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, UI_QueryInt64);
        }
    }

    public void readOverSource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_OVER_SOURCE)));
    }

    public void readOverSlope() {
        setOverSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_OVER_SLOPE)));
    }

    public void readOverPos() {
        setOverEvent(ServiceEnum.getOverEventFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_OVER_POS)));
    }

    public void readOverTime() {
        setOverTime(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_OVER_TIME));
    }

    public void readOverLevelSelect() {
        setOverTrigger_Level_ID(ServiceEnum.getTrigger_Level_IDFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_OVER_LEVELSELECT)));
    }

    public void readOverHighLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_H);
        if (getTriggerMode() != ServiceEnum.TriggerMode.Trigger_Over || UI_QueryInt64 == getOverlevelA()) {
            return;
        }
        setOverlevelA(UI_QueryInt64);
        setLevel(UI_QueryInt64);
        setLevelB(getOverlevelB());
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, UI_QueryInt64);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, getOverlevelB());
    }

    public void readOverLowLevel() {
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Over) {
            long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_L);
            setOverlevelB(UI_QueryInt64);
            setLevel(getOverlevelA());
            setLevelB(UI_QueryInt64);
            syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, UI_QueryInt64);
            syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, getOverlevelA());
        }
    }

    public void readDelaySourceA() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_DELAY_SRCA);
        setDelayChanA(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readDelaySourceB() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_DELAY_SRCB);
        setDelayChanB(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readDelayWhen() {
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_DELAY_WHEN)));
    }

    public void readDelaySlopeA() {
        setEdgeSlopeA(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_DELAY_EDGA) ? 1 : 0));
    }

    public void readDelaySlopeB() {
        setEdgeSlopeB(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_DELAY_EDGB) ? 1 : 0));
    }

    public void readDelayLwidth() {
        setDelayLowerLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_DELAY_LOWER));
    }

    public void readDelayUwidth() {
        setDelayUperLimit(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_DELAY_UPPER));
    }

    public void readDelayHighLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.delayChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.delayChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_DELAY_LEVEL_H);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_Delay || UI_QueryInt643 == getDelaylevelA() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setDelaylevelA(UI_QueryInt643);
        setChan(getDelayChanA());
        setLevel(UI_QueryInt643);
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readDelayLowLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.delayChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.delayChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_DELAY_LEVEL_L);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_Delay || UI_QueryInt643 == getDelaylevelB() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setDelaylevelB(UI_QueryInt643);
        setChan(getDelayChanB());
        setLevel(UI_QueryInt643);
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readSetupHoldSourceA() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SETUP_SCL);
        setSetupHoldChanA(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readSetupHoldSourceB() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SETUP_SDA);
        setSetupHoldChanB(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readSetupHoldSlope() {
        setSetupHoldSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_SETUP_SLOPE) ? 1 : 0));
    }

    public void readSetupHoldDataType() {
        setSetupHoldPolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_SETUP_DATA) ? 1 : 0));
    }

    public void readSetupHoldWhen() {
        setSHEvent(ServiceEnum.getSHEventFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SETUP_WHEN)));
    }

    public void readSetupTime() {
        setSetup(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SETUP_TIME));
    }

    public void readHoldTime() {
        setHold(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_HOLD_TIME));
    }

    public void readSetupHoldHighLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SETUP_LEVEL_H);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_Setup || UI_QueryInt643 == getSetupHoldlevelB() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setSetupHoldlevelB(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getSetupHoldChanB());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readSetupHoldLowLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SETUP_LEVEL_L);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_Setup || UI_QueryInt643 == getSetupHoldlevelA() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setSetupHoldlevelA(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getSetupHoldChanA());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readNthSource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_NTH_SOURCE)));
    }

    public void readNthSlope() {
        setNthSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_NTH_SLOPE) ? 1 : 0));
    }

    public void readNthidelTime() {
        setIdelTime(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_NTH_IDLETIME));
    }

    public void readNthedgeNumber() {
        setEdgeNumber(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_NTH_EDGE));
    }

    public void readRS232Source() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RS232_SOURCE_LA)));
    }

    public void readRS232When() {
        setTrigger_RS232_When(ServiceEnum.getTrigger_RS232_WhenFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RS232_WHEN)));
    }

    public void readRS232Parity() {
        setTrigger_RS232_Parity(ServiceEnum.getTrigger_RS232_ParityFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RS232_CHECK)));
    }

    public void readRS232Polarity() {
        setPulsePolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_RS232_POLARITY) ? 1 : 0));
    }

    public void readRS232StopBit() {
        setTrigger_RS232_Stop(ServiceEnum.getTrigger_RS232_StopFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RS232_STOPBIT)));
    }

    public void readRS232DataWidth() {
        setTrigger_RS232_Width(ServiceEnum.getTrigger_RS232_WidthFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RS232_DATAWIDTH)));
        readRs232DataAttr();
    }

    public void readRS232Baudrate() {
        setRs232BaudRate(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_RS232_BAUDRATE));
    }

    public void readI2CScl() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_SCL);
        setIicChanA(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readI2CSda() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_SDA);
        setIicChanB(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readI2CWhen() {
        setTrigger_I2C_When(ServiceEnum.getTrigger_I2C_WhenFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_WHEN)));
    }

    public void readI2CAddrData() {
        setTrigger_I2C_Spec(ServiceEnum.getTrigger_I2C_SpecFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_ADDRDATA_BITS)));
    }

    public void readI2CDirection() {
        setTrigger_I2C_WR(ServiceEnum.getTrigger_I2C_WRFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_I2C_DIRECTION)));
    }

    public void readI2CData() {
        int i;
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_I2C_DATA);
        String binaryString = Long.toBinaryString(UI_QueryInt64);
        if (this.i2cDataType == 1) {
            binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
            i = 2;
        } else {
            i = 8;
        }
        int length = binaryString.length();
        if (binaryString.length() % i != 0) {
            for (int i2 = 0; i2 < i - (length % i); i2++) {
                binaryString = "0" + binaryString;
            }
        }
        int length2 = binaryString.length() / i;
        if (length2 < getByteLength()) {
            for (int i3 = 0; i3 < (getByteLength() - length2) * i; i3++) {
                binaryString = "0" + binaryString;
            }
        }
        char[] charArray = binaryString.toCharArray();
        String str = "";
        for (int i4 = 0; i4 < charArray.length; i4++) {
            if (i4 % i == 0 && i4 != 0) {
                str = str + " ";
            }
            str = str + charArray[i4];
        }
        setFormatValue1Str(this.i2cDataType == 0 ? "[bin]" + str : "[hex]" + str);
    }

    public void readI2cCode() {
        String UI_QueryStr;
        int length = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_I2C_CODE_STRING).length();
        String str = "";
        int i = 0;
        while (i < length) {
            str = str + UI_QueryStr.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue1Str("[bin]" + str);
    }

    public void readI2CClkLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.iicChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.iicChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2C_LEVEL_CLK);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_I2C || UI_QueryInt643 == getIiclevelA() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setIiclevelA(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getIicChanA());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readI2CDataLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.iicChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.iicChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2C_LEVEL_DATA);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_I2C || UI_QueryInt643 == getIiclevelB() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setIiclevelB(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getIicChanB());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readSpiScl() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_SCL);
        setSpiChanA(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readSpiSda() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_SDA);
        setSpiChanB(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readSpiCs() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_CS);
        setSpiChanC(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readSpiClkLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.spiChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.spiChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_CLK);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_SPI || UI_QueryInt643 == getSpilevelA() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setSpilevelA(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getSpiChanA());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readSpiDataLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.spiChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.spiChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_DATA);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_SPI || UI_QueryInt643 == getSpilevelB() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setSpilevelB(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getSpiChanB());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readSpiCsLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.spiChanC.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.spiChanC.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_CS);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_SPI || UI_QueryInt643 == getSpilevelC() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setSpilevelC(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getSpiChanC());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readSpiSlope() {
        setSpiSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_SPI_SLOPE) ? 1 : 0));
    }

    public void readSpiWhen() {
        setTrigger_Spi_CS(ServiceEnum.getTrigger_Spi_CSFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_SPI_WHEN) ? 1 : 0));
    }

    public void readSpiCsMode() {
        setPulsePolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_SPI_CSMODE) ? 1 : 0));
    }

    public void readSpiTimeout() {
        setSpiTimeOut(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SPI_TIMEOUT));
    }

    public void readSpiData() {
        int i;
        String str;
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SPI_DATA);
        String binaryString = Long.toBinaryString(UI_QueryInt64);
        int i2 = 1;
        if (getSpiDataType() == 1) {
            binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
            i = 2;
        } else {
            i = 8;
        }
        int length = binaryString.length();
        int i3 = 0;
        String str2 = "";
        if (getSpiDataType() == 0) {
            if (length < getDataBits()) {
                while (i3 < getDataBits() - length) {
                    binaryString = "0" + binaryString;
                    i3++;
                }
            }
            char[] charArray = binaryString.toCharArray();
            for (int length2 = charArray.length - 1; length2 >= 0; length2--) {
                String str3 = str2 + charArray[length2];
                if (i2 % i == 0 && i2 != charArray.length) {
                    str3 = str3 + " ";
                }
                str2 = str3;
                i2++;
            }
            StringBuffer stringBuffer = new StringBuffer(str2);
            str = "[bin]" + stringBuffer.reverse().toString();
        } else {
            int dataBits = getDataBits() / 4;
            if (getDataBits() % 4 != 0) {
                dataBits++;
            }
            if (length < dataBits) {
                while (i3 < dataBits - length) {
                    binaryString = "0" + binaryString;
                    i3++;
                }
            }
            char[] charArray2 = binaryString.toCharArray();
            for (int length3 = charArray2.length - 1; length3 >= 0; length3--) {
                String str4 = str2 + charArray2[length3];
                if (i2 % i == 0 && i2 != charArray2.length) {
                    str4 = str4 + " ";
                }
                str2 = str4;
                i2++;
            }
            StringBuffer stringBuffer2 = new StringBuffer(str2);
            str = "[hex]" + stringBuffer2.reverse().toString();
        }
        setFormatValue2Str(str);
    }

    public void readSpiCode() {
        String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_SPI_CODE_STRING);
        int length = UI_QueryStr.length();
        String sb = new StringBuilder(UI_QueryStr).reverse().toString();
        String str = "";
        int i = 0;
        while (i < length) {
            str = str + sb.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        StringBuilder sb2 = new StringBuilder(str);
        setFormatValue2Str("[bin]" + sb2.reverse().toString());
    }

    public void readSpiDataBits() {
        setDataBits(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SPI_DATABITS));
    }

    public void readCanSource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_SOURCE_LA)));
    }

    public void readCanBaud() {
        setCanBaud(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_BAUD));
    }

    public void readCanFdBaud() {
        setCanFdBaud(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CANFD_BAUD));
    }

    public void readCanSingnal() {
        setTrigger_Can_Phy(ServiceEnum.getTrigger_Can_PhyFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_SINGNAL)));
    }

    public void readCanWhen() {
        setTrigger_Serv_Can_When(ServiceEnum.getTrigger_Serv_Can_WhenFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_WHEN)));
    }

    public void readCanSamplePoint() {
        setSamplePoints(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_SAMPLE_POINT));
    }

    public void readCanFdSamplePoint() {
        setFdSamplePoints(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_FD_SAMPLE_POINT));
    }

    public void readCanIdExtended() {
        setIdExtended(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_ID_EXTENDED) == 1);
    }

    public void readCanDefine() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_DEFINE);
        if (UI_QueryInt32 == 1 || UI_QueryInt32 == 3) {
            setCanDefine(true);
        } else {
            setCanDefine(false);
        }
    }

    public void readCanDataByte() {
        setDataByte(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_CAN_DATA_BYTE));
    }

    public void readCanIdFilter() {
        if (!API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_CAN_ID_FILTER)) {
            setCanDataIdType(1);
            if (getFormatValue3IdStr().contains("[bin]")) {
                setCanIdType(0);
                return;
            } else {
                setCanIdType(1);
                return;
            }
        }
        setCanDataIdType(0);
        if (getFormatValue3DataStr().contains("[bin]")) {
            setCanDataType(0);
        } else {
            setCanDataType(1);
        }
    }

    public void readCanData() {
        String str;
        long parseLong = Long.parseLong(API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_CAN_DATA));
        String binaryString = Long.toBinaryString(parseLong);
        int length = binaryString.length();
        int i = 2;
        int i2 = 0;
        int i3 = 1;
        String str2 = "";
        if (getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data || (getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data_id && !getCanDefine())) {
            if (getCanDataType() == 1) {
                binaryString = Long.toHexString(parseLong).toUpperCase();
            } else {
                i = 8;
            }
            if (binaryString.length() % i != 0) {
                for (int i4 = 0; i4 < i - (length % i); i4++) {
                    binaryString = "0" + binaryString;
                }
            }
            int length2 = binaryString.length() / i;
            if (length2 < getDataByte()) {
                for (int i5 = 0; i5 < (getDataByte() - length2) * i; i5++) {
                    binaryString = "0" + binaryString;
                }
            }
            char[] charArray = binaryString.toCharArray();
            while (i2 < charArray.length) {
                if (i2 % i == 0 && i2 != 0) {
                    str2 = str2 + " ";
                }
                str2 = str2 + charArray[i2];
                i2++;
            }
            setFormatValue3DataStr(getCanDataType() == 0 ? "[bin]" + str2 : "[hex]" + str2);
            return;
        }
        if (getCanIdType() == 1) {
            binaryString = Long.toHexString(parseLong).toUpperCase();
            length = binaryString.length();
        } else {
            i = 8;
        }
        int i6 = getIdExtended() ? 29 : 11;
        if (getCanIdType() == 0) {
            if (length < i6) {
                while (i2 < i6 - length) {
                    binaryString = "0" + binaryString;
                    i2++;
                }
            }
            char[] charArray2 = binaryString.toCharArray();
            for (int length3 = charArray2.length - 1; length3 >= 0; length3--) {
                String str3 = str2 + charArray2[length3];
                if (i3 % i == 0 && i3 != charArray2.length) {
                    str3 = str3 + " ";
                }
                str2 = str3;
                i3++;
            }
            StringBuffer stringBuffer = new StringBuffer(str2);
            str = "[bin]" + stringBuffer.reverse().toString();
        } else {
            int i7 = i6 / 4;
            if (i6 % 4 != 0) {
                i7++;
            }
            if (length < i7) {
                while (i2 < i7 - length) {
                    binaryString = "0" + binaryString;
                    i2++;
                }
            }
            char[] charArray3 = binaryString.toCharArray();
            for (int length4 = charArray3.length - 1; length4 >= 0; length4--) {
                String str4 = str2 + charArray3[length4];
                if (i3 % i == 0 && i3 != charArray3.length) {
                    str4 = str4 + " ";
                }
                str2 = str4;
                i3++;
            }
            StringBuffer stringBuffer2 = new StringBuffer(str2);
            str = "[hex]" + stringBuffer2.reverse().toString();
        }
        setFormatValue3IdStr(str);
    }

    public void readCanCode() {
        String UI_QueryStr;
        int i = 0;
        String str = "";
        if (getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data || (getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data_id && !getCanDefine())) {
            int length = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_CAN_DATA_CODE_STRING).length();
            while (i < length) {
                str = str + UI_QueryStr.charAt(i);
                i++;
                if (i % 8 == 0 && i != length) {
                    str = str + " ";
                }
            }
            setFormatValue3DataStr("[bin]" + str);
        } else if (getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_remote_id || getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_id || (getTrigger_Serv_Can_When() == ServiceEnum.Trigger_Serv_Can_When.trig_can_when_frame_data_id && getCanDefine())) {
            String UI_QueryStr2 = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_CAN_ID_CODE_STRING);
            int length2 = UI_QueryStr2.length();
            String sb = new StringBuilder(UI_QueryStr2).reverse().toString();
            while (i < length2) {
                str = str + sb.charAt(i);
                i++;
                if (i % 8 == 0 && i != length2) {
                    str = str + " ";
                }
            }
            StringBuilder sb2 = new StringBuilder(str);
            setFormatValue3IdStr("[bin]" + sb2.reverse().toString());
        }
    }

    public void readFlexRaySource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_SOURCE_LA)));
    }

    public void readFlexRayBaud() {
        setTrigger_Flex_Baud(ServiceEnum.getTrigger_Flex_BaudFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_BAUD)));
    }

    public void readFlexRayWhen() {
        setTrigger_Flex_When(ServiceEnum.getTrigger_Flex_WhenFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_WHEN)));
    }

    public void readFlexRayPost() {
        setTrigger_Flex_Pos(ServiceEnum.getTrigger_Flex_PosFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_POST_TYPE)));
    }

    public void readFlexRayError() {
        setTrigger_Flex_Err(ServiceEnum.getTrigger_Flex_ErrFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ERROR_TYPE)));
    }

    public void readFlexRaySymbol() {
        setTrigger_Flex_Symbol(ServiceEnum.getTrigger_Flex_SymbolFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_SYMBOL_TYPE)));
    }

    public void readFlexRayFrame() {
        setTrigger_Flex_Frame(ServiceEnum.getTrigger_Flex_FrameFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_FRAME_TYPE)));
    }

    public void readFlexrayDefine() {
        setDefine(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_FLEXRAY_DEFINE));
    }

    public void readFlexRayIDcomp() {
        setTrigger_IIS_data_cmp_ID(ServiceEnum.getTrigger_IIS_data_cmpFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_COMP)));
    }

    public void readFlexRayCYCcomp() {
        setTrigger_IIS_data_cmp_Cyc(ServiceEnum.getTrigger_IIS_data_cmpFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_COMP)));
    }

    public void readFlexRayCH() {
        setTrigger_Flex_Phy(ServiceEnum.getTrigger_Flex_PhyFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CH_A_B)));
    }

    public void readFlexRayCYCmax() {
        setCompareUperLimit(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_MAX));
    }

    public void readFlexRayCYCmin() {
        setCompareLowerLimit(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_MIN));
    }

    public void readFlexRayIDmax() {
        setIdUperLimit(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MAX));
    }

    public void readFlexRayIDmin() {
        setIdLowerLimit(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MIN));
    }

    public void readLinSource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_LIN_SOURCE_LA)));
    }

    public void readLinVersion() {
        setTrigger_Lin_Ver(ServiceEnum.getTrigger_Lin_VerFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_LIN_VERSION)));
    }

    public void readLinBaud() {
        setLinBaud(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_LIN_BAUD));
    }

    public void readLinSamplePosition() {
        setLinSamplePosition(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_LIN_SAMPLE_POINT));
    }

    public void readLinWhen() {
        setTrigger_Lin_When(ServiceEnum.getTrigger_Lin_WhenFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_LIN_WHEN)));
    }

    public void readLinErrType() {
        setTrigger_Lin_Err(ServiceEnum.getTrigger_Lin_ErrFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_LIN_ERR_TYPE)));
    }

    public void readLinID() {
        setLinId(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_LIN_ID));
    }

    public void readLinDataByte() {
        setLinByte(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_LIN_DATA_BYTE));
    }

    public void readLinData() {
        int i;
        long parseLong = Long.parseLong(API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_LIN_DATA));
        String binaryString = Long.toBinaryString(parseLong);
        if (this.linDataType == 1) {
            binaryString = Long.toHexString(parseLong).toUpperCase();
            i = 2;
        } else {
            i = 8;
        }
        int length = binaryString.length();
        if (binaryString.length() % i != 0) {
            for (int i2 = 0; i2 < i - (length % i); i2++) {
                binaryString = "0" + binaryString;
            }
        }
        int length2 = binaryString.length() / i;
        if (length2 < getLinByte()) {
            for (int i3 = 0; i3 < (getLinByte() - length2) * i; i3++) {
                binaryString = "0" + binaryString;
            }
        }
        char[] charArray = binaryString.toCharArray();
        String str = "";
        for (int i4 = 0; i4 < charArray.length; i4++) {
            if (i4 % i == 0 && i4 != 0) {
                str = str + " ";
            }
            str = str + charArray[i4];
        }
        setFormatValue4Str(this.linDataType == 0 ? "[bin]" + str : "[hex]" + str);
    }

    public void readLinCode() {
        String UI_QueryStr;
        int length = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_LIN_CODE_STRING).length();
        String str = "";
        int i = 0;
        while (i < length) {
            str = str + UI_QueryStr.charAt(i);
            i++;
            if (i % 8 == 0 && i != length) {
                str = str + " ";
            }
        }
        setFormatValue4Str("[bin]" + str);
    }

    public void readDataMin() {
        setI2sDataType(1);
        if (getFormatValue5MinStr().contains("[bin]")) {
            setIisMinDataType(0);
        } else {
            setIisMinDataType(1);
        }
    }

    public void readDataMax() {
        setI2sDataType(2);
        if (getFormatValue5MaxStr().contains("[bin]")) {
            setIisMaxDataType(0);
        } else {
            setIisMaxDataType(1);
        }
    }

    public void readclkSource() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_SCLK);
        setIisChanA(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readwsSource() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_WS);
        setIisChanB(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readsdaSource() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_SDA);
        setIisChanC(ServiceEnum.getChanFromValue1(UI_QueryInt32));
        setChan(ServiceEnum.getChanFromValue1(UI_QueryInt32));
    }

    public void readclkEdge() {
        setIisSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_SLOPE)));
    }

    public void readAudio() {
        setTrigger_IIS_Ch(ServiceEnum.getTrigger_IIS_ChFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_WS_LOW)));
    }

    public void readiisWhen() {
        setTrigger_IIS_data_cmp(ServiceEnum.getTrigger_IIS_data_cmpFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_WHEN)));
    }

    public void readwidth() {
        setWidth(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_USER_WIDTH));
    }

    public void readallWidth() {
        setAllWidth(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_WIDTH));
    }

    public void readAlignment() {
        setTrigger_IIS_Spec(ServiceEnum.getTrigger_IIS_SpecFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_ALIGNMENT)));
    }

    public void readIisData() {
        int i;
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_DATA_IIS);
        String binaryString = Long.toBinaryString(UI_QueryInt64);
        int i2 = 1;
        if (getI2sDataType() == 0) {
            if (getIisDataType() == 1) {
                binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
                i = 2;
            }
            i = 8;
        } else if (getI2sDataType() == 1) {
            if (getIisMinDataType() == 1) {
                binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
                i = 2;
            }
            i = 8;
        } else {
            if (getI2sDataType() == 2 && getIisMaxDataType() == 1) {
                binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
                i = 2;
            }
            i = 8;
        }
        int length = binaryString.length();
        int i3 = 0;
        String str = "";
        if (getI2sDataType() == 0) {
            if (getIisDataType() == 0) {
                if (length < getWidth()) {
                    while (i3 < getWidth() - length) {
                        binaryString = "0" + binaryString;
                        i3++;
                    }
                }
                char[] charArray = binaryString.toCharArray();
                for (int length2 = charArray.length - 1; length2 >= 0; length2--) {
                    String str2 = str + charArray[length2];
                    if (i2 % i == 0 && i2 != charArray.length) {
                        str2 = str2 + " ";
                    }
                    str = str2;
                    i2++;
                }
                StringBuffer stringBuffer = new StringBuffer(str);
                str = "[bin]" + stringBuffer.reverse().toString();
            } else if (getIisDataType() == 1) {
                int width = getWidth() / 4;
                if (getWidth() % 4 != 0) {
                    width++;
                }
                if (length < width) {
                    while (i3 < width - length) {
                        binaryString = "0" + binaryString;
                        i3++;
                    }
                }
                char[] charArray2 = binaryString.toCharArray();
                for (int length3 = charArray2.length - 1; length3 >= 0; length3--) {
                    String str3 = str + charArray2[length3];
                    if (i2 % i == 0 && i2 != charArray2.length) {
                        str3 = str3 + " ";
                    }
                    str = str3;
                    i2++;
                }
                StringBuffer stringBuffer2 = new StringBuffer(str);
                str = "[hex]" + stringBuffer2.reverse().toString();
            }
            setFormatValue5Str(str);
            setFormatValue5MinStr(str);
        } else if (getI2sDataType() == 1) {
            if (getIisMinDataType() == 0) {
                if (length < getWidth()) {
                    while (i3 < getWidth() - length) {
                        binaryString = "0" + binaryString;
                        i3++;
                    }
                }
                char[] charArray3 = binaryString.toCharArray();
                for (int length4 = charArray3.length - 1; length4 >= 0; length4--) {
                    String str4 = str + charArray3[length4];
                    if (i2 % i == 0 && i2 != charArray3.length) {
                        str4 = str4 + " ";
                    }
                    str = str4;
                    i2++;
                }
                StringBuffer stringBuffer3 = new StringBuffer(str);
                str = "[bin]" + stringBuffer3.reverse().toString();
            } else if (getIisMinDataType() == 1) {
                int width2 = getWidth() / 4;
                if (getWidth() % 4 != 0) {
                    width2++;
                }
                if (length < width2) {
                    while (i3 < width2 - length) {
                        binaryString = "0" + binaryString;
                        i3++;
                    }
                }
                char[] charArray4 = binaryString.toCharArray();
                for (int length5 = charArray4.length - 1; length5 >= 0; length5--) {
                    String str5 = str + charArray4[length5];
                    if (i2 % i == 0 && i2 != charArray4.length) {
                        str5 = str5 + " ";
                    }
                    str = str5;
                    i2++;
                }
                StringBuffer stringBuffer4 = new StringBuffer(str);
                str = "[hex]" + stringBuffer4.reverse().toString();
            }
            setFormatValue5MinStr(str);
            setFormatValue5Str(str);
        } else if (getI2sDataType() == 2) {
            if (getIisMaxDataType() == 0) {
                if (length < getWidth()) {
                    while (i3 < getWidth() - length) {
                        binaryString = "0" + binaryString;
                        i3++;
                    }
                }
                char[] charArray5 = binaryString.toCharArray();
                for (int length6 = charArray5.length - 1; length6 >= 0; length6--) {
                    String str6 = str + charArray5[length6];
                    if (i2 % i == 0 && i2 != charArray5.length) {
                        str6 = str6 + " ";
                    }
                    str = str6;
                    i2++;
                }
                StringBuffer stringBuffer5 = new StringBuffer(str);
                str = "[bin]" + stringBuffer5.reverse().toString();
            } else if (getIisMaxDataType() == 1) {
                int width3 = getWidth() / 4;
                if (getWidth() % 4 != 0) {
                    width3++;
                }
                if (length < width3) {
                    while (i3 < width3 - length) {
                        binaryString = "0" + binaryString;
                        i3++;
                    }
                }
                char[] charArray6 = binaryString.toCharArray();
                for (int length7 = charArray6.length - 1; length7 >= 0; length7--) {
                    String str7 = str + charArray6[length7];
                    if (i2 % i == 0 && i2 != charArray6.length) {
                        str7 = str7 + " ";
                    }
                    str = str7;
                    i2++;
                }
                StringBuffer stringBuffer6 = new StringBuffer(str);
                str = "[hex]" + stringBuffer6.reverse().toString();
            }
            setFormatValue5MaxStr(str);
        }
    }

    public void readIisCode() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_IIS_DATA_TYPE);
        int i = 0;
        String str = "";
        if (UI_QueryInt32 != 1) {
            if (UI_QueryInt32 == 2) {
                String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_I2S_MAX_STRING);
                int length = UI_QueryStr.length();
                String sb = new StringBuilder(UI_QueryStr).reverse().toString();
                while (i < length) {
                    str = str + sb.charAt(i);
                    i++;
                    if (i % 8 == 0 && i != length) {
                        str = str + " ";
                    }
                }
                StringBuilder sb2 = new StringBuilder(str);
                setFormatValue5MaxStr("[bin]" + sb2.reverse().toString());
                return;
            }
            return;
        }
        String UI_QueryStr2 = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_I2S_MIN_STRING);
        int length2 = UI_QueryStr2.length();
        String sb3 = new StringBuilder(UI_QueryStr2).reverse().toString();
        while (i < length2) {
            str = str + sb3.charAt(i);
            i++;
            if (i % 8 == 0 && i != length2) {
                str = str + " ";
            }
        }
        String sb4 = new StringBuilder(str).reverse().toString();
        setFormatValue5Str("[bin]" + sb4);
        setFormatValue5MinStr("[bin]" + sb4);
    }

    public void readIisClkLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.iisChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.iisChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_CLK);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_I2S || UI_QueryInt643 == getIislevelA() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setIislevelA(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getIisChanA());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readIisWsLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.iisChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.iisChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_CS);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_I2S || UI_QueryInt643 == getIislevelB() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setIislevelB(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getIisChanB());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readIisDataLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.iisChanC.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.iisChanC.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        long j = (5 * UI_QueryInt64) - UI_QueryInt642;
        long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
        long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_DATA);
        if (this.triggerMode != ServiceEnum.TriggerMode.Trigger_I2S || UI_QueryInt643 == getIislevelC() || UI_QueryInt643 < j2 || UI_QueryInt643 > j) {
            return;
        }
        setIislevelC(UI_QueryInt643);
        setLevel(UI_QueryInt643);
        setChan(getIisChanC());
        MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(UI_QueryInt643));
    }

    public void readMilstdSource() {
        setChan(ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_1553B_SOURCE)));
    }

    public void readMilstdPolarity() {
        setPulsePolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_1553B_POLARITY) ? 1 : 0));
    }

    public void readMilstdWhen() {
        setTrigger_1553_When(ServiceEnum.getTrigger_1553_WhenFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_1553B_WHEN)));
    }

    public void readMilstdLevelSelect() {
        setMilstdTrigger_Level_ID(ServiceEnum.getTrigger_Level_IDFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_1553B_LEVELSELECT)));
    }

    public void readMilstdSyncType() {
        setTrigger_1553_Sync(ServiceEnum.getTrigger_1553_SyncFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_1553B_SYNC_TYPE)));
    }

    public void readMilstdErrType() {
        setTrigger_1553_Err(ServiceEnum.getTrigger_1553_ErrFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_1553B_ERR_TYPE)));
    }

    public void readMilstdDataComp() {
        setTrigger_value_cmp(ServiceEnum.getTrigger_value_cmpFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_1553B_DATA_COMP)));
    }

    public void readMilstdHighLevel() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_H);
        if (getTriggerMode() != ServiceEnum.TriggerMode.Trigger_1553 || UI_QueryInt64 == getMilstdlevelA()) {
            return;
        }
        setMilstdlevelA(UI_QueryInt64);
        setLevel(UI_QueryInt64);
        setLevelB(getMilstdlevelB());
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, UI_QueryInt64);
        syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, getMilstdlevelB());
    }

    public void readMilstdLowLevel() {
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_L);
            setMilstdlevelB(UI_QueryInt64);
            setLevel(getMilstdlevelA());
            setLevelB(UI_QueryInt64);
            syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_A, getMilstdlevelA());
            syncInterfaceData(41, MessageID.MSG_TRIGGER_LEVEL_B, UI_QueryInt64);
        }
    }

    public void readMilstdData() {
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_DATA_1553);
        String binaryString = Long.toBinaryString(UI_QueryInt64);
        int i = 0;
        String str = "";
        int i2 = 8;
        if (getMilstdDataType() == 0) {
            if (getUpType() == 1) {
                binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
                i2 = 2;
            }
            int length = binaryString.length();
            if (binaryString.length() % i2 != 0) {
                for (int i3 = 0; i3 < i2 - (length % i2); i3++) {
                    binaryString = "0" + binaryString;
                }
            }
            int length2 = binaryString.length() / i2;
            if (length2 < 2) {
                for (int i4 = 0; i4 < (2 - length2) * i2; i4++) {
                    binaryString = "0" + binaryString;
                }
            }
            char[] charArray = binaryString.toCharArray();
            while (i < charArray.length) {
                if (i % i2 == 0 && i != 0) {
                    str = str + " ";
                }
                str = str + charArray[i];
                i++;
            }
        } else if (getMilstdDataType() == 1) {
            if (getDownType() == 1) {
                binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
                i2 = 2;
            }
            int length3 = binaryString.length();
            if (binaryString.length() % i2 != 0) {
                for (int i5 = 0; i5 < i2 - (length3 % i2); i5++) {
                    binaryString = "0" + binaryString;
                }
            }
            int length4 = binaryString.length() / i2;
            if (length4 < 2) {
                for (int i6 = 0; i6 < (2 - length4) * i2; i6++) {
                    binaryString = "0" + binaryString;
                }
            }
            char[] charArray2 = binaryString.toCharArray();
            while (i < charArray2.length) {
                if (i % i2 == 0 && i != 0) {
                    str = str + " ";
                }
                str = str + charArray2[i];
                i++;
            }
        } else if (getMilstdDataType() == 2) {
            int i7 = 5;
            if (getRtaType() == 1) {
                binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
                i7 = 2;
            }
            int length5 = binaryString.length();
            if (length5 < i7) {
                while (i < i7 - length5) {
                    binaryString = "0" + binaryString;
                    i++;
                }
            }
            str = binaryString;
        } else if (getMilstdDataType() == 3) {
            int i8 = 11;
            if (getBitType() == 1) {
                binaryString = Long.toHexString(UI_QueryInt64).toUpperCase();
                i8 = 3;
            }
            int length6 = binaryString.length();
            if (length6 < i8) {
                while (i < i8 - length6) {
                    binaryString = "0" + binaryString;
                    i++;
                }
            }
            StringBuffer stringBuffer = new StringBuffer(binaryString);
            if (getBitType() == 0) {
                stringBuffer.insert(3, " ");
            } else if (getBitType() == 1) {
                stringBuffer.insert(1, " ");
            }
            str = stringBuffer.toString();
        }
        if (getMilstdDataType() == 0) {
            if (getUpType() == 0) {
                str = "[bin]" + str;
            } else if (getUpType() == 1) {
                str = "[hex]" + str;
            }
            setFormatValue6MaxStr(str);
        } else if (getMilstdDataType() == 1) {
            if (getDownType() == 0) {
                str = "[bin]" + str;
            } else if (getDownType() == 1) {
                str = "[hex]" + str;
            }
            setFormatValue6Str(str);
        } else if (getMilstdDataType() == 2) {
            if (getRtaType() == 0) {
                str = "[bin]" + str;
            } else if (getRtaType() == 1) {
                str = "[hex]" + str;
            }
            setFormatValue6RtaStr(str);
        } else if (getMilstdDataType() == 3) {
            if (getBitType() == 0) {
                str = "[bin]" + str;
            } else if (getBitType() == 1) {
                str = "[hex]" + str;
            }
            setFormatValue6BitStr(str);
        }
    }

    public void readMilstdDataMax() {
        setMilstdDataType(0);
        if (getFormatValue6MaxStr().contains("[bin]")) {
            setUpType(0);
        } else {
            setUpType(1);
        }
    }

    public void readMilstdDataMin() {
        setMilstdDataType(1);
        if (getFormatValue6Str().contains("[bin]")) {
            setDownType(0);
        } else {
            setDownType(1);
        }
    }

    public void readMilstdDataRta() {
        setMilstdDataType(2);
        if (getFormatValue6RtaStr().contains("[bin]")) {
            setRtaType(0);
        } else {
            setRtaType(1);
        }
    }

    public void readMilstdDataBit() {
        setMilstdDataType(3);
        if (getFormatValue6BitStr().contains("[bin]")) {
            setBitType(0);
        } else {
            setBitType(1);
        }
    }

    public void readMilstdCode() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_1553_DATA_TYPE);
        if (UI_QueryInt32 == 1) {
            StringBuilder sb = new StringBuilder(API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_1553_MAX_STRING));
            setFormatValue6MaxStr("[bin]" + sb.insert(8, " ").toString());
        } else if (UI_QueryInt32 == 2) {
            StringBuilder sb2 = new StringBuilder(API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_1553_MIN_STRING));
            setFormatValue6Str("[bin]" + sb2.insert(8, " ").toString());
        } else if (UI_QueryInt32 == 3) {
            StringBuilder sb3 = new StringBuilder(API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_1553_RTA_STRING));
            setFormatValue6RtaStr("[bin]" + sb3.toString());
        } else if (UI_QueryInt32 == 4) {
            StringBuilder sb4 = new StringBuilder(API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_1553_BIT_STRING));
            setFormatValue6BitStr("[bin]" + sb4.insert(3, " ").toString());
        }
    }

    public String binaryTransformtoHex(String str) {
        int i;
        str.length();
        StringBuffer stringBuffer = new StringBuffer();
        String str2 = str.toString();
        String str3 = "";
        int i2 = 1;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI || getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S || ((getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN && getCanDataIdType() == 1) || (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553 && (getMilstdDataType() == 2 || getMilstdDataType() == 3)))) {
            String replaceAll = str2.replaceAll(" ", "");
            if (replaceAll.length() % 4 != 0) {
                for (int i3 = 0; i3 < 4 - (replaceAll.length() % 4); i3++) {
                    str2 = "0" + str2;
                }
            }
        }
        char[] charArray = str2.toCharArray();
        int length = str2.length();
        int i4 = 0;
        while (i4 < length) {
            if (charArray[i4] != 'X') {
                int i5 = i4 + 1;
                if (charArray[i5] != 'X') {
                    int i6 = i4 + 2;
                    if (charArray[i6] != 'X') {
                        int i7 = i4 + 3;
                        if (charArray[i7] != 'X') {
                            if (charArray[i4] == '-' || charArray[i5] == '-' || charArray[i6] == '-' || charArray[i7] == '-') {
                                if (charArray[i4] == 'X' || charArray[i5] == 'X' || charArray[i6] == 'X' || charArray[i7] == 'X') {
                                    stringBuffer.append("X");
                                } else if (charArray[i4] == '-' && charArray[i5] == '-' && charArray[i6] == '-' && charArray[i7] == '-') {
                                    stringBuffer.append("-");
                                } else {
                                    int i8 = 0;
                                    for (int i9 = 0; i9 < 4; i9++) {
                                        int i10 = i4 + i9;
                                        if (charArray[i10] == '-') {
                                            charArray[i10] = '0';
                                        }
                                        i8 += Integer.parseInt(String.valueOf(charArray[i10])) << ((4 - i9) - 1);
                                    }
                                    stringBuffer.append(Integer.toHexString(i8));
                                }
                            } else {
                                int i11 = 0;
                                for (int i12 = 0; i12 < 4; i12++) {
                                    int i13 = i4 + i12;
                                    i11 += Integer.parseInt(str2.substring(i13, i13 + 1)) << ((4 - i12) - 1);
                                }
                                stringBuffer.append(Integer.toHexString(i11));
                            }
                            i = i4 + 4;
                            if (i < length && charArray[i] == ' ') {
                                i4++;
                            }
                            i4 += 4;
                        }
                    }
                }
            }
            stringBuffer.append("X");
            i = i4 + 4;
            if (i < length) {
                i4++;
            }
            i4 += 4;
        }
        char[] charArray2 = stringBuffer.toString().toCharArray();
        for (int length2 = charArray2.length - 1; length2 >= 0; length2--) {
            String str4 = str3 + charArray2[length2];
            if (i2 % 2 == 0 && i2 != charArray2.length) {
                str4 = str4 + " ";
            }
            str3 = str4;
            i2++;
        }
        return new StringBuffer(str3).reverse().toString().toUpperCase();
    }

    public int readEdgeSource() {
        return API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_EDGE_SOURCE);
    }

    public void saveEdgeSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_EDGE_SOURCE, i);
        LogUtils.e("chanValue", Integer.valueOf(i));
    }

    public void saveNoise(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_NOISE, z);
        setIsNoise(z);
    }

    public void readNoise() {
        setIsNoise(API.getInstance().UI_QueryBool(41, MessageID.MSG_TRIGGER_NOISE));
    }

    public void readEdgeCoupling() {
        setCoupling(ServiceEnum.getCouplingFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_COUPLING)));
    }

    public void saveEdgeCoupling(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_COUPLING, i);
        setCoupling(ServiceEnum.getCouplingFromValue1(i));
    }

    public void readEdgeSlope() {
        setEdgeSlope(ServiceEnum.getEdgeSlopeFromValue1(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_EDGE_WHEN)));
    }

    public void saveEdgeSlope(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_EDGE_WHEN, i);
        setEdgeSlope(ServiceEnum.getEdgeSlopeFromValue1(i));
    }

    public void saveSweep(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SWEEP, i);
        setNMode(i);
    }

    public void readEdgeSweep() {
        setNMode(API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_SWEEP));
    }

    public void saveholdOff(long j) {
        setHoldOff(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_HOLDOFF, j);
    }

    public void readHoldOff() {
        setHoldOff(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_HOLDOFF));
    }

    public float readprobeRatio(ServiceEnum.Chan chan) {
        if (chan == ServiceEnum.Chan.chan1) {
            return API.getInstance().UI_QueryFloat(1, MessageID.MSG_PROBE_RATIO);
        }
        if (chan == ServiceEnum.Chan.chan2) {
            return API.getInstance().UI_QueryFloat(2, MessageID.MSG_PROBE_RATIO);
        }
        if (chan == ServiceEnum.Chan.chan3) {
            return API.getInstance().UI_QueryFloat(3, MessageID.MSG_PROBE_RATIO);
        }
        if (chan == ServiceEnum.Chan.chan4) {
            return API.getInstance().UI_QueryFloat(4, MessageID.MSG_PROBE_RATIO);
        }
        return 1.0f;
    }

    public void saveButtonLevel() {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LEVEL_Z, 0);
    }

    public void saveButtonLevelA() {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_BUTTON_LEVEL, 0);
    }

    public void saveButtonLevelB() {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_BUTTON_LEVEL, 1);
    }

    public int readTriggerType() {
        return API.getInstance().UI_QueryInt32(41, MessageID.MSG_TRIGGER_TYPE);
    }

    public long readLevel() {
        return API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
    }

    public void savePulseSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_PULSE_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void savePulseWhen(ServiceEnum.EMoreThan eMoreThan) {
        setEMoreThan(eMoreThan);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_PULSE_WHEN, eMoreThan.value1);
    }

    public void savePulsePolarity(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        setPolarity(triggerPulsePolarity);
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_PULSE_POLARITY, triggerPulsePolarity.value1);
    }

    public void savePulseUperLimit(long j) {
        setUperLimit(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_PULSE_UPPER, j);
    }

    public void savePulseLowerLimit(long j) {
        setLowerLimit(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_PULSE_LOWER, j);
    }

    public void saveSlopeSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SLOPE_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveSlopeLevelSelect(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SLOPE_LEVELSELECT, i);
        setSlopeTrigger_Level_ID(ServiceEnum.getTrigger_Level_IDFromValue1(i));
    }

    public void saveSlopeWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SLOPE_WHEN, i);
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(i));
    }

    public void saveSlope(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SLOPE_POLARITY, i);
        setSlope(ServiceEnum.getEdgeSlopeFromValue1(i));
    }

    public void saveSlopeUperLimit(long j) {
        setSlopeUperLimit(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_SLOPE_UPPER, j);
    }

    public void saveSlopeLowerLimit(long j) {
        setSlopeLowerLimit(j);
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_SLOPE_LOWER, j);
    }

    public void saveVideoSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_VIDEO_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveVideoLines(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_VIDEO_SYNC, i);
        setVideoSync(ServiceEnum.getTrigger_Video_SyncFromValue1(i));
    }

    public void saveVideoPolarity(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_VIDEO_POLARITY, i);
        setVideoPolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(i));
    }

    public void saveVideoFormat(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_VIDEO_STANDARD, i);
        setVideoFormat(ServiceEnum.getTrigger_Video_FormatFromValue1(i));
    }

    public void savePatternSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_PATTERN_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void savePatternCode(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_PATTERN_CODE, i);
    }

    public void saveDurationSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_DURATION_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveDurationWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_DURATION_WHEN, i);
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(i));
    }

    public void saveDurationCode(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_DURATION_CODE, i);
    }

    public void saveDurationUperLimit(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_DURATION_UPPER, j);
        setDurationUperLimit(j);
    }

    public void saveDurationLowerLimit(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_DURATION_LOWER, j);
        setDurationLowerLimit(j);
    }

    public void saveTimeoutSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_TIMEOUT_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveTimeoutSlope(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_TIMEOUT_SLOPE, i);
        setTimeoutSlope(ServiceEnum.getEdgeSlopeFromValue1(i));
    }

    public void saveTimeoutValue(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_TIMEOUT_TIME, j);
        setTimeOut(j);
    }

    public void saveRuntSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RUNT_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveRuntLevelSelect(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RUNT_LEVELSELECT, i);
        setRuntTrigger_Level_ID(ServiceEnum.getTrigger_Level_IDFromValue1(i));
    }

    public void saveRuntWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RUNT_WHEN, i);
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(i));
    }

    public void saveRuntPolarity(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RUNT_POLARITY, i);
        setRuntPolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(i));
    }

    public void saveRuntUpper(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_RUNT_UPPER, j);
        setRuntUperLimit(j);
    }

    public void saveRuntLower(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_RUNT_LOWER, j);
        setRuntLowerLimit(j);
    }

    public void saveOverSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_OVER_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveOverSlope(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_OVER_SLOPE, i);
        setOverSlope(ServiceEnum.getEdgeSlopeFromValue1(i));
    }

    public void saveOverEvent(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_OVER_POS, i);
        setOverEvent(ServiceEnum.getOverEventFromValue1(i));
    }

    public void saveOverSelect(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_OVER_LEVELSELECT, i);
        setOverTrigger_Level_ID(ServiceEnum.getTrigger_Level_IDFromValue1(i));
    }

    public void saveOverTimeValue(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_OVER_TIME, j);
        setOverTime(j);
    }

    public void saveDelaySourceA(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_DELAY_SRCA, i);
        setDelayChanA(ServiceEnum.getChanFromValue1(i));
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveDelaySourceB(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_DELAY_SRCB, i);
        setDelayChanB(ServiceEnum.getChanFromValue1(i));
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveDelayWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_DELAY_WHEN, i);
        setEMoreThan(ServiceEnum.getEMoreThanFromValue1(i));
    }

    public void saveDelaySlopeA(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_DELAY_EDGA, z);
        setEdgeSlopeA(ServiceEnum.getEdgeSlopeFromValue1(z ? 1 : 0));
    }

    public void saveDelaySlopeB(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_DELAY_EDGB, z);
        setEdgeSlopeB(ServiceEnum.getEdgeSlopeFromValue1(z ? 1 : 0));
    }

    public void saveDelayUpperLimit(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_DELAY_UPPER, j);
        setDelayUperLimit(j);
    }

    public void saveDelayLowerLimit(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_DELAY_LOWER, j);
        setDelayLowerLimit(j);
    }

    public void saveSetupHold(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SETUP_WHEN, i);
        setSHEvent(ServiceEnum.getSHEventFromValue1(i));
    }

    public void saveSetupHoldSlope(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_SETUP_SLOPE, z);
        setSetupHoldSlope(ServiceEnum.getEdgeSlopeFromValue1(z ? 1 : 0));
    }

    public void saveSetupHoldData(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_SETUP_DATA, z);
        setSetupHoldPolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(z ? 1 : 0));
    }

    public void saveSourceClock(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SETUP_SCL, i);
        setChan(ServiceEnum.getChanFromValue1(i));
        setSetupHoldChanA(ServiceEnum.getChanFromValue1(i));
    }

    public void saveSourceData(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SETUP_SDA, i);
        setChan(ServiceEnum.getChanFromValue1(i));
        setSetupHoldChanB(ServiceEnum.getChanFromValue1(i));
    }

    public void saveSetupValue(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_SETUP_TIME, j);
        setSetup(j);
    }

    public void saveHoldValue(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_HOLD_TIME, j);
        setHold(j);
    }

    public void saveNthSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_NTH_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveNthSlope(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_NTH_SLOPE, z);
        setNthSlope(z ? ServiceEnum.EdgeSlope.Trigger_Edge_Falling : ServiceEnum.EdgeSlope.Trigger_Edge_Rising);
    }

    public void saveNthIdleTime(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_NTH_IDLETIME, j);
        setIdelTime(j);
    }

    public void saveRs232Source(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RS232_SOURCE_LA, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveRs232Polarity(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_RS232_POLARITY, z);
        setPulsePolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(z ? 1 : 0));
    }

    public void saveRs232When(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RS232_WHEN, i);
        setTrigger_RS232_When(ServiceEnum.getTrigger_RS232_WhenFromValue1(i));
    }

    public void saveRs232Stop(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RS232_STOPBIT, i);
        setTrigger_RS232_Stop(ServiceEnum.getTrigger_RS232_StopFromValue1(i));
    }

    public void saveRs232Parity(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RS232_CHECK, i);
        setTrigger_RS232_Parity(ServiceEnum.getTrigger_RS232_ParityFromValue1(i));
    }

    public void saveRs232BaudRate(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RS232_BAUDRATE, i);
        setRs232BaudRate(i);
    }

    public void saveRs232Width(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_RS232_DATAWIDTH, i);
        setTrigger_RS232_Width(ServiceEnum.getTrigger_RS232_WidthFromValue1(i));
    }

    public void saveCanSamplePoints(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_SAMPLE_POINT, i);
        setSamplePoints(i);
    }

    public void saveCanFdSamplePoints(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_FD_SAMPLE_POINT, i);
        setFdSamplePoints(i);
    }

    public void saveCanWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_WHEN, i);
        setTrigger_Serv_Can_When(ServiceEnum.getTrigger_Serv_Can_WhenFromValue1(i));
    }

    public void saveCanSignal(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_SINGNAL, i);
        setTrigger_Can_Phy(ServiceEnum.getTrigger_Can_PhyFromValue1(i));
    }

    public void saveCanDefine(boolean z) {
        if (z) {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_DEFINE, 1);
        } else {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_DEFINE, 0);
        }
        setCanDefine(z);
    }

    public void saveCanIdExtendedValue(boolean z) {
        if (z) {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_ID_EXTENDED, 1);
        } else {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_ID_EXTENDED, 0);
        }
        setIdExtended(z);
    }

    public void saveCanSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_CAN_SOURCE_LA, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveLinSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LIN_SOURCE_LA, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveLinErrorType(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LIN_ERR_TYPE, i);
        setTrigger_Lin_Err(ServiceEnum.getTrigger_Lin_ErrFromValue1(i));
    }

    public void saveLinSamplePoints(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LIN_SAMPLE_POINT, i);
        setLinSamplePosition(i);
    }

    public void saveLinWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LIN_WHEN, i);
        setTrigger_Lin_When(ServiceEnum.getTrigger_Lin_WhenFromValue1(i));
    }

    public void saveLinVersion(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_LIN_VERSION, i);
        setTrigger_Lin_Ver(ServiceEnum.getTrigger_Lin_VerFromValue1(i));
    }

    public void saveSpiTimeout(long j) {
        API.getInstance().UI_PostInt64(41, MessageID.MSG_TRIGGER_SPI_TIMEOUT, j);
        setSpiTimeOut(j);
    }

    public void saveSpiSourceScl(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SPI_SCL, i);
        setChan(ServiceEnum.getChanFromValue1(i));
        setSpiChanA(ServiceEnum.getChanFromValue1(i));
    }

    public void saveSpiSourceSda(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SPI_SDA, i);
        setChan(ServiceEnum.getChanFromValue1(i));
        setSpiChanB(ServiceEnum.getChanFromValue1(i));
    }

    public void saveSpiSourceCs(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_SPI_CS, i);
        setChan(ServiceEnum.getChanFromValue1(i));
        setSpiChanC(ServiceEnum.getChanFromValue1(i));
    }

    public void saveSpiCsMode(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_SPI_CSMODE, z);
        setPulsePolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(z ? 1 : 0));
    }

    public void saveSpiTimeout(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_SPI_WHEN, z);
        setTrigger_Spi_CS(ServiceEnum.getTrigger_Spi_CSFromValue1(z ? 1 : 0));
    }

    public void saveSpiSlope(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_SPI_SLOPE, z);
        setSpiSlope(z ? ServiceEnum.EdgeSlope.Trigger_Edge_Falling : ServiceEnum.EdgeSlope.Trigger_Edge_Rising);
    }

    public void saveI2cAddrWidthValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_I2C_ADDRDATA_BITS, i);
        setTrigger_I2C_Spec(ServiceEnum.getTrigger_I2C_SpecFromValue1(i));
    }

    public void saveI2cDirectionValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_I2C_DIRECTION, i);
        setTrigger_I2C_WR(ServiceEnum.getTrigger_I2C_WRFromValue1(i));
    }

    public void saveI2cSourceSda(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_I2C_SDA, i);
        setIicChanB(ServiceEnum.getChanFromValue1(i));
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveI2cSourceScl(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_I2C_SCL, i);
        setIicChanA(ServiceEnum.getChanFromValue1(i));
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveI2cWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_I2C_WHEN, i);
        setTrigger_I2C_When(ServiceEnum.getTrigger_I2C_WhenFromValue1(i));
    }

    public void saveFlexrayDownCycValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_MIN, i);
        setCompareLowerLimit(i);
    }

    public void saveFlexrayUpCycValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_MAX, i);
        setCompareUperLimit(i);
    }

    public void saveFlexrayDownIdValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MIN, i);
        setIdLowerLimit(i);
    }

    public void saveFlexrayUpIdValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_MAX, i);
        setIdUperLimit(i);
    }

    public void saveFlexrayCycCompValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CYC_COMP, i);
        setTrigger_IIS_data_cmp_Cyc(ServiceEnum.getTrigger_IIS_data_cmpFromValue1(i));
    }

    public void saveFlexrayIdCompValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ID_COMP, i);
        setTrigger_IIS_data_cmp_ID(ServiceEnum.getTrigger_IIS_data_cmpFromValue1(i));
    }

    public void saveFlexrayErrorValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_ERROR_TYPE, i);
        setTrigger_Flex_Err(ServiceEnum.getTrigger_Flex_ErrFromValue1(i));
    }

    public void saveFlexraySymbolValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_SYMBOL_TYPE, i);
        setTrigger_Flex_Symbol(ServiceEnum.getTrigger_Flex_SymbolFromValue1(i));
    }

    public void saveFlexrayFrameValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_FRAME_TYPE, i);
        setTrigger_Flex_Frame(ServiceEnum.getTrigger_Flex_FrameFromValue1(i));
    }

    public void saveFlexrayPostTypeValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_POST_TYPE, i);
        setTrigger_Flex_Pos(ServiceEnum.getTrigger_Flex_PosFromValue1(i));
    }

    public void saveFlexrayBaudValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_BAUD, i);
        setTrigger_Flex_Baud(ServiceEnum.getTrigger_Flex_BaudFromValue1(i));
    }

    public void saveFlexraySource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_SOURCE_LA, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveFlexrayDefine(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_FLEXRAY_DEFINE, z);
        setDefine(z);
    }

    public void saveFlexrayWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_WHEN, i);
        setTrigger_Flex_When(ServiceEnum.getTrigger_Flex_WhenFromValue1(i));
    }

    public void saveFlexrayChanceValue(boolean z) {
        if (z) {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CH_A_B, 1);
        } else {
            API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_FLEXRAY_CH_A_B, 0);
        }
        setTrigger_Flex_Phy(ServiceEnum.getTrigger_Flex_PhyFromValue1(z ? 1 : 0));
    }

    public void saveI2sAllWidthValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_WIDTH, i);
        setAllWidth(i);
    }

    public void saveI2sWidthValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_USER_WIDTH, i);
        setWidth(i);
    }

    public void saveI2sAlignmentValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_ALIGNMENT, i);
        setTrigger_IIS_Spec(ServiceEnum.getTrigger_IIS_SpecFromValue1(i));
    }

    public void saveI2sAudioValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_WS_LOW, i);
        setTrigger_IIS_Ch(ServiceEnum.getTrigger_IIS_ChFromValue1(i));
    }

    public void saveI2sEdgeValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_SLOPE, i);
        setIisSlope(ServiceEnum.getEdgeSlopeFromValue1(i));
    }

    public void saveSourceSda(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_SDA, i);
        setChan(ServiceEnum.getChanFromValue1(i));
        setIisChanC(ServiceEnum.getChanFromValue1(i));
    }

    public void saveSourceWs(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_WS, i);
        setChan(ServiceEnum.getChanFromValue1(i));
        setIisChanB(ServiceEnum.getChanFromValue1(i));
    }

    public void saveSourceScl(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_SCLK, i);
        setChan(ServiceEnum.getChanFromValue1(i));
        setIisChanA(ServiceEnum.getChanFromValue1(i));
    }

    public void saveIisWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_IIS_WHEN, i);
        setTrigger_IIS_data_cmp(ServiceEnum.getTrigger_IIS_data_cmpFromValue1(i));
    }

    public void saveMilstdErrorValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_ERR_TYPE, i);
        setTrigger_1553_Err(ServiceEnum.getTrigger_1553_ErrFromValue1(i));
    }

    public void saveMilstdSyncValue(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_SYNC_TYPE, i);
        setTrigger_1553_Sync(ServiceEnum.getTrigger_1553_SyncFromValue1(i));
    }

    public void saveMilstdSource(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_SOURCE, i);
        setChan(ServiceEnum.getChanFromValue1(i));
    }

    public void saveMilstdCompare(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_DATA_COMP, i);
        setTrigger_value_cmp(ServiceEnum.getTrigger_value_cmpFromValue1(i));
    }

    public void saveMilstdWhen(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_WHEN, i);
        setTrigger_1553_When(ServiceEnum.getTrigger_1553_WhenFromValue1(i));
    }

    public void saveMilstdLevelSelect(int i) {
        API.getInstance().UI_PostInt32(41, MessageID.MSG_TRIGGER_1553B_LEVELSELECT, i);
        setMilstdTrigger_Level_ID(ServiceEnum.getTrigger_Level_IDFromValue1(i));
    }

    public void saveMilstdPolarity(boolean z) {
        API.getInstance().UI_PostBool(41, MessageID.MSG_TRIGGER_1553B_POLARITY, z);
        setPulsePolarity(ServiceEnum.getTriggerPulsePolarityFromValue1(z ? 1 : 0));
    }

    public void checkLevel() {
        ServiceEnum.Chan chan = getChan();
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(chan.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(chan.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
        double d = UI_QueryInt64;
        double d2 = UI_QueryInt642;
        long j = (long) ((d * 4.5d) - d2);
        long j2 = (long) ((d * (-4.5d)) - d2);
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Slope) {
            long UI_QueryInt643 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_H);
            long UI_QueryInt644 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SLOPE_LEVEL_L);
            if (UI_QueryInt643 > j) {
                setSlopelevelA(j);
            } else {
                setSlopelevelA(UI_QueryInt643);
            }
            if (UI_QueryInt644 < j2) {
                setSlopelevelB(j2);
            } else {
                setSlopelevelB(UI_QueryInt644);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Runt) {
            long UI_QueryInt645 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_H);
            long UI_QueryInt646 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_RUNT_LEVEL_L);
            if (UI_QueryInt645 > j) {
                setRuntlevelA(j);
            } else {
                setRuntlevelA(UI_QueryInt645);
            }
            if (UI_QueryInt646 < j2) {
                setRuntlevelB(j2);
            } else {
                setRuntlevelB(UI_QueryInt646);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Over) {
            long UI_QueryInt647 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_H);
            long UI_QueryInt648 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_OVER_LEVEL_L);
            if (UI_QueryInt647 > j) {
                setOverlevelA(j);
            } else {
                setOverlevelA(UI_QueryInt647);
            }
            if (UI_QueryInt648 < j2) {
                setOverlevelB(j2);
            } else {
                setOverlevelB(UI_QueryInt648);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
            long UI_QueryInt649 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_H);
            long UI_QueryInt6410 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_1553B_LEVEL_L);
            if (UI_QueryInt649 > j) {
                setMilstdlevelA(j);
            } else {
                setMilstdlevelA(UI_QueryInt649);
            }
            if (UI_QueryInt6410 < j2) {
                setMilstdlevelB(j2);
            } else {
                setMilstdlevelB(UI_QueryInt6410);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Delay) {
            long UI_QueryInt6411 = API.getInstance().UI_QueryInt64(this.delayChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6412 = API.getInstance().UI_QueryInt64(this.delayChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j3 = (UI_QueryInt6411 * 5) - UI_QueryInt6412;
            long j4 = (UI_QueryInt6411 * (-5)) - UI_QueryInt6412;
            long UI_QueryInt6413 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_DELAY_LEVEL_H);
            if (this.delayChanA.value1 > ServiceEnum.Chan.chan4.value1 && this.delayChanA.value1 <= ServiceEnum.Chan.d15.value1) {
                setDelaylevelA(UI_QueryInt6413);
            } else if (UI_QueryInt6413 > j3) {
                setDelaylevelA(j3);
            } else if (UI_QueryInt6413 < j4) {
                setDelaylevelA(j4);
            } else {
                setDelaylevelA(UI_QueryInt6413);
            }
            long UI_QueryInt6414 = API.getInstance().UI_QueryInt64(this.delayChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6415 = API.getInstance().UI_QueryInt64(this.delayChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j5 = (5 * UI_QueryInt6414) - UI_QueryInt6415;
            long j6 = (UI_QueryInt6414 * (-5)) - UI_QueryInt6415;
            long UI_QueryInt6416 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_DELAY_LEVEL_L);
            if (this.delayChanB.value1 > ServiceEnum.Chan.chan4.value1 && this.delayChanB.value1 <= ServiceEnum.Chan.d15.value1) {
                setDelaylevelB(UI_QueryInt6416);
            } else if (UI_QueryInt6416 > j5) {
                setDelaylevelB(j5);
            } else if (UI_QueryInt6416 < j6) {
                setDelaylevelB(j6);
            } else {
                setDelaylevelB(UI_QueryInt6416);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Setup) {
            long UI_QueryInt6417 = API.getInstance().UI_QueryInt64(this.setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6418 = API.getInstance().UI_QueryInt64(this.setupHoldChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j7 = (UI_QueryInt6417 * 5) - UI_QueryInt6418;
            long j8 = (UI_QueryInt6417 * (-5)) - UI_QueryInt6418;
            long UI_QueryInt6419 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SETUP_LEVEL_L);
            if (this.setupHoldChanA.value1 > ServiceEnum.Chan.chan4.value1 && this.setupHoldChanA.value1 <= ServiceEnum.Chan.d15.value1) {
                setSetupHoldlevelA(UI_QueryInt6419);
            } else if (UI_QueryInt6419 > j7) {
                setSetupHoldlevelA(j7);
            } else if (UI_QueryInt6419 < j8) {
                setSetupHoldlevelA(j8);
            } else {
                setSetupHoldlevelA(UI_QueryInt6419);
            }
            long UI_QueryInt6420 = API.getInstance().UI_QueryInt64(this.setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6421 = API.getInstance().UI_QueryInt64(this.setupHoldChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j9 = (5 * UI_QueryInt6420) - UI_QueryInt6421;
            long j10 = (UI_QueryInt6420 * (-5)) - UI_QueryInt6421;
            long UI_QueryInt6422 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SETUP_LEVEL_H);
            if (this.setupHoldChanB.value1 > ServiceEnum.Chan.chan4.value1 && this.setupHoldChanB.value1 <= ServiceEnum.Chan.d15.value1) {
                setSetupHoldlevelB(UI_QueryInt6422);
            } else if (UI_QueryInt6422 > j9) {
                setSetupHoldlevelB(j9);
            } else if (UI_QueryInt6422 < j10) {
                setSetupHoldlevelB(j10);
            } else {
                setSetupHoldlevelB(UI_QueryInt6422);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_I2C) {
            long UI_QueryInt6423 = API.getInstance().UI_QueryInt64(this.iicChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6424 = API.getInstance().UI_QueryInt64(this.iicChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j11 = (UI_QueryInt6423 * 5) - UI_QueryInt6424;
            long j12 = (UI_QueryInt6423 * (-5)) - UI_QueryInt6424;
            long UI_QueryInt6425 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2C_LEVEL_CLK);
            if (this.iicChanA.value1 > ServiceEnum.Chan.chan4.value1 && this.iicChanA.value1 <= ServiceEnum.Chan.d15.value1) {
                setIiclevelA(UI_QueryInt6425);
            } else if (UI_QueryInt6425 > j11) {
                setIiclevelA(j11);
            } else if (UI_QueryInt6425 < j12) {
                setIiclevelA(j12);
            } else {
                setIiclevelA(UI_QueryInt6425);
            }
            long UI_QueryInt6426 = API.getInstance().UI_QueryInt64(this.iicChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6427 = API.getInstance().UI_QueryInt64(this.iicChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j13 = (5 * UI_QueryInt6426) - UI_QueryInt6427;
            long j14 = (UI_QueryInt6426 * (-5)) - UI_QueryInt6427;
            long UI_QueryInt6428 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2C_LEVEL_DATA);
            if (this.iicChanB.value1 > ServiceEnum.Chan.chan4.value1 && this.iicChanB.value1 <= ServiceEnum.Chan.d15.value1) {
                setIiclevelB(UI_QueryInt6428);
            } else if (UI_QueryInt6428 > j13) {
                setIiclevelB(j13);
            } else if (UI_QueryInt6428 < j14) {
                setIiclevelB(j14);
            } else {
                setIiclevelB(UI_QueryInt6428);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_SPI) {
            long UI_QueryInt6429 = API.getInstance().UI_QueryInt64(this.spiChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6430 = API.getInstance().UI_QueryInt64(this.spiChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j15 = (UI_QueryInt6429 * 5) - UI_QueryInt6430;
            long j16 = (UI_QueryInt6429 * (-5)) - UI_QueryInt6430;
            long UI_QueryInt6431 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_CLK);
            if (this.spiChanA.value1 > ServiceEnum.Chan.chan4.value1 && this.spiChanA.value1 <= ServiceEnum.Chan.d15.value1) {
                setSpilevelA(UI_QueryInt6431);
            } else if (UI_QueryInt6431 > j15) {
                setSpilevelA(j15);
            } else if (UI_QueryInt6431 < j16) {
                setSpilevelA(j16);
            } else {
                setSpilevelA(UI_QueryInt6431);
            }
            long UI_QueryInt6432 = API.getInstance().UI_QueryInt64(this.spiChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6433 = API.getInstance().UI_QueryInt64(this.spiChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j17 = (UI_QueryInt6432 * 5) - UI_QueryInt6433;
            long j18 = (UI_QueryInt6432 * (-5)) - UI_QueryInt6433;
            long UI_QueryInt6434 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_DATA);
            if (this.spiChanB.value1 > ServiceEnum.Chan.chan4.value1 && this.spiChanB.value1 <= ServiceEnum.Chan.d15.value1) {
                setSpilevelB(UI_QueryInt6434);
            } else if (UI_QueryInt6434 > j17) {
                setSpilevelB(j17);
            } else if (UI_QueryInt6434 < j18) {
                setSpilevelB(j18);
            } else {
                setSpilevelB(UI_QueryInt6434);
            }
            long UI_QueryInt6435 = API.getInstance().UI_QueryInt64(this.spiChanC.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6436 = API.getInstance().UI_QueryInt64(this.spiChanC.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j19 = (5 * UI_QueryInt6435) - UI_QueryInt6436;
            long j20 = (UI_QueryInt6435 * (-5)) - UI_QueryInt6436;
            long UI_QueryInt6437 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_SPI_LEVEL_CS);
            if (this.spiChanC.value1 > ServiceEnum.Chan.chan4.value1 && this.spiChanC.value1 <= ServiceEnum.Chan.d15.value1) {
                setSpilevelC(UI_QueryInt6437);
            } else if (UI_QueryInt6437 > j19) {
                setSpilevelC(j19);
            } else if (UI_QueryInt6437 < j20) {
                setSpilevelC(j20);
            } else {
                setSpilevelC(UI_QueryInt6437);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_I2S) {
            long UI_QueryInt6438 = API.getInstance().UI_QueryInt64(this.iisChanA.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6439 = API.getInstance().UI_QueryInt64(this.iisChanA.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j21 = (UI_QueryInt6438 * 5) - UI_QueryInt6439;
            long j22 = (UI_QueryInt6438 * (-5)) - UI_QueryInt6439;
            long UI_QueryInt6440 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_CLK);
            if (UI_QueryInt6440 > j21) {
                setIislevelA(j21);
            } else if (UI_QueryInt6440 < j22) {
                setIislevelA(j22);
            } else {
                setIislevelA(UI_QueryInt6440);
            }
            long UI_QueryInt6441 = API.getInstance().UI_QueryInt64(this.iisChanB.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6442 = API.getInstance().UI_QueryInt64(this.iisChanB.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j23 = (UI_QueryInt6441 * 5) - UI_QueryInt6442;
            long j24 = (UI_QueryInt6441 * (-5)) - UI_QueryInt6442;
            long UI_QueryInt6443 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_CS);
            if (UI_QueryInt6443 > j23) {
                setIislevelB(j23);
            } else if (UI_QueryInt6443 < j24) {
                setIislevelB(j24);
            } else {
                setIislevelB(UI_QueryInt6443);
            }
            long UI_QueryInt6444 = API.getInstance().UI_QueryInt64(this.iisChanC.value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6445 = API.getInstance().UI_QueryInt64(this.iisChanC.value1 + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j25 = (5 * UI_QueryInt6444) - UI_QueryInt6445;
            long j26 = (UI_QueryInt6444 * (-5)) - UI_QueryInt6445;
            long UI_QueryInt6446 = API.getInstance().UI_QueryInt64(41, MessageID.MSG_SCPI_I2S_LEVEL_DATA);
            if (UI_QueryInt6446 > j25) {
                setIislevelC(j25);
            } else if (UI_QueryInt6446 < j26) {
                setIislevelC(j26);
            } else {
                setIislevelC(UI_QueryInt6446);
            }
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_Edge && (getCoupling() == ServiceEnum.Coupling.AC || getCoupling() == ServiceEnum.Coupling.LF)) {
            double UI_QueryInt6447 = API.getInstance().UI_QueryInt64(getChan().value1 + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long j27 = (long) (4.5d * UI_QueryInt6447);
            long j28 = (long) (UI_QueryInt6447 * (-4.5d));
            long UI_QueryInt6448 = API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
            if (UI_QueryInt6448 > j27) {
                setLevel(j27);
            } else if (UI_QueryInt6448 < j28) {
                setLevel(j28);
            } else {
                setLevel(UI_QueryInt6448);
            }
        } else {
            long UI_QueryInt6449 = API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_LEVEL);
            if (getChan().value1 < ServiceEnum.Chan.chan1.value1 || getChan().value1 > ServiceEnum.Chan.chan4.value1) {
                return;
            }
            if (UI_QueryInt6449 > j) {
                setLevel(j);
            } else if (UI_QueryInt6449 < j2) {
                setLevel(j2);
            } else {
                setLevel(UI_QueryInt6449);
            }
        }
    }

    public void postWay(int i, int i2, int i3) {
        API.getInstance().UI_PostInt32(i, i2, i3);
    }

    @Bindable
    public int getI2sDataType() {
        return this.i2sDataType;
    }

    public void setI2sDataType(int i) {
        this.i2sDataType = i;
        notifyPropertyChanged(394);
    }

    @Bindable
    public int getCanDataIdType() {
        return this.canDataIdType;
    }

    public void setCanDataIdType(int i) {
        this.canDataIdType = i;
        notifyPropertyChanged(137);
    }

    @Bindable
    public int getMilstdDataType() {
        return this.milstdDataType;
    }

    public void setMilstdDataType(int i) {
        this.milstdDataType = i;
        notifyPropertyChanged(537);
    }

    public int isShow() {
        int width;
        int width2;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            width = getDataBits();
            width2 = getDataBits() / 4;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (getCanDataIdType() == 1) {
                return getIdExtended() ? 1 : 3;
            }
            return 0;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            width = getWidth();
            width2 = getWidth() / 4;
        } else {
            if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                if (getMilstdDataType() == 2) {
                    return 1;
                }
                if (getMilstdDataType() == 3) {
                    return 3;
                }
            }
            return 0;
        }
        return width - (width2 * 4);
    }

    public String getDataHex() {
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_I2C) {
            return getFormatValue1Str().substring(5);
        }
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_SPI) {
            return getFormatValue2Str().substring(5);
        }
        if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (getCanDataIdType() == 0) {
                return getFormatValue3DataStr().substring(5);
            }
            return getFormatValue3IdStr().substring(5);
        } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_LIN) {
            return getFormatValue4Str().substring(5);
        } else {
            if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_I2S) {
                if (getI2sDataType() == 0) {
                    return getFormatValue5Str().substring(5);
                }
                if (getI2sDataType() == 1) {
                    return getFormatValue5MinStr().substring(5);
                }
                return getI2sDataType() == 2 ? getFormatValue5MaxStr().substring(5) : "XXXXXXXX";
            } else if (this.triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
                if (getMilstdDataType() == 0) {
                    return getFormatValue6MaxStr().substring(5);
                }
                if (getMilstdDataType() == 1) {
                    return getFormatValue6Str().substring(5);
                }
                if (getMilstdDataType() == 2) {
                    return getFormatValue6RtaStr().substring(5);
                }
                return getMilstdDataType() == 3 ? getFormatValue6BitStr().substring(5) : "XXXXXXXX";
            } else {
                return "XXXXXXXX";
            }
        }
    }

    public String getAllDataBinary() {
        String str = "";
        int i = 0;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            String binaryString = Long.toBinaryString(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_I2C_DATA));
            int length = binaryString.length();
            if (binaryString.length() % 8 != 0) {
                for (int i2 = 0; i2 < 8 - (length % 8); i2++) {
                    binaryString = "0" + binaryString;
                }
            }
            int length2 = binaryString.length() / 8;
            if (length2 < getByteLength()) {
                for (int i3 = 0; i3 < (getByteLength() - length2) * 8; i3++) {
                    binaryString = "0" + binaryString;
                }
            }
            char[] charArray = binaryString.toCharArray();
            while (i < charArray.length) {
                if (i % 8 == 0 && i != 0) {
                    str = str + " ";
                }
                str = str + charArray[i];
                i++;
            }
            return str;
        }
        int i4 = 1;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            String binaryString2 = Long.toBinaryString(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SPI_DATA));
            int length3 = binaryString2.length();
            if (length3 < getDataBits()) {
                while (i < getDataBits() - length3) {
                    binaryString2 = "0" + binaryString2;
                    i++;
                }
            }
            char[] charArray2 = binaryString2.toCharArray();
            for (int length4 = charArray2.length - 1; length4 >= 0; length4--) {
                str = str + charArray2[length4];
                if (i4 % 8 == 0 && i4 != charArray2.length) {
                    str = str + " ";
                }
                i4++;
            }
            return new StringBuffer(str).reverse().toString();
        }
        int i5 = 11;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            String binaryString3 = Long.toBinaryString(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_CAN_DATA));
            int length5 = binaryString3.length();
            int dataByte = getDataByte() * 8;
            if (getCanDataIdType() != 1) {
                i5 = dataByte;
            } else if (getIdExtended()) {
                i5 = 29;
            }
            if (length5 < i5) {
                while (i < i5 - length5) {
                    binaryString3 = "0" + binaryString3;
                    i++;
                }
            }
            char[] charArray3 = binaryString3.toCharArray();
            for (int length6 = charArray3.length - 1; length6 >= 0; length6--) {
                str = str + charArray3[length6];
                if (i4 % 8 == 0 && i4 != charArray3.length) {
                    str = str + " ";
                }
                i4++;
            }
            return new StringBuffer(str).reverse().toString();
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_LIN_CODE_STRING);
            int length7 = UI_QueryStr.length();
            if (UI_QueryStr.length() % 8 != 0) {
                for (int i6 = 0; i6 < 8 - (length7 % 8); i6++) {
                    UI_QueryStr = "0" + UI_QueryStr;
                }
            }
            int length8 = UI_QueryStr.length() / 8;
            if (length8 < getLinByte()) {
                for (int i7 = 0; i7 < (getLinByte() - length8) * 8; i7++) {
                    UI_QueryStr = "0" + UI_QueryStr;
                }
            }
            char[] charArray4 = UI_QueryStr.toCharArray();
            while (i < charArray4.length) {
                if (i % 8 == 0 && i != 0) {
                    str = str + " ";
                }
                str = str + charArray4[i];
                i++;
            }
            return str;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            String binaryString4 = Long.toBinaryString(API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_DATA_IIS));
            int length9 = binaryString4.length();
            if (length9 < getWidth()) {
                while (i < getWidth() - length9) {
                    binaryString4 = "0" + binaryString4;
                    i++;
                }
            }
            char[] charArray5 = binaryString4.toCharArray();
            for (int length10 = charArray5.length - 1; length10 >= 0; length10--) {
                str = str + charArray5[length10];
                if (i4 % 8 == 0 && i4 != charArray5.length) {
                    str = str + " ";
                }
                i4++;
            }
            return new StringBuffer(str).reverse().toString();
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            String binaryString5 = Long.toBinaryString(API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_DATA_1553));
            int length11 = binaryString5.length();
            if (getMilstdDataType() == 2) {
                i5 = 5;
            } else if (getMilstdDataType() != 3) {
                i5 = 16;
            }
            if (length11 < i5) {
                while (i < i5 - length11) {
                    binaryString5 = "0" + binaryString5;
                    i++;
                }
            }
            char[] charArray6 = binaryString5.toCharArray();
            for (int length12 = charArray6.length - 1; length12 >= 0; length12--) {
                str = str + charArray6[length12];
                if (i4 % 8 == 0 && i4 != charArray6.length) {
                    str = str + " ";
                }
                i4++;
            }
            return new StringBuffer(str).reverse().toString();
        } else {
            return "XXXXXXXX";
        }
    }

    public String getAllDataHex() {
        char[] charArray;
        String str = "";
        int i = 0;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            String upperCase = Long.toHexString(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_I2C_DATA)).toUpperCase();
            int length = upperCase.length();
            if (upperCase.length() % 2 != 0) {
                for (int i2 = 0; i2 < 2 - (length % 2); i2++) {
                    upperCase = "0" + upperCase;
                }
            }
            int length2 = upperCase.length() / 2;
            if (length2 < getByteLength()) {
                for (int i3 = 0; i3 < (getByteLength() - length2) * 2; i3++) {
                    upperCase = "0" + upperCase;
                }
            }
            char[] charArray2 = upperCase.toCharArray();
            while (i < charArray2.length) {
                if (i % 2 == 0 && i != 0) {
                    str = str + " ";
                }
                str = str + charArray2[i];
                i++;
            }
            return str;
        }
        int i4 = 1;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            String upperCase2 = Long.toHexString(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_SPI_DATA)).toUpperCase();
            int length3 = upperCase2.length();
            int dataBits = getDataBits() / 4;
            if (getDataBits() % 4 != 0) {
                dataBits++;
            }
            if (length3 < dataBits) {
                while (i < dataBits - length3) {
                    upperCase2 = "0" + upperCase2;
                    i++;
                }
            }
            char[] charArray3 = upperCase2.toCharArray();
            for (int length4 = charArray3.length - 1; length4 >= 0; length4--) {
                str = str + charArray3[length4];
                if (i4 % 2 == 0 && i4 != charArray3.length) {
                    str = str + " ";
                }
                i4++;
            }
            return new StringBuffer(str.trim()).reverse().toString();
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            String upperCase3 = Long.toHexString(API.getInstance().UI_QueryInt64(41, MessageID.MSG_TRIGGER_CAN_DATA)).toUpperCase();
            int length5 = upperCase3.length();
            int dataByte = (getDataByte() * 4) / 2;
            if (getCanDataIdType() == 1) {
                dataByte = ((getIdExtended() ? 29 : 11) / 4) + 1;
            }
            if (length5 < dataByte) {
                while (i < dataByte - length5) {
                    upperCase3 = "0" + upperCase3;
                    i++;
                }
            }
            char[] charArray4 = upperCase3.toCharArray();
            for (int length6 = charArray4.length - 1; length6 >= 0; length6--) {
                str = str + charArray4[length6];
                if (i4 % 2 == 0 && i4 != charArray4.length) {
                    str = str + " ";
                }
                i4++;
            }
            return new StringBuffer(str).reverse().toString();
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_LIN_CODE_STRING);
            StringBuilder sb = new StringBuilder();
            for (int i5 = 0; i5 < UI_QueryStr.length(); i5 += 4) {
                int i6 = 0;
                for (int i7 = 0; i7 < 4; i7++) {
                    int i8 = i5 + i7;
                    i6 += Integer.parseInt(UI_QueryStr.substring(i8, i8 + 1)) << ((4 - i7) - 1);
                }
                sb.append(Integer.toHexString(i6));
            }
            String upperCase4 = sb.toString().toUpperCase();
            int length7 = upperCase4.length();
            if (upperCase4.length() % 2 != 0) {
                for (int i9 = 0; i9 < 2 - (length7 % 2); i9++) {
                    upperCase4 = "0" + upperCase4;
                }
            }
            int length8 = upperCase4.length() / 2;
            if (length8 < getLinByte()) {
                for (int i10 = 0; i10 < (getLinByte() - length8) * 2; i10++) {
                    upperCase4 = "0" + upperCase4;
                }
            }
            char[] charArray5 = upperCase4.toCharArray();
            while (i < charArray5.length) {
                if (i % 2 == 0 && i != 0) {
                    str = str + " ";
                }
                str = str + charArray5[i];
                i++;
            }
            return str;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            String upperCase5 = Long.toHexString(API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_DATA_IIS)).toUpperCase();
            int length9 = upperCase5.length();
            int width = getWidth() / 4;
            if (getWidth() % 4 != 0) {
                width++;
            }
            if (length9 < width) {
                while (i < width - length9) {
                    upperCase5 = "0" + upperCase5;
                    i++;
                }
            }
            char[] charArray6 = upperCase5.toCharArray();
            for (int length10 = charArray6.length - 1; length10 >= 0; length10--) {
                str = str + charArray6[length10];
                if (i4 % 2 == 0 && i4 != charArray6.length) {
                    str = str + " ";
                }
                i4++;
            }
            return new StringBuffer(str.trim()).reverse().toString();
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            String upperCase6 = Long.toHexString(API.getInstance().UI_QueryInt64(41, MessageID.CMD_SCPI_TRIGGER_DATA_1553)).toUpperCase();
            int length11 = upperCase6.length();
            int i11 = 16;
            if (getMilstdDataType() == 2) {
                i11 = 8;
            } else if (getMilstdDataType() == 3) {
                i11 = 12;
            }
            int i12 = i11 / 4;
            if (length11 < i12) {
                while (i < i12 - length11) {
                    upperCase6 = "0" + upperCase6;
                    i++;
                }
            }
            for (int length12 = upperCase6.toCharArray().length - 1; length12 >= 0; length12--) {
                str = str + charArray[length12];
                if (i4 % 2 == 0 && i4 != 0) {
                    str = str + " ";
                }
                i4++;
            }
            return new StringBuffer(str.trim()).reverse().toString();
        } else {
            return "XXXXXXXX";
        }
    }

    public String getAllXBinary() {
        int i = 0;
        String str = "";
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            while (i < getByteLength()) {
                str = str + "XXXXXXXX ";
                i++;
            }
            String trim = str.trim();
            setFormatValue1Str("[bin]" + trim);
            return trim;
        }
        int i2 = 1;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            while (i < getDataBits()) {
                String str2 = str + "X";
                if (i2 % 8 == 0) {
                    str2 = str2 + " ";
                }
                str = str2;
                i2++;
                i++;
            }
            String stringBuffer = new StringBuffer(str.trim()).reverse().toString();
            setFormatValue2Str("[bin]" + stringBuffer);
            return stringBuffer;
        }
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (getCanDataIdType() == 0) {
                while (i < getDataByte()) {
                    str = str + "XXXXXXXX ";
                    i++;
                }
                String trim2 = str.trim();
                setFormatValue3DataStr("[bin]" + trim2);
                return trim2;
            } else if (getCanDataIdType() == 1) {
                String str3 = getIdExtended() ? "XXXXX XXXXXXXX XXXXXXXX XXXXXXXX" : "XXX XXXXXXXX";
                setFormatValue3IdStr("[bin]" + str3);
                return str3;
            } else {
                return "XXXXXXXX";
            }
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            while (i < getLinByte()) {
                str = str + "XXXXXXXX ";
                i++;
            }
            String trim3 = str.trim();
            setFormatValue4Str("[bin]" + trim3);
            return trim3;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            int i3 = 1;
            while (i < getWidth()) {
                String str4 = str + "X";
                if (i3 % 8 == 0) {
                    str4 = str4 + " ";
                }
                str = str4;
                i3++;
                i++;
            }
            String stringBuffer2 = new StringBuffer(str.trim()).reverse().toString();
            if (getI2sDataType() == 0 || getI2sDataType() == 1) {
                setFormatValue5Str("[bin]" + stringBuffer2);
                setFormatValue5MinStr("[bin]" + stringBuffer2);
            } else {
                setFormatValue5MaxStr("[bin]" + stringBuffer2);
            }
            return stringBuffer2;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            if (getMilstdDataType() == 0) {
                setFormatValue6MaxStr("[bin]XXXXXXXX XXXXXXXX");
            } else if (getMilstdDataType() == 1) {
                setFormatValue6Str("[bin]XXXXXXXX XXXXXXXX");
            } else if (getMilstdDataType() == 2) {
                setFormatValue6RtaStr("[bin]XXXXX");
                return "XXXXX";
            } else if (getMilstdDataType() == 3) {
                setFormatValue6BitStr("[bin]XXX XXXXXXXX");
                return "XXX XXXXXXXX";
            } else {
                return "";
            }
            return "XXXXXXXX XXXXXXXX";
        } else {
            return "XXXXXXXX";
        }
    }

    public String getAllXHex() {
        int i = 0;
        String str = "";
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            while (i < getByteLength()) {
                str = str + "XX ";
                i++;
            }
            String trim = str.trim();
            setFormatValue1Str("[hex]" + trim);
            return trim;
        }
        int i2 = 1;
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            int dataBits = getDataBits() / 4;
            if (getDataBits() % 4 != 0) {
                dataBits++;
            }
            while (i < dataBits) {
                String str2 = str + "X";
                if (i2 % 2 == 0) {
                    str2 = str2 + " ";
                }
                str = str2;
                i2++;
                i++;
            }
            String stringBuffer = new StringBuffer(str.trim()).reverse().toString();
            setFormatValue2Str("[hex]" + stringBuffer);
            return stringBuffer;
        }
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (getCanDataIdType() == 0) {
                while (i < getDataByte()) {
                    str = str + "XX ";
                    i++;
                }
                String trim2 = str.trim();
                setFormatValue3DataStr("[bin]" + trim2);
                return trim2;
            } else if (getCanDataIdType() == 1) {
                String str3 = getIdExtended() ? "XX XX XX XX" : "X XX";
                setFormatValue3IdStr("[hex]" + str3);
                return str3;
            }
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            while (i < getLinByte()) {
                str = str + "XX ";
                i++;
            }
            String trim3 = str.trim();
            setFormatValue4Str("[hex]" + trim3);
            return trim3;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            int width = getWidth() / 4;
            if (getWidth() % 4 != 0) {
                width++;
            }
            int i3 = 1;
            while (i < width) {
                String str4 = str + "X";
                if (i3 % 2 == 0) {
                    str4 = str4 + " ";
                }
                str = str4;
                i3++;
                i++;
            }
            String stringBuffer2 = new StringBuffer(str.trim()).reverse().toString();
            if (getI2sDataType() == 0 || getI2sDataType() == 1) {
                setFormatValue5Str("[hex]" + stringBuffer2);
                setFormatValue5MinStr("[hex]" + stringBuffer2);
            } else {
                setFormatValue5MaxStr("[hex]" + stringBuffer2);
            }
            return stringBuffer2;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            if (getMilstdDataType() == 0) {
                setFormatValue6MaxStr("[hex]XX XX");
            } else if (getMilstdDataType() == 1) {
                setFormatValue6Str("[hex]XX XX");
            } else if (getMilstdDataType() == 2) {
                setFormatValue6RtaStr("[hex]XX");
                return "XX";
            } else if (getMilstdDataType() == 3) {
                setFormatValue6BitStr("[hex]X XX");
                return "X XX";
            } else {
                return "";
            }
            return "XX XX";
        }
        return "XX";
    }

    public void syncInterfaceData(int i, int i2, long j) {
        MessageBus.getInstance().onSyncData(i, i2, Long.valueOf(j));
    }

    public void setTriggerBinaryData(String str) {
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            this.formatBinaryValue1Str = str;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            this.formatBinaryValue2Str = str;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (getCanDataIdType() == 0) {
                this.formatBinaryValue3DataStr = str;
            } else {
                this.formatBinaryValue3IdStr = str;
            }
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            this.formatBinaryValue4Str = str;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            if (getI2sDataType() == 0 || getI2sDataType() == 1) {
                this.formatBinaryValue5Str = str;
                this.formatBinaryValue5MinStr = str;
                return;
            }
            this.formatBinaryValue5MaxStr = str;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            if (getMilstdDataType() == 0) {
                this.formatBinaryValue6MaxStr = str;
            } else if (getMilstdDataType() == 1) {
                this.formatBinaryValue6Str = str;
            } else if (getMilstdDataType() == 2) {
                this.formatBinaryValue6RtaStr = str;
            } else {
                this.formatBinaryValue6BitStr = str;
            }
        }
    }

    public String getTriggerBinaryData() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            if (getI2cDataType() == 0) {
                return getFormatValue1Str().substring(5);
            }
            String UI_QueryStr = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_I2C_CODE_STRING);
            if (UI_QueryStr.equals(this.formatBinaryValue1Str)) {
                UI_QueryStr = this.formatBinaryValue1Str;
            }
            String replaceAll = UI_QueryStr.replaceAll(" ", "");
            int length = replaceAll.length() / 8;
            int i = this.byteLength;
            if (length < i) {
                String str7 = "";
                for (int i2 = 0; i2 < (this.byteLength - length) * 8; i2++) {
                    str7 = "X" + str7;
                }
                str5 = str7 + replaceAll;
            } else {
                String str8 = "";
                for (int i3 = (length - i) * 8; i3 < replaceAll.length(); i3++) {
                    str8 = str8 + replaceAll.toCharArray()[i3];
                }
                str5 = str8;
            }
            for (int i4 = 0; i4 < str5.length(); i4++) {
                if (i4 % 8 == 0 && i4 != 0) {
                    str6 = str6 + " ";
                }
                str6 = str6 + str5.toCharArray()[i4];
            }
            return str6;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            if (getSpiDataType() == 0) {
                return getFormatValue2Str().substring(5);
            }
            String UI_QueryStr2 = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_SPI_CODE_STRING);
            if (this.formatBinaryValue2Str.equals(UI_QueryStr2)) {
                UI_QueryStr2 = this.formatBinaryValue2Str;
            }
            String replaceAll2 = UI_QueryStr2.replaceAll(" ", "");
            int length2 = replaceAll2.length();
            char[] charArray = replaceAll2.toCharArray();
            if (getDataBits() > length2) {
                String str9 = "";
                for (int i5 = 0; i5 < getDataBits() - length2; i5++) {
                    str9 = "X" + str9;
                }
                str4 = str9 + replaceAll2;
            } else {
                String str10 = "";
                for (int dataBits = length2 - getDataBits(); dataBits < length2; dataBits++) {
                    str10 = str10 + charArray[dataBits];
                }
                str4 = str10;
            }
            String stringBuffer = new StringBuffer(str4).reverse().toString();
            for (int i6 = 0; i6 < str4.length(); i6++) {
                if (i6 % 8 == 0 && i6 != 0) {
                    str6 = str6 + " ";
                }
                str6 = str6 + stringBuffer.toCharArray()[i6];
            }
            return new StringBuffer(str6).reverse().toString();
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (getCanDataIdType() == 0) {
                if (getCanDataType() == 0) {
                    return getFormatValue3DataStr().substring(5);
                }
                String replaceAll3 = this.formatBinaryValue3DataStr.replaceAll(" ", "");
                int length3 = replaceAll3.length() / 8;
                if (length3 < getDataByte()) {
                    String str11 = "";
                    for (int i7 = 0; i7 < (getDataByte() - length3) * 8; i7++) {
                        str11 = "X" + str11;
                    }
                    str3 = str11 + replaceAll3;
                } else {
                    String str12 = "";
                    for (int dataByte = (length3 - getDataByte()) * 8; dataByte < replaceAll3.length(); dataByte++) {
                        str12 = str12 + replaceAll3.toCharArray()[dataByte];
                    }
                    str3 = str12;
                }
                for (int i8 = 0; i8 < str3.length(); i8++) {
                    if (i8 % 8 == 0 && i8 != 0) {
                        str6 = str6 + " ";
                    }
                    str6 = str6 + str3.toCharArray()[i8];
                }
                return str6;
            } else if (getCanIdType() == 0) {
                return getFormatValue3IdStr().substring(5);
            } else {
                if (getIdExtended()) {
                    setCanIdBits(29);
                } else {
                    setCanIdBits(11);
                }
                String replaceAll4 = this.formatValue3IdStr.substring(5).replaceAll(" ", "");
                if (getIdExtended()) {
                    String str13 = "";
                    for (int i9 = 0; i9 < replaceAll4.length(); i9++) {
                        if (replaceAll4.charAt(i9) != 'X') {
                            String binaryString = Integer.toBinaryString(Integer.parseInt(replaceAll4.substring(i9, i9 + 1), 16));
                            int length4 = binaryString.length();
                            if (i9 != 0) {
                                for (int i10 = 0; i10 < 4 - length4; i10++) {
                                    binaryString = "0" + binaryString;
                                }
                            }
                            str13 = str13 + binaryString;
                        } else if (i9 == 0) {
                            str13 = str13 + "X";
                        } else {
                            str13 = str13 + "XXXX";
                        }
                    }
                    StringBuilder sb = new StringBuilder(str13);
                    sb.insert(5, " ");
                    sb.insert(14, " ");
                    sb.insert(23, " ");
                    str2 = sb.toString();
                } else {
                    String str14 = "";
                    for (int i11 = 0; i11 < replaceAll4.length(); i11++) {
                        if (replaceAll4.charAt(i11) != 'X') {
                            String binaryString2 = Integer.toBinaryString(Integer.parseInt(replaceAll4.substring(i11, i11 + 1), 16));
                            int length5 = binaryString2.length();
                            if (i11 == 0) {
                                for (int i12 = 0; i12 < 3 - length5; i12++) {
                                    binaryString2 = "0" + binaryString2;
                                }
                                binaryString2 = binaryString2 + " ";
                            } else {
                                for (int i13 = 0; i13 < 4 - length5; i13++) {
                                    binaryString2 = "0" + binaryString2;
                                }
                            }
                            str14 = str14 + binaryString2;
                        } else if (i11 == 0) {
                            str14 = str14 + "XXX ";
                        } else {
                            str14 = str14 + "XXXX";
                        }
                    }
                    str2 = str14;
                }
                return str2.equals("") ? this.formatBinaryValue3IdStr : str2;
            }
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            if (getLinDataType() == 0) {
                return getFormatValue4Str().substring(5);
            }
            String UI_QueryStr3 = API.getInstance().UI_QueryStr(41, MessageID.MSG_TRIGGER_LIN_CODE_STRING);
            if (UI_QueryStr3.equals(this.formatBinaryValue4Str)) {
                UI_QueryStr3 = this.formatBinaryValue4Str;
            }
            String replaceAll5 = UI_QueryStr3.replaceAll(" ", "");
            int length6 = replaceAll5.length() / 8;
            int i14 = this.linByte;
            if (length6 < i14) {
                String str15 = "";
                for (int i15 = 0; i15 < (this.linByte - length6) * 8; i15++) {
                    str15 = "X" + str15;
                }
                str = str15 + replaceAll5;
            } else {
                String str16 = "";
                for (int i16 = (length6 - i14) * 8; i16 < replaceAll5.length(); i16++) {
                    str16 = str16 + replaceAll5.toCharArray()[i16];
                }
                str = str16;
            }
            for (int i17 = 0; i17 < str.length(); i17++) {
                if (i17 % 8 == 0 && i17 != 0) {
                    str6 = str6 + " ";
                }
                str6 = str6 + str.toCharArray()[i17];
            }
            return str6;
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            if (getI2sDataType() == 0) {
                if (getIisDataType() == 0) {
                    return getFormatValue5Str().substring(5);
                }
                return getI2sTransformData(this.formatBinaryValue5Str);
            } else if (getI2sDataType() == 1) {
                if (getIisMinDataType() == 0) {
                    return getFormatValue5MinStr().substring(5);
                }
                return getI2sTransformData(this.formatBinaryValue5MinStr);
            } else if (getIisMaxDataType() == 0) {
                return getFormatValue5MaxStr().substring(5);
            } else {
                return getI2sTransformData(this.formatBinaryValue5MaxStr);
            }
        } else if (getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            if (getMilstdDataType() == 0) {
                if (getUpType() == 0) {
                    return getFormatValue6MaxStr().substring(5);
                }
                return this.formatBinaryValue6MaxStr;
            } else if (getMilstdDataType() == 1) {
                if (getDownType() == 0) {
                    return getFormatValue6Str().substring(5);
                }
                return this.formatBinaryValue6Str;
            } else if (getMilstdDataType() == 2) {
                if (getRtaType() == 0) {
                    return getFormatValue6RtaStr().substring(5);
                }
                return this.formatBinaryValue6RtaStr;
            } else if (getBitType() == 0) {
                return getFormatValue6BitStr().substring(5);
            } else {
                return this.formatBinaryValue6BitStr;
            }
        } else {
            return "";
        }
    }

    public String getI2sTransformData(String str) {
        String str2;
        String str3 = "";
        String replaceAll = str.replaceAll(" ", "");
        int length = replaceAll.length();
        char[] charArray = replaceAll.toCharArray();
        if (getWidth() > length) {
            String str4 = "";
            for (int i = 0; i < getWidth() - length; i++) {
                str4 = "X" + str4;
            }
            str2 = str4 + replaceAll;
        } else {
            String str5 = "";
            for (int width = length - getWidth(); width < length; width++) {
                str5 = str5 + charArray[width];
            }
            str2 = str5;
        }
        String stringBuffer = new StringBuffer(str2).reverse().toString();
        for (int i2 = 0; i2 < str2.length(); i2++) {
            if (i2 % 8 == 0 && i2 != 0) {
                str3 = str3 + " ";
            }
            str3 = str3 + stringBuffer.toCharArray()[i2];
        }
        return new StringBuffer(str3).reverse().toString();
    }

    public void rollTriggerLevel(KeyEvent keyEvent, boolean z, PanelKeyViewModel panelKeyViewModel, TriggerParam triggerParam) {
        HorizontalParam horizontalParam;
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        VerticalViewModel verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        ArrayList<VerticalParam> arrayList = new ArrayList<>();
        if (horizontalViewModel != null) {
            horizontalViewModel.getLiveData();
            horizontalParam = horizontalViewModel.getLiveData().getValue();
        } else {
            horizontalParam = null;
        }
        if (verticalViewModel != null) {
            verticalViewModel.getLiveData();
            arrayList = verticalViewModel.getLiveData().getValue();
        }
        if (z) {
            panelKeyViewModel.handleLevelCW(horizontalParam, arrayList, triggerParam, keyEvent);
        } else {
            panelKeyViewModel.handleLevelCCW(horizontalParam, arrayList, triggerParam, keyEvent);
        }
    }
}
