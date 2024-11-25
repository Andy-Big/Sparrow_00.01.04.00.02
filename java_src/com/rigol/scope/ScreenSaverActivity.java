package com.rigol.scope;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.view.animation.TranslateAnimation;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.bumptech.glide.Glide;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.databinding.ActivityScreenSaverBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.UtilityViewModel;
import java.io.File;
/* loaded from: classes.dex */
public class ScreenSaverActivity extends BaseActivity {
    private ActivityScreenSaverBinding binding;
    private UtilityParam utilityParam;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        getWindow().addFlags(1024);
        ActivityScreenSaverBinding inflate = ActivityScreenSaverBinding.inflate(getLayoutInflater());
        this.binding = inflate;
        setContentView(inflate.getRoot());
        UtilityViewModel utilityViewModel = (UtilityViewModel) ContextUtil.getAppViewModel(UtilityViewModel.class);
        if (utilityViewModel != null) {
            utilityViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$ScreenSaverActivity$vIwR3pWY8W5y5s-yNEtRfa7k_5w
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ScreenSaverActivity.this.lambda$onCreate$0$ScreenSaverActivity((UtilityParam) obj);
                }
            });
        }
        getWindow().addFlags(128);
    }

    public /* synthetic */ void lambda$onCreate$0$ScreenSaverActivity(UtilityParam utilityParam) {
        this.utilityParam = utilityParam;
        this.binding.setParam(utilityParam);
        Glide.with((FragmentActivity) this).load(new File(this.utilityParam.getScreenPicture())).error(ContextUtil.getDrawable(R.drawable.logo_r)).into(this.binding.mainAdBackground);
        startAnimation();
    }

    private void startAnimation() {
        UtilityParam utilityParam = this.utilityParam;
        if (utilityParam != null) {
            if (utilityParam.getScreenSelect() == ServiceEnum.UtilityScreenSaver.SCR_TEXT.value1) {
                initAnimation(this.binding.mainAdTextview);
            } else if (this.utilityParam.getScreenSelect() == ServiceEnum.UtilityScreenSaver.SCR_PICTURE.value1) {
                initAnimation(this.binding.mainAdBackground);
            }
        }
    }

    private void initAnimation(final View view) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        float f = i / 2;
        float f2 = i2;
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, f, 0.0f, f2);
        float f3 = i;
        float f4 = i2 / 2;
        final TranslateAnimation translateAnimation2 = new TranslateAnimation(f, f3, f2, f4);
        final TranslateAnimation translateAnimation3 = new TranslateAnimation(f3, f, f4, 0.0f);
        final TranslateAnimation translateAnimation4 = new TranslateAnimation(f, 0.0f, 0.0f, f4);
        final TranslateAnimation translateAnimation5 = new TranslateAnimation(0.0f, f, f4, f2);
        translateAnimation.setInterpolator(new BounceInterpolator());
        translateAnimation2.setInterpolator(new BounceInterpolator());
        translateAnimation3.setInterpolator(new BounceInterpolator());
        translateAnimation4.setInterpolator(new BounceInterpolator());
        translateAnimation5.setInterpolator(new BounceInterpolator());
        view.startAnimation(translateAnimation);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.rigol.scope.ScreenSaverActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                translateAnimation2.setDuration(15000L);
                view.startAnimation(translateAnimation2);
            }
        });
        translateAnimation2.setAnimationListener(new Animation.AnimationListener() { // from class: com.rigol.scope.ScreenSaverActivity.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                translateAnimation3.setDuration(15000L);
                view.startAnimation(translateAnimation3);
            }
        });
        translateAnimation3.setAnimationListener(new Animation.AnimationListener() { // from class: com.rigol.scope.ScreenSaverActivity.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                translateAnimation4.setDuration(15000L);
                view.startAnimation(translateAnimation4);
            }
        });
        translateAnimation4.setAnimationListener(new Animation.AnimationListener() { // from class: com.rigol.scope.ScreenSaverActivity.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                translateAnimation5.setDuration(15000L);
                view.startAnimation(translateAnimation5);
            }
        });
        translateAnimation5.setAnimationListener(new Animation.AnimationListener() { // from class: com.rigol.scope.ScreenSaverActivity.5
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                translateAnimation2.setDuration(15000L);
                view.startAnimation(translateAnimation2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.rigol.scope.BaseActivity, androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            finish();
        } else if (i == 3) {
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        finish();
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onSearchRequested() {
        finish();
        return super.onSearchRequested();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.rigol.scope.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }
}
