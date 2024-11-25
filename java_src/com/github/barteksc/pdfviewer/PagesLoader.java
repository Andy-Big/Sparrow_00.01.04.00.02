package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.github.barteksc.pdfviewer.util.Util;
import com.shockwave.pdfium.util.SizeF;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class PagesLoader {
    private int cacheOrder;
    private float pageRelativePartHeight;
    private float pageRelativePartWidth;
    private float partRenderHeight;
    private float partRenderWidth;
    private PDFView pdfView;
    private final int preloadOffset;
    private final RectF thumbnailRect = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
    private float xOffset;
    private float yOffset;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Holder {
        int col;
        int row;

        private Holder() {
        }

        public String toString() {
            return "Holder{row=" + this.row + ", col=" + this.col + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class RenderRange {
        GridSize gridSize;
        Holder leftTop;
        int page = 0;
        Holder rightBottom;

        RenderRange() {
            this.gridSize = new GridSize();
            this.leftTop = new Holder();
            this.rightBottom = new Holder();
        }

        public String toString() {
            return "RenderRange{page=" + this.page + ", gridSize=" + this.gridSize + ", leftTop=" + this.leftTop + ", rightBottom=" + this.rightBottom + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class GridSize {
        int cols;
        int rows;

        private GridSize() {
        }

        public String toString() {
            return "GridSize{rows=" + this.rows + ", cols=" + this.cols + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PagesLoader(PDFView pDFView) {
        this.pdfView = pDFView;
        this.preloadOffset = Util.getDP(pDFView.getContext(), Constants.PRELOAD_OFFSET);
    }

    private void getPageColsRows(GridSize gridSize, int i) {
        SizeF pageSize = this.pdfView.pdfFile.getPageSize(i);
        float height = (Constants.PART_SIZE * (1.0f / pageSize.getHeight())) / this.pdfView.getZoom();
        float width = (Constants.PART_SIZE * (1.0f / pageSize.getWidth())) / this.pdfView.getZoom();
        gridSize.rows = MathUtils.ceil(1.0f / height);
        gridSize.cols = MathUtils.ceil(1.0f / width);
    }

    private void calculatePartSize(GridSize gridSize) {
        this.pageRelativePartWidth = 1.0f / gridSize.cols;
        this.pageRelativePartHeight = 1.0f / gridSize.rows;
        this.partRenderWidth = Constants.PART_SIZE / this.pageRelativePartWidth;
        this.partRenderHeight = Constants.PART_SIZE / this.pageRelativePartHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x01a6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.List<com.github.barteksc.pdfviewer.PagesLoader.RenderRange> getRenderRangeList(float r20, float r21, float r22, float r23) {
        /*
            Method dump skipped, instructions count: 539
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.PagesLoader.getRenderRangeList(float, float, float, float):java.util.List");
    }

    private void loadVisible() {
        float f = this.preloadOffset;
        float f2 = this.xOffset;
        float f3 = this.yOffset;
        List<RenderRange> renderRangeList = getRenderRangeList((-f2) + f, (-f3) + f, ((-f2) - this.pdfView.getWidth()) - f, ((-f3) - this.pdfView.getHeight()) - f);
        for (RenderRange renderRange : renderRangeList) {
            loadThumbnail(renderRange.page);
        }
        int i = 0;
        for (RenderRange renderRange2 : renderRangeList) {
            calculatePartSize(renderRange2.gridSize);
            i += loadPage(renderRange2.page, renderRange2.leftTop.row, renderRange2.rightBottom.row, renderRange2.leftTop.col, renderRange2.rightBottom.col, Constants.Cache.CACHE_SIZE - i);
            if (i >= Constants.Cache.CACHE_SIZE) {
                return;
            }
        }
    }

    private int loadPage(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 0;
        while (i2 <= i3) {
            for (int i8 = i4; i8 <= i5; i8++) {
                if (loadCell(i, i2, i8, this.pageRelativePartWidth, this.pageRelativePartHeight)) {
                    i7++;
                }
                if (i7 >= i6) {
                    return i7;
                }
            }
            i2++;
        }
        return i7;
    }

    private boolean loadCell(int i, int i2, int i3, float f, float f2) {
        float f3 = i3 * f;
        float f4 = i2 * f2;
        float f5 = this.partRenderWidth;
        float f6 = this.partRenderHeight;
        float f7 = f3 + f > 1.0f ? 1.0f - f3 : f;
        float f8 = f4 + f2 > 1.0f ? 1.0f - f4 : f2;
        float f9 = f5 * f7;
        float f10 = f6 * f8;
        RectF rectF = new RectF(f3, f4, f7 + f3, f8 + f4);
        if (f9 <= 0.0f || f10 <= 0.0f) {
            return false;
        }
        if (!this.pdfView.cacheManager.upPartIfContained(i, rectF, this.cacheOrder)) {
            this.pdfView.renderingHandler.addRenderingTask(i, f9, f10, rectF, false, this.cacheOrder, this.pdfView.isBestQuality(), this.pdfView.isAnnotationRendering());
        }
        this.cacheOrder++;
        return true;
    }

    private void loadThumbnail(int i) {
        SizeF pageSize = this.pdfView.pdfFile.getPageSize(i);
        float width = pageSize.getWidth() * Constants.THUMBNAIL_RATIO;
        float height = pageSize.getHeight() * Constants.THUMBNAIL_RATIO;
        if (this.pdfView.cacheManager.containsThumbnail(i, this.thumbnailRect)) {
            return;
        }
        this.pdfView.renderingHandler.addRenderingTask(i, width, height, this.thumbnailRect, true, 0, this.pdfView.isBestQuality(), this.pdfView.isAnnotationRendering());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadPages() {
        this.cacheOrder = 1;
        this.xOffset = -MathUtils.max(this.pdfView.getCurrentXOffset(), 0.0f);
        this.yOffset = -MathUtils.max(this.pdfView.getCurrentYOffset(), 0.0f);
        loadVisible();
    }
}
