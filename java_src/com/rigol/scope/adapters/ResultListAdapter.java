package com.rigol.scope.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.blankj.utilcode.util.SPUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.WaveformFragment;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.CounterResultParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DvmResultParam;
import com.rigol.scope.data.EyeResultParam;
import com.rigol.scope.data.JitterResultParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.MaskResultParam;
import com.rigol.scope.data.MeasureResultParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.ResultParam;
import com.rigol.scope.data.RtsaMarkerResultParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.ThreeTuple;
import com.rigol.scope.databinding.AdapterItemResultCounterBinding;
import com.rigol.scope.databinding.AdapterItemResultCursorBinding;
import com.rigol.scope.databinding.AdapterItemResultDvmBinding;
import com.rigol.scope.databinding.AdapterItemResultEyeBinding;
import com.rigol.scope.databinding.AdapterItemResultHistogramBinding;
import com.rigol.scope.databinding.AdapterItemResultItemTowviewBinding;
import com.rigol.scope.databinding.AdapterItemResultJitterBinding;
import com.rigol.scope.databinding.AdapterItemResultMarkerBinding;
import com.rigol.scope.databinding.AdapterItemResultMaskBinding;
import com.rigol.scope.databinding.AdapterItemResultMeasHistogramBinding;
import com.rigol.scope.databinding.AdapterItemResultMeasureBinding;
import com.rigol.scope.databinding.FragmentWaveformBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.JsonUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.CounterViewModel;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.DvmViewModel;
import com.rigol.scope.viewmodels.HistogramViewModel;
import com.rigol.scope.viewmodels.MeasureResultViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.baseview.BaseWaveformView;
import com.rigol.scope.views.histogram.HistogramResultParam;
import com.rigol.scope.views.histogram.MeasHistogramResultParam;
import com.rigol.scope.views.wave.WaveformLayout;
import com.rigol.scope.views.window.Window;
import com.rigol.scope.views.window.WindowContent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import org.json.JSONException;
import timber.log.Timber;

/* loaded from: classes.dex */
public class ResultListAdapter extends MultiItemTypeAdapter<List<ResultParam>> {
    public static final String CACHED_RESULT_LIST_KEY = "cached_result_list";
    public static final String MODULE_KEY_EYE_TEXT_STATUS = "51_6440";
    private static final int NO_SUCH_INDEX = -1;
    public static final String ON_ITEM_DATA_BODE_KEY = "61_1303";
    public static final String ON_ITEM_DATA_CHANGED_KEY_COUNTER = "29_2824";
    public static final String ON_ITEM_DATA_CHANGED_KEY_CURSOR = "21_3370";
    public static final String ON_ITEM_DATA_CHANGED_KEY_DVM = "30_3849";
    public static final String ON_ITEM_DATA_CHANGED_KEY_EYE = "51_6437";
    public static final String ON_ITEM_DATA_CHANGED_KEY_HISTOGRAM = "34_8462";
    public static final String ON_ITEM_DATA_CHANGED_KEY_JITTER = "52_10014";
    public static final String ON_ITEM_DATA_CHANGED_KEY_MARKER = "50_6975";
    public static final String ON_ITEM_DATA_CHANGED_KEY_MASK = "46_11555";
    public static final String ON_ITEM_DATA_CHANGED_KEY_MEASURE = "28_13100";
    public static final String ON_ITEM_DATA_CHANGED_KEY_MEAS_HISTOGRAM = "34_8478";
    public static final String ON_ITEM_DATA_CHANGED_KEY_UPA = "31_12563";
    public static final String ON_ITEM_DATA_RIPPLE_KEY_UPA = "31_12564";
    public static final String ON_ITEM_DATA_SEACH_KEY = "25_17760";
    public static final String ON_ITEM_DATA_SEACH_KEY_POS = "25_17759";
    public static final String ON_LIST_CHANGED_KEY_COUNTER = "29_2825";
    public static final String ON_LIST_CHANGED_KEY_CURSOR = "21_3371";
    public static final String ON_LIST_CHANGED_KEY_DVM = "30_3850";
    public static final String ON_LIST_CHANGED_KEY_EYE = "51_6436";
    public static final String ON_LIST_CHANGED_KEY_HISTOGRAM = "34_8461";
    public static final String ON_LIST_CHANGED_KEY_JITTER = "52_10015";
    public static final String ON_LIST_CHANGED_KEY_MARKER = "50_6974";
    public static final String ON_LIST_CHANGED_KEY_MASK = "46_11556";
    public static final String ON_LIST_CHANGED_KEY_MEASURE = "28_13098";
    public static final String ON_LIST_CHANGED_KEY_MEAS_HISTOGRAM = "34_8477";
    private static final int SELECT_ITEM_NONE = -1;
    private int lastItemCount;
    private final MeasureResultViewModel measureResultViewModel;
    private SharedParam sharedParam;
    private final SharedViewModel sharedViewModel;
    private SparseArray<MappingObject> titlesArray;

