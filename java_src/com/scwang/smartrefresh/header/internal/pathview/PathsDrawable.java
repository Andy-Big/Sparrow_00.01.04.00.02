package com.scwang.smartrefresh.header.internal.pathview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import com.scwang.smartrefresh.layout.internal.PaintDrawable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class PathsDrawable extends PaintDrawable {
    private boolean mCacheDirty;
    private Bitmap mCachedBitmap;
    protected List<Integer> mColors;
    protected int mOriginHeight;
    protected int mOriginWidth;
    protected List<Path> mPaths;
    protected List<Path> mltOriginPath;
    protected List<String> mltOriginSvg;
    protected static final Region REGION = new Region();
    protected static final Region MAX_CLIP = new Region(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected int mWidth = 1;
    protected int mHeight = 1;
    protected int mStartX = 0;
    protected int mStartY = 0;

    protected boolean onMeasure() {
        Integer num;
        Integer num2;
        Integer num3;
        List<Path> list = this.mPaths;
        Integer num4 = null;
        if (list != null) {
            Integer num5 = null;
            num2 = null;
            num3 = null;
            for (Path path : list) {
                REGION.setPath(path, MAX_CLIP);
                Rect bounds = REGION.getBounds();
                num4 = Integer.valueOf(Math.min(num4 == null ? bounds.top : num4.intValue(), bounds.top));
                num5 = Integer.valueOf(Math.min(num5 == null ? bounds.left : num5.intValue(), bounds.left));
                num2 = Integer.valueOf(Math.max(num2 == null ? bounds.right : num2.intValue(), bounds.right));
                num3 = Integer.valueOf(Math.max(num3 == null ? bounds.bottom : num3.intValue(), bounds.bottom));
            }
            num = num4;
            num4 = num5;
        } else {
            num = null;
            num2 = null;
            num3 = null;
        }
        this.mStartX = num4 == null ? 0 : num4.intValue();
        this.mStartY = num == null ? 0 : num.intValue();
        this.mWidth = num2 == null ? 0 : num2.intValue() - this.mStartX;
        this.mHeight = num3 == null ? 0 : num3.intValue() - this.mStartY;
        if (this.mOriginWidth == 0) {
            this.mOriginWidth = this.mWidth;
        }
        if (this.mOriginHeight == 0) {
            this.mOriginHeight = this.mHeight;
        }
        Rect bounds2 = getBounds();
        if (this.mWidth == 0 || this.mHeight == 0) {
            if (this.mOriginWidth == 0) {
                this.mOriginWidth = 1;
            }
            if (this.mOriginHeight == 0) {
                this.mOriginHeight = 1;
            }
            this.mHeight = 1;
            this.mWidth = 1;
            return false;
        }
        super.setBounds(bounds2.left, bounds2.top, bounds2.left + this.mWidth, bounds2.top + this.mHeight);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        List<Path> list = this.mltOriginPath;
        if (list != null && list.size() > 0 && (i5 != this.mWidth || i6 != this.mHeight)) {
            int i7 = this.mStartX;
            int i8 = this.mStartY;
            float f = i5;
            float f2 = i6;
            this.mPaths = PathParser.transformScale((f * 1.0f) / this.mOriginWidth, (f2 * 1.0f) / this.mOriginHeight, this.mltOriginPath, this.mltOriginSvg);
            if (onMeasure()) {
                return;
            }
            this.mWidth = i5;
            this.mHeight = i6;
            this.mStartX = (int) (((i7 * 1.0f) * f) / this.mOriginWidth);
            this.mStartY = (int) (((i8 * 1.0f) * f2) / this.mOriginHeight);
            super.setBounds(i, i2, i3, i4);
            return;
        }
        super.setBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        setBounds(rect.left, rect.top, rect.right, rect.bottom);
    }

    public boolean parserPaths(String... strArr) {
        this.mOriginHeight = 0;
        this.mOriginWidth = 0;
        this.mltOriginSvg = new ArrayList();
        ArrayList arrayList = new ArrayList();
        this.mltOriginPath = arrayList;
        this.mPaths = arrayList;
        for (String str : strArr) {
            this.mltOriginSvg.add(str);
            this.mltOriginPath.add(PathParser.createPathFromPathData(str));
        }
        return onMeasure();
    }

    public void declareOriginal(int i, int i2, int i3, int i4) {
        this.mStartX = i;
        this.mStartY = i2;
        this.mWidth = i3;
        this.mOriginWidth = i3;
        this.mHeight = i4;
        this.mOriginHeight = i4;
        Rect bounds = getBounds();
        super.setBounds(bounds.left, bounds.top, bounds.left + i3, bounds.top + i4);
    }

    public void parserColors(int... iArr) {
        this.mColors = new ArrayList();
        for (int i : iArr) {
            this.mColors.add(Integer.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int width = bounds.width();
        int height = bounds.height();
        if (this.mPaint.getAlpha() == 255) {
            canvas.save();
            canvas.translate(bounds.left - this.mStartX, bounds.top - this.mStartY);
            if (this.mPaths != null) {
                for (int i = 0; i < this.mPaths.size(); i++) {
                    List<Integer> list = this.mColors;
                    if (list != null && i < list.size()) {
                        this.mPaint.setColor(this.mColors.get(i).intValue());
                    }
                    canvas.drawPath(this.mPaths.get(i), this.mPaint);
                }
                this.mPaint.setAlpha(255);
            }
            canvas.restore();
            return;
        }
        createCachedBitmapIfNeeded(width, height);
        if (this.mCacheDirty) {
            this.mCachedBitmap.eraseColor(0);
            drawCachedBitmap(new Canvas(this.mCachedBitmap));
            this.mCacheDirty = false;
        }
        canvas.drawBitmap(this.mCachedBitmap, bounds.left, bounds.top, this.mPaint);
    }

    public void setGeometricWidth(int i) {
        Rect bounds = getBounds();
        float width = (i * 1.0f) / bounds.width();
        setBounds((int) (bounds.left * width), (int) (bounds.top * width), (int) (bounds.right * width), (int) (bounds.bottom * width));
    }

    public void setGeometricHeight(int i) {
        Rect bounds = getBounds();
        float height = (i * 1.0f) / bounds.height();
        setBounds((int) (bounds.left * height), (int) (bounds.top * height), (int) (bounds.right * height), (int) (bounds.bottom * height));
    }

    private void drawCachedBitmap(Canvas canvas) {
        canvas.translate(-this.mStartX, -this.mStartY);
        if (this.mPaths != null) {
            for (int i = 0; i < this.mPaths.size(); i++) {
                List<Integer> list = this.mColors;
                if (list != null && i < list.size()) {
                    this.mPaint.setColor(this.mColors.get(i).intValue());
                }
                canvas.drawPath(this.mPaths.get(i), this.mPaint);
            }
        }
    }

    private void createCachedBitmapIfNeeded(int i, int i2) {
        Bitmap bitmap = this.mCachedBitmap;
        if (bitmap != null && i == bitmap.getWidth() && i2 == this.mCachedBitmap.getHeight()) {
            return;
        }
        this.mCachedBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.mCacheDirty = true;
    }
}
