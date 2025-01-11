package com.github.barteksc.pdfviewer;

import android.graphics.RectF;
import com.github.barteksc.pdfviewer.util.Constants;
import com.github.barteksc.pdfviewer.util.MathUtils;
import com.github.barteksc.pdfviewer.util.Util;
import com.shockwave.pdfium.util.SizeF;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes.dex */
class PagesLoader {
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

    /* loaded from: classes.dex */
    private class Holder {
        int col;
        int row;

        private Holder() {
        }

        public String toString() {
            return "Holder{row=" + this.row + ", col=" + this.col + '}';
        }
    }

    /* loaded from: classes.dex */
    private class RenderRange {
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

    /* loaded from: classes.dex */
    private class GridSize {
        int cols;
        int rows;

        private GridSize() {
        }

        public String toString() {
            return "GridSize{rows=" + this.rows + ", cols=" + this.cols + '}';
        }
    }

    PagesLoader(PDFView pDFView) {
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
    */
    private List<RenderRange> getRenderRangeList(float f, float f2, float f3, float f4) {
        float pageOffset;
        float width;
        float f5;
        float height;
        float f6;
        float f7;
        float f8;
        int i;
        boolean z;
        float width2;
        float f9;
        float f10 = -MathUtils.max(f, 0.0f);
        float f11 = -MathUtils.max(f2, 0.0f);
        float f12 = -MathUtils.max(f3, 0.0f);
        float f13 = -MathUtils.max(f4, 0.0f);
        float f14 = this.pdfView.isSwipeVertical() ? f11 : f10;
        float f15 = this.pdfView.isSwipeVertical() ? f13 : f12;
        int pageAtOffset = this.pdfView.pdfFile.getPageAtOffset(f14, this.pdfView.getZoom());
        int pageAtOffset2 = this.pdfView.pdfFile.getPageAtOffset(f15, this.pdfView.getZoom());
        int i2 = 1;
        int i3 = (pageAtOffset2 - pageAtOffset) + 1;
        LinkedList linkedList = new LinkedList();
        int i4 = pageAtOffset;
        while (i4 <= pageAtOffset2) {
            RenderRange renderRange = new RenderRange();
            renderRange.page = i4;
            if (i4 != pageAtOffset) {
                if (i4 == pageAtOffset2) {
                    pageOffset = this.pdfView.pdfFile.getPageOffset(i4, this.pdfView.getZoom());
                    if (this.pdfView.isSwipeVertical()) {
                        f6 = pageOffset;
                        pageOffset = f10;
                    } else {
                        f6 = f11;
                    }
                    height = f13;
                    f5 = f6;
                } else {
                    pageOffset = this.pdfView.pdfFile.getPageOffset(i4, this.pdfView.getZoom());
                    SizeF scaledPageSize = this.pdfView.pdfFile.getScaledPageSize(i4, this.pdfView.getZoom());
                    if (this.pdfView.isSwipeVertical()) {
                        f5 = pageOffset;
                        height = scaledPageSize.getHeight() + pageOffset;
                        pageOffset = f10;
                    } else {
                        width = scaledPageSize.getWidth() + pageOffset;
                        f5 = f11;
                        height = f13;
                        getPageColsRows(renderRange.gridSize, renderRange.page);
                        float f16 = f10;
                        SizeF scaledPageSize2 = this.pdfView.pdfFile.getScaledPageSize(renderRange.page, this.pdfView.getZoom());
                        float height2 = scaledPageSize2.getHeight() / renderRange.gridSize.rows;
                        float width3 = scaledPageSize2.getWidth() / renderRange.gridSize.cols;
                        float f17 = f11;
                        float secondaryPageOffset = this.pdfView.pdfFile.getSecondaryPageOffset(i4, this.pdfView.getZoom());
                        if (!this.pdfView.isSwipeVertical()) {
                        }
                        linkedList.add(renderRange);
                        i4++;
                        f11 = f17;
                        f13 = f8;
                        f10 = f16;
                        pageAtOffset = i;
                        i2 = 1;
                        f12 = f7;
                    }
                }
                width = f12;
                getPageColsRows(renderRange.gridSize, renderRange.page);
                float f162 = f10;
                SizeF scaledPageSize22 = this.pdfView.pdfFile.getScaledPageSize(renderRange.page, this.pdfView.getZoom());
                float height22 = scaledPageSize22.getHeight() / renderRange.gridSize.rows;
                float width32 = scaledPageSize22.getWidth() / renderRange.gridSize.cols;
                float f172 = f11;
                float secondaryPageOffset2 = this.pdfView.pdfFile.getSecondaryPageOffset(i4, this.pdfView.getZoom());
                if (!this.pdfView.isSwipeVertical()) {
                }
                linkedList.add(renderRange);
                i4++;
                f11 = f172;
                f13 = f8;
                f10 = f162;
                pageAtOffset = i;
                i2 = 1;
                f12 = f7;
            } else if (i3 != i2) {
                float pageOffset2 = this.pdfView.pdfFile.getPageOffset(i4, this.pdfView.getZoom());
                SizeF scaledPageSize3 = this.pdfView.pdfFile.getScaledPageSize(i4, this.pdfView.getZoom());
                if (this.pdfView.isSwipeVertical()) {
                    f9 = pageOffset2 + scaledPageSize3.getHeight();
                    width2 = f12;
                } else {
                    width2 = pageOffset2 + scaledPageSize3.getWidth();
                    f9 = f13;
                }
                f5 = f11;
                height = f9;
                width = width2;
                pageOffset = f10;
                getPageColsRows(renderRange.gridSize, renderRange.page);
                float f1622 = f10;
                SizeF scaledPageSize222 = this.pdfView.pdfFile.getScaledPageSize(renderRange.page, this.pdfView.getZoom());
                float height222 = scaledPageSize222.getHeight() / renderRange.gridSize.rows;
                float width322 = scaledPageSize222.getWidth() / renderRange.gridSize.cols;
                float f1722 = f11;
                float secondaryPageOffset22 = this.pdfView.pdfFile.getSecondaryPageOffset(i4, this.pdfView.getZoom());
                if (!this.pdfView.isSwipeVertical()) {
                }
                linkedList.add(renderRange);
                i4++;
                f11 = f1722;
                f13 = f8;
                f10 = f1622;
                pageAtOffset = i;
                i2 = 1;
                f12 = f7;
            } else {
                pageOffset = f10;
                f5 = f11;
                width = f12;
                height = f13;
                getPageColsRows(renderRange.gridSize, renderRange.page);
                float f16222 = f10;
                SizeF scaledPageSize2222 = this.pdfView.pdfFile.getScaledPageSize(renderRange.page, this.pdfView.getZoom());
                float height2222 = scaledPageSize2222.getHeight() / renderRange.gridSize.rows;
                float width3222 = scaledPageSize2222.getWidth() / renderRange.gridSize.cols;
                float f17222 = f11;
                float secondaryPageOffset222 = this.pdfView.pdfFile.getSecondaryPageOffset(i4, this.pdfView.getZoom());
                if (!this.pdfView.isSwipeVertical()) {
                    f7 = f12;
                    f8 = f13;
                    i = pageAtOffset;
                    renderRange.leftTop.row = MathUtils.floor(Math.abs(f5 - this.pdfView.pdfFile.getPageOffset(renderRange.page, this.pdfView.getZoom())) / height2222);
                    renderRange.leftTop.col = MathUtils.floor(MathUtils.min(pageOffset - secondaryPageOffset222, 0.0f) / width3222);
                    renderRange.rightBottom.row = MathUtils.ceil(Math.abs(height - this.pdfView.pdfFile.getPageOffset(renderRange.page, this.pdfView.getZoom())) / height2222);
                    renderRange.rightBottom.col = MathUtils.floor(MathUtils.min(width - secondaryPageOffset222, 0.0f) / width3222);
                    z = false;
                } else {
                    f7 = f12;
                    f8 = f13;
                    i = pageAtOffset;
                    renderRange.leftTop.col = MathUtils.floor(Math.abs(pageOffset - this.pdfView.pdfFile.getPageOffset(renderRange.page, this.pdfView.getZoom())) / width3222);
                    renderRange.leftTop.row = MathUtils.floor(MathUtils.min(f5 - secondaryPageOffset222, 0.0f) / height2222);
                    renderRange.rightBottom.col = MathUtils.floor(Math.abs(width - this.pdfView.pdfFile.getPageOffset(renderRange.page, this.pdfView.getZoom())) / width3222);
                    z = false;
                    renderRange.rightBottom.row = MathUtils.floor(MathUtils.min(height - secondaryPageOffset222, 0.0f) / height2222);
                }
                linkedList.add(renderRange);
                i4++;
                f11 = f17222;
                f13 = f8;
                f10 = f16222;
                pageAtOffset = i;
                i2 = 1;
                f12 = f7;
            }
        }
        return linkedList;
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

    void loadPages() {
        this.cacheOrder = 1;
        this.xOffset = -MathUtils.max(this.pdfView.getCurrentXOffset(), 0.0f);
        this.yOffset = -MathUtils.max(this.pdfView.getCurrentYOffset(), 0.0f);
        loadVisible();
    }
}
