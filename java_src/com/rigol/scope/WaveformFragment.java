package com.rigol.scope;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ThreadUtils;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.BodeParam;
import com.rigol.scope.data.CursorResultParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.EyeParam;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.FlexKnobParam;
import com.rigol.scope.data.JitterParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.OptionParam;
import com.rigol.scope.data.RefParam;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.WindowParam;
import com.rigol.scope.data.XYParam;
import com.rigol.scope.databinding.FragmentWaveformBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.KtUtilKt;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.StateManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.utilities.WindowHolderManager;
import com.rigol.scope.viewmodels.BodeViewModel;
import com.rigol.scope.viewmodels.CursorViewModel;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.DisplayViewModel;
import com.rigol.scope.viewmodels.EyeViewModel;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.FlexKnobViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.JitterViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.OptionViewModel;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.viewmodels.RefViewModel;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.UpaViewModel;
import com.rigol.scope.viewmodels.ViewABkeyViewModel;
import com.rigol.scope.viewmodels.XYViewModel;
import com.rigol.scope.views.busAnalyse.BusAnalysePopupView;
import com.rigol.scope.views.eye.EyePopupView;
import com.rigol.scope.views.histogram.HistogramResultParam;
import com.rigol.scope.views.histogram.HistogramViewModel;
import com.rigol.scope.views.histogram.MeasHistogramResultParam;
import com.rigol.scope.views.histogram.MeasHistogramViewModel;
import com.rigol.scope.views.jitter.JitterPopupView;
import com.rigol.scope.views.knob.FlexKnobPopupView;
import com.rigol.scope.views.multi.MultiWindow;
import com.rigol.scope.views.multi.MultiWindowPopupView;
import com.rigol.scope.views.rtsa.RtsaPopupView;
import com.rigol.scope.views.wave.WaveIntensityPopupView;
import com.rigol.scope.views.window.AllMeasureWindowHolder;
import com.rigol.scope.views.window.BodeWindowHolder;
import com.rigol.scope.views.window.DecodeTableWindowHolder;
import com.rigol.scope.views.window.EyeWindowHolder;
import com.rigol.scope.views.window.FFTWindowHolder;
import com.rigol.scope.views.window.HistogramWindowHolder;
import com.rigol.scope.views.window.JitterBathtubWindowHolder;
import com.rigol.scope.views.window.JitterHistogramWindowHolder;
import com.rigol.scope.views.window.JitterSpectrumWindowHolder;
import com.rigol.scope.views.window.JitterTrackWindowHolder;
import com.rigol.scope.views.window.MathWindowHolder;
import com.rigol.scope.views.window.MeasureListWindowHolder;
import com.rigol.scope.views.window.PeakSearchWindowHolder;
import com.rigol.scope.views.window.RtsaPeakSearchWindowHolder;
import com.rigol.scope.views.window.SearchRippleWindowHolder;
import com.rigol.scope.views.window.UPAListWindowHolder;
import com.rigol.scope.views.window.UPARippleWindowHolder;
import com.rigol.scope.views.window.WaveformWindowHolder;
import com.rigol.scope.views.window.Window;
import com.rigol.scope.views.window.WindowDirection;
import com.rigol.scope.views.window.WindowHolder;
import com.rigol.scope.views.window.XYWindowHolder;
import com.rigol.util.ToastUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class WaveformFragment extends BaseFragment {
    private FragmentWaveformBinding binding;
    private BodeParam bodeParam;
    private BodeViewModel bodeViewModel;
    private CursorViewModel cursorViewModel;
    private DecodeViewModel decodeViewModel;
    private DisplayViewModel displayViewModel;
    private EyeViewModel eyeViewModel;
    private FlexKnobViewModel flexKnobViewModel;
    private HistogramViewModel histogramViewModel;
    private JitterViewModel jitterViewModel;
    private MathViewModel mathViewModel;
    private MeasHistogramViewModel measHistogramViewModel;
    private OptionViewModel optionViewModel;
    private PanelKeyViewModel panelKeyViewModel;
    private RefViewModel refViewModel;
    private SharedParam sharedParam;
    private ViewABkeyViewModel viewABkeyViewModel;
    private List<MathParam> mathParamList = null;
    private List<DecodeParam> decodeParamList = null;
    private JitterParam jitterParam = null;
    private EyeParam eyeParam = null;
    private OptionParam optionParam = null;
    private FlexKnobParam flexKnobParam = null;
    private RefParam refParam = null;
    private CursorResultParam cursorParam = null;
    private HistogramResultParam histogramResultParam = null;
    private MeasHistogramResultParam measHistogramResultParam = null;
    public Boolean show_is_main = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onViewCreated$32(SharedParam sharedParam) {
    }

    public /* synthetic */ void lambda$onViewCreated$12$WaveformFragment(MeasHistogramResultParam measHistogramResultParam) {
    }

    @Override // com.rigol.scope.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mathViewModel = (MathViewModel) getAppViewModelProvider().get(MathViewModel.class);
        this.eyeViewModel = (EyeViewModel) getAppViewModelProvider().get(EyeViewModel.class);
        this.decodeViewModel = (DecodeViewModel) getAppViewModelProvider().get(DecodeViewModel.class);
        this.jitterViewModel = (JitterViewModel) getAppViewModelProvider().get(JitterViewModel.class);
        this.optionViewModel = (OptionViewModel) getAppViewModelProvider().get(OptionViewModel.class);
        this.panelKeyViewModel = (PanelKeyViewModel) getAppViewModelProvider().get(PanelKeyViewModel.class);
        this.displayViewModel = (DisplayViewModel) getAppViewModelProvider().get(DisplayViewModel.class);
        this.cursorViewModel = (CursorViewModel) getAppViewModelProvider().get(CursorViewModel.class);
        this.viewABkeyViewModel = (ViewABkeyViewModel) getAppViewModelProvider().get(ViewABkeyViewModel.class);
        this.flexKnobViewModel = (FlexKnobViewModel) getAppViewModelProvider().get(FlexKnobViewModel.class);
        this.refViewModel = (RefViewModel) getAppViewModelProvider().get(RefViewModel.class);
        this.histogramViewModel = (HistogramViewModel) getAppViewModelProvider().get(HistogramViewModel.class);
        this.measHistogramViewModel = (MeasHistogramViewModel) getAppViewModelProvider().get(MeasHistogramViewModel.class);
        this.bodeViewModel = (BodeViewModel) getAppViewModelProvider().get(BodeViewModel.class);
        if (this.sharedViewModel != null) {
            this.sharedViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$79oCXBWjRyiaMYo6KCxfNtThNt0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onCreate$0$WaveformFragment((SharedParam) obj);
                }
            });
        }
        BodeViewModel bodeViewModel = this.bodeViewModel;
        if (bodeViewModel != null) {
            bodeViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$l9fXHnGj4itvZn2pxlbi9HXw3X0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onCreate$1$WaveformFragment((BodeParam) obj);
                }
            });
        }
        FlexKnobViewModel flexKnobViewModel = this.flexKnobViewModel;
        if (flexKnobViewModel != null) {
            flexKnobViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$KoDlLoZ5ntIG0Bzo5H9EL4qbA-Q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onCreate$2$WaveformFragment((FlexKnobParam) obj);
                }
            });
        }
        RefViewModel refViewModel = this.refViewModel;
        if (refViewModel != null) {
            refViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$Edj5p3RZh110-N5eM7lcNawmL8k
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onCreate$3$WaveformFragment((RefParam) obj);
                }
            });
        }
        CursorViewModel cursorViewModel = this.cursorViewModel;
        if (cursorViewModel != null) {
            cursorViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$mJw2kDfwTD6UlTzQMPt6GaYbJ7Q
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onCreate$4$WaveformFragment((CursorResultParam) obj);
                }
            });
        }
        HistogramViewModel histogramViewModel = this.histogramViewModel;
        if (histogramViewModel != null) {
            histogramViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$nxjV6R460CFgh_Mc7mIMJYXv93A
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onCreate$5$WaveformFragment((HistogramResultParam) obj);
                }
            });
        }
        MeasHistogramViewModel measHistogramViewModel = this.measHistogramViewModel;
        if (measHistogramViewModel != null) {
            measHistogramViewModel.getLiveData().observe(this, new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$50cLfT5zyGYMDUdgUuTTpgUzSBU
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onCreate$6$WaveformFragment((MeasHistogramResultParam) obj);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onCreate$0$WaveformFragment(SharedParam sharedParam) {
        this.sharedParam = sharedParam;
    }

    public /* synthetic */ void lambda$onCreate$1$WaveformFragment(BodeParam bodeParam) {
        this.bodeParam = bodeParam;
    }

    public /* synthetic */ void lambda$onCreate$2$WaveformFragment(FlexKnobParam flexKnobParam) {
        this.flexKnobParam = flexKnobParam;
    }

    public /* synthetic */ void lambda$onCreate$3$WaveformFragment(RefParam refParam) {
        this.refParam = refParam;
    }

    public /* synthetic */ void lambda$onCreate$4$WaveformFragment(CursorResultParam cursorResultParam) {
        this.cursorParam = cursorResultParam;
    }

    public /* synthetic */ void lambda$onCreate$5$WaveformFragment(HistogramResultParam histogramResultParam) {
        this.histogramResultParam = histogramResultParam;
    }

    public /* synthetic */ void lambda$onCreate$6$WaveformFragment(MeasHistogramResultParam measHistogramResultParam) {
        this.measHistogramResultParam = measHistogramResultParam;
    }

    @Override // com.rigol.scope.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        OptionViewModel optionViewModel = this.optionViewModel;
        if (optionViewModel != null) {
            optionViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$RTIrPITL_tBIly0fc0a5Zoofic0
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onViewCreated$7$WaveformFragment((OptionParam) obj);
                }
            });
        }
        JitterViewModel jitterViewModel = this.jitterViewModel;
        if (jitterViewModel != null) {
            jitterViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$inYlyIVnm_TR59NHcP67kCzBKaY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onViewCreated$8$WaveformFragment((JitterParam) obj);
                }
            });
        }
        EyeViewModel eyeViewModel = this.eyeViewModel;
        if (eyeViewModel != null) {
            eyeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$CIg-7IlCBu8egOxUo84YghRPwYI
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onViewCreated$9$WaveformFragment((EyeParam) obj);
                }
            });
        }
        DecodeViewModel decodeViewModel = this.decodeViewModel;
        if (decodeViewModel != null) {
            decodeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$qeMR20ta4GVcmVgUGdx0trsJufM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onViewCreated$11$WaveformFragment((ArrayList) obj);
                }
            });
        }
        MeasHistogramViewModel measHistogramViewModel = this.measHistogramViewModel;
        if (measHistogramViewModel != null) {
            measHistogramViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$K3EOi6u4te_UxOvJAF_z2ZoH1tg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onViewCreated$12$WaveformFragment((MeasHistogramResultParam) obj);
                }
            });
        }
        MathViewModel mathViewModel = this.mathViewModel;
        if (mathViewModel != null) {
            mathViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$faQ1Km7s-fnxJmw3BZBVk8Mjg84
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onViewCreated$15$WaveformFragment((ArrayList) obj);
                }
            });
        }
        PanelKeyViewModel panelKeyViewModel = this.panelKeyViewModel;
        if (panelKeyViewModel != null) {
            panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$fyNPfz9C6Yl_aNgS8_oWb4qLBDo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WaveformFragment.this.lambda$onViewCreated$16$WaveformFragment((KeyEvent) obj);
                }
            });
        }
        this.syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_HISTO_ENABLE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$N7YBmqjMD_TinK5F1qWfVZ0I9aU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$17$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(21, MessageID.MSG_CURSOR_TYPE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$W_U4zhiZP3yESwp1e5GEDLEhQTo
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$18$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(50, MessageID.MSG_FFT_EN).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$f3HhpkytuTEISkJ0OuuQfvE58WU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$19$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_HISTO_ENABLE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$avjy20QLWBYiVXZaYJ0kxyafndw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$20$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(50, MessageID.MSG_FFT_PEAK_TABLE_EN).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$3xWjE88SiNreLTS1NmR5ku9_DZU
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$21$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(51, MessageID.MSG_EYE_EN).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$ve4nlx5tPrGSlTQI9Ex0rOIJ3r4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$22$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(40, MessageID.MSG_XY_ENABLE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$sRLZZbm1CFJnMj2Y4hMFl-Py23Q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$23$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_ALL_SRC).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$n8Fo4dqnDfiGG6b60DSS-DYF6vg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$24$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(31, MessageID.MSG_UPA_POWER_DISP).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$01VPEbP0E5XrUKl64OeQTPzXeiM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$25$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(52, MessageID.MSG_JITTER_EN).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$uDwKpk0b2PISOTe0WrjfksDEEwg
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$26$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(52, MessageID.MSG_JITTER_TRACK).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$pWzz1dy2hTvst0rTsBIILr7uH9Q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$27$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(52, MessageID.MSG_JITTER_SPEC).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$A5d0VIwLqpLN-sQcFxaAxMpKElM
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$28$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(52, MessageID.MSG_JITTER_HISTO).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$vi4Zmz4ul1tAMjDQxCUzRWXHwHw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$29$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(52, MessageID.MSG_JITTER_CURVE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$QkpHjmbcFamQpoh-lOlZbdrsDc0
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$30$WaveformFragment(obj);
            }
        });
        this.syncDataViewModel.get(36, MessageID.MSG_LICENSE_CHANGED).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$53VxVSogJYcIEC8pcLyI7fPwANk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.this.lambda$onViewCreated$31$WaveformFragment(obj);
            }
        });
        this.sharedViewModel.getLiveData().observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$CBst4jph9IPcdj3VLa7EPQW31Zk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WaveformFragment.lambda$onViewCreated$32((SharedParam) obj);
            }
        });
        PopupViewManager.getInstance().add(MultiWindowPopupView.class, new MultiWindowPopupView());
    }

    public /* synthetic */ void lambda$onViewCreated$7$WaveformFragment(OptionParam optionParam) {
        this.optionParam = optionParam;
    }

    public /* synthetic */ void lambda$onViewCreated$8$WaveformFragment(JitterParam jitterParam) {
        this.jitterParam = jitterParam;
    }

    public /* synthetic */ void lambda$onViewCreated$9$WaveformFragment(EyeParam eyeParam) {
        this.eyeParam = eyeParam;
    }

    public /* synthetic */ void lambda$onViewCreated$11$WaveformFragment(ArrayList arrayList) {
        if (arrayList != null) {
            this.decodeParamList = arrayList;
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                final DecodeParam decodeParam = (DecodeParam) it.next();
                if (decodeParam != null) {
                    this.syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_EVT).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$DPM3Z3J-8mheMXSmnz6ZbXHV8dM
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            WaveformFragment.this.lambda$onViewCreated$10$WaveformFragment(decodeParam, obj);
                        }
                    });
                }
            }
        }
    }

    public /* synthetic */ void lambda$onViewCreated$10$WaveformFragment(DecodeParam decodeParam, Object obj) {
        WindowHolder windowHolderByServiceID = ViewUtil.getWindowHolderByServiceID(ServiceEnum.WindowType.WIN_DECODE, decodeParam.getServiceId());
        if (!decodeParam.isEvent()) {
            if (windowHolderByServiceID != null) {
                WindowHolderManager.getInstance().remove(windowHolderByServiceID);
            }
        } else if (windowHolderByServiceID == null) {
            WindowParam windowParam = new WindowParam();
            windowParam.setServiceID(decodeParam.getServiceId());
            windowParam.setType(ServiceEnum.WindowType.WIN_DECODE);
            addWindow(windowParam);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$15$WaveformFragment(ArrayList arrayList) {
        this.mathParamList = arrayList;
        if (arrayList != null) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                final MathParam mathParam = (MathParam) it.next();
                if (mathParam != null) {
                    this.syncDataViewModel.get(mathParam.getServiceId(), MessageID.MSG_MATH_EN).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$Y08CAzSBf3o0zYrm1qsZurwk_u8
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            WaveformFragment.this.lambda$onViewCreated$13$WaveformFragment(mathParam, obj);
                        }
                    });
                    this.syncDataViewModel.get(mathParam.getServiceId(), MessageID.MSG_MATH_FFT_PEAK_ENABLE).observe(getViewLifecycleOwner(), new Observer() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$MmVzsVMiIYT0vZOqSGxoKD6NB9w
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            WaveformFragment.this.lambda$onViewCreated$14$WaveformFragment(mathParam, obj);
                        }
                    });
                }
            }
        }
    }

    public /* synthetic */ void lambda$onViewCreated$13$WaveformFragment(MathParam mathParam, Object obj) {
        if (obj instanceof Boolean) {
            updateMathWindowState(((Boolean) obj).booleanValue(), mathParam.getServiceId());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$14$WaveformFragment(MathParam mathParam, Object obj) {
        if (obj instanceof Boolean) {
            updateMathPeakWindowState(((Boolean) obj).booleanValue(), mathParam.getServiceId());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$16$WaveformFragment(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(FlexKnobPopupView.class)) {
            ((FlexKnobPopupView) PopupViewManager.getInstance().get(FlexKnobPopupView.class)).dismiss();
        }
        if (!PopupViewManager.getInstance().isShowing() || PopupViewManager.getInstance().isShowing(WaveIntensityPopupView.class)) {
            this.panelKeyViewModel.handleFlexKnob(keyEvent, this.flexKnobParam, this.cursorViewModel.getValue(), this.mathParamList, this.displayViewModel.getValue(), this.refParam, this.decodeParamList, this.viewABkeyViewModel, this.bodeParam);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$17$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateHistogramWinState((Boolean) obj);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$18$WaveformFragment(Object obj) {
        if (obj instanceof Integer) {
            if (((Integer) obj).intValue() == ServiceEnum.CursorView.cursor_view_vert.value1) {
                this.cursorParam.setCursorLineBMode(ServiceEnum.CursorView.cursor_view_vert);
                if (this.viewABkeyViewModel.getAx_boolean() != null) {
                    this.viewABkeyViewModel.getAx_boolean().setValue(false);
                }
                if (this.viewABkeyViewModel.getBx_boolean() != null) {
                    this.viewABkeyViewModel.getBx_boolean().setValue(false);
                }
                if (this.viewABkeyViewModel.getAy_boolean() != null) {
                    this.viewABkeyViewModel.getAy_boolean().setValue(true);
                }
                if (this.viewABkeyViewModel.getBy_boolean() != null) {
                    this.viewABkeyViewModel.getBy_boolean().setValue(true);
                }
            } else {
                this.cursorParam.setCursorLineBMode(ServiceEnum.CursorView.cursor_view_hori);
                if (this.viewABkeyViewModel.getAy_boolean() != null) {
                    this.viewABkeyViewModel.getAy_boolean().setValue(false);
                }
                if (this.viewABkeyViewModel.getBy_boolean() != null) {
                    this.viewABkeyViewModel.getBy_boolean().setValue(false);
                }
                if (this.viewABkeyViewModel.getAx_boolean() != null) {
                    this.viewABkeyViewModel.getAx_boolean().setValue(true);
                }
                if (this.viewABkeyViewModel.getBx_boolean() != null) {
                    this.viewABkeyViewModel.getBx_boolean().setValue(true);
                }
            }
            PopupViewManager.getInstance().setCursorChangeLight(this.cursorViewModel.getValue(), this.viewABkeyViewModel);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$19$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateRtsaWindowState(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$20$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateHistogramWinState((Boolean) obj);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$21$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateRtsaPeakWindowState(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$22$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateEyeWindowState(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$23$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateXYWindowState(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$24$WaveformFragment(Object obj) {
        MeasureSettingParam value;
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel == null || (value = measureSettingViewModel.getLiveData().getValue()) == null) {
            return;
        }
        ServiceEnum.Chan measureAllSrc = value.getMeasureAllSrc();
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_ALL_MEASURE);
        if (measureAllSrc.value1 >= ServiceEnum.Chan.chan1.value1 && measureAllSrc.value1 <= ServiceEnum.Chan.chan4.value1) {
            if (list == null || list.size() == 0) {
                WindowParam windowParam = new WindowParam();
                windowParam.setType(ServiceEnum.WindowType.WIN_ALL_MEASURE);
                windowParam.setSource1(measureAllSrc);
                windowParam.setServiceID(value.getServiceId());
                ((MainActivity) this.mActivity).getWaveformFragment().addWindow(windowParam);
            }
        } else if (list == null || list.size() == 0) {
        } else {
            WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_ALL_MEASURE);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$25$WaveformFragment(Object obj) {
        MeasureSettingParam value;
        MeasureSettingViewModel measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        if (measureSettingViewModel == null || (value = measureSettingViewModel.getLiveData().getValue()) == null) {
            return;
        }
        ServiceEnum.Chan measureAllSrc = value.getMeasureAllSrc();
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_ALL_MEASURE);
        if (measureAllSrc.value1 >= ServiceEnum.Chan.chan1.value1 && measureAllSrc.value1 <= ServiceEnum.Chan.chan4.value1) {
            if (list == null || list.size() == 0) {
                WindowParam windowParam = new WindowParam();
                windowParam.setType(ServiceEnum.WindowType.WIN_ALL_MEASURE);
                windowParam.setSource1(measureAllSrc);
                windowParam.setServiceID(value.getServiceId());
                ((MainActivity) this.mActivity).getWaveformFragment().addWindow(windowParam);
            }
        } else if (list == null || list.size() == 0) {
        } else {
            WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_ALL_MEASURE);
        }
    }

    public /* synthetic */ void lambda$onViewCreated$26$WaveformFragment(Object obj) {
        JitterParam jitterParam = this.jitterParam;
        if (jitterParam == null) {
            return;
        }
        if (jitterParam.isEnabled()) {
            if (this.jitterParam.isTrack()) {
                updateJitterTrackWinState(true);
            }
            if (this.jitterParam.isSpectrum()) {
                updateJitterSpectrumWinState(true);
            }
            if (this.jitterParam.isHistogram()) {
                updateJitterHistogramWinState(true);
            }
            if (this.jitterParam.isBathtubCurve()) {
                updateJitterBathtubCurveWinState(true);
                return;
            }
            return;
        }
        updateJitterTrackWinState(false);
        updateJitterSpectrumWinState(false);
        updateJitterHistogramWinState(false);
        updateJitterBathtubCurveWinState(false);
    }

    public /* synthetic */ void lambda$onViewCreated$27$WaveformFragment(Object obj) {
        JitterParam jitterParam = this.jitterParam;
        if (jitterParam != null && (obj instanceof Boolean) && jitterParam.isEnabled()) {
            updateJitterTrackWinState(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$28$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateJitterSpectrumWinState(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$29$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateJitterHistogramWinState(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$30$WaveformFragment(Object obj) {
        if (obj instanceof Boolean) {
            updateJitterBathtubCurveWinState(((Boolean) obj).booleanValue());
        }
    }

    public /* synthetic */ void lambda$onViewCreated$31$WaveformFragment(Object obj) {
        if (this.optionParam != null) {
            if (!KtUtilKt.functionEnable(ServiceEnum.Function.FUN_FFT, this.optionParam)) {
                PopupViewManager.getInstance().dismiss(RtsaPopupView.class);
            }
            if (!KtUtilKt.functionEnable(ServiceEnum.Function.FUN_EYE, this.optionParam)) {
                PopupViewManager.getInstance().dismiss(EyePopupView.class);
            }
            if (!KtUtilKt.functionEnable(ServiceEnum.Function.FUN_JITTER, this.optionParam)) {
                PopupViewManager.getInstance().dismiss(JitterPopupView.class);
            }
            if (KtUtilKt.functionEnable(ServiceEnum.Function.FUN_BUS_ANALYSE, this.optionParam)) {
                return;
            }
            PopupViewManager.getInstance().dismiss(BusAnalysePopupView.class);
        }
    }

    public FragmentWaveformBinding getBinding() {
        return this.binding;
    }

    public void addWindow(WindowParam windowParam) {
        if (windowParam == null || windowParam.getType() == ServiceEnum.WindowType.WIN_NONE) {
            return;
        }
        if (this.binding.multiWindow.isFull()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
        } else if (!API.getInstance().UI_QueryBool(61, MessageID.MSG_BODE_ENABLE) || windowParam.getType() == ServiceEnum.WindowType.WIN_BODE) {
            if (this.show_is_main.booleanValue() && ServiceEnum.WindowType.WIN_MAIN_WAVEFORM == windowParam.getType()) {
                return;
            }
            ServiceEnum.WindowType type = windowParam.getType();
            WindowHolder windowHolder = null;
            switch (AnonymousClass2.$SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[type.ordinal()]) {
                case 1:
                    this.show_is_main = true;
                    windowHolder = new WaveformWindowHolder(this.mActivity, windowParam);
                    break;
                case 2:
                    FunctionManager.getInstance().xySwitch = true;
                    XYWindowHolder xYWindowHolder = new XYWindowHolder(this.mActivity, windowParam);
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(10, MessageID.MSG_HOR_REFRESH_ULTRAL_ENABLE), null);
                    windowHolder = xYWindowHolder;
                    break;
                case 3:
                    windowHolder = new JitterTrackWindowHolder(this.mActivity, windowParam);
                    break;
                case 4:
                    windowHolder = new JitterSpectrumWindowHolder(this.mActivity, windowParam);
                    break;
                case 5:
                    windowHolder = new JitterHistogramWindowHolder(this.mActivity, windowParam);
                    break;
                case 6:
                    windowHolder = new JitterBathtubWindowHolder(this.mActivity, windowParam);
                    break;
                case 7:
                    windowHolder = new MathWindowHolder(this.mActivity, windowParam);
                    break;
                case 8:
                    windowHolder = new HistogramWindowHolder(this.mActivity, windowParam);
                    break;
                case 9:
                    windowHolder = new FFTWindowHolder(this.mActivity, windowParam);
                    break;
                case 10:
                    windowHolder = new EyeWindowHolder(this.mActivity, windowParam);
                    break;
                case 11:
                    windowHolder = new MeasureListWindowHolder(this.mActivity, windowParam);
                    break;
                case 12:
                    windowHolder = new AllMeasureWindowHolder(this.mActivity, windowParam);
                    break;
                case 13:
                    windowHolder = new DecodeTableWindowHolder(this.mActivity, windowParam);
                    break;
                case 14:
                    windowHolder = new PeakSearchWindowHolder(this.mActivity, windowParam);
                    break;
                case 15:
                    windowHolder = new RtsaPeakSearchWindowHolder(this.mActivity, windowParam);
                    break;
                case 16:
                    if (((UpaViewModel) ContextUtil.getAppViewModel(UpaViewModel.class)).getLiveData().getValue().getDisposeType() == 0) {
                        windowHolder = new UPAListWindowHolder(this.mActivity, windowParam);
                        break;
                    } else {
                        windowHolder = new UPARippleWindowHolder(this.mActivity, windowParam);
                        break;
                    }
                case 17:
                    windowHolder = new BodeWindowHolder(this.mActivity, windowParam);
                    break;
                case 18:
                    windowHolder = new SearchRippleWindowHolder(this.mActivity, windowParam);
                    SearchParam value = ((SearchViewModel) ContextUtil.getAppViewModel(SearchViewModel.class)).getLiveData().getValue();
                    value.saveNavigation(value.readNavigation());
                    break;
                case 19:
                    windowHolder = new BodeWindowHolder(this.mActivity, windowParam);
                    break;
            }
            if (windowHolder != null) {
                WindowHolderManager.getInstance().add(windowHolder);
                if (type == ServiceEnum.WindowType.WIN_JITTER_BATHTUB_CURVE || type == ServiceEnum.WindowType.WIN_JITTER_HISTOGRAM || type == ServiceEnum.WindowType.WIN_JITTER_SPECTRUM || type == ServiceEnum.WindowType.WIN_JITTER_TRACK || type == ServiceEnum.WindowType.WIN_BASET100_ANALYSE_RESULT) {
                    this.binding.multiWindow.addWindow(windowHolder.getWindow(), WindowDirection.BOTTOM);
                } else if (type == ServiceEnum.WindowType.WIN_UPA) {
                    this.binding.multiWindow.addWindow(windowHolder.getWindow(), WindowDirection.BOTTOM);
                } else {
                    this.binding.multiWindow.addWindow(windowHolder.getWindow());
                }
            }
            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$ARstz8980jZkYtF-ySrkBn0xGYs
                @Override // java.lang.Runnable
                public final void run() {
                    WaveformFragment.lambda$addWindow$33();
                }
            }, 200L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.rigol.scope.WaveformFragment$2  reason: invalid class name */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType;

        static {
            int[] iArr = new int[ServiceEnum.WindowType.values().length];
            $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType = iArr;
            try {
                iArr[ServiceEnum.WindowType.WIN_MAIN_WAVEFORM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_XY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_JITTER_TRACK.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_JITTER_SPECTRUM.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_JITTER_HISTOGRAM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_JITTER_BATHTUB_CURVE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_MATH.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_HISTOGRAM.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_FFT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_EYE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_MEASURE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_ALL_MEASURE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_DECODE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_MATH_PEAKSEARCH.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_RTSA_PEAKSEARCH.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_UPA.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_BASET100_ANALYSE_RESULT.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_SEARCH.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$rigol$scope$cil$ServiceEnum$WindowType[ServiceEnum.WindowType.WIN_BODE.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$addWindow$33() {
        MessageBus.getInstance().onSyncData(MessageBus.getKey(60, MessageID.MSG_LA_ENABLE), true);
        ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData().getValue().setShowResultBar(((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData().getValue().getShowResultBar());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.binding = FragmentWaveformBinding.inflate(LayoutInflater.from(this.mActivity));
        WindowParam windowParam = new WindowParam();
        windowParam.setType(ServiceEnum.WindowType.WIN_MAIN_WAVEFORM);
        addWindow(windowParam);
        this.binding.multiWindow.setCallback(new AnonymousClass1(windowParam));
        return this.binding.getRoot();
    }

    /* renamed from: com.rigol.scope.WaveformFragment$1  reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements MultiWindow.Callback {
        final /* synthetic */ WindowParam val$waveformWindowParam;

        AnonymousClass1(WindowParam windowParam) {
            this.val$waveformWindowParam = windowParam;
        }

        @Override // com.rigol.scope.views.multi.MultiWindow.Callback
        public void onClosed(WindowHolder windowHolder) {
            FftParam value;
            int windowCount = WaveformFragment.this.binding.multiWindow.getWindowCount();
            int size = WindowHolderManager.getInstance().size(ServiceEnum.WindowType.WIN_XY);
            if (WaveformFragment.this.sharedParam != null) {
                WaveformFragment.this.sharedParam.setWindowCount(windowCount);
                WaveformFragment.this.sharedParam.setXyWindowCount(size);
            }
            if (windowCount < 1) {
                WaveformFragment.this.addWindow(this.val$waveformWindowParam);
            }
            if (windowHolder.getWindowParam().getType() == ServiceEnum.WindowType.WIN_EYE) {
                if (WaveformFragment.this.eyeParam != null) {
                    WaveformFragment.this.eyeParam.getEnabled().setValue(false);
                }
            } else if (windowHolder.getWindowParam().getType() == ServiceEnum.WindowType.WIN_MATH_PEAKSEARCH) {
                ViewUtil.getMathItem(WaveformFragment.this.mathParamList, windowHolder.getWindowParam().getServiceID() - 17).savePeakSearch(false);
            } else if (windowHolder.getWindowParam().getType() == ServiceEnum.WindowType.WIN_RTSA_PEAKSEARCH) {
                FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
                if (fftViewModel == null || (value = fftViewModel.getLiveData().getValue()) == null) {
                    return;
                }
                value.savePeakTableEn(false);
            } else if (windowHolder.getWindowParam().getType() == ServiceEnum.WindowType.WIN_DECODE) {
                StateManager.INSTANCE.setState(ServiceEnum.WindowType.WIN_DECODE, 1, 4, Integer.valueOf(windowHolder.getWindowParam().getServiceID() - 42), false);
            } else if (windowHolder.getWindowParam().getType() == ServiceEnum.WindowType.WIN_JITTER_TRACK) {
                if (WaveformFragment.this.jitterParam != null) {
                    WaveformFragment.this.jitterParam.setTrack(false);
                }
            } else if (windowHolder.getWindowParam().getType() == ServiceEnum.WindowType.WIN_JITTER_SPECTRUM) {
                if (WaveformFragment.this.jitterParam != null) {
                    WaveformFragment.this.jitterParam.setSpectrum(false);
                }
            } else if (windowHolder.getWindowParam().getType() == ServiceEnum.WindowType.WIN_JITTER_HISTOGRAM) {
                if (WaveformFragment.this.jitterParam != null) {
                    WaveformFragment.this.jitterParam.setHistogram(false);
                }
            } else if (windowHolder.getWindowParam().getType() != ServiceEnum.WindowType.WIN_JITTER_BATHTUB_CURVE || WaveformFragment.this.jitterParam == null) {
            } else {
                WaveformFragment.this.jitterParam.setBathtubCurve(false);
            }
        }

        @Override // com.rigol.scope.views.multi.MultiWindow.Callback
        public void onAdded(Window window) {
            int windowCount = WaveformFragment.this.binding.multiWindow.getWindowCount();
            int size = WindowHolderManager.getInstance().size(ServiceEnum.WindowType.WIN_XY);
            if (WaveformFragment.this.sharedParam != null) {
                WaveformFragment.this.sharedParam.setWindowCount(windowCount);
                WaveformFragment.this.sharedParam.setXyWindowCount(size);
            }
            ThreadUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.rigol.scope.-$$Lambda$WaveformFragment$1$eqhUdykRE62xK2sFb9Z4nlP-obw
                @Override // java.lang.Runnable
                public final void run() {
                    MessageBus.getInstance().onSyncData(MessageBus.getKey(60, MessageID.MSG_LA_ENABLE), true);
                }
            }, 200L);
        }
    }

    private void updateHistogramWinState(Boolean bool) {
        if (this.histogramResultParam == null) {
            return;
        }
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_HISTOGRAM);
        if (!bool.booleanValue()) {
            if (list != null) {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_HISTOGRAM);
            }
        } else if (list != null && list.size() != 0) {
            ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
        } else if (this.binding.multiWindow.isFull()) {
            ToastUtils.showShort((int) R.string.inf_max_multi_window_size);
            this.eyeParam.getEnabled().save(false);
        } else {
            WindowParam windowParam = new WindowParam();
            windowParam.setServiceID(34);
            windowParam.setType(ServiceEnum.WindowType.WIN_HISTOGRAM);
            addWindow(windowParam);
        }
    }

    private void updateRtsaWindowState(boolean z) {
        FftParam value;
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_FFT);
        if (z) {
            if (list != null && list.size() != 0) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
                return;
            } else if (this.binding.multiWindow.isFull()) {
                ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
                FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
                if (fftViewModel == null || (value = fftViewModel.getLiveData().getValue()) == null) {
                    return;
                }
                value.saveEnable(false);
                return;
            } else {
                WindowParam windowParam = new WindowParam();
                windowParam.setType(ServiceEnum.WindowType.WIN_FFT);
                windowParam.setServiceID(50);
                addWindow(windowParam);
                return;
            }
        }
        PopupViewManager.getInstance().dismiss(RtsaPopupView.class);
        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_FFT);
    }

    private void updateRtsaPeakWindowState(boolean z) {
        FftParam value;
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_RTSA_PEAKSEARCH);
        if (z) {
            if (list != null && list.size() != 0) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
                return;
            } else if (this.binding.multiWindow.isFull()) {
                ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
                FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
                if (fftViewModel == null || (value = fftViewModel.getLiveData().getValue()) == null) {
                    return;
                }
                value.savePeakTableEn(false);
                return;
            } else {
                WindowParam windowParam = new WindowParam();
                windowParam.setType(ServiceEnum.WindowType.WIN_RTSA_PEAKSEARCH);
                windowParam.setServiceID(50);
                addWindow(windowParam);
                return;
            }
        }
        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_RTSA_PEAKSEARCH);
    }

    private void updateXYWindowState(boolean z) {
        XYParam value;
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_XY);
        if (z) {
            if (list != null && list.size() != 0) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
                return;
            } else if (this.binding.multiWindow.isFull()) {
                ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
                XYViewModel xYViewModel = (XYViewModel) ContextUtil.getAppViewModel(XYViewModel.class);
                if (xYViewModel == null || (value = xYViewModel.getLiveData().getValue()) == null) {
                    return;
                }
                value.getEnable().save(false);
                return;
            } else {
                WindowParam windowParam = new WindowParam();
                windowParam.setSource1(ServiceEnum.Chan.chan1);
                windowParam.setSource2(ServiceEnum.Chan.chan2);
                windowParam.setServiceID(56);
                windowParam.setType(ServiceEnum.WindowType.WIN_XY);
                addWindow(windowParam);
                return;
            }
        }
        WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_XY);
        ((HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class)).getLiveData().getValue().setXyCheck(false);
    }

    private void updateMathWindowState(boolean z, int i) {
        MathParam mathParam;
        int i2 = i - 17;
        FunctionManager.getInstance().setFlexKnobEnum(ServiceEnum.Function.FUN_MATH, i2, false);
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_MATH);
        WindowHolder windowHolder = null;
        if (list != null && list.size() != 0) {
            for (WindowHolder windowHolder2 : list) {
                if (windowHolder2.getWindowParam().getServiceID() == i) {
                    windowHolder = windowHolder2;
                }
            }
        }
        if (z) {
            if (windowHolder != null) {
                ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
                return;
            } else if (this.binding.multiWindow.isFull()) {
                ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
                List<MathParam> list2 = this.mathParamList;
                if (list2 == null || (mathParam = list2.get(i2)) == null) {
                    return;
                }
                mathParam.saveStatus(false);
                return;
            } else {
                WindowParam windowParam = new WindowParam();
                windowParam.setServiceID(i);
                windowParam.setType(ServiceEnum.WindowType.WIN_MATH);
                addWindow(windowParam);
            }
        } else if (windowHolder != null) {
            WindowHolderManager.getInstance().remove(windowHolder);
        }
        ViewUtil.getFlexKnobParamViewModel().refreshCHList();
    }

    private void updateMathPeakWindowState(boolean z, int i) {
        MathParam mathParam;
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_MATH_PEAKSEARCH);
        WindowHolder windowHolder = null;
        if (list != null && list.size() != 0) {
            for (WindowHolder windowHolder2 : list) {
                if (windowHolder2.getWindowParam().getServiceID() == i) {
                    windowHolder = windowHolder2;
                }
            }
        }
        if (!z) {
            if (windowHolder != null) {
                WindowHolderManager.getInstance().remove(windowHolder);
            }
        } else if (windowHolder != null) {
            ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
        } else if (this.binding.multiWindow.isFull()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
            List<MathParam> list2 = this.mathParamList;
            if (list2 == null || (mathParam = list2.get(i - 17)) == null) {
                return;
            }
            mathParam.savePeakSearch(false);
        } else {
            WindowParam windowParam = new WindowParam();
            windowParam.setServiceID(i);
            windowParam.setType(ServiceEnum.WindowType.WIN_MATH_PEAKSEARCH);
            addWindow(windowParam);
        }
    }

    public void updateJitterTrackWinState(boolean z) {
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_JITTER_TRACK);
        if (!z) {
            if (list != null) {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_JITTER_TRACK);
            }
        } else if (list != null && list.size() != 0) {
            ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
        } else if (this.binding.multiWindow.isFull()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
            JitterParam jitterParam = this.jitterParam;
            if (jitterParam != null) {
                jitterParam.saveTrack(false);
            }
        } else {
            WindowParam windowParam = new WindowParam();
            windowParam.setServiceID(52);
            windowParam.setType(ServiceEnum.WindowType.WIN_JITTER_TRACK);
            addWindow(windowParam);
        }
    }

    public void updateJitterSpectrumWinState(boolean z) {
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_JITTER_SPECTRUM);
        if (!z) {
            if (list != null) {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_JITTER_SPECTRUM);
            }
        } else if (list != null && list.size() != 0) {
            ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
        } else if (this.binding.multiWindow.isFull()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
            JitterParam jitterParam = this.jitterParam;
            if (jitterParam != null) {
                jitterParam.saveSpectrum(false);
            }
        } else {
            WindowParam windowParam = new WindowParam();
            windowParam.setServiceID(52);
            windowParam.setType(ServiceEnum.WindowType.WIN_JITTER_SPECTRUM);
            addWindow(windowParam);
        }
    }

    public void updateJitterHistogramWinState(boolean z) {
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_JITTER_HISTOGRAM);
        if (!z) {
            if (list != null) {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_JITTER_HISTOGRAM);
            }
        } else if (list != null && list.size() != 0) {
            ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
        } else if (this.binding.multiWindow.isFull()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
            JitterParam jitterParam = this.jitterParam;
            if (jitterParam != null) {
                jitterParam.saveHistogram(false);
            }
        } else {
            WindowParam windowParam = new WindowParam();
            windowParam.setServiceID(52);
            windowParam.setType(ServiceEnum.WindowType.WIN_JITTER_HISTOGRAM);
            addWindow(windowParam);
        }
    }

    public void updateJitterBathtubCurveWinState(boolean z) {
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_JITTER_BATHTUB_CURVE);
        if (!z) {
            if (list != null) {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_JITTER_BATHTUB_CURVE);
            }
        } else if (list != null && list.size() != 0) {
            ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
        } else if (this.binding.multiWindow.isFull()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
            JitterParam jitterParam = this.jitterParam;
            if (jitterParam != null) {
                jitterParam.saveBathtubCurve(false);
            }
        } else {
            WindowParam windowParam = new WindowParam();
            windowParam.setServiceID(52);
            windowParam.setType(ServiceEnum.WindowType.WIN_JITTER_BATHTUB_CURVE);
            addWindow(windowParam);
        }
    }

    public void updateEyeWindowState(boolean z) {
        if (this.eyeParam == null) {
            return;
        }
        List<WindowHolder> list = WindowHolderManager.getInstance().get(ServiceEnum.WindowType.WIN_EYE);
        if (!z) {
            if (list != null) {
                WindowHolderManager.getInstance().remove(ServiceEnum.WindowType.WIN_EYE);
            }
        } else if (list != null && list.size() != 0) {
            ToastUtils.showLong(ActivityUtils.getTopActivity().getResources().getString(R.string.inf_window_opened));
        } else if (this.binding.multiWindow.isFull()) {
            ToastUtils.showShort(getResources().getString(R.string.inf_max_multi_window_size));
            this.eyeParam.getEnabled().save(false);
        } else {
            WindowParam windowParam = new WindowParam();
            windowParam.setSource1(ServiceEnum.getChanFromValue1(this.eyeParam.getChan().getValue().intValue()));
            windowParam.setServiceID(51);
            windowParam.setType(ServiceEnum.WindowType.WIN_EYE);
            addWindow(windowParam);
        }
    }
}
