package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.UnitFormat;
import java.util.Objects;

/* loaded from: classes2.dex */
public class WaveRecordParam extends BaseParam {
    private static final boolean DEFAULT_BEEPER = true;
    private static final int DEFAULT_CURRENT = 0;
    private static final int DEFAULT_CURRENTFRAMES = 0;
    private static final int DEFAULT_ENDFRAME = 0;
    private static final boolean DEFAULT_FRAMESTART = false;
    private static final int DEFAULT_MAXFRAMES = 1000;
    private static final boolean DEFAULT_ONOFF = false;
    private static final boolean DEFAULT_PLAY = false;
    private static final boolean DEFAULT_PLAYDIR = false;
    private static final boolean DEFAULT_PLAYMODE = false;
    private static final int DEFAULT_RECORDFRAMES = 1000;
    private static final boolean DEFAULT_START = false;
    private static final int DEFAULT_STARTFRAME = 0;
    private static final String DEFAULT_TIME = "0.00000000s";
    private static final boolean DEFAULT_WINMIN = false;
    private MessageAttr currentAttr;
    private MessageAttr endFrameAttr;
    private MessageAttr playIntervalAttr;
    private int progressStr;
    private boolean recordBeeper;
    private int recordCurrent;
    private int recordCurrentFrames;
    private int recordEndFrame;
    private boolean recordFrameStart;
    private int recordFrames;
    private MessageAttr recordFramesAttr;
    private long recordInterval;
    private MessageAttr recordIntervalAttr;
    private int recordMaxFrames;
    private boolean recordMin;
    private boolean recordOnOff;
    private boolean recordPlay;
    private boolean recordPlayDir;
    private long recordPlayInterval;
    private boolean recordPlayMode;
    private boolean recordStart;
    private int recordStartFrame;
    private MessageAttr startFrameAttr;
    private ServiceEnum.RecordState state;
    private String time;
    private static final ServiceEnum.RecordState DEFAULT_STATE = ServiceEnum.RecordState.Record_disable;
    private static final long DEFAULT_PLAYTNTERVAL = (long) (Math.pow(1000.0d, UnitFormat.SI.MILLI.scale - UnitFormat.SI.FEMTO.scale) * 100.0d);
    private static final long DEFAULT_RECORDINTRVAL = (long) (Math.pow(1000.0d, UnitFormat.SI.NANO.scale - UnitFormat.SI.FEMTO.scale) * 10.0d);

    public WaveRecordParam() {
        super(14);
        this.recordOnOff = false;
        this.recordStart = false;
        this.recordPlay = false;
        this.recordCurrent = 0;
        this.state = DEFAULT_STATE;
        this.recordCurrentFrames = 0;
        this.recordFrameStart = false;
        this.recordPlayMode = false;
        this.recordPlayDir = false;
        this.recordPlayInterval = DEFAULT_PLAYTNTERVAL;
        this.recordStartFrame = 0;
        this.recordEndFrame = 0;
        this.recordInterval = DEFAULT_RECORDINTRVAL;
        this.recordFrames = 1000;
        this.recordMaxFrames = 1000;
        this.recordBeeper = true;
        this.recordMin = false;
        this.time = DEFAULT_TIME;
        this.progressStr = 0;
        this.recordFramesAttr = new MessageAttr();
        this.recordIntervalAttr = new MessageAttr();
        this.currentAttr = new MessageAttr();
        this.playIntervalAttr = new MessageAttr();
        this.startFrameAttr = new MessageAttr();
        this.endFrameAttr = new MessageAttr();
    }

    @Bindable
    public boolean isRecordOnOff() {
        return this.recordOnOff;
    }

    public void setRecordOnOff(boolean z) {
        this.recordOnOff = z;
        notifyPropertyChanged(703);
    }

    @Bindable
    public boolean isRecordStart() {
        return this.recordStart;
    }

    @Bindable
    public int getProgressStr() {
        return this.progressStr;
    }

    public void setRecordStart(boolean z) {
        this.recordStart = z;
        notifyPropertyChanged(708);
    }

    @Bindable
    public boolean isRecordPlay() {
        return this.recordPlay;
    }

    public void setRecordPlay(boolean z) {
        this.recordPlay = z;
        notifyPropertyChanged(704);
    }

    @Bindable
    public int getRecordCurrent() {
        return this.recordCurrent;
    }

    public void setRecordCurrent(int i) {
        this.recordCurrent = i;
        if (isRecordStart()) {
            return;
        }
        notifyPropertyChanged(695);
    }

