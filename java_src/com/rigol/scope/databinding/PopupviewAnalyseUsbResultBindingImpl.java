package com.rigol.scope.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.adapters.TextViewBindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.views.busAnalyse.BusAnalyseUsbParam;

/* loaded from: classes2.dex */
public class PopupviewAnalyseUsbResultBindingImpl extends PopupviewAnalyseUsbResultBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.title_layout, 25);
        sViewsWithIds.put(R.id.scrollView, 26);
        sViewsWithIds.put(R.id.resultText, 27);
        sViewsWithIds.put(R.id.bus_analyse_usb_result_save, 28);
        sViewsWithIds.put(R.id.header, 29);
        sViewsWithIds.put(R.id.result, 30);
        sViewsWithIds.put(R.id.poltText, 31);
        sViewsWithIds.put(R.id.plot_layout, 32);
        sViewsWithIds.put(R.id.polt, 33);
        sViewsWithIds.put(R.id.plot_y_layout, 34);
        sViewsWithIds.put(R.id.yruler9, 35);
        sViewsWithIds.put(R.id.plot_x_layout, 36);
        sViewsWithIds.put(R.id.xruler1, 37);
        sViewsWithIds.put(R.id.eyeText, 38);
        sViewsWithIds.put(R.id.eye_layout, 39);
        sViewsWithIds.put(R.id.eye, 40);
        sViewsWithIds.put(R.id.yruler1_1, 41);
        sViewsWithIds.put(R.id.yruler2_1, 42);
        sViewsWithIds.put(R.id.yruler3_1, 43);
        sViewsWithIds.put(R.id.yruler4_1, 44);
        sViewsWithIds.put(R.id.yruler5_1, 45);
        sViewsWithIds.put(R.id.yruler6_1, 46);
        sViewsWithIds.put(R.id.yruler7_1, 47);
        sViewsWithIds.put(R.id.yruler8_1, 48);
        sViewsWithIds.put(R.id.yruler9_1, 49);
        sViewsWithIds.put(R.id.eyexruler1_1, 50);
        sViewsWithIds.put(R.id.xruler2_1, 51);
        sViewsWithIds.put(R.id.xruler3_1, 52);
        sViewsWithIds.put(R.id.xruler4_1, 53);
        sViewsWithIds.put(R.id.xruler5_1, 54);
        sViewsWithIds.put(R.id.xruler6_1, 55);
        sViewsWithIds.put(R.id.xruler7_1, 56);
        sViewsWithIds.put(R.id.yruler1_11, 57);
        sViewsWithIds.put(R.id.yruler2_11, 58);
        sViewsWithIds.put(R.id.yruler3_11, 59);
        sViewsWithIds.put(R.id.yruler4_11, 60);
        sViewsWithIds.put(R.id.yruler5_11, 61);
        sViewsWithIds.put(R.id.yruler6_11, 62);
        sViewsWithIds.put(R.id.xruler1_11, 63);
        sViewsWithIds.put(R.id.xruler2_11, 64);
        sViewsWithIds.put(R.id.xruler3_11, 65);
        sViewsWithIds.put(R.id.xruler4_11, 66);
        sViewsWithIds.put(R.id.xruler5_11, 67);
        sViewsWithIds.put(R.id.xruler6_11, 68);
        sViewsWithIds.put(R.id.xruler7_11, 69);
        sViewsWithIds.put(R.id.xruler8_11, 70);
        sViewsWithIds.put(R.id.xruler9_11, 71);
        sViewsWithIds.put(R.id.yruler1_2, 72);
        sViewsWithIds.put(R.id.yruler2_2, 73);
        sViewsWithIds.put(R.id.yruler3_2, 74);
        sViewsWithIds.put(R.id.yruler4_2, 75);
        sViewsWithIds.put(R.id.yruler5_2, 76);
        sViewsWithIds.put(R.id.yruler6_2, 77);
        sViewsWithIds.put(R.id.yruler7_2, 78);
        sViewsWithIds.put(R.id.yruler8_2, 79);
        sViewsWithIds.put(R.id.yruler9_2, 80);
        sViewsWithIds.put(R.id.yruler10_2, 81);
        sViewsWithIds.put(R.id.yruler11_2, 82);
        sViewsWithIds.put(R.id.xruler1_2, 83);
        sViewsWithIds.put(R.id.xruler2_2, 84);
        sViewsWithIds.put(R.id.xruler3_2, 85);
        sViewsWithIds.put(R.id.xruler4_2, 86);
        sViewsWithIds.put(R.id.xruler5_2, 87);
    }

    public PopupviewAnalyseUsbResultBindingImpl(DataBindingComponent dataBindingComponent, View view) {
        this(dataBindingComponent, view, mapBindings(dataBindingComponent, view, 88, sIncludes, sViewsWithIds));
    }

    private PopupviewAnalyseUsbResultBindingImpl(DataBindingComponent dataBindingComponent, View view, Object[] objArr) {
        super(dataBindingComponent, view, 1, (Button) objArr[28], (ImageView) objArr[40], (ConstraintLayout) objArr[22], (ConstraintLayout) objArr[21], (ConstraintLayout) objArr[20], (ConstraintLayout) objArr[19], (ConstraintLayout) objArr[24], (ConstraintLayout) objArr[23], (ConstraintLayout) objArr[39], (TextView) objArr[38], (TextView) objArr[50], (RecyclerView) objArr[29], (ConstraintLayout) objArr[32], (ConstraintLayout) objArr[36], (ConstraintLayout) objArr[34], (ImageView) objArr[33], (TextView) objArr[31], (RecyclerView) objArr[30], (TextView) objArr[27], (ScrollView) objArr[26], (View) objArr[25], (TextView) objArr[37], (TextView) objArr[17], (TextView) objArr[18], (TextView) objArr[63], (TextView) objArr[83], (TextView) objArr[9], (TextView) objArr[51], (TextView) objArr[64], (TextView) objArr[84], (TextView) objArr[10], (TextView) objArr[52], (TextView) objArr[65], (TextView) objArr[85], (TextView) objArr[11], (TextView) objArr[53], (TextView) objArr[66], (TextView) objArr[86], (TextView) objArr[12], (TextView) objArr[54], (TextView) objArr[67], (TextView) objArr[87], (TextView) objArr[13], (TextView) objArr[55], (TextView) objArr[68], (TextView) objArr[14], (TextView) objArr[56], (TextView) objArr[69], (TextView) objArr[15], (TextView) objArr[70], (TextView) objArr[16], (TextView) objArr[71], (TextView) objArr[1], (TextView) objArr[81], (TextView) objArr[41], (TextView) objArr[57], (TextView) objArr[82], (TextView) objArr[72], (TextView) objArr[2], (TextView) objArr[42], (TextView) objArr[58], (TextView) objArr[73], (TextView) objArr[3], (TextView) objArr[43], (TextView) objArr[59], (TextView) objArr[74], (TextView) objArr[4], (TextView) objArr[44], (TextView) objArr[60], (TextView) objArr[75], (TextView) objArr[5], (TextView) objArr[45], (TextView) objArr[61], (TextView) objArr[76], (TextView) objArr[6], (TextView) objArr[46], (TextView) objArr[62], (TextView) objArr[77], (TextView) objArr[7], (TextView) objArr[47], (TextView) objArr[78], (TextView) objArr[8], (TextView) objArr[48], (TextView) objArr[79], (TextView) objArr[35], (TextView) objArr[49], (TextView) objArr[80]);
        this.mDirtyFlags = -1L;
        this.eye11Xlayout.setTag(null);
        this.eye11Ylayout.setTag(null);
        this.eye1Xlayout.setTag(null);
        this.eye1Ylayout.setTag(null);
        this.eye2Xlayout.setTag(null);
        this.eye2Ylayout.setTag(null);
        ConstraintLayout constraintLayout = (ConstraintLayout) objArr[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        this.xruler10.setTag(null);
        this.xruler11.setTag(null);
        this.xruler2.setTag(null);
        this.xruler3.setTag(null);
        this.xruler4.setTag(null);
        this.xruler5.setTag(null);
        this.xruler6.setTag(null);
        this.xruler7.setTag(null);
        this.xruler8.setTag(null);
        this.xruler9.setTag(null);
        this.yruler1.setTag(null);
        this.yruler2.setTag(null);
        this.yruler3.setTag(null);
        this.yruler4.setTag(null);
        this.yruler5.setTag(null);
        this.yruler6.setTag(null);
        this.yruler7.setTag(null);
        this.yruler8.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 16L;
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
            setParam((BusAnalyseUsbParam) obj);
            return true;
        }
        return false;
    }

    @Override // com.rigol.scope.databinding.PopupviewAnalyseUsbResultBinding
    public void setParam(BusAnalyseUsbParam busAnalyseUsbParam) {
        updateRegistration(0, busAnalyseUsbParam);
        this.mParam = busAnalyseUsbParam;
        synchronized (this) {
            this.mDirtyFlags |= 1;
        }
        notifyPropertyChanged(594);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return onChangeParam((BusAnalyseUsbParam) obj, i2);
    }

    private boolean onChangeParam(BusAnalyseUsbParam busAnalyseUsbParam, int i) {
        if (i == 0) {
            synchronized (this) {
                this.mDirtyFlags |= 1;
            }
            return true;
        } else if (i == 899) {
            synchronized (this) {
                this.mDirtyFlags |= 2;
            }
            return true;
        } else if (i == 898) {
            synchronized (this) {
                this.mDirtyFlags |= 4;
            }
            return true;
        } else if (i == 1011) {
            synchronized (this) {
                this.mDirtyFlags |= 8;
            }
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02d8  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void executeBindings() {
        long j;
        int i;
        boolean z;
        boolean z2;
        boolean z3;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        long j2;
        String str19;
        boolean z4;
        boolean z5;
        boolean z6;
        int i2;
        int i3;
        int i4;
        String str20;
        int i5;
        String str21;
        PopupviewAnalyseUsbResultBindingImpl popupviewAnalyseUsbResultBindingImpl;
        BusAnalyseUsbParam busAnalyseUsbParam;
        long j3;
        String str22;
        String str23;
        String str24;
        String str25;
        String str26;
        String str27;
        String str28;
        String str29;
        long j4;
        boolean z7;
        boolean z8;
        boolean z9;
        long j5;
        String str30;
        boolean z10;
        String str31;
        String str32;
        long j6;
        synchronized (this) {
            try {
                j = this.mDirtyFlags;
                this.mDirtyFlags = 0L;
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        break;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
                throw th;
            }
        }
        BusAnalyseUsbParam busAnalyseUsbParam2 = this.mParam;
        if ((31 & j) != 0) {
            if ((j & 19) != 0) {
                long srcVscale = busAnalyseUsbParam2 != null ? busAnalyseUsbParam2.getSrcVscale() : 0L;
                j3 = j;
                busAnalyseUsbParam = busAnalyseUsbParam2;
                str28 = UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(srcVscale * 2, ServiceEnum.Unit.Unit_V);
                str24 = UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(srcVscale * 0, ServiceEnum.Unit.Unit_V);
                str25 = UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(srcVscale * (-1), ServiceEnum.Unit.Unit_V);
                str29 = UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(srcVscale * (-2), ServiceEnum.Unit.Unit_V);
                str26 = UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(srcVscale * 3, ServiceEnum.Unit.Unit_V);
                str27 = UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(srcVscale * 4, ServiceEnum.Unit.Unit_V);
                str22 = UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(srcVscale * 1, ServiceEnum.Unit.Unit_V);
                str23 = UnitFormat.newBuilder("0.##", UnitFormat.SI.MICRO).convert(srcVscale * (-3), ServiceEnum.Unit.Unit_V);
            } else {
                busAnalyseUsbParam = busAnalyseUsbParam2;
                j3 = j;
                str22 = null;
                str23 = null;
                str24 = null;
                str25 = null;
                str26 = null;
                str27 = null;
                str28 = null;
                str29 = null;
            }
            int i6 = ((j3 & 25) > 0L ? 1 : ((j3 & 25) == 0L ? 0 : -1));
            if (i6 != 0) {
                i = busAnalyseUsbParam != null ? busAnalyseUsbParam.getUsb_type() : 0;
                z7 = i == 4;
                z8 = i == 2;
                z9 = i == 0;
                j5 = i6 != 0 ? z7 ? j3 | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j3 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID : j3;
                j4 = 0;
                if ((j5 & 25) != 0) {
                    j5 |= z8 ? 64L : 32L;
                }
                if ((j5 & 25) != 0) {
                    j5 = z9 ? j5 | PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID : j5 | 512;
                }
            } else {
                j4 = 0;
                i = 0;
                z7 = false;
                z8 = false;
                z9 = false;
                j5 = j3;
            }
            if ((j5 & 21) != j4) {
                if (busAnalyseUsbParam != null) {
                    j6 = busAnalyseUsbParam.getSrcHscale();
                    str31 = str22;
                    str32 = str23;
                } else {
                    str31 = str22;
                    str32 = str23;
                    j6 = j4;
                }
                String str33 = str24;
                String str34 = str25;
                String str35 = str26;
                String str36 = str27;
                String str37 = str28;
                str30 = str29;
                z10 = z7;
                boolean z11 = z8;
                String str38 = str32;
                String convert = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * 3, ServiceEnum.Unit.Unit_s);
                String convert2 = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * 5, ServiceEnum.Unit.Unit_s);
                String convert3 = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * j4, ServiceEnum.Unit.Unit_s);
                String convert4 = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * (-3), ServiceEnum.Unit.Unit_s);
                String convert5 = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * (-4), ServiceEnum.Unit.Unit_s);
                str3 = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * 2, ServiceEnum.Unit.Unit_s);
                String convert6 = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * (-1), ServiceEnum.Unit.Unit_s);
                String convert7 = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * 1, ServiceEnum.Unit.Unit_s);
                str8 = convert6;
                str4 = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * (-2), ServiceEnum.Unit.Unit_s);
                str = UnitFormat.newBuilder("0.##", UnitFormat.SI.FEMTO).convert(j6 * 4, ServiceEnum.Unit.Unit_s);
                str13 = convert5;
                str11 = convert2;
                str17 = str33;
                str14 = str38;
                str12 = str35;
                str9 = str36;
                j = j5;
                str18 = str31;
                j2 = 512;
                str7 = convert7;
                str6 = convert3;
                str2 = convert;
                str5 = convert4;
                z2 = z11;
                z3 = z9;
                i = i;
                str16 = str34;
                str10 = str37;
            } else {
                str30 = str29;
                z10 = z7;
                boolean z12 = z8;
                boolean z13 = z9;
                str17 = str24;
                str14 = str23;
                str12 = str26;
                str9 = str27;
                j = j5;
                str18 = str22;
                str10 = str28;
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                str11 = null;
                str13 = null;
                j2 = 512;
                z2 = z12;
                z3 = z13;
                str16 = str25;
            }
            z = z10;
            str15 = str30;
        } else {
            i = 0;
            z = false;
            z2 = false;
            z3 = false;
            str = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            str8 = null;
            str9 = null;
            str10 = null;
            str11 = null;
            str12 = null;
            str13 = null;
            str14 = null;
            str15 = null;
            str16 = null;
            str17 = null;
            str18 = null;
            j2 = 512;
        }
        if ((j & j2) != 0) {
            str19 = str10;
            if (i == 1) {
                z4 = true;
                boolean z14 = (j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) == 0 && i == 5;
                if ((j & 32) == 0) {
                    z5 = z14;
                    if (i == 3) {
                        z6 = true;
                        i2 = ((j & 25) > 0L ? 1 : ((j & 25) == 0L ? 0 : -1));
                        if (i2 != 0) {
                            if (z2) {
                                z6 = true;
                            }
                            if (z3) {
                                z4 = true;
                            }
                            if (z) {
                                z5 = true;
                            }
                            if (i2 != 0) {
                                j |= z6 ? 256L : 128L;
                            }
                            if ((j & 25) != 0) {
                                j |= z4 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
                            }
                            if ((j & 25) != 0) {
                                j |= z5 ? PlaybackStateCompat.ACTION_PREPARE : PlaybackStateCompat.ACTION_PLAY_FROM_URI;
                            }
                            i3 = z6 ? 0 : 8;
                            i4 = z4 ? 0 : 8;
                            str20 = str12;
                            i5 = z5 ? 0 : 8;
                        } else {
                            i3 = 0;
                            i4 = 0;
                            str20 = str12;
                            i5 = 0;
                        }
                        String str39 = str2;
                        if ((j & 25) != 0) {
                            str21 = str9;
                            popupviewAnalyseUsbResultBindingImpl = this;
                            popupviewAnalyseUsbResultBindingImpl.eye11Xlayout.setVisibility(i3);
                            popupviewAnalyseUsbResultBindingImpl.eye11Ylayout.setVisibility(i3);
                            popupviewAnalyseUsbResultBindingImpl.eye1Xlayout.setVisibility(i4);
                            popupviewAnalyseUsbResultBindingImpl.eye1Ylayout.setVisibility(i4);
                            popupviewAnalyseUsbResultBindingImpl.eye2Xlayout.setVisibility(i5);
                            popupviewAnalyseUsbResultBindingImpl.eye2Ylayout.setVisibility(i5);
                        } else {
                            str21 = str9;
                            popupviewAnalyseUsbResultBindingImpl = this;
                        }
                        if ((j & 21) != 0) {
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler10, str);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler11, str11);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler2, str13);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler3, str5);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler4, str4);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler5, str8);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler6, str6);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler7, str7);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler8, str3);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.xruler9, str39);
                        }
                        if ((19 & j) != 0) {
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.yruler1, str21);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.yruler2, str20);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.yruler3, str19);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.yruler4, str18);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.yruler5, str17);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.yruler6, str16);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.yruler7, str15);
                            TextViewBindingAdapter.setText(popupviewAnalyseUsbResultBindingImpl.yruler8, str14);
                            return;
                        }
                        return;
                    }
                } else {
                    z5 = z14;
                }
                z6 = false;
                i2 = ((j & 25) > 0L ? 1 : ((j & 25) == 0L ? 0 : -1));
                if (i2 != 0) {
                }
                String str392 = str2;
                if ((j & 25) != 0) {
                }
                if ((j & 21) != 0) {
                }
                if ((19 & j) != 0) {
                }
            }
        } else {
            str19 = str10;
        }
        z4 = false;
        if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) == 0) {
        }
        if ((j & 32) == 0) {
        }
        z6 = false;
        i2 = ((j & 25) > 0L ? 1 : ((j & 25) == 0L ? 0 : -1));
        if (i2 != 0) {
        }
        String str3922 = str2;
        if ((j & 25) != 0) {
        }
        if ((j & 21) != 0) {
        }
        if ((19 & j) != 0) {
        }
    }
}
