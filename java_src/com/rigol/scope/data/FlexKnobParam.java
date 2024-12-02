package com.rigol.scope.data;

import android.app.Activity;
import android.text.TextUtils;
import androidx.databinding.Bindable;
import androidx.lifecycle.MutableLiveData;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.SPUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.ViewABkeyViewModel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class FlexKnobParam extends BaseParam {
    private ServiceEnum.Chan[] chanArr;
    private final List<MappingObject> constList;
    private MappingObject currentMappingObject;
    private int flexLatestCH;
    private boolean isCheckDirection;
    public OnRefreshListener onRefreshListener;
    private List<MappingObject> selectedList;

    /* loaded from: classes2.dex */
    public interface OnRefreshListener {
        void call(List<MappingObject> list);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.onRefreshListener = onRefreshListener;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void readAll() {
        readCHList();
    }

    public void readCHList() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        String UI_QueryStr = API.getInstance().UI_QueryStr(1, MessageID.MSG_FLEX_ORDER);
        if (!TextUtils.isEmpty(UI_QueryStr)) {
            String replace = UI_QueryStr.replace("[", "");
            String[] split = (TextUtils.isEmpty(replace) ? "" : replace.replace("]", "")).split(",");
            if (split.length > 0) {
                for (String str : split) {
                    ServiceEnum.FlexKnobEnum flexKnobEnumFromValue1 = ServiceEnum.getFlexKnobEnumFromValue1(Integer.parseInt(str));
                    if (flexKnobEnumFromValue1 != null) {
                        for (MappingObject mappingObject : this.constList) {
                            if (mappingObject.getValue() == flexKnobEnumFromValue1.value1 && !arrayList.contains(mappingObject)) {
                                arrayList.add(addKeyAOrBHint(flexKnobEnumFromValue1, mappingObject));
                            }
                        }
                    }
                }
            }
        }
        if (this.isCheckDirection) {
            ServiceEnum.FlexKnobEnum currentFlexKnobEnum = FunctionManager.getInstance().getCurrentFlexKnobEnum();
            arrayList2.clear();
            arrayList3.clear();
            arrayList4.clear();
            MappingObject mappingObject2 = null;
            MappingObject mappingObject3 = null;
            for (int i = 0; i < arrayList.size(); i++) {
                if (((MappingObject) arrayList.get(i)).getValue() == ServiceEnum.FlexKnobEnum.Intensity.value1) {
                    mappingObject3 = (MappingObject) arrayList.get(i);
                } else if (((MappingObject) arrayList.get(i)).getValue() == currentFlexKnobEnum.value1) {
                    mappingObject2 = (MappingObject) arrayList.get(i);
                } else if (((MappingObject) arrayList.get(i)).getValue() >= ServiceEnum.FlexKnobEnum.Math1.value1 && ((MappingObject) arrayList.get(i)).getValue() <= ServiceEnum.FlexKnobEnum.Math4.value1) {
                    arrayList2.add((MappingObject) arrayList.get(i));
                } else if (((MappingObject) arrayList.get(i)).getValue() >= ServiceEnum.FlexKnobEnum.Ref1.value1 && ((MappingObject) arrayList.get(i)).getValue() <= ServiceEnum.FlexKnobEnum.Ref10.value1) {
                    arrayList4.add((MappingObject) arrayList.get(i));
                } else {
                    arrayList3.add((MappingObject) arrayList.get(i));
                }
            }
            arrayList.clear();
            if (mappingObject2 != null) {
                arrayList.add(mappingObject2);
            }
            arrayList.addAll(swapFlexKnobOrder(arrayList2));
            arrayList.addAll(swapFlexKnobOrder(arrayList3));
            arrayList.addAll(swapFlexKnobOrder(arrayList4));
            if (mappingObject3 != null) {
                arrayList.add(mappingObject3);
            }
        }
        this.selectedList = arrayList;
        OnRefreshListener onRefreshListener = this.onRefreshListener;
        if (onRefreshListener != null) {
            onRefreshListener.call(arrayList);
        }
        if (this.isCheckDirection) {
            if (FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_CURSOR)) {
                FunctionManager.getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Cursor);
            } else if (FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_MATH) || FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_REF) || FunctionManager.getInstance().isEnabled(ServiceEnum.Function.FUN_DECODE)) {
                int value = ((MappingObject) arrayList.get(0)).getValue();
                if (value != ServiceEnum.FlexKnobEnum.Intensity.value1) {
                    FunctionManager.getInstance().setCurrentFlexKnobEnum(ServiceEnum.getFlexKnobEnumFromValue1(value));
                }
            } else {
                FunctionManager.getInstance().setCurrentFlexKnobEnum(ServiceEnum.FlexKnobEnum.Intensity);
            }
            changeIcon(FunctionManager.getInstance().getCurrentFlexKnobEnum());
        }
    }

    public FlexKnobParam() {
        super(11);
        this.constList = ViewUtil.getList((int) R.array.msg_flex_knob_manual);
        this.isCheckDirection = SPUtils.getInstance().getBoolean("isAutoDirection", true);
        this.currentMappingObject = ViewUtil.getList((int) R.array.msg_flex_knob_manual).get(0);
        this.chanArr = new ServiceEnum.Chan[]{ServiceEnum.Chan.intensity, ServiceEnum.Chan.cursor, ServiceEnum.Chan.m1, ServiceEnum.Chan.m2, ServiceEnum.Chan.m3, ServiceEnum.Chan.m4, ServiceEnum.Chan.la, ServiceEnum.Chan.dg1, ServiceEnum.Chan.dg2, ServiceEnum.Chan.r1, ServiceEnum.Chan.r2, ServiceEnum.Chan.r3, ServiceEnum.Chan.r4, ServiceEnum.Chan.r5, ServiceEnum.Chan.r6, ServiceEnum.Chan.r7, ServiceEnum.Chan.r8, ServiceEnum.Chan.r9, ServiceEnum.Chan.r10, ServiceEnum.Chan.bus1, ServiceEnum.Chan.bus2, ServiceEnum.Chan.bus3, ServiceEnum.Chan.bus4};
    }

    private List<MappingObject> swapFlexKnobOrder(List<MappingObject> list) {
        for (int i = 0; i < list.size(); i++) {
            int i2 = 0;
            while (i2 < (list.size() - 1) - i) {
                int i3 = i2 + 1;
                if (list.get(i2).getValue() > list.get(i3).getValue()) {
                    Collections.swap(list, i2, i3);
                }
                i2 = i3;
            }
        }
        return list;
    }

    @Bindable
    public int getFlexLatestCH() {
        return this.flexLatestCH;
    }

    public void setFlexLatestCH(int i) {
        API.getInstance().UI_PostInt64(1, MessageID.MSG_FLEX_LATEST, i);
        this.flexLatestCH = i;
        SPUtils.getInstance().put("flexLatestCH", i);
        notifyPropertyChanged(322);
    }

    public int readFlexLatest() {
        int i = SPUtils.getInstance().getInt("flexLatestCH", ServiceEnum.FlexKnobEnum.Intensity.value1);
        this.flexLatestCH = i;
        return i;
    }

    @Bindable
    public MappingObject getCurrentMappingObject() {
        return this.currentMappingObject;
    }

    public void setCurrentMappingObject(MappingObject mappingObject) {
        this.currentMappingObject = mappingObject;
        notifyPropertyChanged(196);
    }

    @Bindable
    public boolean isCheckDirection() {
        boolean z = SPUtils.getInstance().getBoolean("isAutoDirection", true);
        this.isCheckDirection = z;
        return z;
    }

    public void setCheckDirection(boolean z) {
        this.isCheckDirection = z;
        SPUtils.getInstance().put("isAutoDirection", z);
        notifyPropertyChanged(176);
    }

    public void refreshRef(int i) {
        MessageBus.getInstance().onSyncData(MessageBus.getKey(57, MessageID.MSG_FLEX_KNOB_REFRESH_REF_CHAN), Integer.valueOf(getRefChanByMappingObject(i)));
    }

    public int getRefChanByMappingObject(int i) {
        int i2 = ServiceEnum.Chan.r2.value1 - ServiceEnum.Chan.r1.value1;
        int i3 = ServiceEnum.Chan.r3.value1 - ServiceEnum.Chan.r1.value1;
        int i4 = ServiceEnum.Chan.r4.value1 - ServiceEnum.Chan.r1.value1;
        int i5 = ServiceEnum.Chan.r5.value1 - ServiceEnum.Chan.r1.value1;
        int i6 = ServiceEnum.Chan.r6.value1 - ServiceEnum.Chan.r1.value1;
        int i7 = ServiceEnum.Chan.r7.value1 - ServiceEnum.Chan.r1.value1;
        int i8 = ServiceEnum.Chan.r8.value1 - ServiceEnum.Chan.r1.value1;
        int i9 = ServiceEnum.Chan.r9.value1 - ServiceEnum.Chan.r1.value1;
        int i10 = ServiceEnum.Chan.r10.value1 - ServiceEnum.Chan.r1.value1;
        if (i != ServiceEnum.Chan.r1.value1) {
            if (i == ServiceEnum.Chan.r2.value1) {
                return i2;
            }
            if (i == ServiceEnum.Chan.r3.value1) {
                return i3;
            }
            if (i == ServiceEnum.Chan.r4.value1) {
                return i4;
            }
            if (i == ServiceEnum.Chan.r5.value1) {
                return i5;
            }
            if (i == ServiceEnum.Chan.r6.value1) {
                return i6;
            }
            if (i == ServiceEnum.Chan.r7.value1) {
                return i7;
            }
            if (i == ServiceEnum.Chan.r8.value1) {
                return i8;
            }
            if (i == ServiceEnum.Chan.r9.value1) {
                return i9;
            }
            if (i == ServiceEnum.Chan.r10.value1) {
                return i10;
            }
        }
        return 0;
    }

    public void changeIcon(int i) {
        MappingObject mappingObject;
        List<MappingObject> list = this.selectedList;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator<MappingObject> it = this.selectedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                mappingObject = null;
                break;
            }
            mappingObject = it.next();
            if (i == mappingObject.getValue()) {
                break;
            }
        }
        if (mappingObject == null) {
            return;
        }
        MessageBus.getInstance().onSyncData(MessageBus.getKey(57, MessageID.MSG_FLEX_KNOB_REFRESH_ICON), mappingObject);
        setFlexLatestCH(mappingObject.getValue());
        setCurrentMappingObject(mappingObject);
        if (mappingObject.getValue() < ServiceEnum.Chan.r1.value1 || mappingObject.getValue() > ServiceEnum.Chan.r10.value1) {
            return;
        }
        refreshRef(mappingObject.getValue());
    }

    private void changeIcon(ServiceEnum.FlexKnobEnum flexKnobEnum) {
        if (flexKnobEnum == null) {
            flexKnobEnum = ServiceEnum.FlexKnobEnum.Intensity;
        }
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[flexKnobEnum.ordinal()]) {
            case 1:
                changeIcon(ServiceEnum.FlexKnobEnum.Cursor.value1);
                return;
            case 2:
                changeIcon(ServiceEnum.FlexKnobEnum.Math1.value1);
                return;
            case 3:
                changeIcon(ServiceEnum.FlexKnobEnum.Math2.value1);
                return;
            case 4:
                changeIcon(ServiceEnum.FlexKnobEnum.Math3.value1);
                return;
            case 5:
                changeIcon(ServiceEnum.FlexKnobEnum.Math4.value1);
                return;
            case 6:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref1.value1);
                return;
            case 7:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref2.value1);
                return;
            case 8:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref3.value1);
                return;
            case 9:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref4.value1);
                return;
            case 10:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref5.value1);
                return;
            case 11:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref6.value1);
                return;
            case 12:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref7.value1);
                return;
            case 13:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref8.value1);
                return;
            case 14:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref9.value1);
                return;
            case 15:
                changeIcon(ServiceEnum.FlexKnobEnum.Ref10.value1);
                return;
            case 16:
                changeIcon(ServiceEnum.FlexKnobEnum.Decoder1.value1);
                return;
            case 17:
                changeIcon(ServiceEnum.FlexKnobEnum.Decoder2.value1);
                return;
            case 18:
                changeIcon(ServiceEnum.FlexKnobEnum.Decoder3.value1);
                return;
            case 19:
                changeIcon(ServiceEnum.FlexKnobEnum.Decoder4.value1);
                return;
            case 20:
                changeIcon(ServiceEnum.FlexKnobEnum.Intensity.value1);
                return;
            default:
                return;
        }
    }

    /* renamed from: com.rigol.scope.data.FlexKnobParam$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum;

        static {
            int[] iArr = new int[ServiceEnum.FlexKnobEnum.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum = iArr;
            try {
                iArr[ServiceEnum.FlexKnobEnum.Cursor.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math1.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math2.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math3.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Math4.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref1.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref2.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref3.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref4.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref5.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref6.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref7.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref8.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref9.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Ref10.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder1.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder2.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder3.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Decoder4.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.Intensity.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.LA.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.DG1.ordinal()] = 22;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[ServiceEnum.FlexKnobEnum.DG2.ordinal()] = 23;
            } catch (NoSuchFieldError unused23) {
            }
        }
    }

    private MappingObject addKeyAOrBHint(ServiceEnum.FlexKnobEnum flexKnobEnum, MappingObject mappingObject) {
        Activity topActivity = ActivityUtils.getTopActivity();
        switch (AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$FlexKnobEnum[flexKnobEnum.ordinal()]) {
            case 1:
                ViewABkeyViewModel viewABkeyViewModel = ViewUtil.getViewABkeyViewModel();
                MutableLiveData<Boolean> ax_boolean = viewABkeyViewModel.getAx_boolean();
                MutableLiveData<Boolean> ay_boolean = viewABkeyViewModel.getAy_boolean();
                MutableLiveData<Boolean> bx_boolean = viewABkeyViewModel.getBx_boolean();
                MutableLiveData<Boolean> by_boolean = viewABkeyViewModel.getBy_boolean();
                if (ax_boolean != null && ax_boolean.getValue() != null && ax_boolean.getValue().booleanValue()) {
                    mappingObject.setKeyAStr(topActivity.getString(R.string.flexknob_msg_flex_knob_cursor_hint_a_ax));
                } else if (ay_boolean != null && ay_boolean.getValue() != null && ay_boolean.getValue().booleanValue()) {
                    mappingObject.setKeyAStr(topActivity.getString(R.string.flexknob_msg_flex_knob_cursor_hint_a_ay));
                }
                if (bx_boolean != null && bx_boolean.getValue() != null && bx_boolean.getValue().booleanValue()) {
                    mappingObject.setKeyBStr(topActivity.getString(R.string.flexknob_msg_flex_knob_cursor_hint_b_bx));
                    break;
                } else if (by_boolean != null && by_boolean.getValue() != null && by_boolean.getValue().booleanValue()) {
                    mappingObject.setKeyBStr(topActivity.getString(R.string.flexknob_msg_flex_knob_cursor_hint_b_by));
                    break;
                }
                break;
            case 2:
                mathHint(0, mappingObject, topActivity);
                break;
            case 3:
                mathHint(1, mappingObject, topActivity);
                break;
            case 4:
                mathHint(2, mappingObject, topActivity);
                break;
            case 5:
                mathHint(3, mappingObject, topActivity);
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                mappingObject.setKeyAStr(topActivity.getString(R.string.flexknob_msg_flex_knob_ref_hint_a));
                mappingObject.setKeyBStr(topActivity.getString(R.string.flexknob_msg_flex_knob_ref_hint_b));
                break;
            case 16:
            case 17:
            case 18:
            case 19:
                mappingObject.setKeyAStr(topActivity.getString(R.string.flexknob_msg_flex_knob_decode_hint_a));
                mappingObject.setKeyBStr(topActivity.getString(R.string.flexknob_msg_flex_knob_decode_hint_b));
                break;
            case 20:
                mappingObject.setKeyAStr(topActivity.getString(R.string.msg_flex_knob_intensity_hint_a));
                mappingObject.setKeyBStr("");
                break;
            case 21:
            case 22:
            case 23:
                mappingObject.setKeyAStr("");
                mappingObject.setKeyBStr("");
                break;
        }
        return mappingObject;
    }

    private MappingObject mathHint(int i, MappingObject mappingObject, Activity activity) {
        ServiceEnum.MathOperator operator;
        MathViewModel mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        if (mathViewModel != null) {
            mathViewModel.getLiveData();
            ArrayList<MathParam> value = mathViewModel.getLiveData().getValue();
            if (value != null && value.size() > 0 && (operator = value.get(i).getOperator()) != null) {
                if (operator == ServiceEnum.MathOperator.operator_add || operator == ServiceEnum.MathOperator.operator_sub || operator == ServiceEnum.MathOperator.operator_mul || operator == ServiceEnum.MathOperator.operator_div) {
                    mappingObject.setKeyAStr(activity.getString(R.string.flexknob_msg_flex_knob_math_arithmetic_hint_a));
                    mappingObject.setKeyBStr(activity.getString(R.string.flexknob_msg_flex_knob_math_arithmetic_hint_b));
                } else if (operator == ServiceEnum.MathOperator.operator_fft) {
                    mappingObject.setKeyAStr(activity.getString(R.string.flexknob_msg_flex_knob_math_fft_hint_a));
                    mappingObject.setKeyBStr(activity.getString(R.string.flexknob_msg_flex_knob_math_fft_hint_b));
                } else if (operator == ServiceEnum.MathOperator.operator_and || operator == ServiceEnum.MathOperator.operator_or || operator == ServiceEnum.MathOperator.operator_xor || operator == ServiceEnum.MathOperator.operator_not) {
                    mappingObject.setKeyAStr(activity.getString(R.string.flexknob_msg_flex_knob_math_logic_hint_a));
                    mappingObject.setKeyBStr(activity.getString(R.string.flexknob_msg_flex_knob_math_logic_hint_b));
                } else if (operator == ServiceEnum.MathOperator.operator_intg || operator == ServiceEnum.MathOperator.operator_diff || operator == ServiceEnum.MathOperator.operator_root || operator == ServiceEnum.MathOperator.operator_lg || operator == ServiceEnum.MathOperator.operator_ln || operator == ServiceEnum.MathOperator.operator_exp || operator == ServiceEnum.MathOperator.operator_abs || operator == ServiceEnum.MathOperator.operator_ax_b) {
                    mappingObject.setKeyAStr(activity.getString(R.string.flexknob_msg_flex_knob_math_arithmetic_hint_a));
                    mappingObject.setKeyBStr(activity.getString(R.string.flexknob_msg_flex_knob_math_arithmetic_hint_b));
                } else if (operator == ServiceEnum.MathOperator.operator_lp || operator == ServiceEnum.MathOperator.operator_hp || operator == ServiceEnum.MathOperator.operator_bp || operator == ServiceEnum.MathOperator.operator_bt) {
                    mappingObject.setKeyAStr(activity.getString(R.string.flexknob_msg_flex_knob_math_arithmetic_hint_a));
                    mappingObject.setKeyBStr(activity.getString(R.string.flexknob_msg_flex_knob_math_arithmetic_hint_b));
                }
            }
        }
        return mappingObject;
    }

    @Override // com.rigol.scope.data.BaseParam
    public void reset() {
        super.reset();
        setCheckDirection(true);
    }
}
