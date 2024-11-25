package com.rigol.scope.adapters;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.AppUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.AdapterUtilityAboutItemBinding;
import com.rigol.scope.databinding.AdapterUtilityInformationBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.baseview.LinearSpaceItemDecoration;
import com.rigol.util.PackageUtilKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
/* loaded from: classes.dex */
public class UtilityAboutDeviceAdapter extends RecyclerView.Adapter<AboutViewHolder> {
    private AboutAdapter aboutAdapter;
    private final Context context;
    private final UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilityAboutDeviceAdapter(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public AboutViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new AboutViewHolder(AdapterUtilityAboutItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(AboutViewHolder aboutViewHolder, int i) {
        this.aboutAdapter = new AboutAdapter(loadAboutData());
        aboutViewHolder.binding.recyclerDeviceInformation.addItemDecoration(new LinearSpaceItemDecoration(3));
        aboutViewHolder.binding.recyclerDeviceInformation.setAdapter(this.aboutAdapter);
    }

    /* loaded from: classes.dex */
    public static class AboutViewHolder extends RecyclerView.ViewHolder {
        private AdapterUtilityAboutItemBinding binding;

        public AboutViewHolder(AdapterUtilityAboutItemBinding adapterUtilityAboutItemBinding) {
            super(adapterUtilityAboutItemBinding.getRoot());
            this.binding = adapterUtilityAboutItemBinding;
        }
    }

    private List<String> loadAboutData() {
        String str;
        String str2;
        ArrayList arrayList = new ArrayList();
        UtilityViewModel utilityViewModel = this.utilityViewModel;
        UtilityParam value = utilityViewModel != null ? utilityViewModel.getLiveData().getValue() : null;
        int UI_QueryInt32 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_BW);
        int UI_QueryInt322 = API.getInstance().UI_QueryInt32(11, MessageID.MSG_APP_UTILITY_MODEL_CHANGE);
        ServiceEnum.Bandwidth bandwidth = ServiceEnum.Bandwidth.BW_100M;
        if (UI_QueryInt32 >= ServiceEnum.Bandwidth.BW_FULL.value1 && UI_QueryInt32 <= ServiceEnum.Bandwidth.BW_20G.value1) {
            bandwidth = ServiceEnum.getBandwidthFromValue1(UI_QueryInt32);
        }
        if (value.getModel().equals("DHO824") || value.getModel().equals("HDO824")) {
            bandwidth = ServiceEnum.getBandwidthFromValue1(ServiceEnum.Bandwidth.BW_200M.value1);
        }
        String str3 = "0";
        if (value != null) {
            if (UI_QueryInt322 == 0) {
                arrayList.add(this.context.getResources().getString(R.string.inf_sys_model) + "&" + value.getModel() + " (" + this.context.getResources().getString(R.string.inf_system_bw) + bandwidth.value2 + ")");
            } else {
                arrayList.add(this.context.getResources().getString(R.string.inf_sys_model) + "&" + value.getModel().replace("HDO", "DHO") + " (" + this.context.getResources().getString(R.string.inf_system_bw) + bandwidth.value2 + ")");
            }
            arrayList.add(this.context.getResources().getString(R.string.inf_sys_serial) + "&" + value.getSerial());
            String softVersion = value.getSoftVersion();
            if (softVersion.substring(9, 11).compareTo("00") == 0) {
                str2 = softVersion.substring(0, 8);
            } else {
                String substring = softVersion.substring(0, 8);
                if (softVersion.substring(9, 10).compareTo("0") == 0) {
                    str2 = substring + " SP" + softVersion.substring(10, 11);
                } else {
                    str2 = substring + " SP" + softVersion.substring(9, 11);
                }
            }
            arrayList.add(this.context.getResources().getString(R.string.inf_sys_firmware) + "&" + str2);
            arrayList.add(this.context.getResources().getString(R.string.inf_sys_hardware) + "&" + value.getHardVersion());
            arrayList.add(this.context.getResources().getString(R.string.inf_sys_build) + "&" + value.getMiscBuild());
        }
        if (value != null && value.getProjectMode()) {
            String[] split = API.getInstance().UI_QueryStr(11, MessageID.MSG_MISC_FPGA_VER).split("\\,");
            if (split.length == 5) {
                str3 = split[0];
                str = split[1];
                String str4 = split[1];
                String str5 = split[3];
                String str6 = split[4];
            } else {
                str = "0";
            }
            arrayList.set(2, this.context.getResources().getString(R.string.inf_sys_firmware) + "&" + value.getSoftVersion());
            String UI_QueryStr = API.getInstance().UI_QueryStr(11, MessageID.MSG_MISC_SYSTEM_VERSION);
            arrayList.add(this.context.getResources().getString(R.string.inf_sys_wpu) + "&" + str3);
            arrayList.add(this.context.getResources().getString(R.string.inf_sys_spu_a) + "&" + str);
            StringBuilder sb = new StringBuilder();
            sb.append("System.Version&");
            sb.append(UI_QueryStr);
            arrayList.add(sb.toString());
        }
        Date date = new Date(Build.TIME);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        arrayList.add(this.context.getResources().getString(R.string.inf_sys_android_build) + "&" + simpleDateFormat.format(date));
        arrayList.add(this.context.getResources().getString(R.string.inf_sys_android_version) + "&" + Build.VERSION.RELEASE);
        if (AppUtils.isAppInstalled(PackageUtilKt.PACKAGE_NAME_LAUNCHER)) {
            arrayList.add(this.context.getResources().getString(R.string.inf_sys_launcher) + "&" + AppUtils.getAppVersionName(PackageUtilKt.PACKAGE_NAME_LAUNCHER));
        }
        if (AppUtils.isAppInstalled(PackageUtilKt.PACKAGE_NAME_WEBCONTROL)) {
            arrayList.add("WebControl&" + AppUtils.getAppVersionName(PackageUtilKt.PACKAGE_NAME_WEBCONTROL));
        }
        return arrayList;
    }

    public void upData() {
        this.aboutAdapter.setData(loadAboutData());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AboutAdapter extends RecyclerView.Adapter<DetialViewHolder> {
        private List<String> list;

        public AboutAdapter(List<String> list) {
            this.list = list;
        }

        public void setData(List<String> list) {
            this.list = list;
            notifyDataSetChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DetialViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DetialViewHolder(AdapterUtilityInformationBinding.inflate(LayoutInflater.from(viewGroup.getContext())));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(DetialViewHolder detialViewHolder, int i) {
            String str = this.list.get(i);
            if (str.contains("&")) {
                String[] split = str.split("&");
                if (split.length > 0) {
                    detialViewHolder.binding.informationTitle.setText(split[0]);
                }
                if (split.length > 1) {
                    detialViewHolder.binding.informationContent.setText(split[1]);
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.list.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes.dex */
        public static class DetialViewHolder extends RecyclerView.ViewHolder {
            AdapterUtilityInformationBinding binding;

            public DetialViewHolder(AdapterUtilityInformationBinding adapterUtilityInformationBinding) {
                super(adapterUtilityInformationBinding.getRoot());
                this.binding = adapterUtilityInformationBinding;
            }
        }
    }
}
