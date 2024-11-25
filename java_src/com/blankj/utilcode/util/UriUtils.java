package com.blankj.utilcode.util;

import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.content.FileProvider;
import androidx.exifinterface.media.ExifInterface;
import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
/* loaded from: classes.dex */
public final class UriUtils {
    private UriUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static Uri res2Uri(String str) {
        return Uri.parse("android.resource://" + Utils.getApp().getPackageName() + "/" + str);
    }

    public static Uri file2Uri(File file) {
        if (UtilsBridge.isFileExists(file)) {
            if (Build.VERSION.SDK_INT >= 24) {
                return FileProvider.getUriForFile(Utils.getApp(), Utils.getApp().getPackageName() + ".utilcode.provider", file);
            }
            return Uri.fromFile(file);
        }
        return null;
    }

    public static File uri2File(Uri uri) {
        if (uri == null) {
            return null;
        }
        File uri2FileReal = uri2FileReal(uri);
        return uri2FileReal != null ? uri2FileReal : copyUri2Cache(uri);
    }

    private static File uri2FileReal(Uri uri) {
        Uri uri2;
        File fileFromUri;
        String[] split;
        boolean z;
        String str;
        File file;
        Log.d("UriUtils", uri.toString());
        String authority = uri.getAuthority();
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if (Build.VERSION.SDK_INT >= 24 && path != null) {
            String[] strArr = {"/external/", "/external_path/"};
            for (int i = 0; i < 2; i++) {
                String str2 = strArr[i];
                if (path.startsWith(str2)) {
                    File file2 = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + path.replace(str2, "/"));
                    if (file2.exists()) {
                        Log.d("UriUtils", uri.toString() + " -> " + str2);
                        return file2;
                    }
                }
            }
            if (path.startsWith("/files_path/")) {
                file = new File(Utils.getApp().getFilesDir().getAbsolutePath() + path.replace("/files_path/", "/"));
            } else if (path.startsWith("/cache_path/")) {
                file = new File(Utils.getApp().getCacheDir().getAbsolutePath() + path.replace("/cache_path/", "/"));
            } else if (path.startsWith("/external_files_path/")) {
                file = new File(Utils.getApp().getExternalFilesDir(null).getAbsolutePath() + path.replace("/external_files_path/", "/"));
            } else if (path.startsWith("/external_cache_path/")) {
                file = new File(Utils.getApp().getExternalCacheDir().getAbsolutePath() + path.replace("/external_cache_path/", "/"));
            } else {
                file = null;
            }
            if (file != null && file.exists()) {
                Log.d("UriUtils", uri.toString() + " -> " + path);
                return file;
            }
        }
        if ("file".equals(scheme)) {
            if (path != null) {
                return new File(path);
            }
            Log.d("UriUtils", uri.toString() + " parse failed. -> 0");
            return null;
        } else if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(Utils.getApp(), uri)) {
            if ("com.android.externalstorage.documents".equals(authority)) {
                String str3 = DocumentsContract.getDocumentId(uri).split(":")[0];
                if ("primary".equalsIgnoreCase(str3)) {
                    return new File(Environment.getExternalStorageDirectory() + "/" + split[1]);
                }
                StorageManager storageManager = (StorageManager) Utils.getApp().getSystemService("storage");
                try {
                    Class<?> cls = Class.forName("android.os.storage.StorageVolume");
                    Method method = storageManager.getClass().getMethod("getVolumeList", new Class[0]);
                    Method method2 = cls.getMethod("getUuid", new Class[0]);
                    Method method3 = cls.getMethod("getState", new Class[0]);
                    Method method4 = cls.getMethod("getPath", new Class[0]);
                    Method method5 = cls.getMethod("isPrimary", new Class[0]);
                    Method method6 = cls.getMethod("isEmulated", new Class[0]);
                    Object invoke = method.invoke(storageManager, new Object[0]);
                    int length = Array.getLength(invoke);
                    int i2 = 0;
                    while (i2 < length) {
                        Object obj = Array.get(invoke, i2);
                        Object obj2 = invoke;
                        if (!"mounted".equals(method3.invoke(obj, new Object[0])) && !"mounted_ro".equals(method3.invoke(obj, new Object[0]))) {
                            z = false;
                            if (z && ((!((Boolean) method5.invoke(obj, new Object[0])).booleanValue() || !((Boolean) method6.invoke(obj, new Object[0])).booleanValue()) && (str = (String) method2.invoke(obj, new Object[0])) != null && str.equals(str3))) {
                                return new File(method4.invoke(obj, new Object[0]) + "/" + split[1]);
                            }
                            i2++;
                            invoke = obj2;
                        }
                        z = true;
                        if (z) {
                            return new File(method4.invoke(obj, new Object[0]) + "/" + split[1]);
                        }
                        i2++;
                        invoke = obj2;
                    }
                } catch (Exception e) {
                    Log.d("UriUtils", uri.toString() + " parse failed. " + e.toString() + " -> 1_0");
                }
                Log.d("UriUtils", uri.toString() + " parse failed. -> 1_0");
                return null;
            } else if ("com.android.providers.downloads.documents".equals(authority)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                if (TextUtils.isEmpty(documentId)) {
                    Log.d("UriUtils", uri.toString() + " parse failed(id is null). -> 1_1");
                    return null;
                } else if (documentId.startsWith("raw:")) {
                    return new File(documentId.substring(4));
                } else {
                    if (documentId.startsWith("msf:")) {
                        documentId = documentId.split(":")[1];
                    }
                    try {
                        long parseLong = Long.parseLong(documentId);
                        String[] strArr2 = {"content://downloads/public_downloads", "content://downloads/all_downloads", "content://downloads/my_downloads"};
                        for (int i3 = 0; i3 < 3; i3++) {
                            try {
                                fileFromUri = getFileFromUri(ContentUris.withAppendedId(Uri.parse(strArr2[i3]), parseLong), "1_1");
                            } catch (Exception unused) {
                            }
                            if (fileFromUri != null) {
                                return fileFromUri;
                            }
                        }
                        Log.d("UriUtils", uri.toString() + " parse failed. -> 1_1");
                        return null;
                    } catch (Exception unused2) {
                        return null;
                    }
                }
            } else if ("com.android.providers.media.documents".equals(authority)) {
                String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                String str4 = split2[0];
                if ("image".equals(str4)) {
                    uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                } else if ("video".equals(str4)) {
                    uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                } else if (!"audio".equals(str4)) {
                    Log.d("UriUtils", uri.toString() + " parse failed. -> 1_2");
                    return null;
                } else {
                    uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                return getFileFromUri(uri2, "_id=?", new String[]{split2[1]}, "1_2");
            } else if ("content".equals(scheme)) {
                return getFileFromUri(uri, "1_3");
            } else {
                Log.d("UriUtils", uri.toString() + " parse failed. -> 1_4");
                return null;
            }
        } else if ("content".equals(scheme)) {
            return getFileFromUri(uri, ExifInterface.GPS_MEASUREMENT_2D);
        } else {
            Log.d("UriUtils", uri.toString() + " parse failed. -> 3");
            return null;
        }
    }

    private static File getFileFromUri(Uri uri, String str) {
        return getFileFromUri(uri, null, null, str);
    }

    private static File getFileFromUri(Uri uri, String str, String[] strArr, String str2) {
        if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
            if (!TextUtils.isEmpty(uri.getLastPathSegment())) {
                return new File(uri.getLastPathSegment());
            }
        } else if ("com.tencent.mtt.fileprovider".equals(uri.getAuthority())) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                return new File(Environment.getExternalStorageDirectory(), path.substring(10, path.length()));
            }
        } else if ("com.huawei.hidisk.fileprovider".equals(uri.getAuthority())) {
            String path2 = uri.getPath();
            if (!TextUtils.isEmpty(path2)) {
                return new File(path2.replace("/root", ""));
            }
        }
        Cursor query = Utils.getApp().getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
        try {
            if (query == null) {
                Log.d("UriUtils", uri.toString() + " parse failed(cursor is null). -> " + str2);
                return null;
            } else if (!query.moveToFirst()) {
                Log.d("UriUtils", uri.toString() + " parse failed(moveToFirst return false). -> " + str2);
                return null;
            } else {
                int columnIndex = query.getColumnIndex("_data");
                if (columnIndex > -1) {
                    return new File(query.getString(columnIndex));
                }
                Log.d("UriUtils", uri.toString() + " parse failed(columnIndex: " + columnIndex + " is wrong). -> " + str2);
                return null;
            }
        } catch (Exception unused) {
            Log.d("UriUtils", uri.toString() + " parse failed. -> " + str2);
            return null;
        } finally {
            query.close();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0062 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static java.io.File copyUri2Cache(android.net.Uri r7) {
        /*
            java.lang.String r0 = "UriUtils"
            java.lang.String r1 = "copyUri2Cache() called"
            android.util.Log.d(r0, r1)
            r0 = 0
            android.app.Application r1 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> L4a java.io.FileNotFoundException -> L4f
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L4a java.io.FileNotFoundException -> L4f
            java.io.InputStream r7 = r1.openInputStream(r7)     // Catch: java.lang.Throwable -> L4a java.io.FileNotFoundException -> L4f
            java.io.File r1 = new java.io.File     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            android.app.Application r2 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            java.io.File r2 = r2.getCacheDir()     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            r3.<init>()     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            java.lang.String r4 = ""
            r3.append(r4)     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            long r4 = java.lang.System.currentTimeMillis()     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            r3.append(r4)     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            java.lang.String r3 = r3.toString()     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            r1.<init>(r2, r3)     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            java.lang.String r2 = r1.getAbsolutePath()     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            com.blankj.utilcode.util.UtilsBridge.writeFileFromIS(r2, r7)     // Catch: java.io.FileNotFoundException -> L48 java.lang.Throwable -> L5f
            if (r7 == 0) goto L47
            r7.close()     // Catch: java.io.IOException -> L43
            goto L47
        L43:
            r7 = move-exception
            r7.printStackTrace()
        L47:
            return r1
        L48:
            r1 = move-exception
            goto L51
        L4a:
            r7 = move-exception
            r6 = r0
            r0 = r7
            r7 = r6
            goto L60
        L4f:
            r1 = move-exception
            r7 = r0
        L51:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L5f
            if (r7 == 0) goto L5e
            r7.close()     // Catch: java.io.IOException -> L5a
            goto L5e
        L5a:
            r7 = move-exception
            r7.printStackTrace()
        L5e:
            return r0
        L5f:
            r0 = move-exception
        L60:
            if (r7 == 0) goto L6a
            r7.close()     // Catch: java.io.IOException -> L66
            goto L6a
        L66:
            r7 = move-exception
            r7.printStackTrace()
        L6a:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.UriUtils.copyUri2Cache(android.net.Uri):java.io.File");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] uri2Bytes(android.net.Uri r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            android.app.Application r1 = com.blankj.utilcode.util.Utils.getApp()     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            java.io.InputStream r4 = r1.openInputStream(r4)     // Catch: java.lang.Throwable -> L21 java.io.FileNotFoundException -> L26
            byte[] r0 = com.blankj.utilcode.util.UtilsBridge.inputStream2Bytes(r4)     // Catch: java.io.FileNotFoundException -> L1f java.lang.Throwable -> L3d
            if (r4 == 0) goto L1e
            r4.close()     // Catch: java.io.IOException -> L1a
            goto L1e
        L1a:
            r4 = move-exception
            r4.printStackTrace()
        L1e:
            return r0
        L1f:
            r1 = move-exception
            goto L28
        L21:
            r4 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L3e
        L26:
            r1 = move-exception
            r4 = r0
        L28:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L3d
            java.lang.String r1 = "UriUtils"
            java.lang.String r2 = "uri to bytes failed."
            android.util.Log.d(r1, r2)     // Catch: java.lang.Throwable -> L3d
            if (r4 == 0) goto L3c
            r4.close()     // Catch: java.io.IOException -> L38
            goto L3c
        L38:
            r4 = move-exception
            r4.printStackTrace()
        L3c:
            return r0
        L3d:
            r0 = move-exception
        L3e:
            if (r4 == 0) goto L48
            r4.close()     // Catch: java.io.IOException -> L44
            goto L48
        L44:
            r4 = move-exception
            r4.printStackTrace()
        L48:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.UriUtils.uri2Bytes(android.net.Uri):byte[]");
    }
}
