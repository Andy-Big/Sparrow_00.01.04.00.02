package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseBooleanArray;
import com.github.barteksc.pdfviewer.exception.PageRenderingException;
import com.github.barteksc.pdfviewer.util.FitPolicy;
import com.github.barteksc.pdfviewer.util.PageSizeCalculator;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.PdfiumCore;
import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
class PdfFile {
    private static final Object lock = new Object();
    private boolean autoSpacing;
    private final boolean fitEachPage;
    private boolean isVertical;
    private int[] originalUserPages;
    private final FitPolicy pageFitPolicy;
    private PdfDocument pdfDocument;
    private PdfiumCore pdfiumCore;
    private int spacingPx;
    private int pagesCount = 0;
    private List<Size> originalPageSizes = new ArrayList();
    private List<SizeF> pageSizes = new ArrayList();
    private SparseBooleanArray openedPages = new SparseBooleanArray();
    private Size originalMaxWidthPageSize = new Size(0, 0);
    private Size originalMaxHeightPageSize = new Size(0, 0);
    private SizeF maxHeightPageSize = new SizeF(0.0f, 0.0f);
    private SizeF maxWidthPageSize = new SizeF(0.0f, 0.0f);
    private List<Float> pageOffsets = new ArrayList();
    private List<Float> pageSpacing = new ArrayList();
    private float documentLength = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public PdfFile(PdfiumCore pdfiumCore, PdfDocument pdfDocument, FitPolicy fitPolicy, Size size, int[] iArr, boolean z, int i, boolean z2, boolean z3) {
        this.pdfiumCore = pdfiumCore;
        this.pdfDocument = pdfDocument;
        this.pageFitPolicy = fitPolicy;
        this.originalUserPages = iArr;
        this.isVertical = z;
        this.spacingPx = i;
        this.autoSpacing = z2;
        this.fitEachPage = z3;
        setup(size);
    }

    private void setup(Size size) {
        int[] iArr = this.originalUserPages;
        if (iArr != null) {
            this.pagesCount = iArr.length;
        } else {
            this.pagesCount = this.pdfiumCore.getPageCount(this.pdfDocument);
        }
        for (int i = 0; i < this.pagesCount; i++) {
            Size pageSize = this.pdfiumCore.getPageSize(this.pdfDocument, documentPage(i));
            if (pageSize.getWidth() > this.originalMaxWidthPageSize.getWidth()) {
                this.originalMaxWidthPageSize = pageSize;
            }
            if (pageSize.getHeight() > this.originalMaxHeightPageSize.getHeight()) {
                this.originalMaxHeightPageSize = pageSize;
            }
            this.originalPageSizes.add(pageSize);
        }
        recalculatePageSizes(size);
    }

    public void recalculatePageSizes(Size size) {
        this.pageSizes.clear();
        PageSizeCalculator pageSizeCalculator = new PageSizeCalculator(this.pageFitPolicy, this.originalMaxWidthPageSize, this.originalMaxHeightPageSize, size, this.fitEachPage);
        this.maxWidthPageSize = pageSizeCalculator.getOptimalMaxWidthPageSize();
        this.maxHeightPageSize = pageSizeCalculator.getOptimalMaxHeightPageSize();
        for (Size size2 : this.originalPageSizes) {
            this.pageSizes.add(pageSizeCalculator.calculate(size2));
        }
        if (this.autoSpacing) {
            prepareAutoSpacing(size);
        }
        prepareDocLen();
        preparePagesOffset();
    }

    public int getPagesCount() {
        return this.pagesCount;
    }

    public SizeF getPageSize(int i) {
        if (documentPage(i) < 0) {
            return new SizeF(0.0f, 0.0f);
        }
        return this.pageSizes.get(i);
    }

    public SizeF getScaledPageSize(int i, float f) {
        SizeF pageSize = getPageSize(i);
        return new SizeF(pageSize.getWidth() * f, pageSize.getHeight() * f);
    }

    public SizeF getMaxPageSize() {
        return this.isVertical ? this.maxWidthPageSize : this.maxHeightPageSize;
    }

    public float getMaxPageWidth() {
        return getMaxPageSize().getWidth();
    }

    public float getMaxPageHeight() {
        return getMaxPageSize().getHeight();
    }

    private void prepareAutoSpacing(Size size) {
        float width;
        float width2;
        this.pageSpacing.clear();
        for (int i = 0; i < getPagesCount(); i++) {
            SizeF sizeF = this.pageSizes.get(i);
            if (this.isVertical) {
                width = size.getHeight();
                width2 = sizeF.getHeight();
            } else {
                width = size.getWidth();
                width2 = sizeF.getWidth();
            }
            float max = Math.max(0.0f, width - width2);
            if (i < getPagesCount() - 1) {
                max += this.spacingPx;
            }
            this.pageSpacing.add(Float.valueOf(max));
        }
    }

    private void prepareDocLen() {
        float f;
        float f2 = 0.0f;
        for (int i = 0; i < getPagesCount(); i++) {
            SizeF sizeF = this.pageSizes.get(i);
            f2 += this.isVertical ? sizeF.getHeight() : sizeF.getWidth();
            if (this.autoSpacing) {
                f = this.pageSpacing.get(i).floatValue();
            } else if (i < getPagesCount() - 1) {
                f = this.spacingPx;
            }
            f2 += f;
        }
        this.documentLength = f2;
    }

