package com.rigol.scope.views.rtsa;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.rigol.scope.R;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.FftParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterRtsaBasesettingBinding;
import com.rigol.scope.databinding.AdapterRtsaMarkerBinding;
import com.rigol.scope.databinding.AdapterRtsaPeakBinding;
import com.rigol.scope.databinding.PopupviewRtsaBinding;
import com.rigol.scope.utilities.UnitFormat;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.baseview.BasePopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.rtsa.RtsaViewPagerAdapter;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.List;
/* loaded from: classes2.dex */
public class RtsaPopupView extends BasePopupView implements RtsaViewPagerAdapter.OnItemClickCallback {
    private PopupviewRtsaBinding binding;
    private KeyboardPopupView keyboardPopupView;

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public int getTitle() {
        return R.string.msg_fft;
    }

    public RtsaPopupView() {
        super((int) R.style.App_PopupWindow_RTSA);
        PopupviewRtsaBinding inflate = PopupviewRtsaBinding.inflate(LayoutInflater.from(this.context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_fft_module);
        if (list == null) {
            return;
        }
        RtsaViewPagerAdapter rtsaViewPagerAdapter = new RtsaViewPagerAdapter(this.context, list);
        rtsaViewPagerAdapter.setOnItemClickCallback(this);
        this.binding.rtsaViewPager.setAdapter(rtsaViewPagerAdapter);
        new TabLayoutMediator(this.binding.rtsaTabs, this.binding.rtsaViewPager, new TabLayoutMediator.TabConfigurationStrategy() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaPopupView$ZBEC0X75KO6aCyn6PZNXEOEvp38
            @Override // com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
            public final void onConfigureTab(TabLayout.Tab tab, int i) {
                RtsaPopupView.lambda$new$0(tab, i);
            }
        }).attach();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$new$0(TabLayout.Tab tab, int i) {
        TextView textView;
        MappingObject valueAt = ViewUtil.getArray(R.array.msg_fft_module).valueAt(i);
        tab.setCustomView(R.layout.adapter_item_tab);
        if (valueAt == null || (textView = (TextView) tab.getCustomView()) == null) {
            return;
        }
        textView.setText(valueAt.getStr());
        textView.setTextSize(16.0f);
    }

    @Override // com.rigol.scope.views.rtsa.RtsaViewPagerAdapter.OnItemClickCallback
    public void onBasicItemClick(AdapterRtsaBasesettingBinding adapterRtsaBasesettingBinding, final FftParam fftParam, View view) {
        int id = view.getId();
        if (id == R.id.fftCenter_edit_text) {
            fftParam.readCenterAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_hz, fftParam.getCenterAttr().getMaxLongValue(), fftParam.getCenterAttr().getMinLongValue(), fftParam.getCenterAttr().getDefLongValue(), fftParam.getCenter(), new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.1
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.saveCenter(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.fftStart_edit_text) {
            fftParam.readStartAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_hz, fftParam.getStartAttr().getMaxLongValue(), fftParam.getStartAttr().getMinLongValue(), fftParam.getStartAttr().getDefLongValue(), fftParam.getStart(), new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.2
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.saveStart(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.fftEnd_edit_text) {
            fftParam.readEndAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_hz, fftParam.getEndAttr().getMaxLongValue(), fftParam.getEndAttr().getMinLongValue(), fftParam.getEndAttr().getDefLongValue(), fftParam.getEnd(), new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.3
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.saveEnd(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.fftSpan_edit_text) {
            fftParam.readSpanAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_hz, fftParam.getSpanAttr().getMaxLongValue(), fftParam.getSpanAttr().getMinLongValue(), fftParam.getSpanAttr().getDefLongValue(), fftParam.getSpan(), new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.4
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.saveSpan(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.last_span_btn) {
            fftParam.doLastSpan();
        } else if (id == R.id.full_span_btn) {
            fftParam.doFullSpan();
        } else if (id == R.id.rbw_spinner) {
            ViewUtil.showSpinner(this.anchor, view, fftParam.getRBWList(), new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaPopupView$a5DvibD06aUqVg5-g0Q3uJj-kSU
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    RtsaPopupView.lambda$onBasicItemClick$1(FftParam.this, view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.rbw_auto_switch) {
            fftParam.saveAutoRbw(!fftParam.isAutoRbw());
        } else if (id == R.id.window_spinner) {
            ViewUtil.showSpinner(this.anchor, view, (int) R.array.msg_fft_window, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaPopupView$oNRgZXF3f88-NhzZa69gk7zi-TA
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    FftParam.this.saveWindow(ServiceEnum.getfftWindowFromValue1(((MappingObject) obj).getValue()));
                }
            });
        } else if (id == R.id.ref_level_edit_text) {
            fftParam.readRefLevelAttr();
            ViewUtil.showKeyboard(this.anchor, view, fftParam.getUnit(), fftParam.getRefLevelAttr().getMaxLongValue(), fftParam.getRefLevelAttr().getMinLongValue(), fftParam.getRefLevelAttr().getDefLongValue(), fftParam.getRefLevel(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.5
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.saveRefLevel(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.unit_spinner) {
            List<MappingObject> unitSpinnerList = fftParam.getUnitSpinnerList();
            if (unitSpinnerList == null) {
                return;
            }
            ViewUtil.showSpinner(this.anchor, view, unitSpinnerList, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaPopupView$0loX0TIVH3urhtS0XLFpPdxjBuE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    FftParam.this.saveUnit(ServiceEnum.getUnitFromValue1(((MappingObject) obj).getValue()));
                }
            });
        } else if (id == R.id.scale_edit_text) {
            fftParam.readScaleAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_db, fftParam.getScaleAttr().getMaxLongValue(), fftParam.getScaleAttr().getMinLongValue(), fftParam.getScaleAttr().getDefLongValue(), fftParam.getScale(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.6
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.saveScale(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.source_spinner) {
            ViewUtil.showChanSpinner(this.anchor, view, (int) R.array.msg_fft_src, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaPopupView$xsBVWhcLp0pkxBfhhNhGHQcELq0
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    FftParam.this.saveSrc(ServiceEnum.getChanFromValue1(((MappingObject) obj).getValue()));
                }
            });
        } else if (id == R.id.auto_tune_btn) {
            fftParam.doAutoTune();
        } else if (id == R.id.preset_btn) {
            fftParam.doPreset();
        } else if (id == R.id.persistTime_spinner) {
            ViewUtil.showSpinner(this.anchor, view, (int) R.array.msg_display_persistime, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.views.rtsa.-$$Lambda$RtsaPopupView$1L4PkP5HrWGVqu1Tod66o2CinRE
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    FftParam.this.savePersistTime(ServiceEnum.getEWavePersisFromValue1(((MappingObject) obj).getValue()));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onBasicItemClick$1(FftParam fftParam, View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        fftParam.saveRbw(ServiceEnum.getRtsaRBWFromValue1(mappingObject.getValue()));
        fftParam.saveAutoRbw(false);
    }

    @Override // com.rigol.scope.views.rtsa.RtsaViewPagerAdapter.OnItemClickCallback
    public void onMarkerItemClick(AdapterRtsaMarkerBinding adapterRtsaMarkerBinding, FftParam fftParam, View view) {
        int id = view.getId();
        if (id == R.id.checkBox_marker1) {
            if (fftParam.findMarkerById(ServiceEnum.RtsaMarker.Rtsa_Marker1) == null) {
                fftParam.addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker1);
            } else {
                fftParam.removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker1);
            }
        } else if (id == R.id.checkBox_marker2) {
            if (fftParam.findMarkerById(ServiceEnum.RtsaMarker.Rtsa_Marker2) == null) {
                fftParam.addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker2);
            } else {
                fftParam.removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker2);
            }
        } else if (id == R.id.checkBox_marker3) {
            if (fftParam.findMarkerById(ServiceEnum.RtsaMarker.Rtsa_Marker3) == null) {
                fftParam.addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker3);
            } else {
                fftParam.removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker3);
            }
        } else if (id == R.id.checkBox_marker4) {
            if (fftParam.findMarkerById(ServiceEnum.RtsaMarker.Rtsa_Marker4) == null) {
                fftParam.addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker4);
            } else {
                fftParam.removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker4);
            }
        } else if (id == R.id.checkBox_marker5) {
            if (fftParam.findMarkerById(ServiceEnum.RtsaMarker.Rtsa_Marker5) == null) {
                fftParam.addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker5);
            } else {
                fftParam.removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker5);
            }
        } else if (id == R.id.checkBox_marker6) {
            if (fftParam.findMarkerById(ServiceEnum.RtsaMarker.Rtsa_Marker6) == null) {
                fftParam.addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker6);
            } else {
                fftParam.removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker6);
            }
        } else if (id == R.id.checkBox_marker7) {
            if (fftParam.findMarkerById(ServiceEnum.RtsaMarker.Rtsa_Marker7) == null) {
                fftParam.addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker7);
            } else {
                fftParam.removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker7);
            }
        } else if (id == R.id.checkBox_marker8) {
            if (fftParam.findMarkerById(ServiceEnum.RtsaMarker.Rtsa_Marker8) == null) {
                fftParam.addMarker(ServiceEnum.RtsaMarker.Rtsa_Marker8);
            } else {
                fftParam.removeMarker(ServiceEnum.RtsaMarker.Rtsa_Marker8);
            }
        } else if (id == R.id.add_all_btn) {
            fftParam.doAddAllMarker();
        } else if (id == R.id.remove_all_btn) {
            fftParam.doRemoveAllMarker();
        }
    }

    @Override // com.rigol.scope.views.rtsa.RtsaViewPagerAdapter.OnItemClickCallback
    public void onPeakItemClick(AdapterRtsaPeakBinding adapterRtsaPeakBinding, final FftParam fftParam, View view) {
        int id = view.getId();
        if (id == R.id.peaken_switch) {
            fftParam.savePeakEn(!fftParam.isPeakEn());
        } else if (id == R.id.next_peak_btn) {
            fftParam.findNextPeak();
        } else if (id == R.id.left_peak_btn) {
            fftParam.findLeftPeak();
        } else if (id == R.id.right_peak_btn) {
            fftParam.findRightPeak();
        } else if (id == R.id.peak_num_text) {
            fftParam.readPeakNumAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_number, fftParam.getPeakNumAttr().getMaxIntValue(), fftParam.getPeakNumAttr().getMinIntValue(), fftParam.getPeakNumAttr().getDefIntValue(), fftParam.getPeakNum(), new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.7
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.savePeakNum(((Long) t).intValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.threshold_text) {
            fftParam.readPeakThresholdAttr();
            ViewUtil.showKeyboard(this.anchor, view, fftParam.getUnit(), fftParam.getPeakThresholdAttr().getMaxLongValue(), fftParam.getPeakThresholdAttr().getMinLongValue(), fftParam.getPeakThresholdAttr().getDefLongValue(), fftParam.getPeakThreshold(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.8
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.savePeakThreshold(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.excursion_text) {
            fftParam.readExcurAttr();
            ViewUtil.showKeyboard(this.anchor, view, ServiceEnum.Unit.Unit_db, fftParam.getExcurAttr().getMaxLongValue(), fftParam.getExcurAttr().getMinLongValue(), fftParam.getExcurAttr().getDefLongValue(), fftParam.getPeakExcur(), UnitFormat.SI.NANO, new KeyboardListener() { // from class: com.rigol.scope.views.rtsa.RtsaPopupView.9
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    fftParam.savePeakExcur(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    RtsaPopupView.this.keyboardPopupView = keyboardPopupView;
                }
            });
        } else if (id == R.id.peak_table_enswitch) {
            fftParam.savePeakTableEn(!fftParam.isPeakTableEn());
        } else if (id == R.id.Amp_radio_button) {
            fftParam.savePeakOrder(ServiceEnum.enPeakOrder.fft_peak_AmpOrder);
        } else if (id == R.id.Freq_radio_button) {
            fftParam.savePeakOrder(ServiceEnum.enPeakOrder.fft_peak_FreqOrder);
        }
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView
    public void onLocaleChanged() {
        super.onLocaleChanged();
        List<MappingObject> list = ViewUtil.getList((int) R.array.msg_fft_module);
        if (list == null) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            TextView textView = (TextView) this.binding.rtsaTabs.getTabAt(i).getCustomView();
            if (textView != null) {
                textView.setText(list.get(i).getStr());
            }
        }
    }
}
