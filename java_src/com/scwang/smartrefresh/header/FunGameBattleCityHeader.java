package com.scwang.smartrefresh.header;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.SparseArray;
import com.scwang.smartrefresh.header.fungame.FunGameView;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.util.DensityUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
/* loaded from: classes2.dex */
public class FunGameBattleCityHeader extends FunGameView {
    protected static final int DEFAULT_BULLET_NUM_SPACING = 360;
    protected static final int DEFAULT_ENEMY_TANK_NUM_SPACING = 60;
    protected static final int DEFAULT_TANK_MAGIC_TOTAL_NUM = 8;
    protected static final float TANK_BARREL_RATIO = 0.33333334f;
    protected static int TANK_ROW_NUM = 3;
    protected int barrelSize;
    protected float bulletRadius;
    protected int bulletSpace;
    protected int bulletSpeed;
    protected SparseArray<Queue<RectF>> eTankSparseArray;
    protected int enemySpeed;
    protected int enemyTankSpace;
    protected int levelNum;
    protected Queue<Point> mBulletList;
    protected int offsetETankX;
    protected int offsetMBulletX;
    protected boolean once;
    protected int overstepNum;
    protected Random random;
    protected Point usedBullet;
    protected int wipeOutNum;

    public FunGameBattleCityHeader(Context context) {
        this(context, null);
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FunGameBattleCityHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.enemySpeed = 1;
        this.bulletSpeed = 4;
        this.once = true;
        this.random = new Random();
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView, com.scwang.smartrefresh.header.fungame.FunGameBase, com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onInitialized(RefreshKernel refreshKernel, int i, int i2) {
        this.controllerSize = i / TANK_ROW_NUM;
        int floor = (int) Math.floor((this.controllerSize * TANK_BARREL_RATIO) + 0.5f);
        this.barrelSize = floor;
        this.bulletRadius = (floor - (this.DIVIDING_LINE_SIZE * 2.0f)) * 0.5f;
        super.onInitialized(refreshKernel, i, i2);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void resetConfigParams() {
        this.status = 0;
        this.controllerPosition = this.DIVIDING_LINE_SIZE;
        this.enemySpeed = DensityUtil.dp2px(1.0f);
        this.bulletSpeed = DensityUtil.dp2px(4.0f);
        this.levelNum = 8;
        this.wipeOutNum = 0;
        this.once = true;
        this.enemyTankSpace = this.controllerSize + this.barrelSize + 60;
        this.bulletSpace = 360;
        this.eTankSparseArray = new SparseArray<>();
        for (int i = 0; i < TANK_ROW_NUM; i++) {
            this.eTankSparseArray.put(i, new LinkedList());
        }
        this.mBulletList = new LinkedList();
    }

    protected RectF generateEnemyTank(int i) {
        float f = -(this.controllerSize + this.barrelSize);
        float f2 = (i * this.controllerSize) + this.DIVIDING_LINE_SIZE;
        return new RectF(f, f2, (this.barrelSize * 2.5f) + f, this.controllerSize + f2);
    }

    protected int getTrackIndex(int i) {
        int i2 = this.mHeaderHeight;
        int i3 = TANK_ROW_NUM;
        int i4 = i / (i2 / i3);
        if (i4 >= i3) {
            i4 = i3 - 1;
        }
        if (i4 < 0) {
            return 0;
        }
        return i4;
    }

    protected boolean checkWipeOutETank(Point point) {
        int trackIndex = getTrackIndex(point.y);
        RectF peek = this.eTankSparseArray.get(trackIndex).peek();
        if (peek == null || !peek.contains(point.x, point.y)) {
            return false;
        }
        int i = this.wipeOutNum + 1;
        this.wipeOutNum = i;
        if (i == this.levelNum) {
            upLevel();
        }
        this.eTankSparseArray.get(trackIndex).poll();
        return true;
    }

    protected void upLevel() {
        this.levelNum += 8;
        this.enemySpeed += DensityUtil.dp2px(1.0f);
        this.bulletSpeed += DensityUtil.dp2px(1.0f);
        this.wipeOutNum = 0;
        int i = this.enemyTankSpace;
        if (i > 12) {
            this.enemyTankSpace = i - 12;
        }
        int i2 = this.bulletSpace;
        if (i2 > 30) {
            this.bulletSpace = i2 - 30;
        }
    }

    protected boolean checkTankCrash(int i, float f, float f2) {
        RectF peek = this.eTankSparseArray.get(i).peek();
        return peek != null && peek.contains(f, f2);
    }

    protected int appearanceOption() {
        return this.random.nextInt(TANK_ROW_NUM);
    }

    @Override // com.scwang.smartrefresh.header.fungame.FunGameView
    protected void drawGame(Canvas canvas, int i, int i2) {
        drawSelfTank(canvas, i);
        if (this.status == 1 || this.status == 3 || this.status == 4) {
            drawEnemyTank(canvas, i);
            drawBulletPath(canvas, i);
        }
        if (isInEditMode()) {
            drawTank(canvas, new RectF(this.controllerSize, 0.0f, this.controllerSize * 2, this.controllerSize));
            drawTank(canvas, new RectF(0.0f, this.controllerSize, this.controllerSize, this.controllerSize * 2));
            drawTank(canvas, new RectF(this.controllerSize * 3, this.controllerSize * 2, this.controllerSize * 4, this.controllerSize * 3));
        }
    }

    protected void drawBulletPath(Canvas canvas, int i) {
        this.mPaint.setColor(this.mModelColor);
        int i2 = this.offsetMBulletX + this.bulletSpeed;
        this.offsetMBulletX = i2;
        boolean z = false;
        if (i2 / this.bulletSpace == 1) {
            this.offsetMBulletX = 0;
        }
        if (this.offsetMBulletX == 0) {
            Point point = new Point();
            point.x = (i - this.controllerSize) - this.barrelSize;
            point.y = (int) (this.controllerPosition + (this.controllerSize * 0.5f));
            this.mBulletList.offer(point);
        }
        for (Point point2 : this.mBulletList) {
            if (checkWipeOutETank(point2)) {
                this.usedBullet = point2;
            } else {
                if (point2.x + this.bulletRadius <= 0.0f) {
                    z = true;
                }
                drawBullet(canvas, point2);
            }
        }
        if (z) {
            this.mBulletList.poll();
        }
        this.mBulletList.remove(this.usedBullet);
        this.usedBullet = null;
    }

    protected void drawBullet(Canvas canvas, Point point) {
        point.x -= this.bulletSpeed;
        canvas.drawCircle(point.x, point.y, this.bulletRadius, this.mPaint);
    }

    protected void drawSelfTank(Canvas canvas, int i) {
        int i2;
        this.mPaint.setColor(this.rModelColor);
        boolean checkTankCrash = checkTankCrash(getTrackIndex((int) this.controllerPosition), i - this.controllerSize, this.controllerPosition);
        boolean checkTankCrash2 = checkTankCrash(getTrackIndex((int) (this.controllerPosition + this.controllerSize)), i - this.controllerSize, this.controllerPosition + this.controllerSize);
        if (checkTankCrash || checkTankCrash2) {
            this.status = 2;
        }
        canvas.drawRect(i - this.controllerSize, this.controllerPosition + this.DIVIDING_LINE_SIZE, i, this.controllerPosition + this.controllerSize + this.DIVIDING_LINE_SIZE, this.mPaint);
        float f = (i - this.controllerSize) - this.barrelSize;
        float f2 = this.controllerPosition + ((this.controllerSize - this.barrelSize) * 0.5f);
        float f3 = i - this.controllerSize;
        float f4 = this.controllerPosition;
        int i3 = this.controllerSize;
        canvas.drawRect(f, f2, f3, f4 + ((i3 - i2) * 0.5f) + this.barrelSize, this.mPaint);
    }

    protected void drawEnemyTank(Canvas canvas, int i) {
        this.mPaint.setColor(this.lModelColor);
        int i2 = this.offsetETankX + this.enemySpeed;
        this.offsetETankX = i2;
        if (i2 / this.enemyTankSpace == 1 || this.once) {
            this.offsetETankX = 0;
            this.once = false;
        }
        int appearanceOption = appearanceOption();
        boolean z = false;
        for (int i3 = 0; i3 < TANK_ROW_NUM; i3++) {
            Queue<RectF> queue = this.eTankSparseArray.get(i3);
            if (this.offsetETankX == 0 && i3 == appearanceOption) {
                queue.offer(generateEnemyTank(i3));
            }
            Iterator<RectF> it = queue.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                RectF next = it.next();
                if (next.left >= i) {
                    int i4 = this.overstepNum + 1;
                    this.overstepNum = i4;
                    if (i4 >= 8) {
                        this.status = 2;
                        z = true;
                        break;
                    }
                    z = true;
                } else {
                    drawTank(canvas, next);
                }
            }
            if (this.status == 2) {
                break;
            }
            if (z) {
                queue.poll();
                z = false;
            }
        }
        invalidate();
    }

    protected void drawTank(Canvas canvas, RectF rectF) {
        rectF.set(rectF.left + this.enemySpeed, rectF.top, rectF.right + this.enemySpeed, rectF.bottom);
        canvas.drawRect(rectF, this.mPaint);
        float f = rectF.top + ((this.controllerSize - this.barrelSize) * 0.5f);
        float f2 = rectF.right;
        float f3 = rectF.right;
        int i = this.barrelSize;
        canvas.drawRect(f2, f, f3 + i, f + i, this.mPaint);
    }
}
