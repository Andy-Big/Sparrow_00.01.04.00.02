package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.blankj.utilcode.util.LogUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AfgParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b \n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\u000b\n\u0002\bA\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\bI\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010¦\u0001\u001a\u00030§\u0001J\u0007\u0010¨\u0001\u001a\u00020\u0016J\u0007\u0010©\u0001\u001a\u00020\u0016J\u0007\u0010ª\u0001\u001a\u00020\u0016J\u0007\u0010«\u0001\u001a\u00020\u0016J\n\u0010¬\u0001\u001a\u00030§\u0001H\u0016J\u0007\u0010\u00ad\u0001\u001a\u000207J\b\u0010®\u0001\u001a\u00030§\u0001J\u0007\u0010¯\u0001\u001a\u000207J\b\u0010°\u0001\u001a\u00030§\u0001J\u0007\u0010±\u0001\u001a\u00020\u0016J\b\u0010²\u0001\u001a\u00030§\u0001J\u0007\u0010³\u0001\u001a\u00020\u0016J\b\u0010´\u0001\u001a\u00030§\u0001J\u0007\u0010µ\u0001\u001a\u00020^J\u0007\u0010¶\u0001\u001a\u000207J\u0007\u0010·\u0001\u001a\u00020\u0016J\b\u0010¸\u0001\u001a\u00030§\u0001J\u0007\u0010¹\u0001\u001a\u00020\u0016J\b\u0010º\u0001\u001a\u00030§\u0001J\u0007\u0010»\u0001\u001a\u000207J\b\u0010¼\u0001\u001a\u00030§\u0001J\u0007\u0010½\u0001\u001a\u00020\u0016J\b\u0010¾\u0001\u001a\u00030§\u0001J\u0007\u0010¿\u0001\u001a\u00020\u0016J\b\u0010À\u0001\u001a\u00030§\u0001J\u0007\u0010Á\u0001\u001a\u000207J\b\u0010Â\u0001\u001a\u00030§\u0001J\u0007\u0010Ã\u0001\u001a\u00020\u0016J\u0007\u0010Ä\u0001\u001a\u000207J\b\u0010Å\u0001\u001a\u00030§\u0001J\u0007\u0010Æ\u0001\u001a\u00020^J\u0007\u0010Ç\u0001\u001a\u00020\u0016J\u0007\u0010È\u0001\u001a\u000207J\b\u0010É\u0001\u001a\u00030§\u0001J\u0007\u0010Ê\u0001\u001a\u000207J\b\u0010Ë\u0001\u001a\u00030§\u0001J\u0007\u0010Ì\u0001\u001a\u000207J\b\u0010Í\u0001\u001a\u00030§\u0001J\u0007\u0010Î\u0001\u001a\u000207J\u0007\u0010Ï\u0001\u001a\u000207J\u0007\u0010Ð\u0001\u001a\u000207J\b\u0010Ñ\u0001\u001a\u00030§\u0001J\n\u0010Ò\u0001\u001a\u00030§\u0001H\u0016J\u0010\u0010Ó\u0001\u001a\u00030§\u00012\u0006\u0010\u0017\u001a\u00020\u0016J\u0010\u0010Ô\u0001\u001a\u00030§\u00012\u0006\u0010\u001f\u001a\u00020\u0016J\u0010\u0010Õ\u0001\u001a\u00030§\u00012\u0006\u0010\"\u001a\u00020\u0016J\u0010\u0010Ö\u0001\u001a\u00030§\u00012\u0006\u0010(\u001a\u00020\u0016J\b\u0010×\u0001\u001a\u00030§\u0001J\u0010\u0010Ø\u0001\u001a\u00030§\u00012\u0006\u0010@\u001a\u000207J\u0010\u0010Ù\u0001\u001a\u00030§\u00012\u0006\u0010F\u001a\u000207J\u0010\u0010Ú\u0001\u001a\u00030§\u00012\u0006\u0010L\u001a\u00020\u0016J\u0010\u0010Û\u0001\u001a\u00030§\u00012\u0006\u0010R\u001a\u00020\u0016J\u0010\u0010Ü\u0001\u001a\u00030§\u00012\u0006\u0010_\u001a\u00020^J\u0010\u0010Ý\u0001\u001a\u00030§\u00012\u0006\u0010d\u001a\u000207J\u0010\u0010Þ\u0001\u001a\u00030§\u00012\u0006\u0010j\u001a\u00020\u0016J\u0010\u0010ß\u0001\u001a\u00030§\u00012\u0006\u0010p\u001a\u00020\u0016J\u0010\u0010à\u0001\u001a\u00030§\u00012\u0006\u0010v\u001a\u000207J\u0010\u0010á\u0001\u001a\u00030§\u00012\u0006\u0010|\u001a\u00020\u0016J\u0010\u0010â\u0001\u001a\u00030§\u00012\u0006\u00101\u001a\u00020\u0016J\u0010\u0010ã\u0001\u001a\u00030§\u00012\u0006\u00108\u001a\u000207J\u0011\u0010ä\u0001\u001a\u00030§\u00012\u0007\u0010\u0082\u0001\u001a\u00020\u0016J\u0010\u0010å\u0001\u001a\u00030§\u00012\u0006\u0010X\u001a\u000207J\u0011\u0010æ\u0001\u001a\u00030§\u00012\u0007\u0010\u0085\u0001\u001a\u00020^J\u0011\u0010ç\u0001\u001a\u00030§\u00012\u0007\u0010\u0088\u0001\u001a\u00020\u0016J\u0011\u0010è\u0001\u001a\u00030§\u00012\u0007\u0010\u008b\u0001\u001a\u000207J\u0011\u0010é\u0001\u001a\u00030§\u00012\u0007\u0010\u008e\u0001\u001a\u000207J\u0011\u0010ê\u0001\u001a\u00030§\u00012\u0007\u0010\u0091\u0001\u001a\u000207J\u0011\u0010ë\u0001\u001a\u00030§\u00012\u0007\u0010\u0094\u0001\u001a\u000207J\u0011\u0010ì\u0001\u001a\u00030§\u00012\u0007\u0010\u009a\u0001\u001a\u000207J\u0011\u0010í\u0001\u001a\u00030§\u00012\u0007\u0010\u009d\u0001\u001a\u000207J\u0012\u0010î\u0001\u001a\u00030§\u00012\b\u0010¡\u0001\u001a\u00030 \u0001J\b\u0010ï\u0001\u001a\u00030§\u0001R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR&\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR&\u0010\"\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0019\"\u0004\b$\u0010\u001bR\u001a\u0010%\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\f\"\u0004\b'\u0010\u000eR&\u0010(\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010\u001bR\u001a\u0010+\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\f\"\u0004\b-\u0010\u000eR&\u0010.\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR&\u00101\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001a\u00104\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR&\u00108\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\f\"\u0004\b?\u0010\u000eR&\u0010@\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010:\"\u0004\bB\u0010<R\u001a\u0010C\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\f\"\u0004\bE\u0010\u000eR&\u0010F\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010:\"\u0004\bH\u0010<R\u001a\u0010I\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\f\"\u0004\bK\u0010\u000eR&\u0010L\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\u0019\"\u0004\bN\u0010\u001bR\u001a\u0010O\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\f\"\u0004\bQ\u0010\u000eR&\u0010R\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0019\"\u0004\bT\u0010\u001bR\u001a\u0010U\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR&\u0010X\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010:\"\u0004\bZ\u0010<R\u001a\u0010[\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\f\"\u0004\b]\u0010\u000eR&\u0010_\u001a\u00020^2\u0006\u0010\u0015\u001a\u00020^8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR&\u0010d\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010:\"\u0004\bf\u0010<R\u001a\u0010g\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\f\"\u0004\bi\u0010\u000eR&\u0010j\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010\u0019\"\u0004\bl\u0010\u001bR\u001a\u0010m\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\f\"\u0004\bo\u0010\u000eR&\u0010p\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\u0019\"\u0004\br\u0010\u001bR\u001a\u0010s\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bt\u0010\f\"\u0004\bu\u0010\u000eR&\u0010v\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bw\u0010:\"\u0004\bx\u0010<R\u001a\u0010y\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010\f\"\u0004\b{\u0010\u000eR&\u0010|\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u0019\"\u0004\b~\u0010\u001bR\u001c\u0010\u007f\u001a\u00020\nX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0080\u0001\u0010\f\"\u0005\b\u0081\u0001\u0010\u000eR)\u0010\u0082\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0083\u0001\u0010\u0019\"\u0005\b\u0084\u0001\u0010\u001bR)\u0010\u0085\u0001\u001a\u00020^2\u0006\u0010\u0015\u001a\u00020^8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0086\u0001\u0010a\"\u0005\b\u0087\u0001\u0010cR)\u0010\u0088\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0089\u0001\u0010\u0019\"\u0005\b\u008a\u0001\u0010\u001bR)\u0010\u008b\u0001\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008c\u0001\u0010:\"\u0005\b\u008d\u0001\u0010<R)\u0010\u008e\u0001\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008f\u0001\u0010:\"\u0005\b\u0090\u0001\u0010<R)\u0010\u0091\u0001\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0092\u0001\u0010:\"\u0005\b\u0093\u0001\u0010<R)\u0010\u0094\u0001\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0095\u0001\u0010:\"\u0005\b\u0096\u0001\u0010<R)\u0010\u0097\u0001\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0098\u0001\u0010\u0019\"\u0005\b\u0099\u0001\u0010\u001bR)\u0010\u009a\u0001\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009b\u0001\u0010:\"\u0005\b\u009c\u0001\u0010<R)\u0010\u009d\u0001\u001a\u0002072\u0006\u0010\u0015\u001a\u0002078G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009e\u0001\u0010:\"\u0005\b\u009f\u0001\u0010<R-\u0010¡\u0001\u001a\u00030 \u00012\u0007\u0010\u0015\u001a\u00030 \u00018G@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¢\u0001\u0010£\u0001\"\u0006\b¤\u0001\u0010¥\u0001¨\u0006ð\u0001"}, d2 = {"Lcom/rigol/scope/data/AfgParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "afgFreqUnit", "Lcom/rigol/scope/cil/ServiceEnum$Unit;", "getAfgFreqUnit", "()Lcom/rigol/scope/cil/ServiceEnum$Unit;", "setAfgFreqUnit", "(Lcom/rigol/scope/cil/ServiceEnum$Unit;)V", "afg_mod_am_devAtty", "Lcom/rigol/scope/cil/MessageAttr;", "getAfg_mod_am_devAtty", "()Lcom/rigol/scope/cil/MessageAttr;", "setAfg_mod_am_devAtty", "(Lcom/rigol/scope/cil/MessageAttr;)V", "afg_mod_pm_devAtty", "getAfg_mod_pm_devAtty", "setAfg_mod_pm_devAtty", "afg_wave_am_freqAttr", "getAfg_wave_am_freqAttr", "setAfg_wave_am_freqAttr", "value", "", "afg_wave_am_shape", "getAfg_wave_am_shape", "()I", "setAfg_wave_am_shape", "(I)V", "afg_wave_fm_devAttr", "getAfg_wave_fm_devAttr", "setAfg_wave_fm_devAttr", "afg_wave_fm_shape", "getAfg_wave_fm_shape", "setAfg_wave_fm_shape", "afg_wave_mod_type", "getAfg_wave_mod_type", "setAfg_wave_mod_type", "afg_wave_pm_freqAttr", "getAfg_wave_pm_freqAttr", "setAfg_wave_pm_freqAttr", "afg_wave_pm_shape", "getAfg_wave_pm_shape", "setAfg_wave_pm_shape", "afg_wave_range_depthAttr", "getAfg_wave_range_depthAttr", "setAfg_wave_range_depthAttr", "attr_step_pos", "getAttr_step_pos", "setAttr_step_pos", "basic_SYMM", "getBasic_SYMM", "setBasic_SYMM", "basic_SYMMAttr", "getBasic_SYMMAttr", "setBasic_SYMMAttr", "", "basic_amp", "getBasic_amp", "()J", "setBasic_amp", "(J)V", "basic_amp_freqAttr", "getBasic_amp_freqAttr", "setBasic_amp_freqAttr", "basic_falledge", "getBasic_falledge", "setBasic_falledge", "basic_falledgeAttr", "getBasic_falledgeAttr", "setBasic_falledgeAttr", "basic_freq", "getBasic_freq", "setBasic_freq", "basic_freqAttr", "getBasic_freqAttr", "setBasic_freqAttr", "basic_high", "getBasic_high", "setBasic_high", "basic_highAttr", "getBasic_highAttr", "setBasic_highAttr", "basic_low", "getBasic_low", "setBasic_low", "basic_lowAttr", "getBasic_lowAttr", "setBasic_lowAttr", "basic_offset", "getBasic_offset", "setBasic_offset", "basic_offsetAttr", "getBasic_offsetAttr", "setBasic_offsetAttr", "", "basic_output_enable", "getBasic_output_enable", "()Z", "setBasic_output_enable", "(Z)V", "basic_period", "getBasic_period", "setBasic_period", "basic_periodAttr", "getBasic_periodAttr", "setBasic_periodAttr", "basic_phase", "getBasic_phase", "setBasic_phase", "basic_phaseAttr", "getBasic_phaseAttr", "setBasic_phaseAttr", "basic_pul_duty", "getBasic_pul_duty", "setBasic_pul_duty", "basic_pul_dutyAttr", "getBasic_pul_dutyAttr", "setBasic_pul_dutyAttr", "basic_riseedge", "getBasic_riseedge", "setBasic_riseedge", "basic_riseedgeAttr", "getBasic_riseedgeAttr", "setBasic_riseedgeAttr", "basic_squ_duty", "getBasic_squ_duty", "setBasic_squ_duty", "basic_squ_dutyAttr", "getBasic_squ_dutyAttr", "setBasic_squ_dutyAttr", "mode_function", "getMode_function", "setMode_function", "service_output_enable", "getService_output_enable", "setService_output_enable", "wave_function", "getWave_function", "setWave_function", "wave_mod_am_depth", "getWave_mod_am_depth", "setWave_mod_am_depth", "wave_mod_am_freq", "getWave_mod_am_freq", "setWave_mod_am_freq", "wave_mod_fm_deviation", "getWave_mod_fm_deviation", "setWave_mod_fm_deviation", "wave_mod_fm_freq", "getWave_mod_fm_freq", "setWave_mod_fm_freq", "wave_mod_pic", "getWave_mod_pic", "setWave_mod_pic", "wave_mod_pm_dev", "getWave_mod_pm_dev", "setWave_mod_pm_dev", "wave_mod_pm_freq", "getWave_mod_pm_freq", "setWave_mod_pm_freq", "", "wave_path", "getWave_path", "()Ljava/lang/String;", "setWave_path", "(Ljava/lang/String;)V", "readAfgModPmDev", "", "readAfgWaveAmShape", "readAfgWaveFmShape", "readAfgWaveModType", "readAfgWavePmShape", "readAll", "readBasicFalledge", "readBasicFalledgeAttr", "readBasicFreq", "readBasicFreqAttr", "readBasicHigh", "readBasicHighAttr", "readBasicLow", "readBasicLowAttr", "readBasicOutputEnable", "readBasicPeriod", "readBasicPhase", "readBasicPhaseAttr", "readBasicPulDuty", "readBasicPulDutyAttr", "readBasicRiseedge", "readBasicRiseedgeAttr", "readBasicSquDuty", "readBasicSquDutyAttr", "readBasicSymm", "readBasicSymmAttr", "readBasicamp", "readBasicampAttr", "readModeFunction", "readOffset", "readOffsetAttr", "readServiceOutputEnable", "readWaveFunction", "readWaveModAmDepth", "readWaveModAmDepthAttr", "readWaveModAmFreq", "readWaveModAmFreqArrt", "readWaveModFmDeviation", "readWaveModFmDeviationAttr", "readWaveModFmFreq", "readWaveModPmDev", "readWaveModPmFreq", "readWaveModPmFreqAttr", "reset", "saveAfgWaveAmShape", "saveAfgWaveFmShape", "saveAfgWaveModType", "saveAfgWavePmShape", "saveAttrStepPos", "saveBasicFalledge", "saveBasicFreq", "saveBasicHigh", "saveBasicLow", "saveBasicOutputEnable", "saveBasicPeriod", "saveBasicPhase", "saveBasicPulDuty", "saveBasicRiseedge", "saveBasicSquDuty", "saveBasicSymm", "saveBasicamp", "saveModeFunction", "saveOffset", "saveServiceOutputEnable", "saveWaveFunction", "saveWaveModAmDepth", "saveWaveModAmFreq", "saveWaveModFmDeviation", "saveWaveModFmFreq", "saveWaveModPmDev", "saveWaveModPmFreq", "saveWavePath", "setWaveModPic", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class AfgParam extends BaseParam {
    private ServiceEnum.Unit afgFreqUnit;
    private MessageAttr afg_mod_am_devAtty;
    private MessageAttr afg_mod_pm_devAtty;
    private MessageAttr afg_wave_am_freqAttr;
    private int afg_wave_am_shape;
    private MessageAttr afg_wave_fm_devAttr;
    private int afg_wave_fm_shape;
    private int afg_wave_mod_type;
    private MessageAttr afg_wave_pm_freqAttr;
    private int afg_wave_pm_shape;
    private MessageAttr afg_wave_range_depthAttr;
    private int attr_step_pos;
    private int basic_SYMM;
    private MessageAttr basic_SYMMAttr;
    private long basic_amp;
    private MessageAttr basic_amp_freqAttr;
    private long basic_falledge;
    private MessageAttr basic_falledgeAttr;
    private long basic_freq;
    private MessageAttr basic_freqAttr;
    private int basic_high;
    private MessageAttr basic_highAttr;
    private int basic_low;
    private MessageAttr basic_lowAttr;
    private long basic_offset;
    private MessageAttr basic_offsetAttr;
    private boolean basic_output_enable;
    private long basic_period;
    private MessageAttr basic_periodAttr;
    private int basic_phase;
    private MessageAttr basic_phaseAttr;
    private int basic_pul_duty;
    private MessageAttr basic_pul_dutyAttr;
    private long basic_riseedge;
    private MessageAttr basic_riseedgeAttr;
    private int basic_squ_duty;
    private MessageAttr basic_squ_dutyAttr;
    private int mode_function;
    private boolean service_output_enable;
    private int wave_function;
    private long wave_mod_am_depth;
    private long wave_mod_am_freq;
    private long wave_mod_fm_deviation;
    private long wave_mod_fm_freq;
    private int wave_mod_pic;
    private long wave_mod_pm_dev;
    private long wave_mod_pm_freq;
    private String wave_path;

    public AfgParam() {
        super(64);
        this.basic_periodAttr = new MessageAttr();
        this.basic_freqAttr = new MessageAttr();
        this.basic_amp_freqAttr = new MessageAttr();
        this.basic_offsetAttr = new MessageAttr();
        this.basic_highAttr = new MessageAttr();
        this.basic_lowAttr = new MessageAttr();
        this.basic_phaseAttr = new MessageAttr();
        this.basic_squ_dutyAttr = new MessageAttr();
        this.basic_SYMMAttr = new MessageAttr();
        this.basic_riseedgeAttr = new MessageAttr();
        this.basic_falledgeAttr = new MessageAttr();
        this.basic_pul_dutyAttr = new MessageAttr();
        this.afg_mod_am_devAtty = new MessageAttr();
        this.afg_mod_pm_devAtty = new MessageAttr();
        this.afg_wave_fm_devAttr = new MessageAttr();
        this.afg_wave_range_depthAttr = new MessageAttr();
        this.afg_wave_pm_freqAttr = new MessageAttr();
        this.afg_wave_am_freqAttr = new MessageAttr();
        this.afgFreqUnit = ServiceEnum.Unit.Unit_hz;
        this.attr_step_pos = 1;
        this.wave_path = "";
        this.basic_freq = 10000000000L;
        this.basic_period = 10000000000L;
    }

    public final MessageAttr getBasic_periodAttr() {
        return this.basic_periodAttr;
    }

    public final void setBasic_periodAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_periodAttr = messageAttr;
    }

    public final MessageAttr getBasic_freqAttr() {
        return this.basic_freqAttr;
    }

    public final void setBasic_freqAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_freqAttr = messageAttr;
    }

    public final MessageAttr getBasic_amp_freqAttr() {
        return this.basic_amp_freqAttr;
    }

    public final void setBasic_amp_freqAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_amp_freqAttr = messageAttr;
    }

    public final MessageAttr getBasic_offsetAttr() {
        return this.basic_offsetAttr;
    }

    public final void setBasic_offsetAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_offsetAttr = messageAttr;
    }

    public final MessageAttr getBasic_highAttr() {
        return this.basic_highAttr;
    }

    public final void setBasic_highAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_highAttr = messageAttr;
    }

    public final MessageAttr getBasic_lowAttr() {
        return this.basic_lowAttr;
    }

    public final void setBasic_lowAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_lowAttr = messageAttr;
    }

    public final MessageAttr getBasic_phaseAttr() {
        return this.basic_phaseAttr;
    }

    public final void setBasic_phaseAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_phaseAttr = messageAttr;
    }

    public final MessageAttr getBasic_squ_dutyAttr() {
        return this.basic_squ_dutyAttr;
    }

    public final void setBasic_squ_dutyAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_squ_dutyAttr = messageAttr;
    }

    public final MessageAttr getBasic_SYMMAttr() {
        return this.basic_SYMMAttr;
    }

    public final void setBasic_SYMMAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_SYMMAttr = messageAttr;
    }

    public final MessageAttr getBasic_riseedgeAttr() {
        return this.basic_riseedgeAttr;
    }

    public final void setBasic_riseedgeAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_riseedgeAttr = messageAttr;
    }

    public final MessageAttr getBasic_falledgeAttr() {
        return this.basic_falledgeAttr;
    }

    public final void setBasic_falledgeAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_falledgeAttr = messageAttr;
    }

    public final MessageAttr getBasic_pul_dutyAttr() {
        return this.basic_pul_dutyAttr;
    }

    public final void setBasic_pul_dutyAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.basic_pul_dutyAttr = messageAttr;
    }

    public final MessageAttr getAfg_mod_am_devAtty() {
        return this.afg_mod_am_devAtty;
    }

    public final void setAfg_mod_am_devAtty(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.afg_mod_am_devAtty = messageAttr;
    }

    public final MessageAttr getAfg_mod_pm_devAtty() {
        return this.afg_mod_pm_devAtty;
    }

    public final void setAfg_mod_pm_devAtty(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.afg_mod_pm_devAtty = messageAttr;
    }

    public final MessageAttr getAfg_wave_fm_devAttr() {
        return this.afg_wave_fm_devAttr;
    }

    public final void setAfg_wave_fm_devAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.afg_wave_fm_devAttr = messageAttr;
    }

    public final MessageAttr getAfg_wave_range_depthAttr() {
        return this.afg_wave_range_depthAttr;
    }

    public final void setAfg_wave_range_depthAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.afg_wave_range_depthAttr = messageAttr;
    }

    public final MessageAttr getAfg_wave_pm_freqAttr() {
        return this.afg_wave_pm_freqAttr;
    }

    public final void setAfg_wave_pm_freqAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.afg_wave_pm_freqAttr = messageAttr;
    }

    public final MessageAttr getAfg_wave_am_freqAttr() {
        return this.afg_wave_am_freqAttr;
    }

    public final void setAfg_wave_am_freqAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.afg_wave_am_freqAttr = messageAttr;
    }

    public final ServiceEnum.Unit getAfgFreqUnit() {
        return this.afgFreqUnit;
    }

    public final void setAfgFreqUnit(ServiceEnum.Unit unit) {
        Intrinsics.checkNotNullParameter(unit, "<set-?>");
        this.afgFreqUnit = unit;
    }

    @Bindable
    public final int getAttr_step_pos() {
        return this.attr_step_pos;
    }

    public final void setAttr_step_pos(int i) {
        log("chNum", Integer.valueOf(this.attr_step_pos), Integer.valueOf(i));
        this.attr_step_pos = i;
        notifyPropertyChanged(56);
    }

    @Bindable
    public final String getWave_path() {
        return this.wave_path;
    }

    public final void setWave_path(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.wave_path, value);
        this.wave_path = value;
        notifyPropertyChanged(1048);
    }

    @Bindable
    public final int getWave_function() {
        return this.wave_function;
    }

    public final void setWave_function(int i) {
        log("chNum", Integer.valueOf(this.wave_function), Integer.valueOf(i));
        this.wave_function = i;
        notifyPropertyChanged(1040);
    }

    @Bindable
    public final int getMode_function() {
        return this.mode_function;
    }

    public final void setMode_function(int i) {
        log("chNum", Integer.valueOf(this.mode_function), Integer.valueOf(i));
        this.mode_function = i;
        notifyPropertyChanged(549);
    }

    @Bindable
    public final long getBasic_freq() {
        return this.basic_freq;
    }

    public final void setBasic_freq(long j) {
        log("chNum", Long.valueOf(this.basic_freq), Long.valueOf(j));
        this.basic_freq = j;
        notifyPropertyChanged(77);
    }

    @Bindable
    public final long getBasic_period() {
        return this.basic_period;
    }

    public final void setBasic_period(long j) {
        log("chNum", Long.valueOf(this.basic_period), Long.valueOf(j));
        this.basic_period = j;
        notifyPropertyChanged(82);
    }

    @Bindable
    public final long getBasic_amp() {
        return this.basic_amp;
    }

    public final void setBasic_amp(long j) {
        log("chNum", Long.valueOf(this.basic_amp), Long.valueOf(j));
        this.basic_amp = j;
        notifyPropertyChanged(75);
    }

    @Bindable
    public final long getWave_mod_am_freq() {
        return this.wave_mod_am_freq;
    }

    public final void setWave_mod_am_freq(long j) {
        log("chNum", Long.valueOf(this.wave_mod_am_freq), Long.valueOf(j));
        this.wave_mod_am_freq = j;
        notifyPropertyChanged(1042);
    }

    @Bindable
    public final long getWave_mod_fm_freq() {
        return this.wave_mod_fm_freq;
    }

    public final void setWave_mod_fm_freq(long j) {
        log("chNum", Long.valueOf(this.wave_mod_fm_freq), Long.valueOf(j));
        this.wave_mod_fm_freq = j;
        notifyPropertyChanged(1044);
    }

    @Bindable
    public final long getWave_mod_pm_freq() {
        return this.wave_mod_pm_freq;
    }

    public final void setWave_mod_pm_freq(long j) {
        log("chNum", Long.valueOf(this.wave_mod_pm_freq), Long.valueOf(j));
        this.wave_mod_pm_freq = j;
        notifyPropertyChanged(1047);
    }

    @Bindable
    public final long getWave_mod_pm_dev() {
        return this.wave_mod_pm_dev;
    }

    public final void setWave_mod_pm_dev(long j) {
        log("chNum", Long.valueOf(this.wave_mod_pm_dev), Long.valueOf(j));
        this.wave_mod_pm_dev = j;
        notifyPropertyChanged(1046);
    }

    @Bindable
    public final long getWave_mod_am_depth() {
        return this.wave_mod_am_depth;
    }

    public final void setWave_mod_am_depth(long j) {
        log("chNum", Long.valueOf(this.wave_mod_am_depth), Long.valueOf(j));
        this.wave_mod_am_depth = j;
        notifyPropertyChanged(1041);
    }

    @Bindable
    public final long getWave_mod_fm_deviation() {
        return this.wave_mod_fm_deviation;
    }

    public final void setWave_mod_fm_deviation(long j) {
        log("chNum", Long.valueOf(this.wave_mod_fm_deviation), Long.valueOf(j));
        this.wave_mod_fm_deviation = j;
        notifyPropertyChanged(1043);
    }

    @Bindable
    public final long getBasic_offset() {
        return this.basic_offset;
    }

    public final void setBasic_offset(long j) {
        log("chNum", Long.valueOf(this.basic_offset), Long.valueOf(j));
        this.basic_offset = j;
        notifyPropertyChanged(80);
    }

    @Bindable
    public final int getBasic_high() {
        return this.basic_high;
    }

    public final void setBasic_high(int i) {
        log("chNum", Integer.valueOf(this.basic_high), Integer.valueOf(i));
        this.basic_high = i;
        notifyPropertyChanged(78);
    }

    @Bindable
    public final int getBasic_low() {
        return this.basic_low;
    }

    public final void setBasic_low(int i) {
        log("chNum", Integer.valueOf(this.basic_low), Integer.valueOf(i));
        this.basic_low = i;
        notifyPropertyChanged(79);
    }

    @Bindable
    public final int getBasic_phase() {
        return this.basic_phase;
    }

    public final void setBasic_phase(int i) {
        log("chNum", Integer.valueOf(this.basic_phase), Integer.valueOf(i));
        this.basic_phase = i;
        notifyPropertyChanged(83);
    }

    @Bindable
    public final int getBasic_squ_duty() {
        return this.basic_squ_duty;
    }

    public final void setBasic_squ_duty(int i) {
        log("chNum", Integer.valueOf(this.basic_squ_duty), Integer.valueOf(i));
        this.basic_squ_duty = i;
        notifyPropertyChanged(86);
    }

    @Bindable
    public final int getBasic_SYMM() {
        return this.basic_SYMM;
    }

    public final void setBasic_SYMM(int i) {
        log("chNum", Integer.valueOf(this.basic_SYMM), Integer.valueOf(i));
        this.basic_SYMM = i;
        notifyPropertyChanged(74);
    }

    @Bindable
    public final long getBasic_riseedge() {
        return this.basic_riseedge;
    }

    public final void setBasic_riseedge(long j) {
        log("chNum", Long.valueOf(this.basic_riseedge), Long.valueOf(j));
        this.basic_riseedge = j;
        notifyPropertyChanged(85);
    }

    @Bindable
    public final long getBasic_falledge() {
        return this.basic_falledge;
    }

    public final void setBasic_falledge(long j) {
        log("chNum", Long.valueOf(this.basic_falledge), Long.valueOf(j));
        this.basic_falledge = j;
        notifyPropertyChanged(76);
    }

    @Bindable
    public final int getBasic_pul_duty() {
        return this.basic_pul_duty;
    }

    public final void setBasic_pul_duty(int i) {
        log("chNum", Integer.valueOf(this.basic_pul_duty), Integer.valueOf(i));
        this.basic_pul_duty = i;
        notifyPropertyChanged(84);
    }

    @Bindable
    public final int getAfg_wave_mod_type() {
        return this.afg_wave_mod_type;
    }

    public final void setAfg_wave_mod_type(int i) {
        log("chNum", Integer.valueOf(this.afg_wave_mod_type), Integer.valueOf(i));
        this.afg_wave_mod_type = i;
        setWaveModPic();
        notifyPropertyChanged(41);
    }

    @Bindable
    public final int getAfg_wave_am_shape() {
        return this.afg_wave_am_shape;
    }

    public final void setAfg_wave_am_shape(int i) {
        log("chNum", Integer.valueOf(this.afg_wave_am_shape), Integer.valueOf(i));
        this.afg_wave_am_shape = i;
        notifyPropertyChanged(39);
    }

    @Bindable
    public final int getAfg_wave_fm_shape() {
        return this.afg_wave_fm_shape;
    }

    public final void setAfg_wave_fm_shape(int i) {
        log("chNum", Integer.valueOf(this.afg_wave_fm_shape), Integer.valueOf(i));
        this.afg_wave_fm_shape = i;
        notifyPropertyChanged(40);
    }

    @Bindable
    public final int getAfg_wave_pm_shape() {
        return this.afg_wave_pm_shape;
    }

    public final void setAfg_wave_pm_shape(int i) {
        log("chNum", Integer.valueOf(this.afg_wave_pm_shape), Integer.valueOf(i));
        this.afg_wave_pm_shape = i;
        notifyPropertyChanged(42);
    }

    @Bindable
    public final boolean getBasic_output_enable() {
        return this.basic_output_enable;
    }

    public final void setBasic_output_enable(boolean z) {
        log("chNum", Boolean.valueOf(this.basic_output_enable), Boolean.valueOf(z));
        this.basic_output_enable = z;
        notifyPropertyChanged(81);
    }

    @Bindable
    public final boolean getService_output_enable() {
        return this.service_output_enable;
    }

    public final void setService_output_enable(boolean z) {
        log("chNum", Boolean.valueOf(this.service_output_enable), Boolean.valueOf(z));
        this.service_output_enable = z;
        notifyPropertyChanged(812);
    }

    @Bindable
    public final int getWave_mod_pic() {
        return this.wave_mod_pic;
    }

    public final void setWave_mod_pic(int i) {
        log("chNum", Integer.valueOf(this.wave_mod_pic), Integer.valueOf(i));
        this.wave_mod_pic = i;
        notifyPropertyChanged(1045);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setWave_mod_pic(0);
        setService_output_enable(false);
        setBasic_output_enable(false);
        setAfg_wave_pm_shape(0);
        setAfg_wave_fm_shape(0);
        setAfg_wave_am_shape(0);
        setAfg_wave_mod_type(0);
        setAfg_wave_mod_type(0);
        setBasic_pul_duty(50000);
        setBasic_falledge(0L);
        setBasic_riseedge(0L);
        setBasic_SYMM(50);
        setBasic_squ_duty(50);
        setBasic_phase(0);
        setBasic_low(0);
        setBasic_high(0);
        setBasic_offset(0L);
        setWave_mod_fm_deviation(1000000000L);
        setWave_mod_am_depth(100L);
        setWave_mod_pm_freq(100000000L);
        setWave_mod_pm_dev(90000L);
        setWave_mod_fm_freq(100000000L);
        setWave_mod_am_freq(100000000L);
        setBasic_amp(5000000000L);
        setBasic_period(10000000000L);
        setBasic_freq(1000000000L);
        setMode_function(0);
        setWave_function(0);
        setWave_path("");
        setAttr_step_pos(1);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        super.readAll();
        readBasicPulDuty();
        readBasicFalledge();
        readBasicRiseedge();
        readBasicSymm();
        readBasicSquDuty();
        readBasicPhase();
        readBasicLow();
        readBasicHigh();
        readOffset();
        readBasicamp();
        readBasicPeriod();
        readBasicFreq();
        readModeFunction();
        readWaveFunction();
        readOffsetAttr();
        readBasicampAttr();
        readBasicFreqAttr();
        readBasicHighAttr();
        readBasicFalledgeAttr();
        readBasicLowAttr();
        readBasicPhaseAttr();
        readBasicRiseedgeAttr();
        readBasicSquDutyAttr();
        readBasicSymmAttr();
        readBasicPulDutyAttr();
        readBasicOutputEnable();
        readAfgWaveModType();
        readAfgWaveAmShape();
        readWaveModAmFreq();
        readWaveModAmDepth();
        readWaveModPmFreq();
        readWaveModFmFreq();
        readWaveModFmDeviation();
        readWaveModPmDev();
        readAfgModPmDev();
        readAfgWaveFmShape();
        readAfgWavePmShape();
        readServiceOutputEnable();
        readWaveModFmDeviationAttr();
        readWaveModAmDepthAttr();
        readWaveModPmFreqAttr();
        readWaveModAmFreqArrt();
    }

    public final boolean readServiceOutputEnable() {
        setService_output_enable(API.getInstance().UI_QueryBool(65, 337));
        return this.service_output_enable;
    }

    public final void saveServiceOutputEnable(boolean z) {
        setService_output_enable(z);
        API.getInstance().UI_PostBool(65, 337, z);
    }

    public final long readWaveModPmDev() {
        setWave_mod_pm_dev(API.getInstance().UI_QueryInt64(68, 346));
        return this.wave_mod_pm_dev;
    }

    public final void saveWaveModPmDev(long j) {
        setWave_mod_pm_dev(j);
        API.getInstance().UI_PostInt64(68, 346, j);
    }

    public final long readWaveModFmDeviation() {
        setWave_mod_fm_deviation(API.getInstance().UI_QueryInt64(67, 343));
        return this.wave_mod_fm_deviation;
    }

    public final void readWaveModFmDeviationAttr() {
        API.getInstance().UI_QueryAttr(67, 343, this.afg_wave_fm_devAttr);
    }

    public final void saveWavePath(String wave_path) {
        Intrinsics.checkNotNullParameter(wave_path, "wave_path");
        setWave_path(wave_path);
        saveStr(317, wave_path);
    }

    public final void saveWaveModFmDeviation(long j) {
        setWave_mod_fm_deviation(j);
        API.getInstance().UI_PostInt64(67, 343, j);
    }

    public final long readWaveModAmDepth() {
        setWave_mod_am_depth(API.getInstance().UI_QueryInt64(66, 339) / 1000);
        return this.wave_mod_am_depth;
    }

    public final void saveWaveModAmDepth(long j) {
        setWave_mod_am_depth(j);
        API.getInstance().UI_PostInt64(66, 339, j * 1000);
    }

    public final void readWaveModAmDepthAttr() {
        API.getInstance().UI_QueryAttr(66, 339, this.afg_wave_range_depthAttr);
    }

    public final long readWaveModAmFreq() {
        setWave_mod_am_freq(API.getInstance().UI_QueryInt64(66, 341));
        return this.wave_mod_am_freq;
    }

    public final void readWaveModAmFreqArrt() {
        API.getInstance().UI_QueryAttr(66, 341, this.afg_wave_am_freqAttr);
    }

    public final void saveWaveModAmFreq(long j) {
        setWave_mod_am_freq(j);
        API.getInstance().UI_PostInt64(66, 341, j);
    }

    public final long readWaveModFmFreq() {
        setWave_mod_fm_freq(API.getInstance().UI_QueryInt64(67, 344));
        return this.wave_mod_fm_freq;
    }

    public final void saveWaveModFmFreq(long j) {
        setWave_mod_fm_freq(j);
        API.getInstance().UI_PostInt64(67, 344, j);
    }

    public final long readWaveModPmFreq() {
        setWave_mod_pm_freq(API.getInstance().UI_QueryInt64(68, 347));
        return this.wave_mod_pm_freq;
    }

    public final void readWaveModPmFreqAttr() {
        API.getInstance().UI_QueryAttr(68, 347, this.afg_wave_pm_freqAttr);
    }

    public final void saveWaveModPmFreq(long j) {
        setWave_mod_pm_freq(j);
        API.getInstance().UI_PostInt64(68, 347, j);
    }

    public final int readAfgWaveAmShape() {
        setAfg_wave_am_shape(API.getInstance().UI_QueryInt32(66, 342));
        setWaveModPic();
        return this.afg_wave_am_shape;
    }

    public final void saveAfgWaveAmShape(int i) {
        setAfg_wave_am_shape(i);
        setWaveModPic();
        API.getInstance().UI_PostInt32(66, 342, i);
    }

    public final int readAfgWaveFmShape() {
        setAfg_wave_fm_shape(API.getInstance().UI_QueryInt32(67, 345));
        setWaveModPic();
        return this.afg_wave_fm_shape;
    }

    public final void saveAfgWaveFmShape(int i) {
        setAfg_wave_fm_shape(i);
        setWaveModPic();
        API.getInstance().UI_PostInt32(67, 345, i);
    }

    public final int readAfgWavePmShape() {
        setAfg_wave_pm_shape(API.getInstance().UI_QueryInt32(68, 348));
        setWaveModPic();
        return this.afg_wave_pm_shape;
    }

    public final void saveAfgWavePmShape(int i) {
        setAfg_wave_pm_shape(i);
        setWaveModPic();
        API.getInstance().UI_PostInt32(68, 348, i);
    }

    public final int readAfgWaveModType() {
        setAfg_wave_mod_type(API.getInstance().UI_QueryInt32(65, 338));
        return this.afg_wave_mod_type;
    }

    public final void saveAfgWaveModType(int i) {
        setAfg_wave_mod_type(i);
        setWaveModPic();
        API.getInstance().UI_PostInt32(65, 338, i);
    }

    public final int readBasicPulDuty() {
        setBasic_pul_duty(readInt(335) / 1000);
        return this.basic_pul_duty;
    }

    public final boolean readBasicOutputEnable() {
        setBasic_output_enable(API.getInstance().UI_QueryBool(63, 327));
        if (this.basic_output_enable) {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G1_LED_WHITE.value1, 1);
        } else {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G1_LED_WHITE.value1, 0);
        }
        return this.basic_output_enable;
    }

    public final void saveBasicOutputEnable(boolean z) {
        setBasic_output_enable(z);
        API.getInstance().UI_PostBool(63, 327, z);
        if (z) {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G1_LED_WHITE.value1, 1);
        } else {
            API.getInstance().UI_PostInt32Int32(11, MessageID.MSG_APP_UTILITY_LED, ServiceEnum.PanelLed.G1_LED_WHITE.value1, 0);
        }
    }

    public final void readBasicPulDutyAttr() {
        readAttr(335, this.basic_pul_dutyAttr);
    }

    public final void readAfgModPmDev() {
        API.getInstance().UI_QueryAttr(68, 346, this.afg_mod_pm_devAtty);
    }

    public final void saveBasicPulDuty(int i) {
        setBasic_pul_duty(i);
        saveInt(335, i * 1000);
    }

    public final long readBasicFalledge() {
        setBasic_falledge(readLong(274));
        return this.basic_falledge;
    }

    public final void readBasicFalledgeAttr() {
        readAttr(274, this.basic_falledgeAttr);
    }

    public final void saveBasicFalledge(long j) {
        setBasic_falledge(j);
        saveLong(274, j);
    }

    public final long readBasicRiseedge() {
        setBasic_riseedge(readLong(273));
        return this.basic_riseedge;
    }

    public final void readBasicRiseedgeAttr() {
        readAttr(273, this.basic_riseedgeAttr);
    }

    public final void saveBasicRiseedge(long j) {
        setBasic_riseedge(j);
        saveLong(273, j);
    }

    public final int readBasicSymm() {
        setBasic_SYMM(readInt(334) / 1000);
        return this.basic_SYMM;
    }

    public final void readBasicSymmAttr() {
        readAttr(334, this.basic_SYMMAttr);
    }

    public final void saveBasicSymm(int i) {
        setBasic_SYMM(i);
        saveInt(334, i * 1000);
    }

    public final int readBasicSquDuty() {
        setBasic_squ_duty(readInt(336) / 1000);
        return this.basic_squ_duty;
    }

    public final void readBasicSquDutyAttr() {
        readAttr(336, this.basic_squ_dutyAttr);
    }

    public final void saveBasicSquDuty(int i) {
        setBasic_squ_duty(i);
        saveInt(336, i * 1000);
    }

    public final int readBasicPhase() {
        setBasic_phase(readInt(331));
        return this.basic_phase;
    }

    public final void saveBasicPhase(int i) {
        setBasic_phase(i);
        saveInt(331, i);
    }

    public final void readBasicPhaseAttr() {
        readAttr(331, this.basic_phaseAttr);
    }

    public final int readBasicLow() {
        setBasic_low(readInt(276));
        return this.basic_low;
    }

    public final void readBasicLowAttr() {
        readAttr(276, this.basic_lowAttr);
    }

    public final void saveBasicLow(int i) {
        setBasic_low(i);
        saveInt(276, i);
    }

    public final int readBasicHigh() {
        setBasic_high(readInt(275));
        return this.basic_high;
    }

    public final void readBasicHighAttr() {
        readAttr(275, this.basic_highAttr);
    }

    public final void saveBasicHigh(int i) {
        setBasic_high(i);
        saveInt(275, i);
    }

    public final void readOffsetAttr() {
        readAttr(333, this.basic_offsetAttr);
    }

    public final long readOffset() {
        setBasic_offset(readLong(333));
        return this.basic_offset;
    }

    public final void saveOffset(long j) {
        setBasic_offset(j);
        saveLong(333, j);
    }

    public final void readBasicampAttr() {
        readAttr(332, this.basic_amp_freqAttr);
    }

    public final long readBasicamp() {
        setBasic_amp(readLong(332));
        return this.basic_amp;
    }

    public final void saveBasicamp(long j) {
        setBasic_amp(j);
        saveLong(332, j);
    }

    public final long readBasicPeriod() {
        setBasic_period(readLong(312));
        return this.basic_period;
    }

    public final void saveBasicPeriod(long j) {
        setBasic_period(j);
        saveLong(312, j);
    }

    public final void readBasicFreqAttr() {
        readAttr(330, this.basic_freqAttr);
    }

    public final long readBasicFreq() {
        setBasic_freq(readLong(330));
        readBasicFreqAttr();
        return this.basic_freq;
    }

    public final void saveBasicFreq(long j) {
        setBasic_freq(j);
        saveLong(330, j);
    }

    public final void saveAttrStepPos() {
        if (this.attr_step_pos == 1) {
            setAttr_step_pos(2);
        } else {
            setAttr_step_pos(1);
        }
        saveInt(349, this.attr_step_pos);
    }

    public final int readWaveFunction() {
        setWave_function(API.getInstance().UI_QueryInt32(63, 329));
        return this.wave_function;
    }

    public final void saveWaveFunction(int i) {
        setWave_function(i);
        LogUtils.e("wave_function", Integer.valueOf(i));
        setWaveModPic();
        API.getInstance().UI_PostInt32(63, 329, i);
        readBasicFreqAttr();
    }

    public final int readModeFunction() {
        setMode_function(readInt(256));
        return this.mode_function;
    }

    public final void saveModeFunction(int i) {
        setMode_function(i);
        API.getInstance().UI_PostInt32(63, 256, i);
    }

    public final void setWaveModPic() {
        int i = this.afg_wave_mod_type;
        if (i == 0) {
            setWave_mod_pic((i * 18) + (this.wave_function * 6) + this.afg_wave_am_shape);
        } else if (i == 1) {
            setWave_mod_pic((i * 18) + (this.wave_function * 6) + this.afg_wave_fm_shape);
        } else {
            setWave_mod_pic((i * 18) + (this.wave_function * 6) + this.afg_wave_pm_shape);
        }
    }
}
