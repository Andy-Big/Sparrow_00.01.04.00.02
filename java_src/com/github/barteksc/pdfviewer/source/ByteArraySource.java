package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;
/* loaded from: classes.dex */
public class ByteArraySource implements DocumentSource {
    private byte[] data;

    public ByteArraySource(byte[] bArr) {
        this.data = bArr;
    }

    @Override // com.github.barteksc.pdfviewer.source.DocumentSource
    public PdfDocument createDocument(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(this.data, str);
    }
}
