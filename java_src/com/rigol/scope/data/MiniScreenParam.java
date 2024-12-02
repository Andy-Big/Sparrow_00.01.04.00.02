package com.rigol.scope.data;

import androidx.databinding.Bindable;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.viewmodels.CursorViewModel;

/* loaded from: classes2.dex */
public class MiniScreenParam extends BaseParam {
    private static final String DEFAULT_TOP_LEFT_STRING = "Scale";
    private static final String DEFAULT_TOP_LEFT_TIPS = "Vernier";
    private static final String DEFAULT_TOP_RIGHT_STRING = "Position";
    private static final String DEFAULT_TOP_RIGHT_TIPS = "Zero";
    private ServiceEnum.Function function;

    public MiniScreenParam() {
        super(0);
        this.function = ServiceEnum.Function.FUN_HORIZONTAL;
    }

    @Bindable
    public ServiceEnum.Function getFunction() {
        return this.function;
    }

    public void setFunction(ServiceEnum.Function function) {
        this.function = function;
        notifyPropertyChanged(352);
    }

    /* renamed from: com.rigol.scope.data.MiniScreenParam$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function;

        static {
            int[] iArr = new int[ServiceEnum.Function.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function = iArr;
            try {
                iArr[ServiceEnum.Function.FUN_CURSOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_WAVE_INTENSITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[ServiceEnum.Function.FUN_TRIGGER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public String getTopLeftCornerTips(ServiceEnum.Function function) {
        CursorResultParam value;
        if (function != null && AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()] == 1) {
            CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
            return (cursorViewModel == null || (value = cursorViewModel.getLiveData().getValue()) == null || value.getView() == ServiceEnum.CursorView.cursor_view_hori) ? "Ay" : "Ax";
        }
        return DEFAULT_TOP_LEFT_TIPS;
    }

    public String getTopRightCornerTips(ServiceEnum.Function function) {
        CursorResultParam value;
        if (function == null) {
            return DEFAULT_TOP_RIGHT_TIPS;
        }
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i != 1) {
            return i != 2 ? DEFAULT_TOP_RIGHT_TIPS : "Off";
        }
        CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        return (cursorViewModel == null || (value = cursorViewModel.getLiveData().getValue()) == null || value.getView() == ServiceEnum.CursorView.cursor_view_hori) ? "By" : "Bx";
    }

    public String getTopLeftCornerString(ServiceEnum.Function function) {
        CursorResultParam value;
        if (function != null && AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()] == 1) {
            CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
            return (cursorViewModel == null || (value = cursorViewModel.getLiveData().getValue()) == null || value.getView() == ServiceEnum.CursorView.cursor_view_hori) ? "Ax" : "Ay";
        }
        return DEFAULT_TOP_LEFT_STRING;
    }

    public String getTopRightCornerString(ServiceEnum.Function function) {
        CursorResultParam value;
        if (function == null) {
            return DEFAULT_TOP_RIGHT_STRING;
        }
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i != 1) {
            return i != 2 ? i != 3 ? DEFAULT_TOP_RIGHT_STRING : "Level" : "Intensity";
        }
        CursorViewModel cursorViewModel = (CursorViewModel) ContextUtil.getAppViewModel(CursorViewModel.class);
        return (cursorViewModel == null || (value = cursorViewModel.getLiveData().getValue()) == null || value.getView() == ServiceEnum.CursorView.cursor_view_hori) ? "Bx" : "By";
    }

    public String getTopCenterString(ServiceEnum.Function function) {
        if (function == null) {
            return ServiceEnum.Function.FUN_HORIZONTAL.value2;
        }
        int i = AnonymousClass1.$SwitchMap$com$rigol$scope$cil$ServiceEnum$Function[function.ordinal()];
        if (i == 1 || i == 3) {
            return function.value2;
        }
        return ServiceEnum.Function.FUN_HORIZONTAL.value2;
    }
}
