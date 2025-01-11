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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [304=4] */
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
    */
    private static File copyUri2Cache(Uri uri) {
        Throwable th;
        InputStream inputStream;
        Log.d("UriUtils", "copyUri2Cache() called");
        try {
            inputStream = Utils.getApp().getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e = e;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
        try {
            try {
                File file = new File(Utils.getApp().getCacheDir(), "" + System.currentTimeMillis());
                UtilsBridge.writeFileFromIS(file.getAbsolutePath(), inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return file;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            e.printStackTrace();
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0040 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] uri2Bytes(Uri uri) {
        Throwable th;
        InputStream inputStream;
        if (uri == null) {
            return null;
        }
        try {
            inputStream = Utils.getApp().getContentResolver().openInputStream(uri);
        } catch (FileNotFoundException e) {
            e = e;
            inputStream = null;
        } catch (Throwable th2) {
            th = th2;
            inputStream = null;
            if (inputStream != null) {
            }
            throw th;
        }
        try {
            try {
                byte[] inputStream2Bytes = UtilsBridge.inputStream2Bytes(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                return inputStream2Bytes;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                        e3.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            e.printStackTrace();
            Log.d("UriUtils", "uri to bytes failed.");
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return null;
        }
    }
}
