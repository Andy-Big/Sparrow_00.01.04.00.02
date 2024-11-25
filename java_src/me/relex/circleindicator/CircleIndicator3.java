package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import me.relex.circleindicator.BaseCircleIndicator;
/* loaded from: classes2.dex */
public class CircleIndicator3 extends BaseCircleIndicator {
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver;
    private final ViewPager2.OnPageChangeCallback mInternalPageChangeCallback;
    private ViewPager2 mViewpager;

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

    public CircleIndicator3(Context context) {
        super(context);
        this.mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: me.relex.circleindicator.CircleIndicator3.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                if (i == CircleIndicator3.this.mLastPosition || CircleIndicator3.this.mViewpager.getAdapter() == null || CircleIndicator3.this.mViewpager.getAdapter().getItemCount() <= 0) {
                    return;
                }
                CircleIndicator3.this.animatePageSelected(i);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: me.relex.circleindicator.CircleIndicator3.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator3.this.mViewpager == null) {
                    return;
                }
                RecyclerView.Adapter adapter = CircleIndicator3.this.mViewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == CircleIndicator3.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator3.this.mLastPosition < itemCount) {
                    CircleIndicator3 circleIndicator3 = CircleIndicator3.this;
                    circleIndicator3.mLastPosition = circleIndicator3.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator3.this.mLastPosition = -1;
                }
                CircleIndicator3.this.createIndicators();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                super.onItemRangeChanged(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, Object obj) {
                super.onItemRangeChanged(i, i2, obj);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                super.onItemRangeInserted(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                super.onItemRangeRemoved(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                super.onItemRangeMoved(i, i2, i3);
                onChanged();
            }
        };
    }

    public CircleIndicator3(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: me.relex.circleindicator.CircleIndicator3.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i) {
                if (i == CircleIndicator3.this.mLastPosition || CircleIndicator3.this.mViewpager.getAdapter() == null || CircleIndicator3.this.mViewpager.getAdapter().getItemCount() <= 0) {
                    return;
                }
                CircleIndicator3.this.animatePageSelected(i);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: me.relex.circleindicator.CircleIndicator3.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator3.this.mViewpager == null) {
                    return;
                }
                RecyclerView.Adapter adapter = CircleIndicator3.this.mViewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == CircleIndicator3.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator3.this.mLastPosition < itemCount) {
                    CircleIndicator3 circleIndicator3 = CircleIndicator3.this;
                    circleIndicator3.mLastPosition = circleIndicator3.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator3.this.mLastPosition = -1;
                }
                CircleIndicator3.this.createIndicators();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2) {
                super.onItemRangeChanged(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i, int i2, Object obj) {
                super.onItemRangeChanged(i, i2, obj);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i, int i2) {
                super.onItemRangeInserted(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i, int i2) {
                super.onItemRangeRemoved(i, i2);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i, int i2, int i3) {
                super.onItemRangeMoved(i, i2, i3);
                onChanged();
            }
        };
    }

    public CircleIndicator3(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: me.relex.circleindicator.CircleIndicator3.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                if (i2 == CircleIndicator3.this.mLastPosition || CircleIndicator3.this.mViewpager.getAdapter() == null || CircleIndicator3.this.mViewpager.getAdapter().getItemCount() <= 0) {
                    return;
                }
                CircleIndicator3.this.animatePageSelected(i2);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: me.relex.circleindicator.CircleIndicator3.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator3.this.mViewpager == null) {
                    return;
                }
                RecyclerView.Adapter adapter = CircleIndicator3.this.mViewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == CircleIndicator3.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator3.this.mLastPosition < itemCount) {
                    CircleIndicator3 circleIndicator3 = CircleIndicator3.this;
                    circleIndicator3.mLastPosition = circleIndicator3.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator3.this.mLastPosition = -1;
                }
                CircleIndicator3.this.createIndicators();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i2, int i22) {
                super.onItemRangeChanged(i2, i22);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i2, int i22, Object obj) {
                super.onItemRangeChanged(i2, i22, obj);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i2, int i22) {
                super.onItemRangeInserted(i2, i22);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i2, int i22) {
                super.onItemRangeRemoved(i2, i22);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i2, int i22, int i3) {
                super.onItemRangeMoved(i2, i22, i3);
                onChanged();
            }
        };
    }

    public CircleIndicator3(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mInternalPageChangeCallback = new ViewPager2.OnPageChangeCallback() { // from class: me.relex.circleindicator.CircleIndicator3.1
            @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i22) {
                if (i22 == CircleIndicator3.this.mLastPosition || CircleIndicator3.this.mViewpager.getAdapter() == null || CircleIndicator3.this.mViewpager.getAdapter().getItemCount() <= 0) {
                    return;
                }
                CircleIndicator3.this.animatePageSelected(i22);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: me.relex.circleindicator.CircleIndicator3.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator3.this.mViewpager == null) {
                    return;
                }
                RecyclerView.Adapter adapter = CircleIndicator3.this.mViewpager.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == CircleIndicator3.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator3.this.mLastPosition < itemCount) {
                    CircleIndicator3 circleIndicator3 = CircleIndicator3.this;
                    circleIndicator3.mLastPosition = circleIndicator3.mViewpager.getCurrentItem();
                } else {
                    CircleIndicator3.this.mLastPosition = -1;
                }
                CircleIndicator3.this.createIndicators();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i22, int i222) {
                super.onItemRangeChanged(i22, i222);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i22, int i222, Object obj) {
                super.onItemRangeChanged(i22, i222, obj);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i22, int i222) {
                super.onItemRangeInserted(i22, i222);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i22, int i222) {
                super.onItemRangeRemoved(i22, i222);
                onChanged();
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i22, int i222, int i3) {
                super.onItemRangeMoved(i22, i222, i3);
                onChanged();
            }
        };
    }

    public void setViewPager(ViewPager2 viewPager2) {
        this.mViewpager = viewPager2;
        if (viewPager2 == null || viewPager2.getAdapter() == null) {
            return;
        }
        this.mLastPosition = -1;
        createIndicators();
        this.mViewpager.unregisterOnPageChangeCallback(this.mInternalPageChangeCallback);
        this.mViewpager.registerOnPageChangeCallback(this.mInternalPageChangeCallback);
        this.mInternalPageChangeCallback.onPageSelected(this.mViewpager.getCurrentItem());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIndicators() {
        RecyclerView.Adapter adapter = this.mViewpager.getAdapter();
        createIndicators(adapter == null ? 0 : adapter.getItemCount(), this.mViewpager.getCurrentItem());
    }

    public RecyclerView.AdapterDataObserver getAdapterDataObserver() {
        return this.mAdapterDataObserver;
    }
}
