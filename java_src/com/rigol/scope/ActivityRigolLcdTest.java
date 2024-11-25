package com.rigol.scope;

import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
/* loaded from: classes.dex */
public class ActivityRigolLcdTest extends SelfTestActivity {
    private static final int[] COLORS = {SupportMenu.CATEGORY_MASK, -16711936, -1, ViewCompat.MEASURED_STATE_MASK, -16776961, -7829368, Color.rgb(128, 0, 0), Color.rgb(0, 0, 128), Color.rgb(64, 0, 0), Color.rgb(0, 64, 0), Color.rgb(0, 0, 64), Color.rgb(192, 0, 0), Color.rgb(0, 192, 0), Color.rgb(0, 0, 192), Color.rgb(0, 0, 0)};
    private TextView exitText;
    private TextView lcd_color;
    private TextView lcd_text;
    private int mColorIndex;
    private GestureDetector mDetector;
    private TextView tv_result;

    static /* synthetic */ int access$108(ActivityRigolLcdTest activityRigolLcdTest) {
        int i = activityRigolLcdTest.mColorIndex;
        activityRigolLcdTest.mColorIndex = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.activity_rigol_lcd_test);
        this.lcd_color = (TextView) findViewById(R.id.lcd_color);
        this.lcd_text = (TextView) findViewById(R.id.lcd_text);
        TextView textView = (TextView) findViewById(R.id.exitText);
        this.exitText = textView;
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.ActivityRigolLcdTest.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ActivityRigolLcdTest.this.finish();
            }
        });
        this.mDetector = new GestureDetector(this, new OnGestureListener());
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mDetector.onTouchEvent(motionEvent);
    }

    /* loaded from: classes.dex */
    private class OnGestureListener extends GestureDetector.SimpleOnGestureListener {
        private OnGestureListener() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            int access$108 = ActivityRigolLcdTest.access$108(ActivityRigolLcdTest.this) % (ActivityRigolLcdTest.COLORS.length + 1);
            if (access$108 == 2) {
                ActivityRigolLcdTest.this.lcd_color.setBackgroundColor(ActivityRigolLcdTest.COLORS[access$108]);
                ActivityRigolLcdTest.this.lcd_text.setTextColor(ViewCompat.MEASURED_STATE_MASK);
                TextView textView = ActivityRigolLcdTest.this.lcd_text;
                textView.setText(" (" + (access$108 + 1) + "/15)");
            } else if (access$108 != ActivityRigolLcdTest.COLORS.length) {
                ActivityRigolLcdTest.this.lcd_color.setBackgroundColor(ActivityRigolLcdTest.COLORS[access$108]);
                ActivityRigolLcdTest.this.lcd_text.setTextColor(-1);
                TextView textView2 = ActivityRigolLcdTest.this.lcd_text;
                textView2.setText(" (" + (access$108 + 1) + "/15)");
            } else {
                ActivityRigolLcdTest.this.finish();
            }
            return true;
        }
    }
}
