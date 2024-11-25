package com.rigol.scope.data;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import com.blankj.utilcode.util.SPUtils;
import kotlin.Metadata;
/* compiled from: MotorParam.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0010\u001a\u00020\u0011R&\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR&\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048G@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/rigol/scope/data/MotorParam;", "Landroidx/databinding/BaseObservable;", "()V", "value", "", "angle1", "getAngle1", "()I", "setAngle1", "(I)V", "angle2", "getAngle2", "setAngle2", "angle3", "getAngle3", "setAngle3", "readAll", "", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class MotorParam extends BaseObservable {
    private int angle1 = -1;
    private int angle2 = -1;
    private int angle3 = -1;

    @Bindable
    public final int getAngle1() {
        return this.angle1;
    }

    public final void setAngle1(int i) {
        this.angle1 = i;
        notifyPropertyChanged(46);
    }

    @Bindable
    public final int getAngle2() {
        return this.angle2;
    }

    public final void setAngle2(int i) {
        this.angle2 = i;
        notifyPropertyChanged(47);
    }

    @Bindable
    public final int getAngle3() {
        return this.angle3;
    }

    public final void setAngle3(int i) {
        this.angle3 = i;
        notifyPropertyChanged(48);
    }

    public final void readAll() {
        setAngle1(SPUtils.getInstance().getInt("angle1", -1));
        setAngle2(SPUtils.getInstance().getInt("angle2", -1));
        setAngle3(SPUtils.getInstance().getInt("angle3", -1));
    }
}
