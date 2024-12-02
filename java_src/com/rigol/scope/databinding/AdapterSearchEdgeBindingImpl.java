package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.ImageViewBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;

/* loaded from: classes2.dex */
public class AdapterSearchEdgeBindingImpl extends AdapterSearchEdgeBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.edge_slopetype_radio_group, 10);
    }

    public AdapterSearchEdgeBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 11, sIncludes, sViewsWithIds));
    }

    private AdapterSearchEdgeBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 5, (RadioButton) objArr[6], (RadioButton) objArr[5], (RadioButton) objArr[4], (ImageView) objArr[7], (TextView) objArr[3], (RadioGroup) objArr[10], (TextView) objArr[1], (TextView) objArr[2], (TextView) objArr[8], (EditText) objArr[9]);
        this.mDirtyFlags = -1L;
        this.edgeEitherRadioButton.setTag(null);
        this.edgeFallingRadioButton.setTag(null);
        this.edgeRisingRadioButton.setTag(null);
        this.edgeSlopeImage.setTag(null);
        this.edgeSlopetype.setTag(null);
        this.edgeSource.setTag(null);
        this.edgeSourceSpinner.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.thre.setTag(null);
        this.threEditText.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
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
        if (258 == i) {
            setEdgeEitherMapping((MappingObject) obj);
        } else if (594 == i) {
            setParam((SearchParam) obj);
        } else if (261 == i) {
            setEdgeFallingMapping((MappingObject) obj);
        } else if (265 != i) {
            return false;
        } else {
            setEdgeRisingMapping((MappingObject) obj);
        }
        return true;
    }

    @Override // com.rigol.scope.databinding.AdapterSearchEdgeBinding
    public void setEdgeEitherMapping(MappingObject mappingObject) {
        updateRegistration(0, mappingObject);
        this.mEdgeEitherMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(258);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterSearchEdgeBinding
    public void setParam(SearchParam searchParam) {
        updateRegistration(1, searchParam);
        this.mParam = searchParam;
        synchronized (this) {
            this.mDirtyFlags |= 2;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterSearchEdgeBinding
    public void setEdgeFallingMapping(MappingObject mappingObject) {
        updateRegistration(2, mappingObject);
        this.mEdgeFallingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 4;
        }
        notifyPropertyChanged(261);
        super.requestRebind();
    }

    @Override // com.rigol.scope.databinding.AdapterSearchEdgeBinding
    public void setEdgeRisingMapping(MappingObject mappingObject) {
        updateRegistration(4, mappingObject);
        this.mEdgeRisingMapping = mappingObject;
        synchronized (this) {
            this.mDirtyFlags |= 16;
        }
        notifyPropertyChanged(265);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return false;
                        }
                        return onChangeEdgeRisingMapping((MappingObject) obj, i2);
                    }
                    return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchEdgeSourceParamEdgeSrcValue1((MappingObject) obj, i2);
                }
                return onChangeEdgeFallingMapping((MappingObject) obj, i2);
            }
            return onChangeParam((SearchParam) obj, i2);
        }
        return onChangeEdgeEitherMapping((MappingObject) obj, i2);
    }

    private boolean onChangeEdgeEitherMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(SearchParam searchParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 271) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 269) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 266) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 921) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeEdgeFallingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgSearchEdgeSourceParamEdgeSrcValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        }
        return false;
    }

    private boolean onChangeEdgeRisingMapping(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i;
        float f;
        String str;
        String str2;
        Drawable drawable;
        String str3;
        int i2;
        String str4;
        boolean z5;
        boolean z6;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        MappingObject mappingObject = this.mEdgeEitherMapping;
        SearchParam searchParam = this.mParam;
        MappingObject mappingObject2 = this.mEdgeFallingMapping;
        MappingObject mappingObject3 = this.mEdgeRisingMapping;
        int i3 = ((4129 & j) > 0L ? 1 : ((4129 & j) == 0L ? 0 : -1));
        String str5 = (i3 == 0 || mappingObject == null) ? null : mappingObject.getStr();
        if ((5066 & j) != 0) {
            if ((j & 4234) != 0) {
                ServiceEnum.Chan edgeSrc = searchParam != null ? searchParam.getEdgeSrc() : null;
                MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_search_edge_source, edgeSrc != null ? edgeSrc.value1 : 0);
                updateRegistration(3, mappingObject4);
                str4 = mappingObject4 != null ? mappingObject4.getStr() : null;
                i2 = (j & 4226) != 0 ? ColorUtil.getColor(getRoot().getContext(), edgeSrc) : 0;
            } else {
                i2 = 0;
                str4 = null;
            }
            if ((j & 4610) != 0) {
                str2 = UnitFormat.newBuilder(UnitFormat.SI.NANO).convert(searchParam != null ? searchParam.getThre() : 0L) + ServiceEnum.Unit.Unit_V.value2;
            } else {
                str2 = null;
            }
            if ((j & 4354) != 0) {
                ServiceEnum.EdgeSlope edgeSlope = searchParam != null ? searchParam.getEdgeSlope() : null;
                drawable = ViewUtil.getTriggerEdgePic(edgeSlope);
                z5 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Any;
                z = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Rising;
                z6 = edgeSlope == ServiceEnum.EdgeSlope.Trigger_Edge_Falling;
            } else {
                z5 = false;
                z = false;
                z6 = false;
                drawable = null;
            }
            if ((j & 4162) != 0) {
                boolean isEnable = searchParam != null ? searchParam.isEnable() : false;
                i = i2;
                z4 = isEnable;
                z3 = z5;
                str = str4;
                f = ContextUtil.getAlpha(isEnable);
                z2 = z6;
            } else {
                i = i2;
                z4 = false;
                z2 = z6;
                z3 = z5;
                str = str4;
                f = 0.0f;
            }
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            i = 0;
            f = 0.0f;
            str = null;
            str2 = null;
            drawable = null;
        }
        int i4 = ((j & 5124) > 0L ? 1 : ((j & 5124) == 0L ? 0 : -1));
        String str6 = (i4 == 0 || mappingObject2 == null) ? null : mappingObject2.getStr();
        int i5 = ((j & 6160) > 0L ? 1 : ((j & 6160) == 0L ? 0 : -1));
        String str7 = (i5 == 0 || mappingObject3 == null) ? null : mappingObject3.getStr();
        if ((j & 4354) != 0) {
            str3 = str2;
            CompoundButtonBindingAdapter.setChecked(this.edgeEitherRadioButton, z3);
            CompoundButtonBindingAdapter.setChecked(this.edgeFallingRadioButton, z2);
            CompoundButtonBindingAdapter.setChecked(this.edgeRisingRadioButton, z);
            ImageViewBindingAdapter.setImageDrawable(this.edgeSlopeImage, drawable);
        } else {
            str3 = str2;
        }
        if (i3 != 0) {
            TextViewBindingAdapter.setText(this.edgeEitherRadioButton, str5);
        }
        if ((4162 & j) != 0) {
            this.edgeEitherRadioButton.setEnabled(z4);
            this.edgeFallingRadioButton.setEnabled(z4);
            this.edgeRisingRadioButton.setEnabled(z4);
            this.edgeSlopeImage.setEnabled(z4);
            this.edgeSourceSpinner.setEnabled(z4);
            this.threEditText.setEnabled(z4);
            if (getBuildSdkInt() >= 11) {
                this.edgeEitherRadioButton.setAlpha(f);
                this.edgeFallingRadioButton.setAlpha(f);
                this.edgeRisingRadioButton.setAlpha(f);
                this.edgeSlopeImage.setAlpha(f);
                this.edgeSlopetype.setAlpha(f);
                this.edgeSource.setAlpha(f);
                this.edgeSourceSpinner.setAlpha(f);
                this.thre.setAlpha(f);
                this.threEditText.setAlpha(f);
            }
        }
        if (i4 != 0) {
            TextViewBindingAdapter.setText(this.edgeFallingRadioButton, str6);
        }
        if (i5 != 0) {
            TextViewBindingAdapter.setText(this.edgeRisingRadioButton, str7);
        }
        if ((j & 4234) != 0) {
            TextViewBindingAdapter.setText(this.edgeSourceSpinner, str);
        }
        if ((4226 & j) != 0) {
            this.edgeSourceSpinner.setTextColor(i);
        }
        if ((j & 4610) != 0) {
            TextViewBindingAdapter.setText(this.threEditText, str3);
        }
    }
}
