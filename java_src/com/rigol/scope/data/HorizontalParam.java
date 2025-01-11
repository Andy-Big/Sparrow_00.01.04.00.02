package com.rigol.scope.data;

import android.app.Activity;
import androidx.databinding.Bindable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.OffsetUtil;
import com.rigol.scope.utilities.ScaleNumUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.viewmodels.JitterViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: HorizontalParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0010\u0002\n\u0002\bS\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0019\u0010Ë\u0001\u001a\u00020\u00102\u0007\u0010Ì\u0001\u001a\u00020\u00102\u0007\u0010Í\u0001\u001a\u00020\u0010J\u0019\u0010Î\u0001\u001a\u00020\u00102\u0007\u0010Ì\u0001\u001a\u00020\u00102\u0007\u0010Í\u0001\u001a\u00020\u0010J\u0018\u0010Ï\u0001\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0007\u0010Í\u0001\u001a\u00020\u0010J\u0018\u0010Ð\u0001\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00102\u0007\u0010Í\u0001\u001a\u00020\u0010J\u0010\u0010Ñ\u0001\u001a\u00020\"2\u0007\u0010Ò\u0001\u001a\u00020\"J\u0010\u0010Ó\u0001\u001a\u00020\"2\u0007\u0010Ò\u0001\u001a\u00020\"J\u0010\u0010Ô\u0001\u001a\u00020\"2\u0007\u0010Ò\u0001\u001a\u00020\"J\u0010\u0010Õ\u0001\u001a\u00020\"2\u0007\u0010Ò\u0001\u001a\u00020\"J\u0007\u0010Ö\u0001\u001a\u00020/J\u0011\u0010×\u0001\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\"J\u0011\u0010Ú\u0001\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\"J\"\u0010Û\u0001\u001a\u00020\"2\u0007\u0010Ò\u0001\u001a\u00020\"2\u0007\u0010Ù\u0001\u001a\u00020\"2\u0007\u0010Í\u0001\u001a\u00020\u0010J\"\u0010Ü\u0001\u001a\u00020\"2\u0007\u0010Ò\u0001\u001a\u00020\"2\u0007\u0010Ù\u0001\u001a\u00020\"2\u0007\u0010Í\u0001\u001a\u00020\u0010J\b\u0010Ý\u0001\u001a\u00030Ø\u0001J\u0007\u0010Þ\u0001\u001a\u00020\u0004J\n\u0010ß\u0001\u001a\u00030Ø\u0001H\u0016J\u0007\u0010à\u0001\u001a\u00020/J\u0007\u0010á\u0001\u001a\u00020\u0010J\u0007\u0010â\u0001\u001a\u00020\u001cJ\u0007\u0010ã\u0001\u001a\u00020\"J\u0007\u0010ä\u0001\u001a\u00020\u0010J\u0007\u0010å\u0001\u001a\u00020\"J\u0007\u0010æ\u0001\u001a\u00020\"J\u0007\u0010ç\u0001\u001a\u000203J\u0007\u0010è\u0001\u001a\u00020\u0010J\b\u0010é\u0001\u001a\u00030Ø\u0001J\u0007\u0010ê\u0001\u001a\u00020/J\u0007\u0010ë\u0001\u001a\u00020/J\u0007\u0010ì\u0001\u001a\u00020/J\u0007\u0010í\u0001\u001a\u00020IJ\u0007\u0010î\u0001\u001a\u00020OJ\u0007\u0010ï\u0001\u001a\u00020\"J\b\u0010ð\u0001\u001a\u00030Ø\u0001J\u0007\u0010ñ\u0001\u001a\u00020\"J\b\u0010ò\u0001\u001a\u00030Ø\u0001J\u0007\u0010ó\u0001\u001a\u00020\"J\b\u0010ô\u0001\u001a\u00030Ø\u0001J\u0007\u0010õ\u0001\u001a\u00020\"J\b\u0010ö\u0001\u001a\u00030Ø\u0001J\u0007\u0010÷\u0001\u001a\u00020\"J\b\u0010ø\u0001\u001a\u00030Ø\u0001J\u0007\u0010ù\u0001\u001a\u00020\u0010J\b\u0010ú\u0001\u001a\u00030\u0083\u0001J\u0007\u0010û\u0001\u001a\u00020\"J\u0007\u0010ü\u0001\u001a\u00020\"J\b\u0010ý\u0001\u001a\u00030Ø\u0001J\u0007\u0010þ\u0001\u001a\u00020\"J\b\u0010ÿ\u0001\u001a\u00030Ø\u0001J\u0007\u0010\u0080\u0002\u001a\u00020/J\b\u0010\u0081\u0002\u001a\u00030\u009e\u0001J\u0007\u0010\u0082\u0002\u001a\u00020\"J\b\u0010\u0083\u0002\u001a\u00030Ø\u0001J\b\u0010\u0084\u0002\u001a\u00030ª\u0001J\u0007\u0010\u0085\u0002\u001a\u00020/J\u0007\u0010\u0086\u0002\u001a\u00020\"J\b\u0010\u0087\u0002\u001a\u00030Ø\u0001J\u0007\u0010\u0088\u0002\u001a\u00020\"J\b\u0010\u0089\u0002\u001a\u00030Ø\u0001J\n\u0010\u008a\u0002\u001a\u00030Ø\u0001H\u0016J\u0012\u0010\u008b\u0002\u001a\u00030Ø\u00012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u0010\u0010\u008c\u0002\u001a\u00030Ø\u00012\u0006\u0010U\u001a\u00020/J\u0010\u0010\u008d\u0002\u001a\u00030Ø\u00012\u0006\u0010\u0011\u001a\u00020\u0010J\u0011\u0010\u008e\u0002\u001a\u00030Ø\u00012\u0007\u0010\u008c\u0001\u001a\u00020/J\u0010\u0010\u008f\u0002\u001a\u00030Ø\u00012\u0006\u0010\u001d\u001a\u00020\u001cJ\u0010\u0010\u0090\u0002\u001a\u00030Ø\u00012\u0006\u0010(\u001a\u00020\u0010J\u0010\u0010\u0091\u0002\u001a\u00030Ø\u00012\u0006\u00100\u001a\u00020\"J\u0010\u0010\u0092\u0002\u001a\u00030Ø\u00012\u0006\u00104\u001a\u000203J\u0010\u0010\u0093\u0002\u001a\u00030Ø\u00012\u0006\u00109\u001a\u00020\u0010J\u0010\u0010\u0094\u0002\u001a\u00030Ø\u00012\u0006\u0010A\u001a\u00020/J\u0010\u0010\u0095\u0002\u001a\u00030Ø\u00012\u0006\u0010F\u001a\u00020/J\u0011\u0010\u0096\u0002\u001a\u00030Ø\u00012\u0007\u0010\u0097\u0002\u001a\u00020/J\u0010\u0010\u0098\u0002\u001a\u00030Ø\u00012\u0006\u0010J\u001a\u00020IJ\u0011\u0010\u0099\u0002\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\"J\u0011\u0010\u009a\u0002\u001a\u00030Ø\u00012\u0007\u0010Ò\u0001\u001a\u00020\"J\u0010\u0010\u009b\u0002\u001a\u00030Ø\u00012\u0006\u0010n\u001a\u00020\"J\u0011\u0010\u009c\u0002\u001a\u00030Ø\u00012\u0007\u0010\u009d\u0002\u001a\u00020\"J\u0011\u0010\u009e\u0002\u001a\u00030Ø\u00012\u0007\u0010\u009f\u0002\u001a\u00020\"J\u0011\u0010 \u0002\u001a\u00030Ø\u00012\u0007\u0010\u0080\u0001\u001a\u00020\u0010J\u0012\u0010¡\u0002\u001a\u00030Ø\u00012\b\u0010\u0084\u0001\u001a\u00030\u0083\u0001J\u0011\u0010¢\u0002\u001a\u00030Ø\u00012\u0007\u0010\u009d\u0002\u001a\u00020\"J\u0011\u0010£\u0002\u001a\u00030Ø\u00012\u0007\u0010\u009f\u0002\u001a\u00020\"J\u0011\u0010¤\u0002\u001a\u00030Ø\u00012\u0007\u0010¤\u0001\u001a\u00020\"J\u0012\u0010¥\u0002\u001a\u00030Ø\u00012\b\u0010«\u0001\u001a\u00030ª\u0001J\u0011\u0010¦\u0002\u001a\u00030Ø\u00012\u0007\u0010§\u0002\u001a\u00020/J\u0011\u0010¨\u0002\u001a\u00030Ø\u00012\u0007\u0010Ù\u0001\u001a\u00020\"J\u0011\u0010©\u0002\u001a\u00030Ø\u00012\u0007\u0010Ò\u0001\u001a\u00020\"J\b\u0010ª\u0002\u001a\u00030Ø\u0001R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR&\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0003\u001a\u00020\u001c8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R&\u0010#\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R&\u0010(\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0013\"\u0004\b*\u0010\u0015R&\u0010+\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R&\u00100\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010%\"\u0004\b2\u0010'R&\u00104\u001a\u0002032\u0006\u0010\u0003\u001a\u0002038G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R&\u00109\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0013\"\u0004\b;\u0010\u0015R\u001a\u0010<\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u0019\"\u0004\b>\u0010\u001bR\u0010\u0010?\u001a\u0004\u0018\u00010@X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010A\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER&\u0010F\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010C\"\u0004\bH\u0010ER&\u0010J\u001a\u00020I2\u0006\u0010\u0003\u001a\u00020I8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR&\u0010P\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020O8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010TR&\u0010U\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010C\"\u0004\bV\u0010ER&\u0010W\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010C\"\u0004\bX\u0010ER&\u0010Y\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010C\"\u0004\bZ\u0010ER&\u0010[\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010C\"\u0004\b\\\u0010ER\u0010\u0010]\u001a\u0004\u0018\u00010^X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010_\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010%\"\u0004\ba\u0010'R\u001a\u0010b\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\u0019\"\u0004\bd\u0010\u001bR&\u0010e\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020O8G@BX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010R\"\u0004\bg\u0010TR&\u0010h\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010%\"\u0004\bj\u0010'R\u001a\u0010k\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0019\"\u0004\bm\u0010\u001bR&\u0010n\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010%\"\u0004\bp\u0010'R\u001a\u0010q\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0019\"\u0004\bs\u0010\u001bR&\u0010t\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010%\"\u0004\bv\u0010'R\u001a\u0010w\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0019\"\u0004\by\u0010\u001bR&\u0010z\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010%\"\u0004\b|\u0010'R\u001a\u0010}\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0019\"\u0004\b\u007f\u0010\u001bR)\u0010\u0080\u0001\u001a\u00020\u00102\u0006\u0010\u0003\u001a\u00020\u00108G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0013\"\u0005\b\u0082\u0001\u0010\u0015R-\u0010\u0084\u0001\u001a\u00030\u0083\u00012\u0007\u0010\u0003\u001a\u00030\u0083\u00018G@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001\"\u0006\b\u0087\u0001\u0010\u0088\u0001R)\u0010\u0089\u0001\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010%\"\u0005\b\u008b\u0001\u0010'R)\u0010\u008c\u0001\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010C\"\u0005\b\u008e\u0001\u0010ER)\u0010\u008f\u0001\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010%\"\u0005\b\u0091\u0001\u0010'R\u001d\u0010\u0092\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0019\"\u0005\b\u0094\u0001\u0010\u001bR)\u0010\u0095\u0001\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010%\"\u0005\b\u0097\u0001\u0010'R\u001d\u0010\u0098\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\u0019\"\u0005\b\u009a\u0001\u0010\u001bR\u001d\u0010\u009b\u0001\u001a\u00020/X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010C\"\u0005\b\u009d\u0001\u0010ER-\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u0003\u001a\u00030\u009e\u00018G@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R)\u0010¤\u0001\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¥\u0001\u0010%\"\u0005\b¦\u0001\u0010'R\u001d\u0010§\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¨\u0001\u0010\u0019\"\u0005\b©\u0001\u0010\u001bR-\u0010«\u0001\u001a\u00030ª\u00012\u0007\u0010\u0003\u001a\u00030ª\u00018G@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010\u00ad\u0001\"\u0006\b®\u0001\u0010¯\u0001R)\u0010°\u0001\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b±\u0001\u0010C\"\u0005\b²\u0001\u0010ER)\u0010³\u0001\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b´\u0001\u0010C\"\u0005\bµ\u0001\u0010ER)\u0010¶\u0001\u001a\u00020/2\u0006\u0010\u0003\u001a\u00020/8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b·\u0001\u0010C\"\u0005\b¸\u0001\u0010ER)\u0010¹\u0001\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bº\u0001\u0010%\"\u0005\b»\u0001\u0010'R\u001d\u0010¼\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b½\u0001\u0010\u0019\"\u0005\b¾\u0001\u0010\u001bR)\u0010¿\u0001\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020O8G@BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÀ\u0001\u0010R\"\u0005\bÁ\u0001\u0010TR)\u0010Â\u0001\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÃ\u0001\u0010%\"\u0005\bÄ\u0001\u0010'R\u001d\u0010Å\u0001\u001a\u00020\u0017X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÆ\u0001\u0010\u0019\"\u0005\bÇ\u0001\u0010\u001bR)\u0010È\u0001\u001a\u00020O2\u0006\u0010\u0003\u001a\u00020O8G@BX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\bÉ\u0001\u0010R\"\u0005\bÊ\u0001\u0010T¨\u0006«\u0002"}, d2 = {"Lcom/rigol/scope/data/HorizontalParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "Lcom/rigol/scope/cil/ServiceEnum$AcquireMode;", "acquireMode", "getAcquireMode", "()Lcom/rigol/scope/cil/ServiceEnum$AcquireMode;", "setAcquireMode", "(Lcom/rigol/scope/cil/ServiceEnum$AcquireMode;)V", "aorBManager", "Lcom/rigol/scope/utilities/AorBManager;", "getAorBManager", "()Lcom/rigol/scope/utilities/AorBManager;", "setAorBManager", "(Lcom/rigol/scope/utilities/AorBManager;)V", "", "avgTimes", "getAvgTimes", "()I", "setAvgTimes", "(I)V", "avgTimesAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getAvgTimesAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "setAvgTimesAttr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "Lcom/rigol/scope/cil/ServiceEnum$AcquireDepth;", "depth", "getDepth", "()Lcom/rigol/scope/cil/ServiceEnum$AcquireDepth;", "setDepth", "(Lcom/rigol/scope/cil/ServiceEnum$AcquireDepth;)V", "", "depthValue", "getDepthValue", "()J", "setDepthValue", "(J)V", "displayMode", "getDisplayMode", "setDisplayMode", "dotTime", "getDotTime", "setDotTime", "enableToSetOffset", "", "expandGnd", "getExpandGnd", "setExpandGnd", "Lcom/rigol/scope/cil/ServiceEnum$HorizontalExpand;", "expandMode", "getExpandMode", "()Lcom/rigol/scope/cil/ServiceEnum$HorizontalExpand;", "setExpandMode", "(Lcom/rigol/scope/cil/ServiceEnum$HorizontalExpand;)V", "expandUser", "getExpandUser", "setExpandUser", "expandUserAttr", "getExpandUserAttr", "setExpandUserAttr", "eyeParam", "Lcom/rigol/scope/data/EyeParam;", "filter1", "getFilter1", "()Z", "setFilter1", "(Z)V", "filter2", "getFilter2", "setFilter2", "Lcom/rigol/scope/cil/ServiceEnum$HighResBit;", "highBit", "getHighBit", "()Lcom/rigol/scope/cil/ServiceEnum$HighResBit;", "setHighBit", "(Lcom/rigol/scope/cil/ServiceEnum$HighResBit;)V", "", "highBw", "getHighBw", "()Ljava/lang/String;", "setHighBw", "(Ljava/lang/String;)V", "isAntiAliasing", "setAntiAliasing", "isDepthEn", "setDepthEn", "isFine", "setFine", "isZoom", "setZoom", "jitterParam", "Lcom/rigol/scope/data/JitterParam;", "mainOffset", "getMainOffset", "setMainOffset", "mainOffsetAttr", "getMainOffsetAttr", "setMainOffsetAttr", "mainOffsetStr", "getMainOffsetStr", "setMainOffsetStr", "mainScale", "getMainScale", "setMainScale", "mainScaleAttr", "getMainScaleAttr", "setMainScaleAttr", "maxFrame", "getMaxFrame", "setMaxFrame", "maxFrameAttr", "getMaxFrameAttr", "setMaxFrameAttr", "memEnd", "getMemEnd", "setMemEnd", "memEndAttr", "getMemEndAttr", "setMemEndAttr", "memStart", "getMemStart", "setMemStart", "memStartAttr", "getMemStartAttr", "setMemStartAttr", "roll", "getRoll", "setRoll", "Lcom/rigol/scope/cil/ServiceEnum$ControlAction;", "runStop", "getRunStop", "()Lcom/rigol/scope/cil/ServiceEnum$ControlAction;", "setRunStop", "(Lcom/rigol/scope/cil/ServiceEnum$ControlAction;)V", "sample", "getSample", "setSample", "sapmassa", "getSapmassa", "setSapmassa", "scrEnd", "getScrEnd", "setScrEnd", "scrEndAttr", "getScrEndAttr", "setScrEndAttr", "scrStart", "getScrStart", "setScrStart", "scrStartAttr", "getScrStartAttr", "setScrStartAttr", "showDepth", "getShowDepth", "setShowDepth", "Lcom/rigol/scope/cil/ServiceEnum$HoriTimeMode;", "timeMode", "getTimeMode", "()Lcom/rigol/scope/cil/ServiceEnum$HoriTimeMode;", "setTimeMode", "(Lcom/rigol/scope/cil/ServiceEnum$HoriTimeMode;)V", "timeOut", "getTimeOut", "setTimeOut", "timeOutAttr", "getTimeOutAttr", "setTimeOutAttr", "Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;", "triggerStatus", "getTriggerStatus", "()Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;", "setTriggerStatus", "(Lcom/rigol/scope/cil/ServiceEnum$ControlStatus;)V", "ultraEnable", "getUltraEnable", "setUltraEnable", "xyCheck", "getXyCheck", "setXyCheck", "xyCheckEnable", "getXyCheckEnable", "setXyCheckEnable", "zoomOffset", "getZoomOffset", "setZoomOffset", "zoomOffsetAttr", "getZoomOffsetAttr", "setZoomOffsetAttr", "zoomOffsetStr", "getZoomOffsetStr", "setZoomOffsetStr", "zoomScale", "getZoomScale", "setZoomScale", "zoomScaleAttr", "getZoomScaleAttr", "setZoomScaleAttr", "zoomScaleStr", "getZoomScaleStr", "setZoomScaleStr", "avgDown", "avg", "repeatCount", "avgUp", "expandUserDown", "expandUserUp", "getLowerScale", "scale", "getScaleLager", "getScaleSmaller", "getUpperSclae", "getZoomEnable", "moveMainOffset", "", "offset", "moveZoomOffset", "offsetLarger", "offsetSmaller", "readAcquireAvgTimesAttr", "readAcquireMode", "readAll", "readAntiAliasing", "readAvgTimes", "readDepth", "readDepthValue", "readDisplayMode", "readDotTime", "readExpandGnd", "readExpandMode", "readExpandUser", "readExpandUserAttr", "readFilter1", "readFilter2", "readFine", "readHighBit", "readHighBw", "readMainOffset", "readMainOffsetAttr", "readMainScale", "readMainScaleAttr", "readMaxFrame", "readMaxFrameAttr", "readMemEnd", "readMemEndAttr", "readMemStart", "readMemStartAttr", "readRoll", "readRunStop", "readSample", "readScrEnd", "readScrEndAttr", "readScrStart", "readScrStartAttr", "readShowDepth", "readTimeMode", "readTimeOut", "readTimeeOutAttr", "readTriggerStatus", "readZoom", "readZoomOffset", "readZoomOffsetAttr", "readZoomScale", "readZoomScaleAttr", "reset", "saveAcquireMode", "saveAntiAliasing", "saveAvgTimes", "saveDelaySample", "saveDepth", "saveDisplay", "saveExpandGnd", "saveExpandMode", "saveExpandUser", "saveFilter1", "saveFilter2", "saveFine", "fine", "saveHighBits", "saveMainOffset", "saveMainScale", "saveMaxFrame", "saveMemEnd", "end", "saveMemStart", "start", "saveRoll", "saveRunStop", "saveScrEnd", "saveScrStart", "saveTimeOut", "saveTriggerStatus", "saveZoom", "zoom", "saveZoomOffset", "saveZoomScale", "updateDepthEn", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class HorizontalParam extends BaseParam {
    private ServiceEnum.AcquireMode acquireMode;
    public AorBManager aorBManager;
    private int avgTimes;
    private MessageAttr avgTimesAttr;
    private ServiceEnum.AcquireDepth depth;
    private long depthValue;
    private int displayMode;
    private long dotTime;
    private boolean enableToSetOffset;
    private long expandGnd;
    private ServiceEnum.HorizontalExpand expandMode;
    private int expandUser;
    private MessageAttr expandUserAttr;
    private EyeParam eyeParam;
    private boolean filter1;
    private boolean filter2;
    private ServiceEnum.HighResBit highBit;
    private String highBw;
    private boolean isAntiAliasing;
    private boolean isDepthEn;
    private boolean isFine;
    private boolean isZoom;
    private JitterParam jitterParam;
    private long mainOffset;
    private MessageAttr mainOffsetAttr;
    private String mainOffsetStr;
    private long mainScale;
    private MessageAttr mainScaleAttr;
    private long maxFrame;
    private MessageAttr maxFrameAttr;
    private long memEnd;
    private MessageAttr memEndAttr;
    private long memStart;
    private MessageAttr memStartAttr;
    private int roll;
    private ServiceEnum.ControlAction runStop;
    private long sample;
    private boolean sapmassa;
    private long scrEnd;
    private MessageAttr scrEndAttr;
    private long scrStart;
    private MessageAttr scrStartAttr;
    private boolean showDepth;
    private ServiceEnum.HoriTimeMode timeMode;
    private long timeOut;
    private MessageAttr timeOutAttr;
    private ServiceEnum.ControlStatus triggerStatus;
    private boolean ultraEnable;
    private boolean xyCheck;
    private boolean xyCheckEnable;
    private long zoomOffset;
    private MessageAttr zoomOffsetAttr;
    private String zoomOffsetStr;
    private long zoomScale;
    private MessageAttr zoomScaleAttr;
    private String zoomScaleStr;

    public HorizontalParam() {
        super(10);
        boolean z;
        long j;
        long j2;
        long j3;
        long j4;
        ServiceEnum.AcquireMode acquireMode;
        float f;
        float f2;
        ServiceEnum.AcquireDepth acquireDepth;
        ServiceEnum.HorizontalExpand horizontalExpand;
        int i;
        ServiceEnum.HighResBit highResBit;
        ServiceEnum.ControlAction controlAction;
        ServiceEnum.ControlStatus controlStatus;
        ServiceEnum.HoriTimeMode horiTimeMode;
        boolean z2;
        boolean z3;
        LiveData<EyeParam> liveData;
        LiveData<JitterParam> liveData2;
        z = HorizontalParamKt.DEFAULT_ULTRA_ENABLE;
        this.ultraEnable = z;
        j = HorizontalParamKt.DEFAULT_DEPTH_MEM_START;
        this.memStart = j;
        j2 = HorizontalParamKt.DEFAULT_DEPTH_MEM_END;
        this.memEnd = j2;
        j3 = HorizontalParamKt.DEFAULT_DEPTH_SCR_START;
        this.scrStart = j3;
        j4 = HorizontalParamKt.DEFAULT_DEPTH_SCR_END;
        this.scrEnd = j4;
        acquireMode = HorizontalParamKt.DEFAULT_ACQUIRE_MODE;
        this.acquireMode = acquireMode;
        f = HorizontalParamKt.DEFAULT_MAIN_SCALE;
        this.mainScale = f;
        this.mainOffsetStr = "";
        f2 = HorizontalParamKt.DEFAULT_ZOOM_SCALE;
        this.zoomScale = f2;
        this.zoomScaleStr = "";
        this.zoomOffsetStr = "";
        this.avgTimes = 2;
        this.depthValue = 10000L;
        acquireDepth = HorizontalParamKt.DEFAULT_DEPTH;
        this.depth = acquireDepth;
        this.sample = 4000000000L;
        this.dotTime = 250.0f;
        horizontalExpand = HorizontalParamKt.DEFAULT_EXPANDMODE;
        this.expandMode = horizontalExpand;
        i = HorizontalParamKt.DEFAULT_ROLL;
        this.roll = i;
        highResBit = HorizontalParamKt.DEFAULT_HIGHBIT;
        this.highBit = highResBit;
        this.highBw = "";
        controlAction = HorizontalParamKt.DEFAULT_RUNSTOP;
        this.runStop = controlAction;
        controlStatus = HorizontalParamKt.DEFAULT_TRIGGERSTATUS;
        this.triggerStatus = controlStatus;
        this.filter1 = true;
        this.filter2 = true;
        horiTimeMode = HorizontalParamKt.DEFAULT_TIMEMODE;
        this.timeMode = horiTimeMode;
        this.isDepthEn = true;
        z2 = HorizontalParamKt.DEFAULT_XY_CHECK;
        this.xyCheck = z2;
        z3 = HorizontalParamKt.DEFAULT_XY_CHECK_ENABLE;
        this.xyCheckEnable = z3;
        this.memStartAttr = new MessageAttr();
        this.memEndAttr = new MessageAttr();
        this.scrStartAttr = new MessageAttr();
        this.scrEndAttr = new MessageAttr();
        this.mainScaleAttr = new MessageAttr();
        this.mainOffsetAttr = new MessageAttr();
        this.zoomScaleAttr = new MessageAttr();
        this.zoomOffsetAttr = new MessageAttr();
        this.expandUserAttr = new MessageAttr();
        this.avgTimesAttr = new MessageAttr();
        this.maxFrameAttr = new MessageAttr();
        this.timeOutAttr = new MessageAttr();
        this.enableToSetOffset = true;
        JitterViewModel jitterViewModel = (JitterViewModel) ContextUtil.getAppViewModel(JitterViewModel.class);
        if (jitterViewModel != null && (liveData2 = jitterViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData2.observe((LifecycleOwner) topActivity, new Observer<JitterParam>() { // from class: com.rigol.scope.data.HorizontalParam.1
                    {
                        HorizontalParam.this = this;
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(JitterParam jitterParam) {
                        HorizontalParam.this.jitterParam = jitterParam;
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        EyeViewModel eyeViewModel = (EyeViewModel) ContextUtil.getAppViewModel(EyeViewModel.class);
        if (eyeViewModel == null || (liveData = eyeViewModel.getLiveData()) == null) {
            return;
        }
        Activity topActivity2 = ActivityUtils.getTopActivity();
        if (topActivity2 != null) {
            liveData.observe((LifecycleOwner) topActivity2, new Observer<EyeParam>() { // from class: com.rigol.scope.data.HorizontalParam.2
                {
                    HorizontalParam.this = this;
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(EyeParam eyeParam) {
                    HorizontalParam.this.eyeParam = eyeParam;
                }
            });
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.data.HorizontalParam$offsetLarger$1.run():void, com.rigol.scope.data.HorizontalParam$offsetSmaller$1.run():void] */
    public static final /* synthetic */ void access$setEnableToSetOffset$p(HorizontalParam horizontalParam, boolean z) {
        horizontalParam.enableToSetOffset = z;
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
    public final boolean getUltraEnable() {
        return this.ultraEnable;
    }

    public final void setUltraEnable(boolean z) {
        this.ultraEnable = z;
        notifyPropertyChanged(985);
    }

    @Bindable
    public final long getMemStart() {
        return this.memStart;
    }

    public final void setMemStart(long j) {
        this.memStart = j;
        notifyPropertyChanged(532);
    }

    @Bindable
    public final long getMemEnd() {
        return this.memEnd;
    }

    public final void setMemEnd(long j) {
        this.memEnd = j;
        notifyPropertyChanged(531);
    }

    @Bindable
    public final long getScrStart() {
        return this.scrStart;
    }

    public final void setScrStart(long j) {
        this.scrStart = j;
        notifyPropertyChanged(779);
    }

    @Bindable
    public final long getScrEnd() {
        return this.scrEnd;
    }

    public final void setScrEnd(long j) {
        this.scrEnd = j;
        notifyPropertyChanged(778);
    }

    @Bindable
    public final ServiceEnum.AcquireMode getAcquireMode() {
        return this.acquireMode;
    }

    public final void setAcquireMode(ServiceEnum.AcquireMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("acquireMode", this.acquireMode, value);
        this.acquireMode = value;
        notifyPropertyChanged(28);
    }

    @Bindable
    public final long getMainScale() {
        return this.mainScale;
    }

    public final void setMainScale(long j) {
        log("mainScale", Long.valueOf(this.mainScale), Long.valueOf(j));
        this.mainScale = j;
        notifyPropertyChanged(516);
        syncData(MessageID.MSG_HOR_MAIN_SCALE, Long.valueOf(this.mainScale));
    }

    @Bindable
    public final long getMainOffset() {
        return this.mainOffset;
    }

    public final void setMainOffset(long j) {
        log("mainOffset", Long.valueOf(this.mainOffset), Long.valueOf(j));
        this.mainOffset = j;
        String convert = UnitFormat.newBuilder("0.00####", UnitFormat.SI.FEMTO).convert(j, ServiceEnum.Unit.Unit_s);
        Intrinsics.checkNotNullExpressionValue(convert, "UnitFormat.newBuilder(\"0… ServiceEnum.Unit.Unit_s)");
        setMainOffsetStr(convert);
        notifyPropertyChanged(514);
        syncData(MessageID.MSG_HOR_MAIN_OFFSET, Long.valueOf(this.mainOffset));
    }

    @Bindable
    public final String getMainOffsetStr() {
        return this.mainOffsetStr;
    }

    private final void setMainOffsetStr(String str) {
        this.mainOffsetStr = str;
        notifyPropertyChanged(515);
    }

    @Bindable
    public final long getZoomScale() {
        return this.zoomScale;
    }

    public final void setZoomScale(long j) {
        log("zoomScale", Long.valueOf(this.zoomScale), Long.valueOf(j));
        this.zoomScale = j;
        setZoomScaleStr(UnitFormat.newBuilder(UnitFormat.SI.FEMTO).convert(this.zoomScale, ServiceEnum.Unit.Unit_s) + "/div");
        notifyPropertyChanged(1092);
        syncData(MessageID.MSG_HOR_ZOOM_SCALE, Long.valueOf(this.zoomScale));
    }

    @Bindable
    public final String getZoomScaleStr() {
        return this.zoomScaleStr;
    }

    private final void setZoomScaleStr(String str) {
        log("zoomScaleStr", this.zoomScaleStr, str);
        this.zoomScaleStr = str;
        notifyPropertyChanged(1093);
    }

    @Bindable
    public final long getZoomOffset() {
        return this.zoomOffset;
    }

    public final void setZoomOffset(long j) {
        log("zoomOffset", Long.valueOf(this.zoomOffset), Long.valueOf(j));
        this.zoomOffset = j;
        String convert = UnitFormat.newBuilder("0.00####", UnitFormat.SI.FEMTO).convert(j, ServiceEnum.Unit.Unit_s);
        Intrinsics.checkNotNullExpressionValue(convert, "UnitFormat.newBuilder(\"0… ServiceEnum.Unit.Unit_s)");
        setZoomOffsetStr(convert);
        String subNumber = ViewUtil.subNumber(this.zoomOffsetStr, 8);
        Intrinsics.checkNotNullExpressionValue(subNumber, "ViewUtil.subNumber(zoomOffsetStr, 8)");
        setZoomOffsetStr(subNumber);
        notifyPropertyChanged(1090);
        syncData(MessageID.MSG_HOR_ZOOM_OFFSET, Long.valueOf(this.zoomOffset));
    }

    @Bindable
    public final String getZoomOffsetStr() {
        return this.zoomOffsetStr;
    }

    private final void setZoomOffsetStr(String str) {
        this.zoomOffsetStr = str;
        notifyPropertyChanged(1091);
    }

    @Bindable
    public final boolean isFine() {
        return this.isFine;
    }

    public final void setFine(boolean z) {
        log("isFine", Boolean.valueOf(this.isFine), Boolean.valueOf(z));
        this.isFine = z;
        notifyPropertyChanged(314);
    }

    @Bindable
    public final boolean isZoom() {
        return this.isZoom;
    }

    public final void setZoom(boolean z) {
        log("isZoom", Boolean.valueOf(this.isZoom), Boolean.valueOf(z));
        this.isZoom = z;
        notifyPropertyChanged(1088);
        syncData(MessageID.MSG_HOR_ZOOM_ON, Boolean.valueOf(this.isZoom));
    }

    @Bindable
    public final int getAvgTimes() {
        return this.avgTimes;
    }

    public final void setAvgTimes(int i) {
        log("avgTimes", Integer.valueOf(this.avgTimes), Integer.valueOf(i));
        this.avgTimes = i;
        notifyPropertyChanged(65);
    }

    @Bindable
    public final boolean isAntiAliasing() {
        return this.isAntiAliasing;
    }

    public final void setAntiAliasing(boolean z) {
        log("isAntiAliasing", Boolean.valueOf(this.isAntiAliasing), Boolean.valueOf(z));
        this.isAntiAliasing = z;
        notifyPropertyChanged(49);
    }

    @Bindable
    public final long getDepthValue() {
        return this.depthValue;
    }

    public final void setDepthValue(long j) {
        log("depthValue", Long.valueOf(this.depthValue), Long.valueOf(j));
        this.depthValue = j;
        notifyPropertyChanged(239);
    }

    @Bindable
    public final ServiceEnum.AcquireDepth getDepth() {
        return this.depth;
    }

    public final void setDepth(ServiceEnum.AcquireDepth value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("depth", this.depth, value);
        this.depth = value;
        notifyPropertyChanged(237);
    }

    @Bindable
    public final long getSample() {
        return this.sample;
    }

    public final void setSample(long j) {
        log("sample", Long.valueOf(this.sample), Long.valueOf(j));
        this.sample = j;
        notifyPropertyChanged(770);
    }

    @Bindable
    public final long getDotTime() {
        return this.dotTime;
    }

    public final void setDotTime(long j) {
        log("dotTime", Long.valueOf(this.dotTime), Long.valueOf(j));
        this.dotTime = j;
        notifyPropertyChanged(246);
    }

    @Bindable
    public final ServiceEnum.HorizontalExpand getExpandMode() {
        return this.expandMode;
    }

    public final void setExpandMode(ServiceEnum.HorizontalExpand value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("expandMode", this.expandMode, value);
        this.expandMode = value;
        notifyPropertyChanged(289);
        syncData(MessageID.MSG_HOR_EXPAND, this.expandMode);
    }

    @Bindable
    public final int getExpandUser() {
        return this.expandUser;
    }

    public final void setExpandUser(int i) {
        log("expandUser", Integer.valueOf(this.expandUser), Integer.valueOf(i));
        this.expandUser = i;
        notifyPropertyChanged(290);
        syncData(MessageID.MSG_HOR_EXPAND_USER, Integer.valueOf(this.expandUser));
    }

    @Bindable
    public final long getExpandGnd() {
        return this.expandGnd;
    }

    public final void setExpandGnd(long j) {
        log("expandGnd", Long.valueOf(this.expandGnd), Long.valueOf(j));
        this.expandGnd = j;
        notifyPropertyChanged(287);
    }

    @Bindable
    public final int getRoll() {
        return this.roll;
    }

    public final void setRoll(int i) {
        log("roll", Integer.valueOf(this.roll), Integer.valueOf(i));
        this.roll = i;
        notifyPropertyChanged(742);
    }

    @Bindable
    public final ServiceEnum.HighResBit getHighBit() {
        return this.highBit;
    }

    public final void setHighBit(ServiceEnum.HighResBit value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("highBit", this.highBit, value);
        this.highBit = value;
        notifyPropertyChanged(371);
    }

    @Bindable
    public final int getDisplayMode() {
        return this.displayMode;
    }

    public final void setDisplayMode(int i) {
        log("displayMode", Integer.valueOf(this.displayMode), Integer.valueOf(i));
        this.displayMode = i;
        notifyPropertyChanged(244);
    }

    @Bindable
    public final String getHighBw() {
        return this.highBw;
    }

    public final void setHighBw(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("highBw", this.highBw, value);
        this.highBw = value;
        notifyPropertyChanged(372);
    }

    @Bindable
    public final ServiceEnum.ControlAction getRunStop() {
        return this.runStop;
    }

    public final void setRunStop(ServiceEnum.ControlAction value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("runStop", this.runStop, value);
        this.runStop = value;
        updateDepthEn();
        notifyPropertyChanged(760);
        syncData(MessageID.MSG_HOR_RUN, this.runStop);
    }

    @Bindable
    public final ServiceEnum.ControlStatus getTriggerStatus() {
        return this.triggerStatus;
    }

    public final void setTriggerStatus(ServiceEnum.ControlStatus value) {
        Intrinsics.checkNotNullParameter(value, "value");
        ServiceEnum.ControlStatus controlStatus = this.triggerStatus;
        if (controlStatus != value) {
            log("triggerStatus", controlStatus, value);
        }
        this.triggerStatus = value;
        notifyPropertyChanged(947);
    }

    @Bindable
    public final boolean getFilter1() {
        return this.filter1;
    }

    public final void setFilter1(boolean z) {
        log("filter1", Boolean.valueOf(this.filter1), Boolean.valueOf(z));
        this.filter1 = z;
        notifyPropertyChanged(312);
    }

    @Bindable
    public final boolean getFilter2() {
        return this.filter2;
    }

    public final void setFilter2(boolean z) {
        log("filter2", Boolean.valueOf(this.filter2), Boolean.valueOf(z));
        this.filter2 = z;
        notifyPropertyChanged(313);
    }

    @Bindable
    public final ServiceEnum.HoriTimeMode getTimeMode() {
        return this.timeMode;
    }

    public final void setTimeMode(ServiceEnum.HoriTimeMode value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("timeMode", this.timeMode, value);
        this.timeMode = value;
        updateDepthEn();
        notifyPropertyChanged(935);
        syncData(MessageID.MSG_HOR_UI_TIME_VIEW_MODE, this.timeMode);
    }

    @Bindable
    public final boolean isDepthEn() {
        return this.isDepthEn;
    }

    public final void setDepthEn(boolean z) {
        log("isDepthEn", Boolean.valueOf(this.isDepthEn), Boolean.valueOf(z));
        this.isDepthEn = z;
        notifyPropertyChanged(238);
    }

    @Bindable
    public final long getMaxFrame() {
        return this.maxFrame;
    }

    public final void setMaxFrame(long j) {
        log("maxFrame", Long.valueOf(this.maxFrame), Long.valueOf(j));
        this.maxFrame = j;
        notifyPropertyChanged(523);
    }

    @Bindable
    public final long getTimeOut() {
        return this.timeOut;
    }

    public final void setTimeOut(long j) {
        log("timeOut", Long.valueOf(this.timeOut), Long.valueOf(j));
        this.timeOut = j;
        notifyPropertyChanged(936);
    }

    @Bindable
    public final boolean getXyCheck() {
        return this.xyCheck;
    }

    public final void setXyCheck(boolean z) {
        log("xyCheck", Boolean.valueOf(this.xyCheck), Boolean.valueOf(z));
        this.xyCheck = z;
        notifyPropertyChanged(1081);
    }

    @Bindable
    public final boolean getXyCheckEnable() {
        return this.xyCheckEnable;
    }

    public final void setXyCheckEnable(boolean z) {
        log("xyCheckEnable", Boolean.valueOf(this.xyCheckEnable), Boolean.valueOf(z));
        this.xyCheckEnable = z;
        notifyPropertyChanged(1082);
    }

    @Bindable
    public final boolean getSapmassa() {
        return this.sapmassa;
    }

    public final void setSapmassa(boolean z) {
        log("xyCheckEnable", Boolean.valueOf(this.sapmassa), Boolean.valueOf(z));
        this.sapmassa = z;
        notifyPropertyChanged(772);
    }

    public final void saveDelaySample(boolean z) {
        setSapmassa(z);
    }

    public final boolean getShowDepth() {
        return this.showDepth;
    }

    public final void setShowDepth(boolean z) {
        this.showDepth = z;
    }

    public final MessageAttr getMemStartAttr() {
        return this.memStartAttr;
    }

    public final void setMemStartAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.memStartAttr = messageAttr;
    }

    public final MessageAttr getMemEndAttr() {
        return this.memEndAttr;
    }

    public final void setMemEndAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.memEndAttr = messageAttr;
    }

    public final MessageAttr getScrStartAttr() {
        return this.scrStartAttr;
    }

    public final void setScrStartAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.scrStartAttr = messageAttr;
    }

    public final MessageAttr getScrEndAttr() {
        return this.scrEndAttr;
    }

    public final void setScrEndAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.scrEndAttr = messageAttr;
    }

    public final MessageAttr getMainScaleAttr() {
        return this.mainScaleAttr;
    }

    public final void setMainScaleAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.mainScaleAttr = messageAttr;
    }

    public final MessageAttr getMainOffsetAttr() {
        return this.mainOffsetAttr;
    }

    public final void setMainOffsetAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.mainOffsetAttr = messageAttr;
    }

    public final MessageAttr getZoomScaleAttr() {
        return this.zoomScaleAttr;
    }

    public final void setZoomScaleAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.zoomScaleAttr = messageAttr;
    }

    public final MessageAttr getZoomOffsetAttr() {
        return this.zoomOffsetAttr;
    }

    public final void setZoomOffsetAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.zoomOffsetAttr = messageAttr;
    }

    public final MessageAttr getExpandUserAttr() {
        return this.expandUserAttr;
    }

    public final void setExpandUserAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.expandUserAttr = messageAttr;
    }

    public final MessageAttr getAvgTimesAttr() {
        return this.avgTimesAttr;
    }

    public final void setAvgTimesAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.avgTimesAttr = messageAttr;
    }

    public final MessageAttr getMaxFrameAttr() {
        return this.maxFrameAttr;
    }

    public final void setMaxFrameAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.maxFrameAttr = messageAttr;
    }

    public final MessageAttr getTimeOutAttr() {
        return this.timeOutAttr;
    }

    public final void setTimeOutAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.timeOutAttr = messageAttr;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readMemStart();
        readMemEnd();
        readScrStart();
        readScrEnd();
        readAcquireMode();
        readMainScale();
        readMainOffset();
        readZoomScale();
        readZoomOffset();
        readFine();
        readZoom();
        readDepthValue();
        readDepth();
        readSample();
        readDotTime();
        readAvgTimes();
        readAntiAliasing();
        readExpandMode();
        readExpandUser();
        readExpandGnd();
        readRoll();
        readHighBit();
        readDisplayMode();
        readHighBw();
        readRunStop();
        readTriggerStatus();
        readFilter1();
        readFilter2();
        readTimeMode();
        readShowDepth();
        readMaxFrame();
        readTimeOut();
        readMemStartAttr();
        readMemEndAttr();
        readScrStartAttr();
        readScrEndAttr();
        readMainScaleAttr();
        readMainOffsetAttr();
        readZoomScaleAttr();
        readZoomOffsetAttr();
        readExpandUserAttr();
        readAcquireAvgTimesAttr();
        readMaxFrameAttr();
        readTimeeOutAttr();
    }

    public final long readMemStart() {
        setMemStart(readLong(MessageID.MSG_HOR_MEM_START));
        return this.memStart;
    }

    public final long readMemEnd() {
        setMemEnd(readLong(MessageID.MSG_HOR_MEM_END));
        return this.memEnd;
    }

    public final long readScrStart() {
        setScrStart(readLong(MessageID.MSG_HOR_SCR_START));
        return this.scrStart;
    }

    public final long readScrEnd() {
        setScrEnd(readLong(MessageID.MSG_HOR_SCR_END));
        return this.scrEnd;
    }

    public final ServiceEnum.AcquireMode readAcquireMode() {
        ServiceEnum.AcquireMode acquireModeFromValue1 = ServiceEnum.getAcquireModeFromValue1(readInt(MessageID.MSG_ACQ_MODE));
        Intrinsics.checkNotNullExpressionValue(acquireModeFromValue1, "ServiceEnum.getAcquireMo…mValue1(acquireModeValue)");
        setAcquireMode(acquireModeFromValue1);
        return this.acquireMode;
    }

    public final long readMainScale() {
        setMainScale(readLong(MessageID.MSG_HOR_MAIN_SCALE));
        return this.mainScale;
    }

    public final long readMainOffset() {
        setMainOffset(readLong(MessageID.MSG_HOR_MAIN_OFFSET));
        return this.mainOffset;
    }

    public final long readZoomScale() {
        setZoomScale(readLong(MessageID.MSG_HOR_ZOOM_SCALE));
        return this.zoomScale;
    }

    public final long readZoomOffset() {
        setZoomOffset(readLong(MessageID.MSG_HOR_ZOOM_OFFSET));
        return this.zoomOffset;
    }

    public final boolean readFine() {
        setFine(readBool(MessageID.MSG_HOR_FINE_ON));
        return this.isFine;
    }

    public final boolean readZoom() {
        setZoom(readBool(MessageID.MSG_HOR_ZOOM_ON));
        return this.isZoom;
    }

    public final long readDepthValue() {
        setDepthValue(readLong(MessageID.MSG_ACQ_MEMDEPTH_VALUE));
        return this.depthValue;
    }

    public final ServiceEnum.AcquireDepth readDepth() {
        ServiceEnum.AcquireDepth acquireDepthFromValue1 = ServiceEnum.getAcquireDepthFromValue1(readInt(MessageID.MSG_ACQ_MEMDEPTH));
        Intrinsics.checkNotNullExpressionValue(acquireDepthFromValue1, "ServiceEnum.getAcquireDe…sageID.MSG_ACQ_MEMDEPTH))");
        setDepth(acquireDepthFromValue1);
        return this.depth;
    }

    public final long readSample() {
        setSample(readLong(MessageID.MSG_ACQ_SARATE));
        return this.sample;
    }

    public final long readDotTime() {
        setDotTime(readLong(8972));
        return this.dotTime;
    }

    public final int readAvgTimes() {
        setAvgTimes(readInt(MessageID.MSG_ACQ_AVG_TIMES));
        return this.avgTimes;
    }

    public final boolean readAntiAliasing() {
        setAntiAliasing(readBool(MessageID.MSG_ACQ_ANTI_ALIASING));
        return this.isAntiAliasing;
    }

    public final ServiceEnum.HorizontalExpand readExpandMode() {
        ServiceEnum.HorizontalExpand horizontalExpandFromValue1 = ServiceEnum.getHorizontalExpandFromValue1(readInt(MessageID.MSG_HOR_EXPAND));
        Intrinsics.checkNotNullExpressionValue(horizontalExpandFromValue1, "ServiceEnum.getHorizonta…essageID.MSG_HOR_EXPAND))");
        setExpandMode(horizontalExpandFromValue1);
        return this.expandMode;
    }

    public final int readExpandUser() {
        setExpandUser(readInt(MessageID.MSG_HOR_EXPAND_USER));
        return this.expandUser;
    }

    public final long readExpandGnd() {
        setExpandGnd(readLong(MessageID.MSG_HOR_EXPAND_GND));
        return this.expandGnd;
    }

    public final int readRoll() {
        setRoll(readInt(MessageID.MSG_HOR_AUTO_ROLL));
        return this.roll;
    }

    public final ServiceEnum.HighResBit readHighBit() {
        ServiceEnum.HighResBit highResBitFromValue1 = ServiceEnum.getHighResBitFromValue1(readInt(MessageID.MSG_ACQ_HIGHRES_BIT));
        Intrinsics.checkNotNullExpressionValue(highResBitFromValue1, "ServiceEnum.getHighResBi…eID.MSG_ACQ_HIGHRES_BIT))");
        setHighBit(highResBitFromValue1);
        return this.highBit;
    }

    public final int readDisplayMode() {
        setDisplayMode(readInt(MessageID.MSG_ACQ_ULTRA_DISPLAYMODE));
        return this.displayMode;
    }

    public final String readHighBw() {
        setHighBw(readStr(MessageID.MSG_ACQ_HIGHRES_BW));
        return this.highBw;
    }

    public final ServiceEnum.ControlAction readRunStop() {
        ServiceEnum.ControlAction controlActionFromValue1 = ServiceEnum.getControlActionFromValue1(readInt(MessageID.MSG_HOR_RUN));
        Intrinsics.checkNotNullExpressionValue(controlActionFromValue1, "ServiceEnum.getControlAc…t(MessageID.MSG_HOR_RUN))");
        setRunStop(controlActionFromValue1);
        return this.runStop;
    }

    public final ServiceEnum.ControlStatus readTriggerStatus() {
        ServiceEnum.ControlStatus controlStatusFromValue1 = ServiceEnum.getControlStatusFromValue1(readInt(MessageID.MSG_HOR_GET_TRIGSTATUS));
        Intrinsics.checkNotNullExpressionValue(controlStatusFromValue1, "ServiceEnum.getControlSt….MSG_HOR_GET_TRIGSTATUS))");
        setTriggerStatus(controlStatusFromValue1);
        return this.triggerStatus;
    }

    public final boolean readFilter1() {
        setFilter1(readBool(MessageID.MSG_HOR_FILTER1_EN));
        return this.filter1;
    }

    public final boolean readFilter2() {
        setFilter2(readBool(MessageID.MSG_HOR_FILTER2_EN));
        return this.filter2;
    }

    public final ServiceEnum.HoriTimeMode readTimeMode() {
        ServiceEnum.HoriTimeMode horiTimeModeFromValue1 = ServiceEnum.getHoriTimeModeFromValue1(readInt(MessageID.MSG_HOR_UI_TIME_VIEW_MODE));
        Intrinsics.checkNotNullExpressionValue(horiTimeModeFromValue1, "ServiceEnum.getHoriTimeM…G_HOR_UI_TIME_VIEW_MODE))");
        setTimeMode(horiTimeModeFromValue1);
        return this.timeMode;
    }

    public final boolean readShowDepth() {
        boolean readBool = readBool(MessageID.MSG_ACQ_OPT_DEPTH);
        this.showDepth = readBool;
        return readBool;
    }

    public final long readMaxFrame() {
        setMaxFrame(readLong(MessageID.MSG_ACQ_ULTRA_FRAME));
        return this.maxFrame;
    }

    public final long readTimeOut() {
        setTimeOut(readLong(MessageID.MSG_ACQ_ULTRA_TIMEOUT));
        return this.timeOut;
    }

    public final void readMemStartAttr() {
        readAttr(MessageID.MSG_HOR_MEM_START, this.memStartAttr);
    }

    public final void readMemEndAttr() {
        readAttr(MessageID.MSG_HOR_MEM_END, this.memEndAttr);
    }

    public final void readScrStartAttr() {
        readAttr(MessageID.MSG_HOR_SCR_START, this.scrStartAttr);
    }

    public final void readScrEndAttr() {
        readAttr(MessageID.MSG_HOR_SCR_END, this.scrEndAttr);
    }

    public final void readMainScaleAttr() {
        readAttr(MessageID.MSG_HOR_MAIN_SCALE, this.mainScaleAttr);
    }

    public final void readMainOffsetAttr() {
        MessageBus.getInstance().onSyncData(MessageBus.getKey(58, MessageID.MSG_NAVIGATE_TIMEOFFSET_PLAYING), 12);
        readAttr(MessageID.MSG_HOR_MAIN_OFFSET, this.mainOffsetAttr);
    }

    public final void readZoomScaleAttr() {
        readAttr(MessageID.MSG_HOR_ZOOM_SCALE, this.zoomScaleAttr);
    }

    public final void readZoomOffsetAttr() {
        readAttr(MessageID.MSG_HOR_ZOOM_OFFSET, this.zoomOffsetAttr);
    }

    public final void readExpandUserAttr() {
        readAttr(MessageID.MSG_HOR_EXPAND_USER, this.expandUserAttr);
    }

    public final void readAcquireAvgTimesAttr() {
        readAttr(MessageID.MSG_ACQ_AVG_TIMES, this.avgTimesAttr);
    }

    public final void readMaxFrameAttr() {
        readAttr(MessageID.MSG_ACQ_ULTRA_FRAME, this.maxFrameAttr);
    }

    public final void readTimeeOutAttr() {
        readAttr(MessageID.MSG_ACQ_ULTRA_TIMEOUT, this.timeOutAttr);
    }

    public final void updateDepthEn() {
        BaseProperty<Boolean> enabled;
        Boolean value;
        JitterParam jitterParam = this.jitterParam;
        boolean z = false;
        if (!(jitterParam != null ? jitterParam.isEnabled() : false)) {
            EyeParam eyeParam = this.eyeParam;
            if (!((eyeParam == null || (enabled = eyeParam.getEnabled()) == null || (value = enabled.getValue()) == null) ? false : value.booleanValue())) {
                z = true;
            }
        }
        setDepthEn(z);
    }

    public final void saveMemStart(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.memStartAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setMemStart(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_HOR_MEM_START, this.memStart);
    }

    public final void saveMemEnd(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.memEndAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setMemEnd(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_HOR_MEM_END, this.memEnd);
    }

    public final void saveScrStart(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.scrStartAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setScrStart(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_HOR_SCR_START, this.scrStart);
    }

    public final void saveScrEnd(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.scrEndAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setScrEnd(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_HOR_SCR_END, this.scrEnd);
    }

    public final void saveMainScale(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.mainScaleAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setMainScale(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_HOR_MAIN_SCALE, this.mainScale);
    }

    public final void saveMainOffset(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.mainOffsetAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setMainOffset(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_HOR_MAIN_OFFSET, this.mainOffset);
    }

    public final void moveMainOffset(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.mainOffsetAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        long longValue = ((Long) checkAttrRang).longValue();
        long j2 = longValue - this.mainOffset;
        setMainOffset(longValue);
        API.getInstance().UI_PostInt64(40, MessageID.MSG_PLOT_DRAG_HORI, j2);
    }

    public final void saveZoomScale(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.zoomScaleAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setZoomScale(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_HOR_ZOOM_SCALE, this.zoomScale);
    }

    public final void saveZoomOffset(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.zoomOffsetAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setZoomOffset(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_HOR_ZOOM_OFFSET, this.zoomOffset);
    }

    public final void moveZoomOffset(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.zoomOffsetAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        long longValue = ((Long) checkAttrRang).longValue();
        long j2 = longValue - this.zoomOffset;
        setZoomOffset(longValue);
        API.getInstance().UI_PostInt64(40, MessageID.MSG_PLOT_DRAG_HORI, j2);
    }

    public final void saveFine(boolean z) {
        setFine(z);
        saveInt(MessageID.MSG_HOR_FINE_ON, z);
    }

    public final void saveZoom(boolean z) {
        setZoom(z);
        saveInt(MessageID.MSG_HOR_ZOOM_ON, z);
    }

    public final void saveDepth(ServiceEnum.AcquireDepth depth) {
        Intrinsics.checkNotNullParameter(depth, "depth");
        setDepth(depth);
        saveInt(MessageID.MSG_ACQ_MEMDEPTH, depth.value1);
    }

    public final void saveAvgTimes(int i) {
        setAvgTimes(i);
        saveInt(MessageID.MSG_ACQ_AVG_TIMES, i);
    }

    public final void saveAntiAliasing(boolean z) {
        setAntiAliasing(z);
        saveInt(MessageID.MSG_ACQ_ANTI_ALIASING, z);
    }

    public final void saveExpandMode(ServiceEnum.HorizontalExpand expandMode) {
        Intrinsics.checkNotNullParameter(expandMode, "expandMode");
        setExpandMode(expandMode);
        saveInt(MessageID.MSG_HOR_EXPAND, expandMode.value1);
    }

    public final void saveExpandUser(int i) {
        setExpandUser(i);
        saveInt(MessageID.MSG_HOR_EXPAND_USER, i);
    }

    public final void saveExpandGnd(long j) {
        setExpandGnd(j);
        saveLong(MessageID.MSG_HOR_EXPAND_GND, j);
    }

    public final void saveAcquireMode(ServiceEnum.AcquireMode acquireMode) {
        if (acquireMode == null) {
            return;
        }
        setAcquireMode(acquireMode);
        saveInt(MessageID.MSG_ACQ_MODE, acquireMode.value1);
        syncData(MessageID.MSG_ACQ_MODE, 1);
    }

    public final void saveRoll(int i) {
        setRoll(i);
        saveInt(MessageID.MSG_HOR_AUTO_ROLL, i);
    }

    public final void saveHighBits(ServiceEnum.HighResBit highBit) {
        Intrinsics.checkNotNullParameter(highBit, "highBit");
        setHighBit(highBit);
        saveInt(MessageID.MSG_ACQ_HIGHRES_BIT, highBit.value1);
    }

    public final void saveDisplay(int i) {
        setDisplayMode(i);
        saveInt(MessageID.MSG_ACQ_ULTRA_DISPLAYMODE, i);
    }

    public final void saveRunStop(ServiceEnum.ControlAction runStop) {
        Intrinsics.checkNotNullParameter(runStop, "runStop");
        setRunStop(runStop);
        saveInt(MessageID.MSG_HOR_RUN, runStop.value1);
    }

    public final void saveTriggerStatus(ServiceEnum.ControlStatus triggerStatus) {
        Intrinsics.checkNotNullParameter(triggerStatus, "triggerStatus");
        setTriggerStatus(triggerStatus);
        saveInt(MessageID.MSG_HOR_GET_TRIGSTATUS, triggerStatus.value1);
    }

    public final void saveFilter1(boolean z) {
        setFilter1(z);
        saveBool(MessageID.MSG_HOR_FILTER1_EN, z);
    }

    public final void saveFilter2(boolean z) {
        setFilter2(z);
        saveBool(MessageID.MSG_HOR_FILTER2_EN, z);
    }

    public final void saveMaxFrame(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.maxFrameAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setMaxFrame(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_ACQ_ULTRA_FRAME, j);
    }

    public final void saveTimeOut(long j) {
        Object checkAttrRang = checkAttrRang(Long.valueOf(j), this.timeOutAttr, Long.TYPE);
        if (checkAttrRang == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
        }
        setTimeOut(((Long) checkAttrRang).longValue());
        saveLong(MessageID.MSG_ACQ_ULTRA_TIMEOUT, j);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        boolean z;
        boolean z2;
        boolean z3;
        ServiceEnum.AcquireMode acquireMode;
        float f;
        float f2;
        ServiceEnum.AcquireDepth acquireDepth;
        ServiceEnum.HorizontalExpand horizontalExpand;
        int i;
        ServiceEnum.HighResBit highResBit;
        ServiceEnum.ControlAction controlAction;
        ServiceEnum.ControlStatus controlStatus;
        ServiceEnum.HoriTimeMode horiTimeMode;
        super.reset();
        setTimeOut(this.timeOutAttr.getDefLongValue());
        setDisplayMode(0);
        z = HorizontalParamKt.DEFAULT_XY_CHECK;
        setXyCheck(z);
        z2 = HorizontalParamKt.DEFAULT_XY_CHECK_ENABLE;
        setXyCheckEnable(z2);
        z3 = HorizontalParamKt.DEFAULT_ULTRA_ENABLE;
        setUltraEnable(z3);
        acquireMode = HorizontalParamKt.DEFAULT_ACQUIRE_MODE;
        setAcquireMode(acquireMode);
        f = HorizontalParamKt.DEFAULT_MAIN_SCALE;
        setMainScale(f);
        setMainOffset(0L);
        f2 = HorizontalParamKt.DEFAULT_ZOOM_SCALE;
        setZoomScale(f2);
        setZoomOffset(0L);
        setFine(false);
        setZoom(false);
        setAvgTimes(2);
        setAntiAliasing(false);
        setDepthValue(10000L);
        acquireDepth = HorizontalParamKt.DEFAULT_DEPTH;
        setDepth(acquireDepth);
        setSample(4000000000L);
        setDotTime(250.0f);
        horizontalExpand = HorizontalParamKt.DEFAULT_EXPANDMODE;
        setExpandMode(horizontalExpand);
        setExpandUser(0);
        setExpandGnd(0L);
        i = HorizontalParamKt.DEFAULT_ROLL;
        setRoll(i);
        highResBit = HorizontalParamKt.DEFAULT_HIGHBIT;
        setHighBit(highResBit);
        controlAction = HorizontalParamKt.DEFAULT_RUNSTOP;
        setRunStop(controlAction);
        controlStatus = HorizontalParamKt.DEFAULT_TRIGGERSTATUS;
        setTriggerStatus(controlStatus);
        setFilter1(true);
        setFilter2(true);
        horiTimeMode = HorizontalParamKt.DEFAULT_TIMEMODE;
        setTimeMode(horiTimeMode);
        this.showDepth = false;
        setDepthEn(true);
    }

    public final long getUpperSclae(long j) {
        return StringsKt.startsWith$default(String.valueOf(j), ExifInterface.GPS_MEASUREMENT_2D, false, 2, (Object) null) ? (j * 5) / 2 : j * 2;
    }

    public final long getLowerScale(long j) {
        if (StringsKt.startsWith$default(String.valueOf(j), "5", false, 2, (Object) null)) {
            return (j * 2) / 5;
        }
        return j / 2;
    }

    public final long getScaleLager(long j) {
        long j2;
        long plusNum = ScaleNumUtil.getPlusNum(j, 1.0f);
        if (this.isFine) {
            long lowerScale = getLowerScale(plusNum);
            if (StringsKt.startsWith$default(String.valueOf(plusNum), "5", false, 2, (Object) null)) {
                j2 = (plusNum / 5) / 10;
            } else if (StringsKt.startsWith$default(String.valueOf(plusNum), ExifInterface.GPS_MEASUREMENT_2D, false, 2, (Object) null)) {
                j2 = (plusNum / 2) / 10;
            } else {
                long j3 = 10;
                j2 = (plusNum / j3) / j3;
            }
            if (j2 < 50000) {
                j2 = 50000;
            }
            return lowerScale + ((((j + j2) - lowerScale) / j2) * j2);
        }
        return plusNum;
    }

    public final long getScaleSmaller(long j) {
        long j2;
        long minusNum = ScaleNumUtil.getMinusNum(j, 1.0f);
        if (this.isFine) {
            long upperSclae = getUpperSclae(minusNum);
            if (StringsKt.startsWith$default(String.valueOf(upperSclae), "5", false, 2, (Object) null)) {
                j2 = (upperSclae / 5) / 10;
            } else if (StringsKt.startsWith$default(String.valueOf(upperSclae), ExifInterface.GPS_MEASUREMENT_2D, false, 2, (Object) null)) {
                j2 = (upperSclae / 2) / 10;
            } else {
                long j3 = 10;
                j2 = (upperSclae / j3) / j3;
            }
            if (j2 < 50000) {
                j2 = 50000;
            }
            return minusNum + ((((j - j2) - minusNum) / j2) * j2);
        }
        return minusNum;
    }

    public final long offsetLarger(long j, long j2, int i) {
        if (this.enableToSetOffset) {
            long horizontalOffsetStep = OffsetUtil.getHorizontalOffsetStep(j, i) + j2;
            if (OffsetUtil.isCloseToAndOverZero(j2, horizontalOffsetStep)) {
                this.enableToSetOffset = false;
                ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.HorizontalParam$offsetLarger$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        HorizontalParam.access$setEnableToSetOffset$p(HorizontalParam.this, true);
                    }
                }, 550L);
                return 0L;
            }
            return horizontalOffsetStep;
        }
        return j2;
    }

    public final long offsetSmaller(long j, long j2, int i) {
        if (this.enableToSetOffset) {
            long horizontalOffsetStep = j2 - OffsetUtil.getHorizontalOffsetStep(j, i);
            if (OffsetUtil.isCloseToAndOverZero(j2, horizontalOffsetStep)) {
                this.enableToSetOffset = false;
                ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.HorizontalParam$offsetSmaller$1
                    @Override // java.lang.Runnable
                    public final void run() {
                        HorizontalParam.access$setEnableToSetOffset$p(HorizontalParam.this, true);
                    }
                }, 550L);
                return 0L;
            }
            return horizontalOffsetStep;
        }
        return j2;
    }

    public final int avgUp(int i, int i2) {
        return i < this.avgTimesAttr.getMaxIntValue() ? i + (i2 * 1) : ((long) i) > ((long) this.avgTimesAttr.getMaxIntValue()) ? this.avgTimesAttr.getMaxIntValue() : i;
    }

    public final int avgDown(int i, int i2) {
        return i > this.avgTimesAttr.getMinIntValue() ? i - (i2 * 1) : ((long) i) < ((long) this.avgTimesAttr.getMinIntValue()) ? this.avgTimesAttr.getMinIntValue() : i;
    }

    public final int expandUserUp(int i, int i2) {
        return i < this.expandUserAttr.getMaxIntValue() ? i + (i2 * 1) : ((long) i) > ((long) this.expandUserAttr.getMaxIntValue()) ? this.expandUserAttr.getMaxIntValue() : i;
    }

    public final int expandUserDown(int i, int i2) {
        return i > this.expandUserAttr.getMinIntValue() ? i - (i2 * 1) : ((long) i) < ((long) this.expandUserAttr.getMinIntValue()) ? this.expandUserAttr.getMinIntValue() : i;
    }

    public final boolean getZoomEnable() {
        return this.acquireMode != ServiceEnum.AcquireMode.Acquire_Ultra && (this.timeMode != ServiceEnum.HoriTimeMode.Horizontal_ROLL || this.runStop == ServiceEnum.ControlAction.Control_Stop);
    }
}
