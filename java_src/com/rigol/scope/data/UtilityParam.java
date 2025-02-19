package com.rigol.scope.data;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import androidx.databinding.Bindable;
import com.blankj.utilcode.constant.CacheConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.BaseApplicationContext;
import com.rigol.scope.BuildConfig;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.LanguageUtil;
import com.sun.mail.imap.IMAPStore;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UtilityParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b'\n\u0002\u0010\t\n\u0002\b\u0019\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001J\u0011\u0010\u0084\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0013J\n\u0010\u0086\u0001\u001a\u00030\u0083\u0001H\u0016J\u0007\u0010\u0087\u0001\u001a\u00020\u0004J\u0007\u0010\u0088\u0001\u001a\u00020\u0004J\u0007\u0010\u0089\u0001\u001a\u00020\rJ\u0007\u0010\u008a\u0001\u001a\u00020\u0013J\u0007\u0010\u008b\u0001\u001a\u00020\u0013J\u0007\u0010\u008c\u0001\u001a\u00020\rJ\u0007\u0010\u008d\u0001\u001a\u00020\u0004J\u0007\u0010\u008e\u0001\u001a\u00020+J\u0007\u0010\u008f\u0001\u001a\u00020\u0013J\u0007\u0010\u0090\u0001\u001a\u00020\u0004J\u0007\u0010\u0091\u0001\u001a\u00020\u0004J\u0007\u0010\u0092\u0001\u001a\u00020\u0004J\u0007\u0010\u0093\u0001\u001a\u00020\rJ\u0007\u0010\u0094\u0001\u001a\u00020@J\u0007\u0010\u0095\u0001\u001a\u00020\u0004J\u0007\u0010\u0096\u0001\u001a\u00020IJ\u0007\u0010\u0097\u0001\u001a\u00020\rJ\u0007\u0010\u0098\u0001\u001a\u00020\rJ\u0007\u0010\u0099\u0001\u001a\u00020\u0013J\u0007\u0010\u009a\u0001\u001a\u00020\rJ\u0007\u0010\u009b\u0001\u001a\u00020\u0013J\u0007\u0010\u009c\u0001\u001a\u00020\u0013J\u0007\u0010\u009d\u0001\u001a\u00020\u0013J\u0007\u0010\u009e\u0001\u001a\u00020\rJ\u0007\u0010\u009f\u0001\u001a\u00020\u0004J\u0007\u0010 \u0001\u001a\u00020\u0013J\u0007\u0010¡\u0001\u001a\u00020pJ\u0007\u0010¢\u0001\u001a\u00020\u0013J\u0007\u0010£\u0001\u001a\u00020\u0004J\u0007\u0010¤\u0001\u001a\u00020\u0004J\u0007\u0010¥\u0001\u001a\u00020\u0004J\n\u0010¦\u0001\u001a\u00030\u0083\u0001H\u0016J\b\u0010§\u0001\u001a\u00030\u0083\u0001J\u0010\u0010¨\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010©\u0001\u001a\u00030\u0083\u00012\u0006\u0010\n\u001a\u00020\u0004J\u0011\u0010ª\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0014\u001a\u00030«\u0001J\u001c\u0010¬\u0001\u001a\u00030\u0083\u00012\b\u0010\u00ad\u0001\u001a\u00030«\u00012\b\u0010®\u0001\u001a\u00030«\u0001J\u0010\u0010¯\u0001\u001a\u00030\u0083\u00012\u0006\u0010%\u001a\u00020\rJ\u0010\u0010°\u0001\u001a\u00030\u0083\u00012\u0006\u0010(\u001a\u00020\u0004J\u0010\u0010±\u0001\u001a\u00030\u0083\u00012\u0006\u0010,\u001a\u00020+J\u0010\u0010²\u0001\u001a\u00030\u0083\u00012\u0006\u00107\u001a\u00020\u0004J\u0010\u0010³\u0001\u001a\u00030\u0083\u00012\u0006\u0010:\u001a\u00020\u0004J\u0010\u0010´\u0001\u001a\u00030\u0083\u00012\u0006\u0010=\u001a\u00020\u0004J\u0010\u0010µ\u0001\u001a\u00030\u0083\u00012\u0006\u0010A\u001a\u00020@J\u0010\u0010¶\u0001\u001a\u00030\u0083\u00012\u0006\u0010F\u001a\u00020\u0004J\u0010\u0010·\u0001\u001a\u00030\u0083\u00012\u0006\u0010J\u001a\u00020IJ\u0010\u0010¸\u0001\u001a\u00030\u0083\u00012\u0006\u0010O\u001a\u00020\rJ\u0010\u0010¹\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u0019\u001a\u00020\rJ\u0010\u0010º\u0001\u001a\u00030\u0083\u00012\u0006\u0010R\u001a\u00020\u0013J\u0010\u0010»\u0001\u001a\u00030\u0083\u00012\u0006\u0010U\u001a\u00020\rJ\u0010\u0010¼\u0001\u001a\u00030\u0083\u00012\u0006\u0010X\u001a\u00020\u0013J\u0010\u0010½\u0001\u001a\u00030\u0083\u00012\u0006\u0010^\u001a\u00020\u0013J\u0010\u0010¾\u0001\u001a\u00030\u0083\u00012\u0006\u0010g\u001a\u00020\u0004J\u0010\u0010¿\u0001\u001a\u00030\u0083\u00012\u0006\u0010q\u001a\u00020pJ\u0011\u0010À\u0001\u001a\u00030\u0083\u00012\u0007\u0010v\u001a\u00030«\u0001J\u0010\u0010Á\u0001\u001a\u00030\u0083\u00012\u0006\u0010y\u001a\u00020\u0004J\u0010\u0010Â\u0001\u001a\u00030\u0083\u00012\u0006\u0010|\u001a\u00020\u0004J\u0010\u0010Ã\u0001\u001a\u00030\u0083\u00012\u0006\u0010\u007f\u001a\u00020\u0004R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R&\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0010\"\u0004\b\u001b\u0010\u0012R&\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R&\u0010 \u001a\u00020\u001f2\u0006\u0010\u0003\u001a\u00020\u001f8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010%\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0010\"\u0004\b'\u0010\u0012R&\u0010(\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR&\u0010,\u001a\u00020+2\u0006\u0010\u0003\u001a\u00020+8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00101\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R&\u00104\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R&\u00107\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0007\"\u0004\b9\u0010\tR&\u0010:\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\u0007\"\u0004\b<\u0010\tR&\u0010=\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0007\"\u0004\b?\u0010\tR&\u0010A\u001a\u00020@2\u0006\u0010\u0003\u001a\u00020@8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001a\u0010F\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u0007\"\u0004\bH\u0010\tR&\u0010J\u001a\u00020I2\u0006\u0010\u0003\u001a\u00020I8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR&\u0010O\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0010\"\u0004\bQ\u0010\u0012R&\u0010R\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0016\"\u0004\bT\u0010\u0018R&\u0010U\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\u0010\"\u0004\bW\u0010\u0012R&\u0010X\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\u0016\"\u0004\bZ\u0010\u0018R&\u0010[\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0016\"\u0004\b]\u0010\u0018R&\u0010^\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0016\"\u0004\b`\u0010\u0018R&\u0010a\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0016\"\u0004\bc\u0010\u0018R\u001a\u0010d\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010\u0010\"\u0004\bf\u0010\u0012R&\u0010g\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR&\u0010j\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0007\"\u0004\bl\u0010\tR&\u0010m\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0016\"\u0004\bo\u0010\u0018R&\u0010q\u001a\u00020p2\u0006\u0010\u0003\u001a\u00020p8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR&\u0010v\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u00138G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010\u0016\"\u0004\bx\u0010\u0018R&\u0010y\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\u0007\"\u0004\b{\u0010\tR&\u0010|\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0007\"\u0004\b~\u0010\tR(\u0010\u007f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\u0007\"\u0005\b\u0081\u0001\u0010\t¨\u0006Ä\u0001"}, d2 = {"Lcom/rigol/scope/data/UtilityParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "auxOut", "getAuxOut", "()Z", "setAuxOut", "(Z)V", "beeper", "getBeeper", "setBeeper", "", "chNum", "getChNum", "()I", "setChNum", "(I)V", "", IMAPStore.ID_DATE, "getDate", "()Ljava/lang/String;", "setDate", "(Ljava/lang/String;)V", "displayBrightness", "getDisplayBrightness", "setDisplayBrightness", "hardVersion", "getHardVersion", "setHardVersion", "Lcom/rigol/scope/cil/ServiceEnum$HDMI_Ratio;", "hdmiRatio", "getHdmiRatio", "()Lcom/rigol/scope/cil/ServiceEnum$HDMI_Ratio;", "setHdmiRatio", "(Lcom/rigol/scope/cil/ServiceEnum$HDMI_Ratio;)V", "language", "getLanguage", "setLanguage", "lockKeyboard", "getLockKeyboard", "setLockKeyboard", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "measSrc", "getMeasSrc", "()Lcom/rigol/scope/cil/ServiceEnum$Chan;", "setMeasSrc", "(Lcom/rigol/scope/cil/ServiceEnum$Chan;)V", "miscBuild", "getMiscBuild", "setMiscBuild", "model", "getModel", "setModel", "powerOnSet", "getPowerOnSet", "setPowerOnSet", "powerStatus", "getPowerStatus", "setPowerStatus", "projectMode", "getProjectMode", "setProjectMode", "Lcom/rigol/scope/cil/ServiceEnum$UtilityQuickOperationType;", "quickOper", "getQuickOper", "()Lcom/rigol/scope/cil/ServiceEnum$UtilityQuickOperationType;", "setQuickOper", "(Lcom/rigol/scope/cil/ServiceEnum$UtilityQuickOperationType;)V", "readInputKeyboard", "getReadInputKeyboard", "setReadInputKeyboard", "Lcom/rigol/scope/cil/ServiceEnum$RefClock;", "refClock", "getRefClock", "()Lcom/rigol/scope/cil/ServiceEnum$RefClock;", "setRefClock", "(Lcom/rigol/scope/cil/ServiceEnum$RefClock;)V", "saveGroup", "getSaveGroup", "setSaveGroup", "screenPicture", "getScreenPicture", "setScreenPicture", "screenSelect", "getScreenSelect", "setScreenSelect", "screenTime", "getScreenTime", "setScreenTime", "screenTimeStr", "getScreenTimeStr", "setScreenTimeStr", "screenWord", "getScreenWord", "setScreenWord", "serial", "getSerial", "setSerial", "series", "getSeries", "setSeries", "showTime", "getShowTime", "setShowTime", "showzoom", "getShowzoom", "setShowzoom", "softVersion", "getSoftVersion", "setSoftVersion", "Lcom/rigol/scope/cil/ServiceEnum$UtilityQuickStatReset;", "statReset", "getStatReset", "()Lcom/rigol/scope/cil/ServiceEnum$UtilityQuickStatReset;", "setStatReset", "(Lcom/rigol/scope/cil/ServiceEnum$UtilityQuickStatReset;)V", "time", "getTime", "setTime", "verticalExpand", "getVerticalExpand", "setVerticalExpand", "vibration", "getVibration", "setVibration", "zbdLed", "getZbdLed", "setZbdLed", "makeVibration", "", "modifyTime", "tm", "readAll", "readAuxOut", "readBeeper", "readChNum", "readDate", "readHardVersion", "readLanguage", "readLockKeyboard", "readMeasSrc", "readModel", "readPowerOnSet", "readPowerStatus", "readProjectMode", "readQuickOpenStatus", "readQuickOper", "readReadInputKeyboard", "readRefClock", "readSaveGroup", "readScreenBrightness", "readScreenPicture", "readScreenSelect", "readScreenTime", "readScreenWord", "readSerial", "readSeries", "readShowTime", "readSoftVersion", "readStatReet", "readTime", "readVerticalExpand", "readVibration", "readZbdLed", "reset", "resetScreenSaver", "saveAuxOut", "saveBeeper", "saveDate", "", "saveDiff", "s1", "s2", "saveLanguage", "saveLockKeyboard", "saveMeasSrc", "savePowerOnSet", "savePowerStatus", "saveProjectMode", "saveQuickOper", "saveReadInputKeyboard", "saveRefClock", "saveSaveGroup", "saveScreenBrightness", "saveScreenPicture", "saveScreenSelect", "saveScreenTime", "saveScreenWord", "saveShowTime", "saveStatReset", "saveTime", "saveVerticalExpand", "saveVibration", "saveZbdLed", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class UtilityParam extends BaseParam {
    private boolean auxOut;
    private boolean beeper;
    private int chNum;
    private String date;
    private int displayBrightness;
    private String hardVersion;
    private ServiceEnum.HDMI_Ratio hdmiRatio;
    private int language;
    private boolean lockKeyboard;
    private ServiceEnum.Chan measSrc;
    private String miscBuild;
    private String model;
    private boolean powerOnSet;
    private boolean powerStatus;
    private boolean projectMode;
    private ServiceEnum.UtilityQuickOperationType quickOper;
    private boolean readInputKeyboard;
    private ServiceEnum.RefClock refClock;
    private int saveGroup;
    private String screenPicture;
    private int screenSelect;
    private String screenTime;
    private String screenTimeStr;
    private String screenWord;
    private String serial;
    private int series;
    private boolean showTime;
    private boolean showzoom;
    private String softVersion;
    private ServiceEnum.UtilityQuickStatReset statReset;
    private String time;
    private boolean verticalExpand;
    private boolean vibration;
    private boolean zbdLed;

    public UtilityParam() {
        super(11);
        this.language = ServiceEnum.SystemLanguage.language_chinese.value1;
        this.chNum = 4;
        this.screenWord = UtilityParamKt.DEFAULT_SCREEN_WORD;
        this.screenPicture = "";
        this.screenTime = UtilityParamKt.DEFAULT_SCREEN_TIME;
        this.screenTimeStr = "";
        this.screenSelect = UtilityParamKt.getDEFAULT_SCREEN_SELECT();
        this.vibration = true;
        this.time = "";
        this.date = "";
        this.model = "";
        this.serial = "";
        this.softVersion = "";
        this.hardVersion = "";
        this.miscBuild = BuildConfig.releaseTime;
        ServiceEnum.UtilityQuickOperationType utilityQuickOperationTypeFromValue1 = ServiceEnum.getUtilityQuickOperationTypeFromValue1(0);
        Intrinsics.checkNotNullExpressionValue(utilityQuickOperationTypeFromValue1, "ServiceEnum.getUtilityQu…Value1(DEFAULT_QUICKOPER)");
        this.quickOper = utilityQuickOperationTypeFromValue1;
        this.measSrc = ServiceEnum.Chan.chan1;
        this.statReset = ServiceEnum.UtilityQuickStatReset.Measure;
        this.refClock = ServiceEnum.RefClock.REF_10MHz_OFF;
        this.hdmiRatio = ServiceEnum.HDMI_Ratio.HDMI_1920x1080;
        this.series = ServiceEnum.ProductSeries.SERIES_1000.value1;
    }

    @Bindable
    public final int getLanguage() {
        return this.language;
    }

    public final void setLanguage(int i) {
        log("language", Integer.valueOf(this.language), Integer.valueOf(i));
        this.language = i;
        notifyPropertyChanged(478);
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            LanguageUtil.setLanguage(this.language);
        } else {
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.data.UtilityParam$language$1
                @Override // java.lang.Runnable
                public final void run() {
                    LanguageUtil.setLanguage(UtilityParam.this.getLanguage());
                }
            });
        }
    }

    @Bindable
    public final int getChNum() {
        return this.chNum;
    }

    public final void setChNum(int i) {
        log("chNum", Integer.valueOf(this.chNum), Integer.valueOf(i));
        this.chNum = i;
    }

    @Bindable
    public final boolean getProjectMode() {
        return this.projectMode;
    }

    public final void setProjectMode(boolean z) {
        log("projectMode", Boolean.valueOf(this.projectMode), Boolean.valueOf(z));
        this.projectMode = z;
        notifyPropertyChanged(677);
        syncData(MessageID.MSG_APP_UTILITY_PROJECT, Boolean.valueOf(this.projectMode));
    }

    @Bindable
    public final String getScreenWord() {
        return this.screenWord;
    }

    public final void setScreenWord(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("screenWord", this.screenWord, value);
        this.screenWord = value;
        notifyPropertyChanged(784);
        syncData(MessageID.MSG_APP_UTILITY_SCREEN_WORD, this.screenWord);
    }

    @Bindable
    public final String getScreenPicture() {
        return this.screenPicture;
    }

    public final void setScreenPicture(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("screenPicture", this.screenPicture, value);
        this.screenPicture = value;
        notifyPropertyChanged(780);
    }

    @Bindable
    public final String getScreenTime() {
        return this.screenTime;
    }

    public final void setScreenTime(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("screenTime", this.screenTime, value);
        String str = value;
        if (TextUtils.isEmpty(str) || StringsKt.startsWith$default((CharSequence) str, '-', false, 2, (Object) null) || Intrinsics.areEqual(value, "OFF")) {
            value = UtilityParamKt.DEFAULT_SCREEN_TIME;
        }
        this.screenTime = value;
        setScreenTimeStr(this.screenTime + " minute");
        notifyPropertyChanged(782);
    }

    @Bindable
    public final String getScreenTimeStr() {
        return this.screenTimeStr;
    }

    public final void setScreenTimeStr(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("screenTimeStr", this.screenTimeStr, value);
        this.screenTimeStr = value;
        notifyPropertyChanged(783);
    }

    @Bindable
    public final int getScreenSelect() {
        return this.screenSelect;
    }

    public final void setScreenSelect(int i) {
        log("screenSelect", Integer.valueOf(this.screenSelect), Integer.valueOf(i));
        this.screenSelect = i;
        notifyPropertyChanged(781);
    }

