package com.rigol.scope.data;

import android.text.TextUtils;
import androidx.databinding.Bindable;
import com.blankj.utilcode.util.ConvertUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.utilities.UtilityUtil;
import com.rigol.scope.utilities.ViewUtil;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class DiskManageParam extends BaseParam {
    public static final String DEFAULT_PATH = "/data/UserData";
    private Callback callback;
    private boolean copied;
    @Bindable
    private int count;
    private boolean cut;
    private DiskParam diskParam;
    private FileFilter fileFilter;
    private final List<FileParam> files;
    private final Runnable loadFilesRunnable;
    @Bindable
    private int selectedCount;
    private List<FileParam> selectedFiles;
    private SelectionMode selectionMode;
    private State state;

    /* loaded from: classes2.dex */
    public interface Callback {
        void onFilesLoadStart();

        void onFilesLoaded();

        void onFilesLoading(int i, int i2);
    }

    /* loaded from: classes2.dex */
    public enum SelectionMode {
        NONE,
        ALL,
        FILE,
        DIR
    }

    /* loaded from: classes2.dex */
    public enum State {
        DEFAULT,
        SELECTING,
        PASTING
    }

    public DiskManageParam() {
        super(12);
        this.diskParam = new DiskParam();
        this.files = new ArrayList();
        this.selectedFiles = new ArrayList();
        this.state = State.DEFAULT;
        this.selectionMode = SelectionMode.ALL;
        this.copied = false;
        this.cut = false;
        this.count = 0;
        this.selectedCount = 0;
        this.fileFilter = null;
        this.loadFilesRunnable = new AnonymousClass1();
    }

    /* renamed from: com.rigol.scope.data.DiskManageParam$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            File[] listFiles;
            synchronized (DiskManageParam.class) {
                String path = DiskManageParam.this.diskParam.getPath();
                boolean isFileExists = FileUtils.isFileExists(path);
                boolean isDir = FileUtils.isDir(path);
                if (!isFileExists || !isDir) {
                    path = DiskManageParam.DEFAULT_PATH;
                    DiskManageParam.this.setPath(DiskManageParam.DEFAULT_PATH);
                }
                if (DiskManageParam.this.callback != null) {
                    DiskManageParam.this.callback.onFilesLoadStart();
                }
                File file = new File(path);
                if (DiskManageParam.this.fileFilter != null) {
                    listFiles = file.listFiles(DiskManageParam.this.fileFilter);
                } else {
                    listFiles = file.listFiles();
                }
                if (listFiles == null) {
                    if (DiskManageParam.this.callback != null) {
                        DiskManageParam.this.callback.onFilesLoaded();
                    }
                    return;
                }
                int length = listFiles.length;
                DiskManageParam.this.files.clear();
                int i = 1;
                for (File file2 : listFiles) {
                    if (DiskManageParam.this.callback != null) {
                        DiskManageParam.this.callback.onFilesLoading(i, length);
                    }
                    DiskManageParam.this.addItem(file2, DiskManageParam.this.files);
                    i++;
                }
                DiskManageParam.this.setCount(DiskManageParam.this.files.size());
                DiskManageParam.this.files.sort(new Comparator() { // from class: com.rigol.scope.data.-$$Lambda$DiskManageParam$1$fu68hn1EAca6ErWjS7TH-QJBro4
                    @Override // java.util.Comparator
                    public final int compare(Object obj, Object obj2) {
                        int compareTo;
                        compareTo = ((FileParam) obj).compareTo((File) ((FileParam) obj2));
                        return compareTo;
                    }
                });
                if (DiskManageParam.this.callback != null) {
                    DiskManageParam.this.callback.onFilesLoaded();
                }
            }
        }
    }

    public FileFilter getFileFilter() {
        return this.fileFilter;
    }

    public void setFileFilter(FileFilter fileFilter) {
        this.fileFilter = fileFilter;
    }

    @Bindable
    public String getPath() {
        return this.diskParam.getPath();
    }

    public void setPath(String str) {
        Iterator<DiskParam> it = UtilityUtil.getDiskList().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            DiskParam next = it.next();
            if (next != null) {
                String root = next.getRoot();
                if (!TextUtils.isEmpty(root) && str.startsWith(root)) {
                    setDiskParam(next);
                    break;
                }
            }
        }
        this.diskParam.setPath(str);
        notifyPropertyChanged(242);
        notifyPropertyChanged(602);
    }

    public void setDiskParam(DiskParam diskParam) {
        this.diskParam = diskParam;
        notifyPropertyChanged(242);
    }

    @Bindable
    public DiskParam getDiskParam() {
        return this.diskParam;
    }

    @Bindable
    public SelectionMode getSelectionMode() {
        return this.selectionMode;
    }

    public void setSelectionMode(SelectionMode selectionMode) {
        this.selectionMode = selectionMode;
        notifyPropertyChanged(795);
    }

    public boolean isCopied() {
        return this.copied;
    }

    public void setCopied(boolean z) {
        this.copied = z;
        if (z) {
            refreshSelectedFiles();
        }
    }

    public boolean isCut() {
        return this.cut;
    }

    public void setCut(boolean z) {
        this.cut = z;
        if (z) {
            refreshSelectedFiles();
        }
    }

    private void refreshSelectedFiles() {
        this.selectedFiles.clear();
        for (FileParam fileParam : getFiles()) {
            if (fileParam != null && fileParam.isSelected()) {
                this.selectedFiles.add(fileParam);
            }
        }
    }

    public List<FileParam> getFiles() {
        return this.files;
    }

    public List<FileParam> getSelectedFiles() {
        return this.selectedFiles;
    }

    public void setSelectedFiles(List<FileParam> list) {
        this.selectedFiles = list;
    }

    public void setCount(int i) {
        this.count = i;
        notifyPropertyChanged(190);
    }

    public int getCount() {
        return this.count;
    }

    public void setSelectedCount(int i) {
        this.selectedCount = i;
        notifyPropertyChanged(794);
    }

    public int getSelectedCount() {
        return this.selectedCount;
    }

    public void selectAll() {
        for (FileParam fileParam : getFiles()) {
            if (fileParam != null) {
                fileParam.setSelected(true);
            }
        }
        setSelectedCount(getFiles().size());
    }

    public void unSelectAll() {
        for (FileParam fileParam : getFiles()) {
            if (fileParam != null) {
                fileParam.setSelected(false);
            }
        }
        setSelectedCount(0);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    public synchronized void loadFiles() {
        ThreadUtils.getIoPool().submit(this.loadFilesRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addItem(File file, List<FileParam> list) {
        if (file == null || file.getPath().isEmpty()) {
            return;
        }
        FileParam fileParam = new FileParam(file.getPath());
        fileParam.setSize(ConvertUtils.byte2FitMemorySize(file.length()));
        fileParam.setPic(ViewUtil.isImageFile(fileParam.getPath()));
        list.add(fileParam);
    }

    private String getFilePermissions(File file) {
        String str = file.canRead() ? "r" : "-";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(file.canWrite() ? "w" : "-");
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(file.canExecute() ? "d" : "-");
        return sb3.toString();
    }

    public void backward() {
        if (TextUtils.isEmpty(this.diskParam.getPath())) {
            setPath(this.diskParam.getRoot());
            loadFiles();
            return;
        }
        String parent = new File(this.diskParam.getPath()).getParent();
        if (!TextUtils.isEmpty(parent) && parent != null && parent.startsWith(this.diskParam.getRoot())) {
            setPath(parent);
        } else {
            setPath(this.diskParam.getRoot());
        }
        loadFiles();
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        unSelectAll();
        this.copied = false;
        this.cut = false;
        setState(State.DEFAULT);
        this.selectedFiles.clear();
    }

    @Bindable
    public State getState() {
        return this.state;
    }

    public void setState(State state) {
        this.state = state;
        notifyPropertyChanged(906);
    }
}
