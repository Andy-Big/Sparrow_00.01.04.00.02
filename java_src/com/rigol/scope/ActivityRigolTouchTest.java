package com.rigol.scope;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.chrisbanes.photoview.OnScaleChangedListener;
import com.github.chrisbanes.photoview.PhotoViewAttacher;
import com.rigol.scope.utilities.KeyCodeUtil;
import com.rigol.scope.views.selfCheck.SelfCheckBorderTouchViewNew;
import com.rigol.scope.views.selfCheck.SelfCheckOnTouchChangedListener;
import com.rigol.scope.views.selfCheck.SelfCheckPointCircleView;
import com.rigol.scope.views.selfCheck.SelfCheckPointView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ActivityRigolTouchTest extends AppCompatActivity implements SelfCheckOnTouchChangedListener {
    private TextView exitText;
    private ImageView imageView;
    private ArrayList<SelfCheckPointView> list = new ArrayList<>();
    private SelfCheckBorderTouchViewNew mBorderView;
    private SelfCheckPointCircleView mSelfCheckPointCircleView;
    private RelativeLayout root;
    protected int runStopClickCount;
    private TextView touch_text;
    private TextView touch_text_next;
    private TextView tv_information;
    private TextView tv_pinch;
    private TextView tv_pointCount;
    private TextView tv_scaleValue;
    private TextView tv_stretch;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_rigol_touch_test);
        this.root = (RelativeLayout) findViewById(R.id.rela_container);
        SelfCheckBorderTouchViewNew selfCheckBorderTouchViewNew = (SelfCheckBorderTouchViewNew) findViewById(R.id.touch_border);
        this.mBorderView = selfCheckBorderTouchViewNew;
        selfCheckBorderTouchViewNew.setOnTouchChangedListener(this);
        this.mBorderView.setVisibility(0);
        TextView textView = (TextView) findViewById(R.id.touch_test);
        this.touch_text = textView;
        textView.setVisibility(0);
        TextView textView2 = (TextView) findViewById(R.id.touch_test_next);
        this.touch_text_next = textView2;
        textView2.setVisibility(8);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        this.imageView = imageView;
        imageView.setVisibility(8);
        TextView textView3 = (TextView) findViewById(R.id.tv_ScaleValue);
        this.tv_scaleValue = textView3;
        textView3.setText("25%");
        this.tv_scaleValue.setVisibility(8);
        TextView textView4 = (TextView) findViewById(R.id.tv_PointerCount);
        this.tv_pointCount = textView4;
        textView4.setText("0points");
        this.tv_pointCount.setVisibility(8);
        TextView textView5 = (TextView) findViewById(R.id.Informatica);
        this.tv_information = textView5;
        textView5.setVisibility(8);
        TextView textView6 = (TextView) findViewById(R.id.pinch);
        this.tv_pinch = textView6;
        textView6.setVisibility(8);
        this.tv_stretch = (TextView) findViewById(R.id.stretch);
        this.exitText = (TextView) findViewById(R.id.exitText);
        this.tv_stretch.setVisibility(8);
        final PhotoViewAttacher photoViewAttacher = new PhotoViewAttacher(this.imageView);
        photoViewAttacher.setMinimumScale(0.25f);
        photoViewAttacher.setMaximumScale(5.0f);
        SelfCheckPointCircleView selfCheckPointCircleView = new SelfCheckPointCircleView(this);
        this.mSelfCheckPointCircleView = selfCheckPointCircleView;
        this.root.addView(selfCheckPointCircleView);
        this.mSelfCheckPointCircleView.setVisibility(8);
        photoViewAttacher.setOnScaleChangeListener(new OnScaleChangedListener() { // from class: com.rigol.scope.-$$Lambda$ActivityRigolTouchTest$pIWrH-e-5NylRSod2TeT2OBCahA
            @Override // com.github.chrisbanes.photoview.OnScaleChangedListener
            public final void onScaleChange(float f, float f2, float f3) {
                ActivityRigolTouchTest.this.lambda$onCreate$0$ActivityRigolTouchTest(photoViewAttacher, f, f2, f3);
            }
        });
        this.exitText.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.ActivityRigolTouchTest.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityRigolTouchTest.this.finish();
            }
        });
        this.imageView.setOnTouchListener(new View.OnTouchListener() { // from class: com.rigol.scope.-$$Lambda$ActivityRigolTouchTest$w6zjokbve1vv_BvIqStge7NhBGw
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ActivityRigolTouchTest.this.lambda$onCreate$1$ActivityRigolTouchTest(photoViewAttacher, view, motionEvent);
            }
        });
    }

    public /* synthetic */ void lambda$onCreate$0$ActivityRigolTouchTest(PhotoViewAttacher photoViewAttacher, float f, float f2, float f3) {
        double scale = photoViewAttacher.getScale();
        if (scale <= 0.25d || scale >= 5.0d) {
            return;
        }
        String[] split = String.valueOf(scale * 100.0d).split("\\.");
        this.tv_scaleValue.setText(split[0] + "%");
    }

    public /* synthetic */ boolean lambda$onCreate$1$ActivityRigolTouchTest(PhotoViewAttacher photoViewAttacher, View view, MotionEvent motionEvent) {
        TextView textView = this.tv_pointCount;
        textView.setText(motionEvent.getPointerCount() + " points");
        if (motionEvent.getAction() == 1) {
            this.tv_pointCount.setText(" 0 points");
        }
        photoViewAttacher.onTouch(view, motionEvent);
        int action = motionEvent.getAction();
        int pointerCount = motionEvent.getPointerCount();
        int i = 0;
        while (i < pointerCount) {
            float x = motionEvent.getX(i);
            float y = motionEvent.getY(i);
            SelfCheckPointView selfCheckPointView = this.list.size() > i ? this.list.get(i) : null;
            if (selfCheckPointView == null) {
                SelfCheckPointView selfCheckPointView2 = new SelfCheckPointView();
                selfCheckPointView2.setX(x);
                selfCheckPointView2.setY(y);
                this.list.add(selfCheckPointView2);
            } else {
                selfCheckPointView.setX(x);
                selfCheckPointView.setY(y);
            }
            i++;
        }
        if (this.list.size() > pointerCount) {
            while (pointerCount < this.list.size()) {
                this.list.remove(pointerCount);
                pointerCount++;
            }
        }
        if (action == 1) {
            this.list.clear();
        }
        this.mSelfCheckPointCircleView.list = this.list;
        this.mSelfCheckPointCircleView.invalidate();
        return true;
    }

    @Override // com.rigol.scope.views.selfCheck.SelfCheckOnTouchChangedListener
    public void onTouchFinish(View view) {
        SelfCheckBorderTouchViewNew selfCheckBorderTouchViewNew = this.mBorderView;
        if (view == selfCheckBorderTouchViewNew) {
            selfCheckBorderTouchViewNew.setVisibility(8);
            this.imageView.setVisibility(0);
            this.tv_pointCount.setVisibility(0);
            this.tv_scaleValue.setVisibility(0);
            this.tv_information.setVisibility(0);
            this.tv_pinch.setVisibility(0);
            this.tv_stretch.setVisibility(0);
            this.mSelfCheckPointCircleView.setVisibility(0);
            this.touch_text.setVisibility(8);
            this.touch_text_next.setVisibility(8);
        } else if (view == this.imageView) {
            finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        int panelKey = KeyCodeUtil.getPanelKey(i);
        if (panelKey == 12) {
            int i2 = this.runStopClickCount + 1;
            this.runStopClickCount = i2;
            if (i2 == 3) {
                finish();
            }
        } else if (panelKey == 82) {
            onTouchFinish(this.mBorderView);
        } else {
            this.runStopClickCount = 0;
        }
        return super.onKeyUp(i, keyEvent);
    }
}
