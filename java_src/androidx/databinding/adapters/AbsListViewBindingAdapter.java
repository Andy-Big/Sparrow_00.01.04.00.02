package androidx.databinding.adapters;

import android.widget.AbsListView;
/* loaded from: classes.dex */
public class AbsListViewBindingAdapter {

    /* loaded from: classes.dex */
    public interface OnScroll {
        void onScroll(AbsListView absListView, int i, int i2, int i3);
    }

    /* loaded from: classes.dex */
    public interface OnScrollStateChanged {
        void onScrollStateChanged(AbsListView absListView, int i);
    }

    public static void setOnScroll(AbsListView absListView, final OnScroll onScroll, final OnScrollStateChanged onScrollStateChanged) {
        absListView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: androidx.databinding.adapters.AbsListViewBindingAdapter.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView2, int i) {
                OnScrollStateChanged onScrollStateChanged2 = OnScrollStateChanged.this;
                if (onScrollStateChanged2 != null) {
                    onScrollStateChanged2.onScrollStateChanged(absListView2, i);
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView2, int i, int i2, int i3) {
                OnScroll onScroll2 = onScroll;
                if (onScroll2 != null) {
                    onScroll2.onScroll(absListView2, i, i2, i3);
                }
            }
        });
    }
}
