package com.rigol.scope.data;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DecodeParam extends BaseParam {
    private static final boolean DEFAULT_EVENT = false;
    private static final int DEFAULT_EVEN_FORMAT = 0;
    private static final int DEFAULT_FORMAT = 0;
    private static final boolean DEFAULT_LABEL = true;
    private int _1553b_polarity;
    private int _1553b_source;
    private long _1553b_thres1;
    private long _1553b_thres2;
    private AorBManager aorBManager;
    private int arinc429_baud;
    private int arinc429_byte_format;
    private long arinc429_down_thres;
    private int arinc429_singal_type;
    private int arinc429_source;
    private long arinc429_up_thres;
    private MessageAttr arincDownThresAttr;
    private MessageAttr arincUpThresAttr;
    private int bus_bitx;
    private int bus_chan;
    private int bus_graph;
    private int bus_width;
    private MessageAttr bus_widthAttr;
    private MessageAttr canBaudAttr;
    private MessageAttr canFdBaudAttr;
    private MessageAttr canFdSamplePosAttr;
    private MessageAttr canSamplePosAttr;
    private MessageAttr canThresAttr;
    private int can_baud;
    private int can_fd_baud;
    private long can_fd_samp;
    private long can_samp;
    private int can_singal;
    private int can_source;
    private long can_threas;
    private int currentItem;
    private boolean decodeIsShow;
    private boolean display;
    private boolean event;
    private int event_busx;
    private int event_format;
    private boolean event_table;
    private int event_view;
    private MessageAttr flexSamplePosAttr;
    private MessageAttr flexThresAttr;
    private int flex_baud;
    private boolean flex_channel;
    private long flex_samp;
    private int flex_signal;
    private int flex_source;
    private long flex_thres;
    private int format;
    private float guideline;
    private MessageAttr i2cClkThresAttr;
    private MessageAttr i2cDataThresAttr;
    private boolean i2c_exchange;
    private boolean i2c_read_write;
    private int i2c_scl;
    private long i2c_scl_thres;
    private int i2c_sda;
    private long i2c_sda_thres;
    private MessageAttr i2sDataThresAttr;
    private MessageAttr i2sReceiveValueAttr;
    private MessageAttr i2sSclkThresAttr;
    private MessageAttr i2sWordValueAttr;
    private MessageAttr i2sWsThresAttr;
    private int i2s_align;
    private int i2s_data;
    private boolean i2s_data_polarity;
    private long i2s_data_thres;
    private boolean i2s_endian;
    private long i2s_receive;
    private int i2s_sclock;
    private int i2s_sclock_edge;
    private long i2s_sclock_thres;
    private long i2s_wave_singal_thres;
    private long i2s_word;
    private int i2s_ws;
    private int i2s_ws_low;
    private boolean label;
    private MessageAttr linBaudAttr;
    private MessageAttr linThresAttr;
    private int lin_baud;
    private boolean lin_parity_bit;
    private boolean lin_polarity;
    private int lin_source;
    private long lin_thres;
    private int lin_version;
    private MessageAttr milstdThres1Attr;
    private MessageAttr mostThresAttr;
    private int most_signal_type;
    private int most_source;
    private long most_thres;
    private boolean noiseProject;
    private boolean onOff;
    private MessageAttr palBusThresAttr;
    private MessageAttr palClkThresAttr;
    private int pal_bus;
    private int pal_clk;
    private int pal_clk_edge;
    private int pal_clk_menu;
    private long pal_clk_thres;
    private int pal_dat_menu;
    private long pal_dat_thres;
    private boolean pal_endian;
    private boolean pal_parity;
    private boolean polarity;
    private int position;
    private long rejectTime;
    private MessageAttr rejectTimeAttr;
    private MessageAttr rs232BaudAttr;
    private int rs232_baud;
    private boolean rs232_endian;
    private boolean rs232_package;
    private int rs232_package_end;
    private int rs232_parity;
    private boolean rs232_pol;
    private int rs232_rx;
    private long rs232_rx_thres;
    private int rs232_stop;
    private int rs232_tx;
    private long rs232_tx_thres;
    private int rs232_width;
    private MessageAttr rxThresAttr;
    private MessageAttr sentNibbnumAttr;
    private MessageAttr sentThresAttr;
    private MessageAttr sentTickAttr;
    private MessageAttr sentToleranceAttr;
    private int sent_crc_format;
    private int sent_idle_state;
    private long sent_nibbnum;
    private int sent_pause_plus;
    private int sent_signal_type;
    private int sent_source;
    private long sent_thres;
    private long sent_tick;
    private long sent_tolerance;
    private boolean settings;
    private MessageAttr spiClkThresAttr;
    private MessageAttr spiCsThresAttr;
    private MessageAttr spiMisoThresAttr;
    private MessageAttr spiMosiThresAttr;
    private MessageAttr spiTimeoutAttr;
    private MessageAttr spiWidthAttr;
    private int spi_clock;
    private int spi_clock_edge;
    private long spi_clock_thres;
    private int spi_cs;
    private int spi_cs_polarity;
    private long spi_cs_thres;
    private int spi_data_polarity;
    private boolean spi_endian;
    private int spi_miso;
    private long spi_miso_thres;
    private int spi_mode;
    private int spi_mosi;
    private long spi_mosi_thres;
    private long spi_timeout;
    private long spi_width;
    private int tempPosition;
    private String title;
    private MessageAttr txThresAttr;
    private ServiceEnum.DecodeBusType type;
    private MessageAttr usbDiffHthresAttr;
    private MessageAttr usbDiffLthresAttr;
    private MessageAttr usbDpThresAttr;
    private MessageAttr usbDsThresAttr;
    private int usb_diff;
    private long usb_diff_high_thres;
    private long usb_diff_low_thres;
    private int usb_dp;
    private long usb_dp_thres;
    private int usb_ds;
    private long usb_ds_thres;
    private long usb_rate;

    public boolean getDecodeIsShow() {
        return this.decodeIsShow;
    }

    public void setDecodeIsShow(boolean z) {
        this.decodeIsShow = z;
    }

    public int getCurrentItem() {
        return this.currentItem;
    }

    public void setCurrentItem(int i) {
        this.currentItem = i;
    }

    public AorBManager getAorBManager() {
        return this.aorBManager;
    }

    public void setAorBManager(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    public int getOffset(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return 0;
                    }
                    return API.getInstance().UI_QueryInt32(4, MessageID.MSG_CHAN_OFFSET_REAL);
                }
                return API.getInstance().UI_QueryInt32(3, MessageID.MSG_CHAN_OFFSET_REAL);
            }
            return API.getInstance().UI_QueryInt32(2, MessageID.MSG_CHAN_OFFSET_REAL);
        }
        return API.getInstance().UI_QueryInt32(1, MessageID.MSG_CHAN_OFFSET_REAL);
    }

    public int getScale(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i != 4) {
                        return 0;
                    }
                    return API.getInstance().UI_QueryInt32(4, MessageID.MSG_CHAN_OFFSET_REAL);
                }
                return API.getInstance().UI_QueryInt32(3, MessageID.MSG_CHAN_OFFSET_REAL);
            }
            return API.getInstance().UI_QueryInt32(2, MessageID.MSG_CHAN_OFFSET_REAL);
        }
        return API.getInstance().UI_QueryInt32(1, MessageID.MSG_CHAN_OFFSET_REAL);
    }

    @Bindable
    public boolean isPolarity() {
        return this.polarity;
    }

    public void setPolarity(boolean z) {
        this.polarity = z;
        notifyPropertyChanged(642);
    }

    public void savePolarity(boolean z) {
        setPolarity(z);
        saveBool(MessageID.MSG_DECODE_POLARITY, z);
    }

    public void readPal_Polarity() {
        setPolarity(readBool(MessageID.MSG_DECODE_POLARITY));
    }

    public DecodeParam(String str, int i) {
        super(i);
        this.type = ServiceEnum.DecodeBusType.Decode_Parallel;
        this.decodeIsShow = false;
        this.bus_widthAttr = new MessageAttr();
        this.bus_width = 1;
        this.usb_diff = 0;
        this.guideline = 0.5f;
        this.palClkThresAttr = new MessageAttr();
        this.palBusThresAttr = new MessageAttr();
        this.rejectTimeAttr = new MessageAttr();
        this.usbDpThresAttr = new MessageAttr();
        this.usbDsThresAttr = new MessageAttr();
        this.usbDiffHthresAttr = new MessageAttr();
        this.usbDiffLthresAttr = new MessageAttr();
        this.i2cClkThresAttr = new MessageAttr();
        this.i2cDataThresAttr = new MessageAttr();
        this.spiClkThresAttr = new MessageAttr();
        this.spiMisoThresAttr = new MessageAttr();
        this.spiMosiThresAttr = new MessageAttr();
        this.spiCsThresAttr = new MessageAttr();
        this.spiWidthAttr = new MessageAttr();
        this.spiTimeoutAttr = new MessageAttr();
        this.linThresAttr = new MessageAttr();
        this.canThresAttr = new MessageAttr();
        this.canSamplePosAttr = new MessageAttr();
        this.canFdSamplePosAttr = new MessageAttr();
        this.flexThresAttr = new MessageAttr();
        this.flexSamplePosAttr = new MessageAttr();
        this.i2sSclkThresAttr = new MessageAttr();
        this.i2sWsThresAttr = new MessageAttr();
        this.i2sDataThresAttr = new MessageAttr();
        this.i2sWordValueAttr = new MessageAttr();
        this.i2sReceiveValueAttr = new MessageAttr();
        this.milstdThres1Attr = new MessageAttr();
        this.arincUpThresAttr = new MessageAttr();
        this.arincDownThresAttr = new MessageAttr();
        this.sentThresAttr = new MessageAttr();
        this.sentTickAttr = new MessageAttr();
        this.sentToleranceAttr = new MessageAttr();
        this.sentNibbnumAttr = new MessageAttr();
        this.mostThresAttr = new MessageAttr();
        this.rs232BaudAttr = new MessageAttr();
        this.canBaudAttr = new MessageAttr();
        this.canFdBaudAttr = new MessageAttr();
        this.linBaudAttr = new MessageAttr();
        this.txThresAttr = new MessageAttr();
        this.rxThresAttr = new MessageAttr();
        this.title = str;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public boolean isDisplay() {
        return this.display;
    }

    public void saveDisplay(boolean z) {
        this.display = z;
        saveBool(MessageID.MSG_DECODE_DISPLAY, z);
    }

    public boolean isSettings() {
        return this.settings;
    }

    public void saveSettings(boolean z) {
        this.settings = z;
        saveBool(MessageID.MSG_DECODE_SETTINGS, z);
    }

    @Bindable
    public boolean isPal_parity() {
        return this.pal_parity;
    }

    public void setPal_parity(boolean z) {
        this.pal_parity = z;
        notifyPropertyChanged(592);
    }

    public void savePal_parity(boolean z) {
        setPal_parity(z);
        saveBool(MessageID.MSG_DECODE_PAL_ENDIAN, z);
    }

    @Bindable
    public int getCan_singal() {
        return this.can_singal;
    }

    public void setCan_singal(int i) {
        this.can_singal = i;
        notifyPropertyChanged(147);
    }

    public void saveCan_singal(int i) {
        setCan_singal(i);
        saveInt(MessageID.MSG_DECODE_CAN_SIGNAL, i);
    }

    public void readCan_singal() {
        setCan_singal(readInt(MessageID.MSG_DECODE_CAN_SIGNAL));
    }

    @Bindable
    public long getCan_samp() {
        return this.can_samp;
    }

    public void setCan_samp(long j) {
        this.can_samp = j;
        notifyPropertyChanged(146);
    }

    public void saveCan_samp(long j) {
        setCan_samp(j);
        saveLong(MessageID.MSG_DECODE_CAN_SAMP, j);
    }

    public void readCan_samp() {
        setCan_samp(readInt(MessageID.MSG_DECODE_CAN_SAMP));
    }

    public void setTempPosition(int i) {
        this.tempPosition = i;
    }

    public int getTempPosition() {
        return this.tempPosition;
    }

    @Bindable
    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
        notifyPropertyChanged(646);
        setGuideline((250.0f - i) / 500.0f);
        syncData(MessageID.MSG_DECODE_POS, Integer.valueOf(i));
        savePosition(i);
    }

    public void savePosition(int i) {
        this.position = i;
        saveInt(MessageID.MSG_DECODE_POS, i);
    }

    public void readBus_Pos() {
        setPosition(readInt(MessageID.MSG_DECODE_POS));
    }

    @Bindable
    public ServiceEnum.DecodeBusType getType() {
        return this.type;
    }

    public void setType(ServiceEnum.DecodeBusType decodeBusType) {
        this.type = decodeBusType;
        notifyPropertyChanged(978);
        syncData(MessageID.MSG_DECODE_TYPE, decodeBusType);
    }

    public void saveType(ServiceEnum.DecodeBusType decodeBusType) {
        setType(decodeBusType);
        saveInt(MessageID.MSG_DECODE_TYPE, decodeBusType.value1);
    }

    public void readType() {
        setType(ServiceEnum.getDecodeBusTypeFromValue1(readInt(MessageID.MSG_DECODE_TYPE)));
    }

    @Bindable
    public boolean isOnOff() {
        return this.onOff;
    }

    public void setOnOff(boolean z) {
        this.onOff = z;
        notifyPropertyChanged(570);
        syncData(MessageID.MSG_DECODE_ONOFF, Boolean.valueOf(z));
    }

    public void saveOnOff(boolean z) {
        Log.e("onoff", Log.getStackTraceString(new Throwable()));
        setOnOff(z);
        saveBool(MessageID.MSG_DECODE_ONOFF, z);
    }

    public void readBus_ONOFF() {
        setOnOff(readBool(MessageID.MSG_DECODE_ONOFF));
    }

    @Bindable
    public boolean isEvent() {
        return this.event;
    }

    public void setEvent(boolean z) {
        this.event = z;
        notifyPropertyChanged(284);
        syncData(MessageID.MSG_DECODE_EVT, Boolean.valueOf(z));
    }

    public void saveEvent(boolean z) {
        setEvent(z);
        saveBool(MessageID.MSG_DECODE_EVT, z);
    }

    public void readBus_Evt() {
        setEvent(readBool(MessageID.MSG_DECODE_EVT));
    }

    @Bindable
    public boolean isNoiseProject() {
        return this.noiseProject;
    }

    public void setNoiseProject(boolean z) {
        this.noiseProject = z;
        notifyPropertyChanged(559);
    }

    public void saveNoiseProject(boolean z) {
        setNoiseProject(z);
        saveBool(MessageID.MSG_DECODE_PAL_NRJ, z);
    }

    public void readPal_Nrj() {
        setNoiseProject(readBool(MessageID.MSG_DECODE_PAL_NRJ));
    }

    @Bindable
    public long getRejectTime() {
        return this.rejectTime;
    }

    public void setRejectTime(long j) {
        this.rejectTime = j;
        notifyPropertyChanged(736);
    }

    public void saveRejectTime(long j) {
        setRejectTime(j);
        saveLong(MessageID.MSG_DECODE_NRJ_TIME, j);
    }

    public void readPal_NrjTime() {
        setRejectTime(readLong(MessageID.MSG_DECODE_NRJ_TIME));
    }

    public void readRejectTime() {
        setRejectTime(readLong(MessageID.MSG_DECODE_NRJ_TIME));
    }

    @Bindable
    public int getFormat() {
        return this.format;
    }

    public void setFormat(int i) {
        this.format = i;
        notifyPropertyChanged(334);
    }

    public void saveFormat(int i) {
        setFormat(i);
        saveInt(MessageID.MSG_DECODE_FORMAT, i);
    }

    public void readBus_Format() {
        setFormat(readInt(MessageID.MSG_DECODE_FORMAT));
    }

    @Bindable
    public boolean isLabel() {
        return this.label;
    }

    public void setLabel(boolean z) {
        this.label = z;
        notifyPropertyChanged(475);
        syncData(MessageID.MSG_DECODE_LABEL, Boolean.valueOf(z));
    }

    public void saveLabel(boolean z) {
        setLabel(z);
        saveBool(MessageID.MSG_DECODE_LABEL, z);
    }

    public void readBus_Label() {
        setLabel(readBool(MessageID.MSG_DECODE_LABEL));
    }

    @Bindable
    public int getPal_clk_menu() {
        return this.pal_clk_menu;
    }

    public void setPal_clk_menu(int i) {
        this.pal_clk_menu = i;
        notifyPropertyChanged(587);
    }

    public void savePal_clk_menu(int i) {
        setPal_clk_menu(i);
    }

    @Bindable
    public int getPal_dat_menu() {
        return this.pal_dat_menu;
    }

    public void setPal_dat_menu(int i) {
        this.pal_dat_menu = i;
        notifyPropertyChanged(589);
    }

    public void savePal_dat_menu(int i) {
        setPal_dat_menu(i);
    }

    @Bindable
    public int getPal_clk() {
        return this.pal_clk;
    }

    public void setPal_clk(int i) {
        this.pal_clk = i;
        notifyPropertyChanged(585);
    }

    public void savePal_clk(int i) {
        setPal_clk(i);
        saveInt(MessageID.MSG_DECODE_PAL_CLK, i);
    }

    public void readPal_Clk() {
        setPal_clk(readInt(MessageID.MSG_DECODE_PAL_CLK));
    }

    @Bindable
    public int getPal_clk_edge() {
        return this.pal_clk_edge;
    }

    public void setPal_clk_edge(int i) {
        this.pal_clk_edge = i;
        notifyPropertyChanged(586);
    }

    public void savePal_clk_edge(int i) {
        setPal_clk_edge(i);
        saveInt(MessageID.MSG_DECODE_PAL_CLK_EDGE, i);
    }

    public void readPal_ClkEdge() {
        setPal_clk_edge(readInt(MessageID.MSG_DECODE_PAL_CLK_EDGE));
    }

    @Bindable
    public long getPal_clk_thres() {
        return this.pal_clk_thres;
    }

    public void setPal_clk_thres(long j) {
        this.pal_clk_thres = j;
        notifyPropertyChanged(588);
    }

    public void savePal_clk_thres(long j) {
        setPal_clk_thres(j);
        saveLong(MessageID.MSG_DECODE_PAL_CLK_THRE, j);
        syncData(MessageID.MSG_DECODE_PAL_CLK_THRE, Long.valueOf(j));
    }

    public void readPal_clk_thres() {
        setPal_clk_thres(readLong(MessageID.MSG_DECODE_PAL_CLK_THRE));
    }

    @Bindable
    public long getPal_dat_thres() {
        return this.pal_dat_thres;
    }

    public void setPal_dat_thres(long j) {
        this.pal_dat_thres = j;
        notifyPropertyChanged(590);
    }

    public void savePal_dat_thres(long j) {
        setPal_dat_thres(j);
        saveLong(MessageID.MSG_DECODE_PAL_DAT_THRE, j);
        syncData(MessageID.MSG_DECODE_PAL_DAT_THRE, Long.valueOf(j));
    }

    public void readPal_dat_thres() {
        setPal_dat_thres(readLong(MessageID.MSG_DECODE_PAL_DAT_THRE));
    }

    @Bindable
    public int getPal_bus() {
        return this.pal_bus;
    }

    public void setPal_bus(int i) {
        this.pal_bus = i;
        notifyPropertyChanged(584);
    }

    public void savePal_bus(int i) {
        setPal_bus(i);
        if (i == 11) {
            i--;
        }
        saveInt(MessageID.MSG_DECODE_PAL_BUS, i);
    }

    public void readPal_bus() {
        int readInt = readInt(MessageID.MSG_DECODE_PAL_BUS);
        if (readInt == 10) {
            setBus_chan(getPal_bus());
            setPal_bus(readInt + 1);
            return;
        }
        setPal_bus(readInt);
        setBus_chan(readInt);
    }

    @Bindable
    public boolean isPal_endian() {
        return this.pal_endian;
    }

    public void setPal_endian(boolean z) {
        this.pal_endian = z;
        notifyPropertyChanged(591);
    }

    public void savePal_endian(boolean z) {
        setPal_endian(z);
        saveBool(MessageID.MSG_DECODE_PAL_ENDIAN, z);
    }

    public void readPal_Endian() {
        setPal_endian(readBool(MessageID.MSG_DECODE_PAL_ENDIAN));
    }

    @Bindable
    public int getBus_width() {
        return this.bus_width;
    }

    public void setBus_width(int i) {
        this.bus_width = i;
        notifyPropertyChanged(128);
    }

    public void saveBus_width(int i) {
        setBus_width(i);
        saveInt(MessageID.MSG_DECODE_BUS_WIDTH, i);
    }

    public int readPalBus_width() {
        int readInt = readInt(MessageID.MSG_DECODE_BUS_WIDTH);
        setBus_width(readInt);
        return readInt;
    }

    @Bindable
    public int getBus_bitx() {
        return this.bus_bitx;
    }

    public void setBus_bitx(int i) {
        this.bus_bitx = i;
        notifyPropertyChanged(126);
    }

    public void saveBus_bitx(int i) {
        setBus_bitx(i);
        saveInt(MessageID.MSG_DECODE_BUS_BITX, i);
    }

    public void readPalBus_bitx() {
        setBus_bitx(readInt(MessageID.MSG_DECODE_BUS_BITX));
    }

    public void readBusWidthAttr() {
        readAttr(MessageID.MSG_DECODE_BUS_WIDTH, this.bus_widthAttr);
    }

    public MessageAttr getBusWidthAttr() {
        return this.bus_widthAttr;
    }

    @Bindable
    public int getBus_chan() {
        return this.bus_chan;
    }

    public void setBus_chan(int i) {
        this.bus_chan = i;
        notifyPropertyChanged(127);
    }

    public void saveBus_chan(int i) {
        setBus_chan(i);
        saveInt(MessageID.MSG_DECODE_BUS_CH, i);
    }

    public void readPalBus_chan() {
        setBus_chan(readInt(MessageID.MSG_DECODE_BUS_CH));
    }

    public int getBus_graph() {
        return this.bus_graph;
    }

    public void saveBus_graph(int i) {
        this.bus_graph = i;
    }

    public boolean getEvent_table() {
        return this.event_table;
    }

    public void saveEvent_table(boolean z) {
        this.event_table = z;
    }

    @Bindable
    public int getEvent_format() {
        return this.event_format;
    }

    public void setEvent_format(int i) {
        log("event_format", Integer.valueOf(this.event_format), Integer.valueOf(i));
        this.event_format = i;
        notifyPropertyChanged(285);
    }

    public void saveEvent_format(int i) {
        setEvent_format(i);
        saveInt(MessageID.MSG_DECODE_EVT_FORMAT, i);
    }

    public void readBus_EvtFormat() {
        setEvent_format(readInt(MessageID.MSG_DECODE_EVT_FORMAT));
    }

    public int getEvent_busx() {
        return this.event_busx;
    }

    public void saveEvent_busx(int i) {
        this.event_busx = i;
    }

    @Bindable
    public int getEvent_view() {
        return this.event_view;
    }

    public void setEvent_view(int i) {
        this.event_view = i;
        notifyPropertyChanged(286);
    }

    public void saveEvent_view(int i) {
        setEvent_view(i);
        saveInt(MessageID.MSG_DECODE_EVT_VIEW, i);
    }

    public void readBus_EvtView() {
        setEvent_view(readInt(MessageID.MSG_DECODE_EVT_VIEW));
    }

    @Bindable
    public int getRs232_baud() {
        return this.rs232_baud;
    }

    public void setRs232_baud(int i) {
        this.rs232_baud = i;
        notifyPropertyChanged(746);
    }

    public void saveRs232_baud(int i) {
        setRs232_baud(i);
        saveInt(MessageID.MSG_DECODE_RS232_BAUD, i);
    }

    public void readRs232_baud() {
        setRs232_baud(readInt(MessageID.MSG_DECODE_RS232_BAUD));
    }

    @Bindable
    public int getRs232_tx() {
        return this.rs232_tx;
    }

    public void setRs232_tx(int i) {
        this.rs232_tx = i;
        notifyPropertyChanged(755);
        syncData(MessageID.MSG_DECODE_RS232_TX, Integer.valueOf(i));
    }

    public void saveRs232_tx(int i) {
        setRs232_tx(i);
        saveInt(MessageID.MSG_DECODE_RS232_TX, i);
    }

    public void readRs232_tx() {
        setRs232_tx(readInt(MessageID.MSG_DECODE_RS232_TX));
    }

    @Bindable
    public int getRs232_rx() {
        return this.rs232_rx;
    }

    public void setRs232_rx(int i) {
        this.rs232_rx = i;
        notifyPropertyChanged(752);
        syncData(MessageID.MSG_DECODE_RS232_RX, Integer.valueOf(i));
    }

    public void saveRs232_rx(int i) {
        setRs232_rx(i);
        saveInt(MessageID.MSG_DECODE_RS232_RX, i);
    }

    public void readRs232_rx() {
        setRs232_rx(readInt(MessageID.MSG_DECODE_RS232_RX));
    }

    @Bindable
    public long getRs232_tx_thres() {
        return this.rs232_tx_thres;
    }

    public void setRs232_tx_thres(long j) {
        this.rs232_tx_thres = j;
        notifyPropertyChanged(756);
    }

    public void saveRs232_tx_thres(long j) {
        setRs232_tx_thres(j);
        saveLong(MessageID.MSG_DECODE_TX_THRE, j);
        syncData(MessageID.MSG_DECODE_TX_THRE, Long.valueOf(j));
    }

    public void readRs232_tx_thres() {
        setRs232_tx_thres(readLong(MessageID.MSG_DECODE_TX_THRE));
    }

    @Bindable
    public long getRs232_rx_thres() {
        return this.rs232_rx_thres;
    }

    public void setRs232_rx_thres(long j) {
        this.rs232_rx_thres = j;
        notifyPropertyChanged(753);
    }

    public void saveRs232_rx_thres(long j) {
        setRs232_rx_thres(j);
        saveLong(MessageID.MSG_DECODE_RX_THRE, j);
        syncData(MessageID.MSG_DECODE_RX_THRE, Long.valueOf(j));
    }

    public void readRs232_rx_thres() {
        setRs232_rx_thres(readLong(MessageID.MSG_DECODE_RX_THRE));
    }

    @Bindable
    public boolean isRs232_pol() {
        return this.rs232_pol;
    }

    public void setRs232_pol(boolean z) {
        this.rs232_pol = z;
        notifyPropertyChanged(751);
    }

    public void saveRs232_pol(boolean z) {
        setRs232_pol(z);
        saveBool(MessageID.MSG_DECODE_RS232_POL, z);
    }

    public void readRs232_pol() {
        setRs232_pol(readBool(MessageID.MSG_DECODE_RS232_POL));
    }

    @Bindable
    public int getRs232_width() {
        return this.rs232_width;
    }

    public void setRs232_width(int i) {
        this.rs232_width = i;
        notifyPropertyChanged(757);
    }

    public void saveRs232_width(int i) {
        setRs232_width(i);
        saveInt(MessageID.MSG_DECODE_RS232_WIDTH, i);
    }

    public void readRs232_width() {
        setRs232_width(readInt(MessageID.MSG_DECODE_RS232_WIDTH));
    }

    @Bindable
    public int getRs232_stop() {
        return this.rs232_stop;
    }

    public void setRs232_stop(int i) {
        this.rs232_stop = i;
        notifyPropertyChanged(754);
    }

    public void saveRs232_stop(int i) {
        setRs232_stop(i);
        saveInt(MessageID.MSG_DECODE_RS232_STOP, i);
    }

    public void readRs232_stop() {
        setRs232_stop(readInt(MessageID.MSG_DECODE_RS232_STOP));
    }

    @Bindable
    public int getRs232_parity() {
        return this.rs232_parity;
    }

    public void setRs232_parity(int i) {
        this.rs232_parity = i;
        notifyPropertyChanged(750);
    }

    public void saveRs232_parity(int i) {
        setRs232_parity(i);
        saveInt(MessageID.MSG_DECODE_RS232_PARITY, i);
    }

    public void readRs232_parity() {
        setRs232_parity(readInt(MessageID.MSG_DECODE_RS232_PARITY));
    }

    @Bindable
    public boolean isRs232_package() {
        return this.rs232_package;
    }

    public void setRs232_package(boolean z) {
        this.rs232_package = z;
        notifyPropertyChanged(748);
    }

    public void saveRs232_package(boolean z) {
        setRs232_package(z);
        saveBool(MessageID.MSG_DECODE_RS232_PACKEN, z);
    }

    public void readRs232_package() {
        setRs232_package(readBool(MessageID.MSG_DECODE_RS232_PACKEN));
    }

    @Bindable
    public boolean getRs232_endian() {
        return this.rs232_endian;
    }

    public void setRs232_endian(boolean z) {
        this.rs232_endian = z;
        notifyPropertyChanged(747);
    }

    public void saveRs232_endian(boolean z) {
        setRs232_endian(z);
        saveInt(MessageID.MSG_DECODE_RS232_ENDIAN, z);
    }

    public void readRs232_endian() {
        setRs232_endian(readBool(MessageID.MSG_DECODE_RS232_ENDIAN));
    }

    @Bindable
    public int getRs232_package_end() {
        return this.rs232_package_end;
    }

    public void setRs232_package_end(int i) {
        this.rs232_package_end = i;
        notifyPropertyChanged(749);
    }

    public void saveRs232_package_end(int i) {
        setRs232_package_end(i);
        saveInt(MessageID.MSG_DECODE_RS232_PACKEND, i);
    }

    public void readRs232_package_end() {
        setRs232_package_end(readInt(MessageID.MSG_DECODE_RS232_PACKEND));
    }

    @Bindable
    public int getI2c_scl() {
        return this.i2c_scl;
    }

    public void setI2c_scl(int i) {
        this.i2c_scl = i;
        notifyPropertyChanged(390);
    }

    public void saveI2c_scl(int i) {
        setI2c_scl(i);
        saveInt(MessageID.MSG_DECODE_I2C_SCL, i);
    }

    public void readI2c_scl() {
        setI2c_scl(readInt(MessageID.MSG_DECODE_I2C_SCL));
    }

    @Bindable
    public int getI2c_sda() {
        return this.i2c_sda;
    }

    public void setI2c_sda(int i) {
        this.i2c_sda = i;
        notifyPropertyChanged(392);
    }

    public void saveI2c_sda(int i) {
        setI2c_sda(i);
        saveInt(MessageID.MSG_DECODE_I2C_SDA, i);
    }

    public void readI2c_sda() {
        setI2c_sda(readInt(MessageID.MSG_DECODE_I2C_SDA));
    }

    @Bindable
    public long getI2c_scl_thres() {
        return this.i2c_scl_thres;
    }

    public void setI2c_scl_thres(long j) {
        this.i2c_scl_thres = j;
        notifyPropertyChanged(391);
    }

    public void saveI2c_scl_thres(long j) {
        setI2c_scl_thres(j);
        saveLong(MessageID.MSG_DECODE_SCL_THRE, j);
        syncData(MessageID.MSG_DECODE_SCL_THRE, Long.valueOf(j));
    }

    public void readI2c_scl_thres() {
        setI2c_scl_thres(readLong(MessageID.MSG_DECODE_SCL_THRE));
    }

    @Bindable
    public long getI2c_sda_thres() {
        return this.i2c_sda_thres;
    }

    public void setI2c_sda_thres(long j) {
        this.i2c_sda_thres = j;
        notifyPropertyChanged(393);
    }

    public void saveI2c_sda_thres(long j) {
        setI2c_sda_thres(j);
        saveLong(MessageID.MSG_DECODE_SDA_THRE, j);
        syncData(MessageID.MSG_DECODE_SDA_THRE, Long.valueOf(j));
    }

    public void readI2c_sda_thres() {
        setI2c_sda_thres(readLong(MessageID.MSG_DECODE_SDA_THRE));
    }

    @Bindable
    public boolean isI2c_exchange() {
        return this.i2c_exchange;
    }

    public void setI2c_exchange(boolean z) {
        this.i2c_exchange = z;
        notifyPropertyChanged(388);
    }

    public void saveI2c_exchange(boolean z) {
        setI2c_exchange(z);
        saveBool(MessageID.MSG_DECODE_I2C_EXC, z);
    }

    public void readI2c_exchange() {
        setI2c_exchange(readBool(MessageID.MSG_DECODE_I2C_EXC));
    }

    @Bindable
    public boolean isI2c_read_write() {
        return this.i2c_read_write;
    }

    public void setI2c_read_write(boolean z) {
        this.i2c_read_write = z;
        notifyPropertyChanged(389);
    }

    public void saveI2c_read_write(boolean z) {
        setI2c_read_write(z);
        saveBool(MessageID.MSG_DECODE_I2C_RW, z);
    }

    public void readI2c_read_write() {
        setI2c_read_write(readBool(MessageID.MSG_DECODE_I2C_RW));
    }

    @Bindable
    public int getSpi_cs() {
        return this.spi_cs;
    }

    public void setSpi_cs(int i) {
        this.spi_cs = i;
        notifyPropertyChanged(881);
    }

    public void saveSpi_cs(int i) {
        setSpi_cs(i);
        saveInt(MessageID.MSG_DECODE_SPI_CS, i);
    }

    public void readSpi_cs() {
        setSpi_cs(readInt(MessageID.MSG_DECODE_SPI_CS));
    }

    @Bindable
    public int getSpi_mode() {
        return this.spi_mode;
    }

    public void setSpi_mode(int i) {
        this.spi_mode = i;
        notifyPropertyChanged(888);
    }

    public void saveSpi_mode(int i) {
        setSpi_mode(i);
        saveBool(MessageID.MSG_DECODE_SPI_MODE, i == 1);
    }

    public void readSpi_mode() {
        setSpi_mode(readBool(MessageID.MSG_DECODE_SPI_MODE) ? 1 : 0);
    }

    @Bindable
    public int getSpi_clock() {
        return this.spi_clock;
    }

    public void setSpi_clock(int i) {
        this.spi_clock = i;
        notifyPropertyChanged(878);
    }

    public void saveSpi_clock(int i) {
        setSpi_clock(i);
        saveInt(MessageID.MSG_DECODE_SPI_CLK, i);
    }

    public void readSpi_clock() {
        setSpi_clock(readInt(MessageID.MSG_DECODE_SPI_CLK));
    }

    @Bindable
    public int getSpi_miso() {
        return this.spi_miso;
    }

    public void setSpi_miso(int i) {
        this.spi_miso = i;
        notifyPropertyChanged(886);
        syncData(MessageID.MSG_DECODE_SPI_MISO, Integer.valueOf(i));
    }

    public void saveSpi_miso(int i) {
        setSpi_miso(i);
        saveInt(MessageID.MSG_DECODE_SPI_MISO, i);
    }

    public void readSpi_miso() {
        setSpi_miso(readInt(MessageID.MSG_DECODE_SPI_MISO));
    }

    @Bindable
    public int getSpi_mosi() {
        return this.spi_mosi;
    }

    public void setSpi_mosi(int i) {
        this.spi_mosi = i;
        notifyPropertyChanged(889);
    }

    public void saveSpi_mosi(int i) {
        setSpi_mosi(i);
        saveInt(MessageID.MSG_DECODE_SPI_MOSI, i);
    }

    public void readSpi_mosi() {
        setSpi_mosi(readInt(MessageID.MSG_DECODE_SPI_MOSI));
    }

    @Bindable
    public long getSpi_cs_thres() {
        return this.spi_cs_thres;
    }

    public void setSpi_cs_thres(long j) {
        this.spi_cs_thres = j;
        notifyPropertyChanged(883);
    }

    public void saveSpi_cs_thres(long j) {
        setSpi_cs_thres(j);
        saveLong(MessageID.MSG_DECODE_CS_THRE, j);
        syncData(MessageID.MSG_DECODE_CS_THRE, Long.valueOf(j));
    }

    public void readSpi_cs_thres() {
        setSpi_cs_thres(readLong(MessageID.MSG_DECODE_CS_THRE));
    }

    @Bindable
    public long getSpi_clock_thres() {
        return this.spi_clock_thres;
    }

    public void setSpi_clock_thres(long j) {
        this.spi_clock_thres = j;
        notifyPropertyChanged(880);
    }

    public void saveSpi_clock_thres(long j) {
        setSpi_clock_thres(j);
        saveLong(MessageID.MSG_DECODE_CLK_THRE, j);
        syncData(MessageID.MSG_DECODE_CLK_THRE, Long.valueOf(j));
    }

    public void readSpi_clock_thres() {
        setSpi_clock_thres(readLong(MessageID.MSG_DECODE_CLK_THRE));
    }

    @Bindable
    public long getSpi_miso_thres() {
        return this.spi_miso_thres;
    }

    public void setSpi_miso_thres(long j) {
        this.spi_miso_thres = j;
        notifyPropertyChanged(887);
    }

    public void saveSpi_miso_thres(long j) {
        setSpi_miso_thres(j);
        saveLong(MessageID.MSG_DECODE_MISO_THRE, j);
        syncData(MessageID.MSG_DECODE_MISO_THRE, Long.valueOf(j));
    }

    public void readSpi_miso_thres() {
        setSpi_miso_thres(readLong(MessageID.MSG_DECODE_MISO_THRE));
    }

    @Bindable
    public long getSpi_mosi_thres() {
        return this.spi_mosi_thres;
    }

    public void setSpi_mosi_thres(long j) {
        this.spi_mosi_thres = j;
        notifyPropertyChanged(890);
    }

    public void saveSpi_mosi_thres(long j) {
        setSpi_mosi_thres(j);
        saveLong(MessageID.MSG_DECODE_MOSI_THRE, j);
        syncData(MessageID.MSG_DECODE_MOSI_THRE, Long.valueOf(j));
    }

    public void readSpi_mosi_thres() {
        setSpi_mosi_thres(readLong(MessageID.MSG_DECODE_MOSI_THRE));
    }

    @Bindable
    public int getSpi_clock_edge() {
        return this.spi_clock_edge;
    }

    public void setSpi_clock_edge(int i) {
        this.spi_clock_edge = i;
        notifyPropertyChanged(879);
    }

    public void saveSpi_clock_edge(int i) {
        setSpi_clock_edge(i);
        saveBool(MessageID.MSG_DECODE_CLK_EDGE, i == 1);
    }

    public void readSpi_clock_edge() {
        setSpi_clock_edge(readBool(MessageID.MSG_DECODE_CLK_EDGE) ? 1 : 0);
    }

    @Bindable
    public int getSpi_data_polarity() {
        return this.spi_data_polarity;
    }

    public void setSpi_data_polarity(int i) {
        this.spi_data_polarity = i;
        notifyPropertyChanged(884);
    }

    public void saveSpi_data_polarity(int i) {
        setSpi_data_polarity(i);
        saveBool(MessageID.MSG_DECODE_DAT_POL, i == 1);
    }

    public void readSpi_data_polarity() {
        setSpi_data_polarity(readBool(MessageID.MSG_DECODE_DAT_POL) ? 1 : 0);
    }

    @Bindable
    public int getSpi_cs_polarity() {
        return this.spi_cs_polarity;
    }

    public void setSpi_cs_polarity(int i) {
        this.spi_cs_polarity = i;
        notifyPropertyChanged(882);
    }

    public void saveSpi_cs_polarity(int i) {
        setSpi_cs_polarity(i);
        saveBool(MessageID.MSG_DECODE_CS_POL, i == 1);
    }

    public void readSpi_cs_polarity() {
        setSpi_cs_polarity(readBool(MessageID.MSG_DECODE_CS_POL) ? 1 : 0);
    }

    @Bindable
    public long getSpi_timeout() {
        return this.spi_timeout;
    }

    public void setSpi_timeout(long j) {
        this.spi_timeout = j;
        notifyPropertyChanged(891);
    }

    public void saveSpi_timeout(long j) {
        setSpi_timeout(j);
        saveLong(MessageID.MSG_DECODE_SPI_TMO, j);
    }

    public void readSpi_timeout() {
        setSpi_timeout(readLong(MessageID.MSG_DECODE_SPI_TMO));
    }

    @Bindable
    public long getSpi_width() {
        return this.spi_width;
    }

    public void setSpi_width(long j) {
        this.spi_width = j;
        notifyPropertyChanged(892);
    }

    public void saveSpi_width(long j) {
        setSpi_width(j);
        saveLong(MessageID.MSG_DECODE_SPI_WIDTH, j);
    }

    public void readSpi_width() {
        setSpi_width(readInt(MessageID.MSG_DECODE_SPI_WIDTH));
    }

    @Bindable
    public boolean isSpi_endian() {
        return this.spi_endian;
    }

    public void setSpi_endian(boolean z) {
        this.spi_endian = z;
        notifyPropertyChanged(885);
    }

    public void saveSpi_endian(boolean z) {
        setSpi_endian(z);
        saveBool(MessageID.MSG_DECODE_SPI_ENDIAN, z);
    }

    public void readSpi_endian() {
        setSpi_endian(readBool(MessageID.MSG_DECODE_SPI_ENDIAN));
    }

    @Bindable
    public int getLin_source() {
        return this.lin_source;
    }

    public void setLin_source(int i) {
        this.lin_source = i;
        notifyPropertyChanged(498);
    }

    public void saveLin_source(int i) {
        setLin_source(i);
        saveInt(MessageID.MSG_DECODE_LIN_SRC, i);
    }

    public void readLin_source() {
        setLin_source(readInt(MessageID.MSG_DECODE_LIN_SRC));
    }

    @Bindable
    public long getLin_thres() {
        return this.lin_thres;
    }

    public void setLin_thres(long j) {
        this.lin_thres = j;
        notifyPropertyChanged(499);
    }

    public void saveLin_thres(long j) {
        setLin_thres(j);
        saveLong(MessageID.MSG_DECODE_LIN_THRE, j);
        syncData(MessageID.MSG_DECODE_LIN_THRE, Integer.valueOf(this.lin_source));
    }

    public void readLin_thres() {
        setLin_thres(readLong(MessageID.MSG_DECODE_LIN_THRE));
    }

    @Bindable
    public int getLin_baud() {
        return this.lin_baud;
    }

    public void setLin_baud(int i) {
        this.lin_baud = i;
        notifyPropertyChanged(495);
    }

    public void saveLin_baud(int i) {
        setLin_baud(i);
        saveInt(MessageID.MSG_DECODE_LIN_BAUD, i);
    }

    public void readLin_baud() {
        setLin_baud(readInt(MessageID.MSG_DECODE_LIN_BAUD));
    }

    @Bindable
    public boolean isLin_polarity() {
        return this.lin_polarity;
    }

    public void setLin_polarity(boolean z) {
        this.lin_polarity = z;
        notifyPropertyChanged(497);
    }

    public void saveLin_polarity(boolean z) {
        setLin_polarity(z);
        saveBool(MessageID.MSG_DECODE_LIN_POL, z);
    }

    public void readLin_polarity() {
        setLin_polarity(readBool(MessageID.MSG_DECODE_LIN_POL));
    }

    @Bindable
    public int getLin_version() {
        return this.lin_version;
    }

    public void setLin_version(int i) {
        this.lin_version = i;
        notifyPropertyChanged(500);
    }

    public void saveLin_version(int i) {
        setLin_version(i);
        saveInt(MessageID.MSG_DECODE_LIN_VER, i);
    }

    public void readLin_version() {
        setLin_version(readInt(MessageID.MSG_DECODE_LIN_VER));
    }

    @Bindable
    public boolean isLin_parity_bit() {
        return this.lin_parity_bit;
    }

    public void setLin_parity_bit(boolean z) {
        this.lin_parity_bit = z;
        notifyPropertyChanged(496);
    }

    public void saveLin_parity_bit(boolean z) {
        setLin_parity_bit(z);
        saveBool(MessageID.MSG_DECODE_LIN_PARITY, z);
    }

    public void readLin_parity_bit() {
        setLin_parity_bit(readBool(MessageID.MSG_DECODE_LIN_PARITY));
    }

    @Bindable
    public int getCan_source() {
        return this.can_source;
    }

    public void setCan_source(int i) {
        this.can_source = i;
        notifyPropertyChanged(148);
    }

    public void saveCan_source(int i) {
        setCan_source(i);
        saveInt(MessageID.MSG_DECODE_CAN_SRC, i);
    }

    public void readCan_source() {
        setCan_source(readInt(MessageID.MSG_DECODE_CAN_SRC));
    }

    @Bindable
    public long getCan_threas() {
        return this.can_threas;
    }

    public void setCan_threas(long j) {
        this.can_threas = j;
        notifyPropertyChanged(149);
    }

    public void saveCan_threas(long j) {
        setCan_threas(j);
        saveLong(MessageID.MSG_DECODE_CAN_THRE, j);
        syncData(MessageID.MSG_DECODE_CAN_THRE, Long.valueOf(j));
    }

    public void readCan_threas() {
        setCan_threas(readLong(MessageID.MSG_DECODE_CAN_THRE));
    }

    @Bindable
    public int getCan_baud() {
        return this.can_baud;
    }

    public void setCan_baud(int i) {
        this.can_baud = i;
        notifyPropertyChanged(143);
    }

    public void saveCan_baud(int i) {
        setCan_baud(i);
        saveInt(MessageID.MSG_DECODE_CAN_BAUD, i);
    }

    public void readCan_baud() {
        setCan_baud(readInt(MessageID.MSG_DECODE_CAN_BAUD));
    }

    @Bindable
    public int getCan_fd_baud() {
        return this.can_fd_baud;
    }

    public void setCan_fd_baud(int i) {
        this.can_fd_baud = i;
        notifyPropertyChanged(144);
    }

    public void saveCan_fd_baud(int i) {
        setCan_fd_baud(i);
        saveInt(MessageID.MSG_DECODE_CANFD_BAUD, i);
    }

    public void readCan_fd_baud() {
        setCan_fd_baud(readInt(MessageID.MSG_DECODE_CANFD_BAUD));
    }

    @Bindable
    public long getCan_fd_samp() {
        return this.can_fd_samp;
    }

    public void setCan_fd_samp(long j) {
        this.can_fd_samp = j;
        notifyPropertyChanged(145);
    }

    public void saveCan_fd_samp(long j) {
        setCan_fd_samp(j);
        saveLong(MessageID.MSG_DECODE_CANFD_SAMP, j);
    }

    public void readCan_fd_samp() {
        setCan_fd_samp(readInt(MessageID.MSG_DECODE_CANFD_SAMP));
    }

    @Bindable
    public int getFlex_source() {
        return this.flex_source;
    }

    public void setFlex_source(int i) {
        this.flex_source = i;
        notifyPropertyChanged(327);
    }

    public void saveFlex_source(int i) {
        saveInt(MessageID.MSG_DECODE_FLEX_SRC, i);
    }

    public void readFlex_source() {
        setFlex_source(readInt(MessageID.MSG_DECODE_FLEX_SRC));
    }

    @Bindable
    public long getFlex_thres() {
        return this.flex_thres;
    }

    public void setFlex_thres(long j) {
        this.flex_thres = j;
        notifyPropertyChanged(328);
    }

    public void saveFlex_thres(long j) {
        setFlex_thres(j);
        saveLong(MessageID.MSG_DECODE_FLEX_THRE, j);
        syncData(MessageID.MSG_DECODE_FLEX_THRE, Long.valueOf(j));
    }

    public void readFlex_thres() {
        setFlex_thres(readLong(MessageID.MSG_DECODE_FLEX_THRE));
    }

    @Bindable
    public int getFlex_baud() {
        return this.flex_baud;
    }

    public void setFlex_baud(int i) {
        this.flex_baud = i;
        notifyPropertyChanged(323);
    }

    public void saveFlex_baud(int i) {
        setFlex_baud(i);
        saveInt(MessageID.MSG_DECODE_FLEX_BAUD, i);
    }

    public void readFlex_baud() {
        setFlex_baud(readInt(MessageID.MSG_DECODE_FLEX_BAUD));
    }

    @Bindable
    public int getFlex_signal() {
        return this.flex_signal;
    }

    public void setFlex_signal(int i) {
        this.flex_signal = i;
        notifyPropertyChanged(326);
    }

    public void saveFlex_signal(int i) {
        setFlex_signal(i);
        saveInt(MessageID.MSG_DECODE_FLEX_SIGNAL, i);
    }

    public void readFlex_signal() {
        setFlex_signal(readInt(MessageID.MSG_DECODE_FLEX_SIGNAL));
    }

    @Bindable
    public boolean isFlex_channel() {
        return this.flex_channel;
    }

    public void setFlex_channel(boolean z) {
        this.flex_channel = z;
        notifyPropertyChanged(324);
    }

    public void saveFlex_channel(boolean z) {
        setFlex_channel(z);
        saveBool(MessageID.MSG_DECODE_FLEX_CHANNEL, z);
    }

    public void readFlex_channel() {
        setFlex_channel(readBool(MessageID.MSG_DECODE_FLEX_CHANNEL));
    }

    @Bindable
    public long getFlex_samp() {
        return this.flex_samp;
    }

    public void setFlex_samp(long j) {
        this.flex_samp = j;
        notifyPropertyChanged(325);
    }

    public void saveFlex_samp(long j) {
        setFlex_samp(j);
        saveLong(MessageID.MSG_DECODE_FLEX_SAMP, j);
    }

    public void readFlex_samp() {
        setFlex_samp(readInt(MessageID.MSG_DECODE_FLEX_SAMP));
    }

    @Bindable
    public int getI2s_sclock() {
        return this.i2s_sclock;
    }

    public void setI2s_sclock(int i) {
        this.i2s_sclock = i;
        notifyPropertyChanged(401);
    }

    public void saveI2s_sclock(int i) {
        setI2s_sclock(i);
        saveInt(MessageID.MSG_DECODE_I2S_SCLK, i);
    }

    public void readI2s_sclock() {
        setI2s_sclock(readInt(MessageID.MSG_DECODE_I2S_SCLK));
    }

    @Bindable
    public int getI2s_ws() {
        return this.i2s_ws;
    }

    public void setI2s_ws(int i) {
        this.i2s_ws = i;
        notifyPropertyChanged(406);
    }

    public void saveI2s_ws(int i) {
        setI2s_ws(i);
        saveInt(MessageID.MSG_DECODE_I2S_WS, i);
    }

    public void readI2s_ws() {
        setI2s_ws(readInt(MessageID.MSG_DECODE_I2S_WS));
    }

    @Bindable
    public int getI2s_data() {
        return this.i2s_data;
    }

    public void setI2s_data(int i) {
        this.i2s_data = i;
        notifyPropertyChanged(396);
    }

    public void saveI2s_data(int i) {
        setI2s_data(i);
        saveInt(MessageID.MSG_DECODE_I2S_DATA, i);
    }

    public void readI2s_data() {
        setI2s_data(readInt(MessageID.MSG_DECODE_I2S_DATA));
    }

    @Bindable
    public long getI2s_sclock_thres() {
        return this.i2s_sclock_thres;
    }

    public void setI2s_sclock_thres(long j) {
        this.i2s_sclock_thres = j;
        notifyPropertyChanged(403);
    }

    public void saveI2s_sclock_thres(long j) {
        setI2s_sclock_thres(j);
        saveLong(MessageID.MSG_DECODE_I2S_SCLK_THRE, j);
        syncData(MessageID.MSG_DECODE_I2S_SCLK_THRE, Long.valueOf(j));
    }

    public void readI2s_sclock_thres() {
        setI2s_sclock_thres(readLong(MessageID.MSG_DECODE_I2S_SCLK_THRE));
    }

    @Bindable
    public long getI2s_wave_singal_thres() {
        return this.i2s_wave_singal_thres;
    }

    public void setI2s_wave_singal_thres(long j) {
        this.i2s_wave_singal_thres = j;
        notifyPropertyChanged(404);
    }

    public void saveI2s_wave_singal_thres(long j) {
        setI2s_wave_singal_thres(j);
        saveLong(MessageID.MSG_DECODE_I2S_WS_THRE, j);
        syncData(MessageID.MSG_DECODE_I2S_WS_THRE, Long.valueOf(j));
    }

    public void readI2s_wave_singal_thres() {
        setI2s_wave_singal_thres(readLong(MessageID.MSG_DECODE_I2S_WS_THRE));
    }

    @Bindable
    public long getI2s_data_thres() {
        return this.i2s_data_thres;
    }

    public void setI2s_data_thres(long j) {
        this.i2s_data_thres = j;
        notifyPropertyChanged(398);
    }

    public void saveI2s_data_thres(long j) {
        setI2s_data_thres(j);
        saveLong(MessageID.MSG_DECODE_I2S_DATA_THRE, j);
        syncData(MessageID.MSG_DECODE_I2S_DATA_THRE, Long.valueOf(j));
    }

    public void readI2s_data_thres() {
        setI2s_data_thres(readLong(MessageID.MSG_DECODE_I2S_DATA_THRE));
    }

    @Bindable
    public int getI2s_sclock_edge() {
        return this.i2s_sclock_edge;
    }

    public void setI2s_sclock_edge(int i) {
        this.i2s_sclock_edge = i;
        notifyPropertyChanged(402);
    }

    public void saveI2s_sclock_edge(int i) {
        setI2s_sclock_edge(i);
        saveBool(MessageID.MSG_DECODE_I2S_SCLKEDGE, i == 0);
    }

    public void readI2s_sclock_edge() {
        setI2s_sclock_edge(!readBool(MessageID.MSG_DECODE_I2S_SCLKEDGE));
    }

    @Bindable
    public long getI2s_word() {
        return this.i2s_word;
    }

    public void setI2s_word(long j) {
        this.i2s_word = j;
        notifyPropertyChanged(405);
    }

    public void saveI2s_word(long j) {
        setI2s_word(j);
        saveLong(MessageID.MSG_DECODE_I2S_WORD, j);
    }

    public void readI2s_word() {
        setI2s_word(readInt(MessageID.MSG_DECODE_I2S_WORD));
    }

    @Bindable
    public long getI2s_receive() {
        return this.i2s_receive;
    }

    public void setI2s_receive(long j) {
        this.i2s_receive = j;
        notifyPropertyChanged(400);
    }

    public void saveI2s_receive(long j) {
        setI2s_receive(j);
        saveLong(MessageID.MSG_DECODE_I2S_RECEIVE, j);
    }

    public void readI2s_receive() {
        setI2s_receive(readInt(MessageID.MSG_DECODE_I2S_RECEIVE));
    }

    @Bindable
    public int getI2s_align() {
        return this.i2s_align;
    }

    public void setI2s_align(int i) {
        this.i2s_align = i;
        notifyPropertyChanged(395);
    }

    public void saveI2s_align(int i) {
        setI2s_align(i);
        saveInt(MessageID.MSG_DECODE_I2S_ALIGN, i);
    }

    public void readI2s_align() {
        setI2s_align(readInt(MessageID.MSG_DECODE_I2S_ALIGN));
    }

    @Bindable
    public int getI2s_ws_low() {
        return this.i2s_ws_low;
    }

    public void setI2s_ws_low(int i) {
        this.i2s_ws_low = i;
        notifyPropertyChanged(407);
    }

    public void saveI2s_ws_low(int i) {
        setI2s_ws_low(i);
        saveInt(MessageID.MSG_DECODE_I2S_WSLOW, i);
    }

    public void readI2s_ws_low() {
        setI2s_ws_low(readInt(MessageID.MSG_DECODE_I2S_WSLOW));
    }

    @Bindable
    public boolean isI2s_endian() {
        return this.i2s_endian;
    }

    public void setI2s_endian(boolean z) {
        this.i2s_endian = z;
        notifyPropertyChanged(399);
    }

    public void saveI2s_endian(boolean z) {
        setI2s_endian(z);
        saveBool(MessageID.MSG_DECODE_I2S_ENDIAN, z);
    }

    public void readI2s_endian() {
        setI2s_endian(readBool(MessageID.MSG_DECODE_I2S_ENDIAN));
    }

    @Bindable
    public boolean isI2s_data_polarity() {
        return this.i2s_data_polarity;
    }

    public void setI2s_data_polarity(boolean z) {
        this.i2s_data_polarity = z;
        notifyPropertyChanged(397);
    }

    public void saveI2s_data_polarity(boolean z) {
        setI2s_data_polarity(z);
        saveBool(MessageID.MSG_DECODE_I2S_POL, z);
    }

    public void readI2s_data_polarity() {
        setI2s_data_polarity(readBool(MessageID.MSG_DECODE_I2S_POL));
    }

    @Bindable
    public int get_1553b_source() {
        return this._1553b_source;
    }

    public void set_1553b_source(int i) {
        this._1553b_source = i;
        notifyPropertyChanged(23);
    }

    public void save_1553b_source(int i) {
        set_1553b_source(i);
        saveInt(MessageID.MSG_DECODE_1553B_SRC, i);
    }

    public void read_1553b_source() {
        set_1553b_source(readInt(MessageID.MSG_DECODE_1553B_SRC));
    }

    @Bindable
    public int get_1553b_polarity() {
        return this._1553b_polarity;
    }

    public void set_1553b_polarity(int i) {
        this._1553b_polarity = i;
        notifyPropertyChanged(22);
    }

    public void save_1553b_polarity(int i) {
        set_1553b_polarity(i);
        saveBool(MessageID.MSG_DECODE_1553B_POL, i == 1);
    }

    public void read_1553b_polarity() {
        set_1553b_polarity(readBool(MessageID.MSG_DECODE_1553B_POL) ? 1 : 0);
    }

    @Bindable
    public long get_1553b_thres1() {
        return this._1553b_thres1;
    }

    public void set_1553b_thres1(long j) {
        this._1553b_thres1 = j;
        notifyPropertyChanged(24);
    }

    public void save_1553b_thres1(long j) {
        set_1553b_thres1(j);
        saveLong(MessageID.MSG_DECODE_1553B_THRE1, j);
        syncData(MessageID.MSG_DECODE_1553B_THRE1, Long.valueOf(j));
    }

    public void read_1553b_thres1() {
        set_1553b_thres1(readLong(MessageID.MSG_DECODE_1553B_THRE1));
    }

    @Bindable
    public long get_1553b_thres2() {
        return this._1553b_thres2;
    }

    public void set_1553b_thres2(long j) {
        this._1553b_thres2 = j;
        notifyPropertyChanged(25);
    }

    public void save_1553b_thres2(long j) {
        set_1553b_thres2(j);
        saveLong(MessageID.MSG_DECODE_1553B_THRE2, j);
        syncData(MessageID.MSG_DECODE_1553B_THRE2, Long.valueOf(j));
    }

    public void read_1553b_thres2() {
        set_1553b_thres2(readLong(MessageID.MSG_DECODE_1553B_THRE2));
    }

    @Bindable
    public long getSent_tolerance() {
        return this.sent_tolerance;
    }

    public void setSent_tolerance(long j) {
        this.sent_tolerance = j;
        notifyPropertyChanged(806);
    }

    public void saveSent_tolerance(long j) {
        setSent_tolerance(j);
        saveLong(MessageID.MSG_DECODE_SENT_TOLERANCE, j);
    }

    public void readSent_tolerance() {
        setSent_tolerance(readLong(MessageID.MSG_DECODE_SENT_TOLERANCE));
    }

    @Bindable
    public long getSent_nibbnum() {
        return this.sent_nibbnum;
    }

    public void setSent_nibbnum(long j) {
        this.sent_nibbnum = j;
        notifyPropertyChanged(800);
    }

    public void saveSent_nibbnum(long j) {
        setSent_nibbnum(j);
        saveLong(MessageID.MSG_DECODE_SENT_NIBBNUM, j);
    }

    public void readSent_nibbnum() {
        setSent_nibbnum(readLong(MessageID.MSG_DECODE_SENT_NIBBNUM));
    }

    @Bindable
    public int getSent_signal_type() {
        return this.sent_signal_type;
    }

    public void setSent_signal_type(int i) {
        this.sent_signal_type = i;
        notifyPropertyChanged(802);
    }

    public void saveSent_signal_type(int i) {
        setSent_signal_type(i);
        saveInt(MessageID.MSG_DECODE_SENT_SIGNAL_TYPE, i);
    }

    public void readSent_signal_type() {
        setSent_signal_type(readInt(MessageID.MSG_DECODE_SENT_SIGNAL_TYPE));
    }

    @Bindable
    public long getSent_tick() {
        return this.sent_tick;
    }

    public void setSent_tick(long j) {
        this.sent_tick = j;
        notifyPropertyChanged(805);
    }

    public void saveSent_tick(long j) {
        setSent_tick(j);
        saveLong(MessageID.MSG_DECODE_SENT_TICK, j);
    }

    public void readSent_tick() {
        setSent_tick(readLong(MessageID.MSG_DECODE_SENT_TICK));
    }

    @Bindable
    public int getSent_source() {
        return this.sent_source;
    }

    public void setSent_source(int i) {
        this.sent_source = i;
        notifyPropertyChanged(803);
    }

    public void saveSent_source(int i) {
        setSent_source(i);
        saveInt(MessageID.MSG_DECODE_SENT_SRC, i);
    }

    public void readSent_source() {
        setSent_source(readInt(MessageID.MSG_DECODE_SENT_SRC));
    }

    @Bindable
    public int getSent_idle_state() {
        return this.sent_idle_state;
    }

    public void setSent_idle_state(int i) {
        this.sent_idle_state = i;
        notifyPropertyChanged(799);
    }

    public void saveSent_idle_state(int i) {
        setSent_idle_state(i);
        saveInt(MessageID.MSG_DECODE_SENT_IDLE, i);
    }

    public void readSent_idle_state() {
        setSent_idle_state(readInt(MessageID.MSG_DECODE_SENT_IDLE));
    }

    @Bindable
    public int getSent_crc_format() {
        return this.sent_crc_format;
    }

    public void setSent_crc_format(int i) {
        this.sent_crc_format = i;
        notifyPropertyChanged(798);
    }

    public void saveSent_crc_format(int i) {
        setSent_crc_format(i);
        saveInt(MessageID.MSG_DECODE_SENT_CRC, i);
    }

    public void readSent_crc_format() {
        setSent_crc_format(readInt(MessageID.MSG_DECODE_SENT_CRC));
    }

    @Bindable
    public int getSent_pause_plus() {
        return this.sent_pause_plus;
    }

    public void setSent_pause_plus(int i) {
        this.sent_pause_plus = i;
        notifyPropertyChanged(801);
    }

    public void saveSent_pause_plus(int i) {
        setSent_pause_plus(i);
        saveInt(MessageID.MSG_DECODE_SENT_PAUSE, i);
    }

    public void readSent_pause_plus() {
        setSent_pause_plus(readInt(MessageID.MSG_DECODE_SENT_PAUSE));
    }

    @Bindable
    public long getSent_thres() {
        return this.sent_thres;
    }

    public void setSent_thres(long j) {
        this.sent_thres = j;
        notifyPropertyChanged(804);
    }

    public void saveSent_thres(long j) {
        setSent_thres(j);
        saveLong(MessageID.MSG_DECODE_SENT_THRE, j);
        syncData(MessageID.MSG_DECODE_SENT_THRE, Long.valueOf(j));
    }

    public void readSent_thres() {
        setSent_thres(readLong(MessageID.MSG_DECODE_SENT_THRE));
    }

    @Bindable
    public int getMost_source() {
        return this.most_source;
    }

    public void setMost_source(int i) {
        this.most_source = i;
        notifyPropertyChanged(552);
    }

    public void saveMost_source(int i) {
        setMost_source(i);
        saveInt(MessageID.MSG_DECODE_MOST_SRC, i);
    }

    public void readMost_source() {
        setMost_source(readInt(MessageID.MSG_DECODE_MOST_SRC));
    }

    @Bindable
    public long getMost_thres() {
        return this.most_thres;
    }

    public void setMost_thres(long j) {
        this.most_thres = j;
        notifyPropertyChanged(553);
    }

    public void saveMost_thres(long j) {
        setMost_thres(j);
        saveLong(MessageID.MSG_DECODE_MOST_THRE, j);
        syncData(MessageID.MSG_DECODE_MOST_THRE, Long.valueOf(j));
    }

    public void readMost_thres() {
        setMost_thres(readLong(MessageID.MSG_DECODE_MOST_THRE));
    }

    @Bindable
    public int getMost_signal_type() {
        return this.most_signal_type;
    }

    public void setMost_signal_type(int i) {
        this.most_signal_type = i;
        notifyPropertyChanged(551);
    }

    public void saveMost_signal_type(int i) {
        setMost_signal_type(i);
        saveInt(MessageID.MSG_DECODE_MOST_SIGNAL_TYPE, i);
    }

    public void readMost_signal_type() {
        setMost_signal_type(readInt(MessageID.MSG_DECODE_MOST_SIGNAL_TYPE));
    }

    @Bindable
    public int getArinc429_source() {
        return this.arinc429_source;
    }

    public void setArinc429_source(int i) {
        this.arinc429_source = i;
        notifyPropertyChanged(54);
    }

    public void saveArinc429_source(int i) {
        setArinc429_source(i);
        saveInt(MessageID.MSG_DECODE_ARINC429_SRC, i);
    }

    public void readArinc429_source() {
        setArinc429_source(readInt(MessageID.MSG_DECODE_ARINC429_SRC));
    }

    @Bindable
    public long getArinc429_up_thres() {
        return this.arinc429_up_thres;
    }

    public void setArinc429_up_thres(long j) {
        this.arinc429_up_thres = j;
        notifyPropertyChanged(55);
    }

    public void saveArinc429_up_thres(long j) {
        setArinc429_up_thres(j);
        saveLong(MessageID.MSG_DECODE_ARINC429_UP_THRE, j);
        syncData(MessageID.MSG_DECODE_ARINC429_UP_THRE, Long.valueOf(j));
    }

    public void readArinc429_up_thres() {
        setArinc429_up_thres(readLong(MessageID.MSG_DECODE_ARINC429_UP_THRE));
    }

    @Bindable
    public long getArinc429_down_thres() {
        return this.arinc429_down_thres;
    }

    public void setArinc429_down_thres(long j) {
        this.arinc429_down_thres = j;
        notifyPropertyChanged(52);
    }

    public void saveArinc429_down_thres(long j) {
        setArinc429_down_thres(j);
        saveLong(MessageID.MSG_DECODE_ARINC429_DOWN_THRE, j);
        syncData(MessageID.MSG_DECODE_ARINC429_DOWN_THRE, Long.valueOf(j));
    }

    public void readArinc429_down_thres() {
        setArinc429_down_thres(readLong(MessageID.MSG_DECODE_ARINC429_DOWN_THRE));
    }

    @Bindable
    public int getArinc429_baud() {
        return this.arinc429_baud;
    }

    public void setArinc429_baud(int i) {
        this.arinc429_baud = i;
        notifyPropertyChanged(50);
    }

    public void saveArinc429_baud(int i) {
        setArinc429_baud(i);
        saveInt(MessageID.MSG_DECODE_ARINC429_BAUD, i);
    }

    public void readArinc429_baud() {
        setArinc429_baud(readInt(MessageID.MSG_DECODE_ARINC429_BAUD));
    }

    @Bindable
    public int getArinc429_singal_type() {
        return this.arinc429_singal_type;
    }

    public void setArinc429_singal_type(int i) {
        this.arinc429_singal_type = i;
        notifyPropertyChanged(53);
    }

    public void saveArinc429_singal_type(int i) {
        setArinc429_singal_type(i);
        saveInt(MessageID.MSG_DECODE_ARINC429_SIGNAL_TYPE, i);
    }

    public void readArinc429_singal_type() {
        setArinc429_singal_type(readBool(MessageID.MSG_DECODE_ARINC429_SIGNAL_TYPE) ? 1 : 0);
    }

    @Bindable
    public int getArinc429_byte_format() {
        return this.arinc429_byte_format;
    }

    public void setArinc429_byte_format(int i) {
        this.arinc429_byte_format = i;
        notifyPropertyChanged(51);
    }

    public void saveArinc429_byte_format(int i) {
        setArinc429_byte_format(i);
        saveInt(MessageID.MSG_DECODE_ARINC429_BYTE_FORMAT, i);
    }

    public void readArinc429_byte_format() {
        setArinc429_byte_format(readInt(MessageID.MSG_DECODE_ARINC429_BYTE_FORMAT));
    }

    @Bindable
    public int getUsb_dp() {
        return this.usb_dp;
    }

    public void setUsb_dp(int i) {
        this.usb_dp = i;
        notifyPropertyChanged(1003);
    }

    public void readUsb_dp() {
        setUsb_dp(readInt(MessageID.MSG_DECODE_USB_DP));
    }

    public void saveUsb_dp(int i) {
        setUsb_dp(i);
        saveInt(MessageID.MSG_DECODE_USB_DP, i);
    }

    @Bindable
    public int getUsb_ds() {
        return this.usb_ds;
    }

    public void setUsb_ds(int i) {
        this.usb_ds = i;
        notifyPropertyChanged(1005);
    }

    public void readUsb_ds() {
        setUsb_ds(readInt(MessageID.MSG_DECODE_USB_DS));
    }

    public void saveUsb_ds(int i) {
        setUsb_ds(i);
        saveInt(MessageID.MSG_DECODE_USB_DS, i);
    }

    @Bindable
    public long getUsb_dp_thres() {
        return this.usb_dp_thres;
    }

    public void setUsb_dp_thres(long j) {
        this.usb_dp_thres = j;
        notifyPropertyChanged(1004);
    }

    public void readUsb_dp_thres() {
        setUsb_dp_thres(readLong(MessageID.MSG_DECODE_USB_DP_THRE));
    }

    public void saveUsb_dp_thres(long j) {
        setUsb_dp_thres(j);
        saveLong(MessageID.MSG_DECODE_USB_DP_THRE, j);
        syncData(MessageID.MSG_DECODE_USB_DP_THRE, Long.valueOf(j));
    }

    @Bindable
    public long getUsb_ds_thres() {
        return this.usb_ds_thres;
    }

    public void setUsb_ds_thres(long j) {
        this.usb_ds_thres = j;
        notifyPropertyChanged(1006);
    }

    public void readUsb_ds_thres() {
        setUsb_ds_thres(readLong(MessageID.MSG_DECODE_USB_DS_THRE));
    }

    public void saveUsb_ds_thres(long j) {
        setUsb_ds_thres(j);
        saveLong(MessageID.MSG_DECODE_USB_DS_THRE, j);
        syncData(MessageID.MSG_DECODE_USB_DS_THRE, Long.valueOf(j));
    }

    @Bindable
    public int getUsb_diff() {
        return this.usb_diff;
    }

    public void setUsb_diff(int i) {
        this.usb_diff = i;
        notifyPropertyChanged(999);
    }

    public void readUsb_diff() {
        setUsb_diff(readInt(MessageID.MSG_DECODE_USB_DIFF));
    }

    public void saveUsb_diff(int i) {
        setUsb_diff(i);
        saveInt(MessageID.MSG_DECODE_USB_DIFF, i);
    }

    @Bindable
    public long getUsb_diff_high_thres() {
        return this.usb_diff_high_thres;
    }

    public void setUsb_diff_high_thres(long j) {
        this.usb_diff_high_thres = j;
        notifyPropertyChanged(1000);
    }

    public void readUsb_diff_high_thres() {
        setUsb_diff_high_thres(readLong(MessageID.MSG_DECODE_USB_DIFF_THRE_H));
    }

    public void saveUsb_diff_high_thres(long j) {
        setUsb_diff_high_thres(j);
        saveLong(MessageID.MSG_DECODE_USB_DIFF_THRE_H, j);
        syncData(MessageID.MSG_DECODE_USB_DIFF_THRE_H, Long.valueOf(j));
    }

    @Bindable
    public long getUsb_diff_low_thres() {
        return this.usb_diff_low_thres;
    }

    public void setUsb_diff_low_thres(long j) {
        this.usb_diff_low_thres = j;
        notifyPropertyChanged(1001);
    }

    public void readUsb_diff_low_thres() {
        setUsb_diff_low_thres(readLong(MessageID.MSG_DECODE_USB_DIFF_THRE_L));
    }

    public void saveUsb_diff_low_thres(long j) {
        setUsb_diff_low_thres(j);
        saveLong(MessageID.MSG_DECODE_USB_DIFF_THRE_L, j);
        syncData(MessageID.MSG_DECODE_USB_DIFF_THRE_L, Long.valueOf(j));
    }

    @Bindable
    public long getUsb_rate() {
        return this.usb_rate;
    }

    public void setUsb_rate(long j) {
        this.usb_rate = j;
        notifyPropertyChanged(1008);
    }

    public void readRate() {
        setUsb_rate(readLong(MessageID.MSG_DECODE_USB_RATE));
    }

    public void saveUsb_rate(long j) {
        setUsb_rate(j);
        saveLong(MessageID.MSG_DECODE_USB_RATE, j);
    }

    @Bindable
    public float getGuideline() {
        return this.guideline;
    }

    public void setGuideline(float f) {
        this.guideline = f;
        notifyPropertyChanged(365);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readDecodeParam();
    }

    public boolean isCopyTrigShow(ServiceEnum.DecodeBusType decodeBusType) {
        return decodeBusType == ServiceEnum.DecodeBusType.Decode_ARINC429 || decodeBusType == ServiceEnum.DecodeBusType.Decode_MOST || decodeBusType == ServiceEnum.DecodeBusType.Decode_SENT || decodeBusType == ServiceEnum.DecodeBusType.Decode_USB || decodeBusType == ServiceEnum.DecodeBusType.Decode_Parallel;
    }

    public String getDecodeLevelStr(long j) {
        return UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(j, ServiceEnum.Unit.Unit_V);
    }

    private void readDecodeParam() {
        readType();
        readBus_ONOFF();
        readPal_Clk();
        readPal_clk_thres();
        readPal_ClkEdge();
        readPal_bus();
        readPalBus_chan();
        readPalBus_bitx();
        readPalBus_width();
        readPal_Nrj();
        readRejectTime();
        readPal_dat_thres();
        readPal_Endian();
        readPal_Polarity();
        readBus_Format();
        readBus_EvtFormat();
        readBus_EvtView();
        readBus_Label();
        readBus_Evt();
        readRs232_rx();
        readRs232_tx();
        readRs232_pol();
        readRs232_tx_thres();
        readRs232_rx_thres();
        readRs232_baud();
        readRs232_width();
        readRs232_parity();
        readRs232_stop();
        readRs232_endian();
        readRs232_package();
        readRs232_package_end();
        readI2c_scl();
        readI2c_sda();
        readI2c_exchange();
        readI2c_read_write();
        readI2c_scl_thres();
        readI2c_sda_thres();
        readLin_source();
        readLin_thres();
        readLin_baud();
        readLin_polarity();
        readLin_version();
        readCan_source();
        readCan_threas();
        readCan_singal();
        readCan_baud();
        readCan_samp();
        readCan_fd_baud();
        readCan_fd_samp();
        readFlex_source();
        readFlex_thres();
        readFlex_samp();
        readFlex_signal();
        readFlex_baud();
        readFlex_channel();
        readI2s_sclock();
        readI2s_ws();
        readI2s_data();
        readI2s_word();
        readI2s_align();
        readI2s_ws_low();
        readI2s_sclock_thres();
        readI2s_wave_singal_thres();
        readI2s_data_thres();
        readI2s_word();
        readI2s_receive();
        readI2s_sclock_edge();
        readI2s_endian();
        readI2s_data_polarity();
        readSpi_clock();
        readSpi_miso();
        readSpi_mosi();
        readSpi_cs();
        readSpi_clock_thres();
        readSpi_miso_thres();
        readSpi_mosi_thres();
        readSpi_cs_thres();
        readSpi_width();
        readSpi_data_polarity();
        readSpi_mode();
        readSpi_clock_edge();
        readSpi_cs_polarity();
        readSpi_endian();
        readSpi_data_polarity();
        readSpi_timeout();
        read_1553b_source();
        read_1553b_polarity();
        read_1553b_thres1();
        read_1553b_thres2();
        readArinc429_source();
        readArinc429_singal_type();
        readArinc429_baud();
        readArinc429_byte_format();
        readArinc429_down_thres();
        readArinc429_up_thres();
        readSent_source();
        readSent_idle_state();
        readSent_crc_format();
        readSent_pause_plus();
        readSent_signal_type();
        readSent_tick();
        readSent_thres();
        readSent_tolerance();
        readSent_nibbnum();
        readMost_source();
        readMost_thres();
        readMost_signal_type();
        readUsb_dp();
        readUsb_ds();
        readUsb_dp_thres();
        readUsb_ds_thres();
        readUsb_diff();
        readUsb_diff_high_thres();
        readUsb_diff_low_thres();
        readRate();
        readPalClkThresAttr();
        readPalBusThresAttr();
        readRejectTimeAttr();
        readUsbDpThresAttr();
        readUsbDsThresAttr();
        readUsbDiffHthresAttr();
        readUsbDiffLthresAttr();
        readI2cClkThresAttr();
        readI2cDataThresAttr();
        readSpiClkThresAttr();
        readSpiMisoThresAttr();
        readSpiMosiThresAttr();
        readSpiCsThresAttr();
        readSpiWidthAttr();
        readSpiTimeoutAttr();
        readLinThresAttr();
        readCanThresAttr();
        readCanSamplePosAttr();
        readCanFdSamplePosAttr();
        readFlexThresAttr();
        readFlexSamplePosAttr();
        readI2sSclkThresAttr();
        readI2sWsThresAttr();
        readI2sDataThresAttr();
        readI2sWordValueAttr();
        readI2sReceiveValueAttr();
        readMilstdThres1Attr();
        readArincUpThresAttr();
        readArincDownThresAttr();
        readSentThresAttr();
        readSentTickAttr();
        readSentToleranceAttr();
        readSentNibbnumAttr();
        readMostThresAttr();
        readRs232BaudAttr();
        readCanBaudAttr();
        readCanFdBaudAttr();
        readLinBaudAttr();
        readTxThresAttr();
        readRxThresAttr();
    }

    public MessageAttr getPalClkThresAttr() {
        return this.palClkThresAttr;
    }

    public MessageAttr getPalBusThresAttr() {
        return this.palBusThresAttr;
    }

    public MessageAttr getRejectTimeAttr() {
        return this.rejectTimeAttr;
    }

    public MessageAttr getUsbDpThresAttr() {
        return this.usbDpThresAttr;
    }

    public MessageAttr getUsbDsThresAttr() {
        return this.usbDsThresAttr;
    }

    public MessageAttr getUsbDiffHthresAttr() {
        return this.usbDiffHthresAttr;
    }

    public MessageAttr getUsbDiffLthresAttr() {
        return this.usbDiffLthresAttr;
    }

    public MessageAttr getI2cClkThresAttr() {
        return this.i2cClkThresAttr;
    }

    public MessageAttr getI2cDataThresAttr() {
        return this.i2cDataThresAttr;
    }

    public MessageAttr getSpiClkThresAttr() {
        return this.spiClkThresAttr;
    }

    public MessageAttr getSpiMisoThresAttr() {
        return this.spiMisoThresAttr;
    }

    public MessageAttr getSpiMosiThresAttr() {
        return this.spiMosiThresAttr;
    }

    public MessageAttr getSpiCsThresAttr() {
        return this.spiCsThresAttr;
    }

    public MessageAttr getSpiWidthAttr() {
        return this.spiWidthAttr;
    }

    public MessageAttr getSpiTimeoutAttr() {
        return this.spiTimeoutAttr;
    }

    public MessageAttr getLinThresAttr() {
        return this.linThresAttr;
    }

    public MessageAttr getCanThresAttr() {
        return this.canThresAttr;
    }

    public MessageAttr getCanSamplePosAttr() {
        return this.canSamplePosAttr;
    }

    public MessageAttr getCanFdSamplePosAttr() {
        return this.canFdSamplePosAttr;
    }

    public MessageAttr getFlexThresAttr() {
        return this.flexThresAttr;
    }

    public MessageAttr getFlexSamplePosAttr() {
        return this.flexSamplePosAttr;
    }

    public MessageAttr getI2sSclkThresAttr() {
        return this.i2sSclkThresAttr;
    }

    public MessageAttr getI2sWsThresAttr() {
        return this.i2sWsThresAttr;
    }

    public MessageAttr getI2sDataThresAttr() {
        return this.i2sDataThresAttr;
    }

    public MessageAttr getI2sWordValueAttr() {
        return this.i2sWordValueAttr;
    }

    public MessageAttr getI2sReceiveValueAttr() {
        return this.i2sReceiveValueAttr;
    }

    public MessageAttr getMilstdThres1Attr() {
        return this.milstdThres1Attr;
    }

    public MessageAttr getArincUpThresAttr() {
        return this.arincUpThresAttr;
    }

    public MessageAttr getArincDownThresAttr() {
        return this.arincDownThresAttr;
    }

    public MessageAttr getSentThresAttr() {
        return this.sentThresAttr;
    }

    public MessageAttr getSentTickAttr() {
        return this.sentTickAttr;
    }

    public MessageAttr getSentToleranceAttr() {
        return this.sentToleranceAttr;
    }

    public MessageAttr getSentNibbnumAttr() {
        return this.sentNibbnumAttr;
    }

    public MessageAttr getMostThresAttr() {
        return this.mostThresAttr;
    }

    public MessageAttr getRs232BaudAttr() {
        return this.rs232BaudAttr;
    }

    public MessageAttr getCanBaudAttr() {
        return this.canBaudAttr;
    }

    public MessageAttr getCanFdBaudAttr() {
        return this.canFdBaudAttr;
    }

    public MessageAttr getLinBaudAttr() {
        return this.linBaudAttr;
    }

    public MessageAttr getTxThresAttr() {
        return this.txThresAttr;
    }

    public MessageAttr getRxThresAttr() {
        return this.rxThresAttr;
    }

    public void readPalClkThresAttr() {
        readAttr(MessageID.MSG_DECODE_PAL_CLK_THRE, this.palClkThresAttr);
    }

    public void readPalBusThresAttr() {
        readAttr(MessageID.MSG_DECODE_PAL_DAT_THRE, this.palBusThresAttr);
    }

    public void readRejectTimeAttr() {
        readAttr(MessageID.MSG_DECODE_NRJ_TIME, this.rejectTimeAttr);
    }

    public void readUsbDpThresAttr() {
        readAttr(MessageID.MSG_DECODE_USB_DP_THRE, this.usbDpThresAttr);
    }

    public void readUsbDsThresAttr() {
        readAttr(MessageID.MSG_DECODE_USB_DS_THRE, this.usbDsThresAttr);
    }

    public void readUsbDiffHthresAttr() {
        readAttr(MessageID.MSG_DECODE_USB_DIFF_THRE_H, this.usbDiffHthresAttr);
    }

    public void readUsbDiffLthresAttr() {
        readAttr(MessageID.MSG_DECODE_USB_DIFF_THRE_L, this.usbDiffLthresAttr);
    }

    public void readI2cClkThresAttr() {
        readAttr(MessageID.MSG_DECODE_SCL_THRE, this.i2cClkThresAttr);
    }

    public void readI2cDataThresAttr() {
        readAttr(MessageID.MSG_DECODE_SDA_THRE, this.i2cDataThresAttr);
    }

    public void readSpiClkThresAttr() {
        readAttr(MessageID.MSG_DECODE_CLK_THRE, this.spiClkThresAttr);
    }

    public void readSpiMisoThresAttr() {
        readAttr(MessageID.MSG_DECODE_MISO_THRE, this.spiMisoThresAttr);
    }

    public void readSpiMosiThresAttr() {
        readAttr(MessageID.MSG_DECODE_MOSI_THRE, this.spiMosiThresAttr);
    }

    public void readSpiCsThresAttr() {
        readAttr(MessageID.MSG_DECODE_CS_THRE, this.spiCsThresAttr);
    }

    public void readSpiWidthAttr() {
        readAttr(MessageID.MSG_DECODE_SPI_WIDTH, this.spiWidthAttr);
    }

    public void readSpiTimeoutAttr() {
        readAttr(MessageID.MSG_DECODE_SPI_TMO, this.spiTimeoutAttr);
    }

    public void readLinThresAttr() {
        readAttr(MessageID.MSG_DECODE_LIN_THRE, this.linThresAttr);
    }

    public void readCanThresAttr() {
        readAttr(MessageID.MSG_DECODE_CAN_THRE, this.canThresAttr);
    }

    public void readCanSamplePosAttr() {
        readAttr(MessageID.MSG_DECODE_CAN_SAMP, this.canSamplePosAttr);
    }

    public void readCanFdSamplePosAttr() {
        readAttr(MessageID.MSG_DECODE_CANFD_SAMP, this.canFdSamplePosAttr);
    }

    public void readFlexThresAttr() {
        readAttr(MessageID.MSG_DECODE_FLEX_THRE, this.flexThresAttr);
    }

    public void readFlexSamplePosAttr() {
        readAttr(MessageID.MSG_DECODE_FLEX_SAMP, this.flexSamplePosAttr);
    }

    public void readI2sSclkThresAttr() {
        readAttr(MessageID.MSG_DECODE_I2S_SCLK_THRE, this.i2sSclkThresAttr);
    }

    public void readI2sWsThresAttr() {
        readAttr(MessageID.MSG_DECODE_I2S_WS_THRE, this.i2sWsThresAttr);
    }

    public void readI2sDataThresAttr() {
        readAttr(MessageID.MSG_DECODE_I2S_DATA_THRE, this.i2sDataThresAttr);
    }

    public void readI2sWordValueAttr() {
        readAttr(MessageID.MSG_DECODE_I2S_WORD, this.i2sWordValueAttr);
    }

    public void readI2sReceiveValueAttr() {
        readAttr(MessageID.MSG_DECODE_I2S_RECEIVE, this.i2sReceiveValueAttr);
    }

    public void readMilstdThres1Attr() {
        readAttr(MessageID.MSG_DECODE_1553B_THRE1, this.milstdThres1Attr);
    }

    public void readArincUpThresAttr() {
        readAttr(MessageID.MSG_DECODE_ARINC429_UP_THRE, this.arincUpThresAttr);
    }

    public void readArincDownThresAttr() {
        readAttr(MessageID.MSG_DECODE_ARINC429_DOWN_THRE, this.arincDownThresAttr);
    }

    public void readSentThresAttr() {
        readAttr(MessageID.MSG_DECODE_SENT_THRE, this.sentThresAttr);
    }

    public void readSentTickAttr() {
        readAttr(MessageID.MSG_DECODE_SENT_TICK, this.sentTickAttr);
    }

    public void readSentToleranceAttr() {
        readAttr(MessageID.MSG_DECODE_SENT_TOLERANCE, this.sentToleranceAttr);
    }

    public void readSentNibbnumAttr() {
        readAttr(MessageID.MSG_DECODE_SENT_NIBBNUM, this.sentNibbnumAttr);
    }

    public void readMostThresAttr() {
        readAttr(MessageID.MSG_DECODE_MOST_THRE, this.mostThresAttr);
    }

    public void readRs232BaudAttr() {
        readAttr(MessageID.MSG_DECODE_RS232_BAUD, this.rs232BaudAttr);
    }

    public void readCanBaudAttr() {
        readAttr(MessageID.MSG_DECODE_CAN_BAUD, this.canBaudAttr);
    }

    public void readCanFdBaudAttr() {
        readAttr(MessageID.MSG_DECODE_CANFD_BAUD, this.canFdBaudAttr);
    }

    public void readLinBaudAttr() {
        readAttr(MessageID.MSG_DECODE_LIN_BAUD, this.linBaudAttr);
    }

    public void readTxThresAttr() {
        readAttr(MessageID.MSG_DECODE_TX_THRE, this.txThresAttr);
    }

    public void readRxThresAttr() {
        readAttr(MessageID.MSG_DECODE_RX_THRE, this.rxThresAttr);
    }

    public List<MappingObject> getTxChanList() {
        ArrayList arrayList = new ArrayList();
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_decode_rs232_tx);
        if (getRs232_rx() == ServiceEnum.Chan.chan_none.value1) {
            for (MappingObject mappingObject : list) {
                if (mappingObject.getValue() > ServiceEnum.Chan.chan_none.value1) {
                    arrayList.add(mappingObject);
                }
            }
        } else {
            arrayList.addAll(0, list);
        }
        return arrayList;
    }

    public List<MappingObject> getRxChanList() {
        ArrayList arrayList = new ArrayList();
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_decode_rs232_rx);
        if (getRs232_tx() == ServiceEnum.Chan.chan_none.value1) {
            for (MappingObject mappingObject : list) {
                if (mappingObject.getValue() > ServiceEnum.Chan.chan_none.value1) {
                    arrayList.add(mappingObject);
                }
            }
        } else {
            arrayList.addAll(0, list);
        }
        return arrayList;
    }

    public List<MappingObject> getMisoChanList() {
        ArrayList arrayList = new ArrayList();
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_decode_spi_miso);
        if (getSpi_mosi() == ServiceEnum.Chan.chan_none.value1) {
            for (MappingObject mappingObject : list) {
                if (mappingObject.getValue() > ServiceEnum.Chan.chan_none.value1) {
                    arrayList.add(mappingObject);
                }
            }
        } else {
            arrayList.addAll(0, list);
        }
        return arrayList;
    }

    public List<MappingObject> getMosiChanList() {
        ArrayList arrayList = new ArrayList();
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_decode_spi_mosi);
        if (getSpi_miso() == ServiceEnum.Chan.chan_none.value1) {
            for (MappingObject mappingObject : list) {
                if (mappingObject.getValue() > ServiceEnum.Chan.chan_none.value1) {
                    arrayList.add(mappingObject);
                }
            }
        } else {
            arrayList.addAll(0, list);
        }
        return arrayList;
    }

    public ServiceEnum.Unit getUnit() {
        return ServiceEnum.Unit.Unit_V;
    }

    public void setChanColor(View view, ServiceEnum.Chan chan) {
        if (chan != null) {
            ((TextView) view).setTextColor(ColorUtil.getColor(view.getContext(), chan));
        }
    }

    public long getDecodeThres(int i, int i2) {
        return API.getInstance().UI_QueryInt64(i, i2);
    }

    public void checkThres() {
        if (getType() == ServiceEnum.DecodeBusType.Decode_Parallel) {
            long UI_QueryInt64 = API.getInstance().UI_QueryInt64(this.pal_clk + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt642 = API.getInstance().UI_QueryInt64(this.pal_clk + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j = (UI_QueryInt64 * 5) - UI_QueryInt642;
            long j2 = (UI_QueryInt64 * (-5)) - UI_QueryInt642;
            long UI_QueryInt643 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_PAL_CLK_THRE);
            if (UI_QueryInt643 > j) {
                setPal_clk_thres(j);
            } else if (UI_QueryInt643 < j2) {
                setPal_clk_thres(j2);
            } else {
                setPal_clk_thres(UI_QueryInt643);
            }
            int i = this.pal_bus;
            if (i == 11) {
                i = this.bus_chan;
            }
            int i2 = i + 0;
            long UI_QueryInt644 = API.getInstance().UI_QueryInt64(i2, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt645 = API.getInstance().UI_QueryInt64(i2, MessageID.MSG_CHAN_OFFSET_REAL);
            long j3 = (5 * UI_QueryInt644) - UI_QueryInt645;
            long j4 = (UI_QueryInt644 * (-5)) - UI_QueryInt645;
            long UI_QueryInt646 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_PAL_DAT_THRE);
            if (UI_QueryInt646 > j3) {
                setPal_dat_thres(j3);
            } else if (UI_QueryInt646 < j4) {
                setPal_dat_thres(j4);
            } else {
                setPal_dat_thres(UI_QueryInt646);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_RS232) {
            long UI_QueryInt647 = API.getInstance().UI_QueryInt64(this.rs232_tx + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt648 = API.getInstance().UI_QueryInt64(this.rs232_tx + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j5 = (UI_QueryInt647 * 5) - UI_QueryInt648;
            long j6 = (UI_QueryInt647 * (-5)) - UI_QueryInt648;
            long UI_QueryInt649 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_TX_THRE);
            if (UI_QueryInt649 > j5) {
                setRs232_tx_thres(j5);
            } else if (UI_QueryInt649 < j6) {
                setRs232_tx_thres(j6);
            } else {
                setRs232_tx_thres(UI_QueryInt649);
            }
            long UI_QueryInt6410 = API.getInstance().UI_QueryInt64(this.rs232_rx + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6411 = API.getInstance().UI_QueryInt64(this.rs232_rx + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j7 = (5 * UI_QueryInt6410) - UI_QueryInt6411;
            long j8 = (UI_QueryInt6410 * (-5)) - UI_QueryInt6411;
            long UI_QueryInt6412 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_RX_THRE);
            if (UI_QueryInt6412 > j7) {
                setRs232_rx_thres(j7);
            } else if (UI_QueryInt6412 < j8) {
                setRs232_rx_thres(j8);
            } else {
                setRs232_rx_thres(UI_QueryInt6412);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_I2C) {
            long UI_QueryInt6413 = API.getInstance().UI_QueryInt64(this.i2c_scl + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6414 = API.getInstance().UI_QueryInt64(this.i2c_scl + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j9 = (UI_QueryInt6413 * 5) - UI_QueryInt6414;
            long j10 = (UI_QueryInt6413 * (-5)) - UI_QueryInt6414;
            long UI_QueryInt6415 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_SCL_THRE);
            if (UI_QueryInt6415 > j9) {
                setI2c_scl_thres(j9);
            } else if (UI_QueryInt6415 < j10) {
                setI2c_scl_thres(j10);
            } else {
                setI2c_scl_thres(UI_QueryInt6415);
            }
            long UI_QueryInt6416 = API.getInstance().UI_QueryInt64(this.i2c_sda + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6417 = API.getInstance().UI_QueryInt64(this.i2c_sda + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j11 = (5 * UI_QueryInt6416) - UI_QueryInt6417;
            long j12 = (UI_QueryInt6416 * (-5)) - UI_QueryInt6417;
            long UI_QueryInt6418 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_SDA_THRE);
            if (UI_QueryInt6418 > j11) {
                setI2c_sda_thres(j11);
            } else if (UI_QueryInt6418 < j12) {
                setI2c_sda_thres(j12);
            } else {
                setI2c_sda_thres(UI_QueryInt6418);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_SPI) {
            long UI_QueryInt6419 = API.getInstance().UI_QueryInt64(this.spi_clock + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6420 = API.getInstance().UI_QueryInt64(this.spi_clock + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j13 = (UI_QueryInt6419 * 5) - UI_QueryInt6420;
            long j14 = (UI_QueryInt6419 * (-5)) - UI_QueryInt6420;
            long UI_QueryInt6421 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_CLK_THRE);
            if (UI_QueryInt6421 > j13) {
                setSpi_clock_thres(j13);
            } else if (UI_QueryInt6421 < j14) {
                setSpi_clock_thres(j14);
            } else {
                setSpi_clock_thres(UI_QueryInt6421);
            }
            long UI_QueryInt6422 = API.getInstance().UI_QueryInt64(this.spi_miso + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6423 = API.getInstance().UI_QueryInt64(this.spi_miso + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j15 = (UI_QueryInt6422 * 5) - UI_QueryInt6423;
            long j16 = (UI_QueryInt6422 * (-5)) - UI_QueryInt6423;
            long UI_QueryInt6424 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_MISO_THRE);
            if (UI_QueryInt6424 > j15) {
                setSpi_miso_thres(j15);
            } else if (UI_QueryInt6424 < j16) {
                setSpi_miso_thres(j16);
            } else {
                setSpi_miso_thres(UI_QueryInt6424);
            }
            long UI_QueryInt6425 = API.getInstance().UI_QueryInt64(this.spi_mosi + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6426 = API.getInstance().UI_QueryInt64(this.spi_mosi + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j17 = (UI_QueryInt6425 * 5) - UI_QueryInt6426;
            long j18 = (UI_QueryInt6425 * (-5)) - UI_QueryInt6426;
            long UI_QueryInt6427 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_MOSI_THRE);
            if (UI_QueryInt6427 > j17) {
                setSpi_mosi_thres(j17);
            } else if (UI_QueryInt6427 < j18) {
                setSpi_mosi_thres(j18);
            } else {
                setSpi_mosi_thres(UI_QueryInt6427);
            }
            long UI_QueryInt6428 = API.getInstance().UI_QueryInt64(this.spi_cs + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6429 = API.getInstance().UI_QueryInt64(this.spi_cs + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j19 = (5 * UI_QueryInt6428) - UI_QueryInt6429;
            long j20 = (UI_QueryInt6428 * (-5)) - UI_QueryInt6429;
            long UI_QueryInt6430 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_CS_THRE);
            if (UI_QueryInt6430 > j19) {
                setSpi_cs_thres(j19);
            } else if (UI_QueryInt6430 < j20) {
                setSpi_cs_thres(j20);
            } else {
                setSpi_cs_thres(UI_QueryInt6430);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_LIN) {
            long UI_QueryInt6431 = API.getInstance().UI_QueryInt64(this.lin_source + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6432 = API.getInstance().UI_QueryInt64(this.lin_source + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j21 = (5 * UI_QueryInt6431) - UI_QueryInt6432;
            long j22 = (UI_QueryInt6431 * (-5)) - UI_QueryInt6432;
            long UI_QueryInt6433 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_LIN_THRE);
            if (UI_QueryInt6433 > j21) {
                setLin_thres(j21);
            } else if (UI_QueryInt6433 < j22) {
                setLin_thres(j22);
            } else {
                setLin_thres(UI_QueryInt6433);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_CAN) {
            long UI_QueryInt6434 = API.getInstance().UI_QueryInt64(this.can_source + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6435 = API.getInstance().UI_QueryInt64(this.can_source + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j23 = (5 * UI_QueryInt6434) - UI_QueryInt6435;
            long j24 = (UI_QueryInt6434 * (-5)) - UI_QueryInt6435;
            long UI_QueryInt6436 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_CAN_THRE);
            if (UI_QueryInt6436 > j23) {
                setCan_threas(j23);
            } else if (UI_QueryInt6436 < j24) {
                setCan_threas(j24);
            } else {
                setCan_threas(UI_QueryInt6436);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_FlexRay) {
            long UI_QueryInt6437 = API.getInstance().UI_QueryInt64(this.flex_source + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6438 = API.getInstance().UI_QueryInt64(this.flex_source + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j25 = (5 * UI_QueryInt6437) - UI_QueryInt6438;
            long j26 = (UI_QueryInt6437 * (-5)) - UI_QueryInt6438;
            long UI_QueryInt6439 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_FLEX_THRE);
            if (UI_QueryInt6439 > j25) {
                setFlex_thres(j25);
            } else if (UI_QueryInt6439 < j26) {
                setFlex_thres(j26);
            } else {
                setFlex_thres(UI_QueryInt6439);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_I2S) {
            long UI_QueryInt6440 = API.getInstance().UI_QueryInt64(this.i2s_sclock + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6441 = API.getInstance().UI_QueryInt64(this.i2s_sclock + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j27 = (UI_QueryInt6440 * 5) - UI_QueryInt6441;
            long j28 = (UI_QueryInt6440 * (-5)) - UI_QueryInt6441;
            long UI_QueryInt6442 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_I2S_SCLK_THRE);
            if (UI_QueryInt6442 > j27) {
                setI2s_sclock_thres(j27);
            } else if (UI_QueryInt6442 < j28) {
                setI2s_sclock_thres(j28);
            } else {
                setI2s_sclock_thres(UI_QueryInt6442);
            }
            long UI_QueryInt6443 = API.getInstance().UI_QueryInt64(this.i2s_ws + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6444 = API.getInstance().UI_QueryInt64(this.i2s_ws + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j29 = (UI_QueryInt6443 * 5) - UI_QueryInt6444;
            long j30 = (UI_QueryInt6443 * (-5)) - UI_QueryInt6444;
            long UI_QueryInt6445 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_I2S_WS_THRE);
            if (UI_QueryInt6445 > j29) {
                setI2s_wave_singal_thres(j29);
            } else if (UI_QueryInt6445 < j30) {
                setI2s_wave_singal_thres(j30);
            } else {
                setI2s_wave_singal_thres(UI_QueryInt6445);
            }
            long UI_QueryInt6446 = API.getInstance().UI_QueryInt64(this.i2s_data + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6447 = API.getInstance().UI_QueryInt64(this.i2s_data + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j31 = (5 * UI_QueryInt6446) - UI_QueryInt6447;
            long j32 = (UI_QueryInt6446 * (-5)) - UI_QueryInt6447;
            long UI_QueryInt6448 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_I2S_DATA_THRE);
            if (UI_QueryInt6448 > j31) {
                setI2s_data_thres(j31);
            } else if (UI_QueryInt6448 < j32) {
                setI2s_data_thres(j32);
            } else {
                setI2s_data_thres(UI_QueryInt6448);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_1553B) {
            long UI_QueryInt6449 = API.getInstance().UI_QueryInt64(this._1553b_source + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6450 = API.getInstance().UI_QueryInt64(this._1553b_source + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j33 = (5 * UI_QueryInt6449) - UI_QueryInt6450;
            long j34 = (UI_QueryInt6449 * (-5)) - UI_QueryInt6450;
            long UI_QueryInt6451 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_1553B_THRE1);
            if (UI_QueryInt6451 > j33) {
                set_1553b_thres1(j33);
            } else if (UI_QueryInt6451 < j34) {
                set_1553b_thres1(j34);
            } else {
                set_1553b_thres1(UI_QueryInt6451);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_ARINC429) {
            long UI_QueryInt6452 = API.getInstance().UI_QueryInt64(this.arinc429_source + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6453 = API.getInstance().UI_QueryInt64(this.arinc429_source + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j35 = (5 * UI_QueryInt6452) - UI_QueryInt6453;
            long j36 = (UI_QueryInt6452 * (-5)) - UI_QueryInt6453;
            long UI_QueryInt6454 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_ARINC429_UP_THRE);
            long UI_QueryInt6455 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_ARINC429_DOWN_THRE);
            if (UI_QueryInt6454 > j35) {
                setArinc429_up_thres(j35);
            } else {
                setArinc429_up_thres(UI_QueryInt6454);
            }
            if (UI_QueryInt6455 < j36) {
                setArinc429_down_thres(j36);
            } else {
                setArinc429_down_thres(UI_QueryInt6455);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_SENT) {
            long UI_QueryInt6456 = API.getInstance().UI_QueryInt64(this.sent_source + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6457 = API.getInstance().UI_QueryInt64(this.sent_source + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j37 = (5 * UI_QueryInt6456) - UI_QueryInt6457;
            long j38 = (UI_QueryInt6456 * (-5)) - UI_QueryInt6457;
            long UI_QueryInt6458 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_SENT_THRE);
            if (UI_QueryInt6458 > j37) {
                setSent_thres(j37);
            } else if (UI_QueryInt6458 < j38) {
                setSent_thres(j38);
            } else {
                setSent_thres(UI_QueryInt6458);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_MOST) {
            long UI_QueryInt6459 = API.getInstance().UI_QueryInt64(this.most_source + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6460 = API.getInstance().UI_QueryInt64(this.most_source + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j39 = (5 * UI_QueryInt6459) - UI_QueryInt6460;
            long j40 = (UI_QueryInt6459 * (-5)) - UI_QueryInt6460;
            long UI_QueryInt6461 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_MOST_THRE);
            if (UI_QueryInt6461 > j39) {
                setMost_thres(j39);
            } else if (UI_QueryInt6461 < j40) {
                setMost_thres(j40);
            } else {
                setMost_thres(UI_QueryInt6461);
            }
        } else if (getType() == ServiceEnum.DecodeBusType.Decode_USB) {
            long UI_QueryInt6462 = API.getInstance().UI_QueryInt64(this.usb_dp + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6463 = API.getInstance().UI_QueryInt64(this.usb_dp + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j41 = (UI_QueryInt6462 * 5) - UI_QueryInt6463;
            long j42 = (UI_QueryInt6462 * (-5)) - UI_QueryInt6463;
            long UI_QueryInt6464 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_USB_DP_THRE);
            if (UI_QueryInt6464 > j41) {
                setUsb_dp_thres(j41);
            } else if (UI_QueryInt6464 < j42) {
                setUsb_dp_thres(j42);
            } else {
                setUsb_dp_thres(UI_QueryInt6464);
            }
            long UI_QueryInt6465 = API.getInstance().UI_QueryInt64(this.usb_ds + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6466 = API.getInstance().UI_QueryInt64(this.usb_ds + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j43 = (UI_QueryInt6465 * 5) - UI_QueryInt6466;
            long j44 = (UI_QueryInt6465 * (-5)) - UI_QueryInt6466;
            long UI_QueryInt6467 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_USB_DS_THRE);
            if (UI_QueryInt6467 > j43) {
                setUsb_ds_thres(j43);
            } else if (UI_QueryInt6467 < j44) {
                setUsb_ds_thres(j44);
            } else {
                setUsb_ds_thres(UI_QueryInt6467);
            }
            long UI_QueryInt6468 = API.getInstance().UI_QueryInt64(this.usb_diff + 0, MessageID.MSG_CHAN_SCALE_REAL);
            long UI_QueryInt6469 = API.getInstance().UI_QueryInt64(this.usb_diff + 0, MessageID.MSG_CHAN_OFFSET_REAL);
            long j45 = (5 * UI_QueryInt6468) - UI_QueryInt6469;
            long j46 = (UI_QueryInt6468 * (-5)) - UI_QueryInt6469;
            long UI_QueryInt6470 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_USB_DIFF_THRE_H);
            long UI_QueryInt6471 = API.getInstance().UI_QueryInt64(getServiceId(), MessageID.MSG_DECODE_USB_DIFF_THRE_L);
            if (UI_QueryInt6470 > j45) {
                setUsb_diff_high_thres(j45);
            } else {
                setUsb_diff_high_thres(UI_QueryInt6470);
            }
            if (UI_QueryInt6471 < j46) {
                setUsb_diff_low_thres(j46);
            } else {
                setUsb_diff_low_thres(UI_QueryInt6471);
            }
        }
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setFormat(0);
        setEvent_format(0);
        setLabel(true);
        setEvent(false);
    }
}
