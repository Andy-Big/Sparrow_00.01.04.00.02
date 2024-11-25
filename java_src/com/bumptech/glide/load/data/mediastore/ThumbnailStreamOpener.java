package com.bumptech.glide.load.data.mediastore;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.ImageHeaderParserUtils;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes.dex */
class ThumbnailStreamOpener {
    private static final FileService DEFAULT_SERVICE = new FileService();
    private static final String TAG = "ThumbStreamOpener";
    private final ArrayPool byteArrayPool;
    private final ContentResolver contentResolver;
    private final List<ImageHeaderParser> parsers;
    private final ThumbnailQuery query;
    private final FileService service;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThumbnailStreamOpener(List<ImageHeaderParser> list, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this(list, DEFAULT_SERVICE, thumbnailQuery, arrayPool, contentResolver);
    }

    ThumbnailStreamOpener(List<ImageHeaderParser> list, FileService fileService, ThumbnailQuery thumbnailQuery, ArrayPool arrayPool, ContentResolver contentResolver) {
        this.service = fileService;
        this.query = thumbnailQuery;
        this.byteArrayPool = arrayPool;
        this.contentResolver = contentResolver;
        this.parsers = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getOrientation(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.contentResolver.openInputStream(uri);
                int orientation = ImageHeaderParserUtils.getOrientation(this.parsers, inputStream, this.byteArrayPool);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return orientation;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e) {
            if (Log.isLoggable(TAG, 3)) {
                Log.d(TAG, "Failed to open uri: " + uri, e);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            }
            return -1;
        }
    }

    public InputStream open(Uri uri) throws FileNotFoundException {
        String path = getPath(uri);
        if (TextUtils.isEmpty(path)) {
            return null;
        }
        File file = this.service.get(path);
        if (isValid(file)) {
            Uri fromFile = Uri.fromFile(file);
            try {
                return this.contentResolver.openInputStream(fromFile);
            } catch (NullPointerException e) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
            }
        }
        return null;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x004a: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:28:0x004a */
    /* JADX WARN: Removed duplicated region for block: B:30:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getPath(android.net.Uri r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            com.bumptech.glide.load.data.mediastore.ThumbnailQuery r2 = r6.query     // Catch: java.lang.Throwable -> L24 java.lang.SecurityException -> L26
            android.database.Cursor r2 = r2.query(r7)     // Catch: java.lang.Throwable -> L24 java.lang.SecurityException -> L26
            if (r2 == 0) goto L1e
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.SecurityException -> L1c java.lang.Throwable -> L49
            if (r3 == 0) goto L1e
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch: java.lang.SecurityException -> L1c java.lang.Throwable -> L49
            if (r2 == 0) goto L1b
            r2.close()
        L1b:
            return r7
        L1c:
            r3 = move-exception
            goto L28
        L1e:
            if (r2 == 0) goto L23
            r2.close()
        L23:
            return r1
        L24:
            r7 = move-exception
            goto L4b
        L26:
            r3 = move-exception
            r2 = r1
        L28:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L49
            if (r4 == 0) goto L43
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L49
            r4.<init>()     // Catch: java.lang.Throwable -> L49
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L49
            r4.append(r7)     // Catch: java.lang.Throwable -> L49
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L49
            android.util.Log.d(r0, r7, r3)     // Catch: java.lang.Throwable -> L49
        L43:
            if (r2 == 0) goto L48
            r2.close()
        L48:
            return r1
        L49:
            r7 = move-exception
            r1 = r2
        L4b:
            if (r1 == 0) goto L50
            r1.close()
        L50:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener.getPath(android.net.Uri):java.lang.String");
    }

    private boolean isValid(File file) {
        return this.service.exists(file) && 0 < this.service.length(file);
    }
}
