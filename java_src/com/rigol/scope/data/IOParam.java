package com.rigol.scope.data;

import android.app.Activity;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.databinding.Bindable;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.scope.cil.MessageAttr;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.NsdRegistrationListenerAdapter;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.UtilityViewModel;
import java.net.InetAddress;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.jmdns.impl.JmDNSImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: IOParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010R\u001a\u00020SJ\u000e\u0010T\u001a\u00020S2\u0006\u0010\u0003\u001a\u00020 J\b\u0010U\u001a\u00020SH\u0016J\u0006\u0010V\u001a\u00020 J\u0006\u0010W\u001a\u00020\u0004J\u0006\u0010X\u001a\u00020 J\u0006\u0010Y\u001a\u00020\rJ\u0006\u0010Z\u001a\u00020\u0004J\u0006\u0010[\u001a\u00020\u0004J\u0006\u0010\\\u001a\u00020\u0004J\u0006\u0010]\u001a\u00020\u0004J\b\u0010^\u001a\u00020\u0004H\u0002J\u0006\u0010_\u001a\u00020\u0004J\u0006\u0010`\u001a\u00020\rJ\b\u0010a\u001a\u00020\u0004H\u0002J\u0006\u0010b\u001a\u00020 J\u0006\u0010c\u001a\u00020FJ\u0006\u0010d\u001a\u00020\u0004J\u0006\u0010e\u001a\u00020 J\b\u0010f\u001a\u00020SH\u0002J\u000e\u0010g\u001a\u00020S2\u0006\u0010h\u001a\u00020 J\u000e\u0010i\u001a\u00020S2\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010j\u001a\u00020S2\u0006\u0010k\u001a\u00020 J\u000e\u0010l\u001a\u00020S2\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010m\u001a\u00020S2\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010n\u001a\u00020S2\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010o\u001a\u00020S2\u0006\u0010\u001d\u001a\u00020\u0004J\u000e\u0010p\u001a\u00020S2\u0006\u0010/\u001a\u00020\u0004J\u000e\u0010q\u001a\u00020S2\u0006\u00105\u001a\u00020\u0004J\u000e\u0010r\u001a\u00020S2\u0006\u0010@\u001a\u00020\rJ\u000e\u0010s\u001a\u00020S2\u0006\u0010t\u001a\u00020 J\u000e\u0010u\u001a\u00020S2\u0006\u0010G\u001a\u00020FJ\u000e\u0010v\u001a\u00020S2\u0006\u0010w\u001a\u00020 J(\u0010x\u001a\u00020S2\u0006\u0010y\u001a\u00020z2\u0006\u0010C\u001a\u00020\u00042\u0006\u0010{\u001a\u00020\u00042\u0006\u0010|\u001a\u00020\rH\u0002R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR&\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR&\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR&\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R&\u0010%\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R&\u0010'\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\"\"\u0004\b(\u0010$R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R&\u0010/\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR&\u00102\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0007\"\u0004\b4\u0010\tR&\u00105\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0007\"\u0004\b7\u0010\tR&\u00108\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\"\"\u0004\b:\u0010$R\u000e\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020<X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010@\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\r8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u0012R&\u0010C\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0007\"\u0004\bE\u0010\tR&\u0010G\u001a\u00020F2\u0006\u0010\u0003\u001a\u00020F8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR&\u0010L\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020 8G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\"\"\u0004\bN\u0010$R&\u0010O\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\t¨\u0006}"}, d2 = {"Lcom/rigol/scope/data/IOParam;", "Lcom/rigol/scope/data/BaseParam;", "()V", "value", "", "dns", "getDns", "()Ljava/lang/String;", "setDns", "(Ljava/lang/String;)V", "gateway", "getGateway", "setGateway", "", "gpib", "getGpib", "()I", "setGpib", "(I)V", "gpibAttr", "Lcom/rigol/scope/cil/MessageAttr;", "getGpibAttr", "()Lcom/rigol/scope/cil/MessageAttr;", "gpibStr", "getGpibStr", "setGpibStr", "hostName", "getHostName", "setHostName", "ipAddress", "getIpAddress", "setIpAddress", "", "isAutoSelected", "()Z", "setAutoSelected", "(Z)V", "isDHCPSelected", "setDHCPSelected", "isStaticSelected", "setStaticSelected", "jmDNS", "Ljavax/jmdns/impl/JmDNSImpl;", "getJmDNS", "()Ljavax/jmdns/impl/JmDNSImpl;", "setJmDNS", "(Ljavax/jmdns/impl/JmDNSImpl;)V", "macAddress", "getMacAddress", "setMacAddress", "manufacturer", "getManufacturer", "setManufacturer", "mask", "getMask", "setMask", "mdns", "getMdns", "setMdns", "registerationHttpListener", "Lcom/rigol/scope/utilities/NsdRegistrationListenerAdapter;", "registerationLxiListener", "registerationScpiListener", "registerationVxiListener", "select", "getSelect", "setSelect", "serviceName", "getServiceName", "setServiceName", "Lcom/rigol/scope/cil/ServiceEnum$tagNET_STATUS_EN;", NotificationCompat.CATEGORY_STATUS, "getStatus", "()Lcom/rigol/scope/cil/ServiceEnum$tagNET_STATUS_EN;", "setStatus", "(Lcom/rigol/scope/cil/ServiceEnum$tagNET_STATUS_EN;)V", "valid", "getValid", "setValid", "visaAddress", "getVisaAddress", "setVisaAddress", "apply", "", "applyMdns", "readAll", "readAuto", "readDNS", "readDhcp", "readGPIB", "readGateWay", "readHostName", "readIPAddress", "readMacAddress", "readManufacturer", "readMask", "readSelect", "readServiceName", "readStatic", "readStatues", "readVISAAddress", "readmDns", "resetSelect", "saveAuto", DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "saveDNS", "saveDhcp", "dhcp", "saveGPIB", "saveGateWay", "saveHostName", "saveIPAddress", "saveMacAddress", "saveMask", "saveSelect", "saveStatic", "static", "saveStatus", "savemDns", "mDns", "setNsdServiceInfo", "serviceInfo", "Landroid/net/nsd/NsdServiceInfo;", "serviceType", "port", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class IOParam extends BaseParam {
    private String dns;
    private String gateway;
    private int gpib;
    private final MessageAttr gpibAttr;
    private String gpibStr;
    private String hostName;
    private String ipAddress;
    private boolean isAutoSelected;
    private boolean isDHCPSelected;
    private boolean isStaticSelected;
    private JmDNSImpl jmDNS;
    private String macAddress;
    private String manufacturer;
    private String mask;
    private boolean mdns;
    private final NsdRegistrationListenerAdapter registerationHttpListener;
    private final NsdRegistrationListenerAdapter registerationLxiListener;
    private final NsdRegistrationListenerAdapter registerationScpiListener;
    private final NsdRegistrationListenerAdapter registerationVxiListener;
    private int select;
    private String serviceName;
    private ServiceEnum.tagNET_STATUS_EN status;
    private boolean valid;
    private String visaAddress;

    public IOParam() {
        super(47);
        this.macAddress = "";
        this.visaAddress = "";
        this.status = ServiceEnum.tagNET_STATUS_EN.NET_STATUS_UNLINK;
        this.select = 3;
        this.isDHCPSelected = true & true;
        this.isAutoSelected = (this.select & 2) == 2;
        this.isStaticSelected = (this.select & 4) == 4;
        this.valid = true;
        this.ipAddress = "";
        this.mask = "";
        this.gateway = "";
        this.dns = "";
        this.registerationLxiListener = new NsdRegistrationListenerAdapter();
        this.registerationHttpListener = new NsdRegistrationListenerAdapter();
        this.registerationScpiListener = new NsdRegistrationListenerAdapter();
        this.registerationVxiListener = new NsdRegistrationListenerAdapter();
        this.hostName = "";
        this.gpib = 1;
        this.gpibStr = "";
        this.gpibAttr = new MessageAttr();
        this.serviceName = "";
        this.manufacturer = "";
    }

    @Bindable
    public final String getMacAddress() {
        return this.macAddress;
    }

    public final void setMacAddress(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("macAddress", this.macAddress, value);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.getDefault()");
        String upperCase = value.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        this.macAddress = upperCase;
        notifyPropertyChanged(513);
    }

    @Bindable
    public final String getVisaAddress() {
        return this.visaAddress;
    }

    public final void setVisaAddress(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("visaAddress", this.visaAddress, value);
        this.visaAddress = value;
        notifyPropertyChanged(1034);
    }

    @Bindable
    public final ServiceEnum.tagNET_STATUS_EN getStatus() {
        return this.status;
    }

    public final void setStatus(ServiceEnum.tagNET_STATUS_EN value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log(NotificationCompat.CATEGORY_STATUS, this.status, value);
        this.status = value;
        notifyPropertyChanged(909);
    }

    @Bindable
    public final int getSelect() {
        return this.select;
    }

    public final void setSelect(int i) {
        log("select", Integer.valueOf(this.select), Integer.valueOf(i));
        this.select = i;
        notifyPropertyChanged(787);
    }

    @Bindable
    public final boolean isDHCPSelected() {
        return this.isDHCPSelected;
    }

    public final void setDHCPSelected(boolean z) {
        log("isDHCPSelected", Boolean.valueOf(this.isDHCPSelected), Boolean.valueOf(z));
        this.isDHCPSelected = z;
        setValid(true);
        notifyPropertyChanged(213);
    }

    @Bindable
    public final boolean isAutoSelected() {
        return this.isAutoSelected;
    }

    public final void setAutoSelected(boolean z) {
        log("isAutoSelected", Boolean.valueOf(this.isAutoSelected), Boolean.valueOf(z));
        this.isAutoSelected = z;
        setValid(true);
        notifyPropertyChanged(62);
    }

    @Bindable
    public final boolean isStaticSelected() {
        return this.isStaticSelected;
    }

    public final void setStaticSelected(boolean z) {
        log("isStaticSelected", Boolean.valueOf(this.isStaticSelected), Boolean.valueOf(z));
        this.isStaticSelected = z;
        setValid(true);
        notifyPropertyChanged(907);
    }

    private final void resetSelect() {
        int i = this.isDHCPSelected ? 1 : 0;
        if (this.isAutoSelected) {
            i |= 2;
        }
        if (this.isStaticSelected) {
            i |= 4;
        }
        setSelect(i);
    }

    @Bindable
    public final boolean getValid() {
        return this.valid;
    }

    public final void setValid(boolean z) {
        log("valid", Boolean.valueOf(this.valid), Boolean.valueOf(z));
        this.valid = z;
        notifyPropertyChanged(1014);
    }

    @Bindable
    public final String getIpAddress() {
        return this.ipAddress;
    }

    public final void setIpAddress(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("ipAddress", this.ipAddress, value);
        String str = value;
        boolean z = true;
        if (str.length() == 0) {
            str = "0.0.0.0";
        }
        this.ipAddress = str;
        notifyPropertyChanged(447);
        if (!ViewUtil.checkIp(this.ipAddress) || !ViewUtil.checkIp(this.mask) || !ViewUtil.checkIp(this.gateway)) {
            z = false;
        }
        setValid(z);
        if (!this.valid || !this.mdns || TextUtils.isEmpty(this.ipAddress) || TextUtils.isEmpty(this.hostName)) {
            return;
        }
        ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>() { // from class: com.rigol.scope.data.IOParam$ipAddress$2
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                String str2;
                String str3;
                JmDNSImpl jmDNS = IOParam.this.getJmDNS();
                if (jmDNS != null) {
                    jmDNS.unregisterAllServices();
                }
                JmDNSImpl jmDNS2 = IOParam.this.getJmDNS();
                if (jmDNS2 != null) {
                    jmDNS2.close();
                }
                str2 = IOParam.this.ipAddress;
                if (!Intrinsics.areEqual("0.0.0.0", str2)) {
                    try {
                        IOParam iOParam = IOParam.this;
                        str3 = IOParam.this.ipAddress;
                        iOParam.setJmDNS(new JmDNSImpl(InetAddress.getByName(str3), IOParam.this.getHostName()));
                    } catch (Exception unused) {
                        JmDNSImpl jmDNS3 = IOParam.this.getJmDNS();
                        if (jmDNS3 != null) {
                            jmDNS3.unregisterAllServices();
                        }
                        JmDNSImpl jmDNS4 = IOParam.this.getJmDNS();
                        if (jmDNS4 != null) {
                            jmDNS4.close();
                        }
                    }
                }
            }
        }, 31, null);
    }

    @Bindable
    public final String getMask() {
        return this.mask;
    }

    public final void setMask(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("mask", this.mask, value);
        if (value.compareTo("0.0.0.0") == 0) {
            setMask("255.255.255.0");
        } else {
            this.mask = value;
        }
        notifyPropertyChanged(521);
        setValid(ViewUtil.checkIp(this.ipAddress) && ViewUtil.checkIp(this.mask) && ViewUtil.checkIp(this.gateway));
    }

    @Bindable
    public final String getGateway() {
        return this.gateway;
    }

    public final void setGateway(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("gateway", this.gateway, value);
        this.gateway = value;
        notifyPropertyChanged(354);
        setValid(ViewUtil.checkIp(this.ipAddress) && ViewUtil.checkIp(this.mask) && ViewUtil.checkIp(this.gateway));
    }

    @Bindable
    public final String getDns() {
        return this.dns;
    }

    public final void setDns(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("dns", this.dns, value);
        if (ViewUtil.checkIp(value)) {
            this.dns = value;
            notifyPropertyChanged(245);
            setValid(ViewUtil.checkIp(this.ipAddress) && ViewUtil.checkIp(this.mask) && ViewUtil.checkIp(this.gateway));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setNsdServiceInfo(NsdServiceInfo nsdServiceInfo, String str, String str2, int i) {
        LiveData<UtilityParam> liveData;
        nsdServiceInfo.setServiceName(str);
        nsdServiceInfo.setServiceType(str2);
        nsdServiceInfo.setPort(i);
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        UtilityParam value = (utilityViewModel == null || (liveData = utilityViewModel.getLiveData()) == null) ? null : liveData.getValue();
        nsdServiceInfo.setAttribute("Manufacturer", this.manufacturer);
        if (value != null) {
            nsdServiceInfo.setAttribute(ExifInterface.TAG_MODEL, value.getModel());
            nsdServiceInfo.setAttribute("SerialNumber", value.getSerial());
            nsdServiceInfo.setAttribute("FirmwareVersion", value.getSoftVersion());
        }
    }

    public final JmDNSImpl getJmDNS() {
        return this.jmDNS;
    }

    public final void setJmDNS(JmDNSImpl jmDNSImpl) {
        this.jmDNS = jmDNSImpl;
    }

    @Bindable
    public final boolean getMdns() {
        return this.mdns;
    }

    public final void setMdns(boolean z) {
        log("mdns", Boolean.valueOf(this.mdns), Boolean.valueOf(z));
        this.mdns = z;
        notifyPropertyChanged(526);
    }

    @Bindable
    public final String getHostName() {
        return this.hostName;
    }

    public final void setHostName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("hostName", this.hostName, value);
        this.hostName = value;
        notifyPropertyChanged(383);
    }

    @Bindable
    public final int getGpib() {
        return this.gpib;
    }

    public final void setGpib(int i) {
        log("gpib", Integer.valueOf(this.gpib), Integer.valueOf(i));
        this.gpib = i;
        notifyPropertyChanged(356);
        setGpibStr("GPIB::" + this.gpib + "::instr");
    }

    @Bindable
    public final String getGpibStr() {
        return this.gpibStr;
    }

    public final void setGpibStr(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("gpibStr", this.gpibStr, value);
        this.gpibStr = value;
        notifyPropertyChanged(357);
    }

    public final MessageAttr getGpibAttr() {
        return this.gpibAttr;
    }

    @Bindable
    public final String getServiceName() {
        return this.serviceName;
    }

    public final void setServiceName(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("serviceName", this.serviceName, value);
        this.serviceName = value;
        notifyPropertyChanged(811);
    }

    @Bindable
    public final String getManufacturer() {
        return this.manufacturer;
    }

    public final void setManufacturer(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        log("manufacturer", this.manufacturer, value);
        this.manufacturer = value;
        notifyPropertyChanged(518);
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        super.readAll();
        readMacAddress();
        readVISAAddress();
        readDhcp();
        readAuto();
        readStatic();
        readSelect();
        readStatues();
        readIPAddress();
        readMask();
        readGateWay();
        readDNS();
        readmDns();
        readHostName();
        readServiceName();
        readManufacturer();
        readGPIB();
        readAttr(MessageID.MSG_APP_UTILITY_GPIB, this.gpibAttr);
    }

    public final String readMacAddress() {
        setMacAddress(readStr(MessageID.MSG_IO_MAC));
        return this.macAddress;
    }

    public final String readVISAAddress() {
        setVisaAddress(readStr(MessageID.MSG_IO_VISA));
        return this.visaAddress;
    }

    public final boolean readDhcp() {
        setDHCPSelected(readBool(MessageID.MSG_IO_DHCP));
        return this.isDHCPSelected;
    }

    public final boolean readAuto() {
        setAutoSelected(readBool(MessageID.MSG_IO_AUTO));
        return this.isAutoSelected;
    }

    public final boolean readStatic() {
        setStaticSelected(readBool(MessageID.MSG_IO_STATIC));
        return this.isStaticSelected;
    }

    public final ServiceEnum.tagNET_STATUS_EN readStatues() {
        ServiceEnum.tagNET_STATUS_EN tagnet_status_en = ServiceEnum.gettagNET_STATUS_ENFromValue1(readInt(MessageID.MSG_IO_STATUS));
        Intrinsics.checkNotNullExpressionValue(tagnet_status_en, "ServiceEnum.gettagNET_STATUS_ENFromValue1(result)");
        setStatus(tagnet_status_en);
        return this.status;
    }

    public final int readSelect() {
        setSelect(readInt(MessageID.MSG_APP_UTILITY_LXI_CFG));
        return this.select;
    }

    public final String readIPAddress() {
        setIpAddress(readStr(MessageID.MSG_IO_IP));
        return this.ipAddress;
    }

    public final String readMask() {
        setMask(readStr(MessageID.MSG_IO_MASK));
        return this.mask;
    }

    public final String readGateWay() {
        setGateway(readStr(MessageID.MSG_IO_GATEWAY));
        return this.gateway;
    }

    public final String readDNS() {
        setDns(readStr(MessageID.MSG_IO_DNS));
        return this.dns;
    }

    public final boolean readmDns() {
        setMdns(readBool(MessageID.MSG_APP_UTILITY_LXI_MDNS));
        if (this.mdns) {
            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.IOParam$readmDns$1
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkUtils.isAvailableAsync(new Utils.Consumer<Boolean>() { // from class: com.rigol.scope.data.IOParam$readmDns$1.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.blankj.utilcode.util.Utils.Consumer
                        public final void accept(Boolean bool) {
                            if (TextUtils.isEmpty(IOParam.this.getIpAddress()) || TextUtils.isEmpty(IOParam.this.getHostName())) {
                                return;
                            }
                            try {
                                IOParam.this.setJmDNS(new JmDNSImpl(InetAddress.getByName(IOParam.this.getIpAddress()), IOParam.this.getHostName()));
                                IOParam.this.applyMdns(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }, 10000L);
        }
        return this.mdns;
    }

    public final String readHostName() {
        setHostName(readStr(MessageID.MSG_APP_UTILITY_LXI_HOST_NAME));
        return this.hostName;
    }

    public final int readGPIB() {
        setGpib(readInt(MessageID.MSG_APP_UTILITY_GPIB));
        return this.gpib;
    }

    private final String readServiceName() {
        setServiceName(readStr(MessageID.MSG_IO_DESCRIPTION));
        return this.serviceName;
    }

    private final String readManufacturer() {
        setManufacturer("RIGOL TECHNOLOGIES");
        return this.manufacturer;
    }

    public final void saveMacAddress(String macAddress) {
        Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        setMacAddress(macAddress);
        saveStr(MessageID.MSG_IO_MAC, macAddress);
    }

    public final void saveDhcp(boolean z) {
        setDHCPSelected(z);
        resetSelect();
        if (this.select == 0) {
            setSelect(1);
            setDHCPSelected(true);
        }
        saveBool(MessageID.MSG_IO_DHCP, this.isDHCPSelected);
        saveSelect(this.select);
    }

    public final void saveAuto(boolean z) {
        setAutoSelected(z);
        resetSelect();
        if (this.select == 0) {
            setSelect(2);
            setAutoSelected(true);
        }
        saveBool(MessageID.MSG_IO_AUTO, this.isAutoSelected);
        saveSelect(this.select);
    }

    public final void saveStatic(boolean z) {
        setStaticSelected(z);
        resetSelect();
        if (this.select == 0) {
            setSelect(4);
            setStaticSelected(true);
        }
        saveBool(MessageID.MSG_IO_STATIC, this.isStaticSelected);
        saveSelect(this.select);
    }

    public final void saveStatus(ServiceEnum.tagNET_STATUS_EN status) {
        Intrinsics.checkNotNullParameter(status, "status");
        setStatus(status);
        saveInt(MessageID.MSG_IO_STATUS, status.value1);
    }

    public final void saveSelect(int i) {
        setSelect(i);
        saveInt(MessageID.MSG_APP_UTILITY_LXI_CFG, i);
    }

    public final void saveIPAddress(String ipAddress) {
        Intrinsics.checkNotNullParameter(ipAddress, "ipAddress");
        setIpAddress(ipAddress);
        saveStr(MessageID.MSG_IO_IP, ipAddress);
    }

    public final void saveMask(String mask) {
        Intrinsics.checkNotNullParameter(mask, "mask");
        setMask(mask);
        saveStr(MessageID.MSG_IO_MASK, mask);
    }

    public final void saveGateWay(String gateway) {
        Intrinsics.checkNotNullParameter(gateway, "gateway");
        setGateway(gateway);
        saveStr(MessageID.MSG_IO_GATEWAY, gateway);
    }

    public final void saveDNS(String dns) {
        Intrinsics.checkNotNullParameter(dns, "dns");
        setDns(dns);
        saveStr(MessageID.MSG_IO_DNS, dns);
    }

    public final void savemDns(boolean z) {
        setMdns(z);
        saveBool(MessageID.MSG_APP_UTILITY_LXI_MDNS, z);
    }

    public final void saveHostName(String hostName) {
        Intrinsics.checkNotNullParameter(hostName, "hostName");
        setHostName(hostName);
        saveStr(MessageID.MSG_APP_UTILITY_LXI_HOST_NAME, hostName);
    }

    public final void saveGPIB(int i) {
        setGpib(i);
        saveInt(MessageID.MSG_APP_UTILITY_GPIB, i);
    }

    public final void applyMdns(boolean z) {
        if (z) {
            Activity topActivity = ActivityUtils.getTopActivity();
            if (topActivity != null) {
                Object systemService = topActivity.getSystemService("servicediscovery");
                if (systemService == null) {
                    throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
                }
                final NsdManager nsdManager = (NsdManager) systemService;
                try {
                    nsdManager.unregisterService(this.registerationHttpListener);
                    nsdManager.unregisterService(this.registerationLxiListener);
                    nsdManager.unregisterService(this.registerationScpiListener);
                    nsdManager.unregisterService(this.registerationVxiListener);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                final NsdServiceInfo nsdServiceInfo = new NsdServiceInfo();
                ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>() { // from class: com.rigol.scope.data.IOParam$applyMdns$$inlined$let$lambda$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
                    /* renamed from: invoke  reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        NsdServiceInfo nsdServiceInfo2 = nsdServiceInfo;
                        JmDNSImpl jmDNS = this.getJmDNS();
                        nsdServiceInfo2.setHost(jmDNS != null ? jmDNS.getInetAddress() : null);
                    }
                }, 31, null);
                ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.IOParam$applyMdns$$inlined$let$lambda$2
                    @Override // java.lang.Runnable
                    public final void run() {
                        NsdRegistrationListenerAdapter nsdRegistrationListenerAdapter;
                        IOParam iOParam = this;
                        iOParam.setNsdServiceInfo(nsdServiceInfo, iOParam.getServiceName(), "_http._tcp.", 80);
                        NsdManager nsdManager2 = nsdManager;
                        NsdServiceInfo nsdServiceInfo2 = nsdServiceInfo;
                        nsdRegistrationListenerAdapter = this.registerationHttpListener;
                        nsdManager2.registerService(nsdServiceInfo2, 1, nsdRegistrationListenerAdapter);
                    }
                }, 500L);
                ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.IOParam$applyMdns$$inlined$let$lambda$3
                    @Override // java.lang.Runnable
                    public final void run() {
                        NsdRegistrationListenerAdapter nsdRegistrationListenerAdapter;
                        IOParam iOParam = this;
                        iOParam.setNsdServiceInfo(nsdServiceInfo, iOParam.getServiceName(), "_lxi._tcp.", 80);
                        NsdManager nsdManager2 = nsdManager;
                        NsdServiceInfo nsdServiceInfo2 = nsdServiceInfo;
                        nsdRegistrationListenerAdapter = this.registerationLxiListener;
                        nsdManager2.registerService(nsdServiceInfo2, 1, nsdRegistrationListenerAdapter);
                    }
                }, 500L);
                ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.IOParam$applyMdns$$inlined$let$lambda$4
                    @Override // java.lang.Runnable
                    public final void run() {
                        NsdRegistrationListenerAdapter nsdRegistrationListenerAdapter;
                        IOParam iOParam = this;
                        iOParam.setNsdServiceInfo(nsdServiceInfo, iOParam.getServiceName(), "_scpi-raw._tcp.", 80);
                        NsdManager nsdManager2 = nsdManager;
                        NsdServiceInfo nsdServiceInfo2 = nsdServiceInfo;
                        nsdRegistrationListenerAdapter = this.registerationScpiListener;
                        nsdManager2.registerService(nsdServiceInfo2, 1, nsdRegistrationListenerAdapter);
                    }
                }, 500L);
                ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.IOParam$applyMdns$$inlined$let$lambda$5
                    @Override // java.lang.Runnable
                    public final void run() {
                        NsdRegistrationListenerAdapter nsdRegistrationListenerAdapter;
                        IOParam iOParam = this;
                        iOParam.setNsdServiceInfo(nsdServiceInfo, iOParam.getServiceName(), "_vxi-11._tcp.", 80);
                        NsdManager nsdManager2 = nsdManager;
                        NsdServiceInfo nsdServiceInfo2 = nsdServiceInfo;
                        nsdRegistrationListenerAdapter = this.registerationVxiListener;
                        nsdManager2.registerService(nsdServiceInfo2, 1, nsdRegistrationListenerAdapter);
                    }
                }, 500L);
                return;
            }
            return;
        }
        Activity topActivity2 = ActivityUtils.getTopActivity();
        if (topActivity2 != null) {
            Object systemService2 = topActivity2.getSystemService("servicediscovery");
            if (systemService2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.nsd.NsdManager");
            }
            NsdManager nsdManager2 = (NsdManager) systemService2;
            try {
                nsdManager2.unregisterService(this.registerationHttpListener);
                nsdManager2.unregisterService(this.registerationLxiListener);
                nsdManager2.unregisterService(this.registerationScpiListener);
                nsdManager2.unregisterService(this.registerationVxiListener);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        ThreadsKt.thread$default(false, false, null, null, 0, new Function0<Unit>() { // from class: com.rigol.scope.data.IOParam$applyMdns$3
            {
                super(0);
            }

            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Possible override for method kotlin.jvm.functions.Function0.invoke()Ljava/lang/Object; */
            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2() {
                JmDNSImpl jmDNS = IOParam.this.getJmDNS();
                if (jmDNS != null) {
                    jmDNS.unregisterAllServices();
                }
                JmDNSImpl jmDNS2 = IOParam.this.getJmDNS();
                if (jmDNS2 != null) {
                    jmDNS2.close();
                }
            }
        }, 31, null);
    }

    public final void apply() {
        readServiceName();
        int i = this.select;
        if ((i & 1) != 1) {
            if ((i & 2) == 2) {
                ThreadUtils.executeBySingle(new IOParam$apply$3(this));
                return;
            } else {
                new ScheduledThreadPoolExecutor(5).execute(new IOParam$apply$4(this));
                return;
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new IOParam$apply$1(null), 3, null);
        if (this.mdns) {
            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.data.IOParam$apply$2
                @Override // java.lang.Runnable
                public final void run() {
                    NetworkUtils.isAvailableAsync(new Utils.Consumer<Boolean>() { // from class: com.rigol.scope.data.IOParam$apply$2.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.blankj.utilcode.util.Utils.Consumer
                        public final void accept(Boolean bool) {
                            if (TextUtils.isEmpty(IOParam.this.getIpAddress()) || TextUtils.isEmpty(IOParam.this.getHostName())) {
                                return;
                            }
                            try {
                                IOParam.this.setJmDNS(new JmDNSImpl(InetAddress.getByName(IOParam.this.getIpAddress()), IOParam.this.getHostName()));
                                IOParam.this.applyMdns(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }, 3000L);
        } else {
            applyMdns(false);
        }
    }
}
