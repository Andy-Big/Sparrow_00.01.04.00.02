package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: NavigateParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010@\u001a\u00020\rJ\b\u0010A\u001a\u00020BH\u0016J\u0006\u0010C\u001a\u00020BJ\u0006\u0010D\u001a\u00020\u0016J\u0006\u0010E\u001a\u00020BJ\u0006\u0010F\u001a\u00020%J\u0006\u0010G\u001a\u00020BJ\u0006\u0010H\u001a\u00020%J\u0006\u0010I\u001a\u00020%J\u0006\u0010J\u001a\u00020\u0004J\u0006\u0010K\u001a\u00020%J\u0006\u00101\u001a\u00020\u0004J\u0006\u0010L\u001a\u00020\u0004J\u0006\u0010M\u001a\u00020BJ\u0006\u0010N\u001a\u00020\u0016J\u0006\u0010O\u001a\u00020BJ\u0006\u0010P\u001a\u00020%J\u0006\u0010Q\u001a\u00020BJ\b\u0010R\u001a\u00020BH\u0016J\u0016\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0004J\u000e\u0010V\u001a\u00020B2\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010W\u001a\u00020B2\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010X\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0004J\u000e\u0010Y\u001a\u00020B2\u0006\u0010\u001f\u001a\u00020\u0004J\u0006\u0010Z\u001a\u00020BJ\u000e\u0010[\u001a\u00020B2\u0006\u0010.\u001a\u00020%J\u000e\u0010\\\u001a\u00020B2\u0006\u0010U\u001a\u00020\u0004J\u0016\u0010]\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0004J\u0016\u0010^\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010_\u001a\u00020%J\u000e\u0010`\u001a\u00020B2\u0006\u0010:\u001a\u00020\u0004J\u0016\u0010a\u001a\u00020B2\u0006\u0010T\u001a\u00020\u00042\u0006\u0010U\u001a\u00020\u0004J\u000e\u0010a\u001a\u00020B2\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010b\u001a\u00020B2\u0006\u0010=\u001a\u00020\u0004J\u0006\u0010c\u001a\u00020BR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR&\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR&\u0010\"\u001a\u00020\u00162\u0006\u0010\u0007\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR&\u0010&\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020%8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R&\u0010+\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\n\"\u0004\b-\u0010\fR&\u0010.\u001a\u00020%2\u0006\u0010\u0007\u001a\u00020%8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R&\u00101\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\n\"\u0004\b3\u0010\fR&\u00104\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\n\"\u0004\b6\u0010\fR&\u00107\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\n\"\u0004\b9\u0010\fR&\u0010:\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\n\"\u0004\b<\u0010\fR&\u0010=\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\n\"\u0004\b?\u0010\f¨\u0006d"}, d2 = {"Lcom/rigol/scope/data/NavigateParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "DEFAULT_FRAMEMODE", "", "DEFAULT_SEARCHTYPE", "DEFAULT_TIMESPEED", "value", "currentPage", "getCurrentPage", "()I", "setCurrentPage", "(I)V", "Lcom/rigol/scope/cil/MessageAttr;", "endFrameAttr", "getEndFrameAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "setEndFrameAttr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "frameAttr", "getFrameAttr", "setFrameAttr", "", "frameDisplayFrame", "getFrameDisplayFrame", "()J", "setFrameDisplayFrame", "(J)V", "frameMode", "getFrameMode", "setFrameMode", "frameSpeed", "getFrameSpeed", "setFrameSpeed", "frameStartFrame", "getFrameStartFrame", "setFrameStartFrame", "", "ifPlaying", "getIfPlaying", "()Z", "setIfPlaying", "(Z)V", "maxPage", "getMaxPage", "setMaxPage", "navEnable", "getNavEnable", "setNavEnable", "readNavMode", "getReadNavMode", "setReadNavMode", "readRunStop", "getReadRunStop", "setReadRunStop", "selectMode", "getSelectMode", "setSelectMode", "serchType", "getSerchType", "setSerchType", "timeSpeed", "getTimeSpeed", "setTimeSpeed", "getFramesAttr", "readAll", "", "readDisPlayMode", "readDisplayFrame", "readEndFrameAttr", "readFramePlay", "readFrameSpeed", "readHorRun", "readIsOutFrame", "readMaxPage", "readNavEnable", "readPage", "readSerchType", "readStartFrame", "readStartFrameAttr", "readTimePlay", "readTimeSpeed", "reset", "saveBackFrame", "messageID", "position", "saveDisPlayMode", "saveDisplayFrame", "saveEndFrame", "saveFrameSpeed", "saveIsOutFrame", "saveNavEnable", "saveNavMode", "saveNextFrame", "savePlay", "isPlay", "saveSerchType", "saveStartFrame", "saveTimeSpeed", "saveUsering", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class NavigateParam extends BaseParam {
    private final int DEFAULT_FRAMEMODE;
    private final int DEFAULT_SEARCHTYPE;
    private final int DEFAULT_TIMESPEED;
    private int currentPage;
    private MessageAttr endFrameAttr;
    private MessageAttr frameAttr;
    private long frameDisplayFrame;
    private int frameMode;
    private int frameSpeed;
    private long frameStartFrame;
    private boolean ifPlaying;
    private int maxPage;
    private boolean navEnable;
    private int readNavMode;
    private int readRunStop;
    private int selectMode;
    private int serchType;
    private int timeSpeed;

    public NavigateParam() {
        super(58);
        this.DEFAULT_TIMESPEED = 2;
        this.frameAttr = new MessageAttr();
        this.endFrameAttr = new MessageAttr();
        this.timeSpeed = this.DEFAULT_TIMESPEED;
        this.serchType = this.DEFAULT_SEARCHTYPE;
        this.frameMode = this.DEFAULT_FRAMEMODE;
    }

    public final MessageAttr getFrameAttr() {
        return this.frameAttr;
    }

    public final void setFrameAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.frameAttr = messageAttr;
    }

    @Bindable
    public final MessageAttr getEndFrameAttr() {
        return this.endFrameAttr;
    }

    public final void setEndFrameAttr(MessageAttr value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.endFrameAttr = value;
        notifyPropertyChanged(274);
    }

    public final MessageAttr getFramesAttr() {
        return this.frameAttr;
    }

    @Bindable
    public final boolean getNavEnable() {
        return this.navEnable;
    }

    public final void setNavEnable(boolean z) {
        this.navEnable = z;
        notifyPropertyChanged(556);
    }

    @Bindable
    public final boolean getIfPlaying() {
        return this.ifPlaying;
    }

    public final void setIfPlaying(boolean z) {
        this.ifPlaying = z;
        notifyPropertyChanged(412);
    }

    @Bindable
    public final int getTimeSpeed() {
        return this.timeSpeed;
    }

    public final void setTimeSpeed(int i) {
        this.timeSpeed = i;
        notifyPropertyChanged(937);
    }

    @Bindable
    public final int getSerchType() {
        return this.serchType;
    }

    public final void setSerchType(int i) {
        this.serchType = i;
        notifyPropertyChanged(807);
    }

    @Bindable
    public final int getFrameSpeed() {
        return this.frameSpeed;
    }

    public final void setFrameSpeed(int i) {
        this.frameSpeed = i;
        notifyPropertyChanged(349);
    }

    @Bindable
    public final int getFrameMode() {
        return this.frameMode;
    }

    public final void setFrameMode(int i) {
        this.frameMode = i;
        notifyPropertyChanged(348);
    }

    @Bindable
    public final long getFrameStartFrame() {
        return this.frameStartFrame;
    }

    public final void setFrameStartFrame(long j) {
        this.frameStartFrame = j;
        notifyPropertyChanged(350);
    }

    @Bindable
    public final long getFrameDisplayFrame() {
        return this.frameDisplayFrame;
    }

    public final void setFrameDisplayFrame(long j) {
        this.frameDisplayFrame = j;
        notifyPropertyChanged(347);
    }

    @Bindable
    public final int getCurrentPage() {
        return this.currentPage;
    }

    public final void setCurrentPage(int i) {
        this.currentPage = i;
        notifyPropertyChanged(197);
    }

    @Bindable
    public final int getMaxPage() {
        return this.maxPage;
    }

    public final void setMaxPage(int i) {
        this.maxPage = i;
        notifyPropertyChanged(524);
    }

    @Bindable
    public final int getReadRunStop() {
        return this.readRunStop;
    }

    public final void setReadRunStop(int i) {
        this.readRunStop = i;
        notifyPropertyChanged(688);
    }

    @Bindable
    public final int getReadNavMode() {
        return this.readNavMode;
    }

    public final void setReadNavMode(int i) {
        this.readNavMode = i;
        notifyPropertyChanged(687);
    }

    @Bindable
    public final int getSelectMode() {
        return this.selectMode;
    }

    public final void setSelectMode(int i) {
        this.selectMode = i;
        notifyPropertyChanged(791);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readTimeSpeed();
        readSerchType();
        readFrameSpeed();
        readDisPlayMode();
        readStartFrame();
        readDisplayFrame();
        readStartFrameAttr();
        readEndFrameAttr();
        readPage();
        readMaxPage();
    }

    public final boolean readNavEnable() {
        setNavEnable(readBool(MessageID.MSG_NAVIGATE_ENABLE));
        return this.navEnable;
    }

    public final void saveNavEnable(boolean z) {
        saveInt(MessageID.MSG_NAVIGATE_ENABLE, z);
    }

    public final void readTimeSpeed() {
        setTimeSpeed(readInt(MessageID.MSG_NAVIGATE_TIMEOFFSET_SPEED));
    }

    public final void saveTimeSpeed(int i) {
        setTimeSpeed(i);
        notifyPropertyChanged(937);
        saveInt(MessageID.MSG_NAVIGATE_TIMEOFFSET_SPEED, i);
    }

    public final void saveStartFrame(int i, int i2) {
        saveInt(i, i2);
    }

    public final void saveEndFrame(int i, int i2) {
        saveInt(i, i2);
    }

    public final void saveBackFrame(int i, int i2) {
        saveInt(i, i2);
    }

    public final void saveNextFrame(int i, int i2) {
        saveInt(i, i2);
    }

    public final void savePlay(int i, boolean z) {
        saveBool(i, z);
    }

    public final boolean readFramePlay() {
        return readBool(MessageID.MSG_NAVIGATE_FRAMEDRAW_PLAYING);
    }

    public final boolean readTimePlay() {
        return readBool(MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING);
    }

    public final boolean readHorRun() {
        setReadRunStop(API.getInstance().UI_QueryInt32By(10, MessageID.MSG_HOR_RUN, 0));
        int i = this.readRunStop;
        if (1 == i) {
            setNavEnable(true);
        } else if (2 == i) {
            setNavEnable(false);
        }
        return this.navEnable;
    }

    public final int readNavMode() {
        setReadNavMode(readInt(MessageID.MSG_NAVIGATE_MODE));
        return this.readNavMode;
    }

    public final void saveNavMode(int i) {
        setSelectMode(i);
        saveInt(MessageID.MSG_NAVIGATE_MODE, i);
    }

    public final void readSerchType() {
        setSerchType(API.getInstance().UI_QueryInt32(25, MessageID.MSG_SEARCH_TYPE));
    }

    public final void saveSerchType(int i) {
        setSerchType(i);
        notifyPropertyChanged(807);
        API.getInstance().UI_PostInt32(25, MessageID.MSG_SEARCH_TYPE, i);
    }

    public final void readFrameSpeed() {
        setFrameSpeed(readInt(MessageID.MSG_NAVIGATE_FRAMEDRAW_SPEED));
    }

    public final void saveFrameSpeed(int i) {
        setFrameSpeed(i);
        notifyPropertyChanged(349);
        saveInt(MessageID.MSG_NAVIGATE_FRAMEDRAW_SPEED, i);
    }

    public final void readDisPlayMode() {
        setFrameMode(readInt(MessageID.MSG_NAVIGATE_FRAMEDRAW_DISPLAYMODE));
    }

    public final void saveDisPlayMode(int i) {
        setFrameMode(i);
        notifyPropertyChanged(348);
        saveUsering();
        saveInt(MessageID.MSG_NAVIGATE_FRAMEDRAW_DISPLAYMODE, i);
    }

    public final long readStartFrame() {
        setFrameStartFrame(readLong(MessageID.MSG_NAVIGATE_FRAMEDRAW_STARTFRAME));
        return this.frameStartFrame;
    }

    public final void saveStartFrame(long j) {
        setFrameStartFrame(j);
        notifyPropertyChanged(350);
        saveLong(MessageID.MSG_NAVIGATE_FRAMEDRAW_STARTFRAME, j);
    }

    public final void saveUsering() {
        saveBool(MessageID.MSG_NAVIGATE_FRAMEDRAW_USERING, true);
    }

    public final int readPage() {
        setCurrentPage(readInt(MessageID.MSG_NAVIGATE_FRAMEDRAW_DISPLAYPAGE));
        return this.currentPage;
    }

    public final int readMaxPage() {
        setMaxPage(readInt(MessageID.MSG_NAVIGATE_FRAMEDRAW_TOTALPAGE));
        return this.maxPage;
    }

    public final long readDisplayFrame() {
        setFrameDisplayFrame(readLong(MessageID.MSG_NAVIGATE_FRAMEDRAW_ENDFRAME));
        return this.frameDisplayFrame;
    }

    public final void saveDisplayFrame(long j) {
        setFrameDisplayFrame(j);
        notifyPropertyChanged(347);
        saveLong(MessageID.MSG_NAVIGATE_FRAMEDRAW_ENDFRAME, j);
    }

    public final boolean readIsOutFrame() {
        return readBool(MessageID.MSG_NAVIGATE_FRAMEDRAW_TIPS);
    }

    public final void saveIsOutFrame() {
        saveBool(MessageID.MSG_NAVIGATE_FRAMEDRAW_TIPS, false);
    }

    public final void readStartFrameAttr() {
        readAttr(MessageID.MSG_NAVIGATE_FRAMEDRAW_STARTFRAME, this.frameAttr);
    }

    public final void readEndFrameAttr() {
        readAttr(MessageID.MSG_NAVIGATE_FRAMEDRAW_ENDFRAME, this.endFrameAttr);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setTimeSpeed(this.DEFAULT_TIMESPEED);
        setSerchType(this.DEFAULT_SEARCHTYPE);
        setFrameMode(this.DEFAULT_FRAMEMODE);
        setFrameStartFrame(this.frameAttr.getDefLongValue());
        setFrameDisplayFrame(this.endFrameAttr.getDefLongValue());
        setIfPlaying(false);
    }
}
