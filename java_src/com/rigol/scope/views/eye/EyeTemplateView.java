package com.rigol.scope.views.eye;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.views.window.WindowType;
/* loaded from: classes2.dex */
public class EyeTemplateView extends View {
    private Context mContext;
    private ServiceEnum.EyeTemplate mEyeTemplate;
    private Paint paint;

    public EyeTemplateView(Context context, ServiceEnum.EyeTemplate eyeTemplate) {
        super(context);
        this.mContext = context;
        this.mEyeTemplate = eyeTemplate;
        init(context);
    }

    public EyeTemplateView(Context context, ServiceEnum.EyeTemplate eyeTemplate, WindowType windowType, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mEyeTemplate = eyeTemplate;
        init(context);
    }

    private void init(Context context) {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-16776961);
        this.paint.setStrokeWidth(10.0f);
        this.paint.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        float UI_QueryInt32 = (float) (API.getInstance().UI_QueryInt32(API.getInstance().UI_QueryInt32(51, MessageID.MSG_EYE_SOURCE) + 0, MessageID.MSG_CHAN_SCALE_VALUE) * 4 * 1.0E-5d);
        int height = getHeight();
        int width = getWidth();
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$EyeTemplate[this.mEyeTemplate.ordinal()];
        if (i != 1) {
            if (i == 2) {
                Path path = new Path();
                path.moveTo(0.0f, 0.0f);
                float f = width;
                path.lineTo(f, 0.0f);
                float f2 = 2.0f * UI_QueryInt32;
                float f3 = height;
                float f4 = (((-1.95f) + UI_QueryInt32) / f2) * f3;
                path.lineTo(f, f4);
                path.lineTo(0.0f, f4);
                path.close();
                canvas.drawPath(path, this.paint);
                Path path2 = new Path();
                float f5 = ((0.1f + UI_QueryInt32) / f2) * f3;
                path2.moveTo(0.28562105f * f, f5);
                float f6 = 0.4397453f * f;
                float f7 = (((-1.15f) + UI_QueryInt32) / f2) * f3;
                path2.lineTo(f6, f7);
                float f8 = 0.5737471f * f;
                path2.lineTo(f8, f7);
                path2.lineTo(0.7143714f * f, f5);
                float f9 = ((1.35f + UI_QueryInt32) / f2) * f3;
                path2.lineTo(f8, f9);
                path2.lineTo(f6, f9);
                path2.close();
                canvas.drawPath(path2, this.paint);
                Path path3 = new Path();
                float f10 = ((UI_QueryInt32 + 1.95f) / f2) * f3;
                path3.moveTo(0.0f, f10);
                path3.lineTo(f, f10);
                path3.lineTo(f, f3);
                path3.lineTo(0.0f, f3);
                path3.close();
                canvas.drawPath(path3, this.paint);
                return;
            } else if (i == 3) {
                Path path4 = new Path();
                path4.moveTo(0.0f, 0.0f);
                float f11 = width;
                path4.lineTo(f11, 0.0f);
                float f12 = 2.0f * UI_QueryInt32;
                float f13 = height;
                float f14 = (((-2.8f) + UI_QueryInt32) / f12) * f13;
                path4.lineTo(f11, f14);
                path4.lineTo(0.0f, f14);
                path4.close();
                canvas.drawPath(path4, this.paint);
                Path path5 = new Path();
                float f15 = ((0.15f + UI_QueryInt32) / f12) * f13;
                path5.moveTo(0.3055022f * f11, f15);
                float f16 = 0.3805052f * f11;
                float f17 = (((-0.7f) + UI_QueryInt32) / f12) * f13;
                path5.lineTo(f16, f17);
                float f18 = 0.6794972f * f11;
                path5.lineTo(f18, f17);
                path5.lineTo(0.69449776f * f11, f15);
                float f19 = ((1.0f + UI_QueryInt32) / f12) * f13;
                path5.lineTo(f18, f19);
                path5.lineTo(f16, f19);
                path5.close();
                canvas.drawPath(path5, this.paint);
                Path path6 = new Path();
                float f20 = ((UI_QueryInt32 + 2.8f) / f12) * f13;
                path6.moveTo(0.0f, f20);
                path6.lineTo(f11, f20);
                path6.lineTo(f11, f13);
                path6.lineTo(0.0f, f13);
                path6.close();
                canvas.drawPath(path6, this.paint);
                return;
            } else if (i == 4) {
                Path path7 = new Path();
                path7.moveTo(0.0f, 0.0f);
                float f21 = width;
                path7.lineTo(f21, 0.0f);
                float f22 = 2.0f * UI_QueryInt32;
                float f23 = height;
                float f24 = (((-0.525f) + UI_QueryInt32) / f22) * f23;
                path7.lineTo(f21, f24);
                path7.lineTo(0.0f, f24);
                path7.close();
                canvas.drawPath(path7, this.paint);
                Path path8 = new Path();
                float f25 = (UI_QueryInt32 / f22) * f23;
                path8.moveTo(0.28749815f * f21, f25);
                float f26 = 0.43749803f * f21;
                float f27 = (((-0.225f) + UI_QueryInt32) / f22) * f23;
                path8.lineTo(f26, f27);
                float f28 = 0.5624996f * f21;
                path8.lineTo(f28, f27);
                path8.lineTo(0.7124994f * f21, f25);
                float f29 = ((0.225f + UI_QueryInt32) / f22) * f23;
                path8.lineTo(f28, f29);
                path8.lineTo(f26, f29);
                path8.close();
                canvas.drawPath(path8, this.paint);
                Path path9 = new Path();
                float f30 = ((UI_QueryInt32 + 0.525f) / f22) * f23;
                path9.moveTo(0.0f, f30);
                path9.lineTo(f21, f30);
                path9.lineTo(f21, f23);
                path9.lineTo(0.0f, f23);
                path9.close();
                canvas.drawPath(path9, this.paint);
                return;
            } else if (i != 5) {
                return;
            } else {
                Path path10 = new Path();
                path10.moveTo(0.0f, 0.0f);
                float f31 = width;
                path10.lineTo(f31, 0.0f);
                float f32 = 2.0f * UI_QueryInt32;
                float f33 = height;
                float f34 = (((-0.525f) + UI_QueryInt32) / f32) * f33;
                path10.lineTo(f31, f34);
                path10.lineTo(0.0f, f34);
                path10.close();
                canvas.drawPath(path10, this.paint);
                Path path11 = new Path();
                float f35 = (UI_QueryInt32 / f32) * f33;
                path11.moveTo(0.31249893f * f31, f35);
                float f36 = 0.42499882f * f31;
                float f37 = (((-0.35f) + UI_QueryInt32) / f32) * f33;
                path11.lineTo(f36, f37);
                float f38 = 0.5749988f * f31;
                path11.lineTo(f38, f37);
                path11.lineTo(0.6874986f * f31, f35);
                float f39 = ((0.35f + UI_QueryInt32) / f32) * f33;
                path11.lineTo(f38, f39);
                path11.lineTo(f36, f39);
                path11.close();
                canvas.drawPath(path11, this.paint);
                Path path12 = new Path();
                float f40 = ((UI_QueryInt32 + 0.525f) / f32) * f33;
                path12.moveTo(0.0f, f40);
                path12.lineTo(f31, f40);
                path12.lineTo(f31, f33);
                path12.lineTo(0.0f, f33);
                path12.close();
                canvas.drawPath(path12, this.paint);
                return;
            }
        }
        Path path13 = new Path();
        path13.moveTo(0.0f, 0.0f);
        float f41 = width;
        path13.lineTo(f41, 0.0f);
        float f42 = 2.0f * UI_QueryInt32;
        float f43 = height;
        float f44 = (((-1.1f) + UI_QueryInt32) / f42) * f43;
        path13.lineTo(f41, f44);
        path13.lineTo(0.0f, f44);
        path13.close();
        canvas.drawPath(path13, this.paint);
        Path path14 = new Path();
        float f45 = ((1.1f + UI_QueryInt32) / f42) * f43;
        path14.moveTo(0.0f, f45);
        path14.lineTo(f41, f45);
        path14.lineTo(f41, f43);
        path14.lineTo(0.0f, f43);
        path14.close();
        canvas.drawPath(path14, this.paint);
        Path path15 = new Path();
        float f46 = (((-0.9f) + UI_QueryInt32) / f42) * f43;
        path15.moveTo(0.0f, f46);
        float f47 = 0.05f * f41;
        path15.lineTo(f47, f46);
        float f48 = 0.2125f * f41;
        float f49 = (((-0.5f) + UI_QueryInt32) / f42) * f43;
        path15.lineTo(f48, f49);
        float f50 = (((-0.1f) + UI_QueryInt32) / f42) * f43;
        path15.lineTo(f47, f50);
        path15.lineTo(0.0f, f50);
        path15.close();
        canvas.drawPath(path15, this.paint);
        Path path16 = new Path();
        float f51 = ((0.1f + UI_QueryInt32) / f42) * f43;
        path16.moveTo(0.0f, f51);
        path16.lineTo(f47, f51);
        float f52 = ((0.5f + UI_QueryInt32) / f42) * f43;
        path16.lineTo(f48, f52);
        float f53 = ((0.9f + UI_QueryInt32) / f42) * f43;
        path16.lineTo(f47, f53);
        path16.lineTo(0.0f, f53);
        path16.close();
        canvas.drawPath(path16, this.paint);
        Path path17 = new Path();
        float f54 = 0.7875f * f41;
        path17.moveTo(f54, f49);
        float f55 = 0.95f * f41;
        path17.lineTo(f55, f46);
        path17.lineTo(f41, f46);
        path17.lineTo(f41, f50);
        path17.lineTo(f55, f50);
        path17.close();
        canvas.drawPath(path17, this.paint);
        Path path18 = new Path();
        path18.moveTo(f54, f52);
        path18.lineTo(f55, f51);
        path18.lineTo(f41, f51);
        path18.lineTo(f41, f53);
        path18.lineTo(f55, f53);
        path18.close();
        canvas.drawPath(path18, this.paint);
        Path path19 = new Path();
        float f56 = 0.1875f * f41;
        path19.moveTo(f56, f46);
        float f57 = 0.3125f * f41;
        path19.lineTo(f57, f46);
        float f58 = 0.25f * f41;
        float f59 = (((-0.7f) + UI_QueryInt32) / f42) * f43;
        path19.lineTo(f58, f59);
        path19.close();
        canvas.drawPath(path19, this.paint);
        Path path20 = new Path();
        float f60 = (((-0.3f) + UI_QueryInt32) / f42) * f43;
        path20.moveTo(f58, f60);
        path20.lineTo(f57, f50);
        path20.lineTo(f56, f50);
        path20.close();
        canvas.drawPath(path20, this.paint);
        Path path21 = new Path();
        float f61 = 0.6875f * f41;
        path21.moveTo(f61, f46);
        float f62 = 0.8125f * f41;
        path21.lineTo(f62, f46);
        float f63 = 0.75f * f41;
        path21.lineTo(f63, f59);
        path21.close();
        canvas.drawPath(path21, this.paint);
        Path path22 = new Path();
        path22.moveTo(f63, f60);
        path22.lineTo(f62, f50);
        path22.lineTo(f61, f50);
        path22.close();
        canvas.drawPath(path22, this.paint);
        Path path23 = new Path();
        path23.moveTo(f56, f51);
        path23.lineTo(f57, f51);
        float f64 = ((0.3f + UI_QueryInt32) / f42) * f43;
        path23.lineTo(f58, f64);
        path23.close();
        canvas.drawPath(path23, this.paint);
        Path path24 = new Path();
        float f65 = ((UI_QueryInt32 + 0.7f) / f42) * f43;
        path24.moveTo(f58, f65);
        path24.lineTo(f57, f53);
        path24.lineTo(f56, f53);
        path24.close();
        canvas.drawPath(path24, this.paint);
        Path path25 = new Path();
        path25.moveTo(f61, f51);
        path25.lineTo(f62, f51);
        path25.lineTo(f63, f64);
        path25.close();
        canvas.drawPath(path25, this.paint);
        Path path26 = new Path();
        path26.moveTo(f63, f65);
        path26.lineTo(f62, f53);
        path26.lineTo(f61, f53);
        path26.close();
        canvas.drawPath(path26, this.paint);
        Path path27 = new Path();
        float f66 = 0.2875f * f41;
        path27.moveTo(f66, f49);
        float f67 = 0.45f * f41;
        path27.lineTo(f67, f46);
        float f68 = 0.55f * f41;
        path27.lineTo(f68, f46);
        float f69 = 0.7125f * f41;
        path27.lineTo(f69, f49);
        path27.lineTo(f68, f50);
        path27.lineTo(f67, f50);
        path27.close();
        canvas.drawPath(path27, this.paint);
        Path path28 = new Path();
        path28.moveTo(f66, f52);
        path28.lineTo(f67, f51);
        path28.lineTo(f68, f51);
        path28.lineTo(f69, f52);
        path28.lineTo(f68, f53);
        path28.lineTo(f67, f53);
        path28.close();
        canvas.drawPath(path28, this.paint);
    }

    /* renamed from: com.rigol.scope.views.eye.EyeTemplateView$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$EyeTemplate;

        static {
            int[] iArr = new int[ServiceEnum.EyeTemplate.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$EyeTemplate = iArr;
            try {
                iArr[ServiceEnum.EyeTemplate.eth100.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$EyeTemplate[ServiceEnum.EyeTemplate.usbLow.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$EyeTemplate[ServiceEnum.EyeTemplate.usbFull.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$EyeTemplate[ServiceEnum.EyeTemplate.usbHighNear.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$EyeTemplate[ServiceEnum.EyeTemplate.usbHighFar.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }
}
