package com.rigol.scope.utilities;

import androidx.lifecycle.ViewModelProvider;
import com.rigol.scope.viewmodels.AfgViewModel;
import com.rigol.scope.viewmodels.AutosetViewModel;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.CalibrationViewModel;
import com.rigol.scope.viewmodels.CounterViewModel;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.DiskManageViewModel;
import com.rigol.scope.viewmodels.DisplayViewModel;
import com.rigol.scope.viewmodels.DvmViewModel;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.FlexKnobViewModel;
import com.rigol.scope.viewmodels.HistogramViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.IOViewModel;
import com.rigol.scope.viewmodels.LaViewModel;
import com.rigol.scope.viewmodels.MaskViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.MeasureResultViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.NavigateViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.RefViewModel;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.StorageViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.UpaViewModel;
import com.rigol.scope.viewmodels.UpaViewRippleModel;
import com.rigol.scope.viewmodels.UtilityViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.viewmodels.WaveRecordViewModel;
import com.rigol.scope.viewmodels.XYViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ViewModelManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/rigol/scope/utilities/ViewModelManager;", "", "()V", "readAll", "", "viewModelProvider", "Landroidx/lifecycle/ViewModelProvider;", "app_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes2.dex */
public final class ViewModelManager {
    public static final ViewModelManager INSTANCE = new ViewModelManager();

    private ViewModelManager() {
    }

    public final void readAll(ViewModelProvider viewModelProvider) {
        Intrinsics.checkNotNullParameter(viewModelProvider, "viewModelProvider");
        String simpleName = ViewModelManager.class.getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "ViewModelManager::class.java.simpleName");
        StopWatch stopWatch = new StopWatch(simpleName);
        Throwable th = null;
        try {
            StopWatch stopWatch2 = stopWatch;
            ((VerticalViewModel) viewModelProvider.get(VerticalViewModel.class)).get(new Object[0]);
            ((HorizontalViewModel) viewModelProvider.get(HorizontalViewModel.class)).get(new Object[0]);
            ((TriggerViewModel) viewModelProvider.get(TriggerViewModel.class)).get(new Object[0]);
            ((MathViewModel) viewModelProvider.get(MathViewModel.class)).get(new Object[0]);
            ((FftViewModel) viewModelProvider.get(FftViewModel.class)).get(new Object[0]);
            ((CursorViewModel) viewModelProvider.get(CursorViewModel.class)).get(new Object[0]);
            ((AutosetViewModel) viewModelProvider.get(AutosetViewModel.class)).get(new Object[0]);
            viewModelProvider.get(MeasureResultViewModel.class);
            ((DvmViewModel) viewModelProvider.get(DvmViewModel.class)).get(new Object[0]);
            ((CounterViewModel) viewModelProvider.get(CounterViewModel.class)).get(new Object[0]);
            ((MeasureSettingViewModel) viewModelProvider.get(MeasureSettingViewModel.class)).get(new Object[0]);
            ((HistogramViewModel) viewModelProvider.get(HistogramViewModel.class)).get(new Object[0]);
            ((DecodeViewModel) viewModelProvider.get(DecodeViewModel.class)).get(new Object[0]);
            ((RefViewModel) viewModelProvider.get(RefViewModel.class)).get(new Object[0]);
            ((MaskViewModel) viewModelProvider.get(MaskViewModel.class)).get(new Object[0]);
            ((WaveRecordViewModel) viewModelProvider.get(WaveRecordViewModel.class)).get(new Object[0]);
            ((SearchViewModel) viewModelProvider.get(SearchViewModel.class)).get(new Object[0]);
            ((DisplayViewModel) viewModelProvider.get(DisplayViewModel.class)).get(new Object[0]);
            ((XYViewModel) viewModelProvider.get(XYViewModel.class)).get(new Object[0]);
            ((StorageViewModel) viewModelProvider.get(StorageViewModel.class)).get();
            ((DiskManageViewModel) viewModelProvider.get(DiskManageViewModel.class)).get(new Object[0]);
            ((UtilityViewModel) viewModelProvider.get(UtilityViewModel.class)).get(new Object[0]);
            ((CalibrationViewModel) viewModelProvider.get(CalibrationViewModel.class)).get(new Object[0]);
            ((OptionViewModel) viewModelProvider.get(OptionViewModel.class)).get(new Object[0]);
            ((IOViewModel) viewModelProvider.get(IOViewModel.class)).get(new Object[0]);
            ((SharedViewModel) viewModelProvider.get(SharedViewModel.class)).get(new Object[0]);
            ((UpaViewModel) viewModelProvider.get(UpaViewModel.class)).get(new Object[0]);
            ((UpaViewRippleModel) viewModelProvider.get(UpaViewRippleModel.class)).get(new Object[0]);
            ((FlexKnobViewModel) viewModelProvider.get(FlexKnobViewModel.class)).get(new Object[0]);
            ((NavigateViewModel) viewModelProvider.get(NavigateViewModel.class)).get(new Object[0]);
            ((LaViewModel) viewModelProvider.get(LaViewModel.class)).get(new Object[0]);
            ((AfgViewModel) viewModelProvider.get(AfgViewModel.class)).get(new Object[0]);
            ((BodeViewModel) viewModelProvider.get(BodeViewModel.class)).get(new Object[0]);
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(stopWatch, th);
        } finally {
        }
    }
}
