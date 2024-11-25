package com.github.barteksc.pdfviewer.source;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import java.io.File;
import java.io.IOException;
/* loaded from: classes.dex */
public class FileSource implements DocumentSource {
    private File file;

    public FileSource(File file) {
        this.file = file;
    }

    @Override // com.github.barteksc.pdfviewer.source.DocumentSource
    public PdfDocument createDocument(Context context, PdfiumCore pdfiumCore, String str) throws IOException {
        return pdfiumCore.newDocument(ParcelFileDescriptor.open(this.file, 268435456), str);
    }
}
