package me.relex.circleindicator;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import me.relex.circleindicator.BaseCircleIndicator;
/* loaded from: classes2.dex */
public class CircleIndicator extends BaseCircleIndicator {
    private final DataSetObserver mInternalDataSetObserver;
    private final ViewPager.OnPageChangeListener mInternalPageChangeListener;
    private ViewPager mViewpager;

    @Override // me.relex.circleindicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void animatePageSelected(int i) {
        super.animatePageSelected(i);
    }

    @Override // me.relex.circleindicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(int i) {
        super.changeIndicatorResource(i);
    }

    @Override // me.relex.circleindicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void changeIndicatorResource(int i, int i2) {
        super.changeIndicatorResource(i, i2);
    }

    @Override // me.relex.circleindicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void createIndicators(int i, int i2) {
        super.createIndicators(i, i2);
    }

    @Override // me.relex.circleindicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void initialize(Config config) {
        super.initialize(config);
    }

    @Override // me.relex.circleindicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void setIndicatorCreatedListener(BaseCircleIndicator.IndicatorCreatedListener indicatorCreatedListener) {
        super.setIndicatorCreatedListener(indicatorCreatedListener);
    }

    @Override // me.relex.circleindicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(int i) {
        super.tintIndicator(i);
    }

    @Override // me.relex.circleindicator.BaseCircleIndicator
    public /* bridge */ /* synthetic */ void tintIndicator(int i, int i2) {
        super.tintIndicator(i, i2);
    }

    public CircleIndicator(Context context) {
        super(context);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (CircleIndicator.this.mViewpager.getAdapter() == null || CircleIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                CircleIndicator.this.animatePageSelected(i);
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.mViewpager == null) {
                    return;
                }
                PagerAdapter adapter = CircleIndicator.this.mViewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.mLastPosition < count) {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator.this.mLastPosition = -1;
                }
                CircleIndicator.this.createIndicators();
            }
        };
    }

    public CircleIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (CircleIndicator.this.mViewpager.getAdapter() == null || CircleIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                CircleIndicator.this.animatePageSelected(i);
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.mViewpager == null) {
                    return;
                }
                PagerAdapter adapter = CircleIndicator.this.mViewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.mLastPosition < count) {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator.this.mLastPosition = -1;
                }
                CircleIndicator.this.createIndicators();
            }
        };
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f, int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                if (CircleIndicator.this.mViewpager.getAdapter() == null || CircleIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                CircleIndicator.this.animatePageSelected(i2);
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.mViewpager == null) {
                    return;
                }
                PagerAdapter adapter = CircleIndicator.this.mViewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.mLastPosition < count) {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator.this.mLastPosition = -1;
                }
                CircleIndicator.this.createIndicators();
            }
        };
    }

    public CircleIndicator(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mInternalPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: me.relex.circleindicator.CircleIndicator.1
            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i22) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i22, float f, int i222) {
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i22) {
                if (CircleIndicator.this.mViewpager.getAdapter() == null || CircleIndicator.this.mViewpager.getAdapter().getCount() <= 0) {
                    return;
                }
                CircleIndicator.this.animatePageSelected(i22);
            }
        };
        this.mInternalDataSetObserver = new DataSetObserver() { // from class: me.relex.circleindicator.CircleIndicator.2
            @Override // android.database.DataSetObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator.this.mViewpager == null) {
                    return;
                }
                PagerAdapter adapter = CircleIndicator.this.mViewpager.getAdapter();
                int count = adapter != null ? adapter.getCount() : 0;
                if (count == CircleIndicator.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator.this.mLastPosition < count) {
                    CircleIndicator circleIndicator = CircleIndicator.this;
                    circleIndicator.mLastPosition = circleIndicator.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator.this.mLastPosition = -1;
                }
                CircleIndicator.this.createIndicators();
            }
        };
    }

    public void setViewPager(ViewPager viewPager) {
        this.mViewpager = viewPager;
        if (viewPager == null || viewPager.getAdapter() == null) {
            return;
        }
        this.mLastPosition = -1;
        createIndicators();
        this.mViewpager.removeOnPageChangeListener(this.mInternalPageChangeListener);
        this.mViewpager.addOnPageChangeListener(this.mInternalPageChangeListener);
        this.mInternalPageChangeListener.onPageSelected(this.mViewpager.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIndicators() {
        PagerAdapter adapter = this.mViewpager.getAdapter();
        createIndicators(adapter == null ? 0 : adapter.getCount(), this.mViewpager.getCurrentItem());
    }

    public DataSetObserver getDataSetObserver() {
        return this.mInternalDataSetObserver;
    }

    @Deprecated
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        ViewPager viewPager = this.mViewpager;
        if (viewPager == null) {
            throw new NullPointerException("can not find Viewpager , setViewPager first");
        }
        viewPager.removeOnPageChangeListener(onPageChangeListener);
        this.mViewpager.addOnPageChangeListener(onPageChangeListener);
    }
}
