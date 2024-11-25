package com.rigol.scope.utilities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.GravityCompat;
import androidx.core.widget.PopupWindowCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.DeviceUtils;
import com.blankj.utilcode.util.FileIOUtils;
import com.blankj.utilcode.util.IntentUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.rigol.lib.data.Firmware;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.WaveformFragment;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.ChanEnableAdapter;
import com.rigol.scope.adapters.ChanSpinnerAdapter;
import com.rigol.scope.adapters.ColorSpinnerAdapter;
import com.rigol.scope.adapters.MultiItemTypeAdapter;
import com.rigol.scope.adapters.OnItemClickListener;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseParam;
import com.rigol.scope.data.CalibrationParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.DiskParam;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.IOParam;
import com.rigol.scope.data.KeyboardParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.TwoTuple;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.data.WaveRecordParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.viewmodels.CalibrationViewModel;
import com.rigol.scope.viewmodels.FlexKnobParamViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.LaViewModel;
import com.rigol.scope.viewmodels.MaskViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.ViewABkeyViewModel;
import com.rigol.scope.viewmodels.ViewStateViewModel;
import com.rigol.scope.viewmodels.WaveRecordViewModel;
import com.rigol.scope.views.SwitchButton;
import com.rigol.scope.views.TextTrackDrawable;
import com.rigol.scope.views.TypeWritingPop;
import com.rigol.scope.views.UtilityPopupView;
import com.rigol.scope.views.alert.DefaultPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.busAnalyse.BusAnalysePopupView;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.display.DisplayPopupView;
import com.rigol.scope.views.eye.EyePopupView;
import com.rigol.scope.views.horizontal.HorizontalPopupView;
import com.rigol.scope.views.jitter.JitterPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.mask.MaskPopupView;
import com.rigol.scope.views.math.MathPopupView;
import com.rigol.scope.views.measure.MeasurePopupView;
import com.rigol.scope.views.multi.MultiWindow;
import com.rigol.scope.views.multi.MultiWindowPopupView;
import com.rigol.scope.views.record.RecordPopupView;
import com.rigol.scope.views.ref.RefPopupView;
import com.rigol.scope.views.rtsa.RtsaPopupView;
import com.rigol.scope.views.search.SearchPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.storage.StoragePopupView;
import com.rigol.scope.views.trigger.TriggerPopupView;
import com.rigol.scope.views.wave.WaveIntensityPopupView;
import com.rigol.scope.views.window.WindowHolder;
import com.rigol.util.EthernetUtil;
import com.rigol.util.PackageUtilKt;
import com.rigol.util.ToastUtils;
import java.io.File;
import java.io.FileFilter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.net.URLConnection;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.functions.Function1;
/* loaded from: classes2.dex */
public class ViewUtil {
    public static final String KEY_A = "a";
    public static final String KEY_B = "b";
    public static final int KEY_FUN_DPRINNG = 2;
    public static final int KEY_FUN_KEYINPUT = 3;
    public static final int KEY_FUN_TEXT = 1;
    public static final int LIGHT_DEFAULT = 0;
    public static final int LIGHT_HORIZONTAL = 2;
    public static final int LIGHT_VERTICAL = 1;
    private static final int MIN_DELAY_TIME = 1000;
    public static final int TYPE_EDIT = 0;
    public static final int TYPE_RADIO = 3;
    public static final int TYPE_SWITCH = 1;
    public static final int TYPE_TEXT = 2;
    public static ControlEvent controlEvent;
    public static FlexKnobParamViewModel flexKnobParamViewModel;
    private static long lastQueryTime;
    public static int serialize;
    public static ViewABkeyViewModel viewABkeyViewModel;
    public static ViewStateViewModel viewStateViewModel;

    public static int getMeasureItem(int i, int i2) {
        return ((i & 255) << 16) | ((i2 & 255) << 8);
    }

    public static int getMeasureItem(int i, int i2, int i3) {
        return ((i & 255) << 16) | ((i2 & 255) << 8) | (i3 & 255);
    }

    public static int getMeasureItem(int i, int i2, int i3, int i4) {
        return ((i & 255) << 24) | ((i2 & 255) << 16) | ((i3 & 255) << 8) | (i4 & 255);
    }

