package com.rigol.scope.data;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.databinding.Bindable;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.OffsetUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ScaleNumUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: VerticalParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b+\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b<\u0018\u00002\u00020\u0001B\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0007\u0010 \u0001\u001a\u00020\bJ\u0010\u0010¡\u0001\u001a\u00030¢\u00012\u0006\u0010?\u001a\u00020\bJ\u0010\u0010£\u0001\u001a\u00020\b2\u0007\u0010¤\u0001\u001a\u00020\u0005J\u0010\u0010¥\u0001\u001a\u00020\b2\u0007\u0010¤\u0001\u001a\u00020\u0005J\u0010\u0010¦\u0001\u001a\u00020\b2\u0007\u0010¤\u0001\u001a\u00020\u0005J\u0010\u0010§\u0001\u001a\u00020\b2\u0007\u0010¤\u0001\u001a\u00020\u0005J\u0007\u0010V\u001a\u00030¢\u0001J\b\u0010¨\u0001\u001a\u00030¢\u0001J\n\u0010©\u0001\u001a\u00030¢\u0001H\u0016J\u0007\u0010ª\u0001\u001a\u00020\u0014J\u0007\u0010«\u0001\u001a\u00020\bJ\u0007\u0010¬\u0001\u001a\u00020!J\u0007\u0010\u00ad\u0001\u001a\u00020(J\u0007\u0010®\u0001\u001a\u00020.J\u0007\u0010¯\u0001\u001a\u00020(J\t\u0010°\u0001\u001a\u0004\u0018\u00010\u0003J\u0007\u0010±\u0001\u001a\u00020\bJ\u0007\u0010²\u0001\u001a\u00020\bJ\u0007\u0010³\u0001\u001a\u00020\bJ\b\u0010´\u0001\u001a\u00030¢\u0001J\u0007\u0010µ\u0001\u001a\u00020(J\u0007\u0010¶\u0001\u001a\u00020\bJ\u0007\u0010·\u0001\u001a\u00020\bJ\b\u0010¸\u0001\u001a\u00030¢\u0001J\u0007\u0010¹\u0001\u001a\u00020\u0003J\u0007\u0010º\u0001\u001a\u00020(J\u0007\u0010»\u0001\u001a\u00020sJ\u0007\u0010¼\u0001\u001a\u00020|J\b\u0010½\u0001\u001a\u00030\u0085\u0001J\u0007\u0010¾\u0001\u001a\u00020\bJ\u0007\u0010¿\u0001\u001a\u00020\bJ\u0007\u0010À\u0001\u001a\u00020(J\b\u0010Á\u0001\u001a\u00030\u0093\u0001J\u0007\u0010Â\u0001\u001a\u00020|J\n\u0010Ã\u0001\u001a\u00030¢\u0001H\u0016J\b\u0010Ä\u0001\u001a\u00030¢\u0001J\u0010\u0010Å\u0001\u001a\u00030¢\u00012\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010Æ\u0001\u001a\u00030¢\u00012\u0006\u0010\u001e\u001a\u00020\bJ\u0010\u0010Ç\u0001\u001a\u00030¢\u00012\u0006\u0010\"\u001a\u00020!J\u0010\u0010È\u0001\u001a\u00030¢\u00012\u0006\u0010)\u001a\u00020(J\u0010\u0010É\u0001\u001a\u00030¢\u00012\u0006\u0010/\u001a\u00020.J\u0010\u0010Ê\u0001\u001a\u00030¢\u00012\u0006\u00107\u001a\u00020(J\u0012\u0010Ë\u0001\u001a\u00030¢\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0003J\u0010\u0010Ì\u0001\u001a\u00030¢\u00012\u0006\u0010?\u001a\u00020\bJ\u0010\u0010Í\u0001\u001a\u00030¢\u00012\u0006\u0010?\u001a\u00020\bJ\u0010\u0010Î\u0001\u001a\u00030¢\u00012\u0006\u0010L\u001a\u00020\bJ\u0010\u0010Ï\u0001\u001a\u00030¢\u00012\u0006\u0010Q\u001a\u00020\bJ\u0010\u0010Ð\u0001\u001a\u00030¢\u00012\u0006\u0010\\\u001a\u00020\bJ\u0010\u0010Ñ\u0001\u001a\u00030¢\u00012\u0006\u0010_\u001a\u00020\bJ\u0010\u0010Ò\u0001\u001a\u00030¢\u00012\u0006\u0010t\u001a\u00020sJ\u0010\u0010Ó\u0001\u001a\u00030¢\u00012\u0006\u0010}\u001a\u00020|J\u0011\u0010Ô\u0001\u001a\u00030¢\u00012\u0007\u0010\u008b\u0001\u001a\u00020\bJ\u0011\u0010Õ\u0001\u001a\u00030¢\u00012\u0007\u0010\u0090\u0001\u001a\u00020(J\u0012\u0010Ö\u0001\u001a\u00030¢\u00012\b\u0010\u0094\u0001\u001a\u00030\u0093\u0001J\u0011\u0010×\u0001\u001a\u00030¢\u00012\u0007\u0010\u009a\u0001\u001a\u00020|J\u0011\u0010Ø\u0001\u001a\u00030¢\u00012\u0007\u0010¤\u0001\u001a\u00020\u0005J\u0011\u0010Ù\u0001\u001a\u00030¢\u00012\u0007\u0010¤\u0001\u001a\u00020\u0005J\b\u0010Ú\u0001\u001a\u00030¢\u0001J\b\u0010Û\u0001\u001a\u00030¢\u0001J\b\u0010Ü\u0001\u001a\u00030¢\u0001J\b\u0010Ý\u0001\u001a\u00030¢\u0001R&\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R&\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00148G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000b\"\u0004\b \u0010\rR&\u0010\"\u001a\u00020!2\u0006\u0010\u0007\u001a\u00020!8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010)\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u0010/\u001a\u00020.2\u0006\u0010\u0007\u001a\u00020.8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R&\u00104\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010+\"\u0004\b6\u0010-R&\u00107\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010+\"\u0004\b9\u0010-R*\u0010:\u001a\u0004\u0018\u00010\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u00038G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R&\u0010?\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u000b\"\u0004\bA\u0010\rR\u0011\u0010B\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u001c\u0010F\u001a\u0004\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR&\u0010L\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u000b\"\u0004\bN\u0010\rR\u0011\u0010O\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bP\u0010ER&\u0010Q\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u000b\"\u0004\bS\u0010\rR\u0011\u0010T\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bU\u0010ER&\u0010V\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010+\"\u0004\bX\u0010-R&\u0010Y\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010<\"\u0004\b[\u0010>R&\u0010\\\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\u000b\"\u0004\b^\u0010\rR&\u0010_\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u000b\"\u0004\ba\u0010\rR\u0011\u0010b\u001a\u00020C¢\u0006\b\n\u0000\u001a\u0004\bc\u0010ER&\u0010d\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010+\"\u0004\bf\u0010-R&\u0010g\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010<\"\u0004\bi\u0010>R&\u0010j\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010+\"\u0004\bl\u0010-R&\u0010m\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010<\"\u0004\bo\u0010>R&\u0010p\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010<\"\u0004\br\u0010>R&\u0010t\u001a\u00020s2\u0006\u0010\u0007\u001a\u00020s8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR&\u0010y\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010+\"\u0004\b{\u0010-R(\u0010}\u001a\u00020|2\u0006\u0010\u0007\u001a\u00020|8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0004\b~\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R)\u0010\u0082\u0001\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00038G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010<\"\u0005\b\u0084\u0001\u0010>R-\u0010\u0086\u0001\u001a\u00030\u0085\u00012\u0007\u0010\u0007\u001a\u00030\u0085\u00018G@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R)\u0010\u008b\u0001\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010\u000b\"\u0005\b\u008d\u0001\u0010\rR\u0013\u0010\u008e\u0001\u001a\u00020C¢\u0006\t\n\u0000\u001a\u0005\b\u008f\u0001\u0010ER)\u0010\u0090\u0001\u001a\u00020(2\u0006\u0010\u0007\u001a\u00020(8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0091\u0001\u0010+\"\u0005\b\u0092\u0001\u0010-R-\u0010\u0094\u0001\u001a\u00030\u0093\u00012\u0007\u0010\u0007\u001a\u00030\u0093\u00018G@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0095\u0001\u0010\u0096\u0001\"\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\t\n\u0000\u001a\u0005\b\u0099\u0001\u0010<R*\u0010\u009a\u0001\u001a\u00020|2\u0006\u0010\u0007\u001a\u00020|8G@FX\u0086\u000e¢\u0006\u0011\n\u0000\u001a\u0005\b\u009b\u0001\u0010\u007f\"\u0006\b\u009c\u0001\u0010\u0081\u0001R\u001d\u0010\u009d\u0001\u001a\u00020\u0003X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010<\"\u0005\b\u009f\u0001\u0010>¨\u0006Þ\u0001"}, d2 = {"Lcom/rigol/scope/data/VerticalParam;", "Lcom/rigol/scope/data/BaseParam;", "title", "", "serviceId", "", "(Ljava/lang/String;I)V", "value", "", "RealScale", "getRealScale", "()J", "setRealScale", "(J)V", "aorBManager", "Lcom/rigol/scope/utilities/AorBManager;", "getAorBManager", "()Lcom/rigol/scope/utilities/AorBManager;", "setAorBManager", "(Lcom/rigol/scope/utilities/AorBManager;)V", "Lcom/rigol/scope/cil/ServiceEnum$Bandwidth;", "bandLimit", "getBandLimit", "()Lcom/rigol/scope/cil/ServiceEnum$Bandwidth;", "setBandLimit", "(Lcom/rigol/scope/cil/ServiceEnum$Bandwidth;)V", "chan", "Lcom/rigol/scope/cil/ServiceEnum$Chan;", "getChan", "()Lcom/rigol/scope/cil/ServiceEnum$Chan;", "chanDelay", "getChanDelay", "setChanDelay", "Lcom/rigol/scope/cil/ServiceEnum$Coupling;", "coupling", "getCoupling", "()Lcom/rigol/scope/cil/ServiceEnum$Coupling;", "setCoupling", "(Lcom/rigol/scope/cil/ServiceEnum$Coupling;)V", "enableToSetOffset", "", "fine", "getFine", "()Z", "setFine", "(Z)V", "Lcom/rigol/scope/cil/ServiceEnum$Impedance;", "impedance", "getImpedance", "()Lcom/rigol/scope/cil/ServiceEnum$Impedance;", "setImpedance", "(Lcom/rigol/scope/cil/ServiceEnum$Impedance;)V", "impedanceEnable", "getImpedanceEnable", "setImpedanceEnable", "invert", "getInvert", "setInvert", "label", "getLabel", "()Ljava/lang/String;", "setLabel", "(Ljava/lang/String;)V", "offset", "getOffset", "setOffset", "offsetAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getOffsetAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "popupSpinner", "Lcom/rigol/scope/views/spinner/PopupSpinner;", "getPopupSpinner", "()Lcom/rigol/scope/views/spinner/PopupSpinner;", "setPopupSpinner", "(Lcom/rigol/scope/views/spinner/PopupSpinner;)V", "position", "getPosition", "setPosition", "positionAttr", "getPositionAttr", "probeBias", "getProbeBias", "setProbeBias", "probeBiasAttr", "getProbeBiasAttr", "probeCal", "getProbeCal", "setProbeCal", "probeCalTime", "getProbeCalTime", "setProbeCalTime", "probeCurrentBias", "getProbeCurrentBias", "setProbeCurrentBias", "probeDelay", "getProbeDelay", "setProbeDelay", "probeDelayAttr", "getProbeDelayAttr", "probeDemagVisible", "getProbeDemagVisible", "setProbeDemagVisible", "probeDetail", "getProbeDetail", "setProbeDetail", "probeInsert", "getProbeInsert", "setProbeInsert", "probeMFR", "getProbeMFR", "setProbeMFR", "probeModel", "getProbeModel", "setProbeModel", "Lcom/rigol/scope/cil/ServiceEnum$ProbeX;", "probeRatio", "getProbeRatio", "()Lcom/rigol/scope/cil/ServiceEnum$ProbeX;", "setProbeRatio", "(Lcom/rigol/scope/cil/ServiceEnum$ProbeX;)V", "probeRatioEnable", "getProbeRatioEnable", "setProbeRatioEnable", "Lcom/rigol/scope/cil/ServiceEnum$Unit;", "probeRatioUnit", "getProbeRatioUnit", "()Lcom/rigol/scope/cil/ServiceEnum$Unit;", "setProbeRatioUnit", "(Lcom/rigol/scope/cil/ServiceEnum$Unit;)V", "probeSN", "getProbeSN", "setProbeSN", "Lcom/rigol/scope/cil/ServiceEnum$ProbeType;", "probeType", "getProbeType", "()Lcom/rigol/scope/cil/ServiceEnum$ProbeType;", "setProbeType", "(Lcom/rigol/scope/cil/ServiceEnum$ProbeType;)V", "scale", "getScale", "setScale", "scaleAttr", "getScaleAttr", "showLabel", "getShowLabel", "setShowLabel", "Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;", "setStatus", "(Lcom/rigol/scope/cil/ServiceEnum$enChanStatus;)V", "getTitle", "unit", "getUnit", "setUnit", "unitHz", "getUnitHz", "setUnitHz", "getScaleValue", "moveOffset", "", "offsetLarger", "count", "offsetSmaller", "positionLarger", "positionSmaller", "probeDemag", "readAll", "readBandLimit", "readChanDelay", "readCoupling", "readFine", "readImpedance", "readInvert", "readLabel", "readOffset", "readPosition", "readProbeBias", "readProbeBiasAttr", "readProbeCal", "readProbeCurrentBias", "readProbeDelay", "readProbeDelayAttr", "readProbeDetail", "readProbeInsert", "readProbeRatio", "readProbeRatioUnit", "readProbeType", "readRealScale", "readScale", "readShowLabel", "readStatus", "readUnit", "reset", "resetOffset", "saveBandwidth", "saveChanDelay", "saveCoupling", "saveFine", "saveImpedance", "saveInvert", "saveLabel", "saveOffset", "saveOffsetReal", "savePosition", "saveProbeBias", "saveProbeCurrentBias", "saveProbeDelay", "saveProbeRatio", "saveProbeRatioUnit", "saveScale", "saveShowLabel", "saveStatus", "saveUnit", "scaleLarger", "scaleSmaller", "toggleFine", "toggleStatus", "turnActive", "turnOff", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class VerticalParam extends BaseParam {
    private long RealScale;
    public AorBManager aorBManager;
    private ServiceEnum.Bandwidth bandLimit;
    private final ServiceEnum.Chan chan;
    private long chanDelay;
    private ServiceEnum.Coupling coupling;
    private boolean enableToSetOffset;
    private boolean fine;
    private ServiceEnum.Impedance impedance;
    private boolean impedanceEnable;
    private boolean invert;
    private String label;
    private long offset;
    private final MessageAttr offsetAttr;
    private PopupSpinner popupSpinner;
    private long position;
    private final MessageAttr positionAttr;
    private long probeBias;
    private final MessageAttr probeBiasAttr;
    private boolean probeCal;
    private String probeCalTime;
    private long probeCurrentBias;
    private long probeDelay;
    private final MessageAttr probeDelayAttr;
    private boolean probeDemagVisible;
    private String probeDetail;
    private boolean probeInsert;
    private String probeMFR;
    private String probeModel;
    private ServiceEnum.ProbeX probeRatio;
    private boolean probeRatioEnable;
    private ServiceEnum.Unit probeRatioUnit;
    private String probeSN;
    private ServiceEnum.ProbeType probeType;
    private long scale;
    private final MessageAttr scaleAttr;
    private boolean showLabel;
    private ServiceEnum.enChanStatus status;
    private final String title;
    private ServiceEnum.Unit unit;
    private String unitHz;

    public VerticalParam(String str, int i) {
        super(i);
        ServiceEnum.enChanStatus enchanstatus;
        ServiceEnum.Coupling coupling;
        ServiceEnum.Bandwidth bandwidth;
        ServiceEnum.ProbeX probeX;
        ServiceEnum.Unit unit;
        ServiceEnum.Impedance impedance;
        ServiceEnum.Unit unit2;
        long j;
        long j2;
        this.title = str;
        ServiceEnum.Chan chanFromServiceId = ViewUtil.getChanFromServiceId(i);
        Intrinsics.checkNotNullExpressionValue(chanFromServiceId, "ViewUtil.getChanFromServiceId(serviceId)");
        this.chan = chanFromServiceId;
        this.unitHz = "Hz";
        enchanstatus = VerticalParamKt.DEFAULT_STATUS;
        this.status = enchanstatus;
        coupling = VerticalParamKt.DEFAULT_COUPING;
        this.coupling = coupling;
        bandwidth = VerticalParamKt.DEFAULT_BANDWIDTH;
        this.bandLimit = bandwidth;
        probeX = VerticalParamKt.DEFAULT_PROBE_RATIO;
        this.probeRatio = probeX;
        unit = VerticalParamKt.DEFAULT_PROBE_RATIO_UNIT;
        this.probeRatioUnit = unit;
        this.probeDetail = "";
        this.probeMFR = "";
        this.probeModel = "";
        this.probeSN = "";
        this.probeCalTime = "";
        this.probeType = ServiceEnum.ProbeType.Probe_BNC;
        this.probeRatioEnable = true;
        this.impedanceEnable = true;
        impedance = VerticalParamKt.DEFAULT_IMPEDANCE;
        this.impedance = impedance;
        unit2 = VerticalParamKt.DEFAULT_UNIT;
        this.unit = unit2;
        j = VerticalParamKt.DEFAULT_SCALE;
        this.scale = j;
        j2 = VerticalParamKt.DEFAULT_SCALE;
        this.RealScale = j2;
        this.scaleAttr = new MessageAttr();
        this.offsetAttr = new MessageAttr();
        this.positionAttr = new MessageAttr();
        this.probeDelayAttr = new MessageAttr();
        this.probeBiasAttr = new MessageAttr();
        this.enableToSetOffset = true;
    }

    public final String getTitle() {
        return this.title;
    }

    public final ServiceEnum.Chan getChan() {
        return this.chan;
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

    public final PopupSpinner getPopupSpinner() {
        return this.popupSpinner;
    }

    public final void setPopupSpinner(PopupSpinner popupSpinner) {
        this.popupSpinner = popupSpinner;
    }

    public final String getUnitHz() {
        return this.unitHz;
    }

    public final void setUnitHz(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.unitHz = str;
    }

    @Bindable
    public final ServiceEnum.enChanStatus getStatus() {
        return this.status;
    }

    public final void setStatus(ServiceEnum.enChanStatus value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", status", this.status, value);
        this.status = value;
        notifyPropertyChanged(909);
        syncData(MessageID.MSG_CHAN_ON_OFF, this.status);
    }

    @Bindable
    public final ServiceEnum.Coupling getCoupling() {
        return this.coupling;
    }

    public final void setCoupling(ServiceEnum.Coupling value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", coupling", this.coupling, value);
        this.coupling = value;
        notifyPropertyChanged(193);
    }

    @Bindable
    public final ServiceEnum.Bandwidth getBandLimit() {
        return this.bandLimit;
    }

    public final void setBandLimit(ServiceEnum.Bandwidth value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", bandLimit", this.bandLimit, value);
        this.bandLimit = value;
        notifyPropertyChanged(71);
    }

    @Bindable
    public final ServiceEnum.ProbeX getProbeRatio() {
        return this.probeRatio;
    }

    public final void setProbeRatio(ServiceEnum.ProbeX value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", probeRatio", this.probeRatio, value);
        this.probeRatio = value;
        notifyPropertyChanged(665);
        ThreadUtils.getMainHandler().postDelayed(new Runnable() { // from class: com.rigol.scope.data.VerticalParam$probeRatio$1
            @Override // java.lang.Runnable
            public final void run() {
                VerticalParam.this.readScale();
                VerticalParam.this.readOffset();
            }
        }, 40L);
    }

    @Bindable
    public final ServiceEnum.Unit getProbeRatioUnit() {
        return this.probeRatioUnit;
    }

    public final void setProbeRatioUnit(ServiceEnum.Unit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", probeRatioUnit", this.probeRatioUnit, value);
        this.probeRatioUnit = value;
        notifyPropertyChanged(667);
        syncData(MessageID.MSG_CHAN_PROBE_UNIT, this.probeRatioUnit);
    }

    @Bindable
    public final String getProbeDetail() {
        return this.probeDetail;
    }

    public final void setProbeDetail(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", probeDetail", this.probeDetail, value);
        this.probeDetail = value;
        notifyPropertyChanged(661);
        if (!TextUtils.isEmpty(this.probeDetail)) {
            List split$default = StringsKt.split$default((CharSequence) this.probeDetail, new String[]{","}, false, 0, 6, (Object) null);
            if (split$default.size() == 4) {
                setProbeMFR((String) split$default.get(0));
                setProbeModel((String) split$default.get(1));
                setProbeSN((String) split$default.get(2));
                setProbeCalTime((String) split$default.get(3));
                return;
            }
            return;
        }
        setProbeMFR("");
        setProbeModel("");
        setProbeSN("");
        setProbeCalTime("");
    }

    @Bindable
    public final String getProbeMFR() {
        return this.probeMFR;
    }

    public final void setProbeMFR(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", probeMFR", this.probeMFR, value);
        this.probeMFR = value;
        notifyPropertyChanged(663);
    }

    @Bindable
    public final String getProbeModel() {
        return this.probeModel;
    }

    public final void setProbeModel(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", probeModel", this.probeModel, value);
        this.probeModel = value;
        notifyPropertyChanged(664);
    }

    @Bindable
    public final String getProbeSN() {
        return this.probeSN;
    }

    public final void setProbeSN(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", probeSN", this.probeSN, value);
        this.probeSN = value;
        notifyPropertyChanged(669);
    }

    @Bindable
    public final String getProbeCalTime() {
        return this.probeCalTime;
    }

    public final void setProbeCalTime(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", probeCalTime", this.probeCalTime, value);
        this.probeCalTime = value;
        notifyPropertyChanged(657);
    }

    @Bindable
    public final ServiceEnum.ProbeType getProbeType() {
        return this.probeType;
    }

    public final void setProbeType(ServiceEnum.ProbeType value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", probeType", this.probeType, value);
        this.probeType = value;
        notifyPropertyChanged(670);
        if (this.probeType == ServiceEnum.ProbeType.Probe_V) {
            setImpedanceEnable(false);
            setProbeRatioEnable(false);
            setProbeDemagVisible(false);
            readProbeCal();
        } else if (this.probeType == ServiceEnum.ProbeType.Probe_A) {
            setImpedanceEnable(false);
            setProbeRatioEnable(false);
            setProbeDemagVisible(true);
            readProbeCal();
        } else if (this.probeType == ServiceEnum.ProbeType.Probe_BNC) {
            if (this.probeInsert) {
                setImpedanceEnable(false);
            }
            setProbeCurrentBias(0L);
            setProbeBias(0L);
        }
    }

    @Bindable
    public final boolean getProbeCal() {
        return this.probeCal;
    }

    public final void setProbeCal(boolean z) {
        log("CHAN" + this.chan.value1 + ", probeCal", Boolean.valueOf(this.probeCal), Boolean.valueOf(z));
        this.probeCal = z;
        notifyPropertyChanged(656);
    }

    @Bindable
    public final boolean getProbeInsert() {
        return this.probeInsert;
    }

    public final void setProbeInsert(boolean z) {
        log("CHAN" + this.chan.value1 + ", probeInsert", Boolean.valueOf(this.probeInsert), Boolean.valueOf(z));
        this.probeInsert = z;
        notifyPropertyChanged(662);
        if (this.probeInsert) {
            return;
        }
        setProbeRatioEnable(true);
        setImpedanceEnable(true);
        setProbeDemagVisible(false);
        setProbeCal(false);
    }

    @Bindable
    public final boolean getProbeRatioEnable() {
        return this.probeRatioEnable;
    }

    public final void setProbeRatioEnable(boolean z) {
        log("CHAN" + this.chan.value1 + ", probeRatioEnable", Boolean.valueOf(this.probeRatioEnable), Boolean.valueOf(z));
        this.probeRatioEnable = z;
        notifyPropertyChanged(666);
    }

    @Bindable
    public final boolean getImpedanceEnable() {
        return this.impedanceEnable;
    }

    public final void setImpedanceEnable(boolean z) {
        log("CHAN" + this.chan.value1 + ", impedanceEnable", Boolean.valueOf(this.impedanceEnable), Boolean.valueOf(z));
        this.impedanceEnable = z;
        notifyPropertyChanged(432);
    }

    @Bindable
    public final boolean getProbeDemagVisible() {
        return this.probeDemagVisible;
    }

    public final void setProbeDemagVisible(boolean z) {
        log("CHAN" + this.chan.value1 + ", probeDemagVisible", Boolean.valueOf(this.probeDemagVisible), Boolean.valueOf(z));
        this.probeDemagVisible = z;
        notifyPropertyChanged(660);
    }

    @Bindable
    public final long getProbeDelay() {
        return this.probeDelay;
    }

    public final void setProbeDelay(long j) {
        log("CHAN" + this.chan.value1 + ", probeDelay", Long.valueOf(this.probeDelay), Long.valueOf(j));
        this.probeDelay = j;
        notifyPropertyChanged(659);
    }

    @Bindable
    public final long getProbeBias() {
        return this.probeBias;
    }

    public final void setProbeBias(long j) {
        log("CHAN" + this.chan.value1 + ", probeBias", Long.valueOf(this.probeBias), Long.valueOf(j));
        this.probeBias = j;
        notifyPropertyChanged(655);
    }

    @Bindable
    public final long getProbeCurrentBias() {
        return this.probeCurrentBias;
    }

    public final void setProbeCurrentBias(long j) {
        log("CHAN" + this.chan.value1 + ", probeCurrentBias", Long.valueOf(this.probeCurrentBias), Long.valueOf(j));
        this.probeCurrentBias = j;
        notifyPropertyChanged(658);
    }

    @Bindable
    public final ServiceEnum.Impedance getImpedance() {
        return this.impedance;
    }

    public final void setImpedance(ServiceEnum.Impedance value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", impedance", this.impedance, value);
        this.impedance = value;
        notifyPropertyChanged(431);
    }

    @Bindable
    public final boolean getInvert() {
        return this.invert;
    }

    public final void setInvert(boolean z) {
        log("CHAN" + this.chan.value1 + ", invert", Boolean.valueOf(this.invert), Boolean.valueOf(z));
        this.invert = z;
        notifyPropertyChanged(444);
    }

    @Bindable
    public final boolean getFine() {
        return this.fine;
    }

    public final void setFine(boolean z) {
        log("CHAN" + this.chan.value1 + ", fine", Boolean.valueOf(this.fine), Boolean.valueOf(z));
        this.fine = z;
        notifyPropertyChanged(314);
    }

    @Bindable
    public final ServiceEnum.Unit getUnit() {
        return this.unit;
    }

    public final void setUnit(ServiceEnum.Unit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("CHAN" + this.chan.value1 + ", unit", this.unit, value);
        this.unit = value;
        notifyPropertyChanged(987);
        syncData(MessageID.MSG_CHAN_UNIT, this.unit);
    }

    @Bindable
    public final long getScale() {
        return this.scale;
    }

    public final void setScale(long j) {
        log("CHAN" + this.chan.value1 + ", scale", Long.valueOf(this.scale), Long.valueOf(j));
        this.scale = j;
        setRealScale(j);
        notifyPropertyChanged(774);
        syncData(MessageID.MSG_CHAN_SCALE_REAL, Long.valueOf(this.scale));
    }

    @Bindable
    public final long getRealScale() {
        return this.RealScale;
    }

    public final void setRealScale(long j) {
        this.RealScale = j;
    }

    @Bindable
    public final long getOffset() {
        return this.offset;
    }

    public final void setOffset(long j) {
        log("CHAN" + this.chan.value1 + ", offset", Long.valueOf(this.offset), Long.valueOf(j));
        this.offset = j;
        notifyPropertyChanged(565);
        syncData(MessageID.MSG_CHAN_OFFSET_REAL, Long.valueOf(this.offset));
    }

    @Bindable
    public final long getPosition() {
        return this.position;
    }

    public final void setPosition(long j) {
        log("CHAN" + this.chan.value1 + ", position", Long.valueOf(this.position), Long.valueOf(j));
        this.position = j;
        notifyPropertyChanged(646);
    }

    @Bindable
    public final long getChanDelay() {
        return this.chanDelay;
    }

    public final void setChanDelay(long j) {
        log("CHAN" + this.chan.value1 + ", chanDelay", Long.valueOf(this.chanDelay), Long.valueOf(j));
        this.chanDelay = j;
        notifyPropertyChanged(163);
    }

    @Bindable
    public final String getLabel() {
        return this.label;
    }

    public final void setLabel(String str) {
        log("CHAN" + this.chan.value1 + ", label", this.label, str);
        this.label = str;
        notifyPropertyChanged(475);
        syncData(MessageID.MSG_CHAN_LABEL_EDIT, this.label);
    }

    @Bindable
    public final boolean getShowLabel() {
        return this.showLabel;
    }

    public final void setShowLabel(boolean z) {
        log("CHAN" + this.chan.value1 + ", showLabel", Boolean.valueOf(this.showLabel), Boolean.valueOf(z));
        this.showLabel = z;
        notifyPropertyChanged(828);
        syncData(MessageID.MSG_CHAN_LABEL_SHOW, Boolean.valueOf(this.showLabel));
    }

    public final MessageAttr getScaleAttr() {
        return this.scaleAttr;
    }

    public final MessageAttr getOffsetAttr() {
        return this.offsetAttr;
    }

    public final MessageAttr getPositionAttr() {
        return this.positionAttr;
    }

    public final MessageAttr getProbeDelayAttr() {
        return this.probeDelayAttr;
    }

    public final MessageAttr getProbeBiasAttr() {
        return this.probeBiasAttr;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readStatus();
        readScale();
        readOffset();
        readPosition();
        readChanDelay();
        readInvert();
        readFine();
        readCoupling();
        readBandLimit();
        readProbeRatio();
        readProbeDelay();
        readProbeBias();
        readProbeCurrentBias();
        readUnit();
        readProbeRatioUnit();
        readImpedance();
        readLabel();
        readShowLabel();
        readAttr(MessageID.MSG_CHAN_SCALE_REAL, this.scaleAttr);
        readAttr(MessageID.MSG_CHAN_OFFSET_REAL, this.offsetAttr);
        readAttr(MessageID.MSG_CHAN_POS_REAL, this.positionAttr);
        readProbeDelayAttr();
        readProbeBiasAttr();
        readRealScale();
    }

    public final void readProbeDelayAttr() {
        readAttr(MessageID.MSG_CHAN_PROBE_DELAY, this.probeDelayAttr);
    }

    public final void readProbeBiasAttr() {
        readAttr(MessageID.MSG_CHAN_PROBE_BIAS, this.probeBiasAttr);
    }

    public final long readScale() {
        setScale(readLong(MessageID.MSG_CHAN_SCALE_REAL));
        return this.scale;
    }

    public final long readRealScale() {
        setRealScale(readLong(MessageID.MSG_CHAN_SCALE_REAL));
        return this.RealScale;
    }

    public final long readOffset() {
        setOffset(readLong(MessageID.MSG_CHAN_OFFSET_REAL));
        return this.offset;
    }

    public final long readPosition() {
        setPosition(readLong(MessageID.MSG_CHAN_POS_REAL));
        return this.position;
    }

    public final long readChanDelay() {
        setChanDelay(readLong(MessageID.MSG_CHAN_SKEW));
        return this.chanDelay;
    }

    public final ServiceEnum.enChanStatus readStatus() {
        ServiceEnum.enChanStatus enchanstatus = ServiceEnum.getenChanStatusFromValue1(readInt(MessageID.MSG_CHAN_ACTIVE));
        Intrinsics.checkNotNullExpressionValue(enchanstatus, "getenChanStatusFromValue…ssageID.MSG_CHAN_ACTIVE))");
        setStatus(enchanstatus);
        return this.status;
    }

    public final boolean readInvert() {
        setInvert(readBool(MessageID.MSG_CHAN_INVERT));
        return this.invert;
    }

    public final boolean readFine() {
        setFine(readBool(MessageID.MSG_CHAN_FINE));
        return this.fine;
    }

    public final ServiceEnum.Coupling readCoupling() {
        ServiceEnum.Coupling couplingFromValue1 = ServiceEnum.getCouplingFromValue1(readInt(MessageID.MSG_CHAN_COUP));
        Intrinsics.checkNotNullExpressionValue(couplingFromValue1, "getCouplingFromValue1(re…MessageID.MSG_CHAN_COUP))");
        setCoupling(couplingFromValue1);
        return this.coupling;
    }

    public final ServiceEnum.Bandwidth readBandLimit() {
        ServiceEnum.Bandwidth bandwidthFromValue1 = ServiceEnum.getBandwidthFromValue1(readInt(MessageID.MSG_CHAN_BWLIMIT));
        Intrinsics.checkNotNullExpressionValue(bandwidthFromValue1, "getBandwidthFromValue1(r…sageID.MSG_CHAN_BWLIMIT))");
        setBandLimit(bandwidthFromValue1);
        return this.bandLimit;
    }

    public final ServiceEnum.ProbeX readProbeRatio() {
        ServiceEnum.ProbeX probeXFromValue1 = ServiceEnum.getProbeXFromValue1(readInt(MessageID.MSG_CHAN_PROBE));
        Intrinsics.checkNotNullExpressionValue(probeXFromValue1, "getProbeXFromValue1(read…essageID.MSG_CHAN_PROBE))");
        setProbeRatio(probeXFromValue1);
        return this.probeRatio;
    }

    public final String readProbeDetail() {
        setProbeDetail(readStr(MessageID.MSG_CHAN_PROBE_DETAIL));
        return this.probeDetail;
    }

    public final ServiceEnum.ProbeType readProbeType() {
        ServiceEnum.ProbeType probeTypeFromValue1 = ServiceEnum.getProbeTypeFromValue1(readInt(MessageID.MSG_PROBE_TYPE));
        Intrinsics.checkNotNullExpressionValue(probeTypeFromValue1, "getProbeTypeFromValue1(r…essageID.MSG_PROBE_TYPE))");
        setProbeType(probeTypeFromValue1);
        return this.probeType;
    }

    public final boolean readProbeCal() {
        setProbeCal(readBool(MessageID.MSG_CHAN_PROBE_CAL));
        return this.probeCal;
    }

    public final boolean readProbeInsert() {
        setProbeInsert(readBool(MessageID.MSG_PROBE_INSERT));
        return this.probeInsert;
    }

    public final long readProbeDelay() {
        setProbeDelay(readLong(MessageID.MSG_CHAN_PROBE_DELAY));
        return this.probeDelay;
    }

    public final long readProbeBias() {
        setProbeBias(readLong(MessageID.MSG_CHAN_PROBE_BIAS));
        return this.probeBias;
    }

    public final long readProbeCurrentBias() {
        setProbeCurrentBias(readLong(MessageID.MSG_CHAN_PROBE_BIAS));
        return this.probeCurrentBias;
    }

    public final ServiceEnum.Unit readUnit() {
        ServiceEnum.Unit unitFromValue1 = ServiceEnum.getUnitFromValue1(readInt(MessageID.MSG_CHAN_UNIT));
        Intrinsics.checkNotNullExpressionValue(unitFromValue1, "getUnitFromValue1(readIn…MessageID.MSG_CHAN_UNIT))");
        setUnit(unitFromValue1);
        readProbeRatioUnit();
        return this.unit;
    }

    public final ServiceEnum.Unit readProbeRatioUnit() {
        ServiceEnum.Unit unitFromValue1 = ServiceEnum.getUnitFromValue1(readInt(MessageID.MSG_CHAN_PROBE_UNIT));
        Intrinsics.checkNotNullExpressionValue(unitFromValue1, "getUnitFromValue1(readIn…eID.MSG_CHAN_PROBE_UNIT))");
        setProbeRatioUnit(unitFromValue1);
        return this.probeRatioUnit;
    }

    public final ServiceEnum.Impedance readImpedance() {
        ServiceEnum.Impedance impedanceFromValue1 = ServiceEnum.getImpedanceFromValue1(readInt(MessageID.MSG_CHAN_IMPEDANCE));
        Intrinsics.checkNotNullExpressionValue(impedanceFromValue1, "ServiceEnum.getImpedance…geID.MSG_CHAN_IMPEDANCE))");
        setImpedance(impedanceFromValue1);
        return this.impedance;
    }

    public final String readLabel() {
        setLabel(readStr(MessageID.MSG_CHAN_LABEL_EDIT));
        return this.label;
    }

    public final boolean readShowLabel() {
        setShowLabel(readBool(MessageID.MSG_CHAN_LABEL_SHOW));
        return this.showLabel;
    }

    public final void saveStatus(ServiceEnum.enChanStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        setStatus(status);
        saveInt(MessageID.MSG_CHAN_ACTIVE, status.value1);
    }

    public final void saveInvert(boolean z) {
        setInvert(z);
        saveBool(MessageID.MSG_CHAN_INVERT, z);
    }

    public final void saveImpedance(ServiceEnum.Impedance impedance) {
        Intrinsics.checkNotNullParameter(impedance, "impedance");
        setImpedance(impedance);
        saveInt(MessageID.MSG_CHAN_IMPEDANCE, impedance.value1);
        if (impedance != ServiceEnum.Impedance.IMP_50 || this.coupling == ServiceEnum.Coupling.DC) {
            return;
        }
        saveCoupling(ServiceEnum.Coupling.DC);
    }

    public final void saveFine(boolean z) {
        setFine(z);
        saveBool(MessageID.MSG_CHAN_FINE, z);
    }

    public final void saveOffset(long j) {
        if (this.status == ServiceEnum.enChanStatus.CHAN_OFF) {
            return;
        }
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.offsetAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        long longValue = ((Long) checkAttrRang).longValue();
        long j2 = longValue - this.offset;
        setOffset(longValue);
        API.getInstance().UI_PostInt64(40, MessageID.MSG_PLOT_DRAG_VERT, j2);
    }

    public final void moveOffset(long j) {
        if (this.status == ServiceEnum.enChanStatus.CHAN_OFF) {
            return;
        }
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.offsetAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        long longValue = ((Long) checkAttrRang).longValue();
        long j2 = longValue - this.offset;
        setOffset(longValue);
        API.getInstance().UI_PostInt32Int64(40, MessageID.MSG_PLOT_DRAG_CHAN, this.chan.value1, j2);
    }

    public final void saveOffsetReal(long j) {
        if (this.status == ServiceEnum.enChanStatus.CHAN_OFF) {
            return;
        }
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.offsetAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        long longValue = ((Long) checkAttrRang).longValue();
        setOffset(longValue);
        saveLong(MessageID.MSG_CHAN_OFFSET_REAL, longValue);
    }

    public final void savePosition(long j) {
        if (this.status == ServiceEnum.enChanStatus.CHAN_OFF) {
            return;
        }
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.positionAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setPosition(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_CHAN_POS_REAL, j);
    }

    public final void saveChanDelay(long j) {
        if (this.status == ServiceEnum.enChanStatus.CHAN_OFF) {
            return;
        }
        setChanDelay(j);
        saveLong(MessageID.MSG_CHAN_SKEW, j);
    }

    public final void saveScale(long j) {
        if (this.status == ServiceEnum.enChanStatus.CHAN_OFF) {
            return;
        }
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.scaleAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setScale(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_CHAN_SCALE_REAL, j);
    }

    public final void saveCoupling(ServiceEnum.Coupling coupling) {
        Intrinsics.checkNotNullParameter(coupling, "coupling");
        setCoupling(coupling);
        saveInt(MessageID.MSG_CHAN_COUP, coupling.value1);
    }

    public final void saveBandwidth(ServiceEnum.Bandwidth bandLimit) {
        Intrinsics.checkNotNullParameter(bandLimit, "bandLimit");
        setBandLimit(bandLimit);
        saveInt(MessageID.MSG_CHAN_BWLIMIT, bandLimit.value1);
    }

    public final void saveProbeRatio(ServiceEnum.ProbeX probeRatio) {
        Intrinsics.checkNotNullParameter(probeRatio, "probeRatio");
        setProbeRatio(probeRatio);
        saveInt(MessageID.MSG_CHAN_PROBE, probeRatio.value1);
    }

    public final void saveProbeDelay(long j) {
        setProbeDelay(j);
        saveLong(MessageID.MSG_CHAN_PROBE_DELAY, j);
    }

    public final void saveProbeBias(long j) {
        setProbeBias(j);
        saveLong(MessageID.MSG_CHAN_PROBE_BIAS, j);
    }

    public final void saveProbeCurrentBias(long j) {
        setProbeCurrentBias(j);
        saveLong(MessageID.MSG_CHAN_PROBE_BIAS, j);
    }

    public final void saveUnit(ServiceEnum.Unit unit) {
        ServiceEnum.Unit unit2;
        Intrinsics.checkNotNullParameter(unit, "unit");
        setUnit(unit);
        saveInt(MessageID.MSG_CHAN_UNIT, unit.value1);
        if (unit == ServiceEnum.Unit.Unit_A) {
            unit2 = ServiceEnum.Unit.Unit_VdivA;
        } else {
            unit2 = ServiceEnum.Unit.Unit_X;
        }
        setProbeRatioUnit(unit2);
    }

    public final void saveProbeRatioUnit(ServiceEnum.Unit probeRatioUnit) {
        Intrinsics.checkNotNullParameter(probeRatioUnit, "probeRatioUnit");
        setProbeRatioUnit(probeRatioUnit);
        saveInt(MessageID.MSG_CHAN_PROBE_UNIT, probeRatioUnit.value1);
    }

    public final void saveLabel(String str) {
        setLabel(str);
        saveStr(MessageID.MSG_CHAN_LABEL_EDIT, str);
    }

    public final void saveShowLabel(boolean z) {
        setShowLabel(z);
        saveBool(MessageID.MSG_CHAN_LABEL_SHOW, z);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        long j;
        ServiceEnum.Impedance impedance;
        ServiceEnum.Coupling coupling;
        ServiceEnum.Bandwidth bandwidth;
        ServiceEnum.Unit unit;
        ServiceEnum.ProbeX probeX;
        ServiceEnum.Unit unit2;
        long j2;
        super.reset();
        j = VerticalParamKt.DEFAULT_SCALE;
        setScale(j);
        setOffset(0L);
        setPosition(0L);
        impedance = VerticalParamKt.DEFAULT_IMPEDANCE;
        setImpedance(impedance);
        coupling = VerticalParamKt.DEFAULT_COUPING;
        setCoupling(coupling);
        setInvert(false);
        bandwidth = VerticalParamKt.DEFAULT_BANDWIDTH;
        setBandLimit(bandwidth);
        unit = VerticalParamKt.DEFAULT_UNIT;
        setUnit(unit);
        setLabel("CH" + ((getServiceId() - 1) + 1));
        setShowLabel(false);
        setFine(false);
        probeX = VerticalParamKt.DEFAULT_PROBE_RATIO;
        setProbeRatio(probeX);
        unit2 = VerticalParamKt.DEFAULT_PROBE_RATIO_UNIT;
        setProbeRatioUnit(unit2);
        j2 = VerticalParamKt.DEFAULT_SCALE;
        setRealScale(j2);
    }

    public final long getScaleValue() {
        return readLong(MessageID.MSG_CHAN_SCALE_VALUE);
    }

    public final void scaleLarger(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = ScaleNumUtil.getPlusNum(this.scale, 1.0f);
            if (this.fine) {
                j = this.scale + (j / 100);
            }
        }
        if (j <= this.scaleAttr.getMaxLongValue()) {
            saveScale(j);
        } else {
            saveScale(this.scaleAttr.getMaxLongValue());
        }
    }

    public final void scaleSmaller(int i) {
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = ScaleNumUtil.getMinusNum(this.scale, 1.0f);
            if (this.fine) {
                j = this.scale - (j / 100);
            }
        }
        if (j >= this.scaleAttr.getMinLongValue()) {
            saveScale(j);
        } else {
            saveScale(this.scaleAttr.getMinLongValue());
        }
    }

    public final long offsetLarger(int i) {
        if (!this.enableToSetOffset) {
            return this.offset;
        }
        return this.offset + OffsetUtil.getVerticalOffsetStep(this.scale, i);
    }

    public final long offsetSmaller(int i) {
        if (!this.enableToSetOffset) {
            return this.offset;
        }
        return this.offset - OffsetUtil.getVerticalOffsetStep(this.scale, i);
    }

    public final long positionLarger(int i) {
        if (!this.enableToSetOffset) {
            return this.position;
        }
        return this.position + OffsetUtil.getVerticalOffsetStep(this.scale, i);
    }

    public final long positionSmaller(int i) {
        if (!this.enableToSetOffset) {
            return this.position;
        }
        return this.position - OffsetUtil.getVerticalOffsetStep(this.scale, i);
    }

    public final void resetOffset() {
        saveOffset(0L);
    }

    public final void toggleFine() {
        saveFine(!this.fine);
    }

    public final void probeCal() {
        saveInt(MessageID.MSG_CHAN_PROBE_CAL, 0);
    }

    public final void probeDemag() {
        saveInt(MessageID.MSG_CHAN_PROBE_DEMAG, 0);
    }

    public final void turnActive() {
        saveStatus(ServiceEnum.enChanStatus.CHAN_ACTIVE);
    }

    public final void turnOff() {
        saveStatus(ServiceEnum.enChanStatus.CHAN_OFF);
    }

    public final void toggleStatus() {
        if (this.status == ServiceEnum.enChanStatus.CHAN_OFF || this.status == ServiceEnum.enChanStatus.CHAN_ON) {
            turnActive();
        } else if (this.status == ServiceEnum.enChanStatus.CHAN_ACTIVE) {
            turnOff();
        }
        PopupViewManager popupViewManager = PopupViewManager.getInstance();
        Intrinsics.checkNotNullExpressionValue(popupViewManager, "PopupViewManager.getInstance()");
        Class<? extends BasePopupView> showingClass = popupViewManager.getShowingClass();
        if (showingClass != null) {
            PopupViewManager.getInstance().showCurrentWindowLight(PopupViewManager.getInstance().get(showingClass));
        }
    }
}