    @Bindable
    public boolean isRecordFrameStart() {
        return this.recordFrameStart;
    }

    public void setRecordFrameStart(boolean z) {
        this.recordFrameStart = z;
        notifyPropertyChanged(698);
    }

    @Bindable
    public boolean isRecordPlayMode() {
        return this.recordPlayMode;
    }

    public void setRecordPlayMode(boolean z) {
        this.recordPlayMode = z;
        notifyPropertyChanged(707);
    }

    @Bindable
    public boolean isRecordPlayDir() {
        return this.recordPlayDir;
    }

    public void setRecordPlayDir(boolean z) {
        this.recordPlayDir = z;
        notifyPropertyChanged(705);
    }

    @Bindable
    public long getRecordPlayInterval() {
        return this.recordPlayInterval;
    }

    public void setRecordPlayInterval(long j) {
        this.recordPlayInterval = j;
        notifyPropertyChanged(706);
    }

    @Bindable
    public int getRecordStartFrame() {
        return this.recordStartFrame;
    }

    public void setRecordStartFrame(int i) {
        this.recordStartFrame = i;
        if (isRecordStart()) {
            return;
        }
        notifyPropertyChanged(709);
    }

    @Bindable
    public int getRecordEndFrame() {
        return this.recordEndFrame;
    }

    public void setRecordEndFrame(int i) {
        this.recordEndFrame = i;
        if (isRecordStart()) {
            return;
        }
        notifyPropertyChanged(697);
    }

    @Bindable
    public long getRecordInterval() {
        return this.recordInterval;
    }

    public void setRecordInterval(long j) {
        this.recordInterval = j;
        notifyPropertyChanged(700);
    }

    @Bindable
    public int getRecordFrames() {
        return this.recordFrames;
    }

    public void setRecordFrames(int i) {
        this.recordFrames = i;
        notifyPropertyChanged(699);
    }

    @Bindable
    public int getRecordMaxFrames() {
        return this.recordMaxFrames;
    }

    public void setRecordMaxFrames(int i) {
        this.recordMaxFrames = i;
        notifyPropertyChanged(701);
    }

    @Bindable
    public boolean isRecordBeeper() {
        return this.recordBeeper;
    }

    public void setRecordBeeper(boolean z) {
        this.recordBeeper = z;
        notifyPropertyChanged(694);
    }

    @Bindable
    public boolean isRecordMin() {
        return this.recordMin;
    }

    public void setRecordMin(boolean z) {
        this.recordMin = z;
        notifyPropertyChanged(702);
    }

    @Bindable
    public int getRecordCurrentFrames() {
        return this.recordCurrentFrames;
    }

    public void setRecordCurrentFrames(int i) {
        this.recordCurrentFrames = i;
        notifyPropertyChanged(696);
    }

    @Bindable
    public ServiceEnum.RecordState getState() {
        return this.state;
    }

    public void setState(ServiceEnum.RecordState recordState) {
        this.state = recordState;
        notifyPropertyChanged(906);
    }

    @Bindable
    public String getTime() {
        return this.time;
    }

    public void setTime(String str) {
        this.time = str;
        notifyPropertyChanged(934);
    }

    public MessageAttr getRecordFramesAttr() {
        return this.recordFramesAttr;
    }

    public void setRecordFramesAttr(MessageAttr messageAttr) {
        this.recordFramesAttr = messageAttr;
    }

    public MessageAttr getRecordIntervalAttr() {
        return this.recordIntervalAttr;
    }

    public void setRecordIntervalAttr(MessageAttr messageAttr) {
        this.recordIntervalAttr = messageAttr;
    }

    public MessageAttr getCurrentAttr() {
        return this.currentAttr;
    }

    public void setCurrentAttr(MessageAttr messageAttr) {
        this.currentAttr = messageAttr;
    }

    public MessageAttr getPlayIntervalAttr() {
        return this.playIntervalAttr;
    }

    public void setPlayIntervalAttr(MessageAttr messageAttr) {
        this.playIntervalAttr = messageAttr;
    }

    public MessageAttr getStartFrameAttr() {
        return this.startFrameAttr;
    }

    public void setStartFrameAttr(MessageAttr messageAttr) {
        this.startFrameAttr = messageAttr;
    }

    public MessageAttr getEndFrameAttr() {
        return this.endFrameAttr;
    }

    public void setEndFrameAttr(MessageAttr messageAttr) {
        this.endFrameAttr = messageAttr;
    }

    public boolean readRecordOnOff() {
        setRecordOnOff(readBool(MessageID.MSG_RECORD_ONOFF));
        return this.recordOnOff;
    }

