package com.github.barteksc.pdfviewer.util;

import com.shockwave.pdfium.util.Size;
import com.shockwave.pdfium.util.SizeF;
/* loaded from: classes.dex */
public class PageSizeCalculator {
    private boolean fitEachPage;
    private FitPolicy fitPolicy;
    private float heightRatio;
    private SizeF optimalMaxHeightPageSize;
    private SizeF optimalMaxWidthPageSize;
    private final Size originalMaxHeightPageSize;
    private final Size originalMaxWidthPageSize;
    private final Size viewSize;
    private float widthRatio;

    public PageSizeCalculator(FitPolicy fitPolicy, Size size, Size size2, Size size3, boolean z) {
        this.fitPolicy = fitPolicy;
        this.originalMaxWidthPageSize = size;
        this.originalMaxHeightPageSize = size2;
        this.viewSize = size3;
        this.fitEachPage = z;
        calculateMaxPages();
    }

    public SizeF calculate(Size size) {
        if (size.getWidth() <= 0 || size.getHeight() <= 0) {
            return new SizeF(0.0f, 0.0f);
        }
        float width = this.fitEachPage ? this.viewSize.getWidth() : size.getWidth() * this.widthRatio;
        float height = this.fitEachPage ? this.viewSize.getHeight() : size.getHeight() * this.heightRatio;
        int i = AnonymousClass1.$SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[this.fitPolicy.ordinal()];
        if (i != 1) {
            if (i == 2) {
                return fitBoth(size, width, height);
            }
            return fitWidth(size, width);
        }
        return fitHeight(size, height);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.github.barteksc.pdfviewer.util.PageSizeCalculator$1  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy;

        static {
            int[] iArr = new int[FitPolicy.values().length];
            $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy = iArr;
            try {
                iArr[FitPolicy.HEIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[FitPolicy.BOTH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public SizeF getOptimalMaxWidthPageSize() {
        return this.optimalMaxWidthPageSize;
    }

    public SizeF getOptimalMaxHeightPageSize() {
        return this.optimalMaxHeightPageSize;
    }

    private void calculateMaxPages() {
        int i = AnonymousClass1.$SwitchMap$com$github$barteksc$pdfviewer$util$FitPolicy[this.fitPolicy.ordinal()];
        if (i == 1) {
            SizeF fitHeight = fitHeight(this.originalMaxHeightPageSize, this.viewSize.getHeight());
            this.optimalMaxHeightPageSize = fitHeight;
            this.heightRatio = fitHeight.getHeight() / this.originalMaxHeightPageSize.getHeight();
            Size size = this.originalMaxWidthPageSize;
            this.optimalMaxWidthPageSize = fitHeight(size, size.getHeight() * this.heightRatio);
        } else if (i == 2) {
            float width = fitBoth(this.originalMaxWidthPageSize, this.viewSize.getWidth(), this.viewSize.getHeight()).getWidth() / this.originalMaxWidthPageSize.getWidth();
            Size size2 = this.originalMaxHeightPageSize;
            SizeF fitBoth = fitBoth(size2, size2.getWidth() * width, this.viewSize.getHeight());
            this.optimalMaxHeightPageSize = fitBoth;
            this.heightRatio = fitBoth.getHeight() / this.originalMaxHeightPageSize.getHeight();
            SizeF fitBoth2 = fitBoth(this.originalMaxWidthPageSize, this.viewSize.getWidth(), this.originalMaxWidthPageSize.getHeight() * this.heightRatio);
            this.optimalMaxWidthPageSize = fitBoth2;
            this.widthRatio = fitBoth2.getWidth() / this.originalMaxWidthPageSize.getWidth();
        } else {
            SizeF fitWidth = fitWidth(this.originalMaxWidthPageSize, this.viewSize.getWidth());
            this.optimalMaxWidthPageSize = fitWidth;
            this.widthRatio = fitWidth.getWidth() / this.originalMaxWidthPageSize.getWidth();
            Size size3 = this.originalMaxHeightPageSize;
            this.optimalMaxHeightPageSize = fitWidth(size3, size3.getWidth() * this.widthRatio);
        }
    }

    private SizeF fitWidth(Size size, float f) {
        return new SizeF(f, (float) Math.floor(f / (size.getWidth() / size.getHeight())));
    }

    private SizeF fitHeight(Size size, float f) {
        return new SizeF((float) Math.floor(f / (size.getHeight() / size.getWidth())), f);
    }

    private SizeF fitBoth(Size size, float f, float f2) {
        float width = size.getWidth() / size.getHeight();
        float floor = (float) Math.floor(f / width);
        if (floor > f2) {
            f = (float) Math.floor(width * f2);
        } else {
            f2 = floor;
        }
        return new SizeF(f, f2);
    }
}