// Inform: получение яркости дисплея
    @Bindable
    public final int getDisplayBrightness() {
        return this.displayBrightness;
    }

// Inform: установка яркости дисплея
    public final void setDisplayBrightness(int i) {
        log("zbdLed", Integer.valueOf(this.displayBrightness), Integer.valueOf(i));
        this.displayBrightness = i;
        notifyPropertyChanged(243);
    }

    @Bindable
    public final boolean getBeeper() {
        return this.beeper;
    }

    public final void setBeeper(boolean z) {
        log("beeper", Boolean.valueOf(this.beeper), Boolean.valueOf(z));
        this.beeper = z;
        notifyPropertyChanged(88);
    }

    @Bindable
    public final boolean getVibration() {
        return this.vibration;
    }

    public final void setVibration(boolean z) {
        log("vibration", Boolean.valueOf(this.vibration), Boolean.valueOf(z));
        this.vibration = z;
        notifyPropertyChanged(1028);
    }

    @Bindable
    public final boolean getPowerStatus() {
        return this.powerStatus;
    }

    public final void setPowerStatus(boolean z) {
        log("powerStatus", Boolean.valueOf(this.powerStatus), Boolean.valueOf(z));
        this.powerStatus = z;
        notifyPropertyChanged(652);
    }

    @Bindable
    public final boolean getAuxOut() {
        return this.auxOut;
    }

    public final void setAuxOut(boolean z) {
        log("auxOut", Boolean.valueOf(this.auxOut), Boolean.valueOf(z));
        this.auxOut = z;
        notifyPropertyChanged(63);
    }

    @Bindable
    public final boolean getPowerOnSet() {
        return this.powerOnSet;
    }

    public final void setPowerOnSet(boolean z) {
        log("powerOnSet", Boolean.valueOf(this.powerOnSet), Boolean.valueOf(z));
        this.powerOnSet = z;
        notifyPropertyChanged(651);
    }

    @Bindable
    public final boolean getShowTime() {
        return this.showTime;
    }

    public final void setShowTime(boolean z) {
        log("showTime", Boolean.valueOf(this.showTime), Boolean.valueOf(z));
        this.showTime = z;
        notifyPropertyChanged(841);
    }

    @Bindable
    public final boolean getShowzoom() {
        return this.showzoom;
    }

    public final void setShowzoom(boolean z) {
        log("showTime", Boolean.valueOf(this.showzoom), Boolean.valueOf(z));
        this.showzoom = z;
        notifyPropertyChanged(845);
    }

    @Bindable
    public final String getTime() {
        return this.time;
    }

    public final void setTime(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("time", this.time, value);
        this.time = value;
        notifyPropertyChanged(934);
    }

    @Bindable
    public final String getDate() {
        return this.date;
    }

    public final void setDate(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log(IMAPStore.ID_DATE, this.date, value);
        this.date = value;
        notifyPropertyChanged(222);
    }

    @Bindable
    public final boolean getVerticalExpand() {
        return this.verticalExpand;
    }

    public final void setVerticalExpand(boolean z) {
        log("verticalExpand", Boolean.valueOf(this.verticalExpand), Boolean.valueOf(z));
        this.verticalExpand = z;
        notifyPropertyChanged(1025);
    }

    @Bindable
    public final boolean getLockKeyboard() {
        return this.lockKeyboard;
    }

    public final void setLockKeyboard(boolean z) {
        log("lockKeyboard", Boolean.valueOf(this.lockKeyboard), Boolean.valueOf(z));
        this.lockKeyboard = z;
        notifyPropertyChanged(506);
    }

    @Bindable
    public final String getModel() {
        return this.model;
    }

    public final void setModel(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("model", this.model, value);
        this.model = value;
        notifyPropertyChanged(550);
    }

    @Bindable
    public final String getSerial() {
        return this.serial;
    }

    public final void setSerial(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("serial", this.serial, value);
        this.serial = value;
        notifyPropertyChanged(808);
    }

    @Bindable
    public final String getSoftVersion() {
        return this.softVersion;
    }

    public final void setSoftVersion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("softVersion", this.softVersion, value);
        this.softVersion = value;
        notifyPropertyChanged(857);
    }

    @Bindable
    public final String getHardVersion() {
        return this.hardVersion;
    }

    public final void setHardVersion(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("hardVersion", this.hardVersion, value);
        this.hardVersion = value;
        notifyPropertyChanged(366);
    }

    @Bindable
    public final String getMiscBuild() {
        return this.miscBuild;
    }

    public final void setMiscBuild(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("miscBuild", this.miscBuild, value);
        this.miscBuild = value;
        notifyPropertyChanged(543);
    }

    @Bindable
    public final ServiceEnum.UtilityQuickOperationType getQuickOper() {
        return this.quickOper;
    }

    public final void setQuickOper(ServiceEnum.UtilityQuickOperationType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("quickOper", this.quickOper, value);
        this.quickOper = value;
        notifyPropertyChanged(684);
        MessageBus.getInstance().onSyncData(MessageBus.getKey(27, MessageID.MSG_QUICK_OPERATION), this.quickOper);
    }

    @Bindable
    public final ServiceEnum.Chan getMeasSrc() {
        return this.measSrc;
    }

    public final void setMeasSrc(ServiceEnum.Chan value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("measSrc", this.measSrc, value);
        this.measSrc = value;
        notifyPropertyChanged(527);
    }

    @Bindable
    public final ServiceEnum.UtilityQuickStatReset getStatReset() {
        return this.statReset;
    }

    public final void setStatReset(ServiceEnum.UtilityQuickStatReset value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("statReset", this.statReset, value);
        this.statReset = value;
        notifyPropertyChanged(905);
    }

    @Bindable
    public final int getSaveGroup() {
        return this.saveGroup;
    }

    public final void setSaveGroup(int i) {
        log("saveGroup", Integer.valueOf(this.saveGroup), Integer.valueOf(i));
        this.saveGroup = i;
        notifyPropertyChanged(773);
    }

    @Bindable
    public final ServiceEnum.RefClock getRefClock() {
        return this.refClock;
    }

    public final void setRefClock(ServiceEnum.RefClock value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("refClock", this.refClock, value);
        this.refClock = value;
        notifyPropertyChanged(715);
    }

    @Bindable
    public final ServiceEnum.HDMI_Ratio getHdmiRatio() {
        return this.hdmiRatio;
    }

    public final void setHdmiRatio(ServiceEnum.HDMI_Ratio value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("hdmiRatio", this.hdmiRatio, value);
        this.hdmiRatio = value;
        notifyPropertyChanged(368);
    }

    @Bindable
    public final boolean getZbdLed() {
        return this.zbdLed;
    }

    public final void setZbdLed(boolean z) {
        log("zbdLed", Boolean.valueOf(this.zbdLed), Boolean.valueOf(z));
        this.zbdLed = z;
        notifyPropertyChanged(1087);
    }

    public final int getSeries() {
        return this.series;
    }

    public final void setSeries(int i) {
        this.series = i;
    }

    public final boolean getReadInputKeyboard() {
        return this.readInputKeyboard;
    }

    public final void setReadInputKeyboard(boolean z) {
        this.readInputKeyboard = z;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readLanguage();
        readProjectMode();
        readBeeper();
        readVibration();
        readPowerStatus();
        readAuxOut();
        readPowerOnSet();
        readTime();
        readDate();
        readVerticalExpand();
        readLockKeyboard();
        readModel();
        readSerial();
        readSoftVersion();
        readHardVersion();
        readQuickOper();
        readMeasSrc();
        readStatReet();
        readSaveGroup();
        readRefClock();
        readZbdLed();
        readScreenWord();
        readScreenPicture();
        readScreenTime();
        readScreenSelect();
        readSeries();
        readChNum();
        readScreenBrightness();
        readQuickOpenStatus();
    }

    public final void saveReadInputKeyboard(boolean z) {
        this.readInputKeyboard = z;
    }

    public final boolean readReadInputKeyboard() {
        return this.readInputKeyboard;
    }

    public final int readSeries() {
        int readInt = readInt(MessageID.MSG_PRODUCT_SERIES);
        this.series = readInt;
        return readInt;
    }

    public final int readChNum() {
        setChNum(readInt(MessageID.MSG_APP_UTILITY_CHANNEL_COUNT));
        return this.chNum;
    }

    public final int readLanguage() {
        setLanguage(readInt(MessageID.MSG_APP_UTILITY_LANGUAGE));
        return this.language;
    }

    public final boolean readProjectMode() {
        setProjectMode(readBool(MessageID.MSG_APP_UTILITY_PROJECT));
        return this.projectMode;
    }

    public final boolean readBeeper() {
        setBeeper(readBool(MessageID.MSG_APP_UTILITY_BEEPER));
        return this.beeper;
    }

    public final boolean readVibration() {
        setVibration(readBool(MessageID.MSG_APP_UTILITY_TOUCH_VIBRATION_EN));
        return this.vibration;
    }

    public final boolean readPowerStatus() {
        setPowerStatus(readBool(MessageID.MSG_APP_UTILITY_POWER_STATUS));
        return this.powerStatus;
    }

    public final boolean readAuxOut() {
        setAuxOut(readInt(MessageID.MSG_APP_UTILITY_AUXOUT) == 1);
        return this.auxOut;
    }

    public final boolean readPowerOnSet() {
        setPowerOnSet(readBool(MessageID.MSG_APP_UTILITY_POWER_ON_SET));
        return this.powerOnSet;
    }

    public final boolean readShowTime() {
        setShowTime(readBool(MessageID.MSG_APP_UTILITY_SHOW_TIME));
        return this.showTime;
    }

    public final String readTime() {
        setTime(UtilityParamKt.millis2Time(System.currentTimeMillis() + (ServiceEnum.TimeZoneDiff.ZONE_DIFF.value1 * CacheConstants.HOUR * 1000)));
        return this.time;
    }

    public final String readDate() {
        setDate(UtilityParamKt.millis2Date(System.currentTimeMillis() + (ServiceEnum.TimeZoneDiff.ZONE_DIFF.value1 * CacheConstants.HOUR * 1000)));
        return this.date;
    }

    public final boolean readVerticalExpand() {
        setVerticalExpand(API.getInstance().UI_QueryBool(1, MessageID.MSG_CHAN_VER_EXPAND));
        return this.verticalExpand;
    }

    public final boolean readLockKeyboard() {
        setLockKeyboard(readBool(MessageID.MSG_APP_UTILITY_LOCK_KB));
        return this.lockKeyboard;
    }

    public final String readModel() {
        setModel(readStr(MessageID.MSG_MISC_MODEL));
        return this.model;
    }

    public final String readSerial() {
        setSerial(readStr(MessageID.MSG_MISC_SERIAL));
        return this.serial;
    }

    public final String readSoftVersion() {
        setSoftVersion(readStr(MessageID.MSG_MISC_SOFT_VER));
        return this.softVersion;
    }

    public final String readHardVersion() {
        setHardVersion(readStr(MessageID.MSG_MISC_HARD_VER));
        return this.hardVersion;
    }

    public final ServiceEnum.UtilityQuickOperationType readQuickOper() {
        ServiceEnum.UtilityQuickOperationType utilityQuickOperationTypeFromValue1 = ServiceEnum.getUtilityQuickOperationTypeFromValue1(API.getInstance().UI_QueryInt32(27, MessageID.MSG_QUICK_OPERATION));
        Intrinsics.checkNotNullExpressionValue(utilityQuickOperationTypeFromValue1, "ServiceEnum.getUtilityQu…tionTypeFromValue1(value)");
        setQuickOper(utilityQuickOperationTypeFromValue1);
        return this.quickOper;
    }

    public final int readQuickOpenStatus() {
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_QUICK_POWER);
        LogUtils.e("wxz readQuickOpenStatus", Integer.valueOf(UI_QueryInt32));
        if (UI_QueryInt32 == 1) {
            Intent intent = new Intent();
            intent.setAction("com.rigol.watchdog.QuickOpenStatus");
            intent.putExtra("quickOpenStatus", "1");
            Context context = BaseApplicationContext.getContext();
            if (context != null) {
                context.sendBroadcast(intent);
            }
        }
        return UI_QueryInt32;
    }

    public final ServiceEnum.Chan readMeasSrc() {
        ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(API.getInstance().UI_QueryInt32(27, MessageID.MSG_QUICK_MEAS_ALL_SRC));
        Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromValue1(value)");
        setMeasSrc(chanFromValue1);
        return this.measSrc;
    }

    public final ServiceEnum.UtilityQuickStatReset readStatReet() {
        ServiceEnum.UtilityQuickStatReset utilityQuickStatResetFromValue1 = ServiceEnum.getUtilityQuickStatResetFromValue1(API.getInstance().UI_QueryInt32(27, MessageID.MSG_QUICK_STAT_RESET));
        Intrinsics.checkNotNullExpressionValue(utilityQuickStatResetFromValue1, "ServiceEnum.getUtilityQu…tatResetFromValue1(value)");
        setStatReset(utilityQuickStatResetFromValue1);
        return this.statReset;
    }

    public final int readSaveGroup() {
        setSaveGroup(API.getInstance().UI_QueryInt32(27, MessageID.MSG_QUICK_SELECT_SAVE));
        return this.saveGroup;
    }

    public final ServiceEnum.RefClock readRefClock() {
        ServiceEnum.RefClock refClockFromValue1 = ServiceEnum.getRefClockFromValue1(readInt(MessageID.MSG_APP_UTILITY_REF_CLOCK));
        Intrinsics.checkNotNullExpressionValue(refClockFromValue1, "ServiceEnum.getRefClockFromValue1(value)");
        setRefClock(refClockFromValue1);
        return this.refClock;
    }

    public final boolean readZbdLed() {
        setZbdLed(readBool(MessageID.MSG_APP_UTILITY_ZBD_LED));
        return this.zbdLed;
    }

    public final String readScreenWord() {
        setScreenWord(readStr(MessageID.MSG_APP_UTILITY_SCREEN_WORD));
        return this.screenWord;
    }

    public final String readScreenPicture() {
        setScreenPicture(readStr(MessageID.MSG_APP_UTILITY_SCREEN_PICTURE));
        return this.screenPicture;
    }

    public final String readScreenTime() {
        setScreenTime(readStr(MessageID.MSG_APP_UTILITY_SCREEN_TIME));
        return this.screenTime;
    }

    public final int readScreenSelect() {
        setScreenSelect(readInt(MessageID.MSG_APP_UTILITY_SCREEN_SELECT));
        return this.screenSelect;
    }

