package com.blankj.utilcode.util;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.blankj.utilcode.constant.RegexConstants;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import kotlin.jvm.internal.ByteCompanionObject;

/* loaded from: classes.dex */
public final class FileUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    /* loaded from: classes.dex */
    public interface OnReplaceListener {
        boolean onReplace(File file, File file2);
    }

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static File getFileByPath(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    public static boolean isFileExists(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return isFileExists(file.getAbsolutePath());
    }

    public static boolean isFileExists(String str) {
        File fileByPath = getFileByPath(str);
        if (fileByPath == null) {
            return false;
        }
        if (fileByPath.exists()) {
            return true;
        }
        return isFileExistsApi29(str);
    }

    private static boolean isFileExistsApi29(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = Utils.getApp().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
                if (openAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    openAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || UtilsBridge.isSpace(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isDir(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? !file.mkdirs() : !file.isDirectory());
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean createFileByDeleteOldFile(String str) {
        return createFileByDeleteOldFile(getFileByPath(str));
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((!file.exists() || file.delete()) && createOrExistsDir(file.getParentFile())) {
            try {
                return file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean copy(String str, String str2) {
        return copy(getFileByPath(str), getFileByPath(str2), (OnReplaceListener) null);
    }

    public static boolean copy(String str, String str2, OnReplaceListener onReplaceListener) {
        return copy(getFileByPath(str), getFileByPath(str2), onReplaceListener);
    }

    public static boolean copy(File file, File file2) {
        return copy(file, file2, (OnReplaceListener) null);
    }

    public static boolean copy(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return copyDir(file, file2, onReplaceListener);
        }
        return copyFile(file, file2, onReplaceListener);
    }

    private static boolean copyDir(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveDir(file, file2, onReplaceListener, false);
    }

    private static boolean copyFile(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveFile(file, file2, onReplaceListener, false);
    }

    public static boolean move(String str, String str2) {
        return move(getFileByPath(str), getFileByPath(str2), (OnReplaceListener) null);
    }

    public static boolean move(String str, String str2, OnReplaceListener onReplaceListener) {
        return move(getFileByPath(str), getFileByPath(str2), onReplaceListener);
    }

    public static boolean move(File file, File file2) {
        return move(file, file2, (OnReplaceListener) null);
    }

    public static boolean move(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return moveDir(file, file2, onReplaceListener);
        }
        return moveFile(file, file2, onReplaceListener);
    }

    public static boolean moveDir(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveDir(file, file2, onReplaceListener, true);
    }

    public static boolean moveFile(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveFile(file, file2, onReplaceListener, true);
    }

    private static boolean copyOrMoveDir(File file, File file2, OnReplaceListener onReplaceListener, boolean z) {
        if (file == null || file2 == null) {
            return false;
        }
        String str = file2.getPath() + File.separator;
        if (!str.contains(file.getPath() + File.separator) && file.exists() && file.isDirectory() && createOrExistsDir(file2)) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file3 : listFiles) {
                    File file4 = new File(str + file3.getName());
                    if (file3.isFile()) {
                        if (!copyOrMoveFile(file3, file4, onReplaceListener, z)) {
                            return false;
                        }
                    } else if (file3.isDirectory() && !copyOrMoveDir(file3, file4, onReplaceListener, z)) {
                        return false;
                    }
                }
            }
            return !z || deleteDir(file);
        }
        return false;
    }

    private static boolean copyOrMoveFile(File file, File file2, OnReplaceListener onReplaceListener, boolean z) {
        if (file != null && file2 != null && !file.equals(file2) && file.exists() && file.isFile()) {
            if (file2.exists()) {
                if (onReplaceListener != null && !onReplaceListener.onReplace(file, file2)) {
                    return true;
                }
                if (!file2.delete()) {
                    return false;
                }
            }
            if (!createOrExistsDir(file2.getParentFile())) {
                return false;
            }
            try {
                if (UtilsBridge.writeFileFromIS(file2.getAbsolutePath(), new FileInputStream(file))) {
                    if (z) {
                        if (!deleteFile(file)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public static boolean delete(String str) {
        return delete(getFileByPath(str));
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        if (file.isDirectory()) {
            return deleteDir(file);
        }
        return deleteFile(file);
    }

    private static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length > 0) {
                    for (File file2 : listFiles) {
                        if (file2.isFile()) {
                            if (!file2.delete()) {
                                return false;
                            }
                        } else if (file2.isDirectory() && !deleteDir(file2)) {
                            return false;
                        }
                    }
                }
                return file.delete();
            }
            return false;
        }
        return true;
    }

    private static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean deleteAllInDir(String str) {
        return deleteAllInDir(getFileByPath(str));
    }

    public static boolean deleteAllInDir(File file) {
        return deleteFilesInDirWithFilter(file, new FileFilter() { // from class: com.blankj.utilcode.util.FileUtils.1
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return true;
            }
        });
    }

    public static boolean deleteFilesInDir(String str) {
        return deleteFilesInDir(getFileByPath(str));
    }

    public static boolean deleteFilesInDir(File file) {
        return deleteFilesInDirWithFilter(file, new FileFilter() { // from class: com.blankj.utilcode.util.FileUtils.2
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return file2.isFile();
            }
        });
    }

    public static boolean deleteFilesInDirWithFilter(String str, FileFilter fileFilter) {
        return deleteFilesInDirWithFilter(getFileByPath(str), fileFilter);
    }

    public static boolean deleteFilesInDirWithFilter(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();
                if (listFiles != null && listFiles.length != 0) {
                    for (File file2 : listFiles) {
                        if (fileFilter.accept(file2)) {
                            if (file2.isFile()) {
                                if (!file2.delete()) {
                                    return false;
                                }
                            } else if (file2.isDirectory() && !deleteDir(file2)) {
                                return false;
                            }
                        }
                    }
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public static List<File> listFilesInDir(String str) {
        return listFilesInDir(str, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(File file) {
        return listFilesInDir(file, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(String str, Comparator<File> comparator) {
        return listFilesInDir(getFileByPath(str), false, comparator);
    }

    public static List<File> listFilesInDir(File file, Comparator<File> comparator) {
        return listFilesInDir(file, false, comparator);
    }

    public static List<File> listFilesInDir(String str, boolean z) {
        return listFilesInDir(getFileByPath(str), z);
    }

    public static List<File> listFilesInDir(File file, boolean z) {
        return listFilesInDir(file, z, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(String str, boolean z, Comparator<File> comparator) {
        return listFilesInDir(getFileByPath(str), z, comparator);
    }

    public static List<File> listFilesInDir(File file, boolean z, Comparator<File> comparator) {
        return listFilesInDirWithFilter(file, new FileFilter() { // from class: com.blankj.utilcode.util.FileUtils.3
            @Override // java.io.FileFilter
            public boolean accept(File file2) {
                return true;
            }
        }, z, comparator);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter) {
        return listFilesInDirWithFilter(file, fileFilter, false, (Comparator<File>) null);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, Comparator<File> comparator) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, comparator);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, Comparator<File> comparator) {
        return listFilesInDirWithFilter(file, fileFilter, false, comparator);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, boolean z) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, z);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, boolean z) {
        return listFilesInDirWithFilter(file, fileFilter, z, (Comparator<File>) null);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, boolean z, Comparator<File> comparator) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, z, comparator);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, boolean z, Comparator<File> comparator) {
        List<File> listFilesInDirWithFilterInner = listFilesInDirWithFilterInner(file, fileFilter, z);
        if (comparator != null) {
            Collections.sort(listFilesInDirWithFilterInner, comparator);
        }
        return listFilesInDirWithFilterInner;
    }

    private static List<File> listFilesInDirWithFilterInner(File file, FileFilter fileFilter, boolean z) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (isDir(file) && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z && file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilterInner(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }

    public static long getFileLastModified(String str) {
        return getFileLastModified(getFileByPath(str));
    }

    public static long getFileLastModified(File file) {
        if (file == null) {
            return -1L;
        }
        return file.lastModified();
    }

    public static String getFileCharsetSimple(String str) {
        return getFileCharsetSimple(getFileByPath(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x004f A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getFileCharsetSimple(File file) {
        if (file == null) {
            return "";
        }
        if (isUtf8(file)) {
            return "UTF-8";
        }
        int i = 0;
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        i = bufferedInputStream2.read() + (bufferedInputStream2.read() << 8);
                        bufferedInputStream2.close();
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (i == 65279) {
                        }
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            return i == 65279 ? i != 65534 ? "GBK" : "Unicode" : "UTF-16BE";
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isUtf8(String str) {
        return isUtf8(getFileByPath(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [966=4, 969=4] */
    public static boolean isUtf8(File file) {
        if (file == null) {
            return false;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            try {
                byte[] bArr = new byte[24];
                BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    int read = bufferedInputStream2.read(bArr);
                    if (read == -1) {
                        try {
                            bufferedInputStream2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return false;
                    }
                    byte[] bArr2 = new byte[read];
                    System.arraycopy(bArr, 0, bArr2, 0, read);
                    boolean z = isUtf8(bArr2) == 100;
                    try {
                        bufferedInputStream2.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    return z;
                } catch (IOException e3) {
                    e = e3;
                    bufferedInputStream = bufferedInputStream2;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e4) {
                            e4.printStackTrace();
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (IOException e6) {
                e = e6;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static int isUtf8(byte[] bArr) {
        if (bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return 100;
        }
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i < length) {
            if ((bArr[i] & (-1)) == -1 || (bArr[i] & (-2)) == -2) {
                return 0;
            }
            if (i4 == 0) {
                if ((bArr[i] & ByteCompanionObject.MAX_VALUE) == bArr[i] && bArr[i] != 0) {
                    i2++;
                } else if ((bArr[i] & (-64)) == -64) {
                    int i5 = i4;
                    for (int i6 = 0; i6 < 8; i6++) {
                        byte b = (byte) (128 >> i6);
                        if ((bArr[i] & b) != b) {
                            break;
                        }
                        i5 = i6;
                    }
                    i3++;
                    i4 = i5;
                }
                i++;
            } else {
                if (bArr.length - i <= i4) {
                    i4 = bArr.length - i;
                }
                boolean z = false;
                for (int i7 = 0; i7 < i4; i7++) {
                    int i8 = i + i7;
                    if ((bArr[i8] & ByteCompanionObject.MIN_VALUE) != -128) {
                        if ((bArr[i8] & ByteCompanionObject.MAX_VALUE) == bArr[i8] && bArr[i] != 0) {
                            i2++;
                        }
                        z = true;
                    }
                }
                if (z) {
                    i3--;
                    i++;
                } else {
                    i3 += i4;
                    i += i4;
                }
                i4 = 0;
            }
        }
        if (i2 == length) {
            return 100;
        }
        return (int) (((i3 + i2) / length) * 100.0f);
    }

    public static int getFileLines(String str) {
        return getFileLines(getFileByPath(str));
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:34:0x0055 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:45:0x005e */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:46:0x0002 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:48:0x0002 */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r6 >= r3) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r1[r6] != 10) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002d, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0030, code lost:
        r3 = r2.read(r1, 0, 1024);
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r3 == (-1)) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r6 >= r3) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003d, code lost:
        if (r1[r6] != 13) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003f, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0044, code lost:
        r2.close();
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (com.blankj.utilcode.util.FileUtils.LINE_SEP.endsWith("\n") != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001c, code lost:
        r3 = r2.read(r1, 0, 1024);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (r3 == (-1)) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        r6 = 0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0049 -> B:45:0x005e). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int getFileLines(File file) {
        int i = 1;
        BufferedInputStream bufferedInputStream = 0;
        try {
            try {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        byte[] bArr = new byte[1024];
                    } catch (IOException e) {
                        e = e;
                        bufferedInputStream = bufferedInputStream2;
                        e.printStackTrace();
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                            bufferedInputStream = bufferedInputStream;
                        }
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        bufferedInputStream = bufferedInputStream2;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e2) {
                                e2.printStackTrace();
                            }
                        }
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                bufferedInputStream = bufferedInputStream;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String getSize(String str) {
        return getSize(getFileByPath(str));
    }

    public static String getSize(File file) {
        if (file == null) {
            return "";
        }
        if (file.isDirectory()) {
            return getDirSize(file);
        }
        return getFileSize(file);
    }

    private static String getDirSize(File file) {
        long dirLength = getDirLength(file);
        return dirLength == -1 ? "" : UtilsBridge.byte2FitMemorySize(dirLength);
    }

    private static String getFileSize(File file) {
        long fileLength = getFileLength(file);
        return fileLength == -1 ? "" : UtilsBridge.byte2FitMemorySize(fileLength);
    }

    public static long getLength(String str) {
        return getLength(getFileByPath(str));
    }

    public static long getLength(File file) {
        if (file == null) {
            return 0L;
        }
        if (file.isDirectory()) {
            return getDirLength(file);
        }
        return getFileLength(file);
    }

    private static long getDirLength(File file) {
        long length;
        long j = 0;
        if (isDir(file)) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        length = getDirLength(file2);
                    } else {
                        length = file2.length();
                    }
                    j += length;
                }
            }
            return j;
        }
        return 0L;
    }

    public static long getFileLength(String str) {
        if (str.matches(RegexConstants.REGEX_URL)) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setRequestProperty("Accept-Encoding", "identity");
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    return httpsURLConnection.getContentLength();
                }
                return -1L;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return getFileLength(getFileByPath(str));
    }

    private static long getFileLength(File file) {
        if (isFile(file)) {
            return file.length();
        }
        return -1L;
    }

    public static String getFileMD5ToString(String str) {
        return getFileMD5ToString(UtilsBridge.isSpace(str) ? null : new File(str));
    }

    public static String getFileMD5ToString(File file) {
        return UtilsBridge.bytes2HexString(getFileMD5(file));
    }

    public static byte[] getFileMD5(String str) {
        return getFileMD5(getFileByPath(str));
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:34:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:44:0x003e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] getFileMD5(File file) {
        DigestInputStream digestInputStream;
        DigestInputStream digestInputStream2;
        DigestInputStream digestInputStream3 = null;
        try {
            if (file == null) {
                return null;
            }
            try {
                digestInputStream2 = new DigestInputStream(new FileInputStream(file), MessageDigest.getInstance("MD5"));
            } catch (IOException e) {
                e = e;
                digestInputStream2 = null;
                e.printStackTrace();
                if (digestInputStream2 != null) {
                }
                return null;
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                digestInputStream2 = null;
                e.printStackTrace();
                if (digestInputStream2 != null) {
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (digestInputStream3 != null) {
                    try {
                        digestInputStream3.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
            try {
                do {
                } while (digestInputStream2.read(new byte[262144]) > 0);
                byte[] digest = digestInputStream2.getMessageDigest().digest();
                try {
                    digestInputStream2.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                return digest;
            } catch (IOException e5) {
                e = e5;
                e.printStackTrace();
                if (digestInputStream2 != null) {
                    try {
                        digestInputStream2.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                return null;
            } catch (NoSuchAlgorithmException e7) {
                e = e7;
                e.printStackTrace();
                if (digestInputStream2 != null) {
                }
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
            digestInputStream3 = digestInputStream;
        }
    }

    public static String getDirName(File file) {
        return file == null ? "" : getDirName(file.getAbsolutePath());
    }

    public static String getDirName(String str) {
        int lastIndexOf;
        return (UtilsBridge.isSpace(str) || (lastIndexOf = str.lastIndexOf(File.separator)) == -1) ? "" : str.substring(0, lastIndexOf + 1);
    }

    public static String getFileName(File file) {
        return file == null ? "" : getFileName(file.getAbsolutePath());
    }

    public static String getFileName(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public static String getFileNameNoExtension(File file) {
        return file == null ? "" : getFileNameNoExtension(file.getPath());
    }

    public static String getFileNameNoExtension(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        if (lastIndexOf2 == -1) {
            return lastIndexOf == -1 ? str : str.substring(0, lastIndexOf);
        } else if (lastIndexOf == -1 || lastIndexOf2 > lastIndexOf) {
            return str.substring(lastIndexOf2 + 1);
        } else {
            return str.substring(lastIndexOf2 + 1, lastIndexOf);
        }
    }

    public static String getFileExtension(File file) {
        return file == null ? "" : getFileExtension(file.getPath());
    }

    public static String getFileExtension(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || str.lastIndexOf(File.separator) >= lastIndexOf) ? "" : str.substring(lastIndexOf + 1);
    }

    public static void notifySystemToScan(String str) {
        notifySystemToScan(getFileByPath(str));
    }

    public static void notifySystemToScan(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        intent.setData(Uri.parse("file://" + file.getAbsolutePath()));
        Utils.getApp().sendBroadcast(intent);
    }

    public static long getFsTotalSize(String str) {
        long blockSize;
        long blockCount;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            blockCount = statFs.getBlockCountLong();
        } else {
            blockSize = statFs.getBlockSize();
            blockCount = statFs.getBlockCount();
        }
        return blockSize * blockCount;
    }

    public static long getFsAvailableSize(String str) {
        long blockSize;
        long availableBlocks;
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            blockSize = statFs.getBlockSizeLong();
            availableBlocks = statFs.getAvailableBlocksLong();
        } else {
            blockSize = statFs.getBlockSize();
            availableBlocks = statFs.getAvailableBlocks();
        }
        return blockSize * availableBlocks;
    }
}
