package com.rigol.scope.views.analyse;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.PopupviewAnalyseUsbResultBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.viewmodels.BusAnalyseViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.busAnalyse.BusAnalyseParam;
import com.rigol.scope.views.save.SavePopupView;
import java.io.File;
/* loaded from: classes2.dex */
public class AnalyseUsbResultPopupView extends BasePopupView implements View.OnClickListener {
    private PopupviewAnalyseUsbResultBinding binding;
    private BusAnalyseParam param;

    public AnalyseUsbResultPopupView() {
        super((int) R.style.App_PopupWindow_Analyse_usb_result);
        PopupviewAnalyseUsbResultBinding inflate = PopupviewAnalyseUsbResultBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.busAnalyseUsbResultSave.setOnClickListener(this);
        BusAnalyseViewModel busAnalyseViewModel = (BusAnalyseViewModel) ContextUtil.getAppViewModel(BusAnalyseViewModel.class);
        if (busAnalyseViewModel != null) {
            busAnalyseViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer<BusAnalyseParam>() { // from class: com.rigol.scope.views.analyse.AnalyseUsbResultPopupView.1
                @Override // androidx.lifecycle.Observer
                public void onChanged(BusAnalyseParam busAnalyseParam) {
                    AnalyseUsbResultPopupView.this.param = busAnalyseParam;
                    AnalyseUsbResultPopupView.this.binding.setParam(AnalyseUsbResultPopupView.this.param.getUsb());
                    String str = "/mnt/tmp/AnalyseImage/usbHighEye.bmp";
                    String str2 = "/mnt/tmp/AnalyseImage/usbHighPlot.bmp";
                    if (AnalyseUsbResultPopupView.this.param != null) {
                        int usb_type = AnalyseUsbResultPopupView.this.param.getUsb().getUsb_type();
                        if (usb_type == 0 || usb_type == 1) {
                            str2 = "/mnt/tmp/AnalyseImage/usbLowPlot.bmp";
                            str = "/mnt/tmp/AnalyseImage/usbLowEye.bmp";
                        } else if (usb_type == 2 || usb_type == 3) {
                            str2 = "/mnt/tmp/AnalyseImage/usbFullPlot.bmp";
                            str = "/mnt/tmp/AnalyseImage/usbFullEye.bmp";
                        } else if (usb_type != 4) {
                        }
                    }
                    AnalyseUsbResultPopupView.this.binding.polt.setImageBitmap(AnalyseUsbResultPopupView.this.getDiskBitmap(str2));
                    AnalyseUsbResultPopupView.this.binding.eye.setImageBitmap(AnalyseUsbResultPopupView.this.getDiskBitmap(str));
                }
            });
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow
    public void showAtLocation(View view, int i, int i2, int i3) {
        super.showAtLocation(view, i, i2, i3);
        PopupviewAnalyseUsbResultBinding popupviewAnalyseUsbResultBinding = this.binding;
        if (popupviewAnalyseUsbResultBinding != null) {
            popupviewAnalyseUsbResultBinding.getRoot().post(new Runnable() { // from class: com.rigol.scope.views.analyse.-$$Lambda$AnalyseUsbResultPopupView$Tha7ZnHW8A1nry-d5wBJrK-IyrE
                @Override // java.lang.Runnable
                public final void run() {
                    AnalyseUsbResultPopupView.this.updateContent();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateContent() {
        if (this.titleView != null) {
            this.titleView.setText(getTitle());
        }
        BusAnalyseParam busAnalyseParam = this.param;
        String str = "/mnt/tmp/AnalyseImage/usbHighEye.bmp";
        String str2 = "/mnt/tmp/AnalyseImage/usbHighPlot.bmp";
        if (busAnalyseParam != null) {
            int usb_type = busAnalyseParam.getUsb().getUsb_type();
            if (usb_type == 0 || usb_type == 1) {
                str2 = "/mnt/tmp/AnalyseImage/usbLowPlot.bmp";
                str = "/mnt/tmp/AnalyseImage/usbLowEye.bmp";
            } else if (usb_type == 2 || usb_type == 3) {
                str2 = "/mnt/tmp/AnalyseImage/usbFullPlot.bmp";
                str = "/mnt/tmp/AnalyseImage/usbFullEye.bmp";
            } else if (usb_type != 4) {
            }
        }
        this.binding.polt.setImageBitmap(getDiskBitmap(str2));
        this.binding.eye.setImageBitmap(getDiskBitmap(str));
        showTable();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap getDiskBitmap(String str) {
        try {
            if (new File(str).exists()) {
                return BitmapFactory.decodeFile(str);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00dc A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00dd A[Catch: Exception -> 0x0127, TryCatch #0 {Exception -> 0x0127, blocks: (B:13:0x0093, B:15:0x0099, B:27:0x00b4, B:30:0x00c5, B:33:0x00dd, B:35:0x00e6, B:37:0x00ea, B:40:0x00ee, B:42:0x00ff, B:44:0x0103, B:46:0x010a, B:45:0x0107, B:51:0x011b, B:47:0x010d, B:48:0x0111, B:50:0x0115, B:52:0x0120, B:28:0x00bc), top: B:57:0x0093 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void showTable() {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.analyse.AnalyseUsbResultPopupView.showTable():void");
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public int getTitle() {
        BusAnalyseParam busAnalyseParam = this.param;
        if (busAnalyseParam != null) {
            int usb_type = busAnalyseParam.getUsb().getUsb_type();
            int usb_point = this.param.getUsb().getUsb_point();
            if (usb_type != 1) {
                if (usb_type == 3) {
                    return R.string.msg_usb_analyse_result_1_1;
                }
                if (usb_type != 4 || usb_point != 0) {
                    if (usb_type == 4 && usb_point == 1) {
                        return R.string.msg_usb_analyse_result_far_2_0;
                    }
                    if (usb_type != 5 || usb_point != 0) {
                        if (usb_type == 5 && usb_point == 1) {
                            return R.string.msg_usb_analyse_result_far_2_0;
                        }
                    }
                }
                return R.string.msg_usb_analyse_result_near_2_0;
            }
        }
        return R.string.msg_usb_analyse_result_1_0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StorageSaveParam value;
        if (view.getId() != R.id.bus_analyse_usb_result_save) {
            return;
        }
        StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
        if (storageViewModel != null && (value = storageViewModel.getSaveLiveData().getValue()) != null) {
            value.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_HTML);
            value.saveFileType(ServiceEnum.enFileType.FILETYPE_HTML.value1);
        }
        PopupViewManager.getInstance().toggle(SavePopupView.class);
    }
}
