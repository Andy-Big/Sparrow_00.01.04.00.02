package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.views.la.LaLienView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
/* compiled from: LaParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\bs\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b>\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010J\u0007\u0010\u009d\u0001\u001a\u00020\u0004J\n\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u009f\u0001J\u0007\u0010 \u0001\u001a\u00020\u0004J\u0007\u0010¡\u0001\u001a\u00020\u0004J\b\u0010¢\u0001\u001a\u00030£\u0001J\n\u0010¤\u0001\u001a\u00030£\u0001H\u0016J\u0007\u0010¥\u0001\u001a\u00020\u0011J\u0007\u0010¦\u0001\u001a\u00020\u0004J\u0007\u0010§\u0001\u001a\u00020\u001aJ\u0007\u0010¨\u0001\u001a\u00020\nJ\u0007\u0010©\u0001\u001a\u00020\u0004J\u0007\u0010ª\u0001\u001a\u00020\u001aJ\u0007\u0010«\u0001\u001a\u00020\nJ\u0007\u0010¬\u0001\u001a\u00020\u0011J\u0007\u0010\u00ad\u0001\u001a\u00020\u0011J\u0007\u0010®\u0001\u001a\u00020\u0011J\u0007\u0010¯\u0001\u001a\u00020\u0011J\u0007\u0010°\u0001\u001a\u00020\nJ\u0007\u0010±\u0001\u001a\u00020\nJ\u0007\u0010²\u0001\u001a\u00020\u0004J\b\u0010³\u0001\u001a\u00030£\u0001J\u0007\u0010´\u0001\u001a\u00020\u0011J\b\u0010µ\u0001\u001a\u00030£\u0001J\b\u0010¶\u0001\u001a\u00030£\u0001J\b\u0010·\u0001\u001a\u00030£\u0001J\b\u0010¸\u0001\u001a\u00030£\u0001J\u0007\u0010¹\u0001\u001a\u00020\u0011J\b\u0010º\u0001\u001a\u00030£\u0001J\u0007\u0010»\u0001\u001a\u00020\nJ\u0007\u0010¼\u0001\u001a\u00020\u0011J\u0007\u0010½\u0001\u001a\u00020\u0011J\u0007\u0010¾\u0001\u001a\u00020\u0011J\u0007\u0010¿\u0001\u001a\u00020\u0004J\u0007\u0010À\u0001\u001a\u00020\u0004J\u0007\u0010Á\u0001\u001a\u00020\u0011J\u0007\u0010Â\u0001\u001a\u00020\u0011J\n\u0010Ã\u0001\u001a\u00030£\u0001H\u0016J\u0010\u0010Ä\u0001\u001a\u00030£\u00012\u0006\u0010s\u001a\u00020\u0011J\u0010\u0010Å\u0001\u001a\u00030£\u00012\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010Æ\u0001\u001a\u00030£\u00012\u0006\u0010\u0017\u001a\u00020\u0004J\u0010\u0010Ç\u0001\u001a\u00030£\u00012\u0006\u0010&\u001a\u00020\u0004J\u0010\u0010È\u0001\u001a\u00030£\u00012\u0006\u0010X\u001a\u00020\u0011J\u0010\u0010É\u0001\u001a\u00030£\u00012\u0006\u0010[\u001a\u00020\u0011J\u0010\u0010Ê\u0001\u001a\u00030£\u00012\u0006\u0010^\u001a\u00020\u0011J\u0010\u0010Ë\u0001\u001a\u00030£\u00012\u0006\u0010a\u001a\u00020\u0011J\u0010\u0010Ì\u0001\u001a\u00030£\u00012\u0006\u0010A\u001a\u00020\nJ\u0011\u0010Í\u0001\u001a\u00030£\u00012\u0007\u0010¢\u0001\u001a\u00020\u0004J\u0010\u0010Î\u0001\u001a\u00030£\u00012\u0006\u0010m\u001a\u00020\u0004J\u0010\u0010Ï\u0001\u001a\u00030£\u00012\u0006\u0010g\u001a\u00020\u0011J\u0010\u0010Ð\u0001\u001a\u00030£\u00012\u0006\u0010v\u001a\u00020\u0011J\u0011\u0010Ñ\u0001\u001a\u00030£\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u0011J\u0011\u0010Ò\u0001\u001a\u00030£\u00012\u0007\u0010\u0085\u0001\u001a\u00020\u0011J\u0011\u0010Ó\u0001\u001a\u00030£\u00012\u0007\u0010\u008e\u0001\u001a\u00020\u0004J\u0011\u0010Ô\u0001\u001a\u00030£\u00012\u0007\u0010Õ\u0001\u001a\u00020\u0011J\u0011\u0010Ö\u0001\u001a\u00030£\u00012\u0007\u0010Õ\u0001\u001a\u00020\u0011J\u0010\u0010×\u0001\u001a\u00030£\u00012\u0006\u0010\u001b\u001a\u00020\u001aJ\u0010\u0010Ø\u0001\u001a\u00030£\u00012\u0006\u0010)\u001a\u00020\u001aJ\u0010\u0010Ù\u0001\u001a\u00030£\u00012\u0006\u0010p\u001a\u00020\u0011J\u0010\u0010Ú\u0001\u001a\u00030£\u00012\u0006\u0010J\u001a\u00020\u0004J\u0010\u0010Û\u0001\u001a\u00030£\u00012\u0006\u0010d\u001a\u00020\u0011J\u0010\u0010Ü\u0001\u001a\u00030£\u00012\u0006\u0010j\u001a\u00020\u0011J\u0011\u0010Ý\u0001\u001a\u00030£\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u0011J\u0011\u0010Þ\u0001\u001a\u00030£\u00012\u0007\u0010\u0091\u0001\u001a\u00020\u0004J\u0010\u0010ß\u0001\u001a\u00030£\u00012\u0006\u0010U\u001a\u00020\u0011J\u0010\u0010à\u0001\u001a\u00030£\u00012\u0006\u0010|\u001a\u00020\u0011R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR2\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR&\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R&\u0010&\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0007\"\u0004\b(\u0010\tR&\u0010)\u001a\u00020\u001a2\u0006\u0010\u0003\u001a\u00020\u001a8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u001d\"\u0004\b+\u0010\u001fR\u001a\u0010,\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010#\"\u0004\b.\u0010%R \u0010/\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0014\"\u0004\b1\u0010\u0016R \u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R \u00105\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0014\"\u0004\b7\u0010\u0016R \u00108\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0014\"\u0004\b:\u0010\u0016R2\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010\u0016R&\u0010>\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR&\u0010A\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000fR&\u0010D\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000fR2\u0010G\u001a\b\u0012\u0004\u0012\u00020\n0\u00102\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R&\u0010J\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0007\"\u0004\bL\u0010\tR\u001a\u0010M\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR&\u0010R\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0007\"\u0004\bT\u0010\tR&\u0010U\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010O\"\u0004\bW\u0010QR&\u0010X\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010O\"\u0004\bZ\u0010QR&\u0010[\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010O\"\u0004\b]\u0010QR&\u0010^\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010O\"\u0004\b`\u0010QR&\u0010a\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010O\"\u0004\bc\u0010QR&\u0010d\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010O\"\u0004\bf\u0010QR&\u0010g\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010O\"\u0004\bi\u0010QR&\u0010j\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010O\"\u0004\bl\u0010QR&\u0010m\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\u0007\"\u0004\bo\u0010\tR&\u0010p\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010O\"\u0004\br\u0010QR&\u0010s\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010O\"\u0004\bu\u0010QR&\u0010v\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010O\"\u0004\bx\u0010QR&\u0010y\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\r\"\u0004\b{\u0010\u000fR&\u0010|\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010O\"\u0004\b~\u0010QR(\u0010\u007f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\n8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\r\"\u0005\b\u0081\u0001\u0010\u000fR)\u0010\u0082\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010O\"\u0005\b\u0084\u0001\u0010QR)\u0010\u0085\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010O\"\u0005\b\u0087\u0001\u0010QR)\u0010\u0088\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010O\"\u0005\b\u008a\u0001\u0010QR)\u0010\u008b\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010O\"\u0005\b\u008d\u0001\u0010QR)\u0010\u008e\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010\u0007\"\u0005\b\u0090\u0001\u0010\tR)\u0010\u0091\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010\u0007\"\u0005\b\u0093\u0001\u0010\tR%\u0010\u0094\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0095\u0001X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0097\u0001\u0010\u0014\"\u0005\b\u0098\u0001\u0010\u0016R'\u0010\u0099\u0001\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u0011@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009a\u0001\u0010O\"\u0005\b\u009b\u0001\u0010Q¨\u0006á\u0001"}, d2 = {"Lcom/rigol/scope/data/LaParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "calibration_Enable", "getCalibration_Enable", "()Z", "setCalibration_Enable", "(Z)V", "", "chanState", "getChanState", "()Ljava/lang/String;", "setChanState", "(Ljava/lang/String;)V", "", "", "chanStateList", "getChanStateList", "()Ljava/util/List;", "setChanStateList", "(Ljava/util/List;)V", "d0TOd7", "getD0TOd7", "setD0TOd7", "", "d0TOd7_threshold_", "getD0TOd7_threshold_", "()J", "setD0TOd7_threshold_", "(J)V", "d0tod7Attr", "Lcom/rigol/scope/cil/MessageAttr;", "getD0tod7Attr", "()Lcom/rigol/scope/cil/MessageAttr;", "setD0tod7Attr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "d8TOd15", "getD8TOd15", "setD8TOd15", "d8TOd15_threshold_", "getD8TOd15_threshold_", "setD8TOd15_threshold_", "d8tod15Attr", "getD8tod15Attr", "setD8tod15Attr", "glist1", "getGlist1", "setGlist1", "glist2", "getGlist2", "setGlist2", "glist3", "getGlist3", "setGlist3", "glist4", "getGlist4", "setGlist4", "glistNow", "getGlistNow", "setGlistNow", "groupChanState", "getGroupChanState", "setGroupChanState", "inputLabel", "getInputLabel", "setInputLabel", "inputLabellist", "getInputLabellist", "setInputLabellist", "inputLabellist64", "getInputLabellist64", "setInputLabellist64", "laEnable", "getLaEnable", "setLaEnable", "laProportion", "getLaProportion", "()I", "setLaProportion", "(I)V", "la_calibration_probe", "getLa_calibration_probe", "setLa_calibration_probe", "la_edge_color", "getLa_edge_color", "setLa_edge_color", "la_group1", "getLa_group1", "setLa_group1", "la_group2", "getLa_group2", "setLa_group2", "la_group3", "getLa_group3", "setLa_group3", "la_group4", "getLa_group4", "setLa_group4", "la_high_color", "getLa_high_color", "setLa_high_color", "la_label_view_select", "getLa_label_view_select", "setLa_label_view_select", "la_label_view_select_chan", "getLa_label_view_select_chan", "setLa_label_view_select_chan", "la_labels_en", "getLa_labels_en", "setLa_labels_en", "la_low_color", "getLa_low_color", "setLa_low_color", "la_order", "getLa_order", "setLa_order", "la_position", "getLa_position", "setLa_position", "la_probe_cal_data", "getLa_probe_cal_data", "setLa_probe_cal_data", "la_probe_cal_pro", "getLa_probe_cal_pro", "setLa_probe_cal_pro", "la_probe_cal_prostr", "getLa_probe_cal_prostr", "setLa_probe_cal_prostr", "la_select_position", "getLa_select_position", "setLa_select_position", "la_size_", "getLa_size_", "setLa_size_", "la_source", "getLa_source", "setLa_source", "la_spacing_", "getLa_spacing_", "setLa_spacing_", "label", "getLabel", "setLabel", "labelGroup", "getLabelGroup", "setLabelGroup", "list_lsview", "", "Lcom/rigol/scope/views/la/LaLienView;", "getList_lsview", "setList_lsview", "sourceGroupindex", "getSourceGroupindex", "setSourceGroupindex", "getGrouplist", "getSizeNow", "getUnit", "Lcom/rigol/scope/cil/ServiceEnum$Unit;", "getd0toD7", "getd8toD15", "groupCancel", "", "readAll", "readAutoOrder", "readD0TOd7", "readD0TOd7Threshold", "readD0ToD7ChanState", "readD8TOd15", "readD8TOd15Threshold", "readD8ToD15ChanState", "readGroup1", "readGroup2", "readGroup3", "readGroup4", "readGroupChanState", "readInputLabel", "readLaEnable", "readLaLabelEn", "readLaLabelViewSelect", "readLaPosition", "readLaProbeCalPro", "readLaProbeCalProString", "readLaSelectPosition", "readLaSize", "readProbe", "readinputLabellist", "readlaHighColor", "readlaSelectChan", "readlaSource", "readlabel", "readlabelGroup", "readlaedgeColor", "readlalowColor", "reset", "saveAutoOrder", "saveCalibrationEnable", "saveD0TOd7", "saveD8TOd15", "saveGroup1", "saveGroup2", "saveGroup3", "saveGroup4", "saveInputLabel", "saveLaGroupCancel", "saveLaLabelEn", "saveLaLabelViewSelect", "saveLaPosition", "saveLaSelectPosition", "saveLaSize", "saveLabel", "saveSelectAddDX", "chars", "saveSelectChar", "savedD0TOd7Threshold", "savedD8TOd15Threshold", "savelLoweColor", "savelaEnable", "savelaHighColor", "savelaSelectChan", "savelaSource", "savelabelGroup", "savelaedgeColor", "setLaProbeCalPros", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class LaParam extends BaseParam {
    private boolean calibration_Enable;
    private String chanState;
    private List<Integer> chanStateList;
    private boolean d0TOd7;
    private long d0TOd7_threshold_;
    private MessageAttr d0tod7Attr;
    private boolean d8TOd15;
    private long d8TOd15_threshold_;
    private MessageAttr d8tod15Attr;
    private List<Integer> glist1;
    private List<Integer> glist2;
    private List<Integer> glist3;
    private List<Integer> glist4;
    private List<Integer> glistNow;
    private String groupChanState;
    private String inputLabel;
    private String inputLabellist;
    private List<String> inputLabellist64;
    private boolean laEnable;
    private int laProportion;
    private boolean la_calibration_probe;
    private int la_edge_color;
    private int la_group1;
    private int la_group2;
    private int la_group3;
    private int la_group4;
    private int la_high_color;
    private int la_label_view_select;
    private int la_label_view_select_chan;
    private boolean la_labels_en;
    private int la_low_color;
    private int la_order;
    private int la_position;
    private String la_probe_cal_data;
    private int la_probe_cal_pro;
    private String la_probe_cal_prostr;
    private int la_select_position;
    private int la_size_;
    private int la_source;
    private int la_spacing_;
    private boolean label;
    private boolean labelGroup;
    private List<LaLienView> list_lsview;
    private int sourceGroupindex;

    public LaParam() {
        super(60);
        this.list_lsview = new ArrayList();
        this.d0tod7Attr = new MessageAttr();
        this.d8tod15Attr = new MessageAttr();
        this.laProportion = 26;
        this.glist1 = CollectionsKt.mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.glist2 = CollectionsKt.mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.glist3 = CollectionsKt.mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.glist4 = CollectionsKt.mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.glistNow = CollectionsKt.mutableListOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        this.la_spacing_ = 35;
        this.labelGroup = true;
        this.inputLabel = "";
        this.inputLabellist = "";
        this.inputLabellist64 = new ArrayList();
        this.chanState = "";
        this.chanStateList = new ArrayList();
        this.groupChanState = "";
        this.la_labels_en = true;
        this.la_probe_cal_prostr = "";
        this.la_probe_cal_data = "";
    }

    public final List<LaLienView> getList_lsview() {
        return this.list_lsview;
    }

    public final void setList_lsview(List<LaLienView> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.list_lsview = list;
    }

    public final MessageAttr getD0tod7Attr() {
        return this.d0tod7Attr;
    }

    public final void setD0tod7Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.d0tod7Attr = messageAttr;
    }

    public final MessageAttr getD8tod15Attr() {
        return this.d8tod15Attr;
    }

    public final void setD8tod15Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.d8tod15Attr = messageAttr;
    }

    public final int getSourceGroupindex() {
        return this.sourceGroupindex;
    }

    public final void setSourceGroupindex(int i) {
        log("chNum", Integer.valueOf(this.sourceGroupindex), Integer.valueOf(i));
        this.sourceGroupindex = i;
    }

    public final int getLaProportion() {
        return this.laProportion;
    }

    public final void setLaProportion(int i) {
        this.laProportion = i;
    }

    public final List<Integer> getGlist1() {
        return this.glist1;
    }

    public final void setGlist1(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.glist1 = list;
    }

    public final List<Integer> getGlist2() {
        return this.glist2;
    }

    public final void setGlist2(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.glist2 = list;
    }

    public final List<Integer> getGlist3() {
        return this.glist3;
    }

    public final void setGlist3(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.glist3 = list;
    }

    public final List<Integer> getGlist4() {
        return this.glist4;
    }

    public final void setGlist4(List<Integer> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.glist4 = list;
    }

    @Bindable
    public final List<Integer> getGlistNow() {
        return this.glistNow;
    }

    public final void setGlistNow(List<Integer> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.glistNow, value);
        this.glistNow = value;
        notifyPropertyChanged(355);
    }

    @Bindable
    public final boolean getLa_calibration_probe() {
        return this.la_calibration_probe;
    }

    public final void setLa_calibration_probe(boolean z) {
        log("chNum", Boolean.valueOf(this.la_calibration_probe), Boolean.valueOf(z));
        this.la_calibration_probe = z;
        notifyPropertyChanged(455);
    }

    @Bindable
    public final boolean getD0TOd7() {
        return this.d0TOd7;
    }

    public final void setD0TOd7(boolean z) {
        log("chNum", Boolean.valueOf(this.d0TOd7), Boolean.valueOf(z));
        this.d0TOd7 = z;
        notifyPropertyChanged(209);
    }

    @Bindable
    public final boolean getD8TOd15() {
        return this.d8TOd15;
    }

    public final void setD8TOd15(boolean z) {
        log("chNum", Boolean.valueOf(this.d8TOd15), Boolean.valueOf(z));
        this.d8TOd15 = z;
        notifyPropertyChanged(211);
    }

    @Bindable
    public final long getD8TOd15_threshold_() {
        return this.d8TOd15_threshold_;
    }

    public final void setD8TOd15_threshold_(long j) {
        log("chNum", Long.valueOf(this.d8TOd15_threshold_), Long.valueOf(j));
        this.d8TOd15_threshold_ = j;
        notifyPropertyChanged(212);
    }

    @Bindable
    public final long getD0TOd7_threshold_() {
        return this.d0TOd7_threshold_;
    }

    public final void setD0TOd7_threshold_(long j) {
        log("chNum", Long.valueOf(this.d0TOd7_threshold_), Long.valueOf(j));
        this.d0TOd7_threshold_ = j;
        notifyPropertyChanged(210);
    }

    @Bindable
    public final int getLa_spacing_() {
        return this.la_spacing_;
    }

    public final void setLa_spacing_(int i) {
        log("chNum", Integer.valueOf(this.la_spacing_), Integer.valueOf(i));
        this.la_spacing_ = i;
    }

    @Bindable
    public final int getLa_size_() {
        return this.la_size_;
    }

    public final void setLa_size_(int i) {
        log("chNum", Integer.valueOf(this.la_size_), Integer.valueOf(i));
        this.la_size_ = i;
        notifyPropertyChanged(472);
    }

    @Bindable
    public final int getLa_source() {
        return this.la_source;
    }

    public final void setLa_source(int i) {
        log("chNum", Integer.valueOf(this.la_source), Integer.valueOf(i));
        this.la_source = i;
        notifyPropertyChanged(473);
    }

    @Bindable
    public final boolean getLabel() {
        return this.label;
    }

    public final void setLabel(boolean z) {
        log("chNum", Boolean.valueOf(this.label), Boolean.valueOf(z));
        this.label = z;
        notifyPropertyChanged(475);
    }

    @Bindable
    public final boolean getLabelGroup() {
        return this.labelGroup;
    }

    public final void setLabelGroup(boolean z) {
        log("chNum", Boolean.valueOf(this.labelGroup), Boolean.valueOf(z));
        this.labelGroup = z;
        notifyPropertyChanged(476);
    }

    @Bindable
    public final boolean getLaEnable() {
        return this.laEnable;
    }

    public final void setLaEnable(boolean z) {
        log("chNum", Boolean.valueOf(this.laEnable), Boolean.valueOf(z));
        this.laEnable = z;
        notifyPropertyChanged(453);
    }

    @Bindable
    public final boolean getCalibration_Enable() {
        return this.calibration_Enable;
    }

    public final void setCalibration_Enable(boolean z) {
        this.calibration_Enable = z;
        notifyPropertyChanged(453);
    }

    @Bindable
    public final int getLa_group1() {
        return this.la_group1;
    }

    public final void setLa_group1(int i) {
        log("chNum", Integer.valueOf(this.la_group1), Integer.valueOf(i));
        this.la_group1 = i;
        notifyPropertyChanged(457);
    }

    @Bindable
    public final int getLa_group2() {
        return this.la_group2;
    }

    public final void setLa_group2(int i) {
        log("chNum", Integer.valueOf(this.la_group2), Integer.valueOf(i));
        this.la_group2 = i;
        notifyPropertyChanged(458);
    }

    @Bindable
    public final int getLa_group3() {
        return this.la_group3;
    }

    public final void setLa_group3(int i) {
        log("chNum", Integer.valueOf(this.la_group3), Integer.valueOf(i));
        this.la_group3 = i;
        notifyPropertyChanged(458);
    }

    @Bindable
    public final int getLa_group4() {
        return this.la_group4;
    }

    public final void setLa_group4(int i) {
        log("chNum", Integer.valueOf(this.la_group4), Integer.valueOf(i));
        this.la_group4 = i;
        notifyPropertyChanged(460);
    }

    @Bindable
    public final int getLa_high_color() {
        return this.la_high_color;
    }

    public final void setLa_high_color(int i) {
        log("chNum", Integer.valueOf(this.la_high_color), Integer.valueOf(i));
        this.la_high_color = i;
        notifyPropertyChanged(461);
    }

    @Bindable
    public final int getLa_edge_color() {
        return this.la_edge_color;
    }

    public final void setLa_edge_color(int i) {
        log("chNum", Integer.valueOf(this.la_edge_color), Integer.valueOf(i));
        this.la_edge_color = i;
        notifyPropertyChanged(456);
    }

    @Bindable
    public final int getLa_low_color() {
        return this.la_low_color;
    }

    public final void setLa_low_color(int i) {
        log("chNum", Integer.valueOf(this.la_low_color), Integer.valueOf(i));
        this.la_low_color = i;
        notifyPropertyChanged(465);
    }

    @Bindable
    public final int getLa_order() {
        return this.la_order;
    }

    public final void setLa_order(int i) {
        log("chNum", Integer.valueOf(this.la_order), Integer.valueOf(i));
        this.la_order = i;
        notifyPropertyChanged(466);
    }

    @Bindable
    public final int getLa_label_view_select() {
        return this.la_label_view_select;
    }

    public final void setLa_label_view_select(int i) {
        log("chNum", Integer.valueOf(this.la_label_view_select), Integer.valueOf(i));
        this.la_label_view_select = i;
        notifyPropertyChanged(466);
    }

    @Bindable
    public final int getLa_label_view_select_chan() {
        return this.la_label_view_select_chan;
    }

    public final void setLa_label_view_select_chan(int i) {
        log("chNum", Integer.valueOf(this.la_label_view_select_chan), Integer.valueOf(i));
        this.la_label_view_select_chan = i;
        notifyPropertyChanged(466);
    }

    @Bindable
    public final String getInputLabel() {
        return this.inputLabel;
    }

    public final void setInputLabel(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.inputLabel, value);
        this.inputLabel = value;
        notifyPropertyChanged(434);
    }

    @Bindable
    public final String getInputLabellist() {
        return this.inputLabellist;
    }

    public final void setInputLabellist(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.inputLabellist, value);
        this.inputLabellist = value;
        notifyPropertyChanged(434);
    }

    @Bindable
    public final List<String> getInputLabellist64() {
        return this.inputLabellist64;
    }

    public final void setInputLabellist64(List<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.inputLabellist64, value);
        this.inputLabellist64 = value;
        notifyPropertyChanged(434);
    }

    @Bindable
    public final String getChanState() {
        return this.chanState;
    }

    public final void setChanState(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.chanState, value);
        this.chanState = value;
        notifyPropertyChanged(434);
    }

    @Bindable
    public final List<Integer> getChanStateList() {
        return this.chanStateList;
    }

    public final void setChanStateList(List<Integer> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("screenTimeStr", this.chanStateList, value);
        this.chanStateList = value;
        notifyPropertyChanged(168);
    }

    @Bindable
    public final String getGroupChanState() {
        return this.groupChanState;
    }

    public final void setGroupChanState(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("screenTimeStr", this.groupChanState, value);
        this.groupChanState = value;
    }

    @Bindable
    public final int getLa_position() {
        return this.la_position;
    }

    public final void setLa_position(int i) {
        log("screenTimeStr", Integer.valueOf(this.la_position), Integer.valueOf(i));
        this.la_position = i;
    }

    @Bindable
    public final int getLa_select_position() {
        return this.la_select_position;
    }

    public final void setLa_select_position(int i) {
        log("screenTimeStr", Integer.valueOf(this.la_select_position), Integer.valueOf(i));
        this.la_select_position = i;
    }

    @Bindable
    public final boolean getLa_labels_en() {
        return this.la_labels_en;
    }

    public final void setLa_labels_en(boolean z) {
        log("chNum", Boolean.valueOf(this.la_labels_en), Boolean.valueOf(z));
        this.la_labels_en = z;
        notifyPropertyChanged(464);
    }

    @Bindable
    public final int getLa_probe_cal_pro() {
        return this.la_probe_cal_pro;
    }

    public final void setLa_probe_cal_pro(int i) {
        log("chNum", Integer.valueOf(this.la_probe_cal_pro), Integer.valueOf(i));
        this.la_probe_cal_pro = i;
        notifyPropertyChanged(469);
    }

    @Bindable
    public final String getLa_probe_cal_prostr() {
        return this.la_probe_cal_prostr;
    }

    public final void setLa_probe_cal_prostr(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.la_probe_cal_prostr, value);
        this.la_probe_cal_prostr = value;
        notifyPropertyChanged(464);
    }

    @Bindable
    public final String getLa_probe_cal_data() {
        return this.la_probe_cal_data;
    }

    public final void setLa_probe_cal_data(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.la_probe_cal_data, value);
        this.la_probe_cal_data = value;
        notifyPropertyChanged(468);
    }

    public final void readLaProbeCalProString() {
        setLa_probe_cal_data(readStr(MessageID.MSG_LA_SHOW_CALNUM));
    }

    public final void readLaProbeCalPro() {
        setLa_probe_cal_pro(readInt(MessageID.MSG_LA_PROBE_CAL_PROGRESS));
    }

    public final void setLaProbeCalPros(int i) {
        setLa_probe_cal_pro(i);
        saveInt(MessageID.MSG_LA_PROBE_CAL_PROGRESS, i);
    }

    public final void readLaLabelEn() {
        setLa_labels_en(readBool(MessageID.MSG_LA_LABEL_VIEW));
    }

    public final void saveLaLabelEn(boolean z) {
        setLa_labels_en(z);
        saveBool(MessageID.MSG_LA_LABEL_VIEW, z);
    }

    public final void saveCalibrationEnable(boolean z) {
        setCalibration_Enable(z);
        saveBool(MessageID.MSG_LA_CALIBRATION_PROBE, z);
    }

    public final void readLaSelectPosition() {
        setLa_select_position(readInt(MessageID.MSG_LA_CHAN_SELECT));
    }

    public final void saveLaSelectPosition(int i) {
        setLa_select_position(i);
        saveInt(MessageID.MSG_LA_CHAN_SELECT, i);
    }

    public final void readLaPosition() {
        setLa_position(readInt(MessageID.MSG_LA_POSITION));
    }

    public final void saveLaPosition(int i) {
        setLa_position(i);
        saveInt(MessageID.MSG_LA_POSITION, i);
    }

    public final String readinputLabellist() {
        setInputLabellist(readStr(MessageID.MSG_LA_CHAN_STATE_ATTR));
        setInputLabellist(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(this.inputLabellist, "{", "", false, 4, (Object) null), "}", "", false, 4, (Object) null), "[", "", false, 4, (Object) null), "]", "", false, 4, (Object) null));
        if (this.inputLabellist.length() > 0) {
            setInputLabellist64(CollectionsKt.toMutableList((Collection) StringsKt.split$default((CharSequence) this.inputLabellist, new String[]{","}, false, 0, 6, (Object) null)));
            if (this.inputLabellist.length() > 10) {
                syncData(MessageID.MSG_LA_ENABLE, Boolean.valueOf(this.laEnable));
            }
        }
        return this.inputLabellist;
    }

    public final String readGroupChanState() {
        setGroupChanState(readStr(MessageID.MSG_LA_GROUP_DX_STATE));
        return this.groupChanState;
    }

    public final String readD0ToD7ChanState() {
        setChanState(readStr(MessageID.MSG_LA_CHAN_STATE));
        if (this.chanState.length() > 10) {
            List<String> split$default = StringsKt.split$default((CharSequence) StringsKt.removeSurrounding(this.chanState, (CharSequence) "[", (CharSequence) "]"), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str : split$default) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
            setChanStateList(CollectionsKt.toMutableList((Collection) arrayList));
        }
        getd0toD7();
        return this.chanState;
    }

    public final String readD8ToD15ChanState() {
        setChanState(readStr(MessageID.MSG_LA_CHAN_STATE));
        if (this.chanState.length() > 10) {
            List<String> split$default = StringsKt.split$default((CharSequence) StringsKt.removeSurrounding(this.chanState, (CharSequence) "[", (CharSequence) "]"), new String[]{","}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(split$default, 10));
            for (String str : split$default) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str)));
            }
            setChanStateList(CollectionsKt.toMutableList((Collection) arrayList));
        }
        getd8toD15();
        return this.chanState;
    }

    public final int readlaSelectChan() {
        setLa_label_view_select_chan(readInt(MessageID.MSG_LA_LABEL_SELECT_CHAN));
        return this.la_label_view_select_chan;
    }

    public final void savelaSelectChan(int i) {
        setLa_label_view_select_chan(i);
        saveInt(MessageID.MSG_LA_LABEL_SELECT_CHAN, i);
    }

    public final int readLaLabelViewSelect() {
        setLa_label_view_select(readInt(MessageID.MSG_LA_LABEL_VIEW_SELECT));
        return this.la_label_view_select;
    }

    public final void saveLaLabelViewSelect(int i) {
        setLa_label_view_select(i);
        saveInt(MessageID.MSG_LA_LABEL_VIEW_SELECT, i);
    }

    public final int readlaHighColor() {
        setLa_high_color(readInt(MessageID.MSG_LA_HIGH_COLOR));
        return this.la_high_color;
    }

    public final int readlaedgeColor() {
        setLa_edge_color(readInt(MessageID.MSG_LA_EDGE_COLOR));
        return this.la_edge_color;
    }

    public final int readlalowColor() {
        setLa_low_color(readInt(MessageID.MSG_LA_LOW_COLOR));
        return this.la_low_color;
    }

    public final void savelaHighColor(int i) {
        setLa_high_color(i);
        saveInt(MessageID.MSG_LA_HIGH_COLOR, i);
    }

    public final void savelaedgeColor(int i) {
        setLa_edge_color(i);
        saveInt(MessageID.MSG_LA_EDGE_COLOR, i);
    }

    public final void savelLoweColor(int i) {
        setLa_low_color(i);
        saveInt(MessageID.MSG_LA_LOW_COLOR, i);
    }

    public final void savelabelGroup(boolean z) {
        setLabelGroup(z);
        saveBool(MessageID.MSG_LA_SELECT_GROUP, z);
    }

    public final boolean readlabelGroup() {
        setLabelGroup(readBool(MessageID.MSG_LA_SELECT_GROUP));
        return this.labelGroup;
    }

    public final void saveInputLabel(String inputLabel) {
        Intrinsics.checkNotNullParameter(inputLabel, "inputLabel");
        setInputLabel(inputLabel);
        saveStr(MessageID.MSG_LA_INPUT_LABEL, inputLabel);
    }

    public final String readInputLabel() {
        setInputLabel(readStr(MessageID.MSG_LA_INPUT_LABEL));
        return this.inputLabel;
    }

    public final void saveGroup1(int i) {
        setLa_group1(i);
        saveInt(MessageID.MSG_LA_GROUP_SET, i);
        getGrouplist();
    }

    public final List<Integer> getGrouplist() {
        int i = this.la_group1;
        if (i == 0) {
            setGlistNow(this.glist1);
            return this.glist1;
        } else if (i == 1) {
            setGlistNow(this.glist2);
            return this.glist2;
        } else if (i == 2) {
            setGlistNow(this.glist3);
            return this.glist3;
        } else {
            setGlistNow(this.glist4);
            return this.glist4;
        }
    }

    public final int readGroup1() {
        setLa_group1(readInt(MessageID.MSG_LA_GROUP_SET));
        return this.la_group1;
    }

    public final void saveGroup2(int i) {
        setLa_group2(i);
        saveInt(MessageID.MSG_LA_GROUP2_SET, i);
    }

    public final int readGroup2() {
        setLa_group2(readInt(MessageID.MSG_LA_GROUP2_SET));
        return this.la_group2;
    }

    public final void saveGroup3(int i) {
        setLa_group3(i);
        saveInt(MessageID.MSG_LA_GROUP3_SET, i);
    }

    public final int readGroup3() {
        setLa_group3(readInt(MessageID.MSG_LA_GROUP3_SET));
        return this.la_group3;
    }

    public final void saveGroup4(int i) {
        setLa_group4(i);
        saveInt(MessageID.MSG_LA_GROUP4_SET, i);
    }

    public final int readGroup4() {
        setLa_group4(readInt(MessageID.MSG_LA_GROUP4_SET));
        return this.la_group4;
    }

    public final void savelaEnable(boolean z) {
        setLaEnable(z);
        saveBool(MessageID.MSG_LA_ENABLE, z);
        if (z) {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.LA_LED_WHITE.value1, 1);
        } else {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.LA_LED_WHITE.value1, 0);
        }
    }

    public final boolean readLaEnable() {
        setLaEnable(readBool(MessageID.MSG_LA_ENABLE));
        if (this.laEnable) {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.LA_LED_WHITE.value1, 1);
        } else {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.LA_LED_WHITE.value1, 0);
        }
        return this.laEnable;
    }

    public final void saveLabel(boolean z) {
        setLabel(z);
        saveBool(MessageID.MSG_LA_LABEL_VIEW, z);
    }

    public final boolean readlabel() {
        setLabel(readBool(MessageID.MSG_LA_LABEL_VIEW));
        return this.label;
    }

    public final int readlaSource() {
        setLa_source(readInt(MessageID.MSG_LA_CURRENT_CHAN));
        return this.la_source;
    }

    public final void savelaSource(int i) {
        setLa_source(i);
        saveInt(MessageID.MSG_LA_CURRENT_CHAN, i);
    }

    public final int readLaSize() {
        setLa_size_(readInt(MessageID.MSG_LA_WAVE_SIZE));
        return this.la_size_;
    }

    public final void saveLaSize(int i) {
        setLa_size_(i);
        saveInt(MessageID.MSG_LA_WAVE_SIZE, i);
    }

    public final boolean readD0TOd7() {
        setD0TOd7(readBool(MessageID.MSG_LA_D0D7_ONOFF));
        return this.d0TOd7;
    }

    public final void saveD0TOd7(boolean z) {
        setD0TOd7(z);
        saveBool(MessageID.MSG_LA_D0D7_ONOFF, z);
    }

    public final boolean readD8TOd15() {
        setD8TOd15(readBool(MessageID.MSG_LA_D8D15_ONOFF));
        return this.d8TOd15;
    }

    public final void saveD8TOd15(boolean z) {
        setD8TOd15(z);
        saveBool(MessageID.MSG_LA_D8D15_ONOFF, z);
    }

    public final long readD0TOd7Threshold() {
        setD0TOd7_threshold_(readLong(MessageID.MSG_LA_LOW_THRE_VAL));
        return this.d0TOd7_threshold_;
    }

    public final void savedD0TOd7Threshold(long j) {
        setD0TOd7_threshold_(j);
        saveLong(MessageID.MSG_LA_LOW_THRE_VAL, j);
    }

    public final long readD8TOd15Threshold() {
        setD8TOd15_threshold_(readLong(MessageID.MSG_LA_HIGH_THRE_VAL));
        return this.d8TOd15_threshold_;
    }

    public final void savedD8TOd15Threshold(long j) {
        setD8TOd15_threshold_(j);
        saveLong(MessageID.MSG_LA_HIGH_THRE_VAL, j);
    }

    public final ServiceEnum.Unit getUnit() {
        return ServiceEnum.Unit.Unit_V;
    }

    public final void saveAutoOrder(int i) {
        setLa_order(i);
        saveInt(MessageID.MSG_LA_AUTO_SET, i);
    }

    public final int readAutoOrder() {
        setLa_order(readInt(MessageID.MSG_LA_AUTO_SET));
        return this.la_order;
    }

    public final void saveSelectChar(int i) {
        saveInt(MessageID.MSG_LA_CHAN_ENABLE, i);
        int i2 = i - 9;
        if (this.chanStateList.get(i2).intValue() == 1) {
            this.chanStateList.get(i2).intValue();
        } else {
            this.chanStateList.get(i2).intValue();
        }
    }

    public final void readProbe() {
        setLa_calibration_probe(API.getInstance().UI_QueryBool(59, MessageID.MSG_LA_PROBE_IDENTIFY));
    }

    public final void saveSelectAddDX(int i) {
        saveInt(MessageID.MSG_LA_GROUP_ADD_DX, i);
        int i2 = i - 9;
        int i3 = this.la_group1;
        if (i3 == 0) {
            if (this.glist1.get(i2).intValue() == 0) {
                this.glist1.set(i2, 1);
                this.glist2.set(i2, 2);
                this.glist3.set(i2, 2);
                this.glist4.set(i2, 2);
                return;
            }
            this.glist1.set(i2, 0);
            this.glist2.set(i2, 0);
            this.glist3.set(i2, 0);
            this.glist4.set(i2, 0);
        } else if (i3 == 1) {
            if (this.glist2.get(i2).intValue() == 0) {
                this.glist2.set(i2, 1);
                this.glist1.set(i2, 2);
                this.glist3.set(i2, 2);
                this.glist4.set(i2, 2);
                return;
            }
            this.glist2.set(i2, 0);
            this.glist1.set(i2, 0);
            this.glist3.set(i2, 0);
            this.glist4.set(i2, 0);
        } else if (i3 == 2) {
            if (this.glist3.get(i2).intValue() == 0) {
                this.glist3.set(i2, 1);
                this.glist2.set(i2, 2);
                this.glist1.set(i2, 2);
                this.glist4.set(i2, 2);
                return;
            }
            this.glist3.set(i2, 0);
            this.glist2.set(i2, 0);
            this.glist1.set(i2, 0);
            this.glist4.set(i2, 0);
        } else if (i3 != 3) {
        } else {
            if (this.glist4.get(i2).intValue() == 0) {
                this.glist4.set(i2, 1);
                this.glist2.set(i2, 2);
                this.glist3.set(i2, 2);
                this.glist1.set(i2, 2);
                return;
            }
            this.glist4.set(i2, 0);
            this.glist2.set(i2, 0);
            this.glist3.set(i2, 0);
            this.glist1.set(i2, 0);
        }
    }

    public final void groupCancel() {
        int i = this.la_group1;
        if (i == 0) {
            int size = this.glist1.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.glist1.get(i2).intValue() == 1) {
                    this.glist1.set(i2, 0);
                    this.glist2.set(i2, 0);
                    this.glist3.set(i2, 0);
                    this.glist4.set(i2, 0);
                }
                setGlistNow(this.glist1);
            }
        } else if (i == 1) {
            int size2 = this.glist2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                if (this.glist2.get(i3).intValue() == 1) {
                    this.glist1.set(i3, 0);
                    this.glist2.set(i3, 0);
                    this.glist3.set(i3, 0);
                    this.glist4.set(i3, 0);
                }
                setGlistNow(this.glist2);
            }
        } else if (i == 2) {
            int size3 = this.glist3.size();
            for (int i4 = 0; i4 < size3; i4++) {
                if (this.glist3.get(i4).intValue() == 1) {
                    this.glist1.set(i4, 0);
                    this.glist2.set(i4, 0);
                    this.glist3.set(i4, 0);
                    this.glist4.set(i4, 0);
                }
                setGlistNow(this.glist3);
            }
        } else if (i == 3) {
            int size4 = this.glist4.size();
            for (int i5 = 0; i5 < size4; i5++) {
                if (this.glist4.get(i5).intValue() == 1) {
                    this.glist1.set(i5, 0);
                    this.glist2.set(i5, 0);
                    this.glist3.set(i5, 0);
                    this.glist4.set(i5, 0);
                }
                setGlistNow(this.glist4);
            }
        }
    }

    public final void saveLaGroupCancel(boolean z) {
        saveBool(MessageID.MSG_LA_GROUP_CANCEL, z);
        groupCancel();
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        super.readAll();
        readD0TOd7();
        readD8TOd15();
        readLaSize();
        readD0TOd7Threshold();
        readD8TOd15Threshold();
        readlaSource();
        readlabel();
        readLaEnable();
        readLaLabelEn();
        readInputLabel();
        readAttr(MessageID.MSG_LA_LOW_THRE_VAL, this.d0tod7Attr);
        readAttr(MessageID.MSG_LA_HIGH_THRE_VAL, this.d8tod15Attr);
        readlabelGroup();
        readGroup1();
        readlaHighColor();
        readlaedgeColor();
        readlalowColor();
        readAutoOrder();
        readlaSelectChan();
        readLaLabelViewSelect();
        readD0ToD7ChanState();
        readD8ToD15ChanState();
        readGroupChanState();
        readinputLabellist();
        readProbe();
    }

    public final boolean getd0toD7() {
        if (this.chanStateList.isEmpty()) {
            setD0TOd7(false);
            return false;
        } else if (this.chanStateList.get(0).intValue() == 1 && this.chanStateList.get(1).intValue() == 1 && this.chanStateList.get(2).intValue() == 1 && this.chanStateList.get(3).intValue() == 1 && this.chanStateList.get(4).intValue() == 1 && this.chanStateList.get(5).intValue() == 1 && this.chanStateList.get(6).intValue() == 1 && this.chanStateList.get(7).intValue() == 1) {
            setD0TOd7(true);
            return true;
        } else {
            setD0TOd7(false);
            return false;
        }
    }

    public final boolean getd8toD15() {
        if (this.chanStateList.isEmpty()) {
            setD8TOd15(false);
            return false;
        } else if (this.chanStateList.get(8).intValue() == 1 && this.chanStateList.get(9).intValue() == 1 && this.chanStateList.get(10).intValue() == 1 && this.chanStateList.get(11).intValue() == 1 && this.chanStateList.get(12).intValue() == 1 && this.chanStateList.get(13).intValue() == 1 && this.chanStateList.get(14).intValue() == 1 && this.chanStateList.get(15).intValue() == 1) {
            setD8TOd15(true);
            return true;
        } else {
            setD8TOd15(false);
            return false;
        }
    }

    public final boolean getSizeNow() {
        int size = this.chanStateList.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            if (this.chanStateList.get(i2).intValue() == 1) {
                i++;
            }
        }
        return i > 8;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setD0TOd7(false);
        setD8TOd15(false);
        setLa_size_(1);
        setD0TOd7_threshold_(100L);
        setD8TOd15_threshold_(0L);
        setD0TOd7_threshold_(0L);
        setLa_spacing_(35);
        setLa_source(0);
        setLabel(false);
        setLabelGroup(true);
        setLaEnable(false);
        setLa_group1(0);
        setLa_group2(0);
        setLa_group3(0);
        setLa_group4(0);
        setLa_edge_color(0);
        setLa_low_color(0);
        setLa_label_view_select(0);
        setLa_label_view_select_chan(0);
        setInputLabel("");
        setInputLabellist("");
        setInputLabellist64(new ArrayList());
        setChanState("");
        setChanStateList(new ArrayList());
        setGroupChanState("");
        setLa_position(0);
        setLa_select_position(0);
        setLa_labels_en(true);
        saveBool(MessageID.MSG_LA_ENABLE, this.laEnable);
        readD0ToD7ChanState();
        readD8ToD15ChanState();
        readinputLabellist();
    }
}
