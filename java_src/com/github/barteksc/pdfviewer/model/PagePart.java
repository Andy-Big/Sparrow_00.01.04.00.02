package com.github.barteksc.pdfviewer.model;

import android.graphics.Bitmap;
import android.graphics.RectF;
/* loaded from: classes.dex */
public class PagePart {
    private int cacheOrder;
    private int page;
    private RectF pageRelativeBounds;
    private Bitmap renderedBitmap;
    private boolean thumbnail;

    public PagePart(int i, Bitmap bitmap, RectF rectF, boolean z, int i2) {
        this.page = i;
        this.renderedBitmap = bitmap;
        this.pageRelativeBounds = rectF;
        this.thumbnail = z;
        this.cacheOrder = i2;
    }

    public int getCacheOrder() {
        return this.cacheOrder;
    }

    public int getPage() {
        return this.page;
    }

    public Bitmap getRenderedBitmap() {
        return this.renderedBitmap;
    }

    public RectF getPageRelativeBounds() {
        return this.pageRelativeBounds;
    }

    public boolean isThumbnail() {
        return this.thumbnail;
    }

    public void setCacheOrder(int i) {
        this.cacheOrder = i;
    }

    public boolean equals(Object obj) {
        if (obj instanceof PagePart) {
            PagePart pagePart = (PagePart) obj;
            return pagePart.getPage() == this.page && pagePart.getPageRelativeBounds().left == this.pageRelativeBounds.left && pagePart.getPageRelativeBounds().right == this.pageRelativeBounds.right && pagePart.getPageRelativeBounds().top == this.pageRelativeBounds.top && pagePart.getPageRelativeBounds().bottom == this.pageRelativeBounds.bottom;
        }
        return false;
    }
}
