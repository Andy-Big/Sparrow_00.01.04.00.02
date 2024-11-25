package com.scwang.smartrefresh.header.flyrefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.scwang.smartrefresh.header.R;
/* loaded from: classes2.dex */
public class MountainSceneView extends View {
    protected static final int HEIGHT = 180;
    protected static final int TREE_HEIGHT = 200;
    protected static final int TREE_WIDTH = 100;
    protected static final int WIDTH = 240;
    protected int COLOR_BACKGROUND;
    protected int COLOR_MOUNTAIN_1;
    protected int COLOR_MOUNTAIN_2;
    protected int COLOR_MOUNTAIN_3;
    protected int COLOR_TREE_1_BRANCH;
    protected int COLOR_TREE_1_BRINK;
    protected int COLOR_TREE_2_BRANCH;
    protected int COLOR_TREE_2_BRINK;
    protected int COLOR_TREE_3_BRANCH;
    protected int COLOR_TREE_3_BRINK;
    protected Paint mBoarderPaint;
    protected float mBounceMax;
    protected Path mBranch;
    protected Paint mBranchPaint;
    protected Path mMount1;
    protected Path mMount2;
    protected Path mMount3;
    protected Paint mMountPaint;
    protected float mMoveFactor;
    protected float mScaleX;
    protected float mScaleY;
    protected Matrix mTransMatrix;
    protected float mTreeBendFactor;
    protected Path mTrunk;
    protected Paint mTrunkPaint;
    protected int mViewportHeight;

    public MountainSceneView(Context context) {
        this(context, null);
    }

