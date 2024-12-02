package com.rigol.scope.adapters;

import android.content.Context;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.AorBParam;
import com.rigol.scope.data.DecodeParam;
import com.rigol.scope.data.MappingObject;
import com.rigol.scope.databinding.AdapterDecodeSpiBinding;
import com.rigol.scope.databinding.PopupviewDecodeBinding;
import com.rigol.scope.utilities.AorBManager;
import com.rigol.scope.utilities.ContextUtil;
import com.rigol.scope.utilities.PopupViewManager;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.viewmodels.PanelKeyViewModel;
import com.rigol.scope.views.decode.DecodeNewPopupView;
import com.rigol.scope.views.keyboard.KeyboardListener;
import com.rigol.scope.views.keyboard.KeyboardPopupView;
import com.rigol.scope.views.spinner.PopupSpinner;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DecodeSpiAdapter extends RecyclerView.Adapter<DecodeSpiHolder> implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, AorBManager.OnSetTextById, AorBManager.OnTextReset {
    private final View anchorView;
    private AorBManager aorBManager;
    private AdapterDecodeSpiBinding binding;
    private View clickedView;
    private final Context context;
    private boolean isMove;
    private KeyboardPopupView keyboardPopupView;
    private List<AorBParam> list_aorbParam = new ArrayList();
    private List<MappingObject> mappingObjects;
    private PanelKeyViewModel panelKeyViewModel;
    private final DecodeParam param;
    private PopupSpinner popupSpinner;
    private PopupviewDecodeBinding popupviewDecodeBinding;
    private SpinnerAdapter spinnerAdapter;
    private DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder;

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return 1;
    }

    public DecodeSpiAdapter(View view, DecodeParam decodeParam, Context context) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
    }

    public DecodeSpiAdapter(View view, DecodeParam decodeParam, Context context, PopupviewDecodeBinding popupviewDecodeBinding, DecodeNewPopupView.ViewPagerAdapter.ViewPagerHolder viewPagerHolder) {
        this.param = decodeParam;
        this.anchorView = view;
        this.context = context;
        this.popupviewDecodeBinding = popupviewDecodeBinding;
        this.viewPagerHolder = viewPagerHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public DecodeSpiHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        this.binding = AdapterDecodeSpiBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new DecodeSpiHolder(this.binding);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(DecodeSpiHolder decodeSpiHolder, int i) {
        this.binding.setEdgeUpMapping(ViewUtil.getMappingObject(R.array.msg_decode_clk_edge, 0));
        this.binding.setEdgeDownMapping(ViewUtil.getMappingObject(R.array.msg_decode_clk_edge, 1));
        this.binding.setModeTimeoutMapping(ViewUtil.getMappingObject(R.array.msg_decode_spi_mode, 1));
        this.binding.setModeCsMapping(ViewUtil.getMappingObject(R.array.msg_decode_spi_mode, 0));
        this.binding.setEndianMsbMapping(ViewUtil.getMappingObject(R.array.msg_decode_spi_endian, 1));
        this.binding.setEndianLsbMapping(ViewUtil.getMappingObject(R.array.msg_decode_spi_endian, 0));
        this.binding.setPolarityPositiveMapping(ViewUtil.getMappingObject(R.array.msg_decode_dat_pol, 1));
        this.binding.setPolarityNegativeMapping(ViewUtil.getMappingObject(R.array.msg_decode_dat_pol, 0));
        this.binding.setCsPositiveMapping(ViewUtil.getMappingObject(R.array.msg_decode_cs_pol, 1));
        this.binding.setCsNegativeMapping(ViewUtil.getMappingObject(R.array.msg_decode_cs_pol, 0));
        this.binding.decodeSpiModeRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeSpiClkValue.setOnClickListener(this);
        this.binding.decodeSpiMisoValue.setOnClickListener(this);
        this.binding.decodeSpiMosiValue.setOnClickListener(this);
        this.binding.decodeSpiClkThresValue.setOnClickListener(this);
        this.binding.decodeSpiMisoThresValue.setOnClickListener(this);
        this.binding.decodeSpiMosiThresValue.setOnClickListener(this);
        this.binding.decodeSpiCsValue.setOnClickListener(this);
        this.binding.decodeSpiCsThresValue.setOnClickListener(this);
        this.binding.decodeSpiWidthValue.setOnClickListener(this);
        this.binding.decodeSpiClkEdgeRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeSpiEndianRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeSpiPolarityRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeSpiCsPolRadioGroup.setOnCheckedChangeListener(this);
        this.binding.decodeSpiTmoValue.setOnClickListener(this);
        if (this.list_aorbParam.size() > 0) {
            this.list_aorbParam.clear();
        }
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiClkThresValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiMisoThresValue, 0, true, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiMosiThresValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiTmoValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiCsThresValue, 0, false, ViewUtil.KEY_A, 3));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiWidthValue, 0, false, ViewUtil.KEY_A, 0));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiClkValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiMisoValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiMosiValue, 0, false, "", 2));
        this.list_aorbParam.add(new AorBParam(this.binding.decodeSpiCsValue, 0, false, "", 2));
        this.aorBManager = null;
        AorBManager aorBManager = new AorBManager(this.context, this.list_aorbParam, this, this) { // from class: com.rigol.scope.adapters.DecodeSpiAdapter.1
            @Override // com.rigol.scope.utilities.AorBManager
            protected void setSwitch_num(int i2) {
                showKey(DecodeSpiAdapter.this.context, ((AorBParam) DecodeSpiAdapter.this.list_aorbParam.get(i2)).getTextView(), true, ((AorBParam) DecodeSpiAdapter.this.list_aorbParam.get(i2)).getAorb());
            }

            @Override // com.rigol.scope.utilities.AorBManager
            protected void setrecovery_num(int i2) {
                showKey(DecodeSpiAdapter.this.context, ((AorBParam) DecodeSpiAdapter.this.list_aorbParam.get(i2)).getTextView(), false, ((AorBParam) DecodeSpiAdapter.this.list_aorbParam.get(i2)).getAorb());
            }
        };
        this.aorBManager = aorBManager;
        aorBManager.showKey(this.context, this.binding.decodeSpiClkThresValue, true, ViewUtil.KEY_A);
        this.aorBManager.showKey(this.context, this.binding.decodeSpiMisoThresValue, true, ViewUtil.KEY_B);
        this.aorBManager.aorBParam_a = 0;
        this.aorBManager.aorBParam_b = 1;
        PopupViewManager.getInstance().setParamAOrBManager(this.param, this.aorBManager);
        if (this.panelKeyViewModel == null) {
            PanelKeyViewModel panelKeyViewModel = (PanelKeyViewModel) ContextUtil.getAppViewModel(PanelKeyViewModel.class);
            this.panelKeyViewModel = panelKeyViewModel;
            if (panelKeyViewModel != null) {
                panelKeyViewModel.getOnKeyUpData().observe((LifecycleOwner) this.context, new Observer() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$b-0Qt06FgUcGT7ul8mns1Td_8gg
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        DecodeSpiAdapter.this.lambda$onBindViewHolder$2$DecodeSpiAdapter((KeyEvent) obj);
                    }
                });
            }
        }
        this.param.readSpi_clock();
        this.param.readSpi_miso();
        this.param.readSpi_mosi();
        this.param.readSpi_cs();
        this.param.readSpi_width();
        this.param.readSpi_data_polarity();
        this.param.readSpi_mode();
        this.param.readSpi_clock_edge();
        this.param.readSpi_cs_polarity();
        this.param.readSpi_endian();
        this.param.readSpi_data_polarity();
        this.param.readSpi_timeout();
        DecodeParam decodeParam = this.param;
        if (decodeParam.getDecodeThres(decodeParam.getServiceId(), MessageID.MSG_DECODE_CLK_THRE) != this.param.getSpi_clock_thres()) {
            this.param.readSpi_clock_thres();
        }
        DecodeParam decodeParam2 = this.param;
        if (decodeParam2.getDecodeThres(decodeParam2.getServiceId(), MessageID.MSG_DECODE_MISO_THRE) != this.param.getSpi_miso_thres()) {
            this.param.readSpi_miso_thres();
        }
        DecodeParam decodeParam3 = this.param;
        if (decodeParam3.getDecodeThres(decodeParam3.getServiceId(), MessageID.MSG_DECODE_MOSI_THRE) != this.param.getSpi_mosi_thres()) {
            this.param.readSpi_mosi_thres();
        }
        DecodeParam decodeParam4 = this.param;
        if (decodeParam4.getDecodeThres(decodeParam4.getServiceId(), MessageID.MSG_DECODE_CS_THRE) != this.param.getSpi_cs_thres()) {
            this.param.readSpi_cs_thres();
        }
        if (ViewUtil.isDoubleChanDecod()) {
            this.binding.decodeSpiModeCsRadioButton.setVisibility(8);
            this.binding.decodeSpiCsValue.setVisibility(8);
            this.binding.decodeSpiCsLabel.setVisibility(8);
        }
        this.binding.setParam(this.param);
        this.binding.executePendingBindings();
    }

    public /* synthetic */ void lambda$onBindViewHolder$2$DecodeSpiAdapter(KeyEvent keyEvent) {
        if (PopupViewManager.getInstance().isShowing(DecodeNewPopupView.class) && this.viewPagerHolder.getLayoutPosition() == this.popupviewDecodeBinding.tabs.getSelectedTabPosition()) {
            this.panelKeyViewModel.abSwitch(keyEvent, this.clickedView, this.popupSpinner, this.mappingObjects, this.spinnerAdapter, this.aorBManager, this.keyboardPopupView, new AorBManager.OnKeyboardItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$kbIYu5_qlECDnUtjjIXoLJkOqDo
                @Override // com.rigol.scope.utilities.AorBManager.OnKeyboardItemChangeListener
                public final void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeSpiAdapter.this.lambda$onBindViewHolder$0$DecodeSpiAdapter(keyboardPopupView);
                }
            }, new AorBManager.OnSpinnerItemChangeListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$dtVbNZu_5qPxCniBSuW45PeEoOY
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerItemChangeListener
                public final void onCall(int i, MappingObject mappingObject) {
                    DecodeSpiAdapter.this.lambda$onBindViewHolder$1$DecodeSpiAdapter(i, mappingObject);
                }
            });
        }
    }

    public /* synthetic */ void lambda$onBindViewHolder$0$DecodeSpiAdapter(KeyboardPopupView keyboardPopupView) {
        this.keyboardPopupView = keyboardPopupView;
    }

    public /* synthetic */ void lambda$onBindViewHolder$1$DecodeSpiAdapter(int i, MappingObject mappingObject) {
        View view = this.clickedView;
        if (view == null) {
            return;
        }
        switch (view.getId()) {
            case R.id.decode_spi_clk_value /* 2131362599 */:
                selectClkValue(mappingObject);
                return;
            case R.id.decode_spi_cs_value /* 2131362607 */:
                selectCSValue(mappingObject);
                return;
            case R.id.decode_spi_miso_value /* 2131362616 */:
                selectMisoValue(mappingObject);
                return;
            case R.id.decode_spi_mosi_value /* 2131362624 */:
                selectMosiValue(mappingObject);
                return;
            default:
                return;
        }
    }

    private void selectCSValue(MappingObject mappingObject) {
        this.param.saveSpi_cs(mappingObject.getValue());
    }

    private void selectMosiValue(MappingObject mappingObject) {
        this.param.saveSpi_mosi(mappingObject.getValue());
    }

    private void selectMisoValue(MappingObject mappingObject) {
        this.param.saveSpi_miso(mappingObject.getValue());
    }

    private void selectClkValue(MappingObject mappingObject) {
        this.param.saveSpi_clock(mappingObject.getValue());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.decode_spi_clk_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_spi_clk)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$suxTZb27-KIh4-N4m58S3ei7sYY
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeSpiAdapter.this.lambda$onClick$3$DecodeSpiAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$edsLeWtQCXV9L3wb9fV0pYbTZBM
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSpiAdapter.this.lambda$onClick$4$DecodeSpiAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_spi_miso_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(this.param.getMisoChanList()), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$oeCG_T48AMv9JhKQKMXqARVdBcU
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeSpiAdapter.this.lambda$onClick$5$DecodeSpiAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$LZq84oINMmrKA4zu3IdGv9-iZBc
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSpiAdapter.this.lambda$onClick$6$DecodeSpiAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_spi_mosi_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(this.param.getMosiChanList()), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$1eV9nQvU5Wc-GnzhqrXB2NA-Vg0
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeSpiAdapter.this.lambda$onClick$7$DecodeSpiAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$CqQtUOhYZ7JKyLhBMVNrgL5QEWQ
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSpiAdapter.this.lambda$onClick$8$DecodeSpiAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_spi_cs_value) {
            ViewUtil.showChanSpinner(this.anchorView, view, ViewUtil.filterChan(ViewUtil.getList((int) R.array.msg_decode_spi_cs)), new AorBManager.OnSpinnerAdapterListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$_BD0aUFrO4u1Cw9q5SW1r1JVYew
                @Override // com.rigol.scope.utilities.AorBManager.OnSpinnerAdapterListener
                public final void onSpinnerAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view2) {
                    DecodeSpiAdapter.this.lambda$onClick$9$DecodeSpiAdapter(popupSpinner, spinnerAdapter, list, view2);
                }
            }, new PopupSpinner.OnItemClickListener() { // from class: com.rigol.scope.adapters.-$$Lambda$DecodeSpiAdapter$_yCkbqUJzcR2qHhU8NhAY6ksiCs
                @Override // com.rigol.scope.views.spinner.PopupSpinner.OnItemClickListener
                public final void onItemClick(View view2, RecyclerView.ViewHolder viewHolder, int i, Object obj) {
                    DecodeSpiAdapter.this.lambda$onClick$10$DecodeSpiAdapter(view2, viewHolder, i, (MappingObject) obj);
                }
            });
        } else if (id == R.id.decode_spi_cs_thres_value) {
            this.param.readSpi_cs_thres();
            this.param.readSpiCsThresAttr();
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getSpiCsThresAttr().getMaxLongValue(), this.param.getSpiCsThresAttr().getMinLongValue(), this.param.getSpiCsThresAttr().getDefLongValue(), this.param.getSpi_cs_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSpiAdapter.2
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeSpiAdapter.this.param.saveSpi_cs_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_spi_miso_thres_value) {
            this.param.readSpi_miso_thres();
            this.param.readSpiMisoThresAttr();
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getSpiMisoThresAttr().getMaxLongValue(), this.param.getSpiMisoThresAttr().getMinLongValue(), this.param.getSpiMisoThresAttr().getDefLongValue(), this.param.getSpi_miso_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSpiAdapter.3
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeSpiAdapter.this.param.saveSpi_miso_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_spi_mosi_thres_value) {
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                this.param.readSpi_mosi_thres();
                this.param.readSpiMosiThresAttr();
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getSpiMosiThresAttr().getMaxLongValue(), this.param.getSpiMosiThresAttr().getMinLongValue(), this.param.getSpiMosiThresAttr().getDefLongValue(), this.param.getSpi_mosi_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSpiAdapter.4
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeSpiAdapter.this.param.saveSpi_mosi_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_spi_clk_thres_value) {
            this.param.readSpi_clock_thres();
            this.param.readSpiClkThresAttr();
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, this.param.getUnit(), this.param.getSpiClkThresAttr().getMaxLongValue(), this.param.getSpiClkThresAttr().getMinLongValue(), this.param.getSpiClkThresAttr().getDefLongValue(), this.param.getSpi_cs_thres(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSpiAdapter.5
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeSpiAdapter.this.param.saveSpi_clock_thres(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_spi_width_value) {
            if (this.aorBManager.setClick_showab_textview(view.getId())) {
                ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_number, this.param.getSpiWidthAttr().getMaxIntValue(), this.param.getSpiWidthAttr().getMinIntValue(), this.param.getSpiWidthAttr().getDefIntValue(), this.param.getSpi_width(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSpiAdapter.6
                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public <T> void resultMinUnitValueListener(T t) {
                        DecodeSpiAdapter.this.param.saveSpi_width(((Long) t).longValue());
                    }

                    @Override // com.rigol.scope.views.keyboard.KeyboardListener
                    public void onCall(KeyboardPopupView keyboardPopupView) {
                        DecodeSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                    }
                });
            }
        } else if (id == R.id.decode_spi_tmo_value && this.aorBManager.setClick_showab_textview(view.getId())) {
            this.param.readSpiTimeoutAttr();
            ViewUtil.showKeyboard(this.anchorView, view, ServiceEnum.Unit.Unit_s, this.param.getSpiTimeoutAttr().getMaxLongValue(), this.param.getSpiTimeoutAttr().getMinLongValue(), this.param.getSpiTimeoutAttr().getDefLongValue(), this.param.getSpi_timeout(), new KeyboardListener() { // from class: com.rigol.scope.adapters.DecodeSpiAdapter.7
                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public <T> void resultMinUnitValueListener(T t) {
                    DecodeSpiAdapter.this.param.saveSpi_timeout(((Long) t).longValue());
                }

                @Override // com.rigol.scope.views.keyboard.KeyboardListener
                public void onCall(KeyboardPopupView keyboardPopupView) {
                    DecodeSpiAdapter.this.keyboardPopupView = keyboardPopupView;
                }
            });
        }
    }

    public /* synthetic */ void lambda$onClick$3$DecodeSpiAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$4$DecodeSpiAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectClkValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$5$DecodeSpiAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$6$DecodeSpiAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectMisoValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$7$DecodeSpiAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$8$DecodeSpiAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectMosiValue(mappingObject);
    }

    public /* synthetic */ void lambda$onClick$9$DecodeSpiAdapter(PopupSpinner popupSpinner, SpinnerAdapter spinnerAdapter, List list, View view) {
        this.popupSpinner = popupSpinner;
        this.spinnerAdapter = spinnerAdapter;
        this.mappingObjects = list;
        this.clickedView = view;
    }

    public /* synthetic */ void lambda$onClick$10$DecodeSpiAdapter(View view, RecyclerView.ViewHolder viewHolder, int i, MappingObject mappingObject) {
        selectCSValue(mappingObject);
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (radioGroup.findViewById(i).isPressed()) {
            if (i == R.id.decode_spi_mode_cs_radioButton) {
                this.aorBManager.set_RadioButton();
                this.param.saveSpi_mode(0);
            } else if (i == R.id.decode_spi_mode_timeout_radioButton) {
                this.aorBManager.set_RadioButton();
                this.param.saveSpi_mode(1);
            } else if (i == R.id.decode_spi_clk_edge_down_radioButton) {
                this.param.saveSpi_clock_edge(1);
            } else if (i == R.id.decode_spi_clk_edge_up_radioButton) {
                this.param.saveSpi_clock_edge(0);
            } else if (i == R.id.decode_spi_cs_pol_negative_radioButton) {
                this.param.saveSpi_cs_polarity(0);
            } else if (i == R.id.decode_spi_cs_pol_positive_radioButton) {
                this.param.saveSpi_cs_polarity(1);
            } else if (i == R.id.decode_spi_endian_LSB_radioButton) {
                this.param.saveSpi_endian(false);
            } else if (i == R.id.decode_spi_endian_MSB_radioButton) {
                this.param.saveSpi_endian(true);
            } else if (i == R.id.decode_spi_polarity_negative_radioButton) {
                this.param.saveSpi_data_polarity(0);
            } else if (i == R.id.decode_spi_polarity_positive_radioButton) {
                this.param.saveSpi_data_polarity(1);
            }
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnSetTextById
    public void onViewIdCallback(KeyEvent keyEvent, int i, boolean z) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        switch (i) {
            case R.id.decode_spi_clk_thres_value /* 2131362598 */:
                if (this.param.getSpi_clock() < 8) {
                    this.param.readSpi_clock_thres();
                    this.param.readSpiClkThresAttr();
                    DecodeParam decodeParam = this.param;
                    decodeParam.saveSpi_clock_thres(decodeParam.getLongStep(decodeParam.getSpi_clock_thres(), this.param.getSpiClkThresAttr(), z, keyEvent));
                    return;
                }
                return;
            case R.id.decode_spi_cs_thres_value /* 2131362606 */:
                this.param.readSpi_cs_thres();
                this.param.readSpiCsThresAttr();
                DecodeParam decodeParam2 = this.param;
                decodeParam2.saveSpi_cs_thres(decodeParam2.getLongStep(decodeParam2.getSpi_cs_thres(), this.param.getSpiCsThresAttr(), z, keyEvent));
                return;
            case R.id.decode_spi_miso_thres_value /* 2131362615 */:
                if (this.param.getSpi_miso() < 8) {
                    this.param.readSpi_miso_thres();
                    this.param.readSpiMisoThresAttr();
                    DecodeParam decodeParam3 = this.param;
                    decodeParam3.saveSpi_miso_thres(decodeParam3.getLongStep(decodeParam3.getSpi_miso_thres(), this.param.getSpiMisoThresAttr(), z, keyEvent));
                    return;
                }
                return;
            case R.id.decode_spi_mosi_thres_value /* 2131362623 */:
                if (this.param.getSpi_mosi() < 8) {
                    this.param.readSpi_mosi_thres();
                    this.param.readSpiMosiThresAttr();
                    DecodeParam decodeParam4 = this.param;
                    decodeParam4.saveSpi_mosi_thres(decodeParam4.getLongStep(decodeParam4.getSpi_mosi_thres(), this.param.getSpiMosiThresAttr(), z, keyEvent));
                    return;
                }
                return;
            case R.id.decode_spi_tmo_value /* 2131362630 */:
                this.param.readSpiTimeoutAttr();
                DecodeParam decodeParam5 = this.param;
                decodeParam5.saveSpi_timeout(decodeParam5.getLongStep(decodeParam5.getSpi_timeout(), this.param.getSpiTimeoutAttr(), z, keyEvent));
                return;
            case R.id.decode_spi_width_value /* 2131362632 */:
                DecodeParam decodeParam6 = this.param;
                decodeParam6.saveSpi_width(decodeParam6.getLongStep(decodeParam6.getSpi_width(), this.param.getSpiWidthAttr(), z, keyEvent));
                return;
            default:
                return;
        }
    }

    @Override // com.rigol.scope.utilities.AorBManager.OnTextReset
    public void onResetDefault(int i) {
        if (this.param == null || !getIsMove()) {
            return;
        }
        switch (i) {
            case R.id.decode_spi_clk_thres_value /* 2131362598 */:
                this.param.readSpi_clock_thres();
                this.param.readSpiClkThresAttr();
                DecodeParam decodeParam = this.param;
                decodeParam.saveSpi_clock_thres(decodeParam.getLongDef(decodeParam.getSpiClkThresAttr()));
                return;
            case R.id.decode_spi_cs_thres_value /* 2131362606 */:
                this.param.readSpi_cs_thres();
                this.param.readSpiCsThresAttr();
                DecodeParam decodeParam2 = this.param;
                decodeParam2.saveSpi_cs_thres(decodeParam2.getLongDef(decodeParam2.getSpiCsThresAttr()));
                return;
            case R.id.decode_spi_miso_thres_value /* 2131362615 */:
                this.param.readSpi_miso_thres();
                this.param.readSpiMisoThresAttr();
                DecodeParam decodeParam3 = this.param;
                decodeParam3.saveSpi_miso_thres(decodeParam3.getLongDef(decodeParam3.getSpiMisoThresAttr()));
                return;
            case R.id.decode_spi_mosi_thres_value /* 2131362623 */:
                this.param.readSpi_mosi_thres();
                this.param.readSpiMosiThresAttr();
                DecodeParam decodeParam4 = this.param;
                decodeParam4.saveSpi_mosi_thres(decodeParam4.getLongDef(decodeParam4.getSpiMosiThresAttr()));
                return;
            case R.id.decode_spi_tmo_value /* 2131362630 */:
                DecodeParam decodeParam5 = this.param;
                decodeParam5.saveSpi_timeout(decodeParam5.getLongDef(decodeParam5.getSpiTimeoutAttr()));
                return;
            case R.id.decode_spi_width_value /* 2131362632 */:
                DecodeParam decodeParam6 = this.param;
                decodeParam6.saveSpi_width(decodeParam6.getLongDef(decodeParam6.getSpiWidthAttr()));
                return;
            default:
                return;
        }
    }

    /* loaded from: classes.dex */
    public static class DecodeSpiHolder extends RecyclerView.ViewHolder {
        public DecodeSpiHolder(AdapterDecodeSpiBinding adapterDecodeSpiBinding) {
            super(adapterDecodeSpiBinding.getRoot());
        }
    }

    public void setIsMove(boolean z) {
        this.isMove = z;
    }

    private boolean getIsMove() {
        return this.isMove;
    }
}
