package com.rigol.scope.data;

import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.ViewUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: CursorResultParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0011\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010[\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020^0]0\\J\u0006\u0010_\u001a\u00020`J\u0006\u0010a\u001a\u00020`J\u0006\u0010b\u001a\u00020cJ\b\u0010d\u001a\u00020cH\u0016J\u0006\u0010e\u001a\u00020\nJ\u0006\u0010f\u001a\u00020cJ\u0006\u0010g\u001a\u00020\nJ\u0006\u0010h\u001a\u00020cJ\u0006\u0010i\u001a\u000202J\u0006\u0010j\u001a\u00020\nJ\u0006\u0010k\u001a\u00020cJ\u0006\u0010l\u001a\u00020\nJ\u0006\u0010m\u001a\u00020cJ\u0006\u0010n\u001a\u000202J\u0006\u0010o\u001a\u00020AJ\u0006\u0010p\u001a\u00020`J\u0006\u0010q\u001a\u00020`J\u0006\u0010r\u001a\u00020`J\b\u0010s\u001a\u0004\u0018\u00010RJ\u0006\u0010t\u001a\u000209J\u0006\u0010u\u001a\u00020cJ\b\u0010v\u001a\u00020cH\u0016J\u000e\u0010w\u001a\u00020c2\u0006\u0010x\u001a\u00020yJ\u000e\u0010z\u001a\u00020c2\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010{\u001a\u00020c2\u0006\u0010\u001a\u001a\u00020\nJ\u000e\u0010|\u001a\u00020c2\u0006\u0010x\u001a\u00020yJ\u000e\u0010}\u001a\u00020c2\u0006\u0010P\u001a\u000202J\u000e\u0010~\u001a\u00020c2\u0006\u0010\"\u001a\u00020\nJ\u000e\u0010\u007f\u001a\u00020c2\u0006\u0010*\u001a\u00020\nJ\u0010\u0010\u0080\u0001\u001a\u00020c2\u0007\u0010\u0081\u0001\u001a\u000202J\u0010\u0010\u0082\u0001\u001a\u00020c2\u0007\u0010\u0083\u0001\u001a\u00020AJ\u0010\u0010\u0084\u0001\u001a\u00020c2\u0007\u0010\u0085\u0001\u001a\u00020`J\u0010\u0010\u0086\u0001\u001a\u00020c2\u0007\u0010\u0085\u0001\u001a\u00020`J\u0010\u0010\u0087\u0001\u001a\u00020c2\u0007\u0010\u0088\u0001\u001a\u00020`J\u000f\u0010\u0089\u0001\u001a\u00020c2\u0006\u0010S\u001a\u00020RJ\u0010\u0010\u008a\u0001\u001a\u00020c2\u0007\u0010\u008b\u0001\u001a\u000202J\u001d\u0010\u008c\u0001\u001a\u00020c2\u000e\u0010\u008d\u0001\u001a\t\u0012\u0004\u0012\u00020\u00150\u008e\u0001¢\u0006\u0003\u0010\u008f\u0001J\u0010\u0010\u0090\u0001\u001a\u00020c2\u0007\u0010\u0081\u0001\u001a\u000202J\u0010\u0010\u0091\u0001\u001a\u00020c2\u0007\u0010\u0092\u0001\u001a\u000209J\u0011\u0010\u0093\u0001\u001a\u00020y2\u0006\u0010x\u001a\u00020yH\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R*\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u00158G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR\u0011\u0010\u001d\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R*\u0010\u001f\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010\u00158G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0017\"\u0004\b!\u0010\u0019R&\u0010\"\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\r\"\u0004\b$\u0010\u000fR\u0011\u0010%\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013R*\u0010'\u001a\u0004\u0018\u00010\u00152\b\u0010'\u001a\u0004\u0018\u00010\u00158G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u0017\"\u0004\b)\u0010\u0019R&\u0010*\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\r\"\u0004\b,\u0010\u000fR\u0011\u0010-\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0013R*\u0010/\u001a\u0004\u0018\u00010\u00152\b\u0010/\u001a\u0004\u0018\u00010\u00158G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010\u0019R&\u00103\u001a\u0002022\u0006\u0010\t\u001a\u0002028G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010>\u001a\u000209X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010;\"\u0004\b@\u0010=R&\u0010B\u001a\u00020A2\u0006\u0010\t\u001a\u00020A8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001e\u0010G\u001a\u0004\u0018\u00010\u00158GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0017\"\u0004\bI\u0010\u0019R\u001e\u0010J\u001a\u0004\u0018\u00010\u00158GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0017\"\u0004\bL\u0010\u0019R\u001e\u0010M\u001a\u0004\u0018\u00010\u00158GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0017\"\u0004\bO\u0010\u0019R&\u0010P\u001a\u0002022\u0006\u0010\t\u001a\u0002028G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u00105\"\u0004\bQ\u00107R*\u0010S\u001a\u0004\u0018\u00010R2\b\u0010\t\u001a\u0004\u0018\u00010R8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR&\u0010X\u001a\u0002092\u0006\u0010\t\u001a\u0002098G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010;\"\u0004\bZ\u0010=¨\u0006\u0094\u0001"}, d2 = {"Lcom/rigol/scope/data/CursorResultParam;", "Lcom/rigol/scope/data/ResultParam;", "()V", "aorBManager", "Lcom/rigol/scope/utilities/AorBManager;", "getAorBManager", "()Lcom/rigol/scope/utilities/AorBManager;", "setAorBManager", "(Lcom/rigol/scope/utilities/AorBManager;)V", "value", "", "ax", "getAx", "()J", "setAx", "(J)V", "axAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getAxAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "axStr", "", "getAxStr", "()Ljava/lang/String;", "setAxStr", "(Ljava/lang/String;)V", "ay", "getAy", "setAy", "ayAttr", "getAyAttr", "ayStr", "getAyStr", "setAyStr", "bx", "getBx", "setBx", "bxAttr", "getBxAttr", "bxStr", "getBxStr", "setBxStr", "by", "getBy", "setBy", "byAttr", "getByAttr", "byStr", "getByStr", "setByStr", "", "cursorEnable", "getCursorEnable", "()Z", "setCursorEnable", "(Z)V", "cursorLineAMode", "Lcom/rigol/scope/cil/ServiceEnum$CursorView;", "getCursorLineAMode", "()Lcom/rigol/scope/cil/ServiceEnum$CursorView;", "setCursorLineAMode", "(Lcom/rigol/scope/cil/ServiceEnum$CursorView;)V", "cursorLineBMode", "getCursorLineBMode", "setCursorLineBMode", "Lcom/rigol/scope/cil/ServiceEnum$CursorMode;", "cursorMode", "getCursorMode", "()Lcom/rigol/scope/cil/ServiceEnum$CursorMode;", "setCursorMode", "(Lcom/rigol/scope/cil/ServiceEnum$CursorMode;)V", "deltaXStr", "getDeltaXStr", "setDeltaXStr", "deltaYStr", "getDeltaYStr", "setDeltaYStr", "invertDeltaXStr", "getInvertDeltaXStr", "setInvertDeltaXStr", "isBothAB", "setBothAB", "Lcom/rigol/scope/cil/ServiceEnum$Unit;", "unit", "getUnit", "()Lcom/rigol/scope/cil/ServiceEnum$Unit;", "setUnit", "(Lcom/rigol/scope/cil/ServiceEnum$Unit;)V", "view", "getView", "setView", "getData", "", "Lcom/rigol/scope/data/ThreeTuple;", "", "getSourceAWidthMode", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "getSourceBWidthMode", "readAbXy", "", "readAll", "readAx", "readAxAttr", "readAy", "readAyAttr", "readBothAB", "readBx", "readBxAttr", "readBy", "readByAttr", "readCursorEnable", "readMode", "readSourceA", "readSourceB", "readSyncArea", "readUnit", "readXorY", "remove", "reset", "saveAPosition", "repeat", "", "saveAx", "saveAy", "saveBPosition", "saveBothAB", "saveBx", "saveBy", "saveCursorEnable", "enable", "saveMode", "mode", "saveSourceA", "source", "saveSourceB", "saveSyncArea", "area", "saveUnit", "saveXorY", "xOrY", "setData", "data", "", "([Ljava/lang/String;)V", "setEnable", "setViewCursorView", "cursorView", "superRepeat", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class CursorResultParam extends ResultParam {
    public AorBManager aorBManager;
    private transient long ax;
    private final transient MessageAttr axAttr;
    private transient String axStr;
    private transient long ay;
    private final transient MessageAttr ayAttr;
    private transient String ayStr;
    private transient long bx;
    private final transient MessageAttr bxAttr;
    private transient String bxStr;
    private transient long by;
    private final transient MessageAttr byAttr;
    private transient String byStr;
    private transient boolean cursorEnable;
    private ServiceEnum.CursorView cursorLineAMode;
    private ServiceEnum.CursorView cursorLineBMode;
    private transient ServiceEnum.CursorMode cursorMode;
    private transient String deltaXStr;
    private transient String deltaYStr;
    private transient String invertDeltaXStr;
    private transient boolean isBothAB;
    private transient ServiceEnum.Unit unit;
    private transient ServiceEnum.CursorView view;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$10;
        public static final /* synthetic */ int[] $EnumSwitchMapping$11;
        public static final /* synthetic */ int[] $EnumSwitchMapping$12;
        public static final /* synthetic */ int[] $EnumSwitchMapping$13;
        public static final /* synthetic */ int[] $EnumSwitchMapping$14;
        public static final /* synthetic */ int[] $EnumSwitchMapping$15;
        public static final /* synthetic */ int[] $EnumSwitchMapping$16;
        public static final /* synthetic */ int[] $EnumSwitchMapping$17;
        public static final /* synthetic */ int[] $EnumSwitchMapping$18;
        public static final /* synthetic */ int[] $EnumSwitchMapping$19;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$20;
        public static final /* synthetic */ int[] $EnumSwitchMapping$21;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;
        public static final /* synthetic */ int[] $EnumSwitchMapping$9;

        static {
            int[] iArr = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            int[] iArr2 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$1[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$1[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr3 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 1;
            $EnumSwitchMapping$2[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            int[] iArr4 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$3[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            int[] iArr5 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$4[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$4[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr6 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$5[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$5[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr7 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$6[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$6[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr8 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$7 = iArr8;
            iArr8[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$7[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$7[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr9 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$8 = iArr9;
            iArr9[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$8[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$8[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr10 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$9 = iArr10;
            iArr10[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$9[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$9[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr11 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$10 = iArr11;
            iArr11[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$10[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$10[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr12 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$11 = iArr12;
            iArr12[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$11[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$11[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr13 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$12 = iArr13;
            iArr13[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$12[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$12[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr14 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$13 = iArr14;
            iArr14[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$13[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            int[] iArr15 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$14 = iArr15;
            iArr15[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            int[] iArr16 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$15 = iArr16;
            iArr16[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$15[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$15[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr17 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$16 = iArr17;
            iArr17[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 1;
            $EnumSwitchMapping$16[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 2;
            int[] iArr18 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$17 = iArr18;
            iArr18[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$17[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$17[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr19 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$18 = iArr19;
            iArr19[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$18[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$18[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr20 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$19 = iArr20;
            iArr20[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$19[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$19[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr21 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$20 = iArr21;
            iArr21[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$20[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$20[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr22 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$21 = iArr22;
            iArr22[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 1;
            $EnumSwitchMapping$21[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 2;
        }
    }

    public CursorResultParam() {
        super(21);
        this.cursorMode = ServiceEnum.CursorMode.cursor_mode_manual;
        this.view = ServiceEnum.CursorView.cursor_view_hori;
        this.axAttr = new MessageAttr();
        this.bxAttr = new MessageAttr();
        this.ayAttr = new MessageAttr();
        this.byAttr = new MessageAttr();
        this.cursorLineAMode = ServiceEnum.CursorView.cursor_view_hori;
        this.cursorLineBMode = ServiceEnum.CursorView.cursor_view_hori;
    }

    public final AorBManager getAorBManager() {
        AorBManager aorBManager = this.aorBManager;
        if (aorBManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aorBManager");
        }
        return aorBManager;
    }

    public final void setAorBManager(AorBManager aorBManager) {
        Intrinsics.checkNotNullParameter(aorBManager, "<set-?>");
        this.aorBManager = aorBManager;
    }

    @Bindable
    public final boolean getCursorEnable() {
        return this.cursorEnable;
    }

    public final void setCursorEnable(boolean z) {
        this.cursorEnable = z;
        notifyPropertyChanged(203);
    }

    @Bindable
    public final ServiceEnum.CursorMode getCursorMode() {
        return this.cursorMode;
    }

    public final void setCursorMode(ServiceEnum.CursorMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.cursorMode = value;
        notifyPropertyChanged(205);
        if (this.cursorMode == ServiceEnum.CursorMode.cursor_mode_off) {
            syncData(MessageID.MSG_CURSOR_MODE, false);
            FunctionManager.getInstance().restoreSelectedFunction();
        }
        readUnit();
    }

    @Bindable
    public final long getAx() {
        return this.ax;
    }

    public final void setAx(long j) {
        this.ax = j;
        notifyPropertyChanged(67);
    }

    @Bindable
    public final long getBx() {
        return this.bx;
    }

    public final void setBx(long j) {
        this.bx = j;
        notifyPropertyChanged(129);
    }

    @Bindable
    public final long getAy() {
        return this.ay;
    }

    public final void setAy(long j) {
        this.ay = j;
        notifyPropertyChanged(69);
    }

    @Bindable
    public final long getBy() {
        return this.by;
    }

    public final void setBy(long j) {
        this.by = j;
        notifyPropertyChanged(131);
    }

    @Bindable
    public final ServiceEnum.CursorView getView() {
        return this.view;
    }

    public final void setView(ServiceEnum.CursorView value) {
        Intrinsics.checkNotNullParameter(value, "value");
        this.view = value;
        notifyPropertyChanged(1032);
        readUnit();
    }

    @Bindable
    public final boolean isBothAB() {
        return this.isBothAB;
    }

    public final void setBothAB(boolean z) {
        this.isBothAB = z;
        notifyPropertyChanged(120);
    }

    @Bindable
    public final ServiceEnum.Unit getUnit() {
        return this.unit;
    }

    public final void setUnit(ServiceEnum.Unit unit) {
        this.unit = unit;
        notifyPropertyChanged(987);
        readAbXy();
    }

    public final MessageAttr getAxAttr() {
        return this.axAttr;
    }

    public final MessageAttr getBxAttr() {
        return this.bxAttr;
    }

    public final MessageAttr getAyAttr() {
        return this.ayAttr;
    }

    public final MessageAttr getByAttr() {
        return this.byAttr;
    }

    @Bindable
    public final String getAxStr() {
        return this.axStr;
    }

    public final void setAxStr(String str) {
        this.axStr = str;
        notifyPropertyChanged(68);
    }

    @Bindable
    public final String getBxStr() {
        return this.bxStr;
    }

    public final void setBxStr(String str) {
        this.bxStr = str;
        notifyPropertyChanged(130);
    }

    @Bindable
    public final String getAyStr() {
        return this.ayStr;
    }

    public final void setAyStr(String str) {
        this.ayStr = str;
        notifyPropertyChanged(70);
    }

    @Bindable
    public final String getByStr() {
        return this.byStr;
    }

    public final void setByStr(String str) {
        this.byStr = str;
        notifyPropertyChanged(132);
    }

    @Bindable
    public final String getDeltaXStr() {
        return this.deltaXStr;
    }

    public final void setDeltaXStr(String str) {
        this.deltaXStr = str;
    }

    @Bindable
    public final String getDeltaYStr() {
        return this.deltaYStr;
    }

    public final void setDeltaYStr(String str) {
        this.deltaYStr = str;
    }

    @Bindable
    public final String getInvertDeltaXStr() {
        return this.invertDeltaXStr;
    }

    public final void setInvertDeltaXStr(String str) {
        this.invertDeltaXStr = str;
    }

    public final ServiceEnum.CursorView getCursorLineAMode() {
        return this.cursorLineAMode;
    }

    public final void setCursorLineAMode(ServiceEnum.CursorView cursorView) {
        Intrinsics.checkNotNullParameter(cursorView, "<set-?>");
        this.cursorLineAMode = cursorView;
    }

    public final ServiceEnum.CursorView getCursorLineBMode() {
        return this.cursorLineBMode;
    }

    public final void setCursorLineBMode(ServiceEnum.CursorView cursorView) {
        Intrinsics.checkNotNullParameter(cursorView, "<set-?>");
        this.cursorLineBMode = cursorView;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readCursorEnable();
        readMode();
        readSourceA();
        readSourceB();
        readSyncArea();
        readXorY();
        readAbXy();
        readBothAB();
        readUnit();
        readAxAttr();
        readBxAttr();
        readAyAttr();
        readByAttr();
    }

    public final void readAbXy() {
        readAx();
        readBx();
        readAy();
        readBy();
    }

    public final void setViewCursorView(ServiceEnum.CursorView cursorView) {
        Intrinsics.checkNotNullParameter(cursorView, "cursorView");
        setView(cursorView);
    }

    public final boolean readCursorEnable() {
        setCursorEnable(readBool(MessageID.MSG_CURSOR_EN));
        setEnable(this.cursorEnable);
        return this.cursorEnable;
    }

    public final ServiceEnum.CursorMode readMode() {
        ServiceEnum.CursorMode cursorModeFromValue1 = ServiceEnum.getCursorModeFromValue1(readInt(MessageID.MSG_CURSOR_MODE));
        Intrinsics.checkNotNullExpressionValue(cursorModeFromValue1, "ServiceEnum.getCursorMod…ssageID.MSG_CURSOR_MODE))");
        setCursorMode(cursorModeFromValue1);
        return this.cursorMode;
    }

    public final ServiceEnum.Chan readSyncArea() {
        ServiceEnum.Chan chanFromValue1;
        if (WhenMappings.$EnumSwitchMapping$0[this.cursorMode.ordinal()] == 1) {
            chanFromValue1 = ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_CURSOR_MANUAL_MIRROR_SRC));
            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromV…URSOR_MANUAL_MIRROR_SRC))");
        } else {
            chanFromValue1 = ServiceEnum.Chan.chan_none;
        }
        setSyncArea(chanFromValue1);
        return getSyncArea();
    }

    public final ServiceEnum.Chan readSourceA() {
        ServiceEnum.Chan chanFromValue1;
        int i = WhenMappings.$EnumSwitchMapping$1[this.cursorMode.ordinal()];
        if (i == 1) {
            chanFromValue1 = ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_CURSOR_MANUALSRC));
            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromV…ID.MSG_CURSOR_MANUALSRC))");
        } else if (i == 2) {
            chanFromValue1 = ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_CURSOR_TASRC));
            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromV…sageID.MSG_CURSOR_TASRC))");
        } else if (i == 3) {
            chanFromValue1 = ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_CURSOR_XY_SRC_X));
            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromV…eID.MSG_CURSOR_XY_SRC_X))");
        } else {
            chanFromValue1 = ServiceEnum.Chan.chan_none;
        }
        setSourceA(chanFromValue1);
        return getSourceA();
    }

    public final ServiceEnum.Chan readSourceB() {
        ServiceEnum.Chan chanFromValue1;
        int i = WhenMappings.$EnumSwitchMapping$2[this.cursorMode.ordinal()];
        if (i == 1) {
            chanFromValue1 = ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_CURSOR_XY_SRC_Y));
            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromV…eID.MSG_CURSOR_XY_SRC_Y))");
        } else if (i == 2) {
            chanFromValue1 = ServiceEnum.getChanFromValue1(readInt(MessageID.MSG_CURSOR_TBSRC));
            Intrinsics.checkNotNullExpressionValue(chanFromValue1, "ServiceEnum.getChanFromV…sageID.MSG_CURSOR_TBSRC))");
        } else {
            chanFromValue1 = ServiceEnum.Chan.chan_none;
        }
        setSourceB(chanFromValue1);
        return getSourceB();
    }

    public final ServiceEnum.CursorView readXorY() {
        int readInt;
        ServiceEnum.CursorView cursorView;
        int i = WhenMappings.$EnumSwitchMapping$3[this.cursorMode.ordinal()];
        if (i == 1) {
            readInt = readInt(MessageID.MSG_CURSOR_TYPE);
        } else if (i == 2) {
            readInt = readInt(MessageID.MSG_CURSOR_TRACK_MODE);
        } else {
            readInt = ServiceEnum.CursorView.cursor_view_hori.value1;
        }
        if (readInt == ServiceEnum.CursorView.cursor_view_vert.value1) {
            cursorView = ServiceEnum.CursorView.cursor_view_vert;
        } else {
            cursorView = ServiceEnum.CursorView.cursor_view_hori;
        }
        setView(cursorView);
        syncData(MessageID.MSG_CURSOR_TYPE, Integer.valueOf(this.view.value1));
        return this.view;
    }

    public final long readAx() {
        long readLong;
        int i = WhenMappings.$EnumSwitchMapping$4[this.cursorMode.ordinal()];
        if (i == 1) {
            readLong = readLong(MessageID.MSG_CURSOR_HAPOS);
        } else if (i == 2) {
            readLong = readLong(MessageID.MSG_CURSOR_TAPOS);
        } else {
            readLong = i != 3 ? 0L : readLong(MessageID.MSG_CURSOR_XY_XA);
        }
        setAx(readLong);
        readAxAttr();
        return this.ax;
    }

    public final long readBx() {
        long readLong;
        int i = WhenMappings.$EnumSwitchMapping$5[this.cursorMode.ordinal()];
        if (i == 1) {
            readLong = readLong(MessageID.MSG_CURSOR_HBPOS);
        } else if (i == 2) {
            readLong = readLong(MessageID.MSG_CURSOR_TBPOS);
        } else {
            readLong = i != 3 ? 0L : readLong(MessageID.MSG_CURSOR_XY_XB);
        }
        setBx(readLong);
        readBxAttr();
        return this.bx;
    }

    public final long readAy() {
        long readLong;
        int i = WhenMappings.$EnumSwitchMapping$6[this.cursorMode.ordinal()];
        if (i == 1) {
            readLong = readLong(MessageID.MSG_CURSOR_VAPOS);
        } else if (i == 2) {
            readLong = readLong(MessageID.MSG_CURSOR_TAPOS_V);
        } else {
            readLong = i != 3 ? 0L : readLong(MessageID.MSG_CURSOR_XY_YA);
        }
        setAy(readLong);
        readAyAttr();
        return this.ay;
    }

    public final long readBy() {
        long readLong;
        int i = WhenMappings.$EnumSwitchMapping$7[this.cursorMode.ordinal()];
        if (i == 1) {
            readLong = readLong(MessageID.MSG_CURSOR_VBPOS);
        } else if (i == 2) {
            readLong = readLong(MessageID.MSG_CURSOR_TBPOS_V);
        } else {
            readLong = i != 3 ? 0L : readLong(MessageID.MSG_CURSOR_XY_YB);
        }
        setBy(readLong);
        readByAttr();
        return this.by;
    }

    public final void readAxAttr() {
        int i = WhenMappings.$EnumSwitchMapping$8[this.cursorMode.ordinal()];
        if (i == 1) {
            readAttr(MessageID.MSG_CURSOR_HAPOS, this.axAttr);
        } else if (i == 2) {
            readAttr(MessageID.MSG_CURSOR_TAPOS, this.axAttr);
        } else if (i != 3) {
        } else {
            readAttr(MessageID.MSG_CURSOR_XY_XA, this.axAttr);
        }
    }

    public final void readBxAttr() {
        int i = WhenMappings.$EnumSwitchMapping$9[this.cursorMode.ordinal()];
        if (i == 1) {
            readAttr(MessageID.MSG_CURSOR_HBPOS, this.bxAttr);
        } else if (i == 2) {
            readAttr(MessageID.MSG_CURSOR_TBPOS, this.bxAttr);
        } else if (i != 3) {
        } else {
            readAttr(MessageID.MSG_CURSOR_XY_XB, this.bxAttr);
        }
    }

    public final void readAyAttr() {
        int i = WhenMappings.$EnumSwitchMapping$10[this.cursorMode.ordinal()];
        if (i == 1) {
            readAttr(MessageID.MSG_CURSOR_VAPOS, this.ayAttr);
        } else if (i == 2) {
            readAttr(MessageID.MSG_CURSOR_TAPOS_V, this.ayAttr);
        } else if (i != 3) {
        } else {
            readAttr(MessageID.MSG_CURSOR_XY_YA, this.ayAttr);
        }
    }

    public final void readByAttr() {
        int i = WhenMappings.$EnumSwitchMapping$11[this.cursorMode.ordinal()];
        if (i == 1) {
            readAttr(MessageID.MSG_CURSOR_VBPOS, this.byAttr);
        } else if (i == 2) {
            readAttr(MessageID.MSG_CURSOR_TBPOS_V, this.byAttr);
        } else if (i != 3) {
        } else {
            readAttr(MessageID.MSG_CURSOR_XY_YB, this.byAttr);
        }
    }

    public final boolean readBothAB() {
        setBothAB(readBool(MessageID.MSG_CURSOR_CHANED_AB));
        return this.isBothAB;
    }

    public final ServiceEnum.Unit readUnit() {
        int readInt;
        ServiceEnum.Unit unit;
        int i = WhenMappings.$EnumSwitchMapping$12[this.cursorMode.ordinal()];
        if (i == 1) {
            if (this.view == ServiceEnum.CursorView.cursor_view_hori) {
                readInt = readInt(MessageID.MSG_CURSOR_TIMEUNIT);
            } else {
                readInt = readInt(MessageID.MSG_CURSOR_VUNIT);
            }
            setUnit(ServiceEnum.getUnitFromValue1(readInt));
        } else if (i == 2) {
            if (this.view == ServiceEnum.CursorView.cursor_view_hori) {
                unit = ServiceEnum.Unit.Unit_s;
            } else {
                unit = ServiceEnum.Unit.Unit_V;
            }
            setUnit(unit);
        } else if (i == 3) {
            setUnit(ServiceEnum.Unit.Unit_V);
        }
        return this.unit;
    }

    public final void saveCursorEnable(boolean z) {
        saveBool(MessageID.MSG_CURSOR_EN, z);
    }

    public final void saveMode(ServiceEnum.CursorMode mode) {
        Intrinsics.checkNotNullParameter(mode, "mode");
        setCursorMode(mode);
        saveInt(MessageID.MSG_CURSOR_MODE, mode.value1);
    }

    public final void saveXorY(boolean z) {
        ServiceEnum.CursorView cursorView;
        if (z) {
            cursorView = ServiceEnum.CursorView.cursor_view_vert;
        } else {
            cursorView = ServiceEnum.CursorView.cursor_view_hori;
        }
        setView(cursorView);
        int i = WhenMappings.$EnumSwitchMapping$13[this.cursorMode.ordinal()];
        if (i == 1) {
            saveInt(MessageID.MSG_CURSOR_TYPE, this.view.value1);
        } else if (i != 2) {
        } else {
            saveInt(MessageID.MSG_CURSOR_TRACK_MODE, this.view.value1);
        }
    }

    public final void setEnable(boolean z) {
        setCursorEnable(z);
        notifyPropertyChanged(203);
        syncData(MessageID.MSG_CURSOR_EN, Boolean.valueOf(z));
    }

    public final void saveSyncArea(ServiceEnum.Chan area) {
        Intrinsics.checkNotNullParameter(area, "area");
        setSyncArea(area);
        if (WhenMappings.$EnumSwitchMapping$14[this.cursorMode.ordinal()] != 1) {
            return;
        }
        saveInt(MessageID.MSG_CURSOR_MANUAL_MIRROR_SRC, getSyncArea().value1);
    }

    public final void saveSourceA(ServiceEnum.Chan source) {
        Intrinsics.checkNotNullParameter(source, "source");
        setSourceA(source);
        int i = WhenMappings.$EnumSwitchMapping$15[this.cursorMode.ordinal()];
        if (i == 1) {
            saveInt(MessageID.MSG_CURSOR_MANUALSRC, source.value1);
        } else if (i == 2) {
            saveInt(MessageID.MSG_CURSOR_TASRC, source.value1);
        } else if (i != 3) {
        } else {
            saveInt(MessageID.MSG_CURSOR_XY_SRC_X, source.value1);
        }
    }

    public final void saveSourceB(ServiceEnum.Chan source) {
        Intrinsics.checkNotNullParameter(source, "source");
        setSourceB(source);
        int i = WhenMappings.$EnumSwitchMapping$16[this.cursorMode.ordinal()];
        if (i == 1) {
            saveInt(MessageID.MSG_CURSOR_TBSRC, source.value1);
        } else if (i != 2) {
        } else {
            saveInt(MessageID.MSG_CURSOR_XY_SRC_Y, source.value1);
        }
    }

    public final void saveBothAB(boolean z) {
        setBothAB(z);
        saveBool(MessageID.MSG_CURSOR_CHANED_AB, z);
    }

    public final void saveUnit(ServiceEnum.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        setUnit(unit);
        if (this.view == ServiceEnum.CursorView.cursor_view_hori) {
            saveInt(MessageID.MSG_CURSOR_TIMEUNIT, unit.value1);
        } else {
            saveInt(MessageID.MSG_CURSOR_VUNIT, unit.value1);
        }
    }

    public final void saveAx(long j) {
        setAx(j);
        int i = WhenMappings.$EnumSwitchMapping$17[this.cursorMode.ordinal()];
        if (i == 1) {
            saveLong(MessageID.MSG_CURSOR_HAPOS, j);
        } else if (i == 2) {
            saveLong(MessageID.MSG_CURSOR_TAPOS, j);
        } else if (i != 3) {
        } else {
            saveLong(MessageID.MSG_CURSOR_XY_XA, j);
        }
    }

    public final void saveBx(long j) {
        setBx(j);
        int i = WhenMappings.$EnumSwitchMapping$18[this.cursorMode.ordinal()];
        if (i == 1) {
            saveLong(MessageID.MSG_CURSOR_HBPOS, j);
        } else if (i == 2) {
            saveLong(MessageID.MSG_CURSOR_TBPOS, j);
        } else if (i != 3) {
        } else {
            saveLong(MessageID.MSG_CURSOR_XY_XB, j);
        }
    }

    public final void saveAy(long j) {
        setAy(j);
        int i = WhenMappings.$EnumSwitchMapping$19[this.cursorMode.ordinal()];
        if (i == 1) {
            saveLong(MessageID.MSG_CURSOR_VAPOS, j);
        } else if (i == 2) {
            saveLong(MessageID.MSG_CURSOR_TAPOS_V, j);
        } else if (i != 3) {
        } else {
            saveLong(MessageID.MSG_CURSOR_XY_YA, j);
        }
    }

    public final void saveBy(long j) {
        setBy(j);
        int i = WhenMappings.$EnumSwitchMapping$20[this.cursorMode.ordinal()];
        if (i == 1) {
            saveLong(MessageID.MSG_CURSOR_VBPOS, j);
        } else if (i == 2) {
            saveLong(MessageID.MSG_CURSOR_TBPOS_V, j);
        } else if (i != 3) {
        } else {
            saveLong(MessageID.MSG_CURSOR_XY_YB, j);
        }
    }

    public final void saveAPosition(int i) {
        MutableLiveData<Boolean> ax_boolean = ViewUtil.getViewABkeyViewModel().getAx_boolean();
        Intrinsics.checkNotNullExpressionValue(ax_boolean, "ViewUtil.getViewABkeyViewModel().getAx_boolean()");
        Boolean value = ax_boolean.getValue();
        Intrinsics.checkNotNull(value);
        if (value.booleanValue()) {
            saveInt(MessageID.MSG_CURSOR_AX_POS, superRepeat(i));
        } else {
            saveInt(MessageID.MSG_CURSOR_AY_POS, -superRepeat(i));
        }
    }

    public final void saveBPosition(int i) {
        MutableLiveData<Boolean> bx_boolean = ViewUtil.getViewABkeyViewModel().getBx_boolean();
        Intrinsics.checkNotNullExpressionValue(bx_boolean, "ViewUtil.getViewABkeyViewModel().getBx_boolean()");
        Boolean value = bx_boolean.getValue();
        Intrinsics.checkNotNull(value);
        if (value.booleanValue()) {
            saveInt(MessageID.MSG_CURSOR_BX_POS, superRepeat(i));
        } else {
            saveInt(MessageID.MSG_CURSOR_BY_POS, -superRepeat(i));
        }
    }

    private final int superRepeat(int i) {
        return Math.abs(i) > 1 ? i * 2 : i;
    }

    public final List<ThreeTuple<String, String, Float>> getData() {
        if (getItemData().isEmpty()) {
            getItemData().add(new ThreeTuple<>("AX:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("AY:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("BX:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("BY:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("ΔX:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("ΔY:", "*****", Float.valueOf(0.33f)));
            getItemData().add(new ThreeTuple<>("1/ΔX:", "*****", Float.valueOf(0.33f)));
        }
        return getItemData();
    }

    public final void setData(String[] data) {
        Intrinsics.checkNotNullParameter(data, "data");
        getItemData().clear();
        setSourceA(getSource(data[1]));
        setAxStr(ContextUtil.getResultText(data[3]));
        ArrayList<ThreeTuple<String, String, Float>> itemData = getItemData();
        String str = this.axStr;
        Float valueOf = Float.valueOf(0.33f);
        itemData.add(new ThreeTuple<>("AX:", str, valueOf));
        setAyStr(ContextUtil.getResultText(data[4]));
        getItemData().add(new ThreeTuple<>("AY:", this.ayStr, valueOf));
        setBxStr(ContextUtil.getResultText(data[5]));
        getItemData().add(new ThreeTuple<>("BX:", this.bxStr, valueOf));
        setByStr(ContextUtil.getResultText(data[6]));
        getItemData().add(new ThreeTuple<>("BY:", this.byStr, valueOf));
        this.deltaXStr = ContextUtil.getResultText(data[7]);
        getItemData().add(new ThreeTuple<>("ΔX:", this.deltaXStr, valueOf));
        this.deltaYStr = ContextUtil.getResultText(data[8]);
        getItemData().add(new ThreeTuple<>("ΔY:", this.deltaYStr, valueOf));
        this.invertDeltaXStr = ContextUtil.getResultText(data[9]);
        getItemData().add(new ThreeTuple<>("1/ΔX:", this.invertDeltaXStr, valueOf));
        ThreadUtils.getMainHandler().postDelayed(new Runnable() { // from class: com.rigol.scope.data.CursorResultParam$setData$1
            @Override // java.lang.Runnable
            public final void run() {
                MessageBus.getInstance().onSyncData(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_CURSOR, true);
            }
        }, 10L);
    }

    public final ServiceEnum.Chan getSourceAWidthMode() {
        if (this.cursorMode == ServiceEnum.CursorMode.cursor_mode_xy) {
            if (this.view == ServiceEnum.CursorView.cursor_view_hori) {
                return getSourceA();
            }
            return getSourceB();
        }
        return getSourceA();
    }

    public final ServiceEnum.Chan getSourceBWidthMode() {
        int i = WhenMappings.$EnumSwitchMapping$21[this.cursorMode.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return getSourceA();
            }
            return getSourceB();
        } else if (this.view == ServiceEnum.CursorView.cursor_view_hori) {
            return getSourceA();
        } else {
            return getSourceB();
        }
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setCursorMode(ServiceEnum.CursorMode.cursor_mode_off);
        setBothAB(false);
        setSyncArea(ServiceEnum.Chan.chan_none);
    }

    public final void remove() {
        saveMode(ServiceEnum.CursorMode.cursor_mode_off);
    }
}
