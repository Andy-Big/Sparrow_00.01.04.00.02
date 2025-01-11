package com.rigol.scope.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.MainActivity;
import com.rigol.scope.R;
import com.rigol.scope.ScreenSaverActivity;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.AdapterUtilityScreensaverBinding;
import com.rigol.scope.utilities.ScreenSaverUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import java.io.File;
import java.io.FileFilter;

/* loaded from: classes.dex */
public class UtilityScreenSaverAdapter extends RecyclerView.Adapter<ScreenSaverViewHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {
    private final View baseView;
    private AdapterUtilityScreensaverBinding binding;
    private KeyboardPopupView keyboardPopupView;
    private final MainActivity mainActivity;
    private final UtilityParam utilityParam;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public UtilityScreenSaverAdapter(MainActivity mainActivity, View view, UtilityParam utilityParam) {
        this.mainActivity = mainActivity;
        this.baseView = view;
        this.utilityParam = utilityParam;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public ScreenSaverViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        AdapterUtilityScreensaverBinding inflate = AdapterUtilityScreensaverBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        this.binding = inflate;
        inflate.setParam(this.utilityParam);
        return new ScreenSaverViewHolder(this.binding);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(ScreenSaverViewHolder screenSaverViewHolder, int i) {
        initClicke(screenSaverViewHolder);
    }

    private void initClicke(ScreenSaverViewHolder screenSaverViewHolder) {
        screenSaverViewHolder.binding.radiogroupScreenType.setOnCheckedChangeListener(this);
        screenSaverViewHolder.binding.tvPictureValue.setOnClickListener(this);
        screenSaverViewHolder.binding.tvTextValue.setOnClickListener(this);
        screenSaverViewHolder.binding.tvWatitimeValue.setOnClickListener(this);
        screenSaverViewHolder.binding.tvPreview.setOnClickListener(this);
        screenSaverViewHolder.binding.tvDefault.setOnClickListener(this);
        screenSaverViewHolder.binding.tvTextValue.setOnClickListener(this);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i == R.id.radioButton_close) {
            UtilityParam utilityParam = this.utilityParam;
            if (utilityParam != null) {
                utilityParam.saveScreenSelect(ServiceEnum.UtilityScreenSaver.SCR_OFF.value1);
            }
            ScreenSaverUtil.getInstance(this.mainActivity).setMillsInFuture();
        } else if (i == R.id.radioButton_picture) {
            UtilityParam utilityParam2 = this.utilityParam;
            if (utilityParam2 != null) {
                utilityParam2.saveScreenSelect(ServiceEnum.UtilityScreenSaver.SCR_PICTURE.value1);
            }
            ScreenSaverUtil.getInstance(this.mainActivity).setMillsInFuture();
        } else if (i != R.id.radioButton_text) {
        } else {
            UtilityParam utilityParam3 = this.utilityParam;
            if (utilityParam3 != null) {
                utilityParam3.saveScreenSelect(ServiceEnum.UtilityScreenSaver.SCR_TEXT.value1);
            }
            ScreenSaverUtil.getInstance(this.mainActivity).setMillsInFuture();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_default /* 2131364412 */:
                UtilityParam utilityParam = this.utilityParam;
                if (utilityParam != null) {
                    utilityParam.resetScreenSaver();
                    return;
                }
                return;
            case R.id.tv_picture_value /* 2131364434 */:
                ViewUtil.showDiskManage(DiskManageParam.DEFAULT_PATH, DiskManageParam.SelectionMode.FILE, new FileFilter() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityScreenSaverAdapter$z-IOj2v6tutxR7BHMSjYyHAigqg
                    @Override // java.io.FileFilter
                    public final boolean accept(File file) {
                        return UtilityScreenSaverAdapter.lambda$onClick$0(file);
                    }
                }, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityScreenSaverAdapter$mieiUyHyDGxThg5D8j-FEcHumUQ
                    @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                    public final void onFolderSelected(String str) {
                        UtilityScreenSaverAdapter.this.lambda$onClick$1$UtilityScreenSaverAdapter(str);
                    }
                });
                return;
            case R.id.tv_preview /* 2131364436 */:
                this.mainActivity.startActivity(new Intent(this.mainActivity, ScreenSaverActivity.class));
                return;
            case R.id.tv_text_value /* 2131364451 */:
                ViewUtil.showPinyinKeyboard(this.mainActivity, this.baseView, this.binding.tvTextValue, new ExternalInterface() { // from class: com.rigol.scope.adapters.-$$Lambda$UtilityScreenSaverAdapter$cV6pZFmSHqNaaD8NIS0U4d0kfQM
                    @Override // com.rigol.pinyinkeyboard.ExternalInterface
                    public final void resultShow(String str) {
                        UtilityScreenSaverAdapter.this.lambda$onClick$2$UtilityScreenSaverAdapter(str);
                    }
                });
                return;
            case R.id.tv_watitime_value /* 2131364459 */:
                if (this.utilityParam != null) {
                    new KeyboardPopupView(new KeyboardPopupView.Builder(ServiceEnum.Unit.Unit_number, 999L, 1L, 30L, Integer.parseInt(this.utilityParam.getScreenTime())).setKeyboardListener(new KeyboardListener() { // from class: com.rigol.scope.adapters.UtilityScreenSaverAdapter.1
                        {
                            UtilityScreenSaverAdapter.this = this;
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public <T> void resultMinUnitValueListener(T t) {
                            UtilityScreenSaverAdapter.this.utilityParam.saveScreenTime(String.valueOf((Long) t));
                            ScreenSaverUtil.getInstance(UtilityScreenSaverAdapter.this.mainActivity).setMillsInFuture();
                        }

                        @Override // com.rigol.scope.views.keyboard.KeyboardListener
                        public void onCall(KeyboardPopupView keyboardPopupView) {
                            UtilityScreenSaverAdapter.this.keyboardPopupView = keyboardPopupView;
                        }
                    })).showAsDropDown(this.baseView, 0, 0, GravityCompat.START);
                    return;
                }
                return;
            default:
                return;
        }
    }

    static /* synthetic */ boolean lambda$onClick$0(File file) {
        return file != null && (ViewUtil.isImageFile(file.getPath()) || file.isDirectory());
    }

    public /* synthetic */ void lambda$onClick$1$UtilityScreenSaverAdapter(String str) {
        UtilityParam utilityParam = this.utilityParam;
        if (utilityParam != null) {
            utilityParam.saveScreenPicture(str);
        }
    }

    public /* synthetic */ void lambda$onClick$2$UtilityScreenSaverAdapter(String str) {
        UtilityParam utilityParam = this.utilityParam;
        if (utilityParam != null) {
            utilityParam.saveScreenWord(str);
        }
    }

    /* loaded from: classes.dex */
    public static class ScreenSaverViewHolder extends RecyclerView.ViewHolder {
        private AdapterUtilityScreensaverBinding binding;

        public ScreenSaverViewHolder(AdapterUtilityScreensaverBinding adapterUtilityScreensaverBinding) {
            super(adapterUtilityScreensaverBinding.getRoot());
            this.binding = adapterUtilityScreensaverBinding;
        }
    }
}
