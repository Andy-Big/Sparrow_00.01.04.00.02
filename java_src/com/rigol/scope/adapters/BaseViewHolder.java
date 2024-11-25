package com.rigol.scope.adapters;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
/* loaded from: classes.dex */
public class BaseViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener, View.OnTouchListener {
    private final T binding;
    private GestureDetector gestureDetector;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public BaseViewHolder(T t) {
        super(t.getRoot());
        this.binding = t;
        this.itemView.setOnClickListener(this);
        this.itemView.setOnLongClickListener(this);
        this.itemView.setOnTouchListener(this);
    }

    public T getBinding() {
        return this.binding;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int bindingAdapterPosition = getBindingAdapterPosition();
        OnItemClickListener onItemClickListener = this.onItemClickListener;
        if (onItemClickListener == null || bindingAdapterPosition < 0) {
            return;
        }
        onItemClickListener.onItemClick(view, this, bindingAdapterPosition);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        int bindingAdapterPosition = getBindingAdapterPosition();
        OnItemLongClickListener onItemLongClickListener = this.onItemLongClickListener;
        if (onItemLongClickListener != null) {
            return onItemLongClickListener.onItemLongClick(view, this, bindingAdapterPosition);
        }
        return false;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnGestureListener(final OnItemGestureDetectorListener onItemGestureDetectorListener) {
        if (onItemGestureDetectorListener != null) {
            this.gestureDetector = new GestureDetector(getBinding().getRoot().getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.rigol.scope.adapters.BaseViewHolder.1
                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onDown(MotionEvent motionEvent) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    return onItemGestureDetectorListener2.onDown(motionEvent, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onShowPress(MotionEvent motionEvent) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    onItemGestureDetectorListener2.onShowPress(motionEvent, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTap(MotionEvent motionEvent) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    return onItemGestureDetectorListener2.onDoubleTap(motionEvent, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    return onItemGestureDetectorListener2.onSingleTapUp(motionEvent, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    return onItemGestureDetectorListener2.onSingleTapConfirmed(motionEvent, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public void onLongPress(MotionEvent motionEvent) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    onItemGestureDetectorListener2.onLongPress(motionEvent, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    return onItemGestureDetectorListener2.onScroll(motionEvent, motionEvent2, f, f2, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnContextClickListener
                public boolean onContextClick(MotionEvent motionEvent) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    return onItemGestureDetectorListener2.onContextClick(motionEvent, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
                public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    return onItemGestureDetectorListener2.onDoubleTapEvent(motionEvent, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }

                @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
                public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                    OnItemGestureDetectorListener onItemGestureDetectorListener2 = onItemGestureDetectorListener;
                    View view = BaseViewHolder.this.itemView;
                    BaseViewHolder baseViewHolder = BaseViewHolder.this;
                    return onItemGestureDetectorListener2.onFling(motionEvent, motionEvent2, f, f2, view, baseViewHolder, baseViewHolder.getBindingAdapterPosition());
                }
            });
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.gestureDetector != null) {
            handleItemState(motionEvent);
            return this.gestureDetector.onTouchEvent(motionEvent);
        }
        return false;
    }

    private void handleItemState(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.itemView.setPressed(true);
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.itemView.setPressed(false);
        }
    }
}
