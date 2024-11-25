package com.rigol.scope.views.storage;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.Utils;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.R;
import com.rigol.scope.adapters.SpinnerAdapter;
import com.rigol.scope.adapters.StorageViewPagerAdapter;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.DiskParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageLoadParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.AdapterStorageLoadBinding;
import com.rigol.scope.databinding.AdapterStorageSaveBinding;
import com.rigol.scope.databinding.AdapterStorageUpgradeBinding;
import com.rigol.scope.databinding.PopupviewStorageBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ImageUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UtilityUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.views.UpgradingPopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.scope.views.storage.StoragePopupView;
import com.rigol.util.ToastUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/* loaded from: classes2.dex */
public class StoragePopupView extends BasePopupView implements StorageViewPagerAdapter.OnItemClickCallback, PopupWindow.OnDismissListener, View.OnClickListener, TabLayoutMediator.TabConfigurationStrategy {
    private final StorageViewPagerAdapter adapter;
    private AorBManager aorBManager;
    private final PopupviewStorageBinding binding;
    private View clickedView;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam;
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private PopupSpinner popupSpinner;
    private SpinnerAdapter spinnerAdapter;
    private StorageLoadParam storageLoadParam;
    private StorageSaveParam storageSaveParam;
    private SyncDataViewModel syncDataViewModel;

