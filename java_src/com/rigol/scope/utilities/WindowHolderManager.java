package com.rigol.scope.utilities;

import android.app.Activity;
import androidx.collection.SimpleArrayMap;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.MainActivity;
import com.rigol.scope.WaveformFragment;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.views.window.WindowHolder;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class WindowHolderManager {
    private static WindowHolderManager INSTANCE;
    private final SimpleArrayMap<ServiceEnum.WindowType, CopyOnWriteArrayList<WindowHolder>> windowHolders = new SimpleArrayMap<>();

    private WindowHolderManager() {
    }

    public static WindowHolderManager getInstance() {
        if (INSTANCE == null) {
            synchronized (WindowHolderManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new WindowHolderManager();
                }
            }
        }
        return INSTANCE;
    }

    public List<WindowHolder> get(ServiceEnum.WindowType windowType) {
        return this.windowHolders.get(windowType);
    }

    public List<WindowHolder> get(WindowParam windowParam) {
        if (windowParam == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<WindowHolder> list = get(windowParam.getType());
        if (list == null) {
            return null;
        }
        for (WindowHolder windowHolder : list) {
            if (windowHolder != null) {
                switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[windowParam.getType().ordinal()]) {
                    case 1:
                        if (windowParam.getServiceID() == windowHolder.getWindowParam().getServiceID()) {
                            if (windowParam.getSource1() == windowHolder.getWindowParam().getSource1()) {
                                arrayList.add(windowHolder);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            continue;
                        }
                    case 2:
                        if (windowParam.getServiceID() == windowHolder.getWindowParam().getServiceID()) {
                            if (windowParam.getSource1() == windowHolder.getWindowParam().getSource1() && windowParam.getSource2() == windowHolder.getWindowParam().getSource2()) {
                                arrayList.add(windowHolder);
                                break;
                            }
                        } else {
                            continue;
                        }
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (windowParam.getSource1() == windowHolder.getWindowParam().getSource1()) {
                            arrayList.add(windowHolder);
                            break;
                        } else {
                            continue;
                        }
                    default:
                        arrayList.add(windowHolder);
                        continue;
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.utilities.WindowHolderManager$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType;

        static {
            int[] iArr = new int[ServiceEnum.WindowType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType = iArr;
            try {
                iArr[ServiceEnum.WindowType.WIN_DECODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_FFT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_EYE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_ALL_MEASURE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_SEARCH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_MATH_PEAKSEARCH.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public boolean contains(WindowHolder windowHolder) {
        CopyOnWriteArrayList<WindowHolder> copyOnWriteArrayList;
        if (windowHolder == null || (copyOnWriteArrayList = this.windowHolders.get(windowHolder.getWindowParam().getType())) == null) {
            return false;
        }
        for (WindowHolder windowHolder2 : copyOnWriteArrayList) {
            if (windowHolder2 != null) {
                switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[windowHolder.getWindowParam().getType().ordinal()]) {
                    case 1:
                        if (windowHolder.getWindowParam().getServiceID() != windowHolder2.getWindowParam().getServiceID()) {
                            continue;
                        } else if (windowHolder.getWindowParam().getSource1() != windowHolder2.getWindowParam().getSource1()) {
                            break;
                        } else {
                            return true;
                        }
                    case 2:
                        if (windowHolder.getWindowParam().getServiceID() != windowHolder2.getWindowParam().getServiceID()) {
                            continue;
                        } else if (windowHolder.getWindowParam().getSource1() == windowHolder2.getWindowParam().getSource1() && windowHolder.getWindowParam().getSource2() == windowHolder2.getWindowParam().getSource2()) {
                            return true;
                        }
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        if (windowHolder.getWindowParam().getSource1() == windowHolder2.getWindowParam().getSource1()) {
                            return true;
                        }
                        continue;
                    case 7:
                        if (windowHolder.getWindowParam().getSource1() != windowHolder2.getWindowParam().getSource1()) {
                            continue;
                        } else if (windowHolder.getWindowParam().getSource2() != windowHolder2.getWindowParam().getSource2()) {
                            break;
                        } else {
                            return true;
                        }
                    case 8:
                        if (windowHolder.getWindowParam().getServiceID() == windowHolder2.getWindowParam().getServiceID()) {
                            return true;
                        }
                        continue;
                    default:
                        return true;
                }
            }
        }
        return false;
    }

    public void add(WindowHolder windowHolder) {
        if (contains(windowHolder)) {
            return;
        }
        CopyOnWriteArrayList<WindowHolder> copyOnWriteArrayList = this.windowHolders.get(windowHolder.getWindowParam().getType());
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.windowHolders.put(windowHolder.getWindowParam().getType(), copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(windowHolder);
    }

    public void removeAll() {
        for (int i = 0; i < this.windowHolders.size(); i++) {
            ServiceEnum.WindowType keyAt = this.windowHolders.keyAt(i);
            if (keyAt != ServiceEnum.WindowType.WIN_MAIN_WAVEFORM) {
                LogUtils.e("removeAll", "removeAll");
                remove(keyAt);
            }
        }
    }

    public void remove(ServiceEnum.WindowType windowType) {
        CopyOnWriteArrayList<WindowHolder> copyOnWriteArrayList;
        if (windowType == null || (copyOnWriteArrayList = this.windowHolders.get(windowType)) == null || copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (WindowHolder windowHolder : copyOnWriteArrayList) {
            if (windowHolder != null && windowHolder.getWindowParam().getType() == windowType) {
                remove(windowHolder);
            }
        }
    }

    public void remove(WindowHolder windowHolder) {
        WaveformFragment waveformFragment;
        if (windowHolder.getWindowParam().getType() == ServiceEnum.WindowType.WIN_SEARCH) {
            SearchParam value = ((SearchViewModel) ContextUtil.getAppViewModel(SearchViewModel.class)).getLiveData().getValue();
            value.saveNavigation(value.readNavigation());
        }
        if (windowHolder == null) {
            return;
        }
        CopyOnWriteArrayList<WindowHolder> copyOnWriteArrayList = this.windowHolders.get(windowHolder.getWindowParam().getType());
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.remove(windowHolder);
        }
        Activity topActivity = ActivityUtils.getTopActivity();
        if ((topActivity instanceof MainActivity) && (waveformFragment = ((MainActivity) topActivity).getWaveformFragment()) != null) {
            waveformFragment.getBinding().multiWindow.removeWindow(windowHolder);
        }
        ViewUtil.getFlexKnobParamViewModel().refreshCHList();
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.utilities.-$$Lambda$WindowHolderManager$ekkoI8RNtTkzMdrP1oBORpcpvu4
            @Override // java.lang.Runnable
            public final void run() {
                MessageBus.getInstance().onSyncData(MessageBus.getKey(60, MessageID.MSG_LA_ENABLE), true);
            }
        }, 200L);
    }

    public int size(ServiceEnum.WindowType windowType) {
        List<WindowHolder> list = get(windowType);
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return list.size();
    }

    public int size(ServiceEnum.WindowType windowType, int i) {
        WindowParam windowParam;
        List<WindowHolder> list = get(windowType);
        int i2 = 0;
        if (list != null && !list.isEmpty()) {
            for (WindowHolder windowHolder : list) {
                if (windowHolder != null && (windowParam = windowHolder.getWindowParam()) != null && windowParam.getServiceID() == i) {
                    i2++;
                }
            }
        }
        return i2;
    }

    public void onLocaleChanged() {
        for (int i = 0; i < this.windowHolders.size(); i++) {
            for (WindowHolder windowHolder : this.windowHolders.valueAt(i)) {
                if (windowHolder != null) {
                    windowHolder.onLocaleChanged();
                }
            }
        }
    }
}
