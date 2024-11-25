package com.shockwave.pdfium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import android.view.Surface;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PdfiumCore {
    private static final String FD_FIELD_NAME = "descriptor";
    private static final Object lock;
    private static Field mFdField;
    private int mCurrentDpi;
    private static final String TAG = PdfiumCore.class.getName();
    private static final Class FD_CLASS = FileDescriptor.class;

    private native void nativeCloseDocument(long j);

    private native void nativeClosePage(long j);

    private native void nativeClosePages(long[] jArr);

    private native long nativeGetBookmarkDestIndex(long j, long j2);

    private native String nativeGetBookmarkTitle(long j);

    private native Integer nativeGetDestPageIndex(long j, long j2);

    private native String nativeGetDocumentMetaText(long j, String str);

    private native Long nativeGetFirstChildBookmark(long j, Long l);

    private native RectF nativeGetLinkRect(long j);

    private native String nativeGetLinkURI(long j, long j2);

    private native int nativeGetPageCount(long j);

    private native int nativeGetPageHeightPixel(long j, int i);

    private native int nativeGetPageHeightPoint(long j);

    private native long[] nativeGetPageLinks(long j);

    private native Size nativeGetPageSizeByIndex(long j, int i, int i2);

    private native int nativeGetPageWidthPixel(long j, int i);

    private native int nativeGetPageWidthPoint(long j);

    private native Long nativeGetSiblingBookmark(long j, long j2);

    private native long nativeLoadPage(long j, int i);

    private native long[] nativeLoadPages(long j, int i, int i2);

    private native long nativeOpenDocument(int i, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j, int i, int i2, int i3, int i4, int i5, double d, double d2);

    private native void nativeRenderPage(long j, Surface surface, int i, int i2, int i3, int i4, int i5, boolean z);

    private native void nativeRenderPageBitmap(long j, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z);

    static {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e) {
            Log.e(TAG, "Native libraries failed to load - " + e);
        }
        lock = new Object();
        mFdField = null;
    }

    public static int getNumFd(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (mFdField == null) {
                Field declaredField = FD_CLASS.getDeclaredField(FD_FIELD_NAME);
                mFdField = declaredField;
                declaredField.setAccessible(true);
            }
            return mFdField.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return -1;
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public PdfiumCore(Context context) {
        this.mCurrentDpi = context.getResources().getDisplayMetrics().densityDpi;
        Log.d(TAG, "Starting PdfiumAndroid 1.9.0");
    }

    public PdfDocument newDocument(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        return newDocument(parcelFileDescriptor, (String) null);
    }

    public PdfDocument newDocument(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.parcelFileDescriptor = parcelFileDescriptor;
        synchronized (lock) {
            pdfDocument.mNativeDocPtr = nativeOpenDocument(getNumFd(parcelFileDescriptor), str);
        }
        return pdfDocument;
    }

    public PdfDocument newDocument(byte[] bArr) throws IOException {
        return newDocument(bArr, (String) null);
    }

    public PdfDocument newDocument(byte[] bArr, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        synchronized (lock) {
            pdfDocument.mNativeDocPtr = nativeOpenMemDocument(bArr, str);
        }
        return pdfDocument;
    }

    public int getPageCount(PdfDocument pdfDocument) {
        int nativeGetPageCount;
        synchronized (lock) {
            nativeGetPageCount = nativeGetPageCount(pdfDocument.mNativeDocPtr);
        }
        return nativeGetPageCount;
    }

    public long openPage(PdfDocument pdfDocument, int i) {
        long nativeLoadPage;
        synchronized (lock) {
            nativeLoadPage = nativeLoadPage(pdfDocument.mNativeDocPtr, i);
            pdfDocument.mNativePagesPtr.put(Integer.valueOf(i), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    public long[] openPage(PdfDocument pdfDocument, int i, int i2) {
        long[] nativeLoadPages;
        synchronized (lock) {
            nativeLoadPages = nativeLoadPages(pdfDocument.mNativeDocPtr, i, i2);
            for (long j : nativeLoadPages) {
                if (i > i2) {
                    break;
                }
                pdfDocument.mNativePagesPtr.put(Integer.valueOf(i), Long.valueOf(j));
                i++;
            }
        }
        return nativeLoadPages;
    }

    public int getPageWidth(PdfDocument pdfDocument, int i) {
        synchronized (lock) {
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i));
            if (l != null) {
                return nativeGetPageWidthPixel(l.longValue(), this.mCurrentDpi);
            }
            return 0;
        }
    }

    public int getPageHeight(PdfDocument pdfDocument, int i) {
        synchronized (lock) {
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i));
            if (l != null) {
                return nativeGetPageHeightPixel(l.longValue(), this.mCurrentDpi);
            }
            return 0;
        }
    }

    public int getPageWidthPoint(PdfDocument pdfDocument, int i) {
        synchronized (lock) {
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i));
            if (l != null) {
                return nativeGetPageWidthPoint(l.longValue());
            }
            return 0;
        }
    }

    public int getPageHeightPoint(PdfDocument pdfDocument, int i) {
        synchronized (lock) {
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i));
            if (l != null) {
                return nativeGetPageHeightPoint(l.longValue());
            }
            return 0;
        }
    }

    public Size getPageSize(PdfDocument pdfDocument, int i) {
        Size nativeGetPageSizeByIndex;
        synchronized (lock) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(pdfDocument.mNativeDocPtr, i, this.mCurrentDpi);
        }
        return nativeGetPageSizeByIndex;
    }

    public void renderPage(PdfDocument pdfDocument, Surface surface, int i, int i2, int i3, int i4, int i5) {
        renderPage(pdfDocument, surface, i, i2, i3, i4, i5, false);
    }

    public void renderPage(PdfDocument pdfDocument, Surface surface, int i, int i2, int i3, int i4, int i5, boolean z) {
        synchronized (lock) {
            try {
                try {
                    try {
                        nativeRenderPage(pdfDocument.mNativePagesPtr.get(Integer.valueOf(i)).longValue(), surface, this.mCurrentDpi, i2, i3, i4, i5, z);
                    } catch (NullPointerException e) {
                        e = e;
                        Log.e(TAG, "mContext may be null");
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e = e2;
                        Log.e(TAG, "Exception throw from native");
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (NullPointerException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5) {
        renderPageBitmap(pdfDocument, bitmap, i, i2, i3, i4, i5, false);
    }

    public void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int i, int i2, int i3, int i4, int i5, boolean z) {
        synchronized (lock) {
            try {
                try {
                    try {
                        nativeRenderPageBitmap(pdfDocument.mNativePagesPtr.get(Integer.valueOf(i)).longValue(), bitmap, this.mCurrentDpi, i2, i3, i4, i5, z);
                    } catch (NullPointerException e) {
                        e = e;
                        Log.e(TAG, "mContext may be null");
                        e.printStackTrace();
                    } catch (Exception e2) {
                        e = e2;
                        Log.e(TAG, "Exception throw from native");
                        e.printStackTrace();
                    }
                } catch (Throwable th) {
                    th = th;
                    throw th;
                }
            } catch (NullPointerException e3) {
                e = e3;
            } catch (Exception e4) {
                e = e4;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    public void closeDocument(PdfDocument pdfDocument) {
        synchronized (lock) {
            for (Integer num : pdfDocument.mNativePagesPtr.keySet()) {
                nativeClosePage(pdfDocument.mNativePagesPtr.get(num).longValue());
            }
            pdfDocument.mNativePagesPtr.clear();
            nativeCloseDocument(pdfDocument.mNativeDocPtr);
            if (pdfDocument.parcelFileDescriptor != null) {
                try {
                    pdfDocument.parcelFileDescriptor.close();
                } catch (IOException unused) {
                }
                pdfDocument.parcelFileDescriptor = null;
            }
        }
    }

    public PdfDocument.Meta getDocumentMeta(PdfDocument pdfDocument) {
        PdfDocument.Meta meta;
        synchronized (lock) {
            meta = new PdfDocument.Meta();
            meta.title = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Title");
            meta.author = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Author");
            meta.subject = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Subject");
            meta.keywords = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Keywords");
            meta.creator = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Creator");
            meta.producer = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Producer");
            meta.creationDate = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "CreationDate");
            meta.modDate = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "ModDate");
        }
        return meta;
    }

    public List<PdfDocument.Bookmark> getTableOfContents(PdfDocument pdfDocument) {
        ArrayList arrayList;
        synchronized (lock) {
            arrayList = new ArrayList();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.mNativeDocPtr, null);
            if (nativeGetFirstChildBookmark != null) {
                recursiveGetBookmark(arrayList, pdfDocument, nativeGetFirstChildBookmark.longValue());
            }
        }
        return arrayList;
    }

    private void recursiveGetBookmark(List<PdfDocument.Bookmark> list, PdfDocument pdfDocument, long j) {
        PdfDocument.Bookmark bookmark = new PdfDocument.Bookmark();
        bookmark.mNativePtr = j;
        bookmark.title = nativeGetBookmarkTitle(j);
        bookmark.pageIdx = nativeGetBookmarkDestIndex(pdfDocument.mNativeDocPtr, j);
        list.add(bookmark);
        Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.mNativeDocPtr, Long.valueOf(j));
        if (nativeGetFirstChildBookmark != null) {
            recursiveGetBookmark(bookmark.getChildren(), pdfDocument, nativeGetFirstChildBookmark.longValue());
        }
        Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(pdfDocument.mNativeDocPtr, j);
        if (nativeGetSiblingBookmark != null) {
            recursiveGetBookmark(list, pdfDocument, nativeGetSiblingBookmark.longValue());
        }
    }

    public List<PdfDocument.Link> getPageLinks(PdfDocument pdfDocument, int i) {
        long[] nativeGetPageLinks;
        synchronized (lock) {
            ArrayList arrayList = new ArrayList();
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i));
            if (l == null) {
                return arrayList;
            }
            for (long j : nativeGetPageLinks(l.longValue())) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(pdfDocument.mNativeDocPtr, j);
                String nativeGetLinkURI = nativeGetLinkURI(pdfDocument.mNativeDocPtr, j);
                RectF nativeGetLinkRect = nativeGetLinkRect(j);
                if (nativeGetLinkRect != null && (nativeGetDestPageIndex != null || nativeGetLinkURI != null)) {
                    arrayList.add(new PdfDocument.Link(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
            return arrayList;
        }
    }

    public Point mapPageCoordsToDevice(PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, double d, double d2) {
        return nativePageCoordsToDevice(pdfDocument.mNativePagesPtr.get(Integer.valueOf(i)).longValue(), i2, i3, i4, i5, i6, d, d2);
    }

    public RectF mapRectToDevice(PdfDocument pdfDocument, int i, int i2, int i3, int i4, int i5, int i6, RectF rectF) {
        Point mapPageCoordsToDevice = mapPageCoordsToDevice(pdfDocument, i, i2, i3, i4, i5, i6, rectF.left, rectF.top);
        Point mapPageCoordsToDevice2 = mapPageCoordsToDevice(pdfDocument, i, i2, i3, i4, i5, i6, rectF.right, rectF.bottom);
        return new RectF(mapPageCoordsToDevice.x, mapPageCoordsToDevice.y, mapPageCoordsToDevice2.x, mapPageCoordsToDevice2.y);
    }
}