// Inform: чтение яркости дисплея
    public final int readScreenBrightness() {
        setDisplayBrightness(readInt(MessageID.MSG_APP_UTILITY_DISPLAY_BRIGHTNESS));
        return this.displayBrightness;
    }

// Inform: устсохранение яркости дисплея
    public final void saveScreenBrightness(int i) {
        setDisplayBrightness(i);
        saveInt(MessageID.MSG_APP_UTILITY_DISPLAY_BRIGHTNESS, i);
    }

    public final void saveLanguage(int i) {
        setLanguage(i);
        saveInt(MessageID.MSG_APP_UTILITY_LANGUAGE, i);
    }

    public final void saveProjectMode(boolean z) {
        setProjectMode(z);
        saveBool(MessageID.MSG_APP_UTILITY_PROJECT, z);
    }

    public final void saveBeeper(boolean z) {
        setBeeper(z);
        saveBool(MessageID.MSG_APP_UTILITY_BEEPER, z);
    }

    public final void saveVibration(boolean z) {
        setVibration(z);
        saveBool(MessageID.MSG_APP_UTILITY_TOUCH_VIBRATION_EN, z);
    }

    public final void saveScreenWord(String screenWord) {
        Intrinsics.checkNotNullParameter(screenWord, "screenWord");
        setScreenWord(screenWord);
        saveStr(MessageID.MSG_APP_UTILITY_SCREEN_WORD, screenWord);
    }

    public final void saveScreenPicture(String screenPicture) {
        Intrinsics.checkNotNullParameter(screenPicture, "screenPicture");
        setScreenPicture(screenPicture);
        saveStr(MessageID.MSG_APP_UTILITY_SCREEN_PICTURE, screenPicture);
    }

    public final void saveScreenTime(String screenTime) {
        Intrinsics.checkNotNullParameter(screenTime, "screenTime");
        setScreenTime(screenTime);
        saveStr(MessageID.MSG_APP_UTILITY_SCREEN_TIME, screenTime);
    }

    public final void saveScreenSelect(int i) {
        setScreenSelect(i);
        saveInt(MessageID.MSG_APP_UTILITY_SCREEN_WORD, i);
    }

    public final void makeVibration() {
        setVibration(this.vibration);
        saveInt(MessageID.MSG_APP_UTILITY_TOUCH_VIBRATION, 0);
    }

    public final void savePowerStatus(boolean z) {
        setPowerStatus(z);
        saveBool(MessageID.MSG_APP_UTILITY_POWER_STATUS, z);
    }

    public final void saveAuxOut(boolean z) {
        setAuxOut(z);
        saveInt(MessageID.MSG_APP_UTILITY_AUXOUT, z);
    }

    public final void savePowerOnSet(boolean z) {
        setPowerOnSet(z);
        saveBool(MessageID.MSG_APP_UTILITY_POWER_ON_SET, z);
    }

    public final void saveShowTime(boolean z) {
        setShowTime(z);
        saveBool(MessageID.MSG_APP_UTILITY_SHOW_TIME, z);
    }

    public final void saveTime(long j) {
        setTime(UtilityParamKt.millis2Time(j));
        UtilityParamKt.applyTime();
    }

    public final void saveDate(long j) {
        setDate(UtilityParamKt.millis2Date(j));
        UtilityParamKt.applyTime();
    }

    public final void saveLockKeyboard(boolean z) {
        setLockKeyboard(z);
        saveBool(MessageID.MSG_APP_UTILITY_LOCK_KB, z);
    }

    public final void modifyTime(String tm) {
        Intrinsics.checkNotNullParameter(tm, "tm");
        API.getInstance().UI_PostStr(11, MessageID.MSG_SCPI_UTILITY_TIME, tm);
        UtilityParamKt.applyTime();
    }

    public final void saveDiff(long j, long j2) {
        API.getInstance().UI_PostInt64(36, MessageID.MSG_LICENSE_CALENDAR, j2 - j);
    }

    public final void saveVerticalExpand(boolean z) {
        setVerticalExpand(z);
        API.getInstance().UI_PostBool(1, MessageID.MSG_CHAN_VER_EXPAND, z);
    }

    public final void saveQuickOper(ServiceEnum.UtilityQuickOperationType quickOper) {
        Intrinsics.checkNotNullParameter(quickOper, "quickOper");
        setQuickOper(quickOper);
        API.getInstance().UI_PostInt32(27, MessageID.MSG_QUICK_OPERATION, quickOper.value1);
    }

    public final void saveMeasSrc(ServiceEnum.Chan measSrc) {
        Intrinsics.checkNotNullParameter(measSrc, "measSrc");
        setMeasSrc(measSrc);
        API.getInstance().UI_PostInt32(27, MessageID.MSG_QUICK_MEAS_ALL_SRC, measSrc.value1);
    }

    public final void saveStatReset(ServiceEnum.UtilityQuickStatReset statReset) {
        Intrinsics.checkNotNullParameter(statReset, "statReset");
        setStatReset(statReset);
        API.getInstance().UI_PostInt32(27, MessageID.MSG_QUICK_STAT_RESET, statReset.value1);
    }

    public final void saveSaveGroup(int i) {
        setSaveGroup(i);
        API.getInstance().UI_PostInt32(27, MessageID.MSG_QUICK_SELECT_SAVE, i);
    }

    public final void saveRefClock(ServiceEnum.RefClock refClock) {
        Intrinsics.checkNotNullParameter(refClock, "refClock");
        setRefClock(refClock);
        saveInt(MessageID.MSG_APP_UTILITY_REF_CLOCK, refClock.value1);
    }

    public final void saveZbdLed(boolean z) {
        setZbdLed(z);
        saveBool(MessageID.MSG_APP_UTILITY_ZBD_LED, z);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setVibration(true);
        setAuxOut(false);
        setShowTime(false);
        setVerticalExpand(false);
        ServiceEnum.UtilityQuickOperationType utilityQuickOperationTypeFromValue1 = ServiceEnum.getUtilityQuickOperationTypeFromValue1(0);
        Intrinsics.checkNotNullExpressionValue(utilityQuickOperationTypeFromValue1, "ServiceEnum.getUtilityQu…Value1(DEFAULT_QUICKOPER)");
        setQuickOper(utilityQuickOperationTypeFromValue1);
        setZbdLed(false);
        setMeasSrc(ServiceEnum.Chan.chan1);
        setScreenSelect(UtilityParamKt.getDEFAULT_SCREEN_SELECT());
        setSaveGroup(7);
        setStatReset(ServiceEnum.UtilityQuickStatReset.Measure);
        resetScreenSaver();
    }

    public final void resetScreenSaver() {
        setScreenWord(UtilityParamKt.DEFAULT_SCREEN_WORD);
        setScreenPicture("");
        setScreenTime(UtilityParamKt.DEFAULT_SCREEN_TIME);
    }
}
