package com.rigol.scope.views.decoration;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.utilities.ContextUtil;
/* loaded from: classes2.dex */
public class BackgroundItemDecoration extends RecyclerView.ItemDecoration {
    private int itemHeight;
    private final Paint paint;

    public BackgroundItemDecoration() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.paint.setAntiAlias(true);
        this.paint.setColor(-3355444);
    }

    public void setItemHeight(int i) {
        this.itemHeight = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        if (this.itemHeight == 0) {
            return;
        }
        super.onDraw(canvas, recyclerView, state);
        int height = recyclerView.getHeight();
        int i = this.itemHeight;
        int i2 = height / i;
        int i3 = 0;
        int i4 = i + 0;
        while (i3 < i2) {
            if (i3 % 2 == 0) {
                this.paint.setColor(ContextUtil.getColor(R.color.silver));
            } else {
                this.paint.setColor(-1);
            }
            int i5 = this.itemHeight;
            int i6 = i3 * i5;
            i4 = i5 + i6;
            canvas.drawRect(0.0f, i6, recyclerView.getRight(), i4, this.paint);
            i3++;
        }
        if (i4 < recyclerView.getHeight()) {
            if (i3 % 2 == 0) {
                this.paint.setColor(ContextUtil.getColor(R.color.silver));
            } else {
                this.paint.setColor(-1);
            }
            canvas.drawRect(0.0f, i4, recyclerView.getRight(), recyclerView.getHeight(), this.paint);
        }
    }
}
