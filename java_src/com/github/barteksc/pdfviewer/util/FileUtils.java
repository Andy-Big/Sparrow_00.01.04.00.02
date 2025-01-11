package com.github.barteksc.pdfviewer.util;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class FileUtils {
    private FileUtils() {
    }

    public static File fileFromAsset(Context context, String str) throws IOException {
        File cacheDir = context.getCacheDir();
        File file = new File(cacheDir, str + "-pdfview.pdf");
        if (str.contains("/")) {
            file.getParentFile().mkdirs();
        }
        copy(context.getAssets().open(str), file);
        return file;
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [57=4] */
    public static void copy(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(file);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } finally {
                    fileOutputStream.close();
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (inputStream != null) {
                try {
                    inputStream.close();
                } finally {
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                }
            }
            throw th;
        }
    }
}