    public void saveRecordOnOff(boolean z) {
        setRecordOnOff(z);
        saveBool(MessageID.MSG_RECORD_ONOFF, z);
    }

    public boolean readRecordStart() {
        setRecordStart(readBool(MessageID.MSG_RECORD_START));
        return this.recordStart;
    }

    public void saveRecordStart(boolean z) {
        setRecordStart(z);
        saveBool(MessageID.MSG_RECORD_START, z);
    }

    public boolean readRecordPlay() {
        setRecordPlay(readBool(MessageID.MSG_RECORD_PLAY));
        return this.recordPlay;
    }

    public void saveRecordPlay(boolean z) {
        setRecordPlay(z);
        saveBool(MessageID.MSG_RECORD_PLAY, z);
    }

    public int readRecordCurrent() {
        setRecordCurrent(readInt(MessageID.MSG_RECORD_CURRENT));
        return this.recordCurrent;
    }

    public void saveRecordCurrent(int i) {
        readCurrentAttr();
        if (i > getCurrentAttr().getMaxIntValue()) {
            i = getCurrentAttr().getMaxIntValue();
        }
        if (i < getCurrentAttr().getMinIntValue()) {
            i = getCurrentAttr().getMinIntValue();
        }
        setRecordCurrent(i);
        saveInt(MessageID.MSG_RECORD_CURRENT, i);
    }

    public boolean readRecordFrameStart() {
        setRecordFrameStart(readBool(MessageID.MSG_RECORD_FRAMESTART));
        return this.recordFrameStart;
    }

    public void saveRecordFrameStart(boolean z) {
        setRecordFrameStart(z);
        saveBool(MessageID.MSG_RECORD_FRAMESTART, z);
    }

    public boolean readRecordPlayMode() {
        setRecordPlayMode(readBool(MessageID.MSG_RECORD_PLAYMODE));
        return this.recordPlayMode;
    }

    public void saveRecordPlayMode(boolean z) {
        setRecordPlayMode(z);
        saveBool(MessageID.MSG_RECORD_PLAYMODE, z);
    }

    public boolean readRecordPlayDir() {
        setRecordPlayDir(readBool(MessageID.MSG_RECORD_PLAYDIR));
        return this.recordPlayDir;
    }

    public void saveRecordPlayDir(boolean z) {
        setRecordPlayDir(z);
        saveBool(MessageID.MSG_RECORD_PLAYDIR, z);
    }

    public long readRecordPlayInterval() {
        setRecordPlayInterval(readLong(MessageID.MSG_RECORD_PLAYINTERVAL));
        return this.recordPlayInterval;
    }

    public void saveRecordPlayInterval(long j) {
        setRecordPlayInterval(j);
        saveLong(MessageID.MSG_RECORD_PLAYINTERVAL, j);
    }

    public int readRecordStartFrame() {
        setRecordStartFrame(readInt(MessageID.MSG_RECORD_STARTFRAME));
        return this.recordStartFrame;
    }

    public void saveRecordStartFrame(int i) {
        setRecordStartFrame(i);
        saveInt(MessageID.MSG_RECORD_STARTFRAME, i);
    }

    public int readRecordEndFrame() {
        setRecordEndFrame(readInt(MessageID.MSG_RECORD_ENDFRAME));
        return this.recordEndFrame;
    }

    public void saveRecordEndFrame(int i) {
        setRecordEndFrame(i);
        saveInt(MessageID.MSG_RECORD_ENDFRAME, i);
    }

    public long readRecordInterval() {
        setRecordInterval(readLong(MessageID.MSG_RECORD_INTERVAL));
        return this.recordInterval;
    }

    public void saveRecordInterval(long j) {
        setRecordInterval(j);
        saveLong(MessageID.MSG_RECORD_INTERVAL, j);
    }

    public int readRecordFrames() {
        setRecordFrames(readInt(MessageID.MSG_RECORD_FRAMES));
        return this.recordFrames;
    }

    public void saveRecordFrames(int i) {
        setRecordFrames(i);
        saveInt(MessageID.MSG_RECORD_FRAMES, i);
    }

    public int readRecordMaxFrames() {
        setRecordMaxFrames(readInt(MessageID.MSG_RECORD_MAXFRAMES));
        return this.recordMaxFrames;
    }

    public void saveRecordMaxFrames(int i) {
        setRecordMaxFrames(i);
        saveInt(MessageID.MSG_RECORD_MAXFRAMES, i);
    }

    public boolean readRecordBeeper() {
        setRecordBeeper(readBool(MessageID.MSG_RECORD_BEEPER));
        return this.recordBeeper;
    }

