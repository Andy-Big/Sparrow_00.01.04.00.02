package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.IOException;
/* loaded from: classes.dex */
public interface DocumentSource {
    PdfDocument createDocument(Context context, PdfiumCore pdfiumCore, String str) throws IOException;
}
