package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.CompoundButtonBindingAdapter;
import androidx.databinding.adapters.TextViewBindingAdapter;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.data.StorageSaveParam;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.SwitchButton;

/* loaded from: classes2.dex */
public class AdapterStorageSaveBindingImpl extends AdapterStorageSaveBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.guideline, 25);
        sViewsWithIds.put(R.id.choose, 26);
        sViewsWithIds.put(R.id.choose_dividing_line, 27);
        sViewsWithIds.put(R.id.storage_channel, 28);
        sViewsWithIds.put(R.id.file_dividing_line, 29);
        sViewsWithIds.put(R.id.prefix, 30);
        sViewsWithIds.put(R.id.auto_name, 31);
        sViewsWithIds.put(R.id.path_name, 32);
        sViewsWithIds.put(R.id.save, 33);
    }

    public AdapterStorageSaveBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 34, sIncludes, sViewsWithIds));
    }

    private AdapterStorageSaveBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 6, (TextView) objArr[31], (SwitchButton) objArr[23], (CheckBox) objArr[16], (CheckBox) objArr[17], (CheckBox) objArr[18], (CheckBox) objArr[19], (TextView) objArr[26], (View) objArr[27], (TextView) objArr[1], (View) objArr[29], (Guideline) objArr[25], (TextView) objArr[8], (SwitchButton) objArr[9], (TextView) objArr[4], (TextView) objArr[5], (TextView) objArr[10], (SwitchButton) objArr[11], (TextView) objArr[6], (SwitchButton) objArr[7], (TextView) objArr[32], (EditText) objArr[24], (TextView) objArr[30], (EditText) objArr[22], (Button) objArr[33], (TextView) objArr[20], (TextView) objArr[21], (TextView) objArr[2], (SwitchButton) objArr[3], (TextView) objArr[28], (TextView) objArr[12], (TextView) objArr[13], (TextView) objArr[14], (TextView) objArr[15]);
        this.mDirtyFlags = -1L;
        this.autoNameSwitch.setTag(null);
        this.checkBoxCH1.setTag(null);
        this.checkBoxCH2.setTag(null);
        this.checkBoxCH3.setTag(null);
        this.checkBoxCH4.setTag(null);
        this.chooseSpinnerSave.setTag(null);
        this.imageColor.setTag(null);
        this.imageColorSwitch.setTag(null);
        this.imageFormat.setTag(null);
        this.imageFormatSpinner.setTag(null);
        this.imageHeader.setTag(null);
        this.imageHeaderSwitch.setTag(null);
        this.imageInvert.setTag(null);
        this.imageInvertSwitch.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.pathNameEditText.setTag(null);
        this.prefixEditText.setTag(null);
        this.setupFormat.setTag(null);
        this.setupFormatSpinner.setTag(null);
        this.smbEnLabel.setTag(null);
        this.smbEnSwitch.setTag(null);
        this.waveDepth.setTag(null);
        this.waveDepthSpinner.setTag(null);
        this.waveFormat.setTag(null);
        this.waveFormatSpinner.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 134217728L;
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
        if (594 == i) {
            setParam((StorageSaveParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.AdapterStorageSaveBinding
    public void setParam(StorageSaveParam storageSaveParam) {
        updateRegistration(3, storageSaveParam);
        this.mParam = storageSaveParam;
        synchronized (this) {
            this.mDirtyFlags |= 8;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                return false;
                            }
                            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageWaveFormatParamWaveFileType((MappingObject) obj, i2);
                        }
                        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageSaveOptionParamChooseValue1((MappingObject) obj, i2);
                    }
                    return onChangeParam((StorageSaveParam) obj, i2);
                }
                return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageWaveDepthParamWaveDepth((MappingObject) obj, i2);
            }
            return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageImageFormatParamImageFileType((MappingObject) obj, i2);
        }
        return onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageSetupFormatParamSetupFileType((MappingObject) obj, i2);
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageSetupFormatParamSetupFileType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 64;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageImageFormatParamImageFileType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
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

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageWaveDepthParamWaveDepth(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 256;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeParam(StorageSaveParam storageSaveParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else if (i == 178) {
            synchronized (this) {
                this.mDirtyFlags |= 512;
            }
            return true;
        } else if (i == 855) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 428) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            return true;
        } else if (i == 430) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            }
            return true;
        } else if (i == 427) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PLAY_FROM_URI;
            }
            return true;
        } else if (i == 429) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE;
            }
            return true;
        } else if (i == 1035) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
            }
            return true;
        } else if (i == 1036) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
            }
            return true;
        } else if (i == 153) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
            }
            return true;
        } else if (i == 155) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
            }
            return true;
        } else if (i == 157) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
            }
            return true;
        } else if (i == 159) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
            }
            return true;
        } else if (i == 814) {
            synchronized (this) {
                this.mDirtyFlags |= PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            }
            return true;
        } else if (i == 654) {
            synchronized (this) {
                this.mDirtyFlags |= 4194304;
            }
            return true;
        } else if (i == 60) {
            synchronized (this) {
                this.mDirtyFlags |= 8388608;
            }
            return true;
        } else if (i == 603) {
            synchronized (this) {
                this.mDirtyFlags |= 16777216;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageSaveOptionParamChooseValue1(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 16;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 33554432;
            }
            return true;
        } else {
            return false;
        }
    }

    private boolean onChangeViewUtilGetMappingObjectComRigolScopeRArrayMsgStorageWaveFormatParamWaveFileType(MappingObject mappingObject, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 32;
            }
            return true;
        } else if (i == 915) {
            synchronized (this) {
                this.mDirtyFlags |= 67108864;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c4, code lost:
        if (r11 != false) goto L203;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0200  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int i;
        int i2;
        boolean z7;
        int i3;
        boolean z8;
        boolean z9;
        boolean z10;
        String str8;
        String str9;
        String str10;
        long j2;
        boolean z11;
        long j3;
        boolean z12;
        int i4;
        String str11;
        String str12;
        synchronized (this) {
            j = this.mDirtyFlags;
            this.mDirtyFlags = 0L;
        }
        StorageSaveParam storageSaveParam = this.mParam;
        String str13 = null;
        if ((268435455 & j) != 0) {
            z4 = ((j & 134479880) == 0 || storageSaveParam == null) ? false : storageSaveParam.isChan2();
            z6 = ((j & 135266312) == 0 || storageSaveParam == null) ? false : storageSaveParam.isChan4();
            if ((j & 167772696) != 0) {
                ServiceEnum.StorageOperationChoose choose = storageSaveParam != null ? storageSaveParam.getChoose() : null;
                int i5 = ((j & 134218248) > 0L ? 1 : ((j & 134218248) == 0L ? 0 : -1));
                if (i5 != 0) {
                    boolean z13 = choose == ServiceEnum.StorageOperationChoose.IMAGE;
                    boolean z14 = choose == ServiceEnum.StorageOperationChoose.WAVE;
                    boolean z15 = choose == ServiceEnum.StorageOperationChoose.SETUP;
                    if (i5 != 0) {
                        j |= z13 ? 536870912L : 268435456L;
                    }
                    if ((j & 134218248) != 0) {
                        j |= z14 ? 8589934592L : 4294967296L;
                    }
                    if ((j & 134218248) != 0) {
                        j |= z15 ? 2147483648L : 1073741824L;
                    }
                    i3 = 8;
                    i = z13 ? 0 : 8;
                    i2 = z14 ? 0 : 8;
                } else {
                    i = 0;
                    i2 = 0;
                }
                i3 = 0;
                MappingObject mappingObject = ViewUtil.getMappingObject(R.array.msg_storage_save_option, choose != null ? choose.value1 : 0);
                updateRegistration(4, mappingObject);
                str8 = mappingObject != null ? mappingObject.getStr() : null;
            } else {
                str8 = null;
                i = 0;
                i2 = 0;
                i3 = 0;
            }
            if ((j & 150994952) != 0) {
                str9 = ViewUtil.getDiskUIPathName(storageSaveParam != null ? storageSaveParam.getPathName() : null);
            } else {
                str9 = null;
            }
            boolean isChan1 = ((j & 134348808) == 0 || storageSaveParam == null) ? false : storageSaveParam.isChan1();
            boolean isChan3 = ((j & 134742024) == 0 || storageSaveParam == null) ? false : storageSaveParam.isChan3();
            boolean isImageInvert = ((j & 134221832) == 0 || storageSaveParam == null) ? false : storageSaveParam.isImageInvert();
            boolean isImageHeader = ((j & 134234120) == 0 || storageSaveParam == null) ? false : storageSaveParam.isImageHeader();
            if ((j & 201392168) != 0) {
                MappingObject mappingObject2 = ViewUtil.getMappingObject(R.array.msg_storage_wave_format, storageSaveParam != null ? storageSaveParam.getWaveFileType() : 0);
                updateRegistration(5, mappingObject2);
                if (mappingObject2 != null) {
                    str10 = mappingObject2.getStr();
                    boolean isAutoName = ((j & 142606344) != 0 || storageSaveParam == null) ? false : storageSaveParam.isAutoName();
                    if ((j & 134225928) != 0 || storageSaveParam == null) {
                        j2 = 134218760;
                        z11 = false;
                    } else {
                        z11 = storageSaveParam.isImageColor();
                        j2 = 134218760;
                    }
                    if ((j & j2) != 0 || storageSaveParam == null) {
                        j3 = 138412040;
                        z12 = false;
                    } else {
                        z12 = storageSaveParam.getSmbEn();
                        j3 = 138412040;
                    }
                    String prefix = ((j & j3) != 0 || storageSaveParam == null) ? null : storageSaveParam.getPrefix();
                    if ((j & 136314953) == 0) {
                        MappingObject mappingObject3 = ViewUtil.getMappingObject(R.array.msg_storage_setup_format, storageSaveParam != null ? storageSaveParam.getSetupFileType() : 0);
                        i4 = 0;
                        updateRegistration(0, mappingObject3);
                        if (mappingObject3 != null) {
                            str11 = mappingObject3.getStr();
                            if ((j & 134250764) != 0) {
                                MappingObject mappingObject4 = ViewUtil.getMappingObject(R.array.msg_storage_wave_depth, storageSaveParam != null ? storageSaveParam.getWaveDepth() : i4);
                                updateRegistration(2, mappingObject4);
                                if (mappingObject4 != null) {
                                    str12 = mappingObject4.getStr();
                                    if ((j & 134219914) != 0) {
                                        MappingObject mappingObject5 = ViewUtil.getMappingObject(R.array.msg_storage_image_format, storageSaveParam != null ? storageSaveParam.getImageFileType() : 0);
                                        updateRegistration(1, mappingObject5);
                                        if (mappingObject5 != null) {
                                            str13 = mappingObject5.getStr();
                                        }
                                    }
                                    str5 = str11;
                                    str6 = str12;
                                    str2 = str8;
                                    str3 = str9;
                                    str7 = str10;
                                    z5 = isAutoName;
                                    str = str13;
                                    z = isChan1;
                                    z2 = isChan3;
                                    z8 = isImageInvert;
                                    z7 = isImageHeader;
                                    z3 = z11;
                                    z9 = z12;
                                    str4 = prefix;
                                }
                            }
                            str12 = null;
                            if ((j & 134219914) != 0) {
                            }
                            str5 = str11;
                            str6 = str12;
                            str2 = str8;
                            str3 = str9;
                            str7 = str10;
                            z5 = isAutoName;
                            str = str13;
                            z = isChan1;
                            z2 = isChan3;
                            z8 = isImageInvert;
                            z7 = isImageHeader;
                            z3 = z11;
                            z9 = z12;
                            str4 = prefix;
                        }
                    } else {
                        i4 = 0;
                    }
                    str11 = null;
                    if ((j & 134250764) != 0) {
                    }
                    str12 = null;
                    if ((j & 134219914) != 0) {
                    }
                    str5 = str11;
                    str6 = str12;
                    str2 = str8;
                    str3 = str9;
                    str7 = str10;
                    z5 = isAutoName;
                    str = str13;
                    z = isChan1;
                    z2 = isChan3;
                    z8 = isImageInvert;
                    z7 = isImageHeader;
                    z3 = z11;
                    z9 = z12;
                    str4 = prefix;
                }
            }
            str10 = null;
            if ((j & 142606344) != 0) {
            }
            if ((j & 134225928) != 0) {
            }
            j2 = 134218760;
            z11 = false;
            if ((j & j2) != 0) {
            }
            j3 = 138412040;
            z12 = false;
            if ((j & j3) != 0) {
            }
            if ((j & 136314953) == 0) {
            }
            str11 = null;
            if ((j & 134250764) != 0) {
            }
            str12 = null;
            if ((j & 134219914) != 0) {
            }
            str5 = str11;
            str6 = str12;
            str2 = str8;
            str3 = str9;
            str7 = str10;
            z5 = isAutoName;
            str = str13;
            z = isChan1;
            z2 = isChan3;
            z8 = isImageInvert;
            z7 = isImageHeader;
            z3 = z11;
            z9 = z12;
            str4 = prefix;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            z = false;
            z2 = false;
            z3 = false;
            z4 = false;
            z5 = false;
            z6 = false;
            i = 0;
            i2 = 0;
            z7 = false;
            i3 = 0;
            z8 = false;
            z9 = false;
        }
        if ((j & 142606344) != 0) {
            z10 = z8;
            CompoundButtonBindingAdapter.setChecked(this.autoNameSwitch, z5);
        } else {
            z10 = z8;
        }
        if ((j & 134348808) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBoxCH1, z);
        }
        if ((j & 134479880) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBoxCH2, z4);
        }
        if ((j & 134742024) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBoxCH3, z2);
        }
        if ((j & 135266312) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.checkBoxCH4, z6);
        }
        if ((j & 167772696) != 0) {
            TextViewBindingAdapter.setText(this.chooseSpinnerSave, str2);
        }
        if ((j & 134218248) != 0) {
            this.imageColor.setVisibility(i);
            this.imageColorSwitch.setVisibility(i);
            this.imageFormat.setVisibility(i);
            this.imageFormatSpinner.setVisibility(i);
            this.imageHeader.setVisibility(i);
            this.imageHeaderSwitch.setVisibility(i);
            this.imageInvert.setVisibility(i);
            this.imageInvertSwitch.setVisibility(i);
            this.setupFormat.setVisibility(i3);
            this.setupFormatSpinner.setVisibility(i3);
            this.waveDepth.setVisibility(i2);
            this.waveDepthSpinner.setVisibility(i2);
            this.waveFormat.setVisibility(i2);
            this.waveFormatSpinner.setVisibility(i2);
        }
        if ((j & 134225928) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.imageColorSwitch, z3);
        }
        if ((134219914 & j) != 0) {
            TextViewBindingAdapter.setText(this.imageFormatSpinner, str);
        }
        if ((j & 134234120) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.imageHeaderSwitch, z7);
        }
        if ((j & 134221832) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.imageInvertSwitch, z10);
        }
        if ((j & 150994952) != 0) {
            TextViewBindingAdapter.setText(this.pathNameEditText, str3);
        }
        if ((138412040 & j) != 0) {
            TextViewBindingAdapter.setText(this.prefixEditText, str4);
        }
        if ((136314953 & j) != 0) {
            TextViewBindingAdapter.setText(this.setupFormatSpinner, str5);
        }
        if ((134217728 & j) != 0) {
            this.smbEnLabel.setVisibility(4);
            this.smbEnSwitch.setVisibility(4);
        }
        if ((134218760 & j) != 0) {
            CompoundButtonBindingAdapter.setChecked(this.smbEnSwitch, z9);
        }
        if ((134250764 & j) != 0) {
            TextViewBindingAdapter.setText(this.waveDepthSpinner, str6);
        }
        if ((j & 201392168) != 0) {
            TextViewBindingAdapter.setText(this.waveFormatSpinner, str7);
        }
    }
}
