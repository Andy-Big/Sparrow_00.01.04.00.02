package com.rigol.scope.views.rtsa;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.blankj.utilcode.util.ActivityUtils;
import com.rigol.scope.BaseActivity;
import com.rigol.scope.R;
import com.rigol.scope.adapters.BaseAdapterDelegate;
import com.rigol.scope.adapters.BaseViewHolder;
import com.rigol.scope.adapters.MultiItemTypeAdapter;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.HorizontalParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterRtsaBasesettingBinding;
import com.rigol.scope.databinding.AdapterRtsaMarkerBinding;
import com.rigol.scope.databinding.AdapterRtsaPeakBinding;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.FftViewModel;
import com.rigol.scope.viewmodels.HorizontalViewModel;
import com.rigol.scope.viewmodels.UpdateUIViewModel;
import com.rigol.scope.views.rtsa.RtsaViewPagerAdapter;
import java.util.List;
/* loaded from: classes2.dex */
public class RtsaViewPagerAdapter extends MultiItemTypeAdapter<List<MappingObject>> {
    private BasicDelegate basicDelegate;
    private MarkerDelegate markerDelegate;
    private PeakDelegate peakDelegate;

    /* loaded from: classes2.dex */
    public interface OnItemClickCallback {
        void onBasicItemClick(AdapterRtsaBasesettingBinding adapterRtsaBasesettingBinding, FftParam fftParam, View view);

        void onMarkerItemClick(AdapterRtsaMarkerBinding adapterRtsaMarkerBinding, FftParam fftParam, View view);

        void onPeakItemClick(AdapterRtsaPeakBinding adapterRtsaPeakBinding, FftParam fftParam, View view);
    }

    public RtsaViewPagerAdapter(Context context, List<MappingObject> list) {
        super(context, list);
        this.basicDelegate = new BasicDelegate(R.layout.adapter_rtsa_basesetting);
        this.markerDelegate = new MarkerDelegate(R.layout.adapter_rtsa_marker);
        this.peakDelegate = new PeakDelegate(R.layout.adapter_rtsa_peak);
        this.delegatesManager.addDelegate(this.basicDelegate);
        this.delegatesManager.addDelegate(this.markerDelegate);
        this.delegatesManager.addDelegate(this.peakDelegate);
    }

