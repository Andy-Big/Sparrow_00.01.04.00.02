package com.rigol.scope.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.databinding.adapters.ViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.IOParam;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterUtilityLansettingItemBindingImpl extends AdapterUtilityLansettingItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.constraintLayout4, 15);
        sViewsWithIds.put(R.id.textView43, 16);
        sViewsWithIds.put(R.id.mac_layout, 17);
        sViewsWithIds.put(R.id.textView47, 18);
        sViewsWithIds.put(R.id.visa_layout, 19);
        sViewsWithIds.put(R.id.textView49, 20);
        sViewsWithIds.put(R.id.divider1, 21);
        sViewsWithIds.put(R.id.ipconfig_layout, 22);
        sViewsWithIds.put(R.id.ip_layout, 23);
        sViewsWithIds.put(R.id.textdivider11, 24);
        sViewsWithIds.put(R.id.submask_layout, 25);
        sViewsWithIds.put(R.id.textView38, 26);
        sViewsWithIds.put(R.id.gateway_layout, 27);
        sViewsWithIds.put(R.id.textView40, 28);
        sViewsWithIds.put(R.id.constraintLayout25, 29);
        sViewsWithIds.put(R.id.dns_layout, 30);
        sViewsWithIds.put(R.id.divider2, 31);
        sViewsWithIds.put(R.id.mDnslayout, 32);
        sViewsWithIds.put(R.id.mdns, 33);
        sViewsWithIds.put(R.id.hostNamelayout, 34);
        sViewsWithIds.put(R.id.textdivider13, 35);
        sViewsWithIds.put(R.id.gpiblayout, 36);
        sViewsWithIds.put(R.id.textdivider14, 37);
        sViewsWithIds.put(R.id.divider3, 38);
    }

    public AdapterUtilityLansettingItemBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 39, sIncludes, sViewsWithIds));
    }

    private AdapterUtilityLansettingItemBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[14], (ConstraintLayout) objArr[29], (ConstraintLayout) objArr[15], (View) objArr[21], (View) objArr[31], (View) objArr[38], (TextView) objArr[30], (EditText) objArr[12], (EditText) objArr[9], (EditText) objArr[10], (EditText) objArr[7], (EditText) objArr[8], (ConstraintLayout) objArr[27], (ConstraintLayout) objArr[36], (ConstraintLayout) objArr[34], (CheckBox) objArr[5], (CheckBox) objArr[4], (ConstraintLayout) objArr[23], (CheckBox) objArr[6], (ConstraintLayout) objArr[22], (ConstraintLayout) objArr[32], (ConstraintLayout) objArr[17], (TextView) objArr[33], (ConstraintLayout) objArr[25], (SwitchButton) objArr[11], (TextView) objArr[26], (TextView) objArr[28], (TextView) objArr[16], (TextView) objArr[18], (TextView) objArr[20], (TextView) objArr[24], (TextView) objArr[35], (TextView) objArr[37], (EditText) objArr[13], (TextView) objArr[2], (TextView) objArr[1], (TextView) objArr[3], (ConstraintLayout) objArr[19]);
        this.mDirtyFlags = -1L;
        this.apply.setTag(null);
        this.edtHostNameValue.setTag(null);
        this.edtdefaultGateway.setTag(null);
        this.edtdns.setTag(null);
        this.edtipAddress.setTag(null);
        this.edtsubMask.setTag(null);
        this.ipAuto.setTag(null);
        this.ipDhcp.setTag(null);
        this.ipStatic.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.switchMdns.setTag(null);
        this.tvgpib.setTag(null);
        this.tvmacAddress.setTag(null);
        this.tvnetState.setTag(null);
        this.tvvisaAddress.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
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
        if (446 == i) {
            setIoParam((IOParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterUtilityLansettingItemBinding
    public void setIoParam(IOParam iOParam) {
        updateRegistration(0, iOParam);
        this.mIoParam = iOParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(446);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeIoParam((IOParam) obj, i2);
    }

    private boolean onChangeIoParam(IOParam iOParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 909) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 513) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1034) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 213) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 62) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 907) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else if (i == 787) {
            synchronized (this) {
                this.mDirtyFlags |= 128;
            }
            return true;
        } else if (i == 447) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else if (i == 521) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 354) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 245) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 526) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 383) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 357) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1014) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
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
        boolean z5;
        boolean z6;
        int i;
        String str;
        String str2;
        String str3;
        Drawable drawable;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        float f;
        boolean z7;
        Drawable drawable2;
        String str10;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        IOParam iOParam = this.mIoParam;
        float f2 = 0.0f;
        int i2 = 0;
        String str11 = null;
        if ((131071 & j) != 0) {
            String macAddress = ((j & 65541) == 0 || iOParam == null) ? null : iOParam.getMacAddress();
            boolean isStaticSelected = ((j & 65601) == 0 || iOParam == null) ? false : iOParam.isStaticSelected();
            String dns = ((j & 67585) == 0 || iOParam == null) ? null : iOParam.getDns();
            boolean isAutoSelected = ((j & 65569) == 0 || iOParam == null) ? false : iOParam.isAutoSelected();
            boolean mdns = ((j & 69633) == 0 || iOParam == null) ? false : iOParam.getMdns();
            String hostName = ((j & 73729) == 0 || iOParam == null) ? null : iOParam.getHostName();
            if ((j & 98305) != 0) {
                z7 = iOParam != null ? iOParam.getValid() : false;
                f = ContextUtil.getAlpha(z7);
            } else {
                f = 0.0f;
                z7 = false;
            }
            boolean isDHCPSelected = ((j & 65553) == 0 || iOParam == null) ? false : iOParam.isDHCPSelected();
            String ipAddress = ((j & 65793) == 0 || iOParam == null) ? null : iOParam.getIpAddress();
            String gpibStr = ((j & 81921) == 0 || iOParam == null) ? null : iOParam.getGpibStr();
            String visaAddress = ((j & 65545) == 0 || iOParam == null) ? null : iOParam.getVisaAddress();
            int i3 = ((j & 65665) > 0L ? 1 : ((j & 65665) == 0L ? 0 : -1));
            if (i3 != 0) {
                z4 = (iOParam != null ? iOParam.getSelect() : 0) == 4;
                if (i3 != 0) {
                    j |= z4 ? PlaybackStateCompat.ACTION_SET_REPEAT_MODE : PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
                }
                drawable2 = ContextUtil.getDrawable(z4 ? R.drawable.sel_edit_line : 17170445);
            } else {
                z4 = false;
                drawable2 = null;
            }
            if ((j & 65539) != 0) {
                ServiceEnum.tagNET_STATUS_EN status = iOParam != null ? iOParam.getStatus() : null;
                int networkStatusColor = ViewUtil.getNetworkStatusColor(status);
                ServiceEnum.tagNET_STATUS_EN tagnet_status_en = status;
                str10 = tagnet_status_en != null ? tagnet_status_en.value2 : null;
                i2 = networkStatusColor;
            } else {
                str10 = null;
            }
            str = ((j & 66049) == 0 || iOParam == null) ? null : iOParam.getMask();
            if ((j & 66561) != 0 && iOParam != null) {
                str11 = iOParam.getGateway();
            }
            z = z7;
            str7 = macAddress;
            str8 = str10;
            drawable = drawable2;
            i = i2;
            str4 = str11;
            str5 = dns;
            z2 = isAutoSelected;
            z5 = mdns;
            str3 = hostName;
            f2 = f;
            z3 = isDHCPSelected;
            str2 = ipAddress;
            str6 = gpibStr;
            str9 = visaAddress;
            z6 = isStaticSelected;
        } else {
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            i = 0;
            str = null;
            str2 = null;
            str3 = null;
            drawable = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
        }
        if ((j & 98305) != 0) {
            if (getBuildSdkInt() >= 11) {
                this.apply.setAlpha(f2);
            }
            this.apply.setEnabled(z);
        }
        if ((j & 73729) != 0) {
            TextViewBindingAdapter.setText(this.edtHostNameValue, str3);
        }
        if ((j & 65665) != 0) {
            ViewBindingAdapter.setBackground(this.edtdefaultGateway, drawable);
            this.edtdefaultGateway.setEnabled(z4);
            ViewBindingAdapter.setBackground(this.edtdns, drawable);
            this.edtdns.setEnabled(z4);
            ViewBindingAdapter.setBackground(this.edtipAddress, drawable);
            this.edtipAddress.setEnabled(z4);
            ViewBindingAdapter.setBackground(this.edtsubMask, drawable);
            this.edtsubMask.setEnabled(z4);
        }
        if ((j & 66561) != 0) {
            TextViewBindingAdapter.setText(this.edtdefaultGateway, str4);
        }
        if ((j & 67585) != 0) {
            TextViewBindingAdapter.setText(this.edtdns, str5);
        }
        if ((j & 65793) != 0) {
            TextViewBindingAdapter.setText(this.edtipAddress, str2);
        }
        if ((j & 66049) != 0) {
            TextViewBindingAdapter.setText(this.edtsubMask, str);
        }
        if ((j & 65569) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.ipAuto, z2);
        }
        if ((65553 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.ipDhcp, z3);
        }
        if ((j & 65601) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.ipStatic, z6);
        }
        if ((j & 69633) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.switchMdns, z5);
        }
        if ((81921 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvgpib, str6);
        }
        if ((j & 65541) != 0) {
            TextViewBindingAdapter.setText(this.tvmacAddress, str7);
        }
        if ((65539 & j) != 0) {
            TextViewBindingAdapter.setText(this.tvnetState, str8);
            this.tvnetState.setTextColor(i);
        }
        if ((j & 65545) != 0) {
            TextViewBindingAdapter.setText(this.tvvisaAddress, str9);
        }
    }
}
