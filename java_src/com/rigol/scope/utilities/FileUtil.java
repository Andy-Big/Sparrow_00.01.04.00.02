package com.rigol.scope.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
/* loaded from: classes2.dex */
public class FileUtil {
    public static long listFiles(File file, List<String> list) {
        String absolutePath = file.getAbsolutePath();
        if (file.isFile()) {
            absolutePath = file.getParent();
        }
        return listFiles(absolutePath, file, list);
    }

    private static long listFiles(String str, File file, List<String> list) {
        long j = 0;
        if (file.exists()) {
            if (file.isFile()) {
                list.add(str + "|" + file.getAbsolutePath().substring(str.length() + 1));
                return file.length();
            }
            for (File file2 : file.listFiles()) {
                j += listFiles(str, file2, list);
            }
            return j;
        }
        return 0L;
    }

    public static void copyOrMove(File file, File file2, boolean z) throws IOException {
        File parentFile = file2.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        byte[] bArr = new byte[1048576];
        while (true) {
            int read = fileInputStream.read(bArr);
            if (read == -1) {
                break;
            }
            fileOutputStream.write(bArr, 0, read);
            fileOutputStream.getFD().sync();
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        fileInputStream.close();
        if (z) {
            file.delete();
        }
    }
}
