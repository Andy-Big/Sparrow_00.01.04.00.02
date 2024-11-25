package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import android.net.Uri;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;
/* loaded from: classes.dex */
public class UriSource implements DocumentSource {
    private Uri uri;

    public UriSource(Uri uri) {
        this.uri = uri;
    }

    @Override // com.github.barteksc.pdfviewer.source.DocumentSource
    public PdfDocument createDocument(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(context.getContentResolver().openFileDescriptor(this.uri, "r"), str);
    }
}
