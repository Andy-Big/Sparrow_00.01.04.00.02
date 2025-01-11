package com.blankj.utilcode.util;

import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/* loaded from: classes.dex */
public final class ZipUtils {
    private static final int BUFFER_LEN = 8192;

    private ZipUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean zipFiles(Collection<String> collection, String str) throws IOException {
        return zipFiles(collection, str, (String) null);
    }

    public static boolean zipFiles(Collection<String> collection, String str, String str2) throws IOException {
        ZipOutputStream zipOutputStream;
        if (collection == null || str == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(str));
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (String str3 : collection) {
                if (!zipFile(UtilsBridge.getFileByPath(str3), "", zipOutputStream, str2)) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    return false;
                }
            }
            zipOutputStream.finish();
            zipOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                zipOutputStream2.finish();
                zipOutputStream2.close();
            }
            throw th;
        }
    }

    public static boolean zipFiles(Collection<File> collection, File file) throws IOException {
        return zipFiles(collection, file, (String) null);
    }

    public static boolean zipFiles(Collection<File> collection, File file, String str) throws IOException {
        ZipOutputStream zipOutputStream;
        if (collection == null || file == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file));
        } catch (Throwable th) {
            th = th;
        }
        try {
            for (File file2 : collection) {
                if (!zipFile(file2, "", zipOutputStream, str)) {
                    zipOutputStream.finish();
                    zipOutputStream.close();
                    return false;
                }
            }
            zipOutputStream.finish();
            zipOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                zipOutputStream2.finish();
                zipOutputStream2.close();
            }
            throw th;
        }
    }

    public static boolean zipFile(String str, String str2) throws IOException {
        return zipFile(UtilsBridge.getFileByPath(str), UtilsBridge.getFileByPath(str2), (String) null);
    }

    public static boolean zipFile(String str, String str2, String str3) throws IOException {
        return zipFile(UtilsBridge.getFileByPath(str), UtilsBridge.getFileByPath(str2), str3);
    }

    public static boolean zipFile(File file, File file2) throws IOException {
        return zipFile(file, file2, (String) null);
    }

    public static boolean zipFile(File file, File file2, String str) throws IOException {
        ZipOutputStream zipOutputStream;
        if (file == null || file2 == null) {
            return false;
        }
        ZipOutputStream zipOutputStream2 = null;
        try {
            zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
        } catch (Throwable th) {
            th = th;
        }
        try {
            boolean zipFile = zipFile(file, "", zipOutputStream, str);
            zipOutputStream.close();
            return zipFile;
        } catch (Throwable th2) {
            th = th2;
            zipOutputStream2 = zipOutputStream;
            if (zipOutputStream2 != null) {
                zipOutputStream2.close();
            }
            throw th;
        }
    }

    private static boolean zipFile(File file, String str, ZipOutputStream zipOutputStream, String str2) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(UtilsBridge.isSpace(str) ? "" : File.separator);
        sb.append(file.getName());
        String sb2 = sb.toString();
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length <= 0) {
                ZipEntry zipEntry = new ZipEntry(sb2 + '/');
                zipEntry.setComment(str2);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.closeEntry();
                return true;
            }
            for (File file2 : listFiles) {
                if (!zipFile(file2, sb2, zipOutputStream, str2)) {
                    return false;
                }
            }
            return true;
        }
        BufferedInputStream bufferedInputStream = null;
        try {
            BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
            try {
                ZipEntry zipEntry2 = new ZipEntry(sb2);
                zipEntry2.setComment(str2);
                zipOutputStream.putNextEntry(zipEntry2);
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = bufferedInputStream2.read(bArr, 0, 8192);
                    if (read != -1) {
                        zipOutputStream.write(bArr, 0, read);
                    } else {
                        zipOutputStream.closeEntry();
                        bufferedInputStream2.close();
                        return true;
                    }
                }
            } catch (Throwable th) {
                th = th;
                bufferedInputStream = bufferedInputStream2;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static List<File> unzipFile(String str, String str2) throws IOException {
        return unzipFileByKeyword(str, str2, (String) null);
    }

    public static List<File> unzipFile(File file, File file2) throws IOException {
        return unzipFileByKeyword(file, file2, (String) null);
    }

    public static List<File> unzipFileByKeyword(String str, String str2, String str3) throws IOException {
        return unzipFileByKeyword(UtilsBridge.getFileByPath(str), UtilsBridge.getFileByPath(str2), str3);
    }

    public static List<File> unzipFileByKeyword(File file, File file2, String str) throws IOException {
        if (file == null || file2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        try {
            if (UtilsBridge.isSpace(str)) {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement = entries.nextElement();
                    String replace = nextElement.getName().replace("\\", "/");
                    if (replace.contains("../")) {
                        Log.e("ZipUtils", "entryName: " + replace + " is dangerous!");
                    } else if (!unzipChildFile(file2, arrayList, zipFile, nextElement, replace)) {
                        return arrayList;
                    }
                }
            } else {
                while (entries.hasMoreElements()) {
                    ZipEntry nextElement2 = entries.nextElement();
                    String replace2 = nextElement2.getName().replace("\\", "/");
                    if (replace2.contains("../")) {
                        Log.e("ZipUtils", "entryName: " + replace2 + " is dangerous!");
                    } else if (replace2.contains(str) && !unzipChildFile(file2, arrayList, zipFile, nextElement2, replace2)) {
                        return arrayList;
                    }
                }
            }
            return arrayList;
        } finally {
            zipFile.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean unzipChildFile(File file, List<File> list, ZipFile zipFile, ZipEntry zipEntry, String str) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        Throwable th;
        File file2 = new File(file, str);
        list.add(file2);
        if (zipEntry.isDirectory()) {
            return UtilsBridge.createOrExistsDir(file2);
        }
        if (!UtilsBridge.createOrExistsFile(file2)) {
            return false;
        }
        try {
            bufferedInputStream = new BufferedInputStream(zipFile.getInputStream(zipEntry));
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
        try {
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
        } catch (Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            th = th;
            if (bufferedInputStream != null) {
            }
            if (bufferedOutputStream != null) {
            }
            throw th;
        }
        try {
            byte[] bArr = new byte[8192];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read != -1) {
                    bufferedOutputStream.write(bArr, 0, read);
                } else {
                    bufferedInputStream.close();
                    bufferedOutputStream.close();
                    return true;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (bufferedInputStream != null) {
                bufferedInputStream.close();
            }
            if (bufferedOutputStream != null) {
                bufferedOutputStream.close();
            }
            throw th;
        }
    }

    public static List<String> getFilesPath(String str) throws IOException {
        return getFilesPath(UtilsBridge.getFileByPath(str));
    }

    public static List<String> getFilesPath(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            String replace = entries.nextElement().getName().replace("\\", "/");
            if (replace.contains("../")) {
                Log.e("ZipUtils", "entryName: " + replace + " is dangerous!");
                arrayList.add(replace);
            } else {
                arrayList.add(replace);
            }
        }
        zipFile.close();
        return arrayList;
    }

    public static List<String> getComments(String str) throws IOException {
        return getComments(UtilsBridge.getFileByPath(str));
    }

    public static List<String> getComments(File file) throws IOException {
        if (file == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ZipFile zipFile = new ZipFile(file);
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        while (entries.hasMoreElements()) {
            arrayList.add(entries.nextElement().getComment());
        }
        zipFile.close();
        return arrayList;
    }
}
