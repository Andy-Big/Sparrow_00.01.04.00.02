package com.rigol.scope.databinding;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import androidx.lifecycle.MutableLiveData;
import com.rigol.scope.R;
import com.rigol.scope.data.LeftStatusBarParam;
import com.rigol.scope.data.MenuParam;
import com.rigol.scope.views.waveview.AwgPlotView;

/* loaded from: classes2.dex */
public class FragmentContBindingImpl extends FragmentContBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.modeSpinner, 5);
        sViewsWithIds.put(R.id.trigButton, 6);
        sViewsWithIds.put(R.id.middleView, 7);
        sViewsWithIds.put(R.id.bottomView, 8);
        sViewsWithIds.put(R.id.switch1View, 9);
        sViewsWithIds.put(R.id.rigol1View, 10);
        sViewsWithIds.put(R.id.switch2View, 11);
        sViewsWithIds.put(R.id.rigol2View, 12);
        sViewsWithIds.put(R.id.switch3View, 13);
        sViewsWithIds.put(R.id.rigol3View, 14);
        sViewsWithIds.put(R.id.startPhaseText, 15);
        sViewsWithIds.put(R.id.startPhaseEdit, 16);
        sViewsWithIds.put(R.id.dutyCycleText, 17);
        sViewsWithIds.put(R.id.dutyCycleEdit, 18);
        sViewsWithIds.put(R.id.afgView, 19);
        sViewsWithIds.put(R.id.rowListView, 20);
    }

    public FragmentContBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 21, sIncludes, sViewsWithIds));
    }

    private FragmentContBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 4, (AwgPlotView) objArr[19], (View) objArr[1], (View) objArr[8], (TextView) objArr[2], (TextView) objArr[18], (TextView) objArr[17], (View) objArr[7], (TextView) objArr[5], (TextView) objArr[3], (AppCompatTextView) objArr[10], (AppCompatTextView) objArr[12], (AppCompatTextView) objArr[14], (AppCompatTextView) objArr[20], (TextView) objArr[16], (TextView) objArr[15], (AppCompatTextView) objArr[9], (AppCompatTextView) objArr[11], (AppCompatTextView) objArr[13], (TextView) objArr[6], (TextView) objArr[4]);
        this.mDirtyFlags = -1L;
        this.bgView.setTag(null);
        this.channelText.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.onText.setTag(null);
        this.waveformSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 64L;
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
        if (483 == i) {
            setLeftStatusBarParam((LeftStatusBarParam) obj);
        } else if (533 != i) {
            return false;
        } else {
            setMenuParam((MenuParam) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.FragmentContBinding
    public void setLeftStatusBarParam(LeftStatusBarParam leftStatusBarParam) {
        this.mLeftStatusBarParam = leftStatusBarParam;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(483);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.FragmentContBinding
    public void setMenuParam(MenuParam menuParam) {
        this.mMenuParam = menuParam;
        synchronized (this) {
            this.mDirtyFlags |= 32;
        }
        notifyPropertyChanged(533);
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
                    return onChangeMenuParamWaveform((MutableLiveData) obj, i2);
                }
                return onChangeLeftStatusBarParamColor((MutableLiveData) obj, i2);
            }
            return onChangeLeftStatusBarParamChannelEnable((MutableLiveData) obj, i2);
        }
        return onChangeLeftStatusBarParamSelectChanEnable((MutableLiveData) obj, i2);
    }

    private boolean onChangeLeftStatusBarParamSelectChanEnable(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeLeftStatusBarParamChannelEnable(MutableLiveData<Boolean> mutableLiveData, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeLeftStatusBarParamColor(MutableLiveData<Integer> mutableLiveData, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeMenuParamWaveform(MutableLiveData<String> mutableLiveData, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:131:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0150  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        String str;
        int i;
        int i2;
        Drawable drawable;
        int i3;
        int i4;
        int i5;
        int i6;
        Drawable drawable2;
        Context context;
        int i7;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        LeftStatusBarParam leftStatusBarParam = this.mLeftStatusBarParam;
        MenuParam menuParam = this.mMenuParam;
        if ((87 & j) != 0) {
            int i8 = ((j & 85) > 0L ? 1 : ((j & 85) == 0L ? 0 : -1));
            if (i8 != 0) {
                MutableLiveData<Boolean> selectChanEnable = leftStatusBarParam != null ? leftStatusBarParam.getSelectChanEnable() : null;
                updateLiveDataRegistration(0, selectChanEnable);
                z2 = ViewDataBinding.safeUnbox(selectChanEnable != null ? selectChanEnable.getValue() : null);
                if (i8 != 0) {
                    j = z2 ? j | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
            } else {
                z2 = false;
            }
            int i9 = ((j & 86) > 0L ? 1 : ((j & 86) == 0L ? 0 : -1));
            if (i9 != 0) {
                MutableLiveData<Boolean> channelEnable = leftStatusBarParam != null ? leftStatusBarParam.getChannelEnable() : null;
                updateLiveDataRegistration(1, channelEnable);
                z = ViewDataBinding.safeUnbox(channelEnable != null ? channelEnable.getValue() : null);
                if (i9 != 0) {
                    j = z ? j | 256 | PlaybackStateCompat.ACTION_PREPARE : j | 128 | PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                }
            } else {
                z = false;
            }
        } else {
            z = false;
            z2 = false;
        }
        if ((j & 104) != 0) {
            MutableLiveData<String> waveform = menuParam != null ? menuParam.getWaveform() : null;
            updateLiveDataRegistration(3, waveform);
            if (waveform != null) {
                str = waveform.getValue();
                if ((j & 82176) == 0) {
                    MutableLiveData<Integer> color = leftStatusBarParam != null ? leftStatusBarParam.getColor() : null;
                    updateLiveDataRegistration(2, color);
                    boolean z3 = ViewDataBinding.safeUnbox(color != null ? color.getValue() : null) == 0;
                    if ((j & 256) != 0) {
                        j |= z3 ? PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : 512L;
                    }
                    if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                        j |= z3 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                    }
                    if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                        j |= z3 ? PlaybackStateCompat.ACTION_SET_REPEAT_MODE : PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                    }
                    if ((256 & j) != 0) {
                        TextView textView = this.channelText;
                        i = z3 ? getColorFromResource(textView, R.color.bg_channel1_color) : getColorFromResource(textView, R.color.bg_channel2_color);
                    } else {
                        i = 0;
                    }
                    if ((j & PlaybackStateCompat.ACTION_PREPARE) != 0) {
                        i2 = z3 ? getColorFromResource(this.onText, R.color.bg_channel1_color) : getColorFromResource(this.onText, R.color.bg_channel2_color);
                    } else {
                        i2 = 0;
                    }
                    if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0) {
                        if (z3) {
                            context = this.bgView.getContext();
                            i7 = R.drawable.bg_yellow_line_menu;
                        } else {
                            context = this.bgView.getContext();
                            i7 = R.drawable.bg_green_line_menu;
                        }
                        drawable = AppCompatResources.getDrawable(context, i7);
                        i3 = ((86 & j) > 0L ? 1 : ((86 & j) == 0L ? 0 : -1));
                        if (i3 != 0) {
                            if (!z) {
                                i = getColorFromResource(this.channelText, R.color.popup_view_background);
                            }
                            if (!z) {
                                i2 = getColorFromResource(this.onText, R.color.popup_view_background);
                            }
                            i5 = i;
                            i4 = i2;
                        } else {
                            i4 = 0;
                            i5 = 0;
                        }
                        i6 = ((j & 85) > 0L ? 1 : ((j & 85) == 0L ? 0 : -1));
                        if (i6 != 0) {
                            if (!z2) {
                                drawable = AppCompatResources.getDrawable(this.bgView.getContext(), R.drawable.bg_black_menu);
                            }
                            drawable2 = drawable;
                        } else {
                            drawable2 = null;
                        }
                        if (i6 != 0) {
                            ViewBindingAdapter.setBackground(this.bgView, drawable2);
                        }
                        if (i3 != 0) {
                            this.channelText.setTextColor(i5);
                            this.onText.setTextColor(i4);
                        }
                        if ((j & 104) != 0) {
                            TextViewBindingAdapter.setText(this.waveformSpinner, str);
                            return;
                        }
                        return;
                    }
                } else {
                    i = 0;
                    i2 = 0;
                }
                drawable = null;
                i3 = ((86 & j) > 0L ? 1 : ((86 & j) == 0L ? 0 : -1));
                if (i3 != 0) {
                }
                i6 = ((j & 85) > 0L ? 1 : ((j & 85) == 0L ? 0 : -1));
                if (i6 != 0) {
                }
                if (i6 != 0) {
                }
                if (i3 != 0) {
                }
                if ((j & 104) != 0) {
                }
            }
        }
        str = null;
        if ((j & 82176) == 0) {
        }
        drawable = null;
        i3 = ((86 & j) > 0L ? 1 : ((86 & j) == 0L ? 0 : -1));
        if (i3 != 0) {
        }
        i6 = ((j & 85) > 0L ? 1 : ((j & 85) == 0L ? 0 : -1));
        if (i6 != 0) {
        }
        if (i6 != 0) {
        }
        if (i3 != 0) {
        }
        if ((j & 104) != 0) {
        }
    }
}
