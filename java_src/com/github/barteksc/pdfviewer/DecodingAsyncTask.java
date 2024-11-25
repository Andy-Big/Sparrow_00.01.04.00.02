package com.github.barteksc.pdfviewer;

import android.os.AsyncTask;
import com.github.barteksc.pdfviewer.source.DocumentSource;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
class DecodingAsyncTask extends AsyncTask<Void, Void, Throwable> {
    private boolean cancelled = false;
    private DocumentSource docSource;
    private String password;
    private PdfFile pdfFile;
    private WeakReference<PDFView> pdfViewReference;
    private PdfiumCore pdfiumCore;
    private int[] userPages;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DecodingAsyncTask(DocumentSource documentSource, String str, int[] iArr, PDFView pDFView, PdfiumCore pdfiumCore) {
        this.docSource = documentSource;
        this.userPages = iArr;
        this.pdfViewReference = new WeakReference<>(pDFView);
        this.password = str;
        this.pdfiumCore = pdfiumCore;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public Throwable doInBackground(Void... voidArr) {
        try {
            PDFView pDFView = this.pdfViewReference.get();
            if (pDFView != null) {
                this.pdfFile = new PdfFile(this.pdfiumCore, this.docSource.createDocument(pDFView.getContext(), this.pdfiumCore, this.password), pDFView.getPageFitPolicy(), getViewSize(pDFView), this.userPages, pDFView.isSwipeVertical(), pDFView.getSpacingPx(), pDFView.isAutoSpacingEnabled(), pDFView.isFitEachPage());
                return null;
            }
            return new NullPointerException("pdfView == null");
        } catch (Throwable th) {
            return th;
        }
    }

    private Size getViewSize(PDFView pDFView) {
        return new Size(pDFView.getWidth(), pDFView.getHeight());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    public void onPostExecute(Throwable th) {
        PDFView pDFView = this.pdfViewReference.get();
        if (pDFView != null) {
            if (th != null) {
                pDFView.loadError(th);
            } else if (this.cancelled) {
            } else {
                pDFView.loadComplete(this.pdfFile);
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onCancelled() {
        this.cancelled = true;
    }
}
