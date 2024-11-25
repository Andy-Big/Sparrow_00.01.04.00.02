package com.rigol.scope.views.presentation;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.SPUtils;
import com.rigol.scope.data.MotorParam;
import com.rigol.scope.databinding.PresentationMotorBinding;
import com.rigol.scope.utilities.MotorManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.VibrationTouchListener;
import com.rigol.scope.views.baseview.BasePresentation;
import com.rigol.scope.views.baseview.FanScaleView;
import timber.log.Timber;
/* loaded from: classes2.dex */
public class MotorPresentation extends BasePresentation {
    final int defalutFilpPosition;
    private FanScaleView fanScaleView;
    public boolean isScreenPresentationReady;
    public PresentationMotorBinding mBinding;
    private View.OnTouchListener onTouchListener;
    private final MotorParam param;

    public MotorPresentation(Context context, Display display) {
        super(context, display);
        this.defalutFilpPosition = 0;
        this.isScreenPresentationReady = true;
        this.onTouchListener = new VibrationTouchListener();
        this.param = new MotorParam();
        this.mBinding = PresentationMotorBinding.inflate(LayoutInflater.from(context));
        this.param.readAll();
        this.mBinding.setParam(this.param);
        setContentView(this.mBinding.getRoot());
        this.fanScaleView = this.mBinding.fanScaleView;
        this.mBinding.btnAngleFirst.setOnTouchListener(this.onTouchListener);
        this.mBinding.btnAngleSecond.setOnTouchListener(this.onTouchListener);
        this.mBinding.btnAngleThird.setOnTouchListener(this.onTouchListener);
        this.mBinding.fanScaleView.setOnTouchListener(this.onTouchListener);
        this.mBinding.btnHide.setOnTouchListener(this.onTouchListener);
        this.mBinding.btnAngleFirst.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MotorPresentation$_437xfvpve4b0HiArnaKgS6oY6I
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MotorPresentation.this.lambda$new$0$MotorPresentation(view);
            }
        });
        this.mBinding.btnAngleFirst.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MotorPresentation$sj_6Ey2yLnYbAoCIWccStbRiGHI
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return MotorPresentation.this.lambda$new$1$MotorPresentation(view);
            }
        });
        this.mBinding.btnAngleSecond.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MotorPresentation$JMdsFAJt53VwISY7paZtWveuUZc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MotorPresentation.this.lambda$new$2$MotorPresentation(view);
            }
        });
        this.mBinding.btnAngleSecond.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MotorPresentation$d1B1MePDefAyTElsDRSbOfFJyo4
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return MotorPresentation.this.lambda$new$3$MotorPresentation(view);
            }
        });
        this.mBinding.btnAngleThird.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MotorPresentation$pf5qQTLibEtm3yJUuhtVBFr6qGg
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MotorPresentation.this.lambda$new$4$MotorPresentation(view);
            }
        });
        this.mBinding.btnAngleThird.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MotorPresentation$PIlAI_YpS13bcZ0L1NMjAbUM3WA
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return MotorPresentation.this.lambda$new$5$MotorPresentation(view);
            }
        });
        this.mBinding.btnHide.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.presentation.-$$Lambda$MotorPresentation$fJlGV5FXNK-0ctzJbHfyBAMQck0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MotorPresentation.this.lambda$new$6$MotorPresentation(view);
            }
        });
        ViewUtil.setTouchDelegate(this.mBinding.btnHide, (ViewGroup) this.mBinding.btnHide.getParent(), 20);
    }

    public /* synthetic */ void lambda$new$0$MotorPresentation(View view) {
        CharSequence text = this.mBinding.btnAngleFirst.getText();
        if (text == null || text.toString().length() <= 0 || text.toString().indexOf("%") == -1) {
            return;
        }
        this.fanScaleView.setNotifyToRefreshAngleType(FanScaleView.NotifyToRefreshAngleTypeEnum.SETTING_BUTTON_CLICKED);
        MotorManager.getInstance().setPosition(Integer.valueOf(text.toString().replace("%", "")).intValue());
    }

    public /* synthetic */ boolean lambda$new$1$MotorPresentation(View view) {
        this.param.setAngle1(this.fanScaleView.getPercentage());
        SPUtils.getInstance().put("angle1", this.fanScaleView.getPercentage());
        return true;
    }

    public /* synthetic */ void lambda$new$2$MotorPresentation(View view) {
        CharSequence text = this.mBinding.btnAngleSecond.getText();
        if (text == null || text.toString().length() <= 0 || text.toString().indexOf("%") == -1) {
            return;
        }
        this.fanScaleView.setNotifyToRefreshAngleType(FanScaleView.NotifyToRefreshAngleTypeEnum.SETTING_BUTTON_CLICKED);
        MotorManager.getInstance().setPosition(Integer.valueOf(text.toString().replace("%", "")).intValue());
    }

    public /* synthetic */ boolean lambda$new$3$MotorPresentation(View view) {
        this.param.setAngle2(this.fanScaleView.getPercentage());
        SPUtils.getInstance().put("angle2", this.fanScaleView.getPercentage());
        return true;
    }

    public /* synthetic */ void lambda$new$4$MotorPresentation(View view) {
        CharSequence text = this.mBinding.btnAngleThird.getText();
        if (text == null || text.toString().length() <= 0 || text.toString().indexOf("%") == -1) {
            return;
        }
        this.fanScaleView.setNotifyToRefreshAngleType(FanScaleView.NotifyToRefreshAngleTypeEnum.SETTING_BUTTON_CLICKED);
        MotorManager.getInstance().setPosition(Integer.valueOf(text.toString().replace("%", "")).intValue());
    }

    public /* synthetic */ boolean lambda$new$5$MotorPresentation(View view) {
        this.param.setAngle3(this.fanScaleView.getPercentage());
        SPUtils.getInstance().put("angle3", this.fanScaleView.getPercentage());
        return true;
    }

    public /* synthetic */ void lambda$new$6$MotorPresentation(View view) {
        dismiss();
    }

    public void refreshFanByFilpAngle(int i) {
        this.fanScaleView.refreshFanByInputAngle(i);
        Timber.d("curAnglePercentage:%s", Integer.valueOf(i));
    }

    public void notifyMotorResetToDefalut() {
        this.fanScaleView.setNotifyToRefreshAngleType(FanScaleView.NotifyToRefreshAngleTypeEnum.PHYSIAL_BUTTON_CLICKED);
    }

    public void notifyMotorRotateForward() {
        this.fanScaleView.setNotifyToRefreshAngleType(FanScaleView.NotifyToRefreshAngleTypeEnum.PHYSIAL_KNOB_DRIVED);
    }

    public void notifyMotorRotateReversal() {
        this.fanScaleView.setNotifyToRefreshAngleType(FanScaleView.NotifyToRefreshAngleTypeEnum.PHYSIAL_KNOB_DRIVED);
    }
}
