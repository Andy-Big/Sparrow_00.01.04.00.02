package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.R;
import androidx.core.view.GravityCompat;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    public static final int HORIZONTAL = 0;
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    public static final int SHOW_DIVIDER_BEGINNING = 1;
    public static final int SHOW_DIVIDER_END = 4;
    public static final int SHOW_DIVIDER_MIDDLE = 2;
    public static final int SHOW_DIVIDER_NONE = 0;
    public static final int VERTICAL = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface DividerMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OrientationMode {
    }

    int getChildrenSkipCount(View view, int i) {
        return 0;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    int measureNullChild(int i) {
        return 0;
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context) {
        this(context, null);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = BadgeDrawable.TOP_START;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.LinearLayoutCompat, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, R.styleable.LinearLayoutCompat, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i, 0);
        int i2 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_orientation, -1);
        if (i2 >= 0) {
            setOrientation(i2);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_gravity, -1);
        if (i3 >= 0) {
            setGravity(i3);
        }
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z) {
            setBaselineAligned(z);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R.styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R.styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R.styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    public void setShowDividers(int i) {
        if (i != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i) {
        this.mDividerPadding = i;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int bottom;
        int virtualChildCount = getVirtualChildCount();
        for (int i = 0; i < virtualChildCount; i++) {
            View virtualChildAt = getVirtualChildAt(i);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LayoutParams) virtualChildAt.getLayoutParams()).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 == null) {
                bottom = (getHeight() - getPaddingBottom()) - this.mDividerHeight;
            } else {
                bottom = virtualChildAt2.getBottom() + ((LayoutParams) virtualChildAt2.getLayoutParams()).bottomMargin;
            }
            drawHorizontalDivider(canvas, bottom);
        }
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i;
        int left2;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i2 = 0; i2 < virtualChildCount; i2++) {
            View virtualChildAt = getVirtualChildAt(i2);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i2)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (isLayoutRtl) {
                    left2 = virtualChildAt.getRight() + layoutParams.rightMargin;
                } else {
                    left2 = (virtualChildAt.getLeft() - layoutParams.leftMargin) - this.mDividerWidth;
                }
                drawVerticalDivider(canvas, left2);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft() - layoutParams2.leftMargin;
                    i = this.mDividerWidth;
                    right = left - i;
                } else {
                    right = virtualChildAt2.getRight() + layoutParams2.rightMargin;
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i = this.mDividerWidth;
                right = left - i;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i) {
        this.mDivider.setBounds(i, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    public boolean isBaselineAligned() {
        return this.mBaselineAligned;
    }

    public void setBaselineAligned(boolean z) {
        this.mBaselineAligned = z;
    }

    public boolean isMeasureWithLargestChildEnabled() {
        return this.mUseLargestChild;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.mUseLargestChild = z;
    }

    @Override // android.view.View
    public int getBaseline() {
        int i;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i2 = this.mBaselineAlignedChildIndex;
        if (childCount <= i2) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i2);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i3 = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i = this.mGravity & 112) != 48) {
            if (i == 16) {
                i3 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i == 80) {
                i3 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return i3 + ((LayoutParams) childAt.getLayoutParams()).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.mBaselineAlignedChildIndex = i;
    }

    View getVirtualChildAt(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    public void setWeightSum(float f) {
        this.mWeightSum = Math.max(0.0f, f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.mOrientation == 1) {
            measureVertical(i, i2);
        } else {
            measureHorizontal(i, i2);
        }
    }

    protected boolean hasDividerBeforeChildAt(int i) {
        if (i == 0) {
            return (this.mShowDividers & 1) != 0;
        } else if (i == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        } else if ((this.mShowDividers & 2) != 0) {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x032b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureVertical(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        View view;
        int max;
        boolean z2;
        int max2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i19 = this.mBaselineAlignedChildIndex;
        boolean z3 = this.mUseLargestChild;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        boolean z4 = false;
        boolean z5 = false;
        float f = 0.0f;
        boolean z6 = true;
        while (true) {
            int i26 = 8;
            int i27 = i23;
            if (i25 < virtualChildCount) {
                View virtualChildAt = getVirtualChildAt(i25);
                if (virtualChildAt == null) {
                    this.mTotalLength += measureNullChild(i25);
                    i16 = virtualChildCount;
                    i14 = mode2;
                    i23 = i27;
                } else {
                    int i28 = i20;
                    if (virtualChildAt.getVisibility() == 8) {
                        i25 += getChildrenSkipCount(virtualChildAt, i25);
                        i16 = virtualChildCount;
                        i23 = i27;
                        i20 = i28;
                        i14 = mode2;
                    } else {
                        if (hasDividerBeforeChildAt(i25)) {
                            this.mTotalLength += this.mDividerHeight;
                        }
                        LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                        float f2 = f + layoutParams.weight;
                        if (mode2 == 1073741824 && layoutParams.height == 0 && layoutParams.weight > 0.0f) {
                            int i29 = this.mTotalLength;
                            this.mTotalLength = Math.max(i29, layoutParams.topMargin + i29 + layoutParams.bottomMargin);
                            max = i22;
                            view = virtualChildAt;
                            i17 = i24;
                            i16 = virtualChildCount;
                            z4 = true;
                            i12 = i28;
                            i13 = i21;
                            i18 = i25;
                            i14 = mode2;
                            i15 = i27;
                        } else {
                            int i30 = i21;
                            if (layoutParams.height != 0 || layoutParams.weight <= 0.0f) {
                                i11 = Integer.MIN_VALUE;
                            } else {
                                layoutParams.height = -2;
                                i11 = 0;
                            }
                            i12 = i28;
                            int i31 = i11;
                            i13 = i30;
                            int i32 = i22;
                            i14 = mode2;
                            i15 = i27;
                            i16 = virtualChildCount;
                            i17 = i24;
                            i18 = i25;
                            measureChildBeforeLayout(virtualChildAt, i25, i, 0, i2, f2 == 0.0f ? this.mTotalLength : 0);
                            if (i31 != Integer.MIN_VALUE) {
                                layoutParams.height = i31;
                            }
                            int measuredHeight = virtualChildAt.getMeasuredHeight();
                            int i33 = this.mTotalLength;
                            view = virtualChildAt;
                            this.mTotalLength = Math.max(i33, i33 + measuredHeight + layoutParams.topMargin + layoutParams.bottomMargin + getNextLocationOffset(view));
                            max = z3 ? Math.max(measuredHeight, i32) : i32;
                        }
                        if (i19 >= 0 && i19 == i18 + 1) {
                            this.mBaselineChildTop = this.mTotalLength;
                        }
                        if (i18 < i19 && layoutParams.weight > 0.0f) {
                            throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                        }
                        if (mode == 1073741824 || layoutParams.width != -1) {
                            z2 = false;
                        } else {
                            z2 = true;
                            z5 = true;
                        }
                        int i34 = layoutParams.leftMargin + layoutParams.rightMargin;
                        int measuredWidth = view.getMeasuredWidth() + i34;
                        int max3 = Math.max(i13, measuredWidth);
                        int combineMeasuredStates = View.combineMeasuredStates(i12, view.getMeasuredState());
                        z6 = z6 && layoutParams.width == -1;
                        if (layoutParams.weight > 0.0f) {
                            if (!z2) {
                                i34 = measuredWidth;
                            }
                            i23 = Math.max(i15, i34);
                            max2 = i17;
                        } else {
                            if (!z2) {
                                i34 = measuredWidth;
                            }
                            max2 = Math.max(i17, i34);
                            i23 = i15;
                        }
                        i22 = max;
                        f = f2;
                        i24 = max2;
                        i20 = combineMeasuredStates;
                        i25 = getChildrenSkipCount(view, i18) + i18;
                        i21 = max3;
                    }
                }
                i25++;
                virtualChildCount = i16;
                mode2 = i14;
            } else {
                int i35 = i20;
                int i36 = i22;
                int i37 = i24;
                int i38 = virtualChildCount;
                int i39 = mode2;
                int i40 = i21;
                if (this.mTotalLength > 0) {
                    i3 = i38;
                    if (hasDividerBeforeChildAt(i3)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i3 = i38;
                }
                if (z3 && (i39 == Integer.MIN_VALUE || i39 == 0)) {
                    this.mTotalLength = 0;
                    int i41 = 0;
                    while (i41 < i3) {
                        View virtualChildAt2 = getVirtualChildAt(i41);
                        if (virtualChildAt2 == null) {
                            this.mTotalLength += measureNullChild(i41);
                        } else if (virtualChildAt2.getVisibility() == i26) {
                            i41 += getChildrenSkipCount(virtualChildAt2, i41);
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            int i42 = this.mTotalLength;
                            this.mTotalLength = Math.max(i42, i42 + i36 + layoutParams2.topMargin + layoutParams2.bottomMargin + getNextLocationOffset(virtualChildAt2));
                        }
                        i41++;
                        i26 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i2, 0);
                int i43 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (z4 || (i43 != 0 && f > 0.0f)) {
                    float f3 = this.mWeightSum;
                    if (f3 > 0.0f) {
                        f = f3;
                    }
                    this.mTotalLength = 0;
                    int i44 = i43;
                    int i45 = i37;
                    i4 = i35;
                    int i46 = 0;
                    while (i46 < i3) {
                        View virtualChildAt3 = getVirtualChildAt(i46);
                        if (virtualChildAt3.getVisibility() == 8) {
                            i7 = i44;
                        } else {
                            LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                            float f4 = layoutParams3.weight;
                            if (f4 > 0.0f) {
                                int i47 = (int) ((i44 * f4) / f);
                                float f5 = f - f4;
                                i7 = i44 - i47;
                                int childMeasureSpec = getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight() + layoutParams3.leftMargin + layoutParams3.rightMargin, layoutParams3.width);
                                if (layoutParams3.height == 0) {
                                    i10 = 1073741824;
                                    if (i39 == 1073741824) {
                                        if (i47 <= 0) {
                                            i47 = 0;
                                        }
                                        virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i47, 1073741824));
                                        i4 = View.combineMeasuredStates(i4, virtualChildAt3.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                        f = f5;
                                    }
                                } else {
                                    i10 = 1073741824;
                                }
                                int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i47;
                                if (measuredHeight2 < 0) {
                                    measuredHeight2 = 0;
                                }
                                virtualChildAt3.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight2, i10));
                                i4 = View.combineMeasuredStates(i4, virtualChildAt3.getMeasuredState() & InputDeviceCompat.SOURCE_ANY);
                                f = f5;
                            } else {
                                i7 = i44;
                            }
                            int i48 = layoutParams3.leftMargin + layoutParams3.rightMargin;
                            int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i48;
                            i40 = Math.max(i40, measuredWidth2);
                            float f6 = f;
                            if (mode != 1073741824) {
                                i8 = i4;
                                i9 = -1;
                                if (layoutParams3.width == -1) {
                                    z = true;
                                    if (!z) {
                                        i48 = measuredWidth2;
                                    }
                                    int max4 = Math.max(i45, i48);
                                    boolean z7 = !z6 && layoutParams3.width == i9;
                                    int i49 = this.mTotalLength;
                                    this.mTotalLength = Math.max(i49, virtualChildAt3.getMeasuredHeight() + i49 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                                    z6 = z7;
                                    i4 = i8;
                                    i45 = max4;
                                    f = f6;
                                }
                            } else {
                                i8 = i4;
                                i9 = -1;
                            }
                            z = false;
                            if (!z) {
                            }
                            int max42 = Math.max(i45, i48);
                            if (z6) {
                            }
                            int i492 = this.mTotalLength;
                            this.mTotalLength = Math.max(i492, virtualChildAt3.getMeasuredHeight() + i492 + layoutParams3.topMargin + layoutParams3.bottomMargin + getNextLocationOffset(virtualChildAt3));
                            z6 = z7;
                            i4 = i8;
                            i45 = max42;
                            f = f6;
                        }
                        i46++;
                        i44 = i7;
                    }
                    i5 = i;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i6 = i45;
                } else {
                    i6 = Math.max(i37, i27);
                    if (z3 && i39 != 1073741824) {
                        for (int i50 = 0; i50 < i3; i50++) {
                            View virtualChildAt4 = getVirtualChildAt(i50);
                            if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                                virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i36, 1073741824));
                            }
                        }
                    }
                    i5 = i;
                    i4 = i35;
                }
                if (z6 || mode == 1073741824) {
                    i6 = i40;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i6 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i5, i4), resolveSizeAndState);
                if (z5) {
                    forceUniformWidth(i3, i2);
                    return;
                }
                return;
            }
        }
    }

    private void forceUniformWidth(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i4 = layoutParams.height;
                    layoutParams.height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i2, 0);
                    layoutParams.height = i4;
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:198:0x045a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureHorizontal(int i, int i2) {
        int[] iArr;
        int i3;
        int max;
        int i4;
        int i5;
        int max2;
        int i6;
        int i7;
        int i8;
        float f;
        int i9;
        boolean z;
        int baseline;
        int i10;
        int i11;
        char c;
        int i12;
        int i13;
        boolean z2;
        boolean z3;
        View view;
        int i14;
        boolean z4;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z5 = this.mBaselineAligned;
        boolean z6 = this.mUseLargestChild;
        int i15 = 1073741824;
        boolean z7 = mode == 1073741824;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        boolean z8 = false;
        int i21 = 0;
        boolean z9 = false;
        boolean z10 = true;
        float f2 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (i16 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i16);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i16);
            } else if (virtualChildAt.getVisibility() == 8) {
                i16 += getChildrenSkipCount(virtualChildAt, i16);
            } else {
                if (hasDividerBeforeChildAt(i16)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f3 = f2 + layoutParams.weight;
                if (mode == i15 && layoutParams.width == 0 && layoutParams.weight > 0.0f) {
                    if (z7) {
                        this.mTotalLength += layoutParams.leftMargin + layoutParams.rightMargin;
                    } else {
                        int i22 = this.mTotalLength;
                        this.mTotalLength = Math.max(i22, layoutParams.leftMargin + i22 + layoutParams.rightMargin);
                    }
                    if (z5) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i13 = i16;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                    } else {
                        i13 = i16;
                        z2 = z6;
                        z3 = z5;
                        view = virtualChildAt;
                        z8 = true;
                        i14 = 1073741824;
                        if (mode2 == i14 && layoutParams.height == -1) {
                            z4 = true;
                            z9 = true;
                        } else {
                            z4 = false;
                        }
                        int i23 = layoutParams.topMargin + layoutParams.bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i23;
                        i21 = View.combineMeasuredStates(i21, view.getMeasuredState());
                        if (z3 && (baseline2 = view.getBaseline()) != -1) {
                            int i24 = ((((layoutParams.gravity >= 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & (-2)) >> 1;
                            iArr2[i24] = Math.max(iArr2[i24], baseline2);
                            iArr[i24] = Math.max(iArr[i24], measuredHeight - baseline2);
                        }
                        i18 = Math.max(i18, measuredHeight);
                        z10 = !z10 && layoutParams.height == -1;
                        if (layoutParams.weight <= 0.0f) {
                            if (!z4) {
                                i23 = measuredHeight;
                            }
                            i20 = Math.max(i20, i23);
                        } else {
                            int i25 = i20;
                            if (!z4) {
                                i23 = measuredHeight;
                            }
                            i19 = Math.max(i19, i23);
                            i20 = i25;
                        }
                        int i26 = i13;
                        childrenSkipCount = getChildrenSkipCount(view, i26) + i26;
                        f2 = f3;
                        int i27 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z6 = z2;
                        z5 = z3;
                        i15 = i14;
                        i16 = i27;
                    }
                } else {
                    if (layoutParams.width != 0 || layoutParams.weight <= 0.0f) {
                        c = 65534;
                        i12 = Integer.MIN_VALUE;
                    } else {
                        c = 65534;
                        layoutParams.width = -2;
                        i12 = 0;
                    }
                    i13 = i16;
                    int i28 = i12;
                    z2 = z6;
                    z3 = z5;
                    measureChildBeforeLayout(virtualChildAt, i13, i, f3 == 0.0f ? this.mTotalLength : 0, i2, 0);
                    if (i28 != Integer.MIN_VALUE) {
                        layoutParams.width = i28;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z7) {
                        view = virtualChildAt;
                        this.mTotalLength += layoutParams.leftMargin + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i29 = this.mTotalLength;
                        this.mTotalLength = Math.max(i29, i29 + measuredWidth + layoutParams.leftMargin + layoutParams.rightMargin + getNextLocationOffset(view));
                    }
                    if (z2) {
                        i17 = Math.max(measuredWidth, i17);
                    }
                }
                i14 = 1073741824;
                if (mode2 == i14) {
                }
                z4 = false;
                int i232 = layoutParams.topMargin + layoutParams.bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i232;
                i21 = View.combineMeasuredStates(i21, view.getMeasuredState());
                if (z3) {
                    int i242 = ((((layoutParams.gravity >= 0 ? this.mGravity : layoutParams.gravity) & 112) >> 4) & (-2)) >> 1;
                    iArr2[i242] = Math.max(iArr2[i242], baseline2);
                    iArr[i242] = Math.max(iArr[i242], measuredHeight - baseline2);
                }
                i18 = Math.max(i18, measuredHeight);
                if (z10) {
                }
                if (layoutParams.weight <= 0.0f) {
                }
                int i262 = i13;
                childrenSkipCount = getChildrenSkipCount(view, i262) + i262;
                f2 = f3;
                int i272 = childrenSkipCount + 1;
                iArr3 = iArr;
                z6 = z2;
                z5 = z3;
                i15 = i14;
                i16 = i272;
            }
            z2 = z6;
            z3 = z5;
            int i30 = i15;
            childrenSkipCount = i16;
            i14 = i30;
            int i2722 = childrenSkipCount + 1;
            iArr3 = iArr;
            z6 = z2;
            z5 = z3;
            i15 = i14;
            i16 = i2722;
        }
        boolean z11 = z6;
        boolean z12 = z5;
        int i31 = i18;
        int i32 = i19;
        int i33 = i20;
        int i34 = i21;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        if (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i31;
            i3 = i34;
        } else {
            i3 = i34;
            max = Math.max(i31, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z11 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i35 = 0;
            while (i35 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i35);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i35);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i35 += getChildrenSkipCount(virtualChildAt2, i35);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z7) {
                        this.mTotalLength += layoutParams2.leftMargin + i17 + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i36 = this.mTotalLength;
                        i11 = max;
                        this.mTotalLength = Math.max(i36, i36 + i17 + layoutParams2.leftMargin + layoutParams2.rightMargin + getNextLocationOffset(virtualChildAt2));
                        i35++;
                        max = i11;
                    }
                }
                i11 = max;
                i35++;
                max = i11;
            }
        }
        int i37 = max;
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i, 0);
        int i38 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z8 || (i38 != 0 && f2 > 0.0f)) {
            float f4 = this.mWeightSum;
            if (f4 > 0.0f) {
                f2 = f4;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i39 = i32;
            int i40 = -1;
            int i41 = i3;
            int i42 = 0;
            while (i42 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i42);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i7 = i38;
                    i8 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f5 = layoutParams3.weight;
                    if (f5 > 0.0f) {
                        int i43 = (int) ((i38 * f5) / f2);
                        float f6 = f2 - f5;
                        int i44 = i38 - i43;
                        i8 = virtualChildCount;
                        int childMeasureSpec = getChildMeasureSpec(i2, getPaddingTop() + getPaddingBottom() + layoutParams3.topMargin + layoutParams3.bottomMargin, layoutParams3.height);
                        if (layoutParams3.width == 0) {
                            i10 = 1073741824;
                            if (mode == 1073741824) {
                                if (i43 <= 0) {
                                    i43 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i43, 1073741824), childMeasureSpec);
                                i41 = View.combineMeasuredStates(i41, virtualChildAt3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                                f2 = f6;
                                i7 = i44;
                            }
                        } else {
                            i10 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i43;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i10), childMeasureSpec);
                        i41 = View.combineMeasuredStates(i41, virtualChildAt3.getMeasuredState() & ViewCompat.MEASURED_STATE_MASK);
                        f2 = f6;
                        i7 = i44;
                    } else {
                        i7 = i38;
                        i8 = virtualChildCount;
                    }
                    if (z7) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3);
                        f = f2;
                    } else {
                        int i45 = this.mTotalLength;
                        f = f2;
                        this.mTotalLength = Math.max(i45, virtualChildAt3.getMeasuredWidth() + i45 + layoutParams3.leftMargin + layoutParams3.rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z13 = mode2 != 1073741824 && layoutParams3.height == -1;
                    int i46 = layoutParams3.topMargin + layoutParams3.bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i46;
                    i40 = Math.max(i40, measuredHeight2);
                    if (!z13) {
                        i46 = measuredHeight2;
                    }
                    int max3 = Math.max(i39, i46);
                    if (z10) {
                        i9 = -1;
                        if (layoutParams3.height == -1) {
                            z = true;
                            if (z12 && (baseline = virtualChildAt3.getBaseline()) != i9) {
                                int i47 = ((((layoutParams3.gravity >= 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & (-2)) >> 1;
                                iArr2[i47] = Math.max(iArr2[i47], baseline);
                                iArr[i47] = Math.max(iArr[i47], measuredHeight2 - baseline);
                            }
                            z10 = z;
                            i39 = max3;
                            f2 = f;
                        }
                    } else {
                        i9 = -1;
                    }
                    z = false;
                    if (z12) {
                        int i472 = ((((layoutParams3.gravity >= 0 ? this.mGravity : layoutParams3.gravity) & 112) >> 4) & (-2)) >> 1;
                        iArr2[i472] = Math.max(iArr2[i472], baseline);
                        iArr[i472] = Math.max(iArr[i472], measuredHeight2 - baseline);
                    }
                    z10 = z;
                    i39 = max3;
                    f2 = f;
                }
                i42++;
                i38 = i7;
                virtualChildCount = i8;
            }
            i4 = i2;
            i5 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            max2 = (iArr2[1] == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i40 : Math.max(i40, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i6 = i39;
            i3 = i41;
        } else {
            i6 = Math.max(i32, i33);
            if (z11 && mode != 1073741824) {
                for (int i48 = 0; i48 < virtualChildCount; i48++) {
                    View virtualChildAt4 = getVirtualChildAt(i48);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LayoutParams) virtualChildAt4.getLayoutParams()).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i17, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i4 = i2;
            i5 = virtualChildCount;
            max2 = i37;
        }
        if (z10 || mode2 == 1073741824) {
            i6 = max2;
        }
        setMeasuredDimension(resolveSizeAndState | (i3 & ViewCompat.MEASURED_STATE_MASK), View.resolveSizeAndState(Math.max(i6 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i4, i3 << 16));
        if (z9) {
            forceUniformHeight(i5, i);
        }
    }

    private void forceUniformHeight(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View virtualChildAt = getVirtualChildAt(i3);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (layoutParams.height == -1) {
                    int i4 = layoutParams.width;
                    layoutParams.width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i2, 0, makeMeasureSpec, 0);
                    layoutParams.width = i4;
                }
            }
        }
    }

    void measureChildBeforeLayout(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.mOrientation == 1) {
            layoutVertical(i, i2, i3, i4);
        } else {
            layoutHorizontal(i, i2, i3, i4);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutVertical(int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int i7;
        int i8;
        int paddingLeft = getPaddingLeft();
        int i9 = i3 - i;
        int paddingRight = i9 - getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i10 = this.mGravity;
        int i11 = i10 & 112;
        int i12 = i10 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i11 == 16) {
            paddingTop = getPaddingTop() + (((i4 - i2) - this.mTotalLength) / 2);
        } else if (i11 == 80) {
            paddingTop = ((getPaddingTop() + i4) - i2) - this.mTotalLength;
        } else {
            paddingTop = getPaddingTop();
        }
        int i13 = 0;
        while (i13 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i13);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i13);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i12;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i14, ViewCompat.getLayoutDirection(this)) & 7;
                if (absoluteGravity == 1) {
                    i5 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i6 = layoutParams.rightMargin;
                } else if (absoluteGravity == 5) {
                    i5 = paddingRight - measuredWidth;
                    i6 = layoutParams.rightMargin;
                } else {
                    i7 = layoutParams.leftMargin + paddingLeft;
                    int i15 = i7;
                    if (hasDividerBeforeChildAt(i13)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i16 = paddingTop + layoutParams.topMargin;
                    setChildFrame(virtualChildAt, i15, i16 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    i13 += getChildrenSkipCount(virtualChildAt, i13);
                    paddingTop = i16 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                    i8 = 1;
                    i13 += i8;
                }
                i7 = i5 - i6;
                int i152 = i7;
                if (hasDividerBeforeChildAt(i13)) {
                }
                int i162 = paddingTop + layoutParams.topMargin;
                setChildFrame(virtualChildAt, i152, i162 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                i13 += getChildrenSkipCount(virtualChildAt, i13);
                paddingTop = i162 + measuredHeight + layoutParams.bottomMargin + getNextLocationOffset(virtualChildAt);
                i8 = 1;
                i13 += i8;
            }
            i8 = 1;
            i13 += i8;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutHorizontal(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i14 = i4 - i2;
        int paddingBottom = i14 - getPaddingBottom();
        int paddingBottom2 = (i14 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i15 = this.mGravity;
        int i16 = i15 & 112;
        boolean z2 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i15, ViewCompat.getLayoutDirection(this));
        boolean z3 = true;
        if (absoluteGravity == 1) {
            paddingLeft = getPaddingLeft() + (((i3 - i) - this.mTotalLength) / 2);
        } else if (absoluteGravity == 5) {
            paddingLeft = ((getPaddingLeft() + i3) - i) - this.mTotalLength;
        } else {
            paddingLeft = getPaddingLeft();
        }
        if (isLayoutRtl) {
            i5 = virtualChildCount - 1;
            i6 = -1;
        } else {
            i5 = 0;
            i6 = 1;
        }
        int i17 = 0;
        while (i17 < virtualChildCount) {
            int i18 = i5 + (i6 * i17);
            View virtualChildAt = getVirtualChildAt(i18);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i18);
                z = z3;
                i7 = paddingTop;
                i8 = virtualChildCount;
                i9 = i16;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i19 = i17;
                if (z2) {
                    i8 = virtualChildCount;
                    if (layoutParams.height != -1) {
                        i10 = virtualChildAt.getBaseline();
                        i11 = layoutParams.gravity;
                        if (i11 < 0) {
                            i11 = i16;
                        }
                        i12 = i11 & 112;
                        i9 = i16;
                        if (i12 == 16) {
                            if (i12 == 48) {
                                i13 = layoutParams.topMargin + paddingTop;
                                if (i10 != -1) {
                                    z = true;
                                    i13 += iArr[1] - i10;
                                }
                            } else if (i12 != 80) {
                                i13 = paddingTop;
                            } else {
                                i13 = (paddingBottom - measuredHeight) - layoutParams.bottomMargin;
                                if (i10 != -1) {
                                    i13 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i10);
                                }
                            }
                            z = true;
                        } else {
                            z = true;
                            i13 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + layoutParams.topMargin) - layoutParams.bottomMargin;
                        }
                        if (hasDividerBeforeChildAt(i18)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i20 = layoutParams.leftMargin + paddingLeft;
                        i7 = paddingTop;
                        setChildFrame(virtualChildAt, i20 + getLocationOffset(virtualChildAt), i13, measuredWidth, measuredHeight);
                        i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                        paddingLeft = i20 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                        i17++;
                        virtualChildCount = i8;
                        i16 = i9;
                        z3 = z;
                        paddingTop = i7;
                    }
                } else {
                    i8 = virtualChildCount;
                }
                i10 = -1;
                i11 = layoutParams.gravity;
                if (i11 < 0) {
                }
                i12 = i11 & 112;
                i9 = i16;
                if (i12 == 16) {
                }
                if (hasDividerBeforeChildAt(i18)) {
                }
                int i202 = layoutParams.leftMargin + paddingLeft;
                i7 = paddingTop;
                setChildFrame(virtualChildAt, i202 + getLocationOffset(virtualChildAt), i13, measuredWidth, measuredHeight);
                i17 = i19 + getChildrenSkipCount(virtualChildAt, i18);
                paddingLeft = i202 + measuredWidth + layoutParams.rightMargin + getNextLocationOffset(virtualChildAt);
                i17++;
                virtualChildCount = i8;
                i16 = i9;
                z3 = z;
                paddingTop = i7;
            } else {
                i7 = paddingTop;
                i8 = virtualChildCount;
                i9 = i16;
                z = true;
            }
            i17++;
            virtualChildCount = i8;
            i16 = i9;
            z3 = z;
            paddingTop = i7;
        }
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i3 + i, i4 + i2);
    }

    public void setOrientation(int i) {
        if (this.mOrientation != i) {
            this.mOrientation = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public void setGravity(int i) {
        if (this.mGravity != i) {
            if ((8388615 & i) == 0) {
                i |= GravityCompat.START;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.mGravity = i;
            requestLayout();
        }
    }

    public int getGravity() {
        return this.mGravity;
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        int i3 = this.mGravity;
        if ((8388615 & i3) != i2) {
            this.mGravity = i2 | ((-8388616) & i3);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        int i3 = this.mGravity;
        if ((i3 & 112) != i2) {
            this.mGravity = i2 | (i3 & (-113));
            requestLayout();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i = this.mOrientation;
        if (i == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int gravity;
        public float weight;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.gravity = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.LinearLayoutCompat_Layout);
            this.weight = obtainStyledAttributes.getFloat(R.styleable.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.gravity = obtainStyledAttributes.getInt(R.styleable.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.gravity = -1;
            this.weight = 0.0f;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2);
            this.gravity = -1;
            this.weight = f;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.gravity = -1;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.gravity = -1;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.gravity = -1;
            this.weight = layoutParams.weight;
            this.gravity = layoutParams.gravity;
        }
    }
}