    public ResultListAdapter(Context context) {
        super(context, new ArrayList());
        this.measureResultViewModel = (MeasureResultViewModel) ContextUtil.getAppViewModel(MeasureResultViewModel.class);
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        this.sharedViewModel = sharedViewModel;
        if (sharedViewModel != null) {
            sharedViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$ResultListAdapter$H8OP3y6WWvRLxuEXiRvp1daNr1M
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ResultListAdapter.this.lambda$new$0$ResultListAdapter((SharedParam) obj);
                }
            });
        }
        loadTitles(context);
        this.delegatesManager.addDelegate(new MeasureDelegate(R.layout.adapter_item_result_measure)).addDelegate(new CursorDelegate(R.layout.adapter_item_result_cursor)).addDelegate(new DvmDelegate(R.layout.adapter_item_result_dvm)).addDelegate(new CounterDelegate(R.layout.adapter_item_result_counter)).addDelegate(new EyeDelegate(R.layout.adapter_item_result_eye)).addDelegate(new JitterDelegate(R.layout.adapter_item_result_jitter)).addDelegate(new HistogramDelegate(R.layout.adapter_item_result_histogram)).addDelegate(new MeasHistogramDelegate(R.layout.adapter_item_result_meas_histogram)).addDelegate(new MaskDelegate(R.layout.adapter_item_result_mask)).addDelegate(new RtsaMarkerDelegate(R.layout.adapter_item_result_marker));
        SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        if (syncDataViewModel != null) {
            syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_STAT_ENABLE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$ResultListAdapter$g68xvSHC394mkclOd8rFxRTIK4c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ResultListAdapter.this.lambda$new$1$ResultListAdapter(obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$ResultListAdapter(SharedParam sharedParam) {
        this.sharedParam = sharedParam;
    }

    public /* synthetic */ void lambda$new$1$ResultListAdapter(Object obj) {
        cacheItems();
        notifyDataSetChanged();
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter
    public void setCurrentItem(int i) {
        ResultParam resultParam;
        super.setCurrentItem(i);
        if (i == -1) {
            setCurrentItem2Delegates(i);
            return;
        }
        List<ResultParam> items = getItems();
        if (items == null || items.size() == 0 || (resultParam = items.get(i)) == null || !(resultParam instanceof MeasureResultParam)) {
            return;
        }
        SharedParam sharedParam = this.sharedParam;
        if (sharedParam != null) {
            sharedParam.setCurrentResultItem(i);
        }
        setCurrentItem2Delegates(i);
        ((MeasureResultParam) resultParam).setIndicator(ViewUtil.getMeasureItem(resultParam.getMeasType().value1, resultParam.getSourceA().value1, resultParam.getSourceB().value1));
    }

    private void setCurrentItem2Delegates(int i) {
        SparseArrayCompat delegates = this.delegatesManager.getDelegates();
        if (delegates != null) {
            for (int i2 = 0; i2 < delegates.size(); i2++) {
                AdapterDelegate adapterDelegate = (AdapterDelegate) delegates.get(i2);
                if (adapterDelegate instanceof BaseMeasureAdapterDelegate) {
                    ((BaseMeasureAdapterDelegate) adapterDelegate).setSelectedPosition(i);
                }
            }
        }
    }

    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter
    public void resetCurrentItem() {
        super.resetCurrentItem();
        setCurrentItem2Delegates(-1);
    }

    public void removeAll() {
        if (getItemCount() <= 0) {
            return;
        }
        API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_CLEAR_ALL, 0);
        FunctionManager.getInstance().disable(ServiceEnum.Function.FUN_CURSOR);
        FunctionManager.getInstance().disable(ServiceEnum.Function.FUN_DVM);
        FunctionManager.getInstance().disable(ServiceEnum.Function.FUN_HISTOGRAM);
        FunctionManager.getInstance().disable(ServiceEnum.Function.FUN_COUNTER);
        getItems().clear();
        resetCurrentItem();
        refreshAndCache();
    }

    public void removeAll(Class<? extends ResultParam> cls) {
        if (getItemCount() == 0) {
            return;
        }
        SharedViewModel sharedViewModel = this.sharedViewModel;
        if (sharedViewModel != null) {
            sharedViewModel.hasRemoveMeasureItem.setValue(true);
        }
        API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_CLEAR_ALL, 0);
        removeItems(cls);
        resetCurrentItem();
        refreshAndCache();
    }

    private void removeItems(Class<? extends ResultParam> cls) {
        Iterator<ResultParam> it = getItems().iterator();
        while (it.hasNext()) {
            if (it.next().getClass() == cls) {
                it.remove();
            }
        }
    }

    public void remove(int i) {
        ResultParam resultParam;
        if (getItemCount() != 0 && i >= 0 && i < getItemCount() && (resultParam = getItems().get(i)) != null) {
            if (resultParam instanceof CursorResultParam) {
                ((CursorResultParam) resultParam).remove();
            } else if (resultParam instanceof DvmResultParam) {
                ((DvmResultParam) resultParam).remove();
            } else if (resultParam instanceof CounterResultParam) {
                ((CounterResultParam) resultParam).remove();
            } else if (resultParam instanceof HistogramResultParam) {
                ((HistogramResultParam) resultParam).remove();
            } else if (resultParam instanceof EyeResultParam) {
                ((EyeResultParam) resultParam).remove();
            } else if (resultParam instanceof JitterResultParam) {
                ((JitterResultParam) resultParam).remove();
            } else if (resultParam instanceof MaskResultParam) {
                ((MaskResultParam) resultParam).remove();
            } else if (resultParam instanceof RtsaMarkerResultParam) {
                ((RtsaMarkerResultParam) resultParam).remove();
            } else if (resultParam instanceof MeasHistogramResultParam) {
                ((MeasHistogramResultParam) resultParam).remove();
            } else if (resultParam instanceof MeasureResultParam) {
                try {
                    if (queryItems(28, MessageID.MSG_APP_MEAS_QUERY_ITEM).size() <= 1) {
                        if (this.sharedViewModel != null) {
                            this.sharedViewModel.hasRemoveMeasureItem.setValue(true);
                        }
                        FunctionManager.getInstance().restoreSelectedFunction();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ((MeasureResultParam) resultParam).remove();
            }
            getCurrentItem();
            getItems().remove(i);
            refreshAndCache();
        }
    }

    private int findchooseItem(int i) {
        List<ResultParam> items;
        if (i > -1 && (items = getItems()) != null && items.size() != 0) {
            for (int i2 = i; i2 < items.size(); i2++) {
                ResultParam resultParam = items.get(i2);
                if (resultParam != null && (resultParam instanceof MeasureResultParam)) {
                    return i2;
                }
            }
            for (int i3 = i - 1; i3 >= 0; i3--) {
                ResultParam resultParam2 = items.get(i3);
                if (resultParam2 != null && (resultParam2 instanceof MeasureResultParam)) {
                    return i3;
                }
            }
        }
        return -1;
    }

    private void refreshAndCache() {
        WaveformFragment waveformFragment;
        FragmentWaveformBinding binding;
        List<Window> windows;
        checkCurrentItem();
        notifyDataSetChanged();
        cacheItems();
        this.measureResultViewModel.getLiveData().setValue(getItems());
        SharedParam sharedParam = this.sharedParam;
        if (sharedParam != null) {
            if (sharedParam.getShowResultBar()) {
                this.sharedParam.setShowResultBar(getItemCount() != 0);
            } else {
                this.sharedParam.setShowResultBar((getItemCount() == 0 || getItemCount() == this.lastItemCount) ? false : false);
            }
        }
        if (getItemCount() == 0) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if ((topActivity instanceof MainActivity) && (waveformFragment = ((MainActivity) topActivity).getWaveformFragment()) != null && (binding = waveformFragment.getBinding()) != null && (windows = binding.multiWindow.getWindows()) != null) {
                for (Window window : windows) {
                    if (window != null) {
                        View findViewById = window.findViewById(R.id.window_content);
                        if (findViewById instanceof WindowContent) {
                            findViewById.setTag(111, true);
                            ((WindowContent) findViewById).hideABxyIndicator();
                        } else if (findViewById instanceof WaveformLayout) {
                            findViewById.setTag(111, true);
                            BaseWaveformView mainView = ((WaveformLayout) findViewById).getMainView();
                            if (mainView != null) {
                                mainView.hideABxyIndicator();
                            }
                        }
                    }
                }
            }
        }
        this.lastItemCount = getItemCount();
    }

    private void checkCurrentItem() {
        if (getItemCount() <= 0) {
            setCurrentItem(-1);
            return;
        }
        int currentItem = getCurrentItem();
        if (currentItem < 0) {
            currentItem = 0;
        } else if (currentItem >= getItemCount()) {
            currentItem = getItemCount() - 1;
        }
        MessageBus.getInstance().onSyncData(MessageBus.getKey(28, MessageID.MSG_APP_MEASURE), getItems().get(currentItem).getMeasType());
        List<ResultParam> items = getItems();
        if (items == null || items.size() <= 0) {
            return;
        }
        if (items.get(currentItem) instanceof MeasureResultParam) {
            setCurrentItem(currentItem);
            return;
        }
        for (int i = currentItem + 1; i < items.size(); i++) {
            if (items.get(i) instanceof MeasureResultParam) {
                setCurrentItem(i);
                return;
            }
        }
        for (int i2 = currentItem - 1; i2 >= 0; i2--) {
            if (items.get(i2) instanceof MeasureResultParam) {
                setCurrentItem(i2);
                return;
            }
        }
        setCurrentItem(-1);
    }

// info: восстановление активных пунктов измерений из preferences приложения
    public void recover() throws JSONException {
        List<ResultParam> resultParams;
        boolean z;
        int i = 0;
        MessageBus.getInstance().setUseQueue(false);
        String string = SPUtils.getInstance().getString(CACHED_RESULT_LIST_KEY);
        if (TextUtils.isEmpty(string) || (resultParams = JsonUtil.getResultParams(string)) == null || resultParams.isEmpty()) {
            return;
        }
        Queue<String> cachedQueue = MessageBus.getInstance().getCachedQueue();
        LinkedList linkedList = new LinkedList();
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        while (true) {
            z = true;
            if (cachedQueue.peek() == null) {
                break;
            }
            String poll = cachedQueue.poll();
            if (ON_LIST_CHANGED_KEY_MEASURE.equals(poll)) {
                List<ResultParam> queryItems = queryItems(28, MessageID.MSG_APP_MEAS_QUERY_ITEM);
                z2 = (queryItems == null || queryItems.isEmpty()) ? false : true;
            } else if (ON_LIST_CHANGED_KEY_CURSOR.equals(poll)) {
                List<ResultParam> queryItems2 = queryItems(21, MessageID.MSG_CURSOR_QUERY_ITEM);
                z4 = (queryItems2 == null || queryItems2.isEmpty()) ? false : true;
            } else if (ON_LIST_CHANGED_KEY_DVM.equals(poll)) {
                List<ResultParam> queryItems3 = queryItems(30, MessageID.MSG_DVM_QUERY_ITEM);
                z3 = (queryItems3 == null || queryItems3.isEmpty()) ? false : true;
            } else if (ON_LIST_CHANGED_KEY_COUNTER.equals(poll)) {
                List<ResultParam> queryItems4 = queryItems(29, MessageID.MSG_COUNTER_QUERY_ITEM);
                z5 = (queryItems4 == null || queryItems4.isEmpty()) ? false : true;
            } else if (ON_LIST_CHANGED_KEY_HISTOGRAM.equals(poll)) {
                List<ResultParam> queryItems5 = queryItems(34, MessageID.MSG_HISTO_QUERY_ITEM);
                z6 = (queryItems5 == null || queryItems5.isEmpty()) ? false : true;
            } else if (ON_LIST_CHANGED_KEY_MEAS_HISTOGRAM.equals(poll)) {
                List<ResultParam> queryItems6 = queryItems(34, MessageID.MSG_HISTO_QUERY_MEAS_ITEM);
                z9 = (queryItems6 == null || queryItems6.isEmpty()) ? false : true;
            } else if (ON_LIST_CHANGED_KEY_EYE.equals(poll)) {
                List<ResultParam> queryItems7 = queryItems(51, MessageID.MSG_EYE_QUERY_RESULT_UI);
                z7 = (queryItems7 == null || queryItems7.isEmpty()) ? false : true;
            } else if (ON_LIST_CHANGED_KEY_JITTER.equals(poll)) {
                List<ResultParam> queryItems8 = queryItems(52, MessageID.MSG_JITTER_QUERY_RESULT_UI);
                z8 = (queryItems8 == null || queryItems8.isEmpty()) ? false : true;
            } else {
                linkedList.offer(poll);
            }
        }
        Iterator<ResultParam> it = resultParams.iterator();
        int i2 = -1;
        while (it.hasNext()) {
            ResultParam next = it.next();
            if (next != null) {
                Iterator<ResultParam> it2 = it;
                int i3 = i2;
                boolean z10 = z2;
                boolean z11 = z;
                ResultParam newParam = newParam(next.getMeasType(), z2, z3, z4, z5, z6, z9, z7, z8);
                if (newParam != null) {
                    copyParam(next, newParam);
                    if (newParam.getMeasType() == ServiceEnum.MeasType.Meas_Cursor) {
                        ((CursorResultParam) newParam).saveSourceA(newParam.getSourceA());
                    } else if (newParam.getMeasType() == ServiceEnum.MeasType.Meas_DVM) {
                        ServiceEnum.DvmMode dvmModeFromValue1 = ServiceEnum.getDvmModeFromValue1(next.getMode());
                        if (dvmModeFromValue1 != null) {
                            ((DvmResultParam) newParam).setDvmMode(dvmModeFromValue1);
                        }
                    } else if (newParam.getMeasType() == ServiceEnum.MeasType.Meas_Counter) {
                        ServiceEnum.CounterType counterTypeFromValue1 = ServiceEnum.getCounterTypeFromValue1(next.getMode());
                        if (counterTypeFromValue1 != null) {
                            ((CounterResultParam) newParam).setCounterType(counterTypeFromValue1);
                        }
                    } else if ((newParam instanceof MeasureResultParam) && i3 == -1) {
                        i2 = i;
                        getItems().add(newParam);
                        i++;
                    }
                    i2 = i3;
                    getItems().add(newParam);
                    i++;
                } else {
                    i2 = i3;
                }
                z = z11;
                it = it2;
                z2 = z10;
            }
        }
        int i4 = i2;
        boolean z12 = z;
        if (i4 != -1) {
            setCurrentItem(i4);
        }
        notifyDataSetChanged();
        while (linkedList.peek() != null) {
            MessageBus.getInstance().onUpdateUI((String) linkedList.poll(), z12);
        }
    }

// info: сохранение активного списка результатов измерений в preferences приложения
    private void cacheItems() {
        try {
            SPUtils.getInstance().put(CACHED_RESULT_LIST_KEY, JsonUtil.toJson(getItems()));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadTitles(Context context) {
        this.titlesArray = MappingObject.createMappingByValue(context, R.array.msg_app_meas_hor_type, R.array.msg_app_meas_vertical_type, R.array.msg_app_meas_other_type, R.array.msg_app_meas_histo_type, R.array.msg_app_meas_counter_type, R.array.msg_app_meas_dvm_type, R.array.msg_app_meas_cursor_type, R.array.msg_app_meas_eye_type, R.array.msg_app_meas_jitter_type, R.array.msg_app_meas_mask_type, R.array.msg_app_meas_marker1_type, R.array.msg_app_meas_marker2_type, R.array.msg_app_meas_marker3_type, R.array.msg_app_meas_marker4_type, R.array.msg_app_meas_marker5_type, R.array.msg_app_meas_marker6_type, R.array.msg_app_meas_marker7_type, R.array.msg_app_meas_marker8_type);
    }

    public void refreshTitles(Context context) {
        MappingObject mappingObject;
        loadTitles(context);
        for (ResultParam resultParam : getItems()) {
            ServiceEnum.MeasType measType = resultParam.getMeasType();
            if (measType != null && (mappingObject = this.titlesArray.get(measType.value1)) != null) {
                resultParam.setTitle(mappingObject.getStr());
            }
        }
        notifyDataSetChanged();
    }

    public void onListChanged(Class<? extends ResultParam> cls) {
        try {
            if (cls == MeasureResultParam.class) {
                onListChanged(queryItems(28, MessageID.MSG_APP_MEAS_QUERY_ITEM), MeasureResultParam.class);
            } else if (cls == CursorResultParam.class) {
                onListChanged(queryItems(21, MessageID.MSG_CURSOR_QUERY_ITEM), CursorResultParam.class);
            } else if (cls == DvmResultParam.class) {
                onListChanged(queryItems(30, MessageID.MSG_DVM_QUERY_ITEM), DvmResultParam.class);
            } else if (cls == CounterResultParam.class) {
                onListChanged(queryItems(29, MessageID.MSG_COUNTER_QUERY_ITEM), CounterResultParam.class);
            } else if (cls == HistogramResultParam.class) {
                onListChanged(queryItems(34, MessageID.MSG_HISTO_QUERY_ITEM), HistogramResultParam.class);
            } else if (cls == MeasHistogramResultParam.class) {
                onListChanged(queryItems(34, MessageID.MSG_HISTO_QUERY_MEAS_ITEM), MeasHistogramResultParam.class);
            } else if (cls == EyeResultParam.class) {
                onListChanged(queryItems(51, MessageID.MSG_EYE_QUERY_RESULT_UI), EyeResultParam.class);
            } else if (cls == JitterResultParam.class) {
                onListChanged(queryItems(52, MessageID.MSG_JITTER_QUERY_RESULT_UI), JitterResultParam.class);
            } else if (cls == MaskResultParam.class) {
                onListChanged(queryItems(46, MessageID.MSG_MASK_QUERY_UI), MaskResultParam.class);
            } else if (cls != RtsaMarkerResultParam.class) {
            } else {
                onListChanged(queryItems(50, MessageID.MSG_FFT_MARKER_QUERY_UI), RtsaMarkerResultParam.class);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void onListChanged(List<ResultParam> list, Class<? extends ResultParam> cls) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    List<ResultParam> items = getItems();
                    for (ResultParam resultParam : list) {
                        int isInParams = isInParams(items, resultParam.getMeasType(), resultParam.getSourceA(), resultParam.getSourceB());
                        if (isInParams != -1) {
                            ResultParam resultParam2 = items.get(isInParams);
                            if (resultParam2 != null) {
                                resultParam2.setSourceA(resultParam.getSourceA());
                                resultParam2.setSourceB(resultParam.getSourceB());
                            }
                        } else {
                            ResultParam newParam = newParam(cls);
                            if (newParam != null) {
                                if (newParam.getMeasType() == ServiceEnum.MeasType.Meas_DVM) {
                                    ((DvmResultParam) newParam).readMode();
                                } else if (newParam.getMeasType() == ServiceEnum.MeasType.Meas_Counter) {
                                    ((CounterResultParam) newParam).readCounterType();
                                }
                                copyParam(resultParam, newParam);
                                getItems().add(newParam);
                                this.measureResultViewModel.getResultBarStatus().setValue(true);
                                syncItemAdded(cls);
                                if (newParam instanceof MeasureResultParam) {
                                    setCurrentItem(getItems().size() - 1);
                                }
                            }
                        }
                    }
                    if (cls == MeasureResultParam.class) {
                        int i = 0;
                        while (i < items.size()) {
                            ResultParam resultParam3 = items.get(i);
                            if (resultParam3 != null && resultParam3.getClass() == cls && !list.contains(resultParam3)) {
                                items.remove(resultParam3);
                                i--;
                            }
                            i++;
                        }
                    }
                    refreshAndCache();
                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        removeItems(cls);
        syncItemRemoved(cls);
        refreshAndCache();
    }

    private void syncItemRemoved(Class<? extends ResultParam> cls) {
        if (cls == null) {
            return;
        }
        if (cls == CursorResultParam.class) {
            MessageBus.getInstance().onSyncData(21, MessageID.MSG_CURSOR_MODE, false);
        } else if (cls == DvmResultParam.class) {
            MessageBus.getInstance().onSyncData(30, MessageID.MSG_DVM_ENABLE, false);
        } else if (cls == CounterResultParam.class) {
            MessageBus.getInstance().onSyncData(29, MessageID.MSG_COUNTER_1_ENABLE, false);
        } else if (cls == HistogramResultParam.class) {
            MessageBus.getInstance().onSyncData(34, MessageID.MSG_HISTO_EN, false);
        } else if (cls != EyeResultParam.class && cls == MeasHistogramResultParam.class) {
            MessageBus.getInstance().onSyncData(28, MessageID.MSG_APP_MEAS_HISTO_ENABLE, false);
        }
    }

    private void syncItemAdded(Class<? extends ResultParam> cls) {
        if (cls == null) {
            return;
        }
        if (cls == CursorResultParam.class) {
            MessageBus.getInstance().onSyncData(21, MessageID.MSG_CURSOR_MODE, true);
        } else if (cls == DvmResultParam.class) {
            MessageBus.getInstance().onSyncData(30, MessageID.MSG_DVM_ENABLE, true);
        } else if (cls == CounterResultParam.class) {
            MessageBus.getInstance().onSyncData(29, MessageID.MSG_COUNTER_1_ENABLE, true);
        } else if (cls == HistogramResultParam.class) {
            MessageBus.getInstance().onSyncData(34, MessageID.MSG_HISTO_EN, true);
        }
    }

    private void copyParam(ResultParam resultParam, ResultParam resultParam2) {
        resultParam2.setMeasType(resultParam.getMeasType());
        resultParam2.setSourceA(resultParam.getSourceA());
        resultParam2.setSourceB(resultParam.getSourceB());
        MappingObject mappingObject = this.titlesArray.get(resultParam.getMeasType().value1);
        if (mappingObject != null) {
            resultParam2.setTitle(mappingObject.getStr());
        }
        if (resultParam2 instanceof MeasureResultParam) {
            resultParam2.setStat(resultParam.getStat());
        }
    }

    public void onItemDataChanged(Class<? extends ResultParam> cls) {
        if (cls == MeasureResultParam.class) {
            onItemDataChanged(queryData(28, MessageID.MSG_APP_MEAS_QUERY_DATA));
        } else if (cls == CursorResultParam.class) {
            onItemDataChanged(queryData(21, MessageID.MSG_CURSOR_QUERY_DATA));
        } else if (cls == DvmResultParam.class) {
            onItemDataChanged(queryData(30, MessageID.MSG_DVM_QUERY_DATA));
        } else if (cls == CounterResultParam.class) {
            onItemDataChanged(queryData(29, MessageID.MSG_COUNTER_QUERY_DATA));
        } else if (cls == HistogramResultParam.class) {
            onItemDataChanged(queryData(34, MessageID.MSG_HISTO_QUERY_DATA));
        } else if (cls == MeasHistogramResultParam.class) {
            onItemDataChanged(queryData(34, MessageID.MSG_HISTO_QUERY_MEAS_DATA));
        } else if (cls == EyeResultParam.class) {
            onItemDataChanged(queryData(51, MessageID.MSG_EYE_QUERY_RESULT_DATA));
        } else if (cls == JitterResultParam.class) {
            onItemDataChanged(queryData(52, MessageID.MSG_JITTER_QUERY_RESULT_DATA));
        } else if (cls == MaskResultParam.class) {
            onItemDataChanged(queryData(46, MessageID.MSG_MASK_QUERY_DATA));
        } else if (cls == RtsaMarkerResultParam.class) {
            onItemDataChanged(queryData(50, MessageID.MSG_FFT_MARKER_QUERY_DATA));
        }
    }

    private void onItemDataChanged(String[][] strArr) {
        try {
            List<ResultParam> items = getItems();
            for (String[] strArr2 : strArr) {
                int isInParams = isInParams(items, strArr2);
                if (isInParams != -1) {
                    onItemDataChanged(items.get(isInParams), strArr2);
                    notifyItemChanged(isInParams);
                }
            }
        } catch (Exception e) {
            Timber.e(e.toString(), new Object[0]);
            e.printStackTrace();
        }
    }

    public static ResultParam newParam(Class<? extends ResultParam> cls) {
        HistogramViewModel histogramViewModel;
        HistogramResultParam value;
        CounterResultParam value2;
        DvmResultParam value3;
        CursorResultParam value4;
        if (cls == CursorResultParam.class) {
            CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
            if (cursorViewModel != null && (value4 = cursorViewModel.getLiveData().getValue()) != null) {
                return value4;
            }
        } else if (cls == DvmResultParam.class) {
            DvmViewModel dvmViewModel = (DvmViewModel) ContextUtil.getAppViewModel(DvmViewModel.class);
            if (dvmViewModel != null && (value3 = dvmViewModel.getLiveData().getValue()) != null) {
                return value3;
            }
        } else if (cls == CounterResultParam.class) {
            CounterViewModel counterViewModel = (CounterViewModel) ContextUtil.getAppViewModel(CounterViewModel.class);
            if (counterViewModel != null && (value2 = counterViewModel.getLiveData().getValue()) != null) {
                return value2;
            }
        } else if (cls == HistogramResultParam.class && (histogramViewModel = (HistogramViewModel) ContextUtil.getAppViewModel(HistogramViewModel.class)) != null && (value = histogramViewModel.getLiveData().getValue()) != null) {
            return value;
        }
        try {
            return cls.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ResultParam newParam(ServiceEnum.MeasType measType, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
        if (measType == null) {
            return null;
        }
        if (measType == ServiceEnum.MeasType.Meas_Cursor) {
            if (z3) {
                return new CursorResultParam();
            }
        } else if (measType == ServiceEnum.MeasType.Meas_DVM) {
            if (z2) {
                return new DvmResultParam();
            }
        } else if (measType == ServiceEnum.MeasType.Meas_Counter) {
            if (z4) {
                return new CounterResultParam();
            }
        } else if (measType == ServiceEnum.MeasType.Meas_Histogram) {
            if (z5) {
                return new HistogramResultParam();
            }
        } else if (measType == ServiceEnum.MeasType.Meas_MHistogram) {
            if (z6) {
                return new MeasHistogramResultParam();
            }
        } else if (measType == ServiceEnum.MeasType.EYE_RESULT) {
            if (z7) {
                return new EyeResultParam();
            }
        } else if (measType == ServiceEnum.MeasType.Jitter_Result) {
            if (z8) {
                return new JitterResultParam();
            }
        } else if (z) {
            return new MeasureResultParam();
        }
        return null;
    }

    private int isInParams(List<ResultParam> list, ServiceEnum.MeasType measType, ServiceEnum.Chan chan, ServiceEnum.Chan chan2) {
        for (int i = 0; i < list.size(); i++) {
            ResultParam resultParam = list.get(i);
            if (resultParam != null && measType == resultParam.getMeasType() && (measType == ServiceEnum.MeasType.Meas_Cursor || measType == ServiceEnum.MeasType.Meas_DVM || measType == ServiceEnum.MeasType.Meas_Counter || measType == ServiceEnum.MeasType.MASK_RESULT || measType == ServiceEnum.MeasType.Jitter_Result || measType == ServiceEnum.MeasType.EYE_RESULT || measType == ServiceEnum.MeasType.Meas_MHistogram || measType == ServiceEnum.MeasType.Meas_Histogram || (chan == resultParam.getSourceA() && chan2 == resultParam.getSourceB()))) {
                return i;
            }
        }
        return -1;
    }

    private int isInParams(List<ResultParam> list, String[] strArr) {
        if (strArr == null) {
            return -1;
        }
        return isInParams(list, ServiceEnum.getMeasTypeFromValue1(Integer.parseInt(strArr[0])), ServiceEnum.getChanFromValue1(Integer.parseInt(strArr[1])), ServiceEnum.getChanFromValue1(Integer.parseInt(strArr[2])));
    }

    private void onItemDataChanged(ResultParam resultParam, String[] strArr) {
        if (resultParam instanceof CounterResultParam) {
            ((CounterResultParam) resultParam).setData(strArr);
        } else if (resultParam instanceof DvmResultParam) {
            ((DvmResultParam) resultParam).setData(strArr);
        } else if (resultParam instanceof CursorResultParam) {
            CursorResultParam cursorResultParam = (CursorResultParam) resultParam;
            cursorResultParam.readAbXy();
            cursorResultParam.setData(strArr);
        } else if (resultParam instanceof HistogramResultParam) {
            ((HistogramResultParam) resultParam).setData(strArr);
        } else if (resultParam instanceof MeasHistogramResultParam) {
            ((MeasHistogramResultParam) resultParam).setData(strArr);
        } else if (resultParam instanceof EyeResultParam) {
            ((EyeResultParam) resultParam).setData(strArr);
        } else if (resultParam instanceof JitterResultParam) {
            ((JitterResultParam) resultParam).setData(strArr);
        } else if (resultParam instanceof MaskResultParam) {
            ((MaskResultParam) resultParam).setData(strArr);
        } else if (resultParam instanceof RtsaMarkerResultParam) {
            ((RtsaMarkerResultParam) resultParam).setData(strArr);
        } else {
            ((MeasureResultParam) resultParam).setData(strArr);
        }
    }

    private List<ResultParam> queryItems(int i, int i2) throws JSONException {
        return JsonUtil.getResultParams(API.getInstance().UI_QueryStr(i, i2));
    }

    private String[][] queryData(int i, int i2) {
        try {
            return (String[][]) GsonUtils.fromJson(API.getInstance().UI_QueryStr(i, i2), (Class<Object>) String[][].class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class MeasureDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public MeasureDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof MeasureResultParam;
        }

    // info: задание заголовка пункта измерений с цветным выделением канала
    @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            SpannableString titleWithSrc;
            super.onBindViewHolder(list, i, baseViewHolder);
            final AdapterItemResultMeasureBinding adapterItemResultMeasureBinding = (AdapterItemResultMeasureBinding) baseViewHolder.getBinding();
            final MeasureResultParam measureResultParam = (MeasureResultParam) list.get(i);
            if (measureResultParam == null) {
                return;
            }
            if (measureResultParam.getMeasType() != null && measureResultParam.getTitle() != null) {
                if (measureResultParam.getMeasType().value1 >= ServiceEnum.MeasType.Meas_DelayRR.value1 && measureResultParam.getMeasType().value1 <= ServiceEnum.MeasType.Meas_PhaseFF.value1) {
                    titleWithSrc = ViewUtil.getTitleWithSrc(adapterItemResultMeasureBinding.getRoot().getContext(), measureResultParam.getTitle(), measureResultParam.getSourceA(), measureResultParam.getSourceB());
                } else {
                    titleWithSrc = ViewUtil.getTitleWithSrc(adapterItemResultMeasureBinding.getRoot().getContext(), measureResultParam.getTitle(), measureResultParam.getSourceA());
                }
                if (adapterItemResultMeasureBinding.getRoot().getWidth() != 0) {
                    Paint paint = new Paint(adapterItemResultMeasureBinding.title.getPaint());
                    ViewUtil.getFitableTextSize(paint, titleWithSrc.toString(), (adapterItemResultMeasureBinding.getRoot().getWidth() - adapterItemResultMeasureBinding.icon.getWidth()) - 20, 8.0f, 16.0f);
                    ViewUtil.getFitableTextSize(paint, titleWithSrc.toString(), adapterItemResultMeasureBinding.getRoot().getWidth(), 14.0f, 15.0f);
                }
                adapterItemResultMeasureBinding.title.setText(titleWithSrc);
            }
            adapterItemResultMeasureBinding.setParam(measureResultParam);
            ItemAdapter itemAdapter = (ItemAdapter) adapterItemResultMeasureBinding.resultList.getAdapter();
            if (itemAdapter != null) {
                itemAdapter.setItems(measureResultParam.getData());
                itemAdapter.notifyDataSetChanged();
            }
            adapterItemResultMeasureBinding.arrow.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$ResultListAdapter$MeasureDelegate$C-hS2lXcn2FbLQT8PGIs76EX6cY
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ResultListAdapter.MeasureDelegate.lambda$onBindViewHolder$0(MeasureResultParam.this, adapterItemResultMeasureBinding, view);
                }
            });
        }

        static /* synthetic */ void lambda$onBindViewHolder$0(MeasureResultParam measureResultParam, AdapterItemResultMeasureBinding adapterItemResultMeasureBinding, View view) {
            if (measureResultParam.getStat() == 1) {
                measureResultParam.setStats(0);
                API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_ITEM_CHECKED, ViewUtil.getMeasureItem(measureResultParam.getMeasType().value1, measureResultParam.getSourceA().value1, measureResultParam.getSourceB().value1));
            } else {
                measureResultParam.setStats(1);
                API.getInstance().UI_PostInt32(28, MessageID.MSG_APP_MEAS_ITEM_CHECKED, ViewUtil.getMeasureItem(measureResultParam.getMeasType().value1, measureResultParam.getSourceA().value1, measureResultParam.getSourceB().value1));
            }
            ViewUtil.setTouchDelegateDelay(adapterItemResultMeasureBinding.arrow, (ViewGroup) adapterItemResultMeasureBinding.getRoot(), 15, 200);
            API.getInstance().UI_PostInt32(28, MessageID.MSG_MEAS_ITEM_STAT, ViewUtil.getMeasureItem(measureResultParam.getStat(), measureResultParam.getMeasType().value1, measureResultParam.getSourceA().value1, measureResultParam.getSourceB().value1));
        }

        @Override // com.rigol.scope.adapters.BaseAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
            AdapterItemResultMeasureBinding adapterItemResultMeasureBinding = (AdapterItemResultMeasureBinding) DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()), getLayoutId(), viewGroup, false);
            ViewUtil.setTouchDelegate(adapterItemResultMeasureBinding.arrow, (ViewGroup) adapterItemResultMeasureBinding.getRoot(), 15);
            adapterItemResultMeasureBinding.resultList.setVisibility(8);
            return new MeasureVH(adapterItemResultMeasureBinding);
        }
    }

    /* loaded from: classes.dex */
    public static class MeasureVH extends BaseViewHolder<AdapterItemResultMeasureBinding> {
        public MeasureVH(AdapterItemResultMeasureBinding adapterItemResultMeasureBinding) {
            super(adapterItemResultMeasureBinding);
            adapterItemResultMeasureBinding.resultList.setAdapter(new ItemAdapter(adapterItemResultMeasureBinding.getRoot().getContext(), new ArrayList(), R.layout.adapter_item_result_item_towview));
        }
    }

    /* loaded from: classes.dex */
    public static class HistogramDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public HistogramDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof HistogramResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            AdapterItemResultHistogramBinding adapterItemResultHistogramBinding = (AdapterItemResultHistogramBinding) baseViewHolder.getBinding();
            HistogramResultParam histogramResultParam = (HistogramResultParam) list.get(i);
            adapterItemResultHistogramBinding.setParam(histogramResultParam);
            ItemAdapter itemAdapter = (ItemAdapter) adapterItemResultHistogramBinding.resultList.getAdapter();
            if (itemAdapter == null || histogramResultParam.getData() == null) {
                return;
            }
            itemAdapter.setItems(histogramResultParam.getData());
            itemAdapter.notifyDataSetChanged();
        }

        @Override // com.rigol.scope.adapters.BaseAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup);
            AdapterItemResultHistogramBinding adapterItemResultHistogramBinding = (AdapterItemResultHistogramBinding) onCreateViewHolder.getBinding();
            adapterItemResultHistogramBinding.resultList.setAdapter(new ItemAdapter(adapterItemResultHistogramBinding.getRoot().getContext(), new ArrayList(), R.layout.adapter_item_result_item_towview));
            return onCreateViewHolder;
        }
    }

    /* loaded from: classes.dex */
    public static class MeasHistogramDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public MeasHistogramDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof MeasHistogramResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            AdapterItemResultMeasHistogramBinding adapterItemResultMeasHistogramBinding = (AdapterItemResultMeasHistogramBinding) baseViewHolder.getBinding();
            MeasHistogramResultParam measHistogramResultParam = (MeasHistogramResultParam) list.get(i);
            adapterItemResultMeasHistogramBinding.setParam(measHistogramResultParam);
            ItemAdapter itemAdapter = (ItemAdapter) adapterItemResultMeasHistogramBinding.resultList.getAdapter();
            if (itemAdapter == null || measHistogramResultParam.getData() == null) {
                return;
            }
            itemAdapter.setItems(measHistogramResultParam.getData());
            itemAdapter.notifyDataSetChanged();
        }

        @Override // com.rigol.scope.adapters.BaseAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup);
            AdapterItemResultMeasHistogramBinding adapterItemResultMeasHistogramBinding = (AdapterItemResultMeasHistogramBinding) onCreateViewHolder.getBinding();
            adapterItemResultMeasHistogramBinding.resultList.setAdapter(new ItemAdapter(adapterItemResultMeasHistogramBinding.getRoot().getContext(), new ArrayList(), R.layout.adapter_item_result_item_towview));
            return onCreateViewHolder;
        }
    }

    /* loaded from: classes.dex */
    public static class CursorDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public CursorDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof CursorResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            AdapterItemResultCursorBinding adapterItemResultCursorBinding = (AdapterItemResultCursorBinding) baseViewHolder.getBinding();
            CursorResultParam cursorResultParam = (CursorResultParam) list.get(i);
            adapterItemResultCursorBinding.setParam(cursorResultParam);
            ItemAdapter itemAdapter = (ItemAdapter) adapterItemResultCursorBinding.resultList.getAdapter();
            if (itemAdapter != null) {
                itemAdapter.setItems(cursorResultParam.getData());
                itemAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.rigol.scope.adapters.BaseAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup);
            AdapterItemResultCursorBinding adapterItemResultCursorBinding = (AdapterItemResultCursorBinding) onCreateViewHolder.getBinding();
            adapterItemResultCursorBinding.resultList.setAdapter(new ItemAdapter(adapterItemResultCursorBinding.getRoot().getContext(), new ArrayList(), R.layout.adapter_item_result_item_towview));
            return onCreateViewHolder;
        }
    }

    /* loaded from: classes.dex */
    public static class DvmDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public DvmDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof DvmResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            DvmResultParam dvmResultParam = (DvmResultParam) list.get(i);
            dvmResultParam.readMode();
            dvmResultParam.readDVMBandwidth();
            ((AdapterItemResultDvmBinding) baseViewHolder.getBinding()).setParam(dvmResultParam);
        }
    }

    /* loaded from: classes.dex */
    public static class CounterDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public CounterDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof CounterResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            CounterResultParam counterResultParam = (CounterResultParam) list.get(i);
            counterResultParam.readCounterType();
            ((AdapterItemResultCounterBinding) baseViewHolder.getBinding()).setParam(counterResultParam);
        }
    }

    /* loaded from: classes.dex */
    public static class ItemAdapter extends BaseAdapter<List<ThreeTuple<String, String, Float>>> {
        private ResultParam param;

        public ItemAdapter(Context context, List<ThreeTuple<String, String, Float>> list, int i) {
            super(context, list, i);
        }

        @Override // com.rigol.scope.adapters.BaseAdapter
        protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<ThreeTuple<String, String, Float>> list, int i) {
            AdapterItemResultItemTowviewBinding adapterItemResultItemTowviewBinding = (AdapterItemResultItemTowviewBinding) baseViewHolder.getBinding();
            adapterItemResultItemTowviewBinding.itemTitle.setText(list.get(i).getFirst());
            adapterItemResultItemTowviewBinding.itemData.setText(list.get(i).getSecond());
        }

        public ResultParam getParam() {
            return this.param;
        }

        public void setParam(ResultParam resultParam) {
            this.param = resultParam;
        }
    }

    /* loaded from: classes.dex */
    public static class EyeDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public EyeDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof EyeResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            AdapterItemResultEyeBinding adapterItemResultEyeBinding = (AdapterItemResultEyeBinding) baseViewHolder.getBinding();
            EyeResultParam eyeResultParam = (EyeResultParam) list.get(i);
            adapterItemResultEyeBinding.setParam(eyeResultParam);
            ItemAdapter itemAdapter = (ItemAdapter) adapterItemResultEyeBinding.resultList.getAdapter();
            if (itemAdapter != null) {
                itemAdapter.setItems(eyeResultParam.getData());
                itemAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.rigol.scope.adapters.BaseAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup);
            AdapterItemResultEyeBinding adapterItemResultEyeBinding = (AdapterItemResultEyeBinding) onCreateViewHolder.getBinding();
            adapterItemResultEyeBinding.resultList.setAdapter(new ItemAdapter(adapterItemResultEyeBinding.getRoot().getContext(), new ArrayList(), R.layout.adapter_item_result_item_towview));
            return onCreateViewHolder;
        }
    }

    /* loaded from: classes.dex */
    public static class JitterDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public JitterDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof JitterResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            AdapterItemResultJitterBinding adapterItemResultJitterBinding = (AdapterItemResultJitterBinding) baseViewHolder.getBinding();
            JitterResultParam jitterResultParam = (JitterResultParam) list.get(i);
            adapterItemResultJitterBinding.setParam(jitterResultParam);
            ItemAdapter itemAdapter = (ItemAdapter) adapterItemResultJitterBinding.resultList.getAdapter();
            if (itemAdapter != null) {
                itemAdapter.setItems(jitterResultParam.getData());
                itemAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.rigol.scope.adapters.BaseAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup);
            AdapterItemResultJitterBinding adapterItemResultJitterBinding = (AdapterItemResultJitterBinding) onCreateViewHolder.getBinding();
            adapterItemResultJitterBinding.resultList.setAdapter(new ItemAdapter(adapterItemResultJitterBinding.getRoot().getContext(), new ArrayList(), R.layout.adapter_item_result_item_towview));
            return onCreateViewHolder;
        }
    }

    /* loaded from: classes.dex */
    public static class MaskDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public MaskDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof MaskResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            AdapterItemResultMaskBinding adapterItemResultMaskBinding = (AdapterItemResultMaskBinding) baseViewHolder.getBinding();
            MaskResultParam maskResultParam = (MaskResultParam) list.get(i);
            adapterItemResultMaskBinding.setParam(maskResultParam);
            ItemAdapter itemAdapter = (ItemAdapter) adapterItemResultMaskBinding.resultList.getAdapter();
            if (itemAdapter != null) {
                itemAdapter.setItems(maskResultParam.getData());
                itemAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.rigol.scope.adapters.BaseAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup);
            AdapterItemResultMaskBinding adapterItemResultMaskBinding = (AdapterItemResultMaskBinding) onCreateViewHolder.getBinding();
            adapterItemResultMaskBinding.resultList.setAdapter(new ItemAdapter(adapterItemResultMaskBinding.getRoot().getContext(), new ArrayList(), R.layout.adapter_item_result_item_towview));
            return onCreateViewHolder;
        }
    }

    /* loaded from: classes.dex */
    public static class RtsaMarkerDelegate extends BaseMeasureAdapterDelegate {
        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public RtsaMarkerDelegate(int i) {
            super(i);
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return list.get(i) instanceof RtsaMarkerResultParam;
        }

        @Override // com.rigol.scope.adapters.ResultListAdapter.BaseMeasureAdapterDelegate
        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            super.onBindViewHolder(list, i, baseViewHolder);
            AdapterItemResultMarkerBinding adapterItemResultMarkerBinding = (AdapterItemResultMarkerBinding) baseViewHolder.getBinding();
            RtsaMarkerResultParam rtsaMarkerResultParam = (RtsaMarkerResultParam) list.get(i);
            adapterItemResultMarkerBinding.setParam(rtsaMarkerResultParam);
            ItemAdapter itemAdapter = (ItemAdapter) adapterItemResultMarkerBinding.resultList.getAdapter();
            if (itemAdapter != null) {
                itemAdapter.setItems(rtsaMarkerResultParam.getData());
                itemAdapter.notifyDataSetChanged();
            }
        }

        @Override // com.rigol.scope.adapters.BaseAdapterDelegate, com.rigol.scope.adapters.AdapterDelegate
        protected BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup) {
            BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup);
            AdapterItemResultMarkerBinding adapterItemResultMarkerBinding = (AdapterItemResultMarkerBinding) onCreateViewHolder.getBinding();
            adapterItemResultMarkerBinding.resultList.setAdapter(new ItemAdapter(adapterItemResultMarkerBinding.getRoot().getContext(), new ArrayList(), R.layout.adapter_item_result_item_towview));
            return onCreateViewHolder;
        }
    }

    /* loaded from: classes.dex */
    public static class BaseMeasureAdapterDelegate extends BaseAdapterDelegate<List<ResultParam>> {
        private int selectedPosition;

        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<ResultParam> list, int i) {
            return false;
        }

        @Override // com.rigol.scope.adapters.AdapterDelegate
        protected /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public BaseMeasureAdapterDelegate(int i) {
            super(i);
            this.selectedPosition = -1;
        }

        public void setSelectedPosition(int i) {
            this.selectedPosition = i;
        }

        protected void onBindViewHolder(List<ResultParam> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            ViewDataBinding binding = baseViewHolder.getBinding();
            if (binding != null) {
                binding.getRoot().setSelected(i == this.selectedPosition);
            }
        }
    }
}
