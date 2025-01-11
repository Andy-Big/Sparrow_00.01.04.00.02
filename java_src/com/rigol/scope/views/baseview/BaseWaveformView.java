package com.rigol.scope.views.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.collection.SimpleArrayMap;
import androidx.collection.SparseArrayCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Observable;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.GsonUtils;
import com.rigol.scope.R;
import com.rigol.scope.cil.API;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.LaParam;
import com.rigol.scope.data.MathParam;
import com.rigol.scope.data.MeasureSettingParam;
import com.rigol.scope.data.MessageBus;
import com.rigol.scope.data.SearchParam;
import com.rigol.scope.data.SharedParam;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.data.VerticalParam;
import com.rigol.scope.utilities.ColorUtil;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.FunctionManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.DecodeViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.LaViewModel;
import com.rigol.scope.viewmodels.MathViewModel;
import com.rigol.scope.viewmodels.MeasureSettingViewModel;
import com.rigol.scope.viewmodels.SearchViewModel;
import com.rigol.scope.viewmodels.SharedViewModel;
import com.rigol.scope.viewmodels.SyncDataViewModel;
import com.rigol.scope.viewmodels.TriggerViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.viewmodels.VerticalViewModel;
import com.rigol.scope.views.ChannelTag;
import com.rigol.scope.views.DecodeInfoView;
import com.rigol.scope.views.DecodeTag;
import com.rigol.scope.views.ExpandTag;
import com.rigol.scope.views.SearchTag;
import com.rigol.scope.views.TagView;
import com.rigol.scope.views.TriggerLevelTag;
import com.rigol.scope.views.TriggerLevelTagA;
import com.rigol.scope.views.TriggerLevelTagB;
import com.rigol.scope.views.TriggerPointTag;
import com.rigol.scope.views.window.WindowContent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class BaseWaveformView extends WindowContent {
    private List<DecodeParam> decodeParams;
    private final SparseArrayCompat<TagView> decodeTagList;
    protected DecodeViewModel decodeViewModel;
    protected TagView expandTag;
    private HorizontalParam horizontalParam;
    protected HorizontalViewModel horizontalViewModel;
    private LaParam laParam;
    private LaViewModel laViewModel;
    private List<TextView> list_textview;
    protected MathThresholdLine mathThresholdLine;
    protected MathViewModel mathViewModel;
    protected MeasureHighThresLine measureHighThresLine;
    protected MeasureLowThresLine measureLowThresLine;
    protected MeasureMidThresLine measureMidThresLine;
    private MeasureSettingParam measureParam;
    protected MeasureSettingViewModel measureSettingViewModel;
    private SearchParam searchParam;
    protected SearchTag searchTag;
    protected SearchThresholdLine searchThresholdLine;
    private SearchViewModel searchViewModel;
    protected SyncDataViewModel syncDataViewModel;
    protected ThresholdLine thresholdLine;
    protected TriggerLevelTag triggerLevelTag;
    protected TriggerLevelTagA triggerLevelTagA;
    protected TriggerLevelTagB triggerLevelTagB;
    private TriggerParam triggerParam;
    protected TagView triggerPointTag;
    private TriggerViewModel triggerViewModel;
    protected UpdateUIViewModel updateUIViewModel;
    private List<VerticalParam> verticalParams;
    protected VerticalViewModel verticalViewModel;

    public BaseWaveformView(Context context) {
        super(context);
        this.decodeTagList = new SparseArrayCompat<>();
        this.list_textview = new ArrayList();
        init();
    }

    public BaseWaveformView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.decodeTagList = new SparseArrayCompat<>();
        this.list_textview = new ArrayList();
        init();
    }

    public BaseWaveformView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.decodeTagList = new SparseArrayCompat<>();
        this.list_textview = new ArrayList();
        init();
    }

    @Override // com.rigol.scope.views.window.WindowContent, android.view.View
    protected void onSizeChanged(int i, final int i2, int i3, final int i4) {
        VerticalParam verticalParam;
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            TagView tagView = this.expandTag;
            if (tagView != null) {
                tagView.initPositionEdge();
            }
            TagView tagView2 = this.triggerPointTag;
            if (tagView2 != null) {
                tagView2.initPositionEdge();
            }
        }
        if (i2 != i4) {
            List<VerticalParam> list = this.verticalParams;
            if (list != null && !list.isEmpty()) {
                for (int i5 = 0; i5 < this.verticalParams.size(); i5++) {
                    if (this.verticalParams.get(i5) != null) {
                        Object tagView3 = getTagView(verticalParam.getServiceId() + getClass().getSimpleName() + "-Tag", ChannelTag.class);
                        if (tagView3 instanceof TagView) {
                            ((TagView) tagView3).initPositionEdge();
                        }
                    }
                }
            }
            SparseArrayCompat<TagView> sparseArrayCompat = this.decodeTagList;
            if (sparseArrayCompat != null && !sparseArrayCompat.isEmpty()) {
                for (int i6 = 0; i6 < this.decodeTagList.size(); i6++) {
                    TagView valueAt = this.decodeTagList.valueAt(i6);
                    if (valueAt != null) {
                        valueAt.initPositionEdge();
                    }
                }
            }
            TriggerLevelTag triggerLevelTag = this.triggerLevelTag;
            if (triggerLevelTag != null) {
                triggerLevelTag.initPositionEdge();
            }
            postDelayed(new Runnable() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$h0KVBvjSdx9dq_CIfmmAd944K_U
                @Override // java.lang.Runnable
                public final void run() {
                    BaseWaveformView.this.lambda$onSizeChanged$0$BaseWaveformView(i2, i4);
                }
            }, 200L);
        }
    }

    public /* synthetic */ void lambda$onSizeChanged$0$BaseWaveformView(int i, int i2) {
        TriggerLevelTag triggerLevelTag = this.triggerLevelTag;
        if (triggerLevelTag != null) {
            triggerLevelTag.setPosition(true);
        }
        TriggerLevelTagA triggerLevelTagA = this.triggerLevelTagA;
        if (triggerLevelTagA != null) {
            triggerLevelTagA.setPosition(true);
        }
        TriggerLevelTagB triggerLevelTagB = this.triggerLevelTagB;
        if (triggerLevelTagB != null) {
            triggerLevelTagB.setPosition(true);
        }
        updateChannelTagPosition();
        updateDecodeTagPosition(i, i2);
    }

    private void init() {
        setClipToPadding(false);
        setClipChildren(false);
        this.syncDataViewModel = (SyncDataViewModel) ContextUtil.getAppViewModel(SyncDataViewModel.class);
        this.updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
        this.horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
        this.verticalViewModel = (VerticalViewModel) ContextUtil.getAppViewModel(VerticalViewModel.class);
        this.triggerViewModel = (TriggerViewModel) ContextUtil.getAppViewModel(TriggerViewModel.class);
        this.decodeViewModel = (DecodeViewModel) ContextUtil.getAppViewModel(DecodeViewModel.class);
        this.mathViewModel = (MathViewModel) ContextUtil.getAppViewModel(MathViewModel.class);
        this.measureSettingViewModel = (MeasureSettingViewModel) ContextUtil.getAppViewModel(MeasureSettingViewModel.class);
        this.searchViewModel = (SearchViewModel) ContextUtil.getAppViewModel(SearchViewModel.class);
        LaViewModel laViewModel = (LaViewModel) ContextUtil.getAppViewModel(LaViewModel.class);
        this.laViewModel = laViewModel;
        if (laViewModel != null) {
            this.laParam = laViewModel.getLiveData().getValue();
            this.laViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$dkMW2Ojt-PYFJv_ZrjcJWYaZ-c8
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$1$BaseWaveformView((LaParam) obj);
                }
            });
        }
        TriggerViewModel triggerViewModel = this.triggerViewModel;
        if (triggerViewModel != null) {
            this.triggerParam = triggerViewModel.getLiveData().getValue();
            this.triggerViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$aLOGJBndFrAA99urYBXXMpnql_4
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$2$BaseWaveformView((TriggerParam) obj);
                }
            });
        }
        SearchViewModel searchViewModel = this.searchViewModel;
        if (searchViewModel != null) {
            this.searchParam = searchViewModel.getLiveData().getValue();
            this.searchViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$ga-KNN1YMXEQetCA6qZbBlc0WWo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$3$BaseWaveformView((SearchParam) obj);
                }
            });
        }
        DecodeViewModel decodeViewModel = this.decodeViewModel;
        if (decodeViewModel != null) {
            this.decodeParams = decodeViewModel.getLiveData().getValue();
            this.decodeViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$rxFrmWNcgqsVvHQNjbQv7zCgsXE
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$14$BaseWaveformView((ArrayList) obj);
                }
            });
        }
        MeasureSettingViewModel measureSettingViewModel = this.measureSettingViewModel;
        if (measureSettingViewModel != null) {
            measureSettingViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$Kn8LEhVjVBH6mDa2RtX1SiTZJWM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$24$BaseWaveformView((MeasureSettingParam) obj);
                }
            });
        }
        HorizontalViewModel horizontalViewModel = this.horizontalViewModel;
        if (horizontalViewModel != null) {
            this.horizontalParam = horizontalViewModel.getLiveData().getValue();
            this.horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$ekATTDJX9Rr8uIZUtCJMc4u-Znc
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$25$BaseWaveformView((HorizontalParam) obj);
                }
            });
        }
        MeasureSettingViewModel measureSettingViewModel2 = this.measureSettingViewModel;
        if (measureSettingViewModel2 != null && measureSettingViewModel2 != null) {
            measureSettingViewModel2.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$N7d-WnDhsL20h1uBmQM5CFtzshM
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$26$BaseWaveformView((MeasureSettingParam) obj);
                }
            });
        }
        VerticalViewModel verticalViewModel = this.verticalViewModel;
        if (verticalViewModel != null) {
            this.verticalParams = verticalViewModel.getLiveData().getValue();
            this.verticalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$Kxf1a7GJWeh-snnNt3rupjKn_sc
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$32$BaseWaveformView((ArrayList) obj);
                }
            });
        }
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null) {
            syncDataViewModel.get(41, MessageID.MSG_TRIGGER_TYPE).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$w9zhNDv64EfqqoYy-M34ffGQ9jY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$33$BaseWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(41, MessageID.MSG_TRIGGER_EDGE_SOURCE).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$IdCigVG_aBs159yMi-z15lXy4cY
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$34$BaseWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(41, MessageID.MSG_TRIGGER_COUPLING).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$QOmw_EN7OhOz-YXFyRwMZJl056s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$35$BaseWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(10, MessageID.MSG_HOR_UI_TIME_VIEW_MODE).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$y4MGvLDHHlhaevMKh_n8uRH3mIg
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$36$BaseWaveformView(obj);
                }
            });
            this.syncDataViewModel.get(10, MessageID.MSG_HOR_ZOOM_ON).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$5sm_oSw7j7RpgbqpmwKkC2wGyJs
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$37$BaseWaveformView(obj);
                }
            });
        }
        MathViewModel mathViewModel = this.mathViewModel;
        if (mathViewModel != null) {
            mathViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$R8qfKY1bJsnxVBbnT7n71Etr6eo
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    BaseWaveformView.this.lambda$init$42$BaseWaveformView((ArrayList) obj);
                }
            });
        }
        ((SharedViewModel) ContextUtil.getAppViewModel(SharedViewModel.class)).getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$klbflUhtYwaErba8rYnanMJyIN4
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$43$BaseWaveformView((SharedParam) obj);
            }
        });
    }

    public /* synthetic */ void lambda$init$1$BaseWaveformView(LaParam laParam) {
        this.laParam = laParam;
    }

    public /* synthetic */ void lambda$init$2$BaseWaveformView(TriggerParam triggerParam) {
        this.triggerParam = triggerParam;
    }

    public /* synthetic */ void lambda$init$3$BaseWaveformView(SearchParam searchParam) {
        this.searchParam = searchParam;
        SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
        if (syncDataViewModel != null) {
            syncDataViewModel.bind((LifecycleOwner) ActivityUtils.getTopActivity(), searchParam, this.searchThresholdLine);
        }
    }

    public /* synthetic */ void lambda$init$14$BaseWaveformView(ArrayList arrayList) {
        this.decodeParams = arrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final DecodeParam decodeParam = (DecodeParam) it.next();
            if (decodeParam != null) {
                SyncDataViewModel syncDataViewModel = this.syncDataViewModel;
                if (syncDataViewModel != null) {
                    syncDataViewModel.bind((LifecycleOwner) ActivityUtils.getTopActivity(), decodeParam, this.thresholdLine);
                    this.syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_LABEL).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$7NMbJf9FNi7ZGCpgQGot2UqkhwI
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$4$BaseWaveformView(decodeParam, obj);
                        }
                    });
                    this.syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_TYPE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$nAd3uLch_2l18N5pE27XHbGfQjw
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$5$BaseWaveformView(decodeParam, obj);
                        }
                    });
                    this.syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_SPI_MOSI).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$fWnQe3IakRgd_XN8k0hBm241vek
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$6$BaseWaveformView(decodeParam, obj);
                        }
                    });
                    this.syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_SPI_MISO).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$7BTxbUVAxVjtqClnqm73NFb0vEo
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$7$BaseWaveformView(decodeParam, obj);
                        }
                    });
                    this.syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_RS232_TX).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$Yot3aYtELEgyqnGItwqqlw8R6hY
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$8$BaseWaveformView(decodeParam, obj);
                        }
                    });
                    this.syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_RS232_RX).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$uPL8pROZyneTMjOJFf74j2P0Pw4
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$9$BaseWaveformView(decodeParam, obj);
                        }
                    });
                    this.syncDataViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_POS).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$NEfQJAigPmhCbQvH-ODJ9kQu0rU
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$10$BaseWaveformView(decodeParam, obj);
                        }
                    });
                }
                UpdateUIViewModel updateUIViewModel = this.updateUIViewModel;
                if (updateUIViewModel != null) {
                    updateUIViewModel.get(decodeParam.getServiceId(), MessageID.MSG_DECODE_ONOFF).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$Tz6uSKzJ-yfr99G0CIVbPK5N9UI
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$11$BaseWaveformView(decodeParam, (Boolean) obj);
                        }
                    });
                    this.updateUIViewModel.get(decodeParam.getServiceId(), MessageID.MSG_APP_DECODE_QUERY_CONTENT).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$2qRuPjYLdQ4W3JnBXaUxr_FPl6E
                        @Override // androidx.lifecycle.Observer
                        public final void onChanged(Object obj) {
                            BaseWaveformView.this.lambda$init$12$BaseWaveformView(decodeParam, (Boolean) obj);
                        }
                    });
                }
                postDelayed(new Runnable() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$j8KOD37ZAcvtyoWSUY53PX5LbKk
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseWaveformView.this.lambda$init$13$BaseWaveformView(decodeParam);
                    }
                }, 200L);
            }
        }
    }

    public /* synthetic */ void lambda$init$4$BaseWaveformView(DecodeParam decodeParam, Object obj) {
        updateDecodeLabelVisibility(decodeParam);
    }

    public /* synthetic */ void lambda$init$5$BaseWaveformView(DecodeParam decodeParam, Object obj) {
        updateDecodeVisibility(decodeParam);
        updateDecodeLabelVisibility(decodeParam);
    }

    public /* synthetic */ void lambda$init$6$BaseWaveformView(DecodeParam decodeParam, Object obj) {
        updateDecodeVisibility(decodeParam);
        updateDecodeLabelVisibility(decodeParam);
    }

    public /* synthetic */ void lambda$init$7$BaseWaveformView(DecodeParam decodeParam, Object obj) {
        updateDecodeVisibility(decodeParam);
        updateDecodeLabelVisibility(decodeParam);
    }

    public /* synthetic */ void lambda$init$8$BaseWaveformView(DecodeParam decodeParam, Object obj) {
        updateDecodeVisibility(decodeParam);
        updateDecodeLabelVisibility(decodeParam);
    }

    public /* synthetic */ void lambda$init$9$BaseWaveformView(DecodeParam decodeParam, Object obj) {
        updateDecodeVisibility(decodeParam);
        updateDecodeLabelVisibility(decodeParam);
    }

    public /* synthetic */ void lambda$init$10$BaseWaveformView(DecodeParam decodeParam, Object obj) {
        if (getHeight() != 0) {
            Guideline decodeGuideLine1 = getDecodeGuideLine1(decodeParam);
            if (decodeGuideLine1 != null) {
                decodeGuideLine1.setGuidelinePercent(decodeParam.getGuideline());
            }
            getTagView(decodeParam).setPosition((int) (decodeParam.getGuideline() * getHeight()));
        }
    }

    public /* synthetic */ void lambda$init$11$BaseWaveformView(DecodeParam decodeParam, Boolean bool) {
        updateDecodeVisibility(decodeParam);
        updateDecodeLabelVisibility(decodeParam);
    }

    public /* synthetic */ void lambda$init$12$BaseWaveformView(DecodeParam decodeParam, Boolean bool) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        if (bool.booleanValue()) {
            try {
                String[][][] strArr6 = (String[][][]) GsonUtils.fromJson(API.getInstance().UI_QueryStr(decodeParam.getServiceId(), MessageID.MSG_APP_DECODE_QUERY_CONTENT), (Class<Object>) String[][][].class);
                DecodeInfoView decodeView1 = getDecodeView1(decodeParam);
                DecodeInfoView decodeView2 = getDecodeView2(decodeParam);
                Object tagView = getTagView(decodeParam.getServiceId() + getClass().getSimpleName() + "-Label1", TextView.class);
                Object tagView2 = getTagView(decodeParam.getServiceId() + getClass().getSimpleName() + "-Label2", TextView.class);
                ServiceEnum.WaveView waveView = getClass() == MainWaveformView.class ? ServiceEnum.WaveView.Wave_View_Main : ServiceEnum.WaveView.Wave_View_Zoom;
                if (decodeParam.getType() == ServiceEnum.DecodeBusType.Decode_RS232) {
                    if (decodeView1 != null) {
                        String[][] decodeInfo = ViewUtil.getDecodeInfo(strArr6, ServiceEnum.DecodeBusType.Decode_RS232, waveView, decodeParam.getRs232_tx() == ServiceEnum.Chan.chan_none.value1 ? "RS232-RX" : "RS232-TX");
                        subDecodeInfo(decodeView1, decodeInfo);
                        ((TextView) tagView).setText(ViewUtil.getMappingObject(R.array.msg_decode_type, decodeParam.getType().value1).getStr());
                        if ((tagView instanceof TextView) && decodeInfo != null && decodeInfo.length > 0 && (strArr5 = decodeInfo[0]) != null && strArr5.length >= 4) {
                            ((TextView) tagView).setText(strArr5[3]);
                        }
                    }
                    if (decodeView2 != null) {
                        String[][] decodeInfo2 = ViewUtil.getDecodeInfo(strArr6, ServiceEnum.DecodeBusType.Decode_RS232, waveView, "RS232-RX");
                        subDecodeInfo(decodeView2, decodeInfo2);
                        if (!(tagView2 instanceof TextView) || decodeInfo2 == null || decodeInfo2.length <= 0 || (strArr4 = decodeInfo2[0]) == null || strArr4.length < 4) {
                            return;
                        }
                        ((TextView) tagView2).setText(strArr4[3]);
                    }
                } else if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_SPI) {
                    if (decodeView1 != null) {
                        String[][] decodeInfo3 = ViewUtil.getDecodeInfo(strArr6, decodeParam.getType(), waveView, new Object[0]);
                        subDecodeInfo(decodeView1, decodeInfo3);
                        ((TextView) tagView).setText(ViewUtil.getMappingObject(R.array.msg_decode_type, decodeParam.getType().value1).getStr());
                        if (!(tagView instanceof TextView) || decodeInfo3 == null || decodeInfo3.length <= 0 || (strArr = decodeInfo3[0]) == null || strArr.length < 4) {
                            return;
                        }
                        ((TextView) tagView).setText(strArr[3]);
                    }
                } else {
                    if (decodeView1 != null) {
                        String[][] decodeInfo4 = ViewUtil.getDecodeInfo(strArr6, ServiceEnum.DecodeBusType.Decode_SPI, waveView, decodeParam.getSpi_miso() == ServiceEnum.Chan.chan_none.value1 ? "SPI-MOSI" : "SPI-MISO");
                        subDecodeInfo(decodeView1, decodeInfo4);
                        ((TextView) tagView).setText(ViewUtil.getMappingObject(R.array.msg_decode_type, decodeParam.getType().value1).getStr());
                        if ((tagView instanceof TextView) && decodeInfo4 != null && decodeInfo4.length > 0 && (strArr3 = decodeInfo4[0]) != null && strArr3.length >= 4) {
                            ((TextView) tagView).setText(strArr3[3]);
                        }
                    }
                    if (decodeView2 != null) {
                        String[][] decodeInfo5 = ViewUtil.getDecodeInfo(strArr6, ServiceEnum.DecodeBusType.Decode_SPI, waveView, "SPI-MOSI");
                        subDecodeInfo(decodeView2, decodeInfo5);
                        if (!(tagView2 instanceof TextView) || decodeInfo5 == null || decodeInfo5.length <= 0 || (strArr2 = decodeInfo5[0]) == null || strArr2.length < 4) {
                            return;
                        }
                        ((TextView) tagView2).setText(strArr2[3]);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public /* synthetic */ void lambda$init$13$BaseWaveformView(DecodeParam decodeParam) {
        updateDecodeVisibility(decodeParam);
        updateDecodeLabelVisibility(decodeParam);
        if (getHeight() != 0) {
            Guideline decodeGuideLine1 = getDecodeGuideLine1(decodeParam);
            if (decodeGuideLine1 != null) {
                decodeGuideLine1.setGuidelinePercent(decodeParam.getGuideline());
            }
            getTagView(decodeParam).setPosition((int) (decodeParam.getGuideline() * getHeight()));
        }
    }

    public /* synthetic */ void lambda$init$24$BaseWaveformView(final MeasureSettingParam measureSettingParam) {
        SyncDataViewModel syncDataViewModel;
        if (measureSettingParam == null || (syncDataViewModel = this.syncDataViewModel) == null) {
            return;
        }
        syncDataViewModel.get(28, MessageID.MSG_MEAS_HIGH_THRE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$HsdaH3QoK9aVamN8EmjKiq-EQ-U
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$15$BaseWaveformView(measureSettingParam, obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_MEAS_MID_THRE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$o9_IAbfMAra_Z8iIMxqGBbm_Zss
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$16$BaseWaveformView(measureSettingParam, obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_MEAS_LOW_THRE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$jyV1R_DHS0aGuUcBK5RYJUxgMp8
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$17$BaseWaveformView(measureSettingParam, obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_THRESLINE_DISPLAY).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$wttSah9WAm9HL0rwOuM60VHLOxs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$18$BaseWaveformView(measureSettingParam, obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_THRESLINE_DISPLAY).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$vRFftCHed-vDhCqua8L7LffVi00
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$19$BaseWaveformView(measureSettingParam, obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_THRESLINE_DISPLAY).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$1CimneLaji3C7JLvhh-xiXbwKvk
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$20$BaseWaveformView(measureSettingParam, obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_TH_HIGH_TYPE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$yiuxTOrkP4somp-wpX2DH8gYyfc
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$21$BaseWaveformView(measureSettingParam, obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_TH_HIGH_TYPE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$PKfBHNV6ZbusZK2ZwLl5SI4VG38
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$22$BaseWaveformView(measureSettingParam, obj);
            }
        });
        this.syncDataViewModel.get(28, MessageID.MSG_APP_MEAS_TH_HIGH_TYPE).observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$Aha8Jik5XZleTfcsj1JCBgo-cEs
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BaseWaveformView.this.lambda$init$23$BaseWaveformView(measureSettingParam, obj);
            }
        });
    }

    public /* synthetic */ void lambda$init$15$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureHighThresLine measureHighThresLine = this.measureHighThresLine;
        if (measureHighThresLine != null) {
            measureHighThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdHigh());
        }
    }

    public /* synthetic */ void lambda$init$16$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureMidThresLine measureMidThresLine = this.measureMidThresLine;
        if (measureMidThresLine != null) {
            measureMidThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdMiddle());
        }
    }

    public /* synthetic */ void lambda$init$17$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureLowThresLine measureLowThresLine = this.measureLowThresLine;
        if (measureLowThresLine != null) {
            measureLowThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdLow());
        }
    }

    public /* synthetic */ void lambda$init$18$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureHighThresLine measureHighThresLine = this.measureHighThresLine;
        if (measureHighThresLine != null) {
            measureHighThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdHigh());
        }
    }

    public /* synthetic */ void lambda$init$19$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureMidThresLine measureMidThresLine = this.measureMidThresLine;
        if (measureMidThresLine != null) {
            measureMidThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdMiddle());
        }
    }

    public /* synthetic */ void lambda$init$20$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureLowThresLine measureLowThresLine = this.measureLowThresLine;
        if (measureLowThresLine != null) {
            measureLowThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdLow());
        }
    }

    public /* synthetic */ void lambda$init$21$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureHighThresLine measureHighThresLine = this.measureHighThresLine;
        if (measureHighThresLine != null) {
            measureHighThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdHigh());
        }
    }

    public /* synthetic */ void lambda$init$22$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureMidThresLine measureMidThresLine = this.measureMidThresLine;
        if (measureMidThresLine != null) {
            measureMidThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdMiddle());
        }
    }

    public /* synthetic */ void lambda$init$23$BaseWaveformView(MeasureSettingParam measureSettingParam, Object obj) {
        MeasureLowThresLine measureLowThresLine = this.measureLowThresLine;
        if (measureLowThresLine != null) {
            measureLowThresLine.setPosition(measureSettingParam.getThresholdSource().value1, measureSettingParam.getThresholdLow());
        }
    }

    public /* synthetic */ void lambda$init$25$BaseWaveformView(HorizontalParam horizontalParam) {
        this.horizontalParam = horizontalParam;
    }

    public /* synthetic */ void lambda$init$26$BaseWaveformView(MeasureSettingParam measureSettingParam) {
        this.measureParam = measureSettingParam;
    }

    public /* synthetic */ void lambda$init$32$BaseWaveformView(ArrayList arrayList) {
        SyncDataViewModel syncDataViewModel;
        this.verticalParams = arrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final VerticalParam verticalParam = (VerticalParam) it.next();
            if (verticalParam != null && (syncDataViewModel = this.syncDataViewModel) != null) {
                syncDataViewModel.get(verticalParam.getServiceId(), MessageID.MSG_CHAN_OFFSET_REAL).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$3bB5N6npMuRIQ0ng_b355AkcKBA
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$27$BaseWaveformView(verticalParam, obj);
                    }
                });
                this.syncDataViewModel.get(verticalParam.getServiceId(), MessageID.MSG_CHAN_ACTIVE).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$1hSFONdQDVvGZSSEl59Sw-EZD-U
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$28$BaseWaveformView(verticalParam, obj);
                    }
                });
                this.syncDataViewModel.get(verticalParam.getServiceId(), MessageID.MSG_CHAN_ON_OFF).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$JhKw79dsj_QImNs87DROC7MZBic
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$29$BaseWaveformView(verticalParam, obj);
                    }
                });
                this.syncDataViewModel.get(verticalParam.getServiceId(), MessageID.MSG_CHAN_LABEL_EDIT).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$bmOD6vR0Bbq0cDkeJ3e7mCr6ZSw
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$30$BaseWaveformView(verticalParam, obj);
                    }
                });
                this.syncDataViewModel.get(verticalParam.getServiceId(), MessageID.MSG_CHAN_LABEL_SHOW).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$qpIOmbiqQFHoreMzWglPRGCSbPQ
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$31$BaseWaveformView(verticalParam, obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$init$27$BaseWaveformView(VerticalParam verticalParam, Object obj) {
        checkAndSetTriggerLevelTagPosition(verticalParam);
    }

    public /* synthetic */ void lambda$init$28$BaseWaveformView(VerticalParam verticalParam, Object obj) {
        setLabelViewVisibility(verticalParam);
    }

    public /* synthetic */ void lambda$init$29$BaseWaveformView(VerticalParam verticalParam, Object obj) {
        setLabelViewVisibility(verticalParam);
    }

    public /* synthetic */ void lambda$init$30$BaseWaveformView(VerticalParam verticalParam, Object obj) {
        Object tagView = getTagView(verticalParam.getServiceId() + getClass().getSimpleName() + "-Label", ChannelLabel.class);
        if (tagView instanceof LabelView) {
            ((LabelView) tagView).setText(verticalParam.getLabel());
        }
    }

    public /* synthetic */ void lambda$init$31$BaseWaveformView(VerticalParam verticalParam, Object obj) {
        setLabelViewVisibility(verticalParam);
    }

    public /* synthetic */ void lambda$init$33$BaseWaveformView(Object obj) {
        TriggerParam triggerParam = this.triggerParam;
        if (triggerParam == null) {
            return;
        }
        if (ViewUtil.showTriggerTagAB(triggerParam)) {
            ViewUtil.setVisibility(this.triggerLevelTag, 8);
            ViewUtil.setVisibility(this.triggerLevelTagA, 0);
            ViewUtil.setVisibility(this.triggerLevelTagB, 0);
        } else {
            ViewUtil.setVisibility(this.triggerLevelTag, 0);
            ViewUtil.setVisibility(this.triggerLevelTagA, 8);
            ViewUtil.setVisibility(this.triggerLevelTagB, 8);
        }
        ServiceEnum.TriggerMode triggerMode = this.triggerParam.getTriggerMode();
        if (triggerMode == ServiceEnum.TriggerMode.Trigger_Slope) {
            TriggerParam triggerParam2 = this.triggerParam;
            triggerParam2.setLevel(triggerParam2.getSlopelevelA());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_A), Long.valueOf(this.triggerParam.getSlopelevelA()));
            TriggerParam triggerParam3 = this.triggerParam;
            triggerParam3.setLevelB(triggerParam3.getSlopelevelB());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_B), Long.valueOf(this.triggerParam.getSlopelevelB()));
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Runt) {
            TriggerParam triggerParam4 = this.triggerParam;
            triggerParam4.setLevel(triggerParam4.getRuntlevelA());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_A), Long.valueOf(this.triggerParam.getRuntlevelA()));
            TriggerParam triggerParam5 = this.triggerParam;
            triggerParam5.setLevelB(triggerParam5.getRuntlevelB());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_B), Long.valueOf(this.triggerParam.getRuntlevelB()));
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Over) {
            TriggerParam triggerParam6 = this.triggerParam;
            triggerParam6.setLevel(triggerParam6.getOverlevelA());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_A), Long.valueOf(this.triggerParam.getOverlevelA()));
            TriggerParam triggerParam7 = this.triggerParam;
            triggerParam7.setLevelB(triggerParam7.getOverlevelB());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_B), Long.valueOf(this.triggerParam.getOverlevelB()));
        } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
            TriggerParam triggerParam8 = this.triggerParam;
            triggerParam8.setLevel(triggerParam8.getMilstdlevelA());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_A), Long.valueOf(this.triggerParam.getMilstdlevelA()));
            TriggerParam triggerParam9 = this.triggerParam;
            triggerParam9.setLevelB(triggerParam9.getMilstdlevelB());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL_B), Long.valueOf(this.triggerParam.getMilstdlevelB()));
        } else {
            TriggerParam triggerParam10 = this.triggerParam;
            triggerParam10.setLevel(triggerParam10.getLevel());
            MessageBus.getInstance().onSyncData(MessageBus.getKey(41, MessageID.MSG_TRIGGER_LEVEL), Long.valueOf(this.triggerParam.getLevel()));
        }
    }

    public /* synthetic */ void lambda$init$34$BaseWaveformView(Object obj) {
        TriggerParam triggerParam = this.triggerParam;
        if (triggerParam == null) {
            return;
        }
        TriggerLevelTag triggerLevelTag = this.triggerLevelTag;
        int i = 8;
        if (ViewUtil.showTriggerTag(triggerParam) && !ViewUtil.hideTriggerTag(this.triggerParam)) {
            i = 0;
        }
        ViewUtil.setVisibility(triggerLevelTag, i);
    }

    public /* synthetic */ void lambda$init$35$BaseWaveformView(Object obj) {
        TriggerParam triggerParam = this.triggerParam;
        if (triggerParam == null) {
            return;
        }
        TriggerLevelTag triggerLevelTag = this.triggerLevelTag;
        int i = 8;
        if (ViewUtil.showTriggerTag(triggerParam) && !ViewUtil.hideTriggerTag(this.triggerParam)) {
            i = 0;
        }
        ViewUtil.setVisibility(triggerLevelTag, i);
    }

    public /* synthetic */ void lambda$init$36$BaseWaveformView(Object obj) {
        HorizontalParam horizontalParam = this.horizontalParam;
        if (horizontalParam == null) {
            return;
        }
        if (horizontalParam.getTimeMode() == ServiceEnum.HoriTimeMode.Horizontal_ROLL) {
            ViewUtil.setVisibility(this.triggerPointTag, 8);
            ViewUtil.setVisibility(this.triggerLevelTagA, 8);
            ViewUtil.setVisibility(this.triggerLevelTagB, 8);
            ViewUtil.setVisibility(this.triggerLevelTag, 8);
            return;
        }
        ViewUtil.setVisibility(this.triggerPointTag, 0);
        if (ViewUtil.showTriggerTagAB(this.triggerParam)) {
            ViewUtil.setVisibility(this.triggerLevelTagA, 0);
            ViewUtil.setVisibility(this.triggerLevelTagB, 0);
        } else if (ViewUtil.showTriggerTag(this.triggerParam)) {
            ViewUtil.setVisibility(this.triggerLevelTag, 0);
            if (this.triggerParam.getChan().value1 >= ServiceEnum.Chan.d0.value1) {
                ViewUtil.setVisibility(this.triggerLevelTag, 8);
            }
        }
    }

    public /* synthetic */ void lambda$init$37$BaseWaveformView(Object obj) {
        List<DecodeParam> list = this.decodeParams;
        if (list != null) {
            for (DecodeParam decodeParam : list) {
                updateDecodeVisibility(decodeParam);
                updateDecodeLabelVisibility(decodeParam);
            }
        }
    }

    public /* synthetic */ void lambda$init$42$BaseWaveformView(ArrayList arrayList) {
        SyncDataViewModel syncDataViewModel;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            final MathParam mathParam = (MathParam) it.next();
            if (mathParam != null && (syncDataViewModel = this.syncDataViewModel) != null) {
                syncDataViewModel.get(mathParam.getServiceId(), MessageID.MSG_MATH_LOGIC_S32THRE1).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$m2sQXdaNMZtmofG6Gu8p6AqZavo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$38$BaseWaveformView(mathParam, obj);
                    }
                });
                this.syncDataViewModel.get(mathParam.getServiceId(), MessageID.MSG_MATH_LOGIC_S32THRE2).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$bze1YxAbKcjoNbln9cNvaNWq7gc
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$39$BaseWaveformView(mathParam, obj);
                    }
                });
                this.syncDataViewModel.get(mathParam.getServiceId(), MessageID.MSG_MATH_LOGIC_S32THRE3).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$CTiHBBktdfOhlGivTtQXVUW6WPo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$40$BaseWaveformView(mathParam, obj);
                    }
                });
                this.syncDataViewModel.get(mathParam.getServiceId(), MessageID.MSG_MATH_LOGIC_S32THRE4).observe((LifecycleOwner) getContext(), new Observer() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$gde_eyKqa1kid5YZb_KKuMB8FTs
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        BaseWaveformView.this.lambda$init$41$BaseWaveformView(mathParam, obj);
                    }
                });
            }
        }
    }

    public /* synthetic */ void lambda$init$38$BaseWaveformView(MathParam mathParam, Object obj) {
        if (this.mathThresholdLine == null || !mathParam.getStatus()) {
            return;
        }
        this.mathThresholdLine.setPosition(ServiceEnum.Chan.chan1.value1, mathParam.getThresholdCH1());
    }

    public /* synthetic */ void lambda$init$39$BaseWaveformView(MathParam mathParam, Object obj) {
        if (this.mathThresholdLine == null || !mathParam.getStatus()) {
            return;
        }
        this.mathThresholdLine.setPosition(ServiceEnum.Chan.chan2.value1, mathParam.getThresholdCH2());
    }

    public /* synthetic */ void lambda$init$40$BaseWaveformView(MathParam mathParam, Object obj) {
        if (this.mathThresholdLine == null || !mathParam.getStatus()) {
            return;
        }
        this.mathThresholdLine.setPosition(ServiceEnum.Chan.chan3.value1, mathParam.getThresholdCH3());
    }

    public /* synthetic */ void lambda$init$41$BaseWaveformView(MathParam mathParam, Object obj) {
        if (this.mathThresholdLine == null || !mathParam.getStatus()) {
            return;
        }
        this.mathThresholdLine.setPosition(ServiceEnum.Chan.chan4.value1, mathParam.getThresholdCH4());
    }

    public /* synthetic */ void lambda$init$43$BaseWaveformView(final SharedParam sharedParam) {
        sharedParam.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.rigol.scope.views.baseview.BaseWaveformView.1
            {
                BaseWaveformView.this = this;
            }

            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                if (i == 833) {
                    sharedParam.getShowResultBar();
                }
            }
        });
    }

    private void subDecodeInfo(DecodeInfoView decodeInfoView, String[][] strArr) {
        if (strArr != null && strArr.length > 1) {
            decodeInfoView.setData((String[][]) Arrays.copyOfRange(strArr, 1, strArr.length));
        } else {
            decodeInfoView.setData(null);
        }
    }

    private void updateDecodeLabelVisibility(DecodeParam decodeParam) {
        Object tagView = getTagView(decodeParam.getServiceId() + getClass().getSimpleName() + "-Label1", TextView.class);
        int i = 0;
        if (tagView instanceof TextView) {
            ((TextView) tagView).setVisibility((decodeParam.isLabel() && decodeParam.isOnOff()) ? 0 : 8);
        }
        Object tagView2 = getTagView(decodeParam.getServiceId() + getClass().getSimpleName() + "-Label2", TextView.class);
        if (decodeParam.getType() == ServiceEnum.DecodeBusType.Decode_RS232) {
            if (tagView2 instanceof TextView) {
                TextView textView = (TextView) tagView2;
                if (!decodeParam.isLabel() || !decodeParam.isOnOff() || decodeParam.getRs232_rx() == ServiceEnum.Chan.chan_none.value1 || decodeParam.getRs232_tx() == ServiceEnum.Chan.chan_none.value1) {
                    i = 8;
                }
                textView.setVisibility(i);
            }
        } else if (decodeParam.getType() == ServiceEnum.DecodeBusType.Decode_SPI) {
            if (tagView2 instanceof TextView) {
                TextView textView2 = (TextView) tagView2;
                if (!decodeParam.isLabel() || !decodeParam.isOnOff() || decodeParam.getSpi_mosi() == ServiceEnum.Chan.chan_none.value1 || decodeParam.getSpi_miso() == ServiceEnum.Chan.chan_none.value1) {
                    i = 8;
                }
                textView2.setVisibility(i);
            }
        } else if (tagView2 instanceof TextView) {
            ((TextView) tagView2).setVisibility(8);
        }
    }

    private void setLabelViewVisibility(VerticalParam verticalParam) {
        Object tagView = getTagView(verticalParam.getServiceId() + getClass().getSimpleName() + "-Label", ChannelLabel.class);
        if (verticalParam.getShowLabel() && verticalParam.getStatus() != ServiceEnum.enChanStatus.CHAN_OFF) {
            if (tagView instanceof LabelView) {
                LabelView labelView = (LabelView) tagView;
                labelView.setVisibility(0);
                labelView.setText(verticalParam.getLabel());
            }
        } else if (tagView instanceof LabelView) {
            LabelView labelView2 = (LabelView) tagView;
            if (labelView2.getVisibility() == 0) {
                labelView2.setVisibility(8);
            }
        }
    }

    private void updateDecodeVisibility(final DecodeParam decodeParam) {
        setDecodeViewVisibility(decodeParam, API.getInstance().UI_QueryBool(decodeParam.getServiceId(), MessageID.MSG_DECODE_ONOFF));
        final TagView tagView = getTagView(decodeParam);
        DecodeInfoView decodeView1 = getDecodeView1(decodeParam);
        if (decodeView1 == null) {
            return;
        }
        int top = (decodeView1.getTop() + decodeView1.getBottom()) / 2;
        if (tagView != null) {
            if (top > 0 && top < getHeight()) {
                tagView.setPosition(top);
            } else {
                tagView.setPosition(getHeight() / 2);
            }
            tagView.postDelayed(new Runnable() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$HFZA_DbDnugbMkjEnUn-VAhh2Cg
                @Override // java.lang.Runnable
                public final void run() {
                    BaseWaveformView.lambda$updateDecodeVisibility$44(TagView.this, decodeParam);
                }
            }, 100L);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$HFZA_DbDnugbMkjEnUn-VAhh2Cg.run():void] */
    static /* synthetic */ void lambda$updateDecodeVisibility$44(TagView tagView, DecodeParam decodeParam) {
        tagView.setVisibility(decodeParam.isOnOff() ? 0 : 8);
    }

    private void setDecodeViewVisibility(DecodeParam decodeParam, boolean z) {
        DecodeInfoView decodeView1 = getDecodeView1(decodeParam);
        DecodeInfoView decodeView2 = getDecodeView2(decodeParam);
        int i = 0;
        if (decodeView1 != null) {
            decodeView1.setVisibility(z ? 0 : 8);
        }
        if (decodeParam.getType() == ServiceEnum.DecodeBusType.Decode_RS232) {
            if (decodeView2 != null) {
                if (!z || decodeParam.getRs232_rx() == ServiceEnum.Chan.chan_none.value1 || decodeParam.getRs232_tx() == ServiceEnum.Chan.chan_none.value1) {
                    i = 8;
                }
                decodeView2.setVisibility(i);
            }
        } else if (decodeParam.getType() != ServiceEnum.DecodeBusType.Decode_SPI) {
            if (decodeView2 != null) {
                decodeView2.setVisibility(8);
            }
        } else if (decodeView2 != null) {
            if (!z || decodeParam.getSpi_mosi() == ServiceEnum.Chan.chan_none.value1 || decodeParam.getSpi_miso() == ServiceEnum.Chan.chan_none.value1) {
                i = 8;
            }
            decodeView2.setVisibility(i);
        }
    }

    private void checkAndSetTriggerLevelTagPosition(VerticalParam verticalParam) {
        TriggerParam triggerParam = this.triggerParam;
        if (triggerParam != null && triggerParam.getChan() == verticalParam.getChan()) {
            TriggerLevelTag triggerLevelTag = this.triggerLevelTag;
            if (triggerLevelTag != null) {
                triggerLevelTag.setPosition(false);
            }
            if (this.triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Slope || this.triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Runt || this.triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_Over || this.triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                TriggerLevelTagA triggerLevelTagA = this.triggerLevelTagA;
                if (triggerLevelTagA != null) {
                    triggerLevelTagA.setPosition(false);
                }
                TriggerLevelTagB triggerLevelTagB = this.triggerLevelTagB;
                if (triggerLevelTagB != null) {
                    triggerLevelTagB.setPosition(false);
                }
            }
            this.triggerParam.updateChanScaleOffset();
        }
    }

    public void addDecodeTags() {
        final DecodeParam decodeParam;
        List<DecodeParam> list = this.decodeParams;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (final int i = 0; i < this.decodeParams.size() && (decodeParam = this.decodeParams.get(i)) != null; i++) {
            DecodeTag decodeTag = new DecodeTag(getContext(), null, decodeParam);
            addView(decodeTag, 35, 35);
            ViewUtil.applyToTopAndLeft(getSet(), this, decodeTag);
            this.decodeTagList.append(decodeParam.getServiceId(), decodeTag);
            decodeTag.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.baseview.BaseWaveformView.2
                @Override // com.rigol.scope.views.TagView.Callback
                public void onStart() {
                }

                {
                    BaseWaveformView.this = this;
                }

                @Override // com.rigol.scope.views.TagView.Callback
                public void onMove(int i2, int i3, int i4, int i5) {
                    if (BaseWaveformView.this.getHeight() != 0) {
                        float height = i3 / BaseWaveformView.this.getHeight();
                        DecodeParam decodeParam2 = decodeParam;
                        decodeParam2.setGuideline(decodeParam2.getGuideline() + height);
                        BaseWaveformView.this.setDecodeLinePercent(i3, BaseWaveformView.this.getDecodeGuideLine1(decodeParam));
                        decodeParam.setTempPosition((int) (250.0f - ((decodeParam.getGuideline() + height) * 500.0f)));
                    }
                }

                @Override // com.rigol.scope.views.TagView.Callback
                public void onEnd() {
                    if (decodeParam.getTempPosition() >= -250 && decodeParam.getTempPosition() <= 250) {
                        DecodeParam decodeParam2 = decodeParam;
                        decodeParam2.savePosition(decodeParam2.getTempPosition());
                    }
                    FunctionManager.getInstance().setFlexKnobEnum(ServiceEnum.Function.FUN_DECODE, i, false);
                }
            });
        }
    }

    public void setDecodeLinePercent(int i, Guideline guideline) {
        if (guideline != null) {
            ViewGroup.LayoutParams layoutParams = guideline.getLayoutParams();
            if (!(layoutParams instanceof ConstraintLayout.LayoutParams) || getHeight() == 0) {
                return;
            }
            ((ConstraintLayout.LayoutParams) layoutParams).guidePercent += i / getHeight();
            guideline.setLayoutParams(layoutParams);
        }
    }

    public void addChannelTags() {
        final VerticalParam verticalParam;
        List<VerticalParam> list = this.verticalParams;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.verticalParams.size() && (verticalParam = this.verticalParams.get(i)) != null; i++) {
            ChannelTag channelTag = new ChannelTag(getContext(), null, verticalParam);
            ChannelLabel channelLabel = new ChannelLabel(getContext(), null, verticalParam);
            addView(channelTag, 35, 35);
            addView(channelLabel, -2, -2);
            ViewUtil.applyToTopAndLeft(getSet(), this, channelTag);
            getSet().clone(this);
            getSet().connect(channelLabel.getId(), 3, channelTag.getId(), 3);
            getSet().connect(channelLabel.getId(), 6, channelTag.getId(), 6);
            getSet().setMargin(channelLabel.getId(), 6, 50);
            getSet().setMargin(channelLabel.getId(), 3, -20);
            getSet().applyTo(this);
            channelTag.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.baseview.BaseWaveformView.3
                @Override // com.rigol.scope.views.TagView.Callback
                public void onEnd() {
                }

                @Override // com.rigol.scope.views.TagView.Callback
                public void onStart() {
                }

                {
                    BaseWaveformView.this = this;
                }

                @Override // com.rigol.scope.views.TagView.Callback
                public void onMove(int i2, int i3, int i4, int i5) {
                    VerticalParam verticalParam2 = verticalParam;
                    verticalParam2.moveOffset(((float) verticalParam2.getOffset()) - (((i3 / BaseWaveformView.this.getHeight()) * ((float) verticalParam.getScale())) * 8.0f));
                }
            });
            channelTag.setOnClickListener(new View.OnClickListener() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$DLXUHrd8vbhOjcdzN9ObNTxCXq8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseWaveformView.lambda$addChannelTags$45(VerticalParam.this, view);
                }
            });
            SimpleArrayMap<String, Object> tagViews = getTagViews();
            tagViews.put(verticalParam.getServiceId() + getClass().getSimpleName() + "-Tag", channelTag);
            SimpleArrayMap<String, Object> tagViews2 = getTagViews();
            tagViews2.put(verticalParam.getServiceId() + getClass().getSimpleName() + "-Label", channelLabel);
        }
    }

    /* JADX DEBUG: Method not inlined, still used in: [com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$DLXUHrd8vbhOjcdzN9ObNTxCXq8.onClick(android.view.View):void] */
    static /* synthetic */ void lambda$addChannelTags$45(VerticalParam verticalParam, View view) {
        verticalParam.turnActive();
    }

    public void addDecodeThresLine() {
        if (this.thresholdLine == null) {
            ThresholdLine thresholdLine = new ThresholdLine(getContext(), null);
            this.thresholdLine = thresholdLine;
            addView(thresholdLine, -1, 2);
            ViewUtil.applyToTopAndLeft(getSet(), this, this.thresholdLine);
        }
    }

    public void addSearchThresLine() {
        if (this.searchThresholdLine == null) {
            SearchThresholdLine searchThresholdLine = new SearchThresholdLine(getContext(), null);
            this.searchThresholdLine = searchThresholdLine;
            addView(searchThresholdLine, -1, 2);
            ViewUtil.applyToTopAndLeft(getSet(), this, this.searchThresholdLine);
        }
    }

    public void addMathThresLine() {
        if (this.mathThresholdLine == null) {
            MathThresholdLine mathThresholdLine = new MathThresholdLine(getContext(), null);
            this.mathThresholdLine = mathThresholdLine;
            addView(mathThresholdLine, -1, 2);
            ViewUtil.applyToTopAndLeft(getSet(), this, this.mathThresholdLine);
        }
    }

    public void addMeasureHighThresLine() {
        if (this.measureHighThresLine == null) {
            MeasureHighThresLine measureHighThresLine = new MeasureHighThresLine(getContext(), null);
            this.measureHighThresLine = measureHighThresLine;
            addView(measureHighThresLine, -1, 2);
            ViewUtil.applyToTopAndLeft(getSet(), this, this.measureHighThresLine);
        }
    }

    public void addMeasureMidThresLine() {
        if (this.measureMidThresLine == null) {
            MeasureMidThresLine measureMidThresLine = new MeasureMidThresLine(getContext(), null);
            this.measureMidThresLine = measureMidThresLine;
            addView(measureMidThresLine, -1, 2);
            ViewUtil.applyToTopAndLeft(getSet(), this, this.measureMidThresLine);
        }
    }

    public void addMeasureLowThresLine() {
        if (this.measureLowThresLine == null) {
            MeasureLowThresLine measureLowThresLine = new MeasureLowThresLine(getContext(), null);
            this.measureLowThresLine = measureLowThresLine;
            addView(measureLowThresLine, -1, 2);
            ViewUtil.applyToTopAndLeft(getSet(), this, this.measureLowThresLine);
        }
    }

    public void addSearchTag() {
        this.searchTag = new SearchTag(getContext(), null);
        addView(this.triggerLevelTag, -1, 80);
        ViewUtil.applyToTopAndLeft(getSet(), this, this.triggerLevelTag);
    }

    public void addTriggerLevelTag() {
        if (this.triggerViewModel == null) {
            return;
        }
        TriggerLevelTag triggerLevelTag = new TriggerLevelTag(getContext(), null);
        this.triggerLevelTag = triggerLevelTag;
        triggerLevelTag.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.baseview.BaseWaveformView.4
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
            }

            {
                BaseWaveformView.this = this;
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                VerticalParam verticalItem;
                if (BaseWaveformView.this.triggerParam == null || (verticalItem = ViewUtil.getVerticalItem(BaseWaveformView.this.verticalParams, BaseWaveformView.this.triggerParam.getChan())) == null) {
                    return;
                }
                long scale = ((-i2) * (verticalItem.getScale() * 8)) / BaseWaveformView.this.getHeight();
                long level = BaseWaveformView.this.triggerParam.getLevel() + scale;
                if (level >= (BaseWaveformView.this.triggerParam.getChanScale() * 5) - BaseWaveformView.this.triggerParam.getChanOffset()) {
                    BaseWaveformView.this.triggerParam.saveLevelSync((BaseWaveformView.this.triggerParam.getChanScale() * 5) - BaseWaveformView.this.triggerParam.getChanOffset());
                } else if (level <= ((-BaseWaveformView.this.triggerParam.getChanScale()) * 5) - BaseWaveformView.this.triggerParam.getChanOffset()) {
                    BaseWaveformView.this.triggerParam.saveLevelSync(((-BaseWaveformView.this.triggerParam.getChanScale()) * 5) - BaseWaveformView.this.triggerParam.getChanOffset());
                } else {
                    BaseWaveformView.this.triggerParam.saveLevelSync(BaseWaveformView.this.triggerParam.getLevel() + scale);
                }
            }
        });
        addView(this.triggerLevelTag, -1, 80);
        ViewUtil.applyToTopAndLeft(getSet(), this, this.triggerLevelTag);
    }

    public void addTriggerLevelTagA() {
        if (this.triggerViewModel == null) {
            return;
        }
        TriggerLevelTagA triggerLevelTagA = new TriggerLevelTagA(getContext(), null);
        this.triggerLevelTagA = triggerLevelTagA;
        triggerLevelTagA.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.baseview.BaseWaveformView.5
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
            }

            {
                BaseWaveformView.this = this;
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                VerticalParam verticalItem;
                if (BaseWaveformView.this.triggerParam == null || (verticalItem = ViewUtil.getVerticalItem(BaseWaveformView.this.verticalParams, BaseWaveformView.this.triggerParam.getChan())) == null) {
                    return;
                }
                long scale = ((-i2) * (verticalItem.getScale() * 8)) / BaseWaveformView.this.getHeight();
                ServiceEnum.TriggerMode triggerMode = BaseWaveformView.this.triggerParam.getTriggerMode();
                if (triggerMode == ServiceEnum.TriggerMode.Trigger_Slope) {
                    BaseWaveformView.this.triggerParam.saveSlopeLevelASync(BaseWaveformView.this.triggerParam.getSlopelevelA() + scale);
                } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Over) {
                    BaseWaveformView.this.triggerParam.saveOverLevelASync(BaseWaveformView.this.triggerParam.getOverlevelA() + scale);
                } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Runt) {
                    BaseWaveformView.this.triggerParam.saveRuntLevelASync(BaseWaveformView.this.triggerParam.getRuntlevelA() + scale);
                } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
                    BaseWaveformView.this.triggerParam.saveMilstdLevelASync(BaseWaveformView.this.triggerParam.getMilstdlevelA() + scale);
                }
            }
        });
        addView(this.triggerLevelTagA, -1, 80);
        ViewUtil.applyToTopAndLeft(getSet(), this, this.triggerLevelTagA);
        this.triggerLevelTagA.setVisibility(8);
    }

    public void addTriggerLevelTagB() {
        if (this.triggerViewModel == null) {
            return;
        }
        TriggerLevelTagB triggerLevelTagB = new TriggerLevelTagB(getContext(), null);
        this.triggerLevelTagB = triggerLevelTagB;
        triggerLevelTagB.setCallback(new TagView.Callback() { // from class: com.rigol.scope.views.baseview.BaseWaveformView.6
            @Override // com.rigol.scope.views.TagView.Callback
            public void onEnd() {
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onStart() {
            }

            {
                BaseWaveformView.this = this;
            }

            @Override // com.rigol.scope.views.TagView.Callback
            public void onMove(int i, int i2, int i3, int i4) {
                VerticalParam verticalItem;
                if (BaseWaveformView.this.triggerParam == null || (verticalItem = ViewUtil.getVerticalItem(BaseWaveformView.this.verticalParams, BaseWaveformView.this.triggerParam.getChan())) == null) {
                    return;
                }
                long scale = ((-i2) * (verticalItem.getScale() * 8)) / BaseWaveformView.this.getHeight();
                ServiceEnum.TriggerMode triggerMode = BaseWaveformView.this.triggerParam.getTriggerMode();
                if (triggerMode == ServiceEnum.TriggerMode.Trigger_Slope) {
                    BaseWaveformView.this.triggerParam.saveSlopeLevelBSync(BaseWaveformView.this.triggerParam.getSlopelevelB() + scale);
                    if (BaseWaveformView.this.triggerParam.getSlopeTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        BaseWaveformView.this.triggerParam.saveSlopeLevelASync(BaseWaveformView.this.triggerParam.getSlopelevelA() + scale);
                    } else {
                        BaseWaveformView.this.triggerParam.saveSlopeLevelASync(BaseWaveformView.this.triggerParam.getSlopelevelA());
                    }
                } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Over) {
                    BaseWaveformView.this.triggerParam.saveOverLevelBSync(BaseWaveformView.this.triggerParam.getOverlevelB() + scale);
                    if (BaseWaveformView.this.triggerParam.getOverTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        BaseWaveformView.this.triggerParam.saveOverLevelASync(BaseWaveformView.this.triggerParam.getOverlevelA() + scale);
                    } else {
                        BaseWaveformView.this.triggerParam.saveOverLevelASync(BaseWaveformView.this.triggerParam.getOverlevelA());
                    }
                } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_Runt) {
                    BaseWaveformView.this.triggerParam.saveRuntLevelBSync(BaseWaveformView.this.triggerParam.getRuntlevelB() + scale);
                    if (BaseWaveformView.this.triggerParam.getRuntTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        BaseWaveformView.this.triggerParam.saveRuntLevelASync(BaseWaveformView.this.triggerParam.getRuntlevelA() + scale);
                    } else {
                        BaseWaveformView.this.triggerParam.saveRuntLevelASync(BaseWaveformView.this.triggerParam.getRuntlevelA());
                    }
                } else if (triggerMode == ServiceEnum.TriggerMode.Trigger_1553) {
                    BaseWaveformView.this.triggerParam.saveMilstdLevelBSync(BaseWaveformView.this.triggerParam.getMilstdlevelB() + scale);
                    if (BaseWaveformView.this.triggerParam.getMilstdTrigger_Level_ID() == ServiceEnum.Trigger_Level_ID.Trigger_Level_Double) {
                        BaseWaveformView.this.triggerParam.saveMilstdLevelASync(BaseWaveformView.this.triggerParam.getMilstdlevelA() + scale);
                    } else {
                        BaseWaveformView.this.triggerParam.saveMilstdLevelASync(BaseWaveformView.this.triggerParam.getMilstdlevelA());
                    }
                }
            }
        });
        addView(this.triggerLevelTagB, -1, 80);
        ViewUtil.applyToTopAndLeft(getSet(), this, this.triggerLevelTagB);
        this.triggerLevelTagB.setVisibility(8);
    }

    public void addDecodeViews() {
        List<DecodeParam> list = this.decodeParams;
        if (list == null) {
            return;
        }
        for (DecodeParam decodeParam : list) {
            if (decodeParam != null) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                DecodeInfoView newDecodeView = newDecodeView();
                addView(newDecodeView, -1, 40);
                Guideline newGuideLine = newGuideLine(decodeParam.getGuideline(), 0);
                addGuideLine(newGuideLine);
                bindToGuideLine(newDecodeView, newGuideLine);
                TextView textView = new TextView(getContext(), null);
                textView.setId(View.generateViewId());
                textView.setTextSize(18.0f);
                textView.setTextColor(ColorUtil.getColor(getContext(), decodeParam.getServiceId()));
                textView.setGravity(16);
                textView.setVisibility(8);
                addView(textView, -2, -2);
                getSet().clone(this);
                getSet().connect(textView.getId(), 4, newDecodeView.getId(), 3);
                getSet().connect(textView.getId(), 6, newDecodeView.getId(), 6);
                getSet().setMargin(textView.getId(), 6, 10);
                getSet().applyTo(this);
                DecodeInfoView newDecodeView2 = newDecodeView();
                addView(newDecodeView2, -1, 40);
                getSet().clone(this);
                getSet().connect(newDecodeView2.getId(), 3, newGuideLine.getId(), 3);
                getSet().setMargin(newDecodeView2.getId(), 3, 40);
                getSet().applyTo(this);
                TextView textView2 = new TextView(getContext(), null);
                textView2.setId(View.generateViewId());
                textView2.setTextSize(18.0f);
                textView2.setTextColor(ColorUtil.getColor(getContext(), decodeParam.getServiceId()));
                textView2.setGravity(16);
                textView2.setVisibility(8);
                addView(textView2, -2, -2);
                getSet().clone(this);
                getSet().connect(textView2.getId(), 4, newDecodeView2.getId(), 3);
                getSet().connect(textView2.getId(), 6, newDecodeView2.getId(), 6);
                getSet().setMargin(textView2.getId(), 6, 10);
                getSet().applyTo(this);
                arrayList.add(newDecodeView);
                arrayList.add(newDecodeView2);
                SimpleArrayMap<String, Object> tagViews = getTagViews();
                tagViews.put(decodeParam.getServiceId() + getClass().getSimpleName(), arrayList);
                arrayList2.add(newGuideLine);
                SimpleArrayMap<String, Object> guidelines = getGuidelines();
                guidelines.put(decodeParam.getServiceId() + getClass().getSimpleName(), arrayList2);
                SimpleArrayMap<String, Object> tagViews2 = getTagViews();
                tagViews2.put(decodeParam.getServiceId() + getClass().getSimpleName() + "-Label1", textView);
                SimpleArrayMap<String, Object> tagViews3 = getTagViews();
                tagViews3.put(decodeParam.getServiceId() + getClass().getSimpleName() + "-Label2", textView2);
            }
        }
    }

    private DecodeInfoView newDecodeView() {
        DecodeInfoView decodeInfoView = new DecodeInfoView(getContext(), null);
        decodeInfoView.setId(View.generateViewId());
        decodeInfoView.setVisibility(8);
        return decodeInfoView;
    }

    public void addExpandTag() {
        ExpandTag expandTag = new ExpandTag(getContext(), null);
        this.expandTag = expandTag;
        addView(expandTag, 20, 10);
        ViewUtil.applyToTopAndLeft(getSet(), this, this.expandTag);
        ViewGroup.LayoutParams layoutParams = this.expandTag.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
            layoutParams2.startMargin = -10;
            layoutParams2.topMargin = 2;
        }
        this.expandTag.setLayoutParams(layoutParams);
        postDelayed(new Runnable() { // from class: com.rigol.scope.views.baseview.-$$Lambda$bcwb9jCREkSKya1zoF5TtBmpEPI
            @Override // java.lang.Runnable
            public final void run() {
                BaseWaveformView.this.updateExpandTagPosition();
            }
        }, 200L);
    }

    public void addTriggerPointTag(final boolean z) {
        TriggerPointTag triggerPointTag = new TriggerPointTag(getContext(), null);
        this.triggerPointTag = triggerPointTag;
        addView(triggerPointTag, 30, -1);
        ViewUtil.applyToTopAndLeft(getSet(), this, this.triggerPointTag);
        ViewGroup.LayoutParams layoutParams = this.triggerPointTag.getLayoutParams();
        if (layoutParams instanceof ConstraintLayout.LayoutParams) {
            ((ConstraintLayout.LayoutParams) layoutParams).topMargin = 14;
            this.triggerPointTag.setLayoutParams(layoutParams);
        }
        postDelayed(new Runnable() { // from class: com.rigol.scope.views.baseview.-$$Lambda$BaseWaveformView$OtURgbJvGwK-A48it9kCxV3pdyM
            @Override // java.lang.Runnable
            public final void run() {
                BaseWaveformView.this.lambda$addTriggerPointTag$46$BaseWaveformView(z);
            }
        }, 200L);
    }

    private void updateDecodeTagPosition(int i, int i2) {
        List<DecodeParam> list = this.decodeParams;
        if (list == null) {
            return;
        }
        for (DecodeParam decodeParam : list) {
            if (decodeParam != null) {
                TagView tagView = getTagView(decodeParam);
                if (i2 == 0) {
                    return;
                }
                tagView.setPosition((int) ((tagView.getPosition() * i) / i2));
            }
        }
    }

    private void updateChannelTagPosition() {
        List<VerticalParam> list = this.verticalParams;
        if (list == null || list.isEmpty()) {
            return;
        }
        for (VerticalParam verticalParam : this.verticalParams) {
            updateChannelTagPosition(verticalParam);
        }
    }

    public void updateChannelTagPosition(VerticalParam verticalParam) {
        if (verticalParam == null) {
            return;
        }
        Object tagView = getTagView(verticalParam.getServiceId() + getClass().getSimpleName() + "-Tag", ChannelTag.class);
        if (tagView instanceof ChannelTag) {
            ((ChannelTag) tagView).updatePosition();
        }
    }

    public TagView getTagView(DecodeParam decodeParam) {
        return this.decodeTagList.get(decodeParam.getServiceId());
    }

    public DecodeInfoView getDecodeView1(DecodeParam decodeParam) {
        if (decodeParam == null) {
            return null;
        }
        return (DecodeInfoView) getTagView(decodeParam.getServiceId() + getClass().getSimpleName(), 0, DecodeInfoView.class);
    }

    public DecodeInfoView getDecodeView2(DecodeParam decodeParam) {
        if (decodeParam == null) {
            return null;
        }
        return (DecodeInfoView) getTagView(decodeParam.getServiceId() + getClass().getSimpleName(), 1, DecodeInfoView.class);
    }

    public Guideline getDecodeGuideLine1(DecodeParam decodeParam) {
        if (decodeParam == null) {
            return null;
        }
        return getGuideLine(decodeParam.getServiceId() + getClass().getSimpleName(), 0);
    }

    public Guideline getDecodeGuideLine2(DecodeParam decodeParam) {
        if (decodeParam == null) {
            return null;
        }
        return getGuideLine(decodeParam.getServiceId() + getClass().getSimpleName(), 1);
    }

    public void updateExpandTagPosition() {
        HorizontalParam horizontalParam = this.horizontalParam;
        if (horizontalParam == null) {
            return;
        }
        horizontalParam.readExpandGnd();
        this.expandTag.setPosition(getExpandTagPosition(getWidth()));
    }

    public int getExpandTagPosition(int i) {
        ServiceEnum.HorizontalExpand expandMode;
        HorizontalParam horizontalParam = this.horizontalParam;
        if (horizontalParam == null || i < 0 || (expandMode = horizontalParam.getExpandMode()) == ServiceEnum.HorizontalExpand.Horizontal_Expand_LB) {
            return 0;
        }
        if (expandMode == ServiceEnum.HorizontalExpand.Horizontal_Expand_RB) {
            return getWidth();
        }
        if (expandMode == ServiceEnum.HorizontalExpand.Horizontal_Expand_Center) {
            return getWidth() / 2;
        }
        if (expandMode == ServiceEnum.HorizontalExpand.Horizontal_Expand_Trig) {
            return this.triggerPointTag.getPosition();
        }
        return (int) ((((float) (this.horizontalParam.getExpandGnd() - (-500))) / 1000) * i);
    }

    /* renamed from: updateTriggerPointTagPosition */
    public void lambda$addTriggerPointTag$46$BaseWaveformView(boolean z) {
        HorizontalParam horizontalParam = this.horizontalParam;
        if (horizontalParam == null) {
            return;
        }
        int valuePercent = (int) (ViewUtil.getValuePercent(horizontalParam, 0L, z) * getWidth());
        this.triggerPointTag.setPosition(valuePercent);
        if (this.horizontalParam.getExpandMode() == ServiceEnum.HorizontalExpand.Horizontal_Expand_Trig) {
            this.expandTag.setPosition(valuePercent);
        }
    }

    public void addLaTag() {
        int i;
        LaParam laParam;
        int i2 = 0;
        if (this.laParam.getLaEnable() && this.laParam.getLa_labels_en()) {
            if (this.list_textview.size() != 0) {
                int i3 = 0;
                while (i3 < this.list_textview.size()) {
                    int i4 = i3 + 1;
                    int i5 = i4 * 4;
                    if (Integer.parseInt(this.laParam.getInputLabellist64().get(i5 - 3)) == 1) {
                        this.list_textview.get(i3).setVisibility(0);
                        this.list_textview.get(i3).setText(this.laParam.getInputLabellist64().get(i5 - 1));
                        if (this.horizontalParam.isZoom()) {
                            this.list_textview.get(i3).setY((((Integer.parseInt(this.laParam.getInputLabellist64().get(i5 - 2)) - 5) / this.laParam.getLaProportion()) * getHeight()) / 16);
                        } else {
                            this.list_textview.get(i3).setY(Integer.parseInt(this.laParam.getInputLabellist64().get(i5 - 2)));
                        }
                    } else {
                        this.list_textview.get(i3).setVisibility(8);
                    }
                    i3 = i4;
                }
                return;
            }
            while (i2 < 16) {
                TextView textView = new TextView(getContext());
                i2++;
                textView.setText(this.laParam.getInputLabellist64().get((i2 * 4) - 1));
                textView.setId(generateViewId());
                if (this.horizontalParam.isZoom()) {
                    textView.setY((((Integer.parseInt(this.laParam.getInputLabellist64().get(i - 2)) - 5) / this.laParam.getLaProportion()) * getHeight()) / 16);
                } else {
                    if (this.laParam != null) {
                        textView.setY(Integer.parseInt(laParam.getInputLabellist64().get(i - 2)));
                    }
                }
                addView(textView);
                this.list_textview.add(textView);
            }
            return;
        }
        while (i2 < this.list_textview.size()) {
            this.list_textview.get(i2).setVisibility(8);
            i2++;
        }
    }

    public void upAddLaTag(float f) {
        int i;
        int i2 = 0;
        if (this.laParam.getLaEnable()) {
            if (this.list_textview.size() == 0) {
                while (i2 < 16) {
                    TextView textView = new TextView(getContext());
                    i2++;
                    textView.setText(this.laParam.getInputLabellist64().get((i2 * 4) - 1));
                    textView.setId(generateViewId());
                    textView.setY((((Integer.parseInt(this.laParam.getInputLabellist64().get(i - 2)) - 5) / this.laParam.getLaProportion()) * getHeight()) / 16);
                    addView(textView);
                    this.list_textview.add(textView);
                }
                return;
            }
            int i3 = 0;
            while (i3 < this.list_textview.size()) {
                int i4 = i3 + 1;
                int i5 = i4 * 4;
                if (Integer.parseInt(this.laParam.getInputLabellist64().get(i5 - 3)) == 1) {
                    this.list_textview.get(i3).setVisibility(0);
                    this.list_textview.get(i3).setText(this.laParam.getInputLabellist64().get(i5 - 1));
                    this.list_textview.get(i3).setY((((Integer.parseInt(this.laParam.getInputLabellist64().get(i5 - 2)) - 5) / this.laParam.getLaProportion()) * getHeight()) / 16);
                } else {
                    this.list_textview.get(i3).setVisibility(8);
                }
                i3 = i4;
            }
            return;
        }
        while (i2 < this.list_textview.size()) {
            this.list_textview.get(i2).setVisibility(8);
            i2++;
        }
    }

    public List<TextView> getlist_textview() {
        return this.list_textview;
    }

    public void setAllTag() {
        this.triggerLevelTag.setShowtag(true);
        this.triggerLevelTag.invalidate();
    }

    public void setresetAllTag() {
        this.triggerLevelTag.setShowtag(false);
        this.triggerLevelTag.invalidate();
    }
}
