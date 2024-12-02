package com.rigol.scope;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.DiskParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UtilityUtil;
import com.rigol.scope.viewmodels.DiskManageViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.FileSaveLoading;
import com.rigol.scope.views.LoadingPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.util.DiskUtil;
import com.rigol.util.ToastUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: UsbReceiver.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0004H\u0002¨\u0006\n"}, d2 = {"Lcom/rigol/scope/UsbReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "updateDiskPath", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class UsbReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        LiveData<DiskManageParam> liveData;
        DiskManageParam value;
        LiveData<SharedParam> liveData2;
        SharedParam value2;
        LiveData<DiskManageParam> liveData3;
        DiskManageParam value3;
        LiveData<SharedParam> liveData4;
        SharedParam value4;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (ActivityUtils.getTopActivity() == null) {
            return;
        }
        if (Intrinsics.areEqual("android.intent.action.MEDIA_MOUNTED", action)) {
            ToastUtils.showShort((int) R.string.inf_usb_storage_connect);
            SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
            if (sharedViewModel != null && (liveData4 = sharedViewModel.getLiveData()) != null && (value4 = liveData4.getValue()) != null) {
                value4.setShowUsb(DiskUtil.INSTANCE.hasRemovableDisk());
            }
            updateDiskPath();
            DiskManageViewModel diskManageViewModel = (DiskManageViewModel) ContextUtil.getAppViewModel(DiskManageViewModel.class);
            if (diskManageViewModel == null || (liveData3 = diskManageViewModel.getLiveData()) == null || (value3 = liveData3.getValue()) == null) {
                return;
            }
            value3.loadFiles();
        } else if (Intrinsics.areEqual("android.intent.action.MEDIA_UNMOUNTED", action)) {
            ToastUtils.showShort((int) R.string.inf_usb_storage_disconnect);
            SharedViewModel sharedViewModel2 = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
            if (sharedViewModel2 != null && (liveData2 = sharedViewModel2.getLiveData()) != null && (value2 = liveData2.getValue()) != null) {
                value2.setShowUsb(DiskUtil.INSTANCE.hasRemovableDisk());
            }
            updateDiskPath();
            DiskManageViewModel diskManageViewModel2 = (DiskManageViewModel) ContextUtil.getAppViewModel(DiskManageViewModel.class);
            if (diskManageViewModel2 == null || (liveData = diskManageViewModel2.getLiveData()) == null || (value = liveData.getValue()) == null) {
                return;
            }
            value.loadFiles();
        }
    }

    private final void updateDiskPath() {
        MutableLiveData<StorageSaveParam> saveLiveData;
        StorageSaveParam value;
        BasePopupView basePopupView;
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel == null || (saveLiveData = storageViewModel.getSaveLiveData()) == null || (value = saveLiveData.getValue()) == null) {
            return;
        }
        Intrinsics.checkNotNullExpressionValue(value, "saveLiveData.value ?: return");
        DiskParam firstUsbDisk = UtilityUtil.getFirstUsbDisk();
        if (firstUsbDisk == null) {
            value.setPathName(DiskManageParam.DEFAULT_PATH);
        } else {
            value.setPathName(firstUsbDisk.getPath());
        }
        PopupViewManager popupViewManager = PopupViewManager.getInstance();
        if (popupViewManager == null || (basePopupView = popupViewManager.get(FileSaveLoading.class)) == null) {
            return;
        }
        String pathName = value.getPathName();
        Intrinsics.checkNotNullExpressionValue(pathName, "saveParam.pathName");
        if (StringsKt.startsWith$default(pathName, DiskManageParam.DEFAULT_PATH, false, 2, (Object) null)) {
            if (basePopupView == null) {
                throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.views.LoadingPopupView");
            }
            ((LoadingPopupView) basePopupView).isShowWrning().set(false);
        } else if (basePopupView != null) {
            LoadingPopupView loadingPopupView = (LoadingPopupView) basePopupView;
            loadingPopupView.isShowWrning().set(true);
            loadingPopupView.setWrningResId(R.string.msg_storage_usb);
        } else {
            throw new NullPointerException("null cannot be cast to non-null type com.rigol.scope.views.LoadingPopupView");
        }
    }
}