    public static int getServiceIdFromDecodeIndex(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    return i != 4 ? 0 : 45;
                }
                return 44;
            }
            return 43;
        }
        return 42;
    }

    public static int getServiceIdFromPosition(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            default:
                return 0;
        }
    }

    public static int setSpecifiedBitTo0(int i, int i2) {
        if (i > 127 || i < -128) {
            return 0;
        }
        return ((byte) i) & (~(1 << i2));
    }

    public static int setSpecifiedBitTo1(int i, int i2) {
        if (i > 127 || i < -128) {
            return 0;
        }
        return ((byte) i) | (1 << i2);
    }

    public static boolean isFastQuery() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - lastQueryTime < 1000;
        lastQueryTime = currentTimeMillis;
        return z;
    }

    public static void setVisibility(View view, int i) {
        if (view == null) {
            return;
        }
        view.setVisibility(i);
    }

    public static void setSupportsChangeAnimations(RecyclerView recyclerView, boolean z) {
        DefaultItemAnimator defaultItemAnimator = (DefaultItemAnimator) recyclerView.getItemAnimator();
        if (defaultItemAnimator != null) {
            defaultItemAnimator.setSupportsChangeAnimations(z);
        }
    }

    public static void showSpinner(View view, View view2, int i, PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        showSpinner(view, view2, getList(i), onItemClickListener);
    }

    public static void showSpinner(View view, View view2, int i, AorBManager.OnSpinnerAdapterListener onSpinnerAdapterListener, PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        showSpinner(view, view2, getList(i), onSpinnerAdapterListener, onItemClickListener);
    }

    public static void showSpinner(View view, View view2, List<MappingObject> list, PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        showSpinner(view, view2, list, 0, 5, GravityCompat.START, onItemClickListener);
    }

    public static void showSpinner(View view, View view2, List<MappingObject> list, AorBManager.OnSpinnerAdapterListener onSpinnerAdapterListener, PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        showSpinner(view, view2, list, 0, 5, GravityCompat.START, onSpinnerAdapterListener, onItemClickListener);
    }

    public static void showSpinner(View view, final View view2, final List<MappingObject> list, int i, int i2, int i3, final PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        final PopupSpinner popupSpinner = new PopupSpinner();
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(view.getContext(), list, view2.getWidth());
        selectCurrentItem(view2, list, spinnerAdapter);
        spinnerAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$pyhb81D1SxIGe6ZEzCeb4J_KPJs
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i4) {
                ViewUtil.lambda$showSpinner$0(view2, popupSpinner, onItemClickListener, list, view3, viewHolder, i4);
            }
        });
        popupSpinner.setAdapter(spinnerAdapter);
        popupSpinner.showAsDropDown(view, view2, i, i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$showSpinner$0(View view, PopupSpinner popupSpinner, PopupSpinner.OnItemClickListener onItemClickListener, List list, View view2, RecyclerView.ViewHolder viewHolder, int i) {
        if (view instanceof TextView) {
            View findViewById = viewHolder.itemView.findViewById(R.id.title);
            if (findViewById instanceof TextView) {
                ((TextView) view).setText(((TextView) findViewById).getText());
            }
        }
        popupSpinner.dismiss();
        onItemClickListener.onItemClick(view2, viewHolder, i, (MappingObject) list.get(i));
    }

    public static void showSpinner(View view, final View view2, final List<MappingObject> list, int i, int i2, int i3, AorBManager.OnSpinnerAdapterListener onSpinnerAdapterListener, final PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        final PopupSpinner popupSpinner = new PopupSpinner();
        final SpinnerAdapter spinnerAdapter = new SpinnerAdapter(view.getContext(), list, view2.getWidth());
        selectCurrentItem(view2, list, spinnerAdapter);
        spinnerAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$Csg-rbF-XPdcboHO2IC0YQeiK18
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i4) {
                ViewUtil.lambda$showSpinner$1(view2, popupSpinner, onItemClickListener, list, spinnerAdapter, view3, viewHolder, i4);
            }
        });
        popupSpinner.setAdapter(spinnerAdapter);
        popupSpinner.showAsDropDown(view, view2, 0, 5, i3);
        if (onSpinnerAdapterListener != null) {
            onSpinnerAdapterListener.onSpinnerAdapter(popupSpinner, spinnerAdapter, list, view2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$showSpinner$1(View view, PopupSpinner popupSpinner, PopupSpinner.OnItemClickListener onItemClickListener, List list, SpinnerAdapter spinnerAdapter, View view2, RecyclerView.ViewHolder viewHolder, int i) {
        if (view instanceof TextView) {
            View findViewById = viewHolder.itemView.findViewById(R.id.title);
            if (findViewById instanceof TextView) {
                ((TextView) view).setText(((TextView) findViewById).getText());
            }
        }
        popupSpinner.dismiss();
        onItemClickListener.onItemClick(view2, viewHolder, i, (MappingObject) list.get(i));
        spinnerAdapter.notifyDataSetChanged();
    }

    public static void showChanSpinner(View view, View view2, int i, PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        showChanSpinner(view, view2, getList(i), onItemClickListener);
    }

    public static void showChanSpinner(View view, View view2, int i, AorBManager.OnSpinnerAdapterListener onSpinnerAdapterListener, PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        showChanSpinner(view, view2, getList(i), onSpinnerAdapterListener, onItemClickListener);
    }

    public static void showChanSpinner(View view, final View view2, final List<MappingObject> list, final PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        final PopupSpinner popupSpinner = new PopupSpinner();
        ChanSpinnerAdapter chanSpinnerAdapter = new ChanSpinnerAdapter(view.getContext(), list, view2.getWidth());
        selectCurrentItem(view2, list, chanSpinnerAdapter);
        chanSpinnerAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$LiBjLDACyq38PO-k83IO4uPXs9c
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i) {
                onItemClickListener.onItemClick(view3, viewHolder, i, ViewUtil.onSpinnerItemClick(view2, list, popupSpinner, view3, viewHolder, i));
            }
        });
        popupSpinner.setAdapter(chanSpinnerAdapter);
        popupSpinner.showAsDropDown(view, view2, 0, 5, GravityCompat.START);
    }

    public static void showChanSpinner(View view, final View view2, final List<MappingObject> list, AorBManager.OnSpinnerAdapterListener onSpinnerAdapterListener, final PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        final PopupSpinner popupSpinner = new PopupSpinner();
        SpinnerAdapter chanSpinnerAdapter = new ChanSpinnerAdapter(view.getContext(), list, view2.getWidth());
        selectCurrentItem(view2, list, chanSpinnerAdapter);
        chanSpinnerAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$U26Grbf7Ct47sOig_BmQNr3_Ccg
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i) {
                onItemClickListener.onItemClick(view3, viewHolder, i, ViewUtil.onSpinnerItemClick(view2, list, popupSpinner, view3, viewHolder, i));
            }
        });
        popupSpinner.setAdapter(chanSpinnerAdapter);
        popupSpinner.showAsDropDown(view, view2, 0, 5, GravityCompat.START);
        if (onSpinnerAdapterListener != null) {
            onSpinnerAdapterListener.onSpinnerAdapter(popupSpinner, chanSpinnerAdapter, list, view2);
        }
    }

    public static void showStateChanSpinner(View view, View view2, int i, SparseArrayCompat<Boolean> sparseArrayCompat, PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        showStateChanSpinner(view, view2, getList(i), sparseArrayCompat, onItemClickListener);
    }

    public static void showStateChanSpinner(View view, final View view2, final List<MappingObject> list, SparseArrayCompat<Boolean> sparseArrayCompat, final PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        final PopupSpinner popupSpinner = new PopupSpinner();
        ChanEnableAdapter chanEnableAdapter = new ChanEnableAdapter(view.getContext(), list, sparseArrayCompat, view2.getWidth());
        selectCurrentItem(view2, list, chanEnableAdapter);
        chanEnableAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$81c4kJRnC2bjfSuGKAZglMhCWHk
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i) {
                onItemClickListener.onItemClick(view3, viewHolder, i, ViewUtil.onSpinnerItemClick(view2, list, popupSpinner, view3, viewHolder, i));
            }
        });
        popupSpinner.setAdapter(chanEnableAdapter);
        popupSpinner.showAsDropDown(view, view2, 0, 5, GravityCompat.START);
    }

    public static void showStateChanSpinner(View view, final View view2, final List<MappingObject> list, SparseArrayCompat<Boolean> sparseArrayCompat, AorBManager.OnSpinnerAdapterListener onSpinnerAdapterListener, final PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        final PopupSpinner popupSpinner = new PopupSpinner();
        SpinnerAdapter chanEnableAdapter = new ChanEnableAdapter(view.getContext(), list, sparseArrayCompat, view2.getWidth());
        selectCurrentItem(view2, list, chanEnableAdapter);
        chanEnableAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$IBlyOCIdHlpvZY8WTTkx9ed2W3c
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i) {
                onItemClickListener.onItemClick(view3, viewHolder, i, ViewUtil.onSpinnerItemClick(view2, list, popupSpinner, view3, viewHolder, i));
            }
        });
        popupSpinner.setAdapter(chanEnableAdapter);
        popupSpinner.showAsDropDown(view, view2, 0, 5, GravityCompat.START);
        if (onSpinnerAdapterListener != null) {
            onSpinnerAdapterListener.onSpinnerAdapter(popupSpinner, chanEnableAdapter, list, view2);
        }
    }

    public static void setState(ServiceEnum.Chan chan, ServiceEnum.Chan chan2, boolean z) {
        if (chan == null || chan2 == null) {
            return;
        }
        StateManager.INSTANCE.setState(ServiceEnum.WindowType.WIN_XY, 2, 4, Integer.valueOf(chan.value1 - ServiceEnum.Chan.chan1.value1), Integer.valueOf(chan2.value1 - ServiceEnum.Chan.chan1.value1), Boolean.valueOf(z));
    }

    public static void setState(ServiceEnum.Chan chan, ServiceEnum.Chan chan2, ServiceEnum.Chan chan3, boolean z) {
        if (chan == null || chan2 == null) {
            return;
        }
        StateManager.INSTANCE.setState(ServiceEnum.WindowType.WIN_XY, 3, 5, Integer.valueOf(chan.value1 - ServiceEnum.Chan.chan1.value1), Integer.valueOf(chan2.value1 - ServiceEnum.Chan.chan1.value1), Integer.valueOf(chan3.value1 - ServiceEnum.Chan.chan1.value1), Boolean.valueOf(z));
    }

    public static void showColorSpinner(View view, View view2, int i, PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        showColorSpinner(view, view2, getList(i), onItemClickListener);
    }

    public static void showColorSpinner(View view, final View view2, final List<MappingObject> list, final PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        final PopupSpinner popupSpinner = new PopupSpinner();
        ColorSpinnerAdapter colorSpinnerAdapter = new ColorSpinnerAdapter(view.getContext(), list, view2.getWidth());
        selectCurrentItem(view2, list, colorSpinnerAdapter);
        colorSpinnerAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$RUKpq8uJ9I3hsLyyKCoVxHS7IfM
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i) {
                onItemClickListener.onItemClick(view3, viewHolder, i, ViewUtil.onSpinnerItemClick(view2, list, popupSpinner, view3, viewHolder, i));
            }
        });
        popupSpinner.setAdapter(colorSpinnerAdapter);
        popupSpinner.showAsDropDown(view, view2, 0, 5, GravityCompat.START);
    }

    public static void showColorSpinner(View view, final View view2, final List<MappingObject> list, AorBManager.OnSpinnerAdapterListener onSpinnerAdapterListener, final PopupSpinner.OnItemClickListener<MappingObject> onItemClickListener) {
        final PopupSpinner popupSpinner = new PopupSpinner();
        SpinnerAdapter colorSpinnerAdapter = new ColorSpinnerAdapter(view.getContext(), list, view2.getWidth());
        selectCurrentItem(view2, list, colorSpinnerAdapter);
        colorSpinnerAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$bBflSLct-8EUu5pNUH6zCz8TUFs
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i) {
                onItemClickListener.onItemClick(view3, viewHolder, i, ViewUtil.onSpinnerItemClick(view2, list, popupSpinner, view3, viewHolder, i));
            }
        });
        popupSpinner.setAdapter(colorSpinnerAdapter);
        popupSpinner.showAsDropDown(view, view2, 0, 5, GravityCompat.START);
        if (onSpinnerAdapterListener != null) {
            onSpinnerAdapterListener.onSpinnerAdapter(popupSpinner, colorSpinnerAdapter, list, view2);
        }
    }

    private static void selectCurrentItem(View view, List<MappingObject> list, MultiItemTypeAdapter<List<MappingObject>> multiItemTypeAdapter) {
        int indexOf;
        if (!(view instanceof TextView) || (indexOf = MappingObject.indexOf(list, ((TextView) view).getText().toString())) == -1) {
            return;
        }
        multiItemTypeAdapter.setCurrentItem(indexOf);
    }

    private static MappingObject onSpinnerItemClick(View view, List<MappingObject> list, PopupSpinner popupSpinner, View view2, RecyclerView.ViewHolder viewHolder, int i) {
        MappingObject mappingObject = list.get(i);
        if (view instanceof TextView) {
            View findViewById = viewHolder.itemView.findViewById(R.id.title);
            if (findViewById instanceof TextView) {
                TextView textView = (TextView) view;
                textView.setText(((TextView) findViewById).getText());
                ServiceEnum.Chan chanFromValue1 = ServiceEnum.getChanFromValue1(mappingObject.getValue());
                if (chanFromValue1 != null) {
                    textView.setTextColor(ColorUtil.getColor(view2.getContext(), chanFromValue1));
                }
            }
        }
        popupSpinner.dismiss();
        return mappingObject;
    }

    public static void showDiskManage() {
        showDiskManage(null);
    }

    public static void showDiskManage(DiskManagePopupView.Callback callback) {
        showDiskManage(null, DiskManageParam.SelectionMode.ALL, callback);
    }

    public static void showDiskManage(String str, DiskManageParam.SelectionMode selectionMode, DiskManagePopupView.Callback callback) {
        showDiskManage(str, selectionMode, null, callback);
    }

    public static void showDiskManage(String str, DiskManageParam.SelectionMode selectionMode, FileFilter fileFilter, DiskManagePopupView.Callback callback) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(DiskManagePopupView.class);
        if (basePopupView instanceof DiskManagePopupView) {
            DiskManagePopupView diskManagePopupView = (DiskManagePopupView) basePopupView;
            diskManagePopupView.setFilter(fileFilter);
            diskManagePopupView.setSelectionMode(selectionMode);
            diskManagePopupView.setCallback(callback);
            diskManagePopupView.setRootPath(str);
            basePopupView.show();
        }
    }

    public static String getDiskUIPathName(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        for (DiskParam diskParam : UtilityUtil.getDiskList()) {
            if (diskParam != null) {
                String root = diskParam.getRoot();
                if (!TextUtils.isEmpty(root) && str.startsWith(root)) {
                    return diskParam.getFormattedPath(str);
                }
            }
        }
        return str;
    }

    public static void hideSystemUI(View view) {
        view.setSystemUiVisibility(MessageID.MSG_EMAIL_USERNAME);
    }

    public static void showSystemUI(View view) {
        view.setSystemUiVisibility(MessageID.MSG_CHAN_ACTIVE);
    }

    public static void drawPolygon(Canvas canvas, Path path, Paint paint, float[][] fArr) {
        for (float[] fArr2 : fArr) {
            path.lineTo(fArr2[0], fArr2[1]);
        }
        canvas.drawPath(path, paint);
    }

    public static void drawPolygon(Canvas canvas, int i, int i2, Paint paint, int i3, int i4, int i5, boolean z, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        if (i2 < 1) {
            return;
        }
        Path path = new Path();
        int i16 = i3 >> 1;
        if (i2 == 1) {
            if (z) {
                return;
            }
            float f = i;
            path.moveTo(f, 0.0f);
            path.lineTo(f, i3);
        } else if (i2 <= i4) {
            if (z) {
                i += i6;
                int i17 = i - i6;
                i12 = (i17 + i2) - i6;
                int i18 = i6 - i6;
                i13 = (i3 + i18) - i6;
                i14 = i17 + (i2 >> 1);
                i15 = i18 + i16;
            } else {
                i12 = i + i2;
                i13 = i3 + 0;
                i14 = i + (i2 >> 1);
                i15 = i16 + 0;
                i6 = 0;
            }
            float f2 = i;
            float f3 = i15;
            path.moveTo(f2, f3);
            float f4 = i14;
            path.lineTo(f4, i6);
            path.lineTo(i12, f3);
            path.lineTo(f4, i13);
            path.lineTo(f2, f3);
        } else {
            if (z) {
                i += i6;
                int i19 = i - i6;
                i7 = (i2 + i19) - i6;
                int i20 = i6 - i6;
                i8 = (i3 + i20) - i6;
                i9 = i19 + i5;
                i10 = (i7 + i6) - i5;
                i11 = i20 + i16;
            } else {
                i7 = i2 + i;
                i8 = i3 + 0;
                i9 = i + i5;
                i10 = i7 - i5;
                i11 = i16 + 0;
                i6 = 0;
            }
            float f5 = i;
            float f6 = i11;
            path.moveTo(f5, f6);
            float f7 = i9;
            float f8 = i6;
            path.lineTo(f7, f8);
            float f9 = i10;
            path.lineTo(f9, f8);
            path.lineTo(i7, f6);
            float f10 = i8;
            path.lineTo(f9, f10);
            path.lineTo(f7, f10);
            path.lineTo(f5, f6);
        }
        canvas.drawPath(path, paint);
        path.reset();
    }

    public static void setSwitchButton(SwitchButton switchButton) {
        switchButton.setTrackDrawable("OFF", "ON");
        switchButton.setTextOff("OFF");
        switchButton.setTextOn("ON");
        switchButton.setShowText(true);
    }

    public static void setSwitchButton(int i, SwitchButton switchButton) {
        List<MappingObject> list = getList(i);
        switchButton.setTrackDrawable(list.get(0).getStr(), list.get(1).getStr());
        switchButton.setTextOff(list.get(0).getStr());
        switchButton.setTextOn(list.get(1).getStr());
        switchButton.setShowText(true);
    }

    public static void updateSwitchText(int i, SwitchButton switchButton) {
        List<MappingObject> list = getList(i);
        Drawable trackDrawable = switchButton.getTrackDrawable();
        if (trackDrawable instanceof TextTrackDrawable) {
            TextTrackDrawable textTrackDrawable = (TextTrackDrawable) trackDrawable;
            textTrackDrawable.setmLeftText(list.get(0).getStr());
            textTrackDrawable.setmRightText(list.get(1).getStr());
        }
        try {
            Field declaredField = SwitchCompat.class.getDeclaredField("mOnLayout");
            Field declaredField2 = SwitchCompat.class.getDeclaredField("mOffLayout");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            declaredField.set(switchButton, null);
            declaredField2.set(switchButton, null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        switchButton.setTextOff(list.get(0).getStr());
        switchButton.setTextOn(list.get(1).getStr());
    }

    public static void showKeyboard(View view, View view2, ServiceEnum.Unit unit, long j, long j2, long j3, long j4, KeyboardListener keyboardListener) {
        KeyboardPopupView keyboardPopupView = new KeyboardPopupView(new KeyboardPopupView.Builder(unit, j, j2, j3, j4).setKeyboardListener(keyboardListener));
        keyboardListener.onCall(keyboardPopupView);
        keyboardPopupView.showAsDropDown(view, view2, 0, 0, GravityCompat.START);
    }

    public static void showKeyboard(View view, View view2, ServiceEnum.Unit unit, long j, long j2, long j3, long j4, UnitFormat.SI si, KeyboardListener keyboardListener) {
        KeyboardPopupView keyboardPopupView = new KeyboardPopupView(new KeyboardPopupView.Builder(unit, j, j2, j3, j4).setKeyboardListener(keyboardListener));
        keyboardPopupView.setBaseSI(si);
        keyboardListener.onCall(keyboardPopupView);
        keyboardPopupView.showAsDropDown(view, view2, 0, 0, GravityCompat.START);
    }

    public static void showKeyboard(View view, View view2, ServiceEnum.Unit unit, long j, long j2, long j3, long j4, String str, int i, KeyboardListener keyboardListener) {
        KeyboardPopupView keyboardPopupView = new KeyboardPopupView(new KeyboardPopupView.Builder(unit, j, j2, j3, j4).setKeyboardListener(keyboardListener));
        keyboardPopupView.setPattern(str, i);
        keyboardListener.onCall(keyboardPopupView);
        keyboardPopupView.showAsDropDown(view, view2, 0, 0, GravityCompat.START);
    }

    public static void showKeyboard(View view, View view2, ServiceEnum.Unit unit, long j, long j2, long j3, long j4, UnitFormat.SI si, UnitFormat.SI[] siArr, String str, KeyboardListener keyboardListener) {
        KeyboardPopupView keyboardPopupView = new KeyboardPopupView(new KeyboardPopupView.Builder(unit, j, j2, j3, j4).setKeyboardListener(keyboardListener));
        keyboardPopupView.setBaseSI(si);
        keyboardPopupView.setPattern(str);
        if (siArr != null) {
            KeyboardParam param = keyboardPopupView.getParam();
            if (param != null) {
                for (int i = 0; i < siArr.length; i++) {
                    param.getUnitSiList().append(i, siArr[i]);
                }
            }
            List<View> unitButtons = keyboardPopupView.getUnitButtons();
            if (unitButtons != null) {
                for (int i2 = 0; i2 < unitButtons.size(); i2++) {
                    View view3 = unitButtons.get(i2);
                    if (view3 != null) {
                        if (i2 >= siArr.length) {
                            break;
                        }
                        view3.setEnabled(true);
                    }
                }
            }
        }
        keyboardListener.onCall(keyboardPopupView);
        keyboardPopupView.showAsDropDown(view, view2, 0, 0, GravityCompat.START);
    }

    public static void showPinyinKeyboard(Context context, View view, View view2, ExternalInterface externalInterface) {
        showPinyinKeyboard(context, view, (TextView) view2, externalInterface, 17, 0, 0);
    }

    public static void showPinyinKeyboard(Context context, View view, TextView textView, ExternalInterface externalInterface, int i, int i2, int i3) {
        showPinyinKeyboard(context, view, textView, textView.getText() == null ? "" : textView.getText().toString(), externalInterface, i, i2, i3);
    }

    public static void showPinyinKeyboard(Context context, View view, View view2, String str, ExternalInterface externalInterface, int i, int i2, int i3) {
        if (view2 instanceof TextView) {
            TypeWritingPop typeWritingListener = TypeWritingPop.create(context, ActivityUtils.getTopActivity(), str).setTypeWritingListener(externalInterface);
            PopupWindowCompat.setWindowLayoutType(typeWritingListener, 1005);
            typeWritingListener.attachRefView(view2);
            typeWritingListener.show();
        }
    }

    public static void showSavePinyinKeyboard(Context context, View view, View view2, boolean z, String str, ExternalInterface externalInterface, int i, int i2, int i3) {
        if (view2 instanceof TextView) {
            TypeWritingPop typeWritingListener = TypeWritingPop.create(context, ActivityUtils.getTopActivity(), str).setTypeWritingListener(externalInterface);
            typeWritingListener.setEnglishKeyBoard();
            PopupWindowCompat.setWindowLayoutType(typeWritingListener, 1005);
            typeWritingListener.attachRefView(view2);
            typeWritingListener.show();
        }
    }

    public static void updateStatus(List<VerticalParam> list, int i) {
        if (list == null) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            VerticalParam verticalParam = list.get(i2);
            if (verticalParam != null) {
                verticalParam.setStatus(ServiceEnum.getenChanStatusFromValue1((i >> (i2 * 2)) & 3));
            }
        }
    }

    public static VerticalParam getActiveItem(List<VerticalParam> list) {
        if (list != null && !list.isEmpty()) {
            for (VerticalParam verticalParam : list) {
                if (verticalParam != null && verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_ACTIVE) {
                    return verticalParam;
                }
            }
        }
        return null;
    }

    public static VerticalParam getFirstOnItem(List<VerticalParam> list) {
        if (list != null && !list.isEmpty()) {
            for (VerticalParam verticalParam : list) {
                if (verticalParam != null && verticalParam.getStatus() == ServiceEnum.enChanStatus.CHAN_ON) {
                    return verticalParam;
                }
            }
        }
        return null;
    }

    public static VerticalParam getDefaultItem(List<VerticalParam> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        VerticalParam activeItem = getActiveItem(list);
        if (activeItem != null) {
            return activeItem;
        }
        VerticalParam firstOnItem = getFirstOnItem(list);
        return firstOnItem != null ? firstOnItem : list.get(0);
    }

    public static VerticalParam getVerticalItem(List<VerticalParam> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static VerticalParam getVerticalItem(List<VerticalParam> list, ServiceEnum.Chan chan) {
        if (list != null && !list.isEmpty()) {
            for (VerticalParam verticalParam : list) {
                if (verticalParam != null && verticalParam.getChan() == chan) {
                    return verticalParam;
                }
            }
        }
        return null;
    }

    public static DecodeParam getDecodeItem(List<DecodeParam> list, int i) {
        if (list == null || list.isEmpty() || list.size() - 1 < i) {
            return null;
        }
        return list.get(i);
    }

    public static MathParam getMathItem(List<MathParam> list, ServiceEnum.Chan chan) {
        return getMathItem(list, chan.value1 - ServiceEnum.Chan.m1.value1);
    }

    public static MathParam getMathItem(List<MathParam> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static TwoTuple<ServiceEnum.WindowType, Class<? extends BaseParam>> getItemClass(CursorResultParam cursorResultParam, ServiceEnum.Chan chan) {
        if (cursorResultParam != null && chan != null) {
            if (cursorResultParam.getCursorMode() == ServiceEnum.CursorMode.cursor_mode_xy) {
                return new TwoTuple<>(ServiceEnum.WindowType.WIN_XY, VerticalParam.class);
            }
            if (isAnalogChannel(chan)) {
                if (cursorResultParam.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                    return new TwoTuple<>(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM, HorizontalParam.class);
                }
                return new TwoTuple<>(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM, VerticalParam.class);
            } else if (isMathChannel(chan)) {
                if (cursorResultParam.getView() == ServiceEnum.CursorView.cursor_view_hori) {
                    return new TwoTuple<>(ServiceEnum.WindowType.WIN_MATH, HorizontalParam.class);
                }
                return new TwoTuple<>(ServiceEnum.WindowType.WIN_MATH, MathParam.class);
            }
        }
        return null;
    }

    public static List<MappingObject> getList(int i) {
        return MappingHelper.getInstance().getList(i);
    }

    public static List<MappingObject> getList(ServiceEnum.Chan[] chanArr) {
        ArrayList arrayList = new ArrayList();
        for (ServiceEnum.Chan chan : chanArr) {
            MappingObject mappingObject = new MappingObject();
            mappingObject.setValue(chan.value1);
            mappingObject.setStr(chan.value2);
            mappingObject.setPi(chan.pic1);
            arrayList.add(mappingObject);
        }
        return arrayList;
    }

    public static SparseArrayCompat<MappingObject> getArray(int i) {
        return MappingHelper.getInstance().getArray(i);
    }

    public static MappingObject getMappingObject(int i, int i2) {
        return getArray(i).get(i2);
    }

    public static MappingObject getMappingObject(int i, int i2, int i3) {
        SparseArrayCompat<MappingObject> array = getArray(i);
        array.putAll(getArray(i2));
        return array.get(i3);
    }

    public static List<String> generateData(int i) {
        if (i <= 0) {
            return null;
        }
        Random random = new Random();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList.add(String.valueOf(random.nextInt() + i2));
        }
        return arrayList;
    }

    public static int toInt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        return (int) Float.parseFloat(str);
    }

    public static void lock(boolean z) {
        Activity topActivity = ActivityUtils.getTopActivity();
        if (topActivity instanceof MainActivity) {
            ((MainActivity) topActivity).locked(z);
        }
    }

    public static void lock(Window window, boolean z) {
        if (window == null) {
            return;
        }
        if (z) {
            window.setFlags(16, 16);
        } else {
            window.clearFlags(16);
        }
    }

    public static void gotoAWG() {
        Intent launchAppIntent = IntentUtils.getLaunchAppIntent(PackageUtilKt.PACKAGE_NAME_AWG);
        if (launchAppIntent == null) {
            ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_toast_not_instlled));
        } else {
            ActivityUtils.startActivity(launchAppIntent);
        }
    }

    public static String getNextFileName(File file, String str, ServiceEnum.enFileType enfiletype) {
        if (file == null || TextUtils.isEmpty(str) || enfiletype == null) {
            return null;
        }
        File[] listFiles = file.listFiles();
        int i = 0;
        if (listFiles == null || listFiles.length == 0) {
            return getFileName(str, enfiletype, 0);
        }
        String fileName = getFileName(str, enfiletype, 0);
        File file2 = new File(file.getPath(), fileName);
        while (file2.exists() && file2.isFile()) {
            i++;
            fileName = getFileName(str, enfiletype, i);
            file2 = new File(file.getPath(), fileName);
        }
        return fileName;
    }

    private static String getFileName(String str, ServiceEnum.enFileType enfiletype, int i) {
        return str + i + "." + enfiletype.value2;
    }

    public static List<Integer> getBitsFromValue(int i) {
        ArrayList arrayList = new ArrayList();
        String binaryString = Integer.toBinaryString(i);
        for (int i2 = 0; i2 < binaryString.length(); i2++) {
            arrayList.add(Integer.valueOf(Integer.parseInt(String.valueOf(binaryString.charAt(i2)))));
        }
        Collections.reverse(arrayList);
        return arrayList;
    }

    public static List<Integer> checkLengthIfNotEnoughThenAdd(List<Integer> list, int i) {
        if (list != null && !list.isEmpty() && i > list.size()) {
            int size = i - list.size();
            for (int i2 = 0; i2 < size; i2++) {
                list.add(0);
            }
        }
        return list;
    }

    public static List<Integer> selectAllBitWhenFirstBitOn(List<Integer> list) {
        return (list == null || list.isEmpty() || list.get(0).intValue() != 1) ? list : selectAllBits(list);
    }

    public static boolean isAllBitsSelected(List<Integer> list, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        while (i < i2) {
            if (list.get(i).intValue() != 1) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isAllBitsUnSelected(List<Integer> list, int i, int i2) {
        if (list == null || list.isEmpty()) {
            return false;
        }
        while (i < i2) {
            if (list.get(i).intValue() != 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static List<Integer> selectAllBits(List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, 1);
            }
        }
        return list;
    }

    public static List<Integer> unSelectAllBits(List<Integer> list) {
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, 0);
            }
        }
        return list;
    }

    public static int getValueFromBits(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            Integer num = list.get(i2);
            if (num.intValue() == 1) {
                i += num.intValue() << i2;
            }
        }
        return i;
    }

    public static void addMeasureItem(int i) {
        API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_ADD_MENU, i);
    }

    public static void SetMeasureCat(int i) {
        API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_CAT, i);
    }

    public static void changeMeasureItem(int i) {
        API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_CHANGED_ITEM, i);
    }

    public static void changeItemAllSource(int i) {
        API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_CHANGED_ALLITEMSOURCE, i);
    }

    public static int getServiceIdFromChan(ServiceEnum.Chan chan) {
        switch (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan[chan.ordinal()]) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 17;
            case 6:
                return 18;
            case 7:
                return 19;
            case 8:
                return 20;
            default:
                return 0;
        }
    }

    public static ServiceEnum.Chan getChanFromServiceId(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return ServiceEnum.Chan.chan4;
                    }
                    switch (i) {
                        case 17:
                            return ServiceEnum.Chan.m1;
                        case 18:
                            return ServiceEnum.Chan.m2;
                        case 19:
                            return ServiceEnum.Chan.m3;
                        case 20:
                            return ServiceEnum.Chan.m4;
                        default:
                            return ServiceEnum.Chan.chan_none;
                    }
                }
                return ServiceEnum.Chan.chan3;
            }
            return ServiceEnum.Chan.chan2;
        }
        return ServiceEnum.Chan.chan1;
    }

    public static boolean isAnalogChannel(ServiceEnum.Chan chan) {
        return chan != null && chan.value1 >= ServiceEnum.Chan.chan1.value1 && chan.value1 <= ServiceEnum.Chan.chan4.value1;
    }

    public static boolean isMathChannel(ServiceEnum.Chan chan) {
        return chan != null && chan.value1 >= ServiceEnum.Chan.m1.value1 && chan.value1 <= ServiceEnum.Chan.m4.value1;
    }

    public static boolean isRefChannel(ServiceEnum.Chan chan) {
        return chan != null && chan.value1 >= ServiceEnum.Chan.r1.value1 && chan.value1 <= ServiceEnum.Chan.r10.value1;
    }

    public static SpannableString getTitleWithSrc(Context context, String str, ServiceEnum.Chan chan) {
        String str2;
        SpannableString spannableString = new SpannableString(str + "(" + getShortChanStr(chan) + ")");
        spannableString.setSpan(new ForegroundColorSpan(ColorUtil.getColor(context, chan)), str.length() + 1, str2.length() - 1, 33);
        return spannableString;
    }

    public static SpannableString getTitleWithSrc(Context context, String str, ServiceEnum.Chan chan, ServiceEnum.Chan chan2) {
        String str2;
        if (chan2 == null || TextUtils.isEmpty(chan2.value2)) {
            return getTitleWithSrc(context, str, chan);
        }
        SpannableString spannableString = new SpannableString(str + "(" + getShortChanStr(chan) + " - " + getShortChanStr(chan2) + ")");
        spannableString.setSpan(new ForegroundColorSpan(ColorUtil.getColor(context, chan)), str.length() + 1, str.length() + 2 + String.valueOf(chan.value1).length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ColorUtil.getColor(context, chan2)), (str2.length() - 2) - String.valueOf(chan2.value1).length(), str2.length() - 1, 33);
        return spannableString;
    }

    public static String getShortChanStr(ServiceEnum.Chan chan, ServiceEnum.Chan chan2) {
        if (chan == null && chan2 == null) {
            return "";
        }
        if (chan == null) {
            return getShortChanStr(chan2);
        }
        if (chan2 == null) {
            return getShortChanStr(chan);
        }
        String shortChanStr = getShortChanStr(chan);
        String shortChanStr2 = getShortChanStr(chan2);
        if (TextUtils.isEmpty(shortChanStr)) {
            return shortChanStr2;
        }
        if (TextUtils.isEmpty(shortChanStr2)) {
            return shortChanStr;
        }
        return shortChanStr + "-" + shortChanStr2;
    }

    public static String getShortChanStr(ServiceEnum.Chan chan) {
        if (chan == null || chan == ServiceEnum.Chan.chan_none) {
            return "";
        }
        if (chan.value1 >= ServiceEnum.Chan.chan1.value1 && chan.value1 <= ServiceEnum.Chan.chan4.value1) {
            return "C" + ((chan.value1 - ServiceEnum.Chan.chan1.value1) + 1);
        } else if (chan.value1 >= ServiceEnum.Chan.m1.value1 && chan.value1 <= ServiceEnum.Chan.m4.value1) {
            return "M" + ((chan.value1 - ServiceEnum.Chan.m1.value1) + 1);
        } else if (chan.value1 >= ServiceEnum.Chan.r1.value1 && chan.value1 <= ServiceEnum.Chan.r10.value1) {
            return "R" + ((chan.value1 - ServiceEnum.Chan.r1.value1) + 1);
        } else if (chan.value1 == ServiceEnum.Chan.ext.value1) {
            return ExifInterface.LONGITUDE_EAST;
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("D");
            sb.append(chan.value1 - 9);
            return sb.toString();
        }
    }

    public static String getFullChanStr(ServiceEnum.Chan chan, ServiceEnum.Chan chan2) {
        if (chan == null && chan2 == null) {
            return "";
        }
        if (chan == null) {
            return getFullChanStr(chan2);
        }
        if (chan2 == null) {
            return getFullChanStr(chan);
        }
        String fullChanStr = getFullChanStr(chan);
        String fullChanStr2 = getFullChanStr(chan2);
        if (TextUtils.isEmpty(fullChanStr)) {
            return fullChanStr2;
        }
        if (TextUtils.isEmpty(fullChanStr2)) {
            return fullChanStr;
        }
        return fullChanStr + "-" + fullChanStr2;
    }

    public static String getFullChanStr(ServiceEnum.Chan chan) {
        if (chan == null) {
            return "";
        }
        if (chan.value1 >= ServiceEnum.Chan.chan1.value1 && chan.value1 <= ServiceEnum.Chan.chan4.value1) {
            return "Chan" + ((chan.value1 - ServiceEnum.Chan.chan1.value1) + 1);
        } else if (chan.value1 >= ServiceEnum.Chan.m1.value1 && chan.value1 <= ServiceEnum.Chan.m4.value1) {
            return "Math" + ((chan.value1 - ServiceEnum.Chan.m1.value1) + 1);
        } else if (chan.value1 < ServiceEnum.Chan.r1.value1 || chan.value1 > ServiceEnum.Chan.r10.value1) {
            return chan.value1 == ServiceEnum.Chan.ext.value1 ? "Ext" : "";
        } else {
            return "Ref" + ((chan.value1 - ServiceEnum.Chan.r1.value1) + 1);
        }
    }

    public static String getDecodeSimpleStr(DecodeParam decodeParam) {
        switch (decodeParam.getServiceId()) {
            case 42:
                return "B1";
            case 43:
                return "B2";
            case 44:
                return "B3";
            case 45:
                return "B4";
            default:
                return "";
        }
    }

    public static String getChanWinTitleStr(ServiceEnum.Chan chan) {
        if (chan != null && chan.value1 >= ServiceEnum.Chan.chan1.value1 && chan.value1 <= ServiceEnum.Chan.chan4.value1) {
            return "CH" + ((chan.value1 - ServiceEnum.Chan.chan1.value1) + 1);
        }
        return "";
    }

    public static MultiWindow getMultiWindow() {
        WaveformFragment waveformFragment;
        Activity topActivity = ActivityUtils.getTopActivity();
        if (!(topActivity instanceof MainActivity) || (waveformFragment = ((MainActivity) topActivity).getWaveformFragment()) == null) {
            return null;
        }
        return waveformFragment.getBinding().multiWindow;
    }

    public static Drawable getTriggerEdgePic(ServiceEnum.EdgeSlope edgeSlope) {
        if (edgeSlope == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_edge_rising);
        }
        int i = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ContextUtil.getDrawable(R.drawable.trigger_edge_either);
            }
            return ContextUtil.getDrawable(R.drawable.trigger_edge_rising);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_edge_falling);
    }

    public static Drawable getPulsePic(int i) {
        if (i == 0) {
            return ContextUtil.getDrawable(R.drawable.trigger_pulse_positive);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_pulse_negative);
    }

    public static Drawable getTriggerPulsePolarityPic(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        if (triggerPulsePolarity == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_pulse_positive);
        }
        if (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity[triggerPulsePolarity.ordinal()] == 1) {
            return ContextUtil.getDrawable(R.drawable.trigger_pulse_negative);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_pulse_positive);
    }

    public static Drawable getTriggerSslopePic(ServiceEnum.EdgeSlope edgeSlope) {
        if (edgeSlope == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_slope_rising);
        }
        if (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope.ordinal()] == 1) {
            return ContextUtil.getDrawable(R.drawable.trigger_slope_falling);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_slope_rising);
    }

    public static Drawable getTriggerVideoPolarityPic(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        if (triggerPulsePolarity == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_video_positive);
        }
        if (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity[triggerPulsePolarity.ordinal()] == 1) {
            return ContextUtil.getDrawable(R.drawable.trigger_video_negative);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_video_positive);
    }

    public static Drawable getTriggerPatternPic(ServiceEnum.TriggerPattern triggerPattern) {
        TriggerViewModel triggerViewModel = (TriggerViewModel) ContextUtil.getAppViewModel(TriggerViewModel.class);
        if (triggerViewModel == null) {
            return ContextUtil.getDrawable(R.drawable.ic_trigger_x);
        }
        if (triggerViewModel.getLiveData().getValue() == null) {
            return ContextUtil.getDrawable(R.drawable.ic_trigger_x);
        }
        if (triggerPattern == null) {
            return ContextUtil.getDrawable(R.drawable.ic_trigger_x);
        }
        int i = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[triggerPattern.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return ContextUtil.getDrawable(R.drawable.ic_falling);
                    }
                    return ContextUtil.getDrawable(R.drawable.ic_trigger_x);
                }
                return ContextUtil.getDrawable(R.drawable.ic_rising);
            }
            return ContextUtil.getDrawable(R.drawable.ic_trigger_zero);
        }
        return ContextUtil.getDrawable(R.drawable.ic_trigger_one);
    }

    public static Drawable getTriggerDurationPatternPic(ServiceEnum.TriggerPattern triggerPattern) {
        TriggerViewModel triggerViewModel = (TriggerViewModel) ContextUtil.getAppViewModel(TriggerViewModel.class);
        if (triggerViewModel == null) {
            return ContextUtil.getDrawable(R.drawable.ic_trigger_x);
        }
        if (triggerViewModel.getLiveData().getValue() == null) {
            return ContextUtil.getDrawable(R.drawable.ic_trigger_x);
        }
        if (triggerPattern == null) {
            return ContextUtil.getDrawable(R.drawable.ic_trigger_x);
        }
        int i = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[triggerPattern.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ContextUtil.getDrawable(R.drawable.ic_trigger_zero);
            }
            return ContextUtil.getDrawable(R.drawable.ic_trigger_x);
        }
        return ContextUtil.getDrawable(R.drawable.ic_trigger_one);
    }

    public static Drawable getTriggerTimeoutPic(ServiceEnum.EdgeSlope edgeSlope) {
        if (edgeSlope == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_timeout_rising);
        }
        int i = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return ContextUtil.getDrawable(R.drawable.trigger_timeout_either);
            }
            return ContextUtil.getDrawable(R.drawable.trigger_timeout_rising);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_timeout_falling);
    }

    public static Drawable getTriggerRuntPolarityPic(ServiceEnum.TriggerPulsePolarity triggerPulsePolarity) {
        if (triggerPulsePolarity == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_runt_positive);
        }
        if (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity[triggerPulsePolarity.ordinal()] == 1) {
            return ContextUtil.getDrawable(R.drawable.trigger_runt_negative);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_runt_positive);
    }

    public static Drawable getTriggerOverPic(ServiceEnum.EdgeSlope edgeSlope, ServiceEnum.OverEvent overEvent) {
        if (edgeSlope == null || overEvent == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_over_rising_enter);
        }
        int i = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope.ordinal()];
        if (i == 1) {
            int i2 = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[overEvent.ordinal()];
            if (i2 != 1) {
                if (i2 == 2) {
                    return ContextUtil.getDrawable(R.drawable.trigger_over_falling_time);
                }
                return ContextUtil.getDrawable(R.drawable.trigger_over_falling_enter);
            }
            return ContextUtil.getDrawable(R.drawable.trigger_over_falling_exit);
        } else if (i == 2) {
            int i3 = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[overEvent.ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return ContextUtil.getDrawable(R.drawable.trigger_over_either_time);
                }
                return ContextUtil.getDrawable(R.drawable.trigger_over_either_enter);
            }
            return ContextUtil.getDrawable(R.drawable.trigger_over_either_exit);
        } else {
            int i4 = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[overEvent.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    return ContextUtil.getDrawable(R.drawable.trigger_over_rising_time);
                }
                return ContextUtil.getDrawable(R.drawable.trigger_over_rising_enter);
            }
            return ContextUtil.getDrawable(R.drawable.trigger_over_rising_exit);
        }
    }

    public static Drawable getTriggerDelayPic(ServiceEnum.EdgeSlope edgeSlope, ServiceEnum.EdgeSlope edgeSlope2) {
        if (edgeSlope == null || edgeSlope2 == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_delay_rising);
        }
        if (edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising && edgeSlope2 == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
            return ContextUtil.getDrawable(R.drawable.trigger_delay_rising_falling);
        }
        if (edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && edgeSlope2 == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
            return ContextUtil.getDrawable(R.drawable.trigger_delay_falling_rising);
        }
        if (edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling && edgeSlope2 == ServiceEnum.EdgeSlope.Trigger_Edge_Falling) {
            return ContextUtil.getDrawable(R.drawable.trigger_delay_falling);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_delay_rising);
    }

    public static Drawable getTriggerSetupHoldPic(ServiceEnum.EdgeSlope edgeSlope, ServiceEnum.SHEvent sHEvent) {
        if (edgeSlope == null || sHEvent == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_setup_hold_rising_setup);
        }
        if (edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising) {
            if (sHEvent == ServiceEnum.SHEvent.Trigger_SH_setup) {
                return ContextUtil.getDrawable(R.drawable.trigger_setup_hold_rising_setup);
            }
            if (sHEvent == ServiceEnum.SHEvent.Trigger_SH_hold) {
                return ContextUtil.getDrawable(R.drawable.trigger_setup_hold_rising_hold);
            }
            return ContextUtil.getDrawable(R.drawable.trigger_setup_hold_rising_setup_hold);
        } else if (sHEvent == ServiceEnum.SHEvent.Trigger_SH_setup) {
            return ContextUtil.getDrawable(R.drawable.trigger_setup_hold_falling_setup);
        } else {
            if (sHEvent == ServiceEnum.SHEvent.Trigger_SH_hold) {
                return ContextUtil.getDrawable(R.drawable.trigger_setup_hold_falling_hold);
            }
            return ContextUtil.getDrawable(R.drawable.trigger_setup_hold_falling_setup_hold);
        }
    }

    public static Drawable getTriggerNthPic(ServiceEnum.EdgeSlope edgeSlope) {
        if (edgeSlope == null) {
            return ContextUtil.getDrawable(R.drawable.trigger_nth_rising);
        }
        if (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[edgeSlope.ordinal()] == 1) {
            return ContextUtil.getDrawable(R.drawable.trigger_nth_falling);
        }
        return ContextUtil.getDrawable(R.drawable.trigger_nth_rising);
    }

    public static String[] getVerticalRulers(List<VerticalParam> list) {
        VerticalParam defaultItem = getDefaultItem(list);
        String[] strArr = new String[9];
        if (defaultItem == null) {
            return strArr;
        }
        for (int i = 0; i < 9; i++) {
            strArr[i] = UnitFormat.newBuilder("0.###", UnitFormat.SI.NANO).convert(((4 - i) * defaultItem.getScale()) - defaultItem.getOffset(), defaultItem.getUnit());
        }
        return strArr;
    }

    public static String[] getReverseVerticalRulers(List<VerticalParam> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i > list.size()) {
            return null;
        }
        VerticalParam verticalParam = list.get(i);
        String[] strArr = new String[9];
        if (verticalParam == null) {
            return strArr;
        }
        for (int i2 = 8; i2 >= 0; i2--) {
            strArr[8 - i2] = UnitFormat.newBuilder("0.##", UnitFormat.SI.NANO).convert(((4 - i2) * verticalParam.getScale()) - verticalParam.getOffset(), verticalParam.getUnit());
        }
        return strArr;
    }

    public static String[] getVerticalRulers(List<VerticalParam> list, int i) {
        if (list == null || list.isEmpty() || i < 0 || i > list.size()) {
            return null;
        }
        VerticalParam verticalParam = list.get(i);
        String[] strArr = new String[9];
        if (verticalParam == null) {
            return strArr;
        }
        for (int i2 = 0; i2 < 9; i2++) {
            strArr[i2] = UnitFormat.newBuilder("0.##", UnitFormat.SI.NANO).convert(((4 - i2) * verticalParam.getScale()) - verticalParam.getOffset(), verticalParam.getUnit());
        }
        return strArr;
    }

    public static String[] getHorizontalMainRulers(HorizontalParam horizontalParam) {
        String[] strArr = new String[11];
        if (horizontalParam == null) {
            return strArr;
        }
        for (int i = 0; i < 11; i++) {
            strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(((i - 5) * horizontalParam.getMainScale()) + horizontalParam.getMainOffset(), ServiceEnum.Unit.Unit_s);
        }
        return strArr;
    }

    public static String[] getHorizontalZoomRulers(HorizontalParam horizontalParam) {
        String[] strArr = new String[11];
        if (horizontalParam == null) {
            return strArr;
        }
        for (int i = 0; i < 11; i++) {
            strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(((i - 5) * horizontalParam.getZoomScale()) + horizontalParam.getZoomOffset(), ServiceEnum.Unit.Unit_s);
        }
        return strArr;
    }

    public static String[] getRtsaXRulers(FftParam fftParam) {
        String[] strArr = new String[11];
        if (fftParam == null) {
            return strArr;
        }
        for (int i = 0; i < 11; i++) {
            strArr[i] = subNumber(UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO).convert(fftParam.getStart() + ((i * (fftParam.getEnd() - fftParam.getStart())) / 10), ServiceEnum.Unit.Unit_hz), 6);
        }
        return strArr;
    }

    public static String[] getRtsaYRulers(FftParam fftParam) {
        String[] strArr = new String[11];
        if (fftParam == null) {
            return strArr;
        }
        int i = 0;
        if (fftParam.getUnit() == ServiceEnum.Unit.Unit_dbm || fftParam.getUnit() == ServiceEnum.Unit.Unit_dBmV || fftParam.getUnit() == ServiceEnum.Unit.Unit_dBuV) {
            while (i < 11) {
                strArr[i] = subNumber(String.valueOf(((fftParam.getRefLevel() - (i * fftParam.getScale())) * 1.0d) / 1.0E9d), 5) + fftParam.getUnit().value2;
                i++;
            }
        } else if (fftParam.getUnit() == ServiceEnum.Unit.Unit_V) {
            while (i < 11) {
                long doDBmtoV = fftParam.doDBmtoV(fftParam.doVtoDBm(fftParam.getRefLevel()) - (i * fftParam.getScale()));
                strArr[i] = (doDBmtoV < 1 || doDBmtoV > fftParam.getRefLevelAttr().getMaxLongValue()) ? "<1nV" : UnitFormat.newBuilder("0.##", UnitFormat.SI.NANO).convert(doDBmtoV, fftParam.getUnit());
                i++;
            }
        } else if (fftParam.getUnit() != ServiceEnum.Unit.Unit_W) {
            return strArr;
        } else {
            while (i < 11) {
                long doDBmtoW = fftParam.doDBmtoW(fftParam.doWtoDBm(fftParam.getRefLevel()) - (i * fftParam.getScale()));
                strArr[i] = (doDBmtoW < 1 || doDBmtoW > fftParam.getRefLevelAttr().getMaxLongValue()) ? "<1nW" : UnitFormat.newBuilder("0.##", UnitFormat.SI.NANO).convert(doDBmtoW, fftParam.getUnit());
                i++;
            }
        }
        return strArr;
    }

    public static String[] getMathXMainRulers(MathParam mathParam, HorizontalParam horizontalParam) {
        String[] strArr = new String[11];
        int i = 0;
        if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_fft) {
            if (mathParam == null) {
                return strArr;
            }
            while (i < 11) {
                UnitFormat newBuilder = UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO);
                strArr[i] = subNumber(newBuilder.convert(mathParam.getFftStart() + (i * (mathParam.getFftSpan() / 10)), ServiceEnum.Unit.Unit_hz), 6);
                i++;
            }
        } else if (horizontalParam == null) {
            return strArr;
        } else {
            while (i < 11) {
                strArr[i] = UnitFormat.newBuilder("0.###", UnitFormat.SI.FEMTO).convert(((i - 5) * horizontalParam.getMainScale()) + horizontalParam.getMainOffset(), ServiceEnum.Unit.Unit_s);
                i++;
            }
        }
        return strArr;
    }

    public static String[] getMathXZoomRulers(MathParam mathParam, HorizontalParam horizontalParam) {
        String[] strArr = new String[11];
        int i = 0;
        if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_fft) {
            if (mathParam == null) {
                return strArr;
            }
            while (i < 11) {
                UnitFormat newBuilder = UnitFormat.newBuilder("0.##########", UnitFormat.SI.MICRO);
                strArr[i] = subNumber(newBuilder.convert(mathParam.getFftStart() + (i * (mathParam.getFftSpan() / 10)), ServiceEnum.Unit.Unit_hz), 6);
                i++;
            }
        } else if (horizontalParam == null) {
            return strArr;
        } else {
            while (i < 11) {
                strArr[i] = UnitFormat.newBuilder("0.###", UnitFormat.SI.FEMTO).convert(((i - 5) * horizontalParam.getZoomScale()) + horizontalParam.getZoomOffset(), ServiceEnum.Unit.Unit_s);
                i++;
            }
        }
        return strArr;
    }

    public static String[] getMathYRulers(MathParam mathParam) {
        String convert;
        double d;
        String[] strArr = new String[9];
        if (mathParam == null) {
            return strArr;
        }
        int i = 0;
        if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_fft) {
            while (i < 9) {
                long fftScale = ((4 - i) * mathParam.getFftScale()) - mathParam.getFftOffset();
                if (mathParam.getFftUnitIndex() != ServiceEnum.fftSpecUnit.fft_spec_rms) {
                    if (Math.abs((fftScale * 1.0d) / 1.0E9d) > 1000.0d) {
                        convert = UnitFormat.newBuilder("0.##", UnitFormat.SI.NANO).convert(fftScale, mathParam.getUnitIndex());
                    } else {
                        convert = subNumber(String.valueOf(d), 5) + mathParam.getUnitIndex().value2;
                    }
                } else {
                    convert = UnitFormat.newBuilder("0.##", UnitFormat.SI.NANO).convert(fftScale, mathParam.getUnitIndex());
                }
                strArr[i] = convert;
                i++;
            }
        } else if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_and || mathParam.getOperator() == ServiceEnum.MathOperator.operator_or || mathParam.getOperator() == ServiceEnum.MathOperator.operator_xor || mathParam.getOperator() == ServiceEnum.MathOperator.operator_not) {
            while (i < 9) {
                strArr[i] = " ";
                i++;
            }
        } else {
            while (i < 9) {
                strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.NANO).convert(((4 - i) * mathParam.getScale()) - mathParam.getOffset(), mathParam.getUnitIndex());
                i++;
            }
        }
        return strArr;
    }

    public static String[] getEyeXRulers(EyeParam eyeParam) {
        String[] strArr = new String[11];
        if (eyeParam == null || eyeParam.getUiTime().getValue().longValue() == 0) {
            return strArr;
        }
        for (int i = 0; i < 11; i++) {
            strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(i * (eyeParam.getUiTime().getValue().longValue() / 10), ServiceEnum.Unit.Unit_s);
        }
        return strArr;
    }

    public static String[] getEyeYRulers(VerticalParam verticalParam) {
        String[] strArr = new String[9];
        if (verticalParam == null) {
            return strArr;
        }
        for (int i = 0; i < 9; i++) {
            strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.NANO).convert(((4 - i) * verticalParam.getScale()) - verticalParam.getOffset(), verticalParam.getUnit());
        }
        return strArr;
    }

    public static String[] getJitterTrackXRulers(HorizontalParam horizontalParam) {
        String[] strArr = new String[11];
        if (horizontalParam == null) {
            return strArr;
        }
        for (int i = 0; i < 11; i++) {
            strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(((i - 5) * horizontalParam.getMainScale()) + horizontalParam.getMainOffset(), ServiceEnum.Unit.Unit_s);
        }
        return strArr;
    }

    public static String[] getJitterTrackYRulers() {
        String[] strArr = new String[9];
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(52, MessageID.MSG_JITTER_MAX_TREND);
        long UI_QueryInt642 = (UI_QueryInt64 - API.getInstance().UI_QueryInt64(52, MessageID.MSG_JITTER_MIN_TREND)) / 8;
        for (int i = 0; i < 9; i++) {
            strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(UI_QueryInt64 - (i * UI_QueryInt642), ServiceEnum.Unit.Unit_s);
        }
        return strArr;
    }

    public static String[] getJitterSpectrumXRulers() {
        String[] strArr = new String[11];
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(52, MessageID.MSG_JITTER_CR_DATEFREQ) / 2;
        for (int i = 0; i < 11; i++) {
            strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.NONE).convert(i * (UI_QueryInt64 / 10), ServiceEnum.Unit.Unit_hz);
        }
        return strArr;
    }

    public static String[] getJitterSpectrumYRulers() {
        String[] strArr = new String[9];
        for (int i = 0; i < 9; i++) {
            strArr[i] = " ";
        }
        return strArr;
    }

    public static String[] getJitterHistogramXRulers() {
        String[] strArr = new String[11];
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(52, MessageID.MSG_JITTER_MAX_HIST_HOR);
        long UI_QueryInt642 = API.getInstance().UI_QueryInt64(52, MessageID.MSG_JITTER_MIN_HIST_HOR);
        for (int i = 0; i < 11; i++) {
            UnitFormat newBuilder = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO);
            strArr[i] = newBuilder.convert((i * ((UI_QueryInt64 - UI_QueryInt642) / 10)) + UI_QueryInt642, ServiceEnum.Unit.Unit_s);
        }
        return strArr;
    }

    public static String[] getJitterHistogramYRulers() {
        String[] strArr = new String[9];
        long UI_QueryInt64 = API.getInstance().UI_QueryInt64(52, MessageID.MSG_JITTER_MAX_HIST_VERT);
        for (int i = 0; i < 9; i++) {
            String convert = UnitFormat.newBuilder("0.##", UnitFormat.SI.NONE).convert(UI_QueryInt64 - (i * (UI_QueryInt64 / 10)), ServiceEnum.Unit.Unit_Hits);
            strArr[i] = convert + "hits";
        }
        return strArr;
    }

    public static String[] getJitterBathtubCurveXRulers() {
        return new String[]{"-0.5UI", "-0.4UI", "-0.3UI", "-0.2UI", "-0.1UI", "0.0", "0.1UI", "0.2UI", "0.3UI", "0.4UI", "0.5UI"};
    }

    public static String[] getJitterBathtubCurveYRulers() {
        return new String[]{" ", " ", " ", " ", "1e-12", " ", " ", " ", "1e-18"};
    }

    public static String[] getMeasHistogramXRulers() {
        String[] strArr = new String[11];
        double UI_QueryDouble = API.getInstance().UI_QueryDouble(34, MessageID.MSG_HISTO_MEAS_HOR_MAXVALUE);
        double UI_QueryDouble2 = API.getInstance().UI_QueryDouble(34, MessageID.MSG_HISTO_MEAS_HOR_MINVALUE);
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(34, MessageID.MSG_HISTO_MEAS_HOR_UNIT);
        ServiceEnum.Unit unit = ServiceEnum.Unit.Unit_none;
        ServiceEnum.Unit[] values = ServiceEnum.Unit.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            ServiceEnum.Unit unit2 = values[i];
            if (unit2.value1 == UI_QueryInt32) {
                unit = unit2;
                break;
            }
            i++;
        }
        for (int i2 = 0; i2 < 11; i2++) {
            strArr[i2] = UnitFormat.newBuilder("0.##", UnitFormat.SI.NONE).convert((i2 * ((UI_QueryDouble - UI_QueryDouble2) / 10.0d)) + UI_QueryDouble2, unit);
        }
        return strArr;
    }

    public static String[] getMeasHistogramYRulers() {
        String[] strArr = new String[9];
        long UI_QueryInt32 = API.getInstance().UI_QueryInt32(34, MessageID.MSG_HISTO_MEAS_VERT_MAXVALUE);
        float f = (((float) UI_QueryInt32) * 1.0f) / 7;
        float f2 = f != 0.0f ? f : 1.0f;
        for (int i = 1; i < 9; i++) {
            Math.round((float) (UI_QueryInt32 / 8));
            strArr[i] = UnitFormat.newBuilder("0.##", UnitFormat.SI.NONE).convert(((9 - i) - 1) * f2, ServiceEnum.Unit.Unit_Hits) + "hits";
        }
        return strArr;
    }

    public static void centerHorizontally(ConstraintLayout constraintLayout, int i, ConstraintSet constraintSet) {
        if (i < 0) {
            return;
        }
        constraintSet.clone(constraintLayout);
        constraintSet.clear(i, 6);
        constraintSet.clear(i, 7);
        constraintSet.centerHorizontally(i, 0);
        constraintSet.applyTo(constraintLayout);
    }

    public static void centerVertically(ConstraintLayout constraintLayout, int i, ConstraintSet constraintSet) {
        if (i < 0) {
            return;
        }
        constraintSet.clone(constraintLayout);
        constraintSet.clear(i, 3);
        constraintSet.clear(i, 4);
        constraintSet.centerVertically(i, 0);
        constraintSet.applyTo(constraintLayout);
    }

    public static void left(ConstraintLayout constraintLayout, int i, ConstraintSet constraintSet) {
        if (i < 0) {
            return;
        }
        constraintSet.clone(constraintLayout);
        constraintSet.clear(i, 7);
        constraintSet.connect(i, 6, 0, 6);
        constraintSet.connect(i, 3, 0, 3);
        constraintSet.applyTo(constraintLayout);
    }

    public static void right(ConstraintLayout constraintLayout, int i, ConstraintSet constraintSet) {
        if (i < 0) {
            return;
        }
        constraintSet.clone(constraintLayout);
        constraintSet.clear(i, 6);
        constraintSet.connect(i, 7, 0, 7);
        constraintSet.connect(i, 3, 0, 3);
        constraintSet.applyTo(constraintLayout);
    }

    public static void applyToTopAndLeft(ConstraintSet constraintSet, ConstraintLayout constraintLayout, View view) {
        if (constraintSet == null || constraintLayout == null || view == null) {
            return;
        }
        constraintSet.clone(constraintLayout);
        constraintSet.connect(view.getId(), 6, 0, 6);
        constraintSet.connect(view.getId(), 3, 0, 3);
        constraintSet.applyTo(constraintLayout);
    }

    public static float getValuePercent(VerticalParam verticalParam, long j) {
        if (verticalParam == null) {
            return -1.0f;
        }
        verticalParam.readRealScale();
        long realScale = ((verticalParam.getRealScale() * 8) / 2) - verticalParam.getOffset();
        return ((float) (realScale - j)) / ((float) (realScale - (((verticalParam.getRealScale() * (-8)) / 2) - verticalParam.getOffset())));
    }

    public static float getValuePercent(HorizontalParam horizontalParam, long j, boolean z) {
        long mainScale;
        long mainScale2;
        long mainOffset;
        if (horizontalParam == null) {
            return -1.0f;
        }
        if (z) {
            mainScale = ((horizontalParam.getZoomScale() * (-10)) / 2) + horizontalParam.getZoomOffset();
            mainScale2 = (horizontalParam.getZoomScale() * 10) / 2;
            mainOffset = horizontalParam.getZoomOffset();
        } else {
            mainScale = ((horizontalParam.getMainScale() * (-10)) / 2) + horizontalParam.getMainOffset();
            mainScale2 = (horizontalParam.getMainScale() * 10) / 2;
            mainOffset = horizontalParam.getMainOffset();
        }
        return ((float) (mainScale - j)) / ((float) (mainScale - (mainScale2 + mainOffset)));
    }

    public static float getValuePercent(MathParam mathParam, long j) {
        long logicScale;
        long logicScale2;
        long logicOffset;
        if (mathParam == null) {
            return -1.0f;
        }
        if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_fft) {
            logicScale = ((mathParam.getFftScale() * 8) / 2) - mathParam.getFftOffset();
            logicScale2 = (mathParam.getFftScale() * (-8)) / 2;
            logicOffset = mathParam.getFftOffset();
        } else if (mathParam.getOperator() == ServiceEnum.MathOperator.operator_and || mathParam.getOperator() == ServiceEnum.MathOperator.operator_or || mathParam.getOperator() == ServiceEnum.MathOperator.operator_not || mathParam.getOperator() == ServiceEnum.MathOperator.operator_xor) {
            logicScale = ((mathParam.getLogicScale() * 8) / 2) - mathParam.getLogicOffset();
            logicScale2 = (mathParam.getLogicScale() * (-8)) / 2;
            logicOffset = mathParam.getLogicOffset();
        } else {
            logicScale = ((mathParam.getScale() * 8) / 2) - mathParam.getOffset();
            logicScale2 = (mathParam.getScale() * (-8)) / 2;
            logicOffset = mathParam.getOffset();
        }
        return ((float) (logicScale - j)) / ((float) (logicScale - (logicScale2 - logicOffset)));
    }

    public static float getValuePercent(RefParam.Param param, long j) {
        if (param == null) {
            return -1.0f;
        }
        long verScale = ((param.getVerScale() * 8) / 2) - param.getVerOffset();
        return ((float) (verScale - j)) / ((float) (verScale - (((param.getVerScale() * (-8)) / 2) - param.getVerOffset())));
    }

    public static WindowHolder getWindowXy(int i) {
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_XY);
        if (list == null || list.isEmpty() || i < 0 || i >= list.size()) {
            return null;
        }
        return list.get(i);
    }

    public static int getWindowXyIndex(ServiceEnum.Chan chan, ServiceEnum.Chan chan2) {
        WindowParam windowParam;
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_XY);
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                WindowHolder windowHolder = list.get(i);
                if (windowHolder != null && (windowParam = windowHolder.getWindowParam()) != null && windowParam.getSource1() == chan && windowParam.getSource2() == chan2) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void makeVibration(UtilityViewModel utilityViewModel) {
        UtilityParam value;
        if (utilityViewModel == null || (value = utilityViewModel.getLiveData().getValue()) == null || !value.getVibration()) {
            return;
        }
        value.makeVibration();
    }

    public static void addOutsideEnableClickRects(final int[] iArr, final View view, final Class<? extends BasePopupView> cls) {
        if (view == null) {
            return;
        }
        view.post(new Runnable() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$8ZjRdIqcRN_jcziJipFMJ6Q-FYs
            @Override // java.lang.Runnable
            public final void run() {
                ViewUtil.lambda$addOutsideEnableClickRects$8(cls, view, iArr);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$addOutsideEnableClickRects$8(Class cls, View view, int[] iArr) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(cls);
        if (basePopupView == null) {
            return;
        }
        view.getLocationOnScreen(iArr);
        basePopupView.getOutsideEnableClickRects().add(new Rect(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight()));
    }

    public static void removeOutsideEnableClickRects(Class<? extends BasePopupView> cls) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(cls);
        if (basePopupView != null) {
            basePopupView.getOutsideEnableClickRects().clear();
        }
    }

    public static void setListOutsideEnableClickRects(RecyclerView recyclerView, List<MappingObject> list, int[] iArr) {
        MappingObject mappingObject;
        Class<? extends BasePopupView> popupViewClass;
        if (recyclerView == null || list == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            for (int i = 0; i < list.size() && (mappingObject = list.get(i)) != null && (popupViewClass = getPopupViewClass(ServiceEnum.getFunctionFromValue1(mappingObject.getValue()))) != null; i++) {
                if (i >= findFirstVisibleItemPosition && i <= findLastVisibleItemPosition) {
                    RecyclerView.ViewHolder findViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(i);
                    if (findViewHolderForAdapterPosition instanceof BaseViewHolder) {
                        addOutsideEnableClickRects(iArr, ((BaseViewHolder) findViewHolderForAdapterPosition).getBinding().getRoot(), popupViewClass);
                    }
                } else {
                    removeOutsideEnableClickRects(popupViewClass);
                }
            }
        }
    }

    public static Class<? extends BasePopupView> getPopupViewClass(ServiceEnum.Function function) {
        if (function == null) {
            return null;
        }
        switch (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()]) {
            case 1:
                return MeasurePopupView.class;
            case 2:
                return MultiWindowPopupView.class;
            case 3:
                return MathPopupView.class;
            case 4:
                return RefPopupView.class;
            case 5:
                return RtsaPopupView.class;
            case 6:
                return EyePopupView.class;
            case 7:
                return JitterPopupView.class;
            case 8:
                return DecodeNewPopupView.class;
            case 9:
                return BusAnalysePopupView.class;
            case 10:
                return MaskPopupView.class;
            case 11:
                return SearchPopupView.class;
            case 12:
                return RecordPopupView.class;
            case 13:
                return DisplayPopupView.class;
            case 14:
                return StoragePopupView.class;
            case 15:
                return UtilityPopupView.class;
            case 16:
                return DefaultPopupView.class;
            case 17:
                return TriggerPopupView.class;
            case 18:
                return HorizontalPopupView.class;
            case 19:
                return WaveIntensityPopupView.class;
            default:
                return null;
        }
    }

    public static void doScreenShot() {
        MutableLiveData<StorageSaveParam> saveLiveData;
        StorageSaveParam value;
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel == null || (saveLiveData = storageViewModel.getSaveLiveData()) == null || (value = saveLiveData.getValue()) == null) {
            return;
        }
        value.screenShotSetting();
        ImageUtil.save(value);
    }

    public static void doMaskScreenShot() {
        MutableLiveData<StorageSaveParam> saveLiveData;
        StorageSaveParam value;
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel == null || (saveLiveData = storageViewModel.getSaveLiveData()) == null || (value = saveLiveData.getValue()) == null) {
            return;
        }
        value.screenShotSetting();
        ImageUtil.masksave(value);
    }

    public static void doSaveWave() {
        MutableLiveData<StorageSaveParam> saveLiveData;
        StorageSaveParam value;
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel == null || (saveLiveData = storageViewModel.getSaveLiveData()) == null || (value = saveLiveData.getValue()) == null) {
            return;
        }
        value.saveWaveSetting();
        value.doSave();
    }

    public static void doSaveSetup() {
        MutableLiveData<StorageSaveParam> saveLiveData;
        StorageSaveParam value;
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel == null || (saveLiveData = storageViewModel.getSaveLiveData()) == null || (value = saveLiveData.getValue()) == null) {
            return;
        }
        value.saveSetupSetting();
        value.doSave();
    }

    public static void doSaveRef() {
        MutableLiveData<StorageSaveParam> saveLiveData;
        StorageSaveParam value;
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel == null || (saveLiveData = storageViewModel.getSaveLiveData()) == null || (value = saveLiveData.getValue()) == null) {
            return;
        }
        value.saveRefSetting();
        value.doSave();
    }

    public static void doSaveMask() {
        MutableLiveData<StorageSaveParam> saveLiveData;
        StorageSaveParam value;
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel == null || (saveLiveData = storageViewModel.getSaveLiveData()) == null || (value = saveLiveData.getValue()) == null) {
            return;
        }
        value.saveMaskSetting();
        value.doSave();
    }

    public static void quickAction() {
        UtilityParam value;
        MutableLiveData<StorageSaveParam> saveLiveData;
        final StorageSaveParam value2;
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel == null || (value = utilityViewModel.getLiveData().getValue()) == null) {
            return;
        }
        switch (AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[value.getQuickOper().ordinal()]) {
            case 1:
                doScreenShot();
                return;
            case 2:
                doSaveWave();
                return;
            case 3:
                doSaveSetup();
                return;
            case 4:
            case 5:
            case 6:
            case 7:
                API.getInstance().UI_PostBool(27, MessageID.MSG_APP_QUICK, true);
                return;
            case 8:
                if (API.getInstance().UI_QueryInt32(10, MessageID.MSG_ACQ_MODE) != ServiceEnum.AcquireMode.Acquire_Ultra.value1) {
                    API.getInstance().UI_PostBool(27, MessageID.MSG_APP_QUICK, true);
                    if (PopupViewManager.getInstance().isShowing(RecordPopupView.class)) {
                        return;
                    }
                    PopupViewManager.getInstance().toggle(RecordPopupView.class);
                    return;
                }
                ToastUtils.showShort(ActivityUtils.getTopActivity().getResources().getString(R.string.err_action_disabled));
                return;
            case 9:
                StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                if (storageViewModel == null || (saveLiveData = storageViewModel.getSaveLiveData()) == null || (value2 = saveLiveData.getValue()) == null) {
                    return;
                }
                int saveGroup = value.getSaveGroup();
                if (saveGroup == 1) {
                    doScreenShot();
                    return;
                } else if (saveGroup == 2) {
                    doSaveWave();
                    return;
                } else if (saveGroup == 3) {
                    new Thread() { // from class: com.rigol.scope.utilities.ViewUtil.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            super.run();
                            try {
                                ViewUtil.doScreenShot();
                                sleep(300L);
                                ViewUtil.doSaveWave();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.run();
                    return;
                } else if (saveGroup == 4) {
                    doSaveSetup();
                    return;
                } else if (saveGroup == 5) {
                    new Thread() { // from class: com.rigol.scope.utilities.ViewUtil.2
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            super.run();
                            try {
                                ViewUtil.doScreenShot();
                                sleep(300L);
                                ViewUtil.doSaveSetup();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.run();
                    return;
                } else if (saveGroup == 6) {
                    doSaveWave();
                    value2.setGroup(4);
                    return;
                } else if (saveGroup == 7) {
                    new Thread() { // from class: com.rigol.scope.utilities.ViewUtil.3
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            super.run();
                            try {
                                ViewUtil.doScreenShot();
                                sleep(300L);
                                ViewUtil.doSaveWave();
                                StorageSaveParam.this.setGroup(4);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }.run();
                    return;
                } else {
                    return;
                }
            default:
                return;
        }
    }

    public static String getUpdateContent(int i, Firmware firmware) {
        if (firmware == null) {
            return null;
        }
        if (i != ServiceEnum.SystemLanguage.language_chinese.value1) {
            return firmware.getComment_en();
        }
        return firmware.getComment_cn();
    }

    public static String getErrorMessage(int i, String str) {
        return i + ": " + str;
    }

    public static List<MappingObject> getDepthSpinnerList() {
        HorizontalParam value;
        ArrayList arrayList = new ArrayList();
        final int UI_QueryInt32 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_PRODUCT_SERIES);
        List<MappingObject> filter = KtUtilKt.filter(getList((int) R.array.msg_acq_memdepth), new Function1() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$g_tUFrZxLxSWyyt2rUjBaWhzHr4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ViewUtil.lambda$getDepthSpinnerList$9(UI_QueryInt32, (MappingObject) obj);
            }
        });
        HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        if (horizontalViewModel == null || (value = horizontalViewModel.getLiveData().getValue()) == null) {
            return filter;
        }
        ServiceEnum.HoriTimeMode readTimeMode = value.readTimeMode();
        value.readShowDepth();
        int UI_QueryInt322 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_PRODUCT_DOMAIN);
        int UI_QueryInt323 = API.getInstance().UI_QueryInt32(10, MessageID.MSG_ACQ_INTER_MODE);
        boolean UI_QueryBool = API.getInstance().UI_QueryBool(60, MessageID.MSG_LA_ENABLE);
        API.getInstance().UI_QueryInt64(10, MessageID.MSG_ACQ_MEMDEPTH_VALUE);
        String UI_QueryStr = API.getInstance().UI_QueryStr(11, MessageID.MSG_MISC_MODEL);
        boolean z = (UI_QueryStr.equals("DHO824") || UI_QueryStr.equals("HDO824")) ? true : true;
        int i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
        if (UI_QueryInt322 == ServiceEnum.ProductDomain.DOMAIN_HDO.value1) {
            if (z) {
                if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_1000.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_100M.value1;
                    if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                    } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
                    }
                } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_2000.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_200M.value1;
                    if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_100M.value1;
                    } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                    }
                } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_4000.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_500M.value1;
                    if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_250M.value1;
                    } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_125M.value1;
                    }
                } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_800.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                    if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
                    } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_10M.value1;
                    }
                } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_900.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                    if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
                    } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                        i = ServiceEnum.AcquireDepth.Acquire_Depth_10M.value1;
                    }
                }
            } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_1000.value1) {
                i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
                } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_10M.value1;
                }
            } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_2000.value1) {
                i = ServiceEnum.AcquireDepth.Acquire_Depth_100M.value1;
                if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
                }
            } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_4000.value1) {
                i = ServiceEnum.AcquireDepth.Acquire_Depth_250M.value1;
                if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_125M.value1;
                } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                }
            } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_800.value1) {
                i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
                if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_10M.value1;
                } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_5M.value1;
                }
            } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_900.value1) {
                i = ServiceEnum.AcquireDepth.Acquire_Depth_50M.value1;
                if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
                } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_10M.value1;
                }
            }
        } else if (UI_QueryInt322 == ServiceEnum.ProductDomain.DOMAIN_DSO.value1) {
            i = ServiceEnum.AcquireDepth.Acquire_Depth_1G.value1;
            if (z && UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_70000.value1) {
                i = ServiceEnum.AcquireDepth.Acquire_Depth_2G.value1;
            }
        } else if (UI_QueryInt322 == ServiceEnum.ProductDomain.DOMAIN_MSO.value1 && UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_8000.value1) {
            i = ServiceEnum.AcquireDepth.Acquire_Depth_500M.value1;
        }
        if (UI_QueryInt322 == ServiceEnum.ProductDomain.DOMAIN_HDO.value1 && UI_QueryBool) {
            if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_800.value1) {
                i = ServiceEnum.AcquireDepth.Acquire_Depth_10M.value1;
                if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_1M.value1;
                } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_1M.value1;
                }
            } else if (UI_QueryInt32 == ServiceEnum.ProductSeries.SERIES_900.value1) {
                i = ServiceEnum.AcquireDepth.Acquire_Depth_25M.value1;
                if (UI_QueryInt323 == ServiceEnum.SampleMode.DUAL_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_10M.value1;
                } else if (UI_QueryInt323 == ServiceEnum.SampleMode.QUAD_SAMPLE_MODE.value1) {
                    i = ServiceEnum.AcquireDepth.Acquire_Depth_1M.value1;
                }
            }
        }
        for (MappingObject mappingObject : filter) {
            if (readTimeMode == ServiceEnum.HoriTimeMode.Horizontal_ROLL || readTimeMode == ServiceEnum.HoriTimeMode.Horizontal_SCAN) {
                if (mappingObject.getValue() <= i && mappingObject.getValue() >= ServiceEnum.AcquireDepth.Acquire_Depth_1M.value1 && mappingObject.getValue() <= ServiceEnum.AcquireDepth.Acquire_Depth_100M.value1) {
                    arrayList.add(mappingObject);
                }
            } else if (value.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_HighResolution) {
                if (mappingObject.getValue() <= i && mappingObject.getValue() > ServiceEnum.AcquireDepth.Acquire_Depth_Auto.value1) {
                    arrayList.add(mappingObject);
                }
            } else if (value.getAcquireMode() == ServiceEnum.AcquireMode.Acquire_Average) {
                if (UI_QueryInt323 == ServiceEnum.SampleMode.SINGLE_SAMPLE_MODE.value1) {
                    if (mappingObject.getValue() > ServiceEnum.AcquireDepth.Acquire_Depth_Auto.value1 && mappingObject.getValue() <= i && mappingObject.getValue() <= ServiceEnum.AcquireDepth.Acquire_Depth_10M.value1) {
                        arrayList.add(mappingObject);
                    }
                } else if (mappingObject.getValue() > ServiceEnum.AcquireDepth.Acquire_Depth_Auto.value1 && mappingObject.getValue() <= i && mappingObject.getValue() <= ServiceEnum.AcquireDepth.Acquire_Depth_1M.value1) {
                    arrayList.add(mappingObject);
                }
            } else if (mappingObject.getValue() <= i) {
                arrayList.add(mappingObject);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ Boolean lambda$getDepthSpinnerList$9(int i, MappingObject mappingObject) {
        if (i == ServiceEnum.ProductSeries.SERIES_900.value1) {
            return Boolean.valueOf(mappingObject.getValue() != ServiceEnum.AcquireDepth.Acquire_Depth_5M.value1);
        }
        return true;
    }

    public static void switchToast(int i, boolean z) {
        String string = ContextUtil.getString(i);
        if (z) {
            String string2 = ContextUtil.getString(R.string.carrier_9);
            ToastUtils.showShort(string + ": " + string2);
            return;
        }
        String string3 = ContextUtil.getString(R.string.carrier_8);
        ToastUtils.showShort(string + ": " + string3);
    }

    public static boolean showTriggerTagAB(TriggerParam triggerParam) {
        if (triggerParam == null) {
            return false;
        }
        ServiceEnum.TriggerMode triggerMode = triggerParam.getTriggerMode();
        return triggerMode == ServiceEnum.TriggerMode.Trigger_Over || triggerMode == ServiceEnum.TriggerMode.Trigger_Slope || triggerMode == ServiceEnum.TriggerMode.Trigger_Runt || triggerMode == ServiceEnum.TriggerMode.Trigger_1553;
    }

    public static boolean showTriggerTag(TriggerParam triggerParam) {
        if (triggerParam == null) {
            return true;
        }
        if (triggerParam.getChan().value1 >= ServiceEnum.Chan.d0.value1) {
            return false;
        }
        if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Edge) {
            return (triggerParam.getChan() == ServiceEnum.Chan.acline || triggerParam.getChan() == ServiceEnum.Chan.ext || triggerParam.getChan() == ServiceEnum.Chan.d0 || triggerParam.getChan() == ServiceEnum.Chan.d1 || triggerParam.getChan() == ServiceEnum.Chan.d2 || triggerParam.getChan() == ServiceEnum.Chan.d3 || triggerParam.getChan() == ServiceEnum.Chan.d4 || triggerParam.getChan() == ServiceEnum.Chan.d5 || triggerParam.getChan() == ServiceEnum.Chan.d6 || triggerParam.getChan() == ServiceEnum.Chan.d7 || triggerParam.getChan() == ServiceEnum.Chan.d8 || triggerParam.getChan() == ServiceEnum.Chan.d9 || triggerParam.getChan() == ServiceEnum.Chan.d10 || triggerParam.getChan() == ServiceEnum.Chan.d11 || triggerParam.getChan() == ServiceEnum.Chan.d12 || triggerParam.getChan() == ServiceEnum.Chan.d13 || triggerParam.getChan() == ServiceEnum.Chan.d14 || triggerParam.getChan() == ServiceEnum.Chan.d15 || triggerParam.getCoupling() == ServiceEnum.Coupling.AC || triggerParam.getCoupling() == ServiceEnum.Coupling.LF) ? false : true;
        }
        return true;
    }

    public static boolean hideTriggerTag(TriggerParam triggerParam) {
        return triggerParam == null || triggerParam.getChan().value1 >= ServiceEnum.Chan.d0.value1 || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553 || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Over || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Runt || triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Slope;
    }

    public static String keepMaxNumberOfDigits(String str, int i) {
        return (TextUtils.isEmpty(str) || i <= 0 || str.length() < i) ? str : str.substring(0, i);
    }

    public static void setTouchDelegate(View view, ViewGroup viewGroup, int i) {
        setTouchDelegateDelay(view, viewGroup, i, 0);
    }

    public static void setTouchDelegateDelay(final View view, final ViewGroup viewGroup, final int i, int i2) {
        if (view == null || viewGroup == null) {
            return;
        }
        viewGroup.postDelayed(new Runnable() { // from class: com.rigol.scope.utilities.-$$Lambda$ViewUtil$dFMHMdEleSJJGvKQynvadU_smUU
            @Override // java.lang.Runnable
            public final void run() {
                ViewUtil.lambda$setTouchDelegateDelay$10(view, i, viewGroup);
            }
        }, i2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$setTouchDelegateDelay$10(View view, int i, ViewGroup viewGroup) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.left -= i;
        rect.top -= i;
        rect.right += i;
        rect.bottom += i;
        viewGroup.setTouchDelegate(new TouchDelegate(rect, view));
    }

    public static String subNumber(String str, int i) {
        if (!TextUtils.isEmpty(str) && str.length() > i) {
            boolean startsWith = str.startsWith("-");
            StringBuilder sb = new StringBuilder();
            sb.append("\\d{1,3}.\\d{2,");
            sb.append(i - 1);
            sb.append("}");
            Matcher matcher = Pattern.compile(sb.toString()).matcher(str);
            if (matcher.find()) {
                String substring = str.substring(matcher.start(), matcher.end());
                if (substring.length() > i) {
                    Matcher matcher2 = Pattern.compile("[a-zA-Z]+").matcher(str);
                    String substring2 = substring.substring(0, i);
                    if (matcher2.find()) {
                        substring2 = substring2 + str.substring(matcher2.start(), matcher2.end());
                    }
                    if (startsWith) {
                        return "-" + substring2;
                    }
                    return substring2;
                }
            }
            return str;
        }
        return str;
    }

    public static String[][] getDecodeInfo(String[][][] strArr, ServiceEnum.DecodeBusType decodeBusType, ServiceEnum.WaveView waveView, Object... objArr) {
        String[] strArr2;
        if (strArr != null && waveView != null && decodeBusType != null) {
            for (String[][] strArr3 : strArr) {
                if (strArr3 != null && strArr3.length >= 1 && (strArr2 = strArr3[0]) != null && strArr2.length >= 1) {
                    if (decodeBusType == ServiceEnum.DecodeBusType.Decode_RS232 || decodeBusType == ServiceEnum.DecodeBusType.Decode_SPI) {
                        if (strArr2.length >= 4 && objArr.length > 0 && (objArr[0] instanceof String) && !TextUtils.isEmpty((String) objArr[0]) && String.valueOf(waveView.value1).equals(strArr2[0]) && objArr[0].equals(strArr2[3])) {
                            return strArr3;
                        }
                    } else if (String.valueOf(waveView.value1).equals(strArr2[0])) {
                        return strArr3;
                    }
                }
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList<java.lang.String[]> getCsvInfo(java.lang.String r11, java.lang.Object... r12) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            if (r12 == 0) goto L1a
            int r2 = r12.length
            if (r2 <= 0) goto L1a
            r2 = r12[r1]
            boolean r2 = r2 instanceof java.lang.Integer
            if (r2 == 0) goto L1a
            r12 = r12[r1]
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            goto L1b
        L1a:
            r12 = -1
        L1b:
            r2 = 0
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L89
            r3.<init>(r11)     // Catch: java.lang.Throwable -> L86 java.lang.Exception -> L89
            org.apache.commons.csv.CSVFormat r4 = org.apache.commons.csv.CSVFormat.DEFAULT     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L84
            org.apache.commons.csv.CSVParser r4 = org.apache.commons.csv.CSVParser.parse(r3, r4)     // Catch: java.lang.Throwable -> L81 java.lang.Exception -> L84
            java.util.Iterator r5 = r4.iterator()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            r6 = r1
        L2c:
            boolean r7 = r5.hasNext()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            if (r7 == 0) goto L6e
            java.lang.Object r7 = r5.next()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            org.apache.commons.csv.CSVRecord r7 = (org.apache.commons.csv.CSVRecord) r7     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            if (r7 != 0) goto L3b
            goto L2c
        L3b:
            if (r12 < 0) goto L52
            if (r6 < r12) goto L52
            r3.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r11 = move-exception
            r11.printStackTrace()
        L47:
            if (r4 == 0) goto L51
            r4.close()     // Catch: java.io.IOException -> L4d
            goto L51
        L4d:
            r11 = move-exception
            r11.printStackTrace()
        L51:
            return r0
        L52:
            int r8 = r7.size()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            java.lang.String[] r8 = new java.lang.String[r8]     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            r9 = r1
        L59:
            int r10 = r7.size()     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            if (r9 >= r10) goto L68
            java.lang.String r10 = r7.get(r9)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            r8[r9] = r10     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            int r9 = r9 + 1
            goto L59
        L68:
            r0.add(r8)     // Catch: java.lang.Exception -> L8b java.lang.Throwable -> Laa
            int r6 = r6 + 1
            goto L2c
        L6e:
            r3.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r11 = move-exception
            r11.printStackTrace()
        L76:
            if (r4 == 0) goto L80
            r4.close()     // Catch: java.io.IOException -> L7c
            goto L80
        L7c:
            r11 = move-exception
            r11.printStackTrace()
        L80:
            return r0
        L81:
            r11 = move-exception
            r4 = r2
            goto Lab
        L84:
            r4 = r2
            goto L8b
        L86:
            r11 = move-exception
            r4 = r2
            goto Lac
        L89:
            r3 = r2
            r4 = r3
        L8b:
            java.lang.String r12 = "File not exist:%s"
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.Throwable -> Laa
            r0[r1] = r11     // Catch: java.lang.Throwable -> Laa
            timber.log.Timber.e(r12, r0)     // Catch: java.lang.Throwable -> Laa
            if (r3 == 0) goto L9f
            r3.close()     // Catch: java.io.IOException -> L9b
            goto L9f
        L9b:
            r11 = move-exception
            r11.printStackTrace()
        L9f:
            if (r4 == 0) goto La9
            r4.close()     // Catch: java.io.IOException -> La5
            goto La9
        La5:
            r11 = move-exception
            r11.printStackTrace()
        La9:
            return r2
        Laa:
            r11 = move-exception
        Lab:
            r2 = r3
        Lac:
            if (r2 == 0) goto Lb6
            r2.close()     // Catch: java.io.IOException -> Lb2
            goto Lb6
        Lb2:
            r12 = move-exception
            r12.printStackTrace()
        Lb6:
            if (r4 == 0) goto Lc0
            r4.close()     // Catch: java.io.IOException -> Lbc
            goto Lc0
        Lbc:
            r12 = move-exception
            r12.printStackTrace()
        Lc0:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.utilities.ViewUtil.getCsvInfo(java.lang.String, java.lang.Object[]):java.util.ArrayList");
    }

    public static WindowHolder getWindowHolderByServiceID(ServiceEnum.WindowType windowType, int i) {
        List<WindowHolder> list;
        if (windowType == null || i < 0 || (list = WindowHolderManager.getInstance().get(windowType)) == null) {
            return null;
        }
        for (WindowHolder windowHolder : list) {
            if (windowHolder != null && windowHolder.getWindowParam().getServiceID() == i) {
                return windowHolder;
            }
        }
        return null;
    }

    public static float getFitableTextSize(Paint paint, String str, int i, float f, float f2) {
        if (paint == null || TextUtils.isEmpty(str) || i <= 0) {
            return -1.0f;
        }
        float measureText = paint.measureText(str);
        float f3 = i;
        if (measureText > f3) {
            while (measureText > f3) {
                if (paint.getTextSize() < f) {
                    return f;
                }
                paint.setTextSize(paint.getTextSize() - 1.0f);
                measureText = paint.measureText(str);
            }
        } else if (measureText < f3) {
            while (measureText < f3) {
                if (paint.getTextSize() > f2) {
                    return f2;
                }
                paint.setTextSize(paint.getTextSize() + 1.0f);
                measureText = paint.measureText(str);
            }
            paint.setTextSize(paint.getTextSize() - 1.0f);
        }
        return paint.getTextSize() > f2 ? f2 : paint.getTextSize() < f ? f : paint.getTextSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.utilities.ViewUtil$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType;
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$tagNET_STATUS_EN;

        static {
            int[] iArr = new int[ServiceEnum.tagNET_STATUS_EN.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$tagNET_STATUS_EN = iArr;
            try {
                iArr[ServiceEnum.tagNET_STATUS_EN.NET_STATUS_UNLINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$tagNET_STATUS_EN[ServiceEnum.tagNET_STATUS_EN.NET_STATUS_IPCONFLICT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$tagNET_STATUS_EN[ServiceEnum.tagNET_STATUS_EN.NET_STATUS_INVALID_IP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$tagNET_STATUS_EN[ServiceEnum.tagNET_STATUS_EN.NET_STATUS_CONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$tagNET_STATUS_EN[ServiceEnum.tagNET_STATUS_EN.NET_STATUS_INIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[ServiceEnum.UtilityQuickOperationType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType = iArr2;
            try {
                iArr2[ServiceEnum.UtilityQuickOperationType.QUICK_SaveImage.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_SaveWave.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_SaveSetup.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_AllMeasure.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_StatReset.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_Print.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_Email.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_Record.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$UtilityQuickOperationType[ServiceEnum.UtilityQuickOperationType.QUICK_SelectSave.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            int[] iArr3 = new int[ServiceEnum.Function.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function = iArr3;
            try {
                iArr3[ServiceEnum.Function.FUN_MEASURE.ordinal()] = 1;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MULTI_WINDOW.ordinal()] = 2;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MATH.ordinal()] = 3;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_REF.ordinal()] = 4;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_FFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_EYE.ordinal()] = 6;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_JITTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DECODE.ordinal()] = 8;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_BUS_ANALYSE.ordinal()] = 9;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_MASK.ordinal()] = 10;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_SEARCH.ordinal()] = 11;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_RECORD.ordinal()] = 12;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DISPLAY.ordinal()] = 13;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_STORAGE.ordinal()] = 14;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_UTILITY.ordinal()] = 15;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_DEFAULT.ordinal()] = 16;
            } catch (NoSuchFieldError unused30) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_TRIGGER.ordinal()] = 17;
            } catch (NoSuchFieldError unused31) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_HORIZONTAL.ordinal()] = 18;
            } catch (NoSuchFieldError unused32) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_WAVE_INTENSITY.ordinal()] = 19;
            } catch (NoSuchFieldError unused33) {
            }
            int[] iArr4 = new int[ServiceEnum.OverEvent.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent = iArr4;
            try {
                iArr4[ServiceEnum.OverEvent.Trigger_over_exit.ordinal()] = 1;
            } catch (NoSuchFieldError unused34) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$OverEvent[ServiceEnum.OverEvent.Trigger_over_time.ordinal()] = 2;
            } catch (NoSuchFieldError unused35) {
            }
            int[] iArr5 = new int[ServiceEnum.TriggerPattern.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern = iArr5;
            try {
                iArr5[ServiceEnum.TriggerPattern.Trigger_pat_h.ordinal()] = 1;
            } catch (NoSuchFieldError unused36) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[ServiceEnum.TriggerPattern.Trigger_pat_l.ordinal()] = 2;
            } catch (NoSuchFieldError unused37) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[ServiceEnum.TriggerPattern.Trigger_pat_rise.ordinal()] = 3;
            } catch (NoSuchFieldError unused38) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPattern[ServiceEnum.TriggerPattern.Trigger_pat_fall.ordinal()] = 4;
            } catch (NoSuchFieldError unused39) {
            }
            int[] iArr6 = new int[ServiceEnum.TriggerPulsePolarity.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$TriggerPulsePolarity = iArr6;
            try {
                iArr6[ServiceEnum.TriggerPulsePolarity.Trigger_pulse_negative.ordinal()] = 1;
            } catch (NoSuchFieldError unused40) {
            }
            int[] iArr7 = new int[ServiceEnum.EdgeSlope.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope = iArr7;
            try {
                iArr7[ServiceEnum.EdgeSlope.Trigger_Edge_Falling.ordinal()] = 1;
            } catch (NoSuchFieldError unused41) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$EdgeSlope[ServiceEnum.EdgeSlope.Trigger_Edge_Any.ordinal()] = 2;
            } catch (NoSuchFieldError unused42) {
            }
            int[] iArr8 = new int[ServiceEnum.Chan.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan = iArr8;
            try {
                iArr8[ServiceEnum.Chan.chan1.ordinal()] = 1;
            } catch (NoSuchFieldError unused43) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan[ServiceEnum.Chan.chan2.ordinal()] = 2;
            } catch (NoSuchFieldError unused44) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan[ServiceEnum.Chan.chan3.ordinal()] = 3;
            } catch (NoSuchFieldError unused45) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan[ServiceEnum.Chan.chan4.ordinal()] = 4;
            } catch (NoSuchFieldError unused46) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan[ServiceEnum.Chan.m1.ordinal()] = 5;
            } catch (NoSuchFieldError unused47) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan[ServiceEnum.Chan.m2.ordinal()] = 6;
            } catch (NoSuchFieldError unused48) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan[ServiceEnum.Chan.m3.ordinal()] = 7;
            } catch (NoSuchFieldError unused49) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Chan[ServiceEnum.Chan.m4.ordinal()] = 8;
            } catch (NoSuchFieldError unused50) {
            }
        }
    }

    public static int getNetworkStatusColor(ServiceEnum.tagNET_STATUS_EN tagnet_status_en) {
        int i = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$tagNET_STATUS_EN[tagnet_status_en.ordinal()];
        if (i == 1 || i == 2 || i == 3) {
            return ContextUtil.getColor(R.color.design_default_color_error);
        }
        if (i == 4 || i == 5) {
            return ContextUtil.getColor(R.color.lime);
        }
        return ContextUtil.getColor(R.color.white);
    }

    public static ServiceEnum.tagNET_STATUS_EN getNetworkStatus(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return ServiceEnum.tagNET_STATUS_EN.NET_STATUS_CONNECTED;
            }
            if (i != 3) {
                return ServiceEnum.tagNET_STATUS_EN.NET_STATUS_INIT;
            }
        }
        return ServiceEnum.tagNET_STATUS_EN.NET_STATUS_UNLINK;
    }

    public static void getNetworkInfo(Context context, IOParam iOParam) {
        String ipAddress = EthernetUtil.getIpAddress(context);
        if (TextUtils.isEmpty(ipAddress)) {
            ipAddress = NetworkUtils.getIPAddress(true);
        }
        iOParam.saveIPAddress(ipAddress);
        String subMask = EthernetUtil.getSubMask(context);
        if (TextUtils.isEmpty(subMask)) {
            subMask = NetworkUtils.getNetMaskByWifi();
        }
        iOParam.saveMask(subMask);
        String defaultGateway = EthernetUtil.getDefaultGateway(context);
        if (TextUtils.isEmpty(defaultGateway)) {
            defaultGateway = NetworkUtils.getGatewayByWifi();
        }
        iOParam.saveGateWay(defaultGateway);
        iOParam.saveDNS(EthernetUtil.getDns(context));
        iOParam.saveStatus(getNetworkStatus(EthernetUtil.getEthernetConnectState(context)));
        iOParam.setVisaAddress(EthernetUtil.getVisaAddress(context));
        String upperCase = DeviceUtils.getMacAddress().toUpperCase(Locale.ROOT);
        if (TextUtils.isEmpty(upperCase)) {
            String readFile2String = FileIOUtils.readFile2String("/sys/class/net/eth0/address");
            if (TextUtils.isEmpty(readFile2String)) {
                return;
            }
            iOParam.saveMacAddress(readFile2String);
            return;
        }
        iOParam.saveMacAddress(upperCase);
    }

    public static boolean isCalibrationStarted() {
        CalibrationParam value;
        CalibrationViewModel calibrationViewModel = (CalibrationViewModel) ContextUtil.getAppViewModel(CalibrationViewModel.class);
        if (calibrationViewModel == null || (value = calibrationViewModel.getLiveData().getValue()) == null) {
            return false;
        }
        return value.isStarted();
    }

    public static boolean isRecording() {
        WaveRecordParam value;
        ServiceEnum.RecordState readState;
        WaveRecordViewModel waveRecordViewModel = (WaveRecordViewModel) ContextUtil.getAppViewModel(WaveRecordViewModel.class);
        if (waveRecordViewModel == null || (value = waveRecordViewModel.getLiveData().getValue()) == null || (readState = value.readState()) == null) {
            return false;
        }
        return readState == ServiceEnum.RecordState.Play_ing || readState == ServiceEnum.RecordState.Record_ing;
    }

    public static boolean isPassFailRunning() {
        MaskViewModel maskViewModel = (MaskViewModel) ContextUtil.getAppViewModel(MaskViewModel.class);
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (maskViewModel == null || utilityViewModel == null) {
            return false;
        }
        MaskParam value = maskViewModel.getLiveData().getValue();
        UtilityParam value2 = utilityViewModel.getLiveData().getValue();
        if (value == null || value2 == null || !value.isEnable() || !value.isOperate()) {
            return false;
        }
        return (value2.getQuickOper() == ServiceEnum.UtilityQuickOperationType.QUICK_StatReset && value2.getStatReset() == ServiceEnum.UtilityQuickStatReset.PassFail) ? false : true;
    }

    public static boolean isImageFile(String str) {
        String guessContentTypeFromName = URLConnection.guessContentTypeFromName(str.replaceAll(UnitFormat.PATTERN_SIGN, ""));
        return guessContentTypeFromName != null && guessContentTypeFromName.startsWith("image");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized void identification(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.utilities.ViewUtil.identification(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, boolean):void");
    }

    public static String convert(String str, int i, String str2, DecimalFormat decimalFormat) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (i > 0 && str.length() < i + str2.length()) {
                return str;
            }
            try {
                BigDecimal bigDecimal = new BigDecimal(str.substring(0, str.length() - str2.length()));
                return decimalFormat.format(bigDecimal) + str2;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static boolean checkIp(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        if (str.compareTo("0.0.0.0") == 0) {
            return true;
        }
        return str.matches("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
    }

    public static List<MappingObject> filterChan(List<MappingObject> list) {
        UtilityParam utilityParam;
        ArrayList arrayList = new ArrayList();
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData();
            utilityParam = utilityViewModel.getLiveData().getValue();
        } else {
            utilityParam = null;
        }
        int i = 0;
        if (isDoubleChan()) {
            while (i < list.size()) {
                if (list.get(i).getStr().equals("CH3") || list.get(i).getStr().equals("CH4") || list.get(i).getStr().contains("D")) {
                    if (list.get(i).getStr().equals("CH3") && utilityParam.readChNum() == 4) {
                        arrayList.add(list.get(i));
                    } else if (list.get(i).getStr().equals("CH4") && utilityParam.readChNum() == 4) {
                        arrayList.add(list.get(i));
                    }
                } else {
                    arrayList.add(list.get(i));
                }
                i++;
            }
        } else {
            while (i < list.size()) {
                if (((LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class)).getLiveData().getValue().getLa_calibration_probe() && list.get(i).getStr().contains("D")) {
                    arrayList.add(list.get(i));
                } else if (!list.get(i).getStr().contains("D")) {
                    arrayList.add(list.get(i));
                }
                i++;
            }
        }
        return arrayList;
    }

    public static List<MappingObject> checkNone(List<MappingObject> list) {
        ArrayList arrayList = new ArrayList();
        if (isDoubleChan()) {
            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).getStr().equals("CH3") && !list.get(i).getStr().equals("CH4") && !list.get(i).getStr().contains("D")) {
                    arrayList.add(list.get(i));
                }
            }
        } else {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public static boolean isDoubleChan() {
        UtilityParam utilityParam;
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        LaViewModel laViewModel = (LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class);
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData();
            utilityParam = utilityViewModel.getLiveData().getValue();
        } else {
            utilityParam = null;
        }
        LaParam value = laViewModel != null ? laViewModel.getLiveData().getValue() : null;
        if (value == null || utilityParam == null) {
            return false;
        }
        return utilityParam.readChNum() == 2 || utilityParam.getSeries() == 800 || !value.getLa_calibration_probe();
    }

    public static boolean isDoubleChanS() {
        UtilityParam utilityParam;
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        LaViewModel laViewModel = (LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class);
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData();
            utilityParam = utilityViewModel.getLiveData().getValue();
        } else {
            utilityParam = null;
        }
        return ((laViewModel != null ? laViewModel.getLiveData().getValue() : null) == null || utilityParam == null || utilityParam.readChNum() != 2) ? false : true;
    }

    public static boolean isDoubleChanDecod() {
        UtilityParam utilityParam;
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData();
            utilityParam = utilityViewModel.getLiveData().getValue();
        } else {
            utilityParam = null;
        }
        return utilityParam != null && utilityParam.readChNum() == 2 && utilityParam.getSeries() == 800;
    }

    public static ViewStateViewModel getViewStateViewModel() {
        if (viewStateViewModel == null) {
            synchronized (ViewStateViewModel.class) {
                if (viewStateViewModel == null) {
                    viewStateViewModel = (ViewStateViewModel) ContextUtil.getAppViewModel(ViewStateViewModel.class);
                }
            }
        }
        return viewStateViewModel;
    }

    public static FlexKnobParamViewModel getFlexKnobParamViewModel() {
        if (flexKnobParamViewModel == null) {
            synchronized (FlexKnobParamViewModel.class) {
                if (flexKnobParamViewModel == null) {
                    flexKnobParamViewModel = (FlexKnobParamViewModel) ContextUtil.getAppViewModel(FlexKnobParamViewModel.class);
                }
            }
        }
        return flexKnobParamViewModel;
    }

    public static ViewABkeyViewModel getViewABkeyViewModel() {
        if (viewABkeyViewModel == null) {
            synchronized (ViewStateViewModel.class) {
                if (viewABkeyViewModel == null) {
                    viewABkeyViewModel = (ViewABkeyViewModel) ContextUtil.getAppViewModel(ViewABkeyViewModel.class);
                }
            }
        }
        return viewABkeyViewModel;
    }

    public static void setKeyEven(float f, float f2) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        ControlEvent controlEvent2 = controlEvent;
        if (controlEvent2 == null) {
            synchronized (ControlEvent.class) {
                if (controlEvent == null) {
                    controlEvent = new ControlEvent();
                }
            }
            controlEvent.onMessage(f, f2);
            return;
        }
        controlEvent2.onMessage(f, f2);
    }

    public static boolean getTouchLock() {
        return ((UtilityViewModel) Objects.requireNonNull((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class))).getLiveData().getValue().readReadInputKeyboard();
    }

    public static List<MappingObject> checkla(List<MappingObject> list) {
        ArrayList arrayList = new ArrayList();
        if (((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getSeries() == 800) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getStr().equals("CH1") || list.get(i).getStr().equals("CH2")) {
                    arrayList.add(list.get(i));
                }
            }
        } else {
            arrayList.addAll(list);
        }
        return arrayList;
    }

    public static boolean checkModel() {
        return !((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getModel().contains(ExifInterface.LATITUDE_SOUTH);
    }

    public static boolean checkModelS() {
        return !((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getModel().equals("DHO812");
    }

    public static boolean checkModelEDU() {
        return !((UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class)).getValue().getModel().contains("EDU");
    }
}
