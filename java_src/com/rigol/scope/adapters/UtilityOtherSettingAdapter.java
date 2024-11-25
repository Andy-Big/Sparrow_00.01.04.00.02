package com.rigol.scope.adapters;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.scope.R;
import com.rigol.scope.adapters.UtilityOtherSettingAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.AdapterUtilityOtherBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ReflectUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.openSourceLicense.OpenSourceLicensePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;
import kotlinx.coroutines.DebugKt;
/* loaded from: classes.dex */
public class UtilityOtherSettingAdapter extends RecyclerView.Adapter<OtherSettingViewHolder> {
    private static final String SYS_DP_STATE = "sys.hdmi_status.aux";
    private static int hdmiId = 1;
    private View baseView;
    private AdapterUtilityOtherBinding binding;
    private final HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
    private final UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    static /* synthetic */ int access$112(int i) {
        int i2 = hdmiId + i;
        hdmiId = i2;
        return i2;
    }

    public UtilityOtherSettingAdapter(View view) {
        this.baseView = view;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public OtherSettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterUtilityOtherBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        HorizontalParam value = this.horizontalViewModel.getLiveData().getValue();
        if (value != null) {
            this.binding.setHorizontalParam(value);
        }
        UtilityParam value2 = this.utilityViewModel.getLiveData().getValue();
        if (value2 != null) {
            this.binding.setUtilityParam(value2);
        }
        return new OtherSettingViewHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(OtherSettingViewHolder otherSettingViewHolder, int i) {
        final HorizontalParam value = this.horizontalViewModel.getLiveData().getValue();
        if (value != null) {
            this.binding.switchButtonFilter1.setChecked(value.getFilter1());
            this.binding.switchButtonFilter2.setChecked(value.getFilter2());
        }
        final UtilityParam value2 = this.utilityViewModel.getLiveData().getValue();
        if (value2 != null) {
            this.binding.switchButtonRefClock.setChecked(value2.getRefClock() == ServiceEnum.RefClock.REF_10MHz_IN);
        }
        ViewUtil.setSwitchButton(this.binding.switchButtonFilter1);
        ViewUtil.setSwitchButton(this.binding.switchButtonFilter2);
        ViewUtil.setSwitchButton(this.binding.switchButtonRefClock);
        ViewUtil.setSwitchButton(this.binding.switchButtonZbd);
        this.binding.switchButtonFilter1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityOtherSettingAdapter$lPDgD1sRggwlEJkkg9NviP2nxmQ
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityOtherSettingAdapter.lambda$onBindViewHolder$0(HorizontalParam.this, compoundButton, z);
            }
        });
        this.binding.switchButtonFilter2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityOtherSettingAdapter$eLMmX2nnuPMOA29uGY9OSy4UtLg
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityOtherSettingAdapter.lambda$onBindViewHolder$1(HorizontalParam.this, compoundButton, z);
            }
        });
        this.binding.switchButtonRefClock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityOtherSettingAdapter$3bKQn7sopbBWynbYO_0YwKIuC-g
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityOtherSettingAdapter.lambda$onBindViewHolder$2(UtilityParam.this, compoundButton, z);
            }
        });
        this.binding.switchButtonZbd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityOtherSettingAdapter$9YbqR9_0vJB5-8rOk1hJseq81n8
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                UtilityOtherSettingAdapter.lambda$onBindViewHolder$3(UtilityParam.this, compoundButton, z);
            }
        });
        this.binding.hdmiSpinner.setOnClickListener(new AnonymousClass1(value2));
        this.binding.openSourceLicenseLayout.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityOtherSettingAdapter$6Au6F7GIzc2g8h8RjIlMwcY6M7E
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                UtilityOtherSettingAdapter.lambda$onBindViewHolder$4(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onBindViewHolder$0(HorizontalParam horizontalParam, CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && horizontalParam != null) {
            horizontalParam.saveFilter1(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onBindViewHolder$1(HorizontalParam horizontalParam, CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && horizontalParam != null) {
            horizontalParam.saveFilter2(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onBindViewHolder$2(UtilityParam utilityParam, CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && utilityParam != null) {
            if (z) {
                utilityParam.saveRefClock(ServiceEnum.RefClock.REF_10MHz_IN);
            } else {
                utilityParam.saveRefClock(ServiceEnum.RefClock.REF_10MHz_OFF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onBindViewHolder$3(UtilityParam utilityParam, CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed() && utilityParam != null) {
            utilityParam.saveZbdLed(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.adapters.UtilityOtherSettingAdapter$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ UtilityParam val$utilityParam;

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$onClick$0(ShellUtils.CommandResult commandResult) {
        }

        AnonymousClass1(UtilityParam utilityParam) {
            this.val$utilityParam = utilityParam;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            View view2 = UtilityOtherSettingAdapter.this.baseView;
            final UtilityParam utilityParam = this.val$utilityParam;
            ViewUtil.showSpinner(view2, view, (int) R.array.msg_app_utility_hdmi_ratio, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityOtherSettingAdapter$1$w412i78eDIIsdiQCfsFtKYQTD-4
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view3, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    UtilityOtherSettingAdapter.AnonymousClass1.lambda$onClick$2(UtilityParam.this, view3, viewHolder, i, (MappingObject) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$onClick$2(UtilityParam utilityParam, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
            String str;
            if (utilityParam != null) {
                ServiceEnum.HDMI_Ratio hDMI_RatioFromValue1 = ServiceEnum.getHDMI_RatioFromValue1(mappingObject.getValue());
                utilityParam.setHdmiRatio(hDMI_RatioFromValue1);
                switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio[hDMI_RatioFromValue1.ordinal()]) {
                    case 1:
                        str = "setprop persist.sys.resolution.aux 1920x1080@60";
                        break;
                    case 2:
                        str = "setprop persist.sys.resolution.aux 1600x900@60";
                        break;
                    case 3:
                        str = "setprop persist.sys.resolution.aux 1280x1024@60";
                        break;
                    case 4:
                        str = "setprop persist.sys.resolution.aux 1280x720@60";
                        break;
                    case 5:
                        str = "setprop persist.sys.resolution.aux 1024x768@60";
                        break;
                    case 6:
                        str = "setprop persist.sys.resolution.aux 800x600@60";
                        break;
                    case 7:
                        str = "setprop persist.sys.resolution.aux 720x480@60";
                        break;
                    case 8:
                        str = "setprop persist.sys.resolution.aux 640x480@60";
                        break;
                    default:
                        str = "";
                        break;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                arrayList.add("setprop sys.display.timeline " + UtilityOtherSettingAdapter.hdmiId);
                ShellUtils.execCmdAsync((List<String>) arrayList, true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityOtherSettingAdapter$1$V3dVL8nHdHjMKxF2gRmdy-apHIo
                    @Override // com.blankj.utilcode.util.Utils.Consumer
                    public final void accept(Object obj) {
                        UtilityOtherSettingAdapter.AnonymousClass1.lambda$onClick$0((ShellUtils.CommandResult) obj);
                    }
                });
                UtilityOtherSettingAdapter.access$112(1);
                ReflectUtil.setProperty("persist.sys.rotation.efull", "true");
                ReflectUtil.setProperty(UtilityOtherSettingAdapter.SYS_DP_STATE, DebugKt.DEBUG_PROPERTY_VALUE_OFF);
                new Handler().postDelayed(new Runnable() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityOtherSettingAdapter$1$B_oAOm9a2-kRToQQXNWnJF5aAB0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ReflectUtil.setProperty(UtilityOtherSettingAdapter.SYS_DP_STATE, DebugKt.DEBUG_PROPERTY_VALUE_ON);
                    }
                }, 500L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.adapters.UtilityOtherSettingAdapter$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio;

        static {
            int[] iArr = new int[ServiceEnum.HDMI_Ratio.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio = iArr;
            try {
                iArr[ServiceEnum.HDMI_Ratio.HDMI_1920x1080.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio[ServiceEnum.HDMI_Ratio.HDMI_1600x900.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio[ServiceEnum.HDMI_Ratio.HDMI_1280x1024.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio[ServiceEnum.HDMI_Ratio.HDMI_1280x720.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio[ServiceEnum.HDMI_Ratio.HDMI_1024x768.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio[ServiceEnum.HDMI_Ratio.HDMI_800x600.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio[ServiceEnum.HDMI_Ratio.HDMI_720x480.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$HDMI_Ratio[ServiceEnum.HDMI_Ratio.HDMI_640x480.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onBindViewHolder$4(View view) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(OpenSourceLicensePopupView.class);
        if (basePopupView == null) {
            OpenSourceLicensePopupView openSourceLicensePopupView = new OpenSourceLicensePopupView();
            PopupViewManager.getInstance().add(OpenSourceLicensePopupView.class, openSourceLicensePopupView);
            openSourceLicensePopupView.show();
            return;
        }
        basePopupView.show();
    }

    /* loaded from: classes.dex */
    public static class OtherSettingViewHolder extends RecyclerView.ViewHolder {
        public OtherSettingViewHolder(AdapterUtilityOtherBinding adapterUtilityOtherBinding) {
            super(adapterUtilityOtherBinding.getRoot());
        }
    }
}