    /* loaded from: classes2.dex */
    public static class BasicDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener {
        private AdapterRtsaBasesettingBinding binding;
        private HorizontalParam horizontalParam;
        private OnItemClickCallback onItemClickCallback;
        private FftParam param;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public BasicDelegate(int i) {
            super(i);
            FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
            if (fftViewModel != null) {
                fftViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaViewPagerAdapter$BasicDelegate$l4gDftvDVf_8yrAho8DU42nusvs
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RtsaViewPagerAdapter.BasicDelegate.this.lambda$new$0$RtsaViewPagerAdapter$BasicDelegate((FftParam) obj);
                    }
                });
            }
            HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
            if (horizontalViewModel != null) {
                horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaViewPagerAdapter$BasicDelegate$IcsPelRc1GB4KQhoC0l20frkl5U
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RtsaViewPagerAdapter.BasicDelegate.this.lambda$new$1$RtsaViewPagerAdapter$BasicDelegate((HorizontalParam) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$new$0$RtsaViewPagerAdapter$BasicDelegate(FftParam fftParam) {
            this.param = fftParam;
            AdapterRtsaBasesettingBinding adapterRtsaBasesettingBinding = this.binding;
            if (adapterRtsaBasesettingBinding != null) {
                adapterRtsaBasesettingBinding.setParam(fftParam);
            }
            UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
            if (updateUIViewModel != null) {
                updateUIViewModel.bind((BaseActivity) ActivityUtils.getTopActivity(), this.param);
            }
        }

        public /* synthetic */ void lambda$new$1$RtsaViewPagerAdapter$BasicDelegate(HorizontalParam horizontalParam) {
            this.horizontalParam = horizontalParam;
            AdapterRtsaBasesettingBinding adapterRtsaBasesettingBinding = this.binding;
            if (adapterRtsaBasesettingBinding != null) {
                adapterRtsaBasesettingBinding.setHoriParam(horizontalParam);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            MappingObject mappingObject = list.get(i);
            return mappingObject != null && mappingObject.getValue() == ServiceEnum.RtsaModule.RTSA_Basic.value1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterRtsaBasesettingBinding adapterRtsaBasesettingBinding = (AdapterRtsaBasesettingBinding) baseViewHolder.getBinding();
            this.binding = adapterRtsaBasesettingBinding;
            adapterRtsaBasesettingBinding.setParam(this.param);
            this.binding.setHoriParam(this.horizontalParam);
            ViewUtil.setSwitchButton(R.array.msg_fft_rbw_auto, this.binding.rbwAutoSwitch);
            this.binding.fftCenterEditText.setOnClickListener(this);
            this.binding.fftStartEditText.setOnClickListener(this);
            this.binding.fftEndEditText.setOnClickListener(this);
            this.binding.fftSpanEditText.setOnClickListener(this);
            this.binding.lastSpanBtn.setOnClickListener(this);
            this.binding.fullSpanBtn.setOnClickListener(this);
            this.binding.rbwSpinner.setOnClickListener(this);
            this.binding.rbwAutoSwitch.setOnClickListener(this);
            this.binding.windowSpinner.setOnClickListener(this);
            this.binding.refLevelEditText.setOnClickListener(this);
            this.binding.unitSpinner.setOnClickListener(this);
            this.binding.scaleEditText.setOnClickListener(this);
            this.binding.sourceSpinner.setOnClickListener(this);
            this.binding.autoTuneBtn.setOnClickListener(this);
            this.binding.presetBtn.setOnClickListener(this);
            this.binding.persistTimeSpinner.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickCallback onItemClickCallback = this.onItemClickCallback;
            if (onItemClickCallback != null) {
                onItemClickCallback.onBasicItemClick(this.binding, this.param, view);
            }
        }

        public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }
    }

    /* loaded from: classes2.dex */
    public static class MarkerDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener {
        private AdapterRtsaMarkerBinding binding;
        private OnItemClickCallback onItemClickCallback;
        private FftParam param;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public MarkerDelegate(int i) {
            super(i);
            FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
            if (fftViewModel != null) {
                fftViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaViewPagerAdapter$MarkerDelegate$QKHcXFM7UAWCk3sgsf0R-uqbjuc
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RtsaViewPagerAdapter.MarkerDelegate.this.lambda$new$0$RtsaViewPagerAdapter$MarkerDelegate((FftParam) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$new$0$RtsaViewPagerAdapter$MarkerDelegate(FftParam fftParam) {
            this.param = fftParam;
            AdapterRtsaMarkerBinding adapterRtsaMarkerBinding = this.binding;
            if (adapterRtsaMarkerBinding != null) {
                adapterRtsaMarkerBinding.setParam(fftParam);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            MappingObject mappingObject = list.get(i);
            return mappingObject != null && mappingObject.getValue() == ServiceEnum.RtsaModule.RTSA_Marker.value1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterRtsaMarkerBinding adapterRtsaMarkerBinding = (AdapterRtsaMarkerBinding) baseViewHolder.getBinding();
            this.binding = adapterRtsaMarkerBinding;
            adapterRtsaMarkerBinding.setParam(this.param);
            this.binding.checkBoxMarker1.setOnClickListener(this);
            this.binding.checkBoxMarker2.setOnClickListener(this);
            this.binding.checkBoxMarker3.setOnClickListener(this);
            this.binding.checkBoxMarker4.setOnClickListener(this);
            this.binding.checkBoxMarker5.setOnClickListener(this);
            this.binding.checkBoxMarker6.setOnClickListener(this);
            this.binding.checkBoxMarker7.setOnClickListener(this);
            this.binding.checkBoxMarker8.setOnClickListener(this);
            this.binding.addAllBtn.setOnClickListener(this);
            this.binding.removeAllBtn.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickCallback onItemClickCallback = this.onItemClickCallback;
            if (onItemClickCallback != null) {
                onItemClickCallback.onMarkerItemClick(this.binding, this.param, view);
            }
        }

        public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }
    }

    /* loaded from: classes2.dex */
    public static class PeakDelegate extends BaseAdapterDelegate<List<MappingObject>> implements View.OnClickListener {
        private AdapterRtsaPeakBinding binding;
        private HorizontalParam horizontalParam;
        private OnItemClickCallback onItemClickCallback;
        private FftParam param;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public /* bridge */ /* synthetic */ void onBindViewHolder(Object obj, int i, BaseViewHolder baseViewHolder) {
            onBindViewHolder((List) obj, i, (BaseViewHolder<? extends ViewDataBinding>) baseViewHolder);
        }

        public PeakDelegate(int i) {
            super(i);
            FftViewModel fftViewModel = (FftViewModel) ContextUtil.getAppViewModel(FftViewModel.class);
            if (fftViewModel != null) {
                fftViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaViewPagerAdapter$PeakDelegate$o3djBnfabUBl3R822RWwW0KeReo
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RtsaViewPagerAdapter.PeakDelegate.this.lambda$new$0$RtsaViewPagerAdapter$PeakDelegate((FftParam) obj);
                    }
                });
            }
            HorizontalViewModel horizontalViewModel = (HorizontalViewModel) ContextUtil.getAppViewModel(HorizontalViewModel.class);
            if (horizontalViewModel != null) {
                horizontalViewModel.getLiveData().observe((LifecycleOwner) ActivityUtils.getTopActivity(), new Observer() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaViewPagerAdapter$PeakDelegate$ZPYy-9VahDjBeaS_vh9QCFPjHQc
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        RtsaViewPagerAdapter.PeakDelegate.this.lambda$new$1$RtsaViewPagerAdapter$PeakDelegate((HorizontalParam) obj);
                    }
                });
            }
        }

        public /* synthetic */ void lambda$new$0$RtsaViewPagerAdapter$PeakDelegate(FftParam fftParam) {
            this.param = fftParam;
            AdapterRtsaPeakBinding adapterRtsaPeakBinding = this.binding;
            if (adapterRtsaPeakBinding != null) {
                adapterRtsaPeakBinding.setParam(fftParam);
            }
            UpdateUIViewModel updateUIViewModel = (UpdateUIViewModel) ContextUtil.getAppViewModel(UpdateUIViewModel.class);
            if (updateUIViewModel != null) {
                updateUIViewModel.bind((BaseActivity) ActivityUtils.getTopActivity(), this.param);
            }
        }

        public /* synthetic */ void lambda$new$1$RtsaViewPagerAdapter$PeakDelegate(HorizontalParam horizontalParam) {
            this.horizontalParam = horizontalParam;
            AdapterRtsaPeakBinding adapterRtsaPeakBinding = this.binding;
            if (adapterRtsaPeakBinding != null) {
                adapterRtsaPeakBinding.setHoriParam(horizontalParam);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.rigol.scope.adapters.AdapterDelegate
        public boolean isForViewType(List<MappingObject> list, int i) {
            MappingObject mappingObject = list.get(i);
            return mappingObject != null && mappingObject.getValue() == ServiceEnum.RtsaModule.RTSA_Peak.value1;
        }

        protected void onBindViewHolder(List<MappingObject> list, int i, BaseViewHolder<? extends ViewDataBinding> baseViewHolder) {
            AdapterRtsaPeakBinding adapterRtsaPeakBinding = (AdapterRtsaPeakBinding) baseViewHolder.getBinding();
            this.binding = adapterRtsaPeakBinding;
            adapterRtsaPeakBinding.setParam(this.param);
            this.binding.setHoriParam(this.horizontalParam);
            ViewUtil.setSwitchButton(this.binding.peakenSwitch);
            ViewUtil.setSwitchButton(this.binding.peakTableEnswitch);
            this.binding.setAmpOrderMapping(ViewUtil.getMappingObject(R.array.msg_fft_peak_tabelorder, ServiceEnum.enPeakOrder.fft_peak_AmpOrder.value1));
            this.binding.setFreqOrderMapping(ViewUtil.getMappingObject(R.array.msg_fft_peak_tabelorder, ServiceEnum.enPeakOrder.fft_peak_FreqOrder.value1));
            this.binding.peakenSwitch.setOnClickListener(this);
            this.binding.nextPeakBtn.setOnClickListener(this);
            this.binding.leftPeakBtn.setOnClickListener(this);
            this.binding.rightPeakBtn.setOnClickListener(this);
            this.binding.thresholdText.setOnClickListener(this);
            this.binding.excursionText.setOnClickListener(this);
            this.binding.peakNumText.setOnClickListener(this);
            this.binding.AmpRadioButton.setOnClickListener(this);
            this.binding.FreqRadioButton.setOnClickListener(this);
            this.binding.peakTableEnswitch.setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            OnItemClickCallback onItemClickCallback = this.onItemClickCallback;
            if (onItemClickCallback != null) {
                onItemClickCallback.onPeakItemClick(this.binding, this.param, view);
            }
        }

        public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        BasicDelegate basicDelegate = this.basicDelegate;
        if (basicDelegate != null) {
            basicDelegate.setOnItemClickCallback(onItemClickCallback);
        }
        MarkerDelegate markerDelegate = this.markerDelegate;
        if (markerDelegate != null) {
            markerDelegate.setOnItemClickCallback(onItemClickCallback);
        }
        PeakDelegate peakDelegate = this.peakDelegate;
        if (peakDelegate != null) {
            peakDelegate.setOnItemClickCallback(onItemClickCallback);
        }
    }
}