    private void preparePagesOffset() {
        float f;
        this.pageOffsets.clear();
        float f2 = 0.0f;
        for (int i = 0; i < getPagesCount(); i++) {
            SizeF sizeF = this.pageSizes.get(i);
            float height = this.isVertical ? sizeF.getHeight() : sizeF.getWidth();
            if (this.autoSpacing) {
                f2 += this.pageSpacing.get(i).floatValue() / 2.0f;
                if (i == 0) {
                    f2 -= this.spacingPx / 2.0f;
                } else if (i == getPagesCount() - 1) {
                    f2 += this.spacingPx / 2.0f;
                }
                this.pageOffsets.add(Float.valueOf(f2));
                f = this.pageSpacing.get(i).floatValue() / 2.0f;
            } else {
                this.pageOffsets.add(Float.valueOf(f2));
                f = this.spacingPx;
            }
            f2 += height + f;
        }
    }

    public float getDocLen(float f) {
        return this.documentLength * f;
    }

    public float getPageLength(int i, float f) {
        SizeF pageSize = getPageSize(i);
        return (this.isVertical ? pageSize.getHeight() : pageSize.getWidth()) * f;
    }

    public float getPageSpacing(int i, float f) {
        return (this.autoSpacing ? this.pageSpacing.get(i).floatValue() : this.spacingPx) * f;
    }

    public float getPageOffset(int i, float f) {
        if (documentPage(i) < 0) {
            return 0.0f;
        }
        return this.pageOffsets.get(i).floatValue() * f;
    }

    public float getSecondaryPageOffset(int i, float f) {
        float maxPageHeight;
        float height;
        SizeF pageSize = getPageSize(i);
        if (this.isVertical) {
            maxPageHeight = getMaxPageWidth();
            height = pageSize.getWidth();
        } else {
            maxPageHeight = getMaxPageHeight();
            height = pageSize.getHeight();
        }
        return (f * (maxPageHeight - height)) / 2.0f;
    }

    public int getPageAtOffset(float f, float f2) {
        int i = 0;
        for (int i2 = 0; i2 < getPagesCount() && (this.pageOffsets.get(i2).floatValue() * f2) - (getPageSpacing(i2, f2) / 2.0f) < f; i2++) {
            i++;
        }
        int i3 = i - 1;
        if (i3 >= 0) {
            return i3;
        }
        return 0;
    }

    public boolean openPage(int i) throws PageRenderingException {
        int documentPage = documentPage(i);
        if (documentPage < 0) {
            return false;
        }
        synchronized (lock) {
            if (this.openedPages.indexOfKey(documentPage) < 0) {
                try {
                    this.pdfiumCore.openPage(this.pdfDocument, documentPage);
                    this.openedPages.put(documentPage, true);
                    return true;
                } catch (Exception e) {
                    this.openedPages.put(documentPage, false);
                    throw new PageRenderingException(i, e);
                }
            }
            return false;
        }
    }

    public boolean pageHasError(int i) {
        return !this.openedPages.get(documentPage(i), false);
    }

    public void renderPageBitmap(Bitmap bitmap, int i, Rect rect, boolean z) {
        this.pdfiumCore.renderPageBitmap(this.pdfDocument, bitmap, documentPage(i), rect.left, rect.top, rect.width(), rect.height(), z);
    }

    public PdfDocument.Meta getMetaData() {
        PdfDocument pdfDocument = this.pdfDocument;
        if (pdfDocument == null) {
            return null;
        }
        return this.pdfiumCore.getDocumentMeta(pdfDocument);
    }

    public List<PdfDocument.Bookmark> getBookmarks() {
        PdfDocument pdfDocument = this.pdfDocument;
        if (pdfDocument == null) {
            return new ArrayList();
        }
        return this.pdfiumCore.getTableOfContents(pdfDocument);
    }

    public List<PdfDocument.Link> getPageLinks(int i) {
        return this.pdfiumCore.getPageLinks(this.pdfDocument, documentPage(i));
    }

    public RectF mapRectToDevice(int i, int i2, int i3, int i4, int i5, RectF rectF) {
        return this.pdfiumCore.mapRectToDevice(this.pdfDocument, documentPage(i), i2, i3, i4, i5, 0, rectF);
    }

    public void dispose() {
        PdfDocument pdfDocument;
        PdfiumCore pdfiumCore = this.pdfiumCore;
        if (pdfiumCore != null && (pdfDocument = this.pdfDocument) != null) {
            pdfiumCore.closeDocument(pdfDocument);
        }
        this.pdfDocument = null;
        this.originalUserPages = null;
    }

    public int determineValidPageNumberFrom(int i) {
        int pagesCount;
        if (i <= 0) {
            return 0;
        }
        int[] iArr = this.originalUserPages;
        if (iArr != null) {
            if (i >= iArr.length) {
                pagesCount = iArr.length;
                return pagesCount - 1;
            }
            return i;
        }
        if (i >= getPagesCount()) {
            pagesCount = getPagesCount();
            return pagesCount - 1;
        }
        return i;
    }

    public int documentPage(int i) {
        int i2;
        int[] iArr = this.originalUserPages;
        if (iArr == null) {
            i2 = i;
        } else if (i < 0 || i >= iArr.length) {
            return -1;
        } else {
            i2 = iArr[i];
        }
        if (i2 < 0 || i >= getPagesCount()) {
            return -1;
        }
        return i2;
    }
}