    public StoragePopupView() {
        super((int) R.style.App_PopupWindow_Storage);
        this.list_aorbParam = new ArrayList();
        PopupviewStorageBinding inflate = PopupviewStorageBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        this.binding.smbSetting.setOnClickListener(this);
        this.aorBManager = new AorBManager(this.context, this.list_aorbParam) { // from class: com.rigol.scope.views.storage.StoragePopupView.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i) {
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i) {
            }
        };
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$4aTOfjf0lPXN5spjj11VJbfPePU
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        StoragePopupView.this.lambda$new$2$StoragePopupView((KeyEvent) obj);
                    }
                });
            }
        }
        if (this.syncDataViewModel == null) {
            SyncDataViewModel syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
            this.syncDataViewModel = syncDataViewModel;
            if (syncDataViewModel != null) {
                syncDataViewModel.get(12, MessageID.MSG_STORAGE_RESULT).observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$BtErY9IPLJE5XxXBk7T8_3aZA0Q
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        StoragePopupView.this.lambda$new$3$StoragePopupView(obj);
                    }
                });
            }
        }
        TextView textView = this.binding.tvMem;
        textView.setText(String.valueOf(PopupViewManager.getInstance().getAvailableSize() + "MB"));
        this.binding.diskManage.setOnClickListener(this);
        StorageViewPagerAdapter storageViewPagerAdapter = new StorageViewPagerAdapter(this.context, ViewUtil.getList((int) R.array.msg_storage_operation));
        this.adapter = storageViewPagerAdapter;
        storageViewPagerAdapter.setOnItemClickCallback(this, this.aorBManager);
        this.binding.viewPager.setAdapter(this.adapter);
        this.binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() { // from class: com.rigol.scope.views.storage.StoragePopupView.2
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                StorageViewModel storageViewModel;
                String pathName;
                super.onPageSelected(i);
                if (ServiceEnum.getStorageOperationFromValue1(i) != ServiceEnum.StorageOperation.LOAD || (storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class)) == null) {
                    return;
                }
                StorageLoadParam value = storageViewModel.getLoadLiveData().getValue();
                value.setSetupFileType(ViewUtil.getList((int) R.array.msg_storage_load_setup).get(0).getValue());
                if (value == null || (pathName = value.getPathName()) == null || !new File(pathName).isFile()) {
                    return;
                }
                if (pathName.endsWith(ServiceEnum.enFileType.FILETYPE_STP.value2) && pathName.endsWith(ServiceEnum.enFileType.FILETYPE_WFM.value2)) {
                    return;
                }
                DiskParam firstUsbDisk = UtilityUtil.getFirstUsbDisk();
                if (firstUsbDisk == null) {
                    value.savePathName(DiskManageParam.DEFAULT_PATH);
                } else {
                    value.savePathName(firstUsbDisk.getPath());
                }
            }
        });
        new TabLayoutMediator(this.binding.tabs, this.binding.viewPager, this).attach();
    }

    public /* synthetic */ void lambda$new$2$StoragePopupView(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(StoragePopupView.class)) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$iEcGA0ikRig_y9qxFTnGPTkl3XA
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    StoragePopupView.this.lambda$new$0$StoragePopupView(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$kS_lXdztgEdQnVgPbccgBUeo8pA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    StoragePopupView.this.lambda$new$1$StoragePopupView(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$new$0$StoragePopupView(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$new$1$StoragePopupView(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.choose_spinner_load /* 2131362284 */:
                selectLoadChoose(mappingObject);
                return;
            case R.id.choose_spinner_save /* 2131362285 */:
                selectSaveChoose(mappingObject);
                return;
            case R.id.image_format_spinner /* 2131363109 */:
                selectSaveImage(mappingObject);
                return;
            case R.id.setup_file_format_spinner /* 2131363841 */:
                selectLoadSetUpFileFormat(mappingObject);
                return;
            case R.id.setup_format_spinner /* 2131363843 */:
                selectSaveSetUp(mappingObject);
                return;
            case R.id.wave_depth_spinner /* 2131364625 */:
                selectSaveWaveDepth(i, mappingObject);
                return;
            case R.id.wave_file_format_spinner /* 2131364627 */:
                selectLoadWaveFileFormat(mappingObject);
                return;
            case R.id.wave_format_spinner /* 2131364630 */:
                selectSaveWave(mappingObject);
                return;
            default:
                return;
        }
    }

    public /* synthetic */ void lambda$new$3$StoragePopupView(Object obj) {
        TextView textView = this.binding.tvMem;
        textView.setText(String.valueOf(PopupViewManager.getInstance().getAvailableSize() + "MB"));
    }

    @Override // com.rigol.scope.adapters.StorageViewPagerAdapter.OnItemClickCallback
    public void onSaveItemClick(AdapterStorageSaveBinding adapterStorageSaveBinding, final StorageSaveParam storageSaveParam, View view) {
        FileFilter fileFilter;
        List<MappingObject> list;
        int id = view.getId();
        this.storageSaveParam = storageSaveParam;
        if (id == R.id.choose_spinner_save) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_storage_save_option), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$6Xlom3jHJwaEe88HlVojoowBFhI
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    StoragePopupView.this.lambda$onSaveItemClick$4$StoragePopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$CWmYUqQTsMBSCkqhjJNHPOH3NDQ
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    StoragePopupView.this.lambda$onSaveItemClick$5$StoragePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.image_format_spinner) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_storage_image_format), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$N82XKWOWnfgScT6moQZB2dSWH5Q
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    StoragePopupView.this.lambda$onSaveItemClick$6$StoragePopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$7A-iAITMxRZ-yX3drTQVu1u_BKg
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    StoragePopupView.this.lambda$onSaveItemClick$7$StoragePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.wave_format_spinner) {
            if (storageSaveParam.getWaveDepth() == 0) {
                list = ViewUtil.getList((int) R.array.msg_storage_scr_format);
            } else {
                list = ViewUtil.getList((int) R.array.msg_storage_wave_format);
            }
            ViewUtil.showSpinner(this.anchor, view, list, new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$EzFtzI0ixp9dqWjJPPvTr4sXvo8
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    StoragePopupView.this.lambda$onSaveItemClick$8$StoragePopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$uJCCmWgPhkiEjIu-A3FMSRoxs5g
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    StoragePopupView.this.lambda$onSaveItemClick$9$StoragePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.setup_format_spinner) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_storage_setup_format), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$E6eF3byWDZDyllne9YoR1cbYIvA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    StoragePopupView.this.lambda$onSaveItemClick$10$StoragePopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$JHIJfvSVvCcGr3SWniHHufnSJCY
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    StoragePopupView.this.lambda$onSaveItemClick$11$StoragePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.wave_depth_spinner) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_storage_wave_depth), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$DytmEcS27eW9I2BhexQ7OWO9iro
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list2, View view2) {
                    StoragePopupView.this.lambda$onSaveItemClick$12$StoragePopupView(popupSpinner, spinnerAdapter, list2, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$6jbWwSvdTh6SDx4wiFPgzB2veyA
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    StoragePopupView.this.lambda$onSaveItemClick$13$StoragePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.image_invert_switch) {
            storageSaveParam.saveImageInvert(!storageSaveParam.isImageInvert());
        } else if (id == R.id.image_color_switch) {
            storageSaveParam.saveImageColor(!storageSaveParam.isImageColor());
        } else if (id == R.id.image_header_switch) {
            storageSaveParam.saveImageHeader(!storageSaveParam.isImageHeader());
        } else if (id == R.id.auto_name_switch) {
            storageSaveParam.saveAutoName(!storageSaveParam.readAutoName());
        } else if (id == R.id.checkBox_CH1) {
            storageSaveParam.setChan1(!storageSaveParam.isChan1());
        } else if (id == R.id.checkBox_CH2) {
            storageSaveParam.setChan2(!storageSaveParam.isChan2());
        } else if (id == R.id.checkBox_CH3) {
            storageSaveParam.setChan3(!storageSaveParam.isChan3());
        } else if (id == R.id.checkBox_CH4) {
            storageSaveParam.setChan4(!storageSaveParam.isChan4());
        } else if (id == R.id.prefix_edit_text) {
            Context context = this.context;
            View view2 = this.anchor;
            String prefix = storageSaveParam.getPrefix();
            Objects.requireNonNull(storageSaveParam);
            ViewUtil.showSavePinyinKeyboard(context, view2, view, true, prefix, new ExternalInterface() { // from class: com.rigol.scope.views.storage.-$$Lambda$i9NRwQVRXRz5denMFitBirafr2w
                @Override // com.rigol.pinyinkeyboard.ExternalInterface
                public final void resultShow(String str) {
                    StorageSaveParam.this.savePrefix(str);
                }
            }, 17, 0, 0);
        } else if (id == R.id.save) {
            if (storageSaveParam.getChoose() == ServiceEnum.StorageOperationChoose.IMAGE) {
                PopupViewManager.getInstance().dismissAll(new Class[0]);
                storageSaveParam.screenShotSetting();
                ImageUtil.save(storageSaveParam);
            } else if (storageSaveParam.getChoose() == ServiceEnum.StorageOperationChoose.WAVE) {
                storageSaveParam.saveWaveSetting();
                storageSaveParam.doSave();
            } else if (storageSaveParam.getChoose() == ServiceEnum.StorageOperationChoose.SETUP) {
                storageSaveParam.saveSetupSetting();
                storageSaveParam.doSave();
            }
        } else if (id == R.id.smb_en_switch) {
            storageSaveParam.saveSmbEn(!storageSaveParam.getSmbEn());
        } else if (id == R.id.path_name_edit_text) {
            if (storageSaveParam.getChoose() == ServiceEnum.StorageOperationChoose.IMAGE) {
                fileFilter = new FileFilter() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$jNIGuV_qbBjtMU7ypx9due3Dt_U
                    @Override // java.io.FileFilter
                    public final boolean accept(File file) {
                        return StoragePopupView.lambda$onSaveItemClick$14(StorageSaveParam.this, file);
                    }
                };
            } else if (storageSaveParam.getChoose() == ServiceEnum.StorageOperationChoose.WAVE) {
                fileFilter = new FileFilter() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$XtAJOvNW1fqQsftsdlmGo0_TqJY
                    @Override // java.io.FileFilter
                    public final boolean accept(File file) {
                        return StoragePopupView.lambda$onSaveItemClick$15(StorageSaveParam.this, file);
                    }
                };
            } else {
                fileFilter = new FileFilter() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$dXoK9OCdfmKWxxatfE8Zwyl4NzI
                    @Override // java.io.FileFilter
                    public final boolean accept(File file) {
                        return StoragePopupView.lambda$onSaveItemClick$16(StorageSaveParam.this, file);
                    }
                };
            }
            String pathName = storageSaveParam.getPathName();
            DiskManageParam.SelectionMode selectionMode = DiskManageParam.SelectionMode.DIR;
            Objects.requireNonNull(storageSaveParam);
            ViewUtil.showDiskManage(pathName, selectionMode, fileFilter, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.views.storage.-$$Lambda$FtnkS5Qj29C5AJZD93PQtkUcPos
                @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                public final void onFolderSelected(String str) {
                    StorageSaveParam.this.savePathName(str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onSaveItemClick$4$StoragePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onSaveItemClick$5$StoragePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSaveChoose(mappingObject);
    }

    public /* synthetic */ void lambda$onSaveItemClick$6$StoragePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onSaveItemClick$7$StoragePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSaveImage(mappingObject);
    }

    public /* synthetic */ void lambda$onSaveItemClick$8$StoragePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onSaveItemClick$9$StoragePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSaveWave(mappingObject);
    }

    public /* synthetic */ void lambda$onSaveItemClick$10$StoragePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onSaveItemClick$11$StoragePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSaveSetUp(mappingObject);
    }

    public /* synthetic */ void lambda$onSaveItemClick$12$StoragePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onSaveItemClick$13$StoragePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectSaveWaveDepth(i, mappingObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$onSaveItemClick$14(StorageSaveParam storageSaveParam, File file) {
        return file.isDirectory() || file.getName().endsWith(ViewUtil.getMappingObject(R.array.msg_storage_image_format, storageSaveParam.getImageFileType()).getStr().replace("*.", ""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$onSaveItemClick$15(StorageSaveParam storageSaveParam, File file) {
        return file.isDirectory() || file.getName().endsWith(ViewUtil.getMappingObject(R.array.msg_storage_wave_format, storageSaveParam.getWaveFileType()).getStr().replace("*.", ""));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$onSaveItemClick$16(StorageSaveParam storageSaveParam, File file) {
        return file.isDirectory() || file.getName().endsWith(ViewUtil.getMappingObject(R.array.msg_storage_setup_format, storageSaveParam.getSetupFileType()).getStr().replace("*.", ""));
    }

    private void selectSaveWaveDepth(int i, MappingObject mappingObject) {
        StorageSaveParam storageSaveParam;
        if (mappingObject == null || (storageSaveParam = this.storageSaveParam) == null) {
            return;
        }
        storageSaveParam.saveWaveDepth(mappingObject.getValue());
        if (i == 0) {
            int waveFileType = this.storageSaveParam.getWaveFileType();
            List<MappingObject> list = ViewUtil.getList((int) R.array.msg_storage_wave_format);
            if (waveFileType == list.get(0).getValue() || waveFileType == list.get(1).getValue()) {
                return;
            }
            selectSaveWave(list.get(0));
        }
    }

    private void selectSaveSetUp(MappingObject mappingObject) {
        StorageSaveParam storageSaveParam;
        if (mappingObject == null || (storageSaveParam = this.storageSaveParam) == null) {
            return;
        }
        storageSaveParam.setSetupFileType(mappingObject.getValue());
    }

    private void selectSaveWave(MappingObject mappingObject) {
        StorageSaveParam storageSaveParam;
        if (mappingObject == null || (storageSaveParam = this.storageSaveParam) == null) {
            return;
        }
        storageSaveParam.setWaveFileType(mappingObject.getValue());
    }

    private void selectSaveImage(MappingObject mappingObject) {
        StorageSaveParam storageSaveParam;
        if (mappingObject == null || (storageSaveParam = this.storageSaveParam) == null) {
            return;
        }
        storageSaveParam.setImageFileType(mappingObject.getValue());
    }

    private void selectSaveChoose(MappingObject mappingObject) {
        StorageSaveParam storageSaveParam;
        if (mappingObject == null || (storageSaveParam = this.storageSaveParam) == null) {
            return;
        }
        ServiceEnum.StorageOperationChoose storageOperationChooseFromValue1 = ServiceEnum.getStorageOperationChooseFromValue1(mappingObject.getValue());
        if (storageOperationChooseFromValue1 == ServiceEnum.StorageOperationChoose.IMAGE) {
            storageSaveParam.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_IMG);
            storageSaveParam.setFileType(storageSaveParam.getImageFileType());
        } else if (storageOperationChooseFromValue1 == ServiceEnum.StorageOperationChoose.WAVE) {
            storageSaveParam.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_WAV);
            storageSaveParam.setFileType(storageSaveParam.getWaveFileType());
        } else if (storageOperationChooseFromValue1 == ServiceEnum.StorageOperationChoose.SETUP) {
            storageSaveParam.saveFileProc(ServiceEnum.StorageFunc.FUNC_SAVE_STP);
            storageSaveParam.setFileType(storageSaveParam.getSetupFileType());
        }
        storageSaveParam.setChoose(storageOperationChooseFromValue1);
    }

    @Override // com.rigol.scope.adapters.StorageViewPagerAdapter.OnItemClickCallback
    public void onLoadItemClick(AdapterStorageLoadBinding adapterStorageLoadBinding, final StorageLoadParam storageLoadParam, View view) {
        int id = view.getId();
        this.storageLoadParam = storageLoadParam;
        if (id == R.id.choose_spinner_load) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_storage_load_option), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$Oi_lOl4SJCRxnx6NrBlGrSeCeW4
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    StoragePopupView.this.lambda$onLoadItemClick$17$StoragePopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$NvSofP7Vbw2PamLuyCqhjqOAMq4
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    StoragePopupView.this.lambda$onLoadItemClick$18$StoragePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.wave_file_format_spinner) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_storage_load_wave), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$IY18TT0KiotA7Hf5ZnxRaiOEruY
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    StoragePopupView.this.lambda$onLoadItemClick$19$StoragePopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$UEaDaIoxub6k1fCD3n_rF0M8I-w
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    StoragePopupView.this.lambda$onLoadItemClick$20$StoragePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.setup_file_format_spinner) {
            ViewUtil.showSpinner(this.anchor, view, ViewUtil.getList((int) R.array.msg_storage_load_setup), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$EjtPh92MYqlyT8uJ7yfcSNu-GWA
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    StoragePopupView.this.lambda$onLoadItemClick$21$StoragePopupView(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$GLdVmwqfhXXeWymkg_r160J_Ni4
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    StoragePopupView.this.lambda$onLoadItemClick$22$StoragePopupView(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.load) {
            if (storageLoadParam.getChoose() == ServiceEnum.StorageOperationChoose.WAVE) {
                storageLoadParam.loadWaveSetting();
            } else if (storageLoadParam.getChoose() == ServiceEnum.StorageOperationChoose.SETUP) {
                storageLoadParam.loadSetupSetting();
            }
            storageLoadParam.doLoad();
        } else if (id == R.id.path_name_edit_text) {
            final ServiceEnum.enFileType enfiletype = ServiceEnum.getenFileTypeFromValue1(storageLoadParam.getFileType());
            FileFilter fileFilter = enfiletype != null ? new FileFilter() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$i5UpXllL_ALx2p4qMuHEH5pJny0
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    return StoragePopupView.lambda$onLoadItemClick$23(ServiceEnum.enFileType.this, file);
                }
            } : null;
            String pathName = storageLoadParam.getPathName();
            DiskManageParam.SelectionMode selectionMode = DiskManageParam.SelectionMode.FILE;
            Objects.requireNonNull(storageLoadParam);
            ViewUtil.showDiskManage(pathName, selectionMode, fileFilter, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.views.storage.-$$Lambda$gdWAoUf1TpGS31Lcs9y1uuv3718
                @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                public final void onFolderSelected(String str) {
                    StorageLoadParam.this.savePathName(str);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onLoadItemClick$17$StoragePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onLoadItemClick$18$StoragePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectLoadChoose(mappingObject);
    }

    public /* synthetic */ void lambda$onLoadItemClick$19$StoragePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onLoadItemClick$20$StoragePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectLoadWaveFileFormat(mappingObject);
    }

    public /* synthetic */ void lambda$onLoadItemClick$21$StoragePopupView(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onLoadItemClick$22$StoragePopupView(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectLoadSetUpFileFormat(mappingObject);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$onLoadItemClick$23(ServiceEnum.enFileType enfiletype, File file) {
        if (file != null) {
            String path = file.getPath();
            if (path.endsWith("." + enfiletype.value2) || file.isDirectory()) {
                return true;
            }
        }
        return false;
    }

    private void selectLoadSetUpFileFormat(MappingObject mappingObject) {
        StorageLoadParam storageLoadParam;
        if (mappingObject == null || (storageLoadParam = this.storageLoadParam) == null) {
            return;
        }
        storageLoadParam.setSetupFileType(mappingObject.getValue());
    }

    private void selectLoadWaveFileFormat(MappingObject mappingObject) {
        StorageLoadParam storageLoadParam;
        if (mappingObject == null || (storageLoadParam = this.storageLoadParam) == null) {
            return;
        }
        storageLoadParam.setWaveFileType(mappingObject.getValue());
    }

    private void selectLoadChoose(MappingObject mappingObject) {
        StorageLoadParam storageLoadParam;
        if (mappingObject == null || (storageLoadParam = this.storageLoadParam) == null) {
            return;
        }
        ServiceEnum.StorageOperationChoose storageOperationChooseFromValue1 = ServiceEnum.getStorageOperationChooseFromValue1(mappingObject.getValue());
        storageLoadParam.setChoose(storageOperationChooseFromValue1);
        if (storageOperationChooseFromValue1 == ServiceEnum.StorageOperationChoose.WAVE) {
            storageLoadParam.saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_WAV);
            storageLoadParam.saveFileType(storageLoadParam.getWaveFileType());
        } else if (storageOperationChooseFromValue1 == ServiceEnum.StorageOperationChoose.SETUP) {
            storageLoadParam.saveFileProc(ServiceEnum.StorageFunc.FUNC_LOAD_STP);
            storageLoadParam.saveFileType(storageLoadParam.getSetupFileType());
        }
    }

    @Override // com.rigol.scope.adapters.StorageViewPagerAdapter.OnItemClickCallback
    public void onUpgradeItemClick(AdapterStorageUpgradeBinding adapterStorageUpgradeBinding, final View view) {
        Object tag;
        int id = view.getId();
        if (id == R.id.upgrade) {
            if (PopupViewManager.getInstance().getAvailableSize() < 200) {
                ToastUtils.showShort((int) R.string.inf_upgrade_storage_hint);
            } else if (adapterStorageUpgradeBinding.pathNameEditText.getText().toString().contains("DHO800_DHO900") && (tag = adapterStorageUpgradeBinding.pathNameEditText.getTag()) != null) {
                dismiss();
                API.getInstance().UI_PostBool(11, MessageID.MSG_APP_UTILITY_POWER_ON_SET, false);
                PopupViewManager.getInstance().show(UpgradingPopupView.class);
                new AnonymousClass3(tag).start();
            }
        } else if (id == R.id.path_name_edit_text && (view instanceof TextView)) {
            ViewUtil.showDiskManage(((TextView) view).getText().toString(), DiskManageParam.SelectionMode.FILE, new FileFilter() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$usTa4b4kUx2c8_6IYtjUWMLq7qo
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    return StoragePopupView.lambda$onUpgradeItemClick$24(file);
                }
            }, new DiskManagePopupView.Callback() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$qDGHlIk2Y7l1T_1-k_AeHYbXzMc
                @Override // com.rigol.scope.views.diskManage.DiskManagePopupView.Callback
                public final void onFolderSelected(String str) {
                    StoragePopupView.lambda$onUpgradeItemClick$25(view, str);
                }
            });
        }
    }

    /* renamed from: com.rigol.scope.views.storage.StoragePopupView$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass3 extends Thread {
        final /* synthetic */ Object val$pathName;

        AnonymousClass3(Object obj) {
            this.val$pathName = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            ShellUtils.execCmdAsync("su -c \"/rigol/shell/do_update.sh " + this.val$pathName.toString() + "\"", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.views.storage.-$$Lambda$StoragePopupView$3$ZWEqlIEHq-vihOLWLlAGpZSE994
                @Override // com.blankj.utilcode.util.Utils.Consumer
                public final void accept(Object obj) {
                    StoragePopupView.AnonymousClass3.lambda$run$0((ShellUtils.CommandResult) obj);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static /* synthetic */ void lambda$run$0(ShellUtils.CommandResult commandResult) {
            PopupViewManager.getInstance().dismiss(UpgradingPopupView.class);
            if (commandResult.result == 0) {
                ToastUtils.showLong((int) R.string.inf_upgrade_h4);
            } else {
                ToastUtils.showShort((int) R.string.err_msg_do_fail);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$onUpgradeItemClick$24(File file) {
        return file != null && (file.getPath().endsWith(".GEL") || file.isDirectory());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onUpgradeItemClick$25(View view, String str) {
        ((TextView) view).setText(ViewUtil.getDiskUIPathName(str));
        view.setTag(str);
    }

    @Override // com.rigol.scope.adapters.StorageViewPagerAdapter.OnItemClickCallback
    public void onManagerCall(AorBManager aorBManager) {
        this.aorBManager = aorBManager;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.disk_manage) {
            ViewUtil.showDiskManage();
        }
        if (id == R.id.smb_setting) {
            PopupViewManager.getInstance().show(SmbSettingPopupView.class);
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        StorageViewPagerAdapter storageViewPagerAdapter = this.adapter;
        if (storageViewPagerAdapter != null) {
            storageViewPagerAdapter.onLocaleChanged();
        }
        if (this.binding != null) {
            for (int i = 0; i < this.binding.tabs.getTabCount(); i++) {
                TabLayout.Tab tabAt = this.binding.tabs.getTabAt(i);
                if (tabAt != null) {
                    onConfigureTab(tabAt, i);
                }
            }
        }
    }

    @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
    public void onConfigureTab(TabLayout.Tab tab, int i) {
        tab.setText(ViewUtil.getArray(R.array.msg_storage_operation).valueAt(i).getStr());
    }
}
