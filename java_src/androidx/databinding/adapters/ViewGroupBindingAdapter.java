package androidx.databinding.adapters;

import android.animation.LayoutTransition;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
/* loaded from: classes.dex */
public class ViewGroupBindingAdapter {

    /* loaded from: classes.dex */
    public interface OnAnimationEnd {
        void onAnimationEnd(Animation animation);
    }

    /* loaded from: classes.dex */
    public interface OnAnimationRepeat {
        void onAnimationRepeat(Animation animation);
    }

    /* loaded from: classes.dex */
    public interface OnAnimationStart {
        void onAnimationStart(Animation animation);
    }

    /* loaded from: classes.dex */
    public interface OnChildViewAdded {
        void onChildViewAdded(View view, View view2);
    }

    /* loaded from: classes.dex */
    public interface OnChildViewRemoved {
        void onChildViewRemoved(View view, View view2);
    }

    public static void setAnimateLayoutChanges(ViewGroup viewGroup, boolean z) {
        if (z) {
            viewGroup.setLayoutTransition(new LayoutTransition());
        } else {
            viewGroup.setLayoutTransition(null);
        }
    }

    public static void setListener(ViewGroup viewGroup, final OnChildViewAdded onChildViewAdded, final OnChildViewRemoved onChildViewRemoved) {
        if (onChildViewAdded == null && onChildViewRemoved == null) {
            viewGroup.setOnHierarchyChangeListener(null);
        } else {
            viewGroup.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() { // from class: androidx.databinding.adapters.ViewGroupBindingAdapter.1
                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewAdded(View view, View view2) {
                    OnChildViewAdded onChildViewAdded2 = OnChildViewAdded.this;
                    if (onChildViewAdded2 != null) {
                        onChildViewAdded2.onChildViewAdded(view, view2);
                    }
                }

                @Override // android.view.ViewGroup.OnHierarchyChangeListener
                public void onChildViewRemoved(View view, View view2) {
                    OnChildViewRemoved onChildViewRemoved2 = onChildViewRemoved;
                    if (onChildViewRemoved2 != null) {
                        onChildViewRemoved2.onChildViewRemoved(view, view2);
                    }
                }
            });
        }
    }

    public static void setListener(ViewGroup viewGroup, final OnAnimationStart onAnimationStart, final OnAnimationEnd onAnimationEnd, final OnAnimationRepeat onAnimationRepeat) {
        if (onAnimationStart == null && onAnimationEnd == null && onAnimationRepeat == null) {
            viewGroup.setLayoutAnimationListener(null);
        } else {
            viewGroup.setLayoutAnimationListener(new Animation.AnimationListener() { // from class: androidx.databinding.adapters.ViewGroupBindingAdapter.2
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    OnAnimationStart onAnimationStart2 = OnAnimationStart.this;
                    if (onAnimationStart2 != null) {
                        onAnimationStart2.onAnimationStart(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    OnAnimationEnd onAnimationEnd2 = onAnimationEnd;
                    if (onAnimationEnd2 != null) {
                        onAnimationEnd2.onAnimationEnd(animation);
                    }
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                    OnAnimationRepeat onAnimationRepeat2 = onAnimationRepeat;
                    if (onAnimationRepeat2 != null) {
                        onAnimationRepeat2.onAnimationRepeat(animation);
                    }
                }
            });
        }
    }
}