    public MountainSceneView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.COLOR_BACKGROUND = -8466743;
        this.COLOR_MOUNTAIN_1 = -7939369;
        this.COLOR_MOUNTAIN_2 = -12807524;
        this.COLOR_MOUNTAIN_3 = -12689549;
        this.COLOR_TREE_1_BRANCH = -14716553;
        this.COLOR_TREE_1_BRINK = -15974840;
        this.COLOR_TREE_2_BRANCH = -13334385;
        this.COLOR_TREE_2_BRINK = -14982807;
        this.COLOR_TREE_3_BRANCH = -11030098;
        this.COLOR_TREE_3_BRINK = -10312531;
        this.mMountPaint = new Paint();
        this.mTrunkPaint = new Paint();
        this.mBranchPaint = new Paint();
        this.mBoarderPaint = new Paint();
        this.mMount1 = new Path();
        this.mMount2 = new Path();
        this.mMount3 = new Path();
        this.mTrunk = new Path();
        this.mBranch = new Path();
        this.mTransMatrix = new Matrix();
        this.mScaleX = 5.0f;
        this.mScaleY = 5.0f;
        this.mMoveFactor = 0.0f;
        this.mBounceMax = 1.0f;
        this.mTreeBendFactor = Float.MAX_VALUE;
        this.mViewportHeight = 0;
        this.mMountPaint.setAntiAlias(true);
        this.mMountPaint.setStyle(Paint.Style.FILL);
        this.mTrunkPaint.setAntiAlias(true);
        this.mBranchPaint.setAntiAlias(true);
        this.mBoarderPaint.setAntiAlias(true);
        this.mBoarderPaint.setStyle(Paint.Style.STROKE);
        this.mBoarderPaint.setStrokeWidth(2.0f);
        this.mBoarderPaint.setStrokeJoin(Paint.Join.ROUND);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MountainSceneView);
        if (obtainStyledAttributes.hasValue(R.styleable.MountainSceneView_msvPrimaryColor)) {
            setPrimaryColor(obtainStyledAttributes.getColor(R.styleable.MountainSceneView_msvPrimaryColor, ViewCompat.MEASURED_STATE_MASK));
        }
        this.mViewportHeight = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MountainSceneView_msvViewportHeight, 0);
        obtainStyledAttributes.recycle();
        updateMountainPath(this.mMoveFactor, 180);
        updateTreePath(this.mMoveFactor, true);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.mScaleX = (measuredWidth * 1.0f) / 240.0f;
        int i3 = this.mViewportHeight;
        if (i3 <= 0) {
            i3 = measuredHeight;
        }
        this.mScaleY = (i3 * 1.0f) / 180.0f;
        updateMountainPath(this.mMoveFactor, measuredHeight);
        updateTreePath(this.mMoveFactor, true);
    }

    private void updateMountainPath(float f, int i) {
        this.mTransMatrix.reset();
        this.mTransMatrix.setScale(this.mScaleX, this.mScaleY);
        float f2 = 10.0f * f;
        this.mMount1.reset();
        this.mMount1.moveTo(0.0f, 95.0f + f2);
        this.mMount1.lineTo(55.0f, 74.0f + f2);
        this.mMount1.lineTo(146.0f, f2 + 104.0f);
        this.mMount1.lineTo(227.0f, 72.0f + f2);
        this.mMount1.lineTo(240.0f, f2 + 80.0f);
        this.mMount1.lineTo(240.0f, 180.0f);
        this.mMount1.lineTo(0.0f, 180.0f);
        this.mMount1.close();
        this.mMount1.transform(this.mTransMatrix);
        float f3 = 20.0f * f;
        this.mMount2.reset();
        this.mMount2.moveTo(0.0f, 103.0f + f3);
        this.mMount2.lineTo(67.0f, 90.0f + f3);
        this.mMount2.lineTo(165.0f, 115.0f + f3);
        this.mMount2.lineTo(221.0f, 87.0f + f3);
        this.mMount2.lineTo(240.0f, f3 + 100.0f);
        this.mMount2.lineTo(240.0f, 180.0f);
        this.mMount2.lineTo(0.0f, 180.0f);
        this.mMount2.close();
        this.mMount2.transform(this.mTransMatrix);
        float f4 = f * 30.0f;
        this.mMount3.reset();
        this.mMount3.moveTo(0.0f, 114.0f + f4);
        this.mMount3.cubicTo(30.0f, f4 + 106.0f, 196.0f, f4 + 97.0f, 240.0f, f4 + 104.0f);
        float f5 = i;
        this.mMount3.lineTo(240.0f, f5 / this.mScaleY);
        this.mMount3.lineTo(0.0f, f5 / this.mScaleY);
        this.mMount3.close();
        this.mMount3.transform(this.mTransMatrix);
    }

    private void updateTreePath(float f, boolean z) {
        int i;
        if (f != this.mTreeBendFactor || z) {
            Interpolator create = PathInterpolatorCompat.create(0.8f, (-0.5f) * f);
            float f2 = f * 30.000002f;
            float[] fArr = new float[26];
            float[] fArr2 = new float[26];
            int i2 = 0;
            float f3 = 0.0f;
            float f4 = 200.0f;
            while (true) {
                if (i2 > 25) {
                    break;
                }
                fArr[i2] = (create.getInterpolation(f3) * f2) + 50.0f;
                fArr2[i2] = f4;
                f4 -= 8.0f;
                f3 += 0.04f;
                i2++;
            }
            this.mTrunk.reset();
            this.mTrunk.moveTo(45.0f, 200.0f);
            int i3 = (int) (17 * 0.5f);
            float f5 = 17 - i3;
            for (int i4 = 0; i4 < 17; i4++) {
                if (i4 < i3) {
                    this.mTrunk.lineTo(fArr[i4] - 5.0f, fArr2[i4]);
                } else {
                    this.mTrunk.lineTo(fArr[i4] - (((17 - i4) * 5.0f) / f5), fArr2[i4]);
                }
            }
            for (int i5 = 16; i5 >= 0; i5--) {
                if (i5 < i3) {
                    this.mTrunk.lineTo(fArr[i5] + 5.0f, fArr2[i5]);
                } else {
                    this.mTrunk.lineTo(fArr[i5] + (((17 - i5) * 5.0f) / f5), fArr2[i5]);
                }
            }
            this.mTrunk.close();
            this.mBranch.reset();
            float f6 = 15;
            this.mBranch.moveTo(fArr[10] - 20.0f, fArr2[10]);
            this.mBranch.addArc(new RectF(fArr[10] - 20.0f, fArr2[10] - 20.0f, fArr[10] + 20.0f, fArr2[10] + 20.0f), 0.0f, 180.0f);
            for (int i6 = 10; i6 <= 25; i6++) {
                float f7 = (i6 - 10) / f6;
                this.mBranch.lineTo((fArr[i6] - 20.0f) + (f7 * f7 * 20.0f), fArr2[i6]);
            }
            for (i = 25; i >= 10; i--) {
                float f8 = (i - 10) / f6;
                this.mBranch.lineTo((fArr[i] + 20.0f) - ((f8 * f8) * 20.0f), fArr2[i]);
            }
        }
    }

    private void drawTree(Canvas canvas, float f, float f2, float f3, int i, int i2) {
        canvas.save();
        canvas.translate(f2 - ((100.0f * f) / 2.0f), f3 - (200.0f * f));
        canvas.scale(f, f);
        this.mBranchPaint.setColor(i2);
        canvas.drawPath(this.mBranch, this.mBranchPaint);
        this.mTrunkPaint.setColor(i);
        canvas.drawPath(this.mTrunk, this.mTrunkPaint);
        this.mBoarderPaint.setColor(i);
        canvas.drawPath(this.mBranch, this.mBoarderPaint);
        canvas.restore();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(this.COLOR_BACKGROUND);
        this.mMountPaint.setColor(this.COLOR_MOUNTAIN_1);
        canvas.drawPath(this.mMount1, this.mMountPaint);
        canvas.save();
        canvas.scale(-1.0f, 1.0f, getWidth() / 2, 0.0f);
        float f = this.mScaleX;
        drawTree(canvas, f * 0.12f, f * 180.0f, ((this.mMoveFactor * 20.0f) + 93.0f) * this.mScaleY, this.COLOR_TREE_3_BRINK, this.COLOR_TREE_3_BRANCH);
        float f2 = this.mScaleX;
        drawTree(canvas, f2 * 0.1f, f2 * 200.0f, ((this.mMoveFactor * 20.0f) + 96.0f) * this.mScaleY, this.COLOR_TREE_3_BRINK, this.COLOR_TREE_3_BRANCH);
        canvas.restore();
        this.mMountPaint.setColor(this.COLOR_MOUNTAIN_2);
        canvas.drawPath(this.mMount2, this.mMountPaint);
        float f3 = this.mScaleX;
        drawTree(canvas, f3 * 0.2f, f3 * 160.0f, ((this.mMoveFactor * 30.0f) + 105.0f) * this.mScaleY, this.COLOR_TREE_1_BRINK, this.COLOR_TREE_1_BRANCH);
        float f4 = this.mScaleX;
        drawTree(canvas, f4 * 0.14f, f4 * 180.0f, ((this.mMoveFactor * 30.0f) + 105.0f) * this.mScaleY, this.COLOR_TREE_2_BRINK, this.COLOR_TREE_2_BRANCH);
        float f5 = this.mScaleX;
        drawTree(canvas, f5 * 0.16f, f5 * 140.0f, ((this.mMoveFactor * 30.0f) + 105.0f) * this.mScaleY, this.COLOR_TREE_2_BRINK, this.COLOR_TREE_2_BRANCH);
        this.mMountPaint.setColor(this.COLOR_MOUNTAIN_3);
        canvas.drawPath(this.mMount3, this.mMountPaint);
    }

    public void setPrimaryColor(int i) {
        this.COLOR_BACKGROUND = i;
        this.COLOR_MOUNTAIN_1 = ColorUtils.compositeColors(-1711276033, i);
        this.COLOR_MOUNTAIN_2 = ColorUtils.compositeColors(-1724083556, i);
        this.COLOR_MOUNTAIN_3 = ColorUtils.compositeColors(-868327565, i);
        this.COLOR_TREE_1_BRANCH = ColorUtils.compositeColors(1428124023, i);
        this.COLOR_TREE_1_BRINK = ColorUtils.compositeColors(-871612856, i);
        this.COLOR_TREE_2_BRANCH = ColorUtils.compositeColors(1429506191, i);
        this.COLOR_TREE_2_BRINK = ColorUtils.compositeColors(-870620823, i);
        this.COLOR_TREE_3_BRANCH = ColorUtils.compositeColors(1431810478, i);
        this.COLOR_TREE_3_BRINK = ColorUtils.compositeColors(-865950547, i);
    }

    public void updatePercent(float f) {
        this.mBounceMax = f;
        float max = Math.max(0.0f, f);
        this.mMoveFactor = Math.max(0.0f, this.mBounceMax);
        int measuredHeight = getMeasuredHeight();
        float f2 = this.mMoveFactor;
        if (measuredHeight <= 0) {
            measuredHeight = 180;
        }
        updateMountainPath(f2, measuredHeight);
        updateTreePath(max, false);
    }
}
