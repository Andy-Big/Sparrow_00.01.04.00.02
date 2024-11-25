package com.rigol.scope.views;

import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.PopupviewLogcatBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.calibration.CalibrationPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
/* loaded from: classes2.dex */
public class LogcatPopupView extends BasePopupView implements View.OnClickListener {
    private PopupviewLogcatBinding binding;
    private String filterStr;
    private ServiceEnum.LogGrade logGrade;
    private String logStr;

    public LogcatPopupView() {
        super((int) R.style.App_PopupWindow_LOGCAT);
        this.logGrade = ServiceEnum.LogGrade.Log_Verbose;
        this.filterStr = " ";
        this.logStr = " ";
        PopupviewLogcatBinding inflate = PopupviewLogcatBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.gradeSpinner.setOnClickListener(this);
        this.binding.filterEdit.setOnClickListener(this);
        this.binding.buttonRefresh.setOnClickListener(this);
        this.binding.buttonSave.setOnClickListener(this);
        this.binding.log.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.binding.log.addTextChangedListener(new CalibrationPopupView.AutoScrollTextWatcher() { // from class: com.rigol.scope.views.LogcatPopupView.1
            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                LogcatPopupView logcatPopupView = LogcatPopupView.this;
                logcatPopupView.scrollToBottom(logcatPopupView.binding.log);
            }
        });
        init();
    }

    private void init() {
        this.binding.gradeSpinner.setText(ViewUtil.getMappingObject(R.array.msg_debug_logcat_grade, this.logGrade.value1).getStr());
        this.binding.filterEdit.setText(this.filterStr);
        showLog();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.LogcatPopupView$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$LogGrade;

        static {
            int[] iArr = new int[ServiceEnum.LogGrade.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$LogGrade = iArr;
            try {
                iArr[ServiceEnum.LogGrade.Log_Verbose.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$LogGrade[ServiceEnum.LogGrade.Log_DeBug.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$LogGrade[ServiceEnum.LogGrade.Log_Info.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$LogGrade[ServiceEnum.LogGrade.Log_Warn.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$LogGrade[ServiceEnum.LogGrade.Log_Error.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public void queryLogToFile(ServiceEnum.LogGrade logGrade, String str) {
        int i = AnonymousClass4.$SwitchMap$com$rigol$scope$cil$ServiceEnum$LogGrade[logGrade.ordinal()];
        String str2 = i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? "logcat " : "logcat -d *:E " : "logcat -d *:W " : "logcat -t 1000 *:I " : "logcat -t 1000 *:D " : "logcat -t 1000 *:V ";
        if (!str.equals(" ")) {
            str2 = str2 + "| grep " + str + " ";
        }
        ShellUtils.execCmdAsync(str2 + "> /mnt/tmp/Log.txt", true, new Utils.Consumer<ShellUtils.CommandResult>() { // from class: com.rigol.scope.views.LogcatPopupView.2
            @Override // com.blankj.utilcode.util.Utils.Consumer
            public void accept(ShellUtils.CommandResult commandResult) {
            }
        });
    }

    public void acquireLogStr() {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            FileInputStream fileInputStream = new FileInputStream("/mnt/tmp/Log.txt");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                stringBuffer.append(readLine);
                stringBuffer.append("\n");
            }
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException unused) {
        }
        this.logStr = stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void scrollToBottom(TextView textView) {
        int lineCount = textView.getLineCount();
        int lineHeight = textView.getLineHeight();
        int height = textView.getHeight();
        int i = lineCount * lineHeight;
        if (i > height) {
            textView.scrollTo(0, ((i - height) - textView.getPaddingTop()) - ((ConstraintLayout.LayoutParams) textView.getLayoutParams()).topMargin);
        }
    }

    public void showLog() {
        queryLogToFile(this.logGrade, this.filterStr);
        ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.views.-$$Lambda$LogcatPopupView$e4UYipvezS12hYRkKKpxSsYr4_Y
            @Override // java.lang.Runnable
            public final void run() {
                LogcatPopupView.this.lambda$showLog$0$LogcatPopupView();
            }
        }, 2000L);
    }

    public /* synthetic */ void lambda$showLog$0$LogcatPopupView() {
        acquireLogStr();
        this.binding.log.setText(this.logStr);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str;
        int id = view.getId();
        if (id == R.id.grade_spinner) {
            ViewUtil.showSpinner(this.anchor, view, (int) R.array.msg_debug_logcat_grade, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.-$$Lambda$LogcatPopupView$wTW_Ro--dKQbOw-adPqQiXL73AI
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    LogcatPopupView.this.lambda$onClick$1$LogcatPopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.filter_edit) {
            ViewUtil.showPinyinKeyboard(this.context, this.anchor, view, new ExternalInterface() { // from class: com.rigol.scope.views.-$$Lambda$LogcatPopupView$u6uJD3w9_3Vr5vJ-cQrAp-RyPWs
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str2) {
                    LogcatPopupView.this.lambda$onClick$2$LogcatPopupView(str2);
                }
            });
        } else if (id == R.id.button_refresh) {
            showLog();
        } else if (id == R.id.button_save) {
            UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
            if (utilityViewModel == null) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                return;
            }
            UtilityParam value = utilityViewModel.getLiveData().getValue();
            if (value == null) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                return;
            }
            String replace = value.getTime().replace(":", "-");
            StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
            if (storageViewModel == null) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                return;
            }
            StorageSaveParam value2 = storageViewModel.getSaveLiveData().getValue();
            if (value2 == null) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.msg_storage_toast_fail));
                return;
            }
            ShellUtils.execCmdAsync("logcat -d *:V > " + (value2.getPathName() + "/Log_" + replace + ".txt"), true, new Utils.Consumer<ShellUtils.CommandResult>() { // from class: com.rigol.scope.views.LogcatPopupView.3
                @Override // com.blankj.utilcode.util.Utils.Consumer
                public void accept(ShellUtils.CommandResult commandResult) {
                }
            });
            ToastUtils.showLong(ActivityUtils.getTopActivity().getString(R.string.msg_storage_toast_save_success) + ViewUtil.getDiskUIPathName(str));
        }
    }

    public /* synthetic */ void lambda$onClick$1$LogcatPopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        if (mappingObject == null) {
            return;
        }
        this.logGrade = ServiceEnum.getLogGradeFromValue1(mappingObject.getValue());
        showLog();
    }

    public /* synthetic */ void lambda$onClick$2$LogcatPopupView(String str) {
        this.filterStr = str;
        this.binding.filterEdit.setText(this.filterStr);
        showLog();
    }
}
