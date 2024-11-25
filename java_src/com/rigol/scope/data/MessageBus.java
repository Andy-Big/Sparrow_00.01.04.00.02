package com.rigol.scope.data;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.rigol.scope.adapters.ResultListAdapter;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/* loaded from: classes2.dex */
public class MessageBus {
    private static final MessageBus DEFAULT = new MessageBus();
    public static final String SYNC_DATA_KEY_FUNCTION_ITEM_CLICK = "_sync_function_item_click";
    public static final String SYNC_DATA_KEY_FUNCTION_ITEM_LONG_CLICK = "_sync_function_item_long_click";
    public static final String SYNC_DATA_KEY_MOTOR_FORWARD = "_sync_motor_forward";
    public static final String SYNC_DATA_KEY_MOTOR_RECOVERY = "_sync_motor_recovery";
    public static final String SYNC_DATA_KEY_MOTOR_REVERSE = "_sync_motor_reverse";
    public static final String SYNC_DATA_KEY_MOTOR_SET_POSITION = "_sync_motor_set_position";
    private boolean useQueue = true;
    private final List<ViewModelProvider> providers = new ArrayList();
    private final Queue<String> cachedQueue = new LinkedList();

    public static MessageBus getInstance() {
        return DEFAULT;
    }

    private MessageBus() {
    }

    public synchronized ViewModelProvider with(ViewModelProvider viewModelProvider) {
        if (!this.providers.contains(viewModelProvider)) {
            this.providers.add(viewModelProvider);
        }
        return viewModelProvider;
    }

    public synchronized <T extends ViewModel> T with(ViewModelProvider viewModelProvider, Class<T> cls) {
        return (T) with(viewModelProvider).get(cls);
    }

    public void setUseQueue(boolean z) {
        this.useQueue = z;
    }

    public boolean isUseQueue() {
        return this.useQueue;
    }

    public Queue<String> getCachedQueue() {
        return this.cachedQueue;
    }

    public static String getKey(int i, int i2) {
        return i + "_" + i2;
    }

    public static String getKey(int i, int i2, int i3) {
        return i + "_" + i2 + "_" + i3;
    }

    public static String getKey(int i, int i2, long j) {
        return i + "_" + i2 + "_" + j;
    }

    public List<MutableLiveData<Boolean>> get(int i, int i2) {
        return get(getKey(i, i2));
    }

    public List<MutableLiveData<Boolean>> get(String str) {
        List<MutableLiveData<Boolean>> synchronizedList = Collections.synchronizedList(new ArrayList());
        for (ViewModelProvider viewModelProvider : this.providers) {
            MutableLiveData<Boolean> mutableLiveData = ((UpdateUIViewModel) viewModelProvider.get(UpdateUIViewModel.class)).get(str);
            if (mutableLiveData != null) {
                synchronizedList.add(mutableLiveData);
            }
        }
        return synchronizedList;
    }

    public List<MutableLiveData<Object>> get2(String str) {
        List<MutableLiveData<Object>> synchronizedList = Collections.synchronizedList(new ArrayList());
        for (ViewModelProvider viewModelProvider : this.providers) {
            MutableLiveData<Object> mutableLiveData = ((SyncDataViewModel) viewModelProvider.get(SyncDataViewModel.class)).get(str);
            if (mutableLiveData != null) {
                synchronizedList.add(mutableLiveData);
            }
        }
        return synchronizedList;
    }

    public void onUpdateUI(int i, int i2, boolean z) {
        onUpdateUI(getKey(i, i2), z);
    }

    public void onUpdateUI(int i, int i2, int i3, boolean z) {
        onUpdateUI(getKey(i, i2, i3), z);
    }

    public void onUpdateUI(int i, int i2, long j, boolean z) {
        onUpdateUI(getKey(i, i2, j), z);
    }

    public void onUpdateUI(String str, boolean z) {
        str.equals(ResultListAdapter.ON_ITEM_DATA_BODE_KEY);
        if (isUseQueue()) {
            getCachedQueue().offer(str);
            return;
        }
        for (MutableLiveData<Boolean> mutableLiveData : get(str)) {
            if (mutableLiveData != null) {
                mutableLiveData.postValue(Boolean.valueOf(z));
            }
        }
    }

    public void onSyncData(String str, Object obj) {
        for (MutableLiveData<Object> mutableLiveData : get2(str)) {
            if (mutableLiveData != null) {
                mutableLiveData.postValue(obj);
            }
        }
    }

    public void onSyncData(int i, int i2, Object obj) {
        onSyncData(getKey(i, i2), obj);
    }
}