    public void saveRecordBeeper(boolean z) {
        setRecordBeeper(z);
        saveBool(MessageID.MSG_RECORD_BEEPER, z);
    }

    public int readRecordCurrentFrames() {
        setRecordCurrentFrames(readInt(MessageID.MSG_REC_RECED_COUNT));
        return this.recordCurrentFrames;
    }

    public ServiceEnum.RecordState readState() {
        setState(ServiceEnum.getRecordStateFromValue1(readInt(MessageID.MSG_REC_INNER_STATE)));
        return this.state;
    }

    public String readTime() {
        setTime(readStr(MessageID.MSG_REC_TIME_STAMP));
        return this.time;
    }

    public void readRecordFramesAttr() {
        readAttr(MessageID.MSG_RECORD_FRAMES, this.recordFramesAttr);
    }

    public void readRecordIntervalAttr() {
        readAttr(MessageID.MSG_RECORD_INTERVAL, this.recordIntervalAttr);
    }

    public void readCurrentAttr() {
        readAttr(MessageID.MSG_RECORD_CURRENT, this.currentAttr);
    }

    public void readPlayIntervalAttr() {
        readAttr(MessageID.MSG_RECORD_PLAYINTERVAL, this.playIntervalAttr);
    }

    public void readStartFrameAttr() {
        readAttr(MessageID.MSG_RECORD_STARTFRAME, this.startFrameAttr);
    }

    public void readEndFrameAttr() {
        readAttr(MessageID.MSG_RECORD_ENDFRAME, this.endFrameAttr);
    }

    public void readAllAttr() {
        readRecordFramesAttr();
        readRecordIntervalAttr();
        readCurrentAttr();
        readPlayIntervalAttr();
        readStartFrameAttr();
        readEndFrameAttr();
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readRecordBeeper();
        readRecordCurrent();
        readRecordEndFrame();
        readRecordFrameStart();
        readRecordInterval();
        readRecordOnOff();
        readRecordPlay();
        readRecordPlayDir();
        readRecordPlayInterval();
        readRecordPlayMode();
        readRecordStart();
        readRecordStartFrame();
        readRecordCurrentFrames();
        readState();
        readAllAttr();
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setRecordOnOff(false);
        setRecordStart(false);
        setRecordPlay(false);
        setRecordCurrent(0);
        setState(DEFAULT_STATE);
        setRecordCurrentFrames(0);
        setRecordFrameStart(false);
        setRecordPlayMode(false);
        setRecordPlayDir(false);
        setRecordPlayInterval(DEFAULT_PLAYTNTERVAL);
        setRecordStartFrame(0);
        setRecordEndFrame(0);
        setRecordInterval(DEFAULT_RECORDINTRVAL);
        setRecordFrames(1000);
        setRecordMaxFrames(1000);
        setRecordBeeper(true);
        setRecordMin(false);
        setTime(DEFAULT_TIME);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WaveRecordParam waveRecordParam = (WaveRecordParam) obj;
        return this.recordOnOff == waveRecordParam.recordOnOff && this.recordStart == waveRecordParam.recordStart && this.recordPlay == waveRecordParam.recordPlay && this.recordCurrent == waveRecordParam.recordCurrent && this.recordFrameStart == waveRecordParam.recordFrameStart && this.recordPlayMode == waveRecordParam.recordPlayMode && this.recordPlayDir == waveRecordParam.recordPlayDir && this.recordPlayInterval == waveRecordParam.recordPlayInterval && this.recordStartFrame == waveRecordParam.recordStartFrame && this.recordEndFrame == waveRecordParam.recordEndFrame && this.recordInterval == waveRecordParam.recordInterval && this.recordFrames == waveRecordParam.recordFrames && this.recordMaxFrames == waveRecordParam.recordMaxFrames && this.recordBeeper == waveRecordParam.recordBeeper;
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.recordOnOff), Boolean.valueOf(this.recordStart), Boolean.valueOf(this.recordPlay), Integer.valueOf(this.recordCurrent), Boolean.valueOf(this.recordFrameStart), Boolean.valueOf(this.recordPlayMode), Boolean.valueOf(this.recordPlayDir), Long.valueOf(this.recordPlayInterval), Integer.valueOf(this.recordStartFrame), Integer.valueOf(this.recordEndFrame), Long.valueOf(this.recordInterval), Integer.valueOf(this.recordFrames), Integer.valueOf(this.recordMaxFrames), Boolean.valueOf(this.recordBeeper));
    }
}
