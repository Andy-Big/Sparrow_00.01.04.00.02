package me.relex.circleindicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import me.relex.circleindicator.BaseCircleIndicator;
/* loaded from: classes2.dex */
public class CircleIndicator2 extends BaseCircleIndicator {
    private final RecyclerView.AdapterDataObserver mAdapterDataObserver;
    private final RecyclerView.OnScrollListener mInternalOnScrollListener;
    private RecyclerView mRecyclerView;
    private SnapHelper mSnapHelper;

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

    public CircleIndicator2(Context context) {
        super(context);
        this.mInternalOnScrollListener = new RecyclerView.OnScrollListener() { // from class: me.relex.circleindicator.CircleIndicator2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int snapPosition = CircleIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
                if (snapPosition == -1) {
                    return;
                }
                CircleIndicator2.this.animatePageSelected(snapPosition);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: me.relex.circleindicator.CircleIndicator2.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator2.this.mRecyclerView == null) {
                    return;
                }
                RecyclerView.Adapter adapter = CircleIndicator2.this.mRecyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == CircleIndicator2.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator2.this.mLastPosition < itemCount) {
                    CircleIndicator2 circleIndicator2 = CircleIndicator2.this;
                    circleIndicator2.mLastPosition = circleIndicator2.getSnapPosition(circleIndicator2.mRecyclerView.getLayoutManager());
                } else {
                    CircleIndicator2.this.mLastPosition = -1;
                }
                CircleIndicator2.this.createIndicators();
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

    public CircleIndicator2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mInternalOnScrollListener = new RecyclerView.OnScrollListener() { // from class: me.relex.circleindicator.CircleIndicator2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i, int i2) {
                super.onScrolled(recyclerView, i, i2);
                int snapPosition = CircleIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
                if (snapPosition == -1) {
                    return;
                }
                CircleIndicator2.this.animatePageSelected(snapPosition);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: me.relex.circleindicator.CircleIndicator2.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator2.this.mRecyclerView == null) {
                    return;
                }
                RecyclerView.Adapter adapter = CircleIndicator2.this.mRecyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == CircleIndicator2.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator2.this.mLastPosition < itemCount) {
                    CircleIndicator2 circleIndicator2 = CircleIndicator2.this;
                    circleIndicator2.mLastPosition = circleIndicator2.getSnapPosition(circleIndicator2.mRecyclerView.getLayoutManager());
                } else {
                    CircleIndicator2.this.mLastPosition = -1;
                }
                CircleIndicator2.this.createIndicators();
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

    public CircleIndicator2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mInternalOnScrollListener = new RecyclerView.OnScrollListener() { // from class: me.relex.circleindicator.CircleIndicator2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i2, int i22) {
                super.onScrolled(recyclerView, i2, i22);
                int snapPosition = CircleIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
                if (snapPosition == -1) {
                    return;
                }
                CircleIndicator2.this.animatePageSelected(snapPosition);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: me.relex.circleindicator.CircleIndicator2.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator2.this.mRecyclerView == null) {
                    return;
                }
                RecyclerView.Adapter adapter = CircleIndicator2.this.mRecyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == CircleIndicator2.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator2.this.mLastPosition < itemCount) {
                    CircleIndicator2 circleIndicator2 = CircleIndicator2.this;
                    circleIndicator2.mLastPosition = circleIndicator2.getSnapPosition(circleIndicator2.mRecyclerView.getLayoutManager());
                } else {
                    CircleIndicator2.this.mLastPosition = -1;
                }
                CircleIndicator2.this.createIndicators();
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

    public CircleIndicator2(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mInternalOnScrollListener = new RecyclerView.OnScrollListener() { // from class: me.relex.circleindicator.CircleIndicator2.1
            @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
            public void onScrolled(RecyclerView recyclerView, int i22, int i222) {
                super.onScrolled(recyclerView, i22, i222);
                int snapPosition = CircleIndicator2.this.getSnapPosition(recyclerView.getLayoutManager());
                if (snapPosition == -1) {
                    return;
                }
                CircleIndicator2.this.animatePageSelected(snapPosition);
            }
        };
        this.mAdapterDataObserver = new RecyclerView.AdapterDataObserver() { // from class: me.relex.circleindicator.CircleIndicator2.2
            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (CircleIndicator2.this.mRecyclerView == null) {
                    return;
                }
                RecyclerView.Adapter adapter = CircleIndicator2.this.mRecyclerView.getAdapter();
                int itemCount = adapter != null ? adapter.getItemCount() : 0;
                if (itemCount == CircleIndicator2.this.getChildCount()) {
                    return;
                }
                if (CircleIndicator2.this.mLastPosition < itemCount) {
                    CircleIndicator2 circleIndicator2 = CircleIndicator2.this;
                    circleIndicator2.mLastPosition = circleIndicator2.getSnapPosition(circleIndicator2.mRecyclerView.getLayoutManager());
                } else {
                    CircleIndicator2.this.mLastPosition = -1;
                }
                CircleIndicator2.this.createIndicators();
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

    public void attachToRecyclerView(RecyclerView recyclerView, SnapHelper snapHelper) {
        this.mRecyclerView = recyclerView;
        this.mSnapHelper = snapHelper;
        this.mLastPosition = -1;
        createIndicators();
        recyclerView.removeOnScrollListener(this.mInternalOnScrollListener);
        recyclerView.addOnScrollListener(this.mInternalOnScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createIndicators() {
        RecyclerView.Adapter adapter = this.mRecyclerView.getAdapter();
        createIndicators(adapter == null ? 0 : adapter.getItemCount(), getSnapPosition(this.mRecyclerView.getLayoutManager()));
    }

    public int getSnapPosition(RecyclerView.LayoutManager layoutManager) {
        View findSnapView;
        if (layoutManager == null || (findSnapView = this.mSnapHelper.findSnapView(layoutManager)) == null) {
            return -1;
        }
        return layoutManager.getPosition(findSnapView);
    }

    public RecyclerView.AdapterDataObserver getAdapterDataObserver() {
        return this.mAdapterDataObserver;
    }
}
