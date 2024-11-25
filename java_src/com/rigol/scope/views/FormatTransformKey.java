package com.rigol.scope.views;

import android.content.Context;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import com.rigol.scope.R;
import com.rigol.scope.cil.MessageID;
import com.rigol.scope.cil.ServiceEnum;
import com.rigol.scope.data.TriggerParam;
import com.rigol.scope.databinding.FormatTransformKeyBinding;
import com.rigol.scope.utilities.ViewUtil;
import com.rigol.scope.views.baseview.BasePopupView;
/* loaded from: classes2.dex */
public class FormatTransformKey extends BasePopupView implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private View anchorView;
    private int binLengthMax;
    final int binary;
    private FormatTransformKeyBinding binding;
    private Context context;
    private int format;
    private int formatIndex;
    private int formatIndexMax;
    private FormatTransformInterface formatTransformInterface;
    final int hex;
    private int hexLengthMax;
    private int indexMax;
    private TriggerParam param;
    private String strKey;

    /* loaded from: classes2.dex */
    public interface FormatTransformInterface {
        void FormatTransformListener(String str);
    }

    public FormatTransformKey(Context context, View view, TriggerParam triggerParam) {
        super(context, (int) R.style.App_PopupWindow_FormatTransform);
        this.binary = 0;
        this.hex = 1;
        this.binLengthMax = 0;
        this.hexLengthMax = 0;
        this.formatIndex = 0;
        this.formatIndexMax = 0;
        this.strKey = "0";
        this.format = 0;
        this.indexMax = 8;
        this.param = triggerParam;
        this.anchorView = view;
        this.context = context;
        FormatTransformKeyBinding inflate = FormatTransformKeyBinding.inflate(LayoutInflater.from(context));
        this.binding = inflate;
        setContentView(inflate.getRoot());
        int keyNumMax = triggerParam.getKeyNumMax();
        int i = keyNumMax / 8;
        int i2 = keyNumMax % 8;
        this.binLengthMax = keyNumMax + i + (i2 == 0 ? -1 : 0);
        this.hexLengthMax = (keyNumMax / 4) + (keyNumMax % 4 == 0 ? 0 : 1) + i + (i2 != 0 ? 0 : -1);
        this.binding.setBinMapping(ViewUtil.getMappingObject(R.array.msg_format, 0));
        this.binding.setHexMapping(ViewUtil.getMappingObject(R.array.msg_format, 1));
        this.binding.binaryValue.setText("X-------");
        if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            if (triggerParam.getFormatValue1Str().contains("[bin]")) {
                triggerParam.setFormat(0);
            } else {
                triggerParam.setFormat(1);
            }
        } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            if (triggerParam.getFormatValue2Str().contains("[bin]")) {
                triggerParam.setFormat(0);
            } else {
                triggerParam.setFormat(1);
            }
        } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (triggerParam.getCanDataIdType() == 0) {
                if (triggerParam.getFormatValue3DataStr().contains("[bin]")) {
                    triggerParam.setFormat(0);
                } else {
                    triggerParam.setFormat(1);
                }
            } else if (triggerParam.getFormatValue3IdStr().contains("[bin]")) {
                triggerParam.setFormat(0);
            } else {
                triggerParam.setFormat(1);
            }
        } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            if (triggerParam.getFormatValue4Str().contains("[bin]")) {
                triggerParam.setFormat(0);
            } else {
                triggerParam.setFormat(1);
            }
        } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            if (triggerParam.getI2sDataType() == 0) {
                if (triggerParam.getFormatValue5Str().contains("[bin]")) {
                    triggerParam.setFormat(0);
                } else {
                    triggerParam.setFormat(1);
                }
            } else if (triggerParam.getI2sDataType() == 1) {
                if (triggerParam.getFormatValue5MinStr().contains("[bin]")) {
                    triggerParam.setFormat(0);
                } else {
                    triggerParam.setFormat(1);
                }
            } else if (triggerParam.getI2sDataType() == 2) {
                if (triggerParam.getFormatValue5MaxStr().contains("[bin]")) {
                    triggerParam.setFormat(0);
                } else {
                    triggerParam.setFormat(1);
                }
            }
        } else if (triggerParam.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            if (triggerParam.getMilstdDataType() == 0) {
                if (triggerParam.getFormatValue6MaxStr().contains("[bin]")) {
                    triggerParam.setFormat(0);
                } else {
                    triggerParam.setFormat(1);
                }
            } else if (triggerParam.getMilstdDataType() == 1) {
                if (triggerParam.getFormatValue6Str().contains("[bin]")) {
                    triggerParam.setFormat(0);
                } else {
                    triggerParam.setFormat(1);
                }
            } else if (triggerParam.getMilstdDataType() == 2) {
                if (triggerParam.getFormatValue6RtaStr().contains("[bin]")) {
                    triggerParam.setFormat(0);
                } else {
                    triggerParam.setFormat(1);
                }
            } else if (triggerParam.getMilstdDataType() == 3) {
                if (triggerParam.getFormatValue6BitStr().contains("[bin]")) {
                    triggerParam.setFormat(0);
                } else {
                    triggerParam.setFormat(1);
                }
            }
        }
        int format = triggerParam.getFormat();
        this.binding.formatBin.setChecked(format == 0);
        this.binding.formatHex.setChecked(format == 1);
        if (format == 0) {
            this.binding.typeFormat.setText(this.binding.getBinMapping().getStr());
            this.binding.typeFormatValue.setText("X-------");
            this.binding.keyA.setEnabled(false);
            this.binding.keyB.setEnabled(false);
            this.binding.keyC.setEnabled(false);
            this.binding.keyB.setEnabled(false);
            this.binding.keyD.setEnabled(false);
            this.binding.keyE.setEnabled(false);
            this.binding.keyF.setEnabled(false);
            this.binding.keyTwo.setEnabled(false);
            this.binding.keyThree.setEnabled(false);
            this.binding.keyFour.setEnabled(false);
            this.binding.keyFive.setEnabled(false);
            this.binding.keySix.setEnabled(false);
            this.binding.keySeven.setEnabled(false);
            this.binding.keyEigth.setEnabled(false);
            this.binding.keyNine.setEnabled(false);
        } else {
            this.binding.typeFormat.setText(this.binding.getHexMapping().getStr());
            this.binding.typeFormatValue.setText("X-");
            this.binding.keyA.setEnabled(true);
            this.binding.keyB.setEnabled(true);
            this.binding.keyC.setEnabled(true);
            this.binding.keyB.setEnabled(true);
            this.binding.keyD.setEnabled(true);
            this.binding.keyE.setEnabled(true);
            this.binding.keyF.setEnabled(true);
            this.binding.keyTwo.setEnabled(true);
            this.binding.keyThree.setEnabled(true);
            this.binding.keyFour.setEnabled(true);
            this.binding.keyFive.setEnabled(true);
            this.binding.keySix.setEnabled(true);
            this.binding.keySeven.setEnabled(true);
            this.binding.keyEigth.setEnabled(true);
            this.binding.keyNine.setEnabled(true);
        }
        this.binding.setParam(triggerParam);
        this.binding.formatBin.setOnCheckedChangeListener(this);
        this.binding.formatHex.setOnCheckedChangeListener(this);
        this.binding.keyA.setOnClickListener(this);
        this.binding.keyB.setOnClickListener(this);
        this.binding.keyC.setOnClickListener(this);
        this.binding.keyD.setOnClickListener(this);
        this.binding.keyE.setOnClickListener(this);
        this.binding.keyF.setOnClickListener(this);
        this.binding.keyZero.setOnClickListener(this);
        this.binding.keyOne.setOnClickListener(this);
        this.binding.keyTwo.setOnClickListener(this);
        this.binding.keyThree.setOnClickListener(this);
        this.binding.keyFour.setOnClickListener(this);
        this.binding.keyFive.setOnClickListener(this);
        this.binding.keySix.setOnClickListener(this);
        this.binding.keySeven.setOnClickListener(this);
        this.binding.keyEigth.setOnClickListener(this);
        this.binding.keyNine.setOnClickListener(this);
        this.binding.keyX.setOnClickListener(this);
        this.binding.keyAll.setOnClickListener(this);
        this.binding.keyDelete.setOnClickListener(this);
        this.binding.keyClear.setOnClickListener(this);
        this.binding.keyLeft.setOnClickListener(this);
        this.binding.keyRight.setOnClickListener(this);
        this.binding.keyOk.setOnClickListener(this);
        this.binding.typeFormatValue.setOnClickListener(this);
    }

    public void init() {
        int keyNumMax = this.param.getKeyNumMax();
        int i = keyNumMax / 8;
        int i2 = -1;
        this.binLengthMax = keyNumMax + i + ((keyNumMax < 8 || keyNumMax % 8 != 0) ? 0 : -1);
        int i3 = (keyNumMax / 4) + (keyNumMax % 4 == 0 ? 0 : 1) + i;
        if (keyNumMax < 8 || keyNumMax % 8 != 0) {
            i2 = 0;
        }
        this.hexLengthMax = i3 + i2;
        this.binding.binaryValue.setText(this.param.getTriggerBinaryData());
        if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            if (this.param.getFormatValue1Str().contains("[bin]")) {
                this.param.setFormat(0);
            } else {
                this.param.setFormat(1);
            }
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            if (this.param.getFormatValue2Str().contains("[bin]")) {
                this.param.setFormat(0);
            } else {
                this.param.setFormat(1);
            }
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (this.param.getCanDataIdType() == 0) {
                if (this.param.getFormatValue3DataStr().contains("[bin]")) {
                    this.param.setFormat(0);
                } else {
                    this.param.setFormat(1);
                }
            } else if (this.param.getFormatValue3IdStr().contains("[bin]")) {
                this.param.setFormat(0);
            } else {
                this.param.setFormat(1);
            }
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            if (this.param.getFormatValue4Str().contains("[bin]")) {
                this.param.setFormat(0);
            } else {
                this.param.setFormat(1);
            }
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            if (this.param.getI2sDataType() == 0) {
                if (this.param.getFormatValue5Str().contains("[bin]")) {
                    this.param.setFormat(0);
                } else {
                    this.param.setFormat(1);
                }
            } else if (this.param.getI2sDataType() == 1) {
                if (this.param.getFormatValue5MinStr().contains("[bin]")) {
                    this.param.setFormat(0);
                } else {
                    this.param.setFormat(1);
                }
            } else if (this.param.getI2sDataType() == 2) {
                if (this.param.getFormatValue5MaxStr().contains("[bin]")) {
                    this.param.setFormat(0);
                } else {
                    this.param.setFormat(1);
                }
            }
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            if (this.param.getMilstdDataType() == 0) {
                if (this.param.getFormatValue6MaxStr().contains("[bin]")) {
                    this.param.setFormat(0);
                } else {
                    this.param.setFormat(1);
                }
            } else if (this.param.getMilstdDataType() == 1) {
                if (this.param.getFormatValue6Str().contains("[bin]")) {
                    this.param.setFormat(0);
                } else {
                    this.param.setFormat(1);
                }
            } else if (this.param.getMilstdDataType() == 2) {
                if (this.param.getFormatValue6RtaStr().contains("[bin]")) {
                    this.param.setFormat(0);
                } else {
                    this.param.setFormat(1);
                }
            } else if (this.param.getMilstdDataType() == 3) {
                if (this.param.getFormatValue6BitStr().contains("[bin]")) {
                    this.param.setFormat(0);
                } else {
                    this.param.setFormat(1);
                }
            }
        }
        int format = this.param.getFormat();
        this.binding.formatBin.setChecked(format == 0);
        this.binding.formatHex.setChecked(format == 1);
        if (format == 0) {
            this.binding.typeFormat.setText(this.binding.getBinMapping().getStr());
            this.binding.typeFormatValue.setText(this.param.getTriggerBinaryData());
            this.binding.keyA.setEnabled(false);
            this.binding.keyB.setEnabled(false);
            this.binding.keyC.setEnabled(false);
            this.binding.keyB.setEnabled(false);
            this.binding.keyD.setEnabled(false);
            this.binding.keyE.setEnabled(false);
            this.binding.keyF.setEnabled(false);
            this.binding.keyTwo.setEnabled(false);
            this.binding.keyThree.setEnabled(false);
            this.binding.keyFour.setEnabled(false);
            this.binding.keyFive.setEnabled(false);
            this.binding.keySix.setEnabled(false);
            this.binding.keySeven.setEnabled(false);
            this.binding.keyEigth.setEnabled(false);
            this.binding.keyNine.setEnabled(false);
        } else {
            this.binding.typeFormat.setText(this.binding.getHexMapping().getStr());
            this.binding.typeFormatValue.setText(this.param.getDataHex());
            this.binding.keyA.setEnabled(this.param.isShow() == 0);
            this.binding.keyB.setEnabled(this.param.isShow() == 0);
            this.binding.keyC.setEnabled(this.param.isShow() == 0);
            this.binding.keyD.setEnabled(this.param.isShow() == 0);
            this.binding.keyE.setEnabled(this.param.isShow() == 0);
            this.binding.keyF.setEnabled(this.param.isShow() == 0);
            this.binding.keyTwo.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 2);
            this.binding.keyThree.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 2);
            this.binding.keyFour.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 3);
            this.binding.keyFive.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 3);
            this.binding.keySix.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 3);
            this.binding.keySeven.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 3);
            this.binding.keyEigth.setEnabled(this.param.isShow() == 0);
            this.binding.keyNine.setEnabled(this.param.isShow() == 0);
        }
        try {
            this.binding.typeFormatValue.setSelection(0, 1);
            this.binding.typeFormatValue.requestFocus();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.formatIndex = 0;
        if (format == 0) {
            if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                this.param.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, 0);
            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, 0);
            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, 0);
            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                this.param.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, 0);
            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                if (this.param.getI2sDataType() == 0) {
                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, 0);
                } else if (this.param.getI2sDataType() == 1) {
                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, 0);
                } else if (this.param.getI2sDataType() == 2) {
                    this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, 0);
                }
            } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                if (this.param.getMilstdDataType() == 0) {
                    this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, 0);
                } else if (this.param.getMilstdDataType() == 1) {
                    this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, 0);
                } else if (this.param.getMilstdDataType() == 2) {
                    this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, 0);
                } else if (this.param.getMilstdDataType() == 3) {
                    this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, 0);
                }
            }
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
            TriggerParam triggerParam = this.param;
            triggerParam.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, triggerParam.getByteLength() * 8);
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
            TriggerParam triggerParam2 = this.param;
            triggerParam2.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, triggerParam2.getDataBits());
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
            if (this.param.getCanDataIdType() == 0) {
                TriggerParam triggerParam3 = this.param;
                triggerParam3.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, triggerParam3.getDataByte() * 8);
            } else {
                TriggerParam triggerParam4 = this.param;
                triggerParam4.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, triggerParam4.getCanIdBits());
            }
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
            TriggerParam triggerParam5 = this.param;
            triggerParam5.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, triggerParam5.getLinByte() * 8);
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
            if (this.param.getI2sDataType() == 0) {
                TriggerParam triggerParam6 = this.param;
                triggerParam6.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, triggerParam6.getWidth());
            } else if (this.param.getI2sDataType() == 1) {
                TriggerParam triggerParam7 = this.param;
                triggerParam7.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, triggerParam7.getWidth());
            } else if (this.param.getI2sDataType() == 2) {
                TriggerParam triggerParam8 = this.param;
                triggerParam8.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, triggerParam8.getWidth());
            }
        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
            if (this.param.getMilstdDataType() == 0) {
                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, 16);
            } else if (this.param.getMilstdDataType() == 1) {
                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, 16);
            } else if (this.param.getMilstdDataType() == 2) {
                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, 5);
            } else if (this.param.getMilstdDataType() == 3) {
                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, 11);
            }
        }
        this.param.setTriggerBinaryData(this.binding.binaryValue.getText().toString());
        this.binding.setParam(this.param);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x02cc, code lost:
        if (r19.formatIndex > (r19.param.getDataBits() % 8)) goto L163;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0304, code lost:
        if (r19.formatIndex > ((r19.param.getDataBits() % 8) + 9)) goto L175;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2078:0x2628, code lost:
        if (r19.formatIndex > (r19.param.getDataBits() % 8)) goto L1641;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2090:0x2664, code lost:
        if (r19.formatIndex > ((r19.param.getDataBits() % 8) + 9)) goto L1653;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2147:0x2760, code lost:
        if (r2 <= 11) goto L1695;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2177:0x2845, code lost:
        if (r19.formatIndex > (r19.param.getWidth() % 8)) goto L1739;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2189:0x2881, code lost:
        if (r19.formatIndex > ((r19.param.getWidth() % 8) + 9)) goto L1759;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x03cb, code lost:
        if (r2 <= 11) goto L213;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2404:0x2c86, code lost:
        if (r19.formatIndex > (r19.param.getDataBits() % 8)) goto L2419;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2416:0x2cc2, code lost:
        if (r19.formatIndex > ((r19.param.getDataBits() % 8) + 9)) goto L2431;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2459:0x2d72, code lost:
        if (r2 <= 11) goto L2456;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2472:0x2dc2, code lost:
        if (r19.formatIndex > (r19.param.getWidth() % 8)) goto L2483;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2484:0x2dfe, code lost:
        if (r19.formatIndex > ((r19.param.getWidth() % 8) + 9)) goto L2503;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0456, code lost:
        if (r19.formatIndex > (r19.param.getWidth() % 8)) goto L249;
     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x048e, code lost:
        if (r19.formatIndex > ((r19.param.getWidth() % 8) + 9)) goto L269;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2743:0x3317, code lost:
        if (r19.formatIndex > (r19.param.getDataBits() % 8)) goto L2745;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2755:0x3353, code lost:
        if (r19.formatIndex > ((r19.param.getDataBits() % 8) + 9)) goto L2757;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2808:0x342a, code lost:
        if (r2 <= 11) goto L2795;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2833:0x34e5, code lost:
        if (r19.formatIndex > (r19.param.getWidth() % 8)) goto L2834;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2845:0x3521, code lost:
        if (r19.formatIndex > ((r19.param.getWidth() % 8) + 9)) goto L2854;
     */
    /* JADX WARN: Code restructure failed: missing block: B:803:0x0d2b, code lost:
        if (r19.formatIndex > (r19.param.getDataBits() % 8)) goto L787;
     */
    /* JADX WARN: Code restructure failed: missing block: B:815:0x0d67, code lost:
        if (r19.formatIndex > ((r19.param.getDataBits() % 8) + 9)) goto L799;
     */
    /* JADX WARN: Code restructure failed: missing block: B:868:0x0e4b, code lost:
        if (r2 <= 11) goto L837;
     */
    /* JADX WARN: Code restructure failed: missing block: B:890:0x0efd, code lost:
        if (r19.formatIndex > (r19.param.getWidth() % 8)) goto L873;
     */
    /* JADX WARN: Code restructure failed: missing block: B:902:0x0f39, code lost:
        if (r19.formatIndex > ((r19.param.getWidth() % 8) + 9)) goto L893;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:1452:0x1bc2  */
    /* JADX WARN: Removed duplicated region for block: B:1554:0x1dd1  */
    /* JADX WARN: Removed duplicated region for block: B:1557:0x1dd8  */
    /* JADX WARN: Removed duplicated region for block: B:1569:0x1df6  */
    /* JADX WARN: Removed duplicated region for block: B:1584:0x1e24  */
    /* JADX WARN: Removed duplicated region for block: B:1603:0x1e65  */
    /* JADX WARN: Removed duplicated region for block: B:1627:0x1ee7  */
    /* JADX WARN: Removed duplicated region for block: B:1633:0x1ef1  */
    /* JADX WARN: Removed duplicated region for block: B:1634:0x1ef6  */
    /* JADX WARN: Removed duplicated region for block: B:1636:0x1efd  */
    /* JADX WARN: Removed duplicated region for block: B:1642:0x1f09  */
    /* JADX WARN: Removed duplicated region for block: B:1644:0x1f10  */
    /* JADX WARN: Removed duplicated region for block: B:1650:0x1f27  */
    /* JADX WARN: Removed duplicated region for block: B:1656:0x1f33  */
    /* JADX WARN: Removed duplicated region for block: B:1657:0x1f38  */
    /* JADX WARN: Removed duplicated region for block: B:1667:0x1f59 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:1672:0x1f63  */
    /* JADX WARN: Removed duplicated region for block: B:1673:0x1f68  */
    /* JADX WARN: Removed duplicated region for block: B:1686:0x1f96  */
    /* JADX WARN: Removed duplicated region for block: B:1692:0x1fa2  */
    /* JADX WARN: Removed duplicated region for block: B:1693:0x1fa7  */
    /* JADX WARN: Removed duplicated region for block: B:1709:0x1fde  */
    /* JADX WARN: Removed duplicated region for block: B:1715:0x1fea  */
    /* JADX WARN: Removed duplicated region for block: B:1716:0x1fef  */
    /* JADX WARN: Removed duplicated region for block: B:1733:0x2031  */
    /* JADX WARN: Removed duplicated region for block: B:1739:0x203d  */
    /* JADX WARN: Removed duplicated region for block: B:1740:0x2042  */
    /* JADX WARN: Removed duplicated region for block: B:2208:0x28d7  */
    /* JADX WARN: Removed duplicated region for block: B:2209:0x28e2  */
    /* JADX WARN: Removed duplicated region for block: B:2503:0x2e54  */
    /* JADX WARN: Removed duplicated region for block: B:2504:0x2e5f  */
    /* JADX WARN: Removed duplicated region for block: B:2864:0x3577  */
    /* JADX WARN: Removed duplicated region for block: B:2865:0x3582  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04e2  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04eb  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0772  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x07b3  */
    /* JADX WARN: Removed duplicated region for block: B:447:0x07da  */
    /* JADX WARN: Removed duplicated region for block: B:448:0x07df  */
    /* JADX WARN: Removed duplicated region for block: B:456:0x07f2  */
    /* JADX WARN: Removed duplicated region for block: B:458:0x07f9  */
    /* JADX WARN: Removed duplicated region for block: B:470:0x081c  */
    /* JADX WARN: Removed duplicated region for block: B:471:0x0821  */
    /* JADX WARN: Removed duplicated region for block: B:486:0x084c  */
    /* JADX WARN: Removed duplicated region for block: B:487:0x0851  */
    /* JADX WARN: Removed duplicated region for block: B:506:0x088b  */
    /* JADX WARN: Removed duplicated region for block: B:507:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:529:0x08d3  */
    /* JADX WARN: Removed duplicated region for block: B:530:0x08d8  */
    /* JADX WARN: Removed duplicated region for block: B:553:0x0926  */
    /* JADX WARN: Removed duplicated region for block: B:554:0x092b  */
    /* JADX WARN: Removed duplicated region for block: B:921:0x0f8f  */
    /* JADX WARN: Removed duplicated region for block: B:922:0x0f9a  */
    @Override // android.view.View.OnClickListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onClick(android.view.View r20) {
        /*
            Method dump skipped, instructions count: 14186
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rigol.scope.views.FormatTransformKey.onClick(android.view.View):void");
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (compoundButton.isPressed()) {
            switch (compoundButton.getId()) {
                case R.id.format_bin /* 2131362968 */:
                    TriggerParam triggerParam = this.param;
                    if (triggerParam != null) {
                        int format = triggerParam.getFormat();
                        Editable text = this.binding.binaryValue.getText();
                        int i = 0;
                        while (true) {
                            if (i < text.length()) {
                                if (text.charAt(i) == '-') {
                                    this.indexMax = i;
                                } else {
                                    i++;
                                }
                            }
                        }
                        if (i == text.length()) {
                            this.indexMax = i;
                        }
                        if (format == 1) {
                            this.binding.typeFormatValue.setText(text.toString());
                        }
                        this.binding.typeFormat.setText(this.binding.getBinMapping().getStr());
                        this.binding.formatBin.setChecked(true);
                        this.binding.formatHex.setChecked(false);
                        this.binding.keyA.setEnabled(false);
                        this.binding.keyB.setEnabled(false);
                        this.binding.keyC.setEnabled(false);
                        this.binding.keyD.setEnabled(false);
                        this.binding.keyE.setEnabled(false);
                        this.binding.keyF.setEnabled(false);
                        this.binding.keyTwo.setEnabled(false);
                        this.binding.keyThree.setEnabled(false);
                        this.binding.keyFour.setEnabled(false);
                        this.binding.keyFive.setEnabled(false);
                        this.binding.keySix.setEnabled(false);
                        this.binding.keySeven.setEnabled(false);
                        this.binding.keyEigth.setEnabled(false);
                        this.binding.keyNine.setEnabled(false);
                        this.param.setFormat(0);
                        this.formatTransformInterface.FormatTransformListener("[bin]" + this.binding.typeFormatValue.getText().toString().replace("-", "X"));
                        this.binding.typeFormatValue.setSelection(0, 1);
                        this.binding.typeFormatValue.requestFocus();
                        this.formatIndex = 0;
                        if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, 0);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, 0);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, 0);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                            this.param.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, 0);
                            break;
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                            if (this.param.getI2sDataType() == 0) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, 0);
                                break;
                            } else if (this.param.getI2sDataType() == 1) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, 0);
                                break;
                            } else if (this.param.getI2sDataType() == 2) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, 0);
                                break;
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                            if (this.param.getMilstdDataType() == 0) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, 0);
                                break;
                            } else if (this.param.getMilstdDataType() == 1) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, 0);
                                break;
                            } else if (this.param.getMilstdDataType() == 2) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, 0);
                                break;
                            } else if (this.param.getMilstdDataType() == 3) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, 0);
                                break;
                            }
                        }
                    }
                    break;
                case R.id.format_hex /* 2131362969 */:
                    TriggerParam triggerParam2 = this.param;
                    if (triggerParam2 != null) {
                        int format2 = triggerParam2.getFormat();
                        Editable text2 = this.binding.typeFormatValue.getText();
                        if (format2 == 0) {
                            String binaryTransformtoHex = this.param.binaryTransformtoHex(text2.toString());
                            if (binaryTransformtoHex.charAt(binaryTransformtoHex.length() - 1) == '-') {
                                this.indexMax = binaryTransformtoHex.length() - 1;
                            } else {
                                this.indexMax = binaryTransformtoHex.length();
                            }
                            this.binding.typeFormatValue.setText(binaryTransformtoHex);
                        }
                        this.formatTransformInterface.FormatTransformListener("[hex]" + this.binding.typeFormatValue.getText().toString().replace("-", "X"));
                        this.binding.typeFormatValue.setSelection(0, 1);
                        this.binding.typeFormatValue.requestFocus();
                        this.formatIndex = 0;
                        if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2C) {
                            TriggerParam triggerParam3 = this.param;
                            triggerParam3.postWay(41, MessageID.MSG_TRIGGER_I2C_CURRBIT, triggerParam3.getByteLength() * 8);
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_SPI) {
                            TriggerParam triggerParam4 = this.param;
                            triggerParam4.postWay(41, MessageID.MSG_TRIGGER_SPI_CURRBIT, triggerParam4.getDataBits());
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_CAN) {
                            if (this.param.getCanDataIdType() == 0) {
                                TriggerParam triggerParam5 = this.param;
                                triggerParam5.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, triggerParam5.getDataByte() * 8);
                            } else {
                                TriggerParam triggerParam6 = this.param;
                                triggerParam6.postWay(41, MessageID.MSG_TRIGGER_CAN_CURR_BIT, triggerParam6.getCanIdBits());
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_LIN) {
                            TriggerParam triggerParam7 = this.param;
                            triggerParam7.postWay(41, MessageID.MSG_TRIGGER_LIN_CURRBIT, triggerParam7.getLinByte() * 8);
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_I2S) {
                            if (this.param.getI2sDataType() == 0) {
                                TriggerParam triggerParam8 = this.param;
                                triggerParam8.postWay(41, MessageID.MSG_TRIGGER_IIS_CURR_BIT, triggerParam8.getWidth());
                            } else if (this.param.getI2sDataType() == 1) {
                                TriggerParam triggerParam9 = this.param;
                                triggerParam9.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MIN, triggerParam9.getWidth());
                            } else if (this.param.getI2sDataType() == 2) {
                                TriggerParam triggerParam10 = this.param;
                                triggerParam10.postWay(41, MessageID.MSG_TRIGGER_IIS_DATA_MAX, triggerParam10.getWidth());
                            }
                        } else if (this.param.getTriggerMode() == ServiceEnum.TriggerMode.Trigger_1553) {
                            if (this.param.getMilstdDataType() == 0) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MAX, 16);
                            } else if (this.param.getMilstdDataType() == 1) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_DATA_MIN, 16);
                            } else if (this.param.getMilstdDataType() == 2) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA, 5);
                            } else if (this.param.getMilstdDataType() == 3) {
                                this.param.postWay(41, MessageID.MSG_TRIGGER_1553B_RTA_11, 11);
                            }
                        }
                        this.binding.typeFormat.setText(this.binding.getHexMapping().getStr());
                        this.binding.formatBin.setChecked(false);
                        this.binding.formatHex.setChecked(true);
                        this.binding.keyA.setEnabled(this.param.isShow() == 0);
                        this.binding.keyB.setEnabled(this.param.isShow() == 0);
                        this.binding.keyC.setEnabled(this.param.isShow() == 0);
                        this.binding.keyD.setEnabled(this.param.isShow() == 0);
                        this.binding.keyE.setEnabled(this.param.isShow() == 0);
                        this.binding.keyF.setEnabled(this.param.isShow() == 0);
                        this.binding.keyTwo.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 2);
                        this.binding.keyThree.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 2);
                        this.binding.keyFour.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 3);
                        this.binding.keyFive.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 3);
                        this.binding.keySix.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 3);
                        this.binding.keySeven.setEnabled(this.param.isShow() == 0 || this.param.isShow() >= 3);
                        this.binding.keyEigth.setEnabled(this.param.isShow() == 0);
                        this.binding.keyNine.setEnabled(this.param.isShow() == 0);
                        this.param.setFormat(z ? 1 : 0);
                        break;
                    }
                    break;
            }
            this.param.setTriggerBinaryData(this.binding.binaryValue.getText().toString());
        }
    }

    public void getFormatTransformValue(FormatTransformInterface formatTransformInterface) {
        this.formatTransformInterface = formatTransformInterface;
    }

    @Override // com.rigol.scope.views.baseview.BasePopupView, android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        super.onDismiss();
        if (this.refView != null) {
            this.refView.removeOnAttachStateChangeListener(this.onAttachStateChangeListener);
        }
    }
}
