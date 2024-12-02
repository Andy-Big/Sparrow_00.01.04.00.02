package com.rigol.scope.views.busAnalyse;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.Bindable;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BaseParam;
import com.rigol.scope.utilities.ColorUtil;

/* loaded from: classes2.dex */
public class BusAnalyseUsbParam extends BaseParam {
    private static final int DEFAULT_USBDIFF = 1;
    private static final int DEFAULT_USBDP = 1;
    private static final int DEFAULT_USBDS = 2;
    private static final int DEFAULT_USBPOINT = 1;
    private static final int DEFAULT_USBTYPE = 0;
    private long srcHscale;
    private long srcVscale;
    private boolean usb_auto_set;
    private int usb_diff_source;
    private int usb_point;
    private int usb_source_dp;
    private int usb_source_ds;
    private boolean usb_test;
    private int usb_type;

    @Bindable
    public long getSrcVscale() {
        return this.srcVscale;
    }

    public void setSrcVscale(long j) {
        this.srcVscale = j;
        notifyPropertyChanged(899);
    }

    @Bindable
    public long getSrcHscale() {
        return this.srcHscale;
    }

    public void setSrcHscale(long j) {
        this.srcHscale = j;
        notifyPropertyChanged(898);
    }

    public BusAnalyseUsbParam() {
        super(48);
        this.srcVscale = 0L;
        this.srcHscale = 0L;
    }

    @Bindable
    public int getUsb_diff_source() {
        return this.usb_diff_source;
    }

    public void saveUsb_diff_source(int i) {
        this.usb_diff_source = i;
        notifyPropertyChanged(1002);
        saveInt(MessageID.MSG_USB_ANALYSE_DIFF, i);
    }

    @Bindable
    public int getUsb_point() {
        return this.usb_point;
    }

    public void saveUsb_point(int i) {
        this.usb_point = i;
        notifyPropertyChanged(1007);
        saveInt(MessageID.MSG_USB_ANALYSE_POINT, i);
    }

    @Bindable
    public int getUsb_type() {
        return this.usb_type;
    }

    public void setUsb_type(int i) {
        this.usb_type = i;
        notifyPropertyChanged(1011);
    }

    public void saveUsb_type(int i) {
        setUsb_type(i);
        saveInt(MessageID.MSG_USB_ANALYSE_TYPE, i);
    }

    public boolean isUsb_auto_set() {
        return this.usb_auto_set;
    }

    public void saveUsb_auto_set(boolean z) {
        this.usb_auto_set = z;
        saveBool(MessageID.MSG_USB_ANALYSE_AUTO_SET, z);
    }

    public boolean isUsb_test() {
        return this.usb_test;
    }

    public void saveUsb_test(boolean z) {
        this.usb_test = z;
    }

    @Bindable
    public int getUsb_source_dp() {
        return this.usb_source_dp;
    }

    public void saveUsb_source_dp(int i) {
        this.usb_source_dp = i;
        notifyPropertyChanged(1009);
        saveInt(MessageID.MSG_USB_ANALYSE_DP, i);
    }

    @Bindable
    public int getUsb_source_ds() {
        return this.usb_source_ds;
    }

    public void saveUsb_source_ds(int i) {
        this.usb_source_ds = i;
        notifyPropertyChanged(1010);
        saveInt(MessageID.MSG_USB_ANALYSE_DS, i);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        this.usb_type = readInt(MessageID.MSG_USB_ANALYSE_TYPE);
        this.usb_source_dp = readInt(MessageID.MSG_USB_ANALYSE_DP);
        this.usb_source_ds = readInt(MessageID.MSG_USB_ANALYSE_DS);
        this.usb_point = readInt(MessageID.MSG_USB_ANALYSE_POINT);
        this.usb_diff_source = readInt(MessageID.MSG_USB_ANALYSE_DIFF);
    }

    public void setChanColor(View view, ServiceEnum.Chan chan) {
        if (chan != null) {
            ((TextView) view).setTextColor(ColorUtil.getColor(view.getContext(), chan));
        }
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setUsb_type(0);
        saveUsb_diff_source(1);
        saveUsb_point(1);
        saveUsb_source_dp(1);
        saveUsb_source_ds(2);
    }
}
