package com.rigol.scope.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.UtilityParam;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.NumberProgressBar;
/* loaded from: classes2.dex */
public class PopupviewLaCalibrationBindingImpl extends PopupviewLaCalibrationBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title, 3);
        sViewsWithIds.put(R.id.guideline_left, 4);
        sViewsWithIds.put(R.id.guideline_center, 5);
        sViewsWithIds.put(R.id.notice, 6);
        sViewsWithIds.put(R.id.last_time, 7);
        sViewsWithIds.put(R.id.last_time_content, 8);
        sViewsWithIds.put(R.id.result, 9);
        sViewsWithIds.put(R.id.progress, 10);
        sViewsWithIds.put(R.id.detail, 11);
        sViewsWithIds.put(R.id.detail_arrow, 12);
        sViewsWithIds.put(R.id.detail_scroll, 13);
        sViewsWithIds.put(R.id.detail_content, 14);
        sViewsWithIds.put(R.id.dividing_line, 15);
        sViewsWithIds.put(R.id.start_or_stop, 16);
        sViewsWithIds.put(R.id.close, 17);
    }

    public PopupviewLaCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 18, sIncludes, sViewsWithIds));
    }

    private PopupviewLaCalibrationBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (Button) objArr[17], (TextView) objArr[11], (ImageView) objArr[12], (TextView) objArr[14], (ScrollView) objArr[13], (View) objArr[15], (Guideline) objArr[5], (Guideline) objArr[4], (TextView) objArr[7], (TextView) objArr[8], (TextView) objArr[6], (TextView) objArr[1], (ConstraintLayout) objArr[0], (NumberProgressBar) objArr[10], (TextView) objArr[9], (TextView) objArr[2], (Button) objArr[16], (TextView) objArr[3]);
        this.mDirtyFlags = -1L;
        this.noticeContent.setTag(null);
        this.popup.setTag(null);
        this.resultContent.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 256L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (569 == i) {
            setOnClickListener((View.OnClickListener) obj);
        } else if (1013 == i) {
            setUtilityParam((UtilityParam) obj);
        } else if (449 == i) {
            setIsProbe((ObservableBoolean) obj);
        } else if (454 != i) {
            return false;
        } else {
            setLaParam((LaParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.PopupviewLaCalibrationBinding
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }

    @Override // com.rigol.scope.databinding.PopupviewLaCalibrationBinding
    public void setUtilityParam(UtilityParam utilityParam) {
        this.mUtilityParam = utilityParam;
    }

    @Override // com.rigol.scope.databinding.PopupviewLaCalibrationBinding
    public void setIsProbe(ObservableBoolean observableBoolean) {
        this.mIsProbe = observableBoolean;
    }

    @Override // com.rigol.scope.databinding.PopupviewLaCalibrationBinding
    public void setLaParam(LaParam laParam) {
        updateRegistration(2, laParam);
        this.mLaParam = laParam;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(454);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaCalStatusLaParamLaProbeCalPro((MappingObject) obj, i2);
                }
                return onChangeLaParam((LaParam) obj, i2);
            }
            return onChangeIsProbe((ObservableBoolean) obj, i2);
        }
        return onChangeUtilityParam((UtilityParam) obj, i2);
    }

    private boolean onChangeUtilityParam(UtilityParam utilityParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeIsProbe(ObservableBoolean observableBoolean, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeLaParam(LaParam laParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 468) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 469) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgLaCalStatusLaParamLaProbeCalPro(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LaParam laParam = this.mLaParam;
        String str2 = null;
        if ((492 & j) != 0) {
            if ((j & 460) != 0) {
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_la_cal_status, laParam != null ? laParam.getLa_probe_cal_pro() : 0);
                updateRegistration(3, mappingObject);
                if (mappingObject != null) {
                    str = mappingObject.getStr();
                    if ((j & 292) != 0 && laParam != null) {
                        str2 = laParam.getLa_probe_cal_data();
                    }
                }
            }
            str = null;
            if ((j & 292) != 0) {
                str2 = laParam.getLa_probe_cal_data();
            }
        } else {
            str = null;
        }
        if ((j & 292) != 0) {
            TextViewBindingAdapter.setText(this.noticeContent, str2);
        }
        if ((j & 460) != 0) {
            TextViewBindingAdapter.setText(this.resultContent, str);
        }
    }
}
