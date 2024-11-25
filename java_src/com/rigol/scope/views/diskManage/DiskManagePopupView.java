package com.rigol.scope.views.diskManage;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.GravityCompat;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ShellUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.blankj.utilcode.util.Utils;
import com.rigol.pinyinkeyboard.ExternalInterface;
import com.rigol.scope.ImagePreviewActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapter;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.DiskManageAdapter;
import com.rigol.scope.adapters.OnItemClickListener;
import com.rigol.scope.adapters.OnItemLongClickListener;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DiskManageParam;
import com.rigol.scope.data.DiskParam;
import com.rigol.scope.data.FileParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.databinding.AdapterItemSpinnerBinding;
import com.rigol.scope.databinding.PopupviewDiskManageBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FileUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.UtilityUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WeakRefHandler;
import com.rigol.scope.viewmodels.DiskManageViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.views.CopyingLoading;
import com.rigol.scope.views.CuttingLoading;
import com.rigol.scope.views.DeletingLoading;
import com.rigol.scope.views.FileSaveLoading;
import com.rigol.scope.views.LoadingPopupView;
import com.rigol.scope.views.alert.CleanDiskPopupView;
import com.rigol.scope.views.alert.CopyFilePopupView;
import com.rigol.scope.views.alert.DeleteFilePopupView;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.diskManage.DiskManagePopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import com.rigol.util.ToastUtils;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class DiskManagePopupView extends BasePopupView implements View.OnClickListener {
    private final int MSG_COPY;
    private final DiskManageAdapter adapter;
    private final PopupviewDiskManageBinding binding;
    private Callback callback;
    private final Handler copyHandler;
    private int fileOP;
    private boolean isSame;
    private boolean isStartCopy;
    private final ObservableBoolean loadingFiles;
    private BasePopupView loadingPopupView;
    private List<String> mCopyList;
    private List<FileParam> mFileList;
    private DiskManageParam param;
    private final Runnable refreshListRunnable;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onFolderSelected(String str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.diskManage.DiskManagePopupView$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass2 implements Handler.Callback {
        AnonymousClass2() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 100) {
                BasePopupView basePopupView = PopupViewManager.getInstance().get(CopyFilePopupView.class);
                if (basePopupView instanceof CopyFilePopupView) {
                    CopyFilePopupView copyFilePopupView = (CopyFilePopupView) basePopupView;
                    copyFilePopupView.setConfirmListener(new View.OnClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$2$dz_-n4GrWZf2zEIKHKEkEyXGldw
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DiskManagePopupView.AnonymousClass2.this.lambda$handleMessage$0$DiskManagePopupView$2(view);
                        }
                    });
                    copyFilePopupView.setCancelListener(new View.OnClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$2$bg5yGmKt2MxgJATbQV2EnVT_LIg
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            DiskManagePopupView.AnonymousClass2.this.lambda$handleMessage$1$DiskManagePopupView$2(view);
                        }
                    });
                }
                basePopupView.show();
                return false;
            }
            return false;
        }

        public /* synthetic */ void lambda$handleMessage$0$DiskManagePopupView$2(View view) {
            DiskManagePopupView.this.onCopy();
        }

        public /* synthetic */ void lambda$handleMessage$1$DiskManagePopupView$2(View view) {
            DiskManagePopupView.this.isSame = true;
        }
    }

    public DiskManagePopupView() {
        super((int) R.style.App_PopupWindow_DiskManage);
        this.mCopyList = null;
        this.mFileList = new ArrayList();
        this.fileOP = 0;
        this.loadingFiles = new ObservableBoolean(false);
        this.loadingPopupView = null;
        this.isSame = true;
        this.isStartCopy = true;
        this.MSG_COPY = 100;
        this.refreshListRunnable = new Runnable() { // from class: com.rigol.scope.views.diskManage.DiskManagePopupView.1
            @Override // java.lang.Runnable
            public void run() {
                DiskManagePopupView.this.mFileList.clear();
                DiskManagePopupView.this.mFileList.addAll(DiskManagePopupView.this.param.getFiles());
                DiskManagePopupView.this.adapter.notifyDataSetChanged();
            }
        };
        this.copyHandler = new WeakRefHandler(new AnonymousClass2());
        PopupviewDiskManageBinding inflate = PopupviewDiskManageBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        inflate.setLoadingFiles(this.loadingFiles);
        this.binding.setClickListener(this);
        setContentView(this.binding.getRoot());
        DiskManageViewModel diskManageViewModel = (DiskManageViewModel) ContextUtil.getAppViewModel(DiskManageViewModel.class);
        if (diskManageViewModel != null) {
            diskManageViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$kwSsrw2GR2m5OknOQFF0az4czoQ
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    DiskManagePopupView.this.lambda$new$0$DiskManagePopupView((DiskManageParam) obj);
                }
            });
        }
        SharedViewModel sharedViewModel = (SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class);
        if (sharedViewModel != null) {
            final PopupviewDiskManageBinding popupviewDiskManageBinding = this.binding;
            Objects.requireNonNull(popupviewDiskManageBinding);
            sharedViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$xxb0S-bwQ8jSjHKaiRr4-_pEA00
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    PopupviewDiskManageBinding.this.setShareParam((SharedParam) obj);
                }
            });
        }
        DiskManageAdapter diskManageAdapter = new DiskManageAdapter(this.context, R.layout.adapter_item_disk_manage);
        this.adapter = diskManageAdapter;
        diskManageAdapter.setItems(this.mFileList);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$G-t2etZYQ9sLNrvkBUj0aS8KpeU
            @Override // com.rigol.scope.adapters.OnItemClickListener
            public final void onItemClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                DiskManagePopupView.this.lambda$new$1$DiskManagePopupView(view, viewHolder, i);
            }
        });
        this.adapter.setOnItemLongClickListener(new OnItemLongClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$oA1Vq8vSZhYpFZ-SqY64J90qBOQ
            @Override // com.rigol.scope.adapters.OnItemLongClickListener
            public final boolean onItemLongClick(View view, RecyclerView.ViewHolder viewHolder, int i) {
                return DiskManagePopupView.this.lambda$new$2$DiskManagePopupView(view, viewHolder, i);
            }
        });
        this.adapter.setOnSelectedListener(new DiskManageAdapter.OnSelectedListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$0xgu2FvbUcSpE4vQkJNJvB8VgYw
            @Override // com.rigol.scope.adapters.DiskManageAdapter.OnSelectedListener
            public final void onSelected(View view, FileParam fileParam) {
                DiskManagePopupView.this.lambda$new$3$DiskManagePopupView(view, fileParam);
            }
        });
        ViewUtil.setSupportsChangeAnimations(this.binding.fileList, false);
        this.binding.fileList.setAdapter(this.adapter);
    }

    public /* synthetic */ void lambda$new$0$DiskManagePopupView(DiskManageParam diskManageParam) {
        this.param = diskManageParam;
        this.binding.setDiskParam(diskManageParam);
        this.param.setCallback(new AnonymousClass3());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.views.diskManage.DiskManagePopupView$3  reason: invalid class name */
    /* loaded from: classes2.dex */
    public class AnonymousClass3 implements DiskManageParam.Callback {
        AnonymousClass3() {
        }

        @Override // com.rigol.scope.data.DiskManageParam.Callback
        public void onFilesLoadStart() {
            DiskManagePopupView.this.loadingFiles.set(true);
        }

        @Override // com.rigol.scope.data.DiskManageParam.Callback
        public void onFilesLoading(int i, int i2) {
            final String str = ContextUtil.getString(R.string.msg_storage_load_toast) + "(" + i + " / " + i2 + ")";
            ThreadUtils.runOnUiThread(new Runnable() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$3$Layq-N37mWsM5ydf_c33-6Q_SPE
                @Override // java.lang.Runnable
                public final void run() {
                    DiskManagePopupView.AnonymousClass3.this.lambda$onFilesLoading$0$DiskManagePopupView$3(str);
                }
            });
        }

        public /* synthetic */ void lambda$onFilesLoading$0$DiskManagePopupView$3(String str) {
            DiskManagePopupView.this.binding.loading.setText(str);
        }

        @Override // com.rigol.scope.data.DiskManageParam.Callback
        public void onFilesLoaded() {
            DiskManagePopupView.this.loadingFiles.set(false);
            ThreadUtils.runOnUiThread(DiskManagePopupView.this.refreshListRunnable);
        }
    }

    public /* synthetic */ void lambda$new$1$DiskManagePopupView(View view, RecyclerView.ViewHolder viewHolder, int i) {
        onItemClick(i);
    }

    public /* synthetic */ boolean lambda$new$2$DiskManagePopupView(View view, RecyclerView.ViewHolder viewHolder, int i) {
        onItemLongClick(i);
        return true;
    }

    public /* synthetic */ void lambda$new$3$DiskManagePopupView(View view, FileParam fileParam) {
        onItemSelected(fileParam);
    }

    public void setSelectionMode(DiskManageParam.SelectionMode selectionMode) {
        DiskManageParam diskManageParam = this.param;
        if (diskManageParam != null) {
            diskManageParam.setSelectionMode(selectionMode);
        }
    }

    public void setFilter(FileFilter fileFilter) {
        DiskManageParam diskManageParam = this.param;
        if (diskManageParam != null) {
            diskManageParam.setFileFilter(fileFilter);
        }
    }

    public void setRootPath(String str) {
        if (TextUtils.isEmpty(str)) {
            this.param.setPath(DiskManageParam.DEFAULT_PATH);
            this.param.setDiskParam(new DiskParam());
        } else if (this.param != null) {
            File file = new File(str);
            if (file.exists()) {
                if (file.isFile()) {
                    this.param.setPath(file.getParent());
                    return;
                }
                this.param.setPath(str);
                this.param.loadFiles();
            }
        }
    }

    private void onItemSelected(FileParam fileParam) {
        this.param.setSelectedCount(fileParam.isSelected() ? this.param.getSelectedCount() + 1 : this.param.getSelectedCount() - 1);
        DiskManageParam diskManageParam = this.param;
        diskManageParam.setState(diskManageParam.getSelectedCount() == 0 ? DiskManageParam.State.DEFAULT : DiskManageParam.State.SELECTING);
        this.adapter.notifyDataSetChanged();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    private void onItemLongClick(int i) {
        FileParam fileParam;
        if (this.param.getState() != DiskManageParam.State.DEFAULT || (fileParam = (FileParam) this.adapter.getItems().get(i)) == null || TextUtils.isEmpty(fileParam.getPath())) {
            return;
        }
        fileParam.setSelected(!fileParam.isSelected());
        onItemSelected(fileParam);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    private void onItemClick(int i) {
        FileParam fileParam = (FileParam) this.adapter.getItems().get(i);
        if (fileParam == null || TextUtils.isEmpty(fileParam.getPath())) {
            return;
        }
        if (this.param.getState() == DiskManageParam.State.SELECTING) {
            fileParam.setSelected(!fileParam.isSelected());
            onItemSelected(fileParam);
        } else if (FileUtils.isDir(fileParam.getPath())) {
            this.param.setPath(fileParam.getPath());
            this.param.loadFiles();
        } else if (fileParam.isPic()) {
            Intent intent = new Intent();
            intent.setClass(this.context, ImagePreviewActivity.class);
            intent.putExtra(ImagePreviewActivity.IMAGE_FILE_PATH, fileParam.getPath());
            this.context.startActivity(intent);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        StorageSaveParam value;
        String str;
        FileParam fileParam;
        String name;
        final String substring;
        String substring2;
        final int id = view.getId();
        if (id == R.id.backward) {
            if (this.param.getState() == DiskManageParam.State.SELECTING) {
                this.param.reset();
            } else {
                this.param.backward();
            }
        } else if (id == R.id.select_all) {
            this.param.selectAll();
            this.adapter.notifyDataSetChanged();
            this.param.setState(DiskManageParam.State.SELECTING);
        } else if (id == R.id.select_cancel || id == R.id.cancel) {
            this.param.reset();
            this.adapter.notifyDataSetChanged();
        } else {
            int i = 0;
            if (id == R.id.copy) {
                this.param.setCopied(true);
                this.param.setCut(false);
                this.param.setState(DiskManageParam.State.PASTING);
            } else if (id == R.id.cut) {
                this.param.setCut(true);
                this.param.setCopied(false);
                this.param.setState(DiskManageParam.State.PASTING);
            } else if (id == R.id.delete) {
                if (this.param.getSelectedCount() <= 0) {
                    return;
                }
                BasePopupView basePopupView = PopupViewManager.getInstance().get(DeleteFilePopupView.class);
                if (basePopupView instanceof DeleteFilePopupView) {
                    ((DeleteFilePopupView) basePopupView).setConfirmListener(new View.OnClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$shBGYzn4P8p9cMijrgy7LTGwKrs
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            DiskManagePopupView.this.lambda$onClick$5$DiskManagePopupView(view2);
                        }
                    });
                    basePopupView.show();
                }
            } else if (id == R.id.rename) {
                if (this.param.getSelectedCount() > 1) {
                    return;
                }
                Iterator<FileParam> it = this.param.getFiles().iterator();
                while (true) {
                    str = null;
                    if (!it.hasNext()) {
                        fileParam = null;
                        break;
                    }
                    fileParam = it.next();
                    if (fileParam != null && fileParam.isSelected()) {
                        break;
                    }
                }
                if (fileParam == null) {
                    return;
                }
                boolean contains = fileParam.getName().contains(".") ? fileParam.getName().contains(".") : false;
                if (contains && fileParam.getAbsoluteFile().isDirectory()) {
                    name = fileParam.getName();
                    str = "";
                } else if (contains && fileParam.getAbsoluteFile().isFile()) {
                    substring = fileParam.getName().substring(fileParam.getName().lastIndexOf("."));
                    substring2 = fileParam.getName().substring(0, fileParam.getName().lastIndexOf("."));
                    final String path = fileParam.getPath();
                    final String dirName = FileUtils.getDirName(path);
                    FileUtils.getFileNameNoExtension(fileParam);
                    FileUtils.getFileExtension(fileParam);
                    final boolean z = contains;
                    ViewUtil.showSavePinyinKeyboard(this.context, this.anchor, this.binding.rename, true, substring2, new ExternalInterface() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$eJtlnINGcVXg0koK_pClvUpAEhM
                        @Override // com.rigol.pinyinkeyboard.ExternalInterface
                        public final void resultShow(String str2) {
                            DiskManagePopupView.this.lambda$onClick$7$DiskManagePopupView(z, substring, path, dirName, str2);
                        }
                    }, 17, 0, 0);
                } else {
                    name = fileParam.getName();
                }
                substring2 = name;
                substring = str;
                final String path2 = fileParam.getPath();
                final String dirName2 = FileUtils.getDirName(path2);
                FileUtils.getFileNameNoExtension(fileParam);
                FileUtils.getFileExtension(fileParam);
                final boolean z2 = contains;
                ViewUtil.showSavePinyinKeyboard(this.context, this.anchor, this.binding.rename, true, substring2, new ExternalInterface() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$eJtlnINGcVXg0koK_pClvUpAEhM
                    @Override // com.rigol.pinyinkeyboard.ExternalInterface
                    public final void resultShow(String str2) {
                        DiskManagePopupView.this.lambda$onClick$7$DiskManagePopupView(z2, substring, path2, dirName2, str2);
                    }
                }, 17, 0, 0);
            } else if (id == R.id.create_file || id == R.id.create_folder) {
                ViewUtil.showSavePinyinKeyboard(this.context, this.anchor, view, true, null, new ExternalInterface() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$pF3RVlJIDJ2_rTXsLzt_MNVLDaY
                    @Override // com.rigol.pinyinkeyboard.ExternalInterface
                    public final void resultShow(String str2) {
                        DiskManagePopupView.this.lambda$onClick$9$DiskManagePopupView(id, str2);
                    }
                }, 17, 0, 0);
            } else if (id == R.id.paste) {
                onCopy();
            } else if (id == R.id.ok) {
                if (this.callback != null) {
                    if (this.param.getState() == DiskManageParam.State.DEFAULT) {
                        this.callback.onFolderSelected(this.param.getPath());
                        onShowWrning(this.param.getPath());
                    } else {
                        Iterator<FileParam> it2 = this.param.getFiles().iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            FileParam next = it2.next();
                            if (next != null && next.isSelected()) {
                                this.callback.onFolderSelected(next.getPath());
                                onShowWrning(next.getPath());
                                break;
                            }
                        }
                    }
                }
                dismiss();
            } else if (id == R.id.clean_all) {
                BasePopupView basePopupView2 = PopupViewManager.getInstance().get(CleanDiskPopupView.class);
                if (basePopupView2 instanceof CleanDiskPopupView) {
                    ((CleanDiskPopupView) basePopupView2).setConfirmListener(new View.OnClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$5OsgHUB0zCNGLvPMGWP21J1UcmI
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            DiskManagePopupView.lambda$onClick$10(view2);
                        }
                    });
                    basePopupView2.show();
                    StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                    if (storageViewModel == null || (value = storageViewModel.getSaveLiveData().getValue()) == null) {
                        return;
                    }
                    value.setPathName(DiskManageParam.DEFAULT_PATH);
                }
            } else if (id == R.id.disk_list_arrow || id == R.id.current_path) {
                final PopupSpinner popupSpinner = new PopupSpinner();
                final List<DiskParam> diskList = UtilityUtil.getDiskList();
                BaseAdapter<List<DiskParam>> baseAdapter = new BaseAdapter<List<DiskParam>>(this.context, diskList, R.layout.adapter_item_spinner) { // from class: com.rigol.scope.views.diskManage.DiskManagePopupView.5
                    @Override // com.rigol.scope.adapters.BaseAdapter
                    protected void convert(BaseViewHolder<? extends ViewDataBinding> baseViewHolder, List<DiskParam> list, int i2) {
                        AdapterItemSpinnerBinding adapterItemSpinnerBinding = (AdapterItemSpinnerBinding) baseViewHolder.getBinding();
                        adapterItemSpinnerBinding.title.setText(list.get(i2).getName());
                        if (i2 == getCurrentItem()) {
                            adapterItemSpinnerBinding.titleLayout.setSelected(true);
                        }
                    }

                    @Override // com.rigol.scope.adapters.MultiItemTypeAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
                    public BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder(ViewGroup viewGroup, int i2) {
                        BaseViewHolder<? extends ViewDataBinding> onCreateViewHolder = super.onCreateViewHolder(viewGroup, i2);
                        ViewDataBinding binding = onCreateViewHolder.getBinding();
                        if (binding instanceof AdapterItemSpinnerBinding) {
                            ViewGroup.LayoutParams layoutParams = binding.getRoot().getLayoutParams();
                            layoutParams.width = 210;
                            binding.getRoot().setLayoutParams(layoutParams);
                        }
                        return onCreateViewHolder;
                    }
                };
                baseAdapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$nUKGZs3SfMcRvAYGXdG0G8VlCyw
                    @Override // com.rigol.scope.adapters.OnItemClickListener
                    public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i2) {
                        DiskManagePopupView.this.lambda$onClick$11$DiskManagePopupView(diskList, popupSpinner, view2, viewHolder, i2);
                    }
                });
                while (true) {
                    if (i >= diskList.size()) {
                        break;
                    }
                    DiskParam diskParam = diskList.get(i);
                    if (diskParam != null) {
                        String root = diskParam.getRoot();
                        if (!TextUtils.isEmpty(root) && this.param.getPath().startsWith(root)) {
                            baseAdapter.setCurrentItem(i);
                            break;
                        }
                    }
                    i++;
                }
                popupSpinner.setAdapter(baseAdapter);
                popupSpinner.showAsDropDown(this.anchor, this.binding.currentPath, 0, 5, GravityCompat.START);
            }
        }
    }

    public /* synthetic */ void lambda$onClick$5$DiskManagePopupView(View view) {
        final BasePopupView basePopupView = PopupViewManager.getInstance().get(DeletingLoading.class);
        if (basePopupView != null) {
            basePopupView.show();
        }
        final AnonymousClass4 anonymousClass4 = new AnonymousClass4();
        if (basePopupView instanceof LoadingPopupView) {
            ((LoadingPopupView) basePopupView).setCancelListener(new View.OnClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$X6pR3qCeUr4cdHSnD644b-JWfYA
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    DiskManagePopupView.lambda$onClick$4(BasePopupView.this, anonymousClass4, view2);
                }
            });
        }
        ThreadUtils.executeByIo(anonymousClass4);
    }

    /* renamed from: com.rigol.scope.views.diskManage.DiskManagePopupView$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass4 extends ThreadUtils.SimpleTask<Boolean> {
        AnonymousClass4() {
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public Boolean doInBackground() throws Throwable {
            StorageSaveParam value;
            boolean z = true;
            for (FileParam fileParam : DiskManagePopupView.this.param.getFiles()) {
                if (isCanceled()) {
                    return false;
                }
                if (fileParam != null && fileParam.isSelected()) {
                    z &= FileUtils.delete(fileParam.getPath());
                    StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
                    if (storageViewModel != null && (value = storageViewModel.getSaveLiveData().getValue()) != null && value.getPathName().equals(fileParam.toString())) {
                        value.setPathName(DiskManageParam.DEFAULT_PATH);
                    }
                }
            }
            return Boolean.valueOf(z);
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onSuccess(Boolean bool) {
            if (bool.booleanValue()) {
                ToastUtils.showShort(DiskManagePopupView.this.context.getResources().getString(R.string.msg_storage_success));
                ShellUtils.execCmdAsync("sync", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$4$xclv0mTyvQ9FDrasubt_WgkdNZQ
                    @Override // com.blankj.utilcode.util.Utils.Consumer
                    public final void accept(Object obj) {
                        Timber.d(((ShellUtils.CommandResult) obj).toString(), new Object[0]);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void onDone() {
            super.onDone();
            PopupViewManager.getInstance().dismiss(DeletingLoading.class);
            DiskManagePopupView.this.param.reset();
            DiskManagePopupView.this.param.loadFiles();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onClick$4(BasePopupView basePopupView, ThreadUtils.SimpleTask simpleTask, View view) {
        basePopupView.dismiss();
        simpleTask.cancel();
    }

    public /* synthetic */ void lambda$onClick$7$DiskManagePopupView(boolean z, String str, String str2, String str3, String str4) {
        StorageSaveParam value;
        if (z) {
            str4 = str4 + str;
        }
        if (FileUtils.rename(str2, str4)) {
            ToastUtils.showShort(this.context.getResources().getString(R.string.msg_storage_success));
            this.param.reset();
            this.param.loadFiles();
            StorageViewModel storageViewModel = (StorageViewModel) ContextUtil.getAppViewModel(StorageViewModel.class);
            if (storageViewModel != null && (value = storageViewModel.getSaveLiveData().getValue()) != null && str2.equals(value.getPathName())) {
                value.setPathName(str3 + str4);
            }
            ShellUtils.execCmdAsync("sync", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$b06ZlE-ZKXiOOaizNDMoAbFUmLI
                @Override // com.blankj.utilcode.util.Utils.Consumer
                public final void accept(Object obj) {
                    Timber.d(((ShellUtils.CommandResult) obj).toString(), new Object[0]);
                }
            });
            return;
        }
        ToastUtils.showShort(this.context.getResources().getString(R.string.msg_storage_err_null_exist));
    }

    public /* synthetic */ void lambda$onClick$9$DiskManagePopupView(int i, String str) {
        boolean createOrExistsDir;
        File file = new File(this.param.getPath() + File.separator + str);
        if (file.exists()) {
            ToastUtils.showShort(this.context.getResources().getString(R.string.msg_storage_err_file_exist));
            return;
        }
        if (i == R.id.create_file) {
            createOrExistsDir = FileUtils.createOrExistsFile(file);
        } else {
            createOrExistsDir = FileUtils.createOrExistsDir(file);
        }
        if (createOrExistsDir) {
            ToastUtils.showShort(this.context.getResources().getString(R.string.msg_storage_success));
            ShellUtils.execCmdAsync("sync", true, (Utils.Consumer<ShellUtils.CommandResult>) new Utils.Consumer() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$vFA2W_Cu9qK0W5E4285pesNgHrc
                @Override // com.blankj.utilcode.util.Utils.Consumer
                public final void accept(Object obj) {
                    Timber.d(((ShellUtils.CommandResult) obj).toString(), new Object[0]);
                }
            });
        }
        this.param.loadFiles();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onClick$10(View view) {
        PopupViewManager.getInstance().toggle(DeletingLoading.class);
        API.getInstance().UI_PostInt32(12, MessageID.MSG_STORAGE_FILE_PROC, ServiceEnum.StorageFunc.FUNC_SECURITYCLEAR.value1);
        API.getInstance().UI_PostInt32(12, MessageID.MSG_STORAGE_SECURITYCLEAR, 0);
    }

    public /* synthetic */ void lambda$onClick$11$DiskManagePopupView(List list, PopupSpinner popupSpinner, View view, RecyclerView.ViewHolder viewHolder, int i) {
        DiskParam diskParam = (DiskParam) list.get(i);
        if (diskParam == null) {
            return;
        }
        this.param.setPath(diskParam.getPath());
        this.param.setDiskParam(diskParam);
        this.param.loadFiles();
        popupSpinner.dismiss();
    }

    private void onShowWrning(String str) {
        BasePopupView basePopupView = PopupViewManager.getInstance().get(FileSaveLoading.class);
        if (!str.startsWith(DiskManageParam.DEFAULT_PATH)) {
            LoadingPopupView loadingPopupView = (LoadingPopupView) basePopupView;
            loadingPopupView.isShowWrning().set(true);
            loadingPopupView.setWrningResId(R.string.msg_storage_usb);
            return;
        }
        ((LoadingPopupView) basePopupView).isShowWrning().set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCopy() {
        final List<FileParam> selectedFiles;
        if (this.param.getSelectedCount() <= 0 || (selectedFiles = this.param.getSelectedFiles()) == null || selectedFiles.isEmpty()) {
            return;
        }
        if (this.param.isCopied()) {
            BasePopupView basePopupView = PopupViewManager.getInstance().get(CopyingLoading.class);
            this.loadingPopupView = basePopupView;
            basePopupView.show();
        } else if (this.param.isCut()) {
            BasePopupView basePopupView2 = PopupViewManager.getInstance().get(CuttingLoading.class);
            this.loadingPopupView = basePopupView2;
            basePopupView2.show();
        }
        FileParam fileParam = selectedFiles.get(0);
        if (fileParam != null) {
            String path = fileParam.getPath();
            String str = this.param.getPath() + File.separator + fileParam.getName();
            if (!path.startsWith(DiskManageParam.DEFAULT_PATH) || !str.startsWith(DiskManageParam.DEFAULT_PATH)) {
                ((LoadingPopupView) this.loadingPopupView).isShowWrning().set(true);
                ((LoadingPopupView) this.loadingPopupView).setWrningResId(R.string.msg_storage_usb);
            } else {
                ((LoadingPopupView) this.loadingPopupView).isShowWrning().set(false);
            }
        }
        final ThreadUtils.SimpleTask<Boolean> simpleTask = new ThreadUtils.SimpleTask<Boolean>() { // from class: com.rigol.scope.views.diskManage.DiskManagePopupView.6
            String curFilePath;
            long srcFileSize;

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public Boolean doInBackground() throws Throwable {
                boolean z = false;
                if (DiskManagePopupView.this.mCopyList == null) {
                    DiskManagePopupView.this.mCopyList = new ArrayList();
                    this.srcFileSize = 0L;
                    for (FileParam fileParam2 : selectedFiles) {
                        this.srcFileSize += FileUtil.listFiles(fileParam2, DiskManagePopupView.this.mCopyList);
                    }
                    for (String str2 : DiskManagePopupView.this.mCopyList) {
                        File file = new File(DiskManagePopupView.this.param.getPath(), str2.split("\\|")[1]);
                        if (file.isDirectory()) {
                            file.mkdir();
                        }
                        if (file.exists()) {
                            DiskManagePopupView.this.copyHandler.sendEmptyMessage(100);
                            return false;
                        }
                    }
                }
                try {
                    Iterator it = DiskManagePopupView.this.mCopyList.iterator();
                    while (it.hasNext()) {
                        String str3 = (String) it.next();
                        String[] split = str3.split("\\|");
                        Log.i("YYY", "str=" + str3 + ", str[0]: " + split[0] + ", str[1]:" + split[1] + ", cut:" + DiskManagePopupView.this.param.isCut());
                        it.remove();
                        File file2 = new File(split[0], split[1]);
                        File file3 = new File(DiskManagePopupView.this.param.getPath(), split[1]);
                        Thread.sleep(10L);
                        if (file3.exists()) {
                            Log.i("YYY", "dest exists");
                            file3.delete();
                        }
                        FileUtil.copyOrMove(file2, file3, DiskManagePopupView.this.param.isCut());
                    }
                    z = true;
                } catch (Exception unused) {
                }
                DiskManagePopupView.this.mCopyList = null;
                return Boolean.valueOf(z);
            }

            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onSuccess(Boolean bool) {
                if (bool.booleanValue()) {
                    ToastUtils.showShort(DiskManagePopupView.this.context.getResources().getString(R.string.msg_storage_success));
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.blankj.utilcode.util.ThreadUtils.Task
            public void onDone() {
                super.onDone();
                if (DiskManagePopupView.this.loadingPopupView != null && DiskManagePopupView.this.loadingPopupView.isShowing()) {
                    DiskManagePopupView.this.loadingPopupView.dismiss();
                }
                String str2 = this.curFilePath;
                if (str2 != null && FileUtils.getLength(str2) != this.srcFileSize) {
                    FileUtils.delete(this.curFilePath);
                }
                if (DiskManagePopupView.this.mCopyList == null) {
                    DiskManagePopupView.this.param.reset();
                    DiskManagePopupView.this.param.loadFiles();
                }
            }
        };
        BasePopupView basePopupView3 = this.loadingPopupView;
        if (basePopupView3 instanceof LoadingPopupView) {
            ((LoadingPopupView) basePopupView3).setCancelListener(new View.OnClickListener() { // from class: com.rigol.scope.views.diskManage.-$$Lambda$DiskManagePopupView$KxHMc1_zAq6mCHRyZaj6JHdGGKo
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    DiskManagePopupView.this.lambda$onCopy$12$DiskManagePopupView(simpleTask, view);
                }
            });
        }
        ThreadUtils.executeByIo(simpleTask);
    }

    public /* synthetic */ void lambda$onCopy$12$DiskManagePopupView(ThreadUtils.SimpleTask simpleTask, View view) {
        this.loadingPopupView.dismiss();
        simpleTask.cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onPrepare() {
        super.onPrepare();
        DiskManageParam diskManageParam = this.param;
        if (diskManageParam != null) {
            diskManageParam.loadFiles();
        }
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        DiskManageParam diskManageParam = this.param;
        if (diskManageParam != null) {
            diskManageParam.reset();
        }
    }
}
