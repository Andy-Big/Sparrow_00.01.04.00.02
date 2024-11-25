package com.rigol.scope.views.selfCheck;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.InputDeviceCompat;
import com.rigol.scope.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class SelfCheckPointCircleView extends View {
    public List<SelfCheckPointView> list;
    private float radius;
    private String touchInfo;
    private Paint touchPaint;

    public SelfCheckPointCircleView(Context context) {
        super(context);
        this.list = new ArrayList();
    }

    public SelfCheckPointCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.list = new ArrayList();
    }

    public SelfCheckPointCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.list = new ArrayList();
    }

    public SelfCheckPointCircleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.list = new ArrayList();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        this.touchPaint = paint;
        paint.setTextSize(15.0f);
        this.touchPaint.setColor(-1);
        this.touchInfo = getContext().getString(R.string.screen_multi_touch_info);
        this.radius = dip2px(getContext(), 30.0f);
        for (int i = 0; i < this.list.size(); i++) {
            SelfCheckPointView selfCheckPointView = this.list.get(i);
            if (selfCheckPointView != null) {
                float dip2px = dip2px(getContext(), 50.0f) + (this.touchPaint.getTextSize() * i);
                int i2 = i % 5;
                int i3 = SupportMenu.CATEGORY_MASK;
                if (i2 != 0) {
                    if (i2 == 1) {
                        i3 = -16711936;
                    } else if (i2 == 2) {
                        i3 = -16776961;
                    } else if (i2 == 3) {
                        i3 = InputDeviceCompat.SOURCE_ANY;
                    } else if (i2 == 4) {
                        i3 = -1;
                    }
                }
                float x = selfCheckPointView.getX();
                float y = selfCheckPointView.getY();
                this.touchPaint.setColor(i3);
                canvas.drawLine(x, 0.0f, x, getHeight(), this.touchPaint);
                canvas.drawLine(0.0f, y, getWidth(), y, this.touchPaint);
                int i4 = (int) x;
                int i5 = (int) y;
                canvas.drawCircle(i4, i5, this.radius, this.touchPaint);
                canvas.drawText(String.format(this.touchInfo, Integer.valueOf(i + 1), Integer.valueOf(i4), Integer.valueOf(i5)), dip2px(getContext(), 8.0f) + 0.0f, dip2px, this.touchPaint);
            }
        }
    }

    private float dip2px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().density) + 0.5f;
    }
}
