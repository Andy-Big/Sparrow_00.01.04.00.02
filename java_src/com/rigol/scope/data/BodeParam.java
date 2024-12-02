package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import java.lang.reflect.Type;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BodeParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\bq\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b?\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J5\u0010¶\u0001\u001a\u0016\u0012\u000f\u0012\r\u0012\u0006\u0012\u0004\u0018\u00010\u0016\u0018\u00010·\u0001\u0018\u00010·\u00012\u0007\u0010¸\u0001\u001a\u00020\u00112\u0007\u0010¹\u0001\u001a\u00020\u0011H\u0002¢\u0006\u0003\u0010º\u0001J\n\u0010»\u0001\u001a\u00030¼\u0001H\u0016J\u0007\u0010½\u0001\u001a\u00020\u0004J\b\u0010¾\u0001\u001a\u00030¼\u0001J\u0007\u0010¿\u0001\u001a\u00020\u0016J\u0007\u0010À\u0001\u001a\u00020,J\u0007\u0010Á\u0001\u001a\u00020,J\u0007\u0010Â\u0001\u001a\u00020\u0011J\b\u0010Ã\u0001\u001a\u00030¼\u0001J\b\u0010Ä\u0001\u001a\u00030¼\u0001J\u0007\u0010Å\u0001\u001a\u00020\u0011J\u0007\u0010Æ\u0001\u001a\u00020,J\u0007\u0010Ç\u0001\u001a\u00020\u0011J\u0007\u0010È\u0001\u001a\u00020\u0011J\u0007\u0010É\u0001\u001a\u00020\u0004J\b\u0010Ê\u0001\u001a\u00030¼\u0001J\u0007\u0010Ë\u0001\u001a\u00020\u0004J\b\u0010Ì\u0001\u001a\u00030¼\u0001J\u0007\u0010Í\u0001\u001a\u00020\u0011J\u0007\u0010Î\u0001\u001a\u00020,J\u0007\u0010Ï\u0001\u001a\u00020\u0011J\u0007\u0010Ð\u0001\u001a\u00020\u0004J\b\u0010Ñ\u0001\u001a\u00030¼\u0001J\u0007\u0010Ò\u0001\u001a\u00020\u0004J\b\u0010Ó\u0001\u001a\u00030¼\u0001J\u0007\u0010Ô\u0001\u001a\u00020\u0004J\b\u0010Õ\u0001\u001a\u00030¼\u0001J\u0007\u0010Ö\u0001\u001a\u00020\u0004J\b\u0010×\u0001\u001a\u00030¼\u0001J\u0007\u0010Ø\u0001\u001a\u00020\u0004J\b\u0010Ù\u0001\u001a\u00030¼\u0001J\u0007\u0010Ú\u0001\u001a\u00020\u0004J\b\u0010Û\u0001\u001a\u00030¼\u0001J\u0007\u0010Ü\u0001\u001a\u00020\u0004J\b\u0010Ý\u0001\u001a\u00030¼\u0001J\u0007\u0010Þ\u0001\u001a\u00020\u0004J\b\u0010ß\u0001\u001a\u00030¼\u0001J\b\u0010à\u0001\u001a\u00030¼\u0001J\b\u0010á\u0001\u001a\u00030¼\u0001J\n\u0010â\u0001\u001a\u00030¼\u0001H\u0016J\u0010\u0010ã\u0001\u001a\u00030¼\u00012\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010ä\u0001\u001a\u00030¼\u00012\u0006\u0010-\u001a\u00020,J\u0010\u0010å\u0001\u001a\u00030¼\u00012\u0006\u00102\u001a\u00020,J\u0010\u0010æ\u0001\u001a\u00030¼\u00012\u0006\u0010;\u001a\u00020\u0011J\u0010\u0010ç\u0001\u001a\u00030¼\u00012\u0006\u0010A\u001a\u00020\u0011J\u0010\u0010è\u0001\u001a\u00030¼\u00012\u0006\u0010D\u001a\u00020,J\u0010\u0010é\u0001\u001a\u00030¼\u00012\u0006\u0010G\u001a\u00020\u0011J\u0010\u0010ê\u0001\u001a\u00030¼\u00012\u0006\u0010J\u001a\u00020\u0011J\u0010\u0010ë\u0001\u001a\u00030¼\u00012\u0006\u0010M\u001a\u00020\u0004J\u0010\u0010ì\u0001\u001a\u00030¼\u00012\u0006\u0010S\u001a\u00020\u0004J\u0010\u0010í\u0001\u001a\u00030¼\u00012\u0006\u0010Y\u001a\u00020\u0011J\u0010\u0010î\u0001\u001a\u00030¼\u00012\u0006\u0010\\\u001a\u00020,J\u0010\u0010ï\u0001\u001a\u00030¼\u00012\u0006\u0010h\u001a\u00020\u0011J\u0010\u0010ð\u0001\u001a\u00030¼\u00012\u0006\u0010k\u001a\u00020\u0004J\u0010\u0010ñ\u0001\u001a\u00030¼\u00012\u0006\u0010q\u001a\u00020\u0004J\u0010\u0010ò\u0001\u001a\u00030¼\u00012\u0006\u0010w\u001a\u00020\u0004J\u0010\u0010ó\u0001\u001a\u00030¼\u00012\u0006\u0010}\u001a\u00020\u0004J\u0011\u0010ô\u0001\u001a\u00030¼\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u0004J\u0011\u0010õ\u0001\u001a\u00030¼\u00012\u0007\u0010\u0089\u0001\u001a\u00020\u0004J\u0011\u0010ö\u0001\u001a\u00030¼\u00012\u0007\u0010\u008f\u0001\u001a\u00020\u0004J\u0011\u0010÷\u0001\u001a\u00030¼\u00012\u0007\u0010\u0095\u0001\u001a\u00020\u0004J\u0011\u0010ø\u0001\u001a\u00030¼\u00012\u0007\u0010\u009b\u0001\u001a\u00020,J\u0010\u0010ù\u0001\u001a\u00030¼\u00012\u0006\u0010-\u001a\u00020,J\u0010\u0010ú\u0001\u001a\u00030¼\u00012\u0006\u00105\u001a\u00020,R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR&\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015R&\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0013\"\u0004\b!\u0010\u0015R*\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020\u00160#j\b\u0012\u0004\u0012\u00020\u0016`$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R&\u0010)\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015R&\u0010-\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020,8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R&\u00102\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020,8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010/\"\u0004\b4\u00101R&\u00105\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020,8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010/\"\u0004\b7\u00101R&\u00108\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u00168G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0019\"\u0004\b:\u0010\u001bR&\u0010;\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0013\"\u0004\b=\u0010\u0015R\u001a\u0010>\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000fR&\u0010A\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\u0013\"\u0004\bC\u0010\u0015R&\u0010D\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020,8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010/\"\u0004\bF\u00101R&\u0010G\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0013\"\u0004\bI\u0010\u0015R&\u0010J\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010\u0013\"\u0004\bL\u0010\u0015R&\u0010M\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0007\"\u0004\bO\u0010\tR\u001a\u0010P\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010\r\"\u0004\bR\u0010\u000fR&\u0010S\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bT\u0010\u0007\"\u0004\bU\u0010\tR\u001a\u0010V\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010\r\"\u0004\bX\u0010\u000fR&\u0010Y\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\u0013\"\u0004\b[\u0010\u0015R&\u0010\\\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020,8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010/\"\u0004\b^\u00101R$\u0010_\u001a\u00020\u00162\u0006\u0010\u0003\u001a\u00020\u0016@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b`\u0010\u0019\"\u0004\ba\u0010\u001bRD\u0010b\u001a\u0012\u0012\u0004\u0012\u00020\u00160#j\b\u0012\u0004\u0012\u00020\u0016`$2\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00160#j\b\u0012\u0004\u0012\u00020\u0016`$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u0010&\"\u0004\bd\u0010(RD\u0010e\u001a\u0012\u0012\u0004\u0012\u00020\u00160#j\b\u0012\u0004\u0012\u00020\u0016`$2\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00160#j\b\u0012\u0004\u0012\u00020\u0016`$@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u0010&\"\u0004\bg\u0010(R&\u0010h\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00118G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\u0013\"\u0004\bj\u0010\u0015R&\u0010k\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\u0007\"\u0004\bm\u0010\tR\u001a\u0010n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\r\"\u0004\bp\u0010\u000fR&\u0010q\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010\u0007\"\u0004\bs\u0010\tR\u001a\u0010t\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010\r\"\u0004\bv\u0010\u000fR&\u0010w\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\u0007\"\u0004\by\u0010\tR\u001a\u0010z\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\r\"\u0004\b|\u0010\u000fR&\u0010}\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0007\"\u0004\b\u007f\u0010\tR\u001d\u0010\u0080\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\r\"\u0005\b\u0082\u0001\u0010\u000fR)\u0010\u0083\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010\u0007\"\u0005\b\u0085\u0001\u0010\tR\u001d\u0010\u0086\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\r\"\u0005\b\u0088\u0001\u0010\u000fR)\u0010\u0089\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\u0007\"\u0005\b\u008b\u0001\u0010\tR\u001d\u0010\u008c\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010\r\"\u0005\b\u008e\u0001\u0010\u000fR)\u0010\u008f\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010\u0007\"\u0005\b\u0091\u0001\u0010\tR\u001d\u0010\u0092\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\r\"\u0005\b\u0094\u0001\u0010\u000fR)\u0010\u0095\u0001\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010\u0007\"\u0005\b\u0097\u0001\u0010\tR\u001d\u0010\u0098\u0001\u001a\u00020\u000bX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0099\u0001\u0010\r\"\u0005\b\u009a\u0001\u0010\u000fR)\u0010\u009b\u0001\u001a\u00020,2\u0006\u0010\u0003\u001a\u00020,8G@FX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u009c\u0001\u0010/\"\u0005\b\u009d\u0001\u00101R-\u0010\u009f\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u0003\u001a\u00030\u009e\u00018G@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b \u0001\u0010¡\u0001\"\u0006\b¢\u0001\u0010£\u0001R/\u0010¤\u0001\u001a\u0014\u0012\u0005\u0012\u00030¥\u00010#j\t\u0012\u0005\u0012\u00030¥\u0001`$X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b¦\u0001\u0010&\"\u0005\b§\u0001\u0010(R/\u0010¨\u0001\u001a\u0014\u0012\u0005\u0012\u00030¥\u00010#j\t\u0012\u0005\u0012\u00030¥\u0001`$X\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b©\u0001\u0010&\"\u0005\bª\u0001\u0010(R+\u0010«\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u0003\u001a\u00030\u009e\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¬\u0001\u0010¡\u0001\"\u0006\b\u00ad\u0001\u0010£\u0001R+\u0010®\u0001\u001a\u00030¥\u00012\u0007\u0010\u0003\u001a\u00030¥\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¯\u0001\u0010°\u0001\"\u0006\b±\u0001\u0010²\u0001R+\u0010³\u0001\u001a\u00030\u009e\u00012\u0007\u0010\u0003\u001a\u00030\u009e\u0001@FX\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b´\u0001\u0010¡\u0001\"\u0006\bµ\u0001\u0010£\u0001¨\u0006û\u0001"}, d2 = {"Lcom/rigol/scope/data/BodeParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "bodeAmpout", "getBodeAmpout", "()J", "setBodeAmpout", "(J)V", "bodeAmpoutAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getBodeAmpoutAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "setBodeAmpoutAttr", "(Lcom/rigol/scope/cil/MessageAttr;)V", "bodeCursorPosition", "", "getBodeCursorPosition", "()I", "setBodeCursorPosition", "(I)V", "", "bodeData", "getBodeData", "()Ljava/lang/String;", "setBodeData", "(Ljava/lang/String;)V", "bodeDataGain", "getBodeDataGain", "setBodeDataGain", "bodeDataRange", "getBodeDataRange", "setBodeDataRange", "bodeDataString", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getBodeDataString", "()Ljava/util/ArrayList;", "setBodeDataString", "(Ljava/util/ArrayList;)V", "bodeDataWidth", "getBodeDataWidth", "setBodeDataWidth", "", "bodeEnable", "getBodeEnable", "()Z", "setBodeEnable", "(Z)V", "bodeImpedace", "getBodeImpedace", "setBodeImpedace", "bodeMinPop", "getBodeMinPop", "setBodeMinPop", "bodePmgmData", "getBodePmgmData", "setBodePmgmData", "bodePointNum", "getBodePointNum", "setBodePointNum", "bodePointNumAttr", "getBodePointNumAttr", "setBodePointNumAttr", "bodeRunDispType", "getBodeRunDispType", "setBodeRunDispType", "bodeRunStopEnable", "getBodeRunStopEnable", "setBodeRunStopEnable", "bodeSourceIn", "getBodeSourceIn", "setBodeSourceIn", "bodeSourceOut", "getBodeSourceOut", "setBodeSourceOut", "bodeStartFreq", "getBodeStartFreq", "setBodeStartFreq", "bodeStartFreqAttr", "getBodeStartFreqAttr", "setBodeStartFreqAttr", "bodeStopFreq", "getBodeStopFreq", "setBodeStopFreq", "bodeStopFreqAttr", "getBodeStopFreqAttr", "setBodeStopFreqAttr", "bodeSweepType", "getBodeSweepType", "setBodeSweepType", "bodeVaramp", "getBodeVaramp", "setBodeVaramp", "bode_result", "getBode_result", "setBode_result", "bode_resultDatalist", "getBode_resultDatalist", "setBode_resultDatalist", "bode_resultlist", "getBode_resultlist", "setBode_resultlist", "bodedispType", "getBodedispType", "setBodedispType", "bodevaramp1", "getBodevaramp1", "setBodevaramp1", "bodevaramp1Attr", "getBodevaramp1Attr", "setBodevaramp1Attr", "bodevaramp2", "getBodevaramp2", "setBodevaramp2", "bodevaramp2Attr", "getBodevaramp2Attr", "setBodevaramp2Attr", "bodevaramp3", "getBodevaramp3", "setBodevaramp3", "bodevaramp3Attr", "getBodevaramp3Attr", "setBodevaramp3Attr", "bodevaramp4", "getBodevaramp4", "setBodevaramp4", "bodevaramp4Attr", "getBodevaramp4Attr", "setBodevaramp4Attr", "bodevaramp5", "getBodevaramp5", "setBodevaramp5", "bodevaramp5Attr", "getBodevaramp5Attr", "setBodevaramp5Attr", "bodevaramp6", "getBodevaramp6", "setBodevaramp6", "bodevaramp6Attr", "getBodevaramp6Attr", "setBodevaramp6Attr", "bodevaramp7", "getBodevaramp7", "setBodevaramp7", "bodevaramp7Attr", "getBodevaramp7Attr", "setBodevaramp7Attr", "bodevaramp8", "getBodevaramp8", "setBodevaramp8", "bodevaramp8Attr", "getBodevaramp8Attr", "setBodevaramp8Attr", "firEnable", "getFirEnable", "setFirEnable", "", "last_one", "getLast_one", "()D", "setLast_one", "(D)V", "position_listx", "", "getPosition_listx", "setPosition_listx", "position_listy", "getPosition_listy", "setPosition_listy", "spacing_heightunit", "getSpacing_heightunit", "setSpacing_heightunit", "spacing_width_middley", "getSpacing_width_middley", "()F", "setSpacing_width_middley", "(F)V", "spacing_width_unit", "getSpacing_width_unit", "setSpacing_width_unit", "queryData", "", "serviceID", "messageID", "(II)[[Ljava/lang/String;", "readAll", "", "readBodeAmpout", "readBodeAmpoutAttr", "readBodeData", "readBodeEnable", "readBodeImpedace", "readBodePointNum", "readBodePointNumAttr", "readBodeResult", "readBodeRunDispType", "readBodeRunStopEnable", "readBodeSourceIn", "readBodeSourceOut", "readBodeStartFreq", "readBodeStartFreqAttr", "readBodeStopFreq", "readBodeStopFreqAttr", "readBodeSweepType", "readBodeVaramp", "readBodedispType", "readBodevaramp1", "readBodevaramp1AttrAttr", "readBodevaramp2", "readBodevaramp2AttrAttr", "readBodevaramp3", "readBodevaramp3AttrAttr", "readBodevaramp4", "readBodevaramp4AttrAttr", "readBodevaramp5", "readBodevaramp5AttrAttr", "readBodevaramp6", "readBodevaramp6AttrAttr", "readBodevaramp7", "readBodevaramp7AttrAttr", "readBodevaramp8", "readBodevaramp8AttrAttr", "readFirEnable", "readbodePmgmData", "reset", "saveBodeAmpout", "saveBodeEnable", "saveBodeImpedace", "saveBodePointNum", "saveBodeRunDispType", "saveBodeRunStopEnable", "saveBodeSourceIn", "saveBodeSourceOut", "saveBodeStartFreq", "saveBodeStopFreq", "saveBodeSweepType", "saveBodeVaramp", "saveBodedispType", "saveBodevaramp1", "saveBodevaramp2", "saveBodevaramp3", "saveBodevaramp4", "saveBodevaramp5", "saveBodevaramp6", "saveBodevaramp7", "saveBodevaramp8", "saveFirEnable", "setBodeEnable1", "setBodeshow", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class BodeParam extends BaseParam {
    private long bodeAmpout;
    private MessageAttr bodeAmpoutAttr;
    private int bodeCursorPosition;
    private String bodeData;
    private int bodeDataGain;
    private int bodeDataRange;
    private ArrayList<String> bodeDataString;
    private int bodeDataWidth;
    private boolean bodeEnable;
    private boolean bodeImpedace;
    private boolean bodeMinPop;
    private String bodePmgmData;
    private int bodePointNum;
    private MessageAttr bodePointNumAttr;
    private int bodeRunDispType;
    private boolean bodeRunStopEnable;
    private int bodeSourceIn;
    private int bodeSourceOut;
    private long bodeStartFreq;
    private MessageAttr bodeStartFreqAttr;
    private long bodeStopFreq;
    private MessageAttr bodeStopFreqAttr;
    private int bodeSweepType;
    private boolean bodeVaramp;
    private String bode_result;
    private ArrayList<String> bode_resultDatalist;
    private ArrayList<String> bode_resultlist;
    private int bodedispType;
    private long bodevaramp1;
    private MessageAttr bodevaramp1Attr;
    private long bodevaramp2;
    private MessageAttr bodevaramp2Attr;
    private long bodevaramp3;
    private MessageAttr bodevaramp3Attr;
    private long bodevaramp4;
    private MessageAttr bodevaramp4Attr;
    private long bodevaramp5;
    private MessageAttr bodevaramp5Attr;
    private long bodevaramp6;
    private MessageAttr bodevaramp6Attr;
    private long bodevaramp7;
    private MessageAttr bodevaramp7Attr;
    private long bodevaramp8;
    private MessageAttr bodevaramp8Attr;
    private boolean firEnable;
    private double last_one;
    private ArrayList<Float> position_listx;
    private ArrayList<Float> position_listy;
    private double spacing_heightunit;
    private float spacing_width_middley;
    private double spacing_width_unit;

    public BodeParam() {
        super(61);
        this.bodeStartFreqAttr = new MessageAttr();
        this.bodePointNumAttr = new MessageAttr();
        this.bodeStopFreqAttr = new MessageAttr();
        this.bodeAmpoutAttr = new MessageAttr();
        this.bodevaramp1Attr = new MessageAttr();
        this.bodevaramp2Attr = new MessageAttr();
        this.bodevaramp3Attr = new MessageAttr();
        this.bodevaramp4Attr = new MessageAttr();
        this.bodevaramp5Attr = new MessageAttr();
        this.bodevaramp6Attr = new MessageAttr();
        this.bodevaramp7Attr = new MessageAttr();
        this.bodevaramp8Attr = new MessageAttr();
        this.position_listx = new ArrayList<>();
        this.position_listy = new ArrayList<>();
        this.bodeDataString = new ArrayList<>();
        this.bodeRunDispType = 1;
        this.bodeSourceOut = 1;
        this.bodeData = "";
        this.bodePmgmData = "";
        this.bodeDataGain = 60;
        this.bodeDataRange = 180;
        this.bode_result = "";
        this.bode_resultlist = new ArrayList<>();
        this.bode_resultDatalist = new ArrayList<>();
        this.bodeMinPop = true;
    }

    public final MessageAttr getBodeStartFreqAttr() {
        return this.bodeStartFreqAttr;
    }

    public final void setBodeStartFreqAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodeStartFreqAttr = messageAttr;
    }

    public final MessageAttr getBodePointNumAttr() {
        return this.bodePointNumAttr;
    }

    public final void setBodePointNumAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodePointNumAttr = messageAttr;
    }

    public final MessageAttr getBodeStopFreqAttr() {
        return this.bodeStopFreqAttr;
    }

    public final void setBodeStopFreqAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodeStopFreqAttr = messageAttr;
    }

    public final MessageAttr getBodeAmpoutAttr() {
        return this.bodeAmpoutAttr;
    }

    public final void setBodeAmpoutAttr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodeAmpoutAttr = messageAttr;
    }

    public final MessageAttr getBodevaramp1Attr() {
        return this.bodevaramp1Attr;
    }

    public final void setBodevaramp1Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodevaramp1Attr = messageAttr;
    }

    public final MessageAttr getBodevaramp2Attr() {
        return this.bodevaramp2Attr;
    }

    public final void setBodevaramp2Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodevaramp2Attr = messageAttr;
    }

    public final MessageAttr getBodevaramp3Attr() {
        return this.bodevaramp3Attr;
    }

    public final void setBodevaramp3Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodevaramp3Attr = messageAttr;
    }

    public final MessageAttr getBodevaramp4Attr() {
        return this.bodevaramp4Attr;
    }

    public final void setBodevaramp4Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodevaramp4Attr = messageAttr;
    }

    public final MessageAttr getBodevaramp5Attr() {
        return this.bodevaramp5Attr;
    }

    public final void setBodevaramp5Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodevaramp5Attr = messageAttr;
    }

    public final MessageAttr getBodevaramp6Attr() {
        return this.bodevaramp6Attr;
    }

    public final void setBodevaramp6Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodevaramp6Attr = messageAttr;
    }

    public final MessageAttr getBodevaramp7Attr() {
        return this.bodevaramp7Attr;
    }

    public final void setBodevaramp7Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodevaramp7Attr = messageAttr;
    }

    public final MessageAttr getBodevaramp8Attr() {
        return this.bodevaramp8Attr;
    }

    public final void setBodevaramp8Attr(MessageAttr messageAttr) {
        Intrinsics.checkNotNullParameter(messageAttr, "<set-?>");
        this.bodevaramp8Attr = messageAttr;
    }

    public final ArrayList<Float> getPosition_listx() {
        return this.position_listx;
    }

    public final void setPosition_listx(ArrayList<Float> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.position_listx = arrayList;
    }

    public final ArrayList<Float> getPosition_listy() {
        return this.position_listy;
    }

    public final void setPosition_listy(ArrayList<Float> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.position_listy = arrayList;
    }

    public final ArrayList<String> getBodeDataString() {
        return this.bodeDataString;
    }

    public final void setBodeDataString(ArrayList<String> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.bodeDataString = arrayList;
    }

    @Bindable
    public final boolean getBodeEnable() {
        return this.bodeEnable;
    }

    public final void setBodeEnable(boolean z) {
        log("chNum", Boolean.valueOf(this.bodeEnable), Boolean.valueOf(z));
        this.bodeEnable = z;
        notifyPropertyChanged(96);
    }

    @Bindable
    public final boolean getFirEnable() {
        return this.firEnable;
    }

    public final void setFirEnable(boolean z) {
        log("chNum", Boolean.valueOf(this.firEnable), Boolean.valueOf(z));
        this.firEnable = z;
        notifyPropertyChanged(319);
    }

    @Bindable
    public final boolean getBodeRunStopEnable() {
        return this.bodeRunStopEnable;
    }

    public final void setBodeRunStopEnable(boolean z) {
        log("chNum", Boolean.valueOf(this.bodeRunStopEnable), Boolean.valueOf(z));
        this.bodeRunStopEnable = z;
        notifyPropertyChanged(104);
    }

    @Bindable
    public final int getBodeRunDispType() {
        return this.bodeRunDispType;
    }

    public final void setBodeRunDispType(int i) {
        log("chNum", Integer.valueOf(this.bodeRunDispType), Integer.valueOf(i));
        this.bodeRunDispType = i;
        notifyPropertyChanged(103);
    }

    @Bindable
    public final int getBodeSourceOut() {
        return this.bodeSourceOut;
    }

    public final void setBodeSourceOut(int i) {
        log("chNum", Integer.valueOf(this.bodeSourceOut), Integer.valueOf(i));
        this.bodeSourceOut = i;
        notifyPropertyChanged(106);
    }

    @Bindable
    public final int getBodeSourceIn() {
        return this.bodeSourceIn;
    }

    public final void setBodeSourceIn(int i) {
        log("chNum", Integer.valueOf(this.bodeSourceIn), Integer.valueOf(i));
        this.bodeSourceIn = i;
        notifyPropertyChanged(105);
    }

    @Bindable
    public final int getBodePointNum() {
        return this.bodePointNum;
    }

    public final void setBodePointNum(int i) {
        log("chNum", Integer.valueOf(this.bodePointNum), Integer.valueOf(i));
        this.bodePointNum = i;
        notifyPropertyChanged(102);
    }

    @Bindable
    public final int getBodeSweepType() {
        return this.bodeSweepType;
    }

    public final void setBodeSweepType(int i) {
        log("chNum", Integer.valueOf(this.bodeSweepType), Integer.valueOf(i));
        this.bodeSweepType = i;
        notifyPropertyChanged(109);
    }

    @Bindable
    public final int getBodedispType() {
        return this.bodedispType;
    }

    public final void setBodedispType(int i) {
        log("chNum", Integer.valueOf(this.bodedispType), Integer.valueOf(i));
        this.bodedispType = i;
        notifyPropertyChanged(109);
    }

    @Bindable
    public final boolean getBodeImpedace() {
        return this.bodeImpedace;
    }

    public final void setBodeImpedace(boolean z) {
        log("chNum", Boolean.valueOf(this.bodeImpedace), Boolean.valueOf(z));
        this.bodeImpedace = z;
        notifyPropertyChanged(98);
    }

    @Bindable
    public final boolean getBodeVaramp() {
        return this.bodeVaramp;
    }

    public final void setBodeVaramp(boolean z) {
        log("chNum", Boolean.valueOf(this.bodeVaramp), Boolean.valueOf(z));
        this.bodeVaramp = z;
        notifyPropertyChanged(110);
    }

    @Bindable
    public final long getBodeStartFreq() {
        return this.bodeStartFreq;
    }

    public final void setBodeStartFreq(long j) {
        log("chNum", Long.valueOf(this.bodeStartFreq), Long.valueOf(j));
        this.bodeStartFreq = j;
        notifyPropertyChanged(107);
    }

    @Bindable
    public final long getBodeStopFreq() {
        return this.bodeStopFreq;
    }

    public final void setBodeStopFreq(long j) {
        log("chNum", Long.valueOf(this.bodeStopFreq), Long.valueOf(j));
        this.bodeStopFreq = j;
        notifyPropertyChanged(108);
    }

    @Bindable
    public final long getBodeAmpout() {
        return this.bodeAmpout;
    }

    public final void setBodeAmpout(long j) {
        log("chNum", Long.valueOf(this.bodeAmpout), Long.valueOf(j));
        this.bodeAmpout = j;
        notifyPropertyChanged(91);
    }

    @Bindable
    public final long getBodevaramp1() {
        return this.bodevaramp1;
    }

    public final void setBodevaramp1(long j) {
        log("chNum", Long.valueOf(this.bodevaramp1), Long.valueOf(j));
        this.bodevaramp1 = j;
        notifyPropertyChanged(112);
    }

    @Bindable
    public final long getBodevaramp2() {
        return this.bodevaramp2;
    }

    public final void setBodevaramp2(long j) {
        log("chNum", Long.valueOf(this.bodevaramp2), Long.valueOf(j));
        this.bodevaramp2 = j;
        notifyPropertyChanged(113);
    }

    @Bindable
    public final long getBodevaramp3() {
        return this.bodevaramp3;
    }

    public final void setBodevaramp3(long j) {
        log("chNum", Long.valueOf(this.bodevaramp3), Long.valueOf(j));
        this.bodevaramp3 = j;
        notifyPropertyChanged(114);
    }

    @Bindable
    public final long getBodevaramp4() {
        return this.bodevaramp4;
    }

    public final void setBodevaramp4(long j) {
        log("chNum", Long.valueOf(this.bodevaramp4), Long.valueOf(j));
        this.bodevaramp4 = j;
        notifyPropertyChanged(115);
    }

    @Bindable
    public final long getBodevaramp5() {
        return this.bodevaramp5;
    }

    public final void setBodevaramp5(long j) {
        log("chNum", Long.valueOf(this.bodevaramp5), Long.valueOf(j));
        this.bodevaramp5 = j;
        notifyPropertyChanged(116);
    }

    @Bindable
    public final long getBodevaramp6() {
        return this.bodevaramp6;
    }

    public final void setBodevaramp6(long j) {
        log("chNum", Long.valueOf(this.bodevaramp6), Long.valueOf(j));
        this.bodevaramp6 = j;
        notifyPropertyChanged(117);
    }

    @Bindable
    public final long getBodevaramp7() {
        return this.bodevaramp7;
    }

    public final void setBodevaramp7(long j) {
        log("chNum", Long.valueOf(this.bodevaramp7), Long.valueOf(j));
        this.bodevaramp7 = j;
        notifyPropertyChanged(118);
    }

    @Bindable
    public final long getBodevaramp8() {
        return this.bodevaramp8;
    }

    public final void setBodevaramp8(long j) {
        log("chNum", Long.valueOf(this.bodevaramp8), Long.valueOf(j));
        this.bodevaramp8 = j;
        notifyPropertyChanged(119);
    }

    @Bindable
    public final String getBodeData() {
        return this.bodeData;
    }

    public final void setBodeData(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.bodeData, value);
        this.bodeData = value;
        notifyPropertyChanged(119);
    }

    @Bindable
    public final String getBodePmgmData() {
        return this.bodePmgmData;
    }

    public final void setBodePmgmData(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.bodePmgmData, value);
        this.bodePmgmData = value;
        notifyPropertyChanged(101);
    }

    @Bindable
    public final int getBodeDataWidth() {
        return this.bodeDataWidth;
    }

    public final void setBodeDataWidth(int i) {
        log("chNum", Integer.valueOf(this.bodeDataWidth), Integer.valueOf(i));
        this.bodeDataWidth = i;
        notifyPropertyChanged(119);
    }

    @Bindable
    public final int getBodeDataGain() {
        return this.bodeDataGain;
    }

    public final void setBodeDataGain(int i) {
        log("chNum", Integer.valueOf(this.bodeDataGain), Integer.valueOf(i));
        this.bodeDataGain = i;
        notifyPropertyChanged(93);
    }

    @Bindable
    public final int getBodeDataRange() {
        return this.bodeDataRange;
    }

    public final void setBodeDataRange(int i) {
        log("chNum", Integer.valueOf(this.bodeDataRange), Integer.valueOf(i));
        this.bodeDataRange = i;
        notifyPropertyChanged(94);
    }

    @Bindable
    public final double getLast_one() {
        return this.last_one;
    }

    public final void setLast_one(double d) {
        log("chNum", Double.valueOf(this.last_one), Double.valueOf(d));
        this.last_one = d;
        notifyPropertyChanged(94);
    }

    public final double getSpacing_width_unit() {
        return this.spacing_width_unit;
    }

    public final void setSpacing_width_unit(double d) {
        log("chNum", Double.valueOf(this.spacing_width_unit), Double.valueOf(d));
        this.spacing_width_unit = d;
        notifyPropertyChanged(94);
    }

    public final double getSpacing_heightunit() {
        return this.spacing_heightunit;
    }

    public final void setSpacing_heightunit(double d) {
        log("chNum", Double.valueOf(this.spacing_heightunit), Double.valueOf(d));
        this.spacing_heightunit = d;
        notifyPropertyChanged(94);
    }

    public final float getSpacing_width_middley() {
        return this.spacing_width_middley;
    }

    public final void setSpacing_width_middley(float f) {
        log("chNum", Float.valueOf(this.spacing_width_middley), Float.valueOf(f));
        this.spacing_width_middley = f;
        notifyPropertyChanged(94);
    }

    public final String getBode_result() {
        return this.bode_result;
    }

    public final void setBode_result(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.bode_result, value);
        this.bode_result = value;
        notifyPropertyChanged(94);
    }

    public final ArrayList<String> getBode_resultlist() {
        return this.bode_resultlist;
    }

    public final void setBode_resultlist(ArrayList<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.bode_resultlist, value);
        this.bode_resultlist = value;
        notifyPropertyChanged(94);
    }

    public final ArrayList<String> getBode_resultDatalist() {
        return this.bode_resultDatalist;
    }

    public final void setBode_resultDatalist(ArrayList<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("chNum", this.bode_resultDatalist, value);
        this.bode_resultDatalist = value;
        notifyPropertyChanged(94);
    }

    @Bindable
    public final boolean getBodeMinPop() {
        return this.bodeMinPop;
    }

    public final void setBodeMinPop(boolean z) {
        log("isEnable", Boolean.valueOf(this.bodeMinPop), Boolean.valueOf(z));
        this.bodeMinPop = z;
        notifyPropertyChanged(99);
    }

    public final int getBodeCursorPosition() {
        return this.bodeCursorPosition;
    }

    public final void setBodeCursorPosition(int i) {
        this.bodeCursorPosition = i;
    }

    public final void readBodeResult() {
        String str;
        String[][] queryData = queryData(getServiceId(), MessageID.MSG_BODE_RESULT);
        syncData(MessageID.MSG_BODE_RESULT, false);
        Intrinsics.checkNotNull(queryData);
        String[][] strArr = queryData;
        String[] strArr2 = strArr[0];
        Intrinsics.checkNotNull(strArr2);
        int length = strArr2.length;
        for (int i = 0; i < length; i++) {
            String[] strArr3 = strArr[0];
            if (strArr3 != null && (str = strArr3[i]) != null) {
                this.bode_resultlist.add(str);
            }
        }
    }

    public final void readbodePmgmData() {
        setBodePmgmData(readStr(MessageID.MSG_BODE_PMGM));
        syncData(MessageID.MSG_BODE_PMGM, this.bodePmgmData);
    }

    public final void readFirEnable() {
        setFirEnable(readBool(MessageID.MSG_BODE_FIR_ENABLE));
    }

    public final void saveFirEnable(boolean z) {
        setFirEnable(z);
        saveBool(MessageID.MSG_BODE_FIR_ENABLE, z);
    }

    public final void setBodeshow(boolean z) {
        setBodeMinPop(z);
    }

    public final String readBodeData() {
        setBodeData(readStr(MessageID.MSG_BODE_PLOTDATA));
        syncData(MessageID.MSG_BODE_PLOTDATA, this.bodeData);
        if (this.bodeRunStopEnable) {
            this.bodeDataString.add(this.bodeData);
        }
        return this.bodeData;
    }

    public final void readBodevaramp3AttrAttr() {
        readAttr(MessageID.MSG_BODE_VARAMP3, this.bodevaramp3Attr);
    }

    public final void readBodevaramp4AttrAttr() {
        readAttr(MessageID.MSG_BODE_VARAMP4, this.bodevaramp4Attr);
    }

    public final void readBodevaramp5AttrAttr() {
        readAttr(MessageID.MSG_BODE_VARAMP5, this.bodevaramp5Attr);
    }

    public final void readBodevaramp6AttrAttr() {
        readAttr(MessageID.MSG_BODE_VARAMP6, this.bodevaramp6Attr);
    }

    public final void readBodevaramp7AttrAttr() {
        readAttr(MessageID.MSG_BODE_VARAMP7, this.bodevaramp7Attr);
    }

    public final void readBodevaramp8AttrAttr() {
        readAttr(MessageID.MSG_BODE_VARAMP8, this.bodevaramp8Attr);
    }

    public final void readBodevaramp1AttrAttr() {
        readAttr(MessageID.MSG_BODE_VARAMP1, this.bodevaramp1Attr);
    }

    public final long readBodevaramp1() {
        setBodevaramp1(readLong(MessageID.MSG_BODE_VARAMP1));
        return this.bodevaramp1;
    }

    public final void saveBodevaramp1(long j) {
        setBodevaramp1(j);
        saveLong(MessageID.MSG_BODE_VARAMP1, j);
    }

    public final void readBodevaramp2AttrAttr() {
        readAttr(MessageID.MSG_BODE_VARAMP2, this.bodevaramp2Attr);
    }

    public final long readBodevaramp2() {
        setBodevaramp2(readLong(MessageID.MSG_BODE_VARAMP2));
        return this.bodevaramp2;
    }

    public final void saveBodevaramp2(long j) {
        setBodevaramp2(j);
        saveLong(MessageID.MSG_BODE_VARAMP2, j);
    }

    public final long readBodevaramp3() {
        setBodevaramp3(readLong(MessageID.MSG_BODE_VARAMP3));
        return this.bodevaramp3;
    }

    public final void saveBodevaramp3(long j) {
        setBodevaramp3(j);
        saveLong(MessageID.MSG_BODE_VARAMP3, j);
    }

    public final long readBodevaramp4() {
        setBodevaramp4(readLong(MessageID.MSG_BODE_VARAMP4));
        return this.bodevaramp4;
    }

    public final void saveBodevaramp4(long j) {
        setBodevaramp4(j);
        saveLong(MessageID.MSG_BODE_VARAMP4, j);
    }

    public final long readBodevaramp5() {
        setBodevaramp5(readLong(MessageID.MSG_BODE_VARAMP5));
        return this.bodevaramp5;
    }

    public final void saveBodevaramp5(long j) {
        setBodevaramp5(j);
        saveLong(MessageID.MSG_BODE_VARAMP5, j);
    }

    public final long readBodevaramp6() {
        setBodevaramp6(readLong(MessageID.MSG_BODE_VARAMP6));
        return this.bodevaramp6;
    }

    public final void saveBodevaramp6(long j) {
        setBodevaramp6(j);
        saveLong(MessageID.MSG_BODE_VARAMP6, j);
    }

    public final long readBodevaramp7() {
        setBodevaramp7(readLong(MessageID.MSG_BODE_VARAMP7));
        return this.bodevaramp7;
    }

    public final void saveBodevaramp7(long j) {
        setBodevaramp7(j);
        saveLong(MessageID.MSG_BODE_VARAMP7, j);
    }

    public final long readBodevaramp8() {
        setBodevaramp8(readLong(MessageID.MSG_BODE_VARAMP8));
        return this.bodevaramp8;
    }

    public final void saveBodevaramp8(long j) {
        setBodevaramp8(j);
        saveLong(MessageID.MSG_BODE_VARAMP8, j);
    }

    public final void readBodeAmpoutAttr() {
        readAttr(MessageID.MSG_BODE_AMPOUT, this.bodeAmpoutAttr);
    }

    public final long readBodeAmpout() {
        setBodeAmpout(readLong(MessageID.MSG_BODE_AMPOUT));
        return this.bodeAmpout;
    }

    public final void saveBodeAmpout(long j) {
        setBodeAmpout(j);
        saveLong(MessageID.MSG_BODE_AMPOUT, j);
    }

    public final void readBodeStopFreqAttr() {
        readAttr(MessageID.MSG_BODE_STOP_FREQ, this.bodeStopFreqAttr);
    }

    public final long readBodeStopFreq() {
        setBodeStopFreq(readLong(MessageID.MSG_BODE_STOP_FREQ));
        readBodeStartFreqAttr();
        readBodeStopFreqAttr();
        return this.bodeStopFreq;
    }

    public final void saveBodeStopFreq(long j) {
        setBodeStopFreq(j);
        syncData(MessageID.MSG_BODE_START_FREQ, Long.valueOf(j));
        saveLong(MessageID.MSG_BODE_STOP_FREQ, j);
    }

    public final void readBodeStartFreqAttr() {
        readAttr(MessageID.MSG_BODE_START_FREQ, this.bodeStartFreqAttr);
    }

    public final long readBodeStartFreq() {
        setBodeStartFreq(readLong(MessageID.MSG_BODE_START_FREQ));
        syncData(MessageID.MSG_BODE_START_FREQ, Long.valueOf(this.bodeStartFreq));
        syncData(MessageID.MSG_BODE_RUNSTOP, true);
        readBodeStartFreqAttr();
        readBodeStopFreqAttr();
        return this.bodeStartFreq;
    }

    public final void saveBodeStartFreq(long j) {
        setBodeStartFreq(j);
        saveLong(MessageID.MSG_BODE_START_FREQ, j);
        syncData(MessageID.MSG_BODE_START_FREQ, Long.valueOf(j));
    }

    public final boolean readBodeVaramp() {
        setBodeVaramp(readBool(MessageID.MSG_BODE_VARAMP));
        return this.bodeVaramp;
    }

    public final void saveBodeVaramp(boolean z) {
        setBodeVaramp(z);
        saveBool(MessageID.MSG_BODE_VARAMP, z);
    }

    public final boolean readBodeImpedace() {
        setBodeImpedace(readBool(MessageID.MSG_BODE_IMPEDANCE));
        return this.bodeImpedace;
    }

    public final void saveBodeImpedace(boolean z) {
        setBodeImpedace(z);
        saveBool(MessageID.MSG_BODE_IMPEDANCE, z);
    }

    public final int readBodedispType() {
        setBodedispType(readInt(MessageID.MSG_BODE_DISP_TYPE));
        return this.bodedispType;
    }

    public final void saveBodedispType(int i) {
        setBodedispType(i);
        saveInt(MessageID.MSG_BODE_DISP_TYPE, i);
        syncData(MessageID.MSG_BODE_ENABLE, Boolean.valueOf(this.bodeEnable));
    }

    public final int readBodeSweepType() {
        setBodeSweepType(readInt(MessageID.MSG_BODE_SWEEP_TYPE));
        return this.bodeSweepType;
    }

    public final void saveBodeSweepType(int i) {
        setBodeSweepType(i);
        saveInt(MessageID.MSG_BODE_SWEEP_TYPE, i);
    }

    public final void readBodePointNumAttr() {
        readAttr(MessageID.MSG_BODE_POINT_NUM, this.bodePointNumAttr);
    }

    public final int readBodePointNum() {
        setBodePointNum(readInt(MessageID.MSG_BODE_POINT_NUM));
        return this.bodePointNum;
    }

    public final void saveBodePointNum(int i) {
        setBodePointNum(i);
        saveInt(MessageID.MSG_BODE_POINT_NUM, i);
    }

    public final int readBodeSourceIn() {
        setBodeSourceIn(readInt(MessageID.MSG_BODE_SOURCE_IN));
        return this.bodeSourceIn;
    }

    public final void saveBodeSourceIn(int i) {
        setBodeSourceIn(i);
        saveInt(MessageID.MSG_BODE_SOURCE_IN, i);
    }

    public final int readBodeSourceOut() {
        setBodeSourceOut(readInt(MessageID.MSG_BODE_SOURCE_OUT));
        return this.bodeSourceOut;
    }

    public final void saveBodeSourceOut(int i) {
        setBodeSourceOut(i);
        saveInt(MessageID.MSG_BODE_SOURCE_OUT, i);
    }

    public final int readBodeRunDispType() {
        setBodeRunDispType(readInt(MessageID.MSG_BODE_DISP_TYPE));
        return this.bodeRunDispType;
    }

    public final void saveBodeRunDispType(int i) {
        setBodeRunDispType(i);
        saveInt(MessageID.MSG_BODE_DISP_TYPE, i);
    }

    public final boolean readBodeEnable() {
        setBodeEnable(readBool(MessageID.MSG_BODE_ENABLE));
        syncData(MessageID.MSG_BODE_ENABLE, Boolean.valueOf(this.bodeEnable));
        return this.bodeEnable;
    }

    public final void saveBodeEnable(boolean z) {
        setBodeEnable(z);
        saveBool(MessageID.MSG_BODE_ENABLE, z);
        syncData(MessageID.MSG_BODE_ENABLE, Boolean.valueOf(z));
    }

    public final void setBodeEnable1(boolean z) {
        setBodeEnable(z);
        saveBool(MessageID.MSG_BODE_ENABLE, z);
    }

    public final boolean readBodeRunStopEnable() {
        setBodeRunStopEnable(readBool(MessageID.MSG_BODE_RUNSTOP));
        return this.bodeRunStopEnable;
    }

    public final void saveBodeRunStopEnable(boolean z) {
        setBodeRunStopEnable(z);
        this.bode_resultlist.clear();
        saveBool(MessageID.MSG_BODE_RUNSTOP, z);
        syncData(MessageID.MSG_BODE_RUNSTOP, Boolean.valueOf(z));
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        super.readAll();
        readBodeRunStopEnable();
        readBodeSourceOut();
        readBodeSourceIn();
        readBodeSweepType();
        readBodeImpedace();
        readBodeVaramp();
        readBodeStopFreq();
        readBodeStartFreq();
        readBodePointNum();
        readBodeRunDispType();
        readBodeEnable();
        readBodeAmpout();
        readBodevaramp1();
        readBodevaramp2();
        readBodevaramp3();
        readBodevaramp4();
        readBodevaramp5();
        readBodevaramp6();
        readBodevaramp7();
        readBodevaramp8();
        readBodevaramp1AttrAttr();
        readBodevaramp2AttrAttr();
        readBodevaramp3AttrAttr();
        readBodevaramp4AttrAttr();
        readBodevaramp5AttrAttr();
        readBodevaramp6AttrAttr();
        readBodevaramp7AttrAttr();
        readBodevaramp8AttrAttr();
        readBodeStartFreqAttr();
        readBodePointNumAttr();
        readBodeStopFreqAttr();
        readBodeAmpoutAttr();
        readBodedispType();
        readFirEnable();
    }

    private final String[][] queryData(int i, int i2) {
        try {
            return (String[][]) GsonUtils.fromJson(API.getInstance().UI_QueryStr(i, i2), (Type) String[][].class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setBodeEnable(false);
        setBodeRunStopEnable(false);
        setBodeRunDispType(1);
        setBodeSourceOut(2);
        setBodeSourceIn(1);
        setBodePointNum(10);
        setBodeSweepType(0);
        setBodedispType(0);
        setBodeImpedace(false);
        setBodeVaramp(false);
        setBodeStartFreq(100000000L);
        setBodeStopFreq(1000000000000L);
        setBodeAmpout(200000000L);
        setBodevaramp1(200000000L);
        setBodevaramp2(200000000L);
        setBodevaramp3(200000000L);
        setBodevaramp4(200000000L);
        setBodevaramp5(200000000L);
        setBodevaramp6(200000000L);
        setBodevaramp7(200000000L);
        setBodevaramp8(200000000L);
        setBodeData("");
        setBodeDataWidth(0);
        setBodeDataGain(60);
        setBodeDataRange(180);
        setLast_one(0.0d);
        setSpacing_width_unit(0.0d);
        setSpacing_heightunit(0.0d);
        setSpacing_width_middley(0.0f);
        syncData(MessageID.MSG_BODE_ENABLE, false);
        setFirEnable(false);
    }
}
