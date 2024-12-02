package com.rigol.scope.views.window;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PathEffect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SimpleArrayMap;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ViewDragHelper;
import androidx.databinding.Observable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.utilities.Colors;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.DragViewUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.FlexKnobParamViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.MeasureResultViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.RefViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.CursorTag;
import com.rigol.scope.views.TagView;
import com.rigol.scope.views.ZoomWaveformView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.baseview.Indicator;
import com.rigol.scope.views.baseview.LabelView;
import com.rigol.scope.views.baseview.LineView;
import com.rigol.scope.views.baseview.MainWaveformView;
import com.rigol.scope.views.histogram.HistogramRectView;
import com.rigol.scope.views.histogram.HistogramResultParam;
import com.rigol.scope.views.histogram.HistogramSettingPopupView;
import com.rigol.scope.views.histogram.HistogramViewModel;
import com.rigol.scope.views.ref.RefPopupView;
import com.rigol.scope.views.window.WindowContent;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: WindowContent.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000à\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b'\b\u0016\u0018\u00002\u00020\u0001:\u0002¥\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u009c\u0001\u001a\u00030\u009d\u0001J-\u0010\u009e\u0001\u001a\u00030\u009d\u00012\u0007\u0010\u009f\u0001\u001a\u00020\u000e2\u0006\u0010v\u001a\u00020w2\u0007\u0010 \u0001\u001a\u00020\t2\u0007\u0010¡\u0001\u001a\u00020\tH\u0002J\b\u0010¢\u0001\u001a\u00030\u009d\u0001J\u0012\u0010£\u0001\u001a\u00030\u009d\u00012\b\u0010¤\u0001\u001a\u00030¥\u0001J\b\u0010¦\u0001\u001a\u00030\u009d\u0001J.\u0010§\u0001\u001a\u00030\u009d\u00012\b\u0010¨\u0001\u001a\u00030©\u00012\u0006\u0010v\u001a\u00020w2\u0007\u0010ª\u0001\u001a\u00020\t2\u0007\u0010«\u0001\u001a\u00020\tH\u0002J\b\u0010¬\u0001\u001a\u00030\u009d\u0001J\u001a\u0010\u00ad\u0001\u001a\u00030©\u00012\u0007\u0010®\u0001\u001a\u00020\t2\u0007\u0010¯\u0001\u001a\u00020\tJ\u0013\u0010°\u0001\u001a\u00030\u009d\u00012\u0007\u0010±\u0001\u001a\u00020\tH\u0002J\"\u0010²\u0001\u001a\u00030\u009d\u00012\u0007\u0010³\u0001\u001a\u00020\u00012\u0006\u0010v\u001a\u00020w2\u0007\u0010´\u0001\u001a\u00020\tJ=\u0010µ\u0001\u001a\u00030\u009d\u00012\u0007\u0010³\u0001\u001a\u00020\u00012\u0006\u0010v\u001a\u00020w2\u0007\u0010¶\u0001\u001a\u00020\t2\u0007\u0010·\u0001\u001a\u00020\t2\u0007\u0010¸\u0001\u001a\u00020\t2\u0007\u0010¹\u0001\u001a\u00020\tJ\b\u0010º\u0001\u001a\u00030\u009d\u0001J\b\u0010»\u0001\u001a\u00030\u009d\u0001J\b\u0010¼\u0001\u001a\u00030\u009d\u0001J\b\u0010½\u0001\u001a\u00030\u009d\u0001J\b\u0010¾\u0001\u001a\u00030\u009d\u0001J \u0010¿\u0001\u001a\u00030\u009d\u00012\n\u0010À\u0001\u001a\u0005\u0018\u00010Á\u00012\n\u0010¤\u0001\u001a\u0005\u0018\u00010¥\u0001J\u0019\u0010Â\u0001\u001a\u00030\u009d\u00012\u0006\u0010v\u001a\u00020w2\u0007\u0010´\u0001\u001a\u00020\tJ4\u0010Ã\u0001\u001a\u00030\u009d\u00012\u0006\u0010v\u001a\u00020w2\u0007\u0010¶\u0001\u001a\u00020\t2\u0007\u0010·\u0001\u001a\u00020\t2\u0007\u0010¸\u0001\u001a\u00020\t2\u0007\u0010¹\u0001\u001a\u00020\tJ\u0013\u0010Ä\u0001\u001a\u0005\u0018\u00010¥\u00012\u0007\u0010Å\u0001\u001a\u00020'J\u001c\u0010Ä\u0001\u001a\u0005\u0018\u00010¥\u00012\u0007\u0010Å\u0001\u001a\u00020'2\u0007\u0010±\u0001\u001a\u00020\tJ\u0015\u0010Æ\u0001\u001a\u0005\u0018\u00010Ç\u00012\u0007\u0010±\u0001\u001a\u00020\tH\u0002J*\u0010È\u0001\u001a\u0004\u0018\u00010\u0018\"\u0005\b\u0000\u0010É\u00012\u0007\u0010Å\u0001\u001a\u00020'2\u000f\u0010Ê\u0001\u001a\n\u0012\u0005\u0012\u0003HÉ\u00010Ë\u0001J3\u0010È\u0001\u001a\u0004\u0018\u00010\u0018\"\u0005\b\u0000\u0010É\u00012\u0007\u0010Å\u0001\u001a\u00020'2\u0007\u0010±\u0001\u001a\u00020\t2\u000f\u0010Ê\u0001\u001a\n\u0012\u0005\u0012\u0003HÉ\u00010Ë\u0001J\n\u0010Ì\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010Í\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010Î\u0001\u001a\u00030\u009d\u0001H\u0016J\b\u0010Ï\u0001\u001a\u00030\u009d\u0001J\u001b\u0010Ð\u0001\u001a\u00030¥\u00012\b\u0010Ñ\u0001\u001a\u00030Ò\u00012\u0007\u0010¯\u0001\u001a\u00020\tJ\u0013\u0010Ó\u0001\u001a\u00020q2\b\u0010Ô\u0001\u001a\u00030Õ\u0001H\u0016J7\u0010Ö\u0001\u001a\u00030\u009d\u00012\u0007\u0010×\u0001\u001a\u00020q2\u0007\u0010Ø\u0001\u001a\u00020\t2\u0007\u0010Ù\u0001\u001a\u00020\t2\u0007\u0010Ú\u0001\u001a\u00020\t2\u0007\u0010Û\u0001\u001a\u00020\tH\u0014J\u001c\u0010Ü\u0001\u001a\u00030\u009d\u00012\u0007\u0010Ý\u0001\u001a\u00020\t2\u0007\u0010Þ\u0001\u001a\u00020\tH\u0014J.\u0010ß\u0001\u001a\u00030\u009d\u00012\u0007\u0010à\u0001\u001a\u00020\t2\u0007\u0010á\u0001\u001a\u00020\t2\u0007\u0010â\u0001\u001a\u00020\t2\u0007\u0010ã\u0001\u001a\u00020\tH\u0014J\u0013\u0010ä\u0001\u001a\u00020q2\b\u0010å\u0001\u001a\u00030Õ\u0001H\u0016J\u0011\u0010æ\u0001\u001a\u00030\u009d\u00012\u0007\u0010®\u0001\u001a\u00020\tJ\u0013\u0010ç\u0001\u001a\u00030\u009d\u00012\u0007\u0010±\u0001\u001a\u00020\tH\u0002J\b\u0010è\u0001\u001a\u00030\u009d\u0001J\b\u0010é\u0001\u001a\u00030\u009d\u0001J\n\u0010ê\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010ë\u0001\u001a\u00030\u009d\u0001H\u0002J6\u0010ì\u0001\u001a\u00030\u009d\u00012\t\u0010í\u0001\u001a\u0004\u0018\u00010m2\u0019\u0010î\u0001\u001a\u0014\u0012\u000f\u0012\r\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010ï\u00010ï\u0001H\u0002¢\u0006\u0003\u0010ð\u0001J\n\u0010ñ\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010ò\u0001\u001a\u00030\u009d\u0001H\u0002J8\u0010ó\u0001\u001a\u00030\u009d\u00012\t\u0010í\u0001\u001a\u0004\u0018\u00010m2\u001b\u0010î\u0001\u001a\u0016\u0012\u000f\u0012\r\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010ï\u0001\u0018\u00010ï\u0001H\u0002¢\u0006\u0003\u0010ð\u0001J\n\u0010ô\u0001\u001a\u00030\u009d\u0001H\u0002J\n\u0010õ\u0001\u001a\u00030\u009d\u0001H\u0002J6\u0010ö\u0001\u001a\u00030\u009d\u00012\t\u0010í\u0001\u001a\u0004\u0018\u00010m2\u0019\u0010î\u0001\u001a\u0014\u0012\u000f\u0012\r\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010ï\u00010ï\u0001H\u0002¢\u0006\u0003\u0010ð\u0001J\b\u0010÷\u0001\u001a\u00030\u009d\u0001J\b\u0010ø\u0001\u001a\u00030\u009d\u0001J\b\u0010ù\u0001\u001a\u00030\u009d\u0001J\b\u0010ú\u0001\u001a\u00030\u009d\u0001J\n\u0010û\u0001\u001a\u00030\u009d\u0001H\u0002J\b\u0010ü\u0001\u001a\u00030\u009d\u0001J\u001e\u0010ý\u0001\u001a\u00030\u009d\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u00012\b\u0010\u0080\u0002\u001a\u00030Ç\u0001H\u0002J&\u0010\u0081\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u0082\u0002\u001a\u00020q2\u0007\u0010\u0083\u0002\u001a\u00020'2\b\u0010\u0080\u0002\u001a\u00030Ç\u0001H\u0002J\u001e\u0010\u0084\u0002\u001a\u00030\u009d\u00012\b\u0010þ\u0001\u001a\u00030ÿ\u00012\b\u0010\u0080\u0002\u001a\u00030Ç\u0001H\u0002J&\u0010\u0085\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u0086\u0002\u001a\u00020q2\b\u0010\u0087\u0002\u001a\u00030ÿ\u00012\u0007\u0010±\u0001\u001a\u00020\tH\u0002J\u000e\u0010\u0088\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u0089\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u008a\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u008b\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u008c\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u008d\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u008e\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u008f\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u0019\u0010\u0090\u0002\u001a\u00030\u009d\u0001*\u00020A2\t\u0010í\u0001\u001a\u0004\u0018\u00010mH\u0002J\u0019\u0010\u0091\u0002\u001a\u00030\u009d\u0001*\u00020A2\t\u0010í\u0001\u001a\u0004\u0018\u00010mH\u0002J\u0019\u0010\u0092\u0002\u001a\u00030\u009d\u0001*\u00020A2\t\u0010í\u0001\u001a\u0004\u0018\u00010mH\u0002J\u0019\u0010\u0093\u0002\u001a\u00030\u009d\u0001*\u00020A2\t\u0010í\u0001\u001a\u0004\u0018\u00010mH\u0002J\u000e\u0010\u0094\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u0095\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u0096\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u0097\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u0098\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u0099\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u009a\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u009b\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u009c\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010\u009d\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J1\u0010\u009e\u0002\u001a\u00030\u009d\u0001*\u00020A2\u001b\u0010î\u0001\u001a\u0016\u0012\u000f\u0012\r\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010ï\u0001\u0018\u00010ï\u0001H\u0002¢\u0006\u0003\u0010\u009f\u0002J1\u0010 \u0002\u001a\u00030\u009d\u0001*\u00020A2\u001b\u0010î\u0001\u001a\u0016\u0012\u000f\u0012\r\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010ï\u0001\u0018\u00010ï\u0001H\u0002¢\u0006\u0003\u0010\u009f\u0002J1\u0010¡\u0002\u001a\u00030\u009d\u0001*\u00020A2\u001b\u0010î\u0001\u001a\u0016\u0012\u000f\u0012\r\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010ï\u0001\u0018\u00010ï\u0001H\u0002¢\u0006\u0003\u0010\u009f\u0002J1\u0010¢\u0002\u001a\u00030\u009d\u0001*\u00020A2\u001b\u0010î\u0001\u001a\u0016\u0012\u000f\u0012\r\u0012\u0006\u0012\u0004\u0018\u00010'\u0018\u00010ï\u0001\u0018\u00010ï\u0001H\u0002¢\u0006\u0003\u0010\u009f\u0002J\u000e\u0010£\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002J\u000e\u0010¤\u0002\u001a\u00030\u009d\u0001*\u00020\u000eH\u0002R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u0013\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00180&X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u001c\u0010*\u001a\u0004\u0018\u00010+X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u00102\u001a\u0004\u0018\u000103¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u001c\u00106\u001a\u0004\u0018\u000107X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u0013\u0010<\u001a\u0004\u0018\u00010=¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010F\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010H\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\u0013\u0010M\u001a\u0004\u0018\u00010N¢\u0006\b\n\u0000\u001a\u0004\bO\u0010PR\u0013\u0010Q\u001a\u0004\u0018\u00010R¢\u0006\b\n\u0000\u001a\u0004\bS\u0010TR\u001c\u0010U\u001a\u0004\u0018\u00010VX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0013\u0010[\u001a\u0004\u0018\u00010\\¢\u0006\b\n\u0000\u001a\u0004\b]\u0010^R\u000e\u0010_\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010b\u001a\u0004\u0018\u00010cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\u0013\u0010h\u001a\u0004\u0018\u00010i¢\u0006\b\n\u0000\u001a\u0004\bj\u0010kR$\u0010l\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010m\u0018\u00010GX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bn\u0010J\"\u0004\bo\u0010LR\u001a\u0010p\u001a\u00020qX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\u0011\u0010v\u001a\u00020w¢\u0006\b\n\u0000\u001a\u0004\bx\u0010yR\u001c\u0010z\u001a\u0004\u0018\u00010{X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b|\u0010}\"\u0004\b~\u0010\u007fR\u0017\u0010\u0080\u0001\u001a\u0005\u0018\u00010\u0081\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0017\u0010\u0084\u0001\u001a\u0005\u0018\u00010\u0085\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001R\"\u0010\u0088\u0001\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00180&X\u0084\u0004¢\u0006\t\n\u0000\u001a\u0005\b\u0089\u0001\u0010)R\u0017\u0010\u008a\u0001\u001a\u0005\u0018\u00010\u008b\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R(\u0010\u008e\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010\u008f\u0001\u0018\u00010GX\u0086\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010J\"\u0005\b\u0091\u0001\u0010LR\u0017\u0010\u0092\u0001\u001a\u0005\u0018\u00010\u0093\u0001¢\u0006\n\n\u0000\u001a\u0006\b\u0094\u0001\u0010\u0095\u0001R \u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0086.¢\u0006\u0012\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001\"\u0006\b\u009a\u0001\u0010\u009b\u0001¨\u0006¦\u0002"}, d2 = {"Lcom/rigol/scope/views/window/WindowContent;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "captureStart", "captureTop", "cursorAx", "Lcom/rigol/scope/views/CursorTag;", "cursorAxShadow", "cursorAy", "cursorAyShadow", "cursorBx", "cursorBxShadow", "cursorBy", "cursorByShadow", "cursorObserver", "Landroidx/lifecycle/Observer;", "", "cursorResultParam", "Lcom/rigol/scope/data/CursorResultParam;", "getCursorResultParam", "()Lcom/rigol/scope/data/CursorResultParam;", "setCursorResultParam", "(Lcom/rigol/scope/data/CursorResultParam;)V", "cursorViewModel", "Lcom/rigol/scope/viewmodels/CursorViewModel;", "getCursorViewModel", "()Lcom/rigol/scope/viewmodels/CursorViewModel;", "dragHelper", "Landroidx/customview/widget/ViewDragHelper;", "guidelines", "Landroidx/collection/SimpleArrayMap;", "", "getGuidelines", "()Landroidx/collection/SimpleArrayMap;", "histogramParam", "Lcom/rigol/scope/views/histogram/HistogramResultParam;", "getHistogramParam", "()Lcom/rigol/scope/views/histogram/HistogramResultParam;", "setHistogramParam", "(Lcom/rigol/scope/views/histogram/HistogramResultParam;)V", "histogramRect", "Lcom/rigol/scope/views/histogram/HistogramRectView;", "histogramViewModel", "Lcom/rigol/scope/views/histogram/HistogramViewModel;", "getHistogramViewModel", "()Lcom/rigol/scope/views/histogram/HistogramViewModel;", "horizontalParam", "Lcom/rigol/scope/data/HorizontalParam;", "getHorizontalParam", "()Lcom/rigol/scope/data/HorizontalParam;", "setHorizontalParam", "(Lcom/rigol/scope/data/HorizontalParam;)V", "horizontalViewModel", "Lcom/rigol/scope/viewmodels/HorizontalViewModel;", "getHorizontalViewModel", "()Lcom/rigol/scope/viewmodels/HorizontalViewModel;", "indicatorAx", "Lcom/rigol/scope/views/baseview/Indicator;", "indicatorAy", "indicatorBx", "indicatorBy", "indicatorObserver", "mathParams", "", "Lcom/rigol/scope/data/MathParam;", "getMathParams", "()Ljava/util/List;", "setMathParams", "(Ljava/util/List;)V", "mathViewModel", "Lcom/rigol/scope/viewmodels/MathViewModel;", "getMathViewModel", "()Lcom/rigol/scope/viewmodels/MathViewModel;", "measureResultViewModel", "Lcom/rigol/scope/viewmodels/MeasureResultViewModel;", "getMeasureResultViewModel", "()Lcom/rigol/scope/viewmodels/MeasureResultViewModel;", "measureSettingParam", "Lcom/rigol/scope/data/MeasureSettingParam;", "getMeasureSettingParam", "()Lcom/rigol/scope/data/MeasureSettingParam;", "setMeasureSettingParam", "(Lcom/rigol/scope/data/MeasureSettingParam;)V", "measureSettingViewModel", "Lcom/rigol/scope/viewmodels/MeasureSettingViewModel;", "getMeasureSettingViewModel", "()Lcom/rigol/scope/viewmodels/MeasureSettingViewModel;", "messureCusorA", "messureCusorB", "refObserver", "refParam", "Lcom/rigol/scope/data/RefParam;", "getRefParam", "()Lcom/rigol/scope/data/RefParam;", "setRefParam", "(Lcom/rigol/scope/data/RefParam;)V", "refViewModel", "Lcom/rigol/scope/viewmodels/RefViewModel;", "getRefViewModel", "()Lcom/rigol/scope/viewmodels/RefViewModel;", "resultParams", "Lcom/rigol/scope/data/ResultParam;", "getResultParams", "setResultParams", "returnSuperOnTouch", "", "getReturnSuperOnTouch", "()Z", "setReturnSuperOnTouch", "(Z)V", "set", "Landroidx/constraintlayout/widget/ConstraintSet;", "getSet", "()Landroidx/constraintlayout/widget/ConstraintSet;", "sharedParam", "Lcom/rigol/scope/data/SharedParam;", "getSharedParam", "()Lcom/rigol/scope/data/SharedParam;", "setSharedParam", "(Lcom/rigol/scope/data/SharedParam;)V", "sharedViewModel", "Lcom/rigol/scope/viewmodels/SharedViewModel;", "getSharedViewModel", "()Lcom/rigol/scope/viewmodels/SharedViewModel;", "syncDataViewModel", "Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "getSyncDataViewModel", "()Lcom/rigol/scope/viewmodels/SyncDataViewModel;", "tagViews", "getTagViews", "updateUIViewModel", "Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "getUpdateUIViewModel", "()Lcom/rigol/scope/viewmodels/UpdateUIViewModel;", "verticalParams", "Lcom/rigol/scope/data/VerticalParam;", "getVerticalParams", "setVerticalParams", "verticalViewModel", "Lcom/rigol/scope/viewmodels/VerticalViewModel;", "getVerticalViewModel", "()Lcom/rigol/scope/viewmodels/VerticalViewModel;", "windowParam", "Lcom/rigol/scope/data/WindowParam;", "getWindowParam", "()Lcom/rigol/scope/data/WindowParam;", "setWindowParam", "(Lcom/rigol/scope/data/WindowParam;)V", "addCursorShadowTags", "", "addCursorTag", "cursorTag", "tagViewWidth", "tagViewHeight", "addCursorTags", "addGuideLine", "guideline", "Landroidx/constraintlayout/widget/Guideline;", "addHistogramRect", "addIndicator", "indicator", "Lcom/rigol/scope/views/baseview/LineView;", "width", "height", "addIndicators", "addLine", "id", "orientation", "addRefTag", "index", "applyClear", "layout", "viewId", "applyConnect", "startId", "startSide", "endId", "endSide", "bindCursor", "bindHistogram", "bindIndicator", "bindMeasureCursor", "bindRef", "bindToGuideLine", "view", "Landroid/view/View;", "clear", "connect", "getGuideLine", "key", "getRefTag", "Lcom/rigol/scope/views/TagView;", "getTagView", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Ljava/lang/Class;", "hideABxyCursor", "hideABxyCursorShadow", "hideABxyIndicator", "hideMeasureCursor", "newGuideLine", "percent", "", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onLayout", "changed", "left", "top", "right", "bottom", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSizeChanged", "w", "h", "oldw", "oldh", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "removeLine", "removeRefTag", "resetCursorTags", "setCursorTags", "showABxyCursor", "showABxyCursorShadow", "showABxyIndicator", "resultParam", "strings", "", "(Lcom/rigol/scope/data/ResultParam;[[Ljava/lang/String;)V", "showAxyCursor", "showAxyCursorShadow", "showAxyIndicator", "showBxyCursor", "showBxyCursorShadow", "showBxyIndicator", "showMeasureCursor", "unbindCursor", "unbindIndicator", "unbindRef", "updateABxyCursorShadowPosition", "updateCursorA_B", "updateRefColor", "param", "Lcom/rigol/scope/data/RefParam$Param;", "tagView", "updateRefLabel", "isShowLabel", "label", "updateRefPosition", "updateRefTag", "isCurrentWindow", "it", "getCursorAxRange", "getCursorAxShadowRange", "getCursorAyRange", "getCursorAyShadowRange", "getCursorBxRange", "getCursorBxShadowRange", "getCursorByRange", "getCursorByShadowRange", "getIndicatorAxRange", "getIndicatorAyRange", "getIndicatorBxRange", "getIndicatorByRange", "getMeasureCursorARange", "getMeasureCursorBRange", "updateCursorAxPosition", "updateCursorAxShadowPosition", "updateCursorAyPosition", "updateCursorAyShadowPosition", "updateCursorBxPosition", "updateCursorBxShadowPosition", "updateCursorByPosition", "updateCursorByShadowPosition", "updateIndicatorAxPosition", "(Lcom/rigol/scope/views/baseview/Indicator;[[Ljava/lang/String;)V", "updateIndicatorAyPosition", "updateIndicatorBxPosition", "updateIndicatorByPosition", "updateMeasureCursorAPosition", "updateMeasureCursorBPosition", "DragCallback2", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public class WindowContent extends ConstraintLayout {
    private int captureStart;
    private int captureTop;
    private final CursorTag cursorAx;
    private final CursorTag cursorAxShadow;
    private final CursorTag cursorAy;
    private final CursorTag cursorAyShadow;
    private final CursorTag cursorBx;
    private final CursorTag cursorBxShadow;
    private final CursorTag cursorBy;
    private final CursorTag cursorByShadow;
    private final Observer<Object> cursorObserver;
    private CursorResultParam cursorResultParam;
    private final CursorViewModel cursorViewModel;
    private final ViewDragHelper dragHelper;
    private final SimpleArrayMap<String, Object> guidelines;
    private HistogramResultParam histogramParam;
    private final HistogramRectView histogramRect;
    private final HistogramViewModel histogramViewModel;
    private HorizontalParam horizontalParam;
    private final HorizontalViewModel horizontalViewModel;
    private final Indicator indicatorAx;
    private final Indicator indicatorAy;
    private final Indicator indicatorBx;
    private final Indicator indicatorBy;
    private final Observer<Object> indicatorObserver;
    private List<? extends MathParam> mathParams;
    private final MathViewModel mathViewModel;
    private final MeasureResultViewModel measureResultViewModel;
    private MeasureSettingParam measureSettingParam;
    private final MeasureSettingViewModel measureSettingViewModel;
    private final CursorTag messureCusorA;
    private final CursorTag messureCusorB;
    private final Observer<Object> refObserver;
    private RefParam refParam;
    private final RefViewModel refViewModel;
    private List<? extends ResultParam> resultParams;
    private boolean returnSuperOnTouch;
    private final ConstraintSet set;
    private SharedParam sharedParam;
    private final SharedViewModel sharedViewModel;
    private final SyncDataViewModel syncDataViewModel;
    private final SimpleArrayMap<String, Object> tagViews;
    private final UpdateUIViewModel updateUIViewModel;
    private List<VerticalParam> verticalParams;
    private final VerticalViewModel verticalViewModel;
    public WindowParam windowParam;

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
        public static final /* synthetic */ int[] $EnumSwitchMapping$22;
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
            $EnumSwitchMapping$0[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$0[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr2 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$1[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$1[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr3 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$2[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$2[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr4 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$3[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$3[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr5 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$4[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$4[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr6 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$5[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$5[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr7 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$6[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$6[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr8 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$7 = iArr8;
            iArr8[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$7[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$7[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr9 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$8 = iArr9;
            iArr9[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$8[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$8[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr10 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$9 = iArr10;
            iArr10[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$9[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$9[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr11 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$10 = iArr11;
            iArr11[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$10[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$10[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr12 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$11 = iArr12;
            iArr12[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$11[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$11[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr13 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$12 = iArr13;
            iArr13[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            $EnumSwitchMapping$12[ServiceEnum.CursorMode.cursor_mode_track.ordinal()] = 2;
            $EnumSwitchMapping$12[ServiceEnum.CursorMode.cursor_mode_xy.ordinal()] = 3;
            int[] iArr14 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$13 = iArr14;
            iArr14[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$13[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$13[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr15 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$14 = iArr15;
            iArr15[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            int[] iArr16 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$15 = iArr16;
            iArr16[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$15[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$15[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr17 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$16 = iArr17;
            iArr17[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            int[] iArr18 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$17 = iArr18;
            iArr18[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$17[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$17[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr19 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$18 = iArr19;
            iArr19[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            int[] iArr20 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$19 = iArr20;
            iArr20[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$19[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$19[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr21 = new int[ServiceEnum.CursorMode.values().length];
            $EnumSwitchMapping$20 = iArr21;
            iArr21[ServiceEnum.CursorMode.cursor_mode_manual.ordinal()] = 1;
            int[] iArr22 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$21 = iArr22;
            iArr22[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$21[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$21[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
            int[] iArr23 = new int[ServiceEnum.WindowType.values().length];
            $EnumSwitchMapping$22 = iArr23;
            iArr23[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            $EnumSwitchMapping$22[ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM.ordinal()] = 2;
            $EnumSwitchMapping$22[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 3;
        }
    }

    public final WindowParam getWindowParam() {
        WindowParam windowParam = this.windowParam;
        if (windowParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("windowParam");
        }
        return windowParam;
    }

    public final void setWindowParam(WindowParam windowParam) {
        Intrinsics.checkNotNullParameter(windowParam, "<set-?>");
        this.windowParam = windowParam;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowContent(Context context) {
        super(context);
        LiveData<HistogramResultParam> liveData;
        MutableLiveData<Object> mutableLiveData;
        LiveData<RefParam> liveData2;
        LiveData<MeasureSettingParam> liveData3;
        LiveData<SharedParam> liveData4;
        MutableLiveData<List<ResultParam>> liveData5;
        LiveData<ArrayList<MathParam>> liveData6;
        LiveData<ArrayList<VerticalParam>> liveData7;
        LiveData<HorizontalParam> liveData8;
        LiveData<CursorResultParam> liveData9;
        LiveData<HistogramResultParam> liveData10;
        Intrinsics.checkNotNullParameter(context, "context");
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        this.sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        this.measureResultViewModel = (MeasureResultViewModel) ContextUtil.getAppViewModel(MeasureResultViewModel.class);
        this.measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        this.cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        this.horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        this.mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        this.refViewModel = (RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class);
        this.histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class);
        this.set = new ConstraintSet();
        this.tagViews = new SimpleArrayMap<>();
        this.guidelines = new SimpleArrayMap<>();
        Indicator indicator = new Indicator(getContext(), null);
        indicator.setId(ConstraintLayout.generateViewId());
        indicator.setOrientation(1);
        indicator.setVisibility(8);
        indicator.setLinePathEffect(new PathEffect());
        Unit unit = Unit.INSTANCE;
        this.indicatorAx = indicator;
        Indicator indicator2 = new Indicator(getContext(), null);
        indicator2.setId(ConstraintLayout.generateViewId());
        indicator2.setOrientation(0);
        indicator2.setVisibility(8);
        indicator2.setLinePathEffect(new PathEffect());
        Unit unit2 = Unit.INSTANCE;
        this.indicatorAy = indicator2;
        Indicator indicator3 = new Indicator(getContext(), null);
        indicator3.setId(ConstraintLayout.generateViewId());
        indicator3.setOrientation(1);
        indicator3.setVisibility(8);
        indicator3.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit3 = Unit.INSTANCE;
        this.indicatorBx = indicator3;
        Indicator indicator4 = new Indicator(getContext(), null);
        indicator4.setId(ConstraintLayout.generateViewId());
        indicator4.setOrientation(0);
        indicator4.setVisibility(8);
        indicator4.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit4 = Unit.INSTANCE;
        this.indicatorBy = indicator4;
        final CursorTag cursorTag = new CursorTag(getContext(), null, 1);
        cursorTag.setId(R.id.cursor_ax);
        cursorTag.setText("AX");
        cursorTag.setCousor_label("1");
        cursorTag.setCousor_showLabel_now(true);
        cursorTag.setShowLabel(true);
        cursorTag.setVisibility(8);
        cursorTag.setLinePathEffect(new PathEffect());
        cursorTag.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$1
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveAx((long) (CursorTag.this.getValue() + ((i3 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getAx());
                    CursorTag.this.setOtherValue(cursorResultParam.getBx());
                }
                this.getCursorAxRange(CursorTag.this);
            }
        });
        Unit unit5 = Unit.INSTANCE;
        this.cursorAx = cursorTag;
        final CursorTag cursorTag2 = new CursorTag(getContext(), null, 0);
        cursorTag2.setId(R.id.cursor_ay);
        cursorTag2.setText("AY");
        cursorTag2.setCousor_label("1");
        cursorTag2.setCousor_showLabel_now(false);
        cursorTag2.setShowLabel(true);
        cursorTag2.setVisibility(8);
        cursorTag2.setLinePathEffect(new PathEffect());
        cursorTag2.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$2
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveAy((long) (CursorTag.this.getValue() - ((i4 / this.getHeight()) * (CursorTag.this.getStartY() - CursorTag.this.getEndY()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getAy());
                    CursorTag.this.setOtherValue(cursorResultParam.getBy());
                }
                this.getCursorAyRange(CursorTag.this);
            }
        });
        Unit unit6 = Unit.INSTANCE;
        this.cursorAy = cursorTag2;
        final CursorTag cursorTag3 = new CursorTag(getContext(), null, 1);
        cursorTag3.setId(R.id.cursor_bx);
        cursorTag3.setText("BX");
        cursorTag3.setCousor_label(ExifInterface.GPS_MEASUREMENT_2D);
        cursorTag3.setCousor_showLabel_now(true);
        cursorTag3.setVisibility(8);
        cursorTag3.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        cursorTag3.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$3
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveBx((long) (CursorTag.this.getValue() + ((i3 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getBx());
                    CursorTag.this.setOtherValue(cursorResultParam.getAx());
                }
                this.getCursorBxRange(CursorTag.this);
            }
        });
        Unit unit7 = Unit.INSTANCE;
        this.cursorBx = cursorTag3;
        final CursorTag cursorTag4 = new CursorTag(getContext(), null, 0);
        cursorTag4.setId(R.id.cursor_by);
        cursorTag4.setText("BY");
        cursorTag4.setCousor_showLabel_now(false);
        cursorTag4.setCousor_label(ExifInterface.GPS_MEASUREMENT_2D);
        cursorTag4.setShowLabel(true);
        cursorTag4.setVisibility(8);
        cursorTag4.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        cursorTag4.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$4
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveBy((long) (CursorTag.this.getValue() - ((i4 / this.getHeight()) * (CursorTag.this.getStartY() - CursorTag.this.getEndY()))));
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getBy());
                    CursorTag.this.setOtherValue(cursorResultParam.getAy());
                }
                this.getCursorByRange(CursorTag.this);
            }
        });
        Unit unit8 = Unit.INSTANCE;
        this.cursorBy = cursorTag4;
        CursorTag cursorTag5 = new CursorTag(getContext(), null, 1);
        cursorTag5.setId(R.id.cursor_ax);
        cursorTag5.setText("AX");
        cursorTag5.setVisibility(8);
        cursorTag5.setDraggable(false);
        cursorTag5.setShowHint(false);
        cursorTag5.setLinePathEffect(new PathEffect());
        Unit unit9 = Unit.INSTANCE;
        this.cursorAxShadow = cursorTag5;
        CursorTag cursorTag6 = new CursorTag(getContext(), null, 0);
        cursorTag6.setId(R.id.cursor_ay);
        cursorTag6.setText("AY");
        cursorTag6.setVisibility(8);
        cursorTag6.setDraggable(false);
        cursorTag6.setShowHint(false);
        cursorTag6.setLinePathEffect(new PathEffect());
        Unit unit10 = Unit.INSTANCE;
        this.cursorAyShadow = cursorTag6;
        CursorTag cursorTag7 = new CursorTag(getContext(), null, 1);
        cursorTag7.setId(R.id.cursor_bx);
        cursorTag7.setText("BX");
        cursorTag7.setVisibility(8);
        cursorTag7.setDraggable(false);
        cursorTag7.setShowHint(false);
        cursorTag7.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit11 = Unit.INSTANCE;
        this.cursorBxShadow = cursorTag7;
        CursorTag cursorTag8 = new CursorTag(getContext(), null, 0);
        cursorTag8.setId(R.id.cursor_by);
        cursorTag8.setText("BY");
        cursorTag8.setVisibility(8);
        cursorTag8.setDraggable(false);
        cursorTag8.setShowHint(false);
        cursorTag8.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit12 = Unit.INSTANCE;
        this.cursorByShadow = cursorTag8;
        final HistogramRectView histogramRectView = new HistogramRectView(getContext());
        histogramRectView.setId(View.generateViewId());
        histogramRectView.setVisibility(4);
        histogramRectView.setCallback(new HistogramRectView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$5
            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onStart() {
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onEnd(float f, float f2, float f3, float f4) {
                HistogramResultParam histogramParam = this.getHistogramParam();
                if (histogramParam != null) {
                    histogramParam.saveLeftPosition((int) ((f / HistogramRectView.this.getMeasuredWidth()) * 1000));
                }
                HistogramResultParam histogramParam2 = this.getHistogramParam();
                if (histogramParam2 != null) {
                    histogramParam2.saveRightPosition((int) ((f2 / HistogramRectView.this.getMeasuredWidth()) * 1000));
                }
                HistogramResultParam histogramParam3 = this.getHistogramParam();
                if (histogramParam3 != null) {
                    histogramParam3.saveTopPosition((int) ((f3 / HistogramRectView.this.getMeasuredHeight()) * 480));
                }
                HistogramResultParam histogramParam4 = this.getHistogramParam();
                if (histogramParam4 != null) {
                    histogramParam4.saveBottomPosition((int) ((f4 / HistogramRectView.this.getMeasuredHeight()) * 480));
                }
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onClick() {
                Timber.d("Histo on long click", new Object[0]);
                BasePopupView basePopupView = PopupViewManager.getInstance().get(HistogramSettingPopupView.class);
                Intrinsics.checkNotNullExpressionValue(basePopupView, "PopupViewManager.getInst…ingPopupView::class.java]");
                if (basePopupView.isShowing()) {
                    return;
                }
                PopupViewManager.getInstance().toggle(HistogramSettingPopupView.class);
            }
        });
        Unit unit13 = Unit.INSTANCE;
        this.histogramRect = histogramRectView;
        setClipChildren(false);
        setClipToPadding(false);
        HistogramViewModel histogramViewModel = this.histogramViewModel;
        this.histogramParam = (histogramViewModel == null || (liveData10 = histogramViewModel.getLiveData()) == null) ? null : liveData10.getValue();
        CursorViewModel cursorViewModel = this.cursorViewModel;
        if (cursorViewModel != null && (liveData9 = cursorViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData9.observe((LifecycleOwner) topActivity, new Observer<CursorResultParam>() { // from class: com.rigol.scope.views.window.WindowContent.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(CursorResultParam cursorResultParam) {
                        Timber.d("Horizontal:UI:WindowContent:HorizontalParam:" + cursorResultParam, new Object[0]);
                        WindowContent.this.setCursorResultParam(cursorResultParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        HorizontalViewModel horizontalViewModel = this.horizontalViewModel;
        if (horizontalViewModel != null && (liveData8 = horizontalViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 != null) {
                liveData8.observe((LifecycleOwner) topActivity2, new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.window.WindowContent.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HorizontalParam horizontalParam) {
                        WindowContent.this.setHorizontalParam(horizontalParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        if (verticalViewModel != null && (liveData7 = verticalViewModel.getLiveData()) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 != null) {
                liveData7.observe((LifecycleOwner) topActivity3, new Observer<ArrayList<VerticalParam>>() { // from class: com.rigol.scope.views.window.WindowContent.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<VerticalParam> arrayList) {
                        WindowContent.this.setVerticalParams(arrayList);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MathViewModel mathViewModel = this.mathViewModel;
        if (mathViewModel != null && (liveData6 = mathViewModel.getLiveData()) != null) {
            Activity topActivity4 = ActivityUtils.getTopActivity();
            if (topActivity4 != null) {
                liveData6.observe((LifecycleOwner) topActivity4, new Observer<ArrayList<MathParam>>() { // from class: com.rigol.scope.views.window.WindowContent.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<MathParam> arrayList) {
                        WindowContent.this.setMathParams(arrayList);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureResultViewModel measureResultViewModel = this.measureResultViewModel;
        if (measureResultViewModel != null && (liveData5 = measureResultViewModel.getLiveData()) != null) {
            Activity topActivity5 = ActivityUtils.getTopActivity();
            if (topActivity5 != null) {
                liveData5.observe((LifecycleOwner) topActivity5, new Observer<List<? extends ResultParam>>() { // from class: com.rigol.scope.views.window.WindowContent.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(List<? extends ResultParam> list) {
                        WindowContent.this.setResultParams(list);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SharedViewModel sharedViewModel = this.sharedViewModel;
        if (sharedViewModel != null && (liveData4 = sharedViewModel.getLiveData()) != null) {
            Activity topActivity6 = ActivityUtils.getTopActivity();
            if (topActivity6 != null) {
                liveData4.observe((LifecycleOwner) topActivity6, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.WindowContent.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(SharedParam sharedParam) {
                        WindowContent.this.setSharedParam(sharedParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureSettingViewModel measureSettingViewModel = this.measureSettingViewModel;
        if (measureSettingViewModel != null && (liveData3 = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity7 = ActivityUtils.getTopActivity();
            if (topActivity7 != null) {
                liveData3.observe((LifecycleOwner) topActivity7, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.window.WindowContent.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        WindowContent.this.setMeasureSettingParam(measureSettingParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        RefViewModel refViewModel = this.refViewModel;
        if (refViewModel != null && (liveData2 = refViewModel.getLiveData()) != null) {
            Activity topActivity8 = ActivityUtils.getTopActivity();
            if (topActivity8 != null) {
                liveData2.observe((LifecycleOwner) topActivity8, new Observer<RefParam>() { // from class: com.rigol.scope.views.window.WindowContent.8
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(RefParam refParam) {
                        WindowContent.this.setRefParam(refParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_INDICATOR)) != null) {
            Activity topActivity9 = ActivityUtils.getTopActivity();
            if (topActivity9 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity9, new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent.9
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WindowContent.this.hideABxyIndicator();
                }
            });
        }
        HistogramViewModel histogramViewModel2 = this.histogramViewModel;
        if (histogramViewModel2 != null && (liveData = histogramViewModel2.getLiveData()) != null) {
            Activity topActivity10 = ActivityUtils.getTopActivity();
            if (topActivity10 != null) {
                liveData.observe((LifecycleOwner) topActivity10, new Observer<HistogramResultParam>() { // from class: com.rigol.scope.views.window.WindowContent.10
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HistogramResultParam histogramResultParam) {
                        Timber.d("Histogram:UI:WindowContent:HistogramGram:" + histogramResultParam, new Object[0]);
                        WindowContent.this.setHistogramParam(histogramResultParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        final CursorTag cursorTag9 = new CursorTag(getContext(), null, 1);
        cursorTag9.setId(View.generateViewId());
        cursorTag9.setText("CA");
        cursorTag9.setVisibility(8);
        cursorTag9.setLineColor(Color.parseColor("#00FF00"));
        cursorTag9.setLabelColor(Color.parseColor("#00FF00"));
        cursorTag9.setTagColor(Color.parseColor("#00FF00"));
        cursorTag9.setLinePathEffect(new PathEffect());
        cursorTag9.setTagStyle(Paint.Style.FILL);
        cursorTag9.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$6
            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    double width = (i3 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX());
                    if (measureSettingParam.getRegionSelect() == 2) {
                        long j = (long) width;
                        measureSettingParam.saveCursorA(((long) CursorTag.this.getValue()) + j);
                        measureSettingParam.saveCursorB(((long) CursorTag.this.getOtherValue()) + j);
                        return;
                    }
                    long j2 = (long) width;
                    double d = j2;
                    long value = (long) (CursorTag.this.getValue() + d);
                    Object m_MinValue = measureSettingParam.getCursorAAttr().getM_MinValue();
                    if (m_MinValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value < ((Long) m_MinValue).longValue()) {
                        Object m_MinValue2 = measureSettingParam.getCursorAAttr().getM_MinValue();
                        if (m_MinValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorA(((Long) m_MinValue2).longValue());
                        return;
                    }
                    long value2 = (long) (CursorTag.this.getValue() + d);
                    Object m_MaxValue = measureSettingParam.getCursorAAttr().getM_MaxValue();
                    if (m_MaxValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value2 > ((Long) m_MaxValue).longValue()) {
                        Object m_MaxValue2 = measureSettingParam.getCursorAAttr().getM_MaxValue();
                        if (m_MaxValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorA(((Long) m_MaxValue2).longValue());
                        return;
                    }
                    measureSettingParam.saveCursorA(((long) CursorTag.this.getValue()) + j2);
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    CursorTag.this.setValue(measureSettingParam.getCursorA());
                    CursorTag.this.setOtherValue(measureSettingParam.getCursorB());
                }
                this.getMeasureCursorARange(CursorTag.this);
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
                this.showMeasureCursor();
            }
        });
        Unit unit14 = Unit.INSTANCE;
        this.messureCusorA = cursorTag9;
        final CursorTag cursorTag10 = new CursorTag(getContext(), null, 1);
        cursorTag10.setId(View.generateViewId());
        cursorTag10.setText("CB");
        cursorTag10.setVisibility(8);
        cursorTag10.setLineColor(Color.parseColor("#00FF00"));
        cursorTag10.setLabelColor(Color.parseColor("#00FF00"));
        cursorTag10.setTagColor(Color.parseColor("#00FF00"));
        cursorTag10.setLinePathEffect(new PathEffect());
        cursorTag10.setTagStyle(Paint.Style.STROKE);
        cursorTag10.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$7
            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    double width = (i3 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX());
                    if (measureSettingParam.getRegionSelect() == 2) {
                        long j = (long) width;
                        measureSettingParam.saveCursorB(((long) CursorTag.this.getValue()) + j);
                        measureSettingParam.saveCursorA(((long) CursorTag.this.getOtherValue()) + j);
                        return;
                    }
                    long j2 = (long) width;
                    double d = j2;
                    long value = (long) (CursorTag.this.getValue() + d);
                    Object m_MinValue = measureSettingParam.getCursorBAttr().getM_MinValue();
                    if (m_MinValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value < ((Long) m_MinValue).longValue()) {
                        Object m_MinValue2 = measureSettingParam.getCursorBAttr().getM_MinValue();
                        if (m_MinValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorB(((Long) m_MinValue2).longValue());
                        return;
                    }
                    long value2 = (long) (CursorTag.this.getValue() + d);
                    Object m_MaxValue = measureSettingParam.getCursorBAttr().getM_MaxValue();
                    if (m_MaxValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value2 > ((Long) m_MaxValue).longValue()) {
                        Object m_MaxValue2 = measureSettingParam.getCursorBAttr().getM_MaxValue();
                        if (m_MaxValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorB(((Long) m_MaxValue2).longValue());
                        return;
                    }
                    measureSettingParam.saveCursorB(((long) CursorTag.this.getValue()) + j2);
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    CursorTag.this.setValue(measureSettingParam.getCursorB());
                    CursorTag.this.setOtherValue(measureSettingParam.getCursorA());
                }
                this.getMeasureCursorBRange(CursorTag.this);
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
                this.showMeasureCursor();
            }
        });
        Unit unit15 = Unit.INSTANCE;
        this.messureCusorB = cursorTag10;
        ViewDragHelper create = ViewDragHelper.create(this, new DragCallback2());
        Intrinsics.checkNotNullExpressionValue(create, "ViewDragHelper.create(th…Content, DragCallback2())");
        this.dragHelper = create;
        this.indicatorObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$indicatorObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                if (WindowContent.this.getSharedParam() == null || WindowContent.this.getResultParams() == null) {
                    return;
                }
                WindowContent.this.hideABxyIndicator();
                SharedParam sharedParam = WindowContent.this.getSharedParam();
                Intrinsics.checkNotNull(sharedParam);
                if (sharedParam.getCurrentResultItem() >= 0) {
                    SharedParam sharedParam2 = WindowContent.this.getSharedParam();
                    Intrinsics.checkNotNull(sharedParam2);
                    int currentResultItem = sharedParam2.getCurrentResultItem();
                    List<ResultParam> resultParams = WindowContent.this.getResultParams();
                    Intrinsics.checkNotNull(resultParams);
                    if (currentResultItem >= resultParams.size()) {
                        return;
                    }
                    List<ResultParam> resultParams2 = WindowContent.this.getResultParams();
                    Intrinsics.checkNotNull(resultParams2);
                    SharedParam sharedParam3 = WindowContent.this.getSharedParam();
                    Intrinsics.checkNotNull(sharedParam3);
                    ResultParam resultParam = resultParams2.get(sharedParam3.getCurrentResultItem());
                    if (resultParam == null || resultParam.getMeasType() == null || WindowContent.this.getMeasureSettingParam() == null) {
                        return;
                    }
                    MeasureSettingParam measureSettingParam = WindowContent.this.getMeasureSettingParam();
                    if (measureSettingParam == null || measureSettingParam.getCursorIndicator()) {
                        String[][] strArr = null;
                        try {
                            strArr = (String[][]) GsonUtils.fromJson(API.getInstance().UI_QueryStr(28, MessageID.MSG_MEAS_ITEM_ABXY), (Type) String[][].class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (strArr == null) {
                            return;
                        }
                        String[][] strArr2 = strArr;
                        if ((strArr2.length == 0) || strArr2.length == 0 || strArr[0] == null) {
                            return;
                        }
                        String[] strArr3 = strArr[0];
                        Intrinsics.checkNotNull(strArr3);
                        if (strArr3.length == 0) {
                            return;
                        }
                        String[] strArr4 = strArr[0];
                        Intrinsics.checkNotNull(strArr4);
                        if (strArr4.length < 11) {
                            return;
                        }
                        ServiceEnum.MeasType measType = resultParam.getMeasType();
                        Intrinsics.checkNotNull(measType);
                        if (measType.value1 > ServiceEnum.MeasType.Meas_VER_TYPE_END.value1) {
                            if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                                if (resultParam.getSourceA().value1 >= ServiceEnum.Chan.chan1.value1 && resultParam.getSourceA().value1 <= ServiceEnum.Chan.chan4.value1) {
                                    WindowContent.this.showAxyIndicator(resultParam, strArr);
                                }
                                if (resultParam.getSourceB().value1 < ServiceEnum.Chan.chan1.value1 || resultParam.getSourceB().value1 > ServiceEnum.Chan.chan4.value1) {
                                    return;
                                }
                                WindowContent.this.showBxyIndicator(resultParam, strArr);
                            } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH) {
                                if (resultParam.getSourceA().value1 >= ServiceEnum.Chan.m1.value1 && resultParam.getSourceA().value1 <= ServiceEnum.Chan.m4.value1 && resultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                                    WindowContent.this.showAxyIndicator(resultParam, strArr);
                                }
                                if (resultParam.getSourceB().value1 < ServiceEnum.Chan.m1.value1 || resultParam.getSourceB().value1 > ServiceEnum.Chan.m4.value1 || resultParam.getSourceB().value1 - ServiceEnum.Chan.m1.value1 != WindowContent.this.getWindowParam().getServiceID() - 17) {
                                    return;
                                }
                                WindowContent.this.showBxyIndicator(resultParam, strArr);
                            }
                        } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                            if (resultParam.getSourceA().value1 < ServiceEnum.Chan.chan1.value1 || resultParam.getSourceA().value1 > ServiceEnum.Chan.chan4.value1) {
                                return;
                            }
                            WindowContent.this.showABxyIndicator(resultParam, strArr);
                        } else if (WindowContent.this.getWindowParam().getType() != ServiceEnum.WindowType.WIN_MATH || resultParam.getSourceA().value1 < ServiceEnum.Chan.m1.value1 || resultParam.getSourceA().value1 > ServiceEnum.Chan.m4.value1 || resultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 != WindowContent.this.getWindowParam().getServiceID() - 17) {
                        } else {
                            WindowContent.this.showABxyIndicator(resultParam, strArr);
                        }
                    }
                }
            }
        };
        this.cursorObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$cursorObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CursorResultParam cursorResultParam;
                WindowContent.this.hideABxyCursor();
                if (WindowContent.this.getCursorResultParam() == null || (cursorResultParam = WindowContent.this.getCursorResultParam()) == null) {
                    return;
                }
                int i = WindowContent.WhenMappings.$EnumSwitchMapping$0[cursorResultParam.getCursorMode().ordinal()];
                if (i == 1) {
                    if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                        if (cursorResultParam.getSourceA().value1 < ServiceEnum.Chan.chan1.value1 || cursorResultParam.getSourceA().value1 > ServiceEnum.Chan.chan4.value1) {
                            return;
                        }
                        WindowContent.this.showABxyCursor();
                    } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH && cursorResultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                        WindowContent.this.showABxyCursor();
                    }
                } else if (i == 2) {
                    if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                        if (cursorResultParam.getSourceA().value1 >= ServiceEnum.Chan.chan1.value1 && cursorResultParam.getSourceA().value1 <= ServiceEnum.Chan.chan4.value1) {
                            WindowContent.this.showAxyCursor();
                        }
                        if (cursorResultParam.getSourceB().value1 < ServiceEnum.Chan.chan1.value1 || cursorResultParam.getSourceB().value1 > ServiceEnum.Chan.chan4.value1) {
                            return;
                        }
                        WindowContent.this.showBxyCursor();
                    } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH) {
                        if (cursorResultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                            WindowContent.this.showAxyCursor();
                        }
                        if (cursorResultParam.getSourceB().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                            WindowContent.this.showBxyCursor();
                        }
                    }
                } else if (i == 3 && WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_XY) {
                    WindowContent.this.showABxyCursor();
                }
            }
        };
        this.refObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$refObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RefParam refParam;
                if (!(obj instanceof Integer) || (refParam = WindowContent.this.getRefParam()) == null) {
                    return;
                }
                Number number = (Number) obj;
                RefParam.Param param = refParam.getParam(number.intValue());
                if (param == null || param.getSaveChan() == null) {
                    return;
                }
                if (param.getSaveChan().value1 >= ServiceEnum.Chan.chan1.value1 && param.getSaveChan().value1 <= ServiceEnum.Chan.d15.value1) {
                    WindowContent windowContent = WindowContent.this;
                    if ((windowContent instanceof MainWaveformView) || (windowContent instanceof ZoomWaveformView)) {
                        r3 = true;
                    }
                    WindowContent.this.updateRefTag(r3, param, number.intValue());
                } else if (param.getSaveChan().value1 < ServiceEnum.Chan.m1.value1 || param.getSaveChan().value1 > ServiceEnum.Chan.m4.value1) {
                } else {
                    if (param.getSaveChan().value1 == ServiceEnum.Chan.m1.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 17, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m2.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 18, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m3.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 19, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m4.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 20, param, number.intValue());
                    }
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowContent(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LiveData<HistogramResultParam> liveData;
        MutableLiveData<Object> mutableLiveData;
        LiveData<RefParam> liveData2;
        LiveData<MeasureSettingParam> liveData3;
        LiveData<SharedParam> liveData4;
        MutableLiveData<List<ResultParam>> liveData5;
        LiveData<ArrayList<MathParam>> liveData6;
        LiveData<ArrayList<VerticalParam>> liveData7;
        LiveData<HorizontalParam> liveData8;
        LiveData<CursorResultParam> liveData9;
        LiveData<HistogramResultParam> liveData10;
        Intrinsics.checkNotNullParameter(context, "context");
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        this.sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        this.measureResultViewModel = (MeasureResultViewModel) ContextUtil.getAppViewModel(MeasureResultViewModel.class);
        this.measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        this.cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        this.horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        this.mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        this.refViewModel = (RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class);
        this.histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class);
        this.set = new ConstraintSet();
        this.tagViews = new SimpleArrayMap<>();
        this.guidelines = new SimpleArrayMap<>();
        Indicator indicator = new Indicator(getContext(), null);
        indicator.setId(ConstraintLayout.generateViewId());
        indicator.setOrientation(1);
        indicator.setVisibility(8);
        indicator.setLinePathEffect(new PathEffect());
        Unit unit = Unit.INSTANCE;
        this.indicatorAx = indicator;
        Indicator indicator2 = new Indicator(getContext(), null);
        indicator2.setId(ConstraintLayout.generateViewId());
        indicator2.setOrientation(0);
        indicator2.setVisibility(8);
        indicator2.setLinePathEffect(new PathEffect());
        Unit unit2 = Unit.INSTANCE;
        this.indicatorAy = indicator2;
        Indicator indicator3 = new Indicator(getContext(), null);
        indicator3.setId(ConstraintLayout.generateViewId());
        indicator3.setOrientation(1);
        indicator3.setVisibility(8);
        indicator3.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit3 = Unit.INSTANCE;
        this.indicatorBx = indicator3;
        Indicator indicator4 = new Indicator(getContext(), null);
        indicator4.setId(ConstraintLayout.generateViewId());
        indicator4.setOrientation(0);
        indicator4.setVisibility(8);
        indicator4.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit4 = Unit.INSTANCE;
        this.indicatorBy = indicator4;
        final CursorTag cursorTag = new CursorTag(getContext(), null, 1);
        cursorTag.setId(R.id.cursor_ax);
        cursorTag.setText("AX");
        cursorTag.setCousor_label("1");
        cursorTag.setCousor_showLabel_now(true);
        cursorTag.setShowLabel(true);
        cursorTag.setVisibility(8);
        cursorTag.setLinePathEffect(new PathEffect());
        cursorTag.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$8
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveAx((long) (CursorTag.this.getValue() + ((i3 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getAx());
                    CursorTag.this.setOtherValue(cursorResultParam.getBx());
                }
                this.getCursorAxRange(CursorTag.this);
            }
        });
        Unit unit5 = Unit.INSTANCE;
        this.cursorAx = cursorTag;
        final CursorTag cursorTag2 = new CursorTag(getContext(), null, 0);
        cursorTag2.setId(R.id.cursor_ay);
        cursorTag2.setText("AY");
        cursorTag2.setCousor_label("1");
        cursorTag2.setCousor_showLabel_now(false);
        cursorTag2.setShowLabel(true);
        cursorTag2.setVisibility(8);
        cursorTag2.setLinePathEffect(new PathEffect());
        cursorTag2.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$9
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveAy((long) (CursorTag.this.getValue() - ((i4 / this.getHeight()) * (CursorTag.this.getStartY() - CursorTag.this.getEndY()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getAy());
                    CursorTag.this.setOtherValue(cursorResultParam.getBy());
                }
                this.getCursorAyRange(CursorTag.this);
            }
        });
        Unit unit6 = Unit.INSTANCE;
        this.cursorAy = cursorTag2;
        final CursorTag cursorTag3 = new CursorTag(getContext(), null, 1);
        cursorTag3.setId(R.id.cursor_bx);
        cursorTag3.setText("BX");
        cursorTag3.setCousor_label(ExifInterface.GPS_MEASUREMENT_2D);
        cursorTag3.setCousor_showLabel_now(true);
        cursorTag3.setVisibility(8);
        cursorTag3.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        cursorTag3.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$10
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveBx((long) (CursorTag.this.getValue() + ((i3 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getBx());
                    CursorTag.this.setOtherValue(cursorResultParam.getAx());
                }
                this.getCursorBxRange(CursorTag.this);
            }
        });
        Unit unit7 = Unit.INSTANCE;
        this.cursorBx = cursorTag3;
        final CursorTag cursorTag4 = new CursorTag(getContext(), null, 0);
        cursorTag4.setId(R.id.cursor_by);
        cursorTag4.setText("BY");
        cursorTag4.setCousor_showLabel_now(false);
        cursorTag4.setCousor_label(ExifInterface.GPS_MEASUREMENT_2D);
        cursorTag4.setShowLabel(true);
        cursorTag4.setVisibility(8);
        cursorTag4.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        cursorTag4.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$11
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveBy((long) (CursorTag.this.getValue() - ((i4 / this.getHeight()) * (CursorTag.this.getStartY() - CursorTag.this.getEndY()))));
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getBy());
                    CursorTag.this.setOtherValue(cursorResultParam.getAy());
                }
                this.getCursorByRange(CursorTag.this);
            }
        });
        Unit unit8 = Unit.INSTANCE;
        this.cursorBy = cursorTag4;
        CursorTag cursorTag5 = new CursorTag(getContext(), null, 1);
        cursorTag5.setId(R.id.cursor_ax);
        cursorTag5.setText("AX");
        cursorTag5.setVisibility(8);
        cursorTag5.setDraggable(false);
        cursorTag5.setShowHint(false);
        cursorTag5.setLinePathEffect(new PathEffect());
        Unit unit9 = Unit.INSTANCE;
        this.cursorAxShadow = cursorTag5;
        CursorTag cursorTag6 = new CursorTag(getContext(), null, 0);
        cursorTag6.setId(R.id.cursor_ay);
        cursorTag6.setText("AY");
        cursorTag6.setVisibility(8);
        cursorTag6.setDraggable(false);
        cursorTag6.setShowHint(false);
        cursorTag6.setLinePathEffect(new PathEffect());
        Unit unit10 = Unit.INSTANCE;
        this.cursorAyShadow = cursorTag6;
        CursorTag cursorTag7 = new CursorTag(getContext(), null, 1);
        cursorTag7.setId(R.id.cursor_bx);
        cursorTag7.setText("BX");
        cursorTag7.setVisibility(8);
        cursorTag7.setDraggable(false);
        cursorTag7.setShowHint(false);
        cursorTag7.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit11 = Unit.INSTANCE;
        this.cursorBxShadow = cursorTag7;
        CursorTag cursorTag8 = new CursorTag(getContext(), null, 0);
        cursorTag8.setId(R.id.cursor_by);
        cursorTag8.setText("BY");
        cursorTag8.setVisibility(8);
        cursorTag8.setDraggable(false);
        cursorTag8.setShowHint(false);
        cursorTag8.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit12 = Unit.INSTANCE;
        this.cursorByShadow = cursorTag8;
        final HistogramRectView histogramRectView = new HistogramRectView(getContext());
        histogramRectView.setId(View.generateViewId());
        histogramRectView.setVisibility(4);
        histogramRectView.setCallback(new HistogramRectView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$12
            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onStart() {
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onEnd(float f, float f2, float f3, float f4) {
                HistogramResultParam histogramParam = this.getHistogramParam();
                if (histogramParam != null) {
                    histogramParam.saveLeftPosition((int) ((f / HistogramRectView.this.getMeasuredWidth()) * 1000));
                }
                HistogramResultParam histogramParam2 = this.getHistogramParam();
                if (histogramParam2 != null) {
                    histogramParam2.saveRightPosition((int) ((f2 / HistogramRectView.this.getMeasuredWidth()) * 1000));
                }
                HistogramResultParam histogramParam3 = this.getHistogramParam();
                if (histogramParam3 != null) {
                    histogramParam3.saveTopPosition((int) ((f3 / HistogramRectView.this.getMeasuredHeight()) * 480));
                }
                HistogramResultParam histogramParam4 = this.getHistogramParam();
                if (histogramParam4 != null) {
                    histogramParam4.saveBottomPosition((int) ((f4 / HistogramRectView.this.getMeasuredHeight()) * 480));
                }
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onClick() {
                Timber.d("Histo on long click", new Object[0]);
                BasePopupView basePopupView = PopupViewManager.getInstance().get(HistogramSettingPopupView.class);
                Intrinsics.checkNotNullExpressionValue(basePopupView, "PopupViewManager.getInst…ingPopupView::class.java]");
                if (basePopupView.isShowing()) {
                    return;
                }
                PopupViewManager.getInstance().toggle(HistogramSettingPopupView.class);
            }
        });
        Unit unit13 = Unit.INSTANCE;
        this.histogramRect = histogramRectView;
        setClipChildren(false);
        setClipToPadding(false);
        HistogramViewModel histogramViewModel = this.histogramViewModel;
        this.histogramParam = (histogramViewModel == null || (liveData10 = histogramViewModel.getLiveData()) == null) ? null : liveData10.getValue();
        CursorViewModel cursorViewModel = this.cursorViewModel;
        if (cursorViewModel != null && (liveData9 = cursorViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData9.observe((LifecycleOwner) topActivity, new Observer<CursorResultParam>() { // from class: com.rigol.scope.views.window.WindowContent.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(CursorResultParam cursorResultParam) {
                        Timber.d("Horizontal:UI:WindowContent:HorizontalParam:" + cursorResultParam, new Object[0]);
                        WindowContent.this.setCursorResultParam(cursorResultParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        HorizontalViewModel horizontalViewModel = this.horizontalViewModel;
        if (horizontalViewModel != null && (liveData8 = horizontalViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 != null) {
                liveData8.observe((LifecycleOwner) topActivity2, new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.window.WindowContent.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HorizontalParam horizontalParam) {
                        WindowContent.this.setHorizontalParam(horizontalParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        if (verticalViewModel != null && (liveData7 = verticalViewModel.getLiveData()) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 != null) {
                liveData7.observe((LifecycleOwner) topActivity3, new Observer<ArrayList<VerticalParam>>() { // from class: com.rigol.scope.views.window.WindowContent.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<VerticalParam> arrayList) {
                        WindowContent.this.setVerticalParams(arrayList);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MathViewModel mathViewModel = this.mathViewModel;
        if (mathViewModel != null && (liveData6 = mathViewModel.getLiveData()) != null) {
            Activity topActivity4 = ActivityUtils.getTopActivity();
            if (topActivity4 != null) {
                liveData6.observe((LifecycleOwner) topActivity4, new Observer<ArrayList<MathParam>>() { // from class: com.rigol.scope.views.window.WindowContent.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<MathParam> arrayList) {
                        WindowContent.this.setMathParams(arrayList);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureResultViewModel measureResultViewModel = this.measureResultViewModel;
        if (measureResultViewModel != null && (liveData5 = measureResultViewModel.getLiveData()) != null) {
            Activity topActivity5 = ActivityUtils.getTopActivity();
            if (topActivity5 != null) {
                liveData5.observe((LifecycleOwner) topActivity5, new Observer<List<? extends ResultParam>>() { // from class: com.rigol.scope.views.window.WindowContent.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(List<? extends ResultParam> list) {
                        WindowContent.this.setResultParams(list);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SharedViewModel sharedViewModel = this.sharedViewModel;
        if (sharedViewModel != null && (liveData4 = sharedViewModel.getLiveData()) != null) {
            Activity topActivity6 = ActivityUtils.getTopActivity();
            if (topActivity6 != null) {
                liveData4.observe((LifecycleOwner) topActivity6, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.WindowContent.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(SharedParam sharedParam) {
                        WindowContent.this.setSharedParam(sharedParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureSettingViewModel measureSettingViewModel = this.measureSettingViewModel;
        if (measureSettingViewModel != null && (liveData3 = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity7 = ActivityUtils.getTopActivity();
            if (topActivity7 != null) {
                liveData3.observe((LifecycleOwner) topActivity7, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.window.WindowContent.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        WindowContent.this.setMeasureSettingParam(measureSettingParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        RefViewModel refViewModel = this.refViewModel;
        if (refViewModel != null && (liveData2 = refViewModel.getLiveData()) != null) {
            Activity topActivity8 = ActivityUtils.getTopActivity();
            if (topActivity8 != null) {
                liveData2.observe((LifecycleOwner) topActivity8, new Observer<RefParam>() { // from class: com.rigol.scope.views.window.WindowContent.8
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(RefParam refParam) {
                        WindowContent.this.setRefParam(refParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_INDICATOR)) != null) {
            Activity topActivity9 = ActivityUtils.getTopActivity();
            if (topActivity9 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity9, new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent.9
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WindowContent.this.hideABxyIndicator();
                }
            });
        }
        HistogramViewModel histogramViewModel2 = this.histogramViewModel;
        if (histogramViewModel2 != null && (liveData = histogramViewModel2.getLiveData()) != null) {
            Activity topActivity10 = ActivityUtils.getTopActivity();
            if (topActivity10 != null) {
                liveData.observe((LifecycleOwner) topActivity10, new Observer<HistogramResultParam>() { // from class: com.rigol.scope.views.window.WindowContent.10
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HistogramResultParam histogramResultParam) {
                        Timber.d("Histogram:UI:WindowContent:HistogramGram:" + histogramResultParam, new Object[0]);
                        WindowContent.this.setHistogramParam(histogramResultParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        final CursorTag cursorTag9 = new CursorTag(getContext(), null, 1);
        cursorTag9.setId(View.generateViewId());
        cursorTag9.setText("CA");
        cursorTag9.setVisibility(8);
        cursorTag9.setLineColor(Color.parseColor("#00FF00"));
        cursorTag9.setLabelColor(Color.parseColor("#00FF00"));
        cursorTag9.setTagColor(Color.parseColor("#00FF00"));
        cursorTag9.setLinePathEffect(new PathEffect());
        cursorTag9.setTagStyle(Paint.Style.FILL);
        cursorTag9.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$13
            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    double width = (i3 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX());
                    if (measureSettingParam.getRegionSelect() == 2) {
                        long j = (long) width;
                        measureSettingParam.saveCursorA(((long) CursorTag.this.getValue()) + j);
                        measureSettingParam.saveCursorB(((long) CursorTag.this.getOtherValue()) + j);
                        return;
                    }
                    long j2 = (long) width;
                    double d = j2;
                    long value = (long) (CursorTag.this.getValue() + d);
                    Object m_MinValue = measureSettingParam.getCursorAAttr().getM_MinValue();
                    if (m_MinValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value < ((Long) m_MinValue).longValue()) {
                        Object m_MinValue2 = measureSettingParam.getCursorAAttr().getM_MinValue();
                        if (m_MinValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorA(((Long) m_MinValue2).longValue());
                        return;
                    }
                    long value2 = (long) (CursorTag.this.getValue() + d);
                    Object m_MaxValue = measureSettingParam.getCursorAAttr().getM_MaxValue();
                    if (m_MaxValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value2 > ((Long) m_MaxValue).longValue()) {
                        Object m_MaxValue2 = measureSettingParam.getCursorAAttr().getM_MaxValue();
                        if (m_MaxValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorA(((Long) m_MaxValue2).longValue());
                        return;
                    }
                    measureSettingParam.saveCursorA(((long) CursorTag.this.getValue()) + j2);
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    CursorTag.this.setValue(measureSettingParam.getCursorA());
                    CursorTag.this.setOtherValue(measureSettingParam.getCursorB());
                }
                this.getMeasureCursorARange(CursorTag.this);
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
                this.showMeasureCursor();
            }
        });
        Unit unit14 = Unit.INSTANCE;
        this.messureCusorA = cursorTag9;
        final CursorTag cursorTag10 = new CursorTag(getContext(), null, 1);
        cursorTag10.setId(View.generateViewId());
        cursorTag10.setText("CB");
        cursorTag10.setVisibility(8);
        cursorTag10.setLineColor(Color.parseColor("#00FF00"));
        cursorTag10.setLabelColor(Color.parseColor("#00FF00"));
        cursorTag10.setTagColor(Color.parseColor("#00FF00"));
        cursorTag10.setLinePathEffect(new PathEffect());
        cursorTag10.setTagStyle(Paint.Style.STROKE);
        cursorTag10.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$14
            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    double width = (i3 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX());
                    if (measureSettingParam.getRegionSelect() == 2) {
                        long j = (long) width;
                        measureSettingParam.saveCursorB(((long) CursorTag.this.getValue()) + j);
                        measureSettingParam.saveCursorA(((long) CursorTag.this.getOtherValue()) + j);
                        return;
                    }
                    long j2 = (long) width;
                    double d = j2;
                    long value = (long) (CursorTag.this.getValue() + d);
                    Object m_MinValue = measureSettingParam.getCursorBAttr().getM_MinValue();
                    if (m_MinValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value < ((Long) m_MinValue).longValue()) {
                        Object m_MinValue2 = measureSettingParam.getCursorBAttr().getM_MinValue();
                        if (m_MinValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorB(((Long) m_MinValue2).longValue());
                        return;
                    }
                    long value2 = (long) (CursorTag.this.getValue() + d);
                    Object m_MaxValue = measureSettingParam.getCursorBAttr().getM_MaxValue();
                    if (m_MaxValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value2 > ((Long) m_MaxValue).longValue()) {
                        Object m_MaxValue2 = measureSettingParam.getCursorBAttr().getM_MaxValue();
                        if (m_MaxValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorB(((Long) m_MaxValue2).longValue());
                        return;
                    }
                    measureSettingParam.saveCursorB(((long) CursorTag.this.getValue()) + j2);
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    CursorTag.this.setValue(measureSettingParam.getCursorB());
                    CursorTag.this.setOtherValue(measureSettingParam.getCursorA());
                }
                this.getMeasureCursorBRange(CursorTag.this);
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
                this.showMeasureCursor();
            }
        });
        Unit unit15 = Unit.INSTANCE;
        this.messureCusorB = cursorTag10;
        ViewDragHelper create = ViewDragHelper.create(this, new DragCallback2());
        Intrinsics.checkNotNullExpressionValue(create, "ViewDragHelper.create(th…Content, DragCallback2())");
        this.dragHelper = create;
        this.indicatorObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$indicatorObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                if (WindowContent.this.getSharedParam() == null || WindowContent.this.getResultParams() == null) {
                    return;
                }
                WindowContent.this.hideABxyIndicator();
                SharedParam sharedParam = WindowContent.this.getSharedParam();
                Intrinsics.checkNotNull(sharedParam);
                if (sharedParam.getCurrentResultItem() >= 0) {
                    SharedParam sharedParam2 = WindowContent.this.getSharedParam();
                    Intrinsics.checkNotNull(sharedParam2);
                    int currentResultItem = sharedParam2.getCurrentResultItem();
                    List<ResultParam> resultParams = WindowContent.this.getResultParams();
                    Intrinsics.checkNotNull(resultParams);
                    if (currentResultItem >= resultParams.size()) {
                        return;
                    }
                    List<ResultParam> resultParams2 = WindowContent.this.getResultParams();
                    Intrinsics.checkNotNull(resultParams2);
                    SharedParam sharedParam3 = WindowContent.this.getSharedParam();
                    Intrinsics.checkNotNull(sharedParam3);
                    ResultParam resultParam = resultParams2.get(sharedParam3.getCurrentResultItem());
                    if (resultParam == null || resultParam.getMeasType() == null || WindowContent.this.getMeasureSettingParam() == null) {
                        return;
                    }
                    MeasureSettingParam measureSettingParam = WindowContent.this.getMeasureSettingParam();
                    if (measureSettingParam == null || measureSettingParam.getCursorIndicator()) {
                        String[][] strArr = null;
                        try {
                            strArr = (String[][]) GsonUtils.fromJson(API.getInstance().UI_QueryStr(28, MessageID.MSG_MEAS_ITEM_ABXY), (Type) String[][].class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (strArr == null) {
                            return;
                        }
                        String[][] strArr2 = strArr;
                        if ((strArr2.length == 0) || strArr2.length == 0 || strArr[0] == null) {
                            return;
                        }
                        String[] strArr3 = strArr[0];
                        Intrinsics.checkNotNull(strArr3);
                        if (strArr3.length == 0) {
                            return;
                        }
                        String[] strArr4 = strArr[0];
                        Intrinsics.checkNotNull(strArr4);
                        if (strArr4.length < 11) {
                            return;
                        }
                        ServiceEnum.MeasType measType = resultParam.getMeasType();
                        Intrinsics.checkNotNull(measType);
                        if (measType.value1 > ServiceEnum.MeasType.Meas_VER_TYPE_END.value1) {
                            if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                                if (resultParam.getSourceA().value1 >= ServiceEnum.Chan.chan1.value1 && resultParam.getSourceA().value1 <= ServiceEnum.Chan.chan4.value1) {
                                    WindowContent.this.showAxyIndicator(resultParam, strArr);
                                }
                                if (resultParam.getSourceB().value1 < ServiceEnum.Chan.chan1.value1 || resultParam.getSourceB().value1 > ServiceEnum.Chan.chan4.value1) {
                                    return;
                                }
                                WindowContent.this.showBxyIndicator(resultParam, strArr);
                            } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH) {
                                if (resultParam.getSourceA().value1 >= ServiceEnum.Chan.m1.value1 && resultParam.getSourceA().value1 <= ServiceEnum.Chan.m4.value1 && resultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                                    WindowContent.this.showAxyIndicator(resultParam, strArr);
                                }
                                if (resultParam.getSourceB().value1 < ServiceEnum.Chan.m1.value1 || resultParam.getSourceB().value1 > ServiceEnum.Chan.m4.value1 || resultParam.getSourceB().value1 - ServiceEnum.Chan.m1.value1 != WindowContent.this.getWindowParam().getServiceID() - 17) {
                                    return;
                                }
                                WindowContent.this.showBxyIndicator(resultParam, strArr);
                            }
                        } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                            if (resultParam.getSourceA().value1 < ServiceEnum.Chan.chan1.value1 || resultParam.getSourceA().value1 > ServiceEnum.Chan.chan4.value1) {
                                return;
                            }
                            WindowContent.this.showABxyIndicator(resultParam, strArr);
                        } else if (WindowContent.this.getWindowParam().getType() != ServiceEnum.WindowType.WIN_MATH || resultParam.getSourceA().value1 < ServiceEnum.Chan.m1.value1 || resultParam.getSourceA().value1 > ServiceEnum.Chan.m4.value1 || resultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 != WindowContent.this.getWindowParam().getServiceID() - 17) {
                        } else {
                            WindowContent.this.showABxyIndicator(resultParam, strArr);
                        }
                    }
                }
            }
        };
        this.cursorObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$cursorObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CursorResultParam cursorResultParam;
                WindowContent.this.hideABxyCursor();
                if (WindowContent.this.getCursorResultParam() == null || (cursorResultParam = WindowContent.this.getCursorResultParam()) == null) {
                    return;
                }
                int i = WindowContent.WhenMappings.$EnumSwitchMapping$0[cursorResultParam.getCursorMode().ordinal()];
                if (i == 1) {
                    if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                        if (cursorResultParam.getSourceA().value1 < ServiceEnum.Chan.chan1.value1 || cursorResultParam.getSourceA().value1 > ServiceEnum.Chan.chan4.value1) {
                            return;
                        }
                        WindowContent.this.showABxyCursor();
                    } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH && cursorResultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                        WindowContent.this.showABxyCursor();
                    }
                } else if (i == 2) {
                    if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                        if (cursorResultParam.getSourceA().value1 >= ServiceEnum.Chan.chan1.value1 && cursorResultParam.getSourceA().value1 <= ServiceEnum.Chan.chan4.value1) {
                            WindowContent.this.showAxyCursor();
                        }
                        if (cursorResultParam.getSourceB().value1 < ServiceEnum.Chan.chan1.value1 || cursorResultParam.getSourceB().value1 > ServiceEnum.Chan.chan4.value1) {
                            return;
                        }
                        WindowContent.this.showBxyCursor();
                    } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH) {
                        if (cursorResultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                            WindowContent.this.showAxyCursor();
                        }
                        if (cursorResultParam.getSourceB().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                            WindowContent.this.showBxyCursor();
                        }
                    }
                } else if (i == 3 && WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_XY) {
                    WindowContent.this.showABxyCursor();
                }
            }
        };
        this.refObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$refObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RefParam refParam;
                if (!(obj instanceof Integer) || (refParam = WindowContent.this.getRefParam()) == null) {
                    return;
                }
                Number number = (Number) obj;
                RefParam.Param param = refParam.getParam(number.intValue());
                if (param == null || param.getSaveChan() == null) {
                    return;
                }
                if (param.getSaveChan().value1 >= ServiceEnum.Chan.chan1.value1 && param.getSaveChan().value1 <= ServiceEnum.Chan.d15.value1) {
                    WindowContent windowContent = WindowContent.this;
                    if ((windowContent instanceof MainWaveformView) || (windowContent instanceof ZoomWaveformView)) {
                        r3 = true;
                    }
                    WindowContent.this.updateRefTag(r3, param, number.intValue());
                } else if (param.getSaveChan().value1 < ServiceEnum.Chan.m1.value1 || param.getSaveChan().value1 > ServiceEnum.Chan.m4.value1) {
                } else {
                    if (param.getSaveChan().value1 == ServiceEnum.Chan.m1.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 17, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m2.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 18, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m3.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 19, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m4.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 20, param, number.intValue());
                    }
                }
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WindowContent(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        LiveData<HistogramResultParam> liveData;
        MutableLiveData<Object> mutableLiveData;
        LiveData<RefParam> liveData2;
        LiveData<MeasureSettingParam> liveData3;
        LiveData<SharedParam> liveData4;
        MutableLiveData<List<ResultParam>> liveData5;
        LiveData<ArrayList<MathParam>> liveData6;
        LiveData<ArrayList<VerticalParam>> liveData7;
        LiveData<HorizontalParam> liveData8;
        LiveData<CursorResultParam> liveData9;
        LiveData<HistogramResultParam> liveData10;
        Intrinsics.checkNotNullParameter(context, "context");
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        this.sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        this.measureResultViewModel = (MeasureResultViewModel) ContextUtil.getAppViewModel(MeasureResultViewModel.class);
        this.measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        this.cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        this.horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        this.mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        this.refViewModel = (RefViewModel) ContextUtil.getAppViewModel(RefViewModel.class);
        this.histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class);
        this.set = new ConstraintSet();
        this.tagViews = new SimpleArrayMap<>();
        this.guidelines = new SimpleArrayMap<>();
        Indicator indicator = new Indicator(getContext(), null);
        indicator.setId(ConstraintLayout.generateViewId());
        indicator.setOrientation(1);
        indicator.setVisibility(8);
        indicator.setLinePathEffect(new PathEffect());
        Unit unit = Unit.INSTANCE;
        this.indicatorAx = indicator;
        Indicator indicator2 = new Indicator(getContext(), null);
        indicator2.setId(ConstraintLayout.generateViewId());
        indicator2.setOrientation(0);
        indicator2.setVisibility(8);
        indicator2.setLinePathEffect(new PathEffect());
        Unit unit2 = Unit.INSTANCE;
        this.indicatorAy = indicator2;
        Indicator indicator3 = new Indicator(getContext(), null);
        indicator3.setId(ConstraintLayout.generateViewId());
        indicator3.setOrientation(1);
        indicator3.setVisibility(8);
        indicator3.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit3 = Unit.INSTANCE;
        this.indicatorBx = indicator3;
        Indicator indicator4 = new Indicator(getContext(), null);
        indicator4.setId(ConstraintLayout.generateViewId());
        indicator4.setOrientation(0);
        indicator4.setVisibility(8);
        indicator4.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit4 = Unit.INSTANCE;
        this.indicatorBy = indicator4;
        final CursorTag cursorTag = new CursorTag(getContext(), null, 1);
        cursorTag.setId(R.id.cursor_ax);
        cursorTag.setText("AX");
        cursorTag.setCousor_label("1");
        cursorTag.setCousor_showLabel_now(true);
        cursorTag.setShowLabel(true);
        cursorTag.setVisibility(8);
        cursorTag.setLinePathEffect(new PathEffect());
        cursorTag.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$15
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i2, int i3, int i4, int i5) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveAx((long) (CursorTag.this.getValue() + ((i4 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getAx());
                    CursorTag.this.setOtherValue(cursorResultParam.getBx());
                }
                this.getCursorAxRange(CursorTag.this);
            }
        });
        Unit unit5 = Unit.INSTANCE;
        this.cursorAx = cursorTag;
        final CursorTag cursorTag2 = new CursorTag(getContext(), null, 0);
        cursorTag2.setId(R.id.cursor_ay);
        cursorTag2.setText("AY");
        cursorTag2.setCousor_label("1");
        cursorTag2.setCousor_showLabel_now(false);
        cursorTag2.setShowLabel(true);
        cursorTag2.setVisibility(8);
        cursorTag2.setLinePathEffect(new PathEffect());
        cursorTag2.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$16
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i2, int i3, int i4, int i5) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveAy((long) (CursorTag.this.getValue() - ((i5 / this.getHeight()) * (CursorTag.this.getStartY() - CursorTag.this.getEndY()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getAy());
                    CursorTag.this.setOtherValue(cursorResultParam.getBy());
                }
                this.getCursorAyRange(CursorTag.this);
            }
        });
        Unit unit6 = Unit.INSTANCE;
        this.cursorAy = cursorTag2;
        final CursorTag cursorTag3 = new CursorTag(getContext(), null, 1);
        cursorTag3.setId(R.id.cursor_bx);
        cursorTag3.setText("BX");
        cursorTag3.setCousor_label(ExifInterface.GPS_MEASUREMENT_2D);
        cursorTag3.setCousor_showLabel_now(true);
        cursorTag3.setVisibility(8);
        cursorTag3.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        cursorTag3.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$17
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i2, int i3, int i4, int i5) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveBx((long) (CursorTag.this.getValue() + ((i4 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX()))));
                    this.showABxyCursorShadow();
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getBx());
                    CursorTag.this.setOtherValue(cursorResultParam.getAx());
                }
                this.getCursorBxRange(CursorTag.this);
            }
        });
        Unit unit7 = Unit.INSTANCE;
        this.cursorBx = cursorTag3;
        final CursorTag cursorTag4 = new CursorTag(getContext(), null, 0);
        cursorTag4.setId(R.id.cursor_by);
        cursorTag4.setText("BY");
        cursorTag4.setCousor_showLabel_now(false);
        cursorTag4.setCousor_label(ExifInterface.GPS_MEASUREMENT_2D);
        cursorTag4.setShowLabel(true);
        cursorTag4.setVisibility(8);
        cursorTag4.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        cursorTag4.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$18
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i2, int i3, int i4, int i5) {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    cursorResultParam.saveBy((long) (CursorTag.this.getValue() - ((i5 / this.getHeight()) * (CursorTag.this.getStartY() - CursorTag.this.getEndY()))));
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                CursorResultParam cursorResultParam = this.getCursorResultParam();
                if (cursorResultParam != null) {
                    CursorTag.this.setValue(cursorResultParam.getBy());
                    CursorTag.this.setOtherValue(cursorResultParam.getAy());
                }
                this.getCursorByRange(CursorTag.this);
            }
        });
        Unit unit8 = Unit.INSTANCE;
        this.cursorBy = cursorTag4;
        CursorTag cursorTag5 = new CursorTag(getContext(), null, 1);
        cursorTag5.setId(R.id.cursor_ax);
        cursorTag5.setText("AX");
        cursorTag5.setVisibility(8);
        cursorTag5.setDraggable(false);
        cursorTag5.setShowHint(false);
        cursorTag5.setLinePathEffect(new PathEffect());
        Unit unit9 = Unit.INSTANCE;
        this.cursorAxShadow = cursorTag5;
        CursorTag cursorTag6 = new CursorTag(getContext(), null, 0);
        cursorTag6.setId(R.id.cursor_ay);
        cursorTag6.setText("AY");
        cursorTag6.setVisibility(8);
        cursorTag6.setDraggable(false);
        cursorTag6.setShowHint(false);
        cursorTag6.setLinePathEffect(new PathEffect());
        Unit unit10 = Unit.INSTANCE;
        this.cursorAyShadow = cursorTag6;
        CursorTag cursorTag7 = new CursorTag(getContext(), null, 1);
        cursorTag7.setId(R.id.cursor_bx);
        cursorTag7.setText("BX");
        cursorTag7.setVisibility(8);
        cursorTag7.setDraggable(false);
        cursorTag7.setShowHint(false);
        cursorTag7.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit11 = Unit.INSTANCE;
        this.cursorBxShadow = cursorTag7;
        CursorTag cursorTag8 = new CursorTag(getContext(), null, 0);
        cursorTag8.setId(R.id.cursor_by);
        cursorTag8.setText("BY");
        cursorTag8.setVisibility(8);
        cursorTag8.setDraggable(false);
        cursorTag8.setShowHint(false);
        cursorTag8.setLinePathEffect(TagView.DEFAULT_DASH_PATH_EFFECT);
        Unit unit12 = Unit.INSTANCE;
        this.cursorByShadow = cursorTag8;
        final HistogramRectView histogramRectView = new HistogramRectView(getContext());
        histogramRectView.setId(View.generateViewId());
        histogramRectView.setVisibility(4);
        histogramRectView.setCallback(new HistogramRectView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$19
            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onMove(int i2, int i3, int i4, int i5) {
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onStart() {
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onEnd(float f, float f2, float f3, float f4) {
                HistogramResultParam histogramParam = this.getHistogramParam();
                if (histogramParam != null) {
                    histogramParam.saveLeftPosition((int) ((f / HistogramRectView.this.getMeasuredWidth()) * 1000));
                }
                HistogramResultParam histogramParam2 = this.getHistogramParam();
                if (histogramParam2 != null) {
                    histogramParam2.saveRightPosition((int) ((f2 / HistogramRectView.this.getMeasuredWidth()) * 1000));
                }
                HistogramResultParam histogramParam3 = this.getHistogramParam();
                if (histogramParam3 != null) {
                    histogramParam3.saveTopPosition((int) ((f3 / HistogramRectView.this.getMeasuredHeight()) * 480));
                }
                HistogramResultParam histogramParam4 = this.getHistogramParam();
                if (histogramParam4 != null) {
                    histogramParam4.saveBottomPosition((int) ((f4 / HistogramRectView.this.getMeasuredHeight()) * 480));
                }
            }

            @Override // com.rigol.scope.views.histogram.HistogramRectView.Callback
            public void onClick() {
                Timber.d("Histo on long click", new Object[0]);
                BasePopupView basePopupView = PopupViewManager.getInstance().get(HistogramSettingPopupView.class);
                Intrinsics.checkNotNullExpressionValue(basePopupView, "PopupViewManager.getInst…ingPopupView::class.java]");
                if (basePopupView.isShowing()) {
                    return;
                }
                PopupViewManager.getInstance().toggle(HistogramSettingPopupView.class);
            }
        });
        Unit unit13 = Unit.INSTANCE;
        this.histogramRect = histogramRectView;
        setClipChildren(false);
        setClipToPadding(false);
        HistogramViewModel histogramViewModel = this.histogramViewModel;
        this.histogramParam = (histogramViewModel == null || (liveData10 = histogramViewModel.getLiveData()) == null) ? null : liveData10.getValue();
        CursorViewModel cursorViewModel = this.cursorViewModel;
        if (cursorViewModel != null && (liveData9 = cursorViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData9.observe((LifecycleOwner) topActivity, new Observer<CursorResultParam>() { // from class: com.rigol.scope.views.window.WindowContent.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(CursorResultParam cursorResultParam) {
                        Timber.d("Horizontal:UI:WindowContent:HorizontalParam:" + cursorResultParam, new Object[0]);
                        WindowContent.this.setCursorResultParam(cursorResultParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        HorizontalViewModel horizontalViewModel = this.horizontalViewModel;
        if (horizontalViewModel != null && (liveData8 = horizontalViewModel.getLiveData()) != null) {
            Activity topActivity2 = ActivityUtils.getTopActivity();
            if (topActivity2 != null) {
                liveData8.observe((LifecycleOwner) topActivity2, new Observer<HorizontalParam>() { // from class: com.rigol.scope.views.window.WindowContent.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HorizontalParam horizontalParam) {
                        WindowContent.this.setHorizontalParam(horizontalParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        if (verticalViewModel != null && (liveData7 = verticalViewModel.getLiveData()) != null) {
            Activity topActivity3 = ActivityUtils.getTopActivity();
            if (topActivity3 != null) {
                liveData7.observe((LifecycleOwner) topActivity3, new Observer<ArrayList<VerticalParam>>() { // from class: com.rigol.scope.views.window.WindowContent.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<VerticalParam> arrayList) {
                        WindowContent.this.setVerticalParams(arrayList);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MathViewModel mathViewModel = this.mathViewModel;
        if (mathViewModel != null && (liveData6 = mathViewModel.getLiveData()) != null) {
            Activity topActivity4 = ActivityUtils.getTopActivity();
            if (topActivity4 != null) {
                liveData6.observe((LifecycleOwner) topActivity4, new Observer<ArrayList<MathParam>>() { // from class: com.rigol.scope.views.window.WindowContent.4
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(ArrayList<MathParam> arrayList) {
                        WindowContent.this.setMathParams(arrayList);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureResultViewModel measureResultViewModel = this.measureResultViewModel;
        if (measureResultViewModel != null && (liveData5 = measureResultViewModel.getLiveData()) != null) {
            Activity topActivity5 = ActivityUtils.getTopActivity();
            if (topActivity5 != null) {
                liveData5.observe((LifecycleOwner) topActivity5, new Observer<List<? extends ResultParam>>() { // from class: com.rigol.scope.views.window.WindowContent.5
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(List<? extends ResultParam> list) {
                        WindowContent.this.setResultParams(list);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SharedViewModel sharedViewModel = this.sharedViewModel;
        if (sharedViewModel != null && (liveData4 = sharedViewModel.getLiveData()) != null) {
            Activity topActivity6 = ActivityUtils.getTopActivity();
            if (topActivity6 != null) {
                liveData4.observe((LifecycleOwner) topActivity6, new Observer<SharedParam>() { // from class: com.rigol.scope.views.window.WindowContent.6
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(SharedParam sharedParam) {
                        WindowContent.this.setSharedParam(sharedParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        MeasureSettingViewModel measureSettingViewModel = this.measureSettingViewModel;
        if (measureSettingViewModel != null && (liveData3 = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity7 = ActivityUtils.getTopActivity();
            if (topActivity7 != null) {
                liveData3.observe((LifecycleOwner) topActivity7, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.window.WindowContent.7
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        WindowContent.this.setMeasureSettingParam(measureSettingParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        RefViewModel refViewModel = this.refViewModel;
        if (refViewModel != null && (liveData2 = refViewModel.getLiveData()) != null) {
            Activity topActivity8 = ActivityUtils.getTopActivity();
            if (topActivity8 != null) {
                liveData2.observe((LifecycleOwner) topActivity8, new Observer<RefParam>() { // from class: com.rigol.scope.views.window.WindowContent.8
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(RefParam refParam) {
                        WindowContent.this.setRefParam(refParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null && (mutableLiveData = syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_INDICATOR)) != null) {
            Activity topActivity9 = ActivityUtils.getTopActivity();
            if (topActivity9 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity9, new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent.9
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WindowContent.this.hideABxyIndicator();
                }
            });
        }
        HistogramViewModel histogramViewModel2 = this.histogramViewModel;
        if (histogramViewModel2 != null && (liveData = histogramViewModel2.getLiveData()) != null) {
            Activity topActivity10 = ActivityUtils.getTopActivity();
            if (topActivity10 != null) {
                liveData.observe((LifecycleOwner) topActivity10, new Observer<HistogramResultParam>() { // from class: com.rigol.scope.views.window.WindowContent.10
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(HistogramResultParam histogramResultParam) {
                        Timber.d("Histogram:UI:WindowContent:HistogramGram:" + histogramResultParam, new Object[0]);
                        WindowContent.this.setHistogramParam(histogramResultParam);
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        final CursorTag cursorTag9 = new CursorTag(getContext(), null, 1);
        cursorTag9.setId(View.generateViewId());
        cursorTag9.setText("CA");
        cursorTag9.setVisibility(8);
        cursorTag9.setLineColor(Color.parseColor("#00FF00"));
        cursorTag9.setLabelColor(Color.parseColor("#00FF00"));
        cursorTag9.setTagColor(Color.parseColor("#00FF00"));
        cursorTag9.setLinePathEffect(new PathEffect());
        cursorTag9.setTagStyle(Paint.Style.FILL);
        cursorTag9.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$20
            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i2, int i3, int i4, int i5) {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    double width = (i4 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX());
                    if (measureSettingParam.getRegionSelect() == 2) {
                        long j = (long) width;
                        measureSettingParam.saveCursorA(((long) CursorTag.this.getValue()) + j);
                        measureSettingParam.saveCursorB(((long) CursorTag.this.getOtherValue()) + j);
                        return;
                    }
                    long j2 = (long) width;
                    double d = j2;
                    long value = (long) (CursorTag.this.getValue() + d);
                    Object m_MinValue = measureSettingParam.getCursorAAttr().getM_MinValue();
                    if (m_MinValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value < ((Long) m_MinValue).longValue()) {
                        Object m_MinValue2 = measureSettingParam.getCursorAAttr().getM_MinValue();
                        if (m_MinValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorA(((Long) m_MinValue2).longValue());
                        return;
                    }
                    long value2 = (long) (CursorTag.this.getValue() + d);
                    Object m_MaxValue = measureSettingParam.getCursorAAttr().getM_MaxValue();
                    if (m_MaxValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value2 > ((Long) m_MaxValue).longValue()) {
                        Object m_MaxValue2 = measureSettingParam.getCursorAAttr().getM_MaxValue();
                        if (m_MaxValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorA(((Long) m_MaxValue2).longValue());
                        return;
                    }
                    measureSettingParam.saveCursorA(((long) CursorTag.this.getValue()) + j2);
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    CursorTag.this.setValue(measureSettingParam.getCursorA());
                    CursorTag.this.setOtherValue(measureSettingParam.getCursorB());
                }
                this.getMeasureCursorARange(CursorTag.this);
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
                this.showMeasureCursor();
            }
        });
        Unit unit14 = Unit.INSTANCE;
        this.messureCusorA = cursorTag9;
        final CursorTag cursorTag10 = new CursorTag(getContext(), null, 1);
        cursorTag10.setId(View.generateViewId());
        cursorTag10.setText("CB");
        cursorTag10.setVisibility(8);
        cursorTag10.setLineColor(Color.parseColor("#00FF00"));
        cursorTag10.setLabelColor(Color.parseColor("#00FF00"));
        cursorTag10.setTagColor(Color.parseColor("#00FF00"));
        cursorTag10.setLinePathEffect(new PathEffect());
        cursorTag10.setTagStyle(Paint.Style.STROKE);
        cursorTag10.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$$special$$inlined$apply$lambda$21
            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i2, int i3, int i4, int i5) {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    double width = (i4 / this.getWidth()) * (CursorTag.this.getEndX() - CursorTag.this.getStartX());
                    if (measureSettingParam.getRegionSelect() == 2) {
                        long j = (long) width;
                        measureSettingParam.saveCursorB(((long) CursorTag.this.getValue()) + j);
                        measureSettingParam.saveCursorA(((long) CursorTag.this.getOtherValue()) + j);
                        return;
                    }
                    long j2 = (long) width;
                    double d = j2;
                    long value = (long) (CursorTag.this.getValue() + d);
                    Object m_MinValue = measureSettingParam.getCursorBAttr().getM_MinValue();
                    if (m_MinValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value < ((Long) m_MinValue).longValue()) {
                        Object m_MinValue2 = measureSettingParam.getCursorBAttr().getM_MinValue();
                        if (m_MinValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorB(((Long) m_MinValue2).longValue());
                        return;
                    }
                    long value2 = (long) (CursorTag.this.getValue() + d);
                    Object m_MaxValue = measureSettingParam.getCursorBAttr().getM_MaxValue();
                    if (m_MaxValue == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                    }
                    if (value2 > ((Long) m_MaxValue).longValue()) {
                        Object m_MaxValue2 = measureSettingParam.getCursorBAttr().getM_MaxValue();
                        if (m_MaxValue2 == null) {
                            throw new NullPointerException("null cannot be cast to non-null type kotlin.Long");
                        }
                        measureSettingParam.saveCursorB(((Long) m_MaxValue2).longValue());
                        return;
                    }
                    measureSettingParam.saveCursorB(((long) CursorTag.this.getValue()) + j2);
                }
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
                MeasureSettingParam measureSettingParam = this.getMeasureSettingParam();
                if (measureSettingParam != null) {
                    CursorTag.this.setValue(measureSettingParam.getCursorB());
                    CursorTag.this.setOtherValue(measureSettingParam.getCursorA());
                }
                this.getMeasureCursorBRange(CursorTag.this);
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
                this.showMeasureCursor();
            }
        });
        Unit unit15 = Unit.INSTANCE;
        this.messureCusorB = cursorTag10;
        ViewDragHelper create = ViewDragHelper.create(this, new DragCallback2());
        Intrinsics.checkNotNullExpressionValue(create, "ViewDragHelper.create(th…Content, DragCallback2())");
        this.dragHelper = create;
        this.indicatorObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$indicatorObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                if (WindowContent.this.getSharedParam() == null || WindowContent.this.getResultParams() == null) {
                    return;
                }
                WindowContent.this.hideABxyIndicator();
                SharedParam sharedParam = WindowContent.this.getSharedParam();
                Intrinsics.checkNotNull(sharedParam);
                if (sharedParam.getCurrentResultItem() >= 0) {
                    SharedParam sharedParam2 = WindowContent.this.getSharedParam();
                    Intrinsics.checkNotNull(sharedParam2);
                    int currentResultItem = sharedParam2.getCurrentResultItem();
                    List<ResultParam> resultParams = WindowContent.this.getResultParams();
                    Intrinsics.checkNotNull(resultParams);
                    if (currentResultItem >= resultParams.size()) {
                        return;
                    }
                    List<ResultParam> resultParams2 = WindowContent.this.getResultParams();
                    Intrinsics.checkNotNull(resultParams2);
                    SharedParam sharedParam3 = WindowContent.this.getSharedParam();
                    Intrinsics.checkNotNull(sharedParam3);
                    ResultParam resultParam = resultParams2.get(sharedParam3.getCurrentResultItem());
                    if (resultParam == null || resultParam.getMeasType() == null || WindowContent.this.getMeasureSettingParam() == null) {
                        return;
                    }
                    MeasureSettingParam measureSettingParam = WindowContent.this.getMeasureSettingParam();
                    if (measureSettingParam == null || measureSettingParam.getCursorIndicator()) {
                        String[][] strArr = null;
                        try {
                            strArr = (String[][]) GsonUtils.fromJson(API.getInstance().UI_QueryStr(28, MessageID.MSG_MEAS_ITEM_ABXY), (Type) String[][].class);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (strArr == null) {
                            return;
                        }
                        String[][] strArr2 = strArr;
                        if ((strArr2.length == 0) || strArr2.length == 0 || strArr[0] == null) {
                            return;
                        }
                        String[] strArr3 = strArr[0];
                        Intrinsics.checkNotNull(strArr3);
                        if (strArr3.length == 0) {
                            return;
                        }
                        String[] strArr4 = strArr[0];
                        Intrinsics.checkNotNull(strArr4);
                        if (strArr4.length < 11) {
                            return;
                        }
                        ServiceEnum.MeasType measType = resultParam.getMeasType();
                        Intrinsics.checkNotNull(measType);
                        if (measType.value1 > ServiceEnum.MeasType.Meas_VER_TYPE_END.value1) {
                            if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                                if (resultParam.getSourceA().value1 >= ServiceEnum.Chan.chan1.value1 && resultParam.getSourceA().value1 <= ServiceEnum.Chan.chan4.value1) {
                                    WindowContent.this.showAxyIndicator(resultParam, strArr);
                                }
                                if (resultParam.getSourceB().value1 < ServiceEnum.Chan.chan1.value1 || resultParam.getSourceB().value1 > ServiceEnum.Chan.chan4.value1) {
                                    return;
                                }
                                WindowContent.this.showBxyIndicator(resultParam, strArr);
                            } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH) {
                                if (resultParam.getSourceA().value1 >= ServiceEnum.Chan.m1.value1 && resultParam.getSourceA().value1 <= ServiceEnum.Chan.m4.value1 && resultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                                    WindowContent.this.showAxyIndicator(resultParam, strArr);
                                }
                                if (resultParam.getSourceB().value1 < ServiceEnum.Chan.m1.value1 || resultParam.getSourceB().value1 > ServiceEnum.Chan.m4.value1 || resultParam.getSourceB().value1 - ServiceEnum.Chan.m1.value1 != WindowContent.this.getWindowParam().getServiceID() - 17) {
                                    return;
                                }
                                WindowContent.this.showBxyIndicator(resultParam, strArr);
                            }
                        } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                            if (resultParam.getSourceA().value1 < ServiceEnum.Chan.chan1.value1 || resultParam.getSourceA().value1 > ServiceEnum.Chan.chan4.value1) {
                                return;
                            }
                            WindowContent.this.showABxyIndicator(resultParam, strArr);
                        } else if (WindowContent.this.getWindowParam().getType() != ServiceEnum.WindowType.WIN_MATH || resultParam.getSourceA().value1 < ServiceEnum.Chan.m1.value1 || resultParam.getSourceA().value1 > ServiceEnum.Chan.m4.value1 || resultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 != WindowContent.this.getWindowParam().getServiceID() - 17) {
                        } else {
                            WindowContent.this.showABxyIndicator(resultParam, strArr);
                        }
                    }
                }
            }
        };
        this.cursorObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$cursorObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                CursorResultParam cursorResultParam;
                WindowContent.this.hideABxyCursor();
                if (WindowContent.this.getCursorResultParam() == null || (cursorResultParam = WindowContent.this.getCursorResultParam()) == null) {
                    return;
                }
                int i2 = WindowContent.WhenMappings.$EnumSwitchMapping$0[cursorResultParam.getCursorMode().ordinal()];
                if (i2 == 1) {
                    if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                        if (cursorResultParam.getSourceA().value1 < ServiceEnum.Chan.chan1.value1 || cursorResultParam.getSourceA().value1 > ServiceEnum.Chan.chan4.value1) {
                            return;
                        }
                        WindowContent.this.showABxyCursor();
                    } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH && cursorResultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                        WindowContent.this.showABxyCursor();
                    }
                } else if (i2 == 2) {
                    if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MAIN_WAVEFORM || WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_ZOOM_WAVEFORM) {
                        if (cursorResultParam.getSourceA().value1 >= ServiceEnum.Chan.chan1.value1 && cursorResultParam.getSourceA().value1 <= ServiceEnum.Chan.chan4.value1) {
                            WindowContent.this.showAxyCursor();
                        }
                        if (cursorResultParam.getSourceB().value1 < ServiceEnum.Chan.chan1.value1 || cursorResultParam.getSourceB().value1 > ServiceEnum.Chan.chan4.value1) {
                            return;
                        }
                        WindowContent.this.showBxyCursor();
                    } else if (WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH) {
                        if (cursorResultParam.getSourceA().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                            WindowContent.this.showAxyCursor();
                        }
                        if (cursorResultParam.getSourceB().value1 - ServiceEnum.Chan.m1.value1 == WindowContent.this.getWindowParam().getServiceID() - 17) {
                            WindowContent.this.showBxyCursor();
                        }
                    }
                } else if (i2 == 3 && WindowContent.this.getWindowParam().getType() == ServiceEnum.WindowType.WIN_XY) {
                    WindowContent.this.showABxyCursor();
                }
            }
        };
        this.refObserver = new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$refObserver$1
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                RefParam refParam;
                if (!(obj instanceof Integer) || (refParam = WindowContent.this.getRefParam()) == null) {
                    return;
                }
                Number number = (Number) obj;
                RefParam.Param param = refParam.getParam(number.intValue());
                if (param == null || param.getSaveChan() == null) {
                    return;
                }
                if (param.getSaveChan().value1 >= ServiceEnum.Chan.chan1.value1 && param.getSaveChan().value1 <= ServiceEnum.Chan.d15.value1) {
                    WindowContent windowContent = WindowContent.this;
                    if ((windowContent instanceof MainWaveformView) || (windowContent instanceof ZoomWaveformView)) {
                        r3 = true;
                    }
                    WindowContent.this.updateRefTag(r3, param, number.intValue());
                } else if (param.getSaveChan().value1 < ServiceEnum.Chan.m1.value1 || param.getSaveChan().value1 > ServiceEnum.Chan.m4.value1) {
                } else {
                    if (param.getSaveChan().value1 == ServiceEnum.Chan.m1.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 17, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m2.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 18, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m3.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 19, param, number.intValue());
                    } else if (param.getSaveChan().value1 == ServiceEnum.Chan.m4.value1) {
                        WindowContent.this.updateRefTag(WindowContent.this.getWindowParam().getServiceID() == 20, param, number.intValue());
                    }
                }
            }
        };
    }

    public final SyncDataViewModel getSyncDataViewModel() {
        return this.syncDataViewModel;
    }

    public final UpdateUIViewModel getUpdateUIViewModel() {
        return this.updateUIViewModel;
    }

    public final SharedViewModel getSharedViewModel() {
        return this.sharedViewModel;
    }

    public final MeasureResultViewModel getMeasureResultViewModel() {
        return this.measureResultViewModel;
    }

    public final MeasureSettingViewModel getMeasureSettingViewModel() {
        return this.measureSettingViewModel;
    }

    public final CursorViewModel getCursorViewModel() {
        return this.cursorViewModel;
    }

    public final HorizontalViewModel getHorizontalViewModel() {
        return this.horizontalViewModel;
    }

    public final VerticalViewModel getVerticalViewModel() {
        return this.verticalViewModel;
    }

    public final MathViewModel getMathViewModel() {
        return this.mathViewModel;
    }

    public final RefViewModel getRefViewModel() {
        return this.refViewModel;
    }

    public final HistogramViewModel getHistogramViewModel() {
        return this.histogramViewModel;
    }

    public final CursorResultParam getCursorResultParam() {
        return this.cursorResultParam;
    }

    public final void setCursorResultParam(CursorResultParam cursorResultParam) {
        this.cursorResultParam = cursorResultParam;
    }

    public final HorizontalParam getHorizontalParam() {
        return this.horizontalParam;
    }

    public final void setHorizontalParam(HorizontalParam horizontalParam) {
        this.horizontalParam = horizontalParam;
    }

    public final List<VerticalParam> getVerticalParams() {
        return this.verticalParams;
    }

    public final void setVerticalParams(List<VerticalParam> list) {
        this.verticalParams = list;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.rigol.scope.data.MathParam>, java.util.List<com.rigol.scope.data.MathParam> */
    public final List<MathParam> getMathParams() {
        return this.mathParams;
    }

    public final void setMathParams(List<? extends MathParam> list) {
        this.mathParams = list;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.util.List<? extends com.rigol.scope.data.ResultParam>, java.util.List<com.rigol.scope.data.ResultParam> */
    public final List<ResultParam> getResultParams() {
        return this.resultParams;
    }

    public final void setResultParams(List<? extends ResultParam> list) {
        this.resultParams = list;
    }

    public final SharedParam getSharedParam() {
        return this.sharedParam;
    }

    public final void setSharedParam(SharedParam sharedParam) {
        this.sharedParam = sharedParam;
    }

    public final MeasureSettingParam getMeasureSettingParam() {
        return this.measureSettingParam;
    }

    public final void setMeasureSettingParam(MeasureSettingParam measureSettingParam) {
        this.measureSettingParam = measureSettingParam;
    }

    public final RefParam getRefParam() {
        return this.refParam;
    }

    public final void setRefParam(RefParam refParam) {
        this.refParam = refParam;
    }

    public final HistogramResultParam getHistogramParam() {
        return this.histogramParam;
    }

    public final void setHistogramParam(HistogramResultParam histogramResultParam) {
        this.histogramParam = histogramResultParam;
    }

    public final ConstraintSet getSet() {
        return this.set;
    }

    protected final SimpleArrayMap<String, Object> getTagViews() {
        return this.tagViews;
    }

    protected final SimpleArrayMap<String, Object> getGuidelines() {
        return this.guidelines;
    }

    public final Guideline newGuideLine(float f, int i) {
        Guideline guideline = new Guideline(getContext(), null);
        guideline.setId(ConstraintLayout.generateViewId());
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(-1, -1);
        layoutParams.orientation = i;
        guideline.setLayoutParams(layoutParams);
        guideline.setGuidelinePercent(f);
        return guideline;
    }

    public final void addGuideLine(Guideline guideline) {
        Intrinsics.checkNotNullParameter(guideline, "guideline");
        addView(guideline);
    }

    public final Guideline getGuideLine(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.guidelines.containsKey(key)) {
            Object obj = this.guidelines.get(key);
            if (obj instanceof Guideline) {
                return (Guideline) obj;
            }
            return null;
        }
        return null;
    }

    public final Guideline getGuideLine(String key, int i) {
        Intrinsics.checkNotNullParameter(key, "key");
        if (this.guidelines.containsKey(key)) {
            Object obj = this.guidelines.get(key);
            if (!(obj instanceof List) || i < 0) {
                return null;
            }
            List list = (List) obj;
            if (i < list.size()) {
                Object obj2 = list.get(i);
                if (obj2 instanceof Guideline) {
                    return (Guideline) obj2;
                }
                return null;
            }
            return null;
        }
        return null;
    }

    public final <T> Object getTagView(String key, Class<T> clazz) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this.tagViews.containsKey(key) && (obj = this.tagViews.get(key)) != null && Intrinsics.areEqual(obj.getClass(), clazz)) {
            return obj;
        }
        return null;
    }

    public final <T> Object getTagView(String key, int i, Class<T> clazz) {
        Object obj;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        if (this.tagViews.containsKey(key)) {
            Object obj2 = this.tagViews.get(key);
            if (!(obj2 instanceof List) || i < 0) {
                return null;
            }
            List list = (List) obj2;
            if (i >= list.size() || (obj = list.get(i)) == null || !Intrinsics.areEqual(obj.getClass(), clazz)) {
                return null;
            }
            return obj;
        }
        return null;
    }

    public final void bindToGuideLine(View view, Guideline guideline) {
        if (view == null || guideline == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = guideline.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            if (((ConstraintLayout.LayoutParams) layoutParams).orientation == 0) {
                WindowContent windowContent = this;
                this.set.clone(windowContent);
                this.set.connect(view.getId(), 3, guideline.getId(), 3);
                this.set.connect(view.getId(), 4, guideline.getId(), 4);
                this.set.applyTo(windowContent);
                return;
            }
            WindowContent windowContent2 = this;
            this.set.clone(windowContent2);
            this.set.connect(view.getId(), 6, guideline.getId(), 6);
            this.set.connect(view.getId(), 7, guideline.getId(), 7);
            this.set.applyTo(windowContent2);
        }
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [('R' char), (wrap: int : 0x0031: ARITH  (r5v1 int A[REMOVE]) = (r7v0 int) + (1 int))] */
    private final void addRefTag(final int i) {
        final RefParam refParam = this.refParam;
        if (refParam != null) {
            final RefParam.Param param = refParam.getParam(i);
            TagView tagView = new TagView(getContext(), null);
            tagView.setId(View.generateViewId());
            tagView.setTagHeight(20);
            tagView.setTagWidth(35);
            tagView.setShowBorder(true);
            StringBuilder sb = new StringBuilder();
            sb.append('R');
            sb.append(i + 1);
            tagView.setText(sb.toString());
            tagView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            Intrinsics.checkNotNullExpressionValue(param, "param");
            tagView.setLabel(param.getLabel());
            tagView.setTextSize(i == 9 ? 12 : 16);
            int i2 = Colors.INSTANCE.getREF_COLORS().get(param.getRefColor().value1);
            tagView.setLabelColor(i2);
            tagView.setTagColor(i2);
            tagView.setShowLine(false);
            TagView tagView2 = tagView;
            addView(tagView2, 35, 35);
            ViewUtil.applyToTopAndLeft(this.set, this, tagView2);
            updateRefPosition(param, tagView);
            tagView.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.window.WindowContent$addRefTag$1$1$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PopupViewManager.getInstance().toggle(RefPopupView.class);
                }
            });
            tagView.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.window.WindowContent$addRefTag$$inlined$let$lambda$1
                @Override // com.rigol.scope.views.TagView.Callback
                public void onEnd() {
                }

                @Override // com.rigol.scope.views.TagView.Callback
                public void onMove(int i3, int i4, int i5, int i6) {
                    if (this.getHeight() != 0) {
                        refParam.saveRefChan(i);
                        float f = i4;
                        RefParam.Param param2 = RefParam.Param.this;
                        Intrinsics.checkNotNullExpressionValue(param2, "param");
                        float verScale = ((f * ((float) param2.getVerScale())) * 10) / this.getHeight();
                        RefParam.Param param3 = RefParam.Param.this;
                        Intrinsics.checkNotNullExpressionValue(param3, "param");
                        param3.saveVerOffset(((float) param3.getVerOffset()) - verScale);
                    }
                }

                @Override // com.rigol.scope.views.TagView.Callback
                public void onStart() {
                    FlexKnobParamViewModel flexKnobParamViewModel = ViewUtil.getFlexKnobParamViewModel();
                    Intrinsics.checkNotNullExpressionValue(flexKnobParamViewModel, "ViewUtil.getFlexKnobParamViewModel()");
                    if (flexKnobParamViewModel.isFlexAutoDirection()) {
                        FunctionManager.getInstance().setFlexKnobEnum(ServiceEnum.Function.FUN_REF, i, false);
                    }
                }
            });
            SimpleArrayMap<String, Object> simpleArrayMap = this.tagViews;
            simpleArrayMap.put("22_" + i, tagView);
        }
    }

    public final void updateCursorA_B() {
        MeasureSettingParam measureSettingParam = this.measureSettingParam;
        if (measureSettingParam != null) {
            if (measureSettingParam != null) {
                long cursorA = measureSettingParam.getCursorA();
                MeasureSettingParam measureSettingParam2 = this.measureSettingParam;
                if (measureSettingParam2 != null) {
                    measureSettingParam2.saveCursorA(cursorA);
                }
            }
            MeasureSettingParam measureSettingParam3 = this.measureSettingParam;
            if (measureSettingParam3 != null) {
                long cursorB = measureSettingParam3.getCursorB();
                MeasureSettingParam measureSettingParam4 = this.measureSettingParam;
                if (measureSettingParam4 != null) {
                    measureSettingParam4.saveCursorB(cursorB);
                }
            }
        }
    }

    private final void updateRefColor(RefParam.Param param, TagView tagView) {
        ServiceEnum.RefColor refColor = param.getRefColor();
        if (refColor == null || refColor.value1 < 0 || refColor.value1 >= Colors.INSTANCE.getREF_COLORS().size()) {
            return;
        }
        int i = Colors.INSTANCE.getREF_COLORS().get(refColor.value1);
        tagView.setLabelColor(i);
        tagView.setTagColor(i);
    }

    private final void updateRefLabel(boolean z, String str, TagView tagView) {
        tagView.setShowLabel(z);
        tagView.setLabel(str);
    }

    private final void updateRefPosition(RefParam.Param param, TagView tagView) {
        if (param.getSaveChan() != null) {
            tagView.setPosition((int) (ViewUtil.getValuePercent(param, 0L) * getHeight()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TagView getRefTag(int i) {
        Object tagView = getTagView("22_" + i, TagView.class);
        if (tagView instanceof TagView) {
            return (TagView) tagView;
        }
        return null;
    }

    private final void removeRefTag(int i) {
        TagView refTag = getRefTag(i);
        if (refTag != null) {
            removeView(refTag);
            SimpleArrayMap<String, Object> simpleArrayMap = this.tagViews;
            simpleArrayMap.remove("22_" + i);
        }
    }

    /* compiled from: WindowContent.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J0\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J \u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0004H\u0016¨\u0006\u0019"}, d2 = {"Lcom/rigol/scope/views/window/WindowContent$DragCallback2;", "Landroidx/customview/widget/ViewDragHelper$Callback;", "(Lcom/rigol/scope/views/window/WindowContent;)V", "clampViewPositionHorizontal", "", "child", "Landroid/view/View;", "left", "dx", "clampViewPositionVertical", "top", "dy", "getViewHorizontalDragRange", "getViewVerticalDragRange", "onViewPositionChanged", "", "changedView", "onViewReleased", "releasedChild", "xvel", "", "yvel", "tryCaptureView", "", "pointerId", "app_release"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes2.dex */
    public final class DragCallback2 extends ViewDragHelper.Callback {
        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View child, int i, int i2) {
            Intrinsics.checkNotNullParameter(child, "child");
            return i;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View child, int i, int i2) {
            Intrinsics.checkNotNullParameter(child, "child");
            return i;
        }

        /* JADX DEBUG: Incorrect args count in method signature: ()V */
        public DragCallback2() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View child, int i) {
            Intrinsics.checkNotNullParameter(child, "child");
            WindowContent.this.captureStart = child.getLeft();
            WindowContent.this.captureTop = child.getTop();
            return (child instanceof LineView) || (child instanceof LabelView);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            return WindowContent.this.getMeasuredHeight() - child.getMeasuredHeight();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            return WindowContent.this.getMeasuredWidth() - child.getMeasuredWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View changedView, int i, int i2, int i3, int i4) {
            Intrinsics.checkNotNullParameter(changedView, "changedView");
            super.onViewPositionChanged(changedView, i, i2, i3, i4);
            if (changedView instanceof LabelView) {
                LabelView labelView = (LabelView) changedView;
                ViewGroup.LayoutParams layoutParams = labelView.getLayoutParams();
                if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                    ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
                    layoutParams2.startMargin += i - WindowContent.this.captureStart;
                    layoutParams2.topMargin += i2 - WindowContent.this.captureTop;
                    labelView.setLayoutParams(layoutParams);
                    WindowContent.this.captureStart = i;
                    WindowContent.this.captureTop = i2;
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View releasedChild, float f, float f2) {
            Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
            super.onViewReleased(releasedChild, f, f2);
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Intrinsics.checkNotNullParameter(ev, "ev");
        if (ev.getActionMasked() == 0) {
            this.returnSuperOnTouch = false;
        }
        View findClosestChildUnder = DragViewUtil.findClosestChildUnder(this, (int) ev.getX(), (int) ev.getY());
        if ((findClosestChildUnder instanceof LineView) || (findClosestChildUnder instanceof LabelView)) {
            return true;
        }
        return this.dragHelper.shouldInterceptTouchEvent(ev);
    }

    public final boolean getReturnSuperOnTouch() {
        return this.returnSuperOnTouch;
    }

    public final void setReturnSuperOnTouch(boolean z) {
        this.returnSuperOnTouch = z;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        this.dragHelper.processTouchEvent(event);
        if (event.getActionMasked() == 0) {
            View findClosestChildUnder = DragViewUtil.findClosestChildUnder(this, (int) event.getX(), (int) event.getY());
            if (!(findClosestChildUnder instanceof LineView) && !(findClosestChildUnder instanceof LabelView)) {
                this.returnSuperOnTouch = true;
            }
        }
        if (this.returnSuperOnTouch) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    public final void connect(ConstraintSet set, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(set, "set");
        set.connect(i, i2, i3, i4);
    }

    public final void applyConnect(ConstraintLayout layout, ConstraintSet set, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(set, "set");
        set.clone(layout);
        set.connect(i, i2, i3, i4);
        set.applyTo(layout);
    }

    public final void clear(ConstraintSet set, int i) {
        Intrinsics.checkNotNullParameter(set, "set");
        set.clear(i);
    }

    public final void applyClear(ConstraintLayout layout, ConstraintSet set, int i) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(set, "set");
        set.clone(layout);
        set.clear(i);
        set.applyTo(layout);
    }

    public final LineView addLine(int i, int i2) {
        LineView lineView = new LineView(getContext(), null);
        lineView.setId(i);
        lineView.setOrientation(i2);
        if (i2 == 1) {
            addView(lineView, -2, -1);
        } else {
            addView(lineView, -1, -2);
        }
        WindowContent windowContent = this;
        this.set.clone(windowContent);
        connect(this.set, i, 3, 0, 3);
        connect(this.set, i, 6, 0, 6);
        this.set.applyTo(windowContent);
        return lineView;
    }

    public final void removeLine(int i) {
        View findViewById = findViewById(i);
        if (findViewById != null) {
            removeView(findViewById);
        }
    }

    public final void addIndicators() {
        addIndicator(this.indicatorAx, this.set, 1, -1);
        addIndicator(this.indicatorBx, this.set, 1, -1);
        addIndicator(this.indicatorAy, this.set, -1, 1);
        addIndicator(this.indicatorBy, this.set, -1, 1);
    }

    private final void addIndicator(LineView lineView, ConstraintSet constraintSet, int i, int i2) {
        addView(lineView, i, i2);
        WindowContent windowContent = this;
        constraintSet.clone(windowContent);
        constraintSet.connect(lineView.getId(), 3, 0, 3);
        constraintSet.connect(lineView.getId(), 6, 0, 6);
        constraintSet.applyTo(windowContent);
    }

    public final void addHistogramRect() {
        addView(this.histogramRect, -1, -1);
        WindowContent windowContent = this;
        this.set.clone(windowContent);
        this.set.connect(this.histogramRect.getId(), 3, 0, 3);
        this.set.connect(this.histogramRect.getId(), 6, 0, 6);
        this.set.connect(this.histogramRect.getId(), 4, 0, 4);
        this.set.connect(this.histogramRect.getId(), 7, 0, 7);
        this.set.applyTo(windowContent);
        HistogramRectView histogramRectView = this.histogramRect;
        HistogramResultParam histogramResultParam = this.histogramParam;
        Integer valueOf = histogramResultParam != null ? Integer.valueOf(histogramResultParam.getLeft()) : null;
        HistogramResultParam histogramResultParam2 = this.histogramParam;
        Integer valueOf2 = histogramResultParam2 != null ? Integer.valueOf(histogramResultParam2.getRight()) : null;
        HistogramResultParam histogramResultParam3 = this.histogramParam;
        Integer valueOf3 = histogramResultParam3 != null ? Integer.valueOf(histogramResultParam3.getTop()) : null;
        HistogramResultParam histogramResultParam4 = this.histogramParam;
        histogramRectView.setRectPosition(valueOf, valueOf2, valueOf3, histogramResultParam4 != null ? Integer.valueOf(histogramResultParam4.getBottom()) : null);
    }

    public final void bindHistogram() {
        HistogramResultParam histogramResultParam = this.histogramParam;
        if (histogramResultParam != null) {
            histogramResultParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.WindowContent$bindHistogram$1
                @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                public void onPropertyChanged(Observable observable, int i) {
                    HistogramRectView histogramRectView;
                    HistogramRectView histogramRectView2;
                    if (i == 940 || i == 121 || i == 482 || i == 740) {
                        histogramRectView = WindowContent.this.histogramRect;
                        HistogramResultParam histogramParam = WindowContent.this.getHistogramParam();
                        Integer valueOf = histogramParam != null ? Integer.valueOf(histogramParam.getLeft()) : null;
                        HistogramResultParam histogramParam2 = WindowContent.this.getHistogramParam();
                        Integer valueOf2 = histogramParam2 != null ? Integer.valueOf(histogramParam2.getRight()) : null;
                        HistogramResultParam histogramParam3 = WindowContent.this.getHistogramParam();
                        Integer valueOf3 = histogramParam3 != null ? Integer.valueOf(histogramParam3.getTop()) : null;
                        HistogramResultParam histogramParam4 = WindowContent.this.getHistogramParam();
                        histogramRectView.setRectPosition(valueOf, valueOf2, valueOf3, histogramParam4 != null ? Integer.valueOf(histogramParam4.getBottom()) : null);
                    }
                    if (i == 271) {
                        histogramRectView2 = WindowContent.this.histogramRect;
                        HistogramResultParam histogramParam5 = WindowContent.this.getHistogramParam();
                        histogramRectView2.setVisibility((histogramParam5 == null || !histogramParam5.getEnable()) ? 4 : 0);
                    }
                }
            });
        }
    }

    public final void addCursorTags() {
        addCursorTag(this.cursorAx, this.set, 50, -1);
        addCursorTag(this.cursorBx, this.set, 50, -1);
        addCursorTag(this.cursorAy, this.set, -1, 50);
        addCursorTag(this.cursorBy, this.set, -1, 50);
        addCursorTag(this.messureCusorA, this.set, 50, -1);
        addCursorTag(this.messureCusorB, this.set, 50, -1);
    }

    public final void setCursorTags() {
        this.cursorAy.setShowBor(true);
        this.cursorBy.setShowBor(true);
        this.cursorAy.invalidate();
        this.cursorBy.invalidate();
    }

    public final void resetCursorTags() {
        this.cursorAy.setShowBor(false);
        this.cursorBy.setShowBor(false);
        this.cursorAy.invalidate();
        this.cursorBy.invalidate();
    }

    public final void addCursorShadowTags() {
        addCursorTag(this.cursorAxShadow, this.set, 50, -1);
        addCursorTag(this.cursorBxShadow, this.set, 50, -1);
        addCursorTag(this.cursorAyShadow, this.set, -1, 50);
        addCursorTag(this.cursorByShadow, this.set, -1, 50);
    }

    private final void addCursorTag(CursorTag cursorTag, ConstraintSet constraintSet, int i, int i2) {
        addView(cursorTag, i, i2);
        WindowContent windowContent = this;
        constraintSet.clone(windowContent);
        constraintSet.connect(cursorTag.getId(), 3, 0, 3);
        constraintSet.connect(cursorTag.getId(), 6, 0, 6);
        constraintSet.applyTo(windowContent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAxyIndicator(ResultParam resultParam, String[][] strArr) {
        ViewUtil.setVisibility(this.indicatorAx, 0);
        ViewUtil.setVisibility(this.indicatorAy, 0);
        getIndicatorAxRange(this.indicatorAx, resultParam);
        getIndicatorAyRange(this.indicatorAy, resultParam);
        updateIndicatorAxPosition(this.indicatorAx, strArr);
        updateIndicatorAyPosition(this.indicatorAy, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBxyIndicator(ResultParam resultParam, String[][] strArr) {
        ViewUtil.setVisibility(this.indicatorBx, 0);
        ViewUtil.setVisibility(this.indicatorBy, 0);
        getIndicatorBxRange(this.indicatorBx, resultParam);
        getIndicatorByRange(this.indicatorBy, resultParam);
        updateIndicatorBxPosition(this.indicatorBx, strArr);
        updateIndicatorByPosition(this.indicatorBy, strArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showABxyIndicator(ResultParam resultParam, String[][] strArr) {
        ViewUtil.setVisibility(this.indicatorAx, 0);
        ViewUtil.setVisibility(this.indicatorAy, 0);
        ViewUtil.setVisibility(this.indicatorBx, 0);
        ViewUtil.setVisibility(this.indicatorBy, 0);
        getIndicatorAxRange(this.indicatorAx, resultParam);
        getIndicatorAyRange(this.indicatorAy, resultParam);
        getIndicatorBxRange(this.indicatorBx, resultParam);
        getIndicatorByRange(this.indicatorBy, resultParam);
        updateIndicatorAxPosition(this.indicatorAx, strArr);
        updateIndicatorAyPosition(this.indicatorAy, strArr);
        updateIndicatorBxPosition(this.indicatorBx, strArr);
        updateIndicatorByPosition(this.indicatorBy, strArr);
    }

    public void hideABxyIndicator() {
        ViewUtil.setVisibility(this.indicatorAx, 8);
        ViewUtil.setVisibility(this.indicatorAy, 8);
        ViewUtil.setVisibility(this.indicatorBx, 8);
        ViewUtil.setVisibility(this.indicatorBy, 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showAxyCursor() {
        this.cursorAx.setShowHint(true);
        this.cursorAy.setShowHint(true);
        ViewUtil.setVisibility(this.cursorAx, 0);
        ViewUtil.setVisibility(this.cursorAy, 0);
        getCursorAxRange(this.cursorAx);
        getCursorAyRange(this.cursorAy);
        updateCursorAxPosition(this.cursorAx);
        updateCursorAyPosition(this.cursorAy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showBxyCursor() {
        this.cursorBx.setShowHint(true);
        this.cursorBy.setShowHint(true);
        ViewUtil.setVisibility(this.cursorBx, 0);
        ViewUtil.setVisibility(this.cursorBy, 0);
        getCursorBxRange(this.cursorBx);
        getCursorByRange(this.cursorBy);
        updateCursorBxPosition(this.cursorBx);
        updateCursorByPosition(this.cursorBy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showABxyCursor() {
        this.cursorAx.setShowHint(true);
        this.cursorAy.setShowHint(true);
        this.cursorBx.setShowHint(true);
        this.cursorBy.setShowHint(true);
        getCursorAxRange(this.cursorAx);
        getCursorAyRange(this.cursorAy);
        getCursorBxRange(this.cursorBx);
        getCursorByRange(this.cursorBy);
        updateCursorAxPosition(this.cursorAx);
        updateCursorAyPosition(this.cursorAy);
        updateCursorBxPosition(this.cursorBx);
        updateCursorByPosition(this.cursorBy);
        if (this.cursorAx.getVisibility() != 0) {
            ViewUtil.setVisibility(this.cursorAx, 0);
        }
        if (this.cursorAy.getVisibility() != 0) {
            ViewUtil.setVisibility(this.cursorAy, 0);
        }
        if (this.cursorBx.getVisibility() != 0) {
            ViewUtil.setVisibility(this.cursorBx, 0);
        }
        if (this.cursorBy.getVisibility() != 0) {
            ViewUtil.setVisibility(this.cursorBy, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hideABxyCursor() {
        this.cursorAx.setShowHint(false);
        this.cursorAy.setShowHint(false);
        this.cursorBx.setShowHint(false);
        this.cursorBy.setShowHint(false);
        if (this.cursorAx.getVisibility() != 8) {
            ViewUtil.setVisibility(this.cursorAx, 8);
        }
        if (this.cursorAy.getVisibility() != 8) {
            ViewUtil.setVisibility(this.cursorAy, 8);
        }
        if (this.cursorBx.getVisibility() != 8) {
            ViewUtil.setVisibility(this.cursorBx, 8);
        }
        if (this.cursorBy.getVisibility() != 8) {
            ViewUtil.setVisibility(this.cursorBy, 8);
        }
    }

    private final void showAxyCursorShadow() {
        ViewUtil.setVisibility(this.cursorAxShadow, 0);
        ViewUtil.setVisibility(this.cursorAyShadow, 0);
        getCursorAxShadowRange(this.cursorAxShadow);
        getCursorAyShadowRange(this.cursorAyShadow);
        updateCursorAxShadowPosition(this.cursorAxShadow);
        updateCursorAyShadowPosition(this.cursorAyShadow);
    }

    private final void showBxyCursorShadow() {
        ViewUtil.setVisibility(this.cursorBxShadow, 0);
        ViewUtil.setVisibility(this.cursorByShadow, 0);
        getCursorBxShadowRange(this.cursorBxShadow);
        getCursorByShadowRange(this.cursorByShadow);
        updateCursorBxShadowPosition(this.cursorBxShadow);
        updateCursorByShadowPosition(this.cursorByShadow);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showABxyCursorShadow() {
        hideABxyCursorShadow();
    }

    private final void hideABxyCursorShadow() {
        if (this.cursorAxShadow.getVisibility() != 8) {
            ViewUtil.setVisibility(this.cursorAxShadow, 8);
        }
        if (this.cursorAyShadow.getVisibility() != 8) {
            ViewUtil.setVisibility(this.cursorAyShadow, 8);
        }
        if (this.cursorBxShadow.getVisibility() != 8) {
            ViewUtil.setVisibility(this.cursorBxShadow, 8);
        }
        if (this.cursorByShadow.getVisibility() != 8) {
            ViewUtil.setVisibility(this.cursorByShadow, 8);
        }
    }

    private final void updateABxyCursorShadowPosition() {
        updateCursorAxShadowPosition(this.cursorAxShadow);
        updateCursorAyShadowPosition(this.cursorAyShadow);
        updateCursorBxShadowPosition(this.cursorBxShadow);
        updateCursorByShadowPosition(this.cursorByShadow);
    }

    public final void hideMeasureCursor() {
        ViewUtil.setVisibility(this.messureCusorA, 8);
        ViewUtil.setVisibility(this.messureCusorB, 8);
    }

    public final void showMeasureCursor() {
        ViewUtil.setVisibility(this.messureCusorA, 0);
        ViewUtil.setVisibility(this.messureCusorB, 0);
        getMeasureCursorARange(this.messureCusorA);
        updateMeasureCursorAPosition(this.messureCusorA);
        getMeasureCursorBRange(this.messureCusorB);
        updateMeasureCursorBPosition(this.messureCusorB);
    }

    public final void bindIndicator() {
        MutableLiveData<Boolean> mutableLiveData;
        UpdateUIViewModel updateUIViewModel = this.updateUIViewModel;
        if (updateUIViewModel == null || (mutableLiveData = updateUIViewModel.get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_MEASURE)) == null) {
            return;
        }
        Context context = getContext();
        if (context == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context, this.indicatorObserver);
    }

    public final void unbindIndicator() {
        MutableLiveData<Boolean> mutableLiveData;
        UpdateUIViewModel updateUIViewModel = this.updateUIViewModel;
        if (updateUIViewModel == null || (mutableLiveData = updateUIViewModel.get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_MEASURE)) == null) {
            return;
        }
        mutableLiveData.removeObserver(this.indicatorObserver);
    }

    public final void bindCursor() {
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        MutableLiveData<Object> mutableLiveData5;
        MutableLiveData<Object> mutableLiveData6;
        MutableLiveData<Object> mutableLiveData7;
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null && (mutableLiveData7 = syncDataViewModel.get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_CURSOR)) != null) {
            Context context = getContext();
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData7.observe((LifecycleOwner) context, this.cursorObserver);
        }
        SyncDataViewModel syncDataViewModel2 = this.syncDataViewModel;
        if (syncDataViewModel2 != null && (mutableLiveData6 = syncDataViewModel2.get(21, MessageID.MSG_CURSOR_MODE)) != null) {
            Context context2 = getContext();
            if (context2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData6.observe((LifecycleOwner) context2, this.cursorObserver);
        }
        SyncDataViewModel syncDataViewModel3 = this.syncDataViewModel;
        if (syncDataViewModel3 != null && (mutableLiveData5 = syncDataViewModel3.get(21, MessageID.MSG_CURSOR_MANUAL_MIRROR_SRC)) != null) {
            Context context3 = getContext();
            if (context3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData5.observe((LifecycleOwner) context3, this.cursorObserver);
        }
        SyncDataViewModel syncDataViewModel4 = this.syncDataViewModel;
        if (syncDataViewModel4 != null && (mutableLiveData4 = syncDataViewModel4.get(21, MessageID.MSG_CURSOR_HAPOS)) != null) {
            Context context4 = getContext();
            if (context4 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData4.observe((LifecycleOwner) context4, this.cursorObserver);
        }
        SyncDataViewModel syncDataViewModel5 = this.syncDataViewModel;
        if (syncDataViewModel5 != null && (mutableLiveData3 = syncDataViewModel5.get(21, MessageID.MSG_CURSOR_HBPOS)) != null) {
            Context context5 = getContext();
            if (context5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData3.observe((LifecycleOwner) context5, this.cursorObserver);
        }
        SyncDataViewModel syncDataViewModel6 = this.syncDataViewModel;
        if (syncDataViewModel6 != null && (mutableLiveData2 = syncDataViewModel6.get(21, MessageID.MSG_CURSOR_VAPOS)) != null) {
            Context context6 = getContext();
            if (context6 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData2.observe((LifecycleOwner) context6, this.cursorObserver);
        }
        SyncDataViewModel syncDataViewModel7 = this.syncDataViewModel;
        if (syncDataViewModel7 == null || (mutableLiveData = syncDataViewModel7.get(21, MessageID.MSG_CURSOR_VBPOS)) == null) {
            return;
        }
        Context context7 = getContext();
        if (context7 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData.observe((LifecycleOwner) context7, this.cursorObserver);
    }

    public final void unbindCursor() {
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(ResultListAdapter.ON_ITEM_DATA_CHANGED_KEY_CURSOR)) != null) {
            mutableLiveData2.removeObserver(this.cursorObserver);
        }
        SyncDataViewModel syncDataViewModel2 = this.syncDataViewModel;
        if (syncDataViewModel2 == null || (mutableLiveData = syncDataViewModel2.get(21, MessageID.MSG_CURSOR_MODE)) == null) {
            return;
        }
        mutableLiveData.removeObserver(this.cursorObserver);
    }

    public final void bindMeasureCursor() {
        LiveData<MeasureSettingParam> liveData;
        MeasureSettingViewModel measureSettingViewModel = this.measureSettingViewModel;
        if (measureSettingViewModel != null && (liveData = measureSettingViewModel.getLiveData()) != null) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                liveData.observe((LifecycleOwner) topActivity, new Observer<MeasureSettingParam>() { // from class: com.rigol.scope.views.window.WindowContent$bindMeasureCursor$1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(MeasureSettingParam measureSettingParam) {
                        MeasureSettingParam measureSettingParam2 = WindowContent.this.getMeasureSettingParam();
                        if (measureSettingParam2 != null) {
                            measureSettingParam2.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.WindowContent$bindMeasureCursor$1.1
                                @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                                public void onPropertyChanged(Observable observable, int i) {
                                    CursorTag cursorTag;
                                    CursorTag cursorTag2;
                                    MeasureSettingParam measureSettingParam3;
                                    MeasureSettingParam measureSettingParam4;
                                    if (i == 734) {
                                        WindowContent.this.hideMeasureCursor();
                                        if (WindowContent.this.getMeasureSettingParam() == null) {
                                            return;
                                        }
                                        MeasureSettingParam measureSettingParam5 = WindowContent.this.getMeasureSettingParam();
                                        if (measureSettingParam5 != null && measureSettingParam5.getRegion() == 2) {
                                            WindowContent.this.showMeasureCursor();
                                        }
                                    }
                                    if (i == 199 && (measureSettingParam4 = WindowContent.this.getMeasureSettingParam()) != null && measureSettingParam4.getRegion() == 2) {
                                        WindowContent.this.showMeasureCursor();
                                    }
                                    if (i == 201 && (measureSettingParam3 = WindowContent.this.getMeasureSettingParam()) != null && measureSettingParam3.getRegion() == 2) {
                                        WindowContent.this.showMeasureCursor();
                                    }
                                    if (i == 735) {
                                        cursorTag = WindowContent.this.messureCusorA;
                                        MeasureSettingParam measureSettingParam6 = WindowContent.this.getMeasureSettingParam();
                                        cursorTag.setTagStyle((measureSettingParam6 == null || measureSettingParam6.getRegionSelect() != 1) ? Paint.Style.FILL : Paint.Style.STROKE);
                                        cursorTag2 = WindowContent.this.messureCusorB;
                                        MeasureSettingParam measureSettingParam7 = WindowContent.this.getMeasureSettingParam();
                                        cursorTag2.setTagStyle((measureSettingParam7 == null || measureSettingParam7.getRegionSelect() != 0) ? Paint.Style.FILL : Paint.Style.STROKE);
                                        WindowContent.this.showMeasureCursor();
                                    }
                                }
                            });
                        }
                    }
                });
            } else {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
        }
        List<? extends MathParam> list = this.mathParams;
        if (list != null) {
            WindowParam windowParam = this.windowParam;
            if (windowParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
            if (mathItem != null) {
                mathItem.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.window.WindowContent$bindMeasureCursor$$inlined$let$lambda$1
                    @Override // androidx.databinding.Observable.OnPropertyChangedCallback
                    public void onPropertyChanged(Observable observable, int i) {
                        MeasureSettingParam measureSettingParam;
                        if (i == 1039 && (measureSettingParam = WindowContent.this.getMeasureSettingParam()) != null && measureSettingParam.getRegion() == 2) {
                            WindowContent.this.showMeasureCursor();
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateRefTag(boolean z, RefParam.Param param, int i) {
        TagView refTag = getRefTag(i);
        if (!z) {
            if (refTag != null) {
                removeRefTag(i);
            }
        } else if (!param.isOnOff()) {
            if (refTag != null) {
                removeRefTag(i);
            }
        } else if (refTag == null) {
            addRefTag(i);
        } else {
            refTag.setVisibility(0);
            updateRefPosition(param, refTag);
            updateRefColor(param, refTag);
            RefParam refParam = this.refParam;
            if (refParam != null) {
                boolean isShowLabel = refParam.isShowLabel();
                String label = param.getLabel();
                Intrinsics.checkNotNullExpressionValue(label, "it.label");
                updateRefLabel(isShowLabel, label, refTag);
            }
        }
    }

    public final void bindRef() {
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        MutableLiveData<Object> mutableLiveData3;
        MutableLiveData<Object> mutableLiveData4;
        MutableLiveData<Object> mutableLiveData5;
        MutableLiveData<Object> mutableLiveData6;
        MutableLiveData<Object> mutableLiveData7;
        for (int i = 0; i <= 9; i++) {
            SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
            if (syncDataViewModel != null && (mutableLiveData7 = syncDataViewModel.get(22, MessageID.MSG_REFID_SAVE_SRC, i)) != null) {
                Activity topActivity = ActivityUtils.getTopActivity();
                if (topActivity == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData7.observe((LifecycleOwner) topActivity, this.refObserver);
            }
            SyncDataViewModel syncDataViewModel2 = this.syncDataViewModel;
            if (syncDataViewModel2 != null && (mutableLiveData6 = syncDataViewModel2.get(22, MessageID.MSG_REFID_ENABLE, i)) != null) {
                Activity topActivity2 = ActivityUtils.getTopActivity();
                if (topActivity2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData6.observe((LifecycleOwner) topActivity2, this.refObserver);
            }
            SyncDataViewModel syncDataViewModel3 = this.syncDataViewModel;
            if (syncDataViewModel3 != null && (mutableLiveData5 = syncDataViewModel3.get(22, MessageID.MSG_REFID_COLOR, i)) != null) {
                Activity topActivity3 = ActivityUtils.getTopActivity();
                if (topActivity3 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData5.observe((LifecycleOwner) topActivity3, this.refObserver);
            }
            SyncDataViewModel syncDataViewModel4 = this.syncDataViewModel;
            if (syncDataViewModel4 != null && (mutableLiveData4 = syncDataViewModel4.get(22, MessageID.MSG_REFID_SCALE, i)) != null) {
                Activity topActivity4 = ActivityUtils.getTopActivity();
                if (topActivity4 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData4.observe((LifecycleOwner) topActivity4, this.refObserver);
            }
            SyncDataViewModel syncDataViewModel5 = this.syncDataViewModel;
            if (syncDataViewModel5 != null && (mutableLiveData3 = syncDataViewModel5.get(22, MessageID.MSG_REFID_OFFSET, i)) != null) {
                Activity topActivity5 = ActivityUtils.getTopActivity();
                if (topActivity5 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData3.observe((LifecycleOwner) topActivity5, this.refObserver);
            }
            SyncDataViewModel syncDataViewModel6 = this.syncDataViewModel;
            if (syncDataViewModel6 != null && (mutableLiveData2 = syncDataViewModel6.get(22, MessageID.MSG_REFID_LABEL_EDIT, i)) != null) {
                Activity topActivity6 = ActivityUtils.getTopActivity();
                if (topActivity6 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
                }
                mutableLiveData2.observe((LifecycleOwner) topActivity6, this.refObserver);
            }
        }
        SyncDataViewModel syncDataViewModel7 = this.syncDataViewModel;
        if (syncDataViewModel7 != null && (mutableLiveData = syncDataViewModel7.get(22, MessageID.MSG_REF_LABEL_ONOFF)) != null) {
            Activity topActivity7 = ActivityUtils.getTopActivity();
            if (topActivity7 == null) {
                throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
            }
            mutableLiveData.observe((LifecycleOwner) topActivity7, new Observer<Object>() { // from class: com.rigol.scope.views.window.WindowContent$bindRef$1
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TagView refTag;
                    if (obj instanceof Boolean) {
                        int i2 = (ServiceEnum.Chan.r10.value1 - ServiceEnum.Chan.r1.value1) + 1;
                        for (int i3 = 0; i3 < i2; i3++) {
                            refTag = WindowContent.this.getRefTag(i3);
                            if (refTag != null) {
                                refTag.setShowLabel(((Boolean) obj).booleanValue());
                            }
                            if (refTag != null) {
                                refTag.invalidate();
                            }
                        }
                    }
                }
            });
        }
        MutableLiveData<Boolean> mutableLiveData8 = ViewUtil.getViewABkeyViewModel().ax_boolean;
        Activity topActivity8 = ActivityUtils.getTopActivity();
        if (topActivity8 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData8.observe((LifecycleOwner) topActivity8, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.WindowContent$bindRef$2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean it) {
                CursorTag cursorTag;
                CursorTag cursorTag2;
                cursorTag = WindowContent.this.cursorAx;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cursorTag.setCousor_showLabel_now(it.booleanValue());
                cursorTag2 = WindowContent.this.cursorAx;
                cursorTag2.requestLayout();
            }
        });
        MutableLiveData<Boolean> mutableLiveData9 = ViewUtil.getViewABkeyViewModel().ay_boolean;
        Activity topActivity9 = ActivityUtils.getTopActivity();
        if (topActivity9 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData9.observe((LifecycleOwner) topActivity9, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.WindowContent$bindRef$3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean it) {
                CursorTag cursorTag;
                CursorTag cursorTag2;
                cursorTag = WindowContent.this.cursorAy;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cursorTag.setCousor_showLabel_now(it.booleanValue());
                cursorTag2 = WindowContent.this.cursorAy;
                cursorTag2.invalidate();
            }
        });
        MutableLiveData<Boolean> mutableLiveData10 = ViewUtil.getViewABkeyViewModel().bx_boolean;
        Activity topActivity10 = ActivityUtils.getTopActivity();
        if (topActivity10 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData10.observe((LifecycleOwner) topActivity10, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.WindowContent$bindRef$4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean it) {
                CursorTag cursorTag;
                CursorTag cursorTag2;
                cursorTag = WindowContent.this.cursorBx;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cursorTag.setCousor_showLabel_now(it.booleanValue());
                cursorTag2 = WindowContent.this.cursorBx;
                cursorTag2.requestLayout();
            }
        });
        MutableLiveData<Boolean> mutableLiveData11 = ViewUtil.getViewABkeyViewModel().by_boolean;
        Activity topActivity11 = ActivityUtils.getTopActivity();
        if (topActivity11 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData11.observe((LifecycleOwner) topActivity11, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.WindowContent$bindRef$5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean it) {
                CursorTag cursorTag;
                CursorTag cursorTag2;
                cursorTag = WindowContent.this.cursorBy;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cursorTag.setCousor_showLabel_now(it.booleanValue());
                cursorTag2 = WindowContent.this.cursorBy;
                cursorTag2.invalidate();
            }
        });
        MutableLiveData<Boolean> mutableLiveData12 = ViewUtil.getViewABkeyViewModel().popuwind_boolean;
        Activity topActivity12 = ActivityUtils.getTopActivity();
        if (topActivity12 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData12.observe((LifecycleOwner) topActivity12, new Observer<Boolean>() { // from class: com.rigol.scope.views.window.WindowContent$bindRef$6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Boolean bool) {
                CursorTag cursorTag;
                CursorTag cursorTag2;
                CursorTag cursorTag3;
                CursorTag cursorTag4;
                cursorTag = WindowContent.this.cursorAx;
                cursorTag.invalidate();
                cursorTag2 = WindowContent.this.cursorBx;
                cursorTag2.invalidate();
                cursorTag3 = WindowContent.this.cursorAy;
                cursorTag3.invalidate();
                cursorTag4 = WindowContent.this.cursorBy;
                cursorTag4.invalidate();
            }
        });
        MutableLiveData<Float> mutableLiveData13 = ViewUtil.getViewABkeyViewModel().viewpager_postion;
        Activity topActivity13 = ActivityUtils.getTopActivity();
        if (topActivity13 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
        }
        mutableLiveData13.observe((LifecycleOwner) topActivity13, new Observer<Float>() { // from class: com.rigol.scope.views.window.WindowContent$bindRef$7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Float it) {
                CursorTag cursorTag;
                CursorTag cursorTag2;
                CursorTag cursorTag3;
                CursorTag cursorTag4;
                CursorTag cursorTag5;
                CursorTag cursorTag6;
                CursorTag cursorTag7;
                CursorTag cursorTag8;
                cursorTag = WindowContent.this.cursorAx;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                cursorTag.setTagAlphaLine(it.floatValue());
                cursorTag2 = WindowContent.this.cursorBx;
                cursorTag2.setTagAlphaLine(it.floatValue());
                cursorTag3 = WindowContent.this.cursorAy;
                cursorTag3.setTagAlphaLine(it.floatValue());
                cursorTag4 = WindowContent.this.cursorBy;
                cursorTag4.setTagAlphaLine(it.floatValue());
                cursorTag5 = WindowContent.this.cursorAx;
                cursorTag5.invalidate();
                cursorTag6 = WindowContent.this.cursorBx;
                cursorTag6.invalidate();
                cursorTag7 = WindowContent.this.cursorAy;
                cursorTag7.invalidate();
                cursorTag8 = WindowContent.this.cursorBy;
                cursorTag8.invalidate();
            }
        });
    }

    public final void unbindRef() {
        MutableLiveData<Object> mutableLiveData;
        MutableLiveData<Object> mutableLiveData2;
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null && (mutableLiveData2 = syncDataViewModel.get(22, MessageID.MSG_REFID_SAVE_SRC)) != null) {
            mutableLiveData2.removeObserver(this.refObserver);
        }
        SyncDataViewModel syncDataViewModel2 = this.syncDataViewModel;
        if (syncDataViewModel2 == null || (mutableLiveData = syncDataViewModel2.get(22, MessageID.MSG_REFID_ENABLE)) == null) {
            return;
        }
        mutableLiveData.removeObserver(this.refObserver);
    }

    private final void updateIndicatorAxPosition(Indicator indicator, String[][] strArr) {
        String[] strArr2;
        String str;
        String[] strArr3;
        String str2 = (strArr == null || (strArr3 = strArr[0]) == null) ? null : strArr3[4];
        if (TextUtils.isEmpty(str2) || Intrinsics.areEqual(str2, "0")) {
            indicator.setVisibility(8);
        } else if (strArr == null || (strArr2 = strArr[0]) == null || (str = strArr2[3]) == null) {
        } else {
            indicator.setPosition((int) ((((float) (Double.parseDouble(str) - indicator.getStartX())) / ((float) (indicator.getEndX() - indicator.getStartX()))) * getWidth()));
        }
    }

    private final void updateIndicatorAyPosition(Indicator indicator, String[][] strArr) {
        String[] strArr2;
        String str;
        String[] strArr3;
        String str2 = (strArr == null || (strArr3 = strArr[0]) == null) ? null : strArr3[8];
        if (TextUtils.isEmpty(str2) || Intrinsics.areEqual(str2, "0")) {
            indicator.setVisibility(8);
        } else if (strArr == null || (strArr2 = strArr[0]) == null || (str = strArr2[7]) == null) {
        } else {
            indicator.setPosition((int) ((((float) (Double.parseDouble(str) - indicator.getStartY())) / ((float) (indicator.getEndY() - indicator.getStartY()))) * getHeight()));
            indicator.setMeaType("top");
        }
    }

    private final void updateIndicatorBxPosition(Indicator indicator, String[][] strArr) {
        String[] strArr2;
        String str;
        String[] strArr3;
        String str2 = (strArr == null || (strArr3 = strArr[0]) == null) ? null : strArr3[6];
        if (TextUtils.isEmpty(str2) || Intrinsics.areEqual(str2, "0")) {
            indicator.setVisibility(8);
        } else if (strArr == null || (strArr2 = strArr[0]) == null || (str = strArr2[5]) == null) {
        } else {
            indicator.setPosition((int) ((((float) (Double.parseDouble(str) - indicator.getStartX())) / ((float) (indicator.getEndX() - indicator.getStartX()))) * getWidth()));
        }
    }

    private final void updateIndicatorByPosition(Indicator indicator, String[][] strArr) {
        String[] strArr2;
        String str;
        String[] strArr3;
        String str2 = (strArr == null || (strArr3 = strArr[0]) == null) ? null : strArr3[10];
        if (TextUtils.isEmpty(str2) || Intrinsics.areEqual(str2, "0")) {
            indicator.setVisibility(8);
        } else if (strArr == null || (strArr2 = strArr[0]) == null || (str = strArr2[9]) == null) {
        } else {
            indicator.setPosition((int) ((((float) (Double.parseDouble(str) - indicator.getStartY())) / ((float) (indicator.getEndY() - indicator.getStartY()))) * getHeight()));
            indicator.setMeaType("low");
        }
    }

    private final void getIndicatorAxRange(Indicator indicator, ResultParam resultParam) {
        WindowParam windowParam;
        if (resultParam != null) {
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$1[windowParam2.getType().ordinal()];
            if (i == 1) {
                HorizontalParam horizontalParam = this.horizontalParam;
                if (horizontalParam != null) {
                    long j = 2;
                    indicator.setStartX(((horizontalParam.getMainScale() * (-10)) / j) + horizontalParam.getMainOffset());
                    indicator.setEndX(((horizontalParam.getMainScale() * 10) / j) + horizontalParam.getMainOffset());
                }
            } else if (i == 2) {
                HorizontalParam horizontalParam2 = this.horizontalParam;
                if (horizontalParam2 != null) {
                    long j2 = 2;
                    indicator.setStartX(((horizontalParam2.getZoomScale() * (-10)) / j2) + horizontalParam2.getZoomOffset());
                    indicator.setEndX(((horizontalParam2.getZoomScale() * 10) / j2) + horizontalParam2.getZoomOffset());
                }
            } else if (i != 3) {
            } else {
                List<? extends MathParam> list = this.mathParams;
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    if (mathItem.getOperator() != ServiceEnum.MathOperator.operator_fft) {
                        HorizontalParam horizontalParam3 = this.horizontalParam;
                        if (horizontalParam3 != null) {
                            if (mathItem.getWaveType() == ServiceEnum.MathWaveType.MathWave_Main) {
                                long j3 = 2;
                                indicator.setStartX(((horizontalParam3.getMainScale() * (-10)) / j3) + horizontalParam3.getMainOffset());
                                indicator.setEndX(((horizontalParam3.getMainScale() * 10) / j3) + horizontalParam3.getMainOffset());
                                return;
                            }
                            long j4 = 2;
                            indicator.setStartX(((horizontalParam3.getZoomScale() * (-10)) / j4) + horizontalParam3.getZoomOffset());
                            indicator.setEndX(((horizontalParam3.getZoomScale() * 10) / j4) + horizontalParam3.getZoomOffset());
                        }
                    } else if (mathItem.getWaveType() == ServiceEnum.MathWaveType.MathWave_Main) {
                        indicator.setStartX(mathItem.getFftStart());
                        indicator.setEndX(mathItem.getFftEnd());
                    } else {
                        indicator.setStartX(mathItem.getFftZoomStart());
                        indicator.setEndX(mathItem.getFftZoomStart() + (10 * mathItem.getFftZoomHScale()));
                    }
                }
            }
        }
    }

    private final void getIndicatorAyRange(Indicator indicator, ResultParam resultParam) {
        VerticalParam verticalItem;
        WindowParam windowParam;
        if (resultParam != null) {
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$2[windowParam2.getType().ordinal()];
            if (i == 1 || i == 2) {
                List<VerticalParam> list = this.verticalParams;
                if (list == null || (verticalItem = ViewUtil.getVerticalItem(list, resultParam.getSourceA())) == null) {
                    return;
                }
                long j = 2;
                indicator.setStartY(((verticalItem.getScale() * 8) / j) - verticalItem.getOffset());
                indicator.setEndY(((verticalItem.getScale() * (-8)) / j) - verticalItem.getOffset());
            } else if (i != 3) {
            } else {
                List<? extends MathParam> list2 = this.mathParams;
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list2, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        long j2 = 2;
                        indicator.setStartY(((mathItem.getFftScale() * 8) / j2) - mathItem.getFftOffset());
                        indicator.setEndY(((mathItem.getFftScale() * (-8)) / j2) - mathItem.getFftOffset());
                    } else if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_and || mathItem.getOperator() == ServiceEnum.MathOperator.operator_or || mathItem.getOperator() == ServiceEnum.MathOperator.operator_not || mathItem.getOperator() == ServiceEnum.MathOperator.operator_xor) {
                        long j3 = 8;
                        long j4 = 2;
                        indicator.setStartY(((mathItem.getLogicScale() * j3) / j4) - mathItem.getLogicOffset());
                        indicator.setEndY((((-mathItem.getLogicScale()) * j3) / j4) - mathItem.getLogicOffset());
                    } else {
                        long j5 = 8;
                        long j6 = 2;
                        indicator.setStartY(((mathItem.getScale() * j5) / j6) - mathItem.getOffset());
                        indicator.setEndY((((-mathItem.getScale()) * j5) / j6) - mathItem.getOffset());
                    }
                }
            }
        }
    }

    private final void getIndicatorBxRange(Indicator indicator, ResultParam resultParam) {
        WindowParam windowParam;
        if (resultParam != null) {
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$3[windowParam2.getType().ordinal()];
            if (i == 1) {
                HorizontalParam horizontalParam = this.horizontalParam;
                if (horizontalParam != null) {
                    long j = 2;
                    indicator.setStartX(((horizontalParam.getMainScale() * (-10)) / j) + horizontalParam.getMainOffset());
                    indicator.setEndX(((horizontalParam.getMainScale() * 10) / j) + horizontalParam.getMainOffset());
                }
            } else if (i == 2) {
                HorizontalParam horizontalParam2 = this.horizontalParam;
                if (horizontalParam2 != null) {
                    long j2 = 2;
                    indicator.setStartX(((horizontalParam2.getZoomScale() * (-10)) / j2) + horizontalParam2.getZoomOffset());
                    indicator.setEndX(((horizontalParam2.getZoomScale() * 10) / j2) + horizontalParam2.getZoomOffset());
                }
            } else if (i != 3) {
            } else {
                List<? extends MathParam> list = this.mathParams;
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    if (mathItem.getOperator() != ServiceEnum.MathOperator.operator_fft) {
                        HorizontalParam horizontalParam3 = this.horizontalParam;
                        if (horizontalParam3 != null) {
                            if (mathItem.getWaveType() == ServiceEnum.MathWaveType.MathWave_Main) {
                                long j3 = 2;
                                indicator.setStartX(((horizontalParam3.getMainScale() * (-10)) / j3) + horizontalParam3.getMainOffset());
                                indicator.setEndX(((horizontalParam3.getMainScale() * 10) / j3) + horizontalParam3.getMainOffset());
                                return;
                            }
                            long j4 = 2;
                            indicator.setStartX(((horizontalParam3.getZoomScale() * (-10)) / j4) + horizontalParam3.getZoomOffset());
                            indicator.setEndX(((horizontalParam3.getZoomScale() * 10) / j4) + horizontalParam3.getZoomOffset());
                        }
                    } else if (mathItem.getWaveType() == ServiceEnum.MathWaveType.MathWave_Main) {
                        indicator.setStartX(mathItem.getFftStart());
                        indicator.setEndX(mathItem.getFftEnd());
                    } else {
                        indicator.setStartX(mathItem.getFftZoomStart());
                        indicator.setEndX(mathItem.getFftZoomStart() + (10 * mathItem.getFftZoomHScale()));
                    }
                }
            }
        }
    }

    private final void getIndicatorByRange(Indicator indicator, ResultParam resultParam) {
        VerticalParam verticalItem;
        WindowParam windowParam;
        if (resultParam != null) {
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$4[windowParam2.getType().ordinal()];
            if (i == 1 || i == 2) {
                List<VerticalParam> list = this.verticalParams;
                if (list != null) {
                    ServiceEnum.MeasType measType = resultParam.getMeasType();
                    Intrinsics.checkNotNull(measType);
                    if (measType.value1 > ServiceEnum.MeasType.Meas_VER_TYPE_END.value1) {
                        verticalItem = ViewUtil.getVerticalItem(list, resultParam.getSourceB());
                    } else {
                        verticalItem = ViewUtil.getVerticalItem(list, resultParam.getSourceA());
                    }
                    if (verticalItem != null) {
                        long j = 2;
                        indicator.setStartY(((verticalItem.getScale() * 8) / j) - verticalItem.getOffset());
                        indicator.setEndY(((verticalItem.getScale() * (-8)) / j) - verticalItem.getOffset());
                    }
                }
            } else if (i != 3) {
            } else {
                List<? extends MathParam> list2 = this.mathParams;
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list2, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        long j2 = 2;
                        indicator.setStartY(((mathItem.getFftScale() * 8) / j2) - mathItem.getFftOffset());
                        indicator.setEndY(((mathItem.getFftScale() * (-8)) / j2) - mathItem.getFftOffset());
                    } else if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_and || mathItem.getOperator() == ServiceEnum.MathOperator.operator_or || mathItem.getOperator() == ServiceEnum.MathOperator.operator_not || mathItem.getOperator() == ServiceEnum.MathOperator.operator_xor) {
                        long j3 = 8;
                        long j4 = 2;
                        indicator.setStartY(((mathItem.getLogicScale() * j3) / j4) - mathItem.getLogicOffset());
                        indicator.setEndY((((-mathItem.getLogicScale()) * j3) / j4) - mathItem.getLogicOffset());
                    } else {
                        long j5 = 2;
                        indicator.setStartY(((mathItem.getScale() * 8) / j5) - mathItem.getOffset());
                        indicator.setEndY(((mathItem.getScale() * (-8)) / j5) - mathItem.getOffset());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCursorAxPosition(CursorTag cursorTag) {
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam == null || cursorTag.isDragging() || cursorTag.getEndX() - cursorTag.getStartX() == 0) {
            return;
        }
        this.cursorAx.setPosition((int) ((((float) (cursorResultParam.getAx() - cursorTag.getStartX())) / ((float) (cursorTag.getEndX() - cursorTag.getStartX()))) * getWidth()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCursorAyPosition(CursorTag cursorTag) {
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam == null || cursorTag.isDragging() || cursorTag.getEndY() - cursorTag.getStartY() == 0) {
            return;
        }
        this.cursorAy.setPosition((int) ((((float) (cursorResultParam.getAy() - cursorTag.getStartY())) / ((float) (cursorTag.getEndY() - cursorTag.getStartY()))) * getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCursorBxPosition(CursorTag cursorTag) {
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam == null || cursorTag.isDragging() || cursorTag.getEndX() - cursorTag.getStartX() == 0) {
            return;
        }
        this.cursorBx.setPosition((int) ((((float) (cursorResultParam.getBx() - cursorTag.getStartX())) / ((float) (cursorTag.getEndX() - cursorTag.getStartX()))) * getWidth()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateCursorByPosition(CursorTag cursorTag) {
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam == null || cursorTag.isDragging() || cursorTag.getEndY() - cursorTag.getStartY() == 0) {
            return;
        }
        this.cursorBy.setPosition((int) ((((float) (cursorResultParam.getBy() - cursorTag.getStartY())) / ((float) (cursorTag.getEndY() - cursorTag.getStartY()))) * getHeight()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCursorAxRange(CursorTag cursorTag) {
        List<? extends MathParam> list;
        WindowParam windowParam;
        List<VerticalParam> list2;
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam != null) {
            int i = WhenMappings.$EnumSwitchMapping$6[cursorResultParam.getCursorMode().ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3 && (list2 = this.verticalParams) != null) {
                    CursorResultParam cursorResultParam2 = this.cursorResultParam;
                    Intrinsics.checkNotNull(cursorResultParam2);
                    VerticalParam verticalItem = ViewUtil.getVerticalItem(list2, cursorResultParam2.getSourceA());
                    if (verticalItem != null) {
                        long j = 2;
                        cursorTag.setStartX(((verticalItem.getScale() * (-8)) / j) - verticalItem.getOffset());
                        cursorTag.setEndX(((verticalItem.getScale() * 8) / j) - verticalItem.getOffset());
                        return;
                    }
                    return;
                }
                return;
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i2 = WhenMappings.$EnumSwitchMapping$5[windowParam2.getType().ordinal()];
            if (i2 == 1) {
                HorizontalParam horizontalParam = this.horizontalParam;
                if (horizontalParam != null) {
                    long j2 = 2;
                    cursorTag.setStartX(((horizontalParam.getMainScale() * (-10)) / j2) + horizontalParam.getMainOffset());
                    cursorTag.setEndX(((horizontalParam.getMainScale() * 10) / j2) + horizontalParam.getMainOffset());
                }
            } else if (i2 == 2) {
                HorizontalParam horizontalParam2 = this.horizontalParam;
                if (horizontalParam2 != null) {
                    long j3 = 2;
                    cursorTag.setStartX(((horizontalParam2.getZoomScale() * (-10)) / j3) + horizontalParam2.getZoomOffset());
                    cursorTag.setEndX(((horizontalParam2.getZoomScale() * 10) / j3) + horizontalParam2.getZoomOffset());
                }
            } else if (i2 == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    ServiceEnum.MathWaveType waveType = mathItem.getWaveType();
                    if (mathItem.getOperator() != ServiceEnum.MathOperator.operator_fft) {
                        HorizontalParam horizontalParam3 = this.horizontalParam;
                        if (horizontalParam3 != null) {
                            if (waveType == ServiceEnum.MathWaveType.MathWave_Main) {
                                long j4 = 2;
                                cursorTag.setStartX(((horizontalParam3.getMainScale() * (-10)) / j4) + horizontalParam3.getMainOffset());
                                cursorTag.setEndX(((horizontalParam3.getMainScale() * 10) / j4) + horizontalParam3.getMainOffset());
                                return;
                            }
                            long j5 = 2;
                            cursorTag.setStartX(((horizontalParam3.getZoomScale() * (-10)) / j5) + horizontalParam3.getZoomOffset());
                            cursorTag.setEndX(((horizontalParam3.getZoomScale() * 10) / j5) + horizontalParam3.getZoomOffset());
                        }
                    } else if (waveType == ServiceEnum.MathWaveType.MathWave_Main) {
                        cursorTag.setStartX(mathItem.getFftStart());
                        cursorTag.setEndX(mathItem.getFftEnd());
                    } else {
                        cursorTag.setStartX(mathItem.getFftZoomStart());
                        cursorTag.setEndX(mathItem.getFftZoomStart() + (10 * mathItem.getFftZoomHScale()));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCursorAyRange(CursorTag cursorTag) {
        List<? extends MathParam> list;
        WindowParam windowParam;
        List<VerticalParam> list2;
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam != null) {
            int i = WhenMappings.$EnumSwitchMapping$8[cursorResultParam.getCursorMode().ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3 && (list2 = this.verticalParams) != null) {
                    CursorResultParam cursorResultParam2 = this.cursorResultParam;
                    Intrinsics.checkNotNull(cursorResultParam2);
                    VerticalParam verticalItem = ViewUtil.getVerticalItem(list2, cursorResultParam2.getSourceB());
                    if (verticalItem != null) {
                        long j = 2;
                        cursorTag.setStartY(((verticalItem.getScale() * 8) / j) - verticalItem.getOffset());
                        cursorTag.setEndY(((verticalItem.getScale() * (-8)) / j) - verticalItem.getOffset());
                        return;
                    }
                    return;
                }
                return;
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i2 = WhenMappings.$EnumSwitchMapping$7[windowParam2.getType().ordinal()];
            if (i2 == 1 || i2 == 2) {
                List<VerticalParam> list3 = this.verticalParams;
                if (list3 != null) {
                    CursorResultParam cursorResultParam3 = this.cursorResultParam;
                    Intrinsics.checkNotNull(cursorResultParam3);
                    VerticalParam verticalItem2 = ViewUtil.getVerticalItem(list3, cursorResultParam3.getSourceA());
                    if (verticalItem2 != null) {
                        long j2 = 2;
                        cursorTag.setStartY(((verticalItem2.getScale() * 8) / j2) - verticalItem2.getOffset());
                        cursorTag.setEndY(((verticalItem2.getScale() * (-8)) / j2) - verticalItem2.getOffset());
                    }
                }
            } else if (i2 == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        long j3 = 2;
                        cursorTag.setStartY(((mathItem.getFftScale() * 8) / j3) - mathItem.getFftOffset());
                        cursorTag.setEndY(((mathItem.getFftScale() * (-8)) / j3) - mathItem.getFftOffset());
                    } else if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_and || mathItem.getOperator() == ServiceEnum.MathOperator.operator_or || mathItem.getOperator() == ServiceEnum.MathOperator.operator_not || mathItem.getOperator() == ServiceEnum.MathOperator.operator_xor) {
                        long j4 = 2;
                        cursorTag.setStartY(((mathItem.getLogicScale() * 8) / j4) - mathItem.getLogicOffset());
                        cursorTag.setEndY(((mathItem.getLogicScale() * (-8)) / j4) - mathItem.getLogicOffset());
                    } else {
                        long j5 = 2;
                        cursorTag.setStartY(((mathItem.getScale() * 8) / j5) - mathItem.getOffset());
                        cursorTag.setEndY(((mathItem.getScale() * (-8)) / j5) - mathItem.getOffset());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCursorBxRange(CursorTag cursorTag) {
        List<? extends MathParam> list;
        WindowParam windowParam;
        List<VerticalParam> list2;
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam != null) {
            int i = WhenMappings.$EnumSwitchMapping$10[cursorResultParam.getCursorMode().ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3 && (list2 = this.verticalParams) != null) {
                    CursorResultParam cursorResultParam2 = this.cursorResultParam;
                    Intrinsics.checkNotNull(cursorResultParam2);
                    VerticalParam verticalItem = ViewUtil.getVerticalItem(list2, cursorResultParam2.getSourceA());
                    if (verticalItem != null) {
                        long j = 2;
                        cursorTag.setStartX(((verticalItem.getScale() * (-8)) / j) - verticalItem.getOffset());
                        cursorTag.setEndX(((verticalItem.getScale() * 8) / j) - verticalItem.getOffset());
                        return;
                    }
                    return;
                }
                return;
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i2 = WhenMappings.$EnumSwitchMapping$9[windowParam2.getType().ordinal()];
            if (i2 == 1) {
                HorizontalParam horizontalParam = this.horizontalParam;
                if (horizontalParam != null) {
                    long j2 = 2;
                    cursorTag.setStartX(((horizontalParam.getMainScale() * (-10)) / j2) + horizontalParam.getMainOffset());
                    cursorTag.setEndX(((horizontalParam.getMainScale() * 10) / j2) + horizontalParam.getMainOffset());
                }
            } else if (i2 == 2) {
                HorizontalParam horizontalParam2 = this.horizontalParam;
                if (horizontalParam2 != null) {
                    long j3 = 2;
                    cursorTag.setStartX(((horizontalParam2.getZoomScale() * (-10)) / j3) + horizontalParam2.getZoomOffset());
                    cursorTag.setEndX(((horizontalParam2.getZoomScale() * 10) / j3) + horizontalParam2.getZoomOffset());
                }
            } else if (i2 == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    ServiceEnum.MathWaveType waveType = mathItem.getWaveType();
                    if (mathItem.getOperator() != ServiceEnum.MathOperator.operator_fft) {
                        HorizontalParam horizontalParam3 = this.horizontalParam;
                        if (horizontalParam3 != null) {
                            if (waveType == ServiceEnum.MathWaveType.MathWave_Main) {
                                long j4 = 2;
                                cursorTag.setStartX(((horizontalParam3.getMainScale() * (-10)) / j4) + horizontalParam3.getMainOffset());
                                cursorTag.setEndX(((horizontalParam3.getMainScale() * 10) / j4) + horizontalParam3.getMainOffset());
                                return;
                            }
                            long j5 = 2;
                            cursorTag.setStartX(((horizontalParam3.getZoomScale() * (-10)) / j5) + horizontalParam3.getZoomOffset());
                            cursorTag.setEndX(((horizontalParam3.getZoomScale() * 10) / j5) + horizontalParam3.getZoomOffset());
                        }
                    } else if (waveType == ServiceEnum.MathWaveType.MathWave_Main) {
                        cursorTag.setStartX(mathItem.getFftStart());
                        cursorTag.setEndX(mathItem.getFftEnd());
                    } else {
                        cursorTag.setStartX(mathItem.getFftZoomStart());
                        cursorTag.setEndX(mathItem.getFftZoomStart() + (10 * mathItem.getFftZoomHScale()));
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getCursorByRange(CursorTag cursorTag) {
        VerticalParam verticalItem;
        List<? extends MathParam> list;
        WindowParam windowParam;
        List<VerticalParam> list2;
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam != null) {
            int i = WhenMappings.$EnumSwitchMapping$12[cursorResultParam.getCursorMode().ordinal()];
            if (i != 1 && i != 2) {
                if (i == 3 && (list2 = this.verticalParams) != null) {
                    CursorResultParam cursorResultParam2 = this.cursorResultParam;
                    Intrinsics.checkNotNull(cursorResultParam2);
                    VerticalParam verticalItem2 = ViewUtil.getVerticalItem(list2, cursorResultParam2.getSourceB());
                    if (verticalItem2 != null) {
                        long j = 2;
                        cursorTag.setStartY(((verticalItem2.getScale() * 8) / j) - verticalItem2.getOffset());
                        cursorTag.setEndY(((verticalItem2.getScale() * (-8)) / j) - verticalItem2.getOffset());
                        return;
                    }
                    return;
                }
                return;
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i2 = WhenMappings.$EnumSwitchMapping$11[windowParam2.getType().ordinal()];
            if (i2 == 1 || i2 == 2) {
                List<VerticalParam> list3 = this.verticalParams;
                if (list3 != null) {
                    CursorResultParam cursorResultParam3 = this.cursorResultParam;
                    Intrinsics.checkNotNull(cursorResultParam3);
                    if (cursorResultParam3.getCursorMode() == ServiceEnum.CursorMode.cursor_mode_manual) {
                        CursorResultParam cursorResultParam4 = this.cursorResultParam;
                        Intrinsics.checkNotNull(cursorResultParam4);
                        verticalItem = ViewUtil.getVerticalItem(list3, cursorResultParam4.getSourceA());
                    } else {
                        CursorResultParam cursorResultParam5 = this.cursorResultParam;
                        Intrinsics.checkNotNull(cursorResultParam5);
                        verticalItem = ViewUtil.getVerticalItem(list3, cursorResultParam5.getSourceB());
                    }
                    if (verticalItem != null) {
                        long j2 = 2;
                        cursorTag.setStartY(((verticalItem.getScale() * 8) / j2) - verticalItem.getOffset());
                        cursorTag.setEndY(((verticalItem.getScale() * (-8)) / j2) - verticalItem.getOffset());
                    }
                }
            } else if (i2 == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        long j3 = 2;
                        cursorTag.setStartY(((mathItem.getFftScale() * 8) / j3) - mathItem.getFftOffset());
                        cursorTag.setEndY(((mathItem.getFftScale() * (-8)) / j3) - mathItem.getFftOffset());
                    } else if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_and || mathItem.getOperator() == ServiceEnum.MathOperator.operator_or || mathItem.getOperator() == ServiceEnum.MathOperator.operator_not || mathItem.getOperator() == ServiceEnum.MathOperator.operator_xor) {
                        long j4 = 2;
                        cursorTag.setStartY(((mathItem.getLogicScale() * 8) / j4) - mathItem.getLogicOffset());
                        cursorTag.setEndY(((mathItem.getLogicScale() * (-8)) / j4) - mathItem.getLogicOffset());
                    } else {
                        long j5 = 2;
                        cursorTag.setStartY(((mathItem.getScale() * 8) / j5) - mathItem.getOffset());
                        cursorTag.setEndY(((mathItem.getScale() * (-8)) / j5) - mathItem.getOffset());
                    }
                }
            }
        }
    }

    private final void updateCursorAxShadowPosition(CursorTag cursorTag) {
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam == null || cursorTag.isDragging() || cursorTag.getEndX() - cursorTag.getStartX() == 0) {
            return;
        }
        this.cursorAxShadow.setPosition((int) ((((float) (cursorResultParam.getAx() - cursorTag.getStartX())) / ((float) (cursorTag.getEndX() - cursorTag.getStartX()))) * getWidth()));
    }

    private final void updateCursorAyShadowPosition(CursorTag cursorTag) {
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam == null || cursorTag.isDragging() || cursorTag.getEndY() - cursorTag.getStartY() == 0) {
            return;
        }
        this.cursorAyShadow.setPosition((int) ((((float) (cursorResultParam.getAy() - cursorTag.getStartY())) / ((float) (cursorTag.getEndY() - cursorTag.getStartY()))) * getHeight()));
    }

    private final void updateCursorBxShadowPosition(CursorTag cursorTag) {
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam == null || cursorTag.isDragging() || cursorTag.getEndX() - cursorTag.getStartX() == 0) {
            return;
        }
        this.cursorBxShadow.setPosition((int) ((((float) (cursorResultParam.getBx() - cursorTag.getStartX())) / ((float) (cursorTag.getEndX() - cursorTag.getStartX()))) * getWidth()));
    }

    private final void updateCursorByShadowPosition(CursorTag cursorTag) {
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam == null || cursorTag.isDragging() || cursorTag.getEndY() - cursorTag.getStartY() == 0) {
            return;
        }
        this.cursorByShadow.setPosition((int) ((((float) (cursorResultParam.getBy() - cursorTag.getStartY())) / ((float) (cursorTag.getEndY() - cursorTag.getStartY()))) * getHeight()));
    }

    private final void getCursorAxShadowRange(CursorTag cursorTag) {
        List<? extends MathParam> list;
        WindowParam windowParam;
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam != null) {
            if (WhenMappings.$EnumSwitchMapping$14[cursorResultParam.getCursorMode().ordinal()] != 1) {
                return;
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$13[windowParam2.getType().ordinal()];
            if (i == 1) {
                HorizontalParam horizontalParam = this.horizontalParam;
                if (horizontalParam != null) {
                    long j = 2;
                    cursorTag.setStartX(((horizontalParam.getMainScale() * (-10)) / j) + horizontalParam.getMainOffset());
                    cursorTag.setEndX(((horizontalParam.getMainScale() * 10) / j) + horizontalParam.getMainOffset());
                }
            } else if (i == 2) {
                HorizontalParam horizontalParam2 = this.horizontalParam;
                if (horizontalParam2 != null) {
                    long j2 = 2;
                    cursorTag.setStartX(((horizontalParam2.getZoomScale() * (-10)) / j2) + horizontalParam2.getZoomOffset());
                    cursorTag.setEndX(((horizontalParam2.getZoomScale() * 10) / j2) + horizontalParam2.getZoomOffset());
                }
            } else if (i == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    ServiceEnum.MathWaveType waveType = mathItem.getWaveType();
                    if (mathItem.getOperator() != ServiceEnum.MathOperator.operator_fft) {
                        HorizontalParam horizontalParam3 = this.horizontalParam;
                        if (horizontalParam3 != null) {
                            if (waveType == ServiceEnum.MathWaveType.MathWave_Main) {
                                long j3 = 2;
                                cursorTag.setStartX(((horizontalParam3.getMainScale() * (-10)) / j3) + horizontalParam3.getMainOffset());
                                cursorTag.setEndX(((horizontalParam3.getMainScale() * 10) / j3) + horizontalParam3.getMainOffset());
                                return;
                            }
                            long j4 = 2;
                            cursorTag.setStartX(((horizontalParam3.getZoomScale() * (-10)) / j4) + horizontalParam3.getZoomOffset());
                            cursorTag.setEndX(((horizontalParam3.getZoomScale() * 10) / j4) + horizontalParam3.getZoomOffset());
                        }
                    } else if (waveType == ServiceEnum.MathWaveType.MathWave_Main) {
                        cursorTag.setStartX(mathItem.getFftStart());
                        cursorTag.setEndX(mathItem.getFftEnd());
                    } else {
                        cursorTag.setStartX(mathItem.getFftZoomStart());
                        cursorTag.setEndX(mathItem.getFftZoomStart() + (10 * mathItem.getFftZoomHScale()));
                    }
                }
            }
        }
    }

    private final void getCursorAyShadowRange(CursorTag cursorTag) {
        List<? extends MathParam> list;
        WindowParam windowParam;
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam != null) {
            if (WhenMappings.$EnumSwitchMapping$16[cursorResultParam.getCursorMode().ordinal()] != 1) {
                return;
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$15[windowParam2.getType().ordinal()];
            if (i == 1 || i == 2) {
                List<VerticalParam> list2 = this.verticalParams;
                if (list2 != null) {
                    CursorResultParam cursorResultParam2 = this.cursorResultParam;
                    Intrinsics.checkNotNull(cursorResultParam2);
                    VerticalParam verticalItem = ViewUtil.getVerticalItem(list2, cursorResultParam2.getSourceA());
                    if (verticalItem != null) {
                        long j = 2;
                        cursorTag.setStartY(((verticalItem.getScale() * 8) / j) - verticalItem.getOffset());
                        cursorTag.setEndY(((verticalItem.getScale() * (-8)) / j) - verticalItem.getOffset());
                    }
                }
            } else if (i == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        long j2 = 10;
                        long j3 = 2;
                        cursorTag.setStartY((((mathItem.getFftScale() * j2) * 8) / j3) - mathItem.getFftOffset());
                        cursorTag.setEndY((((j2 * mathItem.getFftScale()) * (-8)) / j3) - mathItem.getFftOffset());
                    } else if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_and || mathItem.getOperator() == ServiceEnum.MathOperator.operator_or || mathItem.getOperator() == ServiceEnum.MathOperator.operator_not || mathItem.getOperator() == ServiceEnum.MathOperator.operator_xor) {
                        long j4 = 10;
                        long j5 = 2;
                        cursorTag.setStartY((((mathItem.getLogicScale() * j4) * 8) / j5) - mathItem.getLogicOffset());
                        cursorTag.setEndY((((j4 * mathItem.getLogicScale()) * (-8)) / j5) - mathItem.getLogicOffset());
                    } else {
                        long j6 = 10;
                        long j7 = 2;
                        cursorTag.setStartY((((mathItem.getScale() * j6) * 8) / j7) - mathItem.getOffset());
                        cursorTag.setEndY((((j6 * mathItem.getScale()) * (-8)) / j7) - mathItem.getOffset());
                    }
                }
            }
        }
    }

    private final void getCursorBxShadowRange(CursorTag cursorTag) {
        List<? extends MathParam> list;
        WindowParam windowParam;
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam != null) {
            if (WhenMappings.$EnumSwitchMapping$18[cursorResultParam.getCursorMode().ordinal()] != 1) {
                return;
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$17[windowParam2.getType().ordinal()];
            if (i == 1) {
                HorizontalParam horizontalParam = this.horizontalParam;
                if (horizontalParam != null) {
                    long j = 2;
                    cursorTag.setStartX(((horizontalParam.getMainScale() * (-10)) / j) + horizontalParam.getMainOffset());
                    cursorTag.setEndX(((horizontalParam.getMainScale() * 10) / j) + horizontalParam.getMainOffset());
                }
            } else if (i == 2) {
                HorizontalParam horizontalParam2 = this.horizontalParam;
                if (horizontalParam2 != null) {
                    long j2 = 2;
                    cursorTag.setStartX(((horizontalParam2.getZoomScale() * (-10)) / j2) + horizontalParam2.getZoomOffset());
                    cursorTag.setEndX(((horizontalParam2.getZoomScale() * 10) / j2) + horizontalParam2.getZoomOffset());
                }
            } else if (i == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    ServiceEnum.MathWaveType waveType = mathItem.getWaveType();
                    if (mathItem.getOperator() != ServiceEnum.MathOperator.operator_fft) {
                        HorizontalParam horizontalParam3 = this.horizontalParam;
                        if (horizontalParam3 != null) {
                            if (waveType == ServiceEnum.MathWaveType.MathWave_Main) {
                                long j3 = 2;
                                cursorTag.setStartX(((horizontalParam3.getMainScale() * (-10)) / j3) + horizontalParam3.getMainOffset());
                                cursorTag.setEndX(((horizontalParam3.getMainScale() * 10) / j3) + horizontalParam3.getMainOffset());
                                return;
                            }
                            long j4 = 2;
                            cursorTag.setStartX(((horizontalParam3.getZoomScale() * (-10)) / j4) + horizontalParam3.getZoomOffset());
                            cursorTag.setEndX(((horizontalParam3.getZoomScale() * 10) / j4) + horizontalParam3.getZoomOffset());
                        }
                    } else if (waveType == ServiceEnum.MathWaveType.MathWave_Main) {
                        cursorTag.setStartX(mathItem.getFftStart());
                        cursorTag.setEndX(mathItem.getFftEnd());
                    } else {
                        cursorTag.setStartX(mathItem.getFftZoomStart());
                        cursorTag.setEndX(mathItem.getFftZoomStart() + (10 * mathItem.getFftZoomHScale()));
                    }
                }
            }
        }
    }

    private final void getCursorByShadowRange(CursorTag cursorTag) {
        VerticalParam verticalItem;
        List<? extends MathParam> list;
        WindowParam windowParam;
        CursorResultParam cursorResultParam = this.cursorResultParam;
        if (cursorResultParam != null) {
            if (WhenMappings.$EnumSwitchMapping$20[cursorResultParam.getCursorMode().ordinal()] != 1) {
                return;
            }
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$19[windowParam2.getType().ordinal()];
            if (i == 1 || i == 2) {
                List<VerticalParam> list2 = this.verticalParams;
                if (list2 != null) {
                    CursorResultParam cursorResultParam2 = this.cursorResultParam;
                    Intrinsics.checkNotNull(cursorResultParam2);
                    if (cursorResultParam2.getCursorMode() == ServiceEnum.CursorMode.cursor_mode_manual) {
                        CursorResultParam cursorResultParam3 = this.cursorResultParam;
                        Intrinsics.checkNotNull(cursorResultParam3);
                        verticalItem = ViewUtil.getVerticalItem(list2, cursorResultParam3.getSourceA());
                    } else {
                        CursorResultParam cursorResultParam4 = this.cursorResultParam;
                        Intrinsics.checkNotNull(cursorResultParam4);
                        verticalItem = ViewUtil.getVerticalItem(list2, cursorResultParam4.getSourceB());
                    }
                    if (verticalItem != null) {
                        long j = 2;
                        cursorTag.setStartY(((verticalItem.getScale() * 8) / j) - verticalItem.getOffset());
                        cursorTag.setEndY(((verticalItem.getScale() * (-8)) / j) - verticalItem.getOffset());
                    }
                }
            } else if (i == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                MathParam mathItem = ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17);
                if (mathItem != null) {
                    if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_fft) {
                        long j2 = 10;
                        long j3 = 2;
                        cursorTag.setStartY((((mathItem.getFftScale() * j2) * 8) / j3) - mathItem.getFftOffset());
                        cursorTag.setEndY((((j2 * mathItem.getFftScale()) * (-8)) / j3) - mathItem.getFftOffset());
                    } else if (mathItem.getOperator() == ServiceEnum.MathOperator.operator_and || mathItem.getOperator() == ServiceEnum.MathOperator.operator_or || mathItem.getOperator() == ServiceEnum.MathOperator.operator_not || mathItem.getOperator() == ServiceEnum.MathOperator.operator_xor) {
                        long j4 = 10;
                        long j5 = 2;
                        cursorTag.setStartY((((mathItem.getLogicScale() * j4) * 8) / j5) - mathItem.getLogicOffset());
                        cursorTag.setEndY((((j4 * mathItem.getLogicScale()) * (-8)) / j5) - mathItem.getLogicOffset());
                    } else {
                        long j6 = 10;
                        long j7 = 2;
                        cursorTag.setStartY((((mathItem.getScale() * j6) * 8) / j7) - mathItem.getOffset());
                        cursorTag.setEndY((((j6 * mathItem.getScale()) * (-8)) / j7) - mathItem.getOffset());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMeasureCursorARange(CursorTag cursorTag) {
        List<? extends MathParam> list;
        WindowParam windowParam;
        HorizontalParam horizontalParam;
        if (this.measureSettingParam != null) {
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$21[windowParam2.getType().ordinal()];
            if (i == 1) {
                HorizontalParam horizontalParam2 = this.horizontalParam;
                if (horizontalParam2 != null) {
                    long j = 2;
                    cursorTag.setStartX(((horizontalParam2.getMainScale() * (-10)) / j) + horizontalParam2.getMainOffset());
                    cursorTag.setEndX(((horizontalParam2.getMainScale() * 10) / j) + horizontalParam2.getMainOffset());
                }
            } else if (i == 2) {
                HorizontalParam horizontalParam3 = this.horizontalParam;
                if (horizontalParam3 != null) {
                    long j2 = 2;
                    cursorTag.setStartX(((horizontalParam3.getZoomScale() * (-10)) / j2) + horizontalParam3.getZoomOffset());
                    cursorTag.setEndX(((horizontalParam3.getZoomScale() * 10) / j2) + horizontalParam3.getZoomOffset());
                }
            } else if (i == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                if (ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17) == null || (horizontalParam = this.horizontalParam) == null) {
                    return;
                }
                if (horizontalParam == null || !horizontalParam.isZoom()) {
                    long j3 = 2;
                    cursorTag.setStartX(((horizontalParam.getMainScale() * (-10)) / j3) + horizontalParam.getMainOffset());
                    cursorTag.setEndX(((horizontalParam.getMainScale() * 10) / j3) + horizontalParam.getMainOffset());
                    return;
                }
                long j4 = 2;
                cursorTag.setStartX(((horizontalParam.getZoomScale() * (-10)) / j4) + horizontalParam.getZoomOffset());
                cursorTag.setEndX(((horizontalParam.getZoomScale() * 10) / j4) + horizontalParam.getZoomOffset());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getMeasureCursorBRange(CursorTag cursorTag) {
        List<? extends MathParam> list;
        WindowParam windowParam;
        HorizontalParam horizontalParam;
        if (this.measureSettingParam != null) {
            WindowParam windowParam2 = this.windowParam;
            if (windowParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowParam");
            }
            int i = WhenMappings.$EnumSwitchMapping$22[windowParam2.getType().ordinal()];
            if (i == 1) {
                HorizontalParam horizontalParam2 = this.horizontalParam;
                if (horizontalParam2 != null) {
                    long j = 2;
                    cursorTag.setStartX(((horizontalParam2.getMainScale() * (-10)) / j) + horizontalParam2.getMainOffset());
                    cursorTag.setEndX(((horizontalParam2.getMainScale() * 10) / j) + horizontalParam2.getMainOffset());
                }
            } else if (i == 2) {
                HorizontalParam horizontalParam3 = this.horizontalParam;
                if (horizontalParam3 != null) {
                    long j2 = 2;
                    cursorTag.setStartX(((horizontalParam3.getZoomScale() * (-10)) / j2) + horizontalParam3.getZoomOffset());
                    cursorTag.setEndX(((horizontalParam3.getZoomScale() * 10) / j2) + horizontalParam3.getZoomOffset());
                }
            } else if (i == 3 && (list = this.mathParams) != null) {
                if (this.windowParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("windowParam");
                }
                if (ViewUtil.getMathItem((List<MathParam>) list, windowParam.getServiceID() - 17) == null || (horizontalParam = this.horizontalParam) == null) {
                    return;
                }
                if (horizontalParam == null || !horizontalParam.isZoom()) {
                    long j3 = 2;
                    cursorTag.setStartX(((horizontalParam.getMainScale() * (-10)) / j3) + horizontalParam.getMainOffset());
                    cursorTag.setEndX(((horizontalParam.getMainScale() * 10) / j3) + horizontalParam.getMainOffset());
                    return;
                }
                long j4 = 2;
                cursorTag.setStartX(((horizontalParam.getZoomScale() * (-10)) / j4) + horizontalParam.getZoomOffset());
                cursorTag.setEndX(((horizontalParam.getZoomScale() * 10) / j4) + horizontalParam.getZoomOffset());
            }
        }
    }

    private final void updateMeasureCursorAPosition(CursorTag cursorTag) {
        MeasureSettingParam measureSettingParam = this.measureSettingParam;
        if (measureSettingParam == null || cursorTag.isDragging() || cursorTag.getEndX() - cursorTag.getStartX() == 0) {
            return;
        }
        cursorTag.setPosition((int) ((((float) (measureSettingParam.getCursorA() - cursorTag.getStartX())) / ((float) (cursorTag.getEndX() - cursorTag.getStartX()))) * getWidth()));
    }

    private final void updateMeasureCursorBPosition(CursorTag cursorTag) {
        MeasureSettingParam measureSettingParam = this.measureSettingParam;
        if (measureSettingParam == null || cursorTag.isDragging() || cursorTag.getEndX() - cursorTag.getStartX() == 0) {
            return;
        }
        cursorTag.setPosition((int) ((((float) (measureSettingParam.getCursorB() - cursorTag.getStartX())) / ((float) (cursorTag.getEndX() - cursorTag.getStartX()))) * getWidth()));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.window.WindowContent$onSizeChanged$1
            @Override // java.lang.Runnable
            public final void run() {
                CursorTag cursorTag;
                CursorTag cursorTag2;
                CursorTag cursorTag3;
                CursorTag cursorTag4;
                CursorTag cursorTag5;
                CursorTag cursorTag6;
                CursorTag cursorTag7;
                CursorTag cursorTag8;
                TagView refTag;
                Observer observer;
                WindowContent windowContent = WindowContent.this;
                cursorTag = windowContent.cursorAx;
                windowContent.getCursorAxRange(cursorTag);
                WindowContent windowContent2 = WindowContent.this;
                cursorTag2 = windowContent2.cursorAx;
                windowContent2.updateCursorAxPosition(cursorTag2);
                WindowContent windowContent3 = WindowContent.this;
                cursorTag3 = windowContent3.cursorAy;
                windowContent3.getCursorAyRange(cursorTag3);
                WindowContent windowContent4 = WindowContent.this;
                cursorTag4 = windowContent4.cursorAy;
                windowContent4.updateCursorAyPosition(cursorTag4);
                WindowContent windowContent5 = WindowContent.this;
                cursorTag5 = windowContent5.cursorBx;
                windowContent5.getCursorBxRange(cursorTag5);
                WindowContent windowContent6 = WindowContent.this;
                cursorTag6 = windowContent6.cursorBx;
                windowContent6.updateCursorBxPosition(cursorTag6);
                WindowContent windowContent7 = WindowContent.this;
                cursorTag7 = windowContent7.cursorBy;
                windowContent7.getCursorByRange(cursorTag7);
                WindowContent windowContent8 = WindowContent.this;
                cursorTag8 = windowContent8.cursorBy;
                windowContent8.updateCursorByPosition(cursorTag8);
                int i5 = (ServiceEnum.Chan.r10.value1 - ServiceEnum.Chan.r1.value1) + 1;
                for (int i6 = 0; i6 < i5; i6++) {
                    refTag = WindowContent.this.getRefTag(i6);
                    if (refTag != null) {
                        refTag.initPositionEdge();
                    }
                    observer = WindowContent.this.refObserver;
                    observer.onChanged(Integer.valueOf(i6));
                }
            }
        }, 100L);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }
}
